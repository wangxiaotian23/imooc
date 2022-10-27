package com.course.imooc.server.service;

import com.course.imooc.server.domain.*;
import com.course.imooc.server.dto.PageDto;
import com.course.imooc.server.dto.RoleDto;
import com.course.imooc.server.mapper.RoleMapper;
import com.course.imooc.server.mapper.RoleResourceMapper;
import com.course.imooc.server.mapper.RoleUserMapper;
import com.course.imooc.server.util.CopyUtil;
import com.course.imooc.server.util.UuidUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 李清依
 * @Date: 2022/10/7 14:44
 * @Description:
 */
@Service
public class RoleService {
    @Resource
    private RoleMapper roleMapper;

    @Resource
    private RoleResourceMapper roleResourceMapper;

    @Resource
    private RoleUserMapper roleUserMapper;

    /**
     * 列表查询
     */
    public void list(PageDto pageDto) {
        PageHelper.startPage(pageDto.getPage(), pageDto.getSize());
        RoleExample roleExample = new RoleExample();
        List<Role> roleList = roleMapper.selectByExample(roleExample);
        PageInfo<Role> pageInfo = new PageInfo<>(roleList);
        pageDto.setTotal(pageInfo.getTotal());
        List<RoleDto> roleDtoList = CopyUtil.copyList(roleList, RoleDto.class);
        pageDto.setList(roleDtoList);
    }

    /**
     * 保存，id有值时更新，无值时新增
     */
    public void save(RoleDto roleDto) {
        Role role = CopyUtil.copy(roleDto, Role.class);
        if (StringUtils.isEmpty(roleDto.getId())) {
            this.insert(role);
        } else {
            this.update(role);
        }
    }

    /**
     * 新增
     */
    private void insert(Role role) {
        role.setId(UuidUtil.getShortUuid());
        roleMapper.insert(role);
    }

    /**
     * 更新
     */
    private void update(Role role) {
        roleMapper.updateByPrimaryKey(role);
    }

    /**
     * 删除
     */
    public void delete(String id) {
        roleMapper.deleteByPrimaryKey(id);
    }


    /**
     * 按角色保存资源
     *
     * @param roleDto
     */
    @Transactional
    public void saveResource(RoleDto roleDto) {
        String roleDtoId = roleDto.getId();
        List<String> resourceIds = roleDto.getResourceIds();
        // 清空库中所有的当前角色下的记录
        RoleResourceExample roleResourceExample = new RoleResourceExample();
        roleResourceExample.createCriteria().andRoleIdEqualTo(roleDtoId);
        roleResourceMapper.deleteByExample(roleResourceExample);

        //保存角色资源
        for (int i = 0; i < resourceIds.size(); i++) {
            RoleResource roleResource = new RoleResource();
            roleResource.setId(UuidUtil.getShortUuid());
            roleResource.setRoleId(roleDtoId);
            roleResource.setResourceId(resourceIds.get(i));
            roleResourceMapper.insert(roleResource);
        }
    }

    /**
     * 按角色加载资源
     *
     * @param roleId
     */
    public List<String> listResource(String roleId) {
        RoleResourceExample example = new RoleResourceExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        List<RoleResource> roleResourceList = roleResourceMapper.selectByExample(example);
        List<String> resourceIdList = new ArrayList<>();
        for (int i = 0; i < roleResourceList.size(); i++) {
            resourceIdList.add(roleResourceList.get(i).getResourceId());
        }
        return resourceIdList;
    }

    /**
     * 按角色保存用户
     */
    @Transactional
    public void saveUser(RoleDto roleDto) {
        String roleId = roleDto.getId();
        List<String> userIds = roleDto.getUserIds();

        // 清空库中所有的当前角色下的记录
        RoleUserExample roleUserExample = new RoleUserExample();
        roleUserExample.createCriteria().andRoleIdEqualTo(roleId);
        roleUserMapper.deleteByExample(roleUserExample);

        //保存角色用户
        for (int i = 0; i < userIds.size(); i++) {
            RoleUser roleUser = new RoleUser();
            roleUser.setId(UuidUtil.getShortUuid());
            roleUser.setRoleId(roleId);
            roleUser.setUserId(userIds.get(i));
            roleUserMapper.insert(roleUser);
        }
    }

    /**
     * 按角色加载用户
     *
     * @param roleId
     */
    public List<String> listUser(String roleId) {
        RoleUserExample example = new RoleUserExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        List<RoleUser> roleUserList = roleUserMapper.selectByExample(example);
        List<String> userIdList = new ArrayList<>();
        for (int i = 0; i < roleUserList.size(); i++) {
            userIdList.add(roleUserList.get(i).getUserId());
        }
        return userIdList;
    }


}

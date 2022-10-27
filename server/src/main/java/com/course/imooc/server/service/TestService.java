package com.course.imooc.server.service;


import com.course.imooc.server.domain.Test;
import com.course.imooc.server.domain.TestExample;
import com.course.imooc.server.dto.PageDto;
import com.course.imooc.server.mapper.TestMapper;
import com.course.imooc.server.util.CopyUtil;
import com.course.imooc.server.util.UuidUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestService {

    @Resource
    private TestMapper testMapper;

    /**
     * 列表查询
     */
    public void list(PageDto pageDto) {
        PageHelper.startPage(pageDto.getPage(), pageDto.getSize());
        TestExample testExample = new TestExample();
        List<Test> testList = testMapper.selectByExample(testExample);
        PageInfo<Test> pageInfo = new PageInfo<>(testList);
        pageDto.setTotal(pageInfo.getTotal());
        List<com.course.server.dto.TestDto> testDtoList = CopyUtil.copyList(testList, com.course.server.dto.TestDto.class);
        pageDto.setList(testDtoList);
    }

    /**
     * 保存，id有值时更新，无值时新增
     */
    public void save(com.course.server.dto.TestDto testDto) {
        Test test = CopyUtil.copy(testDto, Test.class);
        if (StringUtils.isEmpty(testDto.getId())) {
            this.insert(test);
        } else {
            this.update(test);
        }
    }

    /**
     * 新增
     */
    private void insert(Test test) {
        test.setId(UuidUtil.getShortUuid());
        testMapper.insert(test);
    }

    /**
     * 更新
     */
    private void update(Test test) {
        testMapper.updateByPrimaryKey(test);
    }

    /**
     * 删除
     */
    public void delete(String id) {
        testMapper.deleteByPrimaryKey(id);
    }
}

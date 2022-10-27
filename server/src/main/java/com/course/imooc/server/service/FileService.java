package com.course.imooc.server.service;

import com.course.imooc.server.domain.File;
import com.course.imooc.server.domain.FileExample;
import com.course.imooc.server.dto.FileDto;
import com.course.imooc.server.dto.PageDto;
import com.course.imooc.server.mapper.FileMapper;
import com.course.imooc.server.util.CopyUtil;
import com.course.imooc.server.util.UuidUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Auther: 李清依
 * @Date: 2022/9/19 19:56
 * @Description:
 */
@Service
public class FileService {
    @Resource
    private FileMapper fileMapper;

    /**
     * 列表查询
     */
    public void list(PageDto pageDto) {
        PageHelper.startPage(pageDto.getPage(), pageDto.getSize());
        FileExample fileExample = new FileExample();
        List<File> fileList = fileMapper.selectByExample(fileExample);
        PageInfo<File> pageInfo = new PageInfo<>(fileList);
        pageDto.setTotal(pageInfo.getTotal());
        List<FileDto> fileDtoList = CopyUtil.copyList(fileList, FileDto.class);
        pageDto.setList(fileDtoList);
    }


    /**
     * 保存，id有值时更新，无值时新增
     */
    public void save(FileDto fileDto) {
        File file = CopyUtil.copy(fileDto, File.class);
        File fileDb = selectByKey(fileDto.getKey());
        if (fileDb==null){
            this.insert(file);
        }else {
            fileDb.setShardIndex(fileDto.getShardIndex());
            this.insert(fileDb);
        }

    }

    /**
     * 新增
     */
    private void insert(File file) {
        Date now = new Date();
        file.setCreatedAt(now);
        file.setUpdatedAt(now);
        file.setId(UuidUtil.getShortUuid());
        fileMapper.insert(file);
    }

    /**
     * 更新
     */
    private void update(File file) {
        file.setUpdatedAt(new Date());
        fileMapper.updateByPrimaryKey(file);
    }

    /**
     * 删除
     */
    public void delete(String id) {
        fileMapper.deleteByPrimaryKey(id);
    }

    public File selectByKey(String key) {
        FileExample fileExample = new FileExample();
        fileExample.createCriteria().andIdEqualTo(key);
        List<File> files = fileMapper.selectByExample(fileExample);
        if (CollectionUtils.isEmpty(files)) {
            return null;
        } else {
            return files.get(0);
        }
    }

    /**
     * 根据文件标识查询数据库记录
     */
    public FileDto findByKey(String key) {
        return CopyUtil.copy(selectByKey(key), FileDto.class);
    }


}

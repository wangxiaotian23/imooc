package com.course.imooc.business.controller.admin;

import com.course.server.dto.TestDto;
import com.course.imooc.server.dto.PageDto;
import com.course.imooc.server.dto.ResponseDto;
import com.course.imooc.server.service.TestService;
import com.course.imooc.server.util.ValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/test")
public class TestController {

    private static final Logger LOG = LoggerFactory.getLogger(TestController.class);
    public static final String BUSINESS_NAME = "测试";

    @Resource
    private TestService testService;

    /**
     * 列表查询
     */
    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto) {
        ResponseDto responseDto = new ResponseDto();
        testService.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }

    /**
     * 保存，id有值时更新，无值时新增
     */
    @PostMapping("/save")
    public ResponseDto save(@RequestBody TestDto testDto) {
        // 保存校验
        ValidatorUtil.length(testDto.getName(), "名称", 1, 50);

        ResponseDto responseDto = new ResponseDto();
        testService.save(testDto);
        responseDto.setContent(testDto);
        return responseDto;
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id) {
        ResponseDto responseDto = new ResponseDto();
        testService.delete(id);
        return responseDto;
    }
}

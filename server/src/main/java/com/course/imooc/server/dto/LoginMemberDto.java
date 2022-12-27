package com.course.imooc.server.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @Auther: 李清依
 * @Date: 2022/10/16 16:01
 * @Description:
 */
@Data
@Getter
@Setter
public class LoginMemberDto {
    private String id;

    private String mobile;

    private String name;

    private String token;

    private String photo;


}

package com.course.imooc.server.dto;

/**
 * @Auther: 李清依
 * @Date: 2022/8/29 21:38
 * @Description:
 */
public class CoursePageDto extends PageDto {
    private String status;

    private String categoryId;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CoursePageDto{");
        sb.append("status='").append(status).append('\'');
        sb.append(", categoryId='").append(categoryId).append('\'');
        sb.append(", page=").append(page);
        sb.append(", size=").append(size);
        sb.append(", total=").append(total);
        sb.append(", list=").append(list);
        sb.append('}');
        return sb.toString();
    }
}

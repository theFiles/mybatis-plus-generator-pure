package com.lidaye.mybatis.plus.generator.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 用户表,1,uploadImg-userPhoto-YES
 * </p>
 *
 * @author ${author}
 * @since 2022-02-21
 */
public class PosUser implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 密码
     */
    private String password;

    /**
     * 性别
     */
    private String sex;

    /**
     * 头像
     */
    private String userPhoto;

    /**
     * 用户禁用状态（0启用 1禁用）
     */
    private String userDisable;

    /**
     * 创建时间
     */
    private LocalDateTime createDate;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 代理商编号
     */
    private String number;

    /**
     * 代理商id
     */
    private Integer agentId;

    /**
     * 盐,
     */
    private String salt;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getUserDisable() {
        return userDisable;
    }

    public void setUserDisable(String userDisable) {
        this.userDisable = userDisable;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "PosUser{" +
        "id=" + id +
        ", nickName=" + nickName +
        ", phone=" + phone +
        ", password=" + password +
        ", sex=" + sex +
        ", userPhoto=" + userPhoto +
        ", userDisable=" + userDisable +
        ", createDate=" + createDate +
        ", remarks=" + remarks +
        ", number=" + number +
        ", agentId=" + agentId +
        ", salt=" + salt +
        "}";
    }
}

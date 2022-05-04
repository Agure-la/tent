package com.kk.model;

import io.smallrye.common.constraint.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_roles", uniqueConstraints = @UniqueConstraint(name = "name_cx", columnNames = {
        "role_name"}))
public class UserRole {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_name", length = 200)
    @NotNull
    private String roleName;

    @ManyToMany(targetEntity = SystemUser.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userRoles")
    private List<SystemUser> userList;

    public Long getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<SystemUser> getUserList() {
        return userList;
    }

    public void setUserList(List<SystemUser> userList) {
        this.userList = userList;
    }
}

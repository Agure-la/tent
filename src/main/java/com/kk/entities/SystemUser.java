package com.kk.entities;

import org.hibernate.search.engine.backend.types.Sortable;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.GenericField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.KeywordField;

import javax.persistence.*;
import java.util.Set;

@Entity
//@Indexed(routingBinder = @RoutingBinderRef())
@Table(name = "portal_users", uniqueConstraints = {
        @UniqueConstraint(name = "username_cx", columnNames = "username"),
        @UniqueConstraint(name = "email_cx" , columnNames = "email"),
        @UniqueConstraint(name = "phone_no_cx", columnNames = "phone_no")
})
public class SystemUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @GenericField
    private Long id;

    @Column(name = "username", length = 100)
    @KeywordField(sortable = Sortable.YES)
    private String username;

    @Column(name = "full_name", length = 255)
    //@FullTextField(analyzer = "english", searchable = Searchable.YES)
    private String fullName;

    @Column(name = "password")
    private String password;

    @Column(name = "email", length = 30)
    //@KeywordField(sortable = Sortable.YES, searchable = Searchable.YES)
    private String email;

    @Column(name = "phone_no", length = 20)
    //@KeywordField(sortable = Sortable.YES, searchable = Searchable.YES)
    private String phoneNo;

    @Column(name = "Deleted", length = 5, columnDefinition = "VARCHAR(5) DEFAULT 'NO'")
    //@KeywordField(sortable = Sortable.YES, searchable = Searchable.YES)
    private String Deleted;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<UserRole> userRoles;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getDeleted() {
        return Deleted;
    }

    public void setDeleted(String deleted) {
        Deleted = deleted;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public void setId(long l) {
    }
}

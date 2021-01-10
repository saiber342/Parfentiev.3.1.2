package CRUDApplication.models;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "roleName")
    private String roleName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    private String name;

    public Role(String roleName, Set<User> users) {
        this.roleName = roleName;
        this.users = users;
    }

    public Role(Long id, String roleName, Set<User> users) {
        this.id = id;
        this.roleName = roleName;
        this.users = users;
    }

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;


    public Role() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public String getAuthority() {
        return roleName;
    }
}

package dbService.datasets;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class UsersDataSet implements Serializable {
    private static final long serialVersionUID = -987654321L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username", unique = true, updatable = false)
    private String username;

    @Column(name = "password", updatable = false)
    private String password;

    @Column(name = "email", updatable = false)
    private String email;

    public UsersDataSet() {
    }

    public UsersDataSet(String username,String password,String email) {
        setId(-1L);
        setUsername(username);
        setPassword(password);
        setEmail(email);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    @Override
    public String toString() {
        return "UserDataSet{" +
                "id=" + id +
                ", username='" + username + "\'" +
                ", password=" + password +
                ", email=" + email +
                '}';
    }
}


import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = User.TABLE_NAME)
public class User {
    public interface CreatedUser {
    }

    public interface UpdateUser {
    }

    public static final String TABLE_NAME = "user";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private long id;

    @Column(name = "username", length = 100, nullable = false, unique = true)
    @NotNull(groups = CreatedUser.class)
    @NotEmpty(groups = CreatedUser.class)
    @Size(groups = CreatedUser.class, min = 2, max = 100)
    private String username;

    @JsonProperty
    @Column(name = "password", length = 60, nullable = false)
    @NotNull(groups = { CreatedUser.class, UpdateUser.class })
    @NotEmpty(groups = { CreatedUser.class, UpdateUser.class })
    @Size(groups = { CreatedUser.class, UpdateUser.class }, min = 8, max = 60)
    private String password;

    // private List<Task> tasks = new ArrayList<Task>();

    public User() {
    }

    public User(long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        User other = (User) obj;

        return id == other.id &&
                Objects.equals(username, other.username) &&
                Objects.equals(password, other.password);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Long.hashCode(id);
        result = prime * result + (username == null ? 0 : username.hashCode());
        result = prime * result + (password == null ? 0 : password.hashCode());
        return result;
    }

}
package yay.apidoc.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "用户")
public class User {
	@ApiModelProperty(required = false)
    private Integer id;
	@ApiModelProperty(required = true)
    private String username;
	@ApiModelProperty(required = true)
    private String password;
	@ApiModelProperty(required = true)
    private String phone;
	@ApiModelProperty(required = true)
    private String email;
	@ApiModelProperty(required = true)
    private String nickname;
	@ApiModelProperty(required = true)
    private String image;
    public User() {
        super();
    }
    public User(Integer id,String username,String password,String phone,String email,String nickname,String image) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.nickname = nickname;
        this.image = image;
    }
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
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

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}

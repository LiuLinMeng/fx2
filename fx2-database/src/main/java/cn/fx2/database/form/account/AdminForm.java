package cn.fx2.database.form.account;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class AdminForm implements Serializable {
    private static final long serialVersionUID = -7507437230627277173L;
    @NotBlank(message = "用户名不能为空")
    private String username;
    @NotBlank(message = "密码不能为空")
    private String password;
}

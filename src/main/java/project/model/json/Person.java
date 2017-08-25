package project.model.json;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Person {
    private String organization;
    private String role;
    private Integer rank;
    @SerializedName("firstname")
    private String firstName;
    @SerializedName("lastname")
    private String lastName;
}

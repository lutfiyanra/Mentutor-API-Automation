package starter.Mentutor;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class MentutorAPI {
    public static final String URL = "https://ecommerce-alta.online";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_REQ_BODY = DIR + "/src/test/resources/JSON/RequestBody";
    public static final String JSON_SCHEMA = DIR+"/src/test/resources/JSON/JsonSchema";

    public static String LOGIN = URL + "/login";
//    public static String ID = "data.id";
    public static String ADMIN_MANAGE_USERS = URL+"/admin/users";
    public static String ADMIN_MANAGE_CLASSES = URL+"/admin/classes";
    public static String ADMIN_MANAGE_USERS_PROFILE = URL + "/admin/users/{id_user}";
    public static String ADMIN_MANAGE_CLASS = URL + "/admin/classes/{id_class}";

    public static String MENTOR_UPDATE_USER = URL + "/users";
    public static String MANAGE_TASK=URL+"/mentors/task";
    public static String MANAGE_SPECIFIC_TASK_ID = URL+"/mentors/task/{id_task}";
    public static String MENTOR_MANAGE_TASK_SCORE = URL+"/mentors/submission/{id_submission}";
    public static String MENTOR_ADD_COMMENT=URL+"/forum/{id_status}";

    public static String MENTEE_UPDATE_PROFILE = URL+"/users";
    public static String MENTEE_GET_ALL_TASK = URL+"/mentees/tasks";
    public static String MENTEE_POST_SUBMIT_TASK = URL+"/mentees/submission/{id_task}";
    public static String MENTEE_POST_COMMENT_FORUM = URL+"/forum/{id_status}";

    public static String MANAGE_FORUM = URL+"/forum";

    @Step("Post Login User")
    public void postLoginUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Get list users invalid page with char")
    public void getListUsersInvalidPage(String page){
        SerenityRest.given().pathParam("page",page);
    }

    @Step("Get single user")
    public void getSingleUser(int id){
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Get single user invalid id with string")
    public void getSingleUserInvalidStringValue(String id){
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Get list resource with valid path")
    public void GetListResource(String path){
        SerenityRest.given().pathParam("path", path);
    }

    @Step("Get list resource with valid page parameter")
    public void getListResourcePageParam(int page){
        SerenityRest.given().pathParam("page", page);
    }

    @Step("Get single resource with valid id")
    public void getSingleResourceValidId(int id){
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Get single resource with invalid id by char")
    public void getSingleResources(String id){
        SerenityRest.given().pathParam("id",id);
    }

    @Step("Post Register")
    public void postRegister(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post create new user")
    public void setPostCreateNewUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Put update user")
    public void setPutUpdateUser(int id, File json){
        SerenityRest.given().pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete user")
    public void deleteUser(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Delete user id string")
    public void deleteUserIdString(String id){
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Delete user id invalid path")
    public void deleteUserInvalidPath(String path){
        SerenityRest.given().pathParam("path", path);
    }

    @Step("Put Update User")
    public void putUpdateUser(int id, File json){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update user invalid path")
    public void putUpdateUserInvalidPath(String path, File json){
        SerenityRest.given()
                .pathParam("path", path)
                .contentType(ContentType.JSON)
                .body(json);
    }

    // Custom Login
    @Step("Post login")
    public void postLogin(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }


    @Step("Get Delayed Response")
    public void getDelayedResponse(int delay){
        SerenityRest.given().pathParam("delay", delay);
    }
}

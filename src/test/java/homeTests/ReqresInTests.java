package homeTests;

import api.ApiManager;
import api.models.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReqresInTests {
    ApiManager apiManager = new ApiManager();

    @Test
    void listUsersTest() {
        RequestModelForGetListUsers requestModelForGetListUsers
                = new RequestModelForGetListUsers();
        requestModelForGetListUsers.setPage("2");
        Response response = apiManager.getReqresInRestService().getListUsers(requestModelForGetListUsers);
        int actualStatusCode = response.getStatusCode();
        int expectedStatusCode = 200;
        Assertions.assertEquals(expectedStatusCode, actualStatusCode);
        JsonPath jsonPath = new JsonPath(response.asString());
        Assertions.assertEquals(Integer.parseInt(requestModelForGetListUsers.getPage()), (Integer) jsonPath.get("page"));
    }

    @Test
    void singleUserTest() {
        int id = 2;
        String email = "janet.weaver@reqres.in";
        String avatar = "https://reqres.in/img/faces/2-image.jpg";
        String text = "To keep ReqRes free, contributions towards server costs are appreciated!";
        Response response = apiManager.getReqresInRestService().getSingleUser();
        int actualStatusCode = response.getStatusCode();
        int expectedStatusCode = 200;
        Assertions.assertEquals(expectedStatusCode, actualStatusCode);
        ResponseModelForGetSingleUsers responseModelForGetSingleUsers
                 = response.then()
                .extract()
                .as(ResponseModelForGetSingleUsers.class);
        org.assertj.core.api.Assertions.assertThat(responseModelForGetSingleUsers.data.id).isEqualTo(id);
        org.assertj.core.api.Assertions.assertThat(responseModelForGetSingleUsers.data.email).isEqualTo(email);
        org.assertj.core.api.Assertions.assertThat(responseModelForGetSingleUsers.data.avatar).isEqualTo(avatar);
        org.assertj.core.api.Assertions.assertThat(responseModelForGetSingleUsers.support.text).isEqualTo(text);
    }

    @Test
    void singleUserNotFoundTest() {
        Response response = apiManager.getReqresInRestService().getSingleUserNotFound();
        int actualStatusCode = response.getStatusCode();
        int expectedStatusCode = 404;
        Assertions.assertEquals(expectedStatusCode, actualStatusCode);
    }

    @Test
    void createTest() {
        String name = "morpheus";
        String job = "leader";
        RequestModelForCreate requestModelForCreate = new RequestModelForCreate();
        requestModelForCreate.setName(name);
        requestModelForCreate.setJob(job);
        Response response = apiManager.getReqresInRestService().postCreate(requestModelForCreate);
        int actualStatusCode = response.getStatusCode();
        int expectedStatusCode = 201;
        Assertions.assertEquals(expectedStatusCode, actualStatusCode);
        ResponseModelForCreate responseModelForCreate
                = response.then()
                .extract()
                .as(ResponseModelForCreate.class);
        org.assertj.core.api.Assertions.assertThat(responseModelForCreate.name).isEqualTo(name);
        org.assertj.core.api.Assertions.assertThat(responseModelForCreate.job).isEqualTo(job);
    }

    @Test
    void updateTest() {
        String name = "morpheus";
        String job = "zion resident test new man";
        RequestModelForUpdate requestModelForUpdate = new RequestModelForUpdate();
        requestModelForUpdate.setName(name);
        requestModelForUpdate.setJob(job);
        Response response = apiManager.getReqresInRestService().putUpdate(requestModelForUpdate);
        int actualStatusCode = response.getStatusCode();
        int expectedStatusCode = 200;
        Assertions.assertEquals(expectedStatusCode, actualStatusCode);
        ResponseModelForUpdate responseModelForUpdate =
                response.then()
                        .extract()
                        .as(ResponseModelForUpdate.class);
        org.assertj.core.api.Assertions.assertThat(responseModelForUpdate.name).isEqualTo(name);
        org.assertj.core.api.Assertions.assertThat(responseModelForUpdate.job).isEqualTo(job);
    }
}

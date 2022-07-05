package homeTests;

import api.ApiManager;
import api.REQRES.ReqresInRestService;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReqresInTests {
    ApiManager apiManager = new ApiManager();

    @Test
    void listUsersTest() {
        ReqresInRestService.RequestModelForGetListUsers requestModelForGetListUsers
                = apiManager.getReqresInRestService().new RequestModelForGetListUsers();
        requestModelForGetListUsers.setPage("2");
        Response response = apiManager.getReqresInRestService().getListUsers(requestModelForGetListUsers);
        int actualStatusCode = response.getStatusCode();
        int expectedStatusCode = 200;
        Assertions.assertEquals(expectedStatusCode, actualStatusCode);
        JsonPath jsonPath = new JsonPath(response.asString());
        Assertions.assertEquals(Integer.parseInt(requestModelForGetListUsers.getPage()), (Integer) jsonPath.get("page"));
    }
}

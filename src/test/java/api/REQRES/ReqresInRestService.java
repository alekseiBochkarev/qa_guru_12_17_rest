package api.REQRES;
import mainPackage.BaseSetup;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Method;
import io.restassured.response.Response;

import java.util.HashMap;

import static mainPackage.BaseSetup.ApiPath.REQRES_IN_REST_SERVICE_PATH;

public class ReqresInRestService extends BaseSetup{

    public Response getListUsers (RequestModelForGetListUsers requestModelForGetListUsers) {
        HashMap requestParams = new HashMap();
        requestParams.put("page", requestModelForGetListUsers.getPage());
        requestSpecBuilder.setBaseUri(workingHost)
                .setBasePath(REQRES_IN_REST_SERVICE_PATH)
                .setContentType("application/json")
                .addQueryParams(requestParams);
        Response reqresResponse = sendRequestAndGetResponseNew(Method.GET);
        return reqresResponse;
    }

    public class RequestModelForGetListUsers {
        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        private String page;
    }

}

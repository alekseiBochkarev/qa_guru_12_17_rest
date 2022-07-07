package api.reqres;
import api.models.RequestModelForCreate;
import api.models.RequestModelForGetListUsers;
import api.models.RequestModelForUpdate;
import base.BaseSetup;
import io.restassured.http.Method;
import io.restassured.response.Response;

import java.util.HashMap;

import static base.BaseSetup.ApiPath.REQRES_IN_REST_SERVICE_PATH;

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

    public Response getSingleUser () {
        requestSpecBuilder.setBaseUri(workingHost)
                .setBasePath(REQRES_IN_REST_SERVICE_PATH + "/2")
                .setContentType("application/json");
        Response reqresResponse = sendRequestAndGetResponseNew(Method.GET);
        return reqresResponse;
    }

    public Response getSingleUserNotFound () {
        requestSpecBuilder.setBaseUri(workingHost)
                .setBasePath(REQRES_IN_REST_SERVICE_PATH + "/23")
                .setContentType("application/json");
        Response reqresResponse = sendRequestAndGetResponseNew(Method.GET);
        return reqresResponse;
    }

    public Response postCreate (RequestModelForCreate requestModelForCreate) {
        HashMap bodyParams = new HashMap();
        bodyParams.put("name", requestModelForCreate.getName());
        bodyParams.put("job", requestModelForCreate.getJob());
        requestSpecBuilder.setBaseUri(workingHost)
                .setBasePath(REQRES_IN_REST_SERVICE_PATH)
                .setContentType("application/json")
                .setBody(bodyParams);
        Response reqresResponse = sendRequestAndGetResponseNew(Method.POST);
        return reqresResponse;
    }

    public Response putUpdate (RequestModelForUpdate requestModelForUpdate) {
        HashMap bodyParams = new HashMap();
        bodyParams.put("name", requestModelForUpdate.getName());
        bodyParams.put("job", requestModelForUpdate.getJob());
        requestSpecBuilder.setBaseUri(workingHost)
                .setBasePath(REQRES_IN_REST_SERVICE_PATH + "/2")
                .setContentType("application/json")
                .setBody(bodyParams);
        Response reqresResponse = sendRequestAndGetResponseNew(Method.PUT);
        return reqresResponse;
    }

}

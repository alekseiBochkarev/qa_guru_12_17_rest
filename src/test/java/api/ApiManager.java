package api;

import api.reqres.ReqresInRestService;

public class ApiManager {

    public ReqresInRestService getReqresInRestService() {
        return reqresInRestService;
    }

    ReqresInRestService reqresInRestService = new ReqresInRestService();

}

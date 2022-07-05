package api;

import api.REQRES.ReqresInRestService;

public class ApiManager {

    public ReqresInRestService getReqresInRestService() {
        return reqresInRestService;
    }

    ReqresInRestService reqresInRestService = new ReqresInRestService();

}

package api.models;

public class ResponseModelForGetSingleUsers {
    public Data data = new Data();
    public Support support = new Support();
    public class Data {
        public int id;
        public String email;
        public String first_name;
        public String last_name;
        public String avatar;
    }
    public class Support {
        public String url;
        public String text;
    }
}

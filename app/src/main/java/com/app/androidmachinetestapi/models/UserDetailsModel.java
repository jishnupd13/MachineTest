package com.app.androidmachinetestapi.models;

import com.google.gson.annotations.SerializedName;

public class UserDetailsModel {

    @SerializedName("data")
    public Data data;

  public   class Data{
        @SerializedName("id")
        public Integer id;

        @SerializedName("email")
        public String email;

        @SerializedName("first_name")
        public String first_name;

        @SerializedName("last_name")
        public String last_name;

        @SerializedName("avatar")
        public String avatar;
    }

}




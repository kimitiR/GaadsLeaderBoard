package com.example.leaderboad.Api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface PostApi {

    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/for\n" +
            "mResponse")
    @FormUrlEncoded
    Call<Void> postSubmission(@Field("entry.1877115667") String name,
                              @Field("entry.2006916086") String lastName,
                              @Field("entry.1824927963") String eMail,
                              @Field("entry.284483984") String linkToProject);
}
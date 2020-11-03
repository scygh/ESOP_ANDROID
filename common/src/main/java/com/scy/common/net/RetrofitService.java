package com.scy.common.net;

import com.scy.common.entity.BaseResponse;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2020/10/26 10:21
 */
public interface RetrofitService {

    @GET("Api/Config/GetConfig")
    Observable<BaseResponse<String>> getConfig(@Header("accessToken") String token,  @Query("key") String key);
}

package com.example.pc.xumuapp.retrofit;

//import com.android.lnpdit.agrimachine.mvp.mvp_home.model.OrgIndexModel;
//import com.android.lnpdit.agrimachine.mvp.mvp_home.model.PersonalIndexModel;
//import com.android.lnpdit.agrimachine.mvp.mvp_home.model.TownsIndexModel;
//import com.android.lnpdit.agrimachine.mvp.mvp_list.model.DetailsListResponseModel;
//import com.android.lnpdit.agrimachine.mvp.mvp_list.model.ListResponseModel;
//import com.android.lnpdit.agrimachine.mvp.mvp_list.model.OrgDetailsListDataModel;
//import com.android.lnpdit.agrimachine.mvp.mvp_list.model.OrgPersonDetailsListDataModel;
//import com.android.lnpdit.agrimachine.mvp.mvp_login.model.LoginModel;

import com.example.pc.xumuapp.mvp_charge.model.ChargeMedel;
import com.example.pc.xumuapp.mvp_contrl.model.ChangeControlModel;
import com.example.pc.xumuapp.mvp_contrl.model.ControlListModel;
import com.example.pc.xumuapp.mvp_login.model.LoginModel;
import com.example.pc.xumuapp.yunwei.model.AdduserModel;
import com.example.pc.xumuapp.newAdded.model.AddcarinfoModel;
import com.example.pc.xumuapp.yunwei.model.EquipmentModel;
import com.example.pc.xumuapp.yunwei.model.EquipmentstatusModel;
import com.example.pc.xumuapp.yunwei.model.GatherModel;
import com.example.pc.xumuapp.yunwei.model.GongdanModel;
import com.example.pc.xumuapp.yunwei.model.OrderModel;
import com.example.pc.xumuapp.yunwei.model.PackModel;
import com.example.pc.xumuapp.yunwei.model.ParameterModel;
import com.example.pc.xumuapp.yunwei.model.PlantModel;
import com.example.pc.xumuapp.yunwei.model.ProcessModel;
import com.example.pc.xumuapp.yunwei.model.SubmitParameterModel;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by wangyuanshi
 */

public interface ApiService {

    //baseUrl

//    http://120.221.150.59:8081/EPIM/api/app/login?username=changqing&password=zhihuinongji
    //    http://39.107.152.122/fm/a/login?__login=true&__ajax=json&username=15040070175&password=123456

//    String API_SERVER_URL = "http://39.107.152.122:8980/zhzz/v3/app/api/";
//    String API_SERVER_URL = "http://49.4.71.112:8090/iahs/";
//    String API_SERVER_URL = "http://200.20.32.34:8090/iahs/";
    String API_SERVER_URL = "http://49.4.55.95:8090/iahs/";

    //作业位置H5（by深度）（0深松作业 1水田深翻 2秸秆还田）
    String URL_DEEP = "http://39.106.254.253/static/mobileClient/workDetail/workDetailByDepth.html?workSerial=";
    //作业位置H5（by作业状态）（3免耕播种 4植保作业 5收获作业 6插秧作业）
    String URL_STATUS = "http://39.106.254.253/static/mobileClient/workDetail/workDetailByWorkState.html?workSerial=";

//    @Headers("Content-Type:application/json")
//    登录
    @POST("login")
    Observable<LoginModel>  login(@Header ("Content-Type") String contentType, @Body RequestBody loginjson);

    //    登出
    @POST("a/logout")
    @FormUrlEncoded
    Observable<ChargeMedel> logout(@Field("userCode") String usercode);

    //    设备列表查询
    @POST("equipment/getPullDownList")
    Observable<EquipmentModel>  getEquipList(@HeaderMap Map<String, String> headers, @Body RequestBody loginjson);

    //     指令下发
    @POST("hw/send-command")
    Observable<OrderModel>  postOrder(@HeaderMap Map<String, String> headers, @Body RequestBody loginjson);

    //    设备状态查询
    @POST("equipment-status/getByEquipmentId")
    Observable<EquipmentstatusModel>  getEquipmentStatus(@HeaderMap Map<String, String> headers, @Body RequestBody loginjson);

    //    设备参数查询
    @POST("equipment-parameter/getByEquipmentId")
    Observable<ParameterModel>  getParameter(@HeaderMap Map<String, String> headers, @Body RequestBody loginjson);

    //    设备参数提交
    @POST("equipment-parameter/put")
    Observable<SubmitParameterModel>  postParameter(@HeaderMap Map<String, String> headers, @Body RequestBody loginjson);








    //    未完成工单列表查询
    @POST("task/getList")
    Observable<GongdanModel>  getGondanList(@HeaderMap Map<String, String> headers, @Body RequestBody loginjson);
//    查询种植列表
    @POST("app/plant/getPullDownList")
    Observable<PlantModel>  getPlantList(@HeaderMap Map<String, String> headers, @Body RequestBody loginjson);

//    查询采收列表
    @POST("app/harvest/getPullDownList")
    Observable<GatherModel>  getGatherList(@HeaderMap Map<String, String> headers, @Body RequestBody loginjson);

//    查询加工列表
    @POST("app/processing/getPullDownList")
    Observable<ProcessModel>  getProcessList(@HeaderMap Map<String, String> headers, @Body RequestBody loginjson);

//    查询包装列表
    @POST("app/packaging/getPullDownList")
    Observable<PackModel>  getPackingList(@HeaderMap Map<String, String> headers, @Body RequestBody loginjson);

//    提交种植信息
    @POST("app/plant/post")
    Observable<PlantModel.NewPlantBean>  newPlant(@HeaderMap Map<String, String> headers, @Body RequestBody loginjson);

    //    提交采收信息
    @POST("app/harvest/post")
    Observable<PlantModel.NewPlantBean>  newGather(@HeaderMap Map<String, String> headers, @Body RequestBody loginjson);

    //    提交采收信息
    @POST("app/processing/post")
    Observable<PlantModel.NewPlantBean>  newProcess(@HeaderMap Map<String, String> headers, @Body RequestBody loginjson);

  //    提交包装信息
    @POST("app/packaging/post")
    Observable<PlantModel.NewPlantBean>  newPack(@HeaderMap Map<String, String> headers, @Body RequestBody loginjson);


    //获取控制设备列表http://39.107.152.122:8980/zhzz/v3/app/api/control/list?pengCode=123456
    @POST("control/list")
    @FormUrlEncoded
    Observable<ControlListModel>  getControlList(@Field("pengCode") String pengCode);


    //获取控制设备列表http://39.107.152.122:8980/zhzz/v3/app/api/water/control/commands?equipCode=GHC200191001&command=63&equipStatus=02,0100
    @POST("water/control/commands")
    @FormUrlEncoded
    Observable<ChangeControlModel>  changeControl(@Field("equipCode") String equipCode, @Field("command") String command, @Field("equipStatus") String equipStatus);









    //    新增用户
    @POST("app/install/api/user/save")
    @FormUrlEncoded
    Observable<AdduserModel> adduser(@Field("loginCode") String loginCode, @Field("userName") String userName, @Field("mobileImei") String mobileImei);
    //区县列表
    @GET("app/install/api/fmAnnualFee/listData")
    Observable<ChargeMedel> cahrgelist();

    //新增车辆信息
    @POST("app/install/api/fmcar/save")
    Observable<AddcarinfoModel> addcarinfo(@QueryMap Map<String,String> carinfo);
    //更新车辆信息
    @POST("app/install/api/fmcar/update")
    Observable<AddcarinfoModel> updatecarinfo(@QueryMap Map<String,String> carinfo);
//    //首页-org
//    @POST("index")
//    Observable<OrgIndexModel> orgIndex(@Query("userId") String userId, @Query("userType") String userType);
//    //首页-personal
//    @POST("index")
//    Observable<PersonalIndexModel> personalIndex(@Query("userId") String userId, @Query("userType") String userType);
//    //区县列表
//    @GET("{officeId}/{workType}/detailsList")
//    Observable<OrgDetailsListDataModel> orgDetailsList(@Path("officeId") String officeId, @Path("workType") String workType);
//    //区县列表-最后一级
//    @GET("{officeId}/{workType}/detailsList")
//    Observable<OrgPersonDetailsListDataModel> orgPersonDetailsList(@Path("officeId") String officeId, @Path("workType") String workType);
//    //列表
//    @POST("history/list")
//    Observable<ListResponseModel> historylist(@Query("carId") String carId, @Query("workType") String workType, @Query("beginTime") String beginTime, @Query("endTime") String endTime);
//    //列表
//    @POST("details/list")
//    Observable<DetailsListResponseModel> detailslist(@Query("carId") String carId, @Query("workType") String workType, @Query("workDate") String workDate);
}

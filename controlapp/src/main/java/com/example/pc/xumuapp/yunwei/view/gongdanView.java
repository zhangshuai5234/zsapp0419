
package com.example.pc.xumuapp.yunwei.view;
import com.example.pc.xumuapp.yunwei.model.GongdanModel;

/**
 * Created by wangyuanshi on 2018/3/21.
 */

public interface gongdanView {

    void GetLoginSuccess(GongdanModel gongdanModel);

    void GetLoginError(Throwable e);
}

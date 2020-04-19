package com.example.pc.xumuapp.mvp_login.view;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pc.xumuapp.MainActivity;
import com.example.pc.xumuapp.base.BaseActivity;
import com.example.pc.xumuapp.R;
import com.example.pc.xumuapp.mvp_login.model.LoginModel;
import com.example.pc.xumuapp.mvp_login.presenter.LoginPresenter;
import com.example.pc.xumuapp.retrofit.ProgressDialogHandler;
import com.example.pc.xumuapp.utils.SpUtils;
import com.google.gson.Gson;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.RequestBody;

public class Loginactivity extends BaseActivity implements LoginView{
    @BindView(R.id.username_edit)
    EditText user_edit;
    @BindView(R.id.passward_edit)
    EditText pwd_edit;

    private ProgressDialogHandler progressDialogHandler = new ProgressDialogHandler(Loginactivity.this, null, true);

    Context context = this;
    private LoginPresenter loginPresenter = new LoginPresenter(this);

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initView() {
        setContentView(R.layout.login_layout);
        ButterKnife.bind(this);
    }

    @Override
    protected void loadData() {
        String username = SpUtils.GetConfigString(context, "username");
        user_edit.setText(username);
    }
    @OnClick(R.id.login_bt)
    public void onClick(View view) {
        if(user_edit.getText().toString().trim().equals("")||pwd_edit.getText().toString().trim().equals("")){
//            to.make(view, "请确认账号或密码不能为空", Snackbar.LENGTH_SHORT).show();
            Toast.makeText(context, "请确认账号或密码不能为空", Toast.LENGTH_SHORT).show();
        }else{
            try {

                Gson gson=new Gson();
                HashMap<String,String> paramsMap = new HashMap<>();
                paramsMap.put("userName",user_edit.getText().toString().trim());
                paramsMap.put("password",pwd_edit.getText().toString().trim());
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"),strEntity);

                loginPresenter.loadLoginData(body);

                Message msg = new Message();
                msg.what = progressDialogHandler.SHOW_PROGRESS_DIALOG;
                progressDialogHandler.handleMessage(msg);

            }catch ( Exception e){
                e.printStackTrace();
            }

        }
    }

    @Override
    public void GetLoginSuccess(LoginModel loginModel) {
        SpUtils.SetConfigString(context,"username", user_edit.getText().toString().trim());
        if (loginModel.getCode()==200){
            // 储存用户信息
//            SpUtils.SetConfigString(context,"id", loginModel.getUser().getId());
            SpUtils.SetConfigString(context,"userToken", loginModel.getData());

            Message msg = new Message();
            msg.what = progressDialogHandler.DISMISS_PROGRESS_DIALOG;
            progressDialogHandler.handleMessage(msg);
//            int i = 0;
            Intent intent = new Intent();
            intent.setClass(Loginactivity.this, MainActivity.class);
//            intent.putExtra("user", loginModel.getUser());
            startActivity(intent);
            finish();
        }else {

        }

    }

    @Override
    public void GetLoginError(Throwable e) {
//        Toast.makeText(context, "账号密码错误", Toast.LENGTH_SHORT).show();
        Message msg = new Message();
        msg.what = progressDialogHandler.DISMISS_PROGRESS_DIALOG;
        progressDialogHandler.handleMessage(msg);
    }
}

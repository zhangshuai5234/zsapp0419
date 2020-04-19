package com.example.pc.xumuapp.mvp_login.view;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
//import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import com.example.pc.xumuapp.base.BaseActivity;
import com.example.pc.xumuapp.MainActivity;
import com.example.pc.xumuapp.R;
import com.example.pc.xumuapp.mvp_login.model.LoginModel;
import com.example.pc.xumuapp.mvp_login.presenter.LoginPresenter;
import com.example.pc.xumuapp.retrofit.ProgressDialogHandler;
import com.example.pc.xumuapp.utils.SpUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

import butterknife.OnClick;

/**
 * Created by wangyuanshi on 2018/3/20.
 */

public class LoginAcitivty extends BaseActivity implements LoginView {

    @BindView(R.id.username_edit)
    EditText user_edit;
    @BindView(R.id.passward_edit)
    EditText pwd_edit;
    private ProgressDialogHandler progressDialogHandler = new ProgressDialogHandler(LoginAcitivty.this, null, true);

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

    @Override
        public void GetLoginSuccess(LoginModel loginModel) {
        SpUtils.SetConfigString(context,"username", user_edit.getText().toString().trim());
        if (loginModel.getCode()==200){ // response success
//            SpUtils.SetConfigString(context,"id", loginModel.getUser().getId());
//            SpUtils.SetConfigString(context,"officeId", loginModel.getData().getOfficeId());
//            SpUtils.SetConfigString(context,"name", loginModel.getData().getName());
//            SpUtils.SetConfigString(context,"photo", loginModel.getData().getPhoto());
//            SpUtils.SetConfigString(context,"userType", loginModel.getUser().getUserType());
//            SpUtils.SetConfigString(context,"mobile", loginModel.getUser().getMobile());

            Message msg = new Message();
            msg.what = progressDialogHandler.DISMISS_PROGRESS_DIALOG;
            progressDialogHandler.handleMessage(msg);

            Intent intent = new Intent();
            intent.setClass(LoginAcitivty.this, MainActivity.class);
//            intent.putExtra("user", loginModel.getUser());
            startActivity(intent);
            finish();
        }else{ // response failed
//            Toast.makeText(context, loginModel.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void GetLoginError(Throwable e) {
        Message msg = new Message();
        msg.what = progressDialogHandler.DISMISS_PROGRESS_DIALOG;
        progressDialogHandler.handleMessage(msg);

        Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.login_bt)
    public void onClick(View view) {
        if(user_edit.getText().toString().trim().equals("")||pwd_edit.getText().toString().trim().equals("")){
//            to.make(view, "请确认账号或密码不能为空", Snackbar.LENGTH_SHORT).show();
            Toast.makeText(context, "请确认账号或密码不能为空", Toast.LENGTH_SHORT).show();
        }else{
//            loginPresenter.loadLoginData(user_edit.getText().toString().trim(), pwd_edit.getText().toString().trim());

            Message msg = new Message();
            msg.what = progressDialogHandler.SHOW_PROGRESS_DIALOG;
            progressDialogHandler.handleMessage(msg);
        }
    }

}

package com.example.pc.xumuapp.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by wangyuanshi on 2017/8/23.
 */

public class SpUtils {

    public static boolean SetConfigString(Context context, String keyanme, String keyvalue) {

        try
        {
            //实例化SharedPreferences对象（第一步）
            SharedPreferences mySharedPreferences= context.getSharedPreferences("agriMach", Activity.MODE_PRIVATE);
            //实例化SharedPreferences.Editor对象（第二步）
            SharedPreferences.Editor editor = mySharedPreferences.edit();
            //用putString的方法保存数据
            editor.putString(keyanme, keyvalue);
            //提交当前数据
            editor.commit();
            //使用toast信息提示框提示成功写入数据
            String strout = "数据成功写入SharedPreferences！"+keyvalue;
            LogUtil.logConsole(strout);
            //Toast.makeText(context,strout, Toast.LENGTH_LONG).show();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();

            return false;
        }
        return true;
    }
    public static String GetConfigString(Context context, String keyname)
    {
        String resultvalue="";
        try
        {
            SharedPreferences sharedPreferences= context.getSharedPreferences("agriMach", Activity.MODE_PRIVATE);
            // 使用getString方法获得value，注意第2个参数是value的默认值
            resultvalue =sharedPreferences.getString(keyname, "");
            //使用toast信息提示框显示信息
            String strout = "数据成功读取SharedPreferences！"+"\n"+keyname+ " " +  resultvalue;
            LogUtil.logConsole(strout);
            //Toast.makeText(context, strout,Toast.LENGTH_LONG).show();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();

            return "";
        }

        return resultvalue;
    }
}

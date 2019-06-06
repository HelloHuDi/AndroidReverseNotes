package com.example.xposedhookweixin1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class XposedHookWeixin implements IXposedHookLoadPackage {

    private static final String selfPackageName = "com.example.xposedhookweixin1";

    static final String intentFilterMsg = selfPackageName + ".notify_open";

    static final String intentSendFriendType = "type";

    private static final String weixinPackageName = "com.tencent.mm";

    private static final String weixinMainActivityClassName = weixinPackageName + ".ui.LauncherUI";

    private static final String weixinSnsUploadClassName = weixinPackageName + ".plugin.sns.ui.SnsUploadUI";

    static final String TAG = "xposed";

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (lpparam.packageName.equals(weixinPackageName)) {
            addWeixinBroadcast(lpparam);
            sendFriendsCircle(lpparam);
        }
    }

    private void addWeixinBroadcast(final XC_LoadPackage.LoadPackageParam lpparam) {
        XposedHelpers.findAndHookMethod(weixinMainActivityClassName, //
                                        lpparam.classLoader, //
                                        "onCreate", Bundle.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        Log.d(TAG, "添加广播");
                        addBroadcastReceiver(lpparam, param);
                    }
                });
    }

    private void addBroadcastReceiver(final XC_LoadPackage.LoadPackageParam lpparam, //
                                      XC_MethodHook.MethodHookParam param) {
        final Activity activity = (Activity) param.thisObject;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(intentFilterMsg);
        activity.registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.d(TAG, "接收到广播：" + intent.getAction());
                Intent intent1 = new Intent();
                //自定义状态
                intent1.putExtra("auto", true);
                intent1.setClass(activity, XposedHelpers.findClass(weixinSnsUploadClassName, lpparam.classLoader));
                intent1.putExtra("KTouchCameraTime", System.currentTimeMillis() / 1000);
                switch (intent.getIntExtra(intentSendFriendType, 0)) {
                    case 0://纯文字
                        intent1.putExtra("sns_comment_type", 1);
                        intent1.putExtra("Ksnsupload_type", 9);
                        intent1.putExtra("KSnsPostManu", true);
                        break;
                    case 1://带图片
                        intent1.putExtra("KSnsPostManu", true);
                        intent1.putExtra("KFilterId", 0);
                        ArrayList<String> imagePath = new ArrayList<>();
                        imagePath.add("/storage/emulated/0/tencent/MicroMsg/WeiXin/wx_camera_1559101436840.jpg");
                        imagePath.add("/storage/emulated/0/images/getcontent.jpg");
                        imagePath.add("/storage/emulated/0/images/149213910864.jpg");
                        imagePath.add("/storage/emulated/0/images/105548al74ai4r49j4jr9x.jpg");
                        imagePath.add("/storage/emulated/0/images/e13d77a5c2e944f5ada3e2e77c2274d5_th.jpg");
                        imagePath.add("/storage/emulated/0/images/001R5mFczy788uT183Nb3&690.jpg");
                        imagePath.add("/storage/emulated/0/images/2015040109334776394.jpg");
                        imagePath.add("/storage/emulated/0/images/091906_85872481.jpg");
                        imagePath.add("/storage/emulated/0/images/getcontent (1).jpg");
                        intent1.putStringArrayListExtra("sns_kemdia_path_list", imagePath);
                        break;
                    case 2://带视频
                        String path = "/storage/emulated/0/tencent/MicroMsg/WeiXin/wx_camera_1559205293644.mp4";
                        String md5 = (String) XposedHelpers.callStaticMethod(XposedHelpers.findClass("com.tencent.mm.vfs.e", lpparam.classLoader), "atg", new Class[]{String.class}, path);
                        intent1.putExtra("KSnsPostManu", true);
                        intent1.putExtra("Ksnsupload_type", 14);
                        intent1.putExtra("KSightPath", path);
                        intent1.putExtra("KSightThumbPath", "/storage/emulated/0/tencent/MicroMsg/bb572955d127587fa0b472b96aa43fbe/video/videoCompressTmpThumb/video_send_preprocess_thumb_1559265591571.jpg");
                        intent1.putExtra("sight_md5", md5);
                        intent1.putExtra("Kis_take_photo", false);
                        break;
                }
                activity.startActivity(intent1);
            }
        }, intentFilter);
    }

    //button  == ki 0x7f11019f  2131820959
    private void sendFriendsCircle(final XC_LoadPackage.LoadPackageParam lpparam) {
        //SnsUploadUI
        XposedHelpers.findAndHookMethod(weixinPackageName + ".ui.MMActivity", lpparam.classLoader, "a", int.class, String.class, MenuItem.OnMenuItemClickListener.class, XposedHelpers.findClass(weixinPackageName + ".ui.q$b", lpparam.classLoader), new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                Activity activity = (Activity) param.thisObject;
                Intent intent = activity.getIntent();
                //不是自动不会继续执行
                if (!intent.getBooleanExtra("auto", false)) return;
                Log.d(TAG, "继续执行上传");
                final MenuItem.OnMenuItemClickListener listeners = (MenuItem.OnMenuItemClickListener) param.args[2];
                new Handler(activity.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        listeners.onMenuItemClick(null);
                    }
                }, 5000);
            }
        });
        XposedHelpers.findAndHookMethod(weixinSnsUploadClassName, lpparam.classLoader, "onCreate", Bundle.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
            }

            @SuppressLint("SetTextI18n")
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                Activity activity = (Activity) param.thisObject;
                Intent intent = activity.getIntent();
                Set<String> keys = Objects.requireNonNull(intent.getExtras()).keySet();
                for (String string : keys) {
                    Log.i(TAG, "打印 打印朋友圈传递信息 内容111111  ：" + string);
                }
                //不是自动不会继续执行
                if (!intent.getBooleanExtra("auto", false)) return;
                Log.d(TAG, "继续执行自动填充文本");
                Field field = lpparam.classLoader.loadClass(weixinSnsUploadClassName).getDeclaredField("rnb");
                field.setAccessible(true);
                EditText text = (EditText) field.get(param.thisObject);
                text.setText("测试，自动填充文本： " + new Random().nextInt(10));
            }
        });
    }

}

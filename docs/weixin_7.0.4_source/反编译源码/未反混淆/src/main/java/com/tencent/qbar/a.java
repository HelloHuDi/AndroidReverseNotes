package com.tencent.qbar;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.qbar.QbarNative.QbarAiModelParam;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class a {
    private static List<String> Aqr;
    private static List<String> Aqs;

    static {
        AppMethodBeat.i(108291);
        ArrayList arrayList = new ArrayList();
        Aqr = arrayList;
        arrayList.add("weixin://wxpay/");
        Aqr.add("wxp://");
        Aqr.add("https://wx.tenpay.com/");
        Aqr.add("https://payapp.weixin.qq.com/");
        Aqr.add("https://action.weixin.qq.com/");
        arrayList = new ArrayList();
        Aqs = arrayList;
        arrayList.add("https://qr.alipay.com/");
        AppMethodBeat.o(108291);
    }

    public static QbarAiModelParam iy(Context context) {
        AppMethodBeat.i(108289);
        try {
            File file = new File(e.eSi.replace("/data/user/0", "/data/data") + "files/", "qbar");
            if (!file.exists()) {
                file.mkdirs();
            }
            String absolutePath = file.getAbsolutePath();
            String str = absolutePath + "/detect_model.bin";
            String str2 = absolutePath + "/detect_model.param";
            String str3 = absolutePath + "/srnet.bin";
            String str4 = absolutePath + "/srnet.param";
            SharedPreferences doB = ah.doB();
            boolean z = doB.getBoolean("qbar_ai_mode_version_1", false);
            if (!z) {
                com.tencent.mm.a.e.deleteFile(str);
                com.tencent.mm.a.e.deleteFile(str2);
                com.tencent.mm.a.e.deleteFile(str3);
                com.tencent.mm.a.e.deleteFile(str4);
                doB.edit().putBoolean("qbar_ai_mode_version_1", true).apply();
            }
            if (!(z && com.tencent.mm.a.e.ct(str))) {
                m.copyAssets(context, "qbar/detect_model.bin", str);
                m.copyAssets(context, "qbar/detect_model.param", str2);
                m.copyAssets(context, "qbar/srnet.bin", str3);
                m.copyAssets(context, "qbar/srnet.param", str4);
            }
            QbarAiModelParam qbarAiModelParam = new QbarAiModelParam();
            qbarAiModelParam.detect_model_bin_path_ = str;
            qbarAiModelParam.detect_model_param_path_ = str2;
            qbarAiModelParam.superresolution_model_bin_path_ = str3;
            qbarAiModelParam.superresolution_model_param_path_ = str4;
            AppMethodBeat.o(108289);
            return qbarAiModelParam;
        } catch (Exception e) {
            ab.w("MicroMsg.QBarAIModHelper", "getAiModeParam err %s", e.getMessage());
            AppMethodBeat.o(108289);
            return null;
        }
    }

    public static void a(QbarNative qbarNative) {
        AppMethodBeat.i(108290);
        if (qbarNative == null) {
            ab.w("MicroMsg.QBarAIModHelper", "config qbarNative is null");
            AppMethodBeat.o(108290);
            return;
        }
        for (String AddWhiteList : Aqr) {
            qbarNative.AddWhiteList(AddWhiteList, qbarNative.Aqx);
        }
        for (String AddWhiteList2 : Aqs) {
            qbarNative.AddBlackList(AddWhiteList2, qbarNative.Aqx);
        }
        qbarNative.AddBlackInternal(6, qbarNative.Aqx);
        AppMethodBeat.o(108290);
    }
}

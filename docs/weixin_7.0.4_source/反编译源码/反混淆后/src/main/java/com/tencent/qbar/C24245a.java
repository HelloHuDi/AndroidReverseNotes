package com.tencent.qbar;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.sdk.platformtools.C40616m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.qbar.QbarNative.QbarAiModelParam;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.qbar.a */
public final class C24245a {
    private static List<String> Aqr;
    private static List<String> Aqs;

    static {
        AppMethodBeat.m2504i(108291);
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
        AppMethodBeat.m2505o(108291);
    }

    /* renamed from: iy */
    public static QbarAiModelParam m37337iy(Context context) {
        AppMethodBeat.m2504i(108289);
        try {
            File file = new File(C6457e.eSi.replace("/data/user/0", "/data/data") + "files/", "qbar");
            if (!file.exists()) {
                file.mkdirs();
            }
            String absolutePath = file.getAbsolutePath();
            String str = absolutePath + "/detect_model.bin";
            String str2 = absolutePath + "/detect_model.param";
            String str3 = absolutePath + "/srnet.bin";
            String str4 = absolutePath + "/srnet.param";
            SharedPreferences doB = C4996ah.doB();
            boolean z = doB.getBoolean("qbar_ai_mode_version_1", false);
            if (!z) {
                C1173e.deleteFile(str);
                C1173e.deleteFile(str2);
                C1173e.deleteFile(str3);
                C1173e.deleteFile(str4);
                doB.edit().putBoolean("qbar_ai_mode_version_1", true).apply();
            }
            if (!(z && C1173e.m2561ct(str))) {
                C40616m.copyAssets(context, "qbar/detect_model.bin", str);
                C40616m.copyAssets(context, "qbar/detect_model.param", str2);
                C40616m.copyAssets(context, "qbar/srnet.bin", str3);
                C40616m.copyAssets(context, "qbar/srnet.param", str4);
            }
            QbarAiModelParam qbarAiModelParam = new QbarAiModelParam();
            qbarAiModelParam.detect_model_bin_path_ = str;
            qbarAiModelParam.detect_model_param_path_ = str2;
            qbarAiModelParam.superresolution_model_bin_path_ = str3;
            qbarAiModelParam.superresolution_model_param_path_ = str4;
            AppMethodBeat.m2505o(108289);
            return qbarAiModelParam;
        } catch (Exception e) {
            C4990ab.m7421w("MicroMsg.QBarAIModHelper", "getAiModeParam err %s", e.getMessage());
            AppMethodBeat.m2505o(108289);
            return null;
        }
    }

    /* renamed from: a */
    public static void m37336a(QbarNative qbarNative) {
        AppMethodBeat.m2504i(108290);
        if (qbarNative == null) {
            C4990ab.m7420w("MicroMsg.QBarAIModHelper", "config qbarNative is null");
            AppMethodBeat.m2505o(108290);
            return;
        }
        for (String AddWhiteList : Aqr) {
            qbarNative.AddWhiteList(AddWhiteList, qbarNative.Aqx);
        }
        for (String AddWhiteList2 : Aqs) {
            qbarNative.AddBlackList(AddWhiteList2, qbarNative.Aqx);
        }
        qbarNative.AddBlackInternal(6, qbarNative.Aqx);
        AppMethodBeat.m2505o(108290);
    }
}

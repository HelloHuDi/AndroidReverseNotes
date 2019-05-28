package com.tencent.p177mm.plugin.webview.model;

import android.content.Intent;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.model.C1851p;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.plugin.webview.modeltools.C29833g;
import com.tencent.p177mm.sdk.platformtools.C15429k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.baseutils.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONStringer;

/* renamed from: com.tencent.mm.plugin.webview.model.ap */
public final class C43914ap {
    /* renamed from: av */
    public static Intent m78769av(String str, String str2, String str3) {
        Parcelable[] parcelableArr;
        int i = 1;
        AppMethodBeat.m2504i(6746);
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        if (C5046bo.isNullOrNil(str)) {
            intent.setType("*/*");
        } else {
            intent.setType(str);
        }
        Intent[] intentArr = null;
        Object[] parcelableArr2;
        if (C5046bo.isNullOrNil(str2)) {
            if (C1443d.m3067fP(16)) {
                C4990ab.m7416i("MicroMsg.WebviewJSSDKUtil", "android API version is below 16.");
                i = 0;
                parcelableArr2 = new Intent[]{C43914ap.aeA(str3)};
            }
            i = 0;
            parcelableArr2 = null;
        } else if ("camera".equalsIgnoreCase(str2)) {
            i = 0;
            parcelableArr2 = new Intent[]{C43914ap.aeA(str3)};
        } else if ("camcorder".equalsIgnoreCase(str2)) {
            i = 0;
            parcelableArr2 = new Intent[]{C43914ap.cXQ()};
        } else if ("microphone".equalsIgnoreCase(str2)) {
            i = 0;
            parcelableArr2 = new Intent[]{C43914ap.cXR()};
        } else {
            if ("*".equalsIgnoreCase(str2) || "true".equalsIgnoreCase(str2) || "false".equalsIgnoreCase(str2)) {
                if (str.equalsIgnoreCase("image/*")) {
                    intentArr = new Intent[]{C43914ap.aeA(str3)};
                } else if (str.equalsIgnoreCase("audio/*")) {
                    intentArr = new Intent[]{C43914ap.cXR()};
                } else if (str.equalsIgnoreCase("video/*")) {
                    intentArr = new Intent[]{C43914ap.cXQ()};
                }
                if ("false".equalsIgnoreCase(str2) || "*".equalsIgnoreCase(str2)) {
                    parcelableArr2 = intentArr;
                } else {
                    i = 0;
                    parcelableArr2 = intentArr;
                }
            }
            i = 0;
            parcelableArr2 = null;
        }
        Intent intent2;
        if (i != 0 || parcelableArr2 == null || parcelableArr2.length == 0) {
            intent2 = new Intent("android.intent.action.CHOOSER");
            intent2.putExtra("android.intent.extra.INITIAL_INTENTS", parcelableArr2);
            intent2.putExtra("android.intent.extra.TITLE", C4996ah.getContext().getString(C25738R.string.g2t));
            intent2.putExtra("android.intent.extra.INTENT", intent);
            AppMethodBeat.m2505o(6746);
            return intent2;
        }
        intent2 = parcelableArr2[0];
        AppMethodBeat.m2505o(6746);
        return intent2;
    }

    public static String aez(String str) {
        AppMethodBeat.m2504i(6747);
        File file = new File(C6457e.euR);
        if (!file.mkdirs()) {
            C4990ab.m7416i("MicroMsg.WebviewJSSDKUtil", "mkdirs failed.File is exist = " + file.exists());
        }
        if (!file.exists()) {
            C4990ab.m7413e("MicroMsg.WebviewJSSDKUtil", "camera storage path do not exist.(%s)", C6457e.euR);
        }
        C4990ab.m7417i("MicroMsg.WebviewJSSDKUtil", "get file path from capture file name : %s == %s", str, file.getAbsolutePath() + File.separator + str + FileUtils.PIC_POSTFIX_JPEG);
        AppMethodBeat.m2505o(6747);
        return file.getAbsolutePath() + File.separator + str + FileUtils.PIC_POSTFIX_JPEG;
    }

    private static Intent aeA(String str) {
        AppMethodBeat.m2504i(6748);
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", C15429k.m23714d(C4996ah.getContext(), new File(C43914ap.aez(str))));
        AppMethodBeat.m2505o(6748);
        return intent;
    }

    private static Intent cXQ() {
        AppMethodBeat.m2504i(6749);
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        AppMethodBeat.m2505o(6749);
        return intent;
    }

    private static Intent cXR() {
        AppMethodBeat.m2504i(6750);
        Intent intent = new Intent("android.provider.MediaStore.RECORD_SOUND");
        AppMethodBeat.m2505o(6750);
        return intent;
    }

    public static String aeB(String str) {
        AppMethodBeat.m2504i(6751);
        C4990ab.m7417i("MicroMsg.WebviewJSSDKUtil", "genLocalIdByFilePath, file path is ：%s", str);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(6751);
            return null;
        }
        C4990ab.m7417i("MicroMsg.WebviewJSSDKUtil", "gen local id by filepath, filepath : %s, localid : %s", str, "weixin://resourceid/" + C4995ag.m7428ck(str));
        AppMethodBeat.m2505o(6751);
        return "weixin://resourceid/" + C4995ag.m7428ck(str);
    }

    public static String aeC(String str) {
        AppMethodBeat.m2504i(6752);
        WebViewJSSDKFileItem aex = C29833g.cYF().aex(str);
        if (aex != null) {
            C4990ab.m7417i("MicroMsg.WebviewJSSDKUtil", "get local thumb filepath from local id :%s", aex.hGG);
            String str2 = aex.hGG;
            AppMethodBeat.m2505o(6752);
            return str2;
        }
        C4990ab.m7413e("MicroMsg.WebviewJSSDKUtil", "fromLocalIdToFilePath, local map not contains the local id : %s", str);
        AppMethodBeat.m2505o(6752);
        return null;
    }

    public static String aeD(String str) {
        AppMethodBeat.m2504i(6753);
        WebViewJSSDKFileItem aex = C29833g.cYF().aex(str);
        if (aex != null) {
            C4990ab.m7417i("MicroMsg.WebviewJSSDKUtil", "get orignal filepath from local id :%s", aex.hGG);
            String str2 = aex.heo;
            AppMethodBeat.m2505o(6753);
            return str2;
        }
        C4990ab.m7413e("MicroMsg.WebviewJSSDKUtil", "getOrigFilePathByLocalId, local map not contains the local id : %s", str);
        AppMethodBeat.m2505o(6753);
        return null;
    }

    /* renamed from: ab */
    public static String m78767ab(ArrayList<String> arrayList) {
        AppMethodBeat.m2504i(6754);
        if (arrayList.size() == 0) {
            C4990ab.m7412e("MicroMsg.WebviewJSSDKUtil", "data is null");
            AppMethodBeat.m2505o(6754);
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                jSONArray.put((String) arrayList.get(i2));
                i = i2 + 1;
            } else {
                String jSONArray2 = jSONArray.toString();
                AppMethodBeat.m2505o(6754);
                return jSONArray2;
            }
        }
    }

    /* renamed from: ac */
    public static String m78768ac(ArrayList<String> arrayList) {
        AppMethodBeat.m2504i(6755);
        String str;
        if (arrayList.size() == 0) {
            C4990ab.m7412e("MicroMsg.WebviewJSSDKUtil", "data is null");
            str = "";
            AppMethodBeat.m2505o(6755);
            return str;
        }
        JSONStringer jSONStringer = new JSONStringer();
        try {
            jSONStringer.array();
            jSONStringer.object();
            for (int i = 0; i < arrayList.size(); i++) {
                str = (String) arrayList.get(i);
                jSONStringer.key("localId");
                jSONStringer.value(str);
            }
            jSONStringer.endObject();
            jSONStringer.endArray();
            str = jSONStringer.toString();
            AppMethodBeat.m2505o(6755);
            return str;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.WebviewJSSDKUtil", e, "", new Object[0]);
            str = "";
            AppMethodBeat.m2505o(6755);
            return str;
        }
    }

    /* renamed from: c */
    public static String m78770c(String str, String str2, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(6756);
        String str3;
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.WebviewJSSDKUtil", "parseVideoItemToJson localId is null");
            str3 = "";
            AppMethodBeat.m2505o(6756);
            return str3;
        }
        JSONStringer jSONStringer = new JSONStringer();
        try {
            jSONStringer.array();
            jSONStringer.object();
            jSONStringer.key("localId");
            jSONStringer.value(str);
            jSONStringer.key("thumbLocalId");
            jSONStringer.value(str2);
            jSONStringer.key(FFmpegMetadataRetriever.METADATA_KEY_DURATION);
            jSONStringer.value(String.valueOf(i));
            jSONStringer.key("height");
            jSONStringer.value(String.valueOf(i2));
            jSONStringer.key("width");
            jSONStringer.value(String.valueOf(i3));
            jSONStringer.key("size");
            jSONStringer.value(String.valueOf(i4));
            jSONStringer.endObject();
            jSONStringer.endArray();
            str3 = jSONStringer.toString();
            AppMethodBeat.m2505o(6756);
            return str3;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.WebviewJSSDKUtil", e, "", new Object[0]);
            str3 = "";
            AppMethodBeat.m2505o(6756);
            return str3;
        }
    }

    static InputStream aeE(String str) {
        AppMethodBeat.m2504i(6757);
        C4990ab.m7417i("MicroMsg.WebviewJSSDKUtil", "getDataFromLocalId : %s", str);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(6757);
            return null;
        }
        if (!C5046bo.isNullOrNil(str) && C1173e.m2561ct(str)) {
            try {
                InputStream fileInputStream = new FileInputStream(str);
                AppMethodBeat.m2505o(6757);
                return fileInputStream;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.WebviewJSSDKUtil", "init file input stream error : %s", e.getMessage());
            }
        }
        AppMethodBeat.m2505o(6757);
        return null;
    }

    public static String aeF(String str) {
        AppMethodBeat.m2504i(6758);
        String str2 = "_USER_FOR_WEBVIEW_JSAPI" + C1851p.m3818m(str, C5046bo.anU());
        AppMethodBeat.m2505o(6758);
        return str2;
    }
}

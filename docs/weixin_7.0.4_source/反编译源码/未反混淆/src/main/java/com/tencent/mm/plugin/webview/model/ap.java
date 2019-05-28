package com.tencent.mm.plugin.webview.model;

import android.content.Intent;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.ttpic.baseutils.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONStringer;

public final class ap {
    public static Intent av(String str, String str2, String str3) {
        Parcelable[] parcelableArr;
        int i = 1;
        AppMethodBeat.i(6746);
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        if (bo.isNullOrNil(str)) {
            intent.setType("*/*");
        } else {
            intent.setType(str);
        }
        Intent[] intentArr = null;
        Object[] parcelableArr2;
        if (bo.isNullOrNil(str2)) {
            if (d.fP(16)) {
                ab.i("MicroMsg.WebviewJSSDKUtil", "android API version is below 16.");
                i = 0;
                parcelableArr2 = new Intent[]{aeA(str3)};
            }
            i = 0;
            parcelableArr2 = null;
        } else if ("camera".equalsIgnoreCase(str2)) {
            i = 0;
            parcelableArr2 = new Intent[]{aeA(str3)};
        } else if ("camcorder".equalsIgnoreCase(str2)) {
            i = 0;
            parcelableArr2 = new Intent[]{cXQ()};
        } else if ("microphone".equalsIgnoreCase(str2)) {
            i = 0;
            parcelableArr2 = new Intent[]{cXR()};
        } else {
            if ("*".equalsIgnoreCase(str2) || "true".equalsIgnoreCase(str2) || "false".equalsIgnoreCase(str2)) {
                if (str.equalsIgnoreCase("image/*")) {
                    intentArr = new Intent[]{aeA(str3)};
                } else if (str.equalsIgnoreCase("audio/*")) {
                    intentArr = new Intent[]{cXR()};
                } else if (str.equalsIgnoreCase("video/*")) {
                    intentArr = new Intent[]{cXQ()};
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
            intent2.putExtra("android.intent.extra.TITLE", ah.getContext().getString(R.string.g2t));
            intent2.putExtra("android.intent.extra.INTENT", intent);
            AppMethodBeat.o(6746);
            return intent2;
        }
        intent2 = parcelableArr2[0];
        AppMethodBeat.o(6746);
        return intent2;
    }

    public static String aez(String str) {
        AppMethodBeat.i(6747);
        File file = new File(e.euR);
        if (!file.mkdirs()) {
            ab.i("MicroMsg.WebviewJSSDKUtil", "mkdirs failed.File is exist = " + file.exists());
        }
        if (!file.exists()) {
            ab.e("MicroMsg.WebviewJSSDKUtil", "camera storage path do not exist.(%s)", e.euR);
        }
        ab.i("MicroMsg.WebviewJSSDKUtil", "get file path from capture file name : %s == %s", str, file.getAbsolutePath() + File.separator + str + FileUtils.PIC_POSTFIX_JPEG);
        AppMethodBeat.o(6747);
        return file.getAbsolutePath() + File.separator + str + FileUtils.PIC_POSTFIX_JPEG;
    }

    private static Intent aeA(String str) {
        AppMethodBeat.i(6748);
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", k.d(ah.getContext(), new File(aez(str))));
        AppMethodBeat.o(6748);
        return intent;
    }

    private static Intent cXQ() {
        AppMethodBeat.i(6749);
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        AppMethodBeat.o(6749);
        return intent;
    }

    private static Intent cXR() {
        AppMethodBeat.i(6750);
        Intent intent = new Intent("android.provider.MediaStore.RECORD_SOUND");
        AppMethodBeat.o(6750);
        return intent;
    }

    public static String aeB(String str) {
        AppMethodBeat.i(6751);
        ab.i("MicroMsg.WebviewJSSDKUtil", "genLocalIdByFilePath, file path is ：%s", str);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(6751);
            return null;
        }
        ab.i("MicroMsg.WebviewJSSDKUtil", "gen local id by filepath, filepath : %s, localid : %s", str, "weixin://resourceid/" + ag.ck(str));
        AppMethodBeat.o(6751);
        return "weixin://resourceid/" + ag.ck(str);
    }

    public static String aeC(String str) {
        AppMethodBeat.i(6752);
        WebViewJSSDKFileItem aex = g.cYF().aex(str);
        if (aex != null) {
            ab.i("MicroMsg.WebviewJSSDKUtil", "get local thumb filepath from local id :%s", aex.hGG);
            String str2 = aex.hGG;
            AppMethodBeat.o(6752);
            return str2;
        }
        ab.e("MicroMsg.WebviewJSSDKUtil", "fromLocalIdToFilePath, local map not contains the local id : %s", str);
        AppMethodBeat.o(6752);
        return null;
    }

    public static String aeD(String str) {
        AppMethodBeat.i(6753);
        WebViewJSSDKFileItem aex = g.cYF().aex(str);
        if (aex != null) {
            ab.i("MicroMsg.WebviewJSSDKUtil", "get orignal filepath from local id :%s", aex.hGG);
            String str2 = aex.heo;
            AppMethodBeat.o(6753);
            return str2;
        }
        ab.e("MicroMsg.WebviewJSSDKUtil", "getOrigFilePathByLocalId, local map not contains the local id : %s", str);
        AppMethodBeat.o(6753);
        return null;
    }

    public static String ab(ArrayList<String> arrayList) {
        AppMethodBeat.i(6754);
        if (arrayList.size() == 0) {
            ab.e("MicroMsg.WebviewJSSDKUtil", "data is null");
            AppMethodBeat.o(6754);
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
                AppMethodBeat.o(6754);
                return jSONArray2;
            }
        }
    }

    public static String ac(ArrayList<String> arrayList) {
        AppMethodBeat.i(6755);
        String str;
        if (arrayList.size() == 0) {
            ab.e("MicroMsg.WebviewJSSDKUtil", "data is null");
            str = "";
            AppMethodBeat.o(6755);
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
            AppMethodBeat.o(6755);
            return str;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.WebviewJSSDKUtil", e, "", new Object[0]);
            str = "";
            AppMethodBeat.o(6755);
            return str;
        }
    }

    public static String c(String str, String str2, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(6756);
        String str3;
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.WebviewJSSDKUtil", "parseVideoItemToJson localId is null");
            str3 = "";
            AppMethodBeat.o(6756);
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
            AppMethodBeat.o(6756);
            return str3;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.WebviewJSSDKUtil", e, "", new Object[0]);
            str3 = "";
            AppMethodBeat.o(6756);
            return str3;
        }
    }

    static InputStream aeE(String str) {
        AppMethodBeat.i(6757);
        ab.i("MicroMsg.WebviewJSSDKUtil", "getDataFromLocalId : %s", str);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(6757);
            return null;
        }
        if (!bo.isNullOrNil(str) && com.tencent.mm.a.e.ct(str)) {
            try {
                InputStream fileInputStream = new FileInputStream(str);
                AppMethodBeat.o(6757);
                return fileInputStream;
            } catch (Exception e) {
                ab.e("MicroMsg.WebviewJSSDKUtil", "init file input stream error : %s", e.getMessage());
            }
        }
        AppMethodBeat.o(6757);
        return null;
    }

    public static String aeF(String str) {
        AppMethodBeat.i(6758);
        String str2 = "_USER_FOR_WEBVIEW_JSAPI" + p.m(str, bo.anU());
        AppMethodBeat.o(6758);
        return str2;
    }
}

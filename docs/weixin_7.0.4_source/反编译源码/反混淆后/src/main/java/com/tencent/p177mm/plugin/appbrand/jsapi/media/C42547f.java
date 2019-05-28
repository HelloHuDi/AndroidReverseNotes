package com.tencent.p177mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.p321l.C38414a;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.f */
public final class C42547f extends C10296a<C38492q> {
    public static final int CTRL_INDEX = 30;
    public static final String NAME = "previewImage";
    private final int hQi = SQLiteGlobal.journalSizeLimit;

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(131300);
        C38492q c38492q = (C38492q) c2241c;
        c38492q.mo6107M(i, m75335a(c38492q.mo61197ad(Activity.class), c38492q.getCurrentPageView(), c38492q.getAppId(), jSONObject));
        AppMethodBeat.m2505o(131300);
    }

    /* renamed from: a */
    private String m75335a(Context context, C44709u c44709u, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(131298);
        JSONArray optJSONArray = jSONObject.optJSONArray("urls");
        String j;
        if (optJSONArray == null) {
            j = mo73394j("fail:invalid data", null);
            AppMethodBeat.m2505o(131298);
            return j;
        }
        int i;
        int intValue;
        String[] strArr = new String[optJSONArray.length()];
        for (i = 0; i < optJSONArray.length(); i++) {
            strArr[i] = optJSONArray.optString(i);
        }
        Object opt = jSONObject.opt("current");
        if (opt instanceof Integer) {
            intValue = ((Integer) opt).intValue();
        } else if (opt instanceof String) {
            intValue = 0;
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (opt.equals(strArr[i2])) {
                    intValue = i2;
                }
            }
        } else {
            intValue = 0;
        }
        for (i = 0; i < strArr.length; i++) {
            File yg = c44709u.asE().mo34314yg(strArr[i]);
            if (yg != null) {
                strArr[i] = yg.getAbsolutePath();
            }
        }
        String[] strArr2 = new String[strArr.length];
        i = 0;
        while (i < strArr.length) {
            if (strArr[i] == null || !strArr[i].startsWith("data:image/")) {
                strArr2[i] = strArr[i];
            } else {
                String str2;
                CharSequence charSequence = strArr[i];
                if (TextUtils.isEmpty(charSequence)) {
                    str2 = "";
                } else {
                    str2 = C42547f.m75334Bz(charSequence.substring(charSequence.indexOf("base64,") + 7).trim());
                }
                strArr2[i] = str2;
            }
            i++;
        }
        ArrayList arrayList = new ArrayList();
        i = 0;
        while (i < strArr2.length) {
            if (!(strArr2[i] == null || strArr[i] == null || strArr2[i].equals(strArr[i]))) {
                arrayList.add(strArr2[i]);
            }
            i++;
        }
        final String[] strArr3 = (String[]) arrayList.toArray(new String[arrayList.size()]);
        if (intValue >= strArr2.length) {
            intValue = 0;
        }
        if (context instanceof MMActivity) {
            Intent intent = new Intent();
            intent.putExtra("nowUrl", strArr2[intValue]);
            intent.putExtra("urlList", strArr2);
            intent.putExtra("type", -255);
            intent.putExtra("isFromWebView", true);
            C38414a c38414a = (C38414a) c44709u.mo5937aa(C38414a.class);
            if (c38414a == null || C5046bo.isNullOrNil(c38414a.referer)) {
                C4990ab.m7420w("MicroMsg.JsApiPreviewImage", "config.referer is null");
            } else {
                intent.putExtra("IsFromWebViewReffer", c38414a.referer);
            }
            intent.putExtra("shouldShowScanQrCodeMenu", true);
            intent.putExtra("scanQrCodeGetA8KeyScene", 44);
            intent.putExtra("scanCodeTypes", new int[]{3});
            intent.putExtra("scanResultCodeTypes", new int[]{22});
            Bundle bundle = new Bundle();
            bundle.putInt("stat_scene", 6);
            bundle.putString("stat_app_id", str);
            bundle.putString("stat_url", c44709u.getURL());
            intent.putExtra("_stat_obj", bundle);
            intent.setClassName(context, context.getPackageName() + ".plugin.subapp.ui.gallery.GestureGalleryUI");
            try {
                if (intent.getExtras().toString().length() > SQLiteGlobal.journalSizeLimit) {
                    C4990ab.m7413e("MicroMsg.JsApiPreviewImage", "data too large size:%d", Integer.valueOf(intent.getExtras().toString().length()));
                    j = mo73394j("fail:data too large", null);
                    AppMethodBeat.m2505o(131298);
                    return j;
                }
                ((MMActivity) context).ifE = new C5186a() {
                    /* renamed from: c */
                    public final void mo6069c(int i, int i2, Intent intent) {
                        AppMethodBeat.m2504i(131297);
                        String[] strArr = strArr3;
                        for (String file : strArr) {
                            try {
                                new File(file).delete();
                            } catch (Exception e) {
                            }
                        }
                        AppMethodBeat.m2505o(131297);
                    }
                };
                Context context2 = context;
                C25985d.m41453a(context2, "subapp", ".ui.gallery.GestureGalleryUI", intent, CdnLogic.kBizGeneric & hashCode(), false);
                j = mo73394j("ok", null);
                AppMethodBeat.m2505o(131298);
                return j;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.JsApiPreviewImage", e, "JsApiPreviewImage get size error", new Object[0]);
                j = mo73394j("fail", null);
                AppMethodBeat.m2505o(131298);
                return j;
            }
        }
        j = mo73394j("fail:internal error invalid android context", null);
        AppMethodBeat.m2505o(131298);
        return j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0061 A:{SYNTHETIC, Splitter:B:16:0x0061} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006d A:{SYNTHETIC, Splitter:B:22:0x006d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: Bz */
    private static String m75334Bz(String str) {
        Throwable th;
        FileOutputStream fileOutputStream;
        AppMethodBeat.m2504i(131299);
        byte[] decode = Base64.decode(str, 0);
        String str2;
        if (decode == null || decode.length == 0) {
            str2 = "";
            AppMethodBeat.m2505o(131299);
            return str2;
        }
        File file = new File(C4996ah.getContext().getCacheDir(), "preview_" + System.currentTimeMillis() + "_" + str.hashCode());
        FileOutputStream fileOutputStream2 = null;
        try {
            FileOutputStream fileOutputStream3 = new FileOutputStream(file);
            try {
                fileOutputStream3.write(decode);
                try {
                    fileOutputStream3.close();
                } catch (IOException e) {
                }
                str2 = file.getAbsolutePath();
                AppMethodBeat.m2505o(131299);
                return str2;
            } catch (Exception e2) {
                fileOutputStream2 = fileOutputStream3;
                str2 = "";
                if (fileOutputStream2 != null) {
                }
                AppMethodBeat.m2505o(131299);
                return str2;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream3;
                if (fileOutputStream != null) {
                }
                AppMethodBeat.m2505o(131299);
                throw th;
            }
        } catch (Exception e3) {
            str2 = "";
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e4) {
                }
            }
            AppMethodBeat.m2505o(131299);
            return str2;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e5) {
                }
            }
            AppMethodBeat.m2505o(131299);
            throw th;
        }
    }
}

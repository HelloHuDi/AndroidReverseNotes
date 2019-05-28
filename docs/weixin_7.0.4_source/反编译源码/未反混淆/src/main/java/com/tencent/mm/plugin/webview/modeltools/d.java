package com.tencent.mm.plugin.webview.modeltools;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.model.ap;
import com.tencent.mm.plugin.webview.ui.tools.k;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.io.File;

public final class d {
    private String uoA = null;
    private String uoB = null;
    private ValueCallback<Uri> uoC = null;
    private ValueCallback<Uri[]> uoD = null;
    public Pair<Intent, Integer> uoE = null;

    public final boolean b(MMActivity mMActivity, int i, int i2, Intent intent) {
        AppMethodBeat.i(6926);
        if (this.uoE != null) {
            AppMethodBeat.o(6926);
            return true;
        } else if (i == 1) {
            b(mMActivity, i2, intent);
            AppMethodBeat.o(6926);
            return true;
        } else {
            AppMethodBeat.o(6926);
            return false;
        }
    }

    private Uri a(MMActivity mMActivity, int i, Intent intent) {
        AppMethodBeat.i(6927);
        if (i != -1) {
            AppMethodBeat.o(6927);
            return null;
        }
        Uri uri;
        String str = null;
        if (intent != null) {
            uri = null;
            if (intent.getData() == null) {
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    uri = extras.getParcelable("android.intent.extra.STREAM") != null ? (Uri) extras.getParcelable("android.intent.extra.STREAM") : null;
                }
            } else {
                uri = intent.getData();
            }
            str = bo.h(mMActivity, uri);
            ab.i("MicroMsg.WebViewUI.FileChooser", "get file path:[%s]", str);
        }
        if (bo.isNullOrNil(str)) {
            File file = new File(ap.aez(this.uoB));
            if (file.exists()) {
                uri = Uri.fromFile(file);
                AppMethodBeat.o(6927);
                return uri;
            }
            AppMethodBeat.o(6927);
            return null;
        }
        Object obj;
        String ako = u.ako(str);
        ab.d("MicroMsg.WebViewUI.FileChooser", "get file mime type [%s]", ako);
        if (bo.isNullOrNil(this.uoA)) {
            obj = 1;
        } else {
            for (String replace : this.uoA.split(",")) {
                boolean z;
                String replace2 = replace2.replace(" ", "");
                if (bo.isNullOrNil(replace2)) {
                    z = true;
                } else {
                    if (!bo.isNullOrNil(ako)) {
                        if (replace2.contains("/") && ako.contains("/")) {
                            String[] split = replace2.split("/");
                            String[] split2 = ako.split("/");
                            if (bo.nullAsNil(split[0]).equals(split2[0])) {
                                z = bo.nullAsNil(split[1]).equals("*") || bo.nullAsNil(split[1]).equals(split2[1]);
                            }
                        } else {
                            z = replace2.equals(ako);
                        }
                    }
                    z = false;
                }
                if (z) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
        }
        if (obj == null) {
            AppMethodBeat.o(6927);
            return null;
        } else if (intent.getData() == null) {
            uri = Uri.fromFile(new File(str));
            AppMethodBeat.o(6927);
            return uri;
        } else {
            uri = intent.getData();
            AppMethodBeat.o(6927);
            return uri;
        }
    }

    public final void b(MMActivity mMActivity, int i, Intent intent) {
        AppMethodBeat.i(6928);
        if (this.uoC == null && this.uoD == null) {
            ab.w("MicroMsg.WebViewUI.FileChooser", "uploadFileCallback is null.");
            AppMethodBeat.o(6928);
            return;
        }
        Uri a = a(mMActivity, i, intent);
        ab.d("MicroMsg.WebViewUI.FileChooser", "result = ".concat(String.valueOf(a)));
        r(a);
        cYx();
        AppMethodBeat.o(6928);
    }

    public final void a(Activity activity, k kVar, ValueCallback<Uri> valueCallback, ValueCallback<Uri[]> valueCallback2, String str, String str2) {
        AppMethodBeat.i(6929);
        ab.i("MicroMsg.WebViewUI.FileChooser", "openFileChooser with wvPerm(%s), callback(%s), callbackLL(%s), acceptType(%s), capture(%s)", kVar, valueCallback, valueCallback2, str, str2);
        cYx();
        if (kVar == null || kVar.cZS() == null) {
            ab.e("MicroMsg.WebViewUI.FileChooser", "openFileChooser fail, wvPerm is null");
            r(null);
            AppMethodBeat.o(6929);
        } else if (kVar.cZS().jB(56)) {
            this.uoC = valueCallback;
            this.uoD = valueCallback2;
            this.uoB = System.currentTimeMillis();
            this.uoA = str;
            Intent av = ap.av(str, aeS(str2), this.uoB);
            if (b.o(activity, "android.permission.CAMERA")) {
                try {
                    activity.startActivityForResult(av, 1);
                    AppMethodBeat.o(6929);
                    return;
                } catch (Exception e) {
                    ab.e("MicroMsg.WebViewUI.FileChooser", "openFileChooser e = %s", e);
                    AppMethodBeat.o(6929);
                    return;
                }
            }
            b.b(activity, "android.permission.CAMERA", com.tencent.view.d.MIC_AVROUND_BLUR);
            this.uoE = Pair.create(av, Integer.valueOf(1));
            ab.e("MicroMsg.WebViewUI.FileChooser", "openFileChooser no Permission");
            AppMethodBeat.o(6929);
        } else {
            ab.e("MicroMsg.WebViewUI.FileChooser", "open file chooser failed, permission fail");
            r(null);
            AppMethodBeat.o(6929);
        }
    }

    private static String aeS(String str) {
        AppMethodBeat.i(6930);
        if ("user".equalsIgnoreCase(str) || "environment".equalsIgnoreCase(str)) {
            str = "true";
            AppMethodBeat.o(6930);
            return str;
        }
        AppMethodBeat.o(6930);
        return str;
    }

    public final void cYx() {
        this.uoA = null;
        this.uoC = null;
        this.uoD = null;
        this.uoB = null;
        this.uoE = null;
    }

    private void r(Uri uri) {
        AppMethodBeat.i(6931);
        if (this.uoC != null) {
            this.uoC.onReceiveValue(uri);
            AppMethodBeat.o(6931);
            return;
        }
        if (this.uoD != null) {
            if (uri == null) {
                this.uoD.onReceiveValue(null);
                AppMethodBeat.o(6931);
                return;
            }
            this.uoD.onReceiveValue(new Uri[]{uri});
        }
        AppMethodBeat.o(6931);
    }
}

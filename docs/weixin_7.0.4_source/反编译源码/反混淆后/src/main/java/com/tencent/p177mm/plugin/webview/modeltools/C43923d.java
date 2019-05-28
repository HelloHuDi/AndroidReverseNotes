package com.tencent.p177mm.plugin.webview.modeltools;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.webview.model.C43914ap;
import com.tencent.p177mm.plugin.webview.p580ui.tools.C40344k;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C30152u;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.view.C31128d;
import java.io.File;

/* renamed from: com.tencent.mm.plugin.webview.modeltools.d */
public final class C43923d {
    private String uoA = null;
    private String uoB = null;
    private ValueCallback<Uri> uoC = null;
    private ValueCallback<Uri[]> uoD = null;
    public Pair<Intent, Integer> uoE = null;

    /* renamed from: b */
    public final boolean mo69606b(MMActivity mMActivity, int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(6926);
        if (this.uoE != null) {
            AppMethodBeat.m2505o(6926);
            return true;
        } else if (i == 1) {
            mo69605b(mMActivity, i2, intent);
            AppMethodBeat.m2505o(6926);
            return true;
        } else {
            AppMethodBeat.m2505o(6926);
            return false;
        }
    }

    /* renamed from: a */
    private Uri m78782a(MMActivity mMActivity, int i, Intent intent) {
        AppMethodBeat.m2504i(6927);
        if (i != -1) {
            AppMethodBeat.m2505o(6927);
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
            str = C5046bo.m7568h(mMActivity, uri);
            C4990ab.m7417i("MicroMsg.WebViewUI.FileChooser", "get file path:[%s]", str);
        }
        if (C5046bo.isNullOrNil(str)) {
            File file = new File(C43914ap.aez(this.uoB));
            if (file.exists()) {
                uri = Uri.fromFile(file);
                AppMethodBeat.m2505o(6927);
                return uri;
            }
            AppMethodBeat.m2505o(6927);
            return null;
        }
        Object obj;
        String ako = C30152u.ako(str);
        C4990ab.m7411d("MicroMsg.WebViewUI.FileChooser", "get file mime type [%s]", ako);
        if (C5046bo.isNullOrNil(this.uoA)) {
            obj = 1;
        } else {
            for (String replace : this.uoA.split(",")) {
                boolean z;
                String replace2 = replace2.replace(" ", "");
                if (C5046bo.isNullOrNil(replace2)) {
                    z = true;
                } else {
                    if (!C5046bo.isNullOrNil(ako)) {
                        if (replace2.contains("/") && ako.contains("/")) {
                            String[] split = replace2.split("/");
                            String[] split2 = ako.split("/");
                            if (C5046bo.nullAsNil(split[0]).equals(split2[0])) {
                                z = C5046bo.nullAsNil(split[1]).equals("*") || C5046bo.nullAsNil(split[1]).equals(split2[1]);
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
            AppMethodBeat.m2505o(6927);
            return null;
        } else if (intent.getData() == null) {
            uri = Uri.fromFile(new File(str));
            AppMethodBeat.m2505o(6927);
            return uri;
        } else {
            uri = intent.getData();
            AppMethodBeat.m2505o(6927);
            return uri;
        }
    }

    /* renamed from: b */
    public final void mo69605b(MMActivity mMActivity, int i, Intent intent) {
        AppMethodBeat.m2504i(6928);
        if (this.uoC == null && this.uoD == null) {
            C4990ab.m7420w("MicroMsg.WebViewUI.FileChooser", "uploadFileCallback is null.");
            AppMethodBeat.m2505o(6928);
            return;
        }
        Uri a = m78782a(mMActivity, i, intent);
        C4990ab.m7410d("MicroMsg.WebViewUI.FileChooser", "result = ".concat(String.valueOf(a)));
        m78783r(a);
        cYx();
        AppMethodBeat.m2505o(6928);
    }

    /* renamed from: a */
    public final void mo69604a(Activity activity, C40344k c40344k, ValueCallback<Uri> valueCallback, ValueCallback<Uri[]> valueCallback2, String str, String str2) {
        AppMethodBeat.m2504i(6929);
        C4990ab.m7417i("MicroMsg.WebViewUI.FileChooser", "openFileChooser with wvPerm(%s), callback(%s), callbackLL(%s), acceptType(%s), capture(%s)", c40344k, valueCallback, valueCallback2, str, str2);
        cYx();
        if (c40344k == null || c40344k.cZS() == null) {
            C4990ab.m7412e("MicroMsg.WebViewUI.FileChooser", "openFileChooser fail, wvPerm is null");
            m78783r(null);
            AppMethodBeat.m2505o(6929);
        } else if (c40344k.cZS().mo69833jB(56)) {
            this.uoC = valueCallback;
            this.uoD = valueCallback2;
            this.uoB = System.currentTimeMillis();
            this.uoA = str;
            Intent av = C43914ap.m78769av(str, C43923d.aeS(str2), this.uoB);
            if (C35805b.m58714o(activity, "android.permission.CAMERA")) {
                try {
                    activity.startActivityForResult(av, 1);
                    AppMethodBeat.m2505o(6929);
                    return;
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.WebViewUI.FileChooser", "openFileChooser e = %s", e);
                    AppMethodBeat.m2505o(6929);
                    return;
                }
            }
            C35805b.m58709b(activity, "android.permission.CAMERA", C31128d.MIC_AVROUND_BLUR);
            this.uoE = Pair.create(av, Integer.valueOf(1));
            C4990ab.m7412e("MicroMsg.WebViewUI.FileChooser", "openFileChooser no Permission");
            AppMethodBeat.m2505o(6929);
        } else {
            C4990ab.m7412e("MicroMsg.WebViewUI.FileChooser", "open file chooser failed, permission fail");
            m78783r(null);
            AppMethodBeat.m2505o(6929);
        }
    }

    private static String aeS(String str) {
        AppMethodBeat.m2504i(6930);
        if ("user".equalsIgnoreCase(str) || "environment".equalsIgnoreCase(str)) {
            str = "true";
            AppMethodBeat.m2505o(6930);
            return str;
        }
        AppMethodBeat.m2505o(6930);
        return str;
    }

    public final void cYx() {
        this.uoA = null;
        this.uoC = null;
        this.uoD = null;
        this.uoB = null;
        this.uoE = null;
    }

    /* renamed from: r */
    private void m78783r(Uri uri) {
        AppMethodBeat.m2504i(6931);
        if (this.uoC != null) {
            this.uoC.onReceiveValue(uri);
            AppMethodBeat.m2505o(6931);
            return;
        }
        if (this.uoD != null) {
            if (uri == null) {
                this.uoD.onReceiveValue(null);
                AppMethodBeat.m2505o(6931);
                return;
            }
            this.uoD.onReceiveValue(new Uri[]{uri});
        }
        AppMethodBeat.m2505o(6931);
    }
}

package com.tencent.p177mm.plugin.webview;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5018as;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.xweb.WebView;
import org.p1430a.C41166a;

/* renamed from: com.tencent.mm.plugin.webview.b */
public final class C14447b {
    public C44275p tipDialog;
    private final int uew = 0;
    private final int uex = 1;
    private final int uey = 2;

    /* renamed from: com.tencent.mm.plugin.webview.b$2 */
    public class C144482 implements C5681a<Integer, Void> {
        final /* synthetic */ Activity ghG;
        final /* synthetic */ WebView ueD;
        final /* synthetic */ boolean ueE;

        public C144482(Activity activity, WebView webView, boolean z) {
            this.ghG = activity;
            this.ueD = webView;
            this.ueE = z;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(5618);
            if (this.ghG.isFinishing()) {
                Integer valueOf = Integer.valueOf(2);
                AppMethodBeat.m2505o(5618);
                return valueOf;
            }
            Object valueOf2 = Integer.valueOf(C14447b.m22671a(this.ueD, this.ueE));
            AppMethodBeat.m2505o(5618);
            return valueOf2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.b$1 */
    public class C144491 implements C5681a<Void, Integer> {
        final /* synthetic */ Activity ghG;
        final /* synthetic */ String uez;

        public C144491(Activity activity, String str) {
            this.ghG = activity;
            this.uez = str;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(5617);
            Integer num = (Integer) obj;
            if (C14447b.this.tipDialog != null && C14447b.this.tipDialog.isShowing()) {
                C14447b.this.tipDialog.dismiss();
                C14447b.this.tipDialog = null;
            }
            if (!this.ghG.isFinishing()) {
                if (num.intValue() != 0) {
                    if (num.intValue() == 1) {
                        C30379h.m48443a(this.ghG, this.ghG.getString(C25738R.string.fz5), "", this.ghG.getString(C25738R.string.f9151r4), null);
                    } else if (C5023at.isConnected(C4996ah.getContext())) {
                        C30379h.m48443a(this.ghG, this.ghG.getString(C25738R.string.fz7), "", this.ghG.getString(C25738R.string.f9151r4), null);
                    } else {
                        C30379h.m48443a(this.ghG, this.ghG.getString(C25738R.string.d5l), "", this.ghG.getString(C25738R.string.f9151r4), null);
                    }
                    AppMethodBeat.m2505o(5617);
                    return null;
                }
                final C5018as eg = C5018as.m7465eg("key_webview_translate", 2);
                if (eg.decodeBool("show_security_dialog", true)) {
                    C30379h.m48466d(this.ghG, this.ghG.getString(C25738R.string.fz9), this.ghG.getString(C25738R.string.fz_), this.ghG.getString(C25738R.string.f9187s6), this.ghG.getString(C25738R.string.f9076or), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(5616);
                            C14447b.adX(C144491.this.uez);
                            eg.encode("show_security_dialog", false);
                            eg.apply();
                            AppMethodBeat.m2505o(5616);
                        }
                    }, null);
                } else {
                    C14447b.adX(this.uez);
                }
            }
            AppMethodBeat.m2505o(5617);
            return null;
        }
    }

    /* renamed from: b */
    public static boolean m22672b(WebView webView) {
        AppMethodBeat.m2504i(5619);
        if (webView.getX5WebViewExtension() == null) {
            AppMethodBeat.m2505o(5619);
            return false;
        }
        boolean z;
        try {
            Bundle bundle = (Bundle) C41166a.m71622ep(webView.getX5WebViewExtension()).mo65761u("invokeMiscMethod", "supportTranslateWebSite", null).object;
            if (bundle != null) {
                z = bundle.getBoolean("result");
                C4990ab.m7417i("MicroMsg.WebViewTranslateHelper", "supportTranslate %b", Boolean.valueOf(z));
                AppMethodBeat.m2505o(5619);
                return z;
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.WebViewTranslateHelper", "supportTranslateWebSite error %s", e.getMessage());
        }
        z = false;
        C4990ab.m7417i("MicroMsg.WebViewTranslateHelper", "supportTranslate %b", Boolean.valueOf(z));
        AppMethodBeat.m2505o(5619);
        return z;
    }

    /* renamed from: a */
    public static int m22671a(WebView webView, boolean z) {
        AppMethodBeat.m2504i(5620);
        if (webView == null || webView.getX5WebViewExtension() == null) {
            AppMethodBeat.m2505o(5620);
            return 2;
        }
        int i;
        Bundle bundle = new Bundle();
        bundle.putString("destLanguage", C4988aa.dor());
        if (z) {
            bundle.putBoolean("isFastOpen", true);
        } else {
            bundle.putBoolean("isFastOpen", false);
        }
        try {
            bundle = (Bundle) C41166a.m71622ep(webView.getX5WebViewExtension()).mo65761u("invokeMiscMethod", "detectTranslateWebSiteIsNeeded", bundle).object;
            if (bundle != null) {
                i = bundle.getInt(OpenSDKTool4Assistant.EXTRA_ERROR_CODE, 2);
                C4990ab.m7417i("MicroMsg.WebViewTranslateHelper", "needTranslate errCode %d,languageCode %s", Integer.valueOf(i), r2);
                AppMethodBeat.m2505o(5620);
                return i;
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.WebViewTranslateHelper", "detectTranslateWebSiteIsNeeded error %s", e.getMessage());
        }
        i = 2;
        C4990ab.m7417i("MicroMsg.WebViewTranslateHelper", "needTranslate errCode %d,languageCode %s", Integer.valueOf(i), r2);
        AppMethodBeat.m2505o(5620);
        return i;
    }

    static /* synthetic */ void adX(String str) {
        AppMethodBeat.m2504i(5621);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("hide_option_menu", true);
        intent.putExtra("translate_webview", true);
        C25985d.m41467b(C4996ah.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.m2505o(5621);
    }
}

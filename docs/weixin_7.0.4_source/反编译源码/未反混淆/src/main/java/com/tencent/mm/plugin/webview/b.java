package com.tencent.mm.plugin.webview;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.vending.c.a;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.xweb.WebView;

public final class b {
    public p tipDialog;
    private final int uew = 0;
    private final int uex = 1;
    private final int uey = 2;

    /* renamed from: com.tencent.mm.plugin.webview.b$2 */
    public class AnonymousClass2 implements a<Integer, Void> {
        final /* synthetic */ Activity ghG;
        final /* synthetic */ WebView ueD;
        final /* synthetic */ boolean ueE;

        public AnonymousClass2(Activity activity, WebView webView, boolean z) {
            this.ghG = activity;
            this.ueD = webView;
            this.ueE = z;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(5618);
            if (this.ghG.isFinishing()) {
                Integer valueOf = Integer.valueOf(2);
                AppMethodBeat.o(5618);
                return valueOf;
            }
            Object valueOf2 = Integer.valueOf(b.a(this.ueD, this.ueE));
            AppMethodBeat.o(5618);
            return valueOf2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.b$1 */
    public class AnonymousClass1 implements a<Void, Integer> {
        final /* synthetic */ Activity ghG;
        final /* synthetic */ String uez;

        public AnonymousClass1(Activity activity, String str) {
            this.ghG = activity;
            this.uez = str;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(5617);
            Integer num = (Integer) obj;
            if (b.this.tipDialog != null && b.this.tipDialog.isShowing()) {
                b.this.tipDialog.dismiss();
                b.this.tipDialog = null;
            }
            if (!this.ghG.isFinishing()) {
                if (num.intValue() != 0) {
                    if (num.intValue() == 1) {
                        h.a(this.ghG, this.ghG.getString(R.string.fz5), "", this.ghG.getString(R.string.r4), null);
                    } else if (at.isConnected(ah.getContext())) {
                        h.a(this.ghG, this.ghG.getString(R.string.fz7), "", this.ghG.getString(R.string.r4), null);
                    } else {
                        h.a(this.ghG, this.ghG.getString(R.string.d5l), "", this.ghG.getString(R.string.r4), null);
                    }
                    AppMethodBeat.o(5617);
                    return null;
                }
                final as eg = as.eg("key_webview_translate", 2);
                if (eg.decodeBool("show_security_dialog", true)) {
                    h.d(this.ghG, this.ghG.getString(R.string.fz9), this.ghG.getString(R.string.fz_), this.ghG.getString(R.string.s6), this.ghG.getString(R.string.or), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(5616);
                            b.adX(AnonymousClass1.this.uez);
                            eg.encode("show_security_dialog", false);
                            eg.apply();
                            AppMethodBeat.o(5616);
                        }
                    }, null);
                } else {
                    b.adX(this.uez);
                }
            }
            AppMethodBeat.o(5617);
            return null;
        }
    }

    public static boolean b(WebView webView) {
        AppMethodBeat.i(5619);
        if (webView.getX5WebViewExtension() == null) {
            AppMethodBeat.o(5619);
            return false;
        }
        boolean z;
        try {
            Bundle bundle = (Bundle) org.a.a.ep(webView.getX5WebViewExtension()).u("invokeMiscMethod", "supportTranslateWebSite", null).object;
            if (bundle != null) {
                z = bundle.getBoolean("result");
                ab.i("MicroMsg.WebViewTranslateHelper", "supportTranslate %b", Boolean.valueOf(z));
                AppMethodBeat.o(5619);
                return z;
            }
        } catch (Exception e) {
            ab.e("MicroMsg.WebViewTranslateHelper", "supportTranslateWebSite error %s", e.getMessage());
        }
        z = false;
        ab.i("MicroMsg.WebViewTranslateHelper", "supportTranslate %b", Boolean.valueOf(z));
        AppMethodBeat.o(5619);
        return z;
    }

    public static int a(WebView webView, boolean z) {
        AppMethodBeat.i(5620);
        if (webView == null || webView.getX5WebViewExtension() == null) {
            AppMethodBeat.o(5620);
            return 2;
        }
        int i;
        Bundle bundle = new Bundle();
        bundle.putString("destLanguage", aa.dor());
        if (z) {
            bundle.putBoolean("isFastOpen", true);
        } else {
            bundle.putBoolean("isFastOpen", false);
        }
        try {
            bundle = (Bundle) org.a.a.ep(webView.getX5WebViewExtension()).u("invokeMiscMethod", "detectTranslateWebSiteIsNeeded", bundle).object;
            if (bundle != null) {
                i = bundle.getInt(OpenSDKTool4Assistant.EXTRA_ERROR_CODE, 2);
                ab.i("MicroMsg.WebViewTranslateHelper", "needTranslate errCode %d,languageCode %s", Integer.valueOf(i), r2);
                AppMethodBeat.o(5620);
                return i;
            }
        } catch (Exception e) {
            ab.e("MicroMsg.WebViewTranslateHelper", "detectTranslateWebSiteIsNeeded error %s", e.getMessage());
        }
        i = 2;
        ab.i("MicroMsg.WebViewTranslateHelper", "needTranslate errCode %d,languageCode %s", Integer.valueOf(i), r2);
        AppMethodBeat.o(5620);
        return i;
    }

    static /* synthetic */ void adX(String str) {
        AppMethodBeat.i(5621);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("hide_option_menu", true);
        intent.putExtra("translate_webview", true);
        d.b(ah.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(5621);
    }
}

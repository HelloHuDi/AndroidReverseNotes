package com.tencent.mm.plugin.websearch.api;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.storage.c;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;

public final class ap {
    private static ap ubl = new ap();
    private SharedPreferences ubh = ar.s(ah.getContext(), "com.tencent.mm.plugin.websearch.WebSearchXWeb", 4);
    private volatile boolean ubi = this.ubh.getBoolean("isUseSysWebview", false);
    private long ubj;
    private boolean ubk = false;
    private long ubm;

    static {
        AppMethodBeat.i(124257);
        AppMethodBeat.o(124257);
    }

    public ap() {
        AppMethodBeat.i(124252);
        cVE();
        AppMethodBeat.o(124252);
    }

    private void cVE() {
        AppMethodBeat.i(124253);
        if (System.currentTimeMillis() - this.ubm < 7200000) {
            AppMethodBeat.o(124253);
            return;
        }
        this.ubm = System.currentTimeMillis();
        d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(124250);
                a aVar = b.eGM;
                c ll = a.ll("100387");
                if (ll == null) {
                    ab.i("WebSearchXWeb", "openSearchPreload item is null");
                    AppMethodBeat.o(124250);
                    return;
                }
                ap apVar = ap.this;
                boolean z = ll.isValid() && "1".equals(ll.dru().get("isOpen"));
                apVar.ubk = z;
                AppMethodBeat.o(124250);
            }
        }, "WebSearchXWeb-getSwitch");
        AppMethodBeat.o(124253);
    }

    public static ap cVF() {
        return ubl;
    }

    public final boolean cVG() {
        AppMethodBeat.i(124254);
        cVE();
        String str = Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            ab.i("WebSearchXWeb", "brand is empty");
            AppMethodBeat.o(124254);
            return false;
        } else if (str.contains("huawei") || str.contains("honor")) {
            ab.i("WebSearchXWeb", "huawei not support sys webview");
            AppMethodBeat.o(124254);
            return false;
        } else if (this.ubk) {
            if (this.ubj == 0) {
                this.ubj = this.ubh.getLong("lastCheckTimestamp", 0);
            }
            if (System.currentTimeMillis() - this.ubj > 86400000) {
                cVH();
                this.ubj = System.currentTimeMillis();
                this.ubh.edit().putLong("lastCheckTimestamp", this.ubj).commit();
            }
            boolean z = this.ubi;
            AppMethodBeat.o(124254);
            return z;
        } else {
            ab.i("WebSearchXWeb", "check use sys webview switch close");
            AppMethodBeat.o(124254);
            return false;
        }
    }

    private void cVH() {
        AppMethodBeat.i(124255);
        final MMWebView im = MMWebView.a.im(ah.getContext());
        final MMWebView in = MMWebView.a.in(ah.getContext());
        d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(124251);
                try {
                    if (WebView.getTbsCoreVersion(ah.getContext()) == 0) {
                        h.pYm.e(15367, Integer.valueOf(1));
                        AppMethodBeat.o(124251);
                    } else if (com.tencent.xweb.x5.sdk.d.canOpenWebPlus(ah.getContext())) {
                        ab.i("WebSearchXWeb", "begin check use sys webview");
                        if (ap.a(im) > ap.a(in)) {
                            h.pYm.e(15367, Integer.valueOf(2));
                            ap.this.ubi = true;
                        } else {
                            h.pYm.e(15367, Integer.valueOf(3));
                            ap.this.ubi = false;
                        }
                        ab.i("WebSearchXWeb", "end  check use sys webview, isUseSysWebview %b", Boolean.valueOf(ap.this.ubi));
                        ap.this.ubh.edit().putBoolean("isUseSysWebview", ap.this.ubi).commit();
                        AppMethodBeat.o(124251);
                    } else {
                        h.pYm.e(15367, Integer.valueOf(1));
                        AppMethodBeat.o(124251);
                    }
                } catch (Exception e) {
                    ab.e("WebSearchXWeb", "", e);
                    AppMethodBeat.o(124251);
                }
            }
        }, "WebSearchXWeb.check");
        AppMethodBeat.o(124255);
    }
}

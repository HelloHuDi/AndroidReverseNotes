package com.tencent.p177mm.plugin.websearch.api;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.wx_extension.p1463a.C42142a;
import com.tencent.p177mm.ipcinvoker.wx_extension.p1463a.C42142a.C32718b;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.p177mm.p612ui.widget.MMWebView.C30798a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C30284ar;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.storage.C5141c;
import com.tencent.xweb.WebView;
import com.tencent.xweb.p685x5.sdk.C24544d;

/* renamed from: com.tencent.mm.plugin.websearch.api.ap */
public final class C35575ap {
    private static C35575ap ubl = new C35575ap();
    private SharedPreferences ubh = C30284ar.m48183s(C4996ah.getContext(), "com.tencent.mm.plugin.websearch.WebSearchXWeb", 4);
    private volatile boolean ubi = this.ubh.getBoolean("isUseSysWebview", false);
    private long ubj;
    private boolean ubk = false;
    private long ubm;

    /* renamed from: com.tencent.mm.plugin.websearch.api.ap$1 */
    class C45161 implements Runnable {
        C45161() {
        }

        public final void run() {
            AppMethodBeat.m2504i(124250);
            C42142a c42142a = C32718b.eGM;
            C5141c ll = C42142a.m74295ll("100387");
            if (ll == null) {
                C4990ab.m7416i("WebSearchXWeb", "openSearchPreload item is null");
                AppMethodBeat.m2505o(124250);
                return;
            }
            C35575ap c35575ap = C35575ap.this;
            boolean z = ll.isValid() && "1".equals(ll.dru().get("isOpen"));
            c35575ap.ubk = z;
            AppMethodBeat.m2505o(124250);
        }
    }

    static {
        AppMethodBeat.m2504i(124257);
        AppMethodBeat.m2505o(124257);
    }

    public C35575ap() {
        AppMethodBeat.m2504i(124252);
        cVE();
        AppMethodBeat.m2505o(124252);
    }

    private void cVE() {
        AppMethodBeat.m2504i(124253);
        if (System.currentTimeMillis() - this.ubm < 7200000) {
            AppMethodBeat.m2505o(124253);
            return;
        }
        this.ubm = System.currentTimeMillis();
        C7305d.post(new C45161(), "WebSearchXWeb-getSwitch");
        AppMethodBeat.m2505o(124253);
    }

    public static C35575ap cVF() {
        return ubl;
    }

    public final boolean cVG() {
        AppMethodBeat.m2504i(124254);
        cVE();
        String str = Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            C4990ab.m7416i("WebSearchXWeb", "brand is empty");
            AppMethodBeat.m2505o(124254);
            return false;
        } else if (str.contains("huawei") || str.contains("honor")) {
            C4990ab.m7416i("WebSearchXWeb", "huawei not support sys webview");
            AppMethodBeat.m2505o(124254);
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
            AppMethodBeat.m2505o(124254);
            return z;
        } else {
            C4990ab.m7416i("WebSearchXWeb", "check use sys webview switch close");
            AppMethodBeat.m2505o(124254);
            return false;
        }
    }

    private void cVH() {
        AppMethodBeat.m2504i(124255);
        final MMWebView im = C30798a.m49144im(C4996ah.getContext());
        final MMWebView in = C30798a.m49145in(C4996ah.getContext());
        C7305d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(124251);
                try {
                    if (WebView.getTbsCoreVersion(C4996ah.getContext()) == 0) {
                        C7060h.pYm.mo8381e(15367, Integer.valueOf(1));
                        AppMethodBeat.m2505o(124251);
                    } else if (C24544d.canOpenWebPlus(C4996ah.getContext())) {
                        C4990ab.m7416i("WebSearchXWeb", "begin check use sys webview");
                        if (C35575ap.m58398a(im) > C35575ap.m58398a(in)) {
                            C7060h.pYm.mo8381e(15367, Integer.valueOf(2));
                            C35575ap.this.ubi = true;
                        } else {
                            C7060h.pYm.mo8381e(15367, Integer.valueOf(3));
                            C35575ap.this.ubi = false;
                        }
                        C4990ab.m7417i("WebSearchXWeb", "end  check use sys webview, isUseSysWebview %b", Boolean.valueOf(C35575ap.this.ubi));
                        C35575ap.this.ubh.edit().putBoolean("isUseSysWebview", C35575ap.this.ubi).commit();
                        AppMethodBeat.m2505o(124251);
                    } else {
                        C7060h.pYm.mo8381e(15367, Integer.valueOf(1));
                        AppMethodBeat.m2505o(124251);
                    }
                } catch (Exception e) {
                    C4990ab.m7413e("WebSearchXWeb", "", e);
                    AppMethodBeat.m2505o(124251);
                }
            }
        }, "WebSearchXWeb.check");
        AppMethodBeat.m2505o(124255);
    }
}

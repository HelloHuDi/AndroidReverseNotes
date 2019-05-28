package com.tencent.p177mm.plugin.webview.p580ui.tools;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.p177mm.plugin.webview.p1068e.C43867e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.o */
public final class C23144o {
    String iCz;
    MMWebView pzp;
    boolean uxW = false;
    WebViewUI uxX;

    public C23144o(WebViewUI webViewUI) {
        this.uxX = webViewUI;
    }

    /* Access modifiers changed, original: final */
    public final boolean daQ() {
        AppMethodBeat.m2504i(8135);
        if (this.uxX.aMj()) {
            AppMethodBeat.m2505o(8135);
            return true;
        }
        Intent intent = this.uxX.getIntent();
        if (intent != null) {
            if (intent.getBooleanExtra("disable_light_actionbar_style", false)) {
                C4990ab.m7416i("MicroMsg.WebViewUIStyleHelper", "checkDisableLightActionbarStyle, KDisableLightActionbarStyle is true");
                AppMethodBeat.m2505o(8135);
                return true;
            }
            String stringExtra = intent.getStringExtra("status_bar_style");
            if (!C5046bo.isNullOrNil(stringExtra) && stringExtra.equals("black")) {
                C4990ab.m7416i("MicroMsg.WebViewUIStyleHelper", "checkDisableLightActionbarStyle, customized by KStatusBarStyle");
                AppMethodBeat.m2505o(8135);
                return true;
            } else if (intent.getIntExtra("customize_status_bar_color", 0) != 0) {
                C4990ab.m7416i("MicroMsg.WebViewUIStyleHelper", "checkDisableLightActionbarStyle, customized by KCustomizeStatusBarColor");
                AppMethodBeat.m2505o(8135);
                return true;
            } else if (intent.getBooleanExtra("open_custom_style_url", false)) {
                C4990ab.m7416i("MicroMsg.WebViewUIStyleHelper", "checkDisableLightActionbarStyle, customized by KOpenCustomStyleUrl");
                AppMethodBeat.m2505o(8135);
                return true;
            } else if (intent.getBooleanExtra("show_full_screen", false)) {
                C4990ab.m7416i("MicroMsg.WebViewUIStyleHelper", "checkDisableLightActionbarStyle, webview is fullscreen");
                AppMethodBeat.m2505o(8135);
                return true;
            }
        }
        AppMethodBeat.m2505o(8135);
        return false;
    }

    /* Access modifiers changed, original: final */
    public final void daR() {
        AppMethodBeat.m2504i(8136);
        daT();
        daS();
        daU();
        AppMethodBeat.m2505o(8136);
    }

    @SuppressLint({"ResourceType"})
    private void daS() {
        AppMethodBeat.m2504i(8137);
        View findViewById = this.uxX.findViewById(2131824656);
        if (findViewById != null) {
            findViewById.setBackgroundColor(daW());
        }
        int color = this.uxX.getResources().getColor(C25738R.color.a5y);
        findViewById = this.uxX.findViewById(2131829179);
        if (findViewById != null && (findViewById instanceof TextView)) {
            ((TextView) findViewById).setTextColor(color);
        }
        findViewById = this.uxX.findViewById(2131829181);
        if (findViewById != null && (findViewById instanceof TextView)) {
            ((TextView) findViewById).setTextColor(color);
        }
        findViewById = this.uxX.findViewById(2131829180);
        if (findViewById != null && (findViewById instanceof ImageView)) {
            ((ImageView) findViewById).setImageResource(C1318a.webview_logo_qqbrowser_light);
        }
        AppMethodBeat.m2505o(8137);
    }

    private void daT() {
        AppMethodBeat.m2504i(8138);
        this.uxX.mo17446xE(daW());
        this.uxX.dyc();
        AppMethodBeat.m2505o(8138);
    }

    /* Access modifiers changed, original: final */
    public final void daU() {
        AppMethodBeat.m2504i(8139);
        if (!daV()) {
            this.uxX.dyc();
            AppMethodBeat.m2505o(8139);
        } else if (this.pzp == null || this.pzp.getWebScrollY() <= 0) {
            this.uxX.dyb();
            AppMethodBeat.m2505o(8139);
        } else {
            this.uxX.dyc();
            AppMethodBeat.m2505o(8139);
        }
    }

    private boolean daV() {
        AppMethodBeat.m2504i(8140);
        if (this.uxX == null) {
            AppMethodBeat.m2505o(8140);
            return false;
        }
        String str = this.iCz;
        if (C5046bo.isNullOrNil(str)) {
            str = this.uxX.cWL();
        }
        boolean agG = C43867e.agG(str);
        AppMethodBeat.m2505o(8140);
        return agG;
    }

    public final int daW() {
        AppMethodBeat.m2504i(8141);
        int color;
        if (daV()) {
            color = this.uxX.getResources().getColor(C25738R.color.a5x);
            AppMethodBeat.m2505o(8141);
            return color;
        }
        color = this.uxX.getResources().getColor(C25738R.color.a5s);
        AppMethodBeat.m2505o(8141);
        return color;
    }
}

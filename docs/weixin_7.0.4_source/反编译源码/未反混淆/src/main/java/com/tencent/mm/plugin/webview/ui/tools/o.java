package com.tencent.mm.plugin.webview.ui.tools;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMWebView;

public final class o {
    String iCz;
    MMWebView pzp;
    boolean uxW = false;
    WebViewUI uxX;

    public o(WebViewUI webViewUI) {
        this.uxX = webViewUI;
    }

    /* Access modifiers changed, original: final */
    public final boolean daQ() {
        AppMethodBeat.i(8135);
        if (this.uxX.aMj()) {
            AppMethodBeat.o(8135);
            return true;
        }
        Intent intent = this.uxX.getIntent();
        if (intent != null) {
            if (intent.getBooleanExtra("disable_light_actionbar_style", false)) {
                ab.i("MicroMsg.WebViewUIStyleHelper", "checkDisableLightActionbarStyle, KDisableLightActionbarStyle is true");
                AppMethodBeat.o(8135);
                return true;
            }
            String stringExtra = intent.getStringExtra("status_bar_style");
            if (!bo.isNullOrNil(stringExtra) && stringExtra.equals("black")) {
                ab.i("MicroMsg.WebViewUIStyleHelper", "checkDisableLightActionbarStyle, customized by KStatusBarStyle");
                AppMethodBeat.o(8135);
                return true;
            } else if (intent.getIntExtra("customize_status_bar_color", 0) != 0) {
                ab.i("MicroMsg.WebViewUIStyleHelper", "checkDisableLightActionbarStyle, customized by KCustomizeStatusBarColor");
                AppMethodBeat.o(8135);
                return true;
            } else if (intent.getBooleanExtra("open_custom_style_url", false)) {
                ab.i("MicroMsg.WebViewUIStyleHelper", "checkDisableLightActionbarStyle, customized by KOpenCustomStyleUrl");
                AppMethodBeat.o(8135);
                return true;
            } else if (intent.getBooleanExtra("show_full_screen", false)) {
                ab.i("MicroMsg.WebViewUIStyleHelper", "checkDisableLightActionbarStyle, webview is fullscreen");
                AppMethodBeat.o(8135);
                return true;
            }
        }
        AppMethodBeat.o(8135);
        return false;
    }

    /* Access modifiers changed, original: final */
    public final void daR() {
        AppMethodBeat.i(8136);
        daT();
        daS();
        daU();
        AppMethodBeat.o(8136);
    }

    @SuppressLint({"ResourceType"})
    private void daS() {
        AppMethodBeat.i(8137);
        View findViewById = this.uxX.findViewById(R.id.c_5);
        if (findViewById != null) {
            findViewById.setBackgroundColor(daW());
        }
        int color = this.uxX.getResources().getColor(R.color.a5y);
        findViewById = this.uxX.findViewById(R.id.fke);
        if (findViewById != null && (findViewById instanceof TextView)) {
            ((TextView) findViewById).setTextColor(color);
        }
        findViewById = this.uxX.findViewById(R.id.fkg);
        if (findViewById != null && (findViewById instanceof TextView)) {
            ((TextView) findViewById).setTextColor(color);
        }
        findViewById = this.uxX.findViewById(R.id.fkf);
        if (findViewById != null && (findViewById instanceof ImageView)) {
            ((ImageView) findViewById).setImageResource(R.raw.webview_logo_qqbrowser_light);
        }
        AppMethodBeat.o(8137);
    }

    private void daT() {
        AppMethodBeat.i(8138);
        this.uxX.xE(daW());
        this.uxX.dyc();
        AppMethodBeat.o(8138);
    }

    /* Access modifiers changed, original: final */
    public final void daU() {
        AppMethodBeat.i(8139);
        if (!daV()) {
            this.uxX.dyc();
            AppMethodBeat.o(8139);
        } else if (this.pzp == null || this.pzp.getWebScrollY() <= 0) {
            this.uxX.dyb();
            AppMethodBeat.o(8139);
        } else {
            this.uxX.dyc();
            AppMethodBeat.o(8139);
        }
    }

    private boolean daV() {
        AppMethodBeat.i(8140);
        if (this.uxX == null) {
            AppMethodBeat.o(8140);
            return false;
        }
        String str = this.iCz;
        if (bo.isNullOrNil(str)) {
            str = this.uxX.cWL();
        }
        boolean agG = e.agG(str);
        AppMethodBeat.o(8140);
        return agG;
    }

    public final int daW() {
        AppMethodBeat.i(8141);
        int color;
        if (daV()) {
            color = this.uxX.getResources().getColor(R.color.a5x);
            AppMethodBeat.o(8141);
            return color;
        }
        color = this.uxX.getResources().getColor(R.color.a5s);
        AppMethodBeat.o(8141);
        return color;
    }
}

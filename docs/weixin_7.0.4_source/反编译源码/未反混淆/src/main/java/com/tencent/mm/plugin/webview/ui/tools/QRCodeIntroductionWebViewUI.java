package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;

public class QRCodeIntroductionWebViewUI extends WebViewUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(7474);
        super.onCreate(bundle);
        addIconOptionMenu(0, R.drawable.uu, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(7471);
                QRCodeIntroductionWebViewUI.a(QRCodeIntroductionWebViewUI.this);
                AppMethodBeat.o(7471);
                return true;
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(7472);
                QRCodeIntroductionWebViewUI.this.finish();
                AppMethodBeat.o(7472);
                return true;
            }
        });
        AppMethodBeat.o(7474);
    }

    static /* synthetic */ void a(QRCodeIntroductionWebViewUI qRCodeIntroductionWebViewUI) {
        AppMethodBeat.i(7475);
        Context context = qRCodeIntroductionWebViewUI;
        h.a(context, "", new String[]{qRCodeIntroductionWebViewUI.getString(R.string.ens), qRCodeIntroductionWebViewUI.getString(R.string.dgg)}, "", false, new c() {
            public final void iE(int i) {
                AppMethodBeat.i(7473);
                switch (i) {
                    case 0:
                        QRCodeIntroductionWebViewUI.this.uhz.q(null);
                        AppMethodBeat.o(7473);
                        return;
                    case 1:
                        QRCodeIntroductionWebViewUI.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(QRCodeIntroductionWebViewUI.this.cWL())));
                        break;
                }
                AppMethodBeat.o(7473);
            }
        });
        AppMethodBeat.o(7475);
    }
}

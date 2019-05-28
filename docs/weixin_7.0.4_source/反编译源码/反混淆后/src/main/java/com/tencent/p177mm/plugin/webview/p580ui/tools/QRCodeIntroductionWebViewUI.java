package com.tencent.p177mm.plugin.webview.p580ui.tools;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.QRCodeIntroductionWebViewUI */
public class QRCodeIntroductionWebViewUI extends WebViewUI {

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.QRCodeIntroductionWebViewUI$3 */
    class C298613 implements C30391c {
        C298613() {
        }

        /* renamed from: iE */
        public final void mo7700iE(int i) {
            AppMethodBeat.m2504i(7473);
            switch (i) {
                case 0:
                    QRCodeIntroductionWebViewUI.this.uhz.mo71942q(null);
                    AppMethodBeat.m2505o(7473);
                    return;
                case 1:
                    QRCodeIntroductionWebViewUI.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(QRCodeIntroductionWebViewUI.this.cWL())));
                    break;
            }
            AppMethodBeat.m2505o(7473);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.QRCodeIntroductionWebViewUI$2 */
    class C356312 implements OnMenuItemClickListener {
        C356312() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(7472);
            QRCodeIntroductionWebViewUI.this.finish();
            AppMethodBeat.m2505o(7472);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.QRCodeIntroductionWebViewUI$1 */
    class C356321 implements OnMenuItemClickListener {
        C356321() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(7471);
            QRCodeIntroductionWebViewUI.m58487a(QRCodeIntroductionWebViewUI.this);
            AppMethodBeat.m2505o(7471);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(7474);
        super.onCreate(bundle);
        addIconOptionMenu(0, C25738R.drawable.f6899uu, new C356321());
        setBackBtn(new C356312());
        AppMethodBeat.m2505o(7474);
    }

    /* renamed from: a */
    static /* synthetic */ void m58487a(QRCodeIntroductionWebViewUI qRCodeIntroductionWebViewUI) {
        AppMethodBeat.m2504i(7475);
        Context context = qRCodeIntroductionWebViewUI;
        C30379h.m48424a(context, "", new String[]{qRCodeIntroductionWebViewUI.getString(C25738R.string.ens), qRCodeIntroductionWebViewUI.getString(C25738R.string.dgg)}, "", false, new C298613());
        AppMethodBeat.m2505o(7475);
    }
}

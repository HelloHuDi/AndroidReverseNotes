package com.tencent.p177mm.plugin.webview.p580ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.opensdk.modelmsg.SendAuth.Req;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.plugin.webview.stub.C46434d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.e */
final class C4592e {
    C7564ap frk = new C7564ap(new C45941(), false);
    C46434d icy;
    C44275p mzU;
    boolean urN = false;
    boolean urO = false;
    final C4593a urP;
    OAuthUI urQ;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.e$a */
    public interface C4593a {
        /* renamed from: a */
        void mo9659a(C4592e c4592e, String str, boolean z);

        /* renamed from: d */
        void mo9660d(boolean z, String str, String str2, String str3);
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.e$1 */
    class C45941 implements C5015a {

        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.e$1$1 */
        class C45951 implements OnCancelListener {
            C45951() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(7413);
                try {
                    dialogInterface.dismiss();
                    AppMethodBeat.m2505o(7413);
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.OAuthSession", "onCancel, ex = " + e.getMessage());
                    AppMethodBeat.m2505o(7413);
                }
            }
        }

        C45941() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(7414);
            if (C4592e.this.urQ.isFinishing()) {
                C4990ab.m7420w("MicroMsg.OAuthSession", "onTimerExpired, context is finishing");
                AppMethodBeat.m2505o(7414);
            } else {
                C4592e c4592e = C4592e.this;
                Context context = C4592e.this.urQ;
                C4592e.this.urQ.getString(C25738R.string.f9238tz);
                c4592e.mzU = C30379h.m48458b(context, C4592e.this.urQ.getString(C25738R.string.f9260un), true, new C45951());
                AppMethodBeat.m2505o(7414);
            }
            return false;
        }
    }

    private C4592e(OAuthUI oAuthUI, C4593a c4593a, C46434d c46434d) {
        AppMethodBeat.m2504i(7415);
        this.urQ = oAuthUI;
        this.urP = c4593a;
        this.icy = c46434d;
        AppMethodBeat.m2505o(7415);
    }

    /* renamed from: a */
    public static C4592e m6958a(OAuthUI oAuthUI, String str, Req req, C4593a c4593a, C46434d c46434d) {
        AppMethodBeat.m2504i(7416);
        C4592e c4592e = new C4592e(oAuthUI, c4593a, c46434d);
        String str2 = req.scope;
        String str3 = req.state;
        if (c4592e.urN) {
            C4990ab.m7412e("MicroMsg.OAuthSession", "already getting");
        } else {
            c4592e.urO = true;
            Bundle bundle = new Bundle();
            bundle.putString("geta8key_data_appid", str);
            bundle.putString("geta8key_data_scope", str2);
            bundle.putString("geta8key_data_state", str3);
            try {
                c4592e.icy.mo15590s(C31128d.MIC_PTU_MEISHI, bundle);
                c4592e.urN = true;
            } catch (Exception e) {
                C4990ab.m7420w("MicroMsg.OAuthSession", "startGetA8Key, ex = " + e.getMessage());
            }
            c4592e.frk.mo16770ae(3000, 3000);
        }
        AppMethodBeat.m2505o(7416);
        return c4592e;
    }
}

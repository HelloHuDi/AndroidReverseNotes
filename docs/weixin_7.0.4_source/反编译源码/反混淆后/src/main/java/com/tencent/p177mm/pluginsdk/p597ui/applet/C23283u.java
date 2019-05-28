package com.tencent.p177mm.pluginsdk.p597ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelsimple.C6681h;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.pluginsdk.ui.applet.u */
public final class C23283u implements C1202f {
    Context context;
    C44275p mzU;
    private C7564ap ppI = new C7564ap(new C232841(), false);
    C6681h qhf;
    private String vlr;

    /* renamed from: com.tencent.mm.pluginsdk.ui.applet.u$1 */
    class C232841 implements C5015a {

        /* renamed from: com.tencent.mm.pluginsdk.ui.applet.u$1$1 */
        class C232851 implements OnCancelListener {
            C232851() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(27721);
                C9638aw.m17182Rg().mo14547c(C23283u.this.qhf);
                C23283u.this.mzU = null;
                AppMethodBeat.m2505o(27721);
            }
        }

        C232841() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(27722);
            C23283u c23283u = C23283u.this;
            Context context = C23283u.this.context;
            C23283u.this.context.getString(C25738R.string.f9238tz);
            c23283u.mzU = C30379h.m48458b(context, C23283u.this.context.getString(C25738R.string.f9260un), true, new C232851());
            AppMethodBeat.m2505o(27722);
            return false;
        }
    }

    public C23283u(Context context) {
        AppMethodBeat.m2504i(27723);
        this.context = context;
        AppMethodBeat.m2505o(27723);
    }

    public final void ajG(String str) {
        AppMethodBeat.m2504i(27724);
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.ViewQZone", "go fail, qqNum is null");
            AppMethodBeat.m2505o(27724);
            return;
        }
        this.vlr = str;
        C9638aw.m17190ZK();
        String str2 = (String) C18628c.m29072Ry().get(46, null);
        C9638aw.m17190ZK();
        C4990ab.m7417i("MicroMsg.ViewQZone", "get a2key:[%s], get new a2key:[%s]", str2, C5046bo.nullAsNil((String) C18628c.m29072Ry().get(72, null)));
        if (C5046bo.isNullOrNil(str2) && C5046bo.isNullOrNil(r1)) {
            ajH(str);
            AppMethodBeat.m2505o(27724);
            return;
        }
        C9638aw.m17182Rg().mo14539a((int) C31128d.MIC_PTU_MEISHI, (C1202f) this);
        this.qhf = new C6681h(C1183p.m2611cB(str), (int) System.currentTimeMillis());
        C9638aw.m17182Rg().mo14541a(this.qhf, 0);
        this.ppI.mo16770ae(3000, 3000);
        AppMethodBeat.m2505o(27724);
    }

    private void ajH(String str) {
        AppMethodBeat.m2504i(27725);
        Intent intent = new Intent();
        String str2 = "rawUrl";
        intent.putExtra(str2, this.context.getString(C25738R.string.az4, new Object[]{str}));
        intent.putExtra("useJs", true);
        intent.putExtra("vertical_scroll", true);
        intent.putExtra("neverGetA8Key", true);
        C25985d.m41467b(this.context, "webview", ".ui.tools.ContactQZoneWebView", intent);
        AppMethodBeat.m2505o(27725);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(27726);
        this.ppI.stopTimer();
        if (this.mzU != null) {
            this.mzU.dismiss();
        }
        C9638aw.m17182Rg().mo14546b((int) C31128d.MIC_PTU_MEISHI, (C1202f) this);
        if (i == 0 && i2 == 0) {
            C6681h c6681h = (C6681h) c1207m;
            String aiT = c6681h.aiT();
            if (aiT == null || aiT.length() == 0) {
                ajH(this.vlr);
                AppMethodBeat.m2505o(27726);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("rawUrl", aiT);
            intent.putExtra("useJs", true);
            intent.putExtra("vertical_scroll", true);
            intent.putExtra("neverGetA8Key", true);
            intent.putExtra("geta8key_session_id", c6681h.ajb());
            C25985d.m41467b(this.context, "webview", ".ui.tools.ContactQZoneWebView", intent);
            AppMethodBeat.m2505o(27726);
            return;
        }
        C4990ab.m7412e("MicroMsg.ViewQZone", "getA8Key fail, errType = " + i + ", errCode = " + i2);
        ajH(this.vlr);
        AppMethodBeat.m2505o(27726);
    }
}

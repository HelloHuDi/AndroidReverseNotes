package com.tencent.p177mm.plugin.scanner.p504ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelsimple.C6681h;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.plugin.scanner.C28892c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.plugin.scanner.ui.r */
public final class C28914r implements C1202f {
    Context context;
    C44275p mzU;
    C7564ap ppI = new C7564ap(new C289151(), false);
    C6681h qhf;
    String url;

    /* renamed from: com.tencent.mm.plugin.scanner.ui.r$1 */
    class C289151 implements C5015a {

        /* renamed from: com.tencent.mm.plugin.scanner.ui.r$1$1 */
        class C131701 implements OnCancelListener {
            C131701() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(81362);
                C1720g.m3540Rg().mo14547c(C28914r.this.qhf);
                C28914r.this.mzU = null;
                AppMethodBeat.m2505o(81362);
            }
        }

        C289151() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(81363);
            C28914r c28914r = C28914r.this;
            Context context = C28914r.this.context;
            C28914r.this.context.getString(C25738R.string.f9238tz);
            c28914r.mzU = C30379h.m48458b(context, C28914r.this.context.getString(C25738R.string.f9260un), true, new C131701());
            AppMethodBeat.m2505o(81363);
            return false;
        }
    }

    public C28914r(Context context) {
        AppMethodBeat.m2504i(81364);
        this.context = context;
        AppMethodBeat.m2505o(81364);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: c */
    public final void mo47030c(String str, int i, byte[] bArr) {
        AppMethodBeat.m2504i(81365);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("useJs", true);
        intent.putExtra("vertical_scroll", true);
        intent.putExtra("geta8key_session_id", i);
        intent.putExtra("geta8key_cookie", bArr);
        C28892c.gkE.mo38924i(intent, this.context);
        AppMethodBeat.m2505o(81365);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(81366);
        this.ppI.stopTimer();
        if (this.mzU != null) {
            this.mzU.dismiss();
        }
        C1720g.m3540Rg().mo14546b((int) C31128d.MIC_PTU_MEISHI, (C1202f) this);
        C6681h c6681h = (C6681h) c1207m;
        if (i == 0 && i2 == 0) {
            String aiT = c6681h.aiT();
            if (aiT == null || aiT.length() == 0) {
                mo47030c(this.url, c6681h.ajb(), c6681h.ajc());
                AppMethodBeat.m2505o(81366);
                return;
            }
            mo47030c(aiT, c6681h.ajb(), c6681h.ajc());
            AppMethodBeat.m2505o(81366);
            return;
        }
        C4990ab.m7412e("MicroMsg.scanner.ViewMMURL", "getA8Key fail, errType = " + i + ", errCode = " + i2);
        mo47030c(this.url, c6681h.ajb(), c6681h.ajc());
        AppMethodBeat.m2505o(81366);
    }
}

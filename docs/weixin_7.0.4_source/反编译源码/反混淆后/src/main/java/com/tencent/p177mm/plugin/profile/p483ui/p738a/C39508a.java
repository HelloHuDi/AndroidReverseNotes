package com.tencent.p177mm.plugin.profile.p483ui.p738a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.profile.p1287b.C46136b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;

/* renamed from: com.tencent.mm.plugin.profile.ui.a.a */
public final class C39508a implements C1202f {
    Activity czX;
    C44275p mzU;
    C46136b ppH;
    private C7564ap ppI = new C7564ap(new C70221(), false);

    /* renamed from: com.tencent.mm.plugin.profile.ui.a.a$1 */
    class C70221 implements C5015a {

        /* renamed from: com.tencent.mm.plugin.profile.ui.a.a$1$1 */
        class C70231 implements OnCancelListener {
            C70231() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(23795);
                C9638aw.m17182Rg().mo14547c(C39508a.this.ppH);
                C39508a.this.mzU = null;
                AppMethodBeat.m2505o(23795);
            }
        }

        C70221() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(23796);
            if (!C39508a.this.czX.isFinishing()) {
                C39508a c39508a = C39508a.this;
                Context context = C39508a.this.czX;
                C39508a.this.czX.getString(C25738R.string.f9238tz);
                c39508a.mzU = C30379h.m48458b(context, C39508a.this.czX.getString(C25738R.string.f9260un), true, new C70231());
            }
            AppMethodBeat.m2505o(23796);
            return false;
        }
    }

    public C39508a(Activity activity) {
        AppMethodBeat.m2504i(23797);
        this.czX = activity;
        AppMethodBeat.m2505o(23797);
    }

    /* renamed from: fF */
    public final void mo62470fF(String str, String str2) {
        AppMethodBeat.m2504i(23798);
        if (str == null) {
            C4990ab.m7412e("MicroMsg.ViewTWeibo", "null weibo id");
            AppMethodBeat.m2505o(23798);
            return;
        }
        C9638aw.m17182Rg().mo14539a(205, (C1202f) this);
        this.ppH = new C46136b(C5046bo.nullAsNil(str).replace("http://t.qq.com/", "").trim(), str2);
        C9638aw.m17182Rg().mo14541a(this.ppH, 0);
        this.ppI.mo16770ae(3000, 3000);
        AppMethodBeat.m2505o(23798);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(23799);
        C9638aw.m17182Rg().mo14546b(205, (C1202f) this);
        C46136b c46136b = (C46136b) c1207m;
        if (i == 0 && i2 == 0) {
            m67515UW(c46136b.getURL());
            AppMethodBeat.m2505o(23799);
            return;
        }
        if (i != 4) {
            C4990ab.m7412e("MicroMsg.ViewTWeibo", "view weibo failed: " + i + ", " + i2);
        }
        m67515UW("http://t.qq.com/" + c46136b.pkH);
        AppMethodBeat.m2505o(23799);
    }

    /* renamed from: UW */
    private void m67515UW(String str) {
        AppMethodBeat.m2504i(23800);
        this.ppI.stopTimer();
        if (this.mzU != null) {
            this.mzU.dismiss();
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.putExtra("title", this.czX.getString(C25738R.string.b2a));
        intent.putExtra("zoom", true);
        intent.putExtra("vertical_scroll", false);
        C25985d.m41467b(this.czX, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.m2505o(23800);
    }
}

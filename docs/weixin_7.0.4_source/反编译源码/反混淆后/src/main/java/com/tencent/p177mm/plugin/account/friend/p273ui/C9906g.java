package com.tencent.p177mm.plugin.account.friend.p273ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.account.friend.p272a.C38031ah;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.account.friend.ui.g */
public final class C9906g implements C1202f {
    private Context context;
    private ProgressDialog fsh;
    C9907a gyh;
    private boolean gyi = true;
    String gyj = "";

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.g$2 */
    class C20072 implements OnClickListener {
        C20072() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(108649);
            C9906g.this.gyh.mo5748e(true, C9906g.this.gyj);
            AppMethodBeat.m2505o(108649);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.g$a */
    public interface C9907a {
        /* renamed from: e */
        void mo5748e(boolean z, String str);
    }

    public C9906g(Context context, C9907a c9907a) {
        this.context = context;
        this.gyh = c9907a;
        this.gyi = true;
    }

    public C9906g(Context context, C9907a c9907a, byte b) {
        this.context = context;
        this.gyh = c9907a;
        this.gyi = false;
    }

    /* renamed from: m */
    public final void mo21262m(int[] iArr) {
        AppMethodBeat.m2504i(108650);
        C1720g.m3540Rg().mo14539a(116, (C1202f) this);
        final C1207m c38031ah = new C38031ah(iArr);
        C1720g.m3540Rg().mo14541a(c38031ah, 0);
        if (this.gyi) {
            Context context = this.context;
            this.context.getString(C25738R.string.cev);
            this.fsh = C30379h.m48458b(context, this.context.getString(C25738R.string.cet), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(108648);
                    C1720g.m3540Rg().mo14547c(c38031ah);
                    C9906g.this.gyh.mo5748e(false, C9906g.this.gyj);
                    AppMethodBeat.m2505o(108648);
                }
            });
        }
        AppMethodBeat.m2505o(108650);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(108651);
        if (c1207m.getType() != 116) {
            AppMethodBeat.m2505o(108651);
            return;
        }
        if (this.fsh != null) {
            this.fsh.dismiss();
            this.fsh = null;
        }
        C1720g.m3540Rg().mo14546b(116, (C1202f) this);
        if (i == 0 && i2 == 0) {
            C4990ab.m7416i("MicroMsg.SendInviteEmail", "dealSendInviteEmailSuccess");
            if (this.gyi) {
                C30379h.m48431a(this.context, (int) C25738R.string.ces, (int) C25738R.string.f9238tz, new C20072());
                AppMethodBeat.m2505o(108651);
                return;
            }
            this.gyh.mo5748e(true, this.gyj);
            AppMethodBeat.m2505o(108651);
            return;
        }
        C4990ab.m7416i("MicroMsg.SendInviteEmail", "dealSendInviteEmailFail");
        this.gyh.mo5748e(false, this.gyj);
        AppMethodBeat.m2505o(108651);
    }
}

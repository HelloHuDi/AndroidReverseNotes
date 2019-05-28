package com.tencent.p177mm.roomsdk.p1086a.p1342c;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.roomsdk.p1086a.C15409a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.roomsdk.a.c.b */
public final class C40603b extends C46610a {
    C1202f fur = new C406041();
    public C1207m tRR;

    /* renamed from: com.tencent.mm.roomsdk.a.c.b$1 */
    class C406041 implements C1202f {
        C406041() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(80257);
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14546b(c1207m.getType(), C40603b.this.fur);
            if (C40603b.this.tipDialog != null) {
                C40603b.this.tipDialog.dismiss();
            }
            if (C40603b.this.tRR.equals(c1207m)) {
                if (c1207m instanceof C15409a) {
                    ((C15409a) c1207m).mo27452a(C40603b.this.xva);
                }
                if (C40603b.this.xva != null) {
                    C40603b.this.xva.mo11081a(i, i2, str, C40603b.this.xva);
                }
                if (i == 0 && i2 == 0) {
                    if (C40603b.this.xuY != null) {
                        C40603b.this.xuY.mo11081a(i, i2, str, C40603b.this.xuY);
                        AppMethodBeat.m2505o(80257);
                        return;
                    }
                } else if (C40603b.this.xuZ != null) {
                    C40603b.this.xuZ.mo11081a(i, i2, str, C40603b.this.xuZ);
                }
            }
            AppMethodBeat.m2505o(80257);
        }
    }

    public C40603b(boolean z) {
        AppMethodBeat.m2504i(80258);
        this.xuX = z;
        AppMethodBeat.m2505o(80258);
    }

    public final void cancel() {
        AppMethodBeat.m2504i(80259);
        if (this.tRR == null) {
            AppMethodBeat.m2505o(80259);
            return;
        }
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14547c(this.tRR);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(this.tRR.getType(), this.fur);
        AppMethodBeat.m2505o(80259);
    }

    public final void dmX() {
        AppMethodBeat.m2504i(80260);
        if (this.tRR == null) {
            AppMethodBeat.m2505o(80260);
            return;
        }
        C4990ab.m7417i("MicroMsg.RoomCallbackFactory", "request scene %s", this.tRR);
        if (!(this.tipDialog == null && this.xuY == null && this.xuZ == null && this.xva == null)) {
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14539a(this.tRR.getType(), this.fur);
        }
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14541a(this.tRR, 0);
        AppMethodBeat.m2505o(80260);
    }

    /* renamed from: a */
    public final void mo48450a(Context context, String str, boolean z, OnCancelListener onCancelListener) {
        AppMethodBeat.m2504i(80261);
        if (this.tRR == null) {
            AppMethodBeat.m2505o(80261);
            return;
        }
        this.tipDialog = C30379h.m48458b(context, str, z, onCancelListener);
        dmX();
        AppMethodBeat.m2505o(80261);
    }
}

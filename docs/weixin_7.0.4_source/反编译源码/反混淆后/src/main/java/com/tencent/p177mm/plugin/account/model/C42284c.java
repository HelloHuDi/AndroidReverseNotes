package com.tencent.p177mm.plugin.account.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C32231g;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C33333a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.account.model.c */
public final class C42284c implements C1202f, C32231g {
    public Context context;
    public C1207m cwn;
    public C26602a gyH;
    private C7306ak handler = new C7306ak(Looper.getMainLooper());
    public C44275p tipDialog;

    /* renamed from: com.tencent.mm.plugin.account.model.c$a */
    public interface C26602a {
        void aqC();
    }

    /* renamed from: com.tencent.mm.plugin.account.model.c$1 */
    public class C422831 implements OnCancelListener {
        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(124671);
            C4990ab.m7420w("MicroMsg.DoInit", "do init canceled");
            C1720g.m3540Rg().mo14547c(C42284c.this.cwn);
            if (C42284c.this.cwn.getType() == C33333a.CTRL_INDEX) {
                C1720g.m3540Rg().mo14546b((int) C33333a.CTRL_INDEX, C42284c.this);
                AppMethodBeat.m2505o(124671);
                return;
            }
            if (C42284c.this.cwn.getType() == 138) {
                C1720g.m3540Rg().mo14546b(138, C42284c.this);
            }
            AppMethodBeat.m2505o(124671);
        }
    }

    public C42284c(Context context, C26602a c26602a) {
        AppMethodBeat.m2504i(124673);
        this.context = context;
        this.gyH = c26602a;
        AppMethodBeat.m2505o(124673);
    }

    /* renamed from: a */
    public final void mo8280a(int i, int i2, C1207m c1207m) {
        AppMethodBeat.m2504i(124674);
        final int i3 = i2 != 0 ? (int) ((((long) i) * 100) / ((long) i2)) : 0;
        this.handler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(124672);
                if (C42284c.this.tipDialog != null) {
                    C42284c.this.tipDialog.setMessage(C42284c.this.context.getString(C25738R.string.f9161re) + i3 + "%");
                }
                AppMethodBeat.m2505o(124672);
            }
        });
        AppMethodBeat.m2505o(124674);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(124675);
        if (c1207m.getType() == C33333a.CTRL_INDEX) {
            C1720g.m3540Rg().mo14546b((int) C33333a.CTRL_INDEX, (C1202f) this);
        } else if (c1207m.getType() == 138) {
            C1720g.m3540Rg().mo14546b(138, (C1202f) this);
        }
        if (i2 == 0 && i == 0) {
            this.gyH.aqC();
        } else {
            C4990ab.m7412e("MicroMsg.DoInit", "do init failed, err=" + i + "," + i2);
            this.gyH.aqC();
        }
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        AppMethodBeat.m2505o(124675);
    }
}

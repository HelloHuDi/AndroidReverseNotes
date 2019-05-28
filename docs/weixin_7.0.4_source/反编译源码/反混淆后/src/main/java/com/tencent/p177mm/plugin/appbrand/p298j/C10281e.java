package com.tencent.p177mm.plugin.appbrand.p298j;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.widget.p337b.C33584g;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;

/* renamed from: com.tencent.mm.plugin.appbrand.j.e */
final class C10281e implements DialogInterface {
    /* renamed from: Ue */
    private OnCancelListener f2869Ue;
    private C7564ap gGo;
    private C33584g inM;
    private boolean mDismissed = false;
    /* renamed from: xH */
    private boolean f2870xH = false;

    C10281e() {
    }

    /* Access modifiers changed, original: final */
    /* renamed from: x */
    public final void mo21728x(final C6750i c6750i) {
        AppMethodBeat.m2504i(102147);
        if (C5004al.isMainThread()) {
            this.gGo = new C7564ap(Looper.getMainLooper(), new C5015a() {
                /* renamed from: BI */
                public final boolean mo4499BI() {
                    AppMethodBeat.m2504i(102146);
                    if (C10281e.this.f2870xH || C10281e.this.mDismissed) {
                        AppMethodBeat.m2505o(102146);
                    } else {
                        C33584g c33584g = new C33584g(c6750i.getContext());
                        c33584g.setMessage(c6750i.getContext().getString(C25738R.string.cu7));
                        c33584g.setOnCancelListener(C10281e.this.f2869Ue);
                        c33584g.setCanceledOnTouchOutside(false);
                        c6750i.gNG.mo6468b(c33584g);
                        C10281e.this.inM = c33584g;
                        AppMethodBeat.m2505o(102146);
                    }
                    return false;
                }
            }, false);
            this.gGo.mo16770ae(500, 500);
            AppMethodBeat.m2505o(102147);
            return;
        }
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(102145);
                C10281e.this.mo21728x(c6750i);
                AppMethodBeat.m2505o(102145);
            }
        });
        AppMethodBeat.m2505o(102147);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final C10281e mo21725a(OnCancelListener onCancelListener) {
        AppMethodBeat.m2504i(102148);
        this.f2869Ue = onCancelListener;
        if (this.inM != null) {
            this.inM.setOnCancelListener(this.f2869Ue);
        }
        AppMethodBeat.m2505o(102148);
        return this;
    }

    public final void cancel() {
        AppMethodBeat.m2504i(102149);
        this.f2870xH = true;
        if (this.inM != null) {
            this.inM.cancel();
            AppMethodBeat.m2505o(102149);
            return;
        }
        if (this.f2869Ue != null) {
            this.f2869Ue.onCancel(this);
        }
        AppMethodBeat.m2505o(102149);
    }

    public final void dismiss() {
        AppMethodBeat.m2504i(102150);
        this.mDismissed = true;
        if (this.inM != null) {
            this.inM.dismiss();
        }
        AppMethodBeat.m2505o(102150);
    }
}

package com.tencent.p177mm.plugin.choosemsgfile.p358b.p359b;

import android.os.Looper;
import android.support.p069v7.widget.RecyclerView.C41531v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p1605d.C42887b;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p360c.C33817g;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.plugin.choosemsgfile.b.b.d */
public abstract class C33813d extends C11376a<C38787m> {
    /* renamed from: T */
    public final /* synthetic */ void mo23108T(C41531v c41531v) {
        m55299a((C38787m) c41531v);
    }

    public C33813d(C33817g c33817g, C7620bi c7620bi) {
        super(c33817g, c7620bi);
    }

    /* Access modifiers changed, original: protected */
    public String aan() {
        return "";
    }

    /* renamed from: a */
    public void mo6912a(C38787m c38787m, int i) {
        c38787m.kuG.setTag(this);
        c38787m.kuO.setTag(this);
        C32291o.ahp().mo43766a(aan(), c38787m.kuG, C42887b.m76163dy(getContext()));
        c38787m.kuK.setVisibility(8);
        c38787m.kuL.setVisibility(8);
        c38787m.kuI.setVisibility(8);
        c38787m.kuJ.setVisibility(8);
        c38787m.kuO.setVisibility(0);
        c38787m.kuN.setVisibility(0);
        m55299a(c38787m);
        if (bfn().mo68413gW(this.kua.field_msgId)) {
            c38787m.kuM.setVisibility(8);
            c38787m.kuN.setChecked(true);
        } else {
            c38787m.kuM.setVisibility(0);
            c38787m.kuN.setChecked(false);
        }
        if (isEnable()) {
            c38787m.kuF.setAlpha(1.0f);
        } else {
            c38787m.kuF.setAlpha(0.6f);
        }
    }

    /* renamed from: a */
    private void m55299a(final C38787m c38787m) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            m55300b(c38787m);
        } else {
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(54294);
                    C33813d.this.m55300b(c38787m);
                    AppMethodBeat.m2505o(54294);
                }
            });
        }
    }

    /* renamed from: b */
    private void m55300b(C38787m c38787m) {
        switch (this.kuk) {
            case 0:
                c38787m.gtQ.setVisibility(8);
                c38787m.kuH.setVisibility(8);
                c38787m.kuN.setVisibility(0);
                c38787m.kuO.setVisibility(0);
                c38787m.kuN.setChecked(false);
                c38787m.kuP.setVisibility(8);
                return;
            case 1:
                c38787m.gtQ.setVisibility(0);
                c38787m.kuH.setVisibility(8);
                c38787m.kuN.setVisibility(8);
                c38787m.kuO.setVisibility(8);
                c38787m.kuP.setVisibility(8);
                return;
            case 2:
                c38787m.gtQ.setVisibility(0);
                c38787m.kuH.setVisibility(0);
                c38787m.kuN.setVisibility(8);
                c38787m.kuO.setVisibility(8);
                c38787m.kuP.setVisibility(8);
                if (this.alq > 0) {
                    int i = (int) ((((float) this.f2899Lp) / ((float) this.alq)) * 100.0f);
                    if (i == -1 || i >= 100) {
                        c38787m.kuH.setProgress(100);
                        return;
                    } else {
                        c38787m.kuH.setProgress(i);
                        return;
                    }
                }
                return;
            case 3:
                c38787m.gtQ.setVisibility(8);
                c38787m.kuH.setVisibility(8);
                c38787m.kuN.setVisibility(0);
                c38787m.kuO.setVisibility(0);
                c38787m.kuP.setVisibility(8);
                return;
            case 4:
                c38787m.gtQ.setVisibility(8);
                c38787m.kuH.setVisibility(8);
                c38787m.kuN.setVisibility(8);
                c38787m.kuO.setVisibility(8);
                c38787m.kuP.setVisibility(0);
                return;
            case 5:
                c38787m.gtQ.setVisibility(8);
                c38787m.kuH.setVisibility(8);
                c38787m.kuN.setVisibility(8);
                c38787m.kuO.setVisibility(8);
                c38787m.kuP.setVisibility(0);
                return;
            default:
                return;
        }
    }
}

package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.os.Looper;
import android.support.v7.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;
import com.tencent.mm.plugin.choosemsgfile.b.d.b;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.bi;

public abstract class d extends a<m> {
    public final /* synthetic */ void T(v vVar) {
        a((m) vVar);
    }

    public d(g gVar, bi biVar) {
        super(gVar, biVar);
    }

    /* Access modifiers changed, original: protected */
    public String aan() {
        return "";
    }

    public void a(m mVar, int i) {
        mVar.kuG.setTag(this);
        mVar.kuO.setTag(this);
        o.ahp().a(aan(), mVar.kuG, b.dy(getContext()));
        mVar.kuK.setVisibility(8);
        mVar.kuL.setVisibility(8);
        mVar.kuI.setVisibility(8);
        mVar.kuJ.setVisibility(8);
        mVar.kuO.setVisibility(0);
        mVar.kuN.setVisibility(0);
        a(mVar);
        if (bfn().gW(this.kua.field_msgId)) {
            mVar.kuM.setVisibility(8);
            mVar.kuN.setChecked(true);
        } else {
            mVar.kuM.setVisibility(0);
            mVar.kuN.setChecked(false);
        }
        if (isEnable()) {
            mVar.kuF.setAlpha(1.0f);
        } else {
            mVar.kuF.setAlpha(0.6f);
        }
    }

    private void a(final m mVar) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            b(mVar);
        } else {
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(54294);
                    d.this.b(mVar);
                    AppMethodBeat.o(54294);
                }
            });
        }
    }

    private void b(m mVar) {
        switch (this.kuk) {
            case 0:
                mVar.gtQ.setVisibility(8);
                mVar.kuH.setVisibility(8);
                mVar.kuN.setVisibility(0);
                mVar.kuO.setVisibility(0);
                mVar.kuN.setChecked(false);
                mVar.kuP.setVisibility(8);
                return;
            case 1:
                mVar.gtQ.setVisibility(0);
                mVar.kuH.setVisibility(8);
                mVar.kuN.setVisibility(8);
                mVar.kuO.setVisibility(8);
                mVar.kuP.setVisibility(8);
                return;
            case 2:
                mVar.gtQ.setVisibility(0);
                mVar.kuH.setVisibility(0);
                mVar.kuN.setVisibility(8);
                mVar.kuO.setVisibility(8);
                mVar.kuP.setVisibility(8);
                if (this.alq > 0) {
                    int i = (int) ((((float) this.Lp) / ((float) this.alq)) * 100.0f);
                    if (i == -1 || i >= 100) {
                        mVar.kuH.setProgress(100);
                        return;
                    } else {
                        mVar.kuH.setProgress(i);
                        return;
                    }
                }
                return;
            case 3:
                mVar.gtQ.setVisibility(8);
                mVar.kuH.setVisibility(8);
                mVar.kuN.setVisibility(0);
                mVar.kuO.setVisibility(0);
                mVar.kuP.setVisibility(8);
                return;
            case 4:
                mVar.gtQ.setVisibility(8);
                mVar.kuH.setVisibility(8);
                mVar.kuN.setVisibility(8);
                mVar.kuO.setVisibility(8);
                mVar.kuP.setVisibility(0);
                return;
            case 5:
                mVar.gtQ.setVisibility(8);
                mVar.kuH.setVisibility(8);
                mVar.kuN.setVisibility(8);
                mVar.kuO.setVisibility(8);
                mVar.kuP.setVisibility(0);
                return;
            default:
                return;
        }
    }
}

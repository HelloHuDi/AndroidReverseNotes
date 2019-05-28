package com.tencent.toybrick.p1427ui;

import android.os.Bundle;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C25373h;
import android.support.p069v7.widget.RecyclerView.C31881t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.C5227ai;
import com.tencent.toybrick.p1113g.C44560a;
import com.tencent.toybrick.p1354b.C41091a;
import com.tencent.toybrick.p1354b.C41092c;
import com.tencent.toybrick.p1354b.C46820b;
import com.tencent.toybrick.p680c.C44830g;
import com.tencent.toybrick.p681d.C5969a;
import com.tencent.toybrick.p681d.C5969a.C5970a;

/* renamed from: com.tencent.toybrick.ui.VerticalToyUI */
public abstract class VerticalToyUI<T extends C44560a> extends BaseToyUI<C44830g> {
    static final /* synthetic */ boolean $assertionsDisabled = (!VerticalToyUI.class.desiredAssertionStatus());
    private C5970a AFT;
    private C46820b AHu;
    private C5969a AHv;
    protected T AHw = null;

    /* renamed from: com.tencent.toybrick.ui.VerticalToyUI$1 */
    class C311171 extends C31881t {
        C311171() {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Class cls = null;
        try {
            this.AHw = (C44560a) cls.newInstance();
        } catch (InstantiationException e) {
            C5227ai.printErrStackTrace("VerticalToyUI", e, "", new Object[0]);
        } catch (IllegalAccessException e2) {
            C5227ai.printErrStackTrace("VerticalToyUI", e2, "", new Object[0]);
        }
        this.AHv = new C5969a(this);
        this.AFT = this.AHv.AFT;
        RecyclerView recyclerView = (RecyclerView) findViewById(2131828399);
        getBaseContext();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager();
        linearLayoutManager.alM = 4;
        linearLayoutManager.mo31843an(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        C46820b c46820b = new C46820b(this, this.AFT);
        this.AHu = c46820b;
        recyclerView.setAdapter(c46820b);
        recyclerView.setRecycledViewPool(C41091a.dSx());
        recyclerView.setViewCacheExtension(new C311171());
        C25373h c41092c = new C41092c(this);
        c41092c.AFT = this.AFT;
        recyclerView.mo66330a(c41092c);
        if (this.AHu != null) {
            this.AHu.aop.notifyChanged();
        }
    }
}

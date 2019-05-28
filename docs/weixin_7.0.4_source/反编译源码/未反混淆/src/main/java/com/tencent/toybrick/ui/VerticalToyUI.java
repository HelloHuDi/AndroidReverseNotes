package com.tencent.toybrick.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.ai;
import com.tencent.toybrick.b.b;
import com.tencent.toybrick.b.c;
import com.tencent.toybrick.c.g;
import com.tencent.toybrick.g.a;

public abstract class VerticalToyUI<T extends a> extends BaseToyUI<g> {
    static final /* synthetic */ boolean $assertionsDisabled = (!VerticalToyUI.class.desiredAssertionStatus());
    private com.tencent.toybrick.d.a.a AFT;
    private b AHu;
    private com.tencent.toybrick.d.a AHv;
    protected T AHw = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Class cls = null;
        try {
            this.AHw = (a) cls.newInstance();
        } catch (InstantiationException e) {
            ai.printErrStackTrace("VerticalToyUI", e, "", new Object[0]);
        } catch (IllegalAccessException e2) {
            ai.printErrStackTrace("VerticalToyUI", e2, "", new Object[0]);
        }
        this.AHv = new com.tencent.toybrick.d.a(this);
        this.AFT = this.AHv.AFT;
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.f0b);
        getBaseContext();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager();
        linearLayoutManager.alM = 4;
        linearLayoutManager.an(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        b bVar = new b(this, this.AFT);
        this.AHu = bVar;
        recyclerView.setAdapter(bVar);
        recyclerView.setRecycledViewPool(com.tencent.toybrick.b.a.dSx());
        recyclerView.setViewCacheExtension(new t() {
        });
        h cVar = new c(this);
        cVar.AFT = this.AFT;
        recyclerView.a(cVar);
        if (this.AHu != null) {
            this.AHu.aop.notifyChanged();
        }
    }
}

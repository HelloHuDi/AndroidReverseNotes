package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.luckymoney.model.s;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.h;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.d.f;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class LuckyMoneyBaseUI extends MMActivity implements h, f {
    private LinkedList<j> ocA = new LinkedList();
    public s ocz = null;

    public abstract boolean c(int i, int i2, String str, m mVar);

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final void bMp() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().show();
            xE(getResources().getColor(R.color.tl));
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void bMq() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }

    public void onDestroy() {
        this.ocz.ng(1554);
        this.ocz.ng(1575);
        this.ocz.ng(1668);
        this.ocz.ng(1581);
        this.ocz.ng(1685);
        this.ocz.ng(1585);
        this.ocz.ng(1514);
        this.ocz.ng(1682);
        this.ocz.ng(1612);
        this.ocz.ng(1643);
        this.ocz.ng(1558);
        this.ocz.ng(2715);
        for (j onDestroy : (List) this.ocA.clone()) {
            onDestroy.onDestroy();
        }
        this.ocA.clear();
        super.onDestroy();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.ocz.bLA()) {
                this.ocz.bLz();
            }
            if (this.mController.contentView.getVisibility() == 8 || this.mController.contentView.getVisibility() == 4) {
                finish();
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    public final void b(int i, int i2, String str, m mVar, boolean z) {
        if (!c(i, i2, str, mVar)) {
            if (i != 0 || i2 != 0) {
                com.tencent.mm.ui.base.h.bQ(this, str);
                finish();
            }
        }
    }

    public final void nf(int i) {
        this.ocz.nf(i);
    }

    public final void ng(int i) {
        this.ocz.ng(i);
    }

    public final void b(m mVar, boolean z) {
        this.ocz.b(mVar, z);
    }

    public final void n(m mVar) {
        this.ocz.b(mVar, true);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (j dNL : (List) this.ocA.clone()) {
            dNL.dNL();
        }
    }

    public final void a(j jVar) {
        if (!this.ocA.contains(jVar)) {
            this.ocA.add(jVar);
        }
    }

    public void onCreate(Bundle bundle) {
        this.yll = true;
        super.onCreate(bundle);
        this.ocz = new s(this, this);
        this.ocz.nf(1554);
        this.ocz.nf(1575);
        this.ocz.nf(1668);
        this.ocz.nf(1581);
        this.ocz.nf(1685);
        this.ocz.nf(1585);
        this.ocz.nf(1514);
        this.ocz.nf(1682);
        this.ocz.nf(1612);
        this.ocz.nf(1643);
        this.ocz.nf(1558);
        this.ocz.nf(2715);
        xE(getResources().getColor(R.color.tl));
        Nc(getResources().getColor(R.color.tt));
        getLayoutId();
        Iterator it = ((List) this.ocA.clone()).iterator();
        while (it.hasNext()) {
            it.next();
        }
    }
}

package com.tencent.p177mm.plugin.luckymoney.p449ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.luckymoney.model.C21207s;
import com.tencent.p177mm.wallet_core.p649c.C44425h;
import com.tencent.p177mm.wallet_core.p649c.C44427j;
import com.tencent.p177mm.wallet_core.p760d.C40932f;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI */
public abstract class LuckyMoneyBaseUI extends MMActivity implements C44425h, C40932f {
    private LinkedList<C44427j> ocA = new LinkedList();
    public C21207s ocz = null;

    /* renamed from: c */
    public abstract boolean mo7808c(int i, int i2, String str, C1207m c1207m);

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final void bMp() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().show();
            mo17446xE(getResources().getColor(C25738R.color.f12134tl));
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void bMq() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }

    public void onDestroy() {
        this.ocz.mo36587ng(1554);
        this.ocz.mo36587ng(1575);
        this.ocz.mo36587ng(1668);
        this.ocz.mo36587ng(1581);
        this.ocz.mo36587ng(1685);
        this.ocz.mo36587ng(1585);
        this.ocz.mo36587ng(1514);
        this.ocz.mo36587ng(1682);
        this.ocz.mo36587ng(1612);
        this.ocz.mo36587ng(1643);
        this.ocz.mo36587ng(1558);
        this.ocz.mo36587ng(2715);
        for (C44427j onDestroy : (List) this.ocA.clone()) {
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

    /* renamed from: b */
    public final void mo24300b(int i, int i2, String str, C1207m c1207m, boolean z) {
        if (!mo7808c(i, i2, str, c1207m)) {
            if (i != 0 || i2 != 0) {
                C30379h.m48465bQ(this, str);
                finish();
            }
        }
    }

    /* renamed from: nf */
    public final void mo24305nf(int i) {
        this.ocz.mo36586nf(i);
    }

    /* renamed from: ng */
    public final void mo24306ng(int i) {
        this.ocz.mo36587ng(i);
    }

    /* renamed from: b */
    public final void mo24301b(C1207m c1207m, boolean z) {
        this.ocz.mo36582b(c1207m, z);
    }

    /* renamed from: n */
    public final void mo24304n(C1207m c1207m) {
        this.ocz.mo36582b(c1207m, true);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (C44427j dNL : (List) this.ocA.clone()) {
            dNL.dNL();
        }
    }

    /* renamed from: a */
    public final void mo24299a(C44427j c44427j) {
        if (!this.ocA.contains(c44427j)) {
            this.ocA.add(c44427j);
        }
    }

    public void onCreate(Bundle bundle) {
        this.yll = true;
        super.onCreate(bundle);
        this.ocz = new C21207s(this, this);
        this.ocz.mo36586nf(1554);
        this.ocz.mo36586nf(1575);
        this.ocz.mo36586nf(1668);
        this.ocz.mo36586nf(1581);
        this.ocz.mo36586nf(1685);
        this.ocz.mo36586nf(1585);
        this.ocz.mo36586nf(1514);
        this.ocz.mo36586nf(1682);
        this.ocz.mo36586nf(1612);
        this.ocz.mo36586nf(1643);
        this.ocz.mo36586nf(1558);
        this.ocz.mo36586nf(2715);
        mo17446xE(getResources().getColor(C25738R.color.f12134tl));
        mo17373Nc(getResources().getColor(C25738R.color.f12140tt));
        getLayoutId();
        Iterator it = ((List) this.ocA.clone()).iterator();
        while (it.hasNext()) {
            it.next();
        }
    }
}

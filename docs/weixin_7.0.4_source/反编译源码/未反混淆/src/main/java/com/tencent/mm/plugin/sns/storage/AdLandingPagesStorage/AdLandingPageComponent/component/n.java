package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l;
import com.tencent.mm.ui.base.CustomScrollView;
import com.tencent.mm.ui.widget.RoundedCornerRelativeLayout;
import java.util.ArrayList;
import java.util.List;

public final class n extends a {
    List<h> bnR = new ArrayList();
    private l qZg;
    private p ral;
    private CustomScrollView ram;

    public n(Context context, p pVar, ViewGroup viewGroup) {
        super(context, pVar, viewGroup);
        AppMethodBeat.i(37153);
        this.ral = pVar;
        AppMethodBeat.o(37153);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpp() {
        AppMethodBeat.i(37154);
        if (this.qZg == null) {
            this.qZg = new l(this.ral.bnR, this.context, this.ram);
            this.qZg.aZ();
            this.bnR = cpt();
        } else {
            this.qZg.dl(this.ral.bnR);
        }
        if (getGravity() == 0) {
            LayoutParams layoutParams = this.contentView.getLayoutParams();
            if (layoutParams instanceof MarginLayoutParams) {
                ((MarginLayoutParams) layoutParams).setMargins((int) this.qZo.qWS, (int) this.qZo.qWQ, (int) this.qZo.qWT, (int) this.qZo.qWR);
            }
            this.contentView.setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(37154);
    }

    /* Access modifiers changed, original: protected|final */
    public final View cpr() {
        AppMethodBeat.i(37155);
        RoundedCornerRelativeLayout roundedCornerRelativeLayout = new RoundedCornerRelativeLayout(this.context);
        this.ram = new CustomScrollView(this.context);
        this.ram.setOverScrollMode(2);
        this.ram.setHorizontalScrollBarEnabled(false);
        this.ram.setVerticalScrollBarEnabled(false);
        this.ram.setOnScrollChangeListener(new CustomScrollView.a() {
            public final void a(ScrollView scrollView, int i, int i2) {
                AppMethodBeat.i(37152);
                for (h hVar : n.this.bnR) {
                    if (hVar.cpx()) {
                        hVar.cpa();
                        hVar.cpc();
                    } else {
                        hVar.cpb();
                    }
                }
                AppMethodBeat.o(37152);
            }
        });
        roundedCornerRelativeLayout.setBackgroundColor(this.backgroundColor);
        roundedCornerRelativeLayout.addView(this.ram);
        roundedCornerRelativeLayout.setRadius((float) this.ral.qWN);
        AppMethodBeat.o(37155);
        return roundedCornerRelativeLayout;
    }

    public final void cpa() {
        AppMethodBeat.i(37156);
        for (h hVar : this.bnR) {
            if (hVar.cpx()) {
                hVar.cpa();
            }
        }
        super.cpa();
        AppMethodBeat.o(37156);
    }

    public final void cpb() {
        AppMethodBeat.i(37157);
        for (h cpb : this.bnR) {
            cpb.cpb();
        }
        super.cpb();
        AppMethodBeat.o(37157);
    }

    public final void cpc() {
        AppMethodBeat.i(37158);
        for (h hVar : this.bnR) {
            if (hVar.cpx()) {
                hVar.cpc();
            }
        }
        super.cpc();
        AppMethodBeat.o(37158);
    }

    public final void cps() {
        AppMethodBeat.i(37159);
        for (h hVar : this.bnR) {
            if (hVar.cpx()) {
                hVar.cpa();
                hVar.cpc();
            } else {
                hVar.cpb();
            }
        }
        AppMethodBeat.o(37159);
    }

    public final void coZ() {
        AppMethodBeat.i(37160);
        super.coZ();
        for (h coZ : this.bnR) {
            coZ.coZ();
        }
        AppMethodBeat.o(37160);
    }

    public final List<h> cpt() {
        AppMethodBeat.i(37161);
        ArrayList arrayList = new ArrayList(this.qZg.cqa());
        AppMethodBeat.o(37161);
        return arrayList;
    }

    public final void a(r rVar) {
        AppMethodBeat.i(37162);
        if (rVar instanceof p) {
            this.ral = (p) rVar;
        }
        super.a(rVar);
        AppMethodBeat.o(37162);
    }
}

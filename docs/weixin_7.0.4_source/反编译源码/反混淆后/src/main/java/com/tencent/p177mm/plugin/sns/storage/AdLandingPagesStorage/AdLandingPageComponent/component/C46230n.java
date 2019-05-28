package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.CustomScrollView;
import com.tencent.p177mm.p612ui.base.CustomScrollView.C40664a;
import com.tencent.p177mm.p612ui.widget.RoundedCornerRelativeLayout;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C13469p;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C29086r;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.C3910a;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C46235l;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n */
public final class C46230n extends C3910a {
    List<C13437h> bnR = new ArrayList();
    private C46235l qZg;
    private C13469p ral;
    private CustomScrollView ram;

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n$1 */
    class C134431 implements C40664a {
        C134431() {
        }

        /* renamed from: a */
        public final void mo25553a(ScrollView scrollView, int i, int i2) {
            AppMethodBeat.m2504i(37152);
            for (C13437h c13437h : C46230n.this.bnR) {
                if (c13437h.cpx()) {
                    c13437h.cpa();
                    c13437h.cpc();
                } else {
                    c13437h.cpb();
                }
            }
            AppMethodBeat.m2505o(37152);
        }
    }

    public C46230n(Context context, C13469p c13469p, ViewGroup viewGroup) {
        super(context, c13469p, viewGroup);
        AppMethodBeat.m2504i(37153);
        this.ral = c13469p;
        AppMethodBeat.m2505o(37153);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpp() {
        AppMethodBeat.m2504i(37154);
        if (this.qZg == null) {
            this.qZg = new C46235l(this.ral.bnR, this.context, this.ram);
            this.qZg.mo74249aZ();
            this.bnR = cpt();
        } else {
            this.qZg.mo74251dl(this.ral.bnR);
        }
        if (getGravity() == 0) {
            LayoutParams layoutParams = this.contentView.getLayoutParams();
            if (layoutParams instanceof MarginLayoutParams) {
                ((MarginLayoutParams) layoutParams).setMargins((int) this.qZo.qWS, (int) this.qZo.qWQ, (int) this.qZo.qWT, (int) this.qZo.qWR);
            }
            this.contentView.setLayoutParams(layoutParams);
        }
        AppMethodBeat.m2505o(37154);
    }

    /* Access modifiers changed, original: protected|final */
    public final View cpr() {
        AppMethodBeat.m2504i(37155);
        RoundedCornerRelativeLayout roundedCornerRelativeLayout = new RoundedCornerRelativeLayout(this.context);
        this.ram = new CustomScrollView(this.context);
        this.ram.setOverScrollMode(2);
        this.ram.setHorizontalScrollBarEnabled(false);
        this.ram.setVerticalScrollBarEnabled(false);
        this.ram.setOnScrollChangeListener(new C134431());
        roundedCornerRelativeLayout.setBackgroundColor(this.backgroundColor);
        roundedCornerRelativeLayout.addView(this.ram);
        roundedCornerRelativeLayout.setRadius((float) this.ral.qWN);
        AppMethodBeat.m2505o(37155);
        return roundedCornerRelativeLayout;
    }

    public final void cpa() {
        AppMethodBeat.m2504i(37156);
        for (C13437h c13437h : this.bnR) {
            if (c13437h.cpx()) {
                c13437h.cpa();
            }
        }
        super.cpa();
        AppMethodBeat.m2505o(37156);
    }

    public final void cpb() {
        AppMethodBeat.m2504i(37157);
        for (C13437h cpb : this.bnR) {
            cpb.cpb();
        }
        super.cpb();
        AppMethodBeat.m2505o(37157);
    }

    public final void cpc() {
        AppMethodBeat.m2504i(37158);
        for (C13437h c13437h : this.bnR) {
            if (c13437h.cpx()) {
                c13437h.cpc();
            }
        }
        super.cpc();
        AppMethodBeat.m2505o(37158);
    }

    public final void cps() {
        AppMethodBeat.m2504i(37159);
        for (C13437h c13437h : this.bnR) {
            if (c13437h.cpx()) {
                c13437h.cpa();
                c13437h.cpc();
            } else {
                c13437h.cpb();
            }
        }
        AppMethodBeat.m2505o(37159);
    }

    public final void coZ() {
        AppMethodBeat.m2504i(37160);
        super.coZ();
        for (C13437h coZ : this.bnR) {
            coZ.coZ();
        }
        AppMethodBeat.m2505o(37160);
    }

    public final List<C13437h> cpt() {
        AppMethodBeat.m2504i(37161);
        ArrayList arrayList = new ArrayList(this.qZg.cqa());
        AppMethodBeat.m2505o(37161);
        return arrayList;
    }

    /* renamed from: a */
    public final void mo25535a(C29086r c29086r) {
        AppMethodBeat.m2504i(37162);
        if (c29086r instanceof C13469p) {
            this.ral = (C13469p) c29086r;
        }
        super.mo25535a(c29086r);
        AppMethodBeat.m2505o(37162);
    }
}

package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C13471s;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.C3910a;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C46235l;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q */
public final class C7111q extends C3910a {
    private C46235l qZg;
    LinearLayout raK;

    public C7111q(Context context, C13471s c13471s, ViewGroup viewGroup) {
        super(context, c13471s, viewGroup);
    }

    public final void cpa() {
        AppMethodBeat.m2504i(37195);
        for (C13437h c13437h : this.qZg.cqa()) {
            if (c13437h.cpx()) {
                c13437h.cpa();
            }
        }
        super.cpa();
        AppMethodBeat.m2505o(37195);
    }

    public final void cpc() {
        AppMethodBeat.m2504i(37196);
        for (C13437h c13437h : this.qZg.cqa()) {
            if (c13437h.cpx()) {
                c13437h.cpc();
            }
        }
        super.cpc();
        AppMethodBeat.m2505o(37196);
    }

    public final void cps() {
        AppMethodBeat.m2504i(37197);
        for (C13437h c13437h : this.qZg.cqa()) {
            if (c13437h.cpx()) {
                c13437h.cpa();
                c13437h.cpc();
            } else {
                c13437h.cpb();
            }
        }
        AppMethodBeat.m2505o(37197);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpq() {
        AppMethodBeat.m2504i(37198);
        LayoutParams layoutParams = this.contentView.getLayoutParams();
        if (layoutParams instanceof MarginLayoutParams) {
            ((MarginLayoutParams) layoutParams).setMargins((int) this.qZo.qWS, (int) this.qZo.qWQ, (int) this.qZo.qWT, (int) this.qZo.qWR);
        }
        this.contentView.setLayoutParams(layoutParams);
        AppMethodBeat.m2505o(37198);
    }

    public final void cpb() {
        AppMethodBeat.m2504i(37199);
        for (C13437h cpb : this.qZg.cqa()) {
            cpb.cpb();
        }
        super.cpb();
        AppMethodBeat.m2505o(37199);
    }

    public final void coZ() {
        AppMethodBeat.m2504i(37200);
        super.coZ();
        for (C13437h coZ : this.qZg.cqa()) {
            coZ.coZ();
        }
        AppMethodBeat.m2505o(37200);
    }

    public final void cpk() {
        AppMethodBeat.m2504i(37202);
        this.raK = (LinearLayout) this.contentView.findViewById(2131827635);
        AppMethodBeat.m2505o(37202);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getLayout() {
        return 2130970725;
    }

    public final List<C13437h> cpt() {
        AppMethodBeat.m2504i(37203);
        ArrayList arrayList = new ArrayList(this.qZg.cqa());
        AppMethodBeat.m2505o(37203);
        return arrayList;
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpp() {
        AppMethodBeat.m2504i(37201);
        if (((C13471s) this.qZo).qXd == 0) {
            this.raK.setOrientation(1);
        } else if (((C13471s) this.qZo).qXd == 1) {
            this.raK.setOrientation(0);
        }
        if (this.qZg == null) {
            this.qZg = new C46235l(((C13471s) this.qZo).qXc, this.context, this.raK);
            this.qZg.mo74249aZ();
            AppMethodBeat.m2505o(37201);
            return;
        }
        this.qZg.mo74251dl(((C13471s) this.qZo).qXc);
        AppMethodBeat.m2505o(37201);
    }
}

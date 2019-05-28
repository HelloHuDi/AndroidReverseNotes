package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l;
import java.util.ArrayList;
import java.util.List;

public final class q extends a {
    private l qZg;
    LinearLayout raK;

    public q(Context context, s sVar, ViewGroup viewGroup) {
        super(context, sVar, viewGroup);
    }

    public final void cpa() {
        AppMethodBeat.i(37195);
        for (h hVar : this.qZg.cqa()) {
            if (hVar.cpx()) {
                hVar.cpa();
            }
        }
        super.cpa();
        AppMethodBeat.o(37195);
    }

    public final void cpc() {
        AppMethodBeat.i(37196);
        for (h hVar : this.qZg.cqa()) {
            if (hVar.cpx()) {
                hVar.cpc();
            }
        }
        super.cpc();
        AppMethodBeat.o(37196);
    }

    public final void cps() {
        AppMethodBeat.i(37197);
        for (h hVar : this.qZg.cqa()) {
            if (hVar.cpx()) {
                hVar.cpa();
                hVar.cpc();
            } else {
                hVar.cpb();
            }
        }
        AppMethodBeat.o(37197);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpq() {
        AppMethodBeat.i(37198);
        LayoutParams layoutParams = this.contentView.getLayoutParams();
        if (layoutParams instanceof MarginLayoutParams) {
            ((MarginLayoutParams) layoutParams).setMargins((int) this.qZo.qWS, (int) this.qZo.qWQ, (int) this.qZo.qWT, (int) this.qZo.qWR);
        }
        this.contentView.setLayoutParams(layoutParams);
        AppMethodBeat.o(37198);
    }

    public final void cpb() {
        AppMethodBeat.i(37199);
        for (h cpb : this.qZg.cqa()) {
            cpb.cpb();
        }
        super.cpb();
        AppMethodBeat.o(37199);
    }

    public final void coZ() {
        AppMethodBeat.i(37200);
        super.coZ();
        for (h coZ : this.qZg.cqa()) {
            coZ.coZ();
        }
        AppMethodBeat.o(37200);
    }

    public final void cpk() {
        AppMethodBeat.i(37202);
        this.raK = (LinearLayout) this.contentView.findViewById(R.id.efo);
        AppMethodBeat.o(37202);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getLayout() {
        return R.layout.au9;
    }

    public final List<h> cpt() {
        AppMethodBeat.i(37203);
        ArrayList arrayList = new ArrayList(this.qZg.cqa());
        AppMethodBeat.o(37203);
        return arrayList;
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpp() {
        AppMethodBeat.i(37201);
        if (((s) this.qZo).qXd == 0) {
            this.raK.setOrientation(1);
        } else if (((s) this.qZo).qXd == 1) {
            this.raK.setOrientation(0);
        }
        if (this.qZg == null) {
            this.qZg = new l(((s) this.qZo).qXc, this.context, this.raK);
            this.qZg.aZ();
            AppMethodBeat.o(37201);
            return;
        }
        this.qZg.dl(((s) this.qZo).qXc);
        AppMethodBeat.o(37201);
    }
}

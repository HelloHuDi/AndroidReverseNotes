package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l;
import java.util.ArrayList;
import java.util.List;

public final class d extends a {
    private List<h> bnR = new ArrayList();
    private q qZf;
    private l qZg;

    public d(Context context, q qVar, ViewGroup viewGroup) {
        super(context, qVar, viewGroup);
        AppMethodBeat.i(37038);
        this.qZf = qVar;
        AppMethodBeat.o(37038);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpp() {
        AppMethodBeat.i(37039);
        if (this.qZg == null) {
            this.qZg = new l(this.qZf.bnR, this.context, (FrameLayout) this.contentView);
            this.qZg.aZ();
            this.bnR = cpt();
            AppMethodBeat.o(37039);
            return;
        }
        this.qZg.dl(this.qZf.bnR);
        AppMethodBeat.o(37039);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpq() {
        AppMethodBeat.i(37040);
        LayoutParams layoutParams = this.contentView.getLayoutParams();
        if (layoutParams instanceof MarginLayoutParams) {
            ((MarginLayoutParams) layoutParams).setMargins((int) this.qZo.qWS, (int) this.qZo.qWQ, (int) this.qZo.qWT, (int) this.qZo.qWR);
        }
        this.contentView.setLayoutParams(layoutParams);
        AppMethodBeat.o(37040);
    }

    /* Access modifiers changed, original: protected|final */
    public final View cpr() {
        AppMethodBeat.i(37041);
        FrameLayout frameLayout = new FrameLayout(this.context);
        AppMethodBeat.o(37041);
        return frameLayout;
    }

    public final void cpa() {
        AppMethodBeat.i(37042);
        for (h hVar : this.bnR) {
            if (hVar.cpx()) {
                hVar.cpa();
            }
        }
        super.cpa();
        AppMethodBeat.o(37042);
    }

    public final void cpb() {
        AppMethodBeat.i(37043);
        for (h cpb : this.bnR) {
            cpb.cpb();
        }
        super.cpb();
        AppMethodBeat.o(37043);
    }

    public final void cpc() {
        AppMethodBeat.i(37044);
        for (h hVar : this.bnR) {
            if (hVar.cpx()) {
                hVar.cpc();
            }
        }
        super.cpc();
        AppMethodBeat.o(37044);
    }

    public final void cps() {
        AppMethodBeat.i(37045);
        for (h hVar : this.bnR) {
            if (hVar.cpx()) {
                hVar.cpa();
                hVar.cpc();
            } else {
                hVar.cpb();
            }
        }
        AppMethodBeat.o(37045);
    }

    public final void coZ() {
        AppMethodBeat.i(37046);
        super.coZ();
        for (h coZ : this.bnR) {
            coZ.coZ();
        }
        AppMethodBeat.o(37046);
    }

    public final List<h> cpt() {
        AppMethodBeat.i(37047);
        ArrayList arrayList = new ArrayList(this.qZg.cqa());
        AppMethodBeat.o(37047);
        return arrayList;
    }

    public final void a(r rVar) {
        AppMethodBeat.i(37048);
        if (rVar instanceof q) {
            this.qZf = (q) rVar;
        }
        super.a(rVar);
        AppMethodBeat.o(37048);
    }
}

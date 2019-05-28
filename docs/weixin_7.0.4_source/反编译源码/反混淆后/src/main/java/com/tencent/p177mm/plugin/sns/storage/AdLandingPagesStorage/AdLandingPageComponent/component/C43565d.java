package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C13470q;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C29086r;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.C3910a;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C46235l;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.d */
public final class C43565d extends C3910a {
    private List<C13437h> bnR = new ArrayList();
    private C13470q qZf;
    private C46235l qZg;

    public C43565d(Context context, C13470q c13470q, ViewGroup viewGroup) {
        super(context, c13470q, viewGroup);
        AppMethodBeat.m2504i(37038);
        this.qZf = c13470q;
        AppMethodBeat.m2505o(37038);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpp() {
        AppMethodBeat.m2504i(37039);
        if (this.qZg == null) {
            this.qZg = new C46235l(this.qZf.bnR, this.context, (FrameLayout) this.contentView);
            this.qZg.mo74249aZ();
            this.bnR = cpt();
            AppMethodBeat.m2505o(37039);
            return;
        }
        this.qZg.mo74251dl(this.qZf.bnR);
        AppMethodBeat.m2505o(37039);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpq() {
        AppMethodBeat.m2504i(37040);
        LayoutParams layoutParams = this.contentView.getLayoutParams();
        if (layoutParams instanceof MarginLayoutParams) {
            ((MarginLayoutParams) layoutParams).setMargins((int) this.qZo.qWS, (int) this.qZo.qWQ, (int) this.qZo.qWT, (int) this.qZo.qWR);
        }
        this.contentView.setLayoutParams(layoutParams);
        AppMethodBeat.m2505o(37040);
    }

    /* Access modifiers changed, original: protected|final */
    public final View cpr() {
        AppMethodBeat.m2504i(37041);
        FrameLayout frameLayout = new FrameLayout(this.context);
        AppMethodBeat.m2505o(37041);
        return frameLayout;
    }

    public final void cpa() {
        AppMethodBeat.m2504i(37042);
        for (C13437h c13437h : this.bnR) {
            if (c13437h.cpx()) {
                c13437h.cpa();
            }
        }
        super.cpa();
        AppMethodBeat.m2505o(37042);
    }

    public final void cpb() {
        AppMethodBeat.m2504i(37043);
        for (C13437h cpb : this.bnR) {
            cpb.cpb();
        }
        super.cpb();
        AppMethodBeat.m2505o(37043);
    }

    public final void cpc() {
        AppMethodBeat.m2504i(37044);
        for (C13437h c13437h : this.bnR) {
            if (c13437h.cpx()) {
                c13437h.cpc();
            }
        }
        super.cpc();
        AppMethodBeat.m2505o(37044);
    }

    public final void cps() {
        AppMethodBeat.m2504i(37045);
        for (C13437h c13437h : this.bnR) {
            if (c13437h.cpx()) {
                c13437h.cpa();
                c13437h.cpc();
            } else {
                c13437h.cpb();
            }
        }
        AppMethodBeat.m2505o(37045);
    }

    public final void coZ() {
        AppMethodBeat.m2504i(37046);
        super.coZ();
        for (C13437h coZ : this.bnR) {
            coZ.coZ();
        }
        AppMethodBeat.m2505o(37046);
    }

    public final List<C13437h> cpt() {
        AppMethodBeat.m2504i(37047);
        ArrayList arrayList = new ArrayList(this.qZg.cqa());
        AppMethodBeat.m2505o(37047);
        return arrayList;
    }

    /* renamed from: a */
    public final void mo25535a(C29086r c29086r) {
        AppMethodBeat.m2504i(37048);
        if (c29086r instanceof C13470q) {
            this.qZf = (C13470q) c29086r;
        }
        super.mo25535a(c29086r);
        AppMethodBeat.m2505o(37048);
    }
}

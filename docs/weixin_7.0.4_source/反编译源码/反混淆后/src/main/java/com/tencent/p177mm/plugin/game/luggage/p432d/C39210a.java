package com.tencent.p177mm.plugin.game.luggage.p432d;

import android.os.Bundle;
import android.view.View;
import com.tencent.luggage.p146d.C41709g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.webview.luggage.C22829j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.game.luggage.d.a */
public final class C39210a extends C12140e {
    public C39210a(C41709g c41709g, Bundle bundle) {
        super(c41709g, null, bundle);
        AppMethodBeat.m2504i(135911);
        if (this.bPO != null) {
            this.bPO.setEnableGesture(false);
        }
        ((C3228d) getWebView()).setShouldCleanPkgWhenDestroy(true);
        AppMethodBeat.m2505o(135911);
    }

    /* renamed from: wR */
    public final View mo20042wR() {
        AppMethodBeat.m2504i(135912);
        View wR = super.mo20042wR();
        this.uhS.setBackgroundColor(0);
        AppMethodBeat.m2505o(135912);
        return wR;
    }

    /* renamed from: wU */
    public final void mo20045wU() {
        AppMethodBeat.m2504i(135913);
        C4990ab.m7416i("MicroMsg.GameFloatLayerWebPage", "onForeground");
        super.mo20045wU();
        mo41795cl("微信游戏", 0);
        C22829j c22829j = this.uhR;
        c22829j.setPullDownEnabled(false);
        c22829j.uiW.setVisibility(8);
        c22829j.uiV.setBackgroundColor(0);
        c22829j.setBackgroundColor(0);
        AppMethodBeat.m2505o(135913);
    }

    /* renamed from: hK */
    public final void mo23979hK(boolean z) {
    }

    public final void bDv() {
    }

    /* renamed from: NP */
    public final void mo41775NP(String str) {
        AppMethodBeat.m2504i(135914);
        this.uhR.setPullDownEnabled(false);
        AppMethodBeat.m2505o(135914);
    }

    public final boolean aYc() {
        return false;
    }

    /* renamed from: cl */
    public final void mo41795cl(String str, int i) {
        AppMethodBeat.m2504i(135915);
        super.mo41795cl("微信游戏", i);
        AppMethodBeat.m2505o(135915);
    }

    public final void bDw() {
        AppMethodBeat.m2504i(135916);
        finish();
        AppMethodBeat.m2505o(135916);
    }
}

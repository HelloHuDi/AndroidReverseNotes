package com.tencent.mm.plugin.game.luggage.d;

import android.os.Bundle;
import android.view.View;
import com.tencent.luggage.d.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.j;
import com.tencent.mm.sdk.platformtools.ab;

public final class a extends e {
    public a(g gVar, Bundle bundle) {
        super(gVar, null, bundle);
        AppMethodBeat.i(135911);
        if (this.bPO != null) {
            this.bPO.setEnableGesture(false);
        }
        ((d) getWebView()).setShouldCleanPkgWhenDestroy(true);
        AppMethodBeat.o(135911);
    }

    public final View wR() {
        AppMethodBeat.i(135912);
        View wR = super.wR();
        this.uhS.setBackgroundColor(0);
        AppMethodBeat.o(135912);
        return wR;
    }

    public final void wU() {
        AppMethodBeat.i(135913);
        ab.i("MicroMsg.GameFloatLayerWebPage", "onForeground");
        super.wU();
        cl("微信游戏", 0);
        j jVar = this.uhR;
        jVar.setPullDownEnabled(false);
        jVar.uiW.setVisibility(8);
        jVar.uiV.setBackgroundColor(0);
        jVar.setBackgroundColor(0);
        AppMethodBeat.o(135913);
    }

    public final void hK(boolean z) {
    }

    public final void bDv() {
    }

    public final void NP(String str) {
        AppMethodBeat.i(135914);
        this.uhR.setPullDownEnabled(false);
        AppMethodBeat.o(135914);
    }

    public final boolean aYc() {
        return false;
    }

    public final void cl(String str, int i) {
        AppMethodBeat.i(135915);
        super.cl("微信游戏", i);
        AppMethodBeat.o(135915);
    }

    public final void bDw() {
        AppMethodBeat.i(135916);
        finish();
        AppMethodBeat.o(135916);
    }
}

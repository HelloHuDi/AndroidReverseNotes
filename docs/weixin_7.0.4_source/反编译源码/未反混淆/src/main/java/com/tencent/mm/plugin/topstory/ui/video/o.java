package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.PluginTopStory;
import com.tencent.mm.plugin.topstory.a.b.a;
import com.tencent.mm.plugin.topstory.a.b.b;
import com.tencent.mm.plugin.topstory.c;
import com.tencent.mm.protocal.protobuf.chv;
import com.tencent.mm.protocal.protobuf.chw;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public final class o {
    private chw sAX;
    private b sDo;
    private int sEV;
    Map<String, b> sFn = new HashMap();
    public int sFo = 2;
    public a sFp;

    public o() {
        AppMethodBeat.i(1792);
        AppMethodBeat.o(1792);
    }

    public final void e(chw chw) {
        AppMethodBeat.i(1793);
        if (chw == null) {
            ab.i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "setVideoInfoExpose null");
        }
        b bVar = new b(chw);
        if (this.sFn.containsKey(bVar.sAX.xgS)) {
            ((b) this.sFn.get(bVar.sAX.xgS)).sAX = chw;
            AppMethodBeat.o(1793);
            return;
        }
        this.sFn.put(bVar.sAX.xgS, bVar);
        ab.i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "setVideoInfoExpose %s", chw);
        AppMethodBeat.o(1793);
    }

    public final void d(b bVar) {
        this.sEV++;
        this.sDo = bVar;
    }

    public final void aEX() {
        AppMethodBeat.i(1794);
        this.sEV--;
        ab.i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "onUIDestroy %d", Integer.valueOf(this.sEV));
        if (this.sEV <= 0) {
            cGS();
            this.sDo = null;
        }
        AppMethodBeat.o(1794);
    }

    public final void f(chw chw) {
        AppMethodBeat.i(1795);
        e(chw);
        ((b) this.sFn.get(chw.xgS)).sAY = true;
        AppMethodBeat.o(1795);
    }

    public final void cGS() {
        AppMethodBeat.i(1796);
        HashSet hashSet = new HashSet();
        for (b bVar : this.sFn.values()) {
            if (!bVar.pZZ) {
                hashSet.add(bVar);
                bVar.pZZ = true;
            }
        }
        if (this.sDo != null) {
            ((com.tencent.mm.plugin.topstory.a.b) g.M(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.sDo.cFT(), hashSet);
        }
        AppMethodBeat.o(1796);
    }

    public final void a(chw chw, int i, String str) {
        AppMethodBeat.i(1797);
        this.sAX = chw;
        this.sFp = new a();
        this.sFp.sAE = System.currentTimeMillis();
        this.sFp.sAM = 2;
        this.sFp.sAL = (long) this.sFo;
        this.sFp.position = (long) (i + 1);
        chv cFT = this.sDo.cFT();
        this.sFp.fjS = cFT.scene + "_" + cFT.hlm + "_" + cFT.xgG;
        if (this.sDo.isFullscreenMode()) {
            this.sFp.sAK = 1;
        }
        this.sFo = 2;
        ab.i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "startVideoPlay %s %s %s reportInfo: %d %d", str, chw.xgS, chw.title, Long.valueOf(this.sFp.sAL), Long.valueOf(this.sFp.sAM));
        AppMethodBeat.o(1797);
    }

    public final void b(chv chv) {
        AppMethodBeat.i(1798);
        ((PluginTopStory) g.M(PluginTopStory.class)).getReporter();
        c.a(chv, this.sAX, this.sFp);
        this.sAX = null;
        this.sFp = null;
        AppMethodBeat.o(1798);
    }
}

package com.tencent.p177mm.plugin.topstory.p541ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.topstory.C4204c;
import com.tencent.p177mm.plugin.topstory.PluginTopStory;
import com.tencent.p177mm.plugin.topstory.p539a.C13943b;
import com.tencent.p177mm.plugin.topstory.p539a.p1414b.C29428a;
import com.tencent.p177mm.plugin.topstory.p539a.p1414b.C39960b;
import com.tencent.p177mm.protocal.protobuf.chv;
import com.tencent.p177mm.protocal.protobuf.chw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.topstory.ui.video.o */
public final class C46311o {
    private chw sAX;
    private C4232b sDo;
    private int sEV;
    Map<String, C39960b> sFn = new HashMap();
    public int sFo = 2;
    public C29428a sFp;

    public C46311o() {
        AppMethodBeat.m2504i(1792);
        AppMethodBeat.m2505o(1792);
    }

    /* renamed from: e */
    public final void mo74506e(chw chw) {
        AppMethodBeat.m2504i(1793);
        if (chw == null) {
            C4990ab.m7416i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "setVideoInfoExpose null");
        }
        C39960b c39960b = new C39960b(chw);
        if (this.sFn.containsKey(c39960b.sAX.xgS)) {
            ((C39960b) this.sFn.get(c39960b.sAX.xgS)).sAX = chw;
            AppMethodBeat.m2505o(1793);
            return;
        }
        this.sFn.put(c39960b.sAX.xgS, c39960b);
        C4990ab.m7417i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "setVideoInfoExpose %s", chw);
        AppMethodBeat.m2505o(1793);
    }

    /* renamed from: d */
    public final void mo74505d(C4232b c4232b) {
        this.sEV++;
        this.sDo = c4232b;
    }

    public final void aEX() {
        AppMethodBeat.m2504i(1794);
        this.sEV--;
        C4990ab.m7417i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "onUIDestroy %d", Integer.valueOf(this.sEV));
        if (this.sEV <= 0) {
            cGS();
            this.sDo = null;
        }
        AppMethodBeat.m2505o(1794);
    }

    /* renamed from: f */
    public final void mo74507f(chw chw) {
        AppMethodBeat.m2504i(1795);
        mo74506e(chw);
        ((C39960b) this.sFn.get(chw.xgS)).sAY = true;
        AppMethodBeat.m2505o(1795);
    }

    public final void cGS() {
        AppMethodBeat.m2504i(1796);
        HashSet hashSet = new HashSet();
        for (C39960b c39960b : this.sFn.values()) {
            if (!c39960b.pZZ) {
                hashSet.add(c39960b);
                c39960b.pZZ = true;
            }
        }
        if (this.sDo != null) {
            ((C13943b) C1720g.m3530M(C13943b.class)).getReporter().mo9125a(this.sDo.cFT(), hashSet);
        }
        AppMethodBeat.m2505o(1796);
    }

    /* renamed from: a */
    public final void mo74501a(chw chw, int i, String str) {
        AppMethodBeat.m2504i(1797);
        this.sAX = chw;
        this.sFp = new C29428a();
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
        C4990ab.m7417i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "startVideoPlay %s %s %s reportInfo: %d %d", str, chw.xgS, chw.title, Long.valueOf(this.sFp.sAL), Long.valueOf(this.sFp.sAM));
        AppMethodBeat.m2505o(1797);
    }

    /* renamed from: b */
    public final void mo74503b(chv chv) {
        AppMethodBeat.m2504i(1798);
        ((PluginTopStory) C1720g.m3530M(PluginTopStory.class)).getReporter();
        C4204c.m6547a(chv, this.sAX, this.sFp);
        this.sAX = null;
        this.sFp = null;
        AppMethodBeat.m2505o(1798);
    }
}

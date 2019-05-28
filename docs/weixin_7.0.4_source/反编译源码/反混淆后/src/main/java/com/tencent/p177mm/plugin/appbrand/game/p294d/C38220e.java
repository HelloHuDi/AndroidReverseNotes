package com.tencent.p177mm.plugin.appbrand.game.p294d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.report.quality.C33522k;
import com.tencent.p177mm.plugin.appbrand.report.quality.QualitySessionRuntime;

/* renamed from: com.tencent.mm.plugin.appbrand.game.d.e */
public final class C38220e {
    public String appId;
    public int axy;
    public int css;
    public int hrT;
    public int hrU;
    public C33522k hrV;

    /* renamed from: com.tencent.mm.plugin.appbrand.game.d.e$a */
    public enum C19236a {
        FPS(1),
        CPU(2),
        MEM(3),
        DRAW_CALL(4),
        TRIANGLE(5),
        VERTEX(6),
        NATIVE_MEM(101),
        DALVIK_MEM(102),
        OTHER_MEM(103),
        MEM_DELTA(104),
        VARIANCE_FPS(105);
        
        public int hsh;

        static {
            AppMethodBeat.m2505o(130189);
        }

        private C19236a(int i) {
            this.hsh = i;
        }
    }

    public C38220e(QualitySessionRuntime qualitySessionRuntime, C33522k c33522k) {
        this.appId = qualitySessionRuntime.appId;
        this.css = qualitySessionRuntime.iCZ;
        this.axy = qualitySessionRuntime.iDa;
        this.hrV = c33522k;
    }
}

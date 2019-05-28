package com.tencent.mm.plugin.appbrand.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.k;

public final class e {
    public String appId;
    public int axy;
    public int css;
    public int hrT;
    public int hrU;
    public k hrV;

    public enum a {
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
            AppMethodBeat.o(130189);
        }

        private a(int i) {
            this.hsh = i;
        }
    }

    public e(QualitySessionRuntime qualitySessionRuntime, k kVar) {
        this.appId = qualitySessionRuntime.appId;
        this.css = qualitySessionRuntime.iCZ;
        this.axy = qualitySessionRuntime.iDa;
        this.hrV = kVar;
    }
}

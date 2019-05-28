package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.protocal.protobuf.aus;
import com.tencent.mm.protocal.protobuf.axc;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.cache.VideoMemoryManager;
import java.util.LinkedList;
import java.util.List;

public final class f {
    public int ulO;
    public int ulP;
    public int ulQ;
    public final List<axc> ulR;
    public int ulS;
    public long ulT;

    public static final class a {
        private static final f ulU = new f();

        static {
            AppMethodBeat.i(6579);
            AppMethodBeat.o(6579);
        }
    }

    /* synthetic */ f(byte b) {
        this();
    }

    private f() {
        AppMethodBeat.i(6580);
        this.ulO = 20480;
        this.ulP = 30720;
        this.ulQ = VideoMemoryManager.VIDEO_CACHE_MEM_CACHE_MIN_SIZE_IN_KB;
        this.ulR = new LinkedList();
        this.ulS = 0;
        this.ulT = 0;
        AppMethodBeat.o(6580);
    }

    public static void ea(List<aus> list) {
        AppMethodBeat.i(6581);
        if (bo.ek(list)) {
            AppMethodBeat.o(6581);
            return;
        }
        for (aus aus : list) {
            g.cYH().ulM.A(Integer.valueOf(aus.wyT), Long.valueOf(bo.anT() + ((long) aus.wyU)));
        }
        g.cYH().cXu();
        AppMethodBeat.o(6581);
    }
}

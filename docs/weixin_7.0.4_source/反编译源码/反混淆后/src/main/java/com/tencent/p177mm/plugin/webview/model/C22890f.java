package com.tencent.p177mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.webview.modeltools.C29833g;
import com.tencent.p177mm.protocal.protobuf.aus;
import com.tencent.p177mm.protocal.protobuf.axc;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.cache.VideoMemoryManager;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.webview.model.f */
public final class C22890f {
    public int ulO;
    public int ulP;
    public int ulQ;
    public final List<axc> ulR;
    public int ulS;
    public long ulT;

    /* renamed from: com.tencent.mm.plugin.webview.model.f$a */
    public static final class C22891a {
        private static final C22890f ulU = new C22890f();

        static {
            AppMethodBeat.m2504i(6579);
            AppMethodBeat.m2505o(6579);
        }
    }

    /* synthetic */ C22890f(byte b) {
        this();
    }

    private C22890f() {
        AppMethodBeat.m2504i(6580);
        this.ulO = 20480;
        this.ulP = 30720;
        this.ulQ = VideoMemoryManager.VIDEO_CACHE_MEM_CACHE_MIN_SIZE_IN_KB;
        this.ulR = new LinkedList();
        this.ulS = 0;
        this.ulT = 0;
        AppMethodBeat.m2505o(6580);
    }

    /* renamed from: ea */
    public static void m34739ea(List<aus> list) {
        AppMethodBeat.m2504i(6581);
        if (C5046bo.m7548ek(list)) {
            AppMethodBeat.m2505o(6581);
            return;
        }
        for (aus aus : list) {
            C29833g.cYH().ulM.mo27466A(Integer.valueOf(aus.wyT), Long.valueOf(C5046bo.anT() + ((long) aus.wyU)));
        }
        C29833g.cYH().cXu();
        AppMethodBeat.m2505o(6581);
    }
}

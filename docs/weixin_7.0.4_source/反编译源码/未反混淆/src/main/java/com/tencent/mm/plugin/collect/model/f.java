package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.protocal.protobuf.oy;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;

public final class f implements com.tencent.mm.ai.f {
    public static f kBJ;
    private final String TAG = "MicroMsg.F2fGetPayUrlManager";
    public Map<l, a> jxd = new HashMap();

    public interface a {
        void a(boolean z, oy oyVar);

        void dz(String str, String str2);
    }

    public f() {
        AppMethodBeat.i(40932);
        AppMethodBeat.o(40932);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(40933);
        if (mVar instanceof l) {
            l lVar = (l) mVar;
            a aVar = (a) this.jxd.get(mVar);
            if (aVar == null) {
                ab.w("MicroMsg.F2fGetPayUrlManager", "no match callback");
                AppMethodBeat.o(40933);
                return;
            }
            if (i == 0 && i2 == 0) {
                aVar.a(true, lVar.kCk);
            } else {
                ab.e("MicroMsg.F2fGetPayUrlManager", "net error: %s", lVar);
                aVar.a(false, lVar.kCk);
            }
            this.jxd.remove(mVar);
        }
        AppMethodBeat.o(40933);
    }
}

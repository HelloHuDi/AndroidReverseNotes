package com.tencent.p177mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.protocal.protobuf.C40555oy;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.collect.model.f */
public final class C33855f implements C1202f {
    public static C33855f kBJ;
    private final String TAG = "MicroMsg.F2fGetPayUrlManager";
    public Map<C6830l, C11415a> jxd = new HashMap();

    /* renamed from: com.tencent.mm.plugin.collect.model.f$a */
    public interface C11415a {
        /* renamed from: a */
        void mo23166a(boolean z, C40555oy c40555oy);

        /* renamed from: dz */
        void mo23167dz(String str, String str2);
    }

    public C33855f() {
        AppMethodBeat.m2504i(40932);
        AppMethodBeat.m2505o(40932);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(40933);
        if (c1207m instanceof C6830l) {
            C6830l c6830l = (C6830l) c1207m;
            C11415a c11415a = (C11415a) this.jxd.get(c1207m);
            if (c11415a == null) {
                C4990ab.m7420w("MicroMsg.F2fGetPayUrlManager", "no match callback");
                AppMethodBeat.m2505o(40933);
                return;
            }
            if (i == 0 && i2 == 0) {
                c11415a.mo23166a(true, c6830l.kCk);
            } else {
                C4990ab.m7413e("MicroMsg.F2fGetPayUrlManager", "net error: %s", c6830l);
                c11415a.mo23166a(false, c6830l.kCk);
            }
            this.jxd.remove(c1207m);
        }
        AppMethodBeat.m2505o(40933);
    }
}

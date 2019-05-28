package com.tencent.p177mm.plugin.game.commlib;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.api.bucket.C18523a;
import com.tencent.p177mm.kernel.api.bucket.C26346d;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.plugin.game.commlib.p1269b.C20944b;
import com.tencent.p177mm.plugin.game.commlib.p977a.C34261a;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.game.commlib.d */
public final class C12107d implements C18523a, C26346d, C34261a {
    private C20944b mTu;

    /* renamed from: com.tencent.mm.plugin.game.commlib.d$1 */
    class C121081 implements C1366d {
        C121081() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C20944b.fnj;
        }
    }

    /* renamed from: a */
    public final void mo23946a(String str, C1331a c1331a) {
        AppMethodBeat.m2504i(59406);
        this.mTu.mo36286b(str, c1331a);
        AppMethodBeat.m2505o(59406);
    }

    /* renamed from: NK */
    public final byte[] mo23945NK(String str) {
        AppMethodBeat.m2504i(59407);
        byte[] NK = this.mTu.mo36285NK(str);
        AppMethodBeat.m2505o(59407);
        return NK;
    }

    public final HashMap<Integer, C1366d> collectDatabaseFactory() {
        AppMethodBeat.m2504i(59408);
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf("GAME_CENTER_MSG_INFO_TABLE".hashCode()), new C121081());
        AppMethodBeat.m2505o(59408);
        return hashMap;
    }

    public final void onDataBaseOpened(C7480h c7480h, C7480h c7480h2) {
        AppMethodBeat.m2504i(59409);
        this.mTu = new C20944b(c7480h);
        AppMethodBeat.m2505o(59409);
    }

    public final void onDataBaseClosed(C7480h c7480h, C7480h c7480h2) {
    }
}

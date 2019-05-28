package com.tencent.p177mm.roomsdk.p1086a.p1342c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.roomsdk.p1086a.C15409a;
import com.tencent.p177mm.roomsdk.p1086a.p1341b.C46609a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.roomsdk.a.c.d */
public final class C30267d {
    private C1202f fur = new C302661();
    protected C46609a xuY;
    protected C46609a xuZ;
    protected C46609a xva;
    private int xvi = 700;

    /* renamed from: com.tencent.mm.roomsdk.a.c.d$1 */
    class C302661 implements C1202f {
        C302661() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(80270);
            if (c1207m instanceof C15409a) {
                ((C15409a) c1207m).mo27452a(C30267d.this.xva);
            }
            if (C30267d.this.xva != null) {
                C30267d.this.xva.mo11081a(i, i2, str, C30267d.this.xva);
            }
            if (i == 0 && i2 == 0) {
                if (C30267d.this.xuY != null) {
                    C30267d.this.xuY.mo11081a(i, i2, str, C30267d.this.xuY);
                    AppMethodBeat.m2505o(80270);
                    return;
                }
            } else if (C30267d.this.xuZ != null) {
                C30267d.this.xuZ.mo11081a(i, i2, str, C30267d.this.xuZ);
            }
            AppMethodBeat.m2505o(80270);
        }
    }

    public C30267d() {
        AppMethodBeat.m2504i(80271);
        AppMethodBeat.m2505o(80271);
    }

    /* renamed from: e */
    public final C30267d mo48456e(C46609a c46609a) {
        this.xuY = c46609a;
        return this;
    }

    /* renamed from: f */
    public final C30267d mo48457f(C46609a c46609a) {
        this.xuZ = c46609a;
        return this;
    }

    public final C30267d dmY() {
        AppMethodBeat.m2504i(80272);
        C4990ab.m7416i("MicroMsg.RoomWatchCallbackFactory", "alive");
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(this.xvi, this.fur);
        AppMethodBeat.m2505o(80272);
        return this;
    }

    public final void dead() {
        AppMethodBeat.m2504i(80273);
        C4990ab.m7416i("MicroMsg.RoomWatchCallbackFactory", "dead");
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(this.xvi, this.fur);
        AppMethodBeat.m2505o(80273);
    }
}

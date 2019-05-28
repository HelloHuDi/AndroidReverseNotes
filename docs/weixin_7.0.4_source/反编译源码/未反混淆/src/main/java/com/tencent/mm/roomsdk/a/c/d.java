package com.tencent.mm.roomsdk.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.roomsdk.a.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class d {
    private f fur = new f() {
        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(80270);
            if (mVar instanceof a) {
                ((a) mVar).a(d.this.xva);
            }
            if (d.this.xva != null) {
                d.this.xva.a(i, i2, str, d.this.xva);
            }
            if (i == 0 && i2 == 0) {
                if (d.this.xuY != null) {
                    d.this.xuY.a(i, i2, str, d.this.xuY);
                    AppMethodBeat.o(80270);
                    return;
                }
            } else if (d.this.xuZ != null) {
                d.this.xuZ.a(i, i2, str, d.this.xuZ);
            }
            AppMethodBeat.o(80270);
        }
    };
    protected com.tencent.mm.roomsdk.a.b.a xuY;
    protected com.tencent.mm.roomsdk.a.b.a xuZ;
    protected com.tencent.mm.roomsdk.a.b.a xva;
    private int xvi = 700;

    public d() {
        AppMethodBeat.i(80271);
        AppMethodBeat.o(80271);
    }

    public final d e(com.tencent.mm.roomsdk.a.b.a aVar) {
        this.xuY = aVar;
        return this;
    }

    public final d f(com.tencent.mm.roomsdk.a.b.a aVar) {
        this.xuZ = aVar;
        return this;
    }

    public final d dmY() {
        AppMethodBeat.i(80272);
        ab.i("MicroMsg.RoomWatchCallbackFactory", "alive");
        g.RQ();
        g.RO().eJo.a(this.xvi, this.fur);
        AppMethodBeat.o(80272);
        return this;
    }

    public final void dead() {
        AppMethodBeat.i(80273);
        ab.i("MicroMsg.RoomWatchCallbackFactory", "dead");
        g.RQ();
        g.RO().eJo.b(this.xvi, this.fur);
        AppMethodBeat.o(80273);
    }
}

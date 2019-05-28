package com.tencent.mm.az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bhq;
import com.tencent.mm.protocal.protobuf.bhr;
import com.tencent.mm.protocal.protobuf.tb;
import com.tencent.mm.protocal.protobuf.tc;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

public final class b extends m implements k {
    private f ehi;
    public a fLr;
    public final List<com.tencent.mm.plugin.messenger.foundation.a.a.j.b> fLs = new ArrayList();

    static class b extends d implements com.tencent.mm.protocal.l.b {
        public bhq fLv = new bhq();

        b() {
            AppMethodBeat.i(59987);
            AppMethodBeat.o(59987);
        }

        public final byte[] ZT() {
            AppMethodBeat.i(59988);
            byte[] toByteArray = this.fLv.toByteArray();
            AppMethodBeat.o(59988);
            return toByteArray;
        }

        public final int ZU() {
            return 681;
        }
    }

    public static class c extends e implements com.tencent.mm.protocal.l.c {
        public bhr fLw = new bhr();

        public c() {
            AppMethodBeat.i(59989);
            AppMethodBeat.o(59989);
        }

        public final int P(byte[] bArr) {
            AppMethodBeat.i(59990);
            this.fLw = (bhr) new bhr().parseFrom(bArr);
            int i = this.fLw.Ret;
            AppMethodBeat.o(59990);
            return i;
        }
    }

    public static class a extends com.tencent.mm.ai.k {
        private final b fLt = new b();
        public final c fLu = new c();

        public a() {
            AppMethodBeat.i(59986);
            AppMethodBeat.o(59986);
        }

        public final d ZR() {
            return this.fLt;
        }

        public final e ZS() {
            return this.fLu;
        }

        public final int getType() {
            return 681;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/oplog";
        }
    }

    public b(List<com.tencent.mm.plugin.messenger.foundation.a.a.j.b> list) {
        AppMethodBeat.i(59991);
        this.fLs.addAll(list);
        this.fLr = new a();
        ((b) this.fLr.acF()).fLv.wIw = ad(list);
        AppMethodBeat.o(59991);
    }

    private static tc ad(List<com.tencent.mm.plugin.messenger.foundation.a.a.j.b> list) {
        AppMethodBeat.i(59992);
        tc tcVar = new tc();
        for (com.tencent.mm.plugin.messenger.foundation.a.a.j.b bVar : list) {
            byte[] buffer = bVar.getBuffer();
            tb tbVar = new tb();
            tbVar.wat = bVar.getCmdId();
            tbVar.wau = new SKBuiltinBuffer_t().setBuffer(buffer);
            tcVar.jBw.add(tbVar);
        }
        tcVar.jBv = list.size();
        ab.d("MicroMsg.NetSceneOplog", "summeroplog oplogs size=" + list.size());
        AppMethodBeat.o(59992);
        return tcVar;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(59993);
        this.ehi = fVar;
        int a = a(eVar, this.fLr, this);
        AppMethodBeat.o(59993);
        return a;
    }

    public final com.tencent.mm.ai.m.b b(q qVar) {
        return com.tencent.mm.ai.m.b.EOk;
    }

    public final int acn() {
        return 5;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(59994);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(59994);
    }

    public final int getType() {
        return 681;
    }
}

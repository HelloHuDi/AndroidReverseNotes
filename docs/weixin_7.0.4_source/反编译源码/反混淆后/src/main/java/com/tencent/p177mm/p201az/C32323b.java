package com.tencent.p177mm.p201az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C6297k;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3463b;
import com.tencent.p177mm.protocal.C4836l.C4832b;
import com.tencent.p177mm.protocal.C4836l.C4833c;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C4836l.C4835e;
import com.tencent.p177mm.protocal.protobuf.C35956tc;
import com.tencent.p177mm.protocal.protobuf.C40573tb;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.bhq;
import com.tencent.p177mm.protocal.protobuf.bhr;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.az.b */
public final class C32323b extends C1207m implements C1918k {
    private C1202f ehi;
    public C32324a fLr;
    public final List<C3463b> fLs = new ArrayList();

    /* renamed from: com.tencent.mm.az.b$b */
    static class C17966b extends C4834d implements C4832b {
        public bhq fLv = new bhq();

        C17966b() {
            AppMethodBeat.m2504i(59987);
            AppMethodBeat.m2505o(59987);
        }

        /* renamed from: ZT */
        public final byte[] mo5742ZT() {
            AppMethodBeat.m2504i(59988);
            byte[] toByteArray = this.fLv.toByteArray();
            AppMethodBeat.m2505o(59988);
            return toByteArray;
        }

        /* renamed from: ZU */
        public final int mo5743ZU() {
            return 681;
        }
    }

    /* renamed from: com.tencent.mm.az.b$c */
    public static class C17967c extends C4835e implements C4833c {
        public bhr fLw = new bhr();

        public C17967c() {
            AppMethodBeat.m2504i(59989);
            AppMethodBeat.m2505o(59989);
        }

        /* renamed from: P */
        public final int mo5744P(byte[] bArr) {
            AppMethodBeat.m2504i(59990);
            this.fLw = (bhr) new bhr().parseFrom(bArr);
            int i = this.fLw.Ret;
            AppMethodBeat.m2505o(59990);
            return i;
        }
    }

    /* renamed from: com.tencent.mm.az.b$a */
    public static class C32324a extends C6297k {
        private final C17966b fLt = new C17966b();
        public final C17967c fLu = new C17967c();

        public C32324a() {
            AppMethodBeat.m2504i(59986);
            AppMethodBeat.m2505o(59986);
        }

        /* renamed from: ZR */
        public final C4834d mo14537ZR() {
            return this.fLt;
        }

        /* renamed from: ZS */
        public final C4835e mo5618ZS() {
            return this.fLu;
        }

        public final int getType() {
            return 681;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/oplog";
        }
    }

    public C32323b(List<C3463b> list) {
        AppMethodBeat.m2504i(59991);
        this.fLs.addAll(list);
        this.fLr = new C32324a();
        ((C17966b) this.fLr.acF()).fLv.wIw = C32323b.m52865ad(list);
        AppMethodBeat.m2505o(59991);
    }

    /* renamed from: ad */
    private static C35956tc m52865ad(List<C3463b> list) {
        AppMethodBeat.m2504i(59992);
        C35956tc c35956tc = new C35956tc();
        for (C3463b c3463b : list) {
            byte[] buffer = c3463b.getBuffer();
            C40573tb c40573tb = new C40573tb();
            c40573tb.wat = c3463b.getCmdId();
            c40573tb.wau = new SKBuiltinBuffer_t().setBuffer(buffer);
            c35956tc.jBw.add(c40573tb);
        }
        c35956tc.jBv = list.size();
        C4990ab.m7410d("MicroMsg.NetSceneOplog", "summeroplog oplogs size=" + list.size());
        AppMethodBeat.m2505o(59992);
        return c35956tc;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(59993);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.fLr, this);
        AppMethodBeat.m2505o(59993);
        return a;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
    }

    public final int acn() {
        return 5;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(59994);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(59994);
    }

    public final int getType() {
        return 681;
    }
}

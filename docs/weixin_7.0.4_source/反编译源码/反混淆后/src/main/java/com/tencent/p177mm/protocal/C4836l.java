package com.tencent.p177mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.pointers.PByteArray;
import com.tencent.p177mm.protocal.protobuf.BaseResponse;
import com.tencent.p177mm.protocal.protobuf.C7267hl;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.protocal.l */
public final class C4836l {

    /* renamed from: com.tencent.mm.protocal.l$a */
    public interface C4831a {
        /* renamed from: a */
        boolean mo9990a(PByteArray pByteArray, int i, byte[] bArr, byte[] bArr2, int i2);
    }

    /* renamed from: com.tencent.mm.protocal.l$b */
    public interface C4832b {
        /* renamed from: ZT */
        byte[] mo5742ZT();

        /* renamed from: ZU */
        int mo5743ZU();

        long ads();

        int dmr();

        boolean dms();
    }

    /* renamed from: com.tencent.mm.protocal.l$c */
    public interface C4833c {
        /* renamed from: P */
        int mo5744P(byte[] bArr);

        boolean dms();
    }

    /* renamed from: com.tencent.mm.protocal.l$d */
    public static class C4834d {
        public byte[] bFT = new byte[0];
        public long bufferSize = 0;
        public int fsO = 0;
        public int vyb = 0;
        public int vyc = 0;
        public String vyd = "";
        public String vye = "";
        public int vyf = 0;
        public boolean vyg = true;
        public C4831a vyh;
        public byte[] vyi;
        public C4851z vyj = new C4851z("", "", 0);
        public long vyk = 0;

        public C4834d() {
            AppMethodBeat.m2504i(58839);
            AppMethodBeat.m2505o(58839);
        }

        /* renamed from: hB */
        public void mo10000hB(int i) {
            this.vyb = i;
        }

        public int getCmdId() {
            return 0;
        }

        public boolean dms() {
            return false;
        }

        public boolean adr() {
            return this.vyg;
        }

        /* renamed from: a */
        public final void mo9995a(C4851z c4851z) {
            AppMethodBeat.m2504i(58840);
            this.vyj = c4851z;
            C4990ab.m7417i("MicroMsg.MMBase.Req", "summerauths setRsaInfo cgi[%s], stack[%s]", Integer.valueOf(getCmdId()), C5046bo.dpG());
            AppMethodBeat.m2505o(58840);
        }

        public final int dmr() {
            return this.fsO;
        }

        public final long ads() {
            return this.vyk;
        }
    }

    /* renamed from: com.tencent.mm.protocal.l$e */
    public static class C4835e {
        public long bufferSize = 0;
        public int vyl = -99;
        public int vym = 255;
        public String vyn = "";

        public int getCmdId() {
            return 0;
        }

        public boolean dms() {
            return false;
        }
    }

    /* renamed from: a */
    public static C7267hl m7194a(C4834d c4834d) {
        AppMethodBeat.m2504i(58841);
        C7267hl c7267hl = new C7267hl();
        c7267hl.vKd = c4834d.vyc;
        c7267hl.Scene = c4834d.vyf;
        c7267hl.luF = c4834d.vyb;
        c7267hl.vKc = C1332b.m2847bI(c4834d.vye.getBytes());
        if (c7267hl.vKc.f1226wR.length >= 16) {
            c7267hl.vKc = c7267hl.vKc.mo4675Lv(16);
        }
        c7267hl.vKe = C1332b.m2847bI(c4834d.vyd.getBytes());
        if (c7267hl.vKe.f1226wR.length >= 132) {
            c7267hl.vKe = c7267hl.vKe.mo4675Lv(132);
        }
        c7267hl.vKb = C1332b.m2847bI(c4834d.bFT);
        if (c7267hl.vKb.f1226wR.length >= 36) {
            c7267hl.vKb = c7267hl.vKb.mo4675Lv(36);
        }
        AppMethodBeat.m2505o(58841);
        return c7267hl;
    }

    /* renamed from: a */
    public static void m7195a(C4835e c4835e, BaseResponse baseResponse) {
        AppMethodBeat.m2504i(58842);
        if (baseResponse.ErrMsg != null) {
            c4835e.vyn = baseResponse.ErrMsg.wVI;
            AppMethodBeat.m2505o(58842);
            return;
        }
        c4835e.vyn = "";
        C4990ab.m7412e("MicroMsg.MMBase", "ErrMsg is Null!!!!!!");
        AppMethodBeat.m2505o(58842);
    }
}

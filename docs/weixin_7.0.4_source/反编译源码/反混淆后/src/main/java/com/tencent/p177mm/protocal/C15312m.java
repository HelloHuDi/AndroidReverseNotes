package com.tencent.p177mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.C4836l.C4832b;
import com.tencent.p177mm.protocal.C4836l.C4833c;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C4836l.C4835e;
import com.tencent.p177mm.protocal.protobuf.C23402iz;
import com.tencent.p177mm.protocal.protobuf.C44131ja;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.IOException;

/* renamed from: com.tencent.mm.protocal.m */
public final class C15312m extends C4787a {

    /* renamed from: com.tencent.mm.protocal.m$a */
    public static class C15313a extends C4834d implements C4832b {
        public int netType;
        public int vyo = 0;

        /* renamed from: ZT */
        public final byte[] mo5742ZT() {
            AppMethodBeat.m2504i(28280);
            C23402iz c23402iz = new C23402iz();
            c23402iz.vKd = C7243d.vxo;
            c23402iz.vKR = 2;
            c23402iz.vKS = this.netType;
            c23402iz.vKT = this.vyo;
            C4990ab.m7417i("MicroMsg.MMBgFg", "somr online:%d nettype:%d ver:%d devid:%d", Integer.valueOf(c23402iz.vKT), Integer.valueOf(c23402iz.vKS), Integer.valueOf(c23402iz.vKd), Integer.valueOf(c23402iz.vKR));
            byte[] bArr = null;
            try {
                bArr = c23402iz.toByteArray();
            } catch (IOException e) {
                C4990ab.m7413e("MicroMsg.MMBgFg", "MMBgfg toProtoBuf exception:%s", C5046bo.m7574l(e));
            }
            AppMethodBeat.m2505o(28280);
            return bArr;
        }

        /* renamed from: ZU */
        public final int mo5743ZU() {
            return 0;
        }

        public final int getCmdId() {
            return 312;
        }

        public final boolean dms() {
            return true;
        }

        public final boolean adr() {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.protocal.m$b */
    public static class C15314b extends C4835e implements C4833c {
        public C44131ja vyp = new C44131ja();

        public C15314b() {
            AppMethodBeat.m2504i(28281);
            AppMethodBeat.m2505o(28281);
        }

        /* renamed from: P */
        public final int mo5744P(byte[] bArr) {
            AppMethodBeat.m2504i(28282);
            this.vyp = (C44131ja) new C44131ja().parseFrom(bArr);
            C4990ab.m7410d("MicroMsg.MMBgFg", "retcode:" + this.vyp.kCl);
            int i = this.vyp.kCl;
            AppMethodBeat.m2505o(28282);
            return i;
        }

        public final int getCmdId() {
            return 1000000312;
        }

        public final boolean dms() {
            return true;
        }
    }
}

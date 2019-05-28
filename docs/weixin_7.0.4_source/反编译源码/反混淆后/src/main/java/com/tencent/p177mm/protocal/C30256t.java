package com.tencent.p177mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.C4836l.C4832b;
import com.tencent.p177mm.protocal.C4836l.C4833c;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C4836l.C4835e;
import com.tencent.p177mm.protocal.protobuf.bej;
import com.tencent.p177mm.protocal.protobuf.bek;

/* renamed from: com.tencent.mm.protocal.t */
public final class C30256t {

    /* renamed from: com.tencent.mm.protocal.t$b */
    public static class C7290b extends C4835e implements C4833c {
        public bek vyH = new bek();

        public C7290b() {
            AppMethodBeat.m2504i(58858);
            AppMethodBeat.m2505o(58858);
        }

        /* renamed from: P */
        public final int mo5744P(byte[] bArr) {
            AppMethodBeat.m2504i(58859);
            this.vyH = (bek) new bek().parseFrom(bArr);
            int i = this.vyH.Ret;
            AppMethodBeat.m2505o(58859);
            return i;
        }

        public final int getCmdId() {
            return 1000000121;
        }
    }

    /* renamed from: com.tencent.mm.protocal.t$a */
    public static class C23473a extends C4834d implements C4832b {
        public bej vyG = new bej();

        public C23473a() {
            AppMethodBeat.m2504i(58856);
            AppMethodBeat.m2505o(58856);
        }

        /* renamed from: ZT */
        public final byte[] mo5742ZT() {
            AppMethodBeat.m2504i(58857);
            byte[] toByteArray = this.vyG.toByteArray();
            AppMethodBeat.m2505o(58857);
            return toByteArray;
        }

        /* renamed from: ZU */
        public final int mo5743ZU() {
            return 138;
        }

        public final int getCmdId() {
            return 121;
        }
    }
}

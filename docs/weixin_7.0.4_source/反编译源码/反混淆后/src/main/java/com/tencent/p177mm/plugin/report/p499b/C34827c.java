package com.tencent.p177mm.plugin.report.p499b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.storage.C19484j;
import com.tencent.p177mm.protocal.C4836l;
import com.tencent.p177mm.protocal.C4836l.C4832b;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C4851z;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.awz;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.report.b.c */
public final class C34827c {

    /* renamed from: com.tencent.mm.plugin.report.b.c$a */
    public static class C34828a extends C4834d implements C4832b {
        public awz pXm = new awz();

        public C34828a() {
            AppMethodBeat.m2504i(72671);
            AppMethodBeat.m2505o(72671);
        }

        /* renamed from: ZT */
        public final byte[] mo5742ZT() {
            AppMethodBeat.m2504i(72672);
            mo9995a(C4851z.dmw());
            this.pXm.vLz = new SKBuiltinBuffer_t().setBuffer(C5046bo.dpz());
            this.pXm.setBaseRequest(C4836l.m7194a(this));
            byte[] toByteArray = this.pXm.toByteArray();
            AppMethodBeat.m2505o(72672);
            return toByteArray;
        }

        /* renamed from: ZU */
        public final int mo5743ZU() {
            return C19484j.CTRL_INDEX;
        }

        public final int getCmdId() {
            return 0;
        }
    }
}

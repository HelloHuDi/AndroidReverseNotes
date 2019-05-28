package com.tencent.p177mm.plugin.backup.p919e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C6297k;
import com.tencent.p177mm.plugin.backup.p342b.C38634d;
import com.tencent.p177mm.pointers.PByteArray;
import com.tencent.p177mm.protocal.C30165k.C30164a;
import com.tencent.p177mm.protocal.C30165k.C30166b;
import com.tencent.p177mm.protocal.C4836l.C4831a;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C4836l.C4835e;
import com.tencent.p177mm.protocal.C4851z;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.MMProtocalJni;
import com.tencent.p177mm.protocal.protobuf.C7284ua;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.backup.e.a */
public final class C45744a extends C1207m implements C1918k {
    private C1202f ehi;
    public C1929q ftU = new C27485a();

    /* renamed from: com.tencent.mm.plugin.backup.e.a$a */
    public static class C27485a extends C6297k {
        private final C30164a juo = new C30164a();
        private final C30166b jup = new C30166b();

        public C27485a() {
            AppMethodBeat.m2504i(17311);
            AppMethodBeat.m2505o(17311);
        }

        /* renamed from: ZR */
        public final C4834d mo14537ZR() {
            return this.juo;
        }

        /* renamed from: ZS */
        public final C4835e mo5618ZS() {
            return this.jup;
        }

        public final int getType() {
            return 1000;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/bakchatcreateqrcodeoffline";
        }

        public final int acC() {
            return 1;
        }
    }

    public C45744a(LinkedList<C7284ua> linkedList, String str, String str2) {
        AppMethodBeat.m2504i(17312);
        final C30164a c30164a = (C30164a) this.ftU.acF();
        c30164a.vxZ = C38634d.aSy();
        c30164a.vxY.vIN = linkedList.size();
        c30164a.vxY.vIO = linkedList;
        c30164a.vxY.vIP = C1427q.getDeviceID(C4996ah.getContext());
        c30164a.vxY.vIQ = C1853r.m3846Yz();
        c30164a.vxY.Scene = 2;
        c30164a.vxY.jBP = 0;
        c30164a.vxY.vIR = str;
        c30164a.vxY.vIS = str2;
        c30164a.vyi = c30164a.vxZ;
        c30164a.vyh = new C4831a() {
            /* renamed from: a */
            public final boolean mo9990a(PByteArray pByteArray, int i, byte[] bArr, byte[] bArr2, int i2) {
                long j;
                AppMethodBeat.m2504i(17310);
                long j2 = (long) c30164a.vyb;
                if (C4872b.dnO() && j2 == 0) {
                    j = C7243d.vxn;
                } else {
                    j = j2;
                }
                C4851z c4851z = c30164a.vyj;
                if (i == 1000) {
                    byte[] bArr3 = c30164a.vyi;
                    if (!c4851z.dmy()) {
                        bArr3 = new byte[0];
                    }
                    if (C5046bo.m7540cb(bArr3)) {
                        C4990ab.m7413e("MicroMsg.BackupCreateQRCodeOfflineScene", "dksession jType %d session should not null", Integer.valueOf(i));
                        AppMethodBeat.m2505o(17310);
                        return false;
                    }
                    byte[] ZT = c30164a.mo5742ZT();
                    int i3 = 0;
                    if (!(C5046bo.m7540cb(bArr2) || C5046bo.m7540cb(ZT))) {
                        i3 = MMProtocalJni.genSignature((int) j, bArr2, ZT);
                    }
                    if (MMProtocalJni.pack(ZT, pByteArray, bArr3, 0, bArr, c30164a.vye, (int) j, 1000, c4851z.ver, c4851z.vyO.getBytes(), c4851z.vyP.getBytes(), i3, i2, c30164a.fsO)) {
                        C4990ab.m7411d("MicroMsg.BackupCreateQRCodeOfflineScene", "reqToBuf using protobuf ok, len:%d, flag:%d", Integer.valueOf(pByteArray.value.length), Integer.valueOf(i2));
                        AppMethodBeat.m2505o(17310);
                        return true;
                    }
                }
                AppMethodBeat.m2505o(17310);
                return false;
            }
        };
        AppMethodBeat.m2505o(17312);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(17313);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ftU, this);
        AppMethodBeat.m2505o(17313);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(17314);
        C4990ab.m7417i("MicroMsg.BackupCreateQRCodeOfflineScene", "err: %d, %d, %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            C4990ab.m7417i("MicroMsg.BackupCreateQRCodeOfflineScene", "onGYNetEnd QRCodeUrl:%s", ((C30166b) c1929q.mo5618ZS()).vya.vIU);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(17314);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(17314);
    }

    public final int getType() {
        return 1000;
    }
}

package com.tencent.mm.plugin.backup.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.r;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.protocal.z;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class a extends m implements k {
    private f ehi;
    public q ftU = new a();

    public static class a extends com.tencent.mm.ai.k {
        private final com.tencent.mm.protocal.k.a juo = new com.tencent.mm.protocal.k.a();
        private final b jup = new b();

        public a() {
            AppMethodBeat.i(17311);
            AppMethodBeat.o(17311);
        }

        public final d ZR() {
            return this.juo;
        }

        public final e ZS() {
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

    public a(LinkedList<ua> linkedList, String str, String str2) {
        AppMethodBeat.i(17312);
        final com.tencent.mm.protocal.k.a aVar = (com.tencent.mm.protocal.k.a) this.ftU.acF();
        aVar.vxZ = com.tencent.mm.plugin.backup.b.d.aSy();
        aVar.vxY.vIN = linkedList.size();
        aVar.vxY.vIO = linkedList;
        aVar.vxY.vIP = com.tencent.mm.compatible.e.q.getDeviceID(ah.getContext());
        aVar.vxY.vIQ = r.Yz();
        aVar.vxY.Scene = 2;
        aVar.vxY.jBP = 0;
        aVar.vxY.vIR = str;
        aVar.vxY.vIS = str2;
        aVar.vyi = aVar.vxZ;
        aVar.vyh = new com.tencent.mm.protocal.l.a() {
            public final boolean a(PByteArray pByteArray, int i, byte[] bArr, byte[] bArr2, int i2) {
                long j;
                AppMethodBeat.i(17310);
                long j2 = (long) aVar.vyb;
                if (com.tencent.mm.sdk.a.b.dnO() && j2 == 0) {
                    j = com.tencent.mm.protocal.d.vxn;
                } else {
                    j = j2;
                }
                z zVar = aVar.vyj;
                if (i == 1000) {
                    byte[] bArr3 = aVar.vyi;
                    if (!zVar.dmy()) {
                        bArr3 = new byte[0];
                    }
                    if (bo.cb(bArr3)) {
                        ab.e("MicroMsg.BackupCreateQRCodeOfflineScene", "dksession jType %d session should not null", Integer.valueOf(i));
                        AppMethodBeat.o(17310);
                        return false;
                    }
                    byte[] ZT = aVar.ZT();
                    int i3 = 0;
                    if (!(bo.cb(bArr2) || bo.cb(ZT))) {
                        i3 = MMProtocalJni.genSignature((int) j, bArr2, ZT);
                    }
                    if (MMProtocalJni.pack(ZT, pByteArray, bArr3, 0, bArr, aVar.vye, (int) j, 1000, zVar.ver, zVar.vyO.getBytes(), zVar.vyP.getBytes(), i3, i2, aVar.fsO)) {
                        ab.d("MicroMsg.BackupCreateQRCodeOfflineScene", "reqToBuf using protobuf ok, len:%d, flag:%d", Integer.valueOf(pByteArray.value.length), Integer.valueOf(i2));
                        AppMethodBeat.o(17310);
                        return true;
                    }
                }
                AppMethodBeat.o(17310);
                return false;
            }
        };
        AppMethodBeat.o(17312);
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(17313);
        this.ehi = fVar;
        int a = a(eVar, this.ftU, this);
        AppMethodBeat.o(17313);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(17314);
        ab.i("MicroMsg.BackupCreateQRCodeOfflineScene", "err: %d, %d, %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            ab.i("MicroMsg.BackupCreateQRCodeOfflineScene", "onGYNetEnd QRCodeUrl:%s", ((b) qVar.ZS()).vya.vIU);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(17314);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(17314);
    }

    public final int getType() {
        return 1000;
    }
}

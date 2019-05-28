package com.tencent.mm.plugin.subapp.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.apw;
import com.tencent.mm.protocal.protobuf.apx;
import com.tencent.mm.protocal.protobuf.cmn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.io.FileOutputStream;

public final class a extends m implements k {
    final b ehh;
    private f ehi;
    private ap frk = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(25220);
            if (a.this.ssI < 0) {
                AppMethodBeat.o(25220);
                return false;
            }
            cmn cmn;
            apx apx = (apx) a.this.ehh.fsH.fsP;
            try {
                cmn = (cmn) apx.wtX.get(a.this.ssI);
            } catch (Exception e) {
                ab.e("MicroMsg.NetSceneGetVUserInfo", "get item :" + a.this.ssI + " not Found");
                cmn = null;
            }
            if (!(cmn == null || cmn.xkr == null || cmn.xkr.getBuffer() == null || cmn.xkq == null || cmn.xkq.getBuffer() == null)) {
                ab.d("MicroMsg.NetSceneGetVUserInfo", "onGYNetEnd ver:" + apx.Version + " idx:" + a.this.ssI + " id:" + Integer.toHexString(cmn.ID) + " size:" + cmn.xkq.getILen() + " hdsize:" + cmn.xkr.getILen());
                a.a(cmn.ID, true, cmn.xkr.getBuffer().toByteArray());
                a.a(cmn.ID, false, cmn.xkq.getBuffer().toByteArray());
            }
            a aVar = a.this;
            aVar.ssI--;
            AppMethodBeat.o(25220);
            return true;
        }
    }, true);
    int ssI = 0;

    public a() {
        int i = 0;
        AppMethodBeat.i(25221);
        aw.ZK();
        int h = bo.h((Integer) c.Ry().get(66052, null));
        if (com.tencent.mm.model.ao.a.flw.kA(h)) {
            aw.ZK();
            i = bo.h((Integer) c.Ry().get(66053, null));
        }
        StringBuilder append = new StringBuilder("init: allfileid:").append(Integer.toBinaryString(h)).append(" inver:");
        aw.ZK();
        ab.d("MicroMsg.NetSceneGetVUserInfo", append.append(bo.h((Integer) c.Ry().get(66053, null))).append(" reqver:").append(i).toString());
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new apw();
        aVar.fsK = new apx();
        aVar.uri = "/cgi-bin/micromsg-bin/getvuserinfo";
        aVar.fsI = ErrorCode.STARTDOWNLOAD_8;
        aVar.fsL = 60;
        aVar.fsM = 1000000060;
        this.ehh = aVar.acD();
        ((apw) this.ehh.fsG.fsP).Version = i;
        AppMethodBeat.o(25221);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(25222);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(25222);
        return a;
    }

    public final int getType() {
        return ErrorCode.STARTDOWNLOAD_8;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        int i4 = 0;
        AppMethodBeat.i(25223);
        if (i2 == 0 && i3 == 0) {
            apx apx = (apx) ((b) qVar).fsH.fsP;
            StringBuilder append = new StringBuilder("onGYNetEnd new version:").append(apx.Version).append(" old version:");
            aw.ZK();
            ab.d("MicroMsg.NetSceneGetVUserInfo", append.append(bo.h((Integer) c.Ry().get(66053, null))).append(" Count:").append(apx.wtX.size()).toString());
            aw.ZK();
            c.Ry().set(66053, Integer.valueOf(apx.Version));
            if (apx.wtX.size() <= 0) {
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(25223);
                return;
            }
            int i5 = 0;
            while (true) {
                int i6 = i4;
                if (i5 < apx.wtX.size()) {
                    i4 = i6 | ((cmn) apx.wtX.get(i5)).ID;
                    i5++;
                } else {
                    aw.ZK();
                    c.Ry().set(66052, Integer.valueOf(i6));
                    this.ehi.onSceneEnd(i2, i3, str, this);
                    this.ssI = apx.wtX.size() - 1;
                    this.frk.ae(50, 50);
                    AppMethodBeat.o(25223);
                    return;
                }
            }
        }
        ab.e("MicroMsg.NetSceneGetVUserInfo", "errType:" + i2 + " errCode:" + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(25223);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x003b A:{SYNTHETIC, Splitter:B:19:0x003b} */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0030 A:{SYNTHETIC, Splitter:B:13:0x0030} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean a(int i, boolean z, byte[] bArr) {
        Throwable e;
        Throwable th;
        AppMethodBeat.i(25224);
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(com.tencent.mm.model.ao.a.flw.B(i, z));
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.close();
                try {
                    fileOutputStream.close();
                } catch (Exception e2) {
                }
                AppMethodBeat.o(25224);
                return true;
            } catch (Exception e3) {
                e = e3;
                try {
                    ab.printErrStackTrace("MicroMsg.NetSceneGetVUserInfo", e, "", new Object[0]);
                    if (fileOutputStream != null) {
                    }
                    AppMethodBeat.o(25224);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                    }
                    AppMethodBeat.o(25224);
                    throw th;
                }
            }
        } catch (Exception e4) {
            e = e4;
            fileOutputStream = null;
            ab.printErrStackTrace("MicroMsg.NetSceneGetVUserInfo", e, "", new Object[0]);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception e5) {
                }
            }
            AppMethodBeat.o(25224);
            return false;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception e6) {
                }
            }
            AppMethodBeat.o(25224);
            throw th;
        }
    }
}

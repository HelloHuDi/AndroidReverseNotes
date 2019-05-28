package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.g.t;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.protocal.protobuf.bfj;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import java.util.Iterator;
import java.util.Map;

public final class l extends m implements k {
    public static String fOO;
    public static String fOP;
    public static String fOQ;
    public static String fOR;
    public static String fOS;
    public static String fOT;
    public static String fOU;
    public static String fOV;
    public static String fOW;
    public static String fOX;
    private static int fOY;
    private static int fOZ = -1;
    private static int fPa = 22;
    private static int fPb = 0;
    private static boolean fPc = false;
    private static int fPd = 0;
    private f ehi;

    public static boolean lW(int i) {
        if (fOY == i) {
            return false;
        }
        return true;
    }

    public static int ajf() {
        return fOZ;
    }

    public static boolean ajg() {
        return (fPb & 2) != 0;
    }

    public static boolean ajh() {
        return (fPa & 4) != 0;
    }

    public static void cR(boolean z) {
        if (z) {
            fPa |= 4;
        } else {
            fPa &= -5;
        }
    }

    public static int aji() {
        return fOY;
    }

    public static int getDeviceType() {
        return fPd;
    }

    public static boolean ajj() {
        return (fPb & 512) != 0;
    }

    public static boolean ajk() {
        return (fPb & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0;
    }

    public l(int i) {
        fOY = i;
    }

    public final int getType() {
        return t.CTRL_INDEX;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(16589);
        a aVar = new a();
        alc alc = new alc();
        alc.luQ = aa.dor();
        ab.d("MicroMsg.NetSceneGetOnlineInfo", "language %s", alc.luQ);
        aVar.fsJ = alc;
        aVar.fsK = new ald();
        aVar.uri = "/cgi-bin/micromsg-bin/getonlineinfo";
        aVar.fsI = t.CTRL_INDEX;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehi = fVar;
        int a = a(eVar, aVar.acD(), this);
        AppMethodBeat.o(16589);
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x01d6  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0152  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(16590);
        ab.i("MicroMsg.NetSceneGetOnlineInfo", "ongynetend %d, %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            ald ald = (ald) ((b) qVar).fsH.fsP;
            fOZ = ald.wqF;
            ab.d("MicroMsg.NetSceneGetOnlineInfo", "iconType:%d onlineInfoFlag:%d", Integer.valueOf(fOZ), Integer.valueOf(ald.vEq));
            Map z = br.z(ald.wqE, "summary");
            int i4 = fPa;
            if (z != null) {
                int i5;
                int i6;
                fOO = (String) z.get(".summary.banner");
                ab.d("MicroMsg.NetSceneGetOnlineInfo", "onlineinfo, count:%d, summary:%s", Integer.valueOf(ald.wqC), ald.wqE);
                alc alc = (alc) ((b) qVar).fsG.fsP;
                Iterator it = ald.wqD.iterator();
                while (it.hasNext()) {
                    bfj bfj = (bfj) it.next();
                    if (bfj.vKc.dlY().hashCode() != alc.BaseRequest.vKc.dlY().hashCode()) {
                        fPd = bfj.wJh;
                        ab.i("MicroMsg.NetSceneGetOnlineInfo", "device type %d", Integer.valueOf(fPd));
                        Map z2 = br.z(bfj.wJi, "wording");
                        ab.d("MicroMsg.NetSceneGetOnlineInfo", bfj.wJi);
                        if (z2 != null) {
                            fOP = (String) z2.get(".wording.title");
                            fOQ = (String) z2.get(".wording.notify");
                            fOR = (String) z2.get(".wording.mute_title");
                            fOS = (String) z2.get(".wording.mute_tips");
                            fOT = (String) z2.get(".wording.exit");
                            fOU = (String) z2.get(".wording.exit_confirm");
                            fOV = (String) z2.get(".wording.lock_title");
                            fOW = (String) z2.get(".wording.mute_lock_title");
                            fOX = (String) z2.get(".wording.exit");
                        }
                        i5 = bfj.wJk;
                        i6 = ald.vEq;
                        fPb = i6;
                        if ((i6 & 2) != 0) {
                            fPc = true;
                        } else {
                            fPc = false;
                        }
                        if (i5 != fPa) {
                            fPa = i5;
                            aw.ZK();
                            c.QV();
                        }
                    }
                }
                i5 = i4;
                i6 = ald.vEq;
                fPb = i6;
                if ((i6 & 2) != 0) {
                }
                if (i5 != fPa) {
                }
            }
            if ((ald.vEq & 64) != 0) {
                aw.ZK();
                ad aoO = c.XM().aoO("filehelper");
                if (aoO == null || bo.isNullOrNil(aoO.field_username)) {
                    com.tencent.mm.model.ab.x(aoO);
                    aw.ZK();
                    aoO = c.XM().aoO("filehelper");
                }
                if (!(aoO == null || com.tencent.mm.n.a.jh(aoO.field_type))) {
                    aoO.NB();
                    aw.ZK();
                    c.XM().b(aoO.field_username, aoO);
                }
                aw.ZK();
                ak aoZ = c.XR().aoZ("filehelper");
                if (aoZ == null) {
                    aoZ = new ak("filehelper");
                    aoZ.eD(bo.anU());
                    aw.ZK();
                    c.XR().d(aoZ);
                } else {
                    aoZ.eD(bo.anU());
                    aw.ZK();
                    c.XR().a(aoZ, "filehelper");
                }
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(16590);
    }
}

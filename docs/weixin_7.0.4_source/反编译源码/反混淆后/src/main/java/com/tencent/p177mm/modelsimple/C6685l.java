package com.tencent.p177mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C37901ab;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C2288t;
import com.tencent.p177mm.protocal.protobuf.alc;
import com.tencent.p177mm.protocal.protobuf.ald;
import com.tencent.p177mm.protocal.protobuf.bfj;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7617ak;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.tencent.mm.modelsimple.l */
public final class C6685l extends C1207m implements C1918k {
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
    private C1202f ehi;

    /* renamed from: lW */
    public static boolean m11103lW(int i) {
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

    /* renamed from: cR */
    public static void m11102cR(boolean z) {
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

    public C6685l(int i) {
        fOY = i;
    }

    public final int getType() {
        return C2288t.CTRL_INDEX;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(16589);
        C1196a c1196a = new C1196a();
        alc alc = new alc();
        alc.luQ = C4988aa.dor();
        C4990ab.m7411d("MicroMsg.NetSceneGetOnlineInfo", "language %s", alc.luQ);
        c1196a.fsJ = alc;
        c1196a.fsK = new ald();
        c1196a.uri = "/cgi-bin/micromsg-bin/getonlineinfo";
        c1196a.fsI = C2288t.CTRL_INDEX;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehi = c1202f;
        int a = mo4457a(c1902e, c1196a.acD(), this);
        AppMethodBeat.m2505o(16589);
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x01d6  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0152  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(16590);
        C4990ab.m7417i("MicroMsg.NetSceneGetOnlineInfo", "ongynetend %d, %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            ald ald = (ald) ((C7472b) c1929q).fsH.fsP;
            fOZ = ald.wqF;
            C4990ab.m7411d("MicroMsg.NetSceneGetOnlineInfo", "iconType:%d onlineInfoFlag:%d", Integer.valueOf(fOZ), Integer.valueOf(ald.vEq));
            Map z = C5049br.m7595z(ald.wqE, "summary");
            int i4 = fPa;
            if (z != null) {
                int i5;
                int i6;
                fOO = (String) z.get(".summary.banner");
                C4990ab.m7411d("MicroMsg.NetSceneGetOnlineInfo", "onlineinfo, count:%d, summary:%s", Integer.valueOf(ald.wqC), ald.wqE);
                alc alc = (alc) ((C7472b) c1929q).fsG.fsP;
                Iterator it = ald.wqD.iterator();
                while (it.hasNext()) {
                    bfj bfj = (bfj) it.next();
                    if (bfj.vKc.dlY().hashCode() != alc.BaseRequest.vKc.dlY().hashCode()) {
                        fPd = bfj.wJh;
                        C4990ab.m7417i("MicroMsg.NetSceneGetOnlineInfo", "device type %d", Integer.valueOf(fPd));
                        Map z2 = C5049br.m7595z(bfj.wJi, "wording");
                        C4990ab.m7410d("MicroMsg.NetSceneGetOnlineInfo", bfj.wJi);
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
                            C9638aw.m17190ZK();
                            C18628c.m29065QV();
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
                C9638aw.m17190ZK();
                C7616ad aoO = C18628c.m29078XM().aoO("filehelper");
                if (aoO == null || C5046bo.isNullOrNil(aoO.field_username)) {
                    C37901ab.m64007x(aoO);
                    C9638aw.m17190ZK();
                    aoO = C18628c.m29078XM().aoO("filehelper");
                }
                if (!(aoO == null || C7486a.m12942jh(aoO.field_type))) {
                    aoO.mo16676NB();
                    C9638aw.m17190ZK();
                    C18628c.m29078XM().mo15724b(aoO.field_username, aoO);
                }
                C9638aw.m17190ZK();
                C7617ak aoZ = C18628c.m29083XR().aoZ("filehelper");
                if (aoZ == null) {
                    aoZ = new C7617ak("filehelper");
                    aoZ.mo14742eD(C5046bo.anU());
                    C9638aw.m17190ZK();
                    C18628c.m29083XR().mo15807d(aoZ);
                } else {
                    aoZ.mo14742eD(C5046bo.anU());
                    C9638aw.m17190ZK();
                    C18628c.m29083XR().mo15767a(aoZ, "filehelper");
                }
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(16590);
    }
}

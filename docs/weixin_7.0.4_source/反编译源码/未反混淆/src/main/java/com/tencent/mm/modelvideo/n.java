package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.al.f;
import com.tencent.mm.cd.h;
import com.tencent.mm.g.a.jv;
import com.tencent.mm.g.b.a.bc;
import com.tencent.mm.g.b.a.j;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.rtmp.TXLivePushConfig;
import java.util.HashMap;

public class n implements at {
    public HashMap<String, a> fWm = new HashMap();
    private c<jv> fWn = new c<jv>() {
        {
            AppMethodBeat.i(50754);
            this.xxI = jv.class.getName().hashCode();
            AppMethodBeat.o(50754);
        }

        private boolean a(jv jvVar) {
            AppMethodBeat.i(50755);
            ab.d("MicroMsg.SubCoreMediaRpt", "get media info report event.");
            if (jvVar == null) {
                AppMethodBeat.o(50755);
                return false;
            }
            String str;
            String str2 = jvVar.cEU.path;
            try {
                if (str2.endsWith(".tmp")) {
                    str2 = str2.substring(0, str2.lastIndexOf(".tmp"));
                    ab.i("MicroMsg.SubCoreMediaRpt", "media info event path[%s, %s]", str2, jvVar.cEU.path);
                }
                str = str2;
            } catch (Exception e) {
                str = str2;
            }
            n nVar = n.this;
            String str3 = jvVar.cEU.cEV;
            String str4 = jvVar.cEU.cEW;
            int i = jvVar.cEU.cEX;
            String str5 = jvVar.cEU.fileId;
            String str6 = jvVar.cEU.cEZ;
            long j = jvVar.cEU.startTime;
            long j2 = jvVar.cEU.endTime;
            g.RS().aa(new AnonymousClass2(str, jvVar.cEU.cEY, str3, str4, i, str5, str6, j, j2, jvVar.cEU.cFa, jvVar.cEU.cFb, jvVar.cEU.cFc));
            AppMethodBeat.o(50755);
            return false;
        }
    };

    /* renamed from: com.tencent.mm.modelvideo.n$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ String bSt;
        final /* synthetic */ long fEG;
        final /* synthetic */ String[] fWq;
        final /* synthetic */ String fWr;
        final /* synthetic */ int fWs;
        final /* synthetic */ String fWt;
        final /* synthetic */ String fWu;
        final /* synthetic */ long fWv;
        final /* synthetic */ int fWw;
        final /* synthetic */ int fWx;
        final /* synthetic */ String fWy;
        final /* synthetic */ String fkv;

        AnonymousClass2(String str, String[] strArr, String str2, String str3, int i, String str4, String str5, long j, long j2, int i2, int i3, String str6) {
            this.bSt = str;
            this.fWq = strArr;
            this.fkv = str2;
            this.fWr = str3;
            this.fWs = i;
            this.fWt = str4;
            this.fWu = str5;
            this.fEG = j;
            this.fWv = j2;
            this.fWw = i2;
            this.fWx = i3;
            this.fWy = str6;
        }

        public final void run() {
            AppMethodBeat.i(50753);
            com.tencent.mm.plugin.sight.base.a WR = d.WR(this.bSt);
            if (WR == null) {
                ab.w("MicroMsg.SubCoreMediaRpt", "get media info is null. %s", this.bSt);
                AppMethodBeat.o(50753);
                return;
            }
            int cs = e.cs(this.bSt);
            String str = null;
            if (this.fWq != null) {
                StringBuffer stringBuffer = new StringBuffer();
                for (String append : this.fWq) {
                    stringBuffer.append(append).append("|");
                }
                str = stringBuffer.toString();
            }
            int gD = com.tencent.mm.sdk.platformtools.at.gD(ah.getContext());
            f.afy();
            String rJ = com.tencent.mm.al.a.rJ(this.bSt);
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(this.fkv).append(",").append(this.fWr).append(",");
            stringBuffer2.append(this.fWs).append(",").append(this.fWt).append(",");
            stringBuffer2.append(this.fWu).append(",").append(gD).append(",");
            stringBuffer2.append(rJ).append(",").append(this.fEG).append(",");
            stringBuffer2.append(this.fWv).append(",").append(cs).append(",");
            stringBuffer2.append(WR.eWK).append(",").append(WR.videoBitrate / 1000).append(",");
            stringBuffer2.append(WR.fzS / 1000).append(",").append(WR.eTk).append(",");
            stringBuffer2.append(WR.width).append(",").append(WR.height).append(",");
            stringBuffer2.append(str).append(",").append(WR.qwV).append(",");
            stringBuffer2.append(this.fWw).append(",").append(this.fWx).append(",");
            stringBuffer2.append(com.tencent.mm.plugin.video.c.abR(this.fWy));
            ab.i("MicroMsg.SubCoreMediaRpt", "download video rpt %s ", stringBuffer2.toString());
            new j(stringBuffer2.toString()).ajK();
            AppMethodBeat.o(50753);
        }
    }

    public class a {
        public String cEZ;
        public String dqJ;
        public com.tencent.mm.i.d fVQ;
        public String fWA;
        public String fWB;
        public int fWC;
        public int fWD;
        public String fWz;
        public long startTime;
        public String toUser;
    }

    public n() {
        AppMethodBeat.i(50757);
        com.tencent.mm.sdk.b.a.xxA.c(this.fWn);
        AppMethodBeat.o(50757);
    }

    public static n alj() {
        AppMethodBeat.i(50758);
        n nVar = (n) q.Y(n.class);
        AppMethodBeat.o(50758);
        return nVar;
    }

    public final void a(String str, String str2, String str3, String str4, String str5, int i, int i2) {
        AppMethodBeat.i(50759);
        a aVar = (a) this.fWm.get(str2);
        if (aVar == null) {
            aVar = new a();
        }
        aVar.fWz = str;
        aVar.fWA = str2;
        aVar.toUser = str3;
        aVar.dqJ = str4;
        aVar.fWB = str5;
        aVar.fWD = i;
        aVar.fWC = i2;
        aVar.startTime = bo.anU();
        this.fWm.put(str2, aVar);
        ab.i("MicroMsg.SubCoreMediaRpt", "note video upload path[%s, %s] toUser %s msgSource %s snsInfoId %s sendScene %d cpStatus %d", str, str2, str3, str4, str5, Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.o(50759);
    }

    public final void a(final com.tencent.mm.i.d dVar, final String str) {
        AppMethodBeat.i(50760);
        if (dVar == null || bo.isNullOrNil(str)) {
            AppMethodBeat.o(50760);
            return;
        }
        g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(50752);
                a aVar = (a) n.this.fWm.remove(str);
                if (aVar == null) {
                    AppMethodBeat.o(50752);
                    return;
                }
                int i;
                com.tencent.mm.plugin.sight.base.a aVar2;
                int cs = e.cs(aVar.fWA);
                com.tencent.mm.plugin.sight.base.a WR = d.WR(aVar.fWA);
                if (bo.isNullOrNil(aVar.fWz)) {
                    i = cs;
                    aVar2 = WR;
                } else {
                    com.tencent.mm.plugin.sight.base.a WR2 = d.WR(aVar.fWz);
                    i = e.cs(aVar.fWz);
                    aVar2 = WR2;
                }
                if (aVar2 == null || WR == null) {
                    ab.w("MicroMsg.SubCoreMediaRpt", "upload video but media info is null. %s", aVar.fWA);
                    AppMethodBeat.o(50752);
                    return;
                }
                StringBuffer stringBuffer;
                int gD = com.tencent.mm.sdk.platformtools.at.gD(ah.getContext());
                long j = dVar.field_startTime != 0 ? dVar.field_startTime : aVar.startTime;
                long anU = dVar.field_endTime != 0 ? dVar.field_endTime : bo.anU();
                String str = null;
                if (dVar.field_usedSvrIps != null) {
                    stringBuffer = new StringBuffer();
                    for (String append : dVar.field_usedSvrIps) {
                        stringBuffer.append(append).append("|");
                    }
                    str = stringBuffer.toString();
                }
                stringBuffer = new StringBuffer();
                stringBuffer.append(aVar.toUser).append(",").append(aVar.dqJ).append(",");
                stringBuffer.append(gD).append(",").append(dVar.field_fileId).append(",");
                stringBuffer.append(dVar.field_mp4identifymd5).append(",").append(com.tencent.mm.plugin.video.c.abR(aVar.fWB)).append(",");
                stringBuffer.append(j).append(",").append(anU).append(",");
                stringBuffer.append(i).append(",").append(aVar2.eWK).append(",");
                stringBuffer.append(aVar2.videoBitrate / 1000).append(",").append(aVar2.fzS / 1000).append(",");
                stringBuffer.append(aVar2.eTk).append(",").append(aVar2.width).append(",");
                stringBuffer.append(aVar2.height).append(",").append(aVar.fWC).append(",");
                stringBuffer.append(cs).append(",").append(WR.eWK).append(",");
                stringBuffer.append(WR.videoBitrate / 1000).append(",").append(WR.fzS / 1000).append(",");
                stringBuffer.append(WR.eTk).append(",").append(WR.width).append(",");
                stringBuffer.append(WR.height).append(",").append(aVar.fWD).append(",");
                stringBuffer.append(str).append(",").append(aVar2.qwV).append(",").append(dVar.field_fileUrl);
                ab.i("MicroMsg.SubCoreMediaRpt", "upload video rpt %s", stringBuffer.toString());
                new bc(stringBuffer.toString()).ajK();
                n.cD(WR.videoBitrate, aVar.fWD);
                AppMethodBeat.o(50752);
            }
        });
        AppMethodBeat.o(50760);
    }

    public final HashMap<Integer, h.d> Jx() {
        return null;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
    }

    public final void bA(boolean z) {
    }

    public final void onAccountRelease() {
    }

    static /* synthetic */ void cD(int i, int i2) {
        int i3;
        int i4;
        AppMethodBeat.i(50761);
        switch (i2) {
            case 1:
                i3 = 101;
                i4 = 107;
                break;
            case 2:
                i3 = 111;
                i4 = com.tencent.view.d.MIC_ALPHA_ADJUST_REAL;
                break;
            case 4:
                i3 = 131;
                i4 = 137;
                break;
            case 5:
                i3 = 121;
                i4 = com.tencent.view.d.MIC_SketchMark;
                break;
            default:
                AppMethodBeat.o(50761);
                return;
        }
        com.tencent.mm.plugin.report.service.h.pYm.a(422, (long) bo.h((Integer) com.tencent.mm.plugin.report.service.h.a(i / 1000, new int[]{350, 544, 800, TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, 1600, 2000}, i3, i4)), 1, false);
        ab.i("MicroMsg.SubCoreMediaRpt", "rptIdkey [%d] bitrate [%d] sendScene [%d]", Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.o(50761);
    }
}

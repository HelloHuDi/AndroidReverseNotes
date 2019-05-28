package com.tencent.p177mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p187al.C8941a;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C18307jv;
import com.tencent.p177mm.p230g.p232b.p233a.C37832j;
import com.tencent.p177mm.p230g.p232b.p233a.C42087bc;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sight.base.C21846d;
import com.tencent.p177mm.plugin.sight.base.C43528a;
import com.tencent.p177mm.plugin.video.C14013c;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.rtmp.TXLivePushConfig;
import com.tencent.view.C31128d;
import java.util.HashMap;

/* renamed from: com.tencent.mm.modelvideo.n */
public class C45459n implements C1816at {
    public HashMap<String, C42227a> fWm = new HashMap();
    private C4884c<C18307jv> fWn = new C97173();

    /* renamed from: com.tencent.mm.modelvideo.n$3 */
    class C97173 extends C4884c<C18307jv> {
        C97173() {
            AppMethodBeat.m2504i(50754);
            this.xxI = C18307jv.class.getName().hashCode();
            AppMethodBeat.m2505o(50754);
        }

        /* renamed from: a */
        private boolean m17297a(C18307jv c18307jv) {
            AppMethodBeat.m2504i(50755);
            C4990ab.m7410d("MicroMsg.SubCoreMediaRpt", "get media info report event.");
            if (c18307jv == null) {
                AppMethodBeat.m2505o(50755);
                return false;
            }
            String str;
            String str2 = c18307jv.cEU.path;
            try {
                if (str2.endsWith(".tmp")) {
                    str2 = str2.substring(0, str2.lastIndexOf(".tmp"));
                    C4990ab.m7417i("MicroMsg.SubCoreMediaRpt", "media info event path[%s, %s]", str2, c18307jv.cEU.path);
                }
                str = str2;
            } catch (Exception e) {
                str = str2;
            }
            C45459n c45459n = C45459n.this;
            String str3 = c18307jv.cEU.cEV;
            String str4 = c18307jv.cEU.cEW;
            int i = c18307jv.cEU.cEX;
            String str5 = c18307jv.cEU.fileId;
            String str6 = c18307jv.cEU.cEZ;
            long j = c18307jv.cEU.startTime;
            long j2 = c18307jv.cEU.endTime;
            C1720g.m3539RS().mo10302aa(new C264912(str, c18307jv.cEU.cEY, str3, str4, i, str5, str6, j, j2, c18307jv.cEU.cFa, c18307jv.cEU.cFb, c18307jv.cEU.cFc));
            AppMethodBeat.m2505o(50755);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.modelvideo.n$2 */
    class C264912 implements Runnable {
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

        C264912(String str, String[] strArr, String str2, String str3, int i, String str4, String str5, long j, long j2, int i2, int i3, String str6) {
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
            AppMethodBeat.m2504i(50753);
            C43528a WR = C21846d.m33388WR(this.bSt);
            if (WR == null) {
                C4990ab.m7421w("MicroMsg.SubCoreMediaRpt", "get media info is null. %s", this.bSt);
                AppMethodBeat.m2505o(50753);
                return;
            }
            int cs = C1173e.m2560cs(this.bSt);
            String str = null;
            if (this.fWq != null) {
                StringBuffer stringBuffer = new StringBuffer();
                for (String append : this.fWq) {
                    stringBuffer.append(append).append("|");
                }
                str = stringBuffer.toString();
            }
            int gD = C5023at.m7473gD(C4996ah.getContext());
            C37461f.afy();
            String rJ = C8941a.m16130rJ(this.bSt);
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
            stringBuffer2.append(C14013c.abR(this.fWy));
            C4990ab.m7417i("MicroMsg.SubCoreMediaRpt", "download video rpt %s ", stringBuffer2.toString());
            new C37832j(stringBuffer2.toString()).ajK();
            AppMethodBeat.m2505o(50753);
        }
    }

    /* renamed from: com.tencent.mm.modelvideo.n$a */
    public class C42227a {
        public String cEZ;
        public String dqJ;
        public C9545d fVQ;
        public String fWA;
        public String fWB;
        public int fWC;
        public int fWD;
        public String fWz;
        public long startTime;
        public String toUser;
    }

    public C45459n() {
        AppMethodBeat.m2504i(50757);
        C4879a.xxA.mo10052c(this.fWn);
        AppMethodBeat.m2505o(50757);
    }

    public static C45459n alj() {
        AppMethodBeat.m2504i(50758);
        C45459n c45459n = (C45459n) C7485q.m12925Y(C45459n.class);
        AppMethodBeat.m2505o(50758);
        return c45459n;
    }

    /* renamed from: a */
    public final void mo73267a(String str, String str2, String str3, String str4, String str5, int i, int i2) {
        AppMethodBeat.m2504i(50759);
        C42227a c42227a = (C42227a) this.fWm.get(str2);
        if (c42227a == null) {
            c42227a = new C42227a();
        }
        c42227a.fWz = str;
        c42227a.fWA = str2;
        c42227a.toUser = str3;
        c42227a.dqJ = str4;
        c42227a.fWB = str5;
        c42227a.fWD = i;
        c42227a.fWC = i2;
        c42227a.startTime = C5046bo.anU();
        this.fWm.put(str2, c42227a);
        C4990ab.m7417i("MicroMsg.SubCoreMediaRpt", "note video upload path[%s, %s] toUser %s msgSource %s snsInfoId %s sendScene %d cpStatus %d", str, str2, str3, str4, str5, Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.m2505o(50759);
    }

    /* renamed from: a */
    public final void mo73266a(final C9545d c9545d, final String str) {
        AppMethodBeat.m2504i(50760);
        if (c9545d == null || C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(50760);
            return;
        }
        C1720g.m3539RS().mo10302aa(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(50752);
                C42227a c42227a = (C42227a) C45459n.this.fWm.remove(str);
                if (c42227a == null) {
                    AppMethodBeat.m2505o(50752);
                    return;
                }
                int i;
                C43528a c43528a;
                int cs = C1173e.m2560cs(c42227a.fWA);
                C43528a WR = C21846d.m33388WR(c42227a.fWA);
                if (C5046bo.isNullOrNil(c42227a.fWz)) {
                    i = cs;
                    c43528a = WR;
                } else {
                    C43528a WR2 = C21846d.m33388WR(c42227a.fWz);
                    i = C1173e.m2560cs(c42227a.fWz);
                    c43528a = WR2;
                }
                if (c43528a == null || WR == null) {
                    C4990ab.m7421w("MicroMsg.SubCoreMediaRpt", "upload video but media info is null. %s", c42227a.fWA);
                    AppMethodBeat.m2505o(50752);
                    return;
                }
                StringBuffer stringBuffer;
                int gD = C5023at.m7473gD(C4996ah.getContext());
                long j = c9545d.field_startTime != 0 ? c9545d.field_startTime : c42227a.startTime;
                long anU = c9545d.field_endTime != 0 ? c9545d.field_endTime : C5046bo.anU();
                String str = null;
                if (c9545d.field_usedSvrIps != null) {
                    stringBuffer = new StringBuffer();
                    for (String append : c9545d.field_usedSvrIps) {
                        stringBuffer.append(append).append("|");
                    }
                    str = stringBuffer.toString();
                }
                stringBuffer = new StringBuffer();
                stringBuffer.append(c42227a.toUser).append(",").append(c42227a.dqJ).append(",");
                stringBuffer.append(gD).append(",").append(c9545d.field_fileId).append(",");
                stringBuffer.append(c9545d.field_mp4identifymd5).append(",").append(C14013c.abR(c42227a.fWB)).append(",");
                stringBuffer.append(j).append(",").append(anU).append(",");
                stringBuffer.append(i).append(",").append(c43528a.eWK).append(",");
                stringBuffer.append(c43528a.videoBitrate / 1000).append(",").append(c43528a.fzS / 1000).append(",");
                stringBuffer.append(c43528a.eTk).append(",").append(c43528a.width).append(",");
                stringBuffer.append(c43528a.height).append(",").append(c42227a.fWC).append(",");
                stringBuffer.append(cs).append(",").append(WR.eWK).append(",");
                stringBuffer.append(WR.videoBitrate / 1000).append(",").append(WR.fzS / 1000).append(",");
                stringBuffer.append(WR.eTk).append(",").append(WR.width).append(",");
                stringBuffer.append(WR.height).append(",").append(c42227a.fWD).append(",");
                stringBuffer.append(str).append(",").append(c43528a.qwV).append(",").append(c9545d.field_fileUrl);
                C4990ab.m7417i("MicroMsg.SubCoreMediaRpt", "upload video rpt %s", stringBuffer.toString());
                new C42087bc(stringBuffer.toString()).ajK();
                C45459n.m83758cD(WR.videoBitrate, c42227a.fWD);
                AppMethodBeat.m2505o(50752);
            }
        });
        AppMethodBeat.m2505o(50760);
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return null;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    public final void onAccountRelease() {
    }

    /* renamed from: cD */
    static /* synthetic */ void m83758cD(int i, int i2) {
        int i3;
        int i4;
        AppMethodBeat.m2504i(50761);
        switch (i2) {
            case 1:
                i3 = 101;
                i4 = 107;
                break;
            case 2:
                i3 = 111;
                i4 = C31128d.MIC_ALPHA_ADJUST_REAL;
                break;
            case 4:
                i3 = 131;
                i4 = 137;
                break;
            case 5:
                i3 = 121;
                i4 = C31128d.MIC_SketchMark;
                break;
            default:
                AppMethodBeat.m2505o(50761);
                return;
        }
        C7060h.pYm.mo8378a(422, (long) C5046bo.m7567h((Integer) C7060h.m11789a(i / 1000, new int[]{350, 544, 800, TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, 1600, 2000}, i3, i4)), 1, false);
        C4990ab.m7417i("MicroMsg.SubCoreMediaRpt", "rptIdkey [%d] bitrate [%d] sendScene [%d]", Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.m2505o(50761);
    }
}

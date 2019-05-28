package com.tencent.p177mm.modelvideo;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1829bf.C1828b;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.network.C32856ab;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1205a;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p187al.C37458c;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p187al.C45150e;
import com.tencent.p177mm.p230g.p232b.p233a.C42099d;
import com.tencent.p177mm.p230g.p232b.p233a.C9514f;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C44686h;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h.C3460c;
import com.tencent.p177mm.plugin.p991m.p1488a.C34506a;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C30242xl;
import com.tencent.p177mm.protocal.protobuf.C44192xm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C7571bh;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.modelvideo.d */
public final class C6689d extends C1207m implements C1918k {
    private String cHr;
    private C7472b ehh;
    C1202f ehi;
    String fFa;
    String fFh;
    int fFi;
    private C1628a fFk;
    boolean fVh;
    boolean fVi;
    C26493s fVj;
    C44686h fVk;
    int fVl;
    private boolean fVm;
    boolean fVn;
    long fVo;
    String fileName;
    int frO;
    private C7564ap frk;
    int retCode;
    private int startOffset;
    long startTime;

    /* renamed from: com.tencent.mm.modelvideo.d$1 */
    class C66901 implements C1628a {
        C66901() {
        }

        /* renamed from: a */
        public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
            AppMethodBeat.m2504i(50665);
            if (i == -21006) {
                C4990ab.m7411d("MicroMsg.NetSceneDownloadVideo", "%s cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", C6689d.this.alb(), C6689d.this.fFa);
                AppMethodBeat.m2505o(50665);
                return 0;
            } else if (i != 0) {
                C26494u.m42261um(C6689d.this.fileName);
                String r = C46180a.m86311r(Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(C6689d.this.startTime), Long.valueOf(C5046bo.anU()), Integer.valueOf(C37458c.m63165bW(C4996ah.getContext())), Integer.valueOf(C6689d.this.fVl), Integer.valueOf(C6689d.this.frO), "");
                new C9514f(r).ajK();
                new C42099d(r).ajK();
                C6689d.this.ehi.onSceneEnd(3, i, "", C6689d.this);
                AppMethodBeat.m2505o(50665);
                return 0;
            } else {
                C6689d.this.fVj = C26494u.m42268ut(C6689d.this.fileName);
                int i2;
                if (C6689d.this.fVj == null || C6689d.this.fVj.status == 113) {
                    if (C6689d.this.fVj == null) {
                        i2 = -1;
                    } else {
                        i2 = C6689d.this.fVj.status;
                    }
                    C4990ab.m7417i("MicroMsg.NetSceneDownloadVideo", "%s upload video info is null or has paused, status:%d", C6689d.this.alb(), Integer.valueOf(i2));
                    C6689d.this.mo14936EH();
                    C6689d.this.ehi.onSceneEnd(3, i, "upload video info is null or has paused, status".concat(String.valueOf(i2)), C6689d.this);
                    AppMethodBeat.m2505o(50665);
                    return 0;
                } else if (c18496c == null) {
                    if (c9545d != null) {
                        C4990ab.m7417i("MicroMsg.NetSceneDownloadVideo", "%s cdntra sceneResult.retCode:%d useTime:%d ", C6689d.this.alb(), Integer.valueOf(c9545d.field_retCode), Long.valueOf(C5046bo.anU() - C6689d.this.fVo));
                        C6689d c6689d = C6689d.this;
                        C44686h c44686h = C6689d.this.fVk;
                        if (c44686h == null || c9545d == null) {
                            C4990ab.m7420w("MicroMsg.NetSceneDownloadVideo", "it had not task info or scene Result, don't report.");
                        } else if (c44686h.field_smallVideoFlag == 1) {
                            C4990ab.m7416i("MicroMsg.NetSceneDownloadVideo", "it download short video, don't report.");
                        } else if (!(c44686h == null || c9545d == null)) {
                            C4990ab.m7417i("MicroMsg.NetSceneDownloadVideo", "%s sceneResult.field_recvedBytes %d, time [%d, %d]", c6689d.alb(), Integer.valueOf(c9545d.field_recvedBytes), Long.valueOf(c9545d.field_startTime), Long.valueOf(c9545d.field_endTime));
                            C37961o.alm();
                            C45150e.m83028a(null, c9545d, c44686h, true);
                        }
                        if (c9545d.field_retCode != 0) {
                            C26494u.m42261um(C6689d.this.fileName);
                            if (C6689d.this.fVh) {
                                C7060h.pYm.mo8378a(354, 13, 1, false);
                            }
                            if (C6689d.this.fVi) {
                                C7060h.pYm.mo8378a(354, 252, 1, false);
                            }
                            C6689d.this.ehi.onSceneEnd(3, c9545d.field_retCode, "", C6689d.this);
                        } else {
                            if (C6689d.this.fVh) {
                                C7060h.pYm.mo8378a(354, 12, 1, false);
                            }
                            if (C6689d.this.fVi) {
                                C7060h.pYm.mo8378a(354, 137, 1, false);
                            }
                            C6689d.this.mo14938mo(c9545d.field_fileLength);
                        }
                        new C9514f(C46180a.m86311r(Integer.valueOf(c9545d.field_retCode), Integer.valueOf(2), Long.valueOf(C6689d.this.startTime), Long.valueOf(C5046bo.anU()), Integer.valueOf(C37458c.m63165bW(C4996ah.getContext())), Integer.valueOf(C6689d.this.fVl), Integer.valueOf(C6689d.this.frO), c9545d.field_transInfo, "", "", "", "", "", "", "", c9545d.efY)).ajK();
                        if (c9545d.field_retCode != 0) {
                            new C42099d(C46180a.m86311r(Integer.valueOf(c9545d.field_retCode), Integer.valueOf(2), Long.valueOf(C6689d.this.startTime), Long.valueOf(C5046bo.anU()), Integer.valueOf(C37458c.m63165bW(C4996ah.getContext())), Integer.valueOf(C6689d.this.fVl), Integer.valueOf(C6689d.this.frO), c9545d.field_transInfo, "", "", "", "", "", "", "", c9545d.efY)).ajK();
                        }
                        C9713a.m17288a(C6689d.this.fVj, 1);
                        C6689d.this.fVk = null;
                    }
                    AppMethodBeat.m2505o(50665);
                    return 0;
                } else if (c18496c.field_finishedLength == C6689d.this.frO) {
                    C4990ab.m7410d("MicroMsg.NetSceneDownloadVideo", "cdntra ignore progress 100%");
                    AppMethodBeat.m2505o(50665);
                    return 0;
                } else if (C6689d.this.fVj.fWY <= c18496c.field_finishedLength || C6689d.this.fVh) {
                    i2 = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                    C6689d.this.fVj.fXb = C5046bo.anT();
                    if (C6689d.this.fVj.fWY < c18496c.field_finishedLength) {
                        C6689d.this.fVj.fWY = c18496c.field_finishedLength;
                        i2 = 1040;
                    }
                    C6689d.this.fVj.bJt = i2;
                    C26494u.m42253f(C6689d.this.fVj);
                    C4990ab.m7411d("MicroMsg.NetSceneDownloadVideo", "%s cdntra progresscallback id:%s finish:%d total:%d", C6689d.this.alb(), C6689d.this.fFa, Integer.valueOf(c18496c.field_finishedLength), Integer.valueOf(c18496c.field_toltalLength));
                    AppMethodBeat.m2505o(50665);
                    return 0;
                } else {
                    C4990ab.m7413e("MicroMsg.NetSceneDownloadVideo", "%s cdnEndProc error oldpos:%d newpos:%d", C6689d.this.alb(), Integer.valueOf(C6689d.this.fVj.fWY), Integer.valueOf(c18496c.field_finishedLength));
                    C26494u.m42261um(C6689d.this.fileName);
                    C6689d.this.ehi.onSceneEnd(3, i, "", C6689d.this);
                    AppMethodBeat.m2505o(50665);
                    return 0;
                }
            }
        }

        /* renamed from: a */
        public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        /* renamed from: l */
        public final byte[] mo5084l(String str, byte[] bArr) {
            return null;
        }
    }

    /* renamed from: com.tencent.mm.modelvideo.d$3 */
    class C66913 implements C5015a {
        C66913() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(50667);
            if (C6689d.this.mo4456a(C6689d.this.ftf, C6689d.this.ehi) == -1) {
                C6689d.this.ehi.onSceneEnd(3, -1, "doScene failed", C6689d.this);
            }
            AppMethodBeat.m2505o(50667);
            return false;
        }
    }

    public final void cancel() {
        AppMethodBeat.m2504i(50668);
        mo14936EH();
        super.cancel();
        AppMethodBeat.m2505o(50668);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: EH */
    public final boolean mo14936EH() {
        boolean z = false;
        AppMethodBeat.m2504i(50669);
        if (!C5046bo.isNullOrNil(this.cHr)) {
            if (this.fVh) {
                C4990ab.m7417i("MicroMsg.NetSceneDownloadVideo", "%s cancel online video task.", alb());
                C37961o.alm().mo73064m(this.cHr, null);
            } else {
                C4990ab.m7417i("MicroMsg.NetSceneDownloadVideo", "%s cancel offline video task.", alb());
                C37461f.afx().mo51228rO(this.cHr);
            }
            z = true;
        }
        this.fVm = true;
        AppMethodBeat.m2505o(50669);
        return z;
    }

    public C6689d(String str) {
        this(str, false);
    }

    public C6689d(String str, boolean z) {
        AppMethodBeat.m2504i(50670);
        this.fVj = null;
        this.fFa = "";
        this.startOffset = 0;
        this.startTime = 0;
        this.frO = 0;
        this.retCode = 0;
        this.fVl = C42129a.MediaType_VIDEO;
        this.fVm = false;
        this.fVn = true;
        this.fFh = null;
        this.fFi = 0;
        this.fVo = 0;
        this.fFk = new C66901();
        this.frk = new C7564ap(new C66913(), false);
        Assert.assertTrue(str != null);
        this.fileName = str;
        this.fVh = z;
        C4990ab.m7417i("MicroMsg.NetSceneDownloadVideo", "%s NetSceneDownloadVideo:  file [%s] isCompleteOnlineVideo [%b]", alb(), str, Boolean.valueOf(z));
        AppMethodBeat.m2505o(50670);
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x04fc  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x05d2  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x05f1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean ala() {
        AppMethodBeat.m2504i(50671);
        C4990ab.m7411d("MicroMsg.NetSceneDownloadVideo", "%s parseVideoMsgXML content: %s", alb(), this.fVj.alw());
        Map z = C5049br.m7595z(this.fVj.alw(), "msg");
        if (z == null) {
            C7060h.pYm.mo8378a(111, 214, 1, false);
            C4990ab.m7421w("MicroMsg.NetSceneDownloadVideo", "%s cdntra parse video recv xml failed", alb());
            AppMethodBeat.m2505o(50671);
            return false;
        }
        String str = (String) z.get(".msg.videomsg.$cdnvideourl");
        String str2 = (String) z.get(".msg.videomsg.$tpvideourl");
        if (C5046bo.isNullOrNil(str) && C5046bo.isNullOrNil(str2)) {
            C7060h.pYm.mo8378a(111, 213, 1, false);
            C4990ab.m7421w("MicroMsg.NetSceneDownloadVideo", "%s cdntra parse video recv xml failed", alb());
            AppMethodBeat.m2505o(50671);
            return false;
        }
        String str3 = (String) z.get(".msg.videomsg.$aeskey");
        this.frO = C5046bo.getInt((String) z.get(".msg.videomsg.$length"), 0);
        String str4 = (String) z.get(".msg.videomsg.$fileparam");
        this.fFa = C37458c.m63162a("downvideo", this.fVj.createTime, this.fVj.getUser(), this.fVj.getFileName());
        if (C5046bo.isNullOrNil(this.fFa)) {
            C4990ab.m7421w("MicroMsg.NetSceneDownloadVideo", "%s cdntra genClientId failed not use cdn file:%s", alb(), this.fVj.getFileName());
            AppMethodBeat.m2505o(50671);
            return false;
        }
        Object obj;
        if (!this.fVh && this.frO < 1048576 && this.fVj != null && this.fVj.cFa > 0) {
            this.fVh = true;
            C4990ab.m7417i("MicroMsg.NetSceneDownloadVideo", "%s less 1M and had preload, reset isCompleteOnlineVideo [%b]", alb(), Boolean.valueOf(this.fVh));
        }
        String str5 = (String) z.get(".msg.videomsg.$md5");
        StringBuilder stringBuilder = new StringBuilder();
        C37961o.all();
        String stringBuilder2 = stringBuilder.append(C9720t.m17303uh(this.fileName)).append(".tmp").toString();
        this.fVk = new C44686h();
        this.fVk.filename = this.fVj.getFileName();
        this.fVk.egB = str5;
        this.fVk.egC = this.frO;
        this.fVk.egD = 0;
        this.fVk.cEV = this.fVj.alt();
        this.fVk.egE = this.fVj.getUser();
        this.fVk.cEX = C1855t.m3896kH(this.fVj.getUser()) ? C37921n.m64060mA(this.fVj.getUser()) : 0;
        this.fVk.field_mediaId = this.fFa;
        this.fVk.field_fullpath = stringBuilder2;
        this.fVk.field_fileType = C42129a.MediaType_VIDEO;
        this.fVk.field_totalLen = this.frO;
        this.fVk.field_aesKey = str3;
        this.fVk.field_fileId = str;
        this.fVk.field_priority = C42129a.efC;
        this.fVk.egl = this.fFk;
        this.fVk.field_wxmsgparam = str4;
        this.fVk.field_chattype = C1855t.m3896kH(this.fVj.getUser()) ? 1 : 0;
        this.fVk.egF = this.fVj.egF;
        if (!C5046bo.isNullOrNil(str2)) {
            str3 = (String) z.get(".msg.videomsg.$tpauthkey");
            this.fVk.field_fileId = "";
            this.fVk.field_fileType = 19;
            this.fVk.field_authKey = str3;
            this.fVk.egm = str2;
        }
        C7620bi Q = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15241Q(this.fVj.getUser(), this.fVj.cKK);
        this.fVk.egH = Q.field_createTime;
        this.fVk.cKK = Q.field_msgSvrId;
        C1828b oE = C1829bf.m3758oE(Q.dqJ);
        this.fVk.egI = oE != null ? oE.fmG : 0;
        if (this.fVj.getUser().equals(Q.field_talker)) {
            this.fVk.field_limitrate = oE == null ? 0 : oE.fmE / 8;
        }
        C4990ab.m7411d("MicroMsg.NetSceneDownloadVideo", "%s limitrate:%d file:%s", alb(), Integer.valueOf(this.fVk.field_limitrate), this.fVj.getFileName());
        if (C37461f.afx().fyQ.contains("video_" + this.fVj.fXe)) {
            C37461f.afx().fyQ.remove("video_" + this.fVj.fXe);
            this.fVk.field_autostart = true;
        } else {
            this.fVk.field_autostart = false;
        }
        if (3 == this.fVj.fXk) {
            this.fVk.field_smallVideoFlag = 1;
        }
        if (!(C5046bo.isNullOrNil(str5) || this.fVh)) {
            int i;
            str2 = ((C34506a) C1720g.m3528K(C34506a.class)).mo24388XT().mo16778es(str5, this.frO);
            int asZ = (int) C5730e.asZ(str2);
            int i2 = this.frO - asZ;
            C37961o.all();
            str3 = C9720t.m17303uh(this.fileName);
            if (((int) C5730e.asZ(str3)) > 0) {
                C4990ab.m7421w("MicroMsg.NetSceneDownloadVideo", "%s already copy dup file, but download again, something error here.", alb());
                boolean deleteFile = C5730e.deleteFile(str3);
                C7571bh XT = ((C34506a) C1720g.m3528K(C34506a.class)).mo24388XT();
                int i3 = this.frO;
                i = 0;
                if (!C5046bo.isNullOrNil(str5)) {
                    i = XT.bSd.delete("MediaDuplication", "md5=? AND size=? AND status!=?", new String[]{str5, String.valueOf(i3), "100"});
                }
                C26493s ut = C26494u.m42268ut(this.fileName);
                ut.fWY = 0;
                ut.bJt = 16;
                C26494u.m42253f(ut);
                C4990ab.m7421w("MicroMsg.NetSceneDownloadVideo", "%s don't copy dup file, go to download now. target video len %d, delete file:%b,delete db: %d", alb(), Integer.valueOf(r11), Boolean.valueOf(deleteFile), Integer.valueOf(i));
                str2 = "";
            }
            C4990ab.m7417i("MicroMsg.NetSceneDownloadVideo", "%s MediaCheckDuplicationStorage: totallen:%s md5:%s  dup(len:%d path:%s) diffLen:%d to:%s target video len %d", alb(), Integer.valueOf(this.frO), str5, Integer.valueOf(asZ), str2, Integer.valueOf(i2), stringBuilder2, Integer.valueOf(r11));
            if (C5046bo.isNullOrNil(str2)) {
                this.fFh = str5;
                this.fFi = this.frO;
            } else if (i2 >= 0 && i2 <= 16) {
                C4990ab.m7417i("MicroMsg.NetSceneDownloadVideo", "%s MediaCheckDuplicationStorage copy dup file now :%s -> %s", alb(), str2, stringBuilder2);
                C5730e.m8644y(str2, stringBuilder2);
                mo14938mo(this.frO);
                ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15289a(new C3460c(Q.field_talker, "update", Q));
                C7060h c7060h = C7060h.pYm;
                Object[] objArr = new Object[7];
                objArr[0] = str;
                objArr[1] = Long.valueOf(this.fVj.cKK);
                objArr[2] = str5;
                objArr[3] = Long.valueOf(this.fVj.createTime);
                objArr[4] = this.fVj.getUser();
                objArr[5] = Integer.valueOf(3 != this.fVj.fXk ? 43 : 62);
                objArr[6] = Integer.valueOf(asZ);
                c7060h.mo8381e(13267, objArr);
                obj = 1;
                if (obj == null) {
                    this.cHr = this.fVk.field_mediaId;
                    this.fVo = C5046bo.anU();
                    this.fVi = this.fVj.videoFormat == 2;
                    C4990ab.m7417i("MicroMsg.NetSceneDownloadVideo", "%s check use cdn isHadHevcLocalFile[%b] isCompleteOnlineVideo[%b]", alb(), Boolean.valueOf(this.fVi), Boolean.valueOf(this.fVh));
                    if (this.fVh) {
                        this.fVn = false;
                        C44686h c44686h = this.fVk;
                        C37961o.all();
                        c44686h.field_fullpath = C9720t.m17303uh(this.fileName);
                        if (this.fVi) {
                            this.fVk.field_requestVideoFormat = 2;
                            C7060h.pYm.mo8378a(354, 251, 1, false);
                        }
                        C37961o.alm().mo73060a(this.fVk, false);
                    } else if (!C37461f.afx().mo51222b(this.fVk, -1)) {
                        C7060h.pYm.mo8378a(111, 212, 1, false);
                        C4990ab.m7413e("MicroMsg.NetSceneDownloadVideo", "%s cdntra addSendTask failed.", alb());
                        this.fFa = "";
                        AppMethodBeat.m2505o(50671);
                        return false;
                    } else if (this.fVi) {
                        C7060h.pYm.mo8378a(354, 135, 1, false);
                    }
                }
                if (this.fVj.fXi != 1) {
                    this.fVj.fXi = 1;
                    this.fVj.bJt = SQLiteGlobal.journalSizeLimit;
                    C26494u.m42253f(this.fVj);
                }
                if (3 != this.fVj.fXk) {
                    str5 = this.fVj.getUser();
                    if (!C5046bo.isNullOrNil(str5)) {
                        int mA;
                        if (C1855t.m3896kH(str5)) {
                            mA = C37921n.m64060mA(str5);
                        } else {
                            mA = 0;
                        }
                        try {
                            NetworkInfo activeNetworkInfo = ((ConnectivityManager) C4996ah.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
                            int subtype = activeNetworkInfo.getSubtype();
                            if (activeNetworkInfo.getType() == 1) {
                                i = 1;
                            } else if (subtype == 13 || subtype == 15 || subtype == 14) {
                                i = 4;
                            } else if (subtype == 3 || subtype == 4 || subtype == 5 || subtype == 6 || subtype == 12) {
                                i = 3;
                            } else if (subtype == 1 || subtype == 2) {
                                i = 2;
                            } else {
                                i = 0;
                            }
                        } catch (Exception e) {
                            C4990ab.m7413e("MicroMsg.NetSceneDownloadVideo", "getNetType : %s", C5046bo.m7574l(e));
                            i = 0;
                        }
                        C4990ab.m7417i("MicroMsg.NetSceneDownloadVideo", "%s dk12024 report:%s", alb(), str5 + "," + mA + "," + str + "," + this.frO + "," + i);
                        C7060h.pYm.mo8374X(12024, str);
                    }
                }
                AppMethodBeat.m2505o(50671);
                return true;
            }
        }
        obj = null;
        if (obj == null) {
        }
        if (this.fVj.fXi != 1) {
        }
        if (3 != this.fVj.fXk) {
        }
        AppMethodBeat.m2505o(50671);
        return true;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: mo */
    public final void mo14938mo(final int i) {
        boolean o;
        AppMethodBeat.m2504i(50672);
        if (this.fVn) {
            StringBuilder stringBuilder = new StringBuilder();
            C37961o.all();
            C5728b c5728b = new C5728b(stringBuilder.append(C9720t.m17303uh(this.fileName)).append(".tmp").toString());
            C37961o.all();
            o = c5728b.mo11675o(new C5728b(C9720t.m17303uh(this.fileName)));
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            C37961o.all();
            C5730e.deleteFile(stringBuilder2.append(C9720t.m17303uh(this.fileName)).append(".tmp").toString());
            o = true;
        }
        C1720g.m3539RS().mo10302aa(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(50666);
                Map z = C5049br.m7595z(C6689d.this.fVj.alw(), "msg");
                if (z != null) {
                    C9720t all = C37961o.all();
                    C37961o.all();
                    all.mo21062s(C9720t.m17303uh(C6689d.this.fileName), (String) z.get(".msg.videomsg.$cdnvideourl"), (String) z.get(".msg.videomsg.$aeskey"));
                }
                boolean z2 = false;
                if (o) {
                    z2 = C26494u.m42242ae(C6689d.this.fileName, i);
                    if (C6689d.this.fVi) {
                        C26494u.m42274uz(C6689d.this.fileName);
                        C4990ab.m7416i("MicroMsg.NetSceneDownloadVideo", "sceneEndproc, isHadHevcLocalFile");
                    }
                } else if (C6689d.this.fVi) {
                    C26494u.m42261um(C6689d.this.fileName);
                    C7060h.pYm.mo8378a(354, 138, 1, false);
                } else {
                    z2 = C26494u.m42242ae(C6689d.this.fileName, i);
                }
                C4990ab.m7417i("MicroMsg.NetSceneDownloadVideo", "%s ashutest::cdntra !FIN! file:%s svrid:%d human:%s user:%s updatedbsucc:%b  MediaCheckDuplicationStorage MD5:%s SIZE:%d renameFlag %b needRename %b", C6689d.this.alb(), C6689d.this.fileName, Long.valueOf(C6689d.this.fVj.cKK), C6689d.this.fVj.alt(), C6689d.this.fVj.getUser(), Boolean.valueOf(z2), C6689d.this.fFh, Integer.valueOf(C6689d.this.fFi), Boolean.valueOf(o), Boolean.valueOf(C6689d.this.fVn));
                if (!C5046bo.isNullOrNil(C6689d.this.fFh) && C6689d.this.fFi > 0) {
                    C7571bh XT = ((C34506a) C1720g.m3528K(C34506a.class)).mo24388XT();
                    String str = C6689d.this.fFh;
                    int i = C6689d.this.fFi;
                    C37961o.all();
                    XT.mo16779y(str, i, C9720t.m17303uh(C6689d.this.fileName));
                }
                if (C6689d.this.fVj.fXk == 3) {
                    C7060h.pYm.mo8378a(198, 38, (long) C6689d.this.fVj.frO, false);
                    C7060h.pYm.mo8378a(198, 40, (long) C6689d.this.fVj.fXd, false);
                    C7060h.pYm.mo8378a(198, 41, 1, false);
                    C7060h.pYm.mo8378a(198, C1855t.m3896kH(C6689d.this.fVj.getUser()) ? 43 : 42, 1, false);
                } else {
                    C7060h.pYm.mo8378a(198, 31, (long) C6689d.this.fVj.frO, false);
                    C7060h.pYm.mo8378a(198, 33, (long) C6689d.this.fVj.fXd, false);
                    C7060h.pYm.mo8378a(198, 34, 1, false);
                    C7060h.pYm.mo8378a(198, C1855t.m3896kH(C6689d.this.fVj.getUser()) ? 36 : 35, 1, false);
                }
                C6689d.this.ehi.onSceneEnd(0, 0, "", C6689d.this);
                AppMethodBeat.m2505o(50666);
            }
        });
        AppMethodBeat.m2505o(50672);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        int i = 1;
        AppMethodBeat.m2504i(50673);
        this.ehi = c1202f;
        this.fVj = C26494u.m42268ut(this.fileName);
        if (this.fVj == null) {
            C4990ab.m7412e("MicroMsg.NetSceneDownloadVideo", "ERR: Get INFO FAILED :" + this.fileName);
            this.retCode = (0 - C1447g.getLine()) - 10000;
            AppMethodBeat.m2505o(50673);
            return -1;
        }
        if (this.fVj != null && 3 == this.fVj.fXk) {
            this.fVl = C42129a.MediaType_TinyVideo;
        }
        if (this.startTime == 0) {
            this.startTime = C5046bo.anU();
            this.startOffset = this.fVj.fWY;
        }
        if (ala()) {
            C4990ab.m7411d("MicroMsg.NetSceneDownloadVideo", "cdntra use cdn return -1 for onGYNetEnd clientid:%s", this.fileName);
            AppMethodBeat.m2505o(50673);
            return 0;
        } else if (this.fVj.status != 112) {
            C4990ab.m7412e("MicroMsg.NetSceneDownloadVideo", "ERR: STATUS: " + this.fVj.status + " [" + this.fileName + "," + this.fVj.cKK + "," + this.fVj.alt() + "," + this.fVj.getUser() + "]");
            this.retCode = (0 - C1447g.getLine()) - 10000;
            AppMethodBeat.m2505o(50673);
            return -1;
        } else {
            C4990ab.m7410d("MicroMsg.NetSceneDownloadVideo", "start doScene  [" + this.fileName + "," + this.fVj.cKK + "," + this.fVj.alt() + "," + this.fVj.getUser() + "]  filesize:" + this.fVj.fWY + " file:" + this.fVj.frO + " netTimes:" + this.fVj.fXf);
            if (!C26494u.m42260ul(this.fileName)) {
                C4990ab.m7412e("MicroMsg.NetSceneDownloadVideo", "ERR: NET TIMES: " + this.fVj.fXf + " [" + this.fileName + "," + this.fVj.cKK + "," + this.fVj.alt() + "," + this.fVj.getUser() + "] ");
                C26494u.m42261um(this.fileName);
                this.retCode = (0 - C1447g.getLine()) - 10000;
                AppMethodBeat.m2505o(50673);
                return -1;
            } else if (this.fVj.cKK <= 0) {
                C4990ab.m7412e("MicroMsg.NetSceneDownloadVideo", "ERR: MSGSVRID: " + this.fVj.cKK + " [" + this.fileName + "," + this.fVj.cKK + "," + this.fVj.alt() + "," + this.fVj.getUser() + "] ");
                C26494u.m42261um(this.fileName);
                this.retCode = (0 - C1447g.getLine()) - 10000;
                AppMethodBeat.m2505o(50673);
                return -1;
            } else if (this.fVj.fWY < 0 || this.fVj.frO <= this.fVj.fWY || this.fVj.frO <= 0) {
                C4990ab.m7412e("MicroMsg.NetSceneDownloadVideo", "ERR: fileSize:" + this.fVj.fWY + " total:" + this.fVj.frO + " [" + this.fileName + "," + this.fVj.cKK + "," + this.fVj.alt() + "," + this.fVj.getUser() + "] ");
                C26494u.m42261um(this.fileName);
                this.retCode = (0 - C1447g.getLine()) - 10000;
                AppMethodBeat.m2505o(50673);
                return -1;
            } else {
                C1196a c1196a = new C1196a();
                c1196a.fsJ = new C30242xl();
                c1196a.fsK = new C44192xm();
                c1196a.uri = "/cgi-bin/micromsg-bin/downloadvideo";
                c1196a.fsI = 150;
                c1196a.fsL = 40;
                c1196a.fsM = 1000000040;
                this.ehh = c1196a.acD();
                C30242xl c30242xl = (C30242xl) this.ehh.fsG.fsP;
                c30242xl.ptF = this.fVj.cKK;
                c30242xl.ptx = this.fVj.fWY;
                c30242xl.ptw = this.fVj.frO;
                if (!C32856ab.m53750ch(C4996ah.getContext())) {
                    i = 2;
                }
                c30242xl.wdl = i;
                int a = mo4457a(c1902e, this.ehh, this);
                AppMethodBeat.m2505o(50673);
                return a;
            }
        }
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        AppMethodBeat.m2504i(50674);
        C30242xl c30242xl = (C30242xl) ((C7472b) c1929q).fsG.fsP;
        C1206b c1206b;
        if (c30242xl.ptF <= 0 || c30242xl.ptx < 0 || c30242xl.ptw <= 0 || c30242xl.ptw <= c30242xl.ptx) {
            C4990ab.m7412e("MicroMsg.NetSceneDownloadVideo", "ERR: SECURITY CHECK FAILED [" + this.fileName + "," + this.fVj.cKK + "," + this.fVj.alt() + "," + this.fVj.getUser() + "] ");
            C26494u.m42261um(this.fileName);
            c1206b = C1206b.EFailed;
            AppMethodBeat.m2505o(50674);
            return c1206b;
        }
        c1206b = C1206b.EOk;
        AppMethodBeat.m2505o(50674);
        return c1206b;
    }

    public final int acn() {
        return 2500;
    }

    public final boolean acJ() {
        AppMethodBeat.m2504i(50675);
        boolean acJ = super.acJ();
        if (acJ) {
            C7060h.pYm.mo8378a(111, 210, 1, false);
        }
        AppMethodBeat.m2505o(50675);
        return acJ;
    }

    /* renamed from: a */
    public final void mo4458a(C1205a c1205a) {
        AppMethodBeat.m2504i(50676);
        C7060h.pYm.mo8378a(111, 211, 1, false);
        C26494u.m42261um(this.fileName);
        AppMethodBeat.m2505o(50676);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(50677);
        if (this.fVm) {
            C4990ab.m7410d("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd Call Stop by Service  [" + this.fileName + "," + this.fVj.cKK + "," + this.fVj.alt() + "," + this.fVj.getUser() + "] ");
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(50677);
        } else if (i2 == 3 && i3 == -1 && !C5046bo.isNullOrNil(this.fFa)) {
            C4990ab.m7421w("MicroMsg.NetSceneDownloadVideo", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", this.fFa);
            AppMethodBeat.m2505o(50677);
        } else {
            C44192xm c44192xm = (C44192xm) ((C7472b) c1929q).fsH.fsP;
            C30242xl c30242xl = (C30242xl) ((C7472b) c1929q).fsG.fsP;
            this.fVj = C26494u.m42268ut(this.fileName);
            if (this.fVj == null) {
                C4990ab.m7412e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd Get INFO FAILED :" + this.fileName);
                this.retCode = (0 - C1447g.getLine()) - 10000;
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(50677);
            } else if (this.fVj.status == 113) {
                C4990ab.m7420w("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd STATUS PAUSE [" + this.fileName + "," + this.fVj.cKK + "," + this.fVj.alt() + "," + this.fVj.getUser() + "] ");
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(50677);
            } else if (this.fVj.status != 112) {
                C4990ab.m7412e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd STATUS ERR: status:" + this.fVj.status + " [" + this.fileName + "," + this.fVj.cKK + "," + this.fVj.alt() + "," + this.fVj.getUser() + "] ");
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(50677);
            } else if (i2 == 4 && i3 != 0) {
                C7060h.pYm.mo8378a(111, 208, 1, false);
                C4990ab.m7412e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd SERVER FAILED errtype:" + i2 + " errCode:" + i3 + " [" + this.fileName + "," + this.fVj.cKK + "," + this.fVj.alt() + "," + this.fVj.getUser() + "] ");
                C26494u.m42261um(this.fileName);
                C7060h.pYm.mo8381e(10420, Integer.valueOf(i3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(C5046bo.anU()), Integer.valueOf(C37458c.m63165bW(C4996ah.getContext())), Integer.valueOf(this.fVl), Integer.valueOf(this.frO - this.startOffset));
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(50677);
            } else if (i2 != 0 || i3 != 0) {
                C7060h.pYm.mo8378a(111, 207, 1, false);
                C4990ab.m7412e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd SERVER FAILED (SET PAUSE) errtype:" + i2 + " errCode:" + i3 + " [" + this.fileName + "," + this.fVj.cKK + "," + this.fVj.alt() + "," + this.fVj.getUser() + "] ");
                this.fVj.status = 113;
                C26494u.m42253f(this.fVj);
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(50677);
            } else if (C5046bo.m7540cb(c44192xm.ptz.getBuffer().f1226wR)) {
                C4990ab.m7412e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd Recv BUF ZERO length  [" + this.fileName + "," + this.fVj.cKK + "," + this.fVj.alt() + "," + this.fVj.getUser() + "] ");
                C26494u.m42261um(this.fileName);
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(50677);
            } else if (c44192xm.ptx != c30242xl.ptx) {
                C4990ab.m7412e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd OFFSET ERROR respStartPos:" + c44192xm.ptx + " reqStartPos:" + c30242xl.ptx + " [" + this.fileName + "," + this.fVj.cKK + "," + this.fVj.alt() + "," + this.fVj.getUser() + "] ");
                C26494u.m42261um(this.fileName);
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(50677);
            } else if (c44192xm.ptw != c30242xl.ptw) {
                C4990ab.m7412e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respTotal:" + c44192xm.ptw + " reqTotal:" + c30242xl.ptw + " [" + this.fileName + "," + this.fVj.cKK + "," + this.fVj.alt() + "," + this.fVj.getUser() + "] ");
                C26494u.m42261um(this.fileName);
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(50677);
            } else if (c30242xl.ptw < c44192xm.ptx) {
                C4990ab.m7412e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respTotal:" + c44192xm.ptw + " respStartPos:" + c30242xl.ptx + " [" + this.fileName + "," + this.fVj.cKK + "," + this.fVj.alt() + "," + this.fVj.getUser() + "] ");
                C26494u.m42261um(this.fileName);
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(50677);
            } else if (c44192xm.ptF != c30242xl.ptF) {
                C4990ab.m7412e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respMsgId:" + c44192xm.ptF + " reqMsgId:" + c30242xl.ptF + " [" + this.fileName + "," + this.fVj.cKK + "," + this.fVj.alt() + "," + this.fVj.getUser() + "] ");
                C26494u.m42261um(this.fileName);
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(50677);
            } else {
                C4990ab.m7410d("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd respBuf:" + c44192xm.ptz.getILen() + " reqStartPos:" + c30242xl.ptx + " totallen:" + c30242xl.ptw + " [" + this.fileName + "," + this.fVj.cKK + "," + this.fVj.alt() + "," + this.fVj.getUser() + "] ");
                C37961o.all();
                int a = C9720t.m17299a(C9720t.m17303uh(this.fileName), c30242xl.ptx, c44192xm.ptz.getBuffer().toByteArray());
                if (a < 0) {
                    C4990ab.m7412e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd WRITEFILE RET:" + a + " [" + this.fileName + "," + this.fVj.cKK + "," + this.fVj.alt() + "," + this.fVj.getUser() + "] ");
                    C26494u.m42261um(this.fileName);
                    this.ehi.onSceneEnd(i2, i3, str, this);
                    AppMethodBeat.m2505o(50677);
                } else if (a > this.fVj.frO) {
                    C4990ab.m7412e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd WRITEFILE newOffset:" + a + " totalLen:" + this.fVj.frO + " [" + this.fileName + "," + this.fVj.cKK + "," + this.fVj.alt() + "," + this.fVj.getUser() + "] ");
                    C26494u.m42261um(this.fileName);
                    this.ehi.onSceneEnd(i2, i3, str, this);
                    AppMethodBeat.m2505o(50677);
                } else {
                    int line;
                    String str2 = this.fileName;
                    C26493s ut = C26494u.m42268ut(str2);
                    if (ut == null) {
                        C4990ab.m7412e("MicroMsg.VideoLogic", "ERR:" + C1447g.m3075Mq() + " getinfo failed: " + str2);
                        line = 0 - C1447g.getLine();
                    } else {
                        ut.fWY = a;
                        ut.fXb = C5046bo.anT();
                        ut.bJt = 1040;
                        line = 0;
                        if (ut.frO > 0 && a >= ut.frO) {
                            C26494u.m42250e(ut);
                            ut.status = 199;
                            ut.bJt |= 256;
                            C4990ab.m7416i("MicroMsg.VideoLogic", "END!!!  updateRecv  file:" + str2 + " newsize:" + a + " total:" + ut.frO + " status:" + ut.status + " netTimes:" + ut.fXf);
                            line = 1;
                        }
                        C4990ab.m7410d("MicroMsg.VideoLogic", "updateRecv " + C1447g.m3075Mq() + " file:" + str2 + " newsize:" + a + " total:" + ut.frO + " status:" + ut.status);
                        if (!C26494u.m42253f(ut)) {
                            line = 0 - C1447g.getLine();
                        }
                    }
                    if (line < 0) {
                        C4990ab.m7412e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd updateAfterRecv Ret:" + line + " newOffset :" + a + " [" + this.fileName + "," + this.fVj.cKK + "," + this.fVj.alt() + "," + this.fVj.getUser() + "] ");
                        this.ehi.onSceneEnd(i2, i3, str, this);
                        AppMethodBeat.m2505o(50677);
                    } else if (line == 1) {
                        C7060h.pYm.mo8381e(10420, Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(C5046bo.anU()), Integer.valueOf(C37458c.m63165bW(C4996ah.getContext())), Integer.valueOf(this.fVl), Integer.valueOf(this.frO - this.startOffset));
                        C9713a.m17288a(this.fVj, 1);
                        C4990ab.m7416i("MicroMsg.NetSceneDownloadVideo", "!!!FIN [" + this.fileName + "," + this.fVj.cKK + "," + this.fVj.alt() + "," + this.fVj.getUser() + "]");
                        this.ehi.onSceneEnd(i2, i3, str, this);
                        AppMethodBeat.m2505o(50677);
                    } else if (this.fVm) {
                        this.ehi.onSceneEnd(i2, i3, str, this);
                        AppMethodBeat.m2505o(50677);
                    } else {
                        this.frk.mo16770ae(0, 0);
                        AppMethodBeat.m2505o(50677);
                    }
                }
            }
        }
    }

    public final int getType() {
        return 150;
    }

    /* Access modifiers changed, original: final */
    public final String alb() {
        AppMethodBeat.m2504i(50678);
        String str = this.fileName + "_" + hashCode();
        AppMethodBeat.m2505o(50678);
        return str;
    }
}

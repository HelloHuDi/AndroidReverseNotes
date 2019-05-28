package com.tencent.p177mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelcontrol.C42204d;
import com.tencent.p177mm.modelcontrol.VideoTransPara;
import com.tencent.p177mm.modelvideo.C45459n;
import com.tencent.p177mm.modelvideo.C45459n.C42227a;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p187al.C37458c;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p187al.C8941a;
import com.tencent.p177mm.p230g.p231a.C42055rs;
import com.tencent.p177mm.p230g.p232b.p233a.C42099d;
import com.tencent.p177mm.p230g.p232b.p233a.C9514f;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.plugin.mmsight.model.C28508d;
import com.tencent.p177mm.plugin.mmsight.model.C39390h;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.p177mm.plugin.sight.base.C21846d;
import com.tencent.p177mm.plugin.sight.base.C43528a;
import com.tencent.p177mm.plugin.sns.storage.C29098r;
import com.tencent.p177mm.protocal.protobuf.baa;
import com.tencent.p177mm.protocal.protobuf.bar;
import com.tencent.p177mm.protocal.protobuf.bax;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import java.io.ByteArrayOutputStream;

/* renamed from: com.tencent.mm.plugin.sns.model.ac */
public final class C46220ac {
    private int cNE;
    private String clientId;
    String fFa;
    int fFb;
    private C1628a fFk;
    int fWD;
    private String hxH;
    private String mPath;
    private long qKa;
    C29098r qKs;
    C34953a qKt;
    private bax qKu;
    long startTime;
    private String thumbPath;

    /* renamed from: com.tencent.mm.plugin.sns.model.ac$2 */
    class C349512 implements C28508d {
        C349512() {
        }

        public final boolean bOc() {
            AppMethodBeat.m2504i(36372);
            C4990ab.m7416i("MicroMsg.SightCdnUpload", "iUpdateVideoFile");
            C46220ac.m86436a(C46220ac.this);
            AppMethodBeat.m2505o(36372);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.ac$a */
    public interface C34953a {
        /* renamed from: kJ */
        void mo47130kJ(boolean z);
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.ac$4 */
    class C462194 implements C1628a {
        C462194() {
        }

        /* renamed from: a */
        public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
            AppMethodBeat.m2504i(36374);
            if (i == -21005) {
                C4990ab.m7411d("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", C46220ac.this.fFa, Integer.valueOf(i), c18496c, c9545d);
                C46220ac.this.qKt.mo47130kJ(true);
                AppMethodBeat.m2505o(36374);
                return 0;
            } else if (c9545d != null && c9545d.field_retCode == 0) {
                C4990ab.m7417i("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", C46220ac.this.fFa, Integer.valueOf(i), c18496c, c9545d);
                C46220ac.this.mo74236ae(c9545d.field_fileUrl, c9545d.field_thumbUrl, "upload_" + C46220ac.this.fFa);
                new C9514f(C46180a.m86311r(Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(C46220ac.this.startTime), Long.valueOf(C5046bo.anU()), Integer.valueOf(C37458c.m63165bW(C4996ah.getContext())), Integer.valueOf(C46220ac.this.fFb), Integer.valueOf(c9545d.field_fileLength), c9545d.field_transInfo, "", "", "", "", "", "", "", c9545d.efY)).ajK();
                C45459n alj = C45459n.alj();
                int i2 = C46220ac.this.fWD;
                if (c9545d != null) {
                    String str2 = c9545d.field_fileUrl;
                    String str3 = str2.hashCode();
                    C42227a c42227a = (C42227a) alj.fWm.get(str3);
                    if (c42227a == null) {
                        c42227a = new C42227a();
                    }
                    String str4 = "";
                    c42227a.dqJ = str4;
                    c42227a.toUser = str4;
                    c42227a.fWz = str4;
                    c42227a.fWD = i2;
                    c42227a.fWC = 1;
                    c42227a.cEZ = str2;
                    c42227a.fVQ = c9545d;
                    c42227a.startTime = C5046bo.anU();
                    alj.fWm.put(str3, c42227a);
                    C4990ab.m7417i("MicroMsg.SubCoreMediaRpt", "note sns video sendScene %d snsKey[%s] url[%s]", Integer.valueOf(i2), str3, str2);
                }
                C46220ac.this.qKt.mo47130kJ(true);
                AppMethodBeat.m2505o(36374);
                return 0;
            } else if (c9545d != null && c9545d.field_retCode != 0) {
                C4990ab.m7417i("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", C46220ac.this.fFa, Integer.valueOf(i), c18496c, c9545d);
                C46220ac.this.mo74234CQ(0);
                String r = C46180a.m86311r(Integer.valueOf(c9545d.field_retCode), Integer.valueOf(1), Long.valueOf(C46220ac.this.startTime), Long.valueOf(C5046bo.anU()), Integer.valueOf(C37458c.m63165bW(C4996ah.getContext())), Integer.valueOf(C46220ac.this.fFb), Integer.valueOf(c9545d.field_fileLength), c9545d.field_transInfo, "", "", "", "", "", "", "", c9545d.efY);
                new C9514f(r).ajK();
                new C42099d(r).ajK();
                C46220ac.this.qKt.mo47130kJ(false);
                AppMethodBeat.m2505o(36374);
                return 0;
            } else if (i != 0) {
                C4990ab.m7417i("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", C46220ac.this.fFa, Integer.valueOf(i), c18496c, c9545d);
                C46220ac.this.mo74234CQ(0);
                if (c9545d != null) {
                    new C9514f(C46180a.m86311r(Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(C46220ac.this.startTime), Long.valueOf(C5046bo.anU()), Integer.valueOf(C37458c.m63165bW(C4996ah.getContext())), Integer.valueOf(C46220ac.this.fFb), Integer.valueOf(c9545d.field_fileLength), c9545d.field_transInfo, "", "", "", "", "", "", "", c9545d.efY)).ajK();
                }
                C46220ac.this.qKt.mo47130kJ(false);
                AppMethodBeat.m2505o(36374);
                return 0;
            } else {
                C4990ab.m7411d("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", C46220ac.this.fFa, Integer.valueOf(i), c18496c, c9545d);
                AppMethodBeat.m2505o(36374);
                return 0;
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

    public C46220ac(int i, C29098r c29098r, String str, String str2, C34953a c34953a) {
        AppMethodBeat.m2504i(36375);
        this.clientId = "";
        this.qKa = 0;
        this.startTime = 0;
        this.fFb = 0;
        this.hxH = "";
        this.qKu = new bax();
        this.fFk = new C462194();
        this.qKa = System.currentTimeMillis();
        this.mPath = str;
        this.thumbPath = str2;
        this.qKt = c34953a;
        this.cNE = i;
        this.qKs = c29098r;
        try {
            this.qKu = (bax) new bax().parseFrom(c29098r.rfI);
            this.clientId = this.qKu.wFE;
            this.hxH = this.qKu.cvZ;
            if (C5046bo.isNullOrNil(this.clientId)) {
                this.clientId = C1178g.m2591x((C5046bo.m7588yz()).getBytes());
                this.qKu.wFE = this.clientId;
                try {
                    c29098r.rfI = this.qKu.toByteArray();
                    C13373af.cnu().mo25631a(c29098r.reX, c29098r);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.SightCdnUpload", e, "", new Object[0]);
                }
            }
            int asZ = (int) C5730e.asZ(str);
            C4990ab.m7417i("MicroMsg.SightCdnUpload", "sightupload %d videopath %s sightFileSize %d md5 %s", Integer.valueOf(i), str, Integer.valueOf(asZ), this.hxH);
            AppMethodBeat.m2505o(36375);
        } catch (Exception e2) {
            C4990ab.m7412e("MicroMsg.SightCdnUpload", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
            AppMethodBeat.m2505o(36375);
        }
    }

    public final boolean cne() {
        AppMethodBeat.m2504i(36376);
        String cz = C1178g.m2587cz(this.mPath);
        if (C5046bo.isNullOrNil(this.hxH) || this.hxH.equals(cz)) {
            baa baa;
            if (this.qKu.wFH != null) {
                baa = this.qKu.wFH;
            } else {
                baa = new baa();
            }
            C4990ab.m7417i("MicroMsg.SightCdnUpload", "check upload %s %d %s", this.mPath, Integer.valueOf(baa.wDQ), Boolean.valueOf(baa.wDP));
            C43528a WR = C21846d.m33388WR(this.mPath);
            if (WR != null) {
                C4990ab.m7417i("MicroMsg.SightCdnUpload", "mediaInfo: %s", WR);
                long j = (C5046bo.isNullOrNil(baa.csB) || !baa.csB.contains("wx5dfbe0a95623607b")) ? baa.wDP ? (long) C42204d.afF().afH().duration : (long) C42204d.afF().afI().duration : (long) C26373g.m41964Nu().getInt("WeiShiShareSnsSightTimeLength", 10);
                if (j <= 0) {
                    j = 10;
                }
                C4990ab.m7417i("MicroMsg.SightCdnUpload", "maxVideoLen: %s", Long.valueOf((j * 1000) + 3000));
                if (((long) WR.eWK) >= (j * 1000) + 3000) {
                    C4990ab.m7417i("MicroMsg.SightCdnUpload", "checkUpload isNotSafeSightVideo videoDuration: %s ", Integer.valueOf(WR.eWK));
                    mo74234CQ(-2);
                    this.qKt.mo47130kJ(false);
                    AppMethodBeat.m2505o(36376);
                    return false;
                }
            }
            if (baa.wDP) {
                int i = C39390h.ouu;
                if (baa.wDQ >= 3) {
                    onError();
                    AppMethodBeat.m2505o(36376);
                    return false;
                }
                C4990ab.m7417i("MicroMsg.SightCdnUpload", "try need remux %d %s", Integer.valueOf(i), this.mPath);
                final C4883b c42055rs = new C42055rs();
                c42055rs.callback = new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(36371);
                        C4990ab.m7417i("MicroMsg.SightCdnUpload", "event callback errcode %d", Integer.valueOf(c42055rs.cNI.result));
                        if (c42055rs.cNI.result >= 0) {
                            C46220ac.m86436a(C46220ac.this);
                            C46220ac.this.mo74235a(baa);
                            AppMethodBeat.m2505o(36371);
                            return;
                        }
                        C46220ac.this.onError();
                        AppMethodBeat.m2505o(36371);
                    }
                };
                c42055rs.cNH.cNL = new C349512();
                c42055rs.cNH.cNp = this.mPath;
                c42055rs.cNH.scene = i;
                c42055rs.cNH.cNJ = baa;
                c42055rs.cNH.cNK = new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(36373);
                        baa.wDQ++;
                        try {
                            C4990ab.m7417i("MicroMsg.SightCdnUpload", "add try count %d", Integer.valueOf(baa.wDQ));
                            bax bax = (bax) new bax().parseFrom(C46220ac.this.qKs.rfI);
                            bax.wFH = baa;
                            C46220ac.this.qKs.rfI = bax.toByteArray();
                            C13373af.cnu().mo25631a(C46220ac.this.qKs.reX, C46220ac.this.qKs);
                            AppMethodBeat.m2505o(36373);
                        } catch (Exception e) {
                            C4990ab.m7413e("MicroMsg.SightCdnUpload", "parseFrom MediaUploadInfo error in checkUploadaddCount %s", e.getMessage());
                            AppMethodBeat.m2505o(36373);
                        }
                    }
                };
                C4879a.xxA.mo10049a(c42055rs, C13373af.cns());
                AppMethodBeat.m2505o(36376);
                return true;
            }
            mo74235a(baa);
            AppMethodBeat.m2505o(36376);
            return true;
        }
        C4990ab.m7417i("MicroMsg.SightCdnUpload", "checkUpload isNotSafeSightVideo old srcmd5 %s newmd5 %s ", this.hxH, cz);
        mo74234CQ(-2);
        this.qKt.mo47130kJ(false);
        AppMethodBeat.m2505o(36376);
        return false;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final boolean mo74235a(baa baa) {
        AppMethodBeat.m2504i(36377);
        if (this.startTime == 0) {
            this.startTime = C5046bo.anU();
            this.fFb = C42129a.efI;
        }
        String str = this.clientId;
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.SightCdnUpload", "cdntra genClientId failed not use cdn");
            AppMethodBeat.m2505o(36377);
            return false;
        }
        C42130g c42130g = new C42130g();
        c42130g.egl = this.fFk;
        c42130g.field_mediaId = str;
        c42130g.field_fullpath = this.mPath;
        c42130g.field_thumbpath = this.thumbPath;
        c42130g.field_fileType = C42129a.efI;
        c42130g.field_talker = "";
        c42130g.field_priority = C42129a.efC;
        c42130g.field_needStorage = true;
        c42130g.field_isStreamMedia = false;
        c42130g.field_appType = 102;
        c42130g.field_bzScene = 1;
        if (C5046bo.isNullOrNil(baa.csB) || !baa.csB.contains("wx5dfbe0a95623607b")) {
            VideoTransPara afH;
            C42204d.afF();
            if (baa.wDP) {
                afH = C42204d.afF().afH();
            } else {
                afH = C42204d.afF().afI();
            }
            c42130g.field_largesvideo = C42204d.m74448a(afH);
        } else {
            c42130g.field_largesvideo = C26373g.m41964Nu().getInt("WeiShiShareSnsSightTimeLength", 10);
        }
        String cz = C1178g.m2587cz(this.mPath);
        if (!C5046bo.isNullOrNil(this.hxH) && !this.hxH.equals(cz)) {
            C4990ab.m7417i("MicroMsg.SightCdnUpload", "isNotSafeSightVideo old srcmd5 %s newmd5 %s ", this.hxH, cz);
            mo74234CQ(-2);
            this.qKt.mo47130kJ(false);
            AppMethodBeat.m2505o(36377);
            return false;
        } else if (C37461f.afx().mo51225e(c42130g)) {
            int i = (baa == null || !baa.wDP) ? 5 : 4;
            this.fWD = i;
            AppMethodBeat.m2505o(36377);
            return true;
        } else {
            C4990ab.m7413e("MicroMsg.SightCdnUpload", "cdntra addSendTask failed. clientid:%s", str);
            AppMethodBeat.m2505o(36377);
            return false;
        }
    }

    /* renamed from: ae */
    public final boolean mo74236ae(String str, String str2, String str3) {
        bax bax;
        AppMethodBeat.m2504i(36378);
        C29098r kE = C13373af.cnu().mo25635kE((long) this.cNE);
        C4990ab.m7410d("MicroMsg.SightCdnUpload", "upload ok " + str + "  " + str3 + "  1");
        kE.rfH = str3;
        try {
            bax = (bax) new bax().parseFrom(kE.rfI);
        } catch (Exception e) {
            bax = null;
        }
        if (bax == null) {
            bax = new bax();
        }
        bar bar = new bar();
        bar.jCt = 1;
        bar.Url = str;
        bax.wFA = bar;
        bax.wFD = 0;
        C37461f.afy();
        bax.wFc = C8941a.m16130rJ(this.mPath);
        C4990ab.m7417i("MicroMsg.SightCdnUpload", "onPostScene videomd5 %s", bax.wFc);
        if (!C5046bo.isNullOrNil(str2)) {
            bar = new bar();
            bar.jCt = 1;
            bar.Url = str2;
            bax.wFC.add(bar);
        }
        try {
            kE.rfI = bax.toByteArray();
        } catch (Exception e2) {
            C4990ab.printErrStackTrace("MicroMsg.SightCdnUpload", e2, "", new Object[0]);
        }
        kE.crq();
        C13373af.cnu().mo25631a(this.cNE, kE);
        C13373af.cnE().mo37396CV(this.cNE);
        if (C13373af.cnB() != null) {
            C13373af.cnB().cmp();
        }
        AppMethodBeat.m2505o(36378);
        return true;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: CQ */
    public final void mo74234CQ(int i) {
        AppMethodBeat.m2504i(36379);
        C4990ab.m7416i("MicroMsg.SightCdnUpload", "snsupload sight by cdn error!");
        C29098r kE = C13373af.cnu().mo25635kE((long) this.cNE);
        try {
            bax bax = (bax) new bax().parseFrom(kE.rfI);
            bax.wFD = 1;
            bax.wFm = i;
            if (this.qKu.wFH != null) {
                this.qKu.wFH.wDQ = 0;
            }
            kE.rfI = bax.toByteArray();
        } catch (Exception e) {
        }
        C13373af.cnE().mo37396CV(this.cNE);
        C13373af.cnu().mo25631a(this.cNE, kE);
        AppMethodBeat.m2505o(36379);
    }

    /* Access modifiers changed, original: final */
    public final void onError() {
        AppMethodBeat.m2504i(36380);
        C4990ab.m7416i("MicroMsg.SightCdnUpload", "snsupload sight by cdn error!");
        C29098r kE = C13373af.cnu().mo25635kE((long) this.cNE);
        kE.offset = 0;
        try {
            bax bax = (bax) new bax().parseFrom(kE.rfI);
            bax.wFE = "";
            if (bax.wFH != null) {
                bax.wFH.wDQ = 0;
            }
            kE.rfI = bax.toByteArray();
            C13373af.cnu().mo25631a(this.cNE, kE);
            C13373af.cnE().mo37396CV(this.cNE);
            AppMethodBeat.m2505o(36380);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.SightCdnUpload", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
            AppMethodBeat.m2505o(36380);
        }
    }
}

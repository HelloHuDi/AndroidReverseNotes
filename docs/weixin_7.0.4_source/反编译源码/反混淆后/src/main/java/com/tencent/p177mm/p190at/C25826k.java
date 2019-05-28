package com.tencent.p177mm.p190at;

import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.modelstat.C42220h;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C32231g;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p187al.C37458c;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p230g.p232b.p233a.C42099d;
import com.tencent.p177mm.p230g.p232b.p233a.C9514f;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.plugin.emoji.p725b.C27730c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h.C3460c;
import com.tencent.p177mm.plugin.p1614i.C46031b;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.akx;
import com.tencent.p177mm.protocal.protobuf.aky;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import com.tencent.p177mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.util.ActUtil;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.at.k */
public final class C25826k extends C1207m implements C1918k {
    String TAG;
    C7620bi csG;
    private long cvx;
    long eFm;
    private final C7472b ehh;
    C1202f ehi;
    private int fDC;
    final C32231g fEW;
    public final long fEX;
    private int fEY;
    private C42220h fEZ;
    String fFa;
    int fFb;
    private String fFc;
    public String fFd;
    int fFe;
    public boolean fFf;
    private int fFg;
    private String fFh;
    private int fFi;
    boolean fFj;
    private C1628a fFk;
    int frO;
    private int startOffset;
    long startTime;
    private int token;

    /* renamed from: com.tencent.mm.at.k$2 */
    class C258252 implements C1628a {
        C258252() {
        }

        /* renamed from: a */
        public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
            AppMethodBeat.m2504i(78311);
            Object[] objArr;
            String r;
            if (i == -21006) {
                C4990ab.m7417i(C25826k.this.TAG, "cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", C25826k.this.fFa);
                AppMethodBeat.m2505o(78311);
                return 0;
            } else if (i != 0) {
                C45161i.m83149lC((int) C25826k.this.fEX);
                C45161i.m83148lB((int) C25826k.this.fEX);
                objArr = new Object[16];
                objArr[0] = Integer.valueOf(i);
                objArr[1] = Integer.valueOf(2);
                objArr[2] = Long.valueOf(C25826k.this.startTime);
                objArr[3] = Long.valueOf(C5046bo.anU());
                objArr[4] = Integer.valueOf(C37458c.m63165bW(C4996ah.getContext()));
                objArr[5] = Integer.valueOf(C25826k.this.fFb);
                objArr[6] = Integer.valueOf(C25826k.this.frO);
                objArr[7] = c9545d == null ? "" : c9545d.field_transInfo;
                objArr[8] = "";
                objArr[9] = "";
                objArr[10] = "";
                objArr[11] = "";
                objArr[12] = "";
                objArr[13] = "";
                objArr[14] = "";
                objArr[15] = c9545d == null ? "" : c9545d.efY;
                r = C46180a.m86311r(objArr);
                new C9514f(r).ajK();
                new C42099d(r).ajK();
                C25826k.this.ehi.onSceneEnd(3, i, "", C25826k.this);
                AppMethodBeat.m2505o(78311);
                return 0;
            } else {
                C25822e b = C32291o.ahl().mo73105b(Long.valueOf(C25826k.this.eFm));
                if (c18496c == null) {
                    if (c9545d != null) {
                        if (c9545d.field_retCode != 0) {
                            C45161i.m83148lB((int) C25826k.this.fEX);
                            C4990ab.m7413e(C25826k.this.TAG, "cdntra sceneResult.retCode :%d", Integer.valueOf(c9545d.field_retCode));
                            C25826k.this.ehi.onSceneEnd(3, c9545d.field_retCode, "", C25826k.this);
                        } else {
                            C4990ab.m7417i(C25826k.this.TAG, "cdntra getimg ok. need convert:%b", Boolean.valueOf(c9545d.field_convert2baseline));
                            C7060h c7060h;
                            if (b.fDC == 1) {
                                C7060h.pYm.mo8378a(198, 26, (long) b.frO, false);
                                C7060h.pYm.mo8378a(198, 27, 1, false);
                                c7060h = C7060h.pYm;
                                if (C25826k.this.csG != null) {
                                    r = C25826k.this.csG.field_talker;
                                } else {
                                    r = "";
                                }
                                c7060h.mo8378a(198, C1855t.m3896kH(r) ? 29 : 28, 1, false);
                            } else {
                                long j;
                                C7060h.pYm.mo8378a(198, 21, (long) b.frO, false);
                                C7060h.pYm.mo8378a(198, 22, 1, false);
                                c7060h = C7060h.pYm;
                                if (C25826k.this.csG != null) {
                                    r = C25826k.this.csG.field_talker;
                                } else {
                                    r = "";
                                }
                                if (C1855t.m3896kH(r)) {
                                    j = 24;
                                } else {
                                    j = 23;
                                }
                                c7060h.mo8378a(198, j, 1, false);
                            }
                            if (c9545d.field_convert2baseline) {
                                C4990ab.m7417i(C25826k.this.TAG, "cdntra need convert2baseline. file:%s", C25826k.this.fFd);
                                boolean Convert2Baseline = MMNativeJpeg.Convert2Baseline(C25826k.this.fFd, 60);
                                C4990ab.m7417i(C25826k.this.TAG, "convert result:%b", Boolean.valueOf(Convert2Baseline));
                            }
                            if (C25826k.this.fFj) {
                                C25826k.m41127a(C25826k.this, b, b.offset, b.offset, 0);
                            } else {
                                C25826k.m41127a(C25826k.this, b, C25826k.this.frO, b.offset, C25826k.this.frO - b.offset);
                            }
                        }
                        objArr = new Object[16];
                        objArr[0] = Integer.valueOf(c9545d.field_retCode);
                        objArr[1] = Integer.valueOf(2);
                        objArr[2] = Long.valueOf(C25826k.this.startTime);
                        objArr[3] = Long.valueOf(C5046bo.anU());
                        objArr[4] = Integer.valueOf(C37458c.m63165bW(C4996ah.getContext()));
                        objArr[5] = Integer.valueOf(C25826k.this.fFb);
                        objArr[6] = Integer.valueOf(C25826k.this.frO);
                        objArr[7] = c9545d == null ? "" : c9545d.field_transInfo;
                        objArr[8] = "";
                        objArr[9] = "";
                        objArr[10] = "";
                        objArr[11] = "";
                        objArr[12] = "";
                        objArr[13] = "";
                        objArr[14] = "";
                        objArr[15] = c9545d == null ? "" : c9545d.efY;
                        new C9514f(C46180a.m86311r(objArr)).ajK();
                        if (c9545d.field_retCode != 0) {
                            objArr = new Object[16];
                            objArr[0] = Integer.valueOf(c9545d.field_retCode);
                            objArr[1] = Integer.valueOf(2);
                            objArr[2] = Long.valueOf(C25826k.this.startTime);
                            objArr[3] = Long.valueOf(C5046bo.anU());
                            objArr[4] = Integer.valueOf(C37458c.m63165bW(C4996ah.getContext()));
                            objArr[5] = Integer.valueOf(C25826k.this.fFb);
                            objArr[6] = Integer.valueOf(C25826k.this.frO);
                            objArr[7] = c9545d == null ? "" : c9545d.field_transInfo;
                            objArr[8] = "";
                            objArr[9] = "";
                            objArr[10] = "";
                            objArr[11] = "";
                            objArr[12] = "";
                            objArr[13] = "";
                            objArr[14] = "";
                            objArr[15] = c9545d == null ? "" : c9545d.efY;
                            new C42099d(C46180a.m86311r(objArr)).ajK();
                        }
                    }
                    AppMethodBeat.m2505o(78311);
                    return 0;
                } else if (c18496c.field_finishedLength == C25826k.this.frO) {
                    C4990ab.m7410d(C25826k.this.TAG, "cdntra ignore progress 100%");
                    AppMethodBeat.m2505o(78311);
                    return 0;
                } else {
                    C25826k.this.fFj = true;
                    if (!C25826k.this.fFf) {
                        C25826k.this.fFf = c18496c.field_mtlnotify;
                    }
                    C4990ab.m7417i(C25826k.this.TAG, "cdntra progresscallback id:%s finish:%d total:%d,  canshowProgressimg:%b", C25826k.this.fFa, Integer.valueOf(c18496c.field_finishedLength), Integer.valueOf(c18496c.field_toltalLength), Boolean.valueOf(C25826k.this.fFf));
                    C25826k.m41127a(C25826k.this, b, C25826k.this.frO, b.offset, c18496c.field_finishedLength - b.offset);
                    AppMethodBeat.m2505o(78311);
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

    public C25826k(long j, long j2, int i, C32231g c32231g) {
        this(j, j2, i, c32231g, -1);
    }

    public C25826k(long j, long j2, int i, final C32231g c32231g, int i2) {
        C25822e b;
        AppMethodBeat.m2504i(78313);
        this.TAG = "MicroMsg.NetSceneGetMsgImg";
        this.fEZ = null;
        this.cvx = -1;
        this.csG = null;
        this.fFa = "";
        this.startTime = 0;
        this.startOffset = -1;
        this.fFb = 0;
        this.fFc = "";
        this.fFd = "";
        this.frO = 0;
        this.fFe = -1;
        this.fFf = false;
        this.fFg = -1;
        this.fFh = null;
        this.fFi = 0;
        this.token = -1;
        this.fFj = false;
        this.fFk = new C258252();
        boolean z = j >= 0 && j2 >= 0 && c32231g != null;
        Assert.assertTrue(z);
        this.fEW = c32231g;
        this.fDC = i;
        this.fEX = j;
        this.eFm = j;
        this.cvx = j2;
        this.fFg = i2;
        C25822e b2 = C32291o.ahl().mo73105b(Long.valueOf(this.eFm));
        if (i == 1) {
            this.eFm = (long) b2.fDJ;
            b = C32291o.ahl().mo73105b(Long.valueOf(this.eFm));
        } else {
            b = b2;
        }
        this.TAG += "[" + this.eFm + "]";
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new akx();
        c1196a.fsK = new aky();
        c1196a.uri = "/cgi-bin/micromsg-bin/getmsgimg";
        c1196a.fsI = 109;
        c1196a.fsL = 10;
        c1196a.fsM = 1000000010;
        this.ehh = c1196a.acD();
        akx akx = (akx) this.ehh.fsG.fsP;
        this.csG = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(j2);
        akx.ptx = b.offset;
        akx.ptw = b.frO;
        C4990ab.m7411d(this.TAG, "cdntra offset:%d total:%d stack:[%s]", Integer.valueOf(b.offset), Integer.valueOf(b.frO), C5046bo.dpG());
        akx.ptF = this.csG.field_msgSvrId;
        akx.vEB = new bts().alV(this.csG.field_talker);
        akx.vEC = new bts().alV((String) C1720g.m3536RP().mo5239Ry().get(2, null));
        akx.wqw = i;
        if (b.offset == 0) {
            this.fEZ = new C42220h(109, false, (long) b.frO);
        }
        this.fEY = Utility.DEFAULT_STREAM_BUFFER_SIZE;
        if (c32231g != null) {
            final int i3 = b.offset;
            final int i4 = b.frO;
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(78310);
                    c32231g.mo8280a(i3, i4, C25826k.this);
                    AppMethodBeat.m2505o(78310);
                }
            });
        }
        AppMethodBeat.m2505o(78313);
    }

    public final int acn() {
        if (this.fDC == 0) {
            return 100;
        }
        return ActUtil.HEIGHT;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
    }

    public final void cancel() {
        AppMethodBeat.m2504i(78314);
        if (!(C5046bo.isNullOrNil(this.fFa) || C37461f.afx() == null)) {
            C4990ab.m7410d(this.TAG, "cancel recv task");
            C37461f.afx().mo51228rO(this.fFa);
        }
        super.cancel();
        AppMethodBeat.m2505o(78314);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(78315);
        this.ehi = c1202f;
        akx akx = (akx) this.ehh.fsG.fsP;
        C25822e b = C32291o.ahl().mo73105b(Long.valueOf(this.eFm));
        if (b.fDy == 0) {
            C7060h.pYm.mo8378a(111, 195, 1, false);
            C4990ab.m7413e(this.TAG, "doScene id:%d  img:%s", Long.valueOf(this.eFm), b);
            AppMethodBeat.m2505o(78315);
            return -1;
        } else if (b.status != 0) {
            C7060h.pYm.mo8378a(111, 194, 1, false);
            C4990ab.m7413e(this.TAG, "doSceneError, id:%d, status:%d", Long.valueOf(b.fDy), Integer.valueOf(b.status));
            AppMethodBeat.m2505o(78315);
            return -1;
        } else {
            String str;
            int i;
            Object obj;
            if (b.fDz.startsWith("SERVERID://")) {
                this.fFc = C1178g.m2591x(b.fDz.getBytes());
                this.fFd = C32291o.ahl().mo73118q(this.fFc, null, ".temp");
                b.mo43803sb(this.fFc + ".temp");
                C32291o.ahl().mo73077a(Long.valueOf(this.eFm), b);
            } else {
                this.fFc = b.fDz;
                this.fFd = C32291o.ahl().mo73118q(this.fFc, null, "");
            }
            C4990ab.m7417i(this.TAG, "doscene id:%d comp:%d off:%d total:%d name:%s tmp:%s full:%s", Long.valueOf(b.fDy), Integer.valueOf(this.fDC), Integer.valueOf(b.offset), Integer.valueOf(b.frO), str, this.fFc, this.fFd);
            if (this.startTime == 0) {
                this.startTime = C5046bo.anU();
                this.startOffset = b.offset;
                if (this.fDC == 1) {
                    i = C42129a.MediaType_FULLSIZEIMAGE;
                } else {
                    i = C42129a.MediaType_IMAGE;
                }
                this.fFb = i;
            }
            if (C5046bo.isNullOrNil(b.fDK)) {
                obj = null;
            } else {
                Map z = C5049br.m7595z(b.fDK, "msg");
                if (z == null) {
                    C4990ab.m7413e(this.TAG, "parse cdnInfo failed. [%s]", b.fDK);
                    obj = null;
                } else {
                    String str2;
                    String str3;
                    this.frO = 0;
                    if (this.fDC != 1) {
                        str = (String) z.get(".msg.img.$cdnmidimgurl");
                        this.frO = C5046bo.getInt((String) z.get(".msg.img.$length"), 0);
                        str2 = str;
                    } else {
                        str = (String) z.get(".msg.img.$cdnbigimgurl");
                        this.frO = C5046bo.getInt((String) z.get(".msg.img.$hdlength"), 0);
                        str2 = str;
                    }
                    if (this.fDC != 1) {
                        str = (String) z.get(".msg.img.$tpurl");
                        if (!C5046bo.isNullOrNil(str)) {
                            this.frO = C5046bo.getInt((String) z.get(".msg.img.$tplength"), 0);
                            str3 = str;
                        }
                        str3 = str;
                    } else {
                        str = (String) z.get(".msg.img.$tphdurl");
                        if (!C5046bo.isNullOrNil(str)) {
                            this.frO = C5046bo.getInt((String) z.get(".msg.img.$tphdlength"), 0);
                        }
                        str3 = str;
                    }
                    C4990ab.m7411d(this.TAG, "cdntra read xml  comptype:%d totallen:%d url:[%s] [%s]", Integer.valueOf(this.fDC), Integer.valueOf(this.frO), str2, str3);
                    if (C5046bo.isNullOrNil(str2) && C5046bo.isNullOrNil(str3)) {
                        C4990ab.m7412e(this.TAG, "cdntra get cdnUrlfailed.");
                        obj = null;
                    } else {
                        str = (String) z.get(".msg.img.$aeskey");
                        if (C5046bo.isNullOrNil(str)) {
                            C4990ab.m7412e(this.TAG, "cdntra get aes key failed.");
                            obj = null;
                        } else {
                            this.fFa = C37458c.m63162a("downimg", (long) b.fDG, this.csG.field_talker, this.csG.field_msgId);
                            if (C5046bo.isNullOrNil(this.fFa)) {
                                C4990ab.m7421w(this.TAG, "cdntra genClientId failed not use cdn imgLocalId:%d", Long.valueOf(this.eFm));
                                obj = null;
                            } else {
                                String str4 = (String) z.get(".msg.img.$md5");
                                if (C5046bo.isNullOrNil(str3) && !C5046bo.isNullOrNil(str4) && (C5046bo.isNullOrNil((String) z.get(".msg.img.$cdnbigimgurl")) || this.fDC == 1)) {
                                    C46031b.bGD();
                                    String es = C46031b.m85613XT().mo16778es(str4, this.frO);
                                    int asZ = (int) C5730e.asZ(es);
                                    int i2 = this.frO - asZ;
                                    String str5 = this.TAG;
                                    String str6 = "MediaCheckDuplicationStorage: totallen:%s md5:%s big:%s NOcompress:%s  dup(len:%d path:%s) diffLen:%d to:%s";
                                    Object[] objArr = new Object[8];
                                    objArr[0] = Integer.valueOf(this.frO);
                                    objArr[1] = str4;
                                    objArr[2] = z.get(".msg.img.$cdnbigimgurl");
                                    objArr[3] = Boolean.valueOf(this.fDC == 1);
                                    objArr[4] = Integer.valueOf(asZ);
                                    objArr[5] = es;
                                    objArr[6] = Integer.valueOf(i2);
                                    objArr[7] = this.fFd;
                                    C4990ab.m7417i(str5, str6, objArr);
                                    if (C5046bo.isNullOrNil(es)) {
                                        this.fFh = str4;
                                        this.fFi = this.frO;
                                    } else if (i2 >= 0 && i2 <= 16) {
                                        boolean z2 = false;
                                        if (!C5046bo.isEqual(es, this.fFd)) {
                                            z2 = C5730e.m8644y(es, this.fFd) >= 0;
                                        }
                                        C4990ab.m7417i(this.TAG, "MediaCheckDuplicationStorage copy dup file now :%s -> %s [%b]", es, this.fFd, Boolean.valueOf(z2));
                                        m41126a(b, this.frO, this.frO, 0, null);
                                        if (this.csG != null) {
                                            ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15289a(new C3460c(this.csG.field_talker, "update", this.csG));
                                        }
                                        C7060h.pYm.mo8381e(13267, str2, Long.valueOf(this.csG.field_msgSvrId), str4, Long.valueOf(this.csG.field_createTime / 1000), this.csG.field_talker, Integer.valueOf(3), Integer.valueOf(asZ));
                                        obj = 1;
                                    }
                                }
                                C42130g c42130g = new C42130g();
                                c42130g.field_mediaId = this.fFa;
                                c42130g.field_fullpath = this.fFd;
                                c42130g.field_fileType = this.fFb;
                                c42130g.field_totalLen = this.frO;
                                c42130g.field_aesKey = str;
                                c42130g.field_fileId = str2;
                                c42130g.field_priority = C42129a.efC;
                                c42130g.egl = this.fFk;
                                c42130g.field_chattype = C1855t.m3896kH(this.csG.field_talker) ? 1 : 0;
                                c42130g.expectImageFormat = ((C27730c) C1720g.m3528K(C27730c.class)).bja() ? 2 : 1;
                                if (!C5046bo.isNullOrNil(str3)) {
                                    str = (String) z.get(".msg.img.$tpauthkey");
                                    c42130g.field_fileType = 19;
                                    c42130g.field_authKey = str;
                                    c42130g.egm = str3;
                                    c42130g.field_fileId = "";
                                }
                                C4990ab.m7417i(this.TAG, "cdnautostart %s %b", "image_" + this.csG.field_msgId, Boolean.valueOf(C37461f.afx().fyQ.contains("image_" + this.csG.field_msgId)));
                                if (C37461f.afx().fyQ.contains("image_" + this.csG.field_msgId)) {
                                    C37461f.afx().fyQ.remove("image_" + this.csG.field_msgId);
                                    c42130g.field_autostart = true;
                                } else {
                                    c42130g.field_autostart = false;
                                }
                                if (C37461f.afx().mo51222b(c42130g, this.fFg)) {
                                    C4990ab.m7416i(this.TAG, "add recv task");
                                    obj = 1;
                                } else {
                                    C7060h.pYm.mo8378a(111, 196, 1, false);
                                    C4990ab.m7413e(this.TAG, "addRecvTask failed :%s", this.fFa);
                                    this.fFa = "";
                                    obj = null;
                                }
                            }
                        }
                    }
                }
            }
            if (obj != null) {
                C4990ab.m7411d(this.TAG, "cdntra this img use cdn : %s", this.fFa);
                AppMethodBeat.m2505o(78315);
                return 0;
            }
            C4990ab.m7411d(this.TAG, "cdntra this img NOT USE CDN: %s", this.fFa);
            b.mo43806se("");
            b.bJt = 4096;
            C32291o.ahl().mo73077a(Long.valueOf(this.eFm), b);
            akx.ptx = b.offset;
            akx.pty = this.fEY;
            akx.ptw = b.frO;
            if (this.fEZ != null) {
                this.fEZ.akj();
            }
            i = mo4457a(c1902e, this.ehh, this);
            AppMethodBeat.m2505o(78315);
            return i;
        }
    }

    public final int getType() {
        return 109;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(78316);
        if (i2 == 3 && i3 == -1 && !C5046bo.isNullOrNil(this.fFa)) {
            C4990ab.m7421w(this.TAG, "cdntra using cdn trans,  wait cdn service callback! clientid:%s", this.fFa);
            AppMethodBeat.m2505o(78316);
        } else if (i2 == 0 && i3 == 0) {
            aky aky = (aky) ((C7472b) c1929q).fsH.fsP;
            C25822e b = C32291o.ahl().mo73105b(Long.valueOf(this.eFm));
            Object obj = null;
            if (aky.pty <= 0) {
                C4990ab.m7412e(this.TAG, "flood control, malformed data_len");
                obj = -1;
            } else if (aky.ptz == null || aky.pty != aky.ptz.getILen()) {
                C4990ab.m7412e(this.TAG, "flood control, malformed data is null or dataLen not match with data buf length");
                obj = -1;
            } else if (aky.ptx < 0 || aky.ptx + aky.pty > aky.ptw) {
                C4990ab.m7412e(this.TAG, "flood control, malformed start pos");
                obj = -1;
            } else if (aky.ptx != b.offset) {
                C4990ab.m7412e(this.TAG, "flood control, malformed start_pos");
                obj = -1;
            } else if (aky.ptw <= 0) {
                C4990ab.m7412e(this.TAG, "flood control, malformed total_len");
                obj = -1;
            }
            if (obj != null) {
                C7060h.pYm.mo8378a(111, 192, 1, false);
                C7060h.pYm.mo8381e(10420, Integer.valueOf(-1), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(C5046bo.anU()), Integer.valueOf(C37458c.m63165bW(C4996ah.getContext())), Integer.valueOf(this.fFb), Integer.valueOf(this.frO - this.startOffset));
                this.ehi.onSceneEnd(4, -1, "", this);
                AppMethodBeat.m2505o(78316);
                return;
            }
            if (m41126a(b, aky.ptw, aky.ptx, aky.pty, aky.ptz.getBuffer().f1226wR) && mo4456a(this.ftf, this.ehi) < 0) {
                this.ehi.onSceneEnd(3, -1, "", this);
            }
            AppMethodBeat.m2505o(78316);
        } else {
            if (i2 == 4) {
                C7060h.pYm.mo8378a(111, 193, 1, false);
                C7060h.pYm.mo8381e(10420, Integer.valueOf(i3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(C5046bo.anU()), Integer.valueOf(C37458c.m63165bW(C4996ah.getContext())), Integer.valueOf(this.fFb), Integer.valueOf(this.frO - this.startOffset));
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(78316);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0149  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private boolean m41126a(final C25822e c25822e, int i, int i2, int i3, byte[] bArr) {
        String str;
        AppMethodBeat.m2504i(78317);
        c25822e.mo43797lt(i);
        c25822e.setOffset(i2 + i3);
        this.fEY = i3;
        if (bArr != null) {
            C5730e.m8619a(this.fFd, bArr, bArr.length);
        }
        C4990ab.m7411d(this.TAG, "onGYNetEnd : offset = " + c25822e.offset + " totalLen = " + c25822e.frO + " stack:[%s]", C5046bo.dpG());
        if (c25822e.agP()) {
            boolean z;
            String amq = C5063r.amq(this.fFd);
            boolean amn = C5063r.amn(this.fFd);
            String str2 = this.fFd + "_hevc";
            C5728b c5728b = new C5728b(this.fFd);
            boolean amp = C5063r.amp(this.fFd);
            if (amp) {
                c5728b.mo11675o(new C5728b(str2));
                if (((C27730c) C1720g.m3528K(C27730c.class)).nativeWxam2Pic(str2, this.fFd) != 0) {
                    C4990ab.m7420w(this.TAG, "download hevc decode failed");
                    z = false;
                } else {
                    amq = C5063r.amq(this.fFd);
                    z = amn;
                }
                C4990ab.m7411d(this.TAG, "hevc download is hevc %b", Boolean.TRUE);
            } else {
                z = amn;
            }
            if (z) {
                String str3 = this.fFc + amq;
                String q = C32291o.ahl().mo73118q(this.fFc, null, amq);
                C4990ab.m7417i(this.TAG, "sceneEndproc ext:%s tmp:%s tmpfull:%s full:%s ", amq, this.fFc, this.fFd, q);
                String IP = ((C27730c) C1720g.m3528K(C27730c.class)).mo45564IP(str3);
                String IP2 = ((C27730c) C1720g.m3528K(C27730c.class)).mo45564IP(q);
                if (amp) {
                    new C5728b(str2).mo11675o(new C5728b(IP2));
                    c5728b.mo11675o(new C5728b(q));
                } else {
                    if (C5730e.asZ(IP2) > 0) {
                        C5730e.deleteFile(IP2);
                        C7060h.pYm.mo15419k(944, 10, 1);
                    }
                    c5728b.mo11675o(new C5728b(q));
                }
                c25822e.mo43803sb(str3);
                c25822e.mo43810sf(IP);
                c25822e.mo43802sa(C37478f.m63230sh(q));
                c25822e.mo43801lx(this.fDC);
                str = q;
                if (C32291o.ahl().mo73077a(Long.valueOf(this.eFm), c25822e) >= 0) {
                    C4990ab.m7412e(this.TAG, "onGYNetEnd : update img fail");
                    this.ehi.onSceneEnd(3, -1, "", this);
                    AppMethodBeat.m2505o(78317);
                    return false;
                }
                if (this.fEW != null) {
                    C5004al.m7441d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(78312);
                            C25826k.this.fEW.mo8280a(c25822e.offset, c25822e.frO, C25826k.this);
                            AppMethodBeat.m2505o(78312);
                        }
                    });
                }
                C4990ab.m7411d(this.TAG, "cdntra check iscompleted :%b clientid:%s", Boolean.valueOf(c25822e.agP()), this.fFa);
                if (c25822e.agP()) {
                    if (C5046bo.isNullOrNil(this.fFa)) {
                        C7060h.pYm.mo8381e(10420, Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(C5046bo.anU()), Integer.valueOf(C37458c.m63165bW(C4996ah.getContext())), Integer.valueOf(this.fFb), Integer.valueOf(i - this.startOffset));
                    }
                    z = false;
                    if (this.fFe > 0) {
                        z = C32291o.ahl().mo73100a(str, c25822e.fDB, this.fFe, 1, this.csG.dJw, this.csG.dJx);
                    }
                    if (z) {
                        c25822e.agR();
                        ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(this.csG.field_msgId, this.csG);
                    }
                    C32291o.ahl().mo73077a(Long.valueOf(this.eFm), c25822e);
                    C4990ab.m7411d(this.TAG, "cdntra ext:%s %s %s  MediaCheckDuplicationStorage md5:%s", this.fFd, str, c25822e.fDz, this.fFh);
                    if (this.fEZ != null) {
                        this.fEZ.mo67750fS((long) c25822e.frO);
                    }
                    if (!C5046bo.isNullOrNil(this.fFh) && this.fFi > 0) {
                        C46031b.bGD();
                        C46031b.m85613XT().mo16779y(this.fFh, this.fFi, str);
                    }
                    this.ehi.onSceneEnd(0, 0, "", this);
                    AppMethodBeat.m2505o(78317);
                    return false;
                }
                AppMethodBeat.m2505o(78317);
                return true;
            }
            c5728b.delete();
        }
        str = null;
        if (C32291o.ahl().mo73077a(Long.valueOf(this.eFm), c25822e) >= 0) {
        }
    }
}

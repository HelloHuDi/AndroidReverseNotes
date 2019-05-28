package com.tencent.p177mm.plugin.record.p492b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p181af.C8909j.C8910b;
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
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h.C3460c;
import com.tencent.p177mm.plugin.p500s.C34832a;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.app.C30065b;
import com.tencent.p177mm.protocal.protobuf.C23464xj;
import com.tencent.p177mm.protocal.protobuf.C23465xk;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;

/* renamed from: com.tencent.mm.plugin.record.b.e */
public final class C43432e extends C1207m implements C1918k {
    private String cHr;
    C7620bi cKd;
    public long cvx;
    private C7472b ehh;
    C1202f ehi;
    C32231g fEW;
    String fFa;
    private C1628a fFk;
    private long jvz;
    C30065b pJj;
    public long pJl;
    private int pJm;
    String pJn;
    private boolean pJo;
    private boolean pJp;
    private boolean pJq;
    public int retCode;
    long startTime;
    private int type;

    /* renamed from: com.tencent.mm.plugin.record.b.e$2 */
    class C129812 implements Runnable {
        C129812() {
        }

        public final void run() {
            AppMethodBeat.m2504i(135654);
            C43432e.this.fEW.mo8280a((int) C43432e.this.pJj.field_offset, (int) C43432e.this.pJj.field_totalLen, C43432e.this);
            AppMethodBeat.m2505o(135654);
        }
    }

    /* renamed from: com.tencent.mm.plugin.record.b.e$1 */
    class C288261 implements C1628a {

        /* renamed from: com.tencent.mm.plugin.record.b.e$1$8 */
        class C129808 implements Runnable {
            C129808() {
            }

            public final void run() {
                AppMethodBeat.m2504i(135652);
                C43432e.this.ehi.onSceneEnd(0, 0, "", C43432e.this);
                AppMethodBeat.m2505o(135652);
            }
        }

        /* renamed from: com.tencent.mm.plugin.record.b.e$1$5 */
        class C288285 implements Runnable {
            C288285() {
            }

            public final void run() {
                AppMethodBeat.m2504i(135649);
                C43432e.this.fEW.mo8280a((int) C43432e.this.pJj.field_offset, (int) C43432e.this.pJj.field_totalLen, C43432e.this);
                AppMethodBeat.m2505o(135649);
            }
        }

        /* renamed from: com.tencent.mm.plugin.record.b.e$1$6 */
        class C288296 implements Runnable {
            C288296() {
            }

            public final void run() {
                AppMethodBeat.m2504i(135650);
                C43432e.this.fEW.mo8280a((int) C43432e.this.pJj.field_offset, (int) C43432e.this.pJj.field_totalLen, C43432e.this);
                AppMethodBeat.m2505o(135650);
            }
        }

        C288261() {
        }

        /* renamed from: a */
        public final int mo5082a(String str, final int i, C18496c c18496c, final C9545d c9545d, boolean z) {
            AppMethodBeat.m2504i(135653);
            String str2 = "MicroMsg.NetSceneDownloadAppAttach";
            String str3 = "summerbig callback mediaId[%s], startRet[%d], progressInfo[%s], sceneResult[%s], finish[%b]";
            Object[] objArr = new Object[5];
            objArr[0] = str;
            objArr[1] = Integer.valueOf(i);
            objArr[2] = c18496c;
            objArr[3] = c9545d;
            objArr[4] = Boolean.valueOf(c18496c == null);
            C4990ab.m7411d(str2, str3, objArr);
            if (i == -21006) {
                C4990ab.m7417i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", C43432e.this.fFa);
                AppMethodBeat.m2505o(135653);
                return 0;
            } else if (i != 0) {
                C21595a.m33071jC(C43432e.this.pJj.xDa);
                new C9514f(C46180a.m86311r(Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(C43432e.this.startTime), Long.valueOf(C5046bo.anU()), Integer.valueOf(C37458c.m63165bW(C4996ah.getContext())), Integer.valueOf(C42129a.MediaType_FILE), Integer.valueOf(0), "")).ajK();
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(135645);
                        C43432e.this.ehi.onSceneEnd(3, i, "", C43432e.this);
                        AppMethodBeat.m2505o(135645);
                    }
                });
                AppMethodBeat.m2505o(135653);
                return 0;
            } else {
                C43432e.this.pJj = C21595a.m33070i(str, C43432e.this.cvx);
                if (C43432e.this.pJj == null) {
                    C4990ab.m7412e("MicroMsg.NetSceneDownloadAppAttach", "summerbig attachInfo is null");
                    C5004al.m7441d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(135646);
                            C43432e.this.ehi.onSceneEnd(3, i, "", C43432e.this);
                            AppMethodBeat.m2505o(135646);
                        }
                    });
                    AppMethodBeat.m2505o(135653);
                    return 0;
                } else if (C43432e.this.pJj.field_status == 102) {
                    C4990ab.m7417i("MicroMsg.NetSceneDownloadAppAttach", "summerbig dancy attach download has paused, status:%d", Long.valueOf(C43432e.this.pJj.field_status));
                    C37461f.afx().mo51227rN(C43432e.this.fFa);
                    C5004al.m7441d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(135647);
                            C43432e.this.ehi.onSceneEnd(3, i, "attach  has paused, status=" + C43432e.this.pJj.field_status, C43432e.this);
                            AppMethodBeat.m2505o(135647);
                        }
                    });
                    AppMethodBeat.m2505o(135653);
                    return 0;
                } else if (c18496c == null) {
                    if (c9545d != null) {
                        if (c9545d.field_retCode != 0) {
                            C21595a.m33071jC(C43432e.this.pJj.xDa);
                            C4990ab.m7413e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra sceneResult.retCode :%d", Integer.valueOf(c9545d.field_retCode));
                        } else {
                            String str4;
                            new File(C43432e.this.pJn).renameTo(new File(C43432e.this.pJj.field_fileFullPath));
                            C43432e.this.pJj.field_status = 199;
                            C43432e.this.pJj.field_offset = C43432e.this.pJj.field_totalLen;
                            C34832a.aUq().mo48326a(C43432e.this.pJj, new String[0]);
                            C7060h.pYm.mo8378a(198, 45, C43432e.this.pJj.field_totalLen, false);
                            C7060h.pYm.mo8378a(198, 46, 1, false);
                            C7060h c7060h = C7060h.pYm;
                            if (C43432e.this.cKd == null) {
                                str4 = "";
                            } else {
                                str4 = C43432e.this.cKd.field_talker;
                            }
                            c7060h.mo8378a(198, C1855t.m3896kH(str4) ? 48 : 47, 1, false);
                            C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(C43432e.this.pJj.field_msgInfoId);
                            if (jf.field_status == 5) {
                                jf.setStatus(3);
                                ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(jf.field_msgId, jf);
                            } else {
                                ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15289a(new C3460c(jf.field_talker, "update", jf));
                            }
                        }
                        new C9514f(C46180a.m86311r(Integer.valueOf(c9545d.field_retCode), Integer.valueOf(2), Long.valueOf(C43432e.this.startTime), Long.valueOf(C5046bo.anU()), Integer.valueOf(C37458c.m63165bW(C4996ah.getContext())), Integer.valueOf(C42129a.MediaType_FILE), Long.valueOf(C43432e.this.pJj.field_totalLen), c9545d.field_transInfo, "", "", "", "", "", "", "", c9545d.efY)).ajK();
                        if (c9545d.field_retCode != 0) {
                            new C42099d(C46180a.m86311r(Integer.valueOf(c9545d.field_retCode), Integer.valueOf(2), Long.valueOf(C43432e.this.startTime), Long.valueOf(C5046bo.anU()), Integer.valueOf(C37458c.m63165bW(C4996ah.getContext())), Integer.valueOf(C42129a.MediaType_FILE), Long.valueOf(C43432e.this.pJj.field_totalLen), c9545d.field_transInfo, "", "", "", "", "", "", "", c9545d.efY)).ajK();
                        }
                        if (C43432e.this.fEW != null) {
                            C5004al.m7441d(new C288296());
                        }
                        if (c9545d.field_retCode != 0) {
                            C5004al.m7441d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(135651);
                                    C43432e.this.ehi.onSceneEnd(3, c9545d.field_retCode, "", C43432e.this);
                                    AppMethodBeat.m2505o(135651);
                                }
                            });
                        } else {
                            C5004al.m7441d(new C129808());
                        }
                    }
                    AppMethodBeat.m2505o(135653);
                    return 0;
                } else if (((long) c18496c.field_finishedLength) == C43432e.this.pJj.field_totalLen) {
                    C4990ab.m7416i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra ignore progress 100%");
                    AppMethodBeat.m2505o(135653);
                    return 0;
                } else if (C43432e.this.pJj.field_offset > ((long) c18496c.field_finishedLength)) {
                    C4990ab.m7413e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdnEndProc error oldpos:%d newpos:%d", Long.valueOf(C43432e.this.pJj.field_offset), Integer.valueOf(c18496c.field_finishedLength));
                    C21595a.m33071jC(C43432e.this.pJj.xDa);
                    C5004al.m7441d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(135648);
                            C43432e.this.ehi.onSceneEnd(3, i, "", C43432e.this);
                            AppMethodBeat.m2505o(135648);
                        }
                    });
                    AppMethodBeat.m2505o(135653);
                    return 0;
                } else {
                    C43432e.this.pJj.field_offset = (long) c18496c.field_finishedLength;
                    C34832a.aUq().mo48326a(C43432e.this.pJj, new String[0]);
                    if (C43432e.this.fEW != null) {
                        C5004al.m7441d(new C288285());
                    }
                    C4990ab.m7411d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra progresscallback id:%s finish:%d total:%d", C43432e.this.fFa, Integer.valueOf(c18496c.field_finishedLength), Integer.valueOf(c18496c.field_toltalLength));
                    AppMethodBeat.m2505o(135653);
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

    /* renamed from: com.tencent.mm.plugin.record.b.e$a */
    public interface C34795a {
        void ceD();
    }

    public C43432e(String str) {
        this(str, 0, null);
    }

    public C43432e(long j, String str, C32231g c32231g) {
        this(str, j, c32231g);
        this.cvx = j;
    }

    public C43432e(long j, long j2, C32231g c32231g) {
        AppMethodBeat.m2504i(135655);
        this.pJj = null;
        this.pJl = -1;
        this.cHr = "";
        this.cvx = 0;
        this.cKd = null;
        this.fFa = "";
        this.startTime = 0;
        this.pJm = -1;
        this.pJn = "";
        this.type = 0;
        this.retCode = 0;
        this.pJo = false;
        this.pJp = false;
        this.jvz = 0;
        this.pJq = false;
        this.fFk = new C288261();
        this.jvz = j2;
        this.cvx = j;
        this.pJj = C34832a.aUq().mo48329lZ(j);
        this.fEW = c32231g;
        this.pJp = true;
        if (this.pJj == null) {
            C4990ab.m7413e("MicroMsg.NetSceneDownloadAppAttach", "big appMsg, info is null, msgid = , svrId".concat(String.valueOf(j)), Long.valueOf(j2));
            AppMethodBeat.m2505o(135655);
            return;
        }
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C23464xj();
        c1196a.fsK = new C23465xk();
        c1196a.uri = "/cgi-bin/micromsg-bin/downloadappattach";
        c1196a.fsI = 221;
        c1196a.fsL = 106;
        c1196a.fsM = 1000000106;
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(135655);
    }

    public C43432e(C30065b c30065b) {
        AppMethodBeat.m2504i(135656);
        this.pJj = null;
        this.pJl = -1;
        this.cHr = "";
        this.cvx = 0;
        this.cKd = null;
        this.fFa = "";
        this.startTime = 0;
        this.pJm = -1;
        this.pJn = "";
        this.type = 0;
        this.retCode = 0;
        this.pJo = false;
        this.pJp = false;
        this.jvz = 0;
        this.pJq = false;
        this.fFk = new C288261();
        this.pJj = c30065b;
        this.pJo = true;
        this.cHr = this.pJj.field_mediaId;
        this.fEW = null;
        this.type = 0;
        if (c30065b == null) {
            C4990ab.m7412e("MicroMsg.NetSceneDownloadAppAttach", "summerbig <init>, info is null, mediaId = " + this.cHr);
            AppMethodBeat.m2505o(135656);
            return;
        }
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C23464xj();
        c1196a.fsK = new C23465xk();
        c1196a.uri = "/cgi-bin/micromsg-bin/downloadappattach";
        c1196a.fsI = 221;
        c1196a.fsL = 106;
        c1196a.fsM = 1000000106;
        this.ehh = c1196a.acD();
        C4990ab.m7417i("MicroMsg.NetSceneDownloadAppAttach", "summerbig NetSceneDownloadAppAttach info fullpath[%s], justSaveFile[%b], stack[%s]", c30065b.field_fileFullPath, Boolean.TRUE, C5046bo.dpG());
        AppMethodBeat.m2505o(135656);
    }

    private C43432e(String str, long j, C32231g c32231g) {
        AppMethodBeat.m2504i(135657);
        this.pJj = null;
        this.pJl = -1;
        this.cHr = "";
        this.cvx = 0;
        this.cKd = null;
        this.fFa = "";
        this.startTime = 0;
        this.pJm = -1;
        this.pJn = "";
        this.type = 0;
        this.retCode = 0;
        this.pJo = false;
        this.pJp = false;
        this.jvz = 0;
        this.pJq = false;
        this.fFk = new C288261();
        this.cHr = str;
        this.cvx = j;
        this.fEW = c32231g;
        this.type = 0;
        this.pJj = C34832a.aUq().aiE(str);
        if (this.pJj == null) {
            this.pJj = C34832a.aUq().mo48329lZ(j);
        }
        if (this.pJj == null) {
            C4990ab.m7412e("MicroMsg.NetSceneDownloadAppAttach", "summerbig <init>, info is null, mediaId = ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(135657);
            return;
        }
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C23464xj();
        c1196a.fsK = new C23465xk();
        c1196a.uri = "/cgi-bin/micromsg-bin/downloadappattach";
        c1196a.fsI = 221;
        c1196a.fsL = 106;
        c1196a.fsM = 1000000106;
        this.ehh = c1196a.acD();
        C4990ab.m7411d("MicroMsg.NetSceneDownloadAppAttach", "summerbig NetSceneDownloadAppAttach , type[%d], info fullpath[%s], field_type[%d], signature[%s], stack[%s]", Integer.valueOf(0), this.pJj.field_fileFullPath, Long.valueOf(this.pJj.field_type), this.pJj.field_signature, C5046bo.dpG());
        AppMethodBeat.m2505o(135657);
    }

    public final void ceC() {
        AppMethodBeat.m2504i(135658);
        this.pJq = true;
        if (this.pJq) {
            C1173e.m2568e(this.pJj.field_fileFullPath, "#!AMR\n".getBytes());
        }
        AppMethodBeat.m2505o(135658);
    }

    /* renamed from: a */
    public final void mo68987a(C34795a c34795a) {
        AppMethodBeat.m2504i(135659);
        if (!this.pJo) {
            C37461f.afx().mo51228rO(this.fFa);
            this.pJj = C34832a.aUq().mo48329lZ(this.cvx);
            if (this.pJj == null) {
                C4990ab.m7417i("MicroMsg.NetSceneDownloadAppAttach", "pause get by msgid  %是is null then get by mediaId %s", Long.valueOf(this.cvx), this.cHr);
                this.pJj = C34832a.aUq().aiE(this.cHr);
            }
        }
        C4990ab.m7417i("MicroMsg.NetSceneDownloadAppAttach", "summerbig pause listener[%s], info[%s], justSaveFile[%b], stack[%s]", c34795a, this.pJj, Boolean.valueOf(this.pJo), C5046bo.dpG());
        if (this.pJj == null) {
            AppMethodBeat.m2505o(135659);
            return;
        }
        if (this.pJj.field_status == 101 && c34795a != null) {
            c34795a.ceD();
        }
        this.pJj.field_status = 102;
        if (!this.pJo) {
            boolean a = C34832a.aUq().mo48326a(this.pJj, new String[0]);
            C4990ab.m7417i("MicroMsg.NetSceneDownloadAppAttach", "pause done %s", Boolean.valueOf(a));
        }
        AppMethodBeat.m2505o(135659);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(135660);
        this.ehi = c1202f;
        if (this.pJj == null) {
            C4990ab.m7412e("MicroMsg.NetSceneDownloadAppAttach", C1447g.m3075Mq() + " get info failed mediaId:" + this.cHr);
            this.retCode = -10000 - C1447g.getLine();
            AppMethodBeat.m2505o(135660);
            return -1;
        }
        this.cKd = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(this.cvx);
        if (this.cKd == null || this.cKd.field_msgId != this.cvx) {
            C4990ab.m7413e("MicroMsg.NetSceneDownloadAppAttach", C1447g.m3075Mq() + " get msginfo failed mediaId:%s  msgId:%d", this.cHr, Long.valueOf(this.cvx));
            this.retCode = -10000 - C1447g.getLine();
            AppMethodBeat.m2505o(135660);
            return -1;
        }
        if (this.startTime == 0) {
            this.startTime = C5046bo.anU();
            this.pJm = (int) this.pJj.field_offset;
        }
        C23464xj c23464xj;
        int a;
        if (this.jvz != 0) {
            c23464xj = (C23464xj) this.ehh.fsG.fsP;
            c23464xj.jBB = C1853r.m3846Yz();
            c23464xj.ptw = (int) this.pJj.field_totalLen;
            c23464xj.ptx = (int) this.pJj.field_offset;
            c23464xj.pty = 0;
            c23464xj.jCt = 40;
            c23464xj.ptF = this.jvz;
            a = mo4457a(c1902e, this.ehh, this);
            AppMethodBeat.m2505o(135660);
            return a;
        }
        Object obj;
        String str = this.cKd.field_content;
        if (C1855t.m3896kH(this.cKd.field_talker)) {
            int ox = C1829bf.m3761ox(this.cKd.field_content);
            if (ox != -1) {
                str = (this.cKd.field_content + " ").substring(ox + 2).trim();
            }
        }
        C8910b me = C8910b.m16064me(C5046bo.anj(str));
        if (me == null) {
            C4990ab.m7413e("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn cdntra parse content xml failed: mediaId:%s", this.cHr);
            obj = null;
        } else {
            C4990ab.m7417i("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra checkUseCdn msgid:%d total:%d fullpath:%s fileid:%s aeskey:%s ", Long.valueOf(this.cvx), Long.valueOf(this.pJj.field_totalLen), this.pJj.field_fileFullPath, me.fgD, C5046bo.anv(me.eyr));
            if ((C5046bo.isNullOrNil(me.fgD) && C5046bo.isNullOrNil(me.fgu)) || C5046bo.isNullOrNil(me.eyr)) {
                C4990ab.m7421w("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra checkUseCdn msgId:%d Not use CDN  cdnAttachUrl:%s aes:%s ", Long.valueOf(this.cvx), me.fgD, C5046bo.anv(me.eyr));
                obj = null;
            } else {
                this.fFa = C37458c.m63162a("downattach", this.pJj.field_createTime, this.cKd.field_talker, this.pJl);
                if (C5046bo.isNullOrNil(this.fFa)) {
                    C4990ab.m7421w("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra genClientId failed not use cdn rowid:%d", Long.valueOf(this.pJl));
                    obj = null;
                } else {
                    C1173e.m2565cx(this.pJj.field_fileFullPath);
                    this.pJn = this.pJj.field_fileFullPath + "_tmp";
                    C42130g c42130g = new C42130g();
                    c42130g.field_mediaId = this.fFa;
                    c42130g.field_fullpath = this.pJn;
                    a = (me.fgs != 0 || me.fgo > 26214400) ? C42129a.efE : C42129a.MediaType_FILE;
                    c42130g.field_fileType = a;
                    c42130g.field_totalLen = (int) this.pJj.field_totalLen;
                    c42130g.field_aesKey = me.eyr;
                    c42130g.field_fileId = me.fgD;
                    c42130g.field_svr_signature = this.pJj.field_signature;
                    c42130g.field_fake_bigfile_signature_aeskey = this.pJj.field_fakeAeskey;
                    c42130g.field_fake_bigfile_signature = this.pJj.field_fakeSignature;
                    c42130g.field_onlycheckexist = false;
                    c42130g.field_priority = C42129a.efC;
                    c42130g.egl = this.fFk;
                    c42130g.field_chattype = C1855t.m3896kH(this.cKd.field_talker) ? 1 : 0;
                    if (!C5046bo.isNullOrNil(me.fgu)) {
                        c42130g.field_fileType = 19;
                        c42130g.field_authKey = me.fgA;
                        c42130g.egm = me.fgu;
                        c42130g.field_fileId = "";
                    }
                    C4990ab.m7417i("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn addRecvTask taskInfo field_fileType[%d], fileFullPath[%s], aeskey[%s], signature[%s], faeskey[%s], fsignature[%s], onlycheckexist[%s]", Integer.valueOf(c42130g.field_fileType), c42130g.field_fullpath, C5046bo.anv(c42130g.field_aesKey), C5046bo.anv(c42130g.field_svr_signature), C5046bo.anv(c42130g.field_fake_bigfile_signature_aeskey), C5046bo.anv(c42130g.field_fake_bigfile_signature), Boolean.valueOf(c42130g.field_onlycheckexist));
                    if (C37461f.afx().mo51222b(c42130g, -1)) {
                        if (this.pJj.field_isUseCdn != 1) {
                            this.pJj.field_isUseCdn = 1;
                            boolean a2 = C34832a.aUq().mo48326a(this.pJj, new String[0]);
                            if (!a2) {
                                C4990ab.m7412e("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn update info ret:".concat(String.valueOf(a2)));
                                this.retCode = -10000 - C1447g.getLine();
                                this.ehi.onSceneEnd(3, -1, "", this);
                                obj = null;
                            }
                        }
                        obj = 1;
                    } else {
                        C4990ab.m7412e("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra addSendTask failed.");
                        this.fFa = "";
                        obj = null;
                    }
                }
            }
        }
        if (obj != null) {
            C4990ab.m7411d("MicroMsg.NetSceneDownloadAppAttach", "cdntra use cdn return -1 for onGYNetEnd mediaid:%s", this.cHr);
            AppMethodBeat.m2505o(135660);
            return 0;
        }
        if (this.pJj.field_status == 102) {
            this.pJj.field_status = 101;
            if (!this.pJo) {
                C34832a.aUq().mo48326a(this.pJj, new String[0]);
            }
        }
        this.pJl = this.pJj.xDa;
        if (C5046bo.isNullOrNil(this.pJj.field_mediaSvrId) && this.jvz == 0) {
            C4990ab.m7412e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : mediaId is null");
            this.retCode = -10000 - C1447g.getLine();
            AppMethodBeat.m2505o(135660);
            return -1;
        } else if (this.pJj.field_totalLen <= 0 || this.pJj.field_totalLen > 26214400) {
            C4990ab.m7412e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : totalLen is invalid, totalLen = " + this.pJj.field_totalLen);
            this.retCode = -10000 - C1447g.getLine();
            AppMethodBeat.m2505o(135660);
            return -1;
        } else if (C5046bo.isNullOrNil(this.pJj.field_fileFullPath) && this.jvz == 0) {
            C4990ab.m7412e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : fileFullPath is null");
            this.retCode = -10000 - C1447g.getLine();
            AppMethodBeat.m2505o(135660);
            return -1;
        } else {
            a = C1173e.m2560cs(this.pJj.field_fileFullPath);
            if (this.pJq) {
                a -= 6;
                if (a <= 0) {
                    a = 0;
                }
            }
            if (((long) a) != this.pJj.field_offset) {
                C4990ab.m7412e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : fileFullPath is invalid, fileLength = " + a + ", info.field_offset = " + this.pJj.field_offset);
                this.retCode = -10000 - C1447g.getLine();
                AppMethodBeat.m2505o(135660);
                return -1;
            }
            C4990ab.m7417i("MicroMsg.NetSceneDownloadAppAttach", "downing attach by non cdn, appId: %s,  mediaId: %s, sdkVer: %d", this.pJj.field_appId, this.pJj.field_mediaSvrId, Long.valueOf(this.pJj.field_sdkVer));
            c23464xj = (C23464xj) this.ehh.fsG.fsP;
            c23464xj.fKh = this.pJj.field_appId;
            c23464xj.fKk = this.pJj.field_mediaSvrId;
            c23464xj.vFE = (int) this.pJj.field_sdkVer;
            c23464xj.jBB = C1853r.m3846Yz();
            c23464xj.ptw = (int) this.pJj.field_totalLen;
            c23464xj.ptx = (int) this.pJj.field_offset;
            c23464xj.pty = 0;
            if (this.jvz != 0) {
                c23464xj.ptF = this.jvz;
            }
            if (this.type != 0) {
                c23464xj.jCt = this.type;
            } else {
                c23464xj.jCt = (int) this.pJj.field_type;
            }
            a = mo4457a(c1902e, this.ehh, this);
            AppMethodBeat.m2505o(135660);
            return a;
        }
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(135661);
        C4990ab.m7410d("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : errType = " + i2 + ", errCode = " + i3);
        if (i2 == 3 && i3 == -1 && !C5046bo.isNullOrNil(this.fFa)) {
            C4990ab.m7421w("MicroMsg.NetSceneDownloadAppAttach", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", this.fFa);
            AppMethodBeat.m2505o(135661);
        } else if (i2 == 0 && i3 == 0) {
            C23465xk c23465xk = (C23465xk) ((C7472b) c1929q).fsH.fsP;
            this.pJj.field_totalLen = (long) c23465xk.ptw;
            if (c23465xk.fKk != null && !c23465xk.fKk.equals(this.pJj.field_mediaSvrId)) {
                C4990ab.m7412e("MicroMsg.NetSceneDownloadAppAttach", "argument is not consistent");
                this.retCode = -10000 - C1447g.getLine();
                this.ehi.onSceneEnd(3, -1, "", this);
                AppMethodBeat.m2505o(135661);
            } else if (((long) c23465xk.ptx) != this.pJj.field_offset) {
                C4990ab.m7412e("MicroMsg.NetSceneDownloadAppAttach", "startPos, totalLen is incorrect startpos:" + c23465xk.ptx);
                this.retCode = -10000 - C1447g.getLine();
                this.ehi.onSceneEnd(3, -1, "", this);
                AppMethodBeat.m2505o(135661);
            } else if (((long) c23465xk.pty) + this.pJj.field_offset > this.pJj.field_totalLen) {
                C4990ab.m7412e("MicroMsg.NetSceneDownloadAppAttach", "data buffer is incorrect datalen:" + c23465xk.pty + " off:" + this.pJj.field_offset + " total?:" + this.pJj.field_totalLen);
                this.retCode = -10000 - C1447g.getLine();
                this.ehi.onSceneEnd(3, -1, "", this);
                AppMethodBeat.m2505o(135661);
            } else {
                byte[] a = C1946aa.m4150a(c23465xk.ptz);
                if (a == null || a.length == 0 || a.length != c23465xk.pty) {
                    C4990ab.m7412e("MicroMsg.NetSceneDownloadAppAttach", "data buffer is incorrect");
                    this.retCode = -10000 - C1447g.getLine();
                    this.ehi.onSceneEnd(3, -1, "", this);
                    AppMethodBeat.m2505o(135661);
                    return;
                }
                String str2 = new String(a);
                C4990ab.m7411d("MicroMsg.NetSceneDownloadAppAttach", "dancy download big appmsg : %s", Boolean.valueOf(this.pJp));
                if (this.pJj.field_offset < this.pJj.field_totalLen && this.pJp) {
                    C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(this.pJj.field_msgInfoId);
                    StringBuffer stringBuffer;
                    if (!str2.startsWith("<appmsg")) {
                        if (!jf.field_content.startsWith("<msg>")) {
                            stringBuffer = new StringBuffer();
                            stringBuffer.append(jf.field_content).append(str2);
                            this.pJj.field_fullXml = stringBuffer.toString();
                        }
                        if (str2.endsWith("</appmsg>") || this.pJj.field_offset + ((long) a.length) == this.pJj.field_totalLen) {
                            if (C1855t.m3896kH(jf.field_talker)) {
                                String[] split = jf.field_content.split(IOUtils.LINE_SEPARATOR_UNIX, 2);
                                String str3 = split[0];
                                StringBuffer stringBuffer2 = new StringBuffer();
                                stringBuffer2.append(str3).append("\n<msg>").append(split.length > 1 ? split[1] : "").append(str2).append("</msg>");
                                this.pJj.field_fullXml = stringBuffer2.toString();
                            } else {
                                stringBuffer = new StringBuffer();
                                stringBuffer.append("<msg>").append(this.pJj.field_fullXml).append("</msg>");
                                this.pJj.field_fullXml = stringBuffer.toString();
                            }
                        }
                    } else if (!C1855t.m3896kH(jf.field_talker)) {
                        this.pJj.field_fullXml = str2;
                    } else if (!C5046bo.isNullOrNil(jf.field_content)) {
                        this.pJj.field_fullXml = new StringBuffer().append(jf.field_content.split(IOUtils.LINE_SEPARATOR_UNIX, 2)[0]).append(IOUtils.LINE_SEPARATOR_UNIX).toString();
                        stringBuffer = new StringBuffer();
                        stringBuffer.append(this.pJj.field_fullXml).append(str2);
                        this.pJj.field_fullXml = stringBuffer.toString();
                    }
                    jf.setContent(this.pJj.field_fullXml);
                    ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(this.pJj.field_msgInfoId, jf);
                    C4990ab.m7411d("MicroMsg.NetSceneDownloadAppAttach", "dancy download full xml succed! xml: [%s]", str2);
                }
                int e = C1173e.m2568e(this.pJj.field_fileFullPath, a);
                if (C5046bo.isNullOrNil(this.pJj.field_fileFullPath) || e == 0) {
                    C30065b c30065b = this.pJj;
                    c30065b.field_offset += (long) a.length;
                    if (this.pJj.field_offset == this.pJj.field_totalLen) {
                        this.pJj.field_status = 199;
                    }
                    if (this.fEW != null) {
                        C5004al.m7441d(new C129812());
                    }
                    if (!(this.pJo ? true : C34832a.aUq().mo48326a(this.pJj, new String[0]))) {
                        C4990ab.m7412e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd update info ret:".concat(String.valueOf(e)));
                        this.retCode = -10000 - C1447g.getLine();
                        this.ehi.onSceneEnd(3, -1, "", this);
                        AppMethodBeat.m2505o(135661);
                        return;
                    } else if (this.pJj.field_status == 199) {
                        C7060h.pYm.mo8381e(10420, Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(C5046bo.anU()), Integer.valueOf(C37458c.m63165bW(C4996ah.getContext())), Integer.valueOf(C42129a.MediaType_FILE), Long.valueOf(this.pJj.field_totalLen - ((long) this.pJm)));
                        C7620bi jf2 = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(this.pJj.field_msgInfoId);
                        ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15289a(new C3460c(jf2.field_talker, "update", jf2));
                        this.ehi.onSceneEnd(0, 0, "", this);
                        AppMethodBeat.m2505o(135661);
                        return;
                    } else if (this.pJj.field_status == 102) {
                        this.ehi.onSceneEnd(3, -1, "", this);
                        this.retCode = -20102;
                        AppMethodBeat.m2505o(135661);
                        return;
                    } else {
                        if (mo4456a(this.ftf, this.ehi) < 0) {
                            C4990ab.m7412e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : doScene fail");
                            this.ehi.onSceneEnd(3, -1, "", this);
                        }
                        AppMethodBeat.m2505o(135661);
                        return;
                    }
                }
                C4990ab.m7412e("MicroMsg.NetSceneDownloadAppAttach", "append to file failed:".concat(String.valueOf(e)));
                this.retCode = -10000 - C1447g.getLine();
                this.ehi.onSceneEnd(3, -1, "", this);
                AppMethodBeat.m2505o(135661);
            }
        } else {
            C4990ab.m7412e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : errType = " + i2 + ", errCode = " + i3);
            this.retCode = -10000 - C1447g.getLine();
            if (i2 == 4) {
                C7060h.pYm.mo8381e(10420, Integer.valueOf(i3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(C5046bo.anU()), Integer.valueOf(C37458c.m63165bW(C4996ah.getContext())), Integer.valueOf(C42129a.MediaType_FILE), Integer.valueOf(0));
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(135661);
        }
    }

    public final int getType() {
        return 221;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
    }

    public final int acn() {
        return 400;
    }

    public final String getMediaId() {
        if (this.pJj == null) {
            return "";
        }
        return this.pJj.field_mediaSvrId;
    }
}

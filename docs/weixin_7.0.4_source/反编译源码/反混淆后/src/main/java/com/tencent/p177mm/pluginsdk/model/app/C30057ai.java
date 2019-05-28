package com.tencent.p177mm.pluginsdk.model.app;

import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.modelsns.C32831d;
import com.tencent.p177mm.modelstat.C18698o;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p187al.C31259b;
import com.tencent.p177mm.p187al.C37458c;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p230g.p231a.C18346nr;
import com.tencent.p177mm.p230g.p231a.C45347np;
import com.tencent.p177mm.p230g.p232b.p233a.C42099d;
import com.tencent.p177mm.p230g.p232b.p233a.C9514f;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.app.C44062z.C35801a;
import com.tencent.p177mm.pluginsdk.model.app.C46492ag.C46491a;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.ckq;
import com.tencent.p177mm.protocal.protobuf.ckr;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5141c;
import com.tencent.p177mm.storage.C7620bi;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* renamed from: com.tencent.mm.pluginsdk.model.app.ai */
public final class C30057ai extends C1207m implements C1918k {
    C8910b csH = null;
    String cvF;
    private boolean eFq = false;
    int eFs = 0;
    C9545d eFt;
    C4884c eFv = new C300582();
    private C7472b ehh;
    C1202f ehi;
    String fFa = "";
    private C1628a fFk = new C300591();
    boolean fFs = true;
    private String fgq = null;
    C30065b pJj = null;
    long pJl = -1;
    int retCode = 0;
    long startTime = 0;
    String toUser;
    private boolean vcD = true;
    private long vcE = -1;

    /* renamed from: com.tencent.mm.pluginsdk.model.app.ai$2 */
    class C300582 extends C4884c<C18346nr> {
        C300582() {
            AppMethodBeat.m2504i(27377);
            this.xxI = C18346nr.class.getName().hashCode();
            AppMethodBeat.m2505o(27377);
        }

        /* renamed from: a */
        private boolean m47581a(C18346nr c18346nr) {
            AppMethodBeat.m2504i(27378);
            if (c18346nr.cJX.filePath.equals(C30057ai.this.pJj.field_fileFullPath)) {
                String str = "";
                try {
                    str = URLEncoder.encode(c18346nr.cJX.result, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    C4990ab.printErrStackTrace("MicroMsg.NetSceneUploadAppAttach", e, "", new Object[0]);
                }
                if (C30057ai.this.eFs == 1) {
                    C9638aw.m17190ZK();
                    C7620bi jf = C18628c.m29080XO().mo15340jf(C30057ai.this.pJj.field_msgInfoId);
                    C32831d c32831d = new C32831d();
                    c32831d.mo53400l("20toUser", C30057ai.this.toUser + ",");
                    c32831d.mo53400l("21source", "4,");
                    c32831d.mo53400l("22qrUrl", str + ",");
                    c32831d.mo53400l("23md5", (C30057ai.this.eFt == null ? "" : C30057ai.this.eFt.field_filemd5) + ",");
                    c32831d.mo53400l("24cdnFileId", (C30057ai.this.eFt == null ? "" : C30057ai.this.eFt.field_fileId) + ",");
                    c32831d.mo53400l("25cdnAesKey", (C30057ai.this.eFt == null ? "" : C30057ai.this.eFt.field_aesKey) + ",");
                    str = "";
                    if (jf.bAA()) {
                        C8910b me = C8910b.m16064me(jf.field_content);
                        if (me != null) {
                            str = me.appId;
                        }
                    }
                    c32831d.mo53400l("26appip", str + ",");
                    c32831d.mo53400l("27toUsersCount", C37921n.m64060mA(C30057ai.this.toUser) + ",");
                    c32831d.mo53400l("28codeType", Integer.valueOf(c18346nr.cJX.cvn));
                    C4990ab.m7416i("MicroMsg.NetSceneUploadAppAttach", "report qrCodeImgChatting(13628): " + c32831d.mo53398Fk());
                    C18698o.m29233y(13628, c32831d.toString());
                }
                C4879a.xxA.mo10053d(C30057ai.this.eFv);
                AppMethodBeat.m2505o(27378);
            } else {
                AppMethodBeat.m2505o(27378);
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.model.app.ai$1 */
    class C300591 implements C1628a {
        C300591() {
        }

        /* renamed from: a */
        public final int mo5082a(String str, final int i, C18496c c18496c, final C9545d c9545d, boolean z) {
            AppMethodBeat.m2504i(27375);
            String str2 = "MicroMsg.NetSceneUploadAppAttach";
            String str3 = "summerbig cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s], progressing[%b], finish[%b], onlyCheckExist[%b]";
            Object[] objArr = new Object[7];
            objArr[0] = C30057ai.this.fFa;
            objArr[1] = Integer.valueOf(i);
            objArr[2] = c18496c;
            objArr[3] = c9545d;
            objArr[4] = Boolean.valueOf(c18496c != null);
            objArr[5] = Boolean.valueOf(c9545d != null);
            objArr[6] = Boolean.valueOf(z);
            C4990ab.m7411d(str2, str3, objArr);
            C14877am.aUq().mo16761b(C30057ai.this.pJl, (C4925c) C30057ai.this.pJj);
            boolean a;
            if (i == -21005) {
                C4990ab.m7417i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", C30057ai.this.fFa);
                AppMethodBeat.m2505o(27375);
                return 0;
            } else if (i != 0) {
                C4733l.m7104jC(C30057ai.this.pJj.xDa);
                C14877am.aUq().mo16761b(C30057ai.this.pJl, (C4925c) C30057ai.this.pJj);
                C30057ai.this.pJj.field_signature = "";
                a = C14877am.aUq().mo48326a(C30057ai.this.pJj, new String[0]);
                C4990ab.m7421w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback startRet[%d] rowid[%d], reset signature ret[%b]", Integer.valueOf(i), Long.valueOf(C30057ai.this.pJl), Boolean.valueOf(a));
                C30057ai.this.ehi.onSceneEnd(3, i, "", C30057ai.this);
                new C9514f(C46180a.m86311r(Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(C30057ai.this.startTime), Long.valueOf(C5046bo.anU()), Integer.valueOf(C37458c.m63165bW(C4996ah.getContext())), Integer.valueOf(C42129a.MediaType_FILE), Integer.valueOf(0), "")).ajK();
                AppMethodBeat.m2505o(27375);
                return 0;
            } else if (C30057ai.this.pJj.field_status == 105) {
                C4990ab.m7417i("MicroMsg.NetSceneUploadAppAttach", "attach upload has paused, status:%d, rowid:%d", Long.valueOf(C30057ai.this.pJj.field_status), Long.valueOf(C30057ai.this.pJl));
                C37461f.afx().mo51227rN(C30057ai.this.fFa);
                C30057ai.this.ehi.onSceneEnd(3, i, "attach  has paused, status" + C30057ai.this.pJj.field_status, C30057ai.this);
                AppMethodBeat.m2505o(27375);
                return 0;
            } else if (c18496c != null) {
                C30057ai.this.pJj.field_lastModifyTime = C5046bo.anT();
                C30057ai.this.pJj.field_offset = (long) c18496c.field_finishedLength;
                a = C14877am.aUq().mo48326a(C30057ai.this.pJj, new String[0]);
                if (a) {
                    AppMethodBeat.m2505o(27375);
                    return 0;
                }
                C4990ab.m7412e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:".concat(String.valueOf(a)));
                C30057ai.this.retCode = -10000 - C1447g.getLine();
                C30057ai.this.ehi.onSceneEnd(3, i, "", C30057ai.this);
                AppMethodBeat.m2505o(27375);
                return 0;
            } else {
                if (c9545d != null) {
                    if (c9545d.field_retCode != 0) {
                        C4990ab.m7413e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback sceneResult.retCode :%d arg[%s] info[%s]", Integer.valueOf(c9545d.field_retCode), c9545d.field_arg, c9545d.field_transInfo, "", "", "", "", "", "", "", c9545d.efY);
                        C4733l.m7104jC(C30057ai.this.pJj.xDa);
                        C14877am.aUq().mo16761b(C30057ai.this.pJl, (C4925c) C30057ai.this.pJj);
                        C30057ai.this.pJj.field_signature = "";
                        a = C14877am.aUq().mo48326a(C30057ai.this.pJj, new String[0]);
                        C4990ab.m7421w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback startRet[%d] sceneResult.field_retCode[%d], rowid[%d], reset signature ret[%b]", Integer.valueOf(i), Integer.valueOf(c9545d.field_retCode), Long.valueOf(C30057ai.this.pJl), Boolean.valueOf(a));
                        String r = C46180a.m86311r(Integer.valueOf(c9545d.field_retCode), Integer.valueOf(1), Long.valueOf(C30057ai.this.startTime), Long.valueOf(C5046bo.anU()), Integer.valueOf(C37458c.m63165bW(C4996ah.getContext())), Integer.valueOf(C42129a.MediaType_FILE), Integer.valueOf(c9545d.field_fileLength), c9545d.field_transInfo, "", "", "", "", "", "", "", c9545d.efY);
                        new C9514f(r).ajK();
                        new C42099d(r).ajK();
                        C30057ai.this.ehi.onSceneEnd(3, c9545d.field_retCode, "", C30057ai.this);
                    } else {
                        C4990ab.m7417i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback upload attach by cdn, isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], signature[%s]", Integer.valueOf(c9545d.field_UploadHitCacheType), Boolean.valueOf(z), Boolean.valueOf(c9545d.field_exist_whencheck), C5046bo.anv(C30057ai.this.pJj.field_signature));
                        if (!z) {
                            mo48318a(i, c9545d);
                        } else if (c9545d.field_exist_whencheck) {
                            C9638aw.m17182Rg().mo14541a(new C44062z(C30057ai.this.csH, C30057ai.this.pJj.field_fileFullPath, C30057ai.this.toUser, new C35801a() {
                                /* renamed from: a */
                                public final void mo9874a(String str, String str2, String str3, String str4, String str5, long j) {
                                    boolean z = true;
                                    AppMethodBeat.m2504i(27370);
                                    String str6 = "MicroMsg.NetSceneUploadAppAttach";
                                    String str7 = "summerbig NetSceneCheckBigFileUpload exist_whencheck call back new md5[%s], aesKey[%s], signature[%s], aesKey[%s], signature[%s], amc null[%b], enableHitcheck[%b]";
                                    Object[] objArr = new Object[7];
                                    objArr[0] = str;
                                    objArr[1] = C5046bo.anv(str2);
                                    objArr[2] = C5046bo.anv(str3);
                                    objArr[3] = C5046bo.anv(str4);
                                    objArr[4] = C5046bo.anv(str5);
                                    if (C30057ai.this.csH != null) {
                                        z = false;
                                    }
                                    objArr[5] = Boolean.valueOf(z);
                                    objArr[6] = Boolean.valueOf(C30057ai.this.fFs);
                                    C4990ab.m7417i(str6, str7, objArr);
                                    if (!C5046bo.isNullOrNil(str3)) {
                                        C30057ai.this.pJj.field_signature = str3;
                                        C30057ai.this.pJj.field_fakeAeskey = str4;
                                        C30057ai.this.pJj.field_fakeSignature = str5;
                                    }
                                    C300591.this.mo48318a(i, c9545d);
                                    AppMethodBeat.m2505o(27370);
                                }
                            }), 0);
                        } else {
                            C4990ab.m7416i("MicroMsg.NetSceneUploadAppAttach", "summerbig upload check but not exist");
                            C9638aw.m17182Rg().mo14541a(new C44062z(null, C30057ai.this.pJj.field_fileFullPath, C30057ai.this.toUser, new C35801a() {

                                /* renamed from: com.tencent.mm.pluginsdk.model.app.ai$1$2$1 */
                                class C148741 implements Runnable {
                                    C148741() {
                                    }

                                    public final void run() {
                                        AppMethodBeat.m2504i(27371);
                                        C4990ab.m7416i("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene again");
                                        C30057ai.this.mo4456a(C30057ai.this.ftf, C30057ai.this.ehi);
                                        AppMethodBeat.m2505o(27371);
                                    }
                                }

                                /* renamed from: a */
                                public final void mo9874a(String str, String str2, String str3, String str4, String str5, long j) {
                                    boolean z;
                                    AppMethodBeat.m2504i(27372);
                                    String str6 = "MicroMsg.NetSceneUploadAppAttach";
                                    String str7 = "summerbig NetSceneCheckBigFileUpload not exist_whencheck call back new md5[%s], aesKey[%s], signature[%s], aesKey[%s], signature[%s], amc null[%b], enableHitcheck[%b]";
                                    Object[] objArr = new Object[7];
                                    objArr[0] = str;
                                    objArr[1] = C5046bo.anv(str2);
                                    objArr[2] = C5046bo.anv(str3);
                                    objArr[3] = C5046bo.anv(str4);
                                    objArr[4] = C5046bo.anv(str5);
                                    if (C30057ai.this.csH == null) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    objArr[5] = Boolean.valueOf(z);
                                    objArr[6] = Boolean.valueOf(C30057ai.this.fFs);
                                    C4990ab.m7417i(str6, str7, objArr);
                                    if (!C5046bo.isNullOrNil(str3)) {
                                        C30057ai.this.pJj.field_signature = str3;
                                        C30057ai.this.pJj.field_fakeAeskey = str4;
                                        C30057ai.this.pJj.field_fakeSignature = str5;
                                        C30057ai.this.pJj.field_lastModifyTime = C5046bo.anU();
                                        if (C30057ai.this.csH != null) {
                                            C30057ai.this.csH.filemd5 = str;
                                            C30057ai.this.csH.eyr = str2;
                                            C30057ai.this.csH.fgo = (int) j;
                                            C9638aw.m17190ZK();
                                            C7620bi jf = C18628c.m29080XO().mo15340jf(C30057ai.this.pJj.field_msgInfoId);
                                            jf.setContent(C8910b.m16061a(C30057ai.this.csH, null, null));
                                            C9638aw.m17190ZK();
                                            C18628c.m29080XO().mo15284a(jf.field_msgId, jf);
                                        }
                                    }
                                    C30057ai.this.fFs = false;
                                    z = C14877am.aUq().mo48326a(C30057ai.this.pJj, new String[0]);
                                    if (z) {
                                        C9638aw.m17180RS().mo10302aa(new C148741());
                                        AppMethodBeat.m2505o(27372);
                                        return;
                                    }
                                    C4990ab.m7412e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:".concat(String.valueOf(z)));
                                    C30057ai.this.retCode = -10000 - C1447g.getLine();
                                    C30057ai.this.ehi.onSceneEnd(3, i, "", C30057ai.this);
                                    AppMethodBeat.m2505o(27372);
                                }
                            }), 0);
                        }
                    }
                }
                AppMethodBeat.m2505o(27375);
                return 0;
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final void mo48318a(int i, final C9545d c9545d) {
            AppMethodBeat.m2504i(27376);
            C30057ai.this.pJj.field_status = 199;
            boolean a = C14877am.aUq().mo48326a(C30057ai.this.pJj, new String[0]);
            if (a) {
                C4733l.m7084a(C30057ai.this.pJj.field_msgInfoId, C30057ai.this.pJj.field_mediaSvrId, c9545d);
                C9638aw.m17182Rg().mo14541a(new C46492ag(C30057ai.this.pJj.field_msgInfoId, true, c9545d, new C46491a() {

                    /* renamed from: com.tencent.mm.pluginsdk.model.app.ai$1$3$1 */
                    class C300561 implements Runnable {
                        C300561() {
                        }

                        public final void run() {
                            AppMethodBeat.m2504i(27373);
                            C30057ai.this.fFs = false;
                            C30057ai.this.pJj.field_createTime = C5046bo.anU();
                            C30057ai.this.pJj.field_lastModifyTime = C5046bo.anT();
                            C30057ai.this.pJj.field_offset = 0;
                            C30057ai.this.pJj.field_status = 101;
                            boolean a = C14877am.aUq().mo48326a(C30057ai.this.pJj, new String[0]);
                            C4990ab.m7417i("MicroMsg.NetSceneUploadAppAttach", "summersafecdn MM_ERR_GET_AESKEY_FAILED doScene again enableHitcheck[%b], ret[%b] new createtime:%d", Boolean.valueOf(C30057ai.this.fFs), Boolean.valueOf(a), Long.valueOf(C30057ai.this.pJj.field_createTime));
                            C30057ai.this.mo4456a(C30057ai.this.ftf, C30057ai.this.ehi);
                            AppMethodBeat.m2505o(27373);
                        }
                    }

                    /* renamed from: cC */
                    public final void mo48315cC(int i, int i2) {
                        AppMethodBeat.m2504i(27374);
                        C4990ab.m7417i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra NetSceneSendAppMsgForCdn callback %d,%d", Integer.valueOf(i), Integer.valueOf(i2));
                        if (i == 4 && i2 == 102) {
                            C9638aw.m17180RS().mo10302aa(new C300561());
                            AppMethodBeat.m2505o(27374);
                            return;
                        }
                        new C9514f(C46180a.m86311r(Integer.valueOf(i2), Integer.valueOf(1), Long.valueOf(C30057ai.this.startTime), Long.valueOf(C5046bo.anU()), Integer.valueOf(C37458c.m63165bW(C4996ah.getContext())), Integer.valueOf(C42129a.MediaType_FILE), Integer.valueOf(c9545d.field_fileLength), c9545d.field_transInfo, "", "", "", "", "", "", "", c9545d.efY)).ajK();
                        if (i == 0 && i2 == 0) {
                            C30057ai.this.mo48317d(c9545d);
                        }
                        C30057ai.this.ehi.onSceneEnd(i, i2, "", C30057ai.this);
                        AppMethodBeat.m2505o(27374);
                    }
                }, C30057ai.this.cvF, C30057ai.this.pJj), 0);
                AppMethodBeat.m2505o(27376);
                return;
            }
            C4990ab.m7412e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:".concat(String.valueOf(a)));
            C30057ai.this.retCode = -10000 - C1447g.getLine();
            C30057ai.this.ehi.onSceneEnd(3, i, "", C30057ai.this);
            AppMethodBeat.m2505o(27376);
        }

        /* renamed from: a */
        public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        /* renamed from: l */
        public final byte[] mo5084l(String str, byte[] bArr) {
            return null;
        }
    }

    public C30057ai(long j, String str, String str2) {
        AppMethodBeat.m2504i(27380);
        this.pJl = j;
        this.fgq = str;
        this.cvF = str2;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ckq();
        c1196a.fsK = new ckr();
        c1196a.uri = "/cgi-bin/micromsg-bin/uploadappattach";
        c1196a.fsI = 220;
        c1196a.fsL = 105;
        c1196a.fsM = 1000000105;
        this.ehh = c1196a.acD();
        C4990ab.m7417i("MicroMsg.NetSceneUploadAppAttach", "summerbig new NetSceneUploadAppAttach rowid[%d], emoticonmd5[%s], stack[%s]", Long.valueOf(j), str, C5046bo.dpG());
        AppMethodBeat.m2505o(27380);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(27381);
        this.ehi = c1202f;
        this.pJj = new C30065b();
        if (!C14877am.aUq().mo16761b(this.pJl, (C4925c) this.pJj) || this.pJj == null) {
            C4990ab.m7412e("MicroMsg.NetSceneUploadAppAttach", C1447g.m3075Mq() + " summerbig get info failed rowid:" + this.pJl);
            this.retCode = -10000 - C1447g.getLine();
            this.pJj = null;
            AppMethodBeat.m2505o(27381);
            return -1;
        } else if (this.pJj.field_status != 101) {
            C4990ab.m7412e("MicroMsg.NetSceneUploadAppAttach", C1447g.m3075Mq() + " summerbig get field_status failed rowid:" + this.pJl + " status:" + this.pJj.field_status);
            AppMethodBeat.m2505o(27381);
            return -1;
        } else {
            Object obj;
            if (this.startTime == 0) {
                this.startTime = C5046bo.anU();
                this.vcE = this.pJj.field_offset;
            }
            C4990ab.m7417i("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene rowid[%d], fileFullPath[%s], totalLen[%d],isUpload[%b], isUseCdn[%b], type[%d]", Long.valueOf(this.pJl), this.pJj.field_fileFullPath, Long.valueOf(this.pJj.field_totalLen), Boolean.valueOf(this.pJj.field_isUpload), Integer.valueOf(this.pJj.field_isUseCdn), Long.valueOf(this.pJj.field_type));
            if (C5046bo.isNullOrNil(this.pJj.field_appId)) {
                C4990ab.m7412e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : appId is null");
                if (!(this.pJj.field_type == 8 || this.pJj.field_type == 6)) {
                    this.retCode = -10000 - C1447g.getLine();
                    AppMethodBeat.m2505o(27381);
                    return -1;
                }
            }
            if (this.pJj.field_type == 8 || this.pJj.field_type == 9) {
                C4990ab.m7417i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra cdn not support Emoji or voiceremind now type:%d", Long.valueOf(this.pJj.field_type));
                obj = null;
            } else {
                C37461f.afx();
                if (C31259b.m50439lg(4) || this.pJj.field_isUseCdn == 1) {
                    C9638aw.m17190ZK();
                    C7620bi jf = C18628c.m29080XO().mo15340jf(this.pJj.field_msgInfoId);
                    if (jf.field_msgId != this.pJj.field_msgInfoId) {
                        C4990ab.m7421w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra read msg info failed msgId[%d], rowid[%d], createtime[%d], len[%d], status[%d], upload[%b], useCdn[%d], mediaId[%s]", Long.valueOf(this.pJj.field_msgInfoId), Long.valueOf(this.pJj.xDa), Long.valueOf(this.pJj.field_createTime), Long.valueOf(this.pJj.field_totalLen), Long.valueOf(this.pJj.field_status), Boolean.valueOf(this.pJj.field_isUpload), Integer.valueOf(this.pJj.field_isUseCdn), this.pJj.field_mediaId);
                        this.toUser = null;
                        obj = null;
                    } else {
                        this.toUser = jf.field_talker;
                        String str = "";
                        if (!C5046bo.isNullOrNil(jf.field_imgPath)) {
                            str = C32291o.ahl().mo73119sj(jf.field_imgPath);
                        }
                        int cs = C1173e.m2560cs(str);
                        int cs2 = C1173e.m2560cs(this.pJj.field_fileFullPath);
                        if (cs >= C42129a.efW) {
                            C4990ab.m7421w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", str, Integer.valueOf(cs));
                            obj = null;
                        } else {
                            this.fFa = C37458c.m63162a("upattach", this.pJj.field_createTime, jf.field_talker, this.pJl);
                            C4990ab.m7421w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra genClientId field_createTime[%d], useCdnTransClientId[%s]", Long.valueOf(this.pJj.field_createTime), this.fFa);
                            if (C5046bo.isNullOrNil(this.fFa)) {
                                C4990ab.m7421w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra genClientId failed not use cdn rowid:%d", Long.valueOf(this.pJl));
                                obj = null;
                            } else {
                                Object obj2;
                                C42130g c42130g = new C42130g();
                                String str2 = jf.field_content;
                                if (C1855t.m3896kH(jf.field_talker)) {
                                    int ox = C1829bf.m3761ox(jf.field_content);
                                    if (ox != -1) {
                                        str2 = (jf.field_content + " ").substring(ox + 2).trim();
                                    }
                                }
                                this.csH = C8910b.m16064me(C5046bo.anj(str2));
                                if (this.csH != null) {
                                    C4990ab.m7411d("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra amc.cdnAttachUrl[%s], amc.aesKey[%s], amc.filemd5[%s], amc.type[%d]", this.csH.fgD, C5046bo.anv(this.csH.eyr), this.csH.filemd5, Integer.valueOf(this.csH.type));
                                    c42130g.field_fileId = this.csH.fgD;
                                    c42130g.field_aesKey = this.csH.eyr;
                                    c42130g.field_filemd5 = this.csH.filemd5;
                                    obj2 = (this.csH.fgs != 0 || this.csH.fgo > 26214400) ? 1 : null;
                                } else {
                                    C4990ab.m7416i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra parse content xml failed");
                                    obj2 = null;
                                }
                                c42130g.egl = this.fFk;
                                c42130g.field_mediaId = this.fFa;
                                c42130g.field_fullpath = this.pJj.field_fileFullPath;
                                c42130g.field_thumbpath = str;
                                c42130g.field_fileType = obj2 != null ? C42129a.efE : C42129a.MediaType_FILE;
                                c42130g.field_svr_signature = obj2 != null ? C5046bo.nullAsNil(this.pJj.field_signature) : "";
                                c42130g.field_onlycheckexist = obj2 != null ? C5046bo.isNullOrNil(this.pJj.field_signature) : false;
                                c42130g.field_fake_bigfile_signature_aeskey = this.pJj.field_fakeAeskey;
                                c42130g.field_fake_bigfile_signature = this.pJj.field_fakeSignature;
                                c42130g.field_talker = jf.field_talker;
                                c42130g.field_priority = C42129a.efC;
                                c42130g.field_totalLen = cs2;
                                c42130g.field_needStorage = false;
                                c42130g.field_isStreamMedia = false;
                                c42130g.field_enable_hitcheck = this.fFs;
                                c42130g.field_chattype = C1855t.m3896kH(jf.field_talker) ? 1 : 0;
                                c42130g.field_force_aeskeycdn = false;
                                c42130g.field_trysafecdn = true;
                                C4990ab.m7417i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra checkUseCdn msgId:%d file[%s][%d] thumb[%s][%d], useCdnTransClientId[%s], fileType[%d], enable_hitcheck[%b], onlycheckexist[%b] force_aeskeycdn[%b] trysafecdn[%b] aeskey[%s], md5[%s], signature[%s], faeskey[%s], fsignature[%s]", Long.valueOf(this.pJj.field_msgInfoId), c42130g.field_fullpath, Integer.valueOf(cs2), str, Integer.valueOf(cs), this.fFa, Integer.valueOf(c42130g.field_fileType), Boolean.valueOf(c42130g.field_enable_hitcheck), Boolean.valueOf(c42130g.field_onlycheckexist), Boolean.valueOf(c42130g.field_force_aeskeycdn), Boolean.valueOf(c42130g.field_trysafecdn), C5046bo.anv(c42130g.field_aesKey), c42130g.field_filemd5, C5046bo.anv(c42130g.field_svr_signature), C5046bo.anv(c42130g.field_fake_bigfile_signature_aeskey), C5046bo.anv(c42130g.field_fake_bigfile_signature));
                                if (C37461f.afx().mo51225e(c42130g)) {
                                    if (this.pJj.field_isUseCdn != 1) {
                                        this.pJj.field_isUseCdn = 1;
                                        boolean a = C14877am.aUq().mo48326a(this.pJj, new String[0]);
                                        if (!a) {
                                            C4990ab.m7412e("MicroMsg.NetSceneUploadAppAttach", "summerbig checkUseCdn update info ret:".concat(String.valueOf(a)));
                                            this.retCode = -10000 - C1447g.getLine();
                                            this.ehi.onSceneEnd(3, -1, "", this);
                                            obj = null;
                                        }
                                    }
                                    C4990ab.m7417i("MicroMsg.NetSceneUploadAppAttach", "summerbig checkUseCdn ret true useCdnTransClientId[%s]", this.fFa);
                                    obj = 1;
                                } else {
                                    C4990ab.m7412e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra addSendTask failed.");
                                    this.fFa = "";
                                    obj = null;
                                }
                            }
                        }
                    }
                } else {
                    r2 = new Object[2];
                    C37461f.afx();
                    r2[0] = Boolean.valueOf(C31259b.m50439lg(4));
                    r2[1] = Integer.valueOf(this.pJj.field_isUseCdn);
                    C4990ab.m7421w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra not use cdn flag:%b getCdnInfo:%d", r2);
                    obj = null;
                }
            }
            if (obj != null) {
                C4990ab.m7411d("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene cdntra use cdn return -1 for onGYNetEnd client rowid:%d", Long.valueOf(this.pJl));
                AppMethodBeat.m2505o(27381);
                return 0;
            } else if (this.pJj.field_netTimes > 3200) {
                C4733l.m7104jC(this.pJj.xDa);
                C4990ab.m7412e("MicroMsg.NetSceneUploadAppAttach", C1447g.m3075Mq() + " summerbig doScene info.field_netTimes > DOSCENE_LIMIT SET ERROR! rowid:" + this.pJl);
                AppMethodBeat.m2505o(27381);
                return -1;
            } else {
                C30065b c30065b = this.pJj;
                c30065b.field_netTimes++;
                if (C5046bo.isNullOrNil(this.pJj.field_clientAppDataId)) {
                    C4990ab.m7412e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : clientAppDataId is null");
                    this.retCode = -10000 - C1447g.getLine();
                    AppMethodBeat.m2505o(27381);
                    return -1;
                } else if (this.pJj.field_totalLen <= 0 || this.pJj.field_totalLen > 26214400) {
                    C4990ab.m7412e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : totalLen is invalid, totalLen = " + this.pJj.field_totalLen);
                    this.retCode = -10000 - C1447g.getLine();
                    if (this.pJj.field_totalLen > 26214400) {
                        C4733l.m7104jC(this.pJj.xDa);
                    }
                    AppMethodBeat.m2505o(27381);
                    return -1;
                } else if (C5046bo.isNullOrNil(this.pJj.field_fileFullPath)) {
                    C4990ab.m7412e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : fileFullPath is null");
                    this.retCode = -10000 - C1447g.getLine();
                    AppMethodBeat.m2505o(27381);
                    return -1;
                } else if (C1173e.m2560cs(this.pJj.field_fileFullPath) > 26214400) {
                    C4990ab.m7412e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene doScene : file is too large");
                    C4733l.m7104jC(this.pJj.xDa);
                    AppMethodBeat.m2505o(27381);
                    return -1;
                } else {
                    byte[] f;
                    if (C5046bo.isNullOrNil(this.fgq)) {
                        f = C1173e.m2571f(this.pJj.field_fileFullPath, (int) this.pJj.field_offset, Utility.DEFAULT_STREAM_BUFFER_SIZE);
                    } else {
                        f = C1173e.m2571f(this.pJj.field_fileFullPath, (int) this.pJj.field_offset, 32768);
                    }
                    if (C5046bo.m7540cb(f)) {
                        C4990ab.m7412e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene doScene : data is null");
                        this.retCode = -10000 - C1447g.getLine();
                        AppMethodBeat.m2505o(27381);
                        return -1;
                    }
                    ckq ckq = (ckq) this.ehh.fsG.fsP;
                    ckq.fKh = this.pJj.field_appId;
                    ckq.vFE = (int) this.pJj.field_sdkVer;
                    ckq.xit = this.pJj.field_clientAppDataId;
                    ckq.jCt = (int) this.pJj.field_type;
                    ckq.jBB = C1853r.m3846Yz();
                    ckq.ptw = (int) this.pJj.field_totalLen;
                    ckq.ptx = (int) this.pJj.field_offset;
                    int a2;
                    if (this.fgq == null || !this.vcD) {
                        ckq.pty = f.length;
                        ckq.ptz = new SKBuiltinBuffer_t().setBuffer(f);
                        if (this.fgq != null) {
                            ckq.wdO = this.fgq;
                        }
                        a2 = mo4457a(c1902e, this.ehh, this);
                        AppMethodBeat.m2505o(27381);
                        return a2;
                    }
                    ckq.wdO = this.fgq;
                    ckq.ptw = (int) this.pJj.field_totalLen;
                    ckq.pty = 0;
                    ckq.ptz = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
                    this.vcD = false;
                    a2 = mo4457a(c1902e, this.ehh, this);
                    AppMethodBeat.m2505o(27381);
                    return a2;
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(27382);
        C4990ab.m7410d("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : errType = " + i2 + ", errCode = " + i3);
        if (i2 == 3 && i3 == -1 && !C5046bo.isNullOrNil(this.fFa)) {
            C4990ab.m7421w("MicroMsg.NetSceneUploadAppAttach", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", this.fFa);
            AppMethodBeat.m2505o(27382);
        } else if (i2 == 0 && i3 == 0) {
            ckr ckr = (ckr) ((C7472b) c1929q).fsH.fsP;
            if (ckr.fKh != null && this.fgq == null && (!ckr.fKh.equals(this.pJj.field_appId) || !ckr.xit.equals(this.pJj.field_clientAppDataId))) {
                C4990ab.m7412e("MicroMsg.NetSceneUploadAppAttach", "argument is not consistent");
                this.retCode = -10000 - C1447g.getLine();
                this.ehi.onSceneEnd(3, -1, "", this);
                AppMethodBeat.m2505o(27382);
            } else if (ckr.ptw < 0 || ((long) ckr.ptw) != this.pJj.field_totalLen || ckr.ptx < 0 || ((long) ckr.ptx) > this.pJj.field_totalLen) {
                C4990ab.m7412e("MicroMsg.NetSceneUploadAppAttach", "dataLen, startPos or totalLen is incorrect");
                this.retCode = -10000 - C1447g.getLine();
                this.ehi.onSceneEnd(3, -1, "", this);
                AppMethodBeat.m2505o(27382);
            } else {
                this.pJj.field_offset = (long) ckr.ptx;
                this.pJj.field_mediaSvrId = C4733l.aiK(ckr.fKk) ? ckr.fKk : "";
                if (this.pJj.field_status == 105) {
                    C4990ab.m7420w("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd STATUS PAUSE [" + this.pJj.field_mediaSvrId + "," + this.pJj.field_offset + "] ");
                    this.ehi.onSceneEnd(i2, -1, "", this);
                    AppMethodBeat.m2505o(27382);
                    return;
                }
                if (this.pJj.field_offset == this.pJj.field_totalLen) {
                    if (C5046bo.isNullOrNil(this.pJj.field_mediaSvrId)) {
                        C4990ab.m7412e("MicroMsg.NetSceneUploadAppAttach", "finish upload but mediaid == null!");
                        this.retCode = -10000 - C1447g.getLine();
                        this.ehi.onSceneEnd(3, -1, "", this);
                        C4733l.m7104jC(this.pJj.xDa);
                        AppMethodBeat.m2505o(27382);
                        return;
                    }
                    this.pJj.field_status = 199;
                    C7060h.pYm.mo8381e(10420, Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(C5046bo.anU()), Integer.valueOf(C37458c.m63165bW(C4996ah.getContext())), Integer.valueOf(C42129a.MediaType_FILE), Long.valueOf(this.pJj.field_totalLen - this.vcE));
                }
                boolean a = C14877am.aUq().mo48326a(this.pJj, new String[0]);
                if (!a) {
                    C4990ab.m7412e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd update info ret:".concat(String.valueOf(a)));
                    this.retCode = -10000 - C1447g.getLine();
                    mo48317d(null);
                    this.ehi.onSceneEnd(3, -1, "", this);
                    AppMethodBeat.m2505o(27382);
                } else if (this.pJj.field_status == 199) {
                    this.ehi.onSceneEnd(0, 0, "", this);
                    AppMethodBeat.m2505o(27382);
                } else {
                    if (mo4456a(this.ftf, this.ehi) < 0) {
                        C4990ab.m7412e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : doScene fail");
                        this.ehi.onSceneEnd(3, -1, "", this);
                    }
                    AppMethodBeat.m2505o(27382);
                }
            }
        } else {
            C4990ab.m7412e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : errType = " + i2 + ", errCode = " + i3);
            this.retCode = -10000 - C1447g.getLine();
            if (i2 == 4) {
                C7060h.pYm.mo8381e(10420, Integer.valueOf(i3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(C5046bo.anU()), Integer.valueOf(C37458c.m63165bW(C4996ah.getContext())), Integer.valueOf(C42129a.MediaType_FILE), Long.valueOf(this.pJj.field_totalLen - this.vcE));
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(27382);
        }
    }

    public final int acn() {
        return 3200;
    }

    public final int getType() {
        return 220;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: d */
    public final void mo48317d(C9545d c9545d) {
        AppMethodBeat.m2504i(27383);
        if (this.pJj.field_type != 2) {
            AppMethodBeat.m2505o(27383);
            return;
        }
        C5141c ll = C18624c.abi().mo17131ll("100131");
        if (ll.isValid()) {
            this.eFs = C42252ah.getInt((String) ll.dru().get("needUploadData"), 1);
        }
        if (this.eFq || this.eFs == 0) {
            AppMethodBeat.m2505o(27383);
            return;
        }
        this.eFt = c9545d;
        this.eFq = true;
        C45347np c45347np = new C45347np();
        C4879a.xxA.mo10052c(this.eFv);
        c45347np.cJU.filePath = this.pJj.field_fileFullPath;
        C4879a.xxA.mo10055m(c45347np);
        AppMethodBeat.m2505o(27383);
    }
}

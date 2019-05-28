package com.tencent.p177mm.p190at;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1831bh;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.modelstat.C42220h;
import com.tencent.p177mm.modelstat.C45458r;
import com.tencent.p177mm.network.C1898c;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.network.C32856ab;
import com.tencent.p177mm.p1385l.C32722a.C26350a;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C32231g;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p183ai.C7475t;
import com.tencent.p177mm.p183ai.C7477v;
import com.tencent.p177mm.p187al.C31259b;
import com.tencent.p177mm.p187al.C37458c;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p187al.C8941a;
import com.tencent.p177mm.p190at.C32290n.C32288d;
import com.tencent.p177mm.p190at.C6326m.C6327a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p232b.p233a.C42099d;
import com.tencent.p177mm.p230g.p232b.p233a.C9514f;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.emoji.p725b.C27730c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.p177mm.plugin.report.service.C34830g;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.pointers.PString;
import com.tencent.p177mm.protocal.protobuf.C44147my;
import com.tencent.p177mm.protocal.protobuf.C46567mz;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.btd;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.protocal.protobuf.clk;
import com.tencent.p177mm.protocal.protobuf.cll;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5730e;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;
import p690e.p691a.p692a.C6092b;

/* renamed from: com.tencent.mm.at.l */
public final class C9022l extends C1207m implements C1918k {
    public static boolean DEBUG = true;
    private static long fFD;
    private String TAG;
    private float cEB;
    public String cMr;
    public C7620bi csG;
    private long eFm;
    private int eFn;
    private C25822e eFo;
    private boolean eFu;
    private final C7472b ehh;
    private C1202f ehi;
    private int fDC;
    private long fDH;
    private final C32231g fEW;
    public long fEX;
    private C42220h fEZ;
    private String fFA;
    private String fFB;
    public String fFC;
    private String fFa;
    private int fFb;
    private int fFe;
    private C1628a fFk;
    private String fFq;
    private String fFr;
    private boolean fFs;
    private C25822e fFt;
    private int fFu;
    C9023b fFv;
    private String fFw;
    public String fFx;
    public boolean fFy;
    private float fFz;
    private int scene;
    private int startOffset;
    private long startTime;

    /* renamed from: com.tencent.mm.at.l$b */
    class C9023b {
        public C9028a fFI;

        /* Access modifiers changed, original: final */
        public final void agX() {
            C25822e d;
            AppMethodBeat.m2504i(78330);
            if (C9022l.this.fEX == C9022l.this.eFm) {
                d = C9022l.m16312d(C9022l.this);
            } else {
                d = C9022l.m16313e(C9022l.this);
            }
            if (d.fDL == 1) {
                C34830g.m57195BO(23);
                C34830g.m57195BO(21);
            }
            C4990ab.m7417i(C9022l.this.TAG, "UploadEndWrapper onUploadEnd %s done", C9022l.m16314f(C9022l.m16312d(C9022l.this)));
            if (C32291o.ahl().mo73077a(Long.valueOf(C9022l.this.eFm), C9022l.m16312d(C9022l.this)) < 0) {
                C4990ab.m7412e(C9022l.this.TAG, "update db failed local id:" + C9022l.this.eFm + " server id:" + C9022l.m16312d(C9022l.this).cKK);
                C45161i.m83149lC((int) C9022l.this.fEX);
                C45161i.m83148lB((int) C9022l.this.fEX);
                C9022l.this.ehi.onSceneEnd(3, -1, "", C9022l.this);
            }
            if (C9022l.this.eFm != C9022l.this.fEX) {
                C4990ab.m7417i(C9022l.this.TAG, "UploadEndWrapper onUploadEnd OriImg %s done", C9022l.m16314f(C9022l.m16313e(C9022l.this)));
                C32291o.ahl().mo73077a(Long.valueOf(C9022l.this.fEX), C9022l.m16313e(C9022l.this));
            }
            if (C4872b.dnO() || C5058f.IS_FLAVOR_RED || C5058f.IS_FLAVOR_PURPLE) {
                List agV = C32291o.ahl().agV();
                if (agV != null) {
                    for (int i = 0; i < agV.size(); i++) {
                        C4990ab.m7417i(C9022l.this.TAG, "UploadEndWrapper onUploadEnd duminfo %s %s", Integer.valueOf(i), C9022l.m16314f((C25822e) agV.get(i)));
                    }
                }
            }
            C9022l.m16301a(C9022l.this, C9022l.this.eFm);
            if (C9022l.this.fEX != C9022l.this.eFm) {
                C9022l.m16301a(C9022l.this, C9022l.this.fEX);
            }
            if (this.fFI != null) {
                this.fFI.agX();
            }
            C9022l.this.mo20458lD(C9022l.this.fDC);
            C9022l.this.fFv = null;
            AppMethodBeat.m2505o(78330);
        }

        public C9023b(C9028a c9028a) {
            this.fFI = c9028a;
        }
    }

    /* renamed from: com.tencent.mm.at.l$5 */
    class C90275 implements Runnable {
        C90275() {
        }

        public final void run() {
            AppMethodBeat.m2504i(78328);
            ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15243QX("SendImgSpeeder");
            AppMethodBeat.m2505o(78328);
        }
    }

    /* renamed from: com.tencent.mm.at.l$a */
    public interface C9028a {
        void agX();
    }

    /* renamed from: com.tencent.mm.at.l$4 */
    class C90294 implements C1628a {

        /* renamed from: com.tencent.mm.at.l$4$2 */
        class C90212 implements Runnable {
            C90212() {
            }

            public final void run() {
                AppMethodBeat.m2504i(78323);
                C9022l.m16304a(C9022l.this, C9022l.m16312d(C9022l.this));
                AppMethodBeat.m2505o(78323);
            }
        }

        C90294() {
        }

        /* renamed from: a */
        public final int mo5082a(String str, int i, C18496c c18496c, final C9545d c9545d, boolean z) {
            Throwable th;
            AppMethodBeat.m2504i(78325);
            C4990ab.m7411d(C9022l.this.TAG, "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", C9022l.this.fFa, Integer.valueOf(i), c18496c, c9545d);
            String str2;
            if (i == -21005) {
                C4990ab.m7421w(C9022l.this.TAG, "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", C9022l.this.fFa);
                if (C9022l.this.fFv != null) {
                    C9022l.this.fFv.agX();
                }
                C9022l.this.ehi.onSceneEnd(3, i, "", C9022l.this);
                AppMethodBeat.m2505o(78325);
                return 0;
            } else if (i != 0) {
                C4990ab.m7413e(C9022l.this.TAG, "cdntra cdnCallback clientid:%s startRet:%d", C9022l.this.fFa, Integer.valueOf(i));
                C45161i.m83149lC((int) C9022l.this.fEX);
                C45161i.m83148lB((int) C9022l.this.fEX);
                if (c9545d != null) {
                    Object[] objArr = new Object[16];
                    objArr[0] = Integer.valueOf(i);
                    objArr[1] = Integer.valueOf(1);
                    objArr[2] = Long.valueOf(C9022l.this.startTime);
                    objArr[3] = Long.valueOf(C5046bo.anU());
                    objArr[4] = Integer.valueOf(C37458c.m63165bW(C4996ah.getContext()));
                    objArr[5] = Integer.valueOf(C9022l.this.fFb);
                    objArr[6] = Integer.valueOf(c9545d.field_fileLength);
                    objArr[7] = c9545d.field_transInfo;
                    objArr[8] = "";
                    objArr[9] = "";
                    objArr[10] = "";
                    objArr[11] = "";
                    objArr[12] = "";
                    objArr[13] = "";
                    objArr[14] = "";
                    if (c9545d == null) {
                        str2 = "";
                    } else {
                        str2 = C9022l.m16331sp(c9545d.efY);
                    }
                    objArr[15] = str2;
                    new C9514f(C46180a.m86311r(objArr)).ajK();
                }
                C9022l.this.ehi.onSceneEnd(3, i, "", C9022l.this);
                if (C9022l.this.fFv != null) {
                    C9022l.this.fFv.agX();
                }
                AppMethodBeat.m2505o(78325);
                return 0;
            } else {
                final C25822e d = C9022l.m16312d(C9022l.this);
                if (d == null || d.fDy != C9022l.this.eFm) {
                    C37461f.afx().mo51227rN(C9022l.this.fFa);
                    C4990ab.m7413e(C9022l.this.TAG, "cdntra get imginfo failed maybe delete by user imgLocalId:%d client:%s", Long.valueOf(C9022l.this.eFm), C9022l.this.fFa);
                    if (C9022l.this.fFv != null) {
                        C9022l.this.fFv.agX();
                    }
                    AppMethodBeat.m2505o(78325);
                    return 0;
                } else if (c18496c != null) {
                    C9022l.m16305a(C9022l.this, d, c18496c.field_finishedLength, 0, 0, c9545d);
                    AppMethodBeat.m2505o(78325);
                    return 0;
                } else {
                    if (c9545d != null) {
                        C4990ab.m7417i(C9022l.this.TAG, "dkupimg sceneResult:%s", c9545d);
                        cll cll;
                        String r;
                        if (c9545d.field_retCode != 0) {
                            C4990ab.m7413e(C9022l.this.TAG, "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", C9022l.this.fFa, Integer.valueOf(c9545d.field_retCode), c9545d);
                            if (c9545d.field_retCode == CdnLogic.kErrSafeProtoNoAeskey) {
                                C4990ab.m7421w(C9022l.this.TAG, "summersafecdn cdntra  ERR_CDNCOM_SAFEPROTO_NOAESKEY clientid:%s, enableHitcheck:%b", C9022l.this.fFa, Boolean.valueOf(C9022l.this.fFs));
                                C1720g.m3537RQ();
                                C1720g.m3539RS().mo10302aa(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.m2504i(78322);
                                        C9022l.this.fFs = false;
                                        C9022l.this.startTime = 0;
                                        C9022l.this.startOffset = 0;
                                        C25822e d = C9022l.m16312d(C9022l.this);
                                        d.mo43795lr(0);
                                        C9022l.this.csG.mo14775eJ(C1829bf.m3756oC(C9022l.this.csG.field_talker));
                                        C9022l.this.fFa = C37458c.m63162a("upimg", C9022l.this.csG.field_createTime, C9022l.this.csG.field_talker, C9022l.this.csG.field_msgId + "_" + C9022l.this.eFm + "_" + C9022l.this.fDC);
                                        boolean a = C9022l.m16305a(C9022l.this, d, 0, 0, 0, c9545d);
                                        clk clk = (clk) C9022l.this.ehh.fsG.fsP;
                                        if (clk == null) {
                                            C4990ab.m7420w(C9022l.this.TAG, "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again but old req is null");
                                        } else {
                                            clk.xja = new bts().alV(C9022l.this.fFa);
                                        }
                                        C4990ab.m7417i(C9022l.this.TAG, "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again enableHitcheck[%b], ret[%b] new clientid[%s] createtime[%d]", Boolean.valueOf(C9022l.this.fFs), Boolean.valueOf(a), C9022l.this.fFa, Long.valueOf(C9022l.this.csG.field_createTime));
                                        C9022l.this.mo4456a(C9022l.this.ftf, C9022l.this.ehi);
                                        AppMethodBeat.m2505o(78322);
                                    }
                                });
                                AppMethodBeat.m2505o(78325);
                                return 0;
                            } else if (c9545d.field_retCode == CdnLogic.kErrUploadHevcIllegal) {
                                C4990ab.m7420w(C9022l.this.TAG, "upload hevc failed try jpg");
                                C1720g.m3539RS().mo10302aa(new C90212());
                                AppMethodBeat.m2505o(78325);
                                return 0;
                            } else {
                                cll = null;
                                if (!C5046bo.m7540cb(c9545d.field_sKeyrespbuf)) {
                                    cll = new cll();
                                    try {
                                        cll.parseFrom(c9545d.field_sKeyrespbuf);
                                        C4990ab.m7411d(C9022l.this.TAG, "parse skeyrespbuf: ret:%d,msg:%s", Integer.valueOf(cll.BaseResponse.Ret), cll.BaseResponse.ErrMsg.toString());
                                    } catch (IOException e) {
                                        th = e;
                                        cll = null;
                                        C4990ab.m7413e(C9022l.this.TAG, "UploadMsgImgResponse parse fail: %s", th);
                                        C4990ab.m7413e(C9022l.this.TAG, "exception:%s", C5046bo.m7574l(th));
                                    } catch (C6092b e2) {
                                        th = e2;
                                        cll = null;
                                        C4990ab.m7413e(C9022l.this.TAG, "UploadMsgImgResponse parse UninitializedMessageException: %s", th);
                                        C4990ab.m7413e(C9022l.this.TAG, "exception:%s", C5046bo.m7574l(th));
                                    }
                                }
                                C45161i.m83149lC((int) C9022l.this.fEX);
                                C45161i.m83148lB((int) C9022l.this.fEX);
                                Object[] objArr2 = new Object[16];
                                objArr2[0] = Integer.valueOf(c9545d.field_retCode);
                                objArr2[1] = Integer.valueOf(1);
                                objArr2[2] = Long.valueOf(C9022l.this.startTime);
                                objArr2[3] = Long.valueOf(C5046bo.anU());
                                objArr2[4] = Integer.valueOf(C37458c.m63165bW(C4996ah.getContext()));
                                objArr2[5] = Integer.valueOf(C9022l.this.fFb);
                                objArr2[6] = Integer.valueOf(c9545d.field_fileLength);
                                objArr2[7] = c9545d.field_transInfo;
                                objArr2[8] = "";
                                objArr2[9] = "";
                                objArr2[10] = "";
                                objArr2[11] = "";
                                objArr2[12] = "";
                                objArr2[13] = "";
                                objArr2[14] = "";
                                objArr2[15] = c9545d == null ? "" : C9022l.m16331sp(c9545d.efY);
                                r = C46180a.m86311r(objArr2);
                                new C9514f(r).ajK();
                                new C42099d(r).ajK();
                                if (cll == null || cll.BaseResponse.Ret == 0) {
                                    C9022l.this.ehi.onSceneEnd(3, c9545d.field_retCode, "", C9022l.this);
                                } else {
                                    C9022l.this.ehi.onSceneEnd(4, cll.BaseResponse.Ret, cll.BaseResponse.ErrMsg.toString(), C9022l.this);
                                }
                                if (C9022l.this.fFv != null) {
                                    C9022l.this.fFv.agX();
                                }
                            }
                        } else {
                            int i2;
                            C4990ab.m7417i(C9022l.this.TAG, "summersafecdn uploadMsgImg by cdn, UploadHitCacheType: %d, needSendMsg:%b", Integer.valueOf(c9545d.field_UploadHitCacheType), Boolean.valueOf(c9545d.field_needSendMsgField));
                            C7060h c7060h = C7060h.pYm;
                            Object[] objArr3 = new Object[3];
                            if (d.cvd == 0) {
                                i2 = 3;
                            } else {
                                i2 = d.cvd;
                            }
                            objArr3[0] = Integer.valueOf(i2);
                            objArr3[1] = C9022l.this.fFq;
                            objArr3[2] = Integer.valueOf(c9545d.field_UploadHitCacheType);
                            c7060h.mo8381e(13230, objArr3);
                            String v = C9022l.this.fFw;
                            str2 = "";
                            C17931a sg = C37478f.m63229sg(v);
                            if (sg == null || C5046bo.isNullOrNil(sg.appId)) {
                                r = str2;
                            } else {
                                r = C37478f.m63228c(sg.appId, sg.mediaTagName, sg.messageExt, sg.messageAction);
                            }
                            if (C5046bo.isNullOrNil(v)) {
                                str2 = (("<msg><img aeskey=\"" + c9545d.field_aesKey + "\" cdnmidimgurl=\"" + c9545d.field_fileId + "\" cdnbigimgurl=\"" + c9545d.field_fileId + "\" ") + "cdnthumburl=\"" + c9545d.field_fileId + "\" cdnthumbaeskey=\"" + c9545d.field_aesKey + "\" cdnthumblength=\"" + c9545d.field_thumbimgLength + "\" ") + "length=\"" + (c9545d.field_midimgLength == 0 ? c9545d.field_fileLength : c9545d.field_midimgLength) + "\" hdlength=\"" + c9545d.field_fileLength + "\"/>" + r + "</msg>";
                                C4990ab.m7417i(C9022l.this.TAG, "cdn callback new build cdnInfo:%s", str2);
                            } else {
                                Map z2 = C5049br.m7595z(v, "msg");
                                if (z2 != null) {
                                    if (d.fDC == 0) {
                                        str2 = (("<msg><img aeskey=\"" + ((String) z2.get(".msg.img.$aeskey")) + "\" cdnmidimgurl=\"" + c9545d.field_fileId + "\" cdnbigimgurl=\"" + ((String) z2.get(".msg.img.$cdnbigimgurl")) + "\" ") + "cdnthumburl=\"" + ((String) z2.get(".msg.img.$cdnthumburl")) + "\" cdnthumbaeskey=\"" + ((String) z2.get(".msg.img.$cdnthumbaeskey")) + "\" cdnthumblength=\"" + ((String) z2.get(".msg.img.cdnthumblength")) + "\" ") + "length=\"" + (c9545d.field_midimgLength == 0 ? c9545d.field_fileLength : c9545d.field_midimgLength) + "\" hdlength=\"" + ((String) z2.get(".msg.img.$hdlength")) + "\"/>" + r + "</msg>";
                                    } else {
                                        str2 = (("<msg><img aeskey=\"" + ((String) z2.get(".msg.img.$aeskey")) + "\" cdnmidimgurl=\"" + ((String) z2.get(".msg.img.$cdnmidimgurl")) + "\" cdnbigimgurl=\"" + c9545d.field_fileId + "\" ") + "cdnthumburl=\"" + ((String) z2.get(".msg.img.$cdnthumburl")) + "\" cdnthumbaeskey=\"" + ((String) z2.get(".msg.img.$cdnthumbaeskey")) + "\" cdnthumblength=\"" + ((String) z2.get(".msg.img.cdnthumblength")) + "\" ") + "length=\"" + ((String) z2.get(".msg.img.$length")) + "\" hdlength=\"" + c9545d.field_fileLength + "\"/>" + r + "</msg>";
                                    }
                                    C4990ab.m7417i(C9022l.this.TAG, "cdn callback rebuild cdnInfo:%s", str2);
                                } else {
                                    str2 = v;
                                }
                            }
                            if (c9545d.mo20809Jm()) {
                                if (C5046bo.isNullOrNil(C9022l.this.fFB)) {
                                    C4990ab.m7420w(C9022l.this.TAG, "summersafecdn sceneResult isUploadBySafeCDNWithMD5 but prepareResponse AESKey is null");
                                } else {
                                    str2 = (("<msg><img aeskey=\"" + C9022l.this.fFB + "\" cdnmidimgurl=\"" + c9545d.field_fileId + "\" cdnbigimgurl=\"" + c9545d.field_fileId + "\" ") + "cdnthumburl=\"" + c9545d.field_fileId + "\" cdnthumbaeskey=\"" + C9022l.this.fFB + "\" ") + "length=\"" + c9545d.field_midimgLength + "\" hdlength=\"" + c9545d.field_fileLength + "\"/>" + r + "</msg>";
                                }
                            }
                            d.mo43806se(str2);
                            C9022l.this.fFx = str2;
                            if (C9022l.this.fEX != C9022l.this.eFm) {
                                C9022l.m16313e(C9022l.this).mo43806se(str2);
                            }
                            if (c9545d.field_needSendMsgField) {
                                C1720g.m3535RO().eJo.mo14541a(new C6326m(C9022l.this.eFn, (clk) C9022l.this.ehh.fsG.fsP, d, c9545d, new C6327a() {
                                    /* renamed from: a */
                                    public final void mo4586a(long j, int i, int i2, int i3) {
                                        AppMethodBeat.m2504i(78324);
                                        new C9514f(C46180a.m86311r(Integer.valueOf(i3), Integer.valueOf(1), Long.valueOf(C9022l.this.startTime), Long.valueOf(C5046bo.anU()), Integer.valueOf(C37458c.m63165bW(C4996ah.getContext())), Integer.valueOf(C9022l.this.fFb), Integer.valueOf(c9545d.field_fileLength), c9545d.field_transInfo, "", "", "", "", "", "", "", C9022l.m16331sp(c9545d.efY))).ajK();
                                        C4990ab.m7417i(C9022l.this.TAG, "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", C9022l.this.fFa, Integer.valueOf(i2), Integer.valueOf(i3));
                                        if (i2 == 0 && i3 == 0) {
                                            C9022l.m16305a(C9022l.this, d, d.frO, j, i, c9545d);
                                            AppMethodBeat.m2505o(78324);
                                            return;
                                        }
                                        C45161i.m83149lC((int) C9022l.this.fEX);
                                        C45161i.m83148lB((int) C9022l.this.fEX);
                                        C9022l.this.ehi.onSceneEnd(i2, i3, "", C9022l.this);
                                        if (C9022l.this.fFv != null) {
                                            C9022l.this.fFv.agX();
                                        }
                                        AppMethodBeat.m2505o(78324);
                                    }
                                }), 0);
                            } else {
                                new C9514f(C46180a.m86311r(Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(C9022l.this.startTime), Long.valueOf(C5046bo.anU()), Integer.valueOf(C37458c.m63165bW(C4996ah.getContext())), Integer.valueOf(C9022l.this.fFb), Integer.valueOf(c9545d.field_fileLength), c9545d.field_transInfo, "", "", "", "", "", "", "", C9022l.m16331sp(c9545d.efY))).ajK();
                                cll = new cll();
                                try {
                                    cll.parseFrom(c9545d.field_sKeyrespbuf);
                                    long j = cll.ptF != 0 ? cll.ptF : (long) cll.ptD;
                                    C4990ab.m7411d(C9022l.this.TAG, "parse skeyrespbuf: ret:%d,msg:%s", Integer.valueOf(cll.BaseResponse.Ret), cll.BaseResponse.ErrMsg.toString());
                                    if (C9022l.m16305a(C9022l.this, d, d.frO, j, cll.pcX, c9545d)) {
                                        C9022l.this.ehi.onSceneEnd(0, 0, "", C9022l.this);
                                        if (C9022l.this.fFv != null) {
                                            C9022l.this.fFv.agX();
                                        }
                                    }
                                    AppMethodBeat.m2505o(78325);
                                    return 0;
                                } catch (IOException e3) {
                                    C4990ab.m7413e(C9022l.this.TAG, "UploadMsgImgResponse parse fail: %s", e3);
                                    C4990ab.m7413e(C9022l.this.TAG, "exception:%s", C5046bo.m7574l(e3));
                                    C9022l.this.ehi.onSceneEnd(3, c9545d.field_retCode, "", C9022l.this);
                                    if (C9022l.this.fFv != null) {
                                        C9022l.this.fFv.agX();
                                    }
                                }
                            }
                        }
                    }
                    AppMethodBeat.m2505o(78325);
                    return 0;
                }
            }
        }

        /* renamed from: a */
        public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            AppMethodBeat.m2504i(78326);
            clk clk = (clk) C9022l.this.ehh.fsG.fsP;
            C44147my c44147my = new C44147my();
            c44147my.vRl = clk.xja.wVI;
            c44147my.ndG = clk.vEB.wVI;
            c44147my.ndF = clk.vEC.wVI;
            c44147my.vRm = clk.xjh;
            c44147my.vRn = clk.xji;
            c44147my.Scene = C9022l.this.scene;
            c44147my.vRp = C9022l.this.fFz;
            c44147my.vRq = C9022l.this.cEB;
            c44147my.vRr = C9022l.this.fFA;
            c44147my.vEG = clk.vEG;
            c44147my.vRw = C9022l.this.fFr;
            c44147my.fKh = clk.fKh;
            c44147my.vCs = clk.vCs;
            c44147my.vCu = clk.vCu;
            c44147my.vCt = clk.vCt;
            C25822e d = C9022l.m16312d(C9022l.this);
            String q = C32291o.ahl().mo73118q(d.fDz, "", "");
            C37461f.afy();
            c44147my.vRy = C8941a.m16129rI(q);
            c44147my.vRz = d.fDD;
            if (c44147my.vRz <= 0) {
                c44147my.vRz = C9022l.this.eFn == 4 ? 2 : 1;
            }
            switch (C9022l.this.eFn) {
                case 1:
                case 2:
                    c44147my.vFH = 1;
                    break;
                case 4:
                    c44147my.vFH = 3;
                    break;
                case 6:
                    c44147my.vFH = 5;
                    break;
                default:
                    c44147my.vFH = 2;
                    break;
            }
            if (c44147my.vRz == 3) {
                c44147my.vFH = 4;
            }
            C4990ab.m7417i(C9022l.this.TAG, "getCdnAuthInfo: mediaid:%s thumbwidth:%d, thumbheight:%d,MsgSource:%s,touser:%s aeskey[%s], imgLocalId[%d], msgLocalId[%d], getBigImgPath()[%s], fullpath[%s], prereq.CRC32[%d] prereq.MsgForwardType[%d], prereq.Source[%d]", str, Integer.valueOf(c44147my.vRm), Integer.valueOf(c44147my.vRn), c44147my.vEG, c44147my.ndF, c44147my.vRw, Long.valueOf(C9022l.this.eFm), Long.valueOf(C9022l.this.fDH), d.fDz, q, Integer.valueOf(c44147my.vRy), Integer.valueOf(c44147my.vRz), Integer.valueOf(c44147my.vFH));
            C1196a c1196a = new C1196a();
            c1196a.fsJ = c44147my;
            c1196a.fsK = new cll();
            c1196a.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
            c1196a.fsI = 625;
            c1196a.fsL = 9;
            c1196a.fsM = 1000000009;
            C7472b acD = c1196a.acD();
            C1898c adg = C9022l.this.ftf.adg();
            String f = C9022l.this.TAG;
            String str2 = "getCdnAuthInfo login:%s";
            Object[] objArr = new Object[1];
            objArr[0] = adg == null ? "acc == null" : Boolean.valueOf(adg.adb());
            C4990ab.m7417i(f, str2, objArr);
            if (adg == null || !adg.adb()) {
                C4990ab.m7413e(C9022l.this.TAG, "getCdnAuthInfo accinfo return null. clientimgid:%s", c44147my.vRl);
                AppMethodBeat.m2505o(78326);
                return;
            }
            if (C7475t.m12874a(adg.mo5490jQ(1), adg.ada(), adg.adc(), acD.acF(), byteArrayOutputStream, adg.ade())) {
                C4990ab.m7411d(C9022l.this.TAG, "getCdnAuthInfo successed.clientimgid:%s", c44147my.vRl);
                AppMethodBeat.m2505o(78326);
                return;
            }
            C4990ab.m7413e(C9022l.this.TAG, "getCdnAuthInfo failed. clientimgid:%s", c44147my.vRl);
            AppMethodBeat.m2505o(78326);
        }

        /* renamed from: l */
        public final byte[] mo5084l(String str, byte[] bArr) {
            AppMethodBeat.m2504i(78327);
            PInt pInt = new PInt();
            btd c46567mz = new C46567mz();
            try {
                byte[] a = C7477v.m12892a(bArr, C1720g.m3535RO().eJo.ftA.adg().mo5490jQ(1), pInt, c46567mz);
                C4990ab.m7417i(C9022l.this.TAG, "decodePrepareResponse aeskey[%s], fileid[%s], clientimgid[%s]", c46567mz.vRw, c46567mz.vRA, c46567mz.vRl);
                C9022l.this.fFB = c46567mz.vRw;
                C4990ab.m7417i(C9022l.this.TAG, "decodePrepareResponse, clientmediaid:%s, ret:%d", str, Integer.valueOf(pInt.value));
                AppMethodBeat.m2505o(78327);
                return a;
            } catch (Exception e) {
                C4990ab.m7413e(C9022l.this.TAG, "decodePrepareResponse Exception:%s", e);
                C9022l.this.fFB = null;
                AppMethodBeat.m2505o(78327);
                return null;
            }
        }
    }

    /* renamed from: d */
    static /* synthetic */ C25822e m16312d(C9022l c9022l) {
        AppMethodBeat.m2504i(78348);
        C25822e agY = c9022l.agY();
        AppMethodBeat.m2505o(78348);
        return agY;
    }

    /* renamed from: e */
    static /* synthetic */ C25822e m16313e(C9022l c9022l) {
        AppMethodBeat.m2504i(78349);
        C25822e agZ = c9022l.agZ();
        AppMethodBeat.m2505o(78349);
        return agZ;
    }

    private C25822e agY() {
        AppMethodBeat.m2504i(78331);
        if (this.eFo == null) {
            this.eFo = C32291o.ahl().mo73105b(Long.valueOf(this.eFm));
        }
        C25822e c25822e = this.eFo;
        AppMethodBeat.m2505o(78331);
        return c25822e;
    }

    private C25822e agZ() {
        AppMethodBeat.m2504i(78332);
        if (this.fFt == null) {
            this.fFt = C32291o.ahl().mo73105b(Long.valueOf(this.fEX));
        }
        C25822e c25822e = this.fFt;
        AppMethodBeat.m2505o(78332);
        return c25822e;
    }

    public C9022l(String str, String str2, String str3, int i) {
        this(str, str2, str3, i, "", "");
    }

    public C9022l(String str, String str2, String str3, int i, C32231g c32231g, int i2, C9028a c9028a) {
        this(3, str, str2, str3, i, c32231g, i2, "", "", true, C25738R.drawable.b0p);
        AppMethodBeat.m2504i(78333);
        this.fFv = new C9023b(c9028a);
        AppMethodBeat.m2505o(78333);
    }

    private C9022l(String str, String str2, String str3, int i, String str4, String str5) {
        this(4, str, str2, str3, i, null, 0, str4, str5, false, -1);
    }

    public C9022l(int i, String str, String str2, String str3, int i2, C32231g c32231g, int i3, String str4, String str5, boolean z, int i4) {
        this(i, str, str2, str3, i2, c32231g, i3, str4, str5, z, i4, 0, -1000.0f, -1000.0f, -1);
    }

    public C9022l(int i, String str, String str2, String str3, int i2, C32231g c32231g, int i3, String str4, String str5, boolean z, int i4, int i5, float f, float f2, long j) {
        AppMethodBeat.m2504i(78334);
        this.TAG = "MicroMsg.NetSceneUploadMsgImg";
        this.fFq = "";
        this.fFr = "";
        this.fFs = true;
        this.fFu = 16384;
        this.fDC = 0;
        this.csG = null;
        this.fEZ = null;
        this.fFa = "";
        this.startTime = 0;
        this.startOffset = -1;
        this.fFb = 0;
        this.fFv = new C9023b(null);
        this.fFk = new C90294();
        this.eFu = false;
        C4990ab.m7417i(this.TAG, "dkupimg init uploadsrc:%d from:%s to:%s ori:%s cmptype:%d prog:%s rotate:%d cdn:%s thumb:%s chatt:%b , res:%d run:%b [%s], scene: %d, longtitude: %f, latitude: %f", Integer.valueOf(i), str, str2, str3, Integer.valueOf(i2), c32231g, Integer.valueOf(i3), str4, str5, Boolean.valueOf(z), Integer.valueOf(i4), Boolean.TRUE, C5046bo.dpG(), Integer.valueOf(i5), Float.valueOf(f), Float.valueOf(f2));
        this.fFy = z;
        this.fFe = i4;
        this.fEW = c32231g;
        this.fDC = i2;
        this.scene = i5;
        this.cEB = f2;
        this.fFz = f;
        this.eFn = i;
        this.fFC = str3;
        PString pString = new PString();
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        this.fFw = str4;
        pString.value = str5;
        String str6 = null;
        if (j > 0) {
            str6 = C32291o.ahl().mo73118q(C32291o.ahl().mo73105b(Long.valueOf(j)).fDE, "", "");
        }
        this.fEX = C32291o.ahl().mo73080a(str3, str6, i2, i, i3, pString, pInt, pInt2, "", "", -1, null, null, null);
        this.eFm = this.fEX;
        C4990ab.m7416i(this.TAG, "FROM A UI :" + str2 + " " + this.fEX);
        if (this.fEX < 0 || !C45161i.m83147lA((int) this.fEX)) {
            C4990ab.m7412e(this.TAG, "insert to img storage failed id:" + this.fEX);
            this.fDH = -1;
            this.ehh = null;
            AppMethodBeat.m2505o(78334);
            return;
        }
        C25822e agY;
        int i6;
        Assert.assertTrue(this.fEX >= 0);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new clk();
        c1196a.fsK = new cll();
        c1196a.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
        c1196a.fsI = 110;
        c1196a.fsL = 9;
        c1196a.fsM = 1000000009;
        this.ehh = c1196a.acD();
        this.cMr = str2;
        this.csG = new C7620bi();
        this.csG.setType(C1855t.m3926nL(str2));
        this.csG.mo14794ju(str2);
        this.csG.mo14781hO(1);
        this.csG.setStatus(1);
        this.csG.mo14795jv(pString.value);
        this.csG.mo14784hZ(pInt.value);
        this.csG.mo14786ia(pInt2.value);
        this.csG.mo14775eJ(C1829bf.m3756oC(this.csG.field_talker));
        this.csG.setContent(str4);
        C26350a.m41930KG().mo35238g(this.csG);
        this.fDH = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15281Z(this.csG);
        Assert.assertTrue(this.fDH >= 0);
        C4990ab.m7416i(this.TAG, "NetSceneUploadMsgImg: local msgId = " + this.fDH);
        C25822e agZ = agZ();
        agZ.mo43793fG((long) ((int) this.fDH));
        C32291o.ahl().mo73077a(Long.valueOf(this.fEX), agZ);
        if (i2 == 1) {
            this.eFm = (long) agZ.fDJ;
            agY = agY();
        } else {
            agY = agZ;
        }
        agY.mo43797lt(C1173e.m2560cs(C32291o.ahl().mo73118q(agY.fDz, "", "")));
        C32291o.ahl().mo73077a(Long.valueOf(this.eFm), agY);
        C4990ab.m7416i(this.TAG, "NetSceneUploadMsgImg: local imgId = " + this.eFm + " img len = " + agY.frO);
        clk clk = (clk) this.ehh.fsG.fsP;
        clk.vEB = new bts().alV(str);
        clk.vEC = new bts().alV(str2);
        clk.ptx = agY.offset;
        clk.ptw = agY.frO;
        clk.nao = this.csG.getType();
        clk.wqw = i2;
        if (C32856ab.m53750ch(C4996ah.getContext())) {
            i6 = 1;
        } else {
            i6 = 2;
        }
        clk.vZF = i6;
        clk.xbN = agY.cvd;
        clk.vRz = agY.fDD;
        clk.xjh = pInt2.value;
        clk.xji = pInt.value;
        C17931a sg = C37478f.m63229sg(str4);
        if (!(sg == null || C5046bo.isNullOrNil(sg.appId))) {
            clk.fKh = sg.appId;
            clk.vCs = sg.mediaTagName;
            clk.vCu = sg.messageAction;
            clk.vCt = sg.messageExt;
        }
        C4990ab.m7417i(this.TAG, "LINE237 thumb.width:%d,thumb.height:%d", Integer.valueOf(clk.xjh), Integer.valueOf(clk.xji));
        if (clk.vRz == 0) {
            clk.vRz = i == 4 ? 2 : 1;
        }
        C4990ab.m7411d(this.TAG, "dkimgsource: %d, forwardtype:%d", Integer.valueOf(agY.cvd), Integer.valueOf(clk.vRz));
        if (agY.offset == 0) {
            this.fEZ = new C42220h(110, true, (long) agY.frO);
        }
        long currentTimeMillis = System.currentTimeMillis();
        mo20458lD(i2);
        C4990ab.m7411d(this.TAG, "hy: create HDThumb using %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        if (c32231g != null) {
            final int i7 = agY.offset;
            final int i8 = agY.frO;
            final C32231g c32231g2 = c32231g;
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(78320);
                    c32231g2.mo8280a(i7, i8, C9022l.this);
                    AppMethodBeat.m2505o(78320);
                }
            });
        }
        AppMethodBeat.m2505o(78334);
    }

    public C9022l(long j, String str, String str2, String str3, int i, C32231g c32231g, int i2, String str4, String str5) {
        C25822e agY;
        String str6;
        AppMethodBeat.m2504i(78335);
        this.TAG = "MicroMsg.NetSceneUploadMsgImg";
        this.fFq = "";
        this.fFr = "";
        this.fFs = true;
        this.fFu = 16384;
        this.fDC = 0;
        this.csG = null;
        this.fEZ = null;
        this.fFa = "";
        this.startTime = 0;
        this.startOffset = -1;
        this.fFb = 0;
        this.fFv = new C9023b(null);
        this.fFk = new C90294();
        this.eFu = false;
        C4990ab.m7417i(this.TAG, "dkupimg init id:%d uploadsrc:%d from:%s to:%s ori:%s cmptype:%d prog:%s rotate:%d cdn:%s thumb:%s chatt:%b , res:%d run:%b [%s]", Long.valueOf(j), Integer.valueOf(3), str, str2, str3, Integer.valueOf(i), c32231g, Integer.valueOf(i2), str4, str5, Boolean.TRUE, Integer.valueOf(C25738R.drawable.b0p), Boolean.TRUE, C5046bo.dpG());
        this.fFy = true;
        this.fFe = C25738R.drawable.b0p;
        this.fEW = c32231g;
        this.fDC = i;
        this.eFn = 3;
        this.fFC = str3;
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        this.fFw = str4;
        this.fEX = j;
        this.eFm = this.fEX;
        C25822e agZ = agZ();
        this.csG = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(agZ.fDH);
        this.fDH = this.csG.field_msgId;
        pInt2.value = this.csG.dJx;
        pInt.value = this.csG.dJw;
        if (i == 1) {
            this.eFm = (long) agZ.fDJ;
            this.eFo = null;
            agY = agY();
        } else {
            agY = agZ;
        }
        if (this.csG.field_talker == null || this.csG.field_talker.equals(str2)) {
            str6 = str2;
        } else {
            C4990ab.m7413e(this.TAG, "fatal!! Send user mis-match, want:%s, fact:%s", str2, this.csG.field_talker);
            C7060h.pYm.mo8378a(594, 4, 1, true);
            str6 = this.csG.field_talker;
        }
        C4990ab.m7416i(this.TAG, "NetSceneUploadMsgImg: local msgId = " + this.csG.field_msgId);
        C4990ab.m7410d(this.TAG, "FROM A UI :" + str2 + "   msg:" + str6 + this.fEX);
        if (this.fEX < 0 || !C45161i.m83147lA((int) this.fEX)) {
            C4990ab.m7412e(this.TAG, "insert to img storage failed id:" + this.fEX);
            this.fDH = -1;
            this.ehh = null;
            AppMethodBeat.m2505o(78335);
            return;
        }
        int i3;
        Assert.assertTrue(this.fEX >= 0);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new clk();
        c1196a.fsK = new cll();
        c1196a.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
        c1196a.fsI = 110;
        c1196a.fsL = 9;
        c1196a.fsM = 1000000009;
        this.ehh = c1196a.acD();
        C4990ab.m7416i(this.TAG, "NetSceneUploadMsgImg: local imgId = " + this.eFm + " img len = " + agY.frO);
        clk clk = (clk) this.ehh.fsG.fsP;
        clk.vEB = new bts().alV(str);
        clk.vEC = new bts().alV(str6);
        clk.ptx = agY.offset;
        clk.ptw = agY.frO;
        clk.nao = this.csG.getType();
        clk.wqw = i;
        if (C32856ab.m53750ch(C4996ah.getContext())) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        clk.vZF = i3;
        clk.xbN = agY.cvd;
        clk.vRz = agY.fDD;
        clk.xjh = pInt2.value;
        clk.xji = pInt.value;
        C4990ab.m7417i(this.TAG, "LINE350 thumb.width:%d,thumb.height:%d", Integer.valueOf(clk.xjh), Integer.valueOf(clk.xji));
        if (clk.vRz == 0) {
            clk.vRz = 1;
        }
        C4990ab.m7411d(this.TAG, "dkimgsource: %d, forwardtype:%d", Integer.valueOf(agY.cvd), Integer.valueOf(clk.vRz));
        if (agY.offset == 0) {
            this.fEZ = new C42220h(110, true, (long) agY.frO);
        }
        final int i4 = agY.offset;
        i3 = agY.frO;
        final C32231g c32231g2 = c32231g;
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(78321);
                c32231g2.mo8280a(i4, i3, C9022l.this);
                AppMethodBeat.m2505o(78321);
            }
        });
        AppMethodBeat.m2505o(78335);
    }

    /* renamed from: lD */
    public final void mo20458lD(int i) {
        int i2 = 1;
        AppMethodBeat.m2504i(78336);
        if (this.csG == null) {
            C4990ab.m7421w(this.TAG, "createHDThumb but msg is null msgLocalId[%d], compressType[%d]", Long.valueOf(this.fDH), Integer.valueOf(i));
            AppMethodBeat.m2505o(78336);
            return;
        }
        if (!this.fFy) {
            C32291o.ahl().mo73087a(this.csG.field_imgPath, C1338a.getDensity(C4996ah.getContext()), true);
        } else if (this.csG.dJA == 0) {
            boolean a = C32291o.ahl().mo73099a(this.csG, this.fFe, i);
            C7620bi c7620bi = this.csG;
            if (!a) {
                i2 = 0;
            }
            c7620bi.mo14788ic(i2);
            ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(this.fDH, this.csG);
            AppMethodBeat.m2505o(78336);
            return;
        }
        AppMethodBeat.m2505o(78336);
    }

    public C9022l(int i, int i2) {
        AppMethodBeat.m2504i(78337);
        this.TAG = "MicroMsg.NetSceneUploadMsgImg";
        this.fFq = "";
        this.fFr = "";
        this.fFs = true;
        this.fFu = 16384;
        this.fDC = 0;
        this.csG = null;
        this.fEZ = null;
        this.fFa = "";
        this.startTime = 0;
        this.startOffset = -1;
        this.fFb = 0;
        this.fFv = new C9023b(null);
        this.fFk = new C90294();
        this.eFu = false;
        C4990ab.m7417i(this.TAG, "dkupimg init id:%d cmptype:%d  [%s]", Integer.valueOf(i), Integer.valueOf(i2), C5046bo.dpG());
        this.fEX = (long) i;
        this.eFm = (long) i;
        this.fDC = i2;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new clk();
        c1196a.fsK = new cll();
        c1196a.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
        c1196a.fsI = 110;
        c1196a.fsL = 9;
        c1196a.fsM = 1000000009;
        this.ehh = c1196a.acD();
        this.fEW = null;
        C4990ab.m7410d(this.TAG, "FROM B SERVICE:" + this.fEX);
        if (C45161i.m83147lA((int) this.fEX)) {
            C25822e b;
            C25822e b2 = C32291o.ahl().mo73105b(Long.valueOf(this.fEX));
            this.fDH = b2.fDH;
            if (i2 == 1) {
                this.eFm = (long) b2.fDJ;
                b = C32291o.ahl().mo73105b(Long.valueOf(this.eFm));
            } else {
                b = b2;
            }
            b2 = C32291o.ahl().mo73117lz((int) b.fDy);
            if (b2 != null) {
                this.fDH = b2.fDH;
            }
            this.csG = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(this.fDH);
            if (this.csG == null || this.csG.field_msgId == this.fDH) {
                if (this.csG != null) {
                    int i3;
                    clk clk = (clk) this.ehh.fsG.fsP;
                    clk.vEB = new bts().alV(C1853r.m3846Yz());
                    clk.vEC = new bts().alV(this.csG.field_talker);
                    clk.ptx = b.offset;
                    clk.ptw = b.frO;
                    clk.nao = this.csG.getType();
                    clk.wqw = i2;
                    if (C32856ab.m53750ch(C4996ah.getContext())) {
                        i3 = 1;
                    } else {
                        i3 = 2;
                    }
                    clk.vZF = i3;
                    clk.xbN = b.cvd;
                    clk.vRz = b.fDD;
                    clk.vRz = b.fDD;
                    clk.xjh = this.csG.dJx;
                    clk.xji = this.csG.dJw;
                    C17931a sg = C37478f.m63229sg(this.csG.field_content);
                    if (!(sg == null || C5046bo.isNullOrNil(sg.appId))) {
                        this.eFn = b.cvd;
                        clk.fKh = sg.appId;
                        clk.vCs = sg.mediaTagName;
                        clk.vCu = sg.messageAction;
                        clk.vCt = sg.messageExt;
                        this.fFw = this.csG.field_content;
                    }
                    C4990ab.m7417i(this.TAG, "LINE425 thumb.width:%d,thumb.height:%d", Integer.valueOf(clk.xjh), Integer.valueOf(clk.xji));
                    C4990ab.m7411d(this.TAG, "dkimgsource: %d, forwardtype:%d", Integer.valueOf(b.cvd), Integer.valueOf(clk.vRz));
                    if (b.offset == 0) {
                        this.fEZ = new C42220h(110, true, (long) b.frO);
                    }
                }
                AppMethodBeat.m2505o(78337);
                return;
            }
            C4990ab.m7421w(this.TAG, "init get msg by id failed:%d", Long.valueOf(this.fDH));
            C7060h.pYm.mo8378a(111, 206, 1, false);
            this.csG = null;
            AppMethodBeat.m2505o(78337);
            return;
        }
        this.fEX = -1;
        AppMethodBeat.m2505o(78337);
    }

    public C9022l(int i, int i2, byte b) {
        AppMethodBeat.m2504i(78338);
        this.TAG = "MicroMsg.NetSceneUploadMsgImg";
        this.fFq = "";
        this.fFr = "";
        this.fFs = true;
        this.fFu = 16384;
        this.fDC = 0;
        this.csG = null;
        this.fEZ = null;
        this.fFa = "";
        this.startTime = 0;
        this.startOffset = -1;
        this.fFb = 0;
        this.fFv = new C9023b(null);
        this.fFk = new C90294();
        this.eFu = false;
        C4990ab.m7417i(this.TAG, "dkupimg init id:%d cmptype:%d pro:%s  [%s]", Integer.valueOf(i), Integer.valueOf(i2), null, C5046bo.dpG());
        this.fEX = (long) i;
        this.eFm = (long) i;
        this.fDC = i2;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new clk();
        c1196a.fsK = new cll();
        c1196a.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
        c1196a.fsI = 110;
        c1196a.fsL = 9;
        c1196a.fsM = 1000000009;
        this.ehh = c1196a.acD();
        this.fEW = null;
        C4990ab.m7410d(this.TAG, "FROM C SERVICE:" + this.fEX);
        if (C45161i.m83147lA((int) this.fEX)) {
            C25822e b2;
            C25822e b3 = C32291o.ahl().mo73105b(Long.valueOf(this.fEX));
            this.fDH = b3.fDH;
            b3.setStatus(0);
            b3.mo43792eI(0);
            b3.setOffset(0);
            C32291o.ahl().mo73076a((int) this.eFm, b3);
            if (i2 == 1) {
                this.eFm = (long) b3.fDJ;
                b2 = C32291o.ahl().mo73105b(Long.valueOf(this.eFm));
            } else {
                b2 = b3;
            }
            this.csG = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(this.fDH);
            if (this.csG != null) {
                int i3;
                this.csG.setStatus(1);
                String str = b2.fDB;
                if (str == null || !str.startsWith("THUMBNAIL_DIRPATH://")) {
                    this.csG.mo14795jv("THUMBNAIL://" + b2.fDy);
                } else {
                    this.csG.mo14795jv(str);
                }
                ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(this.fDH, this.csG);
                clk clk = (clk) this.ehh.fsG.fsP;
                clk.vEB = new bts().alV(C1853r.m3846Yz());
                clk.vEC = new bts().alV(this.csG.field_talker);
                clk.ptx = b2.offset;
                clk.ptw = b2.frO;
                clk.nao = this.csG.getType();
                clk.wqw = i2;
                if (C32856ab.m53750ch(C4996ah.getContext())) {
                    i3 = 1;
                } else {
                    i3 = 2;
                }
                clk.vZF = i3;
                clk.xbN = b2.cvd;
                clk.vRz = b2.fDD;
                clk.xjh = this.csG.dJx;
                clk.xji = this.csG.dJw;
                C4990ab.m7417i(this.TAG, "LINE492 thumb.width:%d,thumb.height:%d", Integer.valueOf(clk.xjh), Integer.valueOf(clk.xji));
                C4990ab.m7411d(this.TAG, "dkimgsource: %d, forwardtype:%d", Integer.valueOf(b2.cvd), Integer.valueOf(clk.vRz));
                if (b2.offset == 0) {
                    this.fEZ = new C42220h(110, true, (long) b2.frO);
                }
            }
            AppMethodBeat.m2505o(78338);
            return;
        }
        this.fEX = -1;
        AppMethodBeat.m2505o(78338);
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
    }

    /* renamed from: a */
    private boolean m16302a(C25822e c25822e, int i) {
        AppMethodBeat.m2504i(78339);
        if (C1855t.m3924nJ(this.csG.field_talker)) {
            C4990ab.m7421w(this.TAG, "cdntra not use cdn user:%s", this.csG.field_talker);
            AppMethodBeat.m2505o(78339);
            return false;
        }
        C37461f.afx();
        if (!C31259b.m50439lg(1) && C5046bo.isNullOrNil(c25822e.fDK)) {
            r2 = new Object[2];
            C37461f.afx();
            r2[0] = Boolean.valueOf(C31259b.m50439lg(1));
            r2[1] = c25822e.fDK;
            C4990ab.m7421w(this.TAG, "cdntra not use cdn flag:%b getCdnInfo:%s", r2);
            AppMethodBeat.m2505o(78339);
            return false;
        } else if (C5046bo.isNullOrNil(this.fFa)) {
            C4990ab.m7421w(this.TAG, "cdntra genClientId failed not use cdn imgLocalId:%d", Long.valueOf(this.eFm));
            AppMethodBeat.m2505o(78339);
            return false;
        } else {
            String q = C32291o.ahl().mo73118q(c25822e.fDz, "", "");
            String q2 = C32291o.ahl().mo73118q(c25822e.fDA, "", "");
            String q3 = C32291o.ahl().mo73118q(c25822e.fDB, "", "");
            String q4 = C32291o.ahl().mo73118q(c25822e.fDE, "", "");
            C42130g c42130g = new C42130g();
            c42130g.egl = this.fFk;
            c42130g.field_mediaId = this.fFa;
            c42130g.field_fileType = this.fFb;
            c42130g.field_talker = this.csG.field_talker;
            c42130g.field_chattype = C1855t.m3896kH(this.csG.field_talker) ? 1 : 0;
            c42130g.field_priority = C42129a.efC;
            c42130g.field_needStorage = false;
            c42130g.field_isStreamMedia = false;
            c42130g.field_sendmsg_viacdn = true;
            c42130g.field_enable_hitcheck = this.fFs;
            c42130g.field_force_aeskeycdn = false;
            c42130g.field_trysafecdn = true;
            if (i == CdnLogic.kErrUploadHevcIllegal) {
                this.fFa = C37458c.m63162a("upimgjpg", this.csG.field_createTime, this.csG.field_talker, this.csG.field_msgId + "_" + this.eFm + "_" + this.fDC);
                c42130g.field_fullpath = q;
                c42130g.field_thumbpath = q3;
                c42130g.field_midimgpath = q2;
                c42130g.lastError = i;
                c42130g.field_mediaId = this.fFa;
            } else {
                boolean z;
                boolean biZ = ((C27730c) C1720g.m3528K(C27730c.class)).biZ();
                if (this.eFn == 4 && C5730e.m8628ct(q4)) {
                    z = biZ;
                } else {
                    q4 = ((C27730c) C1720g.m3528K(C27730c.class)).mo45564IP(q);
                    z = this.fDC == 0 && !C5063r.amq(q).equals(".png") && m16306aL(q, q4);
                    if (z) {
                        c25822e.mo43810sf(((C27730c) C1720g.m3528K(C27730c.class)).mo45564IP(c25822e.fDz));
                    }
                }
                String IP = ((C27730c) C1720g.m3528K(C27730c.class)).mo45564IP(q2);
                boolean aL = m16306aL(q2, IP);
                if (!z) {
                    q4 = q;
                }
                c42130g.field_fullpath = q4;
                c42130g.field_thumbpath = q3;
                if (!aL) {
                    IP = q2;
                }
                c42130g.field_midimgpath = IP;
                q4 = this.TAG;
                q = "hevc upload full size %b, use hevc %b, %b";
                Object[] objArr = new Object[3];
                if (c42130g.field_fileType == C42129a.MediaType_FULLSIZEIMAGE) {
                    biZ = true;
                } else {
                    biZ = false;
                }
                objArr[0] = Boolean.valueOf(biZ);
                objArr[1] = Boolean.valueOf(z);
                objArr[2] = Boolean.valueOf(aL);
                C4990ab.m7411d(q4, q, objArr);
            }
            if (c42130g.field_fileType == C42129a.MediaType_FULLSIZEIMAGE && C5046bo.isNullOrNil(c42130g.field_midimgpath)) {
                C37461f.afx();
                if (C31259b.m50439lg(256)) {
                    C4990ab.m7420w(this.TAG, "summersafecdn send fullsizeimage but midimgpath is null set field_force_aeskeycdn true");
                    c42130g.field_force_aeskeycdn = true;
                    c42130g.field_trysafecdn = false;
                }
            }
            Map z2 = C5049br.m7595z(this.fFw, "msg");
            if (z2 != null) {
                if (this.fDC != 1) {
                    c42130g.field_fileId = (String) z2.get(".msg.img.$cdnmidimgurl");
                    c42130g.field_midFileLength = C5046bo.getInt((String) z2.get(".msg.img.$length"), 0);
                    c42130g.field_totalLen = 0;
                } else {
                    c42130g.field_fileId = (String) z2.get(".msg.img.$cdnbigimgurl");
                    c42130g.field_midFileLength = C5046bo.getInt((String) z2.get(".msg.img.$length"), 0);
                    c42130g.field_totalLen = 0;
                }
                c42130g.field_aesKey = (String) z2.get(".msg.img.$aeskey");
            } else {
                C4990ab.m7417i(this.TAG, "parse cdnInfo failed. [%s]", c25822e.fDK);
            }
            if (C5046bo.isNullOrNil(c42130g.field_aesKey)) {
                C37461f.afy();
                c42130g.field_aesKey = C8941a.afp();
                C4990ab.m7417i(this.TAG, "summersafecdn cdntra oldAeskey is null and gen new[%s]", c42130g.field_aesKey);
            }
            C4990ab.m7417i(this.TAG, "dkupimg src:%d fileid:%s", Integer.valueOf(c25822e.cvd), c42130g.field_fileId);
            this.fFq = c42130g.field_fileId;
            this.fFr = c42130g.field_aesKey;
            C4990ab.m7411d(this.TAG, "summersafecdn checkUseCdn field_enable_hitcheck[%b], field_fileType[%d], field_midimgpath[%s], field_fullpath[%s], aeskey[%s], fileid[%s], enable_hitcheck[%b], aeskeycdn[%b], trysafecdn[%b]", Boolean.valueOf(c42130g.field_enable_hitcheck), Integer.valueOf(c42130g.field_fileType), c42130g.field_midimgpath, c42130g.field_fullpath, c42130g.field_aesKey, c42130g.field_fileId, Boolean.valueOf(c42130g.field_enable_hitcheck), Boolean.valueOf(c42130g.field_force_aeskeycdn), Boolean.valueOf(c42130g.field_trysafecdn));
            this.fFB = null;
            if (C37461f.afx().mo51225e(c42130g)) {
                if (C5046bo.nullAsNil(c25822e.fDK).length() <= 0) {
                    c25822e.mo43806se("CDNINFO_SEND");
                    c25822e.bJt = 4096;
                }
                AppMethodBeat.m2505o(78339);
                return true;
            }
            C7060h.pYm.mo8378a(111, 205, 1, false);
            C4990ab.m7413e(this.TAG, "cdntra addSendTask failed. clientid:%s", this.fFa);
            this.fFa = "";
            AppMethodBeat.m2505o(78339);
            return false;
        }
    }

    /* renamed from: aL */
    private boolean m16306aL(String str, String str2) {
        AppMethodBeat.m2504i(78340);
        if (((C27730c) C1720g.m3528K(C27730c.class)).biZ()) {
            if (C5730e.asZ(str) > 0) {
                if (C5730e.asZ(str2) > 0) {
                    C7060h.pYm.mo15419k(944, 9, 1);
                    C5730e.deleteFile(str2);
                }
                if (!C5730e.m8628ct(str2)) {
                    C5730e.atc(str2);
                }
                if (((C27730c) C1720g.m3528K(C27730c.class)).mo45569dF(str, str2) == 0) {
                    AppMethodBeat.m2505o(78340);
                    return true;
                }
                C4990ab.m7421w(this.TAG, "file to hevc failed %s", str);
            }
            AppMethodBeat.m2505o(78340);
            return false;
        }
        AppMethodBeat.m2505o(78340);
        return false;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(78341);
        C1720g.m3537RQ();
        C1720g.m3539RS().mo10310m(new C90275(), 100);
        int lE;
        if (this.eFm < 0) {
            C7060h.pYm.mo8378a(111, 204, 1, false);
            C4990ab.m7412e(this.TAG, "doScene invalid imgLocalId:" + this.eFm);
            lE = m16323lE(-1);
            AppMethodBeat.m2505o(78341);
            return lE;
        } else if (this.csG == null) {
            C7060h.pYm.mo8378a(111, 203, 1, false);
            C4990ab.m7413e(this.TAG, "doScene msg is null imgid:%d", Long.valueOf(this.eFm));
            C45161i.m83149lC((int) this.fEX);
            lE = m16323lE(-2);
            AppMethodBeat.m2505o(78341);
            return lE;
        } else {
            this.ehi = c1202f;
            mo4470c(c1902e);
            clk clk = (clk) this.ehh.fsG.fsP;
            C25822e agY = agY();
            C25822e lz = C32291o.ahl().mo73117lz((int) agY.fDy);
            if (lz != null) {
                if (lz.status == -1) {
                    C7060h.pYm.mo8378a(111, 202, 1, false);
                    C4990ab.m7412e(this.TAG, "doScene hd img info is null or error.");
                    lE = m16323lE(-3);
                    AppMethodBeat.m2505o(78341);
                    return lE;
                }
            } else if (agY == null || agY.status == -1) {
                C4990ab.m7412e(this.TAG, "doScene img info is null or error.");
                lE = m16323lE(-4);
                AppMethodBeat.m2505o(78341);
                return lE;
            }
            if (C26350a.m41930KG().mo35240kq(this.csG.field_talker)) {
                clk.vEG = C26350a.m41930KG().mo35239h(this.csG);
            } else {
                String aae = C1831bh.aae();
                if (!(aae == null || aae.equals(this.csG.dqJ)) || (aae == null && !C5046bo.isNullOrNil(this.csG.dqJ))) {
                    this.csG.mo14791ix(aae);
                    ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(this.csG.field_msgId, this.csG);
                }
                clk.vEG = this.csG.dqJ;
            }
            String q = C32291o.ahl().mo73118q(agY.fDz, "", "");
            String q2 = C32291o.ahl().mo73118q(agY.fDB, "", "");
            if (!C5046bo.isNullOrNil(agY.fDA)) {
                C32291o.ahl().mo73118q(agY.fDA, "", "");
            }
            if (C1173e.m2560cs(q) <= 0 || C1173e.m2560cs(q2) <= 0) {
                C4990ab.m7413e(this.TAG, "doScene invalid imgLocalId:%d filesize:[%d,%d] %s %s", Long.valueOf(this.eFm), Integer.valueOf(C1173e.m2560cs(q)), Integer.valueOf(C1173e.m2560cs(q2)), q, q2);
                lE = m16323lE(-5);
                AppMethodBeat.m2505o(78341);
                return lE;
            }
            if (clk.xja == null || C5046bo.isNullOrNil(clk.xja.wVI)) {
                if (C5046bo.isNullOrNil(this.fFa)) {
                    C4990ab.m7417i(this.TAG, "createMediaId time:%d talker:%s msg:%d img:%d compressType:%d", Long.valueOf(this.csG.field_createTime), this.csG.field_talker, Long.valueOf(this.csG.field_msgId), Long.valueOf(this.eFm), Integer.valueOf(this.fDC));
                    this.fFa = C37458c.m63162a("upimg", this.csG.field_createTime, this.csG.field_talker, this.csG.field_msgId + "_" + this.eFm + "_" + this.fDC);
                }
                clk.xja = new bts().alV(this.fFa);
                C7620bi c7620bi = this.csG;
                c7620bi.dJC = this.fFa;
                c7620bi.dqp = true;
            }
            if (this.startTime == 0) {
                this.startTime = C5046bo.anU();
                this.startOffset = agY.offset;
                this.fFb = this.fDC == 1 ? C42129a.MediaType_FULLSIZEIMAGE : C42129a.MediaType_IMAGE;
            }
            C4990ab.m7417i(this.TAG, "before checkUseCdn %s, %s, imgBitPath:%s", q, q2, agY.fDz);
            if (m16302a(agY, 0)) {
                C4990ab.m7411d(this.TAG, "cdntra use cdn return -1 for onGYNetEnd clientid:%s", clk.xja.wVI);
                AppMethodBeat.m2505o(78341);
                return 0;
            }
            C4990ab.m7416i(this.TAG, "after checkUseCdn, it use cgi to upload image.");
            int i = agY.fDI;
            if (i >= acn()) {
                C7060h.pYm.mo8378a(111, 201, 1, false);
                C4990ab.m7412e(this.TAG, "doScene limit net time:".concat(String.valueOf(i)));
                C45161i.m83149lC((int) this.fEX);
                lE = m16323lE(-6);
                AppMethodBeat.m2505o(78341);
                return lE;
            }
            agY.mo43795lr(i + 1);
            agY.bJt = 512;
            C32291o.ahl().mo73077a(Long.valueOf(this.eFm), agY);
            int i2 = agY.frO - agY.offset;
            if (i2 > this.fFu) {
                i2 = this.fFu;
            }
            C1173e.m2560cs(q);
            byte[] e = C1173e.m2569e(q, agY.offset, i2);
            if (e == null || e.length <= 0) {
                C7060h.pYm.mo8378a(111, 199, 1, false);
                C4990ab.m7412e(this.TAG, "doScene, file read buf error.");
                lE = m16323lE(-8);
                AppMethodBeat.m2505o(78341);
                return lE;
            }
            clk.pty = e.length;
            clk.ptx = agY.offset;
            clk.ptz = new SKBuiltinBuffer_t().setBuffer(e);
            if (this.fEZ != null) {
                this.fEZ.akj();
            }
            lE = mo4457a(c1902e, this.ehh, this);
            if (lE < 0) {
                C4990ab.m7412e(this.TAG, "doScene netId error");
                C45161i.m83149lC((int) this.fEX);
                lE = m16323lE(-9);
                AppMethodBeat.m2505o(78341);
                return lE;
            }
            AppMethodBeat.m2505o(78341);
            return lE;
        }
    }

    /* renamed from: lE */
    private int m16323lE(int i) {
        AppMethodBeat.m2504i(78342);
        C4990ab.m7412e(this.TAG, "do Scene error code : " + i + " hashcode : " + hashCode());
        if (this.fFv != null) {
            this.fFv.agX();
        }
        AppMethodBeat.m2505o(78342);
        return -1;
    }

    public final int getType() {
        return 110;
    }

    public final int acn() {
        if (this.fDC == 0) {
            return 100;
        }
        return 1350;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(78343);
        cll cll = (cll) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7416i(this.TAG, "cdntra onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " useCdnTransClientId:" + this.fFa);
        if (i2 == 3 && i3 == -1 && !C5046bo.isNullOrNil(this.fFa)) {
            C4990ab.m7421w(this.TAG, "cdntra using cdn trans,  wait cdn service callback! clientid:%s", this.fFa);
            AppMethodBeat.m2505o(78343);
        } else if (i2 == 0 && i3 == 0) {
            this.fFu = cll.pty;
            if (this.fFu > 16384) {
                this.fFu = 16384;
            }
            C25822e agY = agY();
            C4990ab.m7418v(this.TAG, "onGYNetEnd localId:" + this.eFm + "  totalLen:" + agY.frO + " offSet:" + agY.offset);
            if (cll.ptx < 0 || (cll.ptx > agY.frO && agY.frO > 0)) {
                C7060h.pYm.mo8378a(111, 197, 1, false);
                C4990ab.m7412e(this.TAG, "onGYNetEnd invalid server return value : startPos = " + cll.ptx + " img totalLen = " + agY.frO);
                C45161i.m83149lC((int) this.fEX);
                C45161i.m83148lB((int) this.fEX);
                C7060h.pYm.mo8381e(10420, Integer.valueOf(-2), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(C5046bo.anU()), Integer.valueOf(C37458c.m63165bW(C4996ah.getContext())), Integer.valueOf(this.fFb), Integer.valueOf(0));
                this.ehi.onSceneEnd(4, -2, "", this);
                if (this.fFv != null) {
                    this.fFv.agX();
                }
                AppMethodBeat.m2505o(78343);
            } else if (cll.ptx < agY.offset || (C37478f.m63226b(agY) && this.fFu <= 0)) {
                C4990ab.m7412e(this.TAG, "onGYNetEnd invalid data startPos = " + cll.ptx + " totalLen = " + agY.frO + " off:" + agY.offset);
                C45161i.m83149lC((int) this.fEX);
                C45161i.m83148lB((int) this.fEX);
                this.ehi.onSceneEnd(4, -1, "", this);
                if (this.fFv != null) {
                    this.fFv.agX();
                }
                AppMethodBeat.m2505o(78343);
            } else {
                C4990ab.m7410d("ImgInfoLogic", "resp.rImpl.getStartPos() " + cll.ptx);
                if (m16303a(agY, cll.ptx, cll.ptF, cll.pcX, null) && mo4456a(this.ftf, this.ehi) < 0) {
                    C45161i.m83148lB((int) this.fEX);
                    this.ehi.onSceneEnd(3, -1, "", this);
                    if (this.fFv != null) {
                        this.fFv.agX();
                    }
                }
                AppMethodBeat.m2505o(78343);
            }
        } else {
            C4990ab.m7412e(this.TAG, "onGYNetEnd failed errtype:" + i2 + " errcode:" + i3);
            C7060h.pYm.mo8378a(111, 198, 1, false);
            C45161i.m83149lC((int) this.fEX);
            C45161i.m83148lB((int) this.fEX);
            C7060h.pYm.mo8381e(10420, Integer.valueOf(i3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(C5046bo.anU()), Integer.valueOf(C37458c.m63165bW(C4996ah.getContext())), Integer.valueOf(this.fFb), Integer.valueOf(0));
            this.ehi.onSceneEnd(i2, i3, str, this);
            if (this.fFv != null) {
                this.fFv.agX();
            }
            AppMethodBeat.m2505o(78343);
        }
    }

    public final void aha() {
        AppMethodBeat.m2504i(78344);
        C4990ab.m7416i(this.TAG, "send img from system");
        this.eFu = true;
        AppMethodBeat.m2505o(78344);
    }

    /* renamed from: a */
    private boolean m16303a(C25822e c25822e, int i, long j, int i2, C9545d c9545d) {
        AppMethodBeat.m2504i(78345);
        C4990ab.m7411d(this.TAG, "cdntra clientid:%s start:%d svrid:%d createtime:%d", this.fFa, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2));
        C4990ab.m7417i(this.TAG, "dkmsgid  set svrmsgid %d -> %d  oriImgLocalId %s imgLocalId %s", Long.valueOf(j), Integer.valueOf(C1947ae.giA), Long.valueOf(this.fEX), Long.valueOf(this.eFm));
        if (CdnLogic.kMediaTypeFavoriteBigFile == C1947ae.giz && C1947ae.giA != 0) {
            j = (long) C1947ae.giA;
            C1947ae.giA = 0;
        }
        m16311c(c25822e.fDy, i, c25822e.frO);
        c25822e.setOffset(i);
        c25822e.mo43792eI(j);
        if (C37478f.m63226b(c25822e) && this.fEX != this.eFm) {
            C25822e b = C32291o.ahl().mo73105b(Long.valueOf(this.fEX));
            b.mo43792eI(j);
            b.mo43797lt(c25822e.frO);
            b.setOffset(c25822e.frO);
            C32291o.ahl().mo73077a(Long.valueOf(this.fEX), b);
        }
        if (C37478f.m63226b(c25822e)) {
            if (C5046bo.isNullOrNil(this.fFa)) {
                C7060h.pYm.mo8381e(10420, Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(C5046bo.anU()), Integer.valueOf(C37458c.m63165bW(C4996ah.getContext())), Integer.valueOf(this.fFb), Integer.valueOf(c25822e.frO - this.startOffset));
            }
            this.csG.setStatus(2);
            this.csG.mo14774eI(j);
            ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(this.fDH, this.csG);
            if (C45458r.fUq != null) {
                C45458r.fUq.mo67753j(this.csG);
            }
            if (this.fEZ != null) {
                this.fEZ.mo67750fS(0);
            }
            if (C32295r.fGF != null) {
                C32295r.fGF.mo43816a(this.eFm, this.csG, this.ehh, this.eFn, this.eFu, c9545d);
            }
            if (this.fFv != null) {
                this.fFv.agX();
            }
            this.ehi.onSceneEnd(0, 0, "", this);
            C45161i.m83148lB((int) this.fEX);
            AppMethodBeat.m2505o(78345);
            return false;
        }
        AppMethodBeat.m2505o(78345);
        return true;
    }

    /* renamed from: c */
    private void m16311c(long j, int i, int i2) {
        AppMethodBeat.m2504i(78346);
        if (this.fEW != null) {
            final long j2 = j;
            final int i3 = i2;
            final int i4 = i;
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    C32288d c32288d;
                    AppMethodBeat.m2504i(78329);
                    C32290n ahb = C32290n.ahb();
                    long j = j2;
                    long j2 = (long) i3;
                    long j3 = (long) i4;
                    if (ahb.fFL.containsKey(Long.valueOf(j))) {
                        c32288d = (C32288d) ahb.fFL.get(Long.valueOf(j));
                    } else {
                        c32288d = new C32288d();
                    }
                    c32288d.f15015xb = j3;
                    c32288d.cET = j2;
                    ahb.fFL.put(Long.valueOf(j), c32288d);
                    C9022l.this.fEW.mo8280a(i4, i3, C9022l.this);
                    AppMethodBeat.m2505o(78329);
                }
            });
        }
        AppMethodBeat.m2505o(78346);
    }

    /* renamed from: fK */
    public static void m16316fK(long j) {
        fFD = j;
    }

    /* renamed from: sp */
    public static String m16331sp(String str) {
        AppMethodBeat.m2504i(78347);
        try {
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(78347);
            } else {
                String[] split = str.split(",");
                if (split == null || split.length <= 19) {
                    AppMethodBeat.m2505o(78347);
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    long j = fFD;
                    fFD = -1;
                    split[19] = stringBuilder.append(j).toString();
                    str = C5046bo.m7536c(C5046bo.m7508P(split), ",");
                    AppMethodBeat.m2505o(78347);
                }
            }
        } catch (Exception e) {
            AppMethodBeat.m2505o(78347);
        }
        return str;
    }
}

package com.tencent.mm.at;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.g;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.t;
import com.tencent.mm.ai.v;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.r;
import com.tencent.mm.modelstat.h;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.clk;
import com.tencent.mm.protocal.protobuf.cll;
import com.tencent.mm.protocal.protobuf.my;
import com.tencent.mm.protocal.protobuf.mz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.bi;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class l extends m implements k {
    public static boolean DEBUG = true;
    private static long fFD;
    private String TAG;
    private float cEB;
    public String cMr;
    public bi csG;
    private long eFm;
    private int eFn;
    private e eFo;
    private boolean eFu;
    private final com.tencent.mm.ai.b ehh;
    private f ehi;
    private int fDC;
    private long fDH;
    private final g fEW;
    public long fEX;
    private h fEZ;
    private String fFA;
    private String fFB;
    public String fFC;
    private String fFa;
    private int fFb;
    private int fFe;
    private com.tencent.mm.i.g.a fFk;
    private String fFq;
    private String fFr;
    private boolean fFs;
    private e fFt;
    private int fFu;
    b fFv;
    private String fFw;
    public String fFx;
    public boolean fFy;
    private float fFz;
    private int scene;
    private int startOffset;
    private long startTime;

    class b {
        public a fFI;

        /* Access modifiers changed, original: final */
        public final void agX() {
            e d;
            AppMethodBeat.i(78330);
            if (l.this.fEX == l.this.eFm) {
                d = l.d(l.this);
            } else {
                d = l.e(l.this);
            }
            if (d.fDL == 1) {
                com.tencent.mm.plugin.report.service.g.BO(23);
                com.tencent.mm.plugin.report.service.g.BO(21);
            }
            ab.i(l.this.TAG, "UploadEndWrapper onUploadEnd %s done", l.f(l.d(l.this)));
            if (o.ahl().a(Long.valueOf(l.this.eFm), l.d(l.this)) < 0) {
                ab.e(l.this.TAG, "update db failed local id:" + l.this.eFm + " server id:" + l.d(l.this).cKK);
                i.lC((int) l.this.fEX);
                i.lB((int) l.this.fEX);
                l.this.ehi.onSceneEnd(3, -1, "", l.this);
            }
            if (l.this.eFm != l.this.fEX) {
                ab.i(l.this.TAG, "UploadEndWrapper onUploadEnd OriImg %s done", l.f(l.e(l.this)));
                o.ahl().a(Long.valueOf(l.this.fEX), l.e(l.this));
            }
            if (com.tencent.mm.sdk.a.b.dnO() || com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED || com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_PURPLE) {
                List agV = o.ahl().agV();
                if (agV != null) {
                    for (int i = 0; i < agV.size(); i++) {
                        ab.i(l.this.TAG, "UploadEndWrapper onUploadEnd duminfo %s %s", Integer.valueOf(i), l.f((e) agV.get(i)));
                    }
                }
            }
            l.a(l.this, l.this.eFm);
            if (l.this.fEX != l.this.eFm) {
                l.a(l.this, l.this.fEX);
            }
            if (this.fFI != null) {
                this.fFI.agX();
            }
            l.this.lD(l.this.fDC);
            l.this.fFv = null;
            AppMethodBeat.o(78330);
        }

        public b(a aVar) {
            this.fFI = aVar;
        }
    }

    public interface a {
        void agX();
    }

    static /* synthetic */ e d(l lVar) {
        AppMethodBeat.i(78348);
        e agY = lVar.agY();
        AppMethodBeat.o(78348);
        return agY;
    }

    static /* synthetic */ e e(l lVar) {
        AppMethodBeat.i(78349);
        e agZ = lVar.agZ();
        AppMethodBeat.o(78349);
        return agZ;
    }

    private e agY() {
        AppMethodBeat.i(78331);
        if (this.eFo == null) {
            this.eFo = o.ahl().b(Long.valueOf(this.eFm));
        }
        e eVar = this.eFo;
        AppMethodBeat.o(78331);
        return eVar;
    }

    private e agZ() {
        AppMethodBeat.i(78332);
        if (this.fFt == null) {
            this.fFt = o.ahl().b(Long.valueOf(this.fEX));
        }
        e eVar = this.fFt;
        AppMethodBeat.o(78332);
        return eVar;
    }

    public l(String str, String str2, String str3, int i) {
        this(str, str2, str3, i, "", "");
    }

    public l(String str, String str2, String str3, int i, g gVar, int i2, a aVar) {
        this(3, str, str2, str3, i, gVar, i2, "", "", true, R.drawable.b0p);
        AppMethodBeat.i(78333);
        this.fFv = new b(aVar);
        AppMethodBeat.o(78333);
    }

    private l(String str, String str2, String str3, int i, String str4, String str5) {
        this(4, str, str2, str3, i, null, 0, str4, str5, false, -1);
    }

    public l(int i, String str, String str2, String str3, int i2, g gVar, int i3, String str4, String str5, boolean z, int i4) {
        this(i, str, str2, str3, i2, gVar, i3, str4, str5, z, i4, 0, -1000.0f, -1000.0f, -1);
    }

    public l(int i, String str, String str2, String str3, int i2, g gVar, int i3, String str4, String str5, boolean z, int i4, int i5, float f, float f2, long j) {
        AppMethodBeat.i(78334);
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
        this.fFv = new b(null);
        this.fFk = new com.tencent.mm.i.g.a() {
            public final int a(String str, int i, c cVar, final d dVar, boolean z) {
                Throwable th;
                AppMethodBeat.i(78325);
                ab.d(l.this.TAG, "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", l.this.fFa, Integer.valueOf(i), cVar, dVar);
                String str2;
                if (i == -21005) {
                    ab.w(l.this.TAG, "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", l.this.fFa);
                    if (l.this.fFv != null) {
                        l.this.fFv.agX();
                    }
                    l.this.ehi.onSceneEnd(3, i, "", l.this);
                    AppMethodBeat.o(78325);
                    return 0;
                } else if (i != 0) {
                    ab.e(l.this.TAG, "cdntra cdnCallback clientid:%s startRet:%d", l.this.fFa, Integer.valueOf(i));
                    i.lC((int) l.this.fEX);
                    i.lB((int) l.this.fEX);
                    if (dVar != null) {
                        Object[] objArr = new Object[16];
                        objArr[0] = Integer.valueOf(i);
                        objArr[1] = Integer.valueOf(1);
                        objArr[2] = Long.valueOf(l.this.startTime);
                        objArr[3] = Long.valueOf(bo.anU());
                        objArr[4] = Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext()));
                        objArr[5] = Integer.valueOf(l.this.fFb);
                        objArr[6] = Integer.valueOf(dVar.field_fileLength);
                        objArr[7] = dVar.field_transInfo;
                        objArr[8] = "";
                        objArr[9] = "";
                        objArr[10] = "";
                        objArr[11] = "";
                        objArr[12] = "";
                        objArr[13] = "";
                        objArr[14] = "";
                        if (dVar == null) {
                            str2 = "";
                        } else {
                            str2 = l.sp(dVar.efY);
                        }
                        objArr[15] = str2;
                        new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.r(objArr)).ajK();
                    }
                    l.this.ehi.onSceneEnd(3, i, "", l.this);
                    if (l.this.fFv != null) {
                        l.this.fFv.agX();
                    }
                    AppMethodBeat.o(78325);
                    return 0;
                } else {
                    final e d = l.d(l.this);
                    if (d == null || d.fDy != l.this.eFm) {
                        com.tencent.mm.al.f.afx().rN(l.this.fFa);
                        ab.e(l.this.TAG, "cdntra get imginfo failed maybe delete by user imgLocalId:%d client:%s", Long.valueOf(l.this.eFm), l.this.fFa);
                        if (l.this.fFv != null) {
                            l.this.fFv.agX();
                        }
                        AppMethodBeat.o(78325);
                        return 0;
                    } else if (cVar != null) {
                        l.a(l.this, d, cVar.field_finishedLength, 0, 0, dVar);
                        AppMethodBeat.o(78325);
                        return 0;
                    } else {
                        if (dVar != null) {
                            ab.i(l.this.TAG, "dkupimg sceneResult:%s", dVar);
                            cll cll;
                            String r;
                            if (dVar.field_retCode != 0) {
                                ab.e(l.this.TAG, "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", l.this.fFa, Integer.valueOf(dVar.field_retCode), dVar);
                                if (dVar.field_retCode == CdnLogic.kErrSafeProtoNoAeskey) {
                                    ab.w(l.this.TAG, "summersafecdn cdntra  ERR_CDNCOM_SAFEPROTO_NOAESKEY clientid:%s, enableHitcheck:%b", l.this.fFa, Boolean.valueOf(l.this.fFs));
                                    com.tencent.mm.kernel.g.RQ();
                                    com.tencent.mm.kernel.g.RS().aa(new Runnable() {
                                        public final void run() {
                                            AppMethodBeat.i(78322);
                                            l.this.fFs = false;
                                            l.this.startTime = 0;
                                            l.this.startOffset = 0;
                                            e d = l.d(l.this);
                                            d.lr(0);
                                            l.this.csG.eJ(bf.oC(l.this.csG.field_talker));
                                            l.this.fFa = com.tencent.mm.al.c.a("upimg", l.this.csG.field_createTime, l.this.csG.field_talker, l.this.csG.field_msgId + "_" + l.this.eFm + "_" + l.this.fDC);
                                            boolean a = l.a(l.this, d, 0, 0, 0, dVar);
                                            clk clk = (clk) l.this.ehh.fsG.fsP;
                                            if (clk == null) {
                                                ab.w(l.this.TAG, "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again but old req is null");
                                            } else {
                                                clk.xja = new bts().alV(l.this.fFa);
                                            }
                                            ab.i(l.this.TAG, "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again enableHitcheck[%b], ret[%b] new clientid[%s] createtime[%d]", Boolean.valueOf(l.this.fFs), Boolean.valueOf(a), l.this.fFa, Long.valueOf(l.this.csG.field_createTime));
                                            l.this.a(l.this.ftf, l.this.ehi);
                                            AppMethodBeat.o(78322);
                                        }
                                    });
                                    AppMethodBeat.o(78325);
                                    return 0;
                                } else if (dVar.field_retCode == CdnLogic.kErrUploadHevcIllegal) {
                                    ab.w(l.this.TAG, "upload hevc failed try jpg");
                                    com.tencent.mm.kernel.g.RS().aa(new Runnable() {
                                        public final void run() {
                                            AppMethodBeat.i(78323);
                                            l.a(l.this, l.d(l.this));
                                            AppMethodBeat.o(78323);
                                        }
                                    });
                                    AppMethodBeat.o(78325);
                                    return 0;
                                } else {
                                    cll = null;
                                    if (!bo.cb(dVar.field_sKeyrespbuf)) {
                                        cll = new cll();
                                        try {
                                            cll.parseFrom(dVar.field_sKeyrespbuf);
                                            ab.d(l.this.TAG, "parse skeyrespbuf: ret:%d,msg:%s", Integer.valueOf(cll.BaseResponse.Ret), cll.BaseResponse.ErrMsg.toString());
                                        } catch (IOException e) {
                                            th = e;
                                            cll = null;
                                            ab.e(l.this.TAG, "UploadMsgImgResponse parse fail: %s", th);
                                            ab.e(l.this.TAG, "exception:%s", bo.l(th));
                                        } catch (e.a.a.b e2) {
                                            th = e2;
                                            cll = null;
                                            ab.e(l.this.TAG, "UploadMsgImgResponse parse UninitializedMessageException: %s", th);
                                            ab.e(l.this.TAG, "exception:%s", bo.l(th));
                                        }
                                    }
                                    i.lC((int) l.this.fEX);
                                    i.lB((int) l.this.fEX);
                                    Object[] objArr2 = new Object[16];
                                    objArr2[0] = Integer.valueOf(dVar.field_retCode);
                                    objArr2[1] = Integer.valueOf(1);
                                    objArr2[2] = Long.valueOf(l.this.startTime);
                                    objArr2[3] = Long.valueOf(bo.anU());
                                    objArr2[4] = Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext()));
                                    objArr2[5] = Integer.valueOf(l.this.fFb);
                                    objArr2[6] = Integer.valueOf(dVar.field_fileLength);
                                    objArr2[7] = dVar.field_transInfo;
                                    objArr2[8] = "";
                                    objArr2[9] = "";
                                    objArr2[10] = "";
                                    objArr2[11] = "";
                                    objArr2[12] = "";
                                    objArr2[13] = "";
                                    objArr2[14] = "";
                                    objArr2[15] = dVar == null ? "" : l.sp(dVar.efY);
                                    r = com.tencent.mm.plugin.report.a.r(objArr2);
                                    new com.tencent.mm.g.b.a.f(r).ajK();
                                    new com.tencent.mm.g.b.a.d(r).ajK();
                                    if (cll == null || cll.BaseResponse.Ret == 0) {
                                        l.this.ehi.onSceneEnd(3, dVar.field_retCode, "", l.this);
                                    } else {
                                        l.this.ehi.onSceneEnd(4, cll.BaseResponse.Ret, cll.BaseResponse.ErrMsg.toString(), l.this);
                                    }
                                    if (l.this.fFv != null) {
                                        l.this.fFv.agX();
                                    }
                                }
                            } else {
                                int i2;
                                ab.i(l.this.TAG, "summersafecdn uploadMsgImg by cdn, UploadHitCacheType: %d, needSendMsg:%b", Integer.valueOf(dVar.field_UploadHitCacheType), Boolean.valueOf(dVar.field_needSendMsgField));
                                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
                                Object[] objArr3 = new Object[3];
                                if (d.cvd == 0) {
                                    i2 = 3;
                                } else {
                                    i2 = d.cvd;
                                }
                                objArr3[0] = Integer.valueOf(i2);
                                objArr3[1] = l.this.fFq;
                                objArr3[2] = Integer.valueOf(dVar.field_UploadHitCacheType);
                                hVar.e(13230, objArr3);
                                String v = l.this.fFw;
                                str2 = "";
                                a sg = f.sg(v);
                                if (sg == null || bo.isNullOrNil(sg.appId)) {
                                    r = str2;
                                } else {
                                    r = f.c(sg.appId, sg.mediaTagName, sg.messageExt, sg.messageAction);
                                }
                                if (bo.isNullOrNil(v)) {
                                    str2 = (("<msg><img aeskey=\"" + dVar.field_aesKey + "\" cdnmidimgurl=\"" + dVar.field_fileId + "\" cdnbigimgurl=\"" + dVar.field_fileId + "\" ") + "cdnthumburl=\"" + dVar.field_fileId + "\" cdnthumbaeskey=\"" + dVar.field_aesKey + "\" cdnthumblength=\"" + dVar.field_thumbimgLength + "\" ") + "length=\"" + (dVar.field_midimgLength == 0 ? dVar.field_fileLength : dVar.field_midimgLength) + "\" hdlength=\"" + dVar.field_fileLength + "\"/>" + r + "</msg>";
                                    ab.i(l.this.TAG, "cdn callback new build cdnInfo:%s", str2);
                                } else {
                                    Map z2 = br.z(v, "msg");
                                    if (z2 != null) {
                                        if (d.fDC == 0) {
                                            str2 = (("<msg><img aeskey=\"" + ((String) z2.get(".msg.img.$aeskey")) + "\" cdnmidimgurl=\"" + dVar.field_fileId + "\" cdnbigimgurl=\"" + ((String) z2.get(".msg.img.$cdnbigimgurl")) + "\" ") + "cdnthumburl=\"" + ((String) z2.get(".msg.img.$cdnthumburl")) + "\" cdnthumbaeskey=\"" + ((String) z2.get(".msg.img.$cdnthumbaeskey")) + "\" cdnthumblength=\"" + ((String) z2.get(".msg.img.cdnthumblength")) + "\" ") + "length=\"" + (dVar.field_midimgLength == 0 ? dVar.field_fileLength : dVar.field_midimgLength) + "\" hdlength=\"" + ((String) z2.get(".msg.img.$hdlength")) + "\"/>" + r + "</msg>";
                                        } else {
                                            str2 = (("<msg><img aeskey=\"" + ((String) z2.get(".msg.img.$aeskey")) + "\" cdnmidimgurl=\"" + ((String) z2.get(".msg.img.$cdnmidimgurl")) + "\" cdnbigimgurl=\"" + dVar.field_fileId + "\" ") + "cdnthumburl=\"" + ((String) z2.get(".msg.img.$cdnthumburl")) + "\" cdnthumbaeskey=\"" + ((String) z2.get(".msg.img.$cdnthumbaeskey")) + "\" cdnthumblength=\"" + ((String) z2.get(".msg.img.cdnthumblength")) + "\" ") + "length=\"" + ((String) z2.get(".msg.img.$length")) + "\" hdlength=\"" + dVar.field_fileLength + "\"/>" + r + "</msg>";
                                        }
                                        ab.i(l.this.TAG, "cdn callback rebuild cdnInfo:%s", str2);
                                    } else {
                                        str2 = v;
                                    }
                                }
                                if (dVar.Jm()) {
                                    if (bo.isNullOrNil(l.this.fFB)) {
                                        ab.w(l.this.TAG, "summersafecdn sceneResult isUploadBySafeCDNWithMD5 but prepareResponse AESKey is null");
                                    } else {
                                        str2 = (("<msg><img aeskey=\"" + l.this.fFB + "\" cdnmidimgurl=\"" + dVar.field_fileId + "\" cdnbigimgurl=\"" + dVar.field_fileId + "\" ") + "cdnthumburl=\"" + dVar.field_fileId + "\" cdnthumbaeskey=\"" + l.this.fFB + "\" ") + "length=\"" + dVar.field_midimgLength + "\" hdlength=\"" + dVar.field_fileLength + "\"/>" + r + "</msg>";
                                    }
                                }
                                d.se(str2);
                                l.this.fFx = str2;
                                if (l.this.fEX != l.this.eFm) {
                                    l.e(l.this).se(str2);
                                }
                                if (dVar.field_needSendMsgField) {
                                    com.tencent.mm.kernel.g.RO().eJo.a(new m(l.this.eFn, (clk) l.this.ehh.fsG.fsP, d, dVar, new com.tencent.mm.at.m.a() {
                                        public final void a(long j, int i, int i2, int i3) {
                                            AppMethodBeat.i(78324);
                                            new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.r(Integer.valueOf(i3), Integer.valueOf(1), Long.valueOf(l.this.startTime), Long.valueOf(bo.anU()), Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext())), Integer.valueOf(l.this.fFb), Integer.valueOf(dVar.field_fileLength), dVar.field_transInfo, "", "", "", "", "", "", "", l.sp(dVar.efY))).ajK();
                                            ab.i(l.this.TAG, "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", l.this.fFa, Integer.valueOf(i2), Integer.valueOf(i3));
                                            if (i2 == 0 && i3 == 0) {
                                                l.a(l.this, d, d.frO, j, i, dVar);
                                                AppMethodBeat.o(78324);
                                                return;
                                            }
                                            i.lC((int) l.this.fEX);
                                            i.lB((int) l.this.fEX);
                                            l.this.ehi.onSceneEnd(i2, i3, "", l.this);
                                            if (l.this.fFv != null) {
                                                l.this.fFv.agX();
                                            }
                                            AppMethodBeat.o(78324);
                                        }
                                    }), 0);
                                } else {
                                    new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.r(Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(l.this.startTime), Long.valueOf(bo.anU()), Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext())), Integer.valueOf(l.this.fFb), Integer.valueOf(dVar.field_fileLength), dVar.field_transInfo, "", "", "", "", "", "", "", l.sp(dVar.efY))).ajK();
                                    cll = new cll();
                                    try {
                                        cll.parseFrom(dVar.field_sKeyrespbuf);
                                        long j = cll.ptF != 0 ? cll.ptF : (long) cll.ptD;
                                        ab.d(l.this.TAG, "parse skeyrespbuf: ret:%d,msg:%s", Integer.valueOf(cll.BaseResponse.Ret), cll.BaseResponse.ErrMsg.toString());
                                        if (l.a(l.this, d, d.frO, j, cll.pcX, dVar)) {
                                            l.this.ehi.onSceneEnd(0, 0, "", l.this);
                                            if (l.this.fFv != null) {
                                                l.this.fFv.agX();
                                            }
                                        }
                                        AppMethodBeat.o(78325);
                                        return 0;
                                    } catch (IOException e3) {
                                        ab.e(l.this.TAG, "UploadMsgImgResponse parse fail: %s", e3);
                                        ab.e(l.this.TAG, "exception:%s", bo.l(e3));
                                        l.this.ehi.onSceneEnd(3, dVar.field_retCode, "", l.this);
                                        if (l.this.fFv != null) {
                                            l.this.fFv.agX();
                                        }
                                    }
                                }
                            }
                        }
                        AppMethodBeat.o(78325);
                        return 0;
                    }
                }
            }

            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                AppMethodBeat.i(78326);
                clk clk = (clk) l.this.ehh.fsG.fsP;
                my myVar = new my();
                myVar.vRl = clk.xja.wVI;
                myVar.ndG = clk.vEB.wVI;
                myVar.ndF = clk.vEC.wVI;
                myVar.vRm = clk.xjh;
                myVar.vRn = clk.xji;
                myVar.Scene = l.this.scene;
                myVar.vRp = l.this.fFz;
                myVar.vRq = l.this.cEB;
                myVar.vRr = l.this.fFA;
                myVar.vEG = clk.vEG;
                myVar.vRw = l.this.fFr;
                myVar.fKh = clk.fKh;
                myVar.vCs = clk.vCs;
                myVar.vCu = clk.vCu;
                myVar.vCt = clk.vCt;
                e d = l.d(l.this);
                String q = o.ahl().q(d.fDz, "", "");
                com.tencent.mm.al.f.afy();
                myVar.vRy = com.tencent.mm.al.a.rI(q);
                myVar.vRz = d.fDD;
                if (myVar.vRz <= 0) {
                    myVar.vRz = l.this.eFn == 4 ? 2 : 1;
                }
                switch (l.this.eFn) {
                    case 1:
                    case 2:
                        myVar.vFH = 1;
                        break;
                    case 4:
                        myVar.vFH = 3;
                        break;
                    case 6:
                        myVar.vFH = 5;
                        break;
                    default:
                        myVar.vFH = 2;
                        break;
                }
                if (myVar.vRz == 3) {
                    myVar.vFH = 4;
                }
                ab.i(l.this.TAG, "getCdnAuthInfo: mediaid:%s thumbwidth:%d, thumbheight:%d,MsgSource:%s,touser:%s aeskey[%s], imgLocalId[%d], msgLocalId[%d], getBigImgPath()[%s], fullpath[%s], prereq.CRC32[%d] prereq.MsgForwardType[%d], prereq.Source[%d]", str, Integer.valueOf(myVar.vRm), Integer.valueOf(myVar.vRn), myVar.vEG, myVar.ndF, myVar.vRw, Long.valueOf(l.this.eFm), Long.valueOf(l.this.fDH), d.fDz, q, Integer.valueOf(myVar.vRy), Integer.valueOf(myVar.vRz), Integer.valueOf(myVar.vFH));
                com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
                aVar.fsJ = myVar;
                aVar.fsK = new cll();
                aVar.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
                aVar.fsI = 625;
                aVar.fsL = 9;
                aVar.fsM = 1000000009;
                com.tencent.mm.ai.b acD = aVar.acD();
                com.tencent.mm.network.c adg = l.this.ftf.adg();
                String f = l.this.TAG;
                String str2 = "getCdnAuthInfo login:%s";
                Object[] objArr = new Object[1];
                objArr[0] = adg == null ? "acc == null" : Boolean.valueOf(adg.adb());
                ab.i(f, str2, objArr);
                if (adg == null || !adg.adb()) {
                    ab.e(l.this.TAG, "getCdnAuthInfo accinfo return null. clientimgid:%s", myVar.vRl);
                    AppMethodBeat.o(78326);
                    return;
                }
                if (t.a(adg.jQ(1), adg.ada(), adg.adc(), acD.acF(), byteArrayOutputStream, adg.ade())) {
                    ab.d(l.this.TAG, "getCdnAuthInfo successed.clientimgid:%s", myVar.vRl);
                    AppMethodBeat.o(78326);
                    return;
                }
                ab.e(l.this.TAG, "getCdnAuthInfo failed. clientimgid:%s", myVar.vRl);
                AppMethodBeat.o(78326);
            }

            public final byte[] l(String str, byte[] bArr) {
                AppMethodBeat.i(78327);
                PInt pInt = new PInt();
                btd mzVar = new mz();
                try {
                    byte[] a = v.a(bArr, com.tencent.mm.kernel.g.RO().eJo.ftA.adg().jQ(1), pInt, mzVar);
                    ab.i(l.this.TAG, "decodePrepareResponse aeskey[%s], fileid[%s], clientimgid[%s]", mzVar.vRw, mzVar.vRA, mzVar.vRl);
                    l.this.fFB = mzVar.vRw;
                    ab.i(l.this.TAG, "decodePrepareResponse, clientmediaid:%s, ret:%d", str, Integer.valueOf(pInt.value));
                    AppMethodBeat.o(78327);
                    return a;
                } catch (Exception e) {
                    ab.e(l.this.TAG, "decodePrepareResponse Exception:%s", e);
                    l.this.fFB = null;
                    AppMethodBeat.o(78327);
                    return null;
                }
            }
        };
        this.eFu = false;
        ab.i(this.TAG, "dkupimg init uploadsrc:%d from:%s to:%s ori:%s cmptype:%d prog:%s rotate:%d cdn:%s thumb:%s chatt:%b , res:%d run:%b [%s], scene: %d, longtitude: %f, latitude: %f", Integer.valueOf(i), str, str2, str3, Integer.valueOf(i2), gVar, Integer.valueOf(i3), str4, str5, Boolean.valueOf(z), Integer.valueOf(i4), Boolean.TRUE, bo.dpG(), Integer.valueOf(i5), Float.valueOf(f), Float.valueOf(f2));
        this.fFy = z;
        this.fFe = i4;
        this.fEW = gVar;
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
            str6 = o.ahl().q(o.ahl().b(Long.valueOf(j)).fDE, "", "");
        }
        this.fEX = o.ahl().a(str3, str6, i2, i, i3, pString, pInt, pInt2, "", "", -1, null, null, null);
        this.eFm = this.fEX;
        ab.i(this.TAG, "FROM A UI :" + str2 + " " + this.fEX);
        if (this.fEX < 0 || !i.lA((int) this.fEX)) {
            ab.e(this.TAG, "insert to img storage failed id:" + this.fEX);
            this.fDH = -1;
            this.ehh = null;
            AppMethodBeat.o(78334);
            return;
        }
        e agY;
        int i6;
        Assert.assertTrue(this.fEX >= 0);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new clk();
        aVar.fsK = new cll();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
        aVar.fsI = 110;
        aVar.fsL = 9;
        aVar.fsM = 1000000009;
        this.ehh = aVar.acD();
        this.cMr = str2;
        this.csG = new bi();
        this.csG.setType(com.tencent.mm.model.t.nL(str2));
        this.csG.ju(str2);
        this.csG.hO(1);
        this.csG.setStatus(1);
        this.csG.jv(pString.value);
        this.csG.hZ(pInt.value);
        this.csG.ia(pInt2.value);
        this.csG.eJ(bf.oC(this.csG.field_talker));
        this.csG.setContent(str4);
        com.tencent.mm.l.a.a.KG().g(this.csG);
        this.fDH = ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().Z(this.csG);
        Assert.assertTrue(this.fDH >= 0);
        ab.i(this.TAG, "NetSceneUploadMsgImg: local msgId = " + this.fDH);
        e agZ = agZ();
        agZ.fG((long) ((int) this.fDH));
        o.ahl().a(Long.valueOf(this.fEX), agZ);
        if (i2 == 1) {
            this.eFm = (long) agZ.fDJ;
            agY = agY();
        } else {
            agY = agZ;
        }
        agY.lt(e.cs(o.ahl().q(agY.fDz, "", "")));
        o.ahl().a(Long.valueOf(this.eFm), agY);
        ab.i(this.TAG, "NetSceneUploadMsgImg: local imgId = " + this.eFm + " img len = " + agY.frO);
        clk clk = (clk) this.ehh.fsG.fsP;
        clk.vEB = new bts().alV(str);
        clk.vEC = new bts().alV(str2);
        clk.ptx = agY.offset;
        clk.ptw = agY.frO;
        clk.nao = this.csG.getType();
        clk.wqw = i2;
        if (com.tencent.mm.network.ab.ch(ah.getContext())) {
            i6 = 1;
        } else {
            i6 = 2;
        }
        clk.vZF = i6;
        clk.xbN = agY.cvd;
        clk.vRz = agY.fDD;
        clk.xjh = pInt2.value;
        clk.xji = pInt.value;
        a sg = f.sg(str4);
        if (!(sg == null || bo.isNullOrNil(sg.appId))) {
            clk.fKh = sg.appId;
            clk.vCs = sg.mediaTagName;
            clk.vCu = sg.messageAction;
            clk.vCt = sg.messageExt;
        }
        ab.i(this.TAG, "LINE237 thumb.width:%d,thumb.height:%d", Integer.valueOf(clk.xjh), Integer.valueOf(clk.xji));
        if (clk.vRz == 0) {
            clk.vRz = i == 4 ? 2 : 1;
        }
        ab.d(this.TAG, "dkimgsource: %d, forwardtype:%d", Integer.valueOf(agY.cvd), Integer.valueOf(clk.vRz));
        if (agY.offset == 0) {
            this.fEZ = new h(110, true, (long) agY.frO);
        }
        long currentTimeMillis = System.currentTimeMillis();
        lD(i2);
        ab.d(this.TAG, "hy: create HDThumb using %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        if (gVar != null) {
            final int i7 = agY.offset;
            final int i8 = agY.frO;
            final g gVar2 = gVar;
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(78320);
                    gVar2.a(i7, i8, l.this);
                    AppMethodBeat.o(78320);
                }
            });
        }
        AppMethodBeat.o(78334);
    }

    public l(long j, String str, String str2, String str3, int i, g gVar, int i2, String str4, String str5) {
        e agY;
        String str6;
        AppMethodBeat.i(78335);
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
        this.fFv = new b(null);
        this.fFk = /* anonymous class already generated */;
        this.eFu = false;
        ab.i(this.TAG, "dkupimg init id:%d uploadsrc:%d from:%s to:%s ori:%s cmptype:%d prog:%s rotate:%d cdn:%s thumb:%s chatt:%b , res:%d run:%b [%s]", Long.valueOf(j), Integer.valueOf(3), str, str2, str3, Integer.valueOf(i), gVar, Integer.valueOf(i2), str4, str5, Boolean.TRUE, Integer.valueOf(R.drawable.b0p), Boolean.TRUE, bo.dpG());
        this.fFy = true;
        this.fFe = R.drawable.b0p;
        this.fEW = gVar;
        this.fDC = i;
        this.eFn = 3;
        this.fFC = str3;
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        this.fFw = str4;
        this.fEX = j;
        this.eFm = this.fEX;
        e agZ = agZ();
        this.csG = ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().jf(agZ.fDH);
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
            ab.e(this.TAG, "fatal!! Send user mis-match, want:%s, fact:%s", str2, this.csG.field_talker);
            com.tencent.mm.plugin.report.service.h.pYm.a(594, 4, 1, true);
            str6 = this.csG.field_talker;
        }
        ab.i(this.TAG, "NetSceneUploadMsgImg: local msgId = " + this.csG.field_msgId);
        ab.d(this.TAG, "FROM A UI :" + str2 + "   msg:" + str6 + this.fEX);
        if (this.fEX < 0 || !i.lA((int) this.fEX)) {
            ab.e(this.TAG, "insert to img storage failed id:" + this.fEX);
            this.fDH = -1;
            this.ehh = null;
            AppMethodBeat.o(78335);
            return;
        }
        int i3;
        Assert.assertTrue(this.fEX >= 0);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new clk();
        aVar.fsK = new cll();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
        aVar.fsI = 110;
        aVar.fsL = 9;
        aVar.fsM = 1000000009;
        this.ehh = aVar.acD();
        ab.i(this.TAG, "NetSceneUploadMsgImg: local imgId = " + this.eFm + " img len = " + agY.frO);
        clk clk = (clk) this.ehh.fsG.fsP;
        clk.vEB = new bts().alV(str);
        clk.vEC = new bts().alV(str6);
        clk.ptx = agY.offset;
        clk.ptw = agY.frO;
        clk.nao = this.csG.getType();
        clk.wqw = i;
        if (com.tencent.mm.network.ab.ch(ah.getContext())) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        clk.vZF = i3;
        clk.xbN = agY.cvd;
        clk.vRz = agY.fDD;
        clk.xjh = pInt2.value;
        clk.xji = pInt.value;
        ab.i(this.TAG, "LINE350 thumb.width:%d,thumb.height:%d", Integer.valueOf(clk.xjh), Integer.valueOf(clk.xji));
        if (clk.vRz == 0) {
            clk.vRz = 1;
        }
        ab.d(this.TAG, "dkimgsource: %d, forwardtype:%d", Integer.valueOf(agY.cvd), Integer.valueOf(clk.vRz));
        if (agY.offset == 0) {
            this.fEZ = new h(110, true, (long) agY.frO);
        }
        final int i4 = agY.offset;
        i3 = agY.frO;
        final g gVar2 = gVar;
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(78321);
                gVar2.a(i4, i3, l.this);
                AppMethodBeat.o(78321);
            }
        });
        AppMethodBeat.o(78335);
    }

    public final void lD(int i) {
        int i2 = 1;
        AppMethodBeat.i(78336);
        if (this.csG == null) {
            ab.w(this.TAG, "createHDThumb but msg is null msgLocalId[%d], compressType[%d]", Long.valueOf(this.fDH), Integer.valueOf(i));
            AppMethodBeat.o(78336);
            return;
        }
        if (!this.fFy) {
            o.ahl().a(this.csG.field_imgPath, com.tencent.mm.bz.a.getDensity(ah.getContext()), true);
        } else if (this.csG.dJA == 0) {
            boolean a = o.ahl().a(this.csG, this.fFe, i);
            bi biVar = this.csG;
            if (!a) {
                i2 = 0;
            }
            biVar.ic(i2);
            ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().a(this.fDH, this.csG);
            AppMethodBeat.o(78336);
            return;
        }
        AppMethodBeat.o(78336);
    }

    public l(int i, int i2) {
        AppMethodBeat.i(78337);
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
        this.fFv = new b(null);
        this.fFk = /* anonymous class already generated */;
        this.eFu = false;
        ab.i(this.TAG, "dkupimg init id:%d cmptype:%d  [%s]", Integer.valueOf(i), Integer.valueOf(i2), bo.dpG());
        this.fEX = (long) i;
        this.eFm = (long) i;
        this.fDC = i2;
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new clk();
        aVar.fsK = new cll();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
        aVar.fsI = 110;
        aVar.fsL = 9;
        aVar.fsM = 1000000009;
        this.ehh = aVar.acD();
        this.fEW = null;
        ab.d(this.TAG, "FROM B SERVICE:" + this.fEX);
        if (i.lA((int) this.fEX)) {
            e b;
            e b2 = o.ahl().b(Long.valueOf(this.fEX));
            this.fDH = b2.fDH;
            if (i2 == 1) {
                this.eFm = (long) b2.fDJ;
                b = o.ahl().b(Long.valueOf(this.eFm));
            } else {
                b = b2;
            }
            b2 = o.ahl().lz((int) b.fDy);
            if (b2 != null) {
                this.fDH = b2.fDH;
            }
            this.csG = ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().jf(this.fDH);
            if (this.csG == null || this.csG.field_msgId == this.fDH) {
                if (this.csG != null) {
                    int i3;
                    clk clk = (clk) this.ehh.fsG.fsP;
                    clk.vEB = new bts().alV(r.Yz());
                    clk.vEC = new bts().alV(this.csG.field_talker);
                    clk.ptx = b.offset;
                    clk.ptw = b.frO;
                    clk.nao = this.csG.getType();
                    clk.wqw = i2;
                    if (com.tencent.mm.network.ab.ch(ah.getContext())) {
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
                    a sg = f.sg(this.csG.field_content);
                    if (!(sg == null || bo.isNullOrNil(sg.appId))) {
                        this.eFn = b.cvd;
                        clk.fKh = sg.appId;
                        clk.vCs = sg.mediaTagName;
                        clk.vCu = sg.messageAction;
                        clk.vCt = sg.messageExt;
                        this.fFw = this.csG.field_content;
                    }
                    ab.i(this.TAG, "LINE425 thumb.width:%d,thumb.height:%d", Integer.valueOf(clk.xjh), Integer.valueOf(clk.xji));
                    ab.d(this.TAG, "dkimgsource: %d, forwardtype:%d", Integer.valueOf(b.cvd), Integer.valueOf(clk.vRz));
                    if (b.offset == 0) {
                        this.fEZ = new h(110, true, (long) b.frO);
                    }
                }
                AppMethodBeat.o(78337);
                return;
            }
            ab.w(this.TAG, "init get msg by id failed:%d", Long.valueOf(this.fDH));
            com.tencent.mm.plugin.report.service.h.pYm.a(111, 206, 1, false);
            this.csG = null;
            AppMethodBeat.o(78337);
            return;
        }
        this.fEX = -1;
        AppMethodBeat.o(78337);
    }

    public l(int i, int i2, byte b) {
        AppMethodBeat.i(78338);
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
        this.fFv = new b(null);
        this.fFk = /* anonymous class already generated */;
        this.eFu = false;
        ab.i(this.TAG, "dkupimg init id:%d cmptype:%d pro:%s  [%s]", Integer.valueOf(i), Integer.valueOf(i2), null, bo.dpG());
        this.fEX = (long) i;
        this.eFm = (long) i;
        this.fDC = i2;
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new clk();
        aVar.fsK = new cll();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
        aVar.fsI = 110;
        aVar.fsL = 9;
        aVar.fsM = 1000000009;
        this.ehh = aVar.acD();
        this.fEW = null;
        ab.d(this.TAG, "FROM C SERVICE:" + this.fEX);
        if (i.lA((int) this.fEX)) {
            e b2;
            e b3 = o.ahl().b(Long.valueOf(this.fEX));
            this.fDH = b3.fDH;
            b3.setStatus(0);
            b3.eI(0);
            b3.setOffset(0);
            o.ahl().a((int) this.eFm, b3);
            if (i2 == 1) {
                this.eFm = (long) b3.fDJ;
                b2 = o.ahl().b(Long.valueOf(this.eFm));
            } else {
                b2 = b3;
            }
            this.csG = ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().jf(this.fDH);
            if (this.csG != null) {
                int i3;
                this.csG.setStatus(1);
                String str = b2.fDB;
                if (str == null || !str.startsWith("THUMBNAIL_DIRPATH://")) {
                    this.csG.jv("THUMBNAIL://" + b2.fDy);
                } else {
                    this.csG.jv(str);
                }
                ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().a(this.fDH, this.csG);
                clk clk = (clk) this.ehh.fsG.fsP;
                clk.vEB = new bts().alV(r.Yz());
                clk.vEC = new bts().alV(this.csG.field_talker);
                clk.ptx = b2.offset;
                clk.ptw = b2.frO;
                clk.nao = this.csG.getType();
                clk.wqw = i2;
                if (com.tencent.mm.network.ab.ch(ah.getContext())) {
                    i3 = 1;
                } else {
                    i3 = 2;
                }
                clk.vZF = i3;
                clk.xbN = b2.cvd;
                clk.vRz = b2.fDD;
                clk.xjh = this.csG.dJx;
                clk.xji = this.csG.dJw;
                ab.i(this.TAG, "LINE492 thumb.width:%d,thumb.height:%d", Integer.valueOf(clk.xjh), Integer.valueOf(clk.xji));
                ab.d(this.TAG, "dkimgsource: %d, forwardtype:%d", Integer.valueOf(b2.cvd), Integer.valueOf(clk.vRz));
                if (b2.offset == 0) {
                    this.fEZ = new h(110, true, (long) b2.frO);
                }
            }
            AppMethodBeat.o(78338);
            return;
        }
        this.fEX = -1;
        AppMethodBeat.o(78338);
    }

    public final com.tencent.mm.ai.m.b b(q qVar) {
        return com.tencent.mm.ai.m.b.EOk;
    }

    private boolean a(e eVar, int i) {
        AppMethodBeat.i(78339);
        if (com.tencent.mm.model.t.nJ(this.csG.field_talker)) {
            ab.w(this.TAG, "cdntra not use cdn user:%s", this.csG.field_talker);
            AppMethodBeat.o(78339);
            return false;
        }
        com.tencent.mm.al.f.afx();
        if (!com.tencent.mm.al.b.lg(1) && bo.isNullOrNil(eVar.fDK)) {
            r2 = new Object[2];
            com.tencent.mm.al.f.afx();
            r2[0] = Boolean.valueOf(com.tencent.mm.al.b.lg(1));
            r2[1] = eVar.fDK;
            ab.w(this.TAG, "cdntra not use cdn flag:%b getCdnInfo:%s", r2);
            AppMethodBeat.o(78339);
            return false;
        } else if (bo.isNullOrNil(this.fFa)) {
            ab.w(this.TAG, "cdntra genClientId failed not use cdn imgLocalId:%d", Long.valueOf(this.eFm));
            AppMethodBeat.o(78339);
            return false;
        } else {
            String q = o.ahl().q(eVar.fDz, "", "");
            String q2 = o.ahl().q(eVar.fDA, "", "");
            String q3 = o.ahl().q(eVar.fDB, "", "");
            String q4 = o.ahl().q(eVar.fDE, "", "");
            com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
            gVar.egl = this.fFk;
            gVar.field_mediaId = this.fFa;
            gVar.field_fileType = this.fFb;
            gVar.field_talker = this.csG.field_talker;
            gVar.field_chattype = com.tencent.mm.model.t.kH(this.csG.field_talker) ? 1 : 0;
            gVar.field_priority = com.tencent.mm.i.a.efC;
            gVar.field_needStorage = false;
            gVar.field_isStreamMedia = false;
            gVar.field_sendmsg_viacdn = true;
            gVar.field_enable_hitcheck = this.fFs;
            gVar.field_force_aeskeycdn = false;
            gVar.field_trysafecdn = true;
            if (i == CdnLogic.kErrUploadHevcIllegal) {
                this.fFa = com.tencent.mm.al.c.a("upimgjpg", this.csG.field_createTime, this.csG.field_talker, this.csG.field_msgId + "_" + this.eFm + "_" + this.fDC);
                gVar.field_fullpath = q;
                gVar.field_thumbpath = q3;
                gVar.field_midimgpath = q2;
                gVar.lastError = i;
                gVar.field_mediaId = this.fFa;
            } else {
                boolean z;
                boolean biZ = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.emoji.b.c.class)).biZ();
                if (this.eFn == 4 && com.tencent.mm.vfs.e.ct(q4)) {
                    z = biZ;
                } else {
                    q4 = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.emoji.b.c.class)).IP(q);
                    z = this.fDC == 0 && !com.tencent.mm.sdk.platformtools.r.amq(q).equals(".png") && aL(q, q4);
                    if (z) {
                        eVar.sf(((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.emoji.b.c.class)).IP(eVar.fDz));
                    }
                }
                String IP = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.emoji.b.c.class)).IP(q2);
                boolean aL = aL(q2, IP);
                if (!z) {
                    q4 = q;
                }
                gVar.field_fullpath = q4;
                gVar.field_thumbpath = q3;
                if (!aL) {
                    IP = q2;
                }
                gVar.field_midimgpath = IP;
                q4 = this.TAG;
                q = "hevc upload full size %b, use hevc %b, %b";
                Object[] objArr = new Object[3];
                if (gVar.field_fileType == com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE) {
                    biZ = true;
                } else {
                    biZ = false;
                }
                objArr[0] = Boolean.valueOf(biZ);
                objArr[1] = Boolean.valueOf(z);
                objArr[2] = Boolean.valueOf(aL);
                ab.d(q4, q, objArr);
            }
            if (gVar.field_fileType == com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE && bo.isNullOrNil(gVar.field_midimgpath)) {
                com.tencent.mm.al.f.afx();
                if (com.tencent.mm.al.b.lg(256)) {
                    ab.w(this.TAG, "summersafecdn send fullsizeimage but midimgpath is null set field_force_aeskeycdn true");
                    gVar.field_force_aeskeycdn = true;
                    gVar.field_trysafecdn = false;
                }
            }
            Map z2 = br.z(this.fFw, "msg");
            if (z2 != null) {
                if (this.fDC != 1) {
                    gVar.field_fileId = (String) z2.get(".msg.img.$cdnmidimgurl");
                    gVar.field_midFileLength = bo.getInt((String) z2.get(".msg.img.$length"), 0);
                    gVar.field_totalLen = 0;
                } else {
                    gVar.field_fileId = (String) z2.get(".msg.img.$cdnbigimgurl");
                    gVar.field_midFileLength = bo.getInt((String) z2.get(".msg.img.$length"), 0);
                    gVar.field_totalLen = 0;
                }
                gVar.field_aesKey = (String) z2.get(".msg.img.$aeskey");
            } else {
                ab.i(this.TAG, "parse cdnInfo failed. [%s]", eVar.fDK);
            }
            if (bo.isNullOrNil(gVar.field_aesKey)) {
                com.tencent.mm.al.f.afy();
                gVar.field_aesKey = com.tencent.mm.al.a.afp();
                ab.i(this.TAG, "summersafecdn cdntra oldAeskey is null and gen new[%s]", gVar.field_aesKey);
            }
            ab.i(this.TAG, "dkupimg src:%d fileid:%s", Integer.valueOf(eVar.cvd), gVar.field_fileId);
            this.fFq = gVar.field_fileId;
            this.fFr = gVar.field_aesKey;
            ab.d(this.TAG, "summersafecdn checkUseCdn field_enable_hitcheck[%b], field_fileType[%d], field_midimgpath[%s], field_fullpath[%s], aeskey[%s], fileid[%s], enable_hitcheck[%b], aeskeycdn[%b], trysafecdn[%b]", Boolean.valueOf(gVar.field_enable_hitcheck), Integer.valueOf(gVar.field_fileType), gVar.field_midimgpath, gVar.field_fullpath, gVar.field_aesKey, gVar.field_fileId, Boolean.valueOf(gVar.field_enable_hitcheck), Boolean.valueOf(gVar.field_force_aeskeycdn), Boolean.valueOf(gVar.field_trysafecdn));
            this.fFB = null;
            if (com.tencent.mm.al.f.afx().e(gVar)) {
                if (bo.nullAsNil(eVar.fDK).length() <= 0) {
                    eVar.se("CDNINFO_SEND");
                    eVar.bJt = 4096;
                }
                AppMethodBeat.o(78339);
                return true;
            }
            com.tencent.mm.plugin.report.service.h.pYm.a(111, 205, 1, false);
            ab.e(this.TAG, "cdntra addSendTask failed. clientid:%s", this.fFa);
            this.fFa = "";
            AppMethodBeat.o(78339);
            return false;
        }
    }

    private boolean aL(String str, String str2) {
        AppMethodBeat.i(78340);
        if (((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.emoji.b.c.class)).biZ()) {
            if (com.tencent.mm.vfs.e.asZ(str) > 0) {
                if (com.tencent.mm.vfs.e.asZ(str2) > 0) {
                    com.tencent.mm.plugin.report.service.h.pYm.k(944, 9, 1);
                    com.tencent.mm.vfs.e.deleteFile(str2);
                }
                if (!com.tencent.mm.vfs.e.ct(str2)) {
                    com.tencent.mm.vfs.e.atc(str2);
                }
                if (((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.emoji.b.c.class)).dF(str, str2) == 0) {
                    AppMethodBeat.o(78340);
                    return true;
                }
                ab.w(this.TAG, "file to hevc failed %s", str);
            }
            AppMethodBeat.o(78340);
            return false;
        }
        AppMethodBeat.o(78340);
        return false;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(78341);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RS().m(new Runnable() {
            public final void run() {
                AppMethodBeat.i(78328);
                ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().QX("SendImgSpeeder");
                AppMethodBeat.o(78328);
            }
        }, 100);
        int lE;
        if (this.eFm < 0) {
            com.tencent.mm.plugin.report.service.h.pYm.a(111, 204, 1, false);
            ab.e(this.TAG, "doScene invalid imgLocalId:" + this.eFm);
            lE = lE(-1);
            AppMethodBeat.o(78341);
            return lE;
        } else if (this.csG == null) {
            com.tencent.mm.plugin.report.service.h.pYm.a(111, 203, 1, false);
            ab.e(this.TAG, "doScene msg is null imgid:%d", Long.valueOf(this.eFm));
            i.lC((int) this.fEX);
            lE = lE(-2);
            AppMethodBeat.o(78341);
            return lE;
        } else {
            this.ehi = fVar;
            c(eVar);
            clk clk = (clk) this.ehh.fsG.fsP;
            e agY = agY();
            e lz = o.ahl().lz((int) agY.fDy);
            if (lz != null) {
                if (lz.status == -1) {
                    com.tencent.mm.plugin.report.service.h.pYm.a(111, 202, 1, false);
                    ab.e(this.TAG, "doScene hd img info is null or error.");
                    lE = lE(-3);
                    AppMethodBeat.o(78341);
                    return lE;
                }
            } else if (agY == null || agY.status == -1) {
                ab.e(this.TAG, "doScene img info is null or error.");
                lE = lE(-4);
                AppMethodBeat.o(78341);
                return lE;
            }
            if (com.tencent.mm.l.a.a.KG().kq(this.csG.field_talker)) {
                clk.vEG = com.tencent.mm.l.a.a.KG().h(this.csG);
            } else {
                String aae = bh.aae();
                if (!(aae == null || aae.equals(this.csG.dqJ)) || (aae == null && !bo.isNullOrNil(this.csG.dqJ))) {
                    this.csG.ix(aae);
                    ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().a(this.csG.field_msgId, this.csG);
                }
                clk.vEG = this.csG.dqJ;
            }
            String q = o.ahl().q(agY.fDz, "", "");
            String q2 = o.ahl().q(agY.fDB, "", "");
            if (!bo.isNullOrNil(agY.fDA)) {
                o.ahl().q(agY.fDA, "", "");
            }
            if (e.cs(q) <= 0 || e.cs(q2) <= 0) {
                ab.e(this.TAG, "doScene invalid imgLocalId:%d filesize:[%d,%d] %s %s", Long.valueOf(this.eFm), Integer.valueOf(e.cs(q)), Integer.valueOf(e.cs(q2)), q, q2);
                lE = lE(-5);
                AppMethodBeat.o(78341);
                return lE;
            }
            if (clk.xja == null || bo.isNullOrNil(clk.xja.wVI)) {
                if (bo.isNullOrNil(this.fFa)) {
                    ab.i(this.TAG, "createMediaId time:%d talker:%s msg:%d img:%d compressType:%d", Long.valueOf(this.csG.field_createTime), this.csG.field_talker, Long.valueOf(this.csG.field_msgId), Long.valueOf(this.eFm), Integer.valueOf(this.fDC));
                    this.fFa = com.tencent.mm.al.c.a("upimg", this.csG.field_createTime, this.csG.field_talker, this.csG.field_msgId + "_" + this.eFm + "_" + this.fDC);
                }
                clk.xja = new bts().alV(this.fFa);
                bi biVar = this.csG;
                biVar.dJC = this.fFa;
                biVar.dqp = true;
            }
            if (this.startTime == 0) {
                this.startTime = bo.anU();
                this.startOffset = agY.offset;
                this.fFb = this.fDC == 1 ? com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE : com.tencent.mm.i.a.MediaType_IMAGE;
            }
            ab.i(this.TAG, "before checkUseCdn %s, %s, imgBitPath:%s", q, q2, agY.fDz);
            if (a(agY, 0)) {
                ab.d(this.TAG, "cdntra use cdn return -1 for onGYNetEnd clientid:%s", clk.xja.wVI);
                AppMethodBeat.o(78341);
                return 0;
            }
            ab.i(this.TAG, "after checkUseCdn, it use cgi to upload image.");
            int i = agY.fDI;
            if (i >= acn()) {
                com.tencent.mm.plugin.report.service.h.pYm.a(111, 201, 1, false);
                ab.e(this.TAG, "doScene limit net time:".concat(String.valueOf(i)));
                i.lC((int) this.fEX);
                lE = lE(-6);
                AppMethodBeat.o(78341);
                return lE;
            }
            agY.lr(i + 1);
            agY.bJt = 512;
            o.ahl().a(Long.valueOf(this.eFm), agY);
            int i2 = agY.frO - agY.offset;
            if (i2 > this.fFu) {
                i2 = this.fFu;
            }
            e.cs(q);
            byte[] e = e.e(q, agY.offset, i2);
            if (e == null || e.length <= 0) {
                com.tencent.mm.plugin.report.service.h.pYm.a(111, 199, 1, false);
                ab.e(this.TAG, "doScene, file read buf error.");
                lE = lE(-8);
                AppMethodBeat.o(78341);
                return lE;
            }
            clk.pty = e.length;
            clk.ptx = agY.offset;
            clk.ptz = new SKBuiltinBuffer_t().setBuffer(e);
            if (this.fEZ != null) {
                this.fEZ.akj();
            }
            lE = a(eVar, this.ehh, this);
            if (lE < 0) {
                ab.e(this.TAG, "doScene netId error");
                i.lC((int) this.fEX);
                lE = lE(-9);
                AppMethodBeat.o(78341);
                return lE;
            }
            AppMethodBeat.o(78341);
            return lE;
        }
    }

    private int lE(int i) {
        AppMethodBeat.i(78342);
        ab.e(this.TAG, "do Scene error code : " + i + " hashcode : " + hashCode());
        if (this.fFv != null) {
            this.fFv.agX();
        }
        AppMethodBeat.o(78342);
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

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(78343);
        cll cll = (cll) ((com.tencent.mm.ai.b) qVar).fsH.fsP;
        ab.i(this.TAG, "cdntra onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " useCdnTransClientId:" + this.fFa);
        if (i2 == 3 && i3 == -1 && !bo.isNullOrNil(this.fFa)) {
            ab.w(this.TAG, "cdntra using cdn trans,  wait cdn service callback! clientid:%s", this.fFa);
            AppMethodBeat.o(78343);
        } else if (i2 == 0 && i3 == 0) {
            this.fFu = cll.pty;
            if (this.fFu > 16384) {
                this.fFu = 16384;
            }
            e agY = agY();
            ab.v(this.TAG, "onGYNetEnd localId:" + this.eFm + "  totalLen:" + agY.frO + " offSet:" + agY.offset);
            if (cll.ptx < 0 || (cll.ptx > agY.frO && agY.frO > 0)) {
                com.tencent.mm.plugin.report.service.h.pYm.a(111, 197, 1, false);
                ab.e(this.TAG, "onGYNetEnd invalid server return value : startPos = " + cll.ptx + " img totalLen = " + agY.frO);
                i.lC((int) this.fEX);
                i.lB((int) this.fEX);
                com.tencent.mm.plugin.report.service.h.pYm.e(10420, Integer.valueOf(-2), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bo.anU()), Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext())), Integer.valueOf(this.fFb), Integer.valueOf(0));
                this.ehi.onSceneEnd(4, -2, "", this);
                if (this.fFv != null) {
                    this.fFv.agX();
                }
                AppMethodBeat.o(78343);
            } else if (cll.ptx < agY.offset || (f.b(agY) && this.fFu <= 0)) {
                ab.e(this.TAG, "onGYNetEnd invalid data startPos = " + cll.ptx + " totalLen = " + agY.frO + " off:" + agY.offset);
                i.lC((int) this.fEX);
                i.lB((int) this.fEX);
                this.ehi.onSceneEnd(4, -1, "", this);
                if (this.fFv != null) {
                    this.fFv.agX();
                }
                AppMethodBeat.o(78343);
            } else {
                ab.d("ImgInfoLogic", "resp.rImpl.getStartPos() " + cll.ptx);
                if (a(agY, cll.ptx, cll.ptF, cll.pcX, null) && a(this.ftf, this.ehi) < 0) {
                    i.lB((int) this.fEX);
                    this.ehi.onSceneEnd(3, -1, "", this);
                    if (this.fFv != null) {
                        this.fFv.agX();
                    }
                }
                AppMethodBeat.o(78343);
            }
        } else {
            ab.e(this.TAG, "onGYNetEnd failed errtype:" + i2 + " errcode:" + i3);
            com.tencent.mm.plugin.report.service.h.pYm.a(111, 198, 1, false);
            i.lC((int) this.fEX);
            i.lB((int) this.fEX);
            com.tencent.mm.plugin.report.service.h.pYm.e(10420, Integer.valueOf(i3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bo.anU()), Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext())), Integer.valueOf(this.fFb), Integer.valueOf(0));
            this.ehi.onSceneEnd(i2, i3, str, this);
            if (this.fFv != null) {
                this.fFv.agX();
            }
            AppMethodBeat.o(78343);
        }
    }

    public final void aha() {
        AppMethodBeat.i(78344);
        ab.i(this.TAG, "send img from system");
        this.eFu = true;
        AppMethodBeat.o(78344);
    }

    private boolean a(e eVar, int i, long j, int i2, d dVar) {
        AppMethodBeat.i(78345);
        ab.d(this.TAG, "cdntra clientid:%s start:%d svrid:%d createtime:%d", this.fFa, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2));
        ab.i(this.TAG, "dkmsgid  set svrmsgid %d -> %d  oriImgLocalId %s imgLocalId %s", Long.valueOf(j), Integer.valueOf(ae.giA), Long.valueOf(this.fEX), Long.valueOf(this.eFm));
        if (CdnLogic.kMediaTypeFavoriteBigFile == ae.giz && ae.giA != 0) {
            j = (long) ae.giA;
            ae.giA = 0;
        }
        c(eVar.fDy, i, eVar.frO);
        eVar.setOffset(i);
        eVar.eI(j);
        if (f.b(eVar) && this.fEX != this.eFm) {
            e b = o.ahl().b(Long.valueOf(this.fEX));
            b.eI(j);
            b.lt(eVar.frO);
            b.setOffset(eVar.frO);
            o.ahl().a(Long.valueOf(this.fEX), b);
        }
        if (f.b(eVar)) {
            if (bo.isNullOrNil(this.fFa)) {
                com.tencent.mm.plugin.report.service.h.pYm.e(10420, Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bo.anU()), Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext())), Integer.valueOf(this.fFb), Integer.valueOf(eVar.frO - this.startOffset));
            }
            this.csG.setStatus(2);
            this.csG.eI(j);
            ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().a(this.fDH, this.csG);
            if (com.tencent.mm.modelstat.r.fUq != null) {
                com.tencent.mm.modelstat.r.fUq.j(this.csG);
            }
            if (this.fEZ != null) {
                this.fEZ.fS(0);
            }
            if (r.fGF != null) {
                r.fGF.a(this.eFm, this.csG, this.ehh, this.eFn, this.eFu, dVar);
            }
            if (this.fFv != null) {
                this.fFv.agX();
            }
            this.ehi.onSceneEnd(0, 0, "", this);
            i.lB((int) this.fEX);
            AppMethodBeat.o(78345);
            return false;
        }
        AppMethodBeat.o(78345);
        return true;
    }

    private void c(long j, int i, int i2) {
        AppMethodBeat.i(78346);
        if (this.fEW != null) {
            final long j2 = j;
            final int i3 = i2;
            final int i4 = i;
            al.d(new Runnable() {
                public final void run() {
                    n.d dVar;
                    AppMethodBeat.i(78329);
                    n ahb = n.ahb();
                    long j = j2;
                    long j2 = (long) i3;
                    long j3 = (long) i4;
                    if (ahb.fFL.containsKey(Long.valueOf(j))) {
                        dVar = (n.d) ahb.fFL.get(Long.valueOf(j));
                    } else {
                        dVar = new n.d();
                    }
                    dVar.xb = j3;
                    dVar.cET = j2;
                    ahb.fFL.put(Long.valueOf(j), dVar);
                    l.this.fEW.a(i4, i3, l.this);
                    AppMethodBeat.o(78329);
                }
            });
        }
        AppMethodBeat.o(78346);
    }

    public static void fK(long j) {
        fFD = j;
    }

    public static String sp(String str) {
        AppMethodBeat.i(78347);
        try {
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(78347);
            } else {
                String[] split = str.split(",");
                if (split == null || split.length <= 19) {
                    AppMethodBeat.o(78347);
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    long j = fFD;
                    fFD = -1;
                    split[19] = stringBuilder.append(j).toString();
                    str = bo.c(bo.P(split), ",");
                    AppMethodBeat.o(78347);
                }
            }
        } catch (Exception e) {
            AppMethodBeat.o(78347);
        }
        return str;
    }
}

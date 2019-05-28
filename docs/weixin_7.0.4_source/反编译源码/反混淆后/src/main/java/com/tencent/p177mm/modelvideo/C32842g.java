package com.tencent.p177mm.modelvideo;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.compatible.util.C1447g.C1446a;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.model.C1831bh;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.modelcontrol.C42204d;
import com.tencent.p177mm.modelstat.C45457b;
import com.tencent.p177mm.modelvideo.C32845h.C32846a;
import com.tencent.p177mm.modelvideo.C9720t.C9723b;
import com.tencent.p177mm.modelvideo.C9720t.C97252;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.network.C32856ab;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p178a.C1179i;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1205a;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C6300p;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p187al.C31259b;
import com.tencent.p177mm.p187al.C37458c;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p230g.p232b.p233a.C42099d;
import com.tencent.p177mm.p230g.p232b.p233a.C9514f;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.p878a.C42258c;
import com.tencent.p177mm.plugin.p878a.C45479b;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.cfh;
import com.tencent.p177mm.protocal.protobuf.cls;
import com.tencent.p177mm.protocal.protobuf.clt;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;
import com.tencent.smtt.sdk.TbsMediaPlayer.TbsMediaPlayerListener;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.ugc.TXRecordCommon;
import com.tencent.view.C31128d;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Vector;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.modelvideo.g */
public final class C32842g extends C1207m implements C1918k {
    private static int fVE = TXRecordCommon.AUDIO_SAMPLERATE_32000;
    private final int MAX_TIMES;
    private String cMW = "";
    boolean cng = false;
    C1446a eOm = null;
    private C7472b ehh;
    private C1202f ehi;
    private String fFa = "";
    private C1628a fFk = new C328431();
    private boolean fFs = true;
    private final long fVF = 1800000;
    private int fVG = -1;
    private boolean fVH = false;
    private boolean fVI = false;
    private int fVJ = 0;
    private int fVK = 0;
    int fVL = 0;
    public C26493s fVj;
    private int fVl = C42129a.MediaType_VIDEO;
    private boolean fVm = false;
    public String fileName;
    C7564ap frk = new C7564ap(new C328442(), true);
    int retCode = 0;
    private long startTime = 0;

    /* renamed from: com.tencent.mm.modelvideo.g$1 */
    class C328431 implements C1628a {
        C328431() {
        }

        /* renamed from: a */
        public final int mo5082a(String str, int i, C18496c c18496c, final C9545d c9545d, boolean z) {
            AppMethodBeat.m2504i(50695);
            C4990ab.m7411d("MicroMsg.NetSceneUploadVideo", "%s cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", C32842g.m53661a(C32842g.this), C32842g.this.fFa, Integer.valueOf(i), c18496c, c9545d);
            if (i == -21005) {
                C4990ab.m7411d("MicroMsg.NetSceneUploadVideo", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", C32842g.this.fFa);
                AppMethodBeat.m2505o(50695);
                return 0;
            } else if (i != 0) {
                C26494u.m42261um(C32842g.this.fileName);
                new C9514f(C46180a.m86311r(Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(C32842g.this.startTime), Long.valueOf(C5046bo.anU()), Integer.valueOf(C37458c.m63165bW(C4996ah.getContext())), Integer.valueOf(C32842g.this.fVl), Integer.valueOf(0), "")).ajK();
                C32842g.this.ehi.onSceneEnd(3, i, "", C32842g.this);
                AppMethodBeat.m2505o(50695);
                return 0;
            } else {
                C32842g.this.fVj = C26494u.m42268ut(C32842g.this.fileName);
                int i2;
                if (C32842g.this.fVj == null || C32842g.this.fVj.status == 105) {
                    if (C32842g.this.fVj == null) {
                        i2 = -1;
                    } else {
                        i2 = C32842g.this.fVj.status;
                    }
                    C4990ab.m7417i("MicroMsg.NetSceneUploadVideo", "%s info is null or has paused, status:%d", C32842g.m53661a(C32842g.this), Integer.valueOf(i2));
                    C37461f.afx().mo51227rN(C32842g.this.fFa);
                    C32842g.this.ehi.onSceneEnd(3, i, "info is null or has paused, status".concat(String.valueOf(i2)), C32842g.this);
                    AppMethodBeat.m2505o(50695);
                    return 0;
                } else if (c18496c == null) {
                    if (c9545d != null) {
                        String r;
                        if (c9545d.field_retCode != 0) {
                            C4990ab.m7413e("MicroMsg.NetSceneUploadVideo", "%s cdntra sceneResult.retCode :%d arg[%s] info[%s]", C32842g.m53661a(C32842g.this), Integer.valueOf(c9545d.field_retCode), c9545d.field_arg, c9545d.field_transInfo);
                            C26494u.m42261um(C32842g.this.fileName);
                            r = C46180a.m86311r(Integer.valueOf(c9545d.field_retCode), Integer.valueOf(1), Long.valueOf(C32842g.this.startTime), Long.valueOf(C5046bo.anU()), Integer.valueOf(C37458c.m63165bW(C4996ah.getContext())), Integer.valueOf(C32842g.this.fVl), Integer.valueOf(c9545d.field_fileLength), c9545d.field_transInfo, "", "", "", "", "", "", "", c9545d.efY);
                            new C9514f(r).ajK();
                            new C42099d(r).ajK();
                            C32842g.this.ehi.onSceneEnd(3, c9545d.field_retCode, "", C32842g.this);
                        } else {
                            C4990ab.m7417i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn uploadvideo by cdn, videohash isHitCacheUpload: %d, enableHitcheck:%b", C32842g.m53661a(C32842g.this), Integer.valueOf(c9545d.field_UploadHitCacheType), Boolean.valueOf(C32842g.this.fFs));
                            C7060h c7060h = C7060h.pYm;
                            Object[] objArr = new Object[2];
                            i2 = C32842g.this.fVI ? 810 : C32842g.this.fVH ? 820 : 830;
                            objArr[0] = Integer.valueOf(i2 + c9545d.field_UploadHitCacheType);
                            objArr[1] = Integer.valueOf(C32842g.this.fVj.frO);
                            c7060h.mo8381e(12696, objArr);
                            boolean z2 = c9545d.field_isVideoReduced;
                            C4990ab.m7417i("MicroMsg.NetSceneUploadVideo", "%s it video was reduced by cdn %b %s", C32842g.m53661a(C32842g.this), Boolean.valueOf(z2), C32842g.this.fileName);
                            if (z2) {
                                C7060h.pYm.mo8378a(106, 200, 1, false);
                            } else {
                                C7060h.pYm.mo8378a(106, 205, 1, false);
                                if (C32842g.this.fVJ > 0 && c9545d.field_thumbimgLength > 0) {
                                    C4990ab.m7417i("MicroMsg.NetSceneUploadVideo", "%s send video thumb too big thumb length [%d, %d] ", C32842g.m53661a(C32842g.this), Integer.valueOf(C32842g.this.fVJ), Integer.valueOf(c9545d.field_thumbimgLength));
                                    if (C32842g.this.fVJ * 2 > c9545d.field_thumbimgLength) {
                                        C7060h.pYm.mo8378a(106, 206, 1, false);
                                    } else {
                                        C7060h.pYm.mo8378a(106, 207, 1, false);
                                    }
                                }
                                C37961o.all();
                                C4990ab.m7417i("MicroMsg.NetSceneUploadVideo", "%s send video too big thumb length [%d, %d] ", C32842g.m53661a(C32842g.this), Integer.valueOf(C32842g.this.fVj.frO), Integer.valueOf((int) C5730e.asZ(C9720t.m17303uh(C32842g.this.fileName))));
                                if (C32842g.this.fVj.frO != ((int) C5730e.asZ(C9720t.m17303uh(C32842g.this.fileName)))) {
                                    C7060h.pYm.mo8378a(106, 208, 1, false);
                                } else {
                                    C7060h.pYm.mo8378a(106, 209, 1, false);
                                }
                            }
                            C32842g.this.fVj = C26494u.m42268ut(C32842g.this.fileName);
                            if (C5046bo.isNullOrNil(C32842g.this.fVj.alw())) {
                                C4990ab.m7417i("MicroMsg.NetSceneUploadVideo", "%s cdn callback new build cdnInfo:%s", C32842g.m53661a(C32842g.this), ((("<msg><videomsg aeskey=\"" + c9545d.field_aesKey + "\" cdnthumbaeskey=\"" + c9545d.field_aesKey + "\" cdnvideourl=\"" + c9545d.field_fileId + "\" ") + "cdnthumburl=\"" + c9545d.field_fileId + "\" ") + "length=\"" + c9545d.field_fileLength + "\" ") + "cdnthumblength=\"" + c9545d.field_thumbimgLength + "\"/></msg>");
                                C32842g.this.fVj.fXj = r;
                                C26494u.m42253f(C32842g.this.fVj);
                            }
                            Map z3 = C5049br.m7595z(C32842g.this.fVj.alw(), "msg");
                            if (z3 != null) {
                                C9720t all = C37961o.all();
                                C37961o.all();
                                boolean s = all.mo21062s(C9720t.m17303uh(C32842g.this.fileName), (String) z3.get(".msg.videomsg.$cdnvideourl"), (String) z3.get(".msg.videomsg.$aeskey"));
                                c7060h = C7060h.pYm;
                                objArr = new Object[2];
                                if (s) {
                                    i2 = 1;
                                } else {
                                    i2 = 2;
                                }
                                objArr[0] = Integer.valueOf(i2 + TbsMediaPlayerListener.MEDIA_INFO_TIMED_TEXT_ERROR);
                                objArr[1] = Integer.valueOf(C32842g.this.fVj.frO);
                                c7060h.mo8381e(12696, objArr);
                            }
                            C6300p Rg = C1720g.m3540Rg();
                            String c = C32842g.this.fileName;
                            if (z2) {
                                i2 = 0;
                            } else {
                                i2 = C32842g.m53673l(C32842g.this);
                            }
                            Rg.mo14541a(new C32845h(c, i2, c9545d, new C32846a() {

                                /* renamed from: com.tencent.mm.modelvideo.g$1$1$1 */
                                class C328411 implements Runnable {
                                    C328411() {
                                    }

                                    public final void run() {
                                        AppMethodBeat.m2504i(50693);
                                        C32842g.this.fFs = false;
                                        C32842g.this.fVj.status = 104;
                                        C32842g.this.fVj.createTime = C5046bo.anT();
                                        C32842g.this.fVj.fXb = C5046bo.anT();
                                        C32842g.this.fVj.fVG = 0;
                                        C32842g.this.fVj.bJt = 1800;
                                        boolean f = C26494u.m42253f(C32842g.this.fVj);
                                        C4990ab.m7417i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn MM_ERR_GET_AESKEY_FAILED doScene again enableHitcheck[%b], ret[%b] new createtime:%d", C32842g.m53661a(C32842g.this), Boolean.valueOf(C32842g.this.fFs), Boolean.valueOf(f), Long.valueOf(C32842g.this.fVj.createTime));
                                        C32842g.this.mo4456a(C32842g.this.ftf, C32842g.this.ehi);
                                        AppMethodBeat.m2505o(50693);
                                    }
                                }

                                /* renamed from: cC */
                                public final void mo39619cC(int i, int i2) {
                                    AppMethodBeat.m2504i(50694);
                                    if (i == 4 && i2 == 102) {
                                        C1720g.m3539RS().mo10302aa(new C328411());
                                        AppMethodBeat.m2505o(50694);
                                        return;
                                    }
                                    new C9514f(C46180a.m86311r(Integer.valueOf(i2), Integer.valueOf(1), Long.valueOf(C32842g.this.startTime), Long.valueOf(C5046bo.anU()), Integer.valueOf(C37458c.m63165bW(C4996ah.getContext())), Integer.valueOf(C32842g.this.fVl), Integer.valueOf(c9545d.field_fileLength), c9545d.field_transInfo, "", "", "", "", "", "", "", c9545d.efY)).ajK();
                                    C9713a.m17288a(C32842g.this.fVj, 0);
                                    C32842g.m53662a(C32842g.this, c9545d);
                                    C32842g.this.ehi.onSceneEnd(i, i2, "", C32842g.this);
                                    AppMethodBeat.m2505o(50694);
                                }
                            }), 0);
                        }
                    }
                    AppMethodBeat.m2505o(50695);
                    return 0;
                } else if (C32842g.this.fVj.fVG > c18496c.field_finishedLength) {
                    C4990ab.m7421w("MicroMsg.NetSceneUploadVideo", "%s cdntra cdnEndProc error oldpos:%d newpos:%d", C32842g.m53661a(C32842g.this), Integer.valueOf(C32842g.this.fVj.fVG), Integer.valueOf(c18496c.field_finishedLength));
                    AppMethodBeat.m2505o(50695);
                    return 0;
                } else {
                    C32842g.this.fVj.fXb = C5046bo.anT();
                    C32842g.this.fVj.fVG = c18496c.field_finishedLength;
                    C32842g.this.fVj.bJt = FilterEnum4Shaka.MIC_SHAKA_ADD_13;
                    C26494u.m42253f(C32842g.this.fVj);
                    AppMethodBeat.m2505o(50695);
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

    /* renamed from: com.tencent.mm.modelvideo.g$2 */
    class C328442 implements C5015a {
        C328442() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(50696);
            if (C32842g.this.mo4456a(C32842g.this.ftf, C32842g.this.ehi) == -1) {
                C32842g.this.retCode = 0 - (C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
                C32842g.this.ehi.onSceneEnd(3, -1, "doScene failed", C32842g.this);
            }
            AppMethodBeat.m2505o(50696);
            return false;
        }
    }

    private boolean ala() {
        AppMethodBeat.m2504i(50698);
        if (C1855t.m3924nJ(this.fVj.getUser())) {
            C4990ab.m7421w("MicroMsg.NetSceneUploadVideo", "%s cdntra not use cdn user:%s", alb(), this.fVj.getUser());
            AppMethodBeat.m2505o(50698);
            return false;
        }
        C37461f.afx();
        if (C31259b.m50439lg(2) || this.fVj.fXi == 1) {
            this.fFa = C37458c.m63162a("upvideo", this.fVj.createTime, this.fVj.getUser(), this.fVj.getFileName());
            if (C5046bo.isNullOrNil(this.fFa)) {
                C4990ab.m7421w("MicroMsg.NetSceneUploadVideo", "%s cdntra genClientId failed not use cdn file:%s", alb(), this.fVj.getFileName());
                AppMethodBeat.m2505o(50698);
                return false;
            }
            C37961o.all();
            String ui = C9720t.m17304ui(this.fileName);
            C37961o.all();
            String uh = C9720t.m17303uh(this.fileName);
            C42130g c42130g = new C42130g();
            c42130g.egl = this.fFk;
            c42130g.field_mediaId = this.fFa;
            c42130g.field_fullpath = uh;
            c42130g.field_thumbpath = m53677tW(ui);
            c42130g.field_fileType = C42129a.MediaType_VIDEO;
            c42130g.field_enable_hitcheck = this.fFs;
            c42130g.field_largesvideo = C42204d.afF().mo67743rT(uh) ? 1 : 0;
            if (this.fVj != null && 3 == this.fVj.fXk) {
                c42130g.field_smallVideoFlag = 1;
            }
            String str = "MicroMsg.NetSceneUploadVideo";
            String str2 = "%s upload video MMSightExtInfo is null? %b %s";
            Object[] objArr = new Object[3];
            objArr[0] = alb();
            objArr[1] = Boolean.valueOf(this.fVj.fXn == null);
            objArr[2] = this.fileName;
            C4990ab.m7417i(str, str2, objArr);
            if (this.fVj.fXn != null && this.fVj.fXn.wDP) {
                C4990ab.m7417i("MicroMsg.NetSceneUploadVideo", "%s local capture video, mark use large video", alb());
                C37961o.all();
                C45459n.alj().mo73267a("", C9720t.m17303uh(this.fileName), this.fVj.getUser(), "", "", 2, 2);
                C42204d.afF();
                c42130g.field_largesvideo = C42204d.m74448a(C42204d.afF().afG());
            }
            str = "MicroMsg.NetSceneUploadVideo";
            str2 = "%s checkAD file:%s adinfo:%s";
            objArr = new Object[3];
            objArr[0] = alb();
            objArr[1] = this.fVj.getFileName();
            objArr[2] = this.fVj.fXm == null ? BuildConfig.COMMAND : this.fVj.fXm.fiM;
            C4990ab.m7417i(str, str2, objArr);
            if (!(this.fVj.fXm == null || C5046bo.isNullOrNil(this.fVj.fXm.fiM))) {
                c42130g.field_advideoflag = 1;
            }
            c42130g.field_talker = this.fVj.getUser();
            c42130g.field_chattype = C1855t.m3896kH(this.fVj.getUser()) ? 1 : 0;
            c42130g.field_priority = C42129a.efC;
            c42130g.field_needStorage = false;
            c42130g.field_isStreamMedia = false;
            c42130g.field_trysafecdn = true;
            this.fVK = (int) C5730e.asZ(c42130g.field_fullpath);
            this.fVJ = (int) C5730e.asZ(c42130g.field_thumbpath);
            if (this.fVJ >= C42129a.efW) {
                C4990ab.m7421w("MicroMsg.NetSceneUploadVideo", "%s cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", alb(), c42130g.field_thumbpath, Integer.valueOf(this.fVJ));
                AppMethodBeat.m2505o(50698);
                return false;
            }
            int i;
            Map z = C5049br.m7595z(this.fVj.alw(), "msg");
            if (z != null) {
                c42130g.field_fileId = (String) z.get(".msg.videomsg.$cdnvideourl");
                c42130g.field_aesKey = (String) z.get(".msg.videomsg.$aeskey");
                this.fVI = true;
            } else {
                C4990ab.m7417i("MicroMsg.NetSceneUploadVideo", "%s cdntra parse video recv xml failed", alb());
                try {
                    boolean z2;
                    boolean z3;
                    boolean z4;
                    String[] split;
                    String[] split2 = C5046bo.nullAsNil(((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("UseVideoHash")).split(",");
                    C1720g.m3537RQ();
                    C1720g.m3534RN();
                    int bL = C1179i.m2593bL(C1668a.m3383QF(), 100);
                    boolean z5 = (split2 == null || split2.length <= 0) ? false : C5046bo.getInt(split2[0], 0) >= bL;
                    boolean z6 = (split2 == null || split2.length < 2) ? false : C5046bo.getInt(split2[1], 0) >= bL;
                    boolean z7 = (split2 == null || split2.length < 3) ? false : C5046bo.getInt(split2[2], 0) >= bL;
                    if (C4872b.dnO()) {
                        z2 = true;
                        z3 = true;
                        z4 = true;
                    } else {
                        z2 = z6;
                        z3 = z5;
                        z4 = z7;
                    }
                    if (z3) {
                        C9720t all = C37961o.all();
                        C4990ab.m7417i("MicroMsg.VideoInfoStorage", "checkVideoHash in fullCheckRatio:%s path:%s stack:%s", Integer.valueOf(C5046bo.getInt(split2[2], 0)), uh, C5046bo.dpG());
                        long anU = C5046bo.anU();
                        if (C5046bo.isNullOrNil(uh)) {
                            C4990ab.m7413e("MicroMsg.VideoInfoStorage", "checkVideoHash failed , path:%s ", uh);
                            ui = "";
                        } else {
                            int[] uk = C9720t.m17306uk(uh);
                            if (uk == null || uk.length < 33) {
                                C4990ab.m7413e("MicroMsg.VideoInfoStorage", "checkVideoHash  readHash failed :%s", uh);
                                ui = "";
                            } else {
                                int i2;
                                all.fni.mo10108hY("VideoHash", "delete from VideoHash where CreateTime < " + (C5046bo.anT() - 432000));
                                int i3 = uk[32];
                                StringBuffer stringBuffer = new StringBuffer();
                                for (i = 0; i < 32; i++) {
                                    stringBuffer.append(Integer.toHexString(uk[i]));
                                }
                                int length = stringBuffer.length();
                                Vector vector = new Vector();
                                Vector vector2 = new Vector();
                                Vector vector3 = new Vector();
                                Vector vector4 = new Vector();
                                int i4 = -1;
                                Cursor a = all.fni.mo10104a("select size, CreateTime, hash, cdnxml, orgpath from VideoHash where size = ".concat(String.valueOf(i3)), null, 0);
                                while (a.moveToNext()) {
                                    long j = a.getLong(1);
                                    String string = a.getString(2);
                                    String string2 = a.getString(3);
                                    String string3 = a.getString(4);
                                    C4990ab.m7419v("MicroMsg.VideoInfoStorage", "checkVideoHash select [%s][%s]", string, string2);
                                    if (C5046bo.isNullOrNil(string) || C5046bo.isNullOrNil(string2)) {
                                        C7060h.pYm.mo8381e(12696, Integer.valueOf(104), Integer.valueOf(i3));
                                        C4990ab.m7421w("MicroMsg.VideoInfoStorage", "checkVideoHash select error [%s][%s]", string, string2);
                                    } else if (length != string.length()) {
                                        C7060h.pYm.mo8381e(12696, Integer.valueOf(105), Integer.valueOf(i3));
                                        C4990ab.m7421w("MicroMsg.VideoInfoStorage", "checkVideoHash err length file:%d cursor:%d", Integer.valueOf(length), Integer.valueOf(string.length()));
                                    } else {
                                        i2 = 0;
                                        bL = 0;
                                        while (bL < length) {
                                            if (stringBuffer.charAt(bL) == string.charAt(bL)) {
                                                i = i2 + 1;
                                            } else {
                                                i = i2;
                                            }
                                            bL++;
                                            i2 = i;
                                        }
                                        if (i4 < 0 || vector3.size() <= i4 || ((Integer) vector3.get(i4)).intValue() < i2) {
                                            i = vector3.size();
                                        } else {
                                            i = i4;
                                        }
                                        vector3.add(Integer.valueOf(i2));
                                        vector.add(string2);
                                        vector2.add(string3);
                                        vector4.add(Long.valueOf(j));
                                        C4990ab.m7411d("MicroMsg.VideoInfoStorage", "checkVideoHash cursor hitCount:%d/%d ,max:%d vector:%d/%d", Integer.valueOf(i2), Integer.valueOf(length), vector3.get(i), Integer.valueOf(i), Integer.valueOf(vector3.size()));
                                        i4 = i;
                                    }
                                }
                                a.close();
                                if (i4 < 0 || vector3.size() <= 0) {
                                    C7060h.pYm.mo8381e(12696, Integer.valueOf(201), Integer.valueOf(i3));
                                    C4990ab.m7421w("MicroMsg.VideoInfoStorage", "checkVideoHash cursor empty maxHitIndex:%d vector:%d", Integer.valueOf(i4), Integer.valueOf(vector3.size()));
                                    ui = "";
                                } else {
                                    int intValue = ((Integer) vector3.get(i4)).intValue();
                                    length = (intValue * 100) / 256;
                                    if (length < 77) {
                                        C7060h.pYm.mo8381e(12696, Integer.valueOf(202), Integer.valueOf(i3), Integer.valueOf(intValue), Integer.valueOf(0), Integer.valueOf(vector4.size()));
                                        C4990ab.m7421w("MicroMsg.VideoInfoStorage", "checkVideoHash NotEnoughHit. time:%d hit:%d percentMatch:%s arr:%d path:%s", Long.valueOf(C5046bo.m7566gb(anU)), Integer.valueOf(intValue), Integer.valueOf(length), Integer.valueOf(uk.length - 1), uh);
                                        ui = "";
                                    } else {
                                        str2 = C5046bo.nullAsNil((String) vector.get(i4));
                                        i2 = 0;
                                        int i5 = 0;
                                        while (i5 < vector3.size()) {
                                            if (i5 == i4 || ((Integer) vector3.get(i5)).intValue() < intValue || str2.hashCode() == ((String) vector.get(i5)).hashCode()) {
                                                i = i2;
                                            } else {
                                                i = i2 + 1;
                                            }
                                            i5++;
                                            i2 = i;
                                        }
                                        if (i2 > 0) {
                                            all.fni.mo10108hY("VideoHash", "delete from VideoHash where size = ".concat(String.valueOf(i3)));
                                            C7060h.pYm.mo8381e(12696, Integer.valueOf(203), Integer.valueOf(i3), Integer.valueOf(intValue), Integer.valueOf(0), Integer.valueOf(vector4.size()), Integer.valueOf(0), "", "", "", Integer.valueOf(i2));
                                            C4990ab.m7413e("MicroMsg.VideoInfoStorage", "checkVideoHash Not ONE hash hit this path, give up duplicate:%s path:%s", Integer.valueOf(i2), uh);
                                            ui = "";
                                        } else {
                                            anU = C5046bo.m7566gb(anU);
                                            long a2 = C5046bo.m7514a((Long) vector4.get(i4), 0);
                                            C7060h.pYm.mo8381e(12696, Integer.valueOf(300), String.format("%s,%s,%s,%s,%s", new Object[]{Integer.valueOf(i3), Integer.valueOf(intValue), Long.valueOf(a2), Integer.valueOf(vector4.size()), Long.valueOf(anU)}));
                                            C7060h.pYm.mo8381e(12696, Integer.valueOf(length + AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS), r5);
                                            C4990ab.m7417i("MicroMsg.VideoInfoStorage", "checkVideoHash Succ time:%s hit:%s match:%s%% savetime:%s path:%s xml:%s orgpath:%s", Long.valueOf(anU), Integer.valueOf(intValue), Integer.valueOf(length), Long.valueOf(a2), uh, str2, vector2.get(i4));
                                            ui = (String) vector2.get(i4);
                                            z5 = C5046bo.anU() % 1000 < ((long) (r14 * 10)) || length < 90;
                                            C4990ab.m7417i("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff should:%s now:%s ratio:%s percentMatch:%s debuger:%s", Boolean.valueOf(z5), Long.valueOf(anU), Integer.valueOf(r14), Integer.valueOf(length), Boolean.valueOf(C4872b.dnO()));
                                            if (z5 || C4872b.dnO()) {
                                                C7305d.m12298f(new C97252(uh, ui, r5), "checkVideoHashByteDiff");
                                            }
                                            ui = str2;
                                        }
                                    }
                                }
                            }
                        }
                        if (!C5046bo.isNullOrNil(ui)) {
                            split = ui.split("##");
                            if (z2 && split != null && split.length == 2) {
                                c42130g.field_fileId = split[0];
                                c42130g.field_aesKey = split[1];
                                this.fVH = true;
                            }
                            C4990ab.m7417i("MicroMsg.NetSceneUploadVideo", "%s CheckUseVideoHash debug:%s str:%s [%s,%s,%s] hasHash:%s [%s,%s]", alb(), Boolean.valueOf(C4872b.dnO()), r12, Boolean.valueOf(z3), Boolean.valueOf(z2), Boolean.valueOf(z4), Boolean.valueOf(this.fVH), c42130g.field_fileId, c42130g.field_aesKey);
                        }
                    }
                    split = null;
                    c42130g.field_fileId = split[0];
                    c42130g.field_aesKey = split[1];
                    this.fVH = true;
                    C4990ab.m7417i("MicroMsg.NetSceneUploadVideo", "%s CheckUseVideoHash debug:%s str:%s [%s,%s,%s] hasHash:%s [%s,%s]", alb(), Boolean.valueOf(C4872b.dnO()), r12, Boolean.valueOf(z3), Boolean.valueOf(z2), Boolean.valueOf(z4), Boolean.valueOf(this.fVH), c42130g.field_fileId, c42130g.field_aesKey);
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.NetSceneUploadVideo", "Check use videohash :%s", C5046bo.m7574l(e));
                }
            }
            C7060h c7060h = C7060h.pYm;
            objArr = new Object[2];
            i = this.fVH ? 1 : this.fVI ? 2 : 0;
            objArr[0] = Integer.valueOf(i + 700);
            objArr[1] = Integer.valueOf(this.fVj.frO);
            c7060h.mo8381e(12696, objArr);
            if (C5046bo.isNullOrNil(c42130g.field_aesKey) || C5046bo.isNullOrNil(c42130g.field_aesKey)) {
                ui = "";
                c42130g.field_aesKey = ui;
                c42130g.field_fileId = ui;
            }
            C4990ab.m7417i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn check hit cache VideoHash :%s %s %s %b %d", alb(), c42130g.field_mediaId, c42130g.field_fileId, c42130g.field_aesKey, Boolean.valueOf(this.fFs), Integer.valueOf(c42130g.field_largesvideo));
            if (C37461f.afx().mo51225e(c42130g)) {
                if (this.fVj.fXi != 1) {
                    this.fVj.fXi = 1;
                    this.fVj.status = 104;
                    this.fVj.clientId = this.fFa;
                    this.fVj.bJt = 524544;
                    C26494u.m42253f(this.fVj);
                }
                AppMethodBeat.m2505o(50698);
                return true;
            }
            C7060h.pYm.mo8378a(111, 226, 1, false);
            C4990ab.m7413e("MicroMsg.NetSceneUploadVideo", "%s cdntra addSendTask failed.", alb());
            this.fFa = "";
            AppMethodBeat.m2505o(50698);
            return false;
        }
        r4 = new Object[3];
        C37461f.afx();
        r4[1] = Boolean.valueOf(C31259b.m50439lg(2));
        r4[2] = Integer.valueOf(this.fVj.fXi);
        C4990ab.m7421w("MicroMsg.NetSceneUploadVideo", "%s cdntra not use cdn flag:%b getCdnInfo:%d", r4);
        AppMethodBeat.m2505o(50698);
        return false;
    }

    public C32842g(String str) {
        AppMethodBeat.m2504i(50699);
        Assert.assertTrue(str != null);
        C4990ab.m7410d("MicroMsg.NetSceneUploadVideo", "NetSceneUploadVideo:  file:".concat(String.valueOf(str)));
        this.fileName = str;
        this.fVj = C26494u.m42268ut(str);
        if (this.fVj != null) {
            this.MAX_TIMES = 2500;
        } else {
            this.MAX_TIMES = 0;
        }
        this.eOm = new C1446a();
        if (this.fVj != null && 3 == this.fVj.fXk) {
            this.fVl = C42129a.MediaType_TinyVideo;
        }
        C4990ab.m7417i("MicroMsg.NetSceneUploadVideo", "%s NetSceneUploadVideo:  videoType:[%d]", alb(), Integer.valueOf(this.fVl));
        AppMethodBeat.m2505o(50699);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(50700);
        this.ehi = c1202f;
        this.fVj = C26494u.m42268ut(this.fileName);
        if (this.fVj == null || !(this.fVj.status == 104 || this.fVj.status == 103)) {
            C4990ab.m7413e("MicroMsg.NetSceneUploadVideo", "%s Get info Failed file:", alb(), this.fileName);
            this.retCode = 0 - (C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
            AppMethodBeat.m2505o(50700);
            return -1;
        }
        StringBuilder append = new StringBuilder("doscene file:").append(this.fileName).append(" stat:").append(this.fVj.status).append(" [").append(this.fVj.fWZ).append(",").append(this.fVj.fXa).append("] [").append(this.fVj.fVG).append(",").append(this.fVj.frO).append("]  netTimes:").append(this.fVj.fXf).append(" times:");
        int i = this.fVL;
        this.fVL = i + 1;
        C4990ab.m7410d("MicroMsg.NetSceneUploadVideo", append.append(i).toString());
        if (this.startTime == 0) {
            this.startTime = C5046bo.anU();
            this.fVG = this.fVj.fVG;
        }
        C37961o.all();
        if (C26492r.m42229ub(C9720t.m17303uh(this.fileName))) {
            C4990ab.m7421w("MicroMsg.NetSceneUploadVideo", "%s it is mm h265 video xml[%s]", alb(), this.fVj.alw());
            C7060h.pYm.mo8378a(354, 139, 1, false);
        }
        if (ala()) {
            C4990ab.m7411d("MicroMsg.NetSceneUploadVideo", "cdntra use cdn return -1 for onGYNetEnd clientid:%s", this.fileName);
            AppMethodBeat.m2505o(50700);
            return 0;
        }
        String atg;
        if (this.fVj.fXh == 1) {
            this.cng = true;
        } else if (this.fVj.createTime + 600 < C5046bo.anT()) {
            C4990ab.m7412e("MicroMsg.NetSceneUploadVideo", "create time check error:" + this.fileName);
            C26494u.m42261um(this.fileName);
            this.retCode = 0 - (C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
            AppMethodBeat.m2505o(50700);
            return -1;
        } else if (!C26494u.m42260ul(this.fileName)) {
            C4990ab.m7412e("MicroMsg.NetSceneUploadVideo", "checkVoiceNetTimes Failed file:" + this.fileName);
            C26494u.m42261um(this.fileName);
            this.retCode = 0 - (C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
            AppMethodBeat.m2505o(50700);
            return -1;
        }
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cls();
        c1196a.fsK = new clt();
        c1196a.uri = "/cgi-bin/micromsg-bin/uploadvideo";
        c1196a.fsI = 149;
        c1196a.fsL = 39;
        c1196a.fsM = 1000000039;
        this.ehh = c1196a.acD();
        cls cls = (cls) this.ehh.fsG.fsP;
        cls.ndG = (String) C1720g.m3536RP().mo5239Ry().get(2, (Object) "");
        cls.ndF = this.fVj.getUser();
        cls.vFF = this.fileName;
        if (this.cng) {
            cls.xjr = 2;
        }
        if (this.fVj.fXk == 3) {
            cls.xjr = 3;
        }
        cls.wYj = this.fVj.fXd;
        cls.wEs = this.fVj.fXa;
        cls.xjo = this.fVj.frO;
        cls.wdl = C32856ab.m53750ch(C4996ah.getContext()) ? 1 : 2;
        cls.wEv = 2;
        cls.xjp = 0;
        cls.xjq = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        cls.wEu = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        if (C5046bo.isNullOrNil(this.cMW)) {
            C37961o.all();
            atg = C5730e.atg(C9720t.m17303uh(this.fileName));
            this.cMW = atg;
        } else {
            atg = this.cMW;
        }
        cls.xju = atg;
        cls.vEG = C1831bh.aae();
        cls.xjD = this.fVj.cMn;
        cfh cfh = this.fVj.fXm;
        if (cfh != null && !C5046bo.isNullOrNil(cfh.fiG)) {
            cls.xjv = C5046bo.m7532bc(cfh.fiG, "");
            cls.xjw = cfh.wid;
            cls.xjx = C5046bo.m7532bc(cfh.fiI, "");
            cls.xjz = C5046bo.m7532bc(cfh.fiK, "");
            cls.xjy = C5046bo.m7532bc(cfh.fiJ, "");
            cls.xjA = C5046bo.m7532bc(cfh.fiL, "");
        } else if (!(cfh == null || C5046bo.isNullOrNil(cfh.fiK) || C5046bo.isNullOrNil(cfh.fiJ))) {
            cls.xjz = cfh.fiK;
            cls.xjy = cfh.fiJ;
        }
        if (cfh != null) {
            cls.xjC = C5046bo.m7532bc(cfh.fiM, "");
            cls.xjB = C5046bo.m7532bc(cfh.fiN, "");
        }
        C4990ab.m7411d("MicroMsg.NetSceneUploadVideo", "upload video: play length %d, thumb totalLen %d, video totalLen %d, funcFlag %d, videoMd5: %s stream %s streamtime: %d title %s thumburl %s", Integer.valueOf(cls.wYj), Integer.valueOf(cls.wEt), Integer.valueOf(cls.xjo), Integer.valueOf(cls.xjr), cls.xju, cls.xjv, Integer.valueOf(cls.xjw), cls.xjx, cls.xjA);
        C9723b m;
        byte[] bArr;
        if (this.fVj.status == 103) {
            C37961o.all();
            m = C9720t.m17301m(C9720t.m17304ui(this.fileName), this.fVj.fWZ, fVE);
            if (m.ret < 0 || m.cqs == 0) {
                C7060h.pYm.mo8378a(111, 225, 1, false);
                C26494u.m42261um(this.fileName);
                C4990ab.m7412e("MicroMsg.NetSceneUploadVideo", "doScene READ THUMB[" + this.fileName + "]  Error ");
                this.retCode = 0 - (C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
                AppMethodBeat.m2505o(50700);
                return -1;
            }
            C4990ab.m7410d("MicroMsg.NetSceneUploadVideo", "doScene READ THUMB[" + this.fileName + "] read ret:" + m.ret + " readlen:" + m.cqs + " newOff:" + m.fXD + " netOff:" + this.fVj.fWZ);
            if (m.fXD < this.fVj.fWZ) {
                C4990ab.m7412e("MicroMsg.NetSceneUploadVideo", "Err doScene READ THUMB[" + this.fileName + "] newOff:" + m.fXD + " OldtOff:" + this.fVj.fWZ);
                C26494u.m42261um(this.fileName);
                this.retCode = 0 - (C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
                AppMethodBeat.m2505o(50700);
                return -1;
            }
            bArr = new byte[m.cqs];
            System.arraycopy(m.buf, 0, bArr, 0, m.cqs);
            cls.wEt = this.fVj.fWZ;
            cls.wEu = new SKBuiltinBuffer_t().setBuffer(bArr);
        } else {
            C37961o.all();
            m = C9720t.m17301m(C9720t.m17303uh(this.fileName), this.fVj.fVG, fVE);
            if (m.ret < 0 || m.cqs == 0) {
                C7060h.pYm.mo8378a(111, 224, 1, false);
                C26494u.m42261um(this.fileName);
                C4990ab.m7412e("MicroMsg.NetSceneUploadVideo", "doScene READ VIDEO[" + this.fileName + "]  Error ");
                this.retCode = 0 - (C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
                AppMethodBeat.m2505o(50700);
                return -1;
            }
            C4990ab.m7410d("MicroMsg.NetSceneUploadVideo", "doScene READ VIDEO[" + this.fileName + "] read ret:" + m.ret + " readlen:" + m.cqs + " newOff:" + m.fXD + " netOff:" + this.fVj.fVG);
            if (m.fXD < this.fVj.fVG) {
                C4990ab.m7412e("MicroMsg.NetSceneUploadVideo", "Err doScene READ VIDEO[" + this.fileName + "] newOff:" + m.fXD + " OldtOff:" + this.fVj.fVG);
                C26494u.m42261um(this.fileName);
                this.retCode = 0 - (C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
                AppMethodBeat.m2505o(50700);
                return -1;
            } else if (m.fXD >= C1878c.fUE) {
                C7060h.pYm.mo8378a(111, 222, 1, false);
                C4990ab.m7412e("MicroMsg.NetSceneUploadVideo", "Err doScene READ VIDEO[" + this.fileName + "] maxsize:" + C1878c.fUE);
                C26494u.m42261um(this.fileName);
                this.retCode = 0 - (C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
                AppMethodBeat.m2505o(50700);
                return -1;
            } else {
                bArr = new byte[m.cqs];
                System.arraycopy(m.buf, 0, bArr, 0, m.cqs);
                cls.xjp = this.fVj.fVG;
                cls.wEt = this.fVj.fWZ;
                cls.xjq = new SKBuiltinBuffer_t().setBuffer(bArr);
            }
        }
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(50700);
        return a;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        AppMethodBeat.m2504i(50701);
        cls cls = (cls) ((C7472b) c1929q).fsG.fsP;
        C1206b c1206b;
        if (C5046bo.isNullOrNil(cls.vFF) || cls.wEv <= 0 || C5046bo.isNullOrNil(cls.ndG) || C5046bo.isNullOrNil(cls.ndF) || cls.wdl <= 0 || cls.wEt > cls.wEs || cls.wEt < 0 || cls.xjp > cls.xjo || cls.xjp < 0 || ((cls.xjp == cls.xjo && cls.wEt == cls.wEs) || cls.wEs <= 0 || cls.xjo <= 0 || (cls.xjq.getILen() <= 0 && cls.wEu.getILen() <= 0))) {
            C4990ab.m7412e("MicroMsg.NetSceneUploadVideo", "ERR: Security Check Failed file:" + this.fileName + " user:" + cls.ndF);
            c1206b = C1206b.EFailed;
            AppMethodBeat.m2505o(50701);
            return c1206b;
        }
        c1206b = C1206b.EOk;
        AppMethodBeat.m2505o(50701);
        return c1206b;
    }

    public final int acn() {
        return this.MAX_TIMES;
    }

    /* renamed from: a */
    public final void mo4458a(C1205a c1205a) {
        AppMethodBeat.m2504i(50702);
        C7060h.pYm.mo8378a(111, 221, 1, false);
        C26494u.m42261um(this.fileName);
        AppMethodBeat.m2505o(50702);
    }

    public final boolean acJ() {
        AppMethodBeat.m2504i(50703);
        boolean acJ = super.acJ();
        if (acJ) {
            C7060h.pYm.mo8378a(111, 210, 1, false);
        }
        AppMethodBeat.m2505o(50703);
        return acJ;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(50704);
        C4990ab.m7410d("MicroMsg.NetSceneUploadVideo", "cdntra onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " useCdnTransClientId:" + this.fFa);
        if (this.fVm) {
            C4990ab.m7410d("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Call Stop by Service   file:" + this.fileName + " user:" + this.fVj.getUser());
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(50704);
        } else if (i2 == 3 && i3 == -1 && !C5046bo.isNullOrNil(this.fFa)) {
            C4990ab.m7421w("MicroMsg.NetSceneUploadVideo", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", this.fFa);
            AppMethodBeat.m2505o(50704);
        } else {
            clt clt = (clt) ((C7472b) c1929q).fsH.fsP;
            cls cls = (cls) ((C7472b) c1929q).fsG.fsP;
            this.fVj = C26494u.m42268ut(this.fileName);
            if (this.fVj == null) {
                C4990ab.m7412e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd Get INFO FAILED :" + this.fileName);
                this.retCode = (0 - C1447g.getLine()) - 10000;
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(50704);
            } else if (this.fVj.status == 105) {
                C4990ab.m7420w("MicroMsg.NetSceneUploadVideo", "onGYNetEnd STATUS PAUSE [" + this.fileName + "," + this.fVj.cKK + "," + this.fVj.alt() + "," + this.fVj.getUser() + "] ");
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(50704);
            } else if (this.fVj.status != 104 && this.fVj.status != 103) {
                C4990ab.m7412e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd STATUS ERR: status:" + this.fVj.status + " [" + this.fileName + "," + this.fVj.cKK + "," + this.fVj.alt() + "," + this.fVj.getUser() + "] ");
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(50704);
            } else if (i2 == 4 && i3 == -22) {
                C4990ab.m7412e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd BLACK  errtype:" + i2 + " errCode:" + i3 + "  file:" + this.fileName + " user:" + this.fVj.getUser());
                C26494u.m42262un(this.fileName);
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(50704);
            } else if (i2 == 4 && i3 != 0) {
                C7060h.pYm.mo8378a(111, 220, 1, false);
                C4990ab.m7412e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd SERVER FAILED errtype:" + i2 + " errCode:" + i3 + "  file:" + this.fileName + " user:" + this.fVj.getUser());
                C26494u.m42261um(this.fileName);
                C7060h.pYm.mo8381e(10420, Integer.valueOf(i3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(C5046bo.anU()), Integer.valueOf(C37458c.m63165bW(C4996ah.getContext())), Integer.valueOf(this.fVl), Integer.valueOf(0));
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(50704);
            } else if (i2 != 0 || i3 != 0) {
                C7060h.pYm.mo8378a(111, 219, 1, false);
                C4990ab.m7412e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + i2 + " errCode:" + i3 + "  file:" + this.fileName + " user:" + this.fVj.getUser());
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(50704);
            } else if (!C5046bo.m7540cb(cls.wEu.getBuffer().f1226wR) && cls.wEt != clt.wEt - cls.wEu.getILen()) {
                C4990ab.m7412e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Err Thumb Pos:[" + cls.wEt + "," + cls.wEu.getILen() + "," + clt.wEt + "] file:" + this.fileName + " user:" + cls.ndF);
                C26494u.m42261um(this.fileName);
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(50704);
            } else if (C5046bo.m7540cb(cls.xjq.getBuffer().f1226wR) || cls.xjp == clt.xjp - cls.xjq.getILen()) {
                this.fVj.fXb = C5046bo.anT();
                this.fVj.cKK = clt.ptF;
                this.fVj.bJt = 1028;
                C4990ab.m7411d("MicroMsg.NetSceneUploadVideo", "dkmsgid  set svrmsgid %d -> %d", Long.valueOf(this.fVj.cKK), Integer.valueOf(C1947ae.giA));
                if (!(CdnLogic.kMediaTypeFavoriteBigFile != C1947ae.giz || C1947ae.giA == 0 || this.fVj.cKK == 0)) {
                    this.fVj.cKK = (long) C1947ae.giA;
                    C1947ae.giA = 0;
                }
                Object obj = null;
                int i4 = this.fVj.status;
                if (i4 == 103) {
                    this.fVj.fWZ = cls.wEu.getILen() + cls.wEt;
                    this.fVj.bJt |= 64;
                    if (this.fVj.fWZ >= this.fVj.fXa) {
                        this.fVj.status = 104;
                        this.fVj.bJt |= 256;
                    }
                } else if (i4 == 104) {
                    this.fVj.fVG = cls.xjq.getILen() + cls.xjp;
                    this.fVj.bJt |= 8;
                    if (this.fVj.fVG >= this.fVj.frO) {
                        this.fVj.status = 199;
                        this.fVj.bJt |= 256;
                        C26494u.m42247d(this.fVj);
                        obj = 1;
                    }
                } else {
                    C4990ab.m7412e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd ERROR STATUS:" + i4 + " file:" + this.fileName + " user:" + cls.ndF);
                    C26494u.m42261um(this.fileName);
                    this.ehi.onSceneEnd(i2, i3, str, this);
                    AppMethodBeat.m2505o(50704);
                    return;
                }
                C26494u.m42253f(this.fVj);
                if (this.fVm) {
                    this.ehi.onSceneEnd(i2, i3, str, this);
                    AppMethodBeat.m2505o(50704);
                } else if (obj == null) {
                    this.frk.mo16770ae(10, 10);
                    AppMethodBeat.m2505o(50704);
                } else {
                    boolean z;
                    C45457b.fRa.mo73265j(((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf((long) this.fVj.fXe));
                    C7060h.pYm.mo8381e(10420, Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(C5046bo.anU()), Integer.valueOf(C37458c.m63165bW(C4996ah.getContext())), Integer.valueOf(this.fVl), Integer.valueOf(this.fVj.frO - this.fVG));
                    if (this.fVj == null) {
                        z = false;
                    } else {
                        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.fVj.getUser());
                        if (aoO == null || ((int) aoO.ewQ) <= 0) {
                            z = false;
                        } else {
                            z = aoO.dsf();
                        }
                    }
                    if (z || C1855t.m3943nl(this.fVj.getUser())) {
                        C4990ab.m7417i("MicroMsg.NetSceneUploadVideo", "upload to biz :%s", this.fVj.getUser());
                        if (this.fVj.cKK < 0) {
                            C4990ab.m7412e("MicroMsg.NetSceneUploadVideo", "ERR: finish video invaild MSGSVRID :" + this.fVj.cKK + " file:" + this.fileName + " toUser:" + this.fVj.getUser());
                            C26494u.m42261um(this.fileName);
                        }
                    } else {
                        C4990ab.m7416i("MicroMsg.NetSceneUploadVideo", "not upload to biz");
                        if (this.fVj.cKK <= 0) {
                            C4990ab.m7412e("MicroMsg.NetSceneUploadVideo", "ERR: finish video invaild MSGSVRID :" + this.fVj.cKK + " file:" + this.fileName + " toUser:" + this.fVj.getUser());
                            C26494u.m42261um(this.fileName);
                        }
                    }
                    long Mr = this.eOm != null ? this.eOm.mo4908Mr() : 0;
                    C4990ab.m7410d("MicroMsg.NetSceneUploadVideo", "!!!FIN: file:" + this.fileName + " toUser:" + this.fVj.getUser() + " msgsvrid:" + this.fVj.cKK + " thumbsize:" + this.fVj.fXa + " videosize:" + this.fVj.frO + " useTime:" + Mr);
                    C4990ab.m7410d("MicroMsg.NetSceneUploadVideo", "FinishLogForTime file:" + this.fileName + " packSize:" + fVE + " filesize:" + this.fVj.frO + " useTime:" + Mr);
                    C9713a.m17288a(this.fVj, 0);
                    this.ehi.onSceneEnd(i2, i3, str, this);
                    AppMethodBeat.m2505o(50704);
                }
            } else {
                C4990ab.m7412e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Err Thumb Pos:[" + cls.xjp + "," + cls.xjq.getILen() + "," + clt.xjp + "] file:" + this.fileName + " user:" + cls.ndF);
                C26494u.m42261um(this.fileName);
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(50704);
            }
        }
    }

    public final int getType() {
        return 149;
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x016e A:{SYNTHETIC, Splitter:B:42:0x016e} */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01d8  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0173 A:{SYNTHETIC, Splitter:B:45:0x0173} */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0180 A:{SYNTHETIC, Splitter:B:52:0x0180} */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0185 A:{SYNTHETIC, Splitter:B:55:0x0185} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x016e A:{SYNTHETIC, Splitter:B:42:0x016e} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0173 A:{SYNTHETIC, Splitter:B:45:0x0173} */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01d8  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0180 A:{SYNTHETIC, Splitter:B:52:0x0180} */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0185 A:{SYNTHETIC, Splitter:B:55:0x0185} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: tW */
    private String m53677tW(String str) {
        boolean z;
        Throwable e;
        AppMethodBeat.m2504i(50705);
        C5728b c5728b = new C5728b(str);
        C5728b c5728b2 = new C5728b(c5728b.dMC(), "send" + c5728b.getName());
        InputStream inputStream = null;
        OutputStream outputStream = null;
        boolean z2 = false;
        C4990ab.m7411d("MicroMsg.NetSceneUploadVideo", "getSendThumbnailPath:origin file: %d", Long.valueOf(c5728b.length()));
        InputStream p;
        OutputStream q;
        try {
            if (c5728b.length() <= 32768) {
                z = z2;
            } else if (c5728b2.exists()) {
                C4990ab.m7411d("MicroMsg.NetSceneUploadVideo", "dst file %s exist!", C5736j.m8649w(c5728b2.dMD()));
                z = true;
            } else {
                Options amj = C5056d.amj(C5736j.m8649w(c5728b.dMD()));
                String str2 = "MicroMsg.NetSceneUploadVideo";
                String str3 = "getSendThumbnailPath:options %s";
                Object[] objArr = new Object[1];
                objArr[0] = amj == null ? BuildConfig.COMMAND : amj.outWidth + "-" + amj.outHeight;
                C4990ab.m7417i(str2, str3, objArr);
                if (amj == null || (amj.outWidth <= C31128d.MIC_PTU_YOUJIALI && amj.outHeight <= C31128d.MIC_PTU_YOUJIALI)) {
                    p = C5730e.m8638p(c5728b);
                    try {
                        Bitmap a = C5056d.m7620a(p, 0.0f, (int) C31128d.MIC_PTU_YOUJIALI, (int) C31128d.MIC_PTU_YOUJIALI);
                        if (a != null) {
                            q = C5730e.m8641q(c5728b2);
                            try {
                                z = a.compress(CompressFormat.JPEG, 60, q);
                                outputStream = q;
                                inputStream = p;
                            } catch (Exception e2) {
                                e = e2;
                                try {
                                    C4990ab.m7413e("MicroMsg.NetSceneUploadVideo", "exception: %s", C5046bo.m7574l(e));
                                    if (p != null) {
                                    }
                                    if (q != null) {
                                    }
                                    if (z) {
                                    }
                                } catch (Throwable th) {
                                    e = th;
                                    outputStream = q;
                                    inputStream = p;
                                    if (inputStream != null) {
                                    }
                                    if (outputStream != null) {
                                    }
                                    AppMethodBeat.m2505o(50705);
                                    throw e;
                                }
                            }
                        }
                        z = z2;
                        inputStream = p;
                    } catch (Exception e3) {
                        e = e3;
                        q = null;
                        C4990ab.m7413e("MicroMsg.NetSceneUploadVideo", "exception: %s", C5046bo.m7574l(e));
                        if (p != null) {
                        }
                        if (q != null) {
                        }
                        if (z) {
                        }
                    } catch (Throwable th2) {
                        e = th2;
                        inputStream = p;
                        if (inputStream != null) {
                        }
                        if (outputStream != null) {
                        }
                        AppMethodBeat.m2505o(50705);
                        throw e;
                    }
                }
                z = C5056d.m7629a(C5736j.m8649w(c5728b.dMD()), (int) C31128d.MIC_PTU_YOUJIALI, (int) C31128d.MIC_PTU_YOUJIALI, CompressFormat.JPEG, 60, C5736j.m8649w(c5728b2.dMC().dMD()) + "/", c5728b2.getName());
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e5) {
                }
            }
        } catch (Exception e6) {
            e = e6;
            q = null;
            p = null;
            C4990ab.m7413e("MicroMsg.NetSceneUploadVideo", "exception: %s", C5046bo.m7574l(e));
            if (p != null) {
                try {
                    p.close();
                } catch (IOException e7) {
                }
            }
            if (q != null) {
                try {
                    q.close();
                    z = z2;
                } catch (IOException e8) {
                    z = z2;
                }
            } else {
                z = z2;
            }
            if (z) {
            }
        } catch (Throwable th3) {
            e = th3;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e9) {
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e10) {
                }
            }
            AppMethodBeat.m2505o(50705);
            throw e;
        }
        if (z) {
            C4990ab.m7417i("MicroMsg.NetSceneUploadVideo", "%s compress success: length=%d | path=%s", alb(), Long.valueOf(c5728b2.length()), C5736j.m8649w(c5728b2.dMD()));
            str = C5736j.m8649w(c5728b2.dMD());
            AppMethodBeat.m2505o(50705);
            return str;
        }
        C4990ab.m7417i("MicroMsg.NetSceneUploadVideo", "%s compress fail: origin length=%d | path=%s", alb(), Long.valueOf(c5728b.length()), C5736j.m8649w(c5728b.dMD()));
        AppMethodBeat.m2505o(50705);
        return str;
    }

    private String alb() {
        AppMethodBeat.m2504i(50706);
        String str = this.fileName + "_" + hashCode();
        AppMethodBeat.m2505o(50706);
        return str;
    }

    public final void cancel() {
        AppMethodBeat.m2504i(50697);
        C4990ab.m7417i("MicroMsg.NetSceneUploadVideo", "%s stop %s", alb(), this.fFa);
        if (!C5046bo.isNullOrNil(this.fFa)) {
            C37461f.afx().mo51227rN(this.fFa);
        }
        this.fVm = true;
        super.cancel();
        AppMethodBeat.m2505o(50697);
    }

    /* renamed from: l */
    static /* synthetic */ int m53673l(C32842g c32842g) {
        AppMethodBeat.m2504i(50708);
        C37961o.all();
        String uh = C9720t.m17303uh(c32842g.fVj.getFileName());
        if (C42258c.m74643vC(uh)) {
            int i;
            C45479b c45479b = new C45479b();
            long vB = c45479b.mo73275vB(uh);
            long j = c45479b.gjP;
            if (vB >= 131072 || vB <= 0 || c32842g.fVj.fXd <= 5 || c45479b.gjQ <= 0 || j <= 0) {
                i = 0;
            } else {
                i = ((int) j) + ((int) ((c45479b.gjQ * 5) / ((long) c32842g.fVj.fXd)));
                if (i <= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
                    i += WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
                }
            }
            C4990ab.m7417i("MicroMsg.NetSceneUploadVideo", "%s check preload length[%d] moovPos[%d %d] duration[%d] filelen[%d]", c32842g.alb(), Integer.valueOf(i), Long.valueOf(vB), Long.valueOf(j), Integer.valueOf(c32842g.fVj.fXd), Long.valueOf(c45479b.gjQ));
            AppMethodBeat.m2505o(50708);
            return i;
        }
        C4990ab.m7421w("MicroMsg.NetSceneUploadVideo", "%s check preload length but it not mp4.", c32842g.alb());
        AppMethodBeat.m2505o(50708);
        return 0;
    }
}

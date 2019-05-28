package com.tencent.mm.modelvideo;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.i;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.t;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cfh;
import com.tencent.mm.protocal.protobuf.cls;
import com.tencent.mm.protocal.protobuf.clt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ad;
import com.tencent.mm.vfs.e;
import com.tencent.smtt.sdk.TbsMediaPlayer.TbsMediaPlayerListener;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.ugc.TXRecordCommon;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Vector;
import junit.framework.Assert;

public final class g extends m implements k {
    private static int fVE = TXRecordCommon.AUDIO_SAMPLERATE_32000;
    private final int MAX_TIMES;
    private String cMW = "";
    boolean cng = false;
    a eOm = null;
    private b ehh;
    private f ehi;
    private String fFa = "";
    private com.tencent.mm.i.g.a fFk = new com.tencent.mm.i.g.a() {
        public final int a(String str, int i, c cVar, final d dVar, boolean z) {
            AppMethodBeat.i(50695);
            ab.d("MicroMsg.NetSceneUploadVideo", "%s cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", g.a(g.this), g.this.fFa, Integer.valueOf(i), cVar, dVar);
            if (i == -21005) {
                ab.d("MicroMsg.NetSceneUploadVideo", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", g.this.fFa);
                AppMethodBeat.o(50695);
                return 0;
            } else if (i != 0) {
                u.um(g.this.fileName);
                new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.r(Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(g.this.startTime), Long.valueOf(bo.anU()), Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext())), Integer.valueOf(g.this.fVl), Integer.valueOf(0), "")).ajK();
                g.this.ehi.onSceneEnd(3, i, "", g.this);
                AppMethodBeat.o(50695);
                return 0;
            } else {
                g.this.fVj = u.ut(g.this.fileName);
                int i2;
                if (g.this.fVj == null || g.this.fVj.status == 105) {
                    if (g.this.fVj == null) {
                        i2 = -1;
                    } else {
                        i2 = g.this.fVj.status;
                    }
                    ab.i("MicroMsg.NetSceneUploadVideo", "%s info is null or has paused, status:%d", g.a(g.this), Integer.valueOf(i2));
                    com.tencent.mm.al.f.afx().rN(g.this.fFa);
                    g.this.ehi.onSceneEnd(3, i, "info is null or has paused, status".concat(String.valueOf(i2)), g.this);
                    AppMethodBeat.o(50695);
                    return 0;
                } else if (cVar == null) {
                    if (dVar != null) {
                        String r;
                        if (dVar.field_retCode != 0) {
                            ab.e("MicroMsg.NetSceneUploadVideo", "%s cdntra sceneResult.retCode :%d arg[%s] info[%s]", g.a(g.this), Integer.valueOf(dVar.field_retCode), dVar.field_arg, dVar.field_transInfo);
                            u.um(g.this.fileName);
                            r = com.tencent.mm.plugin.report.a.r(Integer.valueOf(dVar.field_retCode), Integer.valueOf(1), Long.valueOf(g.this.startTime), Long.valueOf(bo.anU()), Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext())), Integer.valueOf(g.this.fVl), Integer.valueOf(dVar.field_fileLength), dVar.field_transInfo, "", "", "", "", "", "", "", dVar.efY);
                            new com.tencent.mm.g.b.a.f(r).ajK();
                            new com.tencent.mm.g.b.a.d(r).ajK();
                            g.this.ehi.onSceneEnd(3, dVar.field_retCode, "", g.this);
                        } else {
                            ab.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn uploadvideo by cdn, videohash isHitCacheUpload: %d, enableHitcheck:%b", g.a(g.this), Integer.valueOf(dVar.field_UploadHitCacheType), Boolean.valueOf(g.this.fFs));
                            h hVar = h.pYm;
                            Object[] objArr = new Object[2];
                            i2 = g.this.fVI ? 810 : g.this.fVH ? 820 : 830;
                            objArr[0] = Integer.valueOf(i2 + dVar.field_UploadHitCacheType);
                            objArr[1] = Integer.valueOf(g.this.fVj.frO);
                            hVar.e(12696, objArr);
                            boolean z2 = dVar.field_isVideoReduced;
                            ab.i("MicroMsg.NetSceneUploadVideo", "%s it video was reduced by cdn %b %s", g.a(g.this), Boolean.valueOf(z2), g.this.fileName);
                            if (z2) {
                                h.pYm.a(106, 200, 1, false);
                            } else {
                                h.pYm.a(106, 205, 1, false);
                                if (g.this.fVJ > 0 && dVar.field_thumbimgLength > 0) {
                                    ab.i("MicroMsg.NetSceneUploadVideo", "%s send video thumb too big thumb length [%d, %d] ", g.a(g.this), Integer.valueOf(g.this.fVJ), Integer.valueOf(dVar.field_thumbimgLength));
                                    if (g.this.fVJ * 2 > dVar.field_thumbimgLength) {
                                        h.pYm.a(106, 206, 1, false);
                                    } else {
                                        h.pYm.a(106, 207, 1, false);
                                    }
                                }
                                o.all();
                                ab.i("MicroMsg.NetSceneUploadVideo", "%s send video too big thumb length [%d, %d] ", g.a(g.this), Integer.valueOf(g.this.fVj.frO), Integer.valueOf((int) e.asZ(t.uh(g.this.fileName))));
                                if (g.this.fVj.frO != ((int) e.asZ(t.uh(g.this.fileName)))) {
                                    h.pYm.a(106, 208, 1, false);
                                } else {
                                    h.pYm.a(106, 209, 1, false);
                                }
                            }
                            g.this.fVj = u.ut(g.this.fileName);
                            if (bo.isNullOrNil(g.this.fVj.alw())) {
                                ab.i("MicroMsg.NetSceneUploadVideo", "%s cdn callback new build cdnInfo:%s", g.a(g.this), ((("<msg><videomsg aeskey=\"" + dVar.field_aesKey + "\" cdnthumbaeskey=\"" + dVar.field_aesKey + "\" cdnvideourl=\"" + dVar.field_fileId + "\" ") + "cdnthumburl=\"" + dVar.field_fileId + "\" ") + "length=\"" + dVar.field_fileLength + "\" ") + "cdnthumblength=\"" + dVar.field_thumbimgLength + "\"/></msg>");
                                g.this.fVj.fXj = r;
                                u.f(g.this.fVj);
                            }
                            Map z3 = br.z(g.this.fVj.alw(), "msg");
                            if (z3 != null) {
                                t all = o.all();
                                o.all();
                                boolean s = all.s(t.uh(g.this.fileName), (String) z3.get(".msg.videomsg.$cdnvideourl"), (String) z3.get(".msg.videomsg.$aeskey"));
                                hVar = h.pYm;
                                objArr = new Object[2];
                                if (s) {
                                    i2 = 1;
                                } else {
                                    i2 = 2;
                                }
                                objArr[0] = Integer.valueOf(i2 + TbsMediaPlayerListener.MEDIA_INFO_TIMED_TEXT_ERROR);
                                objArr[1] = Integer.valueOf(g.this.fVj.frO);
                                hVar.e(12696, objArr);
                            }
                            p Rg = com.tencent.mm.kernel.g.Rg();
                            String c = g.this.fileName;
                            if (z2) {
                                i2 = 0;
                            } else {
                                i2 = g.l(g.this);
                            }
                            Rg.a(new h(c, i2, dVar, new h.a() {
                                public final void cC(int i, int i2) {
                                    AppMethodBeat.i(50694);
                                    if (i == 4 && i2 == 102) {
                                        com.tencent.mm.kernel.g.RS().aa(new Runnable() {
                                            public final void run() {
                                                AppMethodBeat.i(50693);
                                                g.this.fFs = false;
                                                g.this.fVj.status = 104;
                                                g.this.fVj.createTime = bo.anT();
                                                g.this.fVj.fXb = bo.anT();
                                                g.this.fVj.fVG = 0;
                                                g.this.fVj.bJt = 1800;
                                                boolean f = u.f(g.this.fVj);
                                                ab.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn MM_ERR_GET_AESKEY_FAILED doScene again enableHitcheck[%b], ret[%b] new createtime:%d", g.a(g.this), Boolean.valueOf(g.this.fFs), Boolean.valueOf(f), Long.valueOf(g.this.fVj.createTime));
                                                g.this.a(g.this.ftf, g.this.ehi);
                                                AppMethodBeat.o(50693);
                                            }
                                        });
                                        AppMethodBeat.o(50694);
                                        return;
                                    }
                                    new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.r(Integer.valueOf(i2), Integer.valueOf(1), Long.valueOf(g.this.startTime), Long.valueOf(bo.anU()), Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext())), Integer.valueOf(g.this.fVl), Integer.valueOf(dVar.field_fileLength), dVar.field_transInfo, "", "", "", "", "", "", "", dVar.efY)).ajK();
                                    a.a(g.this.fVj, 0);
                                    g.a(g.this, dVar);
                                    g.this.ehi.onSceneEnd(i, i2, "", g.this);
                                    AppMethodBeat.o(50694);
                                }
                            }), 0);
                        }
                    }
                    AppMethodBeat.o(50695);
                    return 0;
                } else if (g.this.fVj.fVG > cVar.field_finishedLength) {
                    ab.w("MicroMsg.NetSceneUploadVideo", "%s cdntra cdnEndProc error oldpos:%d newpos:%d", g.a(g.this), Integer.valueOf(g.this.fVj.fVG), Integer.valueOf(cVar.field_finishedLength));
                    AppMethodBeat.o(50695);
                    return 0;
                } else {
                    g.this.fVj.fXb = bo.anT();
                    g.this.fVj.fVG = cVar.field_finishedLength;
                    g.this.fVj.bJt = FilterEnum4Shaka.MIC_SHAKA_ADD_13;
                    u.f(g.this.fVj);
                    AppMethodBeat.o(50695);
                    return 0;
                }
            }
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        public final byte[] l(String str, byte[] bArr) {
            return null;
        }
    };
    private boolean fFs = true;
    private final long fVF = 1800000;
    private int fVG = -1;
    private boolean fVH = false;
    private boolean fVI = false;
    private int fVJ = 0;
    private int fVK = 0;
    int fVL = 0;
    public s fVj;
    private int fVl = com.tencent.mm.i.a.MediaType_VIDEO;
    private boolean fVm = false;
    public String fileName;
    ap frk = new ap(new ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(50696);
            if (g.this.a(g.this.ftf, g.this.ehi) == -1) {
                g.this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
                g.this.ehi.onSceneEnd(3, -1, "doScene failed", g.this);
            }
            AppMethodBeat.o(50696);
            return false;
        }
    }, true);
    int retCode = 0;
    private long startTime = 0;

    private boolean ala() {
        AppMethodBeat.i(50698);
        if (t.nJ(this.fVj.getUser())) {
            ab.w("MicroMsg.NetSceneUploadVideo", "%s cdntra not use cdn user:%s", alb(), this.fVj.getUser());
            AppMethodBeat.o(50698);
            return false;
        }
        com.tencent.mm.al.f.afx();
        if (com.tencent.mm.al.b.lg(2) || this.fVj.fXi == 1) {
            this.fFa = com.tencent.mm.al.c.a("upvideo", this.fVj.createTime, this.fVj.getUser(), this.fVj.getFileName());
            if (bo.isNullOrNil(this.fFa)) {
                ab.w("MicroMsg.NetSceneUploadVideo", "%s cdntra genClientId failed not use cdn file:%s", alb(), this.fVj.getFileName());
                AppMethodBeat.o(50698);
                return false;
            }
            o.all();
            String ui = t.ui(this.fileName);
            o.all();
            String uh = t.uh(this.fileName);
            com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
            gVar.egl = this.fFk;
            gVar.field_mediaId = this.fFa;
            gVar.field_fullpath = uh;
            gVar.field_thumbpath = tW(ui);
            gVar.field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
            gVar.field_enable_hitcheck = this.fFs;
            gVar.field_largesvideo = com.tencent.mm.modelcontrol.d.afF().rT(uh) ? 1 : 0;
            if (this.fVj != null && 3 == this.fVj.fXk) {
                gVar.field_smallVideoFlag = 1;
            }
            String str = "MicroMsg.NetSceneUploadVideo";
            String str2 = "%s upload video MMSightExtInfo is null? %b %s";
            Object[] objArr = new Object[3];
            objArr[0] = alb();
            objArr[1] = Boolean.valueOf(this.fVj.fXn == null);
            objArr[2] = this.fileName;
            ab.i(str, str2, objArr);
            if (this.fVj.fXn != null && this.fVj.fXn.wDP) {
                ab.i("MicroMsg.NetSceneUploadVideo", "%s local capture video, mark use large video", alb());
                o.all();
                n.alj().a("", t.uh(this.fileName), this.fVj.getUser(), "", "", 2, 2);
                com.tencent.mm.modelcontrol.d.afF();
                gVar.field_largesvideo = com.tencent.mm.modelcontrol.d.a(com.tencent.mm.modelcontrol.d.afF().afG());
            }
            str = "MicroMsg.NetSceneUploadVideo";
            str2 = "%s checkAD file:%s adinfo:%s";
            objArr = new Object[3];
            objArr[0] = alb();
            objArr[1] = this.fVj.getFileName();
            objArr[2] = this.fVj.fXm == null ? BuildConfig.COMMAND : this.fVj.fXm.fiM;
            ab.i(str, str2, objArr);
            if (!(this.fVj.fXm == null || bo.isNullOrNil(this.fVj.fXm.fiM))) {
                gVar.field_advideoflag = 1;
            }
            gVar.field_talker = this.fVj.getUser();
            gVar.field_chattype = t.kH(this.fVj.getUser()) ? 1 : 0;
            gVar.field_priority = com.tencent.mm.i.a.efC;
            gVar.field_needStorage = false;
            gVar.field_isStreamMedia = false;
            gVar.field_trysafecdn = true;
            this.fVK = (int) e.asZ(gVar.field_fullpath);
            this.fVJ = (int) e.asZ(gVar.field_thumbpath);
            if (this.fVJ >= com.tencent.mm.i.a.efW) {
                ab.w("MicroMsg.NetSceneUploadVideo", "%s cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", alb(), gVar.field_thumbpath, Integer.valueOf(this.fVJ));
                AppMethodBeat.o(50698);
                return false;
            }
            int i;
            Map z = br.z(this.fVj.alw(), "msg");
            if (z != null) {
                gVar.field_fileId = (String) z.get(".msg.videomsg.$cdnvideourl");
                gVar.field_aesKey = (String) z.get(".msg.videomsg.$aeskey");
                this.fVI = true;
            } else {
                ab.i("MicroMsg.NetSceneUploadVideo", "%s cdntra parse video recv xml failed", alb());
                try {
                    boolean z2;
                    boolean z3;
                    boolean z4;
                    String[] split;
                    String[] split2 = bo.nullAsNil(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("UseVideoHash")).split(",");
                    com.tencent.mm.kernel.g.RQ();
                    com.tencent.mm.kernel.g.RN();
                    int bL = i.bL(com.tencent.mm.kernel.a.QF(), 100);
                    boolean z5 = (split2 == null || split2.length <= 0) ? false : bo.getInt(split2[0], 0) >= bL;
                    boolean z6 = (split2 == null || split2.length < 2) ? false : bo.getInt(split2[1], 0) >= bL;
                    boolean z7 = (split2 == null || split2.length < 3) ? false : bo.getInt(split2[2], 0) >= bL;
                    if (com.tencent.mm.sdk.a.b.dnO()) {
                        z2 = true;
                        z3 = true;
                        z4 = true;
                    } else {
                        z2 = z6;
                        z3 = z5;
                        z4 = z7;
                    }
                    if (z3) {
                        t all = o.all();
                        ab.i("MicroMsg.VideoInfoStorage", "checkVideoHash in fullCheckRatio:%s path:%s stack:%s", Integer.valueOf(bo.getInt(split2[2], 0)), uh, bo.dpG());
                        long anU = bo.anU();
                        if (bo.isNullOrNil(uh)) {
                            ab.e("MicroMsg.VideoInfoStorage", "checkVideoHash failed , path:%s ", uh);
                            ui = "";
                        } else {
                            int[] uk = t.uk(uh);
                            if (uk == null || uk.length < 33) {
                                ab.e("MicroMsg.VideoInfoStorage", "checkVideoHash  readHash failed :%s", uh);
                                ui = "";
                            } else {
                                int i2;
                                all.fni.hY("VideoHash", "delete from VideoHash where CreateTime < " + (bo.anT() - 432000));
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
                                Cursor a = all.fni.a("select size, CreateTime, hash, cdnxml, orgpath from VideoHash where size = ".concat(String.valueOf(i3)), null, 0);
                                while (a.moveToNext()) {
                                    long j = a.getLong(1);
                                    String string = a.getString(2);
                                    String string2 = a.getString(3);
                                    String string3 = a.getString(4);
                                    ab.v("MicroMsg.VideoInfoStorage", "checkVideoHash select [%s][%s]", string, string2);
                                    if (bo.isNullOrNil(string) || bo.isNullOrNil(string2)) {
                                        h.pYm.e(12696, Integer.valueOf(104), Integer.valueOf(i3));
                                        ab.w("MicroMsg.VideoInfoStorage", "checkVideoHash select error [%s][%s]", string, string2);
                                    } else if (length != string.length()) {
                                        h.pYm.e(12696, Integer.valueOf(105), Integer.valueOf(i3));
                                        ab.w("MicroMsg.VideoInfoStorage", "checkVideoHash err length file:%d cursor:%d", Integer.valueOf(length), Integer.valueOf(string.length()));
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
                                        ab.d("MicroMsg.VideoInfoStorage", "checkVideoHash cursor hitCount:%d/%d ,max:%d vector:%d/%d", Integer.valueOf(i2), Integer.valueOf(length), vector3.get(i), Integer.valueOf(i), Integer.valueOf(vector3.size()));
                                        i4 = i;
                                    }
                                }
                                a.close();
                                if (i4 < 0 || vector3.size() <= 0) {
                                    h.pYm.e(12696, Integer.valueOf(201), Integer.valueOf(i3));
                                    ab.w("MicroMsg.VideoInfoStorage", "checkVideoHash cursor empty maxHitIndex:%d vector:%d", Integer.valueOf(i4), Integer.valueOf(vector3.size()));
                                    ui = "";
                                } else {
                                    int intValue = ((Integer) vector3.get(i4)).intValue();
                                    length = (intValue * 100) / 256;
                                    if (length < 77) {
                                        h.pYm.e(12696, Integer.valueOf(202), Integer.valueOf(i3), Integer.valueOf(intValue), Integer.valueOf(0), Integer.valueOf(vector4.size()));
                                        ab.w("MicroMsg.VideoInfoStorage", "checkVideoHash NotEnoughHit. time:%d hit:%d percentMatch:%s arr:%d path:%s", Long.valueOf(bo.gb(anU)), Integer.valueOf(intValue), Integer.valueOf(length), Integer.valueOf(uk.length - 1), uh);
                                        ui = "";
                                    } else {
                                        str2 = bo.nullAsNil((String) vector.get(i4));
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
                                            all.fni.hY("VideoHash", "delete from VideoHash where size = ".concat(String.valueOf(i3)));
                                            h.pYm.e(12696, Integer.valueOf(203), Integer.valueOf(i3), Integer.valueOf(intValue), Integer.valueOf(0), Integer.valueOf(vector4.size()), Integer.valueOf(0), "", "", "", Integer.valueOf(i2));
                                            ab.e("MicroMsg.VideoInfoStorage", "checkVideoHash Not ONE hash hit this path, give up duplicate:%s path:%s", Integer.valueOf(i2), uh);
                                            ui = "";
                                        } else {
                                            anU = bo.gb(anU);
                                            long a2 = bo.a((Long) vector4.get(i4), 0);
                                            h.pYm.e(12696, Integer.valueOf(300), String.format("%s,%s,%s,%s,%s", new Object[]{Integer.valueOf(i3), Integer.valueOf(intValue), Long.valueOf(a2), Integer.valueOf(vector4.size()), Long.valueOf(anU)}));
                                            h.pYm.e(12696, Integer.valueOf(length + AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS), r5);
                                            ab.i("MicroMsg.VideoInfoStorage", "checkVideoHash Succ time:%s hit:%s match:%s%% savetime:%s path:%s xml:%s orgpath:%s", Long.valueOf(anU), Integer.valueOf(intValue), Integer.valueOf(length), Long.valueOf(a2), uh, str2, vector2.get(i4));
                                            ui = (String) vector2.get(i4);
                                            z5 = bo.anU() % 1000 < ((long) (r14 * 10)) || length < 90;
                                            ab.i("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff should:%s now:%s ratio:%s percentMatch:%s debuger:%s", Boolean.valueOf(z5), Long.valueOf(anU), Integer.valueOf(r14), Integer.valueOf(length), Boolean.valueOf(com.tencent.mm.sdk.a.b.dnO()));
                                            if (z5 || com.tencent.mm.sdk.a.b.dnO()) {
                                                com.tencent.mm.sdk.g.d.f(new com.tencent.mm.modelvideo.t.AnonymousClass2(uh, ui, r5), "checkVideoHashByteDiff");
                                            }
                                            ui = str2;
                                        }
                                    }
                                }
                            }
                        }
                        if (!bo.isNullOrNil(ui)) {
                            split = ui.split("##");
                            if (z2 && split != null && split.length == 2) {
                                gVar.field_fileId = split[0];
                                gVar.field_aesKey = split[1];
                                this.fVH = true;
                            }
                            ab.i("MicroMsg.NetSceneUploadVideo", "%s CheckUseVideoHash debug:%s str:%s [%s,%s,%s] hasHash:%s [%s,%s]", alb(), Boolean.valueOf(com.tencent.mm.sdk.a.b.dnO()), r12, Boolean.valueOf(z3), Boolean.valueOf(z2), Boolean.valueOf(z4), Boolean.valueOf(this.fVH), gVar.field_fileId, gVar.field_aesKey);
                        }
                    }
                    split = null;
                    gVar.field_fileId = split[0];
                    gVar.field_aesKey = split[1];
                    this.fVH = true;
                    ab.i("MicroMsg.NetSceneUploadVideo", "%s CheckUseVideoHash debug:%s str:%s [%s,%s,%s] hasHash:%s [%s,%s]", alb(), Boolean.valueOf(com.tencent.mm.sdk.a.b.dnO()), r12, Boolean.valueOf(z3), Boolean.valueOf(z2), Boolean.valueOf(z4), Boolean.valueOf(this.fVH), gVar.field_fileId, gVar.field_aesKey);
                } catch (Exception e) {
                    ab.e("MicroMsg.NetSceneUploadVideo", "Check use videohash :%s", bo.l(e));
                }
            }
            h hVar = h.pYm;
            objArr = new Object[2];
            i = this.fVH ? 1 : this.fVI ? 2 : 0;
            objArr[0] = Integer.valueOf(i + 700);
            objArr[1] = Integer.valueOf(this.fVj.frO);
            hVar.e(12696, objArr);
            if (bo.isNullOrNil(gVar.field_aesKey) || bo.isNullOrNil(gVar.field_aesKey)) {
                ui = "";
                gVar.field_aesKey = ui;
                gVar.field_fileId = ui;
            }
            ab.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn check hit cache VideoHash :%s %s %s %b %d", alb(), gVar.field_mediaId, gVar.field_fileId, gVar.field_aesKey, Boolean.valueOf(this.fFs), Integer.valueOf(gVar.field_largesvideo));
            if (com.tencent.mm.al.f.afx().e(gVar)) {
                if (this.fVj.fXi != 1) {
                    this.fVj.fXi = 1;
                    this.fVj.status = 104;
                    this.fVj.clientId = this.fFa;
                    this.fVj.bJt = 524544;
                    u.f(this.fVj);
                }
                AppMethodBeat.o(50698);
                return true;
            }
            h.pYm.a(111, 226, 1, false);
            ab.e("MicroMsg.NetSceneUploadVideo", "%s cdntra addSendTask failed.", alb());
            this.fFa = "";
            AppMethodBeat.o(50698);
            return false;
        }
        r4 = new Object[3];
        com.tencent.mm.al.f.afx();
        r4[1] = Boolean.valueOf(com.tencent.mm.al.b.lg(2));
        r4[2] = Integer.valueOf(this.fVj.fXi);
        ab.w("MicroMsg.NetSceneUploadVideo", "%s cdntra not use cdn flag:%b getCdnInfo:%d", r4);
        AppMethodBeat.o(50698);
        return false;
    }

    public g(String str) {
        AppMethodBeat.i(50699);
        Assert.assertTrue(str != null);
        ab.d("MicroMsg.NetSceneUploadVideo", "NetSceneUploadVideo:  file:".concat(String.valueOf(str)));
        this.fileName = str;
        this.fVj = u.ut(str);
        if (this.fVj != null) {
            this.MAX_TIMES = 2500;
        } else {
            this.MAX_TIMES = 0;
        }
        this.eOm = new a();
        if (this.fVj != null && 3 == this.fVj.fXk) {
            this.fVl = com.tencent.mm.i.a.MediaType_TinyVideo;
        }
        ab.i("MicroMsg.NetSceneUploadVideo", "%s NetSceneUploadVideo:  videoType:[%d]", alb(), Integer.valueOf(this.fVl));
        AppMethodBeat.o(50699);
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(50700);
        this.ehi = fVar;
        this.fVj = u.ut(this.fileName);
        if (this.fVj == null || !(this.fVj.status == 104 || this.fVj.status == 103)) {
            ab.e("MicroMsg.NetSceneUploadVideo", "%s Get info Failed file:", alb(), this.fileName);
            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
            AppMethodBeat.o(50700);
            return -1;
        }
        StringBuilder append = new StringBuilder("doscene file:").append(this.fileName).append(" stat:").append(this.fVj.status).append(" [").append(this.fVj.fWZ).append(",").append(this.fVj.fXa).append("] [").append(this.fVj.fVG).append(",").append(this.fVj.frO).append("]  netTimes:").append(this.fVj.fXf).append(" times:");
        int i = this.fVL;
        this.fVL = i + 1;
        ab.d("MicroMsg.NetSceneUploadVideo", append.append(i).toString());
        if (this.startTime == 0) {
            this.startTime = bo.anU();
            this.fVG = this.fVj.fVG;
        }
        o.all();
        if (r.ub(t.uh(this.fileName))) {
            ab.w("MicroMsg.NetSceneUploadVideo", "%s it is mm h265 video xml[%s]", alb(), this.fVj.alw());
            h.pYm.a(354, 139, 1, false);
        }
        if (ala()) {
            ab.d("MicroMsg.NetSceneUploadVideo", "cdntra use cdn return -1 for onGYNetEnd clientid:%s", this.fileName);
            AppMethodBeat.o(50700);
            return 0;
        }
        String atg;
        if (this.fVj.fXh == 1) {
            this.cng = true;
        } else if (this.fVj.createTime + 600 < bo.anT()) {
            ab.e("MicroMsg.NetSceneUploadVideo", "create time check error:" + this.fileName);
            u.um(this.fileName);
            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
            AppMethodBeat.o(50700);
            return -1;
        } else if (!u.ul(this.fileName)) {
            ab.e("MicroMsg.NetSceneUploadVideo", "checkVoiceNetTimes Failed file:" + this.fileName);
            u.um(this.fileName);
            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
            AppMethodBeat.o(50700);
            return -1;
        }
        b.a aVar = new b.a();
        aVar.fsJ = new cls();
        aVar.fsK = new clt();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadvideo";
        aVar.fsI = 149;
        aVar.fsL = 39;
        aVar.fsM = 1000000039;
        this.ehh = aVar.acD();
        cls cls = (cls) this.ehh.fsG.fsP;
        cls.ndG = (String) com.tencent.mm.kernel.g.RP().Ry().get(2, (Object) "");
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
        cls.wdl = com.tencent.mm.network.ab.ch(ah.getContext()) ? 1 : 2;
        cls.wEv = 2;
        cls.xjp = 0;
        cls.xjq = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        cls.wEu = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        if (bo.isNullOrNil(this.cMW)) {
            o.all();
            atg = e.atg(t.uh(this.fileName));
            this.cMW = atg;
        } else {
            atg = this.cMW;
        }
        cls.xju = atg;
        cls.vEG = bh.aae();
        cls.xjD = this.fVj.cMn;
        cfh cfh = this.fVj.fXm;
        if (cfh != null && !bo.isNullOrNil(cfh.fiG)) {
            cls.xjv = bo.bc(cfh.fiG, "");
            cls.xjw = cfh.wid;
            cls.xjx = bo.bc(cfh.fiI, "");
            cls.xjz = bo.bc(cfh.fiK, "");
            cls.xjy = bo.bc(cfh.fiJ, "");
            cls.xjA = bo.bc(cfh.fiL, "");
        } else if (!(cfh == null || bo.isNullOrNil(cfh.fiK) || bo.isNullOrNil(cfh.fiJ))) {
            cls.xjz = cfh.fiK;
            cls.xjy = cfh.fiJ;
        }
        if (cfh != null) {
            cls.xjC = bo.bc(cfh.fiM, "");
            cls.xjB = bo.bc(cfh.fiN, "");
        }
        ab.d("MicroMsg.NetSceneUploadVideo", "upload video: play length %d, thumb totalLen %d, video totalLen %d, funcFlag %d, videoMd5: %s stream %s streamtime: %d title %s thumburl %s", Integer.valueOf(cls.wYj), Integer.valueOf(cls.wEt), Integer.valueOf(cls.xjo), Integer.valueOf(cls.xjr), cls.xju, cls.xjv, Integer.valueOf(cls.xjw), cls.xjx, cls.xjA);
        t.b m;
        byte[] bArr;
        if (this.fVj.status == 103) {
            o.all();
            m = t.m(t.ui(this.fileName), this.fVj.fWZ, fVE);
            if (m.ret < 0 || m.cqs == 0) {
                h.pYm.a(111, 225, 1, false);
                u.um(this.fileName);
                ab.e("MicroMsg.NetSceneUploadVideo", "doScene READ THUMB[" + this.fileName + "]  Error ");
                this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
                AppMethodBeat.o(50700);
                return -1;
            }
            ab.d("MicroMsg.NetSceneUploadVideo", "doScene READ THUMB[" + this.fileName + "] read ret:" + m.ret + " readlen:" + m.cqs + " newOff:" + m.fXD + " netOff:" + this.fVj.fWZ);
            if (m.fXD < this.fVj.fWZ) {
                ab.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ THUMB[" + this.fileName + "] newOff:" + m.fXD + " OldtOff:" + this.fVj.fWZ);
                u.um(this.fileName);
                this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
                AppMethodBeat.o(50700);
                return -1;
            }
            bArr = new byte[m.cqs];
            System.arraycopy(m.buf, 0, bArr, 0, m.cqs);
            cls.wEt = this.fVj.fWZ;
            cls.wEu = new SKBuiltinBuffer_t().setBuffer(bArr);
        } else {
            o.all();
            m = t.m(t.uh(this.fileName), this.fVj.fVG, fVE);
            if (m.ret < 0 || m.cqs == 0) {
                h.pYm.a(111, 224, 1, false);
                u.um(this.fileName);
                ab.e("MicroMsg.NetSceneUploadVideo", "doScene READ VIDEO[" + this.fileName + "]  Error ");
                this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
                AppMethodBeat.o(50700);
                return -1;
            }
            ab.d("MicroMsg.NetSceneUploadVideo", "doScene READ VIDEO[" + this.fileName + "] read ret:" + m.ret + " readlen:" + m.cqs + " newOff:" + m.fXD + " netOff:" + this.fVj.fVG);
            if (m.fXD < this.fVj.fVG) {
                ab.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ VIDEO[" + this.fileName + "] newOff:" + m.fXD + " OldtOff:" + this.fVj.fVG);
                u.um(this.fileName);
                this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
                AppMethodBeat.o(50700);
                return -1;
            } else if (m.fXD >= c.fUE) {
                h.pYm.a(111, 222, 1, false);
                ab.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ VIDEO[" + this.fileName + "] maxsize:" + c.fUE);
                u.um(this.fileName);
                this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
                AppMethodBeat.o(50700);
                return -1;
            } else {
                bArr = new byte[m.cqs];
                System.arraycopy(m.buf, 0, bArr, 0, m.cqs);
                cls.xjp = this.fVj.fVG;
                cls.wEt = this.fVj.fWZ;
                cls.xjq = new SKBuiltinBuffer_t().setBuffer(bArr);
            }
        }
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(50700);
        return a;
    }

    public final m.b b(q qVar) {
        AppMethodBeat.i(50701);
        cls cls = (cls) ((b) qVar).fsG.fsP;
        m.b bVar;
        if (bo.isNullOrNil(cls.vFF) || cls.wEv <= 0 || bo.isNullOrNil(cls.ndG) || bo.isNullOrNil(cls.ndF) || cls.wdl <= 0 || cls.wEt > cls.wEs || cls.wEt < 0 || cls.xjp > cls.xjo || cls.xjp < 0 || ((cls.xjp == cls.xjo && cls.wEt == cls.wEs) || cls.wEs <= 0 || cls.xjo <= 0 || (cls.xjq.getILen() <= 0 && cls.wEu.getILen() <= 0))) {
            ab.e("MicroMsg.NetSceneUploadVideo", "ERR: Security Check Failed file:" + this.fileName + " user:" + cls.ndF);
            bVar = m.b.EFailed;
            AppMethodBeat.o(50701);
            return bVar;
        }
        bVar = m.b.EOk;
        AppMethodBeat.o(50701);
        return bVar;
    }

    public final int acn() {
        return this.MAX_TIMES;
    }

    public final void a(m.a aVar) {
        AppMethodBeat.i(50702);
        h.pYm.a(111, 221, 1, false);
        u.um(this.fileName);
        AppMethodBeat.o(50702);
    }

    public final boolean acJ() {
        AppMethodBeat.i(50703);
        boolean acJ = super.acJ();
        if (acJ) {
            h.pYm.a(111, 210, 1, false);
        }
        AppMethodBeat.o(50703);
        return acJ;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(50704);
        ab.d("MicroMsg.NetSceneUploadVideo", "cdntra onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " useCdnTransClientId:" + this.fFa);
        if (this.fVm) {
            ab.d("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Call Stop by Service   file:" + this.fileName + " user:" + this.fVj.getUser());
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(50704);
        } else if (i2 == 3 && i3 == -1 && !bo.isNullOrNil(this.fFa)) {
            ab.w("MicroMsg.NetSceneUploadVideo", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", this.fFa);
            AppMethodBeat.o(50704);
        } else {
            clt clt = (clt) ((b) qVar).fsH.fsP;
            cls cls = (cls) ((b) qVar).fsG.fsP;
            this.fVj = u.ut(this.fileName);
            if (this.fVj == null) {
                ab.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd Get INFO FAILED :" + this.fileName);
                this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(50704);
            } else if (this.fVj.status == 105) {
                ab.w("MicroMsg.NetSceneUploadVideo", "onGYNetEnd STATUS PAUSE [" + this.fileName + "," + this.fVj.cKK + "," + this.fVj.alt() + "," + this.fVj.getUser() + "] ");
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(50704);
            } else if (this.fVj.status != 104 && this.fVj.status != 103) {
                ab.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd STATUS ERR: status:" + this.fVj.status + " [" + this.fileName + "," + this.fVj.cKK + "," + this.fVj.alt() + "," + this.fVj.getUser() + "] ");
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(50704);
            } else if (i2 == 4 && i3 == -22) {
                ab.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd BLACK  errtype:" + i2 + " errCode:" + i3 + "  file:" + this.fileName + " user:" + this.fVj.getUser());
                u.un(this.fileName);
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(50704);
            } else if (i2 == 4 && i3 != 0) {
                h.pYm.a(111, 220, 1, false);
                ab.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd SERVER FAILED errtype:" + i2 + " errCode:" + i3 + "  file:" + this.fileName + " user:" + this.fVj.getUser());
                u.um(this.fileName);
                h.pYm.e(10420, Integer.valueOf(i3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bo.anU()), Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext())), Integer.valueOf(this.fVl), Integer.valueOf(0));
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(50704);
            } else if (i2 != 0 || i3 != 0) {
                h.pYm.a(111, 219, 1, false);
                ab.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + i2 + " errCode:" + i3 + "  file:" + this.fileName + " user:" + this.fVj.getUser());
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(50704);
            } else if (!bo.cb(cls.wEu.getBuffer().wR) && cls.wEt != clt.wEt - cls.wEu.getILen()) {
                ab.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Err Thumb Pos:[" + cls.wEt + "," + cls.wEu.getILen() + "," + clt.wEt + "] file:" + this.fileName + " user:" + cls.ndF);
                u.um(this.fileName);
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(50704);
            } else if (bo.cb(cls.xjq.getBuffer().wR) || cls.xjp == clt.xjp - cls.xjq.getILen()) {
                this.fVj.fXb = bo.anT();
                this.fVj.cKK = clt.ptF;
                this.fVj.bJt = 1028;
                ab.d("MicroMsg.NetSceneUploadVideo", "dkmsgid  set svrmsgid %d -> %d", Long.valueOf(this.fVj.cKK), Integer.valueOf(ae.giA));
                if (!(CdnLogic.kMediaTypeFavoriteBigFile != ae.giz || ae.giA == 0 || this.fVj.cKK == 0)) {
                    this.fVj.cKK = (long) ae.giA;
                    ae.giA = 0;
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
                        u.d(this.fVj);
                        obj = 1;
                    }
                } else {
                    ab.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd ERROR STATUS:" + i4 + " file:" + this.fileName + " user:" + cls.ndF);
                    u.um(this.fileName);
                    this.ehi.onSceneEnd(i2, i3, str, this);
                    AppMethodBeat.o(50704);
                    return;
                }
                u.f(this.fVj);
                if (this.fVm) {
                    this.ehi.onSceneEnd(i2, i3, str, this);
                    AppMethodBeat.o(50704);
                } else if (obj == null) {
                    this.frk.ae(10, 10);
                    AppMethodBeat.o(50704);
                } else {
                    boolean z;
                    com.tencent.mm.modelstat.b.fRa.j(((j) com.tencent.mm.kernel.g.K(j.class)).bOr().jf((long) this.fVj.fXe));
                    h.pYm.e(10420, Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bo.anU()), Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext())), Integer.valueOf(this.fVl), Integer.valueOf(this.fVj.frO - this.fVG));
                    if (this.fVj == null) {
                        z = false;
                    } else {
                        ad aoO = ((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoO(this.fVj.getUser());
                        if (aoO == null || ((int) aoO.ewQ) <= 0) {
                            z = false;
                        } else {
                            z = aoO.dsf();
                        }
                    }
                    if (z || t.nl(this.fVj.getUser())) {
                        ab.i("MicroMsg.NetSceneUploadVideo", "upload to biz :%s", this.fVj.getUser());
                        if (this.fVj.cKK < 0) {
                            ab.e("MicroMsg.NetSceneUploadVideo", "ERR: finish video invaild MSGSVRID :" + this.fVj.cKK + " file:" + this.fileName + " toUser:" + this.fVj.getUser());
                            u.um(this.fileName);
                        }
                    } else {
                        ab.i("MicroMsg.NetSceneUploadVideo", "not upload to biz");
                        if (this.fVj.cKK <= 0) {
                            ab.e("MicroMsg.NetSceneUploadVideo", "ERR: finish video invaild MSGSVRID :" + this.fVj.cKK + " file:" + this.fileName + " toUser:" + this.fVj.getUser());
                            u.um(this.fileName);
                        }
                    }
                    long Mr = this.eOm != null ? this.eOm.Mr() : 0;
                    ab.d("MicroMsg.NetSceneUploadVideo", "!!!FIN: file:" + this.fileName + " toUser:" + this.fVj.getUser() + " msgsvrid:" + this.fVj.cKK + " thumbsize:" + this.fVj.fXa + " videosize:" + this.fVj.frO + " useTime:" + Mr);
                    ab.d("MicroMsg.NetSceneUploadVideo", "FinishLogForTime file:" + this.fileName + " packSize:" + fVE + " filesize:" + this.fVj.frO + " useTime:" + Mr);
                    a.a(this.fVj, 0);
                    this.ehi.onSceneEnd(i2, i3, str, this);
                    AppMethodBeat.o(50704);
                }
            } else {
                ab.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Err Thumb Pos:[" + cls.xjp + "," + cls.xjq.getILen() + "," + clt.xjp + "] file:" + this.fileName + " user:" + cls.ndF);
                u.um(this.fileName);
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(50704);
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
    private String tW(String str) {
        boolean z;
        Throwable e;
        AppMethodBeat.i(50705);
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(str);
        com.tencent.mm.vfs.b bVar2 = new com.tencent.mm.vfs.b(bVar.dMC(), "send" + bVar.getName());
        InputStream inputStream = null;
        OutputStream outputStream = null;
        boolean z2 = false;
        ab.d("MicroMsg.NetSceneUploadVideo", "getSendThumbnailPath:origin file: %d", Long.valueOf(bVar.length()));
        InputStream p;
        OutputStream q;
        try {
            if (bVar.length() <= 32768) {
                z = z2;
            } else if (bVar2.exists()) {
                ab.d("MicroMsg.NetSceneUploadVideo", "dst file %s exist!", com.tencent.mm.vfs.j.w(bVar2.dMD()));
                z = true;
            } else {
                Options amj = com.tencent.mm.sdk.platformtools.d.amj(com.tencent.mm.vfs.j.w(bVar.dMD()));
                String str2 = "MicroMsg.NetSceneUploadVideo";
                String str3 = "getSendThumbnailPath:options %s";
                Object[] objArr = new Object[1];
                objArr[0] = amj == null ? BuildConfig.COMMAND : amj.outWidth + "-" + amj.outHeight;
                ab.i(str2, str3, objArr);
                if (amj == null || (amj.outWidth <= com.tencent.view.d.MIC_PTU_YOUJIALI && amj.outHeight <= com.tencent.view.d.MIC_PTU_YOUJIALI)) {
                    p = e.p(bVar);
                    try {
                        Bitmap a = com.tencent.mm.sdk.platformtools.d.a(p, 0.0f, (int) com.tencent.view.d.MIC_PTU_YOUJIALI, (int) com.tencent.view.d.MIC_PTU_YOUJIALI);
                        if (a != null) {
                            q = e.q(bVar2);
                            try {
                                z = a.compress(CompressFormat.JPEG, 60, q);
                                outputStream = q;
                                inputStream = p;
                            } catch (Exception e2) {
                                e = e2;
                                try {
                                    ab.e("MicroMsg.NetSceneUploadVideo", "exception: %s", bo.l(e));
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
                                    AppMethodBeat.o(50705);
                                    throw e;
                                }
                            }
                        }
                        z = z2;
                        inputStream = p;
                    } catch (Exception e3) {
                        e = e3;
                        q = null;
                        ab.e("MicroMsg.NetSceneUploadVideo", "exception: %s", bo.l(e));
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
                        AppMethodBeat.o(50705);
                        throw e;
                    }
                }
                z = com.tencent.mm.sdk.platformtools.d.a(com.tencent.mm.vfs.j.w(bVar.dMD()), (int) com.tencent.view.d.MIC_PTU_YOUJIALI, (int) com.tencent.view.d.MIC_PTU_YOUJIALI, CompressFormat.JPEG, 60, com.tencent.mm.vfs.j.w(bVar2.dMC().dMD()) + "/", bVar2.getName());
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
            ab.e("MicroMsg.NetSceneUploadVideo", "exception: %s", bo.l(e));
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
            AppMethodBeat.o(50705);
            throw e;
        }
        if (z) {
            ab.i("MicroMsg.NetSceneUploadVideo", "%s compress success: length=%d | path=%s", alb(), Long.valueOf(bVar2.length()), com.tencent.mm.vfs.j.w(bVar2.dMD()));
            str = com.tencent.mm.vfs.j.w(bVar2.dMD());
            AppMethodBeat.o(50705);
            return str;
        }
        ab.i("MicroMsg.NetSceneUploadVideo", "%s compress fail: origin length=%d | path=%s", alb(), Long.valueOf(bVar.length()), com.tencent.mm.vfs.j.w(bVar.dMD()));
        AppMethodBeat.o(50705);
        return str;
    }

    private String alb() {
        AppMethodBeat.i(50706);
        String str = this.fileName + "_" + hashCode();
        AppMethodBeat.o(50706);
        return str;
    }

    public final void cancel() {
        AppMethodBeat.i(50697);
        ab.i("MicroMsg.NetSceneUploadVideo", "%s stop %s", alb(), this.fFa);
        if (!bo.isNullOrNil(this.fFa)) {
            com.tencent.mm.al.f.afx().rN(this.fFa);
        }
        this.fVm = true;
        super.cancel();
        AppMethodBeat.o(50697);
    }

    static /* synthetic */ int l(g gVar) {
        AppMethodBeat.i(50708);
        o.all();
        String uh = t.uh(gVar.fVj.getFileName());
        if (com.tencent.mm.plugin.a.c.vC(uh)) {
            int i;
            com.tencent.mm.plugin.a.b bVar = new com.tencent.mm.plugin.a.b();
            long vB = bVar.vB(uh);
            long j = bVar.gjP;
            if (vB >= 131072 || vB <= 0 || gVar.fVj.fXd <= 5 || bVar.gjQ <= 0 || j <= 0) {
                i = 0;
            } else {
                i = ((int) j) + ((int) ((bVar.gjQ * 5) / ((long) gVar.fVj.fXd)));
                if (i <= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
                    i += WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
                }
            }
            ab.i("MicroMsg.NetSceneUploadVideo", "%s check preload length[%d] moovPos[%d %d] duration[%d] filelen[%d]", gVar.alb(), Integer.valueOf(i), Long.valueOf(vB), Long.valueOf(j), Integer.valueOf(gVar.fVj.fXd), Long.valueOf(bVar.gjQ));
            AppMethodBeat.o(50708);
            return i;
        }
        ab.w("MicroMsg.NetSceneUploadVideo", "%s check preload length but it not mp4.", gVar.alb());
        AppMethodBeat.o(50708);
        return 0;
    }
}

package com.tencent.mm.modelvideo;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.al.e;
import com.tencent.mm.i.c;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.n;
import com.tencent.mm.model.t;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.xl;
import com.tencent.mm.protocal.protobuf.xm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bi;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import junit.framework.Assert;

public final class d extends m implements k {
    private String cHr;
    private b ehh;
    f ehi;
    String fFa;
    String fFh;
    int fFi;
    private a fFk;
    boolean fVh;
    boolean fVi;
    s fVj;
    h fVk;
    int fVl;
    private boolean fVm;
    boolean fVn;
    long fVo;
    String fileName;
    int frO;
    private ap frk;
    int retCode;
    private int startOffset;
    long startTime;

    public final void cancel() {
        AppMethodBeat.i(50668);
        EH();
        super.cancel();
        AppMethodBeat.o(50668);
    }

    /* Access modifiers changed, original: final */
    public final boolean EH() {
        boolean z = false;
        AppMethodBeat.i(50669);
        if (!bo.isNullOrNil(this.cHr)) {
            if (this.fVh) {
                ab.i("MicroMsg.NetSceneDownloadVideo", "%s cancel online video task.", alb());
                o.alm().m(this.cHr, null);
            } else {
                ab.i("MicroMsg.NetSceneDownloadVideo", "%s cancel offline video task.", alb());
                com.tencent.mm.al.f.afx().rO(this.cHr);
            }
            z = true;
        }
        this.fVm = true;
        AppMethodBeat.o(50669);
        return z;
    }

    public d(String str) {
        this(str, false);
    }

    public d(String str, boolean z) {
        AppMethodBeat.i(50670);
        this.fVj = null;
        this.fFa = "";
        this.startOffset = 0;
        this.startTime = 0;
        this.frO = 0;
        this.retCode = 0;
        this.fVl = com.tencent.mm.i.a.MediaType_VIDEO;
        this.fVm = false;
        this.fVn = true;
        this.fFh = null;
        this.fFi = 0;
        this.fVo = 0;
        this.fFk = new a() {
            public final int a(String str, int i, c cVar, com.tencent.mm.i.d dVar, boolean z) {
                AppMethodBeat.i(50665);
                if (i == -21006) {
                    ab.d("MicroMsg.NetSceneDownloadVideo", "%s cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", d.this.alb(), d.this.fFa);
                    AppMethodBeat.o(50665);
                    return 0;
                } else if (i != 0) {
                    u.um(d.this.fileName);
                    String r = com.tencent.mm.plugin.report.a.r(Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(d.this.startTime), Long.valueOf(bo.anU()), Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext())), Integer.valueOf(d.this.fVl), Integer.valueOf(d.this.frO), "");
                    new com.tencent.mm.g.b.a.f(r).ajK();
                    new com.tencent.mm.g.b.a.d(r).ajK();
                    d.this.ehi.onSceneEnd(3, i, "", d.this);
                    AppMethodBeat.o(50665);
                    return 0;
                } else {
                    d.this.fVj = u.ut(d.this.fileName);
                    int i2;
                    if (d.this.fVj == null || d.this.fVj.status == 113) {
                        if (d.this.fVj == null) {
                            i2 = -1;
                        } else {
                            i2 = d.this.fVj.status;
                        }
                        ab.i("MicroMsg.NetSceneDownloadVideo", "%s upload video info is null or has paused, status:%d", d.this.alb(), Integer.valueOf(i2));
                        d.this.EH();
                        d.this.ehi.onSceneEnd(3, i, "upload video info is null or has paused, status".concat(String.valueOf(i2)), d.this);
                        AppMethodBeat.o(50665);
                        return 0;
                    } else if (cVar == null) {
                        if (dVar != null) {
                            ab.i("MicroMsg.NetSceneDownloadVideo", "%s cdntra sceneResult.retCode:%d useTime:%d ", d.this.alb(), Integer.valueOf(dVar.field_retCode), Long.valueOf(bo.anU() - d.this.fVo));
                            d dVar2 = d.this;
                            h hVar = d.this.fVk;
                            if (hVar == null || dVar == null) {
                                ab.w("MicroMsg.NetSceneDownloadVideo", "it had not task info or scene Result, don't report.");
                            } else if (hVar.field_smallVideoFlag == 1) {
                                ab.i("MicroMsg.NetSceneDownloadVideo", "it download short video, don't report.");
                            } else if (!(hVar == null || dVar == null)) {
                                ab.i("MicroMsg.NetSceneDownloadVideo", "%s sceneResult.field_recvedBytes %d, time [%d, %d]", dVar2.alb(), Integer.valueOf(dVar.field_recvedBytes), Long.valueOf(dVar.field_startTime), Long.valueOf(dVar.field_endTime));
                                o.alm();
                                e.a(null, dVar, hVar, true);
                            }
                            if (dVar.field_retCode != 0) {
                                u.um(d.this.fileName);
                                if (d.this.fVh) {
                                    com.tencent.mm.plugin.report.service.h.pYm.a(354, 13, 1, false);
                                }
                                if (d.this.fVi) {
                                    com.tencent.mm.plugin.report.service.h.pYm.a(354, 252, 1, false);
                                }
                                d.this.ehi.onSceneEnd(3, dVar.field_retCode, "", d.this);
                            } else {
                                if (d.this.fVh) {
                                    com.tencent.mm.plugin.report.service.h.pYm.a(354, 12, 1, false);
                                }
                                if (d.this.fVi) {
                                    com.tencent.mm.plugin.report.service.h.pYm.a(354, 137, 1, false);
                                }
                                d.this.mo(dVar.field_fileLength);
                            }
                            new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.r(Integer.valueOf(dVar.field_retCode), Integer.valueOf(2), Long.valueOf(d.this.startTime), Long.valueOf(bo.anU()), Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext())), Integer.valueOf(d.this.fVl), Integer.valueOf(d.this.frO), dVar.field_transInfo, "", "", "", "", "", "", "", dVar.efY)).ajK();
                            if (dVar.field_retCode != 0) {
                                new com.tencent.mm.g.b.a.d(com.tencent.mm.plugin.report.a.r(Integer.valueOf(dVar.field_retCode), Integer.valueOf(2), Long.valueOf(d.this.startTime), Long.valueOf(bo.anU()), Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext())), Integer.valueOf(d.this.fVl), Integer.valueOf(d.this.frO), dVar.field_transInfo, "", "", "", "", "", "", "", dVar.efY)).ajK();
                            }
                            a.a(d.this.fVj, 1);
                            d.this.fVk = null;
                        }
                        AppMethodBeat.o(50665);
                        return 0;
                    } else if (cVar.field_finishedLength == d.this.frO) {
                        ab.d("MicroMsg.NetSceneDownloadVideo", "cdntra ignore progress 100%");
                        AppMethodBeat.o(50665);
                        return 0;
                    } else if (d.this.fVj.fWY <= cVar.field_finishedLength || d.this.fVh) {
                        i2 = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                        d.this.fVj.fXb = bo.anT();
                        if (d.this.fVj.fWY < cVar.field_finishedLength) {
                            d.this.fVj.fWY = cVar.field_finishedLength;
                            i2 = 1040;
                        }
                        d.this.fVj.bJt = i2;
                        u.f(d.this.fVj);
                        ab.d("MicroMsg.NetSceneDownloadVideo", "%s cdntra progresscallback id:%s finish:%d total:%d", d.this.alb(), d.this.fFa, Integer.valueOf(cVar.field_finishedLength), Integer.valueOf(cVar.field_toltalLength));
                        AppMethodBeat.o(50665);
                        return 0;
                    } else {
                        ab.e("MicroMsg.NetSceneDownloadVideo", "%s cdnEndProc error oldpos:%d newpos:%d", d.this.alb(), Integer.valueOf(d.this.fVj.fWY), Integer.valueOf(cVar.field_finishedLength));
                        u.um(d.this.fileName);
                        d.this.ehi.onSceneEnd(3, i, "", d.this);
                        AppMethodBeat.o(50665);
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
        this.frk = new ap(new ap.a() {
            public final boolean BI() {
                AppMethodBeat.i(50667);
                if (d.this.a(d.this.ftf, d.this.ehi) == -1) {
                    d.this.ehi.onSceneEnd(3, -1, "doScene failed", d.this);
                }
                AppMethodBeat.o(50667);
                return false;
            }
        }, false);
        Assert.assertTrue(str != null);
        this.fileName = str;
        this.fVh = z;
        ab.i("MicroMsg.NetSceneDownloadVideo", "%s NetSceneDownloadVideo:  file [%s] isCompleteOnlineVideo [%b]", alb(), str, Boolean.valueOf(z));
        AppMethodBeat.o(50670);
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x04fc  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x05d2  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x05f1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean ala() {
        AppMethodBeat.i(50671);
        ab.d("MicroMsg.NetSceneDownloadVideo", "%s parseVideoMsgXML content: %s", alb(), this.fVj.alw());
        Map z = br.z(this.fVj.alw(), "msg");
        if (z == null) {
            com.tencent.mm.plugin.report.service.h.pYm.a(111, 214, 1, false);
            ab.w("MicroMsg.NetSceneDownloadVideo", "%s cdntra parse video recv xml failed", alb());
            AppMethodBeat.o(50671);
            return false;
        }
        String str = (String) z.get(".msg.videomsg.$cdnvideourl");
        String str2 = (String) z.get(".msg.videomsg.$tpvideourl");
        if (bo.isNullOrNil(str) && bo.isNullOrNil(str2)) {
            com.tencent.mm.plugin.report.service.h.pYm.a(111, 213, 1, false);
            ab.w("MicroMsg.NetSceneDownloadVideo", "%s cdntra parse video recv xml failed", alb());
            AppMethodBeat.o(50671);
            return false;
        }
        String str3 = (String) z.get(".msg.videomsg.$aeskey");
        this.frO = bo.getInt((String) z.get(".msg.videomsg.$length"), 0);
        String str4 = (String) z.get(".msg.videomsg.$fileparam");
        this.fFa = com.tencent.mm.al.c.a("downvideo", this.fVj.createTime, this.fVj.getUser(), this.fVj.getFileName());
        if (bo.isNullOrNil(this.fFa)) {
            ab.w("MicroMsg.NetSceneDownloadVideo", "%s cdntra genClientId failed not use cdn file:%s", alb(), this.fVj.getFileName());
            AppMethodBeat.o(50671);
            return false;
        }
        Object obj;
        if (!this.fVh && this.frO < 1048576 && this.fVj != null && this.fVj.cFa > 0) {
            this.fVh = true;
            ab.i("MicroMsg.NetSceneDownloadVideo", "%s less 1M and had preload, reset isCompleteOnlineVideo [%b]", alb(), Boolean.valueOf(this.fVh));
        }
        String str5 = (String) z.get(".msg.videomsg.$md5");
        StringBuilder stringBuilder = new StringBuilder();
        o.all();
        String stringBuilder2 = stringBuilder.append(t.uh(this.fileName)).append(".tmp").toString();
        this.fVk = new h();
        this.fVk.filename = this.fVj.getFileName();
        this.fVk.egB = str5;
        this.fVk.egC = this.frO;
        this.fVk.egD = 0;
        this.fVk.cEV = this.fVj.alt();
        this.fVk.egE = this.fVj.getUser();
        this.fVk.cEX = t.kH(this.fVj.getUser()) ? n.mA(this.fVj.getUser()) : 0;
        this.fVk.field_mediaId = this.fFa;
        this.fVk.field_fullpath = stringBuilder2;
        this.fVk.field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
        this.fVk.field_totalLen = this.frO;
        this.fVk.field_aesKey = str3;
        this.fVk.field_fileId = str;
        this.fVk.field_priority = com.tencent.mm.i.a.efC;
        this.fVk.egl = this.fFk;
        this.fVk.field_wxmsgparam = str4;
        this.fVk.field_chattype = t.kH(this.fVj.getUser()) ? 1 : 0;
        this.fVk.egF = this.fVj.egF;
        if (!bo.isNullOrNil(str2)) {
            str3 = (String) z.get(".msg.videomsg.$tpauthkey");
            this.fVk.field_fileId = "";
            this.fVk.field_fileType = 19;
            this.fVk.field_authKey = str3;
            this.fVk.egm = str2;
        }
        bi Q = ((j) g.K(j.class)).bOr().Q(this.fVj.getUser(), this.fVj.cKK);
        this.fVk.egH = Q.field_createTime;
        this.fVk.cKK = Q.field_msgSvrId;
        bf.b oE = bf.oE(Q.dqJ);
        this.fVk.egI = oE != null ? oE.fmG : 0;
        if (this.fVj.getUser().equals(Q.field_talker)) {
            this.fVk.field_limitrate = oE == null ? 0 : oE.fmE / 8;
        }
        ab.d("MicroMsg.NetSceneDownloadVideo", "%s limitrate:%d file:%s", alb(), Integer.valueOf(this.fVk.field_limitrate), this.fVj.getFileName());
        if (com.tencent.mm.al.f.afx().fyQ.contains("video_" + this.fVj.fXe)) {
            com.tencent.mm.al.f.afx().fyQ.remove("video_" + this.fVj.fXe);
            this.fVk.field_autostart = true;
        } else {
            this.fVk.field_autostart = false;
        }
        if (3 == this.fVj.fXk) {
            this.fVk.field_smallVideoFlag = 1;
        }
        if (!(bo.isNullOrNil(str5) || this.fVh)) {
            int i;
            str2 = ((com.tencent.mm.plugin.m.a.a) g.K(com.tencent.mm.plugin.m.a.a.class)).XT().es(str5, this.frO);
            int asZ = (int) com.tencent.mm.vfs.e.asZ(str2);
            int i2 = this.frO - asZ;
            o.all();
            str3 = t.uh(this.fileName);
            if (((int) com.tencent.mm.vfs.e.asZ(str3)) > 0) {
                ab.w("MicroMsg.NetSceneDownloadVideo", "%s already copy dup file, but download again, something error here.", alb());
                boolean deleteFile = com.tencent.mm.vfs.e.deleteFile(str3);
                bh XT = ((com.tencent.mm.plugin.m.a.a) g.K(com.tencent.mm.plugin.m.a.a.class)).XT();
                int i3 = this.frO;
                i = 0;
                if (!bo.isNullOrNil(str5)) {
                    i = XT.bSd.delete("MediaDuplication", "md5=? AND size=? AND status!=?", new String[]{str5, String.valueOf(i3), "100"});
                }
                s ut = u.ut(this.fileName);
                ut.fWY = 0;
                ut.bJt = 16;
                u.f(ut);
                ab.w("MicroMsg.NetSceneDownloadVideo", "%s don't copy dup file, go to download now. target video len %d, delete file:%b,delete db: %d", alb(), Integer.valueOf(r11), Boolean.valueOf(deleteFile), Integer.valueOf(i));
                str2 = "";
            }
            ab.i("MicroMsg.NetSceneDownloadVideo", "%s MediaCheckDuplicationStorage: totallen:%s md5:%s  dup(len:%d path:%s) diffLen:%d to:%s target video len %d", alb(), Integer.valueOf(this.frO), str5, Integer.valueOf(asZ), str2, Integer.valueOf(i2), stringBuilder2, Integer.valueOf(r11));
            if (bo.isNullOrNil(str2)) {
                this.fFh = str5;
                this.fFi = this.frO;
            } else if (i2 >= 0 && i2 <= 16) {
                ab.i("MicroMsg.NetSceneDownloadVideo", "%s MediaCheckDuplicationStorage copy dup file now :%s -> %s", alb(), str2, stringBuilder2);
                com.tencent.mm.vfs.e.y(str2, stringBuilder2);
                mo(this.frO);
                ((j) g.K(j.class)).bOr().a(new com.tencent.mm.plugin.messenger.foundation.a.a.h.c(Q.field_talker, "update", Q));
                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
                Object[] objArr = new Object[7];
                objArr[0] = str;
                objArr[1] = Long.valueOf(this.fVj.cKK);
                objArr[2] = str5;
                objArr[3] = Long.valueOf(this.fVj.createTime);
                objArr[4] = this.fVj.getUser();
                objArr[5] = Integer.valueOf(3 != this.fVj.fXk ? 43 : 62);
                objArr[6] = Integer.valueOf(asZ);
                hVar.e(13267, objArr);
                obj = 1;
                if (obj == null) {
                    this.cHr = this.fVk.field_mediaId;
                    this.fVo = bo.anU();
                    this.fVi = this.fVj.videoFormat == 2;
                    ab.i("MicroMsg.NetSceneDownloadVideo", "%s check use cdn isHadHevcLocalFile[%b] isCompleteOnlineVideo[%b]", alb(), Boolean.valueOf(this.fVi), Boolean.valueOf(this.fVh));
                    if (this.fVh) {
                        this.fVn = false;
                        h hVar2 = this.fVk;
                        o.all();
                        hVar2.field_fullpath = t.uh(this.fileName);
                        if (this.fVi) {
                            this.fVk.field_requestVideoFormat = 2;
                            com.tencent.mm.plugin.report.service.h.pYm.a(354, 251, 1, false);
                        }
                        o.alm().a(this.fVk, false);
                    } else if (!com.tencent.mm.al.f.afx().b(this.fVk, -1)) {
                        com.tencent.mm.plugin.report.service.h.pYm.a(111, 212, 1, false);
                        ab.e("MicroMsg.NetSceneDownloadVideo", "%s cdntra addSendTask failed.", alb());
                        this.fFa = "";
                        AppMethodBeat.o(50671);
                        return false;
                    } else if (this.fVi) {
                        com.tencent.mm.plugin.report.service.h.pYm.a(354, 135, 1, false);
                    }
                }
                if (this.fVj.fXi != 1) {
                    this.fVj.fXi = 1;
                    this.fVj.bJt = SQLiteGlobal.journalSizeLimit;
                    u.f(this.fVj);
                }
                if (3 != this.fVj.fXk) {
                    str5 = this.fVj.getUser();
                    if (!bo.isNullOrNil(str5)) {
                        int mA;
                        if (t.kH(str5)) {
                            mA = n.mA(str5);
                        } else {
                            mA = 0;
                        }
                        try {
                            NetworkInfo activeNetworkInfo = ((ConnectivityManager) ah.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
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
                            ab.e("MicroMsg.NetSceneDownloadVideo", "getNetType : %s", bo.l(e));
                            i = 0;
                        }
                        ab.i("MicroMsg.NetSceneDownloadVideo", "%s dk12024 report:%s", alb(), str5 + "," + mA + "," + str + "," + this.frO + "," + i);
                        com.tencent.mm.plugin.report.service.h.pYm.X(12024, str);
                    }
                }
                AppMethodBeat.o(50671);
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
        AppMethodBeat.o(50671);
        return true;
    }

    /* Access modifiers changed, original: final */
    public final void mo(final int i) {
        boolean o;
        AppMethodBeat.i(50672);
        if (this.fVn) {
            StringBuilder stringBuilder = new StringBuilder();
            o.all();
            com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(stringBuilder.append(t.uh(this.fileName)).append(".tmp").toString());
            o.all();
            o = bVar.o(new com.tencent.mm.vfs.b(t.uh(this.fileName)));
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            o.all();
            com.tencent.mm.vfs.e.deleteFile(stringBuilder2.append(t.uh(this.fileName)).append(".tmp").toString());
            o = true;
        }
        g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(50666);
                Map z = br.z(d.this.fVj.alw(), "msg");
                if (z != null) {
                    t all = o.all();
                    o.all();
                    all.s(t.uh(d.this.fileName), (String) z.get(".msg.videomsg.$cdnvideourl"), (String) z.get(".msg.videomsg.$aeskey"));
                }
                boolean z2 = false;
                if (o) {
                    z2 = u.ae(d.this.fileName, i);
                    if (d.this.fVi) {
                        u.uz(d.this.fileName);
                        ab.i("MicroMsg.NetSceneDownloadVideo", "sceneEndproc, isHadHevcLocalFile");
                    }
                } else if (d.this.fVi) {
                    u.um(d.this.fileName);
                    com.tencent.mm.plugin.report.service.h.pYm.a(354, 138, 1, false);
                } else {
                    z2 = u.ae(d.this.fileName, i);
                }
                ab.i("MicroMsg.NetSceneDownloadVideo", "%s ashutest::cdntra !FIN! file:%s svrid:%d human:%s user:%s updatedbsucc:%b  MediaCheckDuplicationStorage MD5:%s SIZE:%d renameFlag %b needRename %b", d.this.alb(), d.this.fileName, Long.valueOf(d.this.fVj.cKK), d.this.fVj.alt(), d.this.fVj.getUser(), Boolean.valueOf(z2), d.this.fFh, Integer.valueOf(d.this.fFi), Boolean.valueOf(o), Boolean.valueOf(d.this.fVn));
                if (!bo.isNullOrNil(d.this.fFh) && d.this.fFi > 0) {
                    bh XT = ((com.tencent.mm.plugin.m.a.a) g.K(com.tencent.mm.plugin.m.a.a.class)).XT();
                    String str = d.this.fFh;
                    int i = d.this.fFi;
                    o.all();
                    XT.y(str, i, t.uh(d.this.fileName));
                }
                if (d.this.fVj.fXk == 3) {
                    com.tencent.mm.plugin.report.service.h.pYm.a(198, 38, (long) d.this.fVj.frO, false);
                    com.tencent.mm.plugin.report.service.h.pYm.a(198, 40, (long) d.this.fVj.fXd, false);
                    com.tencent.mm.plugin.report.service.h.pYm.a(198, 41, 1, false);
                    com.tencent.mm.plugin.report.service.h.pYm.a(198, t.kH(d.this.fVj.getUser()) ? 43 : 42, 1, false);
                } else {
                    com.tencent.mm.plugin.report.service.h.pYm.a(198, 31, (long) d.this.fVj.frO, false);
                    com.tencent.mm.plugin.report.service.h.pYm.a(198, 33, (long) d.this.fVj.fXd, false);
                    com.tencent.mm.plugin.report.service.h.pYm.a(198, 34, 1, false);
                    com.tencent.mm.plugin.report.service.h.pYm.a(198, t.kH(d.this.fVj.getUser()) ? 36 : 35, 1, false);
                }
                d.this.ehi.onSceneEnd(0, 0, "", d.this);
                AppMethodBeat.o(50666);
            }
        });
        AppMethodBeat.o(50672);
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        int i = 1;
        AppMethodBeat.i(50673);
        this.ehi = fVar;
        this.fVj = u.ut(this.fileName);
        if (this.fVj == null) {
            ab.e("MicroMsg.NetSceneDownloadVideo", "ERR: Get INFO FAILED :" + this.fileName);
            this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
            AppMethodBeat.o(50673);
            return -1;
        }
        if (this.fVj != null && 3 == this.fVj.fXk) {
            this.fVl = com.tencent.mm.i.a.MediaType_TinyVideo;
        }
        if (this.startTime == 0) {
            this.startTime = bo.anU();
            this.startOffset = this.fVj.fWY;
        }
        if (ala()) {
            ab.d("MicroMsg.NetSceneDownloadVideo", "cdntra use cdn return -1 for onGYNetEnd clientid:%s", this.fileName);
            AppMethodBeat.o(50673);
            return 0;
        } else if (this.fVj.status != 112) {
            ab.e("MicroMsg.NetSceneDownloadVideo", "ERR: STATUS: " + this.fVj.status + " [" + this.fileName + "," + this.fVj.cKK + "," + this.fVj.alt() + "," + this.fVj.getUser() + "]");
            this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
            AppMethodBeat.o(50673);
            return -1;
        } else {
            ab.d("MicroMsg.NetSceneDownloadVideo", "start doScene  [" + this.fileName + "," + this.fVj.cKK + "," + this.fVj.alt() + "," + this.fVj.getUser() + "]  filesize:" + this.fVj.fWY + " file:" + this.fVj.frO + " netTimes:" + this.fVj.fXf);
            if (!u.ul(this.fileName)) {
                ab.e("MicroMsg.NetSceneDownloadVideo", "ERR: NET TIMES: " + this.fVj.fXf + " [" + this.fileName + "," + this.fVj.cKK + "," + this.fVj.alt() + "," + this.fVj.getUser() + "] ");
                u.um(this.fileName);
                this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
                AppMethodBeat.o(50673);
                return -1;
            } else if (this.fVj.cKK <= 0) {
                ab.e("MicroMsg.NetSceneDownloadVideo", "ERR: MSGSVRID: " + this.fVj.cKK + " [" + this.fileName + "," + this.fVj.cKK + "," + this.fVj.alt() + "," + this.fVj.getUser() + "] ");
                u.um(this.fileName);
                this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
                AppMethodBeat.o(50673);
                return -1;
            } else if (this.fVj.fWY < 0 || this.fVj.frO <= this.fVj.fWY || this.fVj.frO <= 0) {
                ab.e("MicroMsg.NetSceneDownloadVideo", "ERR: fileSize:" + this.fVj.fWY + " total:" + this.fVj.frO + " [" + this.fileName + "," + this.fVj.cKK + "," + this.fVj.alt() + "," + this.fVj.getUser() + "] ");
                u.um(this.fileName);
                this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
                AppMethodBeat.o(50673);
                return -1;
            } else {
                b.a aVar = new b.a();
                aVar.fsJ = new xl();
                aVar.fsK = new xm();
                aVar.uri = "/cgi-bin/micromsg-bin/downloadvideo";
                aVar.fsI = 150;
                aVar.fsL = 40;
                aVar.fsM = 1000000040;
                this.ehh = aVar.acD();
                xl xlVar = (xl) this.ehh.fsG.fsP;
                xlVar.ptF = this.fVj.cKK;
                xlVar.ptx = this.fVj.fWY;
                xlVar.ptw = this.fVj.frO;
                if (!com.tencent.mm.network.ab.ch(ah.getContext())) {
                    i = 2;
                }
                xlVar.wdl = i;
                int a = a(eVar, this.ehh, this);
                AppMethodBeat.o(50673);
                return a;
            }
        }
    }

    public final m.b b(q qVar) {
        AppMethodBeat.i(50674);
        xl xlVar = (xl) ((b) qVar).fsG.fsP;
        m.b bVar;
        if (xlVar.ptF <= 0 || xlVar.ptx < 0 || xlVar.ptw <= 0 || xlVar.ptw <= xlVar.ptx) {
            ab.e("MicroMsg.NetSceneDownloadVideo", "ERR: SECURITY CHECK FAILED [" + this.fileName + "," + this.fVj.cKK + "," + this.fVj.alt() + "," + this.fVj.getUser() + "] ");
            u.um(this.fileName);
            bVar = m.b.EFailed;
            AppMethodBeat.o(50674);
            return bVar;
        }
        bVar = m.b.EOk;
        AppMethodBeat.o(50674);
        return bVar;
    }

    public final int acn() {
        return 2500;
    }

    public final boolean acJ() {
        AppMethodBeat.i(50675);
        boolean acJ = super.acJ();
        if (acJ) {
            com.tencent.mm.plugin.report.service.h.pYm.a(111, 210, 1, false);
        }
        AppMethodBeat.o(50675);
        return acJ;
    }

    public final void a(m.a aVar) {
        AppMethodBeat.i(50676);
        com.tencent.mm.plugin.report.service.h.pYm.a(111, 211, 1, false);
        u.um(this.fileName);
        AppMethodBeat.o(50676);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(50677);
        if (this.fVm) {
            ab.d("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd Call Stop by Service  [" + this.fileName + "," + this.fVj.cKK + "," + this.fVj.alt() + "," + this.fVj.getUser() + "] ");
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(50677);
        } else if (i2 == 3 && i3 == -1 && !bo.isNullOrNil(this.fFa)) {
            ab.w("MicroMsg.NetSceneDownloadVideo", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", this.fFa);
            AppMethodBeat.o(50677);
        } else {
            xm xmVar = (xm) ((b) qVar).fsH.fsP;
            xl xlVar = (xl) ((b) qVar).fsG.fsP;
            this.fVj = u.ut(this.fileName);
            if (this.fVj == null) {
                ab.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd Get INFO FAILED :" + this.fileName);
                this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(50677);
            } else if (this.fVj.status == 113) {
                ab.w("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd STATUS PAUSE [" + this.fileName + "," + this.fVj.cKK + "," + this.fVj.alt() + "," + this.fVj.getUser() + "] ");
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(50677);
            } else if (this.fVj.status != 112) {
                ab.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd STATUS ERR: status:" + this.fVj.status + " [" + this.fileName + "," + this.fVj.cKK + "," + this.fVj.alt() + "," + this.fVj.getUser() + "] ");
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(50677);
            } else if (i2 == 4 && i3 != 0) {
                com.tencent.mm.plugin.report.service.h.pYm.a(111, 208, 1, false);
                ab.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd SERVER FAILED errtype:" + i2 + " errCode:" + i3 + " [" + this.fileName + "," + this.fVj.cKK + "," + this.fVj.alt() + "," + this.fVj.getUser() + "] ");
                u.um(this.fileName);
                com.tencent.mm.plugin.report.service.h.pYm.e(10420, Integer.valueOf(i3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bo.anU()), Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext())), Integer.valueOf(this.fVl), Integer.valueOf(this.frO - this.startOffset));
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(50677);
            } else if (i2 != 0 || i3 != 0) {
                com.tencent.mm.plugin.report.service.h.pYm.a(111, 207, 1, false);
                ab.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd SERVER FAILED (SET PAUSE) errtype:" + i2 + " errCode:" + i3 + " [" + this.fileName + "," + this.fVj.cKK + "," + this.fVj.alt() + "," + this.fVj.getUser() + "] ");
                this.fVj.status = 113;
                u.f(this.fVj);
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(50677);
            } else if (bo.cb(xmVar.ptz.getBuffer().wR)) {
                ab.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd Recv BUF ZERO length  [" + this.fileName + "," + this.fVj.cKK + "," + this.fVj.alt() + "," + this.fVj.getUser() + "] ");
                u.um(this.fileName);
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(50677);
            } else if (xmVar.ptx != xlVar.ptx) {
                ab.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd OFFSET ERROR respStartPos:" + xmVar.ptx + " reqStartPos:" + xlVar.ptx + " [" + this.fileName + "," + this.fVj.cKK + "," + this.fVj.alt() + "," + this.fVj.getUser() + "] ");
                u.um(this.fileName);
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(50677);
            } else if (xmVar.ptw != xlVar.ptw) {
                ab.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respTotal:" + xmVar.ptw + " reqTotal:" + xlVar.ptw + " [" + this.fileName + "," + this.fVj.cKK + "," + this.fVj.alt() + "," + this.fVj.getUser() + "] ");
                u.um(this.fileName);
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(50677);
            } else if (xlVar.ptw < xmVar.ptx) {
                ab.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respTotal:" + xmVar.ptw + " respStartPos:" + xlVar.ptx + " [" + this.fileName + "," + this.fVj.cKK + "," + this.fVj.alt() + "," + this.fVj.getUser() + "] ");
                u.um(this.fileName);
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(50677);
            } else if (xmVar.ptF != xlVar.ptF) {
                ab.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respMsgId:" + xmVar.ptF + " reqMsgId:" + xlVar.ptF + " [" + this.fileName + "," + this.fVj.cKK + "," + this.fVj.alt() + "," + this.fVj.getUser() + "] ");
                u.um(this.fileName);
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(50677);
            } else {
                ab.d("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd respBuf:" + xmVar.ptz.getILen() + " reqStartPos:" + xlVar.ptx + " totallen:" + xlVar.ptw + " [" + this.fileName + "," + this.fVj.cKK + "," + this.fVj.alt() + "," + this.fVj.getUser() + "] ");
                o.all();
                int a = t.a(t.uh(this.fileName), xlVar.ptx, xmVar.ptz.getBuffer().toByteArray());
                if (a < 0) {
                    ab.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd WRITEFILE RET:" + a + " [" + this.fileName + "," + this.fVj.cKK + "," + this.fVj.alt() + "," + this.fVj.getUser() + "] ");
                    u.um(this.fileName);
                    this.ehi.onSceneEnd(i2, i3, str, this);
                    AppMethodBeat.o(50677);
                } else if (a > this.fVj.frO) {
                    ab.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd WRITEFILE newOffset:" + a + " totalLen:" + this.fVj.frO + " [" + this.fileName + "," + this.fVj.cKK + "," + this.fVj.alt() + "," + this.fVj.getUser() + "] ");
                    u.um(this.fileName);
                    this.ehi.onSceneEnd(i2, i3, str, this);
                    AppMethodBeat.o(50677);
                } else {
                    int line;
                    String str2 = this.fileName;
                    s ut = u.ut(str2);
                    if (ut == null) {
                        ab.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.Mq() + " getinfo failed: " + str2);
                        line = 0 - com.tencent.mm.compatible.util.g.getLine();
                    } else {
                        ut.fWY = a;
                        ut.fXb = bo.anT();
                        ut.bJt = 1040;
                        line = 0;
                        if (ut.frO > 0 && a >= ut.frO) {
                            u.e(ut);
                            ut.status = 199;
                            ut.bJt |= 256;
                            ab.i("MicroMsg.VideoLogic", "END!!!  updateRecv  file:" + str2 + " newsize:" + a + " total:" + ut.frO + " status:" + ut.status + " netTimes:" + ut.fXf);
                            line = 1;
                        }
                        ab.d("MicroMsg.VideoLogic", "updateRecv " + com.tencent.mm.compatible.util.g.Mq() + " file:" + str2 + " newsize:" + a + " total:" + ut.frO + " status:" + ut.status);
                        if (!u.f(ut)) {
                            line = 0 - com.tencent.mm.compatible.util.g.getLine();
                        }
                    }
                    if (line < 0) {
                        ab.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd updateAfterRecv Ret:" + line + " newOffset :" + a + " [" + this.fileName + "," + this.fVj.cKK + "," + this.fVj.alt() + "," + this.fVj.getUser() + "] ");
                        this.ehi.onSceneEnd(i2, i3, str, this);
                        AppMethodBeat.o(50677);
                    } else if (line == 1) {
                        com.tencent.mm.plugin.report.service.h.pYm.e(10420, Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bo.anU()), Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext())), Integer.valueOf(this.fVl), Integer.valueOf(this.frO - this.startOffset));
                        a.a(this.fVj, 1);
                        ab.i("MicroMsg.NetSceneDownloadVideo", "!!!FIN [" + this.fileName + "," + this.fVj.cKK + "," + this.fVj.alt() + "," + this.fVj.getUser() + "]");
                        this.ehi.onSceneEnd(i2, i3, str, this);
                        AppMethodBeat.o(50677);
                    } else if (this.fVm) {
                        this.ehi.onSceneEnd(i2, i3, str, this);
                        AppMethodBeat.o(50677);
                    } else {
                        this.frk.ae(0, 0);
                        AppMethodBeat.o(50677);
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
        AppMethodBeat.i(50678);
        String str = this.fileName + "_" + hashCode();
        AppMethodBeat.o(50678);
        return str;
    }
}

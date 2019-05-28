package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ui;
import com.tencent.mm.g.b.a.x;
import com.tencent.mm.g.c.cy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bf.b;
import com.tencent.mm.model.n;
import com.tencent.mm.model.t;
import com.tencent.mm.modelvideo.f.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.video.c;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.bi;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class i implements a {
    LinkedList<bi> fVS = new LinkedList();
    long fVT = 0;
    private int fVU = 0;
    private int fVV = 0;
    public boolean fVW = false;
    public boolean fVX = false;
    private boolean fVY = false;
    private boolean fVZ = false;
    f fWa = null;
    long fWb = 0;

    public i() {
        AppMethodBeat.i(50718);
        AppMethodBeat.o(50718);
    }

    public final void stopDownload() {
        AppMethodBeat.i(50719);
        ab.i("MicroMsg.PreloadVideoService", "%d stop download", Integer.valueOf(hashCode()));
        g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(50715);
                if (i.this.fWa != null) {
                    i.this.fWa.stop();
                }
                i.this.fWa = null;
                AppMethodBeat.o(50715);
            }
        });
        AppMethodBeat.o(50719);
    }

    public final void a(final f fVar, boolean z, int i, int i2) {
        AppMethodBeat.i(50721);
        if (fVar == null) {
            ab.e("MicroMsg.PreloadVideoService", "%d on preload finish but scene is null?", Integer.valueOf(hashCode()));
            AppMethodBeat.o(50721);
            return;
        }
        if (this.fWa != fVar) {
            ab.w("MicroMsg.PreloadVideoService", "%d on preload finish, but scene callback not same object.", Integer.valueOf(hashCode()));
        }
        ab.i("MicroMsg.PreloadVideoService", "%d preload video[%s] finish success[%b] range[%d, %d]", Integer.valueOf(hashCode()), fVar.alc(), Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2));
        g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(50717);
                long j = fVar.cvx;
                synchronized (i.this.fVS) {
                    try {
                        Iterator it = i.this.fVS.iterator();
                        while (it.hasNext()) {
                            bi biVar = (bi) it.next();
                            if (biVar != null && biVar.field_msgId == j) {
                                ab.i("MicroMsg.PreloadVideoService", "%d find msg[%d], remove now", Integer.valueOf(i.this.hashCode()), Long.valueOf(j));
                                it.remove();
                            }
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(50717);
                    }
                }
                i.this.cW(true);
                if (i.this.fWa != null) {
                    i.this.fWa.fVC = null;
                }
                i.this.fWa = null;
                i.a(i.this);
                i.this.ald();
                AppMethodBeat.o(50717);
            }
        });
        AppMethodBeat.o(50721);
    }

    public final void cW(boolean z) {
        AppMethodBeat.i(50722);
        if (z) {
            this.fVU = ((Integer) g.RP().Ry().get(ac.a.USERINFO_C2C_HAD_PRELOAD_COUNT_INT, Integer.valueOf(0))).intValue();
            this.fVU++;
            g.RP().Ry().set(ac.a.USERINFO_C2C_HAD_PRELOAD_COUNT_INT, Integer.valueOf(this.fVU));
            AppMethodBeat.o(50722);
            return;
        }
        this.fVV = ((Integer) g.RP().Ry().get(ac.a.USERINFO_SNS_HAD_PRELOAD_COUNT_INT, Integer.valueOf(0))).intValue();
        this.fVV++;
        g.RP().Ry().set(ac.a.USERINFO_SNS_HAD_PRELOAD_COUNT_INT, Integer.valueOf(this.fVV));
        AppMethodBeat.o(50722);
    }

    public final void a(String str, int i, long j, String str2, String str3, int i2, String str4, String str5, String str6) {
        AppMethodBeat.i(50724);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(bo.anT()).append(",");
        stringBuffer.append(bo.anT()).append(",");
        stringBuffer.append(0).append(",");
        stringBuffer.append(str).append(",");
        stringBuffer.append(i).append(",");
        stringBuffer.append(0).append(",");
        stringBuffer.append(j).append(",");
        stringBuffer.append(",");
        stringBuffer.append(str2).append(",");
        stringBuffer.append(str3).append(",");
        stringBuffer.append(i2).append(",");
        stringBuffer.append(str4).append(",");
        stringBuffer.append(str5).append(",");
        stringBuffer.append(c.abR(str6));
        ab.d("MicroMsg.PreloadVideoService", "%d rpt content[%s]", Integer.valueOf(hashCode()), stringBuffer.toString());
        new x(r2).ajK();
        AppMethodBeat.o(50724);
    }

    public final void ald() {
        AppMethodBeat.i(50720);
        g.RS().aa(new Runnable() {
            /* JADX WARNING: Missing block: B:3:0x002e, code skipped:
            if (r3.cQy.cQz != false) goto L_0x0030;
     */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                AppMethodBeat.i(50716);
                boolean a = ((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_voip_pause_other_preload_android, false);
                if (!com.tencent.mm.r.a.Oo()) {
                    ui uiVar = new ui();
                    uiVar.cQx.cAd = 2;
                    com.tencent.mm.sdk.b.a.xxA.m(uiVar);
                }
                if (a) {
                    AppMethodBeat.o(50716);
                    return;
                }
                if (o.alq().cqT) {
                    AppMethodBeat.o(50716);
                } else if (i.this.fWa != null) {
                    AppMethodBeat.o(50716);
                } else if (i.this.fVW || i.this.fVX) {
                    AppMethodBeat.o(50716);
                } else if (i.this.fVS.isEmpty()) {
                    Object obj;
                    i iVar = i.this;
                    if (bo.fp(iVar.fWb) > 600) {
                        iVar.fWb = bo.anT();
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        i.a(i.this);
                    }
                    AppMethodBeat.o(50716);
                } else {
                    cy cyVar = null;
                    PBool pBool = new PBool();
                    synchronized (i.this.fVS) {
                        try {
                            Iterator it = i.this.fVS.iterator();
                            while (it.hasNext()) {
                                Object obj2;
                                cyVar = (bi) it.next();
                                i iVar2 = i.this;
                                if (cyVar == null) {
                                    pBool.value = true;
                                    obj2 = null;
                                } else {
                                    s ut = u.ut(cyVar.field_imgPath);
                                    if (ut != null && ut.alz()) {
                                        int i;
                                        ab.i("MicroMsg.PreloadVideoService", "%d it finish download all file[%s], needn't preload", Integer.valueOf(iVar2.hashCode()), ut.getFileName());
                                        Map z = br.z(ut.alw(), "msg");
                                        String str = (String) z.get(".msg.videomsg.$newmd5");
                                        String str2 = (String) z.get(".msg.videomsg.$cdnvideourl");
                                        boolean kH = t.kH(ut.getUser());
                                        if (kH) {
                                            i = 2;
                                        } else {
                                            i = 1;
                                        }
                                        iVar2.a(str, i, (long) ut.frO, ut.alt(), ut.getUser(), t.kH(ut.getUser()) ? n.mA(ut.getUser()) : 0, str2, "", "");
                                        h.pYm.a(354, 146, 1, false);
                                        if (kH) {
                                            h.pYm.a(354, 126, 1, false);
                                        } else {
                                            h.pYm.a(354, 125, 1, false);
                                        }
                                        pBool.value = true;
                                        obj2 = null;
                                    } else if (bo.gb(cyVar.field_createTime) >= 86400000) {
                                        ab.i("MicroMsg.PreloadVideoService", "%d more than 1 day don't preload", Integer.valueOf(iVar2.hashCode()));
                                        pBool.value = true;
                                        obj2 = null;
                                    } else {
                                        if (iVar2.cX(true)) {
                                            ab.i("MicroMsg.PreloadVideoService", "%d check c2c video preload timestamp[%d]", Integer.valueOf(iVar2.hashCode()), Long.valueOf(iVar2.fVT));
                                        } else {
                                            ab.i("MicroMsg.PreloadVideoService", "%d check c2c video preload %d %s", Integer.valueOf(iVar2.hashCode()), Long.valueOf(cyVar.field_msgId), cyVar.dqJ);
                                            b oE = bf.oE(cyVar.dqJ);
                                            if (oE == null) {
                                                pBool.value = true;
                                                obj2 = null;
                                            } else if (oE.fmG <= 0) {
                                                pBool.value = true;
                                                obj2 = null;
                                            } else if (!com.tencent.mm.modelcontrol.b.rR(oE.fmI)) {
                                                int i2;
                                                if (at.isWifi(ah.getContext())) {
                                                    i2 = oE.fmH & 1;
                                                } else if (at.is4G(ah.getContext())) {
                                                    i2 = oE.fmH & 2;
                                                } else if (at.is3G(ah.getContext())) {
                                                    i2 = oE.fmH & 4;
                                                } else {
                                                    pBool.value = false;
                                                    obj2 = null;
                                                }
                                                if (i2 > 0) {
                                                    pBool.value = false;
                                                    obj2 = 1;
                                                }
                                            }
                                        }
                                        pBool.value = false;
                                        obj2 = null;
                                    }
                                }
                                if (pBool.value) {
                                    it.remove();
                                }
                                if (obj2 != null) {
                                    break;
                                }
                                cyVar = null;
                            }
                        } finally {
                            AppMethodBeat.o(50716);
                        }
                    }
                    if (cyVar != null) {
                        i.this.fWa = new f(cyVar.field_msgId);
                        ab.i("MicroMsg.PreloadVideoService", "%s start to preload video[%s]", Integer.valueOf(i.this.hashCode()), i.this.fWa.alc());
                        if (i.this.fWa.a(i.this) < 0) {
                            ab.w("MicroMsg.PreloadVideoService", "%s curr preload task do scene error.", Integer.valueOf(i.this.hashCode()));
                            synchronized (i.this.fVS) {
                                try {
                                    Iterator it2 = i.this.fVS.iterator();
                                    while (it2.hasNext()) {
                                        bi biVar = (bi) it2.next();
                                        if (biVar != null && biVar.field_msgId == i.this.fWa.cvx) {
                                            ab.i("MicroMsg.PreloadVideoService", "%d find msg[%d], remove now", Integer.valueOf(i.this.hashCode()), Long.valueOf(i.this.fWa.cvx));
                                            it2.remove();
                                        }
                                    }
                                } catch (Throwable th) {
                                    AppMethodBeat.o(50716);
                                }
                            }
                            i.this.fWa = null;
                        }
                        AppMethodBeat.o(50716);
                    }
                }
            }
        });
        AppMethodBeat.o(50720);
    }

    public final boolean cX(boolean z) {
        int i;
        int i2;
        boolean z2;
        int i3 = 100;
        AppMethodBeat.i(50723);
        this.fVT = ((Long) g.RP().Ry().get(ac.a.USERINFO_HAD_PRELOAD_TIME_LONG, Long.valueOf(-1))).longValue();
        if (bo.gb(this.fVT) >= 86400000) {
            this.fVT = bo.anU();
            g.RP().Ry().set(ac.a.USERINFO_HAD_PRELOAD_TIME_LONG, Long.valueOf(this.fVT));
            g.RP().Ry().set(ac.a.USERINFO_C2C_HAD_PRELOAD_COUNT_INT, Integer.valueOf(0));
            g.RP().Ry().set(ac.a.USERINFO_SNS_HAD_PRELOAD_COUNT_INT, Integer.valueOf(0));
            this.fVZ = false;
            this.fVY = false;
        }
        this.fVU = ((Integer) g.RP().Ry().get(ac.a.USERINFO_C2C_HAD_PRELOAD_COUNT_INT, Integer.valueOf(0))).intValue();
        this.fVV = ((Integer) g.RP().Ry().get(ac.a.USERINFO_SNS_HAD_PRELOAD_COUNT_INT, Integer.valueOf(0))).intValue();
        if (z) {
            i = this.fVU;
            i2 = ((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getInt("C2CMaxPreloadVideo", 100);
        } else {
            i = this.fVV;
            i2 = ((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getInt("SnsMaxPreloadVideo", 100);
        }
        if (i2 > 0) {
            i3 = i2;
        }
        if (i >= i3) {
            z2 = true;
        } else {
            z2 = false;
        }
        ab.i("MicroMsg.PreloadVideoService", "%d check more preload count result[%b] config[%d] hadPreloadCount[%d %d %d] ", Integer.valueOf(hashCode()), Boolean.valueOf(z2), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(this.fVU), Integer.valueOf(this.fVV));
        if (z2) {
            if (z) {
                if (!this.fVY) {
                    this.fVY = true;
                    h.pYm.a(354, 127, 1, false);
                }
            } else if (!this.fVZ) {
                this.fVZ = true;
                h.pYm.a(354, 128, 1, false);
            }
        }
        AppMethodBeat.o(50723);
        return z2;
    }

    static /* synthetic */ boolean a(i iVar) {
        AppMethodBeat.i(50725);
        long yz = bo.yz();
        ab.i("MicroMsg.PreloadVideoService", "%d start to delete expired file limit[%d] status[%d] expiredTime[%d] isC2C[%b]", Integer.valueOf(iVar.hashCode()), Integer.valueOf(1), Integer.valueOf(111), Long.valueOf(bo.anT() - (((long) ((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getInt("PreLoadVideoExpiredTime", 1)) * TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC)), Boolean.TRUE);
        List<s> v = o.all().v(111, r0);
        if (v == null || v.isEmpty()) {
            AppMethodBeat.o(50725);
            return false;
        }
        int i = 0;
        for (s sVar : v) {
            if (sVar != null) {
                o.all();
                String uh = t.uh(sVar.getFileName());
                if (!bo.isNullOrNil(uh)) {
                    File file = new File(uh);
                    if (file.exists()) {
                        long length = file.length();
                        ab.i("MicroMsg.PreloadVideoService", "%s file[%d %d] lastmodifytime[%d] path[%s]", sVar.getFileName(), Long.valueOf(length), Integer.valueOf(sVar.cFa), Long.valueOf(sVar.fXb), uh);
                        if (length > 0 && length <= ((long) sVar.cFa)) {
                            file.delete();
                            i++;
                        }
                    }
                }
                int i2 = i;
                sVar.cFa = 0;
                sVar.bJt = 1;
                u.f(sVar);
                i = i2;
            }
        }
        h.pYm.a(354, 144, (long) i, false);
        ab.i("MicroMsg.PreloadVideoService", "%d delete expire file size %d delete count %d costTime[%d]", Integer.valueOf(iVar.hashCode()), Integer.valueOf(v.size()), Integer.valueOf(i), Long.valueOf(bo.az(yz)));
        AppMethodBeat.o(50725);
        return false;
    }
}

package com.tencent.p177mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1829bf.C1828b;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.modelcontrol.C45448b;
import com.tencent.p177mm.modelvideo.C32837f.C18706a;
import com.tencent.p177mm.p1510r.C35973a;
import com.tencent.p177mm.p230g.p231a.C26250ui;
import com.tencent.p177mm.p230g.p232b.p233a.C18456x;
import com.tencent.p177mm.p230g.p711c.C6575cy;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.video.C14013c;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.pointers.PBool;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.modelvideo.i */
public final class C32847i implements C18706a {
    LinkedList<C7620bi> fVS = new LinkedList();
    long fVT = 0;
    private int fVU = 0;
    private int fVV = 0;
    public boolean fVW = false;
    public boolean fVX = false;
    private boolean fVY = false;
    private boolean fVZ = false;
    C32837f fWa = null;
    long fWb = 0;

    /* renamed from: com.tencent.mm.modelvideo.i$1 */
    class C18801 implements Runnable {
        C18801() {
        }

        public final void run() {
            AppMethodBeat.m2504i(50715);
            if (C32847i.this.fWa != null) {
                C32847i.this.fWa.stop();
            }
            C32847i.this.fWa = null;
            AppMethodBeat.m2505o(50715);
        }
    }

    /* renamed from: com.tencent.mm.modelvideo.i$2 */
    class C18812 implements Runnable {
        C18812() {
        }

        /* JADX WARNING: Missing block: B:3:0x002e, code skipped:
            if (r3.cQy.cQz != false) goto L_0x0030;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            AppMethodBeat.m2504i(50716);
            boolean a = ((C34069a) C1720g.m3528K(C34069a.class)).mo54614a(C11745a.clicfg_voip_pause_other_preload_android, false);
            if (!C35973a.m59176Oo()) {
                C26250ui c26250ui = new C26250ui();
                c26250ui.cQx.cAd = 2;
                C4879a.xxA.mo10055m(c26250ui);
            }
            if (a) {
                AppMethodBeat.m2505o(50716);
                return;
            }
            if (C37961o.alq().cqT) {
                AppMethodBeat.m2505o(50716);
            } else if (C32847i.this.fWa != null) {
                AppMethodBeat.m2505o(50716);
            } else if (C32847i.this.fVW || C32847i.this.fVX) {
                AppMethodBeat.m2505o(50716);
            } else if (C32847i.this.fVS.isEmpty()) {
                Object obj;
                C32847i c32847i = C32847i.this;
                if (C5046bo.m7549fp(c32847i.fWb) > 600) {
                    c32847i.fWb = C5046bo.anT();
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    C32847i.m53691a(C32847i.this);
                }
                AppMethodBeat.m2505o(50716);
            } else {
                C6575cy c6575cy = null;
                PBool pBool = new PBool();
                synchronized (C32847i.this.fVS) {
                    try {
                        Iterator it = C32847i.this.fVS.iterator();
                        while (it.hasNext()) {
                            Object obj2;
                            c6575cy = (C7620bi) it.next();
                            C32847i c32847i2 = C32847i.this;
                            if (c6575cy == null) {
                                pBool.value = true;
                                obj2 = null;
                            } else {
                                C26493s ut = C26494u.m42268ut(c6575cy.field_imgPath);
                                if (ut != null && ut.alz()) {
                                    int i;
                                    C4990ab.m7417i("MicroMsg.PreloadVideoService", "%d it finish download all file[%s], needn't preload", Integer.valueOf(c32847i2.hashCode()), ut.getFileName());
                                    Map z = C5049br.m7595z(ut.alw(), "msg");
                                    String str = (String) z.get(".msg.videomsg.$newmd5");
                                    String str2 = (String) z.get(".msg.videomsg.$cdnvideourl");
                                    boolean kH = C1855t.m3896kH(ut.getUser());
                                    if (kH) {
                                        i = 2;
                                    } else {
                                        i = 1;
                                    }
                                    c32847i2.mo53412a(str, i, (long) ut.frO, ut.alt(), ut.getUser(), C1855t.m3896kH(ut.getUser()) ? C37921n.m64060mA(ut.getUser()) : 0, str2, "", "");
                                    C7060h.pYm.mo8378a(354, 146, 1, false);
                                    if (kH) {
                                        C7060h.pYm.mo8378a(354, 126, 1, false);
                                    } else {
                                        C7060h.pYm.mo8378a(354, 125, 1, false);
                                    }
                                    pBool.value = true;
                                    obj2 = null;
                                } else if (C5046bo.m7566gb(c6575cy.field_createTime) >= 86400000) {
                                    C4990ab.m7417i("MicroMsg.PreloadVideoService", "%d more than 1 day don't preload", Integer.valueOf(c32847i2.hashCode()));
                                    pBool.value = true;
                                    obj2 = null;
                                } else {
                                    if (c32847i2.mo53415cX(true)) {
                                        C4990ab.m7417i("MicroMsg.PreloadVideoService", "%d check c2c video preload timestamp[%d]", Integer.valueOf(c32847i2.hashCode()), Long.valueOf(c32847i2.fVT));
                                    } else {
                                        C4990ab.m7417i("MicroMsg.PreloadVideoService", "%d check c2c video preload %d %s", Integer.valueOf(c32847i2.hashCode()), Long.valueOf(c6575cy.field_msgId), c6575cy.dqJ);
                                        C1828b oE = C1829bf.m3758oE(c6575cy.dqJ);
                                        if (oE == null) {
                                            pBool.value = true;
                                            obj2 = null;
                                        } else if (oE.fmG <= 0) {
                                            pBool.value = true;
                                            obj2 = null;
                                        } else if (!C45448b.m83719rR(oE.fmI)) {
                                            int i2;
                                            if (C5023at.isWifi(C4996ah.getContext())) {
                                                i2 = oE.fmH & 1;
                                            } else if (C5023at.is4G(C4996ah.getContext())) {
                                                i2 = oE.fmH & 2;
                                            } else if (C5023at.is3G(C4996ah.getContext())) {
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
                            c6575cy = null;
                        }
                    } finally {
                        AppMethodBeat.m2505o(50716);
                    }
                }
                if (c6575cy != null) {
                    C32847i.this.fWa = new C32837f(c6575cy.field_msgId);
                    C4990ab.m7417i("MicroMsg.PreloadVideoService", "%s start to preload video[%s]", Integer.valueOf(C32847i.this.hashCode()), C32847i.this.fWa.alc());
                    if (C32847i.this.fWa.mo53406a(C32847i.this) < 0) {
                        C4990ab.m7421w("MicroMsg.PreloadVideoService", "%s curr preload task do scene error.", Integer.valueOf(C32847i.this.hashCode()));
                        synchronized (C32847i.this.fVS) {
                            try {
                                Iterator it2 = C32847i.this.fVS.iterator();
                                while (it2.hasNext()) {
                                    C7620bi c7620bi = (C7620bi) it2.next();
                                    if (c7620bi != null && c7620bi.field_msgId == C32847i.this.fWa.cvx) {
                                        C4990ab.m7417i("MicroMsg.PreloadVideoService", "%d find msg[%d], remove now", Integer.valueOf(C32847i.this.hashCode()), Long.valueOf(C32847i.this.fWa.cvx));
                                        it2.remove();
                                    }
                                }
                            } catch (Throwable th) {
                                AppMethodBeat.m2505o(50716);
                            }
                        }
                        C32847i.this.fWa = null;
                    }
                    AppMethodBeat.m2505o(50716);
                }
            }
        }
    }

    public C32847i() {
        AppMethodBeat.m2504i(50718);
        AppMethodBeat.m2505o(50718);
    }

    public final void stopDownload() {
        AppMethodBeat.m2504i(50719);
        C4990ab.m7417i("MicroMsg.PreloadVideoService", "%d stop download", Integer.valueOf(hashCode()));
        C1720g.m3539RS().mo10302aa(new C18801());
        AppMethodBeat.m2505o(50719);
    }

    /* renamed from: a */
    public final void mo33970a(final C32837f c32837f, boolean z, int i, int i2) {
        AppMethodBeat.m2504i(50721);
        if (c32837f == null) {
            C4990ab.m7413e("MicroMsg.PreloadVideoService", "%d on preload finish but scene is null?", Integer.valueOf(hashCode()));
            AppMethodBeat.m2505o(50721);
            return;
        }
        if (this.fWa != c32837f) {
            C4990ab.m7421w("MicroMsg.PreloadVideoService", "%d on preload finish, but scene callback not same object.", Integer.valueOf(hashCode()));
        }
        C4990ab.m7417i("MicroMsg.PreloadVideoService", "%d preload video[%s] finish success[%b] range[%d, %d]", Integer.valueOf(hashCode()), c32837f.alc(), Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2));
        C1720g.m3539RS().mo10302aa(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(50717);
                long j = c32837f.cvx;
                synchronized (C32847i.this.fVS) {
                    try {
                        Iterator it = C32847i.this.fVS.iterator();
                        while (it.hasNext()) {
                            C7620bi c7620bi = (C7620bi) it.next();
                            if (c7620bi != null && c7620bi.field_msgId == j) {
                                C4990ab.m7417i("MicroMsg.PreloadVideoService", "%d find msg[%d], remove now", Integer.valueOf(C32847i.this.hashCode()), Long.valueOf(j));
                                it.remove();
                            }
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.m2505o(50717);
                    }
                }
                C32847i.this.mo53414cW(true);
                if (C32847i.this.fWa != null) {
                    C32847i.this.fWa.fVC = null;
                }
                C32847i.this.fWa = null;
                C32847i.m53691a(C32847i.this);
                C32847i.this.ald();
                AppMethodBeat.m2505o(50717);
            }
        });
        AppMethodBeat.m2505o(50721);
    }

    /* renamed from: cW */
    public final void mo53414cW(boolean z) {
        AppMethodBeat.m2504i(50722);
        if (z) {
            this.fVU = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_C2C_HAD_PRELOAD_COUNT_INT, Integer.valueOf(0))).intValue();
            this.fVU++;
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_C2C_HAD_PRELOAD_COUNT_INT, Integer.valueOf(this.fVU));
            AppMethodBeat.m2505o(50722);
            return;
        }
        this.fVV = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_SNS_HAD_PRELOAD_COUNT_INT, Integer.valueOf(0))).intValue();
        this.fVV++;
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_SNS_HAD_PRELOAD_COUNT_INT, Integer.valueOf(this.fVV));
        AppMethodBeat.m2505o(50722);
    }

    /* renamed from: a */
    public final void mo53412a(String str, int i, long j, String str2, String str3, int i2, String str4, String str5, String str6) {
        AppMethodBeat.m2504i(50724);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(C5046bo.anT()).append(",");
        stringBuffer.append(C5046bo.anT()).append(",");
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
        stringBuffer.append(C14013c.abR(str6));
        C4990ab.m7411d("MicroMsg.PreloadVideoService", "%d rpt content[%s]", Integer.valueOf(hashCode()), stringBuffer.toString());
        new C18456x(r2).ajK();
        AppMethodBeat.m2505o(50724);
    }

    public final void ald() {
        AppMethodBeat.m2504i(50720);
        C1720g.m3539RS().mo10302aa(new C18812());
        AppMethodBeat.m2505o(50720);
    }

    /* renamed from: cX */
    public final boolean mo53415cX(boolean z) {
        int i;
        int i2;
        boolean z2;
        int i3 = 100;
        AppMethodBeat.m2504i(50723);
        this.fVT = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_HAD_PRELOAD_TIME_LONG, Long.valueOf(-1))).longValue();
        if (C5046bo.m7566gb(this.fVT) >= 86400000) {
            this.fVT = C5046bo.anU();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_HAD_PRELOAD_TIME_LONG, Long.valueOf(this.fVT));
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_C2C_HAD_PRELOAD_COUNT_INT, Integer.valueOf(0));
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_SNS_HAD_PRELOAD_COUNT_INT, Integer.valueOf(0));
            this.fVZ = false;
            this.fVY = false;
        }
        this.fVU = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_C2C_HAD_PRELOAD_COUNT_INT, Integer.valueOf(0))).intValue();
        this.fVV = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_SNS_HAD_PRELOAD_COUNT_INT, Integer.valueOf(0))).intValue();
        if (z) {
            i = this.fVU;
            i2 = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getInt("C2CMaxPreloadVideo", 100);
        } else {
            i = this.fVV;
            i2 = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getInt("SnsMaxPreloadVideo", 100);
        }
        if (i2 > 0) {
            i3 = i2;
        }
        if (i >= i3) {
            z2 = true;
        } else {
            z2 = false;
        }
        C4990ab.m7417i("MicroMsg.PreloadVideoService", "%d check more preload count result[%b] config[%d] hadPreloadCount[%d %d %d] ", Integer.valueOf(hashCode()), Boolean.valueOf(z2), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(this.fVU), Integer.valueOf(this.fVV));
        if (z2) {
            if (z) {
                if (!this.fVY) {
                    this.fVY = true;
                    C7060h.pYm.mo8378a(354, 127, 1, false);
                }
            } else if (!this.fVZ) {
                this.fVZ = true;
                C7060h.pYm.mo8378a(354, 128, 1, false);
            }
        }
        AppMethodBeat.m2505o(50723);
        return z2;
    }

    /* renamed from: a */
    static /* synthetic */ boolean m53691a(C32847i c32847i) {
        AppMethodBeat.m2504i(50725);
        long yz = C5046bo.m7588yz();
        C4990ab.m7417i("MicroMsg.PreloadVideoService", "%d start to delete expired file limit[%d] status[%d] expiredTime[%d] isC2C[%b]", Integer.valueOf(c32847i.hashCode()), Integer.valueOf(1), Integer.valueOf(111), Long.valueOf(C5046bo.anT() - (((long) ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getInt("PreLoadVideoExpiredTime", 1)) * TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC)), Boolean.TRUE);
        List<C26493s> v = C37961o.all().mo21064v(111, r0);
        if (v == null || v.isEmpty()) {
            AppMethodBeat.m2505o(50725);
            return false;
        }
        int i = 0;
        for (C26493s c26493s : v) {
            if (c26493s != null) {
                C37961o.all();
                String uh = C9720t.m17303uh(c26493s.getFileName());
                if (!C5046bo.isNullOrNil(uh)) {
                    File file = new File(uh);
                    if (file.exists()) {
                        long length = file.length();
                        C4990ab.m7417i("MicroMsg.PreloadVideoService", "%s file[%d %d] lastmodifytime[%d] path[%s]", c26493s.getFileName(), Long.valueOf(length), Integer.valueOf(c26493s.cFa), Long.valueOf(c26493s.fXb), uh);
                        if (length > 0 && length <= ((long) c26493s.cFa)) {
                            file.delete();
                            i++;
                        }
                    }
                }
                int i2 = i;
                c26493s.cFa = 0;
                c26493s.bJt = 1;
                C26494u.m42253f(c26493s);
                i = i2;
            }
        }
        C7060h.pYm.mo8378a(354, 144, (long) i, false);
        C4990ab.m7417i("MicroMsg.PreloadVideoService", "%d delete expire file size %d delete count %d costTime[%d]", Integer.valueOf(c32847i.hashCode()), Integer.valueOf(v.size()), Integer.valueOf(i), Long.valueOf(C5046bo.m7525az(yz)));
        AppMethodBeat.m2505o(50725);
        return false;
    }
}

package com.tencent.p177mm.p612ui.chatting.gallery;

import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import android.view.View;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.model.C42192d;
import com.tencent.p177mm.model.C42192d.C42190a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelsimple.C37951y;
import com.tencent.p177mm.modelvideo.C26492r;
import com.tencent.p177mm.modelvideo.C26493s;
import com.tencent.p177mm.modelvideo.C26494u;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C9720t;
import com.tencent.p177mm.modelvideo.C9720t.C9721a;
import com.tencent.p177mm.modelvideo.C9720t.C9721a.C9718a;
import com.tencent.p177mm.network.C32856ab;
import com.tencent.p177mm.p187al.C45150e;
import com.tencent.p177mm.p230g.p231a.C32594lp;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.chatting.C23701al;
import com.tencent.p177mm.p612ui.chatting.C23701al.C23702a;
import com.tencent.p177mm.p612ui.chatting.gallery.C46653m.C53411;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C27011o;
import com.tencent.p177mm.plugin.p468n.C12691e;
import com.tencent.p177mm.plugin.p468n.C43332b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sight.base.C21846d;
import com.tencent.p177mm.plugin.sight.decode.p512ui.C3855b;
import com.tencent.p177mm.pluginsdk.p1080h.p1571b.p1572a.C40434a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14980e;
import com.tencent.p177mm.pluginsdk.p597ui.tools.VideoPlayerTextureView;
import com.tencent.p177mm.pluginsdk.p597ui.tools.VideoTextureView;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C15429k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7306ak.C4998a;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5730e;
import java.util.HashMap;

/* renamed from: com.tencent.mm.ui.chatting.gallery.j */
public final class C15663j extends C23777a implements C42190a, C9721a {
    public static boolean yWS = false;
    private String filename;
    private C42192d iaf;
    private C7564ap klw = new C7564ap(new C1567614(), true);
    private long lastCheckTime = 0;
    int mqi = 0;
    private C43332b orK = new C156727();
    private C7564ap rcg = new C7564ap(new C1567513(), true);
    private C14980e rlb = new C156816();
    private boolean rll;
    private long rlp = 0;
    private long rlq = 0;
    private long rlu;
    private int rlv;
    private C3855b vgC = new C156692();
    private long vgx = 0;
    private HashMap<String, C15682a> yVF = new HashMap();
    private C4884c yWI;
    final SparseArray<C26493s> yWJ = new SparseArray();
    private C46653m yWK = new C46653m(this);
    private boolean yWL = false;
    private boolean yWM = false;
    private boolean yWN = false;
    private int yWO = 0;
    private int yWP = 0;
    private int yWQ = 0;
    private boolean yWR = false;
    C7306ak yWT = new C7306ak(Looper.getMainLooper(), new C156629());
    private int yWU = 0;
    private C4884c<C32594lp> yWV = new C156783();
    private boolean yWW = false;
    private int yWX = 0;
    private int[] yWY = new int[]{-1000, -2000, 3400};

    /* renamed from: com.tencent.mm.ui.chatting.gallery.j$9 */
    class C156629 implements C4998a {
        C156629() {
        }

        public final boolean handleMessage(Message message) {
            AppMethodBeat.m2504i(32324);
            if (message.what == 1) {
                C36180k dFP = C15663j.this.yTG.dFP();
                if (!(dFP == null || C5046bo.isNullOrNil(C15663j.this.filename))) {
                    C4990ab.m7417i("MicroMsg.Imagegallery.handler.video", "%d ui on pause, pause video now. %s", Integer.valueOf(hashCode()), C15663j.this.filename);
                    if (!C15663j.this.yWM) {
                        C26494u.m42252f(C15663j.this.filename, dFP.dGH().yXp.getCurrentPosition(), C15663j.this.rll);
                    }
                    C15663j.m23953a(C15663j.this, dFP);
                    C15663j.this.iaf.mo67733cy(false);
                    if (C15663j.this.rll) {
                        C4879a.xxA.mo10053d(C15663j.this.yWV);
                        C15663j.this.yWK.dGK();
                        C15663j.this.rll = false;
                    }
                }
                C15663j.this.yWL = false;
            }
            AppMethodBeat.m2505o(32324);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.j$2 */
    class C156692 implements C3855b {
        C156692() {
        }

        public final void aFw() {
            AppMethodBeat.m2504i(32314);
            if (C15663j.this.yTG.dFP() != null) {
                C15663j.m23953a(C15663j.this, C15663j.this.yTG.dFP());
            }
            C15663j.this.yTG.yTI.yWv.stopTimer();
            AppMethodBeat.m2505o(32314);
        }

        /* renamed from: oA */
        public final void mo8552oA(int i) {
            AppMethodBeat.m2504i(32315);
            String str = null;
            try {
                str = C15663j.this.yTG.dFP().dGH().yXp.getVideoPath();
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.Imagegallery.handler.video", e, "", new Object[0]);
                C4990ab.m7412e("MicroMsg.Imagegallery.handler.video", "on seek get video path error: " + e.toString());
            }
            C4990ab.m7417i("MicroMsg.Imagegallery.handler.video", "on seek to time[%d] isOnlinePlay[%b] videoPath[%s]", Integer.valueOf(i), Boolean.valueOf(C15663j.this.rll), str);
            if (C5046bo.isNullOrNil(str)) {
                C7620bi dFO = C15663j.this.yTG.dFO();
                if (dFO != null && dFO.bws()) {
                    C26494u.m42252f(dFO.field_imgPath, i * 1000, C15663j.this.rll);
                }
                C15663j.this.yTG.mo64307OP(C15663j.this.yTG.yTI.getCurrentItem());
            } else {
                boolean aG;
                if (C15663j.this.rll) {
                    aG = C15663j.this.yWK.mo74896aG(i, true);
                } else {
                    C15663j.this.mo27899ae(i, true);
                    aG = true;
                }
                if (aG) {
                    C15663j.this.mo27903cV(false);
                }
            }
            C15663j.this.yTG.yTI.dGk();
            AppMethodBeat.m2505o(32315);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.j$8 */
    class C156708 implements Runnable {
        C156708() {
        }

        public final void run() {
            AppMethodBeat.m2504i(32323);
            String bOU = C12691e.bOU();
            if (C5046bo.isNullOrNil(bOU)) {
                C7060h.pYm.mo8374X(14092, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                AppMethodBeat.m2505o(32323);
                return;
            }
            C7060h.pYm.mo8374X(14092, bOU);
            AppMethodBeat.m2505o(32323);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.j$7 */
    class C156727 implements C43332b {
        C156727() {
        }

        public final long bOR() {
            AppMethodBeat.m2504i(32322);
            C4990ab.m7417i("MicroMsg.Imagegallery.handler.video", "%d video get online cache sec", Integer.valueOf(C15663j.this.hashCode()));
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(C5127a.USERINFO_VIDEO_NEED_RESET_EXTRACTOR_BOOLEAN, Boolean.TRUE);
            try {
                if (C15663j.this.rll && C15663j.this.yWK != null) {
                    long j = (long) C15663j.this.yWK.fUV;
                    AppMethodBeat.m2505o(32322);
                    return j;
                }
            } catch (Exception e) {
            }
            AppMethodBeat.m2505o(32322);
            return 0;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.j$10 */
    class C1567310 implements Runnable {
        C1567310() {
        }

        public final void run() {
            AppMethodBeat.m2504i(32325);
            C15663j.this.yWN = true;
            C15663j.this.lastCheckTime = C15663j.this.vgx = 0;
            C15663j.this.iaf.mo67733cy(false);
            C15663j.m23973j(C15663j.this);
            if (C15663j.this.rll) {
                C15663j.this.rlq = C5046bo.anU();
                C15663j.this.yWK.dGK();
                C15663j.this.yWK.reset();
                C15663j.this.rll = false;
                C15663j.this.yWW = false;
            }
            C26494u.m42252f(C15663j.this.filename, 0, C15663j.this.rll);
            if (C15663j.this.yVF != null) {
                C15682a c15682a = (C15682a) C15663j.this.yVF.get(C15663j.this.filename);
                if (c15682a != null) {
                    C36180k dFP = C15663j.this.yTG.dFP();
                    dFP.dGH().yXp.stop();
                    C15663j.this.yWO = 0;
                    C15663j.this.mo27898a(dFP, c15682a.csG, c15682a.pos);
                    C15663j.this.mo27897Pg(0);
                    if (dFP.dGH().yXx.getVisibility() != 8) {
                        dFP.dGH().yXx.setVisibility(8);
                    }
                }
            }
            AppMethodBeat.m2505o(32325);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.j$12 */
    class C1567412 implements Runnable {
        C1567412() {
        }

        public final void run() {
            AppMethodBeat.m2504i(32327);
            try {
                int A;
                if (C5046bo.isNullOrNil(C15663j.this.yTG.dFP().dGH().yXp.getVideoPath())) {
                    A = C26494u.m42237A(C15663j.this.yWK.fUR, C15663j.this.filename);
                } else {
                    A = C15663j.this.yTG.dFP().dGH().yXp.getCurrentPosition() / 1000;
                }
                C15663j.this.yWK.mo74905mm(A);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.Imagegallery.handler.video", e, "start timer error[%s]", e.toString());
            }
            C15663j.this.rcg.mo16770ae(500, 500);
            AppMethodBeat.m2505o(32327);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.j$13 */
    class C1567513 implements C5015a {
        C1567513() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(32328);
            if (C15663j.this.yWK.isStreaming()) {
                C36180k dFP = C15663j.this.yTG.dFP();
                if (dFP == null) {
                    AppMethodBeat.m2505o(32328);
                    return false;
                } else if (dFP.yXm == null) {
                    AppMethodBeat.m2505o(32328);
                    return false;
                } else if (dFP.dGH().yXm.getVisibility() != 0) {
                    AppMethodBeat.m2505o(32328);
                    return false;
                } else {
                    boolean z = true;
                    if (dFP.dGH().yXp.isPlaying()) {
                        z = C15663j.m23962b(C15663j.this, dFP);
                    }
                    if (z) {
                        boolean mm = C15663j.this.yWK.mo74905mm(dFP.dGH().yXp.getCurrentPosition() / 1000);
                        AppMethodBeat.m2505o(32328);
                        return mm;
                    }
                    AppMethodBeat.m2505o(32328);
                    return false;
                }
            }
            AppMethodBeat.m2505o(32328);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.j$14 */
    class C1567614 implements C5015a {
        C1567614() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(32329);
            if (C15663j.this.yTG == null) {
                C4990ab.m7420w("MicroMsg.Imagegallery.handler.video", "[onTimerExpired] null == adapter");
                AppMethodBeat.m2505o(32329);
                return false;
            }
            C36180k dFP = C15663j.this.yTG.dFP();
            if (dFP == null) {
                AppMethodBeat.m2505o(32329);
                return false;
            } else if (dFP.yXm == null) {
                AppMethodBeat.m2505o(32329);
                return false;
            } else if (dFP.dGH().yXm.getVisibility() != 0) {
                AppMethodBeat.m2505o(32329);
                return false;
            } else {
                int currentItem = C15663j.this.yTG.yTI.getCurrentItem();
                if (((C26493s) C15663j.this.yWJ.get(currentItem)) == null) {
                    C15663j.this.mo27896Pf(currentItem);
                    AppMethodBeat.m2505o(32329);
                    return false;
                } else if (dFP.dGH().yXp.isPlaying()) {
                    C15663j.this.yWO = dFP.dGH().yXp.getCurrentPosition();
                    C15663j.this.mo27897Pg(C15663j.this.yWO / 1000);
                    AppMethodBeat.m2505o(32329);
                    return true;
                } else {
                    C4990ab.m7416i("MicroMsg.Imagegallery.handler.video", "it is not playing, stop offline timer");
                    AppMethodBeat.m2505o(32329);
                    return false;
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.j$15 */
    class C1567715 implements Runnable {
        C1567715() {
        }

        public final void run() {
            AppMethodBeat.m2504i(32330);
            C15663j.this.yTG.yTI.onBackPressed();
            AppMethodBeat.m2505o(32330);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.j$3 */
    class C156783 extends C4884c<C32594lp> {
        C156783() {
            AppMethodBeat.m2504i(32316);
            this.xxI = C32594lp.class.getName().hashCode();
            AppMethodBeat.m2505o(32316);
        }

        /* renamed from: a */
        private boolean m23992a(C32594lp c32594lp) {
            AppMethodBeat.m2504i(32317);
            if (!C15663j.this.yWK.mo74895ZA(c32594lp.cHq.cHr)) {
                AppMethodBeat.m2505o(32317);
                return false;
            } else if (c32594lp.cHq.retCode == 0 || c32594lp.cHq.retCode == -21006) {
                String uh;
                int i;
                C46653m f;
                switch (c32594lp.cHq.cAd) {
                    case 1:
                        C46653m f2 = C15663j.this.yWK;
                        long j = (long) c32594lp.cHq.offset;
                        long j2 = c32594lp.cHq.cHs;
                        boolean z = c32594lp.cHq.cHt;
                        C4990ab.m7417i("MicroMsg.OnlineVideoUIHelper", "deal moov ready moovPos[%d] needSeekTime[%d] timeDuration[%d] startDownload[%d %d]", Long.valueOf(j), Integer.valueOf(f2.fUS), Integer.valueOf(f2.fUR), Long.valueOf(j2), Long.valueOf(f2.egA));
                        if (f2.fUR != 0) {
                            C4990ab.m7420w("MicroMsg.OnlineVideoUIHelper", "moov had callback, do nothing.");
                        } else {
                            if (j2 <= f2.egA) {
                                j2 = f2.egA;
                            }
                            f2.egA = j2;
                            C7060h.pYm.mo8378a(354, 5, 1, false);
                            f2.rlG = C5046bo.anU();
                            C37961o.all();
                            uh = C9720t.m17303uh(f2.filename);
                            try {
                                if (f2.fUQ == null) {
                                    C4990ab.m7420w("MicroMsg.OnlineVideoUIHelper", "parser is null, thread is error.");
                                } else if (f2.fUQ.mo21148v(uh, j)) {
                                    f2.fUR = f2.fUQ.gkm;
                                    C4990ab.m7417i("MicroMsg.OnlineVideoUIHelper", "mp4 parse moov success. duration %d filename %s isFastStart %b", Integer.valueOf(f2.fUR), f2.filename, Boolean.valueOf(z));
                                    if (!z) {
                                        C5004al.m7441d(new C53411());
                                    }
                                    if (f2.fUS == -1) {
                                        f2.fUP = 1;
                                    } else {
                                        f2.fUP = 2;
                                    }
                                    C7060h.pYm.mo8378a(354, 7, 1, false);
                                } else {
                                    C4990ab.m7420w("MicroMsg.OnlineVideoUIHelper", "mp4 parse moov error.");
                                    C37961o.alm();
                                    C45150e.m83031k(f2.cHr, 0, -1);
                                    C26494u.m42243af(f2.filename, 15);
                                    C7060h.pYm.mo8378a(354, 8, 1, false);
                                    C4990ab.m7421w("MicroMsg.OnlineVideoUIHelper", "%d rpt parse moov fail %s ", Integer.valueOf(f2.hashCode()), f2.filename);
                                    C7060h.pYm.mo8381e(13836, Integer.valueOf(302), Long.valueOf(C5046bo.anT()), "");
                                }
                            } catch (Exception e) {
                                C4990ab.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", e, "", new Object[0]);
                                C4990ab.m7412e("MicroMsg.OnlineVideoUIHelper", "deal moov ready error: " + e.toString());
                            }
                        }
                        C15663j.this.rll = true;
                        break;
                    case 2:
                        C46653m f3 = C15663j.this.yWK;
                        uh = c32594lp.cHq.cHr;
                        i = c32594lp.cHq.offset;
                        int i2 = c32594lp.cHq.length;
                        f3.fUY = false;
                        if (i < 0 || i2 < 0) {
                            C4990ab.m7421w("MicroMsg.OnlineVideoUIHelper", "deal data available error offset[%d], length[%d]", Integer.valueOf(i), Integer.valueOf(i2));
                        } else if (f3.mo74895ZA(uh)) {
                            Integer num = (Integer) f3.rlC.get(f3.cHr + i + "_" + i2);
                            if (num == null || num.intValue() <= 0) {
                                try {
                                    f3.fUV = f3.fUQ.mo21147cK(i, i2);
                                } catch (Exception e2) {
                                    C4990ab.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", e2, "", new Object[0]);
                                    C4990ab.m7412e("MicroMsg.OnlineVideoUIHelper", "deal data available file pos to video time error: " + e2.toString());
                                }
                            } else {
                                f3.fUV = num.intValue();
                            }
                            C4990ab.m7417i("MicroMsg.OnlineVideoUIHelper", "deal data available. offset[%d] length[%d] cachePlayTime[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(f3.fUV));
                        }
                        if (c32594lp.cHq.length > 0) {
                            C15663j.this.mo27903cV(true);
                            break;
                        }
                        break;
                    case 3:
                        C15663j.this.mo27903cV(true);
                        break;
                    case 4:
                        f = C15663j.this.yWK;
                        C4990ab.m7417i("MicroMsg.OnlineVideoUIHelper", "deal stream finish. playStatus %d ", Integer.valueOf(f.fUP));
                        f.fUY = false;
                        f.fUO = 3;
                        if (f.fUP == 0) {
                            C4990ab.m7420w("MicroMsg.OnlineVideoUIHelper", "it had not moov callback and download finish start to play video.");
                            f.csl();
                            C7060h.pYm.mo8378a(354, 6, 1, false);
                        } else if (f.fUP == 5) {
                            C4990ab.m7420w("MicroMsg.OnlineVideoUIHelper", "it had play error, it request all video data finish, start to play." + f.cHr);
                            f.csl();
                        }
                        f.dGM();
                        C7060h.pYm.mo8378a(354, 26, 1, false);
                        C15663j.this.mo27903cV(true);
                        break;
                    case 5:
                        f = C15663j.this.yWK;
                        String str = c32594lp.cHq.cHr;
                        i = c32594lp.cHq.offset;
                        if (f.mo74895ZA(str)) {
                            f.rlE = (i * 100) / f.gUm;
                            C4990ab.m7416i("MicroMsg.OnlineVideoUIHelper", "deal progress callback. downloadedPercent : " + f.rlE);
                        }
                        if (f.rlE >= 100) {
                            f.fUO = 3;
                            break;
                        }
                        break;
                    case 6:
                        f = C15663j.this.yWK;
                        C4990ab.m7416i("MicroMsg.OnlineVideoUIHelper", "deal had dup video.");
                        f.dGM();
                        f.csl();
                        break;
                    default:
                        C4990ab.m7420w("MicroMsg.Imagegallery.handler.video", "unknown event opcode " + c32594lp.cHq.cAd);
                        break;
                }
                AppMethodBeat.m2505o(32317);
                return false;
            } else {
                C4990ab.m7420w("MicroMsg.Imagegallery.handler.video", "stream download online video error. retCode: " + c32594lp.cHq.retCode);
                C15663j.m23954a(C15663j.this, c32594lp.cHq.cHr, c32594lp.cHq.retCode);
                AppMethodBeat.m2505o(32317);
                return false;
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.j$6 */
    class C156816 implements C14980e {
        C156816() {
        }

        public final void bQL() {
            AppMethodBeat.m2504i(32321);
            C4990ab.m7417i("MicroMsg.Imagegallery.handler.video", "%d on texture update.", Integer.valueOf(C15663j.this.hashCode()));
            try {
                C15663j.this.yTG.dFP().mo57071a(true, 1.0f);
                AppMethodBeat.m2505o(32321);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.Imagegallery.handler.video", "texture view update. error " + e.toString());
                AppMethodBeat.m2505o(32321);
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.j$a */
    public static class C15682a {
        public C7620bi csG;
        public int pos;

        public C15682a(C7620bi c7620bi, int i) {
            this.csG = c7620bi;
            this.pos = i;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m23952a(C15663j c15663j, C7620bi c7620bi, C26493s c26493s, int i, boolean z) {
        AppMethodBeat.m2504i(32377);
        c15663j.m23951a(c7620bi, c26493s, i, z);
        AppMethodBeat.m2505o(32377);
    }

    /* renamed from: j */
    static /* synthetic */ void m23973j(C15663j c15663j) {
        AppMethodBeat.m2504i(32374);
        c15663j.csh();
        AppMethodBeat.m2505o(32374);
    }

    public C15663j(C40775c c40775c) {
        super(c40775c);
        AppMethodBeat.m2504i(32335);
        C4879a c4879a = C4879a.xxA;
        C23701al c23701al = new C23701al(C23702a.VIDEO_GALLERY, c40775c.yTI);
        this.yWI = c23701al;
        c4879a.mo10052c(c23701al);
        C4879a.xxA.mo10052c(this.yWV);
        this.iaf = new C42192d();
        AppMethodBeat.m2505o(32335);
    }

    /* renamed from: a */
    public final boolean mo27898a(C36180k c36180k, C7620bi c7620bi, int i) {
        AppMethodBeat.m2504i(32336);
        super.mo27898a(c36180k, c7620bi, i);
        C26493s bG = C15663j.m23963bG(c7620bi);
        if (c7620bi == null) {
            C4990ab.m7412e("MicroMsg.Imagegallery.handler.video", "msg is null!!");
            AppMethodBeat.m2505o(32336);
            return false;
        }
        if (this.yVF != null) {
            this.yVF.put(c7620bi.field_imgPath, new C15682a(c7620bi, i));
        } else {
            C4990ab.m7412e("MicroMsg.Imagegallery.handler.video", "mCacheMap is null!");
        }
        if (bG == null) {
            AppMethodBeat.m2505o(32336);
            return false;
        }
        C37961o.all();
        c36180k.dGH().yXn.setImageBitmap(C4977b.m7374i(C9720t.m17304ui(c7620bi.field_imgPath), 1.0f));
        if (c36180k.dGH().yXp.isPlaying()) {
            c36180k.dGH().yXp.stop();
        }
        c36180k.yXr.setVisibility(8);
        c36180k.dGH().yXq.setVisibility(8);
        c36180k.dGH().yXx.setVisibility(8);
        c36180k.mo57071a(false, 0.0f);
        this.yWP = 0;
        this.rlp = C5046bo.anU();
        AppMethodBeat.m2505o(32336);
        return true;
    }

    /* renamed from: bG */
    public static C26493s m23963bG(C7620bi c7620bi) {
        AppMethodBeat.m2504i(32337);
        if (C40775c.m70574f(c7620bi)) {
            C26493s ut = C26494u.m42268ut(c7620bi.field_imgPath);
            AppMethodBeat.m2505o(32337);
            return ut;
        }
        AppMethodBeat.m2505o(32337);
        return null;
    }

    public final void pause(int i) {
        AppMethodBeat.m2504i(32338);
        m23959b(mo39605OJ(i));
        this.iaf.mo67733cy(false);
        this.yTG.yTI.mo64299qx(true);
        AppMethodBeat.m2505o(32338);
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: i */
    public final void mo27911i(C7620bi c7620bi, int i) {
        AppMethodBeat.m2504i(32339);
        C4990ab.m7416i("MicroMsg.Imagegallery.handler.video", "toggle video");
        if (c7620bi == null) {
            AppMethodBeat.m2505o(32339);
        } else if (C40775c.m70574f(c7620bi) || C40775c.m70565bp(c7620bi)) {
            C26493s bG = C15663j.m23963bG(c7620bi);
            if (bG == null) {
                AppMethodBeat.m2505o(32339);
            } else if (this.rll && this.yWK != null && this.yWK.fUU) {
                C4990ab.m7417i("MicroMsg.Imagegallery.handler.video", "%d it loading video data, do not response button click.", Integer.valueOf(hashCode()));
                AppMethodBeat.m2505o(32339);
            } else if (this.yTG.yTI.cGZ()) {
                m23959b(mo39605OJ(i));
                this.yTG.yTI.mo64299qx(true);
                this.yTG.yTI.yWv.stopTimer();
                this.iaf.mo67733cy(false);
                C4990ab.m7416i("MicroMsg.Imagegallery.handler.video", "toggle pause video.");
                AppMethodBeat.m2505o(32339);
            } else {
                C9638aw.m17190ZK();
                if (C18628c.isSDCardAvailable()) {
                    int currentPosition;
                    if (this.rll) {
                        try {
                            if (this.yTG.dFP().yXp != null) {
                                currentPosition = this.yTG.dFP().yXp.getCurrentPosition() / 1000;
                                if (this.yWK != null) {
                                    C4990ab.m7421w("MicroMsg.Imagegallery.handler.video", "%d toggle video but online video helper is null.", Integer.valueOf(hashCode()));
                                } else if (this.yWK.mo74906mn(currentPosition)) {
                                    C4990ab.m7416i("MicroMsg.Imagegallery.handler.video", "toggle play video");
                                    m23951a(c7620bi, bG, i, this.rll);
                                } else {
                                    C4990ab.m7416i("MicroMsg.Imagegallery.handler.video", "toggle start timer.");
                                    mo27903cV(false);
                                }
                            }
                        } catch (Exception e) {
                            C4990ab.printErrStackTrace("MicroMsg.Imagegallery.handler.video", e, "", new Object[0]);
                        }
                        currentPosition = 0;
                        if (this.yWK != null) {
                        }
                    } else {
                        if (c7620bi.field_isSend == 0) {
                            if (bG.status == 113 || bG.status == C27011o.CTRL_INDEX) {
                                m23950a(c7620bi, bG);
                            } else {
                                if (bG.status == 199) {
                                    m23951a(c7620bi, bG, i, false);
                                }
                                if (bG.status == 111) {
                                    m23950a(c7620bi, bG);
                                }
                                if (bG.status == 112) {
                                    m23950a(c7620bi, bG);
                                }
                                if (bG.status == 121 || bG.status == 122) {
                                    m23950a(c7620bi, bG);
                                }
                                if (bG.status == 123) {
                                    m23951a(c7620bi, bG, i, false);
                                }
                            }
                        }
                        if (c7620bi.field_isSend == 1) {
                            currentPosition = bG.status;
                            if (currentPosition == 111 || currentPosition == 113 || currentPosition == 112 || currentPosition == 121 || currentPosition == 122) {
                                C4990ab.m7417i("MicroMsg.Imagegallery.handler.video", "download video. msg talker[%s], info status[%d]", c7620bi.field_talker, Integer.valueOf(currentPosition));
                                m23950a(c7620bi, bG);
                            } else {
                                m23951a(c7620bi, bG, i, false);
                            }
                        }
                    }
                    if (this.yTG.yTI.yWu) {
                        this.yTG.yTI.dGk();
                    }
                    dGB();
                    AppMethodBeat.m2505o(32339);
                    return;
                }
                C23639t.m36492hO(this.yTG.yTI.mController.ylL);
                AppMethodBeat.m2505o(32339);
            }
        } else {
            AppMethodBeat.m2505o(32339);
        }
    }

    /* renamed from: j */
    public final void mo27912j(C7620bi c7620bi, int i) {
        AppMethodBeat.m2504i(32340);
        C4990ab.m7416i("MicroMsg.Imagegallery.handler.video", "toggleVideoMenu pos ");
        C26493s ut = C26494u.m42268ut(c7620bi.field_imgPath);
        if (!(ut == null || ut.alz())) {
            m23959b(mo39605OJ(i));
            this.yTG.yTI.mo64299qx(true);
            if (this.rll) {
                this.yWK.dGK();
                this.yWK.reset();
            }
            m23950a(c7620bi, ut);
            if (this.yTG.yTI.mo64296np(c7620bi.field_msgId) == 2) {
                m23968eC(c7620bi.field_imgPath, 8);
                AppMethodBeat.m2505o(32340);
                return;
            }
            m23968eC(c7620bi.field_imgPath, 5);
        }
        AppMethodBeat.m2505o(32340);
    }

    /* renamed from: a */
    private void m23951a(C7620bi c7620bi, C26493s c26493s, int i, boolean z) {
        AppMethodBeat.m2504i(32341);
        if (c7620bi == null || c26493s == null) {
            AppMethodBeat.m2505o(32341);
        } else if (c7620bi.dtH()) {
            Toast.makeText(this.yTG.yTI, C25738R.string.f18, 0).show();
            AppMethodBeat.m2505o(32341);
        } else {
            String uh;
            String alv;
            if (c26493s.fXk == -1) {
                alv = c26493s.alv();
                if (!C5730e.m8628ct(alv)) {
                    C37961o.all();
                    uh = C9720t.m17303uh(c7620bi.field_imgPath);
                }
                uh = alv;
            } else {
                C37961o.all();
                alv = C9720t.m17303uh(c7620bi.field_imgPath);
                if (c7620bi.field_isSend == 1 && c26493s.fXn != null && c26493s.fXn.wDP) {
                    try {
                        String atb = C5730e.atb(alv);
                        if (!atb.endsWith("/")) {
                            atb = atb + "/";
                        }
                        atb = atb + C5730e.atd(alv) + "_hd.mp4";
                        C4990ab.m7417i("MicroMsg.Imagegallery.handler.video", "local capture video, hdFilePath: %s, exist: %s", atb, Boolean.valueOf(C5730e.m8628ct(atb)));
                        if (!C5730e.m8628ct(atb)) {
                            atb = alv;
                        }
                        uh = atb;
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.Imagegallery.handler.video", "try to get hd filePath error: %s", e.getMessage());
                    }
                }
                uh = alv;
            }
            if (uh == null || !C5730e.m8628ct(uh)) {
                Toast.makeText(this.yTG.yTI, C25738R.string.f18, 0).show();
                AppMethodBeat.m2505o(32341);
                return;
            }
            C36180k OJ = mo39605OJ(i);
            if (OJ == null) {
                AppMethodBeat.m2505o(32341);
                return;
            }
            int i2 = 0;
            if (C1855t.m3896kH(c26493s.getUser())) {
                i2 = C37921n.m64060mA(c26493s.getUser());
            }
            boolean ua = C26492r.m42228ua(uh);
            C4990ab.m7417i("MicroMsg.Imagegallery.handler.video", "play video pos[%d], isOnlinePlay[%b] opcode[%d] resetByCompletion[%b]", Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(this.yTG.yTI.mo64296np(c7620bi.field_msgId)), Boolean.valueOf(this.yWR));
            if (ua) {
                C7060h.pYm.mo8381e(12084, Integer.valueOf(c26493s.frO), Integer.valueOf(c26493s.fXd * 1000), Integer.valueOf(0), Integer.valueOf(3), c26493s.getUser(), Integer.valueOf(i2), C26493s.m42234ue(c26493s.alw()), Long.valueOf(c26493s.createTime));
                if (!C40434a.m69349c(uh, this.yTG.yTI.mController.ylL, ua)) {
                    Toast.makeText(this.yTG.yTI.mController.ylL, this.yTG.yTI.getString(C25738R.string.f1k), 0).show();
                }
            } else if (C1427q.etn.esh == 1 && C40434a.m69348b(c26493s.getFileName(), this.yTG.yTI.mController.ylL, ua)) {
                AppMethodBeat.m2505o(32341);
                return;
            } else {
                C9638aw.m17190ZK();
                if (((Integer) C18628c.m29072Ry().get(C5127a.USERINFO_LOCAL_SIGHT_DEBUGINFO_INT_SYNC, Integer.valueOf(0))).intValue() == 1 && OJ.yXr != null) {
                    OJ.yXr.setVisibility(0);
                    OJ.yXr.setText(C21846d.m33384RK(uh));
                }
                OJ.mo57070a(c26493s.fXd, c26493s.frO, i2, c26493s.getUser(), C26493s.m42234ue(c26493s.alw()), c26493s.createTime);
                this.rll = z;
                this.yWL = true;
                this.filename = c26493s.getFileName();
                if (r9 == 3) {
                    OJ.dGH().yXp.setMute(true);
                } else {
                    OJ.dGH().yXp.setMute(false);
                }
                if (OJ.dGH().yXp.getVideoPath() == null || !OJ.dGH().yXp.getVideoPath().equals(uh) || OJ.dGH().yXp.isPlaying() || this.yWR) {
                    this.yWN = false;
                    this.yWR = false;
                    OJ.dGH().yXp.setVideoPath(uh);
                    if (OJ.dGH().yXp instanceof VideoPlayerTextureView) {
                        ((VideoPlayerTextureView) OJ.dGH().yXp).setIOnlineCache(this.orK);
                        ((VideoPlayerTextureView) OJ.dGH().yXp).setNeedResetExtractor(bwE());
                        ((VideoPlayerTextureView) OJ.dGH().yXp).setIsOnlineVideoType(z);
                    }
                    OJ.mo57071a(true, 0.0f);
                } else {
                    OJ.mo57071a(true, 1.0f);
                    OJ.dGH().yXp.start();
                    csg();
                    if (!z) {
                        arz(this.filename);
                    }
                    mo27897Pg(OJ.dGH().yXp.getCurrentPosition() / 1000);
                    mo27903cV(false);
                }
                m23957b(i, c26493s);
                this.yTG.yTI.mo64299qx(false);
                this.yTG.yTI.mController.ylL.getWindow().addFlags(128);
                if (C1443d.m3067fP(18)) {
                    arz(this.filename);
                }
                this.iaf.mo67732a(this);
            }
            OJ.dGH().yXq.setVisibility(8);
            AppMethodBeat.m2505o(32341);
        }
    }

    /* renamed from: a */
    private void m23950a(C7620bi c7620bi, C26493s c26493s) {
        AppMethodBeat.m2504i(32342);
        if (!(C32856ab.m53750ch(this.yTG.yTI.mController.ylL) || yWS)) {
            yWS = true;
        }
        m23958b(c7620bi, c26493s);
        AppMethodBeat.m2505o(32342);
    }

    /* renamed from: b */
    private void m23958b(C7620bi c7620bi, C26493s c26493s) {
        AppMethodBeat.m2504i(32343);
        C4990ab.m7417i("MicroMsg.Imagegallery.handler.video", "startDownloading [%d]", Integer.valueOf(hashCode()));
        if (c7620bi == null || c26493s == null) {
            AppMethodBeat.m2505o(32343);
            return;
        }
        C36180k dFP = this.yTG.dFP();
        if (dFP == null) {
            AppMethodBeat.m2505o(32343);
            return;
        }
        C37951y.m64162C(c7620bi);
        int np = this.yTG.yTI.mo64296np(c7620bi.field_msgId);
        C4990ab.m7410d("MicroMsg.Imagegallery.handler.video", "enterVideoOpCode : ".concat(String.valueOf(np)));
        switch (np) {
            case 0:
                break;
            case 1:
            case 2:
                if (c26493s.aly()) {
                    C4990ab.m7416i("MicroMsg.Imagegallery.handler.video", "start complete online video");
                    C26494u.m42259uA(c7620bi.field_imgPath);
                } else {
                    C4990ab.m7416i("MicroMsg.Imagegallery.handler.video", "start complete offline video");
                    m23968eC(c7620bi.field_imgPath, 10);
                    C26494u.m42264up(c7620bi.field_imgPath);
                }
                C37961o.all().mo21053a(this, Looper.getMainLooper());
                this.yTG.yTI.dGm();
                this.yWW = false;
                dFP.dGH().yXo.setVisibility(8);
                dFP.dGH().yXq.setVisibility(0);
                dFP.dGH().yXq.setProgress(C26494u.m42255g(c26493s));
                if (np == 2) {
                    C15663j.dGD();
                    AppMethodBeat.m2505o(32343);
                    return;
                }
                C15663j.dGC();
                AppMethodBeat.m2505o(32343);
                return;
            case 3:
                C4990ab.m7417i("MicroMsg.Imagegallery.handler.video", "%d mute play video [%d]", Integer.valueOf(hashCode()), Integer.valueOf(np));
                break;
            default:
                C4990ab.m7421w("MicroMsg.Imagegallery.handler.video", "enterVideoOpCode[%d] is error", Integer.valueOf(np));
                AppMethodBeat.m2505o(32343);
                return;
        }
        if (this.yWK.arA(c7620bi.field_imgPath)) {
            C4990ab.m7416i("MicroMsg.Imagegallery.handler.video", "start online play video.");
            this.rll = true;
            C37961o.all().mo21052a(this);
            this.yTG.yTI.dGm();
            this.yWW = false;
            dFP.dGH().yXo.setVisibility(8);
            dFP.dGH().yXq.setVisibility(8);
            dFP.dGH().yXx.setVisibility(0);
            AppMethodBeat.m2505o(32343);
            return;
        }
        C4990ab.m7416i("MicroMsg.Imagegallery.handler.video", "start offline play video.");
        this.rll = false;
        C37961o.all().mo21053a(this, Looper.getMainLooper());
        C26494u.m42264up(c7620bi.field_imgPath);
        this.yTG.yTI.dGm();
        this.yWW = false;
        dFP.dGH().yXo.setVisibility(8);
        dFP.dGH().yXq.setVisibility(0);
        dFP.dGH().yXq.setProgress(C26494u.m42255g(c26493s));
        AppMethodBeat.m2505o(32343);
    }

    /* renamed from: eC */
    private void m23968eC(final String str, final int i) {
        AppMethodBeat.m2504i(32344);
        C9638aw.m17180RS().mo10302aa(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(32313);
                C26494u.m42244ag(str, i);
                AppMethodBeat.m2505o(32313);
            }
        });
        AppMethodBeat.m2505o(32344);
    }

    /* renamed from: b */
    private boolean m23960b(C15682a c15682a) {
        AppMethodBeat.m2504i(32345);
        if (c15682a == null) {
            AppMethodBeat.m2505o(32345);
            return false;
        }
        C37961o.all().mo21052a(this);
        if (this.yTG.yTI.getCurrentItem() == c15682a.pos) {
            C36180k OJ = mo39605OJ(c15682a.pos);
            if (OJ != null) {
                OJ.dGH().yXx.setVisibility(8);
                OJ.dGH().yXq.setVisibility(8);
                OJ.dGH().yXo.setVisibility(8);
            }
            this.yWW = true;
            this.yTG.yTI.dGl();
            AppMethodBeat.m2505o(32345);
            return true;
        }
        this.yTG.mo64309OR(c15682a.pos);
        AppMethodBeat.m2505o(32345);
        return false;
    }

    /* renamed from: Du */
    public final void mo27895Du() {
        AppMethodBeat.m2504i(32346);
        C4990ab.m7416i("MicroMsg.Imagegallery.handler.video", "stopAll. video handler hash code : " + hashCode());
        this.rlq = C5046bo.anU();
        SparseArray sparseArray = this.yTG.yyL;
        int i = 0;
        int i2 = 0;
        while (i < sparseArray.size()) {
            int keyAt = sparseArray.keyAt(i);
            if (!(sparseArray.get(keyAt) == null || ((View) sparseArray.get(keyAt)).getTag() == null)) {
                C36180k c36180k = (C36180k) ((View) sparseArray.get(keyAt)).getTag();
                if (c36180k.yXm != null && c36180k.dGH().yXm.getVisibility() == 0 && (((View) c36180k.dGH().yXp).getVisibility() == 0 || !C5046bo.isNullOrNil(c36180k.dGH().yXp.getVideoPath()) || (this.rll && this.yWK.isStreaming()))) {
                    C4990ab.m7416i("MicroMsg.Imagegallery.handler.video", "stop");
                    cse();
                    if (c36180k != null) {
                        csh();
                        if (this.rll) {
                            this.yWK.dGK();
                        }
                        if (!this.yWM) {
                            C26494u.m42252f(this.filename, this.yWO - 1000, this.rll);
                        }
                        c36180k.dGH().yXq.setVisibility(8);
                        c36180k.dGH().yXx.setVisibility(8);
                        c36180k.dGH().yXp.stop();
                        mo27897Pg(0);
                        c36180k.mo57071a(false, 0.0f);
                        this.rll = false;
                        this.yWW = false;
                        this.yWR = false;
                        this.filename = null;
                        this.rlv = 0;
                        this.rlu = 0;
                        this.yWX = 0;
                        this.yWU = 0;
                        this.yWQ = 0;
                        this.yWP = 0;
                        this.vgx = 0;
                        this.lastCheckTime = 0;
                    }
                    i2 = 1;
                }
            }
            i++;
            i2 = i2;
        }
        this.iaf.mo67733cy(false);
        if (i2 == 0 && this.rll) {
            this.yWK.dGK();
            this.rll = false;
        }
        cse();
        this.yWJ.clear();
        AppMethodBeat.m2505o(32346);
    }

    /* renamed from: b */
    private void m23959b(C36180k c36180k) {
        AppMethodBeat.m2504i(32347);
        if (c36180k == null) {
            AppMethodBeat.m2505o(32347);
            return;
        }
        cse();
        C4990ab.m7410d("MicroMsg.Imagegallery.handler.video", "pause video.");
        if (c36180k.dGH().yXp.isPlaying()) {
            c36180k.dGH().yXp.pause();
            csh();
        }
        AppMethodBeat.m2505o(32347);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onResume() {
        AppMethodBeat.m2504i(32348);
        C4990ab.m7416i("MicroMsg.Imagegallery.handler.video", "ui on resume, add online video event.");
        this.yWT.removeMessages(1);
        C4879a.xxA.mo10052c(this.yWV);
        if (this.yTG != null && C1443d.m3068iW(21)) {
            C36180k dFP = this.yTG.dFP();
            if (!(dFP == null || dFP.yXp == null)) {
                if (dFP.yXp instanceof VideoPlayerTextureView) {
                    ((VideoPlayerTextureView) dFP.yXp).bPd();
                    AppMethodBeat.m2505o(32348);
                    return;
                } else if (dFP.yXp instanceof VideoTextureView) {
                    ((VideoTextureView) dFP.yXp).bPd();
                }
            }
        }
        AppMethodBeat.m2505o(32348);
    }

    public final void detach() {
        AppMethodBeat.m2504i(32349);
        C4990ab.m7417i("MicroMsg.Imagegallery.handler.video", "detach.[%d]", Integer.valueOf(hashCode()));
        this.rlq = C5046bo.anU();
        this.yWT.removeMessages(1);
        cse();
        C4879a.xxA.mo10053d(this.yWI);
        C4879a.xxA.mo10053d(this.yWV);
        mo27895Du();
        this.yTG.yTI.mController.ylL.getWindow().clearFlags(128);
        this.yTG.yTI.dFZ().yVV.setIplaySeekCallback(null);
        super.detach();
        this.yVF.clear();
        this.yVF = null;
        C37961o.all().mo21052a(this);
        this.yWJ.clear();
        C46653m c46653m = this.yWK;
        c46653m.reset();
        c46653m.fUQ = null;
        c46653m.yXX = null;
        c46653m.yXY = null;
        if (C12691e.bOT()) {
            C9638aw.m17180RS().mo10302aa(new C156708());
        }
        C37961o.alq().alG();
        C37961o.alq().run();
        AppMethodBeat.m2505o(32349);
    }

    public final void dGz() {
        AppMethodBeat.m2504i(32350);
        this.yWM = false;
        this.mqi = 0;
        C36180k dFP = this.yTG != null ? this.yTG.dFP() : null;
        if (dFP == null) {
            C4990ab.m7420w("MicroMsg.Imagegallery.handler.video", "notify video prepared, but holder is null.");
            AppMethodBeat.m2505o(32350);
            return;
        }
        final int mA = C5046bo.m7576mA((long) dFP.dGH().yXp.getDuration());
        int videoTotalTime = this.yTG.yTI.dFZ().yVV.getVideoTotalTime();
        C4990ab.m7417i("MicroMsg.Imagegallery.handler.video", "%d videoDuration %d hadSetTotalTime %d", Integer.valueOf(hashCode()), Integer.valueOf(mA), Integer.valueOf(videoTotalTime));
        if (videoTotalTime <= 0 || Math.abs(videoTotalTime - mA) >= 2) {
            this.yTG.yTI.dFZ().yVV.setVideoTotalTime(mA);
        }
        dGB();
        if (mA == 0 || mA >= 1800) {
            C4990ab.m7421w("MicroMsg.Imagegallery.handler.video", "%d repair video duration[%d] error. filename[%s]", Integer.valueOf(hashCode()), Integer.valueOf(mA), this.filename);
        } else {
            C9638aw.m17180RS().mo10302aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(32320);
                    String a = C15663j.this.filename;
                    int i = mA;
                    C26493s ut = C26494u.m42268ut(a);
                    if (ut != null) {
                        int i2 = ut.fXd;
                        if (i2 <= 0 || Math.abs(i2 - i) > 2) {
                            ut.fXd = i;
                            ut.bJt = 4096;
                            C4990ab.m7417i("MicroMsg.VideoLogic", "repair video duration ret %b, duration[%d, %d]", Boolean.valueOf(C26494u.m42253f(ut)), Integer.valueOf(i2), Integer.valueOf(i));
                        }
                    }
                    AppMethodBeat.m2505o(32320);
                }
            });
        }
        mA = C26494u.m42237A(mA, this.filename);
        C4990ab.m7417i("MicroMsg.Imagegallery.handler.video", "notify video prepared. isOnlinePlay[%b] playDuration[%d] playVideoWhenNotify[%b] hadPlayError[%b].", Boolean.valueOf(this.rll), Integer.valueOf(mA), Boolean.valueOf(this.yWL), Boolean.valueOf(this.yWM));
        dFP.dGH().yXp.setOneTimeVideoTextureUpdateCallback(this.rlb);
        if (this.yWL) {
            if (this.rll) {
                C46653m c46653m = this.yWK;
                if (mA > 0) {
                    C4990ab.m7416i("MicroMsg.OnlineVideoUIHelper", "seek to last duration : ".concat(String.valueOf(mA)));
                    c46653m.fUS = mA;
                    c46653m.fUU = true;
                    c46653m.fUP = 2;
                }
                this.yWK.mo74905mm(0);
            } else {
                this.yWK.reset();
                csg();
                mo27899ae(mA, true);
            }
            mo27903cV(false);
            AppMethodBeat.m2505o(32350);
            return;
        }
        if (this.rll) {
            this.yWK.mo74896aG(mA, false);
        } else {
            mo27899ae(mA, false);
        }
        mo27897Pg(mA);
        this.yTG.yTI.mo64299qx(true);
        cse();
        AppMethodBeat.m2505o(32350);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x007e A:{SYNTHETIC, Splitter:B:13:0x007e} */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0072  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void dGA() {
        int i;
        AppMethodBeat.m2504i(32351);
        C4990ab.m7416i("MicroMsg.Imagegallery.handler.video", "notify video completion. isOnlinePlay : " + this.rll);
        cse();
        csh();
        if (!(!this.rll || this.yTG == null || this.yTG.dFP() == null)) {
            C14979e c14979e = this.yTG.dFP().dGH().yXp;
            if (c14979e != null && c14979e.getCurrentPosition() + 2000 < c14979e.getDuration()) {
                C4990ab.m7413e("MicroMsg.Imagegallery.handler.video", "notify video completion, but cur pos[%d] is less than duration[%d]", Integer.valueOf(c14979e.getCurrentPosition()), Integer.valueOf(c14979e.getDuration()));
                i = 0;
                if (i == 0) {
                    C5004al.m7441d(new C1567310());
                    AppMethodBeat.m2505o(32351);
                    return;
                }
                try {
                    C26494u.m42252f(this.filename, this.yTG.dFP().yXp.getCurrentPosition(), this.rll);
                    this.yTG.dFP().yXp.stop();
                    this.yWK.dGL();
                    i = this.yWU + 1;
                    this.yWU = i;
                    if (i <= 3) {
                        C15682a c15682a = (C15682a) this.yVF.get(this.filename);
                        if (c15682a == null || c15682a.csG == null) {
                            AppMethodBeat.m2505o(32351);
                            return;
                        } else {
                            m23951a(c15682a.csG, C15663j.m23963bG(c15682a.csG), c15682a.pos, this.rll);
                        }
                    }
                    AppMethodBeat.m2505o(32351);
                    return;
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.Imagegallery.handler.video", e, "notify video completion error[%s]", e.toString());
                    AppMethodBeat.m2505o(32351);
                    return;
                }
            }
        }
        i = 1;
        if (i == 0) {
        }
    }

    /* renamed from: hp */
    public final void mo27910hp(int i, int i2) {
        boolean z;
        AppMethodBeat.m2504i(32352);
        String str = "MicroMsg.Imagegallery.handler.video";
        String str2 = "notify video error, what %d, extras %d isOnlinePlay %b isLoading %b ";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(this.rll);
        C46653m c46653m = this.yWK;
        if (C5046bo.isNullOrNil(c46653m.cHr) || c46653m.fUO != 1) {
            z = false;
        } else {
            z = true;
        }
        objArr[3] = Boolean.valueOf(z);
        C4990ab.m7413e(str, str2, objArr);
        this.yWM = true;
        this.mqi = i2;
        if (this.rll) {
            if (i == -1) {
                cse();
                this.yTG.dFP().yXp.stop();
                this.yWK.dGL();
            } else if (i == -2) {
                cse();
                C26494u.m42252f(this.filename, this.yTG.dFP().yXp.getCurrentPosition(), this.rll);
                this.yTG.dFP().yXp.stop();
                this.yWK.dGL();
            } else if (i == -3) {
                this.yWM = false;
                this.yWK.dGL();
                AppMethodBeat.m2505o(32352);
                return;
            }
            this.yWW = false;
            this.yTG.yTI.mo64299qx(true);
            this.yTG.dFP().dGH().yXx.setVisibility(0);
            csh();
            C7060h.pYm.mo8378a(354, 18, 1, false);
            AppMethodBeat.m2505o(32352);
            return;
        }
        String str3;
        C26494u.m42271uw(this.filename);
        csh();
        if (this.yTG == null || this.yTG.dFP() == null || this.yTG.dFP().yXp == null) {
            str3 = "";
        } else {
            str3 = this.yTG.dFP().yXp.getVideoPath();
            this.yTG.dFP().yXp.stop();
        }
        if (this.yWN) {
            C4990ab.m7417i("MicroMsg.Imagegallery.handler.video", "%d had play completion don't show error tips", Integer.valueOf(hashCode()));
            AppMethodBeat.m2505o(32352);
            return;
        }
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(32326);
                if (C15663j.this.yTG == null || C15663j.this.yTG.dFP() == null || C15663j.this.yVF == null) {
                    C4990ab.m7420w("MicroMsg.Imagegallery.handler.video", "show error alert but adapter is null.");
                    AppMethodBeat.m2505o(32326);
                    return;
                }
                C15663j.this.yTG.dFP().mo57071a(false, 0.0f);
                if (!C5046bo.isNullOrNil(str3)) {
                    C4990ab.m7413e("MicroMsg.Imagegallery.handler.video", "mediaplay play video error, use third player.[%s]", str3);
                    try {
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        C15429k.m23712a(C15663j.this.yTG.yTI, intent, C5730e.asY(str3), "video/*");
                        C15663j.this.yTG.yTI.startActivity(intent);
                    } catch (Exception e) {
                        C4990ab.m7412e("MicroMsg.Imagegallery.handler.video", "startActivity fail, activity not found");
                        C30379h.m48467g(C15663j.this.yTG.yTI, C25738R.string.bpq, C25738R.string.bpr);
                    }
                }
                C15682a c15682a = (C15682a) C15663j.this.yVF.get(C15663j.this.filename);
                if (c15682a == null || c15682a.csG == null) {
                    AppMethodBeat.m2505o(32326);
                    return;
                }
                C15663j.this.mo27896Pf(c15682a.pos);
                AppMethodBeat.m2505o(32326);
            }
        });
        C7060h.pYm.mo8378a(354, 25, 1, false);
        AppMethodBeat.m2505o(32352);
    }

    private void cse() {
        AppMethodBeat.m2504i(32353);
        C4990ab.m7416i("MicroMsg.Imagegallery.handler.video", "clear timer");
        this.rcg.stopTimer();
        this.klw.stopTimer();
        AppMethodBeat.m2505o(32353);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: cV */
    public final void mo27903cV(boolean z) {
        AppMethodBeat.m2504i(32354);
        if (!this.yWM) {
            if (!this.rll) {
                this.klw.mo16770ae(500, 500);
            } else if (z) {
                C5004al.m7441d(new C1567412());
                AppMethodBeat.m2505o(32354);
                return;
            } else {
                this.rcg.mo16770ae(500, 500);
                AppMethodBeat.m2505o(32354);
                return;
            }
        }
        AppMethodBeat.m2505o(32354);
    }

    /* renamed from: b */
    private void m23957b(int i, C26493s c26493s) {
        AppMethodBeat.m2504i(32355);
        this.yWJ.put(i, c26493s);
        AppMethodBeat.m2505o(32355);
    }

    /* renamed from: Pf */
    public final void mo27896Pf(int i) {
        AppMethodBeat.m2504i(32356);
        this.yWJ.remove(i);
        AppMethodBeat.m2505o(32356);
    }

    /* renamed from: a */
    public final void mo11381a(C9718a c9718a) {
        AppMethodBeat.m2504i(32357);
        String str = c9718a.fileName;
        if (C5046bo.isNullOrNil(str) || this.yVF == null) {
            AppMethodBeat.m2505o(32357);
            return;
        }
        C15682a c15682a = (C15682a) this.yVF.get(str);
        if (c15682a == null) {
            AppMethodBeat.m2505o(32357);
            return;
        }
        C7620bi c7620bi = c15682a.csG;
        if (c7620bi == null || c7620bi.field_imgPath == null || !c7620bi.field_imgPath.equals(str)) {
            AppMethodBeat.m2505o(32357);
            return;
        }
        C26493s bG = C15663j.m23963bG(c7620bi);
        if (bG == null) {
            AppMethodBeat.m2505o(32357);
        } else if (c7620bi.dtH() || bG.status == C27011o.CTRL_INDEX) {
            if (m23960b(c15682a)) {
                Toast.makeText(this.yTG.yTI, C25738R.string.f18, 0).show();
            }
            AppMethodBeat.m2505o(32357);
        } else {
            int g = C26494u.m42255g(bG);
            C36180k OJ = mo39605OJ(c15682a.pos);
            if (this.yTG.yTI.getCurrentItem() == c15682a.pos && OJ != null) {
                this.yTG.yTI.dGm();
                this.yWW = false;
                OJ.dGH().yXq.setVisibility(0);
                OJ.dGH().yXq.setProgress(g);
            } else if (OJ == null) {
                AppMethodBeat.m2505o(32357);
                return;
            }
            if (g < OJ.dGH().yXq.getMax()) {
                AppMethodBeat.m2505o(32357);
                return;
            }
            C4990ab.m7411d("MicroMsg.Imagegallery.handler.video", "onNotifyChange, status:%d", Integer.valueOf(bG.status));
            if ((bG.status == 199 || bG.status == 199) && m23960b(c15682a)) {
                this.yTG.yTI.mo64295hG(true);
                switch (this.yTG.yTI.mo64296np(c7620bi.field_msgId)) {
                    case 0:
                    case 3:
                        m23951a(c7620bi, bG, this.yTG.yTI.getCurrentItem(), false);
                        AppMethodBeat.m2505o(32357);
                        return;
                    case 1:
                        C4990ab.m7410d("MicroMsg.Imagegallery.handler.video", "do restransmit video");
                        C7060h.pYm.mo8378a(354, 15, 1, false);
                        this.yTG.mo64316bv(c7620bi);
                        this.yTG.yTI.mo64297nq(-1);
                        if (this.rll) {
                            C26494u.m42252f(this.filename, this.yTG.dFP().yXp.getCurrentPosition(), this.rll);
                            this.yWR = true;
                        }
                        this.rll = false;
                        AppMethodBeat.m2505o(32357);
                        return;
                    case 2:
                        C7060h.pYm.mo8378a(354, 16, 1, false);
                        C40775c.m70562a(this.yTG.yTI, c7620bi, true);
                        this.yTG.yTI.mo64297nq(-1);
                        if (this.rll) {
                            C26494u.m42252f(this.filename, this.yTG.dFP().yXp.getCurrentPosition(), this.rll);
                            this.yWR = true;
                        }
                        this.rll = false;
                        AppMethodBeat.m2505o(32357);
                        return;
                    default:
                        C4990ab.m7421w("MicroMsg.Imagegallery.handler.video", "enterVideoOpCode[%d] is error", Integer.valueOf(this.yTG.yTI.mo64296np(c7620bi.field_msgId)));
                        break;
                }
            }
            AppMethodBeat.m2505o(32357);
        }
    }

    private void dGB() {
        AppMethodBeat.m2504i(32358);
        try {
            this.yTG.yTI.dFZ().yVV.setIplaySeekCallback(this.vgC);
            AppMethodBeat.m2505o(32358);
        } catch (Exception e) {
            AppMethodBeat.m2505o(32358);
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: bq */
    public final void mo27902bq(final String str, final boolean z) {
        AppMethodBeat.m2504i(32359);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(32319);
                C4990ab.m7417i("MicroMsg.Imagegallery.handler.video", "prepare video filename %s isOnlinePlay %b ", str, Boolean.valueOf(z));
                if (C15663j.this.yVF == null) {
                    C4990ab.m7420w("MicroMsg.Imagegallery.handler.video", "prepare video but cache map is null.");
                    AppMethodBeat.m2505o(32319);
                    return;
                }
                C15682a c15682a = (C15682a) C15663j.this.yVF.get(str);
                if (c15682a == null || c15682a.csG == null) {
                    AppMethodBeat.m2505o(32319);
                    return;
                }
                C26493s bG = C15663j.m23963bG(c15682a.csG);
                if (C15663j.this.yTG.yTI.getCurrentItem() == c15682a.pos) {
                    C15663j.m23952a(C15663j.this, c15682a.csG, bG, c15682a.pos, z);
                    C15663j.this.arz(str);
                    AppMethodBeat.m2505o(32319);
                    return;
                }
                C4990ab.m7421w("MicroMsg.Imagegallery.handler.video", "playVideo, but currentItem is not correct.[%d, %d]", Integer.valueOf(C15663j.this.yTG.yTI.getCurrentItem()), Integer.valueOf(c15682a.pos));
                AppMethodBeat.m2505o(32319);
            }
        });
        AppMethodBeat.m2505o(32359);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: ae */
    public final void mo27899ae(int i, boolean z) {
        AppMethodBeat.m2504i(32360);
        C36180k dFP = this.yTG.dFP();
        if (dFP == null) {
            AppMethodBeat.m2505o(32360);
            return;
        }
        csg();
        dFP.dGH().yXx.setVisibility(8);
        dFP.dGH().yXp.mo27356d((double) (i * 1000), z);
        this.yTG.yTI.mo64299qx(false);
        mo27903cV(false);
        AppMethodBeat.m2505o(32360);
    }

    /* Access modifiers changed, original: protected|final */
    public final void akX() {
        AppMethodBeat.m2504i(32361);
        C36180k dFP = this.yTG.dFP();
        if (dFP == null) {
            AppMethodBeat.m2505o(32361);
            return;
        }
        C4990ab.m7416i("MicroMsg.Imagegallery.handler.video", "start to pause");
        this.yTG.yTI.mo64299qx(true);
        dFP.dGH().yXx.setVisibility(0);
        dFP.dGH().yXp.pause();
        csh();
        AppMethodBeat.m2505o(32361);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean csf() {
        AppMethodBeat.m2504i(32362);
        C36180k dFP = this.yTG.dFP();
        if (dFP == null) {
            AppMethodBeat.m2505o(32362);
            return false;
        }
        boolean z = true;
        if (!dFP.dGH().yXp.isPlaying()) {
            C4990ab.m7416i("MicroMsg.Imagegallery.handler.video", "start to play");
            this.yTG.yTI.mo64299qx(false);
            dFP.dGH().yXx.setVisibility(8);
            z = dFP.dGH().yXp.start();
            csg();
        }
        if (dFP.dGH().yXx.getVisibility() != 8) {
            dFP.dGH().yXx.setVisibility(8);
        }
        AppMethodBeat.m2505o(32362);
        return z;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: Pg */
    public final void mo27897Pg(int i) {
        AppMethodBeat.m2504i(32363);
        this.yTG.yTI.dFZ().yVV.seek(Math.max(0, i));
        AppMethodBeat.m2505o(32363);
    }

    /* Access modifiers changed, original: protected|final */
    public final void arz(String str) {
        AppMethodBeat.m2504i(32364);
        if (!(this.yWW || m23960b((C15682a) this.yVF.get(str)))) {
            C4990ab.m7420w("MicroMsg.Imagegallery.handler.video", "show tool bar error.");
        }
        AppMethodBeat.m2505o(32364);
    }

    private void csg() {
        AppMethodBeat.m2504i(32365);
        this.rlu = C5046bo.anU();
        C4990ab.m7411d("MicroMsg.Imagegallery.handler.video", "notePlayVideo filename %s notePlayVideo %d ", this.filename, Long.valueOf(this.rlu));
        AppMethodBeat.m2505o(32365);
    }

    private void csh() {
        AppMethodBeat.m2504i(32366);
        if (this.rlu > 0) {
            this.rlv = (int) (((long) this.rlv) + ((C5046bo.anU() - this.rlu) / 1000));
        }
        C4990ab.m7417i("MicroMsg.Imagegallery.handler.video", "notePauseVideo filename %s playVideoDuration %d ", this.filename, Integer.valueOf(this.rlv));
        this.rlu = 0;
        AppMethodBeat.m2505o(32366);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getPlayVideoDuration() {
        AppMethodBeat.m2504i(32367);
        if (this.rlv < 0) {
            this.rlv = 0;
        }
        C4990ab.m7417i("MicroMsg.Imagegallery.handler.video", "get[%s] play video duration [%d]", this.filename, Integer.valueOf(this.rlv));
        int i = this.rlv;
        AppMethodBeat.m2505o(32367);
        return i;
    }

    /* Access modifiers changed, original: protected|final */
    public final int getUiStayTime() {
        int i;
        AppMethodBeat.m2504i(32368);
        if (this.rlq <= 0 || this.rlp <= 0) {
            i = 0;
        } else {
            i = (int) (this.rlq - this.rlp);
        }
        if (i < 0) {
            i = 0;
        }
        C4990ab.m7417i("MicroMsg.Imagegallery.handler.video", "%d filename[%s] get ui stay time[%d %d %d]", Integer.valueOf(hashCode()), this.filename, Integer.valueOf(i), Long.valueOf(this.rlq), Long.valueOf(this.rlp));
        AppMethodBeat.m2505o(32368);
        return i;
    }

    /* JADX WARNING: Missing block: B:11:0x0047, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7421w("MicroMsg.Imagegallery.handler.video", "%d rpt rptRepairEffect idKey %d errorTime %d filename %s", java.lang.Integer.valueOf(hashCode()), java.lang.Integer.valueOf(r0), java.lang.Integer.valueOf(r13.yWP), r13.filename);
            com.tencent.p177mm.plugin.report.service.C7060h.pYm.mo8378a(354, (long) r0, 1, false);
            com.tencent.p177mm.plugin.report.service.C7060h.pYm.mo8381e(13836, java.lang.Integer.valueOf(301), java.lang.Long.valueOf(com.tencent.p177mm.sdk.platformtools.C5046bo.anT()), "");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    private boolean m23965c(C36180k c36180k) {
        AppMethodBeat.m2504i(32369);
        int i = this.yWO;
        this.yWO = c36180k.dGH().yXp.getCurrentPosition();
        if (i != this.yWO) {
            this.lastCheckTime = C5046bo.anU();
            long lastSurfaceUpdateTime = c36180k.dGH().yXp.getLastSurfaceUpdateTime();
            if (lastSurfaceUpdateTime <= 0 || lastSurfaceUpdateTime == this.vgx) {
                if (this.yWP != -1) {
                    this.yWP++;
                    C4990ab.m7421w("MicroMsg.Imagegallery.handler.video", "media play is playing[%d], but surface is not update!! repair time[%d]", Integer.valueOf(this.yWP), Integer.valueOf(this.yWQ));
                    if (this.yWQ >= 2) {
                        this.yWK.dGL();
                    }
                    switch (this.yWP) {
                        case 0:
                        case 1:
                            break;
                        case 2:
                            C4990ab.m7421w("MicroMsg.Imagegallery.handler.video", "surface not update, it try seek time[%d] to repair.", Integer.valueOf(this.yWO / 1000));
                            mo27899ae(i, true);
                            this.yWQ++;
                            AppMethodBeat.m2505o(32369);
                            return false;
                        case 3:
                            i = (this.yWO - 2000) / 1000;
                            if (i < 0) {
                                i = 0;
                            }
                            C4990ab.m7421w("MicroMsg.Imagegallery.handler.video", "surface not update, it try seek time[%d] to repair.", Integer.valueOf(i));
                            mo27899ae(i, true);
                            this.yWQ++;
                            AppMethodBeat.m2505o(32369);
                            return false;
                        case 4:
                            i = (this.yWO - 4000) / 1000;
                            if (i < 0) {
                                i = 0;
                            }
                            C4990ab.m7421w("MicroMsg.Imagegallery.handler.video", "surface not update, it try seek time[%d] to repair.", Integer.valueOf(i));
                            mo27899ae(i, true);
                            this.yWQ++;
                            AppMethodBeat.m2505o(32369);
                            return false;
                        default:
                            C4990ab.m7420w("MicroMsg.Imagegallery.handler.video", "rpt surface not update!!");
                            C4990ab.m7421w("MicroMsg.Imagegallery.handler.video", "%d rpt rptSurfaceNotUpdate %s", Integer.valueOf(hashCode()), this.filename);
                            C7060h.pYm.mo8381e(13836, Integer.valueOf(300), Long.valueOf(C5046bo.anT()), "");
                            C7060h.pYm.mo8378a(354, 20, 1, false);
                            this.yWP = -1;
                            break;
                    }
                }
            }
            this.vgx = lastSurfaceUpdateTime;
            switch (this.yWP) {
                case 2:
                    i = 21;
                    break;
                case 3:
                    i = 22;
                    break;
                case 4:
                    i = 23;
                    break;
                default:
                    this.yWP = 0;
                    break;
            }
        }
        C4990ab.m7417i("MicroMsg.Imagegallery.handler.video", "check time[%d, %d], play time[%d, %d]", Long.valueOf(this.lastCheckTime), Long.valueOf(C5046bo.anU()), Integer.valueOf(i), Integer.valueOf(this.yWO));
        if (this.lastCheckTime > 0 && C5046bo.m7566gb(this.lastCheckTime) >= 1500) {
            C4990ab.m7420w("MicroMsg.Imagegallery.handler.video", "play time not update! request all video data to play. ");
            i = this.yTG.dFP().yXp.getCurrentPosition();
            cse();
            C26494u.m42252f(this.filename, i, this.rll);
            this.yTG.dFP().yXp.stop();
            this.yWK.dGL();
            C15682a c15682a = (C15682a) this.yVF.get(this.filename);
            if (c15682a == null || c15682a.csG == null) {
                AppMethodBeat.m2505o(32369);
                return false;
            }
            m23951a(c15682a.csG, C15663j.m23963bG(c15682a.csG), c15682a.pos, this.rll);
            this.lastCheckTime = 0;
            AppMethodBeat.m2505o(32369);
            return false;
        }
        AppMethodBeat.m2505o(32369);
        return true;
    }

    private static void dGC() {
        AppMethodBeat.m2504i(32370);
        C7060h.pYm.mo8378a(354, 11, 1, false);
        AppMethodBeat.m2505o(32370);
    }

    private static void dGD() {
        AppMethodBeat.m2504i(32371);
        C7060h.pYm.mo8378a(354, 14, 1, false);
        AppMethodBeat.m2505o(32371);
    }

    private boolean bwE() {
        AppMethodBeat.m2504i(32372);
        if (this.rll) {
            C9638aw.m17190ZK();
            boolean z = C18628c.m29072Ry().getBoolean(C5127a.USERINFO_VIDEO_NEED_RESET_EXTRACTOR_BOOLEAN, false);
            AppMethodBeat.m2505o(32372);
            return z;
        }
        AppMethodBeat.m2505o(32372);
        return false;
    }
}

package com.tencent.mm.ui.chatting.gallery;

import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import android.view.View;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.g.a.lp;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.d;
import com.tencent.mm.model.n;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.n.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.e.e;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.storage.bi;
import java.util.HashMap;

public final class j extends a implements com.tencent.mm.model.d.a, com.tencent.mm.modelvideo.t.a {
    public static boolean yWS = false;
    private String filename;
    private d iaf;
    private ap klw = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(32329);
            if (j.this.yTG == null) {
                ab.w("MicroMsg.Imagegallery.handler.video", "[onTimerExpired] null == adapter");
                AppMethodBeat.o(32329);
                return false;
            }
            k dFP = j.this.yTG.dFP();
            if (dFP == null) {
                AppMethodBeat.o(32329);
                return false;
            } else if (dFP.yXm == null) {
                AppMethodBeat.o(32329);
                return false;
            } else if (dFP.dGH().yXm.getVisibility() != 0) {
                AppMethodBeat.o(32329);
                return false;
            } else {
                int currentItem = j.this.yTG.yTI.getCurrentItem();
                if (((s) j.this.yWJ.get(currentItem)) == null) {
                    j.this.Pf(currentItem);
                    AppMethodBeat.o(32329);
                    return false;
                } else if (dFP.dGH().yXp.isPlaying()) {
                    j.this.yWO = dFP.dGH().yXp.getCurrentPosition();
                    j.this.Pg(j.this.yWO / 1000);
                    AppMethodBeat.o(32329);
                    return true;
                } else {
                    ab.i("MicroMsg.Imagegallery.handler.video", "it is not playing, stop offline timer");
                    AppMethodBeat.o(32329);
                    return false;
                }
            }
        }
    }, true);
    private long lastCheckTime = 0;
    int mqi = 0;
    private b orK = new b() {
        public final long bOR() {
            AppMethodBeat.i(32322);
            ab.i("MicroMsg.Imagegallery.handler.video", "%d video get online cache sec", Integer.valueOf(j.this.hashCode()));
            aw.ZK();
            c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_VIDEO_NEED_RESET_EXTRACTOR_BOOLEAN, Boolean.TRUE);
            try {
                if (j.this.rll && j.this.yWK != null) {
                    long j = (long) j.this.yWK.fUV;
                    AppMethodBeat.o(32322);
                    return j;
                }
            } catch (Exception e) {
            }
            AppMethodBeat.o(32322);
            return 0;
        }
    };
    private ap rcg = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(32328);
            if (j.this.yWK.isStreaming()) {
                k dFP = j.this.yTG.dFP();
                if (dFP == null) {
                    AppMethodBeat.o(32328);
                    return false;
                } else if (dFP.yXm == null) {
                    AppMethodBeat.o(32328);
                    return false;
                } else if (dFP.dGH().yXm.getVisibility() != 0) {
                    AppMethodBeat.o(32328);
                    return false;
                } else {
                    boolean z = true;
                    if (dFP.dGH().yXp.isPlaying()) {
                        z = j.b(j.this, dFP);
                    }
                    if (z) {
                        boolean mm = j.this.yWK.mm(dFP.dGH().yXp.getCurrentPosition() / 1000);
                        AppMethodBeat.o(32328);
                        return mm;
                    }
                    AppMethodBeat.o(32328);
                    return false;
                }
            }
            AppMethodBeat.o(32328);
            return false;
        }
    }, true);
    private e rlb = new e() {
        public final void bQL() {
            AppMethodBeat.i(32321);
            ab.i("MicroMsg.Imagegallery.handler.video", "%d on texture update.", Integer.valueOf(j.this.hashCode()));
            try {
                j.this.yTG.dFP().a(true, 1.0f);
                AppMethodBeat.o(32321);
            } catch (Exception e) {
                ab.e("MicroMsg.Imagegallery.handler.video", "texture view update. error " + e.toString());
                AppMethodBeat.o(32321);
            }
        }
    };
    private boolean rll;
    private long rlp = 0;
    private long rlq = 0;
    private long rlu;
    private int rlv;
    private com.tencent.mm.plugin.sight.decode.ui.b vgC = new com.tencent.mm.plugin.sight.decode.ui.b() {
        public final void aFw() {
            AppMethodBeat.i(32314);
            if (j.this.yTG.dFP() != null) {
                j.a(j.this, j.this.yTG.dFP());
            }
            j.this.yTG.yTI.yWv.stopTimer();
            AppMethodBeat.o(32314);
        }

        public final void oA(int i) {
            AppMethodBeat.i(32315);
            String str = null;
            try {
                str = j.this.yTG.dFP().dGH().yXp.getVideoPath();
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.Imagegallery.handler.video", e, "", new Object[0]);
                ab.e("MicroMsg.Imagegallery.handler.video", "on seek get video path error: " + e.toString());
            }
            ab.i("MicroMsg.Imagegallery.handler.video", "on seek to time[%d] isOnlinePlay[%b] videoPath[%s]", Integer.valueOf(i), Boolean.valueOf(j.this.rll), str);
            if (bo.isNullOrNil(str)) {
                bi dFO = j.this.yTG.dFO();
                if (dFO != null && dFO.bws()) {
                    u.f(dFO.field_imgPath, i * 1000, j.this.rll);
                }
                j.this.yTG.OP(j.this.yTG.yTI.getCurrentItem());
            } else {
                boolean aG;
                if (j.this.rll) {
                    aG = j.this.yWK.aG(i, true);
                } else {
                    j.this.ae(i, true);
                    aG = true;
                }
                if (aG) {
                    j.this.cV(false);
                }
            }
            j.this.yTG.yTI.dGk();
            AppMethodBeat.o(32315);
        }
    };
    private long vgx = 0;
    private HashMap<String, a> yVF = new HashMap();
    private com.tencent.mm.sdk.b.c yWI;
    final SparseArray<s> yWJ = new SparseArray();
    private m yWK = new m(this);
    private boolean yWL = false;
    private boolean yWM = false;
    private boolean yWN = false;
    private int yWO = 0;
    private int yWP = 0;
    private int yWQ = 0;
    private boolean yWR = false;
    ak yWT = new ak(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ak.a() {
        public final boolean handleMessage(Message message) {
            AppMethodBeat.i(32324);
            if (message.what == 1) {
                k dFP = j.this.yTG.dFP();
                if (!(dFP == null || bo.isNullOrNil(j.this.filename))) {
                    ab.i("MicroMsg.Imagegallery.handler.video", "%d ui on pause, pause video now. %s", Integer.valueOf(hashCode()), j.this.filename);
                    if (!j.this.yWM) {
                        u.f(j.this.filename, dFP.dGH().yXp.getCurrentPosition(), j.this.rll);
                    }
                    j.a(j.this, dFP);
                    j.this.iaf.cy(false);
                    if (j.this.rll) {
                        com.tencent.mm.sdk.b.a.xxA.d(j.this.yWV);
                        j.this.yWK.dGK();
                        j.this.rll = false;
                    }
                }
                j.this.yWL = false;
            }
            AppMethodBeat.o(32324);
            return false;
        }
    });
    private int yWU = 0;
    private com.tencent.mm.sdk.b.c<lp> yWV = new com.tencent.mm.sdk.b.c<lp>() {
        {
            AppMethodBeat.i(32316);
            this.xxI = lp.class.getName().hashCode();
            AppMethodBeat.o(32316);
        }

        private boolean a(lp lpVar) {
            AppMethodBeat.i(32317);
            if (!j.this.yWK.ZA(lpVar.cHq.cHr)) {
                AppMethodBeat.o(32317);
                return false;
            } else if (lpVar.cHq.retCode == 0 || lpVar.cHq.retCode == -21006) {
                String uh;
                int i;
                m f;
                switch (lpVar.cHq.cAd) {
                    case 1:
                        m f2 = j.this.yWK;
                        long j = (long) lpVar.cHq.offset;
                        long j2 = lpVar.cHq.cHs;
                        boolean z = lpVar.cHq.cHt;
                        ab.i("MicroMsg.OnlineVideoUIHelper", "deal moov ready moovPos[%d] needSeekTime[%d] timeDuration[%d] startDownload[%d %d]", Long.valueOf(j), Integer.valueOf(f2.fUS), Integer.valueOf(f2.fUR), Long.valueOf(j2), Long.valueOf(f2.egA));
                        if (f2.fUR != 0) {
                            ab.w("MicroMsg.OnlineVideoUIHelper", "moov had callback, do nothing.");
                        } else {
                            if (j2 <= f2.egA) {
                                j2 = f2.egA;
                            }
                            f2.egA = j2;
                            h.pYm.a(354, 5, 1, false);
                            f2.rlG = bo.anU();
                            o.all();
                            uh = t.uh(f2.filename);
                            try {
                                if (f2.fUQ == null) {
                                    ab.w("MicroMsg.OnlineVideoUIHelper", "parser is null, thread is error.");
                                } else if (f2.fUQ.v(uh, j)) {
                                    f2.fUR = f2.fUQ.gkm;
                                    ab.i("MicroMsg.OnlineVideoUIHelper", "mp4 parse moov success. duration %d filename %s isFastStart %b", Integer.valueOf(f2.fUR), f2.filename, Boolean.valueOf(z));
                                    if (!z) {
                                        al.d(new Runnable() {
                                            public final void run() {
                                                AppMethodBeat.i(32452);
                                                if (m.this.yXX != null) {
                                                    if (m.this.mm(u.A(m.this.fUR, m.this.filename))) {
                                                        if (m.this.rlF == 0 && m.this.rlH == 0) {
                                                            m.this.cso();
                                                        }
                                                        m.this.yXX.bq(m.this.filename, true);
                                                        m.this.fUX = true;
                                                    }
                                                }
                                                AppMethodBeat.o(32452);
                                            }
                                        });
                                    }
                                    if (f2.fUS == -1) {
                                        f2.fUP = 1;
                                    } else {
                                        f2.fUP = 2;
                                    }
                                    h.pYm.a(354, 7, 1, false);
                                } else {
                                    ab.w("MicroMsg.OnlineVideoUIHelper", "mp4 parse moov error.");
                                    o.alm();
                                    com.tencent.mm.al.e.k(f2.cHr, 0, -1);
                                    u.af(f2.filename, 15);
                                    h.pYm.a(354, 8, 1, false);
                                    ab.w("MicroMsg.OnlineVideoUIHelper", "%d rpt parse moov fail %s ", Integer.valueOf(f2.hashCode()), f2.filename);
                                    h.pYm.e(13836, Integer.valueOf(302), Long.valueOf(bo.anT()), "");
                                }
                            } catch (Exception e) {
                                ab.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", e, "", new Object[0]);
                                ab.e("MicroMsg.OnlineVideoUIHelper", "deal moov ready error: " + e.toString());
                            }
                        }
                        j.this.rll = true;
                        break;
                    case 2:
                        m f3 = j.this.yWK;
                        uh = lpVar.cHq.cHr;
                        i = lpVar.cHq.offset;
                        int i2 = lpVar.cHq.length;
                        f3.fUY = false;
                        if (i < 0 || i2 < 0) {
                            ab.w("MicroMsg.OnlineVideoUIHelper", "deal data available error offset[%d], length[%d]", Integer.valueOf(i), Integer.valueOf(i2));
                        } else if (f3.ZA(uh)) {
                            Integer num = (Integer) f3.rlC.get(f3.cHr + i + "_" + i2);
                            if (num == null || num.intValue() <= 0) {
                                try {
                                    f3.fUV = f3.fUQ.cK(i, i2);
                                } catch (Exception e2) {
                                    ab.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", e2, "", new Object[0]);
                                    ab.e("MicroMsg.OnlineVideoUIHelper", "deal data available file pos to video time error: " + e2.toString());
                                }
                            } else {
                                f3.fUV = num.intValue();
                            }
                            ab.i("MicroMsg.OnlineVideoUIHelper", "deal data available. offset[%d] length[%d] cachePlayTime[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(f3.fUV));
                        }
                        if (lpVar.cHq.length > 0) {
                            j.this.cV(true);
                            break;
                        }
                        break;
                    case 3:
                        j.this.cV(true);
                        break;
                    case 4:
                        f = j.this.yWK;
                        ab.i("MicroMsg.OnlineVideoUIHelper", "deal stream finish. playStatus %d ", Integer.valueOf(f.fUP));
                        f.fUY = false;
                        f.fUO = 3;
                        if (f.fUP == 0) {
                            ab.w("MicroMsg.OnlineVideoUIHelper", "it had not moov callback and download finish start to play video.");
                            f.csl();
                            h.pYm.a(354, 6, 1, false);
                        } else if (f.fUP == 5) {
                            ab.w("MicroMsg.OnlineVideoUIHelper", "it had play error, it request all video data finish, start to play." + f.cHr);
                            f.csl();
                        }
                        f.dGM();
                        h.pYm.a(354, 26, 1, false);
                        j.this.cV(true);
                        break;
                    case 5:
                        f = j.this.yWK;
                        String str = lpVar.cHq.cHr;
                        i = lpVar.cHq.offset;
                        if (f.ZA(str)) {
                            f.rlE = (i * 100) / f.gUm;
                            ab.i("MicroMsg.OnlineVideoUIHelper", "deal progress callback. downloadedPercent : " + f.rlE);
                        }
                        if (f.rlE >= 100) {
                            f.fUO = 3;
                            break;
                        }
                        break;
                    case 6:
                        f = j.this.yWK;
                        ab.i("MicroMsg.OnlineVideoUIHelper", "deal had dup video.");
                        f.dGM();
                        f.csl();
                        break;
                    default:
                        ab.w("MicroMsg.Imagegallery.handler.video", "unknown event opcode " + lpVar.cHq.cAd);
                        break;
                }
                AppMethodBeat.o(32317);
                return false;
            } else {
                ab.w("MicroMsg.Imagegallery.handler.video", "stream download online video error. retCode: " + lpVar.cHq.retCode);
                j.a(j.this, lpVar.cHq.cHr, lpVar.cHq.retCode);
                AppMethodBeat.o(32317);
                return false;
            }
        }
    };
    private boolean yWW = false;
    private int yWX = 0;
    private int[] yWY = new int[]{-1000, -2000, 3400};

    public static class a {
        public bi csG;
        public int pos;

        public a(bi biVar, int i) {
            this.csG = biVar;
            this.pos = i;
        }
    }

    static /* synthetic */ void a(j jVar, bi biVar, s sVar, int i, boolean z) {
        AppMethodBeat.i(32377);
        jVar.a(biVar, sVar, i, z);
        AppMethodBeat.o(32377);
    }

    static /* synthetic */ void j(j jVar) {
        AppMethodBeat.i(32374);
        jVar.csh();
        AppMethodBeat.o(32374);
    }

    public j(c cVar) {
        super(cVar);
        AppMethodBeat.i(32335);
        com.tencent.mm.sdk.b.a aVar = com.tencent.mm.sdk.b.a.xxA;
        com.tencent.mm.ui.chatting.al alVar = new com.tencent.mm.ui.chatting.al(com.tencent.mm.ui.chatting.al.a.VIDEO_GALLERY, cVar.yTI);
        this.yWI = alVar;
        aVar.c(alVar);
        com.tencent.mm.sdk.b.a.xxA.c(this.yWV);
        this.iaf = new d();
        AppMethodBeat.o(32335);
    }

    public final boolean a(k kVar, bi biVar, int i) {
        AppMethodBeat.i(32336);
        super.a(kVar, biVar, i);
        s bG = bG(biVar);
        if (biVar == null) {
            ab.e("MicroMsg.Imagegallery.handler.video", "msg is null!!");
            AppMethodBeat.o(32336);
            return false;
        }
        if (this.yVF != null) {
            this.yVF.put(biVar.field_imgPath, new a(biVar, i));
        } else {
            ab.e("MicroMsg.Imagegallery.handler.video", "mCacheMap is null!");
        }
        if (bG == null) {
            AppMethodBeat.o(32336);
            return false;
        }
        o.all();
        kVar.dGH().yXn.setImageBitmap(BackwardSupportUtil.b.i(t.ui(biVar.field_imgPath), 1.0f));
        if (kVar.dGH().yXp.isPlaying()) {
            kVar.dGH().yXp.stop();
        }
        kVar.yXr.setVisibility(8);
        kVar.dGH().yXq.setVisibility(8);
        kVar.dGH().yXx.setVisibility(8);
        kVar.a(false, 0.0f);
        this.yWP = 0;
        this.rlp = bo.anU();
        AppMethodBeat.o(32336);
        return true;
    }

    public static s bG(bi biVar) {
        AppMethodBeat.i(32337);
        if (c.f(biVar)) {
            s ut = u.ut(biVar.field_imgPath);
            AppMethodBeat.o(32337);
            return ut;
        }
        AppMethodBeat.o(32337);
        return null;
    }

    public final void pause(int i) {
        AppMethodBeat.i(32338);
        b(OJ(i));
        this.iaf.cy(false);
        this.yTG.yTI.qx(true);
        AppMethodBeat.o(32338);
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i(bi biVar, int i) {
        AppMethodBeat.i(32339);
        ab.i("MicroMsg.Imagegallery.handler.video", "toggle video");
        if (biVar == null) {
            AppMethodBeat.o(32339);
        } else if (c.f(biVar) || c.bp(biVar)) {
            s bG = bG(biVar);
            if (bG == null) {
                AppMethodBeat.o(32339);
            } else if (this.rll && this.yWK != null && this.yWK.fUU) {
                ab.i("MicroMsg.Imagegallery.handler.video", "%d it loading video data, do not response button click.", Integer.valueOf(hashCode()));
                AppMethodBeat.o(32339);
            } else if (this.yTG.yTI.cGZ()) {
                b(OJ(i));
                this.yTG.yTI.qx(true);
                this.yTG.yTI.yWv.stopTimer();
                this.iaf.cy(false);
                ab.i("MicroMsg.Imagegallery.handler.video", "toggle pause video.");
                AppMethodBeat.o(32339);
            } else {
                aw.ZK();
                if (c.isSDCardAvailable()) {
                    int currentPosition;
                    if (this.rll) {
                        try {
                            if (this.yTG.dFP().yXp != null) {
                                currentPosition = this.yTG.dFP().yXp.getCurrentPosition() / 1000;
                                if (this.yWK != null) {
                                    ab.w("MicroMsg.Imagegallery.handler.video", "%d toggle video but online video helper is null.", Integer.valueOf(hashCode()));
                                } else if (this.yWK.mn(currentPosition)) {
                                    ab.i("MicroMsg.Imagegallery.handler.video", "toggle play video");
                                    a(biVar, bG, i, this.rll);
                                } else {
                                    ab.i("MicroMsg.Imagegallery.handler.video", "toggle start timer.");
                                    cV(false);
                                }
                            }
                        } catch (Exception e) {
                            ab.printErrStackTrace("MicroMsg.Imagegallery.handler.video", e, "", new Object[0]);
                        }
                        currentPosition = 0;
                        if (this.yWK != null) {
                        }
                    } else {
                        if (biVar.field_isSend == 0) {
                            if (bG.status == 113 || bG.status == com.tencent.mm.plugin.appbrand.jsapi.k.o.CTRL_INDEX) {
                                a(biVar, bG);
                            } else {
                                if (bG.status == 199) {
                                    a(biVar, bG, i, false);
                                }
                                if (bG.status == 111) {
                                    a(biVar, bG);
                                }
                                if (bG.status == 112) {
                                    a(biVar, bG);
                                }
                                if (bG.status == 121 || bG.status == 122) {
                                    a(biVar, bG);
                                }
                                if (bG.status == 123) {
                                    a(biVar, bG, i, false);
                                }
                            }
                        }
                        if (biVar.field_isSend == 1) {
                            currentPosition = bG.status;
                            if (currentPosition == 111 || currentPosition == 113 || currentPosition == 112 || currentPosition == 121 || currentPosition == 122) {
                                ab.i("MicroMsg.Imagegallery.handler.video", "download video. msg talker[%s], info status[%d]", biVar.field_talker, Integer.valueOf(currentPosition));
                                a(biVar, bG);
                            } else {
                                a(biVar, bG, i, false);
                            }
                        }
                    }
                    if (this.yTG.yTI.yWu) {
                        this.yTG.yTI.dGk();
                    }
                    dGB();
                    AppMethodBeat.o(32339);
                    return;
                }
                com.tencent.mm.ui.base.t.hO(this.yTG.yTI.mController.ylL);
                AppMethodBeat.o(32339);
            }
        } else {
            AppMethodBeat.o(32339);
        }
    }

    public final void j(bi biVar, int i) {
        AppMethodBeat.i(32340);
        ab.i("MicroMsg.Imagegallery.handler.video", "toggleVideoMenu pos ");
        s ut = u.ut(biVar.field_imgPath);
        if (!(ut == null || ut.alz())) {
            b(OJ(i));
            this.yTG.yTI.qx(true);
            if (this.rll) {
                this.yWK.dGK();
                this.yWK.reset();
            }
            a(biVar, ut);
            if (this.yTG.yTI.np(biVar.field_msgId) == 2) {
                eC(biVar.field_imgPath, 8);
                AppMethodBeat.o(32340);
                return;
            }
            eC(biVar.field_imgPath, 5);
        }
        AppMethodBeat.o(32340);
    }

    private void a(bi biVar, s sVar, int i, boolean z) {
        AppMethodBeat.i(32341);
        if (biVar == null || sVar == null) {
            AppMethodBeat.o(32341);
        } else if (biVar.dtH()) {
            Toast.makeText(this.yTG.yTI, R.string.f18, 0).show();
            AppMethodBeat.o(32341);
        } else {
            String uh;
            String alv;
            if (sVar.fXk == -1) {
                alv = sVar.alv();
                if (!com.tencent.mm.vfs.e.ct(alv)) {
                    o.all();
                    uh = t.uh(biVar.field_imgPath);
                }
                uh = alv;
            } else {
                o.all();
                alv = t.uh(biVar.field_imgPath);
                if (biVar.field_isSend == 1 && sVar.fXn != null && sVar.fXn.wDP) {
                    try {
                        String atb = com.tencent.mm.vfs.e.atb(alv);
                        if (!atb.endsWith("/")) {
                            atb = atb + "/";
                        }
                        atb = atb + com.tencent.mm.vfs.e.atd(alv) + "_hd.mp4";
                        ab.i("MicroMsg.Imagegallery.handler.video", "local capture video, hdFilePath: %s, exist: %s", atb, Boolean.valueOf(com.tencent.mm.vfs.e.ct(atb)));
                        if (!com.tencent.mm.vfs.e.ct(atb)) {
                            atb = alv;
                        }
                        uh = atb;
                    } catch (Exception e) {
                        ab.e("MicroMsg.Imagegallery.handler.video", "try to get hd filePath error: %s", e.getMessage());
                    }
                }
                uh = alv;
            }
            if (uh == null || !com.tencent.mm.vfs.e.ct(uh)) {
                Toast.makeText(this.yTG.yTI, R.string.f18, 0).show();
                AppMethodBeat.o(32341);
                return;
            }
            k OJ = OJ(i);
            if (OJ == null) {
                AppMethodBeat.o(32341);
                return;
            }
            int i2 = 0;
            if (com.tencent.mm.model.t.kH(sVar.getUser())) {
                i2 = n.mA(sVar.getUser());
            }
            boolean ua = r.ua(uh);
            ab.i("MicroMsg.Imagegallery.handler.video", "play video pos[%d], isOnlinePlay[%b] opcode[%d] resetByCompletion[%b]", Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(this.yTG.yTI.np(biVar.field_msgId)), Boolean.valueOf(this.yWR));
            if (ua) {
                h.pYm.e(12084, Integer.valueOf(sVar.frO), Integer.valueOf(sVar.fXd * 1000), Integer.valueOf(0), Integer.valueOf(3), sVar.getUser(), Integer.valueOf(i2), s.ue(sVar.alw()), Long.valueOf(sVar.createTime));
                if (!com.tencent.mm.pluginsdk.h.b.a.a.c(uh, this.yTG.yTI.mController.ylL, ua)) {
                    Toast.makeText(this.yTG.yTI.mController.ylL, this.yTG.yTI.getString(R.string.f1k), 0).show();
                }
            } else if (q.etn.esh == 1 && com.tencent.mm.pluginsdk.h.b.a.a.b(sVar.getFileName(), this.yTG.yTI.mController.ylL, ua)) {
                AppMethodBeat.o(32341);
                return;
            } else {
                aw.ZK();
                if (((Integer) c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_LOCAL_SIGHT_DEBUGINFO_INT_SYNC, Integer.valueOf(0))).intValue() == 1 && OJ.yXr != null) {
                    OJ.yXr.setVisibility(0);
                    OJ.yXr.setText(com.tencent.mm.plugin.sight.base.d.RK(uh));
                }
                OJ.a(sVar.fXd, sVar.frO, i2, sVar.getUser(), s.ue(sVar.alw()), sVar.createTime);
                this.rll = z;
                this.yWL = true;
                this.filename = sVar.getFileName();
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
                    OJ.a(true, 0.0f);
                } else {
                    OJ.a(true, 1.0f);
                    OJ.dGH().yXp.start();
                    csg();
                    if (!z) {
                        arz(this.filename);
                    }
                    Pg(OJ.dGH().yXp.getCurrentPosition() / 1000);
                    cV(false);
                }
                b(i, sVar);
                this.yTG.yTI.qx(false);
                this.yTG.yTI.mController.ylL.getWindow().addFlags(128);
                if (com.tencent.mm.compatible.util.d.fP(18)) {
                    arz(this.filename);
                }
                this.iaf.a(this);
            }
            OJ.dGH().yXq.setVisibility(8);
            AppMethodBeat.o(32341);
        }
    }

    private void a(bi biVar, s sVar) {
        AppMethodBeat.i(32342);
        if (!(com.tencent.mm.network.ab.ch(this.yTG.yTI.mController.ylL) || yWS)) {
            yWS = true;
        }
        b(biVar, sVar);
        AppMethodBeat.o(32342);
    }

    private void b(bi biVar, s sVar) {
        AppMethodBeat.i(32343);
        ab.i("MicroMsg.Imagegallery.handler.video", "startDownloading [%d]", Integer.valueOf(hashCode()));
        if (biVar == null || sVar == null) {
            AppMethodBeat.o(32343);
            return;
        }
        k dFP = this.yTG.dFP();
        if (dFP == null) {
            AppMethodBeat.o(32343);
            return;
        }
        y.C(biVar);
        int np = this.yTG.yTI.np(biVar.field_msgId);
        ab.d("MicroMsg.Imagegallery.handler.video", "enterVideoOpCode : ".concat(String.valueOf(np)));
        switch (np) {
            case 0:
                break;
            case 1:
            case 2:
                if (sVar.aly()) {
                    ab.i("MicroMsg.Imagegallery.handler.video", "start complete online video");
                    u.uA(biVar.field_imgPath);
                } else {
                    ab.i("MicroMsg.Imagegallery.handler.video", "start complete offline video");
                    eC(biVar.field_imgPath, 10);
                    u.up(biVar.field_imgPath);
                }
                o.all().a(this, Looper.getMainLooper());
                this.yTG.yTI.dGm();
                this.yWW = false;
                dFP.dGH().yXo.setVisibility(8);
                dFP.dGH().yXq.setVisibility(0);
                dFP.dGH().yXq.setProgress(u.g(sVar));
                if (np == 2) {
                    dGD();
                    AppMethodBeat.o(32343);
                    return;
                }
                dGC();
                AppMethodBeat.o(32343);
                return;
            case 3:
                ab.i("MicroMsg.Imagegallery.handler.video", "%d mute play video [%d]", Integer.valueOf(hashCode()), Integer.valueOf(np));
                break;
            default:
                ab.w("MicroMsg.Imagegallery.handler.video", "enterVideoOpCode[%d] is error", Integer.valueOf(np));
                AppMethodBeat.o(32343);
                return;
        }
        if (this.yWK.arA(biVar.field_imgPath)) {
            ab.i("MicroMsg.Imagegallery.handler.video", "start online play video.");
            this.rll = true;
            o.all().a(this);
            this.yTG.yTI.dGm();
            this.yWW = false;
            dFP.dGH().yXo.setVisibility(8);
            dFP.dGH().yXq.setVisibility(8);
            dFP.dGH().yXx.setVisibility(0);
            AppMethodBeat.o(32343);
            return;
        }
        ab.i("MicroMsg.Imagegallery.handler.video", "start offline play video.");
        this.rll = false;
        o.all().a(this, Looper.getMainLooper());
        u.up(biVar.field_imgPath);
        this.yTG.yTI.dGm();
        this.yWW = false;
        dFP.dGH().yXo.setVisibility(8);
        dFP.dGH().yXq.setVisibility(0);
        dFP.dGH().yXq.setProgress(u.g(sVar));
        AppMethodBeat.o(32343);
    }

    private void eC(final String str, final int i) {
        AppMethodBeat.i(32344);
        aw.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(32313);
                u.ag(str, i);
                AppMethodBeat.o(32313);
            }
        });
        AppMethodBeat.o(32344);
    }

    private boolean b(a aVar) {
        AppMethodBeat.i(32345);
        if (aVar == null) {
            AppMethodBeat.o(32345);
            return false;
        }
        o.all().a(this);
        if (this.yTG.yTI.getCurrentItem() == aVar.pos) {
            k OJ = OJ(aVar.pos);
            if (OJ != null) {
                OJ.dGH().yXx.setVisibility(8);
                OJ.dGH().yXq.setVisibility(8);
                OJ.dGH().yXo.setVisibility(8);
            }
            this.yWW = true;
            this.yTG.yTI.dGl();
            AppMethodBeat.o(32345);
            return true;
        }
        this.yTG.OR(aVar.pos);
        AppMethodBeat.o(32345);
        return false;
    }

    public final void Du() {
        AppMethodBeat.i(32346);
        ab.i("MicroMsg.Imagegallery.handler.video", "stopAll. video handler hash code : " + hashCode());
        this.rlq = bo.anU();
        SparseArray sparseArray = this.yTG.yyL;
        int i = 0;
        int i2 = 0;
        while (i < sparseArray.size()) {
            int keyAt = sparseArray.keyAt(i);
            if (!(sparseArray.get(keyAt) == null || ((View) sparseArray.get(keyAt)).getTag() == null)) {
                k kVar = (k) ((View) sparseArray.get(keyAt)).getTag();
                if (kVar.yXm != null && kVar.dGH().yXm.getVisibility() == 0 && (((View) kVar.dGH().yXp).getVisibility() == 0 || !bo.isNullOrNil(kVar.dGH().yXp.getVideoPath()) || (this.rll && this.yWK.isStreaming()))) {
                    ab.i("MicroMsg.Imagegallery.handler.video", "stop");
                    cse();
                    if (kVar != null) {
                        csh();
                        if (this.rll) {
                            this.yWK.dGK();
                        }
                        if (!this.yWM) {
                            u.f(this.filename, this.yWO - 1000, this.rll);
                        }
                        kVar.dGH().yXq.setVisibility(8);
                        kVar.dGH().yXx.setVisibility(8);
                        kVar.dGH().yXp.stop();
                        Pg(0);
                        kVar.a(false, 0.0f);
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
        this.iaf.cy(false);
        if (i2 == 0 && this.rll) {
            this.yWK.dGK();
            this.rll = false;
        }
        cse();
        this.yWJ.clear();
        AppMethodBeat.o(32346);
    }

    private void b(k kVar) {
        AppMethodBeat.i(32347);
        if (kVar == null) {
            AppMethodBeat.o(32347);
            return;
        }
        cse();
        ab.d("MicroMsg.Imagegallery.handler.video", "pause video.");
        if (kVar.dGH().yXp.isPlaying()) {
            kVar.dGH().yXp.pause();
            csh();
        }
        AppMethodBeat.o(32347);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onResume() {
        AppMethodBeat.i(32348);
        ab.i("MicroMsg.Imagegallery.handler.video", "ui on resume, add online video event.");
        this.yWT.removeMessages(1);
        com.tencent.mm.sdk.b.a.xxA.c(this.yWV);
        if (this.yTG != null && com.tencent.mm.compatible.util.d.iW(21)) {
            k dFP = this.yTG.dFP();
            if (!(dFP == null || dFP.yXp == null)) {
                if (dFP.yXp instanceof VideoPlayerTextureView) {
                    ((VideoPlayerTextureView) dFP.yXp).bPd();
                    AppMethodBeat.o(32348);
                    return;
                } else if (dFP.yXp instanceof VideoTextureView) {
                    ((VideoTextureView) dFP.yXp).bPd();
                }
            }
        }
        AppMethodBeat.o(32348);
    }

    public final void detach() {
        AppMethodBeat.i(32349);
        ab.i("MicroMsg.Imagegallery.handler.video", "detach.[%d]", Integer.valueOf(hashCode()));
        this.rlq = bo.anU();
        this.yWT.removeMessages(1);
        cse();
        com.tencent.mm.sdk.b.a.xxA.d(this.yWI);
        com.tencent.mm.sdk.b.a.xxA.d(this.yWV);
        Du();
        this.yTG.yTI.mController.ylL.getWindow().clearFlags(128);
        this.yTG.yTI.dFZ().yVV.setIplaySeekCallback(null);
        super.detach();
        this.yVF.clear();
        this.yVF = null;
        o.all().a(this);
        this.yWJ.clear();
        m mVar = this.yWK;
        mVar.reset();
        mVar.fUQ = null;
        mVar.yXX = null;
        mVar.yXY = null;
        if (com.tencent.mm.plugin.n.e.bOT()) {
            aw.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(32323);
                    String bOU = com.tencent.mm.plugin.n.e.bOU();
                    if (bo.isNullOrNil(bOU)) {
                        h.pYm.X(14092, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        AppMethodBeat.o(32323);
                        return;
                    }
                    h.pYm.X(14092, bOU);
                    AppMethodBeat.o(32323);
                }
            });
        }
        o.alq().alG();
        o.alq().run();
        AppMethodBeat.o(32349);
    }

    public final void dGz() {
        AppMethodBeat.i(32350);
        this.yWM = false;
        this.mqi = 0;
        k dFP = this.yTG != null ? this.yTG.dFP() : null;
        if (dFP == null) {
            ab.w("MicroMsg.Imagegallery.handler.video", "notify video prepared, but holder is null.");
            AppMethodBeat.o(32350);
            return;
        }
        final int mA = bo.mA((long) dFP.dGH().yXp.getDuration());
        int videoTotalTime = this.yTG.yTI.dFZ().yVV.getVideoTotalTime();
        ab.i("MicroMsg.Imagegallery.handler.video", "%d videoDuration %d hadSetTotalTime %d", Integer.valueOf(hashCode()), Integer.valueOf(mA), Integer.valueOf(videoTotalTime));
        if (videoTotalTime <= 0 || Math.abs(videoTotalTime - mA) >= 2) {
            this.yTG.yTI.dFZ().yVV.setVideoTotalTime(mA);
        }
        dGB();
        if (mA == 0 || mA >= 1800) {
            ab.w("MicroMsg.Imagegallery.handler.video", "%d repair video duration[%d] error. filename[%s]", Integer.valueOf(hashCode()), Integer.valueOf(mA), this.filename);
        } else {
            aw.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(32320);
                    String a = j.this.filename;
                    int i = mA;
                    s ut = u.ut(a);
                    if (ut != null) {
                        int i2 = ut.fXd;
                        if (i2 <= 0 || Math.abs(i2 - i) > 2) {
                            ut.fXd = i;
                            ut.bJt = 4096;
                            ab.i("MicroMsg.VideoLogic", "repair video duration ret %b, duration[%d, %d]", Boolean.valueOf(u.f(ut)), Integer.valueOf(i2), Integer.valueOf(i));
                        }
                    }
                    AppMethodBeat.o(32320);
                }
            });
        }
        mA = u.A(mA, this.filename);
        ab.i("MicroMsg.Imagegallery.handler.video", "notify video prepared. isOnlinePlay[%b] playDuration[%d] playVideoWhenNotify[%b] hadPlayError[%b].", Boolean.valueOf(this.rll), Integer.valueOf(mA), Boolean.valueOf(this.yWL), Boolean.valueOf(this.yWM));
        dFP.dGH().yXp.setOneTimeVideoTextureUpdateCallback(this.rlb);
        if (this.yWL) {
            if (this.rll) {
                m mVar = this.yWK;
                if (mA > 0) {
                    ab.i("MicroMsg.OnlineVideoUIHelper", "seek to last duration : ".concat(String.valueOf(mA)));
                    mVar.fUS = mA;
                    mVar.fUU = true;
                    mVar.fUP = 2;
                }
                this.yWK.mm(0);
            } else {
                this.yWK.reset();
                csg();
                ae(mA, true);
            }
            cV(false);
            AppMethodBeat.o(32350);
            return;
        }
        if (this.rll) {
            this.yWK.aG(mA, false);
        } else {
            ae(mA, false);
        }
        Pg(mA);
        this.yTG.yTI.qx(true);
        cse();
        AppMethodBeat.o(32350);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x007e A:{SYNTHETIC, Splitter:B:13:0x007e} */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0072  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void dGA() {
        int i;
        AppMethodBeat.i(32351);
        ab.i("MicroMsg.Imagegallery.handler.video", "notify video completion. isOnlinePlay : " + this.rll);
        cse();
        csh();
        if (!(!this.rll || this.yTG == null || this.yTG.dFP() == null)) {
            com.tencent.mm.pluginsdk.ui.tools.e eVar = this.yTG.dFP().dGH().yXp;
            if (eVar != null && eVar.getCurrentPosition() + 2000 < eVar.getDuration()) {
                ab.e("MicroMsg.Imagegallery.handler.video", "notify video completion, but cur pos[%d] is less than duration[%d]", Integer.valueOf(eVar.getCurrentPosition()), Integer.valueOf(eVar.getDuration()));
                i = 0;
                if (i == 0) {
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(32325);
                            j.this.yWN = true;
                            j.this.lastCheckTime = j.this.vgx = 0;
                            j.this.iaf.cy(false);
                            j.j(j.this);
                            if (j.this.rll) {
                                j.this.rlq = bo.anU();
                                j.this.yWK.dGK();
                                j.this.yWK.reset();
                                j.this.rll = false;
                                j.this.yWW = false;
                            }
                            u.f(j.this.filename, 0, j.this.rll);
                            if (j.this.yVF != null) {
                                a aVar = (a) j.this.yVF.get(j.this.filename);
                                if (aVar != null) {
                                    k dFP = j.this.yTG.dFP();
                                    dFP.dGH().yXp.stop();
                                    j.this.yWO = 0;
                                    j.this.a(dFP, aVar.csG, aVar.pos);
                                    j.this.Pg(0);
                                    if (dFP.dGH().yXx.getVisibility() != 8) {
                                        dFP.dGH().yXx.setVisibility(8);
                                    }
                                }
                            }
                            AppMethodBeat.o(32325);
                        }
                    });
                    AppMethodBeat.o(32351);
                    return;
                }
                try {
                    u.f(this.filename, this.yTG.dFP().yXp.getCurrentPosition(), this.rll);
                    this.yTG.dFP().yXp.stop();
                    this.yWK.dGL();
                    i = this.yWU + 1;
                    this.yWU = i;
                    if (i <= 3) {
                        a aVar = (a) this.yVF.get(this.filename);
                        if (aVar == null || aVar.csG == null) {
                            AppMethodBeat.o(32351);
                            return;
                        } else {
                            a(aVar.csG, bG(aVar.csG), aVar.pos, this.rll);
                        }
                    }
                    AppMethodBeat.o(32351);
                    return;
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.Imagegallery.handler.video", e, "notify video completion error[%s]", e.toString());
                    AppMethodBeat.o(32351);
                    return;
                }
            }
        }
        i = 1;
        if (i == 0) {
        }
    }

    public final void hp(int i, int i2) {
        boolean z;
        AppMethodBeat.i(32352);
        String str = "MicroMsg.Imagegallery.handler.video";
        String str2 = "notify video error, what %d, extras %d isOnlinePlay %b isLoading %b ";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(this.rll);
        m mVar = this.yWK;
        if (bo.isNullOrNil(mVar.cHr) || mVar.fUO != 1) {
            z = false;
        } else {
            z = true;
        }
        objArr[3] = Boolean.valueOf(z);
        ab.e(str, str2, objArr);
        this.yWM = true;
        this.mqi = i2;
        if (this.rll) {
            if (i == -1) {
                cse();
                this.yTG.dFP().yXp.stop();
                this.yWK.dGL();
            } else if (i == -2) {
                cse();
                u.f(this.filename, this.yTG.dFP().yXp.getCurrentPosition(), this.rll);
                this.yTG.dFP().yXp.stop();
                this.yWK.dGL();
            } else if (i == -3) {
                this.yWM = false;
                this.yWK.dGL();
                AppMethodBeat.o(32352);
                return;
            }
            this.yWW = false;
            this.yTG.yTI.qx(true);
            this.yTG.dFP().dGH().yXx.setVisibility(0);
            csh();
            h.pYm.a(354, 18, 1, false);
            AppMethodBeat.o(32352);
            return;
        }
        String str3;
        u.uw(this.filename);
        csh();
        if (this.yTG == null || this.yTG.dFP() == null || this.yTG.dFP().yXp == null) {
            str3 = "";
        } else {
            str3 = this.yTG.dFP().yXp.getVideoPath();
            this.yTG.dFP().yXp.stop();
        }
        if (this.yWN) {
            ab.i("MicroMsg.Imagegallery.handler.video", "%d had play completion don't show error tips", Integer.valueOf(hashCode()));
            AppMethodBeat.o(32352);
            return;
        }
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(32326);
                if (j.this.yTG == null || j.this.yTG.dFP() == null || j.this.yVF == null) {
                    ab.w("MicroMsg.Imagegallery.handler.video", "show error alert but adapter is null.");
                    AppMethodBeat.o(32326);
                    return;
                }
                j.this.yTG.dFP().a(false, 0.0f);
                if (!bo.isNullOrNil(str3)) {
                    ab.e("MicroMsg.Imagegallery.handler.video", "mediaplay play video error, use third player.[%s]", str3);
                    try {
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        k.a(j.this.yTG.yTI, intent, com.tencent.mm.vfs.e.asY(str3), "video/*");
                        j.this.yTG.yTI.startActivity(intent);
                    } catch (Exception e) {
                        ab.e("MicroMsg.Imagegallery.handler.video", "startActivity fail, activity not found");
                        com.tencent.mm.ui.base.h.g(j.this.yTG.yTI, R.string.bpq, R.string.bpr);
                    }
                }
                a aVar = (a) j.this.yVF.get(j.this.filename);
                if (aVar == null || aVar.csG == null) {
                    AppMethodBeat.o(32326);
                    return;
                }
                j.this.Pf(aVar.pos);
                AppMethodBeat.o(32326);
            }
        });
        h.pYm.a(354, 25, 1, false);
        AppMethodBeat.o(32352);
    }

    private void cse() {
        AppMethodBeat.i(32353);
        ab.i("MicroMsg.Imagegallery.handler.video", "clear timer");
        this.rcg.stopTimer();
        this.klw.stopTimer();
        AppMethodBeat.o(32353);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cV(boolean z) {
        AppMethodBeat.i(32354);
        if (!this.yWM) {
            if (!this.rll) {
                this.klw.ae(500, 500);
            } else if (z) {
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(32327);
                        try {
                            int A;
                            if (bo.isNullOrNil(j.this.yTG.dFP().dGH().yXp.getVideoPath())) {
                                A = u.A(j.this.yWK.fUR, j.this.filename);
                            } else {
                                A = j.this.yTG.dFP().dGH().yXp.getCurrentPosition() / 1000;
                            }
                            j.this.yWK.mm(A);
                        } catch (Exception e) {
                            ab.printErrStackTrace("MicroMsg.Imagegallery.handler.video", e, "start timer error[%s]", e.toString());
                        }
                        j.this.rcg.ae(500, 500);
                        AppMethodBeat.o(32327);
                    }
                });
                AppMethodBeat.o(32354);
                return;
            } else {
                this.rcg.ae(500, 500);
                AppMethodBeat.o(32354);
                return;
            }
        }
        AppMethodBeat.o(32354);
    }

    private void b(int i, s sVar) {
        AppMethodBeat.i(32355);
        this.yWJ.put(i, sVar);
        AppMethodBeat.o(32355);
    }

    public final void Pf(int i) {
        AppMethodBeat.i(32356);
        this.yWJ.remove(i);
        AppMethodBeat.o(32356);
    }

    public final void a(com.tencent.mm.modelvideo.t.a.a aVar) {
        AppMethodBeat.i(32357);
        String str = aVar.fileName;
        if (bo.isNullOrNil(str) || this.yVF == null) {
            AppMethodBeat.o(32357);
            return;
        }
        a aVar2 = (a) this.yVF.get(str);
        if (aVar2 == null) {
            AppMethodBeat.o(32357);
            return;
        }
        bi biVar = aVar2.csG;
        if (biVar == null || biVar.field_imgPath == null || !biVar.field_imgPath.equals(str)) {
            AppMethodBeat.o(32357);
            return;
        }
        s bG = bG(biVar);
        if (bG == null) {
            AppMethodBeat.o(32357);
        } else if (biVar.dtH() || bG.status == com.tencent.mm.plugin.appbrand.jsapi.k.o.CTRL_INDEX) {
            if (b(aVar2)) {
                Toast.makeText(this.yTG.yTI, R.string.f18, 0).show();
            }
            AppMethodBeat.o(32357);
        } else {
            int g = u.g(bG);
            k OJ = OJ(aVar2.pos);
            if (this.yTG.yTI.getCurrentItem() == aVar2.pos && OJ != null) {
                this.yTG.yTI.dGm();
                this.yWW = false;
                OJ.dGH().yXq.setVisibility(0);
                OJ.dGH().yXq.setProgress(g);
            } else if (OJ == null) {
                AppMethodBeat.o(32357);
                return;
            }
            if (g < OJ.dGH().yXq.getMax()) {
                AppMethodBeat.o(32357);
                return;
            }
            ab.d("MicroMsg.Imagegallery.handler.video", "onNotifyChange, status:%d", Integer.valueOf(bG.status));
            if ((bG.status == 199 || bG.status == 199) && b(aVar2)) {
                this.yTG.yTI.hG(true);
                switch (this.yTG.yTI.np(biVar.field_msgId)) {
                    case 0:
                    case 3:
                        a(biVar, bG, this.yTG.yTI.getCurrentItem(), false);
                        AppMethodBeat.o(32357);
                        return;
                    case 1:
                        ab.d("MicroMsg.Imagegallery.handler.video", "do restransmit video");
                        h.pYm.a(354, 15, 1, false);
                        this.yTG.bv(biVar);
                        this.yTG.yTI.nq(-1);
                        if (this.rll) {
                            u.f(this.filename, this.yTG.dFP().yXp.getCurrentPosition(), this.rll);
                            this.yWR = true;
                        }
                        this.rll = false;
                        AppMethodBeat.o(32357);
                        return;
                    case 2:
                        h.pYm.a(354, 16, 1, false);
                        c.a(this.yTG.yTI, biVar, true);
                        this.yTG.yTI.nq(-1);
                        if (this.rll) {
                            u.f(this.filename, this.yTG.dFP().yXp.getCurrentPosition(), this.rll);
                            this.yWR = true;
                        }
                        this.rll = false;
                        AppMethodBeat.o(32357);
                        return;
                    default:
                        ab.w("MicroMsg.Imagegallery.handler.video", "enterVideoOpCode[%d] is error", Integer.valueOf(this.yTG.yTI.np(biVar.field_msgId)));
                        break;
                }
            }
            AppMethodBeat.o(32357);
        }
    }

    private void dGB() {
        AppMethodBeat.i(32358);
        try {
            this.yTG.yTI.dFZ().yVV.setIplaySeekCallback(this.vgC);
            AppMethodBeat.o(32358);
        } catch (Exception e) {
            AppMethodBeat.o(32358);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void bq(final String str, final boolean z) {
        AppMethodBeat.i(32359);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(32319);
                ab.i("MicroMsg.Imagegallery.handler.video", "prepare video filename %s isOnlinePlay %b ", str, Boolean.valueOf(z));
                if (j.this.yVF == null) {
                    ab.w("MicroMsg.Imagegallery.handler.video", "prepare video but cache map is null.");
                    AppMethodBeat.o(32319);
                    return;
                }
                a aVar = (a) j.this.yVF.get(str);
                if (aVar == null || aVar.csG == null) {
                    AppMethodBeat.o(32319);
                    return;
                }
                s bG = j.bG(aVar.csG);
                if (j.this.yTG.yTI.getCurrentItem() == aVar.pos) {
                    j.a(j.this, aVar.csG, bG, aVar.pos, z);
                    j.this.arz(str);
                    AppMethodBeat.o(32319);
                    return;
                }
                ab.w("MicroMsg.Imagegallery.handler.video", "playVideo, but currentItem is not correct.[%d, %d]", Integer.valueOf(j.this.yTG.yTI.getCurrentItem()), Integer.valueOf(aVar.pos));
                AppMethodBeat.o(32319);
            }
        });
        AppMethodBeat.o(32359);
    }

    /* Access modifiers changed, original: protected|final */
    public final void ae(int i, boolean z) {
        AppMethodBeat.i(32360);
        k dFP = this.yTG.dFP();
        if (dFP == null) {
            AppMethodBeat.o(32360);
            return;
        }
        csg();
        dFP.dGH().yXx.setVisibility(8);
        dFP.dGH().yXp.d((double) (i * 1000), z);
        this.yTG.yTI.qx(false);
        cV(false);
        AppMethodBeat.o(32360);
    }

    /* Access modifiers changed, original: protected|final */
    public final void akX() {
        AppMethodBeat.i(32361);
        k dFP = this.yTG.dFP();
        if (dFP == null) {
            AppMethodBeat.o(32361);
            return;
        }
        ab.i("MicroMsg.Imagegallery.handler.video", "start to pause");
        this.yTG.yTI.qx(true);
        dFP.dGH().yXx.setVisibility(0);
        dFP.dGH().yXp.pause();
        csh();
        AppMethodBeat.o(32361);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean csf() {
        AppMethodBeat.i(32362);
        k dFP = this.yTG.dFP();
        if (dFP == null) {
            AppMethodBeat.o(32362);
            return false;
        }
        boolean z = true;
        if (!dFP.dGH().yXp.isPlaying()) {
            ab.i("MicroMsg.Imagegallery.handler.video", "start to play");
            this.yTG.yTI.qx(false);
            dFP.dGH().yXx.setVisibility(8);
            z = dFP.dGH().yXp.start();
            csg();
        }
        if (dFP.dGH().yXx.getVisibility() != 8) {
            dFP.dGH().yXx.setVisibility(8);
        }
        AppMethodBeat.o(32362);
        return z;
    }

    /* Access modifiers changed, original: protected|final */
    public final void Pg(int i) {
        AppMethodBeat.i(32363);
        this.yTG.yTI.dFZ().yVV.seek(Math.max(0, i));
        AppMethodBeat.o(32363);
    }

    /* Access modifiers changed, original: protected|final */
    public final void arz(String str) {
        AppMethodBeat.i(32364);
        if (!(this.yWW || b((a) this.yVF.get(str)))) {
            ab.w("MicroMsg.Imagegallery.handler.video", "show tool bar error.");
        }
        AppMethodBeat.o(32364);
    }

    private void csg() {
        AppMethodBeat.i(32365);
        this.rlu = bo.anU();
        ab.d("MicroMsg.Imagegallery.handler.video", "notePlayVideo filename %s notePlayVideo %d ", this.filename, Long.valueOf(this.rlu));
        AppMethodBeat.o(32365);
    }

    private void csh() {
        AppMethodBeat.i(32366);
        if (this.rlu > 0) {
            this.rlv = (int) (((long) this.rlv) + ((bo.anU() - this.rlu) / 1000));
        }
        ab.i("MicroMsg.Imagegallery.handler.video", "notePauseVideo filename %s playVideoDuration %d ", this.filename, Integer.valueOf(this.rlv));
        this.rlu = 0;
        AppMethodBeat.o(32366);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getPlayVideoDuration() {
        AppMethodBeat.i(32367);
        if (this.rlv < 0) {
            this.rlv = 0;
        }
        ab.i("MicroMsg.Imagegallery.handler.video", "get[%s] play video duration [%d]", this.filename, Integer.valueOf(this.rlv));
        int i = this.rlv;
        AppMethodBeat.o(32367);
        return i;
    }

    /* Access modifiers changed, original: protected|final */
    public final int getUiStayTime() {
        int i;
        AppMethodBeat.i(32368);
        if (this.rlq <= 0 || this.rlp <= 0) {
            i = 0;
        } else {
            i = (int) (this.rlq - this.rlp);
        }
        if (i < 0) {
            i = 0;
        }
        ab.i("MicroMsg.Imagegallery.handler.video", "%d filename[%s] get ui stay time[%d %d %d]", Integer.valueOf(hashCode()), this.filename, Integer.valueOf(i), Long.valueOf(this.rlq), Long.valueOf(this.rlp));
        AppMethodBeat.o(32368);
        return i;
    }

    /* JADX WARNING: Missing block: B:11:0x0047, code skipped:
            com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.Imagegallery.handler.video", "%d rpt rptRepairEffect idKey %d errorTime %d filename %s", java.lang.Integer.valueOf(hashCode()), java.lang.Integer.valueOf(r0), java.lang.Integer.valueOf(r13.yWP), r13.filename);
            com.tencent.mm.plugin.report.service.h.pYm.a(354, (long) r0, 1, false);
            com.tencent.mm.plugin.report.service.h.pYm.e(13836, java.lang.Integer.valueOf(301), java.lang.Long.valueOf(com.tencent.mm.sdk.platformtools.bo.anT()), "");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean c(k kVar) {
        AppMethodBeat.i(32369);
        int i = this.yWO;
        this.yWO = kVar.dGH().yXp.getCurrentPosition();
        if (i != this.yWO) {
            this.lastCheckTime = bo.anU();
            long lastSurfaceUpdateTime = kVar.dGH().yXp.getLastSurfaceUpdateTime();
            if (lastSurfaceUpdateTime <= 0 || lastSurfaceUpdateTime == this.vgx) {
                if (this.yWP != -1) {
                    this.yWP++;
                    ab.w("MicroMsg.Imagegallery.handler.video", "media play is playing[%d], but surface is not update!! repair time[%d]", Integer.valueOf(this.yWP), Integer.valueOf(this.yWQ));
                    if (this.yWQ >= 2) {
                        this.yWK.dGL();
                    }
                    switch (this.yWP) {
                        case 0:
                        case 1:
                            break;
                        case 2:
                            ab.w("MicroMsg.Imagegallery.handler.video", "surface not update, it try seek time[%d] to repair.", Integer.valueOf(this.yWO / 1000));
                            ae(i, true);
                            this.yWQ++;
                            AppMethodBeat.o(32369);
                            return false;
                        case 3:
                            i = (this.yWO - 2000) / 1000;
                            if (i < 0) {
                                i = 0;
                            }
                            ab.w("MicroMsg.Imagegallery.handler.video", "surface not update, it try seek time[%d] to repair.", Integer.valueOf(i));
                            ae(i, true);
                            this.yWQ++;
                            AppMethodBeat.o(32369);
                            return false;
                        case 4:
                            i = (this.yWO - 4000) / 1000;
                            if (i < 0) {
                                i = 0;
                            }
                            ab.w("MicroMsg.Imagegallery.handler.video", "surface not update, it try seek time[%d] to repair.", Integer.valueOf(i));
                            ae(i, true);
                            this.yWQ++;
                            AppMethodBeat.o(32369);
                            return false;
                        default:
                            ab.w("MicroMsg.Imagegallery.handler.video", "rpt surface not update!!");
                            ab.w("MicroMsg.Imagegallery.handler.video", "%d rpt rptSurfaceNotUpdate %s", Integer.valueOf(hashCode()), this.filename);
                            h.pYm.e(13836, Integer.valueOf(300), Long.valueOf(bo.anT()), "");
                            h.pYm.a(354, 20, 1, false);
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
        ab.i("MicroMsg.Imagegallery.handler.video", "check time[%d, %d], play time[%d, %d]", Long.valueOf(this.lastCheckTime), Long.valueOf(bo.anU()), Integer.valueOf(i), Integer.valueOf(this.yWO));
        if (this.lastCheckTime > 0 && bo.gb(this.lastCheckTime) >= 1500) {
            ab.w("MicroMsg.Imagegallery.handler.video", "play time not update! request all video data to play. ");
            i = this.yTG.dFP().yXp.getCurrentPosition();
            cse();
            u.f(this.filename, i, this.rll);
            this.yTG.dFP().yXp.stop();
            this.yWK.dGL();
            a aVar = (a) this.yVF.get(this.filename);
            if (aVar == null || aVar.csG == null) {
                AppMethodBeat.o(32369);
                return false;
            }
            a(aVar.csG, bG(aVar.csG), aVar.pos, this.rll);
            this.lastCheckTime = 0;
            AppMethodBeat.o(32369);
            return false;
        }
        AppMethodBeat.o(32369);
        return true;
    }

    private static void dGC() {
        AppMethodBeat.i(32370);
        h.pYm.a(354, 11, 1, false);
        AppMethodBeat.o(32370);
    }

    private static void dGD() {
        AppMethodBeat.i(32371);
        h.pYm.a(354, 14, 1, false);
        AppMethodBeat.o(32371);
    }

    private boolean bwE() {
        AppMethodBeat.i(32372);
        if (this.rll) {
            aw.ZK();
            boolean z = c.Ry().getBoolean(com.tencent.mm.storage.ac.a.USERINFO_VIDEO_NEED_RESET_EXTRACTOR_BOOLEAN, false);
            AppMethodBeat.o(32372);
            return z;
        }
        AppMethodBeat.o(32372);
        return false;
    }
}

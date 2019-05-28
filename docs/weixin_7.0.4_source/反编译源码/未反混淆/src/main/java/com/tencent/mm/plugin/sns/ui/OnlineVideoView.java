package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.lp;
import com.tencent.mm.g.a.rb;
import com.tencent.mm.g.a.re;
import com.tencent.mm.g.a.sb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.d;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.n.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public class OnlineVideoView extends RelativeLayout implements com.tencent.mm.model.d.a, com.tencent.mm.plugin.sns.ui.ae.a, com.tencent.mm.pluginsdk.ui.tools.e.a {
    private int cNW;
    private boolean cNX;
    private int cNY;
    private bau cNr;
    private String czD;
    private int duration;
    private boolean eif;
    private int fDG;
    private d iaf;
    ak kkp;
    private e klq;
    private ap klw;
    private Context mContext;
    boolean mOO;
    ImageView mmB;
    private RelativeLayout mmW;
    private TextView mqf;
    private boolean mqg;
    private boolean mqh;
    private int mqi;
    private ProgressBar mqj;
    private MMPinProgressBtn mqk;
    private b orK;
    private az qFT;
    private c qNa;
    private ap rcg;
    private boolean rkY;
    private e.e rlb;
    private int rlf;
    String rlg;
    private boolean rlh;
    private a rli;
    private TextView rlj;
    private ae rlk;
    private boolean rll;
    private boolean rlm;
    private int rln;
    private int rlo;
    private long rlp;
    private long rlq;
    private com.tencent.mm.plugin.sns.model.b.b rlr;
    private c rls;
    private c rlt;
    private long rlu;
    private int rlv;

    public interface a {
    }

    static /* synthetic */ void A(OnlineVideoView onlineVideoView) {
        AppMethodBeat.i(38448);
        onlineVideoView.bwD();
        AppMethodBeat.o(38448);
    }

    static /* synthetic */ void b(OnlineVideoView onlineVideoView, int i) {
        AppMethodBeat.i(38443);
        onlineVideoView.DS(i);
        AppMethodBeat.o(38443);
    }

    static /* synthetic */ void b(OnlineVideoView onlineVideoView, int i, boolean z) {
        AppMethodBeat.i(38444);
        onlineVideoView.af(i, z);
        AppMethodBeat.o(38444);
    }

    static /* synthetic */ void m(OnlineVideoView onlineVideoView) {
        AppMethodBeat.i(38438);
        onlineVideoView.a(true, 1.0f);
        AppMethodBeat.o(38438);
    }

    static /* synthetic */ void n(OnlineVideoView onlineVideoView) {
        AppMethodBeat.i(38439);
        onlineVideoView.bJc();
        AppMethodBeat.o(38439);
    }

    static /* synthetic */ void w(OnlineVideoView onlineVideoView) {
        AppMethodBeat.i(38445);
        onlineVideoView.csd();
        AppMethodBeat.o(38445);
    }

    static /* synthetic */ void y(OnlineVideoView onlineVideoView) {
        AppMethodBeat.i(38447);
        onlineVideoView.csh();
        AppMethodBeat.o(38447);
    }

    public OnlineVideoView(Context context) {
        this(context, null);
    }

    public OnlineVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OnlineVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(38407);
        this.rlf = 0;
        this.mOO = false;
        this.mqg = false;
        this.eif = false;
        this.cNr = null;
        this.rlh = false;
        this.rlk = null;
        this.rlm = false;
        this.duration = 0;
        this.rln = 0;
        this.rlo = 0;
        this.rlp = 0;
        this.rlq = 0;
        this.mqi = 0;
        this.kkp = new ak(Looper.getMainLooper());
        this.rcg = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
            public final boolean BI() {
                AppMethodBeat.i(38405);
                if (OnlineVideoView.this.rlk == null || OnlineVideoView.this.klq == null) {
                    AppMethodBeat.o(38405);
                    return false;
                }
                if (((View) OnlineVideoView.this.klq).getAlpha() < 1.0f) {
                    OnlineVideoView.m(OnlineVideoView.this);
                }
                if (OnlineVideoView.this.klq.isPlaying()) {
                    OnlineVideoView.n(OnlineVideoView.this);
                }
                try {
                    Object obj;
                    if (bo.isNullOrNil(OnlineVideoView.this.rlk.fUL)) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj == null) {
                        AppMethodBeat.o(38405);
                        return false;
                    }
                    boolean mm = OnlineVideoView.this.rlk.mm(OnlineVideoView.this.klq.getCurrentPosition() / 1000);
                    AppMethodBeat.o(38405);
                    return mm;
                } catch (Exception e) {
                    ab.e("MicroMsg.OnlineVideoView", "online video timer check error : " + e.toString());
                    AppMethodBeat.o(38405);
                    return false;
                }
            }
        }, true);
        this.klw = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
            public final boolean BI() {
                AppMethodBeat.i(38406);
                if (OnlineVideoView.this.klq == null) {
                    AppMethodBeat.o(38406);
                    return false;
                }
                if (((View) OnlineVideoView.this.klq).getAlpha() < 1.0f) {
                    OnlineVideoView.m(OnlineVideoView.this);
                }
                if (OnlineVideoView.this.klq.isPlaying()) {
                    OnlineVideoView.n(OnlineVideoView.this);
                    OnlineVideoView.this.klq.getCurrentPosition();
                }
                AppMethodBeat.o(38406);
                return true;
            }
        }, true);
        this.rlr = new com.tencent.mm.plugin.sns.model.b.b() {
            public final void Xw(String str) {
            }

            public final void bj(String str, boolean z) {
            }

            public final void cmu() {
            }

            public final void bk(final String str, final boolean z) {
                AppMethodBeat.i(38386);
                OnlineVideoView.this.kkp.postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(38385);
                        ab.i("MicroMsg.OnlineVideoView", "%d weixin download finish[%b], go to prepare video", Integer.valueOf(OnlineVideoView.this.hashCode()), Boolean.valueOf(z));
                        if (OnlineVideoView.this.cNr != null && z && bo.isEqual(OnlineVideoView.this.cNr.Id, str)) {
                            aq.gb(OnlineVideoView.this.czD, "");
                            String a = aq.a(OnlineVideoView.this.czD, OnlineVideoView.this.cNr);
                            if (!bo.isNullOrNil(a)) {
                                OnlineVideoView.this.bq(a, false);
                            }
                        }
                        AppMethodBeat.o(38385);
                    }
                }, 100);
                AppMethodBeat.o(38386);
            }
        };
        this.rls = new c<sb>() {
            {
                AppMethodBeat.i(38387);
                this.xxI = sb.class.getName().hashCode();
                AppMethodBeat.o(38387);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(38388);
                sb sbVar = (sb) bVar;
                ab.i("MicroMsg.OnlineVideoView", "%d sns video menu event local id[%s, %s]", Integer.valueOf(OnlineVideoView.this.hashCode()), sbVar.cNV.czD, OnlineVideoView.this.czD);
                if (bo.isEqual(sbVar.cNV.czD, OnlineVideoView.this.czD)) {
                    if (sbVar.cNV.cAd == 1) {
                        OnlineVideoView.a(OnlineVideoView.this, sbVar.cNV.cNY);
                    } else if (sbVar.cNV.cAd == 2) {
                        OnlineVideoView.a(OnlineVideoView.this, sbVar.cNV.cNW, sbVar.cNV.cNX);
                    } else if (sbVar.cNV.cAd == 3) {
                        OnlineVideoView.p(OnlineVideoView.this);
                    }
                }
                AppMethodBeat.o(38388);
                return false;
            }
        };
        this.rlt = new c<re>() {
            {
                AppMethodBeat.i(38390);
                this.xxI = re.class.getName().hashCode();
                AppMethodBeat.o(38390);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(38391);
                final re reVar = (re) bVar;
                ab.i("MicroMsg.OnlineVideoView", "%d sns flip ui event. local id[%s, %s] opcode %d hadUiEvent %b", Integer.valueOf(OnlineVideoView.this.hashCode()), reVar.cNj.czD, OnlineVideoView.this.czD, Integer.valueOf(reVar.cNj.cAd), Boolean.valueOf(OnlineVideoView.this.rlm));
                if (reVar.cNj.cAd == 2) {
                    if (reVar.cNj.context != null && reVar.cNj.context == OnlineVideoView.this.mContext) {
                        OnlineVideoView.this.rlm = false;
                        OnlineVideoView.this.csc();
                        OnlineVideoView.this.onDestroy();
                    }
                    AppMethodBeat.o(38391);
                } else {
                    if (reVar.cNj.cAd == 1) {
                        OnlineVideoView.this.kkp.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(38389);
                                if (!bo.isEqual(reVar.cNj.czD, OnlineVideoView.this.czD)) {
                                    OnlineVideoView.this.rlm = false;
                                    OnlineVideoView.this.csc();
                                    OnlineVideoView.this.onDestroy();
                                    AppMethodBeat.o(38389);
                                } else if (OnlineVideoView.this.rlm) {
                                    OnlineVideoView.this.requestLayout();
                                    AppMethodBeat.o(38389);
                                } else {
                                    OnlineVideoView.this.rlm = true;
                                    OnlineVideoView.this.onResume();
                                    AppMethodBeat.o(38389);
                                }
                            }
                        });
                    }
                    AppMethodBeat.o(38391);
                }
                return false;
            }
        };
        this.qNa = new c<lp>() {
            {
                AppMethodBeat.i(38392);
                this.xxI = lp.class.getName().hashCode();
                AppMethodBeat.o(38392);
            }

            /* Code decompiled incorrectly, please refer to instructions dump. */
            private boolean a(lp lpVar) {
                AppMethodBeat.i(38393);
                if (OnlineVideoView.this.rlk == null) {
                    ab.w("MicroMsg.OnlineVideoView", "%d online video helper is null.", Integer.valueOf(OnlineVideoView.this.hashCode()));
                    AppMethodBeat.o(38393);
                } else {
                    try {
                        if (!OnlineVideoView.this.rlk.ZA(lpVar.cHq.cHr)) {
                            AppMethodBeat.o(38393);
                        } else if (lpVar.cHq.retCode == -21112) {
                            OnlineVideoView onlineVideoView = OnlineVideoView.this;
                            h.pYm.a(354, 218, 1, false);
                            onlineVideoView.kkp.post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(38398);
                                    ab.w("MicroMsg.OnlineVideoView", "%d deal sns video change isOnlinePlay[%b]", Integer.valueOf(OnlineVideoView.this.hashCode()), Boolean.valueOf(OnlineVideoView.this.rll));
                                    if (OnlineVideoView.this.rll) {
                                        OnlineVideoView.y(OnlineVideoView.this);
                                        OnlineVideoView.this.klq.stop();
                                        OnlineVideoView.this.cse();
                                        boolean deleteFile = com.tencent.mm.vfs.e.deleteFile(aq.D(OnlineVideoView.this.cNr));
                                        if (OnlineVideoView.this.rlk != null) {
                                            OnlineVideoView.this.rlk.csk();
                                            OnlineVideoView.this.rlk.clear();
                                            OnlineVideoView.this.rlk = new ae(OnlineVideoView.this);
                                        }
                                        ab.i("MicroMsg.OnlineVideoView", "%d delete video file[%b] [%s]", Integer.valueOf(OnlineVideoView.this.hashCode()), Boolean.valueOf(deleteFile), r0);
                                        OnlineVideoView.this.rlo = 0;
                                        OnlineVideoView.A(OnlineVideoView.this);
                                    }
                                    AppMethodBeat.o(38398);
                                }
                            });
                            AppMethodBeat.o(38393);
                        } else if (lpVar.cHq.retCode == 0 || lpVar.cHq.retCode == -21006) {
                            int i;
                            int i2;
                            ae k;
                            switch (lpVar.cHq.cAd) {
                                case 1:
                                    ae k2 = OnlineVideoView.this.rlk;
                                    long j = (long) lpVar.cHq.offset;
                                    long j2 = lpVar.cHq.cHs;
                                    boolean z = lpVar.cHq.cHt;
                                    ab.i("MicroMsg.OnlineVideoViewHelper", "deal moov ready moovPos %d, timeDuration %d, cdnMediaId %s startDownload[%d %d]", Long.valueOf(j), Integer.valueOf(k2.fUR), k2.fUL, Long.valueOf(j2), Long.valueOf(k2.egA));
                                    if (k2.fUR != 0) {
                                        ab.w("MicroMsg.OnlineVideoViewHelper", "moov had callback, do nothing.");
                                    } else {
                                        if (j2 <= k2.egA) {
                                            j2 = k2.egA;
                                        }
                                        k2.egA = j2;
                                        k2.rlG = bo.anU();
                                        try {
                                            if (k2.fUQ == null) {
                                                ab.w("MicroMsg.OnlineVideoViewHelper", "parser is null, thread is error.");
                                            } else if (k2.fUQ.v(k2.fUM, j)) {
                                                k2.fUR = k2.fUQ.gkm;
                                                ab.i("MicroMsg.OnlineVideoViewHelper", "mp4 parse moov success. duration %d cdnMediaId %s isFastStart %b", Integer.valueOf(k2.fUR), k2.fUL, Boolean.valueOf(z));
                                                if (!z) {
                                                    al.d(new Runnable() {
                                                        public final void run() {
                                                            AppMethodBeat.i(38449);
                                                            if (ae.this.rlD != null && ae.this.mm(0)) {
                                                                ae.this.cso();
                                                                ae.this.rlD.bq(ae.this.fUM, true);
                                                                ae.this.fUX = true;
                                                            }
                                                            AppMethodBeat.o(38449);
                                                        }
                                                    });
                                                }
                                                if (k2.fUS == -1) {
                                                    k2.fUP = 1;
                                                } else {
                                                    k2.fUP = 2;
                                                }
                                                h.pYm.a(354, 204, 1, false);
                                            } else {
                                                ab.w("MicroMsg.OnlineVideoViewHelper", "mp4 parse moov error. cdnMediaId %s", k2.fUL);
                                                o.alm();
                                                com.tencent.mm.al.e.k(k2.fUL, 0, -1);
                                                h.pYm.a(354, 205, 1, false);
                                                h.pYm.e(13836, Integer.valueOf(402), Long.valueOf(bo.anT()), "");
                                            }
                                        } catch (Exception e) {
                                            ab.e("MicroMsg.OnlineVideoViewHelper", "deal moov ready error: " + e.toString());
                                        }
                                    }
                                    OnlineVideoView.this.rll = true;
                                    break;
                                case 2:
                                    ae k3 = OnlineVideoView.this.rlk;
                                    String str = lpVar.cHq.cHr;
                                    i = lpVar.cHq.offset;
                                    i2 = lpVar.cHq.length;
                                    k3.fUY = false;
                                    if (i < 0 || i2 < 0) {
                                        ab.w("MicroMsg.OnlineVideoViewHelper", "deal data available error offset[%d], length[%d]", Integer.valueOf(i), Integer.valueOf(i2));
                                    } else if (k3.ZA(str)) {
                                        Integer num = (Integer) k3.rlC.get(k3.fUL + i + "_" + i2);
                                        if (num == null || num.intValue() <= 0) {
                                            try {
                                                k3.fUV = k3.fUQ.cK(i, i2);
                                            } catch (Exception e2) {
                                                ab.e("MicroMsg.OnlineVideoViewHelper", "deal data available file pos to video time error: " + e2.toString());
                                            }
                                        } else {
                                            k3.fUV = num.intValue();
                                        }
                                        ab.i("MicroMsg.OnlineVideoViewHelper", "deal data available. offset[%d] length[%d] cachePlayTime[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(k3.fUV));
                                    }
                                    if (lpVar.cHq.length > 0) {
                                        OnlineVideoView.this.cV(true);
                                        break;
                                    }
                                    break;
                                case 3:
                                    OnlineVideoView.this.cV(true);
                                    break;
                                case 4:
                                    ab.i("MicroMsg.OnlineVideoView", "%d download finish. cdnMediaId %s sendReqCode %d favFromScene %d", Integer.valueOf(OnlineVideoView.this.hashCode()), lpVar.cHq.cHr, Integer.valueOf(OnlineVideoView.this.cNY), Integer.valueOf(OnlineVideoView.this.cNW));
                                    k = OnlineVideoView.this.rlk;
                                    ab.i("MicroMsg.OnlineVideoViewHelper", "deal stream finish. playStatus %d cdnMediaId %s", Integer.valueOf(k.fUP), k.fUL);
                                    k.fUY = false;
                                    k.fUO = 3;
                                    h.pYm.a(354, 206, 1, false);
                                    if (k.fUP == 0) {
                                        ab.w("MicroMsg.OnlineVideoViewHelper", "it had not moov callback and download finish start to play video.");
                                        k.csl();
                                    } else if (k.fUP == 5) {
                                        ab.w("MicroMsg.OnlineVideoViewHelper", "it had play error, it request all video data finish, start to play." + k.fUL);
                                        k.csl();
                                    }
                                    if (OnlineVideoView.this.cNY <= 0) {
                                        if (OnlineVideoView.this.cNW <= 0) {
                                            if (!OnlineVideoView.this.rlh) {
                                                OnlineVideoView.this.cV(true);
                                                break;
                                            }
                                            OnlineVideoView.n(OnlineVideoView.this);
                                            OnlineVideoView.w(OnlineVideoView.this);
                                            break;
                                        }
                                        OnlineVideoView.n(OnlineVideoView.this);
                                        OnlineVideoView.b(OnlineVideoView.this, OnlineVideoView.this.cNW, OnlineVideoView.this.cNX);
                                        break;
                                    }
                                    OnlineVideoView.n(OnlineVideoView.this);
                                    OnlineVideoView.b(OnlineVideoView.this, OnlineVideoView.this.cNY);
                                    break;
                                case 5:
                                    if (OnlineVideoView.this.rlf != 1) {
                                        if (OnlineVideoView.this.rlf == 2) {
                                            OnlineVideoView.a(OnlineVideoView.this, lpVar.cHq.offset, lpVar.cHq.length);
                                            break;
                                        }
                                    }
                                    k = OnlineVideoView.this.rlk;
                                    String str2 = lpVar.cHq.cHr;
                                    i = lpVar.cHq.offset;
                                    i2 = lpVar.cHq.length;
                                    if (k.ZA(str2)) {
                                        k.progress = i;
                                        k.total = i2;
                                        k.rlE = (k.progress * 100) / k.total;
                                        ab.i("MicroMsg.OnlineVideoViewHelper", "deal video[%s] progress callback[%d, %d]. downloadedPercent[%d]", k.fUL, Integer.valueOf(k.progress), Integer.valueOf(k.total), Integer.valueOf(k.rlE));
                                    }
                                    if (k.rlE >= 100) {
                                        k.fUO = 3;
                                        break;
                                    }
                                    break;
                                case 6:
                                    ab.i("MicroMsg.OnlineVideoViewHelper", "deal had dup video. cdnMediaId %s", OnlineVideoView.this.rlk.fUL);
                                    k.csl();
                                    break;
                                default:
                                    ab.w("MicroMsg.OnlineVideoView", "%d unknown event opcode %d", Integer.valueOf(OnlineVideoView.this.hashCode()), Integer.valueOf(lpVar.cHq.cAd));
                                    break;
                            }
                            AppMethodBeat.o(38393);
                        } else {
                            ab.w("MicroMsg.OnlineVideoView", "%d stream download online video error. retCode %d ", Integer.valueOf(OnlineVideoView.this.hashCode()), Integer.valueOf(lpVar.cHq.retCode));
                            AppMethodBeat.o(38393);
                        }
                    } catch (Exception e22) {
                        ab.e("MicroMsg.OnlineVideoView", "online video callback error: " + e22.toString());
                    }
                }
                return false;
            }
        };
        this.rlb = new e.e() {
            public final void bQL() {
                AppMethodBeat.i(38395);
                ab.i("MicroMsg.OnlineVideoView", "%d on texture update.", Integer.valueOf(OnlineVideoView.this.hashCode()));
                try {
                    OnlineVideoView.m(OnlineVideoView.this);
                    AppMethodBeat.o(38395);
                } catch (Exception e) {
                    ab.e("MicroMsg.OnlineVideoView", "texture view update. error " + e.toString());
                    AppMethodBeat.o(38395);
                }
            }
        };
        this.orK = new b() {
            public final long bOR() {
                AppMethodBeat.i(38396);
                ab.i("MicroMsg.OnlineVideoView", "%d sns video get online cache", Integer.valueOf(OnlineVideoView.this.hashCode()));
                g.RQ();
                g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_VIDEO_NEED_RESET_EXTRACTOR_BOOLEAN, Boolean.TRUE);
                try {
                    if (OnlineVideoView.this.rll && OnlineVideoView.this.rlk != null) {
                        long j = (long) OnlineVideoView.this.rlk.fUV;
                        AppMethodBeat.o(38396);
                        return j;
                    }
                } catch (Exception e) {
                }
                AppMethodBeat.o(38396);
                return 0;
            }
        };
        this.mContext = context;
        ab.i("MicroMsg.OnlineVideoView", "%d ui init view.", Integer.valueOf(hashCode()));
        LayoutInflater.from(context).inflate(R.layout.ax5, this);
        this.mmB = (ImageView) findViewById(R.id.aex);
        this.mmW = (RelativeLayout) findViewById(R.id.aey);
        this.rlj = (TextView) findViewById(R.id.aez);
        this.rlj.setVisibility(8);
        this.mqk = (MMPinProgressBtn) findViewById(R.id.af0);
        this.mqj = (ProgressBar) findViewById(R.id.a9d);
        this.mqf = (TextView) findViewById(R.id.af2);
        com.tencent.mm.modelcontrol.d.afF();
        if (com.tencent.mm.modelcontrol.d.afO()) {
            this.mqh = true;
            this.klq = new VideoPlayerTextureView(context);
            ((VideoPlayerTextureView) this.klq).setIOnlineCache(this.orK);
            ((VideoPlayerTextureView) this.klq).setOpenWithNoneSurface(true);
            h.pYm.a(354, 148, 1, false);
        } else {
            this.mqh = false;
            this.klq = new VideoTextureView(context);
            h.pYm.a(354, 149, 1, false);
        }
        this.klq.setVideoCallback(this);
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.addRule(13);
        this.mmW.addView((View) this.klq, layoutParams);
        a(false, 0.0f);
        AppMethodBeat.o(38407);
    }

    public final void csb() {
        AppMethodBeat.i(38408);
        ab.d("MicroMsg.OnlineVideoView", "%d register sns ui event", Integer.valueOf(hashCode()));
        com.tencent.mm.sdk.b.a.xxA.c(this.rlt);
        AppMethodBeat.o(38408);
    }

    public final void csc() {
        AppMethodBeat.i(38409);
        ab.d("MicroMsg.OnlineVideoView", "%d unRegister sns ui event", Integer.valueOf(hashCode()));
        com.tencent.mm.sdk.b.a.xxA.d(this.rlt);
        AppMethodBeat.o(38409);
    }

    public final void a(bau bau, String str, int i) {
        AppMethodBeat.i(38410);
        this.czD = str;
        this.fDG = i;
        az dtl = az.dtl();
        dtl.oyB = this.fDG;
        this.qFT = dtl;
        if (this.cNr != bau) {
            this.cNr = bau;
            boolean b = af.cnC().b(this.cNr, this.mmB, (int) R.drawable.abd, this.mContext.hashCode(), this.qFT);
            ab.i("MicroMsg.OnlineVideoView", "%d fresh thumb image %b", Integer.valueOf(hashCode()), Boolean.valueOf(b));
        }
        this.mOO = false;
        ab.i("MicroMsg.OnlineVideoView", "%d set video data[%s, %d] isPreview %b ", Integer.valueOf(hashCode()), this.czD, Integer.valueOf(this.fDG), Boolean.valueOf(this.mOO));
        AppMethodBeat.o(38410);
    }

    public void setVideoCallback(a aVar) {
        this.rli = aVar;
    }

    public void setMute(boolean z) {
        AppMethodBeat.i(38411);
        this.eif = z;
        this.klq.setMute(this.eif);
        AppMethodBeat.o(38411);
    }

    public final void onResume() {
        AppMethodBeat.i(38412);
        ab.d("MicroMsg.OnlineVideoView", "%d on resume %s", Integer.valueOf(hashCode()), bo.dpG());
        this.rlp = bo.anU();
        if (this.rlk == null) {
            ab.i("MicroMsg.OnlineVideoView", "%d logic init, create new helper and add listener.", Integer.valueOf(hashCode()));
            this.rlk = new ae(this);
            com.tencent.mm.sdk.b.a.xxA.c(this.qNa);
            com.tencent.mm.sdk.b.a.xxA.c(this.rls);
            af.cnA().a(this.rlr);
            this.iaf = new d();
            this.iaf.a(this);
            if (com.tencent.mm.r.a.Cc() != null) {
                com.tencent.mm.r.a.Cc().Id();
            }
        }
        if (!this.mqg) {
            bwD();
        }
        this.rkY = true;
        AppMethodBeat.o(38412);
    }

    public final void onPause() {
        AppMethodBeat.i(38413);
        ab.d("MicroMsg.OnlineVideoView", "%d on pause %s ", Integer.valueOf(hashCode()), bo.dpG());
        cse();
        if (this.klq != null) {
            this.klq.stop();
        }
        AppMethodBeat.o(38413);
    }

    public final void onDestroy() {
        AppMethodBeat.i(38414);
        ab.d("MicroMsg.OnlineVideoView", "%d on destroy %s", Integer.valueOf(hashCode()), bo.dpG());
        this.rlq = bo.anU();
        ab.i("MicroMsg.OnlineVideoView", "%d logic unInit", Integer.valueOf(hashCode()));
        csh();
        this.klq.stop();
        com.tencent.mm.sdk.b.a.xxA.d(this.qNa);
        com.tencent.mm.sdk.b.a.xxA.d(this.rls);
        af.cnA().b(this.rlr);
        cse();
        this.kkp.removeCallbacksAndMessages(null);
        if (this.rlk != null) {
            this.rlk.csk();
            this.rlk.clear();
        }
        if (com.tencent.mm.r.a.Cc() != null) {
            com.tencent.mm.r.a.Cc().Ic();
        }
        if (this.iaf != null) {
            this.iaf.cy(false);
        }
        this.iaf = null;
        this.cNr = null;
        this.czD = null;
        this.rlk = null;
        this.rlo = 0;
        AppMethodBeat.o(38414);
    }

    private void DS(int i) {
        AppMethodBeat.i(38415);
        String str = an.fZ(af.getAccSnsPath(), this.cNr.Id) + i.e(this.cNr);
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("image_path", str);
        intent.putExtra("Retr_Msg_Type", 11);
        ab.i("MicroMsg.OnlineVideoView", "send video path %s reqCode %d", str, Integer.valueOf(i));
        com.tencent.mm.bp.d.b(this.mContext, ".ui.transmit.SelectConversationUI", intent, i);
        this.cNY = 0;
        AppMethodBeat.o(38415);
    }

    private void af(final int i, final boolean z) {
        AppMethodBeat.i(38416);
        this.kkp.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(38384);
                n YT = af.cnF().YT(OnlineVideoView.this.czD);
                if (YT == null) {
                    AppMethodBeat.o(38384);
                    return;
                }
                ab.i("MicroMsg.OnlineVideoView", "fav download video[%s] farFromScene %d isFromMain %b", OnlineVideoView.this.czD, Integer.valueOf(i), Boolean.valueOf(z));
                cl clVar = new cl();
                clVar.cvA.cvH = i;
                clVar.cvA.activity = (Activity) OnlineVideoView.this.mContext;
                com.tencent.mm.plugin.sns.j.a.a(clVar, YT);
                com.tencent.mm.sdk.b.a.xxA.m(clVar);
                if (clVar.cvB.ret == 0) {
                    OnlineVideoView.csi();
                } else {
                    OnlineVideoView.csj();
                }
                if (z) {
                    rb rbVar = new rb();
                    rbVar.cNg.cwT = YT.cqU();
                    rbVar.cNg.cFc = i.j(YT);
                    com.tencent.mm.sdk.b.a.xxA.m(rbVar);
                }
                OnlineVideoView.this.cNW = 0;
                if (OnlineVideoView.this.klq != null) {
                    if (bo.isNullOrNil(OnlineVideoView.this.klq.getVideoPath())) {
                        ab.i("MicroMsg.OnlineVideoView", "%d had not set video path to play", Integer.valueOf(OnlineVideoView.this.hashCode()));
                        String a = aq.a(OnlineVideoView.this.czD, OnlineVideoView.this.cNr);
                        if (!bo.isNullOrNil(a)) {
                            OnlineVideoView.this.bq(a, false);
                        }
                        AppMethodBeat.o(38384);
                        return;
                    } else if (!OnlineVideoView.this.klq.isPlaying()) {
                        OnlineVideoView.this.klq.start();
                        AppMethodBeat.o(38384);
                        return;
                    }
                }
                AppMethodBeat.o(38384);
            }
        });
        AppMethodBeat.o(38416);
    }

    private void csd() {
        AppMethodBeat.i(38417);
        long yz = bo.yz();
        String uu = u.uu(aq.a(this.czD, this.cNr));
        if (bo.isNullOrNil(uu)) {
            Toast.makeText(this.mContext, this.mContext.getString(R.string.f1c), 1).show();
            h.pYm.a(354, 222, 1, false);
        } else {
            Toast.makeText(this.mContext, this.mContext.getString(R.string.f1d, new Object[]{uu}), 1).show();
            com.tencent.mm.sdk.f.a.a(uu, this.mContext);
            h.pYm.a(354, 221, 1, false);
        }
        this.rlh = false;
        ab.i("MicroMsg.OnlineVideoView", "%d save downloaded video finish %d %s", Integer.valueOf(hashCode()), Long.valueOf(bo.az(yz)), r0);
        this.kkp.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(38399);
                if (OnlineVideoView.this.klq != null) {
                    if (bo.isNullOrNil(OnlineVideoView.this.klq.getVideoPath())) {
                        ab.i("MicroMsg.OnlineVideoView", "%d had not set video path to play", Integer.valueOf(OnlineVideoView.this.hashCode()));
                        String a = aq.a(OnlineVideoView.this.czD, OnlineVideoView.this.cNr);
                        if (!bo.isNullOrNil(a)) {
                            OnlineVideoView.this.bq(a, false);
                        }
                        AppMethodBeat.o(38399);
                        return;
                    } else if (!OnlineVideoView.this.klq.isPlaying()) {
                        OnlineVideoView.this.klq.start();
                        AppMethodBeat.o(38399);
                        return;
                    }
                }
                AppMethodBeat.o(38399);
            }
        });
        AppMethodBeat.o(38417);
    }

    private void a(final boolean z, final float f) {
        AppMethodBeat.i(38418);
        this.kkp.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(38400);
                ab.i("MicroMsg.OnlineVideoView", "%d switch video model isVideoPlay %b %f", Integer.valueOf(OnlineVideoView.this.hashCode()), Boolean.valueOf(z), Float.valueOf(f));
                View view = (View) OnlineVideoView.this.klq;
                if (z) {
                    OnlineVideoView.this.mmW.setAlpha(f);
                    OnlineVideoView.this.mmW.setVisibility(0);
                    view.setAlpha(f);
                    view.setVisibility(0);
                    if (((double) f) >= 1.0d) {
                        OnlineVideoView.this.mmB.setVisibility(8);
                        AppMethodBeat.o(38400);
                        return;
                    }
                }
                OnlineVideoView.this.mmW.setVisibility(8);
                view.setVisibility(8);
                OnlineVideoView.this.mmB.setVisibility(0);
                AppMethodBeat.o(38400);
            }
        });
        AppMethodBeat.o(38418);
    }

    private void bwD() {
        String str;
        AppMethodBeat.i(38419);
        if (this.mOO) {
            str = this.rlg;
        } else {
            str = aq.a(this.czD, this.cNr);
        }
        ab.i("MicroMsg.OnlineVideoView", "%d toggleVideo local id %s finish path %s isPreview %b", Integer.valueOf(hashCode()), this.czD, str, Boolean.valueOf(this.mOO));
        if (bo.isNullOrNil(str)) {
            a(false, 0.0f);
            C(false, 0);
            aNt();
            AppMethodBeat.o(38419);
            return;
        }
        ab.i("MicroMsg.OnlineVideoView", "%d sns video already download finish, play now", Integer.valueOf(hashCode()));
        a(true, 0.0f);
        bq(str, false);
        AppMethodBeat.o(38419);
    }

    private void C(boolean z, int i) {
        boolean z2 = true;
        AppMethodBeat.i(38420);
        if (this.cNr == null) {
            ab.w("MicroMsg.OnlineVideoView", "%d start download video but media is null.", Integer.valueOf(hashCode()));
            AppMethodBeat.o(38420);
        } else if (this.rlk == null) {
            ab.w("MicroMsg.OnlineVideoView", "%d start download video but helper is null.", Integer.valueOf(hashCode()));
            AppMethodBeat.o(38420);
        } else if (this.cNr.wEG == 2) {
            ab.w("MicroMsg.OnlineVideoView", "%d it start download video, url type is weixin", Integer.valueOf(hashCode()));
            this.rlf = 3;
            af.cnA().a(this.cNr, 4, null, this.qFT);
            AppMethodBeat.o(38420);
        } else {
            int i2;
            if (!z) {
                com.tencent.mm.modelcontrol.d.afF();
                if (com.tencent.mm.modelcontrol.d.afN()) {
                    ab.i("MicroMsg.OnlineVideoView", "%d it start online download video", Integer.valueOf(hashCode()));
                    this.rlf = 1;
                    if (i == 0) {
                        i = 30;
                    }
                    i2 = i;
                    this.rlk.a(this.cNr, this.fDG, this.czD, z2, i2);
                    AppMethodBeat.o(38420);
                }
            }
            ab.i("MicroMsg.OnlineVideoView", "%d it start offline download video", Integer.valueOf(hashCode()));
            this.rlf = 2;
            if (i == 0) {
                i = 31;
            }
            i2 = i;
            z2 = false;
            this.rlk.a(this.cNr, this.fDG, this.czD, z2, i2);
            AppMethodBeat.o(38420);
        }
    }

    private void aNt() {
        AppMethodBeat.i(38421);
        this.kkp.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(38402);
                ab.i("MicroMsg.OnlineVideoView", "%d show loading. downloadMode %d", Integer.valueOf(OnlineVideoView.this.hashCode()), Integer.valueOf(OnlineVideoView.this.rlf));
                if (OnlineVideoView.this.rlf == 1) {
                    if (!(OnlineVideoView.this.mqj == null || OnlineVideoView.this.mqj.getVisibility() == 0)) {
                        OnlineVideoView.this.mqj.setVisibility(0);
                    }
                    if (!(OnlineVideoView.this.mqk == null || OnlineVideoView.this.mqk.getVisibility() == 8)) {
                        OnlineVideoView.this.mqk.setVisibility(8);
                    }
                }
                if (OnlineVideoView.this.rlf == 2) {
                    if (!(OnlineVideoView.this.mqk == null || OnlineVideoView.this.mqk.getVisibility() == 0)) {
                        OnlineVideoView.this.mqk.setVisibility(0);
                    }
                    if (!(OnlineVideoView.this.mqj == null || OnlineVideoView.this.mqj.getVisibility() == 8)) {
                        OnlineVideoView.this.mqj.setVisibility(8);
                    }
                }
                if (OnlineVideoView.this.rlf == 3) {
                    if (!(OnlineVideoView.this.mqk == null || OnlineVideoView.this.mqk.getVisibility() == 0)) {
                        OnlineVideoView.this.mqk.setVisibility(0);
                        OnlineVideoView.this.mqk.dKB();
                    }
                    if (!(OnlineVideoView.this.mqj == null || OnlineVideoView.this.mqj.getVisibility() == 8)) {
                        OnlineVideoView.this.mqj.setVisibility(8);
                    }
                }
                AppMethodBeat.o(38402);
            }
        });
        AppMethodBeat.o(38421);
    }

    private void bJc() {
        AppMethodBeat.i(38422);
        this.kkp.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(38403);
                if (!(OnlineVideoView.this.mqj == null || OnlineVideoView.this.mqj.getVisibility() == 8)) {
                    ab.i("MicroMsg.OnlineVideoView", "%d hide loading.", Integer.valueOf(OnlineVideoView.this.hashCode()));
                    OnlineVideoView.this.mqj.setVisibility(8);
                }
                if (!(OnlineVideoView.this.mqk == null || OnlineVideoView.this.mqk.getVisibility() == 8)) {
                    ab.i("MicroMsg.OnlineVideoView", "%d hide progress.", Integer.valueOf(OnlineVideoView.this.hashCode()));
                    OnlineVideoView.this.mqk.setVisibility(8);
                }
                AppMethodBeat.o(38403);
            }
        });
        AppMethodBeat.o(38422);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cV(boolean z) {
        AppMethodBeat.i(38423);
        if (!this.rll) {
            this.klw.ae(500, 500);
            AppMethodBeat.o(38423);
        } else if (z) {
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(38404);
                    if (!(OnlineVideoView.this.klq == null || OnlineVideoView.this.rlk == null)) {
                        OnlineVideoView.this.rlk.mm(OnlineVideoView.this.klq.getCurrentPosition() / 1000);
                    }
                    OnlineVideoView.this.rcg.ae(500, 500);
                    AppMethodBeat.o(38404);
                }
            });
            AppMethodBeat.o(38423);
        } else {
            this.rcg.ae(500, 500);
            AppMethodBeat.o(38423);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void cse() {
        AppMethodBeat.i(38424);
        this.rcg.stopTimer();
        this.klw.stopTimer();
        AppMethodBeat.o(38424);
    }

    public final void onError(int i, int i2) {
        AppMethodBeat.i(38425);
        ab.e("MicroMsg.OnlineVideoView", "%d on play video error what %d extra %d. isOnlinePlay %b isMMVideoPlayer[%b]", Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.rll), Boolean.valueOf(this.mqh));
        if (this.rll) {
            h.pYm.a(354, 230, 1, false);
        } else {
            h.pYm.a(354, 231, 1, false);
        }
        this.mqi = i2;
        csh();
        final String videoPath = this.klq.getVideoPath();
        this.rln = this.klq.getCurrentPosition() / 1000;
        if (this.rll) {
            if (i == -2) {
                this.klq.stop();
            } else if (i == -3) {
                this.rlo = i;
                this.klq.pause();
            } else {
                cse();
                this.klq.stop();
            }
            try {
                aNt();
                if (this.rlk != null) {
                    ae aeVar = this.rlk;
                    String str = aeVar.fUL + 0 + "_-1";
                    if (!aeVar.rlC.containsKey(str)) {
                        ab.i("MicroMsg.OnlineVideoViewHelper", "request all data. [%s]", aeVar.fUL);
                        o.alm();
                        com.tencent.mm.al.e.k(aeVar.fUL, 0, -1);
                        aeVar.rlC.put(str, Integer.valueOf(0));
                        h.pYm.a(354, 207, 1, false);
                        h.pYm.e(13836, Integer.valueOf(403), Long.valueOf(bo.anT()), "");
                    }
                    aeVar.fUP = 5;
                    aeVar.fUU = true;
                    aeVar.fUX = false;
                }
                csh();
                AppMethodBeat.o(38425);
                return;
            } catch (Exception e) {
                AppMethodBeat.o(38425);
                return;
            }
        }
        this.klq.stop();
        this.mqg = true;
        a(false, 0.0f);
        if (!bo.isNullOrNil(videoPath)) {
            ab.w("MicroMsg.OnlineVideoView", "%d start third player to play", Integer.valueOf(hashCode()));
            this.kkp.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(38397);
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    k.a(OnlineVideoView.this.getContext(), intent, com.tencent.mm.vfs.e.asY(videoPath), "video/*");
                    try {
                        OnlineVideoView.this.getContext().startActivity(intent);
                        AppMethodBeat.o(38397);
                    } catch (Exception e) {
                        ab.e("MicroMsg.OnlineVideoView", "startActivity fail, activity not found");
                        com.tencent.mm.ui.base.h.g(OnlineVideoView.this.getContext(), R.string.bpq, R.string.bpr);
                        AppMethodBeat.o(38397);
                    }
                }
            });
        }
        AppMethodBeat.o(38425);
    }

    public final void pL() {
        AppMethodBeat.i(38426);
        ab.i("MicroMsg.OnlineVideoView", "%d onPrepared playErrorCode[%d] onErrorPlayTimeSec[%d]", Integer.valueOf(hashCode()), Integer.valueOf(this.mqi), Integer.valueOf(this.rln));
        this.mqi = 0;
        if (this.rln > 0) {
            yI(this.rln);
            this.rln = 0;
            AppMethodBeat.o(38426);
            return;
        }
        this.rlo = 0;
        bJc();
        csg();
        this.klq.start();
        this.duration = this.klq.getDuration() / 1000;
        ab.i("MicroMsg.OnlineVideoView", "%d start play duration %d sns local id %s ", Integer.valueOf(hashCode()), Integer.valueOf(this.duration), this.czD);
        cV(false);
        AppMethodBeat.o(38426);
    }

    public final void EA() {
        AppMethodBeat.i(38427);
        ab.i("MicroMsg.OnlineVideoView", "%d on completion", Integer.valueOf(hashCode()));
        if (this.rli == null) {
            if (com.tencent.mm.compatible.util.d.iX(18) || !this.mqh) {
                yI(0);
                AppMethodBeat.o(38427);
                return;
            } else if (this.klq != null) {
                String videoPath = this.klq.getVideoPath();
                this.klq.stop();
                bq(videoPath, this.rll);
            }
        }
        AppMethodBeat.o(38427);
    }

    public final int dG(int i, int i2) {
        return 0;
    }

    public final void dH(int i, int i2) {
    }

    private boolean bwE() {
        AppMethodBeat.i(38428);
        if (this.rll) {
            g.RQ();
            boolean z = g.RP().Ry().getBoolean(com.tencent.mm.storage.ac.a.USERINFO_VIDEO_NEED_RESET_EXTRACTOR_BOOLEAN, false);
            AppMethodBeat.o(38428);
            return z;
        }
        AppMethodBeat.o(38428);
        return false;
    }

    public final void bq(String str, boolean z) {
        AppMethodBeat.i(38429);
        ab.i("MicroMsg.OnlineVideoView", "%d prepare video isOnlinePlay %b filePath %s", Integer.valueOf(hashCode()), Boolean.valueOf(z), str);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.OnlineVideoView", "%d prepare video but filepath is null.", Integer.valueOf(hashCode()));
            AppMethodBeat.o(38429);
            return;
        }
        this.rll = z;
        if (this.klq != null) {
            if (this.rlo != -3) {
                if (this.klq instanceof VideoPlayerTextureView) {
                    ((VideoPlayerTextureView) this.klq).setNeedResetExtractor(bwE());
                    ((VideoPlayerTextureView) this.klq).setIsOnlineVideoType(z);
                }
                this.klq.setOneTimeVideoTextureUpdateCallback(this.rlb);
                this.klq.setVideoPath(str);
                a(true, 0.0f);
            } else {
                ab.i("MicroMsg.OnlineVideoView", "%d prepare video reset source", Integer.valueOf(hashCode()));
                if (this.klq instanceof VideoPlayerTextureView) {
                    ((VideoPlayerTextureView) this.klq).dlA();
                }
                yI(this.rln);
            }
        }
        g.RQ();
        if (((Integer) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_LOCAL_SIGHT_DEBUGINFO_INT_SYNC, Integer.valueOf(0))).intValue() == 1) {
            this.mqf.setText(com.tencent.mm.plugin.sight.base.d.RK(str));
            this.mqf.setVisibility(0);
        }
        AppMethodBeat.o(38429);
    }

    public final boolean csf() {
        boolean z = true;
        AppMethodBeat.i(38430);
        ab.i("MicroMsg.OnlineVideoView", "%d resumeByDataGain", Integer.valueOf(hashCode()));
        if (!this.klq.isPlaying()) {
            csg();
            z = this.klq.start();
            bJc();
        }
        AppMethodBeat.o(38430);
        return z;
    }

    public final void akX() {
        AppMethodBeat.i(38431);
        ab.i("MicroMsg.OnlineVideoView", "%d pauseByDataBlock", Integer.valueOf(hashCode()));
        csh();
        aNt();
        if (this.klq.isPlaying()) {
            ab.i("MicroMsg.OnlineVideoView", "%d pause play", Integer.valueOf(hashCode()));
            csh();
            this.klq.pause();
        }
        AppMethodBeat.o(38431);
    }

    public final void yI(int i) {
        AppMethodBeat.i(38432);
        ab.i("MicroMsg.OnlineVideoView", "%d seek second %d afterSeekPlay %b", Integer.valueOf(hashCode()), Integer.valueOf(i), Boolean.TRUE);
        this.rlo = 0;
        bJc();
        this.klq.d((double) (i * 1000), true);
        cV(false);
        AppMethodBeat.o(38432);
    }

    private void csg() {
        AppMethodBeat.i(38433);
        this.rlu = bo.anU();
        ab.d("MicroMsg.OnlineVideoView", "%d notePlayVideo notePlayVideo %d ", Integer.valueOf(hashCode()), Long.valueOf(this.rlu));
        AppMethodBeat.o(38433);
    }

    private void csh() {
        AppMethodBeat.i(38434);
        if (this.rlu > 0) {
            this.rlv = (int) (((long) this.rlv) + ((bo.anU() - this.rlu) / 1000));
        }
        ab.i("MicroMsg.OnlineVideoView", "%d notePauseVideo playVideoDuration %d ", Integer.valueOf(hashCode()), Integer.valueOf(this.rlv));
        this.rlu = 0;
        AppMethodBeat.o(38434);
    }

    public int getPlayVideoDuration() {
        AppMethodBeat.i(38435);
        if (this.rlv < 0) {
            this.rlv = 0;
        }
        ab.i("MicroMsg.OnlineVideoView", "%d get play video duration [%d]", Integer.valueOf(hashCode()), Integer.valueOf(this.rlv));
        int i = this.rlv;
        AppMethodBeat.o(38435);
        return i;
    }

    public int getPlayErrorCode() {
        return this.mqi;
    }

    public int getUiStayTime() {
        int i;
        if (this.rlq <= 0 || this.rlp <= 0) {
            i = 0;
        } else {
            i = (int) (this.rlq - this.rlp);
        }
        if (i < 0) {
            return 0;
        }
        return i;
    }

    static /* synthetic */ void csi() {
        AppMethodBeat.i(38436);
        h.pYm.a(354, 225, 1, false);
        AppMethodBeat.o(38436);
    }

    static /* synthetic */ void csj() {
        AppMethodBeat.i(38437);
        h.pYm.a(354, 226, 1, false);
        AppMethodBeat.o(38437);
    }

    static /* synthetic */ void p(OnlineVideoView onlineVideoView) {
        AppMethodBeat.i(38442);
        ab.i("MicroMsg.OnlineVideoView", "%d save video, download finish path %s", Integer.valueOf(onlineVideoView.hashCode()), aq.a(onlineVideoView.czD, onlineVideoView.cNr));
        if (bo.isNullOrNil(aq.a(onlineVideoView.czD, onlineVideoView.cNr))) {
            onlineVideoView.rlh = true;
            onlineVideoView.C(true, 34);
            onlineVideoView.aNt();
            h.pYm.a(354, 220, 1, false);
            AppMethodBeat.o(38442);
            return;
        }
        onlineVideoView.csd();
        AppMethodBeat.o(38442);
    }
}

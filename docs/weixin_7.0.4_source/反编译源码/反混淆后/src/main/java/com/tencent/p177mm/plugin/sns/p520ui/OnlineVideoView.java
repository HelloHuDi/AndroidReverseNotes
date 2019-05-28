package com.tencent.p177mm.plugin.sns.p520ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C42192d;
import com.tencent.p177mm.model.C42192d.C42190a;
import com.tencent.p177mm.modelcontrol.C42204d;
import com.tencent.p177mm.modelvideo.C26494u;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.p1510r.C35973a;
import com.tencent.p177mm.p187al.C45150e;
import com.tencent.p177mm.p230g.p231a.C32594lp;
import com.tencent.p177mm.p230g.p231a.C32626rb;
import com.tencent.p177mm.p230g.p231a.C37793re;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p230g.p231a.C9463sb;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.MMPinProgressBtn;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.p468n.C43332b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sight.base.C21846d;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C34957aq;
import com.tencent.p177mm.plugin.sns.model.C3892an;
import com.tencent.p177mm.plugin.sns.model.C43558b.C43559b;
import com.tencent.p177mm.plugin.sns.p1558j.C39739a;
import com.tencent.p177mm.plugin.sns.p520ui.C29177ae.C29179a;
import com.tencent.p177mm.plugin.sns.p520ui.C29177ae.C291801;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14980e;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14981a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.VideoPlayerTextureView;
import com.tencent.p177mm.pluginsdk.p597ui.tools.VideoTextureView;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.sdk.p1574f.C40612a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C15429k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C44222az;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.plugin.sns.ui.OnlineVideoView */
public class OnlineVideoView extends RelativeLayout implements C42190a, C29179a, C14981a {
    private int cNW;
    private boolean cNX;
    private int cNY;
    private bau cNr;
    private String czD;
    private int duration;
    private boolean eif;
    private int fDG;
    private C42192d iaf;
    C7306ak kkp;
    private C14979e klq;
    private C7564ap klw;
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
    private C43332b orK;
    private C44222az qFT;
    private C4884c qNa;
    private C7564ap rcg;
    private boolean rkY;
    private C14980e rlb;
    private int rlf;
    String rlg;
    private boolean rlh;
    private C29113a rli;
    private TextView rlj;
    private C29177ae rlk;
    private boolean rll;
    private boolean rlm;
    private int rln;
    private int rlo;
    private long rlp;
    private long rlq;
    private C43559b rlr;
    private C4884c rls;
    private C4884c rlt;
    private long rlu;
    private int rlv;

    /* renamed from: com.tencent.mm.plugin.sns.ui.OnlineVideoView$6 */
    class C39686 implements C14980e {
        C39686() {
        }

        public final void bQL() {
            AppMethodBeat.m2504i(38395);
            C4990ab.m7417i("MicroMsg.OnlineVideoView", "%d on texture update.", Integer.valueOf(OnlineVideoView.this.hashCode()));
            try {
                OnlineVideoView.m57534m(OnlineVideoView.this);
                AppMethodBeat.m2505o(38395);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.OnlineVideoView", "texture view update. error " + e.toString());
                AppMethodBeat.m2505o(38395);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.OnlineVideoView$16 */
    class C1348916 implements C5015a {
        C1348916() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(38405);
            if (OnlineVideoView.this.rlk == null || OnlineVideoView.this.klq == null) {
                AppMethodBeat.m2505o(38405);
                return false;
            }
            if (((View) OnlineVideoView.this.klq).getAlpha() < 1.0f) {
                OnlineVideoView.m57534m(OnlineVideoView.this);
            }
            if (OnlineVideoView.this.klq.isPlaying()) {
                OnlineVideoView.m57535n(OnlineVideoView.this);
            }
            try {
                Object obj;
                if (C5046bo.isNullOrNil(OnlineVideoView.this.rlk.fUL)) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj == null) {
                    AppMethodBeat.m2505o(38405);
                    return false;
                }
                boolean mm = OnlineVideoView.this.rlk.mo47340mm(OnlineVideoView.this.klq.getCurrentPosition() / 1000);
                AppMethodBeat.m2505o(38405);
                return mm;
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.OnlineVideoView", "online video timer check error : " + e.toString());
                AppMethodBeat.m2505o(38405);
                return false;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.OnlineVideoView$4 */
    class C134914 extends C4884c<C37793re> {
        C134914() {
            AppMethodBeat.m2504i(38390);
            this.xxI = C37793re.class.getName().hashCode();
            AppMethodBeat.m2505o(38390);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(38391);
            final C37793re c37793re = (C37793re) c4883b;
            C4990ab.m7417i("MicroMsg.OnlineVideoView", "%d sns flip ui event. local id[%s, %s] opcode %d hadUiEvent %b", Integer.valueOf(OnlineVideoView.this.hashCode()), c37793re.cNj.czD, OnlineVideoView.this.czD, Integer.valueOf(c37793re.cNj.cAd), Boolean.valueOf(OnlineVideoView.this.rlm));
            if (c37793re.cNj.cAd == 2) {
                if (c37793re.cNj.context != null && c37793re.cNj.context == OnlineVideoView.this.mContext) {
                    OnlineVideoView.this.rlm = false;
                    OnlineVideoView.this.csc();
                    OnlineVideoView.this.onDestroy();
                }
                AppMethodBeat.m2505o(38391);
            } else {
                if (c37793re.cNj.cAd == 1) {
                    OnlineVideoView.this.kkp.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(38389);
                            if (!C5046bo.isEqual(c37793re.cNj.czD, OnlineVideoView.this.czD)) {
                                OnlineVideoView.this.rlm = false;
                                OnlineVideoView.this.csc();
                                OnlineVideoView.this.onDestroy();
                                AppMethodBeat.m2505o(38389);
                            } else if (OnlineVideoView.this.rlm) {
                                OnlineVideoView.this.requestLayout();
                                AppMethodBeat.m2505o(38389);
                            } else {
                                OnlineVideoView.this.rlm = true;
                                OnlineVideoView.this.onResume();
                                AppMethodBeat.m2505o(38389);
                            }
                        }
                    });
                }
                AppMethodBeat.m2505o(38391);
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.OnlineVideoView$5 */
    class C134935 extends C4884c<C32594lp> {
        C134935() {
            AppMethodBeat.m2504i(38392);
            this.xxI = C32594lp.class.getName().hashCode();
            AppMethodBeat.m2505o(38392);
        }

        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        private boolean m21661a(C32594lp c32594lp) {
            AppMethodBeat.m2504i(38393);
            if (OnlineVideoView.this.rlk == null) {
                C4990ab.m7421w("MicroMsg.OnlineVideoView", "%d online video helper is null.", Integer.valueOf(OnlineVideoView.this.hashCode()));
                AppMethodBeat.m2505o(38393);
            } else {
                try {
                    if (!OnlineVideoView.this.rlk.mo47334ZA(c32594lp.cHq.cHr)) {
                        AppMethodBeat.m2505o(38393);
                    } else if (c32594lp.cHq.retCode == -21112) {
                        OnlineVideoView onlineVideoView = OnlineVideoView.this;
                        C7060h.pYm.mo8378a(354, 218, 1, false);
                        onlineVideoView.kkp.post(new C350129());
                        AppMethodBeat.m2505o(38393);
                    } else if (c32594lp.cHq.retCode == 0 || c32594lp.cHq.retCode == -21006) {
                        int i;
                        int i2;
                        C29177ae k;
                        switch (c32594lp.cHq.cAd) {
                            case 1:
                                C29177ae k2 = OnlineVideoView.this.rlk;
                                long j = (long) c32594lp.cHq.offset;
                                long j2 = c32594lp.cHq.cHs;
                                boolean z = c32594lp.cHq.cHt;
                                C4990ab.m7417i("MicroMsg.OnlineVideoViewHelper", "deal moov ready moovPos %d, timeDuration %d, cdnMediaId %s startDownload[%d %d]", Long.valueOf(j), Integer.valueOf(k2.fUR), k2.fUL, Long.valueOf(j2), Long.valueOf(k2.egA));
                                if (k2.fUR != 0) {
                                    C4990ab.m7420w("MicroMsg.OnlineVideoViewHelper", "moov had callback, do nothing.");
                                } else {
                                    if (j2 <= k2.egA) {
                                        j2 = k2.egA;
                                    }
                                    k2.egA = j2;
                                    k2.rlG = C5046bo.anU();
                                    try {
                                        if (k2.fUQ == null) {
                                            C4990ab.m7420w("MicroMsg.OnlineVideoViewHelper", "parser is null, thread is error.");
                                        } else if (k2.fUQ.mo21148v(k2.fUM, j)) {
                                            k2.fUR = k2.fUQ.gkm;
                                            C4990ab.m7417i("MicroMsg.OnlineVideoViewHelper", "mp4 parse moov success. duration %d cdnMediaId %s isFastStart %b", Integer.valueOf(k2.fUR), k2.fUL, Boolean.valueOf(z));
                                            if (!z) {
                                                C5004al.m7441d(new C291801());
                                            }
                                            if (k2.fUS == -1) {
                                                k2.fUP = 1;
                                            } else {
                                                k2.fUP = 2;
                                            }
                                            C7060h.pYm.mo8378a(354, 204, 1, false);
                                        } else {
                                            C4990ab.m7421w("MicroMsg.OnlineVideoViewHelper", "mp4 parse moov error. cdnMediaId %s", k2.fUL);
                                            C37961o.alm();
                                            C45150e.m83031k(k2.fUL, 0, -1);
                                            C7060h.pYm.mo8378a(354, 205, 1, false);
                                            C7060h.pYm.mo8381e(13836, Integer.valueOf(402), Long.valueOf(C5046bo.anT()), "");
                                        }
                                    } catch (Exception e) {
                                        C4990ab.m7412e("MicroMsg.OnlineVideoViewHelper", "deal moov ready error: " + e.toString());
                                    }
                                }
                                OnlineVideoView.this.rll = true;
                                break;
                            case 2:
                                C29177ae k3 = OnlineVideoView.this.rlk;
                                String str = c32594lp.cHq.cHr;
                                i = c32594lp.cHq.offset;
                                i2 = c32594lp.cHq.length;
                                k3.fUY = false;
                                if (i < 0 || i2 < 0) {
                                    C4990ab.m7421w("MicroMsg.OnlineVideoViewHelper", "deal data available error offset[%d], length[%d]", Integer.valueOf(i), Integer.valueOf(i2));
                                } else if (k3.mo47334ZA(str)) {
                                    Integer num = (Integer) k3.rlC.get(k3.fUL + i + "_" + i2);
                                    if (num == null || num.intValue() <= 0) {
                                        try {
                                            k3.fUV = k3.fUQ.mo21147cK(i, i2);
                                        } catch (Exception e2) {
                                            C4990ab.m7412e("MicroMsg.OnlineVideoViewHelper", "deal data available file pos to video time error: " + e2.toString());
                                        }
                                    } else {
                                        k3.fUV = num.intValue();
                                    }
                                    C4990ab.m7417i("MicroMsg.OnlineVideoViewHelper", "deal data available. offset[%d] length[%d] cachePlayTime[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(k3.fUV));
                                }
                                if (c32594lp.cHq.length > 0) {
                                    OnlineVideoView.this.mo55603cV(true);
                                    break;
                                }
                                break;
                            case 3:
                                OnlineVideoView.this.mo55603cV(true);
                                break;
                            case 4:
                                C4990ab.m7417i("MicroMsg.OnlineVideoView", "%d download finish. cdnMediaId %s sendReqCode %d favFromScene %d", Integer.valueOf(OnlineVideoView.this.hashCode()), c32594lp.cHq.cHr, Integer.valueOf(OnlineVideoView.this.cNY), Integer.valueOf(OnlineVideoView.this.cNW));
                                k = OnlineVideoView.this.rlk;
                                C4990ab.m7417i("MicroMsg.OnlineVideoViewHelper", "deal stream finish. playStatus %d cdnMediaId %s", Integer.valueOf(k.fUP), k.fUL);
                                k.fUY = false;
                                k.fUO = 3;
                                C7060h.pYm.mo8378a(354, 206, 1, false);
                                if (k.fUP == 0) {
                                    C4990ab.m7420w("MicroMsg.OnlineVideoViewHelper", "it had not moov callback and download finish start to play video.");
                                    k.csl();
                                } else if (k.fUP == 5) {
                                    C4990ab.m7420w("MicroMsg.OnlineVideoViewHelper", "it had play error, it request all video data finish, start to play." + k.fUL);
                                    k.csl();
                                }
                                if (OnlineVideoView.this.cNY <= 0) {
                                    if (OnlineVideoView.this.cNW <= 0) {
                                        if (!OnlineVideoView.this.rlh) {
                                            OnlineVideoView.this.mo55603cV(true);
                                            break;
                                        }
                                        OnlineVideoView.m57535n(OnlineVideoView.this);
                                        OnlineVideoView.m57544w(OnlineVideoView.this);
                                        break;
                                    }
                                    OnlineVideoView.m57535n(OnlineVideoView.this);
                                    OnlineVideoView.m57523b(OnlineVideoView.this, OnlineVideoView.this.cNW, OnlineVideoView.this.cNX);
                                    break;
                                }
                                OnlineVideoView.m57535n(OnlineVideoView.this);
                                OnlineVideoView.m57522b(OnlineVideoView.this, OnlineVideoView.this.cNY);
                                break;
                            case 5:
                                if (OnlineVideoView.this.rlf != 1) {
                                    if (OnlineVideoView.this.rlf == 2) {
                                        OnlineVideoView.m57516a(OnlineVideoView.this, c32594lp.cHq.offset, c32594lp.cHq.length);
                                        break;
                                    }
                                }
                                k = OnlineVideoView.this.rlk;
                                String str2 = c32594lp.cHq.cHr;
                                i = c32594lp.cHq.offset;
                                i2 = c32594lp.cHq.length;
                                if (k.mo47334ZA(str2)) {
                                    k.progress = i;
                                    k.total = i2;
                                    k.rlE = (k.progress * 100) / k.total;
                                    C4990ab.m7417i("MicroMsg.OnlineVideoViewHelper", "deal video[%s] progress callback[%d, %d]. downloadedPercent[%d]", k.fUL, Integer.valueOf(k.progress), Integer.valueOf(k.total), Integer.valueOf(k.rlE));
                                }
                                if (k.rlE >= 100) {
                                    k.fUO = 3;
                                    break;
                                }
                                break;
                            case 6:
                                C4990ab.m7417i("MicroMsg.OnlineVideoViewHelper", "deal had dup video. cdnMediaId %s", OnlineVideoView.this.rlk.fUL);
                                k.csl();
                                break;
                            default:
                                C4990ab.m7421w("MicroMsg.OnlineVideoView", "%d unknown event opcode %d", Integer.valueOf(OnlineVideoView.this.hashCode()), Integer.valueOf(c32594lp.cHq.cAd));
                                break;
                        }
                        AppMethodBeat.m2505o(38393);
                    } else {
                        C4990ab.m7421w("MicroMsg.OnlineVideoView", "%d stream download online video error. retCode %d ", Integer.valueOf(OnlineVideoView.this.hashCode()), Integer.valueOf(c32594lp.cHq.retCode));
                        AppMethodBeat.m2505o(38393);
                    }
                } catch (Exception e22) {
                    C4990ab.m7412e("MicroMsg.OnlineVideoView", "online video callback error: " + e22.toString());
                }
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.OnlineVideoView$15 */
    class C2199815 implements Runnable {
        C2199815() {
        }

        public final void run() {
            AppMethodBeat.m2504i(38404);
            if (!(OnlineVideoView.this.klq == null || OnlineVideoView.this.rlk == null)) {
                OnlineVideoView.this.rlk.mo47340mm(OnlineVideoView.this.klq.getCurrentPosition() / 1000);
            }
            OnlineVideoView.this.rcg.mo16770ae(500, 500);
            AppMethodBeat.m2505o(38404);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.OnlineVideoView$7 */
    class C219997 implements C43332b {
        C219997() {
        }

        public final long bOR() {
            AppMethodBeat.m2504i(38396);
            C4990ab.m7417i("MicroMsg.OnlineVideoView", "%d sns video get online cache", Integer.valueOf(OnlineVideoView.this.hashCode()));
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_VIDEO_NEED_RESET_EXTRACTOR_BOOLEAN, Boolean.TRUE);
            try {
                if (OnlineVideoView.this.rll && OnlineVideoView.this.rlk != null) {
                    long j = (long) OnlineVideoView.this.rlk.fUV;
                    AppMethodBeat.m2505o(38396);
                    return j;
                }
            } catch (Exception e) {
            }
            AppMethodBeat.m2505o(38396);
            return 0;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.OnlineVideoView$14 */
    class C2911114 implements Runnable {
        C2911114() {
        }

        public final void run() {
            AppMethodBeat.m2504i(38403);
            if (!(OnlineVideoView.this.mqj == null || OnlineVideoView.this.mqj.getVisibility() == 8)) {
                C4990ab.m7417i("MicroMsg.OnlineVideoView", "%d hide loading.", Integer.valueOf(OnlineVideoView.this.hashCode()));
                OnlineVideoView.this.mqj.setVisibility(8);
            }
            if (!(OnlineVideoView.this.mqk == null || OnlineVideoView.this.mqk.getVisibility() == 8)) {
                C4990ab.m7417i("MicroMsg.OnlineVideoView", "%d hide progress.", Integer.valueOf(OnlineVideoView.this.hashCode()));
                OnlineVideoView.this.mqk.setVisibility(8);
            }
            AppMethodBeat.m2505o(38403);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.OnlineVideoView$17 */
    class C2911217 implements C5015a {
        C2911217() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(38406);
            if (OnlineVideoView.this.klq == null) {
                AppMethodBeat.m2505o(38406);
                return false;
            }
            if (((View) OnlineVideoView.this.klq).getAlpha() < 1.0f) {
                OnlineVideoView.m57534m(OnlineVideoView.this);
            }
            if (OnlineVideoView.this.klq.isPlaying()) {
                OnlineVideoView.m57535n(OnlineVideoView.this);
                OnlineVideoView.this.klq.getCurrentPosition();
            }
            AppMethodBeat.m2505o(38406);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.OnlineVideoView$a */
    public interface C29113a {
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.OnlineVideoView$2 */
    class C350082 implements C43559b {
        C350082() {
        }

        /* renamed from: Xw */
        public final void mo17655Xw(String str) {
        }

        /* renamed from: bj */
        public final void mo8771bj(String str, boolean z) {
        }

        public final void cmu() {
        }

        /* renamed from: bk */
        public final void mo8772bk(final String str, final boolean z) {
            AppMethodBeat.m2504i(38386);
            OnlineVideoView.this.kkp.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(38385);
                    C4990ab.m7417i("MicroMsg.OnlineVideoView", "%d weixin download finish[%b], go to prepare video", Integer.valueOf(OnlineVideoView.this.hashCode()), Boolean.valueOf(z));
                    if (OnlineVideoView.this.cNr != null && z && C5046bo.isEqual(OnlineVideoView.this.cNr.f17915Id, str)) {
                        C34957aq.m57419gb(OnlineVideoView.this.czD, "");
                        String a = C34957aq.m57415a(OnlineVideoView.this.czD, OnlineVideoView.this.cNr);
                        if (!C5046bo.isNullOrNil(a)) {
                            OnlineVideoView.this.mo47342bq(a, false);
                        }
                    }
                    AppMethodBeat.m2505o(38385);
                }
            }, 100);
            AppMethodBeat.m2505o(38386);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.OnlineVideoView$3 */
    class C350093 extends C4884c<C9463sb> {
        C350093() {
            AppMethodBeat.m2504i(38387);
            this.xxI = C9463sb.class.getName().hashCode();
            AppMethodBeat.m2505o(38387);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(38388);
            C9463sb c9463sb = (C9463sb) c4883b;
            C4990ab.m7417i("MicroMsg.OnlineVideoView", "%d sns video menu event local id[%s, %s]", Integer.valueOf(OnlineVideoView.this.hashCode()), c9463sb.cNV.czD, OnlineVideoView.this.czD);
            if (C5046bo.isEqual(c9463sb.cNV.czD, OnlineVideoView.this.czD)) {
                if (c9463sb.cNV.cAd == 1) {
                    OnlineVideoView.m57515a(OnlineVideoView.this, c9463sb.cNV.cNY);
                } else if (c9463sb.cNV.cAd == 2) {
                    OnlineVideoView.m57517a(OnlineVideoView.this, c9463sb.cNV.cNW, c9463sb.cNV.cNX);
                } else if (c9463sb.cNV.cAd == 3) {
                    OnlineVideoView.m57537p(OnlineVideoView.this);
                }
            }
            AppMethodBeat.m2505o(38388);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.OnlineVideoView$13 */
    class C3501113 implements Runnable {
        C3501113() {
        }

        public final void run() {
            AppMethodBeat.m2504i(38402);
            C4990ab.m7417i("MicroMsg.OnlineVideoView", "%d show loading. downloadMode %d", Integer.valueOf(OnlineVideoView.this.hashCode()), Integer.valueOf(OnlineVideoView.this.rlf));
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
            AppMethodBeat.m2505o(38402);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.OnlineVideoView$9 */
    class C350129 implements Runnable {
        C350129() {
        }

        public final void run() {
            AppMethodBeat.m2504i(38398);
            C4990ab.m7421w("MicroMsg.OnlineVideoView", "%d deal sns video change isOnlinePlay[%b]", Integer.valueOf(OnlineVideoView.this.hashCode()), Boolean.valueOf(OnlineVideoView.this.rll));
            if (OnlineVideoView.this.rll) {
                OnlineVideoView.m57546y(OnlineVideoView.this);
                OnlineVideoView.this.klq.stop();
                OnlineVideoView.this.cse();
                boolean deleteFile = C5730e.deleteFile(C34957aq.m57411D(OnlineVideoView.this.cNr));
                if (OnlineVideoView.this.rlk != null) {
                    OnlineVideoView.this.rlk.csk();
                    OnlineVideoView.this.rlk.clear();
                    OnlineVideoView.this.rlk = new C29177ae(OnlineVideoView.this);
                }
                C4990ab.m7417i("MicroMsg.OnlineVideoView", "%d delete video file[%b] [%s]", Integer.valueOf(OnlineVideoView.this.hashCode()), Boolean.valueOf(deleteFile), r0);
                OnlineVideoView.this.rlo = 0;
                OnlineVideoView.m57510A(OnlineVideoView.this);
            }
            AppMethodBeat.m2505o(38398);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.OnlineVideoView$10 */
    class C3501410 implements Runnable {
        C3501410() {
        }

        public final void run() {
            AppMethodBeat.m2504i(38399);
            if (OnlineVideoView.this.klq != null) {
                if (C5046bo.isNullOrNil(OnlineVideoView.this.klq.getVideoPath())) {
                    C4990ab.m7417i("MicroMsg.OnlineVideoView", "%d had not set video path to play", Integer.valueOf(OnlineVideoView.this.hashCode()));
                    String a = C34957aq.m57415a(OnlineVideoView.this.czD, OnlineVideoView.this.cNr);
                    if (!C5046bo.isNullOrNil(a)) {
                        OnlineVideoView.this.mo47342bq(a, false);
                    }
                    AppMethodBeat.m2505o(38399);
                    return;
                } else if (!OnlineVideoView.this.klq.isPlaying()) {
                    OnlineVideoView.this.klq.start();
                    AppMethodBeat.m2505o(38399);
                    return;
                }
            }
            AppMethodBeat.m2505o(38399);
        }
    }

    /* renamed from: A */
    static /* synthetic */ void m57510A(OnlineVideoView onlineVideoView) {
        AppMethodBeat.m2504i(38448);
        onlineVideoView.bwD();
        AppMethodBeat.m2505o(38448);
    }

    /* renamed from: b */
    static /* synthetic */ void m57522b(OnlineVideoView onlineVideoView, int i) {
        AppMethodBeat.m2504i(38443);
        onlineVideoView.m57512DS(i);
        AppMethodBeat.m2505o(38443);
    }

    /* renamed from: b */
    static /* synthetic */ void m57523b(OnlineVideoView onlineVideoView, int i, boolean z) {
        AppMethodBeat.m2504i(38444);
        onlineVideoView.m57520af(i, z);
        AppMethodBeat.m2505o(38444);
    }

    /* renamed from: m */
    static /* synthetic */ void m57534m(OnlineVideoView onlineVideoView) {
        AppMethodBeat.m2504i(38438);
        onlineVideoView.m57518a(true, 1.0f);
        AppMethodBeat.m2505o(38438);
    }

    /* renamed from: n */
    static /* synthetic */ void m57535n(OnlineVideoView onlineVideoView) {
        AppMethodBeat.m2504i(38439);
        onlineVideoView.bJc();
        AppMethodBeat.m2505o(38439);
    }

    /* renamed from: w */
    static /* synthetic */ void m57544w(OnlineVideoView onlineVideoView) {
        AppMethodBeat.m2504i(38445);
        onlineVideoView.csd();
        AppMethodBeat.m2505o(38445);
    }

    /* renamed from: y */
    static /* synthetic */ void m57546y(OnlineVideoView onlineVideoView) {
        AppMethodBeat.m2504i(38447);
        onlineVideoView.csh();
        AppMethodBeat.m2505o(38447);
    }

    public OnlineVideoView(Context context) {
        this(context, null);
    }

    public OnlineVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OnlineVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(38407);
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
        this.kkp = new C7306ak(Looper.getMainLooper());
        this.rcg = new C7564ap(new C1348916(), true);
        this.klw = new C7564ap(new C2911217(), true);
        this.rlr = new C350082();
        this.rls = new C350093();
        this.rlt = new C134914();
        this.qNa = new C134935();
        this.rlb = new C39686();
        this.orK = new C219997();
        this.mContext = context;
        C4990ab.m7417i("MicroMsg.OnlineVideoView", "%d ui init view.", Integer.valueOf(hashCode()));
        LayoutInflater.from(context).inflate(2130970831, this);
        this.mmB = (ImageView) findViewById(2131822133);
        this.mmW = (RelativeLayout) findViewById(2131822134);
        this.rlj = (TextView) findViewById(2131822135);
        this.rlj.setVisibility(8);
        this.mqk = (MMPinProgressBtn) findViewById(2131822136);
        this.mqj = (ProgressBar) findViewById(2131821891);
        this.mqf = (TextView) findViewById(2131822138);
        C42204d.afF();
        if (C42204d.afO()) {
            this.mqh = true;
            this.klq = new VideoPlayerTextureView(context);
            ((VideoPlayerTextureView) this.klq).setIOnlineCache(this.orK);
            ((VideoPlayerTextureView) this.klq).setOpenWithNoneSurface(true);
            C7060h.pYm.mo8378a(354, 148, 1, false);
        } else {
            this.mqh = false;
            this.klq = new VideoTextureView(context);
            C7060h.pYm.mo8378a(354, 149, 1, false);
        }
        this.klq.setVideoCallback(this);
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.addRule(13);
        this.mmW.addView((View) this.klq, layoutParams);
        m57518a(false, 0.0f);
        AppMethodBeat.m2505o(38407);
    }

    public final void csb() {
        AppMethodBeat.m2504i(38408);
        C4990ab.m7411d("MicroMsg.OnlineVideoView", "%d register sns ui event", Integer.valueOf(hashCode()));
        C4879a.xxA.mo10052c(this.rlt);
        AppMethodBeat.m2505o(38408);
    }

    public final void csc() {
        AppMethodBeat.m2504i(38409);
        C4990ab.m7411d("MicroMsg.OnlineVideoView", "%d unRegister sns ui event", Integer.valueOf(hashCode()));
        C4879a.xxA.mo10053d(this.rlt);
        AppMethodBeat.m2505o(38409);
    }

    /* renamed from: a */
    public final void mo55602a(bau bau, String str, int i) {
        AppMethodBeat.m2504i(38410);
        this.czD = str;
        this.fDG = i;
        C44222az dtl = C44222az.dtl();
        dtl.oyB = this.fDG;
        this.qFT = dtl;
        if (this.cNr != bau) {
            this.cNr = bau;
            boolean b = C13373af.cnC().mo37457b(this.cNr, this.mmB, (int) C25738R.drawable.abd, this.mContext.hashCode(), this.qFT);
            C4990ab.m7417i("MicroMsg.OnlineVideoView", "%d fresh thumb image %b", Integer.valueOf(hashCode()), Boolean.valueOf(b));
        }
        this.mOO = false;
        C4990ab.m7417i("MicroMsg.OnlineVideoView", "%d set video data[%s, %d] isPreview %b ", Integer.valueOf(hashCode()), this.czD, Integer.valueOf(this.fDG), Boolean.valueOf(this.mOO));
        AppMethodBeat.m2505o(38410);
    }

    public void setVideoCallback(C29113a c29113a) {
        this.rli = c29113a;
    }

    public void setMute(boolean z) {
        AppMethodBeat.m2504i(38411);
        this.eif = z;
        this.klq.setMute(this.eif);
        AppMethodBeat.m2505o(38411);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(38412);
        C4990ab.m7411d("MicroMsg.OnlineVideoView", "%d on resume %s", Integer.valueOf(hashCode()), C5046bo.dpG());
        this.rlp = C5046bo.anU();
        if (this.rlk == null) {
            C4990ab.m7417i("MicroMsg.OnlineVideoView", "%d logic init, create new helper and add listener.", Integer.valueOf(hashCode()));
            this.rlk = new C29177ae(this);
            C4879a.xxA.mo10052c(this.qNa);
            C4879a.xxA.mo10052c(this.rls);
            C13373af.cnA().mo69136a(this.rlr);
            this.iaf = new C42192d();
            this.iaf.mo67732a(this);
            if (C35973a.m59175Cc() != null) {
                C35973a.m59175Cc().mo4649Id();
            }
        }
        if (!this.mqg) {
            bwD();
        }
        this.rkY = true;
        AppMethodBeat.m2505o(38412);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(38413);
        C4990ab.m7411d("MicroMsg.OnlineVideoView", "%d on pause %s ", Integer.valueOf(hashCode()), C5046bo.dpG());
        cse();
        if (this.klq != null) {
            this.klq.stop();
        }
        AppMethodBeat.m2505o(38413);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(38414);
        C4990ab.m7411d("MicroMsg.OnlineVideoView", "%d on destroy %s", Integer.valueOf(hashCode()), C5046bo.dpG());
        this.rlq = C5046bo.anU();
        C4990ab.m7417i("MicroMsg.OnlineVideoView", "%d logic unInit", Integer.valueOf(hashCode()));
        csh();
        this.klq.stop();
        C4879a.xxA.mo10053d(this.qNa);
        C4879a.xxA.mo10053d(this.rls);
        C13373af.cnA().mo69142b(this.rlr);
        cse();
        this.kkp.removeCallbacksAndMessages(null);
        if (this.rlk != null) {
            this.rlk.csk();
            this.rlk.clear();
        }
        if (C35973a.m59175Cc() != null) {
            C35973a.m59175Cc().mo4648Ic();
        }
        if (this.iaf != null) {
            this.iaf.mo67733cy(false);
        }
        this.iaf = null;
        this.cNr = null;
        this.czD = null;
        this.rlk = null;
        this.rlo = 0;
        AppMethodBeat.m2505o(38414);
    }

    /* renamed from: DS */
    private void m57512DS(int i) {
        AppMethodBeat.m2504i(38415);
        String str = C3892an.m6198fZ(C13373af.getAccSnsPath(), this.cNr.f17915Id) + C29036i.m46108e(this.cNr);
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("image_path", str);
        intent.putExtra("Retr_Msg_Type", 11);
        C4990ab.m7417i("MicroMsg.OnlineVideoView", "send video path %s reqCode %d", str, Integer.valueOf(i));
        C25985d.m41466b(this.mContext, ".ui.transmit.SelectConversationUI", intent, i);
        this.cNY = 0;
        AppMethodBeat.m2505o(38415);
    }

    /* renamed from: af */
    private void m57520af(final int i, final boolean z) {
        AppMethodBeat.m2504i(38416);
        this.kkp.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(38384);
                C46236n YT = C13373af.cnF().mo62918YT(OnlineVideoView.this.czD);
                if (YT == null) {
                    AppMethodBeat.m2505o(38384);
                    return;
                }
                C4990ab.m7417i("MicroMsg.OnlineVideoView", "fav download video[%s] farFromScene %d isFromMain %b", OnlineVideoView.this.czD, Integer.valueOf(i), Boolean.valueOf(z));
                C45316cl c45316cl = new C45316cl();
                c45316cl.cvA.cvH = i;
                c45316cl.cvA.activity = (Activity) OnlineVideoView.this.mContext;
                C39739a.m67958a(c45316cl, YT);
                C4879a.xxA.mo10055m(c45316cl);
                if (c45316cl.cvB.ret == 0) {
                    OnlineVideoView.csi();
                } else {
                    OnlineVideoView.csj();
                }
                if (z) {
                    C32626rb c32626rb = new C32626rb();
                    c32626rb.cNg.cwT = YT.cqU();
                    c32626rb.cNg.cFc = C29036i.m46115j(YT);
                    C4879a.xxA.mo10055m(c32626rb);
                }
                OnlineVideoView.this.cNW = 0;
                if (OnlineVideoView.this.klq != null) {
                    if (C5046bo.isNullOrNil(OnlineVideoView.this.klq.getVideoPath())) {
                        C4990ab.m7417i("MicroMsg.OnlineVideoView", "%d had not set video path to play", Integer.valueOf(OnlineVideoView.this.hashCode()));
                        String a = C34957aq.m57415a(OnlineVideoView.this.czD, OnlineVideoView.this.cNr);
                        if (!C5046bo.isNullOrNil(a)) {
                            OnlineVideoView.this.mo47342bq(a, false);
                        }
                        AppMethodBeat.m2505o(38384);
                        return;
                    } else if (!OnlineVideoView.this.klq.isPlaying()) {
                        OnlineVideoView.this.klq.start();
                        AppMethodBeat.m2505o(38384);
                        return;
                    }
                }
                AppMethodBeat.m2505o(38384);
            }
        });
        AppMethodBeat.m2505o(38416);
    }

    private void csd() {
        AppMethodBeat.m2504i(38417);
        long yz = C5046bo.m7588yz();
        String uu = C26494u.m42269uu(C34957aq.m57415a(this.czD, this.cNr));
        if (C5046bo.isNullOrNil(uu)) {
            Toast.makeText(this.mContext, this.mContext.getString(C25738R.string.f1c), 1).show();
            C7060h.pYm.mo8378a(354, 222, 1, false);
        } else {
            Toast.makeText(this.mContext, this.mContext.getString(C25738R.string.f1d, new Object[]{uu}), 1).show();
            C40612a.m70043a(uu, this.mContext);
            C7060h.pYm.mo8378a(354, 221, 1, false);
        }
        this.rlh = false;
        C4990ab.m7417i("MicroMsg.OnlineVideoView", "%d save downloaded video finish %d %s", Integer.valueOf(hashCode()), Long.valueOf(C5046bo.m7525az(yz)), r0);
        this.kkp.post(new C3501410());
        AppMethodBeat.m2505o(38417);
    }

    /* renamed from: a */
    private void m57518a(final boolean z, final float f) {
        AppMethodBeat.m2504i(38418);
        this.kkp.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(38400);
                C4990ab.m7417i("MicroMsg.OnlineVideoView", "%d switch video model isVideoPlay %b %f", Integer.valueOf(OnlineVideoView.this.hashCode()), Boolean.valueOf(z), Float.valueOf(f));
                View view = (View) OnlineVideoView.this.klq;
                if (z) {
                    OnlineVideoView.this.mmW.setAlpha(f);
                    OnlineVideoView.this.mmW.setVisibility(0);
                    view.setAlpha(f);
                    view.setVisibility(0);
                    if (((double) f) >= 1.0d) {
                        OnlineVideoView.this.mmB.setVisibility(8);
                        AppMethodBeat.m2505o(38400);
                        return;
                    }
                }
                OnlineVideoView.this.mmW.setVisibility(8);
                view.setVisibility(8);
                OnlineVideoView.this.mmB.setVisibility(0);
                AppMethodBeat.m2505o(38400);
            }
        });
        AppMethodBeat.m2505o(38418);
    }

    private void bwD() {
        String str;
        AppMethodBeat.m2504i(38419);
        if (this.mOO) {
            str = this.rlg;
        } else {
            str = C34957aq.m57415a(this.czD, this.cNr);
        }
        C4990ab.m7417i("MicroMsg.OnlineVideoView", "%d toggleVideo local id %s finish path %s isPreview %b", Integer.valueOf(hashCode()), this.czD, str, Boolean.valueOf(this.mOO));
        if (C5046bo.isNullOrNil(str)) {
            m57518a(false, 0.0f);
            m57511C(false, 0);
            aNt();
            AppMethodBeat.m2505o(38419);
            return;
        }
        C4990ab.m7417i("MicroMsg.OnlineVideoView", "%d sns video already download finish, play now", Integer.valueOf(hashCode()));
        m57518a(true, 0.0f);
        mo47342bq(str, false);
        AppMethodBeat.m2505o(38419);
    }

    /* renamed from: C */
    private void m57511C(boolean z, int i) {
        boolean z2 = true;
        AppMethodBeat.m2504i(38420);
        if (this.cNr == null) {
            C4990ab.m7421w("MicroMsg.OnlineVideoView", "%d start download video but media is null.", Integer.valueOf(hashCode()));
            AppMethodBeat.m2505o(38420);
        } else if (this.rlk == null) {
            C4990ab.m7421w("MicroMsg.OnlineVideoView", "%d start download video but helper is null.", Integer.valueOf(hashCode()));
            AppMethodBeat.m2505o(38420);
        } else if (this.cNr.wEG == 2) {
            C4990ab.m7421w("MicroMsg.OnlineVideoView", "%d it start download video, url type is weixin", Integer.valueOf(hashCode()));
            this.rlf = 3;
            C13373af.cnA().mo69138a(this.cNr, 4, null, this.qFT);
            AppMethodBeat.m2505o(38420);
        } else {
            int i2;
            if (!z) {
                C42204d.afF();
                if (C42204d.afN()) {
                    C4990ab.m7417i("MicroMsg.OnlineVideoView", "%d it start online download video", Integer.valueOf(hashCode()));
                    this.rlf = 1;
                    if (i == 0) {
                        i = 30;
                    }
                    i2 = i;
                    this.rlk.mo47335a(this.cNr, this.fDG, this.czD, z2, i2);
                    AppMethodBeat.m2505o(38420);
                }
            }
            C4990ab.m7417i("MicroMsg.OnlineVideoView", "%d it start offline download video", Integer.valueOf(hashCode()));
            this.rlf = 2;
            if (i == 0) {
                i = 31;
            }
            i2 = i;
            z2 = false;
            this.rlk.mo47335a(this.cNr, this.fDG, this.czD, z2, i2);
            AppMethodBeat.m2505o(38420);
        }
    }

    private void aNt() {
        AppMethodBeat.m2504i(38421);
        this.kkp.post(new C3501113());
        AppMethodBeat.m2505o(38421);
    }

    private void bJc() {
        AppMethodBeat.m2504i(38422);
        this.kkp.post(new C2911114());
        AppMethodBeat.m2505o(38422);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: cV */
    public final void mo55603cV(boolean z) {
        AppMethodBeat.m2504i(38423);
        if (!this.rll) {
            this.klw.mo16770ae(500, 500);
            AppMethodBeat.m2505o(38423);
        } else if (z) {
            C5004al.m7441d(new C2199815());
            AppMethodBeat.m2505o(38423);
        } else {
            this.rcg.mo16770ae(500, 500);
            AppMethodBeat.m2505o(38423);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void cse() {
        AppMethodBeat.m2504i(38424);
        this.rcg.stopTimer();
        this.klw.stopTimer();
        AppMethodBeat.m2505o(38424);
    }

    public final void onError(int i, int i2) {
        AppMethodBeat.m2504i(38425);
        C4990ab.m7413e("MicroMsg.OnlineVideoView", "%d on play video error what %d extra %d. isOnlinePlay %b isMMVideoPlayer[%b]", Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.rll), Boolean.valueOf(this.mqh));
        if (this.rll) {
            C7060h.pYm.mo8378a(354, 230, 1, false);
        } else {
            C7060h.pYm.mo8378a(354, 231, 1, false);
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
                    C29177ae c29177ae = this.rlk;
                    String str = c29177ae.fUL + 0 + "_-1";
                    if (!c29177ae.rlC.containsKey(str)) {
                        C4990ab.m7417i("MicroMsg.OnlineVideoViewHelper", "request all data. [%s]", c29177ae.fUL);
                        C37961o.alm();
                        C45150e.m83031k(c29177ae.fUL, 0, -1);
                        c29177ae.rlC.put(str, Integer.valueOf(0));
                        C7060h.pYm.mo8378a(354, 207, 1, false);
                        C7060h.pYm.mo8381e(13836, Integer.valueOf(403), Long.valueOf(C5046bo.anT()), "");
                    }
                    c29177ae.fUP = 5;
                    c29177ae.fUU = true;
                    c29177ae.fUX = false;
                }
                csh();
                AppMethodBeat.m2505o(38425);
                return;
            } catch (Exception e) {
                AppMethodBeat.m2505o(38425);
                return;
            }
        }
        this.klq.stop();
        this.mqg = true;
        m57518a(false, 0.0f);
        if (!C5046bo.isNullOrNil(videoPath)) {
            C4990ab.m7421w("MicroMsg.OnlineVideoView", "%d start third player to play", Integer.valueOf(hashCode()));
            this.kkp.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(38397);
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    C15429k.m23712a(OnlineVideoView.this.getContext(), intent, C5730e.asY(videoPath), "video/*");
                    try {
                        OnlineVideoView.this.getContext().startActivity(intent);
                        AppMethodBeat.m2505o(38397);
                    } catch (Exception e) {
                        C4990ab.m7412e("MicroMsg.OnlineVideoView", "startActivity fail, activity not found");
                        C30379h.m48467g(OnlineVideoView.this.getContext(), C25738R.string.bpq, C25738R.string.bpr);
                        AppMethodBeat.m2505o(38397);
                    }
                }
            });
        }
        AppMethodBeat.m2505o(38425);
    }

    /* renamed from: pL */
    public final void mo8557pL() {
        AppMethodBeat.m2504i(38426);
        C4990ab.m7417i("MicroMsg.OnlineVideoView", "%d onPrepared playErrorCode[%d] onErrorPlayTimeSec[%d]", Integer.valueOf(hashCode()), Integer.valueOf(this.mqi), Integer.valueOf(this.rln));
        this.mqi = 0;
        if (this.rln > 0) {
            mo47347yI(this.rln);
            this.rln = 0;
            AppMethodBeat.m2505o(38426);
            return;
        }
        this.rlo = 0;
        bJc();
        csg();
        this.klq.start();
        this.duration = this.klq.getDuration() / 1000;
        C4990ab.m7417i("MicroMsg.OnlineVideoView", "%d start play duration %d sns local id %s ", Integer.valueOf(hashCode()), Integer.valueOf(this.duration), this.czD);
        mo55603cV(false);
        AppMethodBeat.m2505o(38426);
    }

    /* renamed from: EA */
    public final void mo8553EA() {
        AppMethodBeat.m2504i(38427);
        C4990ab.m7417i("MicroMsg.OnlineVideoView", "%d on completion", Integer.valueOf(hashCode()));
        if (this.rli == null) {
            if (C1443d.m3069iX(18) || !this.mqh) {
                mo47347yI(0);
                AppMethodBeat.m2505o(38427);
                return;
            } else if (this.klq != null) {
                String videoPath = this.klq.getVideoPath();
                this.klq.stop();
                mo47342bq(videoPath, this.rll);
            }
        }
        AppMethodBeat.m2505o(38427);
    }

    /* renamed from: dG */
    public final int mo8554dG(int i, int i2) {
        return 0;
    }

    /* renamed from: dH */
    public final void mo8555dH(int i, int i2) {
    }

    private boolean bwE() {
        AppMethodBeat.m2504i(38428);
        if (this.rll) {
            C1720g.m3537RQ();
            boolean z = C1720g.m3536RP().mo5239Ry().getBoolean(C5127a.USERINFO_VIDEO_NEED_RESET_EXTRACTOR_BOOLEAN, false);
            AppMethodBeat.m2505o(38428);
            return z;
        }
        AppMethodBeat.m2505o(38428);
        return false;
    }

    /* renamed from: bq */
    public final void mo47342bq(String str, boolean z) {
        AppMethodBeat.m2504i(38429);
        C4990ab.m7417i("MicroMsg.OnlineVideoView", "%d prepare video isOnlinePlay %b filePath %s", Integer.valueOf(hashCode()), Boolean.valueOf(z), str);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7421w("MicroMsg.OnlineVideoView", "%d prepare video but filepath is null.", Integer.valueOf(hashCode()));
            AppMethodBeat.m2505o(38429);
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
                m57518a(true, 0.0f);
            } else {
                C4990ab.m7417i("MicroMsg.OnlineVideoView", "%d prepare video reset source", Integer.valueOf(hashCode()));
                if (this.klq instanceof VideoPlayerTextureView) {
                    ((VideoPlayerTextureView) this.klq).dlA();
                }
                mo47347yI(this.rln);
            }
        }
        C1720g.m3537RQ();
        if (((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_LOCAL_SIGHT_DEBUGINFO_INT_SYNC, Integer.valueOf(0))).intValue() == 1) {
            this.mqf.setText(C21846d.m33384RK(str));
            this.mqf.setVisibility(0);
        }
        AppMethodBeat.m2505o(38429);
    }

    public final boolean csf() {
        boolean z = true;
        AppMethodBeat.m2504i(38430);
        C4990ab.m7417i("MicroMsg.OnlineVideoView", "%d resumeByDataGain", Integer.valueOf(hashCode()));
        if (!this.klq.isPlaying()) {
            csg();
            z = this.klq.start();
            bJc();
        }
        AppMethodBeat.m2505o(38430);
        return z;
    }

    public final void akX() {
        AppMethodBeat.m2504i(38431);
        C4990ab.m7417i("MicroMsg.OnlineVideoView", "%d pauseByDataBlock", Integer.valueOf(hashCode()));
        csh();
        aNt();
        if (this.klq.isPlaying()) {
            C4990ab.m7417i("MicroMsg.OnlineVideoView", "%d pause play", Integer.valueOf(hashCode()));
            csh();
            this.klq.pause();
        }
        AppMethodBeat.m2505o(38431);
    }

    /* renamed from: yI */
    public final void mo47347yI(int i) {
        AppMethodBeat.m2504i(38432);
        C4990ab.m7417i("MicroMsg.OnlineVideoView", "%d seek second %d afterSeekPlay %b", Integer.valueOf(hashCode()), Integer.valueOf(i), Boolean.TRUE);
        this.rlo = 0;
        bJc();
        this.klq.mo27356d((double) (i * 1000), true);
        mo55603cV(false);
        AppMethodBeat.m2505o(38432);
    }

    private void csg() {
        AppMethodBeat.m2504i(38433);
        this.rlu = C5046bo.anU();
        C4990ab.m7411d("MicroMsg.OnlineVideoView", "%d notePlayVideo notePlayVideo %d ", Integer.valueOf(hashCode()), Long.valueOf(this.rlu));
        AppMethodBeat.m2505o(38433);
    }

    private void csh() {
        AppMethodBeat.m2504i(38434);
        if (this.rlu > 0) {
            this.rlv = (int) (((long) this.rlv) + ((C5046bo.anU() - this.rlu) / 1000));
        }
        C4990ab.m7417i("MicroMsg.OnlineVideoView", "%d notePauseVideo playVideoDuration %d ", Integer.valueOf(hashCode()), Integer.valueOf(this.rlv));
        this.rlu = 0;
        AppMethodBeat.m2505o(38434);
    }

    public int getPlayVideoDuration() {
        AppMethodBeat.m2504i(38435);
        if (this.rlv < 0) {
            this.rlv = 0;
        }
        C4990ab.m7417i("MicroMsg.OnlineVideoView", "%d get play video duration [%d]", Integer.valueOf(hashCode()), Integer.valueOf(this.rlv));
        int i = this.rlv;
        AppMethodBeat.m2505o(38435);
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
        AppMethodBeat.m2504i(38436);
        C7060h.pYm.mo8378a(354, 225, 1, false);
        AppMethodBeat.m2505o(38436);
    }

    static /* synthetic */ void csj() {
        AppMethodBeat.m2504i(38437);
        C7060h.pYm.mo8378a(354, 226, 1, false);
        AppMethodBeat.m2505o(38437);
    }

    /* renamed from: p */
    static /* synthetic */ void m57537p(OnlineVideoView onlineVideoView) {
        AppMethodBeat.m2504i(38442);
        C4990ab.m7417i("MicroMsg.OnlineVideoView", "%d save video, download finish path %s", Integer.valueOf(onlineVideoView.hashCode()), C34957aq.m57415a(onlineVideoView.czD, onlineVideoView.cNr));
        if (C5046bo.isNullOrNil(C34957aq.m57415a(onlineVideoView.czD, onlineVideoView.cNr))) {
            onlineVideoView.rlh = true;
            onlineVideoView.m57511C(true, 34);
            onlineVideoView.aNt();
            C7060h.pYm.mo8378a(354, 220, 1, false);
            AppMethodBeat.m2505o(38442);
            return;
        }
        onlineVideoView.csd();
        AppMethodBeat.m2505o(38442);
    }
}

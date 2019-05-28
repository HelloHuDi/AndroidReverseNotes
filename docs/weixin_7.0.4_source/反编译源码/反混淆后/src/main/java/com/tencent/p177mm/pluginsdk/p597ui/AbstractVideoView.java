package com.tencent.p177mm.pluginsdk.p597ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.plugin.sight.decode.p512ui.C3855b;
import com.tencent.p177mm.pluginsdk.p597ui.C44091h.C23324b;
import com.tencent.p177mm.pluginsdk.p597ui.C44091h.C23325c;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14978d;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14980e;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14981a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14982c;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14983b;
import com.tencent.p177mm.pluginsdk.p597ui.tools.VideoPlayerSeekBar;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;

/* renamed from: com.tencent.mm.pluginsdk.ui.AbstractVideoView */
public abstract class AbstractVideoView extends RelativeLayout implements C44091h, C14981a, C14983b, C14982c, C14978d, C14980e {
    public String TAG;
    /* renamed from: VN */
    protected boolean f14408VN;
    protected int bqQ;
    protected C7306ak fbD;
    public C14979e klq;
    protected TextView kye;
    protected Context mContext;
    protected ImageView miw;
    protected ProgressBar mqj;
    public C23324b rcd;
    protected TextView rlj;
    protected C7564ap vgA;
    protected C7564ap vgB;
    private C3855b vgC;
    private OnClickListener vgD;
    private Runnable vgE;
    private C23325c vgF;
    protected C35875j vgG;
    protected boolean vgk;
    protected RelativeLayout vgl;
    protected LinearLayout vgm;
    protected VideoPlayerSeekBar vgn;
    protected C30135g vgo;
    protected boolean vgp;
    protected boolean vgq;
    protected int vgr;
    protected boolean vgs;
    protected int vgt;
    protected boolean vgu;
    protected int vgv;
    protected boolean vgw;
    protected long vgx;
    protected int vgy;
    protected C7564ap vgz;

    /* renamed from: com.tencent.mm.pluginsdk.ui.AbstractVideoView$1 */
    class C232581 implements C5015a {
        C232581() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(117934);
            if (AbstractVideoView.this.isPlaying()) {
                if (AbstractVideoView.this.vgs) {
                    if (AbstractVideoView.this.rcd != null) {
                        AbstractVideoView.this.rcd.mo9213cs(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
                    }
                    AbstractVideoView.this.vgs = false;
                }
                AbstractVideoView.this.mo51410ru(AbstractVideoView.this.getCurrPosSec());
                AbstractVideoView.this.m50948nF(AbstractVideoView.this.isPlaying());
                AppMethodBeat.m2505o(117934);
                return true;
            }
            AppMethodBeat.m2505o(117934);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.AbstractVideoView$4 */
    class C300924 implements C5015a {
        C300924() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(117937);
            boolean isPlaying = AbstractVideoView.this.isPlaying();
            C4990ab.m7417i(AbstractVideoView.this.TAG, "%s prepare start checker isplaying[%b] currPosMs[%d]", AbstractVideoView.this.aZk(), Boolean.valueOf(isPlaying), Integer.valueOf(AbstractVideoView.this.getCurrPosMs()));
            if (AbstractVideoView.this.klq != null && r1 <= 50) {
                AbstractVideoView.this.klq.mo9052B(0.0d);
            }
            AppMethodBeat.m2505o(117937);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.AbstractVideoView$5 */
    class C300935 implements C5015a {
        C300935() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(117938);
            if (AbstractVideoView.this.bqQ <= 0) {
                AppMethodBeat.m2505o(117938);
                return false;
            } else if (AbstractVideoView.this.isPlaying()) {
                AbstractVideoView.m50946a(AbstractVideoView.this);
                AppMethodBeat.m2505o(117938);
                return false;
            } else {
                AppMethodBeat.m2505o(117938);
                return true;
            }
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.AbstractVideoView$10 */
    class C3148210 implements Runnable {
        C3148210() {
        }

        public final void run() {
            AppMethodBeat.m2504i(117943);
            if (!(AbstractVideoView.this.vgm == null || AbstractVideoView.this.vgm.getVisibility() == 0)) {
                AbstractVideoView.this.vgm.setVisibility(0);
            }
            AppMethodBeat.m2505o(117943);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.AbstractVideoView$11 */
    class C3148311 implements Runnable {
        C3148311() {
        }

        public final void run() {
            AppMethodBeat.m2504i(117944);
            if (!(AbstractVideoView.this.vgm == null || AbstractVideoView.this.vgm.getVisibility() == 8)) {
                AbstractVideoView.this.vgm.setVisibility(8);
            }
            AppMethodBeat.m2505o(117944);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.AbstractVideoView$2 */
    class C314842 implements Runnable {
        C314842() {
        }

        public final void run() {
            AppMethodBeat.m2504i(117935);
            try {
                AbstractVideoView.this.mo51410ru(0);
                AbstractVideoView.this.m50948nF(AbstractVideoView.this.isPlaying());
                AppMethodBeat.m2505o(117935);
            } catch (Throwable th) {
                AppMethodBeat.m2505o(117935);
            }
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.AbstractVideoView$8 */
    class C314858 implements Runnable {
        C314858() {
        }

        public final void run() {
            AppMethodBeat.m2504i(117941);
            if (!(AbstractVideoView.this.mqj == null || AbstractVideoView.this.mqj.getVisibility() == 0)) {
                C4990ab.m7417i(AbstractVideoView.this.TAG, "%s show loading", AbstractVideoView.this.aZk());
                AbstractVideoView.this.mqj.setVisibility(0);
                if (AbstractVideoView.this.rcd != null) {
                    AbstractVideoView.this.rcd.mo9214ct(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
                }
            }
            AppMethodBeat.m2505o(117941);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.AbstractVideoView$6 */
    class C314866 implements C3855b {
        C314866() {
        }

        public final void aFw() {
        }

        /* renamed from: oA */
        public final void mo8552oA(int i) {
            AppMethodBeat.m2504i(117939);
            if (AbstractVideoView.this.mo26912e((double) i, true)) {
                AbstractVideoView.this.mo9068cV(false);
            }
            AbstractVideoView.this.vgn.setIsPlay(true);
            AppMethodBeat.m2505o(117939);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.AbstractVideoView$7 */
    class C314877 implements OnClickListener {
        C314877() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(117940);
            C4990ab.m7417i(AbstractVideoView.this.TAG, "%s seek bar play button on click ", AbstractVideoView.this.aZk());
            AbstractVideoView abstractVideoView = AbstractVideoView.this;
            if (abstractVideoView.klq != null) {
                if (abstractVideoView.isPlaying()) {
                    abstractVideoView.pause();
                    AppMethodBeat.m2505o(117940);
                    return;
                } else if (C5046bo.isNullOrNil(abstractVideoView.klq.getVideoPath())) {
                    abstractVideoView.start();
                    AppMethodBeat.m2505o(117940);
                    return;
                } else {
                    abstractVideoView.play();
                }
            }
            AppMethodBeat.m2505o(117940);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.AbstractVideoView$9 */
    class C314889 implements Runnable {
        C314889() {
        }

        public final void run() {
            AppMethodBeat.m2504i(117942);
            if (!(AbstractVideoView.this.mqj == null || AbstractVideoView.this.mqj.getVisibility() == 8)) {
                C4990ab.m7417i(AbstractVideoView.this.TAG, "%s hide loading", AbstractVideoView.this.aZk());
                AbstractVideoView.this.mqj.setVisibility(8);
                if (AbstractVideoView.this.rcd != null) {
                    AbstractVideoView.this.rcd.mo9215cu(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
                }
            }
            AppMethodBeat.m2505o(117942);
        }
    }

    public abstract int getReportIdkey();

    /* renamed from: a */
    static /* synthetic */ void m50946a(AbstractVideoView abstractVideoView) {
        C4990ab.m7417i(abstractVideoView.TAG, "%s reset error count ", abstractVideoView.aZk());
        abstractVideoView.bqQ = 0;
        abstractVideoView.mo51409gp((long) (abstractVideoView.getReportIdkey() + 91));
    }

    public AbstractVideoView(Context context) {
        this(context, null);
    }

    public AbstractVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AbstractVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TAG = "MicroMsg.AbstractVideoView";
        this.vgk = true;
        this.vgq = true;
        this.vgr = 0;
        this.vgs = false;
        this.fbD = new C7306ak(Looper.getMainLooper());
        this.vgt = 0;
        this.vgu = true;
        this.vgv = -1;
        this.bqQ = 0;
        this.vgw = false;
        this.f14408VN = false;
        this.vgx = 0;
        this.vgy = 0;
        this.vgz = new C7564ap(new C232581(), true);
        this.vgA = new C7564ap(new C300924(), false);
        this.vgB = new C7564ap(new C300935(), true);
        this.vgC = new C314866();
        this.vgD = new C314877();
        this.vgE = new C314858();
        this.vgF = null;
        this.vgG = new C35875j();
        this.mContext = context;
        initView();
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: cf */
    public C14979e mo9069cf(Context context) {
        return null;
    }

    /* Access modifiers changed, original: protected */
    public void initView() {
        C4990ab.m7417i(this.TAG, "%s init view ", aZk());
        LayoutInflater.from(this.mContext).inflate(2130969173, this);
        this.miw = (ImageView) findViewById(2131822133);
        this.vgl = (RelativeLayout) findViewById(2131822134);
        this.rlj = (TextView) findViewById(2131822135);
        this.mqj = (ProgressBar) findViewById(2131821891);
        this.kye = (TextView) findViewById(2131822138);
        this.vgm = (LinearLayout) findViewById(2131822904);
        VideoPlayerSeekBar videoPlayerSeekBar = (VideoPlayerSeekBar) findViewById(2131822905);
        this.vgn = videoPlayerSeekBar;
        this.vgo = videoPlayerSeekBar;
        this.vgn.setIplaySeekCallback(this.vgC);
        this.vgn.setOnClickListener(this.vgD);
        this.klq = mo9069cf(this.mContext);
        this.klq.setVideoCallback(this);
        this.klq.setOnSeekCompleteCallback(this);
        this.klq.setOnInfoCallback(this);
        this.klq.setOnSurfaceCallback(this);
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.addRule(13);
        this.vgl.addView((View) this.klq, layoutParams);
    }

    public void setVideoFooterView(C30135g c30135g) {
        if (c30135g instanceof View) {
            cpU();
            this.vgo = c30135g;
            this.vgq = false;
            this.vgm.addView((View) this.vgo);
            return;
        }
        C4990ab.m7421w(this.TAG, "%s set video footer view but is not view", aZk());
    }

    public final void cpU() {
        this.vgm.removeView((View) this.vgo);
    }

    /* renamed from: Dq */
    private void m50945Dq(int i) {
        this.vgo.mo27328Dq(i);
    }

    /* renamed from: nF */
    private void m50948nF(boolean z) {
        this.vgo.mo27337nF(z);
    }

    private void setVideoTotalTime(int i) {
        if (this.vgo != null && this.vgo.getVideoTotalTime() != i) {
            this.vgo.setVideoTotalTime(i);
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: cV */
    public void mo9068cV(boolean z) {
        C4990ab.m7411d(this.TAG, "%s start timer rightNow[%b]", aZk(), Boolean.valueOf(z));
        this.vgz.mo16770ae(500, 500);
    }

    public int getCacheTimeSec() {
        return 0;
    }

    /* Access modifiers changed, original: protected */
    public void stopTimer() {
        this.vgz.stopTimer();
        this.vgA.stopTimer();
    }

    /* renamed from: ru */
    public final void mo51410ru(int i) {
        m50945Dq(i);
    }

    /* Access modifiers changed, original: protected */
    public void aNt() {
        mo35358gR(500);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: gR */
    public void mo35358gR(long j) {
        this.fbD.postDelayed(this.vgE, j);
    }

    public final void bJc() {
        C4990ab.m7411d(this.TAG, "%s hide loading %s", aZk(), C5046bo.dpG());
        this.fbD.removeCallbacks(this.vgE);
        this.fbD.post(new C314889());
    }

    /* Access modifiers changed, original: protected|final */
    public final void diM() {
        this.fbD.post(new C3148311());
    }

    public final String aZk() {
        return hashCode();
    }

    public int getPlayerType() {
        return this.vgt;
    }

    public int getVideoSource() {
        return 0;
    }

    public boolean play() {
        if (this.vgk) {
            mo51409gp((long) (getReportIdkey() + 3));
            if (this.klq == null) {
                return false;
            }
            boolean start = this.klq.start();
            C4990ab.m7417i(this.TAG, "%s video play [%b] isPlayOnUiPause[%b]", aZk(), Boolean.valueOf(start), Boolean.valueOf(this.vgs));
            m50948nF(start);
            if (start) {
                this.vgs = false;
                mo9068cV(false);
                if (this.rcd != null) {
                    this.rcd.mo9213cs(getSessionId(), getMediaId());
                }
            }
            return start;
        }
        C4990ab.m7421w(this.TAG, "%s ui on pause now, why u call me to play? [%s]", aZk(), C5046bo.dpG());
        return false;
    }

    public boolean pause() {
        C4990ab.m7417i(this.TAG, "%s pause", aZk());
        mo51409gp((long) (getReportIdkey() + 4));
        if (this.klq == null) {
            return false;
        }
        m50948nF(false);
        this.klq.pause();
        stopTimer();
        if (this.rcd != null) {
            this.rcd.mo9212cr(getSessionId(), getMediaId());
        }
        this.vgG.rlI = C5046bo.anU();
        return true;
    }

    /* renamed from: s */
    public final boolean mo26920s(double d) {
        return mo26912e(d, isPlaying());
    }

    /* renamed from: e */
    public boolean mo26912e(double d, boolean z) {
        boolean bTd = bTd();
        int videoDurationSec = getVideoDurationSec();
        int i = (int) d;
        if (videoDurationSec > 0 && d > ((double) videoDurationSec)) {
            i = videoDurationSec;
        }
        boolean z2 = this.klq != null ? !C5046bo.isNullOrNil(this.klq.getVideoPath()) : false;
        C4990ab.m7409c(this.TAG, "%s seek to [%d %s] seconds afterPlay[%b] isPrepared[%b] duration[%d] hadSetPath[%b]", aZk(), Integer.valueOf(i), Double.valueOf(d), Boolean.valueOf(z), Boolean.valueOf(bTd), Integer.valueOf(videoDurationSec), Boolean.valueOf(z2));
        mo51409gp((long) (getReportIdkey() + 5));
        if (!bTd) {
            this.vgv = i;
            if (z2) {
                this.vgu = true;
            } else {
                this.vgu = z;
                start();
            }
        } else if (this.klq != null) {
            aNt();
            m50945Dq(i);
            this.klq.mo27356d((double) (i * 1000), z);
            return z;
        }
        return false;
    }

    public int getVideoDurationSec() {
        if (this.klq != null) {
            return Math.round((((float) this.klq.getDuration()) * 1.0f) / 1000.0f);
        }
        return -1;
    }

    public int getCurrPosMs() {
        if (this.klq != null) {
            return this.klq.getCurrentPosition();
        }
        return 0;
    }

    public int getCurrPosSec() {
        if (this.klq != null) {
            return Math.round((((float) this.klq.getCurrentPosition()) * 1.0f) / 1000.0f);
        }
        return 0;
    }

    public boolean isPlaying() {
        if (this.klq != null) {
            return this.klq.isPlaying();
        }
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bTd() {
        boolean z = this.klq != null ? !C5046bo.isNullOrNil(this.klq.getVideoPath()) && this.f14408VN : false;
        C4990ab.m7411d(this.TAG, "%s is prepared [%b] isPrepared[%b]", aZk(), Boolean.valueOf(z), Boolean.valueOf(this.f14408VN));
        return z;
    }

    public void setIsShowBasicControls(boolean z) {
        C4990ab.m7417i(this.TAG, "%s is show seek bar[%b]", aZk(), Boolean.valueOf(z));
        this.vgp = z;
        if (this.vgp) {
            this.fbD.post(new C3148210());
        } else {
            diM();
        }
    }

    public void setCover(Bitmap bitmap) {
        C4990ab.m7417i(this.TAG, "%s set cover", aZk());
        if (bitmap != null && !bitmap.isRecycled()) {
            this.miw.setImageBitmap(bitmap);
        }
    }

    public void setFullDirection(int i) {
    }

    public void setIMMVideoViewCallback(C23324b c23324b) {
        this.rcd = c23324b;
    }

    public void stop() {
        C4990ab.m7417i(this.TAG, "%s stop [%s]", aZk(), C5046bo.dpG());
        mo51409gp((long) (getReportIdkey() + 6));
        if (this.klq != null) {
            this.klq.stop();
        }
        this.vgv = -1;
        this.vgu = true;
        this.f14408VN = false;
        this.vgy = 0;
        this.vgx = 0;
        stopTimer();
        this.fbD.postDelayed(new C314842(), 10);
        this.vgG.viD = C5046bo.anU();
        if (this.vgG.blockCount > 0) {
            int i;
            int i2;
            if (C5023at.isWifi(this.mContext)) {
                i = 41;
                i2 = 45;
            } else if (C5023at.is4G(this.mContext)) {
                i = 46;
                i2 = 50;
            } else if (C5023at.is3G(this.mContext)) {
                i = 51;
                i2 = 55;
            } else if (C5023at.is2G(this.mContext)) {
                i = 56;
                i2 = 60;
            }
            C4990ab.m7411d(this.TAG, "%s rptBlockCount [%d]", aZk(), Integer.valueOf(C5046bo.m7567h((Integer) C7053e.m11771a(this.vgG.blockCount, new int[]{1, 2, 3, 4}, i + getReportIdkey(), i2 + getReportIdkey()))));
            mo51409gp((long) i2);
        }
        if (this.vgG.startTimeStamp != 0) {
            long j;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.vgG.startTimeStamp).append(",");
            stringBuffer.append(this.vgG.viC).append(",");
            stringBuffer.append(this.vgG.viD).append(",");
            stringBuffer.append(this.vgG.rlI).append(",");
            stringBuffer.append(this.vgG.viE).append(",");
            stringBuffer.append(this.vgG.viF).append(",");
            stringBuffer.append(this.vgG.viG).append(",");
            stringBuffer.append(this.vgG.blockCount).append(",");
            stringBuffer.append(this.vgG.viC > 0 ? this.vgG.viC - this.vgG.startTimeStamp : 0).append(",");
            stringBuffer.append(this.vgG.url).append(",");
            stringBuffer.append(this.vgG.duration).append(",");
            stringBuffer.append(this.vgG.viH).append(",");
            stringBuffer.append(this.vgG.viI).append(",");
            stringBuffer.append(this.vgG.rlG).append(",");
            if (this.vgG.rlG > this.vgG.startTimeStamp) {
                j = this.vgG.rlG - this.vgG.startTimeStamp;
            } else {
                j = 0;
            }
            stringBuffer.append(j).append(",");
            stringBuffer.append(getPlayerType()).append(",");
            stringBuffer.append(getVideoSource());
            C4990ab.m7417i(this.TAG, "%s rpt video kv stat{%s}", aZk(), stringBuffer.toString());
            if (this.vgF != null) {
                this.vgF.mo26927wB(r0);
            }
            C35875j c35875j = this.vgG;
            c35875j.startTimeStamp = 0;
            c35875j.viC = 0;
            c35875j.viD = 0;
            c35875j.rlI = 0;
            c35875j.viE = 0;
            c35875j.viF = 0;
            c35875j.viG = 0;
            c35875j.blockCount = 0;
            c35875j.url = "";
            c35875j.duration = 0;
            c35875j.viH = 0;
            c35875j.viI = 0;
            c35875j.rlG = 0;
        }
    }

    public void setMute(boolean z) {
        if (this.klq != null) {
            this.klq.setMute(z);
        }
    }

    public void akW() {
        C4990ab.m7417i(this.TAG, "%s onUIResume %s", aZk(), C5046bo.dpG());
        this.vgk = true;
        mo51409gp((long) (getReportIdkey() + 10));
    }

    public void akV() {
        C4990ab.m7417i(this.TAG, "%s onUIPause %s", aZk(), C5046bo.dpG());
        this.vgr = getCurrPosSec();
        this.vgs = isPlaying();
        this.vgy = 0;
        this.vgx = 0;
        pause();
        stopTimer();
        this.vgk = false;
        mo51409gp((long) (getReportIdkey() + 11));
    }

    public void aEX() {
        C4990ab.m7417i(this.TAG, "%s onUIDestroy", aZk());
        stop();
        this.fbD.removeCallbacksAndMessages(null);
        stopTimer();
        this.vgB.stopTimer();
        mo51409gp((long) (getReportIdkey() + 12));
    }

    public void onError(int i, int i2) {
        C4990ab.m7421w(this.TAG, "%s onError info [%d %d] errorCount[%d]", aZk(), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.bqQ));
        mo51409gp((long) (getReportIdkey() + 90));
        this.bqQ++;
        if (this.bqQ > 5) {
            mo51409gp((long) (getReportIdkey() + 92));
            this.vgG.viH = i;
            this.vgG.viI = i2;
            if (this.rcd != null) {
                String str;
                C23324b c23324b = this.rcd;
                String sessionId = getSessionId();
                String mediaId = getMediaId();
                if (i == -1010) {
                    str = "MEDIA_ERR_SRC_NOT_SUPPORTED";
                } else if (i == -1007) {
                    str = "MEDIA_ERR_SRC_NOT_SUPPORTED";
                } else if (i == -1004) {
                    if (C5023at.isConnected(this.mContext)) {
                        str = "MEDIA_ERR_DECODE";
                    } else {
                        str = "MEDIA_ERR_NETWORK";
                    }
                } else if (C5023at.isConnected(this.mContext)) {
                    str = "MEDIA_ERR_DECODE";
                } else {
                    str = "MEDIA_ERR_NETWORK";
                }
                c23324b.mo9209c(sessionId, mediaId, str, i, i2);
            }
            stop();
            bJc();
            return;
        }
        final int currPosSec = this.vgv == -1 ? getCurrPosSec() : this.vgv;
        C4990ab.m7417i(this.TAG, "%s onError now, try to start again. currPlaySec[%d] seekTimeWhenPrepared[%d] currPosSec[%d]", aZk(), Integer.valueOf(currPosSec), Integer.valueOf(this.vgv), Integer.valueOf(getCurrPosSec()));
        stop();
        aNt();
        this.fbD.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(117936);
                AbstractVideoView.this.vgw = true;
                AbstractVideoView.this.mo51410ru(currPosSec);
                AbstractVideoView.this.mo26912e((double) currPosSec, true);
                AbstractVideoView.this.vgw = false;
                AppMethodBeat.m2505o(117936);
            }
        }, 200);
    }

    /* renamed from: pL */
    public final void mo8557pL() {
        C4990ab.m7417i(this.TAG, "%s onPrepared startWhenPrepared[%b] seekTimeWhenPrepared[%d] isPrepared[%b]", aZk(), Boolean.valueOf(this.vgu), Integer.valueOf(this.vgv), Boolean.valueOf(this.f14408VN));
        this.f14408VN = true;
        if (this.klq != null) {
            this.klq.setOneTimeVideoTextureUpdateCallback(this);
        }
        setVideoTotalTime(getVideoDurationSec());
        if (!this.vgu) {
            mo26912e(this.vgv < 0 ? 0.0d : (double) this.vgv, this.vgu);
        } else if (this.vgv < 0) {
            if (play() && cGT()) {
                this.vgA.mo16770ae(1000, 1000);
            }
        } else if (isLive()) {
            play();
        } else {
            mo26912e((double) this.vgv, this.vgu);
        }
        this.vgv = -1;
        this.vgu = true;
        this.vgy = 0;
        this.vgx = 0;
        if (this.rcd != null) {
            this.rcd.mo9210cp(getSessionId(), getMediaId());
        }
        if (this.bqQ > 0) {
            C4990ab.m7411d(this.TAG, "%s start error check timer", aZk());
            this.vgB.mo16770ae(5000, 5000);
        }
        mo51409gp((long) (getReportIdkey() + 2));
        if (this.vgG.viC == 0) {
            this.vgG.viC = C5046bo.anU();
        }
        this.vgG.duration = getVideoDurationSec();
        if (this.vgG.startTimeStamp > 0 && this.vgG.viC > 0) {
            int i;
            int i2;
            int i3 = (int) ((this.vgG.viC - this.vgG.startTimeStamp) / 1000);
            if (C5023at.isWifi(this.mContext)) {
                i = 20;
                i2 = 24;
            } else if (C5023at.is4G(this.mContext)) {
                i = 25;
                i2 = 29;
            } else if (C5023at.is3G(this.mContext)) {
                i = 30;
                i2 = 34;
            } else if (C5023at.is2G(this.mContext)) {
                i = 35;
                i2 = 39;
            } else {
                return;
            }
            C4990ab.m7411d(this.TAG, "%s rptFirstPlayTime [%d]", aZk(), Integer.valueOf(C5046bo.m7567h((Integer) C7053e.m11771a(i3, new int[]{1, 2, 3, 4}, i + getReportIdkey(), i2 + getReportIdkey()))));
            mo51409gp((long) i2);
        }
    }

    public void bQL() {
        C4990ab.m7417i(this.TAG, "%s onTextureUpdate ", aZk());
        bJc();
    }

    /* renamed from: EA */
    public void mo8553EA() {
        C4990ab.m7417i(this.TAG, "%s onCompletion", aZk());
        bJc();
        stopTimer();
        if (this.rcd != null) {
            this.rcd.mo9211cq(getSessionId(), getMediaId());
        }
        this.vgy = 0;
        this.vgx = 0;
        mo51409gp((long) (getReportIdkey() + 7));
    }

    /* renamed from: dG */
    public final int mo8554dG(int i, int i2) {
        return 0;
    }

    /* renamed from: dH */
    public void mo8555dH(int i, int i2) {
        C4990ab.m7417i(this.TAG, "%s on get video size [%d, %d]", aZk(), Integer.valueOf(i), Integer.valueOf(i2));
        if (this.rcd != null) {
            this.rcd.mo9216d(getSessionId(), getMediaId(), i, i2);
        }
        mo51409gp((long) (getReportIdkey() + 8));
    }

    /* renamed from: cU */
    public void mo9067cU(boolean z) {
        C4990ab.m7417i(this.TAG, "%s on seek complete startPlay[%b]", aZk(), Boolean.valueOf(z));
        if (this.klq != null) {
            this.klq.setOneTimeVideoTextureUpdateCallback(this);
        }
        bJc();
        m50948nF(z);
        m50945Dq(getCurrPosSec());
        if (z) {
            mo9068cV(false);
            this.vgs = false;
            if (this.rcd != null) {
                this.rcd.mo9213cs(getSessionId(), getMediaId());
            }
        }
    }

    public void akY() {
        C4990ab.m7417i(this.TAG, "%s on surface available", aZk());
        mo9068cV(false);
    }

    /* Access modifiers changed, original: protected */
    public boolean cGT() {
        return true;
    }

    public void setReporter(C23325c c23325c) {
        this.vgF = c23325c;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: gp */
    public final void mo51409gp(long j) {
        if (this.vgF != null) {
            this.vgF.mo26918gp(j);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void cso() {
        if (this.vgG.startTimeStamp == 0) {
            this.vgG.startTimeStamp = C5046bo.anU();
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void diN() {
        if (this.vgG.rlG == 0) {
            this.vgG.rlG = C5046bo.anU();
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void diO() {
        this.vgG.viE = C5046bo.anU();
    }

    /* Access modifiers changed, original: protected|final */
    public final void diP() {
        this.vgG.viF = C5046bo.anU();
        if (this.vgG.viE > 0) {
            C35875j c35875j = this.vgG;
            c35875j.viG += this.vgG.viF - this.vgG.viE;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void diQ() {
        C35875j c35875j = this.vgG;
        c35875j.blockCount++;
    }

    /* Access modifiers changed, original: protected|final */
    public final void ajo(String str) {
        this.vgG.url = str;
    }

    /* Access modifiers changed, original: protected|final */
    public final void diR() {
        if (this.vgG.viF > 0 && this.vgG.viE > 0) {
            int i;
            int i2;
            int i3 = (int) ((this.vgG.viF - this.vgG.viE) / 1000);
            if (C5023at.isWifi(this.mContext)) {
                i = 70;
                i2 = 74;
            } else if (C5023at.is4G(this.mContext)) {
                i = 75;
                i2 = 79;
            } else if (C5023at.is3G(this.mContext)) {
                i = 80;
                i2 = 84;
            } else if (C5023at.is2G(this.mContext)) {
                i = 85;
                i2 = 89;
            } else {
                return;
            }
            C4990ab.m7411d(this.TAG, "%s rptResumeTime [%d]", aZk(), Integer.valueOf(C5046bo.m7567h((Integer) C7053e.m11771a(i3, new int[]{1, 2, 3, 4}, i + getReportIdkey(), i2 + getReportIdkey()))));
            mo51409gp((long) i2);
        }
    }

    public String getSessionId() {
        return "";
    }

    /* Access modifiers changed, original: protected */
    public String getMediaId() {
        return "";
    }
}

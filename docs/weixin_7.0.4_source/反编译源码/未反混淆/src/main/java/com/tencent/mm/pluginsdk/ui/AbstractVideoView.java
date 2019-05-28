package com.tencent.mm.pluginsdk.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.e.a;
import com.tencent.mm.pluginsdk.ui.tools.e.b;
import com.tencent.mm.pluginsdk.ui.tools.e.c;
import com.tencent.mm.pluginsdk.ui.tools.e.d;
import com.tencent.mm.pluginsdk.ui.tools.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;

public abstract class AbstractVideoView extends RelativeLayout implements h, a, b, c, d, e {
    public String TAG;
    protected boolean VN;
    protected int bqQ;
    protected ak fbD;
    public com.tencent.mm.pluginsdk.ui.tools.e klq;
    protected TextView kye;
    protected Context mContext;
    protected ImageView miw;
    protected ProgressBar mqj;
    public h.b rcd;
    protected TextView rlj;
    protected ap vgA;
    protected ap vgB;
    private com.tencent.mm.plugin.sight.decode.ui.b vgC;
    private OnClickListener vgD;
    private Runnable vgE;
    private h.c vgF;
    protected j vgG;
    protected boolean vgk;
    protected RelativeLayout vgl;
    protected LinearLayout vgm;
    protected VideoPlayerSeekBar vgn;
    protected g vgo;
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
    protected ap vgz;

    public abstract int getReportIdkey();

    static /* synthetic */ void a(AbstractVideoView abstractVideoView) {
        ab.i(abstractVideoView.TAG, "%s reset error count ", abstractVideoView.aZk());
        abstractVideoView.bqQ = 0;
        abstractVideoView.gp((long) (abstractVideoView.getReportIdkey() + 91));
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
        this.fbD = new ak(Looper.getMainLooper());
        this.vgt = 0;
        this.vgu = true;
        this.vgv = -1;
        this.bqQ = 0;
        this.vgw = false;
        this.VN = false;
        this.vgx = 0;
        this.vgy = 0;
        this.vgz = new ap(new ap.a() {
            public final boolean BI() {
                AppMethodBeat.i(117934);
                if (AbstractVideoView.this.isPlaying()) {
                    if (AbstractVideoView.this.vgs) {
                        if (AbstractVideoView.this.rcd != null) {
                            AbstractVideoView.this.rcd.cs(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
                        }
                        AbstractVideoView.this.vgs = false;
                    }
                    AbstractVideoView.this.ru(AbstractVideoView.this.getCurrPosSec());
                    AbstractVideoView.this.nF(AbstractVideoView.this.isPlaying());
                    AppMethodBeat.o(117934);
                    return true;
                }
                AppMethodBeat.o(117934);
                return false;
            }
        }, true);
        this.vgA = new ap(new ap.a() {
            public final boolean BI() {
                AppMethodBeat.i(117937);
                boolean isPlaying = AbstractVideoView.this.isPlaying();
                ab.i(AbstractVideoView.this.TAG, "%s prepare start checker isplaying[%b] currPosMs[%d]", AbstractVideoView.this.aZk(), Boolean.valueOf(isPlaying), Integer.valueOf(AbstractVideoView.this.getCurrPosMs()));
                if (AbstractVideoView.this.klq != null && r1 <= 50) {
                    AbstractVideoView.this.klq.B(0.0d);
                }
                AppMethodBeat.o(117937);
                return false;
            }
        }, false);
        this.vgB = new ap(new ap.a() {
            public final boolean BI() {
                AppMethodBeat.i(117938);
                if (AbstractVideoView.this.bqQ <= 0) {
                    AppMethodBeat.o(117938);
                    return false;
                } else if (AbstractVideoView.this.isPlaying()) {
                    AbstractVideoView.a(AbstractVideoView.this);
                    AppMethodBeat.o(117938);
                    return false;
                } else {
                    AppMethodBeat.o(117938);
                    return true;
                }
            }
        }, true);
        this.vgC = new com.tencent.mm.plugin.sight.decode.ui.b() {
            public final void aFw() {
            }

            public final void oA(int i) {
                AppMethodBeat.i(117939);
                if (AbstractVideoView.this.e((double) i, true)) {
                    AbstractVideoView.this.cV(false);
                }
                AbstractVideoView.this.vgn.setIsPlay(true);
                AppMethodBeat.o(117939);
            }
        };
        this.vgD = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(117940);
                ab.i(AbstractVideoView.this.TAG, "%s seek bar play button on click ", AbstractVideoView.this.aZk());
                AbstractVideoView abstractVideoView = AbstractVideoView.this;
                if (abstractVideoView.klq != null) {
                    if (abstractVideoView.isPlaying()) {
                        abstractVideoView.pause();
                        AppMethodBeat.o(117940);
                        return;
                    } else if (bo.isNullOrNil(abstractVideoView.klq.getVideoPath())) {
                        abstractVideoView.start();
                        AppMethodBeat.o(117940);
                        return;
                    } else {
                        abstractVideoView.play();
                    }
                }
                AppMethodBeat.o(117940);
            }
        };
        this.vgE = new Runnable() {
            public final void run() {
                AppMethodBeat.i(117941);
                if (!(AbstractVideoView.this.mqj == null || AbstractVideoView.this.mqj.getVisibility() == 0)) {
                    ab.i(AbstractVideoView.this.TAG, "%s show loading", AbstractVideoView.this.aZk());
                    AbstractVideoView.this.mqj.setVisibility(0);
                    if (AbstractVideoView.this.rcd != null) {
                        AbstractVideoView.this.rcd.ct(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
                    }
                }
                AppMethodBeat.o(117941);
            }
        };
        this.vgF = null;
        this.vgG = new j();
        this.mContext = context;
        initView();
    }

    /* Access modifiers changed, original: protected */
    public com.tencent.mm.pluginsdk.ui.tools.e cf(Context context) {
        return null;
    }

    /* Access modifiers changed, original: protected */
    public void initView() {
        ab.i(this.TAG, "%s init view ", aZk());
        LayoutInflater.from(this.mContext).inflate(R.layout.pd, this);
        this.miw = (ImageView) findViewById(R.id.aex);
        this.vgl = (RelativeLayout) findViewById(R.id.aey);
        this.rlj = (TextView) findViewById(R.id.aez);
        this.mqj = (ProgressBar) findViewById(R.id.a9d);
        this.kye = (TextView) findViewById(R.id.af2);
        this.vgm = (LinearLayout) findViewById(R.id.azs);
        VideoPlayerSeekBar videoPlayerSeekBar = (VideoPlayerSeekBar) findViewById(R.id.azt);
        this.vgn = videoPlayerSeekBar;
        this.vgo = videoPlayerSeekBar;
        this.vgn.setIplaySeekCallback(this.vgC);
        this.vgn.setOnClickListener(this.vgD);
        this.klq = cf(this.mContext);
        this.klq.setVideoCallback(this);
        this.klq.setOnSeekCompleteCallback(this);
        this.klq.setOnInfoCallback(this);
        this.klq.setOnSurfaceCallback(this);
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.addRule(13);
        this.vgl.addView((View) this.klq, layoutParams);
    }

    public void setVideoFooterView(g gVar) {
        if (gVar instanceof View) {
            cpU();
            this.vgo = gVar;
            this.vgq = false;
            this.vgm.addView((View) this.vgo);
            return;
        }
        ab.w(this.TAG, "%s set video footer view but is not view", aZk());
    }

    public final void cpU() {
        this.vgm.removeView((View) this.vgo);
    }

    private void Dq(int i) {
        this.vgo.Dq(i);
    }

    private void nF(boolean z) {
        this.vgo.nF(z);
    }

    private void setVideoTotalTime(int i) {
        if (this.vgo != null && this.vgo.getVideoTotalTime() != i) {
            this.vgo.setVideoTotalTime(i);
        }
    }

    /* Access modifiers changed, original: protected */
    public void cV(boolean z) {
        ab.d(this.TAG, "%s start timer rightNow[%b]", aZk(), Boolean.valueOf(z));
        this.vgz.ae(500, 500);
    }

    public int getCacheTimeSec() {
        return 0;
    }

    /* Access modifiers changed, original: protected */
    public void stopTimer() {
        this.vgz.stopTimer();
        this.vgA.stopTimer();
    }

    public final void ru(int i) {
        Dq(i);
    }

    /* Access modifiers changed, original: protected */
    public void aNt() {
        gR(500);
    }

    /* Access modifiers changed, original: protected */
    public void gR(long j) {
        this.fbD.postDelayed(this.vgE, j);
    }

    public final void bJc() {
        ab.d(this.TAG, "%s hide loading %s", aZk(), bo.dpG());
        this.fbD.removeCallbacks(this.vgE);
        this.fbD.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(117942);
                if (!(AbstractVideoView.this.mqj == null || AbstractVideoView.this.mqj.getVisibility() == 8)) {
                    ab.i(AbstractVideoView.this.TAG, "%s hide loading", AbstractVideoView.this.aZk());
                    AbstractVideoView.this.mqj.setVisibility(8);
                    if (AbstractVideoView.this.rcd != null) {
                        AbstractVideoView.this.rcd.cu(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
                    }
                }
                AppMethodBeat.o(117942);
            }
        });
    }

    /* Access modifiers changed, original: protected|final */
    public final void diM() {
        this.fbD.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(117944);
                if (!(AbstractVideoView.this.vgm == null || AbstractVideoView.this.vgm.getVisibility() == 8)) {
                    AbstractVideoView.this.vgm.setVisibility(8);
                }
                AppMethodBeat.o(117944);
            }
        });
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
            gp((long) (getReportIdkey() + 3));
            if (this.klq == null) {
                return false;
            }
            boolean start = this.klq.start();
            ab.i(this.TAG, "%s video play [%b] isPlayOnUiPause[%b]", aZk(), Boolean.valueOf(start), Boolean.valueOf(this.vgs));
            nF(start);
            if (start) {
                this.vgs = false;
                cV(false);
                if (this.rcd != null) {
                    this.rcd.cs(getSessionId(), getMediaId());
                }
            }
            return start;
        }
        ab.w(this.TAG, "%s ui on pause now, why u call me to play? [%s]", aZk(), bo.dpG());
        return false;
    }

    public boolean pause() {
        ab.i(this.TAG, "%s pause", aZk());
        gp((long) (getReportIdkey() + 4));
        if (this.klq == null) {
            return false;
        }
        nF(false);
        this.klq.pause();
        stopTimer();
        if (this.rcd != null) {
            this.rcd.cr(getSessionId(), getMediaId());
        }
        this.vgG.rlI = bo.anU();
        return true;
    }

    public final boolean s(double d) {
        return e(d, isPlaying());
    }

    public boolean e(double d, boolean z) {
        boolean bTd = bTd();
        int videoDurationSec = getVideoDurationSec();
        int i = (int) d;
        if (videoDurationSec > 0 && d > ((double) videoDurationSec)) {
            i = videoDurationSec;
        }
        boolean z2 = this.klq != null ? !bo.isNullOrNil(this.klq.getVideoPath()) : false;
        ab.c(this.TAG, "%s seek to [%d %s] seconds afterPlay[%b] isPrepared[%b] duration[%d] hadSetPath[%b]", aZk(), Integer.valueOf(i), Double.valueOf(d), Boolean.valueOf(z), Boolean.valueOf(bTd), Integer.valueOf(videoDurationSec), Boolean.valueOf(z2));
        gp((long) (getReportIdkey() + 5));
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
            Dq(i);
            this.klq.d((double) (i * 1000), z);
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
        boolean z = this.klq != null ? !bo.isNullOrNil(this.klq.getVideoPath()) && this.VN : false;
        ab.d(this.TAG, "%s is prepared [%b] isPrepared[%b]", aZk(), Boolean.valueOf(z), Boolean.valueOf(this.VN));
        return z;
    }

    public void setIsShowBasicControls(boolean z) {
        ab.i(this.TAG, "%s is show seek bar[%b]", aZk(), Boolean.valueOf(z));
        this.vgp = z;
        if (this.vgp) {
            this.fbD.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(117943);
                    if (!(AbstractVideoView.this.vgm == null || AbstractVideoView.this.vgm.getVisibility() == 0)) {
                        AbstractVideoView.this.vgm.setVisibility(0);
                    }
                    AppMethodBeat.o(117943);
                }
            });
        } else {
            diM();
        }
    }

    public void setCover(Bitmap bitmap) {
        ab.i(this.TAG, "%s set cover", aZk());
        if (bitmap != null && !bitmap.isRecycled()) {
            this.miw.setImageBitmap(bitmap);
        }
    }

    public void setFullDirection(int i) {
    }

    public void setIMMVideoViewCallback(h.b bVar) {
        this.rcd = bVar;
    }

    public void stop() {
        ab.i(this.TAG, "%s stop [%s]", aZk(), bo.dpG());
        gp((long) (getReportIdkey() + 6));
        if (this.klq != null) {
            this.klq.stop();
        }
        this.vgv = -1;
        this.vgu = true;
        this.VN = false;
        this.vgy = 0;
        this.vgx = 0;
        stopTimer();
        this.fbD.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(117935);
                try {
                    AbstractVideoView.this.ru(0);
                    AbstractVideoView.this.nF(AbstractVideoView.this.isPlaying());
                    AppMethodBeat.o(117935);
                } catch (Throwable th) {
                    AppMethodBeat.o(117935);
                }
            }
        }, 10);
        this.vgG.viD = bo.anU();
        if (this.vgG.blockCount > 0) {
            int i;
            int i2;
            if (at.isWifi(this.mContext)) {
                i = 41;
                i2 = 45;
            } else if (at.is4G(this.mContext)) {
                i = 46;
                i2 = 50;
            } else if (at.is3G(this.mContext)) {
                i = 51;
                i2 = 55;
            } else if (at.is2G(this.mContext)) {
                i = 56;
                i2 = 60;
            }
            ab.d(this.TAG, "%s rptBlockCount [%d]", aZk(), Integer.valueOf(bo.h((Integer) com.tencent.mm.plugin.report.e.a(this.vgG.blockCount, new int[]{1, 2, 3, 4}, i + getReportIdkey(), i2 + getReportIdkey()))));
            gp((long) i2);
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
            ab.i(this.TAG, "%s rpt video kv stat{%s}", aZk(), stringBuffer.toString());
            if (this.vgF != null) {
                this.vgF.wB(r0);
            }
            j jVar = this.vgG;
            jVar.startTimeStamp = 0;
            jVar.viC = 0;
            jVar.viD = 0;
            jVar.rlI = 0;
            jVar.viE = 0;
            jVar.viF = 0;
            jVar.viG = 0;
            jVar.blockCount = 0;
            jVar.url = "";
            jVar.duration = 0;
            jVar.viH = 0;
            jVar.viI = 0;
            jVar.rlG = 0;
        }
    }

    public void setMute(boolean z) {
        if (this.klq != null) {
            this.klq.setMute(z);
        }
    }

    public void akW() {
        ab.i(this.TAG, "%s onUIResume %s", aZk(), bo.dpG());
        this.vgk = true;
        gp((long) (getReportIdkey() + 10));
    }

    public void akV() {
        ab.i(this.TAG, "%s onUIPause %s", aZk(), bo.dpG());
        this.vgr = getCurrPosSec();
        this.vgs = isPlaying();
        this.vgy = 0;
        this.vgx = 0;
        pause();
        stopTimer();
        this.vgk = false;
        gp((long) (getReportIdkey() + 11));
    }

    public void aEX() {
        ab.i(this.TAG, "%s onUIDestroy", aZk());
        stop();
        this.fbD.removeCallbacksAndMessages(null);
        stopTimer();
        this.vgB.stopTimer();
        gp((long) (getReportIdkey() + 12));
    }

    public void onError(int i, int i2) {
        ab.w(this.TAG, "%s onError info [%d %d] errorCount[%d]", aZk(), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.bqQ));
        gp((long) (getReportIdkey() + 90));
        this.bqQ++;
        if (this.bqQ > 5) {
            gp((long) (getReportIdkey() + 92));
            this.vgG.viH = i;
            this.vgG.viI = i2;
            if (this.rcd != null) {
                String str;
                h.b bVar = this.rcd;
                String sessionId = getSessionId();
                String mediaId = getMediaId();
                if (i == -1010) {
                    str = "MEDIA_ERR_SRC_NOT_SUPPORTED";
                } else if (i == -1007) {
                    str = "MEDIA_ERR_SRC_NOT_SUPPORTED";
                } else if (i == -1004) {
                    if (at.isConnected(this.mContext)) {
                        str = "MEDIA_ERR_DECODE";
                    } else {
                        str = "MEDIA_ERR_NETWORK";
                    }
                } else if (at.isConnected(this.mContext)) {
                    str = "MEDIA_ERR_DECODE";
                } else {
                    str = "MEDIA_ERR_NETWORK";
                }
                bVar.c(sessionId, mediaId, str, i, i2);
            }
            stop();
            bJc();
            return;
        }
        final int currPosSec = this.vgv == -1 ? getCurrPosSec() : this.vgv;
        ab.i(this.TAG, "%s onError now, try to start again. currPlaySec[%d] seekTimeWhenPrepared[%d] currPosSec[%d]", aZk(), Integer.valueOf(currPosSec), Integer.valueOf(this.vgv), Integer.valueOf(getCurrPosSec()));
        stop();
        aNt();
        this.fbD.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(117936);
                AbstractVideoView.this.vgw = true;
                AbstractVideoView.this.ru(currPosSec);
                AbstractVideoView.this.e((double) currPosSec, true);
                AbstractVideoView.this.vgw = false;
                AppMethodBeat.o(117936);
            }
        }, 200);
    }

    public final void pL() {
        ab.i(this.TAG, "%s onPrepared startWhenPrepared[%b] seekTimeWhenPrepared[%d] isPrepared[%b]", aZk(), Boolean.valueOf(this.vgu), Integer.valueOf(this.vgv), Boolean.valueOf(this.VN));
        this.VN = true;
        if (this.klq != null) {
            this.klq.setOneTimeVideoTextureUpdateCallback(this);
        }
        setVideoTotalTime(getVideoDurationSec());
        if (!this.vgu) {
            e(this.vgv < 0 ? 0.0d : (double) this.vgv, this.vgu);
        } else if (this.vgv < 0) {
            if (play() && cGT()) {
                this.vgA.ae(1000, 1000);
            }
        } else if (isLive()) {
            play();
        } else {
            e((double) this.vgv, this.vgu);
        }
        this.vgv = -1;
        this.vgu = true;
        this.vgy = 0;
        this.vgx = 0;
        if (this.rcd != null) {
            this.rcd.cp(getSessionId(), getMediaId());
        }
        if (this.bqQ > 0) {
            ab.d(this.TAG, "%s start error check timer", aZk());
            this.vgB.ae(5000, 5000);
        }
        gp((long) (getReportIdkey() + 2));
        if (this.vgG.viC == 0) {
            this.vgG.viC = bo.anU();
        }
        this.vgG.duration = getVideoDurationSec();
        if (this.vgG.startTimeStamp > 0 && this.vgG.viC > 0) {
            int i;
            int i2;
            int i3 = (int) ((this.vgG.viC - this.vgG.startTimeStamp) / 1000);
            if (at.isWifi(this.mContext)) {
                i = 20;
                i2 = 24;
            } else if (at.is4G(this.mContext)) {
                i = 25;
                i2 = 29;
            } else if (at.is3G(this.mContext)) {
                i = 30;
                i2 = 34;
            } else if (at.is2G(this.mContext)) {
                i = 35;
                i2 = 39;
            } else {
                return;
            }
            ab.d(this.TAG, "%s rptFirstPlayTime [%d]", aZk(), Integer.valueOf(bo.h((Integer) com.tencent.mm.plugin.report.e.a(i3, new int[]{1, 2, 3, 4}, i + getReportIdkey(), i2 + getReportIdkey()))));
            gp((long) i2);
        }
    }

    public void bQL() {
        ab.i(this.TAG, "%s onTextureUpdate ", aZk());
        bJc();
    }

    public void EA() {
        ab.i(this.TAG, "%s onCompletion", aZk());
        bJc();
        stopTimer();
        if (this.rcd != null) {
            this.rcd.cq(getSessionId(), getMediaId());
        }
        this.vgy = 0;
        this.vgx = 0;
        gp((long) (getReportIdkey() + 7));
    }

    public final int dG(int i, int i2) {
        return 0;
    }

    public void dH(int i, int i2) {
        ab.i(this.TAG, "%s on get video size [%d, %d]", aZk(), Integer.valueOf(i), Integer.valueOf(i2));
        if (this.rcd != null) {
            this.rcd.d(getSessionId(), getMediaId(), i, i2);
        }
        gp((long) (getReportIdkey() + 8));
    }

    public void cU(boolean z) {
        ab.i(this.TAG, "%s on seek complete startPlay[%b]", aZk(), Boolean.valueOf(z));
        if (this.klq != null) {
            this.klq.setOneTimeVideoTextureUpdateCallback(this);
        }
        bJc();
        nF(z);
        Dq(getCurrPosSec());
        if (z) {
            cV(false);
            this.vgs = false;
            if (this.rcd != null) {
                this.rcd.cs(getSessionId(), getMediaId());
            }
        }
    }

    public void akY() {
        ab.i(this.TAG, "%s on surface available", aZk());
        cV(false);
    }

    /* Access modifiers changed, original: protected */
    public boolean cGT() {
        return true;
    }

    public void setReporter(h.c cVar) {
        this.vgF = cVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final void gp(long j) {
        if (this.vgF != null) {
            this.vgF.gp(j);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void cso() {
        if (this.vgG.startTimeStamp == 0) {
            this.vgG.startTimeStamp = bo.anU();
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void diN() {
        if (this.vgG.rlG == 0) {
            this.vgG.rlG = bo.anU();
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void diO() {
        this.vgG.viE = bo.anU();
    }

    /* Access modifiers changed, original: protected|final */
    public final void diP() {
        this.vgG.viF = bo.anU();
        if (this.vgG.viE > 0) {
            j jVar = this.vgG;
            jVar.viG += this.vgG.viF - this.vgG.viE;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void diQ() {
        j jVar = this.vgG;
        jVar.blockCount++;
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
            if (at.isWifi(this.mContext)) {
                i = 70;
                i2 = 74;
            } else if (at.is4G(this.mContext)) {
                i = 75;
                i2 = 79;
            } else if (at.is3G(this.mContext)) {
                i = 80;
                i2 = 84;
            } else if (at.is2G(this.mContext)) {
                i = 85;
                i2 = 89;
            } else {
                return;
            }
            ab.d(this.TAG, "%s rptResumeTime [%d]", aZk(), Integer.valueOf(bo.h((Integer) com.tencent.mm.plugin.report.e.a(i3, new int[]{1, 2, 3, 4}, i + getReportIdkey(), i2 + getReportIdkey()))));
            gp((long) i2);
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

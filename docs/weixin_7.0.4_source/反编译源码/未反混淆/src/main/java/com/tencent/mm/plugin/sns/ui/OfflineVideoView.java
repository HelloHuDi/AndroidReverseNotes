package com.tencent.mm.plugin.sns.ui;

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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.ui.base.h;

public class OfflineVideoView extends RelativeLayout implements com.tencent.mm.pluginsdk.ui.tools.e.a {
    private int bqQ;
    public int duration;
    private boolean eif;
    public ak kkp;
    public e klq;
    public ap klw;
    private Context mContext;
    private ImageView mmB;
    private RelativeLayout mmW;
    private boolean mqg;
    private boolean mqh;
    private ProgressBar mqj;
    public a rkX;
    public boolean rkY;
    public boolean rkZ;
    public int rla;
    private e.e rlb;

    public interface a {
        void Dq(int i);

        void EA();

        boolean a(PString pString);

        void onStart(int i);
    }

    static /* synthetic */ void e(OfflineVideoView offlineVideoView) {
        AppMethodBeat.i(38383);
        offlineVideoView.bJc();
        AppMethodBeat.o(38383);
    }

    public OfflineVideoView(Context context) {
        this(context, null);
    }

    public OfflineVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OfflineVideoView(Context context, AttributeSet attributeSet, int i) {
        boolean z;
        super(context, attributeSet, i);
        AppMethodBeat.i(38368);
        this.mContext = null;
        this.eif = false;
        this.mqg = false;
        this.rkY = false;
        this.rkZ = true;
        this.rla = -1;
        this.bqQ = 0;
        this.duration = 0;
        this.kkp = new ak(Looper.getMainLooper());
        this.klw = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
            public final boolean BI() {
                AppMethodBeat.i(38366);
                if (OfflineVideoView.this.klq == null) {
                    AppMethodBeat.o(38366);
                    return false;
                }
                if (((View) OfflineVideoView.this.klq).getAlpha() < 1.0f) {
                    OfflineVideoView.this.a(true, 1.0f);
                }
                if (OfflineVideoView.this.klq.isPlaying()) {
                    OfflineVideoView.e(OfflineVideoView.this);
                    OfflineVideoView offlineVideoView = OfflineVideoView.this;
                    int currentPosition = OfflineVideoView.this.klq.getCurrentPosition() / 1000;
                    if (offlineVideoView.rkX != null) {
                        offlineVideoView.rkX.Dq(currentPosition);
                    }
                }
                AppMethodBeat.o(38366);
                return true;
            }
        }, true);
        this.rlb = new e.e() {
            public final void bQL() {
                AppMethodBeat.i(38367);
                ab.i("MicroMsg.OfflineVideoView", "%d on texture update.", Integer.valueOf(OfflineVideoView.this.hashCode()));
                try {
                    OfflineVideoView.this.a(true, 1.0f);
                    AppMethodBeat.o(38367);
                } catch (Exception e) {
                    ab.e("MicroMsg.OfflineVideoView", "texture view update. error " + e.toString());
                    AppMethodBeat.o(38367);
                }
            }
        };
        this.mContext = context;
        ab.i("MicroMsg.OfflineVideoView", "%d ui init view.", Integer.valueOf(hashCode()));
        LayoutInflater.from(this.mContext).inflate(R.layout.ax5, this);
        this.mmB = (ImageView) findViewById(R.id.aex);
        this.mmW = (RelativeLayout) findViewById(R.id.aey);
        this.mqj = (ProgressBar) findViewById(R.id.a9d);
        if (d.fP(18)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            this.mqh = true;
            this.klq = new VideoPlayerTextureView(this.mContext);
        } else {
            this.mqh = false;
            this.klq = new VideoTextureView(this.mContext);
        }
        this.klq.setVideoCallback(this);
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.addRule(13);
        this.mmW.addView((View) this.klq, layoutParams);
        a(false, 0.0f);
        AppMethodBeat.o(38368);
    }

    public void setVideoCallback(a aVar) {
        this.rkX = aVar;
    }

    public void setMute(boolean z) {
        AppMethodBeat.i(38369);
        this.eif = z;
        this.klq.setMute(this.eif);
        AppMethodBeat.o(38369);
    }

    public final void onResume() {
        AppMethodBeat.i(38370);
        ab.d("MicroMsg.OfflineVideoView", "%d on resume %s", Integer.valueOf(hashCode()), bo.dpG());
        if (!this.mqg) {
            bwD();
        }
        this.rkY = true;
        AppMethodBeat.o(38370);
    }

    public final void bwD() {
        AppMethodBeat.i(38371);
        if (this.rkX != null) {
            PString pString = new PString();
            PString pString2 = new PString();
            if (this.rkX.a(pString)) {
                if (!bo.isNullOrNil(pString2.value)) {
                    Zz(pString2.value);
                }
                if (!bo.isNullOrNil(pString.value)) {
                    Mj(pString.value);
                    AppMethodBeat.o(38371);
                    return;
                }
            }
            aNt();
            a(false, 0.0f);
            AppMethodBeat.o(38371);
            return;
        }
        ab.w("MicroMsg.OfflineVideoView", "%d toggle video but video callback is null", Integer.valueOf(hashCode()));
        AppMethodBeat.o(38371);
    }

    public final void Zz(final String str) {
        AppMethodBeat.i(38372);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(38372);
            return;
        }
        this.kkp.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(38360);
                if (OfflineVideoView.this.mmB != null) {
                    ab.i("MicroMsg.OfflineVideoView", "%d fresh thumb image", Integer.valueOf(hashCode()));
                    OfflineVideoView.this.mmB.setImageBitmap(b.i(str, 1.0f));
                }
                AppMethodBeat.o(38360);
            }
        });
        AppMethodBeat.o(38372);
    }

    public final void onError(int i, int i2) {
        AppMethodBeat.i(38373);
        ab.e("MicroMsg.OfflineVideoView", "%d on play video error what %d extra %d isMMVideoPlayer %b errorCount %d", Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.mqh), Integer.valueOf(this.bqQ));
        this.bqQ++;
        final String videoPath = this.klq.getVideoPath();
        this.klq.stop();
        this.mqg = true;
        a(false, 0.0f);
        if (this.bqQ <= 3) {
            this.kkp.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(38361);
                    OfflineVideoView.this.Mj(videoPath);
                    AppMethodBeat.o(38361);
                }
            }, 200);
            AppMethodBeat.o(38373);
            return;
        }
        if (!bo.isNullOrNil(videoPath)) {
            ab.w("MicroMsg.OfflineVideoView", "%d start third player to play", Integer.valueOf(hashCode()));
            this.kkp.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(38362);
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    k.a(OfflineVideoView.this.getContext(), intent, com.tencent.mm.vfs.e.asY(videoPath), "video/*");
                    try {
                        OfflineVideoView.this.getContext().startActivity(intent);
                        AppMethodBeat.o(38362);
                    } catch (Exception e) {
                        ab.e("MicroMsg.OfflineVideoView", "startActivity fail, activity not found");
                        h.g(OfflineVideoView.this.getContext(), R.string.bpq, R.string.bpr);
                        AppMethodBeat.o(38362);
                    }
                }
            });
        }
        AppMethodBeat.o(38373);
    }

    public final void a(final boolean z, final float f) {
        AppMethodBeat.i(38374);
        this.kkp.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(38363);
                ab.i("MicroMsg.OfflineVideoView", "%d switch video model isVideoPlay %b %f", Integer.valueOf(OfflineVideoView.this.hashCode()), Boolean.valueOf(z), Float.valueOf(f));
                View view = (View) OfflineVideoView.this.klq;
                if (z) {
                    view.setAlpha(f);
                    view.setVisibility(0);
                    OfflineVideoView.this.mmW.setVisibility(0);
                    OfflineVideoView.this.mmW.setAlpha(f);
                    if (((double) f) >= 1.0d) {
                        OfflineVideoView.this.mmB.setVisibility(8);
                        AppMethodBeat.o(38363);
                        return;
                    }
                }
                view.setVisibility(0);
                OfflineVideoView.this.mmW.setVisibility(0);
                OfflineVideoView.this.mmW.setAlpha(0.0f);
                OfflineVideoView.this.mmB.setVisibility(0);
                AppMethodBeat.o(38363);
            }
        });
        AppMethodBeat.o(38374);
    }

    public final void pL() {
        AppMethodBeat.i(38375);
        a(true, 0.0f);
        this.mqg = false;
        bJc();
        this.duration = this.klq.getDuration() / 1000;
        ab.i("MicroMsg.OfflineVideoView", "%d on prepared. shouldPlayWhenPrepared [%b] shouldSeekTimeWhenPrepared[%d]", Integer.valueOf(hashCode()), Boolean.valueOf(this.rkZ), Integer.valueOf(this.rla));
        if (this.rkZ) {
            if (this.rla <= 0) {
                this.klq.start();
            } else {
                ae(this.rla, true);
            }
            startTimer();
            if (this.rkX != null) {
                this.rkX.onStart(this.duration);
            }
        } else {
            ae(this.rla > 0 ? this.rla : 0, false);
        }
        this.rla = -1;
        AppMethodBeat.o(38375);
    }

    private void aNt() {
        AppMethodBeat.i(38376);
        this.kkp.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(38364);
                ab.i("MicroMsg.OfflineVideoView", "%d show loading. downloadMode %d", Integer.valueOf(OfflineVideoView.this.hashCode()), Integer.valueOf(OfflineVideoView.this.hashCode()));
                if (!(OfflineVideoView.this.mqj == null || OfflineVideoView.this.mqj.getVisibility() == 0)) {
                    OfflineVideoView.this.mqj.setVisibility(0);
                }
                AppMethodBeat.o(38364);
            }
        });
        AppMethodBeat.o(38376);
    }

    public final void bJc() {
        AppMethodBeat.i(38377);
        this.kkp.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(38365);
                if (!(OfflineVideoView.this.mqj == null || OfflineVideoView.this.mqj.getVisibility() == 8)) {
                    ab.i("MicroMsg.OfflineVideoView", "%d hide loading.", Integer.valueOf(OfflineVideoView.this.hashCode()));
                    OfflineVideoView.this.mqj.setVisibility(8);
                }
                AppMethodBeat.o(38365);
            }
        });
        AppMethodBeat.o(38377);
    }

    public final void startTimer() {
        AppMethodBeat.i(38378);
        this.klw.ae(1000, 1000);
        AppMethodBeat.o(38378);
    }

    public final void EA() {
        AppMethodBeat.i(38379);
        ab.i("MicroMsg.OfflineVideoView", "%d on completion", Integer.valueOf(hashCode()));
        if (this.rkX != null) {
            this.rkX.EA();
        } else if (d.iX(18) || !this.mqh) {
            ae(0, true);
            AppMethodBeat.o(38379);
            return;
        } else if (this.klq != null) {
            String videoPath = this.klq.getVideoPath();
            this.klq.stop();
            Mj(videoPath);
            AppMethodBeat.o(38379);
            return;
        }
        AppMethodBeat.o(38379);
    }

    public final void Mj(String str) {
        AppMethodBeat.i(38380);
        ab.i("MicroMsg.OfflineVideoView", "%d prepare video  filePath %s", Integer.valueOf(hashCode()), str);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.OfflineVideoView", "%d prepare video but filepath is null.", Integer.valueOf(hashCode()));
            AppMethodBeat.o(38380);
            return;
        }
        if (this.klq != null) {
            this.klq.setOneTimeVideoTextureUpdateCallback(this.rlb);
            this.klq.setVideoPath(str);
        }
        AppMethodBeat.o(38380);
    }

    public final void ae(int i, boolean z) {
        AppMethodBeat.i(38381);
        ab.i("MicroMsg.OfflineVideoView", "%d seek second %d afterSeekPlay %b", Integer.valueOf(hashCode()), Integer.valueOf(i), Boolean.valueOf(z));
        bJc();
        this.klq.d((double) i, z);
        startTimer();
        AppMethodBeat.o(38381);
    }

    public final int dG(int i, int i2) {
        return 0;
    }

    public final void dH(int i, int i2) {
    }

    public int getCurrentPosition() {
        AppMethodBeat.i(38382);
        if (this.klq != null) {
            int currentPosition = this.klq.getCurrentPosition() / 1000;
            AppMethodBeat.o(38382);
            return currentPosition;
        }
        AppMethodBeat.o(38382);
        return 0;
    }
}

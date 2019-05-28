package com.tencent.p177mm.plugin.sns.p520ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14980e;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14981a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.VideoPlayerTextureView;
import com.tencent.p177mm.pluginsdk.p597ui.tools.VideoTextureView;
import com.tencent.p177mm.pointers.PString;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C15429k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.plugin.sns.ui.OfflineVideoView */
public class OfflineVideoView extends RelativeLayout implements C14981a {
    private int bqQ;
    public int duration;
    private boolean eif;
    public C7306ak kkp;
    public C14979e klq;
    public C7564ap klw;
    private Context mContext;
    private ImageView mmB;
    private RelativeLayout mmW;
    private boolean mqg;
    private boolean mqh;
    private ProgressBar mqj;
    public C41311a rkX;
    public boolean rkY;
    public boolean rkZ;
    public int rla;
    private C14980e rlb;

    /* renamed from: com.tencent.mm.plugin.sns.ui.OfflineVideoView$5 */
    class C134885 implements Runnable {
        C134885() {
        }

        public final void run() {
            AppMethodBeat.m2504i(38364);
            C4990ab.m7417i("MicroMsg.OfflineVideoView", "%d show loading. downloadMode %d", Integer.valueOf(OfflineVideoView.this.hashCode()), Integer.valueOf(OfflineVideoView.this.hashCode()));
            if (!(OfflineVideoView.this.mqj == null || OfflineVideoView.this.mqj.getVisibility() == 0)) {
                OfflineVideoView.this.mqj.setVisibility(0);
            }
            AppMethodBeat.m2505o(38364);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.OfflineVideoView$7 */
    class C397927 implements C5015a {
        C397927() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(38366);
            if (OfflineVideoView.this.klq == null) {
                AppMethodBeat.m2505o(38366);
                return false;
            }
            if (((View) OfflineVideoView.this.klq).getAlpha() < 1.0f) {
                OfflineVideoView.this.mo65977a(true, 1.0f);
            }
            if (OfflineVideoView.this.klq.isPlaying()) {
                OfflineVideoView.m71963e(OfflineVideoView.this);
                OfflineVideoView offlineVideoView = OfflineVideoView.this;
                int currentPosition = OfflineVideoView.this.klq.getCurrentPosition() / 1000;
                if (offlineVideoView.rkX != null) {
                    offlineVideoView.rkX.mo62896Dq(currentPosition);
                }
            }
            AppMethodBeat.m2505o(38366);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.OfflineVideoView$6 */
    class C413096 implements Runnable {
        C413096() {
        }

        public final void run() {
            AppMethodBeat.m2504i(38365);
            if (!(OfflineVideoView.this.mqj == null || OfflineVideoView.this.mqj.getVisibility() == 8)) {
                C4990ab.m7417i("MicroMsg.OfflineVideoView", "%d hide loading.", Integer.valueOf(OfflineVideoView.this.hashCode()));
                OfflineVideoView.this.mqj.setVisibility(8);
            }
            AppMethodBeat.m2505o(38365);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.OfflineVideoView$8 */
    class C413108 implements C14980e {
        C413108() {
        }

        public final void bQL() {
            AppMethodBeat.m2504i(38367);
            C4990ab.m7417i("MicroMsg.OfflineVideoView", "%d on texture update.", Integer.valueOf(OfflineVideoView.this.hashCode()));
            try {
                OfflineVideoView.this.mo65977a(true, 1.0f);
                AppMethodBeat.m2505o(38367);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.OfflineVideoView", "texture view update. error " + e.toString());
                AppMethodBeat.m2505o(38367);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.OfflineVideoView$a */
    public interface C41311a {
        /* renamed from: Dq */
        void mo62896Dq(int i);

        /* renamed from: EA */
        void mo62897EA();

        /* renamed from: a */
        boolean mo62898a(PString pString);

        void onStart(int i);
    }

    /* renamed from: e */
    static /* synthetic */ void m71963e(OfflineVideoView offlineVideoView) {
        AppMethodBeat.m2504i(38383);
        offlineVideoView.bJc();
        AppMethodBeat.m2505o(38383);
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
        AppMethodBeat.m2504i(38368);
        this.mContext = null;
        this.eif = false;
        this.mqg = false;
        this.rkY = false;
        this.rkZ = true;
        this.rla = -1;
        this.bqQ = 0;
        this.duration = 0;
        this.kkp = new C7306ak(Looper.getMainLooper());
        this.klw = new C7564ap(new C397927(), true);
        this.rlb = new C413108();
        this.mContext = context;
        C4990ab.m7417i("MicroMsg.OfflineVideoView", "%d ui init view.", Integer.valueOf(hashCode()));
        LayoutInflater.from(this.mContext).inflate(2130970831, this);
        this.mmB = (ImageView) findViewById(2131822133);
        this.mmW = (RelativeLayout) findViewById(2131822134);
        this.mqj = (ProgressBar) findViewById(2131821891);
        if (C1443d.m3067fP(18)) {
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
        mo65977a(false, 0.0f);
        AppMethodBeat.m2505o(38368);
    }

    public void setVideoCallback(C41311a c41311a) {
        this.rkX = c41311a;
    }

    public void setMute(boolean z) {
        AppMethodBeat.m2504i(38369);
        this.eif = z;
        this.klq.setMute(this.eif);
        AppMethodBeat.m2505o(38369);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(38370);
        C4990ab.m7411d("MicroMsg.OfflineVideoView", "%d on resume %s", Integer.valueOf(hashCode()), C5046bo.dpG());
        if (!this.mqg) {
            bwD();
        }
        this.rkY = true;
        AppMethodBeat.m2505o(38370);
    }

    public final void bwD() {
        AppMethodBeat.m2504i(38371);
        if (this.rkX != null) {
            PString pString = new PString();
            PString pString2 = new PString();
            if (this.rkX.mo62898a(pString)) {
                if (!C5046bo.isNullOrNil(pString2.value)) {
                    mo65976Zz(pString2.value);
                }
                if (!C5046bo.isNullOrNil(pString.value)) {
                    mo65975Mj(pString.value);
                    AppMethodBeat.m2505o(38371);
                    return;
                }
            }
            aNt();
            mo65977a(false, 0.0f);
            AppMethodBeat.m2505o(38371);
            return;
        }
        C4990ab.m7421w("MicroMsg.OfflineVideoView", "%d toggle video but video callback is null", Integer.valueOf(hashCode()));
        AppMethodBeat.m2505o(38371);
    }

    /* renamed from: Zz */
    public final void mo65976Zz(final String str) {
        AppMethodBeat.m2504i(38372);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(38372);
            return;
        }
        this.kkp.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(38360);
                if (OfflineVideoView.this.mmB != null) {
                    C4990ab.m7417i("MicroMsg.OfflineVideoView", "%d fresh thumb image", Integer.valueOf(hashCode()));
                    OfflineVideoView.this.mmB.setImageBitmap(C4977b.m7374i(str, 1.0f));
                }
                AppMethodBeat.m2505o(38360);
            }
        });
        AppMethodBeat.m2505o(38372);
    }

    public final void onError(int i, int i2) {
        AppMethodBeat.m2504i(38373);
        C4990ab.m7413e("MicroMsg.OfflineVideoView", "%d on play video error what %d extra %d isMMVideoPlayer %b errorCount %d", Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.mqh), Integer.valueOf(this.bqQ));
        this.bqQ++;
        final String videoPath = this.klq.getVideoPath();
        this.klq.stop();
        this.mqg = true;
        mo65977a(false, 0.0f);
        if (this.bqQ <= 3) {
            this.kkp.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(38361);
                    OfflineVideoView.this.mo65975Mj(videoPath);
                    AppMethodBeat.m2505o(38361);
                }
            }, 200);
            AppMethodBeat.m2505o(38373);
            return;
        }
        if (!C5046bo.isNullOrNil(videoPath)) {
            C4990ab.m7421w("MicroMsg.OfflineVideoView", "%d start third player to play", Integer.valueOf(hashCode()));
            this.kkp.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(38362);
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    C15429k.m23712a(OfflineVideoView.this.getContext(), intent, C5730e.asY(videoPath), "video/*");
                    try {
                        OfflineVideoView.this.getContext().startActivity(intent);
                        AppMethodBeat.m2505o(38362);
                    } catch (Exception e) {
                        C4990ab.m7412e("MicroMsg.OfflineVideoView", "startActivity fail, activity not found");
                        C30379h.m48467g(OfflineVideoView.this.getContext(), C25738R.string.bpq, C25738R.string.bpr);
                        AppMethodBeat.m2505o(38362);
                    }
                }
            });
        }
        AppMethodBeat.m2505o(38373);
    }

    /* renamed from: a */
    public final void mo65977a(final boolean z, final float f) {
        AppMethodBeat.m2504i(38374);
        this.kkp.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(38363);
                C4990ab.m7417i("MicroMsg.OfflineVideoView", "%d switch video model isVideoPlay %b %f", Integer.valueOf(OfflineVideoView.this.hashCode()), Boolean.valueOf(z), Float.valueOf(f));
                View view = (View) OfflineVideoView.this.klq;
                if (z) {
                    view.setAlpha(f);
                    view.setVisibility(0);
                    OfflineVideoView.this.mmW.setVisibility(0);
                    OfflineVideoView.this.mmW.setAlpha(f);
                    if (((double) f) >= 1.0d) {
                        OfflineVideoView.this.mmB.setVisibility(8);
                        AppMethodBeat.m2505o(38363);
                        return;
                    }
                }
                view.setVisibility(0);
                OfflineVideoView.this.mmW.setVisibility(0);
                OfflineVideoView.this.mmW.setAlpha(0.0f);
                OfflineVideoView.this.mmB.setVisibility(0);
                AppMethodBeat.m2505o(38363);
            }
        });
        AppMethodBeat.m2505o(38374);
    }

    /* renamed from: pL */
    public final void mo8557pL() {
        AppMethodBeat.m2504i(38375);
        mo65977a(true, 0.0f);
        this.mqg = false;
        bJc();
        this.duration = this.klq.getDuration() / 1000;
        C4990ab.m7417i("MicroMsg.OfflineVideoView", "%d on prepared. shouldPlayWhenPrepared [%b] shouldSeekTimeWhenPrepared[%d]", Integer.valueOf(hashCode()), Boolean.valueOf(this.rkZ), Integer.valueOf(this.rla));
        if (this.rkZ) {
            if (this.rla <= 0) {
                this.klq.start();
            } else {
                mo65978ae(this.rla, true);
            }
            startTimer();
            if (this.rkX != null) {
                this.rkX.onStart(this.duration);
            }
        } else {
            mo65978ae(this.rla > 0 ? this.rla : 0, false);
        }
        this.rla = -1;
        AppMethodBeat.m2505o(38375);
    }

    private void aNt() {
        AppMethodBeat.m2504i(38376);
        this.kkp.post(new C134885());
        AppMethodBeat.m2505o(38376);
    }

    public final void bJc() {
        AppMethodBeat.m2504i(38377);
        this.kkp.post(new C413096());
        AppMethodBeat.m2505o(38377);
    }

    public final void startTimer() {
        AppMethodBeat.m2504i(38378);
        this.klw.mo16770ae(1000, 1000);
        AppMethodBeat.m2505o(38378);
    }

    /* renamed from: EA */
    public final void mo8553EA() {
        AppMethodBeat.m2504i(38379);
        C4990ab.m7417i("MicroMsg.OfflineVideoView", "%d on completion", Integer.valueOf(hashCode()));
        if (this.rkX != null) {
            this.rkX.mo62897EA();
        } else if (C1443d.m3069iX(18) || !this.mqh) {
            mo65978ae(0, true);
            AppMethodBeat.m2505o(38379);
            return;
        } else if (this.klq != null) {
            String videoPath = this.klq.getVideoPath();
            this.klq.stop();
            mo65975Mj(videoPath);
            AppMethodBeat.m2505o(38379);
            return;
        }
        AppMethodBeat.m2505o(38379);
    }

    /* renamed from: Mj */
    public final void mo65975Mj(String str) {
        AppMethodBeat.m2504i(38380);
        C4990ab.m7417i("MicroMsg.OfflineVideoView", "%d prepare video  filePath %s", Integer.valueOf(hashCode()), str);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7421w("MicroMsg.OfflineVideoView", "%d prepare video but filepath is null.", Integer.valueOf(hashCode()));
            AppMethodBeat.m2505o(38380);
            return;
        }
        if (this.klq != null) {
            this.klq.setOneTimeVideoTextureUpdateCallback(this.rlb);
            this.klq.setVideoPath(str);
        }
        AppMethodBeat.m2505o(38380);
    }

    /* renamed from: ae */
    public final void mo65978ae(int i, boolean z) {
        AppMethodBeat.m2504i(38381);
        C4990ab.m7417i("MicroMsg.OfflineVideoView", "%d seek second %d afterSeekPlay %b", Integer.valueOf(hashCode()), Integer.valueOf(i), Boolean.valueOf(z));
        bJc();
        this.klq.mo27356d((double) i, z);
        startTimer();
        AppMethodBeat.m2505o(38381);
    }

    /* renamed from: dG */
    public final int mo8554dG(int i, int i2) {
        return 0;
    }

    /* renamed from: dH */
    public final void mo8555dH(int i, int i2) {
    }

    public int getCurrentPosition() {
        AppMethodBeat.m2504i(38382);
        if (this.klq != null) {
            int currentPosition = this.klq.getCurrentPosition() / 1000;
            AppMethodBeat.m2505o(38382);
            return currentPosition;
        }
        AppMethodBeat.m2505o(38382);
        return 0;
    }
}

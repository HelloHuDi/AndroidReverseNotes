package com.tencent.p177mm.plugin.fav.p410ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.p1510r.C35973a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.plugin.fav.p407a.C36764n;
import com.tencent.p177mm.plugin.fav.p407a.C36764n.C27973a;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.fav.ui.FavVoiceBaseView */
public class FavVoiceBaseView extends LinearLayout implements C27973a {
    private int cAO;
    private int duration;
    private C36764n mgA;
    private ViewGroup mkc;
    private TextView mkd;
    private ImageButton mke;
    private TextView mkf;
    private C45930a mkg;
    private String path = "";

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavVoiceBaseView$2 */
    class C207062 implements OnClickListener {
        C207062() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(74169);
            if (C35973a.m59179bJ(view.getContext()) || C35973a.m59177bH(view.getContext())) {
                AppMethodBeat.m2505o(74169);
            } else if (!C1445f.m3070Mn() && !C5046bo.isNullOrNil(FavVoiceBaseView.this.path)) {
                C23639t.m36492hO(view.getContext());
                AppMethodBeat.m2505o(74169);
            } else if (!C5046bo.m7532bc(FavVoiceBaseView.this.path, "").equals(FavVoiceBaseView.this.mgA.path)) {
                FavVoiceBaseView.m85249i(FavVoiceBaseView.this);
                AppMethodBeat.m2505o(74169);
            } else if (FavVoiceBaseView.this.mgA.buH()) {
                FavVoiceBaseView.this.buJ();
                AppMethodBeat.m2505o(74169);
            } else {
                if (!FavVoiceBaseView.m85250j(FavVoiceBaseView.this)) {
                    FavVoiceBaseView.m85249i(FavVoiceBaseView.this);
                }
                AppMethodBeat.m2505o(74169);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavVoiceBaseView$1 */
    class C341421 implements Runnable {
        C341421() {
        }

        public final void run() {
            AppMethodBeat.m2504i(74168);
            FavVoiceBaseView.this.mkg.mo73778Vd();
            AppMethodBeat.m2505o(74168);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavVoiceBaseView$a */
    class C45930a extends C7306ak {
        boolean isPaused;
        float mki;
        float mkj;
        int mkk;
        int mkl;

        private C45930a() {
        }

        /* synthetic */ C45930a(FavVoiceBaseView favVoiceBaseView, byte b) {
            this();
        }

        @SuppressLint({"ResourceType"})
        /* renamed from: vD */
        private void m85239vD(int i) {
            AppMethodBeat.m2504i(74170);
            this.isPaused = false;
            this.mki = C39037b.m66394fY((long) i);
            this.mkj = this.mki;
            this.mkl = C1338a.fromDPToPix(FavVoiceBaseView.this.getContext(), 3);
            FavVoiceBaseView.this.mkf.setText(C34171j.m56018B(FavVoiceBaseView.this.getContext(), (int) this.mki));
            FavVoiceBaseView.this.mke.setImageResource(C1318a.voicepost_beginicon);
            FavVoiceBaseView.this.mke.setContentDescription(FavVoiceBaseView.this.getContext().getResources().getString(C25738R.string.f9200sq));
            FavVoiceBaseView.this.mkd.setWidth(this.mkl);
            AppMethodBeat.m2505o(74170);
        }

        @SuppressLint({"ResourceType"})
        public final void begin() {
            AppMethodBeat.m2504i(74171);
            stop();
            this.isPaused = false;
            FavVoiceBaseView.this.mke.setImageResource(C1318a.voicepost_pauseicon);
            FavVoiceBaseView.this.mke.setContentDescription(FavVoiceBaseView.this.getContext().getResources().getString(C25738R.string.f9190s9));
            sendEmptyMessage(4096);
            AppMethodBeat.m2505o(74171);
        }

        public final void stop() {
            AppMethodBeat.m2504i(74172);
            this.isPaused = false;
            removeMessages(4096);
            m85239vD(FavVoiceBaseView.this.duration);
            AppMethodBeat.m2505o(74172);
        }

        /* renamed from: Vd */
        public final void mo73778Vd() {
            AppMethodBeat.m2504i(74173);
            this.mkk = ((int) ((1.0f - (this.mkj / this.mki)) * ((float) (FavVoiceBaseView.this.mkc.getWidth() - this.mkl)))) + this.mkl;
            FavVoiceBaseView.this.mkf.setText(C34171j.m56018B(FavVoiceBaseView.this.getContext(), Math.min((int) Math.ceil((double) this.mkj), (int) this.mki)));
            FavVoiceBaseView.this.mkd.setWidth(this.mkk);
            AppMethodBeat.m2505o(74173);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(74174);
            this.mkj = Math.max(0.0f, this.mkj - 0.256f);
            mo73778Vd();
            if (this.mkj <= 0.1f) {
                AppMethodBeat.m2505o(74174);
                return;
            }
            sendEmptyMessageDelayed(4096, 256);
            AppMethodBeat.m2505o(74174);
        }
    }

    public FavVoiceBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(74175);
        super.onConfigurationChanged(configuration);
        C4990ab.m7417i("MicroMsg.FavVoiceBaseView", "on configuration changed, is paused ? %B", Boolean.valueOf(this.mkg.isPaused));
        if (this.mkg.isPaused) {
            this.mkg.postDelayed(new C341421(), 128);
        }
        AppMethodBeat.m2505o(74175);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.m2504i(74176);
        super.onFinishInflate();
        this.mkc = (ViewGroup) findViewById(2131824009);
        this.mkf = (TextView) findViewById(2131824008);
        this.mkd = (TextView) findViewById(2131824010);
        this.mke = (ImageButton) findViewById(2131824007);
        this.mkg = new C45930a(this, (byte) 0);
        this.mke.setOnClickListener(new C207062());
        AppMethodBeat.m2505o(74176);
    }

    public void setVoiceHelper(C36764n c36764n) {
        AppMethodBeat.m2504i(74177);
        this.mgA = c36764n;
        this.mgA.mo58605a(this);
        AppMethodBeat.m2505o(74177);
    }

    public final boolean buJ() {
        AppMethodBeat.m2504i(74178);
        C4990ab.m7416i("MicroMsg.FavVoiceBaseView", "pause play");
        boolean buJ = this.mgA.buJ();
        C45930a c45930a = this.mkg;
        c45930a.isPaused = true;
        c45930a.removeMessages(4096);
        FavVoiceBaseView.this.mke.setImageResource(C1318a.voicepost_beginicon);
        FavVoiceBaseView.this.mke.setContentDescription(FavVoiceBaseView.this.getContext().getResources().getString(C25738R.string.f9200sq));
        this.mkd.setKeepScreenOn(false);
        AppMethodBeat.m2505o(74178);
        return buJ;
    }

    /* renamed from: bI */
    public final void mo6771bI(String str, int i) {
        AppMethodBeat.m2504i(74179);
        C4990ab.m7411d("MicroMsg.FavVoiceBaseView", "on play, my path %s, my duration %d, play path %s", this.path, Integer.valueOf(this.duration), str);
        if (C5046bo.m7532bc(str, "").equals(this.path)) {
            this.mkd.setKeepScreenOn(true);
            this.mkg.begin();
            AppMethodBeat.m2505o(74179);
            return;
        }
        this.mkg.stop();
        this.mkd.setKeepScreenOn(false);
        AppMethodBeat.m2505o(74179);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(74181);
        buJ();
        AppMethodBeat.m2505o(74181);
    }

    public final void onFinish() {
        AppMethodBeat.m2504i(74180);
        C4990ab.m7410d("MicroMsg.FavVoiceBaseView", "stop play");
        this.mgA.stopPlay();
        this.mkg.stop();
        this.mkd.setKeepScreenOn(false);
        AppMethodBeat.m2505o(74180);
    }

    /* renamed from: i */
    static /* synthetic */ void m85249i(FavVoiceBaseView favVoiceBaseView) {
        AppMethodBeat.m2504i(74182);
        C4990ab.m7411d("MicroMsg.FavVoiceBaseView", "start play, path[%s] voiceType[%d]", favVoiceBaseView.path, Integer.valueOf(favVoiceBaseView.cAO));
        if (favVoiceBaseView.mgA.startPlay(favVoiceBaseView.path, favVoiceBaseView.cAO)) {
            favVoiceBaseView.mkd.setKeepScreenOn(true);
            favVoiceBaseView.mkg.begin();
            AppMethodBeat.m2505o(74182);
            return;
        }
        Toast.makeText(favVoiceBaseView.getContext(), C25738R.string.bsb, 1).show();
        AppMethodBeat.m2505o(74182);
    }

    /* renamed from: j */
    static /* synthetic */ boolean m85250j(FavVoiceBaseView favVoiceBaseView) {
        AppMethodBeat.m2504i(74183);
        C4990ab.m7416i("MicroMsg.FavVoiceBaseView", "resume play");
        boolean buI = favVoiceBaseView.mgA.buI();
        C45930a c45930a = favVoiceBaseView.mkg;
        c45930a.isPaused = false;
        c45930a.sendEmptyMessage(4096);
        FavVoiceBaseView.this.mke.setImageResource(C1318a.voicepost_pauseicon);
        FavVoiceBaseView.this.mke.setContentDescription(FavVoiceBaseView.this.getContext().getResources().getString(C25738R.string.f9190s9));
        favVoiceBaseView.mkd.setKeepScreenOn(true);
        AppMethodBeat.m2505o(74183);
        return buI;
    }
}

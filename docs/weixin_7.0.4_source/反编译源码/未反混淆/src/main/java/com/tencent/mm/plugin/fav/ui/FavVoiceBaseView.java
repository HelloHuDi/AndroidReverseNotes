package com.tencent.mm.plugin.fav.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.t;

public class FavVoiceBaseView extends LinearLayout implements com.tencent.mm.plugin.fav.a.n.a {
    private int cAO;
    private int duration;
    private n mgA;
    private ViewGroup mkc;
    private TextView mkd;
    private ImageButton mke;
    private TextView mkf;
    private a mkg;
    private String path = "";

    class a extends ak {
        boolean isPaused;
        float mki;
        float mkj;
        int mkk;
        int mkl;

        private a() {
        }

        /* synthetic */ a(FavVoiceBaseView favVoiceBaseView, byte b) {
            this();
        }

        @SuppressLint({"ResourceType"})
        private void vD(int i) {
            AppMethodBeat.i(74170);
            this.isPaused = false;
            this.mki = b.fY((long) i);
            this.mkj = this.mki;
            this.mkl = com.tencent.mm.bz.a.fromDPToPix(FavVoiceBaseView.this.getContext(), 3);
            FavVoiceBaseView.this.mkf.setText(j.B(FavVoiceBaseView.this.getContext(), (int) this.mki));
            FavVoiceBaseView.this.mke.setImageResource(R.raw.voicepost_beginicon);
            FavVoiceBaseView.this.mke.setContentDescription(FavVoiceBaseView.this.getContext().getResources().getString(R.string.sq));
            FavVoiceBaseView.this.mkd.setWidth(this.mkl);
            AppMethodBeat.o(74170);
        }

        @SuppressLint({"ResourceType"})
        public final void begin() {
            AppMethodBeat.i(74171);
            stop();
            this.isPaused = false;
            FavVoiceBaseView.this.mke.setImageResource(R.raw.voicepost_pauseicon);
            FavVoiceBaseView.this.mke.setContentDescription(FavVoiceBaseView.this.getContext().getResources().getString(R.string.s9));
            sendEmptyMessage(4096);
            AppMethodBeat.o(74171);
        }

        public final void stop() {
            AppMethodBeat.i(74172);
            this.isPaused = false;
            removeMessages(4096);
            vD(FavVoiceBaseView.this.duration);
            AppMethodBeat.o(74172);
        }

        public final void Vd() {
            AppMethodBeat.i(74173);
            this.mkk = ((int) ((1.0f - (this.mkj / this.mki)) * ((float) (FavVoiceBaseView.this.mkc.getWidth() - this.mkl)))) + this.mkl;
            FavVoiceBaseView.this.mkf.setText(j.B(FavVoiceBaseView.this.getContext(), Math.min((int) Math.ceil((double) this.mkj), (int) this.mki)));
            FavVoiceBaseView.this.mkd.setWidth(this.mkk);
            AppMethodBeat.o(74173);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(74174);
            this.mkj = Math.max(0.0f, this.mkj - 0.256f);
            Vd();
            if (this.mkj <= 0.1f) {
                AppMethodBeat.o(74174);
                return;
            }
            sendEmptyMessageDelayed(4096, 256);
            AppMethodBeat.o(74174);
        }
    }

    public FavVoiceBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(74175);
        super.onConfigurationChanged(configuration);
        ab.i("MicroMsg.FavVoiceBaseView", "on configuration changed, is paused ? %B", Boolean.valueOf(this.mkg.isPaused));
        if (this.mkg.isPaused) {
            this.mkg.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(74168);
                    FavVoiceBaseView.this.mkg.Vd();
                    AppMethodBeat.o(74168);
                }
            }, 128);
        }
        AppMethodBeat.o(74175);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(74176);
        super.onFinishInflate();
        this.mkc = (ViewGroup) findViewById(R.id.bsn);
        this.mkf = (TextView) findViewById(R.id.bsm);
        this.mkd = (TextView) findViewById(R.id.bso);
        this.mke = (ImageButton) findViewById(R.id.bsl);
        this.mkg = new a(this, (byte) 0);
        this.mke.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(74169);
                if (com.tencent.mm.r.a.bJ(view.getContext()) || com.tencent.mm.r.a.bH(view.getContext())) {
                    AppMethodBeat.o(74169);
                } else if (!f.Mn() && !bo.isNullOrNil(FavVoiceBaseView.this.path)) {
                    t.hO(view.getContext());
                    AppMethodBeat.o(74169);
                } else if (!bo.bc(FavVoiceBaseView.this.path, "").equals(FavVoiceBaseView.this.mgA.path)) {
                    FavVoiceBaseView.i(FavVoiceBaseView.this);
                    AppMethodBeat.o(74169);
                } else if (FavVoiceBaseView.this.mgA.buH()) {
                    FavVoiceBaseView.this.buJ();
                    AppMethodBeat.o(74169);
                } else {
                    if (!FavVoiceBaseView.j(FavVoiceBaseView.this)) {
                        FavVoiceBaseView.i(FavVoiceBaseView.this);
                    }
                    AppMethodBeat.o(74169);
                }
            }
        });
        AppMethodBeat.o(74176);
    }

    public void setVoiceHelper(n nVar) {
        AppMethodBeat.i(74177);
        this.mgA = nVar;
        this.mgA.a(this);
        AppMethodBeat.o(74177);
    }

    public final boolean buJ() {
        AppMethodBeat.i(74178);
        ab.i("MicroMsg.FavVoiceBaseView", "pause play");
        boolean buJ = this.mgA.buJ();
        a aVar = this.mkg;
        aVar.isPaused = true;
        aVar.removeMessages(4096);
        FavVoiceBaseView.this.mke.setImageResource(R.raw.voicepost_beginicon);
        FavVoiceBaseView.this.mke.setContentDescription(FavVoiceBaseView.this.getContext().getResources().getString(R.string.sq));
        this.mkd.setKeepScreenOn(false);
        AppMethodBeat.o(74178);
        return buJ;
    }

    public final void bI(String str, int i) {
        AppMethodBeat.i(74179);
        ab.d("MicroMsg.FavVoiceBaseView", "on play, my path %s, my duration %d, play path %s", this.path, Integer.valueOf(this.duration), str);
        if (bo.bc(str, "").equals(this.path)) {
            this.mkd.setKeepScreenOn(true);
            this.mkg.begin();
            AppMethodBeat.o(74179);
            return;
        }
        this.mkg.stop();
        this.mkd.setKeepScreenOn(false);
        AppMethodBeat.o(74179);
    }

    public final void onPause() {
        AppMethodBeat.i(74181);
        buJ();
        AppMethodBeat.o(74181);
    }

    public final void onFinish() {
        AppMethodBeat.i(74180);
        ab.d("MicroMsg.FavVoiceBaseView", "stop play");
        this.mgA.stopPlay();
        this.mkg.stop();
        this.mkd.setKeepScreenOn(false);
        AppMethodBeat.o(74180);
    }

    static /* synthetic */ void i(FavVoiceBaseView favVoiceBaseView) {
        AppMethodBeat.i(74182);
        ab.d("MicroMsg.FavVoiceBaseView", "start play, path[%s] voiceType[%d]", favVoiceBaseView.path, Integer.valueOf(favVoiceBaseView.cAO));
        if (favVoiceBaseView.mgA.startPlay(favVoiceBaseView.path, favVoiceBaseView.cAO)) {
            favVoiceBaseView.mkd.setKeepScreenOn(true);
            favVoiceBaseView.mkg.begin();
            AppMethodBeat.o(74182);
            return;
        }
        Toast.makeText(favVoiceBaseView.getContext(), R.string.bsb, 1).show();
        AppMethodBeat.o(74182);
    }

    static /* synthetic */ boolean j(FavVoiceBaseView favVoiceBaseView) {
        AppMethodBeat.i(74183);
        ab.i("MicroMsg.FavVoiceBaseView", "resume play");
        boolean buI = favVoiceBaseView.mgA.buI();
        a aVar = favVoiceBaseView.mkg;
        aVar.isPaused = false;
        aVar.sendEmptyMessage(4096);
        FavVoiceBaseView.this.mke.setImageResource(R.raw.voicepost_pauseicon);
        FavVoiceBaseView.this.mke.setContentDescription(FavVoiceBaseView.this.getContext().getResources().getString(R.string.s9));
        favVoiceBaseView.mkd.setKeepScreenOn(true);
        AppMethodBeat.o(74183);
        return buI;
    }
}

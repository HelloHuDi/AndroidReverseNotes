package com.tencent.mm.plugin.wenote.ui.nativenote.voiceview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.ui.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.t;
import java.util.Iterator;

public class NoteVoiceView extends FrameLayout implements com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.a {
    public int cAO;
    public int duration;
    public View iVh;
    private ViewGroup mkc;
    TextView mkd;
    private ImageButton mke;
    private TextView mkf;
    public String path = "";
    private TextView uVj;
    public a uVk;
    public a uVl;

    public class a extends ak {
        boolean isPaused;
        float mki;
        float mkj;
        int mkk;
        int mkl;

        private a() {
        }

        /* synthetic */ a(NoteVoiceView noteVoiceView, byte b) {
            this();
        }

        @SuppressLint({"ResourceType"})
        public final void vD(int i) {
            AppMethodBeat.i(27212);
            this.isPaused = false;
            this.mki = b.iu((long) i);
            this.mkj = this.mki;
            this.mkl = com.tencent.mm.bz.a.fromDPToPix(NoteVoiceView.this.getContext(), 0);
            NoteVoiceView.this.mkf.setText(j.B(NoteVoiceView.this.getContext(), (int) (this.mki - this.mkj)));
            NoteVoiceView.this.uVj.setText(j.B(NoteVoiceView.this.getContext(), (int) this.mki));
            NoteVoiceView.this.mke.setImageResource(R.raw.voicepost_beginicon);
            NoteVoiceView.this.mke.setContentDescription(NoteVoiceView.this.getContext().getResources().getString(R.string.sq));
            NoteVoiceView.this.mkd.setWidth(this.mkl);
            AppMethodBeat.o(27212);
        }

        public final void stop() {
            AppMethodBeat.i(27213);
            this.isPaused = false;
            removeMessages(4096);
            vD(NoteVoiceView.this.duration);
            AppMethodBeat.o(27213);
        }

        public final void Vd() {
            AppMethodBeat.i(27214);
            this.mkk = ((int) ((1.0f - (this.mkj / this.mki)) * ((float) (NoteVoiceView.this.mkc.getWidth() - this.mkl)))) + this.mkl;
            NoteVoiceView.this.mkf.setText(j.B(NoteVoiceView.this.getContext(), (int) (this.mki - this.mkj)));
            NoteVoiceView.this.uVj.setText(j.B(NoteVoiceView.this.getContext(), (int) this.mki));
            NoteVoiceView.this.mkd.setWidth(this.mkk);
            AppMethodBeat.o(27214);
        }

        @SuppressLint({"ResourceType"})
        public final void os(boolean z) {
            AppMethodBeat.i(27215);
            this.mkl = com.tencent.mm.bz.a.fromDPToPix(NoteVoiceView.this.getContext(), 0);
            NoteVoiceView.this.mke.setImageResource(R.raw.voicepost_beginicon);
            NoteVoiceView.this.mke.setContentDescription(NoteVoiceView.this.getContext().getResources().getString(R.string.sq));
            Vd();
            if (z) {
                NoteVoiceView.this.mke.setImageResource(R.raw.voicepost_pauseicon);
                NoteVoiceView.this.mke.setContentDescription(NoteVoiceView.this.getContext().getResources().getString(R.string.s9));
                sendEmptyMessage(4096);
            }
            AppMethodBeat.o(27215);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(27216);
            this.mkj = Math.max(0.0f, this.mkj - 0.256f);
            Vd();
            if (this.mkj <= 0.1f) {
                AppMethodBeat.o(27216);
                return;
            }
            sendEmptyMessageDelayed(4096, 256);
            AppMethodBeat.o(27216);
        }
    }

    public NoteVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(27217);
        init(context);
        AppMethodBeat.o(27217);
    }

    public NoteVoiceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(27218);
        init(context);
        AppMethodBeat.o(27218);
    }

    private void init(Context context) {
        AppMethodBeat.i(27219);
        LayoutInflater.from(context).inflate(R.layout.aj_, this, true);
        AppMethodBeat.o(27219);
    }

    public final void ahs(String str) {
        AppMethodBeat.i(27220);
        if (!this.path.equals(str)) {
            dfZ();
        }
        AppMethodBeat.o(27220);
    }

    public final void dfX() {
        AppMethodBeat.i(27221);
        dfZ();
        AppMethodBeat.o(27221);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(27222);
        super.onConfigurationChanged(configuration);
        ab.i("MicroMsg.NoteVoiceView", "on configuration changed, is paused ? %B", Boolean.valueOf(this.uVl.isPaused));
        if (this.uVl.isPaused) {
            this.uVl.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(27210);
                    NoteVoiceView.this.uVl.Vd();
                    AppMethodBeat.o(27210);
                }
            }, 128);
        }
        AppMethodBeat.o(27222);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(27223);
        super.onFinishInflate();
        this.mkc = (ViewGroup) findViewById(R.id.bsn);
        this.mkf = (TextView) findViewById(R.id.bsm);
        this.uVj = (TextView) findViewById(R.id.bsp);
        this.mkd = (TextView) findViewById(R.id.bso);
        this.mke = (ImageButton) findViewById(R.id.bsl);
        this.iVh = findViewById(R.id.djx);
        this.uVl = new a(this, (byte) 0);
        this.mke.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(27211);
                if (com.tencent.mm.r.a.bJ(view.getContext()) || com.tencent.mm.r.a.bH(view.getContext())) {
                    AppMethodBeat.o(27211);
                } else if (!f.Mn() && !bo.isNullOrNil(NoteVoiceView.this.path)) {
                    t.hO(view.getContext());
                    AppMethodBeat.o(27211);
                } else if (!bo.bc(NoteVoiceView.this.path, "").equals(NoteVoiceView.this.uVk.path)) {
                    NoteVoiceView.j(NoteVoiceView.this);
                    AppMethodBeat.o(27211);
                } else if (NoteVoiceView.this.uVk.buH()) {
                    NoteVoiceView noteVoiceView = NoteVoiceView.this;
                    ab.i("MicroMsg.NoteVoiceView", "pause play");
                    a aVar = noteVoiceView.uVk;
                    ab.i("MicroMsg.RecordVoiceHelper", "pause play");
                    aj.amB("keep_app_silent");
                    if (aVar.mfO == null) {
                        ab.w("MicroMsg.RecordVoiceHelper", "pause play error, player is null");
                    } else if (aVar.mfO.pause()) {
                        Iterator it = aVar.callbacks.iterator();
                        while (it.hasNext()) {
                            it.next();
                        }
                    }
                    a aVar2 = noteVoiceView.uVl;
                    aVar2.isPaused = true;
                    aVar2.removeMessages(4096);
                    NoteVoiceView.this.mke.setImageResource(R.raw.voicepost_beginicon);
                    NoteVoiceView.this.mke.setContentDescription(NoteVoiceView.this.getContext().getResources().getString(R.string.sq));
                    noteVoiceView.mkd.setKeepScreenOn(false);
                    AppMethodBeat.o(27211);
                } else {
                    boolean z;
                    NoteVoiceView noteVoiceView2 = NoteVoiceView.this;
                    ab.i("MicroMsg.NoteVoiceView", "resume play");
                    a aVar3 = noteVoiceView2.uVk;
                    ab.i("MicroMsg.RecordVoiceHelper", "resume play");
                    aj.amA("keep_app_silent");
                    if (aVar3.mfO == null) {
                        ab.w("MicroMsg.RecordVoiceHelper", "resum play error, player is null");
                        z = false;
                    } else {
                        z = aVar3.mfO.Ew();
                        if (z) {
                            Iterator it2 = aVar3.callbacks.iterator();
                            while (it2.hasNext()) {
                                it2.next();
                            }
                        }
                    }
                    a aVar4 = noteVoiceView2.uVl;
                    aVar4.isPaused = false;
                    aVar4.sendEmptyMessage(4096);
                    NoteVoiceView.this.mke.setImageResource(R.raw.voicepost_pauseicon);
                    NoteVoiceView.this.mke.setContentDescription(NoteVoiceView.this.getContext().getResources().getString(R.string.s9));
                    noteVoiceView2.mkd.setKeepScreenOn(true);
                    if (!z) {
                        NoteVoiceView.j(NoteVoiceView.this);
                    }
                    AppMethodBeat.o(27211);
                }
            }
        });
        AppMethodBeat.o(27223);
    }

    private void dfZ() {
        AppMethodBeat.i(27224);
        this.uVl.stop();
        this.mkd.setKeepScreenOn(false);
        AppMethodBeat.o(27224);
    }

    public void setVoiceHelper(a aVar) {
        AppMethodBeat.i(27225);
        this.uVk = aVar;
        this.uVk.a(this);
        AppMethodBeat.o(27225);
    }

    static /* synthetic */ void j(NoteVoiceView noteVoiceView) {
        AppMethodBeat.i(27226);
        ab.d("MicroMsg.NoteVoiceView", "start play, path[%s] voiceType[%d]", noteVoiceView.path, Integer.valueOf(noteVoiceView.cAO));
        if (noteVoiceView.uVk.startPlay(noteVoiceView.path, noteVoiceView.cAO)) {
            noteVoiceView.mkd.setKeepScreenOn(true);
            a aVar = noteVoiceView.uVl;
            aVar.stop();
            aVar.isPaused = false;
            NoteVoiceView.this.mke.setImageResource(R.raw.voicepost_pauseicon);
            NoteVoiceView.this.mke.setContentDescription(NoteVoiceView.this.getContext().getResources().getString(R.string.s9));
            aVar.sendEmptyMessage(4096);
            AppMethodBeat.o(27226);
            return;
        }
        Toast.makeText(noteVoiceView.getContext(), R.string.bsb, 1).show();
        AppMethodBeat.o(27226);
    }
}

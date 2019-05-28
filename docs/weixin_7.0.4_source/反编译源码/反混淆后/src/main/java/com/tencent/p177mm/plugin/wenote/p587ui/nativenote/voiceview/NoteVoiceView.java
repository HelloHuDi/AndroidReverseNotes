package com.tencent.p177mm.plugin.wenote.p587ui.nativenote.voiceview;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.p1510r.C35973a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p410ui.C34171j;
import com.tencent.p177mm.plugin.wenote.p587ui.nativenote.voiceview.C44019a.C4692a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4997aj;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteVoiceView */
public class NoteVoiceView extends FrameLayout implements C4692a {
    public int cAO;
    public int duration;
    public View iVh;
    private ViewGroup mkc;
    TextView mkd;
    private ImageButton mke;
    private TextView mkf;
    public String path = "";
    private TextView uVj;
    public C44019a uVk;
    public C35751a uVl;

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteVoiceView$2 */
    class C46912 implements OnClickListener {
        C46912() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(27211);
            if (C35973a.m59179bJ(view.getContext()) || C35973a.m59177bH(view.getContext())) {
                AppMethodBeat.m2505o(27211);
            } else if (!C1445f.m3070Mn() && !C5046bo.isNullOrNil(NoteVoiceView.this.path)) {
                C23639t.m36492hO(view.getContext());
                AppMethodBeat.m2505o(27211);
            } else if (!C5046bo.m7532bc(NoteVoiceView.this.path, "").equals(NoteVoiceView.this.uVk.path)) {
                NoteVoiceView.m69298j(NoteVoiceView.this);
                AppMethodBeat.m2505o(27211);
            } else if (NoteVoiceView.this.uVk.buH()) {
                NoteVoiceView noteVoiceView = NoteVoiceView.this;
                C4990ab.m7416i("MicroMsg.NoteVoiceView", "pause play");
                C44019a c44019a = noteVoiceView.uVk;
                C4990ab.m7416i("MicroMsg.RecordVoiceHelper", "pause play");
                C4997aj.amB("keep_app_silent");
                if (c44019a.mfO == null) {
                    C4990ab.m7420w("MicroMsg.RecordVoiceHelper", "pause play error, player is null");
                } else if (c44019a.mfO.pause()) {
                    Iterator it = c44019a.callbacks.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }
                C35751a c35751a = noteVoiceView.uVl;
                c35751a.isPaused = true;
                c35751a.removeMessages(4096);
                NoteVoiceView.this.mke.setImageResource(C1318a.voicepost_beginicon);
                NoteVoiceView.this.mke.setContentDescription(NoteVoiceView.this.getContext().getResources().getString(C25738R.string.f9200sq));
                noteVoiceView.mkd.setKeepScreenOn(false);
                AppMethodBeat.m2505o(27211);
            } else {
                boolean z;
                NoteVoiceView noteVoiceView2 = NoteVoiceView.this;
                C4990ab.m7416i("MicroMsg.NoteVoiceView", "resume play");
                C44019a c44019a2 = noteVoiceView2.uVk;
                C4990ab.m7416i("MicroMsg.RecordVoiceHelper", "resume play");
                C4997aj.amA("keep_app_silent");
                if (c44019a2.mfO == null) {
                    C4990ab.m7420w("MicroMsg.RecordVoiceHelper", "resum play error, player is null");
                    z = false;
                } else {
                    z = c44019a2.mfO.mo33396Ew();
                    if (z) {
                        Iterator it2 = c44019a2.callbacks.iterator();
                        while (it2.hasNext()) {
                            it2.next();
                        }
                    }
                }
                C35751a c35751a2 = noteVoiceView2.uVl;
                c35751a2.isPaused = false;
                c35751a2.sendEmptyMessage(4096);
                NoteVoiceView.this.mke.setImageResource(C1318a.voicepost_pauseicon);
                NoteVoiceView.this.mke.setContentDescription(NoteVoiceView.this.getContext().getResources().getString(C25738R.string.f9190s9));
                noteVoiceView2.mkd.setKeepScreenOn(true);
                if (!z) {
                    NoteVoiceView.m69298j(NoteVoiceView.this);
                }
                AppMethodBeat.m2505o(27211);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteVoiceView$1 */
    class C147971 implements Runnable {
        C147971() {
        }

        public final void run() {
            AppMethodBeat.m2504i(27210);
            NoteVoiceView.this.uVl.mo56525Vd();
            AppMethodBeat.m2505o(27210);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteVoiceView$a */
    public class C35751a extends C7306ak {
        boolean isPaused;
        float mki;
        float mkj;
        int mkk;
        int mkl;

        private C35751a() {
        }

        /* synthetic */ C35751a(NoteVoiceView noteVoiceView, byte b) {
            this();
        }

        @SuppressLint({"ResourceType"})
        /* renamed from: vD */
        public final void mo56528vD(int i) {
            AppMethodBeat.m2504i(27212);
            this.isPaused = false;
            this.mki = C39037b.m66406iu((long) i);
            this.mkj = this.mki;
            this.mkl = C1338a.fromDPToPix(NoteVoiceView.this.getContext(), 0);
            NoteVoiceView.this.mkf.setText(C34171j.m56018B(NoteVoiceView.this.getContext(), (int) (this.mki - this.mkj)));
            NoteVoiceView.this.uVj.setText(C34171j.m56018B(NoteVoiceView.this.getContext(), (int) this.mki));
            NoteVoiceView.this.mke.setImageResource(C1318a.voicepost_beginicon);
            NoteVoiceView.this.mke.setContentDescription(NoteVoiceView.this.getContext().getResources().getString(C25738R.string.f9200sq));
            NoteVoiceView.this.mkd.setWidth(this.mkl);
            AppMethodBeat.m2505o(27212);
        }

        public final void stop() {
            AppMethodBeat.m2504i(27213);
            this.isPaused = false;
            removeMessages(4096);
            mo56528vD(NoteVoiceView.this.duration);
            AppMethodBeat.m2505o(27213);
        }

        /* renamed from: Vd */
        public final void mo56525Vd() {
            AppMethodBeat.m2504i(27214);
            this.mkk = ((int) ((1.0f - (this.mkj / this.mki)) * ((float) (NoteVoiceView.this.mkc.getWidth() - this.mkl)))) + this.mkl;
            NoteVoiceView.this.mkf.setText(C34171j.m56018B(NoteVoiceView.this.getContext(), (int) (this.mki - this.mkj)));
            NoteVoiceView.this.uVj.setText(C34171j.m56018B(NoteVoiceView.this.getContext(), (int) this.mki));
            NoteVoiceView.this.mkd.setWidth(this.mkk);
            AppMethodBeat.m2505o(27214);
        }

        @SuppressLint({"ResourceType"})
        /* renamed from: os */
        public final void mo56526os(boolean z) {
            AppMethodBeat.m2504i(27215);
            this.mkl = C1338a.fromDPToPix(NoteVoiceView.this.getContext(), 0);
            NoteVoiceView.this.mke.setImageResource(C1318a.voicepost_beginicon);
            NoteVoiceView.this.mke.setContentDescription(NoteVoiceView.this.getContext().getResources().getString(C25738R.string.f9200sq));
            mo56525Vd();
            if (z) {
                NoteVoiceView.this.mke.setImageResource(C1318a.voicepost_pauseicon);
                NoteVoiceView.this.mke.setContentDescription(NoteVoiceView.this.getContext().getResources().getString(C25738R.string.f9190s9));
                sendEmptyMessage(4096);
            }
            AppMethodBeat.m2505o(27215);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(27216);
            this.mkj = Math.max(0.0f, this.mkj - 0.256f);
            mo56525Vd();
            if (this.mkj <= 0.1f) {
                AppMethodBeat.m2505o(27216);
                return;
            }
            sendEmptyMessageDelayed(4096, 256);
            AppMethodBeat.m2505o(27216);
        }
    }

    public NoteVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(27217);
        init(context);
        AppMethodBeat.m2505o(27217);
    }

    public NoteVoiceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(27218);
        init(context);
        AppMethodBeat.m2505o(27218);
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(27219);
        LayoutInflater.from(context).inflate(2130970318, this, true);
        AppMethodBeat.m2505o(27219);
    }

    public final void ahs(String str) {
        AppMethodBeat.m2504i(27220);
        if (!this.path.equals(str)) {
            dfZ();
        }
        AppMethodBeat.m2505o(27220);
    }

    public final void dfX() {
        AppMethodBeat.m2504i(27221);
        dfZ();
        AppMethodBeat.m2505o(27221);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(27222);
        super.onConfigurationChanged(configuration);
        C4990ab.m7417i("MicroMsg.NoteVoiceView", "on configuration changed, is paused ? %B", Boolean.valueOf(this.uVl.isPaused));
        if (this.uVl.isPaused) {
            this.uVl.postDelayed(new C147971(), 128);
        }
        AppMethodBeat.m2505o(27222);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.m2504i(27223);
        super.onFinishInflate();
        this.mkc = (ViewGroup) findViewById(2131824009);
        this.mkf = (TextView) findViewById(2131824008);
        this.uVj = (TextView) findViewById(2131824011);
        this.mkd = (TextView) findViewById(2131824010);
        this.mke = (ImageButton) findViewById(2131824007);
        this.iVh = findViewById(2131826423);
        this.uVl = new C35751a(this, (byte) 0);
        this.mke.setOnClickListener(new C46912());
        AppMethodBeat.m2505o(27223);
    }

    private void dfZ() {
        AppMethodBeat.m2504i(27224);
        this.uVl.stop();
        this.mkd.setKeepScreenOn(false);
        AppMethodBeat.m2505o(27224);
    }

    public void setVoiceHelper(C44019a c44019a) {
        AppMethodBeat.m2504i(27225);
        this.uVk = c44019a;
        this.uVk.mo69695a(this);
        AppMethodBeat.m2505o(27225);
    }

    /* renamed from: j */
    static /* synthetic */ void m69298j(NoteVoiceView noteVoiceView) {
        AppMethodBeat.m2504i(27226);
        C4990ab.m7411d("MicroMsg.NoteVoiceView", "start play, path[%s] voiceType[%d]", noteVoiceView.path, Integer.valueOf(noteVoiceView.cAO));
        if (noteVoiceView.uVk.startPlay(noteVoiceView.path, noteVoiceView.cAO)) {
            noteVoiceView.mkd.setKeepScreenOn(true);
            C35751a c35751a = noteVoiceView.uVl;
            c35751a.stop();
            c35751a.isPaused = false;
            NoteVoiceView.this.mke.setImageResource(C1318a.voicepost_pauseicon);
            NoteVoiceView.this.mke.setContentDescription(NoteVoiceView.this.getContext().getResources().getString(C25738R.string.f9190s9));
            c35751a.sendEmptyMessage(4096);
            AppMethodBeat.m2505o(27226);
            return;
        }
        Toast.makeText(noteVoiceView.getContext(), C25738R.string.bsb, 1).show();
        AppMethodBeat.m2505o(27226);
    }
}

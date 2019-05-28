package com.tencent.p177mm.pluginsdk.p597ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.BasePanelKeybordLayout;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.widget.MMEditText;
import com.tencent.p177mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.p177mm.plugin.report.kvdata.log_13905;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.ChatFooterPanel.C44073a;
import com.tencent.p177mm.pluginsdk.p597ui.chat.C40482n;
import com.tencent.p177mm.pluginsdk.p597ui.chat.C40482n.C40481a;
import com.tencent.p177mm.pluginsdk.p597ui.chat.C44080d;
import com.tencent.p177mm.pluginsdk.p597ui.chat.C44081e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.pluginsdk.ui.VoiceInputFooter */
public class VoiceInputFooter extends BasePanelKeybordLayout {
    private MMActivity crP;
    private ChatFooterPanel eAk;
    MMEditText jZg = null;
    LinearLayout oDC;
    C40482n viY;
    ImageButton viZ;
    private ImageButton vja;
    private boolean vjb = false;
    private boolean vjc = false;
    private final int vjd = 1;
    private final int vje = 2;
    private C30097a vjf;

    /* renamed from: com.tencent.mm.pluginsdk.ui.VoiceInputFooter$5 */
    class C149055 implements C44073a {
        C149055() {
        }

        public final void aYY() {
        }

        /* renamed from: fC */
        public final void mo24351fC(boolean z) {
        }

        public final void aRg() {
            AppMethodBeat.m2504i(27557);
            VoiceInputFooter.this.jZg.getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
            VoiceInputFooter.this.jZg.getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
            AppMethodBeat.m2505o(27557);
        }

        public final void append(String str) {
            AppMethodBeat.m2504i(27558);
            try {
                VoiceInputFooter.this.jZg.asB(str);
                AppMethodBeat.m2505o(27558);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.VoiceInputFooter", e, "", new Object[0]);
                AppMethodBeat.m2505o(27558);
            }
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.VoiceInputFooter$a */
    public interface C30097a {
        void djs();

        /* renamed from: oA */
        void mo27233oA(boolean z);
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.VoiceInputFooter$6 */
    class C358206 implements C40481a {
        C358206() {
        }

        public final void djr() {
        }

        public final void ajt(String str) {
            AppMethodBeat.m2504i(27559);
            if (VoiceInputFooter.this.vjf != null) {
                VoiceInputFooter.this.vjf.djs();
            }
            AppMethodBeat.m2505o(27559);
        }

        /* renamed from: oz */
        public final void mo38994oz(boolean z) {
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.VoiceInputFooter$1 */
    class C358211 implements OnClickListener {
        C358211() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(27554);
            if (VoiceInputFooter.this.getVisibility() == 8) {
                VoiceInputFooter.this.setVisibility(0);
            }
            if (VoiceInputFooter.this.djp()) {
                VoiceInputFooter.m58727a(VoiceInputFooter.this);
            }
            if (VoiceInputFooter.this.aYV()) {
                VoiceInputFooter.m58728b(VoiceInputFooter.this);
            }
            AppMethodBeat.m2505o(27554);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.VoiceInputFooter$2 */
    class C358222 implements OnEditorActionListener {
        C358222() {
        }

        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.VoiceInputFooter$3 */
    class C358233 implements OnClickListener {
        C358233() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(27555);
            VoiceInputFooter.m58729c(VoiceInputFooter.this);
            AppMethodBeat.m2505o(27555);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.VoiceInputFooter$4 */
    class C358244 implements OnClickListener {
        C358244() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(27556);
            VoiceInputFooter.m58730d(VoiceInputFooter.this);
            AppMethodBeat.m2505o(27556);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m58727a(VoiceInputFooter voiceInputFooter) {
        AppMethodBeat.m2504i(27568);
        voiceInputFooter.djq();
        AppMethodBeat.m2505o(27568);
    }

    /* renamed from: b */
    static /* synthetic */ void m58728b(VoiceInputFooter voiceInputFooter) {
        AppMethodBeat.m2504i(27569);
        voiceInputFooter.aRe();
        AppMethodBeat.m2505o(27569);
    }

    public VoiceInputFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(27560);
        this.crP = (MMActivity) context;
        ViewGroup viewGroup = (ViewGroup) C5616v.m8409hu(this.crP).inflate(2130971013, this);
        this.vja = (ImageButton) viewGroup.findViewById(2131828456);
        this.vja.setOnClickListener(new C358233());
        this.viZ = (ImageButton) viewGroup.findViewById(2131825682);
        this.viZ.setOnClickListener(new C358244());
        if (C44081e.vom == null) {
            this.eAk = new C44080d(this.crP);
            AppMethodBeat.m2505o(27560);
            return;
        }
        this.eAk = C44081e.vom.mo35682dF(getContext());
        this.eAk.setEntranceScene(ChatFooterPanel.vhh);
        this.eAk.setVisibility(8);
        this.oDC = (LinearLayout) findViewById(2131820987);
        this.oDC.setOnClickListener(null);
        this.oDC.addView(this.eAk, -1, 0);
        this.eAk.mo11687AD();
        this.eAk.mo11691bf(false);
        this.eAk.setOnTextOperationListener(new C149055());
        AppMethodBeat.m2505o(27560);
    }

    public void setVoiceInputFooterListener(C30097a c30097a) {
        this.vjf = c30097a;
    }

    public final boolean aYV() {
        AppMethodBeat.m2504i(27561);
        if (this.eAk.getVisibility() == 0) {
            AppMethodBeat.m2505o(27561);
            return true;
        }
        AppMethodBeat.m2505o(27561);
        return false;
    }

    public final boolean djp() {
        AppMethodBeat.m2504i(27562);
        if (this.viY.getVisibility() == 0) {
            AppMethodBeat.m2505o(27562);
            return true;
        }
        AppMethodBeat.m2505o(27562);
        return false;
    }

    /* Access modifiers changed, original: final */
    public final void djq() {
        AppMethodBeat.m2504i(27563);
        this.vjb = false;
        if (this.viY != null) {
            this.viY.pause();
            this.viY.setVisibility(8);
            this.vja.setImageResource(C25738R.drawable.a4y);
            this.viZ.setVisibility(0);
            if (this.vjf != null) {
                this.vjf.mo27233oA(false);
            }
        }
        AppMethodBeat.m2505o(27563);
    }

    /* Access modifiers changed, original: final */
    public final void aRe() {
        AppMethodBeat.m2504i(27564);
        this.vjc = false;
        this.eAk.onPause();
        this.eAk.setVisibility(8);
        AppMethodBeat.m2505o(27564);
    }

    public List<View> getPanelView() {
        AppMethodBeat.m2504i(27565);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.eAk);
        arrayList.add(this.viY);
        AppMethodBeat.m2505o(27565);
        return arrayList;
    }

    public final void release() {
        AppMethodBeat.m2504i(27566);
        if (this.eAk != null) {
            this.eAk.mo11686AC();
            this.eAk.destroy();
        }
        if (this.viY != null) {
            this.viY.destroy();
        }
        AppMethodBeat.m2505o(27566);
    }

    /* renamed from: kT */
    private static void m58733kT(int i) {
        AppMethodBeat.m2504i(27567);
        VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
        if (i == 1) {
            voiceInputBehavior.smileIconClick = 1;
        } else if (i == 2) {
            voiceInputBehavior.voiceIconClick = 1;
        } else {
            AppMethodBeat.m2505o(27567);
            return;
        }
        C4990ab.m7417i("MicroMsg.VoiceInputFooter", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", Integer.valueOf(voiceInputBehavior.cancel), Integer.valueOf(voiceInputBehavior.send), Integer.valueOf(voiceInputBehavior.click), Integer.valueOf(voiceInputBehavior.longClick), Long.valueOf(voiceInputBehavior.longClickTime), Integer.valueOf(voiceInputBehavior.textClick), Integer.valueOf(voiceInputBehavior.textChangeCount), Long.valueOf(voiceInputBehavior.textChangeTime), Integer.valueOf(voiceInputBehavior.textChangeReturn), Long.valueOf(voiceInputBehavior.voiceInputTime), Integer.valueOf(voiceInputBehavior.fail), Integer.valueOf(voiceInputBehavior.clear), Integer.valueOf(voiceInputBehavior.smileIconClick), Integer.valueOf(voiceInputBehavior.voiceIconClick), Integer.valueOf(voiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(voiceInputBehavior.fullScreenVoiceLongClickTime));
        log_13905 log_13905 = new log_13905();
        log_13905.viOp_ = voiceInputBehavior;
        C7060h.pYm.mo15417c(13905, log_13905);
        AppMethodBeat.m2505o(27567);
    }

    /* renamed from: c */
    static /* synthetic */ void m58729c(VoiceInputFooter voiceInputFooter) {
        AppMethodBeat.m2504i(27570);
        voiceInputFooter.jZg.requestFocus();
        if (voiceInputFooter.vjb) {
            voiceInputFooter.djq();
            voiceInputFooter.crP.showVKB();
        } else {
            voiceInputFooter.vjb = true;
            voiceInputFooter.crP.aqX();
            if (voiceInputFooter.aYV()) {
                voiceInputFooter.aRe();
            }
            if (voiceInputFooter.viY != null) {
                voiceInputFooter.viY.setVisibility(0);
            }
            voiceInputFooter.vja.setImageResource(C25738R.drawable.f6584ix);
            voiceInputFooter.viZ.setImageResource(C25738R.drawable.f6583iv);
            voiceInputFooter.viZ.setVisibility(8);
            if (voiceInputFooter.vjf != null) {
                voiceInputFooter.vjf.mo27233oA(true);
            }
        }
        VoiceInputFooter.m58733kT(2);
        AppMethodBeat.m2505o(27570);
    }

    /* renamed from: d */
    static /* synthetic */ void m58730d(VoiceInputFooter voiceInputFooter) {
        AppMethodBeat.m2504i(27571);
        if (voiceInputFooter.djp()) {
            voiceInputFooter.djq();
        }
        if (voiceInputFooter.vjc) {
            voiceInputFooter.jZg.requestFocus();
            voiceInputFooter.aRe();
            voiceInputFooter.crP.showVKB();
            voiceInputFooter.viZ.setImageResource(C25738R.drawable.f6583iv);
        } else {
            voiceInputFooter.crP.aqX();
            voiceInputFooter.vjc = true;
            voiceInputFooter.eAk.onResume();
            voiceInputFooter.eAk.setVisibility(0);
            voiceInputFooter.jZg.requestFocus();
            voiceInputFooter.viZ.setImageResource(C25738R.drawable.f6584ix);
            voiceInputFooter.vja.setImageResource(C25738R.drawable.a4y);
        }
        VoiceInputFooter.m58733kT(1);
        AppMethodBeat.m2505o(27571);
    }
}

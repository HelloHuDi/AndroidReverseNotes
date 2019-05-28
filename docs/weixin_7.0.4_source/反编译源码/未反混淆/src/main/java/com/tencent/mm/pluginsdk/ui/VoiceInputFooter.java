package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.pluginsdk.ui.chat.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

public class VoiceInputFooter extends BasePanelKeybordLayout {
    private MMActivity crP;
    private ChatFooterPanel eAk;
    MMEditText jZg = null;
    LinearLayout oDC;
    n viY;
    ImageButton viZ;
    private ImageButton vja;
    private boolean vjb = false;
    private boolean vjc = false;
    private final int vjd = 1;
    private final int vje = 2;
    private a vjf;

    public interface a {
        void djs();

        void oA(boolean z);
    }

    static /* synthetic */ void a(VoiceInputFooter voiceInputFooter) {
        AppMethodBeat.i(27568);
        voiceInputFooter.djq();
        AppMethodBeat.o(27568);
    }

    static /* synthetic */ void b(VoiceInputFooter voiceInputFooter) {
        AppMethodBeat.i(27569);
        voiceInputFooter.aRe();
        AppMethodBeat.o(27569);
    }

    public VoiceInputFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(27560);
        this.crP = (MMActivity) context;
        ViewGroup viewGroup = (ViewGroup) v.hu(this.crP).inflate(R.layout.b20, this);
        this.vja = (ImageButton) viewGroup.findViewById(R.id.f1v);
        this.vja.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(27555);
                VoiceInputFooter.c(VoiceInputFooter.this);
                AppMethodBeat.o(27555);
            }
        });
        this.viZ = (ImageButton) viewGroup.findViewById(R.id.d0w);
        this.viZ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(27556);
                VoiceInputFooter.d(VoiceInputFooter.this);
                AppMethodBeat.o(27556);
            }
        });
        if (e.vom == null) {
            this.eAk = new d(this.crP);
            AppMethodBeat.o(27560);
            return;
        }
        this.eAk = e.vom.dF(getContext());
        this.eAk.setEntranceScene(ChatFooterPanel.vhh);
        this.eAk.setVisibility(8);
        this.oDC = (LinearLayout) findViewById(R.id.l_);
        this.oDC.setOnClickListener(null);
        this.oDC.addView(this.eAk, -1, 0);
        this.eAk.AD();
        this.eAk.bf(false);
        this.eAk.setOnTextOperationListener(new com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a() {
            public final void aYY() {
            }

            public final void fC(boolean z) {
            }

            public final void aRg() {
                AppMethodBeat.i(27557);
                VoiceInputFooter.this.jZg.getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
                VoiceInputFooter.this.jZg.getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
                AppMethodBeat.o(27557);
            }

            public final void append(String str) {
                AppMethodBeat.i(27558);
                try {
                    VoiceInputFooter.this.jZg.asB(str);
                    AppMethodBeat.o(27558);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.VoiceInputFooter", e, "", new Object[0]);
                    AppMethodBeat.o(27558);
                }
            }
        });
        AppMethodBeat.o(27560);
    }

    public void setVoiceInputFooterListener(a aVar) {
        this.vjf = aVar;
    }

    public final boolean aYV() {
        AppMethodBeat.i(27561);
        if (this.eAk.getVisibility() == 0) {
            AppMethodBeat.o(27561);
            return true;
        }
        AppMethodBeat.o(27561);
        return false;
    }

    public final boolean djp() {
        AppMethodBeat.i(27562);
        if (this.viY.getVisibility() == 0) {
            AppMethodBeat.o(27562);
            return true;
        }
        AppMethodBeat.o(27562);
        return false;
    }

    /* Access modifiers changed, original: final */
    public final void djq() {
        AppMethodBeat.i(27563);
        this.vjb = false;
        if (this.viY != null) {
            this.viY.pause();
            this.viY.setVisibility(8);
            this.vja.setImageResource(R.drawable.a4y);
            this.viZ.setVisibility(0);
            if (this.vjf != null) {
                this.vjf.oA(false);
            }
        }
        AppMethodBeat.o(27563);
    }

    /* Access modifiers changed, original: final */
    public final void aRe() {
        AppMethodBeat.i(27564);
        this.vjc = false;
        this.eAk.onPause();
        this.eAk.setVisibility(8);
        AppMethodBeat.o(27564);
    }

    public List<View> getPanelView() {
        AppMethodBeat.i(27565);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.eAk);
        arrayList.add(this.viY);
        AppMethodBeat.o(27565);
        return arrayList;
    }

    public final void release() {
        AppMethodBeat.i(27566);
        if (this.eAk != null) {
            this.eAk.AC();
            this.eAk.destroy();
        }
        if (this.viY != null) {
            this.viY.destroy();
        }
        AppMethodBeat.o(27566);
    }

    private static void kT(int i) {
        AppMethodBeat.i(27567);
        VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
        if (i == 1) {
            voiceInputBehavior.smileIconClick = 1;
        } else if (i == 2) {
            voiceInputBehavior.voiceIconClick = 1;
        } else {
            AppMethodBeat.o(27567);
            return;
        }
        ab.i("MicroMsg.VoiceInputFooter", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", Integer.valueOf(voiceInputBehavior.cancel), Integer.valueOf(voiceInputBehavior.send), Integer.valueOf(voiceInputBehavior.click), Integer.valueOf(voiceInputBehavior.longClick), Long.valueOf(voiceInputBehavior.longClickTime), Integer.valueOf(voiceInputBehavior.textClick), Integer.valueOf(voiceInputBehavior.textChangeCount), Long.valueOf(voiceInputBehavior.textChangeTime), Integer.valueOf(voiceInputBehavior.textChangeReturn), Long.valueOf(voiceInputBehavior.voiceInputTime), Integer.valueOf(voiceInputBehavior.fail), Integer.valueOf(voiceInputBehavior.clear), Integer.valueOf(voiceInputBehavior.smileIconClick), Integer.valueOf(voiceInputBehavior.voiceIconClick), Integer.valueOf(voiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(voiceInputBehavior.fullScreenVoiceLongClickTime));
        log_13905 log_13905 = new log_13905();
        log_13905.viOp_ = voiceInputBehavior;
        h.pYm.c(13905, log_13905);
        AppMethodBeat.o(27567);
    }

    static /* synthetic */ void c(VoiceInputFooter voiceInputFooter) {
        AppMethodBeat.i(27570);
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
            voiceInputFooter.vja.setImageResource(R.drawable.ix);
            voiceInputFooter.viZ.setImageResource(R.drawable.iv);
            voiceInputFooter.viZ.setVisibility(8);
            if (voiceInputFooter.vjf != null) {
                voiceInputFooter.vjf.oA(true);
            }
        }
        kT(2);
        AppMethodBeat.o(27570);
    }

    static /* synthetic */ void d(VoiceInputFooter voiceInputFooter) {
        AppMethodBeat.i(27571);
        if (voiceInputFooter.djp()) {
            voiceInputFooter.djq();
        }
        if (voiceInputFooter.vjc) {
            voiceInputFooter.jZg.requestFocus();
            voiceInputFooter.aRe();
            voiceInputFooter.crP.showVKB();
            voiceInputFooter.viZ.setImageResource(R.drawable.iv);
        } else {
            voiceInputFooter.crP.aqX();
            voiceInputFooter.vjc = true;
            voiceInputFooter.eAk.onResume();
            voiceInputFooter.eAk.setVisibility(0);
            voiceInputFooter.jZg.requestFocus();
            voiceInputFooter.viZ.setImageResource(R.drawable.ix);
            voiceInputFooter.vja.setImageResource(R.drawable.a4y);
        }
        kT(1);
        AppMethodBeat.o(27571);
    }
}

package com.tencent.p177mm.plugin.voiceprint.p545ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.voiceprint.p545ui.C43725a.C29486a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.voiceprint.ui.VoiceTipInfoView */
public class VoiceTipInfoView extends LinearLayout {
    public ProgressBar gHA;
    TextView iDT;
    TextView poi;
    boolean sMN = false;
    private boolean sMO = false;
    private TextView sMP;
    private boolean sMQ = false;
    private float sMR = 0.0f;

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.VoiceTipInfoView$4 */
    class C224554 implements C29486a {
        C224554() {
        }

        public final void cHV() {
        }

        public final void cHW() {
            AppMethodBeat.m2504i(26225);
            VoiceTipInfoView.this.sMP.setVisibility(0);
            VoiceTipInfoView.this.sMQ = false;
            AppMethodBeat.m2505o(26225);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.VoiceTipInfoView$5 */
    class C294815 implements C29486a {
        C294815() {
        }

        public final void cHV() {
        }

        public final void cHW() {
            AppMethodBeat.m2504i(26226);
            VoiceTipInfoView.this.sMP.setVisibility(4);
            VoiceTipInfoView.this.sMQ = false;
            AppMethodBeat.m2505o(26226);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.VoiceTipInfoView$2 */
    class C294822 implements C29486a {
        C294822() {
        }

        public final void cHV() {
        }

        public final void cHW() {
            AppMethodBeat.m2504i(26223);
            VoiceTipInfoView.this.iDT.setVisibility(0);
            VoiceTipInfoView.this.sMN = false;
            AppMethodBeat.m2505o(26223);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.VoiceTipInfoView$1 */
    class C294831 implements C29486a {
        C294831() {
        }

        public final void cHV() {
        }

        public final void cHW() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.VoiceTipInfoView$3 */
    class C294843 implements C29486a {
        C294843() {
        }

        public final void cHV() {
        }

        public final void cHW() {
            AppMethodBeat.m2504i(26224);
            VoiceTipInfoView.this.iDT.setVisibility(4);
            VoiceTipInfoView.this.sMN = false;
            AppMethodBeat.m2505o(26224);
        }
    }

    public VoiceTipInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(26227);
        View inflate = LayoutInflater.from(context).inflate(2130971026, this, true);
        this.gHA = (ProgressBar) inflate.findViewById(2131823898);
        bQt();
        this.iDT = (TextView) inflate.findViewById(2131828458);
        this.poi = (TextView) inflate.findViewById(2131823773);
        this.sMP = (TextView) inflate.findViewById(2131828480);
        reset();
        AppMethodBeat.m2505o(26227);
    }

    public final void reset() {
        AppMethodBeat.m2504i(26228);
        this.poi.setTextSize(0, getContext().getResources().getDimension(C25738R.dimen.aai));
        this.sMR = this.poi.getTextSize();
        this.poi.clearAnimation();
        C4990ab.m7411d("MicroMsg.VoiceTipInfoView", "mTipSize %f", Float.valueOf(this.sMR));
        AppMethodBeat.m2505o(26228);
    }

    public final void bQs() {
        AppMethodBeat.m2504i(26229);
        C4990ab.m7410d("MicroMsg.VoiceTipInfoView", "mProgressBar show");
        this.gHA.setVisibility(0);
        AppMethodBeat.m2505o(26229);
    }

    public final void bQt() {
        AppMethodBeat.m2504i(26230);
        C4990ab.m7410d("MicroMsg.VoiceTipInfoView", "mProgressBar hide");
        this.gHA.setVisibility(8);
        AppMethodBeat.m2505o(26230);
    }

    public void setTipText(String str) {
        AppMethodBeat.m2504i(26231);
        this.poi.setText(str);
        this.poi.setVisibility(0);
        AppMethodBeat.m2505o(26231);
    }

    public void setTipText(int i) {
        AppMethodBeat.m2504i(26232);
        this.poi.setText(i);
        this.poi.setVisibility(0);
        AppMethodBeat.m2505o(26232);
    }

    public void setTitleText(String str) {
        AppMethodBeat.m2504i(26233);
        this.iDT.setText(str);
        this.iDT.setVisibility(0);
        AppMethodBeat.m2505o(26233);
    }

    public void setTitleText(int i) {
        AppMethodBeat.m2504i(26234);
        this.iDT.setText(i);
        this.iDT.setVisibility(0);
        AppMethodBeat.m2505o(26234);
    }

    public final void cIe() {
        AppMethodBeat.m2504i(26235);
        C4990ab.m7411d("MicroMsg.VoiceTipInfoView", "showTitle, titleTv.getVisibility:%d, mAnimingTitle:%b", Integer.valueOf(this.iDT.getVisibility()), Boolean.valueOf(this.sMN));
        if ((this.iDT.getVisibility() == 4 || this.iDT.getVisibility() == 8) && !this.sMN) {
            this.iDT.clearAnimation();
            this.sMN = true;
            C43725a.m78385b(this.iDT, getContext(), new C294822());
            AppMethodBeat.m2505o(26235);
            return;
        }
        C4990ab.m7410d("MicroMsg.VoiceTipInfoView", "showTitle, directly set to VISIBLE");
        this.iDT.clearAnimation();
        this.iDT.setVisibility(0);
        this.iDT.invalidate();
        AppMethodBeat.m2505o(26235);
    }

    public final void cIf() {
        AppMethodBeat.m2504i(26236);
        this.poi.setVisibility(8);
        AppMethodBeat.m2505o(26236);
    }

    public final void cIg() {
        AppMethodBeat.m2504i(26237);
        if (this.sMP.getVisibility() != 4 || this.sMQ) {
            this.sMP.clearAnimation();
            this.sMP.setVisibility(0);
            AppMethodBeat.m2505o(26237);
            return;
        }
        this.sMP.clearAnimation();
        this.sMQ = true;
        TextView textView = this.sMP;
        getContext();
        C43725a.m78386b(textView, new C224554());
        AppMethodBeat.m2505o(26237);
    }

    public final void cIh() {
        AppMethodBeat.m2504i(26238);
        if (this.sMP.getVisibility() != 0 || this.sMQ) {
            this.sMP.clearAnimation();
            this.sMP.setVisibility(4);
            AppMethodBeat.m2505o(26238);
            return;
        }
        this.sMP.clearAnimation();
        this.sMQ = true;
        C43725a.m78383a(this.sMP, getContext(), new C294815());
        AppMethodBeat.m2505o(26238);
    }

    public void setErr(String str) {
        AppMethodBeat.m2504i(26239);
        this.sMP.setText(str);
        AppMethodBeat.m2505o(26239);
    }

    public void setErr(int i) {
        AppMethodBeat.m2504i(26240);
        this.sMP.setText(i);
        AppMethodBeat.m2505o(26240);
    }
}

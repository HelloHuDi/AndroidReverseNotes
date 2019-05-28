package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.voiceprint.ui.a.a;
import com.tencent.mm.sdk.platformtools.ab;

public class VoiceTipInfoView extends LinearLayout {
    public ProgressBar gHA;
    TextView iDT;
    TextView poi;
    boolean sMN = false;
    private boolean sMO = false;
    private TextView sMP;
    private boolean sMQ = false;
    private float sMR = 0.0f;

    public VoiceTipInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(26227);
        View inflate = LayoutInflater.from(context).inflate(R.layout.b8l, this, true);
        this.gHA = (ProgressBar) inflate.findViewById(R.id.bpn);
        bQt();
        this.iDT = (TextView) inflate.findViewById(R.id.f1x);
        this.poi = (TextView) inflate.findViewById(R.id.bm_);
        this.sMP = (TextView) inflate.findViewById(R.id.f2i);
        reset();
        AppMethodBeat.o(26227);
    }

    public final void reset() {
        AppMethodBeat.i(26228);
        this.poi.setTextSize(0, getContext().getResources().getDimension(R.dimen.aai));
        this.sMR = this.poi.getTextSize();
        this.poi.clearAnimation();
        ab.d("MicroMsg.VoiceTipInfoView", "mTipSize %f", Float.valueOf(this.sMR));
        AppMethodBeat.o(26228);
    }

    public final void bQs() {
        AppMethodBeat.i(26229);
        ab.d("MicroMsg.VoiceTipInfoView", "mProgressBar show");
        this.gHA.setVisibility(0);
        AppMethodBeat.o(26229);
    }

    public final void bQt() {
        AppMethodBeat.i(26230);
        ab.d("MicroMsg.VoiceTipInfoView", "mProgressBar hide");
        this.gHA.setVisibility(8);
        AppMethodBeat.o(26230);
    }

    public void setTipText(String str) {
        AppMethodBeat.i(26231);
        this.poi.setText(str);
        this.poi.setVisibility(0);
        AppMethodBeat.o(26231);
    }

    public void setTipText(int i) {
        AppMethodBeat.i(26232);
        this.poi.setText(i);
        this.poi.setVisibility(0);
        AppMethodBeat.o(26232);
    }

    public void setTitleText(String str) {
        AppMethodBeat.i(26233);
        this.iDT.setText(str);
        this.iDT.setVisibility(0);
        AppMethodBeat.o(26233);
    }

    public void setTitleText(int i) {
        AppMethodBeat.i(26234);
        this.iDT.setText(i);
        this.iDT.setVisibility(0);
        AppMethodBeat.o(26234);
    }

    public final void cIe() {
        AppMethodBeat.i(26235);
        ab.d("MicroMsg.VoiceTipInfoView", "showTitle, titleTv.getVisibility:%d, mAnimingTitle:%b", Integer.valueOf(this.iDT.getVisibility()), Boolean.valueOf(this.sMN));
        if ((this.iDT.getVisibility() == 4 || this.iDT.getVisibility() == 8) && !this.sMN) {
            this.iDT.clearAnimation();
            this.sMN = true;
            a.b(this.iDT, getContext(), new a() {
                public final void cHV() {
                }

                public final void cHW() {
                    AppMethodBeat.i(26223);
                    VoiceTipInfoView.this.iDT.setVisibility(0);
                    VoiceTipInfoView.this.sMN = false;
                    AppMethodBeat.o(26223);
                }
            });
            AppMethodBeat.o(26235);
            return;
        }
        ab.d("MicroMsg.VoiceTipInfoView", "showTitle, directly set to VISIBLE");
        this.iDT.clearAnimation();
        this.iDT.setVisibility(0);
        this.iDT.invalidate();
        AppMethodBeat.o(26235);
    }

    public final void cIf() {
        AppMethodBeat.i(26236);
        this.poi.setVisibility(8);
        AppMethodBeat.o(26236);
    }

    public final void cIg() {
        AppMethodBeat.i(26237);
        if (this.sMP.getVisibility() != 4 || this.sMQ) {
            this.sMP.clearAnimation();
            this.sMP.setVisibility(0);
            AppMethodBeat.o(26237);
            return;
        }
        this.sMP.clearAnimation();
        this.sMQ = true;
        TextView textView = this.sMP;
        getContext();
        a.b(textView, new a() {
            public final void cHV() {
            }

            public final void cHW() {
                AppMethodBeat.i(26225);
                VoiceTipInfoView.this.sMP.setVisibility(0);
                VoiceTipInfoView.this.sMQ = false;
                AppMethodBeat.o(26225);
            }
        });
        AppMethodBeat.o(26237);
    }

    public final void cIh() {
        AppMethodBeat.i(26238);
        if (this.sMP.getVisibility() != 0 || this.sMQ) {
            this.sMP.clearAnimation();
            this.sMP.setVisibility(4);
            AppMethodBeat.o(26238);
            return;
        }
        this.sMP.clearAnimation();
        this.sMQ = true;
        a.a(this.sMP, getContext(), new a() {
            public final void cHV() {
            }

            public final void cHW() {
                AppMethodBeat.i(26226);
                VoiceTipInfoView.this.sMP.setVisibility(4);
                VoiceTipInfoView.this.sMQ = false;
                AppMethodBeat.o(26226);
            }
        });
        AppMethodBeat.o(26238);
    }

    public void setErr(String str) {
        AppMethodBeat.i(26239);
        this.sMP.setText(str);
        AppMethodBeat.o(26239);
    }

    public void setErr(int i) {
        AppMethodBeat.i(26240);
        this.sMP.setText(i);
        AppMethodBeat.o(26240);
    }
}

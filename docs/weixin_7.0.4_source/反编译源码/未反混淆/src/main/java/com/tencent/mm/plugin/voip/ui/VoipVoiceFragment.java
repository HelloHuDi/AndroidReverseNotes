package com.tencent.mm.plugin.voip.ui;

import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.a.d;
import com.tencent.mm.plugin.voip.b;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.t;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.Timer;
import java.util.TimerTask;

public class VoipVoiceFragment extends VoipBaseFragment {
    private Runnable lmq = new Runnable() {
        public final void run() {
            AppMethodBeat.i(4948);
            if (VoipVoiceFragment.this.getActivity() == null || VoipVoiceFragment.this.getActivity().isFinishing()) {
                AppMethodBeat.o(4948);
                return;
            }
            VoipVoiceFragment.this.sYG.setVisibility(8);
            AppMethodBeat.o(4948);
        }
    };
    private boolean mIsMute = false;
    private Timer mTimer;
    private TextView nGB;
    private int sRr = 1;
    private boolean sXJ = false;
    private boolean sXL = false;
    private Button sXh;
    private RelativeLayout sYA;
    private MMCheckBox sYB;
    private TextView sYC;
    private RelativeLayout sYD;
    private MMCheckBox sYE;
    private TextView sYF;
    private TextView sYG;
    private TextView sYH;
    private VoipBigIconButton sYI;
    private VoipBigIconButton sYJ;
    private VoipBigIconButton sYK;
    private VoipBigIconButton sYL;
    private VoipSmallIconButton sYM;
    private boolean sYN = false;
    private OpenGlRender sYO;
    private OnClickListener sYP = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(4942);
            boolean isChecked = VoipVoiceFragment.this.sYB.isChecked();
            ab.i("MicroMsg.VoipVoiceFragment", "onSpeakerClick, status: %b", Boolean.valueOf(isChecked));
            VoipVoiceFragment.this.sYB.setEnabled(false);
            if (!(VoipVoiceFragment.this.sVY == null || VoipVoiceFragment.this.sVY.get() == null)) {
                ((c) VoipVoiceFragment.this.sVY.get()).ms(isChecked);
            }
            VoipVoiceFragment.this.sRr = isChecked ? 1 : 2;
            VoipVoiceFragment.this.sYB.setEnabled(true);
            AppMethodBeat.o(4942);
        }
    };
    private OnClickListener sYQ = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(4943);
            boolean isChecked = VoipVoiceFragment.this.sYE.isChecked();
            ab.i("MicroMsg.VoipVoiceFragment", "onMicClick, status: %b", Boolean.valueOf(isChecked));
            VoipVoiceFragment.this.sYE.setEnabled(false);
            if (!(VoipVoiceFragment.this.sVY == null || VoipVoiceFragment.this.sVY.get() == null)) {
                ((c) VoipVoiceFragment.this.sVY.get()).jg(isChecked);
            }
            VoipVoiceFragment.this.mIsMute = isChecked;
            VoipVoiceFragment.this.sYE.setEnabled(true);
            AppMethodBeat.o(4943);
        }
    };
    private OnClickListener sYR = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(4944);
            ab.i("MicroMsg.VoipVoiceFragment", "click accept voice invite button");
            h.pYm.a(11526, true, true, Integer.valueOf(b.cIj().cJZ()), Long.valueOf(b.cIj().cKa()), Long.valueOf(b.cIj().cIK()), Integer.valueOf(2));
            if (!(VoipVoiceFragment.this.sVY == null || VoipVoiceFragment.this.sVY.get() == null || !((c) VoipVoiceFragment.this.sVY.get()).cJq())) {
                VoipVoiceFragment.this.sYI.setEnabled(false);
                VoipVoiceFragment.this.sYx.setText(R.string.f7s);
                VoipVoiceFragment.this.sWv.a(VoipVoiceFragment.this.sYy, VoipBaseFragment.sWo);
                VoipVoiceFragment.this.sYz.setVisibility(0);
                VoipVoiceFragment.this.sYw.setVisibility(8);
                VoipVoiceFragment.this.sYI.setVisibility(8);
                VoipVoiceFragment.this.sYJ.setVisibility(8);
                VoipVoiceFragment.this.sYK.setVisibility(0);
            }
            AppMethodBeat.o(4944);
        }
    };
    private OnClickListener sYS = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(4945);
            ab.i("MicroMsg.VoipVoiceFragment", "click reject voice invite button");
            h.pYm.a(11526, true, true, Integer.valueOf(b.cIj().cJZ()), Long.valueOf(b.cIj().cKa()), Long.valueOf(b.cIj().cIK()), Integer.valueOf(5));
            if (!(VoipVoiceFragment.this.sVY == null || VoipVoiceFragment.this.sVY.get() == null || !((c) VoipVoiceFragment.this.sVY.get()).cJp())) {
                VoipVoiceFragment.this.sYJ.setEnabled(false);
                VoipVoiceFragment.this.sYI.setEnabled(false);
                VoipVoiceFragment.this.fZ(R.string.f6q, -1);
                if (VoipVoiceFragment.this.sWu != null) {
                    VoipVoiceFragment.this.sWu.S(true, false);
                }
            }
            AppMethodBeat.o(4945);
        }
    };
    private OnClickListener sYT = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(4946);
            ab.i("MicroMsg.VoipVoiceFragment", "click hangup voice talking button");
            if (!(VoipVoiceFragment.this.sVY == null || VoipVoiceFragment.this.sVY.get() == null || !((c) VoipVoiceFragment.this.sVY.get()).cJk())) {
                VoipVoiceFragment.this.fZ(R.string.f5m, -1);
            }
            AppMethodBeat.o(4946);
        }
    };
    private OnClickListener sYU = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(4947);
            ab.i("MicroMsg.VoipVoiceFragment", "click cancel voice invite button");
            if (!(VoipVoiceFragment.this.sVY == null || VoipVoiceFragment.this.sVY.get() == null || !((c) VoipVoiceFragment.this.sVY.get()).cJs())) {
                VoipVoiceFragment.this.fZ(R.string.f4f, -1);
                VoipVoiceFragment.this.sYL.setEnabled(false);
            }
            AppMethodBeat.o(4947);
        }
    };
    private OnClickListener sYg = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(4938);
            h.pYm.e(11618, Integer.valueOf(3), Integer.valueOf(1));
            if (!(VoipVoiceFragment.this.sVY == null || VoipVoiceFragment.this.sVY.get() == null)) {
                ((c) VoipVoiceFragment.this.sVY.get()).mv(true);
            }
            if (VoipVoiceFragment.this.sWu != null) {
                VoipVoiceFragment.this.sWu.S(false, true);
            }
            AppMethodBeat.o(4938);
        }
    };
    private OnClickListener sYh = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(4941);
            h.pYm.e(11619, Integer.valueOf(3));
            if (!(VoipVoiceFragment.this.sVY == null || VoipVoiceFragment.this.sVY.get() == null)) {
                ((c) VoipVoiceFragment.this.sVY.get()).cJL();
            }
            AppMethodBeat.o(4941);
        }
    };
    private View sYs;
    private ImageView sYt;
    private TextView sYu;
    private TextView sYv;
    private TextView sYw;
    private TextView sYx;
    private TextView sYy;
    private View sYz;

    public VoipVoiceFragment() {
        AppMethodBeat.i(4949);
        AppMethodBeat.o(4949);
    }

    public void onDestroy() {
        AppMethodBeat.i(4950);
        this.sXJ = false;
        super.onDestroy();
        AppMethodBeat.o(4950);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppMethodBeat.i(4951);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) layoutInflater.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        ab.i("MicroMsg.VoipVoiceFragment", "dpi: " + (((float) displayMetrics.heightPixels) / displayMetrics.density));
        if (((float) displayMetrics.heightPixels) / displayMetrics.density <= 540.0f) {
            this.sWp = (RelativeLayout) layoutInflater.inflate(R.layout.b2j, viewGroup, false);
        } else {
            this.sWp = (RelativeLayout) layoutInflater.inflate(R.layout.b2i, viewGroup, false);
            if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
                ((RelativeLayout) this.sWp.findViewById(R.id.f4k)).setPadding(0, 0, 0, BackwardSupportUtil.b.b(getActivity(), 40.0f));
            }
        }
        this.sWq = (ImageView) this.sWp.findViewById(R.id.f3c);
        this.sYs = this.sWp.findViewById(R.id.f4c);
        this.sYt = (ImageView) this.sWp.findViewById(R.id.f4d);
        a.b.a(this.sYt, this.edV, 0.0375f, true);
        this.sYu = (TextView) this.sWp.findViewById(R.id.f4f);
        this.sYu.setText(j.b(getActivity(), s.mJ(this.edV), this.sYu.getTextSize()));
        this.sYv = (TextView) this.sWp.findViewById(R.id.f4g);
        this.sYw = (TextView) this.sWp.findViewById(R.id.f4s);
        this.sYx = (TextView) this.sWp.findViewById(R.id.f4i);
        this.sYy = (TextView) this.sWp.findViewById(R.id.f4j);
        this.sYz = this.sWp.findViewById(R.id.f4h);
        this.sYG = (TextView) this.sWp.findViewById(R.id.f4r);
        this.sYH = (TextView) this.sWp.findViewById(R.id.f4q);
        this.nGB = (TextView) this.sWp.findViewById(R.id.ckv);
        j(this.sYy);
        this.sYD = (RelativeLayout) this.sWp.findViewById(R.id.f4t);
        this.sYE = (MMCheckBox) this.sWp.findViewById(R.id.f4u);
        this.sYE.setChecked(this.mIsMute);
        this.sYF = (TextView) this.sWp.findViewById(R.id.f4v);
        this.sYF.setText(R.string.f67);
        this.sYA = (RelativeLayout) this.sWp.findViewById(R.id.f4w);
        this.sYB = (MMCheckBox) this.sWp.findViewById(R.id.f4x);
        this.sYC = (TextView) this.sWp.findViewById(R.id.f4y);
        this.sYC.setText(R.string.f70);
        cLp();
        this.sYI = (VoipBigIconButton) this.sWp.findViewById(R.id.f4m);
        this.sYI.setOnClickListener(this.sYR);
        this.sYJ = (VoipBigIconButton) this.sWp.findViewById(R.id.f4l);
        this.sYJ.setOnClickListener(this.sYS);
        this.sYK = (VoipBigIconButton) this.sWp.findViewById(R.id.f4o);
        this.sYK.setOnClickListener(this.sYT);
        this.sYL = (VoipBigIconButton) this.sWp.findViewById(R.id.f4p);
        this.sYL.setOnClickListener(this.sYU);
        this.sXL = d.vn("VOIPBlockIgnoreButton") == 0;
        this.sYM = (VoipSmallIconButton) this.sWp.findViewById(R.id.f4n);
        this.sYM.setOnClickListener(this.sYh);
        if (!this.sXL) {
            this.sYM.setVisibility(8);
        }
        this.sYB.setOnClickListener(this.sYP);
        this.sYE.setOnClickListener(this.sYQ);
        this.sXh = (Button) this.sWp.findViewById(R.id.f3i);
        this.sXh.setOnClickListener(this.sYg);
        int hF = t.hF(getActivity());
        ab.d("MicroMsg.VoipVoiceFragment", "statusHeight: ".concat(String.valueOf(hF)));
        VoipBaseFragment.ae(this.sXh, hF);
        if (this.sRm && 2 == this.sRr) {
            fZ(R.string.f3u, Downloads.MIN_WAIT_FOR_NETWORK);
        }
        String A = com.tencent.mm.openim.room.a.a.A(((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(this.edV));
        if (!bo.isNullOrNil(A)) {
            this.sYv.setText(A);
        }
        this.mTimer = new Timer();
        fY(this.sWs, this.mStatus);
        RelativeLayout relativeLayout = this.sWp;
        AppMethodBeat.o(4951);
        return relativeLayout;
    }

    public final void fY(int i, int i2) {
        AppMethodBeat.i(4952);
        super.fY(i, i2);
        ab.i("MicroMsg.VoipVoiceFragment", "newState: " + com.tencent.mm.plugin.voip.a.b.GK(i2) + ", action: " + com.tencent.mm.plugin.voip.a.b.GK(i) + ", lastStatus: " + com.tencent.mm.plugin.voip.a.b.GK(sWt) + ", isSwitchFromVideo: " + this.sYN);
        if (this.sWp == null) {
            ab.i("MicroMsg.VoipVoiceFragment", "fragment no create, return first, onCreateView will call it again");
            AppMethodBeat.o(4952);
            return;
        }
        switch (i2) {
            case 1:
                cLg();
                AppMethodBeat.o(4952);
                return;
            case 3:
                GE(i);
                AppMethodBeat.o(4952);
                return;
            case 5:
                cLk();
                AppMethodBeat.o(4952);
                return;
            case 7:
            case com.tencent.view.d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW /*261*/:
                cLo();
                AppMethodBeat.o(4952);
                return;
            case 8:
            case com.tencent.view.d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM /*262*/:
                cLl();
                AppMethodBeat.o(4952);
                return;
            case com.tencent.view.d.MIC_PTU_ZIPAI_TOKYO /*257*/:
                cLm();
                AppMethodBeat.o(4952);
                return;
            case com.tencent.view.d.MIC_PTU_ZIPAI_MEDSEA /*259*/:
                cLn();
                break;
        }
        AppMethodBeat.o(4952);
    }

    public final void a(CaptureView captureView) {
    }

    public final void uninit() {
        AppMethodBeat.i(4953);
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        super.uninit();
        AppMethodBeat.o(4953);
    }

    private void cLg() {
        AppMethodBeat.i(4954);
        this.sYs.setVisibility(0);
        this.sYw.setVisibility(8);
        this.sYx.setText(R.string.f6j);
        this.sWv.a(this.sYy, sWo);
        this.sYz.setVisibility(0);
        this.sYI.setVisibility(8);
        this.sYJ.setVisibility(8);
        this.sYK.setVisibility(8);
        this.sYL.setVisibility(0);
        this.sYM.setVisibility(8);
        this.sYD.setVisibility(0);
        this.sYE.setEnabled(false);
        this.sYE.setBackgroundResource(R.drawable.bk_);
        this.sYF.setTextColor(1728053247);
        this.sYH.setVisibility(8);
        if (b.cIj().sRK != null) {
            this.sYH.setVisibility(0);
            this.sYH.setText(b.cIj().sRK);
        }
        cLp();
        this.sYE.setChecked(this.mIsMute);
        this.sYA.setVisibility(0);
        if (2 == this.sRr) {
            fZ(R.string.f3u, Downloads.MIN_WAIT_FOR_NETWORK);
        }
        cLa();
        AppMethodBeat.o(4954);
    }

    private void GE(int i) {
        AppMethodBeat.i(4955);
        this.sYs.setVisibility(0);
        this.sYw.setVisibility(8);
        this.sYx.setText(R.string.f60);
        this.sWv.a(this.sYy, sWo);
        this.sYz.setVisibility(0);
        if (this.sYv != null) {
            if (!ad.aox(this.edV) || bo.ac(this.sYv.getText())) {
                this.sYv.setVisibility(8);
            } else {
                this.sYv.setVisibility(0);
            }
        }
        this.sYI.setVisibility(8);
        this.sYJ.setVisibility(8);
        this.sYK.setVisibility(8);
        this.sYL.setVisibility(0);
        this.sYM.setVisibility(8);
        this.sYD.setVisibility(0);
        this.sYE.setEnabled(false);
        this.sYE.setBackgroundResource(R.drawable.bk_);
        this.sYF.setTextColor(1728053247);
        cLp();
        this.sYE.setChecked(this.mIsMute);
        this.sYA.setVisibility(0);
        if (i != 4097 && 2 == this.sRr) {
            fZ(R.string.f3u, Downloads.MIN_WAIT_FOR_NETWORK);
        }
        cLa();
        this.sYH.setVisibility(8);
        if (b.cIj().sRK != null) {
            this.sYH.setVisibility(0);
            this.sYH.setText(b.cIj().sRK);
        }
        if (sWt == 2) {
            this.sYN = true;
        }
        AppMethodBeat.o(4955);
    }

    private void cLk() {
        AppMethodBeat.i(4956);
        this.sYx.setText(R.string.f7s);
        this.sWv.a(this.sYy, sWo);
        this.sYI.setVisibility(8);
        this.sYJ.setVisibility(8);
        this.sYK.setVisibility(0);
        this.sYL.setVisibility(8);
        this.sYM.setVisibility(8);
        AppMethodBeat.o(4956);
    }

    private void cLl() {
        AppMethodBeat.i(4957);
        this.sWv.cLc();
        this.sYK.setEnabled(false);
        this.sYL.setEnabled(false);
        this.sYI.setEnabled(false);
        this.sYJ.setEnabled(false);
        this.sYM.setEnabled(false);
        AppMethodBeat.o(4957);
    }

    private void cLm() {
        AppMethodBeat.i(4958);
        this.sYs.setVisibility(0);
        this.sYz.setVisibility(0);
        this.sYx.setText(R.string.f61);
        this.sWv.a(this.sYy, sWo);
        if (this.sYv != null) {
            if (!ad.aox(this.edV) || bo.ac(this.sYv.getText())) {
                this.sYv.setVisibility(8);
            } else {
                this.sYv.setVisibility(0);
            }
        }
        cLp();
        this.sYI.setVisibility(0);
        this.sYJ.setVisibility(0);
        this.sYK.setVisibility(8);
        this.sYL.setVisibility(8);
        if (this.sXL) {
            this.sYM.setVisibility(0);
        }
        if (sWt == 256) {
            this.sYN = true;
            fZ(R.string.f3v, Downloads.MIN_WAIT_FOR_NETWORK);
        }
        cLa();
        this.sYH.setVisibility(8);
        if (b.cIj().sRK != null) {
            this.sYH.setVisibility(0);
            this.sYH.setText(b.cIj().sRK);
        }
        AppMethodBeat.o(4958);
    }

    private void cLn() {
        AppMethodBeat.i(4959);
        this.sYs.setVisibility(0);
        this.sYz.setVisibility(0);
        this.sYx.setText(R.string.f7s);
        this.sWv.a(this.sYy, sWo);
        this.sYI.setVisibility(8);
        this.sYJ.setVisibility(8);
        this.sYK.setVisibility(0);
        this.sYL.setVisibility(8);
        this.sYM.setVisibility(8);
        fZ(R.string.f3u, Downloads.MIN_WAIT_FOR_NETWORK);
        cLa();
        AppMethodBeat.o(4959);
    }

    private void cLo() {
        AppMethodBeat.i(4960);
        this.sYL.setVisibility(8);
        this.sYI.setVisibility(8);
        this.sYJ.setVisibility(8);
        this.sYM.setVisibility(8);
        this.sYz.setVisibility(8);
        this.sWv.cLc();
        this.sYK.setVisibility(0);
        this.sYw.setVisibility(0);
        this.sYD.setVisibility(0);
        this.sYA.setVisibility(0);
        this.sYs.setVisibility(0);
        this.sXh.setVisibility(0);
        this.sYE.setEnabled(true);
        this.sYE.setBackgroundResource(R.drawable.a59);
        this.sYF.setTextColor(-1);
        cLp();
        this.sYE.setChecked(this.mIsMute);
        if (!this.sYN) {
            fZ(R.string.f3n, Downloads.MIN_WAIT_FOR_NETWORK);
        } else if (2 == this.sRr) {
            fZ(R.string.f3p, Downloads.MIN_WAIT_FOR_NETWORK);
        } else if (3 == this.sRr) {
            fZ(R.string.f3o, Downloads.MIN_WAIT_FOR_NETWORK);
        }
        cLa();
        arh();
        this.sYH.setVisibility(8);
        if (b.cIj().sRK != null) {
            this.sYH.setVisibility(0);
            this.sYH.setText(b.cIj().sRK);
        }
        AppMethodBeat.o(4960);
    }

    /* Access modifiers changed, original: protected|final */
    public final void abY(String str) {
        AppMethodBeat.i(4961);
        if (this.sYH != null) {
            this.sYH.setVisibility(0);
            this.sYH.setText(str);
        }
        AppMethodBeat.o(4961);
    }

    /* Access modifiers changed, original: protected|final */
    public final void fZ(int i, int i2) {
        AppMethodBeat.i(4962);
        if (this.sYG == null) {
            AppMethodBeat.o(4962);
            return;
        }
        this.sYG.setText(i);
        this.sYG.setVisibility(0);
        this.sYG.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        this.sYG.setBackgroundResource(R.drawable.bk3);
        this.sYG.setCompoundDrawables(null, null, null, null);
        this.sYG.setCompoundDrawablePadding(0);
        this.iGP.removeCallbacks(this.lmq);
        if (-1 != i2) {
            this.iGP.postDelayed(this.lmq, (long) i2);
        }
        AppMethodBeat.o(4962);
    }

    /* Access modifiers changed, original: protected|final */
    public final void mz(boolean z) {
        AppMethodBeat.i(4963);
        if (this.nGB != null) {
            if (z) {
                this.nGB.setText(R.string.gaq);
            } else {
                this.nGB.setText(R.string.gap);
            }
            this.nGB.clearAnimation();
            this.nGB.setVisibility(0);
        }
        AppMethodBeat.o(4963);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cKY() {
        AppMethodBeat.i(4964);
        if (this.nGB != null) {
            this.nGB.clearAnimation();
            this.nGB.setVisibility(8);
        }
        AppMethodBeat.o(4964);
    }

    public final void cKZ() {
    }

    public final void setMute(boolean z) {
        AppMethodBeat.i(4965);
        this.mIsMute = z;
        if (!(this.sYE == null || this.sYF == null)) {
            this.sYE.setChecked(z);
        }
        AppMethodBeat.o(4965);
    }

    public final void a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5, int i6) {
    }

    public final void c(int i, int i2, int[] iArr) {
    }

    public final void cJD() {
    }

    public final void setVoipBeauty(int i) {
    }

    public final void setHWDecMode(int i) {
    }

    private void arh() {
        AppMethodBeat.i(4966);
        if (this.mTimer == null || this.sXJ) {
            AppMethodBeat.o(4966);
            return;
        }
        if (-1 == this.sVZ) {
            this.sVZ = bo.anT();
        }
        this.sXJ = true;
        this.mTimer.schedule(new TimerTask() {
            public final void run() {
                AppMethodBeat.i(4940);
                VoipVoiceFragment.this.iGP.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(4939);
                        VoipVoiceFragment.this.sYw.setText(VoipBaseFragment.fQ(bo.fp(VoipVoiceFragment.this.sVZ)));
                        AppMethodBeat.o(4939);
                    }
                });
                AppMethodBeat.o(4940);
            }
        }, 50, 1000);
        AppMethodBeat.o(4966);
    }

    public final void GC(int i) {
        AppMethodBeat.i(4967);
        this.sRr = i;
        cLp();
        AppMethodBeat.o(4967);
    }

    private void cLp() {
        boolean z = false;
        AppMethodBeat.i(4968);
        if (this.sYB == null || this.sYC == null) {
            ab.e("MicroMsg.VoipVoiceFragment", "speaker is null");
            AppMethodBeat.o(4968);
        } else if (4 == this.sRr || 3 == this.sRr) {
            this.sYB.setEnabled(false);
            this.sYC.setTextColor(1728053247);
            this.sYB.setBackgroundResource(R.drawable.bk0);
            AppMethodBeat.o(4968);
        } else {
            if (this.sRr == 1) {
                z = true;
            }
            this.sYB.setBackgroundResource(R.drawable.a5_);
            this.sYB.setEnabled(true);
            this.sYC.setTextColor(-1);
            this.sYB.setChecked(z);
            AppMethodBeat.o(4968);
        }
    }

    public final OpenGlRender getFilterData() {
        return this.sYO;
    }
}

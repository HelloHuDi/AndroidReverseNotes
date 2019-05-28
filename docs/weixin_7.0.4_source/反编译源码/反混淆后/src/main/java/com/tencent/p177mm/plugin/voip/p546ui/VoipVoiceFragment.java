package com.tencent.p177mm.plugin.voip.p546ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.openim.room.p266a.C42249a;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.voip.C43727b;
import com.tencent.p177mm.plugin.voip.p1417a.C29488d;
import com.tencent.p177mm.plugin.voip.p1417a.C40025b;
import com.tencent.p177mm.plugin.voip.video.CaptureView;
import com.tencent.p177mm.plugin.voip.video.OpenGlRender;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.view.C31128d;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.tencent.mm.plugin.voip.ui.VoipVoiceFragment */
public class VoipVoiceFragment extends VoipBaseFragment {
    private Runnable lmq = new C3537510();
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
    private OnClickListener sYP = new C353764();
    private OnClickListener sYQ = new C353775();
    private OnClickListener sYR = new C353786();
    private OnClickListener sYS = new C353797();
    private OnClickListener sYT = new C295108();
    private OnClickListener sYU = new C140839();
    private OnClickListener sYg = new C43011();
    private OnClickListener sYh = new C413193();
    private View sYs;
    private ImageView sYt;
    private TextView sYu;
    private TextView sYv;
    private TextView sYw;
    private TextView sYx;
    private TextView sYy;
    private View sYz;

    /* renamed from: com.tencent.mm.plugin.voip.ui.VoipVoiceFragment$1 */
    class C43011 implements OnClickListener {
        C43011() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(4938);
            C7060h.pYm.mo8381e(11618, Integer.valueOf(3), Integer.valueOf(1));
            if (!(VoipVoiceFragment.this.sVY == null || VoipVoiceFragment.this.sVY.get() == null)) {
                ((C46324c) VoipVoiceFragment.this.sVY.get()).mo30913mv(true);
            }
            if (VoipVoiceFragment.this.sWu != null) {
                VoipVoiceFragment.this.sWu.mo63352S(false, true);
            }
            AppMethodBeat.m2505o(4938);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VoipVoiceFragment$9 */
    class C140839 implements OnClickListener {
        C140839() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(4947);
            C4990ab.m7416i("MicroMsg.VoipVoiceFragment", "click cancel voice invite button");
            if (!(VoipVoiceFragment.this.sVY == null || VoipVoiceFragment.this.sVY.get() == null || !((C46324c) VoipVoiceFragment.this.sVY.get()).cJs())) {
                VoipVoiceFragment.this.mo56114fZ(C25738R.string.f4f, -1);
                VoipVoiceFragment.this.sYL.setEnabled(false);
            }
            AppMethodBeat.m2505o(4947);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VoipVoiceFragment$2 */
    class C224672 extends TimerTask {

        /* renamed from: com.tencent.mm.plugin.voip.ui.VoipVoiceFragment$2$1 */
        class C224681 implements Runnable {
            C224681() {
            }

            public final void run() {
                AppMethodBeat.m2504i(4939);
                VoipVoiceFragment.this.sYw.setText(VoipBaseFragment.m68591fQ(C5046bo.m7549fp(VoipVoiceFragment.this.sVZ)));
                AppMethodBeat.m2505o(4939);
            }
        }

        C224672() {
        }

        public final void run() {
            AppMethodBeat.m2504i(4940);
            VoipVoiceFragment.this.iGP.post(new C224681());
            AppMethodBeat.m2505o(4940);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VoipVoiceFragment$8 */
    class C295108 implements OnClickListener {
        C295108() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(4946);
            C4990ab.m7416i("MicroMsg.VoipVoiceFragment", "click hangup voice talking button");
            if (!(VoipVoiceFragment.this.sVY == null || VoipVoiceFragment.this.sVY.get() == null || !((C46324c) VoipVoiceFragment.this.sVY.get()).cJk())) {
                VoipVoiceFragment.this.mo56114fZ(C25738R.string.f5m, -1);
            }
            AppMethodBeat.m2505o(4946);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VoipVoiceFragment$10 */
    class C3537510 implements Runnable {
        C3537510() {
        }

        public final void run() {
            AppMethodBeat.m2504i(4948);
            if (VoipVoiceFragment.this.getActivity() == null || VoipVoiceFragment.this.getActivity().isFinishing()) {
                AppMethodBeat.m2505o(4948);
                return;
            }
            VoipVoiceFragment.this.sYG.setVisibility(8);
            AppMethodBeat.m2505o(4948);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VoipVoiceFragment$4 */
    class C353764 implements OnClickListener {
        C353764() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(4942);
            boolean isChecked = VoipVoiceFragment.this.sYB.isChecked();
            C4990ab.m7417i("MicroMsg.VoipVoiceFragment", "onSpeakerClick, status: %b", Boolean.valueOf(isChecked));
            VoipVoiceFragment.this.sYB.setEnabled(false);
            if (!(VoipVoiceFragment.this.sVY == null || VoipVoiceFragment.this.sVY.get() == null)) {
                ((C46324c) VoipVoiceFragment.this.sVY.get()).mo30911ms(isChecked);
            }
            VoipVoiceFragment.this.sRr = isChecked ? 1 : 2;
            VoipVoiceFragment.this.sYB.setEnabled(true);
            AppMethodBeat.m2505o(4942);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VoipVoiceFragment$5 */
    class C353775 implements OnClickListener {
        C353775() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(4943);
            boolean isChecked = VoipVoiceFragment.this.sYE.isChecked();
            C4990ab.m7417i("MicroMsg.VoipVoiceFragment", "onMicClick, status: %b", Boolean.valueOf(isChecked));
            VoipVoiceFragment.this.sYE.setEnabled(false);
            if (!(VoipVoiceFragment.this.sVY == null || VoipVoiceFragment.this.sVY.get() == null)) {
                ((C46324c) VoipVoiceFragment.this.sVY.get()).mo30910jg(isChecked);
            }
            VoipVoiceFragment.this.mIsMute = isChecked;
            VoipVoiceFragment.this.sYE.setEnabled(true);
            AppMethodBeat.m2505o(4943);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VoipVoiceFragment$6 */
    class C353786 implements OnClickListener {
        C353786() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(4944);
            C4990ab.m7416i("MicroMsg.VoipVoiceFragment", "click accept voice invite button");
            C7060h.pYm.mo8377a(11526, true, true, Integer.valueOf(C43727b.cIj().cJZ()), Long.valueOf(C43727b.cIj().cKa()), Long.valueOf(C43727b.cIj().cIK()), Integer.valueOf(2));
            if (!(VoipVoiceFragment.this.sVY == null || VoipVoiceFragment.this.sVY.get() == null || !((C46324c) VoipVoiceFragment.this.sVY.get()).cJq())) {
                VoipVoiceFragment.this.sYI.setEnabled(false);
                VoipVoiceFragment.this.sYx.setText(C25738R.string.f7s);
                VoipVoiceFragment.this.sWv.mo63349a(VoipVoiceFragment.this.sYy, VoipBaseFragment.sWo);
                VoipVoiceFragment.this.sYz.setVisibility(0);
                VoipVoiceFragment.this.sYw.setVisibility(8);
                VoipVoiceFragment.this.sYI.setVisibility(8);
                VoipVoiceFragment.this.sYJ.setVisibility(8);
                VoipVoiceFragment.this.sYK.setVisibility(0);
            }
            AppMethodBeat.m2505o(4944);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VoipVoiceFragment$7 */
    class C353797 implements OnClickListener {
        C353797() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(4945);
            C4990ab.m7416i("MicroMsg.VoipVoiceFragment", "click reject voice invite button");
            C7060h.pYm.mo8377a(11526, true, true, Integer.valueOf(C43727b.cIj().cJZ()), Long.valueOf(C43727b.cIj().cKa()), Long.valueOf(C43727b.cIj().cIK()), Integer.valueOf(5));
            if (!(VoipVoiceFragment.this.sVY == null || VoipVoiceFragment.this.sVY.get() == null || !((C46324c) VoipVoiceFragment.this.sVY.get()).cJp())) {
                VoipVoiceFragment.this.sYJ.setEnabled(false);
                VoipVoiceFragment.this.sYI.setEnabled(false);
                VoipVoiceFragment.this.mo56114fZ(C25738R.string.f6q, -1);
                if (VoipVoiceFragment.this.sWu != null) {
                    VoipVoiceFragment.this.sWu.mo63352S(true, false);
                }
            }
            AppMethodBeat.m2505o(4945);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VoipVoiceFragment$3 */
    class C413193 implements OnClickListener {
        C413193() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(4941);
            C7060h.pYm.mo8381e(11619, Integer.valueOf(3));
            if (!(VoipVoiceFragment.this.sVY == null || VoipVoiceFragment.this.sVY.get() == null)) {
                ((C46324c) VoipVoiceFragment.this.sVY.get()).cJL();
            }
            AppMethodBeat.m2505o(4941);
        }
    }

    public VoipVoiceFragment() {
        AppMethodBeat.m2504i(4949);
        AppMethodBeat.m2505o(4949);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(4950);
        this.sXJ = false;
        super.onDestroy();
        AppMethodBeat.m2505o(4950);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppMethodBeat.m2504i(4951);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) layoutInflater.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        C4990ab.m7416i("MicroMsg.VoipVoiceFragment", "dpi: " + (((float) displayMetrics.heightPixels) / displayMetrics.density));
        if (((float) displayMetrics.heightPixels) / displayMetrics.density <= 540.0f) {
            this.sWp = (RelativeLayout) layoutInflater.inflate(2130971035, viewGroup, false);
        } else {
            this.sWp = (RelativeLayout) layoutInflater.inflate(2130971034, viewGroup, false);
            if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
                ((RelativeLayout) this.sWp.findViewById(2131828556)).setPadding(0, 0, 0, C4977b.m7371b(getActivity(), 40.0f));
            }
        }
        this.sWq = (ImageView) this.sWp.findViewById(2131828511);
        this.sYs = this.sWp.findViewById(2131828548);
        this.sYt = (ImageView) this.sWp.findViewById(2131828549);
        C40460b.m69433a(this.sYt, this.edV, 0.0375f, true);
        this.sYu = (TextView) this.sWp.findViewById(2131828551);
        this.sYu.setText(C44089j.m79293b(getActivity(), C1854s.m3866mJ(this.edV), this.sYu.getTextSize()));
        this.sYv = (TextView) this.sWp.findViewById(2131828552);
        this.sYw = (TextView) this.sWp.findViewById(2131828564);
        this.sYx = (TextView) this.sWp.findViewById(2131828554);
        this.sYy = (TextView) this.sWp.findViewById(2131828555);
        this.sYz = this.sWp.findViewById(2131828553);
        this.sYG = (TextView) this.sWp.findViewById(2131828563);
        this.sYH = (TextView) this.sWp.findViewById(2131828562);
        this.nGB = (TextView) this.sWp.findViewById(2131825090);
        mo63346j(this.sYy);
        this.sYD = (RelativeLayout) this.sWp.findViewById(2131828565);
        this.sYE = (MMCheckBox) this.sWp.findViewById(2131828566);
        this.sYE.setChecked(this.mIsMute);
        this.sYF = (TextView) this.sWp.findViewById(2131828567);
        this.sYF.setText(C25738R.string.f67);
        this.sYA = (RelativeLayout) this.sWp.findViewById(2131828568);
        this.sYB = (MMCheckBox) this.sWp.findViewById(2131828569);
        this.sYC = (TextView) this.sWp.findViewById(2131828570);
        this.sYC.setText(C25738R.string.f70);
        cLp();
        this.sYI = (VoipBigIconButton) this.sWp.findViewById(2131828558);
        this.sYI.setOnClickListener(this.sYR);
        this.sYJ = (VoipBigIconButton) this.sWp.findViewById(2131828557);
        this.sYJ.setOnClickListener(this.sYS);
        this.sYK = (VoipBigIconButton) this.sWp.findViewById(2131828560);
        this.sYK.setOnClickListener(this.sYT);
        this.sYL = (VoipBigIconButton) this.sWp.findViewById(2131828561);
        this.sYL.setOnClickListener(this.sYU);
        this.sXL = C29488d.m46806vn("VOIPBlockIgnoreButton") == 0;
        this.sYM = (VoipSmallIconButton) this.sWp.findViewById(2131828559);
        this.sYM.setOnClickListener(this.sYh);
        if (!this.sXL) {
            this.sYM.setVisibility(8);
        }
        this.sYB.setOnClickListener(this.sYP);
        this.sYE.setOnClickListener(this.sYQ);
        this.sXh = (Button) this.sWp.findViewById(2131828517);
        this.sXh.setOnClickListener(this.sYg);
        int hF = C23639t.m36491hF(getActivity());
        C4990ab.m7410d("MicroMsg.VoipVoiceFragment", "statusHeight: ".concat(String.valueOf(hF)));
        VoipBaseFragment.m68589ae(this.sXh, hF);
        if (this.sRm && 2 == this.sRr) {
            mo56114fZ(C25738R.string.f3u, Downloads.MIN_WAIT_FOR_NETWORK);
        }
        String A = C42249a.m74595A(((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.edV));
        if (!C5046bo.isNullOrNil(A)) {
            this.sYv.setText(A);
        }
        this.mTimer = new Timer();
        mo56113fY(this.sWs, this.mStatus);
        RelativeLayout relativeLayout = this.sWp;
        AppMethodBeat.m2505o(4951);
        return relativeLayout;
    }

    /* renamed from: fY */
    public final void mo56113fY(int i, int i2) {
        AppMethodBeat.m2504i(4952);
        super.mo56113fY(i, i2);
        C4990ab.m7416i("MicroMsg.VoipVoiceFragment", "newState: " + C40025b.m68545GK(i2) + ", action: " + C40025b.m68545GK(i) + ", lastStatus: " + C40025b.m68545GK(sWt) + ", isSwitchFromVideo: " + this.sYN);
        if (this.sWp == null) {
            C4990ab.m7416i("MicroMsg.VoipVoiceFragment", "fragment no create, return first, onCreateView will call it again");
            AppMethodBeat.m2505o(4952);
            return;
        }
        switch (i2) {
            case 1:
                cLg();
                AppMethodBeat.m2505o(4952);
                return;
            case 3:
                m71994GE(i);
                AppMethodBeat.m2505o(4952);
                return;
            case 5:
                cLk();
                AppMethodBeat.m2505o(4952);
                return;
            case 7:
            case C31128d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW /*261*/:
                cLo();
                AppMethodBeat.m2505o(4952);
                return;
            case 8:
            case C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM /*262*/:
                cLl();
                AppMethodBeat.m2505o(4952);
                return;
            case C31128d.MIC_PTU_ZIPAI_TOKYO /*257*/:
                cLm();
                AppMethodBeat.m2505o(4952);
                return;
            case C31128d.MIC_PTU_ZIPAI_MEDSEA /*259*/:
                cLn();
                break;
        }
        AppMethodBeat.m2505o(4952);
    }

    /* renamed from: a */
    public final void mo56105a(CaptureView captureView) {
    }

    public final void uninit() {
        AppMethodBeat.m2504i(4953);
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        super.uninit();
        AppMethodBeat.m2505o(4953);
    }

    private void cLg() {
        AppMethodBeat.m2504i(4954);
        this.sYs.setVisibility(0);
        this.sYw.setVisibility(8);
        this.sYx.setText(C25738R.string.f6j);
        this.sWv.mo63349a(this.sYy, sWo);
        this.sYz.setVisibility(0);
        this.sYI.setVisibility(8);
        this.sYJ.setVisibility(8);
        this.sYK.setVisibility(8);
        this.sYL.setVisibility(0);
        this.sYM.setVisibility(8);
        this.sYD.setVisibility(0);
        this.sYE.setEnabled(false);
        this.sYE.setBackgroundResource(C25738R.drawable.bk_);
        this.sYF.setTextColor(1728053247);
        this.sYH.setVisibility(8);
        if (C43727b.cIj().sRK != null) {
            this.sYH.setVisibility(0);
            this.sYH.setText(C43727b.cIj().sRK);
        }
        cLp();
        this.sYE.setChecked(this.mIsMute);
        this.sYA.setVisibility(0);
        if (2 == this.sRr) {
            mo56114fZ(C25738R.string.f3u, Downloads.MIN_WAIT_FOR_NETWORK);
        }
        cLa();
        AppMethodBeat.m2505o(4954);
    }

    /* renamed from: GE */
    private void m71994GE(int i) {
        AppMethodBeat.m2504i(4955);
        this.sYs.setVisibility(0);
        this.sYw.setVisibility(8);
        this.sYx.setText(C25738R.string.f60);
        this.sWv.mo63349a(this.sYy, sWo);
        this.sYz.setVisibility(0);
        if (this.sYv != null) {
            if (!C7616ad.aox(this.edV) || C5046bo.m7519ac(this.sYv.getText())) {
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
        this.sYE.setBackgroundResource(C25738R.drawable.bk_);
        this.sYF.setTextColor(1728053247);
        cLp();
        this.sYE.setChecked(this.mIsMute);
        this.sYA.setVisibility(0);
        if (i != 4097 && 2 == this.sRr) {
            mo56114fZ(C25738R.string.f3u, Downloads.MIN_WAIT_FOR_NETWORK);
        }
        cLa();
        this.sYH.setVisibility(8);
        if (C43727b.cIj().sRK != null) {
            this.sYH.setVisibility(0);
            this.sYH.setText(C43727b.cIj().sRK);
        }
        if (sWt == 2) {
            this.sYN = true;
        }
        AppMethodBeat.m2505o(4955);
    }

    private void cLk() {
        AppMethodBeat.m2504i(4956);
        this.sYx.setText(C25738R.string.f7s);
        this.sWv.mo63349a(this.sYy, sWo);
        this.sYI.setVisibility(8);
        this.sYJ.setVisibility(8);
        this.sYK.setVisibility(0);
        this.sYL.setVisibility(8);
        this.sYM.setVisibility(8);
        AppMethodBeat.m2505o(4956);
    }

    private void cLl() {
        AppMethodBeat.m2504i(4957);
        this.sWv.cLc();
        this.sYK.setEnabled(false);
        this.sYL.setEnabled(false);
        this.sYI.setEnabled(false);
        this.sYJ.setEnabled(false);
        this.sYM.setEnabled(false);
        AppMethodBeat.m2505o(4957);
    }

    private void cLm() {
        AppMethodBeat.m2504i(4958);
        this.sYs.setVisibility(0);
        this.sYz.setVisibility(0);
        this.sYx.setText(C25738R.string.f61);
        this.sWv.mo63349a(this.sYy, sWo);
        if (this.sYv != null) {
            if (!C7616ad.aox(this.edV) || C5046bo.m7519ac(this.sYv.getText())) {
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
            mo56114fZ(C25738R.string.f3v, Downloads.MIN_WAIT_FOR_NETWORK);
        }
        cLa();
        this.sYH.setVisibility(8);
        if (C43727b.cIj().sRK != null) {
            this.sYH.setVisibility(0);
            this.sYH.setText(C43727b.cIj().sRK);
        }
        AppMethodBeat.m2505o(4958);
    }

    private void cLn() {
        AppMethodBeat.m2504i(4959);
        this.sYs.setVisibility(0);
        this.sYz.setVisibility(0);
        this.sYx.setText(C25738R.string.f7s);
        this.sWv.mo63349a(this.sYy, sWo);
        this.sYI.setVisibility(8);
        this.sYJ.setVisibility(8);
        this.sYK.setVisibility(0);
        this.sYL.setVisibility(8);
        this.sYM.setVisibility(8);
        mo56114fZ(C25738R.string.f3u, Downloads.MIN_WAIT_FOR_NETWORK);
        cLa();
        AppMethodBeat.m2505o(4959);
    }

    private void cLo() {
        AppMethodBeat.m2504i(4960);
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
        this.sYE.setBackgroundResource(C25738R.drawable.a59);
        this.sYF.setTextColor(-1);
        cLp();
        this.sYE.setChecked(this.mIsMute);
        if (!this.sYN) {
            mo56114fZ(C25738R.string.f3n, Downloads.MIN_WAIT_FOR_NETWORK);
        } else if (2 == this.sRr) {
            mo56114fZ(C25738R.string.f3p, Downloads.MIN_WAIT_FOR_NETWORK);
        } else if (3 == this.sRr) {
            mo56114fZ(C25738R.string.f3o, Downloads.MIN_WAIT_FOR_NETWORK);
        }
        cLa();
        arh();
        this.sYH.setVisibility(8);
        if (C43727b.cIj().sRK != null) {
            this.sYH.setVisibility(0);
            this.sYH.setText(C43727b.cIj().sRK);
        }
        AppMethodBeat.m2505o(4960);
    }

    /* Access modifiers changed, original: protected|final */
    public final void abY(String str) {
        AppMethodBeat.m2504i(4961);
        if (this.sYH != null) {
            this.sYH.setVisibility(0);
            this.sYH.setText(str);
        }
        AppMethodBeat.m2505o(4961);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: fZ */
    public final void mo56114fZ(int i, int i2) {
        AppMethodBeat.m2504i(4962);
        if (this.sYG == null) {
            AppMethodBeat.m2505o(4962);
            return;
        }
        this.sYG.setText(i);
        this.sYG.setVisibility(0);
        this.sYG.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        this.sYG.setBackgroundResource(C25738R.drawable.bk3);
        this.sYG.setCompoundDrawables(null, null, null, null);
        this.sYG.setCompoundDrawablePadding(0);
        this.iGP.removeCallbacks(this.lmq);
        if (-1 != i2) {
            this.iGP.postDelayed(this.lmq, (long) i2);
        }
        AppMethodBeat.m2505o(4962);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: mz */
    public final void mo56116mz(boolean z) {
        AppMethodBeat.m2504i(4963);
        if (this.nGB != null) {
            if (z) {
                this.nGB.setText(C25738R.string.gaq);
            } else {
                this.nGB.setText(C25738R.string.gap);
            }
            this.nGB.clearAnimation();
            this.nGB.setVisibility(0);
        }
        AppMethodBeat.m2505o(4963);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cKY() {
        AppMethodBeat.m2504i(4964);
        if (this.nGB != null) {
            this.nGB.clearAnimation();
            this.nGB.setVisibility(8);
        }
        AppMethodBeat.m2505o(4964);
    }

    public final void cKZ() {
    }

    public final void setMute(boolean z) {
        AppMethodBeat.m2504i(4965);
        this.mIsMute = z;
        if (!(this.sYE == null || this.sYF == null)) {
            this.sYE.setChecked(z);
        }
        AppMethodBeat.m2505o(4965);
    }

    /* renamed from: a */
    public final void mo56106a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5, int i6) {
    }

    /* renamed from: c */
    public final void mo56108c(int i, int i2, int[] iArr) {
    }

    public final void cJD() {
    }

    public final void setVoipBeauty(int i) {
    }

    public final void setHWDecMode(int i) {
    }

    private void arh() {
        AppMethodBeat.m2504i(4966);
        if (this.mTimer == null || this.sXJ) {
            AppMethodBeat.m2505o(4966);
            return;
        }
        if (-1 == this.sVZ) {
            this.sVZ = C5046bo.anT();
        }
        this.sXJ = true;
        this.mTimer.schedule(new C224672(), 50, 1000);
        AppMethodBeat.m2505o(4966);
    }

    /* renamed from: GC */
    public final void mo56104GC(int i) {
        AppMethodBeat.m2504i(4967);
        this.sRr = i;
        cLp();
        AppMethodBeat.m2505o(4967);
    }

    private void cLp() {
        boolean z = false;
        AppMethodBeat.m2504i(4968);
        if (this.sYB == null || this.sYC == null) {
            C4990ab.m7412e("MicroMsg.VoipVoiceFragment", "speaker is null");
            AppMethodBeat.m2505o(4968);
        } else if (4 == this.sRr || 3 == this.sRr) {
            this.sYB.setEnabled(false);
            this.sYC.setTextColor(1728053247);
            this.sYB.setBackgroundResource(C25738R.drawable.bk0);
            AppMethodBeat.m2505o(4968);
        } else {
            if (this.sRr == 1) {
                z = true;
            }
            this.sYB.setBackgroundResource(C25738R.drawable.a5_);
            this.sYB.setEnabled(true);
            this.sYC.setTextColor(-1);
            this.sYB.setChecked(z);
            AppMethodBeat.m2505o(4968);
        }
    }

    public final OpenGlRender getFilterData() {
        return this.sYO;
    }
}

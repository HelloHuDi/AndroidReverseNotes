package com.tencent.p177mm.plugin.fts.p424ui.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.fts.p419a.C3163e;
import com.tencent.p177mm.plugin.fts.p424ui.widget.FTSVoiceInputLayoutImpl.C28152a;
import com.tencent.p177mm.plugin.fts.p424ui.widget.VoiceInputLayout.C28155a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fts.ui.widget.c */
public final class C45979c {
    MMActivity crP;
    public C39156a mMG;
    public boolean mMH = false;
    public FTSVoiceInputLayoutImpl mMI;
    public TextView mMJ;
    public ImageView mMK;
    long mML;
    long mMM;
    long mMN;
    private C28152a mMO = new C209011();
    Toast mMP;
    private C28155a mMQ = new C120722();

    /* renamed from: com.tencent.mm.plugin.fts.ui.widget.c$2 */
    class C120722 implements C28155a {
        C120722() {
        }

        public final void bBI() {
            AppMethodBeat.m2504i(62177);
            C45979c c45979c = C45979c.this;
            if (c45979c.mMP != null) {
                c45979c.mMP.cancel();
            }
            c45979c.mMP = Toast.makeText(c45979c.crP, c45979c.crP.getResources().getString(C25738R.string.c2i), 0);
            c45979c.mMP.setGravity(17, 0, 0);
            c45979c.mMP.show();
            C45979c.this.mMG.mo7464a(true, false, "");
            AppMethodBeat.m2505o(62177);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.widget.c$1 */
    class C209011 implements C28152a {
        String mMR = "";
        String mMS = "";

        C209011() {
        }

        public final void bBz() {
            AppMethodBeat.m2504i(62165);
            this.mMR = "";
            this.mMS = "";
            C4990ab.m7410d("MicroMsg.FTSVoiceInputHelper", "onDetectStart");
            C7060h.pYm.mo8381e(15490, Integer.valueOf(3), C3163e.mCM, Integer.valueOf(1));
            C4990ab.m7411d("MicroMsg.FTSVoiceInputHelper", "15490 type:3, sessionId:%s, voicever:%s", C3163e.mCM, Integer.valueOf(1));
            C45979c.this.mMH = true;
            C45979c.this.mMG.bBh();
            AppMethodBeat.m2505o(62165);
        }

        public final void bBA() {
            AppMethodBeat.m2504i(62166);
            C45979c.this.mMM = System.currentTimeMillis();
            if (C45979c.this.mMH && !C5046bo.isNullOrNil(this.mMR)) {
                C45979c.this.bBy();
            }
            AppMethodBeat.m2505o(62166);
        }

        public final void bBB() {
            AppMethodBeat.m2504i(62167);
            C45979c.this.mML = System.currentTimeMillis();
            AppMethodBeat.m2505o(62167);
        }

        public final void bBC() {
            AppMethodBeat.m2504i(62168);
            C4990ab.m7410d("MicroMsg.FTSVoiceInputHelper", "onDetectStop");
            AppMethodBeat.m2505o(62168);
        }

        public final void bBD() {
            AppMethodBeat.m2504i(62169);
            C4990ab.m7410d("MicroMsg.FTSVoiceInputHelper", "onDetectCancel");
            AppMethodBeat.m2505o(62169);
        }

        public final void bBE() {
            AppMethodBeat.m2504i(62170);
            C4990ab.m7410d("MicroMsg.FTSVoiceInputHelper", "onStateReset");
            AppMethodBeat.m2505o(62170);
        }

        public final void bBF() {
            AppMethodBeat.m2504i(62171);
            C4990ab.m7410d("MicroMsg.FTSVoiceInputHelper", "onDetectFinish");
            m32142IF();
            C45979c.this.mMH = false;
            bBG();
            C45979c.this.mMG.mo7463Ny(this.mMR);
            this.mMR = "";
            this.mMS = "";
            AppMethodBeat.m2505o(62171);
        }

        /* renamed from: c */
        public final void mo36217c(String[] strArr, List<String> list) {
            AppMethodBeat.m2504i(138302);
            if (strArr != null && strArr.length > 0 && strArr[0].length() > 0) {
                this.mMR = strArr[0];
                C4990ab.m7410d("MicroMsg.FTSVoiceInputHelper", "onDetected text content: " + this.mMR);
                bBG();
            }
            if (!(list == null || list.isEmpty() || !list.iterator().hasNext())) {
                this.mMS = (String) list.iterator().next();
                C4990ab.m7411d("MicroMsg.FTSVoiceInputHelper", "set voiceId:%s", this.mMS);
            }
            AppMethodBeat.m2505o(138302);
        }

        /* renamed from: wi */
        public final void mo36218wi(int i) {
            AppMethodBeat.m2504i(62173);
            C45979c.this.mMH = false;
            m32142IF();
            if (i == 12) {
                C45979c.this.mMG.mo7464a(false, true, this.mMR);
                AppMethodBeat.m2505o(62173);
                return;
            }
            C45979c.this.mMG.mo7464a(false, false, this.mMR);
            AppMethodBeat.m2505o(62173);
        }

        private void bBG() {
            AppMethodBeat.m2504i(62174);
            bBH();
            C45979c.this.mMJ.setText(this.mMR);
            C45979c.this.mMK.setVisibility(0);
            C45979c.this.mMG.mo7462Nx(this.mMR);
            AppMethodBeat.m2505o(62174);
        }

        private void bBH() {
            AppMethodBeat.m2504i(62175);
            if (this.mMR.length() > 0) {
                this.mMR = this.mMR.replaceAll("。", " ").replaceAll("\\.", " ").replaceAll("，", " ").replaceAll(",", " ").trim();
            }
            AppMethodBeat.m2505o(62175);
        }

        /* renamed from: IF */
        private void m32142IF() {
            long j;
            AppMethodBeat.m2504i(62176);
            C45979c.this.mMN = System.currentTimeMillis();
            C45979c c45979c = C45979c.this;
            if (C45979c.this.mMM > 0) {
                j = C45979c.this.mMM;
            } else {
                j = C45979c.this.mMN;
            }
            c45979c.mMM = j;
            int i = C5046bo.isNullOrNil(this.mMR) ? 2 : 1;
            long j2 = C45979c.this.mMM - C45979c.this.mML;
            long j3 = C45979c.this.mMN - C45979c.this.mML;
            C7060h.pYm.mo8381e(16346, Integer.valueOf(i), C3163e.mCM, Long.valueOf(j2), Long.valueOf(j3));
            C4990ab.m7417i("MicroMsg.FTSVoiceInputHelper", "16346 actionType:%s, searchId:%s, voiceTime:%s, tranTime:%s", Integer.valueOf(i), C3163e.mCM, Long.valueOf(j2), Long.valueOf(j3));
            C45979c.this.mML = 0;
            C45979c.this.mMM = 0;
            C45979c.this.mMN = 0;
            AppMethodBeat.m2505o(62176);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.widget.c$a */
    public interface C39156a {
        /* renamed from: Nx */
        void mo7462Nx(String str);

        /* renamed from: Ny */
        void mo7463Ny(String str);

        /* renamed from: a */
        void mo7464a(boolean z, boolean z2, String str);

        void bBh();
    }

    public C45979c(Context context, FTSVoiceInputLayoutImpl fTSVoiceInputLayoutImpl, TextView textView, ImageView imageView) {
        AppMethodBeat.m2504i(62178);
        this.crP = (MMActivity) context;
        this.mMI = fTSVoiceInputLayoutImpl;
        this.mMJ = textView;
        this.mMK = imageView;
        this.mMI.setFTSVoiceDetectListener(this.mMO);
        this.mMI.setLongClickLisnter(this.mMQ);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mMK, "rotation", new float[]{0.0f, 360.0f});
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setDuration(1000);
        ofFloat.start();
        AppMethodBeat.m2505o(62178);
    }

    public final void bBy() {
        AppMethodBeat.m2504i(62179);
        this.mMI.setVisibility(8);
        AppMethodBeat.m2505o(62179);
    }

    public final void show() {
        AppMethodBeat.m2504i(62180);
        if (C4988aa.dor().equals("zh_CN")) {
            this.mMI.setAlpha(0.0f);
            this.mMI.animate().alpha(1.0f).setDuration(500).start();
            this.mMI.setVisibility(0);
            this.mMK.setVisibility(8);
            this.mMJ.setText("");
            AppMethodBeat.m2505o(62180);
            return;
        }
        AppMethodBeat.m2505o(62180);
    }
}

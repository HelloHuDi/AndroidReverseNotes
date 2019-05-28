package com.tencent.mm.plugin.fts.ui.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.List;

public final class c {
    MMActivity crP;
    public a mMG;
    public boolean mMH = false;
    public FTSVoiceInputLayoutImpl mMI;
    public TextView mMJ;
    public ImageView mMK;
    long mML;
    long mMM;
    long mMN;
    private com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl.a mMO = new com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl.a() {
        String mMR = "";
        String mMS = "";

        public final void bBz() {
            AppMethodBeat.i(62165);
            this.mMR = "";
            this.mMS = "";
            ab.d("MicroMsg.FTSVoiceInputHelper", "onDetectStart");
            h.pYm.e(15490, Integer.valueOf(3), e.mCM, Integer.valueOf(1));
            ab.d("MicroMsg.FTSVoiceInputHelper", "15490 type:3, sessionId:%s, voicever:%s", e.mCM, Integer.valueOf(1));
            c.this.mMH = true;
            c.this.mMG.bBh();
            AppMethodBeat.o(62165);
        }

        public final void bBA() {
            AppMethodBeat.i(62166);
            c.this.mMM = System.currentTimeMillis();
            if (c.this.mMH && !bo.isNullOrNil(this.mMR)) {
                c.this.bBy();
            }
            AppMethodBeat.o(62166);
        }

        public final void bBB() {
            AppMethodBeat.i(62167);
            c.this.mML = System.currentTimeMillis();
            AppMethodBeat.o(62167);
        }

        public final void bBC() {
            AppMethodBeat.i(62168);
            ab.d("MicroMsg.FTSVoiceInputHelper", "onDetectStop");
            AppMethodBeat.o(62168);
        }

        public final void bBD() {
            AppMethodBeat.i(62169);
            ab.d("MicroMsg.FTSVoiceInputHelper", "onDetectCancel");
            AppMethodBeat.o(62169);
        }

        public final void bBE() {
            AppMethodBeat.i(62170);
            ab.d("MicroMsg.FTSVoiceInputHelper", "onStateReset");
            AppMethodBeat.o(62170);
        }

        public final void bBF() {
            AppMethodBeat.i(62171);
            ab.d("MicroMsg.FTSVoiceInputHelper", "onDetectFinish");
            IF();
            c.this.mMH = false;
            bBG();
            c.this.mMG.Ny(this.mMR);
            this.mMR = "";
            this.mMS = "";
            AppMethodBeat.o(62171);
        }

        public final void c(String[] strArr, List<String> list) {
            AppMethodBeat.i(138302);
            if (strArr != null && strArr.length > 0 && strArr[0].length() > 0) {
                this.mMR = strArr[0];
                ab.d("MicroMsg.FTSVoiceInputHelper", "onDetected text content: " + this.mMR);
                bBG();
            }
            if (!(list == null || list.isEmpty() || !list.iterator().hasNext())) {
                this.mMS = (String) list.iterator().next();
                ab.d("MicroMsg.FTSVoiceInputHelper", "set voiceId:%s", this.mMS);
            }
            AppMethodBeat.o(138302);
        }

        public final void wi(int i) {
            AppMethodBeat.i(62173);
            c.this.mMH = false;
            IF();
            if (i == 12) {
                c.this.mMG.a(false, true, this.mMR);
                AppMethodBeat.o(62173);
                return;
            }
            c.this.mMG.a(false, false, this.mMR);
            AppMethodBeat.o(62173);
        }

        private void bBG() {
            AppMethodBeat.i(62174);
            bBH();
            c.this.mMJ.setText(this.mMR);
            c.this.mMK.setVisibility(0);
            c.this.mMG.Nx(this.mMR);
            AppMethodBeat.o(62174);
        }

        private void bBH() {
            AppMethodBeat.i(62175);
            if (this.mMR.length() > 0) {
                this.mMR = this.mMR.replaceAll("。", " ").replaceAll("\\.", " ").replaceAll("，", " ").replaceAll(",", " ").trim();
            }
            AppMethodBeat.o(62175);
        }

        private void IF() {
            long j;
            AppMethodBeat.i(62176);
            c.this.mMN = System.currentTimeMillis();
            c cVar = c.this;
            if (c.this.mMM > 0) {
                j = c.this.mMM;
            } else {
                j = c.this.mMN;
            }
            cVar.mMM = j;
            int i = bo.isNullOrNil(this.mMR) ? 2 : 1;
            long j2 = c.this.mMM - c.this.mML;
            long j3 = c.this.mMN - c.this.mML;
            h.pYm.e(16346, Integer.valueOf(i), e.mCM, Long.valueOf(j2), Long.valueOf(j3));
            ab.i("MicroMsg.FTSVoiceInputHelper", "16346 actionType:%s, searchId:%s, voiceTime:%s, tranTime:%s", Integer.valueOf(i), e.mCM, Long.valueOf(j2), Long.valueOf(j3));
            c.this.mML = 0;
            c.this.mMM = 0;
            c.this.mMN = 0;
            AppMethodBeat.o(62176);
        }
    };
    Toast mMP;
    private com.tencent.mm.plugin.fts.ui.widget.VoiceInputLayout.a mMQ = new com.tencent.mm.plugin.fts.ui.widget.VoiceInputLayout.a() {
        public final void bBI() {
            AppMethodBeat.i(62177);
            c cVar = c.this;
            if (cVar.mMP != null) {
                cVar.mMP.cancel();
            }
            cVar.mMP = Toast.makeText(cVar.crP, cVar.crP.getResources().getString(R.string.c2i), 0);
            cVar.mMP.setGravity(17, 0, 0);
            cVar.mMP.show();
            c.this.mMG.a(true, false, "");
            AppMethodBeat.o(62177);
        }
    };

    public interface a {
        void Nx(String str);

        void Ny(String str);

        void a(boolean z, boolean z2, String str);

        void bBh();
    }

    public c(Context context, FTSVoiceInputLayoutImpl fTSVoiceInputLayoutImpl, TextView textView, ImageView imageView) {
        AppMethodBeat.i(62178);
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
        AppMethodBeat.o(62178);
    }

    public final void bBy() {
        AppMethodBeat.i(62179);
        this.mMI.setVisibility(8);
        AppMethodBeat.o(62179);
    }

    public final void show() {
        AppMethodBeat.i(62180);
        if (aa.dor().equals("zh_CN")) {
            this.mMI.setAlpha(0.0f);
            this.mMI.animate().alpha(1.0f).setDuration(500).start();
            this.mMI.setVisibility(0);
            this.mMK.setVisibility(8);
            this.mMJ.setText("");
            AppMethodBeat.o(62180);
            return;
        }
        AppMethodBeat.o(62180);
    }
}

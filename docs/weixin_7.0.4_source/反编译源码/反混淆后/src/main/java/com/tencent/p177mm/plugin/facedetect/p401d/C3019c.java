package com.tencent.p177mm.plugin.facedetect.p401d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.p177mm.plugin.facedetect.p401d.C11802b.C11803b;
import com.tencent.p177mm.plugin.facedetect.p401d.C11802b.C11804a;
import com.tencent.p177mm.sdk.platformtools.C35988ay;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.view.C31128d;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.tencent.mm.plugin.facedetect.d.c */
public final class C3019c implements C11802b {
    private static String TAG = "MicroMsg.NormalFaceMotion";
    private static long lVc = 500;
    private boolean lVd = false;
    private boolean lVe = false;
    private View lVf = null;
    private View lVg = null;
    private String lVh;
    private long lVi;
    private final Object lVj = new Object();
    private Timer lVk = null;
    private volatile boolean lVl = false;
    private Animation lVm;
    private volatile boolean lVn = false;
    private volatile boolean lVo = false;

    /* renamed from: com.tencent.mm.plugin.facedetect.d.c$2 */
    class C30202 extends TimerTask {

        /* renamed from: com.tencent.mm.plugin.facedetect.d.c$2$1 */
        class C30211 implements Runnable {
            C30211() {
            }

            public final void run() {
                AppMethodBeat.m2504i(298);
                if (C3019c.this.bta() != null) {
                    C3019c.this.bta().startAnimation(C3019c.this.lVm);
                }
                AppMethodBeat.m2505o(298);
            }
        }

        C30202() {
        }

        public final void run() {
            AppMethodBeat.m2504i(299);
            synchronized (C3019c.this.lVj) {
                try {
                    if (!C3019c.this.lVl) {
                        C4990ab.m7420w(C3019c.TAG, "hy: already stopped");
                        cancel();
                    }
                    C5004al.m7441d(new C30211());
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(299);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.d.c$1 */
    class C30221 implements OnClickListener {
        C30221() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(297);
            C3019c.this.lVe = true;
            AppMethodBeat.m2505o(297);
        }
    }

    public C3019c(String str, long j) {
        AppMethodBeat.m2504i(300);
        this.lVh = str;
        this.lVi = j;
        this.lVm = AnimationUtils.loadAnimation(C4996ah.getContext(), C25738R.anim.f8403df);
        AppMethodBeat.m2505o(300);
    }

    public final boolean bsV() {
        return this.lVd && this.lVe;
    }

    public final TextView bta() {
        AppMethodBeat.m2504i(301);
        TextView textView;
        if (!this.lVd && this.lVf != null) {
            textView = (TextView) this.lVf.findViewById(2131823775);
            AppMethodBeat.m2505o(301);
            return textView;
        } else if (!this.lVd || this.lVg == null) {
            AppMethodBeat.m2505o(301);
            return null;
        } else {
            textView = (TextView) this.lVg.findViewById(2131823775);
            AppMethodBeat.m2505o(301);
            return textView;
        }
    }

    public final void setBusinessTip(String str) {
        AppMethodBeat.m2504i(302);
        C4990ab.m7410d(TAG, "getHintMsgTv() == null : " + (bta() == null));
        if (bta() == null) {
            AppMethodBeat.m2505o(302);
            return;
        }
        bta().setText(str);
        AppMethodBeat.m2505o(302);
    }

    /* renamed from: a */
    public final void mo7238a(Context context, ViewGroup viewGroup, ViewGroup viewGroup2) {
        AppMethodBeat.m2504i(303);
        this.lVf = LayoutInflater.from(context).inflate(2130969461, viewGroup);
        this.lVg = LayoutInflater.from(context).inflate(2130969462, viewGroup2);
        this.lVg.setVisibility(4);
        if (bta() != null) {
            bta().setText(this.lVh);
        }
        C4990ab.m7417i(TAG, "hy: starting tween timer: tween: %d", Long.valueOf(this.lVi));
        if (this.lVk != null) {
            this.lVk.cancel();
        }
        this.lVk = new Timer("FaceDetect_hint", true);
        this.lVl = true;
        this.lVk.scheduleAtFixedRate(new C30202(), 0, r4);
        AppMethodBeat.m2505o(303);
    }

    public final boolean bsW() {
        return false;
    }

    /* renamed from: a */
    public final boolean mo7239a(FaceCharacteristicsResult faceCharacteristicsResult) {
        AppMethodBeat.m2504i(304);
        if (this.lVd && faceCharacteristicsResult != null && faceCharacteristicsResult.errCode == 18) {
            C4990ab.m7410d(TAG, "hy: ignore too active");
            AppMethodBeat.m2505o(304);
            return true;
        }
        AppMethodBeat.m2505o(304);
        return false;
    }

    public final C11803b bsY() {
        AppMethodBeat.m2504i(307);
        C11803b c11803b;
        if (this.lVd) {
            c11803b = new C11803b(90025, "user cancelled in intermediate page");
            AppMethodBeat.m2505o(307);
            return c11803b;
        }
        c11803b = new C11803b(90004, "user cancelled in processing");
        AppMethodBeat.m2505o(307);
        return c11803b;
    }

    public final C11804a bsZ() {
        AppMethodBeat.m2504i(308);
        if (!this.lVd || this.lVo) {
            AppMethodBeat.m2505o(308);
            return null;
        }
        this.lVo = true;
        C11804a c11804a = new C11804a();
        AppMethodBeat.m2505o(308);
        return c11804a;
    }

    /* renamed from: b */
    public final boolean mo7240b(FaceCharacteristicsResult faceCharacteristicsResult) {
        AppMethodBeat.m2504i(C31128d.MIC_PTU_QINGCHENG);
        if (faceCharacteristicsResult.errCode == -1) {
            this.lVd = true;
            if (!this.lVn) {
                C35988ay.m59201au(C4996ah.getContext(), C25738R.string.dgc);
                TextView textView = (TextView) this.lVf.findViewById(2131823775);
                Animation loadAnimation = AnimationUtils.loadAnimation(C4996ah.getContext(), C25738R.anim.f8327ay);
                Animation loadAnimation2 = AnimationUtils.loadAnimation(C4996ah.getContext(), C25738R.anim.f8332b5);
                loadAnimation.setDuration(lVc);
                loadAnimation2.setDuration(lVc);
                textView.startAnimation(loadAnimation);
                textView.setVisibility(4);
                this.lVg.setVisibility(0);
                this.lVg.startAnimation(loadAnimation2);
                this.lVg.findViewById(2131823776).setOnClickListener(new C30221());
                this.lVn = true;
                AppMethodBeat.m2505o(C31128d.MIC_PTU_QINGCHENG);
                return true;
            }
        }
        AppMethodBeat.m2505o(C31128d.MIC_PTU_QINGCHENG);
        return false;
    }

    public final void bsX() {
        AppMethodBeat.m2504i(306);
        this.lVl = false;
        if (this.lVk != null) {
            this.lVk.cancel();
        }
        this.lVd = false;
        this.lVn = false;
        this.lVo = false;
        this.lVe = false;
        AppMethodBeat.m2505o(306);
    }
}

package com.tencent.mm.plugin.facedetect.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.facedetect.d.b.a;
import com.tencent.mm.plugin.facedetect.d.b.b;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.view.d;
import java.util.Timer;
import java.util.TimerTask;

public final class c implements b {
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

    public c(String str, long j) {
        AppMethodBeat.i(300);
        this.lVh = str;
        this.lVi = j;
        this.lVm = AnimationUtils.loadAnimation(ah.getContext(), R.anim.df);
        AppMethodBeat.o(300);
    }

    public final boolean bsV() {
        return this.lVd && this.lVe;
    }

    public final TextView bta() {
        AppMethodBeat.i(301);
        TextView textView;
        if (!this.lVd && this.lVf != null) {
            textView = (TextView) this.lVf.findViewById(R.id.bmb);
            AppMethodBeat.o(301);
            return textView;
        } else if (!this.lVd || this.lVg == null) {
            AppMethodBeat.o(301);
            return null;
        } else {
            textView = (TextView) this.lVg.findViewById(R.id.bmb);
            AppMethodBeat.o(301);
            return textView;
        }
    }

    public final void setBusinessTip(String str) {
        AppMethodBeat.i(302);
        ab.d(TAG, "getHintMsgTv() == null : " + (bta() == null));
        if (bta() == null) {
            AppMethodBeat.o(302);
            return;
        }
        bta().setText(str);
        AppMethodBeat.o(302);
    }

    public final void a(Context context, ViewGroup viewGroup, ViewGroup viewGroup2) {
        AppMethodBeat.i(303);
        this.lVf = LayoutInflater.from(context).inflate(R.layout.x6, viewGroup);
        this.lVg = LayoutInflater.from(context).inflate(R.layout.x7, viewGroup2);
        this.lVg.setVisibility(4);
        if (bta() != null) {
            bta().setText(this.lVh);
        }
        ab.i(TAG, "hy: starting tween timer: tween: %d", Long.valueOf(this.lVi));
        if (this.lVk != null) {
            this.lVk.cancel();
        }
        this.lVk = new Timer("FaceDetect_hint", true);
        this.lVl = true;
        this.lVk.scheduleAtFixedRate(new TimerTask() {
            public final void run() {
                AppMethodBeat.i(299);
                synchronized (c.this.lVj) {
                    try {
                        if (!c.this.lVl) {
                            ab.w(c.TAG, "hy: already stopped");
                            cancel();
                        }
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(298);
                                if (c.this.bta() != null) {
                                    c.this.bta().startAnimation(c.this.lVm);
                                }
                                AppMethodBeat.o(298);
                            }
                        });
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(299);
                    }
                }
            }
        }, 0, r4);
        AppMethodBeat.o(303);
    }

    public final boolean bsW() {
        return false;
    }

    public final boolean a(FaceCharacteristicsResult faceCharacteristicsResult) {
        AppMethodBeat.i(304);
        if (this.lVd && faceCharacteristicsResult != null && faceCharacteristicsResult.errCode == 18) {
            ab.d(TAG, "hy: ignore too active");
            AppMethodBeat.o(304);
            return true;
        }
        AppMethodBeat.o(304);
        return false;
    }

    public final b bsY() {
        AppMethodBeat.i(307);
        b bVar;
        if (this.lVd) {
            bVar = new b(90025, "user cancelled in intermediate page");
            AppMethodBeat.o(307);
            return bVar;
        }
        bVar = new b(90004, "user cancelled in processing");
        AppMethodBeat.o(307);
        return bVar;
    }

    public final a bsZ() {
        AppMethodBeat.i(308);
        if (!this.lVd || this.lVo) {
            AppMethodBeat.o(308);
            return null;
        }
        this.lVo = true;
        a aVar = new a();
        AppMethodBeat.o(308);
        return aVar;
    }

    public final boolean b(FaceCharacteristicsResult faceCharacteristicsResult) {
        AppMethodBeat.i(d.MIC_PTU_QINGCHENG);
        if (faceCharacteristicsResult.errCode == -1) {
            this.lVd = true;
            if (!this.lVn) {
                ay.au(ah.getContext(), R.string.dgc);
                TextView textView = (TextView) this.lVf.findViewById(R.id.bmb);
                Animation loadAnimation = AnimationUtils.loadAnimation(ah.getContext(), R.anim.ay);
                Animation loadAnimation2 = AnimationUtils.loadAnimation(ah.getContext(), R.anim.b5);
                loadAnimation.setDuration(lVc);
                loadAnimation2.setDuration(lVc);
                textView.startAnimation(loadAnimation);
                textView.setVisibility(4);
                this.lVg.setVisibility(0);
                this.lVg.startAnimation(loadAnimation2);
                this.lVg.findViewById(R.id.bmc).setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(297);
                        c.this.lVe = true;
                        AppMethodBeat.o(297);
                    }
                });
                this.lVn = true;
                AppMethodBeat.o(d.MIC_PTU_QINGCHENG);
                return true;
            }
        }
        AppMethodBeat.o(d.MIC_PTU_QINGCHENG);
        return false;
    }

    public final void bsX() {
        AppMethodBeat.i(306);
        this.lVl = false;
        if (this.lVk != null) {
            this.lVk.cancel();
        }
        this.lVd = false;
        this.lVn = false;
        this.lVo = false;
        this.lVe = false;
        AppMethodBeat.o(306);
    }
}

package com.tencent.p177mm.plugin.location.p446ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.modelgeo.C42207b.C42206a;
import com.tencent.p177mm.plugin.p443k.C28354d;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5056d;

/* renamed from: com.tencent.mm.plugin.location.ui.e */
public final class C3339e extends ImageView {
    private static int nLT;
    private final String TAG = "MicroMsg.MyPoiPoint";
    private double bDK;
    public C42206a ecy = new C33401();
    private boolean isRunning;
    private Activity mActivity;
    private C42206a nLK;
    private Bitmap nLL;
    private boolean nLM;
    private double nLN;
    private double nLO;
    public C26443d nLP;
    private C28354d nLQ;
    private boolean nLR = false;
    private final int nLS = 689208551;
    private boolean nLU = false;

    /* renamed from: com.tencent.mm.plugin.location.ui.e$1 */
    class C33401 implements C42206a {
        C33401() {
        }

        /* renamed from: a */
        public final boolean mo5861a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.m2504i(113456);
            if (!z) {
                AppMethodBeat.m2505o(113456);
                return false;
            } else if (C3339e.this.nLU) {
                AppMethodBeat.m2505o(113456);
                return false;
            } else {
                C4990ab.m7411d("MicroMsg.MyPoiPoint", "new location comes! slat : %f, slng: %f", Float.valueOf(f2), Float.valueOf(f));
                C3339e.this.nLM = true;
                C3339e.this.bDK = d2;
                C3339e.this.nLN = (double) f2;
                C3339e.this.nLO = (double) f;
                if (C3339e.this.nLQ != null) {
                    if (C3339e.this.nLR) {
                        C3339e.this.nLQ.updateLocaitonPinLayout(C3339e.this, C3339e.this.nLN, C3339e.this.nLO);
                    } else {
                        C3339e.this.nLR = true;
                        C3339e.this.nLQ.addPinView(C3339e.this, C3339e.this.nLN, C3339e.this.nLO);
                    }
                }
                if (C3339e.this.nLK != null) {
                    C3339e.this.nLK.mo5861a(z, f, f2, i, d, d2, d3);
                }
                C3339e.this.invalidate();
                C3339e.this.postInvalidate();
                C3339e.this.requestLayout();
                C3339e.this.nLU = true;
                AppMethodBeat.m2505o(113456);
                return true;
            }
        }
    }

    public C3339e(Activity activity, C28354d c28354d) {
        super(activity);
        AppMethodBeat.m2504i(113457);
        this.nLQ = c28354d;
        this.nLK = null;
        this.mActivity = activity;
        this.nLL = C5056d.m7610LV(C25738R.drawable.alj);
        this.isRunning = false;
        this.nLM = false;
        this.nLP = C26443d.agz();
        nLT = C4977b.m7371b((Context) activity, 80.0f);
        setImageResource(C25738R.drawable.alj);
        setScaleType(ScaleType.FIT_CENTER);
        C4990ab.m7410d("MicroMsg.MyPoiPoint", "enableLocation");
        this.isRunning = true;
        this.nLP.mo44203a(this.ecy);
        AppMethodBeat.m2505o(113457);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(113458);
        super.onDraw(canvas);
        C4990ab.m7410d("MicroMsg.MyPoiPoint", "onDraw");
        AppMethodBeat.m2505o(113458);
    }
}

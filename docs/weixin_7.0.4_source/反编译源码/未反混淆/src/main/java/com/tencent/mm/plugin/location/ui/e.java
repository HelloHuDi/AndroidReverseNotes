package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;

public final class e extends ImageView {
    private static int nLT;
    private final String TAG = "MicroMsg.MyPoiPoint";
    private double bDK;
    public a ecy = new a() {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.i(113456);
            if (!z) {
                AppMethodBeat.o(113456);
                return false;
            } else if (e.this.nLU) {
                AppMethodBeat.o(113456);
                return false;
            } else {
                ab.d("MicroMsg.MyPoiPoint", "new location comes! slat : %f, slng: %f", Float.valueOf(f2), Float.valueOf(f));
                e.this.nLM = true;
                e.this.bDK = d2;
                e.this.nLN = (double) f2;
                e.this.nLO = (double) f;
                if (e.this.nLQ != null) {
                    if (e.this.nLR) {
                        e.this.nLQ.updateLocaitonPinLayout(e.this, e.this.nLN, e.this.nLO);
                    } else {
                        e.this.nLR = true;
                        e.this.nLQ.addPinView(e.this, e.this.nLN, e.this.nLO);
                    }
                }
                if (e.this.nLK != null) {
                    e.this.nLK.a(z, f, f2, i, d, d2, d3);
                }
                e.this.invalidate();
                e.this.postInvalidate();
                e.this.requestLayout();
                e.this.nLU = true;
                AppMethodBeat.o(113456);
                return true;
            }
        }
    };
    private boolean isRunning;
    private Activity mActivity;
    private a nLK;
    private Bitmap nLL;
    private boolean nLM;
    private double nLN;
    private double nLO;
    public d nLP;
    private com.tencent.mm.plugin.k.d nLQ;
    private boolean nLR = false;
    private final int nLS = 689208551;
    private boolean nLU = false;

    public e(Activity activity, com.tencent.mm.plugin.k.d dVar) {
        super(activity);
        AppMethodBeat.i(113457);
        this.nLQ = dVar;
        this.nLK = null;
        this.mActivity = activity;
        this.nLL = com.tencent.mm.sdk.platformtools.d.LV(R.drawable.alj);
        this.isRunning = false;
        this.nLM = false;
        this.nLP = d.agz();
        nLT = b.b((Context) activity, 80.0f);
        setImageResource(R.drawable.alj);
        setScaleType(ScaleType.FIT_CENTER);
        ab.d("MicroMsg.MyPoiPoint", "enableLocation");
        this.isRunning = true;
        this.nLP.a(this.ecy);
        AppMethodBeat.o(113457);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(113458);
        super.onDraw(canvas);
        ab.d("MicroMsg.MyPoiPoint", "onDraw");
        AppMethodBeat.o(113458);
    }
}

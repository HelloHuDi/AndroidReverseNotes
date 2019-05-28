package com.tencent.p177mm.plugin.freewifi.p418ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiStateView */
public class FreeWifiStateView extends ImageView {
    private int bottom;
    private C7306ak fbD;
    int lAB;
    private int lAC;
    private Runnable lAD;
    private int left;
    private Context mContext;
    private Paint mPaint;
    private int right;
    private int state;
    private int top;

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiStateView$1 */
    class C281011 implements Runnable {
        C281011() {
        }

        public final void run() {
            AppMethodBeat.m2504i(21080);
            FreeWifiStateView.this.invalidate();
            AppMethodBeat.m2505o(21080);
        }
    }

    public FreeWifiStateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FreeWifiStateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(21081);
        this.lAB = 2;
        this.left = -1;
        this.top = -1;
        this.right = -1;
        this.bottom = -1;
        this.lAC = -1;
        this.lAD = new C281011();
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Style.STROKE);
        this.left = C1338a.fromDPToPix(this.mContext, 2);
        this.top = this.left;
        this.lAC = C1338a.fromDPToPix(this.mContext, 3);
        this.fbD = new C7306ak(Looper.getMainLooper());
        AppMethodBeat.m2505o(21081);
    }

    public void setState(int i) {
        AppMethodBeat.m2504i(21082);
        this.state = i;
        m85357uR(10);
        AppMethodBeat.m2505o(21082);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(21083);
        super.onDraw(canvas);
        if (this.state == 1) {
            int width = getWidth() / 2;
            this.mPaint.setARGB(255, 103, 209, 79);
            this.mPaint.setStrokeWidth((float) this.lAC);
            if (this.right == -1) {
                this.right = (width * 2) - this.left;
            }
            if (this.bottom == -1) {
                this.bottom = this.right;
            }
            canvas.drawArc(new RectF((float) this.left, (float) this.top, (float) this.right, (float) this.bottom), 270.0f, (float) this.lAB, false, this.mPaint);
            this.lAB += 5;
            if (this.lAB > 365) {
                this.lAB = 0;
            }
            m85357uR(100);
        }
        AppMethodBeat.m2505o(21083);
    }

    /* renamed from: uR */
    private void m85357uR(int i) {
        AppMethodBeat.m2504i(21084);
        this.fbD.removeCallbacks(this.lAD);
        this.fbD.postDelayed(this.lAD, (long) i);
        AppMethodBeat.m2505o(21084);
    }
}

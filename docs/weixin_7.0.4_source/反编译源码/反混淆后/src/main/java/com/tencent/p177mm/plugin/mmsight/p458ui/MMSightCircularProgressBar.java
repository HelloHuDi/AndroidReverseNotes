package com.tencent.p177mm.plugin.mmsight.p458ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.mmsight.p458ui.C12618c.C3509a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar */
public class MMSightCircularProgressBar extends View {
    private Paint aFY;
    boolean cFy = false;
    int duration = 0;
    private Context mContext;
    float oAH = 0.0f;
    int oAI = 0;
    int oAJ = 0;
    private RectF oAK;
    C12618c oAL;
    C3497a oAM;
    private int oAN = Color.parseColor("#1AAD19");
    private float offset = 0.0f;
    private float strokeWidth = 0.0f;

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar$1 */
    class C34951 implements C3509a {

        /* renamed from: com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar$1$1 */
        class C34961 implements Runnable {
            C34961() {
            }

            public final void run() {
                AppMethodBeat.m2504i(55079);
                if (MMSightCircularProgressBar.this.oAM != null) {
                    MMSightCircularProgressBar.this.oAM.bnW();
                }
                AppMethodBeat.m2505o(55079);
            }
        }

        C34951() {
        }

        /* renamed from: aO */
        public final void mo7975aO(float f) {
            AppMethodBeat.m2504i(55080);
            MMSightCircularProgressBar.this.oAH = f;
            MMSightCircularProgressBar.this.invalidate();
            AppMethodBeat.m2505o(55080);
        }

        public final void onAnimationEnd() {
            AppMethodBeat.m2504i(55081);
            C4990ab.m7416i("MicroMsg.MMSightCircularProgressBar", "onAnimationEnd");
            C5004al.m7441d(new C34961());
            AppMethodBeat.m2505o(55081);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar$a */
    public interface C3497a {
        void bnW();
    }

    public MMSightCircularProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(55082);
        this.mContext = context;
        init();
        AppMethodBeat.m2505o(55082);
    }

    public MMSightCircularProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(55083);
        this.mContext = context;
        init();
        AppMethodBeat.m2505o(55083);
    }

    private void init() {
        AppMethodBeat.m2504i(55084);
        float dimensionPixelSize = (float) this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.a66);
        this.strokeWidth = (float) this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.a68);
        this.offset = this.strokeWidth / 2.0f;
        this.oAK = new RectF(this.offset, this.offset, dimensionPixelSize - this.offset, dimensionPixelSize - this.offset);
        this.aFY = new Paint();
        this.aFY.setStyle(Style.STROKE);
        this.aFY.setStrokeWidth(this.strokeWidth);
        this.aFY.setColor(this.oAN);
        this.aFY.setAlpha(XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION);
        this.aFY.setAntiAlias(true);
        AppMethodBeat.m2505o(55084);
    }

    public void setMaxProgress(int i) {
        AppMethodBeat.m2504i(55085);
        C4990ab.m7417i("MicroMsg.MMSightCircularProgressBar", "setMaxProgress: %s", Integer.valueOf(i));
        this.oAJ = i;
        AppMethodBeat.m2505o(55085);
    }

    public void setDuration(int i) {
        AppMethodBeat.m2504i(55086);
        C4990ab.m7417i("MicroMsg.MMSightCircularProgressBar", "setDuration: %s", Integer.valueOf(i));
        this.duration = i;
        AppMethodBeat.m2505o(55086);
    }

    public void setInitProgress(int i) {
        AppMethodBeat.m2504i(55087);
        C4990ab.m7417i("MicroMsg.MMSightCircularProgressBar", "setInitProgress: %s, isStart: %s", Integer.valueOf(i), Boolean.valueOf(this.cFy));
        if (!this.cFy) {
            this.oAI = i;
        }
        AppMethodBeat.m2505o(55087);
    }

    public void setCircularColor(int i) {
        AppMethodBeat.m2504i(55088);
        if (!(this.aFY == null || i == 0)) {
            this.aFY.setColor(i);
        }
        AppMethodBeat.m2505o(55088);
    }

    public void setProgressCallback(C3497a c3497a) {
        this.oAM = c3497a;
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(55089);
        canvas.save();
        canvas.translate(this.offset, this.offset);
        canvas.rotate(180.0f, this.oAK.right / 2.0f, this.oAK.bottom / 2.0f);
        canvas.drawArc(this.oAK, 90.0f, 360.0f * (this.oAH / ((float) this.oAJ)), false, this.aFY);
        canvas.restore();
        AppMethodBeat.m2505o(55089);
    }
}

package com.tencent.mm.plugin.mmsight.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import org.xwalk.core.XWalkEnvironment;

public class MMSightCircularProgressBar extends View {
    private Paint aFY;
    boolean cFy = false;
    int duration = 0;
    private Context mContext;
    float oAH = 0.0f;
    int oAI = 0;
    int oAJ = 0;
    private RectF oAK;
    c oAL;
    a oAM;
    private int oAN = Color.parseColor("#1AAD19");
    private float offset = 0.0f;
    private float strokeWidth = 0.0f;

    public interface a {
        void bnW();
    }

    public MMSightCircularProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(55082);
        this.mContext = context;
        init();
        AppMethodBeat.o(55082);
    }

    public MMSightCircularProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(55083);
        this.mContext = context;
        init();
        AppMethodBeat.o(55083);
    }

    private void init() {
        AppMethodBeat.i(55084);
        float dimensionPixelSize = (float) this.mContext.getResources().getDimensionPixelSize(R.dimen.a66);
        this.strokeWidth = (float) this.mContext.getResources().getDimensionPixelSize(R.dimen.a68);
        this.offset = this.strokeWidth / 2.0f;
        this.oAK = new RectF(this.offset, this.offset, dimensionPixelSize - this.offset, dimensionPixelSize - this.offset);
        this.aFY = new Paint();
        this.aFY.setStyle(Style.STROKE);
        this.aFY.setStrokeWidth(this.strokeWidth);
        this.aFY.setColor(this.oAN);
        this.aFY.setAlpha(XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION);
        this.aFY.setAntiAlias(true);
        AppMethodBeat.o(55084);
    }

    public void setMaxProgress(int i) {
        AppMethodBeat.i(55085);
        ab.i("MicroMsg.MMSightCircularProgressBar", "setMaxProgress: %s", Integer.valueOf(i));
        this.oAJ = i;
        AppMethodBeat.o(55085);
    }

    public void setDuration(int i) {
        AppMethodBeat.i(55086);
        ab.i("MicroMsg.MMSightCircularProgressBar", "setDuration: %s", Integer.valueOf(i));
        this.duration = i;
        AppMethodBeat.o(55086);
    }

    public void setInitProgress(int i) {
        AppMethodBeat.i(55087);
        ab.i("MicroMsg.MMSightCircularProgressBar", "setInitProgress: %s, isStart: %s", Integer.valueOf(i), Boolean.valueOf(this.cFy));
        if (!this.cFy) {
            this.oAI = i;
        }
        AppMethodBeat.o(55087);
    }

    public void setCircularColor(int i) {
        AppMethodBeat.i(55088);
        if (!(this.aFY == null || i == 0)) {
            this.aFY.setColor(i);
        }
        AppMethodBeat.o(55088);
    }

    public void setProgressCallback(a aVar) {
        this.oAM = aVar;
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(55089);
        canvas.save();
        canvas.translate(this.offset, this.offset);
        canvas.rotate(180.0f, this.oAK.right / 2.0f, this.oAK.bottom / 2.0f);
        canvas.drawArc(this.oAK, 90.0f, 360.0f * (this.oAH / ((float) this.oAJ)), false, this.aFY);
        canvas.restore();
        AppMethodBeat.o(55089);
    }
}

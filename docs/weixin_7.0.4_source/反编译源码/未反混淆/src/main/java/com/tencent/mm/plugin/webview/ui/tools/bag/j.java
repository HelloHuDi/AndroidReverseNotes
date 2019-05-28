package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.View.MeasureSpec;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class j extends View {
    int mHeight;
    private Bitmap mMaskBitmap;
    private Paint mPaint = new Paint();
    int mWidth;
    private Bitmap uyO;
    private Canvas uyP;
    private Paint uyQ = new Paint();
    private Rect uyR;
    private RectF uyS;
    private int uyT;
    int uyU;
    int uyV;
    int uyW;
    int uyX = -1;
    boolean uyY;
    private AnimatorListenerAdapter uyZ;

    public j(Context context, Bitmap bitmap) {
        super(context);
        AppMethodBeat.i(8181);
        this.uyQ.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
        this.uyO = bitmap;
        this.mWidth = bitmap.getWidth();
        this.mHeight = bitmap.getHeight();
        this.uyR = new Rect(0, 0, this.mWidth, this.mHeight);
        this.mMaskBitmap = Bitmap.createBitmap(this.mWidth, this.mHeight, Config.ARGB_8888);
        this.uyP = new Canvas(this.mMaskBitmap);
        this.uyS = new RectF();
        this.uyS.left = 0.0f;
        this.uyS.top = 0.0f;
        this.uyS.right = (float) this.mWidth;
        this.uyS.bottom = (float) this.mHeight;
        ab.i("MicroMsg.TransformToBagAniMask", String.format("init: mWidth:%d mHeight:%d", new Object[]{Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight)}));
        AppMethodBeat.o(8181);
    }

    public final void setContentStartPosX(int i) {
        this.uyX = i;
    }

    public final void setListener(AnimatorListenerAdapter animatorListenerAdapter) {
        this.uyZ = animatorListenerAdapter;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(8182);
        canvas.save();
        if (this.uyY) {
            canvas.translate((float) this.uyT, 0.0f);
        }
        canvas.clipRect(this.uyS);
        canvas.drawBitmap(this.uyO, this.uyR, this.uyR, this.mPaint);
        canvas.restore();
        AppMethodBeat.o(8182);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onMeasure(int i, int i2) {
        AppMethodBeat.i(8183);
        super.onMeasure(MeasureSpec.makeMeasureSpec(this.mWidth, ErrorDialogData.SUPPRESSED), MeasureSpec.makeMeasureSpec(this.mHeight, ErrorDialogData.SUPPRESSED));
        AppMethodBeat.o(8183);
    }
}

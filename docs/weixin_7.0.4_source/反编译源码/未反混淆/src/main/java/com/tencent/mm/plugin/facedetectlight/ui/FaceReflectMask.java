package com.tencent.mm.plugin.facedetectlight.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import com.tencent.youtu.ytagreflectlivecheck.controller.ReflectController;
import com.tencent.youtu.ytagreflectlivecheck.ui.YTReflectLayout;

public class FaceReflectMask extends YTReflectLayout {
    private ColorMatrixColorFilter mColorMatrixColorFilter;
    private Paint mcJ = new Paint(1);
    private Paint mcK;
    private PorterDuffXfermode mcL;
    public boolean mcM = false;
    public boolean mdZ;
    private Rect rect = new Rect();

    public FaceReflectMask(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(803);
        this.mcJ.setStyle(Style.FILL);
        this.mcK = new Paint(1);
        this.mColorMatrixColorFilter = ReflectController.DEFAULT_MATRIX_COLOR_FILTER;
        setWillNotDraw(false);
        this.mcL = new PorterDuffXfermode(Mode.CLEAR);
        this.mdZ = true;
        setLayerType(1, null);
        AppMethodBeat.o(803);
    }

    public void setColorMatrixColorFilter(ColorMatrixColorFilter colorMatrixColorFilter) {
        AppMethodBeat.i(804);
        this.mColorMatrixColorFilter = colorMatrixColorFilter;
        invalidate();
        AppMethodBeat.o(804);
    }

    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(805);
        canvas.save();
        float width = (float) (((double) getWidth()) * 0.35d);
        float width2 = (float) (((double) getWidth()) * 0.5d);
        float height = (float) (((double) getHeight()) * 0.4d);
        this.rect.left = 0;
        this.rect.right = getWidth();
        this.rect.top = 0;
        this.rect.bottom = getHeight();
        if (this.mdZ) {
            this.mcJ.setColor(WebView.NIGHT_MODE_COLOR);
            this.mdZ = false;
        } else {
            this.mcJ.setColor(WebView.NIGHT_MODE_COLOR);
            this.mcJ.setColorFilter(this.mColorMatrixColorFilter);
        }
        canvas.drawARGB(255, 0, 0, 0);
        canvas.drawRect(this.rect, this.mcJ);
        if (!this.mcM) {
            this.mcK.setStyle(Style.FILL_AND_STROKE);
            this.mcK.setXfermode(this.mcL);
            canvas.drawCircle(width2, height, width, this.mcK);
        }
        canvas.restore();
        AppMethodBeat.o(805);
    }
}

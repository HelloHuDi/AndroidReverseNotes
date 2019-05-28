package com.facebook.share.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;

@Deprecated
public class LikeBoxCountView extends FrameLayout {
    private int additionalTextPadding;
    private Paint borderPaint;
    private float borderRadius;
    private float caretHeight;
    private LikeBoxCountViewCaretPosition caretPosition = LikeBoxCountViewCaretPosition.LEFT;
    private float caretWidth;
    private TextView likeCountLabel;
    private int textPadding;

    public enum LikeBoxCountViewCaretPosition {
        LEFT,
        TOP,
        RIGHT,
        BOTTOM;

        static {
            AppMethodBeat.m2505o(97075);
        }
    }

    @Deprecated
    public LikeBoxCountView(Context context) {
        super(context);
        AppMethodBeat.m2504i(97076);
        initialize(context);
        AppMethodBeat.m2505o(97076);
    }

    @Deprecated
    public void setText(String str) {
        AppMethodBeat.m2504i(97077);
        this.likeCountLabel.setText(str);
        AppMethodBeat.m2505o(97077);
    }

    @Deprecated
    public void setCaretPosition(LikeBoxCountViewCaretPosition likeBoxCountViewCaretPosition) {
        AppMethodBeat.m2504i(97078);
        this.caretPosition = likeBoxCountViewCaretPosition;
        switch (likeBoxCountViewCaretPosition) {
            case LEFT:
                setAdditionalTextPadding(this.additionalTextPadding, 0, 0, 0);
                AppMethodBeat.m2505o(97078);
                return;
            case TOP:
                setAdditionalTextPadding(0, this.additionalTextPadding, 0, 0);
                AppMethodBeat.m2505o(97078);
                return;
            case RIGHT:
                setAdditionalTextPadding(0, 0, this.additionalTextPadding, 0);
                AppMethodBeat.m2505o(97078);
                return;
            case BOTTOM:
                setAdditionalTextPadding(0, 0, 0, this.additionalTextPadding);
                break;
        }
        AppMethodBeat.m2505o(97078);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(97079);
        super.onDraw(canvas);
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        switch (this.caretPosition) {
            case LEFT:
                paddingLeft = (int) (((float) paddingLeft) + this.caretHeight);
                break;
            case TOP:
                paddingTop = (int) (((float) paddingTop) + this.caretHeight);
                break;
            case RIGHT:
                width = (int) (((float) width) - this.caretHeight);
                break;
            case BOTTOM:
                height = (int) (((float) height) - this.caretHeight);
                break;
        }
        float f = (float) width;
        float f2 = (float) height;
        drawBorder(canvas, (float) paddingLeft, (float) paddingTop, f, f2);
        AppMethodBeat.m2505o(97079);
    }

    private void initialize(Context context) {
        AppMethodBeat.m2504i(97080);
        setWillNotDraw(false);
        this.caretHeight = getResources().getDimension(C25738R.dimen.f10311xl);
        this.caretWidth = getResources().getDimension(C25738R.dimen.f10312xm);
        this.borderRadius = getResources().getDimension(C25738R.dimen.f10309xj);
        this.borderPaint = new Paint();
        this.borderPaint.setColor(getResources().getColor(C25738R.color.f11896ky));
        this.borderPaint.setStrokeWidth(getResources().getDimension(C25738R.dimen.f10310xk));
        this.borderPaint.setStyle(Style.STROKE);
        initializeLikeCountLabel(context);
        addView(this.likeCountLabel);
        setCaretPosition(this.caretPosition);
        AppMethodBeat.m2505o(97080);
    }

    private void initializeLikeCountLabel(Context context) {
        AppMethodBeat.m2504i(97081);
        this.likeCountLabel = new TextView(context);
        this.likeCountLabel.setLayoutParams(new LayoutParams(-1, -1));
        this.likeCountLabel.setGravity(17);
        this.likeCountLabel.setTextSize(0, getResources().getDimension(C25738R.dimen.f10314xo));
        this.likeCountLabel.setTextColor(getResources().getColor(C25738R.color.f11897kz));
        this.textPadding = getResources().getDimensionPixelSize(C25738R.dimen.f10313xn);
        this.additionalTextPadding = getResources().getDimensionPixelSize(C25738R.dimen.f10311xl);
        AppMethodBeat.m2505o(97081);
    }

    private void setAdditionalTextPadding(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(97082);
        this.likeCountLabel.setPadding(this.textPadding + i, this.textPadding + i2, this.textPadding + i3, this.textPadding + i4);
        AppMethodBeat.m2505o(97082);
    }

    private void drawBorder(Canvas canvas, float f, float f2, float f3, float f4) {
        AppMethodBeat.m2504i(97083);
        Path path = new Path();
        float f5 = this.borderRadius * 2.0f;
        path.addArc(new RectF(f, f2, f + f5, f2 + f5), -180.0f, 90.0f);
        if (this.caretPosition == LikeBoxCountViewCaretPosition.TOP) {
            path.lineTo((((f3 - f) - this.caretWidth) / 2.0f) + f, f2);
            path.lineTo(((f3 - f) / 2.0f) + f, f2 - this.caretHeight);
            path.lineTo((((f3 - f) + this.caretWidth) / 2.0f) + f, f2);
        }
        path.lineTo(f3 - this.borderRadius, f2);
        path.addArc(new RectF(f3 - f5, f2, f3, f2 + f5), -90.0f, 90.0f);
        if (this.caretPosition == LikeBoxCountViewCaretPosition.RIGHT) {
            path.lineTo(f3, (((f4 - f2) - this.caretWidth) / 2.0f) + f2);
            path.lineTo(this.caretHeight + f3, ((f4 - f2) / 2.0f) + f2);
            path.lineTo(f3, (((f4 - f2) + this.caretWidth) / 2.0f) + f2);
        }
        path.lineTo(f3, f4 - this.borderRadius);
        path.addArc(new RectF(f3 - f5, f4 - f5, f3, f4), 0.0f, 90.0f);
        if (this.caretPosition == LikeBoxCountViewCaretPosition.BOTTOM) {
            path.lineTo((((f3 - f) + this.caretWidth) / 2.0f) + f, f4);
            path.lineTo(((f3 - f) / 2.0f) + f, this.caretHeight + f4);
            path.lineTo((((f3 - f) - this.caretWidth) / 2.0f) + f, f4);
        }
        path.lineTo(this.borderRadius + f, f4);
        path.addArc(new RectF(f, f4 - f5, f5 + f, f4), 90.0f, 90.0f);
        if (this.caretPosition == LikeBoxCountViewCaretPosition.LEFT) {
            path.lineTo(f, (((f4 - f2) + this.caretWidth) / 2.0f) + f2);
            path.lineTo(f - this.caretHeight, ((f4 - f2) / 2.0f) + f2);
            path.lineTo(f, (((f4 - f2) - this.caretWidth) / 2.0f) + f2);
        }
        path.lineTo(f, this.borderRadius + f2);
        canvas.drawPath(path, this.borderPaint);
        AppMethodBeat.m2505o(97083);
    }
}

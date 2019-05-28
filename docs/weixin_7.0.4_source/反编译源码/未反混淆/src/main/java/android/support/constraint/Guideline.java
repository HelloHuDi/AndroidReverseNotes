package android.support.constraint;

import android.content.Context;
import android.graphics.Canvas;
import android.support.constraint.ConstraintLayout.LayoutParams;
import android.util.AttributeSet;
import android.view.View;

public class Guideline extends View {
    public Guideline(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public Guideline(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    public Guideline(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        super.setVisibility(8);
    }

    public void setVisibility(int i) {
    }

    public void draw(Canvas canvas) {
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setGuidelineBegin(int i) {
        LayoutParams layoutParams = (LayoutParams) getLayoutParams();
        layoutParams.dw = i;
        setLayoutParams(layoutParams);
    }

    public void setGuidelineEnd(int i) {
        LayoutParams layoutParams = (LayoutParams) getLayoutParams();
        layoutParams.dz = i;
        setLayoutParams(layoutParams);
    }

    public void setGuidelinePercent(float f) {
        LayoutParams layoutParams = (LayoutParams) getLayoutParams();
        layoutParams.dA = f;
        setLayoutParams(layoutParams);
    }
}

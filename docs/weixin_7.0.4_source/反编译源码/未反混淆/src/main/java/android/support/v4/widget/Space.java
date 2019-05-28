package android.support.v4.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;

@Deprecated
public class Space extends View {
    @Deprecated
    public Space(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (getVisibility() == 0) {
            setVisibility(4);
        }
    }

    @Deprecated
    public Space(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Deprecated
    public Space(Context context) {
        this(context, null);
    }

    @SuppressLint({"MissingSuperCall"})
    @Deprecated
    public void draw(Canvas canvas) {
    }

    private static int B(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        switch (mode) {
            case j.INVALID_ID /*-2147483648*/:
                return Math.min(i, size);
            case ErrorDialogData.SUPPRESSED /*1073741824*/:
                return size;
            default:
                return i;
        }
    }

    /* Access modifiers changed, original: protected */
    @Deprecated
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(B(getSuggestedMinimumWidth(), i), B(getSuggestedMinimumHeight(), i2));
    }
}

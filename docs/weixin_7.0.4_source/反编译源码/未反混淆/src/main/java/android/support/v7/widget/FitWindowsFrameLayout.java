package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.ad.a;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class FitWindowsFrameLayout extends FrameLayout implements ad {
    private a aiK;

    public FitWindowsFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnFitSystemWindowsListener(a aVar) {
        this.aiK = aVar;
    }

    /* Access modifiers changed, original: protected */
    public boolean fitSystemWindows(Rect rect) {
        if (this.aiK != null) {
            this.aiK.f(rect);
        }
        return super.fitSystemWindows(rect);
    }
}

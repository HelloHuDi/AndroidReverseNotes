package android.support.p069v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.tencent.p177mm.C25738R;

/* renamed from: android.support.v7.widget.AppCompatSeekBar */
public class AppCompatSeekBar extends SeekBar {
    private final C6259m afT;

    public AppCompatSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C25738R.attr.f5708gc);
    }

    public AppCompatSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.afT = new C6259m(this);
        this.afT.mo2096a(attributeSet, i);
    }

    /* Access modifiers changed, original: protected|declared_synchronized */
    public synchronized void onDraw(Canvas canvas) {
        int i = 1;
        synchronized (this) {
            super.onDraw(canvas);
            C6259m c6259m = this.afT;
            if (c6259m.afV != null) {
                int max = c6259m.afU.getMax();
                if (max > 1) {
                    int intrinsicWidth = c6259m.afV.getIntrinsicWidth();
                    int intrinsicHeight = c6259m.afV.getIntrinsicHeight();
                    intrinsicWidth = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                    if (intrinsicHeight >= 0) {
                        i = intrinsicHeight / 2;
                    }
                    c6259m.afV.setBounds(-intrinsicWidth, -i, intrinsicWidth, i);
                    float width = ((float) ((c6259m.afU.getWidth() - c6259m.afU.getPaddingLeft()) - c6259m.afU.getPaddingRight())) / ((float) max);
                    intrinsicHeight = canvas.save();
                    canvas.translate((float) c6259m.afU.getPaddingLeft(), (float) (c6259m.afU.getHeight() / 2));
                    for (i = 0; i <= max; i++) {
                        c6259m.afV.draw(canvas);
                        canvas.translate(width, 0.0f);
                    }
                    canvas.restoreToCount(intrinsicHeight);
                }
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C6259m c6259m = this.afT;
        Drawable drawable = c6259m.afV;
        if (drawable != null && drawable.isStateful() && drawable.setState(c6259m.afU.getDrawableState())) {
            c6259m.afU.invalidateDrawable(drawable);
        }
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        C6259m c6259m = this.afT;
        if (c6259m.afV != null) {
            c6259m.afV.jumpToCurrentState();
        }
    }
}

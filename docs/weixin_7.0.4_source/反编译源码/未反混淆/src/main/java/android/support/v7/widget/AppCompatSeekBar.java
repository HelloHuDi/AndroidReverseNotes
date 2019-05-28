package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.tencent.mm.R;

public class AppCompatSeekBar extends SeekBar {
    private final m afT;

    public AppCompatSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.gc);
    }

    public AppCompatSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.afT = new m(this);
        this.afT.a(attributeSet, i);
    }

    /* Access modifiers changed, original: protected|declared_synchronized */
    public synchronized void onDraw(Canvas canvas) {
        int i = 1;
        synchronized (this) {
            super.onDraw(canvas);
            m mVar = this.afT;
            if (mVar.afV != null) {
                int max = mVar.afU.getMax();
                if (max > 1) {
                    int intrinsicWidth = mVar.afV.getIntrinsicWidth();
                    int intrinsicHeight = mVar.afV.getIntrinsicHeight();
                    intrinsicWidth = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                    if (intrinsicHeight >= 0) {
                        i = intrinsicHeight / 2;
                    }
                    mVar.afV.setBounds(-intrinsicWidth, -i, intrinsicWidth, i);
                    float width = ((float) ((mVar.afU.getWidth() - mVar.afU.getPaddingLeft()) - mVar.afU.getPaddingRight())) / ((float) max);
                    intrinsicHeight = canvas.save();
                    canvas.translate((float) mVar.afU.getPaddingLeft(), (float) (mVar.afU.getHeight() / 2));
                    for (i = 0; i <= max; i++) {
                        mVar.afV.draw(canvas);
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
        m mVar = this.afT;
        Drawable drawable = mVar.afV;
        if (drawable != null && drawable.isStateful() && drawable.setState(mVar.afU.getDrawableState())) {
            mVar.afU.invalidateDrawable(drawable);
        }
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        m mVar = this.afT;
        if (mVar.afV != null) {
            mVar.afV.jumpToCurrentState();
        }
    }
}

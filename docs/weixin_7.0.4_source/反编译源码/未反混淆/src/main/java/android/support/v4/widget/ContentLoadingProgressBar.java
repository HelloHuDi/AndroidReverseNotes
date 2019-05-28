package android.support.v4.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class ContentLoadingProgressBar extends ProgressBar {
    boolean PB = false;
    boolean PC = false;
    private final Runnable PD = new Runnable() {
        public final void run() {
            ContentLoadingProgressBar.this.PB = false;
            ContentLoadingProgressBar.this.mStartTime = -1;
            ContentLoadingProgressBar.this.setVisibility(8);
        }
    };
    private final Runnable PE = new Runnable() {
        public final void run() {
            ContentLoadingProgressBar.this.PC = false;
            if (!ContentLoadingProgressBar.this.mDismissed) {
                ContentLoadingProgressBar.this.mStartTime = System.currentTimeMillis();
                ContentLoadingProgressBar.this.setVisibility(0);
            }
        }
    };
    boolean mDismissed = false;
    long mStartTime = -1;

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        eD();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        eD();
    }

    private void eD() {
        removeCallbacks(this.PD);
        removeCallbacks(this.PE);
    }
}

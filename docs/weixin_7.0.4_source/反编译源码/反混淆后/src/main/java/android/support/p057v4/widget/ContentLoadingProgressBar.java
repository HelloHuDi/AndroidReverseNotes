package android.support.p057v4.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* renamed from: android.support.v4.widget.ContentLoadingProgressBar */
public class ContentLoadingProgressBar extends ProgressBar {
    /* renamed from: PB */
    boolean f16829PB = false;
    /* renamed from: PC */
    boolean f16830PC = false;
    /* renamed from: PD */
    private final Runnable f16831PD = new C174541();
    /* renamed from: PE */
    private final Runnable f16832PE = new C174552();
    boolean mDismissed = false;
    long mStartTime = -1;

    /* renamed from: android.support.v4.widget.ContentLoadingProgressBar$1 */
    class C174541 implements Runnable {
        C174541() {
        }

        public final void run() {
            ContentLoadingProgressBar.this.f16829PB = false;
            ContentLoadingProgressBar.this.mStartTime = -1;
            ContentLoadingProgressBar.this.setVisibility(8);
        }
    }

    /* renamed from: android.support.v4.widget.ContentLoadingProgressBar$2 */
    class C174552 implements Runnable {
        C174552() {
        }

        public final void run() {
            ContentLoadingProgressBar.this.f16830PC = false;
            if (!ContentLoadingProgressBar.this.mDismissed) {
                ContentLoadingProgressBar.this.mStartTime = System.currentTimeMillis();
                ContentLoadingProgressBar.this.setVisibility(0);
            }
        }
    }

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m72500eD();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m72500eD();
    }

    /* renamed from: eD */
    private void m72500eD() {
        removeCallbacks(this.f16831PD);
        removeCallbacks(this.f16832PE);
    }
}

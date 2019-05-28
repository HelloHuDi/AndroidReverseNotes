package android.support.design.widget;

import android.content.Context;
import android.support.p057v4.view.C0449a;
import android.support.p057v4.view.C0477s;
import android.support.p057v4.view.p067a.C0445b;
import android.support.p069v7.widget.AppCompatImageButton;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import com.tencent.p177mm.C25738R;

public class CheckableImageButton extends AppCompatImageButton implements Checkable {
    /* renamed from: nF */
    private static final int[] f3737nF = new int[]{16842912};
    /* renamed from: nG */
    private boolean f3738nG;

    /* renamed from: android.support.design.widget.CheckableImageButton$1 */
    class C173821 extends C0449a {
        C173821() {
        }

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
        }

        public final void onInitializeAccessibilityNodeInfo(View view, C0445b c0445b) {
            super.onInitializeAccessibilityNodeInfo(view, c0445b);
            c0445b.setCheckable(true);
            c0445b.f546NG.setChecked(CheckableImageButton.this.isChecked());
        }
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C25738R.attr.f5661f3);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C0477s.m905a((View) this, new C173821());
    }

    public void setChecked(boolean z) {
        if (this.f3738nG != z) {
            this.f3738nG = z;
            refreshDrawableState();
            sendAccessibilityEvent(2048);
        }
    }

    public boolean isChecked() {
        return this.f3738nG;
    }

    public void toggle() {
        setChecked(!this.f3738nG);
    }

    public int[] onCreateDrawableState(int i) {
        if (this.f3738nG) {
            return mergeDrawableStates(super.onCreateDrawableState(f3737nF.length + i), f3737nF);
        }
        return super.onCreateDrawableState(i);
    }
}

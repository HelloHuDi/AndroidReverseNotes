package android.support.design.widget;

import android.content.Context;
import android.support.v4.view.a;
import android.support.v4.view.a.b;
import android.support.v4.view.s;
import android.support.v7.widget.AppCompatImageButton;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import com.tencent.mm.R;

public class CheckableImageButton extends AppCompatImageButton implements Checkable {
    private static final int[] nF = new int[]{16842912};
    private boolean nG;

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.f3);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        s.a((View) this, new a() {
            public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
                accessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
            }

            public final void onInitializeAccessibilityNodeInfo(View view, b bVar) {
                super.onInitializeAccessibilityNodeInfo(view, bVar);
                bVar.setCheckable(true);
                bVar.NG.setChecked(CheckableImageButton.this.isChecked());
            }
        });
    }

    public void setChecked(boolean z) {
        if (this.nG != z) {
            this.nG = z;
            refreshDrawableState();
            sendAccessibilityEvent(2048);
        }
    }

    public boolean isChecked() {
        return this.nG;
    }

    public void toggle() {
        setChecked(!this.nG);
    }

    public int[] onCreateDrawableState(int i) {
        if (this.nG) {
            return mergeDrawableStates(super.onCreateDrawableState(nF.length + i), nF);
        }
        return super.onCreateDrawableState(i);
    }
}

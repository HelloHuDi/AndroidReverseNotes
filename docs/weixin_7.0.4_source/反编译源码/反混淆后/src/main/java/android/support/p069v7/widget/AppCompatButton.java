package android.support.p069v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.p057v4.view.C0474r;
import android.support.p057v4.widget.C0522b;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import com.tencent.p177mm.C25738R;

/* renamed from: android.support.v7.widget.AppCompatButton */
public class AppCompatButton extends Button implements C0474r, C0522b {
    private final C0713g afh;
    private final C0723n afi;

    public AppCompatButton(Context context) {
        this(context, null);
    }

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C25738R.attr.f5699g4);
    }

    public AppCompatButton(Context context, AttributeSet attributeSet, int i) {
        super(C0697az.m1552ad(context), attributeSet, i);
        this.afh = new C0713g(this);
        this.afh.mo2068a(attributeSet, i);
        this.afi = C0723n.m1629e(this);
        this.afi.mo2098a(attributeSet, i);
        this.afi.mo2099hI();
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.afh != null) {
            this.afh.mo2069bD(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.afh != null) {
            this.afh.mo2073hz();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.afh != null) {
            this.afh.setSupportBackgroundTintList(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.afh != null ? this.afh.getSupportBackgroundTintList() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.afh != null) {
            this.afh.setSupportBackgroundTintMode(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.afh != null ? this.afh.getSupportBackgroundTintMode() : null;
    }

    /* Access modifiers changed, original: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.afh != null) {
            this.afh.mo2072hA();
        }
        if (this.afi != null) {
            this.afi.mo2099hI();
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.afi != null) {
            this.afi.mo2101r(context, i);
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.afi != null) {
            this.afi.mo2100hJ();
        }
    }

    public void setTextSize(int i, float f) {
        if (f699OV) {
            super.setTextSize(i, f);
        } else if (this.afi != null) {
            this.afi.setTextSize(i, f);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (this.afi != null && !f699OV && this.afi.agt.mo2112hO()) {
            this.afi.agt.mo2111hM();
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (f699OV) {
            super.setAutoSizeTextTypeWithDefaults(i);
        } else if (this.afi != null) {
            this.afi.setAutoSizeTextTypeWithDefaults(i);
        }
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (f699OV) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
        } else if (this.afi != null) {
            this.afi.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (f699OV) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
        } else if (this.afi != null) {
            this.afi.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
        }
    }

    public int getAutoSizeTextType() {
        if (f699OV) {
            if (super.getAutoSizeTextType() == 1) {
                return 1;
            }
            return 0;
        } else if (this.afi != null) {
            return this.afi.agt.agC;
        } else {
            return 0;
        }
    }

    public int getAutoSizeStepGranularity() {
        if (f699OV) {
            return super.getAutoSizeStepGranularity();
        }
        return this.afi != null ? Math.round(this.afi.agt.agE) : -1;
    }

    public int getAutoSizeMinTextSize() {
        if (f699OV) {
            return super.getAutoSizeMinTextSize();
        }
        return this.afi != null ? Math.round(this.afi.agt.agF) : -1;
    }

    public int getAutoSizeMaxTextSize() {
        if (f699OV) {
            return super.getAutoSizeMaxTextSize();
        }
        return this.afi != null ? Math.round(this.afi.agt.agG) : -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (f699OV) {
            return super.getAutoSizeTextAvailableSizes();
        }
        if (this.afi != null) {
            return this.afi.agt.agH;
        }
        return new int[0];
    }

    public void setSupportAllCaps(boolean z) {
        if (this.afi != null) {
            this.afi.setAllCaps(z);
        }
    }
}

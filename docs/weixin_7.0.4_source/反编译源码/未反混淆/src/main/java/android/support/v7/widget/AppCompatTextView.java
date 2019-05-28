package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.r;
import android.support.v4.widget.b;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;

public class AppCompatTextView extends TextView implements r, b {
    private final g afh;
    private final n afi;

    public AppCompatTextView(Context context) {
        this(context, null);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet, int i) {
        super(az.ad(context), attributeSet, i);
        this.afh = new g(this);
        this.afh.a(attributeSet, i);
        this.afi = n.e(this);
        this.afi.a(attributeSet, i);
        this.afi.hI();
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.afh != null) {
            this.afh.bD(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.afh != null) {
            this.afh.hz();
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

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.afi != null) {
            this.afi.r(context, i);
        }
    }

    /* Access modifiers changed, original: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.afh != null) {
            this.afh.hA();
        }
        if (this.afi != null) {
            this.afi.hI();
        }
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.afi != null) {
            this.afi.hJ();
        }
    }

    public void setTextSize(int i, float f) {
        if (OV) {
            super.setTextSize(i, f);
        } else if (this.afi != null) {
            this.afi.setTextSize(i, f);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (this.afi != null && !OV && this.afi.agt.hO()) {
            this.afi.agt.hM();
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (OV) {
            super.setAutoSizeTextTypeWithDefaults(i);
        } else if (this.afi != null) {
            this.afi.setAutoSizeTextTypeWithDefaults(i);
        }
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (OV) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
        } else if (this.afi != null) {
            this.afi.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (OV) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
        } else if (this.afi != null) {
            this.afi.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
        }
    }

    public int getAutoSizeTextType() {
        if (OV) {
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
        if (OV) {
            return super.getAutoSizeStepGranularity();
        }
        return this.afi != null ? Math.round(this.afi.agt.agE) : -1;
    }

    public int getAutoSizeMinTextSize() {
        if (OV) {
            return super.getAutoSizeMinTextSize();
        }
        return this.afi != null ? Math.round(this.afi.agt.agF) : -1;
    }

    public int getAutoSizeMaxTextSize() {
        if (OV) {
            return super.getAutoSizeMaxTextSize();
        }
        return this.afi != null ? Math.round(this.afi.agt.agG) : -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (OV) {
            return super.getAutoSizeTextAvailableSizes();
        }
        if (this.afi != null) {
            return this.afi.agt.agH;
        }
        return new int[0];
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return j.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }
}

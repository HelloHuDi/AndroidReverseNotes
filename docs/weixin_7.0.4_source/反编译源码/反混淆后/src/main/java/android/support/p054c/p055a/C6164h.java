package android.support.p054c.p055a;

import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.p057v4.p058a.p059a.C0280a;
import android.support.p057v4.p058a.p059a.C0281e;

/* renamed from: android.support.c.a.h */
abstract class C6164h extends Drawable implements C0281e {
    /* renamed from: uJ */
    Drawable f1703uJ;

    C6164h() {
    }

    public void setColorFilter(int i, Mode mode) {
        if (this.f1703uJ != null) {
            this.f1703uJ.setColorFilter(i, mode);
        } else {
            super.setColorFilter(i, mode);
        }
    }

    public ColorFilter getColorFilter() {
        if (this.f1703uJ == null) {
            return null;
        }
        Drawable drawable = this.f1703uJ;
        if (VERSION.SDK_INT >= 21) {
            return drawable.getColorFilter();
        }
        return null;
    }

    /* Access modifiers changed, original: protected */
    public boolean onLevelChange(int i) {
        if (this.f1703uJ != null) {
            return this.f1703uJ.setLevel(i);
        }
        return super.onLevelChange(i);
    }

    /* Access modifiers changed, original: protected */
    public void onBoundsChange(Rect rect) {
        if (this.f1703uJ != null) {
            this.f1703uJ.setBounds(rect);
        } else {
            super.onBoundsChange(rect);
        }
    }

    public void setHotspot(float f, float f2) {
        if (this.f1703uJ != null) {
            C0280a.m454a(this.f1703uJ, f, f2);
        }
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        if (this.f1703uJ != null) {
            C0280a.m456a(this.f1703uJ, i, i2, i3, i4);
        }
    }

    public void setFilterBitmap(boolean z) {
        if (this.f1703uJ != null) {
            this.f1703uJ.setFilterBitmap(z);
        }
    }

    public void jumpToCurrentState() {
        if (this.f1703uJ != null) {
            this.f1703uJ.jumpToCurrentState();
        }
    }

    public void applyTheme(Theme theme) {
        if (this.f1703uJ != null) {
            C0280a.m458a(this.f1703uJ, theme);
        }
    }

    public void clearColorFilter() {
        if (this.f1703uJ != null) {
            this.f1703uJ.clearColorFilter();
        } else {
            super.clearColorFilter();
        }
    }

    public Drawable getCurrent() {
        if (this.f1703uJ != null) {
            return this.f1703uJ.getCurrent();
        }
        return super.getCurrent();
    }

    public int getMinimumWidth() {
        if (this.f1703uJ != null) {
            return this.f1703uJ.getMinimumWidth();
        }
        return super.getMinimumWidth();
    }

    public int getMinimumHeight() {
        if (this.f1703uJ != null) {
            return this.f1703uJ.getMinimumHeight();
        }
        return super.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        if (this.f1703uJ != null) {
            return this.f1703uJ.getPadding(rect);
        }
        return super.getPadding(rect);
    }

    public int[] getState() {
        if (this.f1703uJ != null) {
            return this.f1703uJ.getState();
        }
        return super.getState();
    }

    public Region getTransparentRegion() {
        if (this.f1703uJ != null) {
            return this.f1703uJ.getTransparentRegion();
        }
        return super.getTransparentRegion();
    }

    public void setChangingConfigurations(int i) {
        if (this.f1703uJ != null) {
            this.f1703uJ.setChangingConfigurations(i);
        } else {
            super.setChangingConfigurations(i);
        }
    }

    public boolean setState(int[] iArr) {
        if (this.f1703uJ != null) {
            return this.f1703uJ.setState(iArr);
        }
        return super.setState(iArr);
    }
}

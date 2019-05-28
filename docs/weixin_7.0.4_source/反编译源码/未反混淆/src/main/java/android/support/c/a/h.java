package android.support.c.a;

import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.a.a.a;
import android.support.v4.a.a.e;

abstract class h extends Drawable implements e {
    Drawable uJ;

    h() {
    }

    public void setColorFilter(int i, Mode mode) {
        if (this.uJ != null) {
            this.uJ.setColorFilter(i, mode);
        } else {
            super.setColorFilter(i, mode);
        }
    }

    public ColorFilter getColorFilter() {
        if (this.uJ == null) {
            return null;
        }
        Drawable drawable = this.uJ;
        if (VERSION.SDK_INT >= 21) {
            return drawable.getColorFilter();
        }
        return null;
    }

    /* Access modifiers changed, original: protected */
    public boolean onLevelChange(int i) {
        if (this.uJ != null) {
            return this.uJ.setLevel(i);
        }
        return super.onLevelChange(i);
    }

    /* Access modifiers changed, original: protected */
    public void onBoundsChange(Rect rect) {
        if (this.uJ != null) {
            this.uJ.setBounds(rect);
        } else {
            super.onBoundsChange(rect);
        }
    }

    public void setHotspot(float f, float f2) {
        if (this.uJ != null) {
            a.a(this.uJ, f, f2);
        }
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        if (this.uJ != null) {
            a.a(this.uJ, i, i2, i3, i4);
        }
    }

    public void setFilterBitmap(boolean z) {
        if (this.uJ != null) {
            this.uJ.setFilterBitmap(z);
        }
    }

    public void jumpToCurrentState() {
        if (this.uJ != null) {
            this.uJ.jumpToCurrentState();
        }
    }

    public void applyTheme(Theme theme) {
        if (this.uJ != null) {
            a.a(this.uJ, theme);
        }
    }

    public void clearColorFilter() {
        if (this.uJ != null) {
            this.uJ.clearColorFilter();
        } else {
            super.clearColorFilter();
        }
    }

    public Drawable getCurrent() {
        if (this.uJ != null) {
            return this.uJ.getCurrent();
        }
        return super.getCurrent();
    }

    public int getMinimumWidth() {
        if (this.uJ != null) {
            return this.uJ.getMinimumWidth();
        }
        return super.getMinimumWidth();
    }

    public int getMinimumHeight() {
        if (this.uJ != null) {
            return this.uJ.getMinimumHeight();
        }
        return super.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        if (this.uJ != null) {
            return this.uJ.getPadding(rect);
        }
        return super.getPadding(rect);
    }

    public int[] getState() {
        if (this.uJ != null) {
            return this.uJ.getState();
        }
        return super.getState();
    }

    public Region getTransparentRegion() {
        if (this.uJ != null) {
            return this.uJ.getTransparentRegion();
        }
        return super.getTransparentRegion();
    }

    public void setChangingConfigurations(int i) {
        if (this.uJ != null) {
            this.uJ.setChangingConfigurations(i);
        } else {
            super.setChangingConfigurations(i);
        }
    }

    public boolean setState(int[] iArr) {
        if (this.uJ != null) {
            return this.uJ.setState(iArr);
        }
        return super.setState(iArr);
    }
}

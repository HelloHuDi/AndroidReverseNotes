package android.support.p069v7.p073d.p074a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.p057v4.p058a.p059a.C0280a;

/* renamed from: android.support.v7.d.a.a */
public class C0591a extends Drawable implements Callback {
    public Drawable mDrawable;

    public C0591a(Drawable drawable) {
        if (this.mDrawable != null) {
            this.mDrawable.setCallback(null);
        }
        this.mDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    public void draw(Canvas canvas) {
        this.mDrawable.draw(canvas);
    }

    /* Access modifiers changed, original: protected */
    public void onBoundsChange(Rect rect) {
        this.mDrawable.setBounds(rect);
    }

    public void setChangingConfigurations(int i) {
        this.mDrawable.setChangingConfigurations(i);
    }

    public int getChangingConfigurations() {
        return this.mDrawable.getChangingConfigurations();
    }

    public void setDither(boolean z) {
        this.mDrawable.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.mDrawable.setFilterBitmap(z);
    }

    public void setAlpha(int i) {
        this.mDrawable.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mDrawable.setColorFilter(colorFilter);
    }

    public boolean isStateful() {
        return this.mDrawable.isStateful();
    }

    public boolean setState(int[] iArr) {
        return this.mDrawable.setState(iArr);
    }

    public int[] getState() {
        return this.mDrawable.getState();
    }

    public void jumpToCurrentState() {
        this.mDrawable.jumpToCurrentState();
    }

    public Drawable getCurrent() {
        return this.mDrawable.getCurrent();
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.mDrawable.setVisible(z, z2);
    }

    public int getOpacity() {
        return this.mDrawable.getOpacity();
    }

    public Region getTransparentRegion() {
        return this.mDrawable.getTransparentRegion();
    }

    public int getIntrinsicWidth() {
        return this.mDrawable.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.mDrawable.getIntrinsicHeight();
    }

    public int getMinimumWidth() {
        return this.mDrawable.getMinimumWidth();
    }

    public int getMinimumHeight() {
        return this.mDrawable.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        return this.mDrawable.getPadding(rect);
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    /* Access modifiers changed, original: protected */
    public boolean onLevelChange(int i) {
        return this.mDrawable.setLevel(i);
    }

    public void setAutoMirrored(boolean z) {
        C0280a.m461a(this.mDrawable, z);
    }

    public boolean isAutoMirrored() {
        return C0280a.m462b(this.mDrawable);
    }

    public void setTint(int i) {
        C0280a.m455a(this.mDrawable, i);
    }

    public void setTintList(ColorStateList colorStateList) {
        C0280a.m457a(this.mDrawable, colorStateList);
    }

    public void setTintMode(Mode mode) {
        C0280a.m460a(this.mDrawable, mode);
    }

    public void setHotspot(float f, float f2) {
        C0280a.m454a(this.mDrawable, f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        C0280a.m456a(this.mDrawable, i, i2, i3, i4);
    }
}

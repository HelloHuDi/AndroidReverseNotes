package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.view.r;
import android.support.v4.widget.s;
import android.util.AttributeSet;
import android.widget.ImageView;

public class AppCompatImageView extends ImageView implements r, s {
    private final g afh;
    private final k qk;

    public AppCompatImageView(Context context) {
        this(context, null);
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet, int i) {
        super(az.ad(context), attributeSet, i);
        this.afh = new g(this);
        this.afh.a(attributeSet, i);
        this.qk = new k(this);
        this.qk.a(attributeSet, i);
    }

    public void setImageResource(int i) {
        if (this.qk != null) {
            this.qk.setImageResource(i);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.qk != null) {
            this.qk.hF();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.qk != null) {
            this.qk.hF();
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        if (this.qk != null) {
            this.qk.hF();
        }
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

    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.qk != null) {
            this.qk.setSupportImageTintList(colorStateList);
        }
    }

    public ColorStateList getSupportImageTintList() {
        return this.qk != null ? this.qk.getSupportImageTintList() : null;
    }

    public void setSupportImageTintMode(Mode mode) {
        if (this.qk != null) {
            this.qk.setSupportImageTintMode(mode);
        }
    }

    public Mode getSupportImageTintMode() {
        return this.qk != null ? this.qk.getSupportImageTintMode() : null;
    }

    /* Access modifiers changed, original: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.afh != null) {
            this.afh.hA();
        }
        if (this.qk != null) {
            this.qk.hF();
        }
    }

    public boolean hasOverlappingRendering() {
        return this.qk.hasOverlappingRendering() && super.hasOverlappingRendering();
    }
}

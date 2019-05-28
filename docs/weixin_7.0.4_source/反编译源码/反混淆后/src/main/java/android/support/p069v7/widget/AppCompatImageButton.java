package android.support.p069v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.p057v4.view.C0474r;
import android.support.p057v4.widget.C0549s;
import android.util.AttributeSet;
import android.widget.ImageButton;
import com.tencent.p177mm.C25738R;

/* renamed from: android.support.v7.widget.AppCompatImageButton */
public class AppCompatImageButton extends ImageButton implements C0474r, C0549s {
    private final C0713g afh;
    /* renamed from: qk */
    private final C0721k f1938qk;

    public AppCompatImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C25738R.attr.f5661f3);
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet, int i) {
        super(C0697az.m1552ad(context), attributeSet, i);
        this.afh = new C0713g(this);
        this.afh.mo2068a(attributeSet, i);
        this.f1938qk = new C0721k(this);
        this.f1938qk.mo2088a(attributeSet, i);
    }

    public void setImageResource(int i) {
        this.f1938qk.setImageResource(i);
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.f1938qk != null) {
            this.f1938qk.mo2091hF();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.f1938qk != null) {
            this.f1938qk.mo2091hF();
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        if (this.f1938qk != null) {
            this.f1938qk.mo2091hF();
        }
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

    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.f1938qk != null) {
            this.f1938qk.setSupportImageTintList(colorStateList);
        }
    }

    public ColorStateList getSupportImageTintList() {
        return this.f1938qk != null ? this.f1938qk.getSupportImageTintList() : null;
    }

    public void setSupportImageTintMode(Mode mode) {
        if (this.f1938qk != null) {
            this.f1938qk.setSupportImageTintMode(mode);
        }
    }

    public Mode getSupportImageTintMode() {
        return this.f1938qk != null ? this.f1938qk.getSupportImageTintMode() : null;
    }

    /* Access modifiers changed, original: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.afh != null) {
            this.afh.mo2072hA();
        }
        if (this.f1938qk != null) {
            this.f1938qk.mo2091hF();
        }
    }

    public boolean hasOverlappingRendering() {
        return this.f1938qk.hasOverlappingRendering() && super.hasOverlappingRendering();
    }
}

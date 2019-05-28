package android.support.p069v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.p069v7.p070a.C0555a.C0554a;
import android.support.p069v7.view.C0604b;
import android.support.p069v7.view.C0604b.C0603a;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;

/* renamed from: android.support.v7.app.ActionBar */
public abstract class ActionBar {

    /* renamed from: android.support.v7.app.ActionBar$LayoutParams */
    public static class LayoutParams extends MarginLayoutParams {
        public int gravity;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0554a.ActionBarLayout);
            this.gravity = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams() {
            super(-2, -2);
            this.gravity = 0;
            this.gravity = 8388627;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = 0;
            this.gravity = layoutParams.gravity;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = 0;
        }
    }

    @Deprecated
    /* renamed from: android.support.v7.app.ActionBar$a */
    public static abstract class C0556a {
        public abstract CharSequence getContentDescription();

        public abstract View getCustomView();

        public abstract Drawable getIcon();

        public abstract CharSequence getText();
    }

    /* renamed from: fa */
    public abstract void mo1337fa();

    /* renamed from: fb */
    public abstract void mo1338fb();

    /* renamed from: fc */
    public abstract void mo1339fc();

    /* renamed from: fd */
    public abstract void mo1340fd();

    public abstract View getCustomView();

    public abstract int getDisplayOptions();

    public abstract int getHeight();

    public abstract CharSequence getTitle();

    public abstract void hide();

    public abstract boolean isShowing();

    public abstract void setBackgroundDrawable(Drawable drawable);

    public abstract void setCustomView(int i);

    public abstract void setCustomView(View view);

    public abstract void setDisplayHomeAsUpEnabled(boolean z);

    public abstract void setDisplayOptions(int i);

    public abstract void setLogo(Drawable drawable);

    public abstract void show();

    public Context getThemedContext() {
        return null;
    }

    public void setHomeActionContentDescription(int i) {
    }

    /* renamed from: fe */
    public void mo1341fe() {
        throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
    }

    public void setElevation(float f) {
        if (f != 0.0f) {
            throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
        }
    }

    /* renamed from: K */
    public void mo1331K(boolean z) {
    }

    /* renamed from: L */
    public void mo1332L(boolean z) {
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    /* renamed from: M */
    public void mo1333M(boolean z) {
    }

    /* renamed from: a */
    public C0604b mo1334a(C0603a c0603a) {
        return null;
    }

    /* renamed from: ff */
    public boolean mo1342ff() {
        return false;
    }

    /* renamed from: fg */
    public boolean mo1343fg() {
        return false;
    }

    /* renamed from: fh */
    public boolean mo1344fh() {
        return false;
    }

    /* renamed from: b */
    public boolean mo1335b(KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean collapseActionView() {
        return false;
    }

    public void setWindowTitle(CharSequence charSequence) {
    }

    /* Access modifiers changed, original: 0000 */
    public void onDestroy() {
    }
}

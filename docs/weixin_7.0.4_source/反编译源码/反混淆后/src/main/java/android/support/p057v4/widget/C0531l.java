package android.support.p057v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.ImageView;

/* renamed from: android.support.v4.widget.l */
public final class C0531l {
    /* renamed from: QT */
    static final C0530b f705QT;

    /* renamed from: android.support.v4.widget.l$b */
    interface C0530b {
        /* renamed from: a */
        void mo1294a(ImageView imageView, ColorStateList colorStateList);

        /* renamed from: a */
        void mo1295a(ImageView imageView, Mode mode);

        /* renamed from: b */
        ColorStateList mo1296b(ImageView imageView);

        /* renamed from: c */
        Mode mo1297c(ImageView imageView);
    }

    /* renamed from: android.support.v4.widget.l$a */
    static class C0532a implements C0530b {
        C0532a() {
        }

        /* renamed from: b */
        public ColorStateList mo1296b(ImageView imageView) {
            return imageView instanceof C0549s ? ((C0549s) imageView).getSupportImageTintList() : null;
        }

        /* renamed from: a */
        public void mo1294a(ImageView imageView, ColorStateList colorStateList) {
            if (imageView instanceof C0549s) {
                ((C0549s) imageView).setSupportImageTintList(colorStateList);
            }
        }

        /* renamed from: a */
        public void mo1295a(ImageView imageView, Mode mode) {
            if (imageView instanceof C0549s) {
                ((C0549s) imageView).setSupportImageTintMode(mode);
            }
        }

        /* renamed from: c */
        public Mode mo1297c(ImageView imageView) {
            return imageView instanceof C0549s ? ((C0549s) imageView).getSupportImageTintMode() : null;
        }
    }

    /* renamed from: android.support.v4.widget.l$c */
    static class C0533c extends C0532a {
        C0533c() {
        }

        /* renamed from: b */
        public final ColorStateList mo1296b(ImageView imageView) {
            return imageView.getImageTintList();
        }

        /* renamed from: a */
        public final void mo1294a(ImageView imageView, ColorStateList colorStateList) {
            imageView.setImageTintList(colorStateList);
            if (VERSION.SDK_INT == 21) {
                Drawable drawable = imageView.getDrawable();
                Object obj = (imageView.getImageTintList() == null || imageView.getImageTintMode() == null) ? null : 1;
                if (drawable != null && obj != null) {
                    if (drawable.isStateful()) {
                        drawable.setState(imageView.getDrawableState());
                    }
                    imageView.setImageDrawable(drawable);
                }
            }
        }

        /* renamed from: a */
        public final void mo1295a(ImageView imageView, Mode mode) {
            imageView.setImageTintMode(mode);
            if (VERSION.SDK_INT == 21) {
                Drawable drawable = imageView.getDrawable();
                Object obj = (imageView.getImageTintList() == null || imageView.getImageTintMode() == null) ? null : 1;
                if (drawable != null && obj != null) {
                    if (drawable.isStateful()) {
                        drawable.setState(imageView.getDrawableState());
                    }
                    imageView.setImageDrawable(drawable);
                }
            }
        }

        /* renamed from: c */
        public final Mode mo1297c(ImageView imageView) {
            return imageView.getImageTintMode();
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f705QT = new C0533c();
        } else {
            f705QT = new C0532a();
        }
    }

    /* renamed from: b */
    public static ColorStateList m1144b(ImageView imageView) {
        return f705QT.mo1296b(imageView);
    }

    /* renamed from: a */
    public static void m1142a(ImageView imageView, ColorStateList colorStateList) {
        f705QT.mo1294a(imageView, colorStateList);
    }

    /* renamed from: c */
    public static Mode m1145c(ImageView imageView) {
        return f705QT.mo1297c(imageView);
    }

    /* renamed from: a */
    public static void m1143a(ImageView imageView, Mode mode) {
        f705QT.mo1295a(imageView, mode);
    }
}

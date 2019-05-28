package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.ImageView;

public final class l {
    static final b QT;

    interface b {
        void a(ImageView imageView, ColorStateList colorStateList);

        void a(ImageView imageView, Mode mode);

        ColorStateList b(ImageView imageView);

        Mode c(ImageView imageView);
    }

    static class a implements b {
        a() {
        }

        public ColorStateList b(ImageView imageView) {
            return imageView instanceof s ? ((s) imageView).getSupportImageTintList() : null;
        }

        public void a(ImageView imageView, ColorStateList colorStateList) {
            if (imageView instanceof s) {
                ((s) imageView).setSupportImageTintList(colorStateList);
            }
        }

        public void a(ImageView imageView, Mode mode) {
            if (imageView instanceof s) {
                ((s) imageView).setSupportImageTintMode(mode);
            }
        }

        public Mode c(ImageView imageView) {
            return imageView instanceof s ? ((s) imageView).getSupportImageTintMode() : null;
        }
    }

    static class c extends a {
        c() {
        }

        public final ColorStateList b(ImageView imageView) {
            return imageView.getImageTintList();
        }

        public final void a(ImageView imageView, ColorStateList colorStateList) {
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

        public final void a(ImageView imageView, Mode mode) {
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

        public final Mode c(ImageView imageView) {
            return imageView.getImageTintMode();
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            QT = new c();
        } else {
            QT = new a();
        }
    }

    public static ColorStateList b(ImageView imageView) {
        return QT.b(imageView);
    }

    public static void a(ImageView imageView, ColorStateList colorStateList) {
        QT.a(imageView, colorStateList);
    }

    public static Mode c(ImageView imageView) {
        return QT.c(imageView);
    }

    public static void a(ImageView imageView, Mode mode) {
        QT.a(imageView, mode);
    }
}

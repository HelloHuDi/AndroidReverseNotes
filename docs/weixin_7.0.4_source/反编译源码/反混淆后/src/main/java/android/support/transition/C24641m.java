package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Matrix;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

/* renamed from: android.support.transition.m */
final class C24641m implements C17421o {
    C24641m() {
    }

    /* renamed from: a */
    public final void mo31655a(ImageView imageView) {
        ScaleType scaleType = imageView.getScaleType();
        imageView.setTag(2131820664, scaleType);
        if (scaleType == ScaleType.MATRIX) {
            imageView.setTag(2131820662, imageView.getImageMatrix());
        } else {
            imageView.setScaleType(ScaleType.MATRIX);
        }
        imageView.setImageMatrix(C17422p.f3874vt);
    }

    /* renamed from: a */
    public final void mo31657a(ImageView imageView, Matrix matrix) {
        imageView.setImageMatrix(matrix);
    }

    /* renamed from: a */
    public final void mo31656a(final ImageView imageView, Animator animator) {
        animator.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                ScaleType scaleType = (ScaleType) imageView.getTag(2131820664);
                imageView.setScaleType(scaleType);
                imageView.setTag(2131820664, null);
                if (scaleType == ScaleType.MATRIX) {
                    imageView.setImageMatrix((Matrix) imageView.getTag(2131820662));
                    imageView.setTag(2131820662, null);
                }
                animator.removeListener(this);
            }
        });
    }
}

package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Matrix;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.R;

final class m implements o {
    m() {
    }

    public final void a(ImageView imageView) {
        ScaleType scaleType = imageView.getScaleType();
        imageView.setTag(R.id.cj, scaleType);
        if (scaleType == ScaleType.MATRIX) {
            imageView.setTag(R.id.ch, imageView.getImageMatrix());
        } else {
            imageView.setScaleType(ScaleType.MATRIX);
        }
        imageView.setImageMatrix(p.vt);
    }

    public final void a(ImageView imageView, Matrix matrix) {
        imageView.setImageMatrix(matrix);
    }

    public final void a(final ImageView imageView, Animator animator) {
        animator.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                ScaleType scaleType = (ScaleType) imageView.getTag(R.id.cj);
                imageView.setScaleType(scaleType);
                imageView.setTag(R.id.cj, null);
                if (scaleType == ScaleType.MATRIX) {
                    imageView.setImageMatrix((Matrix) imageView.getTag(R.id.ch));
                    imageView.setTag(R.id.ch, null);
                }
                animator.removeListener(this);
            }
        });
    }
}

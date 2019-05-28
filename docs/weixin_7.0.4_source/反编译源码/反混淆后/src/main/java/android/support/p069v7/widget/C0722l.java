package android.support.p069v7.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.support.p057v4.p058a.p059a.C0282f;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

/* renamed from: android.support.v7.widget.l */
class C0722l {
    private static final int[] aaV = new int[]{16843067, 16843068};
    private final ProgressBar afQ;
    Bitmap afR;

    C0722l(ProgressBar progressBar) {
        this.afQ = progressBar;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo2096a(AttributeSet attributeSet, int i) {
        C0699bc a = C0699bc.m1555a(this.afQ.getContext(), attributeSet, aaV, i, 0);
        Drawable cW = a.mo2029cW(0);
        if (cW != null) {
            ProgressBar progressBar = this.afQ;
            if (cW instanceof AnimationDrawable) {
                AnimationDrawable animationDrawable = (AnimationDrawable) cW;
                int numberOfFrames = animationDrawable.getNumberOfFrames();
                Drawable animationDrawable2 = new AnimationDrawable();
                animationDrawable2.setOneShot(animationDrawable.isOneShot());
                for (int i2 = 0; i2 < numberOfFrames; i2++) {
                    Drawable b = m1625b(animationDrawable.getFrame(i2), true);
                    b.setLevel(Downloads.MIN_WAIT_FOR_NETWORK);
                    animationDrawable2.addFrame(b, animationDrawable.getDuration(i2));
                }
                animationDrawable2.setLevel(Downloads.MIN_WAIT_FOR_NETWORK);
                cW = animationDrawable2;
            }
            progressBar.setIndeterminateDrawable(cW);
        }
        cW = a.mo2029cW(1);
        if (cW != null) {
            this.afQ.setProgressDrawable(m1625b(cW, false));
        }
        a.atG.recycle();
    }

    /* renamed from: b */
    private Drawable m1625b(Drawable drawable, boolean z) {
        int i = 0;
        Drawable dC;
        if (drawable instanceof C0282f) {
            dC = ((C0282f) drawable).mo459dC();
            if (dC == null) {
                return drawable;
            }
            ((C0282f) drawable).mo460h(m1625b(dC, z));
            return drawable;
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[numberOfLayers];
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                boolean z2;
                int id = layerDrawable.getId(i2);
                Drawable drawable2 = layerDrawable.getDrawable(i2);
                if (id == 16908301 || id == 16908303) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                drawableArr[i2] = m1625b(drawable2, z2);
            }
            dC = new LayerDrawable(drawableArr);
            while (i < numberOfLayers) {
                dC.setId(i, layerDrawable.getId(i));
                i++;
            }
            return dC;
        } else if (!(drawable instanceof BitmapDrawable)) {
            return drawable;
        } else {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (this.afR == null) {
                this.afR = bitmap;
            }
            dC = new ShapeDrawable(new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null));
            dC.getPaint().setShader(new BitmapShader(bitmap, TileMode.REPEAT, TileMode.CLAMP));
            dC.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            return z ? new ClipDrawable(dC, 3, 1) : dC;
        }
    }
}

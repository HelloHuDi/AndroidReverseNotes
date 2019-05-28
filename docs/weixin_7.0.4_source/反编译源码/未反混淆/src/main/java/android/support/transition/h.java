package android.support.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.support.v4.view.s;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout;
import com.tencent.mm.R;

@SuppressLint({"ViewConstructor"})
final class h extends View implements j {
    private final Matrix mMatrix = new Matrix();
    final View mView;
    ViewGroup yE;
    View yF;
    int yG;
    private int yH;
    private int yI;
    Matrix yJ;
    private final OnPreDrawListener yL = new OnPreDrawListener() {
        public final boolean onPreDraw() {
            h.this.yJ = h.this.mView.getMatrix();
            s.R(h.this);
            if (!(h.this.yE == null || h.this.yF == null)) {
                h.this.yE.endViewTransition(h.this.yF);
                s.R(h.this.yE);
                h.this.yE = null;
                h.this.yF = null;
            }
            return true;
        }
    };

    static class a implements android.support.transition.j.a {
        a() {
        }

        public final j a(View view, ViewGroup viewGroup, Matrix matrix) {
            j z = h.z(view);
            if (z == null) {
                FrameLayout frameLayout;
                ViewGroup viewGroup2 = viewGroup;
                while (!(viewGroup2 instanceof FrameLayout)) {
                    ViewParent parent = viewGroup2.getParent();
                    if (!(parent instanceof ViewGroup)) {
                        frameLayout = null;
                        break;
                    }
                    viewGroup2 = (ViewGroup) parent;
                }
                frameLayout = (FrameLayout) viewGroup2;
                if (frameLayout == null) {
                    return null;
                }
                z = new h(view);
                frameLayout.addView(z);
            }
            z.yG++;
            return z;
        }

        public final void A(View view) {
            h z = h.z(view);
            if (z != null) {
                z.yG--;
                if (z.yG <= 0) {
                    ViewParent parent = z.getParent();
                    if (parent instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) parent;
                        viewGroup.endViewTransition(z);
                        viewGroup.removeView(z);
                    }
                }
            }
        }
    }

    h(View view) {
        super(view.getContext());
        this.mView = view;
        setLayerType(2, null);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mView.setTag(R.id.bi, this);
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        getLocationOnScreen(iArr);
        this.mView.getLocationOnScreen(iArr2);
        iArr2[0] = (int) (((float) iArr2[0]) - this.mView.getTranslationX());
        iArr2[1] = (int) (((float) iArr2[1]) - this.mView.getTranslationY());
        this.yH = iArr2[0] - iArr[0];
        this.yI = iArr2[1] - iArr[1];
        this.mView.getViewTreeObserver().addOnPreDrawListener(this.yL);
        this.mView.setVisibility(4);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDetachedFromWindow() {
        this.mView.getViewTreeObserver().removeOnPreDrawListener(this.yL);
        this.mView.setVisibility(0);
        this.mView.setTag(R.id.bi, null);
        super.onDetachedFromWindow();
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDraw(Canvas canvas) {
        this.mMatrix.set(this.yJ);
        this.mMatrix.postTranslate((float) this.yH, (float) this.yI);
        canvas.setMatrix(this.mMatrix);
        this.mView.draw(canvas);
    }

    public final void setVisibility(int i) {
        super.setVisibility(i);
        this.mView.setVisibility(i == 0 ? 4 : 0);
    }

    public final void a(ViewGroup viewGroup, View view) {
        this.yE = viewGroup;
        this.yF = view;
    }

    static h z(View view) {
        return (h) view.getTag(R.id.bi);
    }
}

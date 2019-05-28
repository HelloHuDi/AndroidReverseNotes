package android.support.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.support.p057v4.view.C0477s;
import android.support.transition.C37109j.C17420a;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout;

@SuppressLint({"ViewConstructor"})
/* renamed from: android.support.transition.h */
final class C17417h extends View implements C37109j {
    private final Matrix mMatrix = new Matrix();
    final View mView;
    /* renamed from: yE */
    ViewGroup f3866yE;
    /* renamed from: yF */
    View f3867yF;
    /* renamed from: yG */
    int f3868yG;
    /* renamed from: yH */
    private int f3869yH;
    /* renamed from: yI */
    private int f3870yI;
    /* renamed from: yJ */
    Matrix f3871yJ;
    /* renamed from: yL */
    private final OnPreDrawListener f3872yL = new C174181();

    /* renamed from: android.support.transition.h$1 */
    class C174181 implements OnPreDrawListener {
        C174181() {
        }

        public final boolean onPreDraw() {
            C17417h.this.f3871yJ = C17417h.this.mView.getMatrix();
            C0477s.m891R(C17417h.this);
            if (!(C17417h.this.f3866yE == null || C17417h.this.f3867yF == null)) {
                C17417h.this.f3866yE.endViewTransition(C17417h.this.f3867yF);
                C0477s.m891R(C17417h.this.f3866yE);
                C17417h.this.f3866yE = null;
                C17417h.this.f3867yF = null;
            }
            return true;
        }
    }

    /* renamed from: android.support.transition.h$a */
    static class C17419a implements C17420a {
        C17419a() {
        }

        /* renamed from: a */
        public final C37109j mo31654a(View view, ViewGroup viewGroup, Matrix matrix) {
            C37109j z = C17417h.m27056z(view);
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
                z = new C17417h(view);
                frameLayout.addView(z);
            }
            z.f3868yG++;
            return z;
        }

        /* renamed from: A */
        public final void mo31653A(View view) {
            C17417h z = C17417h.m27056z(view);
            if (z != null) {
                z.f3868yG--;
                if (z.f3868yG <= 0) {
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

    C17417h(View view) {
        super(view.getContext());
        this.mView = view;
        setLayerType(2, null);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mView.setTag(2131820626, this);
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        getLocationOnScreen(iArr);
        this.mView.getLocationOnScreen(iArr2);
        iArr2[0] = (int) (((float) iArr2[0]) - this.mView.getTranslationX());
        iArr2[1] = (int) (((float) iArr2[1]) - this.mView.getTranslationY());
        this.f3869yH = iArr2[0] - iArr[0];
        this.f3870yI = iArr2[1] - iArr[1];
        this.mView.getViewTreeObserver().addOnPreDrawListener(this.f3872yL);
        this.mView.setVisibility(4);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDetachedFromWindow() {
        this.mView.getViewTreeObserver().removeOnPreDrawListener(this.f3872yL);
        this.mView.setVisibility(0);
        this.mView.setTag(2131820626, null);
        super.onDetachedFromWindow();
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDraw(Canvas canvas) {
        this.mMatrix.set(this.f3871yJ);
        this.mMatrix.postTranslate((float) this.f3869yH, (float) this.f3870yI);
        canvas.setMatrix(this.mMatrix);
        this.mView.draw(canvas);
    }

    public final void setVisibility(int i) {
        super.setVisibility(i);
        this.mView.setVisibility(i == 0 ? 4 : 0);
    }

    /* renamed from: a */
    public final void mo31647a(ViewGroup viewGroup, View view) {
        this.f3866yE = viewGroup;
        this.f3867yF = view;
    }

    /* renamed from: z */
    static C17417h m27056z(View view) {
        return (C17417h) view.getTag(2131820626);
    }
}

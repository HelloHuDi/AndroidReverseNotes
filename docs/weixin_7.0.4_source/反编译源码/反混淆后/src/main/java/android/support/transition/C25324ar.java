package android.support.transition;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.p057v4.view.C0477s;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* renamed from: android.support.transition.ar */
class C25324ar implements C41494at {
    /* renamed from: Bb */
    protected C25325a f5134Bb;

    /* renamed from: android.support.transition.ar$a */
    static class C25325a extends ViewGroup {
        /* renamed from: Bc */
        static Method f5135Bc;
        /* renamed from: Bd */
        ViewGroup f5136Bd;
        /* renamed from: Be */
        View f5137Be;
        /* renamed from: Bf */
        ArrayList<Drawable> f5138Bf = null;
        /* renamed from: Bg */
        C25324ar f5139Bg;

        static {
            try {
                f5135Bc = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", new Class[]{Integer.TYPE, Integer.TYPE, Rect.class});
            } catch (NoSuchMethodException e) {
            }
        }

        C25325a(Context context, ViewGroup viewGroup, View view, C25324ar c25324ar) {
            super(context);
            this.f5136Bd = viewGroup;
            this.f5137Be = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.f5139Bg = c25324ar;
        }

        public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean verifyDrawable(Drawable drawable) {
            return super.verifyDrawable(drawable) || (this.f5138Bf != null && this.f5138Bf.contains(drawable));
        }

        public final void add(View view) {
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (!(viewGroup == this.f5136Bd || viewGroup.getParent() == null || !C0477s.m930av(viewGroup))) {
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    this.f5136Bd.getLocationOnScreen(iArr2);
                    C0477s.m952r(view, iArr[0] - iArr2[0]);
                    C0477s.m951q(view, iArr[1] - iArr2[1]);
                }
                viewGroup.removeView(view);
                if (view.getParent() != null) {
                    viewGroup.removeView(view);
                }
            }
            super.addView(view, getChildCount() - 1);
        }

        public final void remove(View view) {
            Object obj;
            super.removeView(view);
            if (getChildCount() == 0 && (this.f5138Bf == null || this.f5138Bf.size() == 0)) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                this.f5136Bd.removeView(this);
            }
        }

        public final void invalidateDrawable(Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        /* Access modifiers changed, original: protected|final */
        public final void dispatchDraw(Canvas canvas) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            this.f5136Bd.getLocationOnScreen(iArr);
            this.f5137Be.getLocationOnScreen(iArr2);
            canvas.translate((float) (iArr2[0] - iArr[0]), (float) (iArr2[1] - iArr[1]));
            canvas.clipRect(new Rect(0, 0, this.f5137Be.getWidth(), this.f5137Be.getHeight()));
            super.dispatchDraw(canvas);
            int size = this.f5138Bf == null ? 0 : this.f5138Bf.size();
            for (int i = 0; i < size; i++) {
                ((Drawable) this.f5138Bf.get(i)).draw(canvas);
            }
        }

        /* Access modifiers changed, original: protected|final */
        public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        }

        public final ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.f5136Bd != null) {
                rect.offset(iArr[0], iArr[1]);
                if (this.f5136Bd instanceof ViewGroup) {
                    iArr[0] = 0;
                    iArr[1] = 0;
                    int[] iArr2 = new int[2];
                    int[] iArr3 = new int[2];
                    int[] iArr4 = new int[2];
                    this.f5136Bd.getLocationOnScreen(iArr3);
                    this.f5137Be.getLocationOnScreen(iArr4);
                    iArr2[0] = iArr4[0] - iArr3[0];
                    iArr2[1] = iArr4[1] - iArr3[1];
                    rect.offset(iArr2[0], iArr2[1]);
                    return super.invalidateChildInParent(iArr, rect);
                }
                invalidate(rect);
            }
            return null;
        }
    }

    C25324ar(Context context, ViewGroup viewGroup, View view) {
        this.f5134Bb = new C25325a(context, viewGroup, view, this);
    }

    /* renamed from: H */
    private static ViewGroup m39950H(View view) {
        View view2 = view;
        while (view2 != null) {
            if (view2.getId() == 16908290 && (view2 instanceof ViewGroup)) {
                return (ViewGroup) view2;
            }
            if (view2.getParent() instanceof ViewGroup) {
                view2 = (ViewGroup) view2.getParent();
            }
        }
        return null;
    }

    /* renamed from: I */
    static C25324ar m39951I(View view) {
        ViewGroup H = C25324ar.m39950H(view);
        if (H == null) {
            return null;
        }
        int childCount = H.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = H.getChildAt(i);
            if (childAt instanceof C25325a) {
                return ((C25325a) childAt).f5139Bg;
            }
        }
        return new C41493ak(H.getContext(), H, view);
    }

    public final void add(Drawable drawable) {
        C25325a c25325a = this.f5134Bb;
        if (c25325a.f5138Bf == null) {
            c25325a.f5138Bf = new ArrayList();
        }
        if (!c25325a.f5138Bf.contains(drawable)) {
            c25325a.f5138Bf.add(drawable);
            c25325a.invalidate(drawable.getBounds());
            drawable.setCallback(c25325a);
        }
    }

    public final void remove(Drawable drawable) {
        C25325a c25325a = this.f5134Bb;
        if (c25325a.f5138Bf != null) {
            c25325a.f5138Bf.remove(drawable);
            c25325a.invalidate(drawable.getBounds());
            drawable.setCallback(null);
        }
    }
}

package android.support.transition;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.s;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.reflect.Method;
import java.util.ArrayList;

class ar implements at {
    protected a Bb;

    static class a extends ViewGroup {
        static Method Bc;
        ViewGroup Bd;
        View Be;
        ArrayList<Drawable> Bf = null;
        ar Bg;

        static {
            try {
                Bc = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", new Class[]{Integer.TYPE, Integer.TYPE, Rect.class});
            } catch (NoSuchMethodException e) {
            }
        }

        a(Context context, ViewGroup viewGroup, View view, ar arVar) {
            super(context);
            this.Bd = viewGroup;
            this.Be = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.Bg = arVar;
        }

        public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean verifyDrawable(Drawable drawable) {
            return super.verifyDrawable(drawable) || (this.Bf != null && this.Bf.contains(drawable));
        }

        public final void add(View view) {
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (!(viewGroup == this.Bd || viewGroup.getParent() == null || !s.av(viewGroup))) {
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    this.Bd.getLocationOnScreen(iArr2);
                    s.r(view, iArr[0] - iArr2[0]);
                    s.q(view, iArr[1] - iArr2[1]);
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
            if (getChildCount() == 0 && (this.Bf == null || this.Bf.size() == 0)) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                this.Bd.removeView(this);
            }
        }

        public final void invalidateDrawable(Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        /* Access modifiers changed, original: protected|final */
        public final void dispatchDraw(Canvas canvas) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            this.Bd.getLocationOnScreen(iArr);
            this.Be.getLocationOnScreen(iArr2);
            canvas.translate((float) (iArr2[0] - iArr[0]), (float) (iArr2[1] - iArr[1]));
            canvas.clipRect(new Rect(0, 0, this.Be.getWidth(), this.Be.getHeight()));
            super.dispatchDraw(canvas);
            int size = this.Bf == null ? 0 : this.Bf.size();
            for (int i = 0; i < size; i++) {
                ((Drawable) this.Bf.get(i)).draw(canvas);
            }
        }

        /* Access modifiers changed, original: protected|final */
        public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        }

        public final ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.Bd != null) {
                rect.offset(iArr[0], iArr[1]);
                if (this.Bd instanceof ViewGroup) {
                    iArr[0] = 0;
                    iArr[1] = 0;
                    int[] iArr2 = new int[2];
                    int[] iArr3 = new int[2];
                    int[] iArr4 = new int[2];
                    this.Bd.getLocationOnScreen(iArr3);
                    this.Be.getLocationOnScreen(iArr4);
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

    ar(Context context, ViewGroup viewGroup, View view) {
        this.Bb = new a(context, viewGroup, view, this);
    }

    private static ViewGroup H(View view) {
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

    static ar I(View view) {
        ViewGroup H = H(view);
        if (H == null) {
            return null;
        }
        int childCount = H.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = H.getChildAt(i);
            if (childAt instanceof a) {
                return ((a) childAt).Bg;
            }
        }
        return new ak(H.getContext(), H, view);
    }

    public final void add(Drawable drawable) {
        a aVar = this.Bb;
        if (aVar.Bf == null) {
            aVar.Bf = new ArrayList();
        }
        if (!aVar.Bf.contains(drawable)) {
            aVar.Bf.add(drawable);
            aVar.invalidate(drawable.getBounds());
            drawable.setCallback(aVar);
        }
    }

    public final void remove(Drawable drawable) {
        a aVar = this.Bb;
        if (aVar.Bf != null) {
            aVar.Bf.remove(drawable);
            aVar.invalidate(drawable.getBounds());
            drawable.setCallback(null);
        }
    }
}

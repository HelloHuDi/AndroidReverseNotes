package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.a.c;
import android.support.v4.view.s;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;

public class ChangeBounds extends Transition {
    private static final String[] xk = new String[]{"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    private static final Property<Drawable, PointF> xl = new Property<Drawable, PointF>(PointF.class, "boundsOrigin") {
        private Rect xv = new Rect();

        public final /* synthetic */ Object get(Object obj) {
            ((Drawable) obj).copyBounds(this.xv);
            return new PointF((float) this.xv.left, (float) this.xv.top);
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            Drawable drawable = (Drawable) obj;
            PointF pointF = (PointF) obj2;
            drawable.copyBounds(this.xv);
            this.xv.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.xv);
        }
    };
    private static final Property<a, PointF> xm = new Property<a, PointF>(PointF.class, "topLeft") {
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            return null;
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            a aVar = (a) obj;
            PointF pointF = (PointF) obj2;
            aVar.xJ = Math.round(pointF.x);
            aVar.xL = Math.round(pointF.y);
            aVar.xO++;
            if (aVar.xO == aVar.xP) {
                aVar.cQ();
            }
        }
    };
    private static final Property<a, PointF> xn = new Property<a, PointF>(PointF.class, "bottomRight") {
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            return null;
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            a aVar = (a) obj;
            PointF pointF = (PointF) obj2;
            aVar.xM = Math.round(pointF.x);
            aVar.xN = Math.round(pointF.y);
            aVar.xP++;
            if (aVar.xO == aVar.xP) {
                aVar.cQ();
            }
        }
    };
    private static final Property<View, PointF> xo = new Property<View, PointF>(PointF.class, "bottomRight") {
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            return null;
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            View view = (View) obj;
            PointF pointF = (PointF) obj2;
            au.b(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    };
    private static final Property<View, PointF> xp = new Property<View, PointF>(PointF.class, "topLeft") {
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            return null;
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            View view = (View) obj;
            PointF pointF = (PointF) obj2;
            au.b(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    };
    private static final Property<View, PointF> xq = new Property<View, PointF>(PointF.class, "position") {
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            return null;
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            View view = (View) obj;
            PointF pointF = (PointF) obj2;
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            au.b(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    };
    private static z xu = new z();
    private int[] xr;
    private boolean xs;
    private boolean xt;

    static class a {
        private View mView;
        int xJ;
        int xL;
        int xM;
        int xN;
        int xO;
        int xP;

        a(View view) {
            this.mView = view;
        }

        /* Access modifiers changed, original: final */
        public final void cQ() {
            au.b(this.mView, this.xJ, this.xL, this.xM, this.xN);
            this.xO = 0;
            this.xP = 0;
        }
    }

    public ChangeBounds() {
        this.xr = new int[2];
        this.xs = false;
        this.xt = false;
    }

    public ChangeBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.xr = new int[2];
        this.xs = false;
        this.xt = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ac.zz);
        boolean a = c.a(obtainStyledAttributes, (XmlResourceParser) attributeSet, "resizeClip", 0, false);
        obtainStyledAttributes.recycle();
        this.xs = a;
    }

    public final String[] getTransitionProperties() {
        return xk;
    }

    private void c(ah ahVar) {
        View view = ahVar.view;
        if (s.as(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            ahVar.values.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            ahVar.values.put("android:changeBounds:parent", ahVar.view.getParent());
            if (this.xt) {
                ahVar.view.getLocationInWindow(this.xr);
                ahVar.values.put("android:changeBounds:windowX", Integer.valueOf(this.xr[0]));
                ahVar.values.put("android:changeBounds:windowY", Integer.valueOf(this.xr[1]));
            }
            if (this.xs) {
                ahVar.values.put("android:changeBounds:clip", s.au(view));
            }
        }
    }

    public final void a(ah ahVar) {
        c(ahVar);
    }

    public final void b(ah ahVar) {
        c(ahVar);
    }

    public final Animator a(ViewGroup viewGroup, ah ahVar, ah ahVar2) {
        if (ahVar == null || ahVar2 == null) {
            return null;
        }
        ViewGroup viewGroup2 = (ViewGroup) ahVar.values.get("android:changeBounds:parent");
        View view = (ViewGroup) ahVar2.values.get("android:changeBounds:parent");
        if (viewGroup2 == null || view == null) {
            return null;
        }
        Object obj;
        int obj2;
        final View view2 = ahVar2.view;
        if (this.xt) {
            ah c = c(viewGroup2, true);
            obj2 = c == null ? viewGroup2 == view ? 1 : null : view == c.view ? 1 : null;
        } else {
            obj2 = 1;
        }
        final int i;
        int i2;
        Animator a;
        if (obj2 != null) {
            Rect rect = (Rect) ahVar.values.get("android:changeBounds:bounds");
            Rect rect2 = (Rect) ahVar2.values.get("android:changeBounds:bounds");
            int i3 = rect.left;
            i = rect2.left;
            int i4 = rect.top;
            final int i5 = rect2.top;
            int i6 = rect.right;
            final int i7 = rect2.right;
            int i8 = rect.bottom;
            final int i9 = rect2.bottom;
            int i10 = i6 - i3;
            int i11 = i8 - i4;
            int i12 = i7 - i;
            int i13 = i9 - i5;
            rect = (Rect) ahVar.values.get("android:changeBounds:clip");
            final Rect rect3 = (Rect) ahVar2.values.get("android:changeBounds:clip");
            i2 = 0;
            if (!((i10 == 0 || i11 == 0) && (i12 == 0 || i13 == 0))) {
                if (!(i3 == i && i4 == i5)) {
                    i2 = 1;
                }
                if (!(i6 == i7 && i8 == i9)) {
                    i2++;
                }
            }
            if (!(rect == null || rect.equals(rect3)) || (rect == null && rect3 != null)) {
                i2++;
            }
            if (i2 > 0) {
                Animator animator;
                if (this.xs) {
                    Animator animator2;
                    Rect rect4;
                    au.b(view2, i3, i4, Math.max(i10, i12) + i3, Math.max(i11, i13) + i4);
                    if (i3 == i && i4 == i5) {
                        animator2 = null;
                    } else {
                        animator2 = q.a(view2, xq, this.Ak.getPath((float) i3, (float) i4, (float) i, (float) i5));
                    }
                    if (rect == null) {
                        rect4 = new Rect(0, 0, i10, i11);
                    } else {
                        rect4 = rect;
                    }
                    if (rect3 == null) {
                        obj2 = new Rect(0, 0, i12, i13);
                    } else {
                        rect = rect3;
                    }
                    if (rect4.equals(obj2)) {
                        animator = null;
                    } else {
                        s.c(view2, rect4);
                        Animator ofObject = ObjectAnimator.ofObject(view2, "clipBounds", xu, new Object[]{rect4, obj2});
                        ofObject.addListener(new AnimatorListenerAdapter() {
                            private boolean mIsCanceled;

                            public final void onAnimationCancel(Animator animator) {
                                this.mIsCanceled = true;
                            }

                            public final void onAnimationEnd(Animator animator) {
                                if (!this.mIsCanceled) {
                                    s.c(view2, rect3);
                                    au.b(view2, i, i5, i7, i9);
                                }
                            }
                        });
                        animator = ofObject;
                    }
                    a = ag.a(animator2, animator);
                } else {
                    au.b(view2, i3, i4, i6, i8);
                    if (i2 == 2) {
                        if (i10 == i12 && i11 == i13) {
                            a = q.a(view2, xq, this.Ak.getPath((float) i3, (float) i4, (float) i, (float) i5));
                        } else {
                            final a aVar = new a(view2);
                            ObjectAnimator a2 = q.a(aVar, xm, this.Ak.getPath((float) i3, (float) i4, (float) i, (float) i5));
                            ObjectAnimator a3 = q.a(aVar, xn, this.Ak.getPath((float) i6, (float) i8, (float) i7, (float) i9));
                            animator = new AnimatorSet();
                            animator.playTogether(new Animator[]{a2, a3});
                            animator.addListener(new AnimatorListenerAdapter() {
                                private a xA = aVar;
                            });
                            a = animator;
                        }
                    } else if (i3 == i && i4 == i5) {
                        a = q.a(view2, xo, this.Ak.getPath((float) i6, (float) i8, (float) i7, (float) i9));
                    } else {
                        a = q.a(view2, xp, this.Ak.getPath((float) i3, (float) i4, (float) i, (float) i5));
                    }
                }
                if (!(view2.getParent() instanceof ViewGroup)) {
                    return a;
                }
                viewGroup2 = (ViewGroup) view2.getParent();
                an.c(viewGroup2, true);
                a((Transition.c) new ad() {
                    boolean xH = false;

                    public final void a(Transition transition) {
                        if (!this.xH) {
                            an.c(viewGroup2, false);
                        }
                        transition.b((Transition.c) this);
                    }

                    public final void cO() {
                        an.c(viewGroup2, false);
                    }

                    public final void cP() {
                        an.c(viewGroup2, true);
                    }
                });
                return a;
            }
        }
        i2 = ((Integer) ahVar.values.get("android:changeBounds:windowX")).intValue();
        int intValue = ((Integer) ahVar.values.get("android:changeBounds:windowY")).intValue();
        i = ((Integer) ahVar2.values.get("android:changeBounds:windowX")).intValue();
        obj2 = ((Integer) ahVar2.values.get("android:changeBounds:windowY")).intValue();
        if (!(i2 == i && intValue == obj2)) {
            viewGroup.getLocationInWindow(this.xr);
            Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Config.ARGB_8888);
            view2.draw(new Canvas(createBitmap));
            final BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
            final float L = au.L(view2);
            au.c(view2, 0.0f);
            au.J(viewGroup).add(bitmapDrawable);
            PropertyValuesHolder a4 = v.a(xl, this.Ak.getPath((float) (i2 - this.xr[0]), (float) (intValue - this.xr[1]), (float) (i - this.xr[0]), (float) (obj2 - this.xr[1])));
            a = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, new PropertyValuesHolder[]{a4});
            final ViewGroup viewGroup3 = viewGroup;
            final View view3 = view2;
            a.addListener(new AnimatorListenerAdapter() {
                public final void onAnimationEnd(Animator animator) {
                    au.J(viewGroup3).remove(bitmapDrawable);
                    au.c(view3, L);
                }
            });
            return a;
        }
        return null;
    }
}

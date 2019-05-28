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
import android.support.p057v4.content.p062a.C0379c;
import android.support.p057v4.view.C0477s;
import android.support.transition.Transition.C31852c;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;

public class ChangeBounds extends Transition {
    /* renamed from: xk */
    private static final String[] f3805xk = new String[]{"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    /* renamed from: xl */
    private static final Property<Drawable, PointF> f3806xl = new Property<Drawable, PointF>(PointF.class, "boundsOrigin") {
        /* renamed from: xv */
        private Rect f3822xv = new Rect();

        public final /* synthetic */ Object get(Object obj) {
            ((Drawable) obj).copyBounds(this.f3822xv);
            return new PointF((float) this.f3822xv.left, (float) this.f3822xv.top);
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            Drawable drawable = (Drawable) obj;
            PointF pointF = (PointF) obj2;
            drawable.copyBounds(this.f3822xv);
            this.f3822xv.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f3822xv);
        }
    };
    /* renamed from: xm */
    private static final Property<C17401a, PointF> f3807xm = new Property<C17401a, PointF>(PointF.class, "topLeft") {
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            return null;
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            C17401a c17401a = (C17401a) obj;
            PointF pointF = (PointF) obj2;
            c17401a.f3816xJ = Math.round(pointF.x);
            c17401a.f3817xL = Math.round(pointF.y);
            c17401a.f3820xO++;
            if (c17401a.f3820xO == c17401a.f3821xP) {
                c17401a.mo31621cQ();
            }
        }
    };
    /* renamed from: xn */
    private static final Property<C17401a, PointF> f3808xn = new Property<C17401a, PointF>(PointF.class, "bottomRight") {
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            return null;
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            C17401a c17401a = (C17401a) obj;
            PointF pointF = (PointF) obj2;
            c17401a.f3818xM = Math.round(pointF.x);
            c17401a.f3819xN = Math.round(pointF.y);
            c17401a.f3821xP++;
            if (c17401a.f3820xO == c17401a.f3821xP) {
                c17401a.mo31621cQ();
            }
        }
    };
    /* renamed from: xo */
    private static final Property<View, PointF> f3809xo = new Property<View, PointF>(PointF.class, "bottomRight") {
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            return null;
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            View view = (View) obj;
            PointF pointF = (PointF) obj2;
            C41495au.m72480b(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    };
    /* renamed from: xp */
    private static final Property<View, PointF> f3810xp = new Property<View, PointF>(PointF.class, "topLeft") {
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            return null;
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            View view = (View) obj;
            PointF pointF = (PointF) obj2;
            C41495au.m72480b(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    };
    /* renamed from: xq */
    private static final Property<View, PointF> f3811xq = new Property<View, PointF>(PointF.class, "position") {
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            return null;
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            View view = (View) obj;
            PointF pointF = (PointF) obj2;
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            C41495au.m72480b(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    };
    /* renamed from: xu */
    private static C37110z f3812xu = new C37110z();
    /* renamed from: xr */
    private int[] f3813xr;
    /* renamed from: xs */
    private boolean f3814xs;
    /* renamed from: xt */
    private boolean f3815xt;

    /* renamed from: android.support.transition.ChangeBounds$a */
    static class C17401a {
        private View mView;
        /* renamed from: xJ */
        int f3816xJ;
        /* renamed from: xL */
        int f3817xL;
        /* renamed from: xM */
        int f3818xM;
        /* renamed from: xN */
        int f3819xN;
        /* renamed from: xO */
        int f3820xO;
        /* renamed from: xP */
        int f3821xP;

        C17401a(View view) {
            this.mView = view;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: cQ */
        public final void mo31621cQ() {
            C41495au.m72480b(this.mView, this.f3816xJ, this.f3817xL, this.f3818xM, this.f3819xN);
            this.f3820xO = 0;
            this.f3821xP = 0;
        }
    }

    public ChangeBounds() {
        this.f3813xr = new int[2];
        this.f3814xs = false;
        this.f3815xt = false;
    }

    public ChangeBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3813xr = new int[2];
        this.f3814xs = false;
        this.f3815xt = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C37103ac.f15741zz);
        boolean a = C0379c.m640a(obtainStyledAttributes, (XmlResourceParser) attributeSet, "resizeClip", 0, false);
        obtainStyledAttributes.recycle();
        this.f3814xs = a;
    }

    public final String[] getTransitionProperties() {
        return f3805xk;
    }

    /* renamed from: c */
    private void m27021c(C8368ah c8368ah) {
        View view = c8368ah.view;
        if (C0477s.m927as(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            c8368ah.values.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            c8368ah.values.put("android:changeBounds:parent", c8368ah.view.getParent());
            if (this.f3815xt) {
                c8368ah.view.getLocationInWindow(this.f3813xr);
                c8368ah.values.put("android:changeBounds:windowX", Integer.valueOf(this.f3813xr[0]));
                c8368ah.values.put("android:changeBounds:windowY", Integer.valueOf(this.f3813xr[1]));
            }
            if (this.f3814xs) {
                c8368ah.values.put("android:changeBounds:clip", C0477s.m929au(view));
            }
        }
    }

    /* renamed from: a */
    public final void mo410a(C8368ah c8368ah) {
        m27021c(c8368ah);
    }

    /* renamed from: b */
    public final void mo411b(C8368ah c8368ah) {
        m27021c(c8368ah);
    }

    /* renamed from: a */
    public final Animator mo409a(ViewGroup viewGroup, C8368ah c8368ah, C8368ah c8368ah2) {
        if (c8368ah == null || c8368ah2 == null) {
            return null;
        }
        ViewGroup viewGroup2 = (ViewGroup) c8368ah.values.get("android:changeBounds:parent");
        View view = (ViewGroup) c8368ah2.values.get("android:changeBounds:parent");
        if (viewGroup2 == null || view == null) {
            return null;
        }
        Object obj;
        int obj2;
        final View view2 = c8368ah2.view;
        if (this.f3815xt) {
            C8368ah c = mo59143c(viewGroup2, true);
            obj2 = c == null ? viewGroup2 == view ? 1 : null : view == c.view ? 1 : null;
        } else {
            obj2 = 1;
        }
        final int i;
        int i2;
        Animator a;
        if (obj2 != null) {
            Rect rect = (Rect) c8368ah.values.get("android:changeBounds:bounds");
            Rect rect2 = (Rect) c8368ah2.values.get("android:changeBounds:bounds");
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
            rect = (Rect) c8368ah.values.get("android:changeBounds:clip");
            final Rect rect3 = (Rect) c8368ah2.values.get("android:changeBounds:clip");
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
                if (this.f3814xs) {
                    Animator animator2;
                    Rect rect4;
                    C41495au.m72480b(view2, i3, i4, Math.max(i10, i12) + i3, Math.max(i11, i13) + i4);
                    if (i3 == i && i4 == i5) {
                        animator2 = null;
                    } else {
                        animator2 = C17424q.m27066a(view2, f3811xq, this.f15707Ak.getPath((float) i3, (float) i4, (float) i, (float) i5));
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
                        C0477s.m937c(view2, rect4);
                        Animator ofObject = ObjectAnimator.ofObject(view2, "clipBounds", f3812xu, new Object[]{rect4, obj2});
                        ofObject.addListener(new AnimatorListenerAdapter() {
                            private boolean mIsCanceled;

                            public final void onAnimationCancel(Animator animator) {
                                this.mIsCanceled = true;
                            }

                            public final void onAnimationEnd(Animator animator) {
                                if (!this.mIsCanceled) {
                                    C0477s.m937c(view2, rect3);
                                    C41495au.m72480b(view2, i, i5, i7, i9);
                                }
                            }
                        });
                        animator = ofObject;
                    }
                    a = C25320ag.m39949a(animator2, animator);
                } else {
                    C41495au.m72480b(view2, i3, i4, i6, i8);
                    if (i2 == 2) {
                        if (i10 == i12 && i11 == i13) {
                            a = C17424q.m27066a(view2, f3811xq, this.f15707Ak.getPath((float) i3, (float) i4, (float) i, (float) i5));
                        } else {
                            final C17401a c17401a = new C17401a(view2);
                            ObjectAnimator a2 = C17424q.m27066a(c17401a, f3807xm, this.f15707Ak.getPath((float) i3, (float) i4, (float) i, (float) i5));
                            ObjectAnimator a3 = C17424q.m27066a(c17401a, f3808xn, this.f15707Ak.getPath((float) i6, (float) i8, (float) i7, (float) i9));
                            animator = new AnimatorSet();
                            animator.playTogether(new Animator[]{a2, a3});
                            animator.addListener(new AnimatorListenerAdapter() {
                                /* renamed from: xA */
                                private C17401a f3827xA = c17401a;
                            });
                            a = animator;
                        }
                    } else if (i3 == i && i4 == i5) {
                        a = C17424q.m27066a(view2, f3809xo, this.f15707Ak.getPath((float) i6, (float) i8, (float) i7, (float) i9));
                    } else {
                        a = C17424q.m27066a(view2, f3810xp, this.f15707Ak.getPath((float) i3, (float) i4, (float) i, (float) i5));
                    }
                }
                if (!(view2.getParent() instanceof ViewGroup)) {
                    return a;
                }
                viewGroup2 = (ViewGroup) view2.getParent();
                C44949an.m82225c(viewGroup2, true);
                mo42271a((C31852c) new C36668ad() {
                    /* renamed from: xH */
                    boolean f3836xH = false;

                    /* renamed from: a */
                    public final void mo452a(Transition transition) {
                        if (!this.f3836xH) {
                            C44949an.m82225c(viewGroup2, false);
                        }
                        transition.mo42277b((C31852c) this);
                    }

                    /* renamed from: cO */
                    public final void mo18279cO() {
                        C44949an.m82225c(viewGroup2, false);
                    }

                    /* renamed from: cP */
                    public final void mo18280cP() {
                        C44949an.m82225c(viewGroup2, true);
                    }
                });
                return a;
            }
        }
        i2 = ((Integer) c8368ah.values.get("android:changeBounds:windowX")).intValue();
        int intValue = ((Integer) c8368ah.values.get("android:changeBounds:windowY")).intValue();
        i = ((Integer) c8368ah2.values.get("android:changeBounds:windowX")).intValue();
        obj2 = ((Integer) c8368ah2.values.get("android:changeBounds:windowY")).intValue();
        if (!(i2 == i && intValue == obj2)) {
            viewGroup.getLocationInWindow(this.f3813xr);
            Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Config.ARGB_8888);
            view2.draw(new Canvas(createBitmap));
            final BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
            final float L = C41495au.m72476L(view2);
            C41495au.m72482c(view2, 0.0f);
            C41495au.m72474J(viewGroup).add(bitmapDrawable);
            PropertyValuesHolder a4 = C17425v.m27067a(f3806xl, this.f15707Ak.getPath((float) (i2 - this.f3813xr[0]), (float) (intValue - this.f3813xr[1]), (float) (i - this.f3813xr[0]), (float) (obj2 - this.f3813xr[1])));
            a = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, new PropertyValuesHolder[]{a4});
            final ViewGroup viewGroup3 = viewGroup;
            final View view3 = view2;
            a.addListener(new AnimatorListenerAdapter() {
                public final void onAnimationEnd(Animator animator) {
                    C41495au.m72474J(viewGroup3).remove(bitmapDrawable);
                    C41495au.m72482c(view3, L);
                }
            });
            return a;
        }
        return null;
    }
}

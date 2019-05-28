package android.support.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.p057v4.content.p062a.C0379c;
import android.support.p057v4.view.C0477s;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import org.xmlpull.v1.XmlPullParser;

public class Slide extends Visibility {
    /* renamed from: yp */
    private static final TimeInterpolator f2301yp = new DecelerateInterpolator();
    /* renamed from: yq */
    private static final TimeInterpolator f2302yq = new AccelerateInterpolator();
    /* renamed from: zp */
    private static final C8361a f2303zp = new C83591();
    /* renamed from: zq */
    private static final C8361a f2304zq = new C83582();
    /* renamed from: zr */
    private static final C8361a f2305zr = new C83573();
    /* renamed from: zt */
    private static final C8361a f2306zt = new C83604();
    /* renamed from: zu */
    private static final C8361a f2307zu = new C83645();
    /* renamed from: zv */
    private static final C8361a f2308zv = new C83656();
    /* renamed from: zn */
    private C8361a f2309zn = f2308zv;
    /* renamed from: zo */
    private int f2310zo = 80;

    /* renamed from: android.support.transition.Slide$3 */
    static class C83573 extends C8363c {
        C83573() {
            super();
        }

        /* renamed from: c */
        public final float mo18281c(ViewGroup viewGroup, View view) {
            return view.getTranslationY() - ((float) viewGroup.getHeight());
        }
    }

    /* renamed from: android.support.transition.Slide$2 */
    static class C83582 extends C8362b {
        C83582() {
            super();
        }

        /* renamed from: b */
        public final float mo18284b(ViewGroup viewGroup, View view) {
            Object obj = 1;
            if (C0477s.m893T(viewGroup) != 1) {
                obj = null;
            }
            if (obj != null) {
                return view.getTranslationX() + ((float) viewGroup.getWidth());
            }
            return view.getTranslationX() - ((float) viewGroup.getWidth());
        }
    }

    /* renamed from: android.support.transition.Slide$1 */
    static class C83591 extends C8362b {
        C83591() {
            super();
        }

        /* renamed from: b */
        public final float mo18284b(ViewGroup viewGroup, View view) {
            return view.getTranslationX() - ((float) viewGroup.getWidth());
        }
    }

    /* renamed from: android.support.transition.Slide$4 */
    static class C83604 extends C8362b {
        C83604() {
            super();
        }

        /* renamed from: b */
        public final float mo18284b(ViewGroup viewGroup, View view) {
            return view.getTranslationX() + ((float) viewGroup.getWidth());
        }
    }

    /* renamed from: android.support.transition.Slide$a */
    interface C8361a {
        /* renamed from: b */
        float mo18284b(ViewGroup viewGroup, View view);

        /* renamed from: c */
        float mo18281c(ViewGroup viewGroup, View view);
    }

    /* renamed from: android.support.transition.Slide$b */
    static abstract class C8362b implements C8361a {
        private C8362b() {
        }

        /* synthetic */ C8362b(byte b) {
            this();
        }

        /* renamed from: c */
        public final float mo18281c(ViewGroup viewGroup, View view) {
            return view.getTranslationY();
        }
    }

    /* renamed from: android.support.transition.Slide$c */
    static abstract class C8363c implements C8361a {
        private C8363c() {
        }

        /* synthetic */ C8363c(byte b) {
            this();
        }

        /* renamed from: b */
        public final float mo18284b(ViewGroup viewGroup, View view) {
            return view.getTranslationX();
        }
    }

    /* renamed from: android.support.transition.Slide$5 */
    static class C83645 extends C8362b {
        C83645() {
            super();
        }

        /* renamed from: b */
        public final float mo18284b(ViewGroup viewGroup, View view) {
            Object obj = 1;
            if (C0477s.m893T(viewGroup) != 1) {
                obj = null;
            }
            if (obj != null) {
                return view.getTranslationX() - ((float) viewGroup.getWidth());
            }
            return view.getTranslationX() + ((float) viewGroup.getWidth());
        }
    }

    /* renamed from: android.support.transition.Slide$6 */
    static class C83656 extends C8363c {
        C83656() {
            super();
        }

        /* renamed from: c */
        public final float mo18281c(ViewGroup viewGroup, View view) {
            return view.getTranslationY() + ((float) viewGroup.getHeight());
        }
    }

    public Slide() {
        setSlideEdge(80);
    }

    public Slide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C37103ac.f15734zD);
        int a = C0379c.m637a(obtainStyledAttributes, (XmlPullParser) attributeSet, "slideEdge", 0, 80);
        obtainStyledAttributes.recycle();
        setSlideEdge(a);
    }

    /* renamed from: c */
    private static void m14759c(C8368ah c8368ah) {
        int[] iArr = new int[2];
        c8368ah.view.getLocationOnScreen(iArr);
        c8368ah.values.put("android:slide:screenPosition", iArr);
    }

    /* renamed from: a */
    public final void mo410a(C8368ah c8368ah) {
        super.mo410a(c8368ah);
        m14759c(c8368ah);
    }

    /* renamed from: b */
    public final void mo411b(C8368ah c8368ah) {
        super.mo411b(c8368ah);
        m14759c(c8368ah);
    }

    private void setSlideEdge(int i) {
        switch (i) {
            case 3:
                this.f2309zn = f2303zp;
                break;
            case 5:
                this.f2309zn = f2306zt;
                break;
            case 48:
                this.f2309zn = f2305zr;
                break;
            case 80:
                this.f2309zn = f2308zv;
                break;
            case 8388611:
                this.f2309zn = f2304zq;
                break;
            case 8388613:
                this.f2309zn = f2307zu;
                break;
            default:
                throw new IllegalArgumentException("Invalid slide direction");
        }
        this.f2310zo = i;
        C16502ab c16502ab = new C16502ab();
        c16502ab.f3506zm = i;
        mo42273a((C37104af) c16502ab);
    }

    /* renamed from: a */
    public final Animator mo18283a(ViewGroup viewGroup, View view, C8368ah c8368ah, C8368ah c8368ah2) {
        if (c8368ah2 == null) {
            return null;
        }
        int[] iArr = (int[]) c8368ah2.values.get("android:slide:screenPosition");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        return C8369aj.m14773a(view, c8368ah2, iArr[0], iArr[1], this.f2309zn.mo18284b(viewGroup, view), this.f2309zn.mo18281c(viewGroup, view), translationX, translationY, f2301yp);
    }

    /* renamed from: a */
    public final Animator mo18282a(ViewGroup viewGroup, View view, C8368ah c8368ah) {
        if (c8368ah == null) {
            return null;
        }
        int[] iArr = (int[]) c8368ah.values.get("android:slide:screenPosition");
        return C8369aj.m14773a(view, c8368ah, iArr[0], iArr[1], view.getTranslationX(), view.getTranslationY(), this.f2309zn.mo18284b(viewGroup, view), this.f2309zn.mo18281c(viewGroup, view), f2302yq);
    }
}

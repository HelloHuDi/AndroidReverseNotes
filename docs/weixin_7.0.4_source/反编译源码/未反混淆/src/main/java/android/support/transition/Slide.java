package android.support.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.s;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import org.xmlpull.v1.XmlPullParser;

public class Slide extends Visibility {
    private static final TimeInterpolator yp = new DecelerateInterpolator();
    private static final TimeInterpolator yq = new AccelerateInterpolator();
    private static final a zp = new b() {
        public final float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX() - ((float) viewGroup.getWidth());
        }
    };
    private static final a zq = new b() {
        public final float b(ViewGroup viewGroup, View view) {
            Object obj = 1;
            if (s.T(viewGroup) != 1) {
                obj = null;
            }
            if (obj != null) {
                return view.getTranslationX() + ((float) viewGroup.getWidth());
            }
            return view.getTranslationX() - ((float) viewGroup.getWidth());
        }
    };
    private static final a zr = new c() {
        public final float c(ViewGroup viewGroup, View view) {
            return view.getTranslationY() - ((float) viewGroup.getHeight());
        }
    };
    private static final a zt = new b() {
        public final float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX() + ((float) viewGroup.getWidth());
        }
    };
    private static final a zu = new b() {
        public final float b(ViewGroup viewGroup, View view) {
            Object obj = 1;
            if (s.T(viewGroup) != 1) {
                obj = null;
            }
            if (obj != null) {
                return view.getTranslationX() - ((float) viewGroup.getWidth());
            }
            return view.getTranslationX() + ((float) viewGroup.getWidth());
        }
    };
    private static final a zv = new c() {
        public final float c(ViewGroup viewGroup, View view) {
            return view.getTranslationY() + ((float) viewGroup.getHeight());
        }
    };
    private a zn = zv;
    private int zo = 80;

    interface a {
        float b(ViewGroup viewGroup, View view);

        float c(ViewGroup viewGroup, View view);
    }

    static abstract class b implements a {
        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public final float c(ViewGroup viewGroup, View view) {
            return view.getTranslationY();
        }
    }

    static abstract class c implements a {
        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }

        public final float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX();
        }
    }

    public Slide() {
        setSlideEdge(80);
    }

    public Slide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ac.zD);
        int a = android.support.v4.content.a.c.a(obtainStyledAttributes, (XmlPullParser) attributeSet, "slideEdge", 0, 80);
        obtainStyledAttributes.recycle();
        setSlideEdge(a);
    }

    private static void c(ah ahVar) {
        int[] iArr = new int[2];
        ahVar.view.getLocationOnScreen(iArr);
        ahVar.values.put("android:slide:screenPosition", iArr);
    }

    public final void a(ah ahVar) {
        super.a(ahVar);
        c(ahVar);
    }

    public final void b(ah ahVar) {
        super.b(ahVar);
        c(ahVar);
    }

    private void setSlideEdge(int i) {
        switch (i) {
            case 3:
                this.zn = zp;
                break;
            case 5:
                this.zn = zt;
                break;
            case 48:
                this.zn = zr;
                break;
            case 80:
                this.zn = zv;
                break;
            case 8388611:
                this.zn = zq;
                break;
            case 8388613:
                this.zn = zu;
                break;
            default:
                throw new IllegalArgumentException("Invalid slide direction");
        }
        this.zo = i;
        ab abVar = new ab();
        abVar.zm = i;
        a((af) abVar);
    }

    public final Animator a(ViewGroup viewGroup, View view, ah ahVar, ah ahVar2) {
        if (ahVar2 == null) {
            return null;
        }
        int[] iArr = (int[]) ahVar2.values.get("android:slide:screenPosition");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        return aj.a(view, ahVar2, iArr[0], iArr[1], this.zn.b(viewGroup, view), this.zn.c(viewGroup, view), translationX, translationY, yp);
    }

    public final Animator a(ViewGroup viewGroup, View view, ah ahVar) {
        if (ahVar == null) {
            return null;
        }
        int[] iArr = (int[]) ahVar.values.get("android:slide:screenPosition");
        return aj.a(view, ahVar, iArr[0], iArr[1], view.getTranslationX(), view.getTranslationY(), this.zn.b(viewGroup, view), this.zn.c(viewGroup, view), yq);
    }
}

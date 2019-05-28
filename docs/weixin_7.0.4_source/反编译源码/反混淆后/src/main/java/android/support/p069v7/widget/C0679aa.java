package android.support.p069v7.widget;

import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build.VERSION;
import android.support.p057v4.p058a.p059a.C0282f;
import android.support.p069v7.p073d.p074a.C0591a;
import java.lang.reflect.Field;

/* renamed from: android.support.v7.widget.aa */
public final class C0679aa {
    public static final Rect ahT = new Rect();
    private static Class<?> ahU;

    static {
        if (VERSION.SDK_INT >= 18) {
            try {
                ahU = Class.forName("android.graphics.Insets");
            } catch (ClassNotFoundException e) {
            }
        }
    }

    /* renamed from: m */
    public static Rect m1529m(Drawable drawable) {
        if (ahU != null) {
            try {
                Object drawable2;
                if (drawable2 instanceof C0282f) {
                    drawable2 = ((C0282f) drawable2).mo459dC();
                }
                Object invoke = drawable2.getClass().getMethod("getOpticalInsets", new Class[0]).invoke(drawable2, new Object[0]);
                if (invoke != null) {
                    Rect rect = new Rect();
                    for (Field field : ahU.getFields()) {
                        String name = field.getName();
                        Object obj = -1;
                        switch (name.hashCode()) {
                            case -1383228885:
                                if (name.equals("bottom")) {
                                    obj = 3;
                                    break;
                                }
                                break;
                            case 115029:
                                if (name.equals("top")) {
                                    obj = 1;
                                    break;
                                }
                                break;
                            case 3317767:
                                if (name.equals("left")) {
                                    obj = null;
                                    break;
                                }
                                break;
                            case 108511772:
                                if (name.equals("right")) {
                                    obj = 2;
                                    break;
                                }
                                break;
                        }
                        switch (obj) {
                            case null:
                                rect.left = field.getInt(invoke);
                                break;
                            case 1:
                                rect.top = field.getInt(invoke);
                                break;
                            case 2:
                                rect.right = field.getInt(invoke);
                                break;
                            case 3:
                                rect.bottom = field.getInt(invoke);
                                break;
                            default:
                                break;
                        }
                    }
                    return rect;
                }
            } catch (Exception e) {
            }
        }
        return ahT;
    }

    /* renamed from: n */
    static void m1530n(Drawable drawable) {
        if (VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            int[] state = drawable.getState();
            if (state == null || state.length == 0) {
                drawable.setState(C0696ay.f1017kO);
            } else {
                drawable.setState(C0696ay.EMPTY_STATE_SET);
            }
            drawable.setState(state);
        }
    }

    /* renamed from: o */
    public static boolean m1531o(Drawable drawable) {
        Drawable drawable2 = drawable;
        while (true) {
            if (VERSION.SDK_INT < 15 && (drawable2 instanceof InsetDrawable)) {
                return false;
            }
            if (VERSION.SDK_INT < 15 && (drawable2 instanceof GradientDrawable)) {
                return false;
            }
            if (VERSION.SDK_INT >= 17 || !(drawable2 instanceof LayerDrawable)) {
                if (!(drawable2 instanceof DrawableContainer)) {
                    if (!(drawable2 instanceof C0282f)) {
                        if (!(drawable2 instanceof C0591a)) {
                            if (!(drawable2 instanceof ScaleDrawable)) {
                                break;
                            }
                            drawable2 = ((ScaleDrawable) drawable2).getDrawable();
                        } else {
                            drawable2 = ((C0591a) drawable2).mDrawable;
                        }
                    } else {
                        drawable2 = ((C0282f) drawable2).mo459dC();
                    }
                } else {
                    ConstantState constantState = drawable2.getConstantState();
                    if (constantState instanceof DrawableContainerState) {
                        for (Drawable o : ((DrawableContainerState) constantState).getChildren()) {
                            if (!C0679aa.m1531o(o)) {
                                return false;
                            }
                        }
                    }
                }
            } else {
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    public static Mode m1528d(int i, Mode mode) {
        switch (i) {
            case 3:
                return Mode.SRC_OVER;
            case 5:
                return Mode.SRC_IN;
            case 9:
                return Mode.SRC_ATOP;
            case 14:
                return Mode.MULTIPLY;
            case 15:
                return Mode.SCREEN;
            case 16:
                return Mode.ADD;
            default:
                return mode;
        }
    }
}

package android.support.v7.widget;

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
import android.support.v4.a.a.f;
import android.support.v7.d.a.a;
import java.lang.reflect.Field;

public final class aa {
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

    public static Rect m(Drawable drawable) {
        if (ahU != null) {
            try {
                Object drawable2;
                if (drawable2 instanceof f) {
                    drawable2 = ((f) drawable2).dC();
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

    static void n(Drawable drawable) {
        if (VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            int[] state = drawable.getState();
            if (state == null || state.length == 0) {
                drawable.setState(ay.kO);
            } else {
                drawable.setState(ay.EMPTY_STATE_SET);
            }
            drawable.setState(state);
        }
    }

    public static boolean o(Drawable drawable) {
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
                    if (!(drawable2 instanceof f)) {
                        if (!(drawable2 instanceof a)) {
                            if (!(drawable2 instanceof ScaleDrawable)) {
                                break;
                            }
                            drawable2 = ((ScaleDrawable) drawable2).getDrawable();
                        } else {
                            drawable2 = ((a) drawable2).mDrawable;
                        }
                    } else {
                        drawable2 = ((f) drawable2).dC();
                    }
                } else {
                    ConstantState constantState = drawable2.getConstantState();
                    if (constantState instanceof DrawableContainerState) {
                        for (Drawable o : ((DrawableContainerState) constantState).getChildren()) {
                            if (!o(o)) {
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

    public static Mode d(int i, Mode mode) {
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

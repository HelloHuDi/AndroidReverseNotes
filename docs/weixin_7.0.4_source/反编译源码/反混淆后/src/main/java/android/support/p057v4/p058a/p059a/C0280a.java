package android.support.p057v4.p058a.p059a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: android.support.v4.a.a.a */
public final class C0280a {
    /* renamed from: Hp */
    private static Method f195Hp;
    /* renamed from: Hq */
    private static boolean f196Hq;
    /* renamed from: Hr */
    private static Method f197Hr;
    /* renamed from: Hs */
    private static boolean f198Hs;

    /* renamed from: a */
    public static void m461a(Drawable drawable, boolean z) {
        if (VERSION.SDK_INT >= 19) {
            drawable.setAutoMirrored(z);
        }
    }

    /* renamed from: b */
    public static boolean m462b(Drawable drawable) {
        if (VERSION.SDK_INT >= 19) {
            return drawable.isAutoMirrored();
        }
        return false;
    }

    /* renamed from: a */
    public static void m454a(Drawable drawable, float f, float f2) {
        if (VERSION.SDK_INT >= 21) {
            drawable.setHotspot(f, f2);
        }
    }

    /* renamed from: a */
    public static void m456a(Drawable drawable, int i, int i2, int i3, int i4) {
        if (VERSION.SDK_INT >= 21) {
            drawable.setHotspotBounds(i, i2, i3, i4);
        }
    }

    /* renamed from: a */
    public static void m455a(Drawable drawable, int i) {
        if (VERSION.SDK_INT >= 21) {
            drawable.setTint(i);
        } else if (drawable instanceof C0281e) {
            ((C0281e) drawable).setTint(i);
        }
    }

    /* renamed from: a */
    public static void m457a(Drawable drawable, ColorStateList colorStateList) {
        if (VERSION.SDK_INT >= 21) {
            drawable.setTintList(colorStateList);
        } else if (drawable instanceof C0281e) {
            ((C0281e) drawable).setTintList(colorStateList);
        }
    }

    /* renamed from: a */
    public static void m460a(Drawable drawable, Mode mode) {
        if (VERSION.SDK_INT >= 21) {
            drawable.setTintMode(mode);
        } else if (drawable instanceof C0281e) {
            ((C0281e) drawable).setTintMode(mode);
        }
    }

    /* renamed from: c */
    public static int m464c(Drawable drawable) {
        if (VERSION.SDK_INT >= 19) {
            return drawable.getAlpha();
        }
        return 0;
    }

    /* renamed from: a */
    public static void m458a(Drawable drawable, Theme theme) {
        if (VERSION.SDK_INT >= 21) {
            drawable.applyTheme(theme);
        }
    }

    /* renamed from: d */
    public static boolean m465d(Drawable drawable) {
        if (VERSION.SDK_INT >= 21) {
            return drawable.canApplyTheme();
        }
        return false;
    }

    /* renamed from: e */
    public static void m466e(Drawable drawable) {
        Drawable drawable2 = drawable;
        while (VERSION.SDK_INT < 23 && VERSION.SDK_INT >= 21) {
            drawable2.clearColorFilter();
            if (drawable2 instanceof InsetDrawable) {
                drawable2 = ((InsetDrawable) drawable2).getDrawable();
            } else if (drawable2 instanceof C0282f) {
                drawable2 = ((C0282f) drawable2).mo459dC();
            } else if (drawable2 instanceof DrawableContainer) {
                DrawableContainerState drawableContainerState = (DrawableContainerState) ((DrawableContainer) drawable2).getConstantState();
                if (drawableContainerState != null) {
                    int childCount = drawableContainerState.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        Drawable child = drawableContainerState.getChild(i);
                        if (child != null) {
                            C0280a.m466e(child);
                        }
                    }
                    return;
                }
                return;
            } else {
                return;
            }
        }
        drawable2.clearColorFilter();
    }

    /* renamed from: a */
    public static void m459a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        if (VERSION.SDK_INT >= 21) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        } else {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        }
    }

    /* renamed from: f */
    public static Drawable m467f(Drawable drawable) {
        if (VERSION.SDK_INT >= 23) {
            return drawable;
        }
        if (VERSION.SDK_INT >= 21) {
            if (drawable instanceof C0281e) {
                return drawable;
            }
            return new C7587i(drawable);
        } else if (VERSION.SDK_INT >= 19) {
            if (drawable instanceof C0281e) {
                return drawable;
            }
            return new C7446h(drawable);
        } else if (drawable instanceof C0281e) {
            return drawable;
        } else {
            return new C6171g(drawable);
        }
    }

    /* renamed from: b */
    public static boolean m463b(Drawable drawable, int i) {
        if (VERSION.SDK_INT >= 23) {
            return drawable.setLayoutDirection(i);
        }
        if (VERSION.SDK_INT < 17) {
            return false;
        }
        if (!f196Hq) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", new Class[]{Integer.TYPE});
                f195Hp = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            f196Hq = true;
        }
        if (f195Hp != null) {
            try {
                f195Hp.invoke(drawable, new Object[]{Integer.valueOf(i)});
                return true;
            } catch (Exception e2) {
                f195Hp = null;
            }
        }
        return false;
    }

    /* renamed from: g */
    public static int m468g(Drawable drawable) {
        if (VERSION.SDK_INT >= 23) {
            return drawable.getLayoutDirection();
        }
        if (VERSION.SDK_INT < 17) {
            return 0;
        }
        if (!f198Hs) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                f197Hr = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            f198Hs = true;
        }
        if (f197Hr != null) {
            try {
                return ((Integer) f197Hr.invoke(drawable, new Object[0])).intValue();
            } catch (Exception e2) {
                f197Hr = null;
            }
        }
        return 0;
    }
}

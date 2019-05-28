package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.XmlResourceParser;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.v4.f.f;
import android.support.v4.f.g;
import android.support.v4.f.n;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import com.tencent.mm.R;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class i {
    private static final int[] afA = new int[]{R.drawable.a_1, R.drawable.a_3, R.drawable.a92, R.drawable.ae, R.drawable.a9v, R.drawable.a9x, R.drawable.a9z, R.drawable.a9w, R.drawable.a9y, R.drawable.a_0};
    private static final int[] afB = new int[]{R.drawable.a9m, R.drawable.o, R.drawable.a9l};
    private static final int[] afC = new int[]{R.drawable.ad, R.drawable.af};
    private static final int[] afD = new int[]{R.drawable.k, R.drawable.n};
    private static final Mode afv = Mode.SRC_IN;
    private static i afw;
    private static final b afx = new b();
    private static final int[] afy = new int[]{R.drawable.a_4, R.drawable.a_2, R.drawable.a8v};
    private static final int[] afz = new int[]{R.drawable.a93, R.drawable.a9, R.drawable.a98, R.drawable.a94, R.drawable.a95, R.drawable.a97, R.drawable.a96};
    private WeakHashMap<Context, n<ColorStateList>> afE;
    private android.support.v4.f.a<String, c> afF;
    private n<String> afG;
    public final Object afH = new Object();
    public final WeakHashMap<Context, f<WeakReference<ConstantState>>> afI = new WeakHashMap(0);
    private TypedValue afJ;
    private boolean afK;

    interface c {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme);
    }

    static class a implements c {
        a() {
        }

        public final Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            try {
                return android.support.c.a.c.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                return null;
            }
        }
    }

    static class b extends g<Integer, PorterDuffColorFilter> {
        public b() {
            super(6);
        }

        /* Access modifiers changed, original: final */
        public final PorterDuffColorFilter b(int i, Mode mode) {
            return (PorterDuffColorFilter) get(Integer.valueOf(c(i, mode)));
        }

        /* Access modifiers changed, original: final */
        public final PorterDuffColorFilter a(int i, Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) put(Integer.valueOf(c(i, mode)), porterDuffColorFilter);
        }

        private static int c(int i, Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }
    }

    static class d implements c {
        d() {
        }

        public final Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            try {
                return android.support.c.a.i.a(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                return null;
            }
        }
    }

    public static i hE() {
        if (afw == null) {
            i iVar = new i();
            afw = iVar;
            if (VERSION.SDK_INT < 24) {
                iVar.a("vector", new d());
                iVar.a("animated-vector", new a());
            }
        }
        return afw;
    }

    public final Drawable a(Context context, int i, boolean z) {
        ab(context);
        Drawable n = n(context, i);
        if (n == null) {
            n = m(context, i);
        }
        if (n == null) {
            n = android.support.v4.content.b.g(context, i);
        }
        if (n != null) {
            n = a(context, i, z, n);
        }
        if (n != null) {
            aa.n(n);
        }
        return n;
    }

    private static long a(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    private Drawable m(Context context, int i) {
        if (this.afJ == null) {
            this.afJ = new TypedValue();
        }
        TypedValue typedValue = this.afJ;
        context.getResources().getValue(i, typedValue, true);
        long a = a(typedValue);
        Drawable a2 = a(context, a);
        if (a2 == null) {
            if (i == R.drawable.p) {
                a2 = new LayerDrawable(new Drawable[]{a(context, (int) R.drawable.o, false), a(context, (int) R.drawable.a92, false)});
            }
            if (a2 != null) {
                a2.setChangingConfigurations(typedValue.changingConfigurations);
                a(context, a, a2);
            }
        }
        return a2;
    }

    /* Access modifiers changed, original: final */
    public final Drawable a(Context context, int i, boolean z, Drawable drawable) {
        ColorStateList o = o(context, i);
        LayerDrawable layerDrawable;
        if (o != null) {
            if (aa.o(drawable)) {
                drawable = drawable.mutate();
            }
            drawable = android.support.v4.a.a.a.f(drawable);
            android.support.v4.a.a.a.a(drawable, o);
            Mode bF = bF(i);
            if (bF == null) {
                return drawable;
            }
            android.support.v4.a.a.a.a(drawable, bF);
            return drawable;
        } else if (i == R.drawable.a_) {
            layerDrawable = (LayerDrawable) drawable;
            a(layerDrawable.findDrawableByLayerId(16908288), ay.s(context, R.attr.fo), afv);
            a(layerDrawable.findDrawableByLayerId(16908303), ay.s(context, R.attr.fo), afv);
            a(layerDrawable.findDrawableByLayerId(16908301), ay.s(context, R.attr.fp), afv);
            return drawable;
        } else if (i == R.drawable.a6 || i == R.drawable.a5 || i == R.drawable.a7) {
            layerDrawable = (LayerDrawable) drawable;
            a(layerDrawable.findDrawableByLayerId(16908288), ay.u(context, R.attr.fo), afv);
            a(layerDrawable.findDrawableByLayerId(16908303), ay.s(context, R.attr.fp), afv);
            a(layerDrawable.findDrawableByLayerId(16908301), ay.s(context, R.attr.fp), afv);
            return drawable;
        } else if (a(context, i, drawable) || !z) {
            return drawable;
        } else {
            return null;
        }
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:47:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0089  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final Drawable n(Context context, int i) {
        if (this.afF == null || this.afF.isEmpty()) {
            return null;
        }
        String str;
        if (this.afG != null) {
            str = (String) this.afG.aH(i);
            if ("appcompat_skip_skip".equals(str) || (str != null && this.afF.get(str) == null)) {
                return null;
            }
        }
        this.afG = new n();
        if (this.afJ == null) {
            this.afJ = new TypedValue();
        }
        TypedValue typedValue = this.afJ;
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        long a = a(typedValue);
        Drawable a2 = a(context, a);
        if (a2 != null) {
            return a2;
        }
        Drawable drawable;
        if (typedValue.string != null && typedValue.string.toString().endsWith(".xml")) {
            try {
                int next;
                XmlResourceParser xml = resources.getXml(i);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                str = xml.getName();
                this.afG.append(i, str);
                c cVar = (c) this.afF.get(str);
                if (cVar != null) {
                    a2 = cVar.a(context, xml, asAttributeSet, context.getTheme());
                }
                if (a2 != null) {
                    a2.setChangingConfigurations(typedValue.changingConfigurations);
                    a(context, a, a2);
                }
                drawable = a2;
                if (drawable == null) {
                    return drawable;
                }
                this.afG.append(i, "appcompat_skip_skip");
                return drawable;
            } catch (Exception e) {
            }
        }
        drawable = a2;
        if (drawable == null) {
        }
    }

    /* JADX WARNING: Missing block: B:27:?, code skipped:
            return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Drawable a(Context context, long j) {
        synchronized (this.afH) {
            f fVar = (f) this.afI.get(context);
            if (fVar == null) {
                return null;
            }
            WeakReference weakReference = (WeakReference) fVar.k(j);
            if (weakReference != null) {
                ConstantState constantState = (ConstantState) weakReference.get();
                if (constantState != null) {
                    Drawable newDrawable = constantState.newDrawable(context.getResources());
                    return newDrawable;
                }
                int a = android.support.v4.f.c.a(fVar.Lk, fVar.mSize, j);
                if (a >= 0 && fVar.Ll[a] != f.Li) {
                    fVar.Ll[a] = f.Li;
                    fVar.Lj = true;
                }
            }
        }
    }

    private boolean a(Context context, long j, Drawable drawable) {
        ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        synchronized (this.afH) {
            f fVar = (f) this.afI.get(context);
            if (fVar == null) {
                fVar = new f();
                this.afI.put(context, fVar);
            }
            fVar.put(j, new WeakReference(constantState));
        }
        return true;
    }

    static boolean a(Context context, int i, Drawable drawable) {
        int i2;
        boolean z;
        int i3 = 16842801;
        Mode mode = afv;
        if (c(afy, i)) {
            i3 = R.attr.fo;
            i2 = -1;
            z = true;
        } else if (c(afA, i)) {
            i3 = R.attr.fp;
            i2 = -1;
            z = true;
        } else if (c(afB, i)) {
            mode = Mode.MULTIPLY;
            i2 = -1;
            z = true;
        } else if (i == R.drawable.a9e) {
            i3 = 16842800;
            i2 = Math.round(40.8f);
            z = true;
        } else if (i == R.drawable.q) {
            i2 = -1;
            z = true;
        } else {
            i2 = -1;
            i3 = 0;
            z = false;
        }
        if (!z) {
            return false;
        }
        if (aa.o(drawable)) {
            drawable = drawable.mutate();
        }
        drawable.setColorFilter(a(ay.s(context, i3), mode));
        if (i2 == -1) {
            return true;
        }
        drawable.setAlpha(i2);
        return true;
    }

    private void a(String str, c cVar) {
        if (this.afF == null) {
            this.afF = new android.support.v4.f.a();
        }
        this.afF.put(str, cVar);
    }

    private static boolean c(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private static Mode bF(int i) {
        if (i == R.drawable.ac) {
            return Mode.MULTIPLY;
        }
        return null;
    }

    /* Access modifiers changed, original: final */
    public final ColorStateList o(Context context, int i) {
        ColorStateList p = p(context, i);
        if (p == null) {
            if (i == R.drawable.r) {
                p = android.support.v7.c.a.b.h(context, R.color.a6t);
            } else if (i == R.drawable.a9t) {
                p = android.support.v7.c.a.b.h(context, R.color.a6w);
            } else if (i == R.drawable.ac) {
                p = aa(context);
            } else if (i == R.drawable.m) {
                p = Y(context);
            } else if (i == R.drawable.j) {
                p = q(context, 0);
            } else if (i == R.drawable.l) {
                p = Z(context);
            } else if (i == R.drawable.a9s || i == R.drawable.ab) {
                p = android.support.v7.c.a.b.h(context, R.color.a6v);
            } else if (c(afz, i)) {
                p = ay.t(context, R.attr.fo);
            } else if (c(afC, i)) {
                p = android.support.v7.c.a.b.h(context, R.color.a6s);
            } else if (c(afD, i)) {
                p = android.support.v7.c.a.b.h(context, R.color.a6r);
            } else if (i == R.drawable.a8) {
                p = android.support.v7.c.a.b.h(context, R.color.a6u);
            }
            if (p != null) {
                a(context, i, p);
            }
        }
        return p;
    }

    private ColorStateList p(Context context, int i) {
        if (this.afE == null) {
            return null;
        }
        n nVar = (n) this.afE.get(context);
        if (nVar != null) {
            return (ColorStateList) nVar.aH(i);
        }
        return null;
    }

    private void a(Context context, int i, ColorStateList colorStateList) {
        if (this.afE == null) {
            this.afE = new WeakHashMap();
        }
        n nVar = (n) this.afE.get(context);
        if (nVar == null) {
            nVar = new n();
            this.afE.put(context, nVar);
        }
        nVar.append(i, colorStateList);
    }

    private static ColorStateList Y(Context context) {
        return q(context, ay.s(context, R.attr.fr));
    }

    private static ColorStateList Z(Context context) {
        return q(context, ay.s(context, R.attr.fn));
    }

    private static ColorStateList q(Context context, int i) {
        r0 = new int[4][];
        r1 = new int[4];
        int s = ay.s(context, R.attr.fq);
        int u = ay.u(context, R.attr.fr);
        r0[0] = ay.mX;
        r1[0] = u;
        r0[1] = ay.PRESSED_STATE_SET;
        r1[1] = android.support.v4.a.b.s(s, i);
        r0[2] = ay.FOCUSED_STATE_SET;
        r1[2] = android.support.v4.a.b.s(s, i);
        r0[3] = ay.EMPTY_STATE_SET;
        r1[3] = i;
        return new ColorStateList(r0, r1);
    }

    private static ColorStateList aa(Context context) {
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList t = ay.t(context, R.attr.fs);
        if (t == null || !t.isStateful()) {
            iArr[0] = ay.mX;
            iArr2[0] = ay.u(context, R.attr.fs);
            iArr[1] = ay.kO;
            iArr2[1] = ay.s(context, R.attr.fp);
            iArr[2] = ay.EMPTY_STATE_SET;
            iArr2[2] = ay.s(context, R.attr.fs);
        } else {
            iArr[0] = ay.mX;
            iArr2[0] = t.getColorForState(iArr[0], 0);
            iArr[1] = ay.kO;
            iArr2[1] = ay.s(context, R.attr.fp);
            iArr[2] = ay.EMPTY_STATE_SET;
            iArr2[2] = t.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    static void a(Drawable drawable, ba baVar, int[] iArr) {
        ColorFilter colorFilter = null;
        if (!aa.o(drawable) || drawable.mutate() == drawable) {
            if (baVar.atE || baVar.atD) {
                ColorStateList colorStateList;
                Mode mode;
                if (baVar.atE) {
                    colorStateList = baVar.atC;
                } else {
                    colorStateList = null;
                }
                if (baVar.atD) {
                    mode = baVar.vI;
                } else {
                    mode = afv;
                }
                if (!(colorStateList == null || mode == null)) {
                    colorFilter = a(colorStateList.getColorForState(iArr, 0), mode);
                }
                drawable.setColorFilter(colorFilter);
            } else {
                drawable.clearColorFilter();
            }
            if (VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
            }
        }
    }

    public static PorterDuffColorFilter a(int i, Mode mode) {
        PorterDuffColorFilter b = afx.b(i, mode);
        if (b != null) {
            return b;
        }
        b = new PorterDuffColorFilter(i, mode);
        afx.a(i, mode, b);
        return b;
    }

    private static void a(Drawable drawable, int i, Mode mode) {
        if (aa.o(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = afv;
        }
        drawable.setColorFilter(a(i, mode));
    }

    private void ab(Context context) {
        if (!this.afK) {
            this.afK = true;
            Drawable a = a(context, (int) R.drawable.ag, false);
            if (a == null || !k(a)) {
                this.afK = false;
                throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
            }
        }
    }

    private static boolean k(Drawable drawable) {
        return (drawable instanceof android.support.c.a.i) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }
}

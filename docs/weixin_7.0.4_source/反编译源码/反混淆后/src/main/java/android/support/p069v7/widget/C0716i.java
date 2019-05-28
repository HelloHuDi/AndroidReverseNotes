package android.support.p069v7.widget;

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
import android.support.p054c.p055a.C7444c;
import android.support.p054c.p055a.C7445i;
import android.support.p057v4.content.C0380b;
import android.support.p057v4.p058a.C0284b;
import android.support.p057v4.p058a.p059a.C0280a;
import android.support.p057v4.p065f.C0404c;
import android.support.p057v4.p065f.C0407f;
import android.support.p057v4.p065f.C0408g;
import android.support.p057v4.p065f.C0418n;
import android.support.p057v4.p065f.C6197a;
import android.support.p069v7.p071c.p072a.C0589b;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import com.tencent.p177mm.C25738R;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: android.support.v7.widget.i */
public final class C0716i {
    private static final int[] afA = new int[]{C25738R.drawable.a_1, C25738R.drawable.a_3, C25738R.drawable.a92, C25738R.drawable.f6327ae, C25738R.drawable.a9v, C25738R.drawable.a9x, C25738R.drawable.a9z, C25738R.drawable.a9w, C25738R.drawable.a9y, C25738R.drawable.a_0};
    private static final int[] afB = new int[]{C25738R.drawable.a9m, C25738R.drawable.f6300o, C25738R.drawable.a9l};
    private static final int[] afC = new int[]{C25738R.drawable.f6326ad, C25738R.drawable.f6328af};
    private static final int[] afD = new int[]{C25738R.drawable.f6296k, C25738R.drawable.f6299n};
    private static final Mode afv = Mode.SRC_IN;
    private static C0716i afw;
    private static final C0718b afx = new C0718b();
    private static final int[] afy = new int[]{C25738R.drawable.a_4, C25738R.drawable.a_2, C25738R.drawable.a8v};
    private static final int[] afz = new int[]{C25738R.drawable.a93, C25738R.drawable.f6321a9, C25738R.drawable.a98, C25738R.drawable.a94, C25738R.drawable.a95, C25738R.drawable.a97, C25738R.drawable.a96};
    private WeakHashMap<Context, C0418n<ColorStateList>> afE;
    private C6197a<String, C0715c> afF;
    private C0418n<String> afG;
    public final Object afH = new Object();
    public final WeakHashMap<Context, C0407f<WeakReference<ConstantState>>> afI = new WeakHashMap(0);
    private TypedValue afJ;
    private boolean afK;

    /* renamed from: android.support.v7.widget.i$c */
    interface C0715c {
        /* renamed from: a */
        Drawable mo2081a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme);
    }

    /* renamed from: android.support.v7.widget.i$a */
    static class C0717a implements C0715c {
        C0717a() {
        }

        /* renamed from: a */
        public final Drawable mo2081a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            try {
                return C7444c.m12686a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                return null;
            }
        }
    }

    /* renamed from: android.support.v7.widget.i$b */
    static class C0718b extends C0408g<Integer, PorterDuffColorFilter> {
        public C0718b() {
            super(6);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: b */
        public final PorterDuffColorFilter mo2087b(int i, Mode mode) {
            return (PorterDuffColorFilter) get(Integer.valueOf(C0718b.m1616c(i, mode)));
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final PorterDuffColorFilter mo2086a(int i, Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) put(Integer.valueOf(C0718b.m1616c(i, mode)), porterDuffColorFilter);
        }

        /* renamed from: c */
        private static int m1616c(int i, Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }
    }

    /* renamed from: android.support.v7.widget.i$d */
    static class C0719d implements C0715c {
        C0719d() {
        }

        /* renamed from: a */
        public final Drawable mo2081a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            try {
                return C7445i.m12690a(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                return null;
            }
        }
    }

    /* renamed from: hE */
    public static C0716i m1606hE() {
        if (afw == null) {
            C0716i c0716i = new C0716i();
            afw = c0716i;
            if (VERSION.SDK_INT < 24) {
                c0716i.m1599a("vector", new C0719d());
                c0716i.m1599a("animated-vector", new C0717a());
            }
        }
        return afw;
    }

    /* renamed from: a */
    public final Drawable mo2082a(Context context, int i, boolean z) {
        m1603ab(context);
        Drawable n = mo2084n(context, i);
        if (n == null) {
            n = m1608m(context, i);
        }
        if (n == null) {
            n = C0380b.m649g(context, i);
        }
        if (n != null) {
            n = mo2083a(context, i, z, n);
        }
        if (n != null) {
            C0679aa.m1530n(n);
        }
        return n;
    }

    /* renamed from: a */
    private static long m1593a(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    /* renamed from: m */
    private Drawable m1608m(Context context, int i) {
        if (this.afJ == null) {
            this.afJ = new TypedValue();
        }
        TypedValue typedValue = this.afJ;
        context.getResources().getValue(i, typedValue, true);
        long a = C0716i.m1593a(typedValue);
        Drawable a2 = m1595a(context, a);
        if (a2 == null) {
            if (i == C25738R.drawable.f6301p) {
                a2 = new LayerDrawable(new Drawable[]{mo2082a(context, (int) C25738R.drawable.f6300o, false), mo2082a(context, (int) C25738R.drawable.a92, false)});
            }
            if (a2 != null) {
                a2.setChangingConfigurations(typedValue.changingConfigurations);
                m1601a(context, a, a2);
            }
        }
        return a2;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final Drawable mo2083a(Context context, int i, boolean z, Drawable drawable) {
        ColorStateList o = mo2085o(context, i);
        LayerDrawable layerDrawable;
        if (o != null) {
            if (C0679aa.m1531o(drawable)) {
                drawable = drawable.mutate();
            }
            drawable = C0280a.m467f(drawable);
            C0280a.m457a(drawable, o);
            Mode bF = C0716i.m1604bF(i);
            if (bF == null) {
                return drawable;
            }
            C0280a.m460a(drawable, bF);
            return drawable;
        } else if (i == C25738R.drawable.f6322a_) {
            layerDrawable = (LayerDrawable) drawable;
            C0716i.m1597a(layerDrawable.findDrawableByLayerId(16908288), C0696ay.m1549s(context, C25738R.attr.f5683fo), afv);
            C0716i.m1597a(layerDrawable.findDrawableByLayerId(16908303), C0696ay.m1549s(context, C25738R.attr.f5683fo), afv);
            C0716i.m1597a(layerDrawable.findDrawableByLayerId(16908301), C0696ay.m1549s(context, C25738R.attr.f5684fp), afv);
            return drawable;
        } else if (i == C25738R.drawable.f6318a6 || i == C25738R.drawable.f6317a5 || i == C25738R.drawable.f6319a7) {
            layerDrawable = (LayerDrawable) drawable;
            C0716i.m1597a(layerDrawable.findDrawableByLayerId(16908288), C0696ay.m1551u(context, C25738R.attr.f5683fo), afv);
            C0716i.m1597a(layerDrawable.findDrawableByLayerId(16908303), C0696ay.m1549s(context, C25738R.attr.f5684fp), afv);
            C0716i.m1597a(layerDrawable.findDrawableByLayerId(16908301), C0696ay.m1549s(context, C25738R.attr.f5684fp), afv);
            return drawable;
        } else if (C0716i.m1600a(context, i, drawable) || !z) {
            return drawable;
        } else {
            return null;
        }
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:47:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0089  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: n */
    public final Drawable mo2084n(Context context, int i) {
        if (this.afF == null || this.afF.isEmpty()) {
            return null;
        }
        String str;
        if (this.afG != null) {
            str = (String) this.afG.mo847aH(i);
            if ("appcompat_skip_skip".equals(str) || (str != null && this.afF.get(str) == null)) {
                return null;
            }
        }
        this.afG = new C0418n();
        if (this.afJ == null) {
            this.afJ = new TypedValue();
        }
        TypedValue typedValue = this.afJ;
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        long a = C0716i.m1593a(typedValue);
        Drawable a2 = m1595a(context, a);
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
                C0715c c0715c = (C0715c) this.afF.get(str);
                if (c0715c != null) {
                    a2 = c0715c.mo2081a(context, xml, asAttributeSet, context.getTheme());
                }
                if (a2 != null) {
                    a2.setChangingConfigurations(typedValue.changingConfigurations);
                    m1601a(context, a, a2);
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
    /* renamed from: a */
    private Drawable m1595a(Context context, long j) {
        synchronized (this.afH) {
            C0407f c0407f = (C0407f) this.afI.get(context);
            if (c0407f == null) {
                return null;
            }
            WeakReference weakReference = (WeakReference) c0407f.mo742k(j);
            if (weakReference != null) {
                ConstantState constantState = (ConstantState) weakReference.get();
                if (constantState != null) {
                    Drawable newDrawable = constantState.newDrawable(context.getResources());
                    return newDrawable;
                }
                int a = C0404c.m689a(c0407f.f479Lk, c0407f.mSize, j);
                if (a >= 0 && c0407f.f480Ll[a] != C0407f.f477Li) {
                    c0407f.f480Ll[a] = C0407f.f477Li;
                    c0407f.f478Lj = true;
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m1601a(Context context, long j, Drawable drawable) {
        ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        synchronized (this.afH) {
            C0407f c0407f = (C0407f) this.afI.get(context);
            if (c0407f == null) {
                c0407f = new C0407f();
                this.afI.put(context, c0407f);
            }
            c0407f.put(j, new WeakReference(constantState));
        }
        return true;
    }

    /* renamed from: a */
    static boolean m1600a(Context context, int i, Drawable drawable) {
        int i2;
        boolean z;
        int i3 = 16842801;
        Mode mode = afv;
        if (C0716i.m1605c(afy, i)) {
            i3 = C25738R.attr.f5683fo;
            i2 = -1;
            z = true;
        } else if (C0716i.m1605c(afA, i)) {
            i3 = C25738R.attr.f5684fp;
            i2 = -1;
            z = true;
        } else if (C0716i.m1605c(afB, i)) {
            mode = Mode.MULTIPLY;
            i2 = -1;
            z = true;
        } else if (i == C25738R.drawable.a9e) {
            i3 = 16842800;
            i2 = Math.round(40.8f);
            z = true;
        } else if (i == C25738R.drawable.f6302q) {
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
        if (C0679aa.m1531o(drawable)) {
            drawable = drawable.mutate();
        }
        drawable.setColorFilter(C0716i.m1594a(C0696ay.m1549s(context, i3), mode));
        if (i2 == -1) {
            return true;
        }
        drawable.setAlpha(i2);
        return true;
    }

    /* renamed from: a */
    private void m1599a(String str, C0715c c0715c) {
        if (this.afF == null) {
            this.afF = new C6197a();
        }
        this.afF.put(str, c0715c);
    }

    /* renamed from: c */
    private static boolean m1605c(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: bF */
    private static Mode m1604bF(int i) {
        if (i == C25738R.drawable.f6325ac) {
            return Mode.MULTIPLY;
        }
        return null;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: o */
    public final ColorStateList mo2085o(Context context, int i) {
        ColorStateList p = m1609p(context, i);
        if (p == null) {
            if (i == C25738R.drawable.f6303r) {
                p = C0589b.m1276h(context, C25738R.color.a6t);
            } else if (i == C25738R.drawable.a9t) {
                p = C0589b.m1276h(context, C25738R.color.a6w);
            } else if (i == C25738R.drawable.f6325ac) {
                p = C0716i.m1602aa(context);
            } else if (i == C25738R.drawable.f6298m) {
                p = C0716i.m1591Y(context);
            } else if (i == C25738R.drawable.f6295j) {
                p = C0716i.m1610q(context, 0);
            } else if (i == C25738R.drawable.f6297l) {
                p = C0716i.m1592Z(context);
            } else if (i == C25738R.drawable.a9s || i == C25738R.drawable.f6324ab) {
                p = C0589b.m1276h(context, C25738R.color.a6v);
            } else if (C0716i.m1605c(afz, i)) {
                p = C0696ay.m1550t(context, C25738R.attr.f5683fo);
            } else if (C0716i.m1605c(afC, i)) {
                p = C0589b.m1276h(context, C25738R.color.a6s);
            } else if (C0716i.m1605c(afD, i)) {
                p = C0589b.m1276h(context, C25738R.color.a6r);
            } else if (i == C25738R.drawable.f6320a8) {
                p = C0589b.m1276h(context, C25738R.color.a6u);
            }
            if (p != null) {
                m1596a(context, i, p);
            }
        }
        return p;
    }

    /* renamed from: p */
    private ColorStateList m1609p(Context context, int i) {
        if (this.afE == null) {
            return null;
        }
        C0418n c0418n = (C0418n) this.afE.get(context);
        if (c0418n != null) {
            return (ColorStateList) c0418n.mo847aH(i);
        }
        return null;
    }

    /* renamed from: a */
    private void m1596a(Context context, int i, ColorStateList colorStateList) {
        if (this.afE == null) {
            this.afE = new WeakHashMap();
        }
        C0418n c0418n = (C0418n) this.afE.get(context);
        if (c0418n == null) {
            c0418n = new C0418n();
            this.afE.put(context, c0418n);
        }
        c0418n.append(i, colorStateList);
    }

    /* renamed from: Y */
    private static ColorStateList m1591Y(Context context) {
        return C0716i.m1610q(context, C0696ay.m1549s(context, C25738R.attr.f5686fr));
    }

    /* renamed from: Z */
    private static ColorStateList m1592Z(Context context) {
        return C0716i.m1610q(context, C0696ay.m1549s(context, C25738R.attr.f5682fn));
    }

    /* renamed from: q */
    private static ColorStateList m1610q(Context context, int i) {
        r0 = new int[4][];
        r1 = new int[4];
        int s = C0696ay.m1549s(context, C25738R.attr.f5685fq);
        int u = C0696ay.m1551u(context, C25738R.attr.f5686fr);
        r0[0] = C0696ay.f1018mX;
        r1[0] = u;
        r0[1] = C0696ay.PRESSED_STATE_SET;
        r1[1] = C0284b.m477s(s, i);
        r0[2] = C0696ay.FOCUSED_STATE_SET;
        r1[2] = C0284b.m477s(s, i);
        r0[3] = C0696ay.EMPTY_STATE_SET;
        r1[3] = i;
        return new ColorStateList(r0, r1);
    }

    /* renamed from: aa */
    private static ColorStateList m1602aa(Context context) {
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList t = C0696ay.m1550t(context, C25738R.attr.f5687fs);
        if (t == null || !t.isStateful()) {
            iArr[0] = C0696ay.f1018mX;
            iArr2[0] = C0696ay.m1551u(context, C25738R.attr.f5687fs);
            iArr[1] = C0696ay.f1017kO;
            iArr2[1] = C0696ay.m1549s(context, C25738R.attr.f5684fp);
            iArr[2] = C0696ay.EMPTY_STATE_SET;
            iArr2[2] = C0696ay.m1549s(context, C25738R.attr.f5687fs);
        } else {
            iArr[0] = C0696ay.f1018mX;
            iArr2[0] = t.getColorForState(iArr[0], 0);
            iArr[1] = C0696ay.f1017kO;
            iArr2[1] = C0696ay.m1549s(context, C25738R.attr.f5684fp);
            iArr[2] = C0696ay.EMPTY_STATE_SET;
            iArr2[2] = t.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    /* renamed from: a */
    static void m1598a(Drawable drawable, C0698ba c0698ba, int[] iArr) {
        ColorFilter colorFilter = null;
        if (!C0679aa.m1531o(drawable) || drawable.mutate() == drawable) {
            if (c0698ba.atE || c0698ba.atD) {
                ColorStateList colorStateList;
                Mode mode;
                if (c0698ba.atE) {
                    colorStateList = c0698ba.atC;
                } else {
                    colorStateList = null;
                }
                if (c0698ba.atD) {
                    mode = c0698ba.f1019vI;
                } else {
                    mode = afv;
                }
                if (!(colorStateList == null || mode == null)) {
                    colorFilter = C0716i.m1594a(colorStateList.getColorForState(iArr, 0), mode);
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

    /* renamed from: a */
    public static PorterDuffColorFilter m1594a(int i, Mode mode) {
        PorterDuffColorFilter b = afx.mo2087b(i, mode);
        if (b != null) {
            return b;
        }
        b = new PorterDuffColorFilter(i, mode);
        afx.mo2086a(i, mode, b);
        return b;
    }

    /* renamed from: a */
    private static void m1597a(Drawable drawable, int i, Mode mode) {
        if (C0679aa.m1531o(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = afv;
        }
        drawable.setColorFilter(C0716i.m1594a(i, mode));
    }

    /* renamed from: ab */
    private void m1603ab(Context context) {
        if (!this.afK) {
            this.afK = true;
            Drawable a = mo2082a(context, (int) C25738R.drawable.f6329ag, false);
            if (a == null || !C0716i.m1607k(a)) {
                this.afK = false;
                throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
            }
        }
    }

    /* renamed from: k */
    private static boolean m1607k(Drawable drawable) {
        return (drawable instanceof C7445i) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }
}

package android.support.p054c.p055a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.VectorDrawable;
import android.os.Build.VERSION;
import android.support.p057v4.content.p062a.C0378b;
import android.support.p057v4.content.p062a.C0379c;
import android.support.p057v4.p058a.C0287c;
import android.support.p057v4.p058a.C0287c.C0286b;
import android.support.p057v4.p058a.p059a.C0280a;
import android.support.p057v4.p065f.C6197a;
import android.util.AttributeSet;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: android.support.c.a.i */
public final class C7445i extends C6164h {
    /* renamed from: uK */
    static final Mode f2029uK = Mode.SRC_IN;
    /* renamed from: uL */
    C0243f f2030uL;
    /* renamed from: uM */
    private PorterDuffColorFilter f2031uM;
    /* renamed from: uN */
    private ColorFilter f2032uN;
    /* renamed from: uO */
    private boolean f2033uO;
    /* renamed from: uP */
    boolean f2034uP;
    /* renamed from: uQ */
    private ConstantState f2035uQ;
    /* renamed from: uR */
    private final float[] f2036uR;
    /* renamed from: uS */
    private final Matrix f2037uS;
    /* renamed from: uT */
    private final Rect f2038uT;

    /* renamed from: android.support.c.a.i$c */
    static class C0240c {
        /* renamed from: kx */
        final ArrayList<Object> f58kx = new ArrayList();
        int mChangingConfigurations;
        float mScaleX = 1.0f;
        float mScaleY = 1.0f;
        /* renamed from: uU */
        int[] f59uU;
        /* renamed from: vh */
        final Matrix f60vh = new Matrix();
        /* renamed from: vi */
        float f61vi = 0.0f;
        /* renamed from: vj */
        float f62vj = 0.0f;
        /* renamed from: vk */
        float f63vk = 0.0f;
        /* renamed from: vl */
        float f64vl = 0.0f;
        /* renamed from: vm */
        float f65vm = 0.0f;
        /* renamed from: vn */
        final Matrix f66vn = new Matrix();
        /* renamed from: vo */
        String f67vo = null;

        public C0240c(C0240c c0240c, C6197a<String, Object> c6197a) {
            this.f61vi = c0240c.f61vi;
            this.f62vj = c0240c.f62vj;
            this.f63vk = c0240c.f63vk;
            this.mScaleX = c0240c.mScaleX;
            this.mScaleY = c0240c.mScaleY;
            this.f64vl = c0240c.f64vl;
            this.f65vm = c0240c.f65vm;
            this.f59uU = c0240c.f59uU;
            this.f67vo = c0240c.f67vo;
            this.mChangingConfigurations = c0240c.mChangingConfigurations;
            if (this.f67vo != null) {
                c6197a.put(this.f67vo, this);
            }
            this.f66vn.set(c0240c.f66vn);
            ArrayList arrayList = c0240c.f58kx;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    Object obj = arrayList.get(i2);
                    if (obj instanceof C0240c) {
                        this.f58kx.add(new C0240c((C0240c) obj, c6197a));
                    } else {
                        if (obj instanceof C6166b) {
                            obj = new C6166b((C6166b) obj);
                        } else if (obj instanceof C6165a) {
                            C6165a c6165a = new C6165a((C6165a) obj);
                        } else {
                            throw new IllegalStateException("Unknown object in the tree!");
                        }
                        this.f58kx.add(obj);
                        if (obj.f69vq != null) {
                            c6197a.put(obj.f69vq, obj);
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: android.support.c.a.i$d */
    static class C0241d {
        int mChangingConfigurations;
        /* renamed from: vp */
        protected C0286b[] f68vp = null;
        /* renamed from: vq */
        String f69vq;

        public C0241d(C0241d c0241d) {
            this.f69vq = c0241d.f69vq;
            this.mChangingConfigurations = c0241d.mChangingConfigurations;
            this.f68vp = C0287c.m490a(c0241d.f68vp);
        }

        /* renamed from: b */
        public final void mo348b(Path path) {
            path.reset();
            if (this.f68vp != null) {
                C0286b.m483a(this.f68vp, path);
            }
        }

        /* renamed from: cG */
        public boolean mo349cG() {
            return false;
        }
    }

    /* renamed from: android.support.c.a.i$e */
    static class C0242e {
        /* renamed from: vt */
        private static final Matrix f70vt = new Matrix();
        private int mChangingConfigurations;
        /* renamed from: vA */
        float f71vA;
        /* renamed from: vB */
        float f72vB;
        /* renamed from: vC */
        float f73vC;
        /* renamed from: vD */
        int f74vD;
        /* renamed from: vE */
        String f75vE;
        /* renamed from: vF */
        final C6197a<String, Object> f76vF;
        /* renamed from: vr */
        private final Path f77vr;
        /* renamed from: vs */
        private final Path f78vs;
        /* renamed from: vu */
        private final Matrix f79vu;
        /* renamed from: vv */
        private Paint f80vv;
        /* renamed from: vw */
        private Paint f81vw;
        /* renamed from: vx */
        private PathMeasure f82vx;
        /* renamed from: vy */
        final C0240c f83vy;
        /* renamed from: vz */
        float f84vz;

        public C0242e() {
            this.f79vu = new Matrix();
            this.f84vz = 0.0f;
            this.f71vA = 0.0f;
            this.f72vB = 0.0f;
            this.f73vC = 0.0f;
            this.f74vD = 255;
            this.f75vE = null;
            this.f76vF = new C6197a();
            this.f83vy = new C0240c();
            this.f77vr = new Path();
            this.f78vs = new Path();
        }

        public C0242e(C0242e c0242e) {
            this.f79vu = new Matrix();
            this.f84vz = 0.0f;
            this.f71vA = 0.0f;
            this.f72vB = 0.0f;
            this.f73vC = 0.0f;
            this.f74vD = 255;
            this.f75vE = null;
            this.f76vF = new C6197a();
            this.f83vy = new C0240c(c0242e.f83vy, this.f76vF);
            this.f77vr = new Path(c0242e.f77vr);
            this.f78vs = new Path(c0242e.f78vs);
            this.f84vz = c0242e.f84vz;
            this.f71vA = c0242e.f71vA;
            this.f72vB = c0242e.f72vB;
            this.f73vC = c0242e.f73vC;
            this.mChangingConfigurations = c0242e.mChangingConfigurations;
            this.f74vD = c0242e.f74vD;
            this.f75vE = c0242e.f75vE;
            if (c0242e.f75vE != null) {
                this.f76vF.put(c0242e.f75vE, this);
            }
        }

        /* renamed from: a */
        public final void mo350a(Canvas canvas, int i, int i2) {
            m365a(this.f83vy, f70vt, canvas, i, i2, null);
        }

        /* renamed from: a */
        private void m365a(C0240c c0240c, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            c0240c.f60vh.set(matrix);
            c0240c.f60vh.preConcat(c0240c.f66vn);
            canvas.save();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < c0240c.f58kx.size()) {
                    Object obj = c0240c.f58kx.get(i4);
                    if (obj instanceof C0240c) {
                        m365a((C0240c) obj, c0240c.f60vh, canvas, i, i2, colorFilter);
                    } else if (obj instanceof C0241d) {
                        C0241d c0241d = (C0241d) obj;
                        float f = ((float) i) / this.f72vB;
                        float f2 = ((float) i2) / this.f73vC;
                        float min = Math.min(f, f2);
                        Matrix matrix2 = c0240c.f60vh;
                        this.f79vu.set(matrix2);
                        this.f79vu.postScale(f, f2);
                        float[] fArr = new float[]{0.0f, 1.0f, 1.0f, 0.0f};
                        matrix2.mapVectors(fArr);
                        float f3 = (fArr[3] * fArr[0]) - (fArr[1] * fArr[2]);
                        f2 = Math.max((float) Math.hypot((double) fArr[0], (double) fArr[1]), (float) Math.hypot((double) fArr[2], (double) fArr[3]));
                        if (f2 > 0.0f) {
                            f2 = Math.abs(f3) / f2;
                        } else {
                            f2 = 0.0f;
                        }
                        if (f2 != 0.0f) {
                            c0241d.mo348b(this.f77vr);
                            Path path = this.f77vr;
                            this.f78vs.reset();
                            if (c0241d.mo349cG()) {
                                this.f78vs.addPath(path, this.f79vu);
                                canvas.clipPath(this.f78vs);
                            } else {
                                C6166b c6166b = (C6166b) c0241d;
                                if (!(c6166b.f1711vb == 0.0f && c6166b.f1712vc == 1.0f)) {
                                    float f4 = (c6166b.f1711vb + c6166b.f1713vd) % 1.0f;
                                    f3 = (c6166b.f1712vc + c6166b.f1713vd) % 1.0f;
                                    if (this.f82vx == null) {
                                        this.f82vx = new PathMeasure();
                                    }
                                    this.f82vx.setPath(this.f77vr, false);
                                    float length = this.f82vx.getLength();
                                    f4 *= length;
                                    f3 *= length;
                                    path.reset();
                                    if (f4 > f3) {
                                        this.f82vx.getSegment(f4, length, path, true);
                                        this.f82vx.getSegment(0.0f, f3, path, true);
                                    } else {
                                        this.f82vx.getSegment(f4, f3, path, true);
                                    }
                                    path.rLineTo(0.0f, 0.0f);
                                }
                                this.f78vs.addPath(path, this.f79vu);
                                if (c6166b.f1707uX != 0) {
                                    if (this.f81vw == null) {
                                        this.f81vw = new Paint();
                                        this.f81vw.setStyle(Style.FILL);
                                        this.f81vw.setAntiAlias(true);
                                    }
                                    Paint paint = this.f81vw;
                                    paint.setColor(C7445i.m12692d(c6166b.f1707uX, c6166b.f1710va));
                                    paint.setColorFilter(colorFilter);
                                    this.f78vs.setFillType(c6166b.f1709uZ == 0 ? FillType.WINDING : FillType.EVEN_ODD);
                                    canvas.drawPath(this.f78vs, paint);
                                }
                                if (c6166b.f1705uV != 0) {
                                    if (this.f80vv == null) {
                                        this.f80vv = new Paint();
                                        this.f80vv.setStyle(Style.STROKE);
                                        this.f80vv.setAntiAlias(true);
                                    }
                                    Paint paint2 = this.f80vv;
                                    if (c6166b.f1715vf != null) {
                                        paint2.setStrokeJoin(c6166b.f1715vf);
                                    }
                                    if (c6166b.f1714ve != null) {
                                        paint2.setStrokeCap(c6166b.f1714ve);
                                    }
                                    paint2.setStrokeMiter(c6166b.f1716vg);
                                    paint2.setColor(C7445i.m12692d(c6166b.f1705uV, c6166b.f1708uY));
                                    paint2.setColorFilter(colorFilter);
                                    paint2.setStrokeWidth(c6166b.f1706uW * (f2 * min));
                                    canvas.drawPath(this.f78vs, paint2);
                                }
                            }
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    canvas.restore();
                    return;
                }
            }
        }
    }

    /* renamed from: android.support.c.a.i$f */
    static class C0243f extends ConstantState {
        int mChangingConfigurations;
        /* renamed from: vG */
        C0242e f85vG;
        /* renamed from: vH */
        ColorStateList f86vH;
        /* renamed from: vI */
        Mode f87vI;
        /* renamed from: vJ */
        boolean f88vJ;
        /* renamed from: vK */
        Bitmap f89vK;
        /* renamed from: vL */
        ColorStateList f90vL;
        /* renamed from: vM */
        Mode f91vM;
        /* renamed from: vN */
        int f92vN;
        /* renamed from: vO */
        boolean f93vO;
        /* renamed from: vP */
        boolean f94vP;
        /* renamed from: vQ */
        Paint f95vQ;

        public C0243f(C0243f c0243f) {
            this.f86vH = null;
            this.f87vI = C7445i.f2029uK;
            if (c0243f != null) {
                this.mChangingConfigurations = c0243f.mChangingConfigurations;
                this.f85vG = new C0242e(c0243f.f85vG);
                if (c0243f.f85vG.f81vw != null) {
                    this.f85vG.f81vw = new Paint(c0243f.f85vG.f81vw);
                }
                if (c0243f.f85vG.f80vv != null) {
                    this.f85vG.f80vv = new Paint(c0243f.f85vG.f80vv);
                }
                this.f86vH = c0243f.f86vH;
                this.f87vI = c0243f.f87vI;
                this.f88vJ = c0243f.f88vJ;
            }
        }

        /* renamed from: p */
        public final void mo354p(int i, int i2) {
            this.f89vK.eraseColor(0);
            this.f85vG.mo350a(new Canvas(this.f89vK), i, i2);
        }

        public C0243f() {
            this.f86vH = null;
            this.f87vI = C7445i.f2029uK;
            this.f85vG = new C0242e();
        }

        public final Drawable newDrawable() {
            return new C7445i(this);
        }

        public final Drawable newDrawable(Resources resources) {
            return new C7445i(this);
        }

        public final int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }
    }

    /* renamed from: android.support.c.a.i$g */
    static class C0244g extends ConstantState {
        /* renamed from: uE */
        private final ConstantState f96uE;

        public C0244g(ConstantState constantState) {
            this.f96uE = constantState;
        }

        public final Drawable newDrawable() {
            C7445i c7445i = new C7445i();
            c7445i.f1703uJ = (VectorDrawable) this.f96uE.newDrawable();
            return c7445i;
        }

        public final Drawable newDrawable(Resources resources) {
            C7445i c7445i = new C7445i();
            c7445i.f1703uJ = (VectorDrawable) this.f96uE.newDrawable(resources);
            return c7445i;
        }

        public final Drawable newDrawable(Resources resources, Theme theme) {
            C7445i c7445i = new C7445i();
            c7445i.f1703uJ = (VectorDrawable) this.f96uE.newDrawable(resources, theme);
            return c7445i;
        }

        public final boolean canApplyTheme() {
            return this.f96uE.canApplyTheme();
        }

        public final int getChangingConfigurations() {
            return this.f96uE.getChangingConfigurations();
        }
    }

    /* renamed from: android.support.c.a.i$a */
    static class C6165a extends C0241d {
        public C6165a(C6165a c6165a) {
            super(c6165a);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final void mo13709a(TypedArray typedArray) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f69vq = string;
            }
            string = typedArray.getString(1);
            if (string != null) {
                this.f68vp = C0287c.m486L(string);
            }
        }

        /* renamed from: cG */
        public final boolean mo349cG() {
            return true;
        }
    }

    /* renamed from: android.support.c.a.i$b */
    static class C6166b extends C0241d {
        /* renamed from: uU */
        private int[] f1704uU;
        /* renamed from: uV */
        int f1705uV = 0;
        /* renamed from: uW */
        float f1706uW = 0.0f;
        /* renamed from: uX */
        int f1707uX = 0;
        /* renamed from: uY */
        float f1708uY = 1.0f;
        /* renamed from: uZ */
        int f1709uZ = 0;
        /* renamed from: va */
        float f1710va = 1.0f;
        /* renamed from: vb */
        float f1711vb = 0.0f;
        /* renamed from: vc */
        float f1712vc = 1.0f;
        /* renamed from: vd */
        float f1713vd = 0.0f;
        /* renamed from: ve */
        Cap f1714ve = Cap.BUTT;
        /* renamed from: vf */
        Join f1715vf = Join.MITER;
        /* renamed from: vg */
        float f1716vg = 4.0f;

        public C6166b(C6166b c6166b) {
            super(c6166b);
            this.f1704uU = c6166b.f1704uU;
            this.f1705uV = c6166b.f1705uV;
            this.f1706uW = c6166b.f1706uW;
            this.f1708uY = c6166b.f1708uY;
            this.f1707uX = c6166b.f1707uX;
            this.f1709uZ = c6166b.f1709uZ;
            this.f1710va = c6166b.f1710va;
            this.f1711vb = c6166b.f1711vb;
            this.f1712vc = c6166b.f1712vc;
            this.f1713vd = c6166b.f1713vd;
            this.f1714ve = c6166b.f1714ve;
            this.f1715vf = c6166b.f1715vf;
            this.f1716vg = c6166b.f1716vg;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final void mo13710a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f1704uU = null;
            if (C0379c.m641a(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f69vq = string;
                }
                string = typedArray.getString(2);
                if (string != null) {
                    this.f68vp = C0287c.m486L(string);
                }
                this.f1707uX = C0379c.m642b(typedArray, xmlPullParser, "fillColor", 1, this.f1707uX);
                this.f1710va = C0379c.m635a(typedArray, xmlPullParser, "fillAlpha", 12, this.f1710va);
                int a = C0379c.m637a(typedArray, xmlPullParser, "strokeLineCap", 8, -1);
                Cap cap = this.f1714ve;
                switch (a) {
                    case 0:
                        cap = Cap.BUTT;
                        break;
                    case 1:
                        cap = Cap.ROUND;
                        break;
                    case 2:
                        cap = Cap.SQUARE;
                        break;
                }
                this.f1714ve = cap;
                a = C0379c.m637a(typedArray, xmlPullParser, "strokeLineJoin", 9, -1);
                Join join = this.f1715vf;
                switch (a) {
                    case 0:
                        join = Join.MITER;
                        break;
                    case 1:
                        join = Join.ROUND;
                        break;
                    case 2:
                        join = Join.BEVEL;
                        break;
                }
                this.f1715vf = join;
                this.f1716vg = C0379c.m635a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f1716vg);
                this.f1705uV = C0379c.m642b(typedArray, xmlPullParser, "strokeColor", 3, this.f1705uV);
                this.f1708uY = C0379c.m635a(typedArray, xmlPullParser, "strokeAlpha", 11, this.f1708uY);
                this.f1706uW = C0379c.m635a(typedArray, xmlPullParser, "strokeWidth", 4, this.f1706uW);
                this.f1712vc = C0379c.m635a(typedArray, xmlPullParser, "trimPathEnd", 6, this.f1712vc);
                this.f1713vd = C0379c.m635a(typedArray, xmlPullParser, "trimPathOffset", 7, this.f1713vd);
                this.f1711vb = C0379c.m635a(typedArray, xmlPullParser, "trimPathStart", 5, this.f1711vb);
                this.f1709uZ = C0379c.m637a(typedArray, xmlPullParser, "fillType", 13, this.f1709uZ);
            }
        }
    }

    public final /* bridge */ /* synthetic */ void applyTheme(Theme theme) {
        super.applyTheme(theme);
    }

    public final /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public final /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public final /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public final /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public final /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public final /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public final /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public final /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public final /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public final /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public final /* bridge */ /* synthetic */ void setColorFilter(int i, Mode mode) {
        super.setColorFilter(i, mode);
    }

    public final /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public final /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public final /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public final /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    C7445i() {
        this.f2034uP = true;
        this.f2036uR = new float[9];
        this.f2037uS = new Matrix();
        this.f2038uT = new Rect();
        this.f2030uL = new C0243f();
    }

    C7445i(C0243f c0243f) {
        this.f2034uP = true;
        this.f2036uR = new float[9];
        this.f2037uS = new Matrix();
        this.f2038uT = new Rect();
        this.f2030uL = c0243f;
        this.f2031uM = m12688a(c0243f.f86vH, c0243f.f87vI);
    }

    public final Drawable mutate() {
        if (this.f1703uJ != null) {
            this.f1703uJ.mutate();
        } else if (!this.f2033uO && super.mutate() == this) {
            this.f2030uL = new C0243f(this.f2030uL);
            this.f2033uO = true;
        }
        return this;
    }

    public final ConstantState getConstantState() {
        if (this.f1703uJ != null && VERSION.SDK_INT >= 24) {
            return new C0244g(this.f1703uJ.getConstantState());
        }
        this.f2030uL.mChangingConfigurations = getChangingConfigurations();
        return this.f2030uL;
    }

    /* JADX WARNING: Missing block: B:34:0x00d3, code skipped:
            if (r1 == 0) goto L_0x00d5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void draw(Canvas canvas) {
        if (this.f1703uJ != null) {
            this.f1703uJ.draw(canvas);
            return;
        }
        copyBounds(this.f2038uT);
        if (this.f2038uT.width() > 0 && this.f2038uT.height() > 0) {
            ColorFilter colorFilter = this.f2032uN == null ? this.f2031uM : this.f2032uN;
            canvas.getMatrix(this.f2037uS);
            this.f2037uS.getValues(this.f2036uR);
            float abs = Math.abs(this.f2036uR[0]);
            float abs2 = Math.abs(this.f2036uR[4]);
            float abs3 = Math.abs(this.f2036uR[1]);
            float abs4 = Math.abs(this.f2036uR[3]);
            if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                abs2 = 1.0f;
                abs = 1.0f;
            }
            int height = (int) (abs2 * ((float) this.f2038uT.height()));
            int min = Math.min(2048, (int) (abs * ((float) this.f2038uT.width())));
            int min2 = Math.min(2048, height);
            if (min > 0 && min2 > 0) {
                Paint paint;
                int save = canvas.save();
                canvas.translate((float) this.f2038uT.left, (float) this.f2038uT.top);
                height = VERSION.SDK_INT >= 17 ? (isAutoMirrored() && C0280a.m468g(this) == 1) ? 1 : 0 : 0;
                if (height != 0) {
                    canvas.translate((float) this.f2038uT.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.f2038uT.offsetTo(0, 0);
                C0243f c0243f = this.f2030uL;
                if (c0243f.f89vK != null) {
                    if (min == c0243f.f89vK.getWidth() && min2 == c0243f.f89vK.getHeight()) {
                        height = 1;
                    } else {
                        height = 0;
                    }
                }
                c0243f.f89vK = Bitmap.createBitmap(min, min2, Config.ARGB_8888);
                c0243f.f94vP = true;
                if (this.f2034uP) {
                    C0243f c0243f2 = this.f2030uL;
                    if (!c0243f2.f94vP && c0243f2.f90vL == c0243f2.f86vH && c0243f2.f91vM == c0243f2.f87vI && c0243f2.f93vO == c0243f2.f88vJ && c0243f2.f92vN == c0243f2.f85vG.f74vD) {
                        height = 1;
                    } else {
                        height = 0;
                    }
                    if (height == 0) {
                        this.f2030uL.mo354p(min, min2);
                        c0243f2 = this.f2030uL;
                        c0243f2.f90vL = c0243f2.f86vH;
                        c0243f2.f91vM = c0243f2.f87vI;
                        c0243f2.f92vN = c0243f2.f85vG.f74vD;
                        c0243f2.f93vO = c0243f2.f88vJ;
                        c0243f2.f94vP = false;
                    }
                } else {
                    this.f2030uL.mo354p(min, min2);
                }
                c0243f = this.f2030uL;
                Rect rect = this.f2038uT;
                if (c0243f.f85vG.f74vD < 255) {
                    height = 1;
                } else {
                    height = 0;
                }
                if (height == 0 && colorFilter == null) {
                    paint = null;
                } else {
                    if (c0243f.f95vQ == null) {
                        c0243f.f95vQ = new Paint();
                        c0243f.f95vQ.setFilterBitmap(true);
                    }
                    c0243f.f95vQ.setAlpha(c0243f.f85vG.f74vD);
                    c0243f.f95vQ.setColorFilter(colorFilter);
                    paint = c0243f.f95vQ;
                }
                canvas.drawBitmap(c0243f.f89vK, null, rect, paint);
                canvas.restoreToCount(save);
            }
        }
    }

    public final int getAlpha() {
        if (this.f1703uJ != null) {
            return C0280a.m464c(this.f1703uJ);
        }
        return this.f2030uL.f85vG.f74vD;
    }

    public final void setAlpha(int i) {
        if (this.f1703uJ != null) {
            this.f1703uJ.setAlpha(i);
        } else if (this.f2030uL.f85vG.f74vD != i) {
            this.f2030uL.f85vG.f74vD = i;
            invalidateSelf();
        }
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.f1703uJ != null) {
            this.f1703uJ.setColorFilter(colorFilter);
            return;
        }
        this.f2032uN = colorFilter;
        invalidateSelf();
    }

    /* renamed from: a */
    private PorterDuffColorFilter m12688a(ColorStateList colorStateList, Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public final void setTint(int i) {
        if (this.f1703uJ != null) {
            C0280a.m455a(this.f1703uJ, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    public final void setTintList(ColorStateList colorStateList) {
        if (this.f1703uJ != null) {
            C0280a.m457a(this.f1703uJ, colorStateList);
            return;
        }
        C0243f c0243f = this.f2030uL;
        if (c0243f.f86vH != colorStateList) {
            c0243f.f86vH = colorStateList;
            this.f2031uM = m12688a(colorStateList, c0243f.f87vI);
            invalidateSelf();
        }
    }

    public final void setTintMode(Mode mode) {
        if (this.f1703uJ != null) {
            C0280a.m460a(this.f1703uJ, mode);
            return;
        }
        C0243f c0243f = this.f2030uL;
        if (c0243f.f87vI != mode) {
            c0243f.f87vI = mode;
            this.f2031uM = m12688a(c0243f.f86vH, mode);
            invalidateSelf();
        }
    }

    public final boolean isStateful() {
        if (this.f1703uJ != null) {
            return this.f1703uJ.isStateful();
        }
        return super.isStateful() || !(this.f2030uL == null || this.f2030uL.f86vH == null || !this.f2030uL.f86vH.isStateful());
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean onStateChange(int[] iArr) {
        if (this.f1703uJ != null) {
            return this.f1703uJ.setState(iArr);
        }
        C0243f c0243f = this.f2030uL;
        if (c0243f.f86vH == null || c0243f.f87vI == null) {
            return false;
        }
        this.f2031uM = m12688a(c0243f.f86vH, c0243f.f87vI);
        invalidateSelf();
        return true;
    }

    public final int getOpacity() {
        if (this.f1703uJ != null) {
            return this.f1703uJ.getOpacity();
        }
        return -3;
    }

    public final int getIntrinsicWidth() {
        if (this.f1703uJ != null) {
            return this.f1703uJ.getIntrinsicWidth();
        }
        return (int) this.f2030uL.f85vG.f84vz;
    }

    public final int getIntrinsicHeight() {
        if (this.f1703uJ != null) {
            return this.f1703uJ.getIntrinsicHeight();
        }
        return (int) this.f2030uL.f85vG.f71vA;
    }

    public final boolean canApplyTheme() {
        if (this.f1703uJ != null) {
            C0280a.m465d(this.f1703uJ);
        }
        return false;
    }

    public final boolean isAutoMirrored() {
        if (this.f1703uJ != null) {
            return C0280a.m462b(this.f1703uJ);
        }
        return this.f2030uL.f88vJ;
    }

    public final void setAutoMirrored(boolean z) {
        if (this.f1703uJ != null) {
            C0280a.m461a(this.f1703uJ, z);
        } else {
            this.f2030uL.f88vJ = z;
        }
    }

    /* renamed from: a */
    public static C7445i m12689a(Resources resources, int i, Theme theme) {
        if (VERSION.SDK_INT >= 24) {
            C7445i c7445i = new C7445i();
            c7445i.f1703uJ = C0378b.m634b(resources, i, theme);
            c7445i.f2035uQ = new C0244g(c7445i.f1703uJ.getConstantState());
            return c7445i;
        }
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
            if (next == 2) {
                return C7445i.m12690a(resources, xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException | XmlPullParserException e) {
            return null;
        }
    }

    /* renamed from: a */
    public static C7445i m12690a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        C7445i c7445i = new C7445i();
        c7445i.inflate(resources, xmlPullParser, attributeSet, theme);
        return c7445i;
    }

    /* renamed from: d */
    static int m12692d(int i, float f) {
        return (((int) (((float) Color.alpha(i)) * f)) << 24) | (16777215 & i);
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        if (this.f1703uJ != null) {
            this.f1703uJ.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        if (this.f1703uJ != null) {
            C0280a.m459a(this.f1703uJ, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        C0243f c0243f = this.f2030uL;
        c0243f.f85vG = new C0242e();
        TypedArray a = C0379c.m638a(resources, theme, attributeSet, C0230a.f36ug);
        C0243f c0243f2 = this.f2030uL;
        C0242e c0242e = c0243f2.f85vG;
        int a2 = C0379c.m637a(a, xmlPullParser, "tintMode", 6, -1);
        Mode mode = Mode.SRC_IN;
        switch (a2) {
            case 3:
                mode = Mode.SRC_OVER;
                break;
            case 5:
                mode = Mode.SRC_IN;
                break;
            case 9:
                mode = Mode.SRC_ATOP;
                break;
            case 14:
                mode = Mode.MULTIPLY;
                break;
            case 15:
                mode = Mode.SCREEN;
                break;
            case 16:
                mode = Mode.ADD;
                break;
        }
        c0243f2.f87vI = mode;
        ColorStateList colorStateList = a.getColorStateList(1);
        if (colorStateList != null) {
            c0243f2.f86vH = colorStateList;
        }
        c0243f2.f88vJ = C0379c.m640a(a, xmlPullParser, "autoMirrored", 5, c0243f2.f88vJ);
        c0242e.f72vB = C0379c.m635a(a, xmlPullParser, "viewportWidth", 7, c0242e.f72vB);
        c0242e.f73vC = C0379c.m635a(a, xmlPullParser, "viewportHeight", 8, c0242e.f73vC);
        if (c0242e.f72vB <= 0.0f) {
            throw new XmlPullParserException(a.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (c0242e.f73vC <= 0.0f) {
            throw new XmlPullParserException(a.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        } else {
            c0242e.f84vz = a.getDimension(3, c0242e.f84vz);
            c0242e.f71vA = a.getDimension(2, c0242e.f71vA);
            if (c0242e.f84vz <= 0.0f) {
                throw new XmlPullParserException(a.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (c0242e.f71vA <= 0.0f) {
                throw new XmlPullParserException(a.getPositionDescription() + "<vector> tag requires height > 0");
            } else {
                c0242e.f74vD = (int) (C0379c.m635a(a, xmlPullParser, "alpha", 4, ((float) c0242e.f74vD) / 255.0f) * 255.0f);
                String string = a.getString(0);
                if (string != null) {
                    c0242e.f75vE = string;
                    c0242e.f76vF.put(string, c0242e);
                }
                a.recycle();
                c0243f.mChangingConfigurations = getChangingConfigurations();
                c0243f.f94vP = true;
                m12691b(resources, xmlPullParser, attributeSet, theme);
                this.f2031uM = m12688a(c0243f.f86vH, c0243f.f87vI);
            }
        }
    }

    /* renamed from: b */
    private void m12691b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        C0243f c0243f = this.f2030uL;
        C0242e c0242e = c0243f.f85vG;
        Object obj = 1;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(c0242e.f83vy);
        int depth = xmlPullParser.getDepth() + 1;
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            Object obj2;
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                C0240c c0240c = (C0240c) arrayDeque.peek();
                TypedArray a;
                if ("path".equals(name)) {
                    C6166b c6166b = new C6166b();
                    TypedArray a2 = C0379c.m638a(resources, theme, attributeSet, C0230a.f38uj);
                    c6166b.mo13710a(a2, xmlPullParser);
                    a2.recycle();
                    c0240c.f58kx.add(c6166b);
                    if (c6166b.f69vq != null) {
                        c0242e.f76vF.put(c6166b.f69vq, c6166b);
                    }
                    obj2 = null;
                    c0243f.mChangingConfigurations = c6166b.mChangingConfigurations | c0243f.mChangingConfigurations;
                } else if ("clip-path".equals(name)) {
                    C6165a c6165a = new C6165a();
                    if (C0379c.m641a(xmlPullParser, "pathData")) {
                        a = C0379c.m638a(resources, theme, attributeSet, C0230a.f39uk);
                        c6165a.mo13709a(a);
                        a.recycle();
                    }
                    c0240c.f58kx.add(c6165a);
                    if (c6165a.f69vq != null) {
                        c0242e.f76vF.put(c6165a.f69vq, c6165a);
                    }
                    c0243f.mChangingConfigurations |= c6165a.mChangingConfigurations;
                    obj2 = obj;
                } else {
                    if ("group".equals(name)) {
                        C0240c c0240c2 = new C0240c();
                        a = C0379c.m638a(resources, theme, attributeSet, C0230a.f37uh);
                        c0240c2.f59uU = null;
                        c0240c2.f61vi = C0379c.m635a(a, xmlPullParser, "rotation", 5, c0240c2.f61vi);
                        c0240c2.f62vj = a.getFloat(1, c0240c2.f62vj);
                        c0240c2.f63vk = a.getFloat(2, c0240c2.f63vk);
                        c0240c2.mScaleX = C0379c.m635a(a, xmlPullParser, "scaleX", 3, c0240c2.mScaleX);
                        c0240c2.mScaleY = C0379c.m635a(a, xmlPullParser, "scaleY", 4, c0240c2.mScaleY);
                        c0240c2.f64vl = C0379c.m635a(a, xmlPullParser, "translateX", 6, c0240c2.f64vl);
                        c0240c2.f65vm = C0379c.m635a(a, xmlPullParser, "translateY", 7, c0240c2.f65vm);
                        String string = a.getString(0);
                        if (string != null) {
                            c0240c2.f67vo = string;
                        }
                        c0240c2.f66vn.reset();
                        c0240c2.f66vn.postTranslate(-c0240c2.f62vj, -c0240c2.f63vk);
                        c0240c2.f66vn.postScale(c0240c2.mScaleX, c0240c2.mScaleY);
                        c0240c2.f66vn.postRotate(c0240c2.f61vi, 0.0f, 0.0f);
                        c0240c2.f66vn.postTranslate(c0240c2.f64vl + c0240c2.f62vj, c0240c2.f65vm + c0240c2.f63vk);
                        a.recycle();
                        c0240c.f58kx.add(c0240c2);
                        arrayDeque.push(c0240c2);
                        if (c0240c2.f67vo != null) {
                            c0242e.f76vF.put(c0240c2.f67vo, c0240c2);
                        }
                        c0243f.mChangingConfigurations |= c0240c2.mChangingConfigurations;
                    }
                    obj2 = obj;
                }
            } else {
                if (eventType == 3) {
                    if ("group".equals(xmlPullParser.getName())) {
                        arrayDeque.pop();
                    }
                }
                obj2 = obj;
            }
            eventType = xmlPullParser.next();
            obj = obj2;
        }
        if (obj != null) {
            throw new XmlPullParserException("no path defined");
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void onBoundsChange(Rect rect) {
        if (this.f1703uJ != null) {
            this.f1703uJ.setBounds(rect);
        }
    }

    public final int getChangingConfigurations() {
        if (this.f1703uJ != null) {
            return this.f1703uJ.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f2030uL.getChangingConfigurations();
    }

    public final void invalidateSelf() {
        if (this.f1703uJ != null) {
            this.f1703uJ.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public final void scheduleSelf(Runnable runnable, long j) {
        if (this.f1703uJ != null) {
            this.f1703uJ.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    public final boolean setVisible(boolean z, boolean z2) {
        if (this.f1703uJ != null) {
            return this.f1703uJ.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    public final void unscheduleSelf(Runnable runnable) {
        if (this.f1703uJ != null) {
            this.f1703uJ.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}

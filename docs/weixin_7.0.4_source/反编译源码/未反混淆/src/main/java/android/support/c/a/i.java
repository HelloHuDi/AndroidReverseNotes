package android.support.c.a;

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
import android.util.AttributeSet;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class i extends h {
    static final Mode uK = Mode.SRC_IN;
    f uL;
    private PorterDuffColorFilter uM;
    private ColorFilter uN;
    private boolean uO;
    boolean uP;
    private ConstantState uQ;
    private final float[] uR;
    private final Matrix uS;
    private final Rect uT;

    static class c {
        final ArrayList<Object> kx = new ArrayList();
        int mChangingConfigurations;
        float mScaleX = 1.0f;
        float mScaleY = 1.0f;
        int[] uU;
        final Matrix vh = new Matrix();
        float vi = 0.0f;
        float vj = 0.0f;
        float vk = 0.0f;
        float vl = 0.0f;
        float vm = 0.0f;
        final Matrix vn = new Matrix();
        String vo = null;

        public c(c cVar, android.support.v4.f.a<String, Object> aVar) {
            this.vi = cVar.vi;
            this.vj = cVar.vj;
            this.vk = cVar.vk;
            this.mScaleX = cVar.mScaleX;
            this.mScaleY = cVar.mScaleY;
            this.vl = cVar.vl;
            this.vm = cVar.vm;
            this.uU = cVar.uU;
            this.vo = cVar.vo;
            this.mChangingConfigurations = cVar.mChangingConfigurations;
            if (this.vo != null) {
                aVar.put(this.vo, this);
            }
            this.vn.set(cVar.vn);
            ArrayList arrayList = cVar.kx;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    Object obj = arrayList.get(i2);
                    if (obj instanceof c) {
                        this.kx.add(new c((c) obj, aVar));
                    } else {
                        if (obj instanceof b) {
                            obj = new b((b) obj);
                        } else if (obj instanceof a) {
                            a aVar2 = new a((a) obj);
                        } else {
                            throw new IllegalStateException("Unknown object in the tree!");
                        }
                        this.kx.add(obj);
                        if (obj.vq != null) {
                            aVar.put(obj.vq, obj);
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    static class d {
        int mChangingConfigurations;
        protected android.support.v4.a.c.b[] vp = null;
        String vq;

        public d(d dVar) {
            this.vq = dVar.vq;
            this.mChangingConfigurations = dVar.mChangingConfigurations;
            this.vp = android.support.v4.a.c.a(dVar.vp);
        }

        public final void b(Path path) {
            path.reset();
            if (this.vp != null) {
                android.support.v4.a.c.b.a(this.vp, path);
            }
        }

        public boolean cG() {
            return false;
        }
    }

    static class e {
        private static final Matrix vt = new Matrix();
        private int mChangingConfigurations;
        float vA;
        float vB;
        float vC;
        int vD;
        String vE;
        final android.support.v4.f.a<String, Object> vF;
        private final Path vr;
        private final Path vs;
        private final Matrix vu;
        private Paint vv;
        private Paint vw;
        private PathMeasure vx;
        final c vy;
        float vz;

        public e() {
            this.vu = new Matrix();
            this.vz = 0.0f;
            this.vA = 0.0f;
            this.vB = 0.0f;
            this.vC = 0.0f;
            this.vD = 255;
            this.vE = null;
            this.vF = new android.support.v4.f.a();
            this.vy = new c();
            this.vr = new Path();
            this.vs = new Path();
        }

        public e(e eVar) {
            this.vu = new Matrix();
            this.vz = 0.0f;
            this.vA = 0.0f;
            this.vB = 0.0f;
            this.vC = 0.0f;
            this.vD = 255;
            this.vE = null;
            this.vF = new android.support.v4.f.a();
            this.vy = new c(eVar.vy, this.vF);
            this.vr = new Path(eVar.vr);
            this.vs = new Path(eVar.vs);
            this.vz = eVar.vz;
            this.vA = eVar.vA;
            this.vB = eVar.vB;
            this.vC = eVar.vC;
            this.mChangingConfigurations = eVar.mChangingConfigurations;
            this.vD = eVar.vD;
            this.vE = eVar.vE;
            if (eVar.vE != null) {
                this.vF.put(eVar.vE, this);
            }
        }

        public final void a(Canvas canvas, int i, int i2) {
            a(this.vy, vt, canvas, i, i2, null);
        }

        private void a(c cVar, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            cVar.vh.set(matrix);
            cVar.vh.preConcat(cVar.vn);
            canvas.save();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < cVar.kx.size()) {
                    Object obj = cVar.kx.get(i4);
                    if (obj instanceof c) {
                        a((c) obj, cVar.vh, canvas, i, i2, colorFilter);
                    } else if (obj instanceof d) {
                        d dVar = (d) obj;
                        float f = ((float) i) / this.vB;
                        float f2 = ((float) i2) / this.vC;
                        float min = Math.min(f, f2);
                        Matrix matrix2 = cVar.vh;
                        this.vu.set(matrix2);
                        this.vu.postScale(f, f2);
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
                            dVar.b(this.vr);
                            Path path = this.vr;
                            this.vs.reset();
                            if (dVar.cG()) {
                                this.vs.addPath(path, this.vu);
                                canvas.clipPath(this.vs);
                            } else {
                                b bVar = (b) dVar;
                                if (!(bVar.vb == 0.0f && bVar.vc == 1.0f)) {
                                    float f4 = (bVar.vb + bVar.vd) % 1.0f;
                                    f3 = (bVar.vc + bVar.vd) % 1.0f;
                                    if (this.vx == null) {
                                        this.vx = new PathMeasure();
                                    }
                                    this.vx.setPath(this.vr, false);
                                    float length = this.vx.getLength();
                                    f4 *= length;
                                    f3 *= length;
                                    path.reset();
                                    if (f4 > f3) {
                                        this.vx.getSegment(f4, length, path, true);
                                        this.vx.getSegment(0.0f, f3, path, true);
                                    } else {
                                        this.vx.getSegment(f4, f3, path, true);
                                    }
                                    path.rLineTo(0.0f, 0.0f);
                                }
                                this.vs.addPath(path, this.vu);
                                if (bVar.uX != 0) {
                                    if (this.vw == null) {
                                        this.vw = new Paint();
                                        this.vw.setStyle(Style.FILL);
                                        this.vw.setAntiAlias(true);
                                    }
                                    Paint paint = this.vw;
                                    paint.setColor(i.d(bVar.uX, bVar.va));
                                    paint.setColorFilter(colorFilter);
                                    this.vs.setFillType(bVar.uZ == 0 ? FillType.WINDING : FillType.EVEN_ODD);
                                    canvas.drawPath(this.vs, paint);
                                }
                                if (bVar.uV != 0) {
                                    if (this.vv == null) {
                                        this.vv = new Paint();
                                        this.vv.setStyle(Style.STROKE);
                                        this.vv.setAntiAlias(true);
                                    }
                                    Paint paint2 = this.vv;
                                    if (bVar.vf != null) {
                                        paint2.setStrokeJoin(bVar.vf);
                                    }
                                    if (bVar.ve != null) {
                                        paint2.setStrokeCap(bVar.ve);
                                    }
                                    paint2.setStrokeMiter(bVar.vg);
                                    paint2.setColor(i.d(bVar.uV, bVar.uY));
                                    paint2.setColorFilter(colorFilter);
                                    paint2.setStrokeWidth(bVar.uW * (f2 * min));
                                    canvas.drawPath(this.vs, paint2);
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

    static class f extends ConstantState {
        int mChangingConfigurations;
        e vG;
        ColorStateList vH;
        Mode vI;
        boolean vJ;
        Bitmap vK;
        ColorStateList vL;
        Mode vM;
        int vN;
        boolean vO;
        boolean vP;
        Paint vQ;

        public f(f fVar) {
            this.vH = null;
            this.vI = i.uK;
            if (fVar != null) {
                this.mChangingConfigurations = fVar.mChangingConfigurations;
                this.vG = new e(fVar.vG);
                if (fVar.vG.vw != null) {
                    this.vG.vw = new Paint(fVar.vG.vw);
                }
                if (fVar.vG.vv != null) {
                    this.vG.vv = new Paint(fVar.vG.vv);
                }
                this.vH = fVar.vH;
                this.vI = fVar.vI;
                this.vJ = fVar.vJ;
            }
        }

        public final void p(int i, int i2) {
            this.vK.eraseColor(0);
            this.vG.a(new Canvas(this.vK), i, i2);
        }

        public f() {
            this.vH = null;
            this.vI = i.uK;
            this.vG = new e();
        }

        public final Drawable newDrawable() {
            return new i(this);
        }

        public final Drawable newDrawable(Resources resources) {
            return new i(this);
        }

        public final int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }
    }

    static class g extends ConstantState {
        private final ConstantState uE;

        public g(ConstantState constantState) {
            this.uE = constantState;
        }

        public final Drawable newDrawable() {
            i iVar = new i();
            iVar.uJ = (VectorDrawable) this.uE.newDrawable();
            return iVar;
        }

        public final Drawable newDrawable(Resources resources) {
            i iVar = new i();
            iVar.uJ = (VectorDrawable) this.uE.newDrawable(resources);
            return iVar;
        }

        public final Drawable newDrawable(Resources resources, Theme theme) {
            i iVar = new i();
            iVar.uJ = (VectorDrawable) this.uE.newDrawable(resources, theme);
            return iVar;
        }

        public final boolean canApplyTheme() {
            return this.uE.canApplyTheme();
        }

        public final int getChangingConfigurations() {
            return this.uE.getChangingConfigurations();
        }
    }

    static class a extends d {
        public a(a aVar) {
            super(aVar);
        }

        /* Access modifiers changed, original: final */
        public final void a(TypedArray typedArray) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.vq = string;
            }
            string = typedArray.getString(1);
            if (string != null) {
                this.vp = android.support.v4.a.c.L(string);
            }
        }

        public final boolean cG() {
            return true;
        }
    }

    static class b extends d {
        private int[] uU;
        int uV = 0;
        float uW = 0.0f;
        int uX = 0;
        float uY = 1.0f;
        int uZ = 0;
        float va = 1.0f;
        float vb = 0.0f;
        float vc = 1.0f;
        float vd = 0.0f;
        Cap ve = Cap.BUTT;
        Join vf = Join.MITER;
        float vg = 4.0f;

        public b(b bVar) {
            super(bVar);
            this.uU = bVar.uU;
            this.uV = bVar.uV;
            this.uW = bVar.uW;
            this.uY = bVar.uY;
            this.uX = bVar.uX;
            this.uZ = bVar.uZ;
            this.va = bVar.va;
            this.vb = bVar.vb;
            this.vc = bVar.vc;
            this.vd = bVar.vd;
            this.ve = bVar.ve;
            this.vf = bVar.vf;
            this.vg = bVar.vg;
        }

        /* Access modifiers changed, original: final */
        public final void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.uU = null;
            if (android.support.v4.content.a.c.a(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.vq = string;
                }
                string = typedArray.getString(2);
                if (string != null) {
                    this.vp = android.support.v4.a.c.L(string);
                }
                this.uX = android.support.v4.content.a.c.b(typedArray, xmlPullParser, "fillColor", 1, this.uX);
                this.va = android.support.v4.content.a.c.a(typedArray, xmlPullParser, "fillAlpha", 12, this.va);
                int a = android.support.v4.content.a.c.a(typedArray, xmlPullParser, "strokeLineCap", 8, -1);
                Cap cap = this.ve;
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
                this.ve = cap;
                a = android.support.v4.content.a.c.a(typedArray, xmlPullParser, "strokeLineJoin", 9, -1);
                Join join = this.vf;
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
                this.vf = join;
                this.vg = android.support.v4.content.a.c.a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.vg);
                this.uV = android.support.v4.content.a.c.b(typedArray, xmlPullParser, "strokeColor", 3, this.uV);
                this.uY = android.support.v4.content.a.c.a(typedArray, xmlPullParser, "strokeAlpha", 11, this.uY);
                this.uW = android.support.v4.content.a.c.a(typedArray, xmlPullParser, "strokeWidth", 4, this.uW);
                this.vc = android.support.v4.content.a.c.a(typedArray, xmlPullParser, "trimPathEnd", 6, this.vc);
                this.vd = android.support.v4.content.a.c.a(typedArray, xmlPullParser, "trimPathOffset", 7, this.vd);
                this.vb = android.support.v4.content.a.c.a(typedArray, xmlPullParser, "trimPathStart", 5, this.vb);
                this.uZ = android.support.v4.content.a.c.a(typedArray, xmlPullParser, "fillType", 13, this.uZ);
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

    i() {
        this.uP = true;
        this.uR = new float[9];
        this.uS = new Matrix();
        this.uT = new Rect();
        this.uL = new f();
    }

    i(f fVar) {
        this.uP = true;
        this.uR = new float[9];
        this.uS = new Matrix();
        this.uT = new Rect();
        this.uL = fVar;
        this.uM = a(fVar.vH, fVar.vI);
    }

    public final Drawable mutate() {
        if (this.uJ != null) {
            this.uJ.mutate();
        } else if (!this.uO && super.mutate() == this) {
            this.uL = new f(this.uL);
            this.uO = true;
        }
        return this;
    }

    public final ConstantState getConstantState() {
        if (this.uJ != null && VERSION.SDK_INT >= 24) {
            return new g(this.uJ.getConstantState());
        }
        this.uL.mChangingConfigurations = getChangingConfigurations();
        return this.uL;
    }

    /* JADX WARNING: Missing block: B:34:0x00d3, code skipped:
            if (r1 == 0) goto L_0x00d5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void draw(Canvas canvas) {
        if (this.uJ != null) {
            this.uJ.draw(canvas);
            return;
        }
        copyBounds(this.uT);
        if (this.uT.width() > 0 && this.uT.height() > 0) {
            ColorFilter colorFilter = this.uN == null ? this.uM : this.uN;
            canvas.getMatrix(this.uS);
            this.uS.getValues(this.uR);
            float abs = Math.abs(this.uR[0]);
            float abs2 = Math.abs(this.uR[4]);
            float abs3 = Math.abs(this.uR[1]);
            float abs4 = Math.abs(this.uR[3]);
            if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                abs2 = 1.0f;
                abs = 1.0f;
            }
            int height = (int) (abs2 * ((float) this.uT.height()));
            int min = Math.min(2048, (int) (abs * ((float) this.uT.width())));
            int min2 = Math.min(2048, height);
            if (min > 0 && min2 > 0) {
                Paint paint;
                int save = canvas.save();
                canvas.translate((float) this.uT.left, (float) this.uT.top);
                height = VERSION.SDK_INT >= 17 ? (isAutoMirrored() && android.support.v4.a.a.a.g(this) == 1) ? 1 : 0 : 0;
                if (height != 0) {
                    canvas.translate((float) this.uT.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.uT.offsetTo(0, 0);
                f fVar = this.uL;
                if (fVar.vK != null) {
                    if (min == fVar.vK.getWidth() && min2 == fVar.vK.getHeight()) {
                        height = 1;
                    } else {
                        height = 0;
                    }
                }
                fVar.vK = Bitmap.createBitmap(min, min2, Config.ARGB_8888);
                fVar.vP = true;
                if (this.uP) {
                    f fVar2 = this.uL;
                    if (!fVar2.vP && fVar2.vL == fVar2.vH && fVar2.vM == fVar2.vI && fVar2.vO == fVar2.vJ && fVar2.vN == fVar2.vG.vD) {
                        height = 1;
                    } else {
                        height = 0;
                    }
                    if (height == 0) {
                        this.uL.p(min, min2);
                        fVar2 = this.uL;
                        fVar2.vL = fVar2.vH;
                        fVar2.vM = fVar2.vI;
                        fVar2.vN = fVar2.vG.vD;
                        fVar2.vO = fVar2.vJ;
                        fVar2.vP = false;
                    }
                } else {
                    this.uL.p(min, min2);
                }
                fVar = this.uL;
                Rect rect = this.uT;
                if (fVar.vG.vD < 255) {
                    height = 1;
                } else {
                    height = 0;
                }
                if (height == 0 && colorFilter == null) {
                    paint = null;
                } else {
                    if (fVar.vQ == null) {
                        fVar.vQ = new Paint();
                        fVar.vQ.setFilterBitmap(true);
                    }
                    fVar.vQ.setAlpha(fVar.vG.vD);
                    fVar.vQ.setColorFilter(colorFilter);
                    paint = fVar.vQ;
                }
                canvas.drawBitmap(fVar.vK, null, rect, paint);
                canvas.restoreToCount(save);
            }
        }
    }

    public final int getAlpha() {
        if (this.uJ != null) {
            return android.support.v4.a.a.a.c(this.uJ);
        }
        return this.uL.vG.vD;
    }

    public final void setAlpha(int i) {
        if (this.uJ != null) {
            this.uJ.setAlpha(i);
        } else if (this.uL.vG.vD != i) {
            this.uL.vG.vD = i;
            invalidateSelf();
        }
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.uJ != null) {
            this.uJ.setColorFilter(colorFilter);
            return;
        }
        this.uN = colorFilter;
        invalidateSelf();
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public final void setTint(int i) {
        if (this.uJ != null) {
            android.support.v4.a.a.a.a(this.uJ, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    public final void setTintList(ColorStateList colorStateList) {
        if (this.uJ != null) {
            android.support.v4.a.a.a.a(this.uJ, colorStateList);
            return;
        }
        f fVar = this.uL;
        if (fVar.vH != colorStateList) {
            fVar.vH = colorStateList;
            this.uM = a(colorStateList, fVar.vI);
            invalidateSelf();
        }
    }

    public final void setTintMode(Mode mode) {
        if (this.uJ != null) {
            android.support.v4.a.a.a.a(this.uJ, mode);
            return;
        }
        f fVar = this.uL;
        if (fVar.vI != mode) {
            fVar.vI = mode;
            this.uM = a(fVar.vH, mode);
            invalidateSelf();
        }
    }

    public final boolean isStateful() {
        if (this.uJ != null) {
            return this.uJ.isStateful();
        }
        return super.isStateful() || !(this.uL == null || this.uL.vH == null || !this.uL.vH.isStateful());
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean onStateChange(int[] iArr) {
        if (this.uJ != null) {
            return this.uJ.setState(iArr);
        }
        f fVar = this.uL;
        if (fVar.vH == null || fVar.vI == null) {
            return false;
        }
        this.uM = a(fVar.vH, fVar.vI);
        invalidateSelf();
        return true;
    }

    public final int getOpacity() {
        if (this.uJ != null) {
            return this.uJ.getOpacity();
        }
        return -3;
    }

    public final int getIntrinsicWidth() {
        if (this.uJ != null) {
            return this.uJ.getIntrinsicWidth();
        }
        return (int) this.uL.vG.vz;
    }

    public final int getIntrinsicHeight() {
        if (this.uJ != null) {
            return this.uJ.getIntrinsicHeight();
        }
        return (int) this.uL.vG.vA;
    }

    public final boolean canApplyTheme() {
        if (this.uJ != null) {
            android.support.v4.a.a.a.d(this.uJ);
        }
        return false;
    }

    public final boolean isAutoMirrored() {
        if (this.uJ != null) {
            return android.support.v4.a.a.a.b(this.uJ);
        }
        return this.uL.vJ;
    }

    public final void setAutoMirrored(boolean z) {
        if (this.uJ != null) {
            android.support.v4.a.a.a.a(this.uJ, z);
        } else {
            this.uL.vJ = z;
        }
    }

    public static i a(Resources resources, int i, Theme theme) {
        if (VERSION.SDK_INT >= 24) {
            i iVar = new i();
            iVar.uJ = android.support.v4.content.a.b.b(resources, i, theme);
            iVar.uQ = new g(iVar.uJ.getConstantState());
            return iVar;
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
                return a(resources, xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException | XmlPullParserException e) {
            return null;
        }
    }

    public static i a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        i iVar = new i();
        iVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return iVar;
    }

    static int d(int i, float f) {
        return (((int) (((float) Color.alpha(i)) * f)) << 24) | (16777215 & i);
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        if (this.uJ != null) {
            this.uJ.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        if (this.uJ != null) {
            android.support.v4.a.a.a.a(this.uJ, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        f fVar = this.uL;
        fVar.vG = new e();
        TypedArray a = android.support.v4.content.a.c.a(resources, theme, attributeSet, a.ug);
        f fVar2 = this.uL;
        e eVar = fVar2.vG;
        int a2 = android.support.v4.content.a.c.a(a, xmlPullParser, "tintMode", 6, -1);
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
        fVar2.vI = mode;
        ColorStateList colorStateList = a.getColorStateList(1);
        if (colorStateList != null) {
            fVar2.vH = colorStateList;
        }
        fVar2.vJ = android.support.v4.content.a.c.a(a, xmlPullParser, "autoMirrored", 5, fVar2.vJ);
        eVar.vB = android.support.v4.content.a.c.a(a, xmlPullParser, "viewportWidth", 7, eVar.vB);
        eVar.vC = android.support.v4.content.a.c.a(a, xmlPullParser, "viewportHeight", 8, eVar.vC);
        if (eVar.vB <= 0.0f) {
            throw new XmlPullParserException(a.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (eVar.vC <= 0.0f) {
            throw new XmlPullParserException(a.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        } else {
            eVar.vz = a.getDimension(3, eVar.vz);
            eVar.vA = a.getDimension(2, eVar.vA);
            if (eVar.vz <= 0.0f) {
                throw new XmlPullParserException(a.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (eVar.vA <= 0.0f) {
                throw new XmlPullParserException(a.getPositionDescription() + "<vector> tag requires height > 0");
            } else {
                eVar.vD = (int) (android.support.v4.content.a.c.a(a, xmlPullParser, "alpha", 4, ((float) eVar.vD) / 255.0f) * 255.0f);
                String string = a.getString(0);
                if (string != null) {
                    eVar.vE = string;
                    eVar.vF.put(string, eVar);
                }
                a.recycle();
                fVar.mChangingConfigurations = getChangingConfigurations();
                fVar.vP = true;
                b(resources, xmlPullParser, attributeSet, theme);
                this.uM = a(fVar.vH, fVar.vI);
            }
        }
    }

    private void b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        f fVar = this.uL;
        e eVar = fVar.vG;
        Object obj = 1;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(eVar.vy);
        int depth = xmlPullParser.getDepth() + 1;
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            Object obj2;
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                c cVar = (c) arrayDeque.peek();
                TypedArray a;
                if ("path".equals(name)) {
                    b bVar = new b();
                    TypedArray a2 = android.support.v4.content.a.c.a(resources, theme, attributeSet, a.uj);
                    bVar.a(a2, xmlPullParser);
                    a2.recycle();
                    cVar.kx.add(bVar);
                    if (bVar.vq != null) {
                        eVar.vF.put(bVar.vq, bVar);
                    }
                    obj2 = null;
                    fVar.mChangingConfigurations = bVar.mChangingConfigurations | fVar.mChangingConfigurations;
                } else if ("clip-path".equals(name)) {
                    a aVar = new a();
                    if (android.support.v4.content.a.c.a(xmlPullParser, "pathData")) {
                        a = android.support.v4.content.a.c.a(resources, theme, attributeSet, a.uk);
                        aVar.a(a);
                        a.recycle();
                    }
                    cVar.kx.add(aVar);
                    if (aVar.vq != null) {
                        eVar.vF.put(aVar.vq, aVar);
                    }
                    fVar.mChangingConfigurations |= aVar.mChangingConfigurations;
                    obj2 = obj;
                } else {
                    if ("group".equals(name)) {
                        c cVar2 = new c();
                        a = android.support.v4.content.a.c.a(resources, theme, attributeSet, a.uh);
                        cVar2.uU = null;
                        cVar2.vi = android.support.v4.content.a.c.a(a, xmlPullParser, "rotation", 5, cVar2.vi);
                        cVar2.vj = a.getFloat(1, cVar2.vj);
                        cVar2.vk = a.getFloat(2, cVar2.vk);
                        cVar2.mScaleX = android.support.v4.content.a.c.a(a, xmlPullParser, "scaleX", 3, cVar2.mScaleX);
                        cVar2.mScaleY = android.support.v4.content.a.c.a(a, xmlPullParser, "scaleY", 4, cVar2.mScaleY);
                        cVar2.vl = android.support.v4.content.a.c.a(a, xmlPullParser, "translateX", 6, cVar2.vl);
                        cVar2.vm = android.support.v4.content.a.c.a(a, xmlPullParser, "translateY", 7, cVar2.vm);
                        String string = a.getString(0);
                        if (string != null) {
                            cVar2.vo = string;
                        }
                        cVar2.vn.reset();
                        cVar2.vn.postTranslate(-cVar2.vj, -cVar2.vk);
                        cVar2.vn.postScale(cVar2.mScaleX, cVar2.mScaleY);
                        cVar2.vn.postRotate(cVar2.vi, 0.0f, 0.0f);
                        cVar2.vn.postTranslate(cVar2.vl + cVar2.vj, cVar2.vm + cVar2.vk);
                        a.recycle();
                        cVar.kx.add(cVar2);
                        arrayDeque.push(cVar2);
                        if (cVar2.vo != null) {
                            eVar.vF.put(cVar2.vo, cVar2);
                        }
                        fVar.mChangingConfigurations |= cVar2.mChangingConfigurations;
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
        if (this.uJ != null) {
            this.uJ.setBounds(rect);
        }
    }

    public final int getChangingConfigurations() {
        if (this.uJ != null) {
            return this.uJ.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.uL.getChangingConfigurations();
    }

    public final void invalidateSelf() {
        if (this.uJ != null) {
            this.uJ.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public final void scheduleSelf(Runnable runnable, long j) {
        if (this.uJ != null) {
            this.uJ.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    public final boolean setVisible(boolean z, boolean z2) {
        if (this.uJ != null) {
            return this.uJ.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    public final void unscheduleSelf(Runnable runnable) {
        if (this.uJ != null) {
            this.uJ.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}

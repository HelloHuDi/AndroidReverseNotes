package android.support.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

/* renamed from: android.support.transition.u */
final class C41500u<T> extends Property<T, Float> {
    /* renamed from: vx */
    private final PathMeasure f16775vx;
    /* renamed from: zb */
    private final Property<T, PointF> f16776zb;
    /* renamed from: zc */
    private final float f16777zc;
    /* renamed from: zd */
    private final float[] f16778zd = new float[2];
    /* renamed from: ze */
    private final PointF f16779ze = new PointF();
    /* renamed from: zf */
    private float f16780zf;

    public final /* synthetic */ void set(Object obj, Object obj2) {
        Float f = (Float) obj2;
        this.f16780zf = f.floatValue();
        this.f16775vx.getPosTan(this.f16777zc * f.floatValue(), this.f16778zd, null);
        this.f16779ze.x = this.f16778zd[0];
        this.f16779ze.y = this.f16778zd[1];
        this.f16776zb.set(obj, this.f16779ze);
    }

    C41500u(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.f16776zb = property;
        this.f16775vx = new PathMeasure(path, false);
        this.f16777zc = this.f16775vx.getLength();
    }

    public final /* synthetic */ Object get(Object obj) {
        return Float.valueOf(this.f16780zf);
    }
}

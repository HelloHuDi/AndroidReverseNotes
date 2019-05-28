package android.support.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

final class u<T> extends Property<T, Float> {
    private final PathMeasure vx;
    private final Property<T, PointF> zb;
    private final float zc;
    private final float[] zd = new float[2];
    private final PointF ze = new PointF();
    private float zf;

    public final /* synthetic */ void set(Object obj, Object obj2) {
        Float f = (Float) obj2;
        this.zf = f.floatValue();
        this.vx.getPosTan(this.zc * f.floatValue(), this.zd, null);
        this.ze.x = this.zd[0];
        this.ze.y = this.zd[1];
        this.zb.set(obj, this.ze);
    }

    u(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.zb = property;
        this.vx = new PathMeasure(path, false);
        this.zc = this.vx.getLength();
    }

    public final /* synthetic */ Object get(Object obj) {
        return Float.valueOf(this.zf);
    }
}

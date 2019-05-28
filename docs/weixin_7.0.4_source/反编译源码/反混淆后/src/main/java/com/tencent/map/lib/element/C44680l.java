package com.tencent.map.lib.element;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.mapstructure.TappedElement;
import com.tencent.map.lib.p822gl.model.GLIcon;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C16263gj;
import com.tencent.tencentmap.mapsdk.maps.p667a.C24374fw;
import com.tencent.tencentmap.mapsdk.maps.p667a.C44510ev;
import com.tencent.tencentmap.mapsdk.maps.p667a.C5876fn;

/* renamed from: com.tencent.map.lib.element.l */
public class C44680l implements C41717j {
    /* renamed from: a */
    protected C41719m f17552a;
    /* renamed from: b */
    protected GLIcon f17553b;
    /* renamed from: c */
    protected C17844n f17554c;
    /* renamed from: d */
    protected DoublePoint f17555d;
    /* renamed from: e */
    private C5876fn f17556e;
    /* renamed from: f */
    private boolean f17557f;
    /* renamed from: g */
    private C44510ev f17558g;

    public C44680l() {
        AppMethodBeat.m2504i(97883);
        this.f17555d = new DoublePoint();
        this.f17558g = null;
        this.f17557f = true;
        AppMethodBeat.m2505o(97883);
    }

    public C44680l(C41719m c41719m) {
        AppMethodBeat.m2504i(97884);
        this.f17555d = new DoublePoint();
        this.f17558g = null;
        this.f17552a = c41719m;
        this.f17553b = new GLIcon(this.f17552a.mo67443c(), this.f17552a.mo67430a(), this.f17552a.mo67448f(), this.f17552a.mo67449g(), this.f17552a.mo67453k(), this.f17552a.mo67454l(), this.f17552a.mo67440b());
        this.f17553b.setFixPos(c41719m.mo67457o());
        this.f17553b.setFastLoad(c41719m.mo67458p());
        this.f17553b.setRotateAngle(c41719m.mo67450h());
        this.f17553b.setAvoidAnno(c41719m.mo67452j());
        this.f17553b.setAlpha(c41719m.mo67446e());
        this.f17557f = true;
        AppMethodBeat.m2505o(97884);
    }

    /* renamed from: a */
    public void mo71711a(C41719m c41719m) {
        AppMethodBeat.m2504i(97885);
        if (c41719m == null) {
            AppMethodBeat.m2505o(97885);
            return;
        }
        if (this.f17552a == null) {
            this.f17552a = c41719m;
        } else {
            this.f17552a.mo67431a(c41719m.mo67446e());
            this.f17552a.mo67432a(c41719m.mo67448f(), c41719m.mo67449g());
            this.f17552a.mo67439b(c41719m.mo67445d());
            this.f17552a.mo67433a(c41719m.mo67450h());
            this.f17552a.mo67438b(c41719m.mo67455m());
            this.f17552a.mo67442c(c41719m.mo67452j());
            this.f17552a.mo67441c(c41719m.mo67456n());
        }
        if (this.f17553b == null) {
            this.f17553b = new GLIcon(this.f17552a.mo67443c(), this.f17552a.mo67430a(), this.f17552a.mo67448f(), this.f17552a.mo67449g(), this.f17552a.mo67453k(), this.f17552a.mo67454l(), this.f17552a.mo67440b());
        }
        this.f17553b.setAlpha(this.f17552a.mo67446e());
        this.f17553b.setAnchor(this.f17552a.mo67448f(), this.f17552a.mo67449g());
        this.f17553b.setRotateAngle(c41719m.mo67450h());
        this.f17553b.setFixPos(c41719m.mo67457o());
        this.f17553b.setFastLoad(c41719m.mo67458p());
        this.f17553b.setAvoidAnno(c41719m.mo67452j());
        AppMethodBeat.m2505o(97885);
    }

    /* renamed from: b */
    public void mo20132b(C16263gj c16263gj, C24374fw c24374fw) {
        AppMethodBeat.m2504i(97886);
        if (mo71721d()) {
            this.f17556e = c16263gj.mo29418b();
            if (this.f17558g != null) {
                if (this.f17558g.mo70882b()) {
                    this.f17558g = null;
                } else {
                    this.f17558g.mo70880a();
                }
            }
            if (this.f17553b != null) {
                c16263gj.mo29416a(this.f17552a.mo67430a(), this.f17553b, this.f17552a.mo67445d(), this.f17552a.mo67450h(), this.f17552a.mo67451i(), this.f17552a.mo67459q(), this.f17552a.mo67455m(), this.f17552a.mo67456n());
            }
            AppMethodBeat.m2505o(97886);
            return;
        }
        if (this.f17553b != null) {
            this.f17553b.mDisplayId = -1;
        }
        AppMethodBeat.m2505o(97886);
    }

    /* renamed from: a */
    public boolean mo20130a(C24374fw c24374fw, float f, float f2) {
        AppMethodBeat.m2504i(97887);
        if (!mo71721d() || this.f17552a.mo67430a() == null || this.f17556e == null) {
            AppMethodBeat.m2505o(97887);
            return false;
        }
        boolean z;
        TappedElement a = this.f17556e.mo12445f().mo29314a(f, f2);
        if (a == null || a.itemId != ((long) mo71723f())) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            this.f17553b.setState(1);
        } else {
            this.f17553b.setState(0);
        }
        if (z && this.f17554c != null) {
            this.f17554c.mo33058a(this);
        }
        AppMethodBeat.m2505o(97887);
        return z;
    }

    /* renamed from: a */
    public Rect mo20125a(C24374fw c24374fw) {
        AppMethodBeat.m2504i(97888);
        if (this.f17553b == null || this.f17552a == null || this.f17552a.mo67430a() == null) {
            AppMethodBeat.m2505o(97888);
            return null;
        }
        DoublePoint doublePoint;
        if (mo71722e()) {
            GeoPoint a = mo71706a();
            doublePoint = new DoublePoint(0.0d, 0.0d);
            if (a != null) {
                doublePoint.f2800x = (double) a.getLongitudeE6();
                doublePoint.f2801y = (double) a.getLatitudeE6();
            }
            this.f17555d = doublePoint;
        } else {
            this.f17555d = c24374fw.mo29298b(mo71706a());
        }
        DoublePoint doublePoint2 = new DoublePoint();
        doublePoint = new DoublePoint();
        Bitmap textureBm = this.f17553b.getTextureBm(this.f17553b.getState());
        int width = textureBm.getWidth();
        int height = textureBm.getHeight();
        doublePoint2.f2800x = this.f17555d.f2800x;
        doublePoint.f2800x = this.f17555d.f2800x + ((double) width);
        doublePoint2.f2801y = this.f17555d.f2801y;
        doublePoint.f2801y = this.f17555d.f2801y + ((double) height);
        width = (int) (((float) width) * this.f17552a.mo67448f());
        height = (int) (((float) height) * this.f17552a.mo67449g());
        doublePoint2.f2800x -= (double) width;
        doublePoint.f2800x -= (double) width;
        doublePoint2.f2801y -= (double) height;
        doublePoint.f2801y -= (double) height;
        height = this.f17552a.mo67453k();
        width = this.f17552a.mo67454l();
        doublePoint2.f2800x += (double) height;
        doublePoint.f2800x += (double) height;
        doublePoint2.f2801y += (double) width;
        doublePoint.f2801y = ((double) width) + doublePoint.f2801y;
        GeoPoint a2 = c24374fw.mo29297a(doublePoint2);
        GeoPoint a3 = c24374fw.mo29297a(doublePoint);
        Rect rect = new Rect(a2.getLongitudeE6(), a2.getLatitudeE6(), a3.getLongitudeE6(), a3.getLatitudeE6());
        AppMethodBeat.m2505o(97888);
        return rect;
    }

    /* renamed from: b */
    public Rect mo71715b(C24374fw c24374fw) {
        AppMethodBeat.m2504i(97889);
        if (this.f17553b == null || this.f17552a == null || this.f17552a.mo67430a() == null) {
            AppMethodBeat.m2505o(97889);
            return null;
        }
        int width;
        int height;
        int i;
        if (mo71722e()) {
            GeoPoint a = mo71706a();
            DoublePoint doublePoint = new DoublePoint(0.0d, 0.0d);
            if (a != null) {
                doublePoint.f2800x = (double) a.getLongitudeE6();
                doublePoint.f2801y = (double) a.getLatitudeE6();
            }
            this.f17555d = doublePoint;
        } else {
            this.f17555d = c24374fw.mo29298b(mo71706a());
        }
        DoublePoint doublePoint2 = new DoublePoint();
        DoublePoint doublePoint3 = new DoublePoint();
        Bitmap textureBm = this.f17553b.getTextureBm(this.f17553b.getState());
        if (textureBm != null) {
            width = textureBm.getWidth();
            height = textureBm.getHeight();
            i = width;
        } else {
            height = 0;
            i = 0;
        }
        doublePoint2.f2800x = this.f17555d.f2800x;
        doublePoint3.f2800x = this.f17555d.f2800x + ((double) i);
        doublePoint2.f2801y = this.f17555d.f2801y;
        doublePoint3.f2801y = this.f17555d.f2801y + ((double) height);
        width = (int) (this.f17552a.mo67448f() * ((float) i));
        height = (int) (((float) height) * this.f17552a.mo67449g());
        doublePoint2.f2800x -= (double) width;
        doublePoint3.f2800x -= (double) width;
        doublePoint2.f2801y -= (double) height;
        doublePoint3.f2801y -= (double) height;
        height = this.f17552a.mo67453k();
        width = this.f17552a.mo67454l();
        doublePoint2.f2800x += (double) height;
        doublePoint3.f2800x += (double) height;
        doublePoint2.f2801y += (double) width;
        doublePoint3.f2801y = ((double) width) + doublePoint3.f2801y;
        Rect rect = new Rect((int) doublePoint2.f2800x, (int) doublePoint2.f2801y, (int) doublePoint3.f2800x, (int) doublePoint3.f2801y);
        AppMethodBeat.m2505o(97889);
        return rect;
    }

    /* renamed from: a */
    public void mo71712a(String str, Bitmap... bitmapArr) {
        AppMethodBeat.m2504i(97890);
        this.f17552a = this.f17552a.mo67436a(str, bitmapArr);
        if (this.f17553b != null) {
            this.f17553b.update(str, bitmapArr);
            this.f17553b.setDirty(true);
        }
        AppMethodBeat.m2505o(97890);
    }

    /* renamed from: a */
    public void mo71710a(GeoPoint geoPoint) {
        AppMethodBeat.m2504i(97891);
        this.f17552a = this.f17552a.mo67435a(geoPoint);
        if (this.f17553b != null) {
            this.f17553b.setPosition(geoPoint);
            this.f17553b.setDirty(true);
        }
        AppMethodBeat.m2505o(97891);
    }

    /* renamed from: a */
    public void mo71709a(int i) {
        AppMethodBeat.m2504i(97892);
        this.f17552a = this.f17552a.mo67441c(i);
        if (this.f17553b != null) {
            this.f17553b.setDirty(true);
        }
        AppMethodBeat.m2505o(97892);
    }

    /* renamed from: a */
    public GeoPoint mo71706a() {
        AppMethodBeat.m2504i(97893);
        GeoPoint a = this.f17552a.mo67430a();
        AppMethodBeat.m2505o(97893);
        return a;
    }

    /* renamed from: b */
    public void mo71717b(int i) {
        AppMethodBeat.m2504i(97894);
        this.f17552a = this.f17552a.mo67433a(i);
        if (this.f17553b != null) {
            this.f17553b.setRotateAngle(i);
            this.f17553b.setDirty(true);
        }
        AppMethodBeat.m2505o(97894);
    }

    /* renamed from: a */
    public void mo71707a(float f) {
        AppMethodBeat.m2504i(97895);
        this.f17552a = this.f17552a.mo67431a(f);
        if (this.f17553b != null) {
            this.f17553b.setAlpha(f);
            this.f17553b.setDirty(true);
        }
        AppMethodBeat.m2505o(97895);
    }

    /* renamed from: a */
    public void mo71708a(float f, float f2) {
        AppMethodBeat.m2504i(97896);
        this.f17552a = this.f17552a.mo67432a(f, f2);
        if (this.f17553b != null) {
            this.f17553b.setAnchor(f, f2);
            this.f17553b.setDirty(true);
        }
        AppMethodBeat.m2505o(97896);
    }

    /* renamed from: b */
    public float mo71714b() {
        AppMethodBeat.m2504i(97897);
        float f = this.f17552a.mo67448f();
        AppMethodBeat.m2505o(97897);
        return f;
    }

    /* renamed from: c */
    public float mo71719c() {
        AppMethodBeat.m2504i(97898);
        float g = this.f17552a.mo67449g();
        AppMethodBeat.m2505o(97898);
        return g;
    }

    /* renamed from: b */
    public void mo71716b(float f, float f2) {
        AppMethodBeat.m2504i(97899);
        if (this.f17553b != null) {
            this.f17553b.setScale(f, f2);
            this.f17553b.setDirty(true);
        }
        AppMethodBeat.m2505o(97899);
    }

    /* renamed from: c */
    public void mo71720c(int i) {
        AppMethodBeat.m2504i(97900);
        this.f17552a = this.f17552a.mo67438b(i);
        if (this.f17553b != null) {
            this.f17553b.setDirty(true);
        }
        AppMethodBeat.m2505o(97900);
    }

    /* renamed from: a */
    public void mo71713a(boolean z) {
        this.f17557f = z;
    }

    /* renamed from: d */
    public boolean mo71721d() {
        return this.f17557f;
    }

    /* renamed from: b */
    public void mo71718b(boolean z) {
        AppMethodBeat.m2504i(97901);
        if (this.f17553b != null) {
            this.f17553b.setFixPos(z);
            this.f17553b.setDirty(true);
        }
        AppMethodBeat.m2505o(97901);
    }

    /* renamed from: e */
    public boolean mo71722e() {
        AppMethodBeat.m2504i(97902);
        if (this.f17553b != null) {
            boolean isFixPos = this.f17553b.isFixPos();
            AppMethodBeat.m2505o(97902);
            return isFixPos;
        }
        AppMethodBeat.m2505o(97902);
        return false;
    }

    /* renamed from: f */
    public int mo71723f() {
        if (this.f17553b != null) {
            return this.f17553b.mDisplayId;
        }
        return -1;
    }

    /* renamed from: g */
    public void mo71724g() {
        if (this.f17553b != null) {
            this.f17553b.mDisplayId = 0;
        }
    }
}

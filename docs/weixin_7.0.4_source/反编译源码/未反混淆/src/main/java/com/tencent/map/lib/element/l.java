package com.tencent.map.lib.element;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.map.lib.mapstructure.TappedElement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.ev;
import com.tencent.tencentmap.mapsdk.maps.a.fn;
import com.tencent.tencentmap.mapsdk.maps.a.fw;
import com.tencent.tencentmap.mapsdk.maps.a.gj;

public class l implements j {
    protected m a;
    protected GLIcon b;
    protected n c;
    protected DoublePoint d;
    private fn e;
    private boolean f;
    private ev g;

    public l() {
        AppMethodBeat.i(97883);
        this.d = new DoublePoint();
        this.g = null;
        this.f = true;
        AppMethodBeat.o(97883);
    }

    public l(m mVar) {
        AppMethodBeat.i(97884);
        this.d = new DoublePoint();
        this.g = null;
        this.a = mVar;
        this.b = new GLIcon(this.a.c(), this.a.a(), this.a.f(), this.a.g(), this.a.k(), this.a.l(), this.a.b());
        this.b.setFixPos(mVar.o());
        this.b.setFastLoad(mVar.p());
        this.b.setRotateAngle(mVar.h());
        this.b.setAvoidAnno(mVar.j());
        this.b.setAlpha(mVar.e());
        this.f = true;
        AppMethodBeat.o(97884);
    }

    public void a(m mVar) {
        AppMethodBeat.i(97885);
        if (mVar == null) {
            AppMethodBeat.o(97885);
            return;
        }
        if (this.a == null) {
            this.a = mVar;
        } else {
            this.a.a(mVar.e());
            this.a.a(mVar.f(), mVar.g());
            this.a.b(mVar.d());
            this.a.a(mVar.h());
            this.a.b(mVar.m());
            this.a.c(mVar.j());
            this.a.c(mVar.n());
        }
        if (this.b == null) {
            this.b = new GLIcon(this.a.c(), this.a.a(), this.a.f(), this.a.g(), this.a.k(), this.a.l(), this.a.b());
        }
        this.b.setAlpha(this.a.e());
        this.b.setAnchor(this.a.f(), this.a.g());
        this.b.setRotateAngle(mVar.h());
        this.b.setFixPos(mVar.o());
        this.b.setFastLoad(mVar.p());
        this.b.setAvoidAnno(mVar.j());
        AppMethodBeat.o(97885);
    }

    public void b(gj gjVar, fw fwVar) {
        AppMethodBeat.i(97886);
        if (d()) {
            this.e = gjVar.b();
            if (this.g != null) {
                if (this.g.b()) {
                    this.g = null;
                } else {
                    this.g.a();
                }
            }
            if (this.b != null) {
                gjVar.a(this.a.a(), this.b, this.a.d(), this.a.h(), this.a.i(), this.a.q(), this.a.m(), this.a.n());
            }
            AppMethodBeat.o(97886);
            return;
        }
        if (this.b != null) {
            this.b.mDisplayId = -1;
        }
        AppMethodBeat.o(97886);
    }

    public boolean a(fw fwVar, float f, float f2) {
        AppMethodBeat.i(97887);
        if (!d() || this.a.a() == null || this.e == null) {
            AppMethodBeat.o(97887);
            return false;
        }
        boolean z;
        TappedElement a = this.e.f().a(f, f2);
        if (a == null || a.itemId != ((long) f())) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            this.b.setState(1);
        } else {
            this.b.setState(0);
        }
        if (z && this.c != null) {
            this.c.a(this);
        }
        AppMethodBeat.o(97887);
        return z;
    }

    public Rect a(fw fwVar) {
        AppMethodBeat.i(97888);
        if (this.b == null || this.a == null || this.a.a() == null) {
            AppMethodBeat.o(97888);
            return null;
        }
        DoublePoint doublePoint;
        if (e()) {
            GeoPoint a = a();
            doublePoint = new DoublePoint(0.0d, 0.0d);
            if (a != null) {
                doublePoint.x = (double) a.getLongitudeE6();
                doublePoint.y = (double) a.getLatitudeE6();
            }
            this.d = doublePoint;
        } else {
            this.d = fwVar.b(a());
        }
        DoublePoint doublePoint2 = new DoublePoint();
        doublePoint = new DoublePoint();
        Bitmap textureBm = this.b.getTextureBm(this.b.getState());
        int width = textureBm.getWidth();
        int height = textureBm.getHeight();
        doublePoint2.x = this.d.x;
        doublePoint.x = this.d.x + ((double) width);
        doublePoint2.y = this.d.y;
        doublePoint.y = this.d.y + ((double) height);
        width = (int) (((float) width) * this.a.f());
        height = (int) (((float) height) * this.a.g());
        doublePoint2.x -= (double) width;
        doublePoint.x -= (double) width;
        doublePoint2.y -= (double) height;
        doublePoint.y -= (double) height;
        height = this.a.k();
        width = this.a.l();
        doublePoint2.x += (double) height;
        doublePoint.x += (double) height;
        doublePoint2.y += (double) width;
        doublePoint.y = ((double) width) + doublePoint.y;
        GeoPoint a2 = fwVar.a(doublePoint2);
        GeoPoint a3 = fwVar.a(doublePoint);
        Rect rect = new Rect(a2.getLongitudeE6(), a2.getLatitudeE6(), a3.getLongitudeE6(), a3.getLatitudeE6());
        AppMethodBeat.o(97888);
        return rect;
    }

    public Rect b(fw fwVar) {
        AppMethodBeat.i(97889);
        if (this.b == null || this.a == null || this.a.a() == null) {
            AppMethodBeat.o(97889);
            return null;
        }
        int width;
        int height;
        int i;
        if (e()) {
            GeoPoint a = a();
            DoublePoint doublePoint = new DoublePoint(0.0d, 0.0d);
            if (a != null) {
                doublePoint.x = (double) a.getLongitudeE6();
                doublePoint.y = (double) a.getLatitudeE6();
            }
            this.d = doublePoint;
        } else {
            this.d = fwVar.b(a());
        }
        DoublePoint doublePoint2 = new DoublePoint();
        DoublePoint doublePoint3 = new DoublePoint();
        Bitmap textureBm = this.b.getTextureBm(this.b.getState());
        if (textureBm != null) {
            width = textureBm.getWidth();
            height = textureBm.getHeight();
            i = width;
        } else {
            height = 0;
            i = 0;
        }
        doublePoint2.x = this.d.x;
        doublePoint3.x = this.d.x + ((double) i);
        doublePoint2.y = this.d.y;
        doublePoint3.y = this.d.y + ((double) height);
        width = (int) (this.a.f() * ((float) i));
        height = (int) (((float) height) * this.a.g());
        doublePoint2.x -= (double) width;
        doublePoint3.x -= (double) width;
        doublePoint2.y -= (double) height;
        doublePoint3.y -= (double) height;
        height = this.a.k();
        width = this.a.l();
        doublePoint2.x += (double) height;
        doublePoint3.x += (double) height;
        doublePoint2.y += (double) width;
        doublePoint3.y = ((double) width) + doublePoint3.y;
        Rect rect = new Rect((int) doublePoint2.x, (int) doublePoint2.y, (int) doublePoint3.x, (int) doublePoint3.y);
        AppMethodBeat.o(97889);
        return rect;
    }

    public void a(String str, Bitmap... bitmapArr) {
        AppMethodBeat.i(97890);
        this.a = this.a.a(str, bitmapArr);
        if (this.b != null) {
            this.b.update(str, bitmapArr);
            this.b.setDirty(true);
        }
        AppMethodBeat.o(97890);
    }

    public void a(GeoPoint geoPoint) {
        AppMethodBeat.i(97891);
        this.a = this.a.a(geoPoint);
        if (this.b != null) {
            this.b.setPosition(geoPoint);
            this.b.setDirty(true);
        }
        AppMethodBeat.o(97891);
    }

    public void a(int i) {
        AppMethodBeat.i(97892);
        this.a = this.a.c(i);
        if (this.b != null) {
            this.b.setDirty(true);
        }
        AppMethodBeat.o(97892);
    }

    public GeoPoint a() {
        AppMethodBeat.i(97893);
        GeoPoint a = this.a.a();
        AppMethodBeat.o(97893);
        return a;
    }

    public void b(int i) {
        AppMethodBeat.i(97894);
        this.a = this.a.a(i);
        if (this.b != null) {
            this.b.setRotateAngle(i);
            this.b.setDirty(true);
        }
        AppMethodBeat.o(97894);
    }

    public void a(float f) {
        AppMethodBeat.i(97895);
        this.a = this.a.a(f);
        if (this.b != null) {
            this.b.setAlpha(f);
            this.b.setDirty(true);
        }
        AppMethodBeat.o(97895);
    }

    public void a(float f, float f2) {
        AppMethodBeat.i(97896);
        this.a = this.a.a(f, f2);
        if (this.b != null) {
            this.b.setAnchor(f, f2);
            this.b.setDirty(true);
        }
        AppMethodBeat.o(97896);
    }

    public float b() {
        AppMethodBeat.i(97897);
        float f = this.a.f();
        AppMethodBeat.o(97897);
        return f;
    }

    public float c() {
        AppMethodBeat.i(97898);
        float g = this.a.g();
        AppMethodBeat.o(97898);
        return g;
    }

    public void b(float f, float f2) {
        AppMethodBeat.i(97899);
        if (this.b != null) {
            this.b.setScale(f, f2);
            this.b.setDirty(true);
        }
        AppMethodBeat.o(97899);
    }

    public void c(int i) {
        AppMethodBeat.i(97900);
        this.a = this.a.b(i);
        if (this.b != null) {
            this.b.setDirty(true);
        }
        AppMethodBeat.o(97900);
    }

    public void a(boolean z) {
        this.f = z;
    }

    public boolean d() {
        return this.f;
    }

    public void b(boolean z) {
        AppMethodBeat.i(97901);
        if (this.b != null) {
            this.b.setFixPos(z);
            this.b.setDirty(true);
        }
        AppMethodBeat.o(97901);
    }

    public boolean e() {
        AppMethodBeat.i(97902);
        if (this.b != null) {
            boolean isFixPos = this.b.isFixPos();
            AppMethodBeat.o(97902);
            return isFixPos;
        }
        AppMethodBeat.o(97902);
        return false;
    }

    public int f() {
        if (this.b != null) {
            return this.b.mDisplayId;
        }
        return -1;
    }

    public void g() {
        if (this.b != null) {
            this.b.mDisplayId = 0;
        }
    }
}

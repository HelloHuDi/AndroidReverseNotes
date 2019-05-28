package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseBooleanArray;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.d;
import com.tencent.map.lib.gl.b;
import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.map.lib.util.SystemUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.CopyOnWriteArrayList;

public class gj {
    public HashMap<Integer, GLIcon> a;
    public HashMap<Integer, GLIcon> b;
    private fn c;
    private gh d;
    private CopyOnWriteArrayList<Integer> e = new CopyOnWriteArrayList();
    private SparseBooleanArray f = new SparseBooleanArray();
    private ArrayList<Integer> g = new ArrayList();

    gj(fn fnVar, b bVar, gh ghVar) {
        AppMethodBeat.i(99166);
        this.c = fnVar;
        this.d = ghVar;
        this.a = new HashMap();
        this.b = new HashMap();
        AppMethodBeat.o(99166);
    }

    public void a(GeoPoint geoPoint, GLIcon gLIcon, boolean z, int i, boolean z2, boolean z3, int i2, int i3) {
        AppMethodBeat.i(99167);
        float rotateAngle = z3 ? 360.0f - gLIcon.getRotateAngle() : gLIcon.getRotateAngle();
        if (this.a.containsKey(Integer.valueOf(gLIcon.mDisplayId))) {
            if (gLIcon.isDirty()) {
                this.d.a(gLIcon.mDisplayId, gLIcon.getIconName(), gLIcon.mPositionX, gLIcon.mPositionY, gLIcon.getAnchroX(), gLIcon.getAnchorY(), gLIcon.getScaleX(), gLIcon.getScaleY(), gLIcon.getAlpha(), rotateAngle, z, gLIcon.isFixPos(), gLIcon.isFastLoad(), gLIcon.isAvoidAnno(), i2, i3);
                if (gLIcon.isIconChanged()) {
                    com.tencent.map.lib.util.b.a(gLIcon.getIconName(), gLIcon.getTextureBm(0));
                    if (!StringUtil.isEqual(gLIcon.getIconName(), gLIcon.getLastName())) {
                        com.tencent.map.lib.util.b.b(gLIcon.getLastName());
                    }
                    gLIcon.setIconChanged(false);
                }
            }
            this.b.put(Integer.valueOf(gLIcon.mDisplayId), gLIcon);
            AppMethodBeat.o(99167);
            return;
        }
        gLIcon.mDisplayId = this.d.a(gLIcon.getIconName(), gLIcon.mPositionX, gLIcon.mPositionY, gLIcon.getAnchroX(), gLIcon.getAnchorY(), gLIcon.getScaleX(), gLIcon.getScaleY(), gLIcon.getAlpha(), rotateAngle, z, gLIcon.isFixPos(), gLIcon.isFastLoad(), gLIcon.isAvoidAnno(), i2, i3);
        com.tencent.map.lib.util.b.a(gLIcon.getIconName(), gLIcon.getTextureBm(0));
        gLIcon.setIconChanged(false);
        gLIcon.setDirty(false);
        this.b.put(Integer.valueOf(gLIcon.mDisplayId), gLIcon);
        AppMethodBeat.o(99167);
    }

    public void a() {
        AppMethodBeat.i(99168);
        e();
        f();
        AppMethodBeat.o(99168);
    }

    private void e() {
        AppMethodBeat.i(99169);
        ArrayList arrayList = new ArrayList();
        for (Entry entry : this.a.entrySet()) {
            Object key = entry.getKey();
            GLIcon gLIcon = (GLIcon) entry.getValue();
            if (!this.b.containsKey(key)) {
                arrayList.add(Integer.valueOf(((Integer) key).intValue()));
                com.tencent.map.lib.util.b.b(gLIcon.getIconName());
            }
        }
        int size = arrayList.size();
        if (size <= 0) {
            AppMethodBeat.o(99169);
            return;
        }
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = ((Integer) arrayList.get(i)).intValue();
        }
        this.d.a(iArr, size);
        AppMethodBeat.o(99169);
    }

    private void f() {
        AppMethodBeat.i(99170);
        this.a.clear();
        this.a.putAll(this.b);
        this.b.clear();
        AppMethodBeat.o(99170);
    }

    public static Bitmap a(String str) {
        AppMethodBeat.i(99171);
        Bitmap a = com.tencent.map.lib.util.b.a(str);
        AppMethodBeat.o(99171);
        return a;
    }

    public fn b() {
        return this.c;
    }

    private int b(d dVar) {
        AppMethodBeat.i(99172);
        if (!(!(this.c instanceof gm) || dVar == null || dVar.l())) {
            Context k = ((gm) this.c).k();
            dVar.a(SystemUtil.getDensity(k) * dVar.n());
        }
        int a = this.c.f().a(dVar);
        dVar.a(a);
        if (!this.e.contains(Integer.valueOf(a))) {
            this.e.add(Integer.valueOf(a));
            this.f.append(a, dVar.l());
        }
        AppMethodBeat.o(99172);
        return a;
    }

    public void a(int i) {
        AppMethodBeat.i(99173);
        this.c.f().a(i, this.f.get(i));
        this.f.delete(i);
        this.e.remove(Integer.valueOf(i));
        AppMethodBeat.o(99173);
    }

    public void a(d dVar) {
        AppMethodBeat.i(99174);
        if (!this.e.contains(Integer.valueOf(dVar.s()))) {
            dVar.a(b(dVar));
            this.d.c(dVar);
        }
        if (!this.g.contains(Integer.valueOf(dVar.s()))) {
            this.g.add(Integer.valueOf(dVar.s()));
        }
        this.d.b(dVar);
        this.d.d(dVar);
        if (dVar.t()) {
            this.d.h(dVar);
        } else {
            this.d.g(dVar);
        }
        this.d.f(dVar);
        if (!StringUtil.isEmpty(dVar.w())) {
            this.d.e(dVar);
        }
        this.d.i(dVar);
        AppMethodBeat.o(99174);
    }

    /* Access modifiers changed, original: protected */
    public void c() {
        AppMethodBeat.i(99175);
        if (this.e != null && this.e.size() > 0) {
            Iterator it = this.e.iterator();
            while (it.hasNext()) {
                int intValue = ((Integer) it.next()).intValue();
                if (!this.g.contains(Integer.valueOf(intValue))) {
                    a(intValue);
                }
            }
            this.g.clear();
        }
        AppMethodBeat.o(99175);
    }

    public float d() {
        AppMethodBeat.i(99176);
        float l = this.c.a().l();
        AppMethodBeat.o(99176);
        return l;
    }
}

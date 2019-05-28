package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseBooleanArray;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.C45135d;
import com.tencent.map.lib.p822gl.C17851b;
import com.tencent.map.lib.p822gl.model.GLIcon;
import com.tencent.map.lib.util.C17862b;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.map.lib.util.SystemUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.gj */
public class C16263gj {
    /* renamed from: a */
    public HashMap<Integer, GLIcon> f3330a;
    /* renamed from: b */
    public HashMap<Integer, GLIcon> f3331b;
    /* renamed from: c */
    private C5876fn f3332c;
    /* renamed from: d */
    private C16238gh f3333d;
    /* renamed from: e */
    private CopyOnWriteArrayList<Integer> f3334e = new CopyOnWriteArrayList();
    /* renamed from: f */
    private SparseBooleanArray f3335f = new SparseBooleanArray();
    /* renamed from: g */
    private ArrayList<Integer> f3336g = new ArrayList();

    C16263gj(C5876fn c5876fn, C17851b c17851b, C16238gh c16238gh) {
        AppMethodBeat.m2504i(99166);
        this.f3332c = c5876fn;
        this.f3333d = c16238gh;
        this.f3330a = new HashMap();
        this.f3331b = new HashMap();
        AppMethodBeat.m2505o(99166);
    }

    /* renamed from: a */
    public void mo29416a(GeoPoint geoPoint, GLIcon gLIcon, boolean z, int i, boolean z2, boolean z3, int i2, int i3) {
        AppMethodBeat.m2504i(99167);
        float rotateAngle = z3 ? 360.0f - gLIcon.getRotateAngle() : gLIcon.getRotateAngle();
        if (this.f3330a.containsKey(Integer.valueOf(gLIcon.mDisplayId))) {
            if (gLIcon.isDirty()) {
                this.f3333d.mo29328a(gLIcon.mDisplayId, gLIcon.getIconName(), gLIcon.mPositionX, gLIcon.mPositionY, gLIcon.getAnchroX(), gLIcon.getAnchorY(), gLIcon.getScaleX(), gLIcon.getScaleY(), gLIcon.getAlpha(), rotateAngle, z, gLIcon.isFixPos(), gLIcon.isFastLoad(), gLIcon.isAvoidAnno(), i2, i3);
                if (gLIcon.isIconChanged()) {
                    C17862b.m27956a(gLIcon.getIconName(), gLIcon.getTextureBm(0));
                    if (!StringUtil.isEqual(gLIcon.getIconName(), gLIcon.getLastName())) {
                        C17862b.m27957b(gLIcon.getLastName());
                    }
                    gLIcon.setIconChanged(false);
                }
            }
            this.f3331b.put(Integer.valueOf(gLIcon.mDisplayId), gLIcon);
            AppMethodBeat.m2505o(99167);
            return;
        }
        gLIcon.mDisplayId = this.f3333d.mo29310a(gLIcon.getIconName(), gLIcon.mPositionX, gLIcon.mPositionY, gLIcon.getAnchroX(), gLIcon.getAnchorY(), gLIcon.getScaleX(), gLIcon.getScaleY(), gLIcon.getAlpha(), rotateAngle, z, gLIcon.isFixPos(), gLIcon.isFastLoad(), gLIcon.isAvoidAnno(), i2, i3);
        C17862b.m27956a(gLIcon.getIconName(), gLIcon.getTextureBm(0));
        gLIcon.setIconChanged(false);
        gLIcon.setDirty(false);
        this.f3331b.put(Integer.valueOf(gLIcon.mDisplayId), gLIcon);
        AppMethodBeat.m2505o(99167);
    }

    /* renamed from: a */
    public void mo29414a() {
        AppMethodBeat.m2504i(99168);
        m24921e();
        m24922f();
        AppMethodBeat.m2505o(99168);
    }

    /* renamed from: e */
    private void m24921e() {
        AppMethodBeat.m2504i(99169);
        ArrayList arrayList = new ArrayList();
        for (Entry entry : this.f3330a.entrySet()) {
            Object key = entry.getKey();
            GLIcon gLIcon = (GLIcon) entry.getValue();
            if (!this.f3331b.containsKey(key)) {
                arrayList.add(Integer.valueOf(((Integer) key).intValue()));
                C17862b.m27957b(gLIcon.getIconName());
            }
        }
        int size = arrayList.size();
        if (size <= 0) {
            AppMethodBeat.m2505o(99169);
            return;
        }
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = ((Integer) arrayList.get(i)).intValue();
        }
        this.f3333d.mo29346a(iArr, size);
        AppMethodBeat.m2505o(99169);
    }

    /* renamed from: f */
    private void m24922f() {
        AppMethodBeat.m2504i(99170);
        this.f3330a.clear();
        this.f3330a.putAll(this.f3331b);
        this.f3331b.clear();
        AppMethodBeat.m2505o(99170);
    }

    /* renamed from: a */
    public static Bitmap m24919a(String str) {
        AppMethodBeat.m2504i(99171);
        Bitmap a = C17862b.m27954a(str);
        AppMethodBeat.m2505o(99171);
        return a;
    }

    /* renamed from: b */
    public C5876fn mo29418b() {
        return this.f3332c;
    }

    /* renamed from: b */
    private int m24920b(C45135d c45135d) {
        AppMethodBeat.m2504i(99172);
        if (!(!(this.f3332c instanceof C46789gm) || c45135d == null || c45135d.mo72981l())) {
            Context k = ((C46789gm) this.f3332c).mo75458k();
            c45135d.mo72965a(SystemUtil.getDensity(k) * c45135d.mo72983n());
        }
        int a = this.f3332c.mo12445f().mo29306a(c45135d);
        c45135d.mo72966a(a);
        if (!this.f3334e.contains(Integer.valueOf(a))) {
            this.f3334e.add(Integer.valueOf(a));
            this.f3335f.append(a, c45135d.mo72981l());
        }
        AppMethodBeat.m2505o(99172);
        return a;
    }

    /* renamed from: a */
    public void mo29415a(int i) {
        AppMethodBeat.m2504i(99173);
        this.f3332c.mo12445f().mo29329a(i, this.f3335f.get(i));
        this.f3335f.delete(i);
        this.f3334e.remove(Integer.valueOf(i));
        AppMethodBeat.m2505o(99173);
    }

    /* renamed from: a */
    public void mo29417a(C45135d c45135d) {
        AppMethodBeat.m2504i(99174);
        if (!this.f3334e.contains(Integer.valueOf(c45135d.mo72988s()))) {
            c45135d.mo72966a(m24920b(c45135d));
            this.f3333d.mo29365c(c45135d);
        }
        if (!this.f3336g.contains(Integer.valueOf(c45135d.mo72988s()))) {
            this.f3336g.add(Integer.valueOf(c45135d.mo72988s()));
        }
        this.f3333d.mo29356b(c45135d);
        this.f3333d.mo29374d(c45135d);
        if (c45135d.mo72989t()) {
            this.f3333d.mo29392h(c45135d);
        } else {
            this.f3333d.mo29388g(c45135d);
        }
        this.f3333d.mo29384f(c45135d);
        if (!StringUtil.isEmpty(c45135d.mo72992w())) {
            this.f3333d.mo29379e(c45135d);
        }
        this.f3333d.mo29396i(c45135d);
        AppMethodBeat.m2505o(99174);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: c */
    public void mo29419c() {
        AppMethodBeat.m2504i(99175);
        if (this.f3334e != null && this.f3334e.size() > 0) {
            Iterator it = this.f3334e.iterator();
            while (it.hasNext()) {
                int intValue = ((Integer) it.next()).intValue();
                if (!this.f3336g.contains(Integer.valueOf(intValue))) {
                    mo29415a(intValue);
                }
            }
            this.f3336g.clear();
        }
        AppMethodBeat.m2505o(99175);
    }

    /* renamed from: d */
    public float mo29420d() {
        AppMethodBeat.m2504i(99176);
        float l = this.f3332c.mo12440a().mo58848l();
        AppMethodBeat.m2505o(99176);
        return l;
    }
}

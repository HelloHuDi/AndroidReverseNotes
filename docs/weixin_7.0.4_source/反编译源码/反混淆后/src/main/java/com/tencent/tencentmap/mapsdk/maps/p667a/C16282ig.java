package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.view.animation.Interpolator;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C31056if.C31058b;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ig */
public class C16282ig extends C31056if {
    /* renamed from: e */
    protected boolean f3435e = true;
    /* renamed from: f */
    protected List<C31056if> f3436f = null;

    public C16282ig(boolean z) {
        AppMethodBeat.m2504i(99837);
        this.f3435e = z;
        if (this.f3436f == null) {
            this.f3436f = new ArrayList();
        }
        AppMethodBeat.m2505o(99837);
    }

    /* renamed from: a */
    public void mo29511a(C31056if c31056if) {
        AppMethodBeat.m2504i(99838);
        if (c31056if == null) {
            AppMethodBeat.m2505o(99838);
            return;
        }
        this.f3436f.add(c31056if);
        AppMethodBeat.m2505o(99838);
    }

    /* renamed from: g */
    public void mo29513g() {
        AppMethodBeat.m2504i(99839);
        if (this.f3436f == null) {
            AppMethodBeat.m2505o(99839);
            return;
        }
        this.f3436f.clear();
        AppMethodBeat.m2505o(99839);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo29509a(float f, Interpolator interpolator) {
        AppMethodBeat.m2504i(99840);
        if (this.f3436f == null) {
            AppMethodBeat.m2505o(99840);
            return;
        }
        int size = this.f3436f.size();
        if (size == 0) {
            AppMethodBeat.m2505o(99840);
            return;
        }
        for (int i = 0; i < size; i++) {
            C31056if c31056if = (C31056if) this.f3436f.get(i);
            if (c31056if != null) {
                if (this.f3435e) {
                    c31056if.mo29509a(f, interpolator);
                } else {
                    c31056if.mo29509a(f, c31056if.mo50387a());
                }
            }
        }
        AppMethodBeat.m2505o(99840);
    }

    /* renamed from: a */
    public boolean mo29512a(GeoPoint geoPoint, GeoPoint geoPoint2) {
        AppMethodBeat.m2504i(99841);
        boolean a = super.mo29512a(geoPoint, geoPoint2);
        if (!a) {
            AppMethodBeat.m2505o(99841);
            return false;
        } else if (this.f3436f == null) {
            AppMethodBeat.m2505o(99841);
            return false;
        } else {
            int size = this.f3436f.size();
            if (size == 0) {
                AppMethodBeat.m2505o(99841);
                return false;
            }
            int i = 0;
            while (i < size) {
                C31056if c31056if = (C31056if) this.f3436f.get(i);
                boolean z = c31056if != null ? a && c31056if.mo29512a(geoPoint, geoPoint2) : a;
                i++;
                a = z;
            }
            AppMethodBeat.m2505o(99841);
            return a;
        }
    }

    /* renamed from: a */
    public void mo29510a(C31058b c31058b) {
        AppMethodBeat.m2504i(99842);
        super.mo29510a(c31058b);
        if (this.f3436f == null) {
            AppMethodBeat.m2505o(99842);
            return;
        }
        int size = this.f3436f.size();
        if (size == 0) {
            AppMethodBeat.m2505o(99842);
            return;
        }
        for (int i = 0; i < size; i++) {
            C31056if c31056if = (C31056if) this.f3436f.get(i);
            if (c31056if != null) {
                c31056if.mo29510a(c31058b);
            }
        }
        AppMethodBeat.m2505o(99842);
    }
}

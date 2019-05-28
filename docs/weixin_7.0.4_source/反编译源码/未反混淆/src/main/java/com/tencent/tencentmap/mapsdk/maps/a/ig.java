package com.tencent.tencentmap.mapsdk.maps.a;

import android.view.animation.Interpolator;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.if.b;
import java.util.ArrayList;
import java.util.List;

public class ig extends if {
    protected boolean e = true;
    protected List<if> f = null;

    public ig(boolean z) {
        AppMethodBeat.i(99837);
        this.e = z;
        if (this.f == null) {
            this.f = new ArrayList();
        }
        AppMethodBeat.o(99837);
    }

    public void a(if ifVar) {
        AppMethodBeat.i(99838);
        if (ifVar == null) {
            AppMethodBeat.o(99838);
            return;
        }
        this.f.add(ifVar);
        AppMethodBeat.o(99838);
    }

    public void g() {
        AppMethodBeat.i(99839);
        if (this.f == null) {
            AppMethodBeat.o(99839);
            return;
        }
        this.f.clear();
        AppMethodBeat.o(99839);
    }

    /* Access modifiers changed, original: protected */
    public void a(float f, Interpolator interpolator) {
        AppMethodBeat.i(99840);
        if (this.f == null) {
            AppMethodBeat.o(99840);
            return;
        }
        int size = this.f.size();
        if (size == 0) {
            AppMethodBeat.o(99840);
            return;
        }
        for (int i = 0; i < size; i++) {
            if ifVar = (if) this.f.get(i);
            if (ifVar != null) {
                if (this.e) {
                    ifVar.a(f, interpolator);
                } else {
                    ifVar.a(f, ifVar.a());
                }
            }
        }
        AppMethodBeat.o(99840);
    }

    public boolean a(GeoPoint geoPoint, GeoPoint geoPoint2) {
        AppMethodBeat.i(99841);
        boolean a = super.a(geoPoint, geoPoint2);
        if (!a) {
            AppMethodBeat.o(99841);
            return false;
        } else if (this.f == null) {
            AppMethodBeat.o(99841);
            return false;
        } else {
            int size = this.f.size();
            if (size == 0) {
                AppMethodBeat.o(99841);
                return false;
            }
            int i = 0;
            while (i < size) {
                if ifVar = (if) this.f.get(i);
                boolean z = ifVar != null ? a && ifVar.a(geoPoint, geoPoint2) : a;
                i++;
                a = z;
            }
            AppMethodBeat.o(99841);
            return a;
        }
    }

    public void a(b bVar) {
        AppMethodBeat.i(99842);
        super.a(bVar);
        if (this.f == null) {
            AppMethodBeat.o(99842);
            return;
        }
        int size = this.f.size();
        if (size == 0) {
            AppMethodBeat.o(99842);
            return;
        }
        for (int i = 0; i < size; i++) {
            if ifVar = (if) this.f.get(i);
            if (ifVar != null) {
                ifVar.a(bVar);
            }
        }
        AppMethodBeat.o(99842);
    }
}

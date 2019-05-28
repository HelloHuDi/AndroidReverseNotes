package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.element.MapPoi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.aj.k;
import com.tencent.tencentmap.mapsdk.a.db;
import com.tencent.tencentmap.mapsdk.a.dd;

public class je extends jb {
    private MapPoi a;
    private iz b;

    public je(iz izVar, MapPoi mapPoi) {
        this.a = mapPoi;
        this.b = izVar;
    }

    public Rect a() {
        AppMethodBeat.i(100027);
        DoublePoint b = this.b.b().t().b(ic.a(new db(this.a.getLatitude(), this.a.getLongitude())));
        Rect rect = new Rect((int) (b.x - ((double) (ic.s * 20.0f))), (int) (b.y - ((double) (ic.s * 20.0f))), (int) (b.x + ((double) (ic.s * 20.0f))), (int) (b.y + ((double) (ic.s * 20.0f))));
        AppMethodBeat.o(100027);
        return rect;
    }

    public String b() {
        AppMethodBeat.i(100028);
        String poiName = this.a.getPoiName();
        AppMethodBeat.o(100028);
        return poiName;
    }

    public void c() {
        AppMethodBeat.i(100029);
        if (this.b != null) {
            k kVar = this.b.u;
            if (kVar != null) {
                dd ddVar = new dd();
                ddVar.e = new db(this.a.getLatitude(), this.a.getLongitude());
                ddVar.d = this.a.getPoiName();
                kVar.a(ddVar);
            }
        }
        AppMethodBeat.o(100029);
    }
}

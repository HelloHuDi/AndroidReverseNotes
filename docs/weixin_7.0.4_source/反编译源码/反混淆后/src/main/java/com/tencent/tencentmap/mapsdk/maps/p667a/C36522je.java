package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.element.MapPoi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.p666a.C24343db;
import com.tencent.tencentmap.mapsdk.p666a.C24346dd;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C30987k;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.je */
public class C36522je extends C16285jb {
    /* renamed from: a */
    private MapPoi f15423a;
    /* renamed from: b */
    private C31061iz f15424b;

    public C36522je(C31061iz c31061iz, MapPoi mapPoi) {
        this.f15423a = mapPoi;
        this.f15424b = c31061iz;
    }

    /* renamed from: a */
    public Rect mo12518a() {
        AppMethodBeat.m2504i(100027);
        DoublePoint b = this.f15424b.mo75386b().mo20244t().mo29298b(C36520ic.m60470a(new C24343db(this.f15423a.getLatitude(), this.f15423a.getLongitude())));
        Rect rect = new Rect((int) (b.f2800x - ((double) (C36520ic.f15414s * 20.0f))), (int) (b.f2801y - ((double) (C36520ic.f15414s * 20.0f))), (int) (b.f2800x + ((double) (C36520ic.f15414s * 20.0f))), (int) (b.f2801y + ((double) (C36520ic.f15414s * 20.0f))));
        AppMethodBeat.m2505o(100027);
        return rect;
    }

    /* renamed from: b */
    public String mo12519b() {
        AppMethodBeat.m2504i(100028);
        String poiName = this.f15423a.getPoiName();
        AppMethodBeat.m2505o(100028);
        return poiName;
    }

    /* renamed from: c */
    public void mo12520c() {
        AppMethodBeat.m2504i(100029);
        if (this.f15424b != null) {
            C30987k c30987k = this.f15424b.f14286u;
            if (c30987k != null) {
                C24346dd c24346dd = new C24346dd();
                c24346dd.f4620e = new C24343db(this.f15423a.getLatitude(), this.f15423a.getLongitude());
                c24346dd.f4619d = this.f15423a.getPoiName();
                c30987k.mo29183a(c24346dd);
            }
        }
        AppMethodBeat.m2505o(100029);
    }
}

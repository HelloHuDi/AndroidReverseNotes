package com.tencent.tencentmap.mapsdk.dynamic;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.IMapView;
import com.tencent.tencentmap.mapsdk.map.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.p666a.C36476dy;
import com.tencent.tencentmap.mapsdk.p666a.C41022ea;
import com.tencent.tencentmap.mapsdk.p666a.C44495ec;
import com.tencent.tencentmap.mapsdk.p666a.C46762ei;

/* renamed from: com.tencent.tencentmap.mapsdk.dynamic.b */
public class C16204b {
    /* renamed from: a */
    private TencentMapOptions f3124a;

    /* renamed from: a */
    public IMapView mo29203a(Context context, TencentMapOptions tencentMapOptions) {
        IMapView c44495ec;
        AppMethodBeat.m2504i(101277);
        int i = 0;
        this.f3124a = tencentMapOptions;
        if (this.f3124a != null) {
            i = this.f3124a.getMapType();
        }
        switch (i) {
            case 0:
                C36476dy.m60312a("maptype", "glmapview");
                c44495ec = new C44495ec(context, this.f3124a);
                break;
            case 1:
                c44495ec = new C46762ei(context, this.f3124a);
                C36476dy.m60312a("maptype", "maprenderlayer");
                break;
            case 2:
                c44495ec = new C41022ea(context, this.f3124a);
                C36476dy.m60312a("maptype", "texturemapview");
                break;
            default:
                c44495ec = new C44495ec(context, this.f3124a);
                break;
        }
        AppMethodBeat.m2505o(101277);
        return c44495ec;
    }
}

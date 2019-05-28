package com.tencent.tencentmap.mapsdk.dynamic;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.dy;
import com.tencent.tencentmap.mapsdk.a.ea;
import com.tencent.tencentmap.mapsdk.a.ec;
import com.tencent.tencentmap.mapsdk.a.ei;
import com.tencent.tencentmap.mapsdk.map.IMapView;
import com.tencent.tencentmap.mapsdk.map.TencentMapOptions;

public class b {
    private TencentMapOptions a;

    public IMapView a(Context context, TencentMapOptions tencentMapOptions) {
        IMapView ecVar;
        AppMethodBeat.i(101277);
        int i = 0;
        this.a = tencentMapOptions;
        if (this.a != null) {
            i = this.a.getMapType();
        }
        switch (i) {
            case 0:
                dy.a("maptype", "glmapview");
                ecVar = new ec(context, this.a);
                break;
            case 1:
                ecVar = new ei(context, this.a);
                dy.a("maptype", "maprenderlayer");
                break;
            case 2:
                ecVar = new ea(context, this.a);
                dy.a("maptype", "texturemapview");
                break;
            default:
                ecVar = new ec(context, this.a);
                break;
        }
        AppMethodBeat.o(101277);
        return ecVar;
    }
}

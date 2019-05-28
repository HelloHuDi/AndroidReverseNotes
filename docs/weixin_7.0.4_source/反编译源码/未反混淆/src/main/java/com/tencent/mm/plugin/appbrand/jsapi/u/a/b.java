package com.tencent.mm.plugin.appbrand.jsapi.u.a;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tencentmap.mapsdk.map.TencentMapOptions;
import java.util.Map;

public final class b extends a {
    private SurfaceTexture mSurfaceTexture;

    public b(Context context, String str, Map<String, Object> map) {
        super(context, str, map);
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final TencentMapOptions A(Map<String, Object> map) {
        SurfaceTexture surfaceTexture;
        int a;
        int a2;
        AppMethodBeat.i(117350);
        TencentMapOptions A = super.A(map);
        if (map != null) {
            Object obj = map.get("surface");
            if (obj instanceof SurfaceTexture) {
                surfaceTexture = (SurfaceTexture) obj;
                this.mSurfaceTexture = surfaceTexture;
                if (this.mSurfaceTexture == null) {
                    ab.e("MicroMsg.SameLayerMapView", "mSurface is null, return");
                }
                A.setExtSurface(new Surface(this.mSurfaceTexture));
                a = f.a((Map) map, "width", 0);
                a2 = f.a((Map) map, "height", 0);
                ab.i("MicroMsg.SameLayerMapView", "handler insert, position:[%d, %d]", Integer.valueOf(a), Integer.valueOf(a2));
                A.setExtSurfaceDimension(a, a2);
                A.setMapType(2);
                this.mSurfaceTexture.setDefaultBufferSize(a, a2);
                AppMethodBeat.o(117350);
                return A;
            }
        }
        surfaceTexture = null;
        this.mSurfaceTexture = surfaceTexture;
        if (this.mSurfaceTexture == null) {
        }
        A.setExtSurface(new Surface(this.mSurfaceTexture));
        a = f.a((Map) map, "width", 0);
        a2 = f.a((Map) map, "height", 0);
        ab.i("MicroMsg.SameLayerMapView", "handler insert, position:[%d, %d]", Integer.valueOf(a), Integer.valueOf(a2));
        A.setExtSurfaceDimension(a, a2);
        A.setMapType(2);
        this.mSurfaceTexture.setDefaultBufferSize(a, a2);
        AppMethodBeat.o(117350);
        return A;
    }

    public final void onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(117351);
        if (this.mSurfaceTexture == null) {
            AppMethodBeat.o(117351);
            return;
        }
        if (this.hMT != null) {
            this.hMT.onTouchEvent(motionEvent);
        }
        AppMethodBeat.o(117351);
    }

    public final void onSizeChanged(int i, int i2) {
        AppMethodBeat.i(117352);
        if (this.mSurfaceTexture != null) {
            this.mSurfaceTexture.setDefaultBufferSize(i, i2);
        }
        this.hMT.onSizeChanged(i, i2, i, i2);
        AppMethodBeat.o(117352);
    }

    public final boolean aDU() {
        return true;
    }
}

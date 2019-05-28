package com.tencent.p177mm.plugin.appbrand.jsapi.p317u.p318a;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C38303f;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C45601a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tencentmap.mapsdk.map.TencentMapOptions;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.a.b */
public final class C38388b extends C45601a {
    private SurfaceTexture mSurfaceTexture;

    public C38388b(Context context, String str, Map<String, Object> map) {
        super(context, str, map);
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: A */
    public final TencentMapOptions mo61042A(Map<String, Object> map) {
        SurfaceTexture surfaceTexture;
        int a;
        int a2;
        AppMethodBeat.m2504i(117350);
        TencentMapOptions A = super.mo61042A(map);
        if (map != null) {
            Object obj = map.get("surface");
            if (obj instanceof SurfaceTexture) {
                surfaceTexture = (SurfaceTexture) obj;
                this.mSurfaceTexture = surfaceTexture;
                if (this.mSurfaceTexture == null) {
                    C4990ab.m7412e("MicroMsg.SameLayerMapView", "mSurface is null, return");
                }
                A.setExtSurface(new Surface(this.mSurfaceTexture));
                a = C38303f.m64812a((Map) map, "width", 0);
                a2 = C38303f.m64812a((Map) map, "height", 0);
                C4990ab.m7417i("MicroMsg.SameLayerMapView", "handler insert, position:[%d, %d]", Integer.valueOf(a), Integer.valueOf(a2));
                A.setExtSurfaceDimension(a, a2);
                A.setMapType(2);
                this.mSurfaceTexture.setDefaultBufferSize(a, a2);
                AppMethodBeat.m2505o(117350);
                return A;
            }
        }
        surfaceTexture = null;
        this.mSurfaceTexture = surfaceTexture;
        if (this.mSurfaceTexture == null) {
        }
        A.setExtSurface(new Surface(this.mSurfaceTexture));
        a = C38303f.m64812a((Map) map, "width", 0);
        a2 = C38303f.m64812a((Map) map, "height", 0);
        C4990ab.m7417i("MicroMsg.SameLayerMapView", "handler insert, position:[%d, %d]", Integer.valueOf(a), Integer.valueOf(a2));
        A.setExtSurfaceDimension(a, a2);
        A.setMapType(2);
        this.mSurfaceTexture.setDefaultBufferSize(a, a2);
        AppMethodBeat.m2505o(117350);
        return A;
    }

    public final void onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(117351);
        if (this.mSurfaceTexture == null) {
            AppMethodBeat.m2505o(117351);
            return;
        }
        if (this.hMT != null) {
            this.hMT.onTouchEvent(motionEvent);
        }
        AppMethodBeat.m2505o(117351);
    }

    public final void onSizeChanged(int i, int i2) {
        AppMethodBeat.m2504i(117352);
        if (this.mSurfaceTexture != null) {
            this.mSurfaceTexture.setDefaultBufferSize(i, i2);
        }
        this.hMT.onSizeChanged(i, i2, i, i2);
        AppMethodBeat.m2505o(117352);
    }

    public final boolean aDU() {
        return true;
    }
}

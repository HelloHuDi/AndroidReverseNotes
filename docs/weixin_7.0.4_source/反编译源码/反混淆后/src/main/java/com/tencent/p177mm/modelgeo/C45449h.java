package com.tencent.p177mm.modelgeo;

import android.content.Context;
import android.os.Looper;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationManagerOptions;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

/* renamed from: com.tencent.mm.modelgeo.h */
public final class C45449h {
    private static C45449h fCh = null;
    private static Context mContext;

    /* renamed from: com.tencent.mm.modelgeo.h$a */
    public static class C42209a extends Exception {
    }

    private C45449h() {
    }

    /* renamed from: bY */
    public static C45449h m83721bY(Context context) {
        AppMethodBeat.m2504i(78148);
        if (fCh == null) {
            fCh = new C45449h();
        }
        mContext = context;
        C45449h c45449h = fCh;
        AppMethodBeat.m2505o(78148);
        return c45449h;
    }

    public static void agE() {
        AppMethodBeat.m2504i(78149);
        C4990ab.m7410d("MicroMsg.SLocationManager", "removeUpdate");
        TencentLocationManager.getInstance(mContext).removeUpdates(null);
        AppMethodBeat.m2505o(78149);
    }

    /* renamed from: a */
    public static void m83720a(TencentLocationListener tencentLocationListener, int i, Looper looper) {
        AppMethodBeat.m2504i(78150);
        C4990ab.m7411d("MicroMsg.SLocationManager", "requestLocationUpdate %s, isLoaded %b", Integer.valueOf(i), Boolean.valueOf(TencentLocationManagerOptions.isLoadLibraryEnabled()));
        C7060h.pYm.mo8378a(584, 0, 1, true);
        TencentLocationManager.getInstance(mContext).setCoordinateType(i);
        TencentLocationRequest create = TencentLocationRequest.create();
        create.setInterval(FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        int requestLocationUpdates = TencentLocationManager.getInstance(mContext).requestLocationUpdates(create, tencentLocationListener, looper);
        C4990ab.m7417i("MicroMsg.SLocationManager", "requestCode %d", Integer.valueOf(requestLocationUpdates));
        AppMethodBeat.m2505o(78150);
    }
}

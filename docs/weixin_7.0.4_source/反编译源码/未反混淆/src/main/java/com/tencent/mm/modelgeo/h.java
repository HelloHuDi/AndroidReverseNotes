package com.tencent.mm.modelgeo;

import android.content.Context;
import android.os.Looper;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationManagerOptions;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

public final class h {
    private static h fCh = null;
    private static Context mContext;

    public static class a extends Exception {
    }

    private h() {
    }

    public static h bY(Context context) {
        AppMethodBeat.i(78148);
        if (fCh == null) {
            fCh = new h();
        }
        mContext = context;
        h hVar = fCh;
        AppMethodBeat.o(78148);
        return hVar;
    }

    public static void agE() {
        AppMethodBeat.i(78149);
        ab.d("MicroMsg.SLocationManager", "removeUpdate");
        TencentLocationManager.getInstance(mContext).removeUpdates(null);
        AppMethodBeat.o(78149);
    }

    public static void a(TencentLocationListener tencentLocationListener, int i, Looper looper) {
        AppMethodBeat.i(78150);
        ab.d("MicroMsg.SLocationManager", "requestLocationUpdate %s, isLoaded %b", Integer.valueOf(i), Boolean.valueOf(TencentLocationManagerOptions.isLoadLibraryEnabled()));
        com.tencent.mm.plugin.report.service.h.pYm.a(584, 0, 1, true);
        TencentLocationManager.getInstance(mContext).setCoordinateType(i);
        TencentLocationRequest create = TencentLocationRequest.create();
        create.setInterval(FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        int requestLocationUpdates = TencentLocationManager.getInstance(mContext).requestLocationUpdates(create, tencentLocationListener, looper);
        ab.i("MicroMsg.SLocationManager", "requestCode %d", Integer.valueOf(requestLocationUpdates));
        AppMethodBeat.o(78150);
    }
}

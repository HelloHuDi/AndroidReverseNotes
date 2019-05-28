package com.tencent.mm.compatible.e;

import android.annotation.TargetApi;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Looper;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.d.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.wxmm.v2helper;

final class f implements a {
    f() {
    }

    @TargetApi(8)
    public static a.a a(int i, Looper looper) {
        AppMethodBeat.i(92928);
        a.a aVar = new a.a();
        try {
            aVar.erH = u.c(looper);
            aVar.rotate = 90;
            if (aVar.erH == null) {
                AppMethodBeat.o(92928);
                return null;
            }
            int i2;
            int i3;
            CameraInfo cameraInfo = new CameraInfo();
            Camera.getCameraInfo(i, cameraInfo);
            switch (((WindowManager) ah.getContext().getSystemService("window")).getDefaultDisplay().getRotation()) {
                case 0:
                    i2 = 0;
                    break;
                case 1:
                    i2 = 90;
                    break;
                case 2:
                    i2 = 180;
                    break;
                case 3:
                    i2 = 270;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            if (cameraInfo.facing == 1) {
                i3 = (360 - ((cameraInfo.orientation + i2) % v2helper.VOIP_ENC_HEIGHT_LV1)) % v2helper.VOIP_ENC_HEIGHT_LV1;
            } else {
                i3 = ((cameraInfo.orientation - i2) + v2helper.VOIP_ENC_HEIGHT_LV1) % v2helper.VOIP_ENC_HEIGHT_LV1;
            }
            ab.d("MicroMsg.CameraUtil.CameraUtilImpl22", "CameraUtilImpl22, open camera, info.orientation: %d, degrees: %d, result:%d", Integer.valueOf(cameraInfo.orientation), Integer.valueOf(i2), Integer.valueOf(i3));
            aVar.erH.setDisplayOrientation(i3);
            AppMethodBeat.o(92928);
            return aVar;
        } catch (Exception e) {
            AppMethodBeat.o(92928);
            return null;
        }
    }
}

package com.tencent.mm.compatible.e;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Looper;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.d.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.wxmm.v2helper;

public final class g implements a {
    public static a.a a(Context context, int i, Looper looper) {
        AppMethodBeat.i(92929);
        a.a aVar = new a.a();
        aVar.erH = null;
        try {
            long yz = bo.yz();
            ab.i("MicroMsg.CameraUtil", "ashu::begin to try Call Camera.open cameraID %d", Integer.valueOf(i));
            aVar.erH = u.b(i, looper);
            ab.i("MicroMsg.CameraUtil", "ashu::Call Camera.open back, use %dms", Long.valueOf(bo.az(yz)));
            if (aVar.erH == null) {
                ab.e("MicroMsg.CameraUtil", "open camera error, not exception, but camera null");
                AppMethodBeat.o(92929);
                return null;
            }
            int i2;
            CameraInfo cameraInfo = new CameraInfo();
            yz = bo.yz();
            ab.i("MicroMsg.CameraUtil", "ashu::begin to Call Camera.getCameraInfo cameraID %d", Integer.valueOf(i));
            Camera.getCameraInfo(i, cameraInfo);
            ab.i("MicroMsg.CameraUtil", "ashu::Call Camera.getCameraInfo back, use %dms", Long.valueOf(bo.az(yz)));
            switch (((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation()) {
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
                i2 = (360 - (cameraInfo.orientation % v2helper.VOIP_ENC_HEIGHT_LV1)) % v2helper.VOIP_ENC_HEIGHT_LV1;
            } else {
                i2 = ((cameraInfo.orientation - i2) + v2helper.VOIP_ENC_HEIGHT_LV1) % v2helper.VOIP_ENC_HEIGHT_LV1;
            }
            yz = bo.yz();
            ab.i("MicroMsg.CameraUtil", "ashu::begin to Call Camera.setDisplayOrientation %d", Integer.valueOf(i2));
            aVar.erH.setDisplayOrientation(i2);
            ab.i("MicroMsg.CameraUtil", "ashu::Call Camera.setDisplayOrientation back, use %dms", Long.valueOf(bo.az(yz)));
            aVar.rotate = cameraInfo.orientation;
            AppMethodBeat.o(92929);
            return aVar;
        } catch (Exception e) {
            ab.e("MicroMsg.CameraUtil", "open camera error %s", e.getMessage());
            ab.printErrStackTrace("MicroMsg.CameraUtil", e, "", new Object[0]);
            AppMethodBeat.o(92929);
            return null;
        }
    }
}

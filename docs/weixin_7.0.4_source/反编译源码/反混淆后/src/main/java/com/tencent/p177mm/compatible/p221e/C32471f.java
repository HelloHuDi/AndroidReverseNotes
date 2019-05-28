package com.tencent.p177mm.compatible.p221e;

import android.annotation.TargetApi;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Looper;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C32468d.C32469a;
import com.tencent.p177mm.compatible.p221e.C32468d.C32469a.C32470a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.wxmm.v2helper;

/* renamed from: com.tencent.mm.compatible.e.f */
final class C32471f implements C32469a {
    C32471f() {
    }

    @TargetApi(8)
    /* renamed from: a */
    public static C32470a m53156a(int i, Looper looper) {
        AppMethodBeat.m2504i(92928);
        C32470a c32470a = new C32470a();
        try {
            c32470a.erH = C41939u.m74076c(looper);
            c32470a.rotate = 90;
            if (c32470a.erH == null) {
                AppMethodBeat.m2505o(92928);
                return null;
            }
            int i2;
            int i3;
            CameraInfo cameraInfo = new CameraInfo();
            Camera.getCameraInfo(i, cameraInfo);
            switch (((WindowManager) C4996ah.getContext().getSystemService("window")).getDefaultDisplay().getRotation()) {
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
            C4990ab.m7411d("MicroMsg.CameraUtil.CameraUtilImpl22", "CameraUtilImpl22, open camera, info.orientation: %d, degrees: %d, result:%d", Integer.valueOf(cameraInfo.orientation), Integer.valueOf(i2), Integer.valueOf(i3));
            c32470a.erH.setDisplayOrientation(i3);
            AppMethodBeat.m2505o(92928);
            return c32470a;
        } catch (Exception e) {
            AppMethodBeat.m2505o(92928);
            return null;
        }
    }
}

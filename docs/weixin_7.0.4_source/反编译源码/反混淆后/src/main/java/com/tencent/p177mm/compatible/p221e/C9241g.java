package com.tencent.p177mm.compatible.p221e;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Looper;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C32468d.C32469a;
import com.tencent.p177mm.compatible.p221e.C32468d.C32469a.C32470a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.wxmm.v2helper;

/* renamed from: com.tencent.mm.compatible.e.g */
public final class C9241g implements C32469a {
    /* renamed from: a */
    public static C32470a m16774a(Context context, int i, Looper looper) {
        AppMethodBeat.m2504i(92929);
        C32470a c32470a = new C32470a();
        c32470a.erH = null;
        try {
            long yz = C5046bo.m7588yz();
            C4990ab.m7417i("MicroMsg.CameraUtil", "ashu::begin to try Call Camera.open cameraID %d", Integer.valueOf(i));
            c32470a.erH = C41939u.m74074b(i, looper);
            C4990ab.m7417i("MicroMsg.CameraUtil", "ashu::Call Camera.open back, use %dms", Long.valueOf(C5046bo.m7525az(yz)));
            if (c32470a.erH == null) {
                C4990ab.m7412e("MicroMsg.CameraUtil", "open camera error, not exception, but camera null");
                AppMethodBeat.m2505o(92929);
                return null;
            }
            int i2;
            CameraInfo cameraInfo = new CameraInfo();
            yz = C5046bo.m7588yz();
            C4990ab.m7417i("MicroMsg.CameraUtil", "ashu::begin to Call Camera.getCameraInfo cameraID %d", Integer.valueOf(i));
            Camera.getCameraInfo(i, cameraInfo);
            C4990ab.m7417i("MicroMsg.CameraUtil", "ashu::Call Camera.getCameraInfo back, use %dms", Long.valueOf(C5046bo.m7525az(yz)));
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
            yz = C5046bo.m7588yz();
            C4990ab.m7417i("MicroMsg.CameraUtil", "ashu::begin to Call Camera.setDisplayOrientation %d", Integer.valueOf(i2));
            c32470a.erH.setDisplayOrientation(i2);
            C4990ab.m7417i("MicroMsg.CameraUtil", "ashu::Call Camera.setDisplayOrientation back, use %dms", Long.valueOf(C5046bo.m7525az(yz)));
            c32470a.rotate = cameraInfo.orientation;
            AppMethodBeat.m2505o(92929);
            return c32470a;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.CameraUtil", "open camera error %s", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.CameraUtil", e, "", new Object[0]);
            AppMethodBeat.m2505o(92929);
            return null;
        }
    }
}

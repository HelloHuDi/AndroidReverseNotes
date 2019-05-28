package com.tencent.p177mm.compatible.p221e;

import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C32468d.C32469a;
import com.tencent.p177mm.compatible.p221e.C32468d.C32469a.C32470a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.compatible.e.i */
final class C9242i implements C32469a {
    C9242i() {
    }

    public static int getNumberOfCameras() {
        AppMethodBeat.m2504i(92930);
        int numberOfCameras;
        if (!C1427q.etc.erh || C1427q.etc.erg == -1) {
            numberOfCameras = C32468d.getNumberOfCameras();
            C4990ab.m7410d("CameraUtilImplConfig", "getNumberOfCameras ".concat(String.valueOf(numberOfCameras)));
            if (numberOfCameras > 1) {
                AppMethodBeat.m2505o(92930);
                return numberOfCameras;
            }
            AppMethodBeat.m2505o(92930);
            return 0;
        }
        numberOfCameras = C1427q.etc.erg;
        C4990ab.m7410d("CameraUtilImplConfig", "mVRCameraNum ".concat(String.valueOf(numberOfCameras)));
        AppMethodBeat.m2505o(92930);
        return numberOfCameras;
    }

    /* renamed from: a */
    public static C32470a m16775a(int i, Looper looper) {
        AppMethodBeat.m2504i(92931);
        C32470a c32470a = new C32470a();
        c32470a.erH = null;
        try {
            c32470a.erH = C41939u.m74074b(i, looper);
            if (c32470a.erH == null) {
                AppMethodBeat.m2505o(92931);
                return null;
            }
            c32470a.rotate = 0;
            C4990ab.m7410d("CameraUtilImplConfig", "DeviceInfo.mCameraInfo.hasVRInfo " + C1427q.etc.erb);
            C4990ab.m7410d("CameraUtilImplConfig", "DeviceInfo.mCameraInfo.mVRFaceRotate " + C1427q.etc.erc);
            C4990ab.m7410d("CameraUtilImplConfig", "DeviceInfo.mCameraInfo.mVRFaceDisplayOrientation " + C1427q.etc.erd);
            C4990ab.m7410d("CameraUtilImplConfig", "DeviceInfo.mCameraInfo.mVRBackRotate " + C1427q.etc.ere);
            C4990ab.m7410d("CameraUtilImplConfig", "DeviceInfo.mCameraInfo.mVRBackDisplayOrientation " + C1427q.etc.erf);
            if (C9242i.getNumberOfCameras() > 1) {
                try {
                    CameraInfo cameraInfo = new CameraInfo();
                    Camera.getCameraInfo(i, cameraInfo);
                    C4990ab.m7410d("CameraUtilImplConfig", "info.facing " + cameraInfo.facing);
                    if (cameraInfo.facing == 1) {
                        if (C1427q.etc.erb && C1427q.etc.erc != -1) {
                            c32470a.rotate = C1427q.etc.erc;
                        }
                        if (C1427q.etc.erb && C1427q.etc.erd != -1) {
                            c32470a.erH.setDisplayOrientation(C1427q.etc.erd);
                        }
                    } else {
                        if (C1427q.etc.erb && C1427q.etc.ere != -1) {
                            c32470a.rotate = C1427q.etc.ere;
                        }
                        if (C1427q.etc.erb && C1427q.etc.erf != -1) {
                            c32470a.erH.setDisplayOrientation(C1427q.etc.erf);
                        }
                    }
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("CameraUtilImplConfig", e, "", new Object[0]);
                }
            } else {
                if (C1427q.etc.erb && C1427q.etc.ere != -1) {
                    c32470a.rotate = C1427q.etc.ere;
                }
                if (C1427q.etc.erb && C1427q.etc.erf != -1) {
                    c32470a.erH.setDisplayOrientation(C1427q.etc.erf);
                }
            }
            AppMethodBeat.m2505o(92931);
            return c32470a;
        } catch (Exception e2) {
            AppMethodBeat.m2505o(92931);
            return null;
        }
    }
}

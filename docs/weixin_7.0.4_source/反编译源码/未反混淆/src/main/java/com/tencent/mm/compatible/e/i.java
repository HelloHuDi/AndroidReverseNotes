package com.tencent.mm.compatible.e;

import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.d.a;
import com.tencent.mm.sdk.platformtools.ab;

final class i implements a {
    i() {
    }

    public static int getNumberOfCameras() {
        AppMethodBeat.i(92930);
        int numberOfCameras;
        if (!q.etc.erh || q.etc.erg == -1) {
            numberOfCameras = d.getNumberOfCameras();
            ab.d("CameraUtilImplConfig", "getNumberOfCameras ".concat(String.valueOf(numberOfCameras)));
            if (numberOfCameras > 1) {
                AppMethodBeat.o(92930);
                return numberOfCameras;
            }
            AppMethodBeat.o(92930);
            return 0;
        }
        numberOfCameras = q.etc.erg;
        ab.d("CameraUtilImplConfig", "mVRCameraNum ".concat(String.valueOf(numberOfCameras)));
        AppMethodBeat.o(92930);
        return numberOfCameras;
    }

    public static a.a a(int i, Looper looper) {
        AppMethodBeat.i(92931);
        a.a aVar = new a.a();
        aVar.erH = null;
        try {
            aVar.erH = u.b(i, looper);
            if (aVar.erH == null) {
                AppMethodBeat.o(92931);
                return null;
            }
            aVar.rotate = 0;
            ab.d("CameraUtilImplConfig", "DeviceInfo.mCameraInfo.hasVRInfo " + q.etc.erb);
            ab.d("CameraUtilImplConfig", "DeviceInfo.mCameraInfo.mVRFaceRotate " + q.etc.erc);
            ab.d("CameraUtilImplConfig", "DeviceInfo.mCameraInfo.mVRFaceDisplayOrientation " + q.etc.erd);
            ab.d("CameraUtilImplConfig", "DeviceInfo.mCameraInfo.mVRBackRotate " + q.etc.ere);
            ab.d("CameraUtilImplConfig", "DeviceInfo.mCameraInfo.mVRBackDisplayOrientation " + q.etc.erf);
            if (getNumberOfCameras() > 1) {
                try {
                    CameraInfo cameraInfo = new CameraInfo();
                    Camera.getCameraInfo(i, cameraInfo);
                    ab.d("CameraUtilImplConfig", "info.facing " + cameraInfo.facing);
                    if (cameraInfo.facing == 1) {
                        if (q.etc.erb && q.etc.erc != -1) {
                            aVar.rotate = q.etc.erc;
                        }
                        if (q.etc.erb && q.etc.erd != -1) {
                            aVar.erH.setDisplayOrientation(q.etc.erd);
                        }
                    } else {
                        if (q.etc.erb && q.etc.ere != -1) {
                            aVar.rotate = q.etc.ere;
                        }
                        if (q.etc.erb && q.etc.erf != -1) {
                            aVar.erH.setDisplayOrientation(q.etc.erf);
                        }
                    }
                } catch (Exception e) {
                    ab.printErrStackTrace("CameraUtilImplConfig", e, "", new Object[0]);
                }
            } else {
                if (q.etc.erb && q.etc.ere != -1) {
                    aVar.rotate = q.etc.ere;
                }
                if (q.etc.erb && q.etc.erf != -1) {
                    aVar.erH.setDisplayOrientation(q.etc.erf);
                }
            }
            AppMethodBeat.o(92931);
            return aVar;
        } catch (Exception e2) {
            AppMethodBeat.o(92931);
            return null;
        }
    }
}

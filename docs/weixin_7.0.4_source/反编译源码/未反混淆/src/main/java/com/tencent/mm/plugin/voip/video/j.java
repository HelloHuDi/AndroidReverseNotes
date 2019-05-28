package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.baseutils.IOUtils;

public final class j {
    public static h tbr;
    public static int tbs = -1;
    public static int tbt = -1;
    public static int tbu = 0;
    public static int tbv = 0;
    public static int tbw = 0;
    public static boolean tbx = true;

    public static boolean cLO() {
        if (q.etc.eqT && q.etc.eqS == 8) {
            return false;
        }
        return true;
    }

    private static boolean cLP() {
        boolean z = false;
        AppMethodBeat.i(5112);
        try {
            if (Class.forName("android.hardware.Camera").getDeclaredMethod("getNumberOfCameras", null) == null) {
                ab.d("GetfcMethod", "GetfcMethod is null");
            } else {
                z = true;
            }
        } catch (Exception e) {
            ab.e("MicroMsg.CameraUtil", "find getNumberOfCameras failed: " + e.getMessage());
        }
        AppMethodBeat.o(5112);
        return z;
    }

    public static void fi(Context context) {
        AppMethodBeat.i(5113);
        if (tbr != null) {
            AppMethodBeat.o(5113);
            return;
        }
        tbr = new h("*");
        boolean cLP = cLP();
        tbx = cLP;
        if (!cLP || q.etc.eqR) {
            if (tbx && q.etc.eqR) {
                cLQ();
            }
            if (q.etc.eqR) {
                tbr.eqQ = q.etc.eqQ;
            }
            if (q.etc.era) {
                if (q.etc.eqZ.erD != 0) {
                    tbr.tal = true;
                } else {
                    tbr.tal = false;
                }
            }
            if (q.etc.eqY) {
                if (q.etc.eqX.erD != 0) {
                    tbr.tak = true;
                } else {
                    tbr.tak = false;
                }
            }
            if (q.etc.eqY && q.etc.eqX.erE >= 0) {
                tbr.tam = q.etc.eqX.erE;
                tbu = tbr.tam;
            }
            if (q.etc.era && q.etc.eqZ.erE >= 0) {
                tbr.tan = q.etc.eqZ.erE;
                tbv = tbr.tan;
            }
            if (q.etc.eqY) {
                if (tbr.tao == null) {
                    tbr.tao = new Point(0, 0);
                }
                tbr.tao = new Point(q.etc.eqX.width, q.etc.eqX.height);
            }
            if (q.etc.era) {
                if (tbr.tap == null) {
                    tbr.tap = new Point(0, 0);
                }
                tbr.tap = new Point(q.etc.eqZ.width, q.etc.eqZ.height);
            }
            if (q.etc.era && q.etc.eqZ.fps != 0) {
                tbr.taj = q.etc.eqZ.fps;
            }
            if (q.etc.eqY && q.etc.eqX.fps != 0) {
                tbr.taj = q.etc.eqX.fps;
            }
            PackageManager packageManager = context.getPackageManager();
            if (!(q.etc.eqR || packageManager.hasSystemFeature("android.hardware.camera"))) {
                tbr.eqQ = 0;
                tbr.tak = false;
                tbr.tal = false;
            }
        } else {
            cLQ();
        }
        if (q.etc.aTf) {
            tbw = q.etc.eqW;
        }
        ab.i("MicroMsg.CameraUtil", "gCameraNum:" + tbr.eqQ + "\ngIsHasFrontCamera:" + tbr.tak + "\ngIsHasBackCamera:" + tbr.tal + "\ngFrontCameraId:" + tbs + "\ngBackCameraId:" + tbt + "\ngBackOrientation:" + tbr.tan + "\ngFrontOrientation:" + tbr.tam + "\ngBestFps:" + tbr.taj + "\ngFacePreviewSize:" + tbr.tao + "\ngNonFacePreviewSize:" + tbr.tap + "\ngFaceCameraIsRotate180:" + tbu + "\ngMainCameraIsRotate180:" + tbv + "\ngCameraFormat:" + tbw + "\ngFaceNotRotate:SDK:" + VERSION.SDK_INT + IOUtils.LINE_SEPARATOR_UNIX);
        AppMethodBeat.o(5113);
    }

    private static void cLQ() {
        AppMethodBeat.i(5114);
        tbr.eqQ = Camera.getNumberOfCameras();
        CameraInfo cameraInfo = new CameraInfo();
        int i = 0;
        while (i < tbr.eqQ) {
            try {
                Camera.getCameraInfo(i, cameraInfo);
                if (cameraInfo.facing == 1) {
                    tbs = i;
                    tbr.tam = cameraInfo.orientation;
                    tbr.tak = true;
                } else if (cameraInfo.facing == 0) {
                    tbt = i;
                    tbr.tan = cameraInfo.orientation;
                    tbr.tal = true;
                }
                i++;
            } catch (Exception e) {
                ab.e("MicroMsg.CameraUtil", "get camera info error: %s", e.getMessage());
            }
        }
        String property = System.getProperty("ro.media.enc.camera.platform", null);
        boolean equalsIgnoreCase = property == null ? false : property.equalsIgnoreCase("Mediatek");
        if (tbr.tam == 270 || (equalsIgnoreCase && tbr.tam == 0)) {
            tbu = 1;
        } else {
            tbu = 0;
        }
        if (tbr.tan == 270 || (equalsIgnoreCase && tbr.tan == 0)) {
            tbv = 1;
            AppMethodBeat.o(5114);
            return;
        }
        tbv = 0;
        AppMethodBeat.o(5114);
    }
}

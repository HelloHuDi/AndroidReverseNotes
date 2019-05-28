package com.tencent.p177mm.plugin.voip.video;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.plugin.voip.video.j */
public final class C43739j {
    public static C29513h tbr;
    public static int tbs = -1;
    public static int tbt = -1;
    public static int tbu = 0;
    public static int tbv = 0;
    public static int tbw = 0;
    public static boolean tbx = true;

    public static boolean cLO() {
        if (C1427q.etc.eqT && C1427q.etc.eqS == 8) {
            return false;
        }
        return true;
    }

    private static boolean cLP() {
        boolean z = false;
        AppMethodBeat.m2504i(5112);
        try {
            if (Class.forName("android.hardware.Camera").getDeclaredMethod("getNumberOfCameras", null) == null) {
                C4990ab.m7410d("GetfcMethod", "GetfcMethod is null");
            } else {
                z = true;
            }
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.CameraUtil", "find getNumberOfCameras failed: " + e.getMessage());
        }
        AppMethodBeat.m2505o(5112);
        return z;
    }

    /* renamed from: fi */
    public static void m78420fi(Context context) {
        AppMethodBeat.m2504i(5113);
        if (tbr != null) {
            AppMethodBeat.m2505o(5113);
            return;
        }
        tbr = new C29513h("*");
        boolean cLP = C43739j.cLP();
        tbx = cLP;
        if (!cLP || C1427q.etc.eqR) {
            if (tbx && C1427q.etc.eqR) {
                C43739j.cLQ();
            }
            if (C1427q.etc.eqR) {
                tbr.eqQ = C1427q.etc.eqQ;
            }
            if (C1427q.etc.era) {
                if (C1427q.etc.eqZ.erD != 0) {
                    tbr.tal = true;
                } else {
                    tbr.tal = false;
                }
            }
            if (C1427q.etc.eqY) {
                if (C1427q.etc.eqX.erD != 0) {
                    tbr.tak = true;
                } else {
                    tbr.tak = false;
                }
            }
            if (C1427q.etc.eqY && C1427q.etc.eqX.erE >= 0) {
                tbr.tam = C1427q.etc.eqX.erE;
                tbu = tbr.tam;
            }
            if (C1427q.etc.era && C1427q.etc.eqZ.erE >= 0) {
                tbr.tan = C1427q.etc.eqZ.erE;
                tbv = tbr.tan;
            }
            if (C1427q.etc.eqY) {
                if (tbr.tao == null) {
                    tbr.tao = new Point(0, 0);
                }
                tbr.tao = new Point(C1427q.etc.eqX.width, C1427q.etc.eqX.height);
            }
            if (C1427q.etc.era) {
                if (tbr.tap == null) {
                    tbr.tap = new Point(0, 0);
                }
                tbr.tap = new Point(C1427q.etc.eqZ.width, C1427q.etc.eqZ.height);
            }
            if (C1427q.etc.era && C1427q.etc.eqZ.fps != 0) {
                tbr.taj = C1427q.etc.eqZ.fps;
            }
            if (C1427q.etc.eqY && C1427q.etc.eqX.fps != 0) {
                tbr.taj = C1427q.etc.eqX.fps;
            }
            PackageManager packageManager = context.getPackageManager();
            if (!(C1427q.etc.eqR || packageManager.hasSystemFeature("android.hardware.camera"))) {
                tbr.eqQ = 0;
                tbr.tak = false;
                tbr.tal = false;
            }
        } else {
            C43739j.cLQ();
        }
        if (C1427q.etc.aTf) {
            tbw = C1427q.etc.eqW;
        }
        C4990ab.m7416i("MicroMsg.CameraUtil", "gCameraNum:" + tbr.eqQ + "\ngIsHasFrontCamera:" + tbr.tak + "\ngIsHasBackCamera:" + tbr.tal + "\ngFrontCameraId:" + tbs + "\ngBackCameraId:" + tbt + "\ngBackOrientation:" + tbr.tan + "\ngFrontOrientation:" + tbr.tam + "\ngBestFps:" + tbr.taj + "\ngFacePreviewSize:" + tbr.tao + "\ngNonFacePreviewSize:" + tbr.tap + "\ngFaceCameraIsRotate180:" + tbu + "\ngMainCameraIsRotate180:" + tbv + "\ngCameraFormat:" + tbw + "\ngFaceNotRotate:SDK:" + VERSION.SDK_INT + IOUtils.LINE_SEPARATOR_UNIX);
        AppMethodBeat.m2505o(5113);
    }

    private static void cLQ() {
        AppMethodBeat.m2504i(5114);
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
                C4990ab.m7413e("MicroMsg.CameraUtil", "get camera info error: %s", e.getMessage());
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
            AppMethodBeat.m2505o(5114);
            return;
        }
        tbv = 0;
        AppMethodBeat.m2505o(5114);
    }
}

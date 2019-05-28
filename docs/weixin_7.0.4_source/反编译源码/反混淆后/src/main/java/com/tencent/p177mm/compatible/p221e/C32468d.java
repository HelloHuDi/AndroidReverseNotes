package com.tencent.p177mm.compatible.p221e;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.compatible.e.d */
public final class C32468d {

    /* renamed from: com.tencent.mm.compatible.e.d$a */
    public interface C32469a {

        /* renamed from: com.tencent.mm.compatible.e.d$a$a */
        public static class C32470a {
            public C41938t erH;
            public int rotate;
        }
    }

    public static int getNumberOfCameras() {
        AppMethodBeat.m2504i(92922);
        int numberOfCameras;
        if (C1427q.etc.erb && C1427q.etc.erh) {
            C9242i c9242i = new C9242i();
            numberOfCameras = C9242i.getNumberOfCameras();
            AppMethodBeat.m2505o(92922);
            return numberOfCameras;
        }
        C9241g c9241g = new C9241g();
        numberOfCameras = Camera.getNumberOfCameras();
        AppMethodBeat.m2505o(92922);
        return numberOfCameras;
    }

    /* renamed from: Lr */
    public static int m53152Lr() {
        AppMethodBeat.m2504i(92923);
        if (C1427q.etn.esf == 1) {
            AppMethodBeat.m2505o(92923);
            return 0;
        }
        int numberOfCameras = Camera.getNumberOfCameras();
        CameraInfo cameraInfo = new CameraInfo();
        int i = 0;
        while (i < numberOfCameras) {
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == 0) {
                C4990ab.m7411d("MicroMsg.CameraUtil", "tigercam get bid %d", Integer.valueOf(i));
                break;
            }
            i++;
        }
        i = 0;
        C4990ab.m7411d("MicroMsg.CameraUtil", "tigercam getBackCameraId %d", Integer.valueOf(i));
        AppMethodBeat.m2505o(92923);
        return i;
    }

    /* renamed from: Ls */
    public static int m53153Ls() {
        AppMethodBeat.m2504i(92924);
        int numberOfCameras = Camera.getNumberOfCameras();
        CameraInfo cameraInfo = new CameraInfo();
        int i = 0;
        while (i < numberOfCameras) {
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == 1) {
                C4990ab.m7411d("MicroMsg.CameraUtil", "tigercam get fid %d", Integer.valueOf(i));
                break;
            }
            i++;
        }
        i = 0;
        C4990ab.m7411d("MicroMsg.CameraUtil", "tigercam getBackCameraId %d", Integer.valueOf(i));
        AppMethodBeat.m2505o(92924);
        return i;
    }

    /* renamed from: Lt */
    public static boolean m53154Lt() {
        AppMethodBeat.m2504i(92925);
        if (C1427q.etc.erj == 1) {
            AppMethodBeat.m2505o(92925);
            return true;
        } else if (VERSION.SDK_INT == 10 && Build.MODEL.equals("GT-S5360")) {
            AppMethodBeat.m2505o(92925);
            return true;
        } else {
            AppMethodBeat.m2505o(92925);
            return false;
        }
    }

    /* renamed from: a */
    public static C32470a m53155a(Context context, int i, Looper looper) {
        AppMethodBeat.m2504i(92926);
        C32470a b;
        if (C1427q.etc.erj == 1) {
            C4990ab.m7410d("MicroMsg.CameraUtil", "openCamera(), CameraUtilImpl20, cameraId = ".concat(String.valueOf(i)));
            C37656e c37656e = new C37656e();
            b = C37656e.m63679b(looper);
            AppMethodBeat.m2505o(92926);
            return b;
        } else if (C1427q.etc.erb) {
            C4990ab.m7410d("MicroMsg.CameraUtil", "openCamera(), CameraUtilImplConfig, cameraId = ".concat(String.valueOf(i)));
            C9242i c9242i = new C9242i();
            b = C9242i.m16775a(i, looper);
            AppMethodBeat.m2505o(92926);
            return b;
        } else if (Build.MODEL.equals("M9")) {
            C9243j c9243j = new C9243j();
            b = C9243j.m16776b(looper);
            AppMethodBeat.m2505o(92926);
            return b;
        } else if (C32468d.getNumberOfCameras() > 1) {
            C4990ab.m7410d("MicroMsg.CameraUtil", "openCamera(), CameraUtilImpl23, cameraId = ".concat(String.valueOf(i)));
            C9241g c9241g = new C9241g();
            b = C9241g.m16774a(context, i, looper);
            AppMethodBeat.m2505o(92926);
            return b;
        } else {
            C32471f c32471f = new C32471f();
            b = C32471f.m53156a(i, looper);
            AppMethodBeat.m2505o(92926);
            return b;
        }
    }
}

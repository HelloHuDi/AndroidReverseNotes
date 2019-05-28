package com.tencent.mm.compatible.e;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class d {

    public interface a {

        public static class a {
            public t erH;
            public int rotate;
        }
    }

    public static int getNumberOfCameras() {
        AppMethodBeat.i(92922);
        int numberOfCameras;
        if (q.etc.erb && q.etc.erh) {
            i iVar = new i();
            numberOfCameras = i.getNumberOfCameras();
            AppMethodBeat.o(92922);
            return numberOfCameras;
        }
        g gVar = new g();
        numberOfCameras = Camera.getNumberOfCameras();
        AppMethodBeat.o(92922);
        return numberOfCameras;
    }

    public static int Lr() {
        AppMethodBeat.i(92923);
        if (q.etn.esf == 1) {
            AppMethodBeat.o(92923);
            return 0;
        }
        int numberOfCameras = Camera.getNumberOfCameras();
        CameraInfo cameraInfo = new CameraInfo();
        int i = 0;
        while (i < numberOfCameras) {
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == 0) {
                ab.d("MicroMsg.CameraUtil", "tigercam get bid %d", Integer.valueOf(i));
                break;
            }
            i++;
        }
        i = 0;
        ab.d("MicroMsg.CameraUtil", "tigercam getBackCameraId %d", Integer.valueOf(i));
        AppMethodBeat.o(92923);
        return i;
    }

    public static int Ls() {
        AppMethodBeat.i(92924);
        int numberOfCameras = Camera.getNumberOfCameras();
        CameraInfo cameraInfo = new CameraInfo();
        int i = 0;
        while (i < numberOfCameras) {
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == 1) {
                ab.d("MicroMsg.CameraUtil", "tigercam get fid %d", Integer.valueOf(i));
                break;
            }
            i++;
        }
        i = 0;
        ab.d("MicroMsg.CameraUtil", "tigercam getBackCameraId %d", Integer.valueOf(i));
        AppMethodBeat.o(92924);
        return i;
    }

    public static boolean Lt() {
        AppMethodBeat.i(92925);
        if (q.etc.erj == 1) {
            AppMethodBeat.o(92925);
            return true;
        } else if (VERSION.SDK_INT == 10 && Build.MODEL.equals("GT-S5360")) {
            AppMethodBeat.o(92925);
            return true;
        } else {
            AppMethodBeat.o(92925);
            return false;
        }
    }

    public static a a(Context context, int i, Looper looper) {
        AppMethodBeat.i(92926);
        a b;
        if (q.etc.erj == 1) {
            ab.d("MicroMsg.CameraUtil", "openCamera(), CameraUtilImpl20, cameraId = ".concat(String.valueOf(i)));
            e eVar = new e();
            b = e.b(looper);
            AppMethodBeat.o(92926);
            return b;
        } else if (q.etc.erb) {
            ab.d("MicroMsg.CameraUtil", "openCamera(), CameraUtilImplConfig, cameraId = ".concat(String.valueOf(i)));
            i iVar = new i();
            b = i.a(i, looper);
            AppMethodBeat.o(92926);
            return b;
        } else if (Build.MODEL.equals("M9")) {
            j jVar = new j();
            b = j.b(looper);
            AppMethodBeat.o(92926);
            return b;
        } else if (getNumberOfCameras() > 1) {
            ab.d("MicroMsg.CameraUtil", "openCamera(), CameraUtilImpl23, cameraId = ".concat(String.valueOf(i)));
            g gVar = new g();
            b = g.a(context, i, looper);
            AppMethodBeat.o(92926);
            return b;
        } else {
            f fVar = new f();
            b = f.a(i, looper);
            AppMethodBeat.o(92926);
            return b;
        }
    }
}

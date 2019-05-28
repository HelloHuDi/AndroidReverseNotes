package com.tencent.liteav.capturer;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Build.VERSION;
import com.tencent.liteav.basic.f.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.ActUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.wxmm.v2helper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class a implements AutoFocusCallback {
    private static final String c = a.class.getSimpleName();
    private Matrix a = new Matrix();
    private int b = 0;
    private Camera d;
    private boolean e = true;
    private int f = 15;
    private int g;
    private int h = 1;
    private int i;
    private int j;
    private int k;
    private int l;
    private SurfaceTexture m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q = false;

    class a {
        public int a = ActUtil.HEIGHT;
        public int b = 720;

        a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    public a() {
        AppMethodBeat.i(67810);
        AppMethodBeat.o(67810);
    }

    public void a(SurfaceTexture surfaceTexture) {
        this.m = surfaceTexture;
    }

    public boolean a(boolean z) {
        AppMethodBeat.i(67811);
        this.p = z;
        if (this.d != null) {
            boolean z2 = true;
            Parameters parameters = this.d.getParameters();
            List supportedFlashModes = parameters.getSupportedFlashModes();
            if (z) {
                if (supportedFlashModes == null || !supportedFlashModes.contains("torch")) {
                    z2 = false;
                } else {
                    TXCLog.i(c, "set FLASH_MODE_TORCH");
                    parameters.setFlashMode("torch");
                }
            } else if (supportedFlashModes == null || !supportedFlashModes.contains("off")) {
                z2 = false;
            } else {
                TXCLog.i(c, "set FLASH_MODE_OFF");
                parameters.setFlashMode("off");
            }
            try {
                this.d.setParameters(parameters);
            } catch (Exception e) {
                z2 = false;
            }
            AppMethodBeat.o(67811);
            return z2;
        }
        AppMethodBeat.o(67811);
        return false;
    }

    public void a(int i) {
        this.g = i;
    }

    public void b(int i) {
        this.f = i;
    }

    public void a(float f, float f2) {
        AppMethodBeat.i(67812);
        if (this.q) {
            try {
                ArrayList arrayList;
                this.d.cancelAutoFocus();
                Parameters parameters = this.d.getParameters();
                if (this.n) {
                    arrayList = new ArrayList();
                    arrayList.add(new Area(a(f, f2, 2.0f), 1000));
                    parameters.setFocusAreas(arrayList);
                }
                if (this.o) {
                    arrayList = new ArrayList();
                    arrayList.add(new Area(a(f, f2, 3.0f), 1000));
                    parameters.setMeteringAreas(arrayList);
                }
                try {
                    this.d.setParameters(parameters);
                    this.d.autoFocus(this);
                    AppMethodBeat.o(67812);
                    return;
                } catch (Exception e) {
                    AppMethodBeat.o(67812);
                    return;
                }
            } catch (Exception e2) {
                AppMethodBeat.o(67812);
                return;
            }
        }
        AppMethodBeat.o(67812);
    }

    public void b(boolean z) {
        this.q = z;
    }

    private Rect a(float f, float f2, float f3) {
        int i;
        int i2;
        int i3 = 1000;
        AppMethodBeat.i(67813);
        float f4 = 200.0f * f3;
        if (this.e) {
            f = 1.0f - f;
        }
        for (i = 0; i < this.k / 90; i++) {
            f = (-(-(f2 - 0.5f))) + 0.5f;
            f2 = (-(f - 0.5f)) + 0.5f;
        }
        int i4 = (int) ((f * 2000.0f) - 1000.0f);
        i = (int) ((f2 * 2000.0f) - 1000.0f);
        if (i4 < -1000) {
            i2 = -1000;
        } else {
            i2 = i4;
        }
        if (i < -1000) {
            i4 = -1000;
        } else {
            i4 = i;
        }
        i = i2 + ((int) f4);
        int i5 = ((int) f4) + i4;
        if (i > 1000) {
            i = 1000;
        }
        if (i5 <= 1000) {
            i3 = i5;
        }
        Rect rect = new Rect(i2, i4, i, i3);
        AppMethodBeat.o(67813);
        return rect;
    }

    public int a() {
        AppMethodBeat.i(67814);
        int i = 0;
        if (this.d != null) {
            Parameters parameters = this.d.getParameters();
            if (parameters.getMaxZoom() > 0 && parameters.isZoomSupported()) {
                i = parameters.getMaxZoom();
            }
        }
        AppMethodBeat.o(67814);
        return i;
    }

    public boolean c(int i) {
        boolean z = false;
        AppMethodBeat.i(67815);
        if (this.d != null) {
            Parameters parameters = this.d.getParameters();
            if (parameters.getMaxZoom() <= 0 || !parameters.isZoomSupported()) {
                TXCLog.e(c, "camera not support zoom!");
            } else if (i < 0 || i > parameters.getMaxZoom()) {
                TXCLog.e(c, "invalid zoom value : " + i + ", while max zoom is " + parameters.getMaxZoom());
            } else {
                try {
                    parameters.setZoom(i);
                    this.d.setParameters(parameters);
                    z = true;
                } catch (Exception e) {
                }
            }
        }
        AppMethodBeat.o(67815);
        return z;
    }

    public void a(float f) {
        float f2 = 1.0f;
        float f3 = -1.0f;
        AppMethodBeat.i(67816);
        if (this.d != null) {
            if (f <= 1.0f) {
                f2 = f;
            }
            if (f2 >= -1.0f) {
                f3 = f2;
            }
            Parameters parameters = this.d.getParameters();
            int minExposureCompensation = parameters.getMinExposureCompensation();
            int maxExposureCompensation = parameters.getMaxExposureCompensation();
            if (minExposureCompensation == 0 || maxExposureCompensation == 0) {
                TXCLog.e(c, "camera not support setExposureCompensation!");
            } else {
                int d = b.a().d();
                f3 *= (float) maxExposureCompensation;
                if (d != 0 && d <= maxExposureCompensation && d >= minExposureCompensation) {
                    TXCLog.d(c, "camera setExposureCompensation: ".concat(String.valueOf(d)));
                    parameters.setExposureCompensation(d);
                } else if (f3 <= ((float) maxExposureCompensation) && f3 >= ((float) minExposureCompensation)) {
                    TXCLog.d(c, "camera setExposureCompensation: ".concat(String.valueOf(f3)));
                    parameters.setExposureCompensation((int) f3);
                }
            }
            try {
                this.d.setParameters(parameters);
                AppMethodBeat.o(67816);
                return;
            } catch (Exception e) {
            }
        }
        AppMethodBeat.o(67816);
    }

    public void d(int i) {
        this.h = i;
        this.k = (((this.l - 90) + (this.h * 90)) + v2helper.VOIP_ENC_HEIGHT_LV1) % v2helper.VOIP_ENC_HEIGHT_LV1;
    }

    public int c(boolean z) {
        AppMethodBeat.i(67817);
        try {
            if (this.m == null) {
                AppMethodBeat.o(67817);
                return -2;
            }
            int i;
            if (this.d != null) {
                b();
            }
            CameraInfo cameraInfo = new CameraInfo();
            int i2 = -1;
            int i3 = -1;
            for (i = 0; i < Camera.getNumberOfCameras(); i++) {
                Camera.getCameraInfo(i, cameraInfo);
                TXCLog.i(c, "camera index " + i + ", facing = " + cameraInfo.facing);
                if (cameraInfo.facing == 1) {
                    i3 = i;
                }
                if (cameraInfo.facing == 0) {
                    i2 = i;
                }
            }
            TXCLog.i(c, "camera front, id = ".concat(String.valueOf(i3)));
            TXCLog.i(c, "camera back , id = ".concat(String.valueOf(i2)));
            if (i3 != -1 || i2 == -1) {
                i = i3;
            } else {
                i = i2;
            }
            if (i2 != -1 || i == -1) {
                i3 = i2;
            } else {
                i3 = i;
            }
            this.e = z;
            if (this.e) {
                this.d = Camera.open(i);
            } else {
                this.d = Camera.open(i3);
            }
            Parameters parameters = this.d.getParameters();
            List supportedFocusModes = parameters.getSupportedFocusModes();
            if (this.q && supportedFocusModes != null && supportedFocusModes.contains("auto")) {
                TXCLog.i(c, "support FOCUS_MODE_AUTO");
                parameters.setFocusMode("auto");
            } else if (supportedFocusModes != null) {
                if (supportedFocusModes.contains("continuous-video")) {
                    TXCLog.i(c, "support FOCUS_MODE_CONTINUOUS_VIDEO");
                    parameters.setFocusMode("continuous-video");
                }
            }
            if (VERSION.SDK_INT >= 14) {
                if (parameters.getMaxNumFocusAreas() > 0) {
                    this.n = true;
                }
                if (parameters.getMaxNumMeteringAreas() > 0) {
                    this.o = true;
                }
            }
            String str = "";
            List supportedPreviewSizes = parameters.getSupportedPreviewSizes();
            if (supportedPreviewSizes != null) {
                String str2 = str;
                for (int i4 = 0; i4 < supportedPreviewSizes.size(); i4++) {
                    Size size = (Size) supportedPreviewSizes.get(i4);
                    str2 = str2 + String.format("camera supported preview size %d x %d\n", new Object[]{Integer.valueOf(size.width), Integer.valueOf(size.height)});
                }
                str = str2;
            }
            a e = e(this.g);
            if (e == null) {
                this.d.release();
                this.d = null;
                TXCLog.d(c, "不支持的视频分辨率");
                AppMethodBeat.o(67817);
                return -3;
            }
            TXCLog.i(c, str + String.format("choose preview size %d x %d ", new Object[]{Integer.valueOf(e.a), Integer.valueOf(e.b)}));
            this.i = e.a;
            this.j = e.b;
            parameters.setPreviewSize(e.a, e.b);
            int[] g = g(this.f);
            if (g != null) {
                parameters.setPreviewFpsRange(g[0], g[1]);
            } else {
                parameters.setPreviewFrameRate(f(this.f));
            }
            if (this.e) {
                i2 = i;
            } else {
                i2 = i3;
            }
            this.l = h(i2);
            this.k = (((this.l - 90) + (this.h * 90)) + v2helper.VOIP_ENC_HEIGHT_LV1) % v2helper.VOIP_ENC_HEIGHT_LV1;
            this.d.setDisplayOrientation(0);
            this.d.setPreviewTexture(this.m);
            this.d.setParameters(parameters);
            this.d.startPreview();
            AppMethodBeat.o(67817);
            return 0;
        } catch (IOException e2) {
            AppMethodBeat.o(67817);
            return -1;
        } catch (Exception e3) {
            AppMethodBeat.o(67817);
            return -1;
        }
    }

    public void b() {
        AppMethodBeat.i(67818);
        if (this.d != null) {
            try {
                this.d.setPreviewCallback(null);
                this.d.stopPreview();
                this.d.release();
            } catch (Exception e) {
            } finally {
                this.d = null;
                this.m = null;
                AppMethodBeat.o(67818);
            }
            return;
        }
        AppMethodBeat.o(67818);
    }

    public int c() {
        return this.k;
    }

    public boolean d() {
        return this.e;
    }

    public int e() {
        return this.i;
    }

    public int f() {
        return this.j;
    }

    private a e(int i) {
        AppMethodBeat.i(67819);
        List supportedPreviewSizes = this.d.getParameters().getSupportedPreviewSizes();
        ArrayList arrayList = new ArrayList();
        switch (i) {
            case 1:
            case 2:
            case 4:
                arrayList.add(new a(640, v2helper.VOIP_ENC_HEIGHT_LV1));
                arrayList.add(new a(768, v2helper.EMethodSetSendToNetworkOn));
                arrayList.add(new a(VideoFilterUtil.IMAGE_HEIGHT, 544));
                arrayList.add(new a(VideoFilterUtil.IMAGE_HEIGHT, 540));
                arrayList.add(new a(800, 480));
                arrayList.add(new a(640, 480));
                arrayList.add(new a(VideoFilterUtil.IMAGE_HEIGHT, 720));
                arrayList.add(new a(ActUtil.HEIGHT, 720));
                break;
            case 3:
                break;
            case 5:
                arrayList.add(new a(VideoFilterUtil.IMAGE_HEIGHT, 544));
                arrayList.add(new a(VideoFilterUtil.IMAGE_HEIGHT, 540));
                arrayList.add(new a(VideoFilterUtil.IMAGE_HEIGHT, 720));
                arrayList.add(new a(ActUtil.HEIGHT, 720));
                arrayList.add(new a(800, 480));
                arrayList.add(new a(640, v2helper.VOIP_ENC_HEIGHT_LV1));
                arrayList.add(new a(640, 480));
                break;
            case 6:
                arrayList.add(new a(ActUtil.HEIGHT, 720));
                arrayList.add(new a(1920, FilterEnum4Shaka.MIC_WEISHI_v4_4_CHUXUE));
                arrayList.add(new a(1920, FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN));
                arrayList.add(new a(VideoFilterUtil.IMAGE_HEIGHT, 544));
                arrayList.add(new a(VideoFilterUtil.IMAGE_HEIGHT, 540));
                arrayList.add(new a(VideoFilterUtil.IMAGE_HEIGHT, 720));
                arrayList.add(new a(800, 480));
                arrayList.add(new a(640, v2helper.VOIP_ENC_HEIGHT_LV1));
                arrayList.add(new a(640, 480));
                break;
            case 7:
                arrayList.add(new a(1920, FilterEnum4Shaka.MIC_WEISHI_v4_4_CHUXUE));
                arrayList.add(new a(1920, FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN));
                arrayList.add(new a(ActUtil.HEIGHT, 720));
                arrayList.add(new a(VideoFilterUtil.IMAGE_HEIGHT, 544));
                arrayList.add(new a(VideoFilterUtil.IMAGE_HEIGHT, 540));
                arrayList.add(new a(VideoFilterUtil.IMAGE_HEIGHT, 720));
                arrayList.add(new a(800, 480));
                arrayList.add(new a(768, v2helper.EMethodSetSendToNetworkOn));
                arrayList.add(new a(640, v2helper.VOIP_ENC_HEIGHT_LV1));
                arrayList.add(new a(640, 480));
                break;
        }
        arrayList.add(new a(480, 320));
        arrayList.add(new a(640, v2helper.VOIP_ENC_HEIGHT_LV1));
        arrayList.add(new a(640, 480));
        arrayList.add(new a(768, v2helper.EMethodSetSendToNetworkOn));
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < arrayList.size()) {
                a aVar = (a) arrayList.get(i3);
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 < supportedPreviewSizes.size()) {
                        Size size = (Size) supportedPreviewSizes.get(i5);
                        if (size.width == aVar.a && size.height == aVar.b) {
                            TXCLog.w(c, "wanted:" + aVar.a + "*" + aVar.b);
                            AppMethodBeat.o(67819);
                            return aVar;
                        }
                        i4 = i5 + 1;
                    } else {
                        i2 = i3 + 1;
                    }
                }
            } else {
                AppMethodBeat.o(67819);
                return null;
            }
        }
    }

    public void onAutoFocus(boolean z, Camera camera) {
        AppMethodBeat.i(67820);
        if (z) {
            TXCLog.i(c, "AUTO focus success");
            AppMethodBeat.o(67820);
            return;
        }
        TXCLog.i(c, "AUTO focus failed");
        AppMethodBeat.o(67820);
    }

    private int f(int i) {
        int i2 = 0;
        AppMethodBeat.i(67821);
        List supportedPreviewFrameRates = this.d.getParameters().getSupportedPreviewFrameRates();
        if (supportedPreviewFrameRates == null) {
            TXCLog.e(c, "getSupportedFPS error");
            AppMethodBeat.o(67821);
            return 1;
        }
        int intValue = ((Integer) supportedPreviewFrameRates.get(0)).intValue();
        while (i2 < supportedPreviewFrameRates.size()) {
            int intValue2 = ((Integer) supportedPreviewFrameRates.get(i2)).intValue();
            if (Math.abs(intValue2 - i) - Math.abs(intValue - i) < 0) {
                intValue = intValue2;
            }
            i2++;
        }
        TXCLog.i(c, "choose fpts=".concat(String.valueOf(intValue)));
        AppMethodBeat.o(67821);
        return intValue;
    }

    private int[] g(int i) {
        AppMethodBeat.i(67822);
        int i2 = i * 1000;
        String str = "camera supported preview fps range: wantFPS = " + i2 + IOUtils.LINE_SEPARATOR_UNIX;
        List<int[]> supportedPreviewFpsRange = this.d.getParameters().getSupportedPreviewFpsRange();
        if (supportedPreviewFpsRange == null || supportedPreviewFpsRange.size() <= 0) {
            AppMethodBeat.o(67822);
            return null;
        }
        String str2;
        int[] iArr;
        int[] iArr2 = (int[]) supportedPreviewFpsRange.get(0);
        Collections.sort(supportedPreviewFpsRange, new Comparator<int[]>() {
            public /* synthetic */ int compare(Object obj, Object obj2) {
                AppMethodBeat.i(67825);
                int a = a((int[]) obj, (int[]) obj2);
                AppMethodBeat.o(67825);
                return a;
            }

            public int a(int[] iArr, int[] iArr2) {
                return iArr[1] - iArr2[1];
            }
        });
        Iterator it = supportedPreviewFpsRange.iterator();
        while (true) {
            str2 = str;
            if (!it.hasNext()) {
                break;
            }
            iArr = (int[]) it.next();
            str = str2 + "camera supported preview fps range: " + iArr[0] + " - " + iArr[1] + IOUtils.LINE_SEPARATOR_UNIX;
        }
        for (int[] iArr3 : supportedPreviewFpsRange) {
            if (iArr3[0] <= i2 && i2 <= iArr3[1]) {
                break;
            }
        }
        iArr3 = iArr2;
        TXCLog.i(c, str2 + "choose preview fps range: " + iArr3[0] + " - " + iArr3[1]);
        AppMethodBeat.o(67822);
        return iArr3;
    }

    private int h(int i) {
        int i2;
        AppMethodBeat.i(67823);
        CameraInfo cameraInfo = new CameraInfo();
        Camera.getCameraInfo(i, cameraInfo);
        if (cameraInfo.facing == 1) {
            i2 = (360 - cameraInfo.orientation) % v2helper.VOIP_ENC_HEIGHT_LV1;
        } else {
            i2 = (cameraInfo.orientation + v2helper.VOIP_ENC_HEIGHT_LV1) % v2helper.VOIP_ENC_HEIGHT_LV1;
        }
        AppMethodBeat.o(67823);
        return i2;
    }

    static {
        AppMethodBeat.i(67824);
        AppMethodBeat.o(67824);
    }
}

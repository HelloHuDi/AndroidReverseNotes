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
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.p1169f.C45104b;
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

/* renamed from: com.tencent.liteav.capturer.a */
public class C37367a implements AutoFocusCallback {
    /* renamed from: c */
    private static final String f15955c = C37367a.class.getSimpleName();
    /* renamed from: a */
    private Matrix f15956a = new Matrix();
    /* renamed from: b */
    private int f15957b = 0;
    /* renamed from: d */
    private Camera f15958d;
    /* renamed from: e */
    private boolean f15959e = true;
    /* renamed from: f */
    private int f15960f = 15;
    /* renamed from: g */
    private int f15961g;
    /* renamed from: h */
    private int f15962h = 1;
    /* renamed from: i */
    private int f15963i;
    /* renamed from: j */
    private int f15964j;
    /* renamed from: k */
    private int f15965k;
    /* renamed from: l */
    private int f15966l;
    /* renamed from: m */
    private SurfaceTexture f15967m;
    /* renamed from: n */
    private boolean f15968n;
    /* renamed from: o */
    private boolean f15969o;
    /* renamed from: p */
    private boolean f15970p;
    /* renamed from: q */
    private boolean f15971q = false;

    /* renamed from: com.tencent.liteav.capturer.a$1 */
    class C177841 implements Comparator<int[]> {
        C177841() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            AppMethodBeat.m2504i(67825);
            int a = mo32900a((int[]) obj, (int[]) obj2);
            AppMethodBeat.m2505o(67825);
            return a;
        }

        /* renamed from: a */
        public int mo32900a(int[] iArr, int[] iArr2) {
            return iArr[1] - iArr2[1];
        }
    }

    /* renamed from: com.tencent.liteav.capturer.a$a */
    class C37366a {
        /* renamed from: a */
        public int f15952a = ActUtil.HEIGHT;
        /* renamed from: b */
        public int f15953b = 720;

        C37366a(int i, int i2) {
            this.f15952a = i;
            this.f15953b = i2;
        }
    }

    public C37367a() {
        AppMethodBeat.m2504i(67810);
        AppMethodBeat.m2505o(67810);
    }

    /* renamed from: a */
    public void mo60165a(SurfaceTexture surfaceTexture) {
        this.f15967m = surfaceTexture;
    }

    /* renamed from: a */
    public boolean mo60166a(boolean z) {
        AppMethodBeat.m2504i(67811);
        this.f15970p = z;
        if (this.f15958d != null) {
            boolean z2 = true;
            Parameters parameters = this.f15958d.getParameters();
            List supportedFlashModes = parameters.getSupportedFlashModes();
            if (z) {
                if (supportedFlashModes == null || !supportedFlashModes.contains("torch")) {
                    z2 = false;
                } else {
                    TXCLog.m15677i(f15955c, "set FLASH_MODE_TORCH");
                    parameters.setFlashMode("torch");
                }
            } else if (supportedFlashModes == null || !supportedFlashModes.contains("off")) {
                z2 = false;
            } else {
                TXCLog.m15677i(f15955c, "set FLASH_MODE_OFF");
                parameters.setFlashMode("off");
            }
            try {
                this.f15958d.setParameters(parameters);
            } catch (Exception e) {
                z2 = false;
            }
            AppMethodBeat.m2505o(67811);
            return z2;
        }
        AppMethodBeat.m2505o(67811);
        return false;
    }

    /* renamed from: a */
    public void mo60164a(int i) {
        this.f15961g = i;
    }

    /* renamed from: b */
    public void mo60168b(int i) {
        this.f15960f = i;
    }

    /* renamed from: a */
    public void mo60163a(float f, float f2) {
        AppMethodBeat.m2504i(67812);
        if (this.f15971q) {
            try {
                ArrayList arrayList;
                this.f15958d.cancelAutoFocus();
                Parameters parameters = this.f15958d.getParameters();
                if (this.f15968n) {
                    arrayList = new ArrayList();
                    arrayList.add(new Area(m62859a(f, f2, 2.0f), 1000));
                    parameters.setFocusAreas(arrayList);
                }
                if (this.f15969o) {
                    arrayList = new ArrayList();
                    arrayList.add(new Area(m62859a(f, f2, 3.0f), 1000));
                    parameters.setMeteringAreas(arrayList);
                }
                try {
                    this.f15958d.setParameters(parameters);
                    this.f15958d.autoFocus(this);
                    AppMethodBeat.m2505o(67812);
                    return;
                } catch (Exception e) {
                    AppMethodBeat.m2505o(67812);
                    return;
                }
            } catch (Exception e2) {
                AppMethodBeat.m2505o(67812);
                return;
            }
        }
        AppMethodBeat.m2505o(67812);
    }

    /* renamed from: b */
    public void mo60169b(boolean z) {
        this.f15971q = z;
    }

    /* renamed from: a */
    private Rect m62859a(float f, float f2, float f3) {
        int i;
        int i2;
        int i3 = 1000;
        AppMethodBeat.m2504i(67813);
        float f4 = 200.0f * f3;
        if (this.f15959e) {
            f = 1.0f - f;
        }
        for (i = 0; i < this.f15965k / 90; i++) {
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
        AppMethodBeat.m2505o(67813);
        return rect;
    }

    /* renamed from: a */
    public int mo60161a() {
        AppMethodBeat.m2504i(67814);
        int i = 0;
        if (this.f15958d != null) {
            Parameters parameters = this.f15958d.getParameters();
            if (parameters.getMaxZoom() > 0 && parameters.isZoomSupported()) {
                i = parameters.getMaxZoom();
            }
        }
        AppMethodBeat.m2505o(67814);
        return i;
    }

    /* renamed from: c */
    public boolean mo60172c(int i) {
        boolean z = false;
        AppMethodBeat.m2504i(67815);
        if (this.f15958d != null) {
            Parameters parameters = this.f15958d.getParameters();
            if (parameters.getMaxZoom() <= 0 || !parameters.isZoomSupported()) {
                TXCLog.m15676e(f15955c, "camera not support zoom!");
            } else if (i < 0 || i > parameters.getMaxZoom()) {
                TXCLog.m15676e(f15955c, "invalid zoom value : " + i + ", while max zoom is " + parameters.getMaxZoom());
            } else {
                try {
                    parameters.setZoom(i);
                    this.f15958d.setParameters(parameters);
                    z = true;
                } catch (Exception e) {
                }
            }
        }
        AppMethodBeat.m2505o(67815);
        return z;
    }

    /* renamed from: a */
    public void mo60162a(float f) {
        float f2 = 1.0f;
        float f3 = -1.0f;
        AppMethodBeat.m2504i(67816);
        if (this.f15958d != null) {
            if (f <= 1.0f) {
                f2 = f;
            }
            if (f2 >= -1.0f) {
                f3 = f2;
            }
            Parameters parameters = this.f15958d.getParameters();
            int minExposureCompensation = parameters.getMinExposureCompensation();
            int maxExposureCompensation = parameters.getMaxExposureCompensation();
            if (minExposureCompensation == 0 || maxExposureCompensation == 0) {
                TXCLog.m15676e(f15955c, "camera not support setExposureCompensation!");
            } else {
                int d = C45104b.m82752a().mo72881d();
                f3 *= (float) maxExposureCompensation;
                if (d != 0 && d <= maxExposureCompensation && d >= minExposureCompensation) {
                    TXCLog.m15675d(f15955c, "camera setExposureCompensation: ".concat(String.valueOf(d)));
                    parameters.setExposureCompensation(d);
                } else if (f3 <= ((float) maxExposureCompensation) && f3 >= ((float) minExposureCompensation)) {
                    TXCLog.m15675d(f15955c, "camera setExposureCompensation: ".concat(String.valueOf(f3)));
                    parameters.setExposureCompensation((int) f3);
                }
            }
            try {
                this.f15958d.setParameters(parameters);
                AppMethodBeat.m2505o(67816);
                return;
            } catch (Exception e) {
            }
        }
        AppMethodBeat.m2505o(67816);
    }

    /* renamed from: d */
    public void mo60173d(int i) {
        this.f15962h = i;
        this.f15965k = (((this.f15966l - 90) + (this.f15962h * 90)) + v2helper.VOIP_ENC_HEIGHT_LV1) % v2helper.VOIP_ENC_HEIGHT_LV1;
    }

    /* renamed from: c */
    public int mo60171c(boolean z) {
        AppMethodBeat.m2504i(67817);
        try {
            if (this.f15967m == null) {
                AppMethodBeat.m2505o(67817);
                return -2;
            }
            int i;
            if (this.f15958d != null) {
                mo60167b();
            }
            CameraInfo cameraInfo = new CameraInfo();
            int i2 = -1;
            int i3 = -1;
            for (i = 0; i < Camera.getNumberOfCameras(); i++) {
                Camera.getCameraInfo(i, cameraInfo);
                TXCLog.m15677i(f15955c, "camera index " + i + ", facing = " + cameraInfo.facing);
                if (cameraInfo.facing == 1) {
                    i3 = i;
                }
                if (cameraInfo.facing == 0) {
                    i2 = i;
                }
            }
            TXCLog.m15677i(f15955c, "camera front, id = ".concat(String.valueOf(i3)));
            TXCLog.m15677i(f15955c, "camera back , id = ".concat(String.valueOf(i2)));
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
            this.f15959e = z;
            if (this.f15959e) {
                this.f15958d = Camera.open(i);
            } else {
                this.f15958d = Camera.open(i3);
            }
            Parameters parameters = this.f15958d.getParameters();
            List supportedFocusModes = parameters.getSupportedFocusModes();
            if (this.f15971q && supportedFocusModes != null && supportedFocusModes.contains("auto")) {
                TXCLog.m15677i(f15955c, "support FOCUS_MODE_AUTO");
                parameters.setFocusMode("auto");
            } else if (supportedFocusModes != null) {
                if (supportedFocusModes.contains("continuous-video")) {
                    TXCLog.m15677i(f15955c, "support FOCUS_MODE_CONTINUOUS_VIDEO");
                    parameters.setFocusMode("continuous-video");
                }
            }
            if (VERSION.SDK_INT >= 14) {
                if (parameters.getMaxNumFocusAreas() > 0) {
                    this.f15968n = true;
                }
                if (parameters.getMaxNumMeteringAreas() > 0) {
                    this.f15969o = true;
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
            C37366a e = m62860e(this.f15961g);
            if (e == null) {
                this.f15958d.release();
                this.f15958d = null;
                TXCLog.m15675d(f15955c, "不支持的视频分辨率");
                AppMethodBeat.m2505o(67817);
                return -3;
            }
            TXCLog.m15677i(f15955c, str + String.format("choose preview size %d x %d ", new Object[]{Integer.valueOf(e.f15952a), Integer.valueOf(e.f15953b)}));
            this.f15963i = e.f15952a;
            this.f15964j = e.f15953b;
            parameters.setPreviewSize(e.f15952a, e.f15953b);
            int[] g = m62862g(this.f15960f);
            if (g != null) {
                parameters.setPreviewFpsRange(g[0], g[1]);
            } else {
                parameters.setPreviewFrameRate(m62861f(this.f15960f));
            }
            if (this.f15959e) {
                i2 = i;
            } else {
                i2 = i3;
            }
            this.f15966l = m62863h(i2);
            this.f15965k = (((this.f15966l - 90) + (this.f15962h * 90)) + v2helper.VOIP_ENC_HEIGHT_LV1) % v2helper.VOIP_ENC_HEIGHT_LV1;
            this.f15958d.setDisplayOrientation(0);
            this.f15958d.setPreviewTexture(this.f15967m);
            this.f15958d.setParameters(parameters);
            this.f15958d.startPreview();
            AppMethodBeat.m2505o(67817);
            return 0;
        } catch (IOException e2) {
            AppMethodBeat.m2505o(67817);
            return -1;
        } catch (Exception e3) {
            AppMethodBeat.m2505o(67817);
            return -1;
        }
    }

    /* renamed from: b */
    public void mo60167b() {
        AppMethodBeat.m2504i(67818);
        if (this.f15958d != null) {
            try {
                this.f15958d.setPreviewCallback(null);
                this.f15958d.stopPreview();
                this.f15958d.release();
            } catch (Exception e) {
            } finally {
                this.f15958d = null;
                this.f15967m = null;
                AppMethodBeat.m2505o(67818);
            }
            return;
        }
        AppMethodBeat.m2505o(67818);
    }

    /* renamed from: c */
    public int mo60170c() {
        return this.f15965k;
    }

    /* renamed from: d */
    public boolean mo60174d() {
        return this.f15959e;
    }

    /* renamed from: e */
    public int mo60175e() {
        return this.f15963i;
    }

    /* renamed from: f */
    public int mo60176f() {
        return this.f15964j;
    }

    /* renamed from: e */
    private C37366a m62860e(int i) {
        AppMethodBeat.m2504i(67819);
        List supportedPreviewSizes = this.f15958d.getParameters().getSupportedPreviewSizes();
        ArrayList arrayList = new ArrayList();
        switch (i) {
            case 1:
            case 2:
            case 4:
                arrayList.add(new C37366a(640, v2helper.VOIP_ENC_HEIGHT_LV1));
                arrayList.add(new C37366a(768, v2helper.EMethodSetSendToNetworkOn));
                arrayList.add(new C37366a(VideoFilterUtil.IMAGE_HEIGHT, 544));
                arrayList.add(new C37366a(VideoFilterUtil.IMAGE_HEIGHT, 540));
                arrayList.add(new C37366a(800, 480));
                arrayList.add(new C37366a(640, 480));
                arrayList.add(new C37366a(VideoFilterUtil.IMAGE_HEIGHT, 720));
                arrayList.add(new C37366a(ActUtil.HEIGHT, 720));
                break;
            case 3:
                break;
            case 5:
                arrayList.add(new C37366a(VideoFilterUtil.IMAGE_HEIGHT, 544));
                arrayList.add(new C37366a(VideoFilterUtil.IMAGE_HEIGHT, 540));
                arrayList.add(new C37366a(VideoFilterUtil.IMAGE_HEIGHT, 720));
                arrayList.add(new C37366a(ActUtil.HEIGHT, 720));
                arrayList.add(new C37366a(800, 480));
                arrayList.add(new C37366a(640, v2helper.VOIP_ENC_HEIGHT_LV1));
                arrayList.add(new C37366a(640, 480));
                break;
            case 6:
                arrayList.add(new C37366a(ActUtil.HEIGHT, 720));
                arrayList.add(new C37366a(1920, FilterEnum4Shaka.MIC_WEISHI_v4_4_CHUXUE));
                arrayList.add(new C37366a(1920, FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN));
                arrayList.add(new C37366a(VideoFilterUtil.IMAGE_HEIGHT, 544));
                arrayList.add(new C37366a(VideoFilterUtil.IMAGE_HEIGHT, 540));
                arrayList.add(new C37366a(VideoFilterUtil.IMAGE_HEIGHT, 720));
                arrayList.add(new C37366a(800, 480));
                arrayList.add(new C37366a(640, v2helper.VOIP_ENC_HEIGHT_LV1));
                arrayList.add(new C37366a(640, 480));
                break;
            case 7:
                arrayList.add(new C37366a(1920, FilterEnum4Shaka.MIC_WEISHI_v4_4_CHUXUE));
                arrayList.add(new C37366a(1920, FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN));
                arrayList.add(new C37366a(ActUtil.HEIGHT, 720));
                arrayList.add(new C37366a(VideoFilterUtil.IMAGE_HEIGHT, 544));
                arrayList.add(new C37366a(VideoFilterUtil.IMAGE_HEIGHT, 540));
                arrayList.add(new C37366a(VideoFilterUtil.IMAGE_HEIGHT, 720));
                arrayList.add(new C37366a(800, 480));
                arrayList.add(new C37366a(768, v2helper.EMethodSetSendToNetworkOn));
                arrayList.add(new C37366a(640, v2helper.VOIP_ENC_HEIGHT_LV1));
                arrayList.add(new C37366a(640, 480));
                break;
        }
        arrayList.add(new C37366a(480, 320));
        arrayList.add(new C37366a(640, v2helper.VOIP_ENC_HEIGHT_LV1));
        arrayList.add(new C37366a(640, 480));
        arrayList.add(new C37366a(768, v2helper.EMethodSetSendToNetworkOn));
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < arrayList.size()) {
                C37366a c37366a = (C37366a) arrayList.get(i3);
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 < supportedPreviewSizes.size()) {
                        Size size = (Size) supportedPreviewSizes.get(i5);
                        if (size.width == c37366a.f15952a && size.height == c37366a.f15953b) {
                            TXCLog.m15679w(f15955c, "wanted:" + c37366a.f15952a + "*" + c37366a.f15953b);
                            AppMethodBeat.m2505o(67819);
                            return c37366a;
                        }
                        i4 = i5 + 1;
                    } else {
                        i2 = i3 + 1;
                    }
                }
            } else {
                AppMethodBeat.m2505o(67819);
                return null;
            }
        }
    }

    public void onAutoFocus(boolean z, Camera camera) {
        AppMethodBeat.m2504i(67820);
        if (z) {
            TXCLog.m15677i(f15955c, "AUTO focus success");
            AppMethodBeat.m2505o(67820);
            return;
        }
        TXCLog.m15677i(f15955c, "AUTO focus failed");
        AppMethodBeat.m2505o(67820);
    }

    /* renamed from: f */
    private int m62861f(int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(67821);
        List supportedPreviewFrameRates = this.f15958d.getParameters().getSupportedPreviewFrameRates();
        if (supportedPreviewFrameRates == null) {
            TXCLog.m15676e(f15955c, "getSupportedFPS error");
            AppMethodBeat.m2505o(67821);
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
        TXCLog.m15677i(f15955c, "choose fpts=".concat(String.valueOf(intValue)));
        AppMethodBeat.m2505o(67821);
        return intValue;
    }

    /* renamed from: g */
    private int[] m62862g(int i) {
        AppMethodBeat.m2504i(67822);
        int i2 = i * 1000;
        String str = "camera supported preview fps range: wantFPS = " + i2 + IOUtils.LINE_SEPARATOR_UNIX;
        List<int[]> supportedPreviewFpsRange = this.f15958d.getParameters().getSupportedPreviewFpsRange();
        if (supportedPreviewFpsRange == null || supportedPreviewFpsRange.size() <= 0) {
            AppMethodBeat.m2505o(67822);
            return null;
        }
        String str2;
        int[] iArr;
        int[] iArr2 = (int[]) supportedPreviewFpsRange.get(0);
        Collections.sort(supportedPreviewFpsRange, new C177841());
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
        TXCLog.m15677i(f15955c, str2 + "choose preview fps range: " + iArr3[0] + " - " + iArr3[1]);
        AppMethodBeat.m2505o(67822);
        return iArr3;
    }

    /* renamed from: h */
    private int m62863h(int i) {
        int i2;
        AppMethodBeat.m2504i(67823);
        CameraInfo cameraInfo = new CameraInfo();
        Camera.getCameraInfo(i, cameraInfo);
        if (cameraInfo.facing == 1) {
            i2 = (360 - cameraInfo.orientation) % v2helper.VOIP_ENC_HEIGHT_LV1;
        } else {
            i2 = (cameraInfo.orientation + v2helper.VOIP_ENC_HEIGHT_LV1) % v2helper.VOIP_ENC_HEIGHT_LV1;
        }
        AppMethodBeat.m2505o(67823);
        return i2;
    }

    static {
        AppMethodBeat.m2504i(67824);
        AppMethodBeat.m2505o(67824);
    }
}

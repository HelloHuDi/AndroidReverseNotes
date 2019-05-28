package com.tencent.p177mm.plugin.facedetect.model;

import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C32468d;
import com.tencent.p177mm.compatible.p221e.C32468d.C32469a.C32470a;
import com.tencent.p177mm.compatible.p221e.C41938t;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.view.C31128d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.facedetect.model.n */
public final class C20639n {
    private Context context;
    public C41938t erH;
    private boolean isFrontCamera = true;
    public boolean lUE = false;
    public Point lUF = null;
    public Point lUG = null;
    private Point lUH = null;
    private boolean lUI;
    public int lUJ;
    private boolean lUK = false;
    public boolean lUL = false;
    public Point lUM = null;

    /* renamed from: com.tencent.mm.plugin.facedetect.model.n$a */
    static class C11811a implements Comparator<Size> {
        private C11811a() {
        }

        /* synthetic */ C11811a(byte b) {
            this();
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            Size size = (Size) obj;
            Size size2 = (Size) obj2;
            int i = size.height * size.width;
            int i2 = size2.height * size2.width;
            if (i2 < i) {
                return -1;
            }
            if (i2 > i) {
                return 1;
            }
            return 0;
        }
    }

    public C20639n(Context context) {
        this.context = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01e8  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01b8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: f */
    public final void mo35924f(SurfaceTexture surfaceTexture) {
        AppMethodBeat.m2504i(C31128d.MIC_PTU_ZIPAI_OKINAWA);
        if (this.lUE) {
            C4990ab.m7420w("MicroMsg.FaceScanCamera", "in open(), previewing");
            release();
        }
        this.isFrontCamera = true;
        int numberOfCameras = Camera.getNumberOfCameras();
        int i = 0;
        while (i < numberOfCameras) {
            CameraInfo cameraInfo = new CameraInfo();
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing != 1 || !this.isFrontCamera) {
                if (cameraInfo.facing == 0 && !this.isFrontCamera) {
                    C4990ab.m7410d("MicroMsg.FaceScanCamera", "hy: front Camera found");
                    break;
                }
                i++;
            } else {
                C4990ab.m7410d("MicroMsg.FaceScanCamera", "hy: front Camera found");
                break;
            }
        }
        i = -1;
        long yz = C5046bo.m7588yz();
        C32470a a = C32468d.m53155a(this.context, i, null);
        IOException iOException;
        if (a == null) {
            C4990ab.m7412e("MicroMsg.FaceScanCamera", "in open(), openCameraRes == null");
            iOException = new IOException();
            AppMethodBeat.m2505o(C31128d.MIC_PTU_ZIPAI_OKINAWA);
            throw iOException;
        }
        this.lUL = true;
        C4990ab.m7411d("MicroMsg.FaceScanCamera", "openCamera done, cameraId=[%s] costTime=[%s]", Integer.valueOf(i), Long.valueOf(C5046bo.m7525az(yz)));
        this.lUJ = a.rotate;
        this.lUI = a.rotate % 180 != 0;
        this.erH = a.erH;
        if (this.erH == null) {
            C4990ab.m7413e("MicroMsg.FaceScanCamera", "in open(), camera == null, bNeedRotate=[%s]", Boolean.valueOf(this.lUI));
            iOException = new IOException();
            AppMethodBeat.m2505o(C31128d.MIC_PTU_ZIPAI_OKINAWA);
            throw iOException;
        }
        Object obj;
        this.erH.setPreviewTexture(surfaceTexture);
        Parameters parameters = this.erH.getParameters();
        Point point = this.lUG;
        Point point2 = this.lUH;
        String str = parameters.get("preview-size-values");
        if (str == null) {
            obj = parameters.get("preview-size-value");
        } else {
            String obj2 = str;
        }
        Point point3 = null;
        if (obj2 != null) {
            C4990ab.m7410d("MicroMsg.FaceScanCamera", "preview-size-values parameter: ".concat(String.valueOf(obj2)));
            point3 = C20639n.m31877a(parameters, point);
        }
        if (point3 == null) {
            point3 = new Point((point2.x >> 3) << 3, (point2.y >> 3) << 3);
        }
        this.lUF = point3;
        this.lUM = new Point(this.lUF);
        C4990ab.m7410d("MicroMsg.FaceScanCamera", "getCameraResolution: " + this.lUG + " camera:" + this.lUF + "bestVideoEncodeSize: " + this.lUM);
        parameters.setPreviewSize(this.lUF.x, this.lUF.y);
        parameters.setZoom(0);
        parameters.setSceneMode("auto");
        try {
            List<Integer> supportedPreviewFormats;
            boolean z;
            boolean z2;
            if (parameters.getSupportedFocusModes() == null || !parameters.getSupportedFocusModes().contains("auto")) {
                C4990ab.m7416i("MicroMsg.FaceScanCamera", "camera not support FOCUS_MODE_AUTO");
                supportedPreviewFormats = parameters.getSupportedPreviewFormats();
                z = false;
                for (Integer intValue : supportedPreviewFormats) {
                    i = intValue.intValue();
                    C4990ab.m7410d("MicroMsg.FaceScanCamera", "supportedPreviewFormat: ".concat(String.valueOf(i)));
                    if (i == 17) {
                        z2 = true;
                        break;
                    }
                    if (i == 842094169) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    z = z2;
                }
                z2 = false;
                if (!z2) {
                    parameters.setPreviewFormat(17);
                } else if (z) {
                    C4990ab.m7412e("MicroMsg.FaceScanCamera", "Preview not support PixelFormat.YCbCr_420_SP, but hasYU12");
                    parameters.setPreviewFormat(842094169);
                } else {
                    C4990ab.m7413e("MicroMsg.FaceScanCamera", "Preview not support PixelFormat.YCbCr_420_SP. Use format: %s", supportedPreviewFormats.get(0));
                    parameters.setPreviewFormat(((Integer) supportedPreviewFormats.get(0)).intValue());
                }
                if (this.lUI) {
                    parameters.setRotation(this.lUJ);
                }
                this.erH.setParameters(parameters);
                AppMethodBeat.m2505o(C31128d.MIC_PTU_ZIPAI_OKINAWA);
            }
            C4990ab.m7416i("MicroMsg.FaceScanCamera", "set FocusMode to FOCUS_MODE_AUTO");
            parameters.setFocusMode("auto");
            supportedPreviewFormats = parameters.getSupportedPreviewFormats();
            z = false;
            while (r6.hasNext()) {
            }
            z2 = false;
            if (!z2) {
            }
            if (this.lUI) {
            }
            this.erH.setParameters(parameters);
            AppMethodBeat.m2505o(C31128d.MIC_PTU_ZIPAI_OKINAWA);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.FaceScanCamera", "set focus mode error: %s", e.getMessage());
        }
    }

    public final void release() {
        AppMethodBeat.m2504i(C31128d.MIC_PTU_ZIPAI_LIGHTRED);
        C4990ab.m7411d("MicroMsg.FaceScanCamera", "release(), previewing = [%s]", Boolean.valueOf(this.lUE));
        if (this.erH != null) {
            long yz = C5046bo.m7588yz();
            if (this.lUE) {
                this.erH.setPreviewCallback(null);
                this.erH.stopPreview();
                this.lUE = false;
                C4990ab.m7411d("MicroMsg.FaceScanCamera", "stopPreview costTime=[%s]", Long.valueOf(C5046bo.m7525az(yz)));
            }
            yz = C5046bo.m7588yz();
            this.erH.release();
            this.erH = null;
            this.lUL = false;
            C4990ab.m7411d("MicroMsg.FaceScanCamera", "camera.release() costTime=[%s]", Long.valueOf(C5046bo.m7525az(yz)));
        }
        this.lUK = false;
        AppMethodBeat.m2505o(C31128d.MIC_PTU_ZIPAI_LIGHTRED);
    }

    public final int getPreviewWidth() {
        AppMethodBeat.m2504i(255);
        C4990ab.m7419v("MicroMsg.FaceScanCamera", "hy: preview width: %d", Integer.valueOf(this.lUF.x));
        int i = this.lUF.x;
        AppMethodBeat.m2505o(255);
        return i;
    }

    public final int getPreviewHeight() {
        AppMethodBeat.m2504i(256);
        C4990ab.m7419v("MicroMsg.FaceScanCamera", "hy: preview height: %d", Integer.valueOf(this.lUF.y));
        int i = this.lUF.y;
        AppMethodBeat.m2505o(256);
        return i;
    }

    /* renamed from: a */
    private static Point m31877a(Parameters parameters, Point point) {
        Size previewSize;
        AppMethodBeat.m2504i(C31128d.MIC_PTU_ZIPAI_TOKYO);
        ArrayList<Size> arrayList = new ArrayList(parameters.getSupportedPreviewSizes());
        Collections.sort(arrayList, new C11811a());
        Point point2 = null;
        C4990ab.m7411d("MicroMsg.FaceScanCamera", "screen.x: %d, screen.y: %d, ratio: %f", Integer.valueOf(point.x), Integer.valueOf(point.y), Float.valueOf(((float) point.x) / ((float) point.y)));
        long gO = C5046bo.m7553gO(C4996ah.getContext());
        C4990ab.m7411d("MicroMsg.FaceScanCamera", "systemAvailableMemInMB: %d", Long.valueOf(gO));
        int i = point.x;
        i = point.y;
        float f = Float.POSITIVE_INFINITY;
        for (Size previewSize2 : arrayList) {
            int i2 = previewSize2.width;
            int i3 = previewSize2.height;
            C4990ab.m7417i("MicroMsg.FaceScanCamera", "realWidth: %d, realHeight: %d", Integer.valueOf(i2), Integer.valueOf(i3));
            int i4 = i2 * i3;
            if (i4 >= 150400 && i4 <= 983040) {
                Object obj = i2 > i3 ? 1 : null;
                if (obj != null) {
                    i = i3;
                } else {
                    i = i2;
                }
                if (obj != null) {
                    i4 = i2;
                } else {
                    i4 = i3;
                }
                C4990ab.m7411d("MicroMsg.FaceScanCamera", "maybeFlippedWidth: %d, maybeFlippedHeight: %d", Integer.valueOf(i), Integer.valueOf(i4));
                if (i == point.x && i4 == point.y && C20639n.m31878f(i, i4, gO)) {
                    point2 = new Point(i2, i3);
                    C4990ab.m7416i("MicroMsg.FaceScanCamera", "Found preview size exactly matching screen size: ".concat(String.valueOf(point2)));
                    AppMethodBeat.m2505o(C31128d.MIC_PTU_ZIPAI_TOKYO);
                    return point2;
                }
                float f2;
                float abs = Math.abs((((float) i) / ((float) i4)) - r8);
                if (abs >= f || !C20639n.m31878f(i2, i3, gO)) {
                    f2 = f;
                } else {
                    f2 = abs;
                    point2 = new Point(i2, i3);
                }
                C4990ab.m7417i("MicroMsg.FaceScanCamera", "diff:[%s] newdiff:[%s] w:[%s] h:[%s]", Float.valueOf(f2), Float.valueOf(abs), Integer.valueOf(i2), Integer.valueOf(i3));
                f = f2;
            }
        }
        if (point2 == null) {
            previewSize2 = parameters.getPreviewSize();
            if (previewSize2 != null) {
                point2 = new Point(previewSize2.width, previewSize2.height);
                C4990ab.m7416i("MicroMsg.FaceScanCamera", "No suitable preview sizes, using default: ".concat(String.valueOf(point2)));
            } else {
                C4990ab.m7412e("MicroMsg.FaceScanCamera", "hy: can not find default size!!");
            }
        }
        C4990ab.m7416i("MicroMsg.FaceScanCamera", "Found best approximate preview size: ".concat(String.valueOf(point2)));
        AppMethodBeat.m2505o(C31128d.MIC_PTU_ZIPAI_TOKYO);
        return point2;
    }

    /* renamed from: f */
    private static boolean m31878f(int i, int i2, long j) {
        AppMethodBeat.m2504i(C31128d.MIC_PTU_ZIPAI_SAPPORO);
        C4990ab.m7411d("MicroMsg.FaceScanCamera", "dataSizeInMB: %f, availableMemInMb: %d", Double.valueOf(((((((double) i) * ((double) i2)) * 3.0d) / 2.0d) / 1024.0d) / 1024.0d), Long.valueOf(j));
        if (((double) j) / (((((((double) i) * ((double) i2)) * 3.0d) / 2.0d) / 1024.0d) / 1024.0d) >= 5.0d) {
            AppMethodBeat.m2505o(C31128d.MIC_PTU_ZIPAI_SAPPORO);
            return true;
        }
        AppMethodBeat.m2505o(C31128d.MIC_PTU_ZIPAI_SAPPORO);
        return false;
    }

    public final void setPreviewCallback(final PreviewCallback previewCallback) {
        AppMethodBeat.m2504i(C31128d.MIC_PTU_ZIPAI_MEDSEA);
        if (this.erH == null) {
            C4990ab.m7420w("MicroMsg.FaceScanCamera", "hy: camera is null. setPreviewCallback failed");
            AppMethodBeat.m2505o(C31128d.MIC_PTU_ZIPAI_MEDSEA);
            return;
        }
        try {
            this.erH.addCallbackBuffer(C27931c.lTA.mo45832g(Integer.valueOf(((getPreviewWidth() * getPreviewHeight()) * ImageFormat.getBitsPerPixel(this.erH.getParameters().getPreviewFormat())) / 8)));
            this.erH.setPreviewCallbackWithBuffer(new PreviewCallback() {
                public final void onPreviewFrame(byte[] bArr, Camera camera) {
                    AppMethodBeat.m2504i(252);
                    if (previewCallback != null) {
                        previewCallback.onPreviewFrame(bArr, camera);
                    }
                    camera.addCallbackBuffer(bArr);
                    AppMethodBeat.m2505o(252);
                }
            });
            AppMethodBeat.m2505o(C31128d.MIC_PTU_ZIPAI_MEDSEA);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.FaceScanCamera", e, "setPreviewCallback error: %s", e.getMessage());
            AppMethodBeat.m2505o(C31128d.MIC_PTU_ZIPAI_MEDSEA);
        }
    }
}

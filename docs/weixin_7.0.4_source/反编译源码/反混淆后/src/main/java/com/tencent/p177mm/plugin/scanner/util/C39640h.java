package com.tencent.p177mm.plugin.scanner.util;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera.Area;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.p221e.C32468d;
import com.tencent.p177mm.compatible.p221e.C32468d.C32469a.C32470a;
import com.tencent.p177mm.compatible.p221e.C41938t;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.plugin.scanner.util.h */
public final class C39640h {
    private static final Pattern qhR = Pattern.compile(",");
    private Activity czX;
    public C41938t erH;
    private int hGe = 0;
    public Rect lQX;
    public boolean lUE = false;
    public Point lUF = null;
    private Point lUG = null;
    public Point lUH = null;
    public boolean lUI;
    public int lUJ;
    private boolean lUK = false;
    public boolean otY = false;
    public boolean qhS;
    private Rect qhT;
    private Rect qhU;
    public int qhV = -1;
    private String qhW = "";
    private int qhX;
    private int qhY;
    private int qhZ;

    /* renamed from: com.tencent.mm.plugin.scanner.util.h$a */
    static class C39639a implements Comparator<Size> {
        private C39639a() {
        }

        /* synthetic */ C39639a(byte b) {
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

    static {
        AppMethodBeat.m2504i(81443);
        AppMethodBeat.m2505o(81443);
    }

    public C39640h(Activity activity, int i, boolean z) {
        AppMethodBeat.m2504i(81420);
        this.czX = activity;
        this.lUG = C5222ae.m7953hy(activity);
        this.qhS = z;
        this.hGe = i;
        AppMethodBeat.m2505o(81420);
    }

    /* renamed from: h */
    public final void mo62609h(SurfaceTexture surfaceTexture) {
        AppMethodBeat.m2504i(81421);
        long yz = C5046bo.m7588yz();
        if (!(this.erH == null || this.lUE)) {
            if (surfaceTexture != null) {
                this.erH.setPreviewTexture(surfaceTexture);
            }
            this.erH.startPreview();
            this.lUE = true;
            C4990ab.m7411d("MicroMsg.scanner.ScanCamera", "startPreview done costTime=[%s]", Long.valueOf(C5046bo.m7525az(yz)));
        }
        AppMethodBeat.m2505o(81421);
    }

    public final void stopPreview() {
        AppMethodBeat.m2504i(81422);
        if (this.erH != null) {
            this.erH.stopPreview();
            this.lUE = false;
        }
        AppMethodBeat.m2505o(81422);
    }

    /* renamed from: a */
    public final void mo62597a(PreviewCallback previewCallback) {
        AppMethodBeat.m2504i(81423);
        if (this.erH != null) {
            try {
                this.erH.setOneShotPreviewCallback(previewCallback);
                AppMethodBeat.m2505o(81423);
                return;
            } catch (RuntimeException e) {
                C4990ab.m7420w("MicroMsg.scanner.ScanCamera", "takeOneShot() " + e.getMessage());
            }
        }
        AppMethodBeat.m2505o(81423);
    }

    public final boolean isOpen() {
        if (this.erH != null) {
            return true;
        }
        return false;
    }

    /* renamed from: Cd */
    public final void mo62594Cd(int i) {
        this.hGe = i;
        this.lQX = null;
    }

    public final String getFocusMode() {
        String focusMode;
        AppMethodBeat.m2504i(81424);
        try {
            if (this.erH != null && this.lUE) {
                focusMode = this.erH.getParameters().getFocusMode();
                AppMethodBeat.m2505o(81424);
                return focusMode;
            }
        } catch (Exception e) {
            C4990ab.m7421w("MicroMsg.scanner.ScanCamera", "getFocusMode() %s", e.getMessage());
        }
        focusMode = "";
        AppMethodBeat.m2505o(81424);
        return focusMode;
    }

    public final void cancelAutoFocus() {
        AppMethodBeat.m2504i(81425);
        try {
            if (this.erH != null) {
                this.erH.cancelAutoFocus();
            }
            AppMethodBeat.m2505o(81425);
        } catch (Exception e) {
            C4990ab.m7421w("MicroMsg.scanner.ScanCamera", "cancelAutoFocus %s", e.getMessage());
            AppMethodBeat.m2505o(81425);
        }
    }

    public final void open() {
        AppMethodBeat.m2504i(81426);
        if (this.lUE) {
            C4990ab.m7420w("MicroMsg.scanner.ScanCamera", "in open(), previewing");
            release();
        }
        int Lr = C32468d.m53152Lr();
        long yz = C5046bo.m7588yz();
        C32470a a = C32468d.m53155a(this.czX, Lr, null);
        IOException iOException;
        if (a == null) {
            C4990ab.m7412e("MicroMsg.scanner.ScanCamera", "in open(), openCameraRes == null");
            iOException = new IOException();
            AppMethodBeat.m2505o(81426);
            throw iOException;
        }
        boolean z;
        this.otY = false;
        this.qhV = -1;
        C4990ab.m7411d("MicroMsg.scanner.ScanCamera", "openCamera done, cameraId=[%s] costTime=[%s]", Integer.valueOf(Lr), Long.valueOf(C5046bo.m7525az(yz)));
        this.lUJ = a.rotate;
        if (a.rotate % 180 != 0) {
            z = true;
        } else {
            z = false;
        }
        this.lUI = z;
        this.erH = a.erH;
        if (this.erH == null) {
            C4990ab.m7413e("MicroMsg.scanner.ScanCamera", "in open(), camera == null, bNeedRotate=[%s]", Boolean.valueOf(this.lUI));
            iOException = new IOException();
            AppMethodBeat.m2505o(81426);
            throw iOException;
        }
        int i;
        Parameters parameters = this.erH.getParameters();
        Point point = this.lUG;
        Point point2 = this.lUH;
        z = 9 == this.hGe || 10 == this.hGe || 7 == this.hGe || 11 == this.hGe;
        this.lUF = C39640h.m67745a(parameters, point, point2, z);
        C4990ab.m7410d("MicroMsg.scanner.ScanCamera", "getCameraResolution: " + this.lUG + " camera:" + this.lUF);
        parameters.setPreviewSize(this.lUF.x, this.lUF.y);
        cic();
        try {
            C39640h.m67747e(parameters);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.scanner.ScanCamera", "set focus mode error: %s", e.getMessage());
        }
        List supportedPreviewFormats = parameters.getSupportedPreviewFormats();
        C4990ab.m7416i("MicroMsg.scanner.ScanCamera", "supportedPreviewFormat:".concat(String.valueOf(supportedPreviewFormats)));
        boolean i2;
        if (supportedPreviewFormats.contains(Integer.valueOf(17))) {
            z = false;
            i2 = 1;
        } else if (supportedPreviewFormats.contains(Integer.valueOf(842094169))) {
            z = true;
            i2 = false;
        } else {
            z = false;
            i2 = false;
        }
        if (i2 != 0) {
            C4990ab.m7416i("MicroMsg.scanner.ScanCamera", "Preview support NV21");
            parameters.setPreviewFormat(17);
        } else if (z) {
            C4990ab.m7416i("MicroMsg.scanner.ScanCamera", "Preview not support NV21, but support YV12");
            parameters.setPreviewFormat(842094169);
        } else {
            C4990ab.m7417i("MicroMsg.scanner.ScanCamera", "Preview not support NV21 and YV12. Use format: %s", supportedPreviewFormats.get(0));
            parameters.setPreviewFormat(((Integer) supportedPreviewFormats.get(0)).intValue());
        }
        this.erH.setParameters(parameters);
        AppMethodBeat.m2505o(81426);
    }

    public final void release() {
        AppMethodBeat.m2504i(81427);
        C4990ab.m7417i("MicroMsg.scanner.ScanCamera", "release(), previewing = [%s]", Boolean.valueOf(this.lUE));
        if (this.erH != null) {
            long yz = C5046bo.m7588yz();
            this.erH.setPreviewCallback(null);
            this.erH.stopPreview();
            this.lUE = false;
            C4990ab.m7417i("MicroMsg.scanner.ScanCamera", "stopPreview costTime=[%s]", Long.valueOf(C5046bo.m7525az(yz)));
            yz = C5046bo.m7588yz();
            this.erH.release();
            this.erH = null;
            C4990ab.m7417i("MicroMsg.scanner.ScanCamera", "camera.release() costTime=[%s]", Long.valueOf(C5046bo.m7525az(yz)));
        }
        this.otY = false;
        this.lUK = false;
        this.qhV = -1;
        this.hGe = 0;
        AppMethodBeat.m2505o(81427);
    }

    private void chZ() {
        AppMethodBeat.m2504i(81428);
        if (this.lQX == null) {
            AppMethodBeat.m2505o(81428);
            return;
        }
        this.qhT = new Rect();
        float f = (float) this.lUF.x;
        float f2 = (float) this.lUF.y;
        if (this.lUI && !this.qhS) {
            f = (float) this.lUF.y;
            f2 = (float) this.lUF.x;
        }
        int width = (int) ((((float) this.lQX.width()) / f) * 2000.0f);
        int height = (int) ((((float) this.lQX.height()) / f2) * 2000.0f);
        this.qhT.left = (-width) / 2;
        this.qhT.right = width / 2;
        this.qhT.top = (-height) / 2;
        this.qhT.bottom = height / 2;
        C4990ab.m7416i("MicroMsg.scanner.ScanCamera", "set focus area:" + this.qhT);
        AppMethodBeat.m2505o(81428);
    }

    private void cia() {
        AppMethodBeat.m2504i(81429);
        if (this.lQX == null) {
            AppMethodBeat.m2505o(81429);
            return;
        }
        float f = (float) this.lUF.x;
        float f2 = (float) this.lUF.y;
        if (this.lUI && !this.qhS) {
            f = (float) this.lUF.y;
            f2 = (float) this.lUF.x;
        }
        this.qhU = new Rect();
        int width = (int) ((((float) this.lQX.width()) / f) * 2000.0f);
        int height = (int) ((((float) this.lQX.height()) / f2) * 2000.0f);
        this.qhU.left = (-width) / 2;
        this.qhU.right = width / 2;
        this.qhU.top = (-height) / 2;
        this.qhU.bottom = height / 2;
        C4990ab.m7416i("MicroMsg.scanner.ScanCamera", "set metering area:" + this.qhU);
        AppMethodBeat.m2505o(81429);
    }

    public final void cib() {
        AppMethodBeat.m2504i(81430);
        if (this.erH == null || this.lUK) {
            AppMethodBeat.m2505o(81430);
            return;
        }
        try {
            Parameters parameters = this.erH.getParameters();
            chZ();
            cia();
            if (this.qhT == null || this.qhU == null) {
                AppMethodBeat.m2505o(81430);
                return;
            }
            ArrayList arrayList;
            this.lUK = true;
            if (parameters.getMaxNumMeteringAreas() > 0) {
                arrayList = new ArrayList();
                arrayList.add(new Area(this.qhU, 1000));
                parameters.setMeteringAreas(arrayList);
            } else {
                C4990ab.m7416i("MicroMsg.scanner.ScanCamera", "setScanFocusAndMeteringArea, camera not support set metering area");
            }
            if (parameters.getMaxNumFocusAreas() > 0) {
                arrayList = new ArrayList();
                arrayList.add(new Area(this.qhT, 1000));
                parameters.setFocusAreas(arrayList);
            } else {
                C4990ab.m7416i("MicroMsg.scanner.ScanCamera", "setScanFocusAndMeteringArea, camera not support area focus");
            }
            this.erH.setParameters(parameters);
            AppMethodBeat.m2505o(81430);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.scanner.ScanCamera", "setScanFocusAndMeteringArea error: %s", e.getMessage());
            AppMethodBeat.m2505o(81430);
        }
    }

    /* renamed from: e */
    public final void mo62607e(Point point) {
        AppMethodBeat.m2504i(81431);
        this.lUH = new Point(point);
        C4990ab.m7411d("MicroMsg.scanner.ScanCamera", "set visible resolution:%s", this.lUH);
        AppMethodBeat.m2505o(81431);
    }

    /* renamed from: a */
    private static Point m67745a(Parameters parameters, Point point, Point point2, boolean z) {
        Object obj;
        AppMethodBeat.m2504i(81432);
        String str = parameters.get("preview-size-values");
        if (str == null) {
            obj = parameters.get("preview-size-value");
        } else {
            String obj2 = str;
        }
        Point point3 = null;
        if (obj2 != null) {
            C4990ab.m7410d("MicroMsg.scanner.ScanCamera", "preview-size-values parameter: ".concat(String.valueOf(obj2)));
            point3 = C39640h.m67746a(parameters, point, z);
        }
        if (point3 == null) {
            point3 = new Point((point2.x >> 3) << 3, (point2.y >> 3) << 3);
        }
        AppMethodBeat.m2505o(81432);
        return point3;
    }

    /* renamed from: a */
    private static Point m67746a(Parameters parameters, Point point, boolean z) {
        Size previewSize;
        AppMethodBeat.m2504i(81433);
        ArrayList<Size> arrayList = new ArrayList(parameters.getSupportedPreviewSizes());
        Collections.sort(arrayList, new C39639a());
        arrayList.remove(0);
        Point point2 = null;
        C4990ab.m7411d("MicroMsg.scanner.ScanCamera", "screen.x: %d, screen.y: %d, ratio: %f", Integer.valueOf(point.x), Integer.valueOf(point.y), Float.valueOf(((float) point.x) / ((float) point.y)));
        C4990ab.m7417i("MicroMsg.scanner.ScanCamera", "SCREEN_PIXELS: %s, MAX_PREVIEW_PIXELS_USE_BIGGER: %s", Integer.valueOf(point.x * point.y), Integer.valueOf(2073600));
        float f = Float.POSITIVE_INFINITY;
        for (Size previewSize2 : arrayList) {
            int i = previewSize2.width;
            int i2 = previewSize2.height;
            C4990ab.m7417i("MicroMsg.scanner.ScanCamera", "realWidth: %d, realHeight: %d", Integer.valueOf(i), Integer.valueOf(i2));
            int i3 = i * i2;
            if (i3 >= 150400 && i3 <= 2073600) {
                if (i3 <= r7 || Math.min(point.x, point.y) < 720) {
                    int i4;
                    Object obj = i > i2 ? 1 : null;
                    if (obj == null || z) {
                        i4 = i;
                    } else {
                        i4 = i2;
                    }
                    if (obj == null || z) {
                        i3 = i2;
                    } else {
                        i3 = i;
                    }
                    C4990ab.m7411d("MicroMsg.scanner.ScanCamera", "maybeFlippedWidth: %d, maybeFlippedHeight: %d", Integer.valueOf(i4), Integer.valueOf(i3));
                    if (i4 == point.x && i3 == point.y) {
                        point2 = new Point(i, i2);
                        C4990ab.m7416i("MicroMsg.scanner.ScanCamera", "Found preview size exactly matching screen size: ".concat(String.valueOf(point2)));
                        AppMethodBeat.m2505o(81433);
                        return point2;
                    }
                    float f2;
                    float abs = Math.abs((((float) i4) / ((float) i3)) - r6);
                    if (abs < f) {
                        f2 = abs;
                        point2 = new Point(i, i2);
                    } else {
                        f2 = f;
                    }
                    C4990ab.m7417i("MicroMsg.scanner.ScanCamera", "diff:[%s] newdiff:[%s] w:[%s] h:[%s]", Float.valueOf(f2), Float.valueOf(abs), Integer.valueOf(i), Integer.valueOf(i2));
                    f = f2;
                }
            }
        }
        if (point2 == null) {
            previewSize2 = parameters.getPreviewSize();
            point2 = new Point(previewSize2.width, previewSize2.height);
            C4990ab.m7416i("MicroMsg.scanner.ScanCamera", "No suitable preview sizes, using default: ".concat(String.valueOf(point2)));
        }
        C4990ab.m7416i("MicroMsg.scanner.ScanCamera", "Found best approximate preview size: ".concat(String.valueOf(point2)));
        AppMethodBeat.m2505o(81433);
        return point2;
    }

    public final void cic() {
        AppMethodBeat.m2504i(81434);
        try {
            if (this.erH != null) {
                Parameters parameters = this.erH.getParameters();
                String str = parameters.get("zoom-supported");
                if (C5046bo.isNullOrNil(str) || !Boolean.parseBoolean(str)) {
                    C4990ab.m7416i("MicroMsg.scanner.ScanCamera", "not support zoom");
                    AppMethodBeat.m2505o(81434);
                    return;
                }
                List zoomRatios = parameters.getZoomRatios();
                if (zoomRatios == null || zoomRatios.size() <= 0) {
                    AppMethodBeat.m2505o(81434);
                    return;
                }
                C1427q.m3050ku(C1720g.m3536RP().mo5240Rz().dur());
                C4990ab.m7417i("MicroMsg.scanner.ScanCamera", "needZoom: %s, qrCodeZoom: %s", Boolean.valueOf(C1427q.etn.esj == 1), Integer.valueOf(C1427q.etn.esj));
                if ((C1427q.etn.esj == 1) && this.lUG.x >= 720 && (this.hGe == 1 || this.hGe == 8 || this.hGe == 4)) {
                    this.qhY = zoomRatios.size() / 5;
                    if (this.qhY > 150) {
                        this.qhY = 150;
                    }
                } else {
                    this.qhY = 0;
                }
                double d = 1.5d;
                if (C1427q.etn.esk != -1.0d) {
                    d = C1427q.etn.esk;
                }
                this.qhZ = (int) (((double) zoomRatios.size()) / d);
                C4990ab.m7411d("MicroMsg.scanner.ScanCamera", "divideRatio: %f,max zoom: %d", Double.valueOf(d), Integer.valueOf(this.qhZ));
                if (this.qhZ < this.qhY) {
                    this.qhZ = this.qhY;
                } else if (this.qhZ > 400) {
                    this.qhZ = 400;
                }
                C4990ab.m7417i("MicroMsg.scanner.ScanCamera", "default zoom:%d,default ratio:%d,max zoom:%d,max ratio:%d", Integer.valueOf(this.qhY), zoomRatios.get(this.qhY), Integer.valueOf(this.qhZ), zoomRatios.get(this.qhZ));
            }
            AppMethodBeat.m2505o(81434);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.scanner.ScanCamera", e, "init zoom exception!", new Object[0]);
            AppMethodBeat.m2505o(81434);
        }
    }

    /* renamed from: o */
    private static int m67748o(List<Integer> list, int i) {
        int binarySearch;
        AppMethodBeat.m2504i(81435);
        if (list != null && list.size() > 0) {
            C4990ab.m7417i("MicroMsg.scanner.ScanCamera", "zoomRatios: %s,size: %d", list, Integer.valueOf(list.size()));
            binarySearch = Collections.binarySearch(list, Integer.valueOf(i));
            C4990ab.m7417i("MicroMsg.scanner.ScanCamera", "insert index:%d", Integer.valueOf(binarySearch));
            if (binarySearch < 0) {
                int i2 = -(binarySearch + 1);
                int i3 = i2 - 1;
                if (i2 < 0 || i2 > list.size() - 1 || i3 < 0 || i3 > list.size() - 1) {
                    if (i2 >= 0 && i2 <= list.size() - 1) {
                        binarySearch = i2;
                    } else if (i3 >= 0 && i3 <= list.size() - 1) {
                        binarySearch = i3;
                    }
                } else if (((Integer) list.get(i2)).intValue() - i > i - ((Integer) list.get(i3)).intValue()) {
                    binarySearch = i3;
                } else {
                    binarySearch = i2;
                }
            }
            AppMethodBeat.m2505o(81435);
            return binarySearch;
        }
        binarySearch = 0;
        AppMethodBeat.m2505o(81435);
        return binarySearch;
    }

    /* renamed from: Ce */
    public final void mo62595Ce(int i) {
        AppMethodBeat.m2504i(81436);
        if (this.erH != null && this.lUE && i > 0) {
            try {
                Parameters parameters = this.erH.getParameters();
                List zoomRatios = parameters.getZoomRatios();
                if (zoomRatios == null || zoomRatios.size() <= 0) {
                    AppMethodBeat.m2505o(81436);
                    return;
                }
                int o;
                int intValue = (int) ((((double) i) / 100.0d) * ((double) ((Integer) zoomRatios.get(this.qhX)).intValue()));
                C4990ab.m7411d("MicroMsg.scanner.ScanCamera", "scale:%d,to ratio:%d", Integer.valueOf(i), Integer.valueOf(intValue));
                if (intValue >= ((Integer) zoomRatios.get(this.qhY)).intValue() && intValue <= ((Integer) zoomRatios.get(this.qhZ)).intValue()) {
                    o = C39640h.m67748o(zoomRatios, intValue);
                } else if (intValue < ((Integer) zoomRatios.get(this.qhY)).intValue()) {
                    o = this.qhY;
                } else {
                    C4990ab.m7416i("MicroMsg.scanner.ScanCamera", "exceed max zoom");
                    o = this.qhX + ((this.qhZ - this.qhX) / 5);
                    if (o > this.qhZ) {
                        o = this.qhZ;
                    }
                }
                C4990ab.m7417i("MicroMsg.scanner.ScanCamera", "zoom:%d,ratio:%d", Integer.valueOf(o), zoomRatios.get(o));
                this.qhX = o;
                parameters.setZoom(o);
                this.erH.setParameters(parameters);
                AppMethodBeat.m2505o(81436);
                return;
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.scanner.ScanCamera", "zoom scale exception:" + e.getMessage());
            }
        }
        AppMethodBeat.m2505o(81436);
    }

    /* renamed from: Cf */
    public final void mo62596Cf(int i) {
        AppMethodBeat.m2504i(81437);
        if (this.erH != null && this.lUE) {
            try {
                Parameters parameters = this.erH.getParameters();
                List zoomRatios = parameters.getZoomRatios();
                if (zoomRatios == null || zoomRatios.size() <= 0) {
                    AppMethodBeat.m2505o(81437);
                    return;
                }
                C4990ab.m7417i("MicroMsg.scanner.ScanCamera", "zoom action:%d,beforeZoom:%d", Integer.valueOf(i), Integer.valueOf(parameters.getZoom()));
                switch (i) {
                    case 0:
                        this.qhX = 0;
                        break;
                    case 1:
                        this.qhX = this.qhY;
                        break;
                    case 2:
                        if (this.qhX < this.qhZ) {
                            this.qhX++;
                            this.qhX = this.qhX > this.qhZ ? this.qhZ : this.qhX;
                            break;
                        }
                        break;
                    case 3:
                        if (this.qhX > this.qhY) {
                            this.qhX--;
                            this.qhX = this.qhX < this.qhY ? this.qhY : this.qhX;
                            break;
                        }
                        break;
                    case 4:
                        this.qhX = this.qhZ;
                        break;
                    case 5:
                        if (this.qhX == this.qhY) {
                            this.qhX = this.qhZ;
                            break;
                        } else {
                            this.qhX = this.qhY;
                            break;
                        }
                }
                parameters.setZoom(this.qhX);
                this.erH.setParameters(parameters);
                C4990ab.m7417i("MicroMsg.scanner.ScanCamera", "zoom action:%d,afterZoom:%d", Integer.valueOf(i), Integer.valueOf(parameters.getZoom()));
                AppMethodBeat.m2505o(81437);
                return;
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.scanner.ScanCamera", "zoom action exception:" + e.getMessage());
            }
        }
        AppMethodBeat.m2505o(81437);
    }

    public final int cid() {
        AppMethodBeat.m2504i(81438);
        try {
            if (!(this.erH == null || this.erH.getParameters() == null || this.erH.getParameters().getZoomRatios() == null || this.erH.getParameters().getZoomRatios().size() <= 0)) {
                int intValue = ((Integer) this.erH.getParameters().getZoomRatios().get(this.qhX)).intValue();
                AppMethodBeat.m2505o(81438);
                return intValue;
            }
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.scanner.ScanCamera", "get zoom ratio exception:" + e.getMessage());
        }
        AppMethodBeat.m2505o(81438);
        return 100;
    }

    /* renamed from: e */
    private static void m67747e(Parameters parameters) {
        AppMethodBeat.m2504i(81439);
        try {
            C4990ab.m7416i("MicroMsg.scanner.ScanCamera", "set scan focus");
            List<String> supportedFocusModes = parameters.getSupportedFocusModes();
            if (supportedFocusModes != null) {
                C4990ab.m7416i("MicroMsg.scanner.ScanCamera", "supported focus modes size = " + supportedFocusModes.size());
                for (String valueOf : supportedFocusModes) {
                    C4990ab.m7416i("MicroMsg.scanner.ScanCamera", "supported focus modes : ".concat(String.valueOf(valueOf)));
                }
                if (supportedFocusModes.contains("continuous-video")) {
                    C4990ab.m7410d("MicroMsg.scanner.ScanCamera", "camera support continuous video focus");
                    parameters.setFocusMode("continuous-video");
                    AppMethodBeat.m2505o(81439);
                    return;
                } else if (supportedFocusModes.contains("auto")) {
                    C4990ab.m7410d("MicroMsg.scanner.ScanCamera", "camera support auto focus");
                    parameters.setFocusMode("auto");
                }
            }
            AppMethodBeat.m2505o(81439);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.scanner.ScanCamera", "setScanFocus error: %s", e.getMessage());
            AppMethodBeat.m2505o(81439);
        }
    }

    public final void cie() {
        AppMethodBeat.m2504i(81440);
        try {
            C4990ab.m7416i("MicroMsg.scanner.ScanCamera", "set picture focus");
            Parameters parameters = this.erH.getParameters();
            if (parameters == null) {
                C4990ab.m7420w("MicroMsg.scanner.ScanCamera", "camera parameters is null");
                AppMethodBeat.m2505o(81440);
                return;
            }
            List<String> supportedFocusModes = parameters.getSupportedFocusModes();
            if (supportedFocusModes != null) {
                C4990ab.m7410d("MicroMsg.scanner.ScanCamera", "supported focus modes size = " + supportedFocusModes.size());
                for (String valueOf : supportedFocusModes) {
                    C4990ab.m7410d("MicroMsg.scanner.ScanCamera", "supported focus modes : ".concat(String.valueOf(valueOf)));
                }
                if (supportedFocusModes.contains("continuous-picture")) {
                    C4990ab.m7410d("MicroMsg.scanner.ScanCamera", "camera support continuous picture focus");
                    parameters.setFocusMode("continuous-picture");
                } else if (supportedFocusModes.contains("continuous-video")) {
                    C4990ab.m7410d("MicroMsg.scanner.ScanCamera", "camera support continuous video focus");
                    parameters.setFocusMode("continuous-video");
                } else if (supportedFocusModes.contains("auto")) {
                    C4990ab.m7410d("MicroMsg.scanner.ScanCamera", "camera support auto focus");
                    parameters.setFocusMode("auto");
                }
                this.erH.setParameters(parameters);
            }
            AppMethodBeat.m2505o(81440);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.scanner.ScanCamera", "setPictureFocus error: %s", e.getMessage());
            AppMethodBeat.m2505o(81440);
        }
    }

    public final boolean cif() {
        AppMethodBeat.m2504i(81441);
        if (this.erH != null && this.lUE) {
            try {
                Parameters parameters = this.erH.getParameters();
                if (C5046bo.m7548ek(parameters.getSupportedFlashModes()) || !parameters.getSupportedFlashModes().contains("torch")) {
                    C4990ab.m7416i("MicroMsg.scanner.ScanCamera", "camera not support flash!!");
                } else {
                    AppMethodBeat.m2505o(81441);
                    return true;
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.scanner.ScanCamera", e, "isFlashSupported error: %s", e.getMessage());
            }
        }
        AppMethodBeat.m2505o(81441);
        return false;
    }

    public final void bPs() {
        AppMethodBeat.m2504i(81442);
        C4990ab.m7417i("MicroMsg.scanner.ScanCamera", "closeFlash, camera: %s, isPreviewing: %s", this.erH, Boolean.valueOf(this.lUE));
        if (this.erH != null && this.lUE) {
            try {
                this.otY = false;
                Parameters parameters = this.erH.getParameters();
                if (C5046bo.m7548ek(parameters.getSupportedFlashModes()) || !parameters.getSupportedFlashModes().contains("off")) {
                    C4990ab.m7416i("MicroMsg.scanner.ScanCamera", "camera not support close flash!!");
                    AppMethodBeat.m2505o(81442);
                    return;
                }
                parameters.setFlashMode("off");
                this.erH.setParameters(parameters);
                C4990ab.m7416i("MicroMsg.scanner.ScanCamera", "close flash");
                AppMethodBeat.m2505o(81442);
                return;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.scanner.ScanCamera", e, "closeFlash error: %s", e.getMessage());
            }
        }
        AppMethodBeat.m2505o(81442);
    }

    public final float chX() {
        if (!this.lUI || this.qhS) {
            return ((float) this.lUF.x) / ((float) this.lUH.x);
        }
        return ((float) this.lUF.y) / ((float) this.lUH.x);
    }

    public final float chY() {
        if (!this.lUI || this.qhS) {
            return ((float) this.lUF.y) / ((float) this.lUH.y);
        }
        return ((float) this.lUF.x) / ((float) this.lUH.y);
    }
}

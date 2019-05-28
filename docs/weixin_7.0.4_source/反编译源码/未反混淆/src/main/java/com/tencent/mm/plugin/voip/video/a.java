package com.tencent.mm.plugin.voip.video;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Build.VERSION;
import android.support.v4.widget.j;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.e.t;
import com.tencent.mm.compatible.e.z;
import com.tencent.mm.compatible.util.l;
import com.tencent.mm.g.a.mi;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.video.ObservableSurfaceView;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.video.b;
import com.tencent.mm.plugin.voip.a.d;
import com.tencent.mm.plugin.voip.model.m;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import com.tencent.wxmm.v2helper;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class a implements com.tencent.mm.plugin.video.a, b {
    private static final Pattern qhR = Pattern.compile(",");
    private static int sZl = 20;
    private static int sZm = 70;
    protected int mHeight = 240;
    protected int mWidth = 320;
    protected t mdw;
    protected boolean mdx = false;
    protected boolean sZA = false;
    protected ObservableSurfaceView sZB = null;
    protected ObservableTextureView sZC;
    protected g sZD;
    protected boolean sZE = false;
    protected boolean sZF = false;
    protected byte[] sZG = null;
    protected int[] sZH = null;
    protected List<byte[]> sZI;
    protected boolean sZJ = true;
    protected int sZK;
    protected int sZL = 0;
    protected int sZM = 0;
    protected int sZN = 0;
    protected boolean sZO = false;
    PreviewCallback sZP = new PreviewCallback() {
        public final void onPreviewFrame(byte[] bArr, Camera camera) {
            AppMethodBeat.i(ReaderCallback.READER_PLUGIN_RES_PPT_GUIDE);
            if (bArr == null || bArr.length <= 0) {
                h.pYm.a(159, 0, 1, false);
                h.pYm.a(159, 3, 1, false);
                if (a.this.sZD != null) {
                    a.this.sZD.bSo();
                }
                AppMethodBeat.o(ReaderCallback.READER_PLUGIN_RES_PPT_GUIDE);
            } else if (a.this.sZw == null) {
                ab.e("MicroMsg.Voip.CaptureRender", "onPreviewFrame mSize is null");
                AppMethodBeat.o(ReaderCallback.READER_PLUGIN_RES_PPT_GUIDE);
            } else {
                if (a.this.sZD != null) {
                    int i;
                    Object obj;
                    int i2 = 1;
                    if (a.this.sZn) {
                        i = j.tbu;
                        if (q.etc.eqY && q.etc.eqX.rotate != 0) {
                            i2 = q.etc.eqX.erF;
                            obj = 1;
                        }
                        obj = null;
                    } else {
                        i = j.tbv;
                        if (q.etc.era && q.etc.eqZ.rotate != 0) {
                            i2 = q.etc.eqZ.erF;
                            int obj2 = 1;
                        }
                        obj2 = null;
                    }
                    int i3 = i > 0 ? 32 : 0;
                    a aVar = a.this;
                    boolean z = obj2 == null && i > 0;
                    aVar.sZo = z;
                    int i4 = a.this.sZw.width;
                    int i5 = a.this.sZw.height;
                    if (obj2 != null) {
                        if (a.this.sZG == null) {
                            a.this.sZG = new byte[(((i4 * i5) * 3) / 2)];
                            a.this.sZG[0] = (byte) 90;
                        }
                        r cIj = com.tencent.mm.plugin.voip.b.cIj();
                        i = bArr.length;
                        int i6 = a.this.sZx;
                        byte[] bArr2 = a.this.sZG;
                        int length = a.this.sZG.length;
                        m mVar = cIj.sSP.sNl.sPr;
                        if (mVar.kzf != m.kze && mVar.sNl.sPp.cKK() && mVar.sNl.cIP()) {
                            mVar.sNl.sPp.videoRorate90D(bArr, i, i4, i5, i6, bArr2, length, i4, i5, i2);
                        }
                        a.this.sZD.a(a.this.sZG, (long) a.this.sZG.length, i4, i5, a.this.sZx, i3);
                    } else {
                        a.this.sZD.a(bArr, (long) bArr.length, a.this.sZw.width, a.this.sZw.height, a.this.sZx, i3);
                    }
                    if (d.cLu() >= 8) {
                        if (a.this.mdw == null) {
                            ab.e("MicroMsg.Voip.CaptureRender", "the camera is null and has been release");
                            AppMethodBeat.o(ReaderCallback.READER_PLUGIN_RES_PPT_GUIDE);
                            return;
                        } else if (a.this.mdw != null) {
                            a.this.mdw.addCallbackBuffer(bArr);
                        }
                    }
                }
                AppMethodBeat.o(ReaderCallback.READER_PLUGIN_RES_PPT_GUIDE);
            }
        }
    };
    protected boolean sZn = false;
    protected boolean sZo = false;
    protected boolean sZp = false;
    protected boolean sZq = false;
    protected boolean sZr = false;
    protected long sZs = 0;
    protected long sZt = 30000;
    protected int sZu = 0;
    protected Parameters sZv;
    protected z sZw;
    protected int sZx;
    protected boolean sZy = false;
    protected boolean sZz = false;

    static {
        AppMethodBeat.i(ReaderCallback.READER_PLUGIN_COMMAND_TEXT_FIND_CLEAR);
        AppMethodBeat.o(ReaderCallback.READER_PLUGIN_COMMAND_TEXT_FIND_CLEAR);
    }

    public a(int i, int i2) {
        AppMethodBeat.i(ReaderCallback.READER_PLUGIN_RES_TXT_GUIDE);
        this.mWidth = i;
        this.mHeight = i2;
        j.fi(ah.getContext().getApplicationContext());
        ab.d("MicroMsg.Voip.CaptureRender", "width: %d, height: %d", Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight));
        AppMethodBeat.o(ReaderCallback.READER_PLUGIN_RES_TXT_GUIDE);
    }

    public final void a(ObservableSurfaceView observableSurfaceView) {
        AppMethodBeat.i(ReaderCallback.READER_PLUGIN_RES_PDF_GUIDE);
        ab.d("MicroMsg.Voip.CaptureRender", "bind ObservableSurfaceView");
        if (observableSurfaceView == null) {
            AppMethodBeat.o(ReaderCallback.READER_PLUGIN_RES_PDF_GUIDE);
            return;
        }
        this.sZB = observableSurfaceView;
        this.sZB.setSurfaceChangeCallback(this);
        this.sZA = true;
        AppMethodBeat.o(ReaderCallback.READER_PLUGIN_RES_PDF_GUIDE);
    }

    public final void a(ObservableTextureView observableTextureView) {
        AppMethodBeat.i(ReaderCallback.GET_BAR_ISSHOWING);
        ab.i("MicroMsg.Voip.CaptureRender", "bind ObservableTextureView");
        if (observableTextureView == null) {
            AppMethodBeat.o(ReaderCallback.GET_BAR_ISSHOWING);
            return;
        }
        this.sZC = observableTextureView;
        this.sZC.setTextureChangeCallback(this);
        this.sZA = false;
        AppMethodBeat.o(ReaderCallback.GET_BAR_ISSHOWING);
    }

    public final boolean bPu() {
        return this.mdx;
    }

    public final void a(SurfaceHolder surfaceHolder) {
        boolean z = false;
        AppMethodBeat.i(ReaderCallback.READER_PLUGIN_SO_ERR);
        ab.d("MicroMsg.Voip.CaptureRender", "surfaceChange");
        if (!this.sZy || surfaceHolder.getSurface() == null) {
            String str = "MicroMsg.Voip.CaptureRender";
            String str2 = "surfaceChange failed, CameraOpen: %b, surface: %b, apiLevel: %s";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(this.sZy);
            if (surfaceHolder.getSurface() == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            objArr[2] = Integer.valueOf(VERSION.SDK_INT);
            ab.e(str, str2, objArr);
            AppMethodBeat.o(ReaderCallback.READER_PLUGIN_SO_ERR);
            return;
        }
        try {
            this.mdw.setPreviewCallback(null);
            this.mdw.stopPreview();
            this.mdw.setPreviewDisplay(surfaceHolder);
            cLA();
            this.mdw.startPreview();
            this.mdx = true;
        } catch (Exception e) {
            Exception exception = e;
            h.pYm.a(159, 0, 1, false);
            h.pYm.a(159, 2, 1, false);
            ab.e("MicroMsg.Voip.CaptureRender", "surfaceChange failed" + exception.getMessage());
            this.sZu = 1;
        }
        if (this.sZF) {
            cLC();
            this.sZF = false;
        }
        com.tencent.mm.plugin.voip.b.cIj().Gw(this.sZu);
        AppMethodBeat.o(ReaderCallback.READER_PLUGIN_SO_ERR);
    }

    public final void e(SurfaceTexture surfaceTexture) {
        boolean z = false;
        AppMethodBeat.i(ReaderCallback.READER_SEARCH_IN_DOCUMENT);
        ab.d("MicroMsg.Voip.CaptureRender", "onSurfaceTextureAvailable");
        if (!this.sZy || surfaceTexture == null) {
            String str = "MicroMsg.Voip.CaptureRender";
            String str2 = "onSurfaceTextureAvailable failed, CameraOpen: %b, surface: %b";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(this.sZy);
            if (surfaceTexture == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            ab.e(str, str2, objArr);
            AppMethodBeat.o(ReaderCallback.READER_SEARCH_IN_DOCUMENT);
            return;
        }
        try {
            this.mdw.setPreviewCallback(null);
            this.mdw.stopPreview();
            this.mdw.setPreviewTexture(surfaceTexture);
            cLA();
            this.mdw.startPreview();
            this.mdx = true;
        } catch (Exception e) {
            Exception exception = e;
            h.pYm.a(159, 0, 1, false);
            h.pYm.a(159, 2, 1, false);
            ab.e("MicroMsg.Voip.CaptureRender", "surfaceChange failed" + exception.getMessage());
            this.sZu = 1;
        }
        if (this.sZF) {
            cLC();
            this.sZF = false;
        }
        com.tencent.mm.plugin.voip.b.cIj().Gw(this.sZu);
        AppMethodBeat.o(ReaderCallback.READER_SEARCH_IN_DOCUMENT);
    }

    public final int a(g gVar, boolean z) {
        AppMethodBeat.i(ReaderCallback.READER_PLUGIN_SO_INTO_START);
        if (j.tbr.eqQ <= 0) {
            this.sZu = 1;
            AppMethodBeat.o(ReaderCallback.READER_PLUGIN_SO_INTO_START);
            return -1;
        }
        if (z) {
            if (!j.tbr.tak) {
                z = false;
            }
        } else if (!j.tbr.tal) {
            z = true;
        }
        this.sZD = gVar;
        if (i(z, this.mWidth, this.mHeight) <= 0) {
            int i = i(z, this.mWidth, this.mHeight);
            if (i <= 0) {
                this.sZu = 1;
                AppMethodBeat.o(ReaderCallback.READER_PLUGIN_SO_INTO_START);
                return i;
            }
        }
        cLA();
        this.sZu = 0;
        AppMethodBeat.o(ReaderCallback.READER_PLUGIN_SO_INTO_START);
        return 1;
    }

    private void cLA() {
        AppMethodBeat.i(ReaderCallback.READER_PLUGIN_SO_PROGRESS);
        try {
            if (this.mdw != null && this.sZy) {
                if (this.sZw == null || this.sZw.height <= 0 || this.sZw.width <= 0) {
                    this.mdw.setPreviewCallback(this.sZP);
                } else {
                    int i = ((this.sZw.height * this.sZw.width) * 3) / 2;
                    if (this.sZI == null) {
                        this.sZI = new ArrayList(3);
                        for (int i2 = 0; i2 < 3; i2++) {
                            this.sZI.add(new byte[i]);
                        }
                    }
                    for (i = 0; i < this.sZI.size(); i++) {
                        if (this.mdw != null) {
                            this.mdw.addCallbackBuffer((byte[]) this.sZI.get(i));
                        }
                    }
                    this.mdw.setPreviewCallbackWithBuffer(this.sZP);
                    AppMethodBeat.o(ReaderCallback.READER_PLUGIN_SO_PROGRESS);
                    return;
                }
            }
            AppMethodBeat.o(ReaderCallback.READER_PLUGIN_SO_PROGRESS);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Voip.CaptureRender", e, "setPreviewCallback error: %s", e.getMessage());
            AppMethodBeat.o(ReaderCallback.READER_PLUGIN_SO_PROGRESS);
        }
    }

    private static t mB(boolean z) {
        t tVar = null;
        AppMethodBeat.i(ReaderCallback.READER_PLUGIN_RES_DOC_GUIDE);
        if (j.tbr.eqQ <= 0) {
            AppMethodBeat.o(ReaderCallback.READER_PLUGIN_RES_DOC_GUIDE);
        } else if (j.tbx) {
            com.tencent.mm.compatible.e.d.a.a a;
            if (z) {
                try {
                    a = com.tencent.mm.compatible.e.d.a(ah.getContext(), j.tbs, null);
                    ab.i("Camera", "Use front");
                } catch (Exception e) {
                    Exception exception = e;
                    h.pYm.a(159, 0, 1, false);
                    h.pYm.a(159, 1, 1, false);
                    ab.e("MicroMsg.Voip.CaptureRender", "openCameraByHighApiLvl:error:" + exception.toString());
                }
            } else {
                a = com.tencent.mm.compatible.e.d.a(ah.getContext(), j.tbt, null);
                ab.i("Camera", "Use back");
            }
            if (a != null) {
                tVar = a.erH;
            }
            AppMethodBeat.o(ReaderCallback.READER_PLUGIN_RES_DOC_GUIDE);
        } else {
            AppMethodBeat.o(ReaderCallback.READER_PLUGIN_RES_DOC_GUIDE);
        }
        return tVar;
    }

    private t mC(boolean z) {
        AppMethodBeat.i(ReaderCallback.READER_PLUGIN_SO_VERSION);
        t mB = mB(z);
        if (mB == null) {
            try {
                mB = new t(Camera.open());
                try {
                    Parameters parameters = mB.getParameters();
                    parameters.set("camera-id", z ? 2 : 1);
                    mB.setParameters(parameters);
                } catch (Exception e) {
                    Exception exception = e;
                    h.pYm.a(159, 0, 1, false);
                    ab.e("MicroMsg.Voip.CaptureRender", "set camera-id error:" + exception.toString());
                }
            } catch (Exception e2) {
                ab.e("MicroMsg.Voip.CaptureRender", "OpenCameraError:" + e2.toString());
                h.pYm.a(159, 0, 1, false);
                h.pYm.a(159, 1, 1, false);
                if (this.sZD != null) {
                    this.sZD.bSo();
                }
                AppMethodBeat.o(ReaderCallback.READER_PLUGIN_SO_VERSION);
                return null;
            }
        }
        this.sZn = z;
        h(mB);
        g(mB);
        AppMethodBeat.o(ReaderCallback.READER_PLUGIN_SO_VERSION);
        return mB;
    }

    private static boolean a(t tVar, int i, int i2) {
        AppMethodBeat.i(ReaderCallback.READER_OPEN_QQ_FILE_LIST);
        if (tVar == null) {
            AppMethodBeat.o(ReaderCallback.READER_OPEN_QQ_FILE_LIST);
            return false;
        }
        try {
            Parameters parameters = tVar.getParameters();
            if (i > 0 && i2 > 0) {
                parameters.setPreviewSize(i, i2);
            }
            tVar.setParameters(parameters);
            AppMethodBeat.o(ReaderCallback.READER_OPEN_QQ_FILE_LIST);
            return true;
        } catch (Exception e) {
            h.pYm.a(159, 0, 1, false);
            ab.e("MicroMsg.Voip.CaptureRender", "TryPreviewSize fail:" + e.toString());
            AppMethodBeat.o(ReaderCallback.READER_OPEN_QQ_FILE_LIST);
            return false;
        }
    }

    private boolean c(t tVar, boolean z) {
        AppMethodBeat.i(ReaderCallback.READER_PLUGIN_ACTIVITY_PAUSE);
        if (tVar == null) {
            AppMethodBeat.o(ReaderCallback.READER_PLUGIN_ACTIVITY_PAUSE);
            return false;
        }
        try {
            ab.i("MicroMsg.Voip.CaptureRender", "trySetAutoFocus, isFrontCamera:%s", Boolean.valueOf(z));
            Parameters parameters = tVar.getParameters();
            List<String> supportedFocusModes = parameters.getSupportedFocusModes();
            if (supportedFocusModes != null) {
                ab.d("MicroMsg.Voip.CaptureRender", "supported focus modes size = " + supportedFocusModes.size());
                for (String valueOf : supportedFocusModes) {
                    ab.d("MicroMsg.Voip.CaptureRender", "supported focus modes : ".concat(String.valueOf(valueOf)));
                }
                if (q.etc.ery == 0 && z) {
                    if (supportedFocusModes.contains("auto")) {
                        ab.d("MicroMsg.Voip.CaptureRender", "camera support auto focus");
                        parameters.setFocusMode("auto");
                        this.sZz = false;
                    } else if (supportedFocusModes.contains("continuous-video")) {
                        ab.d("MicroMsg.Voip.CaptureRender", "camera support continuous video focus");
                        parameters.setFocusMode("continuous-video");
                        this.sZz = true;
                    }
                } else if (q.etc.ery == 1 || !z) {
                    if (supportedFocusModes.contains("continuous-video")) {
                        ab.d("MicroMsg.Voip.CaptureRender", "camera support continuous video focus");
                        parameters.setFocusMode("continuous-video");
                        this.sZz = true;
                    } else if (supportedFocusModes.contains("auto")) {
                        ab.d("MicroMsg.Voip.CaptureRender", "camera support auto focus");
                        parameters.setFocusMode("auto");
                        this.sZz = false;
                    }
                }
                tVar.setParameters(parameters);
            }
            AppMethodBeat.o(ReaderCallback.READER_PLUGIN_ACTIVITY_PAUSE);
            return true;
        } catch (Exception e) {
            h.pYm.a(159, 0, 1, false);
            ab.e("MicroMsg.Voip.CaptureRender", "TrySetAutoFocus fail:" + e.toString());
            AppMethodBeat.o(ReaderCallback.READER_PLUGIN_ACTIVITY_PAUSE);
            return false;
        }
    }

    private static Point a(CharSequence charSequence, Point point) {
        int indexOf;
        int i;
        AppMethodBeat.i(5033);
        int i2 = BaseClientBuilder.API_PRIORITY_OTHER;
        int i3 = 0;
        int i4 = 0;
        for (String trim : qhR.split(charSequence)) {
            String trim2 = trim2.trim();
            indexOf = trim2.indexOf(120);
            if (indexOf < 0) {
                ab.w("MicroMsg.Voip.CaptureRender", "Bad preview-size: ".concat(String.valueOf(trim2)));
            } else {
                try {
                    i = bo.getInt(trim2.substring(0, indexOf), 0);
                    indexOf = bo.getInt(trim2.substring(indexOf + 1), 0);
                    int abs = Math.abs(i - point.x) + Math.abs(indexOf - point.y);
                    if (abs == 0) {
                        break;
                    } else if (abs < i2 && i != indexOf) {
                        i2 = abs;
                        i3 = indexOf;
                        i4 = i;
                    }
                } catch (NumberFormatException e) {
                    ab.w("MicroMsg.Voip.CaptureRender", "Bad preview-size: ".concat(String.valueOf(trim2)));
                }
            }
        }
        indexOf = i3;
        i = i4;
        if (i <= 0 || indexOf <= 0) {
            AppMethodBeat.o(5033);
            return null;
        }
        Point point2 = new Point(i, indexOf);
        AppMethodBeat.o(5033);
        return point2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x012b A:{SYNTHETIC, Splitter:B:38:0x012b} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x012b A:{SYNTHETIC, Splitter:B:38:0x012b} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x012b A:{SYNTHETIC, Splitter:B:38:0x012b} */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x045a  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x04e8 A:{Catch:{ Exception -> 0x05a5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0509  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x05cd A:{SYNTHETIC, Splitter:B:145:0x05cd} */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x051d A:{Catch:{ Exception -> 0x05ea }} */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x05d1 A:{Catch:{ Exception -> 0x05ea }} */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x05d4 A:{Catch:{ Exception -> 0x05ea }} */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x05d8 A:{Catch:{ Exception -> 0x05ea }} */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x05dc A:{Catch:{ Exception -> 0x05ea }} */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x05e0 A:{Catch:{ Exception -> 0x05ea }} */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0541 A:{Catch:{ Exception -> 0x05ea }} */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x045a  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x04e8 A:{Catch:{ Exception -> 0x05a5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0509  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x051d A:{Catch:{ Exception -> 0x05ea }} */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x05cd A:{SYNTHETIC, Splitter:B:145:0x05cd} */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x05d1 A:{Catch:{ Exception -> 0x05ea }} */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x05d4 A:{Catch:{ Exception -> 0x05ea }} */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x05d8 A:{Catch:{ Exception -> 0x05ea }} */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x05dc A:{Catch:{ Exception -> 0x05ea }} */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0541 A:{Catch:{ Exception -> 0x05ea }} */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x05e0 A:{Catch:{ Exception -> 0x05ea }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int i(boolean z, int i, int i2) {
        Exception e;
        Object obj;
        Size previewSize;
        int previewFrameRate;
        t tVar;
        CameraInfo cameraInfo;
        AppMethodBeat.i(5034);
        ab.i("MicroMsg.Voip.CaptureRender", "try open camera, face: ".concat(String.valueOf(z)));
        this.sZz = false;
        boolean z2 = true;
        if (this.mdw != null) {
            if (this.sZn != z) {
                this.mdw.setPreviewCallback(null);
                this.mdw.stopPreview();
                this.mdw.release();
                this.mdw = null;
            } else {
                z2 = this.sZO;
            }
        }
        if (z2) {
            this.mdw = mC(z);
            if (this.mdw == null) {
                this.sZy = false;
                AppMethodBeat.o(5034);
                return -1;
            }
            this.sZO = false;
        }
        try {
            int min;
            Point point;
            z zVar;
            z zVar2;
            if (this.mdw != null) {
                this.mdw.getParameters();
            }
            this.sZy = true;
            t tVar2 = this.mdw;
            int i3 = j.tbr.taj;
            if (tVar2 != null) {
                Object obj2;
                try {
                    ab.i("MicroMsg.Voip.CaptureRender", "safeSetFps: %s", Integer.valueOf(i3));
                    Parameters parameters = tVar2.getParameters();
                    ab.i("MicroMsg.Voip.CaptureRender", "setFpsRange minApiLevel:%s", Integer.valueOf(((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getInt("VoipCaptureRenderFpsRangeMinApiLevel", 26)));
                    if (l.IN() || com.tencent.mm.compatible.util.d.iW(r2)) {
                        int i4 = BaseClientBuilder.API_PRIORITY_OTHER;
                        boolean z3 = false;
                        int i5 = -1;
                        int i6 = 0;
                        if (q.etc != null) {
                            i5 = q.etc.erA * 1000;
                            i6 = q.etc.erB * 1000;
                        }
                        if (i5 > 0 && r7 > 0 && r7 >= i5) {
                            z3 = true;
                        } else if (i5 == 0 && r7 == 0) {
                            z3 = false;
                            i6 = j.INVALID_ID;
                            i5 = j.INVALID_ID;
                        } else {
                            List supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
                            if (supportedPreviewFpsRange == null || supportedPreviewFpsRange.size() == 0) {
                                obj2 = 1;
                                if (obj2 != null) {
                                    try {
                                        ab.i("MicroMsg.Voip.CaptureRender", "steve: SafeSetFps by setPreviewFrameRate target fps %d", Integer.valueOf(i3));
                                        Parameters parameters2 = tVar2.getParameters();
                                        parameters2.setPreviewFrameRate(i3);
                                        tVar2.setParameters(parameters2);
                                    } catch (Exception e2) {
                                        ab.e("MicroMsg.Voip.CaptureRender", "steve: SafeSetFps by setPreviewFrameRate error:" + e2.toString());
                                    }
                                }
                            } else {
                                int size = supportedPreviewFpsRange.size();
                                int i7 = 0;
                                i6 = j.INVALID_ID;
                                i5 = j.INVALID_ID;
                                while (i7 < size) {
                                    int i8;
                                    int i9;
                                    int i10;
                                    int[] iArr = (int[]) supportedPreviewFpsRange.get(i7);
                                    if (iArr != null && iArr.length > 1) {
                                        i8 = iArr[0];
                                        i9 = iArr[1];
                                        ab.i("MicroMsg.Voip.CaptureRender", "dkfps %d:[%d %d]", Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9));
                                        if (i8 >= 0 && i9 >= i8) {
                                            i10 = i9 / 1000;
                                            int i11 = i8 / 1000;
                                            min = Math.min(i3 + 5, 30);
                                            int max = Math.max(i3 - 5, 5);
                                            obj2 = (i10 < max || i10 > min || i11 < max || i11 > min) ? null : 1;
                                            if (obj2 != null) {
                                                i10 = Math.abs(i10 - i3) + Math.abs(i3 - i11);
                                                if (i10 < i4) {
                                                    z2 = true;
                                                    i7++;
                                                    z3 = z2;
                                                    i4 = i10;
                                                    i6 = i9;
                                                    i5 = i8;
                                                }
                                            }
                                        }
                                    }
                                    z2 = z3;
                                    i10 = i4;
                                    i9 = i6;
                                    i8 = i5;
                                    i7++;
                                    z3 = z2;
                                    i4 = i10;
                                    i6 = i9;
                                    i5 = i8;
                                }
                            }
                        }
                        ab.i("MicroMsg.Voip.CaptureRender", "steve: dkfps get fit  [%d %d], target fps %d, matchTargetFPS:%b", Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i3), Boolean.valueOf(z3));
                        if (i5 == BaseClientBuilder.API_PRIORITY_OTHER || i6 == BaseClientBuilder.API_PRIORITY_OTHER || !z3) {
                            obj2 = 1;
                            if (obj2 != null) {
                            }
                        } else {
                            ab.i("MicroMsg.Voip.CaptureRender", "steve: SafeSetFps by setPreviewFpsRange [%d %d], target fps %d", Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i3));
                            parameters.setPreviewFpsRange(i5, i6);
                            tVar2.setParameters(parameters);
                            obj2 = null;
                            if (obj2 != null) {
                            }
                        }
                    } else {
                        obj2 = 1;
                        if (obj2 != null) {
                        }
                    }
                } catch (Exception e22) {
                    ab.e("MicroMsg.Voip.CaptureRender", "steve: SafeSetFps by setPreviewFpsRange error:" + e22.toString());
                    obj2 = 1;
                }
            }
            ab.i("MicroMsg.Voip.CaptureRender", "Camera Open Success, try set size: w,h:" + i + "," + i2);
            if (z) {
                point = j.tbr.tao;
            } else {
                point = j.tbr.tap;
            }
            if (point != null) {
                obj = 1;
            } else {
                obj = null;
            }
            z zVar3 = null;
            if (point != null) {
                z zVar4 = new z(point.x, point.y);
                ab.i("MicroMsg.Voip.CaptureRender", "getCameraSize from table:" + zVar4.width + "," + zVar4.height);
                zVar = zVar4;
            } else {
                zVar = null;
            }
            try {
                CharSequence charSequence;
                Parameters parameters3 = this.mdw.getParameters();
                Point point2 = new Point(i, i2);
                String str = parameters3.get("preview-size-values");
                if (str == null) {
                    charSequence = parameters3.get("preview-size-value");
                } else {
                    Object charSequence2 = str;
                }
                Point point3 = null;
                if (charSequence2 != null) {
                    ab.i("MicroMsg.Voip.CaptureRender", "preview-size-values parameter: ".concat(String.valueOf(charSequence2)));
                    point3 = a(charSequence2, point2);
                }
                if (point3 == null) {
                    point3 = new Point((point2.x >> 3) << 3, (point2.y >> 3) << 3);
                }
                zVar2 = new z(point3.x, point3.y);
                try {
                    ab.i("MicroMsg.Voip.CaptureRender", "getCameraResolution:" + zVar2.width + "," + zVar2.height);
                } catch (Exception e3) {
                    e22 = e3;
                    zVar3 = zVar2;
                    ab.e("MicroMsg.Voip.CaptureRender", "getCameraResolution failed: %s", e22.getMessage());
                    zVar2 = zVar3;
                    if (obj != null) {
                    }
                    c(this.mdw, this.sZn);
                    this.sZv = this.mdw.getParameters();
                    previewSize = this.sZv.getPreviewSize();
                    if (previewSize != null) {
                    }
                    previewFrameRate = this.sZv.getPreviewFrameRate();
                    this.sZx = j.tbw;
                    if (this.sZx <= 0) {
                    }
                    try {
                        tVar = this.mdw;
                        cameraInfo = new CameraInfo();
                        if (this.sZn) {
                        }
                        Camera.getCameraInfo(this.sZn ? j.tbs : j.tbt, cameraInfo);
                        min = 0;
                        switch (((WindowManager) ah.getContext().getSystemService("window")).getDefaultDisplay().getRotation()) {
                            case 0:
                                break;
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                        }
                        if (this.sZn) {
                        }
                        tVar.setDisplayOrientation(min);
                        this.sZK = min;
                    } catch (Exception e222) {
                        ab.e("MicroMsg.Voip.CaptureRender", "setDisplayOrientation failed: %s", e222.getMessage());
                    }
                    ab.i("MicroMsg.Voip.CaptureRender", "Camera ok, fps: %d, mSize.width: %d, mSize.height: %d, format: %d, IsRotate180: %d, displayOrientation: %d", Integer.valueOf(previewFrameRate), Integer.valueOf(this.sZw.width), Integer.valueOf(this.sZw.height), Integer.valueOf(this.sZx), Integer.valueOf(j.tbu), Integer.valueOf(this.sZK));
                    AppMethodBeat.o(5034);
                    return 1;
                }
            } catch (Exception e4) {
                e222 = e4;
                ab.e("MicroMsg.Voip.CaptureRender", "getCameraResolution failed: %s", e222.getMessage());
                zVar2 = zVar3;
                if (obj != null) {
                }
                c(this.mdw, this.sZn);
                this.sZv = this.mdw.getParameters();
                previewSize = this.sZv.getPreviewSize();
                if (previewSize != null) {
                }
                previewFrameRate = this.sZv.getPreviewFrameRate();
                this.sZx = j.tbw;
                if (this.sZx <= 0) {
                }
                tVar = this.mdw;
                cameraInfo = new CameraInfo();
                if (this.sZn) {
                }
                Camera.getCameraInfo(this.sZn ? j.tbs : j.tbt, cameraInfo);
                min = 0;
                switch (((WindowManager) ah.getContext().getSystemService("window")).getDefaultDisplay().getRotation()) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                }
                if (this.sZn) {
                }
                tVar.setDisplayOrientation(min);
                this.sZK = min;
                ab.i("MicroMsg.Voip.CaptureRender", "Camera ok, fps: %d, mSize.width: %d, mSize.height: %d, format: %d, IsRotate180: %d, displayOrientation: %d", Integer.valueOf(previewFrameRate), Integer.valueOf(this.sZw.width), Integer.valueOf(this.sZw.height), Integer.valueOf(this.sZx), Integer.valueOf(j.tbu), Integer.valueOf(this.sZK));
                AppMethodBeat.o(5034);
                return 1;
            }
            if (obj != null) {
                z2 = a(this.mdw, zVar.width, zVar.height);
                ab.i("MicroMsg.Voip.CaptureRender", "1.try config size first! w" + zVar.width + ",h" + zVar.height);
                if (!(z2 || zVar2 == null)) {
                    ab.e("MicroMsg.Voip.CaptureRender", "1.try config size failed!,try support size: w" + zVar2.width + ",h" + zVar2.height);
                    if (!a(this.mdw, zVar2.width, zVar2.height)) {
                        ab.e("MicroMsg.Voip.CaptureRender", "1.try support size fail: w" + zVar2.width + ",h" + zVar2.height);
                        AppMethodBeat.o(5034);
                        return -1;
                    }
                }
            }
            ab.i("MicroMsg.Voip.CaptureRender", "2.no config size!");
            if (zVar2 != null) {
                ab.i("MicroMsg.Voip.CaptureRender", "2.try support size alternatively! w" + zVar2.width + ",h" + zVar2.height);
                if (!a(this.mdw, zVar2.width, zVar2.height)) {
                    ab.e("MicroMsg.Voip.CaptureRender", "2.try support size fail: w" + zVar2.width + ",h" + zVar2.height);
                    AppMethodBeat.o(5034);
                    return -1;
                }
            }
            c(this.mdw, this.sZn);
            try {
                this.sZv = this.mdw.getParameters();
                previewSize = this.sZv.getPreviewSize();
                if (previewSize != null) {
                    this.sZw = new z(previewSize.width, previewSize.height);
                }
                previewFrameRate = this.sZv.getPreviewFrameRate();
                this.sZx = j.tbw;
                if (this.sZx <= 0) {
                    this.sZx = 7;
                }
                tVar = this.mdw;
                cameraInfo = new CameraInfo();
                Camera.getCameraInfo(this.sZn ? j.tbs : j.tbt, cameraInfo);
                min = 0;
                switch (((WindowManager) ah.getContext().getSystemService("window")).getDefaultDisplay().getRotation()) {
                    case 0:
                        min = 0;
                        break;
                    case 1:
                        min = 90;
                        break;
                    case 2:
                        min = 180;
                        break;
                    case 3:
                        min = 270;
                        break;
                }
                if (this.sZn) {
                    min = (360 - ((min + cameraInfo.orientation) % v2helper.VOIP_ENC_HEIGHT_LV1)) % v2helper.VOIP_ENC_HEIGHT_LV1;
                } else {
                    min = ((cameraInfo.orientation - min) + v2helper.VOIP_ENC_HEIGHT_LV1) % v2helper.VOIP_ENC_HEIGHT_LV1;
                }
                tVar.setDisplayOrientation(min);
                this.sZK = min;
                ab.i("MicroMsg.Voip.CaptureRender", "Camera ok, fps: %d, mSize.width: %d, mSize.height: %d, format: %d, IsRotate180: %d, displayOrientation: %d", Integer.valueOf(previewFrameRate), Integer.valueOf(this.sZw.width), Integer.valueOf(this.sZw.height), Integer.valueOf(this.sZx), Integer.valueOf(j.tbu), Integer.valueOf(this.sZK));
                AppMethodBeat.o(5034);
                return 1;
            } catch (Exception e2222) {
                h.pYm.a(159, 0, 1, false);
                ab.e("MicroMsg.Voip.CaptureRender", "try getParameters and getPreviewSize fail, error:%s", e2222.getMessage());
                AppMethodBeat.o(5034);
                return -1;
            }
        } catch (Exception e22222) {
            h.pYm.a(159, 0, 1, false);
            ab.e("MicroMsg.Voip.CaptureRender", "Camera open failed, error:%s", e22222.getMessage());
            if (this.sZD != null) {
                try {
                    this.sZD.bSo();
                    this.sZO = true;
                    this.mdw.setPreviewCallback(null);
                    this.mdw.stopPreview();
                    this.mdw.release();
                    this.mdw = null;
                } catch (Exception e5) {
                    ab.printErrStackTrace("MicroMsg.Voip.CaptureRender", e5, "Camera open failed2, error:%s", e22222.getMessage());
                }
            }
            AppMethodBeat.o(5034);
            return -1;
        }
    }

    public final void cLB() {
        AppMethodBeat.i(ReaderCallback.READER_PLUGIN_COMMAND_PPT_PLAYER);
        if (j.tbr.eqQ < 2) {
            ab.e("MicroMsg.Voip.CaptureRender", "ExchangeCapture...gCameraNum= " + j.tbr.eqQ);
            AppMethodBeat.o(ReaderCallback.READER_PLUGIN_COMMAND_PPT_PLAYER);
            return;
        }
        ab.i("MicroMsg.Voip.CaptureRender", "ExchangeCapture start, gCameraNum= " + j.tbr.eqQ);
        cLD();
        a(this.sZD, !this.sZn);
        cLC();
        com.tencent.mm.plugin.voip.b.cIj().Gw(this.sZu);
        this.sZJ = true;
        AppMethodBeat.o(ReaderCallback.READER_PLUGIN_COMMAND_PPT_PLAYER);
    }

    public final int cLC() {
        Exception exception;
        AppMethodBeat.i(ReaderCallback.READER_PLUGIN_COMMAND_PDF_LIST);
        if (!this.sZy) {
            ab.e("MicroMsg.Voip.CaptureRender", "StartCapture: failed without open camera");
            this.sZu = 1;
            AppMethodBeat.o(ReaderCallback.READER_PLUGIN_COMMAND_PDF_LIST);
            return -1;
        } else if (this.sZE) {
            ab.e("MicroMsg.Voip.CaptureRender", "StartCapture: is in capture already ");
            AppMethodBeat.o(ReaderCallback.READER_PLUGIN_COMMAND_PDF_LIST);
            return -1;
        } else if (this.sZB == null || this.sZB.cHK()) {
            ab.d("MicroMsg.Voip.CaptureRender", "StartCapture now, isUesSurfacePreivew: %b", Boolean.valueOf(this.sZA));
            if (this.sZB != null && this.sZA) {
                try {
                    this.mdw.setPreviewDisplay(this.sZB.getSurfaceHolder());
                } catch (Exception e) {
                    exception = e;
                    h.pYm.a(159, 0, 1, false);
                    h.pYm.a(159, 2, 1, false);
                    this.sZu = 1;
                    ab.e("MicroMsg.Voip.CaptureRender", "StartCapture:error:" + exception.toString());
                }
            } else if (!(this.sZC == null || this.sZA)) {
                try {
                    this.mdw.setPreviewTexture(this.sZC.getSurfaceTexture());
                } catch (Exception e2) {
                    exception = e2;
                    h.pYm.a(159, 0, 1, false);
                    h.pYm.a(159, 2, 1, false);
                    this.sZu = 1;
                    ab.e("MicroMsg.Voip.CaptureRender", "StartCapture:error:" + exception.toString());
                }
            }
            try {
                this.mdw.startPreview();
                this.mdx = true;
            } catch (Exception e22) {
                exception = e22;
                h.pYm.a(159, 0, 1, false);
                h.pYm.a(159, 2, 1, false);
                this.sZu = 1;
                if (this.sZD != null) {
                    this.sZD.bSo();
                }
                ab.e("MicroMsg.Voip.CaptureRender", "startPreview:error" + exception.toString());
            }
            this.sZE = true;
            AppMethodBeat.o(ReaderCallback.READER_PLUGIN_COMMAND_PDF_LIST);
            return 1;
        } else {
            ab.d("MicroMsg.Voip.CaptureRender", "StartCapture:surface not ready, try later.... ");
            this.sZF = true;
            AppMethodBeat.o(ReaderCallback.READER_PLUGIN_COMMAND_PDF_LIST);
            return 0;
        }
    }

    public final void cLD() {
        AppMethodBeat.i(5037);
        ab.d("MicroMsg.Voip.CaptureRender", "StopCapture....mIsInCapture = " + this.sZE);
        if (this.sZE && this.mdw != null) {
            this.sZF = false;
            this.mdw.setPreviewCallback(null);
            try {
                this.mdw.stopPreview();
                this.mdx = false;
            } catch (Exception e) {
                ab.e("MicroMsg.Voip.CaptureRender", "stopPreview:error" + e.toString());
            }
            this.sZE = false;
        }
        if (1 == this.sZu) {
            mi miVar = new mi();
            miVar.cIm.type = 2;
            com.tencent.mm.sdk.b.a.xxA.m(miVar);
        }
        ab.d("MicroMsg.Voip.CaptureRender", "UnInitCapture....mCameraOpen = " + this.sZy);
        if (this.sZy) {
            this.sZu = 0;
            this.sZF = false;
            if (this.mdw != null) {
                this.mdw.setPreviewCallback(null);
                this.mdw.release();
            }
            this.mdw = null;
            this.sZy = false;
        } else if (this.mdw != null) {
            this.mdw.setPreviewCallback(null);
            this.mdw.release();
            this.mdw = null;
            this.sZy = false;
        }
        this.sZG = null;
        if (this.sZI != null) {
            this.sZI.clear();
        }
        this.sZI = null;
        this.sZz = false;
        AppMethodBeat.o(5037);
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x017a A:{Catch:{ Exception -> 0x020b }} */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x019c A:{Catch:{ Exception -> 0x020b }} */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01c7 A:{Catch:{ Exception -> 0x020b }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @TargetApi(14)
    public final void y(int[] iArr) {
        boolean z = true;
        AppMethodBeat.i(ReaderCallback.READER_PLUGIN_COMMAND_TEXT_FIND);
        if (q.etc.ery == 1 && this.sZz) {
            AppMethodBeat.o(ReaderCallback.READER_PLUGIN_COMMAND_TEXT_FIND);
            return;
        }
        if (q.etc.erx > 2000) {
            this.sZt = (long) q.etc.erx;
        }
        boolean z2;
        boolean z3;
        if (iArr == null) {
            ab.e("MicroMsg.Voip.CaptureRender", "focusOnFace error, faceLocation is null");
            z2 = System.currentTimeMillis() - this.sZs > this.sZt;
            if (!(this.sZp && !z2 && this.sZq == this.sZn)) {
                String str = "MicroMsg.Voip.CaptureRender";
                StringBuilder stringBuilder = new StringBuilder("now i need autoFocus! and !mIsCameraNoParamAutoFocus: ");
                if (this.sZp) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                StringBuilder append = stringBuilder.append(z3).append(",isAutoFocusTimeout: ").append(z2).append(",mAutoFocusTimeOut:").append(this.sZt).append(",mIsLastAutoFocusFaceCamera != mIsCurrentFaceCamera :");
                if (this.sZq == this.sZn) {
                    z = false;
                }
                ab.i(str, append.append(z).append(",isClickScreen :false").toString());
                try {
                    if (!(this.mdw == null || this.mdw.getParameters() == null || this.mdw.getParameters().getFocusMode() == null || !this.mdw.getParameters().getFocusMode().equals("auto"))) {
                        this.mdw.autoFocus(null);
                        this.sZH = null;
                        this.sZs = System.currentTimeMillis();
                        this.sZp = true;
                        this.sZq = this.sZn;
                    }
                    AppMethodBeat.o(ReaderCallback.READER_PLUGIN_COMMAND_TEXT_FIND);
                    return;
                } catch (Exception e) {
                    ab.e("MicroMsg.Voip.CaptureRender", "mCamera.getParameters() or autoFocus fail!" + e.toString());
                }
            }
            AppMethodBeat.o(ReaderCallback.READER_PLUGIN_COMMAND_TEXT_FIND);
            return;
        }
        Rect rect;
        Parameters parameters;
        if (this.sZH == null) {
            this.sZH = iArr;
            z2 = true;
        } else {
            z2 = false;
        }
        int[] iArr2 = this.sZH;
        int abs = Math.abs(iArr2[3] - iArr[3]) + ((Math.abs(iArr2[0] - iArr[0]) + Math.abs(iArr2[1] - iArr[1])) + Math.abs(iArr2[2] - iArr[2]));
        ab.d("MicroMsg.Voip.CaptureRender", "face location diff:%d", Integer.valueOf(abs));
        if (abs > sZm || abs > sZl) {
            this.sZH = iArr;
            if (abs > sZm) {
                z2 = true;
            }
            if (abs > sZl) {
                z3 = true;
                if (z2 || z3) {
                    ArrayList arrayList;
                    rect = new Rect(this.sZH[0], this.sZH[1], this.sZH[2], this.sZH[3]);
                    parameters = this.mdw.getParameters();
                    if (z3) {
                        if (!com.tencent.mm.compatible.util.d.iW(14) || parameters.getMaxNumMeteringAreas() <= 0) {
                            ab.d("MicroMsg.Voip.CaptureRender", "camera not support metering area");
                            z3 = false;
                        } else {
                            arrayList = new ArrayList();
                            arrayList.add(new Area(rect, 1000));
                            parameters.setMeteringAreas(arrayList);
                        }
                    }
                    if (z2) {
                        if (!com.tencent.mm.compatible.util.d.iW(14) || parameters.getMaxNumFocusAreas() <= 0) {
                            ab.d("MicroMsg.Voip.CaptureRender", "camera not support area focus");
                            z2 = false;
                        } else {
                            arrayList = new ArrayList();
                            arrayList.add(new Area(rect, 1000));
                            parameters.setFocusAreas(arrayList);
                        }
                    }
                    if (z2 || r3) {
                        this.mdw.setParameters(parameters);
                    }
                    if (z2) {
                        ab.d("MicroMsg.Voip.CaptureRender", "refocus, mIsFocusOnFace:%b", Boolean.valueOf(this.sZJ));
                        if (this.sZJ) {
                            this.sZp = false;
                            this.sZJ = false;
                            this.mdw.autoFocus(new AutoFocusCallback() {
                                public final void onAutoFocus(boolean z, Camera camera) {
                                    AppMethodBeat.i(ReaderCallback.READER_PLUGIN_RES_ROTATESCREEN_PRESS);
                                    ab.d("MicroMsg.Voip.CaptureRender", "onAutoFocus, success:%b", Boolean.valueOf(z));
                                    a.this.sZJ = true;
                                    AppMethodBeat.o(ReaderCallback.READER_PLUGIN_RES_ROTATESCREEN_PRESS);
                                }
                            });
                        }
                    }
                    AppMethodBeat.o(ReaderCallback.READER_PLUGIN_COMMAND_TEXT_FIND);
                }
                AppMethodBeat.o(ReaderCallback.READER_PLUGIN_COMMAND_TEXT_FIND);
                return;
            }
        }
        z3 = false;
        try {
            rect = new Rect(this.sZH[0], this.sZH[1], this.sZH[2], this.sZH[3]);
            parameters = this.mdw.getParameters();
            if (z3) {
            }
            if (z2) {
            }
            this.mdw.setParameters(parameters);
            if (z2) {
            }
            AppMethodBeat.o(ReaderCallback.READER_PLUGIN_COMMAND_TEXT_FIND);
        } catch (Exception e2) {
            ab.e("MicroMsg.Voip.CaptureRender", "focusOnFace exception:%s", e2.getMessage());
        }
    }

    private int g(t tVar) {
        Throwable e;
        int i;
        AppMethodBeat.i(ReaderCallback.READER_PLUGIN_COMMAND_TEXT_FIND_NEXT);
        if (tVar == null) {
            AppMethodBeat.o(ReaderCallback.READER_PLUGIN_COMMAND_TEXT_FIND_NEXT);
            return 0;
        }
        try {
            int i2;
            List<Size> supportedPreviewSizes = tVar.getParameters().getSupportedPreviewSizes();
            if (supportedPreviewSizes == null || supportedPreviewSizes.size() == 0) {
                i2 = 0;
            } else {
                int i3 = 0;
                for (Size size : supportedPreviewSizes) {
                    try {
                        ab.d("MicroMsg.Voip.CaptureRender", "support Size:" + size.width + "," + size.height);
                        if (i3 == 0) {
                            this.sZL = size.width;
                            this.sZM = size.height;
                        }
                        i3++;
                    } catch (Exception e2) {
                        e = e2;
                        i = i3;
                        ab.printErrStackTrace("MicroMsg.Voip.CaptureRender", e, "", new Object[0]);
                        AppMethodBeat.o(ReaderCallback.READER_PLUGIN_COMMAND_TEXT_FIND_NEXT);
                        return i;
                    }
                }
                i2 = i3;
            }
            try {
                List<Integer> supportedPreviewFormats = tVar.getParameters().getSupportedPreviewFormats();
                if (!(supportedPreviewFormats == null || supportedPreviewFormats.size() == 0)) {
                    for (Integer intValue : supportedPreviewFormats) {
                        ab.i("MicroMsg.Voip.CaptureRender", "support Format:".concat(String.valueOf(intValue.intValue())));
                    }
                }
                i = i2;
            } catch (Exception e3) {
                e = e3;
                i = i2;
                ab.printErrStackTrace("MicroMsg.Voip.CaptureRender", e, "", new Object[0]);
                AppMethodBeat.o(ReaderCallback.READER_PLUGIN_COMMAND_TEXT_FIND_NEXT);
                return i;
            }
        } catch (Exception e22) {
            e = e22;
            i = 0;
            ab.printErrStackTrace("MicroMsg.Voip.CaptureRender", e, "", new Object[0]);
            AppMethodBeat.o(ReaderCallback.READER_PLUGIN_COMMAND_TEXT_FIND_NEXT);
            return i;
        }
        AppMethodBeat.o(ReaderCallback.READER_PLUGIN_COMMAND_TEXT_FIND_NEXT);
        return i;
    }

    private static void h(t tVar) {
        List supportedPreviewFrameRates;
        AppMethodBeat.i(ReaderCallback.READER_PLUGIN_COMMAND_TEXT_FIND_PREV);
        List list = null;
        try {
            supportedPreviewFrameRates = tVar.getParameters().getSupportedPreviewFrameRates();
        } catch (Exception e) {
            ab.d("MicroMsg.Voip.CaptureRender", "getSupportedPreviewFrameRates:error:" + e.toString());
            supportedPreviewFrameRates = list;
        }
        String str = "supportFps:";
        if (supportedPreviewFrameRates != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= supportedPreviewFrameRates.size()) {
                    break;
                }
                str = str + ((Integer) supportedPreviewFrameRates.get(i2)).intValue() + ",";
                i = i2 + 1;
            }
        }
        ab.i("MicroMsg.Voip.CaptureRender", str);
        AppMethodBeat.o(ReaderCallback.READER_PLUGIN_COMMAND_TEXT_FIND_PREV);
    }

    public final boolean cLE() {
        return this.sZn;
    }

    public final boolean cLF() {
        return this.sZo;
    }

    public final int cLG() {
        return this.sZu;
    }
}

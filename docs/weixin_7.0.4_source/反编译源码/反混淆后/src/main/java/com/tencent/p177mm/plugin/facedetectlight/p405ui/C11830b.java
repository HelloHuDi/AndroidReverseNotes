package com.tencent.p177mm.plugin.facedetectlight.p405ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ImageFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Looper;
import android.support.p057v4.widget.C8415j;
import android.view.TextureView.SurfaceTextureListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.p221e.C32468d;
import com.tencent.p177mm.compatible.p221e.C32468d.C32469a.C32470a;
import com.tencent.p177mm.compatible.p221e.C41938t;
import com.tencent.p177mm.memory.C18601a;
import com.tencent.p177mm.p612ui.base.MMTextureView;
import com.tencent.p177mm.plugin.facedetect.model.C20636d;
import com.tencent.p177mm.plugin.facedetect.model.C20636d.C20637b;
import com.tencent.p177mm.plugin.facedetect.model.C27931c;
import com.tencent.p177mm.plugin.facedetect.model.C43036p;
import com.tencent.p177mm.plugin.facedetect.p402e.C27922a;
import com.tencent.p177mm.plugin.facedetectaction.p404ui.FaceActionMask;
import com.tencent.p177mm.plugin.facedetectaction.p404ui.FaceActionUI;
import com.tencent.p177mm.plugin.facedetectaction.p967b.C43048d;
import com.tencent.p177mm.plugin.facedetectaction.p967b.C45922a;
import com.tencent.p177mm.plugin.facedetectaction.p967b.C45922a.C20665a;
import com.tencent.p177mm.plugin.facedetectaction.p967b.C45922a.C27943b;
import com.tencent.p177mm.plugin.facedetectaction.p967b.C45922a.C390291;
import com.tencent.p177mm.plugin.facedetectaction.p967b.C45922a.C459212;
import com.tencent.p177mm.plugin.facedetectlight.p405ui.C11841c.C11840a;
import com.tencent.p177mm.plugin.facedetectlight.p405ui.C11841c.C118451;
import com.tencent.p177mm.plugin.facedetectlight.p405ui.C11841c.C118463;
import com.tencent.p177mm.plugin.facedetectlight.p405ui.p406a.C20669b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import com.tencent.youtu.ytfacetrace.YTFaceTraceInterface;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.facedetectlight.ui.b */
public final class C11830b implements SurfaceTextureListener {
    public String edV;
    private Bitmap faceBitmap;
    private C32470a fbb;
    private boolean isFrontCamera;
    private Point lUF;
    private Point lUG;
    private Point lUH;
    private boolean lUI;
    private int lUJ;
    private Point lUM;
    public byte[] lWX;
    public boolean lXB;
    public String mAppId;
    private Context mContext;
    int mDesiredPreviewHeight;
    int mDesiredPreviewWidth;
    private boolean mIsCameraOpened;
    private PreviewCallback man;
    C20637b mao;
    public int mbW;
    public String mbX;
    private FaceActionUI mbY;
    public FaceActionMask mcP;
    private C20665a mca;
    public PreviewFrameLayout mdA;
    private int mdB;
    public String mdC;
    public ImageView mdD;
    public ImageView mdE;
    private boolean mdF;
    private int mdG;
    private C5004al mdH;
    private C20669b mdI;
    private MMTextureView mdt;
    private HandlerThread mdu;
    private C7306ak mdv;
    public C41938t mdw;
    public boolean mdx;
    public TextView mdy;
    public FaceReflectMask mdz;

    /* renamed from: com.tencent.mm.plugin.facedetectlight.ui.b$8 */
    class C30648 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.facedetectlight.ui.b$8$1 */
        class C30651 implements Runnable {
            C30651() {
            }

            public final void run() {
                AppMethodBeat.m2504i(767);
                C11830b.this.mdD.setImageBitmap(C11830b.this.faceBitmap);
                AppMethodBeat.m2505o(767);
            }
        }

        C30648() {
        }

        public final void run() {
            AppMethodBeat.m2504i(768);
            C11830b c11830b = C11830b.this;
            C4996ah.getContext();
            c11830b.faceBitmap = C43036p.m76433n(C11830b.this.edV, C11830b.this.faceBitmap);
            C5004al.m7441d(new C30651());
            AppMethodBeat.m2505o(768);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetectlight.ui.b$9 */
    class C30669 implements PreviewCallback {
        final /* synthetic */ PreviewCallback lUN;

        /* renamed from: com.tencent.mm.plugin.facedetectlight.ui.b$9$1 */
        class C30671 implements Runnable {
            C30671() {
            }

            public final void run() {
                AppMethodBeat.m2504i(769);
                C11830b.this.mdt.setAlpha(1.0f);
                AppMethodBeat.m2505o(769);
            }
        }

        C30669(PreviewCallback previewCallback) {
            this.lUN = previewCallback;
        }

        public final void onPreviewFrame(byte[] bArr, Camera camera) {
            AppMethodBeat.m2504i(770);
            C5004al.m7441d(new C30671());
            if (this.lUN != null) {
                this.lUN.onPreviewFrame(bArr, camera);
            }
            camera.addCallbackBuffer(bArr);
            AppMethodBeat.m2505o(770);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetectlight.ui.b$10 */
    class C1182710 implements C20637b {
        C1182710() {
        }

        /* renamed from: aT */
        public final void mo7298aT(byte[] bArr) {
            AppMethodBeat.m2504i(771);
            C27931c.lTA.mo45831g(bArr);
            AppMethodBeat.m2505o(771);
        }

        public final C18601a<byte[]> bsr() {
            return C27931c.lTA;
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetectlight.ui.b$1 */
    class C118281 implements Runnable {
        C118281() {
        }

        public final void run() {
            AppMethodBeat.m2504i(758);
            C11830b.this.mdD.setVisibility(8);
            C11830b.this.mdE.setVisibility(8);
            C11830b.this.mdF = true;
            AppMethodBeat.m2505o(758);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetectlight.ui.b$7 */
    class C118297 implements Runnable {
        C118297() {
        }

        public final void run() {
            AppMethodBeat.m2504i(766);
            C11830b.m19706w(C11830b.this);
            AppMethodBeat.m2505o(766);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetectlight.ui.b$2 */
    class C118312 implements PreviewCallback {
        C118312() {
        }

        public final void onPreviewFrame(final byte[] bArr, final Camera camera) {
            AppMethodBeat.m2504i(760);
            C11830b.this.mdH.mo10302aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(759);
                    if (C11830b.this.mdx) {
                        byte[] bArr;
                        Camera camera;
                        if (C11830b.this.mdG == 1) {
                            C11840a.btY();
                            bArr = bArr;
                            camera = camera;
                            if (YTFaceTraceInterface.isTracing()) {
                                YTFaceTraceInterface.onPreviewFrame(bArr, camera);
                            }
                            if (YTAGReflectLiveCheckInterface.getProcessState() == 2) {
                                YTAGReflectLiveCheckInterface.onPreviewFrame(bArr, camera);
                            }
                            C20636d.bsq().mo35922aS(bArr);
                            AppMethodBeat.m2505o(759);
                            return;
                        }
                        C27943b.mcl;
                        bArr = bArr;
                        camera = camera;
                        if (YTFaceTraceInterface.isTracing()) {
                            YTFaceTraceInterface.onPreviewFrame(bArr, camera);
                            AppMethodBeat.m2505o(759);
                            return;
                        } else if (YTAGReflectLiveCheckInterface.getProcessState() == 2) {
                            YTAGReflectLiveCheckInterface.onPreviewFrame(bArr, camera);
                        }
                    }
                    AppMethodBeat.m2505o(759);
                }
            });
            AppMethodBeat.m2505o(760);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetectlight.ui.b$5 */
    class C118335 implements Runnable {
        C118335() {
        }

        public final void run() {
            AppMethodBeat.m2504i(764);
            C11830b.this.btW();
            AppMethodBeat.m2505o(764);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetectlight.ui.b$a */
    static class C11835a implements Comparator<Size> {
        private C11835a() {
        }

        /* synthetic */ C11835a(byte b) {
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

    /* renamed from: com.tencent.mm.plugin.facedetectlight.ui.b$3 */
    class C118363 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.facedetectlight.ui.b$3$1 */
        class C118371 implements Runnable {
            C118371() {
            }

            public final void run() {
                AppMethodBeat.m2504i(761);
                int o;
                int p;
                if (C11830b.this.mdG == 1) {
                    C11841c btY = C11840a.btY();
                    Context f = C11830b.this.mContext;
                    C20669b g = C11830b.this.mdI;
                    C41938t h = C11830b.this.mdw;
                    int i = C11830b.this.mdB;
                    TextView textView = C11830b.this.mdy;
                    FaceReflectMask j = C11830b.this.mdz;
                    byte[] k = C11830b.this.lWX;
                    String l = C11830b.this.mdC;
                    String m = C11830b.this.mAppId;
                    int n = C11830b.this.lUJ;
                    o = C11830b.this.mDesiredPreviewWidth;
                    p = C11830b.this.mDesiredPreviewHeight;
                    Point q = C11830b.this.lUM;
                    C4990ab.m7416i("MicroMsg.FaceReflectLogic", "initPreviewDetect（）");
                    btY.mContext = f;
                    btY.mdw = h;
                    btY.hGq = i;
                    btY.mbZ = textView;
                    btY.mdI = g;
                    btY.mdz = j;
                    btY.mdQ = n;
                    btY.mDesiredPreviewWidth = o;
                    btY.mDesiredPreviewHeight = p;
                    btY.mdR = q;
                    btY.lWX = k;
                    btY.mdC = l;
                    btY.mAppId = m;
                    C4990ab.m7416i("MicroMsg.FaceReflectLogic", "mConfig is ".concat(String.valueOf(k)));
                    C4990ab.m7416i("MicroMsg.FaceReflectLogic", "mBioID is " + btY.mdC);
                    C4990ab.m7416i("MicroMsg.FaceReflectLogic", "mAppId is ".concat(String.valueOf(m)));
                    btY.mcb = new Rect(0, 0, 0, 0);
                    btY.mcc = new Rect(0, 0, 0, 0);
                    btY.mch = new C118451(btY);
                    if (C27922a.btw().lZc) {
                        C27922a.btw().mo45818a(btY.mdQ, btY.mDesiredPreviewWidth, btY.mDesiredPreviewHeight, btY.mdR.x, btY.mDesiredPreviewHeight, false);
                    }
                    C11841c btY2 = C11840a.btY();
                    C4990ab.m7416i("MicroMsg.FaceReflectLogic", "initFaceDetect（）");
                    try {
                        YTFaceTraceInterface.start(btY2.mContext, btY2.mdw.etv, btY2.hGq, new C118463(btY2), btY2.mch);
                        AppMethodBeat.m2505o(761);
                        return;
                    } catch (Exception e) {
                        C4990ab.m7417i("MicroMsg.FaceReflectLogic", "init FaceDetect() failed ：%s ", e.getMessage());
                        AppMethodBeat.m2505o(761);
                        return;
                    }
                }
                C45922a btO = C27943b.mcl;
                Context applicationContext = C11830b.this.mbY.getApplicationContext();
                FaceActionUI r = C11830b.this.mbY;
                Camera camera = C11830b.this.mdw.etv;
                int i2 = C11830b.this.mdB;
                TextView textView2 = C11830b.this.mdy;
                C20665a s = C11830b.this.mca;
                int n2 = C11830b.this.lUJ;
                Point point = new Point(C11830b.this.mDesiredPreviewWidth, C11830b.this.mDesiredPreviewHeight);
                int t = C11830b.this.mbW;
                String u = C11830b.this.mbX;
                o = C11830b.this.mDesiredPreviewWidth;
                p = C11830b.this.mDesiredPreviewHeight;
                C4990ab.m7416i("MicroMsg.FaceActionLogic", "initFaceDetect（）");
                btO.mContext = applicationContext;
                btO.mCamera = camera;
                btO.hGq = i2;
                btO.mbZ = textView2;
                btO.mbY = r;
                btO.mca = s;
                btO.mbW = t;
                btO.mbX = u;
                btO.mDesiredPreviewWidth = o;
                btO.mDesiredPreviewHeight = p;
                btO.mcb = new Rect(0, 0, 0, 0);
                btO.mcc = new Rect(0, 0, 0, 0);
                btO.mch = new C390291();
                btO.mci = new C459212();
                try {
                    YTFaceTraceInterface.start(btO.mContext, btO.mCamera, btO.hGq, btO.mci, btO.mch);
                } catch (Exception e2) {
                    C4990ab.m7417i("MicroMsg.FaceActionLogic", "init FaceDetect() failed ：%s ", e2.getMessage());
                }
                C4990ab.m7417i("MicroMsg.FaceActionLogic", "init face detect, camera, rotate: %s", Integer.valueOf(n2));
                C43048d.mcq.fcR = n2;
                C43048d c43048d = C43048d.mcq;
                int i3 = point.x;
                int i4 = point.y;
                c43048d.mcz = i3;
                c43048d.mcA = i4;
                AppMethodBeat.m2505o(761);
            }
        }

        C118363() {
        }

        public final void run() {
            AppMethodBeat.m2504i(762);
            if (!C11830b.m19685d(C11830b.this)) {
                C7060h.pYm.mo8378a(917, C11830b.this.mdG == 1 ? 3 : 39, 1, false);
                C11830b.m19685d(C11830b.this);
            }
            C7060h.pYm.mo8378a(917, C11830b.this.mdG == 1 ? 2 : 38, 1, false);
            C5004al.m7441d(new C118371());
            AppMethodBeat.m2505o(762);
        }
    }

    /* renamed from: d */
    static /* synthetic */ boolean m19685d(C11830b c11830b) {
        AppMethodBeat.m2504i(785);
        boolean btV = c11830b.btV();
        AppMethodBeat.m2505o(785);
        return btV;
    }

    public C11830b(Context context, C20669b c20669b) {
        AppMethodBeat.m2504i(772);
        this.lUF = null;
        this.lUG = null;
        this.lUH = null;
        this.lUM = null;
        this.mdB = 0;
        this.mdH = new C5004al("mPreviewHandlerThread");
        this.mao = new C1182710();
        this.man = new C118312();
        this.mdI = c20669b;
        this.mdG = 1;
        this.mContext = context;
        this.mIsCameraOpened = false;
        this.lXB = false;
        this.mdu = null;
        this.mIsCameraOpened = false;
        AppMethodBeat.m2505o(772);
    }

    public C11830b(FaceActionUI faceActionUI, C20665a c20665a) {
        AppMethodBeat.m2504i(773);
        this.lUF = null;
        this.lUG = null;
        this.lUH = null;
        this.lUM = null;
        this.mdB = 0;
        this.mdH = new C5004al("mPreviewHandlerThread");
        this.mao = new C1182710();
        this.man = new C118312();
        this.mdG = 2;
        this.mbY = faceActionUI;
        this.mIsCameraOpened = false;
        this.lXB = false;
        this.mdu = null;
        this.mIsCameraOpened = false;
        this.mdF = false;
        this.mca = c20665a;
        AppMethodBeat.m2505o(773);
    }

    /* renamed from: a */
    public final void mo23643a(MMTextureView mMTextureView) {
        AppMethodBeat.m2504i(774);
        this.mdt = mMTextureView;
        if (this.mdt.isAvailable()) {
            m19690g(mMTextureView.getSurfaceTexture());
        }
        this.mdt.setSurfaceTextureListener(this);
        this.mdt.setVisibility(0);
        this.mdt.setAlpha(0.0f);
        if (this.mdG == 2 && !this.mdF) {
            C5004al.m7442n(new C118281(), 700);
        }
        AppMethodBeat.m2505o(774);
    }

    /* renamed from: g */
    private void m19690g(final SurfaceTexture surfaceTexture) {
        AppMethodBeat.m2504i(775);
        C4990ab.m7416i("MicroMsg.FaceReflectCam", "openCameraForSurfaceTexture");
        if (this.mdG == 1) {
            this.mdz.setVisibility(0);
        } else {
            this.mcP.setVisibility(0);
        }
        btX();
        if (this.mdv != null) {
            this.mdv.post(new C118363());
            this.mdv.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(763);
                    try {
                        C11830b.m19681a(C11830b.this, surfaceTexture);
                        C11830b c11830b = C11830b.this;
                        PreviewCallback v = C11830b.this.man;
                        if (c11830b.mdw == null) {
                            C4990ab.m7420w("MicroMsg.FaceReflectCam", "hy: camera is null. setPreviewCallback failed");
                            AppMethodBeat.m2505o(763);
                            return;
                        }
                        int bitsPerPixel = ((c11830b.mDesiredPreviewWidth * c11830b.mDesiredPreviewHeight) * ImageFormat.getBitsPerPixel(c11830b.mdw.getParameters().getPreviewFormat())) / 8;
                        for (int i = 0; i < 5; i++) {
                            c11830b.mdw.addCallbackBuffer(C27931c.lTA.mo45832g(Integer.valueOf(bitsPerPixel)));
                        }
                        c11830b.mdw.setPreviewCallbackWithBuffer(new C30669(v));
                        C20636d.bsq().mo35921a(c11830b.mao);
                        AppMethodBeat.m2505o(763);
                    } catch (Exception e) {
                        if (C11830b.this.mdG == 1) {
                            C11830b.this.mdI.mo35972u(90016, "preview error", C4996ah.getContext().getString(C25738R.string.er5));
                            AppMethodBeat.m2505o(763);
                            return;
                        }
                        C4990ab.m7416i("MicroMsg.FaceReflectCam", "preview error");
                        AppMethodBeat.m2505o(763);
                    }
                }
            });
            AppMethodBeat.m2505o(775);
            return;
        }
        C4990ab.m7416i("MicroMsg.FaceReflectCam", "back thread is not running");
        AppMethodBeat.m2505o(775);
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        AppMethodBeat.m2504i(776);
        C4990ab.m7416i("MicroMsg.FaceReflectCam", "surfaceDestroyed");
        if (this.mdv != null) {
            this.mdv.post(new C118335());
            if (this.mdu != null) {
                C4990ab.m7416i("MicroMsg.FaceReflectCam", "stop camera thread");
                try {
                    Thread.sleep(500, 0);
                } catch (InterruptedException e) {
                    C4990ab.m7416i("MicroMsg.FaceReflectCam", "background thread sleep error：" + e.getMessage());
                }
                if (VERSION.SDK_INT >= 18) {
                    this.mdu.quitSafely();
                } else {
                    this.mdu.quit();
                }
                try {
                    this.mdu.join();
                    this.mdu = null;
                    this.mdv = null;
                } catch (InterruptedException e2) {
                    C4990ab.m7416i("MicroMsg.FaceReflectCam", "stop background thread error：" + e2.getMessage());
                }
                C4990ab.m7416i("MicroMsg.FaceReflectCam", "stop camera thread finish");
            }
        } else {
            C4990ab.m7416i("MicroMsg.FaceReflectCam", "back thread is not running");
        }
        AppMethodBeat.m2505o(776);
        return false;
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.m2504i(777);
        C4990ab.m7417i("MicroMsg.FaceReflectCam", "onSurfaceTextureAvailable, width: %s, height: %s", Integer.valueOf(i), Integer.valueOf(i2));
        m19690g(surfaceTexture);
        AppMethodBeat.m2505o(777);
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x026f  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x037b  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x028f  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0296  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x03ae  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x02ce  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x02ff  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean btV() {
        AppMethodBeat.m2504i(778);
        C4990ab.m7416i("MicroMsg.FaceReflectCam", "start open camera");
        this.mIsCameraOpened = false;
        this.isFrontCamera = true;
        int numberOfCameras = Camera.getNumberOfCameras();
        int i = 0;
        while (i < numberOfCameras) {
            CameraInfo cameraInfo = new CameraInfo();
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing != 1 || !this.isFrontCamera) {
                if (cameraInfo.facing == 0 && !this.isFrontCamera) {
                    C4990ab.m7410d("MicroMsg.FaceReflectCam", "hy: front Camera found");
                    break;
                }
                i++;
            } else {
                C4990ab.m7410d("MicroMsg.FaceReflectCam", "hy: front Camera found");
                break;
            }
        }
        i = -1;
        long yz = C5046bo.m7588yz();
        C4990ab.m7416i("MicroMsg.FaceReflectCam", "openCameraRes：" + this.fbb);
        if (this.fbb == null) {
            C4990ab.m7416i("MicroMsg.FaceReflectCam", "openCameraRes is null");
            if (this.mdG == 1) {
                C4990ab.m7416i("MicroMsg.FaceReflectCam", "mFaceReflectController openCameraRe");
                this.fbb = C32468d.m53155a(this.mContext, i, null);
            } else {
                C4990ab.m7416i("MicroMsg.FaceReflectCam", "mFaceActionUI openCameraRe");
                this.fbb = C32468d.m53155a(this.mbY.mController.ylL, i, null);
            }
        }
        IOException iOException;
        if (this.fbb == null) {
            C4990ab.m7416i("MicroMsg.FaceReflectCam", "in open(), openCameraRes == null");
            try {
                iOException = new IOException();
                AppMethodBeat.m2505o(778);
                throw iOException;
            } catch (IOException iOException2) {
                C4990ab.m7416i("MicroMsg.FaceReflectCam", "set cameraRes exception" + iOException2.getMessage());
                AppMethodBeat.m2505o(778);
                return false;
            }
        }
        this.mdB = i;
        this.mIsCameraOpened = true;
        C4990ab.m7411d("MicroMsg.FaceReflectCam", "openCamera done, cameraId=[%s] costTime=[%s]", Integer.valueOf(i), Long.valueOf(C5046bo.m7525az(yz)));
        this.lUJ = this.fbb.rotate;
        this.lUI = this.fbb.rotate % 180 != 0;
        this.mdw = this.fbb.erH;
        if (this.mdw == null) {
            C4990ab.m7413e("MicroMsg.FaceReflectCam", "in open(), camera == null, bNeedRotate=[%s]", Boolean.valueOf(this.lUI));
            try {
                iOException2 = new IOException();
                AppMethodBeat.m2505o(778);
                throw iOException2;
            } catch (IOException iOException22) {
                C4990ab.m7416i("MicroMsg.FaceReflectCam", "set cameraRotation exception" + iOException22.getMessage());
            }
        }
        try {
            int i2;
            Point a;
            Parameters parameters = this.mdw.getParameters();
            if (this.mdG == 1) {
                i2 = this.mContext.getResources().getDisplayMetrics().widthPixels;
                i = this.mContext.getResources().getDisplayMetrics().heightPixels;
            } else {
                i2 = this.mbY.getResources().getDisplayMetrics().widthPixels;
                i = this.mbY.getResources().getDisplayMetrics().heightPixels;
            }
            this.lUG = new Point(i2, i);
            Point point = this.lUG;
            Point point2 = this.lUH;
            Object obj = parameters.get("preview-size-values");
            if (obj == null) {
                obj = parameters.get("preview-size-value");
            }
            if (obj != null) {
                C4990ab.m7410d("MicroMsg.FaceReflectCam", "preview-size-values parameter: ".concat(String.valueOf(obj)));
                a = C11830b.m19679a(parameters, point);
            } else {
                a = null;
            }
            if (a == null) {
                a = new Point((point2.x >> 3) << 3, (point2.y >> 3) << 3);
            }
            this.lUF = a;
            this.lUM = new Point(this.lUF);
            C4990ab.m7410d("MicroMsg.FaceReflectCam", "getCameraResolution: " + this.lUG + " camera:" + this.lUF + "bestVideoEncodeSize: " + this.lUM);
            this.mDesiredPreviewWidth = this.lUF.x;
            this.mDesiredPreviewHeight = this.lUF.y;
            parameters.setPreviewSize(this.mDesiredPreviewWidth, this.mDesiredPreviewHeight);
            C4990ab.m7412e("MicroMsg.FaceReflectCam", "mDesiredPreviewWidth：" + this.mDesiredPreviewWidth);
            C4990ab.m7412e("MicroMsg.FaceReflectCam", "mDesiredPreviewHeight：" + this.mDesiredPreviewHeight);
            parameters.setZoom(0);
            parameters.setSceneMode("auto");
            try {
                List<Integer> supportedPreviewFormats;
                boolean z;
                boolean z2;
                double d;
                final double d2;
                List supportedPreviewFpsRange;
                int i3;
                boolean z3;
                if (parameters.getSupportedFocusModes() == null || !parameters.getSupportedFocusModes().contains("auto")) {
                    C4990ab.m7416i("MicroMsg.FaceReflectCam", "camera not support FOCUS_MODE_AUTO");
                    supportedPreviewFormats = parameters.getSupportedPreviewFormats();
                    z = false;
                    for (Integer intValue : supportedPreviewFormats) {
                        i = intValue.intValue();
                        C4990ab.m7410d("MicroMsg.FaceReflectCam", "supportedPreviewFormat: ".concat(String.valueOf(i)));
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
                        C4990ab.m7412e("MicroMsg.FaceReflectCam", "Preview not support PixelFormat.YCbCr_420_SP, but hasYU12");
                        parameters.setPreviewFormat(842094169);
                    } else {
                        C4990ab.m7413e("MicroMsg.FaceReflectCam", "Preview not support PixelFormat.YCbCr_420_SP. Use format: %s", supportedPreviewFormats.get(0));
                        parameters.setPreviewFormat(((Integer) supportedPreviewFormats.get(0)).intValue());
                    }
                    if (this.lUI) {
                        parameters.setRotation(this.lUJ);
                    }
                    d = this.mdA.getmAspectRatio();
                    C4990ab.m7410d("MicroMsg.FaceReflectCam", "original ratio=".concat(String.valueOf(d)));
                    d2 = ((double) this.mDesiredPreviewWidth) / ((double) this.mDesiredPreviewHeight);
                    C4990ab.m7410d("MicroMsg.FaceReflectCam", "new ratio=".concat(String.valueOf(d2)));
                    if (d != d2) {
                        C4990ab.m7410d("MicroMsg.FaceReflectCam", "NO NEED reset ratio");
                    } else {
                        C4990ab.m7410d("MicroMsg.FaceReflectCam", "start reset ratio");
                        C5004al.m7441d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(765);
                                C4990ab.m7410d("MicroMsg.FaceReflectCam", "reset ratio");
                                LayoutParams layoutParams = (LayoutParams) C11830b.this.mdA.getLayoutParams();
                                layoutParams.width = (int) (((double) C11830b.this.mdA.getContext().getResources().getDisplayMetrics().widthPixels) * 0.7d);
                                layoutParams.height = (int) (((double) layoutParams.width) * d2);
                                layoutParams.addRule(13, -1);
                                C11830b.this.mdA.setLayoutParams(layoutParams);
                                C11830b.this.mdA.setAspectRatio(d2);
                                C4990ab.m7410d("MicroMsg.FaceReflectCam", "after reset ratio=" + C11830b.this.mdA.getmAspectRatio());
                                AppMethodBeat.m2505o(765);
                            }
                        });
                    }
                    C11830b.m19683b(parameters);
                    supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
                    C4990ab.m7410d("MicroMsg.FaceReflectCam", "range:" + supportedPreviewFpsRange.size());
                    for (i3 = 0; i3 < supportedPreviewFpsRange.size(); i3++) {
                        int[] iArr = (int[]) supportedPreviewFpsRange.get(i3);
                        for (i2 = 0; i2 < iArr.length; i2++) {
                            C4990ab.m7417i("MicroMsg.FaceReflectCam", "Camera SupportedPreviewFpsRange：", Integer.valueOf(iArr[i2]));
                        }
                    }
                    C4990ab.m7416i("MicroMsg.FaceReflectCam", "Camera preview-fps-range：" + parameters.get("preview-fps-range"));
                    C4990ab.m7416i("MicroMsg.FaceReflectCam", "Camera preview-fps-range：" + parameters.get("preview-frame-rate"));
                    this.mdw.setParameters(parameters);
                    z3 = this.mIsCameraOpened;
                    AppMethodBeat.m2505o(778);
                    return z3;
                }
                C4990ab.m7416i("MicroMsg.FaceReflectCam", "set FocusMode to FOCUS_MODE_AUTO");
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
                d = this.mdA.getmAspectRatio();
                C4990ab.m7410d("MicroMsg.FaceReflectCam", "original ratio=".concat(String.valueOf(d)));
                d2 = ((double) this.mDesiredPreviewWidth) / ((double) this.mDesiredPreviewHeight);
                C4990ab.m7410d("MicroMsg.FaceReflectCam", "new ratio=".concat(String.valueOf(d2)));
                if (d != d2) {
                }
                C11830b.m19683b(parameters);
                supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
                C4990ab.m7410d("MicroMsg.FaceReflectCam", "range:" + supportedPreviewFpsRange.size());
                while (i3 < supportedPreviewFpsRange.size()) {
                }
                C4990ab.m7416i("MicroMsg.FaceReflectCam", "Camera preview-fps-range：" + parameters.get("preview-fps-range"));
                C4990ab.m7416i("MicroMsg.FaceReflectCam", "Camera preview-fps-range：" + parameters.get("preview-frame-rate"));
                this.mdw.setParameters(parameters);
                z3 = this.mIsCameraOpened;
                AppMethodBeat.m2505o(778);
                return z3;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.FaceReflectCam", "set focus mode error: %s", e.getMessage());
            }
        } catch (Exception e2) {
            C4990ab.printErrStackTrace("MicroMsg.FaceReflectCam", e2, "camera getParameters error: %s", e2.getMessage());
            AppMethodBeat.m2505o(778);
            return false;
        }
    }

    public final void stopPreview() {
        AppMethodBeat.m2504i(779);
        C4990ab.m7417i("MicroMsg.FaceReflectCam", "stopPreview, isPreviewing: %s", Boolean.valueOf(this.mdx));
        if (this.mdw != null) {
            this.mdw.stopPreview();
            this.mdx = false;
            C27931c.lTA.mo45830WY();
        }
        AppMethodBeat.m2505o(779);
    }

    public final void btW() {
        AppMethodBeat.m2504i(780);
        C4990ab.m7416i("MicroMsg.FaceReflectCam", "closeCamera start");
        if (this.mdw != null) {
            try {
                if (this.lXB) {
                    this.lXB = false;
                    this.mdw.stopPreview();
                    this.mdw.setPreviewCallback(null);
                    C4990ab.m7416i("MicroMsg.FaceReflectCam", "stop preview, not previewing");
                }
            } catch (Exception e) {
                C4990ab.m7416i("MicroMsg.FaceReflectCam", "Error setting camera preview: " + e.getMessage());
            }
            try {
                this.mdw.release();
                this.mdw = null;
                this.mdw = null;
            } catch (Exception e2) {
                C4990ab.m7416i("MicroMsg.FaceReflectCam", "Error setting camera preview: " + e2.getMessage());
                this.mdw = null;
            } catch (Throwable th) {
                this.mdw = null;
                AppMethodBeat.m2505o(780);
            }
        }
        C4990ab.m7416i("MicroMsg.FaceReflectCam", "closeCamera end");
        AppMethodBeat.m2505o(780);
    }

    public final void btX() {
        AppMethodBeat.m2504i(781);
        if (this.mdu == null) {
            C4990ab.m7416i("MicroMsg.FaceReflectCam", "start camera thread");
            this.mdu = C7305d.anM("cameraBackground");
            this.mdu.start();
            this.mdv = new C7306ak(this.mdu.getLooper());
        }
        AppMethodBeat.m2505o(781);
    }

    /* renamed from: a */
    private static Point m19679a(Parameters parameters, Point point) {
        Size previewSize;
        AppMethodBeat.m2504i(782);
        ArrayList<Size> arrayList = new ArrayList(parameters.getSupportedPreviewSizes());
        Collections.sort(arrayList, new C11835a());
        Point point2 = null;
        C4990ab.m7411d("MicroMsg.FaceReflectCam", "screen.x: %d, screen.y: %d, ratio: %f", Integer.valueOf(point.x), Integer.valueOf(point.y), Float.valueOf(((float) point.x) / ((float) point.y)));
        long gO = C5046bo.m7553gO(C4996ah.getContext());
        C4990ab.m7411d("MicroMsg.FaceReflectCam", "systemAvailableMemInMB: %d", Long.valueOf(gO));
        int i = point.x;
        i = point.y;
        float f = Float.POSITIVE_INFINITY;
        for (Size previewSize2 : arrayList) {
            int i2 = previewSize2.width;
            int i3 = previewSize2.height;
            C4990ab.m7417i("MicroMsg.FaceReflectCam", "realWidth: %d, realHeight: %d", Integer.valueOf(i2), Integer.valueOf(i3));
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
                C4990ab.m7411d("MicroMsg.FaceReflectCam", "maybeFlippedWidth: %d, maybeFlippedHeight: %d", Integer.valueOf(i), Integer.valueOf(i4));
                if (i == point.x && i4 == point.y && C11830b.m19688f(i, i4, gO)) {
                    point2 = new Point(i2, i3);
                    C4990ab.m7416i("MicroMsg.FaceReflectCam", "Found preview size exactly matching screen size: ".concat(String.valueOf(point2)));
                    AppMethodBeat.m2505o(782);
                    return point2;
                }
                float abs = Math.abs((((float) i) / ((float) i4)) - r8);
                if (i2 % 10 == 0) {
                    float f2;
                    if (abs >= f || !C11830b.m19688f(i2, i3, gO)) {
                        f2 = f;
                    } else {
                        f2 = abs;
                        point2 = new Point(i2, i3);
                    }
                    C4990ab.m7417i("MicroMsg.FaceReflectCam", "diff:[%s] newdiff:[%s] w:[%s] h:[%s]", Float.valueOf(f2), Float.valueOf(abs), Integer.valueOf(i2), Integer.valueOf(i3));
                    f = f2;
                }
            }
        }
        if (point2 == null) {
            previewSize2 = parameters.getPreviewSize();
            if (previewSize2 != null) {
                point2 = new Point(previewSize2.width, previewSize2.height);
                C4990ab.m7416i("MicroMsg.FaceReflectCam", "No suitable preview sizes, using default: ".concat(String.valueOf(point2)));
            } else {
                C4990ab.m7412e("MicroMsg.FaceReflectCam", "hy: can not find default size!!");
            }
        }
        C4990ab.m7416i("MicroMsg.FaceReflectCam", "Found best approximate preview size: ".concat(String.valueOf(point2)));
        AppMethodBeat.m2505o(782);
        return point2;
    }

    /* renamed from: b */
    private static void m19683b(Parameters parameters) {
        AppMethodBeat.m2504i(783);
        if (C1427q.etc.eri > 0) {
            C4990ab.m7416i("MicroMsg.FaceReflectCam", "set frame rate > 0, do not try set preview fps range");
            AppMethodBeat.m2505o(783);
            return;
        }
        List supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        if (supportedPreviewFpsRange == null || supportedPreviewFpsRange.size() == 0) {
            AppMethodBeat.m2505o(783);
            return;
        }
        int i = C8415j.INVALID_ID;
        int i2 = C8415j.INVALID_ID;
        Object obj = null;
        int size = supportedPreviewFpsRange.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj2;
            int[] iArr = (int[]) supportedPreviewFpsRange.get(i3);
            if (iArr != null && iArr.length > 1) {
                int i4 = iArr[0];
                int i5 = iArr[1];
                C4990ab.m7417i("MicroMsg.FaceReflectCam", "dkfps %d:[%d %d]", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
                if (i4 >= 0 && i5 >= i4) {
                    if (i5 >= i2 && obj == null) {
                        i2 = i5;
                        i = i4;
                    }
                    if (i5 >= 30000) {
                        obj2 = 1;
                        i3++;
                        obj = obj2;
                    }
                }
            }
            obj2 = obj;
            i3++;
            obj = obj2;
        }
        C4990ab.m7417i("MicroMsg.FaceReflectCam", "dkfps get fit  [%d %d], max target fps %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(30));
        if (i == BaseClientBuilder.API_PRIORITY_OTHER || i2 == BaseClientBuilder.API_PRIORITY_OTHER) {
            AppMethodBeat.m2505o(783);
            return;
        }
        try {
            parameters.setPreviewFpsRange(i, i2);
            C4990ab.m7417i("MicroMsg.FaceReflectCam", "set fps range %d %d", Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.m2505o(783);
        } catch (Exception e) {
            C4990ab.m7417i("MicroMsg.FaceReflectCam", "trySetPreviewFpsRangeParameters Exception, %s, %s", Looper.myLooper(), e.getMessage());
            AppMethodBeat.m2505o(783);
        }
    }

    /* renamed from: f */
    private static boolean m19688f(int i, int i2, long j) {
        AppMethodBeat.m2504i(784);
        C4990ab.m7411d("MicroMsg.FaceReflectCam", "dataSizeInMB: %f, availableMemInMb: %d", Double.valueOf(((((((double) i) * ((double) i2)) * 3.0d) / 2.0d) / 1024.0d) / 1024.0d), Long.valueOf(j));
        if (((double) j) / (((((((double) i) * ((double) i2)) * 3.0d) / 2.0d) / 1024.0d) / 1024.0d) >= 5.0d) {
            AppMethodBeat.m2505o(784);
            return true;
        }
        AppMethodBeat.m2505o(784);
        return false;
    }

    /* renamed from: w */
    static /* synthetic */ void m19706w(C11830b c11830b) {
        AppMethodBeat.m2504i(787);
        c11830b.faceBitmap = c11830b.mdt.getBitmap();
        C7305d.post(new C30648(), "saveFaceBitmap");
        AppMethodBeat.m2505o(787);
    }
}

package com.tencent.mm.plugin.facedetectlight.ui;

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
import android.support.v4.widget.j;
import android.view.TextureView.SurfaceTextureListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.e.t;
import com.tencent.mm.plugin.facedetect.model.c;
import com.tencent.mm.plugin.facedetect.model.d;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetectaction.ui.FaceActionMask;
import com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import com.tencent.youtu.ytfacetrace.YTFaceTraceInterface;
import com.tencent.youtu.ytfacetrace.YTFaceTraceInterface.FaceDetectResult;
import com.tencent.youtu.ytfacetrace.YTFaceTraceInterface.FaceTraceingNotice;
import com.tencent.youtu.ytfacetrace.jni.YTFaceTraceJNIInterface.FaceStatus;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectResult;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class b implements SurfaceTextureListener {
    public String edV;
    private Bitmap faceBitmap;
    private com.tencent.mm.compatible.e.d.a.a fbb;
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
    com.tencent.mm.plugin.facedetect.model.d.b mao;
    public int mbW;
    public String mbX;
    private FaceActionUI mbY;
    public FaceActionMask mcP;
    private com.tencent.mm.plugin.facedetectaction.b.a.a mca;
    public PreviewFrameLayout mdA;
    private int mdB;
    public String mdC;
    public ImageView mdD;
    public ImageView mdE;
    private boolean mdF;
    private int mdG;
    private al mdH;
    private com.tencent.mm.plugin.facedetectlight.ui.a.b mdI;
    private MMTextureView mdt;
    private HandlerThread mdu;
    private ak mdv;
    public t mdw;
    public boolean mdx;
    public TextView mdy;
    public FaceReflectMask mdz;

    /* renamed from: com.tencent.mm.plugin.facedetectlight.ui.b$9 */
    class AnonymousClass9 implements PreviewCallback {
        final /* synthetic */ PreviewCallback lUN;

        AnonymousClass9(PreviewCallback previewCallback) {
            this.lUN = previewCallback;
        }

        public final void onPreviewFrame(byte[] bArr, Camera camera) {
            AppMethodBeat.i(770);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(769);
                    b.this.mdt.setAlpha(1.0f);
                    AppMethodBeat.o(769);
                }
            });
            if (this.lUN != null) {
                this.lUN.onPreviewFrame(bArr, camera);
            }
            camera.addCallbackBuffer(bArr);
            AppMethodBeat.o(770);
        }
    }

    static class a implements Comparator<Size> {
        private a() {
        }

        /* synthetic */ a(byte b) {
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

    static /* synthetic */ boolean d(b bVar) {
        AppMethodBeat.i(785);
        boolean btV = bVar.btV();
        AppMethodBeat.o(785);
        return btV;
    }

    public b(Context context, com.tencent.mm.plugin.facedetectlight.ui.a.b bVar) {
        AppMethodBeat.i(772);
        this.lUF = null;
        this.lUG = null;
        this.lUH = null;
        this.lUM = null;
        this.mdB = 0;
        this.mdH = new al("mPreviewHandlerThread");
        this.mao = new com.tencent.mm.plugin.facedetect.model.d.b() {
            public final void aT(byte[] bArr) {
                AppMethodBeat.i(771);
                c.lTA.g(bArr);
                AppMethodBeat.o(771);
            }

            public final com.tencent.mm.memory.a<byte[]> bsr() {
                return c.lTA;
            }
        };
        this.man = new PreviewCallback() {
            public final void onPreviewFrame(final byte[] bArr, final Camera camera) {
                AppMethodBeat.i(760);
                b.this.mdH.aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(759);
                        if (b.this.mdx) {
                            byte[] bArr;
                            Camera camera;
                            if (b.this.mdG == 1) {
                                com.tencent.mm.plugin.facedetectlight.ui.c.a.btY();
                                bArr = bArr;
                                camera = camera;
                                if (YTFaceTraceInterface.isTracing()) {
                                    YTFaceTraceInterface.onPreviewFrame(bArr, camera);
                                }
                                if (YTAGReflectLiveCheckInterface.getProcessState() == 2) {
                                    YTAGReflectLiveCheckInterface.onPreviewFrame(bArr, camera);
                                }
                                d.bsq().aS(bArr);
                                AppMethodBeat.o(759);
                                return;
                            }
                            com.tencent.mm.plugin.facedetectaction.b.a.b.mcl;
                            bArr = bArr;
                            camera = camera;
                            if (YTFaceTraceInterface.isTracing()) {
                                YTFaceTraceInterface.onPreviewFrame(bArr, camera);
                                AppMethodBeat.o(759);
                                return;
                            } else if (YTAGReflectLiveCheckInterface.getProcessState() == 2) {
                                YTAGReflectLiveCheckInterface.onPreviewFrame(bArr, camera);
                            }
                        }
                        AppMethodBeat.o(759);
                    }
                });
                AppMethodBeat.o(760);
            }
        };
        this.mdI = bVar;
        this.mdG = 1;
        this.mContext = context;
        this.mIsCameraOpened = false;
        this.lXB = false;
        this.mdu = null;
        this.mIsCameraOpened = false;
        AppMethodBeat.o(772);
    }

    public b(FaceActionUI faceActionUI, com.tencent.mm.plugin.facedetectaction.b.a.a aVar) {
        AppMethodBeat.i(773);
        this.lUF = null;
        this.lUG = null;
        this.lUH = null;
        this.lUM = null;
        this.mdB = 0;
        this.mdH = new al("mPreviewHandlerThread");
        this.mao = /* anonymous class already generated */;
        this.man = /* anonymous class already generated */;
        this.mdG = 2;
        this.mbY = faceActionUI;
        this.mIsCameraOpened = false;
        this.lXB = false;
        this.mdu = null;
        this.mIsCameraOpened = false;
        this.mdF = false;
        this.mca = aVar;
        AppMethodBeat.o(773);
    }

    public final void a(MMTextureView mMTextureView) {
        AppMethodBeat.i(774);
        this.mdt = mMTextureView;
        if (this.mdt.isAvailable()) {
            g(mMTextureView.getSurfaceTexture());
        }
        this.mdt.setSurfaceTextureListener(this);
        this.mdt.setVisibility(0);
        this.mdt.setAlpha(0.0f);
        if (this.mdG == 2 && !this.mdF) {
            al.n(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(758);
                    b.this.mdD.setVisibility(8);
                    b.this.mdE.setVisibility(8);
                    b.this.mdF = true;
                    AppMethodBeat.o(758);
                }
            }, 700);
        }
        AppMethodBeat.o(774);
    }

    private void g(final SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(775);
        ab.i("MicroMsg.FaceReflectCam", "openCameraForSurfaceTexture");
        if (this.mdG == 1) {
            this.mdz.setVisibility(0);
        } else {
            this.mcP.setVisibility(0);
        }
        btX();
        if (this.mdv != null) {
            this.mdv.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(762);
                    if (!b.d(b.this)) {
                        h.pYm.a(917, b.this.mdG == 1 ? 3 : 39, 1, false);
                        b.d(b.this);
                    }
                    h.pYm.a(917, b.this.mdG == 1 ? 2 : 38, 1, false);
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(761);
                            int o;
                            int p;
                            if (b.this.mdG == 1) {
                                c btY = com.tencent.mm.plugin.facedetectlight.ui.c.a.btY();
                                Context f = b.this.mContext;
                                com.tencent.mm.plugin.facedetectlight.ui.a.b g = b.this.mdI;
                                t h = b.this.mdw;
                                int i = b.this.mdB;
                                TextView textView = b.this.mdy;
                                FaceReflectMask j = b.this.mdz;
                                byte[] k = b.this.lWX;
                                String l = b.this.mdC;
                                String m = b.this.mAppId;
                                int n = b.this.lUJ;
                                o = b.this.mDesiredPreviewWidth;
                                p = b.this.mDesiredPreviewHeight;
                                Point q = b.this.lUM;
                                ab.i("MicroMsg.FaceReflectLogic", "initPreviewDetect（）");
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
                                ab.i("MicroMsg.FaceReflectLogic", "mConfig is ".concat(String.valueOf(k)));
                                ab.i("MicroMsg.FaceReflectLogic", "mBioID is " + btY.mdC);
                                ab.i("MicroMsg.FaceReflectLogic", "mAppId is ".concat(String.valueOf(m)));
                                btY.mcb = new Rect(0, 0, 0, 0);
                                btY.mcc = new Rect(0, 0, 0, 0);
                                btY.mch = new com.tencent.mm.plugin.facedetectlight.ui.c.AnonymousClass1(btY);
                                if (com.tencent.mm.plugin.facedetect.e.a.btw().lZc) {
                                    com.tencent.mm.plugin.facedetect.e.a.btw().a(btY.mdQ, btY.mDesiredPreviewWidth, btY.mDesiredPreviewHeight, btY.mdR.x, btY.mDesiredPreviewHeight, false);
                                }
                                c btY2 = com.tencent.mm.plugin.facedetectlight.ui.c.a.btY();
                                ab.i("MicroMsg.FaceReflectLogic", "initFaceDetect（）");
                                try {
                                    YTFaceTraceInterface.start(btY2.mContext, btY2.mdw.etv, btY2.hGq, new com.tencent.mm.plugin.facedetectlight.ui.c.AnonymousClass3(btY2), btY2.mch);
                                    AppMethodBeat.o(761);
                                    return;
                                } catch (Exception e) {
                                    ab.i("MicroMsg.FaceReflectLogic", "init FaceDetect() failed ：%s ", e.getMessage());
                                    AppMethodBeat.o(761);
                                    return;
                                }
                            }
                            com.tencent.mm.plugin.facedetectaction.b.a btO = com.tencent.mm.plugin.facedetectaction.b.a.b.mcl;
                            Context applicationContext = b.this.mbY.getApplicationContext();
                            FaceActionUI r = b.this.mbY;
                            Camera camera = b.this.mdw.etv;
                            int i2 = b.this.mdB;
                            TextView textView2 = b.this.mdy;
                            com.tencent.mm.plugin.facedetectaction.b.a.a s = b.this.mca;
                            int n2 = b.this.lUJ;
                            Point point = new Point(b.this.mDesiredPreviewWidth, b.this.mDesiredPreviewHeight);
                            int t = b.this.mbW;
                            String u = b.this.mbX;
                            o = b.this.mDesiredPreviewWidth;
                            p = b.this.mDesiredPreviewHeight;
                            ab.i("MicroMsg.FaceActionLogic", "initFaceDetect（）");
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
                            btO.mch = new FaceTraceingNotice() {
                                public final void onTracing(int i, FaceStatus faceStatus, Rect rect, byte[] bArr, Camera camera) {
                                    AppMethodBeat.i(678);
                                    switch (i) {
                                        case 0:
                                            ab.i("MicroMsg.FaceActionLogic", "Face mState：init");
                                            YTPoseDetectInterface.start(ah.getContext(), a.this.mCamera, a.this.hGq, new PoseDetectResult() {
                                                public final void onSuccess() {
                                                    AppMethodBeat.i(676);
                                                    ab.i("MicroMsg.FaceActionLogic", "YTPoseDetectInterface start success");
                                                    AppMethodBeat.o(676);
                                                }

                                                public final void onFailed(int i, String str, String str2) {
                                                    AppMethodBeat.i(677);
                                                    ab.i("MicroMsg.FaceActionLogic", "YTPoseDetectInterface start failed：[%s],[%s]", str, str2);
                                                    AppMethodBeat.o(677);
                                                }
                                            });
                                            AppMethodBeat.o(678);
                                            return;
                                        case 1:
                                            ab.i("MicroMsg.FaceActionLogic", "Face mState：detecting");
                                            a aVar = a.this;
                                            ab.i("MicroMsg.FaceActionLogic", "setFaceRect（）");
                                            aVar.mcd = aVar.mbY.getResources().getDisplayMetrics().widthPixels;
                                            aVar.mce = aVar.mbY.getResources().getDisplayMetrics().heightPixels;
                                            aVar.mcc.left = (int) (((double) aVar.mcd) * 0.15d);
                                            aVar.mcc.right = (int) (((double) aVar.mcd) * 0.85d);
                                            aVar.mcc.top = (int) (((double) aVar.mce) * 0.2d);
                                            aVar.mcc.bottom = (int) (((double) aVar.mce) * 0.65d);
                                            aVar = a.this;
                                            ab.i("MicroMsg.FaceActionLogic", "setFaceLiveRect（）");
                                            ab.i("MicroMsg.FaceActionLogic", "faceInPreviewFrame is".concat(String.valueOf(rect)));
                                            if (rect != null) {
                                                int i2 = aVar.mcd;
                                                int i3 = aVar.mce;
                                                int i4 = aVar.mDesiredPreviewWidth;
                                                int i5 = aVar.mDesiredPreviewHeight;
                                                aVar.mcf = ((float) i2) / ((float) i5);
                                                aVar.mcg = ((float) i3) / ((float) i4);
                                                aVar.mcb.left = (int) (((float) rect.left) * aVar.mcf);
                                                aVar.mcb.right = (int) (((float) rect.right) * aVar.mcf);
                                                aVar.mcb.top = (int) (((float) rect.top) * aVar.mcg);
                                                aVar.mcb.bottom = (int) (((float) rect.bottom) * aVar.mcg);
                                                ab.i("MicroMsg.FaceActionLogic", "mUiWidth：" + aVar.mcd);
                                                ab.i("MicroMsg.FaceActionLogic", "mUiHeight：" + aVar.mce);
                                                ab.i("MicroMsg.FaceActionLogic", "previewWidth：".concat(String.valueOf(i4)));
                                                ab.i("MicroMsg.FaceActionLogic", "previewHeight：".concat(String.valueOf(i5)));
                                                ab.i("MicroMsg.FaceActionLogic", "faceInPreviewFrame.right：" + rect.right);
                                                ab.i("MicroMsg.FaceActionLogic", "mWidthRatio：" + aVar.mcf);
                                            }
                                            aVar = a.this;
                                            Rect rect2 = a.this.mcc;
                                            Rect rect3 = a.this.mcb;
                                            ab.i("MicroMsg.FaceActionLogic", "getFacePreviewAdvise（）");
                                            if (faceStatus != null) {
                                                boolean contains = rect2.contains(rect3);
                                                float f = ((float) ((rect3.right - rect3.left) * (rect3.bottom - rect3.top))) / ((float) ((rect2.right - rect2.left) * (rect2.bottom - rect2.top)));
                                                ab.i("MicroMsg.FaceActionLogic", "faceInScreen left is ：" + rect3.left);
                                                ab.i("MicroMsg.FaceActionLogic", "faceInScreen right is ：" + rect3.right);
                                                ab.i("MicroMsg.FaceActionLogic", "faceInScreen top is ：" + rect3.top);
                                                ab.i("MicroMsg.FaceActionLogic", "faceInScreen bottom is ：" + rect3.bottom);
                                                ab.i("MicroMsg.FaceActionLogic", "checkRect left is ：" + rect2.left);
                                                ab.i("MicroMsg.FaceActionLogic", "checkRect right is ：" + rect2.right);
                                                ab.i("MicroMsg.FaceActionLogic", "checkRect top is ：" + rect2.top);
                                                ab.i("MicroMsg.FaceActionLogic", "checkRect bottom is ：" + rect2.bottom);
                                                ab.i("MicroMsg.FaceActionLogic", "faceProportion ：".concat(String.valueOf(f)));
                                                ab.i("MicroMsg.FaceActionLogic", "isInRect？ ：".concat(String.valueOf(contains)));
                                                ab.i("MicroMsg.FaceActionLogic", "status".concat(String.valueOf(faceStatus)));
                                                if (((double) f) >= 0.3d) {
                                                    if (((double) f) <= 0.75d) {
                                                        if (contains) {
                                                            ab.i("MicroMsg.FaceActionLogic", "Detecting result：normal");
                                                            ab.i("MicroMsg.FaceActionLogic", "action：%s,mActionHint:%s", Integer.valueOf(aVar.mbW), aVar.mbX);
                                                            if (aVar.mbX == null) {
                                                                switch (aVar.mbW) {
                                                                    case 0:
                                                                        aVar.mbZ.setText(R.string.bjd);
                                                                        break;
                                                                    case 1:
                                                                        aVar.mbZ.setText(R.string.bjb);
                                                                        break;
                                                                    case 2:
                                                                        aVar.mbZ.setText(R.string.bjc);
                                                                        break;
                                                                }
                                                            }
                                                            aVar.mbZ.setText(aVar.mbX);
                                                            aVar.mca.a(faceStatus, bArr);
                                                            break;
                                                        }
                                                        ab.i("MicroMsg.FaceActionLogic", "Detecting result：out of rect");
                                                        aVar.mbZ.setText(R.string.bla);
                                                        AppMethodBeat.o(678);
                                                        return;
                                                    }
                                                    ab.i("MicroMsg.FaceActionLogic", "Detecting result：too close");
                                                    aVar.mbZ.setText(R.string.ble);
                                                    AppMethodBeat.o(678);
                                                    return;
                                                }
                                                ab.i("MicroMsg.FaceActionLogic", "Detecting result：too far");
                                                aVar.mbZ.setText(R.string.blf);
                                                AppMethodBeat.o(678);
                                                return;
                                            }
                                            ab.i("MicroMsg.FaceActionLogic", "status == null");
                                            aVar.mbZ.setText(R.string.bla);
                                            AppMethodBeat.o(678);
                                            return;
                                        case 2:
                                            ab.i("MicroMsg.FaceActionLogic", "Face mState：stop detect");
                                            AppMethodBeat.o(678);
                                            return;
                                    }
                                    AppMethodBeat.o(678);
                                }
                            };
                            btO.mci = new FaceDetectResult() {
                                public final void onSuccess() {
                                    AppMethodBeat.i(679);
                                    ab.i("MicroMsg.FaceActionLogic", "camera detect success ");
                                    AppMethodBeat.o(679);
                                }

                                public final void onFailed(int i, String str, String str2) {
                                    AppMethodBeat.i(680);
                                    ab.i("MicroMsg.FaceActionLogic", "camera detect failed: errorCode：%s 、message：%s、tips ：%s ", Integer.valueOf(i), str, str2);
                                    AppMethodBeat.o(680);
                                }
                            };
                            try {
                                YTFaceTraceInterface.start(btO.mContext, btO.mCamera, btO.hGq, btO.mci, btO.mch);
                            } catch (Exception e2) {
                                ab.i("MicroMsg.FaceActionLogic", "init FaceDetect() failed ：%s ", e2.getMessage());
                            }
                            ab.i("MicroMsg.FaceActionLogic", "init face detect, camera, rotate: %s", Integer.valueOf(n2));
                            com.tencent.mm.plugin.facedetectaction.b.d.mcq.fcR = n2;
                            com.tencent.mm.plugin.facedetectaction.b.d dVar = com.tencent.mm.plugin.facedetectaction.b.d.mcq;
                            int i3 = point.x;
                            int i4 = point.y;
                            dVar.mcz = i3;
                            dVar.mcA = i4;
                            AppMethodBeat.o(761);
                        }
                    });
                    AppMethodBeat.o(762);
                }
            });
            this.mdv.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(763);
                    try {
                        b.a(b.this, surfaceTexture);
                        b bVar = b.this;
                        PreviewCallback v = b.this.man;
                        if (bVar.mdw == null) {
                            ab.w("MicroMsg.FaceReflectCam", "hy: camera is null. setPreviewCallback failed");
                            AppMethodBeat.o(763);
                            return;
                        }
                        int bitsPerPixel = ((bVar.mDesiredPreviewWidth * bVar.mDesiredPreviewHeight) * ImageFormat.getBitsPerPixel(bVar.mdw.getParameters().getPreviewFormat())) / 8;
                        for (int i = 0; i < 5; i++) {
                            bVar.mdw.addCallbackBuffer(c.lTA.g(Integer.valueOf(bitsPerPixel)));
                        }
                        bVar.mdw.setPreviewCallbackWithBuffer(new AnonymousClass9(v));
                        d.bsq().a(bVar.mao);
                        AppMethodBeat.o(763);
                    } catch (Exception e) {
                        if (b.this.mdG == 1) {
                            b.this.mdI.u(90016, "preview error", ah.getContext().getString(R.string.er5));
                            AppMethodBeat.o(763);
                            return;
                        }
                        ab.i("MicroMsg.FaceReflectCam", "preview error");
                        AppMethodBeat.o(763);
                    }
                }
            });
            AppMethodBeat.o(775);
            return;
        }
        ab.i("MicroMsg.FaceReflectCam", "back thread is not running");
        AppMethodBeat.o(775);
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(776);
        ab.i("MicroMsg.FaceReflectCam", "surfaceDestroyed");
        if (this.mdv != null) {
            this.mdv.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(764);
                    b.this.btW();
                    AppMethodBeat.o(764);
                }
            });
            if (this.mdu != null) {
                ab.i("MicroMsg.FaceReflectCam", "stop camera thread");
                try {
                    Thread.sleep(500, 0);
                } catch (InterruptedException e) {
                    ab.i("MicroMsg.FaceReflectCam", "background thread sleep error：" + e.getMessage());
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
                    ab.i("MicroMsg.FaceReflectCam", "stop background thread error：" + e2.getMessage());
                }
                ab.i("MicroMsg.FaceReflectCam", "stop camera thread finish");
            }
        } else {
            ab.i("MicroMsg.FaceReflectCam", "back thread is not running");
        }
        AppMethodBeat.o(776);
        return false;
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.i(777);
        ab.i("MicroMsg.FaceReflectCam", "onSurfaceTextureAvailable, width: %s, height: %s", Integer.valueOf(i), Integer.valueOf(i2));
        g(surfaceTexture);
        AppMethodBeat.o(777);
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
        AppMethodBeat.i(778);
        ab.i("MicroMsg.FaceReflectCam", "start open camera");
        this.mIsCameraOpened = false;
        this.isFrontCamera = true;
        int numberOfCameras = Camera.getNumberOfCameras();
        int i = 0;
        while (i < numberOfCameras) {
            CameraInfo cameraInfo = new CameraInfo();
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing != 1 || !this.isFrontCamera) {
                if (cameraInfo.facing == 0 && !this.isFrontCamera) {
                    ab.d("MicroMsg.FaceReflectCam", "hy: front Camera found");
                    break;
                }
                i++;
            } else {
                ab.d("MicroMsg.FaceReflectCam", "hy: front Camera found");
                break;
            }
        }
        i = -1;
        long yz = bo.yz();
        ab.i("MicroMsg.FaceReflectCam", "openCameraRes：" + this.fbb);
        if (this.fbb == null) {
            ab.i("MicroMsg.FaceReflectCam", "openCameraRes is null");
            if (this.mdG == 1) {
                ab.i("MicroMsg.FaceReflectCam", "mFaceReflectController openCameraRe");
                this.fbb = com.tencent.mm.compatible.e.d.a(this.mContext, i, null);
            } else {
                ab.i("MicroMsg.FaceReflectCam", "mFaceActionUI openCameraRe");
                this.fbb = com.tencent.mm.compatible.e.d.a(this.mbY.mController.ylL, i, null);
            }
        }
        IOException iOException;
        if (this.fbb == null) {
            ab.i("MicroMsg.FaceReflectCam", "in open(), openCameraRes == null");
            try {
                iOException = new IOException();
                AppMethodBeat.o(778);
                throw iOException;
            } catch (IOException iOException2) {
                ab.i("MicroMsg.FaceReflectCam", "set cameraRes exception" + iOException2.getMessage());
                AppMethodBeat.o(778);
                return false;
            }
        }
        this.mdB = i;
        this.mIsCameraOpened = true;
        ab.d("MicroMsg.FaceReflectCam", "openCamera done, cameraId=[%s] costTime=[%s]", Integer.valueOf(i), Long.valueOf(bo.az(yz)));
        this.lUJ = this.fbb.rotate;
        this.lUI = this.fbb.rotate % 180 != 0;
        this.mdw = this.fbb.erH;
        if (this.mdw == null) {
            ab.e("MicroMsg.FaceReflectCam", "in open(), camera == null, bNeedRotate=[%s]", Boolean.valueOf(this.lUI));
            try {
                iOException2 = new IOException();
                AppMethodBeat.o(778);
                throw iOException2;
            } catch (IOException iOException22) {
                ab.i("MicroMsg.FaceReflectCam", "set cameraRotation exception" + iOException22.getMessage());
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
                ab.d("MicroMsg.FaceReflectCam", "preview-size-values parameter: ".concat(String.valueOf(obj)));
                a = a(parameters, point);
            } else {
                a = null;
            }
            if (a == null) {
                a = new Point((point2.x >> 3) << 3, (point2.y >> 3) << 3);
            }
            this.lUF = a;
            this.lUM = new Point(this.lUF);
            ab.d("MicroMsg.FaceReflectCam", "getCameraResolution: " + this.lUG + " camera:" + this.lUF + "bestVideoEncodeSize: " + this.lUM);
            this.mDesiredPreviewWidth = this.lUF.x;
            this.mDesiredPreviewHeight = this.lUF.y;
            parameters.setPreviewSize(this.mDesiredPreviewWidth, this.mDesiredPreviewHeight);
            ab.e("MicroMsg.FaceReflectCam", "mDesiredPreviewWidth：" + this.mDesiredPreviewWidth);
            ab.e("MicroMsg.FaceReflectCam", "mDesiredPreviewHeight：" + this.mDesiredPreviewHeight);
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
                    ab.i("MicroMsg.FaceReflectCam", "camera not support FOCUS_MODE_AUTO");
                    supportedPreviewFormats = parameters.getSupportedPreviewFormats();
                    z = false;
                    for (Integer intValue : supportedPreviewFormats) {
                        i = intValue.intValue();
                        ab.d("MicroMsg.FaceReflectCam", "supportedPreviewFormat: ".concat(String.valueOf(i)));
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
                        ab.e("MicroMsg.FaceReflectCam", "Preview not support PixelFormat.YCbCr_420_SP, but hasYU12");
                        parameters.setPreviewFormat(842094169);
                    } else {
                        ab.e("MicroMsg.FaceReflectCam", "Preview not support PixelFormat.YCbCr_420_SP. Use format: %s", supportedPreviewFormats.get(0));
                        parameters.setPreviewFormat(((Integer) supportedPreviewFormats.get(0)).intValue());
                    }
                    if (this.lUI) {
                        parameters.setRotation(this.lUJ);
                    }
                    d = this.mdA.getmAspectRatio();
                    ab.d("MicroMsg.FaceReflectCam", "original ratio=".concat(String.valueOf(d)));
                    d2 = ((double) this.mDesiredPreviewWidth) / ((double) this.mDesiredPreviewHeight);
                    ab.d("MicroMsg.FaceReflectCam", "new ratio=".concat(String.valueOf(d2)));
                    if (d != d2) {
                        ab.d("MicroMsg.FaceReflectCam", "NO NEED reset ratio");
                    } else {
                        ab.d("MicroMsg.FaceReflectCam", "start reset ratio");
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(765);
                                ab.d("MicroMsg.FaceReflectCam", "reset ratio");
                                LayoutParams layoutParams = (LayoutParams) b.this.mdA.getLayoutParams();
                                layoutParams.width = (int) (((double) b.this.mdA.getContext().getResources().getDisplayMetrics().widthPixels) * 0.7d);
                                layoutParams.height = (int) (((double) layoutParams.width) * d2);
                                layoutParams.addRule(13, -1);
                                b.this.mdA.setLayoutParams(layoutParams);
                                b.this.mdA.setAspectRatio(d2);
                                ab.d("MicroMsg.FaceReflectCam", "after reset ratio=" + b.this.mdA.getmAspectRatio());
                                AppMethodBeat.o(765);
                            }
                        });
                    }
                    b(parameters);
                    supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
                    ab.d("MicroMsg.FaceReflectCam", "range:" + supportedPreviewFpsRange.size());
                    for (i3 = 0; i3 < supportedPreviewFpsRange.size(); i3++) {
                        int[] iArr = (int[]) supportedPreviewFpsRange.get(i3);
                        for (i2 = 0; i2 < iArr.length; i2++) {
                            ab.i("MicroMsg.FaceReflectCam", "Camera SupportedPreviewFpsRange：", Integer.valueOf(iArr[i2]));
                        }
                    }
                    ab.i("MicroMsg.FaceReflectCam", "Camera preview-fps-range：" + parameters.get("preview-fps-range"));
                    ab.i("MicroMsg.FaceReflectCam", "Camera preview-fps-range：" + parameters.get("preview-frame-rate"));
                    this.mdw.setParameters(parameters);
                    z3 = this.mIsCameraOpened;
                    AppMethodBeat.o(778);
                    return z3;
                }
                ab.i("MicroMsg.FaceReflectCam", "set FocusMode to FOCUS_MODE_AUTO");
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
                ab.d("MicroMsg.FaceReflectCam", "original ratio=".concat(String.valueOf(d)));
                d2 = ((double) this.mDesiredPreviewWidth) / ((double) this.mDesiredPreviewHeight);
                ab.d("MicroMsg.FaceReflectCam", "new ratio=".concat(String.valueOf(d2)));
                if (d != d2) {
                }
                b(parameters);
                supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
                ab.d("MicroMsg.FaceReflectCam", "range:" + supportedPreviewFpsRange.size());
                while (i3 < supportedPreviewFpsRange.size()) {
                }
                ab.i("MicroMsg.FaceReflectCam", "Camera preview-fps-range：" + parameters.get("preview-fps-range"));
                ab.i("MicroMsg.FaceReflectCam", "Camera preview-fps-range：" + parameters.get("preview-frame-rate"));
                this.mdw.setParameters(parameters);
                z3 = this.mIsCameraOpened;
                AppMethodBeat.o(778);
                return z3;
            } catch (Exception e) {
                ab.e("MicroMsg.FaceReflectCam", "set focus mode error: %s", e.getMessage());
            }
        } catch (Exception e2) {
            ab.printErrStackTrace("MicroMsg.FaceReflectCam", e2, "camera getParameters error: %s", e2.getMessage());
            AppMethodBeat.o(778);
            return false;
        }
    }

    public final void stopPreview() {
        AppMethodBeat.i(779);
        ab.i("MicroMsg.FaceReflectCam", "stopPreview, isPreviewing: %s", Boolean.valueOf(this.mdx));
        if (this.mdw != null) {
            this.mdw.stopPreview();
            this.mdx = false;
            c.lTA.WY();
        }
        AppMethodBeat.o(779);
    }

    public final void btW() {
        AppMethodBeat.i(780);
        ab.i("MicroMsg.FaceReflectCam", "closeCamera start");
        if (this.mdw != null) {
            try {
                if (this.lXB) {
                    this.lXB = false;
                    this.mdw.stopPreview();
                    this.mdw.setPreviewCallback(null);
                    ab.i("MicroMsg.FaceReflectCam", "stop preview, not previewing");
                }
            } catch (Exception e) {
                ab.i("MicroMsg.FaceReflectCam", "Error setting camera preview: " + e.getMessage());
            }
            try {
                this.mdw.release();
                this.mdw = null;
                this.mdw = null;
            } catch (Exception e2) {
                ab.i("MicroMsg.FaceReflectCam", "Error setting camera preview: " + e2.getMessage());
                this.mdw = null;
            } catch (Throwable th) {
                this.mdw = null;
                AppMethodBeat.o(780);
            }
        }
        ab.i("MicroMsg.FaceReflectCam", "closeCamera end");
        AppMethodBeat.o(780);
    }

    public final void btX() {
        AppMethodBeat.i(781);
        if (this.mdu == null) {
            ab.i("MicroMsg.FaceReflectCam", "start camera thread");
            this.mdu = com.tencent.mm.sdk.g.d.anM("cameraBackground");
            this.mdu.start();
            this.mdv = new ak(this.mdu.getLooper());
        }
        AppMethodBeat.o(781);
    }

    private static Point a(Parameters parameters, Point point) {
        Size previewSize;
        AppMethodBeat.i(782);
        ArrayList<Size> arrayList = new ArrayList(parameters.getSupportedPreviewSizes());
        Collections.sort(arrayList, new a());
        Point point2 = null;
        ab.d("MicroMsg.FaceReflectCam", "screen.x: %d, screen.y: %d, ratio: %f", Integer.valueOf(point.x), Integer.valueOf(point.y), Float.valueOf(((float) point.x) / ((float) point.y)));
        long gO = bo.gO(ah.getContext());
        ab.d("MicroMsg.FaceReflectCam", "systemAvailableMemInMB: %d", Long.valueOf(gO));
        int i = point.x;
        i = point.y;
        float f = Float.POSITIVE_INFINITY;
        for (Size previewSize2 : arrayList) {
            int i2 = previewSize2.width;
            int i3 = previewSize2.height;
            ab.i("MicroMsg.FaceReflectCam", "realWidth: %d, realHeight: %d", Integer.valueOf(i2), Integer.valueOf(i3));
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
                ab.d("MicroMsg.FaceReflectCam", "maybeFlippedWidth: %d, maybeFlippedHeight: %d", Integer.valueOf(i), Integer.valueOf(i4));
                if (i == point.x && i4 == point.y && f(i, i4, gO)) {
                    point2 = new Point(i2, i3);
                    ab.i("MicroMsg.FaceReflectCam", "Found preview size exactly matching screen size: ".concat(String.valueOf(point2)));
                    AppMethodBeat.o(782);
                    return point2;
                }
                float abs = Math.abs((((float) i) / ((float) i4)) - r8);
                if (i2 % 10 == 0) {
                    float f2;
                    if (abs >= f || !f(i2, i3, gO)) {
                        f2 = f;
                    } else {
                        f2 = abs;
                        point2 = new Point(i2, i3);
                    }
                    ab.i("MicroMsg.FaceReflectCam", "diff:[%s] newdiff:[%s] w:[%s] h:[%s]", Float.valueOf(f2), Float.valueOf(abs), Integer.valueOf(i2), Integer.valueOf(i3));
                    f = f2;
                }
            }
        }
        if (point2 == null) {
            previewSize2 = parameters.getPreviewSize();
            if (previewSize2 != null) {
                point2 = new Point(previewSize2.width, previewSize2.height);
                ab.i("MicroMsg.FaceReflectCam", "No suitable preview sizes, using default: ".concat(String.valueOf(point2)));
            } else {
                ab.e("MicroMsg.FaceReflectCam", "hy: can not find default size!!");
            }
        }
        ab.i("MicroMsg.FaceReflectCam", "Found best approximate preview size: ".concat(String.valueOf(point2)));
        AppMethodBeat.o(782);
        return point2;
    }

    private static void b(Parameters parameters) {
        AppMethodBeat.i(783);
        if (q.etc.eri > 0) {
            ab.i("MicroMsg.FaceReflectCam", "set frame rate > 0, do not try set preview fps range");
            AppMethodBeat.o(783);
            return;
        }
        List supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        if (supportedPreviewFpsRange == null || supportedPreviewFpsRange.size() == 0) {
            AppMethodBeat.o(783);
            return;
        }
        int i = j.INVALID_ID;
        int i2 = j.INVALID_ID;
        Object obj = null;
        int size = supportedPreviewFpsRange.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj2;
            int[] iArr = (int[]) supportedPreviewFpsRange.get(i3);
            if (iArr != null && iArr.length > 1) {
                int i4 = iArr[0];
                int i5 = iArr[1];
                ab.i("MicroMsg.FaceReflectCam", "dkfps %d:[%d %d]", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
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
        ab.i("MicroMsg.FaceReflectCam", "dkfps get fit  [%d %d], max target fps %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(30));
        if (i == BaseClientBuilder.API_PRIORITY_OTHER || i2 == BaseClientBuilder.API_PRIORITY_OTHER) {
            AppMethodBeat.o(783);
            return;
        }
        try {
            parameters.setPreviewFpsRange(i, i2);
            ab.i("MicroMsg.FaceReflectCam", "set fps range %d %d", Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.o(783);
        } catch (Exception e) {
            ab.i("MicroMsg.FaceReflectCam", "trySetPreviewFpsRangeParameters Exception, %s, %s", Looper.myLooper(), e.getMessage());
            AppMethodBeat.o(783);
        }
    }

    private static boolean f(int i, int i2, long j) {
        AppMethodBeat.i(784);
        ab.d("MicroMsg.FaceReflectCam", "dataSizeInMB: %f, availableMemInMb: %d", Double.valueOf(((((((double) i) * ((double) i2)) * 3.0d) / 2.0d) / 1024.0d) / 1024.0d), Long.valueOf(j));
        if (((double) j) / (((((((double) i) * ((double) i2)) * 3.0d) / 2.0d) / 1024.0d) / 1024.0d) >= 5.0d) {
            AppMethodBeat.o(784);
            return true;
        }
        AppMethodBeat.o(784);
        return false;
    }

    static /* synthetic */ void w(b bVar) {
        AppMethodBeat.i(787);
        bVar.faceBitmap = bVar.mdt.getBitmap();
        com.tencent.mm.sdk.g.d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(768);
                b bVar = b.this;
                ah.getContext();
                bVar.faceBitmap = p.n(b.this.edV, b.this.faceBitmap);
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(767);
                        b.this.mdD.setImageBitmap(b.this.faceBitmap);
                        AppMethodBeat.o(767);
                    }
                });
                AppMethodBeat.o(768);
            }
        }, "saveFaceBitmap");
        AppMethodBeat.o(787);
    }
}

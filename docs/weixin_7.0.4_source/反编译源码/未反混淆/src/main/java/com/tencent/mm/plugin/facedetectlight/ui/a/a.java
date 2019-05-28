package com.tencent.mm.plugin.facedetectlight.ui.a;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.facedetectlight.ui.FaceReflectMask;
import com.tencent.mm.plugin.facedetectlight.ui.PreviewFrameLayout;
import com.tencent.mm.plugin.facedetectlight.ui.b;
import com.tencent.mm.plugin.facedetectlight.ui.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.smtt.sdk.WebView;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import com.tencent.youtu.ytcommon.YTCommonExInterface;
import com.tencent.youtu.ytfacetrace.YTFaceTraceInterface;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public final class a extends com.tencent.mm.plugin.facedetectlight.ui.a implements b {
    PreviewFrameLayout mcO;
    MMTextureView mcQ;
    private ImageView mcR;
    public TextView mcS;
    public b mcZ;
    public FaceReflectMask mdz;
    public ImageView mee;
    private TextView mef;
    ImageView meg;

    public a(ViewGroup viewGroup, com.tencent.mm.plugin.facedetectlight.ui.container.a aVar) {
        super(viewGroup, aVar);
    }

    public final int btU() {
        return R.layout.xa;
    }

    public final void initView() {
        AppMethodBeat.i(825);
        this.mcR = (ImageView) findViewById(R.id.blv);
        this.mcO = (PreviewFrameLayout) findViewById(R.id.blt);
        this.mcQ = (MMTextureView) findViewById(R.id.blu);
        this.mdz = (FaceReflectMask) findViewById(R.id.blx);
        this.mee = (ImageView) findViewById(R.id.bmi);
        this.mcS = (TextView) findViewById(R.id.bly);
        this.meg = (ImageView) findViewById(R.id.bmj);
        this.mef = (TextView) findViewById(R.id.bmb);
        AppMethodBeat.o(825);
    }

    public final void setBusinessTip(String str) {
        AppMethodBeat.i(826);
        if (TextUtils.isEmpty(str) || this.mef == null) {
            AppMethodBeat.o(826);
            return;
        }
        ab.d(this.TAG, "business tip is : ".concat(String.valueOf(str)));
        this.mef.setText(str);
        AppMethodBeat.o(826);
    }

    public final void a(byte[] bArr, String str, String str2, String str3) {
        AppMethodBeat.i(827);
        ab.d(this.TAG, "initCamera : bioID=%s ,appID=%s ,userName=%s", str, str2, str3);
        this.mcZ = new b(this.BE.getContext(), (b) this);
        this.mcZ.mdy = this.mcS;
        this.mcZ.mdz = this.mdz;
        this.mcZ.mdA = this.mcO;
        this.mcZ.lWX = bArr;
        this.mcZ.mdC = str;
        this.mcZ.mAppId = str2;
        this.mcZ.edV = str3;
        this.mcZ.mdD = this.mcR;
        AppMethodBeat.o(827);
    }

    public final void bua() {
        AppMethodBeat.i(828);
        ab.i(this.TAG, "finish ReflectUI");
        FaceReflectMask faceReflectMask = this.mdz;
        faceReflectMask.mdZ = true;
        faceReflectMask.mcM = true;
        faceReflectMask.invalidate();
        this.mdz.setBackgroundColor(WebView.NIGHT_MODE_COLOR);
        this.mcZ.stopPreview();
        setVisibility(8);
        this.meg.setVisibility(0);
        AppMethodBeat.o(828);
    }

    public final void bub() {
        AppMethodBeat.i(829);
        ab.i(this.TAG, "reflectLoadAnimation()");
        final int width = this.mdz.getWidth();
        final int height = this.mdz.getHeight();
        final RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(2500);
        rotateAnimation.setRepeatCount(-1);
        this.meg.setVisibility(4);
        this.meg.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(824);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) a.this.meg.getLayoutParams();
                marginLayoutParams.width = (int) (((double) width) * 0.7d);
                marginLayoutParams.height = (int) (((double) width) * 0.7d);
                marginLayoutParams.topMargin = (int) ((((double) height) * 0.4d) - (((double) width) * 0.35d));
                a.this.meg.setLayoutParams(marginLayoutParams);
                a.this.meg.setVisibility(0);
                a.this.meg.startAnimation(rotateAnimation);
                AppMethodBeat.o(824);
            }
        });
        this.mee.setVisibility(4);
        AppMethodBeat.o(829);
    }

    public final void buc() {
        AppMethodBeat.i(830);
        this.mef.setVisibility(0);
        AppMethodBeat.o(830);
    }

    public final void resume() {
        AppMethodBeat.i(831);
        ab.i(this.TAG, " FaceReflect Preview UI resume");
        if (this.mcZ != null) {
            this.mcZ.a(this.mcQ);
            this.mcZ.btX();
            this.mcZ.mdx = true;
            this.mcS.setText(R.string.bld);
        }
        AppMethodBeat.o(831);
    }

    public final void aB(int i, String str) {
        AppMethodBeat.i(833);
        this.mds.a(1, i, str, null);
        AppMethodBeat.o(833);
    }

    public final void Ly(String str) {
        AppMethodBeat.i(834);
        ab.i(this.TAG, "callbackDetectSuccess()");
        Bundle bundle = new Bundle();
        bundle.putString("key_bio_buffer_path", str);
        this.mds.a(0, 0, "collect data ok", bundle);
        AppMethodBeat.o(834);
    }

    public final void u(int i, String str, String str2) {
        AppMethodBeat.i(835);
        ab.i(this.TAG, "callbackDetectFailed()");
        Bundle bundle = new Bundle();
        bundle.putString("show_err_msg", str2);
        this.mds.a(4, i, str, bundle);
        AppMethodBeat.o(835);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x00fb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bsk() {
        IOException e;
        int initModel;
        boolean z;
        AppMethodBeat.i(832);
        com.tencent.mm.plugin.facedetectlight.ui.c.a.mdY;
        ab.i("MicroMsg.FaceReflectLogic", "initAuth()");
        int initAuth = YTCommonExInterface.initAuth(ah.getContext(), "rel_wechat_2055-12-06.lic1.2", 0, false);
        ab.i(this.TAG, "auth：".concat(String.valueOf(initAuth)));
        if (initAuth != 0) {
            ab.i(this.TAG, "initAuth failed");
            h.pYm.a(917, 29, 1, false);
            AppMethodBeat.o(832);
            return;
        }
        byte[] bArr;
        byte[] bArr2;
        ab.i(this.TAG, "initAuth success");
        h.pYm.a(917, 28, 1, false);
        c btY = com.tencent.mm.plugin.facedetectlight.ui.c.a.mdY;
        Activity activity = (Activity) this.BE.getContext();
        ab.i("MicroMsg.FaceReflectLogic", "initYoutuInstance()");
        try {
            InputStream open = ah.getContext().getAssets().open("face_detect" + File.separator + "ufdmtcc.bin");
            InputStream open2 = ah.getContext().getAssets().open("face_detect" + File.separator + "ufat.bin");
            bArr = new byte[open.available()];
            try {
                open.read(bArr);
                bArr2 = new byte[open2.available()];
                try {
                    open2.read(bArr2);
                    open.close();
                    open2.close();
                } catch (IOException e2) {
                    e = e2;
                    ab.i("MicroMsg.FaceReflectLogic", "load ufat.bin or ufdmtcc.bin failed" + e.getMessage());
                    initModel = YTFaceTraceInterface.initModel(bArr, bArr2);
                    ab.i("MicroMsg.FaceReflectLogic", "YTFaceTraceInterface.initModel ret: %s", Integer.valueOf(initModel));
                    if (initModel == 0) {
                    }
                    if (z) {
                    }
                    btY.mState = 0;
                    btY.mdI = this;
                    AppMethodBeat.o(832);
                }
            } catch (IOException e3) {
                e = e3;
                bArr2 = null;
                ab.i("MicroMsg.FaceReflectLogic", "load ufat.bin or ufdmtcc.bin failed" + e.getMessage());
                initModel = YTFaceTraceInterface.initModel(bArr, bArr2);
                ab.i("MicroMsg.FaceReflectLogic", "YTFaceTraceInterface.initModel ret: %s", Integer.valueOf(initModel));
                if (initModel == 0) {
                }
                if (z) {
                }
                btY.mState = 0;
                btY.mdI = this;
                AppMethodBeat.o(832);
            }
        } catch (IOException e4) {
            e = e4;
            bArr2 = null;
            bArr = null;
            ab.i("MicroMsg.FaceReflectLogic", "load ufat.bin or ufdmtcc.bin failed" + e.getMessage());
            initModel = YTFaceTraceInterface.initModel(bArr, bArr2);
            ab.i("MicroMsg.FaceReflectLogic", "YTFaceTraceInterface.initModel ret: %s", Integer.valueOf(initModel));
            if (initModel == 0) {
            }
            if (z) {
            }
            btY.mState = 0;
            btY.mdI = this;
            AppMethodBeat.o(832);
        }
        initModel = YTFaceTraceInterface.initModel(bArr, bArr2);
        ab.i("MicroMsg.FaceReflectLogic", "YTFaceTraceInterface.initModel ret: %s", Integer.valueOf(initModel));
        if (initModel == 0) {
            ab.i("MicroMsg.FaceReflectLogic", "YTFacePreviewInterface.initModel failed，return:".concat(String.valueOf(initModel)));
            z = false;
        } else {
            int initModel2 = YTAGReflectLiveCheckInterface.initModel(bArr, bArr2);
            if (initModel2 != 0) {
                ab.i("MicroMsg.FaceReflectLogic", "YTFacePreviewInterface.initModel failed，return:".concat(String.valueOf(initModel2)));
                z = false;
            } else {
                z = true;
            }
        }
        if (z) {
            YTCommonExInterface.setAppBrightness(activity, 255);
        }
        btY.mState = 0;
        btY.mdI = this;
        AppMethodBeat.o(832);
    }
}

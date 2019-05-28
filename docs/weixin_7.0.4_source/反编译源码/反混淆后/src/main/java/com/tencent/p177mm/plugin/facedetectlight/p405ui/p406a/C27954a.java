package com.tencent.p177mm.plugin.facedetectlight.p405ui.p406a;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.MMTextureView;
import com.tencent.p177mm.plugin.facedetectlight.p405ui.C11826a;
import com.tencent.p177mm.plugin.facedetectlight.p405ui.C11830b;
import com.tencent.p177mm.plugin.facedetectlight.p405ui.C11841c;
import com.tencent.p177mm.plugin.facedetectlight.p405ui.C11841c.C11840a;
import com.tencent.p177mm.plugin.facedetectlight.p405ui.FaceReflectMask;
import com.tencent.p177mm.plugin.facedetectlight.p405ui.PreviewFrameLayout;
import com.tencent.p177mm.plugin.facedetectlight.p405ui.container.C20670a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.smtt.sdk.WebView;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import com.tencent.youtu.ytcommon.YTCommonExInterface;
import com.tencent.youtu.ytfacetrace.YTFaceTraceInterface;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.tencent.mm.plugin.facedetectlight.ui.a.a */
public final class C27954a extends C11826a implements C20669b {
    PreviewFrameLayout mcO;
    MMTextureView mcQ;
    private ImageView mcR;
    public TextView mcS;
    public C11830b mcZ;
    public FaceReflectMask mdz;
    public ImageView mee;
    private TextView mef;
    ImageView meg;

    /* renamed from: com.tencent.mm.plugin.facedetectlight.ui.a.a$1 */
    public class C30631 implements Runnable {
        public final void run() {
            AppMethodBeat.m2504i(823);
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) C27954a.this.mee.getLayoutParams();
            marginLayoutParams.width = (int) (((double) C27954a.this.mdz.getWidth()) * 0.8d);
            marginLayoutParams.height = (int) (((double) C27954a.this.mdz.getWidth()) * 0.8d);
            marginLayoutParams.topMargin = (int) ((((double) C27954a.this.mdz.getHeight()) * 0.4d) - (((double) C27954a.this.mdz.getWidth()) * 0.4d));
            C27954a.this.mee.setLayoutParams(marginLayoutParams);
            C27954a.this.mee.setVisibility(0);
            C27954a.this.mcO.setVisibility(0);
            C27954a.this.mcQ.setVisibility(0);
            C27954a c27954a = C27954a.this;
            C4990ab.m7416i(c27954a.TAG, "beginLoadAnimation()");
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setDuration(1000);
            c27954a.mee.startAnimation(rotateAnimation);
            AppMethodBeat.m2505o(823);
        }
    }

    public C27954a(ViewGroup viewGroup, C20670a c20670a) {
        super(viewGroup, c20670a);
    }

    public final int btU() {
        return 2130969466;
    }

    public final void initView() {
        AppMethodBeat.m2504i(825);
        this.mcR = (ImageView) findViewById(2131823758);
        this.mcO = (PreviewFrameLayout) findViewById(2131823756);
        this.mcQ = (MMTextureView) findViewById(2131823757);
        this.mdz = (FaceReflectMask) findViewById(2131823760);
        this.mee = (ImageView) findViewById(2131823782);
        this.mcS = (TextView) findViewById(2131823761);
        this.meg = (ImageView) findViewById(2131823783);
        this.mef = (TextView) findViewById(2131823775);
        AppMethodBeat.m2505o(825);
    }

    public final void setBusinessTip(String str) {
        AppMethodBeat.m2504i(826);
        if (TextUtils.isEmpty(str) || this.mef == null) {
            AppMethodBeat.m2505o(826);
            return;
        }
        C4990ab.m7410d(this.TAG, "business tip is : ".concat(String.valueOf(str)));
        this.mef.setText(str);
        AppMethodBeat.m2505o(826);
    }

    /* renamed from: a */
    public final void mo45870a(byte[] bArr, String str, String str2, String str3) {
        AppMethodBeat.m2504i(827);
        C4990ab.m7411d(this.TAG, "initCamera : bioID=%s ,appID=%s ,userName=%s", str, str2, str3);
        this.mcZ = new C11830b(this.f2906BE.getContext(), (C20669b) this);
        this.mcZ.mdy = this.mcS;
        this.mcZ.mdz = this.mdz;
        this.mcZ.mdA = this.mcO;
        this.mcZ.lWX = bArr;
        this.mcZ.mdC = str;
        this.mcZ.mAppId = str2;
        this.mcZ.edV = str3;
        this.mcZ.mdD = this.mcR;
        AppMethodBeat.m2505o(827);
    }

    public final void bua() {
        AppMethodBeat.m2504i(828);
        C4990ab.m7416i(this.TAG, "finish ReflectUI");
        FaceReflectMask faceReflectMask = this.mdz;
        faceReflectMask.mdZ = true;
        faceReflectMask.mcM = true;
        faceReflectMask.invalidate();
        this.mdz.setBackgroundColor(WebView.NIGHT_MODE_COLOR);
        this.mcZ.stopPreview();
        setVisibility(8);
        this.meg.setVisibility(0);
        AppMethodBeat.m2505o(828);
    }

    public final void bub() {
        AppMethodBeat.m2504i(829);
        C4990ab.m7416i(this.TAG, "reflectLoadAnimation()");
        final int width = this.mdz.getWidth();
        final int height = this.mdz.getHeight();
        final RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(2500);
        rotateAnimation.setRepeatCount(-1);
        this.meg.setVisibility(4);
        this.meg.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(824);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) C27954a.this.meg.getLayoutParams();
                marginLayoutParams.width = (int) (((double) width) * 0.7d);
                marginLayoutParams.height = (int) (((double) width) * 0.7d);
                marginLayoutParams.topMargin = (int) ((((double) height) * 0.4d) - (((double) width) * 0.35d));
                C27954a.this.meg.setLayoutParams(marginLayoutParams);
                C27954a.this.meg.setVisibility(0);
                C27954a.this.meg.startAnimation(rotateAnimation);
                AppMethodBeat.m2505o(824);
            }
        });
        this.mee.setVisibility(4);
        AppMethodBeat.m2505o(829);
    }

    public final void buc() {
        AppMethodBeat.m2504i(830);
        this.mef.setVisibility(0);
        AppMethodBeat.m2505o(830);
    }

    public final void resume() {
        AppMethodBeat.m2504i(831);
        C4990ab.m7416i(this.TAG, " FaceReflect Preview UI resume");
        if (this.mcZ != null) {
            this.mcZ.mo23643a(this.mcQ);
            this.mcZ.btX();
            this.mcZ.mdx = true;
            this.mcS.setText(C25738R.string.bld);
        }
        AppMethodBeat.m2505o(831);
    }

    /* renamed from: aB */
    public final void mo35968aB(int i, String str) {
        AppMethodBeat.m2504i(833);
        this.mds.mo35973a(1, i, str, null);
        AppMethodBeat.m2505o(833);
    }

    /* renamed from: Ly */
    public final void mo35967Ly(String str) {
        AppMethodBeat.m2504i(834);
        C4990ab.m7416i(this.TAG, "callbackDetectSuccess()");
        Bundle bundle = new Bundle();
        bundle.putString("key_bio_buffer_path", str);
        this.mds.mo35973a(0, 0, "collect data ok", bundle);
        AppMethodBeat.m2505o(834);
    }

    /* renamed from: u */
    public final void mo35972u(int i, String str, String str2) {
        AppMethodBeat.m2504i(835);
        C4990ab.m7416i(this.TAG, "callbackDetectFailed()");
        Bundle bundle = new Bundle();
        bundle.putString("show_err_msg", str2);
        this.mds.mo35973a(4, i, str, bundle);
        AppMethodBeat.m2505o(835);
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
        AppMethodBeat.m2504i(832);
        C11840a.mdY;
        C4990ab.m7416i("MicroMsg.FaceReflectLogic", "initAuth()");
        int initAuth = YTCommonExInterface.initAuth(C4996ah.getContext(), "rel_wechat_2055-12-06.lic1.2", 0, false);
        C4990ab.m7416i(this.TAG, "auth：".concat(String.valueOf(initAuth)));
        if (initAuth != 0) {
            C4990ab.m7416i(this.TAG, "initAuth failed");
            C7060h.pYm.mo8378a(917, 29, 1, false);
            AppMethodBeat.m2505o(832);
            return;
        }
        byte[] bArr;
        byte[] bArr2;
        C4990ab.m7416i(this.TAG, "initAuth success");
        C7060h.pYm.mo8378a(917, 28, 1, false);
        C11841c btY = C11840a.mdY;
        Activity activity = (Activity) this.f2906BE.getContext();
        C4990ab.m7416i("MicroMsg.FaceReflectLogic", "initYoutuInstance()");
        try {
            InputStream open = C4996ah.getContext().getAssets().open("face_detect" + File.separator + "ufdmtcc.bin");
            InputStream open2 = C4996ah.getContext().getAssets().open("face_detect" + File.separator + "ufat.bin");
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
                    C4990ab.m7416i("MicroMsg.FaceReflectLogic", "load ufat.bin or ufdmtcc.bin failed" + e.getMessage());
                    initModel = YTFaceTraceInterface.initModel(bArr, bArr2);
                    C4990ab.m7417i("MicroMsg.FaceReflectLogic", "YTFaceTraceInterface.initModel ret: %s", Integer.valueOf(initModel));
                    if (initModel == 0) {
                    }
                    if (z) {
                    }
                    btY.mState = 0;
                    btY.mdI = this;
                    AppMethodBeat.m2505o(832);
                }
            } catch (IOException e3) {
                e = e3;
                bArr2 = null;
                C4990ab.m7416i("MicroMsg.FaceReflectLogic", "load ufat.bin or ufdmtcc.bin failed" + e.getMessage());
                initModel = YTFaceTraceInterface.initModel(bArr, bArr2);
                C4990ab.m7417i("MicroMsg.FaceReflectLogic", "YTFaceTraceInterface.initModel ret: %s", Integer.valueOf(initModel));
                if (initModel == 0) {
                }
                if (z) {
                }
                btY.mState = 0;
                btY.mdI = this;
                AppMethodBeat.m2505o(832);
            }
        } catch (IOException e4) {
            e = e4;
            bArr2 = null;
            bArr = null;
            C4990ab.m7416i("MicroMsg.FaceReflectLogic", "load ufat.bin or ufdmtcc.bin failed" + e.getMessage());
            initModel = YTFaceTraceInterface.initModel(bArr, bArr2);
            C4990ab.m7417i("MicroMsg.FaceReflectLogic", "YTFaceTraceInterface.initModel ret: %s", Integer.valueOf(initModel));
            if (initModel == 0) {
            }
            if (z) {
            }
            btY.mState = 0;
            btY.mdI = this;
            AppMethodBeat.m2505o(832);
        }
        initModel = YTFaceTraceInterface.initModel(bArr, bArr2);
        C4990ab.m7417i("MicroMsg.FaceReflectLogic", "YTFaceTraceInterface.initModel ret: %s", Integer.valueOf(initModel));
        if (initModel == 0) {
            C4990ab.m7416i("MicroMsg.FaceReflectLogic", "YTFacePreviewInterface.initModel failed，return:".concat(String.valueOf(initModel)));
            z = false;
        } else {
            int initModel2 = YTAGReflectLiveCheckInterface.initModel(bArr, bArr2);
            if (initModel2 != 0) {
                C4990ab.m7416i("MicroMsg.FaceReflectLogic", "YTFacePreviewInterface.initModel failed，return:".concat(String.valueOf(initModel2)));
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
        AppMethodBeat.m2505o(832);
    }
}

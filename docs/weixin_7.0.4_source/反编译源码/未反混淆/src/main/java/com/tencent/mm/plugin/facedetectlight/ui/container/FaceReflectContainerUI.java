package com.tencent.mm.plugin.facedetectlight.ui.container;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.RotateAnimation;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.plugin.facedetect.c.f;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetectlight.ui.c;
import com.tencent.mm.plugin.facedetectlight.ui.d;
import com.tencent.mm.plugin.facedetectlight.ui.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.youtu.ytcommon.YTCommonExInterface;

@a(3)
public class FaceReflectContainerUI extends MMActivity implements OnClickListener, f, a {
    private String edV;
    private byte[] lWX;
    private String lXd;
    private String mAppId;
    private String mdC;
    private com.tencent.mm.plugin.facedetectlight.ui.a.a mea;
    private d meb;
    private e mec;
    private TextView med;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static {
        AppMethodBeat.i(822);
        k.a("YTCommonEx", FaceReflectContainerUI.class.getClassLoader());
        k.a("YTFaceTrace", FaceReflectContainerUI.class.getClassLoader());
        k.a("YTNextCV", FaceReflectContainerUI.class.getClassLoader());
        k.a("YTAGReflectLiveCheck", FaceReflectContainerUI.class.getClassLoader());
        YTCommonExInterface.setBusinessCode(1);
        AppMethodBeat.o(822);
    }

    public final int getLayoutId() {
        return R.layout.x_;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(810);
        ab.d("MicroMsg.FaceReflectContainerUI", "start VerifyActivity");
        super.onCreate(bundle);
        YTCommonExInterface.setIsEnabledLog(true);
        YTCommonExInterface.setIsEnabledNativeLog(true);
        getWindow().addFlags(2097280);
        ab.d("MicroMsg.FaceReflectContainerUI", "getData");
        this.mAppId = getIntent().getStringExtra("k_app_id");
        this.edV = getIntent().getStringExtra("k_user_name");
        this.lWX = getIntent().getByteArrayExtra("k_bio_config");
        this.mdC = getIntent().getStringExtra("k_bio_id");
        this.lXd = getIntent().getStringExtra("business_tips");
        ab.i("MicroMsg.FaceReflectContainerUI", "mConfig " + this.lWX);
        ab.i("MicroMsg.FaceReflectContainerUI", "mBioID is %s", this.mdC);
        ab.i("MicroMsg.FaceReflectContainerUI", "mAppID is %s", this.mAppId);
        ab.i("MicroMsg.FaceReflectContainerUI", "mBusinessTip is %s", this.lXd);
        FaceDetectReporter faceDetectReporter = (FaceDetectReporter) getIntent().getBundleExtra("key_reporter_bundle").getParcelable("key_parcelable_reporter");
        if (faceDetectReporter != null) {
            FaceDetectReporter.bsJ().a(faceDetectReporter);
        }
        FaceDetectReporter.bsJ().appId = this.mAppId;
        FaceDetectReporter.bsJ().lUv = 6;
        if (p.M(this)) {
            ab.i("MicroMsg.FaceReflectContainerUI", "carson: checkFacePermissionAnd Request true and do init ");
            btZ();
            bsk();
            AppMethodBeat.o(810);
            return;
        }
        ab.i("MicroMsg.FaceReflectContainerUI", "carson: no camera permission. request permission");
        AppMethodBeat.o(810);
    }

    public final void bsk() {
        AppMethodBeat.i(811);
        this.mea.bsk();
        AppMethodBeat.o(811);
    }

    private void btZ() {
        AppMethodBeat.i(812);
        ab.d("MicroMsg.FaceReflectContainerUI", "initLayout");
        this.med = (TextView) findViewById(R.id.bmh);
        this.med.setOnClickListener(this);
        this.mea = new com.tencent.mm.plugin.facedetectlight.ui.a.a((ViewGroup) findViewById(R.id.bls), this);
        this.meb = new d((ViewGroup) findViewById(R.id.bmg), this);
        this.mec = new e((ViewGroup) findViewById(R.id.blo), this);
        this.mea.setBusinessTip(this.lXd);
        AppMethodBeat.o(812);
    }

    public void onResume() {
        AppMethodBeat.i(813);
        super.onResume();
        if (this.mea != null) {
            this.mea.resume();
        }
        AppMethodBeat.o(813);
    }

    public void onStop() {
        AppMethodBeat.i(814);
        super.onStop();
        if (this.mea != null) {
            com.tencent.mm.plugin.facedetectlight.ui.a.a aVar = this.mea;
            ab.i(aVar.TAG, " FaceReflect Preview UI pause");
            if (aVar.mcZ != null) {
                aVar.mcZ.lXB = false;
            }
        }
        AppMethodBeat.o(814);
    }

    public void onDestroy() {
        AppMethodBeat.i(815);
        super.onDestroy();
        ab.i("MicroMsg.FaceReflectContainerUI", "onDestroy");
        c.a.mdY.release();
        AppMethodBeat.o(815);
    }

    public final void startPreview() {
        AppMethodBeat.i(816);
        this.med.setTextColor(-1);
        com.tencent.mm.plugin.facedetectlight.ui.a.a aVar = this.mea;
        aVar.a(this.lWX, this.mdC, this.mAppId, this.edV);
        aVar.mdz.setVisibility(0);
        aVar.mee.setVisibility(4);
        aVar.mee.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(823);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) a.this.mee.getLayoutParams();
                marginLayoutParams.width = (int) (((double) a.this.mdz.getWidth()) * 0.8d);
                marginLayoutParams.height = (int) (((double) a.this.mdz.getWidth()) * 0.8d);
                marginLayoutParams.topMargin = (int) ((((double) a.this.mdz.getHeight()) * 0.4d) - (((double) a.this.mdz.getWidth()) * 0.4d));
                a.this.mee.setLayoutParams(marginLayoutParams);
                a.this.mee.setVisibility(0);
                a.this.mcO.setVisibility(0);
                a.this.mcQ.setVisibility(0);
                a aVar = a.this;
                ab.i(aVar.TAG, "beginLoadAnimation()");
                RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
                rotateAnimation.setDuration(1000);
                aVar.mee.startAnimation(rotateAnimation);
                AppMethodBeat.o(823);
            }
        });
        aVar.resume();
        aVar.mcS.setVisibility(0);
        FaceDetectReporter.bsJ().H(0, System.currentTimeMillis());
        AppMethodBeat.o(816);
    }

    public final void a(int i, int i2, String str, Bundle bundle) {
        AppMethodBeat.i(817);
        ab.i("MicroMsg.FaceReflectContainerUI", "finishWithResult errType: %d, errCode: %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i != 0 && i2 != 0 && com.tencent.mm.plugin.facedetect.e.a.btw().isStarted() && com.tencent.mm.plugin.facedetect.e.a.btw().lZc) {
            com.tencent.mm.plugin.facedetect.e.a.btw().bty();
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("key_parcelable_reporter", FaceDetectReporter.bsJ());
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        Bundle bundle3 = new Bundle();
        bundle3.putInt("err_type", i);
        bundle3.putInt("err_code", i2);
        bundle3.putString("err_msg", str);
        bundle3.putString("k_bio_id", this.mdC);
        bundle3.putAll(bundle2);
        Intent intent = new Intent();
        intent.putExtras(bundle3);
        setResult(-1, intent);
        finish();
        AppMethodBeat.o(817);
    }

    public void onBackPressed() {
        AppMethodBeat.i(818);
        super.onBackPressed();
        c.a.mdY.onBackPressed();
        AppMethodBeat.o(818);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(820);
        ab.i("MicroMsg.FaceReflectContainerUI", "carson onRequestPermissionsResult");
        if (iArr == null || iArr.length <= 0) {
            AppMethodBeat.o(820);
            return;
        }
        switch (i) {
            case 23:
                btZ();
                this.mea.bsk();
                break;
        }
        AppMethodBeat.o(820);
    }

    public final void a(boolean z, boolean z2, com.tencent.mm.plugin.facedetect.ui.c cVar) {
    }

    public final void d(int i, int i2, String str, Bundle bundle) {
    }

    public final void bsp() {
    }

    public final void bsm() {
        AppMethodBeat.i(138983);
        c.a.mdY.release();
        AppMethodBeat.o(138983);
    }

    public void onClick(View view) {
        AppMethodBeat.i(821);
        c.a.mdY.onBackPressed();
        finish();
        AppMethodBeat.o(821);
    }
}

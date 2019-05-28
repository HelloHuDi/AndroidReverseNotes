package com.tencent.p177mm.plugin.facedetectlight.p405ui.container;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1449k;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.facedetect.model.C43036p;
import com.tencent.p177mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.p177mm.plugin.facedetect.p400c.C11795f;
import com.tencent.p177mm.plugin.facedetect.p402e.C27922a;
import com.tencent.p177mm.plugin.facedetect.p403ui.C3048c;
import com.tencent.p177mm.plugin.facedetectlight.p405ui.C11841c.C11840a;
import com.tencent.p177mm.plugin.facedetectlight.p405ui.C27955d;
import com.tencent.p177mm.plugin.facedetectlight.p405ui.C39035e;
import com.tencent.p177mm.plugin.facedetectlight.p405ui.p406a.C27954a;
import com.tencent.p177mm.plugin.facedetectlight.p405ui.p406a.C27954a.C30631;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.youtu.ytcommon.YTCommonExInterface;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.facedetectlight.ui.container.FaceReflectContainerUI */
public class FaceReflectContainerUI extends MMActivity implements OnClickListener, C11795f, C20670a {
    private String edV;
    private byte[] lWX;
    private String lXd;
    private String mAppId;
    private String mdC;
    private C27954a mea;
    private C27955d meb;
    private C39035e mec;
    private TextView med;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    static {
        AppMethodBeat.m2504i(822);
        C1449k.m3079a("YTCommonEx", FaceReflectContainerUI.class.getClassLoader());
        C1449k.m3079a("YTFaceTrace", FaceReflectContainerUI.class.getClassLoader());
        C1449k.m3079a("YTNextCV", FaceReflectContainerUI.class.getClassLoader());
        C1449k.m3079a("YTAGReflectLiveCheck", FaceReflectContainerUI.class.getClassLoader());
        YTCommonExInterface.setBusinessCode(1);
        AppMethodBeat.m2505o(822);
    }

    public final int getLayoutId() {
        return 2130969465;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(810);
        C4990ab.m7410d("MicroMsg.FaceReflectContainerUI", "start VerifyActivity");
        super.onCreate(bundle);
        YTCommonExInterface.setIsEnabledLog(true);
        YTCommonExInterface.setIsEnabledNativeLog(true);
        getWindow().addFlags(2097280);
        C4990ab.m7410d("MicroMsg.FaceReflectContainerUI", "getData");
        this.mAppId = getIntent().getStringExtra("k_app_id");
        this.edV = getIntent().getStringExtra("k_user_name");
        this.lWX = getIntent().getByteArrayExtra("k_bio_config");
        this.mdC = getIntent().getStringExtra("k_bio_id");
        this.lXd = getIntent().getStringExtra("business_tips");
        C4990ab.m7416i("MicroMsg.FaceReflectContainerUI", "mConfig " + this.lWX);
        C4990ab.m7417i("MicroMsg.FaceReflectContainerUI", "mBioID is %s", this.mdC);
        C4990ab.m7417i("MicroMsg.FaceReflectContainerUI", "mAppID is %s", this.mAppId);
        C4990ab.m7417i("MicroMsg.FaceReflectContainerUI", "mBusinessTip is %s", this.lXd);
        FaceDetectReporter faceDetectReporter = (FaceDetectReporter) getIntent().getBundleExtra("key_reporter_bundle").getParcelable("key_parcelable_reporter");
        if (faceDetectReporter != null) {
            FaceDetectReporter.bsJ().mo54648a(faceDetectReporter);
        }
        FaceDetectReporter.bsJ().appId = this.mAppId;
        FaceDetectReporter.bsJ().lUv = 6;
        if (C43036p.m76428M(this)) {
            C4990ab.m7416i("MicroMsg.FaceReflectContainerUI", "carson: checkFacePermissionAnd Request true and do init ");
            btZ();
            bsk();
            AppMethodBeat.m2505o(810);
            return;
        }
        C4990ab.m7416i("MicroMsg.FaceReflectContainerUI", "carson: no camera permission. request permission");
        AppMethodBeat.m2505o(810);
    }

    public final void bsk() {
        AppMethodBeat.m2504i(811);
        this.mea.bsk();
        AppMethodBeat.m2505o(811);
    }

    private void btZ() {
        AppMethodBeat.m2504i(812);
        C4990ab.m7410d("MicroMsg.FaceReflectContainerUI", "initLayout");
        this.med = (TextView) findViewById(2131823781);
        this.med.setOnClickListener(this);
        this.mea = new C27954a((ViewGroup) findViewById(2131823755), this);
        this.meb = new C27955d((ViewGroup) findViewById(2131823780), this);
        this.mec = new C39035e((ViewGroup) findViewById(2131823751), this);
        this.mea.setBusinessTip(this.lXd);
        AppMethodBeat.m2505o(812);
    }

    public void onResume() {
        AppMethodBeat.m2504i(813);
        super.onResume();
        if (this.mea != null) {
            this.mea.resume();
        }
        AppMethodBeat.m2505o(813);
    }

    public void onStop() {
        AppMethodBeat.m2504i(814);
        super.onStop();
        if (this.mea != null) {
            C27954a c27954a = this.mea;
            C4990ab.m7416i(c27954a.TAG, " FaceReflect Preview UI pause");
            if (c27954a.mcZ != null) {
                c27954a.mcZ.lXB = false;
            }
        }
        AppMethodBeat.m2505o(814);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(815);
        super.onDestroy();
        C4990ab.m7416i("MicroMsg.FaceReflectContainerUI", "onDestroy");
        C11840a.mdY.release();
        AppMethodBeat.m2505o(815);
    }

    public final void startPreview() {
        AppMethodBeat.m2504i(816);
        this.med.setTextColor(-1);
        C27954a c27954a = this.mea;
        c27954a.mo45870a(this.lWX, this.mdC, this.mAppId, this.edV);
        c27954a.mdz.setVisibility(0);
        c27954a.mee.setVisibility(4);
        c27954a.mee.post(new C30631());
        c27954a.resume();
        c27954a.mcS.setVisibility(0);
        FaceDetectReporter.bsJ().mo54644H(0, System.currentTimeMillis());
        AppMethodBeat.m2505o(816);
    }

    /* renamed from: a */
    public final void mo23589a(int i, int i2, String str, Bundle bundle) {
        AppMethodBeat.m2504i(817);
        C4990ab.m7417i("MicroMsg.FaceReflectContainerUI", "finishWithResult errType: %d, errCode: %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i != 0 && i2 != 0 && C27922a.btw().isStarted() && C27922a.btw().lZc) {
            C27922a.btw().bty();
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
        AppMethodBeat.m2505o(817);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(818);
        super.onBackPressed();
        C11840a.mdY.onBackPressed();
        AppMethodBeat.m2505o(818);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(820);
        C4990ab.m7416i("MicroMsg.FaceReflectContainerUI", "carson onRequestPermissionsResult");
        if (iArr == null || iArr.length <= 0) {
            AppMethodBeat.m2505o(820);
            return;
        }
        switch (i) {
            case 23:
                btZ();
                this.mea.bsk();
                break;
        }
        AppMethodBeat.m2505o(820);
    }

    /* renamed from: a */
    public final void mo23590a(boolean z, boolean z2, C3048c c3048c) {
    }

    /* renamed from: d */
    public final void mo23594d(int i, int i2, String str, Bundle bundle) {
    }

    public final void bsp() {
    }

    public final void bsm() {
        AppMethodBeat.m2504i(138983);
        C11840a.mdY.release();
        AppMethodBeat.m2505o(138983);
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(821);
        C11840a.mdY.onBackPressed();
        finish();
        AppMethodBeat.m2505o(821);
    }
}

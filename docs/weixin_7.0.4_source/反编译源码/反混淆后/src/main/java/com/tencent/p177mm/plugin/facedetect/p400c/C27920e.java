package com.tencent.p177mm.plugin.facedetect.p400c;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.p177mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.p177mm.plugin.facedetect.p403ui.C3048c;
import com.tencent.p177mm.plugin.facedetect.p403ui.C34109a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.mm.plugin.facedetect.c.e */
public class C27920e extends C39010a {
    private static final String TAG = ("MicroMsg." + C27920e.class.getSimpleName());
    private boolean isRetry = false;
    private String lTl;
    private String lTm;
    private int lTn;

    static {
        AppMethodBeat.m2504i(JsApiGetBackgroundAudioState.CTRL_INDEX);
        AppMethodBeat.m2505o(JsApiGetBackgroundAudioState.CTRL_INDEX);
    }

    C27920e(Context context, C11795f c11795f, int i, int i2) {
        super(context, c11795f, i, i2);
        this.lTn = i;
    }

    public final C1207m bsn() {
        return null;
    }

    public final void onStart() {
        AppMethodBeat.m2504i(151);
        C4990ab.m7416i(TAG, "alvinluo onStart and create report session");
        FaceDetectReporter.bsJ().bsK();
        FaceDetectReporter.bsJ().mo54646R(FaceDetectReporter.m55883vl(this.lTn), this.isRetry);
        AppMethodBeat.m2505o(151);
    }

    public final void onRelease() {
        AppMethodBeat.m2504i(152);
        if (!FaceDetectReporter.bsJ().lUt) {
            FaceDetectReporter.bsJ().mo54651c(FaceDetectReporter.m55883vl(this.lTn), this.isRetry, 2, 1, 90006);
        }
        AppMethodBeat.m2505o(152);
    }

    /* renamed from: n */
    public final void mo7232n(int i, int i2, String str) {
        AppMethodBeat.m2504i(XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION);
        C4990ab.m7419v(TAG, "alvinluo onCollectEnd errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        AppMethodBeat.m2505o(XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION);
    }

    /* renamed from: c */
    public final boolean mo7230c(int i, String str, Bundle bundle) {
        AppMethodBeat.m2504i(JsApiMakeVoIPCall.CTRL_INDEX);
        C4990ab.m7417i(TAG, "alvinluo onUploadEnd errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(0), str);
        if (i != 0) {
            FaceDetectReporter.bsJ().mo54651c(FaceDetectReporter.m55883vl(this.lTn), this.isRetry, 1, 2, 90012);
            m44410o(i, 0, str);
            AppMethodBeat.m2505o(JsApiMakeVoIPCall.CTRL_INDEX);
            return true;
        } else if (bundle == null || C5046bo.isNullOrNil(bundle.getString("key_pic_cdn_id"))) {
            C4990ab.m7412e(TAG, "hy: not return cdn id!");
            m44410o(4, 6, "not return cdn id");
            AppMethodBeat.m2505o(JsApiMakeVoIPCall.CTRL_INDEX);
            return true;
        } else {
            this.lTl = bundle.getString("key_pic_cdn_id");
            this.lTm = bundle.getString("key_cdn_aes_key");
            C4990ab.m7419v(TAG, "hy: start upload: picCdnId: %s, aes key: %s", this.lTl, this.lTm);
            Bundle bundle2 = new Bundle();
            bundle2.putString("err_msg", str);
            bundle2.putString("key_pic_cdn_id", this.lTl);
            bundle2.putString("key_cdn_aes_key", this.lTm);
            bundle2.putInt("check_alive_type", this.lTf);
            mo61907a(i, 0, str, bundle2);
            AppMethodBeat.m2505o(JsApiMakeVoIPCall.CTRL_INDEX);
            return false;
        }
    }

    /* renamed from: g */
    public final void mo7231g(int i, int i2, String str, C1207m c1207m) {
    }

    /* renamed from: c */
    public final void mo7229c(int i, int i2, String str, Bundle bundle) {
    }

    /* renamed from: ax */
    public final void mo7226ax(int i, String str) {
        AppMethodBeat.m2504i(155);
        C4990ab.m7417i(TAG, "alvinluo onCancel, errCode: %d, errMsg: %s", Integer.valueOf(i), str);
        if (!FaceDetectReporter.bsJ().lUt) {
            FaceDetectReporter.bsJ().mo54651c(FaceDetectReporter.m55883vl(this.lTn), this.isRetry, 2, 1, i);
        }
        mo61907a(1, i, str, null);
        AppMethodBeat.m2505o(155);
    }

    public final Bundle bso() {
        AppMethodBeat.m2504i(156);
        Bundle bundle = new Bundle();
        bundle.putLong("k_bio_id", bsl());
        AppMethodBeat.m2505o(156);
        return bundle;
    }

    /* renamed from: o */
    private void m44410o(final int i, final int i2, final String str) {
        String string;
        AppMethodBeat.m2504i(157);
        mo61911b(i, i2, str, null);
        Context context = C4996ah.getContext();
        if (str == null) {
            string = context.getString(C25738R.string.bjk);
        } else {
            string = str;
        }
        C3048c b = C34109a.m55909b(C25738R.drawable.b33, string, context.getString(C25738R.string.blk), null, new OnClickListener() {
            final /* synthetic */ boolean lTp = false;
            final /* synthetic */ Bundle lTq;

            public final void onClick(View view) {
                AppMethodBeat.m2504i(149);
                if (this.lTp) {
                    C27920e.m44409a(C27920e.this);
                    AppMethodBeat.m2505o(149);
                    return;
                }
                C27920e.this.mo61907a(i, i2, str, this.lTq);
                AppMethodBeat.m2505o(149);
            }
        }, new OnClickListener() {
            final /* synthetic */ Bundle lTq = null;

            public final void onClick(View view) {
                AppMethodBeat.m2504i(150);
                C27920e.this.mo61907a(i, i2, str, this.lTq);
                AppMethodBeat.m2505o(150);
            }
        });
        b.status = 3;
        mo61910a(true, false, b);
        AppMethodBeat.m2505o(157);
    }

    /* renamed from: a */
    static /* synthetic */ void m44409a(C27920e c27920e) {
        AppMethodBeat.m2504i(158);
        c27920e.bsk();
        c27920e.isRetry = true;
        AppMethodBeat.m2505o(158);
    }
}

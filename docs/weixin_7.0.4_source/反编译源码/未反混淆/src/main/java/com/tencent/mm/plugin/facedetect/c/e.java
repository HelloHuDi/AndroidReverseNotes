package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.ui.a;
import com.tencent.mm.plugin.facedetect.ui.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import org.xwalk.core.XWalkEnvironment;

public class e extends a {
    private static final String TAG = ("MicroMsg." + e.class.getSimpleName());
    private boolean isRetry = false;
    private String lTl;
    private String lTm;
    private int lTn;

    static {
        AppMethodBeat.i(JsApiGetBackgroundAudioState.CTRL_INDEX);
        AppMethodBeat.o(JsApiGetBackgroundAudioState.CTRL_INDEX);
    }

    e(Context context, f fVar, int i, int i2) {
        super(context, fVar, i, i2);
        this.lTn = i;
    }

    public final m bsn() {
        return null;
    }

    public final void onStart() {
        AppMethodBeat.i(151);
        ab.i(TAG, "alvinluo onStart and create report session");
        FaceDetectReporter.bsJ().bsK();
        FaceDetectReporter.bsJ().R(FaceDetectReporter.vl(this.lTn), this.isRetry);
        AppMethodBeat.o(151);
    }

    public final void onRelease() {
        AppMethodBeat.i(152);
        if (!FaceDetectReporter.bsJ().lUt) {
            FaceDetectReporter.bsJ().c(FaceDetectReporter.vl(this.lTn), this.isRetry, 2, 1, 90006);
        }
        AppMethodBeat.o(152);
    }

    public final void n(int i, int i2, String str) {
        AppMethodBeat.i(XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION);
        ab.v(TAG, "alvinluo onCollectEnd errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        AppMethodBeat.o(XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION);
    }

    public final boolean c(int i, String str, Bundle bundle) {
        AppMethodBeat.i(JsApiMakeVoIPCall.CTRL_INDEX);
        ab.i(TAG, "alvinluo onUploadEnd errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(0), str);
        if (i != 0) {
            FaceDetectReporter.bsJ().c(FaceDetectReporter.vl(this.lTn), this.isRetry, 1, 2, 90012);
            o(i, 0, str);
            AppMethodBeat.o(JsApiMakeVoIPCall.CTRL_INDEX);
            return true;
        } else if (bundle == null || bo.isNullOrNil(bundle.getString("key_pic_cdn_id"))) {
            ab.e(TAG, "hy: not return cdn id!");
            o(4, 6, "not return cdn id");
            AppMethodBeat.o(JsApiMakeVoIPCall.CTRL_INDEX);
            return true;
        } else {
            this.lTl = bundle.getString("key_pic_cdn_id");
            this.lTm = bundle.getString("key_cdn_aes_key");
            ab.v(TAG, "hy: start upload: picCdnId: %s, aes key: %s", this.lTl, this.lTm);
            Bundle bundle2 = new Bundle();
            bundle2.putString("err_msg", str);
            bundle2.putString("key_pic_cdn_id", this.lTl);
            bundle2.putString("key_cdn_aes_key", this.lTm);
            bundle2.putInt("check_alive_type", this.lTf);
            a(i, 0, str, bundle2);
            AppMethodBeat.o(JsApiMakeVoIPCall.CTRL_INDEX);
            return false;
        }
    }

    public final void g(int i, int i2, String str, m mVar) {
    }

    public final void c(int i, int i2, String str, Bundle bundle) {
    }

    public final void ax(int i, String str) {
        AppMethodBeat.i(155);
        ab.i(TAG, "alvinluo onCancel, errCode: %d, errMsg: %s", Integer.valueOf(i), str);
        if (!FaceDetectReporter.bsJ().lUt) {
            FaceDetectReporter.bsJ().c(FaceDetectReporter.vl(this.lTn), this.isRetry, 2, 1, i);
        }
        a(1, i, str, null);
        AppMethodBeat.o(155);
    }

    public final Bundle bso() {
        AppMethodBeat.i(156);
        Bundle bundle = new Bundle();
        bundle.putLong("k_bio_id", bsl());
        AppMethodBeat.o(156);
        return bundle;
    }

    private void o(final int i, final int i2, final String str) {
        String string;
        AppMethodBeat.i(157);
        b(i, i2, str, null);
        Context context = ah.getContext();
        if (str == null) {
            string = context.getString(R.string.bjk);
        } else {
            string = str;
        }
        c b = a.b(R.drawable.b33, string, context.getString(R.string.blk), null, new OnClickListener() {
            final /* synthetic */ boolean lTp = false;
            final /* synthetic */ Bundle lTq;

            public final void onClick(View view) {
                AppMethodBeat.i(149);
                if (this.lTp) {
                    e.a(e.this);
                    AppMethodBeat.o(149);
                    return;
                }
                e.this.a(i, i2, str, this.lTq);
                AppMethodBeat.o(149);
            }
        }, new OnClickListener() {
            final /* synthetic */ Bundle lTq = null;

            public final void onClick(View view) {
                AppMethodBeat.i(150);
                e.this.a(i, i2, str, this.lTq);
                AppMethodBeat.o(150);
            }
        });
        b.status = 3;
        a(true, false, b);
        AppMethodBeat.o(157);
    }

    static /* synthetic */ void a(e eVar) {
        AppMethodBeat.i(158);
        eVar.bsk();
        eVar.isRetry = true;
        AppMethodBeat.o(158);
    }
}

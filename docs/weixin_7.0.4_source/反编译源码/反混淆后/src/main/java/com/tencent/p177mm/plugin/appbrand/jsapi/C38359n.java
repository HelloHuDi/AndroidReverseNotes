package com.tencent.p177mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.page.C38470q;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.n */
public abstract class C38359n extends C45611o implements C5186a {
    protected MMActivity hwd;
    private int hwe;

    /* renamed from: C */
    public abstract void mo6154C(Intent intent);

    /* renamed from: a */
    public abstract boolean mo6155a(MMActivity mMActivity, JSONObject jSONObject, int i);

    public abstract void onError(int i, String str);

    public C38359n(C45608m c45608m, C38492q c38492q, C44709u c44709u, JSONObject jSONObject, int i) {
        MMActivity mMActivity;
        super(c45608m, c38492q, c44709u, jSONObject, i);
        C38470q asV = c38492q.getRuntime().asV();
        if (asV == null) {
            mMActivity = null;
        } else {
            Context context = asV.getContext();
            if (context instanceof MMActivity) {
                mMActivity = (MMActivity) context;
            } else {
                mMActivity = null;
            }
        }
        this.hwd = mMActivity;
        if (this.hwd == null) {
            throw new IllegalArgumentException("JsApiActivityResultRequest. Activity is null");
        }
        this.hwe = c45608m.hashCode() & CdnLogic.kBizGeneric;
    }

    public final void run() {
        this.hwd.ifE = this;
        if (!mo6155a(this.hwd, aCg(), this.hwe)) {
            onError(-1, "fail:system error {{launch fail}}");
        }
    }

    /* renamed from: c */
    public final void mo6069c(int i, int i2, Intent intent) {
        if (this.hwe == i) {
            if (i2 == -1) {
                mo6154C(intent);
            } else if (intent == null || !intent.hasExtra("result_error_msg")) {
                onError(-1, "fail:system error {{unknow error}}");
            } else {
                onError(intent.getIntExtra("result_error_code", -1), intent.getStringExtra("result_error_msg"));
            }
        }
    }
}

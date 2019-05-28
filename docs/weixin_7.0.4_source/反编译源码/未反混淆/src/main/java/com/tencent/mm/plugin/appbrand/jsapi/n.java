package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import org.json.JSONObject;

public abstract class n extends o implements a {
    protected MMActivity hwd;
    private int hwe;

    public abstract void C(Intent intent);

    public abstract boolean a(MMActivity mMActivity, JSONObject jSONObject, int i);

    public abstract void onError(int i, String str);

    public n(m mVar, q qVar, u uVar, JSONObject jSONObject, int i) {
        MMActivity mMActivity;
        super(mVar, qVar, uVar, jSONObject, i);
        com.tencent.mm.plugin.appbrand.page.q asV = qVar.getRuntime().asV();
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
        this.hwe = mVar.hashCode() & CdnLogic.kBizGeneric;
    }

    public final void run() {
        this.hwd.ifE = this;
        if (!a(this.hwd, aCg(), this.hwe)) {
            onError(-1, "fail:system error {{launch fail}}");
        }
    }

    public final void c(int i, int i2, Intent intent) {
        if (this.hwe == i) {
            if (i2 == -1) {
                C(intent);
            } else if (intent == null || !intent.hasExtra("result_error_msg")) {
                onError(-1, "fail:system error {{unknow error}}");
            } else {
                onError(intent.getIntExtra("result_error_code", -1), intent.getStringExtra("result_error_msg"));
            }
        }
    }
}

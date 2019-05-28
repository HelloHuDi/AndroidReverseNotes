package com.tencent.p177mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelbase.BaseReq;
import com.tencent.p177mm.opensdk.modelbase.BaseResp;
import com.tencent.p177mm.opensdk.utils.C18754d;
import com.tencent.p177mm.opensdk.utils.Log;

/* renamed from: com.tencent.mm.opensdk.modelbiz.WXPayInsurance */
public class WXPayInsurance {

    /* renamed from: com.tencent.mm.opensdk.modelbiz.WXPayInsurance$Resp */
    public static final class Resp extends BaseResp {
        public String wxOrderId;

        public final boolean checkArgs() {
            return true;
        }

        public final void fromBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128168);
            super.fromBundle(bundle);
            this.wxOrderId = bundle.getString("_wxapi_pay_insourance_order_id");
            AppMethodBeat.m2505o(128168);
        }

        public final int getType() {
            return 22;
        }

        public final void toBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128167);
            super.fromBundle(bundle);
            bundle.putString("_wxapi_pay_insourance_order_id", this.wxOrderId);
            AppMethodBeat.m2505o(128167);
        }
    }

    /* renamed from: com.tencent.mm.opensdk.modelbiz.WXPayInsurance$Req */
    public static final class Req extends BaseReq {
        private static final String TAG = "MicroMsg.SDK.WXPayInsurance.Req";
        private static final int URL_LENGTH_LIMIT = 10240;
        public String url;

        public final boolean checkArgs() {
            AppMethodBeat.m2504i(128200);
            if (C18754d.m29305b(this.url)) {
                Log.m4141i(TAG, "url should not be empty");
                AppMethodBeat.m2505o(128200);
                return false;
            } else if (this.url.length() > 10240) {
                Log.m4140e(TAG, "url must be in 10k");
                AppMethodBeat.m2505o(128200);
                return false;
            } else {
                AppMethodBeat.m2505o(128200);
                return true;
            }
        }

        public final void fromBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128202);
            super.fromBundle(bundle);
            this.url = bundle.getString("_wxapi_pay_insourance_req_url");
            AppMethodBeat.m2505o(128202);
        }

        public final int getType() {
            return 22;
        }

        public final void toBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128201);
            super.fromBundle(bundle);
            bundle.putString("_wxapi_pay_insourance_req_url", this.url);
            AppMethodBeat.m2505o(128201);
        }
    }
}

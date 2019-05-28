package com.tencent.p177mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelbase.BaseReq;
import com.tencent.p177mm.opensdk.modelbase.BaseResp;
import com.tencent.p177mm.opensdk.utils.C18754d;
import com.tencent.p177mm.opensdk.utils.Log;

/* renamed from: com.tencent.mm.opensdk.modelbiz.WXNontaxPay */
public class WXNontaxPay {

    /* renamed from: com.tencent.mm.opensdk.modelbiz.WXNontaxPay$Resp */
    public static final class Resp extends BaseResp {
        public String wxOrderId;

        public final boolean checkArgs() {
            return true;
        }

        public final void fromBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128222);
            super.fromBundle(bundle);
            this.wxOrderId = bundle.getString("_wxapi_nontax_pay_order_id");
            AppMethodBeat.m2505o(128222);
        }

        public final int getType() {
            return 21;
        }

        public final void toBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128221);
            super.fromBundle(bundle);
            bundle.putString("_wxapi_nontax_pay_order_id", this.wxOrderId);
            AppMethodBeat.m2505o(128221);
        }
    }

    /* renamed from: com.tencent.mm.opensdk.modelbiz.WXNontaxPay$Req */
    public static final class Req extends BaseReq {
        private static final String TAG = "MicroMsg.SDK.WXNontaxPay.Req";
        private static final int URL_LENGTH_LIMIT = 10240;
        public String url;

        public final boolean checkArgs() {
            AppMethodBeat.m2504i(128228);
            if (C18754d.m29305b(this.url)) {
                Log.m4141i(TAG, "url should not be empty");
                AppMethodBeat.m2505o(128228);
                return false;
            } else if (this.url.length() > 10240) {
                Log.m4140e(TAG, "url must be in 10k");
                AppMethodBeat.m2505o(128228);
                return false;
            } else {
                AppMethodBeat.m2505o(128228);
                return true;
            }
        }

        public final void fromBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128230);
            super.fromBundle(bundle);
            this.url = bundle.getString("_wxapi_nontax_pay_req_url");
            AppMethodBeat.m2505o(128230);
        }

        public final int getType() {
            return 21;
        }

        public final void toBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128229);
            super.fromBundle(bundle);
            bundle.putString("_wxapi_nontax_pay_req_url", this.url);
            AppMethodBeat.m2505o(128229);
        }
    }
}

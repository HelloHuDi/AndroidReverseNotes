package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public class WXNontaxPay {

    public static final class Resp extends BaseResp {
        public String wxOrderId;

        public final boolean checkArgs() {
            return true;
        }

        public final void fromBundle(Bundle bundle) {
            AppMethodBeat.i(128222);
            super.fromBundle(bundle);
            this.wxOrderId = bundle.getString("_wxapi_nontax_pay_order_id");
            AppMethodBeat.o(128222);
        }

        public final int getType() {
            return 21;
        }

        public final void toBundle(Bundle bundle) {
            AppMethodBeat.i(128221);
            super.fromBundle(bundle);
            bundle.putString("_wxapi_nontax_pay_order_id", this.wxOrderId);
            AppMethodBeat.o(128221);
        }
    }

    public static final class Req extends BaseReq {
        private static final String TAG = "MicroMsg.SDK.WXNontaxPay.Req";
        private static final int URL_LENGTH_LIMIT = 10240;
        public String url;

        public final boolean checkArgs() {
            AppMethodBeat.i(128228);
            if (d.b(this.url)) {
                Log.i(TAG, "url should not be empty");
                AppMethodBeat.o(128228);
                return false;
            } else if (this.url.length() > 10240) {
                Log.e(TAG, "url must be in 10k");
                AppMethodBeat.o(128228);
                return false;
            } else {
                AppMethodBeat.o(128228);
                return true;
            }
        }

        public final void fromBundle(Bundle bundle) {
            AppMethodBeat.i(128230);
            super.fromBundle(bundle);
            this.url = bundle.getString("_wxapi_nontax_pay_req_url");
            AppMethodBeat.o(128230);
        }

        public final int getType() {
            return 21;
        }

        public final void toBundle(Bundle bundle) {
            AppMethodBeat.i(128229);
            super.fromBundle(bundle);
            bundle.putString("_wxapi_nontax_pay_req_url", this.url);
            AppMethodBeat.o(128229);
        }
    }
}

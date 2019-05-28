package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public class WXPayInsurance {

    public static final class Resp extends BaseResp {
        public String wxOrderId;

        public final boolean checkArgs() {
            return true;
        }

        public final void fromBundle(Bundle bundle) {
            AppMethodBeat.i(128168);
            super.fromBundle(bundle);
            this.wxOrderId = bundle.getString("_wxapi_pay_insourance_order_id");
            AppMethodBeat.o(128168);
        }

        public final int getType() {
            return 22;
        }

        public final void toBundle(Bundle bundle) {
            AppMethodBeat.i(128167);
            super.fromBundle(bundle);
            bundle.putString("_wxapi_pay_insourance_order_id", this.wxOrderId);
            AppMethodBeat.o(128167);
        }
    }

    public static final class Req extends BaseReq {
        private static final String TAG = "MicroMsg.SDK.WXPayInsurance.Req";
        private static final int URL_LENGTH_LIMIT = 10240;
        public String url;

        public final boolean checkArgs() {
            AppMethodBeat.i(128200);
            if (d.b(this.url)) {
                Log.i(TAG, "url should not be empty");
                AppMethodBeat.o(128200);
                return false;
            } else if (this.url.length() > 10240) {
                Log.e(TAG, "url must be in 10k");
                AppMethodBeat.o(128200);
                return false;
            } else {
                AppMethodBeat.o(128200);
                return true;
            }
        }

        public final void fromBundle(Bundle bundle) {
            AppMethodBeat.i(128202);
            super.fromBundle(bundle);
            this.url = bundle.getString("_wxapi_pay_insourance_req_url");
            AppMethodBeat.o(128202);
        }

        public final int getType() {
            return 22;
        }

        public final void toBundle(Bundle bundle) {
            AppMethodBeat.i(128201);
            super.fromBundle(bundle);
            bundle.putString("_wxapi_pay_insourance_req_url", this.url);
            AppMethodBeat.o(128201);
        }
    }
}

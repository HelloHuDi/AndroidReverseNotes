package com.tencent.p177mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelbase.BaseReq;
import com.tencent.p177mm.opensdk.modelbase.BaseResp;
import com.tencent.p177mm.opensdk.utils.C18754d;
import com.tencent.p177mm.opensdk.utils.Log;

/* renamed from: com.tencent.mm.opensdk.modelbiz.WXInvoiceAuthInsert */
public class WXInvoiceAuthInsert {

    /* renamed from: com.tencent.mm.opensdk.modelbiz.WXInvoiceAuthInsert$Resp */
    public static final class Resp extends BaseResp {
        public String wxOrderId;

        public final boolean checkArgs() {
            return true;
        }

        public final void fromBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128161);
            super.fromBundle(bundle);
            this.wxOrderId = bundle.getString("_wxapi_invoice_auth_insert_order_id");
            AppMethodBeat.m2505o(128161);
        }

        public final int getType() {
            return 20;
        }

        public final void toBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128160);
            super.fromBundle(bundle);
            bundle.putString("_wxapi_invoice_auth_insert_order_id", this.wxOrderId);
            AppMethodBeat.m2505o(128160);
        }
    }

    /* renamed from: com.tencent.mm.opensdk.modelbiz.WXInvoiceAuthInsert$Req */
    public static final class Req extends BaseReq {
        private static final String TAG = "MicroMsg.SDK.WXInvoiceAuthInsert.Req";
        private static final int URL_LENGTH_LIMIT = 10240;
        public String url;

        public final boolean checkArgs() {
            AppMethodBeat.m2504i(128157);
            if (C18754d.m29305b(this.url)) {
                Log.m4141i(TAG, "url should not be empty");
                AppMethodBeat.m2505o(128157);
                return false;
            } else if (this.url.length() > 10240) {
                Log.m4140e(TAG, "url must be in 10k");
                AppMethodBeat.m2505o(128157);
                return false;
            } else {
                AppMethodBeat.m2505o(128157);
                return true;
            }
        }

        public final void fromBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128159);
            super.fromBundle(bundle);
            this.url = bundle.getString("_wxapi_invoice_auth_insert_req_url");
            AppMethodBeat.m2505o(128159);
        }

        public final int getType() {
            return 20;
        }

        public final void toBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128158);
            super.fromBundle(bundle);
            bundle.putString("_wxapi_invoice_auth_insert_req_url", this.url);
            AppMethodBeat.m2505o(128158);
        }
    }
}

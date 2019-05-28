package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;

public final class SendAuth {

    public static class Req extends BaseReq {
        private static final int LENGTH_LIMIT = 1024;
        private static final String TAG = "MicroMsg.SDK.SendAuth.Req";
        public String scope;
        public String state;

        public Req(Bundle bundle) {
            AppMethodBeat.i(128249);
            fromBundle(bundle);
            AppMethodBeat.o(128249);
        }

        public boolean checkArgs() {
            AppMethodBeat.i(128252);
            if (this.scope == null || this.scope.length() == 0 || this.scope.length() > 1024) {
                Log.e(TAG, "checkArgs fail, scope is invalid");
                AppMethodBeat.o(128252);
                return false;
            } else if (this.state == null || this.state.length() <= 1024) {
                AppMethodBeat.o(128252);
                return true;
            } else {
                Log.e(TAG, "checkArgs fail, state is invalid");
                AppMethodBeat.o(128252);
                return false;
            }
        }

        public void fromBundle(Bundle bundle) {
            AppMethodBeat.i(128250);
            super.fromBundle(bundle);
            this.scope = bundle.getString("_wxapi_sendauth_req_scope");
            this.state = bundle.getString("_wxapi_sendauth_req_state");
            AppMethodBeat.o(128250);
        }

        public int getType() {
            return 1;
        }

        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(128251);
            super.toBundle(bundle);
            bundle.putString("_wxapi_sendauth_req_scope", this.scope);
            bundle.putString("_wxapi_sendauth_req_state", this.state);
            AppMethodBeat.o(128251);
        }
    }

    public static class Resp extends BaseResp {
        private static final int LENGTH_LIMIT = 1024;
        private static final String TAG = "MicroMsg.SDK.SendAuth.Resp";
        public String code;
        public String country;
        public String lang;
        public String state;
        public String url;

        public Resp(Bundle bundle) {
            AppMethodBeat.i(128263);
            fromBundle(bundle);
            AppMethodBeat.o(128263);
        }

        public boolean checkArgs() {
            AppMethodBeat.i(128266);
            if (this.state == null || this.state.length() <= 1024) {
                AppMethodBeat.o(128266);
                return true;
            }
            Log.e(TAG, "checkArgs fail, state is invalid");
            AppMethodBeat.o(128266);
            return false;
        }

        public void fromBundle(Bundle bundle) {
            AppMethodBeat.i(128264);
            super.fromBundle(bundle);
            this.code = bundle.getString("_wxapi_sendauth_resp_token");
            this.state = bundle.getString("_wxapi_sendauth_resp_state");
            this.url = bundle.getString("_wxapi_sendauth_resp_url");
            this.lang = bundle.getString("_wxapi_sendauth_resp_lang");
            this.country = bundle.getString("_wxapi_sendauth_resp_country");
            AppMethodBeat.o(128264);
        }

        public int getType() {
            return 1;
        }

        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(128265);
            super.toBundle(bundle);
            bundle.putString("_wxapi_sendauth_resp_token", this.code);
            bundle.putString("_wxapi_sendauth_resp_state", this.state);
            bundle.putString("_wxapi_sendauth_resp_url", this.url);
            bundle.putString("_wxapi_sendauth_resp_lang", this.lang);
            bundle.putString("_wxapi_sendauth_resp_country", this.country);
            AppMethodBeat.o(128265);
        }
    }

    private SendAuth() {
    }
}

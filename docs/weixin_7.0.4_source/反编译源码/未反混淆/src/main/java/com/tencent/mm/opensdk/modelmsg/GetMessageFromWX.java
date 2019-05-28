package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.Builder;
import com.tencent.mm.opensdk.utils.Log;

public final class GetMessageFromWX {

    public static class Req extends BaseReq {
        public String country;
        public String lang;
        public String username;

        public Req(Bundle bundle) {
            AppMethodBeat.i(128308);
            fromBundle(bundle);
            AppMethodBeat.o(128308);
        }

        public boolean checkArgs() {
            return true;
        }

        public void fromBundle(Bundle bundle) {
            AppMethodBeat.i(128310);
            super.fromBundle(bundle);
            this.lang = bundle.getString("_wxapi_getmessage_req_lang");
            this.country = bundle.getString("_wxapi_getmessage_req_country");
            AppMethodBeat.o(128310);
        }

        public int getType() {
            return 3;
        }

        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(128309);
            super.toBundle(bundle);
            bundle.putString("_wxapi_getmessage_req_lang", this.lang);
            bundle.putString("_wxapi_getmessage_req_country", this.country);
            AppMethodBeat.o(128309);
        }
    }

    public static class Resp extends BaseResp {
        private static final String TAG = "MicroMsg.SDK.GetMessageFromWX.Resp";
        public WXMediaMessage message;

        public Resp(Bundle bundle) {
            AppMethodBeat.i(128317);
            fromBundle(bundle);
            AppMethodBeat.o(128317);
        }

        public boolean checkArgs() {
            AppMethodBeat.i(128320);
            if (this.message == null) {
                Log.e(TAG, "checkArgs fail, message is null");
                AppMethodBeat.o(128320);
                return false;
            }
            boolean checkArgs = this.message.checkArgs();
            AppMethodBeat.o(128320);
            return checkArgs;
        }

        public void fromBundle(Bundle bundle) {
            AppMethodBeat.i(128318);
            super.fromBundle(bundle);
            this.message = Builder.fromBundle(bundle);
            AppMethodBeat.o(128318);
        }

        public int getType() {
            return 3;
        }

        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(128319);
            super.toBundle(bundle);
            bundle.putAll(Builder.toBundle(this.message));
            AppMethodBeat.o(128319);
        }
    }

    private GetMessageFromWX() {
    }
}

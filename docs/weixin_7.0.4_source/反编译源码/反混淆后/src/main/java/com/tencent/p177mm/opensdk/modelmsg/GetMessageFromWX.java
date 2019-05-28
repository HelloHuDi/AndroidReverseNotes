package com.tencent.p177mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelbase.BaseReq;
import com.tencent.p177mm.opensdk.modelbase.BaseResp;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage.Builder;
import com.tencent.p177mm.opensdk.utils.Log;

/* renamed from: com.tencent.mm.opensdk.modelmsg.GetMessageFromWX */
public final class GetMessageFromWX {

    /* renamed from: com.tencent.mm.opensdk.modelmsg.GetMessageFromWX$Req */
    public static class Req extends BaseReq {
        public String country;
        public String lang;
        public String username;

        public Req(Bundle bundle) {
            AppMethodBeat.m2504i(128308);
            fromBundle(bundle);
            AppMethodBeat.m2505o(128308);
        }

        public boolean checkArgs() {
            return true;
        }

        public void fromBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128310);
            super.fromBundle(bundle);
            this.lang = bundle.getString("_wxapi_getmessage_req_lang");
            this.country = bundle.getString("_wxapi_getmessage_req_country");
            AppMethodBeat.m2505o(128310);
        }

        public int getType() {
            return 3;
        }

        public void toBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128309);
            super.toBundle(bundle);
            bundle.putString("_wxapi_getmessage_req_lang", this.lang);
            bundle.putString("_wxapi_getmessage_req_country", this.country);
            AppMethodBeat.m2505o(128309);
        }
    }

    /* renamed from: com.tencent.mm.opensdk.modelmsg.GetMessageFromWX$Resp */
    public static class Resp extends BaseResp {
        private static final String TAG = "MicroMsg.SDK.GetMessageFromWX.Resp";
        public WXMediaMessage message;

        public Resp(Bundle bundle) {
            AppMethodBeat.m2504i(128317);
            fromBundle(bundle);
            AppMethodBeat.m2505o(128317);
        }

        public boolean checkArgs() {
            AppMethodBeat.m2504i(128320);
            if (this.message == null) {
                Log.m4140e(TAG, "checkArgs fail, message is null");
                AppMethodBeat.m2505o(128320);
                return false;
            }
            boolean checkArgs = this.message.checkArgs();
            AppMethodBeat.m2505o(128320);
            return checkArgs;
        }

        public void fromBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128318);
            super.fromBundle(bundle);
            this.message = Builder.fromBundle(bundle);
            AppMethodBeat.m2505o(128318);
        }

        public int getType() {
            return 3;
        }

        public void toBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128319);
            super.toBundle(bundle);
            bundle.putAll(Builder.toBundle(this.message));
            AppMethodBeat.m2505o(128319);
        }
    }

    private GetMessageFromWX() {
    }
}

package com.tencent.p177mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelbase.BaseReq;
import com.tencent.p177mm.opensdk.modelbase.BaseResp;
import com.tencent.p177mm.opensdk.utils.Log;

/* renamed from: com.tencent.mm.opensdk.modelmsg.LaunchFromWX */
public class LaunchFromWX {

    /* renamed from: com.tencent.mm.opensdk.modelmsg.LaunchFromWX$Resp */
    public static class Resp extends BaseResp {
        public Resp(Bundle bundle) {
            AppMethodBeat.m2504i(128262);
            fromBundle(bundle);
            AppMethodBeat.m2505o(128262);
        }

        public boolean checkArgs() {
            return true;
        }

        public int getType() {
            return 6;
        }
    }

    /* renamed from: com.tencent.mm.opensdk.modelmsg.LaunchFromWX$Req */
    public static class Req extends BaseReq {
        private static final int MESSAGE_ACTION_LENGTH_LIMIT = 2048;
        private static final int MESSAGE_EXT_LENGTH_LIMIT = 2048;
        private static final String TAG = "MicroMsg.SDK.LaunchFromWX.Req";
        public String country;
        public String lang;
        public String messageAction;
        public String messageExt;

        public Req(Bundle bundle) {
            AppMethodBeat.m2504i(128334);
            fromBundle(bundle);
            AppMethodBeat.m2505o(128334);
        }

        public boolean checkArgs() {
            AppMethodBeat.m2504i(128337);
            if (this.messageAction != null && this.messageAction.length() > 2048) {
                Log.m4140e(TAG, "checkArgs fail, messageAction is too long");
                AppMethodBeat.m2505o(128337);
                return false;
            } else if (this.messageExt == null || this.messageExt.length() <= 2048) {
                AppMethodBeat.m2505o(128337);
                return true;
            } else {
                Log.m4140e(TAG, "checkArgs fail, messageExt is too long");
                AppMethodBeat.m2505o(128337);
                return false;
            }
        }

        public void fromBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128336);
            super.fromBundle(bundle);
            this.messageAction = bundle.getString("_wxobject_message_action");
            this.messageExt = bundle.getString("_wxobject_message_ext");
            this.lang = bundle.getString("_wxapi_launch_req_lang");
            this.country = bundle.getString("_wxapi_launch_req_country");
            AppMethodBeat.m2505o(128336);
        }

        public int getType() {
            return 6;
        }

        public void toBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128335);
            super.toBundle(bundle);
            bundle.putString("_wxobject_message_action", this.messageAction);
            bundle.putString("_wxobject_message_ext", this.messageExt);
            bundle.putString("_wxapi_launch_req_lang", this.lang);
            bundle.putString("_wxapi_launch_req_country", this.country);
            AppMethodBeat.m2505o(128335);
        }
    }

    private LaunchFromWX() {
    }
}

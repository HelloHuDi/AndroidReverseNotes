package com.tencent.p177mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelbase.BaseReq;
import com.tencent.p177mm.opensdk.modelbase.BaseResp;
import com.tencent.p177mm.opensdk.utils.Log;

/* renamed from: com.tencent.mm.opensdk.modelbiz.SubscribeMessage */
public final class SubscribeMessage {

    /* renamed from: com.tencent.mm.opensdk.modelbiz.SubscribeMessage$Req */
    public static class Req extends BaseReq {
        private static final int LENGTH_LIMIT = 1024;
        private static final String TAG = "MicroMsg.SDK.SubscribeMessage.Req";
        public String reserved;
        public int scene;
        public String templateID;

        public Req(Bundle bundle) {
            AppMethodBeat.m2504i(128181);
            fromBundle(bundle);
            AppMethodBeat.m2505o(128181);
        }

        public boolean checkArgs() {
            AppMethodBeat.m2504i(128184);
            if (this.templateID == null || this.templateID.length() == 0) {
                Log.m4140e(TAG, "checkArgs fail, templateID is null");
                AppMethodBeat.m2505o(128184);
                return false;
            } else if (this.templateID.length() > 1024) {
                Log.m4140e(TAG, "checkArgs fail, templateID is too long");
                AppMethodBeat.m2505o(128184);
                return false;
            } else if (this.reserved == null || this.reserved.length() <= 1024) {
                AppMethodBeat.m2505o(128184);
                return true;
            } else {
                Log.m4140e(TAG, "checkArgs fail, reserved is too long");
                AppMethodBeat.m2505o(128184);
                return false;
            }
        }

        public void fromBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128182);
            super.fromBundle(bundle);
            this.scene = bundle.getInt("_wxapi_subscribemessage_req_scene");
            this.templateID = bundle.getString("_wxapi_subscribemessage_req_templateid");
            this.reserved = bundle.getString("_wxapi_subscribemessage_req_reserved");
            AppMethodBeat.m2505o(128182);
        }

        public int getType() {
            return 18;
        }

        public void toBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128183);
            super.toBundle(bundle);
            bundle.putInt("_wxapi_subscribemessage_req_scene", this.scene);
            bundle.putString("_wxapi_subscribemessage_req_templateid", this.templateID);
            bundle.putString("_wxapi_subscribemessage_req_reserved", this.reserved);
            AppMethodBeat.m2505o(128183);
        }
    }

    /* renamed from: com.tencent.mm.opensdk.modelbiz.SubscribeMessage$Resp */
    public static class Resp extends BaseResp {
        private static final String TAG = "MicroMsg.SDK.SubscribeMessage.Resp";
        public String action;
        public String reserved;
        public int scene;
        public String templateID;

        public Resp(Bundle bundle) {
            AppMethodBeat.m2504i(128225);
            fromBundle(bundle);
            AppMethodBeat.m2505o(128225);
        }

        public boolean checkArgs() {
            return true;
        }

        public void fromBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128226);
            super.fromBundle(bundle);
            this.templateID = bundle.getString("_wxapi_subscribemessage_resp_templateid");
            this.scene = bundle.getInt("_wxapi_subscribemessage_resp_scene");
            this.action = bundle.getString("_wxapi_subscribemessage_resp_action");
            this.reserved = bundle.getString("_wxapi_subscribemessage_resp_reserved");
            AppMethodBeat.m2505o(128226);
        }

        public int getType() {
            return 18;
        }

        public void toBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128227);
            super.toBundle(bundle);
            bundle.putString("_wxapi_subscribemessage_resp_templateid", this.templateID);
            bundle.putInt("_wxapi_subscribemessage_resp_scene", this.scene);
            bundle.putString("_wxapi_subscribemessage_resp_action", this.action);
            bundle.putString("_wxapi_subscribemessage_resp_reserved", this.reserved);
            AppMethodBeat.m2505o(128227);
        }
    }

    private SubscribeMessage() {
    }
}

package com.tencent.p177mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelbase.BaseReq;
import com.tencent.p177mm.opensdk.utils.Log;

/* renamed from: com.tencent.mm.opensdk.modelbiz.JumpToBizWebview */
public final class JumpToBizWebview {

    /* renamed from: com.tencent.mm.opensdk.modelbiz.JumpToBizWebview$Req */
    public static class Req extends BaseReq {
        private static final int EXT_MSG_LENGTH = 1024;
        private static final String TAG = "MicroMsg.SDK.JumpToBizWebview.Req";
        public String extMsg;
        public int scene = 1;
        public String toUserName;
        public int webType;

        public boolean checkArgs() {
            AppMethodBeat.m2504i(128234);
            if (this.toUserName == null || this.toUserName.length() <= 0) {
                Log.m4140e(TAG, "checkArgs fail, toUserName is invalid");
                AppMethodBeat.m2505o(128234);
                return false;
            } else if (this.extMsg == null || this.extMsg.length() <= 1024) {
                AppMethodBeat.m2505o(128234);
                return true;
            } else {
                Log.m4140e(TAG, "ext msg is not null, while the length exceed 1024 bytes");
                AppMethodBeat.m2505o(128234);
                return false;
            }
        }

        public int getType() {
            return 8;
        }

        public void toBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128235);
            super.toBundle(bundle);
            bundle.putString("_wxapi_jump_to_biz_webview_req_to_user_name", this.toUserName);
            bundle.putString("_wxapi_jump_to_biz_webview_req_ext_msg", this.extMsg);
            bundle.putInt("_wxapi_jump_to_biz_webview_req_web_type", this.webType);
            bundle.putInt("_wxapi_jump_to_biz_webview_req_scene", this.scene);
            AppMethodBeat.m2505o(128235);
        }
    }
}

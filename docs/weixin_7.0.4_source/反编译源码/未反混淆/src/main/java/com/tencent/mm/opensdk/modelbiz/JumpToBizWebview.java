package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.utils.Log;

public final class JumpToBizWebview {

    public static class Req extends BaseReq {
        private static final int EXT_MSG_LENGTH = 1024;
        private static final String TAG = "MicroMsg.SDK.JumpToBizWebview.Req";
        public String extMsg;
        public int scene = 1;
        public String toUserName;
        public int webType;

        public boolean checkArgs() {
            AppMethodBeat.i(128234);
            if (this.toUserName == null || this.toUserName.length() <= 0) {
                Log.e(TAG, "checkArgs fail, toUserName is invalid");
                AppMethodBeat.o(128234);
                return false;
            } else if (this.extMsg == null || this.extMsg.length() <= 1024) {
                AppMethodBeat.o(128234);
                return true;
            } else {
                Log.e(TAG, "ext msg is not null, while the length exceed 1024 bytes");
                AppMethodBeat.o(128234);
                return false;
            }
        }

        public int getType() {
            return 8;
        }

        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(128235);
            super.toBundle(bundle);
            bundle.putString("_wxapi_jump_to_biz_webview_req_to_user_name", this.toUserName);
            bundle.putString("_wxapi_jump_to_biz_webview_req_ext_msg", this.extMsg);
            bundle.putInt("_wxapi_jump_to_biz_webview_req_web_type", this.webType);
            bundle.putInt("_wxapi_jump_to_biz_webview_req_scene", this.scene);
            AppMethodBeat.o(128235);
        }
    }
}

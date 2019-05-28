package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.utils.Log;

public final class JumpToBizTempSession {
    public static final int SHOW_CHAT = 1;
    public static final int SHOW_MENU = 0;

    public static class Req extends BaseReq {
        private static final int MAX_SESSION_FROM_LENGTH = 1024;
        private static final String TAG = "MicroMsg.SDK.JumpToBizTempSession.Req";
        public String sessionFrom;
        public int showType;
        public String toUserName;

        public boolean checkArgs() {
            AppMethodBeat.i(128189);
            if (this.toUserName == null || this.toUserName.length() <= 0) {
                Log.e(TAG, "checkArgs fail, toUserName is invalid");
                AppMethodBeat.o(128189);
                return false;
            } else if (this.sessionFrom == null || this.sessionFrom.length() > 1024) {
                Log.e(TAG, "checkArgs fail, sessionFrom is invalid");
                AppMethodBeat.o(128189);
                return false;
            } else {
                AppMethodBeat.o(128189);
                return true;
            }
        }

        public int getType() {
            return 10;
        }

        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(128190);
            super.toBundle(bundle);
            bundle.putString("_wxapi_jump_to_biz_webview_req_to_user_name", this.toUserName);
            bundle.putString("_wxapi_jump_to_biz_webview_req_session_from", this.sessionFrom);
            bundle.putInt("_wxapi_jump_to_biz_webview_req_show_type", this.showType);
            AppMethodBeat.o(128190);
        }
    }
}

package com.tencent.p177mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelbase.BaseReq;
import com.tencent.p177mm.opensdk.utils.Log;

/* renamed from: com.tencent.mm.opensdk.modelbiz.JumpToBizTempSession */
public final class JumpToBizTempSession {
    public static final int SHOW_CHAT = 1;
    public static final int SHOW_MENU = 0;

    /* renamed from: com.tencent.mm.opensdk.modelbiz.JumpToBizTempSession$Req */
    public static class Req extends BaseReq {
        private static final int MAX_SESSION_FROM_LENGTH = 1024;
        private static final String TAG = "MicroMsg.SDK.JumpToBizTempSession.Req";
        public String sessionFrom;
        public int showType;
        public String toUserName;

        public boolean checkArgs() {
            AppMethodBeat.m2504i(128189);
            if (this.toUserName == null || this.toUserName.length() <= 0) {
                Log.m4140e(TAG, "checkArgs fail, toUserName is invalid");
                AppMethodBeat.m2505o(128189);
                return false;
            } else if (this.sessionFrom == null || this.sessionFrom.length() > 1024) {
                Log.m4140e(TAG, "checkArgs fail, sessionFrom is invalid");
                AppMethodBeat.m2505o(128189);
                return false;
            } else {
                AppMethodBeat.m2505o(128189);
                return true;
            }
        }

        public int getType() {
            return 10;
        }

        public void toBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128190);
            super.toBundle(bundle);
            bundle.putString("_wxapi_jump_to_biz_webview_req_to_user_name", this.toUserName);
            bundle.putString("_wxapi_jump_to_biz_webview_req_session_from", this.sessionFrom);
            bundle.putInt("_wxapi_jump_to_biz_webview_req_show_type", this.showType);
            AppMethodBeat.m2505o(128190);
        }
    }
}

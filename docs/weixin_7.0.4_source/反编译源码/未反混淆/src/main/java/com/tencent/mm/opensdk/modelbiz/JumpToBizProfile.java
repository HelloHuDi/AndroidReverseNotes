package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.utils.Log;

public class JumpToBizProfile {
    public static final int JUMP_TO_HARD_WARE_BIZ_PROFILE = 1;
    public static final int JUMP_TO_NORMAL_BIZ_PROFILE = 0;

    public static class Req extends BaseReq {
        private static final int EXT_MSG_LENGTH = 1024;
        private static final String TAG = "MicroMsg.SDK.JumpToBizProfile.Req";
        public String extMsg;
        public int profileType = 0;
        public String toUserName;

        public boolean checkArgs() {
            AppMethodBeat.i(128191);
            if (this.toUserName == null || this.toUserName.length() == 0) {
                Log.e(TAG, "checkArgs fail, toUserName is invalid");
                AppMethodBeat.o(128191);
                return false;
            } else if (this.extMsg != null && this.extMsg.length() > 1024) {
                Log.e(TAG, "ext msg is not null, while the length exceed 1024 bytes");
                AppMethodBeat.o(128191);
                return false;
            } else if (this.profileType == 1 && (this.extMsg == null || this.extMsg.length() == 0)) {
                Log.e(TAG, "scene is jump to hardware profile, while extmsg is null");
                AppMethodBeat.o(128191);
                return false;
            } else {
                AppMethodBeat.o(128191);
                return true;
            }
        }

        public void fromBundle(Bundle bundle) {
            AppMethodBeat.i(128193);
            super.fromBundle(bundle);
            this.toUserName = bundle.getString("_wxapi_jump_to_biz_profile_req_to_user_name");
            this.extMsg = bundle.getString("_wxapi_jump_to_biz_profile_req_ext_msg");
            AppMethodBeat.o(128193);
        }

        public int getType() {
            return 7;
        }

        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(128192);
            super.toBundle(bundle);
            bundle.putString("_wxapi_jump_to_biz_profile_req_to_user_name", this.toUserName);
            bundle.putString("_wxapi_jump_to_biz_profile_req_ext_msg", this.extMsg);
            bundle.putInt("_wxapi_jump_to_biz_profile_req_scene", 0);
            bundle.putInt("_wxapi_jump_to_biz_profile_req_profile_type", this.profileType);
            AppMethodBeat.o(128192);
        }
    }
}

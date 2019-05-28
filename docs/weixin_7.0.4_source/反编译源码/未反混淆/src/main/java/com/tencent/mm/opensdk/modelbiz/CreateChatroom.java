package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.d;

public class CreateChatroom {

    public static class Req extends BaseReq {
        public String chatroomName;
        public String chatroomNickName;
        public String extMsg;
        public String groupId = "";

        public boolean checkArgs() {
            AppMethodBeat.i(128162);
            if (d.b(this.groupId)) {
                AppMethodBeat.o(128162);
                return false;
            }
            AppMethodBeat.o(128162);
            return true;
        }

        public int getType() {
            return 14;
        }

        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(128163);
            super.toBundle(bundle);
            bundle.putString("_wxapi_create_chatroom_group_id", this.groupId);
            bundle.putString("_wxapi_create_chatroom_chatroom_name", this.chatroomName);
            bundle.putString("_wxapi_create_chatroom_chatroom_nickname", this.chatroomNickName);
            bundle.putString("_wxapi_create_chatroom_ext_msg", this.extMsg);
            bundle.putString("_wxapi_basereq_openid", this.openId);
            AppMethodBeat.o(128163);
        }
    }

    public static class Resp extends BaseResp {
        public String extMsg;

        public Resp(Bundle bundle) {
            AppMethodBeat.i(128169);
            fromBundle(bundle);
            AppMethodBeat.o(128169);
        }

        public boolean checkArgs() {
            return true;
        }

        public void fromBundle(Bundle bundle) {
            AppMethodBeat.i(128170);
            super.fromBundle(bundle);
            this.extMsg = bundle.getString("_wxapi_create_chatroom_ext_msg");
            AppMethodBeat.o(128170);
        }

        public int getType() {
            return 14;
        }

        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(128171);
            super.toBundle(bundle);
            bundle.putString("_wxapi_create_chatroom_ext_msg", this.extMsg);
            AppMethodBeat.o(128171);
        }
    }

    private CreateChatroom() {
    }
}

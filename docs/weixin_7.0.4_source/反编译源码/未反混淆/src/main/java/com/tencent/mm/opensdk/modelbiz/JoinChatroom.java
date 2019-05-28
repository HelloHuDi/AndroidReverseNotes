package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.d;

public class JoinChatroom {

    public static class Req extends BaseReq {
        public String chatroomNickName;
        public String extMsg;
        public String groupId = "";

        public boolean checkArgs() {
            AppMethodBeat.i(128172);
            if (d.b(this.groupId)) {
                AppMethodBeat.o(128172);
                return false;
            }
            AppMethodBeat.o(128172);
            return true;
        }

        public int getType() {
            return 15;
        }

        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(128173);
            super.toBundle(bundle);
            bundle.putString("_wxapi_join_chatroom_group_id", this.groupId);
            bundle.putString("_wxapi_join_chatroom_chatroom_nickname", this.chatroomNickName);
            bundle.putString("_wxapi_join_chatroom_ext_msg", this.extMsg);
            bundle.putString("_wxapi_basereq_openid", this.openId);
            AppMethodBeat.o(128173);
        }
    }

    public static class Resp extends BaseResp {
        public String extMsg;

        public Resp(Bundle bundle) {
            AppMethodBeat.i(128209);
            fromBundle(bundle);
            AppMethodBeat.o(128209);
        }

        public boolean checkArgs() {
            return true;
        }

        public void fromBundle(Bundle bundle) {
            AppMethodBeat.i(128210);
            super.fromBundle(bundle);
            this.extMsg = bundle.getString("_wxapi_join_chatroom_ext_msg");
            AppMethodBeat.o(128210);
        }

        public int getType() {
            return 15;
        }

        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(128211);
            super.toBundle(bundle);
            bundle.putString("_wxapi_join_chatroom_ext_msg", this.extMsg);
            AppMethodBeat.o(128211);
        }
    }

    private JoinChatroom() {
    }
}

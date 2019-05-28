package com.tencent.p177mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelbase.BaseReq;
import com.tencent.p177mm.opensdk.modelbase.BaseResp;
import com.tencent.p177mm.opensdk.utils.C18754d;

/* renamed from: com.tencent.mm.opensdk.modelbiz.CreateChatroom */
public class CreateChatroom {

    /* renamed from: com.tencent.mm.opensdk.modelbiz.CreateChatroom$Req */
    public static class Req extends BaseReq {
        public String chatroomName;
        public String chatroomNickName;
        public String extMsg;
        public String groupId = "";

        public boolean checkArgs() {
            AppMethodBeat.m2504i(128162);
            if (C18754d.m29305b(this.groupId)) {
                AppMethodBeat.m2505o(128162);
                return false;
            }
            AppMethodBeat.m2505o(128162);
            return true;
        }

        public int getType() {
            return 14;
        }

        public void toBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128163);
            super.toBundle(bundle);
            bundle.putString("_wxapi_create_chatroom_group_id", this.groupId);
            bundle.putString("_wxapi_create_chatroom_chatroom_name", this.chatroomName);
            bundle.putString("_wxapi_create_chatroom_chatroom_nickname", this.chatroomNickName);
            bundle.putString("_wxapi_create_chatroom_ext_msg", this.extMsg);
            bundle.putString("_wxapi_basereq_openid", this.openId);
            AppMethodBeat.m2505o(128163);
        }
    }

    /* renamed from: com.tencent.mm.opensdk.modelbiz.CreateChatroom$Resp */
    public static class Resp extends BaseResp {
        public String extMsg;

        public Resp(Bundle bundle) {
            AppMethodBeat.m2504i(128169);
            fromBundle(bundle);
            AppMethodBeat.m2505o(128169);
        }

        public boolean checkArgs() {
            return true;
        }

        public void fromBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128170);
            super.fromBundle(bundle);
            this.extMsg = bundle.getString("_wxapi_create_chatroom_ext_msg");
            AppMethodBeat.m2505o(128170);
        }

        public int getType() {
            return 14;
        }

        public void toBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128171);
            super.toBundle(bundle);
            bundle.putString("_wxapi_create_chatroom_ext_msg", this.extMsg);
            AppMethodBeat.m2505o(128171);
        }
    }

    private CreateChatroom() {
    }
}

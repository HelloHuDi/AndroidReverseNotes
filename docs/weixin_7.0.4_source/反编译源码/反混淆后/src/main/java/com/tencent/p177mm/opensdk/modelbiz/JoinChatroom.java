package com.tencent.p177mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelbase.BaseReq;
import com.tencent.p177mm.opensdk.modelbase.BaseResp;
import com.tencent.p177mm.opensdk.utils.C18754d;

/* renamed from: com.tencent.mm.opensdk.modelbiz.JoinChatroom */
public class JoinChatroom {

    /* renamed from: com.tencent.mm.opensdk.modelbiz.JoinChatroom$Req */
    public static class Req extends BaseReq {
        public String chatroomNickName;
        public String extMsg;
        public String groupId = "";

        public boolean checkArgs() {
            AppMethodBeat.m2504i(128172);
            if (C18754d.m29305b(this.groupId)) {
                AppMethodBeat.m2505o(128172);
                return false;
            }
            AppMethodBeat.m2505o(128172);
            return true;
        }

        public int getType() {
            return 15;
        }

        public void toBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128173);
            super.toBundle(bundle);
            bundle.putString("_wxapi_join_chatroom_group_id", this.groupId);
            bundle.putString("_wxapi_join_chatroom_chatroom_nickname", this.chatroomNickName);
            bundle.putString("_wxapi_join_chatroom_ext_msg", this.extMsg);
            bundle.putString("_wxapi_basereq_openid", this.openId);
            AppMethodBeat.m2505o(128173);
        }
    }

    /* renamed from: com.tencent.mm.opensdk.modelbiz.JoinChatroom$Resp */
    public static class Resp extends BaseResp {
        public String extMsg;

        public Resp(Bundle bundle) {
            AppMethodBeat.m2504i(128209);
            fromBundle(bundle);
            AppMethodBeat.m2505o(128209);
        }

        public boolean checkArgs() {
            return true;
        }

        public void fromBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128210);
            super.fromBundle(bundle);
            this.extMsg = bundle.getString("_wxapi_join_chatroom_ext_msg");
            AppMethodBeat.m2505o(128210);
        }

        public int getType() {
            return 15;
        }

        public void toBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128211);
            super.toBundle(bundle);
            bundle.putString("_wxapi_join_chatroom_ext_msg", this.extMsg);
            AppMethodBeat.m2505o(128211);
        }
    }

    private JoinChatroom() {
    }
}

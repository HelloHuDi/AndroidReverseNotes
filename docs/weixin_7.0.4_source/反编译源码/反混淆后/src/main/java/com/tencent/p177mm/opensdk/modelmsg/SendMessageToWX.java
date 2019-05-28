package com.tencent.p177mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelbase.BaseReq;
import com.tencent.p177mm.opensdk.modelbase.BaseResp;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage.Builder;
import com.tencent.p177mm.opensdk.utils.Log;

/* renamed from: com.tencent.mm.opensdk.modelmsg.SendMessageToWX */
public class SendMessageToWX {

    /* renamed from: com.tencent.mm.opensdk.modelmsg.SendMessageToWX$Req */
    public static class Req extends BaseReq {
        private static final int FAV_CONTENT_LENGTH_LIMIT = 26214400;
        private static final String TAG = "MicroMsg.SDK.SendMessageToWX.Req";
        public static final int WXSceneFavorite = 2;
        public static final int WXSceneSession = 0;
        public static final int WXSceneSpecifiedContact = 3;
        public static final int WXSceneTimeline = 1;
        public WXMediaMessage message;
        public int scene;
        public String userOpenId;

        public Req(Bundle bundle) {
            AppMethodBeat.m2504i(128300);
            fromBundle(bundle);
            AppMethodBeat.m2505o(128300);
        }

        public boolean checkArgs() {
            AppMethodBeat.m2504i(128303);
            if (this.message == null) {
                Log.m4140e(TAG, "checkArgs fail ,message is null");
                AppMethodBeat.m2505o(128303);
                return false;
            }
            if (this.message.mediaObject.type() == 6 && this.scene == 2) {
                ((WXFileObject) this.message.mediaObject).setContentLengthLimit(FAV_CONTENT_LENGTH_LIMIT);
            }
            if (this.scene == 3 && this.userOpenId == null) {
                AppMethodBeat.m2505o(128303);
                return false;
            }
            boolean checkArgs = this.message.checkArgs();
            AppMethodBeat.m2505o(128303);
            return checkArgs;
        }

        public void fromBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128301);
            super.fromBundle(bundle);
            this.message = Builder.fromBundle(bundle);
            this.scene = bundle.getInt("_wxapi_sendmessagetowx_req_scene");
            this.userOpenId = bundle.getString("_wxapi_sendmessagetowx_req_use_open_id");
            AppMethodBeat.m2505o(128301);
        }

        public int getType() {
            return 2;
        }

        public void toBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128302);
            super.toBundle(bundle);
            bundle.putAll(Builder.toBundle(this.message));
            bundle.putInt("_wxapi_sendmessagetowx_req_scene", this.scene);
            bundle.putInt("_wxapi_sendmessagetowx_req_media_type", this.message.getType());
            bundle.putString("_wxapi_sendmessagetowx_req_use_open_id", this.userOpenId);
            AppMethodBeat.m2505o(128302);
        }
    }

    /* renamed from: com.tencent.mm.opensdk.modelmsg.SendMessageToWX$Resp */
    public static class Resp extends BaseResp {
        public Resp(Bundle bundle) {
            AppMethodBeat.m2504i(128311);
            fromBundle(bundle);
            AppMethodBeat.m2505o(128311);
        }

        public boolean checkArgs() {
            return true;
        }

        public void fromBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128312);
            super.fromBundle(bundle);
            AppMethodBeat.m2505o(128312);
        }

        public int getType() {
            return 2;
        }

        public void toBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128313);
            super.toBundle(bundle);
            AppMethodBeat.m2505o(128313);
        }
    }

    private SendMessageToWX() {
    }
}

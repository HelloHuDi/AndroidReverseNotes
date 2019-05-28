package com.tencent.p177mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelbase.BaseReq;
import com.tencent.p177mm.opensdk.modelbase.BaseResp;
import com.tencent.p177mm.opensdk.utils.Log;

/* renamed from: com.tencent.mm.opensdk.modelbiz.SubscribeMiniProgramMsg */
public final class SubscribeMiniProgramMsg {

    /* renamed from: com.tencent.mm.opensdk.modelbiz.SubscribeMiniProgramMsg$Resp */
    public static class Resp extends BaseResp {
        private static final String TAG = "MicroMsg.SDK.SubscribeMessage.Resp";
        public String nickname;
        public String unionId;

        public Resp(Bundle bundle) {
            AppMethodBeat.m2504i(128212);
            fromBundle(bundle);
            AppMethodBeat.m2505o(128212);
        }

        public boolean checkArgs() {
            return true;
        }

        public void fromBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128213);
            super.fromBundle(bundle);
            this.unionId = bundle.getString("_wxapi_subscribeminiprogram_resp_unionId");
            this.nickname = bundle.getString("_wxapi_subscribeminiprogram_resp_nickname");
            AppMethodBeat.m2505o(128213);
        }

        public int getType() {
            return 23;
        }

        public void toBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128214);
            super.toBundle(bundle);
            bundle.putString("_wxapi_subscribeminiprogram_resp_unionId", this.unionId);
            bundle.putString("_wxapi_subscribeminiprogram_resp_nickname", this.nickname);
            AppMethodBeat.m2505o(128214);
        }
    }

    /* renamed from: com.tencent.mm.opensdk.modelbiz.SubscribeMiniProgramMsg$Req */
    public static class Req extends BaseReq {
        private static final int LENGTH_LIMIT = 1024;
        private static final String TAG = "MicroMsg.SDK.SubscribeMessage.Req";
        public String miniProgramAppId;

        public Req(Bundle bundle) {
            AppMethodBeat.m2504i(128238);
            fromBundle(bundle);
            AppMethodBeat.m2505o(128238);
        }

        public boolean checkArgs() {
            AppMethodBeat.m2504i(128241);
            if (this.miniProgramAppId == null || this.miniProgramAppId.length() == 0) {
                Log.m4140e(TAG, "checkArgs fail, miniProgramAppId is null");
                AppMethodBeat.m2505o(128241);
                return false;
            }
            AppMethodBeat.m2505o(128241);
            return true;
        }

        public void fromBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128239);
            super.fromBundle(bundle);
            this.miniProgramAppId = bundle.getString("_wxapi_subscribeminiprogram_req_miniprogramappid");
            AppMethodBeat.m2505o(128239);
        }

        public int getType() {
            return 23;
        }

        public void toBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128240);
            super.toBundle(bundle);
            bundle.putString("_wxapi_subscribeminiprogram_req_miniprogramappid", this.miniProgramAppId);
            AppMethodBeat.m2505o(128240);
        }
    }

    private SubscribeMiniProgramMsg() {
    }
}

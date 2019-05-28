package com.tencent.p177mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelbase.BaseReq;
import com.tencent.p177mm.opensdk.modelbase.BaseResp;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage.Builder;

/* renamed from: com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX */
public class ShowMessageFromWX {

    /* renamed from: com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX$Req */
    public static class Req extends BaseReq {
        public String country;
        public String lang;
        public WXMediaMessage message;

        public Req(Bundle bundle) {
            AppMethodBeat.m2504i(128273);
            fromBundle(bundle);
            AppMethodBeat.m2505o(128273);
        }

        public boolean checkArgs() {
            AppMethodBeat.m2504i(128276);
            if (this.message == null) {
                AppMethodBeat.m2505o(128276);
                return false;
            }
            boolean checkArgs = this.message.checkArgs();
            AppMethodBeat.m2505o(128276);
            return checkArgs;
        }

        public void fromBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128275);
            super.fromBundle(bundle);
            this.lang = bundle.getString("_wxapi_showmessage_req_lang");
            this.country = bundle.getString("_wxapi_showmessage_req_country");
            this.message = Builder.fromBundle(bundle);
            AppMethodBeat.m2505o(128275);
        }

        public int getType() {
            return 4;
        }

        public void toBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128274);
            Bundle toBundle = Builder.toBundle(this.message);
            super.toBundle(toBundle);
            bundle.putString("_wxapi_showmessage_req_lang", this.lang);
            bundle.putString("_wxapi_showmessage_req_country", this.country);
            bundle.putAll(toBundle);
            AppMethodBeat.m2505o(128274);
        }
    }

    /* renamed from: com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX$Resp */
    public static class Resp extends BaseResp {
        public Resp(Bundle bundle) {
            AppMethodBeat.m2504i(128257);
            fromBundle(bundle);
            AppMethodBeat.m2505o(128257);
        }

        public boolean checkArgs() {
            return true;
        }

        public int getType() {
            return 4;
        }
    }

    private ShowMessageFromWX() {
    }
}

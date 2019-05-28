package com.tencent.p177mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelbase.BaseReq;
import com.tencent.p177mm.opensdk.modelbase.BaseResp;
import java.util.HashMap;

/* renamed from: com.tencent.mm.opensdk.modelbiz.WXOpenBusinessWebview */
public class WXOpenBusinessWebview {

    /* renamed from: com.tencent.mm.opensdk.modelbiz.WXOpenBusinessWebview$Req */
    public static class Req extends BaseReq {
        public int businessType;
        public HashMap<String, String> queryInfo;

        public boolean checkArgs() {
            return true;
        }

        public void fromBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128223);
            super.fromBundle(bundle);
            this.queryInfo = (HashMap) bundle.getSerializable("_wxapi_open_business_webview_query_info");
            this.businessType = bundle.getInt("_wxapi_open_business_webview_query_type", 0);
            AppMethodBeat.m2505o(128223);
        }

        public int getType() {
            return 25;
        }

        public void toBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128224);
            super.toBundle(bundle);
            bundle.putSerializable("_wxapi_open_business_webview_query_info", this.queryInfo);
            bundle.putInt("_wxapi_open_business_webview_query_type", this.businessType);
            AppMethodBeat.m2505o(128224);
        }
    }

    /* renamed from: com.tencent.mm.opensdk.modelbiz.WXOpenBusinessWebview$Resp */
    public static class Resp extends BaseResp {
        public int businessType;
        public String resultInfo;

        public Resp(Bundle bundle) {
            AppMethodBeat.m2504i(128203);
            fromBundle(bundle);
            AppMethodBeat.m2505o(128203);
        }

        public boolean checkArgs() {
            return true;
        }

        public void fromBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128204);
            super.fromBundle(bundle);
            this.resultInfo = bundle.getString("_wxapi_open_business_webview_result");
            this.businessType = bundle.getInt("_wxapi_open_business_webview_query_type", 0);
            AppMethodBeat.m2505o(128204);
        }

        public int getType() {
            return 25;
        }

        public void toBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128205);
            super.toBundle(bundle);
            bundle.putString("_wxapi_open_business_webview_result", this.resultInfo);
            bundle.putInt("_wxapi_open_business_webview_query_type", this.businessType);
            AppMethodBeat.m2505o(128205);
        }
    }
}

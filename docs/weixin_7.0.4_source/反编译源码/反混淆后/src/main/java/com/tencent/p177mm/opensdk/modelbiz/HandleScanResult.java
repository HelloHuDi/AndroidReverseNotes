package com.tencent.p177mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelbase.BaseReq;
import com.tencent.p177mm.opensdk.modelbase.BaseResp;
import java.net.URLEncoder;

/* renamed from: com.tencent.mm.opensdk.modelbiz.HandleScanResult */
public class HandleScanResult {

    /* renamed from: com.tencent.mm.opensdk.modelbiz.HandleScanResult$Resp */
    public static class Resp extends BaseResp {
        public Resp(Bundle bundle) {
            AppMethodBeat.m2504i(128231);
            fromBundle(bundle);
            AppMethodBeat.m2505o(128231);
        }

        public boolean checkArgs() {
            return true;
        }

        public void fromBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128232);
            super.fromBundle(bundle);
            AppMethodBeat.m2505o(128232);
        }

        public int getType() {
            return 17;
        }

        public void toBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128233);
            super.toBundle(bundle);
            AppMethodBeat.m2505o(128233);
        }
    }

    /* renamed from: com.tencent.mm.opensdk.modelbiz.HandleScanResult$Req */
    public static class Req extends BaseReq {
        private static final int MAX_URL_LENGHT = 10240;
        public String scanResult;

        public boolean checkArgs() {
            AppMethodBeat.m2504i(128236);
            if (this.scanResult == null || this.scanResult.length() < 0) {
                AppMethodBeat.m2505o(128236);
                return false;
            } else if (this.scanResult.length() > 10240) {
                AppMethodBeat.m2505o(128236);
                return false;
            } else {
                AppMethodBeat.m2505o(128236);
                return true;
            }
        }

        public int getType() {
            return 17;
        }

        public void toBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128237);
            super.toBundle(bundle);
            bundle.putString("_wxapi_scan_qrcode_result", URLEncoder.encode(this.scanResult));
            AppMethodBeat.m2505o(128237);
        }
    }
}

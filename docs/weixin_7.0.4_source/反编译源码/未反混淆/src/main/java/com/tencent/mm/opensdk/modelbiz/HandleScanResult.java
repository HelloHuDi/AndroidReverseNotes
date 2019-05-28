package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import java.net.URLEncoder;

public class HandleScanResult {

    public static class Resp extends BaseResp {
        public Resp(Bundle bundle) {
            AppMethodBeat.i(128231);
            fromBundle(bundle);
            AppMethodBeat.o(128231);
        }

        public boolean checkArgs() {
            return true;
        }

        public void fromBundle(Bundle bundle) {
            AppMethodBeat.i(128232);
            super.fromBundle(bundle);
            AppMethodBeat.o(128232);
        }

        public int getType() {
            return 17;
        }

        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(128233);
            super.toBundle(bundle);
            AppMethodBeat.o(128233);
        }
    }

    public static class Req extends BaseReq {
        private static final int MAX_URL_LENGHT = 10240;
        public String scanResult;

        public boolean checkArgs() {
            AppMethodBeat.i(128236);
            if (this.scanResult == null || this.scanResult.length() < 0) {
                AppMethodBeat.o(128236);
                return false;
            } else if (this.scanResult.length() > 10240) {
                AppMethodBeat.o(128236);
                return false;
            } else {
                AppMethodBeat.o(128236);
                return true;
            }
        }

        public int getType() {
            return 17;
        }

        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(128237);
            super.toBundle(bundle);
            bundle.putString("_wxapi_scan_qrcode_result", URLEncoder.encode(this.scanResult));
            AppMethodBeat.o(128237);
        }
    }
}

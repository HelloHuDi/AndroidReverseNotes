package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import java.net.URLEncoder;

public class OpenWebview {

    public static class Req extends BaseReq {
        private static final int MAX_URL_LENGHT = 10240;
        public String url;

        public boolean checkArgs() {
            AppMethodBeat.i(128218);
            if (this.url == null || this.url.length() < 0) {
                AppMethodBeat.o(128218);
                return false;
            } else if (this.url.length() > 10240) {
                AppMethodBeat.o(128218);
                return false;
            } else {
                AppMethodBeat.o(128218);
                return true;
            }
        }

        public void fromBundle(Bundle bundle) {
            AppMethodBeat.i(128219);
            super.fromBundle(bundle);
            this.url = bundle.getString("_wxapi_jump_to_webview_url");
            AppMethodBeat.o(128219);
        }

        public int getType() {
            return 12;
        }

        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(128220);
            super.toBundle(bundle);
            bundle.putString("_wxapi_jump_to_webview_url", URLEncoder.encode(this.url));
            AppMethodBeat.o(128220);
        }
    }

    public static class Resp extends BaseResp {
        public String result;

        public Resp(Bundle bundle) {
            AppMethodBeat.i(128164);
            fromBundle(bundle);
            AppMethodBeat.o(128164);
        }

        public boolean checkArgs() {
            return true;
        }

        public void fromBundle(Bundle bundle) {
            AppMethodBeat.i(128165);
            super.fromBundle(bundle);
            this.result = bundle.getString("_wxapi_open_webview_result");
            AppMethodBeat.o(128165);
        }

        public int getType() {
            return 12;
        }

        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(128166);
            super.toBundle(bundle);
            bundle.putString("_wxapi_open_webview_result", this.result);
            AppMethodBeat.o(128166);
        }
    }
}

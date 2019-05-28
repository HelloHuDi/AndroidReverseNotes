package com.tencent.mm.opensdk.modelpay;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public class JumpToOfflinePay {

    public static class Req extends BaseReq {
        private static final String TAG = "MicroMsg.SDK.JumpToOfflinePay.Req";

        public boolean checkArgs() {
            return true;
        }

        public void fromBundle(Bundle bundle) {
            AppMethodBeat.i(128149);
            super.fromBundle(bundle);
            AppMethodBeat.o(128149);
        }

        public int getType() {
            return 24;
        }

        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(128148);
            super.toBundle(bundle);
            AppMethodBeat.o(128148);
        }
    }

    public static class Resp extends BaseResp {
        public Resp(Bundle bundle) {
            AppMethodBeat.i(128145);
            fromBundle(bundle);
            AppMethodBeat.o(128145);
        }

        public boolean checkArgs() {
            return true;
        }

        public void fromBundle(Bundle bundle) {
            AppMethodBeat.i(128147);
            super.fromBundle(bundle);
            AppMethodBeat.o(128147);
        }

        public int getType() {
            return 24;
        }

        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(128146);
            super.toBundle(bundle);
            AppMethodBeat.o(128146);
        }
    }
}

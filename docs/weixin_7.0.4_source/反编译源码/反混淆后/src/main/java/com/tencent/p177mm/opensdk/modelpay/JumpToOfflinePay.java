package com.tencent.p177mm.opensdk.modelpay;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelbase.BaseReq;
import com.tencent.p177mm.opensdk.modelbase.BaseResp;

/* renamed from: com.tencent.mm.opensdk.modelpay.JumpToOfflinePay */
public class JumpToOfflinePay {

    /* renamed from: com.tencent.mm.opensdk.modelpay.JumpToOfflinePay$Req */
    public static class Req extends BaseReq {
        private static final String TAG = "MicroMsg.SDK.JumpToOfflinePay.Req";

        public boolean checkArgs() {
            return true;
        }

        public void fromBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128149);
            super.fromBundle(bundle);
            AppMethodBeat.m2505o(128149);
        }

        public int getType() {
            return 24;
        }

        public void toBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128148);
            super.toBundle(bundle);
            AppMethodBeat.m2505o(128148);
        }
    }

    /* renamed from: com.tencent.mm.opensdk.modelpay.JumpToOfflinePay$Resp */
    public static class Resp extends BaseResp {
        public Resp(Bundle bundle) {
            AppMethodBeat.m2504i(128145);
            fromBundle(bundle);
            AppMethodBeat.m2505o(128145);
        }

        public boolean checkArgs() {
            return true;
        }

        public void fromBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128147);
            super.fromBundle(bundle);
            AppMethodBeat.m2505o(128147);
        }

        public int getType() {
            return 24;
        }

        public void toBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128146);
            super.toBundle(bundle);
            AppMethodBeat.m2505o(128146);
        }
    }
}

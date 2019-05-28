package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public class WXLaunchMiniProgram {

    public static final class Req extends BaseReq {
        public static final int MINIPROGRAM_TYPE_PREVIEW = 2;
        public static final int MINIPROGRAM_TYPE_TEST = 1;
        public static final int MINIPTOGRAM_TYPE_RELEASE = 0;
        private static final String TAG = "MicroMsg.SDK.WXLaunchMiniProgram.Req";
        public String extData = "";
        public int miniprogramType = 0;
        public String path = "";
        public String userName;

        public final boolean checkArgs() {
            AppMethodBeat.i(128194);
            if (d.b(this.userName)) {
                Log.e(TAG, "userName is null");
                AppMethodBeat.o(128194);
                return false;
            } else if (this.miniprogramType < 0 || this.miniprogramType > 2) {
                Log.e(TAG, "miniprogram type should between MINIPTOGRAM_TYPE_RELEASE and MINIPROGRAM_TYPE_PREVIEW");
                AppMethodBeat.o(128194);
                return false;
            } else {
                AppMethodBeat.o(128194);
                return true;
            }
        }

        public final int getType() {
            return 19;
        }

        public final void toBundle(Bundle bundle) {
            AppMethodBeat.i(128195);
            super.toBundle(bundle);
            bundle.putString("_launch_wxminiprogram_username", this.userName);
            bundle.putString("_launch_wxminiprogram_path", this.path);
            bundle.putString("_launch_wxminiprogram_extData", this.extData);
            bundle.putInt("_launch_wxminiprogram_type", this.miniprogramType);
            AppMethodBeat.o(128195);
        }
    }

    public static final class Resp extends BaseResp {
        public String extMsg;

        public Resp(Bundle bundle) {
            AppMethodBeat.i(128215);
            fromBundle(bundle);
            AppMethodBeat.o(128215);
        }

        public final boolean checkArgs() {
            return true;
        }

        public final void fromBundle(Bundle bundle) {
            AppMethodBeat.i(128216);
            super.fromBundle(bundle);
            this.extMsg = bundle.getString("_launch_wxminiprogram_ext_msg");
            AppMethodBeat.o(128216);
        }

        public final int getType() {
            return 19;
        }

        public final void toBundle(Bundle bundle) {
            AppMethodBeat.i(128217);
            super.toBundle(bundle);
            bundle.putString("_launch_wxminiprogram_ext_msg", this.extMsg);
            AppMethodBeat.o(128217);
        }
    }
}

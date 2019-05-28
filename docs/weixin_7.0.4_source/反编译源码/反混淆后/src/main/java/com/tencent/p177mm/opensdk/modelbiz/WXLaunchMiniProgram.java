package com.tencent.p177mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelbase.BaseReq;
import com.tencent.p177mm.opensdk.modelbase.BaseResp;
import com.tencent.p177mm.opensdk.utils.C18754d;
import com.tencent.p177mm.opensdk.utils.Log;

/* renamed from: com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram */
public class WXLaunchMiniProgram {

    /* renamed from: com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram$Req */
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
            AppMethodBeat.m2504i(128194);
            if (C18754d.m29305b(this.userName)) {
                Log.m4140e(TAG, "userName is null");
                AppMethodBeat.m2505o(128194);
                return false;
            } else if (this.miniprogramType < 0 || this.miniprogramType > 2) {
                Log.m4140e(TAG, "miniprogram type should between MINIPTOGRAM_TYPE_RELEASE and MINIPROGRAM_TYPE_PREVIEW");
                AppMethodBeat.m2505o(128194);
                return false;
            } else {
                AppMethodBeat.m2505o(128194);
                return true;
            }
        }

        public final int getType() {
            return 19;
        }

        public final void toBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128195);
            super.toBundle(bundle);
            bundle.putString("_launch_wxminiprogram_username", this.userName);
            bundle.putString("_launch_wxminiprogram_path", this.path);
            bundle.putString("_launch_wxminiprogram_extData", this.extData);
            bundle.putInt("_launch_wxminiprogram_type", this.miniprogramType);
            AppMethodBeat.m2505o(128195);
        }
    }

    /* renamed from: com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram$Resp */
    public static final class Resp extends BaseResp {
        public String extMsg;

        public Resp(Bundle bundle) {
            AppMethodBeat.m2504i(128215);
            fromBundle(bundle);
            AppMethodBeat.m2505o(128215);
        }

        public final boolean checkArgs() {
            return true;
        }

        public final void fromBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128216);
            super.fromBundle(bundle);
            this.extMsg = bundle.getString("_launch_wxminiprogram_ext_msg");
            AppMethodBeat.m2505o(128216);
        }

        public final int getType() {
            return 19;
        }

        public final void toBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128217);
            super.toBundle(bundle);
            bundle.putString("_launch_wxminiprogram_ext_msg", this.extMsg);
            AppMethodBeat.m2505o(128217);
        }
    }
}

package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public class WXOpenBusinessView {

    public static final class Resp extends BaseResp {
        public String businessType;
        public String extMsg;

        public Resp(Bundle bundle) {
            AppMethodBeat.i(128206);
            fromBundle(bundle);
            AppMethodBeat.o(128206);
        }

        public final boolean checkArgs() {
            return true;
        }

        public final void fromBundle(Bundle bundle) {
            AppMethodBeat.i(128207);
            super.fromBundle(bundle);
            this.extMsg = bundle.getString("_openbusinessview_ext_msg");
            this.businessType = bundle.getString("_openbusinessview_business_type");
            AppMethodBeat.o(128207);
        }

        public final int getType() {
            return 26;
        }

        public final void toBundle(Bundle bundle) {
            AppMethodBeat.i(128208);
            super.toBundle(bundle);
            bundle.putString("_openbusinessview_ext_msg", this.extMsg);
            bundle.putString("_openbusinessview_business_type", this.businessType);
            AppMethodBeat.o(128208);
        }
    }

    public static final class Req extends BaseReq {
        private static final String TAG = "MicroMsg.SDK.WXOpenBusinessView.Req";
        public String businessType;
        public String extInfo;
        public String query;

        public final boolean checkArgs() {
            AppMethodBeat.i(128178);
            if (d.b(this.businessType)) {
                Log.e(TAG, "businessType is null");
                AppMethodBeat.o(128178);
                return false;
            }
            AppMethodBeat.o(128178);
            return true;
        }

        public final void fromBundle(Bundle bundle) {
            AppMethodBeat.i(128180);
            super.fromBundle(bundle);
            this.businessType = bundle.getString("_openbusinessview_businessType");
            this.query = bundle.getString("_openbusinessview__query_info");
            this.extInfo = bundle.getString("_openbusinessview_extInfo");
            AppMethodBeat.o(128180);
        }

        public final int getType() {
            return 26;
        }

        public final void toBundle(Bundle bundle) {
            AppMethodBeat.i(128179);
            super.toBundle(bundle);
            bundle.putString("_openbusinessview_businessType", this.businessType);
            bundle.putString("_openbusinessview__query_info", this.query);
            bundle.putString("_openbusinessview_extInfo", this.extInfo);
            AppMethodBeat.o(128179);
        }
    }
}

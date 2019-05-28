package com.tencent.p177mm.opensdk.modelpay;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelbase.BaseResp;

/* renamed from: com.tencent.mm.opensdk.modelpay.PayResp */
public class PayResp extends BaseResp {
    public String extData;
    public String prepayId;
    public String returnKey;

    public PayResp(Bundle bundle) {
        AppMethodBeat.m2504i(128142);
        fromBundle(bundle);
        AppMethodBeat.m2505o(128142);
    }

    public boolean checkArgs() {
        return true;
    }

    public void fromBundle(Bundle bundle) {
        AppMethodBeat.m2504i(128144);
        super.fromBundle(bundle);
        this.prepayId = bundle.getString("_wxapi_payresp_prepayid");
        this.returnKey = bundle.getString("_wxapi_payresp_returnkey");
        this.extData = bundle.getString("_wxapi_payresp_extdata");
        AppMethodBeat.m2505o(128144);
    }

    public int getType() {
        return 5;
    }

    public void toBundle(Bundle bundle) {
        AppMethodBeat.m2504i(128143);
        super.toBundle(bundle);
        bundle.putString("_wxapi_payresp_prepayid", this.prepayId);
        bundle.putString("_wxapi_payresp_returnkey", this.returnKey);
        bundle.putString("_wxapi_payresp_extdata", this.extData);
        AppMethodBeat.m2505o(128143);
    }
}

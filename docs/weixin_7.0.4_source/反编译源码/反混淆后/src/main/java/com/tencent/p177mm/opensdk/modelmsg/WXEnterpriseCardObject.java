package com.tencent.p177mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.p177mm.opensdk.utils.Log;

/* renamed from: com.tencent.mm.opensdk.modelmsg.WXEnterpriseCardObject */
public class WXEnterpriseCardObject implements IMediaObject {
    private static final int LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXEnterpriseCardObject";
    public String cardInfo;
    public int msgType;

    public boolean checkArgs() {
        AppMethodBeat.m2504i(128299);
        if (this.cardInfo == null || this.cardInfo.length() == 0) {
            Log.m4140e(TAG, "checkArgs fail, cardInfo is invalid");
            AppMethodBeat.m2505o(128299);
            return false;
        }
        AppMethodBeat.m2505o(128299);
        return true;
    }

    public void serialize(Bundle bundle) {
        AppMethodBeat.m2504i(128297);
        bundle.putInt("_wxenterprisecard_msgtype", this.msgType);
        bundle.putString("_wxenterprisecard_cardinfo", this.cardInfo);
        AppMethodBeat.m2505o(128297);
    }

    public int type() {
        return 45;
    }

    public void unserialize(Bundle bundle) {
        AppMethodBeat.m2504i(128298);
        this.msgType = bundle.getInt("_wxenterprisecard_msgtype");
        this.cardInfo = bundle.getString("_wxenterprisecard_cardinfo");
        AppMethodBeat.m2505o(128298);
    }
}

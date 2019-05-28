package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.utils.Log;

public class WXEnterpriseCardObject implements IMediaObject {
    private static final int LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXEnterpriseCardObject";
    public String cardInfo;
    public int msgType;

    public boolean checkArgs() {
        AppMethodBeat.i(128299);
        if (this.cardInfo == null || this.cardInfo.length() == 0) {
            Log.e(TAG, "checkArgs fail, cardInfo is invalid");
            AppMethodBeat.o(128299);
            return false;
        }
        AppMethodBeat.o(128299);
        return true;
    }

    public void serialize(Bundle bundle) {
        AppMethodBeat.i(128297);
        bundle.putInt("_wxenterprisecard_msgtype", this.msgType);
        bundle.putString("_wxenterprisecard_cardinfo", this.cardInfo);
        AppMethodBeat.o(128297);
    }

    public int type() {
        return 45;
    }

    public void unserialize(Bundle bundle) {
        AppMethodBeat.i(128298);
        this.msgType = bundle.getInt("_wxenterprisecard_msgtype");
        this.cardInfo = bundle.getString("_wxenterprisecard_cardinfo");
        AppMethodBeat.o(128298);
    }
}

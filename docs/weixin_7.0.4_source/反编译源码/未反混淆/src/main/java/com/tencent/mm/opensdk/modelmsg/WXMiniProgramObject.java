package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public class WXMiniProgramObject implements IMediaObject {
    public static final int MINIPROGRAM_TYPE_PREVIEW = 2;
    public static final int MINIPROGRAM_TYPE_TEST = 1;
    public static final int MINIPTOGRAM_TYPE_RELEASE = 0;
    private static final String TAG = "MicroMsg.SDK.WXMiniProgramObject";
    public int miniprogramType = 0;
    public String path;
    public String userName;
    public String webpageUrl;
    public boolean withShareTicket;

    public boolean checkArgs() {
        AppMethodBeat.i(128248);
        if (d.b(this.webpageUrl)) {
            Log.e(TAG, "webPageUrl is null");
            AppMethodBeat.o(128248);
            return false;
        } else if (d.b(this.userName)) {
            Log.e(TAG, "userName is null");
            AppMethodBeat.o(128248);
            return false;
        } else if (this.miniprogramType < 0 || this.miniprogramType > 2) {
            Log.e(TAG, "miniprogram type should between MINIPTOGRAM_TYPE_RELEASE and MINIPROGRAM_TYPE_PREVIEW");
            AppMethodBeat.o(128248);
            return false;
        } else {
            AppMethodBeat.o(128248);
            return true;
        }
    }

    public void serialize(Bundle bundle) {
        AppMethodBeat.i(128246);
        bundle.putString("_wxminiprogram_webpageurl", this.webpageUrl);
        bundle.putString("_wxminiprogram_username", this.userName);
        bundle.putString("_wxminiprogram_path", this.path);
        bundle.putBoolean("_wxminiprogram_withsharetiket", this.withShareTicket);
        bundle.putInt("_wxminiprogram_type", this.miniprogramType);
        AppMethodBeat.o(128246);
    }

    public int type() {
        return 36;
    }

    public void unserialize(Bundle bundle) {
        AppMethodBeat.i(128247);
        this.webpageUrl = bundle.getString("_wxminiprogram_webpageurl");
        this.userName = bundle.getString("_wxminiprogram_username");
        this.path = bundle.getString("_wxminiprogram_path");
        this.withShareTicket = bundle.getBoolean("_wxminiprogram_withsharetiket");
        this.miniprogramType = bundle.getInt("_wxminiprogram_type");
        AppMethodBeat.o(128247);
    }
}

package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public class WXDynamicVideoMiniProgramObject extends WXMiniProgramObject {
    private static final String TAG = "MicroMsg.SDK.WXDynamicVideoMiniProgramObject";
    public String appThumbUrl;
    public String videoSource;

    public boolean checkArgs() {
        AppMethodBeat.i(128316);
        if (d.b(this.webpageUrl)) {
            Log.e(TAG, "webPageUrl is null");
            AppMethodBeat.o(128316);
            return false;
        } else if (d.b(this.userName)) {
            Log.e(TAG, "userName is null");
            AppMethodBeat.o(128316);
            return false;
        } else if (this.miniprogramType < 0 || this.miniprogramType > 2) {
            Log.e(TAG, "miniprogram type should between MINIPTOGRAM_TYPE_RELEASE and MINIPROGRAM_TYPE_PREVIEW");
            AppMethodBeat.o(128316);
            return false;
        } else {
            AppMethodBeat.o(128316);
            return true;
        }
    }

    public void serialize(Bundle bundle) {
        AppMethodBeat.i(128314);
        bundle.putString("_wxminiprogram_webpageurl", this.webpageUrl);
        bundle.putString("_wxminiprogram_username", this.userName);
        bundle.putString("_wxminiprogram_path", this.path);
        bundle.putString("_wxminiprogram_videoSource", this.videoSource);
        bundle.putString("_wxminiprogram_appThumbUrl", this.appThumbUrl);
        bundle.putBoolean("_wxminiprogram_withsharetiket", this.withShareTicket);
        bundle.putInt("_wxminiprogram_type", this.miniprogramType);
        AppMethodBeat.o(128314);
    }

    public int type() {
        return 46;
    }

    public void unserialize(Bundle bundle) {
        AppMethodBeat.i(128315);
        this.webpageUrl = bundle.getString("_wxminiprogram_webpageurl");
        this.userName = bundle.getString("_wxminiprogram_username");
        this.path = bundle.getString("_wxminiprogram_path");
        this.videoSource = bundle.getString("_wxminiprogram_videoSource");
        this.appThumbUrl = bundle.getString("_wxminiprogram_appThumbUrl");
        this.withShareTicket = bundle.getBoolean("_wxminiprogram_withsharetiket");
        this.miniprogramType = bundle.getInt("_wxminiprogram_type");
        AppMethodBeat.o(128315);
    }
}

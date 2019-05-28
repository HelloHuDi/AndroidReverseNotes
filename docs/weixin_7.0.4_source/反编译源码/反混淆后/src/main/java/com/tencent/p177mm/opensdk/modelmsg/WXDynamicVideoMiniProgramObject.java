package com.tencent.p177mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.utils.C18754d;
import com.tencent.p177mm.opensdk.utils.Log;

/* renamed from: com.tencent.mm.opensdk.modelmsg.WXDynamicVideoMiniProgramObject */
public class WXDynamicVideoMiniProgramObject extends WXMiniProgramObject {
    private static final String TAG = "MicroMsg.SDK.WXDynamicVideoMiniProgramObject";
    public String appThumbUrl;
    public String videoSource;

    public boolean checkArgs() {
        AppMethodBeat.m2504i(128316);
        if (C18754d.m29305b(this.webpageUrl)) {
            Log.m4140e(TAG, "webPageUrl is null");
            AppMethodBeat.m2505o(128316);
            return false;
        } else if (C18754d.m29305b(this.userName)) {
            Log.m4140e(TAG, "userName is null");
            AppMethodBeat.m2505o(128316);
            return false;
        } else if (this.miniprogramType < 0 || this.miniprogramType > 2) {
            Log.m4140e(TAG, "miniprogram type should between MINIPTOGRAM_TYPE_RELEASE and MINIPROGRAM_TYPE_PREVIEW");
            AppMethodBeat.m2505o(128316);
            return false;
        } else {
            AppMethodBeat.m2505o(128316);
            return true;
        }
    }

    public void serialize(Bundle bundle) {
        AppMethodBeat.m2504i(128314);
        bundle.putString("_wxminiprogram_webpageurl", this.webpageUrl);
        bundle.putString("_wxminiprogram_username", this.userName);
        bundle.putString("_wxminiprogram_path", this.path);
        bundle.putString("_wxminiprogram_videoSource", this.videoSource);
        bundle.putString("_wxminiprogram_appThumbUrl", this.appThumbUrl);
        bundle.putBoolean("_wxminiprogram_withsharetiket", this.withShareTicket);
        bundle.putInt("_wxminiprogram_type", this.miniprogramType);
        AppMethodBeat.m2505o(128314);
    }

    public int type() {
        return 46;
    }

    public void unserialize(Bundle bundle) {
        AppMethodBeat.m2504i(128315);
        this.webpageUrl = bundle.getString("_wxminiprogram_webpageurl");
        this.userName = bundle.getString("_wxminiprogram_username");
        this.path = bundle.getString("_wxminiprogram_path");
        this.videoSource = bundle.getString("_wxminiprogram_videoSource");
        this.appThumbUrl = bundle.getString("_wxminiprogram_appThumbUrl");
        this.withShareTicket = bundle.getBoolean("_wxminiprogram_withsharetiket");
        this.miniprogramType = bundle.getInt("_wxminiprogram_type");
        AppMethodBeat.m2505o(128315);
    }
}

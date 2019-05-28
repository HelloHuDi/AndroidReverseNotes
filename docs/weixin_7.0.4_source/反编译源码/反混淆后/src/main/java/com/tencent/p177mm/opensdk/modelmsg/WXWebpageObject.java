package com.tencent.p177mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.p177mm.opensdk.utils.Log;

/* renamed from: com.tencent.mm.opensdk.modelmsg.WXWebpageObject */
public class WXWebpageObject implements IMediaObject {
    private static final int LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXWebpageObject";
    public String canvasPageXml;
    public String extInfo;
    public String webpageUrl;

    public WXWebpageObject(String str) {
        this.webpageUrl = str;
    }

    public boolean checkArgs() {
        AppMethodBeat.m2504i(128323);
        if (this.webpageUrl == null || this.webpageUrl.length() == 0 || this.webpageUrl.length() > 10240) {
            Log.m4140e(TAG, "checkArgs fail, webpageUrl is invalid");
            AppMethodBeat.m2505o(128323);
            return false;
        }
        AppMethodBeat.m2505o(128323);
        return true;
    }

    public void serialize(Bundle bundle) {
        AppMethodBeat.m2504i(128321);
        bundle.putString("_wxwebpageobject_extInfo", this.extInfo);
        bundle.putString("_wxwebpageobject_webpageUrl", this.webpageUrl);
        bundle.putString("_wxwebpageobject_canvaspagexml", this.canvasPageXml);
        AppMethodBeat.m2505o(128321);
    }

    public int type() {
        return 5;
    }

    public void unserialize(Bundle bundle) {
        AppMethodBeat.m2504i(128322);
        this.extInfo = bundle.getString("_wxwebpageobject_extInfo");
        this.webpageUrl = bundle.getString("_wxwebpageobject_webpageUrl");
        this.canvasPageXml = bundle.getString("_wxwebpageobject_canvaspagexml");
        AppMethodBeat.m2505o(128322);
    }
}

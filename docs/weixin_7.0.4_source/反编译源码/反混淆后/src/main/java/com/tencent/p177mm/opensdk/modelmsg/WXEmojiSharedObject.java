package com.tencent.p177mm.opensdk.modelmsg;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.p177mm.opensdk.utils.Log;

/* renamed from: com.tencent.mm.opensdk.modelmsg.WXEmojiSharedObject */
public class WXEmojiSharedObject implements IMediaObject {
    private static final String TAG = "MicroMsg.SDK.WXEmojiSharedObject";
    public int packageflag;
    public String packageid;
    public String thumburl;
    public String url;

    public WXEmojiSharedObject(String str, int i, String str2, String str3) {
        this.thumburl = str;
        this.packageflag = i;
        this.packageid = str2;
        this.url = str3;
    }

    public boolean checkArgs() {
        AppMethodBeat.m2504i(128296);
        if (TextUtils.isEmpty(this.packageid) || TextUtils.isEmpty(this.thumburl) || TextUtils.isEmpty(this.url) || this.packageflag == -1) {
            Log.m4140e(TAG, "checkArgs fail, packageid or thumburl is invalid");
            AppMethodBeat.m2505o(128296);
            return false;
        }
        AppMethodBeat.m2505o(128296);
        return true;
    }

    public void serialize(Bundle bundle) {
        AppMethodBeat.m2504i(128294);
        bundle.putString("_wxemojisharedobject_thumburl", this.thumburl);
        bundle.putInt("_wxemojisharedobject_packageflag", this.packageflag);
        bundle.putString("_wxemojisharedobject_packageid", this.packageid);
        bundle.putString("_wxemojisharedobject_url", this.url);
        AppMethodBeat.m2505o(128294);
    }

    public int type() {
        return 15;
    }

    public void unserialize(Bundle bundle) {
        AppMethodBeat.m2504i(128295);
        this.thumburl = bundle.getString("_wxwebpageobject_thumburl");
        this.packageflag = bundle.getInt("_wxwebpageobject_packageflag");
        this.packageid = bundle.getString("_wxwebpageobject_packageid");
        this.url = bundle.getString("_wxwebpageobject_url");
        AppMethodBeat.m2505o(128295);
    }
}

package com.tencent.p177mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.p177mm.opensdk.utils.C18754d;
import com.tencent.p177mm.opensdk.utils.Log;

/* renamed from: com.tencent.mm.opensdk.modelmsg.WXEmojiPageSharedObject */
public class WXEmojiPageSharedObject implements IMediaObject {
    private static final String TAG = "MicroMsg.SDK.WXEmojiSharedObject";
    public String desc;
    public String iconUrl;
    public int pageType;
    public String secondUrl;
    public int tid;
    public String title;
    public int type;
    public String url;

    public WXEmojiPageSharedObject(int i, int i2, String str, String str2, String str3, String str4, int i3, String str5) {
        this.tid = i2;
        this.title = str;
        this.desc = str2;
        this.iconUrl = str3;
        this.secondUrl = str4;
        this.pageType = i3;
        this.url = str5;
        this.type = i;
    }

    public boolean checkArgs() {
        AppMethodBeat.m2504i(128285);
        if (C18754d.m29305b(this.title) || C18754d.m29305b(this.iconUrl)) {
            Log.m4140e(TAG, "checkArgs fail, title or iconUrl is invalid");
            AppMethodBeat.m2505o(128285);
            return false;
        }
        AppMethodBeat.m2505o(128285);
        return true;
    }

    public void serialize(Bundle bundle) {
        AppMethodBeat.m2504i(128283);
        bundle.putInt("_wxemojisharedobject_tid", this.tid);
        bundle.putString("_wxemojisharedobject_title", this.title);
        bundle.putString("_wxemojisharedobject_desc", this.desc);
        bundle.putString("_wxemojisharedobject_iconurl", this.iconUrl);
        bundle.putString("_wxemojisharedobject_secondurl", this.secondUrl);
        bundle.putInt("_wxemojisharedobject_pagetype", this.pageType);
        bundle.putString("_wxwebpageobject_url", this.url);
        AppMethodBeat.m2505o(128283);
    }

    public int type() {
        return this.type;
    }

    public void unserialize(Bundle bundle) {
        AppMethodBeat.m2504i(128284);
        this.tid = bundle.getInt("_wxemojisharedobject_tid");
        this.title = bundle.getString("_wxemojisharedobject_title");
        this.desc = bundle.getString("_wxemojisharedobject_desc");
        this.iconUrl = bundle.getString("_wxemojisharedobject_iconurl");
        this.secondUrl = bundle.getString("_wxemojisharedobject_secondurl");
        this.pageType = bundle.getInt("_wxemojisharedobject_pagetype");
        this.url = bundle.getString("_wxwebpageobject_url");
        AppMethodBeat.m2505o(128284);
    }
}

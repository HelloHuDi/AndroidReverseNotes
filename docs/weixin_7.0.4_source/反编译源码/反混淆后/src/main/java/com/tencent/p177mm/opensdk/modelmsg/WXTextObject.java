package com.tencent.p177mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.p177mm.opensdk.utils.Log;

/* renamed from: com.tencent.mm.opensdk.modelmsg.WXTextObject */
public class WXTextObject implements IMediaObject {
    private static final int LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXTextObject";
    public String text;

    public WXTextObject() {
        this(null);
    }

    public WXTextObject(String str) {
        this.text = str;
    }

    public boolean checkArgs() {
        AppMethodBeat.m2504i(128282);
        if (this.text == null || this.text.length() == 0 || this.text.length() > 10240) {
            Log.m4140e(TAG, "checkArgs fail, text is invalid");
            AppMethodBeat.m2505o(128282);
            return false;
        }
        AppMethodBeat.m2505o(128282);
        return true;
    }

    public void serialize(Bundle bundle) {
        AppMethodBeat.m2504i(128280);
        bundle.putString("_wxtextobject_text", this.text);
        AppMethodBeat.m2505o(128280);
    }

    public int type() {
        return 1;
    }

    public void unserialize(Bundle bundle) {
        AppMethodBeat.m2504i(128281);
        this.text = bundle.getString("_wxtextobject_text");
        AppMethodBeat.m2505o(128281);
    }
}

package com.tencent.p177mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.p177mm.opensdk.utils.Log;
import java.io.File;

/* renamed from: com.tencent.mm.opensdk.modelmsg.WXEmojiObject */
public class WXEmojiObject implements IMediaObject {
    private static final int CONTENT_LENGTH_LIMIT = 10485760;
    private static final String TAG = "MicroMsg.SDK.WXEmojiObject";
    public byte[] emojiData;
    public String emojiPath;

    public WXEmojiObject() {
        this.emojiData = null;
        this.emojiPath = null;
    }

    public WXEmojiObject(String str) {
        this.emojiPath = str;
    }

    public WXEmojiObject(byte[] bArr) {
        this.emojiData = bArr;
    }

    private int getFileSize(String str) {
        AppMethodBeat.m2504i(128245);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(128245);
            return 0;
        }
        File file = new File(str);
        if (file.exists()) {
            int length = (int) file.length();
            AppMethodBeat.m2505o(128245);
            return length;
        }
        AppMethodBeat.m2505o(128245);
        return 0;
    }

    public boolean checkArgs() {
        AppMethodBeat.m2504i(128244);
        if ((this.emojiData == null || this.emojiData.length == 0) && (this.emojiPath == null || this.emojiPath.length() == 0)) {
            Log.m4140e(TAG, "checkArgs fail, both arguments is null");
            AppMethodBeat.m2505o(128244);
            return false;
        } else if (this.emojiData != null && this.emojiData.length > CONTENT_LENGTH_LIMIT) {
            Log.m4140e(TAG, "checkArgs fail, emojiData is too large");
            AppMethodBeat.m2505o(128244);
            return false;
        } else if (this.emojiPath == null || getFileSize(this.emojiPath) <= CONTENT_LENGTH_LIMIT) {
            AppMethodBeat.m2505o(128244);
            return true;
        } else {
            Log.m4140e(TAG, "checkArgs fail, emojiSize is too large");
            AppMethodBeat.m2505o(128244);
            return false;
        }
    }

    public void serialize(Bundle bundle) {
        AppMethodBeat.m2504i(128242);
        bundle.putByteArray("_wxemojiobject_emojiData", this.emojiData);
        bundle.putString("_wxemojiobject_emojiPath", this.emojiPath);
        AppMethodBeat.m2505o(128242);
    }

    public void setEmojiData(byte[] bArr) {
        this.emojiData = bArr;
    }

    public void setEmojiPath(String str) {
        this.emojiPath = str;
    }

    public int type() {
        return 8;
    }

    public void unserialize(Bundle bundle) {
        AppMethodBeat.m2504i(128243);
        this.emojiData = bundle.getByteArray("_wxemojiobject_emojiData");
        this.emojiPath = bundle.getString("_wxemojiobject_emojiPath");
        AppMethodBeat.m2505o(128243);
    }
}

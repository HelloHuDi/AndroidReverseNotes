package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.utils.Log;
import java.io.File;

public class WXVideoFileObject implements IMediaObject {
    private static final int FILE_SIZE_LIMIT = 10485760;
    private static final String TAG = "MicroMsg.SDK.WXVideoFileObject";
    public static final int WXVideoFileShareSceneCommon = 0;
    public static final int WXVideoFileShareSceneFromWX = 1;
    public String filePath;
    public int shareScene;
    public String shareTicket;

    public WXVideoFileObject() {
        this.shareScene = 0;
        this.filePath = null;
    }

    public WXVideoFileObject(String str) {
        this.shareScene = 0;
        this.filePath = str;
    }

    private int getFileSize(String str) {
        AppMethodBeat.i(128261);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(128261);
            return 0;
        }
        File file = new File(str);
        if (file.exists()) {
            int length = (int) file.length();
            AppMethodBeat.o(128261);
            return length;
        }
        AppMethodBeat.o(128261);
        return 0;
    }

    public boolean checkArgs() {
        AppMethodBeat.i(128260);
        if (this.filePath == null || this.filePath.length() == 0) {
            Log.e(TAG, "checkArgs fail, filePath is null");
            AppMethodBeat.o(128260);
            return false;
        } else if (getFileSize(this.filePath) > FILE_SIZE_LIMIT) {
            Log.e(TAG, "checkArgs fail, video file size is too large");
            AppMethodBeat.o(128260);
            return false;
        } else {
            AppMethodBeat.o(128260);
            return true;
        }
    }

    public void serialize(Bundle bundle) {
        AppMethodBeat.i(128258);
        bundle.putString("_wxvideofileobject_filePath", this.filePath);
        bundle.putInt("_wxvideofileobject_shareScene", this.shareScene);
        bundle.putString("_wxvideofileobject_shareTicketh", this.shareTicket);
        AppMethodBeat.o(128258);
    }

    public int type() {
        return 38;
    }

    public void unserialize(Bundle bundle) {
        AppMethodBeat.i(128259);
        this.filePath = bundle.getString("_wxvideofileobject_filePath");
        this.shareScene = bundle.getInt("_wxvideofileobject_shareScene", 0);
        this.shareTicket = bundle.getString("_wxvideofileobject_shareTicketh");
        AppMethodBeat.o(128259);
    }
}

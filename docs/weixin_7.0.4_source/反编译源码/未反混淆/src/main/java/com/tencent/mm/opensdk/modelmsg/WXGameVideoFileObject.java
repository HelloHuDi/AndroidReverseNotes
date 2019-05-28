package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.utils.Log;
import java.io.File;

public class WXGameVideoFileObject implements IMediaObject {
    private static final int FILE_SIZE_LIMIT = 10485760;
    private static final String TAG = "MicroMsg.SDK.WXGameVideoFileObject";
    private static final int URL_LENGTH_LIMIT = 10240;
    public String filePath;
    public String thumbUrl;
    public String videoUrl;

    public WXGameVideoFileObject() {
        this.filePath = null;
        this.videoUrl = null;
        this.thumbUrl = null;
    }

    public WXGameVideoFileObject(String str, String str2, String str3) {
        this.filePath = str;
        this.videoUrl = str2;
        this.thumbUrl = str3;
    }

    private int getFileSize(String str) {
        AppMethodBeat.i(128327);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(128327);
            return 0;
        }
        File file = new File(str);
        if (file.exists()) {
            int length = (int) file.length();
            AppMethodBeat.o(128327);
            return length;
        }
        AppMethodBeat.o(128327);
        return 0;
    }

    public boolean checkArgs() {
        AppMethodBeat.i(128326);
        if (this.filePath == null || this.filePath.length() == 0) {
            Log.e(TAG, "checkArgs fail, filePath is null");
            AppMethodBeat.o(128326);
            return false;
        } else if (getFileSize(this.filePath) > FILE_SIZE_LIMIT) {
            Log.e(TAG, "checkArgs fail, video file size is too large");
            AppMethodBeat.o(128326);
            return false;
        } else if (this.videoUrl != null && this.videoUrl.length() > 10240) {
            Log.e(TAG, "checkArgs fail, videoUrl is too long");
            AppMethodBeat.o(128326);
            return false;
        } else if (this.thumbUrl == null || this.thumbUrl.length() <= 10240) {
            AppMethodBeat.o(128326);
            return true;
        } else {
            Log.e(TAG, "checkArgs fail, thumbUrl is too long");
            AppMethodBeat.o(128326);
            return false;
        }
    }

    public void serialize(Bundle bundle) {
        AppMethodBeat.i(128324);
        bundle.putString("_wxvideofileobject_filePath", this.filePath);
        bundle.putString("_wxvideofileobject_cdnUrl", this.videoUrl);
        bundle.putString("_wxvideofileobject_thumbUrl", this.thumbUrl);
        AppMethodBeat.o(128324);
    }

    public int type() {
        return 39;
    }

    public void unserialize(Bundle bundle) {
        AppMethodBeat.i(128325);
        this.filePath = bundle.getString("_wxvideofileobject_filePath");
        this.videoUrl = bundle.getString("_wxvideofileobject_cdnUrl");
        this.thumbUrl = bundle.getString("_wxvideofileobject_thumbUrl");
        AppMethodBeat.o(128325);
    }
}

package com.tencent.p177mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.p177mm.opensdk.utils.Log;
import java.io.File;

/* renamed from: com.tencent.mm.opensdk.modelmsg.WXGameVideoFileObject */
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
        AppMethodBeat.m2504i(128327);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(128327);
            return 0;
        }
        File file = new File(str);
        if (file.exists()) {
            int length = (int) file.length();
            AppMethodBeat.m2505o(128327);
            return length;
        }
        AppMethodBeat.m2505o(128327);
        return 0;
    }

    public boolean checkArgs() {
        AppMethodBeat.m2504i(128326);
        if (this.filePath == null || this.filePath.length() == 0) {
            Log.m4140e(TAG, "checkArgs fail, filePath is null");
            AppMethodBeat.m2505o(128326);
            return false;
        } else if (getFileSize(this.filePath) > FILE_SIZE_LIMIT) {
            Log.m4140e(TAG, "checkArgs fail, video file size is too large");
            AppMethodBeat.m2505o(128326);
            return false;
        } else if (this.videoUrl != null && this.videoUrl.length() > 10240) {
            Log.m4140e(TAG, "checkArgs fail, videoUrl is too long");
            AppMethodBeat.m2505o(128326);
            return false;
        } else if (this.thumbUrl == null || this.thumbUrl.length() <= 10240) {
            AppMethodBeat.m2505o(128326);
            return true;
        } else {
            Log.m4140e(TAG, "checkArgs fail, thumbUrl is too long");
            AppMethodBeat.m2505o(128326);
            return false;
        }
    }

    public void serialize(Bundle bundle) {
        AppMethodBeat.m2504i(128324);
        bundle.putString("_wxvideofileobject_filePath", this.filePath);
        bundle.putString("_wxvideofileobject_cdnUrl", this.videoUrl);
        bundle.putString("_wxvideofileobject_thumbUrl", this.thumbUrl);
        AppMethodBeat.m2505o(128324);
    }

    public int type() {
        return 39;
    }

    public void unserialize(Bundle bundle) {
        AppMethodBeat.m2504i(128325);
        this.filePath = bundle.getString("_wxvideofileobject_filePath");
        this.videoUrl = bundle.getString("_wxvideofileobject_cdnUrl");
        this.thumbUrl = bundle.getString("_wxvideofileobject_thumbUrl");
        AppMethodBeat.m2505o(128325);
    }
}

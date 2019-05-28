package com.tencent.p177mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.p177mm.opensdk.utils.Log;
import java.io.File;

/* renamed from: com.tencent.mm.opensdk.modelmsg.WXAppExtendObject */
public class WXAppExtendObject implements IMediaObject {
    private static final int CONTENT_LENGTH_LIMIT = 10485760;
    private static final int EXTINFO_LENGTH_LIMIT = 2048;
    private static final int PATH_LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXAppExtendObject";
    public String extInfo;
    public byte[] fileData;
    public String filePath;

    public WXAppExtendObject(String str, String str2) {
        this.extInfo = str;
        this.filePath = str2;
    }

    public WXAppExtendObject(String str, byte[] bArr) {
        this.extInfo = str;
        this.fileData = bArr;
    }

    private int getFileSize(String str) {
        AppMethodBeat.m2504i(128256);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(128256);
            return 0;
        }
        File file = new File(str);
        if (file.exists()) {
            int length = (int) file.length();
            AppMethodBeat.m2505o(128256);
            return length;
        }
        AppMethodBeat.m2505o(128256);
        return 0;
    }

    public boolean checkArgs() {
        AppMethodBeat.m2504i(128255);
        if ((this.extInfo == null || this.extInfo.length() == 0) && ((this.filePath == null || this.filePath.length() == 0) && (this.fileData == null || this.fileData.length == 0))) {
            Log.m4140e(TAG, "checkArgs fail, all arguments is null");
            AppMethodBeat.m2505o(128255);
            return false;
        } else if (this.extInfo != null && this.extInfo.length() > 2048) {
            Log.m4140e(TAG, "checkArgs fail, extInfo is invalid");
            AppMethodBeat.m2505o(128255);
            return false;
        } else if (this.filePath != null && this.filePath.length() > 10240) {
            Log.m4140e(TAG, "checkArgs fail, filePath is invalid");
            AppMethodBeat.m2505o(128255);
            return false;
        } else if (this.filePath != null && getFileSize(this.filePath) > CONTENT_LENGTH_LIMIT) {
            Log.m4140e(TAG, "checkArgs fail, fileSize is too large");
            AppMethodBeat.m2505o(128255);
            return false;
        } else if (this.fileData == null || this.fileData.length <= CONTENT_LENGTH_LIMIT) {
            AppMethodBeat.m2505o(128255);
            return true;
        } else {
            Log.m4140e(TAG, "checkArgs fail, fileData is too large");
            AppMethodBeat.m2505o(128255);
            return false;
        }
    }

    public void serialize(Bundle bundle) {
        AppMethodBeat.m2504i(128253);
        bundle.putString("_wxappextendobject_extInfo", this.extInfo);
        bundle.putByteArray("_wxappextendobject_fileData", this.fileData);
        bundle.putString("_wxappextendobject_filePath", this.filePath);
        AppMethodBeat.m2505o(128253);
    }

    public int type() {
        return 7;
    }

    public void unserialize(Bundle bundle) {
        AppMethodBeat.m2504i(128254);
        this.extInfo = bundle.getString("_wxappextendobject_extInfo");
        this.fileData = bundle.getByteArray("_wxappextendobject_fileData");
        this.filePath = bundle.getString("_wxappextendobject_filePath");
        AppMethodBeat.m2505o(128254);
    }
}

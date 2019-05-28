package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.utils.Log;
import java.io.File;

public class WXFileObject implements IMediaObject {
    private static final int CONTENT_LENGTH_LIMIT = 10485760;
    private static final String TAG = "MicroMsg.SDK.WXFileObject";
    private int contentLengthLimit;
    public byte[] fileData;
    public String filePath;

    public WXFileObject() {
        this.contentLengthLimit = CONTENT_LENGTH_LIMIT;
        this.fileData = null;
        this.filePath = null;
    }

    public WXFileObject(String str) {
        this.contentLengthLimit = CONTENT_LENGTH_LIMIT;
        this.filePath = str;
    }

    public WXFileObject(byte[] bArr) {
        this.contentLengthLimit = CONTENT_LENGTH_LIMIT;
        this.fileData = bArr;
    }

    private int getFileSize(String str) {
        AppMethodBeat.i(128307);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(128307);
            return 0;
        }
        File file = new File(str);
        if (file.exists()) {
            int length = (int) file.length();
            AppMethodBeat.o(128307);
            return length;
        }
        AppMethodBeat.o(128307);
        return 0;
    }

    public boolean checkArgs() {
        AppMethodBeat.i(128306);
        if ((this.fileData == null || this.fileData.length == 0) && (this.filePath == null || this.filePath.length() == 0)) {
            Log.e(TAG, "checkArgs fail, both arguments is null");
            AppMethodBeat.o(128306);
            return false;
        } else if (this.fileData != null && this.fileData.length > this.contentLengthLimit) {
            Log.e(TAG, "checkArgs fail, fileData is too large");
            AppMethodBeat.o(128306);
            return false;
        } else if (this.filePath == null || getFileSize(this.filePath) <= this.contentLengthLimit) {
            AppMethodBeat.o(128306);
            return true;
        } else {
            Log.e(TAG, "checkArgs fail, fileSize is too large");
            AppMethodBeat.o(128306);
            return false;
        }
    }

    public void serialize(Bundle bundle) {
        AppMethodBeat.i(128304);
        bundle.putByteArray("_wxfileobject_fileData", this.fileData);
        bundle.putString("_wxfileobject_filePath", this.filePath);
        AppMethodBeat.o(128304);
    }

    public void setContentLengthLimit(int i) {
        this.contentLengthLimit = i;
    }

    public void setFileData(byte[] bArr) {
        this.fileData = bArr;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public int type() {
        return 6;
    }

    public void unserialize(Bundle bundle) {
        AppMethodBeat.i(128305);
        this.fileData = bundle.getByteArray("_wxfileobject_fileData");
        this.filePath = bundle.getString("_wxfileobject_filePath");
        AppMethodBeat.o(128305);
    }
}

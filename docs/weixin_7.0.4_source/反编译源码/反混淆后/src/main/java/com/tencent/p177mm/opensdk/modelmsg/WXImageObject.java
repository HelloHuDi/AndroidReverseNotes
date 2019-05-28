package com.tencent.p177mm.opensdk.modelmsg;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.p177mm.opensdk.utils.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;

/* renamed from: com.tencent.mm.opensdk.modelmsg.WXImageObject */
public class WXImageObject implements IMediaObject {
    private static final int CONTENT_LENGTH_LIMIT = 26214400;
    private static final int PATH_LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXImageObject";
    public byte[] imageData;
    public String imagePath;

    public WXImageObject(Bitmap bitmap) {
        AppMethodBeat.m2504i(128286);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(CompressFormat.JPEG, 85, byteArrayOutputStream);
            this.imageData = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            AppMethodBeat.m2505o(128286);
        } catch (Exception e) {
            Log.m4140e(TAG, "WXImageObject <init>, exception:" + e.getMessage());
            AppMethodBeat.m2505o(128286);
        }
    }

    public WXImageObject(byte[] bArr) {
        this.imageData = bArr;
    }

    private int getFileSize(String str) {
        AppMethodBeat.m2504i(128290);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(128290);
            return 0;
        }
        File file = new File(str);
        if (file.exists()) {
            int length = (int) file.length();
            AppMethodBeat.m2505o(128290);
            return length;
        }
        AppMethodBeat.m2505o(128290);
        return 0;
    }

    public boolean checkArgs() {
        AppMethodBeat.m2504i(128289);
        if ((this.imageData == null || this.imageData.length == 0) && (this.imagePath == null || this.imagePath.length() == 0)) {
            Log.m4140e(TAG, "checkArgs fail, all arguments are null");
            AppMethodBeat.m2505o(128289);
            return false;
        } else if (this.imageData != null && this.imageData.length > CONTENT_LENGTH_LIMIT) {
            Log.m4140e(TAG, "checkArgs fail, content is too large");
            AppMethodBeat.m2505o(128289);
            return false;
        } else if (this.imagePath != null && this.imagePath.length() > 10240) {
            Log.m4140e(TAG, "checkArgs fail, path is invalid");
            AppMethodBeat.m2505o(128289);
            return false;
        } else if (this.imagePath == null || getFileSize(this.imagePath) <= CONTENT_LENGTH_LIMIT) {
            AppMethodBeat.m2505o(128289);
            return true;
        } else {
            Log.m4140e(TAG, "checkArgs fail, image content is too large");
            AppMethodBeat.m2505o(128289);
            return false;
        }
    }

    public void serialize(Bundle bundle) {
        AppMethodBeat.m2504i(128287);
        bundle.putByteArray("_wximageobject_imageData", this.imageData);
        bundle.putString("_wximageobject_imagePath", this.imagePath);
        AppMethodBeat.m2505o(128287);
    }

    public void setImagePath(String str) {
        this.imagePath = str;
    }

    public int type() {
        return 2;
    }

    public void unserialize(Bundle bundle) {
        AppMethodBeat.m2504i(128288);
        this.imageData = bundle.getByteArray("_wximageobject_imageData");
        this.imagePath = bundle.getString("_wximageobject_imagePath");
        AppMethodBeat.m2505o(128288);
    }
}

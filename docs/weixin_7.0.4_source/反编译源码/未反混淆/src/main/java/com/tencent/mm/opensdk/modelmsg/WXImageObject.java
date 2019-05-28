package com.tencent.mm.opensdk.modelmsg;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.utils.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;

public class WXImageObject implements IMediaObject {
    private static final int CONTENT_LENGTH_LIMIT = 26214400;
    private static final int PATH_LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXImageObject";
    public byte[] imageData;
    public String imagePath;

    public WXImageObject(Bitmap bitmap) {
        AppMethodBeat.i(128286);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(CompressFormat.JPEG, 85, byteArrayOutputStream);
            this.imageData = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            AppMethodBeat.o(128286);
        } catch (Exception e) {
            Log.e(TAG, "WXImageObject <init>, exception:" + e.getMessage());
            AppMethodBeat.o(128286);
        }
    }

    public WXImageObject(byte[] bArr) {
        this.imageData = bArr;
    }

    private int getFileSize(String str) {
        AppMethodBeat.i(128290);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(128290);
            return 0;
        }
        File file = new File(str);
        if (file.exists()) {
            int length = (int) file.length();
            AppMethodBeat.o(128290);
            return length;
        }
        AppMethodBeat.o(128290);
        return 0;
    }

    public boolean checkArgs() {
        AppMethodBeat.i(128289);
        if ((this.imageData == null || this.imageData.length == 0) && (this.imagePath == null || this.imagePath.length() == 0)) {
            Log.e(TAG, "checkArgs fail, all arguments are null");
            AppMethodBeat.o(128289);
            return false;
        } else if (this.imageData != null && this.imageData.length > CONTENT_LENGTH_LIMIT) {
            Log.e(TAG, "checkArgs fail, content is too large");
            AppMethodBeat.o(128289);
            return false;
        } else if (this.imagePath != null && this.imagePath.length() > 10240) {
            Log.e(TAG, "checkArgs fail, path is invalid");
            AppMethodBeat.o(128289);
            return false;
        } else if (this.imagePath == null || getFileSize(this.imagePath) <= CONTENT_LENGTH_LIMIT) {
            AppMethodBeat.o(128289);
            return true;
        } else {
            Log.e(TAG, "checkArgs fail, image content is too large");
            AppMethodBeat.o(128289);
            return false;
        }
    }

    public void serialize(Bundle bundle) {
        AppMethodBeat.i(128287);
        bundle.putByteArray("_wximageobject_imageData", this.imageData);
        bundle.putString("_wximageobject_imagePath", this.imagePath);
        AppMethodBeat.o(128287);
    }

    public void setImagePath(String str) {
        this.imagePath = str;
    }

    public int type() {
        return 2;
    }

    public void unserialize(Bundle bundle) {
        AppMethodBeat.i(128288);
        this.imageData = bundle.getByteArray("_wximageobject_imageData");
        this.imagePath = bundle.getString("_wximageobject_imagePath");
        AppMethodBeat.o(128288);
    }
}

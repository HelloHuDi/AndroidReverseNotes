package com.google.android.gms.common.util;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.database.CharArrayBuffer;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class DataUtils {
    public static void copyStringToBuffer(String str, CharArrayBuffer charArrayBuffer) {
        AppMethodBeat.m2504i(90143);
        if (TextUtils.isEmpty(str)) {
            charArrayBuffer.sizeCopied = 0;
        } else if (charArrayBuffer.data == null || charArrayBuffer.data.length < str.length()) {
            charArrayBuffer.data = str.toCharArray();
        } else {
            str.getChars(0, str.length(), charArrayBuffer.data, 0);
        }
        charArrayBuffer.sizeCopied = str.length();
        AppMethodBeat.m2505o(90143);
    }

    public static byte[] loadImageBytes(AssetManager assetManager, String str) {
        AppMethodBeat.m2504i(90145);
        try {
            byte[] readInputStreamFully = IOUtils.readInputStreamFully(assetManager.open(str));
            AppMethodBeat.m2505o(90145);
            return readInputStreamFully;
        } catch (IOException e) {
            RuntimeException runtimeException = new RuntimeException(e);
            AppMethodBeat.m2505o(90145);
            throw runtimeException;
        }
    }

    @VisibleForTesting
    public static byte[] loadImageBytes(Resources resources, int i) {
        AppMethodBeat.m2504i(90144);
        try {
            byte[] readInputStreamFully = IOUtils.readInputStreamFully(resources.openRawResource(i));
            AppMethodBeat.m2505o(90144);
            return readInputStreamFully;
        } catch (IOException e) {
            RuntimeException runtimeException = new RuntimeException(e);
            AppMethodBeat.m2505o(90144);
            throw runtimeException;
        }
    }

    public static byte[] loadImageBytes(Bitmap bitmap) {
        AppMethodBeat.m2504i(90147);
        byte[] loadImageBytes = loadImageBytes(bitmap, 100);
        AppMethodBeat.m2505o(90147);
        return loadImageBytes;
    }

    public static byte[] loadImageBytes(Bitmap bitmap, int i) {
        AppMethodBeat.m2504i(90148);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.JPEG, i, byteArrayOutputStream);
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        AppMethodBeat.m2505o(90148);
        return toByteArray;
    }

    public static byte[] loadImageBytes(BitmapDrawable bitmapDrawable) {
        AppMethodBeat.m2504i(90146);
        byte[] loadImageBytes = loadImageBytes(bitmapDrawable.getBitmap());
        AppMethodBeat.m2505o(90146);
        return loadImageBytes;
    }
}

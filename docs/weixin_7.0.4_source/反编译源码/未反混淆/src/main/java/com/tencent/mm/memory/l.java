package com.tencent.mm.memory;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public abstract class l {
    private static j fdH = new j();
    private static m fdI = new m();
    private static int fdJ = -1;

    public abstract Bitmap a(String str, Options options);

    public abstract Bitmap a(String str, Rect rect, Options options);

    public abstract void v(Bitmap bitmap);

    public static boolean Xg() {
        boolean iW = d.iW(19);
        boolean dpH = bo.dpH();
        ab.i("MicroMsg.PlatformBitmapFactory", "canUseInBitmapFactory, isVersionMatch: %b, isART: %b, result: %s", Boolean.valueOf(iW), Boolean.valueOf(dpH), Boolean.valueOf(iW));
        return iW;
    }

    protected static InputStream t(InputStream inputStream) {
        if (inputStream.markSupported()) {
            return inputStream;
        }
        if (inputStream instanceof FileInputStream) {
            return new com.tencent.mm.sdk.platformtools.l((FileInputStream) inputStream);
        }
        return new BufferedInputStream(inputStream);
    }

    protected static void u(InputStream inputStream) {
        try {
            inputStream.reset();
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.PlatformBitmapFactory", e, "reset stream error: %s", e.getMessage());
        }
    }

    public static l Xf() {
        if (fdJ == -1) {
            if (Xg()) {
                fdJ = 1;
            } else {
                fdJ = 2;
            }
        }
        switch (fdJ) {
            case 1:
                return fdH;
            case 2:
                return fdI;
            default:
                return fdI;
        }
    }
}

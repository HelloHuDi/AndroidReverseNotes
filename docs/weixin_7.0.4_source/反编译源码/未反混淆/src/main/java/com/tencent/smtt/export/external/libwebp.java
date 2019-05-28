package com.tencent.smtt.export.external;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class libwebp {
    private static final int BITMAP_ALPHA_8 = 1;
    private static final int BITMAP_ARGB_4444 = 3;
    private static final int BITMAP_ARGB_8888 = 4;
    private static final int BITMAP_RGB_565 = 2;
    private static final String LOGTAG = "[image]";
    private static boolean isMultiCore = false;
    private static libwebp mInstance = null;
    private static boolean mIsLoadLibSuccess = false;
    private int mBitmapType = 4;

    /* renamed from: com.tencent.smtt.export.external.libwebp$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config = new int[Config.values().length];

        static {
            AppMethodBeat.i(63821);
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Config.ARGB_4444.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Config.RGB_565.ordinal()] = 2;
                AppMethodBeat.o(63821);
            } catch (NoSuchFieldError e2) {
                AppMethodBeat.o(63821);
            }
        }
    }

    public static int checkIsHuaModel() {
        int i = 1;
        AppMethodBeat.i(63832);
        String toLowerCase = Build.BRAND.trim().toLowerCase();
        String toLowerCase2 = Build.MODEL.trim().toLowerCase();
        int i2 = 0;
        if (toLowerCase != null && toLowerCase.length() > 0 && toLowerCase.contains("huawei")) {
            i2 = 1;
        }
        if (toLowerCase2 == null || toLowerCase2.length() <= 0 || !toLowerCase2.contains("huawei")) {
            i = i2;
        }
        AppMethodBeat.o(63832);
        return i;
    }

    private String getCPUinfo() {
        AppMethodBeat.i(63826);
        String str = "";
        try {
            InputStream inputStream = new ProcessBuilder(new String[]{"/system/bin/cat", "/proc/cpuinfo"}).start().getInputStream();
            byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
            while (inputStream.read(bArr) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
        } catch (IOException e) {
        }
        AppMethodBeat.o(63826);
        return str;
    }

    public static libwebp getInstance(Context context) {
        AppMethodBeat.i(63822);
        if (mInstance == null) {
            loadWepLibraryIfNeed(context);
            mInstance = new libwebp();
        }
        libwebp libwebp = mInstance;
        AppMethodBeat.o(63822);
        return libwebp;
    }

    private boolean isMultiCore() {
        AppMethodBeat.i(63825);
        boolean contains = getCPUinfo().contains("processor");
        AppMethodBeat.o(63825);
        return contains;
    }

    public static void loadWepLibraryIfNeed(Context context) {
        AppMethodBeat.i(63824);
        if (!mIsLoadLibSuccess) {
            try {
                LibraryLoader.loadLibrary(context, "webp_base");
                mIsLoadLibSuccess = true;
                AppMethodBeat.o(63824);
                return;
            } catch (UnsatisfiedLinkError e) {
            }
        }
        AppMethodBeat.o(63824);
    }

    public static void loadWepLibraryIfNeed(Context context, String str) {
        AppMethodBeat.i(63823);
        if (!mIsLoadLibSuccess) {
            try {
                System.load(str + File.separator + "libwebp_base.so");
                mIsLoadLibSuccess = true;
                AppMethodBeat.o(63823);
                return;
            } catch (UnsatisfiedLinkError e) {
            }
        }
        AppMethodBeat.o(63823);
    }

    public int[] decodeBase(byte[] bArr, int[] iArr, int[] iArr2) {
        AppMethodBeat.i(63828);
        if (mIsLoadLibSuccess) {
            int[] nativeDecode = nativeDecode(bArr, isMultiCore, iArr, iArr2);
            AppMethodBeat.o(63828);
            return nativeDecode;
        }
        AppMethodBeat.o(63828);
        return null;
    }

    public int[] decodeBase_16bit(byte[] bArr, Config config) {
        AppMethodBeat.i(63829);
        if (mIsLoadLibSuccess) {
            switch (AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[config.ordinal()]) {
                case 1:
                    this.mBitmapType = 3;
                    break;
                case 2:
                    this.mBitmapType = 2;
                    break;
                default:
                    this.mBitmapType = 2;
                    break;
            }
            int[] nativeDecode_16bit = nativeDecode_16bit(bArr, isMultiCore, this.mBitmapType);
            AppMethodBeat.o(63829);
            return nativeDecode_16bit;
        }
        AppMethodBeat.o(63829);
        return null;
    }

    public int[] decodeInto(byte[] bArr, int[] iArr, int[] iArr2) {
        AppMethodBeat.i(63830);
        if (mIsLoadLibSuccess) {
            int[] nativeDecodeInto = nativeDecodeInto(bArr, isMultiCore, iArr, iArr2);
            AppMethodBeat.o(63830);
            return nativeDecodeInto;
        }
        AppMethodBeat.o(63830);
        return null;
    }

    public int getInfo(byte[] bArr, int[] iArr, int[] iArr2) {
        AppMethodBeat.i(63827);
        if (mIsLoadLibSuccess) {
            int nativeGetInfo = nativeGetInfo(bArr, iArr, iArr2);
            AppMethodBeat.o(63827);
            return nativeGetInfo;
        }
        AppMethodBeat.o(63827);
        return 0;
    }

    public int[] incDecode(byte[] bArr, int[] iArr, int[] iArr2) {
        AppMethodBeat.i(63831);
        if (mIsLoadLibSuccess) {
            int[] nativeIDecode = nativeIDecode(bArr, isMultiCore, iArr, iArr2);
            AppMethodBeat.o(63831);
            return nativeIDecode;
        }
        AppMethodBeat.o(63831);
        return null;
    }

    public native int[] nativeDecode(byte[] bArr, boolean z, int[] iArr, int[] iArr2);

    public native int[] nativeDecodeInto(byte[] bArr, boolean z, int[] iArr, int[] iArr2);

    public native int[] nativeDecode_16bit(byte[] bArr, boolean z, int i);

    public native int nativeGetInfo(byte[] bArr, int[] iArr, int[] iArr2);

    public native int[] nativeIDecode(byte[] bArr, boolean z, int[] iArr, int[] iArr2);
}

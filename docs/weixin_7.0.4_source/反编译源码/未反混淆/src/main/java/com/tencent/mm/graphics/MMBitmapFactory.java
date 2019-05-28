package com.tencent.mm.graphics;

import android.content.res.AssetManager.AssetInputStream;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.Keep;
import android.util.TypedValue;
import com.tencent.e.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

@Keep
public class MMBitmapFactory {
    private static final int DENSITY_DEFAULT = 160;
    private static final int REWIND_BUFFER_SIZE = 262144;
    private static final String TAG = "MicroMsg.MMBitmapFactory";
    private static final int TEMP_STORAGE_SIZE = 4096;

    @Keep
    public static class Options extends android.graphics.BitmapFactory.Options {
        @Keep
        public boolean inUseSmoothSample = false;
    }

    static class a extends FilterInputStream {
        private long eCr = 0;

        public a(FileInputStream fileInputStream) {
            super(fileInputStream);
        }

        public final boolean markSupported() {
            return true;
        }

        public final synchronized void mark(int i) {
            AppMethodBeat.i(138503);
            try {
                this.eCr = ((FileInputStream) this.in).getChannel().position();
                AppMethodBeat.o(138503);
            } catch (IOException e) {
                b.b(MMBitmapFactory.TAG, e, "fail to mark position.");
                this.eCr = -1;
                AppMethodBeat.o(138503);
            }
            return;
        }

        public final synchronized void reset() {
            AppMethodBeat.i(138504);
            if (this.eCr < 0) {
                IOException iOException = new IOException("Illegal marked position: " + this.eCr);
                AppMethodBeat.o(138504);
                throw iOException;
            }
            ((FileInputStream) this.in).getChannel().position(this.eCr);
            AppMethodBeat.o(138504);
        }
    }

    private static native void nativeAddExternalLibDir(String str);

    private static native Bitmap nativeDecodeByteArray(byte[] bArr, int i, int i2, android.graphics.BitmapFactory.Options options);

    private static native Bitmap nativeDecodeFileDescriptor(FileDescriptor fileDescriptor, byte[] bArr, Rect rect, android.graphics.BitmapFactory.Options options);

    private static native Bitmap nativeDecodeStream(InputStream inputStream, Rect rect, android.graphics.BitmapFactory.Options options);

    private static native boolean nativeIsSeekable(FileDescriptor fileDescriptor);

    private static native int nativePinBitmap(Bitmap bitmap);

    private static native int nativeUnPinBitmap(Bitmap bitmap);

    public static void addExternalCodecLibDir(String str) {
        AppMethodBeat.i(57633);
        b.i(TAG, "[+] add external codec library path: %s", str);
        nativeAddExternalLibDir(str);
        AppMethodBeat.o(57633);
    }

    public static String getVersion() {
        return "0.2.18";
    }

    public static Bitmap decodeResource(Resources resources, int i) {
        AppMethodBeat.i(57634);
        b.d(TAG, "[*] transfer invocation to BitmapFactory.decodeResource, res: %s, id: %s", resources, Integer.valueOf(i));
        Bitmap decodeResource = BitmapFactory.decodeResource(resources, i);
        AppMethodBeat.o(57634);
        return decodeResource;
    }

    public static Bitmap decodeResource(Resources resources, int i, android.graphics.BitmapFactory.Options options) {
        AppMethodBeat.i(57635);
        b.d(TAG, "[*] transfer invocation to BitmapFactory.decodeResource, res: %s, id: %s, opts: %s", resources, Integer.valueOf(i), options);
        Bitmap decodeResource = BitmapFactory.decodeResource(resources, i, options);
        AppMethodBeat.o(57635);
        return decodeResource;
    }

    public static Bitmap decodeResourceStream(Resources resources, TypedValue typedValue, InputStream inputStream, Rect rect, android.graphics.BitmapFactory.Options options) {
        AppMethodBeat.i(57636);
        b.d(TAG, "[*] transfer invocation to BitmapFactory.decodeResourceStream, res: %s, value: %s, is: %s, pad: %s, opts: %s", resources, typedValue, inputStream, rect, options);
        Bitmap decodeResourceStream = BitmapFactory.decodeResourceStream(resources, typedValue, inputStream, rect, options);
        AppMethodBeat.o(57636);
        return decodeResourceStream;
    }

    public static Bitmap decodeFile(String str) {
        AppMethodBeat.i(57637);
        assertNotNull(str, "'pathName' is null.");
        Bitmap decodeFileInternal = decodeFileInternal(str, null);
        AppMethodBeat.o(57637);
        return decodeFileInternal;
    }

    public static Bitmap decodeFile(String str, android.graphics.BitmapFactory.Options options) {
        AppMethodBeat.i(57638);
        assertNotNull(str, "'pathName' is null.");
        Bitmap decodeFileInternal = decodeFileInternal(str, options);
        AppMethodBeat.o(57638);
        return decodeFileInternal;
    }

    private static Bitmap decodeFileInternal(String str, android.graphics.BitmapFactory.Options options) {
        Throwable th;
        int i = 0;
        AppMethodBeat.i(57639);
        if (options == null) {
            options = new android.graphics.BitmapFactory.Options();
        }
        Bitmap decodeFile;
        if (isForceSystemDecoder(options)) {
            b.w(TAG, "[!] force decoding file %s by system codec.", str);
            decodeFile = BitmapFactory.decodeFile(str, options);
            announceDecodeResult(options, decodeFile, true);
            AppMethodBeat.o(57639);
            return decodeFile;
        }
        Closeable wrapUnResetableStreamOnDemand;
        try {
            wrapUnResetableStreamOnDemand = wrapUnResetableStreamOnDemand(new FileInputStream(str));
            try {
                wrapUnResetableStreamOnDemand.mark(getCompatibleRewindBufferSize());
                Bitmap nativeDecodeStream = nativeDecodeStream(wrapUnResetableStreamOnDemand, null, options);
                if (options.outMimeType != null) {
                    i = 1;
                }
                if (i != 0) {
                    announceDecodeResult(options, nativeDecodeStream, false);
                    setDensityFromOptions(nativeDecodeStream, options);
                    decodeFile = scaleBitmapOnDemand(nativeDecodeStream, options);
                    closeQuietly(wrapUnResetableStreamOnDemand);
                    AppMethodBeat.o(57639);
                    return decodeFile;
                }
                b.w(TAG, "[!] unsupported image format, try to decode with system codec.");
                wrapUnResetableStreamOnDemand.reset();
                decodeFile = BitmapFactory.decodeFile(str, options);
                announceDecodeResult(options, decodeFile, true);
                closeQuietly(wrapUnResetableStreamOnDemand);
                AppMethodBeat.o(57639);
                return decodeFile;
            } catch (Throwable th2) {
                th = th2;
                try {
                    b.b(TAG, th, "decode failed.");
                    closeQuietly(wrapUnResetableStreamOnDemand);
                    AppMethodBeat.o(57639);
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    closeQuietly(wrapUnResetableStreamOnDemand);
                    AppMethodBeat.o(57639);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            wrapUnResetableStreamOnDemand = null;
            closeQuietly(wrapUnResetableStreamOnDemand);
            AppMethodBeat.o(57639);
            throw th;
        }
    }

    public static Bitmap decodeFileDescriptor(FileDescriptor fileDescriptor) {
        AppMethodBeat.i(57640);
        assertNotNull(fileDescriptor, "'fd' is null.");
        Bitmap decodeFileDescriptorInternal = decodeFileDescriptorInternal(fileDescriptor, null, null);
        AppMethodBeat.o(57640);
        return decodeFileDescriptorInternal;
    }

    public static Bitmap decodeFileDescriptor(FileDescriptor fileDescriptor, Rect rect, android.graphics.BitmapFactory.Options options) {
        AppMethodBeat.i(57641);
        assertNotNull(fileDescriptor, "'fd' is null.");
        Bitmap decodeFileDescriptorInternal = decodeFileDescriptorInternal(fileDescriptor, rect, options);
        AppMethodBeat.o(57641);
        return decodeFileDescriptorInternal;
    }

    private static Bitmap decodeFileDescriptorInternal(FileDescriptor fileDescriptor, Rect rect, android.graphics.BitmapFactory.Options options) {
        Throwable th;
        int i = 0;
        AppMethodBeat.i(57642);
        if (options == null) {
            options = new android.graphics.BitmapFactory.Options();
        }
        Bitmap decodeFileDescriptor;
        if (isForceSystemDecoder(options)) {
            b.w(TAG, "[!] force decoding fd %s by system codec.", fileDescriptor);
            decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor, rect, options);
            announceDecodeResult(options, decodeFileDescriptor, true);
            AppMethodBeat.o(57642);
            return decodeFileDescriptor;
        } else if (nativeIsSeekable(fileDescriptor)) {
            try {
                Bitmap nativeDecodeFileDescriptor = nativeDecodeFileDescriptor(fileDescriptor, getOrCreateStorageBuffer(options), rect, options);
                if (options.outMimeType != null) {
                    i = 1;
                }
                if (i != 0) {
                    announceDecodeResult(options, nativeDecodeFileDescriptor, false);
                    setDensityFromOptions(nativeDecodeFileDescriptor, options);
                    decodeFileDescriptor = scaleBitmapOnDemand(nativeDecodeFileDescriptor, options);
                    AppMethodBeat.o(57642);
                    return decodeFileDescriptor;
                }
                b.w(TAG, "[!] unsupported image format, try to decode with system codec.");
                decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor, rect, options);
                announceDecodeResult(options, decodeFileDescriptor, true);
                AppMethodBeat.o(57642);
                return decodeFileDescriptor;
            } catch (Throwable th2) {
                b.b(TAG, th2, "decode failed.");
                AppMethodBeat.o(57642);
                return null;
            }
        } else {
            Closeable fileInputStream;
            try {
                fileInputStream = new FileInputStream(fileDescriptor);
                try {
                    decodeFileDescriptor = decodeStreamInternal(fileInputStream, rect, options);
                    closeQuietly(fileInputStream);
                    AppMethodBeat.o(57642);
                    return decodeFileDescriptor;
                } catch (Throwable th3) {
                    th2 = th3;
                    try {
                        b.b(TAG, th2, "decode failed.");
                        closeQuietly(fileInputStream);
                        AppMethodBeat.o(57642);
                        return null;
                    } catch (Throwable th4) {
                        th2 = th4;
                        closeQuietly(fileInputStream);
                        AppMethodBeat.o(57642);
                        throw th2;
                    }
                }
            } catch (Throwable th5) {
                th2 = th5;
                fileInputStream = null;
                closeQuietly(fileInputStream);
                AppMethodBeat.o(57642);
                throw th2;
            }
        }
    }

    public static Bitmap decodeByteArray(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(57643);
        assertNotNull(bArr, "'data' is null.");
        Bitmap decodeByteArrayInternal = decodeByteArrayInternal(bArr, i, i2, null);
        AppMethodBeat.o(57643);
        return decodeByteArrayInternal;
    }

    public static Bitmap decodeByteArray(byte[] bArr, int i, int i2, android.graphics.BitmapFactory.Options options) {
        AppMethodBeat.i(57644);
        assertNotNull(bArr, "'data' is null.");
        Bitmap decodeByteArrayInternal = decodeByteArrayInternal(bArr, i, i2, options);
        AppMethodBeat.o(57644);
        return decodeByteArrayInternal;
    }

    private static Bitmap decodeByteArrayInternal(byte[] bArr, int i, int i2, android.graphics.BitmapFactory.Options options) {
        boolean z = false;
        AppMethodBeat.i(57645);
        if (options == null) {
            options = new android.graphics.BitmapFactory.Options();
        }
        Bitmap decodeByteArray;
        if (isForceSystemDecoder(options)) {
            b.w(TAG, "[!] force decoding data by system codec.");
            decodeByteArray = BitmapFactory.decodeByteArray(bArr, i, i2, options);
            announceDecodeResult(options, decodeByteArray, true);
            AppMethodBeat.o(57645);
            return decodeByteArray;
        }
        try {
            Bitmap nativeDecodeByteArray = nativeDecodeByteArray(bArr, i, i2, options);
            if (options.outMimeType != null) {
                z = true;
            }
            if (z) {
                announceDecodeResult(options, nativeDecodeByteArray, false);
                setDensityFromOptions(nativeDecodeByteArray, options);
                decodeByteArray = scaleBitmapOnDemand(nativeDecodeByteArray, options);
                AppMethodBeat.o(57645);
                return decodeByteArray;
            }
            b.w(TAG, "[!] unsupported image format, try to decode with system codec.");
            decodeByteArray = BitmapFactory.decodeByteArray(bArr, i, i2, options);
            announceDecodeResult(options, decodeByteArray, true);
            AppMethodBeat.o(57645);
            return decodeByteArray;
        } catch (Throwable th) {
            b.b(TAG, th, "decode failed.");
            AppMethodBeat.o(57645);
            return null;
        }
    }

    public static Bitmap decodeStream(InputStream inputStream) {
        AppMethodBeat.i(57646);
        assertNotNull(inputStream, "'is' is null.");
        Bitmap decodeStreamInternal = decodeStreamInternal(inputStream, null, null);
        AppMethodBeat.o(57646);
        return decodeStreamInternal;
    }

    public static Bitmap decodeStream(InputStream inputStream, Rect rect, android.graphics.BitmapFactory.Options options) {
        AppMethodBeat.i(57647);
        assertNotNull(inputStream, "'is' is null.");
        Bitmap decodeStreamInternal = decodeStreamInternal(inputStream, rect, options);
        AppMethodBeat.o(57647);
        return decodeStreamInternal;
    }

    private static Bitmap decodeStreamInternal(InputStream inputStream, Rect rect, android.graphics.BitmapFactory.Options options) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(57648);
        if (options == null) {
            options = new android.graphics.BitmapFactory.Options();
        }
        if (inputStream instanceof AssetInputStream) {
            b.w(TAG, "[!] force decoding stream by system codec since it's asset stream.");
            z = true;
        } else if (isForceSystemDecoder(options)) {
            b.w(TAG, "[!] force decoding stream by system codec since specific options.");
            z = true;
        } else {
            z = false;
        }
        Bitmap decodeStream;
        if (z) {
            decodeStream = BitmapFactory.decodeStream(inputStream, rect, options);
            announceDecodeResult(options, decodeStream, true);
            AppMethodBeat.o(57648);
            return decodeStream;
        }
        try {
            InputStream wrapUnResetableStreamOnDemand = wrapUnResetableStreamOnDemand(inputStream);
            wrapUnResetableStreamOnDemand.mark(getCompatibleRewindBufferSize());
            Bitmap nativeDecodeStream = nativeDecodeStream(wrapUnResetableStreamOnDemand, rect, options);
            if (options.outMimeType != null) {
                z2 = true;
            }
            if (z2) {
                announceDecodeResult(options, nativeDecodeStream, false);
                setDensityFromOptions(nativeDecodeStream, options);
                decodeStream = scaleBitmapOnDemand(nativeDecodeStream, options);
                AppMethodBeat.o(57648);
                return decodeStream;
            }
            b.w(TAG, "[!] unsupported image format, try to decode with system codec.");
            wrapUnResetableStreamOnDemand.reset();
            wrapUnResetableStreamOnDemand.mark(getCompatibleRewindBufferSize());
            decodeStream = BitmapFactory.decodeStream(wrapUnResetableStreamOnDemand, rect, options);
            announceDecodeResult(options, decodeStream, true);
            AppMethodBeat.o(57648);
            return decodeStream;
        } catch (Throwable th) {
            b.b(TAG, th, "decode failed.");
            AppMethodBeat.o(57648);
            return null;
        }
    }

    private static void announceDecodeResult(android.graphics.BitmapFactory.Options options, Bitmap bitmap, boolean z) {
        AppMethodBeat.i(138193);
        assertNotNull(options, "[-] opts is null.");
        String str = z ? "system" : "mmcodec";
        if (!(bitmap == null && options.outMimeType == null) && options.outWidth > 0 && options.outHeight > 0) {
            b.i(TAG, "[+] decode success by %s, w:%s, h:%s, mime-type:%s, sampleSize:%s", str, Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight), options.outMimeType, Integer.valueOf(options.inSampleSize));
            AppMethodBeat.o(138193);
            return;
        }
        b.e(TAG, "[+] fail to decode by %s", str);
        AppMethodBeat.o(138193);
    }

    public static Bitmap pinBitmap(Bitmap bitmap) {
        AppMethodBeat.i(57649);
        if (!(bitmap == null || bitmap.isRecycled())) {
            b.i(TAG, "[tomys] Try to pin bmp (%s), [w: %s, h: %s, config: %s, size: %s]", bitmap, Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), bitmap.getConfig(), Integer.valueOf(bitmap.getByteCount()));
            if (nativePinBitmap(bitmap) < 0) {
                b.e(TAG, "pinBitmap failed, ret: %s", Integer.valueOf(nativePinBitmap(bitmap)));
            }
        }
        AppMethodBeat.o(57649);
        return bitmap;
    }

    public static Bitmap unPinBitmap(Bitmap bitmap) {
        AppMethodBeat.i(57650);
        if (!(bitmap == null || bitmap.isRecycled())) {
            b.i(TAG, "[tomys] Try to unpin bmp (%s), [w: %s, h: %s, config: %s, size: %s]", bitmap, Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), bitmap.getConfig(), Integer.valueOf(bitmap.getByteCount()));
            if (nativeUnPinBitmap(bitmap) < 0) {
                b.e(TAG, "unPinBitmap failed, ret: %s", Integer.valueOf(nativeUnPinBitmap(bitmap)));
            }
        }
        AppMethodBeat.o(57650);
        return bitmap;
    }

    private static boolean isForceSystemDecoder(android.graphics.BitmapFactory.Options options) {
        AppMethodBeat.i(57651);
        if (options == null || VERSION.SDK_INT < 26 || !Config.HARDWARE.equals(options.inPreferredConfig)) {
            AppMethodBeat.o(57651);
            return false;
        }
        AppMethodBeat.o(57651);
        return true;
    }

    private static void assertNotNull(Object obj, String str) {
        AppMethodBeat.i(57652);
        if (obj == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(str);
            AppMethodBeat.o(57652);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(57652);
    }

    private static void closeQuietly(Closeable closeable) {
        AppMethodBeat.i(57653);
        if (closeable == null) {
            AppMethodBeat.o(57653);
            return;
        }
        try {
            closeable.close();
            AppMethodBeat.o(57653);
        } catch (Throwable th) {
            AppMethodBeat.o(57653);
        }
    }

    private static byte[] getOrCreateStorageBuffer(android.graphics.BitmapFactory.Options options) {
        byte[] bArr = options != null ? options.inTempStorage : null;
        return bArr != null ? bArr : new byte[4096];
    }

    private static Bitmap scaleBitmapOnDemand(Bitmap bitmap, android.graphics.BitmapFactory.Options options) {
        AppMethodBeat.i(57654);
        if (bitmap == null || options == null) {
            AppMethodBeat.o(57654);
            return bitmap;
        } else if (options.inScaled) {
            float f;
            int i = options.inDensity;
            int i2 = options.inTargetDensity;
            int i3 = options.inScreenDensity;
            if (i == 0 || i2 == 0 || i == i3) {
                f = 1.0f;
            } else {
                f = ((float) i2) / ((float) i);
            }
            if (f == 1.0f) {
                AppMethodBeat.o(57654);
                return bitmap;
            }
            b.d(TAG, "[+] Bmp to scale: [sw: %s, sh: %s, dw: %s, dh: %s, scX: %s, scY: %s]", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf((int) ((((float) bitmap.getWidth()) * f) + 0.5f)), Integer.valueOf((int) ((f * ((float) bitmap.getHeight())) + 0.5f)), Float.valueOf(((float) r2) / ((float) bitmap.getWidth())), Float.valueOf(((float) ((int) ((f * ((float) bitmap.getHeight())) + 0.5f))) / ((float) bitmap.getHeight())));
            Matrix matrix = new Matrix();
            matrix.setScale(r3, r4);
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            if (createBitmap != bitmap) {
                bitmap.recycle();
            }
            AppMethodBeat.o(57654);
            return createBitmap;
        } else {
            AppMethodBeat.o(57654);
            return bitmap;
        }
    }

    private static void setDensityFromOptions(Bitmap bitmap, android.graphics.BitmapFactory.Options options) {
        AppMethodBeat.i(57655);
        if (bitmap == null || options == null) {
            AppMethodBeat.o(57655);
            return;
        }
        int i = options.inDensity;
        if (i != 0) {
            bitmap.setDensity(i);
            int i2 = options.inTargetDensity;
            if (i2 == 0 || i == i2 || i == options.inScreenDensity) {
                AppMethodBeat.o(57655);
                return;
            }
            byte[] ninePatchChunk = bitmap.getNinePatchChunk();
            Object obj = (ninePatchChunk == null || !NinePatch.isNinePatchChunk(ninePatchChunk)) ? null : 1;
            if (options.inScaled || obj != null) {
                bitmap.setDensity(i2);
            }
            AppMethodBeat.o(57655);
            return;
        }
        if (options.inBitmap != null) {
            bitmap.setDensity(160);
        }
        AppMethodBeat.o(57655);
    }

    private static int getCompatibleRewindBufferSize() {
        AppMethodBeat.i(138505);
        if ("HUAWEI".equals(Build.MANUFACTURER)) {
            AppMethodBeat.o(138505);
            return 8388608;
        }
        AppMethodBeat.o(138505);
        return REWIND_BUFFER_SIZE;
    }

    private static InputStream wrapUnResetableStreamOnDemand(InputStream inputStream) {
        AppMethodBeat.i(138506);
        InputStream aVar;
        if (inputStream.markSupported()) {
            AppMethodBeat.o(138506);
            return inputStream;
        } else if (inputStream instanceof FileInputStream) {
            aVar = new a((FileInputStream) inputStream);
            AppMethodBeat.o(138506);
            return aVar;
        } else {
            aVar = new BufferedInputStream(inputStream);
            AppMethodBeat.o(138506);
            return aVar;
        }
    }

    private static void loadNativeModule(String str) {
        AppMethodBeat.i(57656);
        try {
            System.loadLibrary(str);
            b.i(TAG, "Successfully load native module: %s", str);
            AppMethodBeat.o(57656);
        } catch (Throwable th) {
            b.b(TAG, th, "Fail to load native module: %s", str);
            RuntimeException runtimeException = new RuntimeException(th);
            AppMethodBeat.o(57656);
        }
    }

    static {
        AppMethodBeat.i(57658);
        loadNativeModule("mmimgcodec");
        AppMethodBeat.o(57658);
    }

    private MMBitmapFactory() {
        AppMethodBeat.i(57657);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(57657);
        throw unsupportedOperationException;
    }
}

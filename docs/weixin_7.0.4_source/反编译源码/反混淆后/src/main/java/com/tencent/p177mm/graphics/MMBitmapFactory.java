package com.tencent.p177mm.graphics;

import android.content.res.AssetManager.AssetInputStream;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.Keep;
import android.util.TypedValue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p136e.p137a.C0926b;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

@Keep
/* renamed from: com.tencent.mm.graphics.MMBitmapFactory */
public class MMBitmapFactory {
    private static final int DENSITY_DEFAULT = 160;
    private static final int REWIND_BUFFER_SIZE = 262144;
    private static final String TAG = "MicroMsg.MMBitmapFactory";
    private static final int TEMP_STORAGE_SIZE = 4096;

    @Keep
    /* renamed from: com.tencent.mm.graphics.MMBitmapFactory$Options */
    public static class Options extends android.graphics.BitmapFactory.Options {
        @Keep
        public boolean inUseSmoothSample = false;
    }

    /* renamed from: com.tencent.mm.graphics.MMBitmapFactory$a */
    static class C1601a extends FilterInputStream {
        private long eCr = 0;

        public C1601a(FileInputStream fileInputStream) {
            super(fileInputStream);
        }

        public final boolean markSupported() {
            return true;
        }

        public final synchronized void mark(int i) {
            AppMethodBeat.m2504i(138503);
            try {
                this.eCr = ((FileInputStream) this.in).getChannel().position();
                AppMethodBeat.m2505o(138503);
            } catch (IOException e) {
                C0926b.m2098b(MMBitmapFactory.TAG, e, "fail to mark position.");
                this.eCr = -1;
                AppMethodBeat.m2505o(138503);
            }
            return;
        }

        public final synchronized void reset() {
            AppMethodBeat.m2504i(138504);
            if (this.eCr < 0) {
                IOException iOException = new IOException("Illegal marked position: " + this.eCr);
                AppMethodBeat.m2505o(138504);
                throw iOException;
            }
            ((FileInputStream) this.in).getChannel().position(this.eCr);
            AppMethodBeat.m2505o(138504);
        }
    }

    private static native void nativeAddExternalLibDir(String str);

    private static native Bitmap nativeDecodeByteArray(byte[] bArr, int i, int i2, Options options);

    private static native Bitmap nativeDecodeFileDescriptor(FileDescriptor fileDescriptor, byte[] bArr, Rect rect, Options options);

    private static native Bitmap nativeDecodeStream(InputStream inputStream, Rect rect, Options options);

    private static native boolean nativeIsSeekable(FileDescriptor fileDescriptor);

    private static native int nativePinBitmap(Bitmap bitmap);

    private static native int nativeUnPinBitmap(Bitmap bitmap);

    public static void addExternalCodecLibDir(String str) {
        AppMethodBeat.m2504i(57633);
        C0926b.m2106i(TAG, "[+] add external codec library path: %s", str);
        MMBitmapFactory.nativeAddExternalLibDir(str);
        AppMethodBeat.m2505o(57633);
    }

    public static String getVersion() {
        return "0.2.18";
    }

    public static Bitmap decodeResource(Resources resources, int i) {
        AppMethodBeat.m2504i(57634);
        C0926b.m2102d(TAG, "[*] transfer invocation to BitmapFactory.decodeResource, res: %s, id: %s", resources, Integer.valueOf(i));
        Bitmap decodeResource = BitmapFactory.decodeResource(resources, i);
        AppMethodBeat.m2505o(57634);
        return decodeResource;
    }

    public static Bitmap decodeResource(Resources resources, int i, Options options) {
        AppMethodBeat.m2504i(57635);
        C0926b.m2102d(TAG, "[*] transfer invocation to BitmapFactory.decodeResource, res: %s, id: %s, opts: %s", resources, Integer.valueOf(i), options);
        Bitmap decodeResource = BitmapFactory.decodeResource(resources, i, options);
        AppMethodBeat.m2505o(57635);
        return decodeResource;
    }

    public static Bitmap decodeResourceStream(Resources resources, TypedValue typedValue, InputStream inputStream, Rect rect, Options options) {
        AppMethodBeat.m2504i(57636);
        C0926b.m2102d(TAG, "[*] transfer invocation to BitmapFactory.decodeResourceStream, res: %s, value: %s, is: %s, pad: %s, opts: %s", resources, typedValue, inputStream, rect, options);
        Bitmap decodeResourceStream = BitmapFactory.decodeResourceStream(resources, typedValue, inputStream, rect, options);
        AppMethodBeat.m2505o(57636);
        return decodeResourceStream;
    }

    public static Bitmap decodeFile(String str) {
        AppMethodBeat.m2504i(57637);
        MMBitmapFactory.assertNotNull(str, "'pathName' is null.");
        Bitmap decodeFileInternal = MMBitmapFactory.decodeFileInternal(str, null);
        AppMethodBeat.m2505o(57637);
        return decodeFileInternal;
    }

    public static Bitmap decodeFile(String str, Options options) {
        AppMethodBeat.m2504i(57638);
        MMBitmapFactory.assertNotNull(str, "'pathName' is null.");
        Bitmap decodeFileInternal = MMBitmapFactory.decodeFileInternal(str, options);
        AppMethodBeat.m2505o(57638);
        return decodeFileInternal;
    }

    private static Bitmap decodeFileInternal(String str, Options options) {
        Throwable th;
        int i = 0;
        AppMethodBeat.m2504i(57639);
        if (options == null) {
            options = new Options();
        }
        Bitmap decodeFile;
        if (MMBitmapFactory.isForceSystemDecoder(options)) {
            C0926b.m2108w(TAG, "[!] force decoding file %s by system codec.", str);
            decodeFile = BitmapFactory.decodeFile(str, options);
            MMBitmapFactory.announceDecodeResult(options, decodeFile, true);
            AppMethodBeat.m2505o(57639);
            return decodeFile;
        }
        Closeable wrapUnResetableStreamOnDemand;
        try {
            wrapUnResetableStreamOnDemand = MMBitmapFactory.wrapUnResetableStreamOnDemand(new FileInputStream(str));
            try {
                wrapUnResetableStreamOnDemand.mark(MMBitmapFactory.getCompatibleRewindBufferSize());
                Bitmap nativeDecodeStream = MMBitmapFactory.nativeDecodeStream(wrapUnResetableStreamOnDemand, null, options);
                if (options.outMimeType != null) {
                    i = 1;
                }
                if (i != 0) {
                    MMBitmapFactory.announceDecodeResult(options, nativeDecodeStream, false);
                    MMBitmapFactory.setDensityFromOptions(nativeDecodeStream, options);
                    decodeFile = MMBitmapFactory.scaleBitmapOnDemand(nativeDecodeStream, options);
                    MMBitmapFactory.closeQuietly(wrapUnResetableStreamOnDemand);
                    AppMethodBeat.m2505o(57639);
                    return decodeFile;
                }
                C0926b.m2107w(TAG, "[!] unsupported image format, try to decode with system codec.");
                wrapUnResetableStreamOnDemand.reset();
                decodeFile = BitmapFactory.decodeFile(str, options);
                MMBitmapFactory.announceDecodeResult(options, decodeFile, true);
                MMBitmapFactory.closeQuietly(wrapUnResetableStreamOnDemand);
                AppMethodBeat.m2505o(57639);
                return decodeFile;
            } catch (Throwable th2) {
                th = th2;
                try {
                    C0926b.m2098b(TAG, th, "decode failed.");
                    MMBitmapFactory.closeQuietly(wrapUnResetableStreamOnDemand);
                    AppMethodBeat.m2505o(57639);
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    MMBitmapFactory.closeQuietly(wrapUnResetableStreamOnDemand);
                    AppMethodBeat.m2505o(57639);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            wrapUnResetableStreamOnDemand = null;
            MMBitmapFactory.closeQuietly(wrapUnResetableStreamOnDemand);
            AppMethodBeat.m2505o(57639);
            throw th;
        }
    }

    public static Bitmap decodeFileDescriptor(FileDescriptor fileDescriptor) {
        AppMethodBeat.m2504i(57640);
        MMBitmapFactory.assertNotNull(fileDescriptor, "'fd' is null.");
        Bitmap decodeFileDescriptorInternal = MMBitmapFactory.decodeFileDescriptorInternal(fileDescriptor, null, null);
        AppMethodBeat.m2505o(57640);
        return decodeFileDescriptorInternal;
    }

    public static Bitmap decodeFileDescriptor(FileDescriptor fileDescriptor, Rect rect, Options options) {
        AppMethodBeat.m2504i(57641);
        MMBitmapFactory.assertNotNull(fileDescriptor, "'fd' is null.");
        Bitmap decodeFileDescriptorInternal = MMBitmapFactory.decodeFileDescriptorInternal(fileDescriptor, rect, options);
        AppMethodBeat.m2505o(57641);
        return decodeFileDescriptorInternal;
    }

    private static Bitmap decodeFileDescriptorInternal(FileDescriptor fileDescriptor, Rect rect, Options options) {
        Throwable th;
        int i = 0;
        AppMethodBeat.m2504i(57642);
        if (options == null) {
            options = new Options();
        }
        Bitmap decodeFileDescriptor;
        if (MMBitmapFactory.isForceSystemDecoder(options)) {
            C0926b.m2108w(TAG, "[!] force decoding fd %s by system codec.", fileDescriptor);
            decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor, rect, options);
            MMBitmapFactory.announceDecodeResult(options, decodeFileDescriptor, true);
            AppMethodBeat.m2505o(57642);
            return decodeFileDescriptor;
        } else if (MMBitmapFactory.nativeIsSeekable(fileDescriptor)) {
            try {
                Bitmap nativeDecodeFileDescriptor = MMBitmapFactory.nativeDecodeFileDescriptor(fileDescriptor, MMBitmapFactory.getOrCreateStorageBuffer(options), rect, options);
                if (options.outMimeType != null) {
                    i = 1;
                }
                if (i != 0) {
                    MMBitmapFactory.announceDecodeResult(options, nativeDecodeFileDescriptor, false);
                    MMBitmapFactory.setDensityFromOptions(nativeDecodeFileDescriptor, options);
                    decodeFileDescriptor = MMBitmapFactory.scaleBitmapOnDemand(nativeDecodeFileDescriptor, options);
                    AppMethodBeat.m2505o(57642);
                    return decodeFileDescriptor;
                }
                C0926b.m2107w(TAG, "[!] unsupported image format, try to decode with system codec.");
                decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor, rect, options);
                MMBitmapFactory.announceDecodeResult(options, decodeFileDescriptor, true);
                AppMethodBeat.m2505o(57642);
                return decodeFileDescriptor;
            } catch (Throwable th2) {
                C0926b.m2098b(TAG, th2, "decode failed.");
                AppMethodBeat.m2505o(57642);
                return null;
            }
        } else {
            Closeable fileInputStream;
            try {
                fileInputStream = new FileInputStream(fileDescriptor);
                try {
                    decodeFileDescriptor = MMBitmapFactory.decodeStreamInternal(fileInputStream, rect, options);
                    MMBitmapFactory.closeQuietly(fileInputStream);
                    AppMethodBeat.m2505o(57642);
                    return decodeFileDescriptor;
                } catch (Throwable th3) {
                    th2 = th3;
                    try {
                        C0926b.m2098b(TAG, th2, "decode failed.");
                        MMBitmapFactory.closeQuietly(fileInputStream);
                        AppMethodBeat.m2505o(57642);
                        return null;
                    } catch (Throwable th4) {
                        th2 = th4;
                        MMBitmapFactory.closeQuietly(fileInputStream);
                        AppMethodBeat.m2505o(57642);
                        throw th2;
                    }
                }
            } catch (Throwable th5) {
                th2 = th5;
                fileInputStream = null;
                MMBitmapFactory.closeQuietly(fileInputStream);
                AppMethodBeat.m2505o(57642);
                throw th2;
            }
        }
    }

    public static Bitmap decodeByteArray(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(57643);
        MMBitmapFactory.assertNotNull(bArr, "'data' is null.");
        Bitmap decodeByteArrayInternal = MMBitmapFactory.decodeByteArrayInternal(bArr, i, i2, null);
        AppMethodBeat.m2505o(57643);
        return decodeByteArrayInternal;
    }

    public static Bitmap decodeByteArray(byte[] bArr, int i, int i2, Options options) {
        AppMethodBeat.m2504i(57644);
        MMBitmapFactory.assertNotNull(bArr, "'data' is null.");
        Bitmap decodeByteArrayInternal = MMBitmapFactory.decodeByteArrayInternal(bArr, i, i2, options);
        AppMethodBeat.m2505o(57644);
        return decodeByteArrayInternal;
    }

    private static Bitmap decodeByteArrayInternal(byte[] bArr, int i, int i2, Options options) {
        boolean z = false;
        AppMethodBeat.m2504i(57645);
        if (options == null) {
            options = new Options();
        }
        Bitmap decodeByteArray;
        if (MMBitmapFactory.isForceSystemDecoder(options)) {
            C0926b.m2107w(TAG, "[!] force decoding data by system codec.");
            decodeByteArray = BitmapFactory.decodeByteArray(bArr, i, i2, options);
            MMBitmapFactory.announceDecodeResult(options, decodeByteArray, true);
            AppMethodBeat.m2505o(57645);
            return decodeByteArray;
        }
        try {
            Bitmap nativeDecodeByteArray = MMBitmapFactory.nativeDecodeByteArray(bArr, i, i2, options);
            if (options.outMimeType != null) {
                z = true;
            }
            if (z) {
                MMBitmapFactory.announceDecodeResult(options, nativeDecodeByteArray, false);
                MMBitmapFactory.setDensityFromOptions(nativeDecodeByteArray, options);
                decodeByteArray = MMBitmapFactory.scaleBitmapOnDemand(nativeDecodeByteArray, options);
                AppMethodBeat.m2505o(57645);
                return decodeByteArray;
            }
            C0926b.m2107w(TAG, "[!] unsupported image format, try to decode with system codec.");
            decodeByteArray = BitmapFactory.decodeByteArray(bArr, i, i2, options);
            MMBitmapFactory.announceDecodeResult(options, decodeByteArray, true);
            AppMethodBeat.m2505o(57645);
            return decodeByteArray;
        } catch (Throwable th) {
            C0926b.m2098b(TAG, th, "decode failed.");
            AppMethodBeat.m2505o(57645);
            return null;
        }
    }

    public static Bitmap decodeStream(InputStream inputStream) {
        AppMethodBeat.m2504i(57646);
        MMBitmapFactory.assertNotNull(inputStream, "'is' is null.");
        Bitmap decodeStreamInternal = MMBitmapFactory.decodeStreamInternal(inputStream, null, null);
        AppMethodBeat.m2505o(57646);
        return decodeStreamInternal;
    }

    public static Bitmap decodeStream(InputStream inputStream, Rect rect, Options options) {
        AppMethodBeat.m2504i(57647);
        MMBitmapFactory.assertNotNull(inputStream, "'is' is null.");
        Bitmap decodeStreamInternal = MMBitmapFactory.decodeStreamInternal(inputStream, rect, options);
        AppMethodBeat.m2505o(57647);
        return decodeStreamInternal;
    }

    private static Bitmap decodeStreamInternal(InputStream inputStream, Rect rect, Options options) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.m2504i(57648);
        if (options == null) {
            options = new Options();
        }
        if (inputStream instanceof AssetInputStream) {
            C0926b.m2107w(TAG, "[!] force decoding stream by system codec since it's asset stream.");
            z = true;
        } else if (MMBitmapFactory.isForceSystemDecoder(options)) {
            C0926b.m2107w(TAG, "[!] force decoding stream by system codec since specific options.");
            z = true;
        } else {
            z = false;
        }
        Bitmap decodeStream;
        if (z) {
            decodeStream = BitmapFactory.decodeStream(inputStream, rect, options);
            MMBitmapFactory.announceDecodeResult(options, decodeStream, true);
            AppMethodBeat.m2505o(57648);
            return decodeStream;
        }
        try {
            InputStream wrapUnResetableStreamOnDemand = MMBitmapFactory.wrapUnResetableStreamOnDemand(inputStream);
            wrapUnResetableStreamOnDemand.mark(MMBitmapFactory.getCompatibleRewindBufferSize());
            Bitmap nativeDecodeStream = MMBitmapFactory.nativeDecodeStream(wrapUnResetableStreamOnDemand, rect, options);
            if (options.outMimeType != null) {
                z2 = true;
            }
            if (z2) {
                MMBitmapFactory.announceDecodeResult(options, nativeDecodeStream, false);
                MMBitmapFactory.setDensityFromOptions(nativeDecodeStream, options);
                decodeStream = MMBitmapFactory.scaleBitmapOnDemand(nativeDecodeStream, options);
                AppMethodBeat.m2505o(57648);
                return decodeStream;
            }
            C0926b.m2107w(TAG, "[!] unsupported image format, try to decode with system codec.");
            wrapUnResetableStreamOnDemand.reset();
            wrapUnResetableStreamOnDemand.mark(MMBitmapFactory.getCompatibleRewindBufferSize());
            decodeStream = BitmapFactory.decodeStream(wrapUnResetableStreamOnDemand, rect, options);
            MMBitmapFactory.announceDecodeResult(options, decodeStream, true);
            AppMethodBeat.m2505o(57648);
            return decodeStream;
        } catch (Throwable th) {
            C0926b.m2098b(TAG, th, "decode failed.");
            AppMethodBeat.m2505o(57648);
            return null;
        }
    }

    private static void announceDecodeResult(Options options, Bitmap bitmap, boolean z) {
        AppMethodBeat.m2504i(138193);
        MMBitmapFactory.assertNotNull(options, "[-] opts is null.");
        String str = z ? "system" : "mmcodec";
        if (!(bitmap == null && options.outMimeType == null) && options.outWidth > 0 && options.outHeight > 0) {
            C0926b.m2106i(TAG, "[+] decode success by %s, w:%s, h:%s, mime-type:%s, sampleSize:%s", str, Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight), options.outMimeType, Integer.valueOf(options.inSampleSize));
            AppMethodBeat.m2505o(138193);
            return;
        }
        C0926b.m2104e(TAG, "[+] fail to decode by %s", str);
        AppMethodBeat.m2505o(138193);
    }

    public static Bitmap pinBitmap(Bitmap bitmap) {
        AppMethodBeat.m2504i(57649);
        if (!(bitmap == null || bitmap.isRecycled())) {
            C0926b.m2106i(TAG, "[tomys] Try to pin bmp (%s), [w: %s, h: %s, config: %s, size: %s]", bitmap, Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), bitmap.getConfig(), Integer.valueOf(bitmap.getByteCount()));
            if (MMBitmapFactory.nativePinBitmap(bitmap) < 0) {
                C0926b.m2104e(TAG, "pinBitmap failed, ret: %s", Integer.valueOf(MMBitmapFactory.nativePinBitmap(bitmap)));
            }
        }
        AppMethodBeat.m2505o(57649);
        return bitmap;
    }

    public static Bitmap unPinBitmap(Bitmap bitmap) {
        AppMethodBeat.m2504i(57650);
        if (!(bitmap == null || bitmap.isRecycled())) {
            C0926b.m2106i(TAG, "[tomys] Try to unpin bmp (%s), [w: %s, h: %s, config: %s, size: %s]", bitmap, Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), bitmap.getConfig(), Integer.valueOf(bitmap.getByteCount()));
            if (MMBitmapFactory.nativeUnPinBitmap(bitmap) < 0) {
                C0926b.m2104e(TAG, "unPinBitmap failed, ret: %s", Integer.valueOf(MMBitmapFactory.nativeUnPinBitmap(bitmap)));
            }
        }
        AppMethodBeat.m2505o(57650);
        return bitmap;
    }

    private static boolean isForceSystemDecoder(Options options) {
        AppMethodBeat.m2504i(57651);
        if (options == null || VERSION.SDK_INT < 26 || !Config.HARDWARE.equals(options.inPreferredConfig)) {
            AppMethodBeat.m2505o(57651);
            return false;
        }
        AppMethodBeat.m2505o(57651);
        return true;
    }

    private static void assertNotNull(Object obj, String str) {
        AppMethodBeat.m2504i(57652);
        if (obj == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(str);
            AppMethodBeat.m2505o(57652);
            throw illegalArgumentException;
        }
        AppMethodBeat.m2505o(57652);
    }

    private static void closeQuietly(Closeable closeable) {
        AppMethodBeat.m2504i(57653);
        if (closeable == null) {
            AppMethodBeat.m2505o(57653);
            return;
        }
        try {
            closeable.close();
            AppMethodBeat.m2505o(57653);
        } catch (Throwable th) {
            AppMethodBeat.m2505o(57653);
        }
    }

    private static byte[] getOrCreateStorageBuffer(Options options) {
        byte[] bArr = options != null ? options.inTempStorage : null;
        return bArr != null ? bArr : new byte[4096];
    }

    private static Bitmap scaleBitmapOnDemand(Bitmap bitmap, Options options) {
        AppMethodBeat.m2504i(57654);
        if (bitmap == null || options == null) {
            AppMethodBeat.m2505o(57654);
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
                AppMethodBeat.m2505o(57654);
                return bitmap;
            }
            C0926b.m2102d(TAG, "[+] Bmp to scale: [sw: %s, sh: %s, dw: %s, dh: %s, scX: %s, scY: %s]", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf((int) ((((float) bitmap.getWidth()) * f) + 0.5f)), Integer.valueOf((int) ((f * ((float) bitmap.getHeight())) + 0.5f)), Float.valueOf(((float) r2) / ((float) bitmap.getWidth())), Float.valueOf(((float) ((int) ((f * ((float) bitmap.getHeight())) + 0.5f))) / ((float) bitmap.getHeight())));
            Matrix matrix = new Matrix();
            matrix.setScale(r3, r4);
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            if (createBitmap != bitmap) {
                bitmap.recycle();
            }
            AppMethodBeat.m2505o(57654);
            return createBitmap;
        } else {
            AppMethodBeat.m2505o(57654);
            return bitmap;
        }
    }

    private static void setDensityFromOptions(Bitmap bitmap, Options options) {
        AppMethodBeat.m2504i(57655);
        if (bitmap == null || options == null) {
            AppMethodBeat.m2505o(57655);
            return;
        }
        int i = options.inDensity;
        if (i != 0) {
            bitmap.setDensity(i);
            int i2 = options.inTargetDensity;
            if (i2 == 0 || i == i2 || i == options.inScreenDensity) {
                AppMethodBeat.m2505o(57655);
                return;
            }
            byte[] ninePatchChunk = bitmap.getNinePatchChunk();
            Object obj = (ninePatchChunk == null || !NinePatch.isNinePatchChunk(ninePatchChunk)) ? null : 1;
            if (options.inScaled || obj != null) {
                bitmap.setDensity(i2);
            }
            AppMethodBeat.m2505o(57655);
            return;
        }
        if (options.inBitmap != null) {
            bitmap.setDensity(160);
        }
        AppMethodBeat.m2505o(57655);
    }

    private static int getCompatibleRewindBufferSize() {
        AppMethodBeat.m2504i(138505);
        if ("HUAWEI".equals(Build.MANUFACTURER)) {
            AppMethodBeat.m2505o(138505);
            return 8388608;
        }
        AppMethodBeat.m2505o(138505);
        return REWIND_BUFFER_SIZE;
    }

    private static InputStream wrapUnResetableStreamOnDemand(InputStream inputStream) {
        AppMethodBeat.m2504i(138506);
        InputStream c1601a;
        if (inputStream.markSupported()) {
            AppMethodBeat.m2505o(138506);
            return inputStream;
        } else if (inputStream instanceof FileInputStream) {
            c1601a = new C1601a((FileInputStream) inputStream);
            AppMethodBeat.m2505o(138506);
            return c1601a;
        } else {
            c1601a = new BufferedInputStream(inputStream);
            AppMethodBeat.m2505o(138506);
            return c1601a;
        }
    }

    private static void loadNativeModule(String str) {
        AppMethodBeat.m2504i(57656);
        try {
            System.loadLibrary(str);
            C0926b.m2106i(TAG, "Successfully load native module: %s", str);
            AppMethodBeat.m2505o(57656);
        } catch (Throwable th) {
            C0926b.m2099b(TAG, th, "Fail to load native module: %s", str);
            RuntimeException runtimeException = new RuntimeException(th);
            AppMethodBeat.m2505o(57656);
        }
    }

    static {
        AppMethodBeat.m2504i(57658);
        MMBitmapFactory.loadNativeModule("mmimgcodec");
        AppMethodBeat.m2505o(57658);
    }

    private MMBitmapFactory() {
        AppMethodBeat.m2504i(57657);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.m2505o(57657);
        throw unsupportedOperationException;
    }
}

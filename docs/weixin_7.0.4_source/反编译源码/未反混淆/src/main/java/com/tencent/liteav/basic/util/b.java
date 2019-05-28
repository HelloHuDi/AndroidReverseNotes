package com.tencent.liteav.basic.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.liteav.basic.d.a;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.ugc.TXRecordCommon;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.UUID;

public class b {
    public static long a = 0;
    private static float b = 0.0f;
    private static float c = 0.0f;
    private static float d = 0.0f;
    private static float e = 0.0f;
    private static float f = 0.0f;
    private static float g = 0.0f;
    private static boolean h = true;
    private static int[] i = new int[2];
    private static long j = 0;
    private static String k = "";
    private static int l = 0;
    private static long m = 0;
    private static final Object n = new Object();
    private static boolean o = false;
    private static int[] p = new int[]{96000, 88200, 64000, TXRecordCommon.AUDIO_SAMPLERATE_48000, TXRecordCommon.AUDIO_SAMPLERATE_44100, TXRecordCommon.AUDIO_SAMPLERATE_32000, 24000, 22050, TXRecordCommon.AUDIO_SAMPLERATE_16000, 12000, 11025, TXRecordCommon.AUDIO_SAMPLERATE_8000, 7350};

    static {
        AppMethodBeat.i(66021);
        AppMethodBeat.o(66021);
    }

    private static long g() {
        AppMethodBeat.i(66000);
        long j = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/stat")), 1000);
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            String[] split = readLine.split(" ");
            if (!(split == null || TextUtils.isEmpty(split[13]))) {
                j = Long.parseLong(split[16]) + ((Long.parseLong(split[13]) + Long.parseLong(split[14])) + Long.parseLong(split[15]));
            }
        } catch (Exception e) {
        }
        AppMethodBeat.o(66000);
        return j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0082  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void h() {
        long parseLong;
        long parseLong2;
        AppMethodBeat.i(66001);
        if (VERSION.SDK_INT < 26) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/stat")), 1000);
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                String[] split = readLine.split(" ");
                if (split != null && split.length >= 9) {
                    parseLong = (((((Long.parseLong(split[2]) + Long.parseLong(split[3])) + Long.parseLong(split[4])) + Long.parseLong(split[6])) + Long.parseLong(split[5])) + Long.parseLong(split[7])) + Long.parseLong(split[8]);
                    try {
                        parseLong2 = Long.parseLong(split[6]) + Long.parseLong(split[5]);
                    } catch (Exception e) {
                        parseLong2 = 0;
                        if (h) {
                        }
                    }
                    if (h) {
                        b = (float) parseLong;
                        f = (float) parseLong2;
                        AppMethodBeat.o(66001);
                        return;
                    }
                    c = (float) parseLong;
                    g = (float) parseLong2;
                    AppMethodBeat.o(66001);
                    return;
                }
            } catch (Exception e2) {
                parseLong = 0;
                parseLong2 = 0;
                if (h) {
                }
            }
        }
        parseLong2 = 0;
        parseLong = 0;
        if (h) {
        }
    }

    public static int[] a() {
        AppMethodBeat.i(66002);
        if (j == 0 || TXCTimeUtil.getTimeTick() - j >= FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
            int[] iArr = new int[2];
            if (h) {
                d = (float) g();
                h();
                h = false;
                iArr[0] = 0;
                iArr[1] = 0;
                AppMethodBeat.o(66002);
                return iArr;
            }
            float f;
            float f2;
            e = (float) g();
            h();
            if (c != b) {
                f = (100.0f * ((c - b) - (g - f))) / (c - b);
                f2 = (100.0f * (e - d)) / (c - b);
            } else {
                f = 0.0f;
                f2 = 0.0f;
            }
            b = c;
            d = e;
            f = g;
            iArr[0] = (int) (f2 * 10.0f);
            iArr[1] = (int) (f * 10.0f);
            i[0] = iArr[0];
            i[1] = iArr[1];
            j = TXCTimeUtil.getTimeTick();
            AppMethodBeat.o(66002);
            return iArr;
        }
        int[] iArr2 = i;
        AppMethodBeat.o(66002);
        return iArr2;
    }

    public static int b() {
        AppMethodBeat.i(66003);
        try {
            int totalPss;
            if (m == 0 || TXCTimeUtil.getTimeTick() - m >= 10000) {
                MemoryInfo memoryInfo = new MemoryInfo();
                Debug.getMemoryInfo(memoryInfo);
                totalPss = memoryInfo.getTotalPss();
                m = TXCTimeUtil.getTimeTick();
                l = totalPss / WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                totalPss = l;
                AppMethodBeat.o(66003);
                return totalPss;
            }
            totalPss = l;
            AppMethodBeat.o(66003);
            return totalPss;
        } catch (Exception e) {
        }
    }

    public static String a(Context context) {
        AppMethodBeat.i(66004);
        String simulateIDFA = TXCDRApi.getSimulateIDFA(context);
        AppMethodBeat.o(66004);
        return simulateIDFA;
    }

    public static String b(Context context) {
        AppMethodBeat.i(66005);
        String str = "";
        if (context != null) {
            try {
                str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
            } catch (Exception e) {
            }
        }
        AppMethodBeat.o(66005);
        return str;
    }

    public static int c(Context context) {
        AppMethodBeat.i(66006);
        if (context == null) {
            AppMethodBeat.o(66006);
            return 255;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            AppMethodBeat.o(66006);
            return 255;
        } else if (!activeNetworkInfo.isConnected()) {
            AppMethodBeat.o(66006);
            return 255;
        } else if (activeNetworkInfo.getType() == 9) {
            AppMethodBeat.o(66006);
            return 5;
        } else if (activeNetworkInfo.getType() == 1) {
            AppMethodBeat.o(66006);
            return 1;
        } else if (activeNetworkInfo.getType() == 0) {
            switch (telephonyManager.getNetworkType()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    AppMethodBeat.o(66006);
                    return 4;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    AppMethodBeat.o(66006);
                    return 3;
                case 13:
                    AppMethodBeat.o(66006);
                    return 2;
                default:
                    AppMethodBeat.o(66006);
                    return 2;
            }
        } else {
            AppMethodBeat.o(66006);
            return 255;
        }
    }

    public static String c() {
        return Build.MODEL;
    }

    public static String d() {
        AppMethodBeat.i(66007);
        String uuid = UUID.randomUUID().toString();
        AppMethodBeat.o(66007);
        return uuid;
    }

    public static String d(Context context) {
        AppMethodBeat.i(66008);
        String devUUID = TXCDRApi.getDevUUID(context, TXCDRApi.getSimulateIDFA(context));
        AppMethodBeat.o(66008);
        return devUUID;
    }

    public static void a(WeakReference<a> weakReference, long j, int i, String str) {
        AppMethodBeat.i(66009);
        Bundle bundle = new Bundle();
        bundle.putLong("EVT_USERID", j);
        bundle.putInt("EVT_ID", i);
        bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
        if (str != null) {
            bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, str);
        }
        a((WeakReference) weakReference, i, bundle);
        AppMethodBeat.o(66009);
    }

    public static void a(WeakReference<a> weakReference, int i, String str) {
        AppMethodBeat.i(66010);
        Bundle bundle = new Bundle();
        bundle.putInt("EVT_ID", i);
        bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
        if (str != null) {
            bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, str);
        }
        a((WeakReference) weakReference, i, bundle);
        AppMethodBeat.o(66010);
    }

    public static void a(WeakReference<a> weakReference, int i, Bundle bundle) {
        AppMethodBeat.i(66011);
        if (weakReference == null) {
            AppMethodBeat.o(66011);
            return;
        }
        a aVar = (a) weakReference.get();
        if (aVar != null) {
            aVar.onNotifyEvent(i, bundle);
        }
        AppMethodBeat.o(66011);
    }

    public static void a(WeakReference<a> weakReference, long j, int i, Bundle bundle) {
        AppMethodBeat.i(66012);
        if (weakReference == null) {
            AppMethodBeat.o(66012);
            return;
        }
        a aVar = (a) weakReference.get();
        if (aVar != null) {
            bundle.putLong("EVT_USERID", j);
            aVar.onNotifyEvent(i, bundle);
        }
        AppMethodBeat.o(66012);
    }

    public static com.tencent.liteav.basic.e.a a(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8 = 0;
        AppMethodBeat.i(66013);
        if (i * i4 >= i2 * i3) {
            i5 = (i2 * i3) / i4;
            i6 = i2;
        } else {
            i5 = i;
            i6 = (i * i4) / i3;
        }
        if (i > i5) {
            i7 = (i - i5) >> 1;
        } else {
            i7 = 0;
        }
        if (i2 > i6) {
            i8 = (i2 - i6) >> 1;
        }
        com.tencent.liteav.basic.e.a aVar = new com.tencent.liteav.basic.e.a(i7, i8, i5, i6);
        AppMethodBeat.o(66013);
        return aVar;
    }

    public static void e() {
        AppMethodBeat.i(66014);
        synchronized (n) {
            try {
                if (!o) {
                    a("stlport_shared");
                    a("saturn");
                    a("txffmpeg");
                    a("liteavsdk");
                    o = true;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(66014);
            }
        }
    }

    public static void a(String str) {
        AppMethodBeat.i(66015);
        try {
            System.loadLibrary(str);
            AppMethodBeat.o(66015);
        } catch (Error e) {
            new StringBuilder("load library : ").append(e.toString());
            b(k, str);
            AppMethodBeat.o(66015);
        } catch (Exception e2) {
            new StringBuilder("load library : ").append(e2.toString());
            b(k, str);
            AppMethodBeat.o(66015);
        }
    }

    private static void b(String str, String str2) {
        AppMethodBeat.i(66016);
        try {
            if (!TextUtils.isEmpty(str)) {
                System.load(str + "/lib" + str2 + ".so");
            }
            AppMethodBeat.o(66016);
        } catch (Error e) {
            new StringBuilder("load library : ").append(e.toString());
            AppMethodBeat.o(66016);
        } catch (Exception e2) {
            new StringBuilder("load library : ").append(e2.toString());
            AppMethodBeat.o(66016);
        }
    }

    public static void b(String str) {
        k = str;
    }

    public static String f() {
        return k;
    }

    public static int a(int i) {
        int i2 = 0;
        while (i2 < p.length && p[i2] != i) {
            i2++;
        }
        if (i2 >= p.length) {
            return -1;
        }
        return i2;
    }

    @TargetApi(16)
    public static MediaFormat a(int i, int i2, int i3) {
        AppMethodBeat.i(66017);
        int a = a(i);
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.put(0, (byte) ((i3 << 3) | (a >> 1)));
        allocate.put(1, (byte) (((a & 1) << 7) | (i2 << 3)));
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", i, i2);
        createAudioFormat.setInteger("channel-count", i2);
        createAudioFormat.setInteger("sample-rate", i);
        createAudioFormat.setByteBuffer("csd-0", allocate);
        AppMethodBeat.o(66017);
        return createAudioFormat;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0058 A:{SYNTHETIC, Splitter:B:23:0x0058} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0069 A:{SYNTHETIC, Splitter:B:31:0x0069} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0069 A:{SYNTHETIC, Splitter:B:31:0x0069} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(String str, String str2) {
        Throwable th;
        AppMethodBeat.i(66018);
        if (str == null || str2 == null) {
            AppMethodBeat.o(66018);
            return false;
        }
        MediaMetadataRetriever mediaMetadataRetriever;
        FileOutputStream fileOutputStream;
        try {
            if (new File(str).exists()) {
                mediaMetadataRetriever = new MediaMetadataRetriever();
                try {
                    mediaMetadataRetriever.setDataSource(str);
                    Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime();
                    File file = new File(str2);
                    if (file.exists()) {
                        file.delete();
                    }
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        frameAtTime.compress(CompressFormat.JPEG, 100, fileOutputStream);
                        fileOutputStream.flush();
                        try {
                            fileOutputStream.close();
                        } catch (IOException e) {
                        }
                        mediaMetadataRetriever.release();
                        AppMethodBeat.o(66018);
                        return true;
                    } catch (Exception e2) {
                        if (fileOutputStream != null) {
                        }
                        if (mediaMetadataRetriever != null) {
                        }
                        AppMethodBeat.o(66018);
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileOutputStream != null) {
                        }
                        if (mediaMetadataRetriever != null) {
                        }
                        AppMethodBeat.o(66018);
                        throw th;
                    }
                } catch (Exception e3) {
                    fileOutputStream = null;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    if (mediaMetadataRetriever != null) {
                        mediaMetadataRetriever.release();
                    }
                    AppMethodBeat.o(66018);
                    return false;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    if (mediaMetadataRetriever != null) {
                        mediaMetadataRetriever.release();
                    }
                    AppMethodBeat.o(66018);
                    throw th;
                }
            }
            AppMethodBeat.o(66018);
            return false;
        } catch (Exception e6) {
            mediaMetadataRetriever = null;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            mediaMetadataRetriever = null;
            fileOutputStream = null;
            if (fileOutputStream != null) {
            }
            if (mediaMetadataRetriever != null) {
            }
            AppMethodBeat.o(66018);
            throw th;
        }
    }

    private static void a(String str, MediaFormat mediaFormat, byte[] bArr, int i, int i2) {
        AppMethodBeat.i(66019);
        ByteBuffer allocate = ByteBuffer.allocate(i2 - i);
        allocate.put(bArr, i, i2 - i);
        allocate.position(0);
        mediaFormat.setByteBuffer(str, allocate);
        AppMethodBeat.o(66019);
    }

    @TargetApi(16)
    public static MediaFormat a(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(66020);
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i, i2);
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        Object obj = null;
        Object obj2 = null;
        while (i3 + 3 < bArr.length) {
            int i6;
            if (bArr[i3] == (byte) 0 && bArr[i3 + 1] == (byte) 0 && bArr[i3 + 2] == (byte) 1) {
                i6 = 3;
            } else {
                i6 = 0;
            }
            if (bArr[i3] == (byte) 0 && bArr[i3 + 1] == (byte) 0 && bArr[i3 + 2] == (byte) 0 && bArr[i3 + 3] == (byte) 1) {
                i6 = 4;
            }
            if (i6 > 0) {
                if (i5 == 0) {
                    i3 += i6;
                    i5 = i6;
                } else {
                    i4 = bArr[i5] & 31;
                    if (i4 == 7) {
                        a("csd-0", createVideoFormat, bArr, i5, i3);
                        obj2 = 1;
                    } else if (i4 == 8) {
                        a("csd-1", createVideoFormat, bArr, i5, i3);
                        int obj3 = 1;
                    }
                    int i7 = i3 + i6;
                    if (obj2 == null || obj3 == null) {
                        i6 = i7;
                        i4 = i3;
                        i5 = i7;
                        i3 = i6 + 1;
                    } else {
                        AppMethodBeat.o(66020);
                        return createVideoFormat;
                    }
                }
            }
            i6 = i3;
            i3 = i6 + 1;
        }
        i3 = bArr[i5] & 31;
        if (obj2 != null && i3 == 8) {
            a("csd-1", createVideoFormat, bArr, i5, i4);
            AppMethodBeat.o(66020);
            return createVideoFormat;
        } else if (obj3 == null || i3 != 7) {
            AppMethodBeat.o(66020);
            return null;
        } else {
            a("csd-0", createVideoFormat, bArr, i5, i4);
            AppMethodBeat.o(66020);
            return createVideoFormat;
        }
    }
}

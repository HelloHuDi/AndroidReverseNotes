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
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.p140d.C0946a;
import com.tencent.liteav.basic.p141e.C32140a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
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

/* renamed from: com.tencent.liteav.basic.util.b */
public class C17778b {
    /* renamed from: a */
    public static long f4126a = 0;
    /* renamed from: b */
    private static float f4127b = 0.0f;
    /* renamed from: c */
    private static float f4128c = 0.0f;
    /* renamed from: d */
    private static float f4129d = 0.0f;
    /* renamed from: e */
    private static float f4130e = 0.0f;
    /* renamed from: f */
    private static float f4131f = 0.0f;
    /* renamed from: g */
    private static float f4132g = 0.0f;
    /* renamed from: h */
    private static boolean f4133h = true;
    /* renamed from: i */
    private static int[] f4134i = new int[2];
    /* renamed from: j */
    private static long f4135j = 0;
    /* renamed from: k */
    private static String f4136k = "";
    /* renamed from: l */
    private static int f4137l = 0;
    /* renamed from: m */
    private static long f4138m = 0;
    /* renamed from: n */
    private static final Object f4139n = new Object();
    /* renamed from: o */
    private static boolean f4140o = false;
    /* renamed from: p */
    private static int[] f4141p = new int[]{96000, 88200, 64000, TXRecordCommon.AUDIO_SAMPLERATE_48000, TXRecordCommon.AUDIO_SAMPLERATE_44100, TXRecordCommon.AUDIO_SAMPLERATE_32000, 24000, 22050, TXRecordCommon.AUDIO_SAMPLERATE_16000, 12000, 11025, TXRecordCommon.AUDIO_SAMPLERATE_8000, 7350};

    static {
        AppMethodBeat.m2504i(66021);
        AppMethodBeat.m2505o(66021);
    }

    /* renamed from: g */
    private static long m27758g() {
        AppMethodBeat.m2504i(66000);
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
        AppMethodBeat.m2505o(66000);
        return j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0082  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: h */
    private static void m27759h() {
        long parseLong;
        long parseLong2;
        AppMethodBeat.m2504i(66001);
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
                        if (f4133h) {
                        }
                    }
                    if (f4133h) {
                        f4127b = (float) parseLong;
                        f4131f = (float) parseLong2;
                        AppMethodBeat.m2505o(66001);
                        return;
                    }
                    f4128c = (float) parseLong;
                    f4132g = (float) parseLong2;
                    AppMethodBeat.m2505o(66001);
                    return;
                }
            } catch (Exception e2) {
                parseLong = 0;
                parseLong2 = 0;
                if (f4133h) {
                }
            }
        }
        parseLong2 = 0;
        parseLong = 0;
        if (f4133h) {
        }
    }

    /* renamed from: a */
    public static int[] m27747a() {
        AppMethodBeat.m2504i(66002);
        if (f4135j == 0 || TXCTimeUtil.getTimeTick() - f4135j >= FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
            int[] iArr = new int[2];
            if (f4133h) {
                f4129d = (float) C17778b.m27758g();
                C17778b.m27759h();
                f4133h = false;
                iArr[0] = 0;
                iArr[1] = 0;
                AppMethodBeat.m2505o(66002);
                return iArr;
            }
            float f;
            float f2;
            f4130e = (float) C17778b.m27758g();
            C17778b.m27759h();
            if (f4128c != f4127b) {
                f = (100.0f * ((f4128c - f4127b) - (f4132g - f4131f))) / (f4128c - f4127b);
                f2 = (100.0f * (f4130e - f4129d)) / (f4128c - f4127b);
            } else {
                f = 0.0f;
                f2 = 0.0f;
            }
            f4127b = f4128c;
            f4129d = f4130e;
            f4131f = f4132g;
            iArr[0] = (int) (f2 * 10.0f);
            iArr[1] = (int) (f * 10.0f);
            f4134i[0] = iArr[0];
            f4134i[1] = iArr[1];
            f4135j = TXCTimeUtil.getTimeTick();
            AppMethodBeat.m2505o(66002);
            return iArr;
        }
        int[] iArr2 = f4134i;
        AppMethodBeat.m2505o(66002);
        return iArr2;
    }

    /* renamed from: b */
    public static int m27748b() {
        AppMethodBeat.m2504i(66003);
        try {
            int totalPss;
            if (f4138m == 0 || TXCTimeUtil.getTimeTick() - f4138m >= 10000) {
                MemoryInfo memoryInfo = new MemoryInfo();
                Debug.getMemoryInfo(memoryInfo);
                totalPss = memoryInfo.getTotalPss();
                f4138m = TXCTimeUtil.getTimeTick();
                f4137l = totalPss / WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                totalPss = f4137l;
                AppMethodBeat.m2505o(66003);
                return totalPss;
            }
            totalPss = f4137l;
            AppMethodBeat.m2505o(66003);
            return totalPss;
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public static String m27739a(Context context) {
        AppMethodBeat.m2504i(66004);
        String simulateIDFA = TXCDRApi.getSimulateIDFA(context);
        AppMethodBeat.m2505o(66004);
        return simulateIDFA;
    }

    /* renamed from: b */
    public static String m27749b(Context context) {
        AppMethodBeat.m2504i(66005);
        String str = "";
        if (context != null) {
            try {
                str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
            } catch (Exception e) {
            }
        }
        AppMethodBeat.m2505o(66005);
        return str;
    }

    /* renamed from: c */
    public static int m27752c(Context context) {
        AppMethodBeat.m2504i(66006);
        if (context == null) {
            AppMethodBeat.m2505o(66006);
            return 255;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            AppMethodBeat.m2505o(66006);
            return 255;
        } else if (!activeNetworkInfo.isConnected()) {
            AppMethodBeat.m2505o(66006);
            return 255;
        } else if (activeNetworkInfo.getType() == 9) {
            AppMethodBeat.m2505o(66006);
            return 5;
        } else if (activeNetworkInfo.getType() == 1) {
            AppMethodBeat.m2505o(66006);
            return 1;
        } else if (activeNetworkInfo.getType() == 0) {
            switch (telephonyManager.getNetworkType()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    AppMethodBeat.m2505o(66006);
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
                    AppMethodBeat.m2505o(66006);
                    return 3;
                case 13:
                    AppMethodBeat.m2505o(66006);
                    return 2;
                default:
                    AppMethodBeat.m2505o(66006);
                    return 2;
            }
        } else {
            AppMethodBeat.m2505o(66006);
            return 255;
        }
    }

    /* renamed from: c */
    public static String m27753c() {
        return Build.MODEL;
    }

    /* renamed from: d */
    public static String m27754d() {
        AppMethodBeat.m2504i(66007);
        String uuid = UUID.randomUUID().toString();
        AppMethodBeat.m2505o(66007);
        return uuid;
    }

    /* renamed from: d */
    public static String m27755d(Context context) {
        AppMethodBeat.m2504i(66008);
        String devUUID = TXCDRApi.getDevUUID(context, TXCDRApi.getSimulateIDFA(context));
        AppMethodBeat.m2505o(66008);
        return devUUID;
    }

    /* renamed from: a */
    public static void m27745a(WeakReference<C0946a> weakReference, long j, int i, String str) {
        AppMethodBeat.m2504i(66009);
        Bundle bundle = new Bundle();
        bundle.putLong("EVT_USERID", j);
        bundle.putInt("EVT_ID", i);
        bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
        if (str != null) {
            bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, str);
        }
        C17778b.m27742a((WeakReference) weakReference, i, bundle);
        AppMethodBeat.m2505o(66009);
    }

    /* renamed from: a */
    public static void m27743a(WeakReference<C0946a> weakReference, int i, String str) {
        AppMethodBeat.m2504i(66010);
        Bundle bundle = new Bundle();
        bundle.putInt("EVT_ID", i);
        bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
        if (str != null) {
            bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, str);
        }
        C17778b.m27742a((WeakReference) weakReference, i, bundle);
        AppMethodBeat.m2505o(66010);
    }

    /* renamed from: a */
    public static void m27742a(WeakReference<C0946a> weakReference, int i, Bundle bundle) {
        AppMethodBeat.m2504i(66011);
        if (weakReference == null) {
            AppMethodBeat.m2505o(66011);
            return;
        }
        C0946a c0946a = (C0946a) weakReference.get();
        if (c0946a != null) {
            c0946a.onNotifyEvent(i, bundle);
        }
        AppMethodBeat.m2505o(66011);
    }

    /* renamed from: a */
    public static void m27744a(WeakReference<C0946a> weakReference, long j, int i, Bundle bundle) {
        AppMethodBeat.m2504i(66012);
        if (weakReference == null) {
            AppMethodBeat.m2505o(66012);
            return;
        }
        C0946a c0946a = (C0946a) weakReference.get();
        if (c0946a != null) {
            bundle.putLong("EVT_USERID", j);
            c0946a.onNotifyEvent(i, bundle);
        }
        AppMethodBeat.m2505o(66012);
    }

    /* renamed from: a */
    public static C32140a m27738a(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8 = 0;
        AppMethodBeat.m2504i(66013);
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
        C32140a c32140a = new C32140a(i7, i8, i5, i6);
        AppMethodBeat.m2505o(66013);
        return c32140a;
    }

    /* renamed from: e */
    public static void m27756e() {
        AppMethodBeat.m2504i(66014);
        synchronized (f4139n) {
            try {
                if (!f4140o) {
                    C17778b.m27740a("stlport_shared");
                    C17778b.m27740a("saturn");
                    C17778b.m27740a("txffmpeg");
                    C17778b.m27740a("liteavsdk");
                    f4140o = true;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(66014);
            }
        }
    }

    /* renamed from: a */
    public static void m27740a(String str) {
        AppMethodBeat.m2504i(66015);
        try {
            System.loadLibrary(str);
            AppMethodBeat.m2505o(66015);
        } catch (Error e) {
            new StringBuilder("load library : ").append(e.toString());
            C17778b.m27751b(f4136k, str);
            AppMethodBeat.m2505o(66015);
        } catch (Exception e2) {
            new StringBuilder("load library : ").append(e2.toString());
            C17778b.m27751b(f4136k, str);
            AppMethodBeat.m2505o(66015);
        }
    }

    /* renamed from: b */
    private static void m27751b(String str, String str2) {
        AppMethodBeat.m2504i(66016);
        try {
            if (!TextUtils.isEmpty(str)) {
                System.load(str + "/lib" + str2 + ".so");
            }
            AppMethodBeat.m2505o(66016);
        } catch (Error e) {
            new StringBuilder("load library : ").append(e.toString());
            AppMethodBeat.m2505o(66016);
        } catch (Exception e2) {
            new StringBuilder("load library : ").append(e2.toString());
            AppMethodBeat.m2505o(66016);
        }
    }

    /* renamed from: b */
    public static void m27750b(String str) {
        f4136k = str;
    }

    /* renamed from: f */
    public static String m27757f() {
        return f4136k;
    }

    /* renamed from: a */
    public static int m27735a(int i) {
        int i2 = 0;
        while (i2 < f4141p.length && f4141p[i2] != i) {
            i2++;
        }
        if (i2 >= f4141p.length) {
            return -1;
        }
        return i2;
    }

    @TargetApi(16)
    /* renamed from: a */
    public static MediaFormat m27736a(int i, int i2, int i3) {
        AppMethodBeat.m2504i(66017);
        int a = C17778b.m27735a(i);
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.put(0, (byte) ((i3 << 3) | (a >> 1)));
        allocate.put(1, (byte) (((a & 1) << 7) | (i2 << 3)));
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", i, i2);
        createAudioFormat.setInteger("channel-count", i2);
        createAudioFormat.setInteger("sample-rate", i);
        createAudioFormat.setByteBuffer("csd-0", allocate);
        AppMethodBeat.m2505o(66017);
        return createAudioFormat;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0058 A:{SYNTHETIC, Splitter:B:23:0x0058} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0069 A:{SYNTHETIC, Splitter:B:31:0x0069} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0069 A:{SYNTHETIC, Splitter:B:31:0x0069} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static boolean m27746a(String str, String str2) {
        Throwable th;
        AppMethodBeat.m2504i(66018);
        if (str == null || str2 == null) {
            AppMethodBeat.m2505o(66018);
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
                        AppMethodBeat.m2505o(66018);
                        return true;
                    } catch (Exception e2) {
                        if (fileOutputStream != null) {
                        }
                        if (mediaMetadataRetriever != null) {
                        }
                        AppMethodBeat.m2505o(66018);
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileOutputStream != null) {
                        }
                        if (mediaMetadataRetriever != null) {
                        }
                        AppMethodBeat.m2505o(66018);
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
                    AppMethodBeat.m2505o(66018);
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
                    AppMethodBeat.m2505o(66018);
                    throw th;
                }
            }
            AppMethodBeat.m2505o(66018);
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
            AppMethodBeat.m2505o(66018);
            throw th;
        }
    }

    /* renamed from: a */
    private static void m27741a(String str, MediaFormat mediaFormat, byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(66019);
        ByteBuffer allocate = ByteBuffer.allocate(i2 - i);
        allocate.put(bArr, i, i2 - i);
        allocate.position(0);
        mediaFormat.setByteBuffer(str, allocate);
        AppMethodBeat.m2505o(66019);
    }

    @TargetApi(16)
    /* renamed from: a */
    public static MediaFormat m27737a(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(66020);
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
                        C17778b.m27741a("csd-0", createVideoFormat, bArr, i5, i3);
                        obj2 = 1;
                    } else if (i4 == 8) {
                        C17778b.m27741a("csd-1", createVideoFormat, bArr, i5, i3);
                        int obj3 = 1;
                    }
                    int i7 = i3 + i6;
                    if (obj2 == null || obj3 == null) {
                        i6 = i7;
                        i4 = i3;
                        i5 = i7;
                        i3 = i6 + 1;
                    } else {
                        AppMethodBeat.m2505o(66020);
                        return createVideoFormat;
                    }
                }
            }
            i6 = i3;
            i3 = i6 + 1;
        }
        i3 = bArr[i5] & 31;
        if (obj2 != null && i3 == 8) {
            C17778b.m27741a("csd-1", createVideoFormat, bArr, i5, i4);
            AppMethodBeat.m2505o(66020);
            return createVideoFormat;
        } else if (obj3 == null || i3 != 7) {
            AppMethodBeat.m2505o(66020);
            return null;
        } else {
            C17778b.m27741a("csd-0", createVideoFormat, bArr, i5, i4);
            AppMethodBeat.m2505o(66020);
            return createVideoFormat;
        }
    }
}

package com.tencent.p177mm.plugin.downloader.p376d;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.downloader.p376d.C20313b.C20314b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.plugin.downloader.d.i */
public final class C11507i {
    /* renamed from: E */
    public static Map<Integer, ByteBuffer> m19306E(ByteBuffer byteBuffer) {
        C20314b c20314b;
        AppMethodBeat.m2504i(2326);
        C20313b.m31416D(byteBuffer);
        ByteBuffer d = C20313b.m31420d(byteBuffer, byteBuffer.capacity() - 24);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i = 0;
        while (d.hasRemaining()) {
            i++;
            if (d.remaining() < 8) {
                c20314b = new C20314b("Insufficient data to read size of APK Signing Block entry #".concat(String.valueOf(i)));
                AppMethodBeat.m2505o(2326);
                throw c20314b;
            }
            long j = d.getLong();
            if (j < 4 || j > 2147483647L) {
                c20314b = new C20314b("APK Signing Block entry #" + i + " size out of range: " + j);
                AppMethodBeat.m2505o(2326);
                throw c20314b;
            }
            int i2 = (int) j;
            int position = d.position() + i2;
            if (i2 > d.remaining()) {
                C20314b c20314b2 = new C20314b("APK Signing Block entry #" + i + " size out of range: " + i2 + ", available: " + d.remaining());
                AppMethodBeat.m2505o(2326);
                throw c20314b2;
            }
            int i3 = d.getInt();
            linkedHashMap.put(Integer.valueOf(i3), C20313b.m31422e(d, i2 - 4));
            if (i3 == 1896449818) {
                C4990ab.m7416i("MicroMsg.Channel.V2SchemeUtil", "find V2 signature block Id : 1896449818");
            }
            d.position(position);
        }
        if (linkedHashMap.isEmpty()) {
            c20314b = new C20314b("not have Id-Value Pair in APK Signing Block entry #".concat(String.valueOf(i)));
            AppMethodBeat.m2505o(2326);
            throw c20314b;
        }
        AppMethodBeat.m2505o(2326);
        return linkedHashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0048  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: P */
    public static ByteBuffer m19308P(File file) {
        Throwable th;
        ByteBuffer byteBuffer = null;
        AppMethodBeat.m2504i(2327);
        if (file != null && file.exists() && file.isFile()) {
            RandomAccessFile randomAccessFile;
            try {
                randomAccessFile = new RandomAccessFile(file, "r");
                try {
                    Pair e = C20313b.m31421e(randomAccessFile);
                    byteBuffer = (ByteBuffer) e.first;
                    long longValue = ((Long) e.second).longValue();
                    if (C2884k.m5125c(randomAccessFile, longValue)) {
                        C20314b c20314b = new C20314b("ZIP64 APK not supported");
                        AppMethodBeat.m2505o(2327);
                        throw c20314b;
                    }
                    byteBuffer = (ByteBuffer) C20313b.m31419b(randomAccessFile, C20313b.m31418b(byteBuffer, longValue)).first;
                    randomAccessFile.close();
                    AppMethodBeat.m2505o(2327);
                } catch (Throwable th2) {
                    th = th2;
                    if (randomAccessFile != null) {
                    }
                    AppMethodBeat.m2505o(2327);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                AppMethodBeat.m2505o(2327);
                throw th;
            }
        }
        AppMethodBeat.m2505o(2327);
        return byteBuffer;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0176 A:{Catch:{ all -> 0x0035 }} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0155 A:{Catch:{ all -> 0x0035 }} */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: Q */
    public static C27707a m19309Q(File file) {
        Throwable th;
        AppMethodBeat.m2504i(2328);
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "r");
            try {
                Pair e = C20313b.m31421e(randomAccessFile2);
                ByteBuffer byteBuffer = (ByteBuffer) e.first;
                long longValue = ((Long) e.second).longValue();
                if (C2884k.m5125c(randomAccessFile2, longValue)) {
                    C20314b c20314b = new C20314b("ZIP64 APK not supported");
                    AppMethodBeat.m2505o(2328);
                    throw c20314b;
                }
                long b = C20313b.m31418b(byteBuffer, longValue);
                Pair b2 = C20313b.m31419b(randomAccessFile2, b);
                Pair create = Pair.create(C11507i.m19311a(randomAccessFile2, b, (int) (longValue - b)), Long.valueOf(b));
                C27707a c27707a = new C27707a();
                c27707a.lowMemory = false;
                c27707a.kLT = file.length();
                c27707a.kLU = Pair.create(C11507i.m19311a(randomAccessFile2, 0, (int) ((Long) b2.second).longValue()), Long.valueOf(0));
                c27707a.kLV = b2;
                c27707a.kLW = create;
                c27707a.kLX = e;
                RuntimeException runtimeException;
                if ((!c27707a.lowMemory && c27707a.kLU == null) || c27707a.kLV == null || c27707a.kLW == null || c27707a.kLX == null) {
                    runtimeException = new RuntimeException("ApkSectionInfo paramters is not valid : " + c27707a.toString());
                    AppMethodBeat.m2505o(2328);
                    throw runtimeException;
                }
                Object obj;
                if ((c27707a.lowMemory || (((Long) c27707a.kLU.second).longValue() == 0 && ((long) ((ByteBuffer) c27707a.kLU.first).remaining()) + ((Long) c27707a.kLU.second).longValue() == ((Long) c27707a.kLV.second).longValue())) && ((long) ((ByteBuffer) c27707a.kLV.first).remaining()) + ((Long) c27707a.kLV.second).longValue() == ((Long) c27707a.kLW.second).longValue() && ((long) ((ByteBuffer) c27707a.kLW.first).remaining()) + ((Long) c27707a.kLW.second).longValue() == ((Long) c27707a.kLX.second).longValue()) {
                    if (((Long) c27707a.kLX.second).longValue() + ((long) ((ByteBuffer) c27707a.kLX.first).remaining()) == c27707a.kLT) {
                        obj = 1;
                        if (obj != null) {
                            runtimeException = new RuntimeException("ApkSectionInfo paramters is not valid : " + c27707a.toString());
                            AppMethodBeat.m2505o(2328);
                            throw runtimeException;
                        }
                        long b3 = C20313b.m31418b((ByteBuffer) c27707a.kLX.first, ((Long) c27707a.kLX.second).longValue());
                        if (b3 != ((Long) c27707a.kLW.second).longValue()) {
                            runtimeException = new RuntimeException("CentralDirOffset mismatch , EocdCentralDirOffset : " + b3 + ", centralDirOffset : " + c27707a.kLW.second);
                            AppMethodBeat.m2505o(2328);
                            throw runtimeException;
                        }
                        C4990ab.m7416i("MicroMsg.Channel.V2SchemeUtil", "baseApk : " + file.getAbsolutePath() + "\nApkSectionInfo = " + c27707a);
                        randomAccessFile2.close();
                        AppMethodBeat.m2505o(2328);
                        return c27707a;
                    }
                }
                obj = null;
                if (obj != null) {
                }
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                AppMethodBeat.m2505o(2328);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (randomAccessFile != null) {
            }
            AppMethodBeat.m2505o(2328);
            throw th;
        }
    }

    /* renamed from: a */
    private static ByteBuffer m19311a(RandomAccessFile randomAccessFile, long j, int i) {
        AppMethodBeat.m2504i(2329);
        ByteBuffer allocate = ByteBuffer.allocate(i);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        randomAccessFile.seek(j);
        randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
        AppMethodBeat.m2505o(2329);
        return allocate;
    }

    /* renamed from: G */
    public static ByteBuffer m19307G(Map<Integer, ByteBuffer> map) {
        AppMethodBeat.m2504i(2330);
        RuntimeException runtimeException;
        if (map == null || map.isEmpty()) {
            runtimeException = new RuntimeException("getNewApkV2SchemeBlock , id value pair is empty");
            AppMethodBeat.m2505o(2330);
            throw runtimeException;
        }
        long j;
        long j2 = 24;
        Iterator it = map.entrySet().iterator();
        while (true) {
            j = j2;
            if (!it.hasNext()) {
                break;
            }
            j2 = ((long) (((ByteBuffer) ((Entry) it.next()).getValue()).remaining() + 12)) + j;
        }
        ByteBuffer allocate = ByteBuffer.allocate((int) (8 + j));
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putLong(j);
        for (Entry entry : map.entrySet()) {
            ByteBuffer byteBuffer = (ByteBuffer) entry.getValue();
            allocate.putLong((long) (byteBuffer.remaining() + 4));
            allocate.putInt(((Integer) entry.getKey()).intValue());
            allocate.put(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
        }
        allocate.putLong(j);
        allocate.putLong(2334950737559900225L);
        allocate.putLong(3617552046287187010L);
        if (allocate.remaining() > 0) {
            runtimeException = new RuntimeException("generateNewApkV2SchemeBlock error");
            AppMethodBeat.m2505o(2330);
            throw runtimeException;
        }
        allocate.flip();
        AppMethodBeat.m2505o(2330);
        return allocate;
    }

    /* renamed from: R */
    public static boolean m19310R(File file) {
        AppMethodBeat.m2504i(2331);
        try {
            if (C11507i.m19306E(C11507i.m19308P(file)).containsKey(Integer.valueOf(1896449818))) {
                AppMethodBeat.m2505o(2331);
                return true;
            }
        } catch (IOException e) {
            C4990ab.m7413e("MicroMsg.Channel.V2SchemeUtil", "containV2Signature, error: %s", e.getMessage());
        } catch (C20314b e2) {
            C4990ab.m7412e("MicroMsg.Channel.V2SchemeUtil", "APK : " + file.getAbsolutePath() + " not have apk signature block");
        }
        AppMethodBeat.m2505o(2331);
        return false;
    }
}

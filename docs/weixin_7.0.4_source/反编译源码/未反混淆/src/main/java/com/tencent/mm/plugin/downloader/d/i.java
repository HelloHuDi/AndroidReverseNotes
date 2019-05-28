package com.tencent.mm.plugin.downloader.d;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.d.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class i {
    public static Map<Integer, ByteBuffer> E(ByteBuffer byteBuffer) {
        b bVar;
        AppMethodBeat.i(2326);
        b.D(byteBuffer);
        ByteBuffer d = b.d(byteBuffer, byteBuffer.capacity() - 24);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i = 0;
        while (d.hasRemaining()) {
            i++;
            if (d.remaining() < 8) {
                bVar = new b("Insufficient data to read size of APK Signing Block entry #".concat(String.valueOf(i)));
                AppMethodBeat.o(2326);
                throw bVar;
            }
            long j = d.getLong();
            if (j < 4 || j > 2147483647L) {
                bVar = new b("APK Signing Block entry #" + i + " size out of range: " + j);
                AppMethodBeat.o(2326);
                throw bVar;
            }
            int i2 = (int) j;
            int position = d.position() + i2;
            if (i2 > d.remaining()) {
                b bVar2 = new b("APK Signing Block entry #" + i + " size out of range: " + i2 + ", available: " + d.remaining());
                AppMethodBeat.o(2326);
                throw bVar2;
            }
            int i3 = d.getInt();
            linkedHashMap.put(Integer.valueOf(i3), b.e(d, i2 - 4));
            if (i3 == 1896449818) {
                ab.i("MicroMsg.Channel.V2SchemeUtil", "find V2 signature block Id : 1896449818");
            }
            d.position(position);
        }
        if (linkedHashMap.isEmpty()) {
            bVar = new b("not have Id-Value Pair in APK Signing Block entry #".concat(String.valueOf(i)));
            AppMethodBeat.o(2326);
            throw bVar;
        }
        AppMethodBeat.o(2326);
        return linkedHashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0048  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static ByteBuffer P(File file) {
        Throwable th;
        ByteBuffer byteBuffer = null;
        AppMethodBeat.i(2327);
        if (file != null && file.exists() && file.isFile()) {
            RandomAccessFile randomAccessFile;
            try {
                randomAccessFile = new RandomAccessFile(file, "r");
                try {
                    Pair e = b.e(randomAccessFile);
                    byteBuffer = (ByteBuffer) e.first;
                    long longValue = ((Long) e.second).longValue();
                    if (k.c(randomAccessFile, longValue)) {
                        b bVar = new b("ZIP64 APK not supported");
                        AppMethodBeat.o(2327);
                        throw bVar;
                    }
                    byteBuffer = (ByteBuffer) b.b(randomAccessFile, b.b(byteBuffer, longValue)).first;
                    randomAccessFile.close();
                    AppMethodBeat.o(2327);
                } catch (Throwable th2) {
                    th = th2;
                    if (randomAccessFile != null) {
                    }
                    AppMethodBeat.o(2327);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                AppMethodBeat.o(2327);
                throw th;
            }
        }
        AppMethodBeat.o(2327);
        return byteBuffer;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0176 A:{Catch:{ all -> 0x0035 }} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0155 A:{Catch:{ all -> 0x0035 }} */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static a Q(File file) {
        Throwable th;
        AppMethodBeat.i(2328);
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "r");
            try {
                Pair e = b.e(randomAccessFile2);
                ByteBuffer byteBuffer = (ByteBuffer) e.first;
                long longValue = ((Long) e.second).longValue();
                if (k.c(randomAccessFile2, longValue)) {
                    b bVar = new b("ZIP64 APK not supported");
                    AppMethodBeat.o(2328);
                    throw bVar;
                }
                long b = b.b(byteBuffer, longValue);
                Pair b2 = b.b(randomAccessFile2, b);
                Pair create = Pair.create(a(randomAccessFile2, b, (int) (longValue - b)), Long.valueOf(b));
                a aVar = new a();
                aVar.lowMemory = false;
                aVar.kLT = file.length();
                aVar.kLU = Pair.create(a(randomAccessFile2, 0, (int) ((Long) b2.second).longValue()), Long.valueOf(0));
                aVar.kLV = b2;
                aVar.kLW = create;
                aVar.kLX = e;
                RuntimeException runtimeException;
                if ((!aVar.lowMemory && aVar.kLU == null) || aVar.kLV == null || aVar.kLW == null || aVar.kLX == null) {
                    runtimeException = new RuntimeException("ApkSectionInfo paramters is not valid : " + aVar.toString());
                    AppMethodBeat.o(2328);
                    throw runtimeException;
                }
                Object obj;
                if ((aVar.lowMemory || (((Long) aVar.kLU.second).longValue() == 0 && ((long) ((ByteBuffer) aVar.kLU.first).remaining()) + ((Long) aVar.kLU.second).longValue() == ((Long) aVar.kLV.second).longValue())) && ((long) ((ByteBuffer) aVar.kLV.first).remaining()) + ((Long) aVar.kLV.second).longValue() == ((Long) aVar.kLW.second).longValue() && ((long) ((ByteBuffer) aVar.kLW.first).remaining()) + ((Long) aVar.kLW.second).longValue() == ((Long) aVar.kLX.second).longValue()) {
                    if (((Long) aVar.kLX.second).longValue() + ((long) ((ByteBuffer) aVar.kLX.first).remaining()) == aVar.kLT) {
                        obj = 1;
                        if (obj != null) {
                            runtimeException = new RuntimeException("ApkSectionInfo paramters is not valid : " + aVar.toString());
                            AppMethodBeat.o(2328);
                            throw runtimeException;
                        }
                        long b3 = b.b((ByteBuffer) aVar.kLX.first, ((Long) aVar.kLX.second).longValue());
                        if (b3 != ((Long) aVar.kLW.second).longValue()) {
                            runtimeException = new RuntimeException("CentralDirOffset mismatch , EocdCentralDirOffset : " + b3 + ", centralDirOffset : " + aVar.kLW.second);
                            AppMethodBeat.o(2328);
                            throw runtimeException;
                        }
                        ab.i("MicroMsg.Channel.V2SchemeUtil", "baseApk : " + file.getAbsolutePath() + "\nApkSectionInfo = " + aVar);
                        randomAccessFile2.close();
                        AppMethodBeat.o(2328);
                        return aVar;
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
                AppMethodBeat.o(2328);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (randomAccessFile != null) {
            }
            AppMethodBeat.o(2328);
            throw th;
        }
    }

    private static ByteBuffer a(RandomAccessFile randomAccessFile, long j, int i) {
        AppMethodBeat.i(2329);
        ByteBuffer allocate = ByteBuffer.allocate(i);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        randomAccessFile.seek(j);
        randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
        AppMethodBeat.o(2329);
        return allocate;
    }

    public static ByteBuffer G(Map<Integer, ByteBuffer> map) {
        AppMethodBeat.i(2330);
        RuntimeException runtimeException;
        if (map == null || map.isEmpty()) {
            runtimeException = new RuntimeException("getNewApkV2SchemeBlock , id value pair is empty");
            AppMethodBeat.o(2330);
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
            AppMethodBeat.o(2330);
            throw runtimeException;
        }
        allocate.flip();
        AppMethodBeat.o(2330);
        return allocate;
    }

    public static boolean R(File file) {
        AppMethodBeat.i(2331);
        try {
            if (E(P(file)).containsKey(Integer.valueOf(1896449818))) {
                AppMethodBeat.o(2331);
                return true;
            }
        } catch (IOException e) {
            ab.e("MicroMsg.Channel.V2SchemeUtil", "containV2Signature, error: %s", e.getMessage());
        } catch (b e2) {
            ab.e("MicroMsg.Channel.V2SchemeUtil", "APK : " + file.getAbsolutePath() + " not have apk signature block");
        }
        AppMethodBeat.o(2331);
        return false;
    }
}

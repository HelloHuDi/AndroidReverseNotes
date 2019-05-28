package com.tencent.mm.plugin.downloader.d;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.d.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.io.DataOutput;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public final class h {

    /* renamed from: com.tencent.mm.plugin.downloader.d.h$1 */
    static class AnonymousClass1 extends HashMap<String, String> {
        final /* synthetic */ String kMd;

        AnonymousClass1(String str) {
            this.kMd = str;
            AppMethodBeat.i(2322);
            put(DownloadInfoColumns.CHANNELID, this.kMd);
            AppMethodBeat.o(2322);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static Pair<ByteBuffer, Long> N(File file) {
        Throwable th;
        AppMethodBeat.i(2323);
        if (file != null && file.exists() && file.isFile()) {
            RandomAccessFile randomAccessFile;
            try {
                randomAccessFile = new RandomAccessFile(file, "r");
                try {
                    Pair<ByteBuffer, Long> e = b.e(randomAccessFile);
                    if (k.c(randomAccessFile, ((Long) e.second).longValue())) {
                        b bVar = new b("ZIP64 APK not supported");
                        AppMethodBeat.o(2323);
                        throw bVar;
                    }
                    randomAccessFile.close();
                    AppMethodBeat.o(2323);
                    return e;
                } catch (Throwable th2) {
                    th = th2;
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                    AppMethodBeat.o(2323);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                }
                AppMethodBeat.o(2323);
                throw th;
            }
        }
        AppMethodBeat.o(2323);
        return null;
    }

    public static boolean O(File file) {
        AppMethodBeat.i(2324);
        try {
            JarEntry jarEntry;
            JarFile jarFile = new JarFile(file);
            JarEntry jarEntry2 = jarFile.getJarEntry("META-INF/MANIFEST.MF");
            Enumeration entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                jarEntry = (JarEntry) entries.nextElement();
                if (jarEntry.getName().matches("META-INF/\\w+\\.SF")) {
                    jarEntry = jarFile.getJarEntry(jarEntry.getName());
                    break;
                }
            }
            jarEntry = null;
            if (!(jarEntry2 == null || r0 == null)) {
                AppMethodBeat.o(2324);
                return true;
            }
        } catch (IOException e) {
            ab.e("MicroMsg.Channel.V1SchemeUtil", "containV1Signature, error: %s", e.getMessage());
        }
        AppMethodBeat.o(2324);
        return false;
    }

    static void a(int i, DataOutput dataOutput) {
        AppMethodBeat.i(2325);
        ByteBuffer order = ByteBuffer.allocate(2).order(ByteOrder.LITTLE_ENDIAN);
        order.putShort((short) i);
        dataOutput.write(order.array());
        AppMethodBeat.o(2325);
    }
}

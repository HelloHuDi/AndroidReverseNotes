package com.tencent.p177mm.plugin.downloader.p376d;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.downloader.p376d.C20313b.C20314b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
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

/* renamed from: com.tencent.mm.plugin.downloader.d.h */
public final class C45830h {

    /* renamed from: com.tencent.mm.plugin.downloader.d.h$1 */
    static class C388481 extends HashMap<String, String> {
        final /* synthetic */ String kMd;

        C388481(String str) {
            this.kMd = str;
            AppMethodBeat.m2504i(2322);
            put(DownloadInfoColumns.CHANNELID, this.kMd);
            AppMethodBeat.m2505o(2322);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: N */
    public static Pair<ByteBuffer, Long> m84823N(File file) {
        Throwable th;
        AppMethodBeat.m2504i(2323);
        if (file != null && file.exists() && file.isFile()) {
            RandomAccessFile randomAccessFile;
            try {
                randomAccessFile = new RandomAccessFile(file, "r");
                try {
                    Pair<ByteBuffer, Long> e = C20313b.m31421e(randomAccessFile);
                    if (C2884k.m5125c(randomAccessFile, ((Long) e.second).longValue())) {
                        C20314b c20314b = new C20314b("ZIP64 APK not supported");
                        AppMethodBeat.m2505o(2323);
                        throw c20314b;
                    }
                    randomAccessFile.close();
                    AppMethodBeat.m2505o(2323);
                    return e;
                } catch (Throwable th2) {
                    th = th2;
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                    AppMethodBeat.m2505o(2323);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                }
                AppMethodBeat.m2505o(2323);
                throw th;
            }
        }
        AppMethodBeat.m2505o(2323);
        return null;
    }

    /* renamed from: O */
    public static boolean m84824O(File file) {
        AppMethodBeat.m2504i(2324);
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
                AppMethodBeat.m2505o(2324);
                return true;
            }
        } catch (IOException e) {
            C4990ab.m7413e("MicroMsg.Channel.V1SchemeUtil", "containV1Signature, error: %s", e.getMessage());
        }
        AppMethodBeat.m2505o(2324);
        return false;
    }

    /* renamed from: a */
    static void m84825a(int i, DataOutput dataOutput) {
        AppMethodBeat.m2504i(2325);
        ByteBuffer order = ByteBuffer.allocate(2).order(ByteOrder.LITTLE_ENDIAN);
        order.putShort((short) i);
        dataOutput.write(order.array());
        AppMethodBeat.m2505o(2325);
    }
}

package com.tencent.p177mm.plugin.downloader.p376d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.downloader.d.c */
public final class C11506c {
    /* renamed from: K */
    public static String m19304K(File file) {
        String str = null;
        AppMethodBeat.m2504i(2310);
        try {
            C4990ab.m7416i("MicroMsg.Channel.ChannelReader", "get channel by v1");
            byte[] Im = C11508j.m19312Im(file.getAbsolutePath());
            if (Im == null) {
                AppMethodBeat.m2505o(2310);
            } else {
                C45829f c45829f = new C45829f();
                c45829f.mo73629E(Im);
                str = c45829f.kMf.getProperty(DownloadInfoColumns.CHANNELID);
                AppMethodBeat.m2505o(2310);
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.Channel.ChannelReader", "APK : %s not have channel info from zip comment", file.getAbsolutePath());
            AppMethodBeat.m2505o(2310);
        }
        return str;
    }

    /* renamed from: L */
    public static String m19305L(File file) {
        byte[] copyOfRange;
        AppMethodBeat.m2504i(2311);
        C4990ab.m7416i("MicroMsg.Channel.ChannelReader", "get channel by v2");
        if (file.exists() && file.isFile()) {
            ByteBuffer byteBuffer;
            if (file.exists() && file.isFile()) {
                Map M = C38847g.m65901M(file);
                byteBuffer = M != null ? (ByteBuffer) M.get(Integer.valueOf(1903261812)) : null;
            } else {
                byteBuffer = null;
            }
            if (byteBuffer != null) {
                copyOfRange = Arrays.copyOfRange(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.limit() + byteBuffer.arrayOffset());
            } else {
                copyOfRange = null;
            }
        } else {
            copyOfRange = null;
        }
        if (copyOfRange == null) {
            AppMethodBeat.m2505o(2311);
            return null;
        }
        C45829f c45829f = new C45829f();
        c45829f.mo73629E(copyOfRange);
        String property = c45829f.kMf.getProperty(DownloadInfoColumns.CHANNELID);
        AppMethodBeat.m2505o(2311);
        return property;
    }

    /* renamed from: Il */
    public static boolean m19303Il(String str) {
        boolean z = false;
        AppMethodBeat.m2504i(2312);
        try {
            z = C20313b.m31417Ik(str);
            AppMethodBeat.m2505o(2312);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.Channel.ChannelReader", "isV2ChannelApk error: %s", e.getMessage());
            AppMethodBeat.m2505o(2312);
        }
        return z;
    }
}

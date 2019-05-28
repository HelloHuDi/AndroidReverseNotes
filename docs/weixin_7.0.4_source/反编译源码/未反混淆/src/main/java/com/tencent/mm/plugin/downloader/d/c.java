package com.tencent.mm.plugin.downloader.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Map;

public final class c {
    public static String K(File file) {
        String str = null;
        AppMethodBeat.i(2310);
        try {
            ab.i("MicroMsg.Channel.ChannelReader", "get channel by v1");
            byte[] Im = j.Im(file.getAbsolutePath());
            if (Im == null) {
                AppMethodBeat.o(2310);
            } else {
                f fVar = new f();
                fVar.E(Im);
                str = fVar.kMf.getProperty(DownloadInfoColumns.CHANNELID);
                AppMethodBeat.o(2310);
            }
        } catch (Exception e) {
            ab.e("MicroMsg.Channel.ChannelReader", "APK : %s not have channel info from zip comment", file.getAbsolutePath());
            AppMethodBeat.o(2310);
        }
        return str;
    }

    public static String L(File file) {
        byte[] copyOfRange;
        AppMethodBeat.i(2311);
        ab.i("MicroMsg.Channel.ChannelReader", "get channel by v2");
        if (file.exists() && file.isFile()) {
            ByteBuffer byteBuffer;
            if (file.exists() && file.isFile()) {
                Map M = g.M(file);
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
            AppMethodBeat.o(2311);
            return null;
        }
        f fVar = new f();
        fVar.E(copyOfRange);
        String property = fVar.kMf.getProperty(DownloadInfoColumns.CHANNELID);
        AppMethodBeat.o(2311);
        return property;
    }

    public static boolean Il(String str) {
        boolean z = false;
        AppMethodBeat.i(2312);
        try {
            z = b.Ik(str);
            AppMethodBeat.o(2312);
        } catch (Exception e) {
            ab.e("MicroMsg.Channel.ChannelReader", "isV2ChannelApk error: %s", e.getMessage());
            AppMethodBeat.o(2312);
        }
        return z;
    }
}

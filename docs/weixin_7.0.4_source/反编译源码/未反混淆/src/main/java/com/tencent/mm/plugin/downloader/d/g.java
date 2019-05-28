package com.tencent.mm.plugin.downloader.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.d.b.b;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;
import org.xwalk.core.Log;

public final class g {
    public static Map<Integer, ByteBuffer> M(File file) {
        Map<Integer, ByteBuffer> map = null;
        AppMethodBeat.i(2321);
        if (file != null && file.exists() && file.isFile()) {
            try {
                map = i.E(i.P(file));
                AppMethodBeat.o(2321);
            } catch (IOException e) {
                AppMethodBeat.o(2321);
                return map;
            } catch (b e2) {
                Log.e("MicroMsg.Channel.IdValueReader", "APK : " + file.getAbsolutePath() + " not have apk signature block");
                AppMethodBeat.o(2321);
                return map;
            }
        }
        AppMethodBeat.o(2321);
        return map;
    }
}

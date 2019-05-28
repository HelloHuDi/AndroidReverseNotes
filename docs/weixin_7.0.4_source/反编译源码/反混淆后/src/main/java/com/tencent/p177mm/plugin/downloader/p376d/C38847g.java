package com.tencent.p177mm.plugin.downloader.p376d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.downloader.p376d.C20313b.C20314b;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;
import org.xwalk.core.Log;

/* renamed from: com.tencent.mm.plugin.downloader.d.g */
public final class C38847g {
    /* renamed from: M */
    public static Map<Integer, ByteBuffer> m65901M(File file) {
        Map<Integer, ByteBuffer> map = null;
        AppMethodBeat.m2504i(2321);
        if (file != null && file.exists() && file.isFile()) {
            try {
                map = C11507i.m19306E(C11507i.m19308P(file));
                AppMethodBeat.m2505o(2321);
            } catch (IOException e) {
                AppMethodBeat.m2505o(2321);
                return map;
            } catch (C20314b e2) {
                Log.m81046e("MicroMsg.Channel.IdValueReader", "APK : " + file.getAbsolutePath() + " not have apk signature block");
                AppMethodBeat.m2505o(2321);
                return map;
            }
        }
        AppMethodBeat.m2505o(2321);
        return map;
    }
}

package com.tencent.qqmusic.mediaplayer.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public class StreamUtils {
    public static long skipForBufferStream(InputStream inputStream, long j) {
        AppMethodBeat.m2504i(128377);
        if (inputStream == null || j <= 0) {
            AppMethodBeat.m2505o(128377);
            return 0;
        }
        long j2 = j;
        long j3 = 0;
        do {
            j2 -= j3;
            j3 = inputStream.skip(j2);
            if (j3 <= 0) {
                break;
            }
        } while (j3 < j2);
        if (j3 > 0) {
            AppMethodBeat.m2505o(128377);
            return j;
        }
        j -= j2;
        AppMethodBeat.m2505o(128377);
        return j;
    }
}

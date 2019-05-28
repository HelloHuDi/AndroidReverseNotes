package com.github.henryye.nativeiv.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import junit.framework.Assert;

public final class d {
    public static InputStream h(InputStream inputStream) {
        AppMethodBeat.i(115777);
        if (!inputStream.markSupported()) {
            if (inputStream instanceof FileInputStream) {
                inputStream = new b((FileInputStream) inputStream);
            } else {
                inputStream = new BufferedInputStream(inputStream);
            }
        }
        AppMethodBeat.o(115777);
        return inputStream;
    }

    public static void i(InputStream inputStream) {
        AppMethodBeat.i(115778);
        Assert.assertTrue(inputStream.markSupported());
        inputStream.mark(8388608);
        AppMethodBeat.o(115778);
    }
}

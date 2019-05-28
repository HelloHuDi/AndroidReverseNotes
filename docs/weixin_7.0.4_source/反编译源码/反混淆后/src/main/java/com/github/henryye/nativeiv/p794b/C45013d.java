package com.github.henryye.nativeiv.p794b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import junit.framework.Assert;

/* renamed from: com.github.henryye.nativeiv.b.d */
public final class C45013d {
    /* renamed from: h */
    public static InputStream m82444h(InputStream inputStream) {
        AppMethodBeat.m2504i(115777);
        if (!inputStream.markSupported()) {
            if (inputStream instanceof FileInputStream) {
                inputStream = new C25504b((FileInputStream) inputStream);
            } else {
                inputStream = new BufferedInputStream(inputStream);
            }
        }
        AppMethodBeat.m2505o(115777);
        return inputStream;
    }

    /* renamed from: i */
    public static void m82445i(InputStream inputStream) {
        AppMethodBeat.m2504i(115778);
        Assert.assertTrue(inputStream.markSupported());
        inputStream.mark(8388608);
        AppMethodBeat.m2505o(115778);
    }
}

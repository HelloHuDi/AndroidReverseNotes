package org.p1128b.p1132d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.OutputStream;

/* renamed from: org.b.d.a */
public final class C44625a {
    public final String BYE;
    public final String BYF;
    public final String BYG;
    public final C46859h BYI;
    private final OutputStream BYJ;
    public final String scope;

    public C44625a(String str, String str2, String str3, C46859h c46859h, String str4, OutputStream outputStream) {
        this.BYE = str;
        this.BYF = str2;
        this.BYG = str3;
        this.BYI = c46859h;
        this.scope = str4;
        this.BYJ = outputStream;
    }

    public final boolean emX() {
        return this.scope != null;
    }

    public final void log(String str) {
        AppMethodBeat.m2504i(77275);
        if (this.BYJ != null) {
            try {
                this.BYJ.write(new StringBuilder(String.valueOf(str)).append(IOUtils.LINE_SEPARATOR_UNIX).toString().getBytes("UTF8"));
                AppMethodBeat.m2505o(77275);
                return;
            } catch (Exception e) {
                RuntimeException runtimeException = new RuntimeException("there were problems while writting to the debug stream", e);
                AppMethodBeat.m2505o(77275);
                throw runtimeException;
            }
        }
        AppMethodBeat.m2505o(77275);
    }
}

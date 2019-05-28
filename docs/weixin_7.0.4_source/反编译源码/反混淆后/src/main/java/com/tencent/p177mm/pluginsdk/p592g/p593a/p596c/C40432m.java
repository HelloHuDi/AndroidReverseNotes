package com.tencent.p177mm.pluginsdk.p592g.p593a.p596c;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.pluginsdk.g.a.c.m */
public final class C40432m {
    public final long aHW;
    public final String bqF;
    public final String filePath;
    final String groupId;
    public final int httpStatusCode;
    public final int status;
    private final String url;
    public final String vdC;
    public final Exception vfo;

    private C40432m(String str, String str2, String str3, String str4, long j, String str5, int i, Exception exception, int i2) {
        this.groupId = str;
        this.vdC = str2;
        this.url = str3;
        this.filePath = str4;
        this.aHW = j;
        this.bqF = str5;
        this.status = i;
        this.vfo = exception;
        this.httpStatusCode = i2;
    }

    public C40432m(String str, String str2, String str3, String str4, long j, String str5, Exception exception) {
        this(str, str2, str3, str4, j, str5, 3, exception, -1);
    }

    public C40432m(C35792l c35792l, long j) {
        this(c35792l.awa(), c35792l.vdC, c35792l.url, c35792l.getFilePath(), j, null, 2, null, -1);
        AppMethodBeat.m2504i(79587);
        AppMethodBeat.m2505o(79587);
    }

    public C40432m(C4715e c4715e, long j, String str) {
        this(c4715e.awa(), c4715e.dib(), c4715e.getURL(), c4715e.getFilePath(), j, str, 2, null, -1);
        AppMethodBeat.m2504i(79588);
        AppMethodBeat.m2505o(79588);
    }

    public C40432m(C4715e c4715e, Exception exception, int i, int i2) {
        this(c4715e.awa(), c4715e.dib(), c4715e.getURL(), c4715e.getFilePath(), -1, null, i2, exception, i);
        AppMethodBeat.m2504i(79589);
        AppMethodBeat.m2505o(79589);
    }

    public C40432m(C4715e c4715e, Exception exception, int i) {
        this(c4715e, exception, -1, i);
    }

    public final String toString() {
        AppMethodBeat.m2504i(79590);
        String str = "NetworkResponse{urlKey='" + this.vdC + '\'' + ", url='" + this.url + '\'' + ", filePath='" + this.filePath + '\'' + ", contentLength=" + this.aHW + ", contentType='" + this.bqF + '\'' + ", status=" + this.status + ", e=" + this.vfo + '}';
        AppMethodBeat.m2505o(79590);
        return str;
    }
}

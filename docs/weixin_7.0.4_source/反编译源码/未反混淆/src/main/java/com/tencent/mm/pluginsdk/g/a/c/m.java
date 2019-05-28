package com.tencent.mm.pluginsdk.g.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m {
    public final long aHW;
    public final String bqF;
    public final String filePath;
    final String groupId;
    public final int httpStatusCode;
    public final int status;
    private final String url;
    public final String vdC;
    public final Exception vfo;

    private m(String str, String str2, String str3, String str4, long j, String str5, int i, Exception exception, int i2) {
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

    public m(String str, String str2, String str3, String str4, long j, String str5, Exception exception) {
        this(str, str2, str3, str4, j, str5, 3, exception, -1);
    }

    public m(l lVar, long j) {
        this(lVar.awa(), lVar.vdC, lVar.url, lVar.getFilePath(), j, null, 2, null, -1);
        AppMethodBeat.i(79587);
        AppMethodBeat.o(79587);
    }

    public m(e eVar, long j, String str) {
        this(eVar.awa(), eVar.dib(), eVar.getURL(), eVar.getFilePath(), j, str, 2, null, -1);
        AppMethodBeat.i(79588);
        AppMethodBeat.o(79588);
    }

    public m(e eVar, Exception exception, int i, int i2) {
        this(eVar.awa(), eVar.dib(), eVar.getURL(), eVar.getFilePath(), -1, null, i2, exception, i);
        AppMethodBeat.i(79589);
        AppMethodBeat.o(79589);
    }

    public m(e eVar, Exception exception, int i) {
        this(eVar, exception, -1, i);
    }

    public final String toString() {
        AppMethodBeat.i(79590);
        String str = "NetworkResponse{urlKey='" + this.vdC + '\'' + ", url='" + this.url + '\'' + ", filePath='" + this.filePath + '\'' + ", contentLength=" + this.aHW + ", contentType='" + this.bqF + '\'' + ", status=" + this.status + ", e=" + this.vfo + '}';
        AppMethodBeat.o(79590);
        return str;
    }
}

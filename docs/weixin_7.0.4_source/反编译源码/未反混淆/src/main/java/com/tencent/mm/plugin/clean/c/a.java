package com.tencent.mm.plugin.clean.c;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.Calendar;

public final class a {
    public long cuQ;
    public long fXb;
    public String filePath;
    public long size;
    public String thumbPath;
    public int type;
    private String userName;

    public a(String str, String str2, int i, String str3, long j, long j2) {
        AppMethodBeat.i(18663);
        this.size = e.asZ(str2);
        ab.v("MicroMsg.AnalyseItem", "add mst %d %d %s %s %d", Long.valueOf(this.size), Integer.valueOf(i), bo.my(this.size), str3, Long.valueOf(j));
        this.thumbPath = str;
        this.type = i;
        this.filePath = str2;
        this.userName = str3;
        this.cuQ = j;
        this.fXb = j2;
        AppMethodBeat.o(18663);
    }

    public final String toString() {
        AppMethodBeat.i(18664);
        String format;
        switch (this.type) {
            case 1:
                format = String.format("%-8s    %-10s  %s\r\n", new Object[]{"IMG", bo.my(this.size), this.filePath});
                AppMethodBeat.o(18664);
                return format;
            case 2:
                format = String.format("%-8s    %-10s  %s\r\n", new Object[]{"VOICE", bo.my(this.size), this.filePath});
                AppMethodBeat.o(18664);
                return format;
            case 3:
                format = String.format("%-8s    %-10s  %s\r\n", new Object[]{ShareConstants.VIDEO_URL, bo.my(this.size), this.filePath});
                AppMethodBeat.o(18664);
                return format;
            case 4:
                format = String.format("%-8s    %-10s  %s\r\n", new Object[]{"ATTACH", bo.my(this.size), this.filePath});
                AppMethodBeat.o(18664);
                return format;
            default:
                format = "";
                AppMethodBeat.o(18664);
                return format;
        }
    }

    public final long bfH() {
        AppMethodBeat.i(18665);
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(this.fXb);
        long j = (long) (instance.get(2) + (instance.get(1) * 100));
        AppMethodBeat.o(18665);
        return j;
    }
}

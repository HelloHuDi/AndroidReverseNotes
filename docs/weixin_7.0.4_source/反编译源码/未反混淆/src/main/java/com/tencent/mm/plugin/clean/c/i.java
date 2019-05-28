package com.tencent.mm.plugin.clean.c;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.f.b.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public final class i {
    public long cuQ;
    public long fXb;
    public String filePath;
    public List<a> kwH = new ArrayList();
    public long size;
    public String thumbPath;
    public int type;
    public String userName;

    public i() {
        AppMethodBeat.i(18715);
        AppMethodBeat.o(18715);
    }

    public final String toString() {
        AppMethodBeat.i(18716);
        String format;
        switch (this.type) {
            case 1:
                format = String.format("%-8s    %-10s  %s\r\n", new Object[]{"IMG", bo.my(this.size), this.filePath});
                AppMethodBeat.o(18716);
                return format;
            case 2:
                format = String.format("%-8s    %-10s  %s\r\n", new Object[]{"VOICE", bo.my(this.size), this.filePath});
                AppMethodBeat.o(18716);
                return format;
            case 3:
                format = String.format("%-8s    %-10s  %s\r\n", new Object[]{ShareConstants.VIDEO_URL, bo.my(this.size), this.filePath});
                AppMethodBeat.o(18716);
                return format;
            case 4:
                format = String.format("%-8s    %-10s  %s\r\n", new Object[]{"ATTACH", bo.my(this.size), this.filePath});
                AppMethodBeat.o(18716);
                return format;
            default:
                format = "";
                AppMethodBeat.o(18716);
                return format;
        }
    }

    public final long bfH() {
        AppMethodBeat.i(18717);
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(this.fXb);
        long j = (long) (instance.get(2) + (instance.get(1) * 100));
        AppMethodBeat.o(18717);
        return j;
    }
}

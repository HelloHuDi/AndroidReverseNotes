package com.tencent.p177mm.plugin.clean.p362c;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.p398f.p1482b.C34092a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.clean.c.i */
public final class C2808i {
    public long cuQ;
    public long fXb;
    public String filePath;
    public List<C34092a> kwH = new ArrayList();
    public long size;
    public String thumbPath;
    public int type;
    public String userName;

    public C2808i() {
        AppMethodBeat.m2504i(18715);
        AppMethodBeat.m2505o(18715);
    }

    public final String toString() {
        AppMethodBeat.m2504i(18716);
        String format;
        switch (this.type) {
            case 1:
                format = String.format("%-8s    %-10s  %s\r\n", new Object[]{"IMG", C5046bo.m7580my(this.size), this.filePath});
                AppMethodBeat.m2505o(18716);
                return format;
            case 2:
                format = String.format("%-8s    %-10s  %s\r\n", new Object[]{"VOICE", C5046bo.m7580my(this.size), this.filePath});
                AppMethodBeat.m2505o(18716);
                return format;
            case 3:
                format = String.format("%-8s    %-10s  %s\r\n", new Object[]{ShareConstants.VIDEO_URL, C5046bo.m7580my(this.size), this.filePath});
                AppMethodBeat.m2505o(18716);
                return format;
            case 4:
                format = String.format("%-8s    %-10s  %s\r\n", new Object[]{"ATTACH", C5046bo.m7580my(this.size), this.filePath});
                AppMethodBeat.m2505o(18716);
                return format;
            default:
                format = "";
                AppMethodBeat.m2505o(18716);
                return format;
        }
    }

    public final long bfH() {
        AppMethodBeat.m2504i(18717);
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(this.fXb);
        long j = (long) (instance.get(2) + (instance.get(1) * 100));
        AppMethodBeat.m2505o(18717);
        return j;
    }
}

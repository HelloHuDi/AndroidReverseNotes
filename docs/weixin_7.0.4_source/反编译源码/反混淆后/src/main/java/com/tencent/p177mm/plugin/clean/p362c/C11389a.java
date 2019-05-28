package com.tencent.p177mm.plugin.clean.p362c;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import java.util.Calendar;

/* renamed from: com.tencent.mm.plugin.clean.c.a */
public final class C11389a {
    public long cuQ;
    public long fXb;
    public String filePath;
    public long size;
    public String thumbPath;
    public int type;
    private String userName;

    public C11389a(String str, String str2, int i, String str3, long j, long j2) {
        AppMethodBeat.m2504i(18663);
        this.size = C5730e.asZ(str2);
        C4990ab.m7419v("MicroMsg.AnalyseItem", "add mst %d %d %s %s %d", Long.valueOf(this.size), Integer.valueOf(i), C5046bo.m7580my(this.size), str3, Long.valueOf(j));
        this.thumbPath = str;
        this.type = i;
        this.filePath = str2;
        this.userName = str3;
        this.cuQ = j;
        this.fXb = j2;
        AppMethodBeat.m2505o(18663);
    }

    public final String toString() {
        AppMethodBeat.m2504i(18664);
        String format;
        switch (this.type) {
            case 1:
                format = String.format("%-8s    %-10s  %s\r\n", new Object[]{"IMG", C5046bo.m7580my(this.size), this.filePath});
                AppMethodBeat.m2505o(18664);
                return format;
            case 2:
                format = String.format("%-8s    %-10s  %s\r\n", new Object[]{"VOICE", C5046bo.m7580my(this.size), this.filePath});
                AppMethodBeat.m2505o(18664);
                return format;
            case 3:
                format = String.format("%-8s    %-10s  %s\r\n", new Object[]{ShareConstants.VIDEO_URL, C5046bo.m7580my(this.size), this.filePath});
                AppMethodBeat.m2505o(18664);
                return format;
            case 4:
                format = String.format("%-8s    %-10s  %s\r\n", new Object[]{"ATTACH", C5046bo.m7580my(this.size), this.filePath});
                AppMethodBeat.m2505o(18664);
                return format;
            default:
                format = "";
                AppMethodBeat.m2505o(18664);
                return format;
        }
    }

    public final long bfH() {
        AppMethodBeat.m2504i(18665);
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(this.fXb);
        long j = (long) (instance.get(2) + (instance.get(1) * 100));
        AppMethodBeat.m2505o(18665);
        return j;
    }
}

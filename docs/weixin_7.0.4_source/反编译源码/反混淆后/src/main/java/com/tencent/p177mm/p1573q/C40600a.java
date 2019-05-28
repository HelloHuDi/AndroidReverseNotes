package com.tencent.p177mm.p1573q;

import android.content.Context;
import android.os.StatFs;
import android.preference.PreferenceManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;

/* renamed from: com.tencent.mm.q.a */
public final class C40600a {
    public static int ewU = -1;
    public static final long[] ewV = new long[]{17179869184L, 34359738368L, 68719476736L, 137438953472L, 274877906944L};
    public static final long[] ewW = new long[]{DownloadHelper.SAVE_LENGTH, 314572800, 524288000, 1073741824, 1073741824};

    /* renamed from: On */
    public static int m70011On() {
        long blockCount;
        int i;
        AppMethodBeat.m2504i(77693);
        long j = 0;
        long j2 = 0;
        double d = 0.0d;
        try {
            StatFs statFs = new StatFs(C1448h.getDataDirectory().getPath());
            j = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
            blockCount = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
            j2 = ((long) statFs.getFreeBlocks()) * ((long) statFs.getBlockSize());
            d = ((double) j) / ((double) blockCount);
        } catch (Exception e) {
            blockCount = 0;
            C4990ab.m7412e("MicroMsg.DbChecker", "get db spare space error");
        }
        if (blockCount > 0) {
            if (j < 52428800) {
                i = 2;
            } else {
                if (ewU < 0) {
                    ewU = ewV.length - 1;
                    for (i = 0; i < ewV.length; i++) {
                        if (blockCount < ewV[i]) {
                            ewU = i;
                            break;
                        }
                    }
                }
                if (j < ewW[ewU]) {
                    i = 1;
                }
            }
            C4990ab.m7417i("MicroMsg.DbChecker", "checkRomSparespace[%d] available:%d all:%d freeSize :%d availPercent %f mobileSizeIndex %d", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(blockCount), Long.valueOf(j2), Double.valueOf(d), Integer.valueOf(ewU));
            AppMethodBeat.m2505o(77693);
            return i;
        }
        i = 0;
        C4990ab.m7417i("MicroMsg.DbChecker", "checkRomSparespace[%d] available:%d all:%d freeSize :%d availPercent %f mobileSizeIndex %d", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(blockCount), Long.valueOf(j2), Double.valueOf(d), Integer.valueOf(ewU));
        AppMethodBeat.m2505o(77693);
        return i;
    }

    /* renamed from: b */
    public static void m70012b(Context context, long j) {
        AppMethodBeat.m2504i(77694);
        PreferenceManager.getDefaultSharedPreferences(context).edit().putLong("db_check_tip_time", j).commit();
        AppMethodBeat.m2505o(77694);
    }
}

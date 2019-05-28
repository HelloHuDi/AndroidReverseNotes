package com.tencent.p177mm.plugin.appbrand.media.record;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.media.record.d */
public final class C42630d {
    public static final Long clp = Long.valueOf(259200000);
    public static final Long clr = Long.valueOf(86400000);
    public static final Long cls = Long.valueOf(43200000);
    public static final Long clt = Long.valueOf(240000);
    private static List<String> clw = new ArrayList(10);
    public static long clx = 0;
    public static final Long ilk = Long.valueOf(60000);
    public static final Long ill = clr;

    /* renamed from: com.tencent.mm.plugin.appbrand.media.record.d$1 */
    static class C426311 implements Runnable {
        C426311() {
        }

        public final void run() {
            AppMethodBeat.m2504i(105596);
            C42630d.access$000();
            AppMethodBeat.m2505o(105596);
        }
    }

    static {
        AppMethodBeat.m2504i(105600);
        AppMethodBeat.m2505o(105600);
    }

    /* renamed from: dA */
    private static boolean m75496dA(String str) {
        AppMethodBeat.m2504i(105598);
        for (String contains : clw) {
            if (str.contains(contains)) {
                AppMethodBeat.m2505o(105598);
                return true;
            }
        }
        AppMethodBeat.m2505o(105598);
        return false;
    }

    public static void aIg() {
        AppMethodBeat.m2504i(105597);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - clx <= ill.longValue()) {
            C4990ab.m7412e("MicroMsg.Record.AudioRecordCacheClean", "The last clean time is in AUDIO_RECORD_NO_SCAN_TIME time");
            AppMethodBeat.m2505o(105597);
            return;
        }
        C4990ab.m7416i("MicroMsg.Record.AudioRecordCacheClean", "start clean audio record file");
        clx = currentTimeMillis;
        C7305d.post(new C426311(), "AudioRecordCacheClean");
        AppMethodBeat.m2505o(105597);
    }

    static /* synthetic */ void access$000() {
        AppMethodBeat.m2504i(105599);
        C4990ab.m7416i("MicroMsg.Record.AudioRecordCacheClean", "clean audio record file");
        File file = new File(C27202h.ilL, "AudioRecord");
        if (file.exists() && file.isDirectory()) {
            String[] list = file.list();
            if (list == null || list.length == 0) {
                C4990ab.m7416i("MicroMsg.Record.AudioRecordCacheClean", "none files exist");
                AppMethodBeat.m2505o(105599);
                return;
            }
            for (String str : list) {
                if (C42630d.m75496dA(str)) {
                    C4990ab.m7416i("MicroMsg.Record.AudioRecordCacheClean", "file is the block file, don't delete");
                } else {
                    File file2 = new File(file + File.separator + str);
                    if (!file2.exists()) {
                        C4990ab.m7416i("MicroMsg.Record.AudioRecordCacheClean", "file not exist");
                    } else if (file2.isDirectory()) {
                        C4990ab.m7416i("MicroMsg.Record.AudioRecordCacheClean", "file is directory, don't delete");
                    } else if (System.currentTimeMillis() - file2.lastModified() > clp.longValue()) {
                        C4990ab.m7413e("MicroMsg.Record.AudioRecordCacheClean", "Clean 3 days file in record file name=%s, path:%s", file2.getName(), file2.getAbsolutePath());
                        file2.delete();
                    } else {
                        C4990ab.m7416i("MicroMsg.Record.AudioRecordCacheClean", "not delete the file, file is in valid time for 3 day");
                    }
                }
            }
            AppMethodBeat.m2505o(105599);
            return;
        }
        C4990ab.m7416i("MicroMsg.Record.AudioRecordCacheClean", "AudioRecord is not exist or not Directory");
        AppMethodBeat.m2505o(105599);
    }
}

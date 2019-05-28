package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class d {
    public static final Long clp = Long.valueOf(259200000);
    public static final Long clr = Long.valueOf(86400000);
    public static final Long cls = Long.valueOf(43200000);
    public static final Long clt = Long.valueOf(240000);
    private static List<String> clw = new ArrayList(10);
    public static long clx = 0;
    public static final Long ilk = Long.valueOf(60000);
    public static final Long ill = clr;

    static {
        AppMethodBeat.i(105600);
        AppMethodBeat.o(105600);
    }

    private static boolean dA(String str) {
        AppMethodBeat.i(105598);
        for (String contains : clw) {
            if (str.contains(contains)) {
                AppMethodBeat.o(105598);
                return true;
            }
        }
        AppMethodBeat.o(105598);
        return false;
    }

    public static void aIg() {
        AppMethodBeat.i(105597);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - clx <= ill.longValue()) {
            ab.e("MicroMsg.Record.AudioRecordCacheClean", "The last clean time is in AUDIO_RECORD_NO_SCAN_TIME time");
            AppMethodBeat.o(105597);
            return;
        }
        ab.i("MicroMsg.Record.AudioRecordCacheClean", "start clean audio record file");
        clx = currentTimeMillis;
        com.tencent.mm.sdk.g.d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(105596);
                d.access$000();
                AppMethodBeat.o(105596);
            }
        }, "AudioRecordCacheClean");
        AppMethodBeat.o(105597);
    }

    static /* synthetic */ void access$000() {
        AppMethodBeat.i(105599);
        ab.i("MicroMsg.Record.AudioRecordCacheClean", "clean audio record file");
        File file = new File(h.ilL, "AudioRecord");
        if (file.exists() && file.isDirectory()) {
            String[] list = file.list();
            if (list == null || list.length == 0) {
                ab.i("MicroMsg.Record.AudioRecordCacheClean", "none files exist");
                AppMethodBeat.o(105599);
                return;
            }
            for (String str : list) {
                if (dA(str)) {
                    ab.i("MicroMsg.Record.AudioRecordCacheClean", "file is the block file, don't delete");
                } else {
                    File file2 = new File(file + File.separator + str);
                    if (!file2.exists()) {
                        ab.i("MicroMsg.Record.AudioRecordCacheClean", "file not exist");
                    } else if (file2.isDirectory()) {
                        ab.i("MicroMsg.Record.AudioRecordCacheClean", "file is directory, don't delete");
                    } else if (System.currentTimeMillis() - file2.lastModified() > clp.longValue()) {
                        ab.e("MicroMsg.Record.AudioRecordCacheClean", "Clean 3 days file in record file name=%s, path:%s", file2.getName(), file2.getAbsolutePath());
                        file2.delete();
                    } else {
                        ab.i("MicroMsg.Record.AudioRecordCacheClean", "not delete the file, file is in valid time for 3 day");
                    }
                }
            }
            AppMethodBeat.o(105599);
            return;
        }
        ab.i("MicroMsg.Record.AudioRecordCacheClean", "AudioRecord is not exist or not Directory");
        AppMethodBeat.o(105599);
    }
}

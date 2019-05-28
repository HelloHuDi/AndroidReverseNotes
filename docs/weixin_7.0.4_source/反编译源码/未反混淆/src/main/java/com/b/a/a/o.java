package com.b.a.a;

import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

final class o {
    private static final SimpleDateFormat bFA = new SimpleDateFormat("yyyMMddHHmmss", Locale.US);
    private static String bFy;
    private static final SimpleDateFormat bFz = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss", Locale.US);

    protected static boolean s(String str, String str2) {
        String str3 = null;
        AppMethodBeat.i(55575);
        if (bFy == null) {
            boolean z;
            if (Environment.getExternalStorageState().equals("mounted")) {
                File file = new File(Environment.getExternalStorageDirectory() + "/" + y.bIO);
                boolean exists = file.exists();
                if (!exists) {
                    exists = file.mkdir();
                }
                if (exists) {
                    str3 = file.toString();
                }
                bFy = str3;
                z = exists;
            } else {
                bFy = null;
                z = false;
            }
            if (!z) {
                AppMethodBeat.o(55575);
                return false;
            }
        }
        try {
            FileWriter fileWriter = new FileWriter(bFy + "/" + str + ".txt", true);
            fileWriter.write(new StringBuilder(IOUtils.LINE_SEPARATOR_UNIX).append(bFz.format(new Date())).append(',').append(str2).toString());
            fileWriter.flush();
            fileWriter.close();
            AppMethodBeat.o(55575);
            return true;
        } catch (Exception e) {
            AppMethodBeat.o(55575);
            return false;
        }
    }

    static {
        AppMethodBeat.i(55574);
        AppMethodBeat.o(55574);
    }

    protected static String wf() {
        AppMethodBeat.i(55576);
        String format = bFA.format(new Date());
        AppMethodBeat.o(55576);
        return format;
    }
}

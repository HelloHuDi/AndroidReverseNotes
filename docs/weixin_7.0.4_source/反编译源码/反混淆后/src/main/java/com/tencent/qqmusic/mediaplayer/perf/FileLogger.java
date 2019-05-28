package com.tencent.qqmusic.mediaplayer.perf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger {
    private static final String TAG = "FileLogger";

    /* JADX WARNING: Removed duplicated region for block: B:23:0x003f A:{SYNTHETIC, Splitter:B:23:0x003f} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002f A:{SYNTHETIC, Splitter:B:15:0x002f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void write(StringBuilder stringBuilder, File file, boolean z) {
        Throwable e;
        AppMethodBeat.m2504i(128419);
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file, z);
            try {
                fileWriter.write(stringBuilder.toString());
                fileWriter.flush();
                try {
                    fileWriter.close();
                    AppMethodBeat.m2505o(128419);
                } catch (IOException e2) {
                    AppMethodBeat.m2505o(128419);
                }
            } catch (IOException e3) {
                e = e3;
                try {
                    Logger.m71022e(TAG, "[write] failed!", e);
                    if (fileWriter == null) {
                    }
                } catch (Throwable th) {
                    e = th;
                    if (fileWriter != null) {
                    }
                    AppMethodBeat.m2505o(128419);
                    throw e;
                }
            }
        } catch (IOException e4) {
            e = e4;
            fileWriter = null;
            Logger.m71022e(TAG, "[write] failed!", e);
            if (fileWriter == null) {
                try {
                    fileWriter.close();
                    AppMethodBeat.m2505o(128419);
                    return;
                } catch (IOException e5) {
                    AppMethodBeat.m2505o(128419);
                    return;
                }
            }
            AppMethodBeat.m2505o(128419);
        } catch (Throwable th2) {
            e = th2;
            fileWriter = null;
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e6) {
                }
            }
            AppMethodBeat.m2505o(128419);
            throw e;
        }
    }
}

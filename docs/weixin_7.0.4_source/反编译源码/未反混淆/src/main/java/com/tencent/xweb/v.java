package com.tencent.xweb;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class v {
    private static final Object ANg = new Object();

    static {
        AppMethodBeat.i(3956);
        AppMethodBeat.o(3956);
    }

    public static void ab(String[] strArr) {
        AppMethodBeat.i(3955);
        if (strArr == null || strArr.length == 0) {
            AppMethodBeat.o(3955);
            return;
        }
        synchronized (ANg) {
            try {
                SharedPreferences sharedPreferencesForFileReaderRecord = XWalkEnvironment.getSharedPreferencesForFileReaderRecord();
                if (sharedPreferencesForFileReaderRecord == null) {
                    Log.e("FileReaderCrashDetect", "resetCrashInfo sp is null");
                }
                Editor edit = sharedPreferencesForFileReaderRecord.edit();
                if (edit == null) {
                    Log.e("FileReaderCrashDetect", "resetCrashInfo editor is null");
                } else {
                    for (String str : strArr) {
                        edit.remove(str + "_count");
                        edit.remove(str + "_time");
                        edit.commit();
                    }
                    AppMethodBeat.o(3955);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(3955);
            }
        }
    }
}

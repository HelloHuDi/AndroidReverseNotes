package com.tencent.xweb;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.xweb.v */
public final class C31149v {
    private static final Object ANg = new Object();

    static {
        AppMethodBeat.m2504i(3956);
        AppMethodBeat.m2505o(3956);
    }

    /* renamed from: ab */
    public static void m50238ab(String[] strArr) {
        AppMethodBeat.m2504i(3955);
        if (strArr == null || strArr.length == 0) {
            AppMethodBeat.m2505o(3955);
            return;
        }
        synchronized (ANg) {
            try {
                SharedPreferences sharedPreferencesForFileReaderRecord = XWalkEnvironment.getSharedPreferencesForFileReaderRecord();
                if (sharedPreferencesForFileReaderRecord == null) {
                    Log.m81046e("FileReaderCrashDetect", "resetCrashInfo sp is null");
                }
                Editor edit = sharedPreferencesForFileReaderRecord.edit();
                if (edit == null) {
                    Log.m81046e("FileReaderCrashDetect", "resetCrashInfo editor is null");
                } else {
                    for (String str : strArr) {
                        edit.remove(str + "_count");
                        edit.remove(str + "_time");
                        edit.commit();
                    }
                    AppMethodBeat.m2505o(3955);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(3955);
            }
        }
    }
}

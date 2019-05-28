package com.tencent.wcdb.support;

import android.util.Printer;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class LogPrinter implements Printer {
    private final int mPriority;
    private final String mTag;

    public LogPrinter(int i, String str) {
        this.mPriority = i;
        this.mTag = str;
    }

    public void println(String str) {
        AppMethodBeat.i(12724);
        Log.println(this.mPriority, this.mTag, str);
        AppMethodBeat.o(12724);
    }
}

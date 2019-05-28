package com.tencent.wcdb.support;

import android.util.Printer;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PrefixPrinter implements Printer {
    private final String mPrefix;
    private final Printer mPrinter;

    public static Printer create(Printer printer, String str) {
        AppMethodBeat.i(12736);
        if (str == null || str.equals("")) {
            AppMethodBeat.o(12736);
            return printer;
        }
        PrefixPrinter prefixPrinter = new PrefixPrinter(printer, str);
        AppMethodBeat.o(12736);
        return prefixPrinter;
    }

    private PrefixPrinter(Printer printer, String str) {
        this.mPrinter = printer;
        this.mPrefix = str;
    }

    public void println(String str) {
        AppMethodBeat.i(12737);
        this.mPrinter.println(this.mPrefix + str);
        AppMethodBeat.o(12737);
    }
}

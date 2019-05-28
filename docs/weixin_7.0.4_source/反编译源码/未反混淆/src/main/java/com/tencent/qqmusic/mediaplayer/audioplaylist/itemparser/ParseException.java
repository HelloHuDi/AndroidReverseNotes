package com.tencent.qqmusic.mediaplayer.audioplaylist.itemparser;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ParseException extends Exception {
    public int curline = 0;

    public ParseException(String str, Exception exception, int i) {
        super(str, exception);
        this.curline = i;
    }

    public String getMessage() {
        AppMethodBeat.i(104769);
        String str = super.getMessage() + " line: " + this.curline;
        AppMethodBeat.o(104769);
        return str;
    }

    public String toString() {
        AppMethodBeat.i(104770);
        String str = "ParseException{message = " + getMessage() + "}";
        AppMethodBeat.o(104770);
        return str;
    }
}

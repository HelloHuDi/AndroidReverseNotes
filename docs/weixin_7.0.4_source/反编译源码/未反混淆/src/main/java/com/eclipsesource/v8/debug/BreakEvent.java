package com.eclipsesource.v8.debug;

import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BreakEvent extends EventData {
    private static final String SOURCE_COLUMN = "sourceColumn";
    private static final String SOURCE_LINE = "sourceLine";
    private static final String SOURCE_LINE_TEXT = "sourceLineText";

    BreakEvent(V8Object v8Object) {
        super(v8Object);
    }

    public int getSourceLine() {
        AppMethodBeat.i(74822);
        int executeIntegerFunction = this.v8Object.executeIntegerFunction(SOURCE_LINE, null);
        AppMethodBeat.o(74822);
        return executeIntegerFunction;
    }

    public int getSourceColumn() {
        AppMethodBeat.i(74823);
        int executeIntegerFunction = this.v8Object.executeIntegerFunction(SOURCE_COLUMN, null);
        AppMethodBeat.o(74823);
        return executeIntegerFunction;
    }

    public String getSourceLineText() {
        AppMethodBeat.i(74824);
        String executeStringFunction = this.v8Object.executeStringFunction(SOURCE_LINE_TEXT, null);
        AppMethodBeat.o(74824);
        return executeStringFunction;
    }
}

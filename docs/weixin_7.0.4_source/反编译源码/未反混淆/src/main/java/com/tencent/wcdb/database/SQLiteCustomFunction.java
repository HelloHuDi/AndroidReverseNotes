package com.tencent.wcdb.database;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.database.SQLiteDatabase.CustomFunction;

public final class SQLiteCustomFunction {
    public final CustomFunction callback;
    public final String name;
    public final int numArgs;

    public SQLiteCustomFunction(String str, int i, CustomFunction customFunction) {
        AppMethodBeat.i(12420);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("name must not be null.");
            AppMethodBeat.o(12420);
            throw illegalArgumentException;
        }
        this.name = str;
        this.numArgs = i;
        this.callback = customFunction;
        AppMethodBeat.o(12420);
    }

    private void dispatchCallback(String[] strArr) {
        AppMethodBeat.i(12421);
        this.callback.callback(strArr);
        AppMethodBeat.o(12421);
    }
}

package com.tencent.ttpic.json;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.StringWriter;

public class JSONStringer extends JSONWriter {
    public JSONStringer() {
        super(new StringWriter());
        AppMethodBeat.i(50181);
        AppMethodBeat.o(50181);
    }

    public String toString() {
        AppMethodBeat.i(50182);
        if (this.mode == 'd') {
            String obj = this.writer.toString();
            AppMethodBeat.o(50182);
            return obj;
        }
        AppMethodBeat.o(50182);
        return null;
    }
}

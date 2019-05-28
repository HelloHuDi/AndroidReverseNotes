package com.tencent.ttpic.json;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.StringWriter;

public class JSONStringer extends JSONWriter {
    public JSONStringer() {
        super(new StringWriter());
        AppMethodBeat.m2504i(50181);
        AppMethodBeat.m2505o(50181);
    }

    public String toString() {
        AppMethodBeat.m2504i(50182);
        if (this.mode == 'd') {
            String obj = this.writer.toString();
            AppMethodBeat.m2505o(50182);
            return obj;
        }
        AppMethodBeat.m2505o(50182);
        return null;
    }
}

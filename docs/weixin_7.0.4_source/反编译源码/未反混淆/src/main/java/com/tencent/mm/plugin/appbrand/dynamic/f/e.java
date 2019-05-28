package com.tencent.mm.plugin.appbrand.dynamic.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.z.b.c;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import org.json.JSONObject;

public final class e extends c {
    public e() {
        super("onTap");
    }

    public e(byte b) {
        super("onTap", ErrorCode.THROWABLE_INITX5CORE);
    }

    public final JSONObject toJSONObject() {
        AppMethodBeat.i(10914);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("todo implementation");
        AppMethodBeat.o(10914);
        throw unsupportedOperationException;
    }
}

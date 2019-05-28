package com.tencent.mm.plugin.wear.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.protobuf.cuk;
import java.io.IOException;

public final class k extends c {
    private String bzH;
    private int code;

    public k(int i, String str) {
        this.code = i;
        this.bzH = str;
    }

    /* Access modifiers changed, original: protected|final */
    public final void send() {
        AppMethodBeat.i(26451);
        cuk cuk = new cuk();
        switch (this.code) {
            case 0:
                cuk.xcZ = 0;
                break;
            case 6:
                cuk.xcZ = 196610;
                break;
            case 7:
                cuk.xcZ = 196615;
                break;
            case 8:
                cuk.xcZ = 196614;
                break;
            case 9:
                cuk.xcZ = 196613;
                break;
        }
        cuk.xpw = this.bzH;
        try {
            a.cUn();
            r.b(20016, cuk.toByteArray(), true);
            AppMethodBeat.o(26451);
        } catch (IOException e) {
            AppMethodBeat.o(26451);
        }
    }

    public final String getName() {
        return "WearPushPayResponseTask";
    }
}

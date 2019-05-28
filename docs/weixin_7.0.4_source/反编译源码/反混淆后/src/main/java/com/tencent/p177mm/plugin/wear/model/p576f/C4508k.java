package com.tencent.p177mm.plugin.wear.model.p576f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wear.model.C43841a;
import com.tencent.p177mm.plugin.wear.model.p575e.C40185r;
import com.tencent.p177mm.protocal.protobuf.cuk;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.wear.model.f.k */
public final class C4508k extends C29724c {
    private String bzH;
    private int code;

    public C4508k(int i, String str) {
        this.code = i;
        this.bzH = str;
    }

    /* Access modifiers changed, original: protected|final */
    public final void send() {
        AppMethodBeat.m2504i(26451);
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
            C43841a.cUn();
            C40185r.m68920b(20016, cuk.toByteArray(), true);
            AppMethodBeat.m2505o(26451);
        } catch (IOException e) {
            AppMethodBeat.m2505o(26451);
        }
    }

    public final String getName() {
        return "WearPushPayResponseTask";
    }
}

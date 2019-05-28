package com.tencent.mm.platformtools;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.ab;

public final class l extends d {
    public l(Activity activity) {
        super(activity);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(124540);
        ab.i("MicroMsg.ErrorConfirmProcessor", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        AppMethodBeat.o(124540);
    }

    public final boolean b(ag agVar) {
        AppMethodBeat.i(124541);
        ab.d("MicroMsg.ErrorConfirmProcessor", "handleOpenUrl");
        Toast.makeText(this.activity, agVar.content, 0).show();
        AppMethodBeat.o(124541);
        return true;
    }

    public final boolean c(ag agVar) {
        AppMethodBeat.i(124542);
        ab.d("MicroMsg.ErrorConfirmProcessor", "handleIgnore");
        Toast.makeText(this.activity, agVar.content, 0).show();
        AppMethodBeat.o(124542);
        return true;
    }

    public final boolean d(ag agVar) {
        AppMethodBeat.i(124543);
        ab.d("MicroMsg.ErrorConfirmProcessor", "handleFalseLast");
        Toast.makeText(this.activity, agVar.content, 0).show();
        AppMethodBeat.o(124543);
        return true;
    }

    public final boolean e(ag agVar) {
        AppMethodBeat.i(124544);
        ab.d("MicroMsg.ErrorConfirmProcessor", "handleFalseCancel");
        Toast.makeText(this.activity, agVar.content, 0).show();
        AppMethodBeat.o(124544);
        return true;
    }
}

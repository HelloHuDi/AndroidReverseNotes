package com.tencent.mm.platformtools;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.ab;

public final class p extends d {
    public p(Activity activity) {
        super(activity);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(124560);
        ab.i("MicroMsg.ErrorYesNoProcessor", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        AppMethodBeat.o(124560);
    }

    public final boolean b(ag agVar) {
        AppMethodBeat.i(124561);
        ab.d("MicroMsg.ErrorYesNoProcessor", "handleOpenUrl");
        Toast.makeText(this.activity, agVar.content, 0).show();
        AppMethodBeat.o(124561);
        return true;
    }

    public final boolean c(ag agVar) {
        AppMethodBeat.i(124562);
        ab.d("MicroMsg.ErrorYesNoProcessor", "handleIgnore");
        Toast.makeText(this.activity, agVar.content, 0).show();
        AppMethodBeat.o(124562);
        return true;
    }

    public final boolean d(ag agVar) {
        AppMethodBeat.i(124563);
        ab.d("MicroMsg.ErrorYesNoProcessor", "handleFalseLast");
        Toast.makeText(this.activity, agVar.content, 0).show();
        AppMethodBeat.o(124563);
        return true;
    }

    public final boolean e(ag agVar) {
        AppMethodBeat.i(124564);
        ab.d("MicroMsg.ErrorYesNoProcessor", "handleFalseCancel");
        Toast.makeText(this.activity, agVar.content, 0).show();
        AppMethodBeat.o(124564);
        return true;
    }
}

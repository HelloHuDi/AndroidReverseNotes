package com.tencent.mm.platformtools;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class m extends d {
    public m(Activity activity) {
        super(activity);
    }

    public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(124545);
        ab.i("MicroMsg.ErrorLabelProcessor", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        AppMethodBeat.o(124545);
    }

    public final boolean b(ag agVar) {
        AppMethodBeat.i(124546);
        ab.d("MicroMsg.ErrorLabelProcessor", "handleOpenUrl");
        Toast.makeText(this.activity, agVar.content, 0).show();
        AppMethodBeat.o(124546);
        return true;
    }

    public final boolean c(ag agVar) {
        AppMethodBeat.i(124547);
        ab.d("MicroMsg.ErrorLabelProcessor", "handleIgnore");
        Toast.makeText(this.activity, agVar.content, 0).show();
        AppMethodBeat.o(124547);
        return true;
    }

    public final boolean d(ag agVar) {
        AppMethodBeat.i(124548);
        ab.d("MicroMsg.ErrorLabelProcessor", "handleFalseLast");
        Toast.makeText(this.activity, agVar.content, 0).show();
        AppMethodBeat.o(124548);
        return true;
    }

    public final boolean e(ag agVar) {
        AppMethodBeat.i(124549);
        ab.d("MicroMsg.ErrorLabelProcessor", "handleFalseCancel");
        Toast.makeText(this.activity, agVar.content, 0).show();
        AppMethodBeat.o(124549);
        return true;
    }
}

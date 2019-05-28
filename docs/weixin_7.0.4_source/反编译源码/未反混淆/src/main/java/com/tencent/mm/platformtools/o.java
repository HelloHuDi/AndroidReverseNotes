package com.tencent.mm.platformtools;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.ab;

public final class o extends d {
    public o(Activity activity) {
        super(activity);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(124555);
        ab.i("MicroMsg.ErrorTextStripleProcessor", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        AppMethodBeat.o(124555);
    }

    public final boolean b(ag agVar) {
        AppMethodBeat.i(124556);
        ab.d("MicroMsg.ErrorTextStripleProcessor", "handleOpenUrl");
        Toast.makeText(this.activity, agVar.content, 0).show();
        AppMethodBeat.o(124556);
        return true;
    }

    public final boolean c(ag agVar) {
        AppMethodBeat.i(124557);
        ab.d("MicroMsg.ErrorTextStripleProcessor", "handleIgnore");
        Toast.makeText(this.activity, agVar.content, 0).show();
        AppMethodBeat.o(124557);
        return true;
    }

    public final boolean d(ag agVar) {
        AppMethodBeat.i(124558);
        ab.d("MicroMsg.ErrorTextStripleProcessor", "handleFalseLast");
        Toast.makeText(this.activity, agVar.content, 0).show();
        AppMethodBeat.o(124558);
        return true;
    }

    public final boolean e(ag agVar) {
        AppMethodBeat.i(124559);
        ab.d("MicroMsg.ErrorTextStripleProcessor", "handleFalseCancel");
        Toast.makeText(this.activity, agVar.content, 0).show();
        AppMethodBeat.o(124559);
        return true;
    }
}

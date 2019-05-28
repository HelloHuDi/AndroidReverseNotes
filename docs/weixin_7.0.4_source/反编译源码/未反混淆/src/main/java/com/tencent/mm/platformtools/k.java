package com.tencent.mm.platformtools;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.ab;

public final class k extends d {
    public k(Activity activity) {
        super(activity);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(124535);
        ab.i("MicroMsg.ErrorClientProcessor", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        AppMethodBeat.o(124535);
    }

    public final boolean b(ag agVar) {
        AppMethodBeat.i(124536);
        ab.d("MicroMsg.ErrorClientProcessor", "handleOpenUrl");
        Toast.makeText(this.activity, agVar.content, 0).show();
        AppMethodBeat.o(124536);
        return true;
    }

    public final boolean c(ag agVar) {
        AppMethodBeat.i(124537);
        ab.d("MicroMsg.ErrorClientProcessor", "handleIgnore");
        Toast.makeText(this.activity, agVar.content, 0).show();
        AppMethodBeat.o(124537);
        return true;
    }

    public final boolean d(ag agVar) {
        AppMethodBeat.i(124538);
        ab.d("MicroMsg.ErrorClientProcessor", "handleFalseLast");
        Toast.makeText(this.activity, agVar.content, 0).show();
        AppMethodBeat.o(124538);
        return true;
    }

    public final boolean e(ag agVar) {
        AppMethodBeat.i(124539);
        ab.d("MicroMsg.ErrorClientProcessor", "handleFalseCancel");
        Toast.makeText(this.activity, agVar.content, 0).show();
        AppMethodBeat.o(124539);
        return true;
    }
}

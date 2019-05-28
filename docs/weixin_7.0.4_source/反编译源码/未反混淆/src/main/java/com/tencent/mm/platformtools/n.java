package com.tencent.mm.platformtools;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.ab;

public final class n extends d {
    public n(Activity activity) {
        super(activity);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(124550);
        ab.i("MicroMsg.ErrorMsgBoxProcessor", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        AppMethodBeat.o(124550);
    }

    public final boolean b(ag agVar) {
        AppMethodBeat.i(124551);
        ab.d("MicroMsg.ErrorMsgBoxProcessor", "handleOpenUrl");
        Toast.makeText(this.activity, agVar.content, 0).show();
        AppMethodBeat.o(124551);
        return true;
    }

    public final boolean c(ag agVar) {
        AppMethodBeat.i(124552);
        ab.d("MicroMsg.ErrorMsgBoxProcessor", "handleIgnore");
        Toast.makeText(this.activity, agVar.content, 0).show();
        AppMethodBeat.o(124552);
        return true;
    }

    public final boolean d(ag agVar) {
        AppMethodBeat.i(124553);
        ab.d("MicroMsg.ErrorMsgBoxProcessor", "handleFalseLast");
        Toast.makeText(this.activity, agVar.content, 0).show();
        AppMethodBeat.o(124553);
        return true;
    }

    public final boolean e(ag agVar) {
        AppMethodBeat.i(124554);
        ab.d("MicroMsg.ErrorMsgBoxProcessor", "handleFalseCancel");
        Toast.makeText(this.activity, agVar.content, 0).show();
        AppMethodBeat.o(124554);
        return true;
    }
}

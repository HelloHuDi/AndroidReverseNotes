package com.tencent.mm.g.a;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class qr extends b {
    public a cMP;

    public static final class a {
        public String cMQ;
        public OnDismissListener cMR;
        public Bundle cMS;
        public Context context;
    }

    public qr() {
        this((byte) 0);
    }

    private qr(byte b) {
        AppMethodBeat.i(5607);
        this.cMP = new a();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(5607);
    }
}

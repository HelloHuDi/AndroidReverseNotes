package com.tencent.mm.g.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.aj;

public final class jc extends com.tencent.mm.sdk.b.b {
    public a cEj;
    public b cEk;

    public static final class a {
        public String appId;
        public WXMediaMessage cEl;
        public aj cEm;
        public Context context;
        public Bundle cvs;
        public int showType;
    }

    public static final class b {
        public boolean cEn;
    }

    public jc() {
        this((byte) 0);
    }

    private jc(byte b) {
        AppMethodBeat.i(77548);
        this.cEj = new a();
        this.cEk = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(77548);
    }
}

package com.tencent.mm.g.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.abh;
import java.util.ArrayList;

public final class ld extends com.tencent.mm.sdk.b.b {
    public a cGU;
    public b cGV;

    public static final class a {
        public String cGW;
        public String cGX;
        public boolean cGY = false;
        public Bundle cGZ;
        public int cHa = 0;
        public ArrayList cHb;
        public boolean cHc = true;
        public abh cHd;
        public Context context;
        public abf field_favProto;
        public long field_localId = 0;
        public int itemType = 0;
        public String path;
        public int type = 0;
    }

    public static final class b {
        public String path;
        public int ret = 0;
    }

    public ld() {
        this((byte) 0);
    }

    private ld(byte b) {
        AppMethodBeat.i(51340);
        this.cGU = new a();
        this.cGV = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(51340);
    }
}

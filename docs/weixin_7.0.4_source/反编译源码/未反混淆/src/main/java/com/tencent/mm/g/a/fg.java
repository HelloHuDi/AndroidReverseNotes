package com.tencent.mm.g.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class fg extends com.tencent.mm.sdk.b.b {
    public a cyJ;
    public b cyK;

    public static final class a {
        public Cursor cyL;
    }

    public static final class b {
        public String cyM;
        public int cyN;
        public String cyO;
        public long cyP;
        public int cyQ;
        public int cyR;
        public List cyS;
        public List cyT;
        public int cyU;
        public int cyV;
    }

    public fg() {
        this((byte) 0);
    }

    private fg(byte b) {
        AppMethodBeat.i(70181);
        this.cyJ = new a();
        this.cyK = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(70181);
    }
}

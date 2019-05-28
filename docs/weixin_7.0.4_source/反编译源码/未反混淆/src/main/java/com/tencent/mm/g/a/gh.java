package com.tencent.mm.g.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.aaw;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.abh;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.List;

public final class gh extends com.tencent.mm.sdk.b.b {
    public a cAH;
    public b cAI;

    public static final class a {
        public aar cAJ;
        public Intent cAK;
        public com.tencent.mm.sdk.e.k.a cAL;
        public Runnable cAM;
        public String cAN;
        public int cAO = 0;
        public int cAP = 0;
        public String cAQ;
        public String cAR;
        public abh cAS;
        public Context context;
        public abf cvC;
        public long cvv;
        public m cwn;
        public String desc;
        public ak handler;
        public String path;
        public String title;
        public String toUser;
        public int type = 0;
    }

    public static final class b {
        public List bka;
        public aaw cAT;
        public e cAU;
        public List cAV;
        public boolean cAW = false;
        public boolean cAX = false;
        public boolean cAY = false;
        public double cAZ = 0.0d;
        public String path;
        public int ret = -1;
        public String thumbPath;
        public String thumbUrl;
    }

    public gh() {
        this((byte) 0);
    }

    private gh(byte b) {
        AppMethodBeat.i(51338);
        this.cAH = new a();
        this.cAI = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(51338);
    }
}

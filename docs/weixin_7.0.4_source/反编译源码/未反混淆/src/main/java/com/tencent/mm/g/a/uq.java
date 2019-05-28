package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import java.util.LinkedList;

public final class uq extends com.tencent.mm.sdk.b.b {
    public a cQP;
    public b cQQ;

    public static final class a {
        public boolean cQR;
        public boolean cQS = false;
        public int scene;
    }

    public static final class b {
        public String aIm;
        public Runnable cQH;
        public boolean cQT;
        public boolean cQU;
        public boolean cQV;
        public boolean cQW;
        public String cQX;
        public String cQY;
        public boolean cQZ;
        public boolean cRa;
        public String cRb;
        public String cRc;
        public String cRd;
        public String cRe;
        public String cRf;
        public String cRg;
        public int cRh;
        public String cRi;
        public String cRj;
        public String cRk;
        public String cRl;
        public LinkedList<String> cRm;
        public ECardInfo cRn;
        public boolean cRo = false;
        public int cRp;
        public int cRq;
        public boolean cRr;
        public String cRs;
        public boolean cRt;
        public m cRu;
        public int errCode = 0;
        public int scene;
        public String subtitle;
        public String title;
    }

    public uq() {
        this((byte) 0);
    }

    private uq(byte b) {
        AppMethodBeat.i(40559);
        this.cQP = new a();
        this.cQQ = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(40559);
    }
}

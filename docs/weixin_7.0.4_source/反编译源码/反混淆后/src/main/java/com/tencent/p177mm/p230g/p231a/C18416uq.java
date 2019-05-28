package com.tencent.p177mm.p230g.p231a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.p177mm.sdk.p600b.C4883b;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.g.a.uq */
public final class C18416uq extends C4883b {
    public C9487a cQP;
    public C18417b cQQ;

    /* renamed from: com.tencent.mm.g.a.uq$a */
    public static final class C9487a {
        public boolean cQR;
        public boolean cQS = false;
        public int scene;
    }

    /* renamed from: com.tencent.mm.g.a.uq$b */
    public static final class C18417b {
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
        public C1207m cRu;
        public int errCode = 0;
        public int scene;
        public String subtitle;
        public String title;
    }

    public C18416uq() {
        this((byte) 0);
    }

    private C18416uq(byte b) {
        AppMethodBeat.m2504i(40559);
        this.cQP = new C9487a();
        this.cQQ = new C18417b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(40559);
    }
}

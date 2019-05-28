package com.tencent.p177mm.p230g.p231a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.aaw;
import com.tencent.p177mm.protocal.protobuf.abf;
import com.tencent.p177mm.protocal.protobuf.abh;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.List;

/* renamed from: com.tencent.mm.g.a.gh */
public final class C37721gh extends C4883b {
    public C9355a cAH;
    public C9356b cAI;

    /* renamed from: com.tencent.mm.g.a.gh$a */
    public static final class C9355a {
        public aar cAJ;
        public Intent cAK;
        public C4931a cAL;
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
        public C1207m cwn;
        public String desc;
        public C7306ak handler;
        public String path;
        public String title;
        public String toUser;
        public int type = 0;
    }

    /* renamed from: com.tencent.mm.g.a.gh$b */
    public static final class C9356b {
        public List bka;
        public aaw cAT;
        public C4927e cAU;
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

    public C37721gh() {
        this((byte) 0);
    }

    private C37721gh(byte b) {
        AppMethodBeat.m2504i(51338);
        this.cAH = new C9355a();
        this.cAI = new C9356b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(51338);
    }
}

package com.tencent.p177mm.p230g.p231a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.abf;
import com.tencent.p177mm.protocal.protobuf.abh;
import com.tencent.p177mm.sdk.p600b.C4883b;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.g.a.ld */
public final class C18313ld extends C4883b {
    public C18314a cGU;
    public C18315b cGV;

    /* renamed from: com.tencent.mm.g.a.ld$a */
    public static final class C18314a {
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

    /* renamed from: com.tencent.mm.g.a.ld$b */
    public static final class C18315b {
        public String path;
        public int ret = 0;
    }

    public C18313ld() {
        this((byte) 0);
    }

    private C18313ld(byte b) {
        AppMethodBeat.m2504i(51340);
        this.cGU = new C18314a();
        this.cGV = new C18315b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(51340);
    }
}

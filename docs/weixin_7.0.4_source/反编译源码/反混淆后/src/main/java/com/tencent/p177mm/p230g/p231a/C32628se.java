package com.tencent.p177mm.p230g.p231a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelappbrand.LaunchParamsOptional;
import com.tencent.p177mm.sdk.p600b.C4883b;

/* renamed from: com.tencent.mm.g.a.se */
public final class C32628se extends C4883b {
    public C18390a cOf;
    public C26239b cOg;

    /* renamed from: com.tencent.mm.g.a.se$a */
    public static final class C18390a {
        public String appId;
        public int axy;
        public String cOh;
        public int cOi;
        public String cOj;
        public String cOk;
        public boolean cOl;
        public boolean cOm = true;
        public LaunchParamsOptional cOn = new LaunchParamsOptional();
        public int cOo;
        public Runnable cOp;
        public int cOq;
        public String cOr;
        public String cOs;
        public String cOt;
        public String cOu;
        public String cOv;
        public Context context;
        public String cst;
        public Bundle cvs;
        public int scene;
        public String userName;

        public C18390a() {
            AppMethodBeat.m2504i(114900);
            AppMethodBeat.m2505o(114900);
        }
    }

    /* renamed from: com.tencent.mm.g.a.se$b */
    public static final class C26239b {
        public boolean cOw;
        public String cOx;
    }

    public C32628se() {
        this((byte) 0);
    }

    private C32628se(byte b) {
        AppMethodBeat.m2504i(114901);
        this.cOf = new C18390a();
        this.cOg = new C26239b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(114901);
    }
}

package com.tencent.p177mm.p230g.p231a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.pluginsdk.model.app.C14875aj;
import com.tencent.p177mm.sdk.p600b.C4883b;

/* renamed from: com.tencent.mm.g.a.jc */
public final class C32579jc extends C4883b {
    public C1547a cEj;
    public C9387b cEk;

    /* renamed from: com.tencent.mm.g.a.jc$a */
    public static final class C1547a {
        public String appId;
        public WXMediaMessage cEl;
        public C14875aj cEm;
        public Context context;
        public Bundle cvs;
        public int showType;
    }

    /* renamed from: com.tencent.mm.g.a.jc$b */
    public static final class C9387b {
        public boolean cEn;
    }

    public C32579jc() {
        this((byte) 0);
    }

    private C32579jc(byte b) {
        AppMethodBeat.m2504i(77548);
        this.cEj = new C1547a();
        this.cEk = new C9387b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(77548);
    }
}

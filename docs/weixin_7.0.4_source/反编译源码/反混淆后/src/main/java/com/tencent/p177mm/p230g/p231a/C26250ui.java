package com.tencent.p177mm.p230g.p231a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p600b.C4883b;

/* renamed from: com.tencent.mm.g.a.ui */
public final class C26250ui extends C4883b {
    public C18413a cQx;
    public C26251b cQy;

    /* renamed from: com.tencent.mm.g.a.ui$a */
    public static final class C18413a {
        public int cAd = 0;
        public byte[] cQr;
        public int cQs = 0;
        public String content;
        public Context context;
        public String talker;
    }

    /* renamed from: com.tencent.mm.g.a.ui$b */
    public static final class C26251b {
        public boolean cQA = false;
        public boolean cQz = false;
        public int type = 0;
    }

    public C26250ui() {
        this((byte) 0);
    }

    private C26250ui(byte b) {
        AppMethodBeat.m2504i(77575);
        this.cQx = new C18413a();
        this.cQy = new C26251b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(77575);
    }
}

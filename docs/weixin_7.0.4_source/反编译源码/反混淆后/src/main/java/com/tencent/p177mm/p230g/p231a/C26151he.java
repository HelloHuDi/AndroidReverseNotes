package com.tencent.p177mm.p230g.p231a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p600b.C4883b;

/* renamed from: com.tencent.mm.g.a.he */
public final class C26151he extends C4883b {
    public C26150a cBW;
    public C18280b cBX;

    /* renamed from: com.tencent.mm.g.a.he$b */
    public static final class C18280b {
        public int ret = 0;
    }

    /* renamed from: com.tencent.mm.g.a.he$a */
    public static final class C26150a {
        public int actionCode;
        public Bundle cBY;
        public Context context;
        public String result;
        public String username;
    }

    public C26151he() {
        this((byte) 0);
    }

    private C26151he(byte b) {
        AppMethodBeat.m2504i(135758);
        this.cBW = new C26150a();
        this.cBX = new C18280b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(135758);
    }
}

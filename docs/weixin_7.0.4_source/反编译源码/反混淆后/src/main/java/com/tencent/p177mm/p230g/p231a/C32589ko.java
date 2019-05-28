package com.tencent.p177mm.p230g.p231a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.ayb;
import com.tencent.p177mm.sdk.p600b.C4883b;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.g.a.ko */
public final class C32589ko extends C4883b {
    public C32590a cGu;
    public C32591b cGv;

    /* renamed from: com.tencent.mm.g.a.ko$a */
    public static final class C32590a {
        public String cEw;
        public boolean cFT = false;
    }

    /* renamed from: com.tencent.mm.g.a.ko$b */
    public static final class C32591b {
        public int cEX = 0;
        public LinkedList<ayb> cGh;
    }

    public C32589ko() {
        this((byte) 0);
    }

    private C32589ko(byte b) {
        AppMethodBeat.m2504i(118261);
        this.cGu = new C32590a();
        this.cGv = new C32591b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(118261);
    }
}

package com.tencent.p177mm.p230g.p231a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p600b.C4883b;
import java.util.List;

/* renamed from: com.tencent.mm.g.a.fg */
public final class C6477fg extends C4883b {
    public C6478a cyJ;
    public C6479b cyK;

    /* renamed from: com.tencent.mm.g.a.fg$a */
    public static final class C6478a {
        public Cursor cyL;
    }

    /* renamed from: com.tencent.mm.g.a.fg$b */
    public static final class C6479b {
        public String cyM;
        public int cyN;
        public String cyO;
        public long cyP;
        public int cyQ;
        public int cyR;
        public List cyS;
        public List cyT;
        public int cyU;
        public int cyV;
    }

    public C6477fg() {
        this((byte) 0);
    }

    private C6477fg(byte b) {
        AppMethodBeat.m2504i(70181);
        this.cyJ = new C6478a();
        this.cyK = new C6479b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(70181);
    }
}

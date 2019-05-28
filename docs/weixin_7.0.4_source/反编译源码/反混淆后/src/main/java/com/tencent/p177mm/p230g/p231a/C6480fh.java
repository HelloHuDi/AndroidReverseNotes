package com.tencent.p177mm.p230g.p231a;

import android.database.MatrixCursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p600b.C4883b;

/* renamed from: com.tencent.mm.g.a.fh */
public final class C6480fh extends C4883b {
    public C6481a cyW;
    public C6482b cyX;

    /* renamed from: com.tencent.mm.g.a.fh$a */
    public static final class C6481a {
        public String[] cyY;
    }

    /* renamed from: com.tencent.mm.g.a.fh$b */
    public static final class C6482b {
        public int cyD = 0;
        public MatrixCursor cyZ;
    }

    public C6480fh() {
        this((byte) 0);
    }

    private C6480fh(byte b) {
        AppMethodBeat.m2504i(15771);
        this.cyW = new C6481a();
        this.cyX = new C6482b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(15771);
    }
}

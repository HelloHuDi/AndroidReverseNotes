package com.tencent.p177mm.p230g.p231a;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.facedetect.model.C43038r;
import com.tencent.p177mm.sdk.p600b.C4883b;

/* renamed from: com.tencent.mm.g.a.oq */
public final class C45353oq extends C4883b {
    public C45352a cKZ;

    /* renamed from: com.tencent.mm.g.a.oq$a */
    public static final class C45352a {
        public byte[] cLa;
        public Rect cLb;
        public C43038r cLc;
        public int height = -1;
        public int rotate = 90;
        public int width = -1;
    }

    public C45353oq() {
        this((byte) 0);
    }

    private C45353oq(byte b) {
        AppMethodBeat.m2504i(28);
        this.cKZ = new C45352a();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(28);
    }
}

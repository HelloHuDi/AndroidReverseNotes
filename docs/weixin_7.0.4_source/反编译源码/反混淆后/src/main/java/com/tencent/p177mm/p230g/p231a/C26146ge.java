package com.tencent.p177mm.p230g.p231a;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.sdk.p600b.C4883b;

/* renamed from: com.tencent.mm.g.a.ge */
public final class C26146ge extends C4883b {
    public C9354a cAt;
    public C26147b cAu;

    /* renamed from: com.tencent.mm.g.a.ge$a */
    public static final class C9354a {
        public boolean cAA = true;
        public aar cAv;
        public ImageView cAw;
        public int cAx;
        public boolean cAy = false;
        public boolean cAz = false;
        public Context context;
        public long cvv;
        public int height;
        public int maxWidth;
        public int opType = 3;
        public int width;
    }

    /* renamed from: com.tencent.mm.g.a.ge$b */
    public static final class C26147b {
        public Bitmap cAB;
        public int ret = -1;
    }

    public C26146ge() {
        this((byte) 0);
    }

    private C26146ge(byte b) {
        AppMethodBeat.m2504i(51336);
        this.cAt = new C9354a();
        this.cAu = new C26147b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(51336);
    }
}

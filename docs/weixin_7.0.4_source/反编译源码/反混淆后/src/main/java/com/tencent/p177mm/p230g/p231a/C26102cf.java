package com.tencent.p177mm.p230g.p231a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p600b.C4883b;

/* renamed from: com.tencent.mm.g.a.cf */
public final class C26102cf extends C4883b {
    public C26103a cvm;

    /* renamed from: com.tencent.mm.g.a.cf$a */
    public static final class C26103a {
        public Activity activity;
        public String ctB;
        public int cvn;
        public int cvo;
        public int cvp = 0;
        public String cvq;
        public String cvr;
        public Bundle cvs;
        public int from = -1;
        public String imagePath;
        public int scene = -1;
        public String source;
    }

    public C26102cf() {
        this((byte) 0);
    }

    private C26102cf(byte b) {
        AppMethodBeat.m2504i(70137);
        this.cvm = new C26103a();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(70137);
    }
}

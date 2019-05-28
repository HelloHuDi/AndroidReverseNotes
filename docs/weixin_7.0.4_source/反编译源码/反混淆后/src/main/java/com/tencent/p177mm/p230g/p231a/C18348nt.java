package com.tencent.p177mm.p230g.p231a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.p1338b.p1339a.C44099c;
import com.tencent.p177mm.protocal.p1338b.p1339a.C44100d;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.abf;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.storage.C7620bi;
import java.util.List;

/* renamed from: com.tencent.mm.g.a.nt */
public final class C18348nt extends C4883b {
    public C18349a cJY;
    public C18350b cJZ;

    /* renamed from: com.tencent.mm.g.a.nt$a */
    public static final class C18349a {
        public String cAN;
        public aar cAv;
        public C45316cl cJy;
        public String cKa;
        public abf cKb;
        public int cKc = 0;
        public C7620bi cKd;
        public List<C7620bi> cKe;
        public String cKf;
        public String cKg;
        public C44100d cKh;
        public Context context;
        public long cvx = 0;
        public String desc;
        public String thumbPath;
        public String title;
        public String toUser;
        public int type = 0;
    }

    /* renamed from: com.tencent.mm.g.a.nt$b */
    public static final class C18350b {
        public C45316cl cJy;
        public C44100d cKh;
        public C44099c cKi;
        public boolean cKj = false;
        public boolean cKk = false;
        public String dataPath;
        public String thumbPath;
    }

    public C18348nt() {
        this((byte) 0);
    }

    private C18348nt(byte b) {
        AppMethodBeat.m2504i(111110);
        this.cJY = new C18349a();
        this.cJZ = new C18350b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(111110);
    }
}

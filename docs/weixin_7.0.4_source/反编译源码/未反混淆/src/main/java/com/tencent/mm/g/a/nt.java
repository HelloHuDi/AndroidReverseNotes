package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.b.a.d;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.storage.bi;
import java.util.List;

public final class nt extends com.tencent.mm.sdk.b.b {
    public a cJY;
    public b cJZ;

    public static final class a {
        public String cAN;
        public aar cAv;
        public cl cJy;
        public String cKa;
        public abf cKb;
        public int cKc = 0;
        public bi cKd;
        public List<bi> cKe;
        public String cKf;
        public String cKg;
        public d cKh;
        public Context context;
        public long cvx = 0;
        public String desc;
        public String thumbPath;
        public String title;
        public String toUser;
        public int type = 0;
    }

    public static final class b {
        public cl cJy;
        public d cKh;
        public c cKi;
        public boolean cKj = false;
        public boolean cKk = false;
        public String dataPath;
        public String thumbPath;
    }

    public nt() {
        this((byte) 0);
    }

    private nt(byte b) {
        AppMethodBeat.i(111110);
        this.cJY = new a();
        this.cJZ = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(111110);
    }
}

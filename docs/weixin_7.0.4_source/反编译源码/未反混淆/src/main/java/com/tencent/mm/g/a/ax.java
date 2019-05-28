package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class ax extends com.tencent.mm.sdk.b.b {
    public a cua;
    public b cub;

    public static final class a {
        public EmojiInfo cuc;
        public String cud;
        public int type;
    }

    public static final class b {
        public boolean csN = false;
    }

    public ax() {
        this((byte) 0);
    }

    private ax(byte b) {
        AppMethodBeat.i(62215);
        this.cua = new a();
        this.cub = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(62215);
    }
}

package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;

public class TbsMediaFactory {
    private Context a = null;
    private bi b = null;
    private DexLoader c = null;

    public TbsMediaFactory(Context context) {
        AppMethodBeat.i(64518);
        this.a = context.getApplicationContext();
        a();
        AppMethodBeat.o(64518);
    }

    private void a() {
        AppMethodBeat.i(64519);
        if (this.a == null) {
            AppMethodBeat.o(64519);
            return;
        }
        if (this.b == null) {
            o.a(true).a(this.a, false, false, null);
            this.b = o.a(true).a();
            if (this.b != null) {
                this.c = this.b.b();
            }
        }
        if (this.b == null || this.c == null) {
            RuntimeException runtimeException = new RuntimeException("tbs core dex(s) load failure !!!");
            AppMethodBeat.o(64519);
            throw runtimeException;
        }
        AppMethodBeat.o(64519);
    }

    public TbsMediaPlayer createPlayer() {
        AppMethodBeat.i(64520);
        if (this.b == null || this.c == null) {
            RuntimeException runtimeException = new RuntimeException("tbs core dex(s) did not loaded !!!");
            AppMethodBeat.o(64520);
            throw runtimeException;
        }
        TbsMediaPlayer tbsMediaPlayer = new TbsMediaPlayer(new ba(this.c, this.a));
        AppMethodBeat.o(64520);
        return tbsMediaPlayer;
    }
}

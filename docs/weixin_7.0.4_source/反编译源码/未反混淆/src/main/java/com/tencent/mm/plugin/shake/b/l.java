package com.tencent.mm.plugin.shake.b;

import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.shake.c.a.e;
import com.tencent.mm.plugin.shake.c.a.g;
import com.tencent.mm.plugin.shake.d.a.h;
import com.tencent.mm.plugin.shake.d.a.j;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.List;

public final class l {
    protected static long qrP = 16000;
    protected static int qrQ = 54158;
    public int qrR;
    public b qrS;

    public interface a {
        void a(int i, e eVar, long j);

        void b(List<d> list, long j);
    }

    public static abstract class b {
        public a qrT;
        protected boolean qrU = false;
        protected long qrV = l.qrP;
        private ak qrW = new ak(new com.tencent.mm.sdk.platformtools.ak.a() {
            public final boolean handleMessage(Message message) {
                AppMethodBeat.i(24472);
                if (!(message.what != l.qrQ || b.this.qrU || b.this.qrT == null)) {
                    b.this.qrT.b(null, 5);
                }
                AppMethodBeat.o(24472);
                return false;
            }
        });

        public abstract void init();

        public abstract void pause();

        public abstract void reset();

        public abstract void resume();

        public abstract void start();

        public b(a aVar) {
            this.qrT = aVar;
        }

        public void cjw() {
            reset();
            this.qrT = null;
        }
    }

    public final b a(Context context, int i, a aVar) {
        AppMethodBeat.i(24473);
        b bVar;
        if (i == this.qrR) {
            bVar = this.qrS;
            AppMethodBeat.o(24473);
            return bVar;
        }
        if (this.qrS != null) {
            this.qrS.cjw();
        }
        switch (i) {
            case 1:
                this.qrS = new c(context, aVar);
                break;
            case 3:
                this.qrS = j.a(aVar);
                break;
            case 4:
                this.qrS = new com.tencent.mm.plugin.shake.d.a.l(context, aVar);
                break;
            case 5:
                this.qrS = new h(aVar);
                break;
            case 6:
                this.qrS = new g(aVar);
                break;
        }
        this.qrR = i;
        this.qrS.init();
        bVar = this.qrS;
        AppMethodBeat.o(24473);
        return bVar;
    }
}

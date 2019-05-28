package com.tencent.p177mm.plugin.shake.p1019b;

import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.shake.p506c.p507a.C21829e;
import com.tencent.p177mm.plugin.shake.p506c.p507a.C7084g;
import com.tencent.p177mm.plugin.shake.p509d.p510a.C13262l;
import com.tencent.p177mm.plugin.shake.p509d.p510a.C34900h;
import com.tencent.p177mm.plugin.shake.p509d.p510a.C34904j;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7306ak.C4998a;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.shake.b.l */
public final class C39691l {
    protected static long qrP = 16000;
    protected static int qrQ = 54158;
    public int qrR;
    public C21828b qrS;

    /* renamed from: com.tencent.mm.plugin.shake.b.l$a */
    public interface C21826a {
        /* renamed from: a */
        void mo25339a(int i, C21829e c21829e, long j);

        /* renamed from: b */
        void mo25340b(List<C34894d> list, long j);
    }

    /* renamed from: com.tencent.mm.plugin.shake.b.l$b */
    public static abstract class C21828b {
        public C21826a qrT;
        protected boolean qrU = false;
        protected long qrV = C39691l.qrP;
        private C7306ak qrW = new C7306ak(new C218271());

        /* renamed from: com.tencent.mm.plugin.shake.b.l$b$1 */
        class C218271 implements C4998a {
            C218271() {
            }

            public final boolean handleMessage(Message message) {
                AppMethodBeat.m2504i(24472);
                if (!(message.what != C39691l.qrQ || C21828b.this.qrU || C21828b.this.qrT == null)) {
                    C21828b.this.qrT.mo25340b(null, 5);
                }
                AppMethodBeat.m2505o(24472);
                return false;
            }
        }

        public abstract void init();

        public abstract void pause();

        public abstract void reset();

        public abstract void resume();

        public abstract void start();

        public C21828b(C21826a c21826a) {
            this.qrT = c21826a;
        }

        public void cjw() {
            reset();
            this.qrT = null;
        }
    }

    /* renamed from: a */
    public final C21828b mo62652a(Context context, int i, C21826a c21826a) {
        AppMethodBeat.m2504i(24473);
        C21828b c21828b;
        if (i == this.qrR) {
            c21828b = this.qrS;
            AppMethodBeat.m2505o(24473);
            return c21828b;
        }
        if (this.qrS != null) {
            this.qrS.cjw();
        }
        switch (i) {
            case 1:
                this.qrS = new C39688c(context, c21826a);
                break;
            case 3:
                this.qrS = C34904j.m57320a(c21826a);
                break;
            case 4:
                this.qrS = new C13262l(context, c21826a);
                break;
            case 5:
                this.qrS = new C34900h(c21826a);
                break;
            case 6:
                this.qrS = new C7084g(c21826a);
                break;
        }
        this.qrR = i;
        this.qrS.init();
        c21828b = this.qrS;
        AppMethodBeat.m2505o(24473);
        return c21828b;
    }
}

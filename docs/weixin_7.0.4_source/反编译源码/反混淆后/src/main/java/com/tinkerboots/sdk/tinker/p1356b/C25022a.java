package com.tinkerboots.sdk.tinker.p1356b;

import android.content.Context;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.facebook.internal.NativeProtocol;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.lib.p1353d.C24433a;
import com.tencent.tinker.lib.p679e.C31097a;
import com.tencent.tinker.lib.p679e.C44553d;
import com.tencent.tinker.lib.util.C41089c;
import com.tencent.tinker.lib.util.C5952a;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

/* renamed from: com.tinkerboots.sdk.tinker.b.a */
public final class C25022a extends C24433a {

    /* renamed from: com.tinkerboots.sdk.tinker.b.a$1 */
    class C245771 implements IdleHandler {
        C245771() {
        }

        public final boolean queueIdle() {
            AppMethodBeat.m2504i(CdnLogic.kBizGeneric);
            C41089c.m71517jc(C25022a.this.context).dSj();
            AppMethodBeat.m2505o(CdnLogic.kBizGeneric);
            return false;
        }
    }

    public C25022a(Context context) {
        super(context);
    }

    /* renamed from: a */
    public final void mo40766a(File file, int i, long j) {
        AppMethodBeat.m2504i(65536);
        super.mo40766a(file, i, j);
        Looper.getMainLooper();
        Looper.myQueue().addIdleHandler(new C245771());
        AppMethodBeat.m2505o(65536);
    }

    /* renamed from: a */
    public final void mo40770a(Throwable th, int i) {
        AppMethodBeat.m2504i(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REPLY);
        super.mo40770a(th, i);
        AppMethodBeat.m2505o(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REPLY);
    }

    /* renamed from: a */
    public final void mo40769a(String str, String str2, File file, String str3) {
        AppMethodBeat.m2504i(65538);
        super.mo40769a(str, str2, file, str3);
        AppMethodBeat.m2505o(65538);
    }

    /* renamed from: a */
    public final void mo40767a(File file, int i, boolean z) {
        AppMethodBeat.m2504i(65539);
        super.mo40767a(file, i, z);
        if (i == 1) {
            C44553d c44553d = C31097a.m50180iX(this.context).ABJ;
            if (c44553d.ABO != null && "00000000000000000000000000000000".equals(c44553d.ABO)) {
                C5952a.m9283e("Tinker.ServerLoadReporter", "Roll back patch when restarting main process, restart all other process also!", new Object[0]);
                ShareTinkerInternals.m9426jr(this.context);
            }
        }
        AppMethodBeat.m2505o(65539);
    }
}

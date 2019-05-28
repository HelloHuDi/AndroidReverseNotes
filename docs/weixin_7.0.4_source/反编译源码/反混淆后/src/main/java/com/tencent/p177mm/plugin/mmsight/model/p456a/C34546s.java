package com.tencent.p177mm.plugin.mmsight.model.p456a;

import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43304d.C34542b;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43304d.C34543c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.view.C31128d;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.plugin.mmsight.model.a.s */
public final class C34546s {
    public C34543c oxa = C34543c.Stop;
    SparseArray<WeakReference<C34542b>> oxb = new SparseArray();
    private C7306ak oxc = new C7306ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(76687);
            C34542b c34542b;
            if (C31128d.MIC_PTU_ZIPAI_TOKYO == message.what) {
                C34543c c34543c = (C34543c) message.obj;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < C34546s.this.oxb.size()) {
                        if (((C34542b) ((WeakReference) C34546s.this.oxb.valueAt(i2)).get()) != null) {
                            int[] iArr = C125572.oxe;
                            c34543c.ordinal();
                        }
                        i = i2 + 1;
                    } else {
                        AppMethodBeat.m2505o(76687);
                        return;
                    }
                }
            } else if (C31128d.MIC_PTU_ZIPAI_SAPPORO == message.what) {
                c34542b = (C34542b) message.obj;
                if (c34542b == null) {
                    AppMethodBeat.m2505o(76687);
                    return;
                }
                C34546s.this.oxb.put(c34542b.hashCode(), new WeakReference(c34542b));
                AppMethodBeat.m2505o(76687);
            } else {
                if (C31128d.MIC_PTU_ZIPAI_MEDSEA == message.what) {
                    c34542b = (C34542b) message.obj;
                    if (c34542b == null) {
                        AppMethodBeat.m2505o(76687);
                        return;
                    }
                    C34546s.this.oxb.remove(c34542b.hashCode());
                }
                AppMethodBeat.m2505o(76687);
            }
        }
    };

    /* renamed from: com.tencent.mm.plugin.mmsight.model.a.s$2 */
    static /* synthetic */ class C125572 {
        static final /* synthetic */ int[] oxe = new int[C34543c.values().length];

        static {
            AppMethodBeat.m2504i(76688);
            try {
                oxe[C34543c.Start.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                oxe[C34543c.Stop.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                oxe[C34543c.Sent.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                oxe[C34543c.Error.ordinal()] = 4;
                AppMethodBeat.m2505o(76688);
            } catch (NoSuchFieldError e4) {
                AppMethodBeat.m2505o(76688);
            }
        }
    }

    public C34546s() {
        AppMethodBeat.m2504i(76689);
        AppMethodBeat.m2505o(76689);
    }

    /* renamed from: a */
    public final void mo55075a(C34543c c34543c) {
        AppMethodBeat.m2504i(76690);
        C4990ab.m7417i("MicroMsg.SightMediaStatusHandler", "status change to %s", c34543c.toString());
        this.oxa = c34543c;
        this.oxc.sendMessage(this.oxc.obtainMessage(C31128d.MIC_PTU_ZIPAI_TOKYO, c34543c));
        AppMethodBeat.m2505o(76690);
    }
}

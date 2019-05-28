package com.tencent.mm.plugin.mmsight.model.a;

import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.a.d.b;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.view.d;
import java.lang.ref.WeakReference;

public final class s {
    public c oxa = c.Stop;
    SparseArray<WeakReference<b>> oxb = new SparseArray();
    private ak oxc = new ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(76687);
            b bVar;
            if (d.MIC_PTU_ZIPAI_TOKYO == message.what) {
                c cVar = (c) message.obj;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < s.this.oxb.size()) {
                        if (((b) ((WeakReference) s.this.oxb.valueAt(i2)).get()) != null) {
                            int[] iArr = AnonymousClass2.oxe;
                            cVar.ordinal();
                        }
                        i = i2 + 1;
                    } else {
                        AppMethodBeat.o(76687);
                        return;
                    }
                }
            } else if (d.MIC_PTU_ZIPAI_SAPPORO == message.what) {
                bVar = (b) message.obj;
                if (bVar == null) {
                    AppMethodBeat.o(76687);
                    return;
                }
                s.this.oxb.put(bVar.hashCode(), new WeakReference(bVar));
                AppMethodBeat.o(76687);
            } else {
                if (d.MIC_PTU_ZIPAI_MEDSEA == message.what) {
                    bVar = (b) message.obj;
                    if (bVar == null) {
                        AppMethodBeat.o(76687);
                        return;
                    }
                    s.this.oxb.remove(bVar.hashCode());
                }
                AppMethodBeat.o(76687);
            }
        }
    };

    /* renamed from: com.tencent.mm.plugin.mmsight.model.a.s$2 */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] oxe = new int[c.values().length];

        static {
            AppMethodBeat.i(76688);
            try {
                oxe[c.Start.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                oxe[c.Stop.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                oxe[c.Sent.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                oxe[c.Error.ordinal()] = 4;
                AppMethodBeat.o(76688);
            } catch (NoSuchFieldError e4) {
                AppMethodBeat.o(76688);
            }
        }
    }

    public s() {
        AppMethodBeat.i(76689);
        AppMethodBeat.o(76689);
    }

    public final void a(c cVar) {
        AppMethodBeat.i(76690);
        ab.i("MicroMsg.SightMediaStatusHandler", "status change to %s", cVar.toString());
        this.oxa = cVar;
        this.oxc.sendMessage(this.oxc.obtainMessage(d.MIC_PTU_ZIPAI_TOKYO, cVar));
        AppMethodBeat.o(76690);
    }
}

package com.tencent.mm.plugin.luckymoney.f2f;

import android.content.Context;
import android.media.SoundPool;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public final class a {
    public volatile boolean jxQ = false;
    public SoundPool nTR = new SoundPool(2, 3, 0);
    Hashtable<String, Integer> nTS = new Hashtable();
    Map<Integer, Boolean> nTT = new HashMap();

    /* renamed from: com.tencent.mm.plugin.luckymoney.f2f.a$1 */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ Set nTU;
        final /* synthetic */ WeakReference nTV;

        public AnonymousClass1(Set set, WeakReference weakReference) {
            this.nTU = set;
            this.nTV = weakReference;
        }

        public final void run() {
            AppMethodBeat.i(42141);
            try {
                for (String str : this.nTU) {
                    if (this.nTV.get() == null || a.this.jxQ) {
                        ab.i("AsyncSoundPool", "context = null or soundPool is stopped");
                        a.this.nTR.release();
                        a.this.nTS.clear();
                        a.this.nTT.clear();
                        AppMethodBeat.o(42141);
                        return;
                    }
                    a.this.nTS.put(str, Integer.valueOf(a.this.nTR.load(((Context) this.nTV.get()).getResources().getAssets().openFd(str), 0)));
                }
                AppMethodBeat.o(42141);
            } catch (Exception e) {
                ab.e("AsyncSoundPool", "load sound file error:" + e.getMessage());
                AppMethodBeat.o(42141);
            }
        }
    }

    public a() {
        AppMethodBeat.i(42143);
        AppMethodBeat.o(42143);
    }

    public final void jU(String str) {
        AppMethodBeat.i(42144);
        if (this.nTS.containsKey(str)) {
            int intValue = ((Integer) this.nTS.get(str)).intValue();
            if (intValue >= 0 && this.nTT.containsKey(Integer.valueOf(intValue)) && ((Boolean) this.nTT.get(Integer.valueOf(intValue))).booleanValue()) {
                this.nTR.play(intValue, 1.0f, 1.0f, 0, 0, 1.0f);
            }
        }
        AppMethodBeat.o(42144);
    }
}

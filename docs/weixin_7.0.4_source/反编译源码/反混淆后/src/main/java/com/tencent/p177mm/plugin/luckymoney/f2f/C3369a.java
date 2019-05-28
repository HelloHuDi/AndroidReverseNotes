package com.tencent.p177mm.plugin.luckymoney.f2f;

import android.content.Context;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.luckymoney.f2f.a */
public final class C3369a {
    public volatile boolean jxQ = false;
    public SoundPool nTR = new SoundPool(2, 3, 0);
    Hashtable<String, Integer> nTS = new Hashtable();
    Map<Integer, Boolean> nTT = new HashMap();

    /* renamed from: com.tencent.mm.plugin.luckymoney.f2f.a$1 */
    public class C33701 implements Runnable {
        final /* synthetic */ Set nTU;
        final /* synthetic */ WeakReference nTV;

        public C33701(Set set, WeakReference weakReference) {
            this.nTU = set;
            this.nTV = weakReference;
        }

        public final void run() {
            AppMethodBeat.m2504i(42141);
            try {
                for (String str : this.nTU) {
                    if (this.nTV.get() == null || C3369a.this.jxQ) {
                        C4990ab.m7416i("AsyncSoundPool", "context = null or soundPool is stopped");
                        C3369a.this.nTR.release();
                        C3369a.this.nTS.clear();
                        C3369a.this.nTT.clear();
                        AppMethodBeat.m2505o(42141);
                        return;
                    }
                    C3369a.this.nTS.put(str, Integer.valueOf(C3369a.this.nTR.load(((Context) this.nTV.get()).getResources().getAssets().openFd(str), 0)));
                }
                AppMethodBeat.m2505o(42141);
            } catch (Exception e) {
                C4990ab.m7412e("AsyncSoundPool", "load sound file error:" + e.getMessage());
                AppMethodBeat.m2505o(42141);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.f2f.a$2 */
    public class C33712 implements OnLoadCompleteListener {
        public final void onLoadComplete(SoundPool soundPool, int i, int i2) {
            AppMethodBeat.m2504i(42142);
            if (i2 == 0) {
                C3369a.this.nTT.put(Integer.valueOf(i), Boolean.TRUE);
                AppMethodBeat.m2505o(42142);
                return;
            }
            C3369a.this.nTT.put(Integer.valueOf(i), Boolean.FALSE);
            AppMethodBeat.m2505o(42142);
        }
    }

    public C3369a() {
        AppMethodBeat.m2504i(42143);
        AppMethodBeat.m2505o(42143);
    }

    /* renamed from: jU */
    public final void mo7780jU(String str) {
        AppMethodBeat.m2504i(42144);
        if (this.nTS.containsKey(str)) {
            int intValue = ((Integer) this.nTS.get(str)).intValue();
            if (intValue >= 0 && this.nTT.containsKey(Integer.valueOf(intValue)) && ((Boolean) this.nTT.get(Integer.valueOf(intValue))).booleanValue()) {
                this.nTR.play(intValue, 1.0f, 1.0f, 0, 0, 1.0f);
            }
        }
        AppMethodBeat.m2505o(42144);
    }
}

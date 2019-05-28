package com.tencent.p177mm.plugin.scanner.p502c;

import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.scanner.p502c.C13123a.C13124a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.worddetect.C24520a;

/* renamed from: com.tencent.mm.plugin.scanner.c.b */
public final class C16847b implements LifecycleObserver, C13123a<String, Integer> {
    private MMActivity hwd;
    private MutableLiveData<Pair<String, Integer>> qiT = new MutableLiveData();

    /* renamed from: a */
    public final /* synthetic */ void mo25149a(Object obj, final C13124a c13124a) {
        AppMethodBeat.m2504i(138723);
        final String str = (String) obj;
        if (!this.qiT.hasObservers()) {
            this.qiT.observe(this.hwd, new Observer<Pair<String, Integer>>() {
                public final /* synthetic */ void onChanged(Object obj) {
                    AppMethodBeat.m2504i(138718);
                    Pair pair = (Pair) obj;
                    if (!(c13124a == null || pair == null || ((Integer) pair.second).intValue() == 0)) {
                        c13124a.mo25150y(pair.first, pair.second);
                    }
                    AppMethodBeat.m2505o(138718);
                }
            });
        }
        C7305d.xDG.mo10151b(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(138719);
                C16847b.m25995a(C16847b.this, str, C24520a.m38147ci(C16847b.this.hwd, str));
                AppMethodBeat.m2505o(138719);
            }
        }, "ImageWordScanThread");
        AppMethodBeat.m2505o(138723);
    }

    public C16847b(MMActivity mMActivity) {
        AppMethodBeat.m2504i(138721);
        mMActivity.getLifecycle().addObserver(this);
        this.hwd = mMActivity;
        AppMethodBeat.m2505o(138721);
    }

    @OnLifecycleEvent(Event.ON_DESTROY)
    public final void onDestroy() {
        AppMethodBeat.m2504i(138722);
        this.hwd.getLifecycle().removeObserver(this);
        this.hwd = null;
        AppMethodBeat.m2505o(138722);
    }

    /* renamed from: a */
    static /* synthetic */ void m25995a(C16847b c16847b, final String str, final int i) {
        AppMethodBeat.m2504i(138724);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(138720);
                C16847b.this.qiT.setValue(new Pair(str, Integer.valueOf(i)));
                AppMethodBeat.m2505o(138720);
            }
        });
        AppMethodBeat.m2505o(138724);
    }
}

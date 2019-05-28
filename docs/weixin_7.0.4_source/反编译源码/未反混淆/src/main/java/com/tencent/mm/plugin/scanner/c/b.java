package com.tencent.mm.plugin.scanner.c;

import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.c.a.a;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.MMActivity;

public final class b implements LifecycleObserver, a<String, Integer> {
    private MMActivity hwd;
    private MutableLiveData<Pair<String, Integer>> qiT = new MutableLiveData();

    public final /* synthetic */ void a(Object obj, final a aVar) {
        AppMethodBeat.i(138723);
        final String str = (String) obj;
        if (!this.qiT.hasObservers()) {
            this.qiT.observe(this.hwd, new Observer<Pair<String, Integer>>() {
                public final /* synthetic */ void onChanged(Object obj) {
                    AppMethodBeat.i(138718);
                    Pair pair = (Pair) obj;
                    if (!(aVar == null || pair == null || ((Integer) pair.second).intValue() == 0)) {
                        aVar.y(pair.first, pair.second);
                    }
                    AppMethodBeat.o(138718);
                }
            });
        }
        d.xDG.b(new Runnable() {
            public final void run() {
                AppMethodBeat.i(138719);
                b.a(b.this, str, com.tencent.worddetect.a.ci(b.this.hwd, str));
                AppMethodBeat.o(138719);
            }
        }, "ImageWordScanThread");
        AppMethodBeat.o(138723);
    }

    public b(MMActivity mMActivity) {
        AppMethodBeat.i(138721);
        mMActivity.getLifecycle().addObserver(this);
        this.hwd = mMActivity;
        AppMethodBeat.o(138721);
    }

    @OnLifecycleEvent(Event.ON_DESTROY)
    public final void onDestroy() {
        AppMethodBeat.i(138722);
        this.hwd.getLifecycle().removeObserver(this);
        this.hwd = null;
        AppMethodBeat.o(138722);
    }

    static /* synthetic */ void a(b bVar, final String str, final int i) {
        AppMethodBeat.i(138724);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(138720);
                b.this.qiT.setValue(new Pair(str, Integer.valueOf(i)));
                AppMethodBeat.o(138720);
            }
        });
        AppMethodBeat.o(138724);
    }
}

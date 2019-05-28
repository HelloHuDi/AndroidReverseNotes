package com.tencent.mm.plugin.gif;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.a.f.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.r;
import java.lang.ref.WeakReference;

public class c {
    private static c not;
    f<String, WeakReference<e>> nou = new com.tencent.mm.memory.a.c(10);
    f<String, WeakReference<b>> nov = new com.tencent.mm.memory.a.c(new b<String, WeakReference<b>>() {
        public final /* synthetic */ void c(Object obj, Object obj2, Object obj3) {
            AppMethodBeat.i(62351);
            WeakReference weakReference = (WeakReference) obj2;
            if (weakReference != null) {
                b bVar = (b) weakReference.get();
                if (bVar != null && (bVar instanceof d)) {
                    ab.i("MicroMsg.GIF.MMAnimateDrawableCacheMgr", "recycle bitmap:%s", bVar.toString());
                    bVar.recycle();
                }
            }
            AppMethodBeat.o(62351);
        }
    });

    public c() {
        AppMethodBeat.i(62352);
        AppMethodBeat.o(62352);
    }

    public static synchronized c bFN() {
        c cVar;
        synchronized (c.class) {
            AppMethodBeat.i(62353);
            if (not == null) {
                synchronized (c.class) {
                    try {
                        if (not == null) {
                            not = new c();
                        }
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.o(62353);
                        }
                    }
                }
            }
            cVar = not;
            AppMethodBeat.o(62353);
        }
        return cVar;
    }

    public final b Ox(String str) {
        AppMethodBeat.i(62354);
        b bVar = null;
        if (this.nov.get(str) != null) {
            bVar = (b) ((WeakReference) this.nov.get(str)).get();
        }
        AppMethodBeat.o(62354);
        return bVar;
    }

    public final b eD(String str, String str2) {
        AppMethodBeat.i(62355);
        b bVar = null;
        if (this.nov.get(str) != null) {
            bVar = (b) ((WeakReference) this.nov.get(str)).get();
        }
        if (bVar == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (r.amp(str2)) {
                bVar = new h(str2);
            } else {
                bVar = new d(str2);
            }
            ab.d("MicroMsg.GIF.MMAnimateDrawableCacheMgr", "new MMAnimateDrawable use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            this.nov.put(str, new WeakReference(bVar));
        }
        AppMethodBeat.o(62355);
        return bVar;
    }

    public final b b(Resources resources, int i) {
        b bVar;
        AppMethodBeat.i(62356);
        if (this.nov.get(null) != null) {
            bVar = (b) ((WeakReference) this.nov.get(null)).get();
        } else {
            bVar = null;
        }
        if (bVar == null) {
            bVar = new d(resources, i);
            this.nov.put(null, new WeakReference(bVar));
        }
        AppMethodBeat.o(62356);
        return bVar;
    }

    public final b x(String str, byte[] bArr) {
        b bVar = null;
        AppMethodBeat.i(62357);
        if (bArr == null) {
            AppMethodBeat.o(62357);
        } else {
            if (this.nov.get(str) != null) {
                bVar = (b) ((WeakReference) this.nov.get(str)).get();
            }
            if (bVar == null) {
                if (r.bU(bArr) && ((PluginEmoji) g.M(PluginEmoji.class)).getEmojiMgr().bjX()) {
                    bVar = new h(bArr);
                } else {
                    bVar = new d(bArr);
                }
                this.nov.put(str, new WeakReference(bVar));
            }
            if (!bVar.isRunning()) {
                bVar.reset();
            }
            AppMethodBeat.o(62357);
        }
        return bVar;
    }
}

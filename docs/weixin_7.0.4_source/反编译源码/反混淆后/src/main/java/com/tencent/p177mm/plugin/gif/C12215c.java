package com.tencent.p177mm.plugin.gif;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.memory.p259a.C7598c;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.p178a.C1177f.C1175b;
import com.tencent.p177mm.plugin.emoji.PluginEmoji;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.plugin.gif.c */
public class C12215c {
    private static C12215c not;
    C1177f<String, WeakReference<C3273e>> nou = new C7598c(10);
    C1177f<String, WeakReference<C34323b>> nov = new C7598c(new C122141());

    /* renamed from: com.tencent.mm.plugin.gif.c$1 */
    class C122141 implements C1175b<String, WeakReference<C34323b>> {
        C122141() {
        }

        /* renamed from: c */
        public final /* synthetic */ void mo4401c(Object obj, Object obj2, Object obj3) {
            AppMethodBeat.m2504i(62351);
            WeakReference weakReference = (WeakReference) obj2;
            if (weakReference != null) {
                C34323b c34323b = (C34323b) weakReference.get();
                if (c34323b != null && (c34323b instanceof C3266d)) {
                    C4990ab.m7417i("MicroMsg.GIF.MMAnimateDrawableCacheMgr", "recycle bitmap:%s", c34323b.toString());
                    c34323b.recycle();
                }
            }
            AppMethodBeat.m2505o(62351);
        }
    }

    public C12215c() {
        AppMethodBeat.m2504i(62352);
        AppMethodBeat.m2505o(62352);
    }

    public static synchronized C12215c bFN() {
        C12215c c12215c;
        synchronized (C12215c.class) {
            AppMethodBeat.m2504i(62353);
            if (not == null) {
                synchronized (C12215c.class) {
                    try {
                        if (not == null) {
                            not = new C12215c();
                        }
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.m2505o(62353);
                        }
                    }
                }
            }
            c12215c = not;
            AppMethodBeat.m2505o(62353);
        }
        return c12215c;
    }

    /* renamed from: Ox */
    public final C34323b mo24058Ox(String str) {
        AppMethodBeat.m2504i(62354);
        C34323b c34323b = null;
        if (this.nov.get(str) != null) {
            c34323b = (C34323b) ((WeakReference) this.nov.get(str)).get();
        }
        AppMethodBeat.m2505o(62354);
        return c34323b;
    }

    /* renamed from: eD */
    public final C34323b mo24060eD(String str, String str2) {
        AppMethodBeat.m2504i(62355);
        C34323b c34323b = null;
        if (this.nov.get(str) != null) {
            c34323b = (C34323b) ((WeakReference) this.nov.get(str)).get();
        }
        if (c34323b == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (C5063r.amp(str2)) {
                c34323b = new C36775h(str2);
            } else {
                c34323b = new C3266d(str2);
            }
            C4990ab.m7411d("MicroMsg.GIF.MMAnimateDrawableCacheMgr", "new MMAnimateDrawable use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            this.nov.put(str, new WeakReference(c34323b));
        }
        AppMethodBeat.m2505o(62355);
        return c34323b;
    }

    /* renamed from: b */
    public final C34323b mo24059b(Resources resources, int i) {
        C34323b c34323b;
        AppMethodBeat.m2504i(62356);
        if (this.nov.get(null) != null) {
            c34323b = (C34323b) ((WeakReference) this.nov.get(null)).get();
        } else {
            c34323b = null;
        }
        if (c34323b == null) {
            c34323b = new C3266d(resources, i);
            this.nov.put(null, new WeakReference(c34323b));
        }
        AppMethodBeat.m2505o(62356);
        return c34323b;
    }

    /* renamed from: x */
    public final C34323b mo24061x(String str, byte[] bArr) {
        C34323b c34323b = null;
        AppMethodBeat.m2504i(62357);
        if (bArr == null) {
            AppMethodBeat.m2505o(62357);
        } else {
            if (this.nov.get(str) != null) {
                c34323b = (C34323b) ((WeakReference) this.nov.get(str)).get();
            }
            if (c34323b == null) {
                if (C5063r.m7679bU(bArr) && ((PluginEmoji) C1720g.m3530M(PluginEmoji.class)).getEmojiMgr().bjX()) {
                    c34323b = new C36775h(bArr);
                } else {
                    c34323b = new C3266d(bArr);
                }
                this.nov.put(str, new WeakReference(c34323b));
            }
            if (!c34323b.isRunning()) {
                c34323b.reset();
            }
            AppMethodBeat.m2505o(62357);
        }
        return c34323b;
    }
}

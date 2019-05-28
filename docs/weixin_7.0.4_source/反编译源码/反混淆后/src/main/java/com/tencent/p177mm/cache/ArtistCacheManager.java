package com.tencent.p177mm.cache;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.p1639ch.C45281a;
import com.tencent.p177mm.p226e.C1493a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.cache.ArtistCacheManager */
public class ArtistCacheManager extends BroadcastReceiver {
    private static ArtistCacheManager efi;
    public static HashMap<String, C18126a> efj = new HashMap();
    private static HashSet<C1493a> efk = new HashSet();
    public String efl;

    /* renamed from: com.tencent.mm.cache.ArtistCacheManager$1 */
    public class C181231 implements Runnable {
        public final void run() {
            AppMethodBeat.m2504i(116205);
            C45281a.asR(C6457e.evi);
            AppMethodBeat.m2505o(116205);
        }
    }

    /* renamed from: com.tencent.mm.cache.ArtistCacheManager$2 */
    class C181252 implements Runnable {
        C181252() {
        }

        public final void run() {
            AppMethodBeat.m2504i(116206);
            C45281a.asR(C6457e.evi);
            AppMethodBeat.m2505o(116206);
        }
    }

    /* renamed from: com.tencent.mm.cache.ArtistCacheManager$a */
    public class C18126a {
        public HashMap<C1493a, C18128d> efo = new HashMap();

        public C18126a() {
            AppMethodBeat.m2504i(116208);
            AppMethodBeat.m2505o(116208);
        }

        public final void clearAll() {
            AppMethodBeat.m2504i(116209);
            for (Entry value : this.efo.entrySet()) {
                ((C18128d) value.getValue()).onDestroy();
            }
            AppMethodBeat.m2505o(116209);
        }
    }

    static {
        AppMethodBeat.m2504i(116214);
        AppMethodBeat.m2505o(116214);
    }

    /* renamed from: Jc */
    public static ArtistCacheManager m28552Jc() {
        AppMethodBeat.m2504i(116210);
        if (efi == null) {
            efi = new ArtistCacheManager();
        }
        ArtistCacheManager artistCacheManager = efi;
        AppMethodBeat.m2505o(116210);
        return artistCacheManager;
    }

    /* renamed from: a */
    public final <T extends C18128d> T mo33607a(C1493a c1493a) {
        C18128d c18128d = null;
        AppMethodBeat.m2504i(116211);
        if (efj.containsKey(this.efl)) {
            C18126a c18126a = (C18126a) efj.get(this.efl);
            if (!c18126a.efo.containsKey(c1493a)) {
                switch (c1493a) {
                    case DOODLE:
                        c18128d = new C26001b();
                        break;
                    case EMOJI_AND_TEXT:
                        c18128d = new C24666c();
                        break;
                    case MOSAIC:
                        c18128d = new C41920g();
                        break;
                    case CROP_PHOTO:
                        c18128d = new C41918a();
                        break;
                }
                if (c18128d != null) {
                    c18128d.onCreate();
                }
                if (!(c18128d == null || c18126a.efo.containsKey(c1493a))) {
                    c18126a.efo.put(c1493a, c18128d);
                }
            }
            C18128d c18128d2 = (C18128d) c18126a.efo.get(c1493a);
            AppMethodBeat.m2505o(116211);
            return c18128d2;
        }
        C4990ab.m7413e("MicroMsg.ArtistCacheManager", "[getArtistCache] id is not contains! %s", this.efl);
        AppMethodBeat.m2505o(116211);
        return null;
    }

    @Deprecated
    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.m2504i(116212);
        C4990ab.m7416i("MicroMsg.ArtistCacheManager", "[onReceive]");
        if (intent != null && intent.getAction().equals("com.tencent.mm.plugin.photoedit.action.clear")) {
            mo33606Jd();
        }
        AppMethodBeat.m2505o(116212);
    }

    /* renamed from: Jd */
    public final void mo33606Jd() {
        AppMethodBeat.m2504i(116213);
        C4990ab.m7416i("MicroMsg.ArtistCacheManager", "[clearAllCache]");
        for (Entry value : efj.entrySet()) {
            ((C18126a) value.getValue()).clearAll();
        }
        efk.clear();
        efi = null;
        C7305d.post(new C181252(), "MicroMsg.ArtistCacheManager[clearAllCache]");
        AppMethodBeat.m2505o(116213);
    }
}

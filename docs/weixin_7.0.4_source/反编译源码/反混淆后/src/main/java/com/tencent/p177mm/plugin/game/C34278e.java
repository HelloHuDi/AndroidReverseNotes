package com.tencent.p177mm.plugin.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.bucket.C18523a;
import com.tencent.p177mm.kernel.api.bucket.C26346d;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.plugin.game.model.C34303w;
import com.tencent.p177mm.plugin.game.model.C46012r;
import com.tencent.p177mm.plugin.game.model.p978a.C20990g;
import com.tencent.p177mm.plugin.game.p1268a.C45983c;
import com.tencent.p177mm.plugin.wepkg.p1076b.C35753b;
import com.tencent.p177mm.plugin.wepkg.p1076b.C44021f;
import com.tencent.p177mm.plugin.wepkg.p1076b.C46470d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.game.e */
public final class C34278e implements C18523a, C26346d, C45983c {
    private C46012r mTk;
    private C34303w mTl;
    private C20990g mTm;

    /* renamed from: com.tencent.mm.plugin.game.e$1 */
    class C121241 implements C1366d {
        C121241() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C46012r.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.e$6 */
    class C282016 implements C1366d {
        C282016() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C35753b.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.e$3 */
    class C342793 implements C1366d {
        C342793() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C20990g.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.e$5 */
    class C342805 implements C1366d {
        C342805() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C46470d.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.e$2 */
    class C342812 implements C1366d {
        C342812() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C34303w.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.e$4 */
    class C342824 implements C1366d {
        C342824() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C44021f.fnj;
        }
    }

    public final void onDataBaseOpened(C7480h c7480h, C7480h c7480h2) {
        AppMethodBeat.m2504i(111172);
        C4990ab.m7416i("MicroMsg.GameStorage", "GameStorage onDataBaseOpened");
        this.mTk = new C46012r(c7480h);
        this.mTm = new C20990g(c7480h);
        AppMethodBeat.m2505o(111172);
    }

    public final HashMap<Integer, C1366d> collectDatabaseFactory() {
        AppMethodBeat.m2504i(111173);
        C4990ab.m7416i("MicroMsg.GameStorage", "GameStorage collectDatabaseFactory");
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf("GAME_CENTER_MSG_INFO_TABLE".hashCode()), new C121241());
        hashMap.put(Integer.valueOf("GAME_CENTER_PB_CACHE_TABLE".hashCode()), new C342812());
        hashMap.put(Integer.valueOf("GAME_CENTER_SILENT_DOWNLOAD_TABLE".hashCode()), new C342793());
        hashMap.put(Integer.valueOf("CHECK_WEPKG_VERSION".hashCode()), new C342824());
        hashMap.put(Integer.valueOf("WEPKG_PRELOAD_FILES".hashCode()), new C342805());
        hashMap.put(Integer.valueOf("WEPKG_DIFF_PACK".hashCode()), new C282016());
        AppMethodBeat.m2505o(111173);
        return hashMap;
    }

    public final void onDataBaseClosed(C7480h c7480h, C7480h c7480h2) {
    }

    public final C46012r bCY() {
        AppMethodBeat.m2504i(111174);
        C1720g.m3534RN().mo5159QU();
        if (this.mTk == null) {
            C1720g.m3537RQ();
            this.mTk = new C46012r(C1720g.m3536RP().eJN);
        }
        C46012r c46012r = this.mTk;
        AppMethodBeat.m2505o(111174);
        return c46012r;
    }

    public final C34303w bCZ() {
        AppMethodBeat.m2504i(111175);
        C1720g.m3534RN().mo5159QU();
        if (this.mTl == null) {
            C1720g.m3537RQ();
            this.mTl = new C34303w(C1720g.m3536RP().eJN);
        }
        C34303w c34303w = this.mTl;
        AppMethodBeat.m2505o(111175);
        return c34303w;
    }

    public final C20990g bDa() {
        AppMethodBeat.m2504i(111176);
        C1720g.m3534RN().mo5159QU();
        if (this.mTm == null) {
            C1720g.m3537RQ();
            this.mTm = new C20990g(C1720g.m3536RP().eJN);
        }
        C20990g c20990g = this.mTm;
        AppMethodBeat.m2505o(111176);
        return c20990g;
    }
}

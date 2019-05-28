package com.tencent.p177mm.booter.cache;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.cache.C18131f.C1346a;
import com.tencent.p177mm.cache.MCacheItem;
import com.tencent.p177mm.memory.p259a.C26399b;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.platformtools.p1386a.C26523a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5066u;

/* renamed from: com.tencent.mm.booter.cache.a */
public final class C25973a extends C1346a {
    public static C25973a edm;
    private final C1177f<String, Bitmap> edn;

    private C25973a() {
        String str;
        AppMethodBeat.m2504i(15884);
        Context context = C4996ah.getContext();
        String str2 = "BACKGROUND_BITMAP_CACHE_LIMIT";
        if (C26523a.values == null) {
            try {
                C26523a.values = C5066u.amt(C5046bo.convertStreamToString(context.getAssets().open("profile.ini")));
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.ProfileUtil", "exception:%s", C5046bo.m7574l(e));
            }
        }
        if (C26523a.values == null) {
            str = null;
        } else {
            str = (String) C26523a.values.get(str2);
        }
        this.edn = new C26399b(C5046bo.getInt(str, 2000), getClass());
        AppMethodBeat.m2505o(15884);
    }

    public static void prepare() {
        AppMethodBeat.m2504i(15885);
        if (edm == null) {
            edm = new C25973a();
        }
        AppMethodBeat.m2505o(15885);
    }

    public static void destroy() {
        AppMethodBeat.m2504i(15886);
        if (edm == null) {
            AppMethodBeat.m2505o(15886);
            return;
        }
        edm.edn.clear();
        AppMethodBeat.m2505o(15886);
    }

    public final Bitmap getBitmap(String str) {
        AppMethodBeat.m2504i(15887);
        C4990ab.m7419v("MicroMsg.MMCacheImpl", "getting bitmap: %s", str);
        Bitmap bitmap = (Bitmap) this.edn.get(str);
        AppMethodBeat.m2505o(15887);
        return bitmap;
    }

    /* renamed from: jM */
    public final MCacheItem mo33625jM(String str) {
        AppMethodBeat.m2504i(15888);
        C4990ab.m7419v("MicroMsg.MMCacheImpl", "getting cache item: %s", str);
        AppMethodBeat.m2505o(15888);
        return null;
    }

    /* renamed from: b */
    public final void mo33623b(String str, Bitmap bitmap) {
        AppMethodBeat.m2504i(15889);
        C4990ab.m7419v("MicroMsg.MMCacheImpl", "setting bitmap: %s", str);
        this.edn.mo4412k(str, bitmap);
        AppMethodBeat.m2505o(15889);
    }

    /* renamed from: jN */
    public final void mo33626jN(String str) {
        AppMethodBeat.m2504i(15890);
        C4990ab.m7419v("MicroMsg.MMCacheImpl", "setting cache item: %s", str);
        AppMethodBeat.m2505o(15890);
    }
}

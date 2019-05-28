package com.tencent.mm.booter.cache;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.cache.MCacheItem;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.u;

public final class a extends com.tencent.mm.cache.f.a {
    public static a edm;
    private final f<String, Bitmap> edn;

    private a() {
        String str;
        AppMethodBeat.i(15884);
        Context context = ah.getContext();
        String str2 = "BACKGROUND_BITMAP_CACHE_LIMIT";
        if (com.tencent.mm.platformtools.a.a.values == null) {
            try {
                com.tencent.mm.platformtools.a.a.values = u.amt(bo.convertStreamToString(context.getAssets().open("profile.ini")));
            } catch (Exception e) {
                ab.e("MicroMsg.ProfileUtil", "exception:%s", bo.l(e));
            }
        }
        if (com.tencent.mm.platformtools.a.a.values == null) {
            str = null;
        } else {
            str = (String) com.tencent.mm.platformtools.a.a.values.get(str2);
        }
        this.edn = new b(bo.getInt(str, 2000), getClass());
        AppMethodBeat.o(15884);
    }

    public static void prepare() {
        AppMethodBeat.i(15885);
        if (edm == null) {
            edm = new a();
        }
        AppMethodBeat.o(15885);
    }

    public static void destroy() {
        AppMethodBeat.i(15886);
        if (edm == null) {
            AppMethodBeat.o(15886);
            return;
        }
        edm.edn.clear();
        AppMethodBeat.o(15886);
    }

    public final Bitmap getBitmap(String str) {
        AppMethodBeat.i(15887);
        ab.v("MicroMsg.MMCacheImpl", "getting bitmap: %s", str);
        Bitmap bitmap = (Bitmap) this.edn.get(str);
        AppMethodBeat.o(15887);
        return bitmap;
    }

    public final MCacheItem jM(String str) {
        AppMethodBeat.i(15888);
        ab.v("MicroMsg.MMCacheImpl", "getting cache item: %s", str);
        AppMethodBeat.o(15888);
        return null;
    }

    public final void b(String str, Bitmap bitmap) {
        AppMethodBeat.i(15889);
        ab.v("MicroMsg.MMCacheImpl", "setting bitmap: %s", str);
        this.edn.k(str, bitmap);
        AppMethodBeat.o(15889);
    }

    public final void jN(String str) {
        AppMethodBeat.i(15890);
        ab.v("MicroMsg.MMCacheImpl", "setting cache item: %s", str);
        AppMethodBeat.o(15890);
    }
}

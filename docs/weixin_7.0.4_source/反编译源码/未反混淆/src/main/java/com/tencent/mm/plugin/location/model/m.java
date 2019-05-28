package com.tencent.mm.plugin.location.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.bv.a.a;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class m implements a {
    private Bitmap jMX = null;
    private f<String, Bitmap> nKC = new b(20, getClass());

    public m() {
        AppMethodBeat.i(113375);
        AppMethodBeat.o(113375);
    }

    public final synchronized Bitmap PO(String str) {
        Bitmap bitmap;
        AppMethodBeat.i(113376);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(113376);
            bitmap = null;
        } else {
            ab.d("MicroMsg.TrackAvatarCacheService", "getAvatar, tag = %s, cacheSize = %d", str, Integer.valueOf(this.nKC.size()));
            bitmap = (Bitmap) this.nKC.get(str);
            if (bitmap == null || bitmap.isRecycled()) {
                AppMethodBeat.o(113376);
                bitmap = null;
            } else {
                AppMethodBeat.o(113376);
            }
        }
        return bitmap;
    }

    public final synchronized void p(String str, Bitmap bitmap) {
        AppMethodBeat.i(113377);
        if (this.nKC.get(str) != null) {
            Bitmap bitmap2 = (Bitmap) this.nKC.get(str);
            if (!bitmap2.isRecycled()) {
                ab.i("MicroMsg.TrackAvatarCacheService", "bitmap recycle %s", bitmap2.toString());
                bitmap2.recycle();
            }
            this.nKC.remove(str);
        }
        this.nKC.put(str, bitmap);
        ab.d("MicroMsg.TrackAvatarCacheService", "updateCache, tag = %s, cacheSize = %d", str, Integer.valueOf(this.nKC.size()));
        AppMethodBeat.o(113377);
    }

    public final synchronized void Dp(String str) {
        AppMethodBeat.i(113378);
        ab.d("MicroMsg.TrackAvatarCacheService", "clearCache, tag = %s", str);
        for (String str2 : this.nKC.snapshot().keySet()) {
            if (str2.startsWith(str)) {
                this.nKC.remove(str2);
            }
        }
        AppMethodBeat.o(113378);
    }
}

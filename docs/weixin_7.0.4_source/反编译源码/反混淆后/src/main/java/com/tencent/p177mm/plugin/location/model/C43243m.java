package com.tencent.p177mm.plugin.location.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.memory.p259a.C26399b;
import com.tencent.p177mm.p1376bv.p1377a.C32428a;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.location.model.m */
public final class C43243m implements C32428a {
    private Bitmap jMX = null;
    private C1177f<String, Bitmap> nKC = new C26399b(20, getClass());

    public C43243m() {
        AppMethodBeat.m2504i(113375);
        AppMethodBeat.m2505o(113375);
    }

    /* renamed from: PO */
    public final synchronized Bitmap mo53069PO(String str) {
        Bitmap bitmap;
        AppMethodBeat.m2504i(113376);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(113376);
            bitmap = null;
        } else {
            C4990ab.m7411d("MicroMsg.TrackAvatarCacheService", "getAvatar, tag = %s, cacheSize = %d", str, Integer.valueOf(this.nKC.size()));
            bitmap = (Bitmap) this.nKC.get(str);
            if (bitmap == null || bitmap.isRecycled()) {
                AppMethodBeat.m2505o(113376);
                bitmap = null;
            } else {
                AppMethodBeat.m2505o(113376);
            }
        }
        return bitmap;
    }

    /* renamed from: p */
    public final synchronized void mo53070p(String str, Bitmap bitmap) {
        AppMethodBeat.m2504i(113377);
        if (this.nKC.get(str) != null) {
            Bitmap bitmap2 = (Bitmap) this.nKC.get(str);
            if (!bitmap2.isRecycled()) {
                C4990ab.m7417i("MicroMsg.TrackAvatarCacheService", "bitmap recycle %s", bitmap2.toString());
                bitmap2.recycle();
            }
            this.nKC.remove(str);
        }
        this.nKC.put(str, bitmap);
        C4990ab.m7411d("MicroMsg.TrackAvatarCacheService", "updateCache, tag = %s, cacheSize = %d", str, Integer.valueOf(this.nKC.size()));
        AppMethodBeat.m2505o(113377);
    }

    /* renamed from: Dp */
    public final synchronized void mo53068Dp(String str) {
        AppMethodBeat.m2504i(113378);
        C4990ab.m7411d("MicroMsg.TrackAvatarCacheService", "clearCache, tag = %s", str);
        for (String str2 : this.nKC.snapshot().keySet()) {
            if (str2.startsWith(str)) {
                this.nKC.remove(str2);
            }
        }
        AppMethodBeat.m2505o(113378);
    }
}

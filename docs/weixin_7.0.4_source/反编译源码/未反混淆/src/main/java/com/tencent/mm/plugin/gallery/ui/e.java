package com.tencent.mm.plugin.gallery.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.sdk.platformtools.bo;

final class e {
    int aaF = -1;
    private c mQS;

    public e(c cVar) {
        this.mQS = cVar;
    }

    /* Access modifiers changed, original: final */
    public final void wB(int i) {
        AppMethodBeat.i(21496);
        c cVar = this.mQS;
        if (cVar.mOH == null || cVar.mOH.size() <= i || i < 0) {
            AppMethodBeat.o(21496);
            return;
        }
        long j = ((MediaItem) cVar.mOH.get(i)).mOk;
        String str = ((MediaItem) cVar.mOH.get(i)).lZg;
        String str2 = ((MediaItem) cVar.mOH.get(i)).fPT;
        if (bo.isNullOrNil(str)) {
            str = str2;
        }
        com.tencent.mm.plugin.gallery.model.e.bBY().b(str, ((MediaItem) cVar.mOH.get(i)).getType(), str2, j);
        AppMethodBeat.o(21496);
    }
}

package com.tencent.mm.view.d;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.c.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;
import java.util.Map.Entry;

public final class a implements m {
    private com.tencent.mm.at.a.d.a<String, Bitmap> Ado = new com.tencent.mm.at.a.d.a(150);

    public a() {
        AppMethodBeat.i(63019);
        AppMethodBeat.o(63019);
    }

    public final Bitmap kR(String str) {
        AppMethodBeat.i(63020);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(63020);
            return null;
        }
        Bitmap bitmap = (Bitmap) this.Ado.get(str);
        AppMethodBeat.o(63020);
        return bitmap;
    }

    public final void c(String str, Bitmap bitmap) {
        AppMethodBeat.i(63021);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.emoji.EmojiLoaderMemoryCache", "[cpan] put failed. key is null.");
            AppMethodBeat.o(63021);
        } else if (bitmap == null) {
            ab.w("MicroMsg.emoji.EmojiLoaderMemoryCache", "[cpan] put failed.value is null.");
            AppMethodBeat.o(63021);
        } else {
            this.Ado.put(str, bitmap);
            AppMethodBeat.o(63021);
        }
    }

    public final void clear() {
        AppMethodBeat.i(63022);
        synchronized (this) {
            try {
                if (this.Ado != null) {
                    Map snapshot = this.Ado.snapshot();
                    if (!snapshot.isEmpty() && snapshot.size() > 0) {
                        for (Entry value : snapshot.entrySet()) {
                            Bitmap bitmap = (Bitmap) value.getValue();
                            if (!(bitmap == null || bitmap.isRecycled())) {
                                ab.i("MicroMsg.emoji.EmojiLoaderMemoryCache", "recycle bitmap:%s, not need", bitmap.toString());
                            }
                        }
                    }
                    com.tencent.mm.at.a.d.a aVar = this.Ado;
                    if (aVar.eRT == null) {
                        Object nullPointerException = new NullPointerException("mData == null");
                        throw nullPointerException;
                    }
                    aVar.eRT.trimToSize(-1);
                }
            } finally {
                AppMethodBeat.o(63022);
            }
        }
        AppMethodBeat.o(63022);
    }
}

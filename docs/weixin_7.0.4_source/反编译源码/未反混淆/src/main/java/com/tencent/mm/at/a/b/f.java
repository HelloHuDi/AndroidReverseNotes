package com.tencent.mm.at.a.b;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.c.m;
import com.tencent.mm.hardcoder.i;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;
import java.util.Map.Entry;

public final class f implements m {
    private com.tencent.mm.a.f<String, Bitmap> fHm = new b(50, getClass());
    private com.tencent.mm.a.f<String, Bitmap> fHn = new b(10, getClass());

    public f() {
        AppMethodBeat.i(116089);
        AppMethodBeat.o(116089);
    }

    public final Bitmap kR(String str) {
        AppMethodBeat.i(116090);
        Bitmap bitmap;
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(116090);
            return null;
        } else if (this.fHm.get(str) == null) {
            bitmap = (Bitmap) this.fHn.get(str);
            AppMethodBeat.o(116090);
            return bitmap;
        } else {
            bitmap = (Bitmap) this.fHm.get(str);
            AppMethodBeat.o(116090);
            return bitmap;
        }
    }

    public final void c(String str, Bitmap bitmap) {
        AppMethodBeat.i(116091);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "[cpan] put failed. key is null.");
            AppMethodBeat.o(116091);
        } else if (bitmap == null) {
            ab.w("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "[cpan] put failed.value is null.");
            AppMethodBeat.o(116091);
        } else {
            long j;
            if (bitmap == null || !(bitmap instanceof Bitmap)) {
                j = 0;
            } else {
                Bitmap bitmap2 = bitmap;
                if (VERSION.SDK_INT >= 12) {
                    j = (long) bitmap2.getByteCount();
                } else {
                    j = (long) (bitmap2.getHeight() * bitmap2.getRowBytes());
                }
            }
            ab.d("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "[cpan] put key:%s,bitmap size:%d B newsize:%s", str, Long.valueOf(j), bo.ga(j));
            if (j > i.ACTION_MINI_PROGRAM_LAUNCH) {
                this.fHn.put(str, bitmap);
                AppMethodBeat.o(116091);
                return;
            }
            this.fHm.put(str, bitmap);
            AppMethodBeat.o(116091);
        }
    }

    public final void clear() {
        AppMethodBeat.i(116092);
        synchronized (this) {
            try {
                Map snapshot;
                Bitmap bitmap;
                if (this.fHm != null) {
                    snapshot = this.fHm.snapshot();
                    if (!snapshot.isEmpty() && snapshot.size() > 0) {
                        for (Entry value : snapshot.entrySet()) {
                            bitmap = (Bitmap) value.getValue();
                            if (!(bitmap == null || bitmap.isRecycled())) {
                                ab.i("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "recycle bitmap:%s, not need", bitmap.toString());
                            }
                        }
                    }
                    this.fHm.clear();
                }
                if (this.fHn != null) {
                    snapshot = this.fHn.snapshot();
                    if (!snapshot.isEmpty() && snapshot.size() > 0) {
                        for (Entry value2 : snapshot.entrySet()) {
                            bitmap = (Bitmap) value2.getValue();
                            if (!(bitmap == null || bitmap.isRecycled())) {
                                ab.i("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "recycle bitmap:%s. not need", bitmap.toString());
                            }
                        }
                    }
                    this.fHn.clear();
                }
            } finally {
                AppMethodBeat.o(116092);
            }
        }
    }
}

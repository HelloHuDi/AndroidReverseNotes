package com.tencent.p177mm.p190at.p191a.p192b;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.p177mm.memory.p259a.C26399b;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.p190at.p191a.p193c.C32283m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.at.a.b.f */
public final class C37473f implements C32283m {
    private C1177f<String, Bitmap> fHm = new C26399b(50, getClass());
    private C1177f<String, Bitmap> fHn = new C26399b(10, getClass());

    public C37473f() {
        AppMethodBeat.m2504i(116089);
        AppMethodBeat.m2505o(116089);
    }

    /* renamed from: kR */
    public final Bitmap mo52991kR(String str) {
        AppMethodBeat.m2504i(116090);
        Bitmap bitmap;
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(116090);
            return null;
        } else if (this.fHm.get(str) == null) {
            bitmap = (Bitmap) this.fHn.get(str);
            AppMethodBeat.m2505o(116090);
            return bitmap;
        } else {
            bitmap = (Bitmap) this.fHm.get(str);
            AppMethodBeat.m2505o(116090);
            return bitmap;
        }
    }

    /* renamed from: c */
    public final void mo52989c(String str, Bitmap bitmap) {
        AppMethodBeat.m2504i(116091);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "[cpan] put failed. key is null.");
            AppMethodBeat.m2505o(116091);
        } else if (bitmap == null) {
            C4990ab.m7420w("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "[cpan] put failed.value is null.");
            AppMethodBeat.m2505o(116091);
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
            C4990ab.m7411d("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "[cpan] put key:%s,bitmap size:%d B newsize:%s", str, Long.valueOf(j), C5046bo.m7565ga(j));
            if (j > C1625i.ACTION_MINI_PROGRAM_LAUNCH) {
                this.fHn.put(str, bitmap);
                AppMethodBeat.m2505o(116091);
                return;
            }
            this.fHm.put(str, bitmap);
            AppMethodBeat.m2505o(116091);
        }
    }

    public final void clear() {
        AppMethodBeat.m2504i(116092);
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
                                C4990ab.m7417i("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "recycle bitmap:%s, not need", bitmap.toString());
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
                                C4990ab.m7417i("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "recycle bitmap:%s. not need", bitmap.toString());
                            }
                        }
                    }
                    this.fHn.clear();
                }
            } finally {
                AppMethodBeat.m2505o(116092);
            }
        }
    }
}

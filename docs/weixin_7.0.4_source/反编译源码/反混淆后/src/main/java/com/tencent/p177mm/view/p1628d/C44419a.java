package com.tencent.p177mm.view.p1628d;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p190at.p191a.p1527d.C45159a;
import com.tencent.p177mm.p190at.p191a.p193c.C32283m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.view.d.a */
public final class C44419a implements C32283m {
    private C45159a<String, Bitmap> Ado = new C45159a(150);

    public C44419a() {
        AppMethodBeat.m2504i(63019);
        AppMethodBeat.m2505o(63019);
    }

    /* renamed from: kR */
    public final Bitmap mo52991kR(String str) {
        AppMethodBeat.m2504i(63020);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(63020);
            return null;
        }
        Bitmap bitmap = (Bitmap) this.Ado.get(str);
        AppMethodBeat.m2505o(63020);
        return bitmap;
    }

    /* renamed from: c */
    public final void mo52989c(String str, Bitmap bitmap) {
        AppMethodBeat.m2504i(63021);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.emoji.EmojiLoaderMemoryCache", "[cpan] put failed. key is null.");
            AppMethodBeat.m2505o(63021);
        } else if (bitmap == null) {
            C4990ab.m7420w("MicroMsg.emoji.EmojiLoaderMemoryCache", "[cpan] put failed.value is null.");
            AppMethodBeat.m2505o(63021);
        } else {
            this.Ado.put(str, bitmap);
            AppMethodBeat.m2505o(63021);
        }
    }

    public final void clear() {
        AppMethodBeat.m2504i(63022);
        synchronized (this) {
            try {
                if (this.Ado != null) {
                    Map snapshot = this.Ado.snapshot();
                    if (!snapshot.isEmpty() && snapshot.size() > 0) {
                        for (Entry value : snapshot.entrySet()) {
                            Bitmap bitmap = (Bitmap) value.getValue();
                            if (!(bitmap == null || bitmap.isRecycled())) {
                                C4990ab.m7417i("MicroMsg.emoji.EmojiLoaderMemoryCache", "recycle bitmap:%s, not need", bitmap.toString());
                            }
                        }
                    }
                    C45159a c45159a = this.Ado;
                    if (c45159a.eRT == null) {
                        Object nullPointerException = new NullPointerException("mData == null");
                        throw nullPointerException;
                    }
                    c45159a.eRT.trimToSize(-1);
                }
            } finally {
                AppMethodBeat.m2505o(63022);
            }
        }
        AppMethodBeat.m2505o(63022);
    }
}

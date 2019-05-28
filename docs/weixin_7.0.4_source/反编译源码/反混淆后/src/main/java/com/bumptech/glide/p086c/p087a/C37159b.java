package com.bumptech.glide.p086c.p087a;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.C37192g;
import com.bumptech.glide.p086c.C25405a;
import com.bumptech.glide.p086c.p087a.C0742d.C0743a;
import java.io.IOException;

/* renamed from: com.bumptech.glide.c.a.b */
public abstract class C37159b<T> implements C0742d<T> {
    private final String azi;
    private final AssetManager azj;
    private T data;

    /* renamed from: R */
    public abstract void mo18606R(T t);

    /* renamed from: a */
    public abstract T mo18607a(AssetManager assetManager, String str);

    public C37159b(AssetManager assetManager, String str) {
        this.azj = assetManager;
        this.azi = str;
    }

    /* renamed from: a */
    public final void mo2184a(C37192g c37192g, C0743a<? super T> c0743a) {
        try {
            this.data = mo18607a(this.azj, this.azi);
            c0743a.mo2189S(this.data);
        } catch (IOException e) {
            Log.isLoggable("AssetPathFetcher", 3);
            c0743a.mo2190b(e);
        }
    }

    public final void cleanup() {
        if (this.data != null) {
            try {
                mo18606R(this.data);
            } catch (IOException e) {
            }
        }
    }

    public final void cancel() {
    }

    /* renamed from: mh */
    public final C25405a mo2188mh() {
        return C25405a.LOCAL;
    }
}

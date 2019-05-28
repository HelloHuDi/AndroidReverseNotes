package com.bumptech.glide.c.a;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.c.a.d.a;
import com.bumptech.glide.g;
import java.io.IOException;

public abstract class b<T> implements d<T> {
    private final String azi;
    private final AssetManager azj;
    private T data;

    public abstract void R(T t);

    public abstract T a(AssetManager assetManager, String str);

    public b(AssetManager assetManager, String str) {
        this.azj = assetManager;
        this.azi = str;
    }

    public final void a(g gVar, a<? super T> aVar) {
        try {
            this.data = a(this.azj, this.azi);
            aVar.S(this.data);
        } catch (IOException e) {
            Log.isLoggable("AssetPathFetcher", 3);
            aVar.b(e);
        }
    }

    public final void cleanup() {
        if (this.data != null) {
            try {
                R(this.data);
            } catch (IOException e) {
            }
        }
    }

    public final void cancel() {
    }

    public final com.bumptech.glide.c.a mh() {
        return com.bumptech.glide.c.a.LOCAL;
    }
}

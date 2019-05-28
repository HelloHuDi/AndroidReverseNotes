package com.bumptech.glide.c.a;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.c.a.d.a;
import com.bumptech.glide.g;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class l<T> implements d<T> {
    private final ContentResolver azy;
    private T data;
    private final Uri uri;

    public abstract void R(T t);

    public abstract T a(Uri uri, ContentResolver contentResolver);

    public l(ContentResolver contentResolver, Uri uri) {
        this.azy = contentResolver;
        this.uri = uri;
    }

    public final void a(g gVar, a<? super T> aVar) {
        try {
            this.data = a(this.uri, this.azy);
            aVar.S(this.data);
        } catch (FileNotFoundException e) {
            Log.isLoggable("LocalUriFetcher", 3);
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

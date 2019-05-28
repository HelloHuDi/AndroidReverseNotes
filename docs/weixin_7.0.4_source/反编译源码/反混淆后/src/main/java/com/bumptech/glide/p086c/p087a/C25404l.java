package com.bumptech.glide.p086c.p087a;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.C37192g;
import com.bumptech.glide.p086c.C25405a;
import com.bumptech.glide.p086c.p087a.C0742d.C0743a;
import java.io.FileNotFoundException;
import java.io.IOException;

/* renamed from: com.bumptech.glide.c.a.l */
public abstract class C25404l<T> implements C0742d<T> {
    private final ContentResolver azy;
    private T data;
    private final Uri uri;

    /* renamed from: R */
    public abstract void mo42446R(T t);

    /* renamed from: a */
    public abstract T mo42447a(Uri uri, ContentResolver contentResolver);

    public C25404l(ContentResolver contentResolver, Uri uri) {
        this.azy = contentResolver;
        this.uri = uri;
    }

    /* renamed from: a */
    public final void mo2184a(C37192g c37192g, C0743a<? super T> c0743a) {
        try {
            this.data = mo42447a(this.uri, this.azy);
            c0743a.mo2189S(this.data);
        } catch (FileNotFoundException e) {
            Log.isLoggable("LocalUriFetcher", 3);
            c0743a.mo2190b(e);
        }
    }

    public final void cleanup() {
        if (this.data != null) {
            try {
                mo42446R(this.data);
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

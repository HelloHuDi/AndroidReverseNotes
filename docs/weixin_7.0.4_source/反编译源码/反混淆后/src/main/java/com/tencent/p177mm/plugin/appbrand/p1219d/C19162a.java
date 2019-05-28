package com.tencent.p177mm.plugin.appbrand.p1219d;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.luggage.p1170a.C25681b;

/* renamed from: com.tencent.mm.plugin.appbrand.d.a */
public interface C19162a extends C25681b {

    /* renamed from: com.tencent.mm.plugin.appbrand.d.a$a */
    public interface C19163a {
        /* renamed from: Q */
        void mo34404Q(byte[] bArr);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.d.a$c */
    public interface C19164c {
        /* renamed from: E */
        void mo34405E(Bitmap bitmap);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.d.a$b */
    public interface C19165b {
        /* renamed from: a */
        void mo22117a(String str, C19163a c19163a);

        /* renamed from: b */
        Bitmap mo22119b(String str, Rect rect, C19164c c19164c);

        boolean match(String str);

        /* renamed from: wP */
        String mo22122wP();
    }

    /* renamed from: a */
    Bitmap mo34401a(String str, Rect rect, C19164c c19164c);

    /* renamed from: a */
    void mo34402a(String str, C19163a c19163a);

    /* renamed from: bB */
    Bitmap mo34403bB(String str);
}

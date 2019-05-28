package com.bumptech.glide.p086c;

import com.bumptech.glide.p086c.p088b.p089a.C8515b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* renamed from: com.bumptech.glide.c.f */
public interface C0776f {

    /* renamed from: com.bumptech.glide.c.f$a */
    public enum C0777a {
        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        UNKNOWN(false);
        
        public final boolean aza;

        static {
            AppMethodBeat.m2505o(91676);
        }

        private C0777a(boolean z) {
            this.aza = z;
        }
    }

    /* renamed from: a */
    int mo2239a(InputStream inputStream, C8515b c8515b);

    /* renamed from: b */
    C0777a mo2240b(ByteBuffer byteBuffer);

    /* renamed from: c */
    C0777a mo2241c(InputStream inputStream);
}

package com.bumptech.glide.c;

import com.bumptech.glide.c.b.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.nio.ByteBuffer;

public interface f {

    public enum a {
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
            AppMethodBeat.o(91676);
        }

        private a(boolean z) {
            this.aza = z;
        }
    }

    int a(InputStream inputStream, b bVar);

    a b(ByteBuffer byteBuffer);

    a c(InputStream inputStream);
}

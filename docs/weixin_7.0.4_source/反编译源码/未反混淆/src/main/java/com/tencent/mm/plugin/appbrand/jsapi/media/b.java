package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public interface b extends com.tencent.luggage.a.b {
    public static final b hOQ = new b() {
        public final Bitmap decodeFile(String str, Options options) {
            AppMethodBeat.i(114351);
            Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
            AppMethodBeat.o(114351);
            return decodeFile;
        }

        public final Bitmap b(InputStream inputStream, Options options) {
            AppMethodBeat.i(114352);
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
            AppMethodBeat.o(114352);
            return decodeStream;
        }
    };

    public static class a {
        public static b a(b bVar) {
            return bVar == null ? b.hOQ : bVar;
        }
    }

    Bitmap b(InputStream inputStream, Options options);

    Bitmap decodeFile(String str, Options options);
}

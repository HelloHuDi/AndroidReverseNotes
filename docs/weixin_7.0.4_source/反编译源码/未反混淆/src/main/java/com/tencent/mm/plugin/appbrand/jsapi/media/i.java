package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import java.io.InputStream;

public final class i implements b {
    public static final i hQA = new i();

    static {
        AppMethodBeat.i(131322);
        AppMethodBeat.o(131322);
    }

    public final Bitmap decodeFile(String str, Options options) {
        AppMethodBeat.i(131320);
        Bitmap decodeFile = MMBitmapFactory.decodeFile(str, options);
        AppMethodBeat.o(131320);
        return decodeFile;
    }

    public final Bitmap b(InputStream inputStream, Options options) {
        AppMethodBeat.i(131321);
        Bitmap decodeStream = MMBitmapFactory.decodeStream(inputStream, null, options);
        AppMethodBeat.o(131321);
        return decodeStream;
    }
}

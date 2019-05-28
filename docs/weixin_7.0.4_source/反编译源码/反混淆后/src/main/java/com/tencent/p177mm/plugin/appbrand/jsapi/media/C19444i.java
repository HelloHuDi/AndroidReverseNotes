package com.tencent.p177mm.plugin.appbrand.jsapi.media;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.graphics.MMBitmapFactory;
import java.io.InputStream;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.i */
public final class C19444i implements C31304b {
    public static final C19444i hQA = new C19444i();

    static {
        AppMethodBeat.m2504i(131322);
        AppMethodBeat.m2505o(131322);
    }

    public final Bitmap decodeFile(String str, Options options) {
        AppMethodBeat.m2504i(131320);
        Bitmap decodeFile = MMBitmapFactory.decodeFile(str, options);
        AppMethodBeat.m2505o(131320);
        return decodeFile;
    }

    /* renamed from: b */
    public final Bitmap mo21986b(InputStream inputStream, Options options) {
        AppMethodBeat.m2504i(131321);
        Bitmap decodeStream = MMBitmapFactory.decodeStream(inputStream, null, options);
        AppMethodBeat.m2505o(131321);
        return decodeStream;
    }
}

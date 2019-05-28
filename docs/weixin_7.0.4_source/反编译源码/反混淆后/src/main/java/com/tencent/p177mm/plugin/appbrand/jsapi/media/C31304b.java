package com.tencent.p177mm.plugin.appbrand.jsapi.media;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.luggage.p1170a.C25681b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.b */
public interface C31304b extends C25681b {
    public static final C31304b hOQ = new C104781();

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.b$1 */
    static class C104781 implements C31304b {
        C104781() {
        }

        public final Bitmap decodeFile(String str, Options options) {
            AppMethodBeat.m2504i(114351);
            Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
            AppMethodBeat.m2505o(114351);
            return decodeFile;
        }

        /* renamed from: b */
        public final Bitmap mo21986b(InputStream inputStream, Options options) {
            AppMethodBeat.m2504i(114352);
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
            AppMethodBeat.m2505o(114352);
            return decodeStream;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.b$a */
    public static class C31305a {
        /* renamed from: a */
        public static C31304b m50560a(C31304b c31304b) {
            return c31304b == null ? C31304b.hOQ : c31304b;
        }
    }

    /* renamed from: b */
    Bitmap mo21986b(InputStream inputStream, Options options);

    Bitmap decodeFile(String str, Options options);
}

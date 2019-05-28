package com.bumptech.glide.p086c.p092d.p788e;

import android.util.Log;
import com.bumptech.glide.p086c.C0776f;
import com.bumptech.glide.p086c.C0776f.C0777a;
import com.bumptech.glide.p086c.C0778g;
import com.bumptech.glide.p086c.C31967j;
import com.bumptech.glide.p086c.C31968k;
import com.bumptech.glide.p086c.p088b.C17526u;
import com.bumptech.glide.p086c.p088b.p089a.C8515b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* renamed from: com.bumptech.glide.c.d.e.j */
public final class C37187j implements C31968k<InputStream, C37186c> {
    private final C31968k<ByteBuffer, C37186c> aGo;
    private final List<C0776f> azH;
    private final C8515b azx;

    /* renamed from: a */
    public final /* synthetic */ C17526u mo2234a(Object obj, int i, int i2, C31967j c31967j) {
        AppMethodBeat.m2504i(92358);
        byte[] d = C37187j.m62334d((InputStream) obj);
        if (d == null) {
            AppMethodBeat.m2505o(92358);
            return null;
        }
        C17526u a = this.aGo.mo2234a(ByteBuffer.wrap(d), i, i2, c31967j);
        AppMethodBeat.m2505o(92358);
        return a;
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo2235a(Object obj, C31967j c31967j) {
        AppMethodBeat.m2504i(92359);
        InputStream inputStream = (InputStream) obj;
        if (((Boolean) c31967j.mo52069a(C41563i.aGn)).booleanValue() || C0778g.m1772a(this.azH, inputStream, this.azx) != C0777a.GIF) {
            AppMethodBeat.m2505o(92359);
            return false;
        }
        AppMethodBeat.m2505o(92359);
        return true;
    }

    public C37187j(List<C0776f> list, C31968k<ByteBuffer, C37186c> c31968k, C8515b c8515b) {
        this.azH = list;
        this.aGo = c31968k;
        this.azx = c8515b;
    }

    /* renamed from: d */
    private static byte[] m62334d(InputStream inputStream) {
        AppMethodBeat.m2504i(92357);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    byte[] toByteArray = byteArrayOutputStream.toByteArray();
                    AppMethodBeat.m2505o(92357);
                    return toByteArray;
                }
            }
        } catch (IOException e) {
            Log.isLoggable("StreamGifDecoder", 5);
            AppMethodBeat.m2505o(92357);
            return null;
        }
    }
}

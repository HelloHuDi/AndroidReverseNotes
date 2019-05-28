package com.tencent.p177mm.plugin.appbrand.appstorage;

import com.tencent.luggage.p1170a.C25681b;
import com.tencent.p177mm.plugin.appbrand.p328r.C19681j;
import com.tencent.p177mm.vfs.C5728b;
import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.appstorage.p */
public interface C19092p extends C25681b {

    /* renamed from: com.tencent.mm.plugin.appbrand.appstorage.p$a */
    public interface C19093a {
        long awL();

        String getFileName();

        long lastModified();
    }

    /* renamed from: X */
    C45518j mo5830X(String str, boolean z);

    /* renamed from: Y */
    C45518j mo5831Y(String str, boolean z);

    /* renamed from: Z */
    File mo5832Z(String str, boolean z);

    /* renamed from: a */
    C45518j mo5833a(C19681j<String> c19681j);

    /* renamed from: a */
    C45518j mo5834a(File file, String str, C19681j<String> c19681j);

    /* renamed from: a */
    C45518j mo5835a(File file, String str, boolean z, C19681j<String> c19681j);

    /* renamed from: a */
    C45518j mo5836a(String str, C42366k c42366k);

    /* renamed from: a */
    C45518j mo5837a(String str, C19681j<List<C26753h>> c19681j);

    /* renamed from: a */
    C45518j mo5838a(String str, File file, boolean z);

    /* renamed from: a */
    C45518j mo5839a(String str, InputStream inputStream, boolean z);

    List<? extends C19093a> awQ();

    /* renamed from: b */
    C45518j mo5843b(String str, C19681j<ByteBuffer> c19681j);

    /* renamed from: b */
    C45518j mo5844b(String str, File file);

    /* renamed from: ca */
    boolean mo5845ca(String str);

    /* renamed from: g */
    C45518j mo5846g(String str, List<C33103u> list);

    void initialize();

    void release();

    /* renamed from: xt */
    InputStream mo34313xt(String str);

    /* renamed from: yd */
    C45518j mo5849yd(String str);

    /* renamed from: ye */
    C45518j mo5850ye(String str);

    /* renamed from: yf */
    C45518j mo5851yf(String str);

    /* renamed from: yg */
    File mo34314yg(String str);

    /* renamed from: yh */
    C5728b mo34315yh(String str);

    /* renamed from: yi */
    boolean mo34316yi(String str);
}

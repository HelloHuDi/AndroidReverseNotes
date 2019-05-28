package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.a.b;
import com.tencent.mm.plugin.appbrand.r.j;
import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public interface p extends b {

    public interface a {
        long awL();

        String getFileName();

        long lastModified();
    }

    j X(String str, boolean z);

    j Y(String str, boolean z);

    File Z(String str, boolean z);

    j a(j<String> jVar);

    j a(File file, String str, j<String> jVar);

    j a(File file, String str, boolean z, j<String> jVar);

    j a(String str, k kVar);

    j a(String str, j<List<h>> jVar);

    j a(String str, File file, boolean z);

    j a(String str, InputStream inputStream, boolean z);

    List<? extends a> awQ();

    j b(String str, j<ByteBuffer> jVar);

    j b(String str, File file);

    boolean ca(String str);

    j g(String str, List<u> list);

    void initialize();

    void release();

    InputStream xt(String str);

    j yd(String str);

    j ye(String str);

    j yf(String str);

    File yg(String str);

    com.tencent.mm.vfs.b yh(String str);

    boolean yi(String str);
}

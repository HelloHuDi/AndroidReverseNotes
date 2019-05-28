package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.p.a;
import com.tencent.mm.plugin.appbrand.r.j;
import com.tencent.mm.vfs.b;
import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public class g implements p {
    public j yd(String str) {
        return j.ERR_PERMISSION_DENIED;
    }

    public j ye(String str) {
        return j.ERR_PERMISSION_DENIED;
    }

    public j X(String str, boolean z) {
        return j.ERR_PERMISSION_DENIED;
    }

    public j Y(String str, boolean z) {
        return j.ERR_PERMISSION_DENIED;
    }

    public j a(String str, j<List<h>> jVar) {
        return j.ERR_PERMISSION_DENIED;
    }

    public j b(String str, j<ByteBuffer> jVar) {
        return j.ERR_PERMISSION_DENIED;
    }

    public j a(String str, InputStream inputStream, boolean z) {
        return j.ERR_PERMISSION_DENIED;
    }

    public j yf(String str) {
        return j.ERR_PERMISSION_DENIED;
    }

    public j a(String str, k kVar) {
        return j.ERR_PERMISSION_DENIED;
    }

    public j g(String str, List<u> list) {
        return j.ERR_PERMISSION_DENIED;
    }

    public j a(String str, File file, boolean z) {
        return j.ERR_PERMISSION_DENIED;
    }

    public File yg(String str) {
        AppMethodBeat.i(90975);
        File Z = Z(str, false);
        AppMethodBeat.o(90975);
        return Z;
    }

    public File Z(String str, boolean z) {
        return null;
    }

    public j b(String str, File file) {
        return j.ERR_PERMISSION_DENIED;
    }

    public boolean ca(String str) {
        return false;
    }

    public void initialize() {
    }

    public void release() {
    }

    public void awP() {
    }

    public b yh(String str) {
        return null;
    }

    public j a(j<String> jVar) {
        return j.ERR_NOT_SUPPORTED;
    }

    public j a(File file, String str, boolean z, j<String> jVar) {
        return j.ERR_NOT_SUPPORTED;
    }

    public j a(File file, String str, j<String> jVar) {
        return j.ERR_NOT_SUPPORTED;
    }

    public List<? extends a> awQ() {
        return null;
    }

    public boolean yi(String str) {
        return false;
    }

    public final InputStream xt(String str) {
        AppMethodBeat.i(90976);
        j jVar = new j();
        if (b(str, jVar) == j.OK) {
            InputStream aVar = new com.tencent.luggage.g.a((ByteBuffer) jVar.value);
            AppMethodBeat.o(90976);
            return aVar;
        }
        AppMethodBeat.o(90976);
        return null;
    }
}

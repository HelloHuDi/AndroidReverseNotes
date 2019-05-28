package com.tencent.mm.plugin.appbrand.appstorage;

import android.os.Environment;
import com.tencent.luggage.g.a;
import com.tencent.luggage.g.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.j;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.b;
import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class s implements p {
    public final LinkedList<p> gYd = new LinkedList();
    private final p gYe = new g();

    public s(String str) {
        AppMethodBeat.i(105390);
        File file = new File(Environment.getExternalStorageDirectory(), "luggage/".concat(String.valueOf(str)));
        LinkedList linkedList = this.gYd;
        String absolutePath = file.getAbsolutePath();
        m mVar = new m(new File(absolutePath, "objects/").getAbsolutePath(), "default_obfuscation_key", "wxfile://");
        w wVar = new w(new File(absolutePath, "files/").getAbsolutePath());
        LinkedList linkedList2 = new LinkedList();
        linkedList2.add(mVar);
        linkedList2.add(wVar);
        linkedList.addAll(linkedList2);
        AppMethodBeat.o(105390);
    }

    public final InputStream xt(String str) {
        AppMethodBeat.i(105391);
        j jVar = new j();
        if (b(str, jVar) == j.OK) {
            InputStream aVar = new a((ByteBuffer) jVar.value);
            AppMethodBeat.o(105391);
            return aVar;
        }
        AppMethodBeat.o(105391);
        return null;
    }

    public final <T extends p> T ae(Class<T> cls) {
        AppMethodBeat.i(105392);
        Iterator it = this.gYd.iterator();
        while (it.hasNext()) {
            p pVar = (p) it.next();
            if (cls.isInstance(pVar)) {
                AppMethodBeat.o(105392);
                return pVar;
            }
        }
        AppMethodBeat.o(105392);
        return null;
    }

    /* Access modifiers changed, original: protected|final */
    public final p ym(String str) {
        AppMethodBeat.i(105393);
        p pVar;
        if (bo.isNullOrNil(str)) {
            pVar = this.gYe;
            AppMethodBeat.o(105393);
            return pVar;
        }
        Iterator it = this.gYd.iterator();
        while (it.hasNext()) {
            pVar = (p) it.next();
            if (pVar.ca(str)) {
                AppMethodBeat.o(105393);
                return pVar;
            }
        }
        pVar = this.gYe;
        AppMethodBeat.o(105393);
        return pVar;
    }

    public final j yd(String str) {
        AppMethodBeat.i(105394);
        j yd = ym(str).yd(str);
        AppMethodBeat.o(105394);
        return yd;
    }

    public final j ye(String str) {
        AppMethodBeat.i(105395);
        j ye = ym(str).ye(str);
        AppMethodBeat.o(105395);
        return ye;
    }

    public final j X(String str, boolean z) {
        AppMethodBeat.i(105396);
        j X = ym(str).X(str, z);
        AppMethodBeat.o(105396);
        return X;
    }

    public final j Y(String str, boolean z) {
        AppMethodBeat.i(105397);
        j Y = ym(str).Y(str, z);
        AppMethodBeat.o(105397);
        return Y;
    }

    public j a(String str, j<List<h>> jVar) {
        AppMethodBeat.i(105398);
        j a = ym(str).a(str, (j) jVar);
        AppMethodBeat.o(105398);
        return a;
    }

    public final j b(String str, j<ByteBuffer> jVar) {
        AppMethodBeat.i(105399);
        j b = ym(str).b(str, (j) jVar);
        AppMethodBeat.o(105399);
        return b;
    }

    public final j a(String str, InputStream inputStream, boolean z) {
        AppMethodBeat.i(105400);
        j a = ym(str).a(str, inputStream, z);
        AppMethodBeat.o(105400);
        return a;
    }

    public final j yf(String str) {
        AppMethodBeat.i(105401);
        j yf = ym(str).yf(str);
        AppMethodBeat.o(105401);
        return yf;
    }

    public final j a(String str, k kVar) {
        AppMethodBeat.i(105402);
        j a = ym(str).a(str, kVar);
        AppMethodBeat.o(105402);
        return a;
    }

    public final j g(String str, List<u> list) {
        AppMethodBeat.i(105403);
        j g = ym(str).g(str, list);
        AppMethodBeat.o(105403);
        return g;
    }

    public final j a(String str, File file, boolean z) {
        AppMethodBeat.i(105404);
        j a = ym(str).a(str, file, z);
        AppMethodBeat.o(105404);
        return a;
    }

    public final File yg(String str) {
        AppMethodBeat.i(105405);
        File Z = Z(str, false);
        AppMethodBeat.o(105405);
        return Z;
    }

    public final File Z(String str, boolean z) {
        AppMethodBeat.i(105406);
        File Z = ym(str).Z(str, z);
        AppMethodBeat.o(105406);
        return Z;
    }

    public final j b(String str, File file) {
        AppMethodBeat.i(105407);
        j b = ym(str).b(str, file);
        AppMethodBeat.o(105407);
        return b;
    }

    public final boolean ca(String str) {
        AppMethodBeat.i(105408);
        String[] strArr = new String[]{"file://", "http://", "https://"};
        for (int i = 0; i < 3; i++) {
            if (h.t(str, strArr[i])) {
                AppMethodBeat.o(105408);
                return false;
            }
        }
        AppMethodBeat.o(105408);
        return true;
    }

    public final void initialize() {
        AppMethodBeat.i(105409);
        Iterator it = this.gYd.iterator();
        while (it.hasNext()) {
            ((p) it.next()).initialize();
        }
        this.gYe.initialize();
        AppMethodBeat.o(105409);
    }

    public final void release() {
        AppMethodBeat.i(105410);
        Iterator it = this.gYd.iterator();
        while (it.hasNext()) {
            ((p) it.next()).release();
        }
        this.gYd.clear();
        this.gYe.release();
        AppMethodBeat.o(105410);
    }

    public b yh(String str) {
        AppMethodBeat.i(105411);
        b yh = ((m) ae(m.class)).yh(str);
        AppMethodBeat.o(105411);
        return yh;
    }

    public final j a(j<String> jVar) {
        j a;
        AppMethodBeat.i(105412);
        Iterator it = this.gYd.iterator();
        while (it.hasNext()) {
            a = ((p) it.next()).a(jVar);
            if (a != j.ERR_NOT_SUPPORTED) {
                AppMethodBeat.o(105412);
                return a;
            }
        }
        a = j.ERR_NOT_SUPPORTED;
        AppMethodBeat.o(105412);
        return a;
    }

    public j a(File file, String str, boolean z, j<String> jVar) {
        j a;
        AppMethodBeat.i(105413);
        Iterator it = this.gYd.iterator();
        while (it.hasNext()) {
            a = ((p) it.next()).a(file, str, z, jVar);
            if (a != j.ERR_NOT_SUPPORTED) {
                AppMethodBeat.o(105413);
                return a;
            }
        }
        a = j.ERR_NOT_SUPPORTED;
        AppMethodBeat.o(105413);
        return a;
    }

    public final j a(File file, String str, j<String> jVar) {
        j a;
        AppMethodBeat.i(105414);
        Iterator it = this.gYd.iterator();
        while (it.hasNext()) {
            a = ((p) it.next()).a(file, str, (j) jVar);
            if (a != j.ERR_NOT_SUPPORTED) {
                AppMethodBeat.o(105414);
                return a;
            }
        }
        a = j.ERR_NOT_SUPPORTED;
        AppMethodBeat.o(105414);
        return a;
    }

    public List<? extends p.a> awQ() {
        AppMethodBeat.i(105415);
        List awR = ((m) ae(m.class)).gXT.awR();
        AppMethodBeat.o(105415);
        return awR;
    }

    public final boolean yi(String str) {
        AppMethodBeat.i(105416);
        boolean yi = ((m) ae(m.class)).yi(str);
        AppMethodBeat.o(105416);
        return yi;
    }
}

package com.tencent.p177mm.plugin.appbrand.appstorage;

import android.os.Environment;
import com.tencent.luggage.p147g.C37399a;
import com.tencent.luggage.p147g.C8874h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.C19092p.C19093a;
import com.tencent.p177mm.plugin.appbrand.p328r.C19681j;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5728b;
import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.appstorage.s */
public class C33102s implements C19092p {
    public final LinkedList<C19092p> gYd = new LinkedList();
    private final C19092p gYe = new C24685g();

    public C33102s(String str) {
        AppMethodBeat.m2504i(105390);
        File file = new File(Environment.getExternalStorageDirectory(), "luggage/".concat(String.valueOf(str)));
        LinkedList linkedList = this.gYd;
        String absolutePath = file.getAbsolutePath();
        C42368m c42368m = new C42368m(new File(absolutePath, "objects/").getAbsolutePath(), "default_obfuscation_key", "wxfile://");
        C2062w c2062w = new C2062w(new File(absolutePath, "files/").getAbsolutePath());
        LinkedList linkedList2 = new LinkedList();
        linkedList2.add(c42368m);
        linkedList2.add(c2062w);
        linkedList.addAll(linkedList2);
        AppMethodBeat.m2505o(105390);
    }

    /* renamed from: xt */
    public final InputStream mo34313xt(String str) {
        AppMethodBeat.m2504i(105391);
        C19681j c19681j = new C19681j();
        if (mo5843b(str, c19681j) == C45518j.OK) {
            InputStream c37399a = new C37399a((ByteBuffer) c19681j.value);
            AppMethodBeat.m2505o(105391);
            return c37399a;
        }
        AppMethodBeat.m2505o(105391);
        return null;
    }

    /* renamed from: ae */
    public final <T extends C19092p> T mo53654ae(Class<T> cls) {
        AppMethodBeat.m2504i(105392);
        Iterator it = this.gYd.iterator();
        while (it.hasNext()) {
            C19092p c19092p = (C19092p) it.next();
            if (cls.isInstance(c19092p)) {
                AppMethodBeat.m2505o(105392);
                return c19092p;
            }
        }
        AppMethodBeat.m2505o(105392);
        return null;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: ym */
    public final C19092p mo53655ym(String str) {
        AppMethodBeat.m2504i(105393);
        C19092p c19092p;
        if (C5046bo.isNullOrNil(str)) {
            c19092p = this.gYe;
            AppMethodBeat.m2505o(105393);
            return c19092p;
        }
        Iterator it = this.gYd.iterator();
        while (it.hasNext()) {
            c19092p = (C19092p) it.next();
            if (c19092p.mo5845ca(str)) {
                AppMethodBeat.m2505o(105393);
                return c19092p;
            }
        }
        c19092p = this.gYe;
        AppMethodBeat.m2505o(105393);
        return c19092p;
    }

    /* renamed from: yd */
    public final C45518j mo5849yd(String str) {
        AppMethodBeat.m2504i(105394);
        C45518j yd = mo53655ym(str).mo5849yd(str);
        AppMethodBeat.m2505o(105394);
        return yd;
    }

    /* renamed from: ye */
    public final C45518j mo5850ye(String str) {
        AppMethodBeat.m2504i(105395);
        C45518j ye = mo53655ym(str).mo5850ye(str);
        AppMethodBeat.m2505o(105395);
        return ye;
    }

    /* renamed from: X */
    public final C45518j mo5830X(String str, boolean z) {
        AppMethodBeat.m2504i(105396);
        C45518j X = mo53655ym(str).mo5830X(str, z);
        AppMethodBeat.m2505o(105396);
        return X;
    }

    /* renamed from: Y */
    public final C45518j mo5831Y(String str, boolean z) {
        AppMethodBeat.m2504i(105397);
        C45518j Y = mo53655ym(str).mo5831Y(str, z);
        AppMethodBeat.m2505o(105397);
        return Y;
    }

    /* renamed from: a */
    public C45518j mo5837a(String str, C19681j<List<C26753h>> c19681j) {
        AppMethodBeat.m2504i(105398);
        C45518j a = mo53655ym(str).mo5837a(str, (C19681j) c19681j);
        AppMethodBeat.m2505o(105398);
        return a;
    }

    /* renamed from: b */
    public final C45518j mo5843b(String str, C19681j<ByteBuffer> c19681j) {
        AppMethodBeat.m2504i(105399);
        C45518j b = mo53655ym(str).mo5843b(str, (C19681j) c19681j);
        AppMethodBeat.m2505o(105399);
        return b;
    }

    /* renamed from: a */
    public final C45518j mo5839a(String str, InputStream inputStream, boolean z) {
        AppMethodBeat.m2504i(105400);
        C45518j a = mo53655ym(str).mo5839a(str, inputStream, z);
        AppMethodBeat.m2505o(105400);
        return a;
    }

    /* renamed from: yf */
    public final C45518j mo5851yf(String str) {
        AppMethodBeat.m2504i(105401);
        C45518j yf = mo53655ym(str).mo5851yf(str);
        AppMethodBeat.m2505o(105401);
        return yf;
    }

    /* renamed from: a */
    public final C45518j mo5836a(String str, C42366k c42366k) {
        AppMethodBeat.m2504i(105402);
        C45518j a = mo53655ym(str).mo5836a(str, c42366k);
        AppMethodBeat.m2505o(105402);
        return a;
    }

    /* renamed from: g */
    public final C45518j mo5846g(String str, List<C33103u> list) {
        AppMethodBeat.m2504i(105403);
        C45518j g = mo53655ym(str).mo5846g(str, list);
        AppMethodBeat.m2505o(105403);
        return g;
    }

    /* renamed from: a */
    public final C45518j mo5838a(String str, File file, boolean z) {
        AppMethodBeat.m2504i(105404);
        C45518j a = mo53655ym(str).mo5838a(str, file, z);
        AppMethodBeat.m2505o(105404);
        return a;
    }

    /* renamed from: yg */
    public final File mo34314yg(String str) {
        AppMethodBeat.m2504i(105405);
        File Z = mo5832Z(str, false);
        AppMethodBeat.m2505o(105405);
        return Z;
    }

    /* renamed from: Z */
    public final File mo5832Z(String str, boolean z) {
        AppMethodBeat.m2504i(105406);
        File Z = mo53655ym(str).mo5832Z(str, z);
        AppMethodBeat.m2505o(105406);
        return Z;
    }

    /* renamed from: b */
    public final C45518j mo5844b(String str, File file) {
        AppMethodBeat.m2504i(105407);
        C45518j b = mo53655ym(str).mo5844b(str, file);
        AppMethodBeat.m2505o(105407);
        return b;
    }

    /* renamed from: ca */
    public final boolean mo5845ca(String str) {
        AppMethodBeat.m2504i(105408);
        String[] strArr = new String[]{"file://", "http://", "https://"};
        for (int i = 0; i < 3; i++) {
            if (C8874h.m15849t(str, strArr[i])) {
                AppMethodBeat.m2505o(105408);
                return false;
            }
        }
        AppMethodBeat.m2505o(105408);
        return true;
    }

    public final void initialize() {
        AppMethodBeat.m2504i(105409);
        Iterator it = this.gYd.iterator();
        while (it.hasNext()) {
            ((C19092p) it.next()).initialize();
        }
        this.gYe.initialize();
        AppMethodBeat.m2505o(105409);
    }

    public final void release() {
        AppMethodBeat.m2504i(105410);
        Iterator it = this.gYd.iterator();
        while (it.hasNext()) {
            ((C19092p) it.next()).release();
        }
        this.gYd.clear();
        this.gYe.release();
        AppMethodBeat.m2505o(105410);
    }

    /* renamed from: yh */
    public C5728b mo34315yh(String str) {
        AppMethodBeat.m2504i(105411);
        C5728b yh = ((C42368m) mo53654ae(C42368m.class)).mo34315yh(str);
        AppMethodBeat.m2505o(105411);
        return yh;
    }

    /* renamed from: a */
    public final C45518j mo5833a(C19681j<String> c19681j) {
        C45518j a;
        AppMethodBeat.m2504i(105412);
        Iterator it = this.gYd.iterator();
        while (it.hasNext()) {
            a = ((C19092p) it.next()).mo5833a(c19681j);
            if (a != C45518j.ERR_NOT_SUPPORTED) {
                AppMethodBeat.m2505o(105412);
                return a;
            }
        }
        a = C45518j.ERR_NOT_SUPPORTED;
        AppMethodBeat.m2505o(105412);
        return a;
    }

    /* renamed from: a */
    public C45518j mo5835a(File file, String str, boolean z, C19681j<String> c19681j) {
        C45518j a;
        AppMethodBeat.m2504i(105413);
        Iterator it = this.gYd.iterator();
        while (it.hasNext()) {
            a = ((C19092p) it.next()).mo5835a(file, str, z, c19681j);
            if (a != C45518j.ERR_NOT_SUPPORTED) {
                AppMethodBeat.m2505o(105413);
                return a;
            }
        }
        a = C45518j.ERR_NOT_SUPPORTED;
        AppMethodBeat.m2505o(105413);
        return a;
    }

    /* renamed from: a */
    public final C45518j mo5834a(File file, String str, C19681j<String> c19681j) {
        C45518j a;
        AppMethodBeat.m2504i(105414);
        Iterator it = this.gYd.iterator();
        while (it.hasNext()) {
            a = ((C19092p) it.next()).mo5834a(file, str, (C19681j) c19681j);
            if (a != C45518j.ERR_NOT_SUPPORTED) {
                AppMethodBeat.m2505o(105414);
                return a;
            }
        }
        a = C45518j.ERR_NOT_SUPPORTED;
        AppMethodBeat.m2505o(105414);
        return a;
    }

    public List<? extends C19093a> awQ() {
        AppMethodBeat.m2504i(105415);
        List awR = ((C42368m) mo53654ae(C42368m.class)).gXT.awR();
        AppMethodBeat.m2505o(105415);
        return awR;
    }

    /* renamed from: yi */
    public final boolean mo34316yi(String str) {
        AppMethodBeat.m2504i(105416);
        boolean yi = ((C42368m) mo53654ae(C42368m.class)).mo34316yi(str);
        AppMethodBeat.m2505o(105416);
        return yi;
    }
}

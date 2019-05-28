package com.tencent.soter.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.b.b;
import com.tencent.soter.a.b.c;
import com.tencent.soter.a.b.d;
import com.tencent.soter.a.g.e;
import com.tencent.soter.a.g.f;
import com.tencent.soter.a.g.h;
import com.tencent.soter.a.g.i;
import com.tencent.soter.a.g.j;
import com.tencent.soter.a.g.k;
import com.tencent.soter.a.g.l;
import com.tencent.soter.core.c.g;

public final class a {

    /* renamed from: com.tencent.soter.a.a$1 */
    public static class AnonymousClass1 implements Runnable {
        final /* synthetic */ e AvI;
        final /* synthetic */ b AvJ;
        final /* synthetic */ Context val$context;

        public AnonymousClass1(Context context, e eVar, b bVar) {
            this.val$context = context;
            this.AvI = eVar;
            this.AvJ = bVar;
        }

        public final void run() {
            AppMethodBeat.i(10453);
            j jVar = new j(this.val$context, this.AvI);
            jVar.Awl = this.AvJ;
            if (!f.dRn().a(jVar, new d())) {
                com.tencent.soter.core.c.d.e("Soter.SoterWrapperApi", "soter: add init task failed.", new Object[0]);
            }
            AppMethodBeat.o(10453);
        }
    }

    public static void a(b<c> bVar, boolean z, com.tencent.soter.a.f.e eVar) {
        AppMethodBeat.i(10454);
        com.tencent.soter.core.c.d.i("Soter.SoterWrapperApi", "soter: starting prepare ask key. ", new Object[0]);
        k kVar = new k(eVar, z);
        kVar.Awl = bVar;
        if (!f.dRn().a(kVar, new c())) {
            com.tencent.soter.core.c.d.d("Soter.SoterWrapperApi", "soter: add prepareAppSecureKey task failed.", new Object[0]);
        }
        AppMethodBeat.o(10454);
    }

    public static void a(b<c> bVar, boolean z, int i, com.tencent.soter.a.f.e eVar, com.tencent.soter.a.f.e eVar2) {
        AppMethodBeat.i(10455);
        com.tencent.soter.core.c.d.i("Soter.SoterWrapperApi", "soter: starting prepare auth key: %d", Integer.valueOf(i));
        l lVar = new l(i, eVar, eVar2, z);
        lVar.Awl = bVar;
        if (!f.dRn().a(lVar, new c())) {
            com.tencent.soter.core.c.d.d("Soter.SoterWrapperApi", "soter: add prepareAuthKey task failed.", new Object[0]);
        }
        AppMethodBeat.o(10455);
    }

    public static void a(b<com.tencent.soter.a.b.a> bVar, com.tencent.soter.a.g.b bVar2) {
        AppMethodBeat.i(10456);
        com.tencent.soter.core.c.d.i("Soter.SoterWrapperApi", "soter: request authorize provide challenge. scene: %d", Integer.valueOf(bVar2.gOW));
        if (bVar2.Awh == 1 || bVar2.Awh == 2) {
            i iVar = new i(bVar2);
            iVar.Awl = bVar;
            if (!f.dRn().a(iVar, new com.tencent.soter.a.b.a())) {
                com.tencent.soter.core.c.d.d("Soter.SoterWrapperApi", "soter: add 2.0 requestAuthorizeAndSign task failed.", new Object[0]);
            }
            AppMethodBeat.o(10456);
            return;
        }
        h hVar = new h(bVar2);
        hVar.Awl = bVar;
        if (!f.dRn().a(hVar, new com.tencent.soter.a.b.a())) {
            com.tencent.soter.core.c.d.d("Soter.SoterWrapperApi", "soter: add 1.0 requestAuthorizeAndSign task failed.", new Object[0]);
        }
        AppMethodBeat.o(10456);
    }

    public static boolean dRc() {
        AppMethodBeat.i(10457);
        if (com.tencent.soter.a.c.a.dRe().isInit() && com.tencent.soter.a.c.a.dRe().dRc()) {
            AppMethodBeat.o(10457);
            return true;
        }
        AppMethodBeat.o(10457);
        return false;
    }

    public static boolean Ri(int i) {
        AppMethodBeat.i(10458);
        boolean isInit = com.tencent.soter.a.c.a.dRe().isInit();
        String str = (String) com.tencent.soter.a.c.a.dRe().dRg().get(i);
        if (!isInit || g.isNullOrNil(str)) {
            if (isInit) {
                com.tencent.soter.core.c.d.w("Soter.SoterWrapperApi", "soter: scene not registered in init. please make sure", new Object[0]);
                AppMethodBeat.o(10458);
                return false;
            }
            com.tencent.soter.core.c.d.w("Soter.SoterWrapperApi", "soter: not initialized yet", new Object[0]);
            AppMethodBeat.o(10458);
            return false;
        } else if (com.tencent.soter.core.a.cn(str, false).errCode == 0) {
            AppMethodBeat.o(10458);
            return true;
        } else {
            AppMethodBeat.o(10458);
            return false;
        }
    }
}

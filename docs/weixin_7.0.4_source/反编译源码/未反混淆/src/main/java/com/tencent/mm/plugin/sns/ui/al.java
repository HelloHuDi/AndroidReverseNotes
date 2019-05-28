package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ab;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.v;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.w;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;

public final class al {
    public static h a(Context context, r rVar, ViewGroup viewGroup, int i) {
        AppMethodBeat.i(38606);
        h hVar = null;
        if (rVar != null) {
            switch (rVar.type) {
                case 21:
                    if (rVar.cuu == 2) {
                        hVar = new m(context, (b) rVar, viewGroup);
                        AppMethodBeat.o(38606);
                        return hVar;
                    } else if (rVar.cuu == 6) {
                        hVar = new s(context, (k) rVar, viewGroup);
                        AppMethodBeat.o(38606);
                        return hVar;
                    } else if (rVar.cuu == 7) {
                        hVar = new t(context, (j) rVar, viewGroup);
                        AppMethodBeat.o(38606);
                        return hVar;
                    }
                    break;
                case 41:
                    switch (rVar.cuu) {
                        case 0:
                            hVar = new w(context, (n) rVar, viewGroup);
                            break;
                        case 1:
                            hVar = new l(context, (n) rVar, viewGroup);
                            break;
                    }
                    break;
                case 82:
                    hVar = new g(context, rVar, viewGroup);
                    break;
                case 101:
                    hVar = new o(context, (x) rVar, viewGroup);
                    break;
                case 102:
                    hVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.b(context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) rVar, viewGroup);
                    break;
                case 103:
                    hVar = new q(context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s) rVar, viewGroup);
                    break;
                case 104:
                    hVar = new d(context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) rVar, viewGroup);
                    break;
                case 105:
                    hVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n(context, (p) rVar, viewGroup);
                    break;
                case 132:
                    hVar = new ab(context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab) rVar, viewGroup);
                    break;
                default:
                    com.tencent.mm.sdk.platformtools.ab.i("SnsAdNativeLandingPagesLayoutHelper", "unknown comp type " + rVar.type);
                    break;
            }
        }
        if (hVar != null) {
            AppMethodBeat.o(38606);
            return hVar;
        } else if (rVar instanceof u) {
            hVar = new aa(context, (u) rVar, viewGroup);
            hVar.setBackgroundColor(i);
            AppMethodBeat.o(38606);
            return hVar;
        } else if (rVar instanceof k) {
            hVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k(context, (k) rVar, viewGroup);
            hVar.setBackgroundColor(i);
            AppMethodBeat.o(38606);
            return hVar;
        } else if (rVar instanceof n) {
            hVar = new w(context, (n) rVar, viewGroup);
            AppMethodBeat.o(38606);
            return hVar;
        } else if (rVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m) {
            hVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.u(context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m) rVar, viewGroup);
            AppMethodBeat.o(38606);
            return hVar;
        } else if (rVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o) {
            hVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x(context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o) rVar, viewGroup);
            AppMethodBeat.o(38606);
            return hVar;
        } else if (rVar instanceof z) {
            z zVar = (z) rVar;
            if (AdLandingPagesProxy.getInstance().getStreamVideoPlayerConfig() > 0) {
                com.tencent.mm.sdk.platformtools.ab.i("SnsAdNativeLandingPagesLayoutHelper", "use new stream video player component");
                hVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.z(context, zVar, viewGroup);
            } else {
                hVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.r(context, zVar, viewGroup);
            }
            AppMethodBeat.o(38606);
            return hVar;
        } else if (rVar instanceof y) {
            hVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.p(context, (y) rVar, viewGroup);
            AppMethodBeat.o(38606);
            return hVar;
        } else if (rVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g) {
            hVar = new f(context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g) rVar, viewGroup);
            AppMethodBeat.o(38606);
            return hVar;
        } else if (rVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d) {
            hVar = new c(context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d) rVar, viewGroup);
            AppMethodBeat.o(38606);
            return hVar;
        } else if (rVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t) {
            hVar = new v(context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t) rVar, viewGroup);
            AppMethodBeat.o(38606);
            return hVar;
        } else {
            hVar = new h(context, rVar, viewGroup);
            AppMethodBeat.o(38606);
            return hVar;
        }
    }
}

package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.dc.a;
import com.tencent.tencentmap.mapsdk.maps.a.ic;
import java.util.ArrayList;

public final class ae {
    public static ad a() {
        AppMethodBeat.i(98293);
        ao aoVar = new ao();
        aoVar.o = ao.a;
        ad adVar = new ad(aoVar);
        AppMethodBeat.o(98293);
        return adVar;
    }

    public static ad b() {
        AppMethodBeat.i(98294);
        ao aoVar = new ao();
        aoVar.o = ao.b;
        ad adVar = new ad(aoVar);
        AppMethodBeat.o(98294);
        return adVar;
    }

    public static ad a(float f, float f2) {
        AppMethodBeat.i(98295);
        ao aoVar = new ao();
        aoVar.o = ao.c;
        aoVar.p = f;
        aoVar.q = f2;
        ad adVar = new ad(aoVar);
        AppMethodBeat.o(98295);
        return adVar;
    }

    public static ad a(float f) {
        AppMethodBeat.i(98296);
        ao aoVar = new ao();
        aoVar.o = ao.d;
        aoVar.r = f;
        ad adVar = new ad(aoVar);
        AppMethodBeat.o(98296);
        return adVar;
    }

    public static ad b(float f) {
        AppMethodBeat.i(98297);
        ao aoVar = new ao();
        aoVar.o = ao.e;
        aoVar.s = f;
        ad adVar = new ad(aoVar);
        AppMethodBeat.o(98297);
        return adVar;
    }

    public static ad a(float f, Point point) {
        AppMethodBeat.i(98298);
        ao aoVar = new ao();
        aoVar.o = ao.f;
        aoVar.t = f;
        aoVar.u = point;
        ad adVar = new ad(aoVar);
        AppMethodBeat.o(98298);
        return adVar;
    }

    public static ad a(cp cpVar) {
        AppMethodBeat.i(98299);
        ao aoVar = new ao();
        aoVar.o = ao.g;
        aoVar.v = cpVar;
        ad adVar = new ad(aoVar);
        AppMethodBeat.o(98299);
        return adVar;
    }

    public static ad a(db dbVar) {
        AppMethodBeat.i(98300);
        ao aoVar = new ao();
        aoVar.o = ao.h;
        aoVar.w = dbVar;
        ad adVar = new ad(aoVar);
        AppMethodBeat.o(98300);
        return adVar;
    }

    public static ad a(db dbVar, float f) {
        AppMethodBeat.i(98301);
        ao aoVar = new ao();
        aoVar.o = ao.i;
        aoVar.x = dbVar;
        aoVar.y = f;
        ad adVar = new ad(aoVar);
        AppMethodBeat.o(98301);
        return adVar;
    }

    public static ad a(dc dcVar, int i) {
        AppMethodBeat.i(98302);
        ao aoVar = new ao();
        aoVar.o = ao.j;
        aoVar.z = dcVar;
        aoVar.A = i;
        ad adVar = new ad(aoVar);
        AppMethodBeat.o(98302);
        return adVar;
    }

    public static ad a(dc dcVar, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(98303);
        ao aoVar = new ao();
        aoVar.o = ao.l;
        aoVar.B = dcVar;
        aoVar.F = i;
        aoVar.G = i2;
        aoVar.H = i3;
        aoVar.I = i4;
        ad adVar = new ad(aoVar);
        AppMethodBeat.o(98303);
        return adVar;
    }

    public static ad a(dc dcVar, db dbVar, int i) {
        AppMethodBeat.i(98304);
        if (dcVar == null) {
            AppMethodBeat.o(98304);
            return null;
        }
        db dbVar2 = dcVar.b;
        db a = ic.a(dbVar, dbVar2);
        db dbVar3 = dcVar.a;
        db a2 = ic.a(dbVar, dbVar3);
        Iterable arrayList = new ArrayList();
        arrayList.add(dbVar2);
        arrayList.add(a);
        arrayList.add(dbVar3);
        arrayList.add(a2);
        ad a3 = a(new a().a(arrayList).a(), i);
        AppMethodBeat.o(98304);
        return a3;
    }
}

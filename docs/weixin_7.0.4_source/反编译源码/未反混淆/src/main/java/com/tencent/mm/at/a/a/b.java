package com.tencent.mm.at.a.a;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.b.c;
import com.tencent.mm.at.a.b.d;
import com.tencent.mm.at.a.b.g;
import com.tencent.mm.at.a.b.i;
import com.tencent.mm.at.a.c.e;
import com.tencent.mm.at.a.c.f;
import com.tencent.mm.at.a.c.h;
import com.tencent.mm.at.a.c.j;
import com.tencent.mm.at.a.c.k;
import com.tencent.mm.at.a.c.m;
import com.tencent.mm.at.a.c.n;
import java.util.concurrent.Executor;

public final class b {
    public static final int fGP = Runtime.getRuntime().availableProcessors();
    public final Resources aEH;
    public final int fGQ;
    public final int fGR;
    public final c fGS;
    public final m fGT;
    public final com.tencent.mm.at.a.c.a fGU;
    public final com.tencent.mm.at.a.c.b fGV;
    public final f fGW;
    public final j fGX;
    public final k fGY;
    public final e fGZ;
    public final h fHa;
    public final Executor fHb;
    public final n fHc;
    public final String packageName;

    public static class a {
        Context context;
        int fGQ = b.fGP;
        int fGR = 5;
        c fGS = null;
        public m fGT = null;
        com.tencent.mm.at.a.c.a fGU = null;
        public com.tencent.mm.at.a.c.b fGV = null;
        f fGW = null;
        j fGX = null;
        e fGZ = null;
        public h fHa = null;
        Executor fHb;
        n fHc = null;
        k fHd = null;

        public a(Context context) {
            AppMethodBeat.i(116066);
            this.context = context.getApplicationContext();
            AppMethodBeat.o(116066);
        }

        public final b ahx() {
            AppMethodBeat.i(116067);
            ahy();
            b bVar = new b(this);
            AppMethodBeat.o(116067);
            return bVar;
        }

        private void ahy() {
            AppMethodBeat.i(116068);
            if (this.fGS == null) {
                this.fGS = c.ahz();
            }
            if (this.fGT == null) {
                this.fGT = new com.tencent.mm.at.a.b.f();
            }
            if (this.fGU == null) {
                this.fGU = new com.tencent.mm.at.a.b.a();
            }
            if (this.fGV == null) {
                this.fGV = new com.tencent.mm.at.a.b.b();
            }
            if (this.fGW == null) {
                this.fGW = new d();
            }
            if (this.fGX == null) {
                this.fGX = new i();
            }
            if (this.fHa == null) {
                this.fHa = a.cs(this.fGQ, this.fGR);
            }
            if (this.fHb == null) {
                this.fHb = com.tencent.mm.sdk.g.c.d.anP("image_loader_ImageTempFile");
            }
            if (this.fHd == null) {
                this.fHd = new com.tencent.mm.at.a.b.e();
            }
            if (this.fGZ == null) {
                this.fGZ = new c();
            }
            if (this.fHc == null) {
                this.fHc = new g();
            }
            AppMethodBeat.o(116068);
        }
    }

    static {
        AppMethodBeat.i(116071);
        AppMethodBeat.o(116071);
    }

    public b(a aVar) {
        AppMethodBeat.i(116069);
        this.packageName = aVar.context.getPackageName();
        this.aEH = aVar.context.getResources();
        this.fGQ = aVar.fGQ;
        this.fGR = aVar.fGR;
        this.fGS = aVar.fGS;
        this.fGT = aVar.fGT;
        this.fGU = aVar.fGU;
        this.fGV = aVar.fGV;
        this.fGW = aVar.fGW;
        this.fGX = aVar.fGX;
        this.fHa = aVar.fHa;
        this.fHb = aVar.fHb;
        this.fGY = aVar.fHd;
        this.fGZ = aVar.fGZ;
        this.fHc = aVar.fHc;
        AppMethodBeat.o(116069);
    }

    public static b bZ(Context context) {
        AppMethodBeat.i(116070);
        b ahx = new a(context).ahx();
        AppMethodBeat.o(116070);
        return ahx;
    }
}

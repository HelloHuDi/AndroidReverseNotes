package a.i.b.a.c.j.a;

import a.f.b.j;
import a.i.b.a.c.b.am;
import a.i.b.a.c.e.a.c;
import a.i.b.a.c.e.a.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class s {
    public final c AWq;
    public final h AWr;
    public final am Bfq;

    public static final class a extends s {
        private final a.i.b.a.c.e.a.c BGD;
        public final a.i.b.a.c.e.a.c.b BHv;
        public final a BHw;
        public final a.i.b.a.c.f.a BcB;
        public final boolean BeM;

        public a(a.i.b.a.c.e.a.c cVar, c cVar2, h hVar, am amVar, a aVar) {
            j.p(cVar, "classProto");
            j.p(cVar2, "nameResolver");
            j.p(hVar, "typeTable");
            super(cVar2, hVar, amVar, (byte) 0);
            AppMethodBeat.i(122296);
            this.BGD = cVar;
            this.BHw = aVar;
            this.BcB = r.a(cVar2, this.BGD.Btn);
            a.i.b.a.c.e.a.c.b bVar = (a.i.b.a.c.e.a.c.b) a.i.b.a.c.e.a.b.Bwx.get(this.BGD.BsW);
            if (bVar == null) {
                bVar = a.i.b.a.c.e.a.c.b.CLASS;
            }
            this.BHv = bVar;
            Boolean Ug = a.i.b.a.c.e.a.b.Bwy.Ug(this.BGD.BsW);
            j.o(Ug, "Flags.IS_INNER.get(classProto.flags)");
            this.BeM = Ug.booleanValue();
            AppMethodBeat.o(122296);
        }

        public final a.i.b.a.c.f.b ejR() {
            AppMethodBeat.i(122295);
            a.i.b.a.c.f.b ehE = this.BcB.ehE();
            j.o(ehE, "classId.asSingleFqName()");
            AppMethodBeat.o(122295);
            return ehE;
        }
    }

    public static final class b extends s {
        private final a.i.b.a.c.f.b BfP;

        public b(a.i.b.a.c.f.b bVar, c cVar, h hVar, am amVar) {
            j.p(bVar, "fqName");
            j.p(cVar, "nameResolver");
            j.p(hVar, "typeTable");
            super(cVar, hVar, amVar, (byte) 0);
            AppMethodBeat.i(122297);
            this.BfP = bVar;
            AppMethodBeat.o(122297);
        }

        public final a.i.b.a.c.f.b ejR() {
            return this.BfP;
        }
    }

    public abstract a.i.b.a.c.f.b ejR();

    private s(c cVar, h hVar, am amVar) {
        this.AWq = cVar;
        this.AWr = hVar;
        this.Bfq = amVar;
    }

    public /* synthetic */ s(c cVar, h hVar, am amVar, byte b) {
        this(cVar, hVar, amVar);
    }

    public String toString() {
        return getClass().getSimpleName() + ": " + ejR();
    }
}

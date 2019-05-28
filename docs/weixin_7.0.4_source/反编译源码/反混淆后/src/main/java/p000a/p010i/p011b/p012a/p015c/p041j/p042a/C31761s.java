package p000a.p010i.p011b.p012a.p015c.p041j.p042a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C41398am;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C37000c;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C37000c.C31689b;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C31700b;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C31702c;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C41420h;
import p000a.p010i.p011b.p012a.p015c.p778f.C8173a;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;

/* renamed from: a.i.b.a.c.j.a.s */
public abstract class C31761s {
    public final C31702c AWq;
    public final C41420h AWr;
    public final C41398am Bfq;

    /* renamed from: a.i.b.a.c.j.a.s$a */
    public static final class C31762a extends C31761s {
        private final C37000c BGD;
        public final C31689b BHv;
        public final C31762a BHw;
        public final C8173a BcB;
        public final boolean BeM;

        public C31762a(C37000c c37000c, C31702c c31702c, C41420h c41420h, C41398am c41398am, C31762a c31762a) {
            C25052j.m39376p(c37000c, "classProto");
            C25052j.m39376p(c31702c, "nameResolver");
            C25052j.m39376p(c41420h, "typeTable");
            super(c31702c, c41420h, c41398am, (byte) 0);
            AppMethodBeat.m2504i(122296);
            this.BGD = c37000c;
            this.BHw = c31762a;
            this.BcB = C8226r.m14530a(c31702c, this.BGD.Btn);
            C31689b c31689b = (C31689b) C31700b.Bwx.get(this.BGD.BsW);
            if (c31689b == null) {
                c31689b = C31689b.CLASS;
            }
            this.BHv = c31689b;
            Boolean Ug = C31700b.Bwy.mo31314Ug(this.BGD.BsW);
            C25052j.m39375o(Ug, "Flags.IS_INNER.get(classProto.flags)");
            this.BeM = Ug.booleanValue();
            AppMethodBeat.m2505o(122296);
        }

        public final C8174b ejR() {
            AppMethodBeat.m2504i(122295);
            C8174b ehE = this.BcB.ehE();
            C25052j.m39375o(ehE, "classId.asSingleFqName()");
            AppMethodBeat.m2505o(122295);
            return ehE;
        }
    }

    /* renamed from: a.i.b.a.c.j.a.s$b */
    public static final class C31763b extends C31761s {
        private final C8174b BfP;

        public C31763b(C8174b c8174b, C31702c c31702c, C41420h c41420h, C41398am c41398am) {
            C25052j.m39376p(c8174b, "fqName");
            C25052j.m39376p(c31702c, "nameResolver");
            C25052j.m39376p(c41420h, "typeTable");
            super(c31702c, c41420h, c41398am, (byte) 0);
            AppMethodBeat.m2504i(122297);
            this.BfP = c8174b;
            AppMethodBeat.m2505o(122297);
        }

        public final C8174b ejR() {
            return this.BfP;
        }
    }

    public abstract C8174b ejR();

    private C31761s(C31702c c31702c, C41420h c41420h, C41398am c41398am) {
        this.AWq = c31702c;
        this.AWr = c41420h;
        this.Bfq = c41398am;
    }

    public /* synthetic */ C31761s(C31702c c31702c, C41420h c41420h, C41398am c41398am, byte b) {
        this(c31702c, c41420h, c41398am);
    }

    public String toString() {
        return getClass().getSimpleName() + ": " + ejR();
    }
}

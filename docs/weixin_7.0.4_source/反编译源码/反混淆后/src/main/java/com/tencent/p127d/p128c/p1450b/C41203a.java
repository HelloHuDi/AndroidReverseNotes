package com.tencent.p127d.p128c.p1450b;

import com.p123qq.taf.jce.JceInputStream;
import com.p123qq.taf.jce.JceOutputStream;
import com.p123qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

/* renamed from: com.tencent.d.c.b.a */
public final class C41203a extends JceStruct {
    static C32109c Asm = new C32109c();
    static ArrayList<C45081b> Asn = new ArrayList();
    static C41204d Aso = new C41204d();
    public C32109c Asj = null;
    public ArrayList<C45081b> Ask = null;
    public C41204d Asl = null;

    public final JceStruct newInit() {
        AppMethodBeat.m2504i(114487);
        C41203a c41203a = new C41203a();
        AppMethodBeat.m2505o(114487);
        return c41203a;
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.m2504i(114488);
        if (this.Asj != null) {
            jceOutputStream.write(this.Asj, 0);
        }
        if (this.Ask != null) {
            jceOutputStream.write(this.Ask, 1);
        }
        if (this.Asl != null) {
            jceOutputStream.write(this.Asl, 2);
        }
        AppMethodBeat.m2505o(114488);
    }

    static {
        AppMethodBeat.m2504i(114490);
        Asn.add(new C45081b());
        AppMethodBeat.m2505o(114490);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.m2504i(114489);
        this.Asj = (C32109c) jceInputStream.read(Asm, 0, false);
        this.Ask = (ArrayList) jceInputStream.read(Asn, 1, false);
        this.Asl = (C41204d) jceInputStream.read(Aso, 2, false);
        AppMethodBeat.m2505o(114489);
    }
}

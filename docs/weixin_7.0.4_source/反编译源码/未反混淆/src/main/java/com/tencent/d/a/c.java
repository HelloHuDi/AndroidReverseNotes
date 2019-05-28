package com.tencent.d.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class c {
    private static com.tencent.d.b.a ArE = null;

    public interface a {
        void f(int i, byte[] bArr);
    }

    public static void a(Context context, a aVar) {
        AppMethodBeat.i(114464);
        if (ArE == null) {
            ArE = new com.tencent.d.b.a(context);
        }
        com.tencent.d.b.a aVar2 = ArE;
        try {
            List iJ = com.tencent.d.f.a.iJ(aVar2.mContext);
            if (iJ.size() == 0) {
                aVar.f(-10, null);
                AppMethodBeat.o(114464);
                return;
            }
            com.tencent.d.c.b.a aVar3 = new com.tencent.d.c.b.a();
            aVar3.Asl = com.tencent.d.b.a.dQj();
            aVar3.Asj = new com.tencent.d.c.b.c();
            aVar3.Asj.AsM = 6;
            aVar3.Asj.Ase = 1;
            aVar3.Asj.requestType = 0;
            aVar3.Asj.AsN = 0;
            aVar3.Asj.AsO = 0;
            aVar3.Asj.AsP = null;
            aVar3.Asj.AsQ = 0;
            aVar3.Asj.AsU = 1;
            aVar3.Ask = new ArrayList();
            for (int i = 0; i < iJ.size(); i++) {
                aVar3.Ask.add(com.tencent.d.b.a.a(aVar2.mContext, (a) iJ.get(i), i));
            }
            byte[] a = aVar2.ArH.a(aVar3);
            if (a == null) {
                aVar.f(-20, null);
                AppMethodBeat.o(114464);
                return;
            }
            aVar.f(0, a);
            AppMethodBeat.o(114464);
        } catch (Throwable th) {
            aVar.f(-100, null);
            AppMethodBeat.o(114464);
        }
    }
}

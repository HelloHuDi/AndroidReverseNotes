package a.i.b.a.c.e.a;

import a.f.b.j;
import a.i.b.a.c.e.a.w;
import a.i.b.a.c.e.a.w.b;
import a.i.b.a.c.e.a.y;
import a.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.LinkedList;
import java.util.List;

public final class d implements c {
    private final y Bxg;
    private final w Bxh;

    public d(y yVar, w wVar) {
        j.p(yVar, "strings");
        j.p(wVar, "qualifiedNames");
        AppMethodBeat.i(121080);
        this.Bxg = yVar;
        this.Bxh = wVar;
        AppMethodBeat.o(121080);
    }

    public final String getString(int i) {
        AppMethodBeat.i(121076);
        String string = this.Bxg.getString(i);
        j.o(string, "strings.getString(index)");
        AppMethodBeat.o(121076);
        return string;
    }

    public final String Uh(int i) {
        AppMethodBeat.i(121077);
        t Uj = Uj(i);
        List list = (List) Uj.first;
        String a = a.a.t.a((Iterable) (List) Uj.second, (CharSequence) ".", null, null, 0, null, null, 62);
        if (list.isEmpty()) {
            AppMethodBeat.o(121077);
            return a;
        }
        String str = a.a.t.a((Iterable) list, (CharSequence) "/", null, null, 0, null, null, 62) + IOUtils.DIR_SEPARATOR_UNIX + a;
        AppMethodBeat.o(121077);
        return str;
    }

    public final boolean Ui(int i) {
        AppMethodBeat.i(121078);
        boolean booleanValue = ((Boolean) Uj(i).AUw).booleanValue();
        AppMethodBeat.o(121078);
        return booleanValue;
    }

    private final t<List<String>, List<String>, Boolean> Uj(int i) {
        AppMethodBeat.i(121079);
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        boolean z = false;
        while (i != -1) {
            b Ty = this.Bxh.Ty(i);
            y yVar = this.Bxg;
            j.o(Ty, "proto");
            String string = yVar.getString(Ty.BuR);
            b.b bVar = Ty.BuS;
            if (bVar == null) {
                j.dWJ();
            }
            switch (e.eQZ[bVar.ordinal()]) {
                case 1:
                    linkedList2.addFirst(string);
                    break;
                case 2:
                    linkedList.addFirst(string);
                    break;
                case 3:
                    linkedList2.addFirst(string);
                    z = true;
                    break;
                default:
                    break;
            }
            i = Ty.BuQ;
        }
        t tVar = new t(linkedList, linkedList2, Boolean.valueOf(z));
        AppMethodBeat.o(121079);
        return tVar;
    }
}

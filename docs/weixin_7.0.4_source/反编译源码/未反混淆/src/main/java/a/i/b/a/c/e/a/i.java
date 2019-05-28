package a.i.b.a.c.e.a;

import a.a.v;
import a.f.b.j;
import a.i.b.a.c.e.a.ak;
import a.i.b.a.c.e.a.am;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.config.SharePluginInfo;
import java.util.List;

public final class i {
    private static final i Bxi = new i(v.AUP);
    public static final a Bxj = new a();
    final List<ak> foD;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static i g(am amVar) {
            AppMethodBeat.i(121097);
            j.p(amVar, SharePluginInfo.ISSUE_KEY_TABLE);
            i ego;
            if (amVar.Bwh.size() == 0) {
                ego = i.Bxi;
                AppMethodBeat.o(121097);
                return ego;
            }
            List list = amVar.Bwh;
            j.o(list, "table.requirementList");
            ego = new i(list, (byte) 0);
            AppMethodBeat.o(121097);
            return ego;
        }
    }

    private i(List<ak> list) {
        this.foD = list;
    }

    public /* synthetic */ i(List list, byte b) {
        this(list);
    }

    static {
        AppMethodBeat.i(121098);
        AppMethodBeat.o(121098);
    }
}

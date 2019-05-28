package p000a.p010i.p011b.p012a.p015c.p033e.p776a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.config.SharePluginInfo;
import java.util.List;
import p000a.p001a.C17115v;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C16485ak;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C36655am;

/* renamed from: a.i.b.a.c.e.a.i */
public final class C37007i {
    private static final C37007i Bxi = new C37007i(C17115v.AUP);
    public static final C37008a Bxj = new C37008a();
    final List<C16485ak> foD;

    /* renamed from: a.i.b.a.c.e.a.i$a */
    public static final class C37008a {
        private C37008a() {
        }

        public /* synthetic */ C37008a(byte b) {
            this();
        }

        /* renamed from: g */
        public static C37007i m61878g(C36655am c36655am) {
            AppMethodBeat.m2504i(121097);
            C25052j.m39376p(c36655am, SharePluginInfo.ISSUE_KEY_TABLE);
            C37007i ego;
            if (c36655am.Bwh.size() == 0) {
                ego = C37007i.Bxi;
                AppMethodBeat.m2505o(121097);
                return ego;
            }
            List list = c36655am.Bwh;
            C25052j.m39375o(list, "table.requirementList");
            ego = new C37007i(list, (byte) 0);
            AppMethodBeat.m2505o(121097);
            return ego;
        }
    }

    private C37007i(List<C16485ak> list) {
        this.foD = list;
    }

    public /* synthetic */ C37007i(List list, byte b) {
        this(list);
    }

    static {
        AppMethodBeat.m2504i(121098);
        AppMethodBeat.m2505o(121098);
    }
}

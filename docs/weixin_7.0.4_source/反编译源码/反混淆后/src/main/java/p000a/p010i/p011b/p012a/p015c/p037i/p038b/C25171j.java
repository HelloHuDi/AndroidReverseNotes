package p000a.p010i.p011b.p012a.p015c.p037i.p038b;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C37091y;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C25093y;
import p000a.p010i.p011b.p012a.p015c.p045l.C25235p;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p045l.C8235ad;

/* renamed from: a.i.b.a.c.i.b.j */
public abstract class C25171j extends C41432f<C37091y> {
    public static final C8199a BET = new C8199a();

    /* renamed from: a.i.b.a.c.i.b.j$a */
    public static final class C8199a {
        private C8199a() {
        }

        public /* synthetic */ C8199a(byte b) {
            this();
        }

        public static C25171j awi(String str) {
            AppMethodBeat.m2504i(122090);
            C25052j.m39376p(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            C25171j c25172b = new C25172b(str);
            AppMethodBeat.m2505o(122090);
            return c25172b;
        }
    }

    /* renamed from: a.i.b.a.c.i.b.j$b */
    public static final class C25172b extends C25171j {
        private final String message;

        public C25172b(String str) {
            C25052j.m39376p(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            AppMethodBeat.m2504i(122092);
            this.message = str;
            AppMethodBeat.m2505o(122092);
        }

        /* renamed from: b */
        public final /* synthetic */ C46867w mo18011b(C25093y c25093y) {
            AppMethodBeat.m2504i(122091);
            C25052j.m39376p(c25093y, "module");
            C8235ad awn = C25235p.awn(this.message);
            C25052j.m39375o(awn, "ErrorUtils.createErrorType(message)");
            C46867w c46867w = awn;
            AppMethodBeat.m2505o(122091);
            return c46867w;
        }

        public final String toString() {
            return this.message;
        }
    }

    public C25171j() {
        super(C37091y.AUy);
    }

    public final /* synthetic */ Object getValue() {
        throw new UnsupportedOperationException();
    }
}

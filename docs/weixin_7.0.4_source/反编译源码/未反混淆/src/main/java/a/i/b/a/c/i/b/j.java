package a.i.b.a.c.i.b;

import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.p;
import a.i.b.a.c.l.w;
import a.y;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class j extends f<y> {
    public static final a BET = new a();

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static j awi(String str) {
            AppMethodBeat.i(122090);
            a.f.b.j.p(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            j bVar = new b(str);
            AppMethodBeat.o(122090);
            return bVar;
        }
    }

    public static final class b extends j {
        private final String message;

        public b(String str) {
            a.f.b.j.p(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            AppMethodBeat.i(122092);
            this.message = str;
            AppMethodBeat.o(122092);
        }

        public final /* synthetic */ w b(a.i.b.a.c.b.y yVar) {
            AppMethodBeat.i(122091);
            a.f.b.j.p(yVar, "module");
            ad awn = p.awn(this.message);
            a.f.b.j.o(awn, "ErrorUtils.createErrorType(message)");
            w wVar = awn;
            AppMethodBeat.o(122091);
            return wVar;
        }

        public final String toString() {
            return this.message;
        }
    }

    public j() {
        super(y.AUy);
    }

    public final /* synthetic */ Object getValue() {
        throw new UnsupportedOperationException();
    }
}

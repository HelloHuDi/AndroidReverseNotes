package a.k;

import a.a.m;
import a.a.t;
import a.f.b.j;
import a.f.b.k;
import a.h.h;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\u001a!\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0002\b\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0002¢\u0006\u0002\b\u0007\u001a\u0014\u0010\b\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u001aJ\u0010\t\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\b¢\u0006\u0002\b\u000e\u001a\u0014\u0010\u000f\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u001a\u001e\u0010\u0011\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u001a\n\u0010\u0013\u001a\u00020\u0002*\u00020\u0002\u001a\u0014\u0010\u0014\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002¨\u0006\u0015"}, dWq = {"getIndentFunction", "Lkotlin/Function1;", "", "indent", "getIndentFunction$StringsKt__IndentKt", "indentWidth", "", "indentWidth$StringsKt__IndentKt", "prependIndent", "reindent", "", "resultSizeEstimate", "indentAddFunction", "indentCutFunction", "reindent$StringsKt__IndentKt", "replaceIndent", "newIndent", "replaceIndentByMargin", "marginPrefix", "trimIndent", "trimMargin", "kotlin-stdlib"}, dWr = 1)
public class n {

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "", "line", "invoke"})
    static final class b extends k implements a.f.a.b<String, String> {
        final /* synthetic */ String BPl;

        b(String str) {
            this.BPl = str;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(56364);
            String str = (String) obj;
            j.p(str, "line");
            String str2 = this.BPl + str;
            AppMethodBeat.o(56364);
            return str2;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "", "line", "invoke"})
    static final class a extends k implements a.f.a.b<String, String> {
        public static final a BPk = new a();

        static {
            AppMethodBeat.i(56341);
            AppMethodBeat.o(56341);
        }

        a() {
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(56340);
            String str = (String) obj;
            j.p(str, "line");
            AppMethodBeat.o(56340);
            return str;
        }
    }

    /* JADX WARNING: Missing block: B:48:0x015d, code skipped:
            if (r1 == null) goto L_0x015f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final String ja(String str, String str2) {
        String str3;
        int i;
        a.f.a.b bVar;
        AppMethodBeat.i(56295);
        j.p(str, "receiver$0");
        j.p(str2, "newIndent");
        CharSequence charSequence = str;
        j.p(charSequence, "receiver$0");
        j.p(charSequence, "receiver$0");
        List c = a.j.n.c(v.a(charSequence, new String[]{IOUtils.LINE_SEPARATOR_WINDOWS, IOUtils.LINE_SEPARATOR_UNIX, "\r"}, false, 6));
        Collection arrayList = new ArrayList();
        for (Object next : c) {
            if ((!u.ar((CharSequence) ((String) next)) ? 1 : 0) != 0) {
                arrayList.add(next);
            }
        }
        Iterable<String> iterable = (List) arrayList;
        Collection arrayList2 = new ArrayList(m.d(iterable));
        for (String str32 : iterable) {
            arrayList2.add(Integer.valueOf(awv(str32)));
        }
        Integer num = (Integer) t.s((List) arrayList2);
        int intValue = num != null ? num.intValue() : 0;
        int length = str.length() + (str2.length() * c.size());
        if (str2.length() == 0) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            bVar = a.BPk;
        } else {
            bVar = new b(str2);
        }
        int fH = a.a.l.fH(c);
        arrayList2 = new ArrayList();
        int i2 = 0;
        for (Object next2 : c) {
            Object next22;
            int i3 = i2 + 1;
            if (i2 < 0) {
                a.a.l.dWs();
            }
            str32 = (String) next22;
            if ((i2 == 0 || i2 == fH) && u.ar(str32)) {
                next22 = null;
            } else {
                j.p(str32, "receiver$0");
                if ((intValue >= 0 ? 1 : 0) == 0) {
                    Throwable illegalArgumentException = new IllegalArgumentException(("Requested character count " + intValue + " is less than zero.").toString());
                    AppMethodBeat.o(56295);
                    throw illegalArgumentException;
                }
                String substring = str32.substring(h.in(intValue, str32.length()));
                j.o(substring, "(this as java.lang.String).substring(startIndex)");
                if (substring != null) {
                    substring = (String) bVar.am(substring);
                }
                substring = str32;
            }
            if (next22 != null) {
                arrayList2.add(next22);
                i2 = i3;
            } else {
                i2 = i3;
            }
        }
        String stringBuilder = ((StringBuilder) t.a((List) arrayList2, new StringBuilder(length), IOUtils.LINE_SEPARATOR_UNIX, null, null, 0, null, null, 124)).toString();
        j.o(stringBuilder, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        AppMethodBeat.o(56295);
        return stringBuilder;
    }

    private static final int awv(String str) {
        int i;
        AppMethodBeat.i(56296);
        CharSequence charSequence = str;
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if ((!b.isWhitespace(charSequence.charAt(i2)) ? 1 : null) != null) {
                i = i2;
                break;
            }
        }
        i = -1;
        if (i == -1) {
            i = str.length();
            AppMethodBeat.o(56296);
            return i;
        }
        AppMethodBeat.o(56296);
        return i;
    }
}

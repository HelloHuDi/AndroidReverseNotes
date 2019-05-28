package p000a.p051k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p000a.C0220l;
import p000a.p001a.C25033k;
import p000a.p005f.p007b.C25052j;
import p000a.p009h.C0016h;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 ,2\u00060\u0001j\u0002`\u0002:\u0002,-B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001d\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n¢\u0006\u0002\u0010\u000bB\u000f\b\u0001\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u001d2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u0017J\u0011\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0004J\"\u0010 \u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00170\"J\u0016\u0010 \u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u0004J\u0016\u0010$\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u0004J\u001e\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010'\u001a\u00020\u001bJ\u0006\u0010(\u001a\u00020\rJ\b\u0010)\u001a\u00020\u0004H\u0016J\b\u0010*\u001a\u00020+H\u0002R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006."}, dWq = {"Lkotlin/text/Regex;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "pattern", "", "(Ljava/lang/String;)V", "option", "Lkotlin/text/RegexOption;", "(Ljava/lang/String;Lkotlin/text/RegexOption;)V", "options", "", "(Ljava/lang/String;Ljava/util/Set;)V", "nativePattern", "Ljava/util/regex/Pattern;", "(Ljava/util/regex/Pattern;)V", "_options", "getOptions", "()Ljava/util/Set;", "getPattern", "()Ljava/lang/String;", "containsMatchIn", "", "input", "", "find", "Lkotlin/text/MatchResult;", "startIndex", "", "findAll", "Lkotlin/sequences/Sequence;", "matchEntire", "matches", "replace", "transform", "Lkotlin/Function1;", "replacement", "replaceFirst", "split", "", "limit", "toPattern", "toString", "writeReplace", "", "Companion", "Serialized", "kotlin-stdlib"})
/* renamed from: a.k.k */
public final class C25274k implements Serializable {
    public static final C25276a BPg = new C25276a();
    public final Pattern BPf;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \u000e2\u00060\u0001j\u0002`\u0002:\u0001\u000eB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, dWq = {"Lkotlin/text/Regex$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "pattern", "", "flags", "", "(Ljava/lang/String;I)V", "getFlags", "()I", "getPattern", "()Ljava/lang/String;", "readResolve", "", "Companion", "kotlin-stdlib"})
    /* renamed from: a.k.k$b */
    static final class C25275b implements Serializable {
        public static final C0217a BPh = new C0217a();
        private final int flags;
        private final String xAK;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lkotlin/text/Regex$Serialized$Companion;", "", "()V", "serialVersionUID", "", "kotlin-stdlib"})
        /* renamed from: a.k.k$b$a */
        public static final class C0217a {
            private C0217a() {
            }

            public /* synthetic */ C0217a(byte b) {
                this();
            }
        }

        static {
            AppMethodBeat.m2504i(56304);
            AppMethodBeat.m2505o(56304);
        }

        public C25275b(String str, int i) {
            C25052j.m39376p(str, "pattern");
            AppMethodBeat.m2504i(56303);
            this.xAK = str;
            this.flags = i;
            AppMethodBeat.m2505o(56303);
        }

        private final Object readResolve() {
            AppMethodBeat.m2504i(56302);
            Pattern compile = Pattern.compile(this.xAK, this.flags);
            C25052j.m39375o(compile, "Pattern.compile(pattern, flags)");
            C25274k c25274k = new C25274k(compile);
            AppMethodBeat.m2505o(56302);
            return c25274k;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007¨\u0006\f"}, dWq = {"Lkotlin/text/Regex$Companion;", "", "()V", "ensureUnicodeCase", "", "flags", "escape", "", "literal", "escapeReplacement", "fromLiteral", "Lkotlin/text/Regex;", "kotlin-stdlib"})
    /* renamed from: a.k.k$a */
    public static final class C25276a {
        private C25276a() {
        }

        public /* synthetic */ C25276a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(56277);
        AppMethodBeat.m2505o(56277);
    }

    public C25274k(Pattern pattern) {
        C25052j.m39376p(pattern, "nativePattern");
        AppMethodBeat.m2504i(56275);
        this.BPf = pattern;
        AppMethodBeat.m2505o(56275);
    }

    public C25274k(String str) {
        C25052j.m39376p(str, "pattern");
        Pattern compile = Pattern.compile(str);
        C25052j.m39375o(compile, "Pattern.compile(pattern)");
        this(compile);
        AppMethodBeat.m2504i(56276);
        AppMethodBeat.m2505o(56276);
    }

    /* renamed from: aq */
    public final boolean mo42119aq(CharSequence charSequence) {
        AppMethodBeat.m2504i(56269);
        C25052j.m39376p(charSequence, "input");
        boolean matches = this.BPf.matcher(charSequence).matches();
        AppMethodBeat.m2505o(56269);
        return matches;
    }

    /* renamed from: a */
    public static /* synthetic */ C8305i m39839a(C25274k c25274k, CharSequence charSequence) {
        AppMethodBeat.m2504i(56270);
        C25052j.m39376p(charSequence, "input");
        Matcher matcher = c25274k.BPf.matcher(charSequence);
        C25052j.m39375o(matcher, "nativePattern.matcher(input)");
        if (matcher.find(0)) {
            C8305i c25273j = new C25273j(matcher, charSequence);
            AppMethodBeat.m2505o(56270);
            return c25273j;
        }
        AppMethodBeat.m2505o(56270);
        return null;
    }

    /* renamed from: c */
    public final String mo42120c(CharSequence charSequence, String str) {
        AppMethodBeat.m2504i(56271);
        C25052j.m39376p(charSequence, "input");
        C25052j.m39376p(str, "replacement");
        String replaceFirst = this.BPf.matcher(charSequence).replaceFirst(str);
        C25052j.m39375o(replaceFirst, "nativePattern.matcher(in…replaceFirst(replacement)");
        AppMethodBeat.m2505o(56271);
        return replaceFirst;
    }

    /* renamed from: r */
    public final List<String> mo42121r(CharSequence charSequence, int i) {
        int i2 = 10;
        AppMethodBeat.m2504i(56272);
        C25052j.m39376p(charSequence, "input");
        if ((i >= 0 ? 1 : null) == null) {
            Throwable illegalArgumentException = new IllegalArgumentException(("Limit must be non-negative, but was " + i + '.').toString());
            AppMethodBeat.m2505o(56272);
            throw illegalArgumentException;
        }
        Matcher matcher = this.BPf.matcher(charSequence);
        if (!matcher.find() || i == 1) {
            List listOf = C25033k.listOf(charSequence.toString());
            AppMethodBeat.m2505o(56272);
            return listOf;
        }
        if (i > 0) {
            i2 = C0016h.m20in(i, 10);
        }
        ArrayList arrayList = new ArrayList(i2);
        int i3 = i - 1;
        i2 = 0;
        do {
            arrayList.add(charSequence.subSequence(i2, matcher.start()).toString());
            i2 = matcher.end();
            if (i3 >= 0 && arrayList.size() == i3) {
                break;
            }
        } while (matcher.find());
        arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
        List<String> list = arrayList;
        AppMethodBeat.m2505o(56272);
        return list;
    }

    public final String toString() {
        AppMethodBeat.m2504i(56273);
        String pattern = this.BPf.toString();
        C25052j.m39375o(pattern, "nativePattern.toString()");
        AppMethodBeat.m2505o(56273);
        return pattern;
    }

    private final Object writeReplace() {
        AppMethodBeat.m2504i(56274);
        String pattern = this.BPf.pattern();
        C25052j.m39375o(pattern, "nativePattern.pattern()");
        C25275b c25275b = new C25275b(pattern, this.BPf.flags());
        AppMethodBeat.m2505o(56274);
        return c25275b;
    }
}

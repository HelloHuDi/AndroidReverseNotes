package p000a.p051k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import p000a.C0220l;
import p000a.p001a.C0002b;
import p000a.p001a.C25035t;
import p000a.p001a.C36921a;
import p000a.p001a.C7987l;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p009h.C0016h;
import p000a.p009h.C31599d;
import p000a.p050j.C17348n;
import p000a.p051k.C8305i.C8306a;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, dWq = {"Lkotlin/text/MatcherMatchResult;", "Lkotlin/text/MatchResult;", "matcher", "Ljava/util/regex/Matcher;", "input", "", "(Ljava/util/regex/Matcher;Ljava/lang/CharSequence;)V", "groupValues", "", "", "getGroupValues", "()Ljava/util/List;", "groupValues_", "groups", "Lkotlin/text/MatchGroupCollection;", "getGroups", "()Lkotlin/text/MatchGroupCollection;", "matchResult", "Ljava/util/regex/MatchResult;", "kotlin.jvm.PlatformType", "range", "Lkotlin/ranges/IntRange;", "getRange", "()Lkotlin/ranges/IntRange;", "value", "getValue", "()Ljava/lang/String;", "next", "kotlin-stdlib"})
/* renamed from: a.k.j */
public final class C25273j implements C8305i {
    private final CharSequence BOQ;
    final MatchResult BOZ = this.BPc.toMatchResult();
    private final C37083g BPa = new C17357b(this);
    private List<String> BPb;
    private final Matcher BPc;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, dWq = {"kotlin/text/MatcherMatchResult$groupValues$1", "Lkotlin/collections/AbstractList;", "", "size", "", "getSize", "()I", "get", "index", "kotlin-stdlib"})
    /* renamed from: a.k.j$a */
    public static final class C17356a extends C0002b<String> {
        final /* synthetic */ C25273j BPd;

        C17356a(C25273j c25273j) {
            this.BPd = c25273j;
        }

        public final /* bridge */ boolean contains(Object obj) {
            AppMethodBeat.m2504i(56283);
            if (obj instanceof String) {
                boolean contains = super.contains((String) obj);
                AppMethodBeat.m2505o(56283);
                return contains;
            }
            AppMethodBeat.m2505o(56283);
            return false;
        }

        public final /* bridge */ int indexOf(Object obj) {
            AppMethodBeat.m2504i(56281);
            if (obj instanceof String) {
                int indexOf = super.indexOf((String) obj);
                AppMethodBeat.m2505o(56281);
                return indexOf;
            }
            AppMethodBeat.m2505o(56281);
            return -1;
        }

        public final /* bridge */ int lastIndexOf(Object obj) {
            AppMethodBeat.m2504i(56282);
            if (obj instanceof String) {
                int lastIndexOf = super.lastIndexOf((String) obj);
                AppMethodBeat.m2505o(56282);
                return lastIndexOf;
            }
            AppMethodBeat.m2505o(56282);
            return -1;
        }

        public final int getSize() {
            AppMethodBeat.m2504i(56279);
            int groupCount = this.BPd.BOZ.groupCount() + 1;
            AppMethodBeat.m2505o(56279);
            return groupCount;
        }

        public final /* synthetic */ Object get(int i) {
            AppMethodBeat.m2504i(56280);
            Object group = this.BPd.BOZ.group(i);
            if (group == null) {
                group = "";
            }
            AppMethodBeat.m2505o(56280);
            return group;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\u0011\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000fH\u0002R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, dWq = {"kotlin/text/MatcherMatchResult$groups$1", "Lkotlin/text/MatchNamedGroupCollection;", "Lkotlin/collections/AbstractCollection;", "Lkotlin/text/MatchGroup;", "size", "", "getSize", "()I", "get", "index", "name", "", "isEmpty", "", "iterator", "", "kotlin-stdlib"})
    /* renamed from: a.k.j$b */
    public static final class C17357b extends C36921a<C44938f> implements C44939h {
        final /* synthetic */ C25273j BPd;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "Lkotlin/text/MatchGroup;", "it", "", "invoke"})
        /* renamed from: a.k.j$b$a */
        static final class C8307a extends C25053k implements C17126b<Integer, C44938f> {
            final /* synthetic */ C17357b BPe;

            C8307a(C17357b c17357b) {
                this.BPe = c17357b;
                super(1);
            }

            /* renamed from: am */
            public final /* synthetic */ Object mo50am(Object obj) {
                AppMethodBeat.m2504i(56268);
                int intValue = ((Number) obj).intValue();
                C17357b c17357b = this.BPe;
                MatchResult matchResult = c17357b.BPd.BOZ;
                C25052j.m39375o(matchResult, "matchResult");
                C31599d il = C0016h.m18il(matchResult.start(intValue), matchResult.end(intValue));
                if (il.AVJ >= 0) {
                    String group = c17357b.BPd.BOZ.group(intValue);
                    C25052j.m39375o(group, "matchResult.group(index)");
                    C44938f c44938f = new C44938f(group, il);
                    AppMethodBeat.m2505o(56268);
                    return c44938f;
                }
                AppMethodBeat.m2505o(56268);
                return null;
            }
        }

        C17357b(C25273j c25273j) {
            this.BPd = c25273j;
        }

        public final /* bridge */ boolean contains(Object obj) {
            AppMethodBeat.m2504i(56290);
            if (obj != null ? obj instanceof C44938f : true) {
                boolean contains = super.contains((C44938f) obj);
                AppMethodBeat.m2505o(56290);
                return contains;
            }
            AppMethodBeat.m2505o(56290);
            return false;
        }

        public final int getSize() {
            AppMethodBeat.m2504i(56288);
            int groupCount = this.BPd.BOZ.groupCount() + 1;
            AppMethodBeat.m2505o(56288);
            return groupCount;
        }

        public final boolean isEmpty() {
            return false;
        }

        public final Iterator<C44938f> iterator() {
            AppMethodBeat.m2504i(56289);
            Iterator it = C17348n.m26863d(C25035t.m39359t(C7987l.m14174g(this)), new C8307a(this)).iterator();
            AppMethodBeat.m2505o(56289);
            return it;
        }
    }

    public C25273j(Matcher matcher, CharSequence charSequence) {
        C25052j.m39376p(matcher, "matcher");
        C25052j.m39376p(charSequence, "input");
        AppMethodBeat.m2504i(56293);
        this.BPc = matcher;
        this.BOQ = charSequence;
        AppMethodBeat.m2505o(56293);
    }

    public final String getValue() {
        AppMethodBeat.m2504i(56291);
        String group = this.BOZ.group();
        C25052j.m39375o(group, "matchResult.group()");
        AppMethodBeat.m2505o(56291);
        return group;
    }

    public final List<String> ekM() {
        AppMethodBeat.m2504i(56292);
        if (this.BPb == null) {
            this.BPb = new C17356a(this);
        }
        List list = this.BPb;
        if (list == null) {
            C25052j.dWJ();
        }
        AppMethodBeat.m2505o(56292);
        return list;
    }

    public final C8306a ekN() {
        AppMethodBeat.m2504i(56294);
        C8306a c8306a = new C8306a(this);
        AppMethodBeat.m2505o(56294);
        return c8306a;
    }
}

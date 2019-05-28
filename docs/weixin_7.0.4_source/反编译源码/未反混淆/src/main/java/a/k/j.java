package a.k;

import a.a.t;
import a.f.b.k;
import a.h.d;
import a.h.h;
import a.j.n;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;

@l(dWo = {1, 1, 13}, dWp = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, dWq = {"Lkotlin/text/MatcherMatchResult;", "Lkotlin/text/MatchResult;", "matcher", "Ljava/util/regex/Matcher;", "input", "", "(Ljava/util/regex/Matcher;Ljava/lang/CharSequence;)V", "groupValues", "", "", "getGroupValues", "()Ljava/util/List;", "groupValues_", "groups", "Lkotlin/text/MatchGroupCollection;", "getGroups", "()Lkotlin/text/MatchGroupCollection;", "matchResult", "Ljava/util/regex/MatchResult;", "kotlin.jvm.PlatformType", "range", "Lkotlin/ranges/IntRange;", "getRange", "()Lkotlin/ranges/IntRange;", "value", "getValue", "()Ljava/lang/String;", "next", "kotlin-stdlib"})
public final class j implements i {
    private final CharSequence BOQ;
    final MatchResult BOZ = this.BPc.toMatchResult();
    private final g BPa = new b(this);
    private List<String> BPb;
    private final Matcher BPc;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, dWq = {"kotlin/text/MatcherMatchResult$groupValues$1", "Lkotlin/collections/AbstractList;", "", "size", "", "getSize", "()I", "get", "index", "kotlin-stdlib"})
    public static final class a extends a.a.b<String> {
        final /* synthetic */ j BPd;

        a(j jVar) {
            this.BPd = jVar;
        }

        public final /* bridge */ boolean contains(Object obj) {
            AppMethodBeat.i(56283);
            if (obj instanceof String) {
                boolean contains = super.contains((String) obj);
                AppMethodBeat.o(56283);
                return contains;
            }
            AppMethodBeat.o(56283);
            return false;
        }

        public final /* bridge */ int indexOf(Object obj) {
            AppMethodBeat.i(56281);
            if (obj instanceof String) {
                int indexOf = super.indexOf((String) obj);
                AppMethodBeat.o(56281);
                return indexOf;
            }
            AppMethodBeat.o(56281);
            return -1;
        }

        public final /* bridge */ int lastIndexOf(Object obj) {
            AppMethodBeat.i(56282);
            if (obj instanceof String) {
                int lastIndexOf = super.lastIndexOf((String) obj);
                AppMethodBeat.o(56282);
                return lastIndexOf;
            }
            AppMethodBeat.o(56282);
            return -1;
        }

        public final int getSize() {
            AppMethodBeat.i(56279);
            int groupCount = this.BPd.BOZ.groupCount() + 1;
            AppMethodBeat.o(56279);
            return groupCount;
        }

        public final /* synthetic */ Object get(int i) {
            AppMethodBeat.i(56280);
            Object group = this.BPd.BOZ.group(i);
            if (group == null) {
                group = "";
            }
            AppMethodBeat.o(56280);
            return group;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\u0011\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000fH\u0002R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, dWq = {"kotlin/text/MatcherMatchResult$groups$1", "Lkotlin/text/MatchNamedGroupCollection;", "Lkotlin/collections/AbstractCollection;", "Lkotlin/text/MatchGroup;", "size", "", "getSize", "()I", "get", "index", "name", "", "isEmpty", "", "iterator", "", "kotlin-stdlib"})
    public static final class b extends a.a.a<f> implements h {
        final /* synthetic */ j BPd;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "Lkotlin/text/MatchGroup;", "it", "", "invoke"})
        static final class a extends k implements a.f.a.b<Integer, f> {
            final /* synthetic */ b BPe;

            a(b bVar) {
                this.BPe = bVar;
                super(1);
            }

            public final /* synthetic */ Object am(Object obj) {
                AppMethodBeat.i(56268);
                int intValue = ((Number) obj).intValue();
                b bVar = this.BPe;
                MatchResult matchResult = bVar.BPd.BOZ;
                a.f.b.j.o(matchResult, "matchResult");
                d il = h.il(matchResult.start(intValue), matchResult.end(intValue));
                if (il.AVJ >= 0) {
                    String group = bVar.BPd.BOZ.group(intValue);
                    a.f.b.j.o(group, "matchResult.group(index)");
                    f fVar = new f(group, il);
                    AppMethodBeat.o(56268);
                    return fVar;
                }
                AppMethodBeat.o(56268);
                return null;
            }
        }

        b(j jVar) {
            this.BPd = jVar;
        }

        public final /* bridge */ boolean contains(Object obj) {
            AppMethodBeat.i(56290);
            if (obj != null ? obj instanceof f : true) {
                boolean contains = super.contains((f) obj);
                AppMethodBeat.o(56290);
                return contains;
            }
            AppMethodBeat.o(56290);
            return false;
        }

        public final int getSize() {
            AppMethodBeat.i(56288);
            int groupCount = this.BPd.BOZ.groupCount() + 1;
            AppMethodBeat.o(56288);
            return groupCount;
        }

        public final boolean isEmpty() {
            return false;
        }

        public final Iterator<f> iterator() {
            AppMethodBeat.i(56289);
            Iterator it = n.d(t.t(a.a.l.g(this)), new a(this)).iterator();
            AppMethodBeat.o(56289);
            return it;
        }
    }

    public j(Matcher matcher, CharSequence charSequence) {
        a.f.b.j.p(matcher, "matcher");
        a.f.b.j.p(charSequence, "input");
        AppMethodBeat.i(56293);
        this.BPc = matcher;
        this.BOQ = charSequence;
        AppMethodBeat.o(56293);
    }

    public final String getValue() {
        AppMethodBeat.i(56291);
        String group = this.BOZ.group();
        a.f.b.j.o(group, "matchResult.group()");
        AppMethodBeat.o(56291);
        return group;
    }

    public final List<String> ekM() {
        AppMethodBeat.i(56292);
        if (this.BPb == null) {
            this.BPb = new a(this);
        }
        List list = this.BPb;
        if (list == null) {
            a.f.b.j.dWJ();
        }
        AppMethodBeat.o(56292);
        return list;
    }

    public final a.k.i.a ekN() {
        AppMethodBeat.i(56294);
        a.k.i.a aVar = new a.k.i.a(this);
        AppMethodBeat.o(56294);
        return aVar;
    }
}

package p000a.p001a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.p1144a.C41374a;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\bÂ\u0002\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00060\u0004j\u0002`\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0003H\u0016J\u0013\u0010\u001d\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002H\u0002J\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010 \u001a\u00020\u0011H\u0016J\b\u0010!\u001a\u00020\u0019H\u0016J\b\u0010\"\u001a\u00020\u0002H\u0002J\b\u0010#\u001a\u00020$H\u0016R(\u0010\u0007\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\t0\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u00158VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, dWq = {"Lkotlin/collections/EmptyMap;", "", "", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "serialVersionUID", "", "size", "", "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "containsKey", "", "key", "containsValue", "value", "equals", "other", "get", "hashCode", "isEmpty", "readResolve", "toString", "", "kotlin-stdlib"})
/* renamed from: a.a.w */
final class C17116w implements C41374a, Serializable, Map {
    public static final C17116w AUQ = new C17116w();

    public final void clear() {
        AppMethodBeat.m2504i(56151);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.m2505o(56151);
        throw unsupportedOperationException;
    }

    public final /* synthetic */ Object put(Object obj, Object obj2) {
        AppMethodBeat.m2504i(56154);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.m2505o(56154);
        throw unsupportedOperationException;
    }

    public final void putAll(Map map) {
        AppMethodBeat.m2504i(56152);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.m2505o(56152);
        throw unsupportedOperationException;
    }

    public final Object remove(Object obj) {
        AppMethodBeat.m2504i(56153);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.m2505o(56153);
        throw unsupportedOperationException;
    }

    static {
        AppMethodBeat.m2504i(56150);
        AppMethodBeat.m2505o(56150);
    }

    private C17116w() {
    }

    public final boolean containsValue(Object obj) {
        AppMethodBeat.m2504i(56149);
        if (obj instanceof Void) {
            C25052j.m39376p((Void) obj, "value");
            AppMethodBeat.m2505o(56149);
        } else {
            AppMethodBeat.m2505o(56149);
        }
        return false;
    }

    public final /* bridge */ Object get(Object obj) {
        return null;
    }

    public final /* bridge */ int size() {
        return 0;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(56148);
        if ((obj instanceof Map) && ((Map) obj).isEmpty()) {
            AppMethodBeat.m2505o(56148);
            return true;
        }
        AppMethodBeat.m2505o(56148);
        return false;
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return "{}";
    }

    public final boolean isEmpty() {
        return true;
    }

    public final boolean containsKey(Object obj) {
        return false;
    }

    private final Object readResolve() {
        return AUQ;
    }

    public final /* bridge */ Set<Entry> entrySet() {
        return C44629x.AUR;
    }

    public final /* bridge */ Set<Object> keySet() {
        return C44629x.AUR;
    }

    public final /* bridge */ Collection values() {
        return C17115v.AUP;
    }
}

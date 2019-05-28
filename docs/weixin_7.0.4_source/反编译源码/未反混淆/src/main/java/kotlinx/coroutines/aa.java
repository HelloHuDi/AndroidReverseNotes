package kotlinx.coroutines;

import a.c.e;
import a.c.e.b;
import a.c.e.c;
import a.f.a.m;
import a.f.b.j;
import a.k.v;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(dWo = {1, 1, 13}, dWp = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\b\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0018B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\t\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0019"}, dWq = {"Lkotlinx/coroutines/CoroutineId;", "Lkotlinx/coroutines/ThreadContextElement;", "", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "id", "", "(J)V", "getId", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "restoreThreadContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "oldState", "toString", "updateThreadContext", "Key", "kotlinx-coroutines-core"})
public final class aa extends a.c.a implements bq<String> {
    public static final a BPL = new a();
    final long id;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, dWq = {"Lkotlinx/coroutines/CoroutineId$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/CoroutineId;", "()V", "kotlinx-coroutines-core"})
    public static final class a implements c<aa> {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.i(118554);
        AppMethodBeat.o(118554);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof aa)) {
                return false;
            }
            if (!(this.id == ((aa) obj).id)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        long j = this.id;
        return (int) (j ^ (j >>> 32));
    }

    public aa(long j) {
        super(BPL);
        AppMethodBeat.i(118553);
        this.id = j;
        AppMethodBeat.o(118553);
    }

    public final /* synthetic */ void a(e eVar, Object obj) {
        AppMethodBeat.i(118552);
        String str = (String) obj;
        j.p(eVar, "context");
        j.p(str, "oldState");
        Thread currentThread = Thread.currentThread();
        j.o(currentThread, "Thread.currentThread()");
        currentThread.setName(str);
        AppMethodBeat.o(118552);
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ Object c(e eVar) {
        String str;
        String str2;
        Thread currentThread;
        String name;
        int d;
        StringBuilder stringBuilder;
        AppMethodBeat.i(118551);
        j.p(eVar, "context");
        ab abVar = (ab) eVar.get(ab.BPM);
        if (abVar != null) {
            str = abVar.name;
            if (str != null) {
                str2 = str;
                currentThread = Thread.currentThread();
                j.o(currentThread, "currentThread");
                name = currentThread.getName();
                j.o(name, "oldName");
                d = v.d((CharSequence) name, " @");
                if (d < 0) {
                    d = name.length();
                }
                stringBuilder = new StringBuilder((str2.length() + d) + 10);
                str = name.substring(0, d);
                j.o(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                stringBuilder.append(str);
                stringBuilder.append(" @");
                stringBuilder.append(str2);
                stringBuilder.append('#');
                stringBuilder.append(this.id);
                str = stringBuilder.toString();
                j.o(str, "StringBuilder(capacity).…builderAction).toString()");
                currentThread.setName(str);
                AppMethodBeat.o(118551);
                return name;
            }
        }
        str2 = "coroutine";
        currentThread = Thread.currentThread();
        j.o(currentThread, "currentThread");
        name = currentThread.getName();
        j.o(name, "oldName");
        d = v.d((CharSequence) name, " @");
        if (d < 0) {
        }
        stringBuilder = new StringBuilder((str2.length() + d) + 10);
        str = name.substring(0, d);
        j.o(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        stringBuilder.append(str);
        stringBuilder.append(" @");
        stringBuilder.append(str2);
        stringBuilder.append('#');
        stringBuilder.append(this.id);
        str = stringBuilder.toString();
        j.o(str, "StringBuilder(capacity).…builderAction).toString()");
        currentThread.setName(str);
        AppMethodBeat.o(118551);
        return name;
    }

    public final String toString() {
        AppMethodBeat.i(118550);
        String str = "CoroutineId(" + this.id + ')';
        AppMethodBeat.o(118550);
        return str;
    }

    public final <R> R fold(R r, m<? super R, ? super b, ? extends R> mVar) {
        AppMethodBeat.i(118555);
        j.p(mVar, "operation");
        j.p(mVar, "operation");
        Object a = a.c.e.b.a.a(this, r, mVar);
        AppMethodBeat.o(118555);
        return a;
    }

    public final <E extends b> E get(c<E> cVar) {
        AppMethodBeat.i(118556);
        j.p(cVar, "key");
        j.p(cVar, "key");
        b a = a.c.e.b.a.a((b) this, (c) cVar);
        AppMethodBeat.o(118556);
        return a;
    }

    public final e minusKey(c<?> cVar) {
        AppMethodBeat.i(118557);
        j.p(cVar, "key");
        j.p(cVar, "key");
        e b = a.c.e.b.a.b(this, cVar);
        AppMethodBeat.o(118557);
        return b;
    }

    public final e plus(e eVar) {
        AppMethodBeat.i(118558);
        j.p(eVar, "context");
        j.p(eVar, "context");
        e a = a.c.e.b.a.a((b) this, eVar);
        AppMethodBeat.o(118558);
        return a;
    }
}

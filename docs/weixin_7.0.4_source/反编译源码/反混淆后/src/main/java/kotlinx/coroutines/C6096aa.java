package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;
import p000a.p002c.C25044a;
import p000a.p002c.C41366e;
import p000a.p002c.C41366e.C36928c;
import p000a.p002c.C41366e.C41367b;
import p000a.p002c.C41366e.C41367b.C17124a;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C31820v;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\b\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0018B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\t\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0019"}, dWq = {"Lkotlinx/coroutines/CoroutineId;", "Lkotlinx/coroutines/ThreadContextElement;", "", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "id", "", "(J)V", "getId", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "restoreThreadContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "oldState", "toString", "updateThreadContext", "Key", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.aa */
public final class C6096aa extends C25044a implements C16462bq<String> {
    public static final C6097a BPL = new C6097a();
    /* renamed from: id */
    final long f1690id;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, dWq = {"Lkotlinx/coroutines/CoroutineId$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/CoroutineId;", "()V", "kotlinx-coroutines-core"})
    /* renamed from: kotlinx.coroutines.aa$a */
    public static final class C6097a implements C36928c<C6096aa> {
        private C6097a() {
        }

        public /* synthetic */ C6097a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(118554);
        AppMethodBeat.m2505o(118554);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof C6096aa)) {
                return false;
            }
            if (!(this.f1690id == ((C6096aa) obj).f1690id)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        long j = this.f1690id;
        return (int) (j ^ (j >>> 32));
    }

    public C6096aa(long j) {
        super(BPL);
        AppMethodBeat.m2504i(118553);
        this.f1690id = j;
        AppMethodBeat.m2505o(118553);
    }

    /* renamed from: a */
    public final /* synthetic */ void mo13486a(C41366e c41366e, Object obj) {
        AppMethodBeat.m2504i(118552);
        String str = (String) obj;
        C25052j.m39376p(c41366e, "context");
        C25052j.m39376p(str, "oldState");
        Thread currentThread = Thread.currentThread();
        C25052j.m39375o(currentThread, "Thread.currentThread()");
        currentThread.setName(str);
        AppMethodBeat.m2505o(118552);
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    public final /* synthetic */ Object mo13487c(C41366e c41366e) {
        String str;
        String str2;
        Thread currentThread;
        String name;
        int d;
        StringBuilder stringBuilder;
        AppMethodBeat.m2504i(118551);
        C25052j.m39376p(c41366e, "context");
        C24583ab c24583ab = (C24583ab) c41366e.get(C24583ab.BPM);
        if (c24583ab != null) {
            str = c24583ab.name;
            if (str != null) {
                str2 = str;
                currentThread = Thread.currentThread();
                C25052j.m39375o(currentThread, "currentThread");
                name = currentThread.getName();
                C25052j.m39375o(name, "oldName");
                d = C31820v.m51539d((CharSequence) name, " @");
                if (d < 0) {
                    d = name.length();
                }
                stringBuilder = new StringBuilder((str2.length() + d) + 10);
                str = name.substring(0, d);
                C25052j.m39375o(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                stringBuilder.append(str);
                stringBuilder.append(" @");
                stringBuilder.append(str2);
                stringBuilder.append('#');
                stringBuilder.append(this.f1690id);
                str = stringBuilder.toString();
                C25052j.m39375o(str, "StringBuilder(capacity).…builderAction).toString()");
                currentThread.setName(str);
                AppMethodBeat.m2505o(118551);
                return name;
            }
        }
        str2 = "coroutine";
        currentThread = Thread.currentThread();
        C25052j.m39375o(currentThread, "currentThread");
        name = currentThread.getName();
        C25052j.m39375o(name, "oldName");
        d = C31820v.m51539d((CharSequence) name, " @");
        if (d < 0) {
        }
        stringBuilder = new StringBuilder((str2.length() + d) + 10);
        str = name.substring(0, d);
        C25052j.m39375o(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        stringBuilder.append(str);
        stringBuilder.append(" @");
        stringBuilder.append(str2);
        stringBuilder.append('#');
        stringBuilder.append(this.f1690id);
        str = stringBuilder.toString();
        C25052j.m39375o(str, "StringBuilder(capacity).…builderAction).toString()");
        currentThread.setName(str);
        AppMethodBeat.m2505o(118551);
        return name;
    }

    public final String toString() {
        AppMethodBeat.m2504i(118550);
        String str = "CoroutineId(" + this.f1690id + ')';
        AppMethodBeat.m2505o(118550);
        return str;
    }

    public final <R> R fold(R r, C31591m<? super R, ? super C41367b, ? extends R> c31591m) {
        AppMethodBeat.m2504i(118555);
        C25052j.m39376p(c31591m, "operation");
        C25052j.m39376p(c31591m, "operation");
        Object a = C17124a.m26497a(this, r, c31591m);
        AppMethodBeat.m2505o(118555);
        return a;
    }

    public final <E extends C41367b> E get(C36928c<E> c36928c) {
        AppMethodBeat.m2504i(118556);
        C25052j.m39376p(c36928c, "key");
        C25052j.m39376p(c36928c, "key");
        C41367b a = C17124a.m26495a((C41367b) this, (C36928c) c36928c);
        AppMethodBeat.m2505o(118556);
        return a;
    }

    public final C41366e minusKey(C36928c<?> c36928c) {
        AppMethodBeat.m2504i(118557);
        C25052j.m39376p(c36928c, "key");
        C25052j.m39376p(c36928c, "key");
        C41366e b = C17124a.m26498b(this, c36928c);
        AppMethodBeat.m2505o(118557);
        return b;
    }

    public final C41366e plus(C41366e c41366e) {
        AppMethodBeat.m2504i(118558);
        C25052j.m39376p(c41366e, "context");
        C25052j.m39376p(c41366e, "context");
        C41366e a = C17124a.m26496a((C41367b) this, c41366e);
        AppMethodBeat.m2505o(118558);
        return a;
    }
}

package a.a;

import a.f.b.j;
import a.h.d;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u001d\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u000bH\u0016J\u0016\u0010\u0010\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010\u0011J\u0015\u0010\u0012\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\u0011J\u001e\u0010\u0013\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0014R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, dWq = {"Lkotlin/collections/ReversedList;", "T", "Lkotlin/collections/AbstractMutableList;", "delegate", "", "(Ljava/util/List;)V", "size", "", "getSize", "()I", "add", "", "index", "element", "(ILjava/lang/Object;)V", "clear", "get", "(I)Ljava/lang/Object;", "removeAt", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"})
public final class ai<T> extends c<T> {
    private final List<T> AUU;

    public ai(List<T> list) {
        j.p(list, "delegate");
        AppMethodBeat.i(56036);
        this.AUU = list;
        AppMethodBeat.o(56036);
    }

    public final int getSize() {
        AppMethodBeat.i(56030);
        int size = this.AUU.size();
        AppMethodBeat.o(56030);
        return size;
    }

    public final T get(int i) {
        AppMethodBeat.i(56031);
        Object obj = this.AUU.get(r.w(this, i));
        AppMethodBeat.o(56031);
        return obj;
    }

    public final void clear() {
        AppMethodBeat.i(56032);
        this.AUU.clear();
        AppMethodBeat.o(56032);
    }

    public final T removeAt(int i) {
        AppMethodBeat.i(56033);
        Object remove = this.AUU.remove(r.w(this, i));
        AppMethodBeat.o(56033);
        return remove;
    }

    public final T set(int i, T t) {
        AppMethodBeat.i(56034);
        Object obj = this.AUU.set(r.w(this, i), t);
        AppMethodBeat.o(56034);
        return obj;
    }

    public final void add(int i, T t) {
        AppMethodBeat.i(56035);
        List list = this.AUU;
        int size = size();
        if (i >= 0 && size >= i) {
            list.add(size() - i, t);
            AppMethodBeat.o(56035);
            return;
        }
        Throwable indexOutOfBoundsException = new IndexOutOfBoundsException("Position index " + i + " must be in range [" + new d(0, size()) + "].");
        AppMethodBeat.o(56035);
        throw indexOutOfBoundsException;
    }
}

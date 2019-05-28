package a.h;

import a.a.ab;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.NoSuchElementException;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\b\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, dWq = {"Lkotlin/ranges/IntProgressionIterator;", "Lkotlin/collections/IntIterator;", "first", "", "last", "step", "(III)V", "finalElement", "hasNext", "", "next", "getStep", "()I", "nextInt", "kotlin-stdlib"})
public final class c extends ab {
    private final int AVM;
    private boolean AVN;
    private int AVO;
    private final int hzv;

    public c(int i, int i2, int i3) {
        boolean z = true;
        AppMethodBeat.i(55994);
        this.hzv = i3;
        this.AVM = i2;
        if (this.hzv > 0) {
            if (i > i2) {
                z = false;
            }
        } else if (i < i2) {
            z = false;
        }
        this.AVN = z;
        if (!this.AVN) {
            i = this.AVM;
        }
        this.AVO = i;
        AppMethodBeat.o(55994);
    }

    public final boolean hasNext() {
        return this.AVN;
    }

    public final int nextInt() {
        AppMethodBeat.i(55993);
        int i = this.AVO;
        if (i != this.AVM) {
            this.AVO += this.hzv;
        } else if (this.AVN) {
            this.AVN = false;
        } else {
            Throwable noSuchElementException = new NoSuchElementException();
            AppMethodBeat.o(55993);
            throw noSuchElementException;
        }
        AppMethodBeat.o(55993);
        return i;
    }
}

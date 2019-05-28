package android.support.constraint.p780a.p781a;

import java.util.HashSet;
import java.util.Iterator;

/* renamed from: android.support.constraint.a.a.o */
public class C25288o {
    /* renamed from: kt */
    HashSet<C25288o> f5051kt = new HashSet(2);
    public int state = 0;

    /* renamed from: a */
    public final void mo42142a(C25288o c25288o) {
        this.f5051kt.add(c25288o);
    }

    public void reset() {
        this.state = 0;
        this.f5051kt.clear();
    }

    public final void invalidate() {
        this.state = 0;
        Iterator it = this.f5051kt.iterator();
        while (it.hasNext()) {
            ((C25288o) it.next()).invalidate();
        }
    }

    /* renamed from: bf */
    public final void mo42144bf() {
        this.state = 1;
        Iterator it = this.f5051kt.iterator();
        while (it.hasNext()) {
            ((C25288o) it.next()).mo42143aE();
        }
    }

    /* renamed from: bg */
    public final boolean mo42145bg() {
        return this.state == 1;
    }

    /* renamed from: aE */
    public void mo42143aE() {
    }
}

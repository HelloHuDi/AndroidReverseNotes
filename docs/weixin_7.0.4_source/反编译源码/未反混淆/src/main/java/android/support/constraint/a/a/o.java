package android.support.constraint.a.a;

import java.util.HashSet;
import java.util.Iterator;

public class o {
    HashSet<o> kt = new HashSet(2);
    public int state = 0;

    public final void a(o oVar) {
        this.kt.add(oVar);
    }

    public void reset() {
        this.state = 0;
        this.kt.clear();
    }

    public final void invalidate() {
        this.state = 0;
        Iterator it = this.kt.iterator();
        while (it.hasNext()) {
            ((o) it.next()).invalidate();
        }
    }

    public final void bf() {
        this.state = 1;
        Iterator it = this.kt.iterator();
        while (it.hasNext()) {
            ((o) it.next()).aE();
        }
    }

    public final boolean bg() {
        return this.state == 1;
    }

    public void aE() {
    }
}

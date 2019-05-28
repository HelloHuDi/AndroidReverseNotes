package a.i.b.a.c.b;

import a.f.b.j;
import a.i.b.a.c.i.e.a.e;

public abstract class az {
    public final boolean Bfm;
    private final String name;

    public abstract boolean b(e eVar, p pVar, l lVar);

    protected az(String str, boolean z) {
        j.p(str, "name");
        this.name = str;
        this.Bfm = z;
    }

    /* Access modifiers changed, original: protected */
    public Integer c(az azVar) {
        j.p(azVar, "visibility");
        return ay.a(this, azVar);
    }

    public String getDisplayName() {
        return this.name;
    }

    public final String toString() {
        return getDisplayName();
    }

    public az eag() {
        return this;
    }
}

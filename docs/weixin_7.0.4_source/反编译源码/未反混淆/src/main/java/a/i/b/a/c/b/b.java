package a.i.b.a.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;

public interface b extends a, v {

    public enum a {
        DECLARATION,
        FAKE_OVERRIDE,
        DELEGATION,
        SYNTHESIZED;

        static {
            AppMethodBeat.o(119246);
        }

        public final boolean dZa() {
            return this != FAKE_OVERRIDE;
        }
    }

    b a(l lVar, w wVar, az azVar, a aVar);

    Collection<? extends b> dYX();

    b dYY();

    a dYZ();

    void k(Collection<? extends b> collection);
}

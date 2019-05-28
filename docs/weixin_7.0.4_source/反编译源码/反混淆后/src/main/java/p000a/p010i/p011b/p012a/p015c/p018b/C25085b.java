package p000a.p010i.p011b.p012a.p015c.p018b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;

/* renamed from: a.i.b.a.c.b.b */
public interface C25085b extends C8045a, C36966v {

    /* renamed from: a.i.b.a.c.b.b$a */
    public enum C8063a {
        DECLARATION,
        FAKE_OVERRIDE,
        DELEGATION,
        SYNTHESIZED;

        static {
            AppMethodBeat.m2505o(119246);
        }

        public final boolean dZa() {
            return this != FAKE_OVERRIDE;
        }
    }

    /* renamed from: a */
    C25085b mo17863a(C31642l c31642l, C44879w c44879w, C25082az c25082az, C8063a c8063a);

    Collection<? extends C25085b> dYX();

    C25085b dYY();

    C8063a dYZ();

    /* renamed from: k */
    void mo41960k(Collection<? extends C25085b> collection);
}

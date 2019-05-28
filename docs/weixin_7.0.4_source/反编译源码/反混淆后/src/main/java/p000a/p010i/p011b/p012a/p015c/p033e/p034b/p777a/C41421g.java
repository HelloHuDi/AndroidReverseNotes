package p000a.p010i.p011b.p012a.p015c.p033e.p034b.p777a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C31698a;

/* renamed from: a.i.b.a.c.e.b.a.g */
public final class C41421g extends C31698a {
    public static final C41421g Byu = new C41421g(1, 1, 13);
    public static final C41421g Byv = new C41421g(new int[0]);
    public static final C25153a Byw = new C25153a();
    private final boolean Byt;

    /* renamed from: a.i.b.a.c.e.b.a.g$a */
    public static final class C25153a {
        private C25153a() {
        }

        public /* synthetic */ C25153a(byte b) {
            this();
        }
    }

    public C41421g(int[] iArr, boolean z) {
        C25052j.m39376p(iArr, "versionArray");
        super(Arrays.copyOf(iArr, iArr.length));
        AppMethodBeat.m2504i(121319);
        this.Byt = z;
        AppMethodBeat.m2505o(121319);
    }

    public C41421g(int... iArr) {
        C25052j.m39376p(iArr, "numbers");
        this(iArr, false);
        AppMethodBeat.m2504i(121320);
        AppMethodBeat.m2505o(121320);
    }

    static {
        AppMethodBeat.m2504i(121321);
        AppMethodBeat.m2505o(121321);
    }

    public final boolean ehy() {
        AppMethodBeat.m2504i(121318);
        if (!(this.major == 1 && this.minor == 0)) {
            Object obj;
            int obj2;
            if (this.Byt) {
                C31698a c31698a = Byu;
                C25052j.m39376p(c31698a, "ourVersion");
                if (this.major == 0) {
                    obj2 = (c31698a.major == 0 && this.minor == c31698a.minor) ? 1 : null;
                } else if (this.major != c31698a.major || this.minor > c31698a.minor) {
                    obj2 = null;
                } else {
                    obj2 = 1;
                }
            } else if (this.major != 1 || this.minor > 4) {
                obj2 = null;
            } else {
                obj2 = 1;
            }
            if (obj2 != null) {
                AppMethodBeat.m2505o(121318);
                return true;
            }
        }
        AppMethodBeat.m2505o(121318);
        return false;
    }
}

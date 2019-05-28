package p000a.p010i.p011b.p012a.p015c.p035g;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: a.i.b.a.c.g.z */
public final class C17273z {
    static final int BAN = 11;
    static final int BAO = 12;
    static final int BAP = 16;
    static final int BAQ = 26;

    /* renamed from: a.i.b.a.c.g.z$a */
    public enum C8190a {
        DOUBLE(C17274b.DOUBLE, 1),
        FLOAT(C17274b.FLOAT, 5),
        INT64(C17274b.LONG, 0),
        UINT64(C17274b.LONG, 0),
        INT32(C17274b.INT, 0),
        FIXED64(C17274b.LONG, 1),
        FIXED32(C17274b.INT, 5),
        BOOL(C17274b.BOOLEAN, 0),
        STRING {
            public final boolean eiN() {
                return false;
            }
        },
        GROUP {
            public final boolean eiN() {
                return false;
            }
        },
        MESSAGE {
            public final boolean eiN() {
                return false;
            }
        },
        BYTES {
            public final boolean eiN() {
                return false;
            }
        },
        UINT32(C17274b.INT, 0),
        ENUM(C17274b.ENUM, 0),
        SFIXED32(C17274b.INT, 5),
        SFIXED64(C17274b.LONG, 1),
        SINT32(C17274b.INT, 0),
        SINT64(C17274b.LONG, 0);
        
        final C17274b BBj;
        final int BBk;

        static {
            AppMethodBeat.m2505o(121691);
        }

        private C8190a(C17274b c17274b, int i) {
            this.BBj = c17274b;
            this.BBk = i;
        }

        public boolean eiN() {
            return true;
        }
    }

    /* renamed from: a.i.b.a.c.g.z$b */
    public enum C17274b {
        INT(Integer.valueOf(0)),
        LONG(Long.valueOf(0)),
        FLOAT(Float.valueOf(0.0f)),
        DOUBLE(Double.valueOf(0.0d)),
        BOOLEAN(Boolean.FALSE),
        STRING(""),
        BYTE_STRING(C31710d.Bzq),
        ENUM(null),
        MESSAGE(null);
        
        private final Object BBv;

        static {
            AppMethodBeat.m2505o(121694);
        }

        private C17274b(Object obj) {
            this.BBv = obj;
        }
    }

    /* renamed from: fy */
    static int m26754fy(int i) {
        return i & 7;
    }

    /* renamed from: fz */
    public static int m26755fz(int i) {
        return i >>> 3;
    }

    /* renamed from: bv */
    static int m26753bv(int i, int i2) {
        return (i << 3) | i2;
    }
}

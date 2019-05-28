package a.i.b.a.c.g;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class z {
    static final int BAN = 11;
    static final int BAO = 12;
    static final int BAP = 16;
    static final int BAQ = 26;

    public enum a {
        DOUBLE(b.DOUBLE, 1),
        FLOAT(b.FLOAT, 5),
        INT64(b.LONG, 0),
        UINT64(b.LONG, 0),
        INT32(b.INT, 0),
        FIXED64(b.LONG, 1),
        FIXED32(b.INT, 5),
        BOOL(b.BOOLEAN, 0),
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
        UINT32(b.INT, 0),
        ENUM(b.ENUM, 0),
        SFIXED32(b.INT, 5),
        SFIXED64(b.LONG, 1),
        SINT32(b.INT, 0),
        SINT64(b.LONG, 0);
        
        final b BBj;
        final int BBk;

        static {
            AppMethodBeat.o(121691);
        }

        private a(b bVar, int i) {
            this.BBj = bVar;
            this.BBk = i;
        }

        public boolean eiN() {
            return true;
        }
    }

    public enum b {
        INT(Integer.valueOf(0)),
        LONG(Long.valueOf(0)),
        FLOAT(Float.valueOf(0.0f)),
        DOUBLE(Double.valueOf(0.0d)),
        BOOLEAN(Boolean.FALSE),
        STRING(""),
        BYTE_STRING(d.Bzq),
        ENUM(null),
        MESSAGE(null);
        
        private final Object BBv;

        static {
            AppMethodBeat.o(121694);
        }

        private b(Object obj) {
            this.BBv = obj;
        }
    }

    static int fy(int i) {
        return i & 7;
    }

    public static int fz(int i) {
        return i >>> 3;
    }

    static int bv(int i, int i2) {
        return (i << 3) | i2;
    }
}

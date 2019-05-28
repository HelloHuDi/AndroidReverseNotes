package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ai */
public final class C41028ai {
    /* renamed from: a */
    private ByteBuffer f16427a;
    /* renamed from: b */
    private String f16428b = "GBK";

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ai$a */
    public static class C36484a {
        /* renamed from: a */
        public byte f15266a;
        /* renamed from: b */
        public int f15267b;
    }

    public C41028ai(byte[] bArr) {
        AppMethodBeat.m2504i(98427);
        this.f16427a = ByteBuffer.wrap(bArr);
        AppMethodBeat.m2505o(98427);
    }

    public C41028ai(byte[] bArr, byte b) {
        AppMethodBeat.m2504i(98428);
        this.f16427a = ByteBuffer.wrap(bArr);
        this.f16427a.position(4);
        AppMethodBeat.m2505o(98428);
    }

    /* renamed from: a */
    public final void mo65108a(byte[] bArr) {
        AppMethodBeat.m2504i(98429);
        this.f16427a = ByteBuffer.wrap(bArr);
        AppMethodBeat.m2505o(98429);
    }

    /* renamed from: a */
    private static int m71315a(C36484a c36484a, ByteBuffer byteBuffer) {
        AppMethodBeat.m2504i(98430);
        byte b = byteBuffer.get();
        c36484a.f15266a = (byte) (b & 15);
        c36484a.f15267b = (b & 240) >> 4;
        if (c36484a.f15267b == 15) {
            c36484a.f15267b = byteBuffer.get() & 255;
            AppMethodBeat.m2505o(98430);
            return 2;
        }
        AppMethodBeat.m2505o(98430);
        return 1;
    }

    /* renamed from: a */
    private boolean m71320a(int i) {
        AppMethodBeat.m2504i(98431);
        try {
            C36484a c36484a = new C36484a();
            while (true) {
                int a = C41028ai.m71315a(c36484a, this.f16427a.duplicate());
                if (c36484a.f15266a == (byte) 11) {
                    AppMethodBeat.m2505o(98431);
                    return false;
                } else if (i > c36484a.f15267b) {
                    this.f16427a.position(a + this.f16427a.position());
                    m71319a(c36484a.f15266a);
                } else if (i == c36484a.f15267b) {
                    AppMethodBeat.m2505o(98431);
                    return true;
                } else {
                    AppMethodBeat.m2505o(98431);
                    return false;
                }
            }
        } catch (RuntimeException | BufferUnderflowException e) {
            AppMethodBeat.m2505o(98431);
            return false;
        }
    }

    /* renamed from: a */
    private void m71318a() {
        AppMethodBeat.m2504i(98432);
        C36484a c36484a = new C36484a();
        do {
            C41028ai.m71315a(c36484a, this.f16427a);
            m71319a(c36484a.f15266a);
        } while (c36484a.f15266a != (byte) 11);
        AppMethodBeat.m2505o(98432);
    }

    /* renamed from: a */
    private void m71319a(byte b) {
        int i = 0;
        AppMethodBeat.m2504i(98433);
        int a;
        C36484a c36484a;
        RuntimeException runtimeException;
        switch (b) {
            case (byte) 0:
                this.f16427a.position(this.f16427a.position() + 1);
                AppMethodBeat.m2505o(98433);
                return;
            case (byte) 1:
                this.f16427a.position(this.f16427a.position() + 2);
                AppMethodBeat.m2505o(98433);
                return;
            case (byte) 2:
                this.f16427a.position(this.f16427a.position() + 4);
                AppMethodBeat.m2505o(98433);
                return;
            case (byte) 3:
                this.f16427a.position(this.f16427a.position() + 8);
                AppMethodBeat.m2505o(98433);
                return;
            case (byte) 4:
                this.f16427a.position(this.f16427a.position() + 4);
                AppMethodBeat.m2505o(98433);
                return;
            case (byte) 5:
                this.f16427a.position(this.f16427a.position() + 8);
                AppMethodBeat.m2505o(98433);
                return;
            case (byte) 6:
                i = this.f16427a.get();
                if (i < 0) {
                    i += 256;
                }
                this.f16427a.position(i + this.f16427a.position());
                AppMethodBeat.m2505o(98433);
                return;
            case (byte) 7:
                this.f16427a.position(this.f16427a.getInt() + this.f16427a.position());
                AppMethodBeat.m2505o(98433);
                return;
            case (byte) 8:
                a = mo65101a(0, 0, true);
                while (i < (a << 1)) {
                    c36484a = new C36484a();
                    C41028ai.m71315a(c36484a, this.f16427a);
                    m71319a(c36484a.f15266a);
                    i++;
                }
                AppMethodBeat.m2505o(98433);
                return;
            case (byte) 9:
                a = mo65101a(0, 0, true);
                while (i < a) {
                    c36484a = new C36484a();
                    C41028ai.m71315a(c36484a, this.f16427a);
                    m71319a(c36484a.f15266a);
                    i++;
                }
                AppMethodBeat.m2505o(98433);
                return;
            case (byte) 10:
                m71318a();
                AppMethodBeat.m2505o(98433);
                return;
            case (byte) 11:
            case (byte) 12:
                AppMethodBeat.m2505o(98433);
                return;
            case (byte) 13:
                C36484a c36484a2 = new C36484a();
                C41028ai.m71315a(c36484a2, this.f16427a);
                if (c36484a2.f15266a != (byte) 0) {
                    runtimeException = new RuntimeException("skipField with invalid type, type value: " + b + ", " + c36484a2.f15266a);
                    AppMethodBeat.m2505o(98433);
                    throw runtimeException;
                }
                this.f16427a.position(mo65101a(0, 0, true) + this.f16427a.position());
                AppMethodBeat.m2505o(98433);
                return;
            default:
                runtimeException = new RuntimeException("invalid type.");
                AppMethodBeat.m2505o(98433);
                throw runtimeException;
        }
    }

    /* renamed from: a */
    public final byte mo65100a(byte b, int i, boolean z) {
        AppMethodBeat.m2504i(98434);
        RuntimeException runtimeException;
        if (m71320a(i)) {
            C36484a c36484a = new C36484a();
            C41028ai.m71315a(c36484a, this.f16427a);
            switch (c36484a.f15266a) {
                case (byte) 0:
                    b = this.f16427a.get();
                    break;
                case (byte) 12:
                    b = (byte) 0;
                    break;
                default:
                    runtimeException = new RuntimeException("type mismatch.");
                    AppMethodBeat.m2505o(98434);
                    throw runtimeException;
            }
        } else if (z) {
            runtimeException = new RuntimeException("require field not exist.");
            AppMethodBeat.m2505o(98434);
            throw runtimeException;
        }
        AppMethodBeat.m2505o(98434);
        return b;
    }

    /* renamed from: a */
    public final short mo65107a(short s, int i, boolean z) {
        AppMethodBeat.m2504i(98435);
        RuntimeException runtimeException;
        if (m71320a(i)) {
            C36484a c36484a = new C36484a();
            C41028ai.m71315a(c36484a, this.f16427a);
            switch (c36484a.f15266a) {
                case (byte) 0:
                    s = (short) this.f16427a.get();
                    break;
                case (byte) 1:
                    s = this.f16427a.getShort();
                    break;
                case (byte) 12:
                    s = (short) 0;
                    break;
                default:
                    runtimeException = new RuntimeException("type mismatch.");
                    AppMethodBeat.m2505o(98435);
                    throw runtimeException;
            }
        } else if (z) {
            runtimeException = new RuntimeException("require field not exist.");
            AppMethodBeat.m2505o(98435);
            throw runtimeException;
        }
        AppMethodBeat.m2505o(98435);
        return s;
    }

    /* renamed from: a */
    public final int mo65101a(int i, int i2, boolean z) {
        AppMethodBeat.m2504i(98436);
        RuntimeException runtimeException;
        if (m71320a(i2)) {
            C36484a c36484a = new C36484a();
            C41028ai.m71315a(c36484a, this.f16427a);
            switch (c36484a.f15266a) {
                case (byte) 0:
                    i = this.f16427a.get();
                    break;
                case (byte) 1:
                    i = this.f16427a.getShort();
                    break;
                case (byte) 2:
                    i = this.f16427a.getInt();
                    break;
                case (byte) 12:
                    i = 0;
                    break;
                default:
                    runtimeException = new RuntimeException("type mismatch.");
                    AppMethodBeat.m2505o(98436);
                    throw runtimeException;
            }
        } else if (z) {
            runtimeException = new RuntimeException("require field not exist.");
            AppMethodBeat.m2505o(98436);
            throw runtimeException;
        }
        AppMethodBeat.m2505o(98436);
        return i;
    }

    /* renamed from: a */
    public final long mo65103a(long j, int i, boolean z) {
        AppMethodBeat.m2504i(98437);
        RuntimeException runtimeException;
        if (m71320a(i)) {
            C36484a c36484a = new C36484a();
            C41028ai.m71315a(c36484a, this.f16427a);
            switch (c36484a.f15266a) {
                case (byte) 0:
                    j = (long) this.f16427a.get();
                    break;
                case (byte) 1:
                    j = (long) this.f16427a.getShort();
                    break;
                case (byte) 2:
                    j = (long) this.f16427a.getInt();
                    break;
                case (byte) 3:
                    j = this.f16427a.getLong();
                    break;
                case (byte) 12:
                    j = 0;
                    break;
                default:
                    runtimeException = new RuntimeException("type mismatch.");
                    AppMethodBeat.m2505o(98437);
                    throw runtimeException;
            }
        } else if (z) {
            runtimeException = new RuntimeException("require field not exist.");
            AppMethodBeat.m2505o(98437);
            throw runtimeException;
        }
        AppMethodBeat.m2505o(98437);
        return j;
    }

    /* renamed from: a */
    private float m71314a(float f, int i, boolean z) {
        AppMethodBeat.m2504i(98438);
        RuntimeException runtimeException;
        if (m71320a(i)) {
            C36484a c36484a = new C36484a();
            C41028ai.m71315a(c36484a, this.f16427a);
            switch (c36484a.f15266a) {
                case (byte) 4:
                    f = this.f16427a.getFloat();
                    break;
                case (byte) 12:
                    f = 0.0f;
                    break;
                default:
                    runtimeException = new RuntimeException("type mismatch.");
                    AppMethodBeat.m2505o(98438);
                    throw runtimeException;
            }
        } else if (z) {
            runtimeException = new RuntimeException("require field not exist.");
            AppMethodBeat.m2505o(98438);
            throw runtimeException;
        }
        AppMethodBeat.m2505o(98438);
        return f;
    }

    /* renamed from: a */
    private double m71313a(double d, int i, boolean z) {
        AppMethodBeat.m2504i(98439);
        RuntimeException runtimeException;
        if (m71320a(i)) {
            C36484a c36484a = new C36484a();
            C41028ai.m71315a(c36484a, this.f16427a);
            switch (c36484a.f15266a) {
                case (byte) 4:
                    d = (double) this.f16427a.getFloat();
                    break;
                case (byte) 5:
                    d = this.f16427a.getDouble();
                    break;
                case (byte) 12:
                    d = 0.0d;
                    break;
                default:
                    runtimeException = new RuntimeException("type mismatch.");
                    AppMethodBeat.m2505o(98439);
                    throw runtimeException;
            }
        } else if (z) {
            runtimeException = new RuntimeException("require field not exist.");
            AppMethodBeat.m2505o(98439);
            throw runtimeException;
        }
        AppMethodBeat.m2505o(98439);
        return d;
    }

    /* renamed from: a */
    public final String mo65105a(int i, boolean z) {
        AppMethodBeat.m2504i(98440);
        String str = null;
        RuntimeException runtimeException;
        if (m71320a(i)) {
            C36484a c36484a = new C36484a();
            C41028ai.m71315a(c36484a, this.f16427a);
            int i2;
            byte[] bArr;
            switch (c36484a.f15266a) {
                case (byte) 6:
                    i2 = this.f16427a.get();
                    if (i2 < 0) {
                        i2 += 256;
                    }
                    bArr = new byte[i2];
                    this.f16427a.get(bArr);
                    try {
                        str = new String(bArr, this.f16428b);
                        break;
                    } catch (UnsupportedEncodingException e) {
                        str = new String(bArr);
                        break;
                    }
                case (byte) 7:
                    i2 = this.f16427a.getInt();
                    if (i2 <= 104857600 && i2 >= 0 && i2 <= this.f16427a.capacity()) {
                        bArr = new byte[i2];
                        this.f16427a.get(bArr);
                        try {
                            str = new String(bArr, this.f16428b);
                            break;
                        } catch (UnsupportedEncodingException e2) {
                            str = new String(bArr);
                            break;
                        }
                    }
                    RuntimeException runtimeException2 = new RuntimeException("String too long: ".concat(String.valueOf(i2)));
                    AppMethodBeat.m2505o(98440);
                    throw runtimeException2;
                    break;
                default:
                    runtimeException = new RuntimeException("type mismatch.");
                    AppMethodBeat.m2505o(98440);
                    throw runtimeException;
            }
        } else if (z) {
            runtimeException = new RuntimeException("require field not exist.");
            AppMethodBeat.m2505o(98440);
            throw runtimeException;
        }
        AppMethodBeat.m2505o(98440);
        return str;
    }

    /* renamed from: a */
    public final <K, V> HashMap<K, V> mo65106a(Map<K, V> map) {
        AppMethodBeat.m2504i(98441);
        HashMap hashMap = (HashMap) m71317a(new HashMap(), map, 0, false);
        AppMethodBeat.m2505o(98441);
        return hashMap;
    }

    /* renamed from: a */
    private <K, V> Map<K, V> m71317a(Map<K, V> map, Map<K, V> map2, int i, boolean z) {
        AppMethodBeat.m2504i(98442);
        if (map2 == null || map2.isEmpty()) {
            HashMap hashMap = new HashMap();
            AppMethodBeat.m2505o(98442);
            return hashMap;
        }
        Entry entry = (Entry) map2.entrySet().iterator().next();
        Object key = entry.getKey();
        Object value = entry.getValue();
        RuntimeException runtimeException;
        if (m71320a(i)) {
            C36484a c36484a = new C36484a();
            C41028ai.m71315a(c36484a, this.f16427a);
            switch (c36484a.f15266a) {
                case (byte) 8:
                    int a = mo65101a(0, 0, true);
                    if (a >= 0) {
                        for (int i2 = 0; i2 < a; i2++) {
                            map.put(mo65104a(key, 0, true), mo65104a(value, 1, true));
                        }
                        break;
                    }
                    runtimeException = new RuntimeException("size invalid: ".concat(String.valueOf(a)));
                    AppMethodBeat.m2505o(98442);
                    throw runtimeException;
                default:
                    runtimeException = new RuntimeException("type mismatch.");
                    AppMethodBeat.m2505o(98442);
                    throw runtimeException;
            }
        } else if (z) {
            runtimeException = new RuntimeException("require field not exist.");
            AppMethodBeat.m2505o(98442);
            throw runtimeException;
        }
        AppMethodBeat.m2505o(98442);
        return map;
    }

    /* renamed from: c */
    private boolean[] m71322c(int i, boolean z) {
        AppMethodBeat.m2504i(98443);
        boolean[] zArr = null;
        RuntimeException runtimeException;
        if (m71320a(i)) {
            C36484a c36484a = new C36484a();
            C41028ai.m71315a(c36484a, this.f16427a);
            switch (c36484a.f15266a) {
                case (byte) 9:
                    int a = mo65101a(0, 0, true);
                    if (a >= 0) {
                        boolean[] zArr2 = new boolean[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            boolean z2;
                            if (mo65100a((byte) 0, 0, true) != (byte) 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            zArr2[i2] = z2;
                        }
                        zArr = zArr2;
                        break;
                    }
                    runtimeException = new RuntimeException("size invalid: ".concat(String.valueOf(a)));
                    AppMethodBeat.m2505o(98443);
                    throw runtimeException;
                default:
                    runtimeException = new RuntimeException("type mismatch.");
                    AppMethodBeat.m2505o(98443);
                    throw runtimeException;
            }
        } else if (z) {
            runtimeException = new RuntimeException("require field not exist.");
            AppMethodBeat.m2505o(98443);
            throw runtimeException;
        }
        AppMethodBeat.m2505o(98443);
        return zArr;
    }

    /* renamed from: b */
    public final byte[] mo65109b(int i, boolean z) {
        AppMethodBeat.m2504i(98444);
        byte[] bArr = null;
        RuntimeException runtimeException;
        if (m71320a(i)) {
            C36484a c36484a = new C36484a();
            C41028ai.m71315a(c36484a, this.f16427a);
            switch (c36484a.f15266a) {
                case (byte) 9:
                    int a = mo65101a(0, 0, true);
                    if (a >= 0 && a <= this.f16427a.capacity()) {
                        bArr = new byte[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            bArr[i2] = mo65100a(bArr[0], 0, true);
                        }
                        break;
                    }
                    runtimeException = new RuntimeException("size invalid: ".concat(String.valueOf(a)));
                    AppMethodBeat.m2505o(98444);
                    throw runtimeException;
                    break;
                case (byte) 13:
                    C36484a c36484a2 = new C36484a();
                    C41028ai.m71315a(c36484a2, this.f16427a);
                    if (c36484a2.f15266a == (byte) 0) {
                        int a2 = mo65101a(0, 0, true);
                        if (a2 >= 0 && a2 <= this.f16427a.capacity()) {
                            bArr = new byte[a2];
                            this.f16427a.get(bArr);
                            break;
                        }
                        RuntimeException runtimeException2 = new RuntimeException("invalid size, tag: " + i + ", type: " + c36484a.f15266a + ", " + c36484a2.f15266a + ", size: " + a2);
                        AppMethodBeat.m2505o(98444);
                        throw runtimeException2;
                    }
                    RuntimeException runtimeException3 = new RuntimeException("type mismatch, tag: " + i + ", type: " + c36484a.f15266a + ", " + c36484a2.f15266a);
                    AppMethodBeat.m2505o(98444);
                    throw runtimeException3;
                default:
                    runtimeException = new RuntimeException("type mismatch.");
                    AppMethodBeat.m2505o(98444);
                    throw runtimeException;
            }
        } else if (z) {
            runtimeException = new RuntimeException("require field not exist.");
            AppMethodBeat.m2505o(98444);
            throw runtimeException;
        }
        AppMethodBeat.m2505o(98444);
        return bArr;
    }

    /* renamed from: d */
    private short[] m71323d(int i, boolean z) {
        AppMethodBeat.m2504i(98445);
        short[] sArr = null;
        RuntimeException runtimeException;
        if (m71320a(i)) {
            C36484a c36484a = new C36484a();
            C41028ai.m71315a(c36484a, this.f16427a);
            switch (c36484a.f15266a) {
                case (byte) 9:
                    int a = mo65101a(0, 0, true);
                    if (a >= 0) {
                        sArr = new short[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            sArr[i2] = mo65107a(sArr[0], 0, true);
                        }
                        break;
                    }
                    runtimeException = new RuntimeException("size invalid: ".concat(String.valueOf(a)));
                    AppMethodBeat.m2505o(98445);
                    throw runtimeException;
                default:
                    runtimeException = new RuntimeException("type mismatch.");
                    AppMethodBeat.m2505o(98445);
                    throw runtimeException;
            }
        } else if (z) {
            runtimeException = new RuntimeException("require field not exist.");
            AppMethodBeat.m2505o(98445);
            throw runtimeException;
        }
        AppMethodBeat.m2505o(98445);
        return sArr;
    }

    /* renamed from: e */
    private int[] m71324e(int i, boolean z) {
        AppMethodBeat.m2504i(98446);
        int[] iArr = null;
        RuntimeException runtimeException;
        if (m71320a(i)) {
            C36484a c36484a = new C36484a();
            C41028ai.m71315a(c36484a, this.f16427a);
            switch (c36484a.f15266a) {
                case (byte) 9:
                    int a = mo65101a(0, 0, true);
                    if (a >= 0) {
                        iArr = new int[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            iArr[i2] = mo65101a(iArr[0], 0, true);
                        }
                        break;
                    }
                    runtimeException = new RuntimeException("size invalid: ".concat(String.valueOf(a)));
                    AppMethodBeat.m2505o(98446);
                    throw runtimeException;
                default:
                    runtimeException = new RuntimeException("type mismatch.");
                    AppMethodBeat.m2505o(98446);
                    throw runtimeException;
            }
        } else if (z) {
            runtimeException = new RuntimeException("require field not exist.");
            AppMethodBeat.m2505o(98446);
            throw runtimeException;
        }
        AppMethodBeat.m2505o(98446);
        return iArr;
    }

    /* renamed from: f */
    private long[] m71325f(int i, boolean z) {
        AppMethodBeat.m2504i(98447);
        long[] jArr = null;
        RuntimeException runtimeException;
        if (m71320a(i)) {
            C36484a c36484a = new C36484a();
            C41028ai.m71315a(c36484a, this.f16427a);
            switch (c36484a.f15266a) {
                case (byte) 9:
                    int a = mo65101a(0, 0, true);
                    if (a >= 0) {
                        jArr = new long[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            jArr[i2] = mo65103a(jArr[0], 0, true);
                        }
                        break;
                    }
                    runtimeException = new RuntimeException("size invalid: ".concat(String.valueOf(a)));
                    AppMethodBeat.m2505o(98447);
                    throw runtimeException;
                default:
                    runtimeException = new RuntimeException("type mismatch.");
                    AppMethodBeat.m2505o(98447);
                    throw runtimeException;
            }
        } else if (z) {
            runtimeException = new RuntimeException("require field not exist.");
            AppMethodBeat.m2505o(98447);
            throw runtimeException;
        }
        AppMethodBeat.m2505o(98447);
        return jArr;
    }

    /* renamed from: g */
    private float[] m71326g(int i, boolean z) {
        AppMethodBeat.m2504i(98448);
        float[] fArr = null;
        RuntimeException runtimeException;
        if (m71320a(i)) {
            C36484a c36484a = new C36484a();
            C41028ai.m71315a(c36484a, this.f16427a);
            switch (c36484a.f15266a) {
                case (byte) 9:
                    int a = mo65101a(0, 0, true);
                    if (a >= 0) {
                        fArr = new float[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            fArr[i2] = m71314a(fArr[0], 0, true);
                        }
                        break;
                    }
                    runtimeException = new RuntimeException("size invalid: ".concat(String.valueOf(a)));
                    AppMethodBeat.m2505o(98448);
                    throw runtimeException;
                default:
                    runtimeException = new RuntimeException("type mismatch.");
                    AppMethodBeat.m2505o(98448);
                    throw runtimeException;
            }
        } else if (z) {
            runtimeException = new RuntimeException("require field not exist.");
            AppMethodBeat.m2505o(98448);
            throw runtimeException;
        }
        AppMethodBeat.m2505o(98448);
        return fArr;
    }

    /* renamed from: h */
    private double[] m71327h(int i, boolean z) {
        AppMethodBeat.m2504i(98449);
        double[] dArr = null;
        RuntimeException runtimeException;
        if (m71320a(i)) {
            C36484a c36484a = new C36484a();
            C41028ai.m71315a(c36484a, this.f16427a);
            switch (c36484a.f15266a) {
                case (byte) 9:
                    int a = mo65101a(0, 0, true);
                    if (a >= 0) {
                        dArr = new double[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            dArr[i2] = m71313a(dArr[0], 0, true);
                        }
                        break;
                    }
                    runtimeException = new RuntimeException("size invalid: ".concat(String.valueOf(a)));
                    AppMethodBeat.m2505o(98449);
                    throw runtimeException;
                default:
                    runtimeException = new RuntimeException("type mismatch.");
                    AppMethodBeat.m2505o(98449);
                    throw runtimeException;
            }
        } else if (z) {
            runtimeException = new RuntimeException("require field not exist.");
            AppMethodBeat.m2505o(98449);
            throw runtimeException;
        }
        AppMethodBeat.m2505o(98449);
        return dArr;
    }

    /* renamed from: b */
    private <T> T[] m71321b(T t, int i, boolean z) {
        AppMethodBeat.m2504i(98450);
        RuntimeException runtimeException;
        if (m71320a(i)) {
            C36484a c36484a = new C36484a();
            C41028ai.m71315a(c36484a, this.f16427a);
            switch (c36484a.f15266a) {
                case (byte) 9:
                    int a = mo65101a(0, 0, true);
                    if (a < 0) {
                        runtimeException = new RuntimeException("size invalid: ".concat(String.valueOf(a)));
                        AppMethodBeat.m2505o(98450);
                        throw runtimeException;
                    }
                    Object[] objArr = (Object[]) Array.newInstance(t.getClass(), a);
                    for (int i2 = 0; i2 < a; i2++) {
                        objArr[i2] = mo65104a((Object) t, 0, true);
                    }
                    AppMethodBeat.m2505o(98450);
                    return objArr;
                default:
                    runtimeException = new RuntimeException("type mismatch.");
                    AppMethodBeat.m2505o(98450);
                    throw runtimeException;
            }
        } else if (z) {
            runtimeException = new RuntimeException("require field not exist.");
            AppMethodBeat.m2505o(98450);
            throw runtimeException;
        } else {
            AppMethodBeat.m2505o(98450);
            return null;
        }
    }

    /* renamed from: a */
    private C41029ak m71316a(C41029ak c41029ak, int i, boolean z) {
        AppMethodBeat.m2504i(98451);
        C41029ak c41029ak2 = null;
        RuntimeException runtimeException;
        if (m71320a(i)) {
            try {
                c41029ak2 = (C41029ak) c41029ak.getClass().newInstance();
                C36484a c36484a = new C36484a();
                C41028ai.m71315a(c36484a, this.f16427a);
                if (c36484a.f15266a != (byte) 10) {
                    runtimeException = new RuntimeException("type mismatch.");
                    AppMethodBeat.m2505o(98451);
                    throw runtimeException;
                }
                c41029ak2.mo12387a(this);
                m71318a();
            } catch (Exception e) {
                RuntimeException runtimeException2 = new RuntimeException(e.getMessage());
                AppMethodBeat.m2505o(98451);
                throw runtimeException2;
            }
        } else if (z) {
            runtimeException = new RuntimeException("require field not exist.");
            AppMethodBeat.m2505o(98451);
            throw runtimeException;
        }
        AppMethodBeat.m2505o(98451);
        return c41029ak2;
    }

    /* renamed from: a */
    public final <T> Object mo65104a(T t, int i, boolean z) {
        int i2 = 0;
        AppMethodBeat.m2504i(98452);
        Object valueOf;
        RuntimeException runtimeException;
        if (t instanceof Byte) {
            Byte valueOf2 = Byte.valueOf(mo65100a((byte) 0, i, z));
            AppMethodBeat.m2505o(98452);
            return valueOf2;
        } else if (t instanceof Boolean) {
            boolean z2;
            if (mo65100a((byte) 0, i, z) != (byte) 0) {
                z2 = true;
            }
            valueOf = Boolean.valueOf(z2);
            AppMethodBeat.m2505o(98452);
            return valueOf;
        } else if (t instanceof Short) {
            valueOf = Short.valueOf(mo65107a((short) 0, i, z));
            AppMethodBeat.m2505o(98452);
            return valueOf;
        } else if (t instanceof Integer) {
            valueOf = Integer.valueOf(mo65101a(0, i, z));
            AppMethodBeat.m2505o(98452);
            return valueOf;
        } else if (t instanceof Long) {
            valueOf = Long.valueOf(mo65103a(0, i, z));
            AppMethodBeat.m2505o(98452);
            return valueOf;
        } else if (t instanceof Float) {
            valueOf = Float.valueOf(m71314a(0.0f, i, z));
            AppMethodBeat.m2505o(98452);
            return valueOf;
        } else if (t instanceof Double) {
            valueOf = Double.valueOf(m71313a(0.0d, i, z));
            AppMethodBeat.m2505o(98452);
            return valueOf;
        } else if (t instanceof String) {
            valueOf = mo65105a(i, z);
            AppMethodBeat.m2505o(98452);
            return valueOf;
        } else if (t instanceof Map) {
            HashMap hashMap = (HashMap) m71317a(new HashMap(), (Map) t, i, z);
            AppMethodBeat.m2505o(98452);
            return hashMap;
        } else if (t instanceof List) {
            List list = (List) t;
            if (list == null || list.isEmpty()) {
                valueOf = new ArrayList();
                AppMethodBeat.m2505o(98452);
                return valueOf;
            }
            Object[] b = m71321b(list.get(0), i, z);
            if (b == null) {
                AppMethodBeat.m2505o(98452);
                return null;
            }
            ArrayList arrayList = new ArrayList();
            while (i2 < b.length) {
                arrayList.add(b[i2]);
                i2++;
            }
            AppMethodBeat.m2505o(98452);
            return arrayList;
        } else if (t instanceof C41029ak) {
            valueOf = m71316a((C41029ak) t, i, z);
            AppMethodBeat.m2505o(98452);
            return valueOf;
        } else if (!t.getClass().isArray()) {
            runtimeException = new RuntimeException("read object error: unsupport type.");
            AppMethodBeat.m2505o(98452);
            throw runtimeException;
        } else if ((t instanceof byte[]) || (t instanceof Byte[])) {
            valueOf = mo65109b(i, z);
            AppMethodBeat.m2505o(98452);
            return valueOf;
        } else if (t instanceof boolean[]) {
            valueOf = m71322c(i, z);
            AppMethodBeat.m2505o(98452);
            return valueOf;
        } else if (t instanceof short[]) {
            valueOf = m71323d(i, z);
            AppMethodBeat.m2505o(98452);
            return valueOf;
        } else if (t instanceof int[]) {
            valueOf = m71324e(i, z);
            AppMethodBeat.m2505o(98452);
            return valueOf;
        } else if (t instanceof long[]) {
            valueOf = m71325f(i, z);
            AppMethodBeat.m2505o(98452);
            return valueOf;
        } else if (t instanceof float[]) {
            valueOf = m71326g(i, z);
            AppMethodBeat.m2505o(98452);
            return valueOf;
        } else if (t instanceof double[]) {
            valueOf = m71327h(i, z);
            AppMethodBeat.m2505o(98452);
            return valueOf;
        } else {
            Object[] objArr = (Object[]) t;
            if (objArr == null || objArr.length == 0) {
                runtimeException = new RuntimeException("unable to get type of key and value.");
                AppMethodBeat.m2505o(98452);
                throw runtimeException;
            }
            valueOf = m71321b(objArr[0], i, z);
            AppMethodBeat.m2505o(98452);
            return valueOf;
        }
    }

    /* renamed from: a */
    public final int mo65102a(String str) {
        this.f16428b = str;
        return 0;
    }
}

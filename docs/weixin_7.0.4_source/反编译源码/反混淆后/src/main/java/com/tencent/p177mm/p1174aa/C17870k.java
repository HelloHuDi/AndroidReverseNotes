package com.tencent.p177mm.p1174aa;

import com.eclipsesource.p096a.C0803h;
import com.eclipsesource.p096a.C25470a;
import com.eclipsesource.p096a.C37205b;
import com.eclipsesource.p096a.C41577k;
import com.eclipsesource.p096a.C45009l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.aa.k */
public final class C17870k implements C41723a {
    private C37205b eIF;

    public C17870k() {
        AppMethodBeat.m2504i(117694);
        this.eIF = new C37205b();
        AppMethodBeat.m2505o(117694);
    }

    public C17870k(String str) {
        AppMethodBeat.m2504i(117695);
        this.eIF = C25470a.m40250ah(str).mo2361oN();
        if (this.eIF == null) {
            C41724g c41724g = new C41724g(String.format("JSONArray string(%s) parse error.", new Object[]{str}));
            AppMethodBeat.m2505o(117695);
            throw c41724g;
        }
        AppMethodBeat.m2505o(117695);
    }

    C17870k(C37205b c37205b) {
        AppMethodBeat.m2504i(117696);
        Assert.assertNotNull(c37205b);
        this.eIF = c37205b;
        AppMethodBeat.m2505o(117696);
    }

    public final int length() {
        AppMethodBeat.m2504i(117697);
        int size = this.eIF.aCy.size();
        AppMethodBeat.m2505o(117697);
        return size;
    }

    /* renamed from: cj */
    public final C41723a mo33299cj(boolean z) {
        AppMethodBeat.m2504i(117698);
        this.eIF.mo59302aC(z);
        AppMethodBeat.m2505o(117698);
        return this;
    }

    /* renamed from: o */
    public final C41723a mo33316o(double d) {
        AppMethodBeat.m2504i(117699);
        this.eIF.mo59310n(d);
        AppMethodBeat.m2505o(117699);
        return this;
    }

    /* renamed from: jC */
    public final C41723a mo33310jC(int i) {
        AppMethodBeat.m2504i(117700);
        this.eIF.mo59306ds(i);
        AppMethodBeat.m2505o(117700);
        return this;
    }

    /* renamed from: fb */
    public final C41723a mo33302fb(long j) {
        AppMethodBeat.m2504i(117701);
        this.eIF.mo59312u(j);
        AppMethodBeat.m2505o(117701);
        return this;
    }

    /* renamed from: av */
    public final C41723a mo33297av(Object obj) {
        AppMethodBeat.m2504i(117702);
        C41727j.m73483a(this.eIF, obj);
        AppMethodBeat.m2505o(117702);
        return this;
    }

    /* renamed from: z */
    public final C41723a mo33332z(int i, boolean z) {
        AppMethodBeat.m2504i(117703);
        try {
            this.eIF.mo59311p(i, z);
            AppMethodBeat.m2505o(117703);
            return this;
        } catch (Exception e) {
            C41724g c41724g = new C41724g(e);
            AppMethodBeat.m2505o(117703);
            throw c41724g;
        }
    }

    /* renamed from: d */
    public final C41723a mo33300d(int i, double d) {
        AppMethodBeat.m2504i(117704);
        try {
            this.eIF.mo59305b(i, d);
            AppMethodBeat.m2505o(117704);
            return this;
        } catch (Exception e) {
            C41724g c41724g = new C41724g(e);
            AppMethodBeat.m2505o(117704);
            throw c41724g;
        }
    }

    /* renamed from: cb */
    public final C41723a mo33298cb(int i, int i2) {
        AppMethodBeat.m2504i(117705);
        try {
            this.eIF.mo59303aX(i, i2);
            AppMethodBeat.m2505o(117705);
            return this;
        } catch (Exception e) {
            C41724g c41724g = new C41724g(e);
            AppMethodBeat.m2505o(117705);
            throw c41724g;
        }
    }

    /* renamed from: q */
    public final C41723a mo33328q(int i, long j) {
        AppMethodBeat.m2504i(117706);
        try {
            this.eIF.mo59308f(i, j);
            AppMethodBeat.m2505o(117706);
            return this;
        } catch (Exception e) {
            C41724g c41724g = new C41724g(e);
            AppMethodBeat.m2505o(117706);
            throw c41724g;
        }
    }

    /* renamed from: d */
    public final C41723a mo33301d(int i, Object obj) {
        AppMethodBeat.m2504i(117707);
        try {
            C37205b c37205b = this.eIF;
            if (obj instanceof C17868c) {
                c37205b.mo59300a(i, C41727j.m73482a((C17868c) obj));
            } else if (obj instanceof C41723a) {
                c37205b.mo59300a(i, C41727j.m73481a((C41723a) obj));
            } else if (obj instanceof Integer) {
                c37205b.mo59303aX(i, ((Integer) obj).intValue());
            } else if (obj instanceof String) {
                c37205b.aCy.set(i, C25470a.m40249ag((String) obj));
            } else if (obj instanceof Boolean) {
                c37205b.mo59311p(i, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Long) {
                c37205b.mo59308f(i, ((Long) obj).longValue());
            } else if (obj instanceof Float) {
                c37205b.aCy.set(i, C25470a.m40247T(((Float) obj).floatValue()));
            } else if (obj instanceof Integer) {
                c37205b.mo59303aX(i, ((Integer) obj).intValue());
            } else if (obj instanceof Double) {
                c37205b.mo59305b(i, ((Double) obj).doubleValue());
            } else if (obj instanceof C0803h) {
                c37205b.mo59300a(i, (C0803h) obj);
            }
            AppMethodBeat.m2505o(117707);
            return this;
        } catch (Exception e) {
            C41724g c41724g = new C41724g(e);
            AppMethodBeat.m2505o(117707);
            throw c41724g;
        }
    }

    public final boolean isNull(int i) {
        AppMethodBeat.m2504i(117708);
        if (i < 0 || i >= length() || this.eIF.mo59307dt(i) == null) {
            AppMethodBeat.m2505o(117708);
            return true;
        }
        AppMethodBeat.m2505o(117708);
        return false;
    }

    public final Object get(int i) {
        AppMethodBeat.m2504i(117709);
        int length = length();
        if (i < 0 || i >= length) {
            C41724g c41724g = new C41724g(String.format("index(%d) out of range(0, %d).", new Object[]{Integer.valueOf(i), Integer.valueOf(length)}));
            AppMethodBeat.m2505o(117709);
            throw c41724g;
        }
        C0803h dt = this.eIF.mo59307dt(i);
        Object c0803h;
        if (dt == null) {
            AppMethodBeat.m2505o(117709);
            return null;
        } else if (dt.isNumber()) {
            c0803h = dt.toString();
            AppMethodBeat.m2505o(117709);
            return c0803h;
        } else if (dt.isBoolean()) {
            c0803h = Boolean.valueOf(dt.mo2362oO());
            AppMethodBeat.m2505o(117709);
            return c0803h;
        } else if (dt.isArray()) {
            c0803h = new C17870k(dt.mo2361oN());
            AppMethodBeat.m2505o(117709);
            return c0803h;
        } else if (dt.isObject()) {
            c0803h = new C25742l(dt.mo2366oS());
            AppMethodBeat.m2505o(117709);
            return c0803h;
        } else if (dt.isString()) {
            c0803h = dt.mo2367pq();
            AppMethodBeat.m2505o(117709);
            return c0803h;
        } else {
            AppMethodBeat.m2505o(117709);
            return null;
        }
    }

    public final Object opt(int i) {
        AppMethodBeat.m2504i(117710);
        int length = length();
        if (i < 0 || i >= length) {
            AppMethodBeat.m2505o(117710);
            return null;
        }
        C0803h dt = this.eIF.mo59307dt(i);
        Object c0803h;
        if (dt == null) {
            AppMethodBeat.m2505o(117710);
            return null;
        } else if (dt.isNumber()) {
            c0803h = dt.toString();
            AppMethodBeat.m2505o(117710);
            return c0803h;
        } else if (dt.isBoolean()) {
            c0803h = Boolean.valueOf(dt.mo2362oO());
            AppMethodBeat.m2505o(117710);
            return c0803h;
        } else if (dt.isArray()) {
            c0803h = new C17870k(dt.mo2361oN());
            AppMethodBeat.m2505o(117710);
            return c0803h;
        } else if (dt.isObject()) {
            c0803h = new C25742l(dt.mo2366oS());
            AppMethodBeat.m2505o(117710);
            return c0803h;
        } else if (dt.isString()) {
            c0803h = dt.mo2367pq();
            AppMethodBeat.m2505o(117710);
            return c0803h;
        } else {
            AppMethodBeat.m2505o(117710);
            return null;
        }
    }

    public final Object remove(int i) {
        AppMethodBeat.m2504i(117711);
        int length = length();
        if (i < 0 || i >= length) {
            AppMethodBeat.m2505o(117711);
            return null;
        }
        C37205b c37205b = this.eIF;
        c37205b.aCy.remove(i);
        Object c0803h;
        if (c37205b.isNumber()) {
            c0803h = c37205b.toString();
            AppMethodBeat.m2505o(117711);
            return c0803h;
        } else if (c37205b.isBoolean()) {
            c0803h = Boolean.valueOf(c37205b.mo2362oO());
            AppMethodBeat.m2505o(117711);
            return c0803h;
        } else if (c37205b.isArray()) {
            c0803h = new C17870k(c37205b.mo2361oN());
            AppMethodBeat.m2505o(117711);
            return c0803h;
        } else if (c37205b.isObject()) {
            c0803h = new C25742l(c37205b.mo2366oS());
            AppMethodBeat.m2505o(117711);
            return c0803h;
        } else if (c37205b.isString()) {
            c0803h = c37205b.mo2367pq();
            AppMethodBeat.m2505o(117711);
            return c0803h;
        } else {
            AppMethodBeat.m2505o(117711);
            return null;
        }
    }

    public final boolean getBoolean(int i) {
        AppMethodBeat.m2504i(117712);
        int length = length();
        C41724g c41724g;
        if (i < 0 || i >= length) {
            c41724g = new C41724g(String.format("index(%d) out of range(0, %d).", new Object[]{Integer.valueOf(i), Integer.valueOf(length)}));
            AppMethodBeat.m2505o(117712);
            throw c41724g;
        }
        C0803h dt = this.eIF.mo59307dt(i);
        if (dt == null) {
            C41724g c41724g2 = new C41724g(String.format("getBoolean(%d) return null.", new Object[]{Integer.valueOf(i)}));
            AppMethodBeat.m2505o(117712);
            throw c41724g2;
        } else if (dt.isBoolean()) {
            boolean oO = dt.mo2362oO();
            AppMethodBeat.m2505o(117712);
            return oO;
        } else {
            if (dt.isString()) {
                String pq = dt.mo2367pq();
                if ("true".equals(pq)) {
                    AppMethodBeat.m2505o(117712);
                    return true;
                } else if ("false".equals(pq)) {
                    AppMethodBeat.m2505o(117712);
                    return false;
                }
            }
            c41724g = new C41724g(String.format("getBoolean(%d) error, value : %s.", new Object[]{Integer.valueOf(i), dt}));
            AppMethodBeat.m2505o(117712);
            throw c41724g;
        }
    }

    public final boolean optBoolean(int i) {
        AppMethodBeat.m2504i(117713);
        boolean optBoolean = optBoolean(i, false);
        AppMethodBeat.m2505o(117713);
        return optBoolean;
    }

    public final boolean optBoolean(int i, boolean z) {
        AppMethodBeat.m2504i(117714);
        int length = length();
        if (i < 0 || i >= length) {
            AppMethodBeat.m2505o(117714);
            return z;
        }
        C0803h dt = this.eIF.mo59307dt(i);
        if (dt == null) {
            AppMethodBeat.m2505o(117714);
            return z;
        } else if (dt.isBoolean()) {
            z = dt.mo2362oO();
            AppMethodBeat.m2505o(117714);
            return z;
        } else {
            if (dt.isString()) {
                String pq = dt.mo2367pq();
                if ("true".equals(pq)) {
                    AppMethodBeat.m2505o(117714);
                    return true;
                } else if ("false".equals(pq)) {
                    AppMethodBeat.m2505o(117714);
                    return false;
                }
            }
            AppMethodBeat.m2505o(117714);
            return z;
        }
    }

    public final double getDouble(int i) {
        AppMethodBeat.m2504i(117715);
        int length = length();
        C41724g c41724g;
        if (i < 0 || i >= length) {
            c41724g = new C41724g(String.format("index(%d) out of range(0, %d).", new Object[]{Integer.valueOf(i), Integer.valueOf(length)}));
            AppMethodBeat.m2505o(117715);
            throw c41724g;
        }
        C0803h dt = this.eIF.mo59307dt(i);
        if (dt == null) {
            C41724g c41724g2 = new C41724g(String.format("getDouble(%d) return null.", new Object[]{Integer.valueOf(i)}));
            AppMethodBeat.m2505o(117715);
            throw c41724g2;
        }
        try {
            double oR;
            if (dt.isNumber()) {
                oR = dt.mo2365oR();
                AppMethodBeat.m2505o(117715);
            } else {
                if (dt.isString()) {
                    oR = Double.parseDouble(dt.mo2367pq());
                    AppMethodBeat.m2505o(117715);
                }
                c41724g = new C41724g(String.format("getDouble(%d) error, value : %s.", new Object[]{Integer.valueOf(i), dt}));
                AppMethodBeat.m2505o(117715);
                throw c41724g;
            }
            return oR;
        } catch (Exception e) {
        }
    }

    public final double optDouble(int i) {
        AppMethodBeat.m2504i(117716);
        double optDouble = optDouble(i, 0.0d);
        AppMethodBeat.m2505o(117716);
        return optDouble;
    }

    public final double optDouble(int i, double d) {
        AppMethodBeat.m2504i(117717);
        int length = length();
        if (i < 0 || i >= length) {
            AppMethodBeat.m2505o(117717);
        } else {
            C0803h dt = this.eIF.mo59307dt(i);
            if (dt == null) {
                AppMethodBeat.m2505o(117717);
            } else {
                try {
                    if (dt.isNumber()) {
                        d = dt.mo2365oR();
                        AppMethodBeat.m2505o(117717);
                    } else {
                        if (dt.isString()) {
                            d = Double.parseDouble(dt.mo2367pq());
                            AppMethodBeat.m2505o(117717);
                        }
                        AppMethodBeat.m2505o(117717);
                    }
                } catch (Exception e) {
                }
            }
        }
        return d;
    }

    public final int getInt(int i) {
        AppMethodBeat.m2504i(117718);
        int length = length();
        C41724g c41724g;
        if (i < 0 || i >= length) {
            c41724g = new C41724g(String.format("index(%d) out of range(0, %d).", new Object[]{Integer.valueOf(i), Integer.valueOf(length)}));
            AppMethodBeat.m2505o(117718);
            throw c41724g;
        }
        Object dt = this.eIF.mo59307dt(i);
        if (dt == null) {
            C41724g c41724g2 = new C41724g(String.format("getInteger(%d) return null.", new Object[]{Integer.valueOf(i)}));
            AppMethodBeat.m2505o(117718);
            throw c41724g2;
        }
        try {
            if (dt.isNumber()) {
                try {
                    length = dt.mo2363oP();
                    AppMethodBeat.m2505o(117718);
                    return length;
                } catch (Exception e) {
                    length = (int) dt.mo2365oR();
                    AppMethodBeat.m2505o(117718);
                    return length;
                }
            }
            if (dt.isString()) {
                length = (int) Double.parseDouble(dt.mo2367pq());
                AppMethodBeat.m2505o(117718);
                return length;
            }
            c41724g = new C41724g(String.format("getInt(%d) error, value : %s.", new Object[]{Integer.valueOf(i), dt}));
            AppMethodBeat.m2505o(117718);
            throw c41724g;
        } catch (Exception e2) {
        }
    }

    public final int optInt(int i) {
        AppMethodBeat.m2504i(117719);
        int optInt = optInt(i, 0);
        AppMethodBeat.m2505o(117719);
        return optInt;
    }

    public final int optInt(int i, int i2) {
        AppMethodBeat.m2504i(117720);
        int length = length();
        if (i < 0 || i >= length) {
            AppMethodBeat.m2505o(117720);
            return i2;
        }
        C0803h dt = this.eIF.mo59307dt(i);
        if (dt == null) {
            AppMethodBeat.m2505o(117720);
            return i2;
        }
        try {
            if (dt.isNumber()) {
                try {
                    i2 = dt.mo2363oP();
                    AppMethodBeat.m2505o(117720);
                    return i2;
                } catch (Exception e) {
                    i2 = (int) dt.mo2365oR();
                    AppMethodBeat.m2505o(117720);
                    return i2;
                }
            }
            if (dt.isString()) {
                i2 = (int) Double.parseDouble(dt.mo2367pq());
                AppMethodBeat.m2505o(117720);
                return i2;
            }
            AppMethodBeat.m2505o(117720);
            return i2;
        } catch (Exception e2) {
        }
    }

    public final long getLong(int i) {
        AppMethodBeat.m2504i(117721);
        int length = length();
        C41724g c41724g;
        if (i < 0 || i >= length) {
            c41724g = new C41724g(String.format("index(%d) out of range(0, %d).", new Object[]{Integer.valueOf(i), Integer.valueOf(length)}));
            AppMethodBeat.m2505o(117721);
            throw c41724g;
        }
        Object dt = this.eIF.mo59307dt(i);
        if (dt == null) {
            C41724g c41724g2 = new C41724g(String.format("getLong(%d) return null.", new Object[]{Integer.valueOf(i)}));
            AppMethodBeat.m2505o(117721);
            throw c41724g2;
        }
        try {
            long oQ;
            if (dt.isNumber()) {
                try {
                    oQ = dt.mo2364oQ();
                    AppMethodBeat.m2505o(117721);
                    return oQ;
                } catch (Exception e) {
                    oQ = (long) dt.mo2365oR();
                    AppMethodBeat.m2505o(117721);
                    return oQ;
                }
            }
            if (dt.isString()) {
                oQ = (long) Double.parseDouble(dt.mo2367pq());
                AppMethodBeat.m2505o(117721);
                return oQ;
            }
            c41724g = new C41724g(String.format("getLong(%d) error, value : %s.", new Object[]{Integer.valueOf(i), dt}));
            AppMethodBeat.m2505o(117721);
            throw c41724g;
        } catch (Exception e2) {
        }
    }

    public final long optLong(int i) {
        AppMethodBeat.m2504i(117722);
        long optLong = optLong(i, 0);
        AppMethodBeat.m2505o(117722);
        return optLong;
    }

    public final long optLong(int i, long j) {
        AppMethodBeat.m2504i(117723);
        int length = length();
        if (i < 0 || i >= length) {
            AppMethodBeat.m2505o(117723);
            return j;
        }
        C0803h dt = this.eIF.mo59307dt(i);
        if (dt == null) {
            AppMethodBeat.m2505o(117723);
            return j;
        }
        try {
            if (dt.isNumber()) {
                try {
                    j = dt.mo2364oQ();
                    AppMethodBeat.m2505o(117723);
                    return j;
                } catch (Exception e) {
                    j = (long) dt.mo2365oR();
                    AppMethodBeat.m2505o(117723);
                    return j;
                }
            }
            if (dt.isString()) {
                j = (long) Double.parseDouble(dt.mo2367pq());
                AppMethodBeat.m2505o(117723);
                return j;
            }
            AppMethodBeat.m2505o(117723);
            return j;
        } catch (Exception e2) {
        }
    }

    public final String getString(int i) {
        AppMethodBeat.m2504i(117724);
        int length = length();
        if (i < 0 || i >= length) {
            C41724g c41724g = new C41724g(String.format("index(%d) out of range(0, %d).", new Object[]{Integer.valueOf(i), Integer.valueOf(length)}));
            AppMethodBeat.m2505o(117724);
            throw c41724g;
        }
        C0803h dt = this.eIF.mo59307dt(i);
        String pq;
        if (dt == null) {
            C41724g c41724g2 = new C41724g(String.format("getString(%d) return null.", new Object[]{Integer.valueOf(i)}));
            AppMethodBeat.m2505o(117724);
            throw c41724g2;
        } else if (dt.isString()) {
            pq = dt.mo2367pq();
            AppMethodBeat.m2505o(117724);
            return pq;
        } else {
            pq = dt.toString();
            AppMethodBeat.m2505o(117724);
            return pq;
        }
    }

    public final String optString(int i) {
        AppMethodBeat.m2504i(117725);
        String optString = optString(i, null);
        AppMethodBeat.m2505o(117725);
        return optString;
    }

    public final String optString(int i, String str) {
        AppMethodBeat.m2504i(117726);
        int length = length();
        if (i < 0 || i >= length) {
            AppMethodBeat.m2505o(117726);
            return str;
        }
        C0803h dt = this.eIF.mo59307dt(i);
        if (dt == null) {
            AppMethodBeat.m2505o(117726);
            return str;
        } else if (dt.isString()) {
            str = dt.mo2367pq();
            AppMethodBeat.m2505o(117726);
            return str;
        } else {
            str = dt.toString();
            AppMethodBeat.m2505o(117726);
            return str;
        }
    }

    /* renamed from: jD */
    public final C41723a mo33311jD(int i) {
        AppMethodBeat.m2504i(117727);
        int length = length();
        if (i < 0 || i >= length) {
            C41724g c41724g = new C41724g(String.format("index(%d) out of range(0, %d).", new Object[]{Integer.valueOf(i), Integer.valueOf(length)}));
            AppMethodBeat.m2505o(117727);
            throw c41724g;
        }
        C0803h dt = this.eIF.mo59307dt(i);
        if (dt == null) {
            C41724g c41724g2 = new C41724g(String.format("getJSONArray(%d) return null.", new Object[]{Integer.valueOf(i)}));
            AppMethodBeat.m2505o(117727);
            throw c41724g2;
        }
        C17870k c17870k = new C17870k(dt.mo2361oN());
        AppMethodBeat.m2505o(117727);
        return c17870k;
    }

    /* renamed from: jE */
    public final C41723a mo33312jE(int i) {
        AppMethodBeat.m2504i(117728);
        int length = length();
        if (i < 0 || i >= length) {
            AppMethodBeat.m2505o(117728);
            return null;
        }
        C0803h dt = this.eIF.mo59307dt(i);
        if (dt == null) {
            AppMethodBeat.m2505o(117728);
            return null;
        }
        C41723a c17870k = new C17870k(dt.mo2361oN());
        AppMethodBeat.m2505o(117728);
        return c17870k;
    }

    /* renamed from: jF */
    public final C17868c mo33313jF(int i) {
        AppMethodBeat.m2504i(117729);
        int length = length();
        if (i < 0 || i >= length) {
            C41724g c41724g = new C41724g(String.format("index(%d) out of range(0, %d).", new Object[]{Integer.valueOf(i), Integer.valueOf(length)}));
            AppMethodBeat.m2505o(117729);
            throw c41724g;
        }
        C0803h dt = this.eIF.mo59307dt(i);
        if (dt == null) {
            C41724g c41724g2 = new C41724g(String.format("getJSONObject(%d) return null.", new Object[]{Integer.valueOf(i)}));
            AppMethodBeat.m2505o(117729);
            throw c41724g2;
        }
        C25742l c25742l = new C25742l(dt.mo2366oS());
        AppMethodBeat.m2505o(117729);
        return c25742l;
    }

    /* renamed from: jG */
    public final C17868c mo33314jG(int i) {
        AppMethodBeat.m2504i(117730);
        int length = length();
        if (i < 0 || i >= length) {
            AppMethodBeat.m2505o(117730);
            return null;
        }
        C0803h dt = this.eIF.mo59307dt(i);
        if (dt == null) {
            AppMethodBeat.m2505o(117730);
            return null;
        }
        C17868c c25742l = new C25742l(dt.mo2366oS());
        AppMethodBeat.m2505o(117730);
        return c25742l;
    }

    public final String toString() {
        AppMethodBeat.m2504i(117731);
        String c37205b = this.eIF.toString();
        AppMethodBeat.m2505o(117731);
        return c37205b;
    }

    public final String toString(int i) {
        AppMethodBeat.m2504i(117732);
        try {
            String a = this.eIF.mo2352a((C45009l) C41577k.m72800du(i));
            AppMethodBeat.m2505o(117732);
            return a;
        } catch (Throwable th) {
            C41724g c41724g = new C41724g(th);
            AppMethodBeat.m2505o(117732);
        }
    }
}

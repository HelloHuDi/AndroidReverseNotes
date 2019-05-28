package com.tencent.mm.aa;

import com.eclipsesource.a.a;
import com.eclipsesource.a.b;
import com.eclipsesource.a.h;
import com.eclipsesource.a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import junit.framework.Assert;

public final class k implements a {
    private b eIF;

    public k() {
        AppMethodBeat.i(117694);
        this.eIF = new b();
        AppMethodBeat.o(117694);
    }

    public k(String str) {
        AppMethodBeat.i(117695);
        this.eIF = a.ah(str).oN();
        if (this.eIF == null) {
            g gVar = new g(String.format("JSONArray string(%s) parse error.", new Object[]{str}));
            AppMethodBeat.o(117695);
            throw gVar;
        }
        AppMethodBeat.o(117695);
    }

    k(b bVar) {
        AppMethodBeat.i(117696);
        Assert.assertNotNull(bVar);
        this.eIF = bVar;
        AppMethodBeat.o(117696);
    }

    public final int length() {
        AppMethodBeat.i(117697);
        int size = this.eIF.aCy.size();
        AppMethodBeat.o(117697);
        return size;
    }

    public final a cj(boolean z) {
        AppMethodBeat.i(117698);
        this.eIF.aC(z);
        AppMethodBeat.o(117698);
        return this;
    }

    public final a o(double d) {
        AppMethodBeat.i(117699);
        this.eIF.n(d);
        AppMethodBeat.o(117699);
        return this;
    }

    public final a jC(int i) {
        AppMethodBeat.i(117700);
        this.eIF.ds(i);
        AppMethodBeat.o(117700);
        return this;
    }

    public final a fb(long j) {
        AppMethodBeat.i(117701);
        this.eIF.u(j);
        AppMethodBeat.o(117701);
        return this;
    }

    public final a av(Object obj) {
        AppMethodBeat.i(117702);
        j.a(this.eIF, obj);
        AppMethodBeat.o(117702);
        return this;
    }

    public final a z(int i, boolean z) {
        AppMethodBeat.i(117703);
        try {
            this.eIF.p(i, z);
            AppMethodBeat.o(117703);
            return this;
        } catch (Exception e) {
            g gVar = new g(e);
            AppMethodBeat.o(117703);
            throw gVar;
        }
    }

    public final a d(int i, double d) {
        AppMethodBeat.i(117704);
        try {
            this.eIF.b(i, d);
            AppMethodBeat.o(117704);
            return this;
        } catch (Exception e) {
            g gVar = new g(e);
            AppMethodBeat.o(117704);
            throw gVar;
        }
    }

    public final a cb(int i, int i2) {
        AppMethodBeat.i(117705);
        try {
            this.eIF.aX(i, i2);
            AppMethodBeat.o(117705);
            return this;
        } catch (Exception e) {
            g gVar = new g(e);
            AppMethodBeat.o(117705);
            throw gVar;
        }
    }

    public final a q(int i, long j) {
        AppMethodBeat.i(117706);
        try {
            this.eIF.f(i, j);
            AppMethodBeat.o(117706);
            return this;
        } catch (Exception e) {
            g gVar = new g(e);
            AppMethodBeat.o(117706);
            throw gVar;
        }
    }

    public final a d(int i, Object obj) {
        AppMethodBeat.i(117707);
        try {
            b bVar = this.eIF;
            if (obj instanceof c) {
                bVar.a(i, j.a((c) obj));
            } else if (obj instanceof a) {
                bVar.a(i, j.a((a) obj));
            } else if (obj instanceof Integer) {
                bVar.aX(i, ((Integer) obj).intValue());
            } else if (obj instanceof String) {
                bVar.aCy.set(i, a.ag((String) obj));
            } else if (obj instanceof Boolean) {
                bVar.p(i, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Long) {
                bVar.f(i, ((Long) obj).longValue());
            } else if (obj instanceof Float) {
                bVar.aCy.set(i, a.T(((Float) obj).floatValue()));
            } else if (obj instanceof Integer) {
                bVar.aX(i, ((Integer) obj).intValue());
            } else if (obj instanceof Double) {
                bVar.b(i, ((Double) obj).doubleValue());
            } else if (obj instanceof h) {
                bVar.a(i, (h) obj);
            }
            AppMethodBeat.o(117707);
            return this;
        } catch (Exception e) {
            g gVar = new g(e);
            AppMethodBeat.o(117707);
            throw gVar;
        }
    }

    public final boolean isNull(int i) {
        AppMethodBeat.i(117708);
        if (i < 0 || i >= length() || this.eIF.dt(i) == null) {
            AppMethodBeat.o(117708);
            return true;
        }
        AppMethodBeat.o(117708);
        return false;
    }

    public final Object get(int i) {
        AppMethodBeat.i(117709);
        int length = length();
        if (i < 0 || i >= length) {
            g gVar = new g(String.format("index(%d) out of range(0, %d).", new Object[]{Integer.valueOf(i), Integer.valueOf(length)}));
            AppMethodBeat.o(117709);
            throw gVar;
        }
        h dt = this.eIF.dt(i);
        Object hVar;
        if (dt == null) {
            AppMethodBeat.o(117709);
            return null;
        } else if (dt.isNumber()) {
            hVar = dt.toString();
            AppMethodBeat.o(117709);
            return hVar;
        } else if (dt.isBoolean()) {
            hVar = Boolean.valueOf(dt.oO());
            AppMethodBeat.o(117709);
            return hVar;
        } else if (dt.isArray()) {
            hVar = new k(dt.oN());
            AppMethodBeat.o(117709);
            return hVar;
        } else if (dt.isObject()) {
            hVar = new l(dt.oS());
            AppMethodBeat.o(117709);
            return hVar;
        } else if (dt.isString()) {
            hVar = dt.pq();
            AppMethodBeat.o(117709);
            return hVar;
        } else {
            AppMethodBeat.o(117709);
            return null;
        }
    }

    public final Object opt(int i) {
        AppMethodBeat.i(117710);
        int length = length();
        if (i < 0 || i >= length) {
            AppMethodBeat.o(117710);
            return null;
        }
        h dt = this.eIF.dt(i);
        Object hVar;
        if (dt == null) {
            AppMethodBeat.o(117710);
            return null;
        } else if (dt.isNumber()) {
            hVar = dt.toString();
            AppMethodBeat.o(117710);
            return hVar;
        } else if (dt.isBoolean()) {
            hVar = Boolean.valueOf(dt.oO());
            AppMethodBeat.o(117710);
            return hVar;
        } else if (dt.isArray()) {
            hVar = new k(dt.oN());
            AppMethodBeat.o(117710);
            return hVar;
        } else if (dt.isObject()) {
            hVar = new l(dt.oS());
            AppMethodBeat.o(117710);
            return hVar;
        } else if (dt.isString()) {
            hVar = dt.pq();
            AppMethodBeat.o(117710);
            return hVar;
        } else {
            AppMethodBeat.o(117710);
            return null;
        }
    }

    public final Object remove(int i) {
        AppMethodBeat.i(117711);
        int length = length();
        if (i < 0 || i >= length) {
            AppMethodBeat.o(117711);
            return null;
        }
        b bVar = this.eIF;
        bVar.aCy.remove(i);
        Object hVar;
        if (bVar.isNumber()) {
            hVar = bVar.toString();
            AppMethodBeat.o(117711);
            return hVar;
        } else if (bVar.isBoolean()) {
            hVar = Boolean.valueOf(bVar.oO());
            AppMethodBeat.o(117711);
            return hVar;
        } else if (bVar.isArray()) {
            hVar = new k(bVar.oN());
            AppMethodBeat.o(117711);
            return hVar;
        } else if (bVar.isObject()) {
            hVar = new l(bVar.oS());
            AppMethodBeat.o(117711);
            return hVar;
        } else if (bVar.isString()) {
            hVar = bVar.pq();
            AppMethodBeat.o(117711);
            return hVar;
        } else {
            AppMethodBeat.o(117711);
            return null;
        }
    }

    public final boolean getBoolean(int i) {
        AppMethodBeat.i(117712);
        int length = length();
        g gVar;
        if (i < 0 || i >= length) {
            gVar = new g(String.format("index(%d) out of range(0, %d).", new Object[]{Integer.valueOf(i), Integer.valueOf(length)}));
            AppMethodBeat.o(117712);
            throw gVar;
        }
        h dt = this.eIF.dt(i);
        if (dt == null) {
            g gVar2 = new g(String.format("getBoolean(%d) return null.", new Object[]{Integer.valueOf(i)}));
            AppMethodBeat.o(117712);
            throw gVar2;
        } else if (dt.isBoolean()) {
            boolean oO = dt.oO();
            AppMethodBeat.o(117712);
            return oO;
        } else {
            if (dt.isString()) {
                String pq = dt.pq();
                if ("true".equals(pq)) {
                    AppMethodBeat.o(117712);
                    return true;
                } else if ("false".equals(pq)) {
                    AppMethodBeat.o(117712);
                    return false;
                }
            }
            gVar = new g(String.format("getBoolean(%d) error, value : %s.", new Object[]{Integer.valueOf(i), dt}));
            AppMethodBeat.o(117712);
            throw gVar;
        }
    }

    public final boolean optBoolean(int i) {
        AppMethodBeat.i(117713);
        boolean optBoolean = optBoolean(i, false);
        AppMethodBeat.o(117713);
        return optBoolean;
    }

    public final boolean optBoolean(int i, boolean z) {
        AppMethodBeat.i(117714);
        int length = length();
        if (i < 0 || i >= length) {
            AppMethodBeat.o(117714);
            return z;
        }
        h dt = this.eIF.dt(i);
        if (dt == null) {
            AppMethodBeat.o(117714);
            return z;
        } else if (dt.isBoolean()) {
            z = dt.oO();
            AppMethodBeat.o(117714);
            return z;
        } else {
            if (dt.isString()) {
                String pq = dt.pq();
                if ("true".equals(pq)) {
                    AppMethodBeat.o(117714);
                    return true;
                } else if ("false".equals(pq)) {
                    AppMethodBeat.o(117714);
                    return false;
                }
            }
            AppMethodBeat.o(117714);
            return z;
        }
    }

    public final double getDouble(int i) {
        AppMethodBeat.i(117715);
        int length = length();
        g gVar;
        if (i < 0 || i >= length) {
            gVar = new g(String.format("index(%d) out of range(0, %d).", new Object[]{Integer.valueOf(i), Integer.valueOf(length)}));
            AppMethodBeat.o(117715);
            throw gVar;
        }
        h dt = this.eIF.dt(i);
        if (dt == null) {
            g gVar2 = new g(String.format("getDouble(%d) return null.", new Object[]{Integer.valueOf(i)}));
            AppMethodBeat.o(117715);
            throw gVar2;
        }
        try {
            double oR;
            if (dt.isNumber()) {
                oR = dt.oR();
                AppMethodBeat.o(117715);
            } else {
                if (dt.isString()) {
                    oR = Double.parseDouble(dt.pq());
                    AppMethodBeat.o(117715);
                }
                gVar = new g(String.format("getDouble(%d) error, value : %s.", new Object[]{Integer.valueOf(i), dt}));
                AppMethodBeat.o(117715);
                throw gVar;
            }
            return oR;
        } catch (Exception e) {
        }
    }

    public final double optDouble(int i) {
        AppMethodBeat.i(117716);
        double optDouble = optDouble(i, 0.0d);
        AppMethodBeat.o(117716);
        return optDouble;
    }

    public final double optDouble(int i, double d) {
        AppMethodBeat.i(117717);
        int length = length();
        if (i < 0 || i >= length) {
            AppMethodBeat.o(117717);
        } else {
            h dt = this.eIF.dt(i);
            if (dt == null) {
                AppMethodBeat.o(117717);
            } else {
                try {
                    if (dt.isNumber()) {
                        d = dt.oR();
                        AppMethodBeat.o(117717);
                    } else {
                        if (dt.isString()) {
                            d = Double.parseDouble(dt.pq());
                            AppMethodBeat.o(117717);
                        }
                        AppMethodBeat.o(117717);
                    }
                } catch (Exception e) {
                }
            }
        }
        return d;
    }

    public final int getInt(int i) {
        AppMethodBeat.i(117718);
        int length = length();
        g gVar;
        if (i < 0 || i >= length) {
            gVar = new g(String.format("index(%d) out of range(0, %d).", new Object[]{Integer.valueOf(i), Integer.valueOf(length)}));
            AppMethodBeat.o(117718);
            throw gVar;
        }
        Object dt = this.eIF.dt(i);
        if (dt == null) {
            g gVar2 = new g(String.format("getInteger(%d) return null.", new Object[]{Integer.valueOf(i)}));
            AppMethodBeat.o(117718);
            throw gVar2;
        }
        try {
            if (dt.isNumber()) {
                try {
                    length = dt.oP();
                    AppMethodBeat.o(117718);
                    return length;
                } catch (Exception e) {
                    length = (int) dt.oR();
                    AppMethodBeat.o(117718);
                    return length;
                }
            }
            if (dt.isString()) {
                length = (int) Double.parseDouble(dt.pq());
                AppMethodBeat.o(117718);
                return length;
            }
            gVar = new g(String.format("getInt(%d) error, value : %s.", new Object[]{Integer.valueOf(i), dt}));
            AppMethodBeat.o(117718);
            throw gVar;
        } catch (Exception e2) {
        }
    }

    public final int optInt(int i) {
        AppMethodBeat.i(117719);
        int optInt = optInt(i, 0);
        AppMethodBeat.o(117719);
        return optInt;
    }

    public final int optInt(int i, int i2) {
        AppMethodBeat.i(117720);
        int length = length();
        if (i < 0 || i >= length) {
            AppMethodBeat.o(117720);
            return i2;
        }
        h dt = this.eIF.dt(i);
        if (dt == null) {
            AppMethodBeat.o(117720);
            return i2;
        }
        try {
            if (dt.isNumber()) {
                try {
                    i2 = dt.oP();
                    AppMethodBeat.o(117720);
                    return i2;
                } catch (Exception e) {
                    i2 = (int) dt.oR();
                    AppMethodBeat.o(117720);
                    return i2;
                }
            }
            if (dt.isString()) {
                i2 = (int) Double.parseDouble(dt.pq());
                AppMethodBeat.o(117720);
                return i2;
            }
            AppMethodBeat.o(117720);
            return i2;
        } catch (Exception e2) {
        }
    }

    public final long getLong(int i) {
        AppMethodBeat.i(117721);
        int length = length();
        g gVar;
        if (i < 0 || i >= length) {
            gVar = new g(String.format("index(%d) out of range(0, %d).", new Object[]{Integer.valueOf(i), Integer.valueOf(length)}));
            AppMethodBeat.o(117721);
            throw gVar;
        }
        Object dt = this.eIF.dt(i);
        if (dt == null) {
            g gVar2 = new g(String.format("getLong(%d) return null.", new Object[]{Integer.valueOf(i)}));
            AppMethodBeat.o(117721);
            throw gVar2;
        }
        try {
            long oQ;
            if (dt.isNumber()) {
                try {
                    oQ = dt.oQ();
                    AppMethodBeat.o(117721);
                    return oQ;
                } catch (Exception e) {
                    oQ = (long) dt.oR();
                    AppMethodBeat.o(117721);
                    return oQ;
                }
            }
            if (dt.isString()) {
                oQ = (long) Double.parseDouble(dt.pq());
                AppMethodBeat.o(117721);
                return oQ;
            }
            gVar = new g(String.format("getLong(%d) error, value : %s.", new Object[]{Integer.valueOf(i), dt}));
            AppMethodBeat.o(117721);
            throw gVar;
        } catch (Exception e2) {
        }
    }

    public final long optLong(int i) {
        AppMethodBeat.i(117722);
        long optLong = optLong(i, 0);
        AppMethodBeat.o(117722);
        return optLong;
    }

    public final long optLong(int i, long j) {
        AppMethodBeat.i(117723);
        int length = length();
        if (i < 0 || i >= length) {
            AppMethodBeat.o(117723);
            return j;
        }
        h dt = this.eIF.dt(i);
        if (dt == null) {
            AppMethodBeat.o(117723);
            return j;
        }
        try {
            if (dt.isNumber()) {
                try {
                    j = dt.oQ();
                    AppMethodBeat.o(117723);
                    return j;
                } catch (Exception e) {
                    j = (long) dt.oR();
                    AppMethodBeat.o(117723);
                    return j;
                }
            }
            if (dt.isString()) {
                j = (long) Double.parseDouble(dt.pq());
                AppMethodBeat.o(117723);
                return j;
            }
            AppMethodBeat.o(117723);
            return j;
        } catch (Exception e2) {
        }
    }

    public final String getString(int i) {
        AppMethodBeat.i(117724);
        int length = length();
        if (i < 0 || i >= length) {
            g gVar = new g(String.format("index(%d) out of range(0, %d).", new Object[]{Integer.valueOf(i), Integer.valueOf(length)}));
            AppMethodBeat.o(117724);
            throw gVar;
        }
        h dt = this.eIF.dt(i);
        String pq;
        if (dt == null) {
            g gVar2 = new g(String.format("getString(%d) return null.", new Object[]{Integer.valueOf(i)}));
            AppMethodBeat.o(117724);
            throw gVar2;
        } else if (dt.isString()) {
            pq = dt.pq();
            AppMethodBeat.o(117724);
            return pq;
        } else {
            pq = dt.toString();
            AppMethodBeat.o(117724);
            return pq;
        }
    }

    public final String optString(int i) {
        AppMethodBeat.i(117725);
        String optString = optString(i, null);
        AppMethodBeat.o(117725);
        return optString;
    }

    public final String optString(int i, String str) {
        AppMethodBeat.i(117726);
        int length = length();
        if (i < 0 || i >= length) {
            AppMethodBeat.o(117726);
            return str;
        }
        h dt = this.eIF.dt(i);
        if (dt == null) {
            AppMethodBeat.o(117726);
            return str;
        } else if (dt.isString()) {
            str = dt.pq();
            AppMethodBeat.o(117726);
            return str;
        } else {
            str = dt.toString();
            AppMethodBeat.o(117726);
            return str;
        }
    }

    public final a jD(int i) {
        AppMethodBeat.i(117727);
        int length = length();
        if (i < 0 || i >= length) {
            g gVar = new g(String.format("index(%d) out of range(0, %d).", new Object[]{Integer.valueOf(i), Integer.valueOf(length)}));
            AppMethodBeat.o(117727);
            throw gVar;
        }
        h dt = this.eIF.dt(i);
        if (dt == null) {
            g gVar2 = new g(String.format("getJSONArray(%d) return null.", new Object[]{Integer.valueOf(i)}));
            AppMethodBeat.o(117727);
            throw gVar2;
        }
        k kVar = new k(dt.oN());
        AppMethodBeat.o(117727);
        return kVar;
    }

    public final a jE(int i) {
        AppMethodBeat.i(117728);
        int length = length();
        if (i < 0 || i >= length) {
            AppMethodBeat.o(117728);
            return null;
        }
        h dt = this.eIF.dt(i);
        if (dt == null) {
            AppMethodBeat.o(117728);
            return null;
        }
        a kVar = new k(dt.oN());
        AppMethodBeat.o(117728);
        return kVar;
    }

    public final c jF(int i) {
        AppMethodBeat.i(117729);
        int length = length();
        if (i < 0 || i >= length) {
            g gVar = new g(String.format("index(%d) out of range(0, %d).", new Object[]{Integer.valueOf(i), Integer.valueOf(length)}));
            AppMethodBeat.o(117729);
            throw gVar;
        }
        h dt = this.eIF.dt(i);
        if (dt == null) {
            g gVar2 = new g(String.format("getJSONObject(%d) return null.", new Object[]{Integer.valueOf(i)}));
            AppMethodBeat.o(117729);
            throw gVar2;
        }
        l lVar = new l(dt.oS());
        AppMethodBeat.o(117729);
        return lVar;
    }

    public final c jG(int i) {
        AppMethodBeat.i(117730);
        int length = length();
        if (i < 0 || i >= length) {
            AppMethodBeat.o(117730);
            return null;
        }
        h dt = this.eIF.dt(i);
        if (dt == null) {
            AppMethodBeat.o(117730);
            return null;
        }
        c lVar = new l(dt.oS());
        AppMethodBeat.o(117730);
        return lVar;
    }

    public final String toString() {
        AppMethodBeat.i(117731);
        String bVar = this.eIF.toString();
        AppMethodBeat.o(117731);
        return bVar;
    }

    public final String toString(int i) {
        AppMethodBeat.i(117732);
        try {
            String a = this.eIF.a((l) com.eclipsesource.a.k.du(i));
            AppMethodBeat.o(117732);
            return a;
        } catch (Throwable th) {
            g gVar = new g(th);
            AppMethodBeat.o(117732);
        }
    }
}

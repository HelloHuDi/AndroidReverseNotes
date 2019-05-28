package com.tencent.mm.aa;

import com.eclipsesource.a.a;
import com.eclipsesource.a.e;
import com.eclipsesource.a.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

public final class l implements c {
    private e eIG;

    public l() {
        AppMethodBeat.i(117733);
        this.eIG = new e();
        AppMethodBeat.o(117733);
    }

    l(e eVar) {
        AppMethodBeat.i(117734);
        if (eVar == null) {
            eVar = new e();
        }
        this.eIG = eVar;
        AppMethodBeat.o(117734);
    }

    public l(Map map) {
        AppMethodBeat.i(117735);
        this.eIG = j.k(map);
        AppMethodBeat.o(117735);
    }

    public l(String str) {
        AppMethodBeat.i(117736);
        this.eIG = a.ah(str).oS();
        AppMethodBeat.o(117736);
    }

    public final int length() {
        AppMethodBeat.i(117737);
        int size = this.eIG.aLq.size();
        AppMethodBeat.o(117737);
        return size;
    }

    public final c s(String str, boolean z) {
        AppMethodBeat.i(117738);
        this.eIG.a(str, a.aB(z));
        AppMethodBeat.o(117738);
        return this;
    }

    public final c c(String str, double d) {
        AppMethodBeat.i(117739);
        this.eIG.a(str, a.m(d));
        AppMethodBeat.o(117739);
        return this;
    }

    public final c J(String str, int i) {
        AppMethodBeat.i(117740);
        this.eIG.a(str, a.dr(i));
        AppMethodBeat.o(117740);
        return this;
    }

    public final c k(String str, long j) {
        AppMethodBeat.i(117741);
        this.eIG.a(str, a.t(j));
        AppMethodBeat.o(117741);
        return this;
    }

    public final c e(String str, Object obj) {
        AppMethodBeat.i(117742);
        j.a(this.eIG, str, obj);
        AppMethodBeat.o(117742);
        return this;
    }

    public final c f(String str, Object obj) {
        AppMethodBeat.i(117743);
        j.a(this.eIG, str, obj);
        AppMethodBeat.o(117743);
        return this;
    }

    public final String lr(String str) {
        AppMethodBeat.i(117744);
        if (str == null) {
            g gVar = new g("Names must be non-null");
            AppMethodBeat.o(117744);
            throw gVar;
        }
        AppMethodBeat.o(117744);
        return str;
    }

    public final Object remove(String str) {
        AppMethodBeat.i(117745);
        e eVar = this.eIG;
        if (str == null) {
            NullPointerException nullPointerException = new NullPointerException("name is null");
            AppMethodBeat.o(117745);
            throw nullPointerException;
        }
        int indexOf = eVar.indexOf(str);
        if (indexOf != -1) {
            eVar.aLr.remove(indexOf);
            eVar.aLq.remove(indexOf);
            eVar.aCy.remove(indexOf);
        }
        Object valueOf;
        if (eVar.isNumber()) {
            String hVar = eVar.toString();
            AppMethodBeat.o(117745);
            return hVar;
        } else if (eVar.isBoolean()) {
            valueOf = Boolean.valueOf(eVar.oO());
            AppMethodBeat.o(117745);
            return valueOf;
        } else if (eVar.isArray()) {
            valueOf = new k(eVar.oN());
            AppMethodBeat.o(117745);
            return valueOf;
        } else if (eVar.isObject()) {
            valueOf = new l(eVar.oS());
            AppMethodBeat.o(117745);
            return valueOf;
        } else if (eVar.isString()) {
            valueOf = eVar.pq();
            AppMethodBeat.o(117745);
            return valueOf;
        } else {
            AppMethodBeat.o(117745);
            return null;
        }
    }

    public final boolean isNull(String str) {
        AppMethodBeat.i(117746);
        if (this.eIG.ak(str) == null) {
            AppMethodBeat.o(117746);
            return true;
        }
        AppMethodBeat.o(117746);
        return false;
    }

    public final boolean has(String str) {
        AppMethodBeat.i(117747);
        if (this.eIG.ak(str) != null) {
            AppMethodBeat.o(117747);
            return true;
        }
        AppMethodBeat.o(117747);
        return false;
    }

    public final Object get(String str) {
        AppMethodBeat.i(117748);
        Object opt = opt(str);
        AppMethodBeat.o(117748);
        return opt;
    }

    public final Object opt(String str) {
        AppMethodBeat.i(117749);
        h ak = this.eIG.ak(str);
        Object hVar;
        if (ak == null) {
            AppMethodBeat.o(117749);
            return null;
        } else if (ak.isNumber()) {
            hVar = ak.toString();
            AppMethodBeat.o(117749);
            return hVar;
        } else if (ak.isBoolean()) {
            hVar = Boolean.valueOf(ak.oO());
            AppMethodBeat.o(117749);
            return hVar;
        } else if (ak.isArray()) {
            hVar = new k(ak.oN());
            AppMethodBeat.o(117749);
            return hVar;
        } else if (ak.isObject()) {
            hVar = new l(ak.oS());
            AppMethodBeat.o(117749);
            return hVar;
        } else if (ak.isString()) {
            hVar = ak.pq();
            AppMethodBeat.o(117749);
            return hVar;
        } else {
            AppMethodBeat.o(117749);
            return null;
        }
    }

    public final boolean getBoolean(String str) {
        AppMethodBeat.i(117750);
        h ak = this.eIG.ak(str);
        if (ak == null) {
            g gVar = new g(String.format("key %s do not exist.", new Object[]{str}));
            AppMethodBeat.o(117750);
            throw gVar;
        } else if (ak.isBoolean()) {
            boolean oO = ak.oO();
            AppMethodBeat.o(117750);
            return oO;
        } else {
            if (ak.isString()) {
                String hVar = ak.toString();
                if ("true".equals(hVar)) {
                    AppMethodBeat.o(117750);
                    return true;
                } else if ("false".equals(hVar)) {
                    AppMethodBeat.o(117750);
                    return false;
                }
            }
            g gVar2 = new g(String.format("getBoolean by key : %s error, value : %s", new Object[]{str, ak}));
            AppMethodBeat.o(117750);
            throw gVar2;
        }
    }

    public final boolean optBoolean(String str, boolean z) {
        AppMethodBeat.i(117751);
        h ak = this.eIG.ak(str);
        if (ak == null) {
            AppMethodBeat.o(117751);
            return z;
        } else if (ak.isBoolean()) {
            z = ak.oO();
            AppMethodBeat.o(117751);
            return z;
        } else {
            if (ak.isString()) {
                String hVar = ak.toString();
                if ("true".equals(hVar)) {
                    AppMethodBeat.o(117751);
                    return true;
                } else if ("false".equals(hVar)) {
                    AppMethodBeat.o(117751);
                    return false;
                }
            }
            AppMethodBeat.o(117751);
            return z;
        }
    }

    public final double getDouble(String str) {
        AppMethodBeat.i(117752);
        h ak = this.eIG.ak(str);
        if (ak == null) {
            g gVar = new g(String.format("key %s do not exist.", new Object[]{str}));
            AppMethodBeat.o(117752);
            throw gVar;
        }
        try {
            double oR;
            if (ak.isNumber()) {
                oR = ak.oR();
                AppMethodBeat.o(117752);
            } else {
                if (ak.isString()) {
                    oR = Double.parseDouble(ak.toString());
                    AppMethodBeat.o(117752);
                }
                g gVar2 = new g(String.format("getDouble by key : %s error, value : %s", new Object[]{str, ak}));
                AppMethodBeat.o(117752);
                throw gVar2;
            }
            return oR;
        } catch (Exception e) {
        }
    }

    public final double optDouble(String str, double d) {
        AppMethodBeat.i(117753);
        h ak = this.eIG.ak(str);
        if (ak == null) {
            AppMethodBeat.o(117753);
        } else {
            try {
                if (ak.isNumber()) {
                    d = ak.oR();
                    AppMethodBeat.o(117753);
                } else {
                    if (ak.isString()) {
                        d = Double.parseDouble(ak.toString());
                        AppMethodBeat.o(117753);
                    }
                    AppMethodBeat.o(117753);
                }
            } catch (Exception e) {
            }
        }
        return d;
    }

    public final int getInt(String str) {
        AppMethodBeat.i(117754);
        Object ak = this.eIG.ak(str);
        if (ak == null) {
            g gVar = new g(String.format("key %s do not exist.", new Object[]{str}));
            AppMethodBeat.o(117754);
            throw gVar;
        }
        try {
            int oP;
            if (ak.isNumber()) {
                try {
                    oP = ak.oP();
                    AppMethodBeat.o(117754);
                    return oP;
                } catch (Exception e) {
                    oP = (int) ak.oR();
                    AppMethodBeat.o(117754);
                    return oP;
                }
            }
            if (ak.isString()) {
                oP = (int) Double.parseDouble(ak.toString());
                AppMethodBeat.o(117754);
                return oP;
            }
            g gVar2 = new g(String.format("getInt by key : %s error, value : %s", new Object[]{str, ak}));
            AppMethodBeat.o(117754);
            throw gVar2;
        } catch (Exception e2) {
        }
    }

    public final int optInt(String str, int i) {
        AppMethodBeat.i(117755);
        h ak = this.eIG.ak(str);
        if (ak == null) {
            AppMethodBeat.o(117755);
            return i;
        }
        try {
            if (ak.isNumber()) {
                try {
                    i = ak.oP();
                    AppMethodBeat.o(117755);
                    return i;
                } catch (Exception e) {
                    i = (int) ak.oR();
                    AppMethodBeat.o(117755);
                    return i;
                }
            }
            if (ak.isString()) {
                i = (int) Double.parseDouble(ak.toString());
                AppMethodBeat.o(117755);
                return i;
            }
            AppMethodBeat.o(117755);
            return i;
        } catch (Exception e2) {
        }
    }

    public final long getLong(String str) {
        AppMethodBeat.i(117756);
        Object ak = this.eIG.ak(str);
        if (ak == null) {
            g gVar = new g(String.format("key %s do not exist.", new Object[]{str}));
            AppMethodBeat.o(117756);
            throw gVar;
        }
        try {
            long oQ;
            if (ak.isNumber()) {
                try {
                    oQ = ak.oQ();
                    AppMethodBeat.o(117756);
                    return oQ;
                } catch (Exception e) {
                    oQ = (long) ak.oR();
                    AppMethodBeat.o(117756);
                    return oQ;
                }
            }
            if (ak.isString()) {
                oQ = (long) Double.parseDouble(ak.toString());
                AppMethodBeat.o(117756);
                return oQ;
            }
            g gVar2 = new g(String.format("getLong by key : %s error, value : %s", new Object[]{str, ak}));
            AppMethodBeat.o(117756);
            throw gVar2;
        } catch (Exception e2) {
        }
    }

    public final long optLong(String str, long j) {
        AppMethodBeat.i(117757);
        h ak = this.eIG.ak(str);
        if (ak == null) {
            AppMethodBeat.o(117757);
            return j;
        }
        try {
            if (ak.isNumber()) {
                try {
                    j = ak.oQ();
                    AppMethodBeat.o(117757);
                    return j;
                } catch (Exception e) {
                    j = (long) ak.oR();
                    AppMethodBeat.o(117757);
                    return j;
                }
            }
            if (ak.isString()) {
                j = (long) Double.parseDouble(ak.toString());
                AppMethodBeat.o(117757);
                return j;
            }
            AppMethodBeat.o(117757);
            return j;
        } catch (Exception e2) {
        }
    }

    public final String getString(String str) {
        AppMethodBeat.i(117758);
        h ak = this.eIG.ak(str);
        String pq;
        if (ak == null) {
            g gVar = new g(String.format("key %s do not exist.", new Object[]{str}));
            AppMethodBeat.o(117758);
            throw gVar;
        } else if (ak.isString()) {
            pq = ak.pq();
            AppMethodBeat.o(117758);
            return pq;
        } else {
            pq = ak.toString();
            AppMethodBeat.o(117758);
            return pq;
        }
    }

    public final String optString(String str) {
        AppMethodBeat.i(117759);
        String optString = optString(str, null);
        AppMethodBeat.o(117759);
        return optString;
    }

    public final String optString(String str, String str2) {
        AppMethodBeat.i(117760);
        h ak = this.eIG.ak(str);
        String pq;
        if (ak == null) {
            AppMethodBeat.o(117760);
            return null;
        } else if (ak.isString()) {
            pq = ak.pq();
            AppMethodBeat.o(117760);
            return pq;
        } else {
            pq = ak.toString();
            AppMethodBeat.o(117760);
            return pq;
        }
    }

    public final a ls(String str) {
        AppMethodBeat.i(117761);
        h ak = this.eIG.ak(str);
        if (ak == null) {
            g gVar = new g(String.format("key %s do not exist.", new Object[]{str}));
            AppMethodBeat.o(117761);
            throw gVar;
        }
        k kVar = new k(ak.oN());
        AppMethodBeat.o(117761);
        return kVar;
    }

    public final a lt(String str) {
        AppMethodBeat.i(117762);
        h ak = this.eIG.ak(str);
        if (ak == null) {
            AppMethodBeat.o(117762);
            return null;
        }
        a kVar = new k(ak.oN());
        AppMethodBeat.o(117762);
        return kVar;
    }

    public final c lu(String str) {
        AppMethodBeat.i(117763);
        h ak = this.eIG.ak(str);
        if (ak == null) {
            g gVar = new g(String.format("key %s do not exist.", new Object[]{str}));
            AppMethodBeat.o(117763);
            throw gVar;
        }
        l lVar = new l(ak.oS());
        AppMethodBeat.o(117763);
        return lVar;
    }

    public final c lv(String str) {
        AppMethodBeat.i(117764);
        h ak = this.eIG.ak(str);
        if (ak == null) {
            AppMethodBeat.o(117764);
            return null;
        }
        c lVar = new l(ak.oS());
        AppMethodBeat.o(117764);
        return lVar;
    }

    public final Iterator<String> keys() {
        AppMethodBeat.i(117765);
        Iterator it = Collections.unmodifiableList(this.eIG.aLq).iterator();
        AppMethodBeat.o(117765);
        return it;
    }

    public final String toString() {
        AppMethodBeat.i(117766);
        String eVar = this.eIG.toString();
        AppMethodBeat.o(117766);
        return eVar;
    }
}

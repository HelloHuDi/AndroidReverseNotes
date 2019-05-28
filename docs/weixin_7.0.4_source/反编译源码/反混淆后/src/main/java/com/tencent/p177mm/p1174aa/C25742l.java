package com.tencent.p177mm.p1174aa;

import com.eclipsesource.p096a.C0803h;
import com.eclipsesource.p096a.C25470a;
import com.eclipsesource.p096a.C31986e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.tencent.mm.aa.l */
public final class C25742l implements C17868c {
    private C31986e eIG;

    public C25742l() {
        AppMethodBeat.m2504i(117733);
        this.eIG = new C31986e();
        AppMethodBeat.m2505o(117733);
    }

    C25742l(C31986e c31986e) {
        AppMethodBeat.m2504i(117734);
        if (c31986e == null) {
            c31986e = new C31986e();
        }
        this.eIG = c31986e;
        AppMethodBeat.m2505o(117734);
    }

    public C25742l(Map map) {
        AppMethodBeat.m2504i(117735);
        this.eIG = C41727j.m73485k(map);
        AppMethodBeat.m2505o(117735);
    }

    public C25742l(String str) {
        AppMethodBeat.m2504i(117736);
        this.eIG = C25470a.m40250ah(str).mo2366oS();
        AppMethodBeat.m2505o(117736);
    }

    public final int length() {
        AppMethodBeat.m2504i(117737);
        int size = this.eIG.aLq.size();
        AppMethodBeat.m2505o(117737);
        return size;
    }

    /* renamed from: s */
    public final C17868c mo33361s(String str, boolean z) {
        AppMethodBeat.m2504i(117738);
        this.eIG.mo52093a(str, C25470a.m40248aB(z));
        AppMethodBeat.m2505o(117738);
        return this;
    }

    /* renamed from: c */
    public final C17868c mo33334c(String str, double d) {
        AppMethodBeat.m2504i(117739);
        this.eIG.mo52093a(str, C25470a.m40253m(d));
        AppMethodBeat.m2505o(117739);
        return this;
    }

    /* renamed from: J */
    public final C17868c mo33333J(String str, int i) {
        AppMethodBeat.m2504i(117740);
        this.eIG.mo52093a(str, C25470a.m40252dr(i));
        AppMethodBeat.m2505o(117740);
        return this;
    }

    /* renamed from: k */
    public final C17868c mo33345k(String str, long j) {
        AppMethodBeat.m2504i(117741);
        this.eIG.mo52093a(str, C25470a.m40254t(j));
        AppMethodBeat.m2505o(117741);
        return this;
    }

    /* renamed from: e */
    public final C17868c mo33335e(String str, Object obj) {
        AppMethodBeat.m2504i(117742);
        C41727j.m73484a(this.eIG, str, obj);
        AppMethodBeat.m2505o(117742);
        return this;
    }

    /* renamed from: f */
    public final C17868c mo33336f(String str, Object obj) {
        AppMethodBeat.m2504i(117743);
        C41727j.m73484a(this.eIG, str, obj);
        AppMethodBeat.m2505o(117743);
        return this;
    }

    /* renamed from: lr */
    public final String mo33348lr(String str) {
        AppMethodBeat.m2504i(117744);
        if (str == null) {
            C41724g c41724g = new C41724g("Names must be non-null");
            AppMethodBeat.m2505o(117744);
            throw c41724g;
        }
        AppMethodBeat.m2505o(117744);
        return str;
    }

    public final Object remove(String str) {
        AppMethodBeat.m2504i(117745);
        C31986e c31986e = this.eIG;
        if (str == null) {
            NullPointerException nullPointerException = new NullPointerException("name is null");
            AppMethodBeat.m2505o(117745);
            throw nullPointerException;
        }
        int indexOf = c31986e.indexOf(str);
        if (indexOf != -1) {
            c31986e.aLr.remove(indexOf);
            c31986e.aLq.remove(indexOf);
            c31986e.aCy.remove(indexOf);
        }
        Object valueOf;
        if (c31986e.isNumber()) {
            String c0803h = c31986e.toString();
            AppMethodBeat.m2505o(117745);
            return c0803h;
        } else if (c31986e.isBoolean()) {
            valueOf = Boolean.valueOf(c31986e.mo2362oO());
            AppMethodBeat.m2505o(117745);
            return valueOf;
        } else if (c31986e.isArray()) {
            valueOf = new C17870k(c31986e.mo2361oN());
            AppMethodBeat.m2505o(117745);
            return valueOf;
        } else if (c31986e.isObject()) {
            valueOf = new C25742l(c31986e.mo2366oS());
            AppMethodBeat.m2505o(117745);
            return valueOf;
        } else if (c31986e.isString()) {
            valueOf = c31986e.mo2367pq();
            AppMethodBeat.m2505o(117745);
            return valueOf;
        } else {
            AppMethodBeat.m2505o(117745);
            return null;
        }
    }

    public final boolean isNull(String str) {
        AppMethodBeat.m2504i(117746);
        if (this.eIG.mo52094ak(str) == null) {
            AppMethodBeat.m2505o(117746);
            return true;
        }
        AppMethodBeat.m2505o(117746);
        return false;
    }

    public final boolean has(String str) {
        AppMethodBeat.m2504i(117747);
        if (this.eIG.mo52094ak(str) != null) {
            AppMethodBeat.m2505o(117747);
            return true;
        }
        AppMethodBeat.m2505o(117747);
        return false;
    }

    public final Object get(String str) {
        AppMethodBeat.m2504i(117748);
        Object opt = opt(str);
        AppMethodBeat.m2505o(117748);
        return opt;
    }

    public final Object opt(String str) {
        AppMethodBeat.m2504i(117749);
        C0803h ak = this.eIG.mo52094ak(str);
        Object c0803h;
        if (ak == null) {
            AppMethodBeat.m2505o(117749);
            return null;
        } else if (ak.isNumber()) {
            c0803h = ak.toString();
            AppMethodBeat.m2505o(117749);
            return c0803h;
        } else if (ak.isBoolean()) {
            c0803h = Boolean.valueOf(ak.mo2362oO());
            AppMethodBeat.m2505o(117749);
            return c0803h;
        } else if (ak.isArray()) {
            c0803h = new C17870k(ak.mo2361oN());
            AppMethodBeat.m2505o(117749);
            return c0803h;
        } else if (ak.isObject()) {
            c0803h = new C25742l(ak.mo2366oS());
            AppMethodBeat.m2505o(117749);
            return c0803h;
        } else if (ak.isString()) {
            c0803h = ak.mo2367pq();
            AppMethodBeat.m2505o(117749);
            return c0803h;
        } else {
            AppMethodBeat.m2505o(117749);
            return null;
        }
    }

    public final boolean getBoolean(String str) {
        AppMethodBeat.m2504i(117750);
        C0803h ak = this.eIG.mo52094ak(str);
        if (ak == null) {
            C41724g c41724g = new C41724g(String.format("key %s do not exist.", new Object[]{str}));
            AppMethodBeat.m2505o(117750);
            throw c41724g;
        } else if (ak.isBoolean()) {
            boolean oO = ak.mo2362oO();
            AppMethodBeat.m2505o(117750);
            return oO;
        } else {
            if (ak.isString()) {
                String c0803h = ak.toString();
                if ("true".equals(c0803h)) {
                    AppMethodBeat.m2505o(117750);
                    return true;
                } else if ("false".equals(c0803h)) {
                    AppMethodBeat.m2505o(117750);
                    return false;
                }
            }
            C41724g c41724g2 = new C41724g(String.format("getBoolean by key : %s error, value : %s", new Object[]{str, ak}));
            AppMethodBeat.m2505o(117750);
            throw c41724g2;
        }
    }

    public final boolean optBoolean(String str, boolean z) {
        AppMethodBeat.m2504i(117751);
        C0803h ak = this.eIG.mo52094ak(str);
        if (ak == null) {
            AppMethodBeat.m2505o(117751);
            return z;
        } else if (ak.isBoolean()) {
            z = ak.mo2362oO();
            AppMethodBeat.m2505o(117751);
            return z;
        } else {
            if (ak.isString()) {
                String c0803h = ak.toString();
                if ("true".equals(c0803h)) {
                    AppMethodBeat.m2505o(117751);
                    return true;
                } else if ("false".equals(c0803h)) {
                    AppMethodBeat.m2505o(117751);
                    return false;
                }
            }
            AppMethodBeat.m2505o(117751);
            return z;
        }
    }

    public final double getDouble(String str) {
        AppMethodBeat.m2504i(117752);
        C0803h ak = this.eIG.mo52094ak(str);
        if (ak == null) {
            C41724g c41724g = new C41724g(String.format("key %s do not exist.", new Object[]{str}));
            AppMethodBeat.m2505o(117752);
            throw c41724g;
        }
        try {
            double oR;
            if (ak.isNumber()) {
                oR = ak.mo2365oR();
                AppMethodBeat.m2505o(117752);
            } else {
                if (ak.isString()) {
                    oR = Double.parseDouble(ak.toString());
                    AppMethodBeat.m2505o(117752);
                }
                C41724g c41724g2 = new C41724g(String.format("getDouble by key : %s error, value : %s", new Object[]{str, ak}));
                AppMethodBeat.m2505o(117752);
                throw c41724g2;
            }
            return oR;
        } catch (Exception e) {
        }
    }

    public final double optDouble(String str, double d) {
        AppMethodBeat.m2504i(117753);
        C0803h ak = this.eIG.mo52094ak(str);
        if (ak == null) {
            AppMethodBeat.m2505o(117753);
        } else {
            try {
                if (ak.isNumber()) {
                    d = ak.mo2365oR();
                    AppMethodBeat.m2505o(117753);
                } else {
                    if (ak.isString()) {
                        d = Double.parseDouble(ak.toString());
                        AppMethodBeat.m2505o(117753);
                    }
                    AppMethodBeat.m2505o(117753);
                }
            } catch (Exception e) {
            }
        }
        return d;
    }

    public final int getInt(String str) {
        AppMethodBeat.m2504i(117754);
        Object ak = this.eIG.mo52094ak(str);
        if (ak == null) {
            C41724g c41724g = new C41724g(String.format("key %s do not exist.", new Object[]{str}));
            AppMethodBeat.m2505o(117754);
            throw c41724g;
        }
        try {
            int oP;
            if (ak.isNumber()) {
                try {
                    oP = ak.mo2363oP();
                    AppMethodBeat.m2505o(117754);
                    return oP;
                } catch (Exception e) {
                    oP = (int) ak.mo2365oR();
                    AppMethodBeat.m2505o(117754);
                    return oP;
                }
            }
            if (ak.isString()) {
                oP = (int) Double.parseDouble(ak.toString());
                AppMethodBeat.m2505o(117754);
                return oP;
            }
            C41724g c41724g2 = new C41724g(String.format("getInt by key : %s error, value : %s", new Object[]{str, ak}));
            AppMethodBeat.m2505o(117754);
            throw c41724g2;
        } catch (Exception e2) {
        }
    }

    public final int optInt(String str, int i) {
        AppMethodBeat.m2504i(117755);
        C0803h ak = this.eIG.mo52094ak(str);
        if (ak == null) {
            AppMethodBeat.m2505o(117755);
            return i;
        }
        try {
            if (ak.isNumber()) {
                try {
                    i = ak.mo2363oP();
                    AppMethodBeat.m2505o(117755);
                    return i;
                } catch (Exception e) {
                    i = (int) ak.mo2365oR();
                    AppMethodBeat.m2505o(117755);
                    return i;
                }
            }
            if (ak.isString()) {
                i = (int) Double.parseDouble(ak.toString());
                AppMethodBeat.m2505o(117755);
                return i;
            }
            AppMethodBeat.m2505o(117755);
            return i;
        } catch (Exception e2) {
        }
    }

    public final long getLong(String str) {
        AppMethodBeat.m2504i(117756);
        Object ak = this.eIG.mo52094ak(str);
        if (ak == null) {
            C41724g c41724g = new C41724g(String.format("key %s do not exist.", new Object[]{str}));
            AppMethodBeat.m2505o(117756);
            throw c41724g;
        }
        try {
            long oQ;
            if (ak.isNumber()) {
                try {
                    oQ = ak.mo2364oQ();
                    AppMethodBeat.m2505o(117756);
                    return oQ;
                } catch (Exception e) {
                    oQ = (long) ak.mo2365oR();
                    AppMethodBeat.m2505o(117756);
                    return oQ;
                }
            }
            if (ak.isString()) {
                oQ = (long) Double.parseDouble(ak.toString());
                AppMethodBeat.m2505o(117756);
                return oQ;
            }
            C41724g c41724g2 = new C41724g(String.format("getLong by key : %s error, value : %s", new Object[]{str, ak}));
            AppMethodBeat.m2505o(117756);
            throw c41724g2;
        } catch (Exception e2) {
        }
    }

    public final long optLong(String str, long j) {
        AppMethodBeat.m2504i(117757);
        C0803h ak = this.eIG.mo52094ak(str);
        if (ak == null) {
            AppMethodBeat.m2505o(117757);
            return j;
        }
        try {
            if (ak.isNumber()) {
                try {
                    j = ak.mo2364oQ();
                    AppMethodBeat.m2505o(117757);
                    return j;
                } catch (Exception e) {
                    j = (long) ak.mo2365oR();
                    AppMethodBeat.m2505o(117757);
                    return j;
                }
            }
            if (ak.isString()) {
                j = (long) Double.parseDouble(ak.toString());
                AppMethodBeat.m2505o(117757);
                return j;
            }
            AppMethodBeat.m2505o(117757);
            return j;
        } catch (Exception e2) {
        }
    }

    public final String getString(String str) {
        AppMethodBeat.m2504i(117758);
        C0803h ak = this.eIG.mo52094ak(str);
        String pq;
        if (ak == null) {
            C41724g c41724g = new C41724g(String.format("key %s do not exist.", new Object[]{str}));
            AppMethodBeat.m2505o(117758);
            throw c41724g;
        } else if (ak.isString()) {
            pq = ak.mo2367pq();
            AppMethodBeat.m2505o(117758);
            return pq;
        } else {
            pq = ak.toString();
            AppMethodBeat.m2505o(117758);
            return pq;
        }
    }

    public final String optString(String str) {
        AppMethodBeat.m2504i(117759);
        String optString = optString(str, null);
        AppMethodBeat.m2505o(117759);
        return optString;
    }

    public final String optString(String str, String str2) {
        AppMethodBeat.m2504i(117760);
        C0803h ak = this.eIG.mo52094ak(str);
        String pq;
        if (ak == null) {
            AppMethodBeat.m2505o(117760);
            return null;
        } else if (ak.isString()) {
            pq = ak.mo2367pq();
            AppMethodBeat.m2505o(117760);
            return pq;
        } else {
            pq = ak.toString();
            AppMethodBeat.m2505o(117760);
            return pq;
        }
    }

    /* renamed from: ls */
    public final C41723a mo33349ls(String str) {
        AppMethodBeat.m2504i(117761);
        C0803h ak = this.eIG.mo52094ak(str);
        if (ak == null) {
            C41724g c41724g = new C41724g(String.format("key %s do not exist.", new Object[]{str}));
            AppMethodBeat.m2505o(117761);
            throw c41724g;
        }
        C17870k c17870k = new C17870k(ak.mo2361oN());
        AppMethodBeat.m2505o(117761);
        return c17870k;
    }

    /* renamed from: lt */
    public final C41723a mo33350lt(String str) {
        AppMethodBeat.m2504i(117762);
        C0803h ak = this.eIG.mo52094ak(str);
        if (ak == null) {
            AppMethodBeat.m2505o(117762);
            return null;
        }
        C41723a c17870k = new C17870k(ak.mo2361oN());
        AppMethodBeat.m2505o(117762);
        return c17870k;
    }

    /* renamed from: lu */
    public final C17868c mo33351lu(String str) {
        AppMethodBeat.m2504i(117763);
        C0803h ak = this.eIG.mo52094ak(str);
        if (ak == null) {
            C41724g c41724g = new C41724g(String.format("key %s do not exist.", new Object[]{str}));
            AppMethodBeat.m2505o(117763);
            throw c41724g;
        }
        C25742l c25742l = new C25742l(ak.mo2366oS());
        AppMethodBeat.m2505o(117763);
        return c25742l;
    }

    /* renamed from: lv */
    public final C17868c mo33352lv(String str) {
        AppMethodBeat.m2504i(117764);
        C0803h ak = this.eIG.mo52094ak(str);
        if (ak == null) {
            AppMethodBeat.m2505o(117764);
            return null;
        }
        C17868c c25742l = new C25742l(ak.mo2366oS());
        AppMethodBeat.m2505o(117764);
        return c25742l;
    }

    public final Iterator<String> keys() {
        AppMethodBeat.m2504i(117765);
        Iterator it = Collections.unmodifiableList(this.eIG.aLq).iterator();
        AppMethodBeat.m2505o(117765);
        return it;
    }

    public final String toString() {
        AppMethodBeat.m2504i(117766);
        String c31986e = this.eIG.toString();
        AppMethodBeat.m2505o(117766);
        return c31986e;
    }
}

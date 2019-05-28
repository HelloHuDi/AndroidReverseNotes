package com.tencent.p177mm.p1174aa;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.aa.i */
public final class C41726i extends JSONObject implements C17868c {
    private final C17868c eIE;

    /* renamed from: J */
    public final /* synthetic */ C17868c mo33333J(String str, int i) {
        AppMethodBeat.m2504i(117686);
        C41726i K = mo67474K(str, i);
        AppMethodBeat.m2505o(117686);
        return K;
    }

    /* renamed from: c */
    public final /* synthetic */ C17868c mo33334c(String str, double d) {
        AppMethodBeat.m2504i(117687);
        C41726i d2 = m73460d(str, d);
        AppMethodBeat.m2505o(117687);
        return d2;
    }

    /* renamed from: e */
    public final /* synthetic */ C17868c mo33335e(String str, Object obj) {
        AppMethodBeat.m2504i(117684);
        C41726i g = mo67475g(str, obj);
        AppMethodBeat.m2505o(117684);
        return g;
    }

    /* renamed from: f */
    public final /* synthetic */ C17868c mo33336f(String str, Object obj) {
        AppMethodBeat.m2504i(117683);
        C41726i h = m73461h(str, obj);
        AppMethodBeat.m2505o(117683);
        return h;
    }

    public final /* synthetic */ JSONArray getJSONArray(String str) {
        AppMethodBeat.m2504i(117672);
        C17869f lz = m73465lz(str);
        AppMethodBeat.m2505o(117672);
        return lz;
    }

    public final /* synthetic */ JSONObject getJSONObject(String str) {
        AppMethodBeat.m2504i(117670);
        C41726i lB = mo67478lB(str);
        AppMethodBeat.m2505o(117670);
        return lB;
    }

    /* renamed from: k */
    public final /* synthetic */ C17868c mo33345k(String str, long j) {
        AppMethodBeat.m2504i(117685);
        C41726i l = m73462l(str, j);
        AppMethodBeat.m2505o(117685);
        return l;
    }

    /* renamed from: ls */
    public final /* synthetic */ C41723a mo33349ls(String str) {
        AppMethodBeat.m2504i(117682);
        C17869f lz = m73465lz(str);
        AppMethodBeat.m2505o(117682);
        return lz;
    }

    /* renamed from: lt */
    public final /* synthetic */ C41723a mo33350lt(String str) {
        AppMethodBeat.m2504i(117681);
        C17869f lA = m73463lA(str);
        AppMethodBeat.m2505o(117681);
        return lA;
    }

    /* renamed from: lu */
    public final /* synthetic */ C17868c mo33351lu(String str) {
        AppMethodBeat.m2504i(117680);
        C41726i lB = mo67478lB(str);
        AppMethodBeat.m2505o(117680);
        return lB;
    }

    /* renamed from: lv */
    public final /* synthetic */ C17868c mo33352lv(String str) {
        AppMethodBeat.m2504i(117679);
        C41726i lC = m73464lC(str);
        AppMethodBeat.m2505o(117679);
        return lC;
    }

    public final /* synthetic */ JSONArray optJSONArray(String str) {
        AppMethodBeat.m2504i(117671);
        C17869f lA = m73463lA(str);
        AppMethodBeat.m2505o(117671);
        return lA;
    }

    public final /* synthetic */ JSONObject optJSONObject(String str) {
        AppMethodBeat.m2504i(117669);
        C41726i lC = m73464lC(str);
        AppMethodBeat.m2505o(117669);
        return lC;
    }

    public final /* synthetic */ JSONObject putOpt(String str, Object obj) {
        AppMethodBeat.m2504i(117673);
        C41726i h = m73461h(str, obj);
        AppMethodBeat.m2505o(117673);
        return h;
    }

    /* renamed from: s */
    public final /* synthetic */ C17868c mo33361s(String str, boolean z) {
        AppMethodBeat.m2504i(117688);
        C41726i t = m73466t(str, z);
        AppMethodBeat.m2505o(117688);
        return t;
    }

    public C41726i() {
        AppMethodBeat.m2504i(117631);
        this.eIE = C41725h.m73451QC();
        AppMethodBeat.m2505o(117631);
    }

    public C41726i(C17868c c17868c) {
        AppMethodBeat.m2504i(117632);
        Assert.assertNotNull(c17868c);
        this.eIE = c17868c;
        AppMethodBeat.m2505o(117632);
    }

    public C41726i(Map map) {
        AppMethodBeat.m2504i(117633);
        this.eIE = C41725h.m73455j(map);
        AppMethodBeat.m2505o(117633);
    }

    public C41726i(String str) {
        AppMethodBeat.m2504i(117634);
        this.eIE = C41725h.m73458lx(str);
        AppMethodBeat.m2505o(117634);
    }

    public final int length() {
        AppMethodBeat.m2504i(117635);
        int length = this.eIE.length();
        AppMethodBeat.m2505o(117635);
        return length;
    }

    /* renamed from: t */
    private C41726i m73466t(String str, boolean z) {
        AppMethodBeat.m2504i(117636);
        this.eIE.mo33361s(str, z);
        AppMethodBeat.m2505o(117636);
        return this;
    }

    /* renamed from: d */
    private C41726i m73460d(String str, double d) {
        AppMethodBeat.m2504i(117637);
        this.eIE.mo33334c(mo33348lr(str), d);
        AppMethodBeat.m2505o(117637);
        return this;
    }

    /* renamed from: K */
    public final C41726i mo67474K(String str, int i) {
        AppMethodBeat.m2504i(117638);
        this.eIE.mo33333J(mo33348lr(str), i);
        AppMethodBeat.m2505o(117638);
        return this;
    }

    /* renamed from: l */
    private C41726i m73462l(String str, long j) {
        AppMethodBeat.m2504i(117639);
        this.eIE.mo33345k(mo33348lr(str), j);
        AppMethodBeat.m2505o(117639);
        return this;
    }

    /* renamed from: g */
    public final C41726i mo67475g(String str, Object obj) {
        AppMethodBeat.m2504i(117640);
        Object obj2 = obj;
        while (obj2 instanceof C41726i) {
            obj2 = ((C41726i) obj2).eIE;
        }
        this.eIE.mo33335e(str, obj2);
        AppMethodBeat.m2505o(117640);
        return this;
    }

    /* renamed from: h */
    private C41726i m73461h(String str, Object obj) {
        AppMethodBeat.m2504i(117641);
        this.eIE.mo33336f(str, obj);
        AppMethodBeat.m2505o(117641);
        return this;
    }

    /* renamed from: lr */
    public final String mo33348lr(String str) {
        AppMethodBeat.m2504i(117642);
        String lr = this.eIE.mo33348lr(str);
        AppMethodBeat.m2505o(117642);
        return lr;
    }

    public final Object remove(String str) {
        AppMethodBeat.m2504i(117643);
        Object remove = this.eIE.remove(str);
        AppMethodBeat.m2505o(117643);
        return remove;
    }

    public final boolean isNull(String str) {
        AppMethodBeat.m2504i(117644);
        boolean isNull = this.eIE.isNull(str);
        AppMethodBeat.m2505o(117644);
        return isNull;
    }

    public final boolean has(String str) {
        AppMethodBeat.m2504i(117645);
        boolean has = this.eIE.has(str);
        AppMethodBeat.m2505o(117645);
        return has;
    }

    public final Object get(String str) {
        AppMethodBeat.m2504i(117646);
        Object obj = this.eIE.get(str);
        AppMethodBeat.m2505o(117646);
        return obj;
    }

    public final Object opt(String str) {
        AppMethodBeat.m2504i(117647);
        Object opt = this.eIE.opt(str);
        AppMethodBeat.m2505o(117647);
        return opt;
    }

    public final boolean getBoolean(String str) {
        AppMethodBeat.m2504i(117648);
        boolean z = this.eIE.getBoolean(str);
        AppMethodBeat.m2505o(117648);
        return z;
    }

    public final boolean optBoolean(String str) {
        AppMethodBeat.m2504i(117649);
        boolean optBoolean = this.eIE.optBoolean(str, false);
        AppMethodBeat.m2505o(117649);
        return optBoolean;
    }

    public final boolean optBoolean(String str, boolean z) {
        AppMethodBeat.m2504i(117650);
        boolean optBoolean = this.eIE.optBoolean(str, z);
        AppMethodBeat.m2505o(117650);
        return optBoolean;
    }

    public final double getDouble(String str) {
        AppMethodBeat.m2504i(117651);
        double d = this.eIE.getDouble(str);
        AppMethodBeat.m2505o(117651);
        return d;
    }

    public final double optDouble(String str) {
        AppMethodBeat.m2504i(117652);
        double optDouble = this.eIE.optDouble(str, Double.NaN);
        AppMethodBeat.m2505o(117652);
        return optDouble;
    }

    public final double optDouble(String str, double d) {
        AppMethodBeat.m2504i(117653);
        double optDouble = this.eIE.optDouble(str, d);
        AppMethodBeat.m2505o(117653);
        return optDouble;
    }

    public final int getInt(String str) {
        AppMethodBeat.m2504i(117654);
        int i = this.eIE.getInt(str);
        AppMethodBeat.m2505o(117654);
        return i;
    }

    public final int optInt(String str) {
        AppMethodBeat.m2504i(117655);
        int optInt = this.eIE.optInt(str, 0);
        AppMethodBeat.m2505o(117655);
        return optInt;
    }

    public final int optInt(String str, int i) {
        AppMethodBeat.m2504i(117656);
        int optInt = this.eIE.optInt(str, i);
        AppMethodBeat.m2505o(117656);
        return optInt;
    }

    public final long getLong(String str) {
        AppMethodBeat.m2504i(117657);
        long j = this.eIE.getLong(str);
        AppMethodBeat.m2505o(117657);
        return j;
    }

    public final long optLong(String str) {
        AppMethodBeat.m2504i(117658);
        long optLong = this.eIE.optLong(str, 0);
        AppMethodBeat.m2505o(117658);
        return optLong;
    }

    public final long optLong(String str, long j) {
        AppMethodBeat.m2504i(117659);
        long optLong = this.eIE.optLong(str, j);
        AppMethodBeat.m2505o(117659);
        return optLong;
    }

    public final String getString(String str) {
        AppMethodBeat.m2504i(117660);
        String string = this.eIE.getString(str);
        AppMethodBeat.m2505o(117660);
        return string;
    }

    public final String optString(String str) {
        AppMethodBeat.m2504i(117661);
        String optString = this.eIE.optString(str, "");
        AppMethodBeat.m2505o(117661);
        return optString;
    }

    public final String optString(String str, String str2) {
        AppMethodBeat.m2504i(117662);
        String optString = this.eIE.optString(str);
        AppMethodBeat.m2505o(117662);
        return optString;
    }

    /* renamed from: lz */
    private C17869f m73465lz(String str) {
        AppMethodBeat.m2504i(117663);
        C41723a ls = this.eIE.mo33349ls(str);
        if (ls == null) {
            AppMethodBeat.m2505o(117663);
            return null;
        }
        C17869f c17869f = new C17869f(ls);
        AppMethodBeat.m2505o(117663);
        return c17869f;
    }

    /* renamed from: lA */
    private C17869f m73463lA(String str) {
        AppMethodBeat.m2504i(117664);
        C41723a lt = this.eIE.mo33350lt(str);
        if (lt == null) {
            AppMethodBeat.m2505o(117664);
            return null;
        }
        C17869f c17869f = new C17869f(lt);
        AppMethodBeat.m2505o(117664);
        return c17869f;
    }

    /* renamed from: lB */
    public final C41726i mo67478lB(String str) {
        AppMethodBeat.m2504i(117665);
        C17868c lu = this.eIE.mo33351lu(str);
        if (lu == null) {
            AppMethodBeat.m2505o(117665);
            return null;
        }
        C41726i c41726i = new C41726i(lu);
        AppMethodBeat.m2505o(117665);
        return c41726i;
    }

    /* renamed from: lC */
    private C41726i m73464lC(String str) {
        AppMethodBeat.m2504i(117666);
        C17868c lv = this.eIE.mo33352lv(str);
        if (lv == null) {
            AppMethodBeat.m2505o(117666);
            return null;
        }
        C41726i c41726i = new C41726i(lv);
        AppMethodBeat.m2505o(117666);
        return c41726i;
    }

    public final Iterator<String> keys() {
        AppMethodBeat.m2504i(117667);
        Iterator keys = this.eIE.keys();
        AppMethodBeat.m2505o(117667);
        return keys;
    }

    public final String toString() {
        AppMethodBeat.m2504i(117668);
        String obj = this.eIE.toString();
        AppMethodBeat.m2505o(117668);
        return obj;
    }
}

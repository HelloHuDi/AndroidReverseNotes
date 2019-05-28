package com.tencent.mm.aa;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONObject;

public final class i extends JSONObject implements c {
    private final c eIE;

    public final /* synthetic */ c J(String str, int i) {
        AppMethodBeat.i(117686);
        i K = K(str, i);
        AppMethodBeat.o(117686);
        return K;
    }

    public final /* synthetic */ c c(String str, double d) {
        AppMethodBeat.i(117687);
        i d2 = d(str, d);
        AppMethodBeat.o(117687);
        return d2;
    }

    public final /* synthetic */ c e(String str, Object obj) {
        AppMethodBeat.i(117684);
        i g = g(str, obj);
        AppMethodBeat.o(117684);
        return g;
    }

    public final /* synthetic */ c f(String str, Object obj) {
        AppMethodBeat.i(117683);
        i h = h(str, obj);
        AppMethodBeat.o(117683);
        return h;
    }

    public final /* synthetic */ JSONArray getJSONArray(String str) {
        AppMethodBeat.i(117672);
        f lz = lz(str);
        AppMethodBeat.o(117672);
        return lz;
    }

    public final /* synthetic */ JSONObject getJSONObject(String str) {
        AppMethodBeat.i(117670);
        i lB = lB(str);
        AppMethodBeat.o(117670);
        return lB;
    }

    public final /* synthetic */ c k(String str, long j) {
        AppMethodBeat.i(117685);
        i l = l(str, j);
        AppMethodBeat.o(117685);
        return l;
    }

    public final /* synthetic */ a ls(String str) {
        AppMethodBeat.i(117682);
        f lz = lz(str);
        AppMethodBeat.o(117682);
        return lz;
    }

    public final /* synthetic */ a lt(String str) {
        AppMethodBeat.i(117681);
        f lA = lA(str);
        AppMethodBeat.o(117681);
        return lA;
    }

    public final /* synthetic */ c lu(String str) {
        AppMethodBeat.i(117680);
        i lB = lB(str);
        AppMethodBeat.o(117680);
        return lB;
    }

    public final /* synthetic */ c lv(String str) {
        AppMethodBeat.i(117679);
        i lC = lC(str);
        AppMethodBeat.o(117679);
        return lC;
    }

    public final /* synthetic */ JSONArray optJSONArray(String str) {
        AppMethodBeat.i(117671);
        f lA = lA(str);
        AppMethodBeat.o(117671);
        return lA;
    }

    public final /* synthetic */ JSONObject optJSONObject(String str) {
        AppMethodBeat.i(117669);
        i lC = lC(str);
        AppMethodBeat.o(117669);
        return lC;
    }

    public final /* synthetic */ JSONObject putOpt(String str, Object obj) {
        AppMethodBeat.i(117673);
        i h = h(str, obj);
        AppMethodBeat.o(117673);
        return h;
    }

    public final /* synthetic */ c s(String str, boolean z) {
        AppMethodBeat.i(117688);
        i t = t(str, z);
        AppMethodBeat.o(117688);
        return t;
    }

    public i() {
        AppMethodBeat.i(117631);
        this.eIE = h.QC();
        AppMethodBeat.o(117631);
    }

    public i(c cVar) {
        AppMethodBeat.i(117632);
        Assert.assertNotNull(cVar);
        this.eIE = cVar;
        AppMethodBeat.o(117632);
    }

    public i(Map map) {
        AppMethodBeat.i(117633);
        this.eIE = h.j(map);
        AppMethodBeat.o(117633);
    }

    public i(String str) {
        AppMethodBeat.i(117634);
        this.eIE = h.lx(str);
        AppMethodBeat.o(117634);
    }

    public final int length() {
        AppMethodBeat.i(117635);
        int length = this.eIE.length();
        AppMethodBeat.o(117635);
        return length;
    }

    private i t(String str, boolean z) {
        AppMethodBeat.i(117636);
        this.eIE.s(str, z);
        AppMethodBeat.o(117636);
        return this;
    }

    private i d(String str, double d) {
        AppMethodBeat.i(117637);
        this.eIE.c(lr(str), d);
        AppMethodBeat.o(117637);
        return this;
    }

    public final i K(String str, int i) {
        AppMethodBeat.i(117638);
        this.eIE.J(lr(str), i);
        AppMethodBeat.o(117638);
        return this;
    }

    private i l(String str, long j) {
        AppMethodBeat.i(117639);
        this.eIE.k(lr(str), j);
        AppMethodBeat.o(117639);
        return this;
    }

    public final i g(String str, Object obj) {
        AppMethodBeat.i(117640);
        Object obj2 = obj;
        while (obj2 instanceof i) {
            obj2 = ((i) obj2).eIE;
        }
        this.eIE.e(str, obj2);
        AppMethodBeat.o(117640);
        return this;
    }

    private i h(String str, Object obj) {
        AppMethodBeat.i(117641);
        this.eIE.f(str, obj);
        AppMethodBeat.o(117641);
        return this;
    }

    public final String lr(String str) {
        AppMethodBeat.i(117642);
        String lr = this.eIE.lr(str);
        AppMethodBeat.o(117642);
        return lr;
    }

    public final Object remove(String str) {
        AppMethodBeat.i(117643);
        Object remove = this.eIE.remove(str);
        AppMethodBeat.o(117643);
        return remove;
    }

    public final boolean isNull(String str) {
        AppMethodBeat.i(117644);
        boolean isNull = this.eIE.isNull(str);
        AppMethodBeat.o(117644);
        return isNull;
    }

    public final boolean has(String str) {
        AppMethodBeat.i(117645);
        boolean has = this.eIE.has(str);
        AppMethodBeat.o(117645);
        return has;
    }

    public final Object get(String str) {
        AppMethodBeat.i(117646);
        Object obj = this.eIE.get(str);
        AppMethodBeat.o(117646);
        return obj;
    }

    public final Object opt(String str) {
        AppMethodBeat.i(117647);
        Object opt = this.eIE.opt(str);
        AppMethodBeat.o(117647);
        return opt;
    }

    public final boolean getBoolean(String str) {
        AppMethodBeat.i(117648);
        boolean z = this.eIE.getBoolean(str);
        AppMethodBeat.o(117648);
        return z;
    }

    public final boolean optBoolean(String str) {
        AppMethodBeat.i(117649);
        boolean optBoolean = this.eIE.optBoolean(str, false);
        AppMethodBeat.o(117649);
        return optBoolean;
    }

    public final boolean optBoolean(String str, boolean z) {
        AppMethodBeat.i(117650);
        boolean optBoolean = this.eIE.optBoolean(str, z);
        AppMethodBeat.o(117650);
        return optBoolean;
    }

    public final double getDouble(String str) {
        AppMethodBeat.i(117651);
        double d = this.eIE.getDouble(str);
        AppMethodBeat.o(117651);
        return d;
    }

    public final double optDouble(String str) {
        AppMethodBeat.i(117652);
        double optDouble = this.eIE.optDouble(str, Double.NaN);
        AppMethodBeat.o(117652);
        return optDouble;
    }

    public final double optDouble(String str, double d) {
        AppMethodBeat.i(117653);
        double optDouble = this.eIE.optDouble(str, d);
        AppMethodBeat.o(117653);
        return optDouble;
    }

    public final int getInt(String str) {
        AppMethodBeat.i(117654);
        int i = this.eIE.getInt(str);
        AppMethodBeat.o(117654);
        return i;
    }

    public final int optInt(String str) {
        AppMethodBeat.i(117655);
        int optInt = this.eIE.optInt(str, 0);
        AppMethodBeat.o(117655);
        return optInt;
    }

    public final int optInt(String str, int i) {
        AppMethodBeat.i(117656);
        int optInt = this.eIE.optInt(str, i);
        AppMethodBeat.o(117656);
        return optInt;
    }

    public final long getLong(String str) {
        AppMethodBeat.i(117657);
        long j = this.eIE.getLong(str);
        AppMethodBeat.o(117657);
        return j;
    }

    public final long optLong(String str) {
        AppMethodBeat.i(117658);
        long optLong = this.eIE.optLong(str, 0);
        AppMethodBeat.o(117658);
        return optLong;
    }

    public final long optLong(String str, long j) {
        AppMethodBeat.i(117659);
        long optLong = this.eIE.optLong(str, j);
        AppMethodBeat.o(117659);
        return optLong;
    }

    public final String getString(String str) {
        AppMethodBeat.i(117660);
        String string = this.eIE.getString(str);
        AppMethodBeat.o(117660);
        return string;
    }

    public final String optString(String str) {
        AppMethodBeat.i(117661);
        String optString = this.eIE.optString(str, "");
        AppMethodBeat.o(117661);
        return optString;
    }

    public final String optString(String str, String str2) {
        AppMethodBeat.i(117662);
        String optString = this.eIE.optString(str);
        AppMethodBeat.o(117662);
        return optString;
    }

    private f lz(String str) {
        AppMethodBeat.i(117663);
        a ls = this.eIE.ls(str);
        if (ls == null) {
            AppMethodBeat.o(117663);
            return null;
        }
        f fVar = new f(ls);
        AppMethodBeat.o(117663);
        return fVar;
    }

    private f lA(String str) {
        AppMethodBeat.i(117664);
        a lt = this.eIE.lt(str);
        if (lt == null) {
            AppMethodBeat.o(117664);
            return null;
        }
        f fVar = new f(lt);
        AppMethodBeat.o(117664);
        return fVar;
    }

    public final i lB(String str) {
        AppMethodBeat.i(117665);
        c lu = this.eIE.lu(str);
        if (lu == null) {
            AppMethodBeat.o(117665);
            return null;
        }
        i iVar = new i(lu);
        AppMethodBeat.o(117665);
        return iVar;
    }

    private i lC(String str) {
        AppMethodBeat.i(117666);
        c lv = this.eIE.lv(str);
        if (lv == null) {
            AppMethodBeat.o(117666);
            return null;
        }
        i iVar = new i(lv);
        AppMethodBeat.o(117666);
        return iVar;
    }

    public final Iterator<String> keys() {
        AppMethodBeat.i(117667);
        Iterator keys = this.eIE.keys();
        AppMethodBeat.o(117667);
        return keys;
    }

    public final String toString() {
        AppMethodBeat.i(117668);
        String obj = this.eIE.toString();
        AppMethodBeat.o(117668);
        return obj;
    }
}

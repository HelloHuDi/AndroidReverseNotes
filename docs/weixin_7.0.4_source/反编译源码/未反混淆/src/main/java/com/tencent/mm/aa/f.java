package com.tencent.mm.aa;

import com.tencent.matrix.trace.core.AppMethodBeat;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f extends JSONArray implements a {
    private final a eIA;

    public final /* synthetic */ a av(Object obj) {
        AppMethodBeat.i(117619);
        f aw = aw(obj);
        AppMethodBeat.o(117619);
        return aw;
    }

    public final /* synthetic */ a cb(int i, int i2) {
        AppMethodBeat.i(117616);
        f cc = cc(i, i2);
        AppMethodBeat.o(117616);
        return cc;
    }

    public final /* synthetic */ a cj(boolean z) {
        AppMethodBeat.i(117623);
        f ck = ck(z);
        AppMethodBeat.o(117623);
        return ck;
    }

    public final /* synthetic */ a fb(long j) {
        AppMethodBeat.i(117620);
        f fc = fc(j);
        AppMethodBeat.o(117620);
        return fc;
    }

    public final /* synthetic */ JSONArray getJSONArray(int i) {
        AppMethodBeat.i(117599);
        f jI = jI(i);
        AppMethodBeat.o(117599);
        return jI;
    }

    public final /* synthetic */ JSONObject getJSONObject(int i) {
        AppMethodBeat.i(117597);
        i jK = jK(i);
        AppMethodBeat.o(117597);
        return jK;
    }

    public final /* synthetic */ a jC(int i) {
        AppMethodBeat.i(117621);
        f jH = jH(i);
        AppMethodBeat.o(117621);
        return jH;
    }

    public final /* synthetic */ a jD(int i) {
        AppMethodBeat.i(117613);
        f jI = jI(i);
        AppMethodBeat.o(117613);
        return jI;
    }

    public final /* synthetic */ a jE(int i) {
        AppMethodBeat.i(117612);
        f jJ = jJ(i);
        AppMethodBeat.o(117612);
        return jJ;
    }

    public final /* synthetic */ c jF(int i) {
        AppMethodBeat.i(117611);
        i jK = jK(i);
        AppMethodBeat.o(117611);
        return jK;
    }

    public final /* synthetic */ c jG(int i) {
        AppMethodBeat.i(117610);
        i jL = jL(i);
        AppMethodBeat.o(117610);
        return jL;
    }

    public final /* synthetic */ a o(double d) {
        AppMethodBeat.i(117622);
        f p = p(d);
        AppMethodBeat.o(117622);
        return p;
    }

    public final /* synthetic */ JSONArray optJSONArray(int i) {
        AppMethodBeat.i(117598);
        f jJ = jJ(i);
        AppMethodBeat.o(117598);
        return jJ;
    }

    public final /* synthetic */ JSONObject optJSONObject(int i) {
        AppMethodBeat.i(117596);
        i jL = jL(i);
        AppMethodBeat.o(117596);
        return jL;
    }

    public final /* synthetic */ a q(int i, long j) {
        AppMethodBeat.i(117615);
        f r = r(i, j);
        AppMethodBeat.o(117615);
        return r;
    }

    public final /* synthetic */ a z(int i, boolean z) {
        AppMethodBeat.i(117618);
        f A = A(i, z);
        AppMethodBeat.o(117618);
        return A;
    }

    public f() {
        AppMethodBeat.i(117557);
        this.eIA = h.QD();
        AppMethodBeat.o(117557);
    }

    public f(String str) {
        AppMethodBeat.i(117558);
        this.eIA = h.ly(str);
        AppMethodBeat.o(117558);
    }

    f(a aVar) {
        AppMethodBeat.i(117559);
        Assert.assertNotNull(aVar);
        this.eIA = aVar;
        AppMethodBeat.o(117559);
    }

    public final int length() {
        AppMethodBeat.i(117560);
        int length = this.eIA.length();
        AppMethodBeat.o(117560);
        return length;
    }

    private f ck(boolean z) {
        AppMethodBeat.i(117561);
        this.eIA.cj(z);
        AppMethodBeat.o(117561);
        return this;
    }

    private f p(double d) {
        AppMethodBeat.i(117562);
        this.eIA.o(d);
        AppMethodBeat.o(117562);
        return this;
    }

    private f jH(int i) {
        AppMethodBeat.i(117563);
        this.eIA.jC(i);
        AppMethodBeat.o(117563);
        return this;
    }

    private f fc(long j) {
        AppMethodBeat.i(117564);
        this.eIA.fb(j);
        AppMethodBeat.o(117564);
        return this;
    }

    private f aw(Object obj) {
        AppMethodBeat.i(117565);
        this.eIA.av(obj);
        AppMethodBeat.o(117565);
        return this;
    }

    private f A(int i, boolean z) {
        AppMethodBeat.i(117566);
        this.eIA.z(i, z);
        AppMethodBeat.o(117566);
        return this;
    }

    private f e(int i, double d) {
        AppMethodBeat.i(117567);
        this.eIA.d(i, d);
        AppMethodBeat.o(117567);
        return this;
    }

    private f cc(int i, int i2) {
        AppMethodBeat.i(117568);
        this.eIA.cb(i, i2);
        AppMethodBeat.o(117568);
        return this;
    }

    private f r(int i, long j) {
        AppMethodBeat.i(117569);
        this.eIA.q(i, j);
        AppMethodBeat.o(117569);
        return this;
    }

    private f e(int i, Object obj) {
        AppMethodBeat.i(117570);
        this.eIA.d(i, obj);
        AppMethodBeat.o(117570);
        return this;
    }

    public final boolean isNull(int i) {
        AppMethodBeat.i(117571);
        boolean isNull = this.eIA.isNull(i);
        AppMethodBeat.o(117571);
        return isNull;
    }

    public final Object get(int i) {
        AppMethodBeat.i(117572);
        Object obj = this.eIA.get(i);
        AppMethodBeat.o(117572);
        return obj;
    }

    public final Object opt(int i) {
        AppMethodBeat.i(117573);
        Object opt = this.eIA.opt(i);
        AppMethodBeat.o(117573);
        return opt;
    }

    public final Object remove(int i) {
        AppMethodBeat.i(117574);
        Object remove = this.eIA.remove(i);
        AppMethodBeat.o(117574);
        return remove;
    }

    public final boolean getBoolean(int i) {
        AppMethodBeat.i(117575);
        boolean z = this.eIA.getBoolean(i);
        AppMethodBeat.o(117575);
        return z;
    }

    public final boolean optBoolean(int i) {
        AppMethodBeat.i(117576);
        boolean optBoolean = this.eIA.optBoolean(i);
        AppMethodBeat.o(117576);
        return optBoolean;
    }

    public final boolean optBoolean(int i, boolean z) {
        AppMethodBeat.i(117577);
        boolean optBoolean = this.eIA.optBoolean(i, z);
        AppMethodBeat.o(117577);
        return optBoolean;
    }

    public final double getDouble(int i) {
        AppMethodBeat.i(117578);
        double d = this.eIA.getDouble(i);
        AppMethodBeat.o(117578);
        return d;
    }

    public final double optDouble(int i) {
        AppMethodBeat.i(117579);
        double optDouble = this.eIA.optDouble(i);
        AppMethodBeat.o(117579);
        return optDouble;
    }

    public final double optDouble(int i, double d) {
        AppMethodBeat.i(117580);
        double optDouble = this.eIA.optDouble(i, d);
        AppMethodBeat.o(117580);
        return optDouble;
    }

    public final int getInt(int i) {
        AppMethodBeat.i(117581);
        int i2 = this.eIA.getInt(i);
        AppMethodBeat.o(117581);
        return i2;
    }

    public final int optInt(int i) {
        AppMethodBeat.i(117582);
        int optInt = this.eIA.optInt(i);
        AppMethodBeat.o(117582);
        return optInt;
    }

    public final int optInt(int i, int i2) {
        AppMethodBeat.i(117583);
        int optInt = this.eIA.optInt(i, i2);
        AppMethodBeat.o(117583);
        return optInt;
    }

    public final long getLong(int i) {
        AppMethodBeat.i(117584);
        long j = this.eIA.getLong(i);
        AppMethodBeat.o(117584);
        return j;
    }

    public final long optLong(int i) {
        AppMethodBeat.i(117585);
        long optLong = this.eIA.optLong(i);
        AppMethodBeat.o(117585);
        return optLong;
    }

    public final long optLong(int i, long j) {
        AppMethodBeat.i(117586);
        long optLong = this.eIA.optLong(i, j);
        AppMethodBeat.o(117586);
        return optLong;
    }

    public final String getString(int i) {
        AppMethodBeat.i(117587);
        String string = this.eIA.getString(i);
        AppMethodBeat.o(117587);
        return string;
    }

    public final String optString(int i) {
        AppMethodBeat.i(117588);
        String optString = this.eIA.optString(i);
        AppMethodBeat.o(117588);
        return optString;
    }

    public final String optString(int i, String str) {
        AppMethodBeat.i(117589);
        String optString = this.eIA.optString(i, str);
        AppMethodBeat.o(117589);
        return optString;
    }

    private f jI(int i) {
        AppMethodBeat.i(117590);
        f fVar = new f(this.eIA.jD(i));
        AppMethodBeat.o(117590);
        return fVar;
    }

    private f jJ(int i) {
        AppMethodBeat.i(117591);
        f fVar = new f(this.eIA.jE(i));
        AppMethodBeat.o(117591);
        return fVar;
    }

    private i jK(int i) {
        AppMethodBeat.i(117592);
        i iVar = new i(this.eIA.jF(i));
        AppMethodBeat.o(117592);
        return iVar;
    }

    private i jL(int i) {
        AppMethodBeat.i(117593);
        i iVar = new i(this.eIA.jG(i));
        AppMethodBeat.o(117593);
        return iVar;
    }

    public final String toString() {
        AppMethodBeat.i(117594);
        String aVar = this.eIA.toString();
        AppMethodBeat.o(117594);
        return aVar;
    }

    public final String toString(int i) {
        AppMethodBeat.i(117595);
        String aVar = this.eIA.toString(i);
        AppMethodBeat.o(117595);
        return aVar;
    }
}

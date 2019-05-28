package com.tencent.mm.plugin.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Vector;
import junit.framework.Assert;

public final class d {
    private final HashMap<c, Vector<Integer>> cS = new HashMap();
    private b jEM = null;

    public d(b bVar) {
        AppMethodBeat.i(18328);
        this.jEM = bVar;
        AppMethodBeat.o(18328);
    }

    public final void a(int i, String str, e eVar) {
        AppMethodBeat.i(18329);
        ab.i("MicroMsg.exdevie.IBeaconManager", "advertismentProcess, brand = %s, rssi = %d", null, Integer.valueOf(i));
        if (eVar == null) {
            ab.e("MicroMsg.exdevie.IBeaconManager", "null == aProtocal");
            AppMethodBeat.o(18329);
            return;
        }
        c cVar = new c();
        cVar.jEJ = null;
        cVar.jEK = eVar;
        cVar.cbq = str;
        Vector vector;
        if (this.cS.containsKey(cVar)) {
            vector = (Vector) this.cS.get(cVar);
            vector.add(Integer.valueOf(i));
            if (1 <= vector.size()) {
                try {
                    a(vector, cVar);
                    return;
                } catch (Exception e) {
                    ab.e("MicroMsg.exdevie.IBeaconManager", "calDistance failed!!!, %s", e.getMessage());
                    return;
                } finally {
                    vector.clear();
                    AppMethodBeat.o(18329);
                }
            } else {
                AppMethodBeat.o(18329);
                return;
            }
        }
        vector = new Vector();
        vector.add(Integer.valueOf(i));
        this.cS.put(cVar, vector);
        AppMethodBeat.o(18329);
    }

    private void a(Vector<Integer> vector, c cVar) {
        int i;
        int[] iArr;
        double p;
        double q;
        AppMethodBeat.i(18330);
        ab.i("MicroMsg.exdevie.IBeaconManager", "calDistance");
        int[] iArr2 = new int[vector.size()];
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= iArr2.length) {
                break;
            }
            iArr2[i] = ((Integer) vector.elementAt(i)).intValue();
            i2 = i + 1;
        }
        a aVar = new a(iArr2);
        if (1 == aVar.jEI.length) {
            ab.d("MicroMsg.exdevice.GaussianFilter", "data group length = 1, no need to filter, just return");
            iArr = aVar.jEI;
        } else {
            StringBuilder stringBuilder = new StringBuilder("");
            stringBuilder.append("Data Before GaussianFilter \r\n");
            for (int i3 : aVar.jEI) {
                stringBuilder.append(" " + i3);
            }
            ab.d("MicroMsg.exdevice.GaussianFilter", stringBuilder.toString());
            p = i.p(aVar.jEI);
            q = i.q(aVar.jEI);
            double doubleValue = i.i(0.15d, q).add(new BigDecimal(p)).doubleValue();
            double doubleValue2 = i.i(3.09d, q).add(new BigDecimal(p)).doubleValue();
            ab.d("MicroMsg.exdevice.GaussianFilter", "Mean = " + p + "SD = " + q + "LowerLimit = " + doubleValue + " UpperLimit = " + doubleValue2);
            i = 0;
            int[] iArr3 = new int[aVar.jEI.length];
            i2 = 0;
            while (i2 < aVar.jEI.length) {
                if (((double) aVar.jEI[i2]) >= doubleValue && ((double) aVar.jEI[i2]) <= doubleValue2) {
                    int i4 = i + 1;
                    iArr3[i] = aVar.jEI[i2];
                    i = i4;
                }
                i2++;
            }
            Assert.assertTrue(i != 0);
            iArr2 = new int[i];
            for (i2 = 0; i2 < i; i2++) {
                iArr2[i2] = iArr3[i2];
            }
            stringBuilder = new StringBuilder("");
            stringBuilder.append("Data After GaussianFilter \r\n");
            for (int i32 : iArr2) {
                stringBuilder.append(" " + i32);
            }
            ab.d("MicroMsg.exdevice.GaussianFilter", stringBuilder.toString());
            iArr = iArr2;
        }
        if (iArr == null || iArr.length == 0) {
            NullPointerException nullPointerException = new NullPointerException("null == ret || 0 == ret.length");
            AppMethodBeat.o(18330);
            throw nullPointerException;
        }
        double p2 = i.p(iArr);
        cVar.jEL = new BigDecimal(p2).divide(new BigDecimal(1), 3, 4).doubleValue();
        p = (1.0d * p2) / ((double) cVar.jEK.jEO.jFs);
        if (p < 1.0d) {
            p = Math.pow(p, 10.0d);
        } else {
            p = (Math.pow(p, 9.9476d) * 0.92093d) + 0.54992d;
        }
        ab.i("MicroMsg.exdevie.IBeaconManager", "txPower = %f , rssi = %f,distance = %f", Double.valueOf(q), Double.valueOf(p2), Double.valueOf(p));
        this.jEM.a(p, cVar);
        AppMethodBeat.o(18330);
    }
}

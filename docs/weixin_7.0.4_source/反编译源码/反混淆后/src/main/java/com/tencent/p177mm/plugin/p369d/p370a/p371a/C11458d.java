package com.tencent.p177mm.plugin.p369d.p370a.p371a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Vector;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.d.a.a.d */
public final class C11458d {
    /* renamed from: cS */
    private final HashMap<C11457c, Vector<Integer>> f2901cS = new HashMap();
    private C27698b jEM = null;

    public C11458d(C27698b c27698b) {
        AppMethodBeat.m2504i(18328);
        this.jEM = c27698b;
        AppMethodBeat.m2505o(18328);
    }

    /* renamed from: a */
    public final void mo23189a(int i, String str, C11459e c11459e) {
        AppMethodBeat.m2504i(18329);
        C4990ab.m7417i("MicroMsg.exdevie.IBeaconManager", "advertismentProcess, brand = %s, rssi = %d", null, Integer.valueOf(i));
        if (c11459e == null) {
            C4990ab.m7412e("MicroMsg.exdevie.IBeaconManager", "null == aProtocal");
            AppMethodBeat.m2505o(18329);
            return;
        }
        C11457c c11457c = new C11457c();
        c11457c.jEJ = null;
        c11457c.jEK = c11459e;
        c11457c.cbq = str;
        Vector vector;
        if (this.f2901cS.containsKey(c11457c)) {
            vector = (Vector) this.f2901cS.get(c11457c);
            vector.add(Integer.valueOf(i));
            if (1 <= vector.size()) {
                try {
                    m19212a(vector, c11457c);
                    return;
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.exdevie.IBeaconManager", "calDistance failed!!!, %s", e.getMessage());
                    return;
                } finally {
                    vector.clear();
                    AppMethodBeat.m2505o(18329);
                }
            } else {
                AppMethodBeat.m2505o(18329);
                return;
            }
        }
        vector = new Vector();
        vector.add(Integer.valueOf(i));
        this.f2901cS.put(c11457c, vector);
        AppMethodBeat.m2505o(18329);
    }

    /* renamed from: a */
    private void m19212a(Vector<Integer> vector, C11457c c11457c) {
        int i;
        int[] iArr;
        double p;
        double q;
        AppMethodBeat.m2504i(18330);
        C4990ab.m7416i("MicroMsg.exdevie.IBeaconManager", "calDistance");
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
        C38824a c38824a = new C38824a(iArr2);
        if (1 == c38824a.jEI.length) {
            C4990ab.m7410d("MicroMsg.exdevice.GaussianFilter", "data group length = 1, no need to filter, just return");
            iArr = c38824a.jEI;
        } else {
            StringBuilder stringBuilder = new StringBuilder("");
            stringBuilder.append("Data Before GaussianFilter \r\n");
            for (int i3 : c38824a.jEI) {
                stringBuilder.append(" " + i3);
            }
            C4990ab.m7410d("MicroMsg.exdevice.GaussianFilter", stringBuilder.toString());
            p = C45823i.m84810p(c38824a.jEI);
            q = C45823i.m84811q(c38824a.jEI);
            double doubleValue = C45823i.m84809i(0.15d, q).add(new BigDecimal(p)).doubleValue();
            double doubleValue2 = C45823i.m84809i(3.09d, q).add(new BigDecimal(p)).doubleValue();
            C4990ab.m7410d("MicroMsg.exdevice.GaussianFilter", "Mean = " + p + "SD = " + q + "LowerLimit = " + doubleValue + " UpperLimit = " + doubleValue2);
            i = 0;
            int[] iArr3 = new int[c38824a.jEI.length];
            i2 = 0;
            while (i2 < c38824a.jEI.length) {
                if (((double) c38824a.jEI[i2]) >= doubleValue && ((double) c38824a.jEI[i2]) <= doubleValue2) {
                    int i4 = i + 1;
                    iArr3[i] = c38824a.jEI[i2];
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
            C4990ab.m7410d("MicroMsg.exdevice.GaussianFilter", stringBuilder.toString());
            iArr = iArr2;
        }
        if (iArr == null || iArr.length == 0) {
            NullPointerException nullPointerException = new NullPointerException("null == ret || 0 == ret.length");
            AppMethodBeat.m2505o(18330);
            throw nullPointerException;
        }
        double p2 = C45823i.m84810p(iArr);
        c11457c.jEL = new BigDecimal(p2).divide(new BigDecimal(1), 3, 4).doubleValue();
        p = (1.0d * p2) / ((double) c11457c.jEK.jEO.jFs);
        if (p < 1.0d) {
            p = Math.pow(p, 10.0d);
        } else {
            p = (Math.pow(p, 9.9476d) * 0.92093d) + 0.54992d;
        }
        C4990ab.m7417i("MicroMsg.exdevie.IBeaconManager", "txPower = %f , rssi = %f,distance = %f", Double.valueOf(q), Double.valueOf(p2), Double.valueOf(p));
        this.jEM.mo23192a(p, c11457c);
        AppMethodBeat.m2505o(18330);
    }
}

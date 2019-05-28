package com.tencent.mm.plugin.qqmail.b;

import android.support.v4.widget.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.g;
import com.tencent.mm.sdk.platformtools.ab;
import e.a.a.b;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public final class a extends com.tencent.mm.bt.a {
    String ptn;
    private boolean pto;
    LinkedList<o> ptp = new LinkedList();
    private boolean ptq;

    public a() {
        AppMethodBeat.i(67903);
        AppMethodBeat.o(67903);
    }

    public final /* synthetic */ com.tencent.mm.bt.a parseFrom(byte[] bArr) {
        AppMethodBeat.i(67915);
        a be = be(bArr);
        AppMethodBeat.o(67915);
        return be;
    }

    public final /* synthetic */ com.tencent.mm.bt.a validate() {
        AppMethodBeat.i(67916);
        a ccn = ccn();
        AppMethodBeat.o(67916);
        return ccn;
    }

    public final a Vc(String str) {
        this.ptn = str;
        this.pto = true;
        return this;
    }

    public final a Bo(int i) {
        boolean z = false;
        AppMethodBeat.i(67904);
        if (i < 0 || i >= this.ptp.size()) {
            AppMethodBeat.o(67904);
        } else {
            if (i >= 10) {
                this.ptp.remove(i);
            } else {
                this.ptp.remove(i);
                Iterator it = this.ptp.iterator();
                int i2 = -1;
                int i3 = j.INVALID_ID;
                int i4 = 0;
                while (it.hasNext()) {
                    o oVar = (o) it.next();
                    int i5 = i4 + 1;
                    if (i4 >= 10) {
                        int i6;
                        if (i3 < oVar.pug) {
                            i3 = oVar.pug;
                            i6 = i5;
                        } else {
                            i6 = i2;
                        }
                        i2 = i6;
                        i4 = i5;
                    } else {
                        i4 = i5;
                    }
                }
                if (i2 != -1 && i2 < this.ptp.size()) {
                    try {
                        a((o) this.ptp.remove(i2));
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.AddrBook", e, "size:%d, idx:%d", Integer.valueOf(this.ptp.size()), Integer.valueOf(i2));
                    }
                }
            }
            if (this.ptp.size() > 0) {
                z = true;
            }
            this.ptq = z;
            AppMethodBeat.o(67904);
        }
        return this;
    }

    public final a a(o oVar) {
        o oVar2;
        int i = 0;
        AppMethodBeat.i(67905);
        if (!this.ptq) {
            this.ptq = true;
        }
        Iterator it = this.ptp.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            oVar2 = (o) it.next();
            if (i2 >= 10) {
                if (a(oVar, oVar2)) {
                    break;
                }
            } else if (oVar.pug > oVar2.pug) {
                break;
            }
            i2++;
        }
        if (i2 >= this.ptp.size()) {
            this.ptp.add(oVar);
        } else {
            this.ptp.add(i2, oVar);
            if (i2 < 10 && this.ptp.size() > 10) {
                oVar2 = (o) this.ptp.remove(10);
                it = this.ptp.iterator();
                while (it.hasNext()) {
                    o oVar3 = (o) it.next();
                    if (i >= 10 && a(oVar2, oVar3)) {
                        break;
                    }
                    i++;
                }
                if (i >= this.ptp.size()) {
                    this.ptp.add(oVar2);
                } else {
                    this.ptp.add(i, oVar2);
                }
            }
        }
        AppMethodBeat.o(67905);
        return this;
    }

    private static boolean a(o oVar, o oVar2) {
        AppMethodBeat.i(67906);
        if (oVar == null || oVar2 == null) {
            AppMethodBeat.o(67906);
            return false;
        }
        int compareTo = b(oVar).compareTo(b(oVar2));
        if (compareTo == 0) {
            if (oVar.nJq.compareTo(oVar2.nJq) <= 0) {
                AppMethodBeat.o(67906);
                return true;
            }
            AppMethodBeat.o(67906);
            return false;
        } else if (compareTo < 0) {
            AppMethodBeat.o(67906);
            return true;
        } else {
            AppMethodBeat.o(67906);
            return false;
        }
    }

    public static String b(o oVar) {
        AppMethodBeat.i(67907);
        String str = oVar.puh;
        if (str == null || "".equals(str)) {
            str = Vd(g.vo(oVar.name.trim()).toLowerCase());
        } else {
            str = Vd(str);
        }
        oVar.puh = str;
        AppMethodBeat.o(67907);
        return str;
    }

    public static String Vd(String str) {
        AppMethodBeat.i(67908);
        if (str == null || str.length() <= 0) {
            ab.d("MicroMsg.getAdjustFullSpell", "%s", "srcName is null or empty, adjust full spell = ~");
            str = "~";
            AppMethodBeat.o(67908);
            return str;
        }
        char[] toCharArray = str.toCharArray();
        int i = 0;
        while (i < toCharArray.length) {
            char c = toCharArray[i];
            if (c >= '0' && c <= '9') {
                str = String.format("{%c%s", new Object[]{Character.valueOf(c), str});
                AppMethodBeat.o(67908);
                return str;
            } else if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
                if (c != '{' || i != 0 || toCharArray.length <= 1 || toCharArray[i + 1] < '0' || toCharArray[i + 1] > '9') {
                    i++;
                } else {
                    AppMethodBeat.o(67908);
                    return str;
                }
            } else if (i == 0) {
                AppMethodBeat.o(67908);
                return str;
            } else {
                str = String.format("%c%s", new Object[]{Character.valueOf(c), str});
                AppMethodBeat.o(67908);
                return str;
            }
        }
        ab.d("MicroMsg.getAdjustFullSpell", "%s is not ok, return '~'", str);
        str = "~";
        AppMethodBeat.o(67908);
        return str;
    }

    public final String toString() {
        AppMethodBeat.i(67909);
        String str = ((("" + getClass().getName() + "(") + "syncInfo = " + this.ptn + "   ") + "addrs = " + this.ptp + "   ") + ")";
        AppMethodBeat.o(67909);
        return str;
    }

    private a ccn() {
        AppMethodBeat.i(67910);
        if (this.pto) {
            AppMethodBeat.o(67910);
            return this;
        }
        b bVar = new b("Not all required fields were included (false = not included in message),  syncInfo:" + this.pto);
        AppMethodBeat.o(67910);
        throw bVar;
    }

    public final int computeSize() {
        AppMethodBeat.i(67911);
        int f = (e.a.a.b.b.a.f(1, this.ptn) + 0) + (e.a.a.a.c(2, 8, this.ptp) + 0);
        AppMethodBeat.o(67911);
        return f;
    }

    public final byte[] toByteArray() {
        AppMethodBeat.i(67912);
        ccn();
        byte[] toByteArray = super.toByteArray();
        AppMethodBeat.o(67912);
        return toByteArray;
    }

    public final void writeFields(e.a.a.c.a aVar) {
        AppMethodBeat.i(67913);
        aVar.e(1, this.ptn);
        aVar.e(2, 8, this.ptp);
        AppMethodBeat.o(67913);
    }

    public final a be(byte[] bArr) {
        AppMethodBeat.i(67914);
        e.a.a.a.a aVar = new e.a.a.a.a(bArr, unknownTagHandler);
        for (int nextFieldNumber = com.tencent.mm.bt.a.getNextFieldNumber(aVar); nextFieldNumber > 0; nextFieldNumber = com.tencent.mm.bt.a.getNextFieldNumber(aVar)) {
            boolean z;
            switch (nextFieldNumber) {
                case 1:
                    Vc(aVar.BTU.readString());
                    z = true;
                    break;
                case 2:
                    int i;
                    LinkedList Vh = aVar.Vh(2);
                    for (i = 0; i < Vh.size(); i++) {
                        byte[] bArr2 = (byte[]) Vh.get(i);
                        o oVar = new o();
                        e.a.a.a.a aVar2 = new e.a.a.a.a(bArr2, unknownTagHandler);
                        for (z = true; z; z = oVar.populateBuilderWithField(aVar2, oVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar2))) {
                        }
                        if (!this.ptq) {
                            this.ptq = true;
                        }
                        this.ptp.add(oVar);
                    }
                    o[] oVarArr = (o[]) this.ptp.toArray(new o[1]);
                    Arrays.sort(oVarArr, new Comparator<o>() {
                        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                            return ((o) obj2).pug - ((o) obj).pug;
                        }
                    });
                    if (10 <= oVarArr.length) {
                        Arrays.sort(oVarArr, 10, oVarArr.length, new Comparator<o>() {
                            public final /* synthetic */ int compare(Object obj, Object obj2) {
                                AppMethodBeat.i(67902);
                                o oVar = (o) obj;
                                o oVar2 = (o) obj2;
                                int compareTo = a.b(oVar).compareTo(a.b(oVar2));
                                if (compareTo == 0) {
                                    compareTo = oVar.nJq.compareTo(oVar2.nJq);
                                    AppMethodBeat.o(67902);
                                    return compareTo;
                                }
                                AppMethodBeat.o(67902);
                                return compareTo;
                            }
                        });
                    }
                    this.ptp.clear();
                    for (Object add : oVarArr) {
                        this.ptp.add(add);
                    }
                    z = true;
                    break;
                default:
                    z = false;
                    break;
            }
            if (!z) {
                aVar.ems();
            }
        }
        a ccn = ccn();
        AppMethodBeat.o(67914);
        return ccn;
    }
}

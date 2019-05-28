package com.tencent.p177mm.plugin.qqmail.p486b;

import android.support.p057v4.widget.C8415j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.platformtools.C9790g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.qqmail.b.a */
public final class C12876a extends C1331a {
    String ptn;
    private boolean pto;
    LinkedList<C43404o> ptp = new LinkedList();
    private boolean ptq;

    /* renamed from: com.tencent.mm.plugin.qqmail.b.a$2 */
    class C128772 implements Comparator<C43404o> {
        C128772() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            AppMethodBeat.m2504i(67902);
            C43404o c43404o = (C43404o) obj;
            C43404o c43404o2 = (C43404o) obj2;
            int compareTo = C12876a.m20872b(c43404o).compareTo(C12876a.m20872b(c43404o2));
            if (compareTo == 0) {
                compareTo = c43404o.nJq.compareTo(c43404o2.nJq);
                AppMethodBeat.m2505o(67902);
                return compareTo;
            }
            AppMethodBeat.m2505o(67902);
            return compareTo;
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.b.a$1 */
    class C128781 implements Comparator<C43404o> {
        C128781() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((C43404o) obj2).pug - ((C43404o) obj).pug;
        }
    }

    public C12876a() {
        AppMethodBeat.m2504i(67903);
        AppMethodBeat.m2505o(67903);
    }

    public final /* synthetic */ C1331a parseFrom(byte[] bArr) {
        AppMethodBeat.m2504i(67915);
        C12876a be = mo24905be(bArr);
        AppMethodBeat.m2505o(67915);
        return be;
    }

    public final /* synthetic */ C1331a validate() {
        AppMethodBeat.m2504i(67916);
        C12876a ccn = ccn();
        AppMethodBeat.m2505o(67916);
        return ccn;
    }

    /* renamed from: Vc */
    public final C12876a mo24903Vc(String str) {
        this.ptn = str;
        this.pto = true;
        return this;
    }

    /* renamed from: Bo */
    public final C12876a mo24902Bo(int i) {
        boolean z = false;
        AppMethodBeat.m2504i(67904);
        if (i < 0 || i >= this.ptp.size()) {
            AppMethodBeat.m2505o(67904);
        } else {
            if (i >= 10) {
                this.ptp.remove(i);
            } else {
                this.ptp.remove(i);
                Iterator it = this.ptp.iterator();
                int i2 = -1;
                int i3 = C8415j.INVALID_ID;
                int i4 = 0;
                while (it.hasNext()) {
                    C43404o c43404o = (C43404o) it.next();
                    int i5 = i4 + 1;
                    if (i4 >= 10) {
                        int i6;
                        if (i3 < c43404o.pug) {
                            i3 = c43404o.pug;
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
                        mo24904a((C43404o) this.ptp.remove(i2));
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.AddrBook", e, "size:%d, idx:%d", Integer.valueOf(this.ptp.size()), Integer.valueOf(i2));
                    }
                }
            }
            if (this.ptp.size() > 0) {
                z = true;
            }
            this.ptq = z;
            AppMethodBeat.m2505o(67904);
        }
        return this;
    }

    /* renamed from: a */
    public final C12876a mo24904a(C43404o c43404o) {
        C43404o c43404o2;
        int i = 0;
        AppMethodBeat.m2504i(67905);
        if (!this.ptq) {
            this.ptq = true;
        }
        Iterator it = this.ptp.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            c43404o2 = (C43404o) it.next();
            if (i2 >= 10) {
                if (C12876a.m20871a(c43404o, c43404o2)) {
                    break;
                }
            } else if (c43404o.pug > c43404o2.pug) {
                break;
            }
            i2++;
        }
        if (i2 >= this.ptp.size()) {
            this.ptp.add(c43404o);
        } else {
            this.ptp.add(i2, c43404o);
            if (i2 < 10 && this.ptp.size() > 10) {
                c43404o2 = (C43404o) this.ptp.remove(10);
                it = this.ptp.iterator();
                while (it.hasNext()) {
                    C43404o c43404o3 = (C43404o) it.next();
                    if (i >= 10 && C12876a.m20871a(c43404o2, c43404o3)) {
                        break;
                    }
                    i++;
                }
                if (i >= this.ptp.size()) {
                    this.ptp.add(c43404o2);
                } else {
                    this.ptp.add(i, c43404o2);
                }
            }
        }
        AppMethodBeat.m2505o(67905);
        return this;
    }

    /* renamed from: a */
    private static boolean m20871a(C43404o c43404o, C43404o c43404o2) {
        AppMethodBeat.m2504i(67906);
        if (c43404o == null || c43404o2 == null) {
            AppMethodBeat.m2505o(67906);
            return false;
        }
        int compareTo = C12876a.m20872b(c43404o).compareTo(C12876a.m20872b(c43404o2));
        if (compareTo == 0) {
            if (c43404o.nJq.compareTo(c43404o2.nJq) <= 0) {
                AppMethodBeat.m2505o(67906);
                return true;
            }
            AppMethodBeat.m2505o(67906);
            return false;
        } else if (compareTo < 0) {
            AppMethodBeat.m2505o(67906);
            return true;
        } else {
            AppMethodBeat.m2505o(67906);
            return false;
        }
    }

    /* renamed from: b */
    public static String m20872b(C43404o c43404o) {
        AppMethodBeat.m2504i(67907);
        String str = c43404o.puh;
        if (str == null || "".equals(str)) {
            str = C12876a.m20870Vd(C9790g.m17432vo(c43404o.name.trim()).toLowerCase());
        } else {
            str = C12876a.m20870Vd(str);
        }
        c43404o.puh = str;
        AppMethodBeat.m2505o(67907);
        return str;
    }

    /* renamed from: Vd */
    public static String m20870Vd(String str) {
        AppMethodBeat.m2504i(67908);
        if (str == null || str.length() <= 0) {
            C4990ab.m7411d("MicroMsg.getAdjustFullSpell", "%s", "srcName is null or empty, adjust full spell = ~");
            str = "~";
            AppMethodBeat.m2505o(67908);
            return str;
        }
        char[] toCharArray = str.toCharArray();
        int i = 0;
        while (i < toCharArray.length) {
            char c = toCharArray[i];
            if (c >= '0' && c <= '9') {
                str = String.format("{%c%s", new Object[]{Character.valueOf(c), str});
                AppMethodBeat.m2505o(67908);
                return str;
            } else if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
                if (c != '{' || i != 0 || toCharArray.length <= 1 || toCharArray[i + 1] < '0' || toCharArray[i + 1] > '9') {
                    i++;
                } else {
                    AppMethodBeat.m2505o(67908);
                    return str;
                }
            } else if (i == 0) {
                AppMethodBeat.m2505o(67908);
                return str;
            } else {
                str = String.format("%c%s", new Object[]{Character.valueOf(c), str});
                AppMethodBeat.m2505o(67908);
                return str;
            }
        }
        C4990ab.m7411d("MicroMsg.getAdjustFullSpell", "%s is not ok, return '~'", str);
        str = "~";
        AppMethodBeat.m2505o(67908);
        return str;
    }

    public final String toString() {
        AppMethodBeat.m2504i(67909);
        String str = ((("" + getClass().getName() + "(") + "syncInfo = " + this.ptn + "   ") + "addrs = " + this.ptp + "   ") + ")";
        AppMethodBeat.m2505o(67909);
        return str;
    }

    private C12876a ccn() {
        AppMethodBeat.m2504i(67910);
        if (this.pto) {
            AppMethodBeat.m2505o(67910);
            return this;
        }
        C6092b c6092b = new C6092b("Not all required fields were included (false = not included in message),  syncInfo:" + this.pto);
        AppMethodBeat.m2505o(67910);
        throw c6092b;
    }

    public final int computeSize() {
        AppMethodBeat.m2504i(67911);
        int f = (C6091a.m9575f(1, this.ptn) + 0) + (C6087a.m9552c(2, 8, this.ptp) + 0);
        AppMethodBeat.m2505o(67911);
        return f;
    }

    public final byte[] toByteArray() {
        AppMethodBeat.m2504i(67912);
        ccn();
        byte[] toByteArray = super.toByteArray();
        AppMethodBeat.m2505o(67912);
        return toByteArray;
    }

    public final void writeFields(C6093a c6093a) {
        AppMethodBeat.m2504i(67913);
        c6093a.mo13475e(1, this.ptn);
        c6093a.mo13474e(2, 8, this.ptp);
        AppMethodBeat.m2505o(67913);
    }

    /* renamed from: be */
    public final C12876a mo24905be(byte[] bArr) {
        AppMethodBeat.m2504i(67914);
        C6086a c6086a = new C6086a(bArr, unknownTagHandler);
        for (int nextFieldNumber = C1331a.getNextFieldNumber(c6086a); nextFieldNumber > 0; nextFieldNumber = C1331a.getNextFieldNumber(c6086a)) {
            boolean z;
            switch (nextFieldNumber) {
                case 1:
                    mo24903Vc(c6086a.BTU.readString());
                    z = true;
                    break;
                case 2:
                    int i;
                    LinkedList Vh = c6086a.mo13445Vh(2);
                    for (i = 0; i < Vh.size(); i++) {
                        byte[] bArr2 = (byte[]) Vh.get(i);
                        C43404o c43404o = new C43404o();
                        C6086a c6086a2 = new C6086a(bArr2, unknownTagHandler);
                        for (z = true; z; z = c43404o.populateBuilderWithField(c6086a2, c43404o, C1331a.getNextFieldNumber(c6086a2))) {
                        }
                        if (!this.ptq) {
                            this.ptq = true;
                        }
                        this.ptp.add(c43404o);
                    }
                    C43404o[] c43404oArr = (C43404o[]) this.ptp.toArray(new C43404o[1]);
                    Arrays.sort(c43404oArr, new C128781());
                    if (10 <= c43404oArr.length) {
                        Arrays.sort(c43404oArr, 10, c43404oArr.length, new C128772());
                    }
                    this.ptp.clear();
                    for (Object add : c43404oArr) {
                        this.ptp.add(add);
                    }
                    z = true;
                    break;
                default:
                    z = false;
                    break;
            }
            if (!z) {
                c6086a.ems();
            }
        }
        C12876a ccn = ccn();
        AppMethodBeat.m2505o(67914);
        return ccn;
    }
}

package navsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C16278i;
import com.tencent.tencentmap.mapsdk.maps.p667a.C24398l;
import com.tencent.tencentmap.mapsdk.maps.p667a.C31070k;
import com.tencent.tencentmap.mapsdk.maps.p667a.C41080n;
import com.tencent.tencentmap.mapsdk.maps.p667a.C46803m;

public final class RttResponse extends C46803m implements Cloneable {
    /* renamed from: a */
    static byte[] f18320a;
    /* renamed from: b */
    static final /* synthetic */ boolean f18321b;
    public byte[] result = null;

    static {
        boolean z;
        AppMethodBeat.m2504i(101143);
        if (RttResponse.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        f18321b = z;
        byte[] bArr = new byte[1];
        f18320a = bArr;
        bArr[0] = (byte) 0;
        AppMethodBeat.m2505o(101143);
    }

    public final String className() {
        return "navsns.RttResponse";
    }

    public final String fullClassName() {
        return "navsns.RttResponse";
    }

    public final byte[] getResult() {
        return this.result;
    }

    public final void setResult(byte[] bArr) {
        this.result = bArr;
    }

    public RttResponse(byte[] bArr) {
        this.result = bArr;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(101136);
        if (obj == null) {
            AppMethodBeat.m2505o(101136);
            return false;
        }
        boolean a = C41080n.m71483a(this.result, ((RttResponse) obj).result);
        AppMethodBeat.m2505o(101136);
        return a;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(101137);
        try {
            Exception exception = new Exception("Need define key first!");
            AppMethodBeat.m2505o(101137);
            throw exception;
        } catch (Exception e) {
            AppMethodBeat.m2505o(101137);
            return 0;
        }
    }

    public final Object clone() {
        AppMethodBeat.m2504i(101138);
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            if (!f18321b) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.m2505o(101138);
                throw assertionError;
            }
        }
        AppMethodBeat.m2505o(101138);
        return obj;
    }

    public final void writeTo(C24398l c24398l) {
        AppMethodBeat.m2504i(101139);
        c24398l.mo40677a(this.result, 0);
        AppMethodBeat.m2505o(101139);
    }

    public final void readFrom(C31070k c31070k) {
        AppMethodBeat.m2504i(101140);
        this.result = c31070k.mo50517a(f18320a, 0, true);
        AppMethodBeat.m2505o(101140);
    }

    public final void display(StringBuilder stringBuilder, int i) {
        AppMethodBeat.m2504i(101141);
        new C16278i(stringBuilder, i).mo29487a(this.result, "result");
        AppMethodBeat.m2505o(101141);
    }

    public final void displaySimple(StringBuilder stringBuilder, int i) {
        AppMethodBeat.m2504i(101142);
        new C16278i(stringBuilder, i).mo29488a(this.result, false);
        AppMethodBeat.m2505o(101142);
    }
}

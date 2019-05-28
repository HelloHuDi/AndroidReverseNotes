package navsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.i;
import com.tencent.tencentmap.mapsdk.maps.a.k;
import com.tencent.tencentmap.mapsdk.maps.a.l;
import com.tencent.tencentmap.mapsdk.maps.a.m;
import com.tencent.tencentmap.mapsdk.maps.a.n;

public final class RttResponse extends m implements Cloneable {
    static byte[] a;
    static final /* synthetic */ boolean b;
    public byte[] result = null;

    static {
        boolean z;
        AppMethodBeat.i(101143);
        if (RttResponse.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        b = z;
        byte[] bArr = new byte[1];
        a = bArr;
        bArr[0] = (byte) 0;
        AppMethodBeat.o(101143);
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
        AppMethodBeat.i(101136);
        if (obj == null) {
            AppMethodBeat.o(101136);
            return false;
        }
        boolean a = n.a(this.result, ((RttResponse) obj).result);
        AppMethodBeat.o(101136);
        return a;
    }

    public final int hashCode() {
        AppMethodBeat.i(101137);
        try {
            Exception exception = new Exception("Need define key first!");
            AppMethodBeat.o(101137);
            throw exception;
        } catch (Exception e) {
            AppMethodBeat.o(101137);
            return 0;
        }
    }

    public final Object clone() {
        AppMethodBeat.i(101138);
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            if (!b) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.o(101138);
                throw assertionError;
            }
        }
        AppMethodBeat.o(101138);
        return obj;
    }

    public final void writeTo(l lVar) {
        AppMethodBeat.i(101139);
        lVar.a(this.result, 0);
        AppMethodBeat.o(101139);
    }

    public final void readFrom(k kVar) {
        AppMethodBeat.i(101140);
        this.result = kVar.a(a, 0, true);
        AppMethodBeat.o(101140);
    }

    public final void display(StringBuilder stringBuilder, int i) {
        AppMethodBeat.i(101141);
        new i(stringBuilder, i).a(this.result, "result");
        AppMethodBeat.o(101141);
    }

    public final void displaySimple(StringBuilder stringBuilder, int i) {
        AppMethodBeat.i(101142);
        new i(stringBuilder, i).a(this.result, false);
        AppMethodBeat.o(101142);
    }
}

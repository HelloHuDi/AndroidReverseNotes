package p690e.p691a.p692a.p693a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import p690e.p691a.p692a.p693a.p694a.C6085b;
import p690e.p691a.p692a.p695b.C6090a;
import p690e.p691a.p692a.p695b.p696a.C6088a;

/* renamed from: e.a.a.a.a */
public final class C6086a {
    public final C6088a BTU;
    public int BTV = 0;
    private final C6085b unknownTagHandler;

    public C6086a(byte[] bArr, C6085b c6085b) {
        AppMethodBeat.m2504i(51865);
        this.BTU = new C6088a(bArr, bArr.length);
        this.unknownTagHandler = c6085b;
        AppMethodBeat.m2505o(51865);
    }

    public final String emq() {
        AppMethodBeat.m2504i(138999);
        String readString = this.BTU.readString();
        AppMethodBeat.m2505o(138999);
        return readString;
    }

    public final boolean emr() {
        AppMethodBeat.m2504i(139000);
        boolean ehX = this.BTU.ehX();
        AppMethodBeat.m2505o(139000);
        return ehX;
    }

    public final void ems() {
        AppMethodBeat.m2504i(51869);
        int fy = C6090a.m9568fy(this.BTV);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FieldNumber: ").append(C6090a.m9569fz(this.BTV)).append(" - ");
        switch (fy) {
            case 0:
                stringBuffer.append("varint (long, int or boolean) value: ").append(this.BTU.mo13459ve());
                break;
            case 1:
                stringBuffer.append("double value: ").append(Double.toString(Double.longBitsToDouble(this.BTU.eib())));
                AppMethodBeat.m2505o(51869);
                return;
            case 2:
                stringBuffer.append("Length delimited (String or ByteString) value: ").append(this.BTU.readString());
                AppMethodBeat.m2505o(51869);
                return;
            case 5:
                stringBuffer.append("float value: ").append(Float.toString(Float.intBitsToFloat(this.BTU.eia())));
                AppMethodBeat.m2505o(51869);
                return;
        }
        AppMethodBeat.m2505o(51869);
    }

    /* renamed from: Vh */
    public final LinkedList<byte[]> mo13445Vh(int i) {
        AppMethodBeat.m2504i(51870);
        LinkedList Vh = this.BTU.mo13450Vh(i);
        AppMethodBeat.m2505o(51870);
        return Vh;
    }

    public final int emp() {
        AppMethodBeat.m2504i(51866);
        int vd = this.BTU.mo13458vd();
        AppMethodBeat.m2505o(51866);
        return vd;
    }
}

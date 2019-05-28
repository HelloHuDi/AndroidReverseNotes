package e.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.a.a.b;
import java.util.LinkedList;

public final class a {
    public final e.a.a.b.a.a BTU;
    public int BTV = 0;
    private final b unknownTagHandler;

    public a(byte[] bArr, b bVar) {
        AppMethodBeat.i(51865);
        this.BTU = new e.a.a.b.a.a(bArr, bArr.length);
        this.unknownTagHandler = bVar;
        AppMethodBeat.o(51865);
    }

    public final String emq() {
        AppMethodBeat.i(138999);
        String readString = this.BTU.readString();
        AppMethodBeat.o(138999);
        return readString;
    }

    public final boolean emr() {
        AppMethodBeat.i(139000);
        boolean ehX = this.BTU.ehX();
        AppMethodBeat.o(139000);
        return ehX;
    }

    public final void ems() {
        AppMethodBeat.i(51869);
        int fy = e.a.a.b.a.fy(this.BTV);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FieldNumber: ").append(e.a.a.b.a.fz(this.BTV)).append(" - ");
        switch (fy) {
            case 0:
                stringBuffer.append("varint (long, int or boolean) value: ").append(this.BTU.ve());
                break;
            case 1:
                stringBuffer.append("double value: ").append(Double.toString(Double.longBitsToDouble(this.BTU.eib())));
                AppMethodBeat.o(51869);
                return;
            case 2:
                stringBuffer.append("Length delimited (String or ByteString) value: ").append(this.BTU.readString());
                AppMethodBeat.o(51869);
                return;
            case 5:
                stringBuffer.append("float value: ").append(Float.toString(Float.intBitsToFloat(this.BTU.eia())));
                AppMethodBeat.o(51869);
                return;
        }
        AppMethodBeat.o(51869);
    }

    public final LinkedList<byte[]> Vh(int i) {
        AppMethodBeat.i(51870);
        LinkedList Vh = this.BTU.Vh(i);
        AppMethodBeat.o(51870);
        return Vh;
    }

    public final int emp() {
        AppMethodBeat.i(51866);
        int vd = this.BTU.vd();
        AppMethodBeat.o(51866);
        return vd;
    }
}

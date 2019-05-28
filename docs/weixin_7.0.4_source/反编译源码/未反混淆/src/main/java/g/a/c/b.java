package g.a.c;

import android.support.v4.widget.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import java.io.InputStream;

public final class b {
    public int Caa;
    public InputStream Cab;
    public int xcZ;

    public final int g(short[] sArr, int i) {
        AppMethodBeat.i(86247);
        short s = sArr[i];
        int i2 = (this.Caa >>> 11) * s;
        if ((this.xcZ ^ j.INVALID_ID) < (j.INVALID_ID ^ i2)) {
            this.Caa = i2;
            sArr[i] = (short) (s + ((2048 - s) >>> 5));
            if ((this.Caa & WebView.NIGHT_MODE_COLOR) == 0) {
                this.xcZ = (this.xcZ << 8) | this.Cab.read();
                this.Caa <<= 8;
            }
            AppMethodBeat.o(86247);
            return 0;
        }
        this.Caa -= i2;
        this.xcZ -= i2;
        sArr[i] = (short) (s - (s >>> 5));
        if ((this.Caa & WebView.NIGHT_MODE_COLOR) == 0) {
            this.xcZ = (this.xcZ << 8) | this.Cab.read();
            this.Caa <<= 8;
        }
        AppMethodBeat.o(86247);
        return 1;
    }

    public static void c(short[] sArr) {
        for (int i = 0; i < sArr.length; i++) {
            sArr[i] = (short) 1024;
        }
    }
}

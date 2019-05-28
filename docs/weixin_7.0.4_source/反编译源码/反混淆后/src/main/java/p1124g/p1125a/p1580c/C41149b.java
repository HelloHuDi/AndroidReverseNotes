package p1124g.p1125a.p1580c;

import android.support.p057v4.widget.C8415j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import java.io.InputStream;

/* renamed from: g.a.c.b */
public final class C41149b {
    public int Caa;
    public InputStream Cab;
    public int xcZ;

    /* renamed from: g */
    public final int mo65730g(short[] sArr, int i) {
        AppMethodBeat.m2504i(86247);
        short s = sArr[i];
        int i2 = (this.Caa >>> 11) * s;
        if ((this.xcZ ^ C8415j.INVALID_ID) < (C8415j.INVALID_ID ^ i2)) {
            this.Caa = i2;
            sArr[i] = (short) (s + ((2048 - s) >>> 5));
            if ((this.Caa & WebView.NIGHT_MODE_COLOR) == 0) {
                this.xcZ = (this.xcZ << 8) | this.Cab.read();
                this.Caa <<= 8;
            }
            AppMethodBeat.m2505o(86247);
            return 0;
        }
        this.Caa -= i2;
        this.xcZ -= i2;
        sArr[i] = (short) (s - (s >>> 5));
        if ((this.Caa & WebView.NIGHT_MODE_COLOR) == 0) {
            this.xcZ = (this.xcZ << 8) | this.Cab.read();
            this.Caa <<= 8;
        }
        AppMethodBeat.m2505o(86247);
        return 1;
    }

    /* renamed from: c */
    public static void m71582c(short[] sArr) {
        for (int i = 0; i < sArr.length; i++) {
            sArr[i] = (short) 1024;
        }
    }
}

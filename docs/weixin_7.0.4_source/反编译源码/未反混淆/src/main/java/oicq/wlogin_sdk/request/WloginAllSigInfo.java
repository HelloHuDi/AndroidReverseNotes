package oicq.wlogin_sdk.request;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.TreeMap;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.util;

public class WloginAllSigInfo implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    public TreeMap<Long, WloginSigInfo> _tk_map = new TreeMap();
    public long _uin = 0;
    public WloginSimpleInfo _useInfo = new WloginSimpleInfo();

    public int put_siginfo(long j, long j2, long j3, long j4, long j5, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7, byte[] bArr8, byte[] bArr9, byte[] bArr10, byte[] bArr11, byte[] bArr12, byte[][] bArr13) {
        AppMethodBeat.i(96438);
        WloginSigInfo wloginSigInfo = (WloginSigInfo) this._tk_map.get(new Long(j));
        if (wloginSigInfo != null) {
            this._tk_map.put(new Long(j), wloginSigInfo.Set(j2, j3, j4, j5, bArr, bArr2, bArr3, bArr4, bArr5, bArr6, bArr7, bArr8, bArr9, bArr10, bArr11, bArr12, bArr13));
        } else {
            this._tk_map.put(new Long(j), new WloginSigInfo(j2, j3, j4, j5, bArr, bArr2, bArr3, bArr4, bArr5, bArr6, bArr7, bArr8, bArr9, bArr10, bArr11, bArr12, bArr13));
        }
        AppMethodBeat.o(96438);
        return 0;
    }

    public WloginAllSigInfo() {
        AppMethodBeat.i(96439);
        AppMethodBeat.o(96439);
    }

    public WloginAllSigInfo get_clone() {
        AppMethodBeat.i(96440);
        try {
            WloginAllSigInfo wloginAllSigInfo = (WloginAllSigInfo) clone();
            AppMethodBeat.o(96440);
            return wloginAllSigInfo;
        } catch (Exception e) {
            util.anG(e.toString());
            AppMethodBeat.o(96440);
            return null;
        }
    }
}

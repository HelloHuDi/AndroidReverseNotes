package a.i.b.a.c.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenAdCanvas;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiCancelDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.p.e;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

public final class w {
    public static final w BrU = new w(false, false, false, false, null, false, null, null, (int) ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_MINIQBFAILED);
    public static final w BrV = new w(false, true, false, false, null, false, null, null, 509);
    public static final w BrW = new w(false, false, false, false, BrU, false, null, null, (int) JsApiOpenAdCanvas.CTRL_INDEX);
    public static final w BrX = new w(false, true, false, false, BrU, false, null, null, (int) JsApiOpenAdCanvas.CTRL_INDEX);
    public static final w BrY = new w(false, false, false, true, BrU, false, null, null, 471);
    public static final w BrZ = new w(false, false, false, true, BrU, false, null, null, 407);
    public static final w Bsa = new w(false, false, true, false, new w(false, false, true, false, BrU, false, null, null, (int) JsApiCancelDownloadTask.CTRL_INDEX), false, null, null, (int) e.CTRL_INDEX);
    public static final a Bsb = new a();
    final boolean BoY;
    final boolean BrM;
    final boolean BrN;
    final boolean BrO;
    final boolean BrP;
    final w BrQ;
    final boolean BrR;
    final w BrS;
    final w BrT;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    w(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, w wVar, boolean z6, w wVar2, w wVar3) {
        this.BrM = z;
        this.BrN = z2;
        this.BoY = z3;
        this.BrO = z4;
        this.BrP = z5;
        this.BrQ = wVar;
        this.BrR = z6;
        this.BrS = wVar2;
        this.BrT = wVar3;
    }

    static {
        AppMethodBeat.i(120328);
        AppMethodBeat.o(120328);
    }
}

package com.tencent.mm.d.a;

import com.eclipsesource.v8.MultiContextV8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class v extends a {
    private MultiContextV8 chm;

    v(String str, byte[] bArr) {
        super(str, bArr);
    }

    static v CD() {
        AppMethodBeat.i(113900);
        v vVar = new v(null, null);
        AppMethodBeat.o(113900);
        return vVar;
    }

    static v k(String str, byte[] bArr) {
        AppMethodBeat.i(113901);
        v vVar = new v(str, bArr);
        AppMethodBeat.o(113901);
        return vVar;
    }

    /* Access modifiers changed, original: final */
    public final MultiContextV8 Co() {
        AppMethodBeat.i(113902);
        this.chm = MultiContextV8.createMultiContextV8(this.chs, this.cht);
        this.cht = null;
        MultiContextV8 multiContextV8 = this.chm;
        AppMethodBeat.o(113902);
        return multiContextV8;
    }

    /* Access modifiers changed, original: 0000 */
    public d Cp() {
        AppMethodBeat.i(113903);
        w CE = w.CE();
        AppMethodBeat.o(113903);
        return CE;
    }

    /* Access modifiers changed, original: final */
    public final void Cq() {
        AppMethodBeat.i(113904);
        try {
            this.chm.release();
            AppMethodBeat.o(113904);
        } catch (Exception e) {
            ab.e("MicroMsg.V8JSRuntime", "commonCleanUp exp = %s", e);
            AppMethodBeat.o(113904);
        }
    }
}

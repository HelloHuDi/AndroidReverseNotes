package com.tencent.magicbrush.handler.glfont;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import com.tencent.magicbrush.a.c.c;
import com.tencent.magicbrush.handler.glfont.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.FloatBuffer;

public final class h implements IMBFontHandler {
    public b bSW;
    private f bTf;
    private d bTg;
    public e bTn;
    private i bTo;
    private boolean bTp = false;

    public final void init(int i, int i2) {
        AppMethodBeat.i(115940);
        c.i("MicroMsg.MBFontManagerImpl", "init() called with: m_atlasWidth = [" + i + "], m_atlasHeight = [" + i2 + "]", new Object[0]);
        this.bTg = new d(i, i2);
        this.bTn = new e(this.bSW);
        this.bTf = new f(this.bTg);
        this.bTo = new i(a.NORMAL);
        AppMethodBeat.o(115940);
    }

    public final String loadFont(String str) {
        String str2 = null;
        AppMethodBeat.i(115941);
        e eVar = this.bTn;
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(115941);
        } else if (eVar.bSW == null) {
            c.i("MicroMsg.MBFont", "[MBFontHandler] FaceProvider is null", new Object[0]);
            AppMethodBeat.o(115941);
        } else {
            String bU = eVar.bSW.bU(str);
            Typeface bT = eVar.bSW.bT(bU);
            if (bT == null) {
                AppMethodBeat.o(115941);
            } else {
                str2 = e.bV(bU);
                if (com.tencent.magicbrush.c.isNullOrNil(str2)) {
                    if (a.yF() != null) {
                        a.yF().fR(0);
                    }
                    str2 = "font" + bT.hashCode();
                }
                c.i("MicroMsg.MBFont", "familyName:".concat(String.valueOf(str2)), new Object[0]);
                eVar.bSV.put(str2, bT);
                AppMethodBeat.o(115941);
            }
        }
        return str2;
    }

    public final void useFont(String str, float f, boolean z, boolean z2) {
        a aVar;
        Typeface create;
        AppMethodBeat.i(115942);
        a i = a.i(z, z2);
        i iVar = this.bTo;
        e eVar = this.bTn;
        if (i == null) {
            aVar = a.NORMAL;
        } else {
            aVar = i;
        }
        if (str == null || str.length() == 0) {
            create = Typeface.create(null, aVar.bTx);
        } else {
            create = (Typeface) eVar.bSV.get(str);
            if (create == null) {
                create = Typeface.create(str, aVar.bTx);
            } else if (create.getStyle() != aVar.bTx) {
                create = Typeface.create(create, aVar.bTx);
            }
        }
        iVar.bTq = create;
        this.bTo.fontSize = f;
        this.bTo.bTs = i;
        AppMethodBeat.o(115942);
    }

    public final void enableStroke(boolean z) {
        this.bTo.bTr = z;
    }

    public final void setStrokeWidth(float f) {
        this.bTo.strokeWidth = f;
    }

    public final FloatBuffer drawText(String str) {
        AppMethodBeat.i(115943);
        this.bTf.a(this.bTo);
        FloatBuffer bW = this.bTf.bW(str);
        if (bW == null) {
            c.i("MicroMsg.MBFontManagerImpl", "drawText() load result is null. atlas may be full. first time, clear and retry; text = [%s]; mCurrentState = [%s]", str, this.bTo);
            clear();
            bW = this.bTf.bW(str);
        }
        if (bW == null) {
            c.i("MicroMsg.MBFontManagerImpl", "drawText() load result is null. atlas may be full. second time, just returned; text = [%s]; mCurrentState = [%s]", str, this.bTo);
            AppMethodBeat.o(115943);
            return null;
        }
        AppMethodBeat.o(115943);
        return bW;
    }

    public final Bitmap getBitmapAtlas() {
        if (this.bTg != null) {
            return this.bTg.bSR;
        }
        return null;
    }

    public final int[] checkAndFlushDirtySignal() {
        AppMethodBeat.i(115944);
        if (this.bTg != null) {
            int i;
            d dVar = this.bTg;
            if (dVar.bST.isEmpty()) {
                i = 0;
            } else {
                i = 1;
            }
            if (i == 0) {
                AppMethodBeat.o(115944);
                return null;
            }
            dVar.bSU[0] = dVar.bST.left;
            dVar.bSU[1] = dVar.bST.top;
            dVar.bSU[2] = dVar.bST.right;
            dVar.bSU[3] = dVar.bST.bottom;
            dVar.bST.setEmpty();
            int[] iArr = dVar.bSU;
            AppMethodBeat.o(115944);
            return iArr;
        }
        AppMethodBeat.o(115944);
        return null;
    }

    public final boolean checkAndFlushClearSignal() {
        boolean z = this.bTp;
        this.bTp = false;
        return z;
    }

    private void clear() {
        AppMethodBeat.i(115945);
        c.i("MicroMsg.MBFontManagerImpl", "FontManager clear", new Object[0]);
        if (this.bTg != null) {
            this.bTg.clear();
        }
        if (this.bTf != null) {
            this.bTf.clear();
        }
        this.bTp = true;
        AppMethodBeat.o(115945);
    }

    public final float measureText(String str) {
        AppMethodBeat.i(115946);
        this.bTf.a(this.bTo);
        float bY = this.bTf.bY(str);
        if (bY == -1.0f) {
            c.i("MicroMsg.MBFontManagerImpl", "measure() load result is null. atlas may be full. first time, clear and retry; text = [%s]; mCurrentState = [%s]", str, this.bTo);
            clear();
            bY = this.bTf.bY(str);
        }
        if (bY == -1.0f) {
            c.i("MicroMsg.MBFontManagerImpl", "measure() load result is null. atlas may be full. second time, just returned; text = [%s]; mCurrentState = [%s]", str, this.bTo);
            AppMethodBeat.o(115946);
            return 0.0f;
        }
        AppMethodBeat.o(115946);
        return bY;
    }

    public final void release() {
        AppMethodBeat.i(115947);
        if (this.bTg != null) {
            d dVar = this.bTg;
            if (dVar.bSR != null) {
                dVar.bSR.recycle();
            }
            this.bTg = null;
        }
        if (this.bTn != null) {
            e eVar = this.bTn;
            if (eVar.bSV != null) {
                eVar.bSV.clear();
                eVar.bSV = null;
            }
            this.bTn = null;
        }
        if (this.bTf != null) {
            f fVar = this.bTf;
            if (fVar.bSX != null) {
                fVar.bSX = null;
            }
            this.bTf = null;
        }
        AppMethodBeat.o(115947);
    }

    public final float getTextLineHeight(String str) {
        AppMethodBeat.i(115948);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(115948);
            return 0.0f;
        } else if (this.bTn == null || this.bTf == null) {
            AppMethodBeat.o(115948);
            return 0.0f;
        } else {
            this.bTf.a(this.bTo);
            g gVar = this.bTf.bSX;
            if (gVar.bTm == null) {
                AppMethodBeat.o(115948);
                return 0.0f;
            }
            float f = (gVar.bTm.descent - gVar.bTm.ascent) + 1.0f;
            AppMethodBeat.o(115948);
            return f;
        }
    }
}

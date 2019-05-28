package com.tencent.magicbrush.handler.glfont;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import com.tencent.magicbrush.C37414c;
import com.tencent.magicbrush.handler.glfont.C32199i.C25716a;
import com.tencent.magicbrush.p1173a.C37412c.C17837c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.FloatBuffer;

/* renamed from: com.tencent.magicbrush.handler.glfont.h */
public final class C6277h implements IMBFontHandler {
    public C45129b bSW;
    private C8882f bTf;
    private C45130d bTg;
    public C1011e bTn;
    private C32199i bTo;
    private boolean bTp = false;

    public final void init(int i, int i2) {
        AppMethodBeat.m2504i(115940);
        C17837c.m27916i("MicroMsg.MBFontManagerImpl", "init() called with: m_atlasWidth = [" + i + "], m_atlasHeight = [" + i2 + "]", new Object[0]);
        this.bTg = new C45130d(i, i2);
        this.bTn = new C1011e(this.bSW);
        this.bTf = new C8882f(this.bTg);
        this.bTo = new C32199i(C25716a.NORMAL);
        AppMethodBeat.m2505o(115940);
    }

    public final String loadFont(String str) {
        String str2 = null;
        AppMethodBeat.m2504i(115941);
        C1011e c1011e = this.bTn;
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(115941);
        } else if (c1011e.bSW == null) {
            C17837c.m27916i("MicroMsg.MBFont", "[MBFontHandler] FaceProvider is null", new Object[0]);
            AppMethodBeat.m2505o(115941);
        } else {
            String bU = c1011e.bSW.mo34440bU(str);
            Typeface bT = c1011e.bSW.mo34439bT(bU);
            if (bT == null) {
                AppMethodBeat.m2505o(115941);
            } else {
                str2 = C1011e.m2280bV(bU);
                if (C37414c.isNullOrNil(str2)) {
                    if (C37416a.m63046yF() != null) {
                        C37416a.m63046yF().mo33012fR(0);
                    }
                    str2 = "font" + bT.hashCode();
                }
                C17837c.m27916i("MicroMsg.MBFont", "familyName:".concat(String.valueOf(str2)), new Object[0]);
                c1011e.bSV.put(str2, bT);
                AppMethodBeat.m2505o(115941);
            }
        }
        return str2;
    }

    public final void useFont(String str, float f, boolean z, boolean z2) {
        C25716a c25716a;
        Typeface create;
        AppMethodBeat.m2504i(115942);
        C25716a i = C25716a.m40809i(z, z2);
        C32199i c32199i = this.bTo;
        C1011e c1011e = this.bTn;
        if (i == null) {
            c25716a = C25716a.NORMAL;
        } else {
            c25716a = i;
        }
        if (str == null || str.length() == 0) {
            create = Typeface.create(null, c25716a.bTx);
        } else {
            create = (Typeface) c1011e.bSV.get(str);
            if (create == null) {
                create = Typeface.create(str, c25716a.bTx);
            } else if (create.getStyle() != c25716a.bTx) {
                create = Typeface.create(create, c25716a.bTx);
            }
        }
        c32199i.bTq = create;
        this.bTo.fontSize = f;
        this.bTo.bTs = i;
        AppMethodBeat.m2505o(115942);
    }

    public final void enableStroke(boolean z) {
        this.bTo.bTr = z;
    }

    public final void setStrokeWidth(float f) {
        this.bTo.strokeWidth = f;
    }

    public final FloatBuffer drawText(String str) {
        AppMethodBeat.m2504i(115943);
        this.bTf.mo20098a(this.bTo);
        FloatBuffer bW = this.bTf.mo20099bW(str);
        if (bW == null) {
            C17837c.m27916i("MicroMsg.MBFontManagerImpl", "drawText() load result is null. atlas may be full. first time, clear and retry; text = [%s]; mCurrentState = [%s]", str, this.bTo);
            clear();
            bW = this.bTf.mo20099bW(str);
        }
        if (bW == null) {
            C17837c.m27916i("MicroMsg.MBFontManagerImpl", "drawText() load result is null. atlas may be full. second time, just returned; text = [%s]; mCurrentState = [%s]", str, this.bTo);
            AppMethodBeat.m2505o(115943);
            return null;
        }
        AppMethodBeat.m2505o(115943);
        return bW;
    }

    public final Bitmap getBitmapAtlas() {
        if (this.bTg != null) {
            return this.bTg.bSR;
        }
        return null;
    }

    public final int[] checkAndFlushDirtySignal() {
        AppMethodBeat.m2504i(115944);
        if (this.bTg != null) {
            int i;
            C45130d c45130d = this.bTg;
            if (c45130d.bST.isEmpty()) {
                i = 0;
            } else {
                i = 1;
            }
            if (i == 0) {
                AppMethodBeat.m2505o(115944);
                return null;
            }
            c45130d.bSU[0] = c45130d.bST.left;
            c45130d.bSU[1] = c45130d.bST.top;
            c45130d.bSU[2] = c45130d.bST.right;
            c45130d.bSU[3] = c45130d.bST.bottom;
            c45130d.bST.setEmpty();
            int[] iArr = c45130d.bSU;
            AppMethodBeat.m2505o(115944);
            return iArr;
        }
        AppMethodBeat.m2505o(115944);
        return null;
    }

    public final boolean checkAndFlushClearSignal() {
        boolean z = this.bTp;
        this.bTp = false;
        return z;
    }

    private void clear() {
        AppMethodBeat.m2504i(115945);
        C17837c.m27916i("MicroMsg.MBFontManagerImpl", "FontManager clear", new Object[0]);
        if (this.bTg != null) {
            this.bTg.clear();
        }
        if (this.bTf != null) {
            this.bTf.clear();
        }
        this.bTp = true;
        AppMethodBeat.m2505o(115945);
    }

    public final float measureText(String str) {
        AppMethodBeat.m2504i(115946);
        this.bTf.mo20098a(this.bTo);
        float bY = this.bTf.mo20100bY(str);
        if (bY == -1.0f) {
            C17837c.m27916i("MicroMsg.MBFontManagerImpl", "measure() load result is null. atlas may be full. first time, clear and retry; text = [%s]; mCurrentState = [%s]", str, this.bTo);
            clear();
            bY = this.bTf.mo20100bY(str);
        }
        if (bY == -1.0f) {
            C17837c.m27916i("MicroMsg.MBFontManagerImpl", "measure() load result is null. atlas may be full. second time, just returned; text = [%s]; mCurrentState = [%s]", str, this.bTo);
            AppMethodBeat.m2505o(115946);
            return 0.0f;
        }
        AppMethodBeat.m2505o(115946);
        return bY;
    }

    public final void release() {
        AppMethodBeat.m2504i(115947);
        if (this.bTg != null) {
            C45130d c45130d = this.bTg;
            if (c45130d.bSR != null) {
                c45130d.bSR.recycle();
            }
            this.bTg = null;
        }
        if (this.bTn != null) {
            C1011e c1011e = this.bTn;
            if (c1011e.bSV != null) {
                c1011e.bSV.clear();
                c1011e.bSV = null;
            }
            this.bTn = null;
        }
        if (this.bTf != null) {
            C8882f c8882f = this.bTf;
            if (c8882f.bSX != null) {
                c8882f.bSX = null;
            }
            this.bTf = null;
        }
        AppMethodBeat.m2505o(115947);
    }

    public final float getTextLineHeight(String str) {
        AppMethodBeat.m2504i(115948);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(115948);
            return 0.0f;
        } else if (this.bTn == null || this.bTf == null) {
            AppMethodBeat.m2505o(115948);
            return 0.0f;
        } else {
            this.bTf.mo20098a(this.bTo);
            C8883g c8883g = this.bTf.bSX;
            if (c8883g.bTm == null) {
                AppMethodBeat.m2505o(115948);
                return 0.0f;
            }
            float f = (c8883g.bTm.descent - c8883g.bTm.ascent) + 1.0f;
            AppMethodBeat.m2505o(115948);
            return f;
        }
    }
}

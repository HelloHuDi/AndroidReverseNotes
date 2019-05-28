package com.tencent.mm.ui.chatting.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ba.n;
import com.tencent.mm.ba.r;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.pluginsdk.ui.e;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.chatting.c.a.a;
import com.tencent.mm.ui.chatting.c.b.c;
import java.util.HashMap;

@a(dFp = c.class)
public class f extends a implements c {
    private static HashMap<String, e> yOG = new HashMap();
    private e pFf = null;
    private Bitmap yOD;
    private ImageView yOE;
    private final k.a yOF = new k.a() {
        public final void a(String str, m mVar) {
            AppMethodBeat.i(31276);
            ab.d("MicroMsg.ChattingUI.ChattingBackgroundComponent", "onBGChange event:%s", str);
            if (str != null && (str.equals(f.this.cgL.getTalkerUserName()) || str.equals("*"))) {
                f.this.cZH();
            }
            AppMethodBeat.o(31276);
        }
    };

    public f() {
        AppMethodBeat.i(31277);
        AppMethodBeat.o(31277);
    }

    public final void cZH() {
        int intValue;
        AppMethodBeat.i(31278);
        com.tencent.mm.ba.a sU = r.aiy().sU(this.cgL.getTalkerUserName());
        if (sU == null) {
            aw.ZK();
            intValue = ((Integer) com.tencent.mm.model.c.Ry().get(12311, Integer.valueOf(-2))).intValue();
        } else {
            intValue = sU.fLV;
        }
        if (intValue == -2) {
            setBackgroundColor(dDI());
            bS(this.cgL.yTx.getContext(), "chatting/purecolor_chat.xml");
            AppMethodBeat.o(31278);
            return;
        }
        r.aix();
        int cb = n.cb(this.cgL.yTx.getContext());
        if (intValue == 0) {
            Object obj;
            switch (cb) {
                case 1:
                case 2:
                case 3:
                case 4:
                    obj = R.drawable.i9;
                    break;
                default:
                    obj = -1;
                    break;
            }
            if (obj != -1) {
                dDH();
                try {
                    this.yOD = BitmapFactory.decodeResource(this.cgL.yTx.getMMResources(), R.drawable.i9);
                } catch (IncompatibleClassChangeError e) {
                    ab.printErrStackTrace("MicroMsg.Crash", e, "May cause dvmFindCatchBlock crash!", new Object[0]);
                    IncompatibleClassChangeError e2 = (IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e2);
                    AppMethodBeat.o(31278);
                    throw e2;
                } catch (Throwable th) {
                }
                if (this.yOD == null) {
                    ab.e("MicroMsg.ChattingUI.ChattingBackgroundComponent", "setBackground decodeFile fail, bm is null, resId = 2130838253");
                    setBackgroundColor(this.cgL.yTx.getMMResources().getColor(R.color.k7));
                } else {
                    if (this.yOE == null) {
                        this.yOE = (ImageView) this.cgL.findViewById(R.id.am2);
                    }
                    if (this.yOE != null) {
                        this.yOE.setImageBitmap(this.yOD);
                    }
                }
                bS(this.cgL.yTx.getContext(), "chatting/reserved_chat.xml");
            }
            AppMethodBeat.o(31278);
            return;
        }
        String str;
        n aix = r.aix();
        if (intValue > 0) {
            bS(this.cgL.yTx.getContext(), "chatting/default_chat.xml");
            switch (cb) {
                case 1:
                    str = aix.cy(intValue, 1) + "horizontal_hdpi.jpg";
                    break;
                case 2:
                    str = aix.cy(intValue, 1) + "horizontal_ldpi.jpg";
                    break;
                case 3:
                    str = aix.cy(intValue, 1) + "vertical_hdpi.jpg";
                    break;
                case 4:
                    str = aix.cy(intValue, 1) + "vertical_ldpi.jpg";
                    break;
                default:
                    str = null;
                    break;
            }
        }
        bS(this.cgL.yTx.getContext(), "chatting/default_chat.xml");
        if (sU == null) {
            str = n.Z("default", cb);
        } else {
            str = n.Z(this.cgL.getTalkerUserName(), cb);
        }
        dDH();
        this.yOD = x.vv(str);
        if (this.yOD == null) {
            ab.e("MicroMsg.ChattingUI.ChattingBackgroundComponent", "setBackground decodeFile fail, bm is null, path = ".concat(String.valueOf(str)));
            setBackgroundColor(dDI());
            AppMethodBeat.o(31278);
            return;
        }
        if (this.yOE == null) {
            this.yOE = (ImageView) this.cgL.findViewById(R.id.am2);
        }
        if (this.yOE != null) {
            this.yOE.setImageBitmap(this.yOD);
        }
        AppMethodBeat.o(31278);
    }

    private void dDH() {
        AppMethodBeat.i(31279);
        if (!(this.yOD == null || this.yOD.isRecycled())) {
            ab.i("MicroMsg.ChattingUI.ChattingBackgroundComponent", "recycle bitmap:%s", this.yOD.toString());
            this.yOD.recycle();
        }
        if (this.yOE != null) {
            this.yOE.setImageBitmap(null);
        }
        AppMethodBeat.o(31279);
    }

    private int dDI() {
        AppMethodBeat.i(31280);
        int color = this.cgL.yTx.getMMResources().getColor(R.color.k7);
        AppMethodBeat.o(31280);
        return color;
    }

    private void setBackgroundColor(int i) {
        AppMethodBeat.i(31281);
        dDH();
        if (this.yOE == null) {
            View findViewById = this.cgL.findViewById(R.id.zd);
            if (findViewById != null) {
                findViewById.setBackgroundColor(i);
            }
            AppMethodBeat.o(31281);
            return;
        }
        this.yOE.setImageDrawable(new ColorDrawable(i));
        AppMethodBeat.o(31281);
    }

    static {
        AppMethodBeat.i(31286);
        AppMethodBeat.o(31286);
    }

    private boolean bS(Context context, String str) {
        AppMethodBeat.i(31282);
        if (yOG.containsKey(str)) {
            this.pFf = (e) yOG.get(str);
            AppMethodBeat.o(31282);
            return true;
        }
        try {
            this.pFf = new e(bo.convertStreamToString(context.getAssets().open(str)));
            yOG.put(str, this.pFf);
            AppMethodBeat.o(31282);
            return true;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.ChattingUI.ChattingBackgroundComponent", e, "", new Object[0]);
            AppMethodBeat.o(31282);
            return false;
        }
    }

    public final e dDJ() {
        return this.pFf;
    }

    public final void dxx() {
    }

    public final void dxy() {
        AppMethodBeat.i(31283);
        ab.i("MicroMsg.ChattingUI.ChattingBackgroundComponent", "[onChattingEnterAnimStart]");
        cZH();
        AppMethodBeat.o(31283);
    }

    public final void dxA() {
    }

    public final void dxB() {
    }

    public final void dxD() {
        AppMethodBeat.i(31285);
        ab.i("MicroMsg.ChattingUI.ChattingBackgroundComponent", "[onChattingExitAnimEnd]");
        if (aw.RK()) {
            r.aiy().d(this.yOF);
            r.aix().d(this.yOF);
        }
        dDH();
        AppMethodBeat.o(31285);
    }

    public final void dxz() {
        AppMethodBeat.i(31284);
        r.aiy().c(this.yOF);
        r.aix().c(this.yOF);
        AppMethodBeat.o(31284);
    }
}

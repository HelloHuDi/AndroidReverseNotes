package com.tencent.p177mm.p612ui.chatting.p616c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.chatting.p616c.p1091a.C15590a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36134c;
import com.tencent.p177mm.p707ba.C37504a;
import com.tencent.p177mm.p707ba.C41787r;
import com.tencent.p177mm.p707ba.C9067n;
import com.tencent.p177mm.platformtools.C18764x;
import com.tencent.p177mm.pluginsdk.p597ui.C14945e;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;

@C15590a(dFp = C36134c.class)
/* renamed from: com.tencent.mm.ui.chatting.c.f */
public class C23755f extends C44291a implements C36134c {
    private static HashMap<String, C14945e> yOG = new HashMap();
    private C14945e pFf = null;
    private Bitmap yOD;
    private ImageView yOE;
    private final C4931a yOF = new C237561();

    /* renamed from: com.tencent.mm.ui.chatting.c.f$1 */
    class C237561 implements C4931a {
        C237561() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(31276);
            C4990ab.m7411d("MicroMsg.ChattingUI.ChattingBackgroundComponent", "onBGChange event:%s", str);
            if (str != null && (str.equals(C23755f.this.cgL.getTalkerUserName()) || str.equals("*"))) {
                C23755f.this.cZH();
            }
            AppMethodBeat.m2505o(31276);
        }
    }

    public C23755f() {
        AppMethodBeat.m2504i(31277);
        AppMethodBeat.m2505o(31277);
    }

    public final void cZH() {
        int intValue;
        AppMethodBeat.m2504i(31278);
        C37504a sU = C41787r.aiy().mo73165sU(this.cgL.getTalkerUserName());
        if (sU == null) {
            C9638aw.m17190ZK();
            intValue = ((Integer) C18628c.m29072Ry().get(12311, Integer.valueOf(-2))).intValue();
        } else {
            intValue = sU.fLV;
        }
        if (intValue == -2) {
            setBackgroundColor(dDI());
            m36619bS(this.cgL.yTx.getContext(), "chatting/purecolor_chat.xml");
            AppMethodBeat.m2505o(31278);
            return;
        }
        C41787r.aix();
        int cb = C9067n.m16439cb(this.cgL.yTx.getContext());
        if (intValue == 0) {
            Object obj;
            switch (cb) {
                case 1:
                case 2:
                case 3:
                case 4:
                    obj = C25738R.drawable.f6562i9;
                    break;
                default:
                    obj = -1;
                    break;
            }
            if (obj != -1) {
                dDH();
                try {
                    this.yOD = BitmapFactory.decodeResource(this.cgL.yTx.getMMResources(), C25738R.drawable.f6562i9);
                } catch (IncompatibleClassChangeError e) {
                    C4990ab.printErrStackTrace("MicroMsg.Crash", e, "May cause dvmFindCatchBlock crash!", new Object[0]);
                    IncompatibleClassChangeError e2 = (IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e2);
                    AppMethodBeat.m2505o(31278);
                    throw e2;
                } catch (Throwable th) {
                }
                if (this.yOD == null) {
                    C4990ab.m7412e("MicroMsg.ChattingUI.ChattingBackgroundComponent", "setBackground decodeFile fail, bm is null, resId = 2130838253");
                    setBackgroundColor(this.cgL.yTx.getMMResources().getColor(C25738R.color.f11874k7));
                } else {
                    if (this.yOE == null) {
                        this.yOE = (ImageView) this.cgL.findViewById(2131822397);
                    }
                    if (this.yOE != null) {
                        this.yOE.setImageBitmap(this.yOD);
                    }
                }
                m36619bS(this.cgL.yTx.getContext(), "chatting/reserved_chat.xml");
            }
            AppMethodBeat.m2505o(31278);
            return;
        }
        String str;
        C9067n aix = C41787r.aix();
        if (intValue > 0) {
            m36619bS(this.cgL.yTx.getContext(), "chatting/default_chat.xml");
            switch (cb) {
                case 1:
                    str = aix.mo20543cy(intValue, 1) + "horizontal_hdpi.jpg";
                    break;
                case 2:
                    str = aix.mo20543cy(intValue, 1) + "horizontal_ldpi.jpg";
                    break;
                case 3:
                    str = aix.mo20543cy(intValue, 1) + "vertical_hdpi.jpg";
                    break;
                case 4:
                    str = aix.mo20543cy(intValue, 1) + "vertical_ldpi.jpg";
                    break;
                default:
                    str = null;
                    break;
            }
        }
        m36619bS(this.cgL.yTx.getContext(), "chatting/default_chat.xml");
        if (sU == null) {
            str = C9067n.m16438Z("default", cb);
        } else {
            str = C9067n.m16438Z(this.cgL.getTalkerUserName(), cb);
        }
        dDH();
        this.yOD = C18764x.m29333vv(str);
        if (this.yOD == null) {
            C4990ab.m7412e("MicroMsg.ChattingUI.ChattingBackgroundComponent", "setBackground decodeFile fail, bm is null, path = ".concat(String.valueOf(str)));
            setBackgroundColor(dDI());
            AppMethodBeat.m2505o(31278);
            return;
        }
        if (this.yOE == null) {
            this.yOE = (ImageView) this.cgL.findViewById(2131822397);
        }
        if (this.yOE != null) {
            this.yOE.setImageBitmap(this.yOD);
        }
        AppMethodBeat.m2505o(31278);
    }

    private void dDH() {
        AppMethodBeat.m2504i(31279);
        if (!(this.yOD == null || this.yOD.isRecycled())) {
            C4990ab.m7417i("MicroMsg.ChattingUI.ChattingBackgroundComponent", "recycle bitmap:%s", this.yOD.toString());
            this.yOD.recycle();
        }
        if (this.yOE != null) {
            this.yOE.setImageBitmap(null);
        }
        AppMethodBeat.m2505o(31279);
    }

    private int dDI() {
        AppMethodBeat.m2504i(31280);
        int color = this.cgL.yTx.getMMResources().getColor(C25738R.color.f11874k7);
        AppMethodBeat.m2505o(31280);
        return color;
    }

    private void setBackgroundColor(int i) {
        AppMethodBeat.m2504i(31281);
        dDH();
        if (this.yOE == null) {
            View findViewById = this.cgL.findViewById(2131821521);
            if (findViewById != null) {
                findViewById.setBackgroundColor(i);
            }
            AppMethodBeat.m2505o(31281);
            return;
        }
        this.yOE.setImageDrawable(new ColorDrawable(i));
        AppMethodBeat.m2505o(31281);
    }

    static {
        AppMethodBeat.m2504i(31286);
        AppMethodBeat.m2505o(31286);
    }

    /* renamed from: bS */
    private boolean m36619bS(Context context, String str) {
        AppMethodBeat.m2504i(31282);
        if (yOG.containsKey(str)) {
            this.pFf = (C14945e) yOG.get(str);
            AppMethodBeat.m2505o(31282);
            return true;
        }
        try {
            this.pFf = new C14945e(C5046bo.convertStreamToString(context.getAssets().open(str)));
            yOG.put(str, this.pFf);
            AppMethodBeat.m2505o(31282);
            return true;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.ChattingUI.ChattingBackgroundComponent", e, "", new Object[0]);
            AppMethodBeat.m2505o(31282);
            return false;
        }
    }

    public final C14945e dDJ() {
        return this.pFf;
    }

    public final void dxx() {
    }

    public final void dxy() {
        AppMethodBeat.m2504i(31283);
        C4990ab.m7416i("MicroMsg.ChattingUI.ChattingBackgroundComponent", "[onChattingEnterAnimStart]");
        cZH();
        AppMethodBeat.m2505o(31283);
    }

    public final void dxA() {
    }

    public final void dxB() {
    }

    public final void dxD() {
        AppMethodBeat.m2504i(31285);
        C4990ab.m7416i("MicroMsg.ChattingUI.ChattingBackgroundComponent", "[onChattingExitAnimEnd]");
        if (C9638aw.m17179RK()) {
            C41787r.aiy().mo10117d(this.yOF);
            C41787r.aix().mo10117d(this.yOF);
        }
        dDH();
        AppMethodBeat.m2505o(31285);
    }

    public final void dxz() {
        AppMethodBeat.m2504i(31284);
        C41787r.aiy().mo10116c(this.yOF);
        C41787r.aix().mo10116c(this.yOF);
        AppMethodBeat.m2505o(31284);
    }
}

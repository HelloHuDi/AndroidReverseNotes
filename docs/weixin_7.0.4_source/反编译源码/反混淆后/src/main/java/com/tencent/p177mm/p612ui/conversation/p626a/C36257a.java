package com.tencent.p177mm.p612ui.conversation.p626a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p201az.C32326l;
import com.tencent.p177mm.pluginsdk.C44070r.C23257a;
import com.tencent.p177mm.pluginsdk.p1080h.p1081a.C14859a;
import com.tencent.p177mm.pluginsdk.p597ui.p1083b.C14933b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.ui.conversation.a.a */
public final class C36257a extends C14933b {
    int aLB = 0;
    private View jAp = null;
    C5475b zvN;
    private C5476d zvO;
    C36256a zvP;

    /* renamed from: com.tencent.mm.ui.conversation.a.a$1 */
    class C158591 implements OnClickListener {
        C158591() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(34628);
            if (!(C36257a.this.zvN == null || C36257a.this.zvP == null)) {
                C36257a.this.zvP.aeT(C36257a.this.zvN.mo11109Pz(C36257a.this.aLB).zvS.f2970id);
            }
            AppMethodBeat.m2505o(34628);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.a.a$2 */
    class C306812 implements OnClickListener {
        C306812() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(34629);
            if (!(C36257a.this.zvN == null || C36257a.this.zvP == null)) {
                C15860c Pz = C36257a.this.zvN.mo11109Pz(C36257a.this.aLB);
                C36257a.this.zvP.mo57130in(Pz.zvS.f2970id, Pz.zvS.url);
            }
            AppMethodBeat.m2505o(34629);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.a.a$a */
    public interface C36256a {
        void aeT(String str);

        /* renamed from: in */
        void mo57130in(String str, String str2);
    }

    /* renamed from: com.tencent.mm.ui.conversation.a.a$3 */
    class C362583 implements C36256a {
        C362583() {
        }

        /* renamed from: in */
        public final void mo57130in(String str, String str2) {
            AppMethodBeat.m2504i(34630);
            C14859a.diD();
            C9638aw.m17190ZK();
            C18628c.m29077XL().mo7920c(new C32326l(2, str));
            C4990ab.m7410d("MicroMsg.ADBanner", "jump to ".concat(String.valueOf(str2)));
            C23257a.vax.mo52971a((Context) C36257a.this.vlu.get(), str2, true);
            AppMethodBeat.m2505o(34630);
        }

        public final void aeT(String str) {
            AppMethodBeat.m2504i(34631);
            C14859a.diD();
            C9638aw.m17190ZK();
            C18628c.m29077XL().mo7920c(new C32326l(3, str));
            AppMethodBeat.m2505o(34631);
        }
    }

    public C36257a(Context context) {
        super(context);
        AppMethodBeat.m2504i(34632);
        if (this.view != null) {
            this.jAp = this.view.findViewById(2131821092);
            this.zvO = new C5476d();
            this.zvO.zvT = this.jAp;
            this.zvO.zvU = (Button) this.view.findViewById(2131821093);
            this.zvO.zvU.setOnClickListener(new C158591());
            this.jAp.setOnClickListener(new C306812());
        }
        AppMethodBeat.m2505o(34632);
    }

    public final int getLayoutId() {
        return 2130968644;
    }

    public final void destroy() {
        AppMethodBeat.m2504i(34633);
        if (C1720g.m3534RN().mo5161QY()) {
            C9638aw.m17190ZK();
            C18628c.m29072Ry().mo10121b(this.zvN);
        }
        AppMethodBeat.m2505o(34633);
    }

    public final void setVisibility(int i) {
        AppMethodBeat.m2504i(34634);
        if (this.jAp != null) {
            this.jAp.setVisibility(i);
        }
        AppMethodBeat.m2505o(34634);
    }

    public final void release() {
        this.zvN = null;
    }

    public final boolean aMN() {
        AppMethodBeat.m2504i(34635);
        this.zvN = new C5475b((Context) this.vlu.get());
        this.zvP = new C362583();
        C14859a fO = C14859a.m23124fO(C4996ah.getContext());
        if (this.zvN != null) {
            if (fO != null) {
                int i;
                this.zvN.zvR = fO;
                this.zvN.mo6869KC();
                if (this.zvN == null || this.zvN.getCount() <= 0 || this.zvN.mo11109Pz(0).mo28098a(this.zvO) != 0) {
                    i = 0;
                } else {
                    i = 1;
                }
                if (i != 0) {
                    C4990ab.m7416i("MicroMsg.ADBanner", "refreshAndReturnIsVisible[true]");
                    setVisibility(0);
                    AppMethodBeat.m2505o(34635);
                    return true;
                }
            }
            setVisibility(8);
        }
        setVisibility(8);
        AppMethodBeat.m2505o(34635);
        return false;
    }
}

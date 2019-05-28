package com.tencent.p177mm.pluginsdk.p597ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.openim.p716b.C32877h;
import com.tencent.p177mm.openim.p716b.C9770o;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.pluginsdk.model.C46498m;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14985g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C7616ad;
import java.util.LinkedList;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.pluginsdk.ui.applet.s */
public final class C23275s implements C1202f {
    String content = "";
    Context context;
    View gub;
    C5653c gud = null;
    LinkedList<Integer> pAT;
    TextView pCu;
    EditText pwu;
    C44275p tipDialog;
    private LinkedList<String> vjJ = new LinkedList();
    String vjK;
    C23280a vlk;
    LinkedList<String> vll;
    boolean vlm = true;
    private boolean vln = false;

    /* renamed from: com.tencent.mm.pluginsdk.ui.applet.s$2 */
    class C232742 implements OnClickListener {

        /* renamed from: com.tencent.mm.pluginsdk.ui.applet.s$2$1 */
        class C72421 implements C5015a {
            C72421() {
            }

            /* renamed from: BI */
            public final boolean mo4499BI() {
                AppMethodBeat.m2504i(79789);
                if (C23275s.this.gub != null) {
                    C23275s c23275s = C23275s.this;
                    String trim = C23275s.this.pwu.getText().toString().trim();
                    Context context = c23275s.context;
                    c23275s.context.getString(C25738R.string.f9238tz);
                    c23275s.tipDialog = C30379h.m48458b(context, c23275s.context.getString(C25738R.string.e3p), true, new C232795());
                    c23275s.content = trim;
                    if (c23275s.vll.size() == 1 && C7616ad.aox((String) c23275s.vll.getFirst())) {
                        c23275s.djH();
                    } else {
                        C1720g.m3535RO().eJo.mo14541a(new C46498m(2, c23275s.vll, c23275s.pAT, trim, ""), 0);
                    }
                }
                AppMethodBeat.m2505o(79789);
                return false;
            }
        }

        C232742() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(79790);
            if (C23275s.this.gud != null) {
                C23275s.this.gud.dismiss();
                C23275s.this.gud = null;
            }
            new C7564ap(new C72421(), false).mo16770ae(500, 500);
            AppMethodBeat.m2505o(79790);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.applet.s$1 */
    class C232761 implements TextWatcher {
        C232761() {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(79788);
            int length = 50 - editable.length();
            if (length < 0) {
                length = 0;
            }
            if (C23275s.this.pCu != null) {
                C23275s.this.pCu.setText(String.valueOf(length));
            }
            AppMethodBeat.m2505o(79788);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.applet.s$3 */
    class C232773 implements OnClickListener {
        C232773() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(79791);
            if (C23275s.this.gud != null) {
                C23275s.this.gud.dismiss();
                C23275s.this.gud = null;
            }
            C23275s.this.onStop();
            if (C23275s.this.vlk != null) {
                C23275s.this.vlk.mo27248bD(false);
            }
            AppMethodBeat.m2505o(79791);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.applet.s$4 */
    class C232784 implements Runnable {
        C232784() {
        }

        public final void run() {
            AppMethodBeat.m2504i(79792);
            if (C23275s.this.context instanceof MMActivity) {
                ((MMActivity) C23275s.this.context).showVKB();
            }
            AppMethodBeat.m2505o(79792);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.applet.s$5 */
    class C232795 implements OnCancelListener {
        C232795() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(79793);
            C23275s.this.onStop();
            if (C23275s.this.vlk != null) {
                C23275s.this.vlk.mo27248bD(false);
            }
            AppMethodBeat.m2505o(79793);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.applet.s$a */
    public interface C23280a {
        /* renamed from: bD */
        void mo27248bD(boolean z);
    }

    public C23275s(Context context, C23280a c23280a) {
        AppMethodBeat.m2504i(79794);
        this.context = context;
        this.vlk = c23280a;
        AppMethodBeat.m2505o(79794);
    }

    /* Access modifiers changed, original: final */
    public final void onStart() {
        AppMethodBeat.m2504i(79795);
        C1720g.m3535RO().eJo.mo14539a(30, (C1202f) this);
        C1720g.m3535RO().eJo.mo14539a(243, (C1202f) this);
        AppMethodBeat.m2505o(79795);
    }

    /* Access modifiers changed, original: final */
    public final void onStop() {
        AppMethodBeat.m2504i(79796);
        C1720g.m3535RO().eJo.mo14546b(30, (C1202f) this);
        C1720g.m3535RO().eJo.mo14546b(243, (C1202f) this);
        if (this.gud != null) {
            this.gud.dismiss();
            this.gud = null;
        }
        AppMethodBeat.m2505o(79796);
    }

    /* renamed from: g */
    public final void mo38981g(LinkedList<String> linkedList, LinkedList<Integer> linkedList2) {
        AppMethodBeat.m2504i(79797);
        mo38979a(linkedList, linkedList2, new LinkedList());
        AppMethodBeat.m2505o(79797);
    }

    /* renamed from: a */
    public final void mo38979a(LinkedList<String> linkedList, LinkedList<Integer> linkedList2, LinkedList<String> linkedList3) {
        boolean z;
        AppMethodBeat.m2504i(79798);
        Assert.assertTrue(linkedList.size() > 0);
        if (linkedList2.size() > 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        onStart();
        this.vll = linkedList;
        this.pAT = linkedList2;
        this.vjJ = linkedList3;
        this.gub = View.inflate(this.context, 2130970617, null);
        String str = "MicroMsg.SendVerifyRequest";
        String str2 = "verifyTip is null: %b, length : %d, value : [%s]";
        Object[] objArr = new Object[3];
        if (this.vjK == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(this.vjK == null ? 0 : this.vjK.length());
        objArr[2] = this.vjK;
        C4990ab.m7417i(str, str2, objArr);
        if (!C5046bo.isNullOrNil(this.vjK)) {
            ((TextView) this.gub.findViewById(2131827352)).setText(this.vjK);
        }
        this.pwu = (EditText) this.gub.findViewById(2131827353);
        this.pCu = (TextView) this.gub.findViewById(2131823129);
        this.pCu.setVisibility(0);
        this.pwu.setText(null);
        this.pCu.setText("50");
        this.pwu.setFilters(C14985g.vuR);
        this.pwu.addTextChangedListener(new C232761());
        this.gud = C30379h.m48436a(this.context, this.context.getString(C25738R.string.e3t), this.gub, new C232742(), new C232773());
        if (this.gud == null) {
            onStop();
        }
        this.pwu.post(new C232784());
        AppMethodBeat.m2505o(79798);
    }

    /* Access modifiers changed, original: final */
    public final void djH() {
        AppMethodBeat.m2504i(79799);
        if (this.vjJ.isEmpty()) {
            this.vln = true;
            C1720g.m3535RO().eJo.mo14539a(881, (C1202f) this);
            C1720g.m3535RO().eJo.mo14541a(new C32877h((String) this.vll.getFirst(), "", ""), 0);
            AppMethodBeat.m2505o(79799);
            return;
        }
        C1720g.m3535RO().eJo.mo14541a(new C9770o((String) this.vll.getFirst(), this.content, (String) this.vjJ.getFirst()), 0);
        AppMethodBeat.m2505o(79799);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(79800);
        if (c1207m.getType() == 881) {
            C1720g.m3535RO().eJo.mo14546b(881, (C1202f) this);
            if (i != 0 || i2 != 0) {
                Toast.makeText(this.context, this.context.getString(C25738R.string.e3n), 1).show();
            } else if (this.vln) {
                C1720g.m3535RO().eJo.mo14541a(new C9770o((String) this.vll.getFirst(), this.content, ((C32877h) c1207m).gfb.vEP), 0);
            }
            this.vln = false;
            AppMethodBeat.m2505o(79800);
        } else if (c1207m.getType() == 30 || c1207m.getType() == 243) {
            C4990ab.m7410d("MicroMsg.SendVerifyRequest", "onSceneEnd, errType = " + i + ", errCode = " + i2);
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            onStop();
            if (i == 0 && i2 == 0) {
                if (this.vlm) {
                    C30379h.m48465bQ(this.context, this.context.getString(C25738R.string.e3o));
                }
                this.vlk.mo27248bD(true);
                AppMethodBeat.m2505o(79800);
                return;
            }
            CharSequence str2;
            if (i == 4 && i2 == -34) {
                str2 = this.context.getString(C25738R.string.bwe);
            } else if (i == 4 && i2 == -94) {
                str2 = this.context.getString(C25738R.string.bwh);
            } else if (!(i == 4 && i2 == -24 && !C5046bo.isNullOrNil(str2)) && (i != 4 || C5046bo.isNullOrNil(str2))) {
                str2 = this.context.getString(C25738R.string.e3n);
            }
            if (this.vlm) {
                Toast.makeText(this.context, str2, 1).show();
            }
            this.vlk.mo27248bD(false);
            AppMethodBeat.m2505o(79800);
        } else {
            C4990ab.m7420w("MicroMsg.SendVerifyRequest", "not expected scene,  type = " + c1207m.getType());
            AppMethodBeat.m2505o(79800);
        }
    }
}

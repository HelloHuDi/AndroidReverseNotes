package com.tencent.p177mm.plugin.account.p275ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p201az.C6332h;
import com.tencent.p177mm.p201az.C6332h.C6333a;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.p629f.p630a.C15885b;
import com.tencent.p177mm.p612ui.p629f.p630a.C30704c;
import com.tencent.p177mm.p612ui.p629f.p630a.C30704c.C30705a;
import com.tencent.p177mm.p612ui.p629f.p630a.C30706e;
import com.tencent.p177mm.plugin.account.friend.p272a.C32967v;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.account.ui.BindFacebookUI */
public class BindFacebookUI extends MMWizardActivity implements C1202f {
    private static final String[] gAu = new String[]{"public_profile"};
    private ProgressDialog gAr;
    private OnCancelListener gAs;
    private C32967v gAt;
    private C30704c gyN;

    /* renamed from: com.tencent.mm.plugin.account.ui.BindFacebookUI$a */
    final class C18865a implements C30705a {
        private C18865a() {
        }

        /* synthetic */ C18865a(BindFacebookUI bindFacebookUI, byte b) {
            this();
        }

        /* renamed from: p */
        public final void mo5794p(Bundle bundle) {
            AppMethodBeat.m2504i(124728);
            C4990ab.m7410d("MicroMsg.BindFacebookUI", "token:" + BindFacebookUI.this.gyN.gqE);
            C1720g.m3536RP().mo5239Ry().set(65830, BindFacebookUI.this.gyN.gqE);
            if (BindFacebookUI.this.gyN.zxC != 0) {
                C1720g.m3536RP().mo5239Ry().set(65832, Long.valueOf(BindFacebookUI.this.gyN.zxC));
            }
            BindFacebookUI.this.gAr = ProgressDialog.show(BindFacebookUI.this, BindFacebookUI.this.getString(C25738R.string.f9238tz), BindFacebookUI.this.getString(C25738R.string.bm0), true);
            BindFacebookUI.this.gAr.setOnCancelListener(BindFacebookUI.this.gAs);
            BindFacebookUI.this.gAt = new C32967v(1, BindFacebookUI.this.gyN.gqE);
            C1720g.m3540Rg().mo14541a(BindFacebookUI.this.gAt, 0);
            BindFacebookUI.m42474do(true);
            AppMethodBeat.m2505o(124728);
        }

        /* renamed from: a */
        public final void mo5792a(C30706e c30706e) {
            AppMethodBeat.m2504i(124729);
            C4990ab.m7410d("MicroMsg.BindFacebookUI", "onFacebookError:" + c30706e.zxP);
            C30379h.m48461b(BindFacebookUI.this, c30706e.getMessage(), BindFacebookUI.this.getString(C25738R.string.avy), true);
            BindFacebookUI.m42474do(false);
            AppMethodBeat.m2505o(124729);
        }

        /* renamed from: a */
        public final void mo5791a(C15885b c15885b) {
            AppMethodBeat.m2504i(124730);
            C4990ab.m7410d("MicroMsg.BindFacebookUI", "onError:" + c15885b.getMessage());
            C30379h.m48461b(BindFacebookUI.this, c15885b.getMessage(), BindFacebookUI.this.getString(C25738R.string.avy), true);
            BindFacebookUI.m42474do(false);
            AppMethodBeat.m2505o(124730);
        }

        public final void onCancel() {
            AppMethodBeat.m2504i(124731);
            C4990ab.m7410d("MicroMsg.BindFacebookUI", "onCancel");
            BindFacebookUI.m42474do(false);
            AppMethodBeat.m2505o(124731);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.BindFacebookUI$1 */
    class C266091 implements OnCancelListener {
        C266091() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(124725);
            if (BindFacebookUI.this.gAt != null) {
                C1720g.m3540Rg().mo14547c(BindFacebookUI.this.gAt);
            }
            AppMethodBeat.m2505o(124725);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.BindFacebookUI$3 */
    class C266103 implements OnClickListener {
        C266103() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(124727);
            BindFacebookUI.this.gyN.mo49070a(BindFacebookUI.this, BindFacebookUI.gAu, new C18865a(BindFacebookUI.this, (byte) 0));
            AppMethodBeat.m2505o(124727);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.BindFacebookUI$2 */
    class C266112 implements OnMenuItemClickListener {
        C266112() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(124726);
            BindFacebookUI.m42471b(BindFacebookUI.this);
            AppMethodBeat.m2505o(124726);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(124732);
        super.onCreate(bundle);
        AppMethodBeat.m2505o(124732);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(124733);
        super.onDestroy();
        AppMethodBeat.m2505o(124733);
    }

    public void onResume() {
        AppMethodBeat.m2504i(124734);
        super.onResume();
        C1720g.m3540Rg().mo14539a(183, (C1202f) this);
        initView();
        AppMethodBeat.m2505o(124734);
    }

    public void onPause() {
        AppMethodBeat.m2504i(124735);
        super.onPause();
        C1720g.m3540Rg().mo14546b(183, (C1202f) this);
        AppMethodBeat.m2505o(124735);
    }

    public final int getLayoutId() {
        return 2130968837;
    }

    public final void initView() {
        AppMethodBeat.m2504i(124736);
        this.gyN = new C30704c(getString(C25738R.string.g7d));
        this.gAs = new C266091();
        addTextOptionMenu(0, getString(C25738R.string.f9154r7), new C266112());
        setMMTitle((int) C25738R.string.a5x);
        TextView textView = (TextView) findViewById(2131821746);
        textView.setVisibility(4);
        textView.setText(C25738R.string.a5w);
        Button button = (Button) findViewById(2131821747);
        button.setVisibility(0);
        button.setOnClickListener(new C266103());
        AppMethodBeat.m2505o(124736);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(124737);
        if (c1207m.getType() != 183) {
            AppMethodBeat.m2505o(124737);
            return;
        }
        if (this.gAr != null) {
            this.gAr.dismiss();
        }
        if (C24679a.gkF.mo38859a(this.mController.ylL, i, i2, str)) {
            AppMethodBeat.m2505o(124737);
            return;
        }
        int i3 = ((C32967v) c1207m).opType;
        if (i == 0 && i2 == 0) {
            if (i3 == 1) {
                ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoX("facebookapp");
                ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15254Rh("facebookapp");
            }
            mo27541Ni(1);
            AppMethodBeat.m2505o(124737);
        } else if (i == 4 && i2 == -67) {
            Toast.makeText(this, C25738R.string.bm3, 1).show();
            AppMethodBeat.m2505o(124737);
        } else if (i == 4 && i2 == -5) {
            Toast.makeText(this, i3 == 1 ? C25738R.string.blx : C25738R.string.bm6, 1).show();
            AppMethodBeat.m2505o(124737);
        } else {
            Toast.makeText(this, i3 == 0 ? C25738R.string.aw3 : C25738R.string.avy, 1).show();
            AppMethodBeat.m2505o(124737);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m42471b(BindFacebookUI bindFacebookUI) {
        AppMethodBeat.m2504i(124738);
        bindFacebookUI.mo27541Ni(1);
        AppMethodBeat.m2505o(124738);
    }

    /* renamed from: do */
    static /* synthetic */ void m42474do(boolean z) {
        AppMethodBeat.m2504i(124739);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C6333a(32, z ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1"));
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C6332h(arrayList));
        AppMethodBeat.m2505o(124739);
    }
}

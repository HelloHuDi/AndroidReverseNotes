package com.tencent.p177mm.p612ui.contact;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p1185bc.C17974c;
import com.tencent.p177mm.p1185bc.C17974c.C17976a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.storage.C7616ad;

/* renamed from: com.tencent.mm.ui.contact.ContactRemarkInfoViewUI */
public class ContactRemarkInfoViewUI extends MMActivity {
    private String bCv;
    private String dul;
    private C7616ad ehM;
    private String fNa;
    private int gwP;
    private String username;
    private TextView zlF;
    private TextView zlG;
    private ImageView zlJ;
    private boolean zlP = false;
    private View zmj;
    private View zmk;

    /* renamed from: com.tencent.mm.ui.contact.ContactRemarkInfoViewUI$1 */
    class C157921 implements OnClickListener {
        C157921() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(33687);
            if (ContactRemarkInfoViewUI.this.zlP) {
                Intent intent = new Intent(ContactRemarkInfoViewUI.this, ContactRemarkImagePreviewUI.class);
                intent.putExtra("Contact_User", ContactRemarkInfoViewUI.this.username);
                C17974c.aiB();
                intent.putExtra("remark_image_path", C17974c.m28282sW(ContactRemarkInfoViewUI.this.username));
                intent.putExtra("view_only", true);
                ContactRemarkInfoViewUI.this.startActivity(intent);
                AppMethodBeat.m2505o(33687);
                return;
            }
            AppMethodBeat.m2505o(33687);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.ContactRemarkInfoViewUI$4 */
    class C362394 implements C17976a {
        C362394() {
        }

        /* renamed from: cP */
        public final void mo11072cP(final boolean z) {
            AppMethodBeat.m2504i(33691);
            ContactRemarkInfoViewUI.this.zlJ.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(33690);
                    if (z) {
                        ContactRemarkInfoViewUI.m59657e(ContactRemarkInfoViewUI.this);
                        AppMethodBeat.m2505o(33690);
                        return;
                    }
                    C30379h.m48465bQ(ContactRemarkInfoViewUI.this, ContactRemarkInfoViewUI.this.getString(C25738R.string.f9111ps));
                    AppMethodBeat.m2505o(33690);
                }
            });
            AppMethodBeat.m2505o(33691);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.ContactRemarkInfoViewUI$3 */
    class C362403 implements OnMenuItemClickListener {
        C362403() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(33689);
            ContactRemarkInfoViewUI.this.finish();
            AppMethodBeat.m2505o(33689);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.ContactRemarkInfoViewUI$2 */
    class C362412 implements OnMenuItemClickListener {
        C362412() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(33688);
            Intent intent = new Intent();
            intent.setClass(ContactRemarkInfoViewUI.this.mController.ylL, ContactRemarkInfoModUI.class);
            intent.putExtra("Contact_Scene", ContactRemarkInfoViewUI.this.gwP);
            intent.putExtra("Contact_User", ContactRemarkInfoViewUI.this.ehM.field_username);
            ContactRemarkInfoViewUI.this.startActivity(intent);
            AppMethodBeat.m2505o(33688);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: e */
    static /* synthetic */ void m59657e(ContactRemarkInfoViewUI contactRemarkInfoViewUI) {
        AppMethodBeat.m2504i(33698);
        contactRemarkInfoViewUI.dHJ();
        AppMethodBeat.m2505o(33698);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(33692);
        super.onCreate(bundle);
        this.gwP = getIntent().getIntExtra("Contact_Scene", 9);
        this.username = getIntent().getStringExtra("Contact_User");
        if (C42252ah.isNullOrNil(this.username)) {
            finish();
            AppMethodBeat.m2505o(33692);
            return;
        }
        m59652Kh();
        initView();
        AppMethodBeat.m2505o(33692);
    }

    public void onResume() {
        AppMethodBeat.m2504i(33693);
        super.onResume();
        m59652Kh();
        this.zlF.setText(C44089j.m79293b((Context) this, C42252ah.nullAsNil(this.bCv), this.zlF.getTextSize()));
        if (C42252ah.isNullOrNil(this.dul)) {
            this.zmj.setVisibility(8);
        } else {
            this.zmj.setVisibility(0);
            this.zlG.setText(C42252ah.nullAsNil(this.dul));
        }
        if (C42252ah.isNullOrNil(this.fNa)) {
            this.zmk.setVisibility(8);
            AppMethodBeat.m2505o(33693);
            return;
        }
        this.zmk.setVisibility(0);
        C17974c.aiB();
        if (C17974c.m28283sX(this.username)) {
            dHJ();
            AppMethodBeat.m2505o(33693);
            return;
        }
        C17974c.aiB().mo33525a(this.username, this.fNa, new C362394());
        AppMethodBeat.m2505o(33693);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(33694);
        super.onDestroy();
        AppMethodBeat.m2505o(33694);
    }

    public final int getLayoutId() {
        return 2130969236;
    }

    /* renamed from: Kh */
    private void m59652Kh() {
        AppMethodBeat.m2504i(33695);
        C9638aw.m17190ZK();
        this.ehM = C18628c.m29078XM().aoO(this.username);
        this.bCv = this.ehM.mo16707Oj();
        this.dul = this.ehM.dul;
        this.fNa = this.ehM.dum;
        AppMethodBeat.m2505o(33695);
    }

    public final void initView() {
        AppMethodBeat.m2504i(33696);
        this.zlF = (TextView) findViewById(2131823120);
        this.zlG = (TextView) findViewById(2131823130);
        this.zlJ = (ImageView) findViewById(2131823133);
        this.zmj = findViewById(2131823134);
        this.zmk = findViewById(2131823135);
        setMMTitle((int) C25738R.string.axx);
        this.zlJ.setOnClickListener(new C157921());
        addTextOptionMenu(0, getString(C25738R.string.f9099pg), new C362412());
        setBackBtn(new C362403());
        AppMethodBeat.m2505o(33696);
    }

    private void dHJ() {
        AppMethodBeat.m2504i(33697);
        C17974c.aiB();
        Bitmap sZ = C17974c.m28285sZ(this.username);
        if (sZ != null) {
            this.zlJ.setImageBitmap(sZ);
            this.zlP = true;
        }
        AppMethodBeat.m2505o(33697);
    }
}

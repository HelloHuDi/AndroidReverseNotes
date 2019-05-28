package com.tencent.p177mm.plugin.account.bind.p271ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l.C38034a;

/* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMContactStatusUI */
public class BindMContactStatusUI extends MMWizardActivity {
    private TextView grA;
    private TextView grB;
    private Button grC;
    private ImageView gri;

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMContactStatusUI$1 */
    class C165661 implements OnClickListener {
        C165661() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(13454);
            BindMContactStatusUI.m25449a(BindMContactStatusUI.this);
            AppMethodBeat.m2505o(13454);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(13455);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.a7a);
        initView();
        AppMethodBeat.m2505o(13455);
    }

    public final int getLayoutId() {
        return 2130968843;
    }

    public final void initView() {
        AppMethodBeat.m2504i(13456);
        this.gri = (ImageView) findViewById(2131821737);
        this.grA = (TextView) findViewById(2131821738);
        this.grB = (TextView) findViewById(2131821768);
        this.grC = (Button) findViewById(2131821740);
        if (C38033l.apS() == C38034a.SUCC) {
            this.gri.setImageResource(C1318a.mobile_binded_icon);
            String str = (String) C1720g.m3536RP().mo5239Ry().get(6, null);
            if (str == null || str.equals("")) {
                str = (String) C1720g.m3536RP().mo5239Ry().get(4097, null);
            }
            this.grB.setText(getString(C25738R.string.a77));
            this.grA.setText(getString(C25738R.string.a7v, new Object[]{str}));
        } else {
            this.gri.setImageResource(C1318a.mobile_unbind_icon);
            this.grB.setText(C25738R.string.a7i);
            this.grA.setText(C25738R.string.a7i);
            this.grB.setVisibility(8);
        }
        this.grC.setOnClickListener(new C165661());
        AppMethodBeat.m2505o(13456);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(13457);
        if (i == 4) {
            mo27541Ni(1);
            AppMethodBeat.m2505o(13457);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(13457);
        return onKeyDown;
    }

    /* renamed from: a */
    static /* synthetic */ void m25449a(BindMContactStatusUI bindMContactStatusUI) {
        AppMethodBeat.m2504i(13458);
        bindMContactStatusUI.mo27541Ni(1);
        AppMethodBeat.m2505o(13458);
    }
}

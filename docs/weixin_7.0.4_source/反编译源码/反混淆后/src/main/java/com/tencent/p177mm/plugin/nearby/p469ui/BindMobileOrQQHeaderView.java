package com.tencent.p177mm.plugin.nearby.p469ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.p1207a.C18608f;
import com.tencent.p177mm.model.p1207a.C26407g;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.plugin.account.bind.p271ui.BindMContactIntroUI;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

/* renamed from: com.tencent.mm.plugin.nearby.ui.BindMobileOrQQHeaderView */
public class BindMobileOrQQHeaderView extends LinearLayout {
    private ImageView iyo;
    private TextView oPI;
    private C12699a oPJ;
    private OnClickListener oPK;

    /* renamed from: com.tencent.mm.plugin.nearby.ui.BindMobileOrQQHeaderView$a */
    public enum C12699a {
        Mobile,
        UploadContact;

        static {
            AppMethodBeat.m2505o(55404);
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearby.ui.BindMobileOrQQHeaderView$1 */
    class C285911 implements OnClickListener {
        C285911() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(55400);
            Intent intent = new Intent();
            intent.setClass(BindMobileOrQQHeaderView.this.getContext(), BindMContactIntroUI.class);
            intent.putExtra("key_upload_scene", 7);
            MMWizardActivity.m23791J(BindMobileOrQQHeaderView.this.getContext(), intent);
            if (C26407g.aaK().mo60654oP(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL) != null) {
                C26407g.aaK().mo60654oP(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL).result = "1";
                C18608f.m29045oU(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
            }
            AppMethodBeat.m2505o(55400);
        }
    }

    public BindMobileOrQQHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(55405);
        this.oPK = new C285911();
        m45409cA(context);
        AppMethodBeat.m2505o(55405);
    }

    public BindMobileOrQQHeaderView(Context context) {
        super(context);
        AppMethodBeat.m2504i(55406);
        this.oPK = new C285911();
        this.oPJ = C12699a.Mobile;
        m45409cA(context);
        AppMethodBeat.m2505o(55406);
    }

    /* renamed from: cA */
    private void m45409cA(Context context) {
        AppMethodBeat.m2504i(55407);
        View inflate = View.inflate(context, 2130970286, this);
        this.oPI = (TextView) inflate.findViewById(2131826295);
        this.iyo = (ImageView) inflate.findViewById(2131826294);
        switch (this.oPJ) {
            case Mobile:
                setOnClickListener(this.oPK);
                this.iyo.setImageResource(C1318a.icons_outlined_cellphone);
                AppMethodBeat.m2505o(55407);
                return;
            case UploadContact:
                setOnClickListener(this.oPK);
                this.iyo.setImageResource(C1318a.icons_outlined_contacts);
                break;
        }
        AppMethodBeat.m2505o(55407);
    }
}

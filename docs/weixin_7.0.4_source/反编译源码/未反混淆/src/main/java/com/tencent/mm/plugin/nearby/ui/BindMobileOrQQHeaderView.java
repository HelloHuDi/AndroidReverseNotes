package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.a.g;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

public class BindMobileOrQQHeaderView extends LinearLayout {
    private ImageView iyo;
    private TextView oPI;
    private a oPJ;
    private OnClickListener oPK;

    public enum a {
        Mobile,
        UploadContact;

        static {
            AppMethodBeat.o(55404);
        }
    }

    public BindMobileOrQQHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(55405);
        this.oPK = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(55400);
                Intent intent = new Intent();
                intent.setClass(BindMobileOrQQHeaderView.this.getContext(), BindMContactIntroUI.class);
                intent.putExtra("key_upload_scene", 7);
                MMWizardActivity.J(BindMobileOrQQHeaderView.this.getContext(), intent);
                if (g.aaK().oP(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL) != null) {
                    g.aaK().oP(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL).result = "1";
                    f.oU(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
                }
                AppMethodBeat.o(55400);
            }
        };
        cA(context);
        AppMethodBeat.o(55405);
    }

    public BindMobileOrQQHeaderView(Context context) {
        super(context);
        AppMethodBeat.i(55406);
        this.oPK = /* anonymous class already generated */;
        this.oPJ = a.Mobile;
        cA(context);
        AppMethodBeat.o(55406);
    }

    private void cA(Context context) {
        AppMethodBeat.i(55407);
        View inflate = View.inflate(context, R.layout.aie, this);
        this.oPI = (TextView) inflate.findViewById(R.id.dgg);
        this.iyo = (ImageView) inflate.findViewById(R.id.dgf);
        switch (this.oPJ) {
            case Mobile:
                setOnClickListener(this.oPK);
                this.iyo.setImageResource(R.raw.icons_outlined_cellphone);
                AppMethodBeat.o(55407);
                return;
            case UploadContact:
                setOnClickListener(this.oPK);
                this.iyo.setImageResource(R.raw.icons_outlined_contacts);
                break;
        }
        AppMethodBeat.o(55407);
    }
}

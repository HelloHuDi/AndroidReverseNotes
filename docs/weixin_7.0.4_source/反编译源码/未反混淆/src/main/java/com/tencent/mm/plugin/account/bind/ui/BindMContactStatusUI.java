package com.tencent.mm.plugin.account.bind.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.ui.MMWizardActivity;

public class BindMContactStatusUI extends MMWizardActivity {
    private TextView grA;
    private TextView grB;
    private Button grC;
    private ImageView gri;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(13455);
        super.onCreate(bundle);
        setMMTitle((int) R.string.a7a);
        initView();
        AppMethodBeat.o(13455);
    }

    public final int getLayoutId() {
        return R.layout.gi;
    }

    public final void initView() {
        AppMethodBeat.i(13456);
        this.gri = (ImageView) findViewById(R.id.a58);
        this.grA = (TextView) findViewById(R.id.a59);
        this.grB = (TextView) findViewById(R.id.a62);
        this.grC = (Button) findViewById(R.id.a5a);
        if (l.apS() == a.SUCC) {
            this.gri.setImageResource(R.raw.mobile_binded_icon);
            String str = (String) g.RP().Ry().get(6, null);
            if (str == null || str.equals("")) {
                str = (String) g.RP().Ry().get(4097, null);
            }
            this.grB.setText(getString(R.string.a77));
            this.grA.setText(getString(R.string.a7v, new Object[]{str}));
        } else {
            this.gri.setImageResource(R.raw.mobile_unbind_icon);
            this.grB.setText(R.string.a7i);
            this.grA.setText(R.string.a7i);
            this.grB.setVisibility(8);
        }
        this.grC.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(13454);
                BindMContactStatusUI.a(BindMContactStatusUI.this);
                AppMethodBeat.o(13454);
            }
        });
        AppMethodBeat.o(13456);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(13457);
        if (i == 4) {
            Ni(1);
            AppMethodBeat.o(13457);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(13457);
        return onKeyDown;
    }

    static /* synthetic */ void a(BindMContactStatusUI bindMContactStatusUI) {
        AppMethodBeat.i(13458);
        bindMContactStatusUI.Ni(1);
        AppMethodBeat.o(13458);
    }
}

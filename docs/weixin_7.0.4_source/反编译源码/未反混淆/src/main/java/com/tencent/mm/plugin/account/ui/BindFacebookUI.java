package com.tencent.mm.plugin.account.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.v;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.f.a.b;
import com.tencent.mm.ui.f.a.c;
import com.tencent.mm.ui.f.a.e;
import java.util.ArrayList;

public class BindFacebookUI extends MMWizardActivity implements f {
    private static final String[] gAu = new String[]{"public_profile"};
    private ProgressDialog gAr;
    private OnCancelListener gAs;
    private v gAt;
    private c gyN;

    final class a implements com.tencent.mm.ui.f.a.c.a {
        private a() {
        }

        /* synthetic */ a(BindFacebookUI bindFacebookUI, byte b) {
            this();
        }

        public final void p(Bundle bundle) {
            AppMethodBeat.i(124728);
            ab.d("MicroMsg.BindFacebookUI", "token:" + BindFacebookUI.this.gyN.gqE);
            g.RP().Ry().set(65830, BindFacebookUI.this.gyN.gqE);
            if (BindFacebookUI.this.gyN.zxC != 0) {
                g.RP().Ry().set(65832, Long.valueOf(BindFacebookUI.this.gyN.zxC));
            }
            BindFacebookUI.this.gAr = ProgressDialog.show(BindFacebookUI.this, BindFacebookUI.this.getString(R.string.tz), BindFacebookUI.this.getString(R.string.bm0), true);
            BindFacebookUI.this.gAr.setOnCancelListener(BindFacebookUI.this.gAs);
            BindFacebookUI.this.gAt = new v(1, BindFacebookUI.this.gyN.gqE);
            g.Rg().a(BindFacebookUI.this.gAt, 0);
            BindFacebookUI.do(true);
            AppMethodBeat.o(124728);
        }

        public final void a(e eVar) {
            AppMethodBeat.i(124729);
            ab.d("MicroMsg.BindFacebookUI", "onFacebookError:" + eVar.zxP);
            h.b(BindFacebookUI.this, eVar.getMessage(), BindFacebookUI.this.getString(R.string.avy), true);
            BindFacebookUI.do(false);
            AppMethodBeat.o(124729);
        }

        public final void a(b bVar) {
            AppMethodBeat.i(124730);
            ab.d("MicroMsg.BindFacebookUI", "onError:" + bVar.getMessage());
            h.b(BindFacebookUI.this, bVar.getMessage(), BindFacebookUI.this.getString(R.string.avy), true);
            BindFacebookUI.do(false);
            AppMethodBeat.o(124730);
        }

        public final void onCancel() {
            AppMethodBeat.i(124731);
            ab.d("MicroMsg.BindFacebookUI", "onCancel");
            BindFacebookUI.do(false);
            AppMethodBeat.o(124731);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(124732);
        super.onCreate(bundle);
        AppMethodBeat.o(124732);
    }

    public void onDestroy() {
        AppMethodBeat.i(124733);
        super.onDestroy();
        AppMethodBeat.o(124733);
    }

    public void onResume() {
        AppMethodBeat.i(124734);
        super.onResume();
        g.Rg().a(183, (f) this);
        initView();
        AppMethodBeat.o(124734);
    }

    public void onPause() {
        AppMethodBeat.i(124735);
        super.onPause();
        g.Rg().b(183, (f) this);
        AppMethodBeat.o(124735);
    }

    public final int getLayoutId() {
        return R.layout.gc;
    }

    public final void initView() {
        AppMethodBeat.i(124736);
        this.gyN = new c(getString(R.string.g7d));
        this.gAs = new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(124725);
                if (BindFacebookUI.this.gAt != null) {
                    g.Rg().c(BindFacebookUI.this.gAt);
                }
                AppMethodBeat.o(124725);
            }
        };
        addTextOptionMenu(0, getString(R.string.r7), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(124726);
                BindFacebookUI.b(BindFacebookUI.this);
                AppMethodBeat.o(124726);
                return true;
            }
        });
        setMMTitle((int) R.string.a5x);
        TextView textView = (TextView) findViewById(R.id.a5g);
        textView.setVisibility(4);
        textView.setText(R.string.a5w);
        Button button = (Button) findViewById(R.id.a5h);
        button.setVisibility(0);
        button.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(124727);
                BindFacebookUI.this.gyN.a(BindFacebookUI.this, BindFacebookUI.gAu, new a(BindFacebookUI.this, (byte) 0));
                AppMethodBeat.o(124727);
            }
        });
        AppMethodBeat.o(124736);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(124737);
        if (mVar.getType() != 183) {
            AppMethodBeat.o(124737);
            return;
        }
        if (this.gAr != null) {
            this.gAr.dismiss();
        }
        if (com.tencent.mm.plugin.account.a.a.gkF.a(this.mController.ylL, i, i2, str)) {
            AppMethodBeat.o(124737);
            return;
        }
        int i3 = ((v) mVar).opType;
        if (i == 0 && i2 == 0) {
            if (i3 == 1) {
                ((j) g.K(j.class)).XR().aoX("facebookapp");
                ((j) g.K(j.class)).bOr().Rh("facebookapp");
            }
            Ni(1);
            AppMethodBeat.o(124737);
        } else if (i == 4 && i2 == -67) {
            Toast.makeText(this, R.string.bm3, 1).show();
            AppMethodBeat.o(124737);
        } else if (i == 4 && i2 == -5) {
            Toast.makeText(this, i3 == 1 ? R.string.blx : R.string.bm6, 1).show();
            AppMethodBeat.o(124737);
        } else {
            Toast.makeText(this, i3 == 0 ? R.string.aw3 : R.string.avy, 1).show();
            AppMethodBeat.o(124737);
        }
    }

    static /* synthetic */ void b(BindFacebookUI bindFacebookUI) {
        AppMethodBeat.i(124738);
        bindFacebookUI.Ni(1);
        AppMethodBeat.o(124738);
    }

    static /* synthetic */ void do(boolean z) {
        AppMethodBeat.i(124739);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.tencent.mm.az.h.a(32, z ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1"));
        ((j) g.K(j.class)).XL().c(new com.tencent.mm.az.h(arrayList));
        AppMethodBeat.o(124739);
    }
}

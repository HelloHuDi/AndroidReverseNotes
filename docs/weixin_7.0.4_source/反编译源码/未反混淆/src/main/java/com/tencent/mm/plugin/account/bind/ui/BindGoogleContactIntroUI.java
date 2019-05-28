package com.tencent.mm.plugin.account.bind.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.m;
import com.tencent.mm.plugin.account.friend.a.w;
import com.tencent.mm.plugin.account.friend.a.w.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.rtmp.TXLiveConstants;

public class BindGoogleContactIntroUI extends MMActivity implements f {
    private ImageView gqh;
    private TextView gqi;
    private Button gqj;
    private Button gqk;
    private boolean gql = false;
    private boolean gqm = false;
    private String gqn;
    private ProgressDialog gqo;
    private w gqp;
    private int gqq;
    private OnClickListener gqr = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(13332);
            Intent intent = new Intent(BindGoogleContactIntroUI.this, BindGoogleContactUI.class);
            intent.putExtra("enter_scene", BindGoogleContactIntroUI.this.gqq);
            BindGoogleContactIntroUI.this.startActivity(intent);
            AppMethodBeat.o(13332);
        }
    };
    private OnClickListener gqs = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(13334);
            h.a(BindGoogleContactIntroUI.this.mController.ylL, true, BindGoogleContactIntroUI.this.getString(R.string.ey7), "", BindGoogleContactIntroUI.this.getString(R.string.ey6), BindGoogleContactIntroUI.this.getString(R.string.or), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(13333);
                    BindGoogleContactIntroUI.b(BindGoogleContactIntroUI.this);
                    AppMethodBeat.o(13333);
                }
            }, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            AppMethodBeat.o(13334);
        }
    };

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BindGoogleContactIntroUI() {
        AppMethodBeat.i(13337);
        AppMethodBeat.o(13337);
    }

    public final int getLayoutId() {
        return R.layout.ge;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(13338);
        super.onCreate(bundle);
        setMMTitle((int) R.string.a61);
        this.gqq = getIntent().getIntExtra("enter_scene", 0);
        this.gql = m.cx(this);
        if (this.gql) {
            startActivityForResult(new Intent("com.tencent.mm.gms.CHECK_GP_SERVICES"), TXLiveConstants.PLAY_EVT_PLAY_PROGRESS);
        }
        AppMethodBeat.o(13338);
    }

    public void onResume() {
        AppMethodBeat.i(13339);
        super.onResume();
        this.gqn = (String) g.RP().Ry().get(208903, null);
        if (TextUtils.isEmpty(this.gqn)) {
            this.gqm = false;
        } else {
            this.gqm = true;
        }
        initView();
        if (this.gqm) {
            this.gqk.setVisibility(0);
            this.gqj.setVisibility(8);
            this.gqi.setVisibility(0);
            this.gqi.setText(getString(R.string.a5z, new Object[]{this.gqn}));
            this.gqk.setOnClickListener(this.gqs);
        } else {
            aoP();
        }
        g.Rg().a(487, (f) this);
        AppMethodBeat.o(13339);
    }

    public void onStop() {
        AppMethodBeat.i(13340);
        super.onStop();
        g.Rg().b(487, (f) this);
        AppMethodBeat.o(13340);
    }

    public void onDestroy() {
        AppMethodBeat.i(13341);
        super.onDestroy();
        AppMethodBeat.o(13341);
    }

    public final void initView() {
        AppMethodBeat.i(13342);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(13335);
                BindGoogleContactIntroUI.this.finish();
                AppMethodBeat.o(13335);
                return true;
            }
        });
        this.gqh = (ImageView) findViewById(R.id.a5k);
        this.gqi = (TextView) findViewById(R.id.a5l);
        this.gqj = (Button) findViewById(R.id.a5m);
        this.gqk = (Button) findViewById(R.id.a5n);
        AppMethodBeat.o(13342);
    }

    private void aoP() {
        AppMethodBeat.i(13343);
        this.gqk.setVisibility(8);
        this.gqj.setVisibility(0);
        this.gqh.setVisibility(0);
        this.gqi.setVisibility(0);
        this.gqi.setText(R.string.a60);
        this.gqj.setText(R.string.a5y);
        this.gqj.setOnClickListener(this.gqr);
        AppMethodBeat.o(13343);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(13344);
        ab.i("MicroMsg.GoogleContact.BindGoogleContactIntroUI", "requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i2 == -1) {
            if (i == TXLiveConstants.PLAY_EVT_PLAY_PROGRESS) {
                this.gql = intent.getBooleanExtra("gpservices", false);
                AppMethodBeat.o(13344);
                return;
            }
        } else if (i == TXLiveConstants.PLAY_EVT_PLAY_PROGRESS) {
            this.gql = intent.getBooleanExtra("gpservices", false);
        }
        AppMethodBeat.o(13344);
    }

    public void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(13345);
        String str2 = "MicroMsg.GoogleContact.BindGoogleContactIntroUI";
        String str3 = "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        objArr[2] = str;
        ab.i(str2, str3, objArr);
        if (this.gqo != null && this.gqo.isShowing()) {
            this.gqo.dismiss();
        }
        if (i == 0 && i2 == 0) {
            g.RP().Ry().set(208903, (Object) "");
            g.RP().Ry().set(208901, (Object) "");
            g.RP().Ry().set(208902, (Object) "");
            g.RP().Ry().set(208905, Boolean.TRUE);
            g.RP().Ry().dsb();
            aoP();
            h.bQ(this, getString(R.string.ey8));
            AppMethodBeat.o(13345);
            return;
        }
        ab.i("MicroMsg.GoogleContact.BindGoogleContactIntroUI", "unbind failed");
        Toast.makeText(this, R.string.c8s, 0).show();
        AppMethodBeat.o(13345);
    }

    static /* synthetic */ void b(BindGoogleContactIntroUI bindGoogleContactIntroUI) {
        AppMethodBeat.i(13346);
        bindGoogleContactIntroUI.gqp = new w(a.MM_BIND_GCONTACT_OPCODE_UNBIND, bindGoogleContactIntroUI.gqn, w.gvM);
        g.Rg().a(bindGoogleContactIntroUI.gqp, 0);
        bindGoogleContactIntroUI.getString(R.string.tz);
        bindGoogleContactIntroUI.gqo = h.b((Context) bindGoogleContactIntroUI, bindGoogleContactIntroUI.getString(R.string.un), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(13336);
                g.Rg().c(BindGoogleContactIntroUI.this.gqp);
                AppMethodBeat.o(13336);
            }
        });
        AppMethodBeat.o(13346);
    }
}

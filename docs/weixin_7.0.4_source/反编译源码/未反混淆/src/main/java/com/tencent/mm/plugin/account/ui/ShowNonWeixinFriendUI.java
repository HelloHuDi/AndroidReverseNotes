package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.d.a;
import com.tencent.mm.ah.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.f.a.c;
import com.tencent.mm.ui.f.a.e;

public class ShowNonWeixinFriendUI extends MMActivity implements a {
    private long gIk = 0;
    private String gIl = "";

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(125591);
        super.onCreate(bundle);
        setMMTitle((int) R.string.cea);
        this.gIk = getIntent().getLongExtra("Contact_KFacebookId", 0);
        this.gIl = getIntent().getStringExtra("Contact_KFacebookName");
        initView();
        AppMethodBeat.o(125591);
    }

    public void onPause() {
        AppMethodBeat.i(125592);
        super.onPause();
        o.acd().e(this);
        AppMethodBeat.o(125592);
    }

    public void onResume() {
        AppMethodBeat.i(125593);
        super.onResume();
        o.acd().d(this);
        AppMethodBeat.o(125593);
    }

    public final int getLayoutId() {
        return R.layout.xu;
    }

    public final void initView() {
        AppMethodBeat.i(125594);
        ImageView imageView = (ImageView) findViewById(R.id.bod);
        TextView textView = (TextView) findViewById(R.id.boe);
        TextView textView2 = (TextView) findViewById(R.id.bof);
        imageView.setBackgroundDrawable(com.tencent.mm.bz.a.g(this, R.raw.default_mobile_avatar));
        imageView.setImageBitmap(b.pS(this.gIk));
        textView.setText(this.gIl);
        textView2.setText(getString(R.string.ce9, new Object[]{this.gIl}));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(125584);
                ShowNonWeixinFriendUI.this.aqX();
                ShowNonWeixinFriendUI.this.finish();
                AppMethodBeat.o(125584);
                return true;
            }
        });
        ((Button) findViewById(R.id.bog)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(125590);
                c cVar = new c(ShowNonWeixinFriendUI.this.getString(R.string.g7d));
                Bundle bundle = new Bundle();
                bundle.putString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, ShowNonWeixinFriendUI.this.getString(R.string.bmd));
                bundle.putString("to", Long.toString(ShowNonWeixinFriendUI.this.gIk));
                cVar.a(ShowNonWeixinFriendUI.this, "apprequests", bundle, new c.a() {
                    public final void a(e eVar) {
                        AppMethodBeat.i(125586);
                        ab.e("MicroMsg.ShowNonWeixinFriendUI", "fbinvite error");
                        AppMethodBeat.o(125586);
                    }

                    public final void a(com.tencent.mm.ui.f.a.b bVar) {
                        AppMethodBeat.i(125587);
                        ab.e("MicroMsg.ShowNonWeixinFriendUI", "fbinvite error");
                        AppMethodBeat.o(125587);
                    }

                    public final void p(Bundle bundle) {
                        AppMethodBeat.i(125588);
                        ab.i("MicroMsg.ShowNonWeixinFriendUI", "fbinvite oncomplete");
                        h.a(ShowNonWeixinFriendUI.this.mController.ylL, (int) R.string.bmi, (int) R.string.tz, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(125585);
                                ShowNonWeixinFriendUI.this.finish();
                                AppMethodBeat.o(125585);
                            }
                        });
                        AppMethodBeat.o(125588);
                    }

                    public final void onCancel() {
                        AppMethodBeat.i(125589);
                        ab.e("MicroMsg.ShowNonWeixinFriendUI", "fbinvite cancle");
                        AppMethodBeat.o(125589);
                    }
                });
                AppMethodBeat.o(125590);
            }
        });
        AppMethodBeat.o(125594);
    }

    public final void qj(String str) {
        AppMethodBeat.i(125595);
        initView();
        AppMethodBeat.o(125595);
    }
}

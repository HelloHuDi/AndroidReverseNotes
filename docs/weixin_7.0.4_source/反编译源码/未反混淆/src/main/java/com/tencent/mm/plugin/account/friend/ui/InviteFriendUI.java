package com.tencent.mm.plugin.account.friend.ui;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
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
import com.tencent.mm.a.g;
import com.tencent.mm.a.p;
import com.tencent.mm.ah.d.a;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.f;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.account.friend.a.b;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class InviteFriendUI extends MMActivity implements a {
    private ImageView gvq;
    private String gxo;
    private int gxp;
    private String gxq;
    private String gxr;
    private String gxs;
    private Button gxt;
    private int gxu;
    private int gxv;
    private String gxw = null;
    private String gxx = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(108580);
        super.onCreate(bundle);
        setMMTitle((int) R.string.cea);
        Intent intent = getIntent();
        this.gxp = intent.getIntExtra("friend_type", -1);
        this.gxq = intent.getStringExtra("friend_nick");
        this.gxo = intent.getStringExtra("friend_num");
        this.gxr = intent.getStringExtra("friend_googleID");
        this.gxs = intent.getStringExtra("friend_googleItemID");
        this.gxo = bo.nullAsNil(this.gxo);
        this.gxw = intent.getStringExtra("friend_linkedInID");
        this.gxx = intent.getStringExtra("friend_linkedInPicUrl");
        initView();
        this.gxu = intent.getIntExtra("search_kvstat_scene", 0);
        this.gxv = intent.getIntExtra("search_kvstat_position", 0);
        AppMethodBeat.o(108580);
    }

    public void onPause() {
        AppMethodBeat.i(108581);
        super.onPause();
        o.acd().e(this);
        AppMethodBeat.o(108581);
    }

    public void onResume() {
        AppMethodBeat.i(108582);
        super.onResume();
        o.acd().d(this);
        AppMethodBeat.o(108582);
    }

    public final int getLayoutId() {
        return R.layout.a84;
    }

    public void onDestroy() {
        AppMethodBeat.i(108583);
        super.onDestroy();
        AppMethodBeat.o(108583);
    }

    public final void initView() {
        Bitmap b;
        AppMethodBeat.i(108584);
        this.gvq = (ImageView) findViewById(R.id.bod);
        TextView textView = (TextView) findViewById(R.id.boe);
        TextView textView2 = (TextView) findViewById(R.id.cix);
        TextView textView3 = (TextView) findViewById(R.id.bof);
        this.gxt = (Button) findViewById(R.id.bog);
        Button button = (Button) findViewById(R.id.ciz);
        textView.setText(this.gxq);
        textView3.setText(getString(R.string.ce9, new Object[]{this.gxq}));
        if (this.gxp == 1) {
            this.gvq.setBackgroundDrawable(com.tencent.mm.bz.a.g(this, R.raw.default_mobile_avatar));
            textView2.setText(getString(R.string.q5) + this.gxo);
            String x = g.x(this.gxo.getBytes());
            if (com.tencent.mm.kernel.g.RP().isSDCardAvailable()) {
                com.tencent.mm.plugin.account.friend.a.a vW = ((b) ((com.tencent.mm.plugin.account.a.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).vW(x);
                if (vW != null) {
                    b = l.b(vW.apz(), this);
                } else {
                    b = null;
                }
            } else {
                b = o.acd().bU(ah.getContext());
            }
            if (b != null) {
                this.gvq.setImageBitmap(b);
            } else {
                this.gvq.setImageDrawable(com.tencent.mm.bz.a.g(this, R.raw.default_mobile_avatar));
            }
        }
        if (this.gxp == 0) {
            this.gvq.setBackgroundDrawable(com.tencent.mm.bz.a.g(this, R.raw.default_qq_avatar));
            textView2.setText(getString(R.string.q_) + this.gxo);
            long cB = (long) p.cB(this.gxo);
            b = null;
            if (cB != 0) {
                b = com.tencent.mm.ah.b.fr(cB);
            }
            if (b == null) {
                this.gvq.setImageDrawable(com.tencent.mm.bz.a.g(this, R.raw.default_qq_avatar));
            } else {
                this.gvq.setImageBitmap(b);
            }
            button.setVisibility(0);
        }
        if (this.gxp == 2) {
            Bitmap pP;
            this.gxt.setText(R.string.c8r);
            this.gvq.setBackgroundDrawable(com.tencent.mm.bz.a.g(this, R.drawable.ad4));
            textView2.setText(getString(R.string.px) + this.gxo);
            if (com.tencent.mm.kernel.g.RP().isSDCardAvailable()) {
                pP = com.tencent.mm.ah.b.pP(this.gxr);
            } else {
                pP = o.acd().bU(ah.getContext());
            }
            if (pP != null) {
                this.gvq.setImageBitmap(pP);
            } else {
                this.gvq.setImageDrawable(com.tencent.mm.bz.a.g(this, R.drawable.ad4));
            }
            if (TextUtils.isEmpty(this.gxq)) {
                textView.setText(bo.anu(this.gxo));
                textView3.setText(getString(R.string.ce9, new Object[]{bo.anu(this.gxo)}));
            }
        }
        if (this.gxp == 3) {
            this.gxt.setText(R.string.ce8);
            Bitmap a = x.a(new c(this.gxx, this.gxx));
            if (a != null) {
                this.gvq.setImageBitmap(a);
            } else {
                this.gvq.setImageResource(R.raw.default_avatar);
            }
            button.setVisibility(8);
        }
        this.gxt.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(108577);
                final String string;
                switch (InviteFriendUI.this.gxp) {
                    case 0:
                        new g(InviteFriendUI.this, new g.a() {
                            public final void e(boolean z, String str) {
                                AppMethodBeat.i(108575);
                                if (z) {
                                    InviteFriendUI.this.finish();
                                }
                                AppMethodBeat.o(108575);
                            }
                        }).m(new int[]{p.cB(InviteFriendUI.this.gxo)});
                        AppMethodBeat.o(108577);
                        return;
                    case 1:
                        String str = (String) com.tencent.mm.kernel.g.RP().Ry().get(42, (Object) "");
                        if (str == null || str.length() == 0) {
                            str = (String) com.tencent.mm.kernel.g.RP().Ry().get(2, (Object) "");
                        }
                        string = InviteFriendUI.this.getString(R.string.ceq, new Object[]{str});
                        final Uri parse = Uri.parse("smsto:" + InviteFriendUI.this.gxo);
                        Intent intent = new Intent("android.intent.action.SENDTO", parse);
                        intent.putExtra("sms_body", string);
                        final PackageManager packageManager = InviteFriendUI.this.getPackageManager();
                        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
                        final HashMap hashMap = new HashMap();
                        for (ResolveInfo resolveInfo : queryIntentActivities) {
                            if (!resolveInfo.activityInfo.packageName.equals("com.whatsapp")) {
                                hashMap.put(resolveInfo.activityInfo.name, resolveInfo);
                            }
                        }
                        if (hashMap.size() == 1) {
                            Iterator it = hashMap.keySet().iterator();
                            if (it.hasNext()) {
                                str = (String) it.next();
                                Intent intent2 = new Intent();
                                intent2.setComponent(new ComponentName(((ResolveInfo) hashMap.get(str)).activityInfo.packageName, ((ResolveInfo) hashMap.get(str)).activityInfo.name));
                                intent2.setAction("android.intent.action.SENDTO");
                                intent2.setData(parse);
                                intent2.putExtra("sms_body", string);
                                InviteFriendUI.this.startActivity(intent2);
                                InviteFriendUI.c(InviteFriendUI.this);
                            }
                            AppMethodBeat.o(108577);
                            return;
                        } else if (hashMap.size() > 1) {
                            j jVar = new j(InviteFriendUI.this);
                            jVar.zFT = new n.a() {
                                public final void a(ImageView imageView, MenuItem menuItem) {
                                    AppMethodBeat.i(108571);
                                    imageView.setImageDrawable(((ResolveInfo) hashMap.get(menuItem.getTitle())).loadIcon(packageManager));
                                    AppMethodBeat.o(108571);
                                }
                            };
                            jVar.zFU = new n.b() {
                                public final void a(TextView textView, MenuItem menuItem) {
                                    AppMethodBeat.i(108572);
                                    CharSequence loadLabel = ((ResolveInfo) hashMap.get(menuItem.getTitle())).loadLabel(packageManager);
                                    if (loadLabel != null) {
                                        textView.setText(loadLabel.toString());
                                        AppMethodBeat.o(108572);
                                        return;
                                    }
                                    textView.setText("");
                                    AppMethodBeat.o(108572);
                                }
                            };
                            jVar.rBl = new n.c() {
                                public final void a(com.tencent.mm.ui.base.l lVar) {
                                    AppMethodBeat.i(108573);
                                    for (CharSequence add : hashMap.keySet()) {
                                        lVar.add(add);
                                    }
                                    AppMethodBeat.o(108573);
                                }
                            };
                            jVar.rBm = new d() {
                                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                                    AppMethodBeat.i(108574);
                                    String str = menuItem.getTitle();
                                    Intent intent = new Intent();
                                    intent.setComponent(new ComponentName(((ResolveInfo) hashMap.get(str)).activityInfo.packageName, ((ResolveInfo) hashMap.get(str)).activityInfo.name));
                                    intent.setAction("android.intent.action.SENDTO");
                                    intent.setData(parse);
                                    intent.putExtra("sms_body", string);
                                    InviteFriendUI.this.startActivity(intent);
                                    AppMethodBeat.o(108574);
                                }
                            };
                            jVar.cuu();
                            InviteFriendUI.c(InviteFriendUI.this);
                            AppMethodBeat.o(108577);
                            return;
                        } else {
                            Toast.makeText(InviteFriendUI.this, R.string.e2a, 1).show();
                            AppMethodBeat.o(108577);
                            return;
                        }
                    case 2:
                        f hVar = new h(InviteFriendUI.this, new h.a() {
                            public final void dn(boolean z) {
                                AppMethodBeat.i(108576);
                                if (z) {
                                    ((com.tencent.mm.plugin.account.friend.a.o) ((com.tencent.mm.plugin.account.a.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).aj(InviteFriendUI.this.gxs, 1);
                                }
                                AppMethodBeat.o(108576);
                            }
                        });
                        string = InviteFriendUI.this.gxr;
                        String b = InviteFriendUI.this.gxo;
                        com.tencent.mm.kernel.g.Rg().a(489, hVar);
                        Cursor wg = ((com.tencent.mm.plugin.account.friend.a.o) ((com.tencent.mm.plugin.account.a.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).wg(string);
                        if (wg == null || wg.getCount() <= 1) {
                            hVar.wm(b);
                        } else {
                            hVar.e(wg);
                        }
                        if (wg != null) {
                            wg.close();
                            break;
                        }
                        break;
                }
                AppMethodBeat.o(108577);
            }
        });
        button.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(108578);
                mx mxVar = new mx();
                mxVar.cIO.opType = 0;
                mxVar.cIO.cIQ = InviteFriendUI.this.gxo + "@qqim";
                mxVar.cIO.cIR = InviteFriendUI.this.gxq;
                com.tencent.mm.sdk.b.a.xxA.m(mxVar);
                if (mxVar.cIP.cvi) {
                    com.tencent.mm.plugin.account.a.a.gkE.d(new Intent().putExtra("Chat_User", InviteFriendUI.this.gxo + "@qqim"), InviteFriendUI.this);
                }
                InviteFriendUI.this.finish();
                AppMethodBeat.o(108578);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(108579);
                InviteFriendUI.this.finish();
                AppMethodBeat.o(108579);
                return true;
            }
        });
        AppMethodBeat.o(108584);
    }

    public final void qj(String str) {
        AppMethodBeat.i(108585);
        if (this.gxo == null || this.gxo.equals("")) {
            AppMethodBeat.o(108585);
            return;
        }
        long pU = com.tencent.mm.ah.b.pU(str);
        if (pU > 0 && this.gxo.equals(String.valueOf(pU)) && this.gxp == 0) {
            this.gvq.setImageBitmap(com.tencent.mm.ah.b.a(str, false, -1));
        }
        AppMethodBeat.o(108585);
    }

    static /* synthetic */ void c(InviteFriendUI inviteFriendUI) {
        AppMethodBeat.i(108586);
        if (inviteFriendUI.gxu > 0 && inviteFriendUI.gxv > 0) {
            h.pYm.e(10991, Integer.valueOf(inviteFriendUI.gxu), Integer.valueOf(7), Integer.valueOf(inviteFriendUI.gxv));
        }
        AppMethodBeat.o(108586);
    }
}

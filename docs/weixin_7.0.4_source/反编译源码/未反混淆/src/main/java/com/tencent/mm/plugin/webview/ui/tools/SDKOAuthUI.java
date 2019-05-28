package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.hh;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.gdpr.c;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Req;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.plugin.webview.model.aa;
import com.tencent.mm.plugin.webview.model.ag;
import com.tencent.mm.plugin.webview.model.i;
import com.tencent.mm.plugin.webview.model.y;
import com.tencent.mm.plugin.webview.model.z;
import com.tencent.mm.protocal.protobuf.bet;
import com.tencent.mm.protocal.protobuf.bew;
import com.tencent.mm.protocal.protobuf.bnb;
import com.tencent.mm.protocal.protobuf.bum;
import com.tencent.mm.protocal.protobuf.buo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(3)
public final class SDKOAuthUI extends MMActivity implements f {
    private static int usH;
    private int accountType = 2;
    private String cOG;
    private p ejZ;
    private int jLX;
    private int jLY;
    private d jOb = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.i(7529);
            SDKOAuthUI.q(SDKOAuthUI.this);
            AppMethodBeat.o(7529);
        }
    };
    private String mAppId;
    private long startTime;
    private boolean ump;
    private Req usF;
    private int usG;
    private ap usI;
    private a usJ;
    private b usK;
    private com.tencent.mm.ui.widget.b.a usL;
    private boolean usM;
    private ag usN;
    private boolean usO = true;
    private String usP;
    private boolean usp = false;

    static final class b extends BaseAdapter {
        private LayoutInflater mInflater;
        LinkedList<bet> usV;
        private com.tencent.mm.at.a.a.c.a usW = new com.tencent.mm.at.a.a.c.a();
        private Context usX;
        private int usY;

        static final class a {
            ImageView usZ;
            TextView uta;
            TextView utb;
            ImageView utc;

            private a() {
            }

            /* synthetic */ a(byte b) {
                this();
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(7550);
            bet Jm = Jm(i);
            AppMethodBeat.o(7550);
            return Jm;
        }

        public b(Context context, LinkedList<bet> linkedList, int i) {
            AppMethodBeat.i(7546);
            this.usX = context;
            this.mInflater = LayoutInflater.from(context);
            this.usV = linkedList;
            com.tencent.mm.at.a.a.c.a aVar = this.usW;
            aVar.eQf = true;
            aVar.eQg = this.usX.getResources().getDimension(R.dimen.a7t);
            this.usY = i;
            AppMethodBeat.o(7546);
        }

        public final int getCount() {
            AppMethodBeat.i(7547);
            if (this.usV == null) {
                AppMethodBeat.o(7547);
                return 0;
            }
            int size = this.usV.size();
            AppMethodBeat.o(7547);
            return size;
        }

        public final bet Jm(int i) {
            AppMethodBeat.i(7548);
            if (i < 0 || i >= this.usV.size()) {
                AppMethodBeat.o(7548);
                return null;
            }
            bet bet = (bet) this.usV.get(i);
            AppMethodBeat.o(7548);
            return bet;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(7549);
            bet Jm = Jm(i);
            if (Jm == null) {
                AppMethodBeat.o(7549);
            } else {
                a aVar;
                if (view == null) {
                    a aVar2 = new a();
                    view = this.mInflater.inflate(R.layout.f5, null, false);
                    aVar2.usZ = (ImageView) view.findViewById(R.id.a0d);
                    aVar2.uta = (TextView) view.findViewById(R.id.a0e);
                    aVar2.utb = (TextView) view.findViewById(R.id.a0f);
                    aVar2.utc = (ImageView) view.findViewById(R.id.a0g);
                    view.setTag(aVar2);
                    aVar = aVar2;
                } else {
                    aVar = (a) view.getTag();
                }
                aVar.uta.setText(Jm.nickname);
                o.ahp().a(Jm.wrK, aVar.usZ, this.usW.ahG());
                if (Jm.desc != null) {
                    aVar.utb.setText(Jm.desc);
                    aVar.utb.setVisibility(0);
                } else {
                    aVar.utb.setVisibility(8);
                }
                if (Jm.id == this.usY) {
                    aVar.utc.setVisibility(0);
                } else {
                    aVar.utc.setVisibility(4);
                }
                AppMethodBeat.o(7549);
            }
            return view;
        }
    }

    static final class a extends BaseAdapter {
        private LayoutInflater mInflater;
        private LinkedList<bew> usA;

        static final class a {
            TextView jbS;
            ImageView usE;

            private a() {
            }

            /* synthetic */ a(byte b) {
                this();
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(7545);
            bew Jl = Jl(i);
            AppMethodBeat.o(7545);
            return Jl;
        }

        public a(Context context, LinkedList<bew> linkedList) {
            AppMethodBeat.i(7540);
            this.mInflater = LayoutInflater.from(context);
            this.usA = linkedList;
            AppMethodBeat.o(7540);
        }

        public final LinkedList<String> cZG() {
            AppMethodBeat.i(7541);
            LinkedList linkedList = new LinkedList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.usA.size()) {
                    bew bew = (bew) this.usA.get(i2);
                    if (bew.wIR == 2 || bew.wIR == 3) {
                        linkedList.add(bew.scope);
                    }
                    i = i2 + 1;
                } else {
                    AppMethodBeat.o(7541);
                    return linkedList;
                }
            }
        }

        public final int getCount() {
            AppMethodBeat.i(7542);
            if (this.usA == null) {
                AppMethodBeat.o(7542);
                return 0;
            }
            int size = this.usA.size();
            AppMethodBeat.o(7542);
            return size;
        }

        private bew Jl(int i) {
            AppMethodBeat.i(7543);
            if (i < 0 || i >= this.usA.size()) {
                AppMethodBeat.o(7543);
                return null;
            }
            bew bew = (bew) this.usA.get(i);
            AppMethodBeat.o(7543);
            return bew;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(7544);
            if (this.usA == null || this.usA.size() <= 0) {
                AppMethodBeat.o(7544);
                return null;
            }
            final bew Jl = Jl(i);
            if (Jl == null) {
                AppMethodBeat.o(7544);
                return view;
            }
            a aVar;
            if (view == null) {
                a aVar2 = new a();
                view = this.mInflater.inflate(R.layout.apq, null, false);
                aVar2.usE = (ImageView) view.findViewById(R.id.a02);
                aVar2.jbS = (TextView) view.findViewById(R.id.a03);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            if (Jl.wIR == 1) {
                aVar.usE.setImageResource(R.raw.login_auth_state_not_selected);
            } else if (Jl.wIR == 3) {
                aVar.usE.setImageResource(R.raw.login_auth_state_must_select);
            } else {
                aVar.usE.setImageResource(R.raw.login_auth_state_default_select);
            }
            aVar.jbS.setText(Jl.desc);
            final ImageView imageView = aVar.usE;
            aVar.usE.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(7539);
                    if (Jl.wIR == 2) {
                        imageView.setImageResource(R.raw.login_auth_state_not_selected);
                        Jl.wIR = 1;
                        AppMethodBeat.o(7539);
                        return;
                    }
                    if (Jl.wIR == 1) {
                        imageView.setImageResource(R.raw.login_auth_state_default_select);
                        Jl.wIR = 2;
                    }
                    AppMethodBeat.o(7539);
                }
            });
            AppMethodBeat.o(7544);
            return view;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SDKOAuthUI() {
        AppMethodBeat.i(7551);
        AppMethodBeat.o(7551);
    }

    static /* synthetic */ String afC(String str) {
        AppMethodBeat.i(7578);
        String aer = aer(str);
        AppMethodBeat.o(7578);
        return aer;
    }

    static /* synthetic */ int d(SDKOAuthUI sDKOAuthUI) {
        AppMethodBeat.i(7575);
        int cZE = sDKOAuthUI.cZE();
        AppMethodBeat.o(7575);
        return cZE;
    }

    static /* synthetic */ void p(SDKOAuthUI sDKOAuthUI) {
        AppMethodBeat.i(7583);
        sDKOAuthUI.cZw();
        AppMethodBeat.o(7583);
    }

    public final void onCreate(Bundle bundle) {
        String str = null;
        AppMethodBeat.i(7552);
        super.onCreate(bundle);
        xE(getResources().getColor(R.color.d4));
        dyb();
        setMMTitle(getString(R.string.d6d));
        pP(false);
        b(null, new Runnable() {
            public final void run() {
                AppMethodBeat.i(7524);
                ab.i("MicroMsg.SdkOAuthUI", "BackBtn click");
                com.tencent.mm.plugin.webview.e.a aVar = com.tencent.mm.plugin.webview.e.a.uKJ;
                com.tencent.mm.plugin.webview.e.a.a(SDKOAuthUI.this.mAppId, SDKOAuthUI.this.startTime, 0, SDKOAuthUI.this.accountType, SDKOAuthUI.d(SDKOAuthUI.this), 1, 0);
                SDKOAuthUI.a(SDKOAuthUI.this, -2);
                SDKOAuthUI.this.finish();
                AppMethodBeat.o(7524);
            }
        });
        if (g.RK()) {
            this.ump = false;
            Intent intent = getIntent();
            this.usp = intent.getBooleanExtra("auth_from_scan", false);
            if (this.usp) {
                this.accountType = 3;
                this.cOG = intent.getStringExtra("auth_raw_url");
                ab.i("MicroMsg.SdkOAuthUI", "doQRCodeOauthAuthorize url: %s", this.cOG);
                cZw();
                g.Rg().a(new y(r0), 0);
                this.usN = new ag(this, null, this.cOG);
                AppMethodBeat.o(7552);
                return;
            }
            Bundle extras = getIntent().getExtras();
            String string = extras.getString(ConstantsAPI.CONTENT);
            if (bo.isNullOrNil(string)) {
                ab.e("MicroMsg.SdkOAuthUI", "init content is nil");
                AppMethodBeat.o(7552);
                return;
            }
            this.mAppId = Uri.parse(string).getQueryParameter("appid");
            if (bo.isNullOrNil(this.mAppId)) {
                ab.i("MicroMsg.SdkOAuthUI", "parseAppId try case not sensitive, content:%s", string);
                this.mAppId = Uri.parse(string.toLowerCase()).getQueryParameter("appid");
            }
            string = this.mAppId;
            com.tencent.mm.pluginsdk.model.app.f bT = com.tencent.mm.pluginsdk.model.app.g.bT(string, false);
            if (bT != null && bo.isNullOrNil(bT.field_openId)) {
                ab.i("MicroMsg.SdkOAuthUI", "checkGetAppSetting appId: %s ", string);
                hh hhVar = new hh();
                hhVar.cCd.appId = string;
                com.tencent.mm.sdk.b.a.xxA.m(hhVar);
            }
            this.usF = new Req(extras);
            this.usN = new ag(this, this.mAppId, this.usF.transaction, this.usF.state);
            string = this.mAppId;
            String str2 = this.usF.scope;
            String str3 = this.usF.state;
            String aer = aer(this.mAppId);
            ab.i("MicroMsg.SdkOAuthUI", "doSDKOauthAuthorize appid: %s", string);
            cZw();
            if (!bo.isNullOrNil(aer)) {
                Signature[] bx = com.tencent.mm.pluginsdk.model.app.p.bx(this, aer);
                if (bx == null || bx.length == 0) {
                    ab.e("MicroMsg.SdkOAuthUI", "getSignature signatures failed");
                } else {
                    str = com.tencent.mm.a.g.x(bx[0].toByteArray());
                }
            }
            g.Rg().a(new aa(string, str2, str3, aer, str), 0);
            AppMethodBeat.o(7552);
            return;
        }
        ab.e("MicroMsg.SdkOAuthUI", "start, hasSetUin fail");
        Toast.makeText(this, R.string.c7, 1).show();
        AppMethodBeat.o(7552);
    }

    public final void onResume() {
        AppMethodBeat.i(7553);
        super.onResume();
        g.Rg().a(1346, (f) this);
        g.Rg().a(1388, (f) this);
        g.Rg().a(2700, (f) this);
        g.Rg().a(2543, (f) this);
        g.Rg().a(1137, (f) this);
        AppMethodBeat.o(7553);
    }

    public final void onPause() {
        AppMethodBeat.i(7554);
        super.onPause();
        g.Rg().b(1388, (f) this);
        g.Rg().b(1346, (f) this);
        g.Rg().b(2700, (f) this);
        g.Rg().b(2543, (f) this);
        g.Rg().b(1137, (f) this);
        AppMethodBeat.o(7554);
    }

    public final void onDestroy() {
        AppMethodBeat.i(7555);
        super.onDestroy();
        if (this.ejZ != null) {
            this.ejZ.dismiss();
        }
        if (this.usI != null) {
            this.usI.stopTimer();
        }
        AppMethodBeat.o(7555);
    }

    public final int getLayoutId() {
        return R.layout.aps;
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(7556);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            com.tencent.mm.plugin.webview.e.a aVar = com.tencent.mm.plugin.webview.e.a.uKJ;
            com.tencent.mm.plugin.webview.e.a.a(this.mAppId, this.startTime, 0, this.accountType, cZE(), 1, 0);
            IH(-2);
            ab.i("MicroMsg.SdkOAuthUI", "key back click");
            finish();
            AppMethodBeat.o(7556);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(7556);
        return onKeyDown;
    }

    private void a(int i, int i2, String str, final buo buo) {
        AppMethodBeat.i(7557);
        ab.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd errType:%d errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        cZx();
        this.startTime = System.currentTimeMillis();
        com.tencent.mm.plugin.webview.e.a aVar;
        if (i == 0 && i2 == 0) {
            ab.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd is_use_newpage %b", Boolean.valueOf(buo.wWf));
            this.usP = buo.wPV;
            ImageView imageView;
            TextView textView;
            com.tencent.mm.at.a.a.c.a aVar2;
            ListView listView;
            if (buo.wIM || buo.wIN) {
                ab.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd direct login");
                c.a(this, com.tencent.mm.model.gdpr.a.OPENSDK, this.mAppId, new com.tencent.mm.model.gdpr.b() {
                    public final void kL(int i) {
                        AppMethodBeat.i(7530);
                        ab.i("MicroMsg.SdkOAuthUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", Integer.valueOf(i));
                        com.tencent.mm.plugin.webview.e.a aVar;
                        if (i == 1) {
                            SDKOAuthUI.a(SDKOAuthUI.this, -4);
                            aVar = com.tencent.mm.plugin.webview.e.a.uKJ;
                            com.tencent.mm.plugin.webview.e.a.a(SDKOAuthUI.this.mAppId, SDKOAuthUI.this.startTime, 0, SDKOAuthUI.this.accountType, 0, 0, 0);
                            SDKOAuthUI.this.finish();
                            AppMethodBeat.o(7530);
                            return;
                        }
                        SDKOAuthUI.a(SDKOAuthUI.this, buo.vGi);
                        aVar = com.tencent.mm.plugin.webview.e.a.uKJ;
                        com.tencent.mm.plugin.webview.e.a.a(SDKOAuthUI.this.mAppId, SDKOAuthUI.this.startTime, 1, SDKOAuthUI.this.accountType, 0, 0, 0);
                        AppMethodBeat.o(7530);
                    }
                });
                AppMethodBeat.o(7557);
            } else if (!buo.wWf) {
                this.usO = false;
                imageView = (ImageView) findViewById(R.id.pb);
                textView = (TextView) findViewById(R.id.pc);
                aVar2 = new com.tencent.mm.at.a.a.c.a();
                aVar2.ePT = R.raw.native_oauth_default_head_img;
                o.ahp().a(buo.wIL, imageView, aVar2.ahG());
                textView.setText(buo.fhH);
                listView = (ListView) findViewById(R.id.pe);
                this.usJ = new a(this, buo.wIK);
                listView.setAdapter(this.usJ);
                ((Button) findViewById(R.id.cqc)).setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(7532);
                        ab.i("MicroMsg.SdkOAuthUI", "accept go  MPGdprPolicyUtil.checkPolicy");
                        c.a(SDKOAuthUI.this, com.tencent.mm.model.gdpr.a.OPENSDK, SDKOAuthUI.this.mAppId, new com.tencent.mm.model.gdpr.b() {
                            public final void kL(int i) {
                                AppMethodBeat.i(7531);
                                ab.i("MicroMsg.SdkOAuthUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", Integer.valueOf(i));
                                com.tencent.mm.plugin.webview.e.a aVar;
                                if (i == 1) {
                                    SDKOAuthUI.a(SDKOAuthUI.this, -4);
                                    aVar = com.tencent.mm.plugin.webview.e.a.uKJ;
                                    com.tencent.mm.plugin.webview.e.a.a(SDKOAuthUI.this.mAppId, SDKOAuthUI.this.startTime, 0, SDKOAuthUI.this.accountType, 1, 1, 0);
                                    SDKOAuthUI.this.finish();
                                    AppMethodBeat.o(7531);
                                } else if (buo.wIO) {
                                    SDKOAuthUI.a(SDKOAuthUI.this, SDKOAuthUI.this.mAppId, SDKOAuthUI.this.usF.state, SDKOAuthUI.afC(SDKOAuthUI.this.mAppId), SDKOAuthUI.this.usJ.cZG());
                                    AppMethodBeat.o(7531);
                                } else {
                                    aVar = com.tencent.mm.plugin.webview.e.a.uKJ;
                                    com.tencent.mm.plugin.webview.e.a.a(SDKOAuthUI.this.mAppId, SDKOAuthUI.this.startTime, 1, SDKOAuthUI.this.accountType, 1, 1, 0);
                                    SDKOAuthUI.a(SDKOAuthUI.this, buo.vGi);
                                    AppMethodBeat.o(7531);
                                }
                            }
                        });
                        AppMethodBeat.o(7532);
                    }
                });
                findViewById(R.id.l_).setVisibility(0);
                AppMethodBeat.o(7557);
            } else if (ag.a(buo)) {
                TextView textView2 = (TextView) findViewById(R.id.e67);
                Iterator it = buo.wIK.iterator();
                while (it.hasNext()) {
                    bew bew = (bew) it.next();
                    if (ag.a(buo)) {
                        textView2.setText(bew.desc);
                    }
                }
                textView2.getPaint().setFakeBoldText(true);
                imageView = (ImageView) findViewById(R.id.e65);
                textView = (TextView) findViewById(R.id.e66);
                aVar2 = new com.tencent.mm.at.a.a.c.a();
                aVar2.ePT = R.raw.native_oauth_default_head_img;
                aVar2.eQg = getResources().getDimension(R.dimen.a7u);
                aVar2.eQf = true;
                o.ahp().a(buo.wIL, imageView, aVar2.ahG());
                textView.setText(buo.fhH);
                Button button = (Button) findViewById(R.id.e6c);
                ((Button) findViewById(R.id.e6b)).setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(7533);
                        SDKOAuthUI.a(SDKOAuthUI.this, buo);
                        AppMethodBeat.o(7533);
                    }
                });
                button.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(7534);
                        SDKOAuthUI.this.usN;
                        bew d = ag.d("snsapi_userinfo", buo.wIK);
                        if (d == null) {
                            SDKOAuthUI.this.usN;
                            d = ag.d("snsapi_login", buo.wIK);
                        }
                        if (d == null) {
                            SDKOAuthUI.this.usN;
                            d = ag.d("group_sns_login", buo.wIK);
                        }
                        com.tencent.mm.plugin.webview.e.a aVar = com.tencent.mm.plugin.webview.e.a.uKJ;
                        com.tencent.mm.plugin.webview.e.a.a(SDKOAuthUI.this.mAppId, SDKOAuthUI.this.startTime, 0, SDKOAuthUI.this.accountType, 2, 1, 0);
                        SDKOAuthUI.a(SDKOAuthUI.this, d, buo);
                        AppMethodBeat.o(7534);
                    }
                });
                usH = buo.wPS;
                this.usL = new com.tencent.mm.ui.widget.b.a(this);
                this.usK = new b(this, buo.wPQ, buo.wPT);
                cZF();
                listView = (ListView) findViewById(R.id.c9t);
                listView.setAdapter(this.usK);
                listView.setOnItemClickListener(new OnItemClickListener() {
                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        AppMethodBeat.i(7535);
                        SDKOAuthUI.this.usK.usY = SDKOAuthUI.this.usK.Jm(i).id;
                        SDKOAuthUI.this.usK.notifyDataSetChanged();
                        AppMethodBeat.o(7535);
                    }
                });
                listView.setOnTouchListener(new OnTouchListener() {
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        AppMethodBeat.i(7536);
                        switch (motionEvent.getAction()) {
                            case 0:
                                SDKOAuthUI.this.jLX = (int) motionEvent.getRawX();
                                SDKOAuthUI.this.jLY = (int) motionEvent.getRawY();
                                break;
                        }
                        AppMethodBeat.o(7536);
                        return false;
                    }
                });
                listView.setOnItemLongClickListener(new OnItemLongClickListener() {
                    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                        AppMethodBeat.i(7537);
                        SDKOAuthUI.this.usG = i;
                        int i2 = SDKOAuthUI.this.usK.Jm(i).id;
                        if (!(i2 == 0 || i2 == 1)) {
                            SDKOAuthUI.this.usL.a(view, i, j, SDKOAuthUI.this, SDKOAuthUI.this.jOb, SDKOAuthUI.this.jLX, SDKOAuthUI.this.jLY);
                        }
                        AppMethodBeat.o(7537);
                        return true;
                    }
                });
                findViewById(R.id.e69).setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(7538);
                        Intent intent = new Intent(SDKOAuthUI.this, CreateAvatarUI.class);
                        intent.putExtra(AppEventsConstants.EVENT_PARAM_VALUE_NO, SDKOAuthUI.this.mAppId);
                        intent.putExtra("default_fileid", SDKOAuthUI.this.usP);
                        SDKOAuthUI.this.startActivityForResult(intent, 6);
                        AppMethodBeat.o(7538);
                    }
                });
                this.usM = buo.wPR;
                if (buo.wPR) {
                    findViewById(R.id.e68).setVisibility(8);
                }
                findViewById(R.id.e64).setVisibility(0);
                AppMethodBeat.o(7557);
            } else if (ag.d("snsapi_friend", buo.wIK) != null) {
                a(buo, SDKOAuthFriendUI.class);
                ag.ag(this);
                AppMethodBeat.o(7557);
            } else {
                a(buo, SDKOAuthOtherUI.class);
                ag.ag(this);
                AppMethodBeat.o(7557);
            }
        } else if (II(i)) {
            aVar = com.tencent.mm.plugin.webview.e.a.uKJ;
            com.tencent.mm.plugin.webview.e.a.a(this.mAppId, this.startTime, 2, this.accountType, 0, 0, i2);
            bH(str, true);
            AppMethodBeat.o(7557);
        } else {
            bH(getString(R.string.g0b), true);
            aVar = com.tencent.mm.plugin.webview.e.a.uKJ;
            com.tencent.mm.plugin.webview.e.a.a(this.mAppId, this.startTime, 2, this.accountType, 0, 0, i2);
            AppMethodBeat.o(7557);
        }
    }

    private int cZE() {
        return this.usO ? 2 : 1;
    }

    private void afA(String str) {
        String str2 = null;
        AppMethodBeat.i(7558);
        ab.i("MicroMsg.SdkOAuthUI", "dealWithLoginCallback url : %s", str);
        String aer = aer(this.mAppId);
        if (bo.isNullOrNil(aer)) {
            ab.e("MicroMsg.SdkOAuthUI", "dealWithLoginCallback pkg nil");
            AppMethodBeat.o(7558);
            return;
        }
        Uri uri;
        Resp resp = new Resp();
        resp.transaction = this.usF.transaction;
        resp.lang = cXI();
        resp.country = getCountry();
        if (bo.isNullOrNil(str)) {
            uri = null;
        } else {
            uri = Uri.parse(str);
        }
        if (uri != null) {
            str2 = uri.getQueryParameter(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
            resp.state = uri.getQueryParameter("state");
            resp.errStr = uri.getQueryParameter("reason");
        }
        if (bo.isNullOrNil(str2)) {
            resp.errCode = -1;
        } else if (str2.toLowerCase().equals("authdeny")) {
            resp.errCode = -4;
        } else {
            resp.errCode = 0;
            resp.code = str2;
        }
        resp.url = str;
        ab.i("MicroMsg.SdkOAuthUI", "dealWithLoginCallback, pkg:%s code:%s errCode:%d state:%s", aer, resp.code, Integer.valueOf(resp.errCode), resp.state);
        a(aer, resp);
        finish();
        AppMethodBeat.o(7558);
    }

    private void IH(int i) {
        LinkedList linkedList = null;
        AppMethodBeat.i(7559);
        ab.i("MicroMsg.SdkOAuthUI", "dealWithCancel");
        if (this.usp) {
            g.Rg().a(new z(2, this.cOG, null, 0), 0);
            AppMethodBeat.o(7559);
        } else if (this.usF == null) {
            AppMethodBeat.o(7559);
        } else {
            String aer = aer(this.mAppId);
            String str = this.mAppId;
            String str2 = this.usF.state;
            if (this.usJ != null) {
                linkedList = this.usJ.cZG();
            }
            g.Rg().a(new com.tencent.mm.plugin.webview.model.ab(2, str, str2, aer, linkedList), 0);
            Resp resp = new Resp();
            resp.transaction = this.usF.transaction;
            resp.errCode = i;
            resp.lang = cXI();
            resp.country = getCountry();
            a(aer, resp);
            AppMethodBeat.o(7559);
        }
    }

    private void a(String str, Resp resp) {
        AppMethodBeat.i(7560);
        if (this.ump) {
            ab.i("MicroMsg.SdkOAuthUI", "doCallback has callback");
            AppMethodBeat.o(7560);
        } else if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(7560);
        } else {
            this.ump = true;
            Bundle bundle = new Bundle();
            resp.toBundle(bundle);
            com.tencent.mm.pluginsdk.model.app.p.at(bundle);
            Args args = new Args();
            args.targetPkgName = str;
            args.bundle = bundle;
            MMessageActV2.send(this, args);
            AppMethodBeat.o(7560);
        }
    }

    private void a(buo buo, Class<?> cls, int i, int i2) {
        AppMethodBeat.i(7561);
        Intent intent = new Intent(this, cls);
        intent.putExtra(AppEventsConstants.EVENT_PARAM_VALUE_NO, this.mAppId);
        if (this.usF != null) {
            intent.putExtra("1", this.usF.transaction);
            intent.putExtra("4", this.usF.state);
        }
        intent.putExtra(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, i);
        intent.putExtra("5", i2);
        intent.putExtra("auth_from_scan", this.usp);
        intent.putExtra("auth_raw_url", this.cOG);
        try {
            intent.putExtra("2", buo.toByteArray());
        } catch (IOException e) {
            ab.e("MicroMsg.SdkOAuthUI", "SdkOauthAuthorizeResp toByteArray failed");
        }
        startActivity(intent);
        AppMethodBeat.o(7561);
    }

    private void a(buo buo, Class<?> cls) {
        AppMethodBeat.i(7562);
        ab.i("MicroMsg.SdkOAuthUI", "startScopeActivity %s", cls.getSimpleName());
        Intent intent = new Intent(this, cls);
        intent.putExtra(AppEventsConstants.EVENT_PARAM_VALUE_NO, this.mAppId);
        if (this.usF != null) {
            intent.putExtra("1", this.usF.transaction);
            intent.putExtra("4", this.usF.state);
        }
        intent.putExtra("auth_from_scan", this.usp);
        intent.putExtra("auth_raw_url", this.cOG);
        try {
            intent.putExtra("2", buo.toByteArray());
        } catch (IOException e) {
            ab.e("MicroMsg.SdkOAuthUI", "SdkOauthAuthorizeResp toByteArray failed");
        }
        startActivity(intent);
        AppMethodBeat.o(7562);
    }

    private void cZF() {
        AppMethodBeat.i(7563);
        if (this.usM) {
            AppMethodBeat.o(7563);
        } else if (this.usK.getCount() >= usH) {
            findViewById(R.id.e69).setVisibility(8);
            findViewById(R.id.e6_).setVisibility(0);
            findViewById(R.id.e6a).setVisibility(4);
            AppMethodBeat.o(7563);
        } else {
            findViewById(R.id.e69).setVisibility(0);
            findViewById(R.id.e6_).setVisibility(8);
            findViewById(R.id.e6a).setVisibility(0);
            AppMethodBeat.o(7563);
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 1;
        AppMethodBeat.i(7564);
        ab.i("MicroMsg.SdkOAuthUI", "onAcvityResult requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i2 != -1) {
            ab.e("MicroMsg.SdkOAuthUI", "Create avatar cancel or failed");
            AppMethodBeat.o(7564);
            return;
        }
        switch (i) {
            case 6:
                bet bet = new bet();
                bet.id = intent.getIntExtra("id", -1);
                bet.nickname = intent.getStringExtra("nickname");
                bet.wrK = intent.getStringExtra("avatarurl");
                bet.desc = null;
                b bVar = this.usK;
                if (bet.id == -1 || bVar.usV.size() >= usH) {
                    i3 = 0;
                } else {
                    bVar.usV.add(bet);
                }
                if (i3 != 0) {
                    this.usK.usY = bet.id;
                    cZF();
                    this.usK.notifyDataSetChanged();
                    break;
                }
                break;
        }
        AppMethodBeat.o(7564);
    }

    private void bH(final String str, final boolean z) {
        AppMethodBeat.i(7565);
        h.a((Context) this, str, getString(R.string.g0a), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(7526);
                if (!SDKOAuthUI.this.usp) {
                    SDKOAuthUI.b(SDKOAuthUI.this, str);
                }
                if (z) {
                    SDKOAuthUI.this.finish();
                }
                AppMethodBeat.o(7526);
            }
        });
        AppMethodBeat.o(7565);
    }

    private void afB(String str) {
        AppMethodBeat.i(7566);
        h.b((Context) this, str, getString(R.string.d65), true);
        AppMethodBeat.o(7566);
    }

    private void cZw() {
        AppMethodBeat.i(7567);
        if (this.ejZ == null || this.ejZ.isShowing()) {
            this.ejZ = h.b((Context) this, getString(R.string.da2), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(7527);
                    try {
                        dialogInterface.dismiss();
                        AppMethodBeat.o(7527);
                    } catch (Exception e) {
                        ab.e("MicroMsg.SdkOAuthUI", "showProgressDlg onCancel exp: %s ", e.getLocalizedMessage());
                        AppMethodBeat.o(7527);
                    }
                }
            });
            AppMethodBeat.o(7567);
            return;
        }
        this.ejZ.show();
        AppMethodBeat.o(7567);
    }

    private void cZx() {
        AppMethodBeat.i(7568);
        if (this.ejZ == null) {
            AppMethodBeat.o(7568);
            return;
        }
        this.ejZ.dismiss();
        AppMethodBeat.o(7568);
    }

    private boolean II(int i) {
        AppMethodBeat.i(7569);
        if (i == 1 || i == 2 || i == 7 || i == 8) {
            ab.e("MicroMsg.SdkOAuthUI", "isNetworkAvailable false, errType = ".concat(String.valueOf(i)));
            AppMethodBeat.o(7569);
            return false;
        } else if (at.isConnected(this)) {
            AppMethodBeat.o(7569);
            return true;
        } else {
            ab.e("MicroMsg.SdkOAuthUI", "isNetworkAvailable false, not connected");
            AppMethodBeat.o(7569);
            return false;
        }
    }

    private String cXI() {
        AppMethodBeat.i(7570);
        String g = com.tencent.mm.sdk.platformtools.aa.g(getSharedPreferences(ah.doA(), 0));
        AppMethodBeat.o(7570);
        return g;
    }

    private static String getCountry() {
        AppMethodBeat.i(7571);
        String bc = bo.bc((String) g.RP().Ry().get(274436, null), null);
        AppMethodBeat.o(7571);
        return bc;
    }

    private static String aer(String str) {
        AppMethodBeat.i(7572);
        String str2 = null;
        com.tencent.mm.pluginsdk.model.app.f bT = com.tencent.mm.pluginsdk.model.app.g.bT(str, false);
        if (bT != null) {
            str2 = bT.field_packageName;
        } else {
            ab.w("MicroMsg.SdkOAuthUI", "dealWithCancel getAppInfo null; appid: %s", str);
        }
        AppMethodBeat.o(7572);
        return str2;
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        com.tencent.mm.plugin.webview.e.a aVar;
        com.tencent.mm.plugin.webview.e.a aVar2;
        AppMethodBeat.i(7573);
        if (mVar instanceof aa) {
            a(i, i2, str, (buo) ((aa) mVar).ehh.fsH.fsP);
        } else if (mVar instanceof com.tencent.mm.plugin.webview.model.ab) {
            ab.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeConfirmEnd errType:%d errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
            if (this.usI != null) {
                this.usI.stopTimer();
            }
            cZx();
            if (i == 0 && i2 == 0) {
                bum cXC = ((com.tencent.mm.plugin.webview.model.ab) mVar).cXC();
                aVar = com.tencent.mm.plugin.webview.e.a.uKJ;
                com.tencent.mm.plugin.webview.e.a.a(this.mAppId, this.startTime, 1, this.accountType, cZE(), 1, 0);
                afA(cXC.vGi);
            } else if (II(i)) {
                bH(str, false);
                aVar2 = com.tencent.mm.plugin.webview.e.a.uKJ;
                com.tencent.mm.plugin.webview.e.a.a(this.mAppId, this.startTime, 2, this.accountType, cZE(), 1, i2);
            } else {
                bH(getString(R.string.g0b), false);
                aVar2 = com.tencent.mm.plugin.webview.e.a.uKJ;
                com.tencent.mm.plugin.webview.e.a.a(this.mAppId, this.startTime, 2, this.accountType, cZE(), 1, i2);
            }
        } else if (mVar instanceof i) {
            ab.i("MicroMsg.SdkOAuthUI", "onAddAvatarEnd errType:%d errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
            if (i == 0 && i2 == 0) {
                if (this.usK.Jm(this.usG).id == this.usK.usY) {
                    this.usK.usY = this.usK.Jm(0).id;
                }
                b bVar = this.usK;
                if (!bVar.usV.remove(bVar.Jm(this.usG))) {
                    ab.e("MicroMsg.SdkOAuthUI", "remove avatar failed: not found");
                }
                cZF();
                this.usK.notifyDataSetChanged();
            } else if (II(i)) {
                afB(str);
            } else {
                afB(getString(R.string.g0b));
            }
        }
        if (mVar instanceof y) {
            Object obj;
            ab.i("MicroMsg.SdkOAuthUI", "onQRCodeOauthAuthorizeEnd errType:%d errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
            this.startTime = System.currentTimeMillis();
            if (i == 0 && i2 == 0) {
                bnb bnb = (bnb) ((y) mVar).ehh.fsH.fsP;
                this.mAppId = bnb.csB;
                this.usN.mAppId = bnb.csB;
                if (bnb.wPP) {
                    ab.i("MicroMsg.SdkOAuthUI", "fallback to h5");
                    obj = 1;
                    aVar = com.tencent.mm.plugin.webview.e.a.uKJ;
                    com.tencent.mm.plugin.webview.e.a.a(this.mAppId, this.startTime, 1, this.accountType, 0, 0, i2);
                    com.tencent.mm.bp.d.b(ah.getContext(), "webview", ".ui.tools.WebViewUI", getIntent());
                    ag.ag(this);
                } else {
                    buo buo;
                    if (bnb == null) {
                        buo = null;
                    } else {
                        buo buo2 = new buo();
                        buo2.BaseResponse = bnb.BaseResponse;
                        buo2.wIM = false;
                        buo2.wIN = false;
                        buo2.wWf = true;
                        buo2.wIO = false;
                        buo2.wIK = bnb.wIK;
                        buo2.fhH = bnb.fhH;
                        buo2.wIL = bnb.wIL;
                        buo2.vGi = "";
                        buo2.wPQ = bnb.wPQ;
                        buo2.wPR = bnb.wPR;
                        buo2.wPS = bnb.wPS;
                        buo2.wPT = bnb.wPT;
                        buo2.wPU = bnb.wPU;
                        buo2.wPV = bnb.wPV;
                        buo = buo2;
                    }
                    a(i, i2, str, buo);
                    obj = null;
                }
            } else if (II(i)) {
                aVar2 = com.tencent.mm.plugin.webview.e.a.uKJ;
                com.tencent.mm.plugin.webview.e.a.a(this.mAppId, this.startTime, 2, this.accountType, 0, 0, i2);
                bH(str, true);
                obj = null;
            } else {
                bH(getString(R.string.g0b), true);
                aVar2 = com.tencent.mm.plugin.webview.e.a.uKJ;
                com.tencent.mm.plugin.webview.e.a.a(this.mAppId, this.startTime, 2, this.accountType, 0, 0, i2);
                obj = null;
            }
            if (obj == null) {
                cZx();
            }
            AppMethodBeat.o(7573);
            return;
        }
        if (mVar instanceof z) {
            ab.i("MicroMsg.SdkOAuthUI", "onQRCodeOauthAuthorizeConfirmEnd errType:%d errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
            cZx();
            if (i == 0 && i2 == 0) {
                aVar2 = com.tencent.mm.plugin.webview.e.a.uKJ;
                com.tencent.mm.plugin.webview.e.a.a(this.mAppId, this.startTime, 1, this.accountType, cZE(), 1, 0);
                finish();
                AppMethodBeat.o(7573);
                return;
            } else if (II(i)) {
                bH(str, false);
                aVar2 = com.tencent.mm.plugin.webview.e.a.uKJ;
                com.tencent.mm.plugin.webview.e.a.a(this.mAppId, this.startTime, 2, this.accountType, cZE(), 1, i2);
            } else {
                bH(getString(R.string.g0b), false);
                aVar2 = com.tencent.mm.plugin.webview.e.a.uKJ;
                com.tencent.mm.plugin.webview.e.a.a(this.mAppId, this.startTime, 2, this.accountType, cZE(), 1, i2);
                AppMethodBeat.o(7573);
                return;
            }
        }
        AppMethodBeat.o(7573);
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(7574);
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        contextMenu.add(0, 1, 0, getString(R.string.d64));
        AppMethodBeat.o(7574);
    }

    static /* synthetic */ void a(SDKOAuthUI sDKOAuthUI, String str, String str2, String str3, LinkedList linkedList) {
        AppMethodBeat.i(7579);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < linkedList.size(); i++) {
            stringBuilder.append((String) linkedList.get(i)).append(",");
        }
        ab.i("MicroMsg.SdkOAuthUI", "doSDKOauthAuthorizeConfirm selectedScopes: %s", stringBuilder.toString());
        if (sDKOAuthUI.usI != null) {
            sDKOAuthUI.usI.stopTimer();
            sDKOAuthUI.usI.ae(3000, 3000);
        } else {
            sDKOAuthUI.usI = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
                public final boolean BI() {
                    AppMethodBeat.i(7528);
                    if (SDKOAuthUI.this.isFinishing()) {
                        ab.i("MicroMsg.SdkOAuthUI", "onTimerExpired isFinishing");
                        AppMethodBeat.o(7528);
                    } else {
                        SDKOAuthUI.p(SDKOAuthUI.this);
                        AppMethodBeat.o(7528);
                    }
                    return false;
                }
            }, false);
            sDKOAuthUI.usI.ae(3000, 3000);
        }
        g.Rg().a(new com.tencent.mm.plugin.webview.model.ab(1, str, str2, str3, linkedList), 0);
        AppMethodBeat.o(7579);
    }

    static /* synthetic */ void a(SDKOAuthUI sDKOAuthUI, bew bew, buo buo) {
        AppMethodBeat.i(7581);
        if (bew == null) {
            ab.e("MicroMsg.SdkOAuthUI", "fillNewOauthPage: do not get scope request for user info");
            AppMethodBeat.o(7581);
            return;
        }
        ab.i("MicroMsg.SdkOAuthUI", "disagreeBtnCallback click");
        if (bew.wIR == 3 || buo.wIK.size() == 1) {
            sDKOAuthUI.IH(-4);
            sDKOAuthUI.finish();
            AppMethodBeat.o(7581);
        } else if (ag.d("snsapi_friend", buo.wIK) != null) {
            sDKOAuthUI.a(buo, SDKOAuthFriendUI.class, -1, 8);
            ag.ag(sDKOAuthUI);
            AppMethodBeat.o(7581);
        } else {
            sDKOAuthUI.a(buo, SDKOAuthOtherUI.class, -1, 8);
            ag.ag(sDKOAuthUI);
            AppMethodBeat.o(7581);
        }
    }

    static /* synthetic */ void q(SDKOAuthUI sDKOAuthUI) {
        AppMethodBeat.i(7584);
        ab.i("MicroMsg.SdkOAuthUI", "doDelAvatar appid: %s", sDKOAuthUI.mAppId);
        g.Rg().a(new i(sDKOAuthUI.usK.Jm(sDKOAuthUI.usG).id), 0);
        AppMethodBeat.o(7584);
    }
}

package com.tencent.p177mm.plugin.webview.p580ui.tools;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.gdpr.C32791a;
import com.tencent.p177mm.model.gdpr.C32792b;
import com.tencent.p177mm.model.gdpr.C37918c;
import com.tencent.p177mm.opensdk.channel.MMessageActV2;
import com.tencent.p177mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.p177mm.opensdk.constants.ConstantsAPI;
import com.tencent.p177mm.opensdk.modelmsg.SendAuth.Req;
import com.tencent.p177mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p230g.p231a.C26152hh;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.widget.p1095b.C24088a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.webview.model.C29812ab;
import com.tencent.p177mm.plugin.webview.model.C35614y;
import com.tencent.p177mm.plugin.webview.model.C35615z;
import com.tencent.p177mm.plugin.webview.model.C40255aa;
import com.tencent.p177mm.plugin.webview.model.C43910ag;
import com.tencent.p177mm.plugin.webview.model.C43918i;
import com.tencent.p177mm.plugin.webview.p1068e.C22784a;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.protocal.protobuf.bet;
import com.tencent.p177mm.protocal.protobuf.bew;
import com.tencent.p177mm.protocal.protobuf.bnb;
import com.tencent.p177mm.protocal.protobuf.bum;
import com.tencent.p177mm.protocal.protobuf.buo;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI */
public final class SDKOAuthUI extends MMActivity implements C1202f {
    private static int usH;
    private int accountType = 2;
    private String cOG;
    private C44275p ejZ;
    private int jLX;
    private int jLY;
    private C5279d jOb = new C356356();
    private String mAppId;
    private long startTime;
    private boolean ump;
    private Req usF;
    private int usG;
    private C7564ap usI;
    private C40285a usJ;
    private C35636b usK;
    private C24088a usL;
    private boolean usM;
    private C43910ag usN;
    private boolean usO = true;
    private String usP;
    private boolean usp = false;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI$11 */
    class C1456211 implements OnItemClickListener {
        C1456211() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(7535);
            SDKOAuthUI.this.usK.usY = SDKOAuthUI.this.usK.mo56344Jm(i).f2978id;
            SDKOAuthUI.this.usK.notifyDataSetChanged();
            AppMethodBeat.m2505o(7535);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI$13 */
    class C1456313 implements OnItemLongClickListener {
        C1456313() {
        }

        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(7537);
            SDKOAuthUI.this.usG = i;
            int i2 = SDKOAuthUI.this.usK.mo56344Jm(i).f2978id;
            if (!(i2 == 0 || i2 == 1)) {
                SDKOAuthUI.this.usL.mo39885a(view, i, j, SDKOAuthUI.this, SDKOAuthUI.this.jOb, SDKOAuthUI.this.jLX, SDKOAuthUI.this.jLY);
            }
            AppMethodBeat.m2505o(7537);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI$1 */
    class C229251 implements Runnable {
        C229251() {
        }

        public final void run() {
            AppMethodBeat.m2504i(7524);
            C4990ab.m7416i("MicroMsg.SdkOAuthUI", "BackBtn click");
            C22784a c22784a = C22784a.uKJ;
            C22784a.m34564a(SDKOAuthUI.this.mAppId, SDKOAuthUI.this.startTime, 0, SDKOAuthUI.this.accountType, SDKOAuthUI.m78824d(SDKOAuthUI.this), 1, 0);
            SDKOAuthUI.m78810a(SDKOAuthUI.this, -2);
            SDKOAuthUI.this.finish();
            AppMethodBeat.m2505o(7524);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI$12 */
    class C2986612 implements OnTouchListener {
        C2986612() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(7536);
            switch (motionEvent.getAction()) {
                case 0:
                    SDKOAuthUI.this.jLX = (int) motionEvent.getRawX();
                    SDKOAuthUI.this.jLY = (int) motionEvent.getRawY();
                    break;
            }
            AppMethodBeat.m2505o(7536);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI$4 */
    class C356334 implements OnCancelListener {
        C356334() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(7527);
            try {
                dialogInterface.dismiss();
                AppMethodBeat.m2505o(7527);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.SdkOAuthUI", "showProgressDlg onCancel exp: %s ", e.getLocalizedMessage());
                AppMethodBeat.m2505o(7527);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI$5 */
    class C356345 implements C5015a {
        C356345() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(7528);
            if (SDKOAuthUI.this.isFinishing()) {
                C4990ab.m7416i("MicroMsg.SdkOAuthUI", "onTimerExpired isFinishing");
                AppMethodBeat.m2505o(7528);
            } else {
                SDKOAuthUI.m78837p(SDKOAuthUI.this);
                AppMethodBeat.m2505o(7528);
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI$6 */
    class C356356 implements C5279d {
        C356356() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(7529);
            SDKOAuthUI.m78838q(SDKOAuthUI.this);
            AppMethodBeat.m2505o(7529);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI$b */
    static final class C35636b extends BaseAdapter {
        private LayoutInflater mInflater;
        LinkedList<bet> usV;
        private C17927a usW = new C17927a();
        private Context usX;
        private int usY;

        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI$b$a */
        static final class C29869a {
            ImageView usZ;
            TextView uta;
            TextView utb;
            ImageView utc;

            private C29869a() {
            }

            /* synthetic */ C29869a(byte b) {
                this();
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(7550);
            bet Jm = mo56344Jm(i);
            AppMethodBeat.m2505o(7550);
            return Jm;
        }

        public C35636b(Context context, LinkedList<bet> linkedList, int i) {
            AppMethodBeat.m2504i(7546);
            this.usX = context;
            this.mInflater = LayoutInflater.from(context);
            this.usV = linkedList;
            C17927a c17927a = this.usW;
            c17927a.eQf = true;
            c17927a.eQg = this.usX.getResources().getDimension(C25738R.dimen.a7t);
            this.usY = i;
            AppMethodBeat.m2505o(7546);
        }

        public final int getCount() {
            AppMethodBeat.m2504i(7547);
            if (this.usV == null) {
                AppMethodBeat.m2505o(7547);
                return 0;
            }
            int size = this.usV.size();
            AppMethodBeat.m2505o(7547);
            return size;
        }

        /* renamed from: Jm */
        public final bet mo56344Jm(int i) {
            AppMethodBeat.m2504i(7548);
            if (i < 0 || i >= this.usV.size()) {
                AppMethodBeat.m2505o(7548);
                return null;
            }
            bet bet = (bet) this.usV.get(i);
            AppMethodBeat.m2505o(7548);
            return bet;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(7549);
            bet Jm = mo56344Jm(i);
            if (Jm == null) {
                AppMethodBeat.m2505o(7549);
            } else {
                C29869a c29869a;
                if (view == null) {
                    C29869a c29869a2 = new C29869a();
                    view = this.mInflater.inflate(2130968792, null, false);
                    c29869a2.usZ = (ImageView) view.findViewById(2131821558);
                    c29869a2.uta = (TextView) view.findViewById(2131821559);
                    c29869a2.utb = (TextView) view.findViewById(2131821560);
                    c29869a2.utc = (ImageView) view.findViewById(2131821561);
                    view.setTag(c29869a2);
                    c29869a = c29869a2;
                } else {
                    c29869a = (C29869a) view.getTag();
                }
                c29869a.uta.setText(Jm.nickname);
                C32291o.ahp().mo43766a(Jm.wrK, c29869a.usZ, this.usW.ahG());
                if (Jm.desc != null) {
                    c29869a.utb.setText(Jm.desc);
                    c29869a.utb.setVisibility(0);
                } else {
                    c29869a.utb.setVisibility(8);
                }
                if (Jm.f2978id == this.usY) {
                    c29869a.utc.setVisibility(0);
                } else {
                    c29869a.utc.setVisibility(4);
                }
                AppMethodBeat.m2505o(7549);
            }
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI$a */
    static final class C40285a extends BaseAdapter {
        private LayoutInflater mInflater;
        private LinkedList<bew> usA;

        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI$a$a */
        static final class C40286a {
            TextView jbS;
            ImageView usE;

            private C40286a() {
            }

            /* synthetic */ C40286a(byte b) {
                this();
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(7545);
            bew Jl = m69081Jl(i);
            AppMethodBeat.m2505o(7545);
            return Jl;
        }

        public C40285a(Context context, LinkedList<bew> linkedList) {
            AppMethodBeat.m2504i(7540);
            this.mInflater = LayoutInflater.from(context);
            this.usA = linkedList;
            AppMethodBeat.m2505o(7540);
        }

        public final LinkedList<String> cZG() {
            AppMethodBeat.m2504i(7541);
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
                    AppMethodBeat.m2505o(7541);
                    return linkedList;
                }
            }
        }

        public final int getCount() {
            AppMethodBeat.m2504i(7542);
            if (this.usA == null) {
                AppMethodBeat.m2505o(7542);
                return 0;
            }
            int size = this.usA.size();
            AppMethodBeat.m2505o(7542);
            return size;
        }

        /* renamed from: Jl */
        private bew m69081Jl(int i) {
            AppMethodBeat.m2504i(7543);
            if (i < 0 || i >= this.usA.size()) {
                AppMethodBeat.m2505o(7543);
                return null;
            }
            bew bew = (bew) this.usA.get(i);
            AppMethodBeat.m2505o(7543);
            return bew;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(7544);
            if (this.usA == null || this.usA.size() <= 0) {
                AppMethodBeat.m2505o(7544);
                return null;
            }
            final bew Jl = m69081Jl(i);
            if (Jl == null) {
                AppMethodBeat.m2505o(7544);
                return view;
            }
            C40286a c40286a;
            if (view == null) {
                C40286a c40286a2 = new C40286a();
                view = this.mInflater.inflate(2130970558, null, false);
                c40286a2.usE = (ImageView) view.findViewById(2131821546);
                c40286a2.jbS = (TextView) view.findViewById(2131821547);
                view.setTag(c40286a2);
                c40286a = c40286a2;
            } else {
                c40286a = (C40286a) view.getTag();
            }
            if (Jl.wIR == 1) {
                c40286a.usE.setImageResource(C1318a.login_auth_state_not_selected);
            } else if (Jl.wIR == 3) {
                c40286a.usE.setImageResource(C1318a.login_auth_state_must_select);
            } else {
                c40286a.usE.setImageResource(C1318a.login_auth_state_default_select);
            }
            c40286a.jbS.setText(Jl.desc);
            final ImageView imageView = c40286a.usE;
            c40286a.usE.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(7539);
                    if (Jl.wIR == 2) {
                        imageView.setImageResource(C1318a.login_auth_state_not_selected);
                        Jl.wIR = 1;
                        AppMethodBeat.m2505o(7539);
                        return;
                    }
                    if (Jl.wIR == 1) {
                        imageView.setImageResource(C1318a.login_auth_state_default_select);
                        Jl.wIR = 2;
                    }
                    AppMethodBeat.m2505o(7539);
                }
            });
            AppMethodBeat.m2505o(7544);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI$14 */
    class C4393414 implements OnClickListener {
        C4393414() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(7538);
            Intent intent = new Intent(SDKOAuthUI.this, CreateAvatarUI.class);
            intent.putExtra(AppEventsConstants.EVENT_PARAM_VALUE_NO, SDKOAuthUI.this.mAppId);
            intent.putExtra("default_fileid", SDKOAuthUI.this.usP);
            SDKOAuthUI.this.startActivityForResult(intent, 6);
            AppMethodBeat.m2505o(7538);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SDKOAuthUI() {
        AppMethodBeat.m2504i(7551);
        AppMethodBeat.m2505o(7551);
    }

    static /* synthetic */ String afC(String str) {
        AppMethodBeat.m2504i(7578);
        String aer = SDKOAuthUI.aer(str);
        AppMethodBeat.m2505o(7578);
        return aer;
    }

    /* renamed from: d */
    static /* synthetic */ int m78824d(SDKOAuthUI sDKOAuthUI) {
        AppMethodBeat.m2504i(7575);
        int cZE = sDKOAuthUI.cZE();
        AppMethodBeat.m2505o(7575);
        return cZE;
    }

    /* renamed from: p */
    static /* synthetic */ void m78837p(SDKOAuthUI sDKOAuthUI) {
        AppMethodBeat.m2504i(7583);
        sDKOAuthUI.cZw();
        AppMethodBeat.m2505o(7583);
    }

    public final void onCreate(Bundle bundle) {
        String str = null;
        AppMethodBeat.m2504i(7552);
        super.onCreate(bundle);
        mo17446xE(getResources().getColor(C25738R.color.f11677d4));
        dyb();
        setMMTitle(getString(C25738R.string.d6d));
        mo17427pP(false);
        mo17392b(null, new C229251());
        if (C1720g.m3531RK()) {
            this.ump = false;
            Intent intent = getIntent();
            this.usp = intent.getBooleanExtra("auth_from_scan", false);
            if (this.usp) {
                this.accountType = 3;
                this.cOG = intent.getStringExtra("auth_raw_url");
                C4990ab.m7417i("MicroMsg.SdkOAuthUI", "doQRCodeOauthAuthorize url: %s", this.cOG);
                cZw();
                C1720g.m3540Rg().mo14541a(new C35614y(r0), 0);
                this.usN = new C43910ag(this, null, this.cOG);
                AppMethodBeat.m2505o(7552);
                return;
            }
            Bundle extras = getIntent().getExtras();
            String string = extras.getString(ConstantsAPI.CONTENT);
            if (C5046bo.isNullOrNil(string)) {
                C4990ab.m7412e("MicroMsg.SdkOAuthUI", "init content is nil");
                AppMethodBeat.m2505o(7552);
                return;
            }
            this.mAppId = Uri.parse(string).getQueryParameter("appid");
            if (C5046bo.isNullOrNil(this.mAppId)) {
                C4990ab.m7417i("MicroMsg.SdkOAuthUI", "parseAppId try case not sensitive, content:%s", string);
                this.mAppId = Uri.parse(string.toLowerCase()).getQueryParameter("appid");
            }
            string = this.mAppId;
            C40439f bT = C46494g.m87739bT(string, false);
            if (bT != null && C5046bo.isNullOrNil(bT.field_openId)) {
                C4990ab.m7417i("MicroMsg.SdkOAuthUI", "checkGetAppSetting appId: %s ", string);
                C26152hh c26152hh = new C26152hh();
                c26152hh.cCd.appId = string;
                C4879a.xxA.mo10055m(c26152hh);
            }
            this.usF = new Req(extras);
            this.usN = new C43910ag(this, this.mAppId, this.usF.transaction, this.usF.state);
            string = this.mAppId;
            String str2 = this.usF.scope;
            String str3 = this.usF.state;
            String aer = SDKOAuthUI.aer(this.mAppId);
            C4990ab.m7417i("MicroMsg.SdkOAuthUI", "doSDKOauthAuthorize appid: %s", string);
            cZw();
            if (!C5046bo.isNullOrNil(aer)) {
                Signature[] bx = C35799p.m58691bx(this, aer);
                if (bx == null || bx.length == 0) {
                    C4990ab.m7412e("MicroMsg.SdkOAuthUI", "getSignature signatures failed");
                } else {
                    str = C1178g.m2591x(bx[0].toByteArray());
                }
            }
            C1720g.m3540Rg().mo14541a(new C40255aa(string, str2, str3, aer, str), 0);
            AppMethodBeat.m2505o(7552);
            return;
        }
        C4990ab.m7412e("MicroMsg.SdkOAuthUI", "start, hasSetUin fail");
        Toast.makeText(this, C25738R.string.f8692c7, 1).show();
        AppMethodBeat.m2505o(7552);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(7553);
        super.onResume();
        C1720g.m3540Rg().mo14539a(1346, (C1202f) this);
        C1720g.m3540Rg().mo14539a(1388, (C1202f) this);
        C1720g.m3540Rg().mo14539a(2700, (C1202f) this);
        C1720g.m3540Rg().mo14539a(2543, (C1202f) this);
        C1720g.m3540Rg().mo14539a(1137, (C1202f) this);
        AppMethodBeat.m2505o(7553);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(7554);
        super.onPause();
        C1720g.m3540Rg().mo14546b(1388, (C1202f) this);
        C1720g.m3540Rg().mo14546b(1346, (C1202f) this);
        C1720g.m3540Rg().mo14546b(2700, (C1202f) this);
        C1720g.m3540Rg().mo14546b(2543, (C1202f) this);
        C1720g.m3540Rg().mo14546b(1137, (C1202f) this);
        AppMethodBeat.m2505o(7554);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(7555);
        super.onDestroy();
        if (this.ejZ != null) {
            this.ejZ.dismiss();
        }
        if (this.usI != null) {
            this.usI.stopTimer();
        }
        AppMethodBeat.m2505o(7555);
    }

    public final int getLayoutId() {
        return 2130970560;
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(7556);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            C22784a c22784a = C22784a.uKJ;
            C22784a.m34564a(this.mAppId, this.startTime, 0, this.accountType, cZE(), 1, 0);
            m78806IH(-2);
            C4990ab.m7416i("MicroMsg.SdkOAuthUI", "key back click");
            finish();
            AppMethodBeat.m2505o(7556);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(7556);
        return onKeyDown;
    }

    /* renamed from: a */
    private void m78809a(int i, int i2, String str, final buo buo) {
        AppMethodBeat.m2504i(7557);
        C4990ab.m7417i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd errType:%d errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        cZx();
        this.startTime = System.currentTimeMillis();
        C22784a c22784a;
        if (i == 0 && i2 == 0) {
            C4990ab.m7417i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd is_use_newpage %b", Boolean.valueOf(buo.wWf));
            this.usP = buo.wPV;
            ImageView imageView;
            TextView textView;
            C17927a c17927a;
            ListView listView;
            if (buo.wIM || buo.wIN) {
                C4990ab.m7416i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd direct login");
                C37918c.m64041a(this, C32791a.OPENSDK, this.mAppId, new C32792b() {
                    /* renamed from: kL */
                    public final void mo8219kL(int i) {
                        AppMethodBeat.m2504i(7530);
                        C4990ab.m7417i("MicroMsg.SdkOAuthUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", Integer.valueOf(i));
                        C22784a c22784a;
                        if (i == 1) {
                            SDKOAuthUI.m78810a(SDKOAuthUI.this, -4);
                            c22784a = C22784a.uKJ;
                            C22784a.m34564a(SDKOAuthUI.this.mAppId, SDKOAuthUI.this.startTime, 0, SDKOAuthUI.this.accountType, 0, 0, 0);
                            SDKOAuthUI.this.finish();
                            AppMethodBeat.m2505o(7530);
                            return;
                        }
                        SDKOAuthUI.m78813a(SDKOAuthUI.this, buo.vGi);
                        c22784a = C22784a.uKJ;
                        C22784a.m34564a(SDKOAuthUI.this.mAppId, SDKOAuthUI.this.startTime, 1, SDKOAuthUI.this.accountType, 0, 0, 0);
                        AppMethodBeat.m2505o(7530);
                    }
                });
                AppMethodBeat.m2505o(7557);
            } else if (!buo.wWf) {
                this.usO = false;
                imageView = (ImageView) findViewById(2131821137);
                textView = (TextView) findViewById(2131821138);
                c17927a = new C17927a();
                c17927a.ePT = C1318a.native_oauth_default_head_img;
                C32291o.ahp().mo43766a(buo.wIL, imageView, c17927a.ahG());
                textView.setText(buo.fhH);
                listView = (ListView) findViewById(2131821140);
                this.usJ = new C40285a(this, buo.wIK);
                listView.setAdapter(this.usJ);
                ((Button) findViewById(2131825292)).setOnClickListener(new OnClickListener() {

                    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI$8$1 */
                    class C145651 implements C32792b {
                        C145651() {
                        }

                        /* renamed from: kL */
                        public final void mo8219kL(int i) {
                            AppMethodBeat.m2504i(7531);
                            C4990ab.m7417i("MicroMsg.SdkOAuthUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", Integer.valueOf(i));
                            C22784a c22784a;
                            if (i == 1) {
                                SDKOAuthUI.m78810a(SDKOAuthUI.this, -4);
                                c22784a = C22784a.uKJ;
                                C22784a.m34564a(SDKOAuthUI.this.mAppId, SDKOAuthUI.this.startTime, 0, SDKOAuthUI.this.accountType, 1, 1, 0);
                                SDKOAuthUI.this.finish();
                                AppMethodBeat.m2505o(7531);
                            } else if (buo.wIO) {
                                SDKOAuthUI.m78814a(SDKOAuthUI.this, SDKOAuthUI.this.mAppId, SDKOAuthUI.this.usF.state, SDKOAuthUI.afC(SDKOAuthUI.this.mAppId), SDKOAuthUI.this.usJ.cZG());
                                AppMethodBeat.m2505o(7531);
                            } else {
                                c22784a = C22784a.uKJ;
                                C22784a.m34564a(SDKOAuthUI.this.mAppId, SDKOAuthUI.this.startTime, 1, SDKOAuthUI.this.accountType, 1, 1, 0);
                                SDKOAuthUI.m78813a(SDKOAuthUI.this, buo.vGi);
                                AppMethodBeat.m2505o(7531);
                            }
                        }
                    }

                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(7532);
                        C4990ab.m7416i("MicroMsg.SdkOAuthUI", "accept go  MPGdprPolicyUtil.checkPolicy");
                        C37918c.m64041a(SDKOAuthUI.this, C32791a.OPENSDK, SDKOAuthUI.this.mAppId, new C145651());
                        AppMethodBeat.m2505o(7532);
                    }
                });
                findViewById(2131820987).setVisibility(0);
                AppMethodBeat.m2505o(7557);
            } else if (C43910ag.m78758a(buo)) {
                TextView textView2 = (TextView) findViewById(2131827247);
                Iterator it = buo.wIK.iterator();
                while (it.hasNext()) {
                    bew bew = (bew) it.next();
                    if (C43910ag.m78758a(buo)) {
                        textView2.setText(bew.desc);
                    }
                }
                textView2.getPaint().setFakeBoldText(true);
                imageView = (ImageView) findViewById(2131827245);
                textView = (TextView) findViewById(2131827246);
                c17927a = new C17927a();
                c17927a.ePT = C1318a.native_oauth_default_head_img;
                c17927a.eQg = getResources().getDimension(C25738R.dimen.a7u);
                c17927a.eQf = true;
                C32291o.ahp().mo43766a(buo.wIL, imageView, c17927a.ahG());
                textView.setText(buo.fhH);
                Button button = (Button) findViewById(2131827253);
                ((Button) findViewById(2131827252)).setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(7533);
                        SDKOAuthUI.m78812a(SDKOAuthUI.this, buo);
                        AppMethodBeat.m2505o(7533);
                    }
                });
                button.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(7534);
                        SDKOAuthUI.this.usN;
                        bew d = C43910ag.m78760d("snsapi_userinfo", buo.wIK);
                        if (d == null) {
                            SDKOAuthUI.this.usN;
                            d = C43910ag.m78760d("snsapi_login", buo.wIK);
                        }
                        if (d == null) {
                            SDKOAuthUI.this.usN;
                            d = C43910ag.m78760d("group_sns_login", buo.wIK);
                        }
                        C22784a c22784a = C22784a.uKJ;
                        C22784a.m34564a(SDKOAuthUI.this.mAppId, SDKOAuthUI.this.startTime, 0, SDKOAuthUI.this.accountType, 2, 1, 0);
                        SDKOAuthUI.m78811a(SDKOAuthUI.this, d, buo);
                        AppMethodBeat.m2505o(7534);
                    }
                });
                usH = buo.wPS;
                this.usL = new C24088a(this);
                this.usK = new C35636b(this, buo.wPQ, buo.wPT);
                cZF();
                listView = (ListView) findViewById(2131824644);
                listView.setAdapter(this.usK);
                listView.setOnItemClickListener(new C1456211());
                listView.setOnTouchListener(new C2986612());
                listView.setOnItemLongClickListener(new C1456313());
                findViewById(2131827249).setOnClickListener(new C4393414());
                this.usM = buo.wPR;
                if (buo.wPR) {
                    findViewById(2131827248).setVisibility(8);
                }
                findViewById(2131827244).setVisibility(0);
                AppMethodBeat.m2505o(7557);
            } else if (C43910ag.m78760d("snsapi_friend", buo.wIK) != null) {
                m78815a(buo, SDKOAuthFriendUI.class);
                C43910ag.m78759ag(this);
                AppMethodBeat.m2505o(7557);
            } else {
                m78815a(buo, SDKOAuthOtherUI.class);
                C43910ag.m78759ag(this);
                AppMethodBeat.m2505o(7557);
            }
        } else if (m78807II(i)) {
            c22784a = C22784a.uKJ;
            C22784a.m34564a(this.mAppId, this.startTime, 2, this.accountType, 0, 0, i2);
            m78821bH(str, true);
            AppMethodBeat.m2505o(7557);
        } else {
            m78821bH(getString(C25738R.string.g0b), true);
            c22784a = C22784a.uKJ;
            C22784a.m34564a(this.mAppId, this.startTime, 2, this.accountType, 0, 0, i2);
            AppMethodBeat.m2505o(7557);
        }
    }

    private int cZE() {
        return this.usO ? 2 : 1;
    }

    private void afA(String str) {
        String str2 = null;
        AppMethodBeat.m2504i(7558);
        C4990ab.m7417i("MicroMsg.SdkOAuthUI", "dealWithLoginCallback url : %s", str);
        String aer = SDKOAuthUI.aer(this.mAppId);
        if (C5046bo.isNullOrNil(aer)) {
            C4990ab.m7412e("MicroMsg.SdkOAuthUI", "dealWithLoginCallback pkg nil");
            AppMethodBeat.m2505o(7558);
            return;
        }
        Uri uri;
        Resp resp = new Resp();
        resp.transaction = this.usF.transaction;
        resp.lang = cXI();
        resp.country = SDKOAuthUI.getCountry();
        if (C5046bo.isNullOrNil(str)) {
            uri = null;
        } else {
            uri = Uri.parse(str);
        }
        if (uri != null) {
            str2 = uri.getQueryParameter(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
            resp.state = uri.getQueryParameter("state");
            resp.errStr = uri.getQueryParameter("reason");
        }
        if (C5046bo.isNullOrNil(str2)) {
            resp.errCode = -1;
        } else if (str2.toLowerCase().equals("authdeny")) {
            resp.errCode = -4;
        } else {
            resp.errCode = 0;
            resp.code = str2;
        }
        resp.url = str;
        C4990ab.m7417i("MicroMsg.SdkOAuthUI", "dealWithLoginCallback, pkg:%s code:%s errCode:%d state:%s", aer, resp.code, Integer.valueOf(resp.errCode), resp.state);
        m78817a(aer, resp);
        finish();
        AppMethodBeat.m2505o(7558);
    }

    /* renamed from: IH */
    private void m78806IH(int i) {
        LinkedList linkedList = null;
        AppMethodBeat.m2504i(7559);
        C4990ab.m7416i("MicroMsg.SdkOAuthUI", "dealWithCancel");
        if (this.usp) {
            C1720g.m3540Rg().mo14541a(new C35615z(2, this.cOG, null, 0), 0);
            AppMethodBeat.m2505o(7559);
        } else if (this.usF == null) {
            AppMethodBeat.m2505o(7559);
        } else {
            String aer = SDKOAuthUI.aer(this.mAppId);
            String str = this.mAppId;
            String str2 = this.usF.state;
            if (this.usJ != null) {
                linkedList = this.usJ.cZG();
            }
            C1720g.m3540Rg().mo14541a(new C29812ab(2, str, str2, aer, linkedList), 0);
            Resp resp = new Resp();
            resp.transaction = this.usF.transaction;
            resp.errCode = i;
            resp.lang = cXI();
            resp.country = SDKOAuthUI.getCountry();
            m78817a(aer, resp);
            AppMethodBeat.m2505o(7559);
        }
    }

    /* renamed from: a */
    private void m78817a(String str, Resp resp) {
        AppMethodBeat.m2504i(7560);
        if (this.ump) {
            C4990ab.m7416i("MicroMsg.SdkOAuthUI", "doCallback has callback");
            AppMethodBeat.m2505o(7560);
        } else if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(7560);
        } else {
            this.ump = true;
            Bundle bundle = new Bundle();
            resp.toBundle(bundle);
            C35799p.m58687at(bundle);
            Args args = new Args();
            args.targetPkgName = str;
            args.bundle = bundle;
            MMessageActV2.send(this, args);
            AppMethodBeat.m2505o(7560);
        }
    }

    /* renamed from: a */
    private void m78816a(buo buo, Class<?> cls, int i, int i2) {
        AppMethodBeat.m2504i(7561);
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
            C4990ab.m7412e("MicroMsg.SdkOAuthUI", "SdkOauthAuthorizeResp toByteArray failed");
        }
        startActivity(intent);
        AppMethodBeat.m2505o(7561);
    }

    /* renamed from: a */
    private void m78815a(buo buo, Class<?> cls) {
        AppMethodBeat.m2504i(7562);
        C4990ab.m7417i("MicroMsg.SdkOAuthUI", "startScopeActivity %s", cls.getSimpleName());
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
            C4990ab.m7412e("MicroMsg.SdkOAuthUI", "SdkOauthAuthorizeResp toByteArray failed");
        }
        startActivity(intent);
        AppMethodBeat.m2505o(7562);
    }

    private void cZF() {
        AppMethodBeat.m2504i(7563);
        if (this.usM) {
            AppMethodBeat.m2505o(7563);
        } else if (this.usK.getCount() >= usH) {
            findViewById(2131827249).setVisibility(8);
            findViewById(2131827250).setVisibility(0);
            findViewById(2131827251).setVisibility(4);
            AppMethodBeat.m2505o(7563);
        } else {
            findViewById(2131827249).setVisibility(0);
            findViewById(2131827250).setVisibility(8);
            findViewById(2131827251).setVisibility(0);
            AppMethodBeat.m2505o(7563);
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 1;
        AppMethodBeat.m2504i(7564);
        C4990ab.m7417i("MicroMsg.SdkOAuthUI", "onAcvityResult requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i2 != -1) {
            C4990ab.m7412e("MicroMsg.SdkOAuthUI", "Create avatar cancel or failed");
            AppMethodBeat.m2505o(7564);
            return;
        }
        switch (i) {
            case 6:
                bet bet = new bet();
                bet.f2978id = intent.getIntExtra("id", -1);
                bet.nickname = intent.getStringExtra("nickname");
                bet.wrK = intent.getStringExtra("avatarurl");
                bet.desc = null;
                C35636b c35636b = this.usK;
                if (bet.f2978id == -1 || c35636b.usV.size() >= usH) {
                    i3 = 0;
                } else {
                    c35636b.usV.add(bet);
                }
                if (i3 != 0) {
                    this.usK.usY = bet.f2978id;
                    cZF();
                    this.usK.notifyDataSetChanged();
                    break;
                }
                break;
        }
        AppMethodBeat.m2505o(7564);
    }

    /* renamed from: bH */
    private void m78821bH(final String str, final boolean z) {
        AppMethodBeat.m2504i(7565);
        C30379h.m48438a((Context) this, str, getString(C25738R.string.g0a), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(7526);
                if (!SDKOAuthUI.this.usp) {
                    SDKOAuthUI.m78820b(SDKOAuthUI.this, str);
                }
                if (z) {
                    SDKOAuthUI.this.finish();
                }
                AppMethodBeat.m2505o(7526);
            }
        });
        AppMethodBeat.m2505o(7565);
    }

    private void afB(String str) {
        AppMethodBeat.m2504i(7566);
        C30379h.m48461b((Context) this, str, getString(C25738R.string.d65), true);
        AppMethodBeat.m2505o(7566);
    }

    private void cZw() {
        AppMethodBeat.m2504i(7567);
        if (this.ejZ == null || this.ejZ.isShowing()) {
            this.ejZ = C30379h.m48458b((Context) this, getString(C25738R.string.da2), true, new C356334());
            AppMethodBeat.m2505o(7567);
            return;
        }
        this.ejZ.show();
        AppMethodBeat.m2505o(7567);
    }

    private void cZx() {
        AppMethodBeat.m2504i(7568);
        if (this.ejZ == null) {
            AppMethodBeat.m2505o(7568);
            return;
        }
        this.ejZ.dismiss();
        AppMethodBeat.m2505o(7568);
    }

    /* renamed from: II */
    private boolean m78807II(int i) {
        AppMethodBeat.m2504i(7569);
        if (i == 1 || i == 2 || i == 7 || i == 8) {
            C4990ab.m7412e("MicroMsg.SdkOAuthUI", "isNetworkAvailable false, errType = ".concat(String.valueOf(i)));
            AppMethodBeat.m2505o(7569);
            return false;
        } else if (C5023at.isConnected(this)) {
            AppMethodBeat.m2505o(7569);
            return true;
        } else {
            C4990ab.m7412e("MicroMsg.SdkOAuthUI", "isNetworkAvailable false, not connected");
            AppMethodBeat.m2505o(7569);
            return false;
        }
    }

    private String cXI() {
        AppMethodBeat.m2504i(7570);
        String g = C4988aa.m7402g(getSharedPreferences(C4996ah.doA(), 0));
        AppMethodBeat.m2505o(7570);
        return g;
    }

    private static String getCountry() {
        AppMethodBeat.m2504i(7571);
        String bc = C5046bo.m7532bc((String) C1720g.m3536RP().mo5239Ry().get(274436, null), null);
        AppMethodBeat.m2505o(7571);
        return bc;
    }

    private static String aer(String str) {
        AppMethodBeat.m2504i(7572);
        String str2 = null;
        C40439f bT = C46494g.m87739bT(str, false);
        if (bT != null) {
            str2 = bT.field_packageName;
        } else {
            C4990ab.m7421w("MicroMsg.SdkOAuthUI", "dealWithCancel getAppInfo null; appid: %s", str);
        }
        AppMethodBeat.m2505o(7572);
        return str2;
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        C22784a c22784a;
        C22784a c22784a2;
        AppMethodBeat.m2504i(7573);
        if (c1207m instanceof C40255aa) {
            m78809a(i, i2, str, (buo) ((C40255aa) c1207m).ehh.fsH.fsP);
        } else if (c1207m instanceof C29812ab) {
            C4990ab.m7417i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeConfirmEnd errType:%d errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
            if (this.usI != null) {
                this.usI.stopTimer();
            }
            cZx();
            if (i == 0 && i2 == 0) {
                bum cXC = ((C29812ab) c1207m).cXC();
                c22784a = C22784a.uKJ;
                C22784a.m34564a(this.mAppId, this.startTime, 1, this.accountType, cZE(), 1, 0);
                afA(cXC.vGi);
            } else if (m78807II(i)) {
                m78821bH(str, false);
                c22784a2 = C22784a.uKJ;
                C22784a.m34564a(this.mAppId, this.startTime, 2, this.accountType, cZE(), 1, i2);
            } else {
                m78821bH(getString(C25738R.string.g0b), false);
                c22784a2 = C22784a.uKJ;
                C22784a.m34564a(this.mAppId, this.startTime, 2, this.accountType, cZE(), 1, i2);
            }
        } else if (c1207m instanceof C43918i) {
            C4990ab.m7417i("MicroMsg.SdkOAuthUI", "onAddAvatarEnd errType:%d errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
            if (i == 0 && i2 == 0) {
                if (this.usK.mo56344Jm(this.usG).f2978id == this.usK.usY) {
                    this.usK.usY = this.usK.mo56344Jm(0).f2978id;
                }
                C35636b c35636b = this.usK;
                if (!c35636b.usV.remove(c35636b.mo56344Jm(this.usG))) {
                    C4990ab.m7412e("MicroMsg.SdkOAuthUI", "remove avatar failed: not found");
                }
                cZF();
                this.usK.notifyDataSetChanged();
            } else if (m78807II(i)) {
                afB(str);
            } else {
                afB(getString(C25738R.string.g0b));
            }
        }
        if (c1207m instanceof C35614y) {
            Object obj;
            C4990ab.m7417i("MicroMsg.SdkOAuthUI", "onQRCodeOauthAuthorizeEnd errType:%d errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
            this.startTime = System.currentTimeMillis();
            if (i == 0 && i2 == 0) {
                bnb bnb = (bnb) ((C35614y) c1207m).ehh.fsH.fsP;
                this.mAppId = bnb.csB;
                this.usN.mAppId = bnb.csB;
                if (bnb.wPP) {
                    C4990ab.m7416i("MicroMsg.SdkOAuthUI", "fallback to h5");
                    obj = 1;
                    c22784a = C22784a.uKJ;
                    C22784a.m34564a(this.mAppId, this.startTime, 1, this.accountType, 0, 0, i2);
                    C25985d.m41467b(C4996ah.getContext(), "webview", ".ui.tools.WebViewUI", getIntent());
                    C43910ag.m78759ag(this);
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
                    m78809a(i, i2, str, buo);
                    obj = null;
                }
            } else if (m78807II(i)) {
                c22784a2 = C22784a.uKJ;
                C22784a.m34564a(this.mAppId, this.startTime, 2, this.accountType, 0, 0, i2);
                m78821bH(str, true);
                obj = null;
            } else {
                m78821bH(getString(C25738R.string.g0b), true);
                c22784a2 = C22784a.uKJ;
                C22784a.m34564a(this.mAppId, this.startTime, 2, this.accountType, 0, 0, i2);
                obj = null;
            }
            if (obj == null) {
                cZx();
            }
            AppMethodBeat.m2505o(7573);
            return;
        }
        if (c1207m instanceof C35615z) {
            C4990ab.m7417i("MicroMsg.SdkOAuthUI", "onQRCodeOauthAuthorizeConfirmEnd errType:%d errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
            cZx();
            if (i == 0 && i2 == 0) {
                c22784a2 = C22784a.uKJ;
                C22784a.m34564a(this.mAppId, this.startTime, 1, this.accountType, cZE(), 1, 0);
                finish();
                AppMethodBeat.m2505o(7573);
                return;
            } else if (m78807II(i)) {
                m78821bH(str, false);
                c22784a2 = C22784a.uKJ;
                C22784a.m34564a(this.mAppId, this.startTime, 2, this.accountType, cZE(), 1, i2);
            } else {
                m78821bH(getString(C25738R.string.g0b), false);
                c22784a2 = C22784a.uKJ;
                C22784a.m34564a(this.mAppId, this.startTime, 2, this.accountType, cZE(), 1, i2);
                AppMethodBeat.m2505o(7573);
                return;
            }
        }
        AppMethodBeat.m2505o(7573);
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.m2504i(7574);
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        contextMenu.add(0, 1, 0, getString(C25738R.string.d64));
        AppMethodBeat.m2505o(7574);
    }

    /* renamed from: a */
    static /* synthetic */ void m78814a(SDKOAuthUI sDKOAuthUI, String str, String str2, String str3, LinkedList linkedList) {
        AppMethodBeat.m2504i(7579);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < linkedList.size(); i++) {
            stringBuilder.append((String) linkedList.get(i)).append(",");
        }
        C4990ab.m7417i("MicroMsg.SdkOAuthUI", "doSDKOauthAuthorizeConfirm selectedScopes: %s", stringBuilder.toString());
        if (sDKOAuthUI.usI != null) {
            sDKOAuthUI.usI.stopTimer();
            sDKOAuthUI.usI.mo16770ae(3000, 3000);
        } else {
            sDKOAuthUI.usI = new C7564ap(new C356345(), false);
            sDKOAuthUI.usI.mo16770ae(3000, 3000);
        }
        C1720g.m3540Rg().mo14541a(new C29812ab(1, str, str2, str3, linkedList), 0);
        AppMethodBeat.m2505o(7579);
    }

    /* renamed from: a */
    static /* synthetic */ void m78811a(SDKOAuthUI sDKOAuthUI, bew bew, buo buo) {
        AppMethodBeat.m2504i(7581);
        if (bew == null) {
            C4990ab.m7412e("MicroMsg.SdkOAuthUI", "fillNewOauthPage: do not get scope request for user info");
            AppMethodBeat.m2505o(7581);
            return;
        }
        C4990ab.m7416i("MicroMsg.SdkOAuthUI", "disagreeBtnCallback click");
        if (bew.wIR == 3 || buo.wIK.size() == 1) {
            sDKOAuthUI.m78806IH(-4);
            sDKOAuthUI.finish();
            AppMethodBeat.m2505o(7581);
        } else if (C43910ag.m78760d("snsapi_friend", buo.wIK) != null) {
            sDKOAuthUI.m78816a(buo, SDKOAuthFriendUI.class, -1, 8);
            C43910ag.m78759ag(sDKOAuthUI);
            AppMethodBeat.m2505o(7581);
        } else {
            sDKOAuthUI.m78816a(buo, SDKOAuthOtherUI.class, -1, 8);
            C43910ag.m78759ag(sDKOAuthUI);
            AppMethodBeat.m2505o(7581);
        }
    }

    /* renamed from: q */
    static /* synthetic */ void m78838q(SDKOAuthUI sDKOAuthUI) {
        AppMethodBeat.m2504i(7584);
        C4990ab.m7417i("MicroMsg.SdkOAuthUI", "doDelAvatar appid: %s", sDKOAuthUI.mAppId);
        C1720g.m3540Rg().mo14541a(new C43918i(sDKOAuthUI.usK.mo56344Jm(sDKOAuthUI.usG).f2978id), 0);
        AppMethodBeat.m2505o(7584);
    }
}

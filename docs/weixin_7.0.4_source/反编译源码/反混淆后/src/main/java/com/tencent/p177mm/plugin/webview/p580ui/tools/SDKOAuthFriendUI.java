package com.tencent.p177mm.plugin.webview.p580ui.tools;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.gdpr.C32791a;
import com.tencent.p177mm.model.gdpr.C32792b;
import com.tencent.p177mm.model.gdpr.C37918c;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.webview.model.C29812ab;
import com.tencent.p177mm.plugin.webview.model.C35615z;
import com.tencent.p177mm.plugin.webview.model.C43910ag;
import com.tencent.p177mm.plugin.webview.p1068e.C22784a;
import com.tencent.p177mm.protocal.protobuf.bew;
import com.tencent.p177mm.protocal.protobuf.buo;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.webview.ui.tools.SDKOAuthFriendUI */
public class SDKOAuthFriendUI extends MMActivity implements C1202f {
    private int accountType = 2;
    private String appId;
    private String cOG;
    private long startTime;
    private String state;
    private String transaction;
    private C43910ag usm;
    private buo usn;
    private int uso;
    private boolean usp = false;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.SDKOAuthFriendUI$1 */
    class C298631 implements Runnable {
        C298631() {
        }

        public final void run() {
            AppMethodBeat.m2504i(7490);
            C22784a c22784a = C22784a.uKJ;
            C22784a.m34564a(SDKOAuthFriendUI.this.appId, SDKOAuthFriendUI.this.startTime, 0, SDKOAuthFriendUI.this.accountType, 3, 1, 0);
            SDKOAuthFriendUI.this.usm.mo69595IH(-2);
            SDKOAuthFriendUI.this.finish();
            AppMethodBeat.m2505o(7490);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(7495);
        super.onCreate(bundle);
        mo17446xE(getResources().getColor(C25738R.color.f11677d4));
        dyb();
        setMMTitle(getString(C25738R.string.d6d));
        mo17427pP(false);
        mo17392b(null, new C298631());
        Intent intent = getIntent();
        this.appId = intent.getStringExtra(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        this.transaction = intent.getStringExtra("1");
        try {
            this.usn = (buo) new buo().parseFrom(intent.getByteArrayExtra("2"));
        } catch (IOException e) {
            C4990ab.m7412e("MicroMsg.SDKOAuthFriendUI", "SdkOauthAuthorizeResp parseFrom byteArray failed");
        }
        this.state = intent.getStringExtra("4");
        this.usp = intent.getBooleanExtra("auth_from_scan", false);
        if (this.usp) {
            this.accountType = 3;
            this.cOG = intent.getStringExtra("auth_raw_url");
            this.usm = new C43910ag(this, this.appId, this.cOG);
        } else {
            this.usm = new C43910ag(this, this.appId, this.transaction, this.state);
        }
        this.uso = intent.getIntExtra(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, -1);
        TextView textView = (TextView) findViewById(2131827259);
        Iterator it = this.usn.wIK.iterator();
        while (it.hasNext()) {
            bew bew = (bew) it.next();
            if (bew.scope.equals("snsapi_friend")) {
                textView.setText(bew.desc);
            }
        }
        textView.getPaint().setFakeBoldText(true);
        ImageView imageView = (ImageView) findViewById(2131827257);
        TextView textView2 = (TextView) findViewById(2131827258);
        C17927a c17927a = new C17927a();
        c17927a.ePT = C1318a.native_oauth_default_head_img;
        c17927a.eQg = getResources().getDimension(C25738R.dimen.a7u);
        c17927a.eQf = true;
        C32291o.ahp().mo43766a(this.usn.wIL, imageView, c17927a.ahG());
        textView2.setText(this.usn.fhH);
        Button button = (Button) findViewById(2131827260);
        Button button2 = (Button) findViewById(2131827261);
        final bew d = C43910ag.m78760d("snsapi_friend", this.usn.wIK);
        final int intExtra = intent.getIntExtra("5", -1);
        this.startTime = System.currentTimeMillis();
        button.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(7491);
                C22784a c22784a = C22784a.uKJ;
                C22784a.m34564a(SDKOAuthFriendUI.this.appId, SDKOAuthFriendUI.this.startTime, 1, SDKOAuthFriendUI.this.accountType, 3, 1, 0);
                SDKOAuthFriendUI.m47332a(SDKOAuthFriendUI.this, intExtra);
                AppMethodBeat.m2505o(7491);
            }
        });
        button2.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(7492);
                C22784a c22784a = C22784a.uKJ;
                C22784a.m34564a(SDKOAuthFriendUI.this.appId, SDKOAuthFriendUI.this.startTime, 0, SDKOAuthFriendUI.this.accountType, 3, 1, 0);
                SDKOAuthFriendUI.m47333a(SDKOAuthFriendUI.this, d, intExtra);
                AppMethodBeat.m2505o(7492);
            }
        });
        AppMethodBeat.m2505o(7495);
    }

    public void onResume() {
        AppMethodBeat.m2504i(7496);
        super.onResume();
        C1720g.m3540Rg().mo14539a(1346, (C1202f) this);
        C1720g.m3540Rg().mo14539a(1137, (C1202f) this);
        AppMethodBeat.m2505o(7496);
    }

    public void onPause() {
        AppMethodBeat.m2504i(7497);
        super.onPause();
        C1720g.m3540Rg().mo14546b(1346, (C1202f) this);
        C1720g.m3540Rg().mo14546b(1137, (C1202f) this);
        AppMethodBeat.m2505o(7497);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(7498);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            this.usm.mo69595IH(-2);
            C22784a c22784a = C22784a.uKJ;
            C22784a.m34564a(this.appId, this.startTime, 0, this.accountType, 3, 1, 0);
            finish();
            AppMethodBeat.m2505o(7498);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(7498);
        return onKeyDown;
    }

    public final int getLayoutId() {
        return 2130970562;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(7499);
        if (!(i == 0 && i2 == 0)) {
            C22784a c22784a = C22784a.uKJ;
            C22784a.m34564a(this.appId, this.startTime, 2, this.accountType, 3, 1, i2);
        }
        if (c1207m instanceof C29812ab) {
            this.usm.mo69600j(i, i2, str, c1207m);
            AppMethodBeat.m2505o(7499);
            return;
        }
        if (c1207m instanceof C35615z) {
            this.usm.mo69601z(i, i2, str);
        }
        AppMethodBeat.m2505o(7499);
    }

    /* renamed from: gy */
    private void m47342gy(final int i, final int i2) {
        AppMethodBeat.m2504i(7500);
        C4990ab.m7416i("MicroMsg.SDKOAuthFriendUI", "accept go  MPGdprPolicyUtil.checkPolicy");
        C37918c.m64041a(this, C32791a.OPENSDK, this.appId, new C32792b() {
            /* renamed from: kL */
            public final void mo8219kL(int i) {
                AppMethodBeat.m2504i(7493);
                C4990ab.m7417i("MicroMsg.SDKOAuthFriendUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", Integer.valueOf(i));
                if (i == 1) {
                    SDKOAuthFriendUI.this.usm.mo69595IH(-4);
                    AppMethodBeat.m2505o(7493);
                } else if (i == 8 && i2 == 8) {
                    SDKOAuthFriendUI.this.usm.mo69595IH(-4);
                    AppMethodBeat.m2505o(7493);
                } else {
                    LinkedList linkedList = new LinkedList();
                    if (i2 == 7) {
                        linkedList.add("snsapi_friend");
                    }
                    if (i == 7) {
                        SDKOAuthFriendUI.this.usm;
                        C43910ag.m78756a(SDKOAuthFriendUI.this.usn, linkedList);
                        if (SDKOAuthFriendUI.this.uso == -1) {
                            C4990ab.m7412e("MicroMsg.SDKOAuthFriendUI", "btnCallback: do not get avatarId from pageone");
                        }
                        if (SDKOAuthFriendUI.this.usp) {
                            SDKOAuthFriendUI.this.usm;
                            C43910ag.m78757a(linkedList, SDKOAuthFriendUI.this.uso, SDKOAuthFriendUI.this.cOG);
                            AppMethodBeat.m2505o(7493);
                            return;
                        }
                        SDKOAuthFriendUI.this.usm.mo69599h(linkedList, SDKOAuthFriendUI.this.uso);
                        AppMethodBeat.m2505o(7493);
                    } else if (SDKOAuthFriendUI.this.usp) {
                        SDKOAuthFriendUI.this.usm;
                        C43910ag.m78757a(linkedList, 0, SDKOAuthFriendUI.this.cOG);
                        AppMethodBeat.m2505o(7493);
                    } else {
                        SDKOAuthFriendUI.this.usm.mo69597aB(linkedList);
                        AppMethodBeat.m2505o(7493);
                    }
                }
            }
        });
        AppMethodBeat.m2505o(7500);
    }

    /* renamed from: Jk */
    private void m47330Jk(final int i) {
        AppMethodBeat.m2504i(7501);
        C4990ab.m7416i("MicroMsg.SDKOAuthFriendUI", "accept go  MPGdprPolicyUtil.checkPolicy");
        C37918c.m64041a(this, C32791a.OPENSDK, this.appId, new C32792b() {
            /* renamed from: kL */
            public final void mo8219kL(int i) {
                AppMethodBeat.m2504i(7494);
                C4990ab.m7417i("MicroMsg.SDKOAuthFriendUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", Integer.valueOf(i));
                if (i == 1 || i != 7) {
                    SDKOAuthFriendUI.this.usm.mo69595IH(-4);
                    AppMethodBeat.m2505o(7494);
                    return;
                }
                LinkedList linkedList = new LinkedList();
                linkedList.add("snsapi_friend");
                SDKOAuthFriendUI.this.usm.mo69597aB(linkedList);
                AppMethodBeat.m2505o(7494);
            }
        });
        AppMethodBeat.m2505o(7501);
    }

    /* renamed from: a */
    private void m47334a(buo buo, Class<?> cls, int i) {
        AppMethodBeat.m2504i(7502);
        Intent intent = new Intent(this, cls);
        intent.putExtra(AppEventsConstants.EVENT_PARAM_VALUE_NO, this.appId);
        intent.putExtra("1", this.transaction);
        intent.putExtra("4", this.state);
        intent.putExtra("6", i);
        intent.putExtra("auth_raw_url", this.cOG);
        intent.putExtra("auth_from_scan", this.usp);
        try {
            intent.putExtra("2", buo.toByteArray());
        } catch (IOException e) {
            C4990ab.m7412e("MicroMsg.SDKOAuthFriendUI", "SdkOauthAuthorizeResp toByteArray failed");
        }
        startActivity(intent);
        AppMethodBeat.m2505o(7502);
    }

    /* renamed from: a */
    private void m47335a(buo buo, Class<?> cls, int i, int i2, int i3) {
        AppMethodBeat.m2504i(7503);
        Intent intent = new Intent(this, cls);
        intent.putExtra(AppEventsConstants.EVENT_PARAM_VALUE_NO, this.appId);
        intent.putExtra("1", this.transaction);
        intent.putExtra("4", this.state);
        intent.putExtra(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, i);
        intent.putExtra("5", i2);
        intent.putExtra("6", i3);
        intent.putExtra("auth_raw_url", this.cOG);
        intent.putExtra("auth_from_scan", this.usp);
        try {
            intent.putExtra("2", buo.toByteArray());
        } catch (IOException e) {
            C4990ab.m7412e("MicroMsg.SDKOAuthFriendUI", "SdkOauthAuthorizeResp toByteArray failed");
        }
        startActivity(intent);
        AppMethodBeat.m2505o(7503);
    }

    /* renamed from: a */
    static /* synthetic */ void m47332a(SDKOAuthFriendUI sDKOAuthFriendUI, int i) {
        AppMethodBeat.m2504i(7504);
        if (C43910ag.m78758a(sDKOAuthFriendUI.usn)) {
            if (sDKOAuthFriendUI.usn.wIK.size() == 2) {
                sDKOAuthFriendUI.m47342gy(i, 7);
                AppMethodBeat.m2505o(7504);
                return;
            }
            sDKOAuthFriendUI.m47335a(sDKOAuthFriendUI.usn, SDKOAuthOtherUI.class, sDKOAuthFriendUI.uso, i, 7);
            C43910ag.m78759ag(sDKOAuthFriendUI);
            AppMethodBeat.m2505o(7504);
        } else if (sDKOAuthFriendUI.usn.wIK.size() == 1) {
            sDKOAuthFriendUI.m47330Jk(7);
            AppMethodBeat.m2505o(7504);
        } else {
            sDKOAuthFriendUI.m47334a(sDKOAuthFriendUI.usn, SDKOAuthOtherUI.class, 7);
            C43910ag.m78759ag(sDKOAuthFriendUI);
            AppMethodBeat.m2505o(7504);
        }
    }
}

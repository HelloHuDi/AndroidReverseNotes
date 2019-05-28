package com.tencent.mm.plugin.webview.ui.tools;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.gdpr.b;
import com.tencent.mm.plugin.webview.model.ag;
import com.tencent.mm.plugin.webview.model.z;
import com.tencent.mm.protocal.protobuf.bew;
import com.tencent.mm.protocal.protobuf.buo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

@a(3)
public class SDKOAuthFriendUI extends MMActivity implements f {
    private int accountType = 2;
    private String appId;
    private String cOG;
    private long startTime;
    private String state;
    private String transaction;
    private ag usm;
    private buo usn;
    private int uso;
    private boolean usp = false;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(7495);
        super.onCreate(bundle);
        xE(getResources().getColor(R.color.d4));
        dyb();
        setMMTitle(getString(R.string.d6d));
        pP(false);
        b(null, new Runnable() {
            public final void run() {
                AppMethodBeat.i(7490);
                com.tencent.mm.plugin.webview.e.a aVar = com.tencent.mm.plugin.webview.e.a.uKJ;
                com.tencent.mm.plugin.webview.e.a.a(SDKOAuthFriendUI.this.appId, SDKOAuthFriendUI.this.startTime, 0, SDKOAuthFriendUI.this.accountType, 3, 1, 0);
                SDKOAuthFriendUI.this.usm.IH(-2);
                SDKOAuthFriendUI.this.finish();
                AppMethodBeat.o(7490);
            }
        });
        Intent intent = getIntent();
        this.appId = intent.getStringExtra(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        this.transaction = intent.getStringExtra("1");
        try {
            this.usn = (buo) new buo().parseFrom(intent.getByteArrayExtra("2"));
        } catch (IOException e) {
            ab.e("MicroMsg.SDKOAuthFriendUI", "SdkOauthAuthorizeResp parseFrom byteArray failed");
        }
        this.state = intent.getStringExtra("4");
        this.usp = intent.getBooleanExtra("auth_from_scan", false);
        if (this.usp) {
            this.accountType = 3;
            this.cOG = intent.getStringExtra("auth_raw_url");
            this.usm = new ag(this, this.appId, this.cOG);
        } else {
            this.usm = new ag(this, this.appId, this.transaction, this.state);
        }
        this.uso = intent.getIntExtra(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, -1);
        TextView textView = (TextView) findViewById(R.id.e6i);
        Iterator it = this.usn.wIK.iterator();
        while (it.hasNext()) {
            bew bew = (bew) it.next();
            if (bew.scope.equals("snsapi_friend")) {
                textView.setText(bew.desc);
            }
        }
        textView.getPaint().setFakeBoldText(true);
        ImageView imageView = (ImageView) findViewById(R.id.e6g);
        TextView textView2 = (TextView) findViewById(R.id.e6h);
        c.a aVar = new c.a();
        aVar.ePT = R.raw.native_oauth_default_head_img;
        aVar.eQg = getResources().getDimension(R.dimen.a7u);
        aVar.eQf = true;
        o.ahp().a(this.usn.wIL, imageView, aVar.ahG());
        textView2.setText(this.usn.fhH);
        Button button = (Button) findViewById(R.id.e6j);
        Button button2 = (Button) findViewById(R.id.e6k);
        final bew d = ag.d("snsapi_friend", this.usn.wIK);
        final int intExtra = intent.getIntExtra("5", -1);
        this.startTime = System.currentTimeMillis();
        button.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(7491);
                com.tencent.mm.plugin.webview.e.a aVar = com.tencent.mm.plugin.webview.e.a.uKJ;
                com.tencent.mm.plugin.webview.e.a.a(SDKOAuthFriendUI.this.appId, SDKOAuthFriendUI.this.startTime, 1, SDKOAuthFriendUI.this.accountType, 3, 1, 0);
                SDKOAuthFriendUI.a(SDKOAuthFriendUI.this, intExtra);
                AppMethodBeat.o(7491);
            }
        });
        button2.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(7492);
                com.tencent.mm.plugin.webview.e.a aVar = com.tencent.mm.plugin.webview.e.a.uKJ;
                com.tencent.mm.plugin.webview.e.a.a(SDKOAuthFriendUI.this.appId, SDKOAuthFriendUI.this.startTime, 0, SDKOAuthFriendUI.this.accountType, 3, 1, 0);
                SDKOAuthFriendUI.a(SDKOAuthFriendUI.this, d, intExtra);
                AppMethodBeat.o(7492);
            }
        });
        AppMethodBeat.o(7495);
    }

    public void onResume() {
        AppMethodBeat.i(7496);
        super.onResume();
        g.Rg().a(1346, (f) this);
        g.Rg().a(1137, (f) this);
        AppMethodBeat.o(7496);
    }

    public void onPause() {
        AppMethodBeat.i(7497);
        super.onPause();
        g.Rg().b(1346, (f) this);
        g.Rg().b(1137, (f) this);
        AppMethodBeat.o(7497);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(7498);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            this.usm.IH(-2);
            com.tencent.mm.plugin.webview.e.a aVar = com.tencent.mm.plugin.webview.e.a.uKJ;
            com.tencent.mm.plugin.webview.e.a.a(this.appId, this.startTime, 0, this.accountType, 3, 1, 0);
            finish();
            AppMethodBeat.o(7498);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(7498);
        return onKeyDown;
    }

    public final int getLayoutId() {
        return R.layout.apu;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(7499);
        if (!(i == 0 && i2 == 0)) {
            com.tencent.mm.plugin.webview.e.a aVar = com.tencent.mm.plugin.webview.e.a.uKJ;
            com.tencent.mm.plugin.webview.e.a.a(this.appId, this.startTime, 2, this.accountType, 3, 1, i2);
        }
        if (mVar instanceof com.tencent.mm.plugin.webview.model.ab) {
            this.usm.j(i, i2, str, mVar);
            AppMethodBeat.o(7499);
            return;
        }
        if (mVar instanceof z) {
            this.usm.z(i, i2, str);
        }
        AppMethodBeat.o(7499);
    }

    private void gy(final int i, final int i2) {
        AppMethodBeat.i(7500);
        ab.i("MicroMsg.SDKOAuthFriendUI", "accept go  MPGdprPolicyUtil.checkPolicy");
        com.tencent.mm.model.gdpr.c.a(this, com.tencent.mm.model.gdpr.a.OPENSDK, this.appId, new b() {
            public final void kL(int i) {
                AppMethodBeat.i(7493);
                ab.i("MicroMsg.SDKOAuthFriendUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", Integer.valueOf(i));
                if (i == 1) {
                    SDKOAuthFriendUI.this.usm.IH(-4);
                    AppMethodBeat.o(7493);
                } else if (i == 8 && i2 == 8) {
                    SDKOAuthFriendUI.this.usm.IH(-4);
                    AppMethodBeat.o(7493);
                } else {
                    LinkedList linkedList = new LinkedList();
                    if (i2 == 7) {
                        linkedList.add("snsapi_friend");
                    }
                    if (i == 7) {
                        SDKOAuthFriendUI.this.usm;
                        ag.a(SDKOAuthFriendUI.this.usn, linkedList);
                        if (SDKOAuthFriendUI.this.uso == -1) {
                            ab.e("MicroMsg.SDKOAuthFriendUI", "btnCallback: do not get avatarId from pageone");
                        }
                        if (SDKOAuthFriendUI.this.usp) {
                            SDKOAuthFriendUI.this.usm;
                            ag.a(linkedList, SDKOAuthFriendUI.this.uso, SDKOAuthFriendUI.this.cOG);
                            AppMethodBeat.o(7493);
                            return;
                        }
                        SDKOAuthFriendUI.this.usm.h(linkedList, SDKOAuthFriendUI.this.uso);
                        AppMethodBeat.o(7493);
                    } else if (SDKOAuthFriendUI.this.usp) {
                        SDKOAuthFriendUI.this.usm;
                        ag.a(linkedList, 0, SDKOAuthFriendUI.this.cOG);
                        AppMethodBeat.o(7493);
                    } else {
                        SDKOAuthFriendUI.this.usm.aB(linkedList);
                        AppMethodBeat.o(7493);
                    }
                }
            }
        });
        AppMethodBeat.o(7500);
    }

    private void Jk(final int i) {
        AppMethodBeat.i(7501);
        ab.i("MicroMsg.SDKOAuthFriendUI", "accept go  MPGdprPolicyUtil.checkPolicy");
        com.tencent.mm.model.gdpr.c.a(this, com.tencent.mm.model.gdpr.a.OPENSDK, this.appId, new b() {
            public final void kL(int i) {
                AppMethodBeat.i(7494);
                ab.i("MicroMsg.SDKOAuthFriendUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", Integer.valueOf(i));
                if (i == 1 || i != 7) {
                    SDKOAuthFriendUI.this.usm.IH(-4);
                    AppMethodBeat.o(7494);
                    return;
                }
                LinkedList linkedList = new LinkedList();
                linkedList.add("snsapi_friend");
                SDKOAuthFriendUI.this.usm.aB(linkedList);
                AppMethodBeat.o(7494);
            }
        });
        AppMethodBeat.o(7501);
    }

    private void a(buo buo, Class<?> cls, int i) {
        AppMethodBeat.i(7502);
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
            ab.e("MicroMsg.SDKOAuthFriendUI", "SdkOauthAuthorizeResp toByteArray failed");
        }
        startActivity(intent);
        AppMethodBeat.o(7502);
    }

    private void a(buo buo, Class<?> cls, int i, int i2, int i3) {
        AppMethodBeat.i(7503);
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
            ab.e("MicroMsg.SDKOAuthFriendUI", "SdkOauthAuthorizeResp toByteArray failed");
        }
        startActivity(intent);
        AppMethodBeat.o(7503);
    }

    static /* synthetic */ void a(SDKOAuthFriendUI sDKOAuthFriendUI, int i) {
        AppMethodBeat.i(7504);
        if (ag.a(sDKOAuthFriendUI.usn)) {
            if (sDKOAuthFriendUI.usn.wIK.size() == 2) {
                sDKOAuthFriendUI.gy(i, 7);
                AppMethodBeat.o(7504);
                return;
            }
            sDKOAuthFriendUI.a(sDKOAuthFriendUI.usn, SDKOAuthOtherUI.class, sDKOAuthFriendUI.uso, i, 7);
            ag.ag(sDKOAuthFriendUI);
            AppMethodBeat.o(7504);
        } else if (sDKOAuthFriendUI.usn.wIK.size() == 1) {
            sDKOAuthFriendUI.Jk(7);
            AppMethodBeat.o(7504);
        } else {
            sDKOAuthFriendUI.a(sDKOAuthFriendUI.usn, SDKOAuthOtherUI.class, 7);
            ag.ag(sDKOAuthFriendUI);
            AppMethodBeat.o(7504);
        }
    }
}

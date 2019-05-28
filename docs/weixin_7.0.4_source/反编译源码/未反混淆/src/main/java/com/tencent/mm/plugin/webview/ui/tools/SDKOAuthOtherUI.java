package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.gdpr.b;
import com.tencent.mm.model.gdpr.c;
import com.tencent.mm.plugin.webview.model.ag;
import com.tencent.mm.plugin.webview.model.z;
import com.tencent.mm.protocal.protobuf.bew;
import com.tencent.mm.protocal.protobuf.buo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(3)
public class SDKOAuthOtherUI extends MMActivity implements f {
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
    private a usv;

    static final class a extends BaseAdapter {
        private Context mContext;
        private LayoutInflater mInflater;
        LinkedList<bew> usA;

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
            AppMethodBeat.i(7515);
            bew Jl = Jl(i);
            AppMethodBeat.o(7515);
            return Jl;
        }

        public a(Context context, LinkedList<bew> linkedList) {
            AppMethodBeat.i(7511);
            this.mInflater = LayoutInflater.from(context);
            this.usA = linkedList;
            this.mContext = context;
            AppMethodBeat.o(7511);
        }

        public final int getCount() {
            AppMethodBeat.i(7512);
            if (this.usA == null) {
                AppMethodBeat.o(7512);
                return 0;
            }
            int size = this.usA.size();
            AppMethodBeat.o(7512);
            return size;
        }

        private bew Jl(int i) {
            AppMethodBeat.i(7513);
            if (i < 0 || i >= this.usA.size()) {
                AppMethodBeat.o(7513);
                return null;
            }
            bew bew = (bew) this.usA.get(i);
            AppMethodBeat.o(7513);
            return bew;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(7514);
            if (this.usA == null || this.usA.size() <= 0) {
                AppMethodBeat.o(7514);
                return null;
            }
            final bew Jl = Jl(i);
            if (Jl == null) {
                AppMethodBeat.o(7514);
                return view;
            }
            a aVar;
            if (view == null) {
                a aVar2 = new a();
                view = this.mInflater.inflate(R.layout.apr, null, false);
                aVar2.usE = (ImageView) view.findViewById(R.id.a02);
                aVar2.jbS = (TextView) view.findViewById(R.id.a03);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            if (Jl.wIR == 1) {
                aVar.usE.setImageResource(R.raw.login_auth_state_radar_not_selected);
            } else if (Jl.wIR == 3) {
                aVar.usE.setImageResource(R.raw.login_auth_state_radar_must_select);
            } else {
                aVar.usE.setImageResource(R.raw.login_auth_state_radar_default_select);
            }
            aVar.jbS.setText(Jl.desc);
            final ImageView imageView = aVar.usE;
            aVar.usE.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(7510);
                    if (Jl.wIR == 2) {
                        imageView.setImageResource(R.raw.login_auth_state_radar_not_selected);
                        Jl.wIR = 1;
                        AppMethodBeat.o(7510);
                        return;
                    }
                    if (Jl.wIR == 1) {
                        imageView.setImageResource(R.raw.login_auth_state_radar_default_select);
                        Jl.wIR = 2;
                    }
                    AppMethodBeat.o(7510);
                }
            });
            AppMethodBeat.o(7514);
            return view;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        boolean z = false;
        AppMethodBeat.i(7516);
        super.onCreate(bundle);
        xE(getResources().getColor(R.color.d4));
        dyb();
        setMMTitle(getString(R.string.d6d));
        pP(false);
        b(null, new Runnable() {
            public final void run() {
                AppMethodBeat.i(7506);
                com.tencent.mm.plugin.webview.e.a aVar = com.tencent.mm.plugin.webview.e.a.uKJ;
                com.tencent.mm.plugin.webview.e.a.a(SDKOAuthOtherUI.this.appId, SDKOAuthOtherUI.this.startTime, 0, SDKOAuthOtherUI.this.accountType, 4, 1, 0);
                SDKOAuthOtherUI.this.usm.IH(-2);
                SDKOAuthOtherUI.this.finish();
                AppMethodBeat.o(7506);
            }
        });
        Intent intent = getIntent();
        this.appId = intent.getStringExtra(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        this.transaction = intent.getStringExtra("1");
        try {
            this.usn = (buo) new buo().parseFrom(intent.getByteArrayExtra("2"));
        } catch (IOException e) {
            ab.e("MicroMsg.SDKOAuthOtherUI", "SdkOauthAuthorizeResp parseFrom byteArray failed");
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
        TextView textView = (TextView) findViewById(R.id.e6n);
        textView.setText(R.string.d6c);
        textView.getPaint().setFakeBoldText(true);
        ImageView imageView = (ImageView) findViewById(R.id.e6l);
        TextView textView2 = (TextView) findViewById(R.id.e6m);
        com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
        aVar.ePT = R.raw.native_oauth_default_head_img;
        aVar.eQg = getResources().getDimension(R.dimen.a7u);
        aVar.eQf = true;
        o.ahp().a(this.usn.wIL, imageView, aVar.ahG());
        textView2.setText(this.usn.fhH);
        ListView listView = (ListView) findViewById(R.id.e6o);
        LinkedList linkedList = new LinkedList();
        Iterator it = this.usn.wIK.iterator();
        while (it.hasNext()) {
            boolean z2;
            bew bew = (bew) it.next();
            if (!(bew.scope.equals("snsapi_userinfo") || bew.scope.equals("snsapi_login") || bew.scope.equals("group_sns_login") || bew.scope.equals("snsapi_friend"))) {
                linkedList.add(bew);
                if (bew.wIR == 3) {
                    z2 = true;
                    z = z2;
                }
            }
            z2 = z;
            z = z2;
        }
        this.usv = new a(this, linkedList);
        listView.setAdapter(this.usv);
        Button button = (Button) findViewById(R.id.e6p);
        Button button2 = (Button) findViewById(R.id.e6q);
        final int intExtra = intent.getIntExtra("5", -2);
        final int intExtra2 = intent.getIntExtra("6", -2);
        this.startTime = System.currentTimeMillis();
        button.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(7507);
                com.tencent.mm.plugin.webview.e.a aVar = com.tencent.mm.plugin.webview.e.a.uKJ;
                com.tencent.mm.plugin.webview.e.a.a(SDKOAuthOtherUI.this.appId, SDKOAuthOtherUI.this.startTime, 1, SDKOAuthOtherUI.this.accountType, 4, 1, 0);
                SDKOAuthOtherUI.a(SDKOAuthOtherUI.this, intExtra, intExtra2);
                AppMethodBeat.o(7507);
            }
        });
        button2.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(7508);
                com.tencent.mm.plugin.webview.e.a aVar = com.tencent.mm.plugin.webview.e.a.uKJ;
                com.tencent.mm.plugin.webview.e.a.a(SDKOAuthOtherUI.this.appId, SDKOAuthOtherUI.this.startTime, 0, SDKOAuthOtherUI.this.accountType, 4, 1, 0);
                SDKOAuthOtherUI.a(SDKOAuthOtherUI.this, z, intExtra, intExtra2);
                AppMethodBeat.o(7508);
            }
        });
        AppMethodBeat.o(7516);
    }

    public void onResume() {
        AppMethodBeat.i(7517);
        super.onResume();
        g.Rg().a(1346, (f) this);
        g.Rg().a(1137, (f) this);
        AppMethodBeat.o(7517);
    }

    public void onPause() {
        AppMethodBeat.i(7518);
        super.onPause();
        g.Rg().b(1346, (f) this);
        g.Rg().b(1137, (f) this);
        AppMethodBeat.o(7518);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(7519);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            com.tencent.mm.plugin.webview.e.a aVar = com.tencent.mm.plugin.webview.e.a.uKJ;
            com.tencent.mm.plugin.webview.e.a.a(this.appId, this.startTime, 0, this.accountType, 4, 1, 0);
            this.usm.IH(-2);
            finish();
            AppMethodBeat.o(7519);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(7519);
        return onKeyDown;
    }

    public final int getLayoutId() {
        return R.layout.apv;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(7520);
        if (!(i == 0 && i2 == 0)) {
            com.tencent.mm.plugin.webview.e.a aVar = com.tencent.mm.plugin.webview.e.a.uKJ;
            com.tencent.mm.plugin.webview.e.a.a(this.appId, this.startTime, 2, this.accountType, 4, 1, i2);
        }
        if (mVar instanceof com.tencent.mm.plugin.webview.model.ab) {
            this.usm.j(i, i2, str, mVar);
            AppMethodBeat.o(7520);
            return;
        }
        if (mVar instanceof z) {
            this.usm.z(i, i2, str);
        }
        AppMethodBeat.o(7520);
    }

    private void ap(final int i, final int i2, final int i3) {
        AppMethodBeat.i(7521);
        ab.i("MicroMsg.SDKOAuthOtherUI", "accept go  MPGdprPolicyUtil.checkPolicy");
        c.a(this, com.tencent.mm.model.gdpr.a.OPENSDK, this.appId, new b() {
            public final void kL(int i) {
                AppMethodBeat.i(7509);
                ab.i("MicroMsg.SDKOAuthOtherUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", Integer.valueOf(i));
                if (i == 1) {
                    SDKOAuthOtherUI.this.usm.IH(-4);
                    AppMethodBeat.o(7509);
                    return;
                }
                LinkedList linkedList;
                if (i3 == 7) {
                    a e = SDKOAuthOtherUI.this.usv;
                    LinkedList linkedList2 = new LinkedList();
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= e.usA.size()) {
                            break;
                        }
                        bew bew = (bew) e.usA.get(i3);
                        if (bew.wIR == 2 || bew.wIR == 3) {
                            linkedList2.add(bew.scope);
                        }
                        i2 = i3 + 1;
                    }
                    linkedList = linkedList2;
                } else {
                    linkedList = new LinkedList();
                }
                if (i == -2 || i2 == -2) {
                    if (i != -2) {
                        if (i == 8 && i3 == 8) {
                            SDKOAuthOtherUI.this.usm.IH(-4);
                            AppMethodBeat.o(7509);
                        } else if (i == 7) {
                            SDKOAuthOtherUI.this.usm;
                            ag.a(SDKOAuthOtherUI.this.usn, linkedList);
                            if (SDKOAuthOtherUI.this.uso == -1) {
                                ab.e("MicroMsg.SDKOAuthOtherUI", "btnCallback: do not get avatarId from pageone");
                            }
                            if (SDKOAuthOtherUI.this.usp) {
                                SDKOAuthOtherUI.this.usm;
                                ag.a(linkedList, SDKOAuthOtherUI.this.uso, SDKOAuthOtherUI.this.cOG);
                                AppMethodBeat.o(7509);
                                return;
                            }
                            SDKOAuthOtherUI.this.usm.h(linkedList, SDKOAuthOtherUI.this.uso);
                            AppMethodBeat.o(7509);
                        } else if (SDKOAuthOtherUI.this.usp) {
                            SDKOAuthOtherUI.this.usm;
                            ag.a(linkedList, SDKOAuthOtherUI.this.uso, SDKOAuthOtherUI.this.cOG);
                            AppMethodBeat.o(7509);
                        } else {
                            SDKOAuthOtherUI.this.usm.aB(linkedList);
                            AppMethodBeat.o(7509);
                        }
                    } else if (i2 != -2) {
                        if (i2 == 8 && i3 == 8) {
                            SDKOAuthOtherUI.this.usm.IH(-4);
                            AppMethodBeat.o(7509);
                            return;
                        }
                        if (i2 == 7) {
                            linkedList.add("snsapi_friend");
                        }
                        SDKOAuthOtherUI.this.usm.aB(linkedList);
                        AppMethodBeat.o(7509);
                    } else if (i3 == 8) {
                        SDKOAuthOtherUI.this.usm.IH(-4);
                        AppMethodBeat.o(7509);
                    } else {
                        SDKOAuthOtherUI.this.usm.aB(linkedList);
                        AppMethodBeat.o(7509);
                    }
                } else if (i == 8 && i2 == 8 && i3 == 8) {
                    SDKOAuthOtherUI.this.usm.IH(-4);
                    AppMethodBeat.o(7509);
                } else {
                    if (i2 == 7) {
                        linkedList.add("snsapi_friend");
                    }
                    if (i == 7) {
                        SDKOAuthOtherUI.this.usm;
                        ag.a(SDKOAuthOtherUI.this.usn, linkedList);
                        if (SDKOAuthOtherUI.this.uso == -1) {
                            ab.e("MicroMsg.SDKOAuthOtherUI", "btnCallback: do not get avatarId from pageone");
                        }
                        if (SDKOAuthOtherUI.this.usp) {
                            SDKOAuthOtherUI.this.usm;
                            ag.a(linkedList, SDKOAuthOtherUI.this.uso, SDKOAuthOtherUI.this.cOG);
                            AppMethodBeat.o(7509);
                            return;
                        }
                        SDKOAuthOtherUI.this.usm.h(linkedList, SDKOAuthOtherUI.this.uso);
                        AppMethodBeat.o(7509);
                    } else if (SDKOAuthOtherUI.this.usp) {
                        SDKOAuthOtherUI.this.usm;
                        ag.a(linkedList, 0, SDKOAuthOtherUI.this.cOG);
                        AppMethodBeat.o(7509);
                    } else {
                        SDKOAuthOtherUI.this.usm.aB(linkedList);
                        AppMethodBeat.o(7509);
                    }
                }
            }
        });
        AppMethodBeat.o(7521);
    }

    static /* synthetic */ void a(SDKOAuthOtherUI sDKOAuthOtherUI, int i, int i2) {
        AppMethodBeat.i(7522);
        sDKOAuthOtherUI.ap(i, i2, 7);
        AppMethodBeat.o(7522);
    }

    static /* synthetic */ void a(SDKOAuthOtherUI sDKOAuthOtherUI, boolean z, int i, int i2) {
        AppMethodBeat.i(7523);
        if (z) {
            sDKOAuthOtherUI.usm.IH(-4);
        }
        sDKOAuthOtherUI.ap(i, i2, 8);
        AppMethodBeat.o(7523);
    }
}

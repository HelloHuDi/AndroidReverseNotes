package com.tencent.p177mm.plugin.webview.p580ui.tools;

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
/* renamed from: com.tencent.mm.plugin.webview.ui.tools.SDKOAuthOtherUI */
public class SDKOAuthOtherUI extends MMActivity implements C1202f {
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
    private C22920a usv;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.SDKOAuthOtherUI$a */
    static final class C22920a extends BaseAdapter {
        private Context mContext;
        private LayoutInflater mInflater;
        LinkedList<bew> usA;

        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.SDKOAuthOtherUI$a$a */
        static final class C22922a {
            TextView jbS;
            ImageView usE;

            private C22922a() {
            }

            /* synthetic */ C22922a(byte b) {
                this();
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(7515);
            bew Jl = m34792Jl(i);
            AppMethodBeat.m2505o(7515);
            return Jl;
        }

        public C22920a(Context context, LinkedList<bew> linkedList) {
            AppMethodBeat.m2504i(7511);
            this.mInflater = LayoutInflater.from(context);
            this.usA = linkedList;
            this.mContext = context;
            AppMethodBeat.m2505o(7511);
        }

        public final int getCount() {
            AppMethodBeat.m2504i(7512);
            if (this.usA == null) {
                AppMethodBeat.m2505o(7512);
                return 0;
            }
            int size = this.usA.size();
            AppMethodBeat.m2505o(7512);
            return size;
        }

        /* renamed from: Jl */
        private bew m34792Jl(int i) {
            AppMethodBeat.m2504i(7513);
            if (i < 0 || i >= this.usA.size()) {
                AppMethodBeat.m2505o(7513);
                return null;
            }
            bew bew = (bew) this.usA.get(i);
            AppMethodBeat.m2505o(7513);
            return bew;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(7514);
            if (this.usA == null || this.usA.size() <= 0) {
                AppMethodBeat.m2505o(7514);
                return null;
            }
            final bew Jl = m34792Jl(i);
            if (Jl == null) {
                AppMethodBeat.m2505o(7514);
                return view;
            }
            C22922a c22922a;
            if (view == null) {
                C22922a c22922a2 = new C22922a();
                view = this.mInflater.inflate(2130970559, null, false);
                c22922a2.usE = (ImageView) view.findViewById(2131821546);
                c22922a2.jbS = (TextView) view.findViewById(2131821547);
                view.setTag(c22922a2);
                c22922a = c22922a2;
            } else {
                c22922a = (C22922a) view.getTag();
            }
            if (Jl.wIR == 1) {
                c22922a.usE.setImageResource(C1318a.login_auth_state_radar_not_selected);
            } else if (Jl.wIR == 3) {
                c22922a.usE.setImageResource(C1318a.login_auth_state_radar_must_select);
            } else {
                c22922a.usE.setImageResource(C1318a.login_auth_state_radar_default_select);
            }
            c22922a.jbS.setText(Jl.desc);
            final ImageView imageView = c22922a.usE;
            c22922a.usE.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(7510);
                    if (Jl.wIR == 2) {
                        imageView.setImageResource(C1318a.login_auth_state_radar_not_selected);
                        Jl.wIR = 1;
                        AppMethodBeat.m2505o(7510);
                        return;
                    }
                    if (Jl.wIR == 1) {
                        imageView.setImageResource(C1318a.login_auth_state_radar_default_select);
                        Jl.wIR = 2;
                    }
                    AppMethodBeat.m2505o(7510);
                }
            });
            AppMethodBeat.m2505o(7514);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.SDKOAuthOtherUI$1 */
    class C229241 implements Runnable {
        C229241() {
        }

        public final void run() {
            AppMethodBeat.m2504i(7506);
            C22784a c22784a = C22784a.uKJ;
            C22784a.m34564a(SDKOAuthOtherUI.this.appId, SDKOAuthOtherUI.this.startTime, 0, SDKOAuthOtherUI.this.accountType, 4, 1, 0);
            SDKOAuthOtherUI.this.usm.mo69595IH(-2);
            SDKOAuthOtherUI.this.finish();
            AppMethodBeat.m2505o(7506);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        boolean z = false;
        AppMethodBeat.m2504i(7516);
        super.onCreate(bundle);
        mo17446xE(getResources().getColor(C25738R.color.f11677d4));
        dyb();
        setMMTitle(getString(C25738R.string.d6d));
        mo17427pP(false);
        mo17392b(null, new C229241());
        Intent intent = getIntent();
        this.appId = intent.getStringExtra(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        this.transaction = intent.getStringExtra("1");
        try {
            this.usn = (buo) new buo().parseFrom(intent.getByteArrayExtra("2"));
        } catch (IOException e) {
            C4990ab.m7412e("MicroMsg.SDKOAuthOtherUI", "SdkOauthAuthorizeResp parseFrom byteArray failed");
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
        TextView textView = (TextView) findViewById(2131827264);
        textView.setText(C25738R.string.d6c);
        textView.getPaint().setFakeBoldText(true);
        ImageView imageView = (ImageView) findViewById(2131827262);
        TextView textView2 = (TextView) findViewById(2131827263);
        C17927a c17927a = new C17927a();
        c17927a.ePT = C1318a.native_oauth_default_head_img;
        c17927a.eQg = getResources().getDimension(C25738R.dimen.a7u);
        c17927a.eQf = true;
        C32291o.ahp().mo43766a(this.usn.wIL, imageView, c17927a.ahG());
        textView2.setText(this.usn.fhH);
        ListView listView = (ListView) findViewById(2131827265);
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
        this.usv = new C22920a(this, linkedList);
        listView.setAdapter(this.usv);
        Button button = (Button) findViewById(2131827266);
        Button button2 = (Button) findViewById(2131827267);
        final int intExtra = intent.getIntExtra("5", -2);
        final int intExtra2 = intent.getIntExtra("6", -2);
        this.startTime = System.currentTimeMillis();
        button.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(7507);
                C22784a c22784a = C22784a.uKJ;
                C22784a.m34564a(SDKOAuthOtherUI.this.appId, SDKOAuthOtherUI.this.startTime, 1, SDKOAuthOtherUI.this.accountType, 4, 1, 0);
                SDKOAuthOtherUI.m34781a(SDKOAuthOtherUI.this, intExtra, intExtra2);
                AppMethodBeat.m2505o(7507);
            }
        });
        button2.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(7508);
                C22784a c22784a = C22784a.uKJ;
                C22784a.m34564a(SDKOAuthOtherUI.this.appId, SDKOAuthOtherUI.this.startTime, 0, SDKOAuthOtherUI.this.accountType, 4, 1, 0);
                SDKOAuthOtherUI.m34782a(SDKOAuthOtherUI.this, z, intExtra, intExtra2);
                AppMethodBeat.m2505o(7508);
            }
        });
        AppMethodBeat.m2505o(7516);
    }

    public void onResume() {
        AppMethodBeat.m2504i(7517);
        super.onResume();
        C1720g.m3540Rg().mo14539a(1346, (C1202f) this);
        C1720g.m3540Rg().mo14539a(1137, (C1202f) this);
        AppMethodBeat.m2505o(7517);
    }

    public void onPause() {
        AppMethodBeat.m2504i(7518);
        super.onPause();
        C1720g.m3540Rg().mo14546b(1346, (C1202f) this);
        C1720g.m3540Rg().mo14546b(1137, (C1202f) this);
        AppMethodBeat.m2505o(7518);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(7519);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            C22784a c22784a = C22784a.uKJ;
            C22784a.m34564a(this.appId, this.startTime, 0, this.accountType, 4, 1, 0);
            this.usm.mo69595IH(-2);
            finish();
            AppMethodBeat.m2505o(7519);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(7519);
        return onKeyDown;
    }

    public final int getLayoutId() {
        return 2130970563;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(7520);
        if (!(i == 0 && i2 == 0)) {
            C22784a c22784a = C22784a.uKJ;
            C22784a.m34564a(this.appId, this.startTime, 2, this.accountType, 4, 1, i2);
        }
        if (c1207m instanceof C29812ab) {
            this.usm.mo69600j(i, i2, str, c1207m);
            AppMethodBeat.m2505o(7520);
            return;
        }
        if (c1207m instanceof C35615z) {
            this.usm.mo69601z(i, i2, str);
        }
        AppMethodBeat.m2505o(7520);
    }

    /* renamed from: ap */
    private void m34783ap(final int i, final int i2, final int i3) {
        AppMethodBeat.m2504i(7521);
        C4990ab.m7416i("MicroMsg.SDKOAuthOtherUI", "accept go  MPGdprPolicyUtil.checkPolicy");
        C37918c.m64041a(this, C32791a.OPENSDK, this.appId, new C32792b() {
            /* renamed from: kL */
            public final void mo8219kL(int i) {
                AppMethodBeat.m2504i(7509);
                C4990ab.m7417i("MicroMsg.SDKOAuthOtherUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", Integer.valueOf(i));
                if (i == 1) {
                    SDKOAuthOtherUI.this.usm.mo69595IH(-4);
                    AppMethodBeat.m2505o(7509);
                    return;
                }
                LinkedList linkedList;
                if (i3 == 7) {
                    C22920a e = SDKOAuthOtherUI.this.usv;
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
                            SDKOAuthOtherUI.this.usm.mo69595IH(-4);
                            AppMethodBeat.m2505o(7509);
                        } else if (i == 7) {
                            SDKOAuthOtherUI.this.usm;
                            C43910ag.m78756a(SDKOAuthOtherUI.this.usn, linkedList);
                            if (SDKOAuthOtherUI.this.uso == -1) {
                                C4990ab.m7412e("MicroMsg.SDKOAuthOtherUI", "btnCallback: do not get avatarId from pageone");
                            }
                            if (SDKOAuthOtherUI.this.usp) {
                                SDKOAuthOtherUI.this.usm;
                                C43910ag.m78757a(linkedList, SDKOAuthOtherUI.this.uso, SDKOAuthOtherUI.this.cOG);
                                AppMethodBeat.m2505o(7509);
                                return;
                            }
                            SDKOAuthOtherUI.this.usm.mo69599h(linkedList, SDKOAuthOtherUI.this.uso);
                            AppMethodBeat.m2505o(7509);
                        } else if (SDKOAuthOtherUI.this.usp) {
                            SDKOAuthOtherUI.this.usm;
                            C43910ag.m78757a(linkedList, SDKOAuthOtherUI.this.uso, SDKOAuthOtherUI.this.cOG);
                            AppMethodBeat.m2505o(7509);
                        } else {
                            SDKOAuthOtherUI.this.usm.mo69597aB(linkedList);
                            AppMethodBeat.m2505o(7509);
                        }
                    } else if (i2 != -2) {
                        if (i2 == 8 && i3 == 8) {
                            SDKOAuthOtherUI.this.usm.mo69595IH(-4);
                            AppMethodBeat.m2505o(7509);
                            return;
                        }
                        if (i2 == 7) {
                            linkedList.add("snsapi_friend");
                        }
                        SDKOAuthOtherUI.this.usm.mo69597aB(linkedList);
                        AppMethodBeat.m2505o(7509);
                    } else if (i3 == 8) {
                        SDKOAuthOtherUI.this.usm.mo69595IH(-4);
                        AppMethodBeat.m2505o(7509);
                    } else {
                        SDKOAuthOtherUI.this.usm.mo69597aB(linkedList);
                        AppMethodBeat.m2505o(7509);
                    }
                } else if (i == 8 && i2 == 8 && i3 == 8) {
                    SDKOAuthOtherUI.this.usm.mo69595IH(-4);
                    AppMethodBeat.m2505o(7509);
                } else {
                    if (i2 == 7) {
                        linkedList.add("snsapi_friend");
                    }
                    if (i == 7) {
                        SDKOAuthOtherUI.this.usm;
                        C43910ag.m78756a(SDKOAuthOtherUI.this.usn, linkedList);
                        if (SDKOAuthOtherUI.this.uso == -1) {
                            C4990ab.m7412e("MicroMsg.SDKOAuthOtherUI", "btnCallback: do not get avatarId from pageone");
                        }
                        if (SDKOAuthOtherUI.this.usp) {
                            SDKOAuthOtherUI.this.usm;
                            C43910ag.m78757a(linkedList, SDKOAuthOtherUI.this.uso, SDKOAuthOtherUI.this.cOG);
                            AppMethodBeat.m2505o(7509);
                            return;
                        }
                        SDKOAuthOtherUI.this.usm.mo69599h(linkedList, SDKOAuthOtherUI.this.uso);
                        AppMethodBeat.m2505o(7509);
                    } else if (SDKOAuthOtherUI.this.usp) {
                        SDKOAuthOtherUI.this.usm;
                        C43910ag.m78757a(linkedList, 0, SDKOAuthOtherUI.this.cOG);
                        AppMethodBeat.m2505o(7509);
                    } else {
                        SDKOAuthOtherUI.this.usm.mo69597aB(linkedList);
                        AppMethodBeat.m2505o(7509);
                    }
                }
            }
        });
        AppMethodBeat.m2505o(7521);
    }

    /* renamed from: a */
    static /* synthetic */ void m34781a(SDKOAuthOtherUI sDKOAuthOtherUI, int i, int i2) {
        AppMethodBeat.m2504i(7522);
        sDKOAuthOtherUI.m34783ap(i, i2, 7);
        AppMethodBeat.m2505o(7522);
    }

    /* renamed from: a */
    static /* synthetic */ void m34782a(SDKOAuthOtherUI sDKOAuthOtherUI, boolean z, int i, int i2) {
        AppMethodBeat.m2504i(7523);
        if (z) {
            sDKOAuthOtherUI.usm.mo69595IH(-4);
        }
        sDKOAuthOtherUI.m34783ap(i, i2, 8);
        AppMethodBeat.m2505o(7523);
    }
}

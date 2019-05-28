package com.tencent.p177mm.plugin.webview.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Constants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.gdpr.C32791a;
import com.tencent.p177mm.model.gdpr.C32792b;
import com.tencent.p177mm.model.gdpr.C37918c;
import com.tencent.p177mm.p1378ce.C26006a;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.plugin.webview.p1068e.C22784a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C40353n.C23160a;
import com.tencent.p177mm.plugin.webview.stub.C46434d;
import com.tencent.p177mm.protocal.protobuf.bew;
import com.tencent.p177mm.protocal.protobuf.buj;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.webview.model.af */
public final class C43907af {
    private static String[] umc;
    private static boolean umd = false;

    /* renamed from: com.tencent.mm.plugin.webview.model.af$a */
    public static final class C14506a {
        public static Bundle cXG() {
            AppMethodBeat.m2504i(6659);
            C4990ab.m7411d("MicroMsg.OauthAuthorizeLogic", "getOauthHostPaths : %s", C26373g.m41965Nv().mo5301O("WebViewConfig", "oauthHostPath"));
            Bundle bundle = new Bundle();
            bundle.putString("oauth_host_paths", r0);
            AppMethodBeat.m2505o(6659);
            return bundle;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.model.af$b */
    public interface C14507b {
        void add(int i);

        boolean cXH();

        void remove(int i);
    }

    /* renamed from: com.tencent.mm.plugin.webview.model.af$d */
    public interface C14508d {
        void aeq(String str);

        void blb();

        /* renamed from: d */
        void mo26749d(OnCancelListener onCancelListener);

        void goBack();
    }

    /* renamed from: com.tencent.mm.plugin.webview.model.af$c */
    public static final class C29814c {

        /* renamed from: com.tencent.mm.plugin.webview.model.af$c$2 */
        public static class C228772 implements OnClickListener {
            final /* synthetic */ C14508d umg;

            public C228772(C14508d c14508d) {
                this.umg = c14508d;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(6661);
                this.umg.goBack();
                AppMethodBeat.m2505o(6661);
            }
        }

        /* renamed from: com.tencent.mm.plugin.webview.model.af$c$3 */
        public static class C228783 implements C32792b {
            final /* synthetic */ int crd;
            final /* synthetic */ long fEG;
            final /* synthetic */ C14508d umg;
            final /* synthetic */ String umh;
            final /* synthetic */ String umi;

            public C228783(C14508d c14508d, String str, long j, int i, String str2) {
                this.umg = c14508d;
                this.umh = str;
                this.fEG = j;
                this.crd = i;
                this.umi = str2;
            }

            /* renamed from: kL */
            public final void mo8219kL(final int i) {
                AppMethodBeat.m2504i(6663);
                C4990ab.m7417i("MicroMsg.OauthAuthorizeLogic", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", Integer.valueOf(i));
                C26006a.m41506q(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(6662);
                        C22784a c22784a;
                        if (i == 1) {
                            C228783.this.umg.goBack();
                            c22784a = C22784a.uKJ;
                            C22784a.m34564a(C228783.this.umh == null ? "" : C228783.this.umh, C228783.this.fEG, 0, 1, 0, 0, C228783.this.crd);
                            AppMethodBeat.m2505o(6662);
                            return;
                        }
                        C228783.this.umg.aeq(C228783.this.umi);
                        c22784a = C22784a.uKJ;
                        C22784a.m34564a(C228783.this.umh == null ? "" : C228783.this.umh, C228783.this.fEG, 1, 1, 0, 0, C228783.this.crd);
                        AppMethodBeat.m2505o(6662);
                    }
                });
                AppMethodBeat.m2505o(6663);
            }
        }

        /* renamed from: com.tencent.mm.plugin.webview.model.af$c$4 */
        public static class C249284 implements C23160a {
            final /* synthetic */ int crd;
            final /* synthetic */ long fEG;
            final /* synthetic */ C46434d ulK;
            final /* synthetic */ C14507b umf;
            final /* synthetic */ C14508d umg;
            final /* synthetic */ String umh;
            final /* synthetic */ Bundle umk;
            final /* synthetic */ int uml;
            final /* synthetic */ Context val$context;

            public C249284(Context context, String str, C14508d c14508d, long j, int i, Bundle bundle, C46434d c46434d, C14507b c14507b, int i2) {
                this.val$context = context;
                this.umh = str;
                this.umg = c14508d;
                this.fEG = j;
                this.crd = i;
                this.umk = bundle;
                this.ulK = c46434d;
                this.umf = c14507b;
                this.uml = i2;
            }

            /* renamed from: f */
            public final void mo5953f(int i, final Bundle bundle) {
                AppMethodBeat.m2504i(6666);
                C4990ab.m7417i("MicroMsg.OauthAuthorizeLogic", "WebAuthorizeDialog#onRevMsg resultCode %d", Integer.valueOf(i));
                switch (i) {
                    case 1:
                        C37918c.m64041a(this.val$context, C32791a.OPENSDK, this.umh, new C32792b() {
                            /* renamed from: kL */
                            public final void mo8219kL(final int i) {
                                AppMethodBeat.m2504i(6665);
                                C4990ab.m7417i("MicroMsg.OauthAuthorizeLogic", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", Integer.valueOf(i));
                                C26006a.m41506q(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.m2504i(6664);
                                        C22784a c22784a;
                                        String str;
                                        if (i == 1) {
                                            C249284.this.umg.goBack();
                                            c22784a = C22784a.uKJ;
                                            if (C249284.this.umh == null) {
                                                str = "";
                                            } else {
                                                str = C249284.this.umh;
                                            }
                                            C22784a.m34564a(str, C249284.this.fEG, 0, 1, 0, 1, C249284.this.crd);
                                            AppMethodBeat.m2505o(6664);
                                            return;
                                        }
                                        c22784a = C22784a.uKJ;
                                        if (C249284.this.umh == null) {
                                            str = "";
                                        } else {
                                            str = C249284.this.umh;
                                        }
                                        C22784a.m34564a(str, C249284.this.fEG, 1, 1, 0, 1, C249284.this.crd);
                                        Bundle bundle = C249284.this.umk;
                                        Bundle bundle2 = bundle;
                                        C14508d c14508d = C249284.this.umg;
                                        C46434d c46434d = C249284.this.ulK;
                                        C14507b c14507b = C249284.this.umf;
                                        int i = C249284.this.uml;
                                        C4990ab.m7416i("MicroMsg.OauthAuthorizeLogic", "doAcceptLogic");
                                        if (bundle.getBoolean("is_call_server_when_confirm")) {
                                            C29814c.m47268a(c46434d, bundle.getString("oauth_url"), 1, (ArrayList) bundle2.getSerializable("key_scope"), c14507b, true, i);
                                            AppMethodBeat.m2505o(6664);
                                            return;
                                        }
                                        c14508d.aeq(bundle.getString("redirect_url"));
                                        C4990ab.m7417i("MicroMsg.OauthAuthorizeLogic", "doAcceptLogic redirectUrl: %s", r0);
                                        AppMethodBeat.m2505o(6664);
                                    }
                                });
                                AppMethodBeat.m2505o(6665);
                            }
                        });
                        AppMethodBeat.m2505o(6666);
                        return;
                    case 2:
                    case 3:
                        ArrayList arrayList;
                        Bundle bundle2 = this.umk;
                        C14508d c14508d = this.umg;
                        C46434d c46434d = this.ulK;
                        C14507b c14507b = this.umf;
                        int i2 = this.uml;
                        C4990ab.m7416i("MicroMsg.OauthAuthorizeLogic", "doRejectLogic");
                        String string = bundle2.getString("oauth_url");
                        if (bundle == null) {
                            arrayList = new ArrayList();
                        } else {
                            arrayList = (ArrayList) bundle.getSerializable("key_scope");
                        }
                        C29814c.m47268a(c46434d, string, 2, arrayList, c14507b, false, i2);
                        c14508d.goBack();
                        C22784a c22784a = C22784a.uKJ;
                        C22784a.m34564a(this.umh == null ? "" : this.umh, this.fEG, 0, 1, 0, 1, this.crd);
                        AppMethodBeat.m2505o(6666);
                        return;
                    default:
                        this.umg.goBack();
                        AppMethodBeat.m2505o(6666);
                        return;
                }
            }
        }

        /* renamed from: com.tencent.mm.plugin.webview.model.af$c$5 */
        public static class C298165 implements OnClickListener {
            final /* synthetic */ C14508d umg;

            public C298165(C14508d c14508d) {
                this.umg = c14508d;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(6667);
                this.umg.goBack();
                AppMethodBeat.m2505o(6667);
            }
        }

        /* renamed from: a */
        public static boolean m47271a(String str, String str2, int i, C46434d c46434d, final C14508d c14508d, final C14507b c14507b, int i2) {
            AppMethodBeat.m2504i(6668);
            if (c46434d == null) {
                C4990ab.m7412e("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorize invoker null");
                AppMethodBeat.m2505o(6668);
                return false;
            }
            C4990ab.m7417i("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorize scene: %d", Integer.valueOf(i));
            c14508d.mo26749d(new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(6660);
                    C4990ab.m7416i("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorize user cancel");
                    c14508d.blb();
                    c14507b.remove(1254);
                    AppMethodBeat.m2505o(6660);
                }
            });
            Bundle bundle = new Bundle();
            bundle.putString("oauth_url", str);
            bundle.putString("biz_username", str2);
            bundle.putInt("scene", i);
            bundle.putInt("webview_binder_id", i2);
            try {
                c14507b.add(1254);
                c46434d.mo15590s(1254, bundle);
                AppMethodBeat.m2505o(6668);
                return true;
            } catch (RemoteException e) {
                C4990ab.m7421w("MicroMsg.OauthAuthorizeLogic", "invoker.doScene exp : %s", e.getLocalizedMessage());
                AppMethodBeat.m2505o(6668);
                return false;
            }
        }

        /* renamed from: a */
        static void m47268a(C46434d c46434d, String str, int i, ArrayList<String> arrayList, C14507b c14507b, boolean z, int i2) {
            AppMethodBeat.m2504i(6669);
            if (c46434d == null) {
                C4990ab.m7412e("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorizeConfirm invoker null");
                AppMethodBeat.m2505o(6669);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("oauth_url", str);
            bundle.putInt("opt", i);
            bundle.putStringArrayList(Constants.KEY_SCOPES, arrayList);
            bundle.putInt("webview_binder_id", i2);
            if (z) {
                try {
                    c14507b.add(1373);
                } catch (RemoteException e) {
                    C4990ab.m7421w("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorizeConfirm doScene exp : %s", e.getLocalizedMessage());
                    AppMethodBeat.m2505o(6669);
                    return;
                }
            }
            c46434d.mo15590s(1373, bundle);
            AppMethodBeat.m2505o(6669);
        }

        /* renamed from: a */
        public static boolean m47270a(String str, C46434d c46434d) {
            AppMethodBeat.m2504i(6670);
            if (C43907af.umc == null && !C43907af.umd) {
                try {
                    Bundle g = c46434d.mo15575g(94, new Bundle());
                    String str2 = null;
                    if (g != null) {
                        str2 = g.getString("oauth_host_paths");
                    }
                    if (C5046bo.isNullOrNil(str2)) {
                        str2 = "open.weixin.qq.com/connect/oauth2/authorize";
                    }
                    C43907af.umc = str2.split(";");
                    C43907af.umd = true;
                } catch (RemoteException e) {
                    C4990ab.m7421w("MicroMsg.OauthAuthorizeLogic", "isOauthHost exp:%s", e.getLocalizedMessage());
                    AppMethodBeat.m2505o(6670);
                    return false;
                }
            }
            if (C43907af.umc == null || C43907af.umc.length == 0) {
                C4990ab.m7416i("MicroMsg.OauthAuthorizeLogic", "isOauthHost sOauthHostPaths nil");
                AppMethodBeat.m2505o(6670);
                return false;
            }
            Uri parse = Uri.parse(str);
            String str3 = parse.getAuthority() + parse.getPath();
            if (C5046bo.isNullOrNil(str3)) {
                C4990ab.m7416i("MicroMsg.OauthAuthorizeLogic", "isOauthHost target nil");
                AppMethodBeat.m2505o(6670);
                return false;
            }
            C4990ab.m7411d("MicroMsg.OauthAuthorizeLogic", "isOauthHost target:%s", str3);
            for (String equalsIgnoreCase : C43907af.umc) {
                if (str3.equalsIgnoreCase(equalsIgnoreCase)) {
                    AppMethodBeat.m2505o(6670);
                    return true;
                }
            }
            AppMethodBeat.m2505o(6670);
            return false;
        }

        /* renamed from: a */
        public static boolean m47269a(C46434d c46434d) {
            boolean z = false;
            AppMethodBeat.m2504i(6671);
            try {
                Bundle g = c46434d.mo15575g(93, new Bundle());
                if (g == null) {
                    C4990ab.m7420w("MicroMsg.OauthAuthorizeLogic", "shouldNativeOauthIntercept Bundle isOauthNative null");
                    AppMethodBeat.m2505o(6671);
                } else {
                    z = g.getBoolean("is_oauth_native");
                    AppMethodBeat.m2505o(6671);
                }
            } catch (RemoteException e) {
                C4990ab.m7421w("MicroMsg.OauthAuthorizeLogic", "shouldNativeOauthIntercept exp:%s", e.getLocalizedMessage());
                AppMethodBeat.m2505o(6671);
            }
            return z;
        }

        public static String aep(String str) {
            String str2 = null;
            AppMethodBeat.m2504i(6672);
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(6672);
            } else {
                try {
                    str2 = Uri.parse(str).getQueryParameter("appid");
                    if (C5046bo.isNullOrNil(str2)) {
                        C4990ab.m7417i("MicroMsg.OauthAuthorizeLogic", "parseAppId try case not sensitive, oauthUrl:%s", str);
                        str2 = Uri.parse(str.toLowerCase()).getQueryParameter("appid");
                    }
                } catch (Exception e) {
                }
                AppMethodBeat.m2505o(6672);
            }
            return str2;
        }
    }

    /* renamed from: aA */
    public static /* synthetic */ ArrayList m78751aA(LinkedList linkedList) {
        AppMethodBeat.m2504i(6676);
        ArrayList az = C43907af.m78753az(linkedList);
        AppMethodBeat.m2505o(6676);
        return az;
    }

    /* renamed from: aa */
    public static /* synthetic */ LinkedList m78752aa(ArrayList arrayList) {
        AppMethodBeat.m2504i(6675);
        LinkedList Z = C43907af.m78750Z(arrayList);
        AppMethodBeat.m2505o(6675);
        return Z;
    }

    /* renamed from: az */
    private static ArrayList<byte[]> m78753az(LinkedList<bew> linkedList) {
        AppMethodBeat.m2504i(6673);
        ArrayList<byte[]> arrayList = new ArrayList();
        if (linkedList == null || linkedList.isEmpty()) {
            AppMethodBeat.m2505o(6673);
            return arrayList;
        }
        int i = 0;
        while (i < linkedList.size()) {
            try {
                arrayList.add(((bew) linkedList.get(i)).toByteArray());
                i++;
            } catch (IOException e) {
                C4990ab.m7421w("MicroMsg.OauthAuthorizeLogic", "oauthScopeInfoListToBytesList index:%d, exp:%s ", Integer.valueOf(i), e.getLocalizedMessage());
                arrayList.clear();
                AppMethodBeat.m2505o(6673);
                return arrayList;
            }
        }
        AppMethodBeat.m2505o(6673);
        return arrayList;
    }

    /* renamed from: Z */
    private static LinkedList<buj> m78750Z(ArrayList<byte[]> arrayList) {
        AppMethodBeat.m2504i(6674);
        LinkedList<buj> linkedList = new LinkedList();
        if (arrayList == null || arrayList.isEmpty()) {
            AppMethodBeat.m2505o(6674);
            return linkedList;
        }
        int i = 0;
        while (i < arrayList.size()) {
            try {
                bew bew = new bew();
                bew.parseFrom((byte[]) arrayList.get(i));
                buj buj = new buj();
                buj.wWa = bew.wIR;
                buj.Desc = bew.desc;
                buj.vOF = bew.scope;
                buj.iyZ = bew.iyZ;
                linkedList.add(buj);
                i++;
            } catch (IOException e) {
                C4990ab.m7421w("MicroMsg.OauthAuthorizeLogic", "bytesListToBytesListScopeInfoList: i:%d, exp:%s", Integer.valueOf(i), e.getLocalizedMessage());
                linkedList.clear();
                AppMethodBeat.m2505o(6674);
                return linkedList;
            }
        }
        AppMethodBeat.m2505o(6674);
        return linkedList;
    }
}

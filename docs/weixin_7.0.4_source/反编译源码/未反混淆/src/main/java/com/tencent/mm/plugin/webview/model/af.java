package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Constants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.g;
import com.tencent.mm.protocal.protobuf.bew;
import com.tencent.mm.protocal.protobuf.buj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public final class af {
    private static String[] umc;
    private static boolean umd = false;

    public static final class a {
        public static Bundle cXG() {
            AppMethodBeat.i(6659);
            ab.d("MicroMsg.OauthAuthorizeLogic", "getOauthHostPaths : %s", g.Nv().O("WebViewConfig", "oauthHostPath"));
            Bundle bundle = new Bundle();
            bundle.putString("oauth_host_paths", r0);
            AppMethodBeat.o(6659);
            return bundle;
        }
    }

    public interface b {
        void add(int i);

        boolean cXH();

        void remove(int i);
    }

    public interface d {
        void aeq(String str);

        void blb();

        void d(OnCancelListener onCancelListener);

        void goBack();
    }

    public static final class c {

        /* renamed from: com.tencent.mm.plugin.webview.model.af$c$2 */
        public static class AnonymousClass2 implements OnClickListener {
            final /* synthetic */ d umg;

            public AnonymousClass2(d dVar) {
                this.umg = dVar;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(6661);
                this.umg.goBack();
                AppMethodBeat.o(6661);
            }
        }

        /* renamed from: com.tencent.mm.plugin.webview.model.af$c$3 */
        public static class AnonymousClass3 implements com.tencent.mm.model.gdpr.b {
            final /* synthetic */ int crd;
            final /* synthetic */ long fEG;
            final /* synthetic */ d umg;
            final /* synthetic */ String umh;
            final /* synthetic */ String umi;

            public AnonymousClass3(d dVar, String str, long j, int i, String str2) {
                this.umg = dVar;
                this.umh = str;
                this.fEG = j;
                this.crd = i;
                this.umi = str2;
            }

            public final void kL(final int i) {
                AppMethodBeat.i(6663);
                ab.i("MicroMsg.OauthAuthorizeLogic", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", Integer.valueOf(i));
                com.tencent.mm.ce.a.q(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(6662);
                        com.tencent.mm.plugin.webview.e.a aVar;
                        if (i == 1) {
                            AnonymousClass3.this.umg.goBack();
                            aVar = com.tencent.mm.plugin.webview.e.a.uKJ;
                            com.tencent.mm.plugin.webview.e.a.a(AnonymousClass3.this.umh == null ? "" : AnonymousClass3.this.umh, AnonymousClass3.this.fEG, 0, 1, 0, 0, AnonymousClass3.this.crd);
                            AppMethodBeat.o(6662);
                            return;
                        }
                        AnonymousClass3.this.umg.aeq(AnonymousClass3.this.umi);
                        aVar = com.tencent.mm.plugin.webview.e.a.uKJ;
                        com.tencent.mm.plugin.webview.e.a.a(AnonymousClass3.this.umh == null ? "" : AnonymousClass3.this.umh, AnonymousClass3.this.fEG, 1, 1, 0, 0, AnonymousClass3.this.crd);
                        AppMethodBeat.o(6662);
                    }
                });
                AppMethodBeat.o(6663);
            }
        }

        /* renamed from: com.tencent.mm.plugin.webview.model.af$c$4 */
        public static class AnonymousClass4 implements com.tencent.mm.plugin.webview.ui.tools.widget.n.a {
            final /* synthetic */ int crd;
            final /* synthetic */ long fEG;
            final /* synthetic */ com.tencent.mm.plugin.webview.stub.d ulK;
            final /* synthetic */ b umf;
            final /* synthetic */ d umg;
            final /* synthetic */ String umh;
            final /* synthetic */ Bundle umk;
            final /* synthetic */ int uml;
            final /* synthetic */ Context val$context;

            public AnonymousClass4(Context context, String str, d dVar, long j, int i, Bundle bundle, com.tencent.mm.plugin.webview.stub.d dVar2, b bVar, int i2) {
                this.val$context = context;
                this.umh = str;
                this.umg = dVar;
                this.fEG = j;
                this.crd = i;
                this.umk = bundle;
                this.ulK = dVar2;
                this.umf = bVar;
                this.uml = i2;
            }

            public final void f(int i, final Bundle bundle) {
                AppMethodBeat.i(6666);
                ab.i("MicroMsg.OauthAuthorizeLogic", "WebAuthorizeDialog#onRevMsg resultCode %d", Integer.valueOf(i));
                switch (i) {
                    case 1:
                        com.tencent.mm.model.gdpr.c.a(this.val$context, com.tencent.mm.model.gdpr.a.OPENSDK, this.umh, new com.tencent.mm.model.gdpr.b() {
                            public final void kL(final int i) {
                                AppMethodBeat.i(6665);
                                ab.i("MicroMsg.OauthAuthorizeLogic", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", Integer.valueOf(i));
                                com.tencent.mm.ce.a.q(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(6664);
                                        com.tencent.mm.plugin.webview.e.a aVar;
                                        String str;
                                        if (i == 1) {
                                            AnonymousClass4.this.umg.goBack();
                                            aVar = com.tencent.mm.plugin.webview.e.a.uKJ;
                                            if (AnonymousClass4.this.umh == null) {
                                                str = "";
                                            } else {
                                                str = AnonymousClass4.this.umh;
                                            }
                                            com.tencent.mm.plugin.webview.e.a.a(str, AnonymousClass4.this.fEG, 0, 1, 0, 1, AnonymousClass4.this.crd);
                                            AppMethodBeat.o(6664);
                                            return;
                                        }
                                        aVar = com.tencent.mm.plugin.webview.e.a.uKJ;
                                        if (AnonymousClass4.this.umh == null) {
                                            str = "";
                                        } else {
                                            str = AnonymousClass4.this.umh;
                                        }
                                        com.tencent.mm.plugin.webview.e.a.a(str, AnonymousClass4.this.fEG, 1, 1, 0, 1, AnonymousClass4.this.crd);
                                        Bundle bundle = AnonymousClass4.this.umk;
                                        Bundle bundle2 = bundle;
                                        d dVar = AnonymousClass4.this.umg;
                                        com.tencent.mm.plugin.webview.stub.d dVar2 = AnonymousClass4.this.ulK;
                                        b bVar = AnonymousClass4.this.umf;
                                        int i = AnonymousClass4.this.uml;
                                        ab.i("MicroMsg.OauthAuthorizeLogic", "doAcceptLogic");
                                        if (bundle.getBoolean("is_call_server_when_confirm")) {
                                            c.a(dVar2, bundle.getString("oauth_url"), 1, (ArrayList) bundle2.getSerializable("key_scope"), bVar, true, i);
                                            AppMethodBeat.o(6664);
                                            return;
                                        }
                                        dVar.aeq(bundle.getString("redirect_url"));
                                        ab.i("MicroMsg.OauthAuthorizeLogic", "doAcceptLogic redirectUrl: %s", r0);
                                        AppMethodBeat.o(6664);
                                    }
                                });
                                AppMethodBeat.o(6665);
                            }
                        });
                        AppMethodBeat.o(6666);
                        return;
                    case 2:
                    case 3:
                        ArrayList arrayList;
                        Bundle bundle2 = this.umk;
                        d dVar = this.umg;
                        com.tencent.mm.plugin.webview.stub.d dVar2 = this.ulK;
                        b bVar = this.umf;
                        int i2 = this.uml;
                        ab.i("MicroMsg.OauthAuthorizeLogic", "doRejectLogic");
                        String string = bundle2.getString("oauth_url");
                        if (bundle == null) {
                            arrayList = new ArrayList();
                        } else {
                            arrayList = (ArrayList) bundle.getSerializable("key_scope");
                        }
                        c.a(dVar2, string, 2, arrayList, bVar, false, i2);
                        dVar.goBack();
                        com.tencent.mm.plugin.webview.e.a aVar = com.tencent.mm.plugin.webview.e.a.uKJ;
                        com.tencent.mm.plugin.webview.e.a.a(this.umh == null ? "" : this.umh, this.fEG, 0, 1, 0, 1, this.crd);
                        AppMethodBeat.o(6666);
                        return;
                    default:
                        this.umg.goBack();
                        AppMethodBeat.o(6666);
                        return;
                }
            }
        }

        /* renamed from: com.tencent.mm.plugin.webview.model.af$c$5 */
        public static class AnonymousClass5 implements OnClickListener {
            final /* synthetic */ d umg;

            public AnonymousClass5(d dVar) {
                this.umg = dVar;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(6667);
                this.umg.goBack();
                AppMethodBeat.o(6667);
            }
        }

        public static boolean a(String str, String str2, int i, com.tencent.mm.plugin.webview.stub.d dVar, final d dVar2, final b bVar, int i2) {
            AppMethodBeat.i(6668);
            if (dVar == null) {
                ab.e("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorize invoker null");
                AppMethodBeat.o(6668);
                return false;
            }
            ab.i("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorize scene: %d", Integer.valueOf(i));
            dVar2.d(new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(6660);
                    ab.i("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorize user cancel");
                    dVar2.blb();
                    bVar.remove(1254);
                    AppMethodBeat.o(6660);
                }
            });
            Bundle bundle = new Bundle();
            bundle.putString("oauth_url", str);
            bundle.putString("biz_username", str2);
            bundle.putInt("scene", i);
            bundle.putInt("webview_binder_id", i2);
            try {
                bVar.add(1254);
                dVar.s(1254, bundle);
                AppMethodBeat.o(6668);
                return true;
            } catch (RemoteException e) {
                ab.w("MicroMsg.OauthAuthorizeLogic", "invoker.doScene exp : %s", e.getLocalizedMessage());
                AppMethodBeat.o(6668);
                return false;
            }
        }

        static void a(com.tencent.mm.plugin.webview.stub.d dVar, String str, int i, ArrayList<String> arrayList, b bVar, boolean z, int i2) {
            AppMethodBeat.i(6669);
            if (dVar == null) {
                ab.e("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorizeConfirm invoker null");
                AppMethodBeat.o(6669);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("oauth_url", str);
            bundle.putInt("opt", i);
            bundle.putStringArrayList(Constants.KEY_SCOPES, arrayList);
            bundle.putInt("webview_binder_id", i2);
            if (z) {
                try {
                    bVar.add(1373);
                } catch (RemoteException e) {
                    ab.w("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorizeConfirm doScene exp : %s", e.getLocalizedMessage());
                    AppMethodBeat.o(6669);
                    return;
                }
            }
            dVar.s(1373, bundle);
            AppMethodBeat.o(6669);
        }

        public static boolean a(String str, com.tencent.mm.plugin.webview.stub.d dVar) {
            AppMethodBeat.i(6670);
            if (af.umc == null && !af.umd) {
                try {
                    Bundle g = dVar.g(94, new Bundle());
                    String str2 = null;
                    if (g != null) {
                        str2 = g.getString("oauth_host_paths");
                    }
                    if (bo.isNullOrNil(str2)) {
                        str2 = "open.weixin.qq.com/connect/oauth2/authorize";
                    }
                    af.umc = str2.split(";");
                    af.umd = true;
                } catch (RemoteException e) {
                    ab.w("MicroMsg.OauthAuthorizeLogic", "isOauthHost exp:%s", e.getLocalizedMessage());
                    AppMethodBeat.o(6670);
                    return false;
                }
            }
            if (af.umc == null || af.umc.length == 0) {
                ab.i("MicroMsg.OauthAuthorizeLogic", "isOauthHost sOauthHostPaths nil");
                AppMethodBeat.o(6670);
                return false;
            }
            Uri parse = Uri.parse(str);
            String str3 = parse.getAuthority() + parse.getPath();
            if (bo.isNullOrNil(str3)) {
                ab.i("MicroMsg.OauthAuthorizeLogic", "isOauthHost target nil");
                AppMethodBeat.o(6670);
                return false;
            }
            ab.d("MicroMsg.OauthAuthorizeLogic", "isOauthHost target:%s", str3);
            for (String equalsIgnoreCase : af.umc) {
                if (str3.equalsIgnoreCase(equalsIgnoreCase)) {
                    AppMethodBeat.o(6670);
                    return true;
                }
            }
            AppMethodBeat.o(6670);
            return false;
        }

        public static boolean a(com.tencent.mm.plugin.webview.stub.d dVar) {
            boolean z = false;
            AppMethodBeat.i(6671);
            try {
                Bundle g = dVar.g(93, new Bundle());
                if (g == null) {
                    ab.w("MicroMsg.OauthAuthorizeLogic", "shouldNativeOauthIntercept Bundle isOauthNative null");
                    AppMethodBeat.o(6671);
                } else {
                    z = g.getBoolean("is_oauth_native");
                    AppMethodBeat.o(6671);
                }
            } catch (RemoteException e) {
                ab.w("MicroMsg.OauthAuthorizeLogic", "shouldNativeOauthIntercept exp:%s", e.getLocalizedMessage());
                AppMethodBeat.o(6671);
            }
            return z;
        }

        public static String aep(String str) {
            String str2 = null;
            AppMethodBeat.i(6672);
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(6672);
            } else {
                try {
                    str2 = Uri.parse(str).getQueryParameter("appid");
                    if (bo.isNullOrNil(str2)) {
                        ab.i("MicroMsg.OauthAuthorizeLogic", "parseAppId try case not sensitive, oauthUrl:%s", str);
                        str2 = Uri.parse(str.toLowerCase()).getQueryParameter("appid");
                    }
                } catch (Exception e) {
                }
                AppMethodBeat.o(6672);
            }
            return str2;
        }
    }

    public static /* synthetic */ ArrayList aA(LinkedList linkedList) {
        AppMethodBeat.i(6676);
        ArrayList az = az(linkedList);
        AppMethodBeat.o(6676);
        return az;
    }

    public static /* synthetic */ LinkedList aa(ArrayList arrayList) {
        AppMethodBeat.i(6675);
        LinkedList Z = Z(arrayList);
        AppMethodBeat.o(6675);
        return Z;
    }

    private static ArrayList<byte[]> az(LinkedList<bew> linkedList) {
        AppMethodBeat.i(6673);
        ArrayList<byte[]> arrayList = new ArrayList();
        if (linkedList == null || linkedList.isEmpty()) {
            AppMethodBeat.o(6673);
            return arrayList;
        }
        int i = 0;
        while (i < linkedList.size()) {
            try {
                arrayList.add(((bew) linkedList.get(i)).toByteArray());
                i++;
            } catch (IOException e) {
                ab.w("MicroMsg.OauthAuthorizeLogic", "oauthScopeInfoListToBytesList index:%d, exp:%s ", Integer.valueOf(i), e.getLocalizedMessage());
                arrayList.clear();
                AppMethodBeat.o(6673);
                return arrayList;
            }
        }
        AppMethodBeat.o(6673);
        return arrayList;
    }

    private static LinkedList<buj> Z(ArrayList<byte[]> arrayList) {
        AppMethodBeat.i(6674);
        LinkedList<buj> linkedList = new LinkedList();
        if (arrayList == null || arrayList.isEmpty()) {
            AppMethodBeat.o(6674);
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
                ab.w("MicroMsg.OauthAuthorizeLogic", "bytesListToBytesListScopeInfoList: i:%d, exp:%s", Integer.valueOf(i), e.getLocalizedMessage());
                linkedList.clear();
                AppMethodBeat.o(6674);
                return linkedList;
            }
        }
        AppMethodBeat.o(6674);
        return linkedList;
    }
}

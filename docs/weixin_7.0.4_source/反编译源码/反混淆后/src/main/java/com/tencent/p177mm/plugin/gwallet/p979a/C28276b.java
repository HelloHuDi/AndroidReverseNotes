package com.tencent.p177mm.plugin.gwallet.p979a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.android.vending.billing.IInAppBillingService;
import com.android.vending.billing.IInAppBillingService.C17502a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.ttpic.VError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

/* renamed from: com.tencent.mm.plugin.gwallet.a.b */
public final class C28276b {
    public int czV;
    public Context mContext;
    public IInAppBillingService npJ;
    private ServiceConnection npK;
    boolean npL = false;
    public boolean npM = false;
    public C21048b npN;
    public String npO;

    /* renamed from: com.tencent.mm.plugin.gwallet.a.b$a */
    public interface C21047a {
        /* renamed from: a */
        void mo7648a(C28282c c28282c);
    }

    /* renamed from: com.tencent.mm.plugin.gwallet.a.b$b */
    public interface C21048b {
        /* renamed from: b */
        void mo7649b(C28282c c28282c, Intent intent);
    }

    /* renamed from: com.tencent.mm.plugin.gwallet.a.b$c */
    public interface C28275c {
        /* renamed from: a */
        void mo46201a(C28282c c28282c, Intent intent);
    }

    /* renamed from: com.tencent.mm.plugin.gwallet.a.b$2 */
    public class C282772 implements Runnable {
        final /* synthetic */ C7306ak mrz;
        final /* synthetic */ List npR;
        final /* synthetic */ C21048b npS;

        public C282772(List list, C21048b c21048b, C7306ak c7306ak) {
            this.npR = list;
            this.npS = c21048b;
            this.mrz = c7306ak;
        }

        /* JADX WARNING: Missing block: B:9:0x002b, code skipped:
            if (r0.equals("") != false) goto L_0x002d;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            AppMethodBeat.m2504i(41694);
            int i = 0;
            for (String str : this.npR) {
                try {
                    C28276b c28276b = C28276b.this;
                    c28276b.mo46202Oz("consume");
                    if (str != null) {
                    }
                    C28276b.m44864OA("Can't consume " + str + ". No token.");
                    int c = c28276b.npJ.mo18555c(3, c28276b.mContext.getPackageName(), str);
                    if (c == 0) {
                        C4990ab.m7410d("MicroMsg.IabHelper", "Successfully consumed token: ".concat(String.valueOf(str)));
                    } else {
                        C4990ab.m7410d("MicroMsg.IabHelper", "Error consuming consuming token ".concat(String.valueOf(str)));
                        C12216a c12216a = new C12216a(c, "Error consuming token ".concat(String.valueOf(str)));
                        AppMethodBeat.m2505o(41694);
                        throw c12216a;
                    }
                } catch (RemoteException e) {
                    C12216a c12216a2 = new C12216a("Remote exception while consuming. token: ".concat(String.valueOf(str)), e);
                    AppMethodBeat.m2505o(41694);
                    throw c12216a2;
                } catch (C12216a e2) {
                    i = e2.npI.bFQ();
                }
            }
            if (this.npS != null) {
                final C28282c c28282c = new C28282c(i, "");
                this.mrz.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(41693);
                        C282772.this.npS.mo7649b(c28282c, null);
                        AppMethodBeat.m2505o(41693);
                    }
                });
            }
            AppMethodBeat.m2505o(41694);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gwallet.a.b$3 */
    public class C282793 implements Runnable {
        final /* synthetic */ C7306ak mrz;
        final /* synthetic */ String npV;
        final /* synthetic */ C21048b npW;

        public C282793(String str, C7306ak c7306ak, C21048b c21048b) {
            this.npV = str;
            this.mrz = c7306ak;
            this.npW = c21048b;
        }

        public final void run() {
            AppMethodBeat.m2504i(41696);
            C28282c c28282c = new C28282c(0, "Inventory refresh successful.");
            final Intent intent = new Intent();
            try {
                int a = C28276b.m44865a(C28276b.this, intent, this.npV);
                if (a != 0) {
                    c28282c = new C28282c(a, "Error refreshing inventory (querying owned items).");
                }
            } catch (RemoteException e) {
                C4990ab.printErrStackTrace("MicroMsg.IabHelper", e, "", new Object[0]);
                c28282c = new C28282c(VError.ERROR_FACE_TXT_INIT, "Remote exception while refreshing inventory.");
            } catch (JSONException e2) {
                C4990ab.printErrStackTrace("MicroMsg.IabHelper", e2, "", new Object[0]);
                c28282c = new C28282c(VError.ERROR_FACE_MODEL_INIT, "Error parsing JSON response while refreshing inventory.");
            }
            intent.putExtra("RESPONSE_CODE", c28282c.bFQ());
            this.mrz.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(41695);
                    C282793.this.npW.mo7649b(c28282c, intent);
                    AppMethodBeat.m2505o(41695);
                }
            });
            AppMethodBeat.m2505o(41696);
        }
    }

    public C28276b(Context context) {
        this.mContext = context;
    }

    /* renamed from: a */
    public final void mo46203a(final C21047a c21047a) {
        AppMethodBeat.m2504i(41697);
        if (this.npL) {
            IllegalStateException illegalStateException = new IllegalStateException("IAB helper is already set up.");
            AppMethodBeat.m2505o(41697);
            throw illegalStateException;
        }
        C4990ab.m7410d("MicroMsg.IabHelper", "Starting in-app billing setup.");
        this.npK = new ServiceConnection() {
            public final void onServiceDisconnected(ComponentName componentName) {
                AppMethodBeat.m2504i(41691);
                C4990ab.m7410d("MicroMsg.IabHelper", "Billing service disconnected.");
                C28276b.this.npJ = null;
                AppMethodBeat.m2505o(41691);
            }

            public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                AppMethodBeat.m2504i(41692);
                C4990ab.m7410d("MicroMsg.IabHelper", "Billing service connected.");
                C28276b.this.npJ = C17502a.m27328f(iBinder);
                String packageName = C28276b.this.mContext.getPackageName();
                try {
                    C4990ab.m7410d("MicroMsg.IabHelper", "Checking for in-app billing 3 support.");
                    int b = C28276b.this.npJ.mo18553b(3, packageName, "inapp");
                    if (b != 0) {
                        if (c21047a != null) {
                            c21047a.mo7648a(new C28282c(b, "Error checking for billing v3 support."));
                        }
                        C28276b.this.npM = false;
                        AppMethodBeat.m2505o(41692);
                        return;
                    }
                    C4990ab.m7410d("MicroMsg.IabHelper", "In-app billing version 3 supported for ".concat(String.valueOf(packageName)));
                    int b2 = C28276b.this.npJ.mo18553b(3, packageName, "subs");
                    if (b2 == 0) {
                        C4990ab.m7410d("MicroMsg.IabHelper", "Subscriptions AVAILABLE.");
                        C28276b.this.npM = true;
                    } else {
                        C4990ab.m7410d("MicroMsg.IabHelper", "Subscriptions NOT AVAILABLE. Response: ".concat(String.valueOf(b2)));
                    }
                    C28276b.this.npL = true;
                    if (c21047a != null) {
                        c21047a.mo7648a(new C28282c(0, "Setup successful."));
                    }
                    AppMethodBeat.m2505o(41692);
                } catch (RemoteException e) {
                    if (c21047a != null) {
                        c21047a.mo7648a(new C28282c(VError.ERROR_FACE_TXT_INIT, "RemoteException while setting up in-app billing."));
                    }
                    C4990ab.printErrStackTrace("MicroMsg.IabHelper", e, "", new Object[0]);
                    AppMethodBeat.m2505o(41692);
                }
            }
        };
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        if (this.mContext == null || this.mContext.getPackageManager() == null || this.mContext.getPackageManager().queryIntentServices(intent, 0) == null || this.mContext.getPackageManager().queryIntentServices(intent, 0).isEmpty()) {
            c21047a.mo7648a(new C28282c(-2001, "Google play not installed!"));
            AppMethodBeat.m2505o(41697);
            return;
        }
        this.mContext.bindService(intent, this.npK, 1);
        AppMethodBeat.m2505o(41697);
    }

    public final void dispose() {
        AppMethodBeat.m2504i(41698);
        C4990ab.m7410d("MicroMsg.IabHelper", "Disposing.");
        this.npL = false;
        if (this.npK != null) {
            C4990ab.m7410d("MicroMsg.IabHelper", "Unbinding from service.");
            try {
                if (this.mContext != null) {
                    this.mContext.unbindService(this.npK);
                }
            } catch (IllegalArgumentException e) {
                C4990ab.m7412e("MicroMsg.IabHelper", e.toString());
            }
            this.npK = null;
            this.npJ = null;
        }
        AppMethodBeat.m2505o(41698);
    }

    /* renamed from: Oz */
    public final void mo46202Oz(String str) {
        AppMethodBeat.m2504i(41699);
        if (this.npL) {
            AppMethodBeat.m2505o(41699);
            return;
        }
        C4990ab.m7412e("MicroMsg.IabHelper", "Illegal state for operation (" + str + "): IAB helper is not set up.");
        IllegalStateException illegalStateException = new IllegalStateException("IAB helper is not set up. Can't perform operation: ".concat(String.valueOf(str)));
        AppMethodBeat.m2505o(41699);
        throw illegalStateException;
    }

    /* renamed from: a */
    public final boolean mo46204a(ArrayList<String> arrayList, C28275c c28275c) {
        AppMethodBeat.m2504i(41700);
        mo46202Oz("query details");
        Intent intent = new Intent();
        C28282c c28282c;
        if (arrayList == null || arrayList.size() == 0) {
            C4990ab.m7412e("MicroMsg.IabHelper", "query list is empty!");
            c28282c = new C28282c(5, "no query list or is empty");
            intent.putExtra("RESPONSE_CODE", 5);
            intent.putExtra("QUERY_DETAIL_INFO", new ArrayList());
            c28275c.mo46201a(c28282c, intent);
            AppMethodBeat.m2505o(41700);
            return true;
        }
        try {
            C4990ab.m7410d("MicroMsg.IabHelper", "query detail list with the size is " + arrayList.size());
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList);
            bundle = this.npJ.getSkuDetails(3, this.mContext.getPackageName(), "inapp", bundle);
            int J = C28276b.m44863J(bundle);
            C4990ab.m7410d("MicroMsg.IabHelper", "detail response: " + String.valueOf(J));
            if (J != 0) {
                C4990ab.m7410d("MicroMsg.IabHelper", "cannot query details");
                c28282c = new C28282c(J, "cannot query details");
                intent.putExtra("RESPONSE_CODE", J);
                c28275c.mo46201a(c28282c, intent);
                AppMethodBeat.m2505o(41700);
                return true;
            }
            C28282c c28282c2 = new C28282c(J, "query list ok!");
            C4990ab.m7410d("MicroMsg.IabHelper", "result code : ".concat(String.valueOf(J)));
            intent.putExtra("RESPONSE_CODE", J);
            intent.putExtra("RESPONSE_QUERY_DETAIL_INFO", bundle.getStringArrayList("DETAILS_LIST"));
            c28275c.mo46201a(c28282c2, intent);
            Iterator it = bundle.getStringArrayList("DETAILS_LIST").iterator();
            while (it.hasNext()) {
                C4990ab.m7410d("MicroMsg.IabHelper", (String) it.next());
            }
            AppMethodBeat.m2505o(41700);
            return true;
        } catch (RemoteException e) {
            C28276b.m44864OA("RemoteException while launching query details ");
            C4990ab.printErrStackTrace("MicroMsg.IabHelper", e, "", new Object[0]);
            c28282c = new C28282c(VError.ERROR_FACE_TXT_INIT, "Remote exception while starting purchase flow");
            intent.putExtra("RESPONSE_CODE", 6);
            intent.putExtra("QUERY_DETAIL_INFO", new ArrayList());
            c28275c.mo46201a(c28282c, intent);
            AppMethodBeat.m2505o(41700);
            return false;
        }
    }

    /* renamed from: wR */
    public static String m44866wR(int i) {
        AppMethodBeat.m2504i(41701);
        String[] split = "0:OK/1:User Canceled/2:Unknown/3:Billing Unavailable/4:Item unavailable/5:Developer Error/6:Error/7:Item Already Owned/8:Item not owned".split("/");
        String[] split2 = "0:OK/-1001:Remote exception during initialization/-1002:Bad response received/-1003:Purchase signature verification failed/-1004:Send intent failed/-1005:User cancelled/-1006:Unknown purchase response/-1007:Missing token/-1008:Unknown error/-1009:Subscriptions not available/-1010:Invalid consumption attempt".split("/");
        String str;
        if (i <= -1000) {
            int i2 = -1000 - i;
            if (i2 < 0 || i2 >= split2.length) {
                str = String.valueOf(i) + ":Unknown IAB Helper Error";
                AppMethodBeat.m2505o(41701);
                return str;
            }
            str = split2[i2];
            AppMethodBeat.m2505o(41701);
            return str;
        } else if (i < 0 || i >= split.length) {
            str = String.valueOf(i) + ":Unknown";
            AppMethodBeat.m2505o(41701);
            return str;
        } else {
            str = split[i];
            AppMethodBeat.m2505o(41701);
            return str;
        }
    }

    /* renamed from: J */
    public static int m44863J(Bundle bundle) {
        AppMethodBeat.m2504i(41702);
        Object obj = bundle.get("RESPONSE_CODE");
        int intValue;
        if (obj == null) {
            C4990ab.m7410d("MicroMsg.IabHelper", "Bundle with null response code, assuming OK (known issue)");
            AppMethodBeat.m2505o(41702);
            return 0;
        } else if (obj instanceof Integer) {
            intValue = ((Integer) obj).intValue();
            AppMethodBeat.m2505o(41702);
            return intValue;
        } else if (obj instanceof Long) {
            intValue = (int) ((Long) obj).longValue();
            AppMethodBeat.m2505o(41702);
            return intValue;
        } else {
            C28276b.m44864OA("Unexpected type for bundle response code.");
            C28276b.m44864OA(obj.getClass().getName());
            RuntimeException runtimeException = new RuntimeException("Unexpected type for bundle response code: " + obj.getClass().getName());
            AppMethodBeat.m2505o(41702);
            throw runtimeException;
        }
    }

    /* renamed from: OA */
    public static void m44864OA(String str) {
        AppMethodBeat.m2504i(41703);
        C4990ab.m7412e("MicroMsg.IabHelper", "In-app billing error: ".concat(String.valueOf(str)));
        AppMethodBeat.m2505o(41703);
    }

    /* renamed from: a */
    static /* synthetic */ int m44865a(C28276b c28276b, Intent intent, String str) {
        AppMethodBeat.m2504i(41704);
        C4990ab.m7410d("MicroMsg.IabHelper", "Querying owned items, item type: ".concat(String.valueOf(str)));
        C4990ab.m7410d("MicroMsg.IabHelper", "Package name: " + c28276b.mContext.getPackageName());
        Object obj = null;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        do {
            C4990ab.m7410d("MicroMsg.IabHelper", "Calling getPurchases with continuation token: ".concat(String.valueOf(obj)));
            Bundle b = c28276b.npJ.mo18554b(3, c28276b.mContext.getPackageName(), str, obj);
            int J = C28276b.m44863J(b);
            C4990ab.m7410d("MicroMsg.IabHelper", "Owned items response: " + String.valueOf(J));
            if (J != 0) {
                C4990ab.m7410d("MicroMsg.IabHelper", "getPurchases() failed: ".concat(String.valueOf(J)));
                AppMethodBeat.m2505o(41704);
                return J;
            } else if (b.containsKey("INAPP_PURCHASE_ITEM_LIST") && b.containsKey("INAPP_PURCHASE_DATA_LIST") && b.containsKey("INAPP_DATA_SIGNATURE_LIST")) {
                arrayList.addAll(b.getStringArrayList("INAPP_PURCHASE_ITEM_LIST"));
                arrayList2.addAll(b.getStringArrayList("INAPP_PURCHASE_DATA_LIST"));
                arrayList3.addAll(b.getStringArrayList("INAPP_DATA_SIGNATURE_LIST"));
                obj = b.getString("INAPP_CONTINUATION_TOKEN");
                C4990ab.m7410d("MicroMsg.IabHelper", "Continuation token: ".concat(String.valueOf(obj)));
            } else {
                C28276b.m44864OA("Bundle returned from getPurchases() doesn't contain required fields.");
                AppMethodBeat.m2505o(41704);
                return VError.ERROR_FACE_MODEL_INIT;
            }
        } while (!TextUtils.isEmpty(obj));
        intent.putStringArrayListExtra("INAPP_PURCHASE_ITEM_LIST", arrayList);
        intent.putStringArrayListExtra("INAPP_PURCHASE_DATA_LIST", arrayList2);
        intent.putStringArrayListExtra("INAPP_DATA_SIGNATURE_LIST", arrayList3);
        AppMethodBeat.m2505o(41704);
        return 0;
    }
}

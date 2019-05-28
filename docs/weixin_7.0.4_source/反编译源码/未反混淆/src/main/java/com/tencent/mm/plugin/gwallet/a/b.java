package com.tencent.mm.plugin.gwallet.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.android.vending.billing.IInAppBillingService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.ttpic.VError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

public final class b {
    public int czV;
    public Context mContext;
    public IInAppBillingService npJ;
    private ServiceConnection npK;
    boolean npL = false;
    public boolean npM = false;
    public b npN;
    public String npO;

    public interface a {
        void a(c cVar);
    }

    public interface b {
        void b(c cVar, Intent intent);
    }

    public interface c {
        void a(c cVar, Intent intent);
    }

    /* renamed from: com.tencent.mm.plugin.gwallet.a.b$2 */
    public class AnonymousClass2 implements Runnable {
        final /* synthetic */ ak mrz;
        final /* synthetic */ List npR;
        final /* synthetic */ b npS;

        public AnonymousClass2(List list, b bVar, ak akVar) {
            this.npR = list;
            this.npS = bVar;
            this.mrz = akVar;
        }

        /* JADX WARNING: Missing block: B:9:0x002b, code skipped:
            if (r0.equals("") != false) goto L_0x002d;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            AppMethodBeat.i(41694);
            int i = 0;
            for (String str : this.npR) {
                try {
                    b bVar = b.this;
                    bVar.Oz("consume");
                    if (str != null) {
                    }
                    b.OA("Can't consume " + str + ". No token.");
                    int c = bVar.npJ.c(3, bVar.mContext.getPackageName(), str);
                    if (c == 0) {
                        ab.d("MicroMsg.IabHelper", "Successfully consumed token: ".concat(String.valueOf(str)));
                    } else {
                        ab.d("MicroMsg.IabHelper", "Error consuming consuming token ".concat(String.valueOf(str)));
                        a aVar = new a(c, "Error consuming token ".concat(String.valueOf(str)));
                        AppMethodBeat.o(41694);
                        throw aVar;
                    }
                } catch (RemoteException e) {
                    a aVar2 = new a("Remote exception while consuming. token: ".concat(String.valueOf(str)), e);
                    AppMethodBeat.o(41694);
                    throw aVar2;
                } catch (a e2) {
                    i = e2.npI.bFQ();
                }
            }
            if (this.npS != null) {
                final c cVar = new c(i, "");
                this.mrz.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(41693);
                        AnonymousClass2.this.npS.b(cVar, null);
                        AppMethodBeat.o(41693);
                    }
                });
            }
            AppMethodBeat.o(41694);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gwallet.a.b$3 */
    public class AnonymousClass3 implements Runnable {
        final /* synthetic */ ak mrz;
        final /* synthetic */ String npV;
        final /* synthetic */ b npW;

        public AnonymousClass3(String str, ak akVar, b bVar) {
            this.npV = str;
            this.mrz = akVar;
            this.npW = bVar;
        }

        public final void run() {
            AppMethodBeat.i(41696);
            c cVar = new c(0, "Inventory refresh successful.");
            final Intent intent = new Intent();
            try {
                int a = b.a(b.this, intent, this.npV);
                if (a != 0) {
                    cVar = new c(a, "Error refreshing inventory (querying owned items).");
                }
            } catch (RemoteException e) {
                ab.printErrStackTrace("MicroMsg.IabHelper", e, "", new Object[0]);
                cVar = new c(VError.ERROR_FACE_TXT_INIT, "Remote exception while refreshing inventory.");
            } catch (JSONException e2) {
                ab.printErrStackTrace("MicroMsg.IabHelper", e2, "", new Object[0]);
                cVar = new c(VError.ERROR_FACE_MODEL_INIT, "Error parsing JSON response while refreshing inventory.");
            }
            intent.putExtra("RESPONSE_CODE", cVar.bFQ());
            this.mrz.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(41695);
                    AnonymousClass3.this.npW.b(cVar, intent);
                    AppMethodBeat.o(41695);
                }
            });
            AppMethodBeat.o(41696);
        }
    }

    public b(Context context) {
        this.mContext = context;
    }

    public final void a(final a aVar) {
        AppMethodBeat.i(41697);
        if (this.npL) {
            IllegalStateException illegalStateException = new IllegalStateException("IAB helper is already set up.");
            AppMethodBeat.o(41697);
            throw illegalStateException;
        }
        ab.d("MicroMsg.IabHelper", "Starting in-app billing setup.");
        this.npK = new ServiceConnection() {
            public final void onServiceDisconnected(ComponentName componentName) {
                AppMethodBeat.i(41691);
                ab.d("MicroMsg.IabHelper", "Billing service disconnected.");
                b.this.npJ = null;
                AppMethodBeat.o(41691);
            }

            public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                AppMethodBeat.i(41692);
                ab.d("MicroMsg.IabHelper", "Billing service connected.");
                b.this.npJ = com.android.vending.billing.IInAppBillingService.a.f(iBinder);
                String packageName = b.this.mContext.getPackageName();
                try {
                    ab.d("MicroMsg.IabHelper", "Checking for in-app billing 3 support.");
                    int b = b.this.npJ.b(3, packageName, "inapp");
                    if (b != 0) {
                        if (aVar != null) {
                            aVar.a(new c(b, "Error checking for billing v3 support."));
                        }
                        b.this.npM = false;
                        AppMethodBeat.o(41692);
                        return;
                    }
                    ab.d("MicroMsg.IabHelper", "In-app billing version 3 supported for ".concat(String.valueOf(packageName)));
                    int b2 = b.this.npJ.b(3, packageName, "subs");
                    if (b2 == 0) {
                        ab.d("MicroMsg.IabHelper", "Subscriptions AVAILABLE.");
                        b.this.npM = true;
                    } else {
                        ab.d("MicroMsg.IabHelper", "Subscriptions NOT AVAILABLE. Response: ".concat(String.valueOf(b2)));
                    }
                    b.this.npL = true;
                    if (aVar != null) {
                        aVar.a(new c(0, "Setup successful."));
                    }
                    AppMethodBeat.o(41692);
                } catch (RemoteException e) {
                    if (aVar != null) {
                        aVar.a(new c(VError.ERROR_FACE_TXT_INIT, "RemoteException while setting up in-app billing."));
                    }
                    ab.printErrStackTrace("MicroMsg.IabHelper", e, "", new Object[0]);
                    AppMethodBeat.o(41692);
                }
            }
        };
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        if (this.mContext == null || this.mContext.getPackageManager() == null || this.mContext.getPackageManager().queryIntentServices(intent, 0) == null || this.mContext.getPackageManager().queryIntentServices(intent, 0).isEmpty()) {
            aVar.a(new c(-2001, "Google play not installed!"));
            AppMethodBeat.o(41697);
            return;
        }
        this.mContext.bindService(intent, this.npK, 1);
        AppMethodBeat.o(41697);
    }

    public final void dispose() {
        AppMethodBeat.i(41698);
        ab.d("MicroMsg.IabHelper", "Disposing.");
        this.npL = false;
        if (this.npK != null) {
            ab.d("MicroMsg.IabHelper", "Unbinding from service.");
            try {
                if (this.mContext != null) {
                    this.mContext.unbindService(this.npK);
                }
            } catch (IllegalArgumentException e) {
                ab.e("MicroMsg.IabHelper", e.toString());
            }
            this.npK = null;
            this.npJ = null;
        }
        AppMethodBeat.o(41698);
    }

    public final void Oz(String str) {
        AppMethodBeat.i(41699);
        if (this.npL) {
            AppMethodBeat.o(41699);
            return;
        }
        ab.e("MicroMsg.IabHelper", "Illegal state for operation (" + str + "): IAB helper is not set up.");
        IllegalStateException illegalStateException = new IllegalStateException("IAB helper is not set up. Can't perform operation: ".concat(String.valueOf(str)));
        AppMethodBeat.o(41699);
        throw illegalStateException;
    }

    public final boolean a(ArrayList<String> arrayList, c cVar) {
        AppMethodBeat.i(41700);
        Oz("query details");
        Intent intent = new Intent();
        c cVar2;
        if (arrayList == null || arrayList.size() == 0) {
            ab.e("MicroMsg.IabHelper", "query list is empty!");
            cVar2 = new c(5, "no query list or is empty");
            intent.putExtra("RESPONSE_CODE", 5);
            intent.putExtra("QUERY_DETAIL_INFO", new ArrayList());
            cVar.a(cVar2, intent);
            AppMethodBeat.o(41700);
            return true;
        }
        try {
            ab.d("MicroMsg.IabHelper", "query detail list with the size is " + arrayList.size());
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList);
            bundle = this.npJ.getSkuDetails(3, this.mContext.getPackageName(), "inapp", bundle);
            int J = J(bundle);
            ab.d("MicroMsg.IabHelper", "detail response: " + String.valueOf(J));
            if (J != 0) {
                ab.d("MicroMsg.IabHelper", "cannot query details");
                cVar2 = new c(J, "cannot query details");
                intent.putExtra("RESPONSE_CODE", J);
                cVar.a(cVar2, intent);
                AppMethodBeat.o(41700);
                return true;
            }
            c cVar3 = new c(J, "query list ok!");
            ab.d("MicroMsg.IabHelper", "result code : ".concat(String.valueOf(J)));
            intent.putExtra("RESPONSE_CODE", J);
            intent.putExtra("RESPONSE_QUERY_DETAIL_INFO", bundle.getStringArrayList("DETAILS_LIST"));
            cVar.a(cVar3, intent);
            Iterator it = bundle.getStringArrayList("DETAILS_LIST").iterator();
            while (it.hasNext()) {
                ab.d("MicroMsg.IabHelper", (String) it.next());
            }
            AppMethodBeat.o(41700);
            return true;
        } catch (RemoteException e) {
            OA("RemoteException while launching query details ");
            ab.printErrStackTrace("MicroMsg.IabHelper", e, "", new Object[0]);
            cVar2 = new c(VError.ERROR_FACE_TXT_INIT, "Remote exception while starting purchase flow");
            intent.putExtra("RESPONSE_CODE", 6);
            intent.putExtra("QUERY_DETAIL_INFO", new ArrayList());
            cVar.a(cVar2, intent);
            AppMethodBeat.o(41700);
            return false;
        }
    }

    public static String wR(int i) {
        AppMethodBeat.i(41701);
        String[] split = "0:OK/1:User Canceled/2:Unknown/3:Billing Unavailable/4:Item unavailable/5:Developer Error/6:Error/7:Item Already Owned/8:Item not owned".split("/");
        String[] split2 = "0:OK/-1001:Remote exception during initialization/-1002:Bad response received/-1003:Purchase signature verification failed/-1004:Send intent failed/-1005:User cancelled/-1006:Unknown purchase response/-1007:Missing token/-1008:Unknown error/-1009:Subscriptions not available/-1010:Invalid consumption attempt".split("/");
        String str;
        if (i <= -1000) {
            int i2 = -1000 - i;
            if (i2 < 0 || i2 >= split2.length) {
                str = String.valueOf(i) + ":Unknown IAB Helper Error";
                AppMethodBeat.o(41701);
                return str;
            }
            str = split2[i2];
            AppMethodBeat.o(41701);
            return str;
        } else if (i < 0 || i >= split.length) {
            str = String.valueOf(i) + ":Unknown";
            AppMethodBeat.o(41701);
            return str;
        } else {
            str = split[i];
            AppMethodBeat.o(41701);
            return str;
        }
    }

    public static int J(Bundle bundle) {
        AppMethodBeat.i(41702);
        Object obj = bundle.get("RESPONSE_CODE");
        int intValue;
        if (obj == null) {
            ab.d("MicroMsg.IabHelper", "Bundle with null response code, assuming OK (known issue)");
            AppMethodBeat.o(41702);
            return 0;
        } else if (obj instanceof Integer) {
            intValue = ((Integer) obj).intValue();
            AppMethodBeat.o(41702);
            return intValue;
        } else if (obj instanceof Long) {
            intValue = (int) ((Long) obj).longValue();
            AppMethodBeat.o(41702);
            return intValue;
        } else {
            OA("Unexpected type for bundle response code.");
            OA(obj.getClass().getName());
            RuntimeException runtimeException = new RuntimeException("Unexpected type for bundle response code: " + obj.getClass().getName());
            AppMethodBeat.o(41702);
            throw runtimeException;
        }
    }

    public static void OA(String str) {
        AppMethodBeat.i(41703);
        ab.e("MicroMsg.IabHelper", "In-app billing error: ".concat(String.valueOf(str)));
        AppMethodBeat.o(41703);
    }

    static /* synthetic */ int a(b bVar, Intent intent, String str) {
        AppMethodBeat.i(41704);
        ab.d("MicroMsg.IabHelper", "Querying owned items, item type: ".concat(String.valueOf(str)));
        ab.d("MicroMsg.IabHelper", "Package name: " + bVar.mContext.getPackageName());
        Object obj = null;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        do {
            ab.d("MicroMsg.IabHelper", "Calling getPurchases with continuation token: ".concat(String.valueOf(obj)));
            Bundle b = bVar.npJ.b(3, bVar.mContext.getPackageName(), str, obj);
            int J = J(b);
            ab.d("MicroMsg.IabHelper", "Owned items response: " + String.valueOf(J));
            if (J != 0) {
                ab.d("MicroMsg.IabHelper", "getPurchases() failed: ".concat(String.valueOf(J)));
                AppMethodBeat.o(41704);
                return J;
            } else if (b.containsKey("INAPP_PURCHASE_ITEM_LIST") && b.containsKey("INAPP_PURCHASE_DATA_LIST") && b.containsKey("INAPP_DATA_SIGNATURE_LIST")) {
                arrayList.addAll(b.getStringArrayList("INAPP_PURCHASE_ITEM_LIST"));
                arrayList2.addAll(b.getStringArrayList("INAPP_PURCHASE_DATA_LIST"));
                arrayList3.addAll(b.getStringArrayList("INAPP_DATA_SIGNATURE_LIST"));
                obj = b.getString("INAPP_CONTINUATION_TOKEN");
                ab.d("MicroMsg.IabHelper", "Continuation token: ".concat(String.valueOf(obj)));
            } else {
                OA("Bundle returned from getPurchases() doesn't contain required fields.");
                AppMethodBeat.o(41704);
                return VError.ERROR_FACE_MODEL_INIT;
            }
        } while (!TextUtils.isEmpty(obj));
        intent.putStringArrayListExtra("INAPP_PURCHASE_ITEM_LIST", arrayList);
        intent.putStringArrayListExtra("INAPP_PURCHASE_DATA_LIST", arrayList2);
        intent.putStringArrayListExtra("INAPP_DATA_SIGNATURE_LIST", arrayList3);
        AppMethodBeat.o(41704);
        return 0;
    }
}

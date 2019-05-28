package com.tencent.mm.wallet_core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.bp.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.lang.ref.WeakReference;

public abstract class c {
    public WeakReference<Context> AeT = new WeakReference(null);
    protected WeakReference<a> Jq;
    public Bundle mqu = new Bundle();

    public interface a {
        Intent n(int i, Bundle bundle);
    }

    public abstract void a(Activity activity, int i, Bundle bundle);

    public abstract void b(Activity activity, Bundle bundle);

    public abstract String bxP();

    public abstract void c(Activity activity, int i);

    public abstract boolean c(Activity activity, Bundle bundle);

    public final c aE(Bundle bundle) {
        this.mqu.putAll(bundle);
        return this;
    }

    private static String cY(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof Bundle) {
            return String.format("Bundle: %s, ", new Object[]{obj.toString()});
        } else if (obj instanceof Context) {
            return String.format("Context: %s, ", new Object[]{obj.toString()});
        } else if (obj instanceof Class) {
            return String.format("Class: %s, ", new Object[]{((Class) obj).getSimpleName()});
        } else {
            return String.format("Value: %s, ", new Object[]{obj.toString()});
        }
    }

    private String s(Object... objArr) {
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("this %s, procname %s", new Object[]{this, bxP()}));
        if (objArr == null || objArr.length <= 0) {
            ab.w("MicroMsg.ProcessManager", "vals is null, use '' as value");
            return stringBuilder.toString();
        }
        int length = objArr.length - 1;
        while (i < length) {
            stringBuilder.append(cY(objArr[i])).append(',');
            i++;
        }
        stringBuilder.append(cY(objArr[length]));
        return stringBuilder.toString();
    }

    public final void F(Object... objArr) {
        ab.i("MicroMsg.ProcessManager", "__CURRENT__ %s", s(objArr));
    }

    public final void a(Activity activity, Class<?> cls, Bundle bundle, Bundle bundle2) {
        F("startActivity1", activity, cls, bundle);
        Intent intent = new Intent(activity, cls);
        intent.putExtra("process_id", getClass().hashCode());
        if (bundle2 != null) {
            intent.putExtras(bundle2);
            ab.d("MicroMsg.ProcessManager", "put bundle: %s", intent.getExtras().toString());
        }
        activity.startActivity(intent);
        if (bundle != null) {
            this.mqu.putAll(bundle);
        }
        ab.d("MicroMsg.ProcessManager", "bankcard tag :" + dNE());
    }

    public final void b(Activity activity, Class<?> cls, Bundle bundle) {
        F("startActivity1", activity, cls, bundle);
        Intent intent = new Intent(activity, cls);
        intent.putExtra("process_id", getClass().hashCode());
        activity.startActivity(intent);
        if (bundle != null) {
            this.mqu.putAll(bundle);
        }
        ab.d("MicroMsg.ProcessManager", "bankcard tag :" + dNE());
    }

    public final void a(Activity activity, String str, String str2, Bundle bundle) {
        F("startActivity3", activity, str, str2, bundle);
        Class hM = d.hM(str, str2);
        if (hM != null) {
            b(activity, hM, bundle);
        } else {
            ab.e("MicroMsg.ProcessManager", " Class Not Found! can't startActivity to " + str + str2);
        }
    }

    public final void a(Activity activity, Class<?> cls, Bundle bundle, int i) {
        F("startActivityForResult1", activity, cls, bundle, Integer.valueOf(i));
        Intent intent = new Intent(activity, cls);
        intent.putExtra("process_id", getClass().hashCode());
        intent.addFlags(67108864);
        activity.startActivityForResult(intent, i);
        if (bundle != null) {
            this.mqu.putAll(bundle);
        }
    }

    public void F(Activity activity) {
        F("finishActivity", activity);
        if (!activity.isFinishing() && (activity instanceof MMActivity)) {
            ((MMActivity) activity).finish();
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void b(Activity activity, Class<?> cls, Bundle bundle, int i) {
        F("finishActivity", activity, cls, "errCode ".concat(String.valueOf(i)));
        Intent intent = new Intent(activity, cls);
        intent.putExtra("process_id", getClass().hashCode());
        intent.addFlags(67108864);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        activity.startActivity(intent);
        this.mqu.putInt("key_err_code", i);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(Activity activity, Class<?> cls, int i) {
        b(activity, cls, null, i);
    }

    public c a(Activity activity, Bundle bundle) {
        return this;
    }

    public final void a(a aVar, Context context) {
        this.Jq = new WeakReference(aVar);
        this.AeT = new WeakReference(context);
    }

    public final void dND() {
        this.Jq = null;
        this.AeT = null;
    }

    public final void aF(Activity activity) {
        F("specEndProcess", activity);
        if (!activity.isFinishing() && (activity instanceof MMActivity)) {
            ((MMActivity) activity).finish();
        }
        if (this.mqu != null) {
            this.mqu.clear();
        }
        a.remove(getClass().hashCode());
        cNF();
    }

    public final void aG(Activity activity) {
        F("endProcess1", activity);
        if (!activity.isFinishing() && (activity instanceof MMActivity)) {
            ((MMActivity) activity).finish();
        }
        if (this.mqu != null) {
            this.mqu.clear();
        }
        a.remove(getClass().hashCode());
    }

    public final void l(Activity activity, Bundle bundle) {
        F("endProcess1", activity);
        if (!activity.isFinishing() && (activity instanceof MMActivity)) {
            ((MMActivity) activity).finish();
        }
        if (this.Jq.get() != null) {
            ((a) this.Jq.get()).n(0, bundle);
        }
        if (bundle != null) {
            bundle.clear();
        }
        a.remove(getClass().hashCode());
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(Activity activity, Class<?> cls, int i, Intent intent, boolean z) {
        Intent n;
        F("endProcess2", activity, cls, Integer.valueOf(i), intent, Boolean.valueOf(z));
        if (this.Jq.get() != null) {
            n = ((a) this.Jq.get()).n(i, this.mqu);
        } else {
            n = intent;
        }
        if (n == null) {
            n = new Intent(activity, cls);
            n.putExtra("key_process_is_stay", z);
        } else if (!(n.getExtras() == null || n.getExtras().containsKey("key_process_is_stay"))) {
            n.putExtra("key_process_is_stay", true);
        }
        if (cls != null) {
            n.setClass(activity, cls);
        }
        n.addFlags(67108864);
        n.putExtra("key_process_is_end", true);
        activity.startActivity(n);
        if (this.mqu != null) {
            this.mqu.clear();
        }
        a.remove(getClass().hashCode());
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(Activity activity, String str, String str2, int i, boolean z) {
        a(activity, str, str2, i, null, z);
    }

    public final void a(Activity activity, String str, String str2, int i, Intent intent, boolean z) {
        F("endProcess3", activity, str, str2, Integer.valueOf(i), intent, Boolean.valueOf(z));
        Intent intent2 = null;
        if (this.Jq.get() != null) {
            intent2 = ((a) this.Jq.get()).n(i, this.mqu);
        }
        if (intent == null) {
            intent = new Intent();
            intent.putExtra("key_process_is_stay", z);
        } else if (!(intent.getExtras() == null || intent.getExtras().containsKey("key_process_is_stay"))) {
            intent.putExtra("key_process_is_stay", true);
        }
        if (intent2 != null) {
            intent.putExtras(intent2);
        }
        intent.addFlags(67108864);
        intent.putExtra("key_process_is_end", true);
        d.b((Context) activity, str, str2, intent);
        if (this.mqu != null) {
            this.mqu.clear();
        }
        a.remove(getClass().hashCode());
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(Activity activity, Class<?> cls, Intent intent) {
        a(activity, (Class) cls, -1, intent, true);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(Activity activity, Class<?> cls, int i, boolean z) {
        a(activity, (Class) cls, i, null, z);
    }

    /* Access modifiers changed, original: protected|final */
    public final void c(Activity activity, Class<?> cls) {
        a(activity, (Class) cls, -1, null, true);
    }

    /* Access modifiers changed, original: protected|final */
    public final void d(Activity activity, String str, String str2) {
        a(activity, str, str2, -1, true);
    }

    public final int dNE() {
        return this.mqu.getInt("key_support_bankcard", 1);
    }

    public final boolean cRY() {
        return this.mqu.getBoolean("key_is_oversea", false);
    }

    public final boolean dNF() {
        return this.mqu.getInt("key_pay_flag", 0) == 2;
    }

    public final boolean dNG() {
        return this.mqu.getInt("key_pay_flag", 0) == 1;
    }

    public final boolean dNH() {
        return this.mqu.getInt("key_pay_flag", 0) == 3;
    }

    public g a(MMActivity mMActivity, i iVar) {
        return null;
    }

    public boolean h(Activity activity, Bundle bundle) {
        return false;
    }

    public final boolean dNI() {
        String string = this.mqu.getString("key_bank_username");
        ab.i("MicroMsg.ProcessManager", "follow bank account : isFollow " + this.mqu.getBoolean("key_is_follow_bank_username", false) + ", username : " + string);
        if (!this.mqu.getBoolean("key_is_follow_bank_username", false) || bo.isNullOrNil(string)) {
            return false;
        }
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.a(new r(string), 0);
        return true;
    }

    public int a(MMActivity mMActivity, int i) {
        return -1;
    }

    public boolean a(WalletBaseUI walletBaseUI, int i, String str) {
        return false;
    }

    public void cNF() {
    }

    public void a(WalletBaseUI walletBaseUI) {
    }

    public void b(WalletBaseUI walletBaseUI) {
    }
}

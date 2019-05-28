package com.tencent.p177mm.wallet_core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p649c.C44431r;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.p177mm.wallet_core.p760d.C30868i;
import com.tencent.p177mm.wallet_core.p760d.C44432g;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.wallet_core.c */
public abstract class C40931c {
    public WeakReference<Context> AeT = new WeakReference(null);
    /* renamed from: Jq */
    protected WeakReference<C30857a> f16226Jq;
    public Bundle mqu = new Bundle();

    /* renamed from: com.tencent.mm.wallet_core.c$a */
    public interface C30857a {
        /* renamed from: n */
        Intent mo7785n(int i, Bundle bundle);
    }

    /* renamed from: a */
    public abstract void mo8124a(Activity activity, int i, Bundle bundle);

    /* renamed from: b */
    public abstract void mo8125b(Activity activity, Bundle bundle);

    public abstract String bxP();

    /* renamed from: c */
    public abstract void mo8127c(Activity activity, int i);

    /* renamed from: c */
    public abstract boolean mo8128c(Activity activity, Bundle bundle);

    /* renamed from: aE */
    public final C40931c mo64568aE(Bundle bundle) {
        this.mqu.putAll(bundle);
        return this;
    }

    /* renamed from: cY */
    private static String m70962cY(Object obj) {
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

    /* renamed from: s */
    private String m70963s(Object... objArr) {
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("this %s, procname %s", new Object[]{this, bxP()}));
        if (objArr == null || objArr.length <= 0) {
            C4990ab.m7420w("MicroMsg.ProcessManager", "vals is null, use '' as value");
            return stringBuilder.toString();
        }
        int length = objArr.length - 1;
        while (i < length) {
            stringBuilder.append(C40931c.m70962cY(objArr[i])).append(',');
            i++;
        }
        stringBuilder.append(C40931c.m70962cY(objArr[length]));
        return stringBuilder.toString();
    }

    /* renamed from: F */
    public final void mo64557F(Object... objArr) {
        C4990ab.m7417i("MicroMsg.ProcessManager", "__CURRENT__ %s", m70963s(objArr));
    }

    /* renamed from: a */
    public final void mo64563a(Activity activity, Class<?> cls, Bundle bundle, Bundle bundle2) {
        mo64557F("startActivity1", activity, cls, bundle);
        Intent intent = new Intent(activity, cls);
        intent.putExtra("process_id", getClass().hashCode());
        if (bundle2 != null) {
            intent.putExtras(bundle2);
            C4990ab.m7411d("MicroMsg.ProcessManager", "put bundle: %s", intent.getExtras().toString());
        }
        activity.startActivity(intent);
        if (bundle != null) {
            this.mqu.putAll(bundle);
        }
        C4990ab.m7410d("MicroMsg.ProcessManager", "bankcard tag :" + dNE());
    }

    /* renamed from: b */
    public final void mo64571b(Activity activity, Class<?> cls, Bundle bundle) {
        mo64557F("startActivity1", activity, cls, bundle);
        Intent intent = new Intent(activity, cls);
        intent.putExtra("process_id", getClass().hashCode());
        activity.startActivity(intent);
        if (bundle != null) {
            this.mqu.putAll(bundle);
        }
        C4990ab.m7410d("MicroMsg.ProcessManager", "bankcard tag :" + dNE());
    }

    /* renamed from: a */
    public final void mo64566a(Activity activity, String str, String str2, Bundle bundle) {
        mo64557F("startActivity3", activity, str, str2, bundle);
        Class hM = C25985d.m41475hM(str, str2);
        if (hM != null) {
            mo64571b(activity, hM, bundle);
        } else {
            C4990ab.m7412e("MicroMsg.ProcessManager", " Class Not Found! can't startActivity to " + str + str2);
        }
    }

    /* renamed from: a */
    public final void mo64562a(Activity activity, Class<?> cls, Bundle bundle, int i) {
        mo64557F("startActivityForResult1", activity, cls, bundle, Integer.valueOf(i));
        Intent intent = new Intent(activity, cls);
        intent.putExtra("process_id", getClass().hashCode());
        intent.addFlags(67108864);
        activity.startActivityForResult(intent, i);
        if (bundle != null) {
            this.mqu.putAll(bundle);
        }
    }

    /* renamed from: F */
    public void mo55241F(Activity activity) {
        mo64557F("finishActivity", activity);
        if (!activity.isFinishing() && (activity instanceof MMActivity)) {
            ((MMActivity) activity).finish();
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: b */
    public final void mo64572b(Activity activity, Class<?> cls, Bundle bundle, int i) {
        mo64557F("finishActivity", activity, cls, "errCode ".concat(String.valueOf(i)));
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
    /* renamed from: a */
    public final void mo64558a(Activity activity, Class<?> cls, int i) {
        mo64572b(activity, cls, null, i);
    }

    /* renamed from: a */
    public C40931c mo8123a(Activity activity, Bundle bundle) {
        return this;
    }

    /* renamed from: a */
    public final void mo64567a(C30857a c30857a, Context context) {
        this.f16226Jq = new WeakReference(c30857a);
        this.AeT = new WeakReference(context);
    }

    public final void dND() {
        this.f16226Jq = null;
        this.AeT = null;
    }

    /* renamed from: aF */
    public final void mo64569aF(Activity activity) {
        mo64557F("specEndProcess", activity);
        if (!activity.isFinishing() && (activity instanceof MMActivity)) {
            ((MMActivity) activity).finish();
        }
        if (this.mqu != null) {
            this.mqu.clear();
        }
        C24143a.remove(getClass().hashCode());
        cNF();
    }

    /* renamed from: aG */
    public final void mo64570aG(Activity activity) {
        mo64557F("endProcess1", activity);
        if (!activity.isFinishing() && (activity instanceof MMActivity)) {
            ((MMActivity) activity).finish();
        }
        if (this.mqu != null) {
            this.mqu.clear();
        }
        C24143a.remove(getClass().hashCode());
    }

    /* renamed from: l */
    public final void mo64582l(Activity activity, Bundle bundle) {
        mo64557F("endProcess1", activity);
        if (!activity.isFinishing() && (activity instanceof MMActivity)) {
            ((MMActivity) activity).finish();
        }
        if (this.f16226Jq.get() != null) {
            ((C30857a) this.f16226Jq.get()).mo7785n(0, bundle);
        }
        if (bundle != null) {
            bundle.clear();
        }
        C24143a.remove(getClass().hashCode());
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo64559a(Activity activity, Class<?> cls, int i, Intent intent, boolean z) {
        Intent n;
        mo64557F("endProcess2", activity, cls, Integer.valueOf(i), intent, Boolean.valueOf(z));
        if (this.f16226Jq.get() != null) {
            n = ((C30857a) this.f16226Jq.get()).mo7785n(i, this.mqu);
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
        C24143a.remove(getClass().hashCode());
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo64565a(Activity activity, String str, String str2, int i, boolean z) {
        mo64564a(activity, str, str2, i, null, z);
    }

    /* renamed from: a */
    public final void mo64564a(Activity activity, String str, String str2, int i, Intent intent, boolean z) {
        mo64557F("endProcess3", activity, str, str2, Integer.valueOf(i), intent, Boolean.valueOf(z));
        Intent intent2 = null;
        if (this.f16226Jq.get() != null) {
            intent2 = ((C30857a) this.f16226Jq.get()).mo7785n(i, this.mqu);
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
        C25985d.m41467b((Context) activity, str, str2, intent);
        if (this.mqu != null) {
            this.mqu.clear();
        }
        C24143a.remove(getClass().hashCode());
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo64561a(Activity activity, Class<?> cls, Intent intent) {
        mo64559a(activity, (Class) cls, -1, intent, true);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo64560a(Activity activity, Class<?> cls, int i, boolean z) {
        mo64559a(activity, (Class) cls, i, null, z);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: c */
    public final void mo64573c(Activity activity, Class<?> cls) {
        mo64559a(activity, (Class) cls, -1, null, true);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: d */
    public final void mo64575d(Activity activity, String str, String str2) {
        mo64565a(activity, str, str2, -1, true);
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

    /* renamed from: a */
    public C44432g mo24745a(MMActivity mMActivity, C30868i c30868i) {
        return null;
    }

    /* renamed from: h */
    public boolean mo38264h(Activity activity, Bundle bundle) {
        return false;
    }

    public final boolean dNI() {
        String string = this.mqu.getString("key_bank_username");
        C4990ab.m7416i("MicroMsg.ProcessManager", "follow bank account : isFollow " + this.mqu.getBoolean("key_is_follow_bank_username", false) + ", username : " + string);
        if (!this.mqu.getBoolean("key_is_follow_bank_username", false) || C5046bo.isNullOrNil(string)) {
            return false;
        }
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14541a(new C44431r(string), 0);
        return true;
    }

    /* renamed from: a */
    public int mo26468a(MMActivity mMActivity, int i) {
        return -1;
    }

    /* renamed from: a */
    public boolean mo26470a(WalletBaseUI walletBaseUI, int i, String str) {
        return false;
    }

    public void cNF() {
    }

    /* renamed from: a */
    public void mo26469a(WalletBaseUI walletBaseUI) {
    }

    /* renamed from: b */
    public void mo26471b(WalletBaseUI walletBaseUI) {
    }
}

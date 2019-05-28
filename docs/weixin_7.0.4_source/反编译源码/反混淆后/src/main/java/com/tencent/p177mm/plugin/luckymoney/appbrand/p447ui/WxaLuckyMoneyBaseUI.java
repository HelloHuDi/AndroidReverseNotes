package com.tencent.p177mm.plugin.luckymoney.appbrand.p447ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.p057v4.widget.C8415j;
import android.util.SparseArray;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.luckymoney.appbrand.p447ui.C3362d.C3361a;
import com.tencent.p177mm.plugin.luckymoney.appbrand.p447ui.detail.C21190b;
import com.tencent.p177mm.plugin.luckymoney.appbrand.p447ui.detail.WxaLuckyMoneyDetailUI;
import com.tencent.p177mm.plugin.luckymoney.appbrand.p447ui.prepare.C28402b;
import com.tencent.p177mm.plugin.luckymoney.appbrand.p447ui.prepare.C39309c;
import com.tencent.p177mm.plugin.luckymoney.appbrand.p447ui.prepare.WxaLuckyMoneyCompleteUI;
import com.tencent.p177mm.plugin.luckymoney.appbrand.p447ui.prepare.WxaLuckyMoneyPrepareUI;
import com.tencent.p177mm.plugin.luckymoney.appbrand.p447ui.receive.C34432b;
import com.tencent.p177mm.plugin.luckymoney.appbrand.p447ui.receive.WxaLuckyMoneyReceiveUI;
import com.tencent.p177mm.plugin.luckymoney.p449ui.C43284j;
import com.tencent.p177mm.plugin.luckymoney.p449ui.C43284j.C43283a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI */
public abstract class WxaLuckyMoneyBaseUI extends MMActivity {
    private C3360c nSh = null;
    private int nSi = 4095;
    private final SparseArray<C3361a> nSj = new SparseArray();
    private final Class[][] nSk;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WxaLuckyMoneyBaseUI() {
        r0 = new Class[4][];
        r0[0] = new Class[]{C34432b.class, WxaLuckyMoneyReceiveUI.class};
        r0[1] = new Class[]{C39309c.class, WxaLuckyMoneyPrepareUI.class};
        r0[2] = new Class[]{C21190b.class, WxaLuckyMoneyDetailUI.class};
        r0[3] = new Class[]{C28402b.class, WxaLuckyMoneyCompleteUI.class};
        this.nSk = r0;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nSh = new C3360c(this);
        this.nSh.oic = 1;
        C3360c c3360c = this.nSh;
        MMActivity mMActivity = c3360c.knn;
        int i = c3360c.oic;
        C43283a c43283a = new C43283a();
        Resources resources = mMActivity.getResources();
        switch (i) {
            case 1:
                c43283a.oie = new ColorDrawable(resources.getColor(C25738R.color.f12134tl));
                c43283a.jlo = resources.getColor(C25738R.color.f12135tm);
                c43283a.oif = resources.getColor(C25738R.color.f12140tt);
                c43283a.oig = resources.getColor(C25738R.color.f12140tt);
                c43283a.oih = C25738R.drawable.f6818rs;
                c43283a.oii = resources.getColor(C25738R.color.f12147u0);
                break;
            default:
                c43283a.oie = resources.getDrawable(C25738R.drawable.b8e);
                c43283a.jlo = -1;
                c43283a.oig = resources.getColor(C25738R.color.f12161ug);
                c43283a.oii = resources.getColor(C25738R.color.f12131th);
                break;
        }
        if (c3360c.knn.getSupportActionBar() != null) {
            if (c43283a.oie != null) {
                c3360c.knn.getSupportActionBar().setBackgroundDrawable(c43283a.oie);
            }
            View customView = c3360c.knn.getSupportActionBar().getCustomView();
            if (customView != null) {
                View findViewById = customView.findViewById(2131821128);
                if (!(findViewById == null || c43283a.jlo == 0)) {
                    findViewById.setBackgroundColor(c43283a.jlo);
                }
                TextView textView = (TextView) customView.findViewById(16908308);
                if (!(textView == null || c43283a.oif == 0)) {
                    textView.setTextColor(c43283a.oif);
                }
                textView = (TextView) customView.findViewById(16908309);
                if (!(textView == null || c43283a.oig == 0)) {
                    textView.setTextColor(c43283a.oig);
                }
                ImageView imageView = (ImageView) customView.findViewById(2131820974);
                if (!(imageView == null || c43283a.oih == 0)) {
                    imageView.setImageResource(c43283a.oih);
                }
            }
            if (c43283a.oii != 0) {
                int i2 = c43283a.oii;
                if (C43284j.bMM()) {
                    Window window = c3360c.knn.getWindow();
                    window.addFlags(C8415j.INVALID_ID);
                    window.setStatusBarColor(i2);
                }
            }
        }
    }

    /* renamed from: t */
    public final void mo73981t(Drawable drawable) {
        this.nSh.mo7772t(drawable);
    }

    public void onDestroy() {
        this.nSh = null;
        this.nSj.clear();
        super.onDestroy();
    }

    /* renamed from: aq */
    private Class<? extends MMActivity> m85789aq(Class cls) {
        Class<? extends MMActivity> cls2 = null;
        for (Class<? extends MMActivity>[] clsArr : this.nSk) {
            if (clsArr[0] == cls) {
                cls2 = clsArr[1];
            }
        }
        return cls2;
    }

    /* renamed from: a */
    public final void mo73979a(final Class cls, final Intent intent, final C3361a c3361a) {
        if (getMainLooper().getThread() != Thread.currentThread()) {
            runOnUiThread(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(42002);
                    WxaLuckyMoneyBaseUI.this.mo73979a(cls, intent, c3361a);
                    AppMethodBeat.m2505o(42002);
                }
            });
            return;
        }
        if (intent == null) {
            intent = new Intent();
        }
        Class aq = m85789aq(cls);
        if (aq == null) {
            throw new IllegalStateException("proceed to ui = [" + cls.getName() + "], but Target is null");
        }
        intent.setClass(this.mController.ylL, aq);
        if (c3361a == null) {
            startActivity(intent);
            return;
        }
        int i = this.nSi;
        this.nSi = i + 1;
        startActivityForResult(intent, i);
        this.nSj.put(i, c3361a);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        C3361a c3361a = (C3361a) this.nSj.get(i);
        if (c3361a != null) {
            C4990ab.m7417i("MicroMsg.HjLuckyMoneyBaseUI", "damon warns you, requestCode == [%d], I used it, and skip. check your code if needed!!!!", Integer.valueOf(i));
            c3361a.mo7773d(i2, intent);
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    /* renamed from: c */
    public final void mo73980c(int i, Intent intent) {
        setResult(i, intent);
        finish();
    }
}

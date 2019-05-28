package com.tencent.mm.plugin.luckymoney.appbrand.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.d.a;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.WxaLuckyMoneyDetailUI;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyCompleteUI;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.c;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.WxaLuckyMoneyReceiveUI;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.b;
import com.tencent.mm.plugin.luckymoney.ui.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;

public abstract class WxaLuckyMoneyBaseUI extends MMActivity {
    private c nSh = null;
    private int nSi = 4095;
    private final SparseArray<a> nSj = new SparseArray();
    private final Class[][] nSk;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WxaLuckyMoneyBaseUI() {
        r0 = new Class[4][];
        r0[0] = new Class[]{b.class, WxaLuckyMoneyReceiveUI.class};
        r0[1] = new Class[]{c.class, WxaLuckyMoneyPrepareUI.class};
        r0[2] = new Class[]{com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.b.class, WxaLuckyMoneyDetailUI.class};
        r0[3] = new Class[]{com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.b.class, WxaLuckyMoneyCompleteUI.class};
        this.nSk = r0;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nSh = new c(this);
        this.nSh.oic = 1;
        c cVar = this.nSh;
        MMActivity mMActivity = cVar.knn;
        int i = cVar.oic;
        j.a aVar = new j.a();
        Resources resources = mMActivity.getResources();
        switch (i) {
            case 1:
                aVar.oie = new ColorDrawable(resources.getColor(R.color.tl));
                aVar.jlo = resources.getColor(R.color.tm);
                aVar.oif = resources.getColor(R.color.tt);
                aVar.oig = resources.getColor(R.color.tt);
                aVar.oih = R.drawable.rs;
                aVar.oii = resources.getColor(R.color.u0);
                break;
            default:
                aVar.oie = resources.getDrawable(R.drawable.b8e);
                aVar.jlo = -1;
                aVar.oig = resources.getColor(R.color.ug);
                aVar.oii = resources.getColor(R.color.th);
                break;
        }
        if (cVar.knn.getSupportActionBar() != null) {
            if (aVar.oie != null) {
                cVar.knn.getSupportActionBar().setBackgroundDrawable(aVar.oie);
            }
            View customView = cVar.knn.getSupportActionBar().getCustomView();
            if (customView != null) {
                View findViewById = customView.findViewById(R.id.p3);
                if (!(findViewById == null || aVar.jlo == 0)) {
                    findViewById.setBackgroundColor(aVar.jlo);
                }
                TextView textView = (TextView) customView.findViewById(16908308);
                if (!(textView == null || aVar.oif == 0)) {
                    textView.setTextColor(aVar.oif);
                }
                textView = (TextView) customView.findViewById(16908309);
                if (!(textView == null || aVar.oig == 0)) {
                    textView.setTextColor(aVar.oig);
                }
                ImageView imageView = (ImageView) customView.findViewById(R.id.kx);
                if (!(imageView == null || aVar.oih == 0)) {
                    imageView.setImageResource(aVar.oih);
                }
            }
            if (aVar.oii != 0) {
                int i2 = aVar.oii;
                if (j.bMM()) {
                    Window window = cVar.knn.getWindow();
                    window.addFlags(android.support.v4.widget.j.INVALID_ID);
                    window.setStatusBarColor(i2);
                }
            }
        }
    }

    public final void t(Drawable drawable) {
        this.nSh.t(drawable);
    }

    public void onDestroy() {
        this.nSh = null;
        this.nSj.clear();
        super.onDestroy();
    }

    private Class<? extends MMActivity> aq(Class cls) {
        Class<? extends MMActivity> cls2 = null;
        for (Class<? extends MMActivity>[] clsArr : this.nSk) {
            if (clsArr[0] == cls) {
                cls2 = clsArr[1];
            }
        }
        return cls2;
    }

    public final void a(final Class cls, final Intent intent, final a aVar) {
        if (getMainLooper().getThread() != Thread.currentThread()) {
            runOnUiThread(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(42002);
                    WxaLuckyMoneyBaseUI.this.a(cls, intent, aVar);
                    AppMethodBeat.o(42002);
                }
            });
            return;
        }
        if (intent == null) {
            intent = new Intent();
        }
        Class aq = aq(cls);
        if (aq == null) {
            throw new IllegalStateException("proceed to ui = [" + cls.getName() + "], but Target is null");
        }
        intent.setClass(this.mController.ylL, aq);
        if (aVar == null) {
            startActivity(intent);
            return;
        }
        int i = this.nSi;
        this.nSi = i + 1;
        startActivityForResult(intent, i);
        this.nSj.put(i, aVar);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        a aVar = (a) this.nSj.get(i);
        if (aVar != null) {
            ab.i("MicroMsg.HjLuckyMoneyBaseUI", "damon warns you, requestCode == [%d], I used it, and skip. check your code if needed!!!!", Integer.valueOf(i));
            aVar.d(i2, intent);
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    public final void c(int i, Intent intent) {
        setResult(i, intent);
        finish();
    }
}

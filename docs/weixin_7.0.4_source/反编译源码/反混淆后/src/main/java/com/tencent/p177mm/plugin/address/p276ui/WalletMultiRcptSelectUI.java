package com.tencent.p177mm.plugin.address.p276ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.base.preference.PreferenceSmallCategory;
import com.tencent.p177mm.plugin.address.model.RcptItem;
import com.tencent.p177mm.plugin.address.p1467a.C33045a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.address.ui.WalletMultiRcptSelectUI */
public class WalletMultiRcptSelectUI extends MMPreference {
    private int cGC = 0;
    private C15541f ehK;
    private RcptItem gKW = null;
    private RcptItem gKX = null;
    private List<RcptItem> gKY;

    /* renamed from: com.tencent.mm.plugin.address.ui.WalletMultiRcptSelectUI$1 */
    class C446931 implements OnMenuItemClickListener {
        C446931() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(16964);
            WalletMultiRcptSelectUI.m81307a(WalletMultiRcptSelectUI.this);
            AppMethodBeat.m2505o(16964);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m81307a(WalletMultiRcptSelectUI walletMultiRcptSelectUI) {
        AppMethodBeat.m2504i(16975);
        walletMultiRcptSelectUI.asi();
        AppMethodBeat.m2505o(16975);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void ash() {
        AppMethodBeat.m2504i(16965);
        List list = C33045a.arS().gIR;
        if (list == null || list.isEmpty()) {
            C4990ab.m7412e("MicroMsg.MultiRptSelectUI", "list == null || list.isEmpty(), need loadata!");
            C33045a.arS().arT();
        }
        switch (this.cGC) {
            case 0:
                C33045a.arQ();
                list = C33045a.arS().gIR;
                break;
            case 1:
                if (!(this.gKW == null || C5046bo.isNullOrNil(this.gKW.code))) {
                    C33045a.arQ();
                    list = C33045a.arS().mo67845wC(this.gKW.code);
                    break;
                }
            case 2:
                if (!(this.gKX == null || C5046bo.isNullOrNil(this.gKX.code))) {
                    C33045a.arQ();
                    list = C33045a.arS().mo67846wD(this.gKX.code);
                    break;
                }
            default:
                C33045a.arQ();
                list = C33045a.arS().gIR;
                break;
        }
        this.gKY = list;
        if (this.gKY == null || this.gKY.size() <= 0) {
            C4990ab.m7412e("MicroMsg.MultiRptSelectUI", "initZoneItems error ,check zone lists!");
            AppMethodBeat.m2505o(16965);
            return;
        }
        this.ehK.removeAll();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gKY.size()) {
                if (!(this.gKY.get(i2) == null || C5046bo.isNullOrNil(((RcptItem) this.gKY.get(i2)).name))) {
                    RcptPreference rcptPreference = new RcptPreference(this);
                    RcptItem rcptItem = (RcptItem) this.gKY.get(i2);
                    if (rcptItem == null || C5046bo.isNullOrNil(rcptItem.name)) {
                        C4990ab.m7412e("MicroMsg.RcptPreference", "setZoneItem item = null");
                    } else {
                        rcptPreference.setKey(rcptItem.code + rcptPreference.hashCode());
                        rcptPreference.gKN = rcptItem;
                    }
                    this.ehK.mo27713b(rcptPreference);
                }
                i = i2 + 1;
            } else {
                this.ehK.mo27713b(new PreferenceSmallCategory(this));
                AppMethodBeat.m2505o(16965);
                return;
            }
        }
    }

    private void asi() {
        AppMethodBeat.m2504i(16966);
        switch (this.cGC) {
            case 1:
                this.gKW = null;
                this.cGC = 0;
                break;
            case 2:
                this.gKX = null;
                this.cGC = 1;
                break;
        }
        Intent intent = new Intent();
        intent.putExtra("key_stage", this.cGC);
        intent.putExtra("key_province", this.gKW);
        intent.putExtra("key_city", this.gKX);
        setResult(0, intent);
        finish();
        AppMethodBeat.m2505o(16966);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(16967);
        super.onCreate(bundle);
        this.ehK = this.yCw;
        initView();
        AppMethodBeat.m2505o(16967);
    }

    public void onResume() {
        AppMethodBeat.m2504i(16968);
        super.onResume();
        AppMethodBeat.m2505o(16968);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(16969);
        super.onDestroy();
        AppMethodBeat.m2505o(16969);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8533bh;
    }

    public final void initView() {
        int i = C25738R.string.f8775em;
        AppMethodBeat.m2504i(16970);
        Intent intent = getIntent();
        if (intent != null) {
            i = intent.getIntExtra("ui_title", C25738R.string.f8775em);
        }
        setMMTitle(i);
        setBackBtn(new C446931());
        m81308x(intent);
        ash();
        AppMethodBeat.m2505o(16970);
    }

    /* renamed from: x */
    private void m81308x(Intent intent) {
        AppMethodBeat.m2504i(16971);
        if (intent == null) {
            C4990ab.m7412e("MicroMsg.MultiRptSelectUI", "initData intent is null");
            AppMethodBeat.m2505o(16971);
            return;
        }
        this.cGC = intent.getIntExtra("key_stage", 0);
        this.gKW = (RcptItem) intent.getParcelableExtra("key_province");
        this.gKX = (RcptItem) intent.getParcelableExtra("key_city");
        String stringExtra = intent.getStringExtra("extra_province");
        if (stringExtra != null) {
            C33045a.arQ();
            this.gKW = C33045a.arS().mo67847wE(stringExtra);
            if (this.gKW != null) {
                this.cGC = 1;
            }
        }
        stringExtra = intent.getStringExtra("extra_city");
        if (stringExtra != null && 1 == this.cGC) {
            C33045a.arQ();
            this.gKX = C33045a.arS().mo67842bl(this.gKW.code, stringExtra);
            if (this.gKX != null) {
                this.cGC = 2;
            }
        }
        AppMethodBeat.m2505o(16971);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(16972);
        if (preference instanceof RcptPreference) {
            RcptItem rcptItem = ((RcptPreference) preference).gKN;
            if (rcptItem == null || C5046bo.isNullOrNil(rcptItem.name)) {
                C4990ab.m7412e("MicroMsg.MultiRptSelectUI", "onPreferenceTreeClick error item, item is null or item.name isNullOrNil");
                AppMethodBeat.m2505o(16972);
                return false;
            }
            int intExtra;
            if (!rcptItem.gIP) {
                this.cGC = 2;
            }
            switch (this.cGC) {
                case 0:
                    this.gKW = rcptItem;
                    this.cGC = 1;
                    break;
                case 1:
                    this.gKX = rcptItem;
                    this.cGC = 2;
                    break;
                case 2:
                    StringBuilder stringBuilder = new StringBuilder();
                    if (this.gKW != null) {
                        stringBuilder.append(this.gKW.name).append(" ");
                    }
                    if (this.gKX != null) {
                        stringBuilder.append(this.gKX.name).append(" ");
                    }
                    stringBuilder.append(rcptItem.name);
                    C4990ab.m7410d("MicroMsg.MultiRptSelectUI", "area_result: " + stringBuilder.toString() + ",item.name: " + rcptItem.name);
                    Intent intent = new Intent();
                    intent.putExtra("karea_result", stringBuilder.toString());
                    intent.putExtra("kpost_code", rcptItem.gIO);
                    intent.putExtra("kwcode", rcptItem.code);
                    setResult(-1, intent);
                    finish();
                    break;
            }
            Intent intent2 = getIntent();
            if (intent2 != null) {
                intExtra = intent2.getIntExtra("ui_title", -1);
            } else {
                intExtra = -1;
            }
            Intent intent3 = new Intent(this, WalletMultiRcptSelectUI.class);
            intent3.putExtra("key_stage", this.cGC);
            intent3.putExtra("key_province", this.gKW);
            intent3.putExtra("key_city", this.gKX);
            if (-1 != intExtra) {
                intent3.putExtra("ui_title", intExtra);
            }
            startActivityForResult(intent3, 1);
        }
        AppMethodBeat.m2505o(16972);
        return false;
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(16973);
        asi();
        super.onBackPressed();
        AppMethodBeat.m2505o(16973);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(16974);
        switch (i) {
            case 1:
                if (i2 != -1) {
                    m81308x(intent);
                    break;
                }
                setResult(-1, intent);
                finish();
                AppMethodBeat.m2505o(16974);
                return;
        }
        AppMethodBeat.m2505o(16974);
    }
}

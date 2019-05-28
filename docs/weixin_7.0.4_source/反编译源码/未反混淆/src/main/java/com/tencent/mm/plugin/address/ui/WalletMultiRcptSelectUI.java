package com.tencent.mm.plugin.address.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.plugin.address.model.RcptItem;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;

public class WalletMultiRcptSelectUI extends MMPreference {
    private int cGC = 0;
    private f ehK;
    private RcptItem gKW = null;
    private RcptItem gKX = null;
    private List<RcptItem> gKY;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(WalletMultiRcptSelectUI walletMultiRcptSelectUI) {
        AppMethodBeat.i(16975);
        walletMultiRcptSelectUI.asi();
        AppMethodBeat.o(16975);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void ash() {
        AppMethodBeat.i(16965);
        List list = a.arS().gIR;
        if (list == null || list.isEmpty()) {
            ab.e("MicroMsg.MultiRptSelectUI", "list == null || list.isEmpty(), need loadata!");
            a.arS().arT();
        }
        switch (this.cGC) {
            case 0:
                a.arQ();
                list = a.arS().gIR;
                break;
            case 1:
                if (!(this.gKW == null || bo.isNullOrNil(this.gKW.code))) {
                    a.arQ();
                    list = a.arS().wC(this.gKW.code);
                    break;
                }
            case 2:
                if (!(this.gKX == null || bo.isNullOrNil(this.gKX.code))) {
                    a.arQ();
                    list = a.arS().wD(this.gKX.code);
                    break;
                }
            default:
                a.arQ();
                list = a.arS().gIR;
                break;
        }
        this.gKY = list;
        if (this.gKY == null || this.gKY.size() <= 0) {
            ab.e("MicroMsg.MultiRptSelectUI", "initZoneItems error ,check zone lists!");
            AppMethodBeat.o(16965);
            return;
        }
        this.ehK.removeAll();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gKY.size()) {
                if (!(this.gKY.get(i2) == null || bo.isNullOrNil(((RcptItem) this.gKY.get(i2)).name))) {
                    RcptPreference rcptPreference = new RcptPreference(this);
                    RcptItem rcptItem = (RcptItem) this.gKY.get(i2);
                    if (rcptItem == null || bo.isNullOrNil(rcptItem.name)) {
                        ab.e("MicroMsg.RcptPreference", "setZoneItem item = null");
                    } else {
                        rcptPreference.setKey(rcptItem.code + rcptPreference.hashCode());
                        rcptPreference.gKN = rcptItem;
                    }
                    this.ehK.b(rcptPreference);
                }
                i = i2 + 1;
            } else {
                this.ehK.b(new PreferenceSmallCategory(this));
                AppMethodBeat.o(16965);
                return;
            }
        }
    }

    private void asi() {
        AppMethodBeat.i(16966);
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
        AppMethodBeat.o(16966);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(16967);
        super.onCreate(bundle);
        this.ehK = this.yCw;
        initView();
        AppMethodBeat.o(16967);
    }

    public void onResume() {
        AppMethodBeat.i(16968);
        super.onResume();
        AppMethodBeat.o(16968);
    }

    public void onDestroy() {
        AppMethodBeat.i(16969);
        super.onDestroy();
        AppMethodBeat.o(16969);
    }

    public final int JC() {
        return R.xml.bh;
    }

    public final void initView() {
        int i = R.string.em;
        AppMethodBeat.i(16970);
        Intent intent = getIntent();
        if (intent != null) {
            i = intent.getIntExtra("ui_title", R.string.em);
        }
        setMMTitle(i);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(16964);
                WalletMultiRcptSelectUI.a(WalletMultiRcptSelectUI.this);
                AppMethodBeat.o(16964);
                return true;
            }
        });
        x(intent);
        ash();
        AppMethodBeat.o(16970);
    }

    private void x(Intent intent) {
        AppMethodBeat.i(16971);
        if (intent == null) {
            ab.e("MicroMsg.MultiRptSelectUI", "initData intent is null");
            AppMethodBeat.o(16971);
            return;
        }
        this.cGC = intent.getIntExtra("key_stage", 0);
        this.gKW = (RcptItem) intent.getParcelableExtra("key_province");
        this.gKX = (RcptItem) intent.getParcelableExtra("key_city");
        String stringExtra = intent.getStringExtra("extra_province");
        if (stringExtra != null) {
            a.arQ();
            this.gKW = a.arS().wE(stringExtra);
            if (this.gKW != null) {
                this.cGC = 1;
            }
        }
        stringExtra = intent.getStringExtra("extra_city");
        if (stringExtra != null && 1 == this.cGC) {
            a.arQ();
            this.gKX = a.arS().bl(this.gKW.code, stringExtra);
            if (this.gKX != null) {
                this.cGC = 2;
            }
        }
        AppMethodBeat.o(16971);
    }

    public final boolean a(f fVar, Preference preference) {
        AppMethodBeat.i(16972);
        if (preference instanceof RcptPreference) {
            RcptItem rcptItem = ((RcptPreference) preference).gKN;
            if (rcptItem == null || bo.isNullOrNil(rcptItem.name)) {
                ab.e("MicroMsg.MultiRptSelectUI", "onPreferenceTreeClick error item, item is null or item.name isNullOrNil");
                AppMethodBeat.o(16972);
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
                    ab.d("MicroMsg.MultiRptSelectUI", "area_result: " + stringBuilder.toString() + ",item.name: " + rcptItem.name);
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
        AppMethodBeat.o(16972);
        return false;
    }

    public void onBackPressed() {
        AppMethodBeat.i(16973);
        asi();
        super.onBackPressed();
        AppMethodBeat.o(16973);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(16974);
        switch (i) {
            case 1:
                if (i2 != -1) {
                    x(intent);
                    break;
                }
                setResult(-1, intent);
                finish();
                AppMethodBeat.o(16974);
                return;
        }
        AppMethodBeat.o(16974);
    }
}

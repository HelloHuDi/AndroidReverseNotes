package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.widget.j;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.remittance.bankcard.model.EnterTimeParcel;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.List;

public class BankRemitSelectArriveTimeUI extends MMPreference {
    private f ehK;
    private List<EnterTimeParcel> pNZ;
    private List<Preference> pOa;
    private int pOb;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(44660);
        super.onCreate(bundle);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.gr)));
        View customView = getSupportActionBar().getCustomView();
        if (customView != null) {
            View findViewById = customView.findViewById(R.id.p3);
            if (findViewById != null) {
                findViewById.setBackgroundColor(getResources().getColor(R.color.h4));
            }
            customView = customView.findViewById(16908308);
            if (customView != null && (customView instanceof TextView)) {
                ((TextView) customView).setTextColor(getResources().getColor(R.color.h4));
            }
        }
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(j.INVALID_ID);
            window.setStatusBarColor(getResources().getColor(R.color.gr));
        }
        BankRemitBaseUI.Y(this);
        this.mController.contentView.setFitsSystemWindows(true);
        setMMTitle((int) R.string.a4x);
        this.pNZ = getIntent().getParcelableArrayListExtra("key_arrive_time_parcel_list");
        this.pOb = getIntent().getIntExtra("key_select_arrive_time", -1);
        initView();
        findViewById(16908298).setBackgroundColor(getResources().getColor(R.color.gr));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(44659);
                BankRemitSelectArriveTimeUI.this.finish();
                AppMethodBeat.o(44659);
                return false;
            }
        }, R.raw.actionbar_icon_dark_back);
        AppMethodBeat.o(44660);
    }

    public final int JC() {
        return R.layout.g0;
    }

    public final void initView() {
        AppMethodBeat.i(44661);
        this.ehK = this.yCw;
        if (this.pNZ != null && this.pNZ.size() > 0) {
            this.pOa = new ArrayList();
            for (int i = 0; i < this.pNZ.size(); i++) {
                EnterTimeParcel enterTimeParcel = (EnterTimeParcel) this.pNZ.get(i);
                ab.d("MicroMsg.BankRemitSelectArriveTimeUI", "enter scene: %d", Integer.valueOf(enterTimeParcel.pLQ));
                Preference preference = new Preference(this);
                preference.setLayoutResource(R.layout.fz);
                preference.yDf = false;
                preference.setKey(enterTimeParcel.pLQ);
                preference.setTitle(enterTimeParcel.pLR);
                if (enterTimeParcel.pLQ == this.pOb) {
                    preference.setWidgetLayoutResource(R.layout.ag0);
                } else {
                    preference.setWidgetLayoutResource(R.layout.ag1);
                }
                if (enterTimeParcel.pLT == 0) {
                    if (!bo.isNullOrNil(enterTimeParcel.pLS)) {
                        preference.setSummary(enterTimeParcel.pLS);
                    }
                    preference.setEnabled(false);
                }
                preference.getExtras().putParcelable("arrive_time", enterTimeParcel);
                this.ehK.b(preference);
                this.pOa.add(preference);
            }
        }
        AppMethodBeat.o(44661);
    }

    public final boolean a(f fVar, Preference preference) {
        AppMethodBeat.i(44662);
        for (Preference preference2 : this.pOa) {
            if (preference2 == preference) {
                preference2.setWidgetLayoutResource(R.layout.ag0);
            } else {
                preference2.setWidgetLayoutResource(R.layout.ag1);
            }
        }
        this.ehK.notifyDataSetChanged();
        EnterTimeParcel enterTimeParcel = (EnterTimeParcel) preference.getExtras().getParcelable("arrive_time");
        if (enterTimeParcel == null) {
            ab.i("MicroMsg.BankRemitSelectArriveTimeUI", "is header");
            AppMethodBeat.o(44662);
        } else {
            Intent intent = new Intent();
            intent.putExtra("key_enter_time_scene", enterTimeParcel.pLQ);
            setResult(-1, intent);
            finish();
            AppMethodBeat.o(44662);
        }
        return false;
    }
}

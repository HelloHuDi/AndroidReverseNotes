package com.tencent.p177mm.plugin.remittance.bankcard.p496ui;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p057v4.widget.C8415j;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.remittance.bankcard.model.EnterTimeParcel;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectArriveTimeUI */
public class BankRemitSelectArriveTimeUI extends MMPreference {
    private C15541f ehK;
    private List<EnterTimeParcel> pNZ;
    private List<Preference> pOa;
    private int pOb;

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectArriveTimeUI$1 */
    class C348061 implements OnMenuItemClickListener {
        C348061() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(44659);
            BankRemitSelectArriveTimeUI.this.finish();
            AppMethodBeat.m2505o(44659);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(44660);
        super.onCreate(bundle);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(C25738R.color.f11772gr)));
        View customView = getSupportActionBar().getCustomView();
        if (customView != null) {
            View findViewById = customView.findViewById(2131821128);
            if (findViewById != null) {
                findViewById.setBackgroundColor(getResources().getColor(C25738R.color.f11782h4));
            }
            customView = customView.findViewById(16908308);
            if (customView != null && (customView instanceof TextView)) {
                ((TextView) customView).setTextColor(getResources().getColor(C25738R.color.f11782h4));
            }
        }
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(C8415j.INVALID_ID);
            window.setStatusBarColor(getResources().getColor(C25738R.color.f11772gr));
        }
        BankRemitBaseUI.m6024Y(this);
        this.mController.contentView.setFitsSystemWindows(true);
        setMMTitle((int) C25738R.string.a4x);
        this.pNZ = getIntent().getParcelableArrayListExtra("key_arrive_time_parcel_list");
        this.pOb = getIntent().getIntExtra("key_select_arrive_time", -1);
        initView();
        findViewById(16908298).setBackgroundColor(getResources().getColor(C25738R.color.f11772gr));
        setBackBtn(new C348061(), C1318a.actionbar_icon_dark_back);
        AppMethodBeat.m2505o(44660);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return 2130968824;
    }

    public final void initView() {
        AppMethodBeat.m2504i(44661);
        this.ehK = this.yCw;
        if (this.pNZ != null && this.pNZ.size() > 0) {
            this.pOa = new ArrayList();
            for (int i = 0; i < this.pNZ.size(); i++) {
                EnterTimeParcel enterTimeParcel = (EnterTimeParcel) this.pNZ.get(i);
                C4990ab.m7411d("MicroMsg.BankRemitSelectArriveTimeUI", "enter scene: %d", Integer.valueOf(enterTimeParcel.pLQ));
                Preference preference = new Preference(this);
                preference.setLayoutResource(2130968823);
                preference.yDf = false;
                preference.setKey(enterTimeParcel.pLQ);
                preference.setTitle(enterTimeParcel.pLR);
                if (enterTimeParcel.pLQ == this.pOb) {
                    preference.setWidgetLayoutResource(2130970197);
                } else {
                    preference.setWidgetLayoutResource(2130970198);
                }
                if (enterTimeParcel.pLT == 0) {
                    if (!C5046bo.isNullOrNil(enterTimeParcel.pLS)) {
                        preference.setSummary(enterTimeParcel.pLS);
                    }
                    preference.setEnabled(false);
                }
                preference.getExtras().putParcelable("arrive_time", enterTimeParcel);
                this.ehK.mo27713b(preference);
                this.pOa.add(preference);
            }
        }
        AppMethodBeat.m2505o(44661);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(44662);
        for (Preference preference2 : this.pOa) {
            if (preference2 == preference) {
                preference2.setWidgetLayoutResource(2130970197);
            } else {
                preference2.setWidgetLayoutResource(2130970198);
            }
        }
        this.ehK.notifyDataSetChanged();
        EnterTimeParcel enterTimeParcel = (EnterTimeParcel) preference.getExtras().getParcelable("arrive_time");
        if (enterTimeParcel == null) {
            C4990ab.m7416i("MicroMsg.BankRemitSelectArriveTimeUI", "is header");
            AppMethodBeat.m2505o(44662);
        } else {
            Intent intent = new Intent();
            intent.putExtra("key_enter_time_scene", enterTimeParcel.pLQ);
            setResult(-1, intent);
            finish();
            AppMethodBeat.m2505o(44662);
        }
        return false;
    }
}

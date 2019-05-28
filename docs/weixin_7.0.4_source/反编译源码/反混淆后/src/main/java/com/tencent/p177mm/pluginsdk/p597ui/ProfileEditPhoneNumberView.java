package com.tencent.p177mm.pluginsdk.p597ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.pluginsdk.p597ui.MMPhoneNumberEditText.C35816a;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.pluginsdk.ui.ProfileEditPhoneNumberView */
public class ProfileEditPhoneNumberView extends ProfileItemView implements C35816a {
    public String vim;
    public String vin;
    public String[] vio;
    private LinearLayout vip;
    private boolean viq = false;
    public C14903a vir;

    /* renamed from: com.tencent.mm.pluginsdk.ui.ProfileEditPhoneNumberView$a */
    public interface C14903a {
        void aVU();

        void djk();
    }

    /* renamed from: a */
    static /* synthetic */ void m61330a(ProfileEditPhoneNumberView profileEditPhoneNumberView, MMPhoneNumberEditText mMPhoneNumberEditText) {
        AppMethodBeat.m2504i(27522);
        profileEditPhoneNumberView.m61334h(mMPhoneNumberEditText);
        AppMethodBeat.m2505o(27522);
    }

    /* renamed from: b */
    static /* synthetic */ void m61332b(ProfileEditPhoneNumberView profileEditPhoneNumberView) {
        AppMethodBeat.m2504i(27523);
        profileEditPhoneNumberView.m61333bV(null, false);
        AppMethodBeat.m2505o(27523);
    }

    public ProfileEditPhoneNumberView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ProfileEditPhoneNumberView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public int getLayout() {
        return 2130970406;
    }

    public final void init() {
        AppMethodBeat.m2504i(27510);
        this.vip = (LinearLayout) findViewById(2131826653);
        AppMethodBeat.m2505o(27510);
    }

    public void clearFocus() {
        AppMethodBeat.m2504i(27511);
        for (int i = 1; i < this.vip.getChildCount(); i++) {
            this.vip.getChildAt(i).clearFocus();
        }
        AppMethodBeat.m2505o(27511);
    }

    /* renamed from: T */
    public final boolean mo27223T(C7616ad c7616ad) {
        this.ldh = c7616ad;
        return true;
    }

    /* renamed from: hF */
    public final void mo58722hF(String str, String str2) {
        AppMethodBeat.m2504i(27512);
        this.vim = str;
        this.vin = str2;
        cby();
        AppMethodBeat.m2505o(27512);
    }

    public final boolean cby() {
        int i;
        int i2;
        AppMethodBeat.m2504i(27513);
        if (C5046bo.isNullOrNil(this.vim)) {
            i = 0;
            i2 = 0;
        } else {
            m61333bV(this.vim, true);
            i = 1;
            i2 = 1;
        }
        if (!C5046bo.isNullOrNil(this.vin)) {
            this.vio = this.vin.split(",");
            while (i2 < this.vio.length + i) {
                m61333bV(this.vio[i2 - i].trim(), false);
                i2++;
            }
        }
        if (i2 < 5) {
            m61333bV(null, false);
            this.viq = false;
        } else {
            this.viq = true;
        }
        AppMethodBeat.m2505o(27513);
        return false;
    }

    public ArrayList<String> getPhoneNumberList() {
        AppMethodBeat.m2504i(27514);
        int childCount = this.vip.getChildCount();
        if (childCount == 1) {
            AppMethodBeat.m2505o(27514);
            return null;
        }
        ArrayList<String> arrayList = new ArrayList(childCount - 1);
        for (int i = 1; i < childCount; i++) {
            String obj = ((MMPhoneNumberEditText) this.vip.getChildAt(i)).getText().toString();
            if (!(C5046bo.isNullOrNil(obj) || obj.trim().equals(""))) {
                arrayList.add(obj);
            }
        }
        if (!C5046bo.isNullOrNil(this.vim) && arrayList.size() > 0) {
            arrayList.remove(0);
        }
        AppMethodBeat.m2505o(27514);
        return arrayList;
    }

    private void djj() {
        AppMethodBeat.m2504i(27515);
        if (this.vir != null) {
            this.vir.aVU();
        }
        AppMethodBeat.m2505o(27515);
    }

    /* renamed from: f */
    public final void mo56597f(final MMPhoneNumberEditText mMPhoneNumberEditText) {
        AppMethodBeat.m2504i(27516);
        if (mMPhoneNumberEditText.vhT) {
            C30379h.m48428a(getContext(), (int) C25738R.string.cby, 0, (int) C25738R.string.cbx, (int) C25738R.string.cbw, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(27509);
                    ProfileEditPhoneNumberView.this.vim = "";
                    ProfileEditPhoneNumberView.this.vir.djk();
                    ProfileEditPhoneNumberView.m61330a(ProfileEditPhoneNumberView.this, mMPhoneNumberEditText);
                    if (!ProfileEditPhoneNumberView.this.viq) {
                        ProfileEditPhoneNumberView.m61332b(ProfileEditPhoneNumberView.this);
                    }
                    AppMethodBeat.m2505o(27509);
                }
            }, null);
            AppMethodBeat.m2505o(27516);
            return;
        }
        m61334h(mMPhoneNumberEditText);
        if (this.viq) {
            m61333bV(null, false);
            this.viq = false;
        }
        djj();
        AppMethodBeat.m2505o(27516);
    }

    public final void dje() {
        AppMethodBeat.m2504i(27517);
        djj();
        AppMethodBeat.m2505o(27517);
    }

    public final void djd() {
        AppMethodBeat.m2504i(27518);
        if (this.vip.getChildCount() - 1 < 5) {
            m61333bV(null, false);
        } else {
            this.viq = true;
        }
        djj();
        AppMethodBeat.m2505o(27518);
    }

    /* renamed from: g */
    public final void mo56598g(MMPhoneNumberEditText mMPhoneNumberEditText) {
        AppMethodBeat.m2504i(27519);
        if (this.vip.getChildCount() - 1 == 1) {
            AppMethodBeat.m2505o(27519);
            return;
        }
        m61334h(mMPhoneNumberEditText);
        if (this.viq) {
            m61333bV(null, false);
        }
        this.viq = false;
        djj();
        AppMethodBeat.m2505o(27519);
    }

    /* renamed from: bV */
    private void m61333bV(String str, boolean z) {
        AppMethodBeat.m2504i(27520);
        MMPhoneNumberEditText mMPhoneNumberEditText = (MMPhoneNumberEditText) LayoutInflater.from(getContext()).inflate(2130970405, null);
        mMPhoneNumberEditText.setHint(C4996ah.getResources().getString(C25738R.string.f8712ct));
        if (z) {
            mMPhoneNumberEditText.diZ();
        }
        mMPhoneNumberEditText.setCallback(this);
        mMPhoneNumberEditText.setText(str);
        mMPhoneNumberEditText.setSelection(mMPhoneNumberEditText.getText().length());
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.setMargins(0, C1338a.fromDPToPix(getContext(), 12), 0, 0);
        this.vip.addView(mMPhoneNumberEditText, layoutParams);
        AppMethodBeat.m2505o(27520);
    }

    /* renamed from: h */
    private void m61334h(MMPhoneNumberEditText mMPhoneNumberEditText) {
        AppMethodBeat.m2504i(27521);
        this.vip.removeView(mMPhoneNumberEditText);
        this.vip.getChildAt(this.vip.getChildCount() - 1).requestFocus();
        AppMethodBeat.m2505o(27521);
    }
}

package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;

public class ProfileEditPhoneNumberView extends ProfileItemView implements com.tencent.mm.pluginsdk.ui.MMPhoneNumberEditText.a {
    public String vim;
    public String vin;
    public String[] vio;
    private LinearLayout vip;
    private boolean viq = false;
    public a vir;

    public interface a {
        void aVU();

        void djk();
    }

    static /* synthetic */ void a(ProfileEditPhoneNumberView profileEditPhoneNumberView, MMPhoneNumberEditText mMPhoneNumberEditText) {
        AppMethodBeat.i(27522);
        profileEditPhoneNumberView.h(mMPhoneNumberEditText);
        AppMethodBeat.o(27522);
    }

    static /* synthetic */ void b(ProfileEditPhoneNumberView profileEditPhoneNumberView) {
        AppMethodBeat.i(27523);
        profileEditPhoneNumberView.bV(null, false);
        AppMethodBeat.o(27523);
    }

    public ProfileEditPhoneNumberView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ProfileEditPhoneNumberView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public int getLayout() {
        return R.layout.alm;
    }

    public final void init() {
        AppMethodBeat.i(27510);
        this.vip = (LinearLayout) findViewById(R.id.dq5);
        AppMethodBeat.o(27510);
    }

    public void clearFocus() {
        AppMethodBeat.i(27511);
        for (int i = 1; i < this.vip.getChildCount(); i++) {
            this.vip.getChildAt(i).clearFocus();
        }
        AppMethodBeat.o(27511);
    }

    public final boolean T(ad adVar) {
        this.ldh = adVar;
        return true;
    }

    public final void hF(String str, String str2) {
        AppMethodBeat.i(27512);
        this.vim = str;
        this.vin = str2;
        cby();
        AppMethodBeat.o(27512);
    }

    public final boolean cby() {
        int i;
        int i2;
        AppMethodBeat.i(27513);
        if (bo.isNullOrNil(this.vim)) {
            i = 0;
            i2 = 0;
        } else {
            bV(this.vim, true);
            i = 1;
            i2 = 1;
        }
        if (!bo.isNullOrNil(this.vin)) {
            this.vio = this.vin.split(",");
            while (i2 < this.vio.length + i) {
                bV(this.vio[i2 - i].trim(), false);
                i2++;
            }
        }
        if (i2 < 5) {
            bV(null, false);
            this.viq = false;
        } else {
            this.viq = true;
        }
        AppMethodBeat.o(27513);
        return false;
    }

    public ArrayList<String> getPhoneNumberList() {
        AppMethodBeat.i(27514);
        int childCount = this.vip.getChildCount();
        if (childCount == 1) {
            AppMethodBeat.o(27514);
            return null;
        }
        ArrayList<String> arrayList = new ArrayList(childCount - 1);
        for (int i = 1; i < childCount; i++) {
            String obj = ((MMPhoneNumberEditText) this.vip.getChildAt(i)).getText().toString();
            if (!(bo.isNullOrNil(obj) || obj.trim().equals(""))) {
                arrayList.add(obj);
            }
        }
        if (!bo.isNullOrNil(this.vim) && arrayList.size() > 0) {
            arrayList.remove(0);
        }
        AppMethodBeat.o(27514);
        return arrayList;
    }

    private void djj() {
        AppMethodBeat.i(27515);
        if (this.vir != null) {
            this.vir.aVU();
        }
        AppMethodBeat.o(27515);
    }

    public final void f(final MMPhoneNumberEditText mMPhoneNumberEditText) {
        AppMethodBeat.i(27516);
        if (mMPhoneNumberEditText.vhT) {
            h.a(getContext(), (int) R.string.cby, 0, (int) R.string.cbx, (int) R.string.cbw, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(27509);
                    ProfileEditPhoneNumberView.this.vim = "";
                    ProfileEditPhoneNumberView.this.vir.djk();
                    ProfileEditPhoneNumberView.a(ProfileEditPhoneNumberView.this, mMPhoneNumberEditText);
                    if (!ProfileEditPhoneNumberView.this.viq) {
                        ProfileEditPhoneNumberView.b(ProfileEditPhoneNumberView.this);
                    }
                    AppMethodBeat.o(27509);
                }
            }, null);
            AppMethodBeat.o(27516);
            return;
        }
        h(mMPhoneNumberEditText);
        if (this.viq) {
            bV(null, false);
            this.viq = false;
        }
        djj();
        AppMethodBeat.o(27516);
    }

    public final void dje() {
        AppMethodBeat.i(27517);
        djj();
        AppMethodBeat.o(27517);
    }

    public final void djd() {
        AppMethodBeat.i(27518);
        if (this.vip.getChildCount() - 1 < 5) {
            bV(null, false);
        } else {
            this.viq = true;
        }
        djj();
        AppMethodBeat.o(27518);
    }

    public final void g(MMPhoneNumberEditText mMPhoneNumberEditText) {
        AppMethodBeat.i(27519);
        if (this.vip.getChildCount() - 1 == 1) {
            AppMethodBeat.o(27519);
            return;
        }
        h(mMPhoneNumberEditText);
        if (this.viq) {
            bV(null, false);
        }
        this.viq = false;
        djj();
        AppMethodBeat.o(27519);
    }

    private void bV(String str, boolean z) {
        AppMethodBeat.i(27520);
        MMPhoneNumberEditText mMPhoneNumberEditText = (MMPhoneNumberEditText) LayoutInflater.from(getContext()).inflate(R.layout.all, null);
        mMPhoneNumberEditText.setHint(ah.getResources().getString(R.string.ct));
        if (z) {
            mMPhoneNumberEditText.diZ();
        }
        mMPhoneNumberEditText.setCallback(this);
        mMPhoneNumberEditText.setText(str);
        mMPhoneNumberEditText.setSelection(mMPhoneNumberEditText.getText().length());
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.setMargins(0, com.tencent.mm.bz.a.fromDPToPix(getContext(), 12), 0, 0);
        this.vip.addView(mMPhoneNumberEditText, layoutParams);
        AppMethodBeat.o(27520);
    }

    private void h(MMPhoneNumberEditText mMPhoneNumberEditText) {
        AppMethodBeat.i(27521);
        this.vip.removeView(mMPhoneNumberEditText);
        this.vip.getChildAt(this.vip.getChildCount() - 1).requestFocus();
        AppMethodBeat.o(27521);
    }
}

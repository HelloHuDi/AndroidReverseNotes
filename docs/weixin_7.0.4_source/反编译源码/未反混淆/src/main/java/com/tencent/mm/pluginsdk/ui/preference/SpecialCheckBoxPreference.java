package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ToggleButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.chatroom.e.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.n.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;

public class SpecialCheckBoxPreference extends Preference {
    private boolean cEH;
    private boolean ehL;
    private String ehq;
    private boolean eif = false;
    private ad ldh;
    private Context mContext;
    private OnCheckedChangeListener vrA = new OnCheckedChangeListener() {
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            AppMethodBeat.i(28123);
            int id = compoundButton.getId();
            if (id == R.id.d9x) {
                SpecialCheckBoxPreference.a(SpecialCheckBoxPreference.this);
                AppMethodBeat.o(28123);
            } else if (id == R.id.d9y) {
                SpecialCheckBoxPreference.b(SpecialCheckBoxPreference.this);
                AppMethodBeat.o(28123);
            } else {
                if (id == R.id.d9z) {
                    SpecialCheckBoxPreference.c(SpecialCheckBoxPreference.this);
                }
                AppMethodBeat.o(28123);
            }
        }
    };
    private ToggleButton vrx;
    private ToggleButton vry;
    private ToggleButton vrz;

    public SpecialCheckBoxPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(28124);
        this.mContext = context;
        AppMethodBeat.o(28124);
    }

    public SpecialCheckBoxPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(28125);
        this.mContext = context;
        AppMethodBeat.o(28125);
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(28126);
        super.onBindView(view);
        this.vrx = (ToggleButton) view.findViewById(R.id.d9x);
        this.vry = (ToggleButton) view.findViewById(R.id.d9y);
        this.vrz = (ToggleButton) view.findViewById(R.id.d9z);
        this.ehq = ((MMActivity) this.mContext).getIntent().getStringExtra("RoomInfo_Id");
        this.cEH = ((MMActivity) this.mContext).getIntent().getBooleanExtra("Is_Chatroom", true);
        this.ehL = ((MMActivity) this.mContext).getIntent().getBooleanExtra("Is_Lbsroom", false);
        aw.ZK();
        this.ldh = c.XM().aoO(this.ehq);
        if (this.ldh != null) {
            ToggleButton toggleButton = this.vrx;
            aw.ZK();
            toggleButton.setChecked(c.XR().aph(this.ldh.field_username));
            this.vrz.setChecked(a.jh(this.ldh.field_type));
            this.vry.setChecked(dle());
        }
        this.vrx.setOnCheckedChangeListener(this.vrA);
        this.vry.setOnCheckedChangeListener(this.vrA);
        this.vrz.setOnCheckedChangeListener(this.vrA);
        AppMethodBeat.o(28126);
    }

    private boolean dle() {
        AppMethodBeat.i(28127);
        if (this.cEH) {
            this.eif = this.ldh.dua == 0;
        } else if (!this.ehL) {
            this.eif = this.ldh.DX();
        }
        if (!(this.mContext instanceof MMActivity)) {
            AppMethodBeat.o(28127);
            return false;
        } else if (this.eif) {
            ((MMActivity) this.mContext).setTitleMuteIconVisibility(0);
            AppMethodBeat.o(28127);
            return true;
        } else {
            ((MMActivity) this.mContext).setTitleMuteIconVisibility(8);
            AppMethodBeat.o(28127);
            return false;
        }
    }

    static /* synthetic */ void a(SpecialCheckBoxPreference specialCheckBoxPreference) {
        AppMethodBeat.i(28128);
        if (specialCheckBoxPreference.ldh != null) {
            aw.ZK();
            if (c.XR().aph(specialCheckBoxPreference.ldh.field_username)) {
                t.x(specialCheckBoxPreference.ldh.field_username, true);
                AppMethodBeat.o(28128);
                return;
            }
            t.w(specialCheckBoxPreference.ldh.field_username, true);
        }
        AppMethodBeat.o(28128);
    }

    static /* synthetic */ void b(SpecialCheckBoxPreference specialCheckBoxPreference) {
        int i = 0;
        AppMethodBeat.i(28129);
        specialCheckBoxPreference.eif = !specialCheckBoxPreference.eif;
        if (specialCheckBoxPreference.cEH) {
            if (!specialCheckBoxPreference.eif) {
                i = 1;
            }
            aw.ZK();
            c.XL().c(new b(specialCheckBoxPreference.ehq, i));
            specialCheckBoxPreference.ldh.hE(i);
            aw.ZK();
            c.XM().b(specialCheckBoxPreference.ehq, specialCheckBoxPreference.ldh);
        }
        specialCheckBoxPreference.dle();
        AppMethodBeat.o(28129);
    }

    static /* synthetic */ void c(SpecialCheckBoxPreference specialCheckBoxPreference) {
        AppMethodBeat.i(28130);
        if (specialCheckBoxPreference.ldh != null) {
            if (a.jh(specialCheckBoxPreference.ldh.field_type)) {
                specialCheckBoxPreference.ldh.NC();
                t.u(specialCheckBoxPreference.ldh);
                h.bQ(specialCheckBoxPreference.mContext, specialCheckBoxPreference.mContext.getString(R.string.du4));
                AppMethodBeat.o(28130);
                return;
            }
            t.r(specialCheckBoxPreference.ldh);
            h.bQ(specialCheckBoxPreference.mContext, specialCheckBoxPreference.mContext.getString(R.string.duj));
        }
        AppMethodBeat.o(28130);
    }
}

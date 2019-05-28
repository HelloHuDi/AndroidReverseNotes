package com.tencent.p177mm.pluginsdk.p597ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ToggleButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.chatroom.p1596e.C41925b;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.storage.C7616ad;

/* renamed from: com.tencent.mm.pluginsdk.ui.preference.SpecialCheckBoxPreference */
public class SpecialCheckBoxPreference extends Preference {
    private boolean cEH;
    private boolean ehL;
    private String ehq;
    private boolean eif = false;
    private C7616ad ldh;
    private Context mContext;
    private OnCheckedChangeListener vrA = new C358811();
    private ToggleButton vrx;
    private ToggleButton vry;
    private ToggleButton vrz;

    /* renamed from: com.tencent.mm.pluginsdk.ui.preference.SpecialCheckBoxPreference$1 */
    class C358811 implements OnCheckedChangeListener {
        C358811() {
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            AppMethodBeat.m2504i(28123);
            int id = compoundButton.getId();
            if (id == 2131826016) {
                SpecialCheckBoxPreference.m58834a(SpecialCheckBoxPreference.this);
                AppMethodBeat.m2505o(28123);
            } else if (id == 2131826017) {
                SpecialCheckBoxPreference.m58835b(SpecialCheckBoxPreference.this);
                AppMethodBeat.m2505o(28123);
            } else {
                if (id == 2131826018) {
                    SpecialCheckBoxPreference.m58836c(SpecialCheckBoxPreference.this);
                }
                AppMethodBeat.m2505o(28123);
            }
        }
    }

    public SpecialCheckBoxPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(28124);
        this.mContext = context;
        AppMethodBeat.m2505o(28124);
    }

    public SpecialCheckBoxPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(28125);
        this.mContext = context;
        AppMethodBeat.m2505o(28125);
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(28126);
        super.onBindView(view);
        this.vrx = (ToggleButton) view.findViewById(2131826016);
        this.vry = (ToggleButton) view.findViewById(2131826017);
        this.vrz = (ToggleButton) view.findViewById(2131826018);
        this.ehq = ((MMActivity) this.mContext).getIntent().getStringExtra("RoomInfo_Id");
        this.cEH = ((MMActivity) this.mContext).getIntent().getBooleanExtra("Is_Chatroom", true);
        this.ehL = ((MMActivity) this.mContext).getIntent().getBooleanExtra("Is_Lbsroom", false);
        C9638aw.m17190ZK();
        this.ldh = C18628c.m29078XM().aoO(this.ehq);
        if (this.ldh != null) {
            ToggleButton toggleButton = this.vrx;
            C9638aw.m17190ZK();
            toggleButton.setChecked(C18628c.m29083XR().aph(this.ldh.field_username));
            this.vrz.setChecked(C7486a.m12942jh(this.ldh.field_type));
            this.vry.setChecked(dle());
        }
        this.vrx.setOnCheckedChangeListener(this.vrA);
        this.vry.setOnCheckedChangeListener(this.vrA);
        this.vrz.setOnCheckedChangeListener(this.vrA);
        AppMethodBeat.m2505o(28126);
    }

    private boolean dle() {
        AppMethodBeat.m2504i(28127);
        if (this.cEH) {
            this.eif = this.ldh.dua == 0;
        } else if (!this.ehL) {
            this.eif = this.ldh.mo16673DX();
        }
        if (!(this.mContext instanceof MMActivity)) {
            AppMethodBeat.m2505o(28127);
            return false;
        } else if (this.eif) {
            ((MMActivity) this.mContext).setTitleMuteIconVisibility(0);
            AppMethodBeat.m2505o(28127);
            return true;
        } else {
            ((MMActivity) this.mContext).setTitleMuteIconVisibility(8);
            AppMethodBeat.m2505o(28127);
            return false;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m58834a(SpecialCheckBoxPreference specialCheckBoxPreference) {
        AppMethodBeat.m2504i(28128);
        if (specialCheckBoxPreference.ldh != null) {
            C9638aw.m17190ZK();
            if (C18628c.m29083XR().aph(specialCheckBoxPreference.ldh.field_username)) {
                C1855t.m3969x(specialCheckBoxPreference.ldh.field_username, true);
                AppMethodBeat.m2505o(28128);
                return;
            }
            C1855t.m3967w(specialCheckBoxPreference.ldh.field_username, true);
        }
        AppMethodBeat.m2505o(28128);
    }

    /* renamed from: b */
    static /* synthetic */ void m58835b(SpecialCheckBoxPreference specialCheckBoxPreference) {
        int i = 0;
        AppMethodBeat.m2504i(28129);
        specialCheckBoxPreference.eif = !specialCheckBoxPreference.eif;
        if (specialCheckBoxPreference.cEH) {
            if (!specialCheckBoxPreference.eif) {
                i = 1;
            }
            C9638aw.m17190ZK();
            C18628c.m29077XL().mo7920c(new C41925b(specialCheckBoxPreference.ehq, i));
            specialCheckBoxPreference.ldh.mo14689hE(i);
            C9638aw.m17190ZK();
            C18628c.m29078XM().mo15724b(specialCheckBoxPreference.ehq, specialCheckBoxPreference.ldh);
        }
        specialCheckBoxPreference.dle();
        AppMethodBeat.m2505o(28129);
    }

    /* renamed from: c */
    static /* synthetic */ void m58836c(SpecialCheckBoxPreference specialCheckBoxPreference) {
        AppMethodBeat.m2504i(28130);
        if (specialCheckBoxPreference.ldh != null) {
            if (C7486a.m12942jh(specialCheckBoxPreference.ldh.field_type)) {
                specialCheckBoxPreference.ldh.mo16677NC();
                C1855t.m3964u(specialCheckBoxPreference.ldh);
                C30379h.m48465bQ(specialCheckBoxPreference.mContext, specialCheckBoxPreference.mContext.getString(C25738R.string.du4));
                AppMethodBeat.m2505o(28130);
                return;
            }
            C1855t.m3961r(specialCheckBoxPreference.ldh);
            C30379h.m48465bQ(specialCheckBoxPreference.mContext, specialCheckBoxPreference.mContext.getString(C25738R.string.duj));
        }
        AppMethodBeat.m2505o(28130);
    }
}

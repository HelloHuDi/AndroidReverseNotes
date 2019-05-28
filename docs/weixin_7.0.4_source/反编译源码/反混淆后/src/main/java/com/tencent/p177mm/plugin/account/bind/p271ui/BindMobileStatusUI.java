package com.tencent.p177mm.plugin.account.bind.p271ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.modelsimple.BindWordingContent;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l.C38034a;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.protocal.protobuf.act;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMobileStatusUI */
public class BindMobileStatusUI extends MMWizardActivity {
    private SharedPreferences ehZ;
    private TextView grB;
    private Button grC;
    private TextView grR;
    private ImageView grS;
    private ImageView grT;
    private Boolean grU = Boolean.TRUE;
    private Boolean grV = Boolean.TRUE;
    private RelativeLayout grW;
    private RelativeLayout grX;
    private BindWordingContent grY;
    private int grZ;
    private ImageView gri;
    private boolean gsa;
    private boolean gsb;
    @SuppressLint({"UseSparseArrays"})
    private HashMap<Integer, Integer> gsc = new HashMap();
    private SparseArray<String> gsd = new SparseArray(3);
    private int status;

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMobileStatusUI$1 */
    class C329401 implements OnMenuItemClickListener {
        C329401() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(13495);
            BindMobileStatusUI.m83826a(BindMobileStatusUI.this);
            AppMethodBeat.m2505o(13495);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMobileStatusUI$2 */
    class C380242 implements OnClickListener {
        C380242() {
        }

        public final void onClick(View view) {
            boolean z = true;
            AppMethodBeat.m2504i(13496);
            BindMobileStatusUI.this.grU = Boolean.valueOf(!BindMobileStatusUI.this.grU.booleanValue());
            if (BindMobileStatusUI.this.grU.booleanValue()) {
                BindMobileStatusUI.this.grS.setImageResource(C1318a.checkbox_selected);
            } else {
                BindMobileStatusUI.this.grS.setImageResource(C1318a.checkbox_unselected);
            }
            BindMobileStatusUI bindMobileStatusUI = BindMobileStatusUI.this;
            if (BindMobileStatusUI.this.grU.booleanValue()) {
                z = false;
            }
            BindMobileStatusUI.m83827a(bindMobileStatusUI, z, 512, 8);
            AppMethodBeat.m2505o(13496);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMobileStatusUI$4 */
    class C380254 implements OnClickListener {
        C380254() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(13498);
            BindMobileStatusUI.m83835f(BindMobileStatusUI.this);
            AppMethodBeat.m2505o(13498);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMobileStatusUI$3 */
    class C454923 implements OnClickListener {
        C454923() {
        }

        public final void onClick(View view) {
            boolean z = true;
            AppMethodBeat.m2504i(13497);
            BindMobileStatusUI.this.grV = Boolean.valueOf(!BindMobileStatusUI.this.grV.booleanValue());
            if (BindMobileStatusUI.this.grV.booleanValue()) {
                BindMobileStatusUI.this.grT.setImageResource(C1318a.checkbox_selected);
            } else {
                BindMobileStatusUI.this.grT.setImageResource(C1318a.checkbox_unselected);
            }
            BindMobileStatusUI bindMobileStatusUI = BindMobileStatusUI.this;
            if (BindMobileStatusUI.this.grV.booleanValue()) {
                z = false;
            }
            BindMobileStatusUI.m83827a(bindMobileStatusUI, z, 256, 7);
            if (!BindMobileStatusUI.this.grV.booleanValue()) {
                BindMobileStatusUI.m83827a(BindMobileStatusUI.this, false, 2097152, 32);
            }
            AppMethodBeat.m2505o(13497);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public BindMobileStatusUI() {
        AppMethodBeat.m2504i(13499);
        AppMethodBeat.m2505o(13499);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m83827a(BindMobileStatusUI bindMobileStatusUI, boolean z, int i, int i2) {
        AppMethodBeat.m2504i(13507);
        boolean b = bindMobileStatusUI.m83830b(z, i, i2);
        AppMethodBeat.m2505o(13507);
        return b;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(13500);
        super.onCreate(bundle);
        this.ehZ = getSharedPreferences(getPackageName() + "_preferences", 0);
        this.status = C1853r.m3822YD();
        this.gsd.put(8, "settings_find_me_by_mobile");
        this.gsd.put(7, "settings_recommend_mobilefriends_to_me");
        this.gsd.put(32, "settings_autoadd_mobilefriends");
        m83830b(false, 512, 8);
        m83830b(false, 256, 7);
        setMMTitle((int) C25738R.string.a7_);
        this.grY = (BindWordingContent) getIntent().getParcelableExtra("kstyle_bind_wording");
        this.grZ = getIntent().getIntExtra("kstyle_bind_recommend_show", 0);
        this.gsa = getIntent().getBooleanExtra("Kfind_friend_by_mobile_flag", false);
        this.gsb = getIntent().getBooleanExtra("Krecom_friends_by_mobile_flag", false);
        initView();
        AppMethodBeat.m2505o(13500);
    }

    public final int getLayoutId() {
        return 2130968836;
    }

    /* renamed from: b */
    private boolean m83830b(boolean z, int i, int i2) {
        AppMethodBeat.m2504i(13502);
        C4990ab.m7410d("MicroMsg.BindMobileStatusUI", "switch change : open = " + z + " item value = " + i + " functionId = " + i2);
        if (z) {
            this.status |= i;
        } else {
            this.status &= i ^ -1;
        }
        this.gsc.put(Integer.valueOf(i2), Integer.valueOf(z ? 1 : 2));
        String str = (String) this.gsd.get(i2);
        if (!(this.ehZ == null || str == null || str.length() <= 0)) {
            Boolean valueOf = Boolean.valueOf(z);
            if (i2 == 8 || i2 == 7) {
                valueOf = Boolean.valueOf(!z);
            }
            this.ehZ.edit().putBoolean(str, valueOf.booleanValue()).commit();
        }
        AppMethodBeat.m2505o(13502);
        return true;
    }

    public final void initView() {
        boolean z = true;
        AppMethodBeat.m2504i(13503);
        this.gri = (ImageView) findViewById(2131821737);
        this.grR = (TextView) findViewById(2131821738);
        this.grB = (TextView) findViewById(2131821739);
        this.grC = (Button) findViewById(2131821740);
        this.grS = (ImageView) findViewById(2131821742);
        this.grT = (ImageView) findViewById(2131821744);
        this.grW = (RelativeLayout) findViewById(2131821741);
        this.grX = (RelativeLayout) findViewById(2131821743);
        switch (this.grZ) {
            case 0:
                boolean z2;
                this.grW.setVisibility(8);
                this.grX.setVisibility(8);
                if (this.gsa) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                m83830b(z2, 512, 8);
                if (this.gsb) {
                    z = false;
                }
                m83830b(z, 256, 7);
                break;
            case 1:
                this.grW.setVisibility(0);
                this.grW.setBackgroundResource(C25738R.drawable.f6441e9);
                this.grX.setVisibility(8);
                break;
        }
        if (this.grY != null) {
            switch (this.grY.bWu.intValue()) {
                case 2:
                    this.grB.setVisibility(8);
                    break;
            }
        }
        this.grC.setVisibility(8);
        addTextOptionMenu(0, getString(C25738R.string.f9142qt), new C329401());
        if (C38033l.apS() == C38034a.SUCC || C38033l.apS() == C38034a.SUCC_UNLOAD) {
            this.gri.setImageResource(C25738R.drawable.ab_);
            String str = (String) C1720g.m3536RP().mo5239Ry().get(6, null);
            if (str == null || str.equals("")) {
                C1720g.m3536RP().mo5239Ry().get(4097, null);
            }
        } else {
            this.gri.setImageResource(C25738R.drawable.ab7);
            this.grB.setVisibility(8);
            this.grR.setText(getString(C25738R.string.a66));
        }
        this.grS.setOnClickListener(new C380242());
        this.grT.setOnClickListener(new C454923());
        this.grC.setOnClickListener(new C380254());
        AppMethodBeat.m2505o(13503);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(13504);
        if (i == 4) {
            mo27541Ni(1);
            AppMethodBeat.m2505o(13504);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(13504);
        return onKeyDown;
    }

    /* renamed from: c */
    public static void m83832c(Context context, boolean z, boolean z2) {
        boolean z3 = false;
        int i = 1;
        AppMethodBeat.m2504i(13505);
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName() + "_preferences", 0);
        sharedPreferences.edit().putBoolean("settings_find_me_by_mobile", !z).commit();
        Editor edit = sharedPreferences.edit();
        String str = "settings_recommend_mobilefriends_to_me";
        if (!z2) {
            z3 = true;
        }
        edit.putBoolean(str, z3).commit();
        int YD = C1853r.m3822YD();
        YD = z ? YD | 512 : YD & -513;
        C1720g.m3536RP().mo5239Ry().set(7, Integer.valueOf(z2 ? YD | 256 : YD & -257));
        act act = new act();
        act.wkw = 8;
        if (z2) {
            YD = 1;
        } else {
            YD = 2;
        }
        act.pvD = YD;
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(23, act));
        act act2 = new act();
        act2.wkw = 7;
        if (!z) {
            i = 2;
        }
        act.pvD = i;
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(23, act2));
        C24679a.gkF.mo38844BS();
        AppMethodBeat.m2505o(13505);
    }

    public void onPause() {
        AppMethodBeat.m2504i(13501);
        C1720g.m3536RP().mo5239Ry().set(7, Integer.valueOf(this.status));
        for (Entry entry : this.gsc.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            act act = new act();
            act.wkw = intValue;
            act.pvD = intValue2;
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(23, act));
            C4990ab.m7410d("MicroMsg.BindMobileStatusUI", "switch  " + intValue + " " + intValue2);
        }
        this.gsc.clear();
        super.onPause();
        AppMethodBeat.m2505o(13501);
    }

    /* renamed from: a */
    static /* synthetic */ void m83826a(BindMobileStatusUI bindMobileStatusUI) {
        AppMethodBeat.m2504i(13506);
        bindMobileStatusUI.mo27541Ni(1);
        AppMethodBeat.m2505o(13506);
    }

    /* renamed from: f */
    static /* synthetic */ void m83835f(BindMobileStatusUI bindMobileStatusUI) {
        AppMethodBeat.m2504i(13508);
        bindMobileStatusUI.mo27541Ni(1);
        AppMethodBeat.m2505o(13508);
    }
}

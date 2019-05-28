package com.tencent.mm.plugin.account.bind.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.act;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMWizardActivity;
import java.util.HashMap;
import java.util.Map.Entry;

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

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BindMobileStatusUI() {
        AppMethodBeat.i(13499);
        AppMethodBeat.o(13499);
    }

    static /* synthetic */ boolean a(BindMobileStatusUI bindMobileStatusUI, boolean z, int i, int i2) {
        AppMethodBeat.i(13507);
        boolean b = bindMobileStatusUI.b(z, i, i2);
        AppMethodBeat.o(13507);
        return b;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(13500);
        super.onCreate(bundle);
        this.ehZ = getSharedPreferences(getPackageName() + "_preferences", 0);
        this.status = r.YD();
        this.gsd.put(8, "settings_find_me_by_mobile");
        this.gsd.put(7, "settings_recommend_mobilefriends_to_me");
        this.gsd.put(32, "settings_autoadd_mobilefriends");
        b(false, 512, 8);
        b(false, 256, 7);
        setMMTitle((int) R.string.a7_);
        this.grY = (BindWordingContent) getIntent().getParcelableExtra("kstyle_bind_wording");
        this.grZ = getIntent().getIntExtra("kstyle_bind_recommend_show", 0);
        this.gsa = getIntent().getBooleanExtra("Kfind_friend_by_mobile_flag", false);
        this.gsb = getIntent().getBooleanExtra("Krecom_friends_by_mobile_flag", false);
        initView();
        AppMethodBeat.o(13500);
    }

    public final int getLayoutId() {
        return R.layout.gb;
    }

    private boolean b(boolean z, int i, int i2) {
        AppMethodBeat.i(13502);
        ab.d("MicroMsg.BindMobileStatusUI", "switch change : open = " + z + " item value = " + i + " functionId = " + i2);
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
        AppMethodBeat.o(13502);
        return true;
    }

    public final void initView() {
        boolean z = true;
        AppMethodBeat.i(13503);
        this.gri = (ImageView) findViewById(R.id.a58);
        this.grR = (TextView) findViewById(R.id.a59);
        this.grB = (TextView) findViewById(R.id.a5_);
        this.grC = (Button) findViewById(R.id.a5a);
        this.grS = (ImageView) findViewById(R.id.a5c);
        this.grT = (ImageView) findViewById(R.id.a5e);
        this.grW = (RelativeLayout) findViewById(R.id.a5b);
        this.grX = (RelativeLayout) findViewById(R.id.a5d);
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
                b(z2, 512, 8);
                if (this.gsb) {
                    z = false;
                }
                b(z, 256, 7);
                break;
            case 1:
                this.grW.setVisibility(0);
                this.grW.setBackgroundResource(R.drawable.e9);
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
        addTextOptionMenu(0, getString(R.string.qt), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(13495);
                BindMobileStatusUI.a(BindMobileStatusUI.this);
                AppMethodBeat.o(13495);
                return false;
            }
        });
        if (l.apS() == a.SUCC || l.apS() == a.SUCC_UNLOAD) {
            this.gri.setImageResource(R.drawable.ab_);
            String str = (String) g.RP().Ry().get(6, null);
            if (str == null || str.equals("")) {
                g.RP().Ry().get(4097, null);
            }
        } else {
            this.gri.setImageResource(R.drawable.ab7);
            this.grB.setVisibility(8);
            this.grR.setText(getString(R.string.a66));
        }
        this.grS.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                boolean z = true;
                AppMethodBeat.i(13496);
                BindMobileStatusUI.this.grU = Boolean.valueOf(!BindMobileStatusUI.this.grU.booleanValue());
                if (BindMobileStatusUI.this.grU.booleanValue()) {
                    BindMobileStatusUI.this.grS.setImageResource(R.raw.checkbox_selected);
                } else {
                    BindMobileStatusUI.this.grS.setImageResource(R.raw.checkbox_unselected);
                }
                BindMobileStatusUI bindMobileStatusUI = BindMobileStatusUI.this;
                if (BindMobileStatusUI.this.grU.booleanValue()) {
                    z = false;
                }
                BindMobileStatusUI.a(bindMobileStatusUI, z, 512, 8);
                AppMethodBeat.o(13496);
            }
        });
        this.grT.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                boolean z = true;
                AppMethodBeat.i(13497);
                BindMobileStatusUI.this.grV = Boolean.valueOf(!BindMobileStatusUI.this.grV.booleanValue());
                if (BindMobileStatusUI.this.grV.booleanValue()) {
                    BindMobileStatusUI.this.grT.setImageResource(R.raw.checkbox_selected);
                } else {
                    BindMobileStatusUI.this.grT.setImageResource(R.raw.checkbox_unselected);
                }
                BindMobileStatusUI bindMobileStatusUI = BindMobileStatusUI.this;
                if (BindMobileStatusUI.this.grV.booleanValue()) {
                    z = false;
                }
                BindMobileStatusUI.a(bindMobileStatusUI, z, 256, 7);
                if (!BindMobileStatusUI.this.grV.booleanValue()) {
                    BindMobileStatusUI.a(BindMobileStatusUI.this, false, 2097152, 32);
                }
                AppMethodBeat.o(13497);
            }
        });
        this.grC.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(13498);
                BindMobileStatusUI.f(BindMobileStatusUI.this);
                AppMethodBeat.o(13498);
            }
        });
        AppMethodBeat.o(13503);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(13504);
        if (i == 4) {
            Ni(1);
            AppMethodBeat.o(13504);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(13504);
        return onKeyDown;
    }

    public static void c(Context context, boolean z, boolean z2) {
        boolean z3 = false;
        int i = 1;
        AppMethodBeat.i(13505);
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName() + "_preferences", 0);
        sharedPreferences.edit().putBoolean("settings_find_me_by_mobile", !z).commit();
        Editor edit = sharedPreferences.edit();
        String str = "settings_recommend_mobilefriends_to_me";
        if (!z2) {
            z3 = true;
        }
        edit.putBoolean(str, z3).commit();
        int YD = r.YD();
        YD = z ? YD | 512 : YD & -513;
        g.RP().Ry().set(7, Integer.valueOf(z2 ? YD | 256 : YD & -257));
        act act = new act();
        act.wkw = 8;
        if (z2) {
            YD = 1;
        } else {
            YD = 2;
        }
        act.pvD = YD;
        ((j) g.K(j.class)).XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(23, act));
        act act2 = new act();
        act2.wkw = 7;
        if (!z) {
            i = 2;
        }
        act.pvD = i;
        ((j) g.K(j.class)).XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(23, act2));
        com.tencent.mm.plugin.account.a.a.gkF.BS();
        AppMethodBeat.o(13505);
    }

    public void onPause() {
        AppMethodBeat.i(13501);
        g.RP().Ry().set(7, Integer.valueOf(this.status));
        for (Entry entry : this.gsc.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            act act = new act();
            act.wkw = intValue;
            act.pvD = intValue2;
            ((j) g.K(j.class)).XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(23, act));
            ab.d("MicroMsg.BindMobileStatusUI", "switch  " + intValue + " " + intValue2);
        }
        this.gsc.clear();
        super.onPause();
        AppMethodBeat.o(13501);
    }

    static /* synthetic */ void a(BindMobileStatusUI bindMobileStatusUI) {
        AppMethodBeat.i(13506);
        bindMobileStatusUI.Ni(1);
        AppMethodBeat.o(13506);
    }

    static /* synthetic */ void f(BindMobileStatusUI bindMobileStatusUI) {
        AppMethodBeat.i(13508);
        bindMobileStatusUI.Ni(1);
        AppMethodBeat.o(13508);
    }
}

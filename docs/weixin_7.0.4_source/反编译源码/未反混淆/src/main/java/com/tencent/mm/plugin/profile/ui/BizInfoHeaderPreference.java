package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ah.d.a;
import com.tencent.mm.ah.o;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.f;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import junit.framework.Assert;

public class BizInfoHeaderPreference extends Preference implements a, b {
    private MMActivity crP;
    private ad ehM;
    private boolean lyb = false;
    private TextView niS;
    private TextView nrD;
    private ImageView pkS;
    private ImageView pkT;
    private View pkU;
    private String pkV;
    private d pkW;
    private com.tencent.mm.plugin.profile.ui.b.a pkX = new com.tencent.mm.plugin.profile.ui.b.a(this);
    private com.tencent.mm.plugin.profile.ui.b.b pkY = new com.tencent.mm.plugin.profile.ui.b.b(this);

    public BizInfoHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(23307);
        this.crP = (MMActivity) context;
        this.lyb = false;
        AppMethodBeat.o(23307);
    }

    public BizInfoHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(23308);
        this.crP = (MMActivity) context;
        this.lyb = false;
        AppMethodBeat.o(23308);
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(23309);
        ab.d("MicroMsg.BizInfoHeaderPreference", "onBindView");
        this.niS = (TextView) view.findViewById(R.id.y2);
        this.nrD = (TextView) view.findViewById(R.id.b29);
        this.pkT = (ImageView) view.findViewById(R.id.b2_);
        this.pkS = (ImageView) view.findViewById(R.id.y1);
        this.pkU = view.findViewById(R.id.b28);
        this.lyb = true;
        initView();
        super.onBindView(view);
        AppMethodBeat.o(23309);
    }

    private boolean hasInit() {
        return this.lyb && this.ehM != null;
    }

    private void initView() {
        AppMethodBeat.i(23310);
        if (hasInit()) {
            this.niS.setText(j.b(this.crP, bo.nullAsNil(this.ehM.Oi()) + " ", this.niS.getTextSize()));
            if (this.pkW == null) {
                this.pkW = f.qX(this.ehM.field_username);
            }
            if (this.pkW != null) {
                this.pkV = this.pkW.field_brandIconURL;
            }
            com.tencent.mm.plugin.brandservice.b.a.a(this.pkS, this.ehM, this.pkV, false);
            this.pkS.setTag(this.ehM.field_username);
            this.pkU.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(23306);
                    String str = BizInfoHeaderPreference.this.ehM.field_username;
                    Intent intent = new Intent(BizInfoHeaderPreference.this.crP, ProfileHdHeadImg.class);
                    intent.putExtra("username", str);
                    intent.putExtra("brand_icon_url", BizInfoHeaderPreference.this.pkV);
                    BizInfoHeaderPreference.this.crP.startActivity(intent);
                    AppMethodBeat.o(23306);
                }
            });
            if (!com.tencent.mm.n.a.jh(this.ehM.field_type) || !adV()) {
                this.nrD.setVisibility(8);
            } else if (!bo.isNullOrNil(this.ehM.Hq())) {
                this.nrD.setVisibility(0);
                this.nrD.setText(this.mContext.getString(R.string.qf) + this.ehM.Hq());
            } else if (ad.aoA(this.ehM.field_username) || t.mX(this.ehM.field_username)) {
                this.nrD.setVisibility(8);
            } else {
                this.nrD.setText(this.mContext.getString(R.string.qf) + bo.nullAsNil(this.ehM.Ok()));
                this.nrD.setVisibility(0);
            }
            if (this.ehM.Oc()) {
                this.pkT.setVisibility(0);
                AppMethodBeat.o(23310);
                return;
            }
            this.pkT.setVisibility(8);
            AppMethodBeat.o(23310);
            return;
        }
        ab.w("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.lyb + "contact = " + this.ehM);
        AppMethodBeat.o(23310);
    }

    public final void a(ad adVar, String str, d dVar) {
        AppMethodBeat.i(23311);
        this.pkV = str;
        this.pkW = dVar;
        onDetach();
        aw.ZK();
        c.XM().a(this.pkY);
        o.acd().d(this.pkX);
        this.ehM = adVar;
        Assert.assertTrue("initView: contact username is null", bo.nullAsNil(adVar.field_username).length() > 0);
        initView();
        AppMethodBeat.o(23311);
    }

    public final void onDetach() {
        AppMethodBeat.i(23312);
        aw.ZK();
        c.XM().b(this.pkY);
        o.acd().e(this.pkX);
        AppMethodBeat.o(23312);
    }

    public final void qj(String str) {
        AppMethodBeat.i(23313);
        if (!hasInit()) {
            ab.e("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.lyb + "contact = " + this.ehM);
            AppMethodBeat.o(23313);
        } else if (bo.nullAsNil(str).length() <= 0) {
            ab.e("MicroMsg.BizInfoHeaderPreference", "notifyChanged: user = ".concat(String.valueOf(str)));
            AppMethodBeat.o(23313);
        } else {
            if (str.equals(this.ehM.field_username)) {
                initView();
            }
            AppMethodBeat.o(23313);
        }
    }

    public final void a(int i, n nVar, Object obj) {
        AppMethodBeat.i(23314);
        if (obj == null || !(obj instanceof String)) {
            ab.d("MicroMsg.BizInfoHeaderPreference", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), nVar, obj);
            AppMethodBeat.o(23314);
        } else if (hasInit()) {
            String str = (String) obj;
            if (bo.nullAsNil(str).length() <= 0) {
                AppMethodBeat.o(23314);
                return;
            }
            if (this.ehM != null && this.ehM.field_username.equals(str)) {
                aw.ZK();
                this.ehM = c.XM().aoO(str);
            }
            AppMethodBeat.o(23314);
        } else {
            ab.e("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.lyb + "contact = " + this.ehM);
            AppMethodBeat.o(23314);
        }
    }

    private boolean adV() {
        AppMethodBeat.i(23315);
        if (this.pkW == null) {
            AppMethodBeat.o(23315);
            return true;
        }
        boolean adV = this.pkW.adV();
        AppMethodBeat.o(23315);
        return adV;
    }
}

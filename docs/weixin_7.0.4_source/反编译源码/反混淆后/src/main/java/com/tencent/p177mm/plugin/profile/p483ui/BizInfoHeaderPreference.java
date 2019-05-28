package com.tencent.p177mm.plugin.profile.p483ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41732d.C8915a;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.brandservice.p926b.C11188a;
import com.tencent.p177mm.plugin.profile.p483ui.p1288b.C34722a;
import com.tencent.p177mm.plugin.profile.p483ui.p1288b.C34723b;
import com.tencent.p177mm.pluginsdk.p597ui.ProfileHdHeadImg;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.profile.ui.BizInfoHeaderPreference */
public class BizInfoHeaderPreference extends Preference implements C8915a, C4937b {
    private MMActivity crP;
    private C7616ad ehM;
    private boolean lyb = false;
    private TextView niS;
    private TextView nrD;
    private ImageView pkS;
    private ImageView pkT;
    private View pkU;
    private String pkV;
    private C16527d pkW;
    private C34722a pkX = new C34722a(this);
    private C34723b pkY = new C34723b(this);

    /* renamed from: com.tencent.mm.plugin.profile.ui.BizInfoHeaderPreference$1 */
    class C214561 implements OnClickListener {
        C214561() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(23306);
            String str = BizInfoHeaderPreference.this.ehM.field_username;
            Intent intent = new Intent(BizInfoHeaderPreference.this.crP, ProfileHdHeadImg.class);
            intent.putExtra("username", str);
            intent.putExtra("brand_icon_url", BizInfoHeaderPreference.this.pkV);
            BizInfoHeaderPreference.this.crP.startActivity(intent);
            AppMethodBeat.m2505o(23306);
        }
    }

    public BizInfoHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(23307);
        this.crP = (MMActivity) context;
        this.lyb = false;
        AppMethodBeat.m2505o(23307);
    }

    public BizInfoHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(23308);
        this.crP = (MMActivity) context;
        this.lyb = false;
        AppMethodBeat.m2505o(23308);
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(23309);
        C4990ab.m7410d("MicroMsg.BizInfoHeaderPreference", "onBindView");
        this.niS = (TextView) view.findViewById(2131821460);
        this.nrD = (TextView) view.findViewById(2131822995);
        this.pkT = (ImageView) view.findViewById(2131822996);
        this.pkS = (ImageView) view.findViewById(2131821459);
        this.pkU = view.findViewById(2131822994);
        this.lyb = true;
        initView();
        super.onBindView(view);
        AppMethodBeat.m2505o(23309);
    }

    private boolean hasInit() {
        return this.lyb && this.ehM != null;
    }

    private void initView() {
        AppMethodBeat.m2504i(23310);
        if (hasInit()) {
            this.niS.setText(C44089j.m79293b(this.crP, C5046bo.nullAsNil(this.ehM.mo16706Oi()) + " ", this.niS.getTextSize()));
            if (this.pkW == null) {
                this.pkW = C17903f.m28104qX(this.ehM.field_username);
            }
            if (this.pkW != null) {
                this.pkV = this.pkW.field_brandIconURL;
            }
            C11188a.m18894a(this.pkS, this.ehM, this.pkV, false);
            this.pkS.setTag(this.ehM.field_username);
            this.pkU.setOnClickListener(new C214561());
            if (!C7486a.m12942jh(this.ehM.field_type) || !adV()) {
                this.nrD.setVisibility(8);
            } else if (!C5046bo.isNullOrNil(this.ehM.mo14673Hq())) {
                this.nrD.setVisibility(0);
                this.nrD.setText(this.mContext.getString(C25738R.string.f9131qf) + this.ehM.mo14673Hq());
            } else if (C7616ad.aoA(this.ehM.field_username) || C1855t.m3911mX(this.ehM.field_username)) {
                this.nrD.setVisibility(8);
            } else {
                this.nrD.setText(this.mContext.getString(C25738R.string.f9131qf) + C5046bo.nullAsNil(this.ehM.mo16708Ok()));
                this.nrD.setVisibility(0);
            }
            if (this.ehM.mo16700Oc()) {
                this.pkT.setVisibility(0);
                AppMethodBeat.m2505o(23310);
                return;
            }
            this.pkT.setVisibility(8);
            AppMethodBeat.m2505o(23310);
            return;
        }
        C4990ab.m7420w("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.lyb + "contact = " + this.ehM);
        AppMethodBeat.m2505o(23310);
    }

    /* renamed from: a */
    public final void mo55303a(C7616ad c7616ad, String str, C16527d c16527d) {
        AppMethodBeat.m2504i(23311);
        this.pkV = str;
        this.pkW = c16527d;
        onDetach();
        C9638aw.m17190ZK();
        C18628c.m29078XM().mo10118a(this.pkY);
        C17884o.acd().mo67502d(this.pkX);
        this.ehM = c7616ad;
        Assert.assertTrue("initView: contact username is null", C5046bo.nullAsNil(c7616ad.field_username).length() > 0);
        initView();
        AppMethodBeat.m2505o(23311);
    }

    public final void onDetach() {
        AppMethodBeat.m2504i(23312);
        C9638aw.m17190ZK();
        C18628c.m29078XM().mo10121b(this.pkY);
        C17884o.acd().mo67503e(this.pkX);
        AppMethodBeat.m2505o(23312);
    }

    /* renamed from: qj */
    public final void mo20342qj(String str) {
        AppMethodBeat.m2504i(23313);
        if (!hasInit()) {
            C4990ab.m7412e("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.lyb + "contact = " + this.ehM);
            AppMethodBeat.m2505o(23313);
        } else if (C5046bo.nullAsNil(str).length() <= 0) {
            C4990ab.m7412e("MicroMsg.BizInfoHeaderPreference", "notifyChanged: user = ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(23313);
        } else {
            if (str.equals(this.ehM.field_username)) {
                initView();
            }
            AppMethodBeat.m2505o(23313);
        }
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(23314);
        if (obj == null || !(obj instanceof String)) {
            C4990ab.m7411d("MicroMsg.BizInfoHeaderPreference", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), c7298n, obj);
            AppMethodBeat.m2505o(23314);
        } else if (hasInit()) {
            String str = (String) obj;
            if (C5046bo.nullAsNil(str).length() <= 0) {
                AppMethodBeat.m2505o(23314);
                return;
            }
            if (this.ehM != null && this.ehM.field_username.equals(str)) {
                C9638aw.m17190ZK();
                this.ehM = C18628c.m29078XM().aoO(str);
            }
            AppMethodBeat.m2505o(23314);
        } else {
            C4990ab.m7412e("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.lyb + "contact = " + this.ehM);
            AppMethodBeat.m2505o(23314);
        }
    }

    private boolean adV() {
        AppMethodBeat.m2504i(23315);
        if (this.pkW == null) {
            AppMethodBeat.m2505o(23315);
            return true;
        }
        boolean adV = this.pkW.adV();
        AppMethodBeat.m2505o(23315);
        return adV;
    }
}

package com.tencent.p177mm.plugin.profile.p483ui.newbizinfo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41732d.C8915a;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.C5230ak;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.brandservice.p926b.C11188a;
import com.tencent.p177mm.plugin.profile.p483ui.newbizinfo.p1012b.C46140d;
import com.tencent.p177mm.plugin.profile.p483ui.p1288b.C34722a;
import com.tencent.p177mm.plugin.profile.p483ui.p1288b.C34723b;
import com.tencent.p177mm.pluginsdk.p597ui.ProfileHdHeadImg;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C30309s;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

/* renamed from: com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoHeaderPreference */
public class NewBizInfoHeaderPreference extends Preference implements C8915a, C4937b {
    private static long ppW = 0;
    private MMActivity crP;
    private C7616ad ehM;
    private ImageView eks;
    private TextView gne;
    private TextView hrg;
    private boolean lyb;
    private RelativeLayout oZf;
    private String pkV;
    private C16527d pkW;
    private C34722a pkX = new C34722a(this);
    private C34723b pkY = new C34723b(this);
    private C46140d ppN;
    private ImageView ppV;

    /* renamed from: com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoHeaderPreference$1 */
    class C395271 implements OnClickListener {
        C395271() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(23854);
            String str = NewBizInfoHeaderPreference.this.ehM.field_username;
            Intent intent = new Intent(NewBizInfoHeaderPreference.this.crP, ProfileHdHeadImg.class);
            intent.putExtra("username", str);
            intent.putExtra("brand_icon_url", NewBizInfoHeaderPreference.this.pkV);
            NewBizInfoHeaderPreference.this.crP.startActivity(intent);
            AppMethodBeat.m2505o(23854);
        }
    }

    public NewBizInfoHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(23855);
        this.crP = (MMActivity) context;
        this.lyb = false;
        AppMethodBeat.m2505o(23855);
    }

    public NewBizInfoHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(23856);
        this.crP = (MMActivity) context;
        this.lyb = false;
        AppMethodBeat.m2505o(23856);
    }

    /* renamed from: jy */
    public static void m86116jy(long j) {
        ppW = j;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(23857);
        this.eks = (ImageView) view.findViewById(2131823001);
        this.gne = (TextView) view.findViewById(2131823003);
        this.hrg = (TextView) view.findViewById(2131822998);
        this.ppV = (ImageView) view.findViewById(2131823004);
        this.oZf = (RelativeLayout) view.findViewById(2131823000);
        this.lyb = true;
        initView();
        super.onBindView(view);
        AppMethodBeat.m2505o(23857);
    }

    private void initView() {
        AppMethodBeat.m2504i(23858);
        if (!this.lyb || this.ehM == null) {
            C4990ab.m7420w("MicroMsg.NewBizInfoHeaderPreference", "initView contact is null, return");
            AppMethodBeat.m2505o(23858);
            return;
        }
        int textSize;
        this.gne.setText(C44089j.m79293b(this.crP, C5046bo.nullAsNil(this.ehM.mo16706Oi()), this.gne.getTextSize()));
        if (this.pkW == null) {
            this.pkW = C17903f.m28104qX(this.ehM.field_username);
        }
        if (this.pkW != null) {
            this.pkV = this.pkW.field_brandIconURL;
        }
        if (this.ppN == null || this.ppN.arA()) {
            boolean z;
            this.eks.setVisibility(0);
            if (System.currentTimeMillis() - ppW < FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
                z = true;
            } else {
                z = false;
            }
            C11188a.m18894a(this.eks, this.ehM, this.pkV, z);
            this.eks.setOnClickListener(new C395271());
        } else {
            this.eks.setVisibility(8);
        }
        if (C5046bo.nullAsNil(this.ehM.signature).trim().length() <= 0) {
            this.hrg.setVisibility(8);
        } else {
            this.hrg.setText(C44089j.m79292b(this.crP, this.ehM.signature));
            this.hrg.setVisibility(0);
            cbI();
        }
        if (C30309s.aVO() && C7486a.m12942jh(this.ehM.field_type) && this.ehM.mo16702Oe() && C17903f.m28106qZ(this.ehM.field_username)) {
            this.ppV.setVisibility(0);
            LayoutParams layoutParams = this.ppV.getLayoutParams();
            textSize = (int) this.gne.getTextSize();
            layoutParams.height = textSize;
            layoutParams.width = textSize;
            this.ppV.setLayoutParams(layoutParams);
        } else {
            this.ppV.setVisibility(4);
        }
        int statusBarHeight = C5230ak.getStatusBarHeight(this.mContext);
        textSize = C5230ak.m7987de(this.mContext);
        C4990ab.m7411d("MicroMsg.NewBizInfoHeaderPreference", "actionBarHeight=%s statusBarHeight=%s", Integer.valueOf(textSize), Integer.valueOf(statusBarHeight));
        if (statusBarHeight <= 0 || textSize <= 0) {
            this.oZf.setPadding(this.oZf.getPaddingLeft(), C1338a.m2857am(this.mContext, C25738R.dimen.a7j), this.oZf.getPaddingRight(), this.oZf.getPaddingBottom());
            AppMethodBeat.m2505o(23858);
            return;
        }
        this.oZf.setPadding(this.oZf.getPaddingLeft(), (statusBarHeight + textSize) + C1338a.m2857am(this.mContext, C25738R.dimen.f10011nc), this.oZf.getPaddingRight(), this.oZf.getPaddingBottom());
        AppMethodBeat.m2505o(23858);
    }

    /* renamed from: a */
    public final void mo74083a(C7616ad c7616ad, String str, C16527d c16527d, C46140d c46140d) {
        AppMethodBeat.m2504i(23860);
        onDetach();
        this.pkV = str;
        this.pkW = c16527d;
        this.ehM = c7616ad;
        this.ppN = c46140d;
        C9638aw.m17190ZK();
        C18628c.m29078XM().mo10118a(this.pkY);
        C17884o.acd().mo67502d(this.pkX);
        initView();
        AppMethodBeat.m2505o(23860);
    }

    public final void onDetach() {
        AppMethodBeat.m2504i(23861);
        C9638aw.m17190ZK();
        C18628c.m29078XM().mo10121b(this.pkY);
        C17884o.acd().mo67503e(this.pkX);
        AppMethodBeat.m2505o(23861);
    }

    /* renamed from: qj */
    public final void mo20342qj(String str) {
        AppMethodBeat.m2504i(23862);
        C4990ab.m7417i("MicroMsg.NewBizInfoHeaderPreference", "notifyChanged user:%s", str);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7416i("MicroMsg.NewBizInfoHeaderPreference", "notifyChanged err, user is null");
            AppMethodBeat.m2505o(23862);
            return;
        }
        if (this.ehM != null && str.equals(this.ehM.field_username)) {
            initView();
        }
        AppMethodBeat.m2505o(23862);
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(23863);
        if (obj == null || !(obj instanceof String)) {
            C4990ab.m7411d("MicroMsg.NewBizInfoHeaderPreference", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), c7298n, obj);
            AppMethodBeat.m2505o(23863);
            return;
        }
        String str = (String) obj;
        if (C5046bo.nullAsNil(str).length() <= 0) {
            AppMethodBeat.m2505o(23863);
            return;
        }
        if (this.ehM != null && this.ehM.field_username.equals(str)) {
            C9638aw.m17190ZK();
            this.ehM = C18628c.m29078XM().aoO(str);
        }
        AppMethodBeat.m2505o(23863);
    }

    private void cbI() {
        Bitmap i;
        Drawable bitmapDrawable;
        boolean z = true;
        AppMethodBeat.m2504i(23859);
        if (C26417a.flw != null) {
            i = C4977b.m7374i(C26417a.flw.mo37872ky(this.ehM.field_verifyFlag), 2.0f);
        } else {
            i = null;
        }
        String str = "MicroMsg.NewBizInfoHeaderPreference";
        String str2 = "verify bmp is null ? %B";
        Object[] objArr = new Object[1];
        if (i != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        C4990ab.m7417i(str, str2, objArr);
        if (i != null) {
            bitmapDrawable = new BitmapDrawable(this.crP.getResources(), i);
        } else {
            bitmapDrawable = null;
        }
        this.hrg.setCompoundDrawables(bitmapDrawable, null, null, null);
        AppMethodBeat.m2505o(23859);
    }
}

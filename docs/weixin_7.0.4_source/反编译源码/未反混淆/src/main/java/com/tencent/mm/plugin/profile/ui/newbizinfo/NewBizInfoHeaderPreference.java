package com.tencent.mm.plugin.profile.ui.newbizinfo;

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
import com.tencent.mm.R;
import com.tencent.mm.ah.d.a;
import com.tencent.mm.ah.o;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.f;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.s;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

public class NewBizInfoHeaderPreference extends Preference implements a, b {
    private static long ppW = 0;
    private MMActivity crP;
    private ad ehM;
    private ImageView eks;
    private TextView gne;
    private TextView hrg;
    private boolean lyb;
    private RelativeLayout oZf;
    private String pkV;
    private d pkW;
    private com.tencent.mm.plugin.profile.ui.b.a pkX = new com.tencent.mm.plugin.profile.ui.b.a(this);
    private com.tencent.mm.plugin.profile.ui.b.b pkY = new com.tencent.mm.plugin.profile.ui.b.b(this);
    private com.tencent.mm.plugin.profile.ui.newbizinfo.b.d ppN;
    private ImageView ppV;

    public NewBizInfoHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(23855);
        this.crP = (MMActivity) context;
        this.lyb = false;
        AppMethodBeat.o(23855);
    }

    public NewBizInfoHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(23856);
        this.crP = (MMActivity) context;
        this.lyb = false;
        AppMethodBeat.o(23856);
    }

    public static void jy(long j) {
        ppW = j;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(23857);
        this.eks = (ImageView) view.findViewById(R.id.b2e);
        this.gne = (TextView) view.findViewById(R.id.b2g);
        this.hrg = (TextView) view.findViewById(R.id.b2b);
        this.ppV = (ImageView) view.findViewById(R.id.b2h);
        this.oZf = (RelativeLayout) view.findViewById(R.id.b2d);
        this.lyb = true;
        initView();
        super.onBindView(view);
        AppMethodBeat.o(23857);
    }

    private void initView() {
        AppMethodBeat.i(23858);
        if (!this.lyb || this.ehM == null) {
            ab.w("MicroMsg.NewBizInfoHeaderPreference", "initView contact is null, return");
            AppMethodBeat.o(23858);
            return;
        }
        int textSize;
        this.gne.setText(j.b(this.crP, bo.nullAsNil(this.ehM.Oi()), this.gne.getTextSize()));
        if (this.pkW == null) {
            this.pkW = f.qX(this.ehM.field_username);
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
            com.tencent.mm.plugin.brandservice.b.a.a(this.eks, this.ehM, this.pkV, z);
            this.eks.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(23854);
                    String str = NewBizInfoHeaderPreference.this.ehM.field_username;
                    Intent intent = new Intent(NewBizInfoHeaderPreference.this.crP, ProfileHdHeadImg.class);
                    intent.putExtra("username", str);
                    intent.putExtra("brand_icon_url", NewBizInfoHeaderPreference.this.pkV);
                    NewBizInfoHeaderPreference.this.crP.startActivity(intent);
                    AppMethodBeat.o(23854);
                }
            });
        } else {
            this.eks.setVisibility(8);
        }
        if (bo.nullAsNil(this.ehM.signature).trim().length() <= 0) {
            this.hrg.setVisibility(8);
        } else {
            this.hrg.setText(j.b(this.crP, this.ehM.signature));
            this.hrg.setVisibility(0);
            cbI();
        }
        if (s.aVO() && com.tencent.mm.n.a.jh(this.ehM.field_type) && this.ehM.Oe() && f.qZ(this.ehM.field_username)) {
            this.ppV.setVisibility(0);
            LayoutParams layoutParams = this.ppV.getLayoutParams();
            textSize = (int) this.gne.getTextSize();
            layoutParams.height = textSize;
            layoutParams.width = textSize;
            this.ppV.setLayoutParams(layoutParams);
        } else {
            this.ppV.setVisibility(4);
        }
        int statusBarHeight = ak.getStatusBarHeight(this.mContext);
        textSize = ak.de(this.mContext);
        ab.d("MicroMsg.NewBizInfoHeaderPreference", "actionBarHeight=%s statusBarHeight=%s", Integer.valueOf(textSize), Integer.valueOf(statusBarHeight));
        if (statusBarHeight <= 0 || textSize <= 0) {
            this.oZf.setPadding(this.oZf.getPaddingLeft(), com.tencent.mm.bz.a.am(this.mContext, R.dimen.a7j), this.oZf.getPaddingRight(), this.oZf.getPaddingBottom());
            AppMethodBeat.o(23858);
            return;
        }
        this.oZf.setPadding(this.oZf.getPaddingLeft(), (statusBarHeight + textSize) + com.tencent.mm.bz.a.am(this.mContext, R.dimen.nc), this.oZf.getPaddingRight(), this.oZf.getPaddingBottom());
        AppMethodBeat.o(23858);
    }

    public final void a(ad adVar, String str, d dVar, com.tencent.mm.plugin.profile.ui.newbizinfo.b.d dVar2) {
        AppMethodBeat.i(23860);
        onDetach();
        this.pkV = str;
        this.pkW = dVar;
        this.ehM = adVar;
        this.ppN = dVar2;
        aw.ZK();
        c.XM().a(this.pkY);
        o.acd().d(this.pkX);
        initView();
        AppMethodBeat.o(23860);
    }

    public final void onDetach() {
        AppMethodBeat.i(23861);
        aw.ZK();
        c.XM().b(this.pkY);
        o.acd().e(this.pkX);
        AppMethodBeat.o(23861);
    }

    public final void qj(String str) {
        AppMethodBeat.i(23862);
        ab.i("MicroMsg.NewBizInfoHeaderPreference", "notifyChanged user:%s", str);
        if (bo.isNullOrNil(str)) {
            ab.i("MicroMsg.NewBizInfoHeaderPreference", "notifyChanged err, user is null");
            AppMethodBeat.o(23862);
            return;
        }
        if (this.ehM != null && str.equals(this.ehM.field_username)) {
            initView();
        }
        AppMethodBeat.o(23862);
    }

    public final void a(int i, n nVar, Object obj) {
        AppMethodBeat.i(23863);
        if (obj == null || !(obj instanceof String)) {
            ab.d("MicroMsg.NewBizInfoHeaderPreference", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), nVar, obj);
            AppMethodBeat.o(23863);
            return;
        }
        String str = (String) obj;
        if (bo.nullAsNil(str).length() <= 0) {
            AppMethodBeat.o(23863);
            return;
        }
        if (this.ehM != null && this.ehM.field_username.equals(str)) {
            aw.ZK();
            this.ehM = c.XM().aoO(str);
        }
        AppMethodBeat.o(23863);
    }

    private void cbI() {
        Bitmap i;
        Drawable bitmapDrawable;
        boolean z = true;
        AppMethodBeat.i(23859);
        if (ao.a.flw != null) {
            i = BackwardSupportUtil.b.i(ao.a.flw.ky(this.ehM.field_verifyFlag), 2.0f);
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
        ab.i(str, str2, objArr);
        if (i != null) {
            bitmapDrawable = new BitmapDrawable(this.crP.getResources(), i);
        } else {
            bitmapDrawable = null;
        }
        this.hrg.setCompoundDrawables(bitmapDrawable, null, null, null);
        AppMethodBeat.o(23859);
    }
}

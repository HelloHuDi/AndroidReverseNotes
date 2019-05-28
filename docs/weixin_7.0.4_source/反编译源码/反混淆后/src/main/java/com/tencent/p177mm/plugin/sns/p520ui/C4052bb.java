package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C13473h;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C3950f.C3951a;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C3953i;
import com.tencent.p177mm.plugin.sns.storage.C21980a;
import com.tencent.p177mm.plugin.sns.storage.C21984b;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C46618a;

/* renamed from: com.tencent.mm.plugin.sns.ui.bb */
public final class C4052bb {
    private String nJy = C4988aa.m7403gw(C4996ah.getContext());
    private LinearLayout rDh;
    public TextView rDi;
    public TextView rDj;
    private View rDk;
    private View rDl;
    public C21984b rDm;
    public C21980a rDn;
    private View view;

    public final String cuH() {
        if (this.rDn == null) {
            return "";
        }
        if (this.rDn.qPj == null) {
            return "";
        }
        return this.rDn.qPj;
    }

    public final int[] cuI() {
        AppMethodBeat.m2504i(39856);
        int[] iArr = new int[2];
        if (this.rDh != null) {
            this.rDk.getLocationInWindow(iArr);
            iArr[0] = iArr[0] + this.rDk.getMeasuredWidth();
        } else if (this.rDk != null) {
            this.rDk.getLocationInWindow(iArr);
            iArr[0] = iArr[0] + this.rDk.getMeasuredWidth();
        }
        AppMethodBeat.m2505o(39856);
        return iArr;
    }

    public C4052bb(View view) {
        AppMethodBeat.m2504i(39857);
        this.view = view;
        C4990ab.m7416i("MicroMsg.TimeLineAdView", "adView init lan " + this.nJy);
        this.rDi = (TextView) this.view.findViewById(2131827660);
        this.rDj = (TextView) this.view.findViewById(2131827661);
        this.rDk = this.view.findViewById(2131827714);
        this.rDl = this.view.findViewById(2131827713);
        this.rDh = (LinearLayout) this.view.findViewById(2131827712);
        this.rDi.setText(" " + this.view.getResources().getString(C25738R.string.ejb) + " ");
        AppMethodBeat.m2505o(39857);
    }

    /* renamed from: a */
    public final void mo8917a(OnClickListener onClickListener, OnClickListener onClickListener2) {
        AppMethodBeat.m2504i(39858);
        this.rDj.setOnClickListener(onClickListener);
        this.rDi.setOnClickListener(onClickListener2);
        if (this.rDk != null) {
            this.rDk.setOnClickListener(onClickListener2);
        }
        if (this.rDh != null) {
            this.rDh.setOnClickListener(onClickListener2);
        }
        AppMethodBeat.m2505o(39858);
    }

    /* renamed from: z */
    public final void mo8922z(Object obj, Object obj2) {
        AppMethodBeat.m2504i(39859);
        this.rDj.setTag(obj);
        this.rDi.setTag(obj2);
        if (this.rDk != null) {
            this.rDk.setTag(obj2);
        }
        if (this.rDh != null) {
            this.rDh.setTag(obj2);
        }
        AppMethodBeat.m2505o(39859);
    }

    /* renamed from: a */
    public final void mo8918a(C21984b c21984b, C21980a c21980a) {
        Object imageSpan;
        AppMethodBeat.m2504i(39860);
        this.rDn = c21980a;
        this.rDm = c21984b;
        String str = "";
        if (c21984b != null) {
            if ("zh_CN".equals(this.nJy)) {
                str = c21984b.qUk;
            } else if ("zh_TW".equals(this.nJy) || "zh_HK".equals(this.nJy)) {
                str = c21984b.qUm;
            } else {
                str = c21984b.qUl;
            }
        }
        if (c21984b != null && C5046bo.isNullOrNil(r0)) {
            str = c21984b.qUi;
        }
        Context context = this.rDj.getContext();
        if (C5046bo.isNullOrNil(str)) {
            str = context.getString(C25738R.string.ejh);
        }
        str = str + " ";
        final int length = str.length();
        final SpannableString spannableString = new SpannableString(str + "ad_");
        Drawable drawable;
        if (c21980a == null || !c21980a.coI()) {
            drawable = context.getResources().getDrawable(C1318a.album_advertise_link_icon);
            drawable.setBounds(0, 0, (int) (((double) this.rDj.getTextSize()) * 1.3d), (int) (((double) this.rDj.getTextSize()) * 1.3d));
            imageSpan = new ImageSpan(drawable, 0);
        } else {
            drawable = context.getResources().getDrawable(C1318a.album_ad_link_tag_weapp);
            drawable.setBounds(0, 0, (int) (((double) this.rDj.getTextSize()) * 0.8d), (int) (((double) this.rDj.getTextSize()) * 0.8d));
            imageSpan = new ImageSpan(drawable, 1);
        }
        if (!C5046bo.isNullOrNil(c21984b.qUj)) {
            C13473h.m21623c("adId", c21984b.qUj, false, 41, new C3951a() {
                public final void cpu() {
                }

                public final void cmD() {
                }

                /* renamed from: YJ */
                public final void mo8627YJ(String str) {
                    AppMethodBeat.m2504i(39855);
                    if (C5046bo.isNullOrNil(str)) {
                        AppMethodBeat.m2505o(39855);
                        return;
                    }
                    Drawable createFromPath = Drawable.createFromPath(str);
                    if (createFromPath != null) {
                        createFromPath.setBounds(0, 0, (int) (((double) C4052bb.this.rDj.getTextSize()) * 1.3d), (int) (((double) C4052bb.this.rDj.getTextSize()) * 1.3d));
                        spannableString.setSpan(new ImageSpan(createFromPath, 0), length, length + 3, 33);
                        C4052bb.this.rDj.setText(spannableString);
                    }
                    AppMethodBeat.m2505o(39855);
                }
            });
        }
        spannableString.setSpan(imageSpan, length, length + 3, 33);
        this.rDj.setText(spannableString);
        if (c21980a == null || C5046bo.isNullOrNil(c21980a.qTD)) {
            this.rDl.setVisibility(8);
        } else {
            this.rDl.setVisibility(0);
        }
        if (c21984b != null) {
            if ("zh_CN".equals(this.nJy)) {
                str = c21984b.qUt;
            } else if ("zh_TW".equals(this.nJy) || "zh_HK".equals(this.nJy)) {
                str = c21984b.qUv;
            } else {
                str = c21984b.qUu;
            }
            if (!C5046bo.isNullOrNil(str)) {
                this.rDi.setText(str);
            }
        }
        AppMethodBeat.m2505o(39860);
    }

    public final void setVisibility(int i) {
        int i2;
        AppMethodBeat.m2504i(39861);
        if (this.rDm == null || this.rDm.qUh != 1) {
            this.rDj.setVisibility(i);
        } else {
            this.rDj.setVisibility(8);
        }
        C46618a aoe = C18624c.abj().aoe("Sns_CanvasAd_DetailLink_JumpWay");
        if (aoe.isValid()) {
            i2 = C5046bo.getInt(aoe.field_value, -1);
        } else {
            i2 = -1;
        }
        if (i2 != -1 && this.rDm != null && this.rDm.coK() && C3953i.m6288YO(this.rDm.cHz)) {
            this.rDj.setVisibility(i);
        }
        this.rDi.setVisibility(i);
        if (this.rDk != null) {
            this.rDk.setVisibility(i);
        }
        if (this.rDh != null) {
            this.rDh.setVisibility(i);
        }
        if (this.rDn == null || C5046bo.isNullOrNil(this.rDn.qTD)) {
            this.rDl.setVisibility(8);
            AppMethodBeat.m2505o(39861);
            return;
        }
        this.rDl.setVisibility(i);
        AppMethodBeat.m2505o(39861);
    }
}

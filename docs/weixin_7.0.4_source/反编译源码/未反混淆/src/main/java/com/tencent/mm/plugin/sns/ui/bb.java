package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.c.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class bb {
    private String nJy = aa.gw(ah.getContext());
    private LinearLayout rDh;
    public TextView rDi;
    public TextView rDj;
    private View rDk;
    private View rDl;
    public b rDm;
    public a rDn;
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
        AppMethodBeat.i(39856);
        int[] iArr = new int[2];
        if (this.rDh != null) {
            this.rDk.getLocationInWindow(iArr);
            iArr[0] = iArr[0] + this.rDk.getMeasuredWidth();
        } else if (this.rDk != null) {
            this.rDk.getLocationInWindow(iArr);
            iArr[0] = iArr[0] + this.rDk.getMeasuredWidth();
        }
        AppMethodBeat.o(39856);
        return iArr;
    }

    public bb(View view) {
        AppMethodBeat.i(39857);
        this.view = view;
        ab.i("MicroMsg.TimeLineAdView", "adView init lan " + this.nJy);
        this.rDi = (TextView) this.view.findViewById(R.id.egc);
        this.rDj = (TextView) this.view.findViewById(R.id.egd);
        this.rDk = this.view.findViewById(R.id.eht);
        this.rDl = this.view.findViewById(R.id.ehs);
        this.rDh = (LinearLayout) this.view.findViewById(R.id.ehr);
        this.rDi.setText(" " + this.view.getResources().getString(R.string.ejb) + " ");
        AppMethodBeat.o(39857);
    }

    public final void a(OnClickListener onClickListener, OnClickListener onClickListener2) {
        AppMethodBeat.i(39858);
        this.rDj.setOnClickListener(onClickListener);
        this.rDi.setOnClickListener(onClickListener2);
        if (this.rDk != null) {
            this.rDk.setOnClickListener(onClickListener2);
        }
        if (this.rDh != null) {
            this.rDh.setOnClickListener(onClickListener2);
        }
        AppMethodBeat.o(39858);
    }

    public final void z(Object obj, Object obj2) {
        AppMethodBeat.i(39859);
        this.rDj.setTag(obj);
        this.rDi.setTag(obj2);
        if (this.rDk != null) {
            this.rDk.setTag(obj2);
        }
        if (this.rDh != null) {
            this.rDh.setTag(obj2);
        }
        AppMethodBeat.o(39859);
    }

    public final void a(b bVar, a aVar) {
        Object imageSpan;
        AppMethodBeat.i(39860);
        this.rDn = aVar;
        this.rDm = bVar;
        String str = "";
        if (bVar != null) {
            if ("zh_CN".equals(this.nJy)) {
                str = bVar.qUk;
            } else if ("zh_TW".equals(this.nJy) || "zh_HK".equals(this.nJy)) {
                str = bVar.qUm;
            } else {
                str = bVar.qUl;
            }
        }
        if (bVar != null && bo.isNullOrNil(r0)) {
            str = bVar.qUi;
        }
        Context context = this.rDj.getContext();
        if (bo.isNullOrNil(str)) {
            str = context.getString(R.string.ejh);
        }
        str = str + " ";
        final int length = str.length();
        final SpannableString spannableString = new SpannableString(str + "ad_");
        Drawable drawable;
        if (aVar == null || !aVar.coI()) {
            drawable = context.getResources().getDrawable(R.raw.album_advertise_link_icon);
            drawable.setBounds(0, 0, (int) (((double) this.rDj.getTextSize()) * 1.3d), (int) (((double) this.rDj.getTextSize()) * 1.3d));
            imageSpan = new ImageSpan(drawable, 0);
        } else {
            drawable = context.getResources().getDrawable(R.raw.album_ad_link_tag_weapp);
            drawable.setBounds(0, 0, (int) (((double) this.rDj.getTextSize()) * 0.8d), (int) (((double) this.rDj.getTextSize()) * 0.8d));
            imageSpan = new ImageSpan(drawable, 1);
        }
        if (!bo.isNullOrNil(bVar.qUj)) {
            h.c("adId", bVar.qUj, false, 41, new f.a() {
                public final void cpu() {
                }

                public final void cmD() {
                }

                public final void YJ(String str) {
                    AppMethodBeat.i(39855);
                    if (bo.isNullOrNil(str)) {
                        AppMethodBeat.o(39855);
                        return;
                    }
                    Drawable createFromPath = Drawable.createFromPath(str);
                    if (createFromPath != null) {
                        createFromPath.setBounds(0, 0, (int) (((double) bb.this.rDj.getTextSize()) * 1.3d), (int) (((double) bb.this.rDj.getTextSize()) * 1.3d));
                        spannableString.setSpan(new ImageSpan(createFromPath, 0), length, length + 3, 33);
                        bb.this.rDj.setText(spannableString);
                    }
                    AppMethodBeat.o(39855);
                }
            });
        }
        spannableString.setSpan(imageSpan, length, length + 3, 33);
        this.rDj.setText(spannableString);
        if (aVar == null || bo.isNullOrNil(aVar.qTD)) {
            this.rDl.setVisibility(8);
        } else {
            this.rDl.setVisibility(0);
        }
        if (bVar != null) {
            if ("zh_CN".equals(this.nJy)) {
                str = bVar.qUt;
            } else if ("zh_TW".equals(this.nJy) || "zh_HK".equals(this.nJy)) {
                str = bVar.qUv;
            } else {
                str = bVar.qUu;
            }
            if (!bo.isNullOrNil(str)) {
                this.rDi.setText(str);
            }
        }
        AppMethodBeat.o(39860);
    }

    public final void setVisibility(int i) {
        int i2;
        AppMethodBeat.i(39861);
        if (this.rDm == null || this.rDm.qUh != 1) {
            this.rDj.setVisibility(i);
        } else {
            this.rDj.setVisibility(8);
        }
        com.tencent.mm.storage.a aoe = c.abj().aoe("Sns_CanvasAd_DetailLink_JumpWay");
        if (aoe.isValid()) {
            i2 = bo.getInt(aoe.field_value, -1);
        } else {
            i2 = -1;
        }
        if (i2 != -1 && this.rDm != null && this.rDm.coK() && i.YO(this.rDm.cHz)) {
            this.rDj.setVisibility(i);
        }
        this.rDi.setVisibility(i);
        if (this.rDk != null) {
            this.rDk.setVisibility(i);
        }
        if (this.rDh != null) {
            this.rDh.setVisibility(i);
        }
        if (this.rDn == null || bo.isNullOrNil(this.rDn.qTD)) {
            this.rDl.setVisibility(8);
            AppMethodBeat.o(39861);
            return;
        }
        this.rDl.setVisibility(i);
        AppMethodBeat.o(39861);
    }
}

package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.d;
import com.tencent.mm.bz.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.LinkedList;
import java.util.List;

public class BizBindWxaInfoPreference extends Preference {
    private static DisplayMetrics iQY = ah.getContext().getResources().getDisplayMetrics();
    private static int iUs = a.fromDPToPix(ah.getContext(), 15);
    private static int iUt = ah.getResources().getDimensionPixelSize(R.dimen.m2);
    private d gIN;
    private TextView iDT;
    private List<WxaEntryInfo> iUl;
    private View iUm;
    private ImageView iUn;
    private TextView iUo;
    private LinearLayout iUp;
    private ViewGroup iUq;
    private View iUr;
    private OnClickListener lBl;
    private volatile boolean pkJ;
    private volatile boolean pkK;
    private OnClickListener pkL;

    static {
        AppMethodBeat.i(23305);
        AppMethodBeat.o(23305);
    }

    public BizBindWxaInfoPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(23296);
        init();
        AppMethodBeat.o(23296);
    }

    public BizBindWxaInfoPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(23297);
        init();
        AppMethodBeat.o(23297);
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(23298);
        this.iUm = view.findViewById(R.id.u2);
        this.iUn = (ImageView) view.findViewById(R.id.u3);
        this.iDT = (TextView) view.findViewById(R.id.u4);
        this.iUo = (TextView) view.findViewById(R.id.u7);
        this.iUr = view.findViewById(R.id.u6);
        this.iUp = (LinearLayout) view.findViewById(R.id.u5);
        this.iUq = (ViewGroup) view.findViewById(R.id.u1);
        this.pkJ = true;
        this.pkK = this.iUl != null;
        azx();
        super.onBindView(view);
        AppMethodBeat.o(23298);
    }

    public final void a(d dVar, List<WxaEntryInfo> list) {
        AppMethodBeat.i(23299);
        this.pkK = true;
        this.gIN = dVar;
        if (this.iUl == null) {
            this.iUl = new LinkedList();
        } else {
            this.iUl.clear();
        }
        if (!(list == null || list.isEmpty())) {
            this.iUl.addAll(list);
        }
        azx();
        AppMethodBeat.o(23299);
    }

    private void init() {
        AppMethodBeat.i(23300);
        this.lBl = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(23294);
                Object tag = view.getTag();
                if (tag == null || !(tag instanceof String)) {
                    AppMethodBeat.o(23294);
                    return;
                }
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = 1020;
                appBrandStatObject.cst = BizBindWxaInfoPreference.this.gIN.field_username;
                ((e) g.K(e.class)).a(BizBindWxaInfoPreference.this.mContext, (String) tag, null, 0, 0, null, appBrandStatObject, BizBindWxaInfoPreference.this.gIN.field_appId);
                AppMethodBeat.o(23294);
            }
        };
        this.pkL = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(23295);
                ((com.tencent.mm.plugin.appbrand.service.g) g.K(com.tencent.mm.plugin.appbrand.service.g.class)).a(BizBindWxaInfoPreference.this.mContext, BizBindWxaInfoPreference.this.gIN.field_username, BizBindWxaInfoPreference.this.gIN.field_appId, BizBindWxaInfoPreference.this.iUl);
                AppMethodBeat.o(23295);
            }
        };
        AppMethodBeat.o(23300);
    }

    private void azx() {
        AppMethodBeat.i(23301);
        if (!this.pkJ || this.iUl == null) {
            AppMethodBeat.o(23301);
        } else if (this.pkK) {
            WxaEntryInfo wxaEntryInfo;
            this.pkK = false;
            if (this.iUl.isEmpty()) {
                wxaEntryInfo = null;
            } else {
                wxaEntryInfo = (WxaEntryInfo) this.iUl.get(0);
            }
            if (wxaEntryInfo != null) {
                a(wxaEntryInfo, this.iUn, this.iDT);
            }
            this.iUo.setText(this.mContext.getString(R.string.au3, new Object[]{Integer.valueOf(this.iUl.size())}));
            cB(this.iUl);
            if (this.iUl.size() == 1) {
                this.iUm.setVisibility(0);
                this.iUq.setTag(((WxaEntryInfo) this.iUl.get(0)).username);
                this.iUq.setOnClickListener(this.lBl);
                AppMethodBeat.o(23301);
                return;
            }
            this.iUm.setVisibility(8);
            this.iUq.setTag(null);
            this.iUq.setOnClickListener(this.pkL);
            AppMethodBeat.o(23301);
        } else {
            AppMethodBeat.o(23301);
        }
    }

    private void cB(List<WxaEntryInfo> list) {
        AppMethodBeat.i(23302);
        this.iUp.removeAllViews();
        if (list.isEmpty()) {
            AppMethodBeat.o(23302);
            return;
        }
        int size = list.size();
        int measuredWidth = this.iUq.getMeasuredWidth();
        if (measuredWidth == 0) {
            measuredWidth = iQY.widthPixels;
        }
        int paddingLeft = (measuredWidth - this.iUq.getPaddingLeft()) - this.iUq.getPaddingRight();
        measuredWidth = paddingLeft / (iUt + iUs);
        if (measuredWidth > size) {
            this.iUr.setVisibility(8);
        } else {
            this.iUr.setVisibility(0);
            measuredWidth = (paddingLeft - this.iUr.getMeasuredWidth()) / (iUt + iUs);
        }
        paddingLeft = Math.min(measuredWidth, size);
        if (paddingLeft > 1) {
            for (size = 0; size < paddingLeft; size++) {
                a((WxaEntryInfo) list.get(size));
            }
        }
        ab.i("MicroMsg.BizBindWxaInfoPreference", "attachItemToContainer(size : %s)", Integer.valueOf(list.size()));
        AppMethodBeat.o(23302);
    }

    private void a(WxaEntryInfo wxaEntryInfo) {
        AppMethodBeat.i(23303);
        ImageView imageView = new ImageView(this.mContext);
        imageView.setLayoutParams(new LayoutParams(iUt + iUs, iUt));
        imageView.setPadding(0, 0, iUs, 0);
        this.iUp.addView(imageView);
        a(wxaEntryInfo, imageView, null);
        AppMethodBeat.o(23303);
    }

    private static void a(WxaEntryInfo wxaEntryInfo, ImageView imageView, TextView textView) {
        AppMethodBeat.i(23304);
        if (wxaEntryInfo == null) {
            AppMethodBeat.o(23304);
            return;
        }
        String str = wxaEntryInfo.username;
        if (imageView != null) {
            imageView.setTag(str);
            b.abR().a(imageView, wxaEntryInfo.iconUrl, com.tencent.mm.modelappbrand.a.a.abQ(), f.fqH);
        }
        if (textView != null) {
            textView.setText(bo.nullAsNil(wxaEntryInfo.title));
        }
        AppMethodBeat.o(23304);
    }
}

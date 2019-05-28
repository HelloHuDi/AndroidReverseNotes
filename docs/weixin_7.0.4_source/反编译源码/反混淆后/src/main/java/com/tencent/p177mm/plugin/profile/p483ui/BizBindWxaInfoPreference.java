package com.tencent.p177mm.plugin.profile.p483ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelappbrand.p873a.C32804a;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.modelappbrand.p873a.C42201f;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.service.C19731g;
import com.tencent.p177mm.plugin.appbrand.service.C45691e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.profile.ui.BizBindWxaInfoPreference */
public class BizBindWxaInfoPreference extends Preference {
    private static DisplayMetrics iQY = C4996ah.getContext().getResources().getDisplayMetrics();
    private static int iUs = C1338a.fromDPToPix(C4996ah.getContext(), 15);
    private static int iUt = C4996ah.getResources().getDimensionPixelSize(C25738R.dimen.f9977m2);
    private C16527d gIN;
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

    /* renamed from: com.tencent.mm.plugin.profile.ui.BizBindWxaInfoPreference$1 */
    class C346981 implements OnClickListener {
        C346981() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(23294);
            Object tag = view.getTag();
            if (tag == null || !(tag instanceof String)) {
                AppMethodBeat.m2505o(23294);
                return;
            }
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = 1020;
            appBrandStatObject.cst = BizBindWxaInfoPreference.this.gIN.field_username;
            ((C45691e) C1720g.m3528K(C45691e.class)).mo68046a(BizBindWxaInfoPreference.this.mContext, (String) tag, null, 0, 0, null, appBrandStatObject, BizBindWxaInfoPreference.this.gIN.field_appId);
            AppMethodBeat.m2505o(23294);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.BizBindWxaInfoPreference$2 */
    class C395042 implements OnClickListener {
        C395042() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(23295);
            ((C19731g) C1720g.m3528K(C19731g.class)).mo34963a(BizBindWxaInfoPreference.this.mContext, BizBindWxaInfoPreference.this.gIN.field_username, BizBindWxaInfoPreference.this.gIN.field_appId, BizBindWxaInfoPreference.this.iUl);
            AppMethodBeat.m2505o(23295);
        }
    }

    static {
        AppMethodBeat.m2504i(23305);
        AppMethodBeat.m2505o(23305);
    }

    public BizBindWxaInfoPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(23296);
        init();
        AppMethodBeat.m2505o(23296);
    }

    public BizBindWxaInfoPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(23297);
        init();
        AppMethodBeat.m2505o(23297);
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(23298);
        this.iUm = view.findViewById(2131821312);
        this.iUn = (ImageView) view.findViewById(2131821313);
        this.iDT = (TextView) view.findViewById(2131821314);
        this.iUo = (TextView) view.findViewById(2131821317);
        this.iUr = view.findViewById(2131821316);
        this.iUp = (LinearLayout) view.findViewById(2131821315);
        this.iUq = (ViewGroup) view.findViewById(2131821311);
        this.pkJ = true;
        this.pkK = this.iUl != null;
        azx();
        super.onBindView(view);
        AppMethodBeat.m2505o(23298);
    }

    /* renamed from: a */
    public final void mo74082a(C16527d c16527d, List<WxaEntryInfo> list) {
        AppMethodBeat.m2504i(23299);
        this.pkK = true;
        this.gIN = c16527d;
        if (this.iUl == null) {
            this.iUl = new LinkedList();
        } else {
            this.iUl.clear();
        }
        if (!(list == null || list.isEmpty())) {
            this.iUl.addAll(list);
        }
        azx();
        AppMethodBeat.m2505o(23299);
    }

    private void init() {
        AppMethodBeat.m2504i(23300);
        this.lBl = new C346981();
        this.pkL = new C395042();
        AppMethodBeat.m2505o(23300);
    }

    private void azx() {
        AppMethodBeat.m2504i(23301);
        if (!this.pkJ || this.iUl == null) {
            AppMethodBeat.m2505o(23301);
        } else if (this.pkK) {
            WxaEntryInfo wxaEntryInfo;
            this.pkK = false;
            if (this.iUl.isEmpty()) {
                wxaEntryInfo = null;
            } else {
                wxaEntryInfo = (WxaEntryInfo) this.iUl.get(0);
            }
            if (wxaEntryInfo != null) {
                BizBindWxaInfoPreference.m86101a(wxaEntryInfo, this.iUn, this.iDT);
            }
            this.iUo.setText(this.mContext.getString(C25738R.string.au3, new Object[]{Integer.valueOf(this.iUl.size())}));
            m86103cB(this.iUl);
            if (this.iUl.size() == 1) {
                this.iUm.setVisibility(0);
                this.iUq.setTag(((WxaEntryInfo) this.iUl.get(0)).username);
                this.iUq.setOnClickListener(this.lBl);
                AppMethodBeat.m2505o(23301);
                return;
            }
            this.iUm.setVisibility(8);
            this.iUq.setTag(null);
            this.iUq.setOnClickListener(this.pkL);
            AppMethodBeat.m2505o(23301);
        } else {
            AppMethodBeat.m2505o(23301);
        }
    }

    /* renamed from: cB */
    private void m86103cB(List<WxaEntryInfo> list) {
        AppMethodBeat.m2504i(23302);
        this.iUp.removeAllViews();
        if (list.isEmpty()) {
            AppMethodBeat.m2505o(23302);
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
                m86100a((WxaEntryInfo) list.get(size));
            }
        }
        C4990ab.m7417i("MicroMsg.BizBindWxaInfoPreference", "attachItemToContainer(size : %s)", Integer.valueOf(list.size()));
        AppMethodBeat.m2505o(23302);
    }

    /* renamed from: a */
    private void m86100a(WxaEntryInfo wxaEntryInfo) {
        AppMethodBeat.m2504i(23303);
        ImageView imageView = new ImageView(this.mContext);
        imageView.setLayoutParams(new LayoutParams(iUt + iUs, iUt));
        imageView.setPadding(0, 0, iUs, 0);
        this.iUp.addView(imageView);
        BizBindWxaInfoPreference.m86101a(wxaEntryInfo, imageView, null);
        AppMethodBeat.m2505o(23303);
    }

    /* renamed from: a */
    private static void m86101a(WxaEntryInfo wxaEntryInfo, ImageView imageView, TextView textView) {
        AppMethodBeat.m2504i(23304);
        if (wxaEntryInfo == null) {
            AppMethodBeat.m2505o(23304);
            return;
        }
        String str = wxaEntryInfo.username;
        if (imageView != null) {
            imageView.setTag(str);
            C37926b.abR().mo60683a(imageView, wxaEntryInfo.iconUrl, C32804a.abQ(), C42201f.fqH);
        }
        if (textView != null) {
            textView.setText(C5046bo.nullAsNil(wxaEntryInfo.title));
        }
        AppMethodBeat.m2505o(23304);
    }
}

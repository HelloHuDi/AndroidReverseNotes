package com.tencent.p177mm.pluginsdk.p597ui.preference;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C37772no;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.preference.C46634g;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.widget.QDisFadeImageView;
import com.tencent.p177mm.plugin.sns.p1024b.C21877n;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C44222az;
import com.tencent.p177mm.storage.C7616ad;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.pluginsdk.ui.preference.SnsPreference */
public final class SnsPreference extends Preference implements C46634g {
    private MMActivity crP;
    private int lXY;
    private List<bau> list;
    private String mTitle;
    private View omq;
    private C44222az qFT;
    private QDisFadeImageView vro;
    private QDisFadeImageView vrp;
    private QDisFadeImageView vrq;
    private QDisFadeImageView vrr;
    private ImageView vrs;
    private ImageView vrt;
    private ImageView vru;
    private ImageView vrv;
    private C30138a vrw;

    /* renamed from: com.tencent.mm.pluginsdk.ui.preference.SnsPreference$a */
    static class C30138a extends ColorDrawable {
        public C30138a() {
            super(-7829368);
        }
    }

    public SnsPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        AppMethodBeat.m2504i(28117);
        this.crP = (MMActivity) context;
        AppMethodBeat.m2505o(28117);
    }

    public SnsPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(28118);
        this.mTitle = "";
        this.vro = null;
        this.vrp = null;
        this.vrq = null;
        this.vrr = null;
        this.vrs = null;
        this.vrt = null;
        this.vru = null;
        this.vrv = null;
        this.lXY = 255;
        this.list = new LinkedList();
        this.vrw = new C30138a();
        this.crP = (MMActivity) context;
        this.mTitle = context.getString(C25738R.string.b0b);
        setLayoutResource(2130970127);
        AppMethodBeat.m2505o(28118);
    }

    private void dld() {
        ImageView imageView;
        int i = 0;
        AppMethodBeat.m2504i(28119);
        if (this.vro != null) {
            this.vro.setImageResource(C25738R.color.a69);
            this.vro.setVisibility(4);
        }
        if (this.vrp != null) {
            this.vrp.setImageResource(C25738R.color.a69);
            this.vrp.setVisibility(4);
        }
        if (this.vrq != null) {
            this.vrq.setImageResource(C25738R.color.a69);
            this.vrq.setVisibility(4);
        }
        if (this.vrr != null) {
            this.vrr.setImageResource(C25738R.color.a69);
            this.vrr.setVisibility(4);
        }
        if (this.vro != null && this.list.size() > 0) {
            int i2;
            ImageView imageView2;
            this.vro.setVisibility(0);
            if (C1445f.m3070Mn()) {
                C21877n.qFx.mo37455b((bau) this.list.get(0), this.vro, this.crP.hashCode(), this.qFT);
                imageView = this.vrs;
                if (((bau) this.list.get(0)).jCt == 6) {
                    i2 = 0;
                    imageView.setVisibility(i2);
                } else {
                    imageView2 = imageView;
                }
            } else {
                this.vro.setImageResource(C25738R.drawable.ak9);
                imageView2 = this.vrs;
            }
            i2 = 8;
            imageView = imageView2;
            imageView.setVisibility(i2);
        }
        if (this.vrp != null && this.list.size() >= 2) {
            this.vrp.setVisibility(0);
            if (C1445f.m3070Mn()) {
                C21877n.qFx.mo37455b((bau) this.list.get(1), this.vrp, this.crP.hashCode(), this.qFT);
                this.vrt.setVisibility(((bau) this.list.get(1)).jCt == 6 ? 0 : 8);
            } else {
                this.vrp.setImageResource(C25738R.drawable.ak9);
            }
        }
        if (this.vrq != null && this.list.size() >= 3) {
            this.vrq.setVisibility(0);
            if (C1445f.m3070Mn()) {
                C21877n.qFx.mo37455b((bau) this.list.get(2), this.vrq, this.crP.hashCode(), this.qFT);
                this.vru.setVisibility(((bau) this.list.get(2)).jCt == 6 ? 0 : 8);
            } else {
                this.vrq.setImageResource(C25738R.drawable.ak9);
            }
        }
        if (this.vrr != null && this.list.size() >= 4) {
            this.vrr.setVisibility(0);
            if (C1445f.m3070Mn()) {
                C21877n.qFx.mo37455b((bau) this.list.get(3), this.vrr, this.crP.hashCode(), this.qFT);
                imageView = this.vrv;
                if (((bau) this.list.get(3)).jCt != 6) {
                    i = 8;
                }
                imageView.setVisibility(i);
            } else {
                this.vrr.setImageResource(C25738R.drawable.ak9);
                AppMethodBeat.m2505o(28119);
                return;
            }
        }
        AppMethodBeat.m2505o(28119);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(28120);
        if (this.omq == null) {
            View onCreateView = super.onCreateView(viewGroup);
            LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
            ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
            viewGroup2.removeAllViews();
            layoutInflater.inflate(2130970144, viewGroup2);
            this.omq = onCreateView;
        }
        View view = this.omq;
        AppMethodBeat.m2505o(28120);
        return view;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(28121);
        super.onBindView(view);
        this.vro = (QDisFadeImageView) view.findViewById(2131826024);
        this.vro.setAlpha(this.lXY);
        this.vro.setImageDrawable(this.vrw);
        this.vrp = (QDisFadeImageView) view.findViewById(2131826026);
        this.vrp.setAlpha(this.lXY);
        this.vrp.setImageDrawable(this.vrw);
        this.vrq = (QDisFadeImageView) view.findViewById(2131826028);
        this.vrq.setAlpha(this.lXY);
        this.vrq.setImageDrawable(this.vrw);
        this.vrr = (QDisFadeImageView) view.findViewById(2131826030);
        this.vrr.setAlpha(this.lXY);
        this.vrr.setImageDrawable(this.vrw);
        TextView textView = (TextView) view.findViewById(2131826014);
        if (!C5046bo.isNullOrNil(this.mTitle)) {
            textView.setText(this.mTitle);
            LayoutParams layoutParams = textView.getLayoutParams();
            layoutParams.width = C1338a.m2856al(this.mContext, C25738R.dimen.f9862i8);
            textView.setLayoutParams(layoutParams);
        }
        this.vrs = (ImageView) view.findViewById(2131826025);
        this.vrt = (ImageView) view.findViewById(2131826027);
        this.vru = (ImageView) view.findViewById(2131826029);
        this.vrv = (ImageView) view.findViewById(2131826031);
        this.vrs.setVisibility(8);
        this.vrt.setVisibility(8);
        this.vru.setVisibility(8);
        this.vrv.setVisibility(8);
        dld();
        if (view == null || this.list == null) {
            AppMethodBeat.m2505o(28121);
            return;
        }
        view.setContentDescription(this.mContext.getString(C25738R.string.deu, new Object[]{Integer.valueOf(this.list.size())}));
        AppMethodBeat.m2505o(28121);
    }

    public final void ajO(String str) {
        AppMethodBeat.m2504i(28122);
        if (str == null) {
            AppMethodBeat.m2505o(28122);
            return;
        }
        this.list.clear();
        C9638aw.m17190ZK();
        C7616ad aoO = C18628c.m29078XM().aoO(str);
        if (aoO != null && ((int) aoO.ewQ) > 0 && C7486a.m12942jh(aoO.field_type)) {
            this.qFT = C44222az.xYQ;
        } else if (str.equals(C1853r.m3846Yz())) {
            this.qFT = C44222az.xYQ;
        } else {
            this.qFT = C44222az.xYR;
        }
        C37772no c37772no = new C37772no();
        c37772no.cJO.username = str;
        C4879a.xxA.mo10055m(c37772no);
        if (c37772no.cJP.cJQ != null) {
            this.list.add(c37772no.cJP.cJQ);
        }
        if (c37772no.cJP.cJR != null) {
            this.list.add(c37772no.cJP.cJR);
        }
        if (c37772no.cJP.cJS != null) {
            this.list.add(c37772no.cJP.cJS);
        }
        if (c37772no.cJP.cJT != null) {
            this.list.add(c37772no.cJP.cJT);
        }
        dld();
        AppMethodBeat.m2505o(28122);
    }
}

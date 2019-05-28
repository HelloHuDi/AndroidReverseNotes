package com.tencent.p177mm.plugin.exdevice.p393ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.base.NoMeasuredTextView;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.service.C45691e;
import com.tencent.p177mm.plugin.exdevice.p390f.p391a.C11643e;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.p955a.C34028c;
import com.tencent.p177mm.plugin.sport.p1302a.C22162d;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.C44146mq;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.exdevice.ui.a */
final class C11726a extends BaseAdapter {
    String igi;
    C34067c lBs;
    private boolean lBt;
    boolean lBu;
    int lBv;
    int lBw;
    ArrayList<C34028c> lBx;
    List<C44146mq> lBy;
    private View lBz;
    private String mAppName;
    private Context mContext;

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.a$e */
    class C3001e {
        ImageView kEn;
        View lBB;
        NoMeasuredTextView lBF;
        TextView lBG;

        C3001e() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.a$b */
    class C11725b {
        TextView jao;
        View lBC;

        C11725b() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.a$d */
    class C11727d {
        Button lBE;

        C11727d() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.a$1 */
    class C117281 implements OnClickListener {
        C117281() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(20002);
            Intent intent = new Intent();
            intent.putExtra("Contact_User", C11726a.this.igi);
            C25985d.m41467b(C11726a.this.mContext, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
            AppMethodBeat.m2505o(20002);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.a$c */
    class C11729c {
        TextView jao;
        View lBB;
        View lBD;
        ImageView lyB;

        C11729c() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.a$f */
    class C11730f {
        ImageView kEn;

        C11730f() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.a$4 */
    class C117324 implements OnClickListener {
        C117324() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(20005);
            C22162d.m33785kT(8);
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = FilterEnum4Shaka.MIC_WEISHI_BAIXIANG;
            ((C45691e) C1720g.m3528K(C45691e.class)).mo68045a(C11726a.this.mContext, null, "wx3fca79fc5715b185", 0, 0, "", appBrandStatObject);
            AppMethodBeat.m2505o(20005);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.a$5 */
    class C117335 implements OnClickListener {
        C117335() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(20006);
            if (C11726a.this.lBs != null) {
                C34067c c = C11726a.this.lBs;
                C11726a.this.igi;
                c.bpS();
            }
            AppMethodBeat.m2505o(20006);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.a$3 */
    class C117343 implements OnClickListener {
        C117343() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(20004);
            if (C11726a.this.lBs != null) {
                C34067c c = C11726a.this.lBs;
                C11726a.this.igi;
                c.bpR();
            }
            AppMethodBeat.m2505o(20004);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.a$a */
    class C11735a {
        TextView jao;
        View lBB;
        ImageView lyB;

        C11735a() {
        }
    }

    public C11726a(Context context, String str, boolean z, String str2) {
        this.mContext = context;
        this.igi = str2;
        this.lBt = z;
        this.mAppName = str;
    }

    public final int getCount() {
        if (this.lBt) {
            return (this.lBv + 5) + this.lBw;
        }
        return 2;
    }

    public final int getViewTypeCount() {
        return 8;
    }

    public final Object getItem(int i) {
        AppMethodBeat.m2504i(20007);
        Integer valueOf = Integer.valueOf(i);
        AppMethodBeat.m2505o(20007);
        return valueOf;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getItemViewType(int i) {
        if (this.lBt) {
            if (i == 0) {
                return 0;
            }
            if (i == 1) {
                return 6;
            }
            if (i > 1 && i <= this.lBv + 1) {
                return 1;
            }
            if (i == this.lBv + 2) {
                return 2;
            }
            if (i == this.lBv + 3) {
                return 5;
            }
            if (i <= this.lBv + 3 || i > (this.lBv + 3) + this.lBw) {
                return i == (this.lBv + this.lBw) + 4 ? 7 : 5;
            } else {
                return 3;
            }
        } else if (i == 0) {
            return 0;
        } else {
            return 4;
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C11725b c11725b;
        C11725b c11725b2;
        C11729c c11729c;
        C11735a c11735a;
        C11727d c11727d;
        C3001e c3001e;
        C11730f c11730f;
        AppMethodBeat.m2504i(20008);
        int itemViewType = getItemViewType(i);
        if (view != null) {
            switch (itemViewType) {
                case 0:
                    c11725b = null;
                    c11725b2 = null;
                    c11729c = null;
                    c11735a = null;
                    c11727d = null;
                    c3001e = null;
                    c11730f = (C11730f) view.getTag();
                    break;
                case 1:
                    c11725b = null;
                    c11725b2 = null;
                    c11729c = null;
                    c11735a = null;
                    c11727d = null;
                    c3001e = (C3001e) view.getTag();
                    c11730f = null;
                    break;
                case 2:
                    c11725b = null;
                    c11725b2 = null;
                    c11729c = null;
                    c11735a = (C11735a) view.getTag();
                    c11727d = null;
                    c3001e = null;
                    c11730f = null;
                    break;
                case 3:
                    c11725b = null;
                    c11725b2 = null;
                    c11729c = (C11729c) view.getTag();
                    c11735a = null;
                    c11727d = null;
                    c3001e = null;
                    c11730f = null;
                    break;
                case 4:
                    c11725b = null;
                    c11725b2 = null;
                    c11729c = null;
                    c11735a = null;
                    c11727d = (C11727d) view.getTag();
                    c3001e = null;
                    c11730f = null;
                    break;
                case 5:
                    view.getTag();
                    c11725b = null;
                    c11725b2 = null;
                    c11729c = null;
                    c11735a = null;
                    c11727d = null;
                    c3001e = null;
                    c11730f = null;
                    break;
                case 6:
                    c11725b = null;
                    c11725b2 = (C11725b) view.getTag();
                    c11729c = null;
                    c11735a = null;
                    c11727d = null;
                    c3001e = null;
                    c11730f = null;
                    break;
                case 7:
                    c11725b = (C11725b) view.getTag();
                    c11725b2 = null;
                    c11729c = null;
                    c11735a = null;
                    c11727d = null;
                    c3001e = null;
                    c11730f = null;
                    break;
                default:
                    c11725b = null;
                    c11725b2 = null;
                    c11729c = null;
                    c11735a = null;
                    c11727d = null;
                    c3001e = null;
                    c11730f = null;
                    break;
            }
        }
        switch (itemViewType) {
            case 0:
                if (this.lBz == null) {
                    this.lBz = LayoutInflater.from(this.mContext).inflate(2130969432, viewGroup, false);
                }
                view = this.lBz;
                c11730f = new C11730f();
                c11730f.kEn = (ImageView) view.findViewById(2131823698);
                view.setTag(c11730f);
                c11725b = null;
                c11725b2 = null;
                c11729c = null;
                c11735a = null;
                c11727d = null;
                c3001e = null;
                break;
            case 1:
                view = LayoutInflater.from(this.mContext).inflate(2130969431, viewGroup, false);
                c3001e = new C3001e();
                c3001e.lBF = (NoMeasuredTextView) view.findViewById(2131823689);
                c3001e.lBG = (TextView) view.findViewById(2131823690);
                c3001e.kEn = (ImageView) view.findViewById(2131823686);
                c3001e.lBB = view.findViewById(2131823685);
                c3001e.lBF.setTextSize(0, this.mContext.getResources().getDimension(C25738R.dimen.f9835h9));
                c3001e.lBF.setTextColor(this.mContext.getResources().getColor(C25738R.color.f11976nq));
                c3001e.lBF.setSingleLine(true);
                c3001e.lBF.setShouldEllipsize(true);
                view.setTag(c3001e);
                c11725b = null;
                c11725b2 = null;
                c11729c = null;
                c11735a = null;
                c11727d = null;
                c11730f = null;
                break;
            case 2:
                view = LayoutInflater.from(this.mContext).inflate(2130969427, viewGroup, false);
                c11735a = new C11735a();
                c11735a.jao = (TextView) view.findViewById(2131823672);
                c11735a.lBB = view.findViewById(2131823668);
                c11735a.lyB = (ImageView) view.findViewById(2131823669);
                view.setTag(c11735a);
                c11725b = null;
                c11725b2 = null;
                c11729c = null;
                c11727d = null;
                c3001e = null;
                c11730f = null;
                break;
            case 3:
                view = LayoutInflater.from(this.mContext).inflate(2130969427, viewGroup, false);
                c11729c = new C11729c();
                c11729c.jao = (TextView) view.findViewById(2131823672);
                c11729c.lBB = view.findViewById(2131823668);
                c11729c.lyB = (ImageView) view.findViewById(2131823669);
                c11729c.lBD = view.findViewById(2131823674);
                view.setTag(c11729c);
                c11725b = null;
                c11725b2 = null;
                c11735a = null;
                c11727d = null;
                c3001e = null;
                c11730f = null;
                break;
            case 4:
                view = LayoutInflater.from(this.mContext).inflate(2130969430, viewGroup, false);
                c11727d = new C11727d();
                c11727d.lBE = (Button) view.findViewById(2131823683);
                view.setTag(c11727d);
                c11725b = null;
                c11725b2 = null;
                c11729c = null;
                c11735a = null;
                c3001e = null;
                c11730f = null;
                break;
            case 5:
                view = LayoutInflater.from(this.mContext).inflate(2130969429, viewGroup, false);
                view.setTag(new C11725b());
                c11725b = null;
                c11725b2 = null;
                c11729c = null;
                c11735a = null;
                c11727d = null;
                c3001e = null;
                c11730f = null;
                break;
            case 6:
                view = LayoutInflater.from(this.mContext).inflate(2130969429, viewGroup, false);
                c11725b2 = new C11725b();
                c11725b2.jao = (TextView) view.findViewById(2131823680);
                view.setTag(c11725b2);
                c11725b = null;
                c11729c = null;
                c11735a = null;
                c11727d = null;
                c3001e = null;
                c11730f = null;
                break;
            case 7:
                view = LayoutInflater.from(this.mContext).inflate(2130969429, viewGroup, false);
                C11725b c11725b3 = new C11725b();
                c11725b3.lBC = view.findViewById(2131823678);
                view.setTag(c11725b3);
                c11725b = c11725b3;
                c11725b2 = null;
                c11729c = null;
                c11735a = null;
                c11727d = null;
                c3001e = null;
                c11730f = null;
                break;
            default:
                c11725b = null;
                c11725b2 = null;
                c11729c = null;
                c11735a = null;
                c11727d = null;
                c3001e = null;
                c11730f = null;
                break;
        }
        switch (itemViewType) {
            case 0:
                C40460b.m69438s(c11730f.kEn, this.igi);
                c11730f.kEn.setOnClickListener(new C117281());
                break;
            case 1:
                if (i - 2 >= 0 && !C5046bo.m7548ek(this.lBx)) {
                    C34028c c34028c = (C34028c) this.lBx.get(i - 2);
                    if (c34028c != null) {
                        int i2 = c34028c.field_step;
                        final String str = c34028c.field_username;
                        if (c34028c.field_step >= Downloads.MIN_WAIT_FOR_NETWORK) {
                            c3001e.lBG.setTextColor(this.mContext.getResources().getColor(C25738R.color.f11975np));
                        } else {
                            c3001e.lBG.setTextColor(this.mContext.getResources().getColor(C25738R.color.f11974no));
                        }
                        c3001e.lBF.setText(C44089j.m79293b(this.mContext, C1854s.m3866mJ(str), c3001e.lBF.getTextSize()));
                        c3001e.lBG.setText(String.valueOf(i2));
                        C40460b.m69437r(c3001e.kEn, str);
                        c3001e.lBB.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.m2504i(20003);
                                Context b = C11726a.this.mContext;
                                Intent intent = new Intent(b, ExdeviceProfileUI.class);
                                intent.putExtra("username", str);
                                b.startActivity(intent);
                                AppMethodBeat.m2505o(20003);
                            }
                        });
                        break;
                    }
                }
                break;
            case 2:
                c11735a.jao.setText(this.mContext.getResources().getText(C25738R.string.bh6));
                c11735a.lyB.setImageResource(C1318a.device_profile_ui_add_followers_logo);
                c11735a.lBB.setOnClickListener(new C117343());
                break;
            case 3:
                if ((i - this.lBv) - 4 >= 0 && !C5046bo.m7548ek(this.lBy)) {
                    C44146mq c44146mq = (C44146mq) this.lBy.get((i - this.lBv) - 4);
                    if (c44146mq != null) {
                        String str2 = c44146mq.title;
                        String str3 = c44146mq.cIY;
                        c11729c.jao.setText(str2);
                        if ((i - this.lBv) - 4 != this.lBw - 1) {
                            c11729c.lBD.setVisibility(0);
                        }
                        C11643e.m19456a(this.mContext, c11729c.lyB, str3);
                        c11729c.lBB.setOnClickListener(new C117324());
                        break;
                    }
                }
                break;
            case 4:
                if (!this.lBu) {
                    C9638aw.m17190ZK();
                    if (C18628c.m29078XM().aoJ(this.igi)) {
                        c11727d.lBE.setVisibility(0);
                        c11727d.lBE.setOnClickListener(new C117335());
                        break;
                    }
                }
                c11727d.lBE.setVisibility(4);
                break;
            case 6:
                c11725b2.jao.setText(this.mContext.getString(C25738R.string.bhe));
                break;
            case 7:
                c11725b.lBC.setVisibility(0);
                break;
        }
        AppMethodBeat.m2505o(20008);
        return view;
    }
}

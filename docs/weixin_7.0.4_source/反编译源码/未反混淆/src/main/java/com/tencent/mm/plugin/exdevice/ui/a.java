package com.tencent.mm.plugin.exdevice.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.protocal.protobuf.mq;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.ArrayList;
import java.util.List;

final class a extends BaseAdapter {
    String igi;
    c lBs;
    private boolean lBt;
    boolean lBu;
    int lBv;
    int lBw;
    ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.c> lBx;
    List<mq> lBy;
    private View lBz;
    private String mAppName;
    private Context mContext;

    class e {
        ImageView kEn;
        View lBB;
        NoMeasuredTextView lBF;
        TextView lBG;

        e() {
        }
    }

    class b {
        TextView jao;
        View lBC;

        b() {
        }
    }

    class d {
        Button lBE;

        d() {
        }
    }

    class c {
        TextView jao;
        View lBB;
        View lBD;
        ImageView lyB;

        c() {
        }
    }

    class f {
        ImageView kEn;

        f() {
        }
    }

    class a {
        TextView jao;
        View lBB;
        ImageView lyB;

        a() {
        }
    }

    public a(Context context, String str, boolean z, String str2) {
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
        AppMethodBeat.i(20007);
        Integer valueOf = Integer.valueOf(i);
        AppMethodBeat.o(20007);
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
        b bVar;
        b bVar2;
        c cVar;
        a aVar;
        d dVar;
        e eVar;
        f fVar;
        AppMethodBeat.i(20008);
        int itemViewType = getItemViewType(i);
        if (view != null) {
            switch (itemViewType) {
                case 0:
                    bVar = null;
                    bVar2 = null;
                    cVar = null;
                    aVar = null;
                    dVar = null;
                    eVar = null;
                    fVar = (f) view.getTag();
                    break;
                case 1:
                    bVar = null;
                    bVar2 = null;
                    cVar = null;
                    aVar = null;
                    dVar = null;
                    eVar = (e) view.getTag();
                    fVar = null;
                    break;
                case 2:
                    bVar = null;
                    bVar2 = null;
                    cVar = null;
                    aVar = (a) view.getTag();
                    dVar = null;
                    eVar = null;
                    fVar = null;
                    break;
                case 3:
                    bVar = null;
                    bVar2 = null;
                    cVar = (c) view.getTag();
                    aVar = null;
                    dVar = null;
                    eVar = null;
                    fVar = null;
                    break;
                case 4:
                    bVar = null;
                    bVar2 = null;
                    cVar = null;
                    aVar = null;
                    dVar = (d) view.getTag();
                    eVar = null;
                    fVar = null;
                    break;
                case 5:
                    view.getTag();
                    bVar = null;
                    bVar2 = null;
                    cVar = null;
                    aVar = null;
                    dVar = null;
                    eVar = null;
                    fVar = null;
                    break;
                case 6:
                    bVar = null;
                    bVar2 = (b) view.getTag();
                    cVar = null;
                    aVar = null;
                    dVar = null;
                    eVar = null;
                    fVar = null;
                    break;
                case 7:
                    bVar = (b) view.getTag();
                    bVar2 = null;
                    cVar = null;
                    aVar = null;
                    dVar = null;
                    eVar = null;
                    fVar = null;
                    break;
                default:
                    bVar = null;
                    bVar2 = null;
                    cVar = null;
                    aVar = null;
                    dVar = null;
                    eVar = null;
                    fVar = null;
                    break;
            }
        }
        switch (itemViewType) {
            case 0:
                if (this.lBz == null) {
                    this.lBz = LayoutInflater.from(this.mContext).inflate(R.layout.wd, viewGroup, false);
                }
                view = this.lBz;
                fVar = new f();
                fVar.kEn = (ImageView) view.findViewById(R.id.bk9);
                view.setTag(fVar);
                bVar = null;
                bVar2 = null;
                cVar = null;
                aVar = null;
                dVar = null;
                eVar = null;
                break;
            case 1:
                view = LayoutInflater.from(this.mContext).inflate(R.layout.wc, viewGroup, false);
                eVar = new e();
                eVar.lBF = (NoMeasuredTextView) view.findViewById(R.id.bk0);
                eVar.lBG = (TextView) view.findViewById(R.id.bk1);
                eVar.kEn = (ImageView) view.findViewById(R.id.bjx);
                eVar.lBB = view.findViewById(R.id.bjw);
                eVar.lBF.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.h9));
                eVar.lBF.setTextColor(this.mContext.getResources().getColor(R.color.nq));
                eVar.lBF.setSingleLine(true);
                eVar.lBF.setShouldEllipsize(true);
                view.setTag(eVar);
                bVar = null;
                bVar2 = null;
                cVar = null;
                aVar = null;
                dVar = null;
                fVar = null;
                break;
            case 2:
                view = LayoutInflater.from(this.mContext).inflate(R.layout.w9, viewGroup, false);
                aVar = new a();
                aVar.jao = (TextView) view.findViewById(R.id.bjj);
                aVar.lBB = view.findViewById(R.id.bjf);
                aVar.lyB = (ImageView) view.findViewById(R.id.bjg);
                view.setTag(aVar);
                bVar = null;
                bVar2 = null;
                cVar = null;
                dVar = null;
                eVar = null;
                fVar = null;
                break;
            case 3:
                view = LayoutInflater.from(this.mContext).inflate(R.layout.w9, viewGroup, false);
                cVar = new c();
                cVar.jao = (TextView) view.findViewById(R.id.bjj);
                cVar.lBB = view.findViewById(R.id.bjf);
                cVar.lyB = (ImageView) view.findViewById(R.id.bjg);
                cVar.lBD = view.findViewById(R.id.bjl);
                view.setTag(cVar);
                bVar = null;
                bVar2 = null;
                aVar = null;
                dVar = null;
                eVar = null;
                fVar = null;
                break;
            case 4:
                view = LayoutInflater.from(this.mContext).inflate(R.layout.wb, viewGroup, false);
                dVar = new d();
                dVar.lBE = (Button) view.findViewById(R.id.bju);
                view.setTag(dVar);
                bVar = null;
                bVar2 = null;
                cVar = null;
                aVar = null;
                eVar = null;
                fVar = null;
                break;
            case 5:
                view = LayoutInflater.from(this.mContext).inflate(R.layout.wa, viewGroup, false);
                view.setTag(new b());
                bVar = null;
                bVar2 = null;
                cVar = null;
                aVar = null;
                dVar = null;
                eVar = null;
                fVar = null;
                break;
            case 6:
                view = LayoutInflater.from(this.mContext).inflate(R.layout.wa, viewGroup, false);
                bVar2 = new b();
                bVar2.jao = (TextView) view.findViewById(R.id.bjr);
                view.setTag(bVar2);
                bVar = null;
                cVar = null;
                aVar = null;
                dVar = null;
                eVar = null;
                fVar = null;
                break;
            case 7:
                view = LayoutInflater.from(this.mContext).inflate(R.layout.wa, viewGroup, false);
                b bVar3 = new b();
                bVar3.lBC = view.findViewById(R.id.bjp);
                view.setTag(bVar3);
                bVar = bVar3;
                bVar2 = null;
                cVar = null;
                aVar = null;
                dVar = null;
                eVar = null;
                fVar = null;
                break;
            default:
                bVar = null;
                bVar2 = null;
                cVar = null;
                aVar = null;
                dVar = null;
                eVar = null;
                fVar = null;
                break;
        }
        switch (itemViewType) {
            case 0:
                com.tencent.mm.pluginsdk.ui.a.b.s(fVar.kEn, this.igi);
                fVar.kEn.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(20002);
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", a.this.igi);
                        com.tencent.mm.bp.d.b(a.this.mContext, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                        AppMethodBeat.o(20002);
                    }
                });
                break;
            case 1:
                if (i - 2 >= 0 && !bo.ek(this.lBx)) {
                    com.tencent.mm.plugin.exdevice.f.b.a.c cVar2 = (com.tencent.mm.plugin.exdevice.f.b.a.c) this.lBx.get(i - 2);
                    if (cVar2 != null) {
                        int i2 = cVar2.field_step;
                        final String str = cVar2.field_username;
                        if (cVar2.field_step >= Downloads.MIN_WAIT_FOR_NETWORK) {
                            eVar.lBG.setTextColor(this.mContext.getResources().getColor(R.color.np));
                        } else {
                            eVar.lBG.setTextColor(this.mContext.getResources().getColor(R.color.no));
                        }
                        eVar.lBF.setText(j.b(this.mContext, s.mJ(str), eVar.lBF.getTextSize()));
                        eVar.lBG.setText(String.valueOf(i2));
                        com.tencent.mm.pluginsdk.ui.a.b.r(eVar.kEn, str);
                        eVar.lBB.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(20003);
                                Context b = a.this.mContext;
                                Intent intent = new Intent(b, ExdeviceProfileUI.class);
                                intent.putExtra("username", str);
                                b.startActivity(intent);
                                AppMethodBeat.o(20003);
                            }
                        });
                        break;
                    }
                }
                break;
            case 2:
                aVar.jao.setText(this.mContext.getResources().getText(R.string.bh6));
                aVar.lyB.setImageResource(R.raw.device_profile_ui_add_followers_logo);
                aVar.lBB.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(20004);
                        if (a.this.lBs != null) {
                            c c = a.this.lBs;
                            a.this.igi;
                            c.bpR();
                        }
                        AppMethodBeat.o(20004);
                    }
                });
                break;
            case 3:
                if ((i - this.lBv) - 4 >= 0 && !bo.ek(this.lBy)) {
                    mq mqVar = (mq) this.lBy.get((i - this.lBv) - 4);
                    if (mqVar != null) {
                        String str2 = mqVar.title;
                        String str3 = mqVar.cIY;
                        cVar.jao.setText(str2);
                        if ((i - this.lBv) - 4 != this.lBw - 1) {
                            cVar.lBD.setVisibility(0);
                        }
                        com.tencent.mm.plugin.exdevice.f.a.e.a(this.mContext, cVar.lyB, str3);
                        cVar.lBB.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(20005);
                                com.tencent.mm.plugin.sport.a.d.kT(8);
                                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                                appBrandStatObject.scene = FilterEnum4Shaka.MIC_WEISHI_BAIXIANG;
                                ((com.tencent.mm.plugin.appbrand.service.e) g.K(com.tencent.mm.plugin.appbrand.service.e.class)).a(a.this.mContext, null, "wx3fca79fc5715b185", 0, 0, "", appBrandStatObject);
                                AppMethodBeat.o(20005);
                            }
                        });
                        break;
                    }
                }
                break;
            case 4:
                if (!this.lBu) {
                    aw.ZK();
                    if (com.tencent.mm.model.c.XM().aoJ(this.igi)) {
                        dVar.lBE.setVisibility(0);
                        dVar.lBE.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(20006);
                                if (a.this.lBs != null) {
                                    c c = a.this.lBs;
                                    a.this.igi;
                                    c.bpS();
                                }
                                AppMethodBeat.o(20006);
                            }
                        });
                        break;
                    }
                }
                dVar.lBE.setVisibility(4);
                break;
            case 6:
                bVar2.jao.setText(this.mContext.getString(R.string.bhe));
                break;
            case 7:
                bVar.lBC.setVisibility(0);
                break;
        }
        AppMethodBeat.o(20008);
        return view;
    }
}

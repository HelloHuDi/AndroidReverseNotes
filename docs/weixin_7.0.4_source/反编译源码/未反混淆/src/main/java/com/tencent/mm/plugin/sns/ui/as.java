package com.tencent.mm.plugin.sns.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aw.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.lucky.a.m;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.aao;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.widget.QFadeImageView;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SuppressLint({"UseSparseArrays"})
public final class as extends BaseAdapter {
    private String country;
    private Activity czX;
    boolean czr = false;
    String lQD = "";
    List<n> list = new ArrayList();
    private String nJy = "";
    Map<Integer, Integer> rgf = new HashMap();
    Map<Integer, Integer> rgg = new HashMap();
    int rgh = 0;
    int rgi = 0;
    String rmL = "";
    private bd rqa = null;
    private long rvA = 0;
    private long rvB = 0;
    int rvC = 0;
    protected OnClickListener rvD = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(39206);
            if (view.getTag() instanceof TimeLineObject) {
                TimeLineObject timeLineObject = (TimeLineObject) view.getTag();
                if (as.ZH(timeLineObject.Id)) {
                    h.pYm.X(10231, "1");
                    com.tencent.mm.aw.a.aic();
                } else {
                    h.pYm.X(10090, "1,0");
                    if (!(com.tencent.mm.r.a.bJ(as.this.czX) || com.tencent.mm.r.a.bH(as.this.czX))) {
                        com.tencent.mm.aw.e a = g.a(af.getAccPath(), timeLineObject, 8);
                        a.fKm = as.this.userName;
                        com.tencent.mm.aw.a.b(a);
                    }
                }
                as.this.notifyDataSetChanged();
            }
            AppMethodBeat.o(39206);
        }
    };
    private az rvs;
    Map<Integer, Integer> rvt = new HashMap();
    private f rvu;
    boolean rvv = false;
    at rvw;
    private c rvx;
    int rvy = BaseClientBuilder.API_PRIORITY_OTHER;
    int rvz = 0;
    private String userName = "";

    class e extends a {
        TextView qZb;
        MaskImageView rvS;
        View rwa;
        TextView rwb;
        MaskLinearLayout rwh;

        e() {
            super();
        }

        public final void init() {
            AppMethodBeat.i(39210);
            super.init();
            this.rvS.setVisibility(8);
            this.qZb.setVisibility(8);
            this.rwb.setVisibility(8);
            this.rwa.setVisibility(8);
            if (com.tencent.mm.bz.a.dm(as.this.czX) > 1.0f) {
                this.qZb.setMaxLines(2);
            }
            AppMethodBeat.o(39210);
        }
    }

    static abstract class f {
        OnClickListener rgo = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(39211);
                if (view.getTag() == null) {
                    AppMethodBeat.o(39211);
                    return;
                }
                f.this.rwm = (a) view.getTag();
                f.this.fw(f.this.rwm.cNE, f.this.rwm.position);
                AppMethodBeat.o(39211);
            }
        };
        OnClickListener rgp = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(39212);
                if (view.getTag() == null) {
                    AppMethodBeat.o(39212);
                    return;
                }
                f.this.rwm = (a) view.getTag();
                f.this.fw(f.this.rwm.cNE, f.this.rwm.position + 1);
                AppMethodBeat.o(39212);
            }
        };
        OnClickListener rgq = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(39213);
                if (view.getTag() == null) {
                    AppMethodBeat.o(39213);
                    return;
                }
                f.this.rwm = (a) view.getTag();
                f.this.fw(f.this.rwm.cNE, f.this.rwm.position + 2);
                AppMethodBeat.o(39213);
            }
        };
        OnClickListener rwi = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(39214);
                if (view.getTag() == null) {
                    AppMethodBeat.o(39214);
                    return;
                }
                ab.d("MicroMsg.SnsphotoAdapter", "sign click");
                f.this.rwm = (a) view.getTag();
                f.this.fx(f.this.rwm.cNE, f.this.rwm.position + 2);
                AppMethodBeat.o(39214);
            }
        };
        OnClickListener rwj = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(39215);
                if (view.getTag() == null) {
                    AppMethodBeat.o(39215);
                    return;
                }
                ab.d("MicroMsg.SnsphotoAdapter", "sign click");
                f.this.rwm = (a) view.getTag();
                f.this.Ed(f.this.rwm.cNE);
                AppMethodBeat.o(39215);
            }
        };
        OnClickListener rwk = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(39216);
                if (view.getTag() == null) {
                    AppMethodBeat.o(39216);
                    return;
                }
                ab.d("MicroMsg.SnsphotoAdapter", "snssight click");
                f.this.rwm = (a) view.getTag();
                f.this.fx(f.this.rwm.cNE, f.this.rwm.position + 2);
                AppMethodBeat.o(39216);
            }
        };
        OnLongClickListener rwl = new OnLongClickListener() {
            public final boolean onLongClick(View view) {
                AppMethodBeat.i(39217);
                if (view.getTag() == null) {
                    AppMethodBeat.o(39217);
                } else {
                    ab.d("MicroMsg.SnsphotoAdapter", "snsFailPhoto long click");
                    f.this.rwm = (a) view.getTag();
                    f.this.fy(f.this.rwm.cNE, f.this.rwm.position);
                    AppMethodBeat.o(39217);
                }
                return true;
            }
        };
        public a rwm = new a();

        public static class a {
            public int cNE;
            public int position;
        }

        public abstract void Ed(int i);

        public abstract void fw(int i, int i2);

        public abstract void fx(int i, int i2);

        public abstract void fy(int i, int i2);
    }

    class a {
        LinearLayout rgx;
        View rgy;
        View rvG;
        TextView rvH;
        TextView rvI;
        TextView rvJ;
        LinearLayout rvK;
        ImageView rvL;
        TextView rvM;
        LinearLayout rvN;
        TextView rvO;

        a() {
        }

        public void init() {
            AppMethodBeat.i(39207);
            this.rvH.setVisibility(8);
            this.rvI.setVisibility(8);
            this.rvJ.setVisibility(8);
            this.rvK.setVisibility(4);
            this.rvL.setVisibility(4);
            this.rgy.setVisibility(8);
            this.rvM.setVisibility(8);
            this.rvN.setVisibility(8);
            AppMethodBeat.o(39207);
        }
    }

    public interface c {
    }

    class b extends a {
        TextView gne;
        TextView hrg;
        ImageView rhd;
        TagImageView rvP;
        TextView rvQ;
        View rvR;

        b() {
            super();
        }

        public final void init() {
            AppMethodBeat.i(39208);
            super.init();
            this.hrg.setVisibility(8);
            this.rvP.setVisibility(8);
            this.rhd.setVisibility(8);
            this.gne.setVisibility(8);
            this.rvQ.setVisibility(8);
            AppMethodBeat.o(39208);
        }
    }

    class d extends a {
        TextView qZb;
        MaskImageView rvS;
        QFadeImageView rvT;
        QFadeImageView rvU;
        QFadeImageView rvV;
        TextView rvW;
        TextView rvX;
        TextView rvY;
        TextView rvZ;
        View rwa;
        TextView rwb;
        TextView rwc;
        TextView rwd;
        TextView rwe;
        TextView rwf;
        TextView rwg;
        MaskLinearLayout rwh;

        d() {
            super();
        }

        public final void init() {
            AppMethodBeat.i(39209);
            super.init();
            this.rvS.setVisibility(8);
            this.rvU.setVisibility(8);
            this.rvV.setVisibility(8);
            this.qZb.setVisibility(8);
            this.rvW.setVisibility(8);
            this.rvX.setVisibility(8);
            this.rvY.setVisibility(8);
            this.rvZ.setVisibility(8);
            this.rwa.setVisibility(8);
            this.rvT.setVisibility(8);
            this.rwb.setVisibility(8);
            this.rwc.setVisibility(8);
            this.rwd.setVisibility(8);
            this.rwe.setVisibility(8);
            this.rwf.setVisibility(8);
            this.rwg.setVisibility(8);
            if (com.tencent.mm.bz.a.dm(as.this.czX) > 1.0f) {
                this.qZb.setMaxLines(2);
            }
            AppMethodBeat.o(39209);
        }
    }

    public final void kI(long j) {
        if (0 == this.rvA) {
            this.rvA = j;
            this.rvB = 0;
        }
    }

    public as(Activity activity, f fVar, String str, final c cVar) {
        AppMethodBeat.i(39218);
        this.userName = str;
        this.czX = activity;
        this.rvu = fVar;
        this.rvx = cVar;
        this.rqa = af.cnt();
        String g = aa.g(this.czX.getSharedPreferences(ah.doA(), 0));
        ab.d("MicroMsg.SnsphotoAdapter", "filterLan temp ".concat(String.valueOf(g)));
        if (!(g.equals("zh_CN") || g.equals("en") || g.equals("zh_TW"))) {
            g = g.equals("zh_HK") ? "zh_TW" : "en";
        }
        this.nJy = g;
        this.country = aa.g(this.czX.getSharedPreferences(ah.doA(), 0));
        com.tencent.mm.kernel.g.RQ();
        if (this.userName.equals((String) com.tencent.mm.kernel.g.RP().Ry().get(2, null))) {
            this.czr = true;
        }
        ab.d("MicroMsg.SnsphotoAdapter", "SnsphotoAdapter : userName : " + this.userName + " country: " + this.country);
        if (this.czr) {
            this.rvs = az.dti();
        } else {
            com.tencent.mm.kernel.g.RQ();
            ad aoO = ((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoO(str);
            if (aoO == null || !com.tencent.mm.n.a.jh(aoO.field_type)) {
                this.rvs = az.dtj();
            } else {
                this.rvs = az.dth();
            }
        }
        this.rvw = new at(new com.tencent.mm.plugin.sns.ui.at.b() {
            public final void a(List<n> list, Map<Integer, Integer> map, Map<Integer, Integer> map2, Map<Integer, Integer> map3, int i, int i2) {
                AppMethodBeat.i(39200);
                ab.d("MicroMsg.SnsphotoAdapter", "onFinishFixPos");
                as asVar = as.this;
                ab.d("MicroMsg.SnsphotoAdapter", "setSnsList the thread id is " + Thread.currentThread().getId());
                if (list == null || list.size() <= 0) {
                    AppMethodBeat.o(39200);
                    return;
                }
                int i3;
                int i4;
                ab.d("MicroMsg.SnsphotoAdapter", "copy list info");
                int size = list.size();
                asVar.list.clear();
                asVar.rgf.clear();
                asVar.rgg.clear();
                asVar.rvt.clear();
                for (i3 = 0; i3 < size; i3++) {
                    asVar.list.add(n.z((n) list.get(i3)));
                }
                for (Integer intValue : map.keySet()) {
                    size = intValue.intValue();
                    asVar.rgf.put(Integer.valueOf(size), Integer.valueOf(((Integer) map.get(Integer.valueOf(size))).intValue()));
                }
                for (Integer intValue2 : map2.keySet()) {
                    size = intValue2.intValue();
                    asVar.rgg.put(Integer.valueOf(size), Integer.valueOf(((Integer) map2.get(Integer.valueOf(size))).intValue()));
                }
                for (Integer intValue22 : map3.keySet()) {
                    size = intValue22.intValue();
                    asVar.rvt.put(Integer.valueOf(size), Integer.valueOf(((Integer) map3.get(Integer.valueOf(size))).intValue()));
                }
                map.clear();
                map2.clear();
                if (asVar.czr) {
                    if (asVar.list.size() <= 1) {
                        i4 = BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i4 = ((n) asVar.list.get(1)).field_head;
                    }
                    i3 = i4;
                } else {
                    i3 = asVar.list.isEmpty() ? BaseClientBuilder.API_PRIORITY_OTHER : ((n) asVar.list.get(0)).field_head;
                }
                asVar.rvy = 0;
                i4 = 0;
                while (true) {
                    size = i4;
                    if (size >= asVar.list.size()) {
                        break;
                    }
                    if (!asVar.czr || size != 0) {
                        if (i3 != ((n) asVar.list.get(size)).field_head) {
                            break;
                        }
                        asVar.rvy = Math.max(asVar.rvy, ((n) asVar.list.get(size)).field_createTime);
                    }
                    i4 = size + 1;
                }
                if (asVar.list.isEmpty() || (asVar.czr && asVar.list.size() == 1)) {
                    asVar.rvy = BaseClientBuilder.API_PRIORITY_OTHER;
                }
                if (asVar.list.isEmpty()) {
                    i3 = 0;
                } else {
                    i3 = ((n) asVar.list.get(asVar.list.size() - 1)).field_head;
                }
                asVar.rvz = BaseClientBuilder.API_PRIORITY_OTHER;
                size = asVar.list.size() - 1;
                while (size >= 0 && r1 != 0 && r1 == ((n) asVar.list.get(size)).field_head) {
                    asVar.rvz = Math.min(asVar.rvz, ((n) asVar.list.get(size)).field_createTime);
                    size--;
                }
                if (asVar.list.isEmpty()) {
                    asVar.rvz = 0;
                }
                asVar.rgi = i;
                asVar.rgh = i2;
                ab.d("MicroMsg.SnsphotoAdapter", "reallyCount " + i + " icount " + i2 + " stTime " + asVar.rvy + " edTIme " + asVar.rvz);
                asVar.notifyDataSetChanged();
                AppMethodBeat.o(39200);
            }

            public final void ctL() {
                AppMethodBeat.i(39201);
                as.this.notifyDataSetChanged();
                AppMethodBeat.o(39201);
            }
        }, str, this.czr);
        kJ(0);
        ll(false);
        AppMethodBeat.o(39218);
    }

    public final int getCount() {
        return this.rgh;
    }

    private void a(TextView textView, TextView textView2, long j) {
        AppMethodBeat.i(39220);
        String str = (String) aw.a(this.czX, 1000 * j, !this.nJy.equals("en"));
        String[] split;
        if (str.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D) > 0) {
            split = str.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            if (split[1].length() < 2) {
                split[1] = new StringBuilder(AppEventsConstants.EVENT_PARAM_VALUE_NO).append(split[1]).toString();
            }
            textView.setText(split[0]);
            textView2.setText(split[1]);
            textView2.setVisibility(0);
            textView.setVisibility(0);
            AppMethodBeat.o(39220);
        } else if (str.indexOf("/") > 0) {
            split = str.split("/");
            if (split[1].length() < 2) {
                split[1] = new StringBuilder(AppEventsConstants.EVENT_PARAM_VALUE_NO).append(split[1]).toString();
            }
            split[0] = aw.x(this.czX, split[0], this.nJy);
            textView.setText(split[0]);
            textView2.setText(split[1]);
            textView2.setVisibility(0);
            textView.setVisibility(0);
            AppMethodBeat.o(39220);
        } else {
            textView2.setVisibility(0);
            textView2.setText(String.valueOf(str));
            AppMethodBeat.o(39220);
        }
    }

    private void a(TextView textView, int i, int i2) {
        AppMethodBeat.i(39221);
        int i3 = i / Downloads.MIN_WAIT_FOR_NETWORK;
        int i4 = i2 / Downloads.MIN_WAIT_FOR_NETWORK;
        ab.d("MicroMsg.SnsphotoAdapter", "preHead: %d, preYear: %d", Integer.valueOf(i), Integer.valueOf(i3));
        if (i3 == 0 || i4 != i3) {
            dN(textView);
            textView.setText(String.format(this.czX.getResources().getString(R.string.eqj), new Object[]{Integer.valueOf(i4)}));
            textView.setVisibility(0);
        }
        AppMethodBeat.o(39221);
    }

    private void dN(View view) {
        AppMethodBeat.i(39222);
        int intValue = ((Integer) view.getTag()).intValue();
        if (view.getLayoutParams() instanceof LayoutParams) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (intValue == 0) {
                layoutParams.topMargin = 0;
                view.setLayoutParams(layoutParams);
                AppMethodBeat.o(39222);
                return;
            }
            layoutParams.topMargin = this.czX.getResources().getDimensionPixelSize(R.dimen.a9r);
            view.setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(39222);
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.i(39223);
        if (this.czr && i == 0) {
            ab.d("MicroMsg.SnsphotoAdapter", "position isSelf " + i + " - 0");
            AppMethodBeat.o(39223);
            return 0;
        }
        int intValue;
        if (this.rgf.get(Integer.valueOf(i)) != null) {
            intValue = ((Integer) this.rgf.get(Integer.valueOf(i))).intValue();
        } else {
            intValue = -1;
        }
        if (intValue == -1) {
            ab.e("MicroMsg.SnsphotoAdapter", "unknow error ".concat(String.valueOf(intValue)));
            AppMethodBeat.o(39223);
            return 0;
        }
        n nVar = (n) getItem(intValue);
        if (nVar.cqu().xfI.wbJ == 1) {
            ab.d("MicroMsg.SnsphotoAdapter", "position " + i + " - 0");
            AppMethodBeat.o(39223);
            return 0;
        } else if (nVar.cqu().xfI.wbJ == 15) {
            ab.d("MicroMsg.SnsphotoAdapter", "position " + i + " - 2");
            AppMethodBeat.o(39223);
            return 2;
        } else if (nVar.cqu().xfI.wbJ == 21) {
            AppMethodBeat.o(39223);
            return 3;
        } else {
            AppMethodBeat.o(39223);
            return 1;
        }
    }

    public final int getViewTypeCount() {
        return 4;
    }

    private void a(int i, QFadeImageView qFadeImageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, int i2, d dVar, int i3) {
        AppMethodBeat.i(39224);
        n nVar = (n) getItem(i);
        TimeLineObject cqu = nVar.cqu();
        cbf q = aj.q(nVar);
        Object obj = null;
        if (q != null && (((q.wGz & 2) == 2 && q.xaB != null) || ((q.wGz & 4) == 4 && q.wFp != null))) {
            obj = 1;
        }
        if (!(!this.czr || q == null || obj == null || this.userName == null || !this.userName.equals(nVar.field_userName))) {
            textView3.setBackgroundResource(R.drawable.al8);
            textView3.setVisibility(0);
        }
        ad aoO;
        String Oj;
        if (i2 == 1) {
            if (aj.ab(nVar.field_localPrivate, this.czr)) {
                textView3.setVisibility(0);
                textView3.setBackgroundResource(R.drawable.al2);
                aoO = this.rqa.aoO(nVar.field_userName);
                Oj = aoO == null ? "" : aoO.Oj();
                if (!(Oj.equals("") || this.userName.equals(nVar.field_userName))) {
                    textView.setVisibility(0);
                    textView.setText(Oj);
                }
            }
        } else if (aj.ab(nVar.field_localPrivate, this.czr)) {
            textView3.setVisibility(0);
            textView3.setBackgroundResource(R.drawable.al2);
            aoO = this.rqa.aoO(nVar.field_userName);
            Oj = aoO == null ? "" : aoO.Oj();
            if (!(Oj == null || Oj.equals("") || this.userName.equals(nVar.field_userName))) {
                textView.setVisibility(0);
                textView.setText(Oj);
            }
        }
        int i4 = nVar.reX;
        a aVar = new a();
        aVar.cNE = i4;
        if (this.rvt.get(Integer.valueOf(i3)) != null) {
            aVar.position = ((Integer) this.rvt.get(Integer.valueOf(i3))).intValue();
        } else {
            aVar.position = 0;
        }
        qFadeImageView.setTag(aVar);
        az azVar = new az(this.rvs.tag);
        azVar.oyB = nVar.field_createTime;
        if (cqu.xfI.wbJ == 1) {
            qFadeImageView.setVisibility(0);
            af.cnC().a(cqu.xfI.wbK, (View) qFadeImageView, this.czX.hashCode(), com.tencent.mm.plugin.sns.model.g.a.IMG_SCENE_SNSSUSER, azVar);
        } else if (cqu.xfI.wbJ == 2) {
            textView4.setText(bo.bc(cqu.xfI.Desc, ""));
            textView4.setVisibility(0);
        } else if (cqu.xfI.wbJ == 21) {
            nVar.cqM();
            boolean z = true;
            if (this.czr) {
                z = true;
            } else if (m.a(nVar, q)) {
                z = false;
            }
            qFadeImageView.setVisibility(0);
            af.cnC().a(cqu.xfI.wbK, (View) qFadeImageView, this.czX.hashCode(), com.tencent.mm.plugin.sns.model.g.a.IMG_SCENE_SNSSUSER, azVar, z);
        }
        if (nVar.cnn() && nVar.cqW()) {
            textView3.setVisibility(0);
            textView3.setBackgroundResource(R.drawable.al0);
            qFadeImageView.setLongClickable(true);
        }
        if (i2 == 1) {
            if (cqu.xfI.wbK == null || cqu.xfI.wbK.size() <= 1) {
                textView2.setVisibility(8);
            } else {
                dVar.rwa.setVisibility(0);
                textView2.setVisibility(0);
                textView2.setText(this.czX.getResources().getQuantityString(R.plurals.a2, i4, new Object[]{Integer.valueOf(cqu.xfI.wbK.size())}));
            }
            CharSequence charSequence = cqu.xfF;
            if (!(charSequence == null || charSequence.equals(""))) {
                dVar.rwa.setVisibility(0);
                dVar.qZb.setVisibility(0);
                dVar.qZb.setText(String.valueOf(charSequence));
                dVar.qZb.setText(com.tencent.mm.pluginsdk.ui.e.j.b(this.czX, charSequence, dVar.qZb.getTextSize()));
            }
        }
        AppMethodBeat.o(39224);
    }

    private void ll(boolean z) {
        AppMethodBeat.i(39225);
        ab.d("MicroMsg.SnsphotoAdapter", "limitSeq " + this.lQD);
        if (this.rvw != null) {
            this.rvw.g(this.lQD, this.rvv, z);
        }
        AppMethodBeat.o(39225);
    }

    public final void notifyDataSetChanged() {
        AppMethodBeat.i(39226);
        super.notifyDataSetChanged();
        AppMethodBeat.o(39226);
    }

    public final void ctK() {
        AppMethodBeat.i(39228);
        ab.d("MicroMsg.SnsphotoAdapter", "i addSize ");
        kJ(this.list.isEmpty() ? 0 : ((n) this.list.get(this.list.size() - 1)).field_snsId);
        AppMethodBeat.o(39228);
    }

    private void kJ(long j) {
        as asVar;
        AppMethodBeat.i(39229);
        String jW = i.jW(af.cnF().a(j, af.cnv().Yc(this.userName), this.userName, this.czr));
        if (this.rmL.equals("")) {
            asVar = this;
        } else if (jW.compareTo(this.rmL) < 0) {
            asVar = this;
        } else {
            jW = this.rmL;
            asVar = this;
        }
        asVar.lQD = jW;
        aao cqL = af.cnJ().YX(this.userName).cqL();
        if (cqL.wfM == 0) {
            AppMethodBeat.o(39229);
            return;
        }
        jW = i.jW(cqL.wfM);
        if (this.lQD.equals("")) {
            this.lQD = jW;
            AppMethodBeat.o(39229);
            return;
        }
        if (jW.compareTo(this.lQD) <= 0) {
            jW = this.lQD;
        }
        this.lQD = jW;
        AppMethodBeat.o(39229);
    }

    public final Object getItem(int i) {
        AppMethodBeat.i(39230);
        Object obj = this.list.get(i);
        AppMethodBeat.o(39230);
        return obj;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final ArrayList<com.tencent.mm.plugin.sns.h.b> fv(int i, int i2) {
        AppMethodBeat.i(39231);
        ArrayList arrayList = new ArrayList();
        this.rvC = i2;
        for (int i3 = 0; i3 < this.list.size(); i3++) {
            n nVar = (n) this.list.get(i3);
            int i4 = nVar.reX;
            if (!(nVar.cqu() == null || nVar.cqu().xfI == null || nVar.cqu().xfI.wbK.size() == 0 || (nVar.cqu().xfI.wbJ != 1 && nVar.cqu().xfI.wbJ != 15))) {
                if (i4 == i) {
                    this.rvC = arrayList.size();
                }
                Iterator it = nVar.cqu().xfI.wbK.iterator();
                int i5 = 0;
                while (it.hasNext()) {
                    bau bau = (bau) it.next();
                    com.tencent.mm.plugin.sns.h.b bVar = new com.tencent.mm.plugin.sns.h.b();
                    bVar.cNr = bau;
                    bVar.qQd = v.ap("sns_table_", (long) i4);
                    bVar.fDG = nVar.field_createTime;
                    int i6 = i5 + 1;
                    bVar.qQe = i5;
                    arrayList.add(bVar);
                    i5 = i6;
                }
            }
        }
        AppMethodBeat.o(39231);
        return arrayList;
    }

    protected static boolean ZH(String str) {
        AppMethodBeat.i(39232);
        com.tencent.mm.aw.e aih = com.tencent.mm.aw.a.aih();
        if (aih != null && com.tencent.mm.aw.a.d(aih) && str.equals(aih.fJU) && com.tencent.mm.aw.a.aie()) {
            AppMethodBeat.o(39232);
            return true;
        }
        AppMethodBeat.o(39232);
        return false;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(39219);
        int itemViewType = getItemViewType(i);
        ab.i("MicroMsg.SnsphotoAdapter", "position ".concat(String.valueOf(itemViewType)));
        d dVar;
        int i2;
        n nVar;
        int i3;
        TimeLineObject cqu;
        String str;
        a aVar;
        if (itemViewType == 0) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof d)) {
                dVar = new d();
                view = com.tencent.mm.ui.v.hu(this.czX).inflate(R.layout.avz, null);
                dVar.rvI = (TextView) view.findViewById(R.id.eo2);
                dVar.rvH = (TextView) view.findViewById(R.id.eo3);
                dVar.rvJ = (TextView) view.findViewById(R.id.eo4);
                dVar.rvS = (MaskImageView) view.findViewById(R.id.eh2);
                dVar.rvT = (QFadeImageView) view.findViewById(R.id.ekr);
                dVar.rvU = (MaskImageView) view.findViewById(R.id.eh3);
                dVar.rvV = (MaskImageView) view.findViewById(R.id.eh4);
                dVar.qZb = (TextView) view.findViewById(R.id.o7);
                dVar.rvW = (TextView) view.findViewById(R.id.eks);
                dVar.rvX = (TextView) view.findViewById(R.id.ekx);
                dVar.rvY = (TextView) view.findViewById(R.id.el0);
                dVar.rvZ = (TextView) view.findViewById(R.id.ekv);
                dVar.rwa = view.findViewById(R.id.eku);
                dVar.rvM = (TextView) view.findViewById(R.id.ee);
                dVar.rvK = (LinearLayout) view.findViewById(R.id.ekn);
                dVar.rvL = (ImageView) view.findViewById(R.id.eko);
                dVar.rgx = (LinearLayout) view.findViewById(R.id.egz);
                dVar.rgy = view.findViewById(R.id.egy);
                dVar.rvT.setOnClickListener(this.rvu.rgo);
                dVar.rvS.setOnClickListener(this.rvu.rgo);
                dVar.rvU.setOnClickListener(this.rvu.rgp);
                dVar.rvV.setOnClickListener(this.rvu.rgq);
                dVar.rvS.setOnLongClickListener(this.rvu.rwl);
                dVar.rvU.setOnLongClickListener(this.rvu.rwl);
                dVar.rvV.setOnLongClickListener(this.rvu.rwl);
                dVar.rwb = (TextView) view.findViewById(R.id.ekt);
                dVar.rwc = (TextView) view.findViewById(R.id.eky);
                dVar.rwd = (TextView) view.findViewById(R.id.el1);
                dVar.rwe = (TextView) view.findViewById(R.id.ekq);
                dVar.rwf = (TextView) view.findViewById(R.id.ekw);
                dVar.rwg = (TextView) view.findViewById(R.id.ekz);
                dVar.rwh = (MaskLinearLayout) view.findViewById(R.id.ekp);
                dVar.rwh.b(dVar.rvS);
                dVar.rvN = (LinearLayout) view.findViewById(R.id.ekl);
                dVar.rvO = (TextView) view.findViewById(R.id.ekm);
                dVar.rvO.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(39203);
                        Intent intent = new Intent();
                        intent.putExtra("enter_scene", com.tencent.mm.ui.e.h.ygb);
                        com.tencent.mm.bp.d.b(as.this.czX, "setting", ".ui.setting.SettingsPrivacyUI", intent);
                        h.pYm.e(14098, Integer.valueOf(8));
                        AppMethodBeat.o(39203);
                    }
                });
                view.setTag(dVar);
            } else {
                dVar = (d) view.getTag();
            }
            af.cnC().dz(dVar.rvS);
            af.cnC().dz(dVar.rvU);
            af.cnC().dz(dVar.rvV);
            i2 = -1;
            if (this.rgf.get(Integer.valueOf(i)) != null) {
                i2 = ((Integer) this.rgf.get(Integer.valueOf(i))).intValue();
            }
            dVar.init();
            dVar.rvJ.setTag(Integer.valueOf(i));
            dVar.rwh.settouchEnable(false);
            dVar.rwh.setBackgroundResource(0);
            dVar.rwh.setDescendantFocusability(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            dVar.rwh.setClickable(false);
            dVar.rvS.settouchEnable(true);
            dVar.rvS.setClickable(true);
            dVar.rvS.setLongClickable(false);
            dVar.rvU.setLongClickable(false);
            dVar.rvV.setLongClickable(false);
            dVar.rwh.setOnClickListener(null);
            dVar.rwh.setOnLongClickListener(null);
            dVar.rwh.setLongClickable(false);
            if (i2 >= this.rgi || i2 == -1) {
                view.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
                view.setVisibility(8);
                AppMethodBeat.o(39219);
            } else {
                int intValue;
                if (i2 - 1 >= 0) {
                    nVar = (n) getItem(i2 - 1);
                    i3 = nVar.field_head;
                    aj.ab(nVar.field_localPrivate, this.czr);
                } else {
                    i3 = -1;
                }
                view.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                view.setVisibility(0);
                if (this.rgg.get(Integer.valueOf(i)) != null) {
                    intValue = ((Integer) this.rgg.get(Integer.valueOf(i))).intValue();
                } else {
                    intValue = 1;
                }
                n nVar2 = (n) getItem(i2);
                cqu = nVar2.cqu();
                if ((this.czr && i == 0) || i3 == -1 || nVar2.field_head != i3) {
                    a(dVar.rvH, dVar.rvI, (long) nVar2.field_createTime);
                    if (cqu.xfG != null) {
                        str = cqu.xfG.guP;
                        if (!(str == null || str.equals(""))) {
                            dVar.rvM.setText(str);
                            dVar.rvM.setVisibility(0);
                        }
                    }
                    dVar.rgy.setVisibility(0);
                }
                a(dVar.rvJ, i3, nVar2.field_head);
                if (this.rvB != 0 && nVar2.field_snsId == this.rvB) {
                    dVar.rvN.setVisibility(0);
                } else if (this.rvB != 0 || this.rvA == 0 || nVar2.field_snsId > this.rvA) {
                    dVar.rvN.setVisibility(8);
                } else {
                    dVar.rvN.setVisibility(0);
                    this.rvB = nVar2.field_snsId;
                }
                dVar.rvK.setVisibility(0);
                if (this.czr && i == 0) {
                    dVar.rvT.setVisibility(0);
                    dVar.rvT.setContentDescription(this.czX.getString(R.string.epj));
                    dVar.rvS.setVisibility(8);
                    dVar.qZb.setText(this.rgh == 1 ? this.czX.getString(R.string.eqk) : "");
                    dVar.qZb.setVisibility(0);
                    dVar.rwa.setVisibility(0);
                    dVar.rvZ.setVisibility(8);
                    af.cnC().a(dVar.rvT, (int) R.color.a1_, (int) R.drawable.a1l, this.czX.hashCode());
                    aVar = new a();
                    aVar.cNE = -1;
                    aVar.position = -1;
                    dVar.rvT.setTag(aVar);
                    AppMethodBeat.o(39219);
                } else {
                    if (intValue > 0) {
                        a(i2, dVar.rvS, dVar.rvW, dVar.rvZ, dVar.rwb, dVar.rwe, 1, dVar, i);
                    }
                    if (intValue >= 2) {
                        a(i2 + 1, dVar.rvU, dVar.rvX, dVar.rvZ, dVar.rwc, dVar.rwf, 2, dVar, i);
                    }
                    if (intValue >= 3) {
                        a(i2 + 2, dVar.rvV, dVar.rvY, dVar.rvZ, dVar.rwd, dVar.rwg, 3, dVar, i);
                    }
                    if (intValue == 1) {
                        nVar = (n) getItem(i2);
                        if (!bo.isNullOrNil(nVar.cqu().xfF) && nVar.field_type == 1) {
                            dVar.rwh.setDescendantFocusability(393216);
                            dVar.rwh.setClickable(true);
                            dVar.rvS.setClickable(false);
                            dVar.rvS.settouchEnable(false);
                            dVar.rwh.setOnClickListener(this.rvu.rgo);
                            dVar.rwh.settouchEnable(true);
                            i2 = nVar2.reX;
                            a aVar2 = new a();
                            aVar2.cNE = i2;
                            if (this.rvt.get(Integer.valueOf(i)) != null) {
                                aVar2.position = ((Integer) this.rvt.get(Integer.valueOf(i))).intValue();
                            } else {
                                aVar2.position = 0;
                            }
                            if (nVar.cnn() && nVar.cqW()) {
                                dVar.rwh.setOnLongClickListener(this.rvu.rwl);
                            }
                            dVar.rwh.setTag(aVar2);
                        }
                    }
                    view.setDrawingCacheEnabled(false);
                    AppMethodBeat.o(39219);
                }
            }
        } else {
            a aVar3;
            if (itemViewType == 2) {
                e eVar;
                int intValue2;
                if (view == null || view.getTag() == null || !(view.getTag() instanceof e)) {
                    e eVar2 = new e();
                    view = com.tencent.mm.ui.v.hu(this.czX).inflate(R.layout.awa, null);
                    eVar2.rvI = (TextView) view.findViewById(R.id.eo2);
                    eVar2.rvH = (TextView) view.findViewById(R.id.eo3);
                    eVar2.rvJ = (TextView) view.findViewById(R.id.eo4);
                    eVar2.rvS = (MaskImageView) view.findViewById(R.id.eh2);
                    eVar2.rvM = (TextView) view.findViewById(R.id.ee);
                    eVar2.rvK = (LinearLayout) view.findViewById(R.id.ekn);
                    eVar2.rvL = (ImageView) view.findViewById(R.id.eko);
                    eVar2.rgx = (LinearLayout) view.findViewById(R.id.egz);
                    eVar2.rgy = view.findViewById(R.id.egy);
                    eVar2.rvS.setOnClickListener(this.rvu.rwk);
                    eVar2.rwb = (TextView) view.findViewById(R.id.ekt);
                    eVar2.rwh = (MaskLinearLayout) view.findViewById(R.id.ekp);
                    eVar2.rwh.b(eVar2.rvS);
                    eVar2.qZb = (TextView) view.findViewById(R.id.o7);
                    eVar2.rwa = view.findViewById(R.id.eku);
                    eVar2.rvN = (LinearLayout) view.findViewById(R.id.ekl);
                    eVar2.rvO = (TextView) view.findViewById(R.id.ekm);
                    eVar2.rvO.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(39202);
                            Intent intent = new Intent();
                            intent.putExtra("enter_scene", com.tencent.mm.ui.e.h.ygb);
                            com.tencent.mm.bp.d.b(as.this.czX, "setting", ".ui.setting.SettingsPrivacyUI", intent);
                            h.pYm.e(14098, Integer.valueOf(8));
                            AppMethodBeat.o(39202);
                        }
                    });
                    view.setTag(eVar2);
                    eVar = eVar2;
                } else {
                    eVar = (e) view.getTag();
                }
                af.cnC().dz(eVar.rvS);
                if (this.rgf.get(Integer.valueOf(i)) != null) {
                    intValue2 = ((Integer) this.rgf.get(Integer.valueOf(i))).intValue();
                } else {
                    intValue2 = -1;
                }
                eVar.init();
                eVar.rvJ.setTag(Integer.valueOf(i));
                eVar.rwh.settouchEnable(false);
                eVar.rwh.setBackgroundResource(0);
                eVar.rwh.setDescendantFocusability(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                eVar.rwh.setClickable(false);
                eVar.rvS.settouchEnable(true);
                eVar.rvS.setClickable(true);
                eVar.rwh.setOnClickListener(null);
                if (intValue2 >= this.rgi || intValue2 == -1) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
                    view.setVisibility(8);
                    AppMethodBeat.o(39219);
                } else {
                    if (intValue2 - 1 >= 0) {
                        nVar = (n) getItem(intValue2 - 1);
                        i2 = nVar.field_head;
                        aj.ab(nVar.field_localPrivate, this.czr);
                    } else {
                        i2 = -1;
                    }
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                    view.setVisibility(0);
                    if (this.rgg.get(Integer.valueOf(i)) != null) {
                        ((Integer) this.rgg.get(Integer.valueOf(i))).intValue();
                    }
                    n nVar3 = (n) getItem(intValue2);
                    TimeLineObject cqu2 = nVar3.cqu();
                    if ((this.czr && i == 0) || i2 == -1 || nVar3.field_head != i2) {
                        a(eVar.rvH, eVar.rvI, (long) nVar3.field_createTime);
                        if (cqu2.xfG != null) {
                            str = cqu2.xfG.guP;
                            if (!(str == null || str.equals(""))) {
                                eVar.rvM.setText(str);
                                eVar.rvM.setVisibility(0);
                            }
                        }
                        eVar.rgy.setVisibility(0);
                    }
                    a(eVar.rvJ, i2, nVar3.field_head);
                    if (this.rvB != 0 && nVar3.field_snsId == this.rvB) {
                        eVar.rvN.setVisibility(0);
                    } else if (this.rvB != 0 || this.rvA == 0 || nVar3.field_snsId > this.rvA) {
                        eVar.rvN.setVisibility(8);
                    } else {
                        eVar.rvN.setVisibility(0);
                        this.rvB = nVar3.field_snsId;
                    }
                    eVar.rvK.setVisibility(0);
                    az azVar = new az(this.rvs.tag);
                    azVar.oyB = nVar3.field_createTime;
                    eVar.rvS.setVisibility(0);
                    af.cnC().a(cqu2.xfI.wbK, eVar.rvS, this.czX.hashCode(), com.tencent.mm.plugin.sns.model.g.a.IMG_SCENE_SNSSUSER, azVar);
                    if (aj.ab(nVar3.field_localPrivate, this.czr)) {
                        eVar.rwb.setVisibility(0);
                        eVar.rwb.setBackgroundResource(R.drawable.al2);
                        ad aoO = this.rqa.aoO(nVar3.field_userName);
                        if (aoO != null) {
                            aoO.Oj();
                        }
                    }
                    CharSequence charSequence = ((n) getItem(intValue2)).cqu().xfF;
                    if (!(charSequence == null || charSequence.equals(""))) {
                        eVar.rwa.setVisibility(0);
                        eVar.qZb.setVisibility(0);
                        eVar.qZb.setText(String.valueOf(charSequence));
                        eVar.qZb.setText(com.tencent.mm.pluginsdk.ui.e.j.b(this.czX, charSequence, eVar.qZb.getTextSize()));
                    }
                    eVar.rwh.setDescendantFocusability(393216);
                    eVar.rwh.setClickable(true);
                    eVar.rvS.setClickable(false);
                    eVar.rvS.settouchEnable(false);
                    eVar.rwh.setOnClickListener(this.rvu.rwk);
                    eVar.rwh.settouchEnable(true);
                    itemViewType = nVar3.reX;
                    aVar3 = new a();
                    aVar3.cNE = itemViewType;
                    if (this.rvt.get(Integer.valueOf(i)) != null) {
                        aVar3.position = ((Integer) this.rvt.get(Integer.valueOf(i))).intValue();
                    } else {
                        aVar3.position = 0;
                    }
                    eVar.rwh.setTag(aVar3);
                }
            } else if (itemViewType == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof d)) {
                    dVar = new d();
                    view = com.tencent.mm.ui.v.hu(this.czX).inflate(R.layout.avz, null);
                    dVar.rvI = (TextView) view.findViewById(R.id.eo2);
                    dVar.rvH = (TextView) view.findViewById(R.id.eo3);
                    dVar.rvJ = (TextView) view.findViewById(R.id.eo4);
                    dVar.rvS = (MaskImageView) view.findViewById(R.id.eh2);
                    dVar.rvT = (QFadeImageView) view.findViewById(R.id.ekr);
                    dVar.rvU = (MaskImageView) view.findViewById(R.id.eh3);
                    dVar.rvV = (MaskImageView) view.findViewById(R.id.eh4);
                    dVar.qZb = (TextView) view.findViewById(R.id.o7);
                    dVar.rvW = (TextView) view.findViewById(R.id.eks);
                    dVar.rvX = (TextView) view.findViewById(R.id.ekx);
                    dVar.rvY = (TextView) view.findViewById(R.id.el0);
                    dVar.rvZ = (TextView) view.findViewById(R.id.ekv);
                    dVar.rwa = view.findViewById(R.id.eku);
                    dVar.rvM = (TextView) view.findViewById(R.id.ee);
                    dVar.rvK = (LinearLayout) view.findViewById(R.id.ekn);
                    dVar.rvL = (ImageView) view.findViewById(R.id.eko);
                    dVar.rgx = (LinearLayout) view.findViewById(R.id.egz);
                    dVar.rgy = view.findViewById(R.id.egy);
                    dVar.rvT.setOnClickListener(this.rvu.rwj);
                    dVar.rvS.setOnClickListener(this.rvu.rwj);
                    dVar.rwb = (TextView) view.findViewById(R.id.ekt);
                    dVar.rwc = (TextView) view.findViewById(R.id.eky);
                    dVar.rwd = (TextView) view.findViewById(R.id.el1);
                    dVar.rwe = (TextView) view.findViewById(R.id.ekq);
                    dVar.rwf = (TextView) view.findViewById(R.id.ekw);
                    dVar.rwg = (TextView) view.findViewById(R.id.ekz);
                    dVar.rwh = (MaskLinearLayout) view.findViewById(R.id.ekp);
                    dVar.rwh.b(dVar.rvS);
                    dVar.rvN = (LinearLayout) view.findViewById(R.id.ekl);
                    dVar.rvO = (TextView) view.findViewById(R.id.ekm);
                    dVar.rvO.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(39205);
                            Intent intent = new Intent();
                            intent.putExtra("enter_scene", com.tencent.mm.ui.e.h.ygb);
                            com.tencent.mm.bp.d.b(as.this.czX, "setting", ".ui.setting.SettingsPrivacyUI", intent);
                            h.pYm.e(14098, Integer.valueOf(8));
                            AppMethodBeat.o(39205);
                        }
                    });
                    view.setTag(dVar);
                } else {
                    dVar = (d) view.getTag();
                }
                af.cnC().dz(dVar.rvS);
                af.cnC().dz(dVar.rvU);
                af.cnC().dz(dVar.rvV);
                i2 = -1;
                if (this.rgf.get(Integer.valueOf(i)) != null) {
                    i2 = ((Integer) this.rgf.get(Integer.valueOf(i))).intValue();
                }
                dVar.init();
                dVar.rvJ.setTag(Integer.valueOf(i));
                dVar.rwh.settouchEnable(false);
                dVar.rwh.setBackgroundResource(0);
                dVar.rwh.setDescendantFocusability(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                dVar.rwh.setClickable(false);
                dVar.rvS.settouchEnable(true);
                dVar.rvS.setClickable(true);
                dVar.rwh.setOnClickListener(null);
                if (i2 >= this.rgi || i2 == -1) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
                    view.setVisibility(8);
                    AppMethodBeat.o(39219);
                } else {
                    if (i2 - 1 >= 0) {
                        nVar = (n) getItem(i2 - 1);
                        i3 = nVar.field_head;
                        aj.ab(nVar.field_localPrivate, this.czr);
                    } else {
                        i3 = -1;
                    }
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                    view.setVisibility(0);
                    n nVar4 = (n) getItem(i2);
                    cqu = nVar4.cqu();
                    if ((this.czr && i == 0) || i3 == -1 || nVar4.field_head != i3) {
                        a(dVar.rvH, dVar.rvI, (long) nVar4.field_createTime);
                        if (cqu.xfG != null) {
                            str = cqu.xfG.guP;
                            if (!(str == null || str.equals(""))) {
                                dVar.rvM.setText(str);
                                dVar.rvM.setVisibility(0);
                            }
                        }
                        dVar.rgy.setVisibility(0);
                    }
                    a(dVar.rvJ, i3, nVar4.field_head);
                    if (this.rvB != 0 && nVar4.field_snsId == this.rvB) {
                        dVar.rvN.setVisibility(0);
                    } else if (this.rvB != 0 || this.rvA == 0 || nVar4.field_snsId > this.rvA) {
                        dVar.rvN.setVisibility(8);
                    } else {
                        dVar.rvN.setVisibility(0);
                        this.rvB = nVar4.field_snsId;
                    }
                    dVar.rvK.setVisibility(0);
                    if (this.czr && i == 0) {
                        dVar.rvT.setVisibility(0);
                        dVar.rvT.setContentDescription(this.czX.getString(R.string.epj));
                        dVar.rvS.setVisibility(8);
                        dVar.qZb.setText(this.rgh == 1 ? this.czX.getString(R.string.eqk) : "");
                        dVar.qZb.setVisibility(0);
                        dVar.rwa.setVisibility(0);
                        dVar.rvZ.setVisibility(8);
                        af.cnC().a(dVar.rvT, (int) R.color.a1_, (int) R.drawable.a1l, this.czX.hashCode());
                        aVar = new a();
                        aVar.cNE = -1;
                        aVar.position = -1;
                        dVar.rvT.setTag(aVar);
                        AppMethodBeat.o(39219);
                    } else {
                        a(i2, dVar.rvS, dVar.rvW, dVar.rvZ, dVar.rwb, dVar.rwe, 1, dVar, i);
                        nVar = (n) getItem(i2);
                        if (!bo.isNullOrNil(nVar.cqu().xfF) && nVar.field_type == 1) {
                            dVar.rwh.setDescendantFocusability(393216);
                            dVar.rwh.setClickable(true);
                            dVar.rvS.setClickable(false);
                            dVar.rvS.settouchEnable(false);
                            dVar.rwh.setOnClickListener(this.rvu.rwj);
                            dVar.rwh.settouchEnable(true);
                            itemViewType = nVar4.reX;
                            aVar3 = new a();
                            aVar3.cNE = itemViewType;
                            if (this.rvt.get(Integer.valueOf(i)) != null) {
                                aVar3.position = ((Integer) this.rvt.get(Integer.valueOf(i))).intValue();
                            } else {
                                aVar3.position = 0;
                            }
                            dVar.rwh.setTag(aVar3);
                        }
                        view.setDrawingCacheEnabled(false);
                        AppMethodBeat.o(39219);
                    }
                }
            } else {
                b bVar;
                if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                    b bVar2 = new b();
                    view = com.tencent.mm.ui.v.hu(this.czX).inflate(R.layout.avy, null);
                    bVar2.rvG = view.findViewById(R.id.a7z);
                    bVar2.rvI = (TextView) view.findViewById(R.id.eo2);
                    bVar2.rvH = (TextView) view.findViewById(R.id.eo3);
                    bVar2.rvJ = (TextView) view.findViewById(R.id.eo4);
                    bVar2.rvM = (TextView) view.findViewById(R.id.ee);
                    bVar2.rgy = view.findViewById(R.id.egy);
                    bVar2.rvM = (TextView) view.findViewById(R.id.ee);
                    bVar2.rvK = (LinearLayout) view.findViewById(R.id.ekn);
                    bVar2.rvL = (ImageView) view.findViewById(R.id.eko);
                    bVar2.rgx = (LinearLayout) view.findViewById(R.id.egz);
                    bVar2.hrg = (TextView) view.findViewById(R.id.ld);
                    bVar2.rvP = (TagImageView) view.findViewById(R.id.d11);
                    bVar2.rhd = (ImageView) view.findViewById(R.id.c9m);
                    bVar2.gne = (TextView) view.findViewById(R.id.d13);
                    bVar2.rvQ = (TextView) view.findViewById(R.id.d14);
                    bVar2.rvG.setOnClickListener(this.rvu.rwi);
                    bVar2.rvR = view.findViewById(R.id.ek3);
                    bVar2.rvN = (LinearLayout) view.findViewById(R.id.ekl);
                    bVar2.rvO = (TextView) view.findViewById(R.id.ekm);
                    bVar2.rvO.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(39204);
                            Intent intent = new Intent();
                            intent.putExtra("enter_scene", com.tencent.mm.ui.e.h.ygb);
                            com.tencent.mm.bp.d.b(as.this.czX, "setting", ".ui.setting.SettingsPrivacyUI", intent);
                            h.pYm.e(14098, Integer.valueOf(8));
                            AppMethodBeat.o(39204);
                        }
                    });
                    view.setTag(bVar2);
                    i.b(bVar2.rvP, this.czX);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                bVar.rvJ.setTag(Integer.valueOf(i));
                if (this.rgf.get(Integer.valueOf(i)) != null) {
                    i2 = ((Integer) this.rgf.get(Integer.valueOf(i))).intValue();
                } else {
                    i2 = -1;
                }
                bVar.init();
                if (i2 >= this.rgi || i2 == -1) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
                    view.setVisibility(8);
                    AppMethodBeat.o(39219);
                } else {
                    view.setVisibility(0);
                    if (i2 - 1 >= 0) {
                        nVar = (n) getItem(i2 - 1);
                        i3 = nVar.field_head;
                        aj.ab(nVar.field_localPrivate, this.czr);
                    } else {
                        i3 = -1;
                    }
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                    view.setVisibility(0);
                    if (this.rgg.get(Integer.valueOf(i)) != null) {
                        ((Integer) this.rgg.get(Integer.valueOf(i))).intValue();
                    }
                    n nVar5 = (n) getItem(i2);
                    TimeLineObject cqu3 = nVar5.cqu();
                    if ((this.czr && i == 0) || i3 == -1 || nVar5.field_head != i3) {
                        a(bVar.rvH, bVar.rvI, (long) nVar5.field_createTime);
                        if (cqu3.xfG != null) {
                            str = cqu3.xfG.guP;
                            if (!(str == null || str.equals(""))) {
                                bVar.rvM.setText(str);
                                bVar.rvM.setVisibility(0);
                            }
                        }
                        bVar.rgy.setVisibility(0);
                    }
                    a(bVar.rvJ, i3, nVar5.field_head);
                    if (this.rvB != 0 && nVar5.field_snsId == this.rvB) {
                        bVar.rvN.setVisibility(0);
                    } else if (this.rvB != 0 || this.rvA == 0 || nVar5.field_snsId > this.rvA) {
                        bVar.rvN.setVisibility(8);
                    } else {
                        bVar.rvN.setVisibility(0);
                        this.rvB = nVar5.field_snsId;
                    }
                    a aVar4 = new a();
                    aVar4.cNE = nVar5.reX;
                    if (this.rvt.get(Integer.valueOf(i)) != null) {
                        aVar4.position = ((Integer) this.rvt.get(Integer.valueOf(i))).intValue();
                    } else {
                        aVar4.position = 0;
                    }
                    bVar.rvG.setTag(aVar4);
                    if (bo.isNullOrNil(cqu3.xfF)) {
                        bVar.hrg.setVisibility(8);
                    } else {
                        bVar.hrg.setVisibility(0);
                        bVar.hrg.setText(cqu3.xfF);
                        bVar.hrg.setText(com.tencent.mm.pluginsdk.ui.e.j.b(this.czX, cqu3.xfF, bVar.hrg.getTextSize()));
                    }
                    bVar.rvK.setVisibility(0);
                    bVar.hrg.setSingleLine(true);
                    bVar.rvR.setVisibility(0);
                    itemViewType = cqu3.xfI.wbJ;
                    az azVar2 = new az(this.rvs.tag);
                    azVar2.oyB = nVar5.field_createTime;
                    bau bau;
                    if (itemViewType == 2) {
                        bVar.hrg.setVisibility(0);
                        bVar.hrg.setSingleLine(false);
                        bVar.hrg.setMaxLines(2);
                        bVar.rvR.setVisibility(8);
                    } else if (itemViewType != 4) {
                        Object obj;
                        String str2;
                        bVar.gne.setTextColor(this.czX.getResources().getColor(R.color.z4));
                        if ((com.tencent.mm.plugin.sns.model.am.a.coe() & 1) <= 0) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        String ZI = obj != null ? au.ZI(cqu3.xfI.Url) : "";
                        str = cqu3.xfI.Title;
                        if (str == null || str.length() <= 40) {
                            str2 = str;
                        } else {
                            str2 = str.substring(0, 40) + "...";
                        }
                        if (bVar.rvP != null) {
                            bVar.rvP.setOnClickListener(null);
                        }
                        bVar.rhd.setVisibility(8);
                        if (!cqu3.xfI.wbK.isEmpty()) {
                            bVar.rvP.setVisibility(0);
                            bau = (bau) cqu3.xfI.wbK.get(0);
                            if (cqu3.xfI.wbJ == 5) {
                                ZI = au.ZI(bau.Url);
                                str2 = bau.Title;
                                bVar.rhd.setVisibility(0);
                                af.cnC().a(bau, bVar.rvP, (int) R.raw.app_attach_file_icon_video, this.czX.hashCode(), com.tencent.mm.plugin.sns.model.g.a.IMG_SCENE_SNSSUSER, azVar2);
                            } else {
                                af.cnC().a(bau, bVar.rvP, this.czX.hashCode(), com.tencent.mm.plugin.sns.model.g.a.IMG_SCENE_SNSSUSER, azVar2);
                            }
                        } else if (cqu3.xfI.wbJ != 26) {
                            bVar.rvP.setVisibility(8);
                        } else {
                            bVar.rvP.setVisibility(0);
                            bVar.rvP.setImageResource(R.raw.note_sns_link_default);
                        }
                        if (bo.isNullOrNil(ZI)) {
                            bVar.rvQ.setVisibility(8);
                        } else {
                            bVar.rvQ.setVisibility(0);
                            bVar.rvQ.setText(ZI);
                        }
                        if (bo.isNullOrNil(str2)) {
                            bVar.gne.setVisibility(8);
                        } else {
                            if (bVar.rvQ.getVisibility() == 8) {
                                bVar.gne.setMaxLines(2);
                            } else {
                                bVar.gne.setMaxLines(1);
                            }
                            bVar.gne.setVisibility(0);
                            if ((cqu3.fgt & 1) > 0) {
                                bVar.gne.setText(i.a(str2, this.czX, bVar.gne));
                            } else {
                                bVar.gne.setText(str2);
                            }
                        }
                    } else if (cqu3.xfI.wbK.isEmpty()) {
                        bVar.rvR.setVisibility(8);
                    } else {
                        bVar.rvP.setVisibility(0);
                        bVar.rhd.setVisibility(0);
                        bVar.rvR.setVisibility(0);
                        bVar.gne.setMaxLines(1);
                        bVar.gne.setTextColor(this.czX.getResources().getColor(R.color.a0k));
                        bau = (bau) cqu3.xfI.wbK.get(0);
                        af.cnC().a(bau, bVar.rvP, (int) R.raw.app_attach_file_icon_music, this.czX.hashCode(), com.tencent.mm.plugin.sns.model.g.a.IMG_SCENE_SNSSUSER, azVar2);
                        bVar.rhd.setPressed(false);
                        if (ZH(cqu3.Id)) {
                            bVar.rhd.setImageResource(R.drawable.vq);
                        } else {
                            bVar.rhd.setImageResource(R.drawable.vs);
                        }
                        bVar.rvP.setTag(cqu3);
                        bVar.rvP.setOnClickListener(this.rvD);
                        bau.cNE = nVar5.reX;
                        bVar.rvR.setTag(cqu3);
                        str = bau.Desc;
                        if (bo.isNullOrNil(str)) {
                            bVar.rvQ.setVisibility(4);
                        } else {
                            bVar.rvQ.setVisibility(0);
                            bVar.rvQ.setText(str);
                        }
                        str = bau.Title;
                        if (bo.isNullOrNil(str)) {
                            bVar.gne.setVisibility(8);
                        } else {
                            bVar.gne.setVisibility(0);
                            bVar.gne.setTag(aVar4);
                            bVar.gne.setOnTouchListener(new aa());
                            bVar.gne.setText(str);
                        }
                    }
                }
            }
            view.setDrawingCacheEnabled(false);
            AppMethodBeat.o(39219);
        }
        return view;
    }

    public final void crP() {
        AppMethodBeat.i(39227);
        ll(true);
        notifyDataSetChanged();
        AppMethodBeat.o(39227);
    }
}

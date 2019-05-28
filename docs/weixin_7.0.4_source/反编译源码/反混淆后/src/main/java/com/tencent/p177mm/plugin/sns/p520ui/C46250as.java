package com.tencent.p177mm.plugin.sns.p520ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p1510r.C35973a;
import com.tencent.p177mm.p198aw.C25848g;
import com.tencent.p177mm.p198aw.C37494a;
import com.tencent.p177mm.p198aw.C9058e;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.C5510e.C5501h;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.widget.QFadeImageView;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.lucky.p1298a.C39742m;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C21925g.C21934a;
import com.tencent.p177mm.plugin.sns.model.C34955aj;
import com.tencent.p177mm.plugin.sns.model.C3889am.C3890a;
import com.tencent.p177mm.plugin.sns.p1025h.C34937b;
import com.tencent.p177mm.plugin.sns.p520ui.C39831at.C39832b;
import com.tencent.p177mm.plugin.sns.storage.C35002v;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.aao;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.protocal.protobuf.cbf;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C44222az;
import com.tencent.p177mm.storage.C7309bd;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SuppressLint({"UseSparseArrays"})
/* renamed from: com.tencent.mm.plugin.sns.ui.as */
public final class C46250as extends BaseAdapter {
    private String country;
    private Activity czX;
    boolean czr = false;
    String lQD = "";
    List<C46236n> list = new ArrayList();
    private String nJy = "";
    Map<Integer, Integer> rgf = new HashMap();
    Map<Integer, Integer> rgg = new HashMap();
    int rgh = 0;
    int rgi = 0;
    String rmL = "";
    private C7309bd rqa = null;
    private long rvA = 0;
    private long rvB = 0;
    int rvC = 0;
    protected OnClickListener rvD = new C398296();
    private C44222az rvs;
    Map<Integer, Integer> rvt = new HashMap();
    private C4017f rvu;
    boolean rvv = false;
    C39831at rvw;
    private C35106c rvx;
    int rvy = BaseClientBuilder.API_PRIORITY_OTHER;
    int rvz = 0;
    private String userName = "";

    /* renamed from: com.tencent.mm.plugin.sns.ui.as$e */
    class C4016e extends C35105a {
        TextView qZb;
        MaskImageView rvS;
        View rwa;
        TextView rwb;
        MaskLinearLayout rwh;

        C4016e() {
            super();
        }

        public final void init() {
            AppMethodBeat.m2504i(39210);
            super.init();
            this.rvS.setVisibility(8);
            this.qZb.setVisibility(8);
            this.rwb.setVisibility(8);
            this.rwa.setVisibility(8);
            if (C1338a.m2860dm(C46250as.this.czX) > 1.0f) {
                this.qZb.setMaxLines(2);
            }
            AppMethodBeat.m2505o(39210);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.as$f */
    static abstract class C4017f {
        OnClickListener rgo = new C40191();
        OnClickListener rgp = new C40182();
        OnClickListener rgq = new C40203();
        OnClickListener rwi = new C40214();
        OnClickListener rwj = new C40225();
        OnClickListener rwk = new C40246();
        OnLongClickListener rwl = new C40237();
        public C4025a rwm = new C4025a();

        /* renamed from: com.tencent.mm.plugin.sns.ui.as$f$2 */
        class C40182 implements OnClickListener {
            C40182() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(39212);
                if (view.getTag() == null) {
                    AppMethodBeat.m2505o(39212);
                    return;
                }
                C4017f.this.rwm = (C4025a) view.getTag();
                C4017f.this.mo8864fw(C4017f.this.rwm.cNE, C4017f.this.rwm.position + 1);
                AppMethodBeat.m2505o(39212);
            }
        }

        /* renamed from: com.tencent.mm.plugin.sns.ui.as$f$1 */
        class C40191 implements OnClickListener {
            C40191() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(39211);
                if (view.getTag() == null) {
                    AppMethodBeat.m2505o(39211);
                    return;
                }
                C4017f.this.rwm = (C4025a) view.getTag();
                C4017f.this.mo8864fw(C4017f.this.rwm.cNE, C4017f.this.rwm.position);
                AppMethodBeat.m2505o(39211);
            }
        }

        /* renamed from: com.tencent.mm.plugin.sns.ui.as$f$3 */
        class C40203 implements OnClickListener {
            C40203() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(39213);
                if (view.getTag() == null) {
                    AppMethodBeat.m2505o(39213);
                    return;
                }
                C4017f.this.rwm = (C4025a) view.getTag();
                C4017f.this.mo8864fw(C4017f.this.rwm.cNE, C4017f.this.rwm.position + 2);
                AppMethodBeat.m2505o(39213);
            }
        }

        /* renamed from: com.tencent.mm.plugin.sns.ui.as$f$4 */
        class C40214 implements OnClickListener {
            C40214() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(39214);
                if (view.getTag() == null) {
                    AppMethodBeat.m2505o(39214);
                    return;
                }
                C4990ab.m7410d("MicroMsg.SnsphotoAdapter", "sign click");
                C4017f.this.rwm = (C4025a) view.getTag();
                C4017f.this.mo8865fx(C4017f.this.rwm.cNE, C4017f.this.rwm.position + 2);
                AppMethodBeat.m2505o(39214);
            }
        }

        /* renamed from: com.tencent.mm.plugin.sns.ui.as$f$5 */
        class C40225 implements OnClickListener {
            C40225() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(39215);
                if (view.getTag() == null) {
                    AppMethodBeat.m2505o(39215);
                    return;
                }
                C4990ab.m7410d("MicroMsg.SnsphotoAdapter", "sign click");
                C4017f.this.rwm = (C4025a) view.getTag();
                C4017f.this.mo8863Ed(C4017f.this.rwm.cNE);
                AppMethodBeat.m2505o(39215);
            }
        }

        /* renamed from: com.tencent.mm.plugin.sns.ui.as$f$7 */
        class C40237 implements OnLongClickListener {
            C40237() {
            }

            public final boolean onLongClick(View view) {
                AppMethodBeat.m2504i(39217);
                if (view.getTag() == null) {
                    AppMethodBeat.m2505o(39217);
                } else {
                    C4990ab.m7410d("MicroMsg.SnsphotoAdapter", "snsFailPhoto long click");
                    C4017f.this.rwm = (C4025a) view.getTag();
                    C4017f.this.mo8866fy(C4017f.this.rwm.cNE, C4017f.this.rwm.position);
                    AppMethodBeat.m2505o(39217);
                }
                return true;
            }
        }

        /* renamed from: com.tencent.mm.plugin.sns.ui.as$f$6 */
        class C40246 implements OnClickListener {
            C40246() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(39216);
                if (view.getTag() == null) {
                    AppMethodBeat.m2505o(39216);
                    return;
                }
                C4990ab.m7410d("MicroMsg.SnsphotoAdapter", "snssight click");
                C4017f.this.rwm = (C4025a) view.getTag();
                C4017f.this.mo8865fx(C4017f.this.rwm.cNE, C4017f.this.rwm.position + 2);
                AppMethodBeat.m2505o(39216);
            }
        }

        /* renamed from: com.tencent.mm.plugin.sns.ui.as$f$a */
        public static class C4025a {
            public int cNE;
            public int position;
        }

        /* renamed from: Ed */
        public abstract void mo8863Ed(int i);

        /* renamed from: fw */
        public abstract void mo8864fw(int i, int i2);

        /* renamed from: fx */
        public abstract void mo8865fx(int i, int i2);

        /* renamed from: fy */
        public abstract void mo8866fy(int i, int i2);
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.as$3 */
    class C136303 implements OnClickListener {
        C136303() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(39203);
            Intent intent = new Intent();
            intent.putExtra("enter_scene", C5501h.ygb);
            C25985d.m41467b(C46250as.this.czX, "setting", ".ui.setting.SettingsPrivacyUI", intent);
            C7060h.pYm.mo8381e(14098, Integer.valueOf(8));
            AppMethodBeat.m2505o(39203);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.as$4 */
    class C136314 implements OnClickListener {
        C136314() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(39204);
            Intent intent = new Intent();
            intent.putExtra("enter_scene", C5501h.ygb);
            C25985d.m41467b(C46250as.this.czX, "setting", ".ui.setting.SettingsPrivacyUI", intent);
            C7060h.pYm.mo8381e(14098, Integer.valueOf(8));
            AppMethodBeat.m2505o(39204);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.as$2 */
    class C291912 implements OnClickListener {
        C291912() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(39202);
            Intent intent = new Intent();
            intent.putExtra("enter_scene", C5501h.ygb);
            C25985d.m41467b(C46250as.this.czX, "setting", ".ui.setting.SettingsPrivacyUI", intent);
            C7060h.pYm.mo8381e(14098, Integer.valueOf(8));
            AppMethodBeat.m2505o(39202);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.as$5 */
    class C291925 implements OnClickListener {
        C291925() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(39205);
            Intent intent = new Intent();
            intent.putExtra("enter_scene", C5501h.ygb);
            C25985d.m41467b(C46250as.this.czX, "setting", ".ui.setting.SettingsPrivacyUI", intent);
            C7060h.pYm.mo8381e(14098, Integer.valueOf(8));
            AppMethodBeat.m2505o(39205);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.as$a */
    class C35105a {
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

        C35105a() {
        }

        public void init() {
            AppMethodBeat.m2504i(39207);
            this.rvH.setVisibility(8);
            this.rvI.setVisibility(8);
            this.rvJ.setVisibility(8);
            this.rvK.setVisibility(4);
            this.rvL.setVisibility(4);
            this.rgy.setVisibility(8);
            this.rvM.setVisibility(8);
            this.rvN.setVisibility(8);
            AppMethodBeat.m2505o(39207);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.as$c */
    public interface C35106c {
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.as$b */
    class C36815b extends C35105a {
        TextView gne;
        TextView hrg;
        ImageView rhd;
        TagImageView rvP;
        TextView rvQ;
        View rvR;

        C36815b() {
            super();
        }

        public final void init() {
            AppMethodBeat.m2504i(39208);
            super.init();
            this.hrg.setVisibility(8);
            this.rvP.setVisibility(8);
            this.rhd.setVisibility(8);
            this.gne.setVisibility(8);
            this.rvQ.setVisibility(8);
            AppMethodBeat.m2505o(39208);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.as$d */
    class C36816d extends C35105a {
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

        C36816d() {
            super();
        }

        public final void init() {
            AppMethodBeat.m2504i(39209);
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
            if (C1338a.m2860dm(C46250as.this.czX) > 1.0f) {
                this.qZb.setMaxLines(2);
            }
            AppMethodBeat.m2505o(39209);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.as$6 */
    class C398296 implements OnClickListener {
        C398296() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(39206);
            if (view.getTag() instanceof TimeLineObject) {
                TimeLineObject timeLineObject = (TimeLineObject) view.getTag();
                if (C46250as.m86591ZH(timeLineObject.f15074Id)) {
                    C7060h.pYm.mo8374X(10231, "1");
                    C37494a.aic();
                } else {
                    C7060h.pYm.mo8374X(10090, "1,0");
                    if (!(C35973a.m59179bJ(C46250as.this.czX) || C35973a.m59177bH(C46250as.this.czX))) {
                        C9058e a = C25848g.m41159a(C13373af.getAccPath(), timeLineObject, 8);
                        a.fKm = C46250as.this.userName;
                        C37494a.m63280b(a);
                    }
                }
                C46250as.this.notifyDataSetChanged();
            }
            AppMethodBeat.m2505o(39206);
        }
    }

    /* renamed from: kI */
    public final void mo74338kI(long j) {
        if (0 == this.rvA) {
            this.rvA = j;
            this.rvB = 0;
        }
    }

    public C46250as(Activity activity, C4017f c4017f, String str, final C35106c c35106c) {
        AppMethodBeat.m2504i(39218);
        this.userName = str;
        this.czX = activity;
        this.rvu = c4017f;
        this.rvx = c35106c;
        this.rqa = C13373af.cnt();
        String g = C4988aa.m7402g(this.czX.getSharedPreferences(C4996ah.doA(), 0));
        C4990ab.m7410d("MicroMsg.SnsphotoAdapter", "filterLan temp ".concat(String.valueOf(g)));
        if (!(g.equals("zh_CN") || g.equals("en") || g.equals("zh_TW"))) {
            g = g.equals("zh_HK") ? "zh_TW" : "en";
        }
        this.nJy = g;
        this.country = C4988aa.m7402g(this.czX.getSharedPreferences(C4996ah.doA(), 0));
        C1720g.m3537RQ();
        if (this.userName.equals((String) C1720g.m3536RP().mo5239Ry().get(2, null))) {
            this.czr = true;
        }
        C4990ab.m7410d("MicroMsg.SnsphotoAdapter", "SnsphotoAdapter : userName : " + this.userName + " country: " + this.country);
        if (this.czr) {
            this.rvs = C44222az.dti();
        } else {
            C1720g.m3537RQ();
            C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
            if (aoO == null || !C7486a.m12942jh(aoO.field_type)) {
                this.rvs = C44222az.dtj();
            } else {
                this.rvs = C44222az.dth();
            }
        }
        this.rvw = new C39831at(new C39832b() {
            /* renamed from: a */
            public final void mo25836a(List<C46236n> list, Map<Integer, Integer> map, Map<Integer, Integer> map2, Map<Integer, Integer> map3, int i, int i2) {
                AppMethodBeat.m2504i(39200);
                C4990ab.m7410d("MicroMsg.SnsphotoAdapter", "onFinishFixPos");
                C46250as c46250as = C46250as.this;
                C4990ab.m7410d("MicroMsg.SnsphotoAdapter", "setSnsList the thread id is " + Thread.currentThread().getId());
                if (list == null || list.size() <= 0) {
                    AppMethodBeat.m2505o(39200);
                    return;
                }
                int i3;
                int i4;
                C4990ab.m7410d("MicroMsg.SnsphotoAdapter", "copy list info");
                int size = list.size();
                c46250as.list.clear();
                c46250as.rgf.clear();
                c46250as.rgg.clear();
                c46250as.rvt.clear();
                for (i3 = 0; i3 < size; i3++) {
                    c46250as.list.add(C46236n.m86476z((C46236n) list.get(i3)));
                }
                for (Integer intValue : map.keySet()) {
                    size = intValue.intValue();
                    c46250as.rgf.put(Integer.valueOf(size), Integer.valueOf(((Integer) map.get(Integer.valueOf(size))).intValue()));
                }
                for (Integer intValue2 : map2.keySet()) {
                    size = intValue2.intValue();
                    c46250as.rgg.put(Integer.valueOf(size), Integer.valueOf(((Integer) map2.get(Integer.valueOf(size))).intValue()));
                }
                for (Integer intValue22 : map3.keySet()) {
                    size = intValue22.intValue();
                    c46250as.rvt.put(Integer.valueOf(size), Integer.valueOf(((Integer) map3.get(Integer.valueOf(size))).intValue()));
                }
                map.clear();
                map2.clear();
                if (c46250as.czr) {
                    if (c46250as.list.size() <= 1) {
                        i4 = BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i4 = ((C46236n) c46250as.list.get(1)).field_head;
                    }
                    i3 = i4;
                } else {
                    i3 = c46250as.list.isEmpty() ? BaseClientBuilder.API_PRIORITY_OTHER : ((C46236n) c46250as.list.get(0)).field_head;
                }
                c46250as.rvy = 0;
                i4 = 0;
                while (true) {
                    size = i4;
                    if (size >= c46250as.list.size()) {
                        break;
                    }
                    if (!c46250as.czr || size != 0) {
                        if (i3 != ((C46236n) c46250as.list.get(size)).field_head) {
                            break;
                        }
                        c46250as.rvy = Math.max(c46250as.rvy, ((C46236n) c46250as.list.get(size)).field_createTime);
                    }
                    i4 = size + 1;
                }
                if (c46250as.list.isEmpty() || (c46250as.czr && c46250as.list.size() == 1)) {
                    c46250as.rvy = BaseClientBuilder.API_PRIORITY_OTHER;
                }
                if (c46250as.list.isEmpty()) {
                    i3 = 0;
                } else {
                    i3 = ((C46236n) c46250as.list.get(c46250as.list.size() - 1)).field_head;
                }
                c46250as.rvz = BaseClientBuilder.API_PRIORITY_OTHER;
                size = c46250as.list.size() - 1;
                while (size >= 0 && r1 != 0 && r1 == ((C46236n) c46250as.list.get(size)).field_head) {
                    c46250as.rvz = Math.min(c46250as.rvz, ((C46236n) c46250as.list.get(size)).field_createTime);
                    size--;
                }
                if (c46250as.list.isEmpty()) {
                    c46250as.rvz = 0;
                }
                c46250as.rgi = i;
                c46250as.rgh = i2;
                C4990ab.m7410d("MicroMsg.SnsphotoAdapter", "reallyCount " + i + " icount " + i2 + " stTime " + c46250as.rvy + " edTIme " + c46250as.rvz);
                c46250as.notifyDataSetChanged();
                AppMethodBeat.m2505o(39200);
            }

            public final void ctL() {
                AppMethodBeat.m2504i(39201);
                C46250as.this.notifyDataSetChanged();
                AppMethodBeat.m2505o(39201);
            }
        }, str, this.czr);
        m86598kJ(0);
        m86599ll(false);
        AppMethodBeat.m2505o(39218);
    }

    public final int getCount() {
        return this.rgh;
    }

    /* renamed from: a */
    private void m86595a(TextView textView, TextView textView2, long j) {
        AppMethodBeat.m2504i(39220);
        String str = (String) C29198aw.m46371a(this.czX, 1000 * j, !this.nJy.equals("en"));
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
            AppMethodBeat.m2505o(39220);
        } else if (str.indexOf("/") > 0) {
            split = str.split("/");
            if (split[1].length() < 2) {
                split[1] = new StringBuilder(AppEventsConstants.EVENT_PARAM_VALUE_NO).append(split[1]).toString();
            }
            split[0] = C29198aw.m46378x(this.czX, split[0], this.nJy);
            textView.setText(split[0]);
            textView2.setText(split[1]);
            textView2.setVisibility(0);
            textView.setVisibility(0);
            AppMethodBeat.m2505o(39220);
        } else {
            textView2.setVisibility(0);
            textView2.setText(String.valueOf(str));
            AppMethodBeat.m2505o(39220);
        }
    }

    /* renamed from: a */
    private void m86594a(TextView textView, int i, int i2) {
        AppMethodBeat.m2504i(39221);
        int i3 = i / Downloads.MIN_WAIT_FOR_NETWORK;
        int i4 = i2 / Downloads.MIN_WAIT_FOR_NETWORK;
        C4990ab.m7411d("MicroMsg.SnsphotoAdapter", "preHead: %d, preYear: %d", Integer.valueOf(i), Integer.valueOf(i3));
        if (i3 == 0 || i4 != i3) {
            m86597dN(textView);
            textView.setText(String.format(this.czX.getResources().getString(C25738R.string.eqj), new Object[]{Integer.valueOf(i4)}));
            textView.setVisibility(0);
        }
        AppMethodBeat.m2505o(39221);
    }

    /* renamed from: dN */
    private void m86597dN(View view) {
        AppMethodBeat.m2504i(39222);
        int intValue = ((Integer) view.getTag()).intValue();
        if (view.getLayoutParams() instanceof LayoutParams) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (intValue == 0) {
                layoutParams.topMargin = 0;
                view.setLayoutParams(layoutParams);
                AppMethodBeat.m2505o(39222);
                return;
            }
            layoutParams.topMargin = this.czX.getResources().getDimensionPixelSize(C25738R.dimen.a9r);
            view.setLayoutParams(layoutParams);
        }
        AppMethodBeat.m2505o(39222);
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.m2504i(39223);
        if (this.czr && i == 0) {
            C4990ab.m7410d("MicroMsg.SnsphotoAdapter", "position isSelf " + i + " - 0");
            AppMethodBeat.m2505o(39223);
            return 0;
        }
        int intValue;
        if (this.rgf.get(Integer.valueOf(i)) != null) {
            intValue = ((Integer) this.rgf.get(Integer.valueOf(i))).intValue();
        } else {
            intValue = -1;
        }
        if (intValue == -1) {
            C4990ab.m7412e("MicroMsg.SnsphotoAdapter", "unknow error ".concat(String.valueOf(intValue)));
            AppMethodBeat.m2505o(39223);
            return 0;
        }
        C46236n c46236n = (C46236n) getItem(intValue);
        if (c46236n.cqu().xfI.wbJ == 1) {
            C4990ab.m7410d("MicroMsg.SnsphotoAdapter", "position " + i + " - 0");
            AppMethodBeat.m2505o(39223);
            return 0;
        } else if (c46236n.cqu().xfI.wbJ == 15) {
            C4990ab.m7410d("MicroMsg.SnsphotoAdapter", "position " + i + " - 2");
            AppMethodBeat.m2505o(39223);
            return 2;
        } else if (c46236n.cqu().xfI.wbJ == 21) {
            AppMethodBeat.m2505o(39223);
            return 3;
        } else {
            AppMethodBeat.m2505o(39223);
            return 1;
        }
    }

    public final int getViewTypeCount() {
        return 4;
    }

    /* renamed from: a */
    private void m86593a(int i, QFadeImageView qFadeImageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, int i2, C36816d c36816d, int i3) {
        AppMethodBeat.m2504i(39224);
        C46236n c46236n = (C46236n) getItem(i);
        TimeLineObject cqu = c46236n.cqu();
        cbf q = C34955aj.m57409q(c46236n);
        Object obj = null;
        if (q != null && (((q.wGz & 2) == 2 && q.xaB != null) || ((q.wGz & 4) == 4 && q.wFp != null))) {
            obj = 1;
        }
        if (!(!this.czr || q == null || obj == null || this.userName == null || !this.userName.equals(c46236n.field_userName))) {
            textView3.setBackgroundResource(C25738R.drawable.al8);
            textView3.setVisibility(0);
        }
        C7616ad aoO;
        String Oj;
        if (i2 == 1) {
            if (C34955aj.m57399ab(c46236n.field_localPrivate, this.czr)) {
                textView3.setVisibility(0);
                textView3.setBackgroundResource(C25738R.drawable.al2);
                aoO = this.rqa.aoO(c46236n.field_userName);
                Oj = aoO == null ? "" : aoO.mo16707Oj();
                if (!(Oj.equals("") || this.userName.equals(c46236n.field_userName))) {
                    textView.setVisibility(0);
                    textView.setText(Oj);
                }
            }
        } else if (C34955aj.m57399ab(c46236n.field_localPrivate, this.czr)) {
            textView3.setVisibility(0);
            textView3.setBackgroundResource(C25738R.drawable.al2);
            aoO = this.rqa.aoO(c46236n.field_userName);
            Oj = aoO == null ? "" : aoO.mo16707Oj();
            if (!(Oj == null || Oj.equals("") || this.userName.equals(c46236n.field_userName))) {
                textView.setVisibility(0);
                textView.setText(Oj);
            }
        }
        int i4 = c46236n.reX;
        C4025a c4025a = new C4025a();
        c4025a.cNE = i4;
        if (this.rvt.get(Integer.valueOf(i3)) != null) {
            c4025a.position = ((Integer) this.rvt.get(Integer.valueOf(i3))).intValue();
        } else {
            c4025a.position = 0;
        }
        qFadeImageView.setTag(c4025a);
        C44222az c44222az = new C44222az(this.rvs.tag);
        c44222az.oyB = c46236n.field_createTime;
        if (cqu.xfI.wbJ == 1) {
            qFadeImageView.setVisibility(0);
            C13373af.cnC().mo37444a(cqu.xfI.wbK, (View) qFadeImageView, this.czX.hashCode(), C21934a.IMG_SCENE_SNSSUSER, c44222az);
        } else if (cqu.xfI.wbJ == 2) {
            textView4.setText(C5046bo.m7532bc(cqu.xfI.Desc, ""));
            textView4.setVisibility(0);
        } else if (cqu.xfI.wbJ == 21) {
            c46236n.cqM();
            boolean z = true;
            if (this.czr) {
                z = true;
            } else if (C39742m.m67968a(c46236n, q)) {
                z = false;
            }
            qFadeImageView.setVisibility(0);
            C13373af.cnC().mo37445a(cqu.xfI.wbK, (View) qFadeImageView, this.czX.hashCode(), C21934a.IMG_SCENE_SNSSUSER, c44222az, z);
        }
        if (c46236n.cnn() && c46236n.cqW()) {
            textView3.setVisibility(0);
            textView3.setBackgroundResource(C25738R.drawable.al0);
            qFadeImageView.setLongClickable(true);
        }
        if (i2 == 1) {
            if (cqu.xfI.wbK == null || cqu.xfI.wbK.size() <= 1) {
                textView2.setVisibility(8);
            } else {
                c36816d.rwa.setVisibility(0);
                textView2.setVisibility(0);
                textView2.setText(this.czX.getResources().getQuantityString(C25738R.plurals.f9616a2, i4, new Object[]{Integer.valueOf(cqu.xfI.wbK.size())}));
            }
            CharSequence charSequence = cqu.xfF;
            if (!(charSequence == null || charSequence.equals(""))) {
                c36816d.rwa.setVisibility(0);
                c36816d.qZb.setVisibility(0);
                c36816d.qZb.setText(String.valueOf(charSequence));
                c36816d.qZb.setText(C44089j.m79293b(this.czX, charSequence, c36816d.qZb.getTextSize()));
            }
        }
        AppMethodBeat.m2505o(39224);
    }

    /* renamed from: ll */
    private void m86599ll(boolean z) {
        AppMethodBeat.m2504i(39225);
        C4990ab.m7410d("MicroMsg.SnsphotoAdapter", "limitSeq " + this.lQD);
        if (this.rvw != null) {
            this.rvw.mo63020g(this.lQD, this.rvv, z);
        }
        AppMethodBeat.m2505o(39225);
    }

    public final void notifyDataSetChanged() {
        AppMethodBeat.m2504i(39226);
        super.notifyDataSetChanged();
        AppMethodBeat.m2505o(39226);
    }

    public final void ctK() {
        AppMethodBeat.m2504i(39228);
        C4990ab.m7410d("MicroMsg.SnsphotoAdapter", "i addSize ");
        m86598kJ(this.list.isEmpty() ? 0 : ((C46236n) this.list.get(this.list.size() - 1)).field_snsId);
        AppMethodBeat.m2505o(39228);
    }

    /* renamed from: kJ */
    private void m86598kJ(long j) {
        C46250as c46250as;
        AppMethodBeat.m2504i(39229);
        String jW = C29036i.m46118jW(C13373af.cnF().mo62925a(j, C13373af.cnv().mo8616Yc(this.userName), this.userName, this.czr));
        if (this.rmL.equals("")) {
            c46250as = this;
        } else if (jW.compareTo(this.rmL) < 0) {
            c46250as = this;
        } else {
            jW = this.rmL;
            c46250as = this;
        }
        c46250as.lQD = jW;
        aao cqL = C13373af.cnJ().mo69179YX(this.userName).cqL();
        if (cqL.wfM == 0) {
            AppMethodBeat.m2505o(39229);
            return;
        }
        jW = C29036i.m46118jW(cqL.wfM);
        if (this.lQD.equals("")) {
            this.lQD = jW;
            AppMethodBeat.m2505o(39229);
            return;
        }
        if (jW.compareTo(this.lQD) <= 0) {
            jW = this.lQD;
        }
        this.lQD = jW;
        AppMethodBeat.m2505o(39229);
    }

    public final Object getItem(int i) {
        AppMethodBeat.m2504i(39230);
        Object obj = this.list.get(i);
        AppMethodBeat.m2505o(39230);
        return obj;
    }

    public final long getItemId(int i) {
        return 0;
    }

    /* renamed from: fv */
    public final ArrayList<C34937b> mo74331fv(int i, int i2) {
        AppMethodBeat.m2504i(39231);
        ArrayList arrayList = new ArrayList();
        this.rvC = i2;
        for (int i3 = 0; i3 < this.list.size(); i3++) {
            C46236n c46236n = (C46236n) this.list.get(i3);
            int i4 = c46236n.reX;
            if (!(c46236n.cqu() == null || c46236n.cqu().xfI == null || c46236n.cqu().xfI.wbK.size() == 0 || (c46236n.cqu().xfI.wbJ != 1 && c46236n.cqu().xfI.wbJ != 15))) {
                if (i4 == i) {
                    this.rvC = arrayList.size();
                }
                Iterator it = c46236n.cqu().xfI.wbK.iterator();
                int i5 = 0;
                while (it.hasNext()) {
                    bau bau = (bau) it.next();
                    C34937b c34937b = new C34937b();
                    c34937b.cNr = bau;
                    c34937b.qQd = C35002v.m57490ap("sns_table_", (long) i4);
                    c34937b.fDG = c46236n.field_createTime;
                    int i6 = i5 + 1;
                    c34937b.qQe = i5;
                    arrayList.add(c34937b);
                    i5 = i6;
                }
            }
        }
        AppMethodBeat.m2505o(39231);
        return arrayList;
    }

    /* renamed from: ZH */
    protected static boolean m86591ZH(String str) {
        AppMethodBeat.m2504i(39232);
        C9058e aih = C37494a.aih();
        if (aih != null && C37494a.m63282d(aih) && str.equals(aih.fJU) && C37494a.aie()) {
            AppMethodBeat.m2505o(39232);
            return true;
        }
        AppMethodBeat.m2505o(39232);
        return false;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(39219);
        int itemViewType = getItemViewType(i);
        C4990ab.m7416i("MicroMsg.SnsphotoAdapter", "position ".concat(String.valueOf(itemViewType)));
        C36816d c36816d;
        int i2;
        C46236n c46236n;
        int i3;
        TimeLineObject cqu;
        String str;
        C4025a c4025a;
        if (itemViewType == 0) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof C36816d)) {
                c36816d = new C36816d();
                view = C5616v.m8409hu(this.czX).inflate(2130970788, null);
                c36816d.rvI = (TextView) view.findViewById(2131827945);
                c36816d.rvH = (TextView) view.findViewById(2131827946);
                c36816d.rvJ = (TextView) view.findViewById(2131827947);
                c36816d.rvS = (MaskImageView) view.findViewById(2131827686);
                c36816d.rvT = (QFadeImageView) view.findViewById(2131827823);
                c36816d.rvU = (MaskImageView) view.findViewById(2131827687);
                c36816d.rvV = (MaskImageView) view.findViewById(2131827688);
                c36816d.qZb = (TextView) view.findViewById(2131821095);
                c36816d.rvW = (TextView) view.findViewById(2131827824);
                c36816d.rvX = (TextView) view.findViewById(2131827829);
                c36816d.rvY = (TextView) view.findViewById(2131827832);
                c36816d.rvZ = (TextView) view.findViewById(2131827827);
                c36816d.rwa = view.findViewById(2131827826);
                c36816d.rvM = (TextView) view.findViewById(2131820733);
                c36816d.rvK = (LinearLayout) view.findViewById(2131827819);
                c36816d.rvL = (ImageView) view.findViewById(2131827820);
                c36816d.rgx = (LinearLayout) view.findViewById(2131827683);
                c36816d.rgy = view.findViewById(2131827682);
                c36816d.rvT.setOnClickListener(this.rvu.rgo);
                c36816d.rvS.setOnClickListener(this.rvu.rgo);
                c36816d.rvU.setOnClickListener(this.rvu.rgp);
                c36816d.rvV.setOnClickListener(this.rvu.rgq);
                c36816d.rvS.setOnLongClickListener(this.rvu.rwl);
                c36816d.rvU.setOnLongClickListener(this.rvu.rwl);
                c36816d.rvV.setOnLongClickListener(this.rvu.rwl);
                c36816d.rwb = (TextView) view.findViewById(2131827825);
                c36816d.rwc = (TextView) view.findViewById(2131827830);
                c36816d.rwd = (TextView) view.findViewById(2131827833);
                c36816d.rwe = (TextView) view.findViewById(2131827822);
                c36816d.rwf = (TextView) view.findViewById(2131827828);
                c36816d.rwg = (TextView) view.findViewById(2131827831);
                c36816d.rwh = (MaskLinearLayout) view.findViewById(2131827821);
                c36816d.rwh.mo8749b(c36816d.rvS);
                c36816d.rvN = (LinearLayout) view.findViewById(2131827817);
                c36816d.rvO = (TextView) view.findViewById(2131827818);
                c36816d.rvO.setOnClickListener(new C136303());
                view.setTag(c36816d);
            } else {
                c36816d = (C36816d) view.getTag();
            }
            C13373af.cnC().mo37462dz(c36816d.rvS);
            C13373af.cnC().mo37462dz(c36816d.rvU);
            C13373af.cnC().mo37462dz(c36816d.rvV);
            i2 = -1;
            if (this.rgf.get(Integer.valueOf(i)) != null) {
                i2 = ((Integer) this.rgf.get(Integer.valueOf(i))).intValue();
            }
            c36816d.init();
            c36816d.rvJ.setTag(Integer.valueOf(i));
            c36816d.rwh.settouchEnable(false);
            c36816d.rwh.setBackgroundResource(0);
            c36816d.rwh.setDescendantFocusability(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            c36816d.rwh.setClickable(false);
            c36816d.rvS.settouchEnable(true);
            c36816d.rvS.setClickable(true);
            c36816d.rvS.setLongClickable(false);
            c36816d.rvU.setLongClickable(false);
            c36816d.rvV.setLongClickable(false);
            c36816d.rwh.setOnClickListener(null);
            c36816d.rwh.setOnLongClickListener(null);
            c36816d.rwh.setLongClickable(false);
            if (i2 >= this.rgi || i2 == -1) {
                view.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
                view.setVisibility(8);
                AppMethodBeat.m2505o(39219);
            } else {
                int intValue;
                if (i2 - 1 >= 0) {
                    c46236n = (C46236n) getItem(i2 - 1);
                    i3 = c46236n.field_head;
                    C34955aj.m57399ab(c46236n.field_localPrivate, this.czr);
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
                C46236n c46236n2 = (C46236n) getItem(i2);
                cqu = c46236n2.cqu();
                if ((this.czr && i == 0) || i3 == -1 || c46236n2.field_head != i3) {
                    m86595a(c36816d.rvH, c36816d.rvI, (long) c46236n2.field_createTime);
                    if (cqu.xfG != null) {
                        str = cqu.xfG.guP;
                        if (!(str == null || str.equals(""))) {
                            c36816d.rvM.setText(str);
                            c36816d.rvM.setVisibility(0);
                        }
                    }
                    c36816d.rgy.setVisibility(0);
                }
                m86594a(c36816d.rvJ, i3, c46236n2.field_head);
                if (this.rvB != 0 && c46236n2.field_snsId == this.rvB) {
                    c36816d.rvN.setVisibility(0);
                } else if (this.rvB != 0 || this.rvA == 0 || c46236n2.field_snsId > this.rvA) {
                    c36816d.rvN.setVisibility(8);
                } else {
                    c36816d.rvN.setVisibility(0);
                    this.rvB = c46236n2.field_snsId;
                }
                c36816d.rvK.setVisibility(0);
                if (this.czr && i == 0) {
                    c36816d.rvT.setVisibility(0);
                    c36816d.rvT.setContentDescription(this.czX.getString(C25738R.string.epj));
                    c36816d.rvS.setVisibility(8);
                    c36816d.qZb.setText(this.rgh == 1 ? this.czX.getString(C25738R.string.eqk) : "");
                    c36816d.qZb.setVisibility(0);
                    c36816d.rwa.setVisibility(0);
                    c36816d.rvZ.setVisibility(8);
                    C13373af.cnC().mo37438a(c36816d.rvT, (int) C25738R.color.a1_, (int) C25738R.drawable.a1l, this.czX.hashCode());
                    c4025a = new C4025a();
                    c4025a.cNE = -1;
                    c4025a.position = -1;
                    c36816d.rvT.setTag(c4025a);
                    AppMethodBeat.m2505o(39219);
                } else {
                    if (intValue > 0) {
                        m86593a(i2, c36816d.rvS, c36816d.rvW, c36816d.rvZ, c36816d.rwb, c36816d.rwe, 1, c36816d, i);
                    }
                    if (intValue >= 2) {
                        m86593a(i2 + 1, c36816d.rvU, c36816d.rvX, c36816d.rvZ, c36816d.rwc, c36816d.rwf, 2, c36816d, i);
                    }
                    if (intValue >= 3) {
                        m86593a(i2 + 2, c36816d.rvV, c36816d.rvY, c36816d.rvZ, c36816d.rwd, c36816d.rwg, 3, c36816d, i);
                    }
                    if (intValue == 1) {
                        c46236n = (C46236n) getItem(i2);
                        if (!C5046bo.isNullOrNil(c46236n.cqu().xfF) && c46236n.field_type == 1) {
                            c36816d.rwh.setDescendantFocusability(393216);
                            c36816d.rwh.setClickable(true);
                            c36816d.rvS.setClickable(false);
                            c36816d.rvS.settouchEnable(false);
                            c36816d.rwh.setOnClickListener(this.rvu.rgo);
                            c36816d.rwh.settouchEnable(true);
                            i2 = c46236n2.reX;
                            C4025a c4025a2 = new C4025a();
                            c4025a2.cNE = i2;
                            if (this.rvt.get(Integer.valueOf(i)) != null) {
                                c4025a2.position = ((Integer) this.rvt.get(Integer.valueOf(i))).intValue();
                            } else {
                                c4025a2.position = 0;
                            }
                            if (c46236n.cnn() && c46236n.cqW()) {
                                c36816d.rwh.setOnLongClickListener(this.rvu.rwl);
                            }
                            c36816d.rwh.setTag(c4025a2);
                        }
                    }
                    view.setDrawingCacheEnabled(false);
                    AppMethodBeat.m2505o(39219);
                }
            }
        } else {
            C4025a c4025a3;
            if (itemViewType == 2) {
                C4016e c4016e;
                int intValue2;
                if (view == null || view.getTag() == null || !(view.getTag() instanceof C4016e)) {
                    C4016e c4016e2 = new C4016e();
                    view = C5616v.m8409hu(this.czX).inflate(2130970800, null);
                    c4016e2.rvI = (TextView) view.findViewById(2131827945);
                    c4016e2.rvH = (TextView) view.findViewById(2131827946);
                    c4016e2.rvJ = (TextView) view.findViewById(2131827947);
                    c4016e2.rvS = (MaskImageView) view.findViewById(2131827686);
                    c4016e2.rvM = (TextView) view.findViewById(2131820733);
                    c4016e2.rvK = (LinearLayout) view.findViewById(2131827819);
                    c4016e2.rvL = (ImageView) view.findViewById(2131827820);
                    c4016e2.rgx = (LinearLayout) view.findViewById(2131827683);
                    c4016e2.rgy = view.findViewById(2131827682);
                    c4016e2.rvS.setOnClickListener(this.rvu.rwk);
                    c4016e2.rwb = (TextView) view.findViewById(2131827825);
                    c4016e2.rwh = (MaskLinearLayout) view.findViewById(2131827821);
                    c4016e2.rwh.mo8749b(c4016e2.rvS);
                    c4016e2.qZb = (TextView) view.findViewById(2131821095);
                    c4016e2.rwa = view.findViewById(2131827826);
                    c4016e2.rvN = (LinearLayout) view.findViewById(2131827817);
                    c4016e2.rvO = (TextView) view.findViewById(2131827818);
                    c4016e2.rvO.setOnClickListener(new C291912());
                    view.setTag(c4016e2);
                    c4016e = c4016e2;
                } else {
                    c4016e = (C4016e) view.getTag();
                }
                C13373af.cnC().mo37462dz(c4016e.rvS);
                if (this.rgf.get(Integer.valueOf(i)) != null) {
                    intValue2 = ((Integer) this.rgf.get(Integer.valueOf(i))).intValue();
                } else {
                    intValue2 = -1;
                }
                c4016e.init();
                c4016e.rvJ.setTag(Integer.valueOf(i));
                c4016e.rwh.settouchEnable(false);
                c4016e.rwh.setBackgroundResource(0);
                c4016e.rwh.setDescendantFocusability(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                c4016e.rwh.setClickable(false);
                c4016e.rvS.settouchEnable(true);
                c4016e.rvS.setClickable(true);
                c4016e.rwh.setOnClickListener(null);
                if (intValue2 >= this.rgi || intValue2 == -1) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
                    view.setVisibility(8);
                    AppMethodBeat.m2505o(39219);
                } else {
                    if (intValue2 - 1 >= 0) {
                        c46236n = (C46236n) getItem(intValue2 - 1);
                        i2 = c46236n.field_head;
                        C34955aj.m57399ab(c46236n.field_localPrivate, this.czr);
                    } else {
                        i2 = -1;
                    }
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                    view.setVisibility(0);
                    if (this.rgg.get(Integer.valueOf(i)) != null) {
                        ((Integer) this.rgg.get(Integer.valueOf(i))).intValue();
                    }
                    C46236n c46236n3 = (C46236n) getItem(intValue2);
                    TimeLineObject cqu2 = c46236n3.cqu();
                    if ((this.czr && i == 0) || i2 == -1 || c46236n3.field_head != i2) {
                        m86595a(c4016e.rvH, c4016e.rvI, (long) c46236n3.field_createTime);
                        if (cqu2.xfG != null) {
                            str = cqu2.xfG.guP;
                            if (!(str == null || str.equals(""))) {
                                c4016e.rvM.setText(str);
                                c4016e.rvM.setVisibility(0);
                            }
                        }
                        c4016e.rgy.setVisibility(0);
                    }
                    m86594a(c4016e.rvJ, i2, c46236n3.field_head);
                    if (this.rvB != 0 && c46236n3.field_snsId == this.rvB) {
                        c4016e.rvN.setVisibility(0);
                    } else if (this.rvB != 0 || this.rvA == 0 || c46236n3.field_snsId > this.rvA) {
                        c4016e.rvN.setVisibility(8);
                    } else {
                        c4016e.rvN.setVisibility(0);
                        this.rvB = c46236n3.field_snsId;
                    }
                    c4016e.rvK.setVisibility(0);
                    C44222az c44222az = new C44222az(this.rvs.tag);
                    c44222az.oyB = c46236n3.field_createTime;
                    c4016e.rvS.setVisibility(0);
                    C13373af.cnC().mo37444a(cqu2.xfI.wbK, c4016e.rvS, this.czX.hashCode(), C21934a.IMG_SCENE_SNSSUSER, c44222az);
                    if (C34955aj.m57399ab(c46236n3.field_localPrivate, this.czr)) {
                        c4016e.rwb.setVisibility(0);
                        c4016e.rwb.setBackgroundResource(C25738R.drawable.al2);
                        C7616ad aoO = this.rqa.aoO(c46236n3.field_userName);
                        if (aoO != null) {
                            aoO.mo16707Oj();
                        }
                    }
                    CharSequence charSequence = ((C46236n) getItem(intValue2)).cqu().xfF;
                    if (!(charSequence == null || charSequence.equals(""))) {
                        c4016e.rwa.setVisibility(0);
                        c4016e.qZb.setVisibility(0);
                        c4016e.qZb.setText(String.valueOf(charSequence));
                        c4016e.qZb.setText(C44089j.m79293b(this.czX, charSequence, c4016e.qZb.getTextSize()));
                    }
                    c4016e.rwh.setDescendantFocusability(393216);
                    c4016e.rwh.setClickable(true);
                    c4016e.rvS.setClickable(false);
                    c4016e.rvS.settouchEnable(false);
                    c4016e.rwh.setOnClickListener(this.rvu.rwk);
                    c4016e.rwh.settouchEnable(true);
                    itemViewType = c46236n3.reX;
                    c4025a3 = new C4025a();
                    c4025a3.cNE = itemViewType;
                    if (this.rvt.get(Integer.valueOf(i)) != null) {
                        c4025a3.position = ((Integer) this.rvt.get(Integer.valueOf(i))).intValue();
                    } else {
                        c4025a3.position = 0;
                    }
                    c4016e.rwh.setTag(c4025a3);
                }
            } else if (itemViewType == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof C36816d)) {
                    c36816d = new C36816d();
                    view = C5616v.m8409hu(this.czX).inflate(2130970788, null);
                    c36816d.rvI = (TextView) view.findViewById(2131827945);
                    c36816d.rvH = (TextView) view.findViewById(2131827946);
                    c36816d.rvJ = (TextView) view.findViewById(2131827947);
                    c36816d.rvS = (MaskImageView) view.findViewById(2131827686);
                    c36816d.rvT = (QFadeImageView) view.findViewById(2131827823);
                    c36816d.rvU = (MaskImageView) view.findViewById(2131827687);
                    c36816d.rvV = (MaskImageView) view.findViewById(2131827688);
                    c36816d.qZb = (TextView) view.findViewById(2131821095);
                    c36816d.rvW = (TextView) view.findViewById(2131827824);
                    c36816d.rvX = (TextView) view.findViewById(2131827829);
                    c36816d.rvY = (TextView) view.findViewById(2131827832);
                    c36816d.rvZ = (TextView) view.findViewById(2131827827);
                    c36816d.rwa = view.findViewById(2131827826);
                    c36816d.rvM = (TextView) view.findViewById(2131820733);
                    c36816d.rvK = (LinearLayout) view.findViewById(2131827819);
                    c36816d.rvL = (ImageView) view.findViewById(2131827820);
                    c36816d.rgx = (LinearLayout) view.findViewById(2131827683);
                    c36816d.rgy = view.findViewById(2131827682);
                    c36816d.rvT.setOnClickListener(this.rvu.rwj);
                    c36816d.rvS.setOnClickListener(this.rvu.rwj);
                    c36816d.rwb = (TextView) view.findViewById(2131827825);
                    c36816d.rwc = (TextView) view.findViewById(2131827830);
                    c36816d.rwd = (TextView) view.findViewById(2131827833);
                    c36816d.rwe = (TextView) view.findViewById(2131827822);
                    c36816d.rwf = (TextView) view.findViewById(2131827828);
                    c36816d.rwg = (TextView) view.findViewById(2131827831);
                    c36816d.rwh = (MaskLinearLayout) view.findViewById(2131827821);
                    c36816d.rwh.mo8749b(c36816d.rvS);
                    c36816d.rvN = (LinearLayout) view.findViewById(2131827817);
                    c36816d.rvO = (TextView) view.findViewById(2131827818);
                    c36816d.rvO.setOnClickListener(new C291925());
                    view.setTag(c36816d);
                } else {
                    c36816d = (C36816d) view.getTag();
                }
                C13373af.cnC().mo37462dz(c36816d.rvS);
                C13373af.cnC().mo37462dz(c36816d.rvU);
                C13373af.cnC().mo37462dz(c36816d.rvV);
                i2 = -1;
                if (this.rgf.get(Integer.valueOf(i)) != null) {
                    i2 = ((Integer) this.rgf.get(Integer.valueOf(i))).intValue();
                }
                c36816d.init();
                c36816d.rvJ.setTag(Integer.valueOf(i));
                c36816d.rwh.settouchEnable(false);
                c36816d.rwh.setBackgroundResource(0);
                c36816d.rwh.setDescendantFocusability(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                c36816d.rwh.setClickable(false);
                c36816d.rvS.settouchEnable(true);
                c36816d.rvS.setClickable(true);
                c36816d.rwh.setOnClickListener(null);
                if (i2 >= this.rgi || i2 == -1) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
                    view.setVisibility(8);
                    AppMethodBeat.m2505o(39219);
                } else {
                    if (i2 - 1 >= 0) {
                        c46236n = (C46236n) getItem(i2 - 1);
                        i3 = c46236n.field_head;
                        C34955aj.m57399ab(c46236n.field_localPrivate, this.czr);
                    } else {
                        i3 = -1;
                    }
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                    view.setVisibility(0);
                    C46236n c46236n4 = (C46236n) getItem(i2);
                    cqu = c46236n4.cqu();
                    if ((this.czr && i == 0) || i3 == -1 || c46236n4.field_head != i3) {
                        m86595a(c36816d.rvH, c36816d.rvI, (long) c46236n4.field_createTime);
                        if (cqu.xfG != null) {
                            str = cqu.xfG.guP;
                            if (!(str == null || str.equals(""))) {
                                c36816d.rvM.setText(str);
                                c36816d.rvM.setVisibility(0);
                            }
                        }
                        c36816d.rgy.setVisibility(0);
                    }
                    m86594a(c36816d.rvJ, i3, c46236n4.field_head);
                    if (this.rvB != 0 && c46236n4.field_snsId == this.rvB) {
                        c36816d.rvN.setVisibility(0);
                    } else if (this.rvB != 0 || this.rvA == 0 || c46236n4.field_snsId > this.rvA) {
                        c36816d.rvN.setVisibility(8);
                    } else {
                        c36816d.rvN.setVisibility(0);
                        this.rvB = c46236n4.field_snsId;
                    }
                    c36816d.rvK.setVisibility(0);
                    if (this.czr && i == 0) {
                        c36816d.rvT.setVisibility(0);
                        c36816d.rvT.setContentDescription(this.czX.getString(C25738R.string.epj));
                        c36816d.rvS.setVisibility(8);
                        c36816d.qZb.setText(this.rgh == 1 ? this.czX.getString(C25738R.string.eqk) : "");
                        c36816d.qZb.setVisibility(0);
                        c36816d.rwa.setVisibility(0);
                        c36816d.rvZ.setVisibility(8);
                        C13373af.cnC().mo37438a(c36816d.rvT, (int) C25738R.color.a1_, (int) C25738R.drawable.a1l, this.czX.hashCode());
                        c4025a = new C4025a();
                        c4025a.cNE = -1;
                        c4025a.position = -1;
                        c36816d.rvT.setTag(c4025a);
                        AppMethodBeat.m2505o(39219);
                    } else {
                        m86593a(i2, c36816d.rvS, c36816d.rvW, c36816d.rvZ, c36816d.rwb, c36816d.rwe, 1, c36816d, i);
                        c46236n = (C46236n) getItem(i2);
                        if (!C5046bo.isNullOrNil(c46236n.cqu().xfF) && c46236n.field_type == 1) {
                            c36816d.rwh.setDescendantFocusability(393216);
                            c36816d.rwh.setClickable(true);
                            c36816d.rvS.setClickable(false);
                            c36816d.rvS.settouchEnable(false);
                            c36816d.rwh.setOnClickListener(this.rvu.rwj);
                            c36816d.rwh.settouchEnable(true);
                            itemViewType = c46236n4.reX;
                            c4025a3 = new C4025a();
                            c4025a3.cNE = itemViewType;
                            if (this.rvt.get(Integer.valueOf(i)) != null) {
                                c4025a3.position = ((Integer) this.rvt.get(Integer.valueOf(i))).intValue();
                            } else {
                                c4025a3.position = 0;
                            }
                            c36816d.rwh.setTag(c4025a3);
                        }
                        view.setDrawingCacheEnabled(false);
                        AppMethodBeat.m2505o(39219);
                    }
                }
            } else {
                C36815b c36815b;
                if (view == null || view.getTag() == null || !(view.getTag() instanceof C36815b)) {
                    C36815b c36815b2 = new C36815b();
                    view = C5616v.m8409hu(this.czX).inflate(2130970787, null);
                    c36815b2.rvG = view.findViewById(2131821839);
                    c36815b2.rvI = (TextView) view.findViewById(2131827945);
                    c36815b2.rvH = (TextView) view.findViewById(2131827946);
                    c36815b2.rvJ = (TextView) view.findViewById(2131827947);
                    c36815b2.rvM = (TextView) view.findViewById(2131820733);
                    c36815b2.rgy = view.findViewById(2131827682);
                    c36815b2.rvM = (TextView) view.findViewById(2131820733);
                    c36815b2.rvK = (LinearLayout) view.findViewById(2131827819);
                    c36815b2.rvL = (ImageView) view.findViewById(2131827820);
                    c36815b2.rgx = (LinearLayout) view.findViewById(2131827683);
                    c36815b2.hrg = (TextView) view.findViewById(2131820991);
                    c36815b2.rvP = (TagImageView) view.findViewById(2131825687);
                    c36815b2.rhd = (ImageView) view.findViewById(2131824637);
                    c36815b2.gne = (TextView) view.findViewById(2131825689);
                    c36815b2.rvQ = (TextView) view.findViewById(2131825690);
                    c36815b2.rvG.setOnClickListener(this.rvu.rwi);
                    c36815b2.rvR = view.findViewById(2131827798);
                    c36815b2.rvN = (LinearLayout) view.findViewById(2131827817);
                    c36815b2.rvO = (TextView) view.findViewById(2131827818);
                    c36815b2.rvO.setOnClickListener(new C136314());
                    view.setTag(c36815b2);
                    C29036i.m46100b(c36815b2.rvP, this.czX);
                    c36815b = c36815b2;
                } else {
                    c36815b = (C36815b) view.getTag();
                }
                c36815b.rvJ.setTag(Integer.valueOf(i));
                if (this.rgf.get(Integer.valueOf(i)) != null) {
                    i2 = ((Integer) this.rgf.get(Integer.valueOf(i))).intValue();
                } else {
                    i2 = -1;
                }
                c36815b.init();
                if (i2 >= this.rgi || i2 == -1) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
                    view.setVisibility(8);
                    AppMethodBeat.m2505o(39219);
                } else {
                    view.setVisibility(0);
                    if (i2 - 1 >= 0) {
                        c46236n = (C46236n) getItem(i2 - 1);
                        i3 = c46236n.field_head;
                        C34955aj.m57399ab(c46236n.field_localPrivate, this.czr);
                    } else {
                        i3 = -1;
                    }
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                    view.setVisibility(0);
                    if (this.rgg.get(Integer.valueOf(i)) != null) {
                        ((Integer) this.rgg.get(Integer.valueOf(i))).intValue();
                    }
                    C46236n c46236n5 = (C46236n) getItem(i2);
                    TimeLineObject cqu3 = c46236n5.cqu();
                    if ((this.czr && i == 0) || i3 == -1 || c46236n5.field_head != i3) {
                        m86595a(c36815b.rvH, c36815b.rvI, (long) c46236n5.field_createTime);
                        if (cqu3.xfG != null) {
                            str = cqu3.xfG.guP;
                            if (!(str == null || str.equals(""))) {
                                c36815b.rvM.setText(str);
                                c36815b.rvM.setVisibility(0);
                            }
                        }
                        c36815b.rgy.setVisibility(0);
                    }
                    m86594a(c36815b.rvJ, i3, c46236n5.field_head);
                    if (this.rvB != 0 && c46236n5.field_snsId == this.rvB) {
                        c36815b.rvN.setVisibility(0);
                    } else if (this.rvB != 0 || this.rvA == 0 || c46236n5.field_snsId > this.rvA) {
                        c36815b.rvN.setVisibility(8);
                    } else {
                        c36815b.rvN.setVisibility(0);
                        this.rvB = c46236n5.field_snsId;
                    }
                    C4025a c4025a4 = new C4025a();
                    c4025a4.cNE = c46236n5.reX;
                    if (this.rvt.get(Integer.valueOf(i)) != null) {
                        c4025a4.position = ((Integer) this.rvt.get(Integer.valueOf(i))).intValue();
                    } else {
                        c4025a4.position = 0;
                    }
                    c36815b.rvG.setTag(c4025a4);
                    if (C5046bo.isNullOrNil(cqu3.xfF)) {
                        c36815b.hrg.setVisibility(8);
                    } else {
                        c36815b.hrg.setVisibility(0);
                        c36815b.hrg.setText(cqu3.xfF);
                        c36815b.hrg.setText(C44089j.m79293b(this.czX, cqu3.xfF, c36815b.hrg.getTextSize()));
                    }
                    c36815b.rvK.setVisibility(0);
                    c36815b.hrg.setSingleLine(true);
                    c36815b.rvR.setVisibility(0);
                    itemViewType = cqu3.xfI.wbJ;
                    C44222az c44222az2 = new C44222az(this.rvs.tag);
                    c44222az2.oyB = c46236n5.field_createTime;
                    bau bau;
                    if (itemViewType == 2) {
                        c36815b.hrg.setVisibility(0);
                        c36815b.hrg.setSingleLine(false);
                        c36815b.hrg.setMaxLines(2);
                        c36815b.rvR.setVisibility(8);
                    } else if (itemViewType != 4) {
                        Object obj;
                        String str2;
                        c36815b.gne.setTextColor(this.czX.getResources().getColor(C25738R.color.f12294z4));
                        if ((C3890a.coe() & 1) <= 0) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        String ZI = obj != null ? C46251au.m86603ZI(cqu3.xfI.Url) : "";
                        str = cqu3.xfI.Title;
                        if (str == null || str.length() <= 40) {
                            str2 = str;
                        } else {
                            str2 = str.substring(0, 40) + "...";
                        }
                        if (c36815b.rvP != null) {
                            c36815b.rvP.setOnClickListener(null);
                        }
                        c36815b.rhd.setVisibility(8);
                        if (!cqu3.xfI.wbK.isEmpty()) {
                            c36815b.rvP.setVisibility(0);
                            bau = (bau) cqu3.xfI.wbK.get(0);
                            if (cqu3.xfI.wbJ == 5) {
                                ZI = C46251au.m86603ZI(bau.Url);
                                str2 = bau.Title;
                                c36815b.rhd.setVisibility(0);
                                C13373af.cnC().mo37439a(bau, c36815b.rvP, (int) C1318a.app_attach_file_icon_video, this.czX.hashCode(), C21934a.IMG_SCENE_SNSSUSER, c44222az2);
                            } else {
                                C13373af.cnC().mo37441a(bau, c36815b.rvP, this.czX.hashCode(), C21934a.IMG_SCENE_SNSSUSER, c44222az2);
                            }
                        } else if (cqu3.xfI.wbJ != 26) {
                            c36815b.rvP.setVisibility(8);
                        } else {
                            c36815b.rvP.setVisibility(0);
                            c36815b.rvP.setImageResource(C1318a.note_sns_link_default);
                        }
                        if (C5046bo.isNullOrNil(ZI)) {
                            c36815b.rvQ.setVisibility(8);
                        } else {
                            c36815b.rvQ.setVisibility(0);
                            c36815b.rvQ.setText(ZI);
                        }
                        if (C5046bo.isNullOrNil(str2)) {
                            c36815b.gne.setVisibility(8);
                        } else {
                            if (c36815b.rvQ.getVisibility() == 8) {
                                c36815b.gne.setMaxLines(2);
                            } else {
                                c36815b.gne.setMaxLines(1);
                            }
                            c36815b.gne.setVisibility(0);
                            if ((cqu3.fgt & 1) > 0) {
                                c36815b.gne.setText(C29036i.m46097a(str2, this.czX, c36815b.gne));
                            } else {
                                c36815b.gne.setText(str2);
                            }
                        }
                    } else if (cqu3.xfI.wbK.isEmpty()) {
                        c36815b.rvR.setVisibility(8);
                    } else {
                        c36815b.rvP.setVisibility(0);
                        c36815b.rhd.setVisibility(0);
                        c36815b.rvR.setVisibility(0);
                        c36815b.gne.setMaxLines(1);
                        c36815b.gne.setTextColor(this.czX.getResources().getColor(C25738R.color.a0k));
                        bau = (bau) cqu3.xfI.wbK.get(0);
                        C13373af.cnC().mo37439a(bau, c36815b.rvP, (int) C1318a.app_attach_file_icon_music, this.czX.hashCode(), C21934a.IMG_SCENE_SNSSUSER, c44222az2);
                        c36815b.rhd.setPressed(false);
                        if (C46250as.m86591ZH(cqu3.f15074Id)) {
                            c36815b.rhd.setImageResource(C25738R.drawable.f6930vq);
                        } else {
                            c36815b.rhd.setImageResource(C25738R.drawable.f6932vs);
                        }
                        c36815b.rvP.setTag(cqu3);
                        c36815b.rvP.setOnClickListener(this.rvD);
                        bau.cNE = c46236n5.reX;
                        c36815b.rvR.setTag(cqu3);
                        str = bau.Desc;
                        if (C5046bo.isNullOrNil(str)) {
                            c36815b.rvQ.setVisibility(4);
                        } else {
                            c36815b.rvQ.setVisibility(0);
                            c36815b.rvQ.setText(str);
                        }
                        str = bau.Title;
                        if (C5046bo.isNullOrNil(str)) {
                            c36815b.gne.setVisibility(8);
                        } else {
                            c36815b.gne.setVisibility(0);
                            c36815b.gne.setTag(c4025a4);
                            c36815b.gne.setOnTouchListener(new C46247aa());
                            c36815b.gne.setText(str);
                        }
                    }
                }
            }
            view.setDrawingCacheEnabled(false);
            AppMethodBeat.m2505o(39219);
        }
        return view;
    }

    public final void crP() {
        AppMethodBeat.m2504i(39227);
        m86599ll(true);
        notifyDataSetChanged();
        AppMethodBeat.m2505o(39227);
    }
}

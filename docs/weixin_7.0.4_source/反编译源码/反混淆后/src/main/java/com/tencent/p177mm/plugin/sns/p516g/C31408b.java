package com.tencent.p177mm.plugin.sns.p516g;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.data.C34935b;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C29057e;
import com.tencent.p177mm.plugin.sns.model.C46224r;
import com.tencent.p177mm.plugin.sns.model.C7101u;
import com.tencent.p177mm.plugin.sns.p1024b.C13356c;
import com.tencent.p177mm.plugin.sns.p520ui.C4052bb;
import com.tencent.p177mm.plugin.sns.p520ui.SnsCommentUI;
import com.tencent.p177mm.plugin.sns.p520ui.p526d.C22089b;
import com.tencent.p177mm.plugin.sns.storage.C21980a;
import com.tencent.p177mm.plugin.sns.storage.C21984b;
import com.tencent.p177mm.plugin.sns.storage.C21991i;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.pluginsdk.C30036f;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5141c;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.sns.g.b */
public final class C31408b implements C29057e {
    private boolean cwB = true;
    Context mContext;
    private int qDY = -1;
    public final int qOK = 14;
    private C22089b qOL;
    private FrameLayout qOM;
    AbsoluteLayout qON = null;
    protected Animation qOO;
    protected Animation qOP;
    boolean qOQ = false;
    int[] qOR = new int[]{C25738R.string.eip, C25738R.string.eiq, C25738R.string.eir, C25738R.string.eis};
    private int[] qOS = new int[]{C1318a.album_test_donotlook, C1318a.album_test_unlike, C1318a.album_test_open, C1318a.album_test_close};
    private int[] qOT = this.qOR;
    private int[] qOU;
    private int[] qOV;
    Map<Long, C3870b> qOW = new HashMap();
    private Map<Long, C3870b> qOX = new HashMap();
    private HashSet<Long> qOY = new HashSet();
    C39736h qOZ = null;
    private HashMap<Long, Boolean> qPa = new HashMap();

    /* renamed from: com.tencent.mm.plugin.sns.g.b$b */
    static class C3870b {
        long qDh;
        StringBuffer qPi = new StringBuffer();
        String qPj;
        long qPk;
        long qPl;
        String qPm;
        String qPn;

        public C3870b(long j, String str, String str2, String str3, String str4) {
            AppMethodBeat.m2504i(36761);
            this.qPj = str;
            this.qPm = str2;
            this.qPn = str3;
            this.qDh = j;
            this.qPk = System.currentTimeMillis();
            this.qPi.append("1:0:".concat(String.valueOf(str4)));
            AppMethodBeat.m2505o(36761);
        }

        public C3870b(long j, String str, String str2, String str3) {
            AppMethodBeat.m2504i(36762);
            this.qPj = str;
            this.qPm = str2;
            this.qPn = str3;
            this.qDh = j;
            this.qPk = System.currentTimeMillis();
            this.qPi.append("0:0:");
            AppMethodBeat.m2505o(36762);
        }

        /* renamed from: YA */
        public final void mo8588YA(String str) {
            AppMethodBeat.m2504i(36763);
            C4990ab.m7410d("MicroMsg.AdNotLikeAbTestHelper", "addactionResult ".concat(String.valueOf(str)));
            if (this.qPi.length() != 0) {
                this.qPi.append("|");
            }
            this.qPi.append(str);
            AppMethodBeat.m2505o(36763);
        }

        public final boolean coy() {
            AppMethodBeat.m2504i(36764);
            if (this.qPi == null || this.qPi.length() == 0) {
                AppMethodBeat.m2505o(36764);
                return false;
            } else if (this.qPi.toString().startsWith("1:0")) {
                AppMethodBeat.m2505o(36764);
                return true;
            } else {
                AppMethodBeat.m2505o(36764);
                return false;
            }
        }

        public final boolean coz() {
            AppMethodBeat.m2504i(36765);
            if (this.qPi == null || this.qPi.length() == 0) {
                AppMethodBeat.m2505o(36765);
                return false;
            }
            AppMethodBeat.m2505o(36765);
            return true;
        }

        /* renamed from: IF */
        public final void mo8587IF() {
            AppMethodBeat.m2504i(36766);
            this.qPl = System.currentTimeMillis();
            C4990ab.m7410d("MicroMsg.AdNotLikeAbTestHelper", "report abtestnotlike " + this.qDh + " uxinfo:" + this.qPj + " actionresult: " + this.qPi + " " + this.qPk + " " + this.qPl);
            C7060h.pYm.mo8381e(11988, this.qPn, this.qPm, "", "", C29036i.m46117jV(this.qDh), this.qPj, this.qPi, Long.valueOf(this.qPk / 1000), Long.valueOf(this.qPl / 1000));
            AppMethodBeat.m2505o(36766);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.g.b$a */
    class C21883a {
        long cND;
        View qCZ = null;
        String qPg;
        C21984b qPh;

        public C21883a(String str, View view, long j, C21984b c21984b) {
            this.qPg = str;
            this.qCZ = view;
            this.qPh = c21984b;
            this.cND = j;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.g.b$4 */
    class C314104 implements AnimationListener {
        C314104() {
        }

        public final void onAnimationStart(Animation animation) {
            C31408b.this.qOQ = true;
        }

        public final void onAnimationEnd(Animation animation) {
            C31408b.this.qOQ = false;
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    /* renamed from: a */
    public final void mo37369a(int i, String str, long j, TimeLineObject timeLineObject, boolean z, C4052bb c4052bb) {
        AppMethodBeat.m2504i(36767);
        if (z && this.cwB && this.qOZ != null && c4052bb != null) {
            this.qOY.add(Long.valueOf(j));
            this.qOX.put(Long.valueOf(j), new C3870b(j, this.qOZ.qPm, this.qOZ.qPn, c4052bb.cuH()));
        }
        AppMethodBeat.m2505o(36767);
    }

    /* renamed from: a */
    public final void mo37368a(int i, String str, long j, TimeLineObject timeLineObject, boolean z) {
        AppMethodBeat.m2504i(36768);
        if (z && this.cwB) {
            if (this.qOY.contains(Long.valueOf(j))) {
                boolean z2 = false;
                if (this.qPa.containsKey(Long.valueOf(j))) {
                    z2 = ((Boolean) this.qPa.get(Long.valueOf(j))).booleanValue();
                }
                if (z2) {
                    C3870b c3870b = (C3870b) this.qOX.get(Long.valueOf(j));
                    if (c3870b != null) {
                        c3870b.mo8587IF();
                    }
                }
            }
            this.qOX.remove(Long.valueOf(j));
            this.qOY.remove(Long.valueOf(j));
        }
        AppMethodBeat.m2505o(36768);
    }

    /* renamed from: a */
    public final void mo51354a(C3870b c3870b) {
        AppMethodBeat.m2504i(36769);
        this.qOW.remove(Long.valueOf(c3870b.qDh));
        c3870b.mo8587IF();
        AppMethodBeat.m2505o(36769);
    }

    public C31408b(Context context, C22089b c22089b, FrameLayout frameLayout) {
        AppMethodBeat.m2504i(36770);
        C43543g cnx = C13373af.cnx();
        C39736h c39736h = new C39736h();
        C5141c ll = C18624c.abi().mo17131ll("100007");
        if (ll.isValid()) {
            Map dru = ll.dru();
            if (dru != null) {
                C4990ab.m7416i("MicroMsg.SnsABTestStrategy", "snsabtest feed " + ll.field_expId + " " + ll.field_layerId + " " + ll.field_startTime + " " + ll.field_endTime);
                c39736h.mo62708h(ll.field_layerId, ll.field_expId, dru);
            }
        } else {
            C4990ab.m7416i("MicroMsg.SnsABTestStrategy", "abtest is invalid");
            c39736h = null;
        }
        cnx.qQa = c39736h;
        this.qOZ = C13373af.cnx().coB();
        if (this.qOZ != null) {
            this.qOU = this.qOZ.qQc;
            if (!this.qOZ.coC()) {
                this.cwB = false;
            }
        }
        this.mContext = context;
        this.qOL = c22089b;
        this.qOM = frameLayout;
        this.qOO = new ScaleAnimation(1.0f, 1.0f, 0.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.qOO = AnimationUtils.loadAnimation(context, C25738R.anim.f8316al);
        this.qOP = new ScaleAnimation(1.0f, 1.0f, 1.0f, 0.0f, 1, 1.0f, 1, 0.0f);
        this.qOP = AnimationUtils.loadAnimation(context, C25738R.anim.f8317am);
        AppMethodBeat.m2505o(36770);
    }

    /* renamed from: dC */
    public final int mo51356dC(View view) {
        AppMethodBeat.m2504i(36771);
        if (this.qOQ) {
            AppMethodBeat.m2505o(36771);
            return 0;
        } else if (this.qON != null) {
            if (this.qON.getTag() instanceof C21883a) {
                final View view2 = ((C21883a) this.qON.getTag()).qCZ;
                this.qOQ = true;
                view2.startAnimation(this.qOP);
                this.qOP.setAnimationListener(new AnimationListener() {
                    public final void onAnimationStart(Animation animation) {
                        C31408b.this.qOQ = true;
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.m2504i(36760);
                        if (view2 != null) {
                            view2.clearAnimation();
                            view2.setVisibility(8);
                            C31408b.this.cox();
                        }
                        C31408b.this.qOQ = false;
                        AppMethodBeat.m2505o(36760);
                    }
                });
            } else {
                cox();
            }
            AppMethodBeat.m2505o(36771);
            return 0;
        } else if (view.getTag() == null || !(view.getTag() instanceof C34935b)) {
            AppMethodBeat.m2505o(36771);
            return 0;
        } else if (!this.cwB || this.qOZ == null) {
            AppMethodBeat.m2505o(36771);
            return 2;
        } else {
            int i;
            int i2;
            boolean z;
            C34935b c34935b = (C34935b) view.getTag();
            long j = c34935b.cND;
            C21984b c21984b = c34935b.qFH.rDm;
            if (!this.qPa.containsKey(Long.valueOf(j))) {
                if (this.qOZ != null) {
                    if (c21984b != null) {
                        i = 0;
                        while (true) {
                            i2 = i;
                            if (i2 >= this.qOZ.qPP.size()) {
                                this.qPa.put(Long.valueOf(j), Boolean.TRUE);
                                z = true;
                                break;
                            } else if (C5046bo.isNullOrNil(C31408b.m50796a((C21882a) this.qOZ.qPP.get(i2), c21984b.qUD))) {
                                this.qPa.put(Long.valueOf(j), Boolean.FALSE);
                                z = false;
                                break;
                            } else {
                                i = i2 + 1;
                            }
                        }
                    } else {
                        z = false;
                    }
                } else {
                    z = false;
                }
            } else {
                z = ((Boolean) this.qPa.get(Long.valueOf(j))).booleanValue();
            }
            if (z) {
                int i3;
                String str = c34935b.cwT;
                this.qOW.put(Long.valueOf(c34935b.cND), new C3870b(c34935b.cND, c34935b.qFH.cuH(), this.qOZ.qPm, this.qOZ.qPn, this.mContext.getString(C25738R.string.ejb)));
                if (this.qOY.contains(Long.valueOf(c34935b.cND))) {
                    this.qOY.remove(Long.valueOf(c34935b.cND));
                }
                this.qON = new AbsoluteLayout(this.mContext);
                this.qON.setId(2131820733);
                LayoutParams layoutParams = new LayoutParams(-1, -1);
                this.qOM.addView(this.qON);
                final View inflate = C5616v.m8409hu(this.mContext).inflate(2130968634, null);
                r12 = new TextView[3];
                ImageView[] imageViewArr = new ImageView[]{(TextView) inflate.findViewById(2131821036), (TextView) inflate.findViewById(2131821038), (TextView) inflate.findViewById(2131821040)};
                imageViewArr[0] = (ImageView) inflate.findViewById(2131821037);
                imageViewArr[1] = (ImageView) inflate.findViewById(2131821039);
                imageViewArr[2] = (ImageView) inflate.findViewById(2131821041);
                i2 = 0;
                if (!C7101u.m11902kj(c34935b.cND)) {
                    for (int i4 : this.qOU) {
                        if (i4 == 3) {
                            i2++;
                        }
                    }
                }
                int i42 = 0;
                for (int i32 : this.qOU) {
                    if (i32 == 0) {
                        i42++;
                    }
                }
                if (i42 + i2 > 0) {
                    i = (this.qOU.length - i42) - i2;
                    if (i == 0) {
                        AppMethodBeat.m2505o(36771);
                        return 2;
                    }
                    this.qOV = new int[i];
                } else {
                    this.qOV = new int[this.qOU.length];
                }
                i = 0;
                i42 = 0;
                while (i < this.qOU.length) {
                    if (this.qOU[i] != 0 && (i2 <= 0 || this.qOU[i] != 3)) {
                        this.qOV[i42] = this.qOU[i];
                        i42++;
                    }
                    i++;
                }
                if (C7101u.m11901ki(c34935b.cND)) {
                    for (i = 0; i < this.qOV.length; i++) {
                        if (this.qOV[i] == 3) {
                            this.qOV[i] = 4;
                            break;
                        }
                    }
                }
                i2 = 0;
                int fromDPToPix = ((C1338a.fromDPToPix(this.mContext, 12) * 2) + (C1338a.fromDPToPix(this.mContext, 8) * 2)) + C1338a.fromDPToPix(this.mContext, 12);
                i = 0;
                while (true) {
                    int i5 = i;
                    if (i5 >= this.qOV.length) {
                        break;
                    }
                    int i6;
                    i42 = this.qOV[i5];
                    i32 = this.qOV[i5] - 1;
                    r12[i5].setText(this.qOT[i32]);
                    TextView textView = r12[i5];
                    Paint paint = new Paint();
                    String charSequence = textView.getText().toString();
                    paint.setTextSize(textView.getTextSize());
                    i = ((int) paint.measureText(charSequence, 0, charSequence.length())) + fromDPToPix;
                    if (i > i2) {
                        i6 = i;
                    } else {
                        i6 = i2;
                    }
                    r12[i5].setCompoundDrawablePadding(C1338a.fromDPToPix(this.mContext, 8));
                    r12[i5].setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(this.qOS[i32]), null, null, null);
                    if (i32 == 1) {
                        imageViewArr[i5].setVisibility(0);
                    } else {
                        imageViewArr[i5].setVisibility(8);
                    }
                    r12[i5].setTag(c34935b);
                    final C34935b c34935b2 = c34935b;
                    final View view3 = view;
                    r12[i5].setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.m2504i(36757);
                            C31408b c31408b = C31408b.this;
                            int i = i42;
                            C34935b c34935b = c34935b2;
                            View view2 = inflate;
                            AbsoluteLayout absoluteLayout = C31408b.this.qON;
                            C4990ab.m7410d("MicroMsg.AdNotLikeAbTestHelper", "processFristButtonClick " + i + " " + c34935b.cND);
                            C3870b c3870b = (C3870b) c31408b.qOW.get(Long.valueOf(c34935b.cND));
                            if (c3870b != null) {
                                int i2;
                                if (i == 4) {
                                    i2 = 3;
                                } else {
                                    i2 = i;
                                }
                                c3870b.mo8588YA("1:" + i2 + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + c31408b.mContext.getString(c31408b.qOR[i - 1]));
                            }
                            if (i == 1) {
                                C46236n YT = C13373af.cnF().mo62918YT(c34935b.cwT);
                                if (YT != null) {
                                    if (YT.mo74253DI(32)) {
                                        Object obj;
                                        C21980a cqq = YT.cqq();
                                        if (cqq == null) {
                                            obj = "";
                                        } else {
                                            String obj2 = cqq.hnw;
                                        }
                                        ((C13356c) C1720g.m3528K(C13356c.class)).mo25461a(11855, YT.cre(), Integer.valueOf(3), obj2, Integer.valueOf(YT.cre()));
                                    }
                                    C13373af.cnI().delete(YT.field_snsId);
                                    C13373af.cnK().mo47208ky(YT.field_snsId);
                                    C21991i.m33620kx(YT.field_snsId);
                                    C1207m c46224r = new C46224r(YT.field_snsId, 8);
                                    C1720g.m3537RQ();
                                    C1720g.m3535RO().eJo.mo14541a(c46224r, 0);
                                    c31408b.mo51354a(c3870b);
                                    c31408b.cox();
                                    AppMethodBeat.m2505o(36757);
                                    return;
                                }
                            } else if (i == 2) {
                                c31408b.mo51353a(view2, absoluteLayout, c34935b);
                                AppMethodBeat.m2505o(36757);
                                return;
                            } else if (i == 3) {
                                if (!C7101u.m11901ki(c34935b.cND)) {
                                    C7101u.m11899kg(c34935b.cND);
                                }
                                c31408b.mo51354a(c3870b);
                                c31408b.cox();
                                AppMethodBeat.m2505o(36757);
                                return;
                            } else if (i == 4) {
                                if (C7101u.m11901ki(c34935b.cND)) {
                                    C7101u.m11900kh(c34935b.cND);
                                }
                                c31408b.mo51354a(c3870b);
                                c31408b.cox();
                            }
                            AppMethodBeat.m2505o(36757);
                        }
                    });
                    i = i5 + 1;
                    i2 = i6;
                }
                for (i = 0; i < this.qOV.length; i++) {
                    r12[i].setMaxWidth(i2);
                }
                for (i = this.qOV.length; i < 3; i++) {
                    r12[i].setVisibility(8);
                }
                Rect rect = new Rect();
                i = C30036f.m47543fD(this.mContext);
                int[] cuI = c34935b.qFH.cuI();
                C4990ab.m7410d("MicroMsg.AdNotLikeAbTestHelper", "addCommentView getLocationInWindow " + cuI[0] + "  " + cuI[1] + " height: " + i);
                i2 += C1338a.fromDPToPix(this.mContext, 12);
                i32 = C4977b.m7371b(this.mContext, 17.0f);
                int b = C4977b.m7371b(this.mContext, 2.0f);
                this.qDY = C5222ae.m7947hA(this.mContext);
                AbsoluteLayout.LayoutParams layoutParams2 = new AbsoluteLayout.LayoutParams(i2, -2, (cuI[0] - i2) - b, ((cuI[1] - this.qDY) - i) + i32);
                this.qON.setTag(new C21883a(str, inflate, c34935b.cND, c34935b.qFH.rDm));
                this.qON.addView(inflate, layoutParams2);
                inflate.setVisibility(8);
                this.qOQ = true;
                final View view4 = view;
                new C7306ak().post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(36758);
                        C31408b.m50797a(C31408b.this, view4, inflate);
                        AppMethodBeat.m2505o(36758);
                    }
                });
                AppMethodBeat.m2505o(36771);
                return 1;
            }
            AppMethodBeat.m2505o(36771);
            return 2;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo51353a(View view, AbsoluteLayout absoluteLayout, C34935b c34935b) {
        AppMethodBeat.m2504i(36772);
        ViewGroup viewGroup = (ViewGroup) view;
        viewGroup.removeAllViews();
        if (this.qOZ == null) {
            AppMethodBeat.m2505o(36772);
        } else if (c34935b.qFH == null || c34935b.qFH.rDm == null) {
            AppMethodBeat.m2505o(36772);
        } else {
            int i;
            C21984b c21984b = c34935b.qFH.rDm;
            int i2 = 0;
            Paint paint = new Paint(1);
            int b = C4977b.m7371b(this.mContext, 12.0f);
            int b2 = C4977b.m7371b(this.mContext, 10.0f);
            int b3 = C4977b.m7371b(this.mContext, 150.0f);
            LinkedList<TextView> linkedList = new LinkedList();
            float b4 = (((float) C4977b.m7371b(this.mContext, 17.0f)) * C1338a.m2860dm(this.mContext)) + ((float) (b2 * 2));
            int i3 = (int) b4;
            int i4 = 0;
            while (true) {
                i = i4;
                if (i >= this.qOZ.qPP.size()) {
                    break;
                }
                C21882a c21882a = (C21882a) this.qOZ.qPP.get(i);
                final TextView textView = new TextView(this.mContext);
                textView.setPadding(b, b2, b, b2);
                textView.setTextSize(1, 14.0f * C1338a.m2860dm(this.mContext));
                textView.setTextColor(this.mContext.getResources().getColor(C25738R.color.a06));
                String a = C31408b.m50796a(c21882a, c21984b.qUD);
                textView.setText(a);
                paint.setTextSize(textView.getTextSize());
                viewGroup.addView(textView);
                i2 = Math.max(i2, ((int) paint.measureText(a)) + (b * 2));
                textView.setTag(Integer.valueOf(i));
                linkedList.add(textView);
                final C34935b c34935b2 = c34935b;
                textView.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(36759);
                        int intValue = ((Integer) view.getTag()).intValue();
                        C3870b c3870b = (C3870b) C31408b.this.qOW.get(Long.valueOf(c34935b2.cND));
                        int i = ((C21882a) C31408b.this.qOZ.qPP.get(intValue)).qOF;
                        if (c3870b != null) {
                            c3870b.mo8588YA("3:" + i + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + textView.getText());
                        }
                        if (((C21882a) C31408b.this.qOZ.qPP.get(intValue)).qOJ == 1) {
                            Intent intent = new Intent();
                            intent.setClass(C31408b.this.mContext, SnsCommentUI.class);
                            intent.putExtra("sns_comment_type", 2);
                            intent.putExtra("sns_id", c34935b2.cND);
                            intent.putExtra("sns_uxinfo", c3870b.qPj);
                            intent.putExtra("action_st_time", c3870b.qPk);
                            intent.putExtra("sns_actionresult", c3870b.qPi.toString());
                            ((MMActivity) C31408b.this.mContext).startActivity(intent);
                            C31408b.this.qOW.remove(Long.valueOf(c34935b2.cND));
                            C31408b.this.cox();
                            AppMethodBeat.m2505o(36759);
                            return;
                        }
                        C31408b.this.mo51354a(c3870b);
                        C31408b.this.cox();
                        AppMethodBeat.m2505o(36759);
                    }
                });
                i4 = i + 1;
            }
            C4990ab.m7416i("MicroMsg.AdNotLikeAbTestHelper", "w h " + i2 + " " + i3);
            if (i2 < b3) {
                i2 = b3;
            }
            for (TextView textView2 : linkedList) {
                ViewGroup.LayoutParams layoutParams = textView2.getLayoutParams();
                layoutParams.width = i2;
                layoutParams.height = (int) b4;
                textView2.setLayoutParams(layoutParams);
            }
            Rect rect = new Rect();
            int fD = C30036f.m47543fD(this.mContext);
            int[] cuI = c34935b.qFH.cuI();
            i = (cuI[0] - i2) - C4977b.m7371b(this.mContext, 2.0f);
            i4 = ((cuI[1] - this.qDY) - fD) + i3;
            C4052bb c4052bb = c34935b.qFH;
            if (c4052bb.rDi != null) {
                fD = c4052bb.rDi.getHeight();
            } else {
                fD = 0;
            }
            absoluteLayout.updateViewLayout(view, new AbsoluteLayout.LayoutParams(-2, -2, i, i4 - fD));
            AppMethodBeat.m2505o(36772);
        }
    }

    /* renamed from: a */
    private static String m50796a(C21882a c21882a, Map<String, String> map) {
        AppMethodBeat.m2504i(36773);
        String str;
        if (c21882a == null) {
            str = "";
            AppMethodBeat.m2505o(36773);
            return str;
        }
        String str2;
        if (C4988aa.doo()) {
            str2 = c21882a.qOG;
        } else if (C4988aa.dop()) {
            str2 = c21882a.qOH;
        } else {
            str2 = c21882a.qOI;
        }
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < str2.length()) {
                char charAt = str2.charAt(i2);
                if (charAt == '$') {
                    if (stringBuffer2.length() == 0) {
                        stringBuffer2.append(charAt);
                    } else if (stringBuffer2.charAt(stringBuffer2.length() - 1) == '$') {
                        stringBuffer.append('$');
                        stringBuffer2 = new StringBuffer();
                    } else {
                        str = (String) map.get(stringBuffer2.substring(1));
                        if (str == null) {
                            str = "";
                            AppMethodBeat.m2505o(36773);
                            return str;
                        }
                        stringBuffer.append(str);
                    }
                } else if (stringBuffer2.length() == 0) {
                    stringBuffer.append(charAt);
                } else {
                    stringBuffer2.append(charAt);
                }
                i = i2 + 1;
            } else {
                str = stringBuffer.toString();
                AppMethodBeat.m2505o(36773);
                return str;
            }
        }
    }

    public final boolean cox() {
        AppMethodBeat.m2504i(36774);
        if (this.qON != null) {
            if (this.qON.getTag() instanceof C21883a) {
                C3870b c3870b = (C3870b) this.qOW.get(Long.valueOf(((C21883a) this.qON.getTag()).cND));
                if (c3870b != null) {
                    if (c3870b.coz()) {
                        if (c3870b.coy()) {
                            c3870b.mo8588YA("2:0:");
                        }
                        mo51354a(c3870b);
                    } else {
                        c3870b.mo8588YA("2:0:");
                        mo51354a(c3870b);
                    }
                }
            }
            this.qOM.removeView(this.qON);
            this.qON = null;
            AppMethodBeat.m2505o(36774);
            return true;
        }
        this.qOQ = false;
        AppMethodBeat.m2505o(36774);
        return false;
    }
}

package com.tencent.mm.plugin.sns.g;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.e;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.model.u;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.SnsCommentUI;
import com.tencent.mm.plugin.sns.ui.bb;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.v;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

public final class b implements e {
    private boolean cwB = true;
    Context mContext;
    private int qDY = -1;
    public final int qOK = 14;
    private com.tencent.mm.plugin.sns.ui.d.b qOL;
    private FrameLayout qOM;
    AbsoluteLayout qON = null;
    protected Animation qOO;
    protected Animation qOP;
    boolean qOQ = false;
    int[] qOR = new int[]{R.string.eip, R.string.eiq, R.string.eir, R.string.eis};
    private int[] qOS = new int[]{R.raw.album_test_donotlook, R.raw.album_test_unlike, R.raw.album_test_open, R.raw.album_test_close};
    private int[] qOT = this.qOR;
    private int[] qOU;
    private int[] qOV;
    Map<Long, b> qOW = new HashMap();
    private Map<Long, b> qOX = new HashMap();
    private HashSet<Long> qOY = new HashSet();
    h qOZ = null;
    private HashMap<Long, Boolean> qPa = new HashMap();

    static class b {
        long qDh;
        StringBuffer qPi = new StringBuffer();
        String qPj;
        long qPk;
        long qPl;
        String qPm;
        String qPn;

        public b(long j, String str, String str2, String str3, String str4) {
            AppMethodBeat.i(36761);
            this.qPj = str;
            this.qPm = str2;
            this.qPn = str3;
            this.qDh = j;
            this.qPk = System.currentTimeMillis();
            this.qPi.append("1:0:".concat(String.valueOf(str4)));
            AppMethodBeat.o(36761);
        }

        public b(long j, String str, String str2, String str3) {
            AppMethodBeat.i(36762);
            this.qPj = str;
            this.qPm = str2;
            this.qPn = str3;
            this.qDh = j;
            this.qPk = System.currentTimeMillis();
            this.qPi.append("0:0:");
            AppMethodBeat.o(36762);
        }

        public final void YA(String str) {
            AppMethodBeat.i(36763);
            ab.d("MicroMsg.AdNotLikeAbTestHelper", "addactionResult ".concat(String.valueOf(str)));
            if (this.qPi.length() != 0) {
                this.qPi.append("|");
            }
            this.qPi.append(str);
            AppMethodBeat.o(36763);
        }

        public final boolean coy() {
            AppMethodBeat.i(36764);
            if (this.qPi == null || this.qPi.length() == 0) {
                AppMethodBeat.o(36764);
                return false;
            } else if (this.qPi.toString().startsWith("1:0")) {
                AppMethodBeat.o(36764);
                return true;
            } else {
                AppMethodBeat.o(36764);
                return false;
            }
        }

        public final boolean coz() {
            AppMethodBeat.i(36765);
            if (this.qPi == null || this.qPi.length() == 0) {
                AppMethodBeat.o(36765);
                return false;
            }
            AppMethodBeat.o(36765);
            return true;
        }

        public final void IF() {
            AppMethodBeat.i(36766);
            this.qPl = System.currentTimeMillis();
            ab.d("MicroMsg.AdNotLikeAbTestHelper", "report abtestnotlike " + this.qDh + " uxinfo:" + this.qPj + " actionresult: " + this.qPi + " " + this.qPk + " " + this.qPl);
            h.pYm.e(11988, this.qPn, this.qPm, "", "", i.jV(this.qDh), this.qPj, this.qPi, Long.valueOf(this.qPk / 1000), Long.valueOf(this.qPl / 1000));
            AppMethodBeat.o(36766);
        }
    }

    class a {
        long cND;
        View qCZ = null;
        String qPg;
        com.tencent.mm.plugin.sns.storage.b qPh;

        public a(String str, View view, long j, com.tencent.mm.plugin.sns.storage.b bVar) {
            this.qPg = str;
            this.qCZ = view;
            this.qPh = bVar;
            this.cND = j;
        }
    }

    public final void a(int i, String str, long j, TimeLineObject timeLineObject, boolean z, bb bbVar) {
        AppMethodBeat.i(36767);
        if (z && this.cwB && this.qOZ != null && bbVar != null) {
            this.qOY.add(Long.valueOf(j));
            this.qOX.put(Long.valueOf(j), new b(j, this.qOZ.qPm, this.qOZ.qPn, bbVar.cuH()));
        }
        AppMethodBeat.o(36767);
    }

    public final void a(int i, String str, long j, TimeLineObject timeLineObject, boolean z) {
        AppMethodBeat.i(36768);
        if (z && this.cwB) {
            if (this.qOY.contains(Long.valueOf(j))) {
                boolean z2 = false;
                if (this.qPa.containsKey(Long.valueOf(j))) {
                    z2 = ((Boolean) this.qPa.get(Long.valueOf(j))).booleanValue();
                }
                if (z2) {
                    b bVar = (b) this.qOX.get(Long.valueOf(j));
                    if (bVar != null) {
                        bVar.IF();
                    }
                }
            }
            this.qOX.remove(Long.valueOf(j));
            this.qOY.remove(Long.valueOf(j));
        }
        AppMethodBeat.o(36768);
    }

    public final void a(b bVar) {
        AppMethodBeat.i(36769);
        this.qOW.remove(Long.valueOf(bVar.qDh));
        bVar.IF();
        AppMethodBeat.o(36769);
    }

    public b(Context context, com.tencent.mm.plugin.sns.ui.d.b bVar, FrameLayout frameLayout) {
        AppMethodBeat.i(36770);
        g cnx = af.cnx();
        h hVar = new h();
        c ll = com.tencent.mm.model.c.c.abi().ll("100007");
        if (ll.isValid()) {
            Map dru = ll.dru();
            if (dru != null) {
                ab.i("MicroMsg.SnsABTestStrategy", "snsabtest feed " + ll.field_expId + " " + ll.field_layerId + " " + ll.field_startTime + " " + ll.field_endTime);
                hVar.h(ll.field_layerId, ll.field_expId, dru);
            }
        } else {
            ab.i("MicroMsg.SnsABTestStrategy", "abtest is invalid");
            hVar = null;
        }
        cnx.qQa = hVar;
        this.qOZ = af.cnx().coB();
        if (this.qOZ != null) {
            this.qOU = this.qOZ.qQc;
            if (!this.qOZ.coC()) {
                this.cwB = false;
            }
        }
        this.mContext = context;
        this.qOL = bVar;
        this.qOM = frameLayout;
        this.qOO = new ScaleAnimation(1.0f, 1.0f, 0.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.qOO = AnimationUtils.loadAnimation(context, R.anim.al);
        this.qOP = new ScaleAnimation(1.0f, 1.0f, 1.0f, 0.0f, 1, 1.0f, 1, 0.0f);
        this.qOP = AnimationUtils.loadAnimation(context, R.anim.am);
        AppMethodBeat.o(36770);
    }

    public final int dC(View view) {
        AppMethodBeat.i(36771);
        if (this.qOQ) {
            AppMethodBeat.o(36771);
            return 0;
        } else if (this.qON != null) {
            if (this.qON.getTag() instanceof a) {
                final View view2 = ((a) this.qON.getTag()).qCZ;
                this.qOQ = true;
                view2.startAnimation(this.qOP);
                this.qOP.setAnimationListener(new AnimationListener() {
                    public final void onAnimationStart(Animation animation) {
                        b.this.qOQ = true;
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.i(36760);
                        if (view2 != null) {
                            view2.clearAnimation();
                            view2.setVisibility(8);
                            b.this.cox();
                        }
                        b.this.qOQ = false;
                        AppMethodBeat.o(36760);
                    }
                });
            } else {
                cox();
            }
            AppMethodBeat.o(36771);
            return 0;
        } else if (view.getTag() == null || !(view.getTag() instanceof com.tencent.mm.plugin.sns.data.b)) {
            AppMethodBeat.o(36771);
            return 0;
        } else if (!this.cwB || this.qOZ == null) {
            AppMethodBeat.o(36771);
            return 2;
        } else {
            int i;
            int i2;
            boolean z;
            com.tencent.mm.plugin.sns.data.b bVar = (com.tencent.mm.plugin.sns.data.b) view.getTag();
            long j = bVar.cND;
            com.tencent.mm.plugin.sns.storage.b bVar2 = bVar.qFH.rDm;
            if (!this.qPa.containsKey(Long.valueOf(j))) {
                if (this.qOZ != null) {
                    if (bVar2 != null) {
                        i = 0;
                        while (true) {
                            i2 = i;
                            if (i2 >= this.qOZ.qPP.size()) {
                                this.qPa.put(Long.valueOf(j), Boolean.TRUE);
                                z = true;
                                break;
                            } else if (bo.isNullOrNil(a((a) this.qOZ.qPP.get(i2), bVar2.qUD))) {
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
                String str = bVar.cwT;
                this.qOW.put(Long.valueOf(bVar.cND), new b(bVar.cND, bVar.qFH.cuH(), this.qOZ.qPm, this.qOZ.qPn, this.mContext.getString(R.string.ejb)));
                if (this.qOY.contains(Long.valueOf(bVar.cND))) {
                    this.qOY.remove(Long.valueOf(bVar.cND));
                }
                this.qON = new AbsoluteLayout(this.mContext);
                this.qON.setId(R.id.ee);
                LayoutParams layoutParams = new LayoutParams(-1, -1);
                this.qOM.addView(this.qON);
                final View inflate = v.hu(this.mContext).inflate(R.layout.av, null);
                r12 = new TextView[3];
                ImageView[] imageViewArr = new ImageView[]{(TextView) inflate.findViewById(R.id.ml), (TextView) inflate.findViewById(R.id.mn), (TextView) inflate.findViewById(R.id.mp)};
                imageViewArr[0] = (ImageView) inflate.findViewById(R.id.mm);
                imageViewArr[1] = (ImageView) inflate.findViewById(R.id.mo);
                imageViewArr[2] = (ImageView) inflate.findViewById(R.id.mq);
                i2 = 0;
                if (!u.kj(bVar.cND)) {
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
                        AppMethodBeat.o(36771);
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
                if (u.ki(bVar.cND)) {
                    for (i = 0; i < this.qOV.length; i++) {
                        if (this.qOV[i] == 3) {
                            this.qOV[i] = 4;
                            break;
                        }
                    }
                }
                i2 = 0;
                int fromDPToPix = ((com.tencent.mm.bz.a.fromDPToPix(this.mContext, 12) * 2) + (com.tencent.mm.bz.a.fromDPToPix(this.mContext, 8) * 2)) + com.tencent.mm.bz.a.fromDPToPix(this.mContext, 12);
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
                    r12[i5].setCompoundDrawablePadding(com.tencent.mm.bz.a.fromDPToPix(this.mContext, 8));
                    r12[i5].setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(this.qOS[i32]), null, null, null);
                    if (i32 == 1) {
                        imageViewArr[i5].setVisibility(0);
                    } else {
                        imageViewArr[i5].setVisibility(8);
                    }
                    r12[i5].setTag(bVar);
                    final com.tencent.mm.plugin.sns.data.b bVar3 = bVar;
                    final View view3 = view;
                    r12[i5].setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(36757);
                            b bVar = b.this;
                            int i = i42;
                            com.tencent.mm.plugin.sns.data.b bVar2 = bVar3;
                            View view2 = inflate;
                            AbsoluteLayout absoluteLayout = b.this.qON;
                            ab.d("MicroMsg.AdNotLikeAbTestHelper", "processFristButtonClick " + i + " " + bVar2.cND);
                            b bVar3 = (b) bVar.qOW.get(Long.valueOf(bVar2.cND));
                            if (bVar3 != null) {
                                int i2;
                                if (i == 4) {
                                    i2 = 3;
                                } else {
                                    i2 = i;
                                }
                                bVar3.YA("1:" + i2 + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + bVar.mContext.getString(bVar.qOR[i - 1]));
                            }
                            if (i == 1) {
                                n YT = af.cnF().YT(bVar2.cwT);
                                if (YT != null) {
                                    if (YT.DI(32)) {
                                        Object obj;
                                        com.tencent.mm.plugin.sns.storage.a cqq = YT.cqq();
                                        if (cqq == null) {
                                            obj = "";
                                        } else {
                                            String obj2 = cqq.hnw;
                                        }
                                        ((com.tencent.mm.plugin.sns.b.c) g.K(com.tencent.mm.plugin.sns.b.c.class)).a(11855, YT.cre(), Integer.valueOf(3), obj2, Integer.valueOf(YT.cre()));
                                    }
                                    af.cnI().delete(YT.field_snsId);
                                    af.cnK().ky(YT.field_snsId);
                                    com.tencent.mm.plugin.sns.storage.i.kx(YT.field_snsId);
                                    m rVar = new r(YT.field_snsId, 8);
                                    g.RQ();
                                    g.RO().eJo.a(rVar, 0);
                                    bVar.a(bVar3);
                                    bVar.cox();
                                    AppMethodBeat.o(36757);
                                    return;
                                }
                            } else if (i == 2) {
                                bVar.a(view2, absoluteLayout, bVar2);
                                AppMethodBeat.o(36757);
                                return;
                            } else if (i == 3) {
                                if (!u.ki(bVar2.cND)) {
                                    u.kg(bVar2.cND);
                                }
                                bVar.a(bVar3);
                                bVar.cox();
                                AppMethodBeat.o(36757);
                                return;
                            } else if (i == 4) {
                                if (u.ki(bVar2.cND)) {
                                    u.kh(bVar2.cND);
                                }
                                bVar.a(bVar3);
                                bVar.cox();
                            }
                            AppMethodBeat.o(36757);
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
                i = f.fD(this.mContext);
                int[] cuI = bVar.qFH.cuI();
                ab.d("MicroMsg.AdNotLikeAbTestHelper", "addCommentView getLocationInWindow " + cuI[0] + "  " + cuI[1] + " height: " + i);
                i2 += com.tencent.mm.bz.a.fromDPToPix(this.mContext, 12);
                i32 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.mContext, 17.0f);
                int b = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.mContext, 2.0f);
                this.qDY = ae.hA(this.mContext);
                AbsoluteLayout.LayoutParams layoutParams2 = new AbsoluteLayout.LayoutParams(i2, -2, (cuI[0] - i2) - b, ((cuI[1] - this.qDY) - i) + i32);
                this.qON.setTag(new a(str, inflate, bVar.cND, bVar.qFH.rDm));
                this.qON.addView(inflate, layoutParams2);
                inflate.setVisibility(8);
                this.qOQ = true;
                final View view4 = view;
                new ak().post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(36758);
                        b.a(b.this, view4, inflate);
                        AppMethodBeat.o(36758);
                    }
                });
                AppMethodBeat.o(36771);
                return 1;
            }
            AppMethodBeat.o(36771);
            return 2;
        }
    }

    /* Access modifiers changed, original: final */
    public final void a(View view, AbsoluteLayout absoluteLayout, com.tencent.mm.plugin.sns.data.b bVar) {
        AppMethodBeat.i(36772);
        ViewGroup viewGroup = (ViewGroup) view;
        viewGroup.removeAllViews();
        if (this.qOZ == null) {
            AppMethodBeat.o(36772);
        } else if (bVar.qFH == null || bVar.qFH.rDm == null) {
            AppMethodBeat.o(36772);
        } else {
            int i;
            com.tencent.mm.plugin.sns.storage.b bVar2 = bVar.qFH.rDm;
            int i2 = 0;
            Paint paint = new Paint(1);
            int b = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.mContext, 12.0f);
            int b2 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.mContext, 10.0f);
            int b3 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.mContext, 150.0f);
            LinkedList<TextView> linkedList = new LinkedList();
            float b4 = (((float) com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.mContext, 17.0f)) * com.tencent.mm.bz.a.dm(this.mContext)) + ((float) (b2 * 2));
            int i3 = (int) b4;
            int i4 = 0;
            while (true) {
                i = i4;
                if (i >= this.qOZ.qPP.size()) {
                    break;
                }
                a aVar = (a) this.qOZ.qPP.get(i);
                final TextView textView = new TextView(this.mContext);
                textView.setPadding(b, b2, b, b2);
                textView.setTextSize(1, 14.0f * com.tencent.mm.bz.a.dm(this.mContext));
                textView.setTextColor(this.mContext.getResources().getColor(R.color.a06));
                String a = a(aVar, bVar2.qUD);
                textView.setText(a);
                paint.setTextSize(textView.getTextSize());
                viewGroup.addView(textView);
                i2 = Math.max(i2, ((int) paint.measureText(a)) + (b * 2));
                textView.setTag(Integer.valueOf(i));
                linkedList.add(textView);
                final com.tencent.mm.plugin.sns.data.b bVar3 = bVar;
                textView.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(36759);
                        int intValue = ((Integer) view.getTag()).intValue();
                        b bVar = (b) b.this.qOW.get(Long.valueOf(bVar3.cND));
                        int i = ((a) b.this.qOZ.qPP.get(intValue)).qOF;
                        if (bVar != null) {
                            bVar.YA("3:" + i + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + textView.getText());
                        }
                        if (((a) b.this.qOZ.qPP.get(intValue)).qOJ == 1) {
                            Intent intent = new Intent();
                            intent.setClass(b.this.mContext, SnsCommentUI.class);
                            intent.putExtra("sns_comment_type", 2);
                            intent.putExtra("sns_id", bVar3.cND);
                            intent.putExtra("sns_uxinfo", bVar.qPj);
                            intent.putExtra("action_st_time", bVar.qPk);
                            intent.putExtra("sns_actionresult", bVar.qPi.toString());
                            ((MMActivity) b.this.mContext).startActivity(intent);
                            b.this.qOW.remove(Long.valueOf(bVar3.cND));
                            b.this.cox();
                            AppMethodBeat.o(36759);
                            return;
                        }
                        b.this.a(bVar);
                        b.this.cox();
                        AppMethodBeat.o(36759);
                    }
                });
                i4 = i + 1;
            }
            ab.i("MicroMsg.AdNotLikeAbTestHelper", "w h " + i2 + " " + i3);
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
            int fD = f.fD(this.mContext);
            int[] cuI = bVar.qFH.cuI();
            i = (cuI[0] - i2) - com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.mContext, 2.0f);
            i4 = ((cuI[1] - this.qDY) - fD) + i3;
            bb bbVar = bVar.qFH;
            if (bbVar.rDi != null) {
                fD = bbVar.rDi.getHeight();
            } else {
                fD = 0;
            }
            absoluteLayout.updateViewLayout(view, new AbsoluteLayout.LayoutParams(-2, -2, i, i4 - fD));
            AppMethodBeat.o(36772);
        }
    }

    private static String a(a aVar, Map<String, String> map) {
        AppMethodBeat.i(36773);
        String str;
        if (aVar == null) {
            str = "";
            AppMethodBeat.o(36773);
            return str;
        }
        String str2;
        if (aa.doo()) {
            str2 = aVar.qOG;
        } else if (aa.dop()) {
            str2 = aVar.qOH;
        } else {
            str2 = aVar.qOI;
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
                            AppMethodBeat.o(36773);
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
                AppMethodBeat.o(36773);
                return str;
            }
        }
    }

    public final boolean cox() {
        AppMethodBeat.i(36774);
        if (this.qON != null) {
            if (this.qON.getTag() instanceof a) {
                b bVar = (b) this.qOW.get(Long.valueOf(((a) this.qON.getTag()).cND));
                if (bVar != null) {
                    if (bVar.coz()) {
                        if (bVar.coy()) {
                            bVar.YA("2:0:");
                        }
                        a(bVar);
                    } else {
                        bVar.YA("2:0:");
                        a(bVar);
                    }
                }
            }
            this.qOM.removeView(this.qON);
            this.qON = null;
            AppMethodBeat.o(36774);
            return true;
        }
        this.qOQ = false;
        AppMethodBeat.o(36774);
        return false;
    }
}

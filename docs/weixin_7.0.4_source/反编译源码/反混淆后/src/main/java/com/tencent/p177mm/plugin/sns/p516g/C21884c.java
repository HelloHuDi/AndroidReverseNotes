package com.tencent.p177mm.plugin.sns.p516g;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.SpannableString;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C18312lc;
import com.tencent.p177mm.p230g.p231a.C26187lb;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C29057e;
import com.tencent.p177mm.plugin.sns.model.C46224r;
import com.tencent.p177mm.plugin.sns.model.C7109w;
import com.tencent.p177mm.plugin.sns.p1025h.C21896c;
import com.tencent.p177mm.plugin.sns.p1363c.C24826a;
import com.tencent.p177mm.plugin.sns.p516g.C21890d.C21891a;
import com.tencent.p177mm.plugin.sns.p516g.C21890d.C21892b;
import com.tencent.p177mm.plugin.sns.p520ui.C4052bb;
import com.tencent.p177mm.plugin.sns.p520ui.C46247aa;
import com.tencent.p177mm.plugin.sns.p520ui.C46251au;
import com.tencent.p177mm.plugin.sns.p520ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C24944o;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C24944o.C24945a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.cbf;
import com.tencent.p177mm.protocal.protobuf.cbn;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.plugin.sns.g.c */
public final class C21884c implements C1202f, C29057e {
    public static final Pattern qPw = Pattern.compile("\\{richtext:([\\s\\S]*?)\\}");
    public static final Pattern qPx = Pattern.compile("\\{sex:([\\s\\S]*?):([\\s\\S]*?):([\\s\\S]*?)\\}");
    public C21896c qJD;
    public final int qOK = 14;
    public final int qPo = 500;
    public List<C21890d> qPp;
    public ListView qPq;
    public C46251au qPr;
    public Map<Long, Integer> qPs = new HashMap();
    public HashSet<Long> qPt = new HashSet();
    public HashSet<Long> qPu = new HashSet();
    public HashMap<Long, C13361a> qPv = new HashMap();
    private C24945a qPy = new C133606();

    /* renamed from: com.tencent.mm.plugin.sns.g.c$6 */
    class C133606 implements C24945a {
        C133606() {
        }

        /* renamed from: a */
        public final void mo25466a(View view, Object obj) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.g.c$a */
    static class C13361a {
        long mEndTime = -1;
        long mStartTime = -1;
        long qJo;
        C21890d qPI;
        int qPJ = 0;
        int qPK = 0;
        String qPL = "";
        String qPM = "";
        String qPN;

        public C13361a(long j, long j2, String str, C21890d c21890d) {
            this.qPI = c21890d;
            this.mStartTime = j;
            this.qJo = j2;
            this.qPN = str;
        }

        /* renamed from: fl */
        public final void mo25468fl(int i, int i2) {
            this.qPJ = i;
            this.qPK = i2;
        }

        /* renamed from: E */
        public final void mo25467E(int i, int i2, int i3, int i4) {
            AppMethodBeat.m2504i(36781);
            if (i == -1 || i2 == -1) {
                AppMethodBeat.m2505o(36781);
                return;
            }
            String str = i + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + i2 + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + i3 + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + i4;
            String str2 = i + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + i2;
            if (str.equals(this.qPL) || (this.qPL.startsWith(str2) && i3 == 0 && i4 == 0)) {
                AppMethodBeat.m2505o(36781);
                return;
            }
            this.qPL = str;
            addAction(i + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + i2 + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + i3 + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + i4);
            AppMethodBeat.m2505o(36781);
        }

        private void addAction(String str) {
            AppMethodBeat.m2504i(36782);
            if (!C5046bo.isNullOrNil(this.qPM)) {
                this.qPM += "|";
            }
            this.qPM += str;
            AppMethodBeat.m2505o(36782);
        }
    }

    public C21884c() {
        AppMethodBeat.m2504i(36783);
        AppMethodBeat.m2505o(36783);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(36784);
        C4990ab.m7416i("MicroMsg.SnSABTestMgr", "onSceneend " + i + " errCode " + i2);
        C4879a.xxA.mo10055m(new C26187lb());
        AppMethodBeat.m2505o(36784);
    }

    /* renamed from: kq */
    private void m33447kq(long j) {
        AppMethodBeat.m2504i(36785);
        if (this.qJD == null) {
            this.qJD = new C21896c();
        }
        if (this.qJD.qQf.size() > 500) {
            this.qJD.qQf.remove(0);
        }
        this.qJD.qQf.add(Long.valueOf(j));
        AppMethodBeat.m2505o(36785);
    }

    public final void clean() {
        AppMethodBeat.m2504i(36786);
        this.qPq = null;
        this.qPr = null;
        if (this.qPt != null) {
            Iterator it = this.qPt.iterator();
            while (it.hasNext()) {
                Long l = (Long) it.next();
                C1207m c46224r = new C46224r(l.longValue(), 0, 0, null);
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14541a(c46224r, 0);
                C4990ab.m7416i("MicroMsg.SnSABTestMgr", "report id ".concat(String.valueOf(l)));
            }
        }
        if (this.qPv != null) {
            for (C13361a a : this.qPv.values()) {
                C21884c.m33439a(a);
            }
            this.qPv.clear();
        }
        if (this.qPp.size() == 0 || this.qJD == null) {
            AppMethodBeat.m2505o(36786);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3537RQ();
        String stringBuilder2 = stringBuilder.append(C1720g.m3536RP().cachePath).append("ws_1100004").toString();
        C4990ab.m7416i("MicroMsg.SnSABTestMgr", "listToFile to list  ".concat(String.valueOf(stringBuilder2)));
        try {
            byte[] toByteArray = this.qJD.toByteArray();
            C5730e.m8624b(stringBuilder2, toByteArray, toByteArray.length);
            C4990ab.m7416i("MicroMsg.SnSABTestMgr", "listTofile " + (System.currentTimeMillis() - currentTimeMillis) + " igNoreAbTestId " + this.qJD.qQf.size());
            AppMethodBeat.m2505o(36786);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.SnSABTestMgr", e, "listToFile failed: ".concat(String.valueOf(stringBuilder2)), new Object[0]);
            AppMethodBeat.m2505o(36786);
        }
    }

    /* renamed from: c */
    public static void m33446c(View view, BaseViewHolder baseViewHolder) {
        AppMethodBeat.m2504i(36787);
        baseViewHolder.rId = false;
        baseViewHolder.rIc = (ViewStub) view.findViewById(2131827907);
        baseViewHolder.rIc.setVisibility(8);
        baseViewHolder.rIh = (ViewStub) view.findViewById(2131827914);
        baseViewHolder.rIh.setVisibility(8);
        AppMethodBeat.m2505o(36787);
    }

    /* renamed from: a */
    public final void mo37370a(Context context, cbf cbf, BaseViewHolder baseViewHolder) {
        AppMethodBeat.m2504i(36788);
        if (!C4988aa.doo()) {
            C21884c.m33444b(baseViewHolder);
            AppMethodBeat.m2505o(36788);
        } else if (this.qPp == null || this.qPp.size() == 0) {
            C21884c.m33444b(baseViewHolder);
            AppMethodBeat.m2505o(36788);
        } else if (this.qPu.contains(Long.valueOf(cbf.vQE))) {
            C21884c.m33444b(baseViewHolder);
            baseViewHolder.rIt.setVisibility(8);
            baseViewHolder.rHv.setVisibility(8);
            baseViewHolder.mRR.setVisibility(8);
            AppMethodBeat.m2505o(36788);
        } else if (cbf.vHl == null || cbf.vHl.equals(C13373af.cnk())) {
            C21884c.m33444b(baseViewHolder);
            AppMethodBeat.m2505o(36788);
        } else if (this.qJD == null || !this.qJD.qQf.contains(Long.valueOf(cbf.vQE))) {
            int i;
            if (cbf != null) {
                try {
                    byte[] a = C1946aa.m4150a(cbf.xaD);
                    if (C5046bo.m7540cb(a)) {
                        i = 0;
                    } else {
                        i = ((cbn) new cbn().parseFrom(a)).xaO;
                    }
                } catch (Exception e) {
                    i = 0;
                }
            } else {
                i = 0;
            }
            int i2 = 0;
            if (this.qPs.containsKey(Long.valueOf(cbf.vQE))) {
                i2 = ((Integer) this.qPs.get(Long.valueOf(cbf.vQE))).intValue();
                if (i2 == -1) {
                    C21884c.m33444b(baseViewHolder);
                    AppMethodBeat.m2505o(36788);
                    return;
                }
            }
            int i3 = i2;
            C21890d c21890d = null;
            for (C21890d c21890d2 : this.qPp) {
                if (c21890d2 != null) {
                    if (c21890d2.qPO == i) {
                        c21890d = c21890d2;
                        break;
                    }
                }
                C21884c.m33444b(baseViewHolder);
                AppMethodBeat.m2505o(36788);
                return;
            }
            if (c21890d == null) {
                C21884c.m33444b(baseViewHolder);
                AppMethodBeat.m2505o(36788);
            } else if (i3 >= c21890d.qPP.size()) {
                C21884c.m33444b(baseViewHolder);
                AppMethodBeat.m2505o(36788);
            } else {
                final C21892b c21892b = (C21892b) c21890d.qPP.get(i3);
                int i4 = c21892b.showType;
                C21884c.m33444b(baseViewHolder);
                if (i > 0) {
                    if (this.qPv.containsKey(Long.valueOf(cbf.vQE))) {
                        ((C13361a) this.qPv.get(Long.valueOf(cbf.vQE))).mo25468fl(i4, c21892b.hhZ.size());
                    } else {
                        C13361a c13361a = new C13361a(System.currentTimeMillis(), cbf.vQE, C29036i.m46117jV(cbf.vQE), c21890d);
                        c13361a.mo25468fl(i4, c21892b.hhZ.size());
                        this.qPv.put(Long.valueOf(cbf.vQE), c13361a);
                    }
                    if (i4 == 1) {
                        String str = c21892b.title;
                        if (!baseViewHolder.rId) {
                            baseViewHolder.rIe = baseViewHolder.rIc.inflate();
                            baseViewHolder.rId = true;
                            baseViewHolder.rIg = (TextView) baseViewHolder.rIe.findViewById(2131827600);
                            baseViewHolder.rIf = (LinearLayout) baseViewHolder.rIe.findViewById(2131827601);
                        }
                        baseViewHolder.rIe.setVisibility(0);
                        baseViewHolder.rIg.setText(str);
                        List list = c21892b.hhZ;
                        if (list.size() != baseViewHolder.rIf.getChildCount()) {
                            baseViewHolder.rIf.removeAllViews();
                            i2 = 0;
                            while (true) {
                                i = i2;
                                if (i >= list.size()) {
                                    break;
                                }
                                C21891a c21891a = (C21891a) list.get(i);
                                TextView textView = new TextView(baseViewHolder.rIf.getContext());
                                textView.setText(c21891a.qPQ);
                                textView.setPadding(0, 0, C1338a.fromDPToPix(context, 10), 0);
                                textView.setVisibility(0);
                                textView.setTextSize(1, 14.0f * C1338a.m2860dm(context));
                                textView.setTextColor(context.getResources().getColor(C25738R.color.a0k));
                                baseViewHolder.rIf.addView(textView);
                                i2 = i + 1;
                            }
                        }
                        for (i2 = 0; i2 < list.size(); i2++) {
                            final C21891a c21891a2 = (C21891a) list.get(i2);
                            TextView textView2 = (TextView) baseViewHolder.rIf.getChildAt(i2);
                            textView2.setText(m33436a(context, textView2, C21884c.m33437a(C43542f.m77825a(c21891a2), cbf), cbf, baseViewHolder, c21891a2, c21892b, c21890d));
                            textView2.setTag(cbf);
                            final Context context2 = context;
                            final BaseViewHolder baseViewHolder2 = baseViewHolder;
                            final C21890d c21890d3 = c21890d;
                            textView2.setOnClickListener(new OnClickListener() {
                                public final void onClick(View view) {
                                    AppMethodBeat.m2504i(36776);
                                    C21884c.m33440a(C21884c.this, context2, view, c21891a2, c21892b, baseViewHolder2, c21890d3);
                                    AppMethodBeat.m2505o(36776);
                                }
                            });
                        }
                        AppMethodBeat.m2505o(36788);
                        return;
                    } else if (i4 == 4) {
                        m33443a(context, cbf, baseViewHolder, c21892b, c21890d);
                        AppMethodBeat.m2505o(36788);
                        return;
                    } else if (i4 == 2) {
                        if (m33445b(context, cbf, baseViewHolder, c21892b, c21890d)) {
                            AppMethodBeat.m2505o(36788);
                            return;
                        } else {
                            AppMethodBeat.m2505o(36788);
                            return;
                        }
                    }
                }
                C21884c.m33444b(baseViewHolder);
                AppMethodBeat.m2505o(36788);
            }
        } else {
            C21884c.m33444b(baseViewHolder);
            AppMethodBeat.m2505o(36788);
        }
    }

    /* renamed from: b */
    private boolean m33445b(Context context, cbf cbf, BaseViewHolder baseViewHolder, C21892b c21892b, C21890d c21890d) {
        AppMethodBeat.m2504i(36790);
        if (c21892b.hhZ.size() == 2) {
            final C21891a c21891a = (C21891a) c21892b.hhZ.get(0);
            C21891a c21891a2 = (C21891a) c21892b.hhZ.get(1);
            String a = C21884c.m33437a(C43542f.m77825a(c21891a), cbf);
            String a2 = C21884c.m33437a(C43542f.m77825a(c21891a2), cbf);
            String a3 = C21884c.m33437a(c21892b.title, cbf);
            String string = context.getString(C25738R.string.f9238tz);
            final Context context2 = context;
            final cbf cbf2 = cbf;
            final C21892b c21892b2 = c21892b;
            final BaseViewHolder baseViewHolder2 = baseViewHolder;
            final C21890d c21890d2 = c21890d;
            C218893 c218893 = new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(36778);
                    C4990ab.m7416i("MicroMsg.SnSABTestMgr", "onClick alert1");
                    C21884c.m33441a(C21884c.this, context2, cbf2, c21891a, c21892b2, baseViewHolder2, c21890d2);
                    AppMethodBeat.m2505o(36778);
                }
            };
            final Context context3 = context;
            final cbf cbf3 = cbf;
            final C21891a c21891a3 = c21891a2;
            final C21892b c21892b3 = c21892b;
            final BaseViewHolder baseViewHolder3 = baseViewHolder;
            final C21890d c21890d3 = c21890d;
            C30379h.m48466d(context, a3, string, a, a2, c218893, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(36779);
                    C4990ab.m7416i("MicroMsg.SnSABTestMgr", "onClick alert2");
                    C21884c.m33441a(C21884c.this, context3, cbf3, c21891a3, c21892b3, baseViewHolder3, c21890d3);
                    AppMethodBeat.m2505o(36779);
                }
            });
            AppMethodBeat.m2505o(36790);
            return true;
        }
        AppMethodBeat.m2505o(36790);
        return false;
    }

    /* renamed from: a */
    private void m33442a(BaseViewHolder baseViewHolder) {
        AppMethodBeat.m2504i(36791);
        if (baseViewHolder == null) {
            AppMethodBeat.m2505o(36791);
            return;
        }
        Context context = baseViewHolder.mRR.getContext();
        if (context == null) {
            AppMethodBeat.m2505o(36791);
            return;
        }
        if (baseViewHolder.mRR.getBackground() == null) {
            baseViewHolder.mRR.setBackgroundResource(C25738R.drawable.f6623k5);
            baseViewHolder.mRR.setPadding(C1338a.fromDPToPix(context, 12), C1338a.fromDPToPix(context, 12), C1338a.fromDPToPix(context, 12), C1338a.fromDPToPix(context, 8));
        }
        int i = baseViewHolder.position - 1;
        if (this.qPr != null) {
            WeakReference weakReference = (WeakReference) this.qPr.rxR.get(Integer.valueOf(i));
            if (weakReference == null || weakReference.get() == null) {
                AppMethodBeat.m2505o(36791);
                return;
            } else {
                ((View) weakReference.get()).setBackgroundResource(C25738R.drawable.f6623k5);
                ((View) weakReference.get()).setPadding(C1338a.fromDPToPix(context, 12), C1338a.fromDPToPix(context, 12), C1338a.fromDPToPix(context, 12), C1338a.fromDPToPix(context, 8));
            }
        }
        AppMethodBeat.m2505o(36791);
    }

    /* renamed from: a */
    private void m33438a(Context context, cbf cbf, C21891a c21891a, C21892b c21892b, BaseViewHolder baseViewHolder, C21890d c21890d) {
        AppMethodBeat.m2504i(36792);
        C4990ab.m7416i("MicroMsg.SnSABTestMgr", "processButtonClick snsobj " + cbf.vHl + " " + cbf.vQE);
        int i = c21891a.qPS - 1;
        C13361a c13361a = (C13361a) this.qPv.get(Long.valueOf(cbf.vQE));
        if (c13361a != null) {
            c13361a.mo25467E(c21892b.showType, c21892b.hhZ.size(), c21891a.index, c21891a.actionType);
            c13361a.qPJ = -1;
            c13361a.qPK = -1;
        }
        String str;
        if (c21891a.actionType == 3) {
            this.qPt.add(Long.valueOf(cbf.vQE));
            this.qPs.put(Long.valueOf(cbf.vQE), Integer.valueOf(i));
        } else if (c21891a.actionType == 1) {
            this.qPs.put(Long.valueOf(cbf.vQE), Integer.valueOf(i));
            m33447kq(cbf.vQE);
            C21884c.m33444b(baseViewHolder);
        } else if (c21891a.actionType == 5) {
            if (this.qPt.contains(Long.valueOf(cbf.vQE))) {
                this.qPt.remove(Long.valueOf(cbf.vQE));
                m33447kq(cbf.vQE);
                C21884c.m33444b(baseViewHolder);
                if (this.qPv.containsKey(Long.valueOf(cbf.vQE))) {
                    C21884c.m33439a((C13361a) this.qPv.remove(Long.valueOf(cbf.vQE)));
                }
            }
            this.qPs.put(Long.valueOf(cbf.vQE), Integer.valueOf(-1));
            m33442a(baseViewHolder);
            AppMethodBeat.m2505o(36792);
            return;
        } else if (c21891a.actionType == 7) {
            if (i < c21890d.qPP.size()) {
                C21892b c21892b2 = (C21892b) c21890d.qPP.get(i);
                if (c21892b2.showType == 2) {
                    m33445b(context, cbf, baseViewHolder, c21892b2, c21890d);
                    AppMethodBeat.m2505o(36792);
                    return;
                } else if (c21892b2.showType == 5) {
                    C23639t.makeText(context, C5046bo.m7532bc(c21892b2.title, ""), 0).show();
                    m33447kq(cbf.vQE);
                    C21884c.m33444b(baseViewHolder);
                    AppMethodBeat.m2505o(36792);
                    return;
                }
            }
        } else if (c21891a.actionType == 6) {
            C23639t.makeText(context, C5046bo.m7532bc(context.getString(C25738R.string.ein), ""), 0).show();
            this.qPu.add(Long.valueOf(cbf.vQE));
            C21884c.m33444b(baseViewHolder);
            C4879a.xxA.mo10055m(new C18312lc());
            m33442a(baseViewHolder);
            AppMethodBeat.m2505o(36792);
            return;
        } else if (c21891a.actionType == 2) {
            str = c21891a.jumpUrl;
            C4990ab.m7416i("MicroMsg.SnSABTestMgr", "jump url ".concat(String.valueOf(str)));
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("useJs", true);
            C24826a.gkE.mo38924i(intent, context);
            m33447kq(cbf.vQE);
            C21884c.m33444b(baseViewHolder);
            m33442a(baseViewHolder);
            AppMethodBeat.m2505o(36792);
            return;
        } else if (c21891a.actionType == 8) {
            AppMethodBeat.m2505o(36792);
            return;
        } else if (c21891a.actionType == 4) {
            str = cbf.vHl;
            LinkedList linkedList = new LinkedList();
            linkedList.add(str);
            C1207m c7109w = new C7109w(1, 5, "", linkedList.size(), linkedList, 0);
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14541a(c7109w, 0);
        }
        if (i == 4 || i == 1) {
            mo37370a(context, cbf, baseViewHolder);
        }
        AppMethodBeat.m2505o(36792);
    }

    /* renamed from: b */
    private static void m33444b(BaseViewHolder baseViewHolder) {
        AppMethodBeat.m2504i(36793);
        if (baseViewHolder == null) {
            AppMethodBeat.m2505o(36793);
            return;
        }
        if (baseViewHolder.rIc != null) {
            baseViewHolder.rIc.setVisibility(8);
        }
        if (baseViewHolder.rIe != null) {
            baseViewHolder.rIe.setVisibility(8);
        }
        if (baseViewHolder.rIh != null) {
            baseViewHolder.rIh.setVisibility(8);
        }
        if (baseViewHolder.rIj != null) {
            baseViewHolder.rIj.setVisibility(8);
        }
        if (baseViewHolder.rIt.getVisibility() == 8) {
            baseViewHolder.rIt.setVisibility(0);
        }
        if (baseViewHolder.rHv.getVisibility() == 8) {
            baseViewHolder.rHv.setVisibility(0);
        }
        if (baseViewHolder.mRR.getVisibility() == 8) {
            baseViewHolder.mRR.setVisibility(0);
        }
        AppMethodBeat.m2505o(36793);
    }

    static {
        AppMethodBeat.m2504i(36800);
        AppMethodBeat.m2505o(36800);
    }

    /* renamed from: a */
    private static String m33437a(String str, cbf cbf) {
        String str2;
        Throwable e;
        AppMethodBeat.m2504i(36794);
        try {
            if (C5046bo.isNullOrNil(str)) {
                str2 = "";
                AppMethodBeat.m2505o(36794);
            } else {
                int i;
                String str3 = cbf.vHl;
                C1720g.m3537RQ();
                C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str3);
                if (str.contains("{username}")) {
                    str = str.replace("{username}", aoO.mo16707Oj());
                }
                if (aoO.dtS == 1) {
                    i = 0;
                } else if (aoO.dtS == 2) {
                    i = 1;
                } else {
                    i = 2;
                }
                while (true) {
                    try {
                        str2 = str;
                        Matcher matcher = qPx.matcher(str2);
                        if (matcher.find() && matcher.groupCount() == 3) {
                            String group = matcher.group();
                            CharSequence group2 = i == 0 ? matcher.group(1) : i == 1 ? matcher.group(2) : matcher.group(3);
                            str = str2.replace(group, group2);
                        } else {
                            AppMethodBeat.m2505o(36794);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        C4990ab.printErrStackTrace("MicroMsg.SnSABTestMgr", e, "settext error ", new Object[0]);
                        AppMethodBeat.m2505o(36794);
                        return str2;
                    }
                }
                AppMethodBeat.m2505o(36794);
            }
        } catch (Exception e3) {
            e = e3;
            str2 = str;
            C4990ab.printErrStackTrace("MicroMsg.SnSABTestMgr", e, "settext error ", new Object[0]);
            AppMethodBeat.m2505o(36794);
            return str2;
        }
        return str2;
    }

    /* renamed from: a */
    private SpannableString m33436a(Context context, TextView textView, String str, cbf cbf, BaseViewHolder baseViewHolder, C21891a c21891a, C21892b c21892b, C21890d c21890d) {
        AppMethodBeat.m2504i(36795);
        Matcher matcher = qPw.matcher(str);
        if (matcher.find() && matcher.groupCount() == 1) {
            String group = matcher.group();
            String group2 = matcher.group(1);
            int indexOf = str.indexOf(group);
            String replace = str.replace(group, group2);
            textView.setOnClickListener(null);
            textView.setClickable(true);
            SpannableString spannableString = new SpannableString(replace);
            textView.setOnTouchListener(new C46247aa());
            final Context context2 = context;
            final cbf cbf2 = cbf;
            final C21891a c21891a2 = c21891a;
            final C21892b c21892b2 = c21892b;
            final BaseViewHolder baseViewHolder2 = baseViewHolder;
            final C21890d c21890d2 = c21890d;
            spannableString.setSpan(new C24944o(cbf.vHl, new C24945a() {
                /* renamed from: a */
                public final void mo25466a(View view, Object obj) {
                    AppMethodBeat.m2504i(36780);
                    C21884c.m33441a(C21884c.this, context2, cbf2, c21891a2, c21892b2, baseViewHolder2, c21890d2);
                    AppMethodBeat.m2505o(36780);
                }
            }), indexOf, group2.length() + indexOf, 33);
            AppMethodBeat.m2505o(36795);
            return spannableString;
        }
        SpannableString b = C44089j.m79292b(context, (CharSequence) str);
        AppMethodBeat.m2505o(36795);
        return b;
    }

    /* renamed from: a */
    public final void mo37369a(int i, String str, long j, TimeLineObject timeLineObject, boolean z, C4052bb c4052bb) {
    }

    /* renamed from: a */
    public final void mo37368a(int i, String str, long j, TimeLineObject timeLineObject, boolean z) {
        AppMethodBeat.m2504i(36796);
        if (this.qPv.containsKey(Long.valueOf(j))) {
            C13361a c13361a = (C13361a) this.qPv.get(Long.valueOf(j));
            if (c13361a.mEndTime == -1) {
                c13361a.mEndTime = System.currentTimeMillis();
            }
            c13361a.mo25467E(c13361a.qPJ, c13361a.qPK, 0, 0);
        }
        AppMethodBeat.m2505o(36796);
    }

    /* renamed from: a */
    private static void m33439a(C13361a c13361a) {
        AppMethodBeat.m2504i(36797);
        C21890d c21890d = c13361a.qPI;
        if (c21890d == null) {
            AppMethodBeat.m2505o(36797);
            return;
        }
        String str = c21890d.qPn;
        String str2 = c21890d.qPm;
        String str3 = c13361a.qPN;
        c13361a.mo25467E(c13361a.qPJ, c13361a.qPK, 0, 0);
        String str4 = c13361a.qPM;
        if (C5046bo.isNullOrNil(str4)) {
            str4 = c13361a.qPJ + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + c13361a.qPK + ":0:0";
        }
        String str5 = "";
        long j = c13361a.mStartTime / 1000;
        if (c13361a.mEndTime == -1) {
            c13361a.mEndTime = System.currentTimeMillis();
        }
        long j2 = c13361a.mEndTime / 1000;
        if (c13361a != null) {
            C4990ab.m7416i("MicroMsg.SnSABTestMgr", "report layerId: " + str + " expid " + str2 + " acton " + str4 + " starttime " + j + " timelineId: " + str3);
            C7060h.pYm.mo8381e(11917, str, str2, str5, str5, Integer.valueOf(1), str3, str4, Long.valueOf(j), Long.valueOf(j2));
        }
        AppMethodBeat.m2505o(36797);
    }

    /* renamed from: a */
    private boolean m33443a(Context context, cbf cbf, BaseViewHolder baseViewHolder, C21892b c21892b, C21890d c21890d) {
        AppMethodBeat.m2504i(36789);
        baseViewHolder.mRR.setBackgroundDrawable(null);
        int i = baseViewHolder.position - 1;
        if (this.qPr != null) {
            WeakReference weakReference = (WeakReference) this.qPr.rxR.get(Integer.valueOf(i));
            if (!(weakReference == null || weakReference.get() == null)) {
                ((View) weakReference.get()).setBackgroundDrawable(null);
            }
        }
        if (!baseViewHolder.rIi) {
            baseViewHolder.rIj = baseViewHolder.rIh.inflate();
            baseViewHolder.rIi = true;
            baseViewHolder.rIk = (LinearLayout) baseViewHolder.rIj.findViewById(2131827602);
        }
        baseViewHolder.rIj.setVisibility(0);
        baseViewHolder.rIt.setVisibility(8);
        baseViewHolder.rHv.setVisibility(8);
        List list = c21892b.hhZ;
        if (list.size() != baseViewHolder.rIk.getChildCount()) {
            baseViewHolder.rIk.removeAllViews();
            int fromDPToPix = C1338a.fromDPToPix(context, 10);
            for (i = 0; i < list.size(); i++) {
                TextView textView = new TextView(context);
                textView.setBackgroundResource(C25738R.drawable.bmc);
                textView.setPadding(fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
                textView.setTextSize(1, 14.0f * C1338a.m2860dm(context));
                textView.setTextColor(context.getResources().getColor(C25738R.color.f11782h4));
                baseViewHolder.rIk.addView(textView);
            }
        }
        i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                final C21891a c21891a = (C21891a) list.get(i2);
                TextView textView2 = (TextView) baseViewHolder.rIk.getChildAt(i2);
                textView2.setText(c21891a.qPQ);
                textView2.setTag(cbf);
                String a = C21884c.m33437a(C43542f.m77825a(c21891a), cbf);
                final Context context2 = context;
                final C21892b c21892b2 = c21892b;
                final BaseViewHolder baseViewHolder2 = baseViewHolder;
                final C21890d c21890d2 = c21890d;
                textView2.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(36777);
                        C21884c.m33440a(C21884c.this, context2, view, c21891a, c21892b2, baseViewHolder2, c21890d2);
                        AppMethodBeat.m2505o(36777);
                    }
                });
                textView2.setText(m33436a(context, textView2, a, cbf, baseViewHolder, c21891a, c21892b, c21890d), BufferType.SPANNABLE);
                if (c21891a.actionType != 5) {
                    textView2.setCompoundDrawablePadding(C1338a.fromDPToPix(context, 5));
                    textView2.setCompoundDrawablesWithIntrinsicBounds(context.getResources().getDrawable(C1318a.album_abtesti_icon2), null, null, null);
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(36789);
                return true;
            }
        }
    }
}

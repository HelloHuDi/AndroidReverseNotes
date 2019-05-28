package com.tencent.mm.plugin.sns.g;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.lb;
import com.tencent.mm.g.a.lc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.e;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.model.w;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.bb;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.pluginsdk.ui.e.o;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.protocal.protobuf.cbn;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
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

public final class c implements f, e {
    public static final Pattern qPw = Pattern.compile("\\{richtext:([\\s\\S]*?)\\}");
    public static final Pattern qPx = Pattern.compile("\\{sex:([\\s\\S]*?):([\\s\\S]*?):([\\s\\S]*?)\\}");
    public com.tencent.mm.plugin.sns.h.c qJD;
    public final int qOK = 14;
    public final int qPo = 500;
    public List<d> qPp;
    public ListView qPq;
    public au qPr;
    public Map<Long, Integer> qPs = new HashMap();
    public HashSet<Long> qPt = new HashSet();
    public HashSet<Long> qPu = new HashSet();
    public HashMap<Long, a> qPv = new HashMap();
    private com.tencent.mm.pluginsdk.ui.e.o.a qPy = new com.tencent.mm.pluginsdk.ui.e.o.a() {
        public final void a(View view, Object obj) {
        }
    };

    static class a {
        long mEndTime = -1;
        long mStartTime = -1;
        long qJo;
        d qPI;
        int qPJ = 0;
        int qPK = 0;
        String qPL = "";
        String qPM = "";
        String qPN;

        public a(long j, long j2, String str, d dVar) {
            this.qPI = dVar;
            this.mStartTime = j;
            this.qJo = j2;
            this.qPN = str;
        }

        public final void fl(int i, int i2) {
            this.qPJ = i;
            this.qPK = i2;
        }

        public final void E(int i, int i2, int i3, int i4) {
            AppMethodBeat.i(36781);
            if (i == -1 || i2 == -1) {
                AppMethodBeat.o(36781);
                return;
            }
            String str = i + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + i2 + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + i3 + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + i4;
            String str2 = i + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + i2;
            if (str.equals(this.qPL) || (this.qPL.startsWith(str2) && i3 == 0 && i4 == 0)) {
                AppMethodBeat.o(36781);
                return;
            }
            this.qPL = str;
            addAction(i + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + i2 + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + i3 + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + i4);
            AppMethodBeat.o(36781);
        }

        private void addAction(String str) {
            AppMethodBeat.i(36782);
            if (!bo.isNullOrNil(this.qPM)) {
                this.qPM += "|";
            }
            this.qPM += str;
            AppMethodBeat.o(36782);
        }
    }

    public c() {
        AppMethodBeat.i(36783);
        AppMethodBeat.o(36783);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(36784);
        ab.i("MicroMsg.SnSABTestMgr", "onSceneend " + i + " errCode " + i2);
        com.tencent.mm.sdk.b.a.xxA.m(new lb());
        AppMethodBeat.o(36784);
    }

    private void kq(long j) {
        AppMethodBeat.i(36785);
        if (this.qJD == null) {
            this.qJD = new com.tencent.mm.plugin.sns.h.c();
        }
        if (this.qJD.qQf.size() > 500) {
            this.qJD.qQf.remove(0);
        }
        this.qJD.qQf.add(Long.valueOf(j));
        AppMethodBeat.o(36785);
    }

    public final void clean() {
        AppMethodBeat.i(36786);
        this.qPq = null;
        this.qPr = null;
        if (this.qPt != null) {
            Iterator it = this.qPt.iterator();
            while (it.hasNext()) {
                Long l = (Long) it.next();
                m rVar = new r(l.longValue(), 0, 0, null);
                g.RQ();
                g.RO().eJo.a(rVar, 0);
                ab.i("MicroMsg.SnSABTestMgr", "report id ".concat(String.valueOf(l)));
            }
        }
        if (this.qPv != null) {
            for (a a : this.qPv.values()) {
                a(a);
            }
            this.qPv.clear();
        }
        if (this.qPp.size() == 0 || this.qJD == null) {
            AppMethodBeat.o(36786);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        g.RQ();
        String stringBuilder2 = stringBuilder.append(g.RP().cachePath).append("ws_1100004").toString();
        ab.i("MicroMsg.SnSABTestMgr", "listToFile to list  ".concat(String.valueOf(stringBuilder2)));
        try {
            byte[] toByteArray = this.qJD.toByteArray();
            com.tencent.mm.vfs.e.b(stringBuilder2, toByteArray, toByteArray.length);
            ab.i("MicroMsg.SnSABTestMgr", "listTofile " + (System.currentTimeMillis() - currentTimeMillis) + " igNoreAbTestId " + this.qJD.qQf.size());
            AppMethodBeat.o(36786);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.SnSABTestMgr", e, "listToFile failed: ".concat(String.valueOf(stringBuilder2)), new Object[0]);
            AppMethodBeat.o(36786);
        }
    }

    public static void c(View view, BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(36787);
        baseViewHolder.rId = false;
        baseViewHolder.rIc = (ViewStub) view.findViewById(R.id.en1);
        baseViewHolder.rIc.setVisibility(8);
        baseViewHolder.rIh = (ViewStub) view.findViewById(R.id.en8);
        baseViewHolder.rIh.setVisibility(8);
        AppMethodBeat.o(36787);
    }

    public final void a(Context context, cbf cbf, BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(36788);
        if (!aa.doo()) {
            b(baseViewHolder);
            AppMethodBeat.o(36788);
        } else if (this.qPp == null || this.qPp.size() == 0) {
            b(baseViewHolder);
            AppMethodBeat.o(36788);
        } else if (this.qPu.contains(Long.valueOf(cbf.vQE))) {
            b(baseViewHolder);
            baseViewHolder.rIt.setVisibility(8);
            baseViewHolder.rHv.setVisibility(8);
            baseViewHolder.mRR.setVisibility(8);
            AppMethodBeat.o(36788);
        } else if (cbf.vHl == null || cbf.vHl.equals(af.cnk())) {
            b(baseViewHolder);
            AppMethodBeat.o(36788);
        } else if (this.qJD == null || !this.qJD.qQf.contains(Long.valueOf(cbf.vQE))) {
            int i;
            if (cbf != null) {
                try {
                    byte[] a = com.tencent.mm.platformtools.aa.a(cbf.xaD);
                    if (bo.cb(a)) {
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
                    b(baseViewHolder);
                    AppMethodBeat.o(36788);
                    return;
                }
            }
            int i3 = i2;
            d dVar = null;
            for (d dVar2 : this.qPp) {
                if (dVar2 != null) {
                    if (dVar2.qPO == i) {
                        dVar = dVar2;
                        break;
                    }
                }
                b(baseViewHolder);
                AppMethodBeat.o(36788);
                return;
            }
            if (dVar == null) {
                b(baseViewHolder);
                AppMethodBeat.o(36788);
            } else if (i3 >= dVar.qPP.size()) {
                b(baseViewHolder);
                AppMethodBeat.o(36788);
            } else {
                final b bVar = (b) dVar.qPP.get(i3);
                int i4 = bVar.showType;
                b(baseViewHolder);
                if (i > 0) {
                    if (this.qPv.containsKey(Long.valueOf(cbf.vQE))) {
                        ((a) this.qPv.get(Long.valueOf(cbf.vQE))).fl(i4, bVar.hhZ.size());
                    } else {
                        a aVar = new a(System.currentTimeMillis(), cbf.vQE, i.jV(cbf.vQE), dVar);
                        aVar.fl(i4, bVar.hhZ.size());
                        this.qPv.put(Long.valueOf(cbf.vQE), aVar);
                    }
                    if (i4 == 1) {
                        String str = bVar.title;
                        if (!baseViewHolder.rId) {
                            baseViewHolder.rIe = baseViewHolder.rIc.inflate();
                            baseViewHolder.rId = true;
                            baseViewHolder.rIg = (TextView) baseViewHolder.rIe.findViewById(R.id.eeq);
                            baseViewHolder.rIf = (LinearLayout) baseViewHolder.rIe.findViewById(R.id.eer);
                        }
                        baseViewHolder.rIe.setVisibility(0);
                        baseViewHolder.rIg.setText(str);
                        List list = bVar.hhZ;
                        if (list.size() != baseViewHolder.rIf.getChildCount()) {
                            baseViewHolder.rIf.removeAllViews();
                            i2 = 0;
                            while (true) {
                                i = i2;
                                if (i >= list.size()) {
                                    break;
                                }
                                a aVar2 = (a) list.get(i);
                                TextView textView = new TextView(baseViewHolder.rIf.getContext());
                                textView.setText(aVar2.qPQ);
                                textView.setPadding(0, 0, com.tencent.mm.bz.a.fromDPToPix(context, 10), 0);
                                textView.setVisibility(0);
                                textView.setTextSize(1, 14.0f * com.tencent.mm.bz.a.dm(context));
                                textView.setTextColor(context.getResources().getColor(R.color.a0k));
                                baseViewHolder.rIf.addView(textView);
                                i2 = i + 1;
                            }
                        }
                        for (i2 = 0; i2 < list.size(); i2++) {
                            final a aVar3 = (a) list.get(i2);
                            TextView textView2 = (TextView) baseViewHolder.rIf.getChildAt(i2);
                            textView2.setText(a(context, textView2, a(f.a(aVar3), cbf), cbf, baseViewHolder, aVar3, bVar, dVar));
                            textView2.setTag(cbf);
                            final Context context2 = context;
                            final BaseViewHolder baseViewHolder2 = baseViewHolder;
                            final d dVar3 = dVar;
                            textView2.setOnClickListener(new OnClickListener() {
                                public final void onClick(View view) {
                                    AppMethodBeat.i(36776);
                                    c.a(c.this, context2, view, aVar3, bVar, baseViewHolder2, dVar3);
                                    AppMethodBeat.o(36776);
                                }
                            });
                        }
                        AppMethodBeat.o(36788);
                        return;
                    } else if (i4 == 4) {
                        a(context, cbf, baseViewHolder, bVar, dVar);
                        AppMethodBeat.o(36788);
                        return;
                    } else if (i4 == 2) {
                        if (b(context, cbf, baseViewHolder, bVar, dVar)) {
                            AppMethodBeat.o(36788);
                            return;
                        } else {
                            AppMethodBeat.o(36788);
                            return;
                        }
                    }
                }
                b(baseViewHolder);
                AppMethodBeat.o(36788);
            }
        } else {
            b(baseViewHolder);
            AppMethodBeat.o(36788);
        }
    }

    private boolean b(Context context, cbf cbf, BaseViewHolder baseViewHolder, b bVar, d dVar) {
        AppMethodBeat.i(36790);
        if (bVar.hhZ.size() == 2) {
            final a aVar = (a) bVar.hhZ.get(0);
            a aVar2 = (a) bVar.hhZ.get(1);
            String a = a(f.a(aVar), cbf);
            String a2 = a(f.a(aVar2), cbf);
            String a3 = a(bVar.title, cbf);
            String string = context.getString(R.string.tz);
            final Context context2 = context;
            final cbf cbf2 = cbf;
            final b bVar2 = bVar;
            final BaseViewHolder baseViewHolder2 = baseViewHolder;
            final d dVar2 = dVar;
            AnonymousClass3 anonymousClass3 = new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(36778);
                    ab.i("MicroMsg.SnSABTestMgr", "onClick alert1");
                    c.a(c.this, context2, cbf2, aVar, bVar2, baseViewHolder2, dVar2);
                    AppMethodBeat.o(36778);
                }
            };
            final Context context3 = context;
            final cbf cbf3 = cbf;
            final a aVar3 = aVar2;
            final b bVar3 = bVar;
            final BaseViewHolder baseViewHolder3 = baseViewHolder;
            final d dVar3 = dVar;
            h.d(context, a3, string, a, a2, anonymousClass3, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(36779);
                    ab.i("MicroMsg.SnSABTestMgr", "onClick alert2");
                    c.a(c.this, context3, cbf3, aVar3, bVar3, baseViewHolder3, dVar3);
                    AppMethodBeat.o(36779);
                }
            });
            AppMethodBeat.o(36790);
            return true;
        }
        AppMethodBeat.o(36790);
        return false;
    }

    private void a(BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(36791);
        if (baseViewHolder == null) {
            AppMethodBeat.o(36791);
            return;
        }
        Context context = baseViewHolder.mRR.getContext();
        if (context == null) {
            AppMethodBeat.o(36791);
            return;
        }
        if (baseViewHolder.mRR.getBackground() == null) {
            baseViewHolder.mRR.setBackgroundResource(R.drawable.k5);
            baseViewHolder.mRR.setPadding(com.tencent.mm.bz.a.fromDPToPix(context, 12), com.tencent.mm.bz.a.fromDPToPix(context, 12), com.tencent.mm.bz.a.fromDPToPix(context, 12), com.tencent.mm.bz.a.fromDPToPix(context, 8));
        }
        int i = baseViewHolder.position - 1;
        if (this.qPr != null) {
            WeakReference weakReference = (WeakReference) this.qPr.rxR.get(Integer.valueOf(i));
            if (weakReference == null || weakReference.get() == null) {
                AppMethodBeat.o(36791);
                return;
            } else {
                ((View) weakReference.get()).setBackgroundResource(R.drawable.k5);
                ((View) weakReference.get()).setPadding(com.tencent.mm.bz.a.fromDPToPix(context, 12), com.tencent.mm.bz.a.fromDPToPix(context, 12), com.tencent.mm.bz.a.fromDPToPix(context, 12), com.tencent.mm.bz.a.fromDPToPix(context, 8));
            }
        }
        AppMethodBeat.o(36791);
    }

    private void a(Context context, cbf cbf, a aVar, b bVar, BaseViewHolder baseViewHolder, d dVar) {
        AppMethodBeat.i(36792);
        ab.i("MicroMsg.SnSABTestMgr", "processButtonClick snsobj " + cbf.vHl + " " + cbf.vQE);
        int i = aVar.qPS - 1;
        a aVar2 = (a) this.qPv.get(Long.valueOf(cbf.vQE));
        if (aVar2 != null) {
            aVar2.E(bVar.showType, bVar.hhZ.size(), aVar.index, aVar.actionType);
            aVar2.qPJ = -1;
            aVar2.qPK = -1;
        }
        String str;
        if (aVar.actionType == 3) {
            this.qPt.add(Long.valueOf(cbf.vQE));
            this.qPs.put(Long.valueOf(cbf.vQE), Integer.valueOf(i));
        } else if (aVar.actionType == 1) {
            this.qPs.put(Long.valueOf(cbf.vQE), Integer.valueOf(i));
            kq(cbf.vQE);
            b(baseViewHolder);
        } else if (aVar.actionType == 5) {
            if (this.qPt.contains(Long.valueOf(cbf.vQE))) {
                this.qPt.remove(Long.valueOf(cbf.vQE));
                kq(cbf.vQE);
                b(baseViewHolder);
                if (this.qPv.containsKey(Long.valueOf(cbf.vQE))) {
                    a((a) this.qPv.remove(Long.valueOf(cbf.vQE)));
                }
            }
            this.qPs.put(Long.valueOf(cbf.vQE), Integer.valueOf(-1));
            a(baseViewHolder);
            AppMethodBeat.o(36792);
            return;
        } else if (aVar.actionType == 7) {
            if (i < dVar.qPP.size()) {
                b bVar2 = (b) dVar.qPP.get(i);
                if (bVar2.showType == 2) {
                    b(context, cbf, baseViewHolder, bVar2, dVar);
                    AppMethodBeat.o(36792);
                    return;
                } else if (bVar2.showType == 5) {
                    t.makeText(context, bo.bc(bVar2.title, ""), 0).show();
                    kq(cbf.vQE);
                    b(baseViewHolder);
                    AppMethodBeat.o(36792);
                    return;
                }
            }
        } else if (aVar.actionType == 6) {
            t.makeText(context, bo.bc(context.getString(R.string.ein), ""), 0).show();
            this.qPu.add(Long.valueOf(cbf.vQE));
            b(baseViewHolder);
            com.tencent.mm.sdk.b.a.xxA.m(new lc());
            a(baseViewHolder);
            AppMethodBeat.o(36792);
            return;
        } else if (aVar.actionType == 2) {
            str = aVar.jumpUrl;
            ab.i("MicroMsg.SnSABTestMgr", "jump url ".concat(String.valueOf(str)));
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("useJs", true);
            com.tencent.mm.plugin.sns.c.a.gkE.i(intent, context);
            kq(cbf.vQE);
            b(baseViewHolder);
            a(baseViewHolder);
            AppMethodBeat.o(36792);
            return;
        } else if (aVar.actionType == 8) {
            AppMethodBeat.o(36792);
            return;
        } else if (aVar.actionType == 4) {
            str = cbf.vHl;
            LinkedList linkedList = new LinkedList();
            linkedList.add(str);
            m wVar = new w(1, 5, "", linkedList.size(), linkedList, 0);
            g.RQ();
            g.RO().eJo.a(wVar, 0);
        }
        if (i == 4 || i == 1) {
            a(context, cbf, baseViewHolder);
        }
        AppMethodBeat.o(36792);
    }

    private static void b(BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(36793);
        if (baseViewHolder == null) {
            AppMethodBeat.o(36793);
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
        AppMethodBeat.o(36793);
    }

    static {
        AppMethodBeat.i(36800);
        AppMethodBeat.o(36800);
    }

    private static String a(String str, cbf cbf) {
        String str2;
        Throwable e;
        AppMethodBeat.i(36794);
        try {
            if (bo.isNullOrNil(str)) {
                str2 = "";
                AppMethodBeat.o(36794);
            } else {
                int i;
                String str3 = cbf.vHl;
                g.RQ();
                ad aoO = ((j) g.K(j.class)).XM().aoO(str3);
                if (str.contains("{username}")) {
                    str = str.replace("{username}", aoO.Oj());
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
                            AppMethodBeat.o(36794);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        ab.printErrStackTrace("MicroMsg.SnSABTestMgr", e, "settext error ", new Object[0]);
                        AppMethodBeat.o(36794);
                        return str2;
                    }
                }
                AppMethodBeat.o(36794);
            }
        } catch (Exception e3) {
            e = e3;
            str2 = str;
            ab.printErrStackTrace("MicroMsg.SnSABTestMgr", e, "settext error ", new Object[0]);
            AppMethodBeat.o(36794);
            return str2;
        }
        return str2;
    }

    private SpannableString a(Context context, TextView textView, String str, cbf cbf, BaseViewHolder baseViewHolder, a aVar, b bVar, d dVar) {
        AppMethodBeat.i(36795);
        Matcher matcher = qPw.matcher(str);
        if (matcher.find() && matcher.groupCount() == 1) {
            String group = matcher.group();
            String group2 = matcher.group(1);
            int indexOf = str.indexOf(group);
            String replace = str.replace(group, group2);
            textView.setOnClickListener(null);
            textView.setClickable(true);
            SpannableString spannableString = new SpannableString(replace);
            textView.setOnTouchListener(new com.tencent.mm.plugin.sns.ui.aa());
            final Context context2 = context;
            final cbf cbf2 = cbf;
            final a aVar2 = aVar;
            final b bVar2 = bVar;
            final BaseViewHolder baseViewHolder2 = baseViewHolder;
            final d dVar2 = dVar;
            spannableString.setSpan(new o(cbf.vHl, new com.tencent.mm.pluginsdk.ui.e.o.a() {
                public final void a(View view, Object obj) {
                    AppMethodBeat.i(36780);
                    c.a(c.this, context2, cbf2, aVar2, bVar2, baseViewHolder2, dVar2);
                    AppMethodBeat.o(36780);
                }
            }), indexOf, group2.length() + indexOf, 33);
            AppMethodBeat.o(36795);
            return spannableString;
        }
        SpannableString b = com.tencent.mm.pluginsdk.ui.e.j.b(context, (CharSequence) str);
        AppMethodBeat.o(36795);
        return b;
    }

    public final void a(int i, String str, long j, TimeLineObject timeLineObject, boolean z, bb bbVar) {
    }

    public final void a(int i, String str, long j, TimeLineObject timeLineObject, boolean z) {
        AppMethodBeat.i(36796);
        if (this.qPv.containsKey(Long.valueOf(j))) {
            a aVar = (a) this.qPv.get(Long.valueOf(j));
            if (aVar.mEndTime == -1) {
                aVar.mEndTime = System.currentTimeMillis();
            }
            aVar.E(aVar.qPJ, aVar.qPK, 0, 0);
        }
        AppMethodBeat.o(36796);
    }

    private static void a(a aVar) {
        AppMethodBeat.i(36797);
        d dVar = aVar.qPI;
        if (dVar == null) {
            AppMethodBeat.o(36797);
            return;
        }
        String str = dVar.qPn;
        String str2 = dVar.qPm;
        String str3 = aVar.qPN;
        aVar.E(aVar.qPJ, aVar.qPK, 0, 0);
        String str4 = aVar.qPM;
        if (bo.isNullOrNil(str4)) {
            str4 = aVar.qPJ + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + aVar.qPK + ":0:0";
        }
        String str5 = "";
        long j = aVar.mStartTime / 1000;
        if (aVar.mEndTime == -1) {
            aVar.mEndTime = System.currentTimeMillis();
        }
        long j2 = aVar.mEndTime / 1000;
        if (aVar != null) {
            ab.i("MicroMsg.SnSABTestMgr", "report layerId: " + str + " expid " + str2 + " acton " + str4 + " starttime " + j + " timelineId: " + str3);
            com.tencent.mm.plugin.report.service.h.pYm.e(11917, str, str2, str5, str5, Integer.valueOf(1), str3, str4, Long.valueOf(j), Long.valueOf(j2));
        }
        AppMethodBeat.o(36797);
    }

    private boolean a(Context context, cbf cbf, BaseViewHolder baseViewHolder, b bVar, d dVar) {
        AppMethodBeat.i(36789);
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
            baseViewHolder.rIk = (LinearLayout) baseViewHolder.rIj.findViewById(R.id.ees);
        }
        baseViewHolder.rIj.setVisibility(0);
        baseViewHolder.rIt.setVisibility(8);
        baseViewHolder.rHv.setVisibility(8);
        List list = bVar.hhZ;
        if (list.size() != baseViewHolder.rIk.getChildCount()) {
            baseViewHolder.rIk.removeAllViews();
            int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(context, 10);
            for (i = 0; i < list.size(); i++) {
                TextView textView = new TextView(context);
                textView.setBackgroundResource(R.drawable.bmc);
                textView.setPadding(fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
                textView.setTextSize(1, 14.0f * com.tencent.mm.bz.a.dm(context));
                textView.setTextColor(context.getResources().getColor(R.color.h4));
                baseViewHolder.rIk.addView(textView);
            }
        }
        i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                final a aVar = (a) list.get(i2);
                TextView textView2 = (TextView) baseViewHolder.rIk.getChildAt(i2);
                textView2.setText(aVar.qPQ);
                textView2.setTag(cbf);
                String a = a(f.a(aVar), cbf);
                final Context context2 = context;
                final b bVar2 = bVar;
                final BaseViewHolder baseViewHolder2 = baseViewHolder;
                final d dVar2 = dVar;
                textView2.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(36777);
                        c.a(c.this, context2, view, aVar, bVar2, baseViewHolder2, dVar2);
                        AppMethodBeat.o(36777);
                    }
                });
                textView2.setText(a(context, textView2, a, cbf, baseViewHolder, aVar, bVar, dVar), BufferType.SPANNABLE);
                if (aVar.actionType != 5) {
                    textView2.setCompoundDrawablePadding(com.tencent.mm.bz.a.fromDPToPix(context, 5));
                    textView2.setCompoundDrawablesWithIntrinsicBounds(context.getResources().getDrawable(R.raw.album_abtesti_icon2), null, null, null);
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(36789);
                return true;
            }
        }
    }
}

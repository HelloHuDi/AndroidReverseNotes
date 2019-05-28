package com.tencent.mm.ui.chatting.a;

import android.os.Bundle;
import android.os.Looper;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.a.e;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.ba.r;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.u;
import com.tencent.mm.pluginsdk.ui.chat.l;
import com.tencent.mm.pluginsdk.ui.e.g;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.ag;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.s;
import com.tencent.mm.ui.chatting.s.f;
import com.tencent.mm.ui.chatting.viewitems.ad.b;
import com.tencent.mm.ui.chatting.viewitems.am.d;
import com.tencent.mm.ui.chatting.viewitems.az;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public final class a extends BaseAdapter implements h {
    private boolean ceU;
    public c elH = null;
    private int emW = -1;
    private LayoutInflater ezi;
    private HashSet jNF = new HashSet();
    private ListView mListView;
    private g yGy;
    public s.g yMW;
    private s.g yMX;
    public f yMY;
    private f yMZ;
    public l yNa;
    private l yNb;
    public x yNc;
    private x yNd;
    public com.tencent.mm.ui.chatting.c yNe;
    private com.tencent.mm.ui.chatting.c yNf;
    private OnClickListener yNg = null;
    private final int yNh;
    private final int yNi;
    public SparseArray<bi> yNj = new SparseArray();
    private HashSet<Long> yNk = new HashSet();
    public SparseIntArray yNl = new SparseIntArray();
    public long yNm = -1;
    private TreeSet<Long> yNn = new TreeSet();
    private Map<Long, Integer> yNo = new HashMap();
    private Map<Long, WeakReference<View>> yNp = new HashMap();
    private boolean yNq = false;
    private boolean yNr = false;
    private final ap yNs = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(31095);
            if (a.this.yod != null && a.this.yod.caA) {
                ab.i("MicroMsg.ChattingDataAdapter", "[onTimerExpired]");
                a.this.dCT();
            }
            AppMethodBeat.o(31095);
            return true;
        }
    }, true);
    public com.tencent.mm.ui.chatting.l.a.a yNt;
    private boolean yNu = false;
    private int yNv = 0;
    protected com.tencent.mm.plugin.messenger.foundation.a.a.h.a yNw = new com.tencent.mm.plugin.messenger.foundation.a.a.h.a() {
        public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.h hVar, com.tencent.mm.plugin.messenger.foundation.a.a.h.c cVar) {
            AppMethodBeat.i(31097);
            if (hVar == null || cVar == null) {
                AppMethodBeat.o(31097);
            } else if (cVar.talker == null || a.this.yod.getTalkerUserName() == null) {
                AppMethodBeat.o(31097);
            } else {
                if (cVar.talker.equals(a.this.yod.getTalkerUserName())) {
                    a.this.dCT();
                }
                AppMethodBeat.o(31097);
            }
        }
    };
    private com.tencent.mm.modelvideo.t.a yNx = new com.tencent.mm.modelvideo.t.a() {
        public final void a(com.tencent.mm.modelvideo.t.a.a aVar) {
            AppMethodBeat.i(31099);
            boolean z = false;
            if (!(aVar == null || aVar.fXk == 3 || (aVar.fXk != 2 && aVar.fXk != -1 && aVar.fXk != 1))) {
                z = d.b(aVar);
            }
            if (!z) {
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(31098);
                        a.this.dCT();
                        AppMethodBeat.o(31098);
                    }
                });
            }
            AppMethodBeat.o(31099);
        }
    };
    private long yNy = -1;
    private com.tencent.mm.ui.chatting.d.a yod;

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(31130);
        bi Ou = Ou(i);
        AppMethodBeat.o(31130);
        return Ou;
    }

    public a(com.tencent.mm.ui.chatting.d.a aVar, ListView listView) {
        AppMethodBeat.i(31100);
        aVar.a(h.class, this);
        this.mListView = listView;
        this.yod = aVar;
        this.ezi = v.hu(aVar.yTx.getContext());
        this.yNh = aVar.yTx.getMMResources().getDimensionPixelSize(R.dimen.nj);
        this.yNi = aVar.yTx.getMMResources().getDimensionPixelSize(R.dimen.le);
        s.g gVar = new s.g();
        this.yMX = gVar;
        this.yMW = gVar;
        f fVar = new f(aVar);
        this.yMZ = fVar;
        this.yMY = fVar;
        l lVar = new l(aVar.yTx.getContext());
        this.yNb = lVar;
        this.yNa = lVar;
        x xVar = new x(aVar);
        this.yNd = xVar;
        this.yNc = xVar;
        com.tencent.mm.ui.chatting.c cVar = new com.tencent.mm.ui.chatting.c(aVar);
        this.yNf = cVar;
        this.yNe = cVar;
        this.yGy = new ag(aVar);
        if (this.elH == null) {
            com.tencent.mm.at.a.a.c.a aVar2 = new com.tencent.mm.at.a.a.c.a();
            aVar2.ePK = e.rz(this.yod.getTalkerUserName());
            aVar2.ePH = true;
            aVar2.ePZ = true;
            aVar2.ePT = R.raw.default_avatar;
            this.elH = aVar2.ahG();
        }
        AppMethodBeat.o(31100);
    }

    public final int getCount() {
        AppMethodBeat.i(31101);
        int size = this.yNj.size();
        AppMethodBeat.o(31101);
        return size;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.i(31102);
        int bN = az.bN(Ou(i));
        AppMethodBeat.o(31102);
        return bN;
    }

    public final int getViewTypeCount() {
        AppMethodBeat.i(31103);
        int dHt = az.dHt();
        AppMethodBeat.o(31103);
        return dHt;
    }

    /* JADX WARNING: Removed duplicated region for block: B:97:0x02c3  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0306  */
    /* JADX WARNING: Missing block: B:84:0x0289, code skipped:
            if (r0 == null) goto L_0x028b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final View getView(int i, View view, ViewGroup viewGroup) {
        Object obj;
        Object obj2;
        Object obj3;
        int intValue;
        com.tencent.mm.ui.chatting.viewitems.c.a aVar;
        AppMethodBeat.i(31104);
        bi Ou = Ou(i);
        ab.i("MicroMsg.ChattingDataAdapter", "[getView] position:" + i + " msgId:" + Ou.field_msgId + " svrId:" + Ou.field_msgSvrId + " type:" + Ou.getType() + " send:" + Ou.field_isSend + " talker:" + Ou.field_talker + " msgSep:" + Ou.field_msgSeq + " time:" + Ou.field_createTime);
        if (i == 0) {
            com.tencent.mm.ui.chatting.d.a aVar2 = this.yod;
            ab.i("MicroMsg.ChattingContext", "[scrollToLastProtect]");
            aVar2.yTy.dCD();
        }
        if (i != 0 && this.yNl.get(i) == 0) {
            long j = Ou(i - 1).field_createTime;
            long j2 = Ou.field_createTime;
            obj = j2 - j < 60000 ? 1 : null;
            obj2 = (j2 - j) / 180000 < 1 ? 1 : null;
            if (obj == null && obj2 == null) {
                this.yNl.put(i, 1);
            } else {
                this.yNl.put(i, 2);
            }
        }
        if ((this.yNl.get(i) == 1 || i == 0 || this.yNk.contains(Long.valueOf(Ou.field_msgId))) && Ou.field_createTime > 1000) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        if (Ou.field_msgId == this.yNm) {
            obj3 = 1;
        } else {
            obj3 = null;
        }
        com.tencent.mm.ba.a sU = r.aiy().sU(this.yod.getTalkerUserName());
        boolean z = true;
        if (sU == null) {
            aw.ZK();
            intValue = ((Integer) com.tencent.mm.model.c.Ry().get(12311, Integer.valueOf(-2))).intValue();
        } else {
            intValue = sU.fLV;
        }
        if (intValue != -2) {
            z = false;
        }
        com.tencent.mm.ui.chatting.viewitems.c.a aVar3;
        if (view == null) {
            com.tencent.mm.ui.chatting.viewitems.c bM = az.bM(Ou);
            view = bM.a(this.ezi, view);
            aVar3 = (com.tencent.mm.ui.chatting.viewitems.c.a) view.getTag();
            aVar3.zbA = bM;
            aVar3.setChattingBG(z);
            aVar = aVar3;
        } else {
            aVar3 = (com.tencent.mm.ui.chatting.viewitems.c.a) view.getTag();
            aVar3.setChattingBG(z);
            aVar = aVar3;
        }
        ab.d("MicroMsg.ChattingDataAdapter", "dealItemView() ChattingItem:%s", aVar.zbA);
        if (obj2 != null) {
            aVar.enf.setVisibility(0);
            aVar.enf.setText(com.tencent.mm.pluginsdk.f.h.c(this.yod.yTx.getContext(), Ou.field_createTime, false));
            if (aVar.enf.getTextSize() > ((float) com.tencent.mm.bz.a.fromDPToPix(this.yod.yTx.getContext(), 25))) {
                ab.e("MicroMsg.ChattingDataAdapter", "WDF!!! TextSize:%s", Float.valueOf(aVar.enf.getTextSize()));
            }
        } else {
            aVar.enf.setVisibility(8);
        }
        if (aVar.zbx != null) {
            if (obj3 != null) {
                aVar.zbx.setVisibility(0);
            } else {
                aVar.zbx.setVisibility(8);
            }
        }
        com.tencent.mm.ui.chatting.viewitems.c cVar = aVar.zbA;
        aVar.zbz = null;
        com.tencent.mm.aw.e aih = com.tencent.mm.aw.a.aih();
        if (aih != null && aih.fJU != null && aih.fJS == 0 && com.tencent.mm.aw.a.aie()) {
            aVar.zbz = aih.fJU;
        }
        cVar.a(aVar, i, this.yod, Ou);
        com.tencent.mm.pluginsdk.ui.e dDJ = ((com.tencent.mm.ui.chatting.c.b.c) this.yod.aF(com.tencent.mm.ui.chatting.c.b.c.class)).dDJ();
        if (aVar.enf.getVisibility() == 0 && dDJ != null) {
            aVar.enf.setTextColor(dDJ.vgW);
            if (dDJ.vgX) {
                aVar.enf.setShadowLayer(2.0f, 1.2f, 1.2f, dDJ.vgY);
            } else {
                aVar.enf.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
            if (dDJ.vgZ) {
                if (dDJ.vha) {
                    aVar.enf.setBackgroundResource(R.drawable.hw);
                } else {
                    aVar.enf.setBackgroundResource(R.drawable.hv);
                }
                aVar.enf.setPadding(this.yNi, this.yNh, this.yNi, this.yNh);
            } else {
                aVar.enf.setBackgroundColor(0);
            }
        }
        if (!(aVar.qkY == null || aVar.qkY.getVisibility() != 0 || dDJ == null || this.yod.getTalkerUserName().equals("qqmail") || Ou.getType() == 318767153)) {
            if (dDJ.vha) {
                aVar.qkY.setTextColor(-1);
                aVar.qkY.setShadowLayer((float) com.tencent.mm.bz.a.fromDPToPix(aVar.qkY.getContext(), 2), 0.0f, (float) com.tencent.mm.bz.a.fromDPToPix(aVar.qkY.getContext(), 1), this.yod.yTx.getMMResources().getColor(R.color.n));
            } else {
                aVar.qkY.setTextColor(dDJ.vgW);
                aVar.qkY.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
        }
        if (aVar.iVh != null) {
            aVar.iVh.setTag(Long.valueOf(Ou.field_msgId));
        }
        if (this.yNq) {
            if (Ou.isSystem()) {
                obj = null;
            } else {
                obj = 1;
            }
        }
        if (!this.yNr) {
            aVar.qy(false);
            for (Entry entry : this.yNp.entrySet()) {
                if (entry.getValue() != null && ((View) ((WeakReference) entry.getValue()).get()) == view) {
                    this.yNp.remove(entry.getKey());
                    this.yNo.remove(entry.getKey());
                    break;
                }
            }
            this.yNp.put(Long.valueOf(Ou.field_msgId), new WeakReference(view));
            if (Ou.drE()) {
                this.yNo.put(Long.valueOf(Ou.field_msgId), Integer.valueOf(Ou.field_isSend));
            }
            AppMethodBeat.o(31104);
            return view;
        }
        if (aVar.moo != null) {
            aVar.moo.setChecked(this.yNn.contains(Long.valueOf(Ou.field_msgId)));
        }
        if (aVar.iVh != null) {
            aVar.iVh.setOnClickListener(this.yNg);
        }
        aVar.qy(true);
        for (Entry entry2 : this.yNp.entrySet()) {
        }
        this.yNp.put(Long.valueOf(Ou.field_msgId), new WeakReference(view));
        if (Ou.drE()) {
        }
        AppMethodBeat.o(31104);
        return view;
    }

    private void dCO() {
        AppMethodBeat.i(31105);
        ab.d("MicroMsg.ChattingDataAdapter", "disable clickListener");
        this.yMW = null;
        this.yMY = null;
        this.yNa = null;
        this.yNc = null;
        this.yNe = null;
        AppMethodBeat.o(31105);
    }

    public final void resume() {
        AppMethodBeat.i(31106);
        this.ceU = true;
        ab.i("MicroMsg.ChattingDataAdapter", "adapter resume");
        aw.ZK();
        com.tencent.mm.model.c.XO().a(this.yNw, Looper.getMainLooper());
        j.a(this.yGy);
        this.yNs.ae(300000, 300000);
        if (this.yNt != null) {
            this.yNt.a(com.tencent.mm.ui.chatting.f.d.a.ACTION_UPDATE, false, null);
        }
        AppMethodBeat.o(31106);
    }

    public final void pause() {
        AppMethodBeat.i(31107);
        this.ceU = false;
        aw.ZK();
        com.tencent.mm.model.c.XO().a(this.yNw);
        j.b(this.yGy);
        ab.i("MicroMsg.ChattingDataAdapter", "adapter pause");
        this.yNs.stopTimer();
        AppMethodBeat.o(31107);
    }

    public final void dhG() {
        AppMethodBeat.i(31108);
        com.tencent.mm.ui.chatting.d.a.dFz().post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(31096);
                a.this.notifyDataSetChanged();
                AppMethodBeat.o(31096);
            }
        });
        AppMethodBeat.o(31108);
    }

    public final int dCP() {
        AppMethodBeat.i(31109);
        if (-1 == this.emW) {
            aw.ZK();
            this.emW = com.tencent.mm.model.c.XO().Rp(this.yod.getTalkerUserName());
        }
        int i = this.emW;
        AppMethodBeat.o(31109);
        return i;
    }

    public final bi Ou(int i) {
        AppMethodBeat.i(31110);
        bi biVar = (bi) this.yNj.get(i);
        AppMethodBeat.o(31110);
        return biVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0061  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean nf(long j) {
        View view;
        boolean z = false;
        AppMethodBeat.i(31111);
        if (this.yNn.contains(Long.valueOf(j))) {
            ab.d("MicroMsg.ChattingDataAdapter", "remove select item, msgId = %d", Long.valueOf(j));
            this.yNn.remove(Long.valueOf(j));
        } else {
            ab.d("MicroMsg.ChattingDataAdapter", "add select item, msgId = %d", Long.valueOf(j));
            if (this.yNn.size() >= 100) {
                com.tencent.mm.ui.base.h.b(this.yod.yTx.getContext(), this.yod.yTx.getMMResources().getString(R.string.beb, new Object[]{Integer.valueOf(100)}), "", true);
                AppMethodBeat.o(31111);
                return false;
            }
            this.yNn.add(Long.valueOf(j));
        }
        if (this.mListView != null) {
            com.tencent.mm.ui.chatting.viewitems.c.a aVar;
            while (true) {
                boolean z2 = z;
                if (z2 >= this.mListView.getChildCount()) {
                    break;
                }
                View childAt = this.mListView.getChildAt(z2);
                aVar = (com.tencent.mm.ui.chatting.viewitems.c.a) childAt.getTag();
                if (aVar != null && aVar.iVh != null && ((Long) aVar.iVh.getTag()).longValue() == j) {
                    view = childAt;
                    break;
                }
                z = z2 + 1;
            }
            if (view == null) {
                aVar = (com.tencent.mm.ui.chatting.viewitems.c.a) view.getTag();
                if (aVar.moo != null && aVar.moo.getVisibility() == 0) {
                    aVar.moo.setChecked(this.yNn.contains(Long.valueOf(j)));
                }
            } else {
                notifyDataSetChanged();
            }
            AppMethodBeat.o(31111);
            return true;
        }
        view = null;
        if (view == null) {
        }
        AppMethodBeat.o(31111);
        return true;
    }

    public final int cdf() {
        AppMethodBeat.i(31112);
        int size = this.yNn.size();
        AppMethodBeat.o(31112);
        return size;
    }

    public final Set<Long> dCQ() {
        return this.yNn;
    }

    public final void dCR() {
        AppMethodBeat.i(31113);
        if (this.yNn != null) {
            this.yNn.clear();
        }
        AppMethodBeat.o(31113);
    }

    public final void bvQ() {
        AppMethodBeat.i(31114);
        this.yNq = false;
        notifyDataSetChanged();
        ab.d("MicroMsg.ChattingDataAdapter", "enable ClickListener");
        this.yMW = this.yMX;
        this.yMY = this.yMZ;
        this.yNa = this.yNb;
        this.yNc = this.yNd;
        this.yNe = this.yNf;
        AppMethodBeat.o(31114);
    }

    public final void dCS() {
        AppMethodBeat.i(31115);
        this.yNq = true;
        notifyDataSetChanged();
        dCO();
        AppMethodBeat.o(31115);
    }

    public final boolean isInEditMode() {
        return this.yNq;
    }

    public final void c(OnClickListener onClickListener) {
        this.yNg = onClickListener;
    }

    public final void notifyDataSetChanged() {
        AppMethodBeat.i(31116);
        super.notifyDataSetChanged();
        this.yNl.clear();
        AppMethodBeat.o(31116);
    }

    public final void dCT() {
        AppMethodBeat.i(31117);
        if (this.yNu) {
            this.yNv++;
            ab.i("MicroMsg.ChattingDataAdapter", "[handleMsgChange] isLockNotify:" + this.yNv);
            AppMethodBeat.o(31117);
        } else if (this.ceU) {
            this.yNt.a(com.tencent.mm.ui.chatting.f.d.a.ACTION_UPDATE, false, null);
            AppMethodBeat.o(31117);
        } else {
            ab.i("MicroMsg.ChattingDataAdapter", "[handleMsgChange] is not resumeState ");
            AppMethodBeat.o(31117);
        }
    }

    public final void Ov(int i) {
        boolean z = false;
        AppMethodBeat.i(31118);
        bi Ou = Ou(i);
        String str = "MicroMsg.ChattingDataAdapter";
        String str2 = "[setShowHistoryMsgTipId] pos:%s msg is null? %s";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i);
        if (Ou == null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        ab.i(str, str2, objArr);
        if (!(Ou == null || Ou.field_msgId == 0)) {
            this.yNm = Ou.field_msgId;
        }
        notifyDataSetChanged();
        AppMethodBeat.o(31118);
    }

    public final void a(long j, boolean z, com.tencent.mm.ui.chatting.f.d.a aVar) {
        AppMethodBeat.i(31119);
        ab.i("MicroMsg.ChattingDataAdapter", "[locationByMsgId] messageId:%s loadAllBottomMsg:%s mode:%s", Long.valueOf(j), Boolean.valueOf(z), aVar);
        Bundle bundle = new Bundle();
        bundle.putLong("MSG_ID", j);
        bundle.putInt("SCENE", 1);
        bundle.putBoolean("IS_LOAD_ALL", z);
        this.yNt.a(aVar, true, bundle);
        AppMethodBeat.o(31119);
    }

    public final void a(int i, com.tencent.mm.ui.chatting.f.d.a aVar) {
        AppMethodBeat.i(31120);
        ab.i("MicroMsg.ChattingDataAdapter", "[locationByMsgId] position:%s mode:%s", Integer.valueOf(i), aVar);
        Bundle bundle = new Bundle();
        bundle.putInt("MSG_POSITION", i);
        bundle.putInt("SCENE", 2);
        this.yNt.a(aVar, false, bundle);
        AppMethodBeat.o(31120);
    }

    public final void dCU() {
        AppMethodBeat.i(31121);
        ab.i("MicroMsg.ChattingDataAdapter", "[lockNotify] isLockNotify:%s notifyCountWhileLock:%s", Boolean.valueOf(this.yNu), Integer.valueOf(this.yNv));
        if (this.yNu) {
            AppMethodBeat.o(31121);
            return;
        }
        this.yNu = true;
        this.yNv = 0;
        AppMethodBeat.o(31121);
    }

    public final void dCV() {
        AppMethodBeat.i(31122);
        ab.i("MicroMsg.ChattingDataAdapter", "[unLockNotify] isLockNotify:%s notifyCountWhileLock:%s", Boolean.valueOf(this.yNu), Integer.valueOf(this.yNv));
        if (this.yNu) {
            this.yNu = false;
            if (this.yNv > 0) {
                this.yNt.a(com.tencent.mm.ui.chatting.f.d.a.ACTION_UPDATE, false, null);
            }
            this.yNv = 0;
            AppMethodBeat.o(31122);
            return;
        }
        AppMethodBeat.o(31122);
    }

    public final void o(long j, int i, int i2) {
        AppMethodBeat.i(31123);
        if (this.yNp.containsKey(Long.valueOf(j)) && this.yNo.containsKey(Long.valueOf(j))) {
            WeakReference weakReference = (WeakReference) this.yNp.get(Long.valueOf(j));
            View view = weakReference != null ? (View) weakReference.get() : null;
            if (view != null) {
                b.a((com.tencent.mm.ui.chatting.viewitems.c.a) view.getTag(), i, i2);
            }
            AppMethodBeat.o(31123);
            return;
        }
        ab.d("MicroMsg.ChattingDataAdapter", "msg not display, ".concat(String.valueOf(j)));
        AppMethodBeat.o(31123);
    }

    public final void B(long j, boolean z) {
        AppMethodBeat.i(31124);
        if (this.yNp.containsKey(Long.valueOf(j)) && this.yNo.containsKey(Long.valueOf(j))) {
            WeakReference weakReference = (WeakReference) this.yNp.get(Long.valueOf(j));
            View view = weakReference != null ? (View) weakReference.get() : null;
            if (view != null) {
                b.a((com.tencent.mm.ui.chatting.viewitems.c.a) view.getTag(), z);
            }
            AppMethodBeat.o(31124);
            return;
        }
        ab.d("MicroMsg.ChattingDataAdapter", "msg not display, ".concat(String.valueOf(j)));
        AppMethodBeat.o(31124);
    }

    public final void a(long j, bi biVar, boolean z) {
        AppMethodBeat.i(31125);
        if (this.yNp.containsKey(Long.valueOf(j)) && this.yNo.containsKey(Long.valueOf(j))) {
            WeakReference weakReference = (WeakReference) this.yNp.get(Long.valueOf(j));
            View view = weakReference != null ? (View) weakReference.get() : null;
            if (view != null) {
                com.tencent.mm.ui.chatting.viewitems.ad.a.a(this.yod.yTx.getContext(), (com.tencent.mm.ui.chatting.viewitems.c.a) view.getTag(), biVar, z);
            }
            AppMethodBeat.o(31125);
            return;
        }
        ab.d("MicroMsg.ChattingDataAdapter", "msg not display, ".concat(String.valueOf(j)));
        AppMethodBeat.o(31125);
    }

    public final void Ow(int i) {
        AppMethodBeat.i(31126);
        bi Ou = Ou(i);
        if (!(Ou == null || Ou.field_msgId == 0)) {
            this.yNk.add(Long.valueOf(Ou.field_msgId));
        }
        AppMethodBeat.o(31126);
    }

    public final void dCW() {
        AppMethodBeat.i(31127);
        this.yNr = true;
        dCO();
        AppMethodBeat.o(31127);
    }

    public final com.tencent.mm.modelvideo.t.a dCX() {
        return this.yNx;
    }

    public final f dCY() {
        return this.yMY;
    }

    public final s.g dCZ() {
        return this.yMW;
    }

    public final x dDa() {
        return this.yNc;
    }

    public final l dDb() {
        return this.yNa;
    }

    public final com.tencent.mm.ui.chatting.c dDc() {
        return this.yNe;
    }

    public final long dDd() {
        AppMethodBeat.i(31128);
        long j;
        if (this.yNy != -1) {
            j = this.yNy;
            AppMethodBeat.o(31128);
            return j;
        }
        this.yNy = 0;
        for (int count = getCount() - 1; count >= 0; count--) {
            bi Ou = Ou(count);
            if (Ou.field_isSend == 1 && (Ou.dqI & 4) != 4) {
                this.yNy = Ou.field_msgId;
                break;
            }
        }
        j = this.yNy;
        AppMethodBeat.o(31128);
        return j;
    }

    public final c dDe() {
        return this.elH;
    }

    public final void dD(int i, int i2) {
        AppMethodBeat.i(31129);
        if (this.yod == null) {
            AppMethodBeat.o(31129);
            return;
        }
        ad adVar = this.yod.sRl;
        bi biVar;
        if (adVar == null) {
            AppMethodBeat.o(31129);
        } else if (adVar.dsf()) {
            ArrayList arrayList = new ArrayList();
            while (i <= i2) {
                biVar = (bi) this.yNj.get(i);
                if (!(biVar == null || biVar.getType() != 285212721 || this.jNF.contains(Long.valueOf(biVar.field_msgId)))) {
                    ab.v("MicroMsg.ChattingDataAdapter", "terry checkpreload:" + biVar.field_msgId);
                    this.jNF.add(Long.valueOf(biVar.field_msgId));
                    arrayList.add(new String[]{String.valueOf(biVar.field_msgId), biVar.field_content, "-1"});
                }
                i++;
            }
            if (arrayList.size() > 0) {
                ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.brandservice.a.b.class)).aU(arrayList);
            }
            AppMethodBeat.o(31129);
        } else {
            LinkedList linkedList = new LinkedList();
            while (i <= i2) {
                biVar = (bi) this.yNj.get(i);
                if (!(biVar == null || (biVar.getType() & 49) == 0 || this.jNF.contains(Long.valueOf(biVar.field_msgSvrId)))) {
                    this.jNF.add(Long.valueOf(biVar.field_msgSvrId));
                    com.tencent.mm.ui.chatting.viewitems.c bM = az.bM(biVar);
                    if (bM != null) {
                        String b = bM.b(this.yod, biVar);
                        if (b != null) {
                            String str = biVar.field_content;
                            if (str != null) {
                                com.tencent.mm.af.j.b X = com.tencent.mm.af.j.b.X(str, biVar.field_reserved);
                                if (X != null) {
                                    int i3;
                                    int ad = u.ad(b, this.yod.getTalkerUserName());
                                    com.tencent.mm.af.e eVar = (com.tencent.mm.af.e) X.X(com.tencent.mm.af.e.class);
                                    if (eVar != null) {
                                        i3 = eVar.ffZ;
                                    } else {
                                        i3 = -1;
                                    }
                                    ArrayList arrayList2 = new ArrayList();
                                    arrayList2.add(String.valueOf(biVar.field_msgSvrId));
                                    arrayList2.add(bo.bc(X.url, ""));
                                    arrayList2.add(String.valueOf(i3));
                                    arrayList2.add(b);
                                    arrayList2.add(String.valueOf(ad));
                                    linkedList.add(arrayList2);
                                }
                            }
                        }
                    }
                }
                i++;
            }
            if (linkedList.size() > 0) {
                ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.brandservice.a.b.class)).i(linkedList, 1);
            }
            AppMethodBeat.o(31129);
        }
    }
}

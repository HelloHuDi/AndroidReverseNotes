package com.tencent.p177mm.p612ui.chatting.p1089a;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C32798u;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvideo.C9720t.C9721a;
import com.tencent.p177mm.modelvideo.C9720t.C9721a.C9718a;
import com.tencent.p177mm.p181af.C25747e;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p184aj.p185a.C25754e;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p198aw.C37494a;
import com.tencent.p177mm.p198aw.C9058e;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C44406x;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.chatting.C36159c;
import com.tencent.p177mm.p612ui.chatting.C44318s.C15711g;
import com.tencent.p177mm.p612ui.chatting.C44318s.C31497f;
import com.tencent.p177mm.p612ui.chatting.C44800ag;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36134c;
import com.tencent.p177mm.p612ui.chatting.p617f.C40748d.C40749a;
import com.tencent.p177mm.p612ui.chatting.p622l.p623a.C17017a;
import com.tencent.p177mm.p612ui.chatting.viewitems.C15717ad.C15714b;
import com.tencent.p177mm.p612ui.chatting.viewitems.C15717ad.C15718a;
import com.tencent.p177mm.p612ui.chatting.viewitems.C23821am.C15733d;
import com.tencent.p177mm.p612ui.chatting.viewitems.C46667az;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.C5379a;
import com.tencent.p177mm.p707ba.C37504a;
import com.tencent.p177mm.p707ba.C41787r;
import com.tencent.p177mm.plugin.brandservice.p1241a.C20023b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h.C3457a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h.C3460c;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.pluginsdk.p597ui.C14945e;
import com.tencent.p177mm.pluginsdk.p597ui.chat.C44083l;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44086g;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

/* renamed from: com.tencent.mm.ui.chatting.a.a */
public final class C30443a extends BaseAdapter implements C15612h {
    private boolean ceU;
    public C25814c elH = null;
    private int emW = -1;
    private LayoutInflater ezi;
    private HashSet jNF = new HashSet();
    private ListView mListView;
    private C44086g yGy;
    public C15711g yMW;
    private C15711g yMX;
    public C31497f yMY;
    private C31497f yMZ;
    public C44083l yNa;
    private C44083l yNb;
    public C44406x yNc;
    private C44406x yNd;
    public C36159c yNe;
    private C36159c yNf;
    private OnClickListener yNg = null;
    private final int yNh;
    private final int yNi;
    public SparseArray<C7620bi> yNj = new SparseArray();
    private HashSet<Long> yNk = new HashSet();
    public SparseIntArray yNl = new SparseIntArray();
    public long yNm = -1;
    private TreeSet<Long> yNn = new TreeSet();
    private Map<Long, Integer> yNo = new HashMap();
    private Map<Long, WeakReference<View>> yNp = new HashMap();
    private boolean yNq = false;
    private boolean yNr = false;
    private final C7564ap yNs = new C7564ap(new C304451(), true);
    public C17017a yNt;
    private boolean yNu = false;
    private int yNv = 0;
    protected C3457a yNw = new C304483();
    private C9721a yNx = new C304464();
    private long yNy = -1;
    private C46650a yod;

    /* renamed from: com.tencent.mm.ui.chatting.a.a$2 */
    class C304442 implements Runnable {
        C304442() {
        }

        public final void run() {
            AppMethodBeat.m2504i(31096);
            C30443a.this.notifyDataSetChanged();
            AppMethodBeat.m2505o(31096);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.a.a$1 */
    class C304451 implements C5015a {
        C304451() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(31095);
            if (C30443a.this.yod != null && C30443a.this.yod.caA) {
                C4990ab.m7416i("MicroMsg.ChattingDataAdapter", "[onTimerExpired]");
                C30443a.this.dCT();
            }
            AppMethodBeat.m2505o(31095);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.a.a$4 */
    class C304464 implements C9721a {

        /* renamed from: com.tencent.mm.ui.chatting.a.a$4$1 */
        class C304471 implements Runnable {
            C304471() {
            }

            public final void run() {
                AppMethodBeat.m2504i(31098);
                C30443a.this.dCT();
                AppMethodBeat.m2505o(31098);
            }
        }

        C304464() {
        }

        /* renamed from: a */
        public final void mo11381a(C9718a c9718a) {
            AppMethodBeat.m2504i(31099);
            boolean z = false;
            if (!(c9718a == null || c9718a.fXk == 3 || (c9718a.fXk != 2 && c9718a.fXk != -1 && c9718a.fXk != 1))) {
                z = C15733d.m24041b(c9718a);
            }
            if (!z) {
                C5004al.m7441d(new C304471());
            }
            AppMethodBeat.m2505o(31099);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.a.a$3 */
    class C304483 implements C3457a {
        C304483() {
        }

        /* renamed from: a */
        public final void mo7913a(C6977h c6977h, C3460c c3460c) {
            AppMethodBeat.m2504i(31097);
            if (c6977h == null || c3460c == null) {
                AppMethodBeat.m2505o(31097);
            } else if (c3460c.talker == null || C30443a.this.yod.getTalkerUserName() == null) {
                AppMethodBeat.m2505o(31097);
            } else {
                if (c3460c.talker.equals(C30443a.this.yod.getTalkerUserName())) {
                    C30443a.this.dCT();
                }
                AppMethodBeat.m2505o(31097);
            }
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.m2504i(31130);
        C7620bi Ou = mo27798Ou(i);
        AppMethodBeat.m2505o(31130);
        return Ou;
    }

    public C30443a(C46650a c46650a, ListView listView) {
        AppMethodBeat.m2504i(31100);
        c46650a.mo74856a(C15612h.class, this);
        this.mListView = listView;
        this.yod = c46650a;
        this.ezi = C5616v.m8409hu(c46650a.yTx.getContext());
        this.yNh = c46650a.yTx.getMMResources().getDimensionPixelSize(C25738R.dimen.f10017nj);
        this.yNi = c46650a.yTx.getMMResources().getDimensionPixelSize(C25738R.dimen.f9958le);
        C15711g c15711g = new C15711g();
        this.yMX = c15711g;
        this.yMW = c15711g;
        C31497f c31497f = new C31497f(c46650a);
        this.yMZ = c31497f;
        this.yMY = c31497f;
        C44083l c44083l = new C44083l(c46650a.yTx.getContext());
        this.yNb = c44083l;
        this.yNa = c44083l;
        C44406x c44406x = new C44406x(c46650a);
        this.yNd = c44406x;
        this.yNc = c44406x;
        C36159c c36159c = new C36159c(c46650a);
        this.yNf = c36159c;
        this.yNe = c36159c;
        this.yGy = new C44800ag(c46650a);
        if (this.elH == null) {
            C17927a c17927a = new C17927a();
            c17927a.ePK = C25754e.m40912rz(this.yod.getTalkerUserName());
            c17927a.ePH = true;
            c17927a.ePZ = true;
            c17927a.ePT = C1318a.default_avatar;
            this.elH = c17927a.ahG();
        }
        AppMethodBeat.m2505o(31100);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(31101);
        int size = this.yNj.size();
        AppMethodBeat.m2505o(31101);
        return size;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.m2504i(31102);
        int bN = C46667az.m88381bN(mo27798Ou(i));
        AppMethodBeat.m2505o(31102);
        return bN;
    }

    public final int getViewTypeCount() {
        AppMethodBeat.m2504i(31103);
        int dHt = C46667az.dHt();
        AppMethodBeat.m2505o(31103);
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
        C5379a c5379a;
        AppMethodBeat.m2504i(31104);
        C7620bi Ou = mo27798Ou(i);
        C4990ab.m7416i("MicroMsg.ChattingDataAdapter", "[getView] position:" + i + " msgId:" + Ou.field_msgId + " svrId:" + Ou.field_msgSvrId + " type:" + Ou.getType() + " send:" + Ou.field_isSend + " talker:" + Ou.field_talker + " msgSep:" + Ou.field_msgSeq + " time:" + Ou.field_createTime);
        if (i == 0) {
            C46650a c46650a = this.yod;
            C4990ab.m7416i("MicroMsg.ChattingContext", "[scrollToLastProtect]");
            c46650a.yTy.dCD();
        }
        if (i != 0 && this.yNl.get(i) == 0) {
            long j = mo27798Ou(i - 1).field_createTime;
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
        C37504a sU = C41787r.aiy().mo73165sU(this.yod.getTalkerUserName());
        boolean z = true;
        if (sU == null) {
            C9638aw.m17190ZK();
            intValue = ((Integer) C18628c.m29072Ry().get(12311, Integer.valueOf(-2))).intValue();
        } else {
            intValue = sU.fLV;
        }
        if (intValue != -2) {
            z = false;
        }
        C5379a c5379a2;
        if (view == null) {
            C5378c bM = C46667az.m88380bM(Ou);
            view = bM.mo11005a(this.ezi, view);
            c5379a2 = (C5379a) view.getTag();
            c5379a2.zbA = bM;
            c5379a2.setChattingBG(z);
            c5379a = c5379a2;
        } else {
            c5379a2 = (C5379a) view.getTag();
            c5379a2.setChattingBG(z);
            c5379a = c5379a2;
        }
        C4990ab.m7411d("MicroMsg.ChattingDataAdapter", "dealItemView() ChattingItem:%s", c5379a.zbA);
        if (obj2 != null) {
            c5379a.enf.setVisibility(0);
            c5379a.enf.setText(C14835h.m23089c(this.yod.yTx.getContext(), Ou.field_createTime, false));
            if (c5379a.enf.getTextSize() > ((float) C1338a.fromDPToPix(this.yod.yTx.getContext(), 25))) {
                C4990ab.m7413e("MicroMsg.ChattingDataAdapter", "WDF!!! TextSize:%s", Float.valueOf(c5379a.enf.getTextSize()));
            }
        } else {
            c5379a.enf.setVisibility(8);
        }
        if (c5379a.zbx != null) {
            if (obj3 != null) {
                c5379a.zbx.setVisibility(0);
            } else {
                c5379a.zbx.setVisibility(8);
            }
        }
        C5378c c5378c = c5379a.zbA;
        c5379a.zbz = null;
        C9058e aih = C37494a.aih();
        if (aih != null && aih.fJU != null && aih.fJS == 0 && C37494a.aie()) {
            c5379a.zbz = aih.fJU;
        }
        c5378c.mo11009a(c5379a, i, this.yod, Ou);
        C14945e dDJ = ((C36134c) this.yod.mo74857aF(C36134c.class)).dDJ();
        if (c5379a.enf.getVisibility() == 0 && dDJ != null) {
            c5379a.enf.setTextColor(dDJ.vgW);
            if (dDJ.vgX) {
                c5379a.enf.setShadowLayer(2.0f, 1.2f, 1.2f, dDJ.vgY);
            } else {
                c5379a.enf.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
            if (dDJ.vgZ) {
                if (dDJ.vha) {
                    c5379a.enf.setBackgroundResource(C25738R.drawable.f6551hw);
                } else {
                    c5379a.enf.setBackgroundResource(C25738R.drawable.f6550hv);
                }
                c5379a.enf.setPadding(this.yNi, this.yNh, this.yNi, this.yNh);
            } else {
                c5379a.enf.setBackgroundColor(0);
            }
        }
        if (!(c5379a.qkY == null || c5379a.qkY.getVisibility() != 0 || dDJ == null || this.yod.getTalkerUserName().equals("qqmail") || Ou.getType() == 318767153)) {
            if (dDJ.vha) {
                c5379a.qkY.setTextColor(-1);
                c5379a.qkY.setShadowLayer((float) C1338a.fromDPToPix(c5379a.qkY.getContext(), 2), 0.0f, (float) C1338a.fromDPToPix(c5379a.qkY.getContext(), 1), this.yod.yTx.getMMResources().getColor(C25738R.color.f11628n));
            } else {
                c5379a.qkY.setTextColor(dDJ.vgW);
                c5379a.qkY.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
        }
        if (c5379a.iVh != null) {
            c5379a.iVh.setTag(Long.valueOf(Ou.field_msgId));
        }
        if (this.yNq) {
            if (Ou.isSystem()) {
                obj = null;
            } else {
                obj = 1;
            }
        }
        if (!this.yNr) {
            c5379a.mo11032qy(false);
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
            AppMethodBeat.m2505o(31104);
            return view;
        }
        if (c5379a.moo != null) {
            c5379a.moo.setChecked(this.yNn.contains(Long.valueOf(Ou.field_msgId)));
        }
        if (c5379a.iVh != null) {
            c5379a.iVh.setOnClickListener(this.yNg);
        }
        c5379a.mo11032qy(true);
        for (Entry entry2 : this.yNp.entrySet()) {
        }
        this.yNp.put(Long.valueOf(Ou.field_msgId), new WeakReference(view));
        if (Ou.drE()) {
        }
        AppMethodBeat.m2505o(31104);
        return view;
    }

    private void dCO() {
        AppMethodBeat.m2504i(31105);
        C4990ab.m7410d("MicroMsg.ChattingDataAdapter", "disable clickListener");
        this.yMW = null;
        this.yMY = null;
        this.yNa = null;
        this.yNc = null;
        this.yNe = null;
        AppMethodBeat.m2505o(31105);
    }

    public final void resume() {
        AppMethodBeat.m2504i(31106);
        this.ceU = true;
        C4990ab.m7416i("MicroMsg.ChattingDataAdapter", "adapter resume");
        C9638aw.m17190ZK();
        C18628c.m29080XO().mo15287a(this.yNw, Looper.getMainLooper());
        C44089j.m79291a(this.yGy);
        this.yNs.mo16770ae(300000, 300000);
        if (this.yNt != null) {
            this.yNt.mo31088a(C40749a.ACTION_UPDATE, false, null);
        }
        AppMethodBeat.m2505o(31106);
    }

    public final void pause() {
        AppMethodBeat.m2504i(31107);
        this.ceU = false;
        C9638aw.m17190ZK();
        C18628c.m29080XO().mo15286a(this.yNw);
        C44089j.m79297b(this.yGy);
        C4990ab.m7416i("MicroMsg.ChattingDataAdapter", "adapter pause");
        this.yNs.stopTimer();
        AppMethodBeat.m2505o(31107);
    }

    public final void dhG() {
        AppMethodBeat.m2504i(31108);
        C46650a.dFz().post(new C304442());
        AppMethodBeat.m2505o(31108);
    }

    public final int dCP() {
        AppMethodBeat.m2504i(31109);
        if (-1 == this.emW) {
            C9638aw.m17190ZK();
            this.emW = C18628c.m29080XO().mo15262Rp(this.yod.getTalkerUserName());
        }
        int i = this.emW;
        AppMethodBeat.m2505o(31109);
        return i;
    }

    /* renamed from: Ou */
    public final C7620bi mo27798Ou(int i) {
        AppMethodBeat.m2504i(31110);
        C7620bi c7620bi = (C7620bi) this.yNj.get(i);
        AppMethodBeat.m2505o(31110);
        return c7620bi;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0061  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: nf */
    public final boolean mo27825nf(long j) {
        View view;
        boolean z = false;
        AppMethodBeat.m2504i(31111);
        if (this.yNn.contains(Long.valueOf(j))) {
            C4990ab.m7411d("MicroMsg.ChattingDataAdapter", "remove select item, msgId = %d", Long.valueOf(j));
            this.yNn.remove(Long.valueOf(j));
        } else {
            C4990ab.m7411d("MicroMsg.ChattingDataAdapter", "add select item, msgId = %d", Long.valueOf(j));
            if (this.yNn.size() >= 100) {
                C30379h.m48461b(this.yod.yTx.getContext(), this.yod.yTx.getMMResources().getString(C25738R.string.beb, new Object[]{Integer.valueOf(100)}), "", true);
                AppMethodBeat.m2505o(31111);
                return false;
            }
            this.yNn.add(Long.valueOf(j));
        }
        if (this.mListView != null) {
            C5379a c5379a;
            while (true) {
                boolean z2 = z;
                if (z2 >= this.mListView.getChildCount()) {
                    break;
                }
                View childAt = this.mListView.getChildAt(z2);
                c5379a = (C5379a) childAt.getTag();
                if (c5379a != null && c5379a.iVh != null && ((Long) c5379a.iVh.getTag()).longValue() == j) {
                    view = childAt;
                    break;
                }
                z = z2 + 1;
            }
            if (view == null) {
                c5379a = (C5379a) view.getTag();
                if (c5379a.moo != null && c5379a.moo.getVisibility() == 0) {
                    c5379a.moo.setChecked(this.yNn.contains(Long.valueOf(j)));
                }
            } else {
                notifyDataSetChanged();
            }
            AppMethodBeat.m2505o(31111);
            return true;
        }
        view = null;
        if (view == null) {
        }
        AppMethodBeat.m2505o(31111);
        return true;
    }

    public final int cdf() {
        AppMethodBeat.m2504i(31112);
        int size = this.yNn.size();
        AppMethodBeat.m2505o(31112);
        return size;
    }

    public final Set<Long> dCQ() {
        return this.yNn;
    }

    public final void dCR() {
        AppMethodBeat.m2504i(31113);
        if (this.yNn != null) {
            this.yNn.clear();
        }
        AppMethodBeat.m2505o(31113);
    }

    public final void bvQ() {
        AppMethodBeat.m2504i(31114);
        this.yNq = false;
        notifyDataSetChanged();
        C4990ab.m7410d("MicroMsg.ChattingDataAdapter", "enable ClickListener");
        this.yMW = this.yMX;
        this.yMY = this.yMZ;
        this.yNa = this.yNb;
        this.yNc = this.yNd;
        this.yNe = this.yNf;
        AppMethodBeat.m2505o(31114);
    }

    public final void dCS() {
        AppMethodBeat.m2504i(31115);
        this.yNq = true;
        notifyDataSetChanged();
        dCO();
        AppMethodBeat.m2505o(31115);
    }

    public final boolean isInEditMode() {
        return this.yNq;
    }

    /* renamed from: c */
    public final void mo27805c(OnClickListener onClickListener) {
        this.yNg = onClickListener;
    }

    public final void notifyDataSetChanged() {
        AppMethodBeat.m2504i(31116);
        super.notifyDataSetChanged();
        this.yNl.clear();
        AppMethodBeat.m2505o(31116);
    }

    public final void dCT() {
        AppMethodBeat.m2504i(31117);
        if (this.yNu) {
            this.yNv++;
            C4990ab.m7416i("MicroMsg.ChattingDataAdapter", "[handleMsgChange] isLockNotify:" + this.yNv);
            AppMethodBeat.m2505o(31117);
        } else if (this.ceU) {
            this.yNt.mo31088a(C40749a.ACTION_UPDATE, false, null);
            AppMethodBeat.m2505o(31117);
        } else {
            C4990ab.m7416i("MicroMsg.ChattingDataAdapter", "[handleMsgChange] is not resumeState ");
            AppMethodBeat.m2505o(31117);
        }
    }

    /* renamed from: Ov */
    public final void mo27799Ov(int i) {
        boolean z = false;
        AppMethodBeat.m2504i(31118);
        C7620bi Ou = mo27798Ou(i);
        String str = "MicroMsg.ChattingDataAdapter";
        String str2 = "[setShowHistoryMsgTipId] pos:%s msg is null? %s";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i);
        if (Ou == null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        C4990ab.m7417i(str, str2, objArr);
        if (!(Ou == null || Ou.field_msgId == 0)) {
            this.yNm = Ou.field_msgId;
        }
        notifyDataSetChanged();
        AppMethodBeat.m2505o(31118);
    }

    /* renamed from: a */
    public final void mo27803a(long j, boolean z, C40749a c40749a) {
        AppMethodBeat.m2504i(31119);
        C4990ab.m7417i("MicroMsg.ChattingDataAdapter", "[locationByMsgId] messageId:%s loadAllBottomMsg:%s mode:%s", Long.valueOf(j), Boolean.valueOf(z), c40749a);
        Bundle bundle = new Bundle();
        bundle.putLong("MSG_ID", j);
        bundle.putInt("SCENE", 1);
        bundle.putBoolean("IS_LOAD_ALL", z);
        this.yNt.mo31088a(c40749a, true, bundle);
        AppMethodBeat.m2505o(31119);
    }

    /* renamed from: a */
    public final void mo27801a(int i, C40749a c40749a) {
        AppMethodBeat.m2504i(31120);
        C4990ab.m7417i("MicroMsg.ChattingDataAdapter", "[locationByMsgId] position:%s mode:%s", Integer.valueOf(i), c40749a);
        Bundle bundle = new Bundle();
        bundle.putInt("MSG_POSITION", i);
        bundle.putInt("SCENE", 2);
        this.yNt.mo31088a(c40749a, false, bundle);
        AppMethodBeat.m2505o(31120);
    }

    public final void dCU() {
        AppMethodBeat.m2504i(31121);
        C4990ab.m7417i("MicroMsg.ChattingDataAdapter", "[lockNotify] isLockNotify:%s notifyCountWhileLock:%s", Boolean.valueOf(this.yNu), Integer.valueOf(this.yNv));
        if (this.yNu) {
            AppMethodBeat.m2505o(31121);
            return;
        }
        this.yNu = true;
        this.yNv = 0;
        AppMethodBeat.m2505o(31121);
    }

    public final void dCV() {
        AppMethodBeat.m2504i(31122);
        C4990ab.m7417i("MicroMsg.ChattingDataAdapter", "[unLockNotify] isLockNotify:%s notifyCountWhileLock:%s", Boolean.valueOf(this.yNu), Integer.valueOf(this.yNv));
        if (this.yNu) {
            this.yNu = false;
            if (this.yNv > 0) {
                this.yNt.mo31088a(C40749a.ACTION_UPDATE, false, null);
            }
            this.yNv = 0;
            AppMethodBeat.m2505o(31122);
            return;
        }
        AppMethodBeat.m2505o(31122);
    }

    /* renamed from: o */
    public final void mo27826o(long j, int i, int i2) {
        AppMethodBeat.m2504i(31123);
        if (this.yNp.containsKey(Long.valueOf(j)) && this.yNo.containsKey(Long.valueOf(j))) {
            WeakReference weakReference = (WeakReference) this.yNp.get(Long.valueOf(j));
            View view = weakReference != null ? (View) weakReference.get() : null;
            if (view != null) {
                C15714b.m24005a((C5379a) view.getTag(), i, i2);
            }
            AppMethodBeat.m2505o(31123);
            return;
        }
        C4990ab.m7410d("MicroMsg.ChattingDataAdapter", "msg not display, ".concat(String.valueOf(j)));
        AppMethodBeat.m2505o(31123);
    }

    /* renamed from: B */
    public final void mo27797B(long j, boolean z) {
        AppMethodBeat.m2504i(31124);
        if (this.yNp.containsKey(Long.valueOf(j)) && this.yNo.containsKey(Long.valueOf(j))) {
            WeakReference weakReference = (WeakReference) this.yNp.get(Long.valueOf(j));
            View view = weakReference != null ? (View) weakReference.get() : null;
            if (view != null) {
                C15714b.m24006a((C5379a) view.getTag(), z);
            }
            AppMethodBeat.m2505o(31124);
            return;
        }
        C4990ab.m7410d("MicroMsg.ChattingDataAdapter", "msg not display, ".concat(String.valueOf(j)));
        AppMethodBeat.m2505o(31124);
    }

    /* renamed from: a */
    public final void mo27802a(long j, C7620bi c7620bi, boolean z) {
        AppMethodBeat.m2504i(31125);
        if (this.yNp.containsKey(Long.valueOf(j)) && this.yNo.containsKey(Long.valueOf(j))) {
            WeakReference weakReference = (WeakReference) this.yNp.get(Long.valueOf(j));
            View view = weakReference != null ? (View) weakReference.get() : null;
            if (view != null) {
                C15718a.m24022a(this.yod.yTx.getContext(), (C5379a) view.getTag(), c7620bi, z);
            }
            AppMethodBeat.m2505o(31125);
            return;
        }
        C4990ab.m7410d("MicroMsg.ChattingDataAdapter", "msg not display, ".concat(String.valueOf(j)));
        AppMethodBeat.m2505o(31125);
    }

    /* renamed from: Ow */
    public final void mo27800Ow(int i) {
        AppMethodBeat.m2504i(31126);
        C7620bi Ou = mo27798Ou(i);
        if (!(Ou == null || Ou.field_msgId == 0)) {
            this.yNk.add(Long.valueOf(Ou.field_msgId));
        }
        AppMethodBeat.m2505o(31126);
    }

    public final void dCW() {
        AppMethodBeat.m2504i(31127);
        this.yNr = true;
        dCO();
        AppMethodBeat.m2505o(31127);
    }

    public final C9721a dCX() {
        return this.yNx;
    }

    public final C31497f dCY() {
        return this.yMY;
    }

    public final C15711g dCZ() {
        return this.yMW;
    }

    public final C44406x dDa() {
        return this.yNc;
    }

    public final C44083l dDb() {
        return this.yNa;
    }

    public final C36159c dDc() {
        return this.yNe;
    }

    public final long dDd() {
        AppMethodBeat.m2504i(31128);
        long j;
        if (this.yNy != -1) {
            j = this.yNy;
            AppMethodBeat.m2505o(31128);
            return j;
        }
        this.yNy = 0;
        for (int count = getCount() - 1; count >= 0; count--) {
            C7620bi Ou = mo27798Ou(count);
            if (Ou.field_isSend == 1 && (Ou.dqI & 4) != 4) {
                this.yNy = Ou.field_msgId;
                break;
            }
        }
        j = this.yNy;
        AppMethodBeat.m2505o(31128);
        return j;
    }

    public final C25814c dDe() {
        return this.elH;
    }

    /* renamed from: dD */
    public final void mo48842dD(int i, int i2) {
        AppMethodBeat.m2504i(31129);
        if (this.yod == null) {
            AppMethodBeat.m2505o(31129);
            return;
        }
        C7616ad c7616ad = this.yod.sRl;
        C7620bi c7620bi;
        if (c7616ad == null) {
            AppMethodBeat.m2505o(31129);
        } else if (c7616ad.dsf()) {
            ArrayList arrayList = new ArrayList();
            while (i <= i2) {
                c7620bi = (C7620bi) this.yNj.get(i);
                if (!(c7620bi == null || c7620bi.getType() != 285212721 || this.jNF.contains(Long.valueOf(c7620bi.field_msgId)))) {
                    C4990ab.m7418v("MicroMsg.ChattingDataAdapter", "terry checkpreload:" + c7620bi.field_msgId);
                    this.jNF.add(Long.valueOf(c7620bi.field_msgId));
                    arrayList.add(new String[]{String.valueOf(c7620bi.field_msgId), c7620bi.field_content, "-1"});
                }
                i++;
            }
            if (arrayList.size() > 0) {
                ((C20023b) C1720g.m3528K(C20023b.class)).mo6752aU(arrayList);
            }
            AppMethodBeat.m2505o(31129);
        } else {
            LinkedList linkedList = new LinkedList();
            while (i <= i2) {
                c7620bi = (C7620bi) this.yNj.get(i);
                if (!(c7620bi == null || (c7620bi.getType() & 49) == 0 || this.jNF.contains(Long.valueOf(c7620bi.field_msgSvrId)))) {
                    this.jNF.add(Long.valueOf(c7620bi.field_msgSvrId));
                    C5378c bM = C46667az.m88380bM(c7620bi);
                    if (bM != null) {
                        String b = bM.mo11017b(this.yod, c7620bi);
                        if (b != null) {
                            String str = c7620bi.field_content;
                            if (str != null) {
                                C8910b X = C8910b.m16058X(str, c7620bi.field_reserved);
                                if (X != null) {
                                    int i3;
                                    int ad = C32798u.m53583ad(b, this.yod.getTalkerUserName());
                                    C25747e c25747e = (C25747e) X.mo20333X(C25747e.class);
                                    if (c25747e != null) {
                                        i3 = c25747e.ffZ;
                                    } else {
                                        i3 = -1;
                                    }
                                    ArrayList arrayList2 = new ArrayList();
                                    arrayList2.add(String.valueOf(c7620bi.field_msgSvrId));
                                    arrayList2.add(C5046bo.m7532bc(X.url, ""));
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
                ((C20023b) C1720g.m3528K(C20023b.class)).mo6757i(linkedList, 1);
            }
            AppMethodBeat.m2505o(31129);
        }
    }
}

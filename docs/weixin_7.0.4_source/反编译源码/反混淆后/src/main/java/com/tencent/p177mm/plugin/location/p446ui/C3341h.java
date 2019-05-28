package com.tencent.p177mm.plugin.location.p446ui;

import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.MMHorList;
import com.tencent.p177mm.plugin.location.model.C39287l;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.location.ui.h */
public final class C3341h {
    Context context;
    private String elp = "";
    private C7306ak mHandler = new C7306ak(Looper.getMainLooper());
    private boolean mIsInit = false;
    C3345c nMA = null;
    MMHorList nMx;
    C3342a nMy;
    private int nMz;

    /* renamed from: com.tencent.mm.plugin.location.ui.h$a */
    class C3342a extends BaseAdapter {
        ArrayList<C3343b> nMD = new ArrayList();

        public C3342a(ArrayList<C3343b> arrayList) {
            AppMethodBeat.m2504i(113494);
            this.nMD.addAll(arrayList);
            AppMethodBeat.m2505o(113494);
        }

        public final int getCount() {
            AppMethodBeat.m2504i(113495);
            int size = this.nMD.size();
            AppMethodBeat.m2505o(113495);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.m2504i(113496);
            Object obj = this.nMD.get(i);
            AppMethodBeat.m2505o(113496);
            return obj;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(113497);
            RelativeLayout relativeLayout = ((C3343b) this.nMD.get(i)).nMF.nMG;
            AppMethodBeat.m2505o(113497);
            return relativeLayout;
        }

        /* renamed from: PV */
        public final C3343b mo7741PV(String str) {
            AppMethodBeat.m2504i(113498);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.nMD.size()) {
                    AppMethodBeat.m2505o(113498);
                    return null;
                } else if (((C3343b) this.nMD.get(i2)).username.equals(str)) {
                    C3343b c3343b = (C3343b) this.nMD.get(i2);
                    AppMethodBeat.m2505o(113498);
                    return c3343b;
                } else {
                    i = i2 + 1;
                }
            }
        }

        /* renamed from: PW */
        public final boolean mo7742PW(String str) {
            AppMethodBeat.m2504i(113499);
            for (int i = 0; i < this.nMD.size(); i++) {
                if (((C3343b) this.nMD.get(i)).username.equals(str)) {
                    AppMethodBeat.m2505o(113499);
                    return true;
                }
            }
            AppMethodBeat.m2505o(113499);
            return false;
        }

        public final ArrayList<String> bJS() {
            AppMethodBeat.m2504i(113500);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.nMD.iterator();
            while (it.hasNext()) {
                arrayList.add(((C3343b) it.next()).username);
            }
            AppMethodBeat.m2505o(113500);
            return arrayList;
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.h$b */
    class C3343b {
        boolean nME = false;
        C3344a nMF;
        private LayoutParams neY;
        String username;

        /* renamed from: com.tencent.mm.plugin.location.ui.h$b$a */
        class C3344a {
            ImageView goC;
            RelativeLayout nMG;

            C3344a() {
            }
        }

        public C3343b(String str) {
            AppMethodBeat.m2504i(113501);
            this.username = str;
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7412e("MicroMsg.ShareHeaderAvatarViewMgr", "init HeaderAvatar, username can't not be null");
                AppMethodBeat.m2505o(113501);
                return;
            }
            this.nMF = new C3344a();
            LayoutInflater layoutInflater = (LayoutInflater) C3341h.this.context.getSystemService("layout_inflater");
            this.nMF.nMG = (RelativeLayout) layoutInflater.inflate(2130969946, null);
            this.nMF.goC = (ImageView) this.nMF.nMG.findViewById(2131823704);
            C40460b.m69437r(this.nMF.goC, this.username);
            this.nMF.nMG.setTag(this.username);
            this.neY = new LayoutParams(-2, -2);
            this.neY.leftMargin = C4977b.m7371b(C3341h.this.context, 5.0f);
            this.neY.rightMargin = C4977b.m7371b(C3341h.this.context, 5.0f);
            this.neY.gravity = 17;
            AppMethodBeat.m2505o(113501);
        }

        public final void bJT() {
            AppMethodBeat.m2504i(113502);
            C4990ab.m7417i("MicroMsg.ShareHeaderAvatarViewMgr", "setTalking, username=%s", this.username);
            this.nMF.nMG.setBackgroundResource(C25738R.drawable.ahh);
            this.nMF.nMG.invalidate();
            this.nME = true;
            AppMethodBeat.m2505o(113502);
        }

        public final void bJU() {
            AppMethodBeat.m2504i(113503);
            C4990ab.m7417i("MicroMsg.ShareHeaderAvatarViewMgr", "exitTalking, username=%s", this.username);
            this.nMF.nMG.setBackgroundResource(C25738R.drawable.ahg);
            this.nMF.nMG.invalidate();
            this.nME = false;
            AppMethodBeat.m2505o(113503);
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.h$c */
    public interface C3345c {
        /* renamed from: PX */
        void mo7750PX(String str);
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.h$1 */
    class C33461 implements OnItemClickListener {
        C33461() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(113492);
            String str = (String) view.getTag();
            if (!C5046bo.isNullOrNil(str)) {
                C7060h.pYm.mo8381e(10997, "15", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                if (C3341h.this.nMA != null) {
                    C3341h.this.nMA.mo7750PX(str);
                }
            }
            AppMethodBeat.m2505o(113492);
        }
    }

    public C3341h(Context context, View view, String str) {
        AppMethodBeat.m2504i(113504);
        this.context = context;
        this.nMx = (MMHorList) view;
        this.elp = str;
        bJQ();
        AppMethodBeat.m2505o(113504);
    }

    private void bJQ() {
        AppMethodBeat.m2504i(113505);
        C4990ab.m7411d("MicroMsg.ShareHeaderAvatarViewMgr", "initAvatarList, memebers.size=%d", Integer.valueOf(C39287l.bJz().mo20564tP(this.elp).size()));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (String str : r0) {
            if (!C5046bo.isNullOrNil(str)) {
                arrayList.add(new C3343b(str));
                arrayList2.add(str);
            }
        }
        m5652G(arrayList);
        mo7738H(arrayList2);
        this.nMx.invalidate();
        this.nMy.notifyDataSetChanged();
        AppMethodBeat.m2505o(113505);
    }

    /* renamed from: G */
    private void m5652G(ArrayList<C3343b> arrayList) {
        AppMethodBeat.m2504i(113506);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C3343b c3343b = (C3343b) it.next();
            if (c3343b.nME) {
                c3343b.bJT();
            }
        }
        this.nMz = C1338a.fromDPToPix(this.context, 60);
        this.nMx.setOverScrollEnabled(true);
        this.nMx.setItemWidth(this.nMz);
        this.nMx.setCenterInParent(true);
        this.nMx.setOnItemClickListener(new C33461());
        this.nMy = new C3342a(arrayList);
        this.nMx.setAdapter(this.nMy);
        AppMethodBeat.m2505o(113506);
    }

    /* renamed from: PS */
    private void m5653PS(String str) {
        AppMethodBeat.m2504i(113507);
        C4990ab.m7411d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberEnter, usernmae=%s", str);
        if (this.nMy.mo7742PW(str)) {
            AppMethodBeat.m2505o(113507);
            return;
        }
        C3343b c3343b = new C3343b(str);
        C3342a c3342a = this.nMy;
        c3342a.nMD.add(c3343b);
        c3342a.notifyDataSetChanged();
        this.nMx.invalidate();
        AppMethodBeat.m2505o(113507);
    }

    /* renamed from: PT */
    private void m5654PT(String str) {
        int i = 0;
        AppMethodBeat.m2504i(113508);
        C4990ab.m7411d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberExit, username=%s", str);
        if (this.nMy.mo7742PW(str)) {
            int i2;
            C3342a c3342a = this.nMy;
            while (true) {
                i2 = i;
                if (i2 >= c3342a.nMD.size()) {
                    i2 = -1;
                    break;
                } else if (((C3343b) c3342a.nMD.get(i2)).username.equals(str)) {
                    break;
                } else {
                    i = i2 + 1;
                }
            }
            if (i2 != -1) {
                c3342a.nMD.remove(i2);
                c3342a.notifyDataSetChanged();
            }
            this.nMx.invalidate();
        }
        AppMethodBeat.m2505o(113508);
    }

    /* renamed from: PU */
    public final void mo7739PU(String str) {
        int i = 0;
        AppMethodBeat.m2504i(113509);
        C4990ab.m7411d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberTalk, username=%s", str);
        if (this.nMy.mo7742PW(str)) {
            this.nMy.mo7741PV(str).bJT();
            this.nMy.notifyDataSetChanged();
            this.nMx.invalidate();
            if (this.nMx.getIsTouching() || C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(113509);
                return;
            }
            C3342a c3342a = this.nMy;
            int i2 = 0;
            while (i2 < c3342a.nMD.size()) {
                if (((C3343b) c3342a.nMD.get(i2)).username.equals(str)) {
                    break;
                }
                i2++;
            }
            i2 = -1;
            C4990ab.m7411d("MicroMsg.ShareHeaderAvatarViewMgr", "scrollToTalker, index=%d", Integer.valueOf(i2));
            if (i2 != -1) {
                int i3 = i2 * this.nMz;
                int currentPosition = this.nMx.getCurrentPosition();
                if (i3 >= currentPosition) {
                    currentPosition = i3 > currentPosition + (this.nMz * 3) ? i3 - (this.nMz * 3) : 0;
                }
                if (i2 != 0) {
                    i = currentPosition;
                }
                this.mHandler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(113493);
                        C4990ab.m7411d("MicroMsg.ShareHeaderAvatarViewMgr", "scrollToTalker pos=%d", Integer.valueOf(i));
                        C3341h.this.nMx.mo27652NI(i);
                        AppMethodBeat.m2505o(113493);
                    }
                });
            }
        }
        AppMethodBeat.m2505o(113509);
    }

    public final void bJR() {
        AppMethodBeat.m2504i(113510);
        C3342a c3342a = this.nMy;
        Iterator it = c3342a.nMD.iterator();
        while (it.hasNext()) {
            ((C3343b) it.next()).bJU();
        }
        c3342a.notifyDataSetChanged();
        this.nMx.invalidate();
        AppMethodBeat.m2505o(113510);
    }

    /* renamed from: H */
    public final void mo7738H(ArrayList<String> arrayList) {
        String str;
        Iterator it;
        AppMethodBeat.m2504i(113511);
        C4990ab.m7411d("MicroMsg.ShareHeaderAvatarViewMgr", "onRefreshMemberList, members.size=%d", Integer.valueOf(arrayList.size()));
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList bJS = this.nMy.bJS();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            str = (String) it2.next();
            if (bJS.indexOf(str) == -1) {
                arrayList2.add(str);
            }
        }
        Iterator it3 = bJS.iterator();
        while (it3.hasNext()) {
            str = (String) it3.next();
            if (arrayList.indexOf(str) == -1) {
                arrayList3.add(str);
            }
        }
        C4990ab.m7411d("MicroMsg.ShareHeaderAvatarViewMgr", "onRefreshMemberList, newMember.size=%d, removeMember.size=%d", Integer.valueOf(arrayList2.size()), Integer.valueOf(arrayList3.size()));
        if (arrayList2.size() > 0) {
            it = arrayList2.iterator();
            while (it.hasNext()) {
                m5653PS((String) it.next());
            }
        }
        if (arrayList3.size() > 0) {
            it = arrayList3.iterator();
            while (it.hasNext()) {
                m5654PT((String) it.next());
            }
        }
        AppMethodBeat.m2505o(113511);
    }
}

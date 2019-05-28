package com.tencent.mm.plugin.location.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMHorList;
import java.util.ArrayList;
import java.util.Iterator;

public final class h {
    Context context;
    private String elp = "";
    private ak mHandler = new ak(Looper.getMainLooper());
    private boolean mIsInit = false;
    c nMA = null;
    MMHorList nMx;
    a nMy;
    private int nMz;

    class a extends BaseAdapter {
        ArrayList<b> nMD = new ArrayList();

        public a(ArrayList<b> arrayList) {
            AppMethodBeat.i(113494);
            this.nMD.addAll(arrayList);
            AppMethodBeat.o(113494);
        }

        public final int getCount() {
            AppMethodBeat.i(113495);
            int size = this.nMD.size();
            AppMethodBeat.o(113495);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.i(113496);
            Object obj = this.nMD.get(i);
            AppMethodBeat.o(113496);
            return obj;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(113497);
            RelativeLayout relativeLayout = ((b) this.nMD.get(i)).nMF.nMG;
            AppMethodBeat.o(113497);
            return relativeLayout;
        }

        public final b PV(String str) {
            AppMethodBeat.i(113498);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.nMD.size()) {
                    AppMethodBeat.o(113498);
                    return null;
                } else if (((b) this.nMD.get(i2)).username.equals(str)) {
                    b bVar = (b) this.nMD.get(i2);
                    AppMethodBeat.o(113498);
                    return bVar;
                } else {
                    i = i2 + 1;
                }
            }
        }

        public final boolean PW(String str) {
            AppMethodBeat.i(113499);
            for (int i = 0; i < this.nMD.size(); i++) {
                if (((b) this.nMD.get(i)).username.equals(str)) {
                    AppMethodBeat.o(113499);
                    return true;
                }
            }
            AppMethodBeat.o(113499);
            return false;
        }

        public final ArrayList<String> bJS() {
            AppMethodBeat.i(113500);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.nMD.iterator();
            while (it.hasNext()) {
                arrayList.add(((b) it.next()).username);
            }
            AppMethodBeat.o(113500);
            return arrayList;
        }
    }

    class b {
        boolean nME = false;
        a nMF;
        private LayoutParams neY;
        String username;

        class a {
            ImageView goC;
            RelativeLayout nMG;

            a() {
            }
        }

        public b(String str) {
            AppMethodBeat.i(113501);
            this.username = str;
            if (bo.isNullOrNil(str)) {
                ab.e("MicroMsg.ShareHeaderAvatarViewMgr", "init HeaderAvatar, username can't not be null");
                AppMethodBeat.o(113501);
                return;
            }
            this.nMF = new a();
            LayoutInflater layoutInflater = (LayoutInflater) h.this.context.getSystemService("layout_inflater");
            this.nMF.nMG = (RelativeLayout) layoutInflater.inflate(R.layout.a_8, null);
            this.nMF.goC = (ImageView) this.nMF.nMG.findViewById(R.id.bke);
            com.tencent.mm.pluginsdk.ui.a.b.r(this.nMF.goC, this.username);
            this.nMF.nMG.setTag(this.username);
            this.neY = new LayoutParams(-2, -2);
            this.neY.leftMargin = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(h.this.context, 5.0f);
            this.neY.rightMargin = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(h.this.context, 5.0f);
            this.neY.gravity = 17;
            AppMethodBeat.o(113501);
        }

        public final void bJT() {
            AppMethodBeat.i(113502);
            ab.i("MicroMsg.ShareHeaderAvatarViewMgr", "setTalking, username=%s", this.username);
            this.nMF.nMG.setBackgroundResource(R.drawable.ahh);
            this.nMF.nMG.invalidate();
            this.nME = true;
            AppMethodBeat.o(113502);
        }

        public final void bJU() {
            AppMethodBeat.i(113503);
            ab.i("MicroMsg.ShareHeaderAvatarViewMgr", "exitTalking, username=%s", this.username);
            this.nMF.nMG.setBackgroundResource(R.drawable.ahg);
            this.nMF.nMG.invalidate();
            this.nME = false;
            AppMethodBeat.o(113503);
        }
    }

    public interface c {
        void PX(String str);
    }

    public h(Context context, View view, String str) {
        AppMethodBeat.i(113504);
        this.context = context;
        this.nMx = (MMHorList) view;
        this.elp = str;
        bJQ();
        AppMethodBeat.o(113504);
    }

    private void bJQ() {
        AppMethodBeat.i(113505);
        ab.d("MicroMsg.ShareHeaderAvatarViewMgr", "initAvatarList, memebers.size=%d", Integer.valueOf(l.bJz().tP(this.elp).size()));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (String str : r0) {
            if (!bo.isNullOrNil(str)) {
                arrayList.add(new b(str));
                arrayList2.add(str);
            }
        }
        G(arrayList);
        H(arrayList2);
        this.nMx.invalidate();
        this.nMy.notifyDataSetChanged();
        AppMethodBeat.o(113505);
    }

    private void G(ArrayList<b> arrayList) {
        AppMethodBeat.i(113506);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.nME) {
                bVar.bJT();
            }
        }
        this.nMz = com.tencent.mm.bz.a.fromDPToPix(this.context, 60);
        this.nMx.setOverScrollEnabled(true);
        this.nMx.setItemWidth(this.nMz);
        this.nMx.setCenterInParent(true);
        this.nMx.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(113492);
                String str = (String) view.getTag();
                if (!bo.isNullOrNil(str)) {
                    com.tencent.mm.plugin.report.service.h.pYm.e(10997, "15", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                    if (h.this.nMA != null) {
                        h.this.nMA.PX(str);
                    }
                }
                AppMethodBeat.o(113492);
            }
        });
        this.nMy = new a(arrayList);
        this.nMx.setAdapter(this.nMy);
        AppMethodBeat.o(113506);
    }

    private void PS(String str) {
        AppMethodBeat.i(113507);
        ab.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberEnter, usernmae=%s", str);
        if (this.nMy.PW(str)) {
            AppMethodBeat.o(113507);
            return;
        }
        b bVar = new b(str);
        a aVar = this.nMy;
        aVar.nMD.add(bVar);
        aVar.notifyDataSetChanged();
        this.nMx.invalidate();
        AppMethodBeat.o(113507);
    }

    private void PT(String str) {
        int i = 0;
        AppMethodBeat.i(113508);
        ab.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberExit, username=%s", str);
        if (this.nMy.PW(str)) {
            int i2;
            a aVar = this.nMy;
            while (true) {
                i2 = i;
                if (i2 >= aVar.nMD.size()) {
                    i2 = -1;
                    break;
                } else if (((b) aVar.nMD.get(i2)).username.equals(str)) {
                    break;
                } else {
                    i = i2 + 1;
                }
            }
            if (i2 != -1) {
                aVar.nMD.remove(i2);
                aVar.notifyDataSetChanged();
            }
            this.nMx.invalidate();
        }
        AppMethodBeat.o(113508);
    }

    public final void PU(String str) {
        int i = 0;
        AppMethodBeat.i(113509);
        ab.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberTalk, username=%s", str);
        if (this.nMy.PW(str)) {
            this.nMy.PV(str).bJT();
            this.nMy.notifyDataSetChanged();
            this.nMx.invalidate();
            if (this.nMx.getIsTouching() || bo.isNullOrNil(str)) {
                AppMethodBeat.o(113509);
                return;
            }
            a aVar = this.nMy;
            int i2 = 0;
            while (i2 < aVar.nMD.size()) {
                if (((b) aVar.nMD.get(i2)).username.equals(str)) {
                    break;
                }
                i2++;
            }
            i2 = -1;
            ab.d("MicroMsg.ShareHeaderAvatarViewMgr", "scrollToTalker, index=%d", Integer.valueOf(i2));
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
                        AppMethodBeat.i(113493);
                        ab.d("MicroMsg.ShareHeaderAvatarViewMgr", "scrollToTalker pos=%d", Integer.valueOf(i));
                        h.this.nMx.NI(i);
                        AppMethodBeat.o(113493);
                    }
                });
            }
        }
        AppMethodBeat.o(113509);
    }

    public final void bJR() {
        AppMethodBeat.i(113510);
        a aVar = this.nMy;
        Iterator it = aVar.nMD.iterator();
        while (it.hasNext()) {
            ((b) it.next()).bJU();
        }
        aVar.notifyDataSetChanged();
        this.nMx.invalidate();
        AppMethodBeat.o(113510);
    }

    public final void H(ArrayList<String> arrayList) {
        String str;
        Iterator it;
        AppMethodBeat.i(113511);
        ab.d("MicroMsg.ShareHeaderAvatarViewMgr", "onRefreshMemberList, members.size=%d", Integer.valueOf(arrayList.size()));
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
        ab.d("MicroMsg.ShareHeaderAvatarViewMgr", "onRefreshMemberList, newMember.size=%d, removeMember.size=%d", Integer.valueOf(arrayList2.size()), Integer.valueOf(arrayList3.size()));
        if (arrayList2.size() > 0) {
            it = arrayList2.iterator();
            while (it.hasNext()) {
                PS((String) it.next());
            }
        }
        if (arrayList3.size() > 0) {
            it = arrayList3.iterator();
            while (it.hasNext()) {
                PT((String) it.next());
            }
        }
        AppMethodBeat.o(113511);
    }
}

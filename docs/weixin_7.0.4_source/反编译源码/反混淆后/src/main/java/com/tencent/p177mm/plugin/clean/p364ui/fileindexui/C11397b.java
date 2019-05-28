package com.tencent.p177mm.plugin.clean.p364ui.fileindexui;

import android.content.Intent;
import android.database.Cursor;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p612ui.MMImageView;
import com.tencent.p177mm.p612ui.gridviewheaders.C46688e;
import com.tencent.p177mm.p612ui.gridviewheaders.GridHeadersGridView.C40873c;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.clean.p362c.C2808i;
import com.tencent.p177mm.plugin.p398f.C39004a;
import com.tencent.p177mm.plugin.p398f.C45913b;
import com.tencent.p177mm.plugin.p398f.p1482b.C34092a;
import com.tencent.p177mm.plugin.p398f.p1482b.C39005b;
import com.tencent.p177mm.pluginsdk.model.C44065o;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.pointers.PLong;
import com.tencent.p177mm.sdk.platformtools.C15429k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.b */
public final class C11397b extends BaseAdapter implements C46688e {
    private static int kxm = 0;
    private boolean bbV;
    ArrayList<C2808i> iLD;
    boolean isStop = false;
    OnItemClickListener jMk = new C114004();
    HashSet<Integer> jur;
    private CleanChattingDetailUI kxl;
    C40873c kxn = new C113993();
    private C7306ak kxo = new C114055();
    OnScrollListener kxp = new C114016();
    private String username;

    /* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.b$1 */
    class C113981 implements Runnable {
        C113981() {
        }

        public final void run() {
            AppMethodBeat.m2504i(18746);
            C11397b.this.notifyDataSetChanged();
            AppMethodBeat.m2505o(18746);
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.b$3 */
    class C113993 implements C40873c {
        C113993() {
        }

        /* renamed from: de */
        public final void mo23152de(View view) {
            AppMethodBeat.m2504i(18748);
            C11397b.m19157a(C11397b.this, (C11402a) view.getTag());
            C11397b.this.notifyDataSetChanged();
            AppMethodBeat.m2505o(18748);
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.b$4 */
    class C114004 implements OnItemClickListener {
        C114004() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(18749);
            C4990ab.m7417i("MicroMsg.CleanChattingDetailAdapter", "Click Item position=%d, count=%d", Integer.valueOf(i), Integer.valueOf(C11397b.this.getCount()));
            if (i < 0 || i >= C11397b.this.getCount()) {
                AppMethodBeat.m2505o(18749);
                return;
            }
            C2808i tv = C11397b.this.mo23149tv(i);
            Intent intent = new Intent();
            switch (tv.type) {
                case 1:
                    String str;
                    intent.putExtra("key_title", C11397b.this.kxl.getString(C25738R.string.aq5));
                    intent.putExtra("show_menu", false);
                    String str2 = "key_image_path";
                    if (C5730e.m8628ct(tv.filePath)) {
                        str = tv.filePath;
                    } else {
                        str = tv.thumbPath;
                    }
                    intent.putExtra(str2, str);
                    C25985d.m41473f(C11397b.this.kxl, ".ui.tools.ShowImageUI", intent);
                    AppMethodBeat.m2505o(18749);
                    return;
                case 3:
                    intent.setAction("android.intent.action.VIEW");
                    C15429k.m23712a(C11397b.this.kxl, intent, C5730e.asY(tv.filePath), "video/*");
                    try {
                        C11397b.this.kxl.startActivity(Intent.createChooser(intent, C11397b.this.kxl.getString(C25738R.string.f1w)));
                        AppMethodBeat.m2505o(18749);
                        return;
                    } catch (Exception e) {
                        AppMethodBeat.m2505o(18749);
                        return;
                    }
                case 4:
                    intent.putExtra("app_msg_id", tv.cuQ);
                    C25985d.m41473f(C11397b.this.kxl, ".ui.chatting.AppAttachDownloadUI", intent);
                    break;
            }
            AppMethodBeat.m2505o(18749);
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.b$6 */
    class C114016 implements OnScrollListener {
        C114016() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.m2504i(18751);
            C32291o.ahp().mo43773cm(i);
            if (i != 2) {
                C11397b.this.bbV = false;
                C11397b.this.kxo.removeCallbacksAndMessages(null);
                C11397b.this.kxo.sendEmptyMessageDelayed(0, 200);
                AppMethodBeat.m2505o(18751);
                return;
            }
            C11397b.this.bbV = true;
            AppMethodBeat.m2505o(18751);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.b$a */
    class C11402a {
        TextView kxr;
        TextView kxs;
        CheckBox kxt;
        int position;

        C11402a() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.b$b */
    class C11403b implements Runnable {
        private C11403b() {
        }

        /* synthetic */ C11403b(C11397b c11397b, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(18752);
            PLong pLong = new PLong();
            PLong pLong2 = new PLong();
            C39005b aZd = C45913b.aZc().aZd();
            String a = C11397b.this.username;
            long yz = C5046bo.m7588yz();
            String str = "select max(msgtime), min(msgtime) from WxFileIndex2 where username='" + a + "' and msgType in (43,62,44,3,49,268435505 )";
            Cursor cursor = null;
            try {
                cursor = aZd.bSd.rawQuery(str, null);
                if (cursor != null && cursor.moveToFirst()) {
                    pLong.value = cursor.getLong(0);
                    pLong2.value = cursor.getLong(1);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.WxFileIndexStorage", e, " sql [%s]", str);
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                AppMethodBeat.m2505o(18752);
            }
            C4990ab.m7417i("MicroMsg.WxFileIndexStorage", "getMediaMsgTimeByUsername [%s] cost[%d]", a, Long.valueOf(C5046bo.m7525az(yz)));
            pLong2.value--;
            long j = pLong.value;
            yz = Math.max(j - 604800000, pLong2.value);
            try {
                if (C11397b.this.isStop) {
                    AppMethodBeat.m2505o(18752);
                    return;
                }
                if (yz == j) {
                    yz--;
                }
                m19169bn(C45913b.aZc().aZd().mo61899k(C11397b.this.username, j, yz));
                C11397b.m19160c(C11397b.this);
                while (true) {
                    j = yz;
                    if (C11397b.this.isStop || j <= pLong2.value) {
                        AppMethodBeat.m2505o(18752);
                    } else {
                        yz = Math.max(j - 15552000000L, pLong2.value);
                        if (yz == j) {
                            yz--;
                        }
                        m19169bn(C45913b.aZc().aZd().mo61899k(C11397b.this.username, j, yz));
                        C11397b.m19160c(C11397b.this);
                    }
                }
                AppMethodBeat.m2505o(18752);
            } catch (Exception e2) {
                C4990ab.printErrStackTrace("MicroMsg.CleanChattingDetailAdapter", e2, "", new Object[0]);
                AppMethodBeat.m2505o(18752);
            }
        }

        /* renamed from: bn */
        private void m19169bn(List<C34092a> list) {
            AppMethodBeat.m2504i(18753);
            int size = list.size();
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < size; i++) {
                C34092a c34092a = (C34092a) list.get(i);
                C2808i c2808i = (C2808i) hashMap.get(Long.valueOf(c34092a.field_msgId));
                if (c2808i == null) {
                    c2808i = new C2808i();
                    hashMap.put(Long.valueOf(c34092a.field_msgId), c2808i);
                    arrayList.add(c2808i);
                }
                c2808i.kwH.add(c34092a);
                c2808i.fXb = c34092a.field_msgtime;
                c2808i.userName = c34092a.field_username;
                c2808i.cuQ = c34092a.field_msgId;
                if (!C39004a.m66252sJ(c34092a.field_msgSubType)) {
                    c2808i.size += c34092a.field_size;
                }
                switch (c34092a.field_msgSubType) {
                    case 1:
                        c2808i.filePath = C1720g.m3536RP().eJL + c34092a.field_path;
                        c2808i.type = 3;
                        break;
                    case 2:
                        c2808i.thumbPath = C1720g.m3536RP().eJL + c34092a.field_path;
                        c2808i.type = 3;
                        break;
                    case 20:
                        c2808i.filePath = C1720g.m3536RP().eJL + c34092a.field_path;
                        c2808i.type = 1;
                        break;
                    case 21:
                        c2808i.thumbPath = C1720g.m3536RP().eJL + c34092a.field_path;
                        c2808i.type = 1;
                        break;
                    case 30:
                        c2808i.filePath = C1720g.m3536RP().eJL + c34092a.field_path;
                        c2808i.type = 1;
                        break;
                    case 31:
                        c2808i.thumbPath = C1720g.m3536RP().eJL + c34092a.field_path;
                        c2808i.type = 1;
                        break;
                    case 32:
                        c2808i.filePath = C1720g.m3536RP().eJL + c34092a.field_path;
                        c2808i.type = 4;
                        break;
                    case 33:
                        c2808i.thumbPath = C1720g.m3536RP().eJL + c34092a.field_path;
                        c2808i.type = 4;
                        break;
                    case 34:
                        c2808i.filePath = C1720g.m3536RP().eJL + c34092a.field_path;
                        c2808i.type = 4;
                        break;
                    case 35:
                        c2808i.thumbPath = C1720g.m3536RP().eJL + c34092a.field_path;
                        c2808i.type = 4;
                        break;
                    default:
                        break;
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (((C2808i) it.next()).size <= 0) {
                    it.remove();
                }
            }
            C11397b.this.iLD.addAll(arrayList);
            AppMethodBeat.m2505o(18753);
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.b$c */
    class C11404c {
        CheckBox gnD;
        TextView gxi;
        MMImageView kxu;
        ImageView kxv;
        View kxw;
        View kxx;

        C11404c() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.b$5 */
    class C114055 extends C7306ak {
        C114055() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(18750);
            if (!C11397b.this.bbV) {
                C11397b.this.notifyDataSetChanged();
            }
            AppMethodBeat.m2505o(18750);
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.m2504i(18762);
        C2808i tv = mo23149tv(i);
        AppMethodBeat.m2505o(18762);
        return tv;
    }

    public C11397b(CleanChattingDetailUI cleanChattingDetailUI, String str) {
        AppMethodBeat.m2504i(18754);
        this.kxl = cleanChattingDetailUI;
        this.jur = new HashSet();
        this.iLD = new ArrayList();
        this.username = str;
        AppMethodBeat.m2505o(18754);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(18755);
        int size = this.iLD.size();
        AppMethodBeat.m2505o(18755);
        return size;
    }

    /* renamed from: tv */
    public final C2808i mo23149tv(int i) {
        AppMethodBeat.m2504i(18756);
        C2808i c2808i = (C2808i) this.iLD.get(i);
        AppMethodBeat.m2505o(18756);
        return c2808i;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(final int i, View view, ViewGroup viewGroup) {
        C11404c c11404c;
        AppMethodBeat.m2504i(18757);
        long currentTimeMillis = System.currentTimeMillis();
        if (view == null) {
            view = this.kxl.getLayoutInflater().inflate(2130969140, viewGroup, false);
            C11404c c11404c2 = new C11404c();
            c11404c2.kxu = (MMImageView) view.findViewById(2131822764);
            c11404c2.gnD = (CheckBox) view.findViewById(2131821593);
            c11404c2.kxw = view.findViewById(2131822767);
            c11404c2.kxx = view.findViewById(2131822766);
            c11404c2.kxv = (ImageView) view.findViewById(2131822765);
            c11404c2.gxi = (TextView) view.findViewById(2131821227);
            view.setTag(c11404c2);
            c11404c = c11404c2;
        } else {
            c11404c = (C11404c) view.getTag();
        }
        C2808i tv = mo23149tv(i);
        c11404c.kxu.setTag(tv.filePath);
        c11404c.kxw.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(18747);
                C11397b.m19156a(C11397b.this, i);
                C11397b.this.notifyDataSetChanged();
                AppMethodBeat.m2505o(18747);
            }
        });
        if (this.jur.contains(Integer.valueOf(i))) {
            c11404c.gnD.setChecked(true);
            c11404c.kxx.setVisibility(0);
        } else {
            c11404c.gnD.setChecked(false);
            c11404c.kxx.setVisibility(8);
        }
        if (tv.type == 3) {
            c11404c.kxv.setVisibility(0);
        } else {
            c11404c.kxv.setVisibility(8);
        }
        if (tv.type == 4) {
            C32291o.ahp().mo43772b(tv.thumbPath, c11404c.kxu);
            c11404c.kxu.setImageResource(C44065o.aiD(C5730e.m8630cv(tv.filePath)));
            c11404c.gxi.setText(new C5728b(tv.filePath).getName());
            c11404c.gxi.setVisibility(0);
        } else {
            if (kxm == 0) {
                kxm = view.getMeasuredWidth();
            }
            C17927a c17927a = new C17927a();
            c17927a.fHe = 1;
            c17927a.ePI = false;
            c17927a.ePO = kxm;
            c17927a.ePN = kxm;
            c17927a.ePJ = tv.thumbPath;
            C32291o.ahp().mo43766a(tv.thumbPath, c11404c.kxu, c17927a.ahG());
            c11404c.gxi.setVisibility(8);
        }
        C4990ab.m7411d("MicroMsg.CleanChattingDetailAdapter", "getView time=%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(18757);
        return view;
    }

    /* renamed from: tw */
    public final long mo23150tw(int i) {
        AppMethodBeat.m2504i(18758);
        long bfH = ((C2808i) this.iLD.get(i)).bfH();
        AppMethodBeat.m2505o(18758);
        return bfH;
    }

    /* renamed from: a */
    public final View mo23142a(int i, View view, ViewGroup viewGroup) {
        C11402a c11402a;
        AppMethodBeat.m2504i(18759);
        if (view == null) {
            C4990ab.m7418v("MicroMsg.CleanChattingDetailAdapter", "convertView is null");
            view = this.kxl.getLayoutInflater().inflate(2130969141, viewGroup, false);
            c11402a = new C11402a();
            c11402a.kxr = (TextView) view.findViewById(2131822768);
            c11402a.kxs = (TextView) view.findViewById(2131822769);
            c11402a.kxt = (CheckBox) view.findViewById(2131822770);
            view.setTag(c11402a);
        } else {
            C4990ab.m7418v("MicroMsg.CleanChattingDetailAdapter", "convertView is not null");
            c11402a = (C11402a) view.getTag();
        }
        C2808i tv = mo23149tv(i);
        c11402a.position = i;
        c11402a.kxr.setText(C14835h.formatTime(this.kxl.getString(C25738R.string.bz3), tv.fXb / 1000));
        long bfH = tv.bfH();
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < this.iLD.size(); i2++) {
            if (((C2808i) this.iLD.get(i2)).bfH() == bfH) {
                hashSet.add(Integer.valueOf(i2));
            }
        }
        Iterator it = hashSet.iterator();
        boolean z = true;
        while (it.hasNext()) {
            boolean z2;
            if (this.jur.contains(Integer.valueOf(((Integer) it.next()).intValue()))) {
                z2 = z;
            } else {
                z2 = false;
            }
            z = z2;
        }
        if (z) {
            c11402a.kxt.setChecked(true);
        } else {
            c11402a.kxt.setChecked(false);
        }
        AppMethodBeat.m2505o(18759);
        return view;
    }

    /* Access modifiers changed, original: final */
    public final void bgi() {
        boolean z;
        AppMethodBeat.m2504i(18760);
        this.kxl.mo73613tx(this.jur.size());
        CleanChattingDetailUI cleanChattingDetailUI = this.kxl;
        if (this.jur.size() == this.iLD.size()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            cleanChattingDetailUI.kxB.setChecked(true);
        } else {
            cleanChattingDetailUI.kxB.setChecked(false);
        }
        Iterator it = this.jur.iterator();
        long j = 0;
        while (it.hasNext()) {
            j = ((C2808i) this.iLD.get(((Integer) it.next()).intValue())).size + j;
        }
        CleanChattingDetailUI cleanChattingDetailUI2 = this.kxl;
        if (j > 0) {
            cleanChattingDetailUI2.kxC.setText(cleanChattingDetailUI2.getString(C25738R.string.b58, new Object[]{C5046bo.m7565ga(j)}));
            AppMethodBeat.m2505o(18760);
            return;
        }
        cleanChattingDetailUI2.kxC.setText("");
        AppMethodBeat.m2505o(18760);
    }

    public final void bgh() {
        AppMethodBeat.m2504i(18761);
        this.jur.clear();
        bgi();
        AppMethodBeat.m2505o(18761);
    }

    /* renamed from: c */
    static /* synthetic */ void m19160c(C11397b c11397b) {
        AppMethodBeat.m2504i(18763);
        if (!c11397b.isStop) {
            C5004al.m7441d(new C113981());
        }
        AppMethodBeat.m2505o(18763);
    }
}

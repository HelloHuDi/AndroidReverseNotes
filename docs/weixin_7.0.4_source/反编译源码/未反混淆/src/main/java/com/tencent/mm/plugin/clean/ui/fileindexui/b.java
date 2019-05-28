package com.tencent.mm.plugin.clean.ui.fileindexui;

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
import com.tencent.mm.R;
import com.tencent.mm.at.o;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.clean.c.i;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.gridviewheaders.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class b extends BaseAdapter implements e {
    private static int kxm = 0;
    private boolean bbV;
    ArrayList<i> iLD;
    boolean isStop = false;
    OnItemClickListener jMk = new OnItemClickListener() {
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.i(18749);
            ab.i("MicroMsg.CleanChattingDetailAdapter", "Click Item position=%d, count=%d", Integer.valueOf(i), Integer.valueOf(b.this.getCount()));
            if (i < 0 || i >= b.this.getCount()) {
                AppMethodBeat.o(18749);
                return;
            }
            i tv = b.this.tv(i);
            Intent intent = new Intent();
            switch (tv.type) {
                case 1:
                    String str;
                    intent.putExtra("key_title", b.this.kxl.getString(R.string.aq5));
                    intent.putExtra("show_menu", false);
                    String str2 = "key_image_path";
                    if (com.tencent.mm.vfs.e.ct(tv.filePath)) {
                        str = tv.filePath;
                    } else {
                        str = tv.thumbPath;
                    }
                    intent.putExtra(str2, str);
                    d.f(b.this.kxl, ".ui.tools.ShowImageUI", intent);
                    AppMethodBeat.o(18749);
                    return;
                case 3:
                    intent.setAction("android.intent.action.VIEW");
                    k.a(b.this.kxl, intent, com.tencent.mm.vfs.e.asY(tv.filePath), "video/*");
                    try {
                        b.this.kxl.startActivity(Intent.createChooser(intent, b.this.kxl.getString(R.string.f1w)));
                        AppMethodBeat.o(18749);
                        return;
                    } catch (Exception e) {
                        AppMethodBeat.o(18749);
                        return;
                    }
                case 4:
                    intent.putExtra("app_msg_id", tv.cuQ);
                    d.f(b.this.kxl, ".ui.chatting.AppAttachDownloadUI", intent);
                    break;
            }
            AppMethodBeat.o(18749);
        }
    };
    HashSet<Integer> jur;
    private CleanChattingDetailUI kxl;
    com.tencent.mm.ui.gridviewheaders.GridHeadersGridView.c kxn = new com.tencent.mm.ui.gridviewheaders.GridHeadersGridView.c() {
        public final void de(View view) {
            AppMethodBeat.i(18748);
            b.a(b.this, (a) view.getTag());
            b.this.notifyDataSetChanged();
            AppMethodBeat.o(18748);
        }
    };
    private ak kxo = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(18750);
            if (!b.this.bbV) {
                b.this.notifyDataSetChanged();
            }
            AppMethodBeat.o(18750);
        }
    };
    OnScrollListener kxp = new OnScrollListener() {
        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.i(18751);
            o.ahp().cm(i);
            if (i != 2) {
                b.this.bbV = false;
                b.this.kxo.removeCallbacksAndMessages(null);
                b.this.kxo.sendEmptyMessageDelayed(0, 200);
                AppMethodBeat.o(18751);
                return;
            }
            b.this.bbV = true;
            AppMethodBeat.o(18751);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private String username;

    class a {
        TextView kxr;
        TextView kxs;
        CheckBox kxt;
        int position;

        a() {
        }
    }

    class b implements Runnable {
        private b() {
        }

        /* synthetic */ b(b bVar, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(18752);
            PLong pLong = new PLong();
            PLong pLong2 = new PLong();
            com.tencent.mm.plugin.f.b.b aZd = com.tencent.mm.plugin.f.b.aZc().aZd();
            String a = b.this.username;
            long yz = bo.yz();
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
                ab.printErrStackTrace("MicroMsg.WxFileIndexStorage", e, " sql [%s]", str);
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                AppMethodBeat.o(18752);
            }
            ab.i("MicroMsg.WxFileIndexStorage", "getMediaMsgTimeByUsername [%s] cost[%d]", a, Long.valueOf(bo.az(yz)));
            pLong2.value--;
            long j = pLong.value;
            yz = Math.max(j - 604800000, pLong2.value);
            try {
                if (b.this.isStop) {
                    AppMethodBeat.o(18752);
                    return;
                }
                if (yz == j) {
                    yz--;
                }
                bn(com.tencent.mm.plugin.f.b.aZc().aZd().k(b.this.username, j, yz));
                b.c(b.this);
                while (true) {
                    j = yz;
                    if (b.this.isStop || j <= pLong2.value) {
                        AppMethodBeat.o(18752);
                    } else {
                        yz = Math.max(j - 15552000000L, pLong2.value);
                        if (yz == j) {
                            yz--;
                        }
                        bn(com.tencent.mm.plugin.f.b.aZc().aZd().k(b.this.username, j, yz));
                        b.c(b.this);
                    }
                }
                AppMethodBeat.o(18752);
            } catch (Exception e2) {
                ab.printErrStackTrace("MicroMsg.CleanChattingDetailAdapter", e2, "", new Object[0]);
                AppMethodBeat.o(18752);
            }
        }

        private void bn(List<com.tencent.mm.plugin.f.b.a> list) {
            AppMethodBeat.i(18753);
            int size = list.size();
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < size; i++) {
                com.tencent.mm.plugin.f.b.a aVar = (com.tencent.mm.plugin.f.b.a) list.get(i);
                i iVar = (i) hashMap.get(Long.valueOf(aVar.field_msgId));
                if (iVar == null) {
                    iVar = new i();
                    hashMap.put(Long.valueOf(aVar.field_msgId), iVar);
                    arrayList.add(iVar);
                }
                iVar.kwH.add(aVar);
                iVar.fXb = aVar.field_msgtime;
                iVar.userName = aVar.field_username;
                iVar.cuQ = aVar.field_msgId;
                if (!com.tencent.mm.plugin.f.a.sJ(aVar.field_msgSubType)) {
                    iVar.size += aVar.field_size;
                }
                switch (aVar.field_msgSubType) {
                    case 1:
                        iVar.filePath = g.RP().eJL + aVar.field_path;
                        iVar.type = 3;
                        break;
                    case 2:
                        iVar.thumbPath = g.RP().eJL + aVar.field_path;
                        iVar.type = 3;
                        break;
                    case 20:
                        iVar.filePath = g.RP().eJL + aVar.field_path;
                        iVar.type = 1;
                        break;
                    case 21:
                        iVar.thumbPath = g.RP().eJL + aVar.field_path;
                        iVar.type = 1;
                        break;
                    case 30:
                        iVar.filePath = g.RP().eJL + aVar.field_path;
                        iVar.type = 1;
                        break;
                    case 31:
                        iVar.thumbPath = g.RP().eJL + aVar.field_path;
                        iVar.type = 1;
                        break;
                    case 32:
                        iVar.filePath = g.RP().eJL + aVar.field_path;
                        iVar.type = 4;
                        break;
                    case 33:
                        iVar.thumbPath = g.RP().eJL + aVar.field_path;
                        iVar.type = 4;
                        break;
                    case 34:
                        iVar.filePath = g.RP().eJL + aVar.field_path;
                        iVar.type = 4;
                        break;
                    case 35:
                        iVar.thumbPath = g.RP().eJL + aVar.field_path;
                        iVar.type = 4;
                        break;
                    default:
                        break;
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (((i) it.next()).size <= 0) {
                    it.remove();
                }
            }
            b.this.iLD.addAll(arrayList);
            AppMethodBeat.o(18753);
        }
    }

    class c {
        CheckBox gnD;
        TextView gxi;
        MMImageView kxu;
        ImageView kxv;
        View kxw;
        View kxx;

        c() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(18762);
        i tv = tv(i);
        AppMethodBeat.o(18762);
        return tv;
    }

    public b(CleanChattingDetailUI cleanChattingDetailUI, String str) {
        AppMethodBeat.i(18754);
        this.kxl = cleanChattingDetailUI;
        this.jur = new HashSet();
        this.iLD = new ArrayList();
        this.username = str;
        AppMethodBeat.o(18754);
    }

    public final int getCount() {
        AppMethodBeat.i(18755);
        int size = this.iLD.size();
        AppMethodBeat.o(18755);
        return size;
    }

    public final i tv(int i) {
        AppMethodBeat.i(18756);
        i iVar = (i) this.iLD.get(i);
        AppMethodBeat.o(18756);
        return iVar;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(final int i, View view, ViewGroup viewGroup) {
        c cVar;
        AppMethodBeat.i(18757);
        long currentTimeMillis = System.currentTimeMillis();
        if (view == null) {
            view = this.kxl.getLayoutInflater().inflate(R.layout.oh, viewGroup, false);
            c cVar2 = new c();
            cVar2.kxu = (MMImageView) view.findViewById(R.id.aw0);
            cVar2.gnD = (CheckBox) view.findViewById(R.id.a1b);
            cVar2.kxw = view.findViewById(R.id.aw3);
            cVar2.kxx = view.findViewById(R.id.aw2);
            cVar2.kxv = (ImageView) view.findViewById(R.id.aw1);
            cVar2.gxi = (TextView) view.findViewById(R.id.rr);
            view.setTag(cVar2);
            cVar = cVar2;
        } else {
            cVar = (c) view.getTag();
        }
        i tv = tv(i);
        cVar.kxu.setTag(tv.filePath);
        cVar.kxw.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(18747);
                b.a(b.this, i);
                b.this.notifyDataSetChanged();
                AppMethodBeat.o(18747);
            }
        });
        if (this.jur.contains(Integer.valueOf(i))) {
            cVar.gnD.setChecked(true);
            cVar.kxx.setVisibility(0);
        } else {
            cVar.gnD.setChecked(false);
            cVar.kxx.setVisibility(8);
        }
        if (tv.type == 3) {
            cVar.kxv.setVisibility(0);
        } else {
            cVar.kxv.setVisibility(8);
        }
        if (tv.type == 4) {
            o.ahp().b(tv.thumbPath, cVar.kxu);
            cVar.kxu.setImageResource(com.tencent.mm.pluginsdk.model.o.aiD(com.tencent.mm.vfs.e.cv(tv.filePath)));
            cVar.gxi.setText(new com.tencent.mm.vfs.b(tv.filePath).getName());
            cVar.gxi.setVisibility(0);
        } else {
            if (kxm == 0) {
                kxm = view.getMeasuredWidth();
            }
            com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
            aVar.fHe = 1;
            aVar.ePI = false;
            aVar.ePO = kxm;
            aVar.ePN = kxm;
            aVar.ePJ = tv.thumbPath;
            o.ahp().a(tv.thumbPath, cVar.kxu, aVar.ahG());
            cVar.gxi.setVisibility(8);
        }
        ab.d("MicroMsg.CleanChattingDetailAdapter", "getView time=%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(18757);
        return view;
    }

    public final long tw(int i) {
        AppMethodBeat.i(18758);
        long bfH = ((i) this.iLD.get(i)).bfH();
        AppMethodBeat.o(18758);
        return bfH;
    }

    public final View a(int i, View view, ViewGroup viewGroup) {
        a aVar;
        AppMethodBeat.i(18759);
        if (view == null) {
            ab.v("MicroMsg.CleanChattingDetailAdapter", "convertView is null");
            view = this.kxl.getLayoutInflater().inflate(R.layout.oi, viewGroup, false);
            aVar = new a();
            aVar.kxr = (TextView) view.findViewById(R.id.aw4);
            aVar.kxs = (TextView) view.findViewById(R.id.aw5);
            aVar.kxt = (CheckBox) view.findViewById(R.id.aw6);
            view.setTag(aVar);
        } else {
            ab.v("MicroMsg.CleanChattingDetailAdapter", "convertView is not null");
            aVar = (a) view.getTag();
        }
        i tv = tv(i);
        aVar.position = i;
        aVar.kxr.setText(h.formatTime(this.kxl.getString(R.string.bz3), tv.fXb / 1000));
        long bfH = tv.bfH();
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < this.iLD.size(); i2++) {
            if (((i) this.iLD.get(i2)).bfH() == bfH) {
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
            aVar.kxt.setChecked(true);
        } else {
            aVar.kxt.setChecked(false);
        }
        AppMethodBeat.o(18759);
        return view;
    }

    /* Access modifiers changed, original: final */
    public final void bgi() {
        boolean z;
        AppMethodBeat.i(18760);
        this.kxl.tx(this.jur.size());
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
            j = ((i) this.iLD.get(((Integer) it.next()).intValue())).size + j;
        }
        CleanChattingDetailUI cleanChattingDetailUI2 = this.kxl;
        if (j > 0) {
            cleanChattingDetailUI2.kxC.setText(cleanChattingDetailUI2.getString(R.string.b58, new Object[]{bo.ga(j)}));
            AppMethodBeat.o(18760);
            return;
        }
        cleanChattingDetailUI2.kxC.setText("");
        AppMethodBeat.o(18760);
    }

    public final void bgh() {
        AppMethodBeat.i(18761);
        this.jur.clear();
        bgi();
        AppMethodBeat.o(18761);
    }

    static /* synthetic */ void c(b bVar) {
        AppMethodBeat.i(18763);
        if (!bVar.isStop) {
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(18746);
                    b.this.notifyDataSetChanged();
                    AppMethodBeat.o(18746);
                }
            });
        }
        AppMethodBeat.o(18763);
    }
}

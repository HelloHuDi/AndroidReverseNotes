package com.tencent.mm.plugin.clean.ui.newui;

import android.content.Intent;
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
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.gridviewheaders.GridHeadersGridView.c;
import com.tencent.mm.ui.gridviewheaders.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public final class b extends BaseAdapter implements e {
    private static int kxm = 0;
    private boolean bbV;
    ArrayList<com.tencent.mm.plugin.clean.c.a> iLD;
    OnItemClickListener jMk = new OnItemClickListener() {
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.i(18849);
            ab.i("MicroMsg.CleanChattingDetailAdapter", "Click Item position=%d", Integer.valueOf(i));
            com.tencent.mm.plugin.clean.c.a tz = b.this.tz(i);
            Intent intent = new Intent();
            switch (tz.type) {
                case 1:
                    intent.putExtra("key_title", b.this.kyH.getString(R.string.aq5));
                    intent.putExtra("show_menu", false);
                    intent.putExtra("key_image_path", tz.filePath);
                    d.f(b.this.kyH, ".ui.tools.ShowImageUI", intent);
                    AppMethodBeat.o(18849);
                    return;
                case 3:
                    intent.setAction("android.intent.action.VIEW");
                    k.a(b.this.kyH, intent, com.tencent.mm.vfs.e.asY(tz.filePath), "video/*");
                    try {
                        b.this.kyH.startActivity(Intent.createChooser(intent, b.this.kyH.getString(R.string.f1w)));
                        AppMethodBeat.o(18849);
                        return;
                    } catch (Exception e) {
                        AppMethodBeat.o(18849);
                        return;
                    }
                case 4:
                    intent.putExtra("app_msg_id", tz.cuQ);
                    d.f(b.this.kyH, ".ui.chatting.AppAttachDownloadUI", intent);
                    break;
            }
            AppMethodBeat.o(18849);
        }
    };
    HashSet<Integer> jur;
    c kxn = new c() {
        public final void de(View view) {
            AppMethodBeat.i(18848);
            b.a(b.this, (a) view.getTag());
            b.this.notifyDataSetChanged();
            AppMethodBeat.o(18848);
        }
    };
    private ak kxo = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(18850);
            if (!b.this.bbV) {
                b.this.notifyDataSetChanged();
            }
            AppMethodBeat.o(18850);
        }
    };
    OnScrollListener kxp = new OnScrollListener() {
        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.i(18851);
            o.ahp().cm(i);
            if (i != 2) {
                b.this.bbV = false;
                b.this.kxo.removeCallbacksAndMessages(null);
                b.this.kxo.sendEmptyMessageDelayed(0, 200);
                AppMethodBeat.o(18851);
                return;
            }
            b.this.bbV = true;
            AppMethodBeat.o(18851);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private CleanChattingDetailUI kyH;

    class a {
        TextView kxr;
        TextView kxs;
        CheckBox kxt;
        int position;

        a() {
        }
    }

    class b {
        CheckBox gnD;
        TextView gxi;
        MMImageView kxu;
        ImageView kxv;
        View kxw;
        View kxx;

        b() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(18860);
        com.tencent.mm.plugin.clean.c.a tz = tz(i);
        AppMethodBeat.o(18860);
        return tz;
    }

    public b(CleanChattingDetailUI cleanChattingDetailUI, ArrayList<com.tencent.mm.plugin.clean.c.a> arrayList) {
        AppMethodBeat.i(18852);
        this.kyH = cleanChattingDetailUI;
        this.iLD = arrayList;
        this.jur = new HashSet();
        AppMethodBeat.o(18852);
    }

    public final int getCount() {
        AppMethodBeat.i(18853);
        int size = this.iLD.size();
        AppMethodBeat.o(18853);
        return size;
    }

    public final com.tencent.mm.plugin.clean.c.a tz(int i) {
        AppMethodBeat.i(18854);
        com.tencent.mm.plugin.clean.c.a aVar = (com.tencent.mm.plugin.clean.c.a) this.iLD.get(i);
        AppMethodBeat.o(18854);
        return aVar;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(final int i, View view, ViewGroup viewGroup) {
        b bVar;
        AppMethodBeat.i(18855);
        long currentTimeMillis = System.currentTimeMillis();
        if (view == null) {
            view = this.kyH.getLayoutInflater().inflate(R.layout.oh, viewGroup, false);
            b bVar2 = new b();
            bVar2.kxu = (MMImageView) view.findViewById(R.id.aw0);
            bVar2.gnD = (CheckBox) view.findViewById(R.id.a1b);
            bVar2.kxw = view.findViewById(R.id.aw3);
            bVar2.kxx = view.findViewById(R.id.aw2);
            bVar2.kxv = (ImageView) view.findViewById(R.id.aw1);
            bVar2.gxi = (TextView) view.findViewById(R.id.rr);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        com.tencent.mm.plugin.clean.c.a tz = tz(i);
        bVar.kxu.setTag(tz.filePath);
        bVar.kxw.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(18847);
                b.a(b.this, i);
                b.this.notifyDataSetChanged();
                AppMethodBeat.o(18847);
            }
        });
        if (this.jur.contains(Integer.valueOf(i))) {
            bVar.gnD.setChecked(true);
            bVar.kxx.setVisibility(0);
        } else {
            bVar.gnD.setChecked(false);
            bVar.kxx.setVisibility(8);
        }
        if (tz.type == 3) {
            bVar.kxv.setVisibility(0);
        } else {
            bVar.kxv.setVisibility(8);
        }
        if (tz.type == 4) {
            bVar.kxu.setImageResource(com.tencent.mm.pluginsdk.model.o.aiD(com.tencent.mm.vfs.e.cv(tz.filePath)));
            bVar.gxi.setText(new com.tencent.mm.vfs.b(tz.filePath).getName());
            bVar.gxi.setVisibility(0);
        } else {
            if (kxm == 0) {
                kxm = view.getMeasuredWidth();
            }
            com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
            aVar.fHe = 1;
            aVar.ePI = false;
            aVar.ePO = kxm;
            aVar.ePN = kxm;
            if (tz.type == 1) {
                aVar.ePJ = tz.filePath;
                o.ahp().a(tz.filePath, bVar.kxu, aVar.ahG());
            } else {
                aVar.ePJ = tz.thumbPath;
                o.ahp().a(tz.thumbPath, bVar.kxu, aVar.ahG());
            }
            bVar.gxi.setVisibility(8);
        }
        ab.d("MicroMsg.CleanChattingDetailAdapter", "getView time=%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(18855);
        return view;
    }

    public final long tw(int i) {
        AppMethodBeat.i(18856);
        long bfH = ((com.tencent.mm.plugin.clean.c.a) this.iLD.get(i)).bfH();
        AppMethodBeat.o(18856);
        return bfH;
    }

    public final View a(int i, View view, ViewGroup viewGroup) {
        a aVar;
        AppMethodBeat.i(18857);
        if (view == null) {
            ab.v("MicroMsg.CleanChattingDetailAdapter", "convertView is null");
            view = this.kyH.getLayoutInflater().inflate(R.layout.oi, viewGroup, false);
            aVar = new a();
            aVar.kxr = (TextView) view.findViewById(R.id.aw4);
            aVar.kxs = (TextView) view.findViewById(R.id.aw5);
            aVar.kxt = (CheckBox) view.findViewById(R.id.aw6);
            view.setTag(aVar);
        } else {
            ab.v("MicroMsg.CleanChattingDetailAdapter", "convertView is not null");
            aVar = (a) view.getTag();
        }
        com.tencent.mm.plugin.clean.c.a tz = tz(i);
        aVar.position = i;
        aVar.kxr.setText(h.formatTime(this.kyH.getString(R.string.bz3), tz.fXb / 1000));
        long bfH = tz.bfH();
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < this.iLD.size(); i2++) {
            if (((com.tencent.mm.plugin.clean.c.a) this.iLD.get(i2)).bfH() == bfH) {
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
        AppMethodBeat.o(18857);
        return view;
    }

    /* Access modifiers changed, original: final */
    public final void bgi() {
        boolean z;
        AppMethodBeat.i(18858);
        this.kyH.tx(this.jur.size());
        CleanChattingDetailUI cleanChattingDetailUI = this.kyH;
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
            j = ((com.tencent.mm.plugin.clean.c.a) this.iLD.get(((Integer) it.next()).intValue())).size + j;
        }
        CleanChattingDetailUI cleanChattingDetailUI2 = this.kyH;
        if (j > 0) {
            cleanChattingDetailUI2.kxC.setText(cleanChattingDetailUI2.getString(R.string.b58, new Object[]{bo.ga(j)}));
            AppMethodBeat.o(18858);
            return;
        }
        cleanChattingDetailUI2.kxC.setText("");
        AppMethodBeat.o(18858);
    }

    public final void bgh() {
        AppMethodBeat.i(18859);
        this.jur.clear();
        bgi();
        AppMethodBeat.o(18859);
    }
}

package com.tencent.p177mm.plugin.clean.p364ui.newui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p612ui.MMImageView;
import com.tencent.p177mm.p612ui.gridviewheaders.C46688e;
import com.tencent.p177mm.p612ui.gridviewheaders.GridHeadersGridView.C40873c;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.clean.p362c.C11389a;
import com.tencent.p177mm.pluginsdk.model.C44065o;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.sdk.platformtools.C15429k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.clean.ui.newui.b */
public final class C27662b extends BaseAdapter implements C46688e {
    private static int kxm = 0;
    private boolean bbV;
    ArrayList<C11389a> iLD;
    OnItemClickListener jMk = new C28163();
    HashSet<Integer> jur;
    C40873c kxn = new C276642();
    private C7306ak kxo = new C75004();
    OnScrollListener kxp = new C28175();
    private CleanChattingDetailUI kyH;

    /* renamed from: com.tencent.mm.plugin.clean.ui.newui.b$3 */
    class C28163 implements OnItemClickListener {
        C28163() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(18849);
            C4990ab.m7417i("MicroMsg.CleanChattingDetailAdapter", "Click Item position=%d", Integer.valueOf(i));
            C11389a tz = C27662b.this.mo45515tz(i);
            Intent intent = new Intent();
            switch (tz.type) {
                case 1:
                    intent.putExtra("key_title", C27662b.this.kyH.getString(C25738R.string.aq5));
                    intent.putExtra("show_menu", false);
                    intent.putExtra("key_image_path", tz.filePath);
                    C25985d.m41473f(C27662b.this.kyH, ".ui.tools.ShowImageUI", intent);
                    AppMethodBeat.m2505o(18849);
                    return;
                case 3:
                    intent.setAction("android.intent.action.VIEW");
                    C15429k.m23712a(C27662b.this.kyH, intent, C5730e.asY(tz.filePath), "video/*");
                    try {
                        C27662b.this.kyH.startActivity(Intent.createChooser(intent, C27662b.this.kyH.getString(C25738R.string.f1w)));
                        AppMethodBeat.m2505o(18849);
                        return;
                    } catch (Exception e) {
                        AppMethodBeat.m2505o(18849);
                        return;
                    }
                case 4:
                    intent.putExtra("app_msg_id", tz.cuQ);
                    C25985d.m41473f(C27662b.this.kyH, ".ui.chatting.AppAttachDownloadUI", intent);
                    break;
            }
            AppMethodBeat.m2505o(18849);
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.newui.b$5 */
    class C28175 implements OnScrollListener {
        C28175() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.m2504i(18851);
            C32291o.ahp().mo43773cm(i);
            if (i != 2) {
                C27662b.this.bbV = false;
                C27662b.this.kxo.removeCallbacksAndMessages(null);
                C27662b.this.kxo.sendEmptyMessageDelayed(0, 200);
                AppMethodBeat.m2505o(18851);
                return;
            }
            C27662b.this.bbV = true;
            AppMethodBeat.m2505o(18851);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.newui.b$4 */
    class C75004 extends C7306ak {
        C75004() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(18850);
            if (!C27662b.this.bbV) {
                C27662b.this.notifyDataSetChanged();
            }
            AppMethodBeat.m2505o(18850);
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.newui.b$a */
    class C20252a {
        TextView kxr;
        TextView kxs;
        CheckBox kxt;
        int position;

        C20252a() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.newui.b$2 */
    class C276642 implements C40873c {
        C276642() {
        }

        /* renamed from: de */
        public final void mo23152de(View view) {
            AppMethodBeat.m2504i(18848);
            C27662b.m43959a(C27662b.this, (C20252a) view.getTag());
            C27662b.this.notifyDataSetChanged();
            AppMethodBeat.m2505o(18848);
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.newui.b$b */
    class C27665b {
        CheckBox gnD;
        TextView gxi;
        MMImageView kxu;
        ImageView kxv;
        View kxw;
        View kxx;

        C27665b() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.m2504i(18860);
        C11389a tz = mo45515tz(i);
        AppMethodBeat.m2505o(18860);
        return tz;
    }

    public C27662b(CleanChattingDetailUI cleanChattingDetailUI, ArrayList<C11389a> arrayList) {
        AppMethodBeat.m2504i(18852);
        this.kyH = cleanChattingDetailUI;
        this.iLD = arrayList;
        this.jur = new HashSet();
        AppMethodBeat.m2505o(18852);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(18853);
        int size = this.iLD.size();
        AppMethodBeat.m2505o(18853);
        return size;
    }

    /* renamed from: tz */
    public final C11389a mo45515tz(int i) {
        AppMethodBeat.m2504i(18854);
        C11389a c11389a = (C11389a) this.iLD.get(i);
        AppMethodBeat.m2505o(18854);
        return c11389a;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(final int i, View view, ViewGroup viewGroup) {
        C27665b c27665b;
        AppMethodBeat.m2504i(18855);
        long currentTimeMillis = System.currentTimeMillis();
        if (view == null) {
            view = this.kyH.getLayoutInflater().inflate(2130969140, viewGroup, false);
            C27665b c27665b2 = new C27665b();
            c27665b2.kxu = (MMImageView) view.findViewById(2131822764);
            c27665b2.gnD = (CheckBox) view.findViewById(2131821593);
            c27665b2.kxw = view.findViewById(2131822767);
            c27665b2.kxx = view.findViewById(2131822766);
            c27665b2.kxv = (ImageView) view.findViewById(2131822765);
            c27665b2.gxi = (TextView) view.findViewById(2131821227);
            view.setTag(c27665b2);
            c27665b = c27665b2;
        } else {
            c27665b = (C27665b) view.getTag();
        }
        C11389a tz = mo45515tz(i);
        c27665b.kxu.setTag(tz.filePath);
        c27665b.kxw.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(18847);
                C27662b.m43958a(C27662b.this, i);
                C27662b.this.notifyDataSetChanged();
                AppMethodBeat.m2505o(18847);
            }
        });
        if (this.jur.contains(Integer.valueOf(i))) {
            c27665b.gnD.setChecked(true);
            c27665b.kxx.setVisibility(0);
        } else {
            c27665b.gnD.setChecked(false);
            c27665b.kxx.setVisibility(8);
        }
        if (tz.type == 3) {
            c27665b.kxv.setVisibility(0);
        } else {
            c27665b.kxv.setVisibility(8);
        }
        if (tz.type == 4) {
            c27665b.kxu.setImageResource(C44065o.aiD(C5730e.m8630cv(tz.filePath)));
            c27665b.gxi.setText(new C5728b(tz.filePath).getName());
            c27665b.gxi.setVisibility(0);
        } else {
            if (kxm == 0) {
                kxm = view.getMeasuredWidth();
            }
            C17927a c17927a = new C17927a();
            c17927a.fHe = 1;
            c17927a.ePI = false;
            c17927a.ePO = kxm;
            c17927a.ePN = kxm;
            if (tz.type == 1) {
                c17927a.ePJ = tz.filePath;
                C32291o.ahp().mo43766a(tz.filePath, c27665b.kxu, c17927a.ahG());
            } else {
                c17927a.ePJ = tz.thumbPath;
                C32291o.ahp().mo43766a(tz.thumbPath, c27665b.kxu, c17927a.ahG());
            }
            c27665b.gxi.setVisibility(8);
        }
        C4990ab.m7411d("MicroMsg.CleanChattingDetailAdapter", "getView time=%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(18855);
        return view;
    }

    /* renamed from: tw */
    public final long mo23150tw(int i) {
        AppMethodBeat.m2504i(18856);
        long bfH = ((C11389a) this.iLD.get(i)).bfH();
        AppMethodBeat.m2505o(18856);
        return bfH;
    }

    /* renamed from: a */
    public final View mo23142a(int i, View view, ViewGroup viewGroup) {
        C20252a c20252a;
        AppMethodBeat.m2504i(18857);
        if (view == null) {
            C4990ab.m7418v("MicroMsg.CleanChattingDetailAdapter", "convertView is null");
            view = this.kyH.getLayoutInflater().inflate(2130969141, viewGroup, false);
            c20252a = new C20252a();
            c20252a.kxr = (TextView) view.findViewById(2131822768);
            c20252a.kxs = (TextView) view.findViewById(2131822769);
            c20252a.kxt = (CheckBox) view.findViewById(2131822770);
            view.setTag(c20252a);
        } else {
            C4990ab.m7418v("MicroMsg.CleanChattingDetailAdapter", "convertView is not null");
            c20252a = (C20252a) view.getTag();
        }
        C11389a tz = mo45515tz(i);
        c20252a.position = i;
        c20252a.kxr.setText(C14835h.formatTime(this.kyH.getString(C25738R.string.bz3), tz.fXb / 1000));
        long bfH = tz.bfH();
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < this.iLD.size(); i2++) {
            if (((C11389a) this.iLD.get(i2)).bfH() == bfH) {
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
            c20252a.kxt.setChecked(true);
        } else {
            c20252a.kxt.setChecked(false);
        }
        AppMethodBeat.m2505o(18857);
        return view;
    }

    /* Access modifiers changed, original: final */
    public final void bgi() {
        boolean z;
        AppMethodBeat.m2504i(18858);
        this.kyH.mo35491tx(this.jur.size());
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
            j = ((C11389a) this.iLD.get(((Integer) it.next()).intValue())).size + j;
        }
        CleanChattingDetailUI cleanChattingDetailUI2 = this.kyH;
        if (j > 0) {
            cleanChattingDetailUI2.kxC.setText(cleanChattingDetailUI2.getString(C25738R.string.b58, new Object[]{C5046bo.m7565ga(j)}));
            AppMethodBeat.m2505o(18858);
            return;
        }
        cleanChattingDetailUI2.kxC.setText("");
        AppMethodBeat.m2505o(18858);
    }

    public final void bgh() {
        AppMethodBeat.m2504i(18859);
        this.jur.clear();
        bgi();
        AppMethodBeat.m2505o(18859);
    }
}

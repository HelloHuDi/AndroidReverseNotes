package com.tencent.mm.ui.chatting.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.e;
import java.util.Date;
import java.util.List;

public final class b extends android.support.v7.widget.RecyclerView.a {
    private com.tencent.mm.at.a.a.c elH = null;
    private String emo;
    public List<c> iJL = null;
    private boolean kuU = true;
    public boolean kuX;
    Context mContext;
    boolean mgP = false;
    public boolean mod = false;
    long yNB;
    public b yNC;

    public class a extends v {
        TextView gnf;
        ProgressBar progressBar;

        public a(View view) {
            super(view);
            AppMethodBeat.i(31131);
            this.gnf = (TextView) view.findViewById(R.id.bpo);
            this.progressBar = (ProgressBar) view.findViewById(R.id.bpn);
            AppMethodBeat.o(31131);
        }
    }

    public interface b {
        void a(boolean z, c cVar, int i);
    }

    public class d extends v {
        TextView kuL;
        ImageView mok;
        View mol;
        ImageView mom;
        View mon;
        CheckBox moo;
        View mop;

        public d(View view) {
            super(view);
            AppMethodBeat.i(31137);
            this.mok = (ImageView) view.findViewById(R.id.bpp);
            this.mol = view.findViewById(R.id.bpt);
            this.mon = view.findViewById(R.id.bpv);
            this.kuL = (TextView) view.findViewById(R.id.avh);
            this.mom = (ImageView) view.findViewById(R.id.bpx);
            this.moo = (CheckBox) view.findViewById(R.id.bpy);
            this.mop = view.findViewById(R.id.bpz);
            this.mop.setVisibility(8);
            this.moo.setVisibility(8);
            this.mol.setVisibility(8);
            this.kuL.setVisibility(8);
            this.mon.setVisibility(8);
            this.mok.setOnClickListener(new OnClickListener(b.this) {
                public final void onClick(View view) {
                    AppMethodBeat.i(31135);
                    c Ox = b.this.Ox(((Integer) view.getTag()).intValue());
                    if (Ox == null) {
                        AppMethodBeat.o(31135);
                        return;
                    }
                    b bVar = b.this;
                    Intent intent = new Intent();
                    intent.putExtra("key_biz_chat_id", bVar.yNB);
                    intent.putExtra("key_is_biz_chat", bVar.mgP);
                    if (Ox == null) {
                        ab.e("MicroMsg.MediaHistoryGalleryAdapter", "[enterGallery] item == null");
                        AppMethodBeat.o(31135);
                        return;
                    }
                    bi biVar = Ox.cKd;
                    if (biVar == null) {
                        ab.e("MicroMsg.MediaHistoryGalleryAdapter", "[enterGallery] msg == null");
                        AppMethodBeat.o(31135);
                        return;
                    }
                    int width;
                    int height;
                    int i = bVar.mContext.getResources().getConfiguration().orientation;
                    int[] iArr = new int[2];
                    if (view != null) {
                        width = view.getWidth();
                        height = view.getHeight();
                        view.getLocationInWindow(iArr);
                    } else {
                        height = 0;
                        width = 0;
                    }
                    intent.addFlags(536870912);
                    intent.putExtra("img_gallery_msg_id", biVar.field_msgId).putExtra("img_gallery_msg_svr_id", biVar.field_msgSvrId).putExtra("img_gallery_talker", biVar.field_talker).putExtra("img_gallery_chatroom_name", biVar.field_talker).putExtra("img_gallery_orientation", i);
                    if (view != null) {
                        intent.putExtra("img_gallery_width", width).putExtra("img_gallery_height", height).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]).putExtra("img_gallery_enter_from_grid", true);
                    } else {
                        intent.putExtra("img_gallery_back_from_grid", true);
                    }
                    com.tencent.mm.bp.d.f(bVar.mContext, "com.tencent.mm.ui.chatting.gallery.ImageGalleryUI", intent);
                    ((Activity) bVar.mContext).overridePendingTransition(0, 0);
                    AppMethodBeat.o(31135);
                }
            });
            this.mop.setOnClickListener(new OnClickListener(b.this) {
                public final void onClick(View view) {
                    boolean z;
                    AppMethodBeat.i(31136);
                    if (d.this.moo.isChecked()) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (com.tencent.mm.ui.chatting.gallery.h.a.yVE.mnX.size() < 9) {
                        d.this.moo.setChecked(z);
                        if (z) {
                            d.this.mom.setVisibility(0);
                        } else {
                            d.this.mom.setVisibility(8);
                        }
                    } else if (!z) {
                        d.this.moo.setChecked(false);
                    }
                    if (b.this.yNC != null) {
                        int intValue = ((Integer) view.getTag()).intValue();
                        b.this.yNC.a(z, b.this.Ox(intValue), intValue);
                    }
                    AppMethodBeat.o(31136);
                }
            });
            AppMethodBeat.o(31137);
        }
    }

    public static class c {
        public bi cKd;
        public String imagePath;
        boolean mog;
        public long timeStamp;
        public int type = 0;
        public a yNE = new a();

        class a {
            public com.tencent.mm.af.j.b cJM;
            public String moi;

            a() {
            }
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(31132);
            if (this.cKd == null || !(obj instanceof bi) || obj == null) {
                boolean equals = super.equals(obj);
                AppMethodBeat.o(31132);
                return equals;
            } else if (this.cKd.field_msgId == ((bi) obj).field_msgId) {
                AppMethodBeat.o(31132);
                return true;
            } else {
                AppMethodBeat.o(31132);
                return false;
            }
        }

        public c(bi biVar) {
            String ui;
            AppMethodBeat.i(31133);
            this.cKd = biVar;
            if (biVar.bws() || biVar.bwt()) {
                this.mog = true;
                o.all();
                ui = t.ui(biVar.field_imgPath);
                s ut = u.ut(biVar.field_imgPath);
                if (ut != null) {
                    this.yNE.moi = bo.mK(ut.fXd);
                }
                this.yNE.cJM = com.tencent.mm.af.j.b.X(biVar.field_content, biVar.field_reserved);
            } else {
                ui = com.tencent.mm.at.o.ahl().c(biVar.field_imgPath, false, false);
                if (!(bo.isNullOrNil(ui) || ui.endsWith("hd") || !e.ct(ui + "hd"))) {
                    ui = ui + "hd";
                }
            }
            if (biVar.dtA()) {
                com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(biVar.field_content);
                String str = null;
                if (!(me == null || me.csD == null || me.csD.length() <= 0)) {
                    com.tencent.mm.pluginsdk.model.app.b aiE = am.aUq().aiE(me.csD);
                    if (aiE != null) {
                        str = aiE.field_fileFullPath;
                    }
                }
                if (str != null) {
                    ui = str;
                }
            }
            this.imagePath = ui;
            this.timeStamp = biVar.field_createTime;
            AppMethodBeat.o(31133);
        }

        public c(long j) {
            AppMethodBeat.i(31134);
            this.timeStamp = j;
            this.type = BaseClientBuilder.API_PRIORITY_OTHER;
            AppMethodBeat.o(31134);
        }
    }

    public b(Context context, List<c> list, String str) {
        AppMethodBeat.i(31138);
        this.iJL = list;
        this.emo = str;
        aw.ZK();
        this.kuU = com.tencent.mm.model.c.isSDCardAvailable();
        this.mContext = context;
        hT(context);
        AppMethodBeat.o(31138);
    }

    public b(Context context, List<c> list, String str, long j) {
        AppMethodBeat.i(31139);
        this.iJL = list;
        this.yNB = j;
        this.emo = str;
        aw.ZK();
        this.kuU = com.tencent.mm.model.c.isSDCardAvailable();
        this.mgP = true;
        this.mContext = context;
        hT(context);
        AppMethodBeat.o(31139);
    }

    private void hT(Context context) {
        AppMethodBeat.i(31140);
        com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
        aVar.fHe = 1;
        aVar.eQa = true;
        aVar.ePO = com.tencent.mm.bz.a.gd(context) / 4;
        aVar.ePN = com.tencent.mm.bz.a.gd(context) / 4;
        aVar.ePV = R.color.wm;
        this.elH = aVar.ahG();
        AppMethodBeat.o(31140);
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.i(31141);
        int i2 = Ox(i).type;
        AppMethodBeat.o(31141);
        return i2;
    }

    public final v a(ViewGroup viewGroup, int i) {
        AppMethodBeat.i(31142);
        if (i == BaseClientBuilder.API_PRIORITY_OTHER) {
            a aVar = new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.a25, viewGroup, false));
            AppMethodBeat.o(31142);
            return aVar;
        }
        v dVar = new d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.a7e, viewGroup, false));
        AppMethodBeat.o(31142);
        return dVar;
    }

    public final void a(v vVar, int i, List list) {
        AppMethodBeat.i(31143);
        if (list == null || list.size() <= 0 || !(vVar instanceof d)) {
            super.a(vVar, i, list);
            AppMethodBeat.o(31143);
        } else if (((Integer) list.get(0)).intValue() == 0) {
            ((d) vVar).moo.setChecked(false);
            ((d) vVar).moo.setVisibility(0);
            ((d) vVar).mop.setVisibility(0);
            AppMethodBeat.o(31143);
        } else {
            ((d) vVar).moo.setChecked(false);
            ((d) vVar).moo.setVisibility(8);
            ((d) vVar).mop.setVisibility(8);
            AppMethodBeat.o(31143);
        }
    }

    public final void a(v vVar, int i) {
        AppMethodBeat.i(31144);
        if (this.kuU) {
            c Ox = Ox(i);
            if (vVar.apN != BaseClientBuilder.API_PRIORITY_OTHER) {
                ((d) vVar).mok.setTag(Integer.valueOf(i));
                ((d) vVar).mop.setTag(Integer.valueOf(i));
                com.tencent.mm.at.o.ahp().a(Ox.imagePath, ((d) vVar).mok, this.elH);
                if (Ox.mog) {
                    ((d) vVar).mol.setVisibility(0);
                    ((d) vVar).kuL.setVisibility(0);
                    ((d) vVar).kuL.setText(bo.bc(Ox.yNE.moi, ""));
                } else {
                    ((d) vVar).kuL.setVisibility(8);
                    ((d) vVar).mol.setVisibility(8);
                }
                if (this.mod) {
                    ((d) vVar).mop.setVisibility(0);
                    ((d) vVar).moo.setVisibility(0);
                    if (com.tencent.mm.ui.chatting.gallery.h.a.yVE.bE(Ox.cKd)) {
                        ((d) vVar).mom.setVisibility(0);
                        ((d) vVar).moo.setChecked(true);
                        AppMethodBeat.o(31144);
                        return;
                    }
                    ((d) vVar).mom.setVisibility(8);
                    ((d) vVar).moo.setChecked(false);
                    AppMethodBeat.o(31144);
                    return;
                }
                ((d) vVar).mop.setVisibility(8);
                ((d) vVar).moo.setVisibility(8);
                AppMethodBeat.o(31144);
                return;
            } else if (i == getItemCount() - 1 || hb(Ox(i + 1).timeStamp) != hb(Ox.timeStamp)) {
                ((a) vVar).gnf.setVisibility(8);
                AppMethodBeat.o(31144);
                return;
            } else {
                ((a) vVar).gnf.setVisibility(0);
                ((a) vVar).gnf.setText(ha(Ox.timeStamp));
                if (this.kuX) {
                    ((a) vVar).progressBar.setVisibility(0);
                    AppMethodBeat.o(31144);
                    return;
                }
                ((a) vVar).progressBar.setVisibility(8);
                AppMethodBeat.o(31144);
                return;
            }
        }
        ab.e("MicroMsg.MediaHistoryGalleryAdapter", "[onBindViewHolder] isSDCardAvailable:%s", Boolean.valueOf(this.kuU));
        AppMethodBeat.o(31144);
    }

    public final String ha(long j) {
        AppMethodBeat.i(31145);
        String a = com.tencent.mm.ui.gridviewheaders.a.dJg().a(new Date(j), this.mContext);
        AppMethodBeat.o(31145);
        return a;
    }

    private static long hb(long j) {
        AppMethodBeat.i(31146);
        long b = com.tencent.mm.ui.gridviewheaders.a.dJg().b(new Date(j));
        AppMethodBeat.o(31146);
        return b;
    }

    public final int getItemCount() {
        AppMethodBeat.i(31147);
        int size = this.iJL.size();
        AppMethodBeat.o(31147);
        return size;
    }

    public final c Ox(int i) {
        AppMethodBeat.i(31148);
        c cVar = (c) this.iJL.get(i);
        AppMethodBeat.o(31148);
        return cVar;
    }
}

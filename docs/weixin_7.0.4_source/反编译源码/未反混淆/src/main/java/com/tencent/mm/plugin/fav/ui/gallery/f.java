package com.tencent.mm.plugin.fav.ui.gallery;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.v;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.at.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.protocal.protobuf.abh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.r;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class f extends android.support.v7.widget.RecyclerView.a {
    private com.tencent.mm.at.a.a.c elH = null;
    List<c> iJL = null;
    private boolean kuU = true;
    boolean kuX;
    Context mContext;
    abh mnG = new abh();
    com.tencent.mm.plugin.fav.ui.gallery.g.b mob;
    b moc;
    boolean mod = false;

    public interface b {
        void a(boolean z, c cVar, int i);
    }

    public static class c {
        public String imagePath;
        public d mof;
        boolean mog;
        public a moh = new a();
        public long timeStamp;
        public int type = 0;

        class a {
            public String moi;

            a() {
            }
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(74567);
            boolean equals;
            if (this.mof == null || !(obj instanceof d) || obj == null) {
                equals = super.equals(obj);
                AppMethodBeat.o(74567);
                return equals;
            }
            equals = this.mof.cAJ.mnd.equals(((d) obj).cAJ.mnd);
            AppMethodBeat.o(74567);
            return equals;
        }

        public c(d dVar) {
            String c;
            AppMethodBeat.i(74568);
            this.mof = dVar;
            if (dVar.bws() || dVar.bwt()) {
                c = com.tencent.mm.plugin.fav.a.b.c(dVar.cAJ);
            } else {
                c = com.tencent.mm.plugin.fav.a.b.b(dVar.cAJ);
                if (!new com.tencent.mm.vfs.b(c).exists()) {
                    c = com.tencent.mm.plugin.fav.a.b.c(dVar.cAJ);
                }
            }
            this.imagePath = c;
            this.timeStamp = dVar.mnW.field_updateTime;
            if (dVar.bws() || dVar.bwt()) {
                this.mog = true;
                this.moh.moi = bo.mK(dVar.cAJ.duration);
            }
            AppMethodBeat.o(74568);
        }
    }

    public class d extends v {
        TextView kuL;
        OnLongClickListener mlV = new OnLongClickListener() {
            public final boolean onLongClick(View view) {
                AppMethodBeat.i(74575);
                if (f.this.mod) {
                    AppMethodBeat.o(74575);
                    return false;
                }
                if (view.getTag(R.id.cy) instanceof int[]) {
                    int[] iArr = (int[]) view.getTag(R.id.cy);
                    s(view, iArr[0], iArr[1]);
                } else {
                    s(view, 0, 0);
                }
                AppMethodBeat.o(74575);
                return true;
            }

            private void s(View view, int i, int i2) {
                AppMethodBeat.i(74576);
                final int intValue = ((Integer) view.getTag(R.id.ax)).intValue();
                final c vG = f.this.vG(intValue);
                if (vG == null) {
                    AppMethodBeat.o(74576);
                    return;
                }
                com.tencent.mm.ui.widget.b.a aVar = new com.tencent.mm.ui.widget.b.a(f.this.mContext);
                d.this.mom.setVisibility(0);
                aVar.zHM = new OnDismissListener() {
                    public final void onDismiss() {
                        AppMethodBeat.i(74572);
                        if (!(d.this.mom == null || f.this.mod)) {
                            d.this.mom.setVisibility(8);
                        }
                        AppMethodBeat.o(74572);
                    }
                };
                aVar.a(view, new OnCreateContextMenuListener() {
                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                        AppMethodBeat.i(74573);
                        String b = com.tencent.mm.plugin.fav.a.b.b(vG.mof.cAJ);
                        boolean ct = e.ct(b);
                        boolean amo = r.amo(b);
                        if (!vG.mog && ct && !amo) {
                            contextMenu.add(0, 0, 0, f.this.mContext.getString(R.string.bri));
                            contextMenu.add(0, 1, 0, f.this.mContext.getString(R.string.bq_));
                            contextMenu.add(0, 2, 0, f.this.mContext.getString(R.string.brb));
                        } else if (vG.mog && ct && !amo) {
                            contextMenu.add(0, 0, 0, f.this.mContext.getString(R.string.bri));
                            contextMenu.add(0, 2, 0, f.this.mContext.getString(R.string.dx0));
                        } else {
                            ab.d("MicroMsg.MediaHistoryGalleryAdapter", "openPopupMenu, isVideo:%s, exist:%s, isGif:%s", Boolean.valueOf(vG.mog), Boolean.valueOf(ct), Boolean.valueOf(amo));
                        }
                        contextMenu.add(0, 4, 0, f.this.mContext.getString(R.string.bp6));
                        AppMethodBeat.o(74573);
                    }
                }, new com.tencent.mm.ui.base.n.d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.i(74574);
                        String b = com.tencent.mm.plugin.fav.a.b.b(vG.mof.cAJ);
                        switch (menuItem.getItemId()) {
                            case 0:
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(vG.mof);
                                f.this.mob.bS(arrayList);
                                AppMethodBeat.o(74574);
                                return;
                            case 1:
                                h.j(vG.mof.mnW.field_localId, 0, 0);
                                com.tencent.mm.plugin.fav.a.b.d(b, f.this.mContext);
                                AppMethodBeat.o(74574);
                                return;
                            case 2:
                                if (bo.isNullOrNil(b)) {
                                    ab.w("MicroMsg.MediaHistoryGalleryAdapter", "save image fail, path is null");
                                    AppMethodBeat.o(74574);
                                    return;
                                } else if (vG.mog) {
                                    String uu = u.uu(b);
                                    ab.i("MicroMsg.MediaHistoryGalleryAdapter", "save video now video path %s out path %s", b, uu);
                                    if (bo.isNullOrNil(uu)) {
                                        Toast.makeText(f.this.mContext, f.this.mContext.getString(R.string.f1c), 1).show();
                                        AppMethodBeat.o(74574);
                                        return;
                                    }
                                    Toast.makeText(f.this.mContext, f.this.mContext.getString(R.string.f1d, new Object[]{uu}), 1).show();
                                    n.a(uu, f.this.mContext);
                                    AppMethodBeat.o(74574);
                                    return;
                                } else if (!q.a(b, f.this.mContext, R.string.b3r)) {
                                    Toast.makeText(f.this.mContext, f.this.mContext.getString(R.string.bra), 1).show();
                                    AppMethodBeat.o(74574);
                                    return;
                                }
                                break;
                            case 4:
                                f.this.mnG.index = f.this.getItemCount() - intValue;
                                ((y) g.K(y.class)).a(f.this.mContext, vG.mof.mnW, f.this.mnG);
                                break;
                        }
                        AppMethodBeat.o(74574);
                    }
                }, i, i2);
                AppMethodBeat.o(74576);
            }
        };
        ImageView mok;
        View mol;
        ImageView mom;
        View mon;
        CheckBox moo;
        View mop;

        public d(View view) {
            super(view);
            AppMethodBeat.i(74577);
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
            this.mok.setOnTouchListener(new OnTouchListener(f.this) {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(74569);
                    if (motionEvent.getAction() == 0) {
                        view.setTag(R.id.cy, new int[]{(int) motionEvent.getRawX(), (int) motionEvent.getRawY()});
                    }
                    AppMethodBeat.o(74569);
                    return false;
                }
            });
            this.mok.setOnClickListener(new OnClickListener(f.this) {
                public final void onClick(View view) {
                    AppMethodBeat.i(74570);
                    c vG = f.this.vG(((Integer) view.getTag(R.id.ax)).intValue());
                    if (vG == null) {
                        AppMethodBeat.o(74570);
                        return;
                    }
                    f fVar = f.this;
                    Intent intent = new Intent();
                    if (vG == null) {
                        ab.e("MicroMsg.MediaHistoryGalleryAdapter", "[enterGallery] item == null");
                        AppMethodBeat.o(74570);
                        return;
                    }
                    d dVar = vG.mof;
                    if (dVar == null) {
                        ab.e("MicroMsg.MediaHistoryGalleryAdapter", "[enterGallery] msg == null");
                        AppMethodBeat.o(74570);
                        return;
                    }
                    int i;
                    int i2 = 0;
                    ArrayList arrayList = new ArrayList();
                    Iterator it = fVar.iJL.iterator();
                    while (true) {
                        i = i2;
                        if (!it.hasNext()) {
                            break;
                        }
                        long j = ((c) it.next()).mof.mnW.field_localId;
                        if (!arrayList.contains(Long.valueOf(j))) {
                            arrayList.add(Long.valueOf(j));
                            if (j == vG.mof.mnW.field_localId) {
                                i = arrayList.size() - 1;
                            }
                        }
                        i2 = i;
                    }
                    long[] jArr = new long[arrayList.size()];
                    i2 = i + -20 > 0 ? i - 20 : 0;
                    i = i + 20 < arrayList.size() ? i + 20 : arrayList.size();
                    for (int i3 = i2; i3 < i; i3++) {
                        jArr[i3] = ((Long) arrayList.get(i3)).longValue();
                    }
                    intent.addFlags(536870912);
                    intent.putExtra("KEY_MEDIA_FAVID_LIST", jArr).putExtra("key_detail_info_id", dVar.mnW.field_localId).putExtra("key_detail_data_id", dVar.cAJ.mnd);
                    intent.putExtra("key_detail_fav_scene", fVar.mnG.scene);
                    intent.putExtra("key_detail_fav_sub_scene", fVar.mnG.jSW);
                    intent.putExtra("key_detail_fav_index", 0);
                    intent.putExtra("key_detail_fav_query", fVar.mnG.query);
                    intent.putExtra("key_detail_fav_sessionid", fVar.mnG.cvF);
                    intent.putExtra("key_detail_fav_tags", fVar.mnG.mfg);
                    com.tencent.mm.plugin.fav.a.b.b(fVar.mContext, ".ui.gallery.FavMediaGalleryUI", intent);
                    ((Activity) fVar.mContext).overridePendingTransition(0, 0);
                    AppMethodBeat.o(74570);
                }
            });
            this.mok.setOnLongClickListener(this.mlV);
            this.mop.setOnClickListener(new OnClickListener(f.this) {
                public final void onClick(View view) {
                    boolean z;
                    AppMethodBeat.i(74571);
                    if (d.this.moo.isChecked()) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (a.moa.mnX.size() < 9) {
                        d.this.moo.setChecked(z);
                        if (z) {
                            d.this.mom.setVisibility(0);
                        } else {
                            d.this.mom.setVisibility(8);
                        }
                    } else if (!z) {
                        d.this.moo.setChecked(false);
                    }
                    if (f.this.moc != null) {
                        int intValue = ((Integer) view.getTag()).intValue();
                        f.this.moc.a(z, f.this.vG(intValue), intValue);
                    }
                    AppMethodBeat.o(74571);
                }
            });
            AppMethodBeat.o(74577);
        }
    }

    public class a extends v {
        TextView gnf;
        ProgressBar progressBar;

        public a(View view) {
            super(view);
            AppMethodBeat.i(74566);
            this.gnf = (TextView) view.findViewById(R.id.bpo);
            this.progressBar = (ProgressBar) view.findViewById(R.id.bpn);
            AppMethodBeat.o(74566);
        }
    }

    public f(Context context, List<c> list, com.tencent.mm.plugin.fav.ui.gallery.g.b bVar) {
        AppMethodBeat.i(74578);
        this.iJL = list;
        this.kuU = g.RP().isSDCardAvailable();
        this.mContext = context;
        this.mob = bVar;
        com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
        aVar.fHe = 1;
        aVar.eQa = true;
        aVar.ePO = com.tencent.mm.bz.a.gd(context) / 4;
        aVar.ePN = com.tencent.mm.bz.a.gd(context) / 4;
        aVar.ePV = R.color.wm;
        this.elH = aVar.ahG();
        AppMethodBeat.o(74578);
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.i(74579);
        int i2 = vG(i).type;
        AppMethodBeat.o(74579);
        return i2;
    }

    public final v a(ViewGroup viewGroup, int i) {
        AppMethodBeat.i(74580);
        if (i == BaseClientBuilder.API_PRIORITY_OTHER) {
            a aVar = new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.y9, viewGroup, false));
            AppMethodBeat.o(74580);
            return aVar;
        }
        v dVar = new d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.y_, viewGroup, false));
        AppMethodBeat.o(74580);
        return dVar;
    }

    public final void a(v vVar, int i, List list) {
        AppMethodBeat.i(74581);
        if (list == null || list.size() <= 0 || !(vVar instanceof d)) {
            super.a(vVar, i, list);
            AppMethodBeat.o(74581);
        } else if (((Integer) list.get(0)).intValue() == 0) {
            ((d) vVar).moo.setChecked(false);
            ((d) vVar).moo.setVisibility(0);
            ((d) vVar).mop.setVisibility(0);
            AppMethodBeat.o(74581);
        } else {
            ((d) vVar).moo.setChecked(false);
            ((d) vVar).moo.setVisibility(8);
            ((d) vVar).mop.setVisibility(8);
            AppMethodBeat.o(74581);
        }
    }

    public final void a(final v vVar, int i) {
        AppMethodBeat.i(74582);
        if (this.kuU) {
            c vG = vG(i);
            if (vVar.apN != BaseClientBuilder.API_PRIORITY_OTHER) {
                ((d) vVar).mok.setTag(R.id.ax, Integer.valueOf(i));
                ((d) vVar).mop.setTag(Integer.valueOf(i));
                o.ahp().a(vG.imagePath, ((d) vVar).mok, this.elH);
                if (vG.mog) {
                    ((d) vVar).mol.setVisibility(0);
                    ((d) vVar).kuL.setVisibility(0);
                    ((d) vVar).kuL.setText(bo.bc(vG.moh.moi, ""));
                } else {
                    ((d) vVar).kuL.setVisibility(8);
                    ((d) vVar).mol.setVisibility(8);
                }
                ((d) vVar).mok.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
                    public final void onGlobalLayout() {
                        AppMethodBeat.i(74565);
                        ((d) vVar).mok.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        ((d) vVar).mom.setLayoutParams(new LayoutParams(((d) vVar).mok.getWidth(), ((d) vVar).mok.getHeight()));
                        AppMethodBeat.o(74565);
                    }
                });
                if (this.mod) {
                    int i2;
                    ((d) vVar).mop.setVisibility(0);
                    ((d) vVar).moo.setVisibility(0);
                    e bwv = a.moa;
                    d dVar = vG.mof;
                    if (dVar != null) {
                        Iterator it = bwv.mnX.iterator();
                        while (it.hasNext()) {
                            if (((d) it.next()).cAJ.mnd.equals(dVar.cAJ.mnd)) {
                                i2 = 1;
                                break;
                            }
                        }
                    }
                    i2 = 0;
                    if (i2 != 0) {
                        ((d) vVar).mom.setVisibility(0);
                        ((d) vVar).moo.setChecked(true);
                        AppMethodBeat.o(74582);
                        return;
                    }
                    ((d) vVar).mom.setVisibility(8);
                    ((d) vVar).moo.setChecked(false);
                    AppMethodBeat.o(74582);
                    return;
                }
                ((d) vVar).mom.setVisibility(8);
                ((d) vVar).mop.setVisibility(8);
                ((d) vVar).moo.setVisibility(8);
                AppMethodBeat.o(74582);
                return;
            } else if (i == getItemCount() - 1 || hb(vG(i + 1).timeStamp) != hb(vG.timeStamp)) {
                ((a) vVar).gnf.setVisibility(8);
                AppMethodBeat.o(74582);
                return;
            } else {
                ((a) vVar).gnf.setVisibility(0);
                ((a) vVar).gnf.setText(ha(vG.timeStamp));
                if (this.kuX) {
                    ((a) vVar).progressBar.setVisibility(0);
                    AppMethodBeat.o(74582);
                    return;
                }
                ((a) vVar).progressBar.setVisibility(8);
                AppMethodBeat.o(74582);
                return;
            }
        }
        ab.e("MicroMsg.MediaHistoryGalleryAdapter", "[onBindViewHolder] isSDCardAvailable:%s", Boolean.valueOf(this.kuU));
        AppMethodBeat.o(74582);
    }

    public final String ha(long j) {
        AppMethodBeat.i(74583);
        String a = com.tencent.mm.ui.gridviewheaders.a.dJg().a(new Date(j), this.mContext);
        AppMethodBeat.o(74583);
        return a;
    }

    private static long hb(long j) {
        AppMethodBeat.i(74584);
        long b = com.tencent.mm.ui.gridviewheaders.a.dJg().b(new Date(j));
        AppMethodBeat.o(74584);
        return b;
    }

    public final int getItemCount() {
        AppMethodBeat.i(74585);
        int size = this.iJL.size();
        AppMethodBeat.o(74585);
        return size;
    }

    public final c vG(int i) {
        AppMethodBeat.i(74586);
        c cVar = (c) this.iJL.get(i);
        AppMethodBeat.o(74586);
        return cVar;
    }
}

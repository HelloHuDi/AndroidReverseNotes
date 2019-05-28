package com.tencent.p177mm.plugin.fav.p410ui.gallery;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelvideo.C26494u;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.gridviewheaders.C15894a;
import com.tencent.p177mm.p612ui.widget.p1095b.C24088a;
import com.tencent.p177mm.platformtools.C45477q;
import com.tencent.p177mm.plugin.fav.p407a.C20679y;
import com.tencent.p177mm.plugin.fav.p407a.C27968h;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p410ui.gallery.C20743e.C20744a;
import com.tencent.p177mm.plugin.fav.p410ui.gallery.C45938g.C43080b;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.protocal.protobuf.abh;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import com.tencent.p177mm.vfs.C5728b;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fav.ui.gallery.f */
public final class C39072f extends C41523a {
    private C25814c elH = null;
    List<C39073c> iJL = null;
    private boolean kuU = true;
    boolean kuX;
    Context mContext;
    abh mnG = new abh();
    C43080b mob;
    C39068b moc;
    boolean mod = false;

    /* renamed from: com.tencent.mm.plugin.fav.ui.gallery.f$b */
    public interface C39068b {
        /* renamed from: a */
        void mo61980a(boolean z, C39073c c39073c, int i);
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.gallery.f$c */
    public static class C39073c {
        public String imagePath;
        public C20742d mof;
        boolean mog;
        public C39069a moh = new C39069a();
        public long timeStamp;
        public int type = 0;

        /* renamed from: com.tencent.mm.plugin.fav.ui.gallery.f$c$a */
        class C39069a {
            public String moi;

            C39069a() {
            }
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.m2504i(74567);
            boolean equals;
            if (this.mof == null || !(obj instanceof C20742d) || obj == null) {
                equals = super.equals(obj);
                AppMethodBeat.m2505o(74567);
                return equals;
            }
            equals = this.mof.cAJ.mnd.equals(((C20742d) obj).cAJ.mnd);
            AppMethodBeat.m2505o(74567);
            return equals;
        }

        public C39073c(C20742d c20742d) {
            String c;
            AppMethodBeat.m2504i(74568);
            this.mof = c20742d;
            if (c20742d.bws() || c20742d.bwt()) {
                c = C39037b.m66379c(c20742d.cAJ);
            } else {
                c = C39037b.m66370b(c20742d.cAJ);
                if (!new C5728b(c).exists()) {
                    c = C39037b.m66379c(c20742d.cAJ);
                }
            }
            this.imagePath = c;
            this.timeStamp = c20742d.mnW.field_updateTime;
            if (c20742d.bws() || c20742d.bwt()) {
                this.mog = true;
                this.moh.moi = C5046bo.m7577mK(c20742d.cAJ.duration);
            }
            AppMethodBeat.m2505o(74568);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.gallery.f$d */
    public class C39074d extends C41531v {
        TextView kuL;
        OnLongClickListener mlV = new C280304();
        ImageView mok;
        View mol;
        ImageView mom;
        View mon;
        CheckBox moo;
        View mop;

        /* renamed from: com.tencent.mm.plugin.fav.ui.gallery.f$d$4 */
        class C280304 implements OnLongClickListener {

            /* renamed from: com.tencent.mm.plugin.fav.ui.gallery.f$d$4$1 */
            class C280311 implements OnDismissListener {
                C280311() {
                }

                public final void onDismiss() {
                    AppMethodBeat.m2504i(74572);
                    if (!(C39074d.this.mom == null || C39072f.this.mod)) {
                        C39074d.this.mom.setVisibility(8);
                    }
                    AppMethodBeat.m2505o(74572);
                }
            }

            C280304() {
            }

            public final boolean onLongClick(View view) {
                AppMethodBeat.m2504i(74575);
                if (C39072f.this.mod) {
                    AppMethodBeat.m2505o(74575);
                    return false;
                }
                if (view.getTag(2131820679) instanceof int[]) {
                    int[] iArr = (int[]) view.getTag(2131820679);
                    m44587s(view, iArr[0], iArr[1]);
                } else {
                    m44587s(view, 0, 0);
                }
                AppMethodBeat.m2505o(74575);
                return true;
            }

            /* renamed from: s */
            private void m44587s(View view, int i, int i2) {
                AppMethodBeat.m2504i(74576);
                final int intValue = ((Integer) view.getTag(2131820604)).intValue();
                final C39073c vG = C39072f.this.mo61984vG(intValue);
                if (vG == null) {
                    AppMethodBeat.m2505o(74576);
                    return;
                }
                C24088a c24088a = new C24088a(C39072f.this.mContext);
                C39074d.this.mom.setVisibility(0);
                c24088a.zHM = new C280311();
                c24088a.mo39886a(view, new OnCreateContextMenuListener() {
                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                        AppMethodBeat.m2504i(74573);
                        String b = C39037b.m66370b(vG.mof.cAJ);
                        boolean ct = C1173e.m2561ct(b);
                        boolean amo = C5063r.amo(b);
                        if (!vG.mog && ct && !amo) {
                            contextMenu.add(0, 0, 0, C39072f.this.mContext.getString(C25738R.string.bri));
                            contextMenu.add(0, 1, 0, C39072f.this.mContext.getString(C25738R.string.bq_));
                            contextMenu.add(0, 2, 0, C39072f.this.mContext.getString(C25738R.string.brb));
                        } else if (vG.mog && ct && !amo) {
                            contextMenu.add(0, 0, 0, C39072f.this.mContext.getString(C25738R.string.bri));
                            contextMenu.add(0, 2, 0, C39072f.this.mContext.getString(C25738R.string.dx0));
                        } else {
                            C4990ab.m7411d("MicroMsg.MediaHistoryGalleryAdapter", "openPopupMenu, isVideo:%s, exist:%s, isGif:%s", Boolean.valueOf(vG.mog), Boolean.valueOf(ct), Boolean.valueOf(amo));
                        }
                        contextMenu.add(0, 4, 0, C39072f.this.mContext.getString(C25738R.string.bp6));
                        AppMethodBeat.m2505o(74573);
                    }
                }, new C5279d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.m2504i(74574);
                        String b = C39037b.m66370b(vG.mof.cAJ);
                        switch (menuItem.getItemId()) {
                            case 0:
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(vG.mof);
                                C39072f.this.mob.mo45948bS(arrayList);
                                AppMethodBeat.m2505o(74574);
                                return;
                            case 1:
                                C27968h.m44531j(vG.mof.mnW.field_localId, 0, 0);
                                C39037b.m66385d(b, C39072f.this.mContext);
                                AppMethodBeat.m2505o(74574);
                                return;
                            case 2:
                                if (C5046bo.isNullOrNil(b)) {
                                    C4990ab.m7420w("MicroMsg.MediaHistoryGalleryAdapter", "save image fail, path is null");
                                    AppMethodBeat.m2505o(74574);
                                    return;
                                } else if (vG.mog) {
                                    String uu = C26494u.m42269uu(b);
                                    C4990ab.m7417i("MicroMsg.MediaHistoryGalleryAdapter", "save video now video path %s out path %s", b, uu);
                                    if (C5046bo.isNullOrNil(uu)) {
                                        Toast.makeText(C39072f.this.mContext, C39072f.this.mContext.getString(C25738R.string.f1c), 1).show();
                                        AppMethodBeat.m2505o(74574);
                                        return;
                                    }
                                    Toast.makeText(C39072f.this.mContext, C39072f.this.mContext.getString(C25738R.string.f1d, new Object[]{uu}), 1).show();
                                    C14987n.m23300a(uu, C39072f.this.mContext);
                                    AppMethodBeat.m2505o(74574);
                                    return;
                                } else if (!C45477q.m83806a(b, C39072f.this.mContext, C25738R.string.b3r)) {
                                    Toast.makeText(C39072f.this.mContext, C39072f.this.mContext.getString(C25738R.string.bra), 1).show();
                                    AppMethodBeat.m2505o(74574);
                                    return;
                                }
                                break;
                            case 4:
                                C39072f.this.mnG.index = C39072f.this.getItemCount() - intValue;
                                ((C20679y) C1720g.m3528K(C20679y.class)).mo35978a(C39072f.this.mContext, vG.mof.mnW, C39072f.this.mnG);
                                break;
                        }
                        AppMethodBeat.m2505o(74574);
                    }
                }, i, i2);
                AppMethodBeat.m2505o(74576);
            }
        }

        public C39074d(View view) {
            super(view);
            AppMethodBeat.m2504i(74577);
            this.mok = (ImageView) view.findViewById(2131823900);
            this.mol = view.findViewById(2131823904);
            this.mon = view.findViewById(2131823906);
            this.kuL = (TextView) view.findViewById(2131822745);
            this.mom = (ImageView) view.findViewById(2131823908);
            this.moo = (CheckBox) view.findViewById(2131823909);
            this.mop = view.findViewById(2131823910);
            this.mop.setVisibility(8);
            this.moo.setVisibility(8);
            this.mol.setVisibility(8);
            this.kuL.setVisibility(8);
            this.mon.setVisibility(8);
            this.mok.setOnTouchListener(new OnTouchListener(C39072f.this) {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.m2504i(74569);
                    if (motionEvent.getAction() == 0) {
                        view.setTag(2131820679, new int[]{(int) motionEvent.getRawX(), (int) motionEvent.getRawY()});
                    }
                    AppMethodBeat.m2505o(74569);
                    return false;
                }
            });
            this.mok.setOnClickListener(new OnClickListener(C39072f.this) {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(74570);
                    C39073c vG = C39072f.this.mo61984vG(((Integer) view.getTag(2131820604)).intValue());
                    if (vG == null) {
                        AppMethodBeat.m2505o(74570);
                        return;
                    }
                    C39072f c39072f = C39072f.this;
                    Intent intent = new Intent();
                    if (vG == null) {
                        C4990ab.m7412e("MicroMsg.MediaHistoryGalleryAdapter", "[enterGallery] item == null");
                        AppMethodBeat.m2505o(74570);
                        return;
                    }
                    C20742d c20742d = vG.mof;
                    if (c20742d == null) {
                        C4990ab.m7412e("MicroMsg.MediaHistoryGalleryAdapter", "[enterGallery] msg == null");
                        AppMethodBeat.m2505o(74570);
                        return;
                    }
                    int i;
                    int i2 = 0;
                    ArrayList arrayList = new ArrayList();
                    Iterator it = c39072f.iJL.iterator();
                    while (true) {
                        i = i2;
                        if (!it.hasNext()) {
                            break;
                        }
                        long j = ((C39073c) it.next()).mof.mnW.field_localId;
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
                    intent.putExtra("KEY_MEDIA_FAVID_LIST", jArr).putExtra("key_detail_info_id", c20742d.mnW.field_localId).putExtra("key_detail_data_id", c20742d.cAJ.mnd);
                    intent.putExtra("key_detail_fav_scene", c39072f.mnG.scene);
                    intent.putExtra("key_detail_fav_sub_scene", c39072f.mnG.jSW);
                    intent.putExtra("key_detail_fav_index", 0);
                    intent.putExtra("key_detail_fav_query", c39072f.mnG.query);
                    intent.putExtra("key_detail_fav_sessionid", c39072f.mnG.cvF);
                    intent.putExtra("key_detail_fav_tags", c39072f.mnG.mfg);
                    C39037b.m66371b(c39072f.mContext, ".ui.gallery.FavMediaGalleryUI", intent);
                    ((Activity) c39072f.mContext).overridePendingTransition(0, 0);
                    AppMethodBeat.m2505o(74570);
                }
            });
            this.mok.setOnLongClickListener(this.mlV);
            this.mop.setOnClickListener(new OnClickListener(C39072f.this) {
                public final void onClick(View view) {
                    boolean z;
                    AppMethodBeat.m2504i(74571);
                    if (C39074d.this.moo.isChecked()) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (C20744a.moa.mnX.size() < 9) {
                        C39074d.this.moo.setChecked(z);
                        if (z) {
                            C39074d.this.mom.setVisibility(0);
                        } else {
                            C39074d.this.mom.setVisibility(8);
                        }
                    } else if (!z) {
                        C39074d.this.moo.setChecked(false);
                    }
                    if (C39072f.this.moc != null) {
                        int intValue = ((Integer) view.getTag()).intValue();
                        C39072f.this.moc.mo61980a(z, C39072f.this.mo61984vG(intValue), intValue);
                    }
                    AppMethodBeat.m2505o(74571);
                }
            });
            AppMethodBeat.m2505o(74577);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.gallery.f$a */
    public class C39076a extends C41531v {
        TextView gnf;
        ProgressBar progressBar;

        public C39076a(View view) {
            super(view);
            AppMethodBeat.m2504i(74566);
            this.gnf = (TextView) view.findViewById(2131823899);
            this.progressBar = (ProgressBar) view.findViewById(2131823898);
            AppMethodBeat.m2505o(74566);
        }
    }

    public C39072f(Context context, List<C39073c> list, C43080b c43080b) {
        AppMethodBeat.m2504i(74578);
        this.iJL = list;
        this.kuU = C1720g.m3536RP().isSDCardAvailable();
        this.mContext = context;
        this.mob = c43080b;
        C17927a c17927a = new C17927a();
        c17927a.fHe = 1;
        c17927a.eQa = true;
        c17927a.ePO = C1338a.m2868gd(context) / 4;
        c17927a.ePN = C1338a.m2868gd(context) / 4;
        c17927a.ePV = C25738R.color.f12221wm;
        this.elH = c17927a.ahG();
        AppMethodBeat.m2505o(74578);
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.m2504i(74579);
        int i2 = mo61984vG(i).type;
        AppMethodBeat.m2505o(74579);
        return i2;
    }

    /* renamed from: a */
    public final C41531v mo4976a(ViewGroup viewGroup, int i) {
        AppMethodBeat.m2504i(74580);
        if (i == BaseClientBuilder.API_PRIORITY_OTHER) {
            C39076a c39076a = new C39076a(LayoutInflater.from(viewGroup.getContext()).inflate(2130969501, viewGroup, false));
            AppMethodBeat.m2505o(74580);
            return c39076a;
        }
        C41531v c39074d = new C39074d(LayoutInflater.from(viewGroup.getContext()).inflate(2130969502, viewGroup, false));
        AppMethodBeat.m2505o(74580);
        return c39074d;
    }

    /* renamed from: a */
    public final void mo27742a(C41531v c41531v, int i, List list) {
        AppMethodBeat.m2504i(74581);
        if (list == null || list.size() <= 0 || !(c41531v instanceof C39074d)) {
            super.mo27742a(c41531v, i, list);
            AppMethodBeat.m2505o(74581);
        } else if (((Integer) list.get(0)).intValue() == 0) {
            ((C39074d) c41531v).moo.setChecked(false);
            ((C39074d) c41531v).moo.setVisibility(0);
            ((C39074d) c41531v).mop.setVisibility(0);
            AppMethodBeat.m2505o(74581);
        } else {
            ((C39074d) c41531v).moo.setChecked(false);
            ((C39074d) c41531v).moo.setVisibility(8);
            ((C39074d) c41531v).mop.setVisibility(8);
            AppMethodBeat.m2505o(74581);
        }
    }

    /* renamed from: a */
    public final void mo4977a(final C41531v c41531v, int i) {
        AppMethodBeat.m2504i(74582);
        if (this.kuU) {
            C39073c vG = mo61984vG(i);
            if (c41531v.apN != BaseClientBuilder.API_PRIORITY_OTHER) {
                ((C39074d) c41531v).mok.setTag(2131820604, Integer.valueOf(i));
                ((C39074d) c41531v).mop.setTag(Integer.valueOf(i));
                C32291o.ahp().mo43766a(vG.imagePath, ((C39074d) c41531v).mok, this.elH);
                if (vG.mog) {
                    ((C39074d) c41531v).mol.setVisibility(0);
                    ((C39074d) c41531v).kuL.setVisibility(0);
                    ((C39074d) c41531v).kuL.setText(C5046bo.m7532bc(vG.moh.moi, ""));
                } else {
                    ((C39074d) c41531v).kuL.setVisibility(8);
                    ((C39074d) c41531v).mol.setVisibility(8);
                }
                ((C39074d) c41531v).mok.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
                    public final void onGlobalLayout() {
                        AppMethodBeat.m2504i(74565);
                        ((C39074d) c41531v).mok.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        ((C39074d) c41531v).mom.setLayoutParams(new LayoutParams(((C39074d) c41531v).mok.getWidth(), ((C39074d) c41531v).mok.getHeight()));
                        AppMethodBeat.m2505o(74565);
                    }
                });
                if (this.mod) {
                    int i2;
                    ((C39074d) c41531v).mop.setVisibility(0);
                    ((C39074d) c41531v).moo.setVisibility(0);
                    C20743e bwv = C20744a.moa;
                    C20742d c20742d = vG.mof;
                    if (c20742d != null) {
                        Iterator it = bwv.mnX.iterator();
                        while (it.hasNext()) {
                            if (((C20742d) it.next()).cAJ.mnd.equals(c20742d.cAJ.mnd)) {
                                i2 = 1;
                                break;
                            }
                        }
                    }
                    i2 = 0;
                    if (i2 != 0) {
                        ((C39074d) c41531v).mom.setVisibility(0);
                        ((C39074d) c41531v).moo.setChecked(true);
                        AppMethodBeat.m2505o(74582);
                        return;
                    }
                    ((C39074d) c41531v).mom.setVisibility(8);
                    ((C39074d) c41531v).moo.setChecked(false);
                    AppMethodBeat.m2505o(74582);
                    return;
                }
                ((C39074d) c41531v).mom.setVisibility(8);
                ((C39074d) c41531v).mop.setVisibility(8);
                ((C39074d) c41531v).moo.setVisibility(8);
                AppMethodBeat.m2505o(74582);
                return;
            } else if (i == getItemCount() - 1 || C39072f.m66494hb(mo61984vG(i + 1).timeStamp) != C39072f.m66494hb(vG.timeStamp)) {
                ((C39076a) c41531v).gnf.setVisibility(8);
                AppMethodBeat.m2505o(74582);
                return;
            } else {
                ((C39076a) c41531v).gnf.setVisibility(0);
                ((C39076a) c41531v).gnf.setText(mo61983ha(vG.timeStamp));
                if (this.kuX) {
                    ((C39076a) c41531v).progressBar.setVisibility(0);
                    AppMethodBeat.m2505o(74582);
                    return;
                }
                ((C39076a) c41531v).progressBar.setVisibility(8);
                AppMethodBeat.m2505o(74582);
                return;
            }
        }
        C4990ab.m7413e("MicroMsg.MediaHistoryGalleryAdapter", "[onBindViewHolder] isSDCardAvailable:%s", Boolean.valueOf(this.kuU));
        AppMethodBeat.m2505o(74582);
    }

    /* renamed from: ha */
    public final String mo61983ha(long j) {
        AppMethodBeat.m2504i(74583);
        String a = C15894a.dJg().mo28137a(new Date(j), this.mContext);
        AppMethodBeat.m2505o(74583);
        return a;
    }

    /* renamed from: hb */
    private static long m66494hb(long j) {
        AppMethodBeat.m2504i(74584);
        long b = C15894a.dJg().mo28138b(new Date(j));
        AppMethodBeat.m2505o(74584);
        return b;
    }

    public final int getItemCount() {
        AppMethodBeat.m2504i(74585);
        int size = this.iJL.size();
        AppMethodBeat.m2505o(74585);
        return size;
    }

    /* renamed from: vG */
    public final C39073c mo61984vG(int i) {
        AppMethodBeat.m2504i(74586);
        C39073c c39073c = (C39073c) this.iJL.get(i);
        AppMethodBeat.m2505o(74586);
        return c39073c;
    }
}

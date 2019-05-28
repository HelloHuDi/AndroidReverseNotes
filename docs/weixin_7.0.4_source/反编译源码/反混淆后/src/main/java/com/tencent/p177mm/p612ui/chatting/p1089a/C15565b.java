package com.tencent.p177mm.p612ui.chatting.p1089a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvideo.C26493s;
import com.tencent.p177mm.modelvideo.C26494u;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C9720t;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.chatting.gallery.C15659h.C15660a;
import com.tencent.p177mm.p612ui.gridviewheaders.C15894a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C30065b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5730e;
import java.util.Date;
import java.util.List;

/* renamed from: com.tencent.mm.ui.chatting.a.b */
public final class C15565b extends C41523a {
    private C25814c elH = null;
    private String emo;
    public List<C15569c> iJL = null;
    private boolean kuU = true;
    public boolean kuX;
    Context mContext;
    boolean mgP = false;
    public boolean mod = false;
    long yNB;
    public C15564b yNC;

    /* renamed from: com.tencent.mm.ui.chatting.a.b$a */
    public class C15563a extends C41531v {
        TextView gnf;
        ProgressBar progressBar;

        public C15563a(View view) {
            super(view);
            AppMethodBeat.m2504i(31131);
            this.gnf = (TextView) view.findViewById(2131823899);
            this.progressBar = (ProgressBar) view.findViewById(2131823898);
            AppMethodBeat.m2505o(31131);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.a.b$b */
    public interface C15564b {
        /* renamed from: a */
        void mo27740a(boolean z, C15569c c15569c, int i);
    }

    /* renamed from: com.tencent.mm.ui.chatting.a.b$d */
    public class C15566d extends C41531v {
        TextView kuL;
        ImageView mok;
        View mol;
        ImageView mom;
        View mon;
        CheckBox moo;
        View mop;

        public C15566d(View view) {
            super(view);
            AppMethodBeat.m2504i(31137);
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
            this.mok.setOnClickListener(new OnClickListener(C15565b.this) {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(31135);
                    C15569c Ox = C15565b.this.mo27741Ox(((Integer) view.getTag()).intValue());
                    if (Ox == null) {
                        AppMethodBeat.m2505o(31135);
                        return;
                    }
                    C15565b c15565b = C15565b.this;
                    Intent intent = new Intent();
                    intent.putExtra("key_biz_chat_id", c15565b.yNB);
                    intent.putExtra("key_is_biz_chat", c15565b.mgP);
                    if (Ox == null) {
                        C4990ab.m7412e("MicroMsg.MediaHistoryGalleryAdapter", "[enterGallery] item == null");
                        AppMethodBeat.m2505o(31135);
                        return;
                    }
                    C7620bi c7620bi = Ox.cKd;
                    if (c7620bi == null) {
                        C4990ab.m7412e("MicroMsg.MediaHistoryGalleryAdapter", "[enterGallery] msg == null");
                        AppMethodBeat.m2505o(31135);
                        return;
                    }
                    int width;
                    int height;
                    int i = c15565b.mContext.getResources().getConfiguration().orientation;
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
                    intent.putExtra("img_gallery_msg_id", c7620bi.field_msgId).putExtra("img_gallery_msg_svr_id", c7620bi.field_msgSvrId).putExtra("img_gallery_talker", c7620bi.field_talker).putExtra("img_gallery_chatroom_name", c7620bi.field_talker).putExtra("img_gallery_orientation", i);
                    if (view != null) {
                        intent.putExtra("img_gallery_width", width).putExtra("img_gallery_height", height).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]).putExtra("img_gallery_enter_from_grid", true);
                    } else {
                        intent.putExtra("img_gallery_back_from_grid", true);
                    }
                    C25985d.m41473f(c15565b.mContext, "com.tencent.mm.ui.chatting.gallery.ImageGalleryUI", intent);
                    ((Activity) c15565b.mContext).overridePendingTransition(0, 0);
                    AppMethodBeat.m2505o(31135);
                }
            });
            this.mop.setOnClickListener(new OnClickListener(C15565b.this) {
                public final void onClick(View view) {
                    boolean z;
                    AppMethodBeat.m2504i(31136);
                    if (C15566d.this.moo.isChecked()) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (C15660a.yVE.mnX.size() < 9) {
                        C15566d.this.moo.setChecked(z);
                        if (z) {
                            C15566d.this.mom.setVisibility(0);
                        } else {
                            C15566d.this.mom.setVisibility(8);
                        }
                    } else if (!z) {
                        C15566d.this.moo.setChecked(false);
                    }
                    if (C15565b.this.yNC != null) {
                        int intValue = ((Integer) view.getTag()).intValue();
                        C15565b.this.yNC.mo27740a(z, C15565b.this.mo27741Ox(intValue), intValue);
                    }
                    AppMethodBeat.m2505o(31136);
                }
            });
            AppMethodBeat.m2505o(31137);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.a.b$c */
    public static class C15569c {
        public C7620bi cKd;
        public String imagePath;
        boolean mog;
        public long timeStamp;
        public int type = 0;
        public C15570a yNE = new C15570a();

        /* renamed from: com.tencent.mm.ui.chatting.a.b$c$a */
        class C15570a {
            public C8910b cJM;
            public String moi;

            C15570a() {
            }
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.m2504i(31132);
            if (this.cKd == null || !(obj instanceof C7620bi) || obj == null) {
                boolean equals = super.equals(obj);
                AppMethodBeat.m2505o(31132);
                return equals;
            } else if (this.cKd.field_msgId == ((C7620bi) obj).field_msgId) {
                AppMethodBeat.m2505o(31132);
                return true;
            } else {
                AppMethodBeat.m2505o(31132);
                return false;
            }
        }

        public C15569c(C7620bi c7620bi) {
            String ui;
            AppMethodBeat.m2504i(31133);
            this.cKd = c7620bi;
            if (c7620bi.bws() || c7620bi.bwt()) {
                this.mog = true;
                C37961o.all();
                ui = C9720t.m17304ui(c7620bi.field_imgPath);
                C26493s ut = C26494u.m42268ut(c7620bi.field_imgPath);
                if (ut != null) {
                    this.yNE.moi = C5046bo.m7577mK(ut.fXd);
                }
                this.yNE.cJM = C8910b.m16058X(c7620bi.field_content, c7620bi.field_reserved);
            } else {
                ui = C32291o.ahl().mo73108c(c7620bi.field_imgPath, false, false);
                if (!(C5046bo.isNullOrNil(ui) || ui.endsWith("hd") || !C5730e.m8628ct(ui + "hd"))) {
                    ui = ui + "hd";
                }
            }
            if (c7620bi.dtA()) {
                C8910b me = C8910b.m16064me(c7620bi.field_content);
                String str = null;
                if (!(me == null || me.csD == null || me.csD.length() <= 0)) {
                    C30065b aiE = C14877am.aUq().aiE(me.csD);
                    if (aiE != null) {
                        str = aiE.field_fileFullPath;
                    }
                }
                if (str != null) {
                    ui = str;
                }
            }
            this.imagePath = ui;
            this.timeStamp = c7620bi.field_createTime;
            AppMethodBeat.m2505o(31133);
        }

        public C15569c(long j) {
            AppMethodBeat.m2504i(31134);
            this.timeStamp = j;
            this.type = BaseClientBuilder.API_PRIORITY_OTHER;
            AppMethodBeat.m2505o(31134);
        }
    }

    public C15565b(Context context, List<C15569c> list, String str) {
        AppMethodBeat.m2504i(31138);
        this.iJL = list;
        this.emo = str;
        C9638aw.m17190ZK();
        this.kuU = C18628c.isSDCardAvailable();
        this.mContext = context;
        m23865hT(context);
        AppMethodBeat.m2505o(31138);
    }

    public C15565b(Context context, List<C15569c> list, String str, long j) {
        AppMethodBeat.m2504i(31139);
        this.iJL = list;
        this.yNB = j;
        this.emo = str;
        C9638aw.m17190ZK();
        this.kuU = C18628c.isSDCardAvailable();
        this.mgP = true;
        this.mContext = context;
        m23865hT(context);
        AppMethodBeat.m2505o(31139);
    }

    /* renamed from: hT */
    private void m23865hT(Context context) {
        AppMethodBeat.m2504i(31140);
        C17927a c17927a = new C17927a();
        c17927a.fHe = 1;
        c17927a.eQa = true;
        c17927a.ePO = C1338a.m2868gd(context) / 4;
        c17927a.ePN = C1338a.m2868gd(context) / 4;
        c17927a.ePV = C25738R.color.f12221wm;
        this.elH = c17927a.ahG();
        AppMethodBeat.m2505o(31140);
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.m2504i(31141);
        int i2 = mo27741Ox(i).type;
        AppMethodBeat.m2505o(31141);
        return i2;
    }

    /* renamed from: a */
    public final C41531v mo4976a(ViewGroup viewGroup, int i) {
        AppMethodBeat.m2504i(31142);
        if (i == BaseClientBuilder.API_PRIORITY_OTHER) {
            C15563a c15563a = new C15563a(LayoutInflater.from(viewGroup.getContext()).inflate(2130969647, viewGroup, false));
            AppMethodBeat.m2505o(31142);
            return c15563a;
        }
        C41531v c15566d = new C15566d(LayoutInflater.from(viewGroup.getContext()).inflate(2130969842, viewGroup, false));
        AppMethodBeat.m2505o(31142);
        return c15566d;
    }

    /* renamed from: a */
    public final void mo27742a(C41531v c41531v, int i, List list) {
        AppMethodBeat.m2504i(31143);
        if (list == null || list.size() <= 0 || !(c41531v instanceof C15566d)) {
            super.mo27742a(c41531v, i, list);
            AppMethodBeat.m2505o(31143);
        } else if (((Integer) list.get(0)).intValue() == 0) {
            ((C15566d) c41531v).moo.setChecked(false);
            ((C15566d) c41531v).moo.setVisibility(0);
            ((C15566d) c41531v).mop.setVisibility(0);
            AppMethodBeat.m2505o(31143);
        } else {
            ((C15566d) c41531v).moo.setChecked(false);
            ((C15566d) c41531v).moo.setVisibility(8);
            ((C15566d) c41531v).mop.setVisibility(8);
            AppMethodBeat.m2505o(31143);
        }
    }

    /* renamed from: a */
    public final void mo4977a(C41531v c41531v, int i) {
        AppMethodBeat.m2504i(31144);
        if (this.kuU) {
            C15569c Ox = mo27741Ox(i);
            if (c41531v.apN != BaseClientBuilder.API_PRIORITY_OTHER) {
                ((C15566d) c41531v).mok.setTag(Integer.valueOf(i));
                ((C15566d) c41531v).mop.setTag(Integer.valueOf(i));
                C32291o.ahp().mo43766a(Ox.imagePath, ((C15566d) c41531v).mok, this.elH);
                if (Ox.mog) {
                    ((C15566d) c41531v).mol.setVisibility(0);
                    ((C15566d) c41531v).kuL.setVisibility(0);
                    ((C15566d) c41531v).kuL.setText(C5046bo.m7532bc(Ox.yNE.moi, ""));
                } else {
                    ((C15566d) c41531v).kuL.setVisibility(8);
                    ((C15566d) c41531v).mol.setVisibility(8);
                }
                if (this.mod) {
                    ((C15566d) c41531v).mop.setVisibility(0);
                    ((C15566d) c41531v).moo.setVisibility(0);
                    if (C15660a.yVE.mo27889bE(Ox.cKd)) {
                        ((C15566d) c41531v).mom.setVisibility(0);
                        ((C15566d) c41531v).moo.setChecked(true);
                        AppMethodBeat.m2505o(31144);
                        return;
                    }
                    ((C15566d) c41531v).mom.setVisibility(8);
                    ((C15566d) c41531v).moo.setChecked(false);
                    AppMethodBeat.m2505o(31144);
                    return;
                }
                ((C15566d) c41531v).mop.setVisibility(8);
                ((C15566d) c41531v).moo.setVisibility(8);
                AppMethodBeat.m2505o(31144);
                return;
            } else if (i == getItemCount() - 1 || C15565b.m23866hb(mo27741Ox(i + 1).timeStamp) != C15565b.m23866hb(Ox.timeStamp)) {
                ((C15563a) c41531v).gnf.setVisibility(8);
                AppMethodBeat.m2505o(31144);
                return;
            } else {
                ((C15563a) c41531v).gnf.setVisibility(0);
                ((C15563a) c41531v).gnf.setText(mo27743ha(Ox.timeStamp));
                if (this.kuX) {
                    ((C15563a) c41531v).progressBar.setVisibility(0);
                    AppMethodBeat.m2505o(31144);
                    return;
                }
                ((C15563a) c41531v).progressBar.setVisibility(8);
                AppMethodBeat.m2505o(31144);
                return;
            }
        }
        C4990ab.m7413e("MicroMsg.MediaHistoryGalleryAdapter", "[onBindViewHolder] isSDCardAvailable:%s", Boolean.valueOf(this.kuU));
        AppMethodBeat.m2505o(31144);
    }

    /* renamed from: ha */
    public final String mo27743ha(long j) {
        AppMethodBeat.m2504i(31145);
        String a = C15894a.dJg().mo28137a(new Date(j), this.mContext);
        AppMethodBeat.m2505o(31145);
        return a;
    }

    /* renamed from: hb */
    private static long m23866hb(long j) {
        AppMethodBeat.m2504i(31146);
        long b = C15894a.dJg().mo28138b(new Date(j));
        AppMethodBeat.m2505o(31146);
        return b;
    }

    public final int getItemCount() {
        AppMethodBeat.m2504i(31147);
        int size = this.iJL.size();
        AppMethodBeat.m2505o(31147);
        return size;
    }

    /* renamed from: Ox */
    public final C15569c mo27741Ox(int i) {
        AppMethodBeat.m2504i(31148);
        C15569c c15569c = (C15569c) this.iJL.get(i);
        AppMethodBeat.m2505o(31148);
        return c15569c;
    }
}

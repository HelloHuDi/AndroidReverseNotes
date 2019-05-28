package com.tencent.p177mm.p612ui.chatting.gallery;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvideo.C26493s;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C9720t;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p193c.C1282i;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.p612ui.chatting.gallery.C15659h.C15660a;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C30065b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5730e;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.ui.chatting.gallery.d */
public final class C46938d extends C46692p<C7620bi> implements OnClickListener {
    private static Map<String, Integer> mid;
    private static Map<String, Integer> yUu;
    protected C25814c elH = null;
    String emo;
    private boolean kuU;
    Context mContext;
    private LayoutInflater mInflater;
    boolean mgP;
    public boolean pZZ = false;
    long yNB;
    private final ImageGalleryGridUI yUs;
    boolean yUt = false;

    /* renamed from: com.tencent.mm.ui.chatting.gallery.d$1 */
    class C361731 implements C1282i {

        /* renamed from: com.tencent.mm.ui.chatting.gallery.d$1$1 */
        class C156531 implements Runnable {
            C156531() {
            }

            public final void run() {
            }
        }

        C361731() {
        }

        /* renamed from: a */
        public final void mo4581a(String str, View view, Bitmap bitmap, Object... objArr) {
            AppMethodBeat.m2504i(32021);
            C5004al.m7441d(new C156531());
            AppMethodBeat.m2505o(32021);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.d$a */
    protected static class C44307a {
        public TextView kuL;
        public ImageView mok;
        public View mol;
        public ImageView mom;
        public View mon;
        public CheckBox moo;
        public View mop;
        public ImageView yUx;
        public TextView yUy;
        public View yUz;

        protected C44307a() {
        }
    }

    public C46938d(Context context, C7620bi c7620bi, String str) {
        super(context, c7620bi);
        AppMethodBeat.m2504i(32022);
        this.yUs = (ImageGalleryGridUI) context;
        this.emo = str;
        this.mgP = C17903f.m28103kq(this.emo);
        if (this.mgP) {
            this.yNB = c7620bi.field_bizChatId;
        }
        C9638aw.m17190ZK();
        this.kuU = C18628c.isSDCardAvailable();
        this.mInflater = LayoutInflater.from(context);
        C17927a c17927a = new C17927a();
        c17927a.fHe = 1;
        c17927a.eQa = true;
        c17927a.ePO = C1338a.m2868gd(context) / 3;
        c17927a.ePN = C1338a.m2868gd(context) / 3;
        c17927a.ePV = C25738R.color.f12221wm;
        this.elH = c17927a.ahG();
        AppMethodBeat.m2505o(32022);
    }

    public final boolean areAllItemsEnabled() {
        return false;
    }

    /* renamed from: KC */
    public final void mo6869KC() {
        AppMethodBeat.m2504i(32023);
        if (this.mgP) {
            C9638aw.m17190ZK();
            setCursor(C18628c.m29081XP().mo74793aN(this.emo, this.yNB));
            AppMethodBeat.m2505o(32023);
            return;
        }
        C9638aw.m17190ZK();
        setCursor(C18628c.m29080XO().mo15252Rf(this.emo));
        AppMethodBeat.m2505o(32023);
    }

    /* renamed from: KD */
    public final void mo6870KD() {
        AppMethodBeat.m2504i(32024);
        if (this.mgP) {
            C9638aw.m17190ZK();
            setCursor(C18628c.m29081XP().mo74793aN(this.emo, this.yNB));
            AppMethodBeat.m2505o(32024);
            return;
        }
        C9638aw.m17190ZK();
        setCursor(C18628c.m29080XO().mo15252Rf(this.emo));
        AppMethodBeat.m2505o(32024);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C44307a c44307a;
        AppMethodBeat.m2504i(32025);
        if (view == null) {
            view = this.mInflater.inflate(2130969842, viewGroup, false);
            c44307a = new C44307a();
            c44307a.mok = (ImageView) view.findViewById(2131823900);
            c44307a.mol = view.findViewById(2131823904);
            c44307a.yUy = (TextView) view.findViewById(2131823901);
            c44307a.yUy.setVisibility(8);
            c44307a.yUx = (ImageView) view.findViewById(2131823903);
            c44307a.kuL = (TextView) view.findViewById(2131822745);
            c44307a.mol.setVisibility(8);
            c44307a.mon = view.findViewById(2131823906);
            c44307a.mon.setVisibility(8);
            c44307a.yUz = view.findViewById(2131823902);
            c44307a.yUz.setVisibility(8);
            c44307a.mom = (ImageView) view.findViewById(2131823908);
            c44307a.moo = (CheckBox) view.findViewById(2131823909);
            c44307a.mop = view.findViewById(2131823910);
            view.setTag(c44307a);
        } else {
            c44307a = (C44307a) view.getTag();
        }
        c44307a.mon.setVisibility(8);
        c44307a.mol.setVisibility(8);
        c44307a.yUz.setVisibility(8);
        c44307a.yUy.setVisibility(8);
        C7620bi c7620bi = (C7620bi) getItem(i);
        if (c7620bi == null) {
            AppMethodBeat.m2505o(32025);
        } else {
            if (!this.kuU) {
                c44307a.mok.setImageResource(C25738R.drawable.ak_);
            } else if (this.yUs instanceof ImageGalleryGridUI) {
                String str = c7620bi.field_content;
                C8910b c8910b = null;
                if (str != null) {
                    c8910b = C8910b.m16058X(str, c7620bi.field_reserved);
                }
                if (this.yUs.yUA == i) {
                    c44307a.mom.setVisibility(0);
                    if (!C40775c.m70566bq(c7620bi) || c8910b == null || c8910b.type == 3) {
                        if (c8910b != null && c8910b.type == 3) {
                            c44307a.yUx.setImageDrawable(this.yUs.getResources().getDrawable(C46938d.m89682f(c8910b)));
                        }
                        C32291o.ahp().mo43768a(C46938d.m89681bx(c7620bi), c44307a.mok, this.elH, new C361731());
                    } else {
                        c44307a.yUx.setImageDrawable(this.yUs.getResources().getDrawable(C46938d.m89682f(c8910b)));
                        c44307a.mok.setImageResource(C46938d.m89683g(c8910b));
                    }
                } else {
                    c44307a.mom.setVisibility(0);
                    c44307a.mom.setBackgroundResource(C25738R.color.f12100sb);
                    if (!C40775c.m70566bq(c7620bi) || c8910b == null || c8910b.type == 3) {
                        if (c8910b != null && c8910b.type == 3) {
                            c44307a.yUx.setImageDrawable(this.yUs.getResources().getDrawable(C46938d.m89682f(c8910b)));
                        }
                        C32291o.ahp().mo43766a(C46938d.m89681bx(c7620bi), c44307a.mok, this.elH);
                    } else {
                        c44307a.yUx.setImageDrawable(this.yUs.getResources().getDrawable(C46938d.m89682f(c8910b)));
                        c44307a.mok.setImageResource(C46938d.m89683g(c8910b));
                    }
                }
                c44307a.mok.setPadding(0, 0, 0, 0);
                int measuredWidth = c44307a.mok.getMeasuredWidth();
                int measuredHeight = c44307a.mok.getMeasuredHeight();
                if (measuredWidth > 0 && measuredHeight > 0) {
                    LayoutParams layoutParams = c44307a.mom.getLayoutParams();
                    layoutParams.width = measuredWidth;
                    layoutParams.height = measuredHeight;
                    c44307a.mom.setLayoutParams(layoutParams);
                }
                if (C40775c.m70574f(c7620bi)) {
                    if (c44307a != null) {
                        c44307a.mol.setVisibility(0);
                        C26493s bG = C15663j.m23963bG(c7620bi);
                        if (bG != null) {
                            c44307a.kuL.setText(C42252ah.m74629mK(bG.fXd));
                        }
                    }
                } else if (C40775c.m70565bp(c7620bi)) {
                    c44307a.mon.setVisibility(0);
                } else if (C40775c.m70566bq(c7620bi) && c44307a != null) {
                    c44307a.yUz.setVisibility(0);
                    c44307a.yUy.setVisibility(0);
                    if (c8910b != null) {
                        C4990ab.m7417i("MicroMsg.ImageGalleryGridAdapter", "initFileName--->content:%s", C42252ah.nullAsNil(c8910b.title));
                        if (c8910b.type != 24) {
                            c44307a.yUy.setText(C44089j.m79293b(this.mContext, C42252ah.nullAsNil(c8910b.title), c44307a.yUy.getTextSize()));
                        } else {
                            c44307a.yUy.setText(C44089j.m79293b(c44307a.yUy.getContext(), c44307a.yUy.getContext().getString(C25738R.string.bsc), c44307a.yUy.getTextSize()));
                        }
                    }
                }
            } else {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("the context should be ImageGalleryGridUI");
                AppMethodBeat.m2505o(32025);
                throw illegalArgumentException;
            }
            c44307a.moo.setChecked(C15660a.yVE.mo27889bE(c7620bi));
            c44307a.moo.setTag(c7620bi);
            c44307a.mop.setTag(c44307a);
            c44307a.mop.setOnClickListener(this);
            if (C15660a.yVE.mnY) {
                c44307a.moo.setVisibility(0);
                c44307a.mop.setVisibility(0);
                c44307a.mom.setVisibility(0);
            } else {
                c44307a.moo.setVisibility(8);
                c44307a.mop.setVisibility(8);
                c44307a.mom.setVisibility(8);
            }
            AppMethodBeat.m2505o(32025);
        }
        return view;
    }

    /* renamed from: f */
    private static int m89682f(C8910b c8910b) {
        AppMethodBeat.m2504i(32026);
        if (c8910b == null) {
            C4990ab.m7416i("MicroMsg.ImageGalleryGridAdapter", "getIconId:2131230813");
            AppMethodBeat.m2505o(32026);
            return C1318a.app_attach_file_icon_unknow_in_gird;
        } else if (c8910b.type == 5 || c8910b.type == 7 || c8910b.type == 15) {
            AppMethodBeat.m2505o(32026);
            return C1318a.app_attach_file_icon_url_in_gird;
        } else if (c8910b.type == 3) {
            AppMethodBeat.m2505o(32026);
            return C1318a.app_attach_file_icon_music_in_gird;
        } else if (c8910b.type == 6 && mid.containsKey(C42252ah.nullAsNil(c8910b.fgp))) {
            C4990ab.m7416i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + mid.get(C42252ah.nullAsNil(c8910b.fgp)));
            int intValue = ((Integer) mid.get(C42252ah.nullAsNil(c8910b.fgp))).intValue();
            AppMethodBeat.m2505o(32026);
            return intValue;
        } else {
            AppMethodBeat.m2505o(32026);
            return C1318a.app_attach_file_icon_unknow_in_gird;
        }
    }

    /* renamed from: g */
    private static int m89683g(C8910b c8910b) {
        AppMethodBeat.m2504i(32027);
        if (c8910b == null) {
            C4990ab.m7416i("MicroMsg.ImageGalleryGridAdapter", "getIconId:2131689673");
            AppMethodBeat.m2505o(32027);
            return C25738R.color.f11724eq;
        } else if (c8910b.type == 5 || c8910b.type == 7 || c8910b.type == 15) {
            AppMethodBeat.m2505o(32027);
            return C25738R.color.f11725er;
        } else if (c8910b.type == 6 && yUu.containsKey(C42252ah.nullAsNil(c8910b.fgp))) {
            C4990ab.m7416i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + yUu.get(C42252ah.nullAsNil(c8910b.fgp)));
            int intValue = ((Integer) yUu.get(C42252ah.nullAsNil(c8910b.fgp))).intValue();
            AppMethodBeat.m2505o(32027);
            return intValue;
        } else {
            AppMethodBeat.m2505o(32027);
            return C25738R.color.f11724eq;
        }
    }

    /* renamed from: bx */
    private static String m89681bx(C7620bi c7620bi) {
        String ui;
        AppMethodBeat.m2504i(32028);
        if (c7620bi.bws() || c7620bi.bwt()) {
            C37961o.all();
            ui = C9720t.m17304ui(c7620bi.field_imgPath);
        } else {
            ui = C32291o.ahl().mo73108c(c7620bi.field_imgPath, false, false);
            if (!(C42252ah.isNullOrNil(ui) || ui.endsWith("hd") || !C5730e.m8628ct(ui + "hd"))) {
                ui = ui + "hd";
            }
        }
        C4990ab.m7417i("MicroMsg.ImageGalleryGridAdapter", "MsgInfoForMonetUri imgPath : %s", ui);
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
        AppMethodBeat.m2505o(32028);
        return ui;
    }

    public final void bwq() {
        AppMethodBeat.m2504i(32029);
        this.pZZ = false;
        notifyDataSetChanged();
        AppMethodBeat.m2505o(32029);
    }

    public final void notifyDataSetChanged() {
        AppMethodBeat.m2504i(32030);
        super.notifyDataSetChanged();
        this.yUt = false;
        AppMethodBeat.m2505o(32030);
    }

    public final void onClick(View view) {
        AppMethodBeat.m2504i(32031);
        C44307a c44307a = (C44307a) view.getTag();
        if (c44307a.moo == null) {
            AppMethodBeat.m2505o(32031);
            return;
        }
        C7620bi c7620bi = (C7620bi) c44307a.moo.getTag();
        if (c7620bi == null) {
            AppMethodBeat.m2505o(32031);
            return;
        }
        C15659h dFX = C15660a.yVE;
        if (dFX.mo27889bE(c7620bi)) {
            dFX.mo27888bD(c7620bi);
        } else {
            dFX.mo27887bC(c7620bi);
        }
        if (C15660a.yVE.mo27889bE(c7620bi)) {
            c44307a.moo.setChecked(true);
            c44307a.mom.setBackgroundResource(C25738R.color.f12084rr);
        } else {
            c44307a.moo.setChecked(false);
            c44307a.mom.setBackgroundResource(C25738R.color.f12100sb);
        }
        if (!this.pZZ && C15660a.yVE.mnX.size() > 1) {
            C7060h.pYm.mo8378a(219, 20, 1, true);
            this.pZZ = true;
        }
        AppMethodBeat.m2505o(32031);
    }

    static {
        AppMethodBeat.m2504i(32033);
        HashMap hashMap = new HashMap();
        mid = hashMap;
        hashMap.put("avi", Integer.valueOf(C1318a.app_attach_file_icon_video_in_gird));
        mid.put("m4v", Integer.valueOf(C1318a.app_attach_file_icon_video_in_gird));
        mid.put("vob", Integer.valueOf(C1318a.app_attach_file_icon_video_in_gird));
        mid.put("mpeg", Integer.valueOf(C1318a.app_attach_file_icon_video_in_gird));
        mid.put("mpe", Integer.valueOf(C1318a.app_attach_file_icon_video_in_gird));
        mid.put("asx", Integer.valueOf(C1318a.app_attach_file_icon_video_in_gird));
        mid.put("asf", Integer.valueOf(C1318a.app_attach_file_icon_video_in_gird));
        mid.put("f4v", Integer.valueOf(C1318a.app_attach_file_icon_video_in_gird));
        mid.put("flv", Integer.valueOf(C1318a.app_attach_file_icon_video_in_gird));
        mid.put("mkv", Integer.valueOf(C1318a.app_attach_file_icon_video_in_gird));
        mid.put("wmv", Integer.valueOf(C1318a.app_attach_file_icon_video_in_gird));
        mid.put("wm", Integer.valueOf(C1318a.app_attach_file_icon_video_in_gird));
        mid.put("3gp", Integer.valueOf(C1318a.app_attach_file_icon_video_in_gird));
        mid.put("mp4", Integer.valueOf(C1318a.app_attach_file_icon_video_in_gird));
        mid.put("rmvb", Integer.valueOf(C1318a.app_attach_file_icon_video_in_gird));
        mid.put("rm", Integer.valueOf(C1318a.app_attach_file_icon_video_in_gird));
        mid.put("ra", Integer.valueOf(C1318a.app_attach_file_icon_video_in_gird));
        mid.put("ram", Integer.valueOf(C1318a.app_attach_file_icon_video_in_gird));
        mid.put("mp3pro", Integer.valueOf(C1318a.app_attach_file_icon_music_in_gird));
        mid.put("vqf", Integer.valueOf(C1318a.app_attach_file_icon_music_in_gird));
        mid.put("cd", Integer.valueOf(C1318a.app_attach_file_icon_music_in_gird));
        mid.put("md", Integer.valueOf(C1318a.app_attach_file_icon_music_in_gird));
        mid.put("mod", Integer.valueOf(C1318a.app_attach_file_icon_music_in_gird));
        mid.put("vorbis", Integer.valueOf(C1318a.app_attach_file_icon_music_in_gird));
        mid.put("au", Integer.valueOf(C1318a.app_attach_file_icon_music_in_gird));
        mid.put("amr", Integer.valueOf(C1318a.app_attach_file_icon_music_in_gird));
        mid.put("silk", Integer.valueOf(C1318a.app_attach_file_icon_music_in_gird));
        mid.put("wma", Integer.valueOf(C1318a.app_attach_file_icon_music_in_gird));
        mid.put("mmf", Integer.valueOf(C1318a.app_attach_file_icon_music_in_gird));
        mid.put("mid", Integer.valueOf(C1318a.app_attach_file_icon_music_in_gird));
        mid.put("midi", Integer.valueOf(C1318a.app_attach_file_icon_music_in_gird));
        mid.put("mp3", Integer.valueOf(C1318a.app_attach_file_icon_music_in_gird));
        mid.put("aac", Integer.valueOf(C1318a.app_attach_file_icon_music_in_gird));
        mid.put("ape", Integer.valueOf(C1318a.app_attach_file_icon_music_in_gird));
        mid.put("aiff", Integer.valueOf(C1318a.app_attach_file_icon_music_in_gird));
        mid.put("aif", Integer.valueOf(C1318a.app_attach_file_icon_music_in_gird));
        mid.put("doc", Integer.valueOf(C1318a.app_attach_file_icon_word_in_gird));
        mid.put("docx", Integer.valueOf(C1318a.app_attach_file_icon_word_in_gird));
        mid.put("ppt", Integer.valueOf(C1318a.app_attach_file_icon_ppt_in_gird));
        mid.put("pptx", Integer.valueOf(C1318a.app_attach_file_icon_ppt_in_gird));
        mid.put("xls", Integer.valueOf(C1318a.app_attach_file_icon_excel_in_gird));
        mid.put("xlsx", Integer.valueOf(C1318a.app_attach_file_icon_excel_in_gird));
        mid.put("pdf", Integer.valueOf(C1318a.app_attach_file_icon_pdf_in_gird));
        mid.put("unknown", Integer.valueOf(C1318a.app_attach_file_icon_unknow_in_gird));
        hashMap = new HashMap();
        yUu = hashMap;
        hashMap.put("doc", Integer.valueOf(C25738R.color.f11720em));
        yUu.put("docx", Integer.valueOf(C25738R.color.f11720em));
        yUu.put("ppt", Integer.valueOf(C25738R.color.f11723ep));
        yUu.put("pptx", Integer.valueOf(C25738R.color.f11723ep));
        yUu.put("xls", Integer.valueOf(C25738R.color.f11726es));
        yUu.put("xlsx", Integer.valueOf(C25738R.color.f11726es));
        yUu.put("pdf", Integer.valueOf(C25738R.color.f11722eo));
        yUu.put("unknown", Integer.valueOf(C25738R.color.f11724eq));
        yUu.put("mp3pro", Integer.valueOf(C25738R.color.f11721en));
        yUu.put("vqf", Integer.valueOf(C25738R.color.f11721en));
        yUu.put("cd", Integer.valueOf(C25738R.color.f11721en));
        yUu.put("md", Integer.valueOf(C25738R.color.f11721en));
        yUu.put("mod", Integer.valueOf(C25738R.color.f11721en));
        yUu.put("vorbis", Integer.valueOf(C25738R.color.f11721en));
        yUu.put("au", Integer.valueOf(C25738R.color.f11721en));
        yUu.put("amr", Integer.valueOf(C25738R.color.f11721en));
        yUu.put("silk", Integer.valueOf(C25738R.color.f11721en));
        yUu.put("wma", Integer.valueOf(C25738R.color.f11721en));
        yUu.put("mmf", Integer.valueOf(C25738R.color.f11721en));
        yUu.put("mid", Integer.valueOf(C25738R.color.f11721en));
        yUu.put("midi", Integer.valueOf(C25738R.color.f11721en));
        yUu.put("mp3", Integer.valueOf(C25738R.color.f11721en));
        yUu.put("aac", Integer.valueOf(C25738R.color.f11721en));
        yUu.put("ape", Integer.valueOf(C25738R.color.f11721en));
        yUu.put("aiff", Integer.valueOf(C25738R.color.f11721en));
        yUu.put("aif", Integer.valueOf(C25738R.color.f11721en));
        AppMethodBeat.m2505o(32033);
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo7687a(Object obj, Cursor cursor) {
        AppMethodBeat.m2504i(32032);
        C7620bi c7620bi = new C7620bi();
        c7620bi.mo8995d(cursor);
        AppMethodBeat.m2505o(32032);
        return c7620bi;
    }
}

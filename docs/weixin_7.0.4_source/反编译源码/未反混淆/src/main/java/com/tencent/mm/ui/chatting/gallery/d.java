package com.tencent.mm.ui.chatting.gallery;

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
import com.tencent.mm.R;
import com.tencent.mm.af.j.b;
import com.tencent.mm.aj.f;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.c.i;
import com.tencent.mm.at.o;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.p;
import com.tencent.mm.vfs.e;
import java.util.HashMap;
import java.util.Map;

public final class d extends p<bi> implements OnClickListener {
    private static Map<String, Integer> mid;
    private static Map<String, Integer> yUu;
    protected c elH = null;
    String emo;
    private boolean kuU;
    Context mContext;
    private LayoutInflater mInflater;
    boolean mgP;
    public boolean pZZ = false;
    long yNB;
    private final ImageGalleryGridUI yUs;
    boolean yUt = false;

    protected static class a {
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

        protected a() {
        }
    }

    public d(Context context, bi biVar, String str) {
        super(context, biVar);
        AppMethodBeat.i(32022);
        this.yUs = (ImageGalleryGridUI) context;
        this.emo = str;
        this.mgP = f.kq(this.emo);
        if (this.mgP) {
            this.yNB = biVar.field_bizChatId;
        }
        aw.ZK();
        this.kuU = com.tencent.mm.model.c.isSDCardAvailable();
        this.mInflater = LayoutInflater.from(context);
        com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
        aVar.fHe = 1;
        aVar.eQa = true;
        aVar.ePO = com.tencent.mm.bz.a.gd(context) / 3;
        aVar.ePN = com.tencent.mm.bz.a.gd(context) / 3;
        aVar.ePV = R.color.wm;
        this.elH = aVar.ahG();
        AppMethodBeat.o(32022);
    }

    public final boolean areAllItemsEnabled() {
        return false;
    }

    public final void KC() {
        AppMethodBeat.i(32023);
        if (this.mgP) {
            aw.ZK();
            setCursor(com.tencent.mm.model.c.XP().aN(this.emo, this.yNB));
            AppMethodBeat.o(32023);
            return;
        }
        aw.ZK();
        setCursor(com.tencent.mm.model.c.XO().Rf(this.emo));
        AppMethodBeat.o(32023);
    }

    public final void KD() {
        AppMethodBeat.i(32024);
        if (this.mgP) {
            aw.ZK();
            setCursor(com.tencent.mm.model.c.XP().aN(this.emo, this.yNB));
            AppMethodBeat.o(32024);
            return;
        }
        aw.ZK();
        setCursor(com.tencent.mm.model.c.XO().Rf(this.emo));
        AppMethodBeat.o(32024);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        AppMethodBeat.i(32025);
        if (view == null) {
            view = this.mInflater.inflate(R.layout.a7e, viewGroup, false);
            aVar = new a();
            aVar.mok = (ImageView) view.findViewById(R.id.bpp);
            aVar.mol = view.findViewById(R.id.bpt);
            aVar.yUy = (TextView) view.findViewById(R.id.bpq);
            aVar.yUy.setVisibility(8);
            aVar.yUx = (ImageView) view.findViewById(R.id.bps);
            aVar.kuL = (TextView) view.findViewById(R.id.avh);
            aVar.mol.setVisibility(8);
            aVar.mon = view.findViewById(R.id.bpv);
            aVar.mon.setVisibility(8);
            aVar.yUz = view.findViewById(R.id.bpr);
            aVar.yUz.setVisibility(8);
            aVar.mom = (ImageView) view.findViewById(R.id.bpx);
            aVar.moo = (CheckBox) view.findViewById(R.id.bpy);
            aVar.mop = view.findViewById(R.id.bpz);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.mon.setVisibility(8);
        aVar.mol.setVisibility(8);
        aVar.yUz.setVisibility(8);
        aVar.yUy.setVisibility(8);
        bi biVar = (bi) getItem(i);
        if (biVar == null) {
            AppMethodBeat.o(32025);
        } else {
            if (!this.kuU) {
                aVar.mok.setImageResource(R.drawable.ak_);
            } else if (this.yUs instanceof ImageGalleryGridUI) {
                String str = biVar.field_content;
                b bVar = null;
                if (str != null) {
                    bVar = b.X(str, biVar.field_reserved);
                }
                if (this.yUs.yUA == i) {
                    aVar.mom.setVisibility(0);
                    if (!c.bq(biVar) || bVar == null || bVar.type == 3) {
                        if (bVar != null && bVar.type == 3) {
                            aVar.yUx.setImageDrawable(this.yUs.getResources().getDrawable(f(bVar)));
                        }
                        o.ahp().a(bx(biVar), aVar.mok, this.elH, new i() {
                            public final void a(String str, View view, Bitmap bitmap, Object... objArr) {
                                AppMethodBeat.i(32021);
                                al.d(new Runnable() {
                                    public final void run() {
                                    }
                                });
                                AppMethodBeat.o(32021);
                            }
                        });
                    } else {
                        aVar.yUx.setImageDrawable(this.yUs.getResources().getDrawable(f(bVar)));
                        aVar.mok.setImageResource(g(bVar));
                    }
                } else {
                    aVar.mom.setVisibility(0);
                    aVar.mom.setBackgroundResource(R.color.sb);
                    if (!c.bq(biVar) || bVar == null || bVar.type == 3) {
                        if (bVar != null && bVar.type == 3) {
                            aVar.yUx.setImageDrawable(this.yUs.getResources().getDrawable(f(bVar)));
                        }
                        o.ahp().a(bx(biVar), aVar.mok, this.elH);
                    } else {
                        aVar.yUx.setImageDrawable(this.yUs.getResources().getDrawable(f(bVar)));
                        aVar.mok.setImageResource(g(bVar));
                    }
                }
                aVar.mok.setPadding(0, 0, 0, 0);
                int measuredWidth = aVar.mok.getMeasuredWidth();
                int measuredHeight = aVar.mok.getMeasuredHeight();
                if (measuredWidth > 0 && measuredHeight > 0) {
                    LayoutParams layoutParams = aVar.mom.getLayoutParams();
                    layoutParams.width = measuredWidth;
                    layoutParams.height = measuredHeight;
                    aVar.mom.setLayoutParams(layoutParams);
                }
                if (c.f(biVar)) {
                    if (aVar != null) {
                        aVar.mol.setVisibility(0);
                        s bG = j.bG(biVar);
                        if (bG != null) {
                            aVar.kuL.setText(ah.mK(bG.fXd));
                        }
                    }
                } else if (c.bp(biVar)) {
                    aVar.mon.setVisibility(0);
                } else if (c.bq(biVar) && aVar != null) {
                    aVar.yUz.setVisibility(0);
                    aVar.yUy.setVisibility(0);
                    if (bVar != null) {
                        ab.i("MicroMsg.ImageGalleryGridAdapter", "initFileName--->content:%s", ah.nullAsNil(bVar.title));
                        if (bVar.type != 24) {
                            aVar.yUy.setText(j.b(this.mContext, ah.nullAsNil(bVar.title), aVar.yUy.getTextSize()));
                        } else {
                            aVar.yUy.setText(j.b(aVar.yUy.getContext(), aVar.yUy.getContext().getString(R.string.bsc), aVar.yUy.getTextSize()));
                        }
                    }
                }
            } else {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("the context should be ImageGalleryGridUI");
                AppMethodBeat.o(32025);
                throw illegalArgumentException;
            }
            aVar.moo.setChecked(com.tencent.mm.ui.chatting.gallery.h.a.yVE.bE(biVar));
            aVar.moo.setTag(biVar);
            aVar.mop.setTag(aVar);
            aVar.mop.setOnClickListener(this);
            if (com.tencent.mm.ui.chatting.gallery.h.a.yVE.mnY) {
                aVar.moo.setVisibility(0);
                aVar.mop.setVisibility(0);
                aVar.mom.setVisibility(0);
            } else {
                aVar.moo.setVisibility(8);
                aVar.mop.setVisibility(8);
                aVar.mom.setVisibility(8);
            }
            AppMethodBeat.o(32025);
        }
        return view;
    }

    private static int f(b bVar) {
        AppMethodBeat.i(32026);
        if (bVar == null) {
            ab.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:2131230813");
            AppMethodBeat.o(32026);
            return R.raw.app_attach_file_icon_unknow_in_gird;
        } else if (bVar.type == 5 || bVar.type == 7 || bVar.type == 15) {
            AppMethodBeat.o(32026);
            return R.raw.app_attach_file_icon_url_in_gird;
        } else if (bVar.type == 3) {
            AppMethodBeat.o(32026);
            return R.raw.app_attach_file_icon_music_in_gird;
        } else if (bVar.type == 6 && mid.containsKey(ah.nullAsNil(bVar.fgp))) {
            ab.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + mid.get(ah.nullAsNil(bVar.fgp)));
            int intValue = ((Integer) mid.get(ah.nullAsNil(bVar.fgp))).intValue();
            AppMethodBeat.o(32026);
            return intValue;
        } else {
            AppMethodBeat.o(32026);
            return R.raw.app_attach_file_icon_unknow_in_gird;
        }
    }

    private static int g(b bVar) {
        AppMethodBeat.i(32027);
        if (bVar == null) {
            ab.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:2131689673");
            AppMethodBeat.o(32027);
            return R.color.eq;
        } else if (bVar.type == 5 || bVar.type == 7 || bVar.type == 15) {
            AppMethodBeat.o(32027);
            return R.color.er;
        } else if (bVar.type == 6 && yUu.containsKey(ah.nullAsNil(bVar.fgp))) {
            ab.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + yUu.get(ah.nullAsNil(bVar.fgp)));
            int intValue = ((Integer) yUu.get(ah.nullAsNil(bVar.fgp))).intValue();
            AppMethodBeat.o(32027);
            return intValue;
        } else {
            AppMethodBeat.o(32027);
            return R.color.eq;
        }
    }

    private static String bx(bi biVar) {
        String ui;
        AppMethodBeat.i(32028);
        if (biVar.bws() || biVar.bwt()) {
            com.tencent.mm.modelvideo.o.all();
            ui = t.ui(biVar.field_imgPath);
        } else {
            ui = o.ahl().c(biVar.field_imgPath, false, false);
            if (!(ah.isNullOrNil(ui) || ui.endsWith("hd") || !e.ct(ui + "hd"))) {
                ui = ui + "hd";
            }
        }
        ab.i("MicroMsg.ImageGalleryGridAdapter", "MsgInfoForMonetUri imgPath : %s", ui);
        if (biVar.dtA()) {
            b me = b.me(biVar.field_content);
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
        AppMethodBeat.o(32028);
        return ui;
    }

    public final void bwq() {
        AppMethodBeat.i(32029);
        this.pZZ = false;
        notifyDataSetChanged();
        AppMethodBeat.o(32029);
    }

    public final void notifyDataSetChanged() {
        AppMethodBeat.i(32030);
        super.notifyDataSetChanged();
        this.yUt = false;
        AppMethodBeat.o(32030);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(32031);
        a aVar = (a) view.getTag();
        if (aVar.moo == null) {
            AppMethodBeat.o(32031);
            return;
        }
        bi biVar = (bi) aVar.moo.getTag();
        if (biVar == null) {
            AppMethodBeat.o(32031);
            return;
        }
        h dFX = com.tencent.mm.ui.chatting.gallery.h.a.yVE;
        if (dFX.bE(biVar)) {
            dFX.bD(biVar);
        } else {
            dFX.bC(biVar);
        }
        if (com.tencent.mm.ui.chatting.gallery.h.a.yVE.bE(biVar)) {
            aVar.moo.setChecked(true);
            aVar.mom.setBackgroundResource(R.color.rr);
        } else {
            aVar.moo.setChecked(false);
            aVar.mom.setBackgroundResource(R.color.sb);
        }
        if (!this.pZZ && com.tencent.mm.ui.chatting.gallery.h.a.yVE.mnX.size() > 1) {
            h.pYm.a(219, 20, 1, true);
            this.pZZ = true;
        }
        AppMethodBeat.o(32031);
    }

    static {
        AppMethodBeat.i(32033);
        HashMap hashMap = new HashMap();
        mid = hashMap;
        hashMap.put("avi", Integer.valueOf(R.raw.app_attach_file_icon_video_in_gird));
        mid.put("m4v", Integer.valueOf(R.raw.app_attach_file_icon_video_in_gird));
        mid.put("vob", Integer.valueOf(R.raw.app_attach_file_icon_video_in_gird));
        mid.put("mpeg", Integer.valueOf(R.raw.app_attach_file_icon_video_in_gird));
        mid.put("mpe", Integer.valueOf(R.raw.app_attach_file_icon_video_in_gird));
        mid.put("asx", Integer.valueOf(R.raw.app_attach_file_icon_video_in_gird));
        mid.put("asf", Integer.valueOf(R.raw.app_attach_file_icon_video_in_gird));
        mid.put("f4v", Integer.valueOf(R.raw.app_attach_file_icon_video_in_gird));
        mid.put("flv", Integer.valueOf(R.raw.app_attach_file_icon_video_in_gird));
        mid.put("mkv", Integer.valueOf(R.raw.app_attach_file_icon_video_in_gird));
        mid.put("wmv", Integer.valueOf(R.raw.app_attach_file_icon_video_in_gird));
        mid.put("wm", Integer.valueOf(R.raw.app_attach_file_icon_video_in_gird));
        mid.put("3gp", Integer.valueOf(R.raw.app_attach_file_icon_video_in_gird));
        mid.put("mp4", Integer.valueOf(R.raw.app_attach_file_icon_video_in_gird));
        mid.put("rmvb", Integer.valueOf(R.raw.app_attach_file_icon_video_in_gird));
        mid.put("rm", Integer.valueOf(R.raw.app_attach_file_icon_video_in_gird));
        mid.put("ra", Integer.valueOf(R.raw.app_attach_file_icon_video_in_gird));
        mid.put("ram", Integer.valueOf(R.raw.app_attach_file_icon_video_in_gird));
        mid.put("mp3pro", Integer.valueOf(R.raw.app_attach_file_icon_music_in_gird));
        mid.put("vqf", Integer.valueOf(R.raw.app_attach_file_icon_music_in_gird));
        mid.put("cd", Integer.valueOf(R.raw.app_attach_file_icon_music_in_gird));
        mid.put("md", Integer.valueOf(R.raw.app_attach_file_icon_music_in_gird));
        mid.put("mod", Integer.valueOf(R.raw.app_attach_file_icon_music_in_gird));
        mid.put("vorbis", Integer.valueOf(R.raw.app_attach_file_icon_music_in_gird));
        mid.put("au", Integer.valueOf(R.raw.app_attach_file_icon_music_in_gird));
        mid.put("amr", Integer.valueOf(R.raw.app_attach_file_icon_music_in_gird));
        mid.put("silk", Integer.valueOf(R.raw.app_attach_file_icon_music_in_gird));
        mid.put("wma", Integer.valueOf(R.raw.app_attach_file_icon_music_in_gird));
        mid.put("mmf", Integer.valueOf(R.raw.app_attach_file_icon_music_in_gird));
        mid.put("mid", Integer.valueOf(R.raw.app_attach_file_icon_music_in_gird));
        mid.put("midi", Integer.valueOf(R.raw.app_attach_file_icon_music_in_gird));
        mid.put("mp3", Integer.valueOf(R.raw.app_attach_file_icon_music_in_gird));
        mid.put("aac", Integer.valueOf(R.raw.app_attach_file_icon_music_in_gird));
        mid.put("ape", Integer.valueOf(R.raw.app_attach_file_icon_music_in_gird));
        mid.put("aiff", Integer.valueOf(R.raw.app_attach_file_icon_music_in_gird));
        mid.put("aif", Integer.valueOf(R.raw.app_attach_file_icon_music_in_gird));
        mid.put("doc", Integer.valueOf(R.raw.app_attach_file_icon_word_in_gird));
        mid.put("docx", Integer.valueOf(R.raw.app_attach_file_icon_word_in_gird));
        mid.put("ppt", Integer.valueOf(R.raw.app_attach_file_icon_ppt_in_gird));
        mid.put("pptx", Integer.valueOf(R.raw.app_attach_file_icon_ppt_in_gird));
        mid.put("xls", Integer.valueOf(R.raw.app_attach_file_icon_excel_in_gird));
        mid.put("xlsx", Integer.valueOf(R.raw.app_attach_file_icon_excel_in_gird));
        mid.put("pdf", Integer.valueOf(R.raw.app_attach_file_icon_pdf_in_gird));
        mid.put("unknown", Integer.valueOf(R.raw.app_attach_file_icon_unknow_in_gird));
        hashMap = new HashMap();
        yUu = hashMap;
        hashMap.put("doc", Integer.valueOf(R.color.em));
        yUu.put("docx", Integer.valueOf(R.color.em));
        yUu.put("ppt", Integer.valueOf(R.color.ep));
        yUu.put("pptx", Integer.valueOf(R.color.ep));
        yUu.put("xls", Integer.valueOf(R.color.es));
        yUu.put("xlsx", Integer.valueOf(R.color.es));
        yUu.put("pdf", Integer.valueOf(R.color.eo));
        yUu.put("unknown", Integer.valueOf(R.color.eq));
        yUu.put("mp3pro", Integer.valueOf(R.color.en));
        yUu.put("vqf", Integer.valueOf(R.color.en));
        yUu.put("cd", Integer.valueOf(R.color.en));
        yUu.put("md", Integer.valueOf(R.color.en));
        yUu.put("mod", Integer.valueOf(R.color.en));
        yUu.put("vorbis", Integer.valueOf(R.color.en));
        yUu.put("au", Integer.valueOf(R.color.en));
        yUu.put("amr", Integer.valueOf(R.color.en));
        yUu.put("silk", Integer.valueOf(R.color.en));
        yUu.put("wma", Integer.valueOf(R.color.en));
        yUu.put("mmf", Integer.valueOf(R.color.en));
        yUu.put("mid", Integer.valueOf(R.color.en));
        yUu.put("midi", Integer.valueOf(R.color.en));
        yUu.put("mp3", Integer.valueOf(R.color.en));
        yUu.put("aac", Integer.valueOf(R.color.en));
        yUu.put("ape", Integer.valueOf(R.color.en));
        yUu.put("aiff", Integer.valueOf(R.color.en));
        yUu.put("aif", Integer.valueOf(R.color.en));
        AppMethodBeat.o(32033);
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        AppMethodBeat.i(32032);
        bi biVar = new bi();
        biVar.d(cursor);
        AppMethodBeat.o(32032);
        return biVar;
    }
}

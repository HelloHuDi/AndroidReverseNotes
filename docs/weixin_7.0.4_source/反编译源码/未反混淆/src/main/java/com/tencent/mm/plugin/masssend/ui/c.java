package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.s;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.masssend.a.h;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.AnimImageView;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.v;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

final class c extends p<com.tencent.mm.plugin.masssend.a.a> {
    private static short ooB = (short) 1;
    private static short ooC = (short) 2;
    private static short ooD = (short) 3;
    private static short ooE = (short) 4;
    private MMActivity crP;
    int enb;
    private LayoutInflater ezi;
    int kmW;
    private short[] ooF;
    private List<String> ooG;
    String ooH = "";
    e ooI;

    static class f {
        ImageView miw;
        TextView ngD;
        TextView ooK;
        TextView ooL;
        TextView ooM;
        TextView ooN;
        TextView ooO;
        AnimImageView ooP;
        View ooQ;
        short ooR;

        f() {
        }
    }

    class a implements OnClickListener {
        private String fileName;
        private int ooe;

        public a(String str, int i) {
            this.fileName = str;
            this.ooe = i;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(22783);
            ab.v("MicroMsg.HistoryAdapter", "image clicked:" + this.fileName);
            aw.ZK();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                StringBuilder stringBuilder = new StringBuilder();
                aw.ZK();
                String stringBuilder2 = stringBuilder.append(com.tencent.mm.model.c.XW()).append(this.fileName).toString();
                if (stringBuilder2 == null || stringBuilder2.equals("") || !com.tencent.mm.vfs.e.ct(stringBuilder2)) {
                    ab.d("MicroMsg.HistoryAdapter", "showImg : imgPath is null");
                    AppMethodBeat.o(22783);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("key_compress_type", this.ooe);
                intent.putExtra("key_favorite", false);
                intent.putExtra("key_image_path", stringBuilder2);
                com.tencent.mm.plugin.masssend.a.gkE.d(c.this.crP, intent);
                AppMethodBeat.o(22783);
                return;
            }
            t.hO(c.this.crP);
            AppMethodBeat.o(22783);
        }
    }

    class b implements OnClickListener {
        private String id;

        public b(String str) {
            this.id = str;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(22784);
            com.tencent.mm.plugin.masssend.a.a Qs = h.bNE().Qs(this.id);
            Intent intent = new Intent(c.this.crP, MassSendMsgUI.class);
            intent.putExtra("mass_send_contact_list", Qs.bNy());
            intent.putExtra("mass_send_again", true);
            c.this.crP.startActivity(intent);
            AppMethodBeat.o(22784);
        }
    }

    class c implements OnClickListener {
        private String fileName;
        private int length;
        private int size;
        private int videoSource;

        public c(String str, int i, int i2, int i3) {
            this.fileName = str;
            this.videoSource = i;
            this.length = i3;
            this.size = i2;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(22785);
            aw.ZK();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                boolean z = this.videoSource == 2;
                o.all();
                ab.i("MicroMsg.HistoryAdapter", "video clicked, path:%s, isExport:%b, typeQt:%b", this.fileName, Boolean.valueOf(z), Boolean.valueOf(r.ua(com.tencent.mm.modelvideo.t.uh(this.fileName))));
                com.tencent.mm.plugin.masssend.a.gkE.a(z, r2, c.this.crP, this.fileName, this.length, this.size);
                AppMethodBeat.o(22785);
                return;
            }
            t.hO(c.this.crP);
            AppMethodBeat.o(22785);
        }
    }

    class d implements OnClickListener {
        private String id;

        public d(String str) {
            this.id = str;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(22786);
            ab.v("MicroMsg.HistoryAdapter", "voice clicked:" + this.id);
            if (c.this.ooI != null) {
                c.this.ooH = c.this.ooI.Qw(this.id);
                c.this.notifyDataSetChanged();
            }
            AppMethodBeat.o(22786);
        }
    }

    interface e {
        String Qw(String str);
    }

    public c(Context context) {
        super(context, new com.tencent.mm.plugin.masssend.a.a());
        AppMethodBeat.i(22787);
        this.crP = (MMActivity) context;
        this.ooG = new LinkedList();
        this.kmW = 10;
        this.enb = this.kmW;
        this.ezi = v.hu(context);
        AppMethodBeat.o(22787);
    }

    public final void KD() {
        AppMethodBeat.i(22788);
        KC();
        AppMethodBeat.o(22788);
    }

    public final boolean bdn() {
        return this.kmW >= this.enb;
    }

    public final void KC() {
        AppMethodBeat.i(22789);
        this.enb = h.bNE().bNz();
        setCursor(h.bNE().xm(this.kmW));
        bNM();
        super.notifyDataSetChanged();
        AppMethodBeat.o(22789);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        Object obj;
        com.tencent.mm.plugin.masssend.a.a aVar;
        CharSequence charSequence;
        int i2;
        AppMethodBeat.i(22790);
        com.tencent.mm.plugin.masssend.a.a aVar2 = (com.tencent.mm.plugin.masssend.a.a) getItem(i);
        if (i != 0) {
            long j = ((com.tencent.mm.plugin.masssend.a.a) getItem(i - 1)).createTime;
            aVar2 = (com.tencent.mm.plugin.masssend.a.a) getItem(i);
            long j2 = aVar2.createTime;
            obj = j2 - j < 60000 ? 1 : null;
            Object obj2 = (j2 - j) / 180000 < 1 ? 1 : null;
            if (obj == null && obj2 == null) {
                this.ooF[i] = (short) 1;
                aVar = aVar2;
            } else {
                this.ooF[i] = (short) 2;
                aVar = aVar2;
            }
        } else {
            this.ooF[i] = (short) 1;
            aVar = aVar2;
        }
        if (this.ooF[i] != (short) 1 || aVar.createTime <= 1000) {
            obj = null;
        } else {
            obj = 1;
        }
        f fVar;
        switch (aVar.msgType) {
            case 1:
                fVar = new f();
                if (view == null || ((f) view.getTag()).ooR != ooB) {
                    view = this.ezi.inflate(R.layout.acn, null);
                    fVar.ooK = (TextView) view.findViewById(R.id.d7g);
                    fVar.ooL = (TextView) view.findViewById(R.id.d7h);
                    fVar.ooM = (TextView) view.findViewById(R.id.d7k);
                    fVar.ooO = (TextView) view.findViewById(R.id.d7j);
                    fVar.ngD = (TextView) view.findViewById(R.id.d7e);
                    fVar.ooQ = view.findViewById(R.id.d7f);
                    fVar.ooR = ooB;
                    view.setTag(fVar);
                    break;
                }
            case 3:
                fVar = new f();
                if (view == null || ((f) view.getTag()).ooR != ooC) {
                    view = this.ezi.inflate(R.layout.acm, null);
                    fVar.ooK = (TextView) view.findViewById(R.id.d7g);
                    fVar.ooL = (TextView) view.findViewById(R.id.d7h);
                    fVar.miw = (ImageView) view.findViewById(R.id.d7i);
                    fVar.ooO = (TextView) view.findViewById(R.id.d7j);
                    fVar.ngD = (TextView) view.findViewById(R.id.d7e);
                    fVar.ooQ = view.findViewById(R.id.d7f);
                    fVar.ooR = ooC;
                    view.setTag(fVar);
                    break;
                }
            case 34:
                fVar = new f();
                if (view == null || ((f) view.getTag()).ooR != ooE) {
                    view = this.ezi.inflate(R.layout.acp, null);
                    fVar.ooK = (TextView) view.findViewById(R.id.d7g);
                    fVar.ooL = (TextView) view.findViewById(R.id.d7h);
                    fVar.ooN = (TextView) view.findViewById(R.id.d7n);
                    fVar.ooM = (TextView) view.findViewById(R.id.d7o);
                    fVar.ooP = (AnimImageView) view.findViewById(R.id.d7p);
                    fVar.ooO = (TextView) view.findViewById(R.id.d7j);
                    fVar.ngD = (TextView) view.findViewById(R.id.d7e);
                    fVar.ooQ = view.findViewById(R.id.d7f);
                    fVar.ooR = ooE;
                    view.setTag(fVar);
                    break;
                }
            case 43:
                fVar = new f();
                if (view == null || ((f) view.getTag()).ooR != ooD) {
                    view = this.ezi.inflate(R.layout.aco, null);
                    fVar.ooK = (TextView) view.findViewById(R.id.d7g);
                    fVar.ooL = (TextView) view.findViewById(R.id.d7h);
                    fVar.miw = (ImageView) view.findViewById(R.id.d7i);
                    fVar.ooN = (TextView) view.findViewById(R.id.d7l);
                    fVar.ooO = (TextView) view.findViewById(R.id.d7j);
                    fVar.ngD = (TextView) view.findViewById(R.id.d7e);
                    fVar.ooQ = view.findViewById(R.id.d7f);
                    fVar.ooR = ooD;
                    view.setTag(fVar);
                    break;
                }
        }
        f fVar2 = (f) view.getTag();
        if (obj != null) {
            fVar2.ngD.setVisibility(0);
            fVar2.ngD.setText(com.tencent.mm.pluginsdk.f.h.c(this.crP, aVar.createTime, false));
        } else {
            fVar2.ngD.setVisibility(8);
        }
        switch (aVar.msgType) {
            case 1:
                fVar2 = (f) view.getTag();
                fVar2.ooM.setText(aVar.bNw());
                j.h(fVar2.ooM, 1);
                break;
            case 3:
                fVar2 = (f) view.getTag();
                aw.ZK();
                if (com.tencent.mm.model.c.isSDCardAvailable()) {
                    h.bNE();
                    Bitmap Qr = com.tencent.mm.plugin.masssend.a.b.Qr(aVar.bNw());
                    if (Qr != null) {
                        fVar2.miw.setImageBitmap(Qr);
                    } else {
                        h.bNE();
                        fVar2.miw.setImageBitmap(com.tencent.mm.plugin.masssend.a.b.g(aVar.bNx(), com.tencent.mm.bz.a.getDensity(fVar2.miw.getContext())));
                    }
                } else {
                    fVar2.miw.setImageDrawable(com.tencent.mm.bz.a.g(this.crP, R.drawable.ak_));
                }
                fVar2.miw.setOnClickListener(new a(aVar.bNw(), aVar.ooe));
                break;
            case 34:
                fVar2 = (f) view.getTag();
                float fY = q.fY((long) aVar.oob);
                if (aVar.bNv().equals(this.ooH)) {
                    fVar2.ooP.setVisibility(0);
                    fVar2.ooP.dzr();
                    fVar2.ooM.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                } else {
                    fVar2.ooP.setVisibility(8);
                    fVar2.ooP.ceT();
                    fVar2.ooM.setCompoundDrawablesWithIntrinsicBounds(null, null, this.crP.getResources().getDrawable(R.raw.chatto_voice_playing), null);
                }
                fVar2.ooN.setText(this.crP.getString(R.string.byu, new Object[]{Integer.valueOf((int) fY)}));
                fVar2.ooM.setWidth(com.tencent.mm.bz.a.fromDPToPix(fVar2.ooM.getContext(), yr((int) fY)));
                fVar2.ooP.setWidth(com.tencent.mm.bz.a.fromDPToPix(fVar2.ooM.getContext(), yr((int) fY)));
                fVar2.ooM.setOnClickListener(new d(aVar.bNv()));
                break;
            case 43:
                f fVar3 = (f) view.getTag();
                o.all();
                Bitmap a = com.tencent.mm.at.o.ahl().a(com.tencent.mm.modelvideo.t.ui(aVar.bNw()), com.tencent.mm.bz.a.getDensity(fVar3.miw.getContext()), this.crP);
                if (a == null) {
                    aw.ZK();
                    if (com.tencent.mm.model.c.isSDCardAvailable()) {
                        fVar3.miw.setImageDrawable(com.tencent.mm.bz.a.g(this.crP, R.color.rn));
                    } else {
                        fVar3.miw.setImageDrawable(com.tencent.mm.bz.a.g(this.crP, R.raw.video_no_sd_icon));
                    }
                } else {
                    fVar3.miw.setImageBitmap(a);
                }
                fVar3.miw.setOnClickListener(new c(aVar.bNw(), aVar.videoSource, aVar.cde, aVar.oob));
                if (aVar.videoSource != 2) {
                    fVar3.ooN.setVisibility(0);
                    fVar3.ooN.setText(bo.mK(aVar.oob));
                    break;
                }
                fVar3.ooN.setVisibility(8);
                break;
        }
        fVar2 = (f) view.getTag();
        fVar2.ooK.setText(this.crP.getResources().getQuantityString(R.plurals.r, aVar.ooa, new Object[]{Integer.valueOf(aVar.ooa)}));
        if (this.ooG.contains(aVar.bNv())) {
            fVar2.ooL.setSingleLine(false);
            fVar2.ooL.setEllipsize(null);
        } else {
            fVar2.ooL.setSingleLine(true);
            fVar2.ooL.setEllipsize(TruncateAt.END);
        }
        TextView textView = fVar2.ooL;
        Context context = this.crP;
        ArrayList arrayList = new ArrayList();
        if (aVar.bNy() == null || aVar.bNy().equals("")) {
            charSequence = "";
        } else {
            List P;
            String[] split = aVar.bNy().split(";");
            if (split == null || split.length <= 0) {
                Object P2 = arrayList;
            } else {
                P2 = bo.P(split);
            }
            if (P2 == null) {
                charSequence = "";
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 < P2.size()) {
                        String mJ = s.mJ((String) P2.get(i3));
                        if (i3 == P2.size() - 1) {
                            stringBuilder.append(mJ);
                        } else {
                            stringBuilder.append(mJ + ", ");
                        }
                        i2 = i3 + 1;
                    } else {
                        charSequence = stringBuilder.toString();
                    }
                }
            }
        }
        textView.setText(j.b(context, charSequence, fVar2.ooL.getTextSize()));
        i2 = (int) fVar2.ooL.getTextSize();
        String charSequence2 = fVar2.ooL.getText().toString();
        com.tencent.mm.bz.a.fromDPToPix(this.crP, 255);
        Paint paint = new Paint();
        paint.setTextSize((float) i2);
        paint.measureText(charSequence2);
        fVar2.ooO.setOnClickListener(new b(aVar.bNv()));
        AppMethodBeat.o(22790);
        return view;
    }

    public final void Qv(String str) {
        AppMethodBeat.i(22791);
        this.ooH = str;
        notifyDataSetChanged();
        AppMethodBeat.o(22791);
    }

    private static int yr(int i) {
        if (i <= 2) {
            return 100;
        }
        if (i < 10) {
            return ((i - 2) * 8) + 100;
        }
        if (i < 60) {
            return (((i / 10) + 7) * 8) + 100;
        }
        return 204;
    }

    private void bNM() {
        AppMethodBeat.i(22792);
        int count = getCount();
        if (count <= 0) {
            AppMethodBeat.o(22792);
            return;
        }
        this.ooF = new short[count];
        AppMethodBeat.o(22792);
    }
}

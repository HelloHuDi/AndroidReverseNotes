package com.tencent.p177mm.plugin.masssend.p452ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvideo.C26492r;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C9720t;
import com.tencent.p177mm.modelvoice.C32850q;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.AnimImageView;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.plugin.masssend.C12490a;
import com.tencent.p177mm.plugin.masssend.p992a.C21270h;
import com.tencent.p177mm.plugin.masssend.p992a.C39356a;
import com.tencent.p177mm.plugin.masssend.p992a.C46069b;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.masssend.ui.c */
final class C43295c extends C46692p<C39356a> {
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
    C43296e ooI;

    /* renamed from: com.tencent.mm.plugin.masssend.ui.c$f */
    static class C3449f {
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

        C3449f() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.masssend.ui.c$a */
    class C34522a implements OnClickListener {
        private String fileName;
        private int ooe;

        public C34522a(String str, int i) {
            this.fileName = str;
            this.ooe = i;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(22783);
            C4990ab.m7418v("MicroMsg.HistoryAdapter", "image clicked:" + this.fileName);
            C9638aw.m17190ZK();
            if (C18628c.isSDCardAvailable()) {
                StringBuilder stringBuilder = new StringBuilder();
                C9638aw.m17190ZK();
                String stringBuilder2 = stringBuilder.append(C18628c.m29088XW()).append(this.fileName).toString();
                if (stringBuilder2 == null || stringBuilder2.equals("") || !C5730e.m8628ct(stringBuilder2)) {
                    C4990ab.m7410d("MicroMsg.HistoryAdapter", "showImg : imgPath is null");
                    AppMethodBeat.m2505o(22783);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("key_compress_type", this.ooe);
                intent.putExtra("key_favorite", false);
                intent.putExtra("key_image_path", stringBuilder2);
                C12490a.gkE.mo38914d(C43295c.this.crP, intent);
                AppMethodBeat.m2505o(22783);
                return;
            }
            C23639t.m36492hO(C43295c.this.crP);
            AppMethodBeat.m2505o(22783);
        }
    }

    /* renamed from: com.tencent.mm.plugin.masssend.ui.c$b */
    class C34523b implements OnClickListener {
        /* renamed from: id */
        private String f15060id;

        public C34523b(String str) {
            this.f15060id = str;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(22784);
            C39356a Qs = C21270h.bNE().mo73988Qs(this.f15060id);
            Intent intent = new Intent(C43295c.this.crP, MassSendMsgUI.class);
            intent.putExtra("mass_send_contact_list", Qs.bNy());
            intent.putExtra("mass_send_again", true);
            C43295c.this.crP.startActivity(intent);
            AppMethodBeat.m2505o(22784);
        }
    }

    /* renamed from: com.tencent.mm.plugin.masssend.ui.c$c */
    class C34524c implements OnClickListener {
        private String fileName;
        private int length;
        private int size;
        private int videoSource;

        public C34524c(String str, int i, int i2, int i3) {
            this.fileName = str;
            this.videoSource = i;
            this.length = i3;
            this.size = i2;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(22785);
            C9638aw.m17190ZK();
            if (C18628c.isSDCardAvailable()) {
                boolean z = this.videoSource == 2;
                C37961o.all();
                C4990ab.m7417i("MicroMsg.HistoryAdapter", "video clicked, path:%s, isExport:%b, typeQt:%b", this.fileName, Boolean.valueOf(z), Boolean.valueOf(C26492r.m42228ua(C9720t.m17303uh(this.fileName))));
                C12490a.gkE.mo38902a(z, r2, C43295c.this.crP, this.fileName, this.length, this.size);
                AppMethodBeat.m2505o(22785);
                return;
            }
            C23639t.m36492hO(C43295c.this.crP);
            AppMethodBeat.m2505o(22785);
        }
    }

    /* renamed from: com.tencent.mm.plugin.masssend.ui.c$d */
    class C34525d implements OnClickListener {
        /* renamed from: id */
        private String f15061id;

        public C34525d(String str) {
            this.f15061id = str;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(22786);
            C4990ab.m7418v("MicroMsg.HistoryAdapter", "voice clicked:" + this.f15061id);
            if (C43295c.this.ooI != null) {
                C43295c.this.ooH = C43295c.this.ooI.mo17616Qw(this.f15061id);
                C43295c.this.notifyDataSetChanged();
            }
            AppMethodBeat.m2505o(22786);
        }
    }

    /* renamed from: com.tencent.mm.plugin.masssend.ui.c$e */
    interface C43296e {
        /* renamed from: Qw */
        String mo17616Qw(String str);
    }

    public C43295c(Context context) {
        super(context, new C39356a());
        AppMethodBeat.m2504i(22787);
        this.crP = (MMActivity) context;
        this.ooG = new LinkedList();
        this.kmW = 10;
        this.enb = this.kmW;
        this.ezi = C5616v.m8409hu(context);
        AppMethodBeat.m2505o(22787);
    }

    /* renamed from: KD */
    public final void mo6870KD() {
        AppMethodBeat.m2504i(22788);
        mo6869KC();
        AppMethodBeat.m2505o(22788);
    }

    public final boolean bdn() {
        return this.kmW >= this.enb;
    }

    /* renamed from: KC */
    public final void mo6869KC() {
        AppMethodBeat.m2504i(22789);
        this.enb = C21270h.bNE().bNz();
        setCursor(C21270h.bNE().mo73990xm(this.kmW));
        bNM();
        super.notifyDataSetChanged();
        AppMethodBeat.m2505o(22789);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        Object obj;
        C39356a c39356a;
        CharSequence charSequence;
        int i2;
        AppMethodBeat.m2504i(22790);
        C39356a c39356a2 = (C39356a) getItem(i);
        if (i != 0) {
            long j = ((C39356a) getItem(i - 1)).createTime;
            c39356a2 = (C39356a) getItem(i);
            long j2 = c39356a2.createTime;
            obj = j2 - j < 60000 ? 1 : null;
            Object obj2 = (j2 - j) / 180000 < 1 ? 1 : null;
            if (obj == null && obj2 == null) {
                this.ooF[i] = (short) 1;
                c39356a = c39356a2;
            } else {
                this.ooF[i] = (short) 2;
                c39356a = c39356a2;
            }
        } else {
            this.ooF[i] = (short) 1;
            c39356a = c39356a2;
        }
        if (this.ooF[i] != (short) 1 || c39356a.createTime <= 1000) {
            obj = null;
        } else {
            obj = 1;
        }
        C3449f c3449f;
        switch (c39356a.msgType) {
            case 1:
                c3449f = new C3449f();
                if (view == null || ((C3449f) view.getTag()).ooR != ooB) {
                    view = this.ezi.inflate(2130970073, null);
                    c3449f.ooK = (TextView) view.findViewById(2131825925);
                    c3449f.ooL = (TextView) view.findViewById(2131825926);
                    c3449f.ooM = (TextView) view.findViewById(2131825929);
                    c3449f.ooO = (TextView) view.findViewById(2131825928);
                    c3449f.ngD = (TextView) view.findViewById(2131825923);
                    c3449f.ooQ = view.findViewById(2131825924);
                    c3449f.ooR = ooB;
                    view.setTag(c3449f);
                    break;
                }
            case 3:
                c3449f = new C3449f();
                if (view == null || ((C3449f) view.getTag()).ooR != ooC) {
                    view = this.ezi.inflate(2130970072, null);
                    c3449f.ooK = (TextView) view.findViewById(2131825925);
                    c3449f.ooL = (TextView) view.findViewById(2131825926);
                    c3449f.miw = (ImageView) view.findViewById(2131825927);
                    c3449f.ooO = (TextView) view.findViewById(2131825928);
                    c3449f.ngD = (TextView) view.findViewById(2131825923);
                    c3449f.ooQ = view.findViewById(2131825924);
                    c3449f.ooR = ooC;
                    view.setTag(c3449f);
                    break;
                }
            case 34:
                c3449f = new C3449f();
                if (view == null || ((C3449f) view.getTag()).ooR != ooE) {
                    view = this.ezi.inflate(2130970075, null);
                    c3449f.ooK = (TextView) view.findViewById(2131825925);
                    c3449f.ooL = (TextView) view.findViewById(2131825926);
                    c3449f.ooN = (TextView) view.findViewById(2131825932);
                    c3449f.ooM = (TextView) view.findViewById(2131825933);
                    c3449f.ooP = (AnimImageView) view.findViewById(2131825934);
                    c3449f.ooO = (TextView) view.findViewById(2131825928);
                    c3449f.ngD = (TextView) view.findViewById(2131825923);
                    c3449f.ooQ = view.findViewById(2131825924);
                    c3449f.ooR = ooE;
                    view.setTag(c3449f);
                    break;
                }
            case 43:
                c3449f = new C3449f();
                if (view == null || ((C3449f) view.getTag()).ooR != ooD) {
                    view = this.ezi.inflate(2130970074, null);
                    c3449f.ooK = (TextView) view.findViewById(2131825925);
                    c3449f.ooL = (TextView) view.findViewById(2131825926);
                    c3449f.miw = (ImageView) view.findViewById(2131825927);
                    c3449f.ooN = (TextView) view.findViewById(2131825930);
                    c3449f.ooO = (TextView) view.findViewById(2131825928);
                    c3449f.ngD = (TextView) view.findViewById(2131825923);
                    c3449f.ooQ = view.findViewById(2131825924);
                    c3449f.ooR = ooD;
                    view.setTag(c3449f);
                    break;
                }
        }
        C3449f c3449f2 = (C3449f) view.getTag();
        if (obj != null) {
            c3449f2.ngD.setVisibility(0);
            c3449f2.ngD.setText(C14835h.m23089c(this.crP, c39356a.createTime, false));
        } else {
            c3449f2.ngD.setVisibility(8);
        }
        switch (c39356a.msgType) {
            case 1:
                c3449f2 = (C3449f) view.getTag();
                c3449f2.ooM.setText(c39356a.bNw());
                C44089j.m79307h(c3449f2.ooM, 1);
                break;
            case 3:
                c3449f2 = (C3449f) view.getTag();
                C9638aw.m17190ZK();
                if (C18628c.isSDCardAvailable()) {
                    C21270h.bNE();
                    Bitmap Qr = C46069b.m85831Qr(c39356a.bNw());
                    if (Qr != null) {
                        c3449f2.miw.setImageBitmap(Qr);
                    } else {
                        C21270h.bNE();
                        c3449f2.miw.setImageBitmap(C46069b.m85833g(c39356a.bNx(), C1338a.getDensity(c3449f2.miw.getContext())));
                    }
                } else {
                    c3449f2.miw.setImageDrawable(C1338a.m2864g(this.crP, C25738R.drawable.ak_));
                }
                c3449f2.miw.setOnClickListener(new C34522a(c39356a.bNw(), c39356a.ooe));
                break;
            case 34:
                c3449f2 = (C3449f) view.getTag();
                float fY = C32850q.m53722fY((long) c39356a.oob);
                if (c39356a.bNv().equals(this.ooH)) {
                    c3449f2.ooP.setVisibility(0);
                    c3449f2.ooP.dzr();
                    c3449f2.ooM.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                } else {
                    c3449f2.ooP.setVisibility(8);
                    c3449f2.ooP.ceT();
                    c3449f2.ooM.setCompoundDrawablesWithIntrinsicBounds(null, null, this.crP.getResources().getDrawable(C1318a.chatto_voice_playing), null);
                }
                c3449f2.ooN.setText(this.crP.getString(C25738R.string.byu, new Object[]{Integer.valueOf((int) fY)}));
                c3449f2.ooM.setWidth(C1338a.fromDPToPix(c3449f2.ooM.getContext(), C43295c.m77168yr((int) fY)));
                c3449f2.ooP.setWidth(C1338a.fromDPToPix(c3449f2.ooM.getContext(), C43295c.m77168yr((int) fY)));
                c3449f2.ooM.setOnClickListener(new C34525d(c39356a.bNv()));
                break;
            case 43:
                C3449f c3449f3 = (C3449f) view.getTag();
                C37961o.all();
                Bitmap a = C32291o.ahl().mo73085a(C9720t.m17304ui(c39356a.bNw()), C1338a.getDensity(c3449f3.miw.getContext()), this.crP);
                if (a == null) {
                    C9638aw.m17190ZK();
                    if (C18628c.isSDCardAvailable()) {
                        c3449f3.miw.setImageDrawable(C1338a.m2864g(this.crP, C25738R.color.f12081rn));
                    } else {
                        c3449f3.miw.setImageDrawable(C1338a.m2864g(this.crP, C1318a.video_no_sd_icon));
                    }
                } else {
                    c3449f3.miw.setImageBitmap(a);
                }
                c3449f3.miw.setOnClickListener(new C34524c(c39356a.bNw(), c39356a.videoSource, c39356a.cde, c39356a.oob));
                if (c39356a.videoSource != 2) {
                    c3449f3.ooN.setVisibility(0);
                    c3449f3.ooN.setText(C5046bo.m7577mK(c39356a.oob));
                    break;
                }
                c3449f3.ooN.setVisibility(8);
                break;
        }
        c3449f2 = (C3449f) view.getTag();
        c3449f2.ooK.setText(this.crP.getResources().getQuantityString(C25738R.plurals.f9605r, c39356a.ooa, new Object[]{Integer.valueOf(c39356a.ooa)}));
        if (this.ooG.contains(c39356a.bNv())) {
            c3449f2.ooL.setSingleLine(false);
            c3449f2.ooL.setEllipsize(null);
        } else {
            c3449f2.ooL.setSingleLine(true);
            c3449f2.ooL.setEllipsize(TruncateAt.END);
        }
        TextView textView = c3449f2.ooL;
        Context context = this.crP;
        ArrayList arrayList = new ArrayList();
        if (c39356a.bNy() == null || c39356a.bNy().equals("")) {
            charSequence = "";
        } else {
            List P;
            String[] split = c39356a.bNy().split(";");
            if (split == null || split.length <= 0) {
                Object P2 = arrayList;
            } else {
                P2 = C5046bo.m7508P(split);
            }
            if (P2 == null) {
                charSequence = "";
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 < P2.size()) {
                        String mJ = C1854s.m3866mJ((String) P2.get(i3));
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
        textView.setText(C44089j.m79293b(context, charSequence, c3449f2.ooL.getTextSize()));
        i2 = (int) c3449f2.ooL.getTextSize();
        String charSequence2 = c3449f2.ooL.getText().toString();
        C1338a.fromDPToPix(this.crP, 255);
        Paint paint = new Paint();
        paint.setTextSize((float) i2);
        paint.measureText(charSequence2);
        c3449f2.ooO.setOnClickListener(new C34523b(c39356a.bNv()));
        AppMethodBeat.m2505o(22790);
        return view;
    }

    /* renamed from: Qv */
    public final void mo68841Qv(String str) {
        AppMethodBeat.m2504i(22791);
        this.ooH = str;
        notifyDataSetChanged();
        AppMethodBeat.m2505o(22791);
    }

    /* renamed from: yr */
    private static int m77168yr(int i) {
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
        AppMethodBeat.m2504i(22792);
        int count = getCount();
        if (count <= 0) {
            AppMethodBeat.m2505o(22792);
            return;
        }
        this.ooF = new short[count];
        AppMethodBeat.m2505o(22792);
    }
}

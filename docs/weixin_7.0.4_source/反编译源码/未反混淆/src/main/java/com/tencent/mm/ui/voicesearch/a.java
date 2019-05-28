package com.tencent.mm.ui.voicesearch;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.database.MergeCursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bg.g;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.tools.r;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressLint({"DefaultLocale"})
public final class a extends p<ak> {
    protected List<String> elZ = null;
    private String gtX;
    private com.tencent.mm.ui.applet.b gvm = new com.tencent.mm.ui.applet.b(new com.tencent.mm.ui.applet.b.a() {
        public final Bitmap wd(String str) {
            AppMethodBeat.i(35304);
            Bitmap a = com.tencent.mm.ah.b.a(str, false, -1);
            AppMethodBeat.o(35304);
            return a;
        }
    });
    private com.tencent.mm.ui.applet.b.b gvn = null;
    private ColorStateList[] yDX = new ColorStateList[2];
    private HashMap<String, a> yDY;
    private b zLp;
    private boolean zrm = true;

    class a {
        public CharSequence nickName;
        public CharSequence zrH;
        public CharSequence zrI;
        public int zrJ;

        private a() {
        }

        /* synthetic */ a(a aVar, byte b) {
            this();
        }
    }

    public interface b {
    }

    public static class c {
        public ImageView ejo;
        public TextView ejp;
        public TextView jJT;
        public TextView jJU;
        public TextView jJV;
        public ImageView yEf;
        public ImageView yEg;
    }

    public a(Context context, com.tencent.mm.ui.p.a aVar) {
        super(context, new ak());
        AppMethodBeat.i(35307);
        super.a(aVar);
        this.yDX[0] = com.tencent.mm.bz.a.h(context, (int) R.color.a7x);
        this.yDX[1] = com.tencent.mm.bz.a.h(context, (int) R.color.a7y);
        this.yDY = new HashMap();
        AppMethodBeat.o(35307);
    }

    public final void fl(List<String> list) {
        AppMethodBeat.i(35308);
        this.elZ = list;
        a(null, null);
        AppMethodBeat.o(35308);
    }

    public final void KD() {
        AppMethodBeat.i(35309);
        KC();
        AppMethodBeat.o(35309);
    }

    public final void KC() {
        AppMethodBeat.i(35310);
        Cursor[] cursorArr = new Cursor[2];
        cursorArr[0] = aw.ZK().fkd.b(t.fkP, this.elZ, this.gtX);
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        if (this.elZ != null && this.elZ.size() > 0) {
            arrayList.addAll(this.elZ);
        }
        while (cursorArr[0].moveToNext()) {
            try {
                String string = cursorArr[0].getString(cursorArr[0].getColumnIndex("username"));
                arrayList.add(string);
                if (!t.kH(string)) {
                    arrayList2.add(string);
                }
                ab.d("MicroMsg.SearchConversationAdapter", "block user ".concat(String.valueOf(string)));
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.SearchConversationAdapter", e, "", new Object[0]);
            }
        }
        cursorArr[1] = aw.ZK().fke.a(this.gtX, "@micromsg.with.all.biz.qq.com", arrayList, arrayList2);
        setCursor(new MergeCursor(cursorArr));
        if (!(this.zLp == null || this.gtX == null)) {
            getCursor().getCount();
        }
        super.notifyDataSetChanged();
        AppMethodBeat.o(35310);
    }

    /* JADX WARNING: Removed duplicated region for block: B:84:0x02de  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x037b  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x020f  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0233  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x024d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final View getView(int i, View view, ViewGroup viewGroup) {
        int i2;
        c cVar;
        a aVar;
        sz szVar;
        AppMethodBeat.i(35311);
        if (this.gvn == null) {
            this.gvn = new com.tencent.mm.ui.applet.b.b() {
                public final String mW(int i) {
                    AppMethodBeat.i(35305);
                    if (i < 0 || i >= a.this.getCount()) {
                        ab.e("MicroMsg.SearchConversationAdapter", "pos is invalid");
                        AppMethodBeat.o(35305);
                        return null;
                    }
                    ak akVar = (ak) a.this.getItem(i);
                    if (akVar == null) {
                        AppMethodBeat.o(35305);
                        return null;
                    }
                    String str = akVar.field_username;
                    AppMethodBeat.o(35305);
                    return str;
                }

                public final int apO() {
                    AppMethodBeat.i(35306);
                    int count = a.this.getCount();
                    AppMethodBeat.o(35306);
                    return count;
                }
            };
        }
        if (this.gvm != null) {
            this.gvm.a(i, this.gvn);
        }
        ak akVar = (ak) getItem(i);
        if (FB(akVar.field_msgType) == 34 && akVar.field_isSend == 0 && !ah.isNullOrNil(akVar.field_content)) {
            String str = akVar.field_content;
            if (akVar.field_username.equals("qmessage") || akVar.field_username.equals("floatbottle")) {
                String[] split = str.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                if (split != null && split.length > 3) {
                    str = split[1] + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + split[2] + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + split[3];
                }
            }
            if (!new n(str).fWX) {
                i2 = 1;
                if (view != null) {
                    cVar = new c();
                    view = View.inflate(this.context, R.layout.apz, null);
                    cVar.ejo = (ImageView) view.findViewById(R.id.qk);
                    cVar.ejp = (TextView) view.findViewById(R.id.b6e);
                    cVar.jJT = (TextView) view.findViewById(R.id.b6f);
                    cVar.jJU = (TextView) view.findViewById(R.id.b6g);
                    cVar.jJV = (TextView) view.findViewById(R.id.nf);
                    cVar.jJV.setBackgroundResource(r.ik(this.context));
                    cVar.yEf = (ImageView) view.findViewById(R.id.b6i);
                    cVar.yEg = (ImageView) view.findViewById(R.id.b6j);
                    view.setTag(cVar);
                } else {
                    cVar = (c) view.getTag();
                }
                aVar = (a) this.yDY.get(akVar.field_username + akVar.field_content);
                if (aVar == null) {
                    CharSequence string;
                    int i3;
                    a aVar2 = new a(this, (byte) 0);
                    aVar2.nickName = j.b(this.context, s.mJ(akVar.field_username), cVar.ejp.getTextSize());
                    if (akVar.field_status == 1) {
                        string = this.context.getString(R.string.cw8);
                    } else if (akVar.field_conversationTime == Long.MAX_VALUE) {
                        string = "";
                    } else {
                        string = h.c(this.context, akVar.field_conversationTime, true);
                    }
                    aVar2.zrH = string;
                    int textSize = (int) cVar.jJU.getTextSize();
                    int YD = com.tencent.mm.model.r.YD();
                    String str2 = akVar.field_username;
                    aw.ZK();
                    Object obj = ah.h((Integer) com.tencent.mm.model.c.Ry().get(17, null)) == 1 ? 1 : null;
                    if (str2.equals("qqmail") && obj == null) {
                        string = this.context.getString(R.string.e_7);
                    } else {
                        aw.ZK();
                        bq RA = com.tencent.mm.model.c.XU().RA("@t.qq.com");
                        obj = (RA == null || !RA.isEnable()) ? null : 1;
                        if (str2.equals("tmessage") && obj == null) {
                            string = this.context.getString(R.string.e_7);
                        } else {
                            obj = (YD & 64) != 0 ? 1 : null;
                            if (str2.equals("qmessage") && obj == null) {
                                string = this.context.getString(R.string.e_7);
                            } else {
                                string = j.b(this.context, com.tencent.mm.booter.notification.a.h.a(akVar.field_isSend, akVar.field_username, akVar.field_content, FB(akVar.field_msgType), this.context), textSize);
                            }
                        }
                    }
                    aVar2.zrI = string;
                    if (t.kH(akVar.field_username) && com.tencent.mm.model.n.mA(akVar.field_username) == 0) {
                        aVar2.nickName = this.context.getString(R.string.ao1);
                    }
                    switch (akVar.field_status) {
                        case 0:
                            i3 = -1;
                            break;
                        case 1:
                            i3 = R.raw.msg_state_sending;
                            break;
                        case 2:
                            i3 = -1;
                            break;
                        case 5:
                            i3 = R.raw.msg_state_failed;
                            break;
                        default:
                            i3 = -1;
                            break;
                    }
                    aVar2.zrJ = i3;
                    this.yDY.put(akVar.field_username + akVar.field_content, aVar2);
                    aVar = aVar2;
                }
                cVar.jJU.setTextColor(this.yDX[i2]);
                cVar.ejp.setText(aVar.nickName);
                cVar.jJT.setText(aVar.zrH);
                cVar.jJU.setText(j.b(this.context, aVar.zrI.toString(), cVar.jJU.getTextSize()));
                if (akVar.field_conversationTime != 0) {
                    cVar.jJT.setVisibility(8);
                } else {
                    cVar.jJT.setVisibility(0);
                }
                cVar.yEf.setVisibility(8);
                if (t.kH(akVar.field_username)) {
                    aw.ZK();
                    ad aoO = com.tencent.mm.model.c.XM().aoO(akVar.field_username);
                    if (aoO != null && aoO.dua == 0) {
                        cVar.yEf.setVisibility(0);
                    }
                }
                com.tencent.mm.pluginsdk.ui.a.b.b(cVar.ejo, akVar.field_username);
                if (this.zrm) {
                    if (akVar.field_unReadCount > 100) {
                        cVar.jJV.setText("...");
                        cVar.jJV.setVisibility(0);
                    } else if (akVar.field_unReadCount > 0) {
                        cVar.jJV.setText(akVar.field_unReadCount);
                        cVar.jJV.setVisibility(0);
                    } else {
                        cVar.jJV.setVisibility(4);
                    }
                }
                if (aw.RK()) {
                    if (!t.a(akVar)) {
                        aw.ZK();
                        if (com.tencent.mm.model.c.XR().g(akVar)) {
                            aw.ZK();
                            com.tencent.mm.model.c.XR().f(akVar);
                        }
                    }
                    aw.ZK();
                    if (com.tencent.mm.model.c.XR().g(akVar)) {
                        view.findViewById(R.id.b6c).setBackgroundResource(R.drawable.k4);
                    } else {
                        view.findViewById(R.id.b6c).setBackgroundResource(R.drawable.k5);
                    }
                }
                szVar = new sz();
                szVar.cPf.cPh = true;
                com.tencent.mm.sdk.b.a.xxA.m(szVar);
                if (!(0 == com.tencent.mm.plugin.messenger.foundation.a.a.a.a(akVar, 7, 0) || akVar.field_username.equals(szVar.cPg.cPj))) {
                    akVar.eE(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(akVar, 6, akVar.field_conversationTime));
                    aw.ZK();
                    com.tencent.mm.model.c.XR().a(akVar, akVar.field_username);
                }
                if (g.fUs == null && g.fUs.tN(akVar.field_username)) {
                    cVar.yEg.setVisibility(0);
                    if (akVar.field_username.equals(szVar.cPg.cPj)) {
                        cVar.yEg.setImageResource(R.raw.talk_room_mic_speaking);
                    } else {
                        cVar.yEg.setImageResource(R.raw.talk_room_mic_idle);
                    }
                } else {
                    cVar.yEg.setVisibility(8);
                }
                AppMethodBeat.o(35311);
                return view;
            }
        }
        i2 = 0;
        if (view != null) {
        }
        aVar = (a) this.yDY.get(akVar.field_username + akVar.field_content);
        if (aVar == null) {
        }
        cVar.jJU.setTextColor(this.yDX[i2]);
        cVar.ejp.setText(aVar.nickName);
        cVar.jJT.setText(aVar.zrH);
        cVar.jJU.setText(j.b(this.context, aVar.zrI.toString(), cVar.jJU.getTextSize()));
        if (akVar.field_conversationTime != 0) {
        }
        cVar.yEf.setVisibility(8);
        if (t.kH(akVar.field_username)) {
        }
        com.tencent.mm.pluginsdk.ui.a.b.b(cVar.ejo, akVar.field_username);
        if (this.zrm) {
        }
        if (aw.RK()) {
        }
        szVar = new sz();
        szVar.cPf.cPh = true;
        com.tencent.mm.sdk.b.a.xxA.m(szVar);
        akVar.eE(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(akVar, 6, akVar.field_conversationTime));
        aw.ZK();
        com.tencent.mm.model.c.XR().a(akVar, akVar.field_username);
        if (g.fUs == null) {
        }
        cVar.yEg.setVisibility(8);
        AppMethodBeat.o(35311);
        return view;
    }

    private static int FB(String str) {
        int i = 1;
        AppMethodBeat.i(35312);
        if (str != null && str.length() > 0) {
            try {
                i = Integer.valueOf(str).intValue();
            } catch (NumberFormatException e) {
            }
        }
        AppMethodBeat.o(35312);
        return i;
    }

    public final void a(String str, m mVar) {
        AppMethodBeat.i(35313);
        if (str != null && !str.equals("") && this.yDY != null) {
            this.yDY.remove(str);
        } else if (this.yDY != null) {
            this.yDY.clear();
        }
        super.a(str, mVar);
        AppMethodBeat.o(35313);
    }

    public final void vM(String str) {
        AppMethodBeat.i(35314);
        this.gtX = str;
        bIf();
        KC();
        AppMethodBeat.o(35314);
    }
}

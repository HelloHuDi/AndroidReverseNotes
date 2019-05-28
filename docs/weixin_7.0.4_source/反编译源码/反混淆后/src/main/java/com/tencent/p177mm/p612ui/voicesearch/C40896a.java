package com.tencent.p177mm.p612ui.voicesearch;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.booter.notification.p841a.C37622h;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvoice.C42230n;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p203bg.C32337g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C42062sz;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.p612ui.C46692p.C30723a;
import com.tencent.p177mm.p612ui.applet.C36043b;
import com.tencent.p177mm.p612ui.applet.C36043b.C23577b;
import com.tencent.p177mm.p612ui.applet.C36043b.C5234a;
import com.tencent.p177mm.p612ui.tools.C44385r;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C43298a;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5140bq;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressLint({"DefaultLocale"})
/* renamed from: com.tencent.mm.ui.voicesearch.a */
public final class C40896a extends C46692p<C7617ak> {
    protected List<String> elZ = null;
    private String gtX;
    private C36043b gvm = new C36043b(new C408981());
    private C23577b gvn = null;
    private ColorStateList[] yDX = new ColorStateList[2];
    private HashMap<String, C24077a> yDY;
    private C24078b zLp;
    private boolean zrm = true;

    /* renamed from: com.tencent.mm.ui.voicesearch.a$a */
    class C24077a {
        public CharSequence nickName;
        public CharSequence zrH;
        public CharSequence zrI;
        public int zrJ;

        private C24077a() {
        }

        /* synthetic */ C24077a(C40896a c40896a, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.ui.voicesearch.a$b */
    public interface C24078b {
    }

    /* renamed from: com.tencent.mm.ui.voicesearch.a$c */
    public static class C24079c {
        public ImageView ejo;
        public TextView ejp;
        public TextView jJT;
        public TextView jJU;
        public TextView jJV;
        public ImageView yEf;
        public ImageView yEg;
    }

    /* renamed from: com.tencent.mm.ui.voicesearch.a$2 */
    class C408972 implements C23577b {
        C408972() {
        }

        /* renamed from: mW */
        public final String mo11090mW(int i) {
            AppMethodBeat.m2504i(35305);
            if (i < 0 || i >= C40896a.this.getCount()) {
                C4990ab.m7412e("MicroMsg.SearchConversationAdapter", "pos is invalid");
                AppMethodBeat.m2505o(35305);
                return null;
            }
            C7617ak c7617ak = (C7617ak) C40896a.this.getItem(i);
            if (c7617ak == null) {
                AppMethodBeat.m2505o(35305);
                return null;
            }
            String str = c7617ak.field_username;
            AppMethodBeat.m2505o(35305);
            return str;
        }

        public final int apO() {
            AppMethodBeat.m2504i(35306);
            int count = C40896a.this.getCount();
            AppMethodBeat.m2505o(35306);
            return count;
        }
    }

    /* renamed from: com.tencent.mm.ui.voicesearch.a$1 */
    class C408981 implements C5234a {
        C408981() {
        }

        /* renamed from: wd */
        public final Bitmap mo10738wd(String str) {
            AppMethodBeat.m2504i(35304);
            Bitmap a = C41730b.m73490a(str, false, -1);
            AppMethodBeat.m2505o(35304);
            return a;
        }
    }

    public C40896a(Context context, C30723a c30723a) {
        super(context, new C7617ak());
        AppMethodBeat.m2504i(35307);
        super.mo74992a(c30723a);
        this.yDX[0] = C1338a.m2870h(context, (int) C25738R.color.a7x);
        this.yDX[1] = C1338a.m2870h(context, (int) C25738R.color.a7y);
        this.yDY = new HashMap();
        AppMethodBeat.m2505o(35307);
    }

    /* renamed from: fl */
    public final void mo64499fl(List<String> list) {
        AppMethodBeat.m2504i(35308);
        this.elZ = list;
        mo5248a(null, null);
        AppMethodBeat.m2505o(35308);
    }

    /* renamed from: KD */
    public final void mo6870KD() {
        AppMethodBeat.m2504i(35309);
        mo6869KC();
        AppMethodBeat.m2505o(35309);
    }

    /* renamed from: KC */
    public final void mo6869KC() {
        AppMethodBeat.m2504i(35310);
        Cursor[] cursorArr = new Cursor[2];
        cursorArr[0] = C9638aw.m17190ZK().fkd.mo44190b(C1855t.fkP, this.elZ, this.gtX);
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        if (this.elZ != null && this.elZ.size() > 0) {
            arrayList.addAll(this.elZ);
        }
        while (cursorArr[0].moveToNext()) {
            try {
                String string = cursorArr[0].getString(cursorArr[0].getColumnIndex("username"));
                arrayList.add(string);
                if (!C1855t.m3896kH(string)) {
                    arrayList2.add(string);
                }
                C4990ab.m7410d("MicroMsg.SearchConversationAdapter", "block user ".concat(String.valueOf(string)));
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.SearchConversationAdapter", e, "", new Object[0]);
            }
        }
        cursorArr[1] = C9638aw.m17190ZK().fke.mo20973a(this.gtX, "@micromsg.with.all.biz.qq.com", arrayList, arrayList2);
        setCursor(new MergeCursor(cursorArr));
        if (!(this.zLp == null || this.gtX == null)) {
            getCursor().getCount();
        }
        super.notifyDataSetChanged();
        AppMethodBeat.m2505o(35310);
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
        C24079c c24079c;
        C24077a c24077a;
        C42062sz c42062sz;
        AppMethodBeat.m2504i(35311);
        if (this.gvn == null) {
            this.gvn = new C408972();
        }
        if (this.gvm != null) {
            this.gvm.mo56803a(i, this.gvn);
        }
        C7617ak c7617ak = (C7617ak) getItem(i);
        if (C40896a.m70886FB(c7617ak.field_msgType) == 34 && c7617ak.field_isSend == 0 && !C42252ah.isNullOrNil(c7617ak.field_content)) {
            String str = c7617ak.field_content;
            if (c7617ak.field_username.equals("qmessage") || c7617ak.field_username.equals("floatbottle")) {
                String[] split = str.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                if (split != null && split.length > 3) {
                    str = split[1] + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + split[2] + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + split[3];
                }
            }
            if (!new C42230n(str).fWX) {
                i2 = 1;
                if (view != null) {
                    c24079c = new C24079c();
                    view = View.inflate(this.context, 2130970567, null);
                    c24079c.ejo = (ImageView) view.findViewById(2131821183);
                    c24079c.ejp = (TextView) view.findViewById(2131823149);
                    c24079c.jJT = (TextView) view.findViewById(2131823150);
                    c24079c.jJU = (TextView) view.findViewById(2131823151);
                    c24079c.jJV = (TextView) view.findViewById(2131821067);
                    c24079c.jJV.setBackgroundResource(C44385r.m80243ik(this.context));
                    c24079c.yEf = (ImageView) view.findViewById(2131823153);
                    c24079c.yEg = (ImageView) view.findViewById(2131823154);
                    view.setTag(c24079c);
                } else {
                    c24079c = (C24079c) view.getTag();
                }
                c24077a = (C24077a) this.yDY.get(c7617ak.field_username + c7617ak.field_content);
                if (c24077a == null) {
                    CharSequence string;
                    int i3;
                    C24077a c24077a2 = new C24077a(this, (byte) 0);
                    c24077a2.nickName = C44089j.m79293b(this.context, C1854s.m3866mJ(c7617ak.field_username), c24079c.ejp.getTextSize());
                    if (c7617ak.field_status == 1) {
                        string = this.context.getString(C25738R.string.cw8);
                    } else if (c7617ak.field_conversationTime == Long.MAX_VALUE) {
                        string = "";
                    } else {
                        string = C14835h.m23089c(this.context, c7617ak.field_conversationTime, true);
                    }
                    c24077a2.zrH = string;
                    int textSize = (int) c24079c.jJU.getTextSize();
                    int YD = C1853r.m3822YD();
                    String str2 = c7617ak.field_username;
                    C9638aw.m17190ZK();
                    Object obj = C42252ah.m74624h((Integer) C18628c.m29072Ry().get(17, null)) == 1 ? 1 : null;
                    if (str2.equals("qqmail") && obj == null) {
                        string = this.context.getString(C25738R.string.e_7);
                    } else {
                        C9638aw.m17190ZK();
                        C5140bq RA = C18628c.m29086XU().mo15356RA("@t.qq.com");
                        obj = (RA == null || !RA.isEnable()) ? null : 1;
                        if (str2.equals("tmessage") && obj == null) {
                            string = this.context.getString(C25738R.string.e_7);
                        } else {
                            obj = (YD & 64) != 0 ? 1 : null;
                            if (str2.equals("qmessage") && obj == null) {
                                string = this.context.getString(C25738R.string.e_7);
                            } else {
                                string = C44089j.m79294b(this.context, C37622h.m63519a(c7617ak.field_isSend, c7617ak.field_username, c7617ak.field_content, C40896a.m70886FB(c7617ak.field_msgType), this.context), textSize);
                            }
                        }
                    }
                    c24077a2.zrI = string;
                    if (C1855t.m3896kH(c7617ak.field_username) && C37921n.m64060mA(c7617ak.field_username) == 0) {
                        c24077a2.nickName = this.context.getString(C25738R.string.ao1);
                    }
                    switch (c7617ak.field_status) {
                        case 0:
                            i3 = -1;
                            break;
                        case 1:
                            i3 = C1318a.msg_state_sending;
                            break;
                        case 2:
                            i3 = -1;
                            break;
                        case 5:
                            i3 = C1318a.msg_state_failed;
                            break;
                        default:
                            i3 = -1;
                            break;
                    }
                    c24077a2.zrJ = i3;
                    this.yDY.put(c7617ak.field_username + c7617ak.field_content, c24077a2);
                    c24077a = c24077a2;
                }
                c24079c.jJU.setTextColor(this.yDX[i2]);
                c24079c.ejp.setText(c24077a.nickName);
                c24079c.jJT.setText(c24077a.zrH);
                c24079c.jJU.setText(C44089j.m79293b(this.context, c24077a.zrI.toString(), c24079c.jJU.getTextSize()));
                if (c7617ak.field_conversationTime != 0) {
                    c24079c.jJT.setVisibility(8);
                } else {
                    c24079c.jJT.setVisibility(0);
                }
                c24079c.yEf.setVisibility(8);
                if (C1855t.m3896kH(c7617ak.field_username)) {
                    C9638aw.m17190ZK();
                    C7616ad aoO = C18628c.m29078XM().aoO(c7617ak.field_username);
                    if (aoO != null && aoO.dua == 0) {
                        c24079c.yEf.setVisibility(0);
                    }
                }
                C40460b.m69434b(c24079c.ejo, c7617ak.field_username);
                if (this.zrm) {
                    if (c7617ak.field_unReadCount > 100) {
                        c24079c.jJV.setText("...");
                        c24079c.jJV.setVisibility(0);
                    } else if (c7617ak.field_unReadCount > 0) {
                        c24079c.jJV.setText(c7617ak.field_unReadCount);
                        c24079c.jJV.setVisibility(0);
                    } else {
                        c24079c.jJV.setVisibility(4);
                    }
                }
                if (C9638aw.m17179RK()) {
                    if (!C1855t.m3881a(c7617ak)) {
                        C9638aw.m17190ZK();
                        if (C18628c.m29083XR().mo15822g(c7617ak)) {
                            C9638aw.m17190ZK();
                            C18628c.m29083XR().mo15821f(c7617ak);
                        }
                    }
                    C9638aw.m17190ZK();
                    if (C18628c.m29083XR().mo15822g(c7617ak)) {
                        view.findViewById(2131823147).setBackgroundResource(C25738R.drawable.f6622k4);
                    } else {
                        view.findViewById(2131823147).setBackgroundResource(C25738R.drawable.f6623k5);
                    }
                }
                c42062sz = new C42062sz();
                c42062sz.cPf.cPh = true;
                C4879a.xxA.mo10055m(c42062sz);
                if (!(0 == C43298a.m77176a(c7617ak, 7, 0) || c7617ak.field_username.equals(c42062sz.cPg.cPj))) {
                    c7617ak.mo14743eE(C43298a.m77176a(c7617ak, 6, c7617ak.field_conversationTime));
                    C9638aw.m17190ZK();
                    C18628c.m29083XR().mo15767a(c7617ak, c7617ak.field_username);
                }
                if (C32337g.fUs == null && C32337g.fUs.mo4625tN(c7617ak.field_username)) {
                    c24079c.yEg.setVisibility(0);
                    if (c7617ak.field_username.equals(c42062sz.cPg.cPj)) {
                        c24079c.yEg.setImageResource(C1318a.talk_room_mic_speaking);
                    } else {
                        c24079c.yEg.setImageResource(C1318a.talk_room_mic_idle);
                    }
                } else {
                    c24079c.yEg.setVisibility(8);
                }
                AppMethodBeat.m2505o(35311);
                return view;
            }
        }
        i2 = 0;
        if (view != null) {
        }
        c24077a = (C24077a) this.yDY.get(c7617ak.field_username + c7617ak.field_content);
        if (c24077a == null) {
        }
        c24079c.jJU.setTextColor(this.yDX[i2]);
        c24079c.ejp.setText(c24077a.nickName);
        c24079c.jJT.setText(c24077a.zrH);
        c24079c.jJU.setText(C44089j.m79293b(this.context, c24077a.zrI.toString(), c24079c.jJU.getTextSize()));
        if (c7617ak.field_conversationTime != 0) {
        }
        c24079c.yEf.setVisibility(8);
        if (C1855t.m3896kH(c7617ak.field_username)) {
        }
        C40460b.m69434b(c24079c.ejo, c7617ak.field_username);
        if (this.zrm) {
        }
        if (C9638aw.m17179RK()) {
        }
        c42062sz = new C42062sz();
        c42062sz.cPf.cPh = true;
        C4879a.xxA.mo10055m(c42062sz);
        c7617ak.mo14743eE(C43298a.m77176a(c7617ak, 6, c7617ak.field_conversationTime));
        C9638aw.m17190ZK();
        C18628c.m29083XR().mo15767a(c7617ak, c7617ak.field_username);
        if (C32337g.fUs == null) {
        }
        c24079c.yEg.setVisibility(8);
        AppMethodBeat.m2505o(35311);
        return view;
    }

    /* renamed from: FB */
    private static int m70886FB(String str) {
        int i = 1;
        AppMethodBeat.m2504i(35312);
        if (str != null && str.length() > 0) {
            try {
                i = Integer.valueOf(str).intValue();
            } catch (NumberFormatException e) {
            }
        }
        AppMethodBeat.m2505o(35312);
        return i;
    }

    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
        AppMethodBeat.m2504i(35313);
        if (str != null && !str.equals("") && this.yDY != null) {
            this.yDY.remove(str);
        } else if (this.yDY != null) {
            this.yDY.clear();
        }
        super.mo5248a(str, c4935m);
        AppMethodBeat.m2505o(35313);
    }

    /* renamed from: vM */
    public final void mo64501vM(String str) {
        AppMethodBeat.m2504i(35314);
        this.gtX = str;
        bIf();
        mo6869KC();
        AppMethodBeat.m2505o(35314);
    }
}

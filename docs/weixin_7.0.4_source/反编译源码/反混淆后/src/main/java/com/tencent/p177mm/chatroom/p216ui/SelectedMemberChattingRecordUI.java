package com.tencent.p177mm.chatroom.p216ui;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.memory.p259a.C7598c;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.modelvoice.C32850q;
import com.tencent.p177mm.modelvoice.C42230n;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.MMLoadMoreListView;
import com.tencent.p177mm.p612ui.base.MMLoadMoreListView.C36055a;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.p177mm.plugin.appbrand.jsapi.p304e.C2275g;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.p1338b.p1339a.C44099c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C7575bv;
import com.tencent.p177mm.storage.C7577u;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.C7620bi.C5135a;
import com.tencent.p177mm.storage.C7620bi.C5138d;
import com.tencent.view.C31128d;
import java.util.Map;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.mm.chatroom.ui.SelectedMemberChattingRecordUI */
public class SelectedMemberChattingRecordUI extends MMActivity {
    private static final C1177f<Integer, C44099c> emX = new C7598c(32);
    private String ejD;
    private MMLoadMoreListView emT;
    private C18163a emU;
    private String emV;
    private int emW = 0;
    private View emy;
    private String mTitle;

    /* renamed from: com.tencent.mm.chatroom.ui.SelectedMemberChattingRecordUI$a */
    public class C18163a extends C46692p<C7620bi> {
        String emZ;
        String emo;
        int ena = -1;
        int enb = -1;
        private C7577u enc;
        Context mContext;

        public C18163a(Context context, String str, String str2, int i) {
            super(context, new C7620bi());
            AppMethodBeat.m2504i(104439);
            this.mContext = context;
            this.enb = i;
            this.emo = str;
            this.emZ = str2;
            this.enc = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14886ob(SelectedMemberChattingRecordUI.this.ejD);
            AppMethodBeat.m2505o(104439);
        }

        /* renamed from: KC */
        public final void mo6869KC() {
            AppMethodBeat.m2504i(104440);
            if (this.ena < 0 || this.ena > this.enb) {
                this.ena = this.enb - 16;
            }
            if (C5046bo.isNullOrNil(SelectedMemberChattingRecordUI.this.emV) || !C1853r.m3858mG(SelectedMemberChattingRecordUI.this.emV)) {
                if (!C1853r.m3858mG(SelectedMemberChattingRecordUI.this.emV)) {
                    setCursor(((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15238G(this.emo, this.emZ, this.enb - this.ena));
                }
                AppMethodBeat.m2505o(104440);
                return;
            }
            setCursor(((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15317cB(this.emo, this.enb - this.ena));
            AppMethodBeat.m2505o(104440);
        }

        /* renamed from: KD */
        public final void mo6870KD() {
            AppMethodBeat.m2504i(104441);
            mo6869KC();
            AppMethodBeat.m2505o(104441);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C18164b c18164b;
            String a;
            CharSequence Oi;
            AppMethodBeat.m2504i(104442);
            if (view == null) {
                view = LayoutInflater.from(this.context).inflate(2130970081, null, false);
                c18164b = new C18164b();
                c18164b.ejo = (ImageView) view.findViewById(2131821183);
                c18164b.ejp = (TextView) view.findViewById(2131823149);
                c18164b.ene = (TextView) view.findViewById(2131822913);
                c18164b.enf = (TextView) view.findViewById(2131823150);
                view.setTag(c18164b);
            }
            C7620bi c7620bi = (C7620bi) getItem(i);
            c18164b = (C18164b) view.getTag();
            C40460b.m69434b(c18164b.ejo, this.emZ);
            C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.emZ);
            if (C5046bo.isNullOrNil(aoO.field_conRemark)) {
                a = SelectedMemberChattingRecordUI.m74058a(this.enc, aoO.field_username);
            } else {
                a = aoO.field_conRemark;
            }
            if (C5046bo.isNullOrNil(a)) {
                Oi = aoO.mo16706Oi();
            } else {
                Object Oi2 = a;
            }
            if (!C7486a.m12942jh(aoO.field_type)) {
                C7575bv RB = ((C6982j) C1720g.m3528K(C6982j.class)).mo15370XN().mo15364RB(aoO.field_username);
                if (!(RB == null || C5046bo.isNullOrNil(RB.field_conRemark))) {
                    Oi2 = RB.field_conRemark;
                }
            }
            C18163a.m28604a(Oi2, c18164b.ejp);
            C18163a.m28604a(SelectedMemberChattingRecordUI.m74057a(C4996ah.getContext(), c7620bi.getType(), c7620bi.field_content, this.emZ, c7620bi.field_isSend).trim(), c18164b.ene);
            C18163a.m28604a(C14835h.m23089c(SelectedMemberChattingRecordUI.this, c7620bi.field_createTime, true), c18164b.enf);
            AppMethodBeat.m2505o(104442);
            return view;
        }

        /* renamed from: a */
        private static boolean m28604a(CharSequence charSequence, TextView textView) {
            AppMethodBeat.m2504i(104443);
            if (charSequence == null || charSequence.length() == 0) {
                textView.setVisibility(8);
                AppMethodBeat.m2505o(104443);
                return false;
            }
            textView.setText(C44089j.m79292b(textView.getContext(), charSequence));
            textView.setVisibility(0);
            AppMethodBeat.m2505o(104443);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.SelectedMemberChattingRecordUI$b */
    static class C18164b {
        public ImageView ejo;
        public TextView ejp;
        public TextView ene;
        public TextView enf;

        private C18164b() {
        }

        /* synthetic */ C18164b(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.SelectedMemberChattingRecordUI$1 */
    class C376511 implements OnItemClickListener {
        C376511() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(104436);
            C7620bi c7620bi = (C7620bi) SelectedMemberChattingRecordUI.this.emU.getItem(i);
            if (c7620bi != null) {
                SelectedMemberChattingRecordUI.m74059a(SelectedMemberChattingRecordUI.this, c7620bi.field_msgId);
            }
            AppMethodBeat.m2505o(104436);
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.SelectedMemberChattingRecordUI$3 */
    class C376523 implements OnMenuItemClickListener {
        C376523() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(104438);
            SelectedMemberChattingRecordUI.this.setResult(0);
            SelectedMemberChattingRecordUI.this.finish();
            AppMethodBeat.m2505o(104438);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.SelectedMemberChattingRecordUI$2 */
    class C419282 implements C36055a {
        C419282() {
        }

        /* renamed from: KB */
        public final void mo8166KB() {
            AppMethodBeat.m2504i(104437);
            if (SelectedMemberChattingRecordUI.this.emU != null) {
                C18163a a = SelectedMemberChattingRecordUI.this.emU;
                a.ena -= 16;
                if (!C5046bo.isNullOrNil(SelectedMemberChattingRecordUI.this.emV) && C1853r.m3858mG(SelectedMemberChattingRecordUI.this.emV)) {
                    a.setCursor(((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15317cB(a.emo, a.enb - a.ena));
                } else if (!C1853r.m3858mG(SelectedMemberChattingRecordUI.this.emV)) {
                    a.setCursor(((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15238G(a.emo, a.emZ, a.enb - a.ena));
                }
                SelectedMemberChattingRecordUI.this.emU.notifyDataSetChanged();
            }
            AppMethodBeat.m2505o(104437);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(104445);
        super.onCreate(bundle);
        C4990ab.m7416i("MicroMsg.SelectedMemberChattingRecordUI", "[onCreate]");
        this.ejD = getIntent().getStringExtra("RoomInfo_Id");
        this.emV = getIntent().getStringExtra("room_member");
        C4990ab.m7417i("MicroMsg.SelectedMemberChattingRecordUI", "roomId:%s", this.ejD);
        this.mTitle = getIntent().getStringExtra("title");
        if (!C5046bo.isNullOrNil(this.emV) && C1853r.m3858mG(this.emV)) {
            this.emW = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15269Rw(this.ejD);
        } else if (!C1853r.m3858mG(this.emV)) {
            this.emW = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15333fc(this.ejD, this.emV);
        }
        initView();
        AppMethodBeat.m2505o(104445);
    }

    /* renamed from: KA */
    private boolean m74055KA() {
        return this.emW == 0;
    }

    public final void initView() {
        AppMethodBeat.m2504i(104446);
        super.initView();
        setMMTitle(C5046bo.nullAsNil(this.mTitle));
        this.emT = (MMLoadMoreListView) findViewById(2131827317);
        this.emT.dzN();
        this.emU = new C18163a(this, this.ejD, this.emV, this.emW);
        this.emT.setAdapter(this.emU);
        this.emy = findViewById(2131827318);
        if (m74055KA()) {
            this.emy.setVisibility(0);
            this.emT.setVisibility(8);
        }
        this.emT.setOnItemClickListener(new C376511());
        this.emT.setOnLoadMoreListener(new C419282());
        setBackBtn(new C376523());
        AppMethodBeat.m2505o(104446);
    }

    /* renamed from: a */
    protected static String m74058a(C7577u c7577u, String str) {
        AppMethodBeat.m2504i(104447);
        if (c7577u == null) {
            AppMethodBeat.m2505o(104447);
            return null;
        }
        String mJ = c7577u.mo16807mJ(str);
        AppMethodBeat.m2505o(104447);
        return mJ;
    }

    public final int getLayoutId() {
        return 2130970596;
    }

    /* renamed from: a */
    public static String m74057a(Context context, int i, String str, String str2, int i2) {
        AppMethodBeat.m2504i(104448);
        String str3 = "";
        C8910b me = C8910b.m16064me(str);
        switch (i) {
            case -1879048186:
                str3 = context.getString(C25738R.string.djh, new Object[]{me.title});
                break;
            case -1879048185:
            case -1879048183:
            case -1879048176:
                str3 = context.getString(C25738R.string.dj8, new Object[]{me.title});
                break;
            case 1:
                str3 = str.substring(str.indexOf(":\n") + 1);
                break;
            case 3:
            case 23:
            case 33:
                str3 = context.getString(C25738R.string.f9199sn);
                break;
            case 34:
                str3 = context.getString(C25738R.string.djk, new Object[]{Integer.valueOf((int) C32850q.m53722fY(new C42230n(str).time))});
                break;
            case C2275g.CTRL_INDEX /*37*/:
                if (str != null && str.length() > 0) {
                    C5138d apF = C5138d.apF(str);
                    if (apF.svN != null && apF.svN.length() > 0) {
                        switch (apF.scene) {
                            case 18:
                                str3 = context.getString(C25738R.string.byj, new Object[]{apF.getDisplayName()});
                                break;
                            case 22:
                            case 23:
                            case 24:
                            case 26:
                            case 27:
                            case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                            case 29:
                                str3 = context.getString(C25738R.string.byt, new Object[]{apF.getDisplayName()});
                                break;
                            case 25:
                                str3 = context.getString(C25738R.string.bwp, new Object[]{apF.getDisplayName()});
                                break;
                            default:
                                str3 = context.getString(C25738R.string.bz2, new Object[]{apF.getDisplayName()});
                                break;
                        }
                    }
                }
            case 42:
            case 66:
                if (C5046bo.nullAsNil(str).length() > 0) {
                    str3 = C1829bf.m3762oy(str);
                    if (!TextUtils.isEmpty(str3)) {
                        str2 = str3;
                    }
                    C5135a Rn = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15260Rn(str);
                    str3 = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str2).mo16707Oj();
                    if (C1855t.m3896kH(str3)) {
                        str3 = C37921n.m64045T(C37921n.m64061mB(str3));
                    }
                    if (i2 != 1) {
                        str3 = context.getString(C25738R.string.bwr, new Object[]{str3, Rn.getDisplayName()});
                        break;
                    }
                    str3 = context.getString(C25738R.string.bwq, new Object[]{str3, Rn.getDisplayName()});
                    break;
                }
                break;
            case 43:
            case 62:
                str3 = context.getString(62 == i ? C25738R.string.f9230tp : C25738R.string.f9253ud);
                break;
            case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                str3 = context.getString(C25738R.string.f9100ph);
                break;
            case 48:
                str3 = context.getString(C25738R.string.djc, new Object[]{((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15261Ro(str).label});
                break;
            case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                if (me != null) {
                    switch (me.type) {
                        case 2:
                            str3 = context.getString(C25738R.string.f9199sn);
                            break;
                        case 3:
                            str3 = context.getString(C25738R.string.djd, new Object[]{me.title});
                            break;
                        case 4:
                            str3 = context.getString(C25738R.string.djj, new Object[]{me.title});
                            break;
                        case 5:
                            str3 = context.getString(C25738R.string.dji, new Object[]{me.getTitle()});
                            break;
                        case 6:
                            str3 = context.getString(C25738R.string.djb, new Object[]{me.title});
                            break;
                        case 7:
                            break;
                        case 8:
                            str3 = context.getString(C25738R.string.f9101pi);
                            break;
                        case 15:
                        case 26:
                        case 27:
                            str3 = context.getString(C25738R.string.f9100ph);
                            break;
                        case 17:
                            str3 = context.getString(C25738R.string.djc, new Object[]{me.title});
                            break;
                        case 19:
                            str3 = context.getString(C25738R.string.djf, new Object[]{me.title});
                            break;
                        case 24:
                            C44099c c44099c;
                            String str4 = me.fgU;
                            if (C5046bo.isNullOrNil(str4)) {
                                C4990ab.m7412e("MicroMsg.SelectedMemberChattingRecordUI", "xml is null");
                                c44099c = null;
                            } else {
                                int hashCode = str4.hashCode();
                                c44099c = (C44099c) emX.get(Integer.valueOf(hashCode));
                                if (c44099c != null) {
                                    C4990ab.m7410d("MicroMsg.SelectedMemberChattingRecordUI", "get record msg data from cache");
                                } else {
                                    Map z;
                                    if (str4.trim().startsWith("<recordinfo>")) {
                                        z = C5049br.m7595z(str4, "recordinfo");
                                    } else {
                                        z = C5049br.m7595z("<recordinfo>" + str4 + "</recordinfo>", "recordinfo");
                                    }
                                    if (z == null) {
                                        C4990ab.m7413e("MicroMsg.SelectedMemberChattingRecordUI", "values is null: %s", str4);
                                        c44099c = null;
                                    } else {
                                        C44099c c44099c2 = new C44099c();
                                        c44099c2.title = (String) z.get(".recordinfo.title");
                                        c44099c2.desc = (String) z.get(".recordinfo.desc");
                                        c44099c2.vzJ = (String) z.get(".recordinfo.favusername");
                                        emX.put(Integer.valueOf(hashCode), c44099c2);
                                        c44099c = c44099c2;
                                    }
                                }
                            }
                            str3 = c44099c == null ? "" : c44099c.desc;
                            str3 = context.getString(C25738R.string.dje, new Object[]{C5046bo.m7532bc(str3, "")});
                            break;
                        case 25:
                            str3 = context.getString(C25738R.string.f9090p6);
                            break;
                        default:
                            str3 = "";
                            break;
                    }
                }
                C4990ab.m7412e("MicroMsg.SelectedMemberChattingRecordUI", "decode msg content failed");
                str3 = "";
                AppMethodBeat.m2505o(104448);
                return str3;
            case 369098801:
            case 452984881:
                str3 = context.getString(C25738R.string.dj_, new Object[]{me.title});
                break;
            case 419430449:
                str3 = context.getString(C25738R.string.djg);
                if (me != null) {
                    int i3 = i2 == 1 ? 1 : 0;
                    switch (me.fhv) {
                        case 1:
                            if (i3 == 0) {
                                str3 = context.getString(C25738R.string.f9336x0);
                                break;
                            }
                            str3 = context.getString(C25738R.string.f9333wx);
                            break;
                        case 3:
                            if (i3 == 0) {
                                str3 = context.getString(C25738R.string.f9331wv);
                                break;
                            }
                            str3 = context.getString(C25738R.string.f9334wy);
                            break;
                        case 4:
                            if (i3 == 0) {
                                str3 = context.getString(C25738R.string.f9332ww);
                                break;
                            }
                            str3 = context.getString(C25738R.string.f9335wz);
                            break;
                        default:
                            str3 = C5046bo.nullAsNil(me.title);
                            break;
                    }
                }
                break;
            case 436207665:
            case 469762097:
                if (me != null) {
                    if (i2 != 1) {
                        str3 = context.getString(C25738R.string.dj9, new Object[]{me.fhW, me.fhS});
                        break;
                    }
                    str3 = context.getString(C25738R.string.dj9, new Object[]{me.fhW, me.fhT});
                    break;
                }
                C4990ab.m7412e("MicroMsg.SelectedMemberChattingRecordUI", "decode msg content failed");
                str3 = "";
                AppMethodBeat.m2505o(104448);
                return str3;
            case 503316529:
                if (me != null) {
                    if (i2 != 1) {
                        str3 = context.getString(C25738R.string.dj9, new Object[]{me.fhW, me.fij});
                        break;
                    }
                    str3 = context.getString(C25738R.string.dj9, new Object[]{me.fhW, me.fik});
                    break;
                }
                C4990ab.m7412e("MicroMsg.SelectedMemberChattingRecordUI", "decode msg content failed");
                str3 = "";
                AppMethodBeat.m2505o(104448);
                return str3;
            case 520093745:
                str3 = context.getString(C25738R.string.dj_, new Object[]{""});
                break;
        }
        AppMethodBeat.m2505o(104448);
        return str3;
    }

    static {
        AppMethodBeat.m2504i(104450);
        AppMethodBeat.m2505o(104450);
    }
}

package com.tencent.mm.chatroom.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.d;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.p;
import java.util.Map;
import org.xwalk.core.XWalkEnvironment;

public class SelectedMemberChattingRecordUI extends MMActivity {
    private static final f<Integer, c> emX = new com.tencent.mm.memory.a.c(32);
    private String ejD;
    private MMLoadMoreListView emT;
    private a emU;
    private String emV;
    private int emW = 0;
    private View emy;
    private String mTitle;

    public class a extends p<bi> {
        String emZ;
        String emo;
        int ena = -1;
        int enb = -1;
        private u enc;
        Context mContext;

        public a(Context context, String str, String str2, int i) {
            super(context, new bi());
            AppMethodBeat.i(104439);
            this.mContext = context;
            this.enb = i;
            this.emo = str;
            this.emZ = str2;
            this.enc = ((com.tencent.mm.plugin.chatroom.a.c) g.K(com.tencent.mm.plugin.chatroom.a.c.class)).XV().ob(SelectedMemberChattingRecordUI.this.ejD);
            AppMethodBeat.o(104439);
        }

        public final void KC() {
            AppMethodBeat.i(104440);
            if (this.ena < 0 || this.ena > this.enb) {
                this.ena = this.enb - 16;
            }
            if (bo.isNullOrNil(SelectedMemberChattingRecordUI.this.emV) || !r.mG(SelectedMemberChattingRecordUI.this.emV)) {
                if (!r.mG(SelectedMemberChattingRecordUI.this.emV)) {
                    setCursor(((j) g.K(j.class)).bOr().G(this.emo, this.emZ, this.enb - this.ena));
                }
                AppMethodBeat.o(104440);
                return;
            }
            setCursor(((j) g.K(j.class)).bOr().cB(this.emo, this.enb - this.ena));
            AppMethodBeat.o(104440);
        }

        public final void KD() {
            AppMethodBeat.i(104441);
            KC();
            AppMethodBeat.o(104441);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            String a;
            CharSequence Oi;
            AppMethodBeat.i(104442);
            if (view == null) {
                view = LayoutInflater.from(this.context).inflate(R.layout.acv, null, false);
                bVar = new b();
                bVar.ejo = (ImageView) view.findViewById(R.id.qk);
                bVar.ejp = (TextView) view.findViewById(R.id.b6e);
                bVar.ene = (TextView) view.findViewById(R.id.b01);
                bVar.enf = (TextView) view.findViewById(R.id.b6f);
                view.setTag(bVar);
            }
            bi biVar = (bi) getItem(i);
            bVar = (b) view.getTag();
            com.tencent.mm.pluginsdk.ui.a.b.b(bVar.ejo, this.emZ);
            ad aoO = ((j) g.K(j.class)).XM().aoO(this.emZ);
            if (bo.isNullOrNil(aoO.field_conRemark)) {
                a = SelectedMemberChattingRecordUI.a(this.enc, aoO.field_username);
            } else {
                a = aoO.field_conRemark;
            }
            if (bo.isNullOrNil(a)) {
                Oi = aoO.Oi();
            } else {
                Object Oi2 = a;
            }
            if (!com.tencent.mm.n.a.jh(aoO.field_type)) {
                bv RB = ((j) g.K(j.class)).XN().RB(aoO.field_username);
                if (!(RB == null || bo.isNullOrNil(RB.field_conRemark))) {
                    Oi2 = RB.field_conRemark;
                }
            }
            a(Oi2, bVar.ejp);
            a(SelectedMemberChattingRecordUI.a(ah.getContext(), biVar.getType(), biVar.field_content, this.emZ, biVar.field_isSend).trim(), bVar.ene);
            a(h.c(SelectedMemberChattingRecordUI.this, biVar.field_createTime, true), bVar.enf);
            AppMethodBeat.o(104442);
            return view;
        }

        private static boolean a(CharSequence charSequence, TextView textView) {
            AppMethodBeat.i(104443);
            if (charSequence == null || charSequence.length() == 0) {
                textView.setVisibility(8);
                AppMethodBeat.o(104443);
                return false;
            }
            textView.setText(com.tencent.mm.pluginsdk.ui.e.j.b(textView.getContext(), charSequence));
            textView.setVisibility(0);
            AppMethodBeat.o(104443);
            return true;
        }
    }

    static class b {
        public ImageView ejo;
        public TextView ejp;
        public TextView ene;
        public TextView enf;

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(104445);
        super.onCreate(bundle);
        ab.i("MicroMsg.SelectedMemberChattingRecordUI", "[onCreate]");
        this.ejD = getIntent().getStringExtra("RoomInfo_Id");
        this.emV = getIntent().getStringExtra("room_member");
        ab.i("MicroMsg.SelectedMemberChattingRecordUI", "roomId:%s", this.ejD);
        this.mTitle = getIntent().getStringExtra("title");
        if (!bo.isNullOrNil(this.emV) && r.mG(this.emV)) {
            this.emW = ((j) g.K(j.class)).bOr().Rw(this.ejD);
        } else if (!r.mG(this.emV)) {
            this.emW = ((j) g.K(j.class)).bOr().fc(this.ejD, this.emV);
        }
        initView();
        AppMethodBeat.o(104445);
    }

    private boolean KA() {
        return this.emW == 0;
    }

    public final void initView() {
        AppMethodBeat.i(104446);
        super.initView();
        setMMTitle(bo.nullAsNil(this.mTitle));
        this.emT = (MMLoadMoreListView) findViewById(R.id.e83);
        this.emT.dzN();
        this.emU = new a(this, this.ejD, this.emV, this.emW);
        this.emT.setAdapter(this.emU);
        this.emy = findViewById(R.id.e84);
        if (KA()) {
            this.emy.setVisibility(0);
            this.emT.setVisibility(8);
        }
        this.emT.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(104436);
                bi biVar = (bi) SelectedMemberChattingRecordUI.this.emU.getItem(i);
                if (biVar != null) {
                    SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this, biVar.field_msgId);
                }
                AppMethodBeat.o(104436);
            }
        });
        this.emT.setOnLoadMoreListener(new com.tencent.mm.ui.base.MMLoadMoreListView.a() {
            public final void KB() {
                AppMethodBeat.i(104437);
                if (SelectedMemberChattingRecordUI.this.emU != null) {
                    a a = SelectedMemberChattingRecordUI.this.emU;
                    a.ena -= 16;
                    if (!bo.isNullOrNil(SelectedMemberChattingRecordUI.this.emV) && r.mG(SelectedMemberChattingRecordUI.this.emV)) {
                        a.setCursor(((j) g.K(j.class)).bOr().cB(a.emo, a.enb - a.ena));
                    } else if (!r.mG(SelectedMemberChattingRecordUI.this.emV)) {
                        a.setCursor(((j) g.K(j.class)).bOr().G(a.emo, a.emZ, a.enb - a.ena));
                    }
                    SelectedMemberChattingRecordUI.this.emU.notifyDataSetChanged();
                }
                AppMethodBeat.o(104437);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(104438);
                SelectedMemberChattingRecordUI.this.setResult(0);
                SelectedMemberChattingRecordUI.this.finish();
                AppMethodBeat.o(104438);
                return true;
            }
        });
        AppMethodBeat.o(104446);
    }

    protected static String a(u uVar, String str) {
        AppMethodBeat.i(104447);
        if (uVar == null) {
            AppMethodBeat.o(104447);
            return null;
        }
        String mJ = uVar.mJ(str);
        AppMethodBeat.o(104447);
        return mJ;
    }

    public final int getLayoutId() {
        return R.layout.aqr;
    }

    public static String a(Context context, int i, String str, String str2, int i2) {
        AppMethodBeat.i(104448);
        String str3 = "";
        com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(str);
        switch (i) {
            case -1879048186:
                str3 = context.getString(R.string.djh, new Object[]{me.title});
                break;
            case -1879048185:
            case -1879048183:
            case -1879048176:
                str3 = context.getString(R.string.dj8, new Object[]{me.title});
                break;
            case 1:
                str3 = str.substring(str.indexOf(":\n") + 1);
                break;
            case 3:
            case 23:
            case 33:
                str3 = context.getString(R.string.sn);
                break;
            case 34:
                str3 = context.getString(R.string.djk, new Object[]{Integer.valueOf((int) q.fY(new n(str).time))});
                break;
            case com.tencent.mm.plugin.appbrand.jsapi.e.g.CTRL_INDEX /*37*/:
                if (str != null && str.length() > 0) {
                    d apF = d.apF(str);
                    if (apF.svN != null && apF.svN.length() > 0) {
                        switch (apF.scene) {
                            case 18:
                                str3 = context.getString(R.string.byj, new Object[]{apF.getDisplayName()});
                                break;
                            case 22:
                            case 23:
                            case 24:
                            case 26:
                            case 27:
                            case com.tencent.view.d.MIC_BASE_CHANNELSHARPEN /*28*/:
                            case 29:
                                str3 = context.getString(R.string.byt, new Object[]{apF.getDisplayName()});
                                break;
                            case 25:
                                str3 = context.getString(R.string.bwp, new Object[]{apF.getDisplayName()});
                                break;
                            default:
                                str3 = context.getString(R.string.bz2, new Object[]{apF.getDisplayName()});
                                break;
                        }
                    }
                }
            case 42:
            case 66:
                if (bo.nullAsNil(str).length() > 0) {
                    str3 = bf.oy(str);
                    if (!TextUtils.isEmpty(str3)) {
                        str2 = str3;
                    }
                    com.tencent.mm.storage.bi.a Rn = ((j) g.K(j.class)).bOr().Rn(str);
                    str3 = ((j) g.K(j.class)).XM().aoO(str2).Oj();
                    if (t.kH(str3)) {
                        str3 = com.tencent.mm.model.n.T(com.tencent.mm.model.n.mB(str3));
                    }
                    if (i2 != 1) {
                        str3 = context.getString(R.string.bwr, new Object[]{str3, Rn.getDisplayName()});
                        break;
                    }
                    str3 = context.getString(R.string.bwq, new Object[]{str3, Rn.getDisplayName()});
                    break;
                }
                break;
            case 43:
            case 62:
                str3 = context.getString(62 == i ? R.string.tp : R.string.ud);
                break;
            case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                str3 = context.getString(R.string.ph);
                break;
            case 48:
                str3 = context.getString(R.string.djc, new Object[]{((j) g.K(j.class)).bOr().Ro(str).label});
                break;
            case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                if (me != null) {
                    switch (me.type) {
                        case 2:
                            str3 = context.getString(R.string.sn);
                            break;
                        case 3:
                            str3 = context.getString(R.string.djd, new Object[]{me.title});
                            break;
                        case 4:
                            str3 = context.getString(R.string.djj, new Object[]{me.title});
                            break;
                        case 5:
                            str3 = context.getString(R.string.dji, new Object[]{me.getTitle()});
                            break;
                        case 6:
                            str3 = context.getString(R.string.djb, new Object[]{me.title});
                            break;
                        case 7:
                            break;
                        case 8:
                            str3 = context.getString(R.string.pi);
                            break;
                        case 15:
                        case 26:
                        case 27:
                            str3 = context.getString(R.string.ph);
                            break;
                        case 17:
                            str3 = context.getString(R.string.djc, new Object[]{me.title});
                            break;
                        case 19:
                            str3 = context.getString(R.string.djf, new Object[]{me.title});
                            break;
                        case 24:
                            c cVar;
                            String str4 = me.fgU;
                            if (bo.isNullOrNil(str4)) {
                                ab.e("MicroMsg.SelectedMemberChattingRecordUI", "xml is null");
                                cVar = null;
                            } else {
                                int hashCode = str4.hashCode();
                                cVar = (c) emX.get(Integer.valueOf(hashCode));
                                if (cVar != null) {
                                    ab.d("MicroMsg.SelectedMemberChattingRecordUI", "get record msg data from cache");
                                } else {
                                    Map z;
                                    if (str4.trim().startsWith("<recordinfo>")) {
                                        z = br.z(str4, "recordinfo");
                                    } else {
                                        z = br.z("<recordinfo>" + str4 + "</recordinfo>", "recordinfo");
                                    }
                                    if (z == null) {
                                        ab.e("MicroMsg.SelectedMemberChattingRecordUI", "values is null: %s", str4);
                                        cVar = null;
                                    } else {
                                        c cVar2 = new c();
                                        cVar2.title = (String) z.get(".recordinfo.title");
                                        cVar2.desc = (String) z.get(".recordinfo.desc");
                                        cVar2.vzJ = (String) z.get(".recordinfo.favusername");
                                        emX.put(Integer.valueOf(hashCode), cVar2);
                                        cVar = cVar2;
                                    }
                                }
                            }
                            str3 = cVar == null ? "" : cVar.desc;
                            str3 = context.getString(R.string.dje, new Object[]{bo.bc(str3, "")});
                            break;
                        case 25:
                            str3 = context.getString(R.string.p6);
                            break;
                        default:
                            str3 = "";
                            break;
                    }
                }
                ab.e("MicroMsg.SelectedMemberChattingRecordUI", "decode msg content failed");
                str3 = "";
                AppMethodBeat.o(104448);
                return str3;
            case 369098801:
            case 452984881:
                str3 = context.getString(R.string.dj_, new Object[]{me.title});
                break;
            case 419430449:
                str3 = context.getString(R.string.djg);
                if (me != null) {
                    int i3 = i2 == 1 ? 1 : 0;
                    switch (me.fhv) {
                        case 1:
                            if (i3 == 0) {
                                str3 = context.getString(R.string.x0);
                                break;
                            }
                            str3 = context.getString(R.string.wx);
                            break;
                        case 3:
                            if (i3 == 0) {
                                str3 = context.getString(R.string.wv);
                                break;
                            }
                            str3 = context.getString(R.string.wy);
                            break;
                        case 4:
                            if (i3 == 0) {
                                str3 = context.getString(R.string.ww);
                                break;
                            }
                            str3 = context.getString(R.string.wz);
                            break;
                        default:
                            str3 = bo.nullAsNil(me.title);
                            break;
                    }
                }
                break;
            case 436207665:
            case 469762097:
                if (me != null) {
                    if (i2 != 1) {
                        str3 = context.getString(R.string.dj9, new Object[]{me.fhW, me.fhS});
                        break;
                    }
                    str3 = context.getString(R.string.dj9, new Object[]{me.fhW, me.fhT});
                    break;
                }
                ab.e("MicroMsg.SelectedMemberChattingRecordUI", "decode msg content failed");
                str3 = "";
                AppMethodBeat.o(104448);
                return str3;
            case 503316529:
                if (me != null) {
                    if (i2 != 1) {
                        str3 = context.getString(R.string.dj9, new Object[]{me.fhW, me.fij});
                        break;
                    }
                    str3 = context.getString(R.string.dj9, new Object[]{me.fhW, me.fik});
                    break;
                }
                ab.e("MicroMsg.SelectedMemberChattingRecordUI", "decode msg content failed");
                str3 = "";
                AppMethodBeat.o(104448);
                return str3;
            case 520093745:
                str3 = context.getString(R.string.dj_, new Object[]{""});
                break;
        }
        AppMethodBeat.o(104448);
        return str3;
    }

    static {
        AppMethodBeat.i(104450);
        AppMethodBeat.o(104450);
    }
}

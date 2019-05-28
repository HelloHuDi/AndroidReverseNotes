package com.tencent.mm.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.modelsimple.n;
import com.tencent.mm.modelsimple.w;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.jsapi.g.i;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.protocal.protobuf.abg;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.protocal.protobuf.bdl;
import com.tencent.mm.protocal.protobuf.bre;
import com.tencent.mm.protocal.protobuf.bxz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.ttpic.wav.WavFileHeader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;
import org.xwalk.core.XWalkEnvironment;

public class AllRemindMsgUI extends MMActivity implements f {
    private static final com.tencent.mm.a.f<Integer, com.tencent.mm.protocal.b.a.c> emX = new com.tencent.mm.memory.a.c(32);
    private RecyclerView aiB;
    private ProgressBar gHA;
    private LinkedList<d> kip;
    private View yeu;
    private b yev;
    private a yew = new a();

    class a implements f, Runnable {
        a() {
        }

        public final void run() {
            AppMethodBeat.i(29116);
            aw.Rg().a(new n(), 0);
            AppMethodBeat.o(29116);
        }

        public final void onSceneEnd(int i, int i2, String str, final m mVar) {
            AppMethodBeat.i(29117);
            ab.i("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i != 0 || i2 != 0) {
                ab.e("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                AllRemindMsgUI.this.aiB.setVisibility(0);
                AllRemindMsgUI.this.gHA.setVisibility(8);
                AppMethodBeat.o(29117);
            } else if (mVar.getType() != 866) {
                AppMethodBeat.o(29117);
            } else {
                com.tencent.mm.sdk.g.d.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(29115);
                        LinkedList<bre> linkedList = ((anq) ((n) mVar).fAT.fsH.fsP).wsp;
                        LinkedList linkedList2 = new LinkedList();
                        if (linkedList != null) {
                            for (bre bre : linkedList) {
                                d dVar = new d();
                                dVar.yeE = bre;
                                dVar.timestamp = ((long) bre.lvf) * 1000;
                                dVar.cuu = bre.wOI;
                                dVar.yeF = bre.wTy;
                                if (bre.wOI == 1) {
                                    bdl bdl = new bdl();
                                    try {
                                        bdl.parseFrom(bre.wcJ.wR);
                                    } catch (IOException e) {
                                        ab.e("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] %s", e.toString());
                                    }
                                    dVar.title = bdl.Title;
                                    dVar.username = bdl.jBB;
                                    dVar.cvx = bdl.ptF;
                                    if (dVar.username != null) {
                                        ad aoO;
                                        if (t.kH(dVar.username)) {
                                            String string;
                                            aoO = ((j) g.K(j.class)).XM().aoO(dVar.username);
                                            if (aoO != null) {
                                                dVar.nickname = aoO.Oj() == null ? aoO.Oi() : aoO.Oj();
                                            }
                                            if (bo.isNullOrNil(dVar.nickname)) {
                                                string = AllRemindMsgUI.this.getString(R.string.ao1);
                                            } else {
                                                string = dVar.nickname;
                                            }
                                            dVar.nickname = string;
                                        } else {
                                            aoO = ((j) g.K(j.class)).XM().aoO(dVar.username);
                                            dVar.nickname = aoO.Oj() == null ? aoO.Oi() : aoO.Oj();
                                        }
                                    }
                                } else if (bre.wOI == 2) {
                                    abg abg = new abg();
                                    try {
                                        abg.parseFrom(bre.wcJ.wR);
                                    } catch (IOException e2) {
                                        ab.e("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] %s", e2.toString());
                                    }
                                    dVar.title = abg.Title;
                                    dVar.cvp = abg.vEt;
                                    dVar.whS = abg.vEu;
                                }
                                ab.i("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] getRemind:%s", dVar);
                                linkedList2.add(dVar);
                            }
                            AllRemindMsgUI.this.kip = linkedList2;
                        }
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(29114);
                                AllRemindMsgUI.this.aiB.setVisibility(0);
                                AllRemindMsgUI.this.gHA.setVisibility(8);
                                AllRemindMsgUI.this.yev.aop.notifyChanged();
                                AppMethodBeat.o(29114);
                            }
                        });
                        AppMethodBeat.o(29115);
                    }
                }, "MicroMsg.emoji.AllRemindMsgUI[onSceneEnd]");
                AppMethodBeat.o(29117);
            }
        }
    }

    class b extends android.support.v7.widget.RecyclerView.a {
        b() {
        }

        public final v a(ViewGroup viewGroup, int i) {
            AppMethodBeat.i(29118);
            c cVar = new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.aoa, viewGroup, false));
            AppMethodBeat.o(29118);
            return cVar;
        }

        public final void a(v vVar, int i) {
            AppMethodBeat.i(29119);
            d dVar = (d) AllRemindMsgUI.this.kip.get(i);
            ((c) vVar).apJ.setTag(dVar);
            ((c) vVar).jXx.setText(com.tencent.mm.pluginsdk.ui.e.j.b(AllRemindMsgUI.this.mController.ylL, dVar.nickname, ((c) vVar).jXx.getTextSize()));
            ((c) vVar).gne.setText(com.tencent.mm.pluginsdk.ui.e.j.b(AllRemindMsgUI.this.mController.ylL, dVar.title, ((c) vVar).gne.getTextSize()));
            long currentTimeMillis = System.currentTimeMillis();
            if (dVar.timestamp - currentTimeMillis < 60000) {
                ((c) vVar).yeA.setText(AllRemindMsgUI.this.mController.ylL.getString(R.string.bxb, new Object[]{Integer.valueOf(1)}));
            } else if (dVar.timestamp - currentTimeMillis < 3600000) {
                ((c) vVar).yeA.setText(AllRemindMsgUI.this.mController.ylL.getString(R.string.bxb, new Object[]{Long.valueOf((dVar.timestamp - currentTimeMillis) / 60000)}));
            } else if (dVar.timestamp - currentTimeMillis < 10800000) {
                ((c) vVar).yeA.setText(AllRemindMsgUI.this.mController.ylL.getString(R.string.bxa, new Object[]{Long.valueOf((dVar.timestamp - currentTimeMillis) / 3600000), Long.valueOf(((dVar.timestamp - currentTimeMillis) - (((dVar.timestamp - currentTimeMillis) / 3600000) * 3600000)) / 60000)}));
            } else {
                ((c) vVar).yeA.setText(h.c(AllRemindMsgUI.this.mController.ylL, dVar.timestamp, true));
            }
            if (dVar.cuu == 2) {
                ((c) vVar).gvq.setImageDrawable(AllRemindMsgUI.this.mController.ylL.getResources().getDrawable(R.drawable.avo));
                AppMethodBeat.o(29119);
                return;
            }
            com.tencent.mm.pluginsdk.ui.a.b.b(((c) vVar).gvq, dVar.username);
            AppMethodBeat.o(29119);
        }

        public final int getItemCount() {
            AppMethodBeat.i(29120);
            if (AllRemindMsgUI.this.kip == null) {
                AppMethodBeat.o(29120);
                return 0;
            }
            int size = AllRemindMsgUI.this.kip.size();
            AppMethodBeat.o(29120);
            return size;
        }
    }

    class c extends v {
        View apJ;
        TextView gne;
        ImageView gvq;
        TextView jXx;
        TextView yeA;

        public c(View view) {
            super(view);
            AppMethodBeat.i(29126);
            this.apJ = view;
            this.gne = (TextView) view.findViewById(R.id.cx);
            this.yeA = (TextView) view.findViewById(R.id.dyk);
            this.jXx = (TextView) view.findViewById(R.id.dyj);
            this.gvq = (ImageView) view.findViewById(R.id.bke);
            this.apJ.setOnClickListener(new OnClickListener(AllRemindMsgUI.this) {
                public final void onClick(View view) {
                    AppMethodBeat.i(29121);
                    d dVar = (d) view.getTag();
                    ab.i("MicroMsg.emoji.AllRemindMsgUI", "[onClick] :%s", dVar);
                    c.a(AllRemindMsgUI.this, dVar.username, dVar.cvx);
                    AppMethodBeat.o(29121);
                }
            });
            this.apJ.setOnTouchListener(new OnTouchListener(AllRemindMsgUI.this) {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(29122);
                    view.setTag(R.id.cy, new int[]{(int) motionEvent.getRawX(), (int) motionEvent.getRawY()});
                    AppMethodBeat.o(29122);
                    return false;
                }
            });
            this.apJ.setOnLongClickListener(new OnLongClickListener(AllRemindMsgUI.this) {
                public final boolean onLongClick(final View view) {
                    AppMethodBeat.i(29125);
                    com.tencent.mm.ui.widget.b.a aVar = new com.tencent.mm.ui.widget.b.a(AllRemindMsgUI.this.mController.ylL);
                    int[] iArr = new int[2];
                    if (view.getTag(R.id.cy) instanceof int[]) {
                        iArr = (int[]) view.getTag(R.id.cy);
                    }
                    aVar.a(view, new OnCreateContextMenuListener() {
                        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                            AppMethodBeat.i(29123);
                            contextMenu.add(0, 0, 0, AllRemindMsgUI.this.mController.ylL.getString(R.string.am7));
                            AppMethodBeat.o(29123);
                        }
                    }, new com.tencent.mm.ui.base.n.d() {
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                            AppMethodBeat.i(29124);
                            ab.i("MicroMsg.emoji.AllRemindMsgUI", "[onMMMenuItemSelected] delete item:%s", (d) view.getTag());
                            aw.Rg().a(new w(2, r0.yeE), 0);
                            AppMethodBeat.o(29124);
                        }
                    }, iArr[0], iArr[1]);
                    AppMethodBeat.o(29125);
                    return true;
                }
            });
            AppMethodBeat.o(29126);
        }

        static /* synthetic */ void a(Context context, String str, long j) {
            AppMethodBeat.i(29127);
            if (str == null) {
                ab.e("MicroMsg.emoji.AllRemindMsgUI", "[gotoChattingUIWithPosition] username is null");
                AppMethodBeat.o(29127);
                return;
            }
            aw.ZK();
            ab.i("MicroMsg.emoji.AllRemindMsgUI", "[gotoChattingUIWithPosition] msgLocalId:%s", Long.valueOf(com.tencent.mm.model.c.XO().Q(str, j).field_msgId));
            if (str.contains("@")) {
                aw.ZK();
                if (com.tencent.mm.model.c.XV().oa(str) == null) {
                    ab.w("MicroMsg.emoji.AllRemindMsgUI", "[gotoChattingUIWithPosition] member is null! username:%s", str);
                    com.tencent.mm.ui.base.h.a(context, context.getString(R.string.dnb), context.getString(R.string.ewj), null);
                    AppMethodBeat.o(29127);
                    return;
                }
            }
            ad aoO = ((j) g.K(j.class)).XM().aoO(str);
            if (aoO == null || !com.tencent.mm.n.a.jh(aoO.field_type)) {
                if (aoO == null) {
                    ab.w("MicroMsg.emoji.AllRemindMsgUI", "[gotoChattingUIWithPosition] contact is null! username:%s", str);
                } else {
                    ab.w("MicroMsg.emoji.AllRemindMsgUI", "[gotoChattingUIWithPosition] isContact not ! username:%s", str);
                }
                com.tencent.mm.ui.base.h.a(context, context.getString(R.string.dnb), context.getString(R.string.ewj), null);
                AppMethodBeat.o(29127);
                return;
            }
            Intent putExtra = new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", r2);
            putExtra.setClass(context, ChattingUI.class);
            context.startActivity(putExtra);
            AppMethodBeat.o(29127);
        }
    }

    class d {
        int cuu;
        int cvp;
        long cvx;
        String nickname;
        long timestamp;
        String title;
        String username;
        String whS;
        bre yeE;
        String yeF;

        d() {
        }

        public final String toString() {
            AppMethodBeat.i(29128);
            String str = "RemindItem{username='" + this.username + '\'' + ", nickname='" + this.nickname + '\'' + ", title='" + bo.anv(this.title) + '\'' + ", timestamp=" + this.timestamp + ", subType=" + this.cuu + ", msgId=" + this.cvx + ", sourceType=" + this.cvp + ", sourceId='" + this.whS + '\'' + '}';
            AppMethodBeat.o(29128);
            return str;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public AllRemindMsgUI() {
        AppMethodBeat.i(29129);
        AppMethodBeat.o(29129);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(29130);
        super.onCreate(bundle);
        aw.Rg().a(866, this.yew);
        aw.Rg().a((int) i.CTRL_INDEX, (f) this);
        com.tencent.mm.plugin.report.service.h.pYm.a(795, 3, 1, false);
        initView();
        com.tencent.mm.sdk.g.d.post(new a(), "load remind data!");
        AppMethodBeat.o(29130);
    }

    public void onDestroy() {
        AppMethodBeat.i(29131);
        super.onDestroy();
        aw.Rg().b(866, this.yew);
        aw.Rg().b((int) i.CTRL_INDEX, (f) this);
        AppMethodBeat.o(29131);
    }

    /* Access modifiers changed, original: protected|final */
    public final void initView() {
        AppMethodBeat.i(29132);
        setMMTitle((int) R.string.dnf);
        this.aiB = (RecyclerView) findViewById(R.id.o_);
        this.gHA = (ProgressBar) findViewById(R.id.oa);
        this.yeu = findViewById(R.id.ob);
        this.aiB.setVisibility(8);
        this.aiB.setLayoutManager(new LinearLayoutManager());
        this.yev = new b();
        this.aiB.setAdapter(this.yev);
        this.yev.a((android.support.v7.widget.RecyclerView.c) new android.support.v7.widget.RecyclerView.c() {
            public final void onChanged() {
                AppMethodBeat.i(29112);
                super.onChanged();
                ab.i("MicroMsg.emoji.AllRemindMsgUI", "[onChanged] size:%s", Integer.valueOf(AllRemindMsgUI.this.yev.getItemCount()));
                if (AllRemindMsgUI.this.yev.getItemCount() == 0) {
                    AllRemindMsgUI.this.yeu.setVisibility(0);
                    AllRemindMsgUI.this.aiB.setVisibility(8);
                    AppMethodBeat.o(29112);
                    return;
                }
                AllRemindMsgUI.this.yeu.setVisibility(8);
                AllRemindMsgUI.this.aiB.setVisibility(0);
                AppMethodBeat.o(29112);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(29113);
                AllRemindMsgUI.this.onBackPressed();
                AppMethodBeat.o(29113);
                return true;
            }
        });
        AppMethodBeat.o(29132);
    }

    public void onBackPressed() {
        AppMethodBeat.i(29133);
        finish();
        AppMethodBeat.o(29133);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getLayoutId() {
        return R.layout.b8;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(29134);
        ab.i("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i != 0 || i2 != 0) {
            Toast.makeText(this.mController.ylL, bo.bc(str, getString(R.string.d_p)), 0).show();
            AppMethodBeat.o(29134);
        } else if (mVar.getType() != i.CTRL_INDEX) {
            AppMethodBeat.o(29134);
        } else {
            bxz bxz = (bxz) ((w) mVar).fAT.fsG.fsP;
            ListIterator listIterator = this.kip.listIterator();
            while (listIterator.hasNext()) {
                if (((d) listIterator.next()).yeF == bxz.wXC.wTy) {
                    listIterator.remove();
                }
            }
            this.yev.aop.notifyChanged();
            AppMethodBeat.o(29134);
        }
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String a(Context context, int i, String str, int i2) {
        AppMethodBeat.i(29135);
        String str2 = "";
        com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(str);
        switch (i) {
            case -1879048186:
                str2 = context.getString(R.string.djh, new Object[]{""});
                break;
            case -1879048185:
            case -1879048183:
            case -1879048176:
                str2 = context.getString(R.string.dj8, new Object[]{""});
                break;
            case 1:
                str2 = context.getString(R.string.ho);
                break;
            case 3:
            case 23:
            case 33:
                str2 = context.getString(R.string.sn);
                break;
            case 34:
                str2 = context.getString(R.string.djk, new Object[]{Integer.valueOf((int) q.fY(new com.tencent.mm.modelvoice.n(str).time))});
                break;
            case com.tencent.mm.plugin.appbrand.jsapi.e.g.CTRL_INDEX /*37*/:
                if (str != null && str.length() > 0) {
                    com.tencent.mm.storage.bi.d apF = com.tencent.mm.storage.bi.d.apF(str);
                    if (apF.svN != null && apF.svN.length() > 0) {
                        switch (apF.scene) {
                            case 18:
                                str2 = context.getString(R.string.byj, new Object[]{apF.getDisplayName()});
                                break;
                            case 22:
                            case 23:
                            case 24:
                            case 26:
                            case 27:
                            case com.tencent.view.d.MIC_BASE_CHANNELSHARPEN /*28*/:
                            case 29:
                                str2 = context.getString(R.string.byt, new Object[]{apF.getDisplayName()});
                                break;
                            case 25:
                                str2 = context.getString(R.string.bwp, new Object[]{apF.getDisplayName()});
                                break;
                            default:
                                str2 = context.getString(R.string.bz2, new Object[]{apF.getDisplayName()});
                                break;
                        }
                    }
                }
            case 42:
            case 66:
                str2 = context.getString(R.string.qw);
                break;
            case 43:
            case 62:
                str2 = context.getString(62 == i ? R.string.tp : R.string.ud);
                break;
            case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                str2 = context.getString(R.string.ph);
                break;
            case 48:
                aw.ZK();
                com.tencent.mm.model.c.XO().Ro(str);
                str2 = context.getString(R.string.djc, new Object[]{""});
                break;
            case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
            case 553648177:
            case 587202609:
                if (me == null) {
                    ab.e("MicroMsg.emoji.AllRemindMsgUI", "decode msg content failed");
                    str2 = "";
                    AppMethodBeat.o(29135);
                    return str2;
                }
                switch (me.type) {
                    case 2:
                        str2 = context.getString(R.string.sn);
                        break;
                    case 3:
                        str2 = context.getString(R.string.djd, new Object[]{""});
                        break;
                    case 4:
                        str2 = context.getString(R.string.djj, new Object[]{""});
                        break;
                    case 5:
                    case 7:
                        str2 = context.getString(R.string.dji, new Object[]{""});
                        break;
                    case 6:
                        str2 = context.getString(R.string.djb, new Object[]{me.title});
                        break;
                    case 8:
                        str2 = context.getString(R.string.pi);
                        break;
                    case 15:
                    case 26:
                    case 27:
                        str2 = context.getString(R.string.ph);
                        break;
                    case 17:
                        str2 = context.getString(R.string.djc, new Object[]{""});
                        break;
                    case 19:
                        str2 = context.getString(R.string.djf, new Object[]{""});
                        break;
                    case 24:
                        str2 = context.getString(R.string.dje, new Object[]{""});
                        break;
                    case 25:
                        str2 = context.getString(R.string.p6);
                        break;
                    case 33:
                        str2 = context.getString(R.string.ho);
                        break;
                    case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                        if (!bo.isNullOrNil(me.p(context, true))) {
                            str2 = me.p(context, true) + " " + me.title;
                            break;
                        }
                    default:
                        ab.i("MicroMsg.emoji.AllRemindMsgUI", "default type:%s", Integer.valueOf(me.type));
                }
            case 369098801:
            case 452984881:
                str2 = context.getString(R.string.dj_, new Object[]{""});
                break;
            case 419430449:
                str2 = context.getString(R.string.djg);
                break;
            case 436207665:
            case 469762097:
                if (me != null) {
                    if (i2 != 1) {
                        str2 = context.getString(R.string.dj9, new Object[]{me.fhW, ""});
                        break;
                    }
                    str2 = context.getString(R.string.dj9, new Object[]{me.fhW, ""});
                    break;
                }
                ab.e("MicroMsg.emoji.AllRemindMsgUI", "decode msg content failed");
                str2 = "";
                AppMethodBeat.o(29135);
                return str2;
            case 503316529:
                if (me != null) {
                    str2 = context.getString(R.string.dj9, new Object[]{me.fhW, ""});
                    break;
                }
                ab.e("MicroMsg.emoji.AllRemindMsgUI", "decode msg content failed");
                str2 = "";
                AppMethodBeat.o(29135);
                return str2;
            case 520093745:
                str2 = context.getString(R.string.dj_, new Object[]{""});
                break;
            default:
                str2 = context.getString(R.string.d7t);
                break;
        }
        AppMethodBeat.o(29135);
        return str2;
    }

    static {
        AppMethodBeat.i(29136);
        AppMethodBeat.o(29136);
    }
}

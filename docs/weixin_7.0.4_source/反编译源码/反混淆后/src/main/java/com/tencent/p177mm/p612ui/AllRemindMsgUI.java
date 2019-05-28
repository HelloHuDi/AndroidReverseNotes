package com.tencent.p177mm.p612ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41525c;
import android.support.p069v7.widget.RecyclerView.C41531v;
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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.memory.p259a.C7598c;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelsimple.C32827n;
import com.tencent.p177mm.modelsimple.C37950w;
import com.tencent.p177mm.modelvoice.C32850q;
import com.tencent.p177mm.modelvoice.C42230n;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.chatting.ChattingUI;
import com.tencent.p177mm.p612ui.widget.p1095b.C24088a;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.p177mm.plugin.appbrand.jsapi.p304e.C2275g;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C44699i;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.p1338b.p1339a.C44099c;
import com.tencent.p177mm.protocal.protobuf.abg;
import com.tencent.p177mm.protocal.protobuf.anq;
import com.tencent.p177mm.protocal.protobuf.bdl;
import com.tencent.p177mm.protocal.protobuf.bre;
import com.tencent.p177mm.protocal.protobuf.bxz;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi.C5138d;
import com.tencent.ttpic.wav.WavFileHeader;
import com.tencent.view.C31128d;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.mm.ui.AllRemindMsgUI */
public class AllRemindMsgUI extends MMActivity implements C1202f {
    private static final C1177f<Integer, C44099c> emX = new C7598c(32);
    private RecyclerView aiB;
    private ProgressBar gHA;
    private LinkedList<C30319d> kip;
    private View yeu;
    private C30316b yev;
    private C30315a yew = new C30315a();

    /* renamed from: com.tencent.mm.ui.AllRemindMsgUI$2 */
    class C154552 implements OnMenuItemClickListener {
        C154552() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(29113);
            AllRemindMsgUI.this.onBackPressed();
            AppMethodBeat.m2505o(29113);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.AllRemindMsgUI$a */
    class C30315a implements C1202f, Runnable {
        C30315a() {
        }

        public final void run() {
            AppMethodBeat.m2504i(29116);
            C9638aw.m17182Rg().mo14541a(new C32827n(), 0);
            AppMethodBeat.m2505o(29116);
        }

        public final void onSceneEnd(int i, int i2, String str, final C1207m c1207m) {
            AppMethodBeat.m2504i(29117);
            C4990ab.m7417i("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i != 0 || i2 != 0) {
                C4990ab.m7413e("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                AllRemindMsgUI.this.aiB.setVisibility(0);
                AllRemindMsgUI.this.gHA.setVisibility(8);
                AppMethodBeat.m2505o(29117);
            } else if (c1207m.getType() != 866) {
                AppMethodBeat.m2505o(29117);
            } else {
                C7305d.post(new Runnable() {

                    /* renamed from: com.tencent.mm.ui.AllRemindMsgUI$a$1$1 */
                    class C51691 implements Runnable {
                        C51691() {
                        }

                        public final void run() {
                            AppMethodBeat.m2504i(29114);
                            AllRemindMsgUI.this.aiB.setVisibility(0);
                            AllRemindMsgUI.this.gHA.setVisibility(8);
                            AllRemindMsgUI.this.yev.aop.notifyChanged();
                            AppMethodBeat.m2505o(29114);
                        }
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(29115);
                        LinkedList<bre> linkedList = ((anq) ((C32827n) c1207m).fAT.fsH.fsP).wsp;
                        LinkedList linkedList2 = new LinkedList();
                        if (linkedList != null) {
                            for (bre bre : linkedList) {
                                C30319d c30319d = new C30319d();
                                c30319d.yeE = bre;
                                c30319d.timestamp = ((long) bre.lvf) * 1000;
                                c30319d.cuu = bre.wOI;
                                c30319d.yeF = bre.wTy;
                                if (bre.wOI == 1) {
                                    bdl bdl = new bdl();
                                    try {
                                        bdl.parseFrom(bre.wcJ.f1226wR);
                                    } catch (IOException e) {
                                        C4990ab.m7413e("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] %s", e.toString());
                                    }
                                    c30319d.title = bdl.Title;
                                    c30319d.username = bdl.jBB;
                                    c30319d.cvx = bdl.ptF;
                                    if (c30319d.username != null) {
                                        C7616ad aoO;
                                        if (C1855t.m3896kH(c30319d.username)) {
                                            String string;
                                            aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(c30319d.username);
                                            if (aoO != null) {
                                                c30319d.nickname = aoO.mo16707Oj() == null ? aoO.mo16706Oi() : aoO.mo16707Oj();
                                            }
                                            if (C5046bo.isNullOrNil(c30319d.nickname)) {
                                                string = AllRemindMsgUI.this.getString(C25738R.string.ao1);
                                            } else {
                                                string = c30319d.nickname;
                                            }
                                            c30319d.nickname = string;
                                        } else {
                                            aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(c30319d.username);
                                            c30319d.nickname = aoO.mo16707Oj() == null ? aoO.mo16706Oi() : aoO.mo16707Oj();
                                        }
                                    }
                                } else if (bre.wOI == 2) {
                                    abg abg = new abg();
                                    try {
                                        abg.parseFrom(bre.wcJ.f1226wR);
                                    } catch (IOException e2) {
                                        C4990ab.m7413e("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] %s", e2.toString());
                                    }
                                    c30319d.title = abg.Title;
                                    c30319d.cvp = abg.vEt;
                                    c30319d.whS = abg.vEu;
                                }
                                C4990ab.m7417i("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] getRemind:%s", c30319d);
                                linkedList2.add(c30319d);
                            }
                            AllRemindMsgUI.this.kip = linkedList2;
                        }
                        C5004al.m7441d(new C51691());
                        AppMethodBeat.m2505o(29115);
                    }
                }, "MicroMsg.emoji.AllRemindMsgUI[onSceneEnd]");
                AppMethodBeat.m2505o(29117);
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.AllRemindMsgUI$b */
    class C30316b extends C41523a {
        C30316b() {
        }

        /* renamed from: a */
        public final C41531v mo4976a(ViewGroup viewGroup, int i) {
            AppMethodBeat.m2504i(29118);
            C30317c c30317c = new C30317c(LayoutInflater.from(viewGroup.getContext()).inflate(2130970505, viewGroup, false));
            AppMethodBeat.m2505o(29118);
            return c30317c;
        }

        /* renamed from: a */
        public final void mo4977a(C41531v c41531v, int i) {
            AppMethodBeat.m2504i(29119);
            C30319d c30319d = (C30319d) AllRemindMsgUI.this.kip.get(i);
            ((C30317c) c41531v).apJ.setTag(c30319d);
            ((C30317c) c41531v).jXx.setText(C44089j.m79293b(AllRemindMsgUI.this.mController.ylL, c30319d.nickname, ((C30317c) c41531v).jXx.getTextSize()));
            ((C30317c) c41531v).gne.setText(C44089j.m79293b(AllRemindMsgUI.this.mController.ylL, c30319d.title, ((C30317c) c41531v).gne.getTextSize()));
            long currentTimeMillis = System.currentTimeMillis();
            if (c30319d.timestamp - currentTimeMillis < 60000) {
                ((C30317c) c41531v).yeA.setText(AllRemindMsgUI.this.mController.ylL.getString(C25738R.string.bxb, new Object[]{Integer.valueOf(1)}));
            } else if (c30319d.timestamp - currentTimeMillis < 3600000) {
                ((C30317c) c41531v).yeA.setText(AllRemindMsgUI.this.mController.ylL.getString(C25738R.string.bxb, new Object[]{Long.valueOf((c30319d.timestamp - currentTimeMillis) / 60000)}));
            } else if (c30319d.timestamp - currentTimeMillis < 10800000) {
                ((C30317c) c41531v).yeA.setText(AllRemindMsgUI.this.mController.ylL.getString(C25738R.string.bxa, new Object[]{Long.valueOf((c30319d.timestamp - currentTimeMillis) / 3600000), Long.valueOf(((c30319d.timestamp - currentTimeMillis) - (((c30319d.timestamp - currentTimeMillis) / 3600000) * 3600000)) / 60000)}));
            } else {
                ((C30317c) c41531v).yeA.setText(C14835h.m23089c(AllRemindMsgUI.this.mController.ylL, c30319d.timestamp, true));
            }
            if (c30319d.cuu == 2) {
                ((C30317c) c41531v).gvq.setImageDrawable(AllRemindMsgUI.this.mController.ylL.getResources().getDrawable(C25738R.drawable.avo));
                AppMethodBeat.m2505o(29119);
                return;
            }
            C40460b.m69434b(((C30317c) c41531v).gvq, c30319d.username);
            AppMethodBeat.m2505o(29119);
        }

        public final int getItemCount() {
            AppMethodBeat.m2504i(29120);
            if (AllRemindMsgUI.this.kip == null) {
                AppMethodBeat.m2505o(29120);
                return 0;
            }
            int size = AllRemindMsgUI.this.kip.size();
            AppMethodBeat.m2505o(29120);
            return size;
        }
    }

    /* renamed from: com.tencent.mm.ui.AllRemindMsgUI$c */
    class C30317c extends C41531v {
        View apJ;
        TextView gne;
        ImageView gvq;
        TextView jXx;
        TextView yeA;

        public C30317c(View view) {
            super(view);
            AppMethodBeat.m2504i(29126);
            this.apJ = view;
            this.gne = (TextView) view.findViewById(2131820678);
            this.yeA = (TextView) view.findViewById(2131826965);
            this.jXx = (TextView) view.findViewById(2131826964);
            this.gvq = (ImageView) view.findViewById(2131823704);
            this.apJ.setOnClickListener(new OnClickListener(AllRemindMsgUI.this) {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(29121);
                    C30319d c30319d = (C30319d) view.getTag();
                    C4990ab.m7417i("MicroMsg.emoji.AllRemindMsgUI", "[onClick] :%s", c30319d);
                    C30317c.m48288a(AllRemindMsgUI.this, c30319d.username, c30319d.cvx);
                    AppMethodBeat.m2505o(29121);
                }
            });
            this.apJ.setOnTouchListener(new OnTouchListener(AllRemindMsgUI.this) {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.m2504i(29122);
                    view.setTag(2131820679, new int[]{(int) motionEvent.getRawX(), (int) motionEvent.getRawY()});
                    AppMethodBeat.m2505o(29122);
                    return false;
                }
            });
            this.apJ.setOnLongClickListener(new OnLongClickListener(AllRemindMsgUI.this) {

                /* renamed from: com.tencent.mm.ui.AllRemindMsgUI$c$3$1 */
                class C303141 implements OnCreateContextMenuListener {
                    C303141() {
                    }

                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                        AppMethodBeat.m2504i(29123);
                        contextMenu.add(0, 0, 0, AllRemindMsgUI.this.mController.ylL.getString(C25738R.string.am7));
                        AppMethodBeat.m2505o(29123);
                    }
                }

                public final boolean onLongClick(final View view) {
                    AppMethodBeat.m2504i(29125);
                    C24088a c24088a = new C24088a(AllRemindMsgUI.this.mController.ylL);
                    int[] iArr = new int[2];
                    if (view.getTag(2131820679) instanceof int[]) {
                        iArr = (int[]) view.getTag(2131820679);
                    }
                    c24088a.mo39886a(view, new C303141(), new C5279d() {
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                            AppMethodBeat.m2504i(29124);
                            C4990ab.m7417i("MicroMsg.emoji.AllRemindMsgUI", "[onMMMenuItemSelected] delete item:%s", (C30319d) view.getTag());
                            C9638aw.m17182Rg().mo14541a(new C37950w(2, r0.yeE), 0);
                            AppMethodBeat.m2505o(29124);
                        }
                    }, iArr[0], iArr[1]);
                    AppMethodBeat.m2505o(29125);
                    return true;
                }
            });
            AppMethodBeat.m2505o(29126);
        }

        /* renamed from: a */
        static /* synthetic */ void m48288a(Context context, String str, long j) {
            AppMethodBeat.m2504i(29127);
            if (str == null) {
                C4990ab.m7412e("MicroMsg.emoji.AllRemindMsgUI", "[gotoChattingUIWithPosition] username is null");
                AppMethodBeat.m2505o(29127);
                return;
            }
            C9638aw.m17190ZK();
            C4990ab.m7417i("MicroMsg.emoji.AllRemindMsgUI", "[gotoChattingUIWithPosition] msgLocalId:%s", Long.valueOf(C18628c.m29080XO().mo15241Q(str, j).field_msgId));
            if (str.contains("@")) {
                C9638aw.m17190ZK();
                if (C18628c.m29087XV().mo14885oa(str) == null) {
                    C4990ab.m7421w("MicroMsg.emoji.AllRemindMsgUI", "[gotoChattingUIWithPosition] member is null! username:%s", str);
                    C30379h.m48438a(context, context.getString(C25738R.string.dnb), context.getString(C25738R.string.ewj), null);
                    AppMethodBeat.m2505o(29127);
                    return;
                }
            }
            C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
            if (aoO == null || !C7486a.m12942jh(aoO.field_type)) {
                if (aoO == null) {
                    C4990ab.m7421w("MicroMsg.emoji.AllRemindMsgUI", "[gotoChattingUIWithPosition] contact is null! username:%s", str);
                } else {
                    C4990ab.m7421w("MicroMsg.emoji.AllRemindMsgUI", "[gotoChattingUIWithPosition] isContact not ! username:%s", str);
                }
                C30379h.m48438a(context, context.getString(C25738R.string.dnb), context.getString(C25738R.string.ewj), null);
                AppMethodBeat.m2505o(29127);
                return;
            }
            Intent putExtra = new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", r2);
            putExtra.setClass(context, ChattingUI.class);
            context.startActivity(putExtra);
            AppMethodBeat.m2505o(29127);
        }
    }

    /* renamed from: com.tencent.mm.ui.AllRemindMsgUI$d */
    class C30319d {
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

        C30319d() {
        }

        public final String toString() {
            AppMethodBeat.m2504i(29128);
            String str = "RemindItem{username='" + this.username + '\'' + ", nickname='" + this.nickname + '\'' + ", title='" + C5046bo.anv(this.title) + '\'' + ", timestamp=" + this.timestamp + ", subType=" + this.cuu + ", msgId=" + this.cvx + ", sourceType=" + this.cvp + ", sourceId='" + this.whS + '\'' + '}';
            AppMethodBeat.m2505o(29128);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.ui.AllRemindMsgUI$1 */
    class C303201 extends C41525c {
        C303201() {
        }

        public final void onChanged() {
            AppMethodBeat.m2504i(29112);
            super.onChanged();
            C4990ab.m7417i("MicroMsg.emoji.AllRemindMsgUI", "[onChanged] size:%s", Integer.valueOf(AllRemindMsgUI.this.yev.getItemCount()));
            if (AllRemindMsgUI.this.yev.getItemCount() == 0) {
                AllRemindMsgUI.this.yeu.setVisibility(0);
                AllRemindMsgUI.this.aiB.setVisibility(8);
                AppMethodBeat.m2505o(29112);
                return;
            }
            AllRemindMsgUI.this.yeu.setVisibility(8);
            AllRemindMsgUI.this.aiB.setVisibility(0);
            AppMethodBeat.m2505o(29112);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public AllRemindMsgUI() {
        AppMethodBeat.m2504i(29129);
        AppMethodBeat.m2505o(29129);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(29130);
        super.onCreate(bundle);
        C9638aw.m17182Rg().mo14539a(866, this.yew);
        C9638aw.m17182Rg().mo14539a((int) C44699i.CTRL_INDEX, (C1202f) this);
        C7060h.pYm.mo8378a(795, 3, 1, false);
        initView();
        C7305d.post(new C30315a(), "load remind data!");
        AppMethodBeat.m2505o(29130);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(29131);
        super.onDestroy();
        C9638aw.m17182Rg().mo14546b(866, this.yew);
        C9638aw.m17182Rg().mo14546b((int) C44699i.CTRL_INDEX, (C1202f) this);
        AppMethodBeat.m2505o(29131);
    }

    /* Access modifiers changed, original: protected|final */
    public final void initView() {
        AppMethodBeat.m2504i(29132);
        setMMTitle((int) C25738R.string.dnf);
        this.aiB = (RecyclerView) findViewById(2131821098);
        this.gHA = (ProgressBar) findViewById(2131821099);
        this.yeu = findViewById(2131821100);
        this.aiB.setVisibility(8);
        this.aiB.setLayoutManager(new LinearLayoutManager());
        this.yev = new C30316b();
        this.aiB.setAdapter(this.yev);
        this.yev.mo66307a((C41525c) new C303201());
        setBackBtn(new C154552());
        AppMethodBeat.m2505o(29132);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(29133);
        finish();
        AppMethodBeat.m2505o(29133);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getLayoutId() {
        return 2130968647;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(29134);
        C4990ab.m7417i("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i != 0 || i2 != 0) {
            Toast.makeText(this.mController.ylL, C5046bo.m7532bc(str, getString(C25738R.string.d_p)), 0).show();
            AppMethodBeat.m2505o(29134);
        } else if (c1207m.getType() != C44699i.CTRL_INDEX) {
            AppMethodBeat.m2505o(29134);
        } else {
            bxz bxz = (bxz) ((C37950w) c1207m).fAT.fsG.fsP;
            ListIterator listIterator = this.kip.listIterator();
            while (listIterator.hasNext()) {
                if (((C30319d) listIterator.next()).yeF == bxz.wXC.wTy) {
                    listIterator.remove();
                }
            }
            this.yev.aop.notifyChanged();
            AppMethodBeat.m2505o(29134);
        }
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static String m48280a(Context context, int i, String str, int i2) {
        AppMethodBeat.m2504i(29135);
        String str2 = "";
        C8910b me = C8910b.m16064me(str);
        switch (i) {
            case -1879048186:
                str2 = context.getString(C25738R.string.djh, new Object[]{""});
                break;
            case -1879048185:
            case -1879048183:
            case -1879048176:
                str2 = context.getString(C25738R.string.dj8, new Object[]{""});
                break;
            case 1:
                str2 = context.getString(C25738R.string.f8870ho);
                break;
            case 3:
            case 23:
            case 33:
                str2 = context.getString(C25738R.string.f9199sn);
                break;
            case 34:
                str2 = context.getString(C25738R.string.djk, new Object[]{Integer.valueOf((int) C32850q.m53722fY(new C42230n(str).time))});
                break;
            case C2275g.CTRL_INDEX /*37*/:
                if (str != null && str.length() > 0) {
                    C5138d apF = C5138d.apF(str);
                    if (apF.svN != null && apF.svN.length() > 0) {
                        switch (apF.scene) {
                            case 18:
                                str2 = context.getString(C25738R.string.byj, new Object[]{apF.getDisplayName()});
                                break;
                            case 22:
                            case 23:
                            case 24:
                            case 26:
                            case 27:
                            case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                            case 29:
                                str2 = context.getString(C25738R.string.byt, new Object[]{apF.getDisplayName()});
                                break;
                            case 25:
                                str2 = context.getString(C25738R.string.bwp, new Object[]{apF.getDisplayName()});
                                break;
                            default:
                                str2 = context.getString(C25738R.string.bz2, new Object[]{apF.getDisplayName()});
                                break;
                        }
                    }
                }
            case 42:
            case 66:
                str2 = context.getString(C25738R.string.f9145qw);
                break;
            case 43:
            case 62:
                str2 = context.getString(62 == i ? C25738R.string.f9230tp : C25738R.string.f9253ud);
                break;
            case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                str2 = context.getString(C25738R.string.f9100ph);
                break;
            case 48:
                C9638aw.m17190ZK();
                C18628c.m29080XO().mo15261Ro(str);
                str2 = context.getString(C25738R.string.djc, new Object[]{""});
                break;
            case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
            case 553648177:
            case 587202609:
                if (me == null) {
                    C4990ab.m7412e("MicroMsg.emoji.AllRemindMsgUI", "decode msg content failed");
                    str2 = "";
                    AppMethodBeat.m2505o(29135);
                    return str2;
                }
                switch (me.type) {
                    case 2:
                        str2 = context.getString(C25738R.string.f9199sn);
                        break;
                    case 3:
                        str2 = context.getString(C25738R.string.djd, new Object[]{""});
                        break;
                    case 4:
                        str2 = context.getString(C25738R.string.djj, new Object[]{""});
                        break;
                    case 5:
                    case 7:
                        str2 = context.getString(C25738R.string.dji, new Object[]{""});
                        break;
                    case 6:
                        str2 = context.getString(C25738R.string.djb, new Object[]{me.title});
                        break;
                    case 8:
                        str2 = context.getString(C25738R.string.f9101pi);
                        break;
                    case 15:
                    case 26:
                    case 27:
                        str2 = context.getString(C25738R.string.f9100ph);
                        break;
                    case 17:
                        str2 = context.getString(C25738R.string.djc, new Object[]{""});
                        break;
                    case 19:
                        str2 = context.getString(C25738R.string.djf, new Object[]{""});
                        break;
                    case 24:
                        str2 = context.getString(C25738R.string.dje, new Object[]{""});
                        break;
                    case 25:
                        str2 = context.getString(C25738R.string.f9090p6);
                        break;
                    case 33:
                        str2 = context.getString(C25738R.string.f8870ho);
                        break;
                    case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                        if (!C5046bo.isNullOrNil(me.mo20339p(context, true))) {
                            str2 = me.mo20339p(context, true) + " " + me.title;
                            break;
                        }
                    default:
                        C4990ab.m7417i("MicroMsg.emoji.AllRemindMsgUI", "default type:%s", Integer.valueOf(me.type));
                }
            case 369098801:
            case 452984881:
                str2 = context.getString(C25738R.string.dj_, new Object[]{""});
                break;
            case 419430449:
                str2 = context.getString(C25738R.string.djg);
                break;
            case 436207665:
            case 469762097:
                if (me != null) {
                    if (i2 != 1) {
                        str2 = context.getString(C25738R.string.dj9, new Object[]{me.fhW, ""});
                        break;
                    }
                    str2 = context.getString(C25738R.string.dj9, new Object[]{me.fhW, ""});
                    break;
                }
                C4990ab.m7412e("MicroMsg.emoji.AllRemindMsgUI", "decode msg content failed");
                str2 = "";
                AppMethodBeat.m2505o(29135);
                return str2;
            case 503316529:
                if (me != null) {
                    str2 = context.getString(C25738R.string.dj9, new Object[]{me.fhW, ""});
                    break;
                }
                C4990ab.m7412e("MicroMsg.emoji.AllRemindMsgUI", "decode msg content failed");
                str2 = "";
                AppMethodBeat.m2505o(29135);
                return str2;
            case 520093745:
                str2 = context.getString(C25738R.string.dj_, new Object[]{""});
                break;
            default:
                str2 = context.getString(C25738R.string.d7t);
                break;
        }
        AppMethodBeat.m2505o(29135);
        return str2;
    }

    static {
        AppMethodBeat.m2504i(29136);
        AppMethodBeat.m2505o(29136);
    }
}

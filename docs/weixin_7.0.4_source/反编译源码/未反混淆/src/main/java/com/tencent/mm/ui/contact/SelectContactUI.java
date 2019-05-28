package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.internal.Utility;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.l;
import com.tencent.mm.bp.d;
import com.tencent.mm.m.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.a.k;
import com.tencent.mm.ui.q.b;
import com.tencent.mm.ui.v;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class SelectContactUI extends MMBaseSelectContactUI implements f {
    private ProgressDialog ehJ;
    private List<String> elZ;
    private HashSet<String> gnG;
    private String jcF;
    private String nHU;
    private int requestCode;
    private String title;
    private int zkf;
    private TextView zoA;
    private TextView zoB;
    private TextView zoC;
    private TextView zoD;
    private TextView zoE;
    private TextView zoF;
    private boolean zoG;
    private boolean zoH;
    private String zoI;
    private String zoJ;
    private boolean zoK;
    private boolean zoL;
    private boolean zoM;
    private boolean zoN = false;
    private String zoO;
    private HashSet<String> zol;
    private int zon;
    private boolean zoo = true;
    private a zop = new a();

    static class a {
        TextView iqU;
        private AlphaAnimation zoZ;
        private AlphaAnimation zpa;
        boolean zpb = false;

        a() {
        }

        public final void e(final Activity activity, int i, int i2) {
            AppMethodBeat.i(33869);
            if (i2 <= 0 || i != i2 + 1 || this.zpb) {
                if (i < i2) {
                    aw(activity);
                    this.zpb = false;
                }
                AppMethodBeat.o(33869);
                return;
            }
            if (this.iqU == null) {
                this.iqU = (TextView) activity.findViewById(R.id.j2);
            }
            if (this.iqU.getVisibility() != 0) {
                this.iqU.setText(R.string.drd);
                this.iqU.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(33867);
                        a.this.zpb = true;
                        a.this.aw(activity);
                        AppMethodBeat.o(33867);
                    }
                });
                if (this.zoZ == null) {
                    this.zoZ = new AlphaAnimation(0.0f, 1.0f);
                }
                this.zoZ.setDuration(300);
                if (this.zpa != null) {
                    this.zpa.cancel();
                }
                this.iqU.setVisibility(0);
                this.iqU.startAnimation(this.zoZ);
            }
            AppMethodBeat.o(33869);
        }

        /* Access modifiers changed, original: final */
        public final void aw(Activity activity) {
            AppMethodBeat.i(33870);
            if (this.iqU == null) {
                this.iqU = (TextView) activity.findViewById(R.id.j2);
            }
            if (this.iqU.getVisibility() == 8) {
                AppMethodBeat.o(33870);
                return;
            }
            if (this.zpa == null) {
                this.zpa = new AlphaAnimation(1.0f, 0.0f);
                this.zpa.setAnimationListener(new AnimationListener() {
                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.i(33868);
                        a.this.iqU.setVisibility(8);
                        AppMethodBeat.o(33868);
                    }
                });
            }
            this.zpa.setDuration(300);
            if (this.zoZ != null) {
                this.zoZ.cancel();
            }
            this.iqU.startAnimation(this.zpa);
            AppMethodBeat.o(33870);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SelectContactUI() {
        AppMethodBeat.i(33871);
        AppMethodBeat.o(33871);
    }

    static /* synthetic */ ArrayList c(SelectContactUI selectContactUI, boolean z) {
        AppMethodBeat.i(33901);
        ArrayList qG = selectContactUI.qG(z);
        AppMethodBeat.o(33901);
        return qG;
    }

    /* Access modifiers changed, original: protected|final */
    public final void Kh() {
        AppMethodBeat.i(33872);
        super.Kh();
        this.zon = getIntent().getIntExtra("list_attr", s.znD);
        this.title = getIntent().getStringExtra("titile");
        this.jcF = getIntent().getStringExtra("sub_title");
        this.zkf = getIntent().getIntExtra("list_type", -1);
        this.zoo = getIntent().getBooleanExtra("show_too_many_member", true);
        this.nHU = getIntent().getStringExtra("label_source");
        if (s.hr(this.zon, 256) && t.Zi().size() == 0) {
            s.hs(this.zon, 256);
        }
        this.zoG = getIntent().getBooleanExtra("Add_SendCard", false);
        this.zoH = getIntent().getBooleanExtra("recommend_friends", false);
        if (this.zoG || this.zoH) {
            this.zoI = bo.bc(getIntent().getStringExtra("be_send_card_name"), "");
            this.zoJ = bo.bc(getIntent().getStringExtra("received_card_name"), "");
        }
        this.zoK = getIntent().getBooleanExtra("Forbid_SelectChatRoom", false);
        this.elZ = new ArrayList();
        this.gnG = new HashSet();
        this.zol = new HashSet();
        String stringExtra = getIntent().getStringExtra("always_select_contact");
        if (!bo.isNullOrNil(stringExtra)) {
            this.zol.addAll(bo.P(stringExtra.split(",")));
        }
        stringExtra = getIntent().getStringExtra("already_select_contact");
        if (!bo.isNullOrNil(stringExtra)) {
            this.gnG.addAll(bo.P(stringExtra.split(",")));
        }
        HashSet hashSet = new HashSet();
        String stringExtra2 = getIntent().getStringExtra("block_contact");
        if (!bo.isNullOrNil(stringExtra2)) {
            hashSet.addAll(bo.P(stringExtra2.split(",")));
        }
        HashSet hashSet2 = new HashSet(hashSet);
        hashSet2.addAll(s.dIf());
        hashSet2.addAll(s.dIg());
        if (this.zoG) {
            hashSet2.removeAll(s.dIf());
        }
        this.elZ.addAll(hashSet2);
        dIj();
        AppMethodBeat.o(33872);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(33873);
        super.onCreate(bundle);
        aw.Rg().a(30, (f) this);
        aw.Rg().a(138, (f) this);
        ab.i("MicroMsg.SelectContactUI", "create!");
        if (!bo.isNullOrNil(this.jcF)) {
            setMMSubTitle(this.jcF);
        }
        if (s.hr(this.zon, 64)) {
            a(1, getString(R.string.s6), (OnMenuItemClickListener) new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(33851);
                    ArrayList c = SelectContactUI.c(SelectContactUI.this, s.hr(SelectContactUI.this.zon, Utility.DEFAULT_STREAM_BUFFER_SIZE));
                    c.remove(r.Yz());
                    boolean z = s.hr(SelectContactUI.this.zon, 4096) && c.size() > 1;
                    if (z) {
                        if (!SelectContactUI.this.zoL) {
                            SelectContactUI.this.zoL = true;
                            SelectContactUI.e(SelectContactUI.this);
                        }
                        ab.i("MicroMsg.SelectContactUI", "Create the chatroom");
                        AppMethodBeat.o(33851);
                        return true;
                    }
                    boolean b = SelectContactUI.b(SelectContactUI.this, SelectContactUI.a(SelectContactUI.this, s.hr(SelectContactUI.this.zon, Utility.DEFAULT_STREAM_BUFFER_SIZE)));
                    AppMethodBeat.o(33851);
                    return b;
                }
            }, b.GREEN);
        }
        Kt();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(33850);
                SelectContactUI.this.aqX();
                SelectContactUI.this.finish();
                if (!SelectContactUI.this.getIntent().getBooleanExtra("stay_in_wechat", true)) {
                    al.n(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(33849);
                            SelectContactUI.this.moveTaskToBack(true);
                            AppMethodBeat.o(33849);
                        }
                    }, 80);
                }
                AppMethodBeat.o(33850);
                return true;
            }
        });
        if (this.zkf != 15) {
            Iterator it = this.gnG.iterator();
            while (it.hasNext()) {
                this.opo.bU((String) it.next(), false);
            }
        }
        AppMethodBeat.o(33873);
    }

    public void onDestroy() {
        AppMethodBeat.i(33874);
        aw.Rg().b(30, (f) this);
        aw.Rg().b(138, (f) this);
        super.onDestroy();
        AppMethodBeat.o(33874);
    }

    public final void mO(int i) {
        AppMethodBeat.i(33875);
        int headerViewsCount = i - getContentLV().getHeaderViewsCount();
        if (headerViewsCount < 0) {
            ab.i("MicroMsg.SelectContactUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", Integer.valueOf(headerViewsCount), Integer.valueOf(i));
            AppMethodBeat.o(33875);
            return;
        }
        com.tencent.mm.ui.contact.a.a Pn = dHV().getItem(headerViewsCount);
        if (Pn == null) {
            AppMethodBeat.o(33875);
        } else if (Pn instanceof k) {
            if (s.hr(this.zon, 16384)) {
                ab.i("MicroMsg.SelectContactUI", "handleClickNonSelect, return the result");
                Intent intent = new Intent();
                String str = "";
                intent.putExtra("Select_Contact", str);
                intent.putExtra("Select_Conv_User", str);
                intent.putExtra("Select_Contact", str);
                setResult(-1, intent);
                finish();
            }
            AppMethodBeat.o(33875);
        } else if (Pn.ehM == null) {
            AppMethodBeat.o(33875);
        } else if (Pn.ehM.field_deleteFlag == 1) {
            AppMethodBeat.o(33875);
        } else {
            String str2 = Pn.ehM.field_username;
            ab.i("MicroMsg.SelectContactUI", "ClickUser=%s", str2);
            if (s.hr(this.zon, 64)) {
                if (!s.hr(this.zon, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) || this.gnG.size() < getIntent().getIntExtra("max_limit_num", BaseClientBuilder.API_PRIORITY_OTHER)) {
                    arR(str2);
                } else if (!this.zol.contains(str2)) {
                    dIb();
                    if (this.gnG.contains(str2)) {
                        this.opo.ajq(str2);
                        this.gnG.remove(str2);
                    } else {
                        str2 = getIntent().getStringExtra("too_many_member_tip_string");
                        if (bo.isNullOrNil(str2)) {
                            str2 = getString(R.string.e1m, new Object[]{Integer.valueOf(getIntent().getIntExtra("max_limit_num", 10))});
                        }
                        h.a(this.mController.ylL, str2, getString(R.string.t6), new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                    }
                }
                Kt();
                dIj();
                dHW().notifyDataSetChanged();
                AppMethodBeat.o(33875);
                return;
            }
            fq(bo.P(new String[]{str2}));
            AppMethodBeat.o(33875);
        }
    }

    private void dIj() {
        int i = 0;
        AppMethodBeat.i(33876);
        if (this.zoo && (this.zkf == 1 || this.zkf == 0)) {
            int size = this.zol != null ? this.zol.size() : 0;
            if (this.gnG != null) {
                i = this.gnG.size();
            }
            this.zop.e(this, size + i, bo.ank(g.Nu().getValue("ChatRoomInviteStartCount")));
        }
        AppMethodBeat.o(33876);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean aow() {
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean aox() {
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final String aoy() {
        return this.title;
    }

    /* Access modifiers changed, original: protected|final */
    public final o aoz() {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(33877);
        com.tencent.mm.ui.contact.c.a aVar = new com.tencent.mm.ui.contact.c.a();
        aVar.zkR = s.hr(this.zon, 16);
        aVar.zkQ = s.hr(this.zon, 32);
        aVar.zkS = !s.hr(this.zon, 4);
        if (s.hr(this.zon, 1)) {
            z = false;
        } else {
            z = true;
        }
        aVar.zkT = z;
        aVar.zkU = s.hr(this.zon, 128);
        aVar.zkV = s.hr(this.zon, 1048576);
        aVar.zkY = s.hr(this.zon, 256);
        if (aVar.zkY) {
            aVar.zkZ = getIntent().getStringExtra("custom_contact");
        }
        if (aVar.zkU) {
            this.zoN = true;
            aVar.zkW = getIntent().getStringExtra("wechat_sport_contact");
            aVar.zkX = getIntent().getStringExtra("wechat_sport_recent_like");
            this.zoO = aVar.zkW;
        }
        if (s.dIh()) {
            aVar.zjx = "@all.contact.without.chatroom.without.openim";
        } else {
            aVar.zjx = "@all.contact.without.chatroom.without.openim.without.openimfavour";
        }
        if (this.scene == 6 || this.scene == 5) {
            aVar.zjx = "@all.contact.without.chatroom.without.openim.without.openimfavour";
        }
        if (getIntent().getBooleanExtra("KBlockOpenImFav", false)) {
            aVar.zjx = "@all.contact.without.chatroom.without.openim.without.openimfavour";
        }
        List list = this.elZ;
        boolean hr = s.hr(this.zon, 1);
        boolean hr2 = s.hr(this.zon, 64);
        if (this.zkf == 15) {
            z2 = true;
        }
        c cVar = new c(this, list, hr, hr2, aVar, z2);
        AppMethodBeat.o(33877);
        return cVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final m aoA() {
        AppMethodBeat.i(33878);
        if (this.zoN) {
            r rVar = new r(this, this.elZ, s.hr(this.zon, 64), this.zoO);
            AppMethodBeat.o(33878);
            return rVar;
        }
        m qVar = new q(this, this.elZ, s.hr(this.zon, 64), this.scene);
        AppMethodBeat.o(33878);
        return qVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(ListView listView, int i) {
        String string;
        AppMethodBeat.i(33879);
        super.a(listView, i);
        if (s.hr(this.zon, 256)) {
            if (this.zoA == null) {
                AnonymousClass11 anonymousClass11 = new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(33858);
                        Intent intent = new Intent();
                        intent.setClassName(SelectContactUI.this, "com.tencent.mm.ui.contact.GroupCardSelectUI");
                        intent.putExtra("group_select_type", true);
                        boolean hr = s.hr(SelectContactUI.this.zon, 16384);
                        intent.putExtra("group_select_need_result", hr);
                        if (!hr) {
                            SelectContactUI.this.startActivity(intent);
                            AppMethodBeat.o(33858);
                        } else if (SelectContactUI.this.zkf == 14) {
                            intent.putExtra("group_multi_select", true);
                            intent.putExtra("already_select_contact", ah.c(SelectContactUI.a(SelectContactUI.this, true), ","));
                            intent.putExtra("max_limit_num", SelectContactUI.this.getIntent().getIntExtra("max_limit_num", 9));
                            SelectContactUI.this.startActivityForResult(intent, 4);
                            AppMethodBeat.o(33858);
                        } else {
                            SelectContactUI.this.startActivityForResult(intent, 0);
                            AppMethodBeat.o(33858);
                        }
                    }
                };
                if (this.zkf == 14) {
                    string = getString(R.string.el);
                } else {
                    string = getString(R.string.e6);
                }
                this.zoA = a(listView, anonymousClass11, string);
            }
            this.zoA.setVisibility(i);
        }
        if (s.hr(this.zon, 512)) {
            if (this.zoB == null) {
                this.zoB = a(listView, new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(33859);
                        com.tencent.mm.plugin.report.service.h.pYm.e(11140, Integer.valueOf(0));
                        d.H(SelectContactUI.this, "pwdgroup", ".ui.FacingCreateChatRoomAllInOneUI");
                        AppMethodBeat.o(33859);
                    }
                }, getString(R.string.bts));
            }
            this.zoB.setVisibility(i);
        }
        if (s.hr(this.zon, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT)) {
            if (this.zoC == null) {
                this.zoC = a(listView, new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(33860);
                        Intent intent = new Intent();
                        intent.setClassName(SelectContactUI.this, "com.tencent.mm.ui.contact.GroupCardSelectUI");
                        intent.putExtra("group_select_type", false);
                        SelectContactUI.this.startActivityForResult(intent, 1);
                        AppMethodBeat.o(33860);
                    }
                }, getString(R.string.e7));
            }
            this.zoC.setVisibility(i);
        }
        if (s.hr(this.zon, 2048)) {
            if (this.zoE == null) {
                this.zoE = a(listView, new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(33861);
                        Intent intent = new Intent();
                        intent.putExtra("list_attr", 16384);
                        d.b(SelectContactUI.this, "brandservice", ".ui.BrandServiceIndexUI", intent, 2);
                        AppMethodBeat.o(33861);
                    }
                }, getString(R.string.ef));
            }
            this.zoE.setVisibility(i);
            this.zoE.setTextSize(16.0f * com.tencent.mm.bz.a.dm(this.zoE.getContext()));
        }
        if (s.hr(this.zon, SQLiteGlobal.journalSizeLimit)) {
            if (this.zoD == null) {
                int i2;
                String str = "";
                int intExtra = getIntent().getIntExtra("topstory_import_type", 0);
                int i3 = R.string.g4w;
                List jT;
                int size;
                if (intExtra == 1) {
                    jT = n.qFA.jT(5);
                    size = bo.ek(jT) ? 0 : jT.size();
                    str = bo.c(jT, ",");
                    i3 = R.string.g4w;
                    intExtra = R.string.g4x;
                    i2 = size;
                } else if (intExtra == 2) {
                    jT = t.Zn();
                    size = bo.ek(jT) ? 0 : jT.size();
                    str = bo.c(jT, ",");
                    i3 = R.string.g4u;
                    intExtra = R.string.g4v;
                    i2 = size;
                } else {
                    intExtra = R.string.g4x;
                    i2 = 0;
                }
                this.zoD = a(listView, new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(33863);
                        h.d(SelectContactUI.this, SelectContactUI.this.getString(intExtra, new Object[]{Integer.valueOf(i2)}), "", SelectContactUI.this.getString(R.string.g4t), SelectContactUI.this.getString(R.string.or), new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(33862);
                                Intent intent = new Intent();
                                intent.putExtra("Select_Contact", str);
                                intent.putExtra("App_MsgId", "fromSns");
                                SelectContactUI.this.setResult(-1, intent);
                                SelectContactUI.this.finish();
                                AppMethodBeat.o(33862);
                            }
                        }, null);
                        AppMethodBeat.o(33863);
                    }
                }, getString(i3));
                this.zoD.setTag(Integer.valueOf(i2));
            }
            Object tag = this.zoD.getTag();
            if (!(tag instanceof Integer) || ((Integer) tag).intValue() <= 0) {
                this.zoD.setVisibility(8);
            } else {
                this.zoD.setVisibility(i);
            }
        }
        if (s.hr(this.zon, 16777216) && this.zoF == null) {
            aw.ZK();
            ab.i("MicroMsg.SelectContactUI", "setOpenIMHeaderView %s", Integer.valueOf(c.XM().dsq().size()));
            if (c.XM().dsq().size() != 0) {
                this.zoF = a(listView, new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(33864);
                        Intent intent = new Intent(SelectContactUI.this.getIntent());
                        intent.setClass(SelectContactUI.this.mController.ylL, OpenIMSelectContactUI.class);
                        intent.removeExtra("titile");
                        intent.putExtra("openim_appid", "3552365301");
                        List arrayList = new ArrayList();
                        Iterator it = SelectContactUI.this.gnG.iterator();
                        while (it.hasNext()) {
                            String str = (String) it.next();
                            if (ad.aox(str)) {
                                arrayList.add(str);
                            }
                        }
                        intent.putExtra("already_select_contact", bo.c(arrayList, ","));
                        SelectContactUI.this.startActivityForResult(intent, 5);
                        AppMethodBeat.o(33864);
                    }
                }, "");
                string = ((com.tencent.mm.openim.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.openim.a.b.class)).a("3552365301", "openim_acct_type_title", com.tencent.mm.openim.a.b.a.TYPE_WORDING);
                this.zoF.setVisibility(i);
                this.zoF.setText(string);
            }
        }
        if (!s.hr(this.zon, 16777216) || this.zoF == null) {
            if (s.hr(this.zon, 2048)) {
                if (this.zoE != null) {
                    this.zoE.setBackgroundResource(R.drawable.k7);
                    AppMethodBeat.o(33879);
                    return;
                }
            } else if (s.hr(this.zon, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT)) {
                if (this.zoC != null) {
                    this.zoC.setBackgroundResource(R.drawable.k7);
                    AppMethodBeat.o(33879);
                    return;
                }
            } else if (s.hr(this.zon, 512)) {
                if (this.zoB != null) {
                    this.zoB.setBackgroundResource(R.drawable.k7);
                    AppMethodBeat.o(33879);
                    return;
                }
            } else if (s.hr(this.zon, 256) && this.zoA != null) {
                this.zoA.setBackgroundResource(R.drawable.k7);
            }
            AppMethodBeat.o(33879);
            return;
        }
        this.zoF.setBackgroundResource(R.drawable.k7);
        AppMethodBeat.o(33879);
    }

    private TextView a(ListView listView, OnClickListener onClickListener, String str) {
        AppMethodBeat.i(33880);
        View inflate = v.hu(this).inflate(R.layout.a6i, null);
        inflate.setOnClickListener(onClickListener);
        TextView textView = (TextView) inflate.findViewById(R.id.b14);
        textView.setText(str);
        listView.addHeaderView(inflate);
        AppMethodBeat.o(33880);
        return textView;
    }

    private boolean fq(final List<String> list) {
        AppMethodBeat.i(33881);
        ab.i("MicroMsg.SelectContactUI", "handleSelect %s", list);
        boolean z;
        if (s.hr(this.zon, 65536)) {
            String fs = fs(list);
            this.zoM = true;
            h.a(this.mController.ylL, fs, null, true, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(33865);
                    SelectContactUI.this.zoM = SelectContactUI.a(SelectContactUI.this, list);
                    AppMethodBeat.o(33865);
                }
            }, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(33866);
                    SelectContactUI.this.zoM = false;
                    AppMethodBeat.o(33866);
                }
            });
            z = this.zoM;
            AppMethodBeat.o(33881);
            return z;
        }
        z = fr(list);
        AppMethodBeat.o(33881);
        return z;
    }

    private boolean fr(List<String> list) {
        boolean z = false;
        AppMethodBeat.i(33882);
        Intent intent;
        if (getIntent().getBooleanExtra("Add_SendCard", false)) {
            if (bo.isNullOrNil(this.zoI)) {
                this.zoI = bo.c((List) list, ",");
            } else if (bo.isNullOrNil(this.zoJ)) {
                this.zoJ = bo.c((List) list, ",");
            } else {
                ab.e("MicroMsg.SelectContactUI", "send card occur error: send:%s | receive:%s", this.zoI, this.zoJ);
                AppMethodBeat.o(33882);
                return false;
            }
            z = t.kH(this.zoJ);
            intent = new Intent();
            intent.putExtra("be_send_card_name", this.zoI);
            intent.putExtra("received_card_name", this.zoJ);
            intent.putExtra("Is_Chatroom", z);
            setResult(-1, intent);
            finish();
        } else if (getIntent().getBooleanExtra("snsPostWhoCanSee", false)) {
            ab.i("MicroMsg.SelectContactUI", "sns post who can see scene,users=%s", list.toString());
            ArrayList qF = qF(false);
            qF.remove(r.Yz());
            boolean z2 = false;
            for (String str : list) {
                if (!bo.isNullOrNil(str)) {
                    if (!(qF.contains(str) || r.Yz().equals(str))) {
                        aw.ZK();
                        ad aoO = c.XM().aoO(str);
                        if (!(aoO == null || ((int) aoO.ewQ) == 0 || !com.tencent.mm.n.a.jh(aoO.field_type))) {
                            arR(str);
                            qF.add(str);
                            z = true;
                            z2 = z;
                        }
                    }
                }
                z = z2;
                z2 = z;
            }
            if (z2) {
                Kt();
                dHV().notifyDataSetChanged();
            } else {
                dIl();
            }
        } else if (getIntent().getBooleanExtra("recommend_friends", false)) {
            ab.i("MicroMsg.SelectContactUI", "Recommend Friends");
            z.a(this.mController.ylL, this.zoJ, list);
        } else if (s.hr(this.zon, 16384)) {
            ab.i("MicroMsg.SelectContactUI", "return the result");
            intent = new Intent();
            String c = bo.c((List) list, ",");
            intent.putExtra("Select_Contact", c);
            intent.putExtra("Select_Conv_User", c);
            intent.putExtra("Select_Contact", c);
            intent.putExtra("label_source", this.nHU);
            c = "Is_Chatroom";
            if (this.requestCode == 1) {
                z = true;
            }
            intent.putExtra(c, z);
            setResult(-1, intent);
            finish();
        } else if (getIntent().getBooleanExtra("shareImage", false)) {
            ab.i("MicroMsg.SelectContactUI", "Share Image");
            dIk();
        } else if (list.size() > 0) {
            ab.i("MicroMsg.SelectContactUI", "Launch ChattingUI: users=%s", list.toString());
            finish();
            intent = new Intent();
            intent.setClass(this, ChattingUI.class);
            intent.putExtra("Chat_User", (String) list.get(0));
            intent.addFlags(67108864);
            startActivity(intent);
        } else {
            ab.e("MicroMsg.SelectContactUI", "unkown action: User=%s", list.toString());
        }
        AppMethodBeat.o(33882);
        return true;
    }

    private void Kt() {
        AppMethodBeat.i(33883);
        if (!s.hr(this.zon, 64) || this.gnG.size() <= 0) {
            updateOptionMenuText(1, getString(R.string.s6));
            enableOptionMenu(1, false);
            AppMethodBeat.o(33883);
            return;
        }
        updateOptionMenuText(1, getString(R.string.s6) + "(" + this.gnG.size() + ")");
        int intExtra = getIntent().getIntExtra("min_limit_num", 0);
        if (!s.hr(this.zon, 262144) || this.gnG.size() >= intExtra) {
            enableOptionMenu(1, true);
            AppMethodBeat.o(33883);
            return;
        }
        enableOptionMenu(1, false);
        AppMethodBeat.o(33883);
    }

    private ArrayList<String> qF(boolean z) {
        AppMethodBeat.i(33884);
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        Iterator it = this.gnG.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (z || !t.mW(str)) {
                hashSet.add(str);
            } else {
                List<String> mz = com.tencent.mm.model.n.mz(str);
                if (mz != null) {
                    for (String str2 : mz) {
                        hashSet.add(str2);
                    }
                }
            }
        }
        arrayList.addAll(hashSet);
        AppMethodBeat.o(33884);
        return arrayList;
    }

    private ArrayList<String> qG(boolean z) {
        AppMethodBeat.i(33885);
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        Iterator it = this.gnG.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (z || !t.mW(str)) {
                hashSet.add(str);
            } else {
                List<String> mz = com.tencent.mm.model.n.mz(str);
                if (mz != null) {
                    for (String str2 : mz) {
                        hashSet.add(str2);
                    }
                }
            }
        }
        hashSet.addAll(this.zol);
        arrayList.addAll(hashSet);
        AppMethodBeat.o(33885);
        return arrayList;
    }

    private void dIk() {
        AppMethodBeat.i(33886);
        final ArrayList qF = qF(true);
        qF.remove(r.Yz());
        if (qF.size() > 0) {
            this.ehJ = h.b(this.mController.ylL, getString(R.string.cw8), false, null);
            aw.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(33852);
                    String Yz = r.Yz();
                    Iterator it = qF.iterator();
                    int i = 0;
                    String str = null;
                    while (it.hasNext()) {
                        String str2 = (String) it.next();
                        ab.d("MicroMsg.SelectContactUI", "toSend, %s", str2);
                        int i2 = i + (t.kH(str2) ? 1 : 0);
                        m lVar = new l(4, Yz, str2, SelectContactUI.this.getIntent().getStringExtra("shareImagePath"), 0, null, 0, "", str, true, R.drawable.b0p);
                        aw.Rg().a(lVar, 0);
                        if (lVar.csG != null) {
                            str = lVar.csG.field_imgPath;
                        }
                        i = i2;
                    }
                    SelectContactUI.this.ehJ.dismiss();
                    Intent intent = new Intent();
                    intent.putStringArrayListExtra("Select_Contact", qF);
                    SelectContactUI.this.setResult(-1, intent);
                    com.tencent.mm.plugin.report.service.h.pYm.e(11048, Integer.valueOf(1), Integer.valueOf(qF.size() - i), Integer.valueOf(i));
                    SelectContactUI.this.finish();
                    AppMethodBeat.o(33852);
                }
            });
        }
        AppMethodBeat.o(33886);
    }

    private void dIl() {
        AppMethodBeat.i(33887);
        List qF = qF(false);
        qF.remove(r.Yz());
        final String c = bo.c(qF, ",");
        if (bo.ek(qF)) {
            Intent intent = new Intent();
            intent.putExtra("Select_Contact", c);
            intent.putExtra("Select_Conv_User", c);
            intent.putExtra("Select_Contact", c);
            intent.putExtra("Select_Contacts_To_Create_New_Label", c);
            setResult(0, intent);
            finish();
            AppMethodBeat.o(33887);
            return;
        }
        h.a(this.mController.ylL, true, getString(R.string.clc), "", getString(R.string.clb), getString(R.string.cla), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(33853);
                ab.i("MicroMsg.SelectContactUI", "return the result,and create new label");
                Intent intent = new Intent();
                intent.putExtra("Select_Contact", c);
                intent.putExtra("Select_Conv_User", c);
                intent.putExtra("Select_Contact", c);
                intent.putExtra("Select_Contacts_To_Create_New_Label", c);
                SelectContactUI.this.setResult(-1, intent);
                SelectContactUI.this.finish();
                AppMethodBeat.o(33853);
            }
        }, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(33854);
                ab.i("MicroMsg.SelectContactUI", "return the result");
                Intent intent = new Intent();
                intent.putExtra("Select_Contact", c);
                intent.putExtra("Select_Conv_User", c);
                intent.putExtra("Select_Contact", c);
                SelectContactUI.this.setResult(-1, intent);
                SelectContactUI.this.finish();
                AppMethodBeat.o(33854);
            }
        });
        AppMethodBeat.o(33887);
    }

    private void a(final com.tencent.mm.roomsdk.a.c.a aVar) {
        AppMethodBeat.i(33888);
        aVar.d(new com.tencent.mm.roomsdk.a.b.c() {
            public final /* synthetic */ void a(int i, int i2, String str, com.tencent.mm.roomsdk.a.b.a aVar) {
                AppMethodBeat.i(33855);
                com.tencent.mm.roomsdk.a.b.c cVar = (com.tencent.mm.roomsdk.a.b.c) aVar;
                SelectContactUI.this.zoL = false;
                if (!com.tencent.mm.ui.u.a.a(SelectContactUI.this, i, i2, str, 4)) {
                    if (i == 0 && i2 == 0 && !bo.isNullOrNil(this.chatroomName)) {
                        if (aVar.dmW()) {
                            com.tencent.mm.model.m.a(this.chatroomName, cVar.ehj, SelectContactUI.this.getString(R.string.aju), false, "");
                        }
                        List list = cVar.cGd;
                        if (list != null && list.size() > 0) {
                            LinkedList linkedList = new LinkedList();
                            for (int i3 = 0; i3 < list.size(); i3++) {
                                linkedList.add(list.get(i3));
                            }
                            String str2 = "weixin://findfriend/verifycontact/" + this.chatroomName + "/";
                            if (aVar.dmW()) {
                                com.tencent.mm.model.m.a(this.chatroomName, linkedList, SelectContactUI.this.getString(R.string.ajv), true, str2);
                            }
                        }
                        SelectContactUI.b(SelectContactUI.this, bo.P(new String[]{this.chatroomName}));
                    } else {
                        SelectContactUI.a(SelectContactUI.this, i, i2, cVar, str, aVar.dmW());
                        AppMethodBeat.o(33855);
                        return;
                    }
                }
                AppMethodBeat.o(33855);
            }
        });
        getString(R.string.tz);
        aVar.a(this, getString(R.string.cmb), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(33856);
                SelectContactUI.this.zoL = false;
                aVar.cancel();
                AppMethodBeat.o(33856);
            }
        });
        AppMethodBeat.o(33888);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(33889);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (!bo.cv(this)) {
            AppMethodBeat.o(33889);
        } else if (com.tencent.mm.ui.u.a.a(this, i, i2, str, 4)) {
            AppMethodBeat.o(33889);
        } else if (i == 0 && i2 == 0) {
            switch (mVar.getType()) {
                case 138:
                    dHV().notifyDataSetChanged();
                    break;
            }
            AppMethodBeat.o(33889);
        } else {
            if (i == 4 && i2 == -24 && !bo.isNullOrNil(str)) {
                Toast.makeText(this, str, 1).show();
            }
            AppMethodBeat.o(33889);
        }
    }

    public final int[] bMP() {
        boolean z = false;
        AppMethodBeat.i(33892);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT));
        if (!getIntent().getBooleanExtra("without_openim", false)) {
            arrayList.add(Integer.valueOf(131081));
        }
        if (!s.hr(this.zon, 1)) {
            arrayList.add(Integer.valueOf(131076));
        }
        if (!s.hr(this.zon, 4)) {
            arrayList.add(Integer.valueOf(131075));
        }
        int[] iArr = new int[arrayList.size()];
        while (true) {
            boolean z2 = z;
            if (z2 < arrayList.size()) {
                iArr[z2] = ((Integer) arrayList.get(z2)).intValue();
                z = z2 + 1;
            } else {
                AppMethodBeat.o(33892);
                return iArr;
            }
        }
    }

    public final void vI(String str) {
        AppMethodBeat.i(33893);
        this.gnG.remove(str);
        dHV().notifyDataSetChanged();
        Kt();
        AppMethodBeat.o(33893);
    }

    private void arR(String str) {
        AppMethodBeat.i(33894);
        if (this.zol.contains(str)) {
            AppMethodBeat.o(33894);
            return;
        }
        dIb();
        this.opo.ajq(str);
        if (this.gnG.contains(str)) {
            this.gnG.remove(str);
            AppMethodBeat.o(33894);
            return;
        }
        this.gnG.add(str);
        AppMethodBeat.o(33894);
    }

    private String fs(List<String> list) {
        AppMethodBeat.i(33895);
        String str = null;
        if (list != null) {
            if (list.size() == 1) {
                str = getString(R.string.e19, new Object[]{s.mJ((String) list.get(0))});
            } else if (list.size() > 1) {
                String string = getString(R.string.tj);
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    if (i == 3) {
                        stringBuilder.append("...");
                        break;
                    }
                    stringBuilder.append(s.mJ((String) list.get(i)));
                    if (i < list.size() - 1) {
                        stringBuilder.append(string);
                    }
                }
                str = getString(R.string.e19, new Object[]{stringBuilder.toString()});
            }
        }
        AppMethodBeat.o(33895);
        return str;
    }

    private static List<String> O(List<String> list) {
        AppMethodBeat.i(33896);
        LinkedList linkedList = new LinkedList();
        if (!aw.RK()) {
            AppMethodBeat.o(33896);
            return linkedList;
        } else if (list == null) {
            AppMethodBeat.o(33896);
            return linkedList;
        } else {
            for (Object obj : list) {
                Object obj2;
                aw.ZK();
                ad aoO = c.XM().aoO(obj2);
                if (!(aoO == null || ((int) aoO.ewQ) == 0)) {
                    obj2 = aoO.Oj();
                }
                linkedList.add(obj2);
            }
            AppMethodBeat.o(33896);
            return linkedList;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(33897);
        super.onActivityResult(i, i2, intent);
        this.requestCode = i;
        ab.i("MicroMsg.SelectContactUI", "requestCode=%d | resultCode=%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i2 != -1) {
            AppMethodBeat.o(33897);
            return;
        }
        String stringExtra;
        Iterator it;
        switch (i) {
            case 0:
                if (!bo.isNullOrNil(intent.getStringExtra("Select_Conv_User"))) {
                    fq(bo.P(new String[]{intent.getStringExtra("Select_Conv_User")}));
                    AppMethodBeat.o(33897);
                    return;
                }
                break;
            case 1:
                stringExtra = intent.getStringExtra("Select_Contact");
                if (!bo.isNullOrNil(stringExtra)) {
                    fq(bo.P(stringExtra.split(",")));
                    AppMethodBeat.o(33897);
                    return;
                }
                break;
            case 2:
                if (intent != null) {
                    if (!bo.isNullOrNil(intent.getStringExtra("Select_Contact"))) {
                        fq(bo.P(new String[]{intent.getStringExtra("Select_Contact")}));
                    }
                    AppMethodBeat.o(33897);
                    return;
                }
                break;
            case 3:
                stringExtra = intent.getStringExtra("Select_Contact");
                if (bo.isNullOrNil(stringExtra)) {
                    ab.i("MicroMsg.SelectContactUI", "GET_LABEL_USERS return usernames is null or empty");
                    AppMethodBeat.o(33897);
                    return;
                }
                ab.i("MicroMsg.SelectContactUI", "GET_LABEL_USERS select username=%s", stringExtra);
                if (s.hr(this.zon, 64)) {
                    for (Object obj : stringExtra.split(",")) {
                        if (this.gnG.add(obj)) {
                            this.opo.ajq(obj);
                        }
                    }
                    Kt();
                    dHV().notifyDataSetChanged();
                    AppMethodBeat.o(33897);
                    return;
                }
                fq(bo.P(new String[]{stringExtra}));
                AppMethodBeat.o(33897);
                return;
            case 4:
                String stringExtra2 = intent.getStringExtra("Select_Conv_User");
                Iterator it2 = this.gnG.iterator();
                while (it2.hasNext()) {
                    this.opo.ajr((String) it2.next());
                }
                this.gnG.clear();
                if (!bo.isNullOrNil(stringExtra2)) {
                    this.gnG.addAll(bo.P(stringExtra2.split(",")));
                }
                it = this.gnG.iterator();
                while (it.hasNext()) {
                    this.opo.bU((String) it.next(), false);
                }
                Kt();
                AppMethodBeat.o(33897);
                return;
            case 5:
                if (intent != null) {
                    String stringExtra3 = intent.getStringExtra("Select_Contact");
                    String stringExtra4 = intent.getStringExtra("Cancel_Select_Contact");
                    List<String> hT = bo.isNullOrNil(stringExtra3) ? null : bo.hT(stringExtra3, ",");
                    List list;
                    if (bo.isNullOrNil(stringExtra4)) {
                        list = null;
                    } else {
                        list = bo.hT(stringExtra4, ",");
                    }
                    if (hT != null) {
                        if (this.opo != null) {
                            for (String stringExtra5 : hT) {
                                if (!this.gnG.contains(stringExtra5)) {
                                    this.opo.ajq(stringExtra5);
                                }
                            }
                        }
                        this.gnG.addAll(hT);
                    }
                    if (list != null) {
                        if (this.opo != null) {
                            for (String stringExtra52 : list) {
                                this.opo.ajq(stringExtra52);
                            }
                        }
                        this.gnG.removeAll(list);
                    }
                    dHV().notifyDataSetChanged();
                    if (getIntent().getBooleanExtra("Add_SendCard", false)) {
                        fq(bo.P(new String[]{stringExtra3}));
                    }
                }
                Kt();
                break;
        }
        AppMethodBeat.o(33897);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bOd() {
        if (this.zoN) {
            return false;
        }
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final void QA(String str) {
        AppMethodBeat.i(33898);
        com.tencent.mm.plugin.report.service.h.pYm.e(11225, Integer.valueOf(1), Integer.valueOf(0));
        Intent intent = new Intent();
        intent.setClassName(this, "com.tencent.mm.ui.contact.SelectLabelContactUI");
        intent.putExtra("label", str);
        HashSet hashSet = new HashSet();
        hashSet.addAll(qF(s.hr(this.zon, Utility.DEFAULT_STREAM_BUFFER_SIZE)));
        hashSet.addAll(this.zol);
        intent.putExtra("always_select_contact", bo.c(new ArrayList(hashSet), ","));
        intent.putExtra("always_select_contact", bo.c(new ArrayList(hashSet), ","));
        if (s.hr(this.zon, 64)) {
            intent.putExtra("list_attr", s.C(16384, 64, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT));
            if (this.zkf == 14) {
                intent.putExtra("max_limit_num", getIntent().getIntExtra("max_limit_num", BaseClientBuilder.API_PRIORITY_OTHER));
            }
        } else {
            intent.putExtra("list_attr", 16384);
        }
        startActivityForResult(intent, 3);
        AppMethodBeat.o(33898);
    }

    public final boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        AppMethodBeat.i(33890);
        boolean contains;
        if (aVar.zmW && aVar.ehM != null) {
            contains = this.gnG.contains(aVar.ehM.field_username);
            AppMethodBeat.o(33890);
            return contains;
        } else if (aVar.zmX && aVar.ehM != null) {
            contains = this.gnG.contains(aVar.ehM.field_username);
            AppMethodBeat.o(33890);
            return contains;
        } else if (aVar instanceof k) {
            contains = this.gnG.isEmpty();
            AppMethodBeat.o(33890);
            return contains;
        } else {
            AppMethodBeat.o(33890);
            return false;
        }
    }

    public final boolean b(com.tencent.mm.ui.contact.a.a aVar) {
        AppMethodBeat.i(33891);
        if (!aVar.zmW || aVar.ehM == null) {
            AppMethodBeat.o(33891);
            return false;
        }
        boolean contains = this.zol.contains(aVar.ehM.field_username);
        AppMethodBeat.o(33891);
        return contains;
    }

    static /* synthetic */ void e(SelectContactUI selectContactUI) {
        AppMethodBeat.i(33902);
        ArrayList<String> qG = selectContactUI.qG(false);
        qG.remove(r.Yz());
        if (qG.size() == 1) {
            selectContactUI.zoL = false;
            selectContactUI.finish();
            selectContactUI.a(ChattingUI.class, new Intent().putExtra("Chat_User", (String) qG.get(0)));
            AppMethodBeat.o(33902);
            return;
        }
        boolean z;
        for (String aox : qG) {
            if (ad.aox(aox)) {
                z = false;
                break;
            }
        }
        z = true;
        if (z) {
            selectContactUI.a(com.tencent.mm.roomsdk.a.b.alY("@chatroom").b("", qG));
            AppMethodBeat.o(33902);
        } else if (s.dIh()) {
            selectContactUI.zoL = false;
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RP().Ry().getBoolean(com.tencent.mm.storage.ac.a.USERINFO_OPENIM_SELECT_ALERT_ID_BOOLEAN, false);
            selectContactUI.zoL = true;
            selectContactUI.a(com.tencent.mm.roomsdk.a.b.alY("@im.chatroom").b("", qG));
            AppMethodBeat.o(33902);
        } else {
            h.a((Context) selectContactUI, selectContactUI.getString(R.string.egx), "", null);
            selectContactUI.zoL = false;
            AppMethodBeat.o(33902);
        }
    }

    static /* synthetic */ void a(SelectContactUI selectContactUI, int i, int i2, com.tencent.mm.roomsdk.a.b.c cVar, String str, boolean z) {
        AppMethodBeat.i(33904);
        String str2 = "";
        String str3 = "";
        String string = com.tencent.mm.sdk.platformtools.ah.getContext().getString(R.string.ajw);
        if (!z) {
            if (cVar != null && !bo.isNullOrNil(cVar.vEO)) {
                h.b((Context) selectContactUI, cVar.vEO, "", true);
                AppMethodBeat.o(33904);
                return;
            } else if (!(z || bo.isNullOrNil(str))) {
                h.b((Context) selectContactUI, str, "", true);
                AppMethodBeat.o(33904);
                return;
            }
        }
        if (i2 == -23) {
            str2 = selectContactUI.getString(R.string.dtb);
            str3 = selectContactUI.getString(R.string.dta);
        }
        List list = cVar.cGd;
        List list2 = cVar.ehk;
        if (list == null || list.size() <= 0 || (list.size() != cVar.cEX && (list2 == null || list2.size() <= 0 || cVar.cEX != list.size() + list2.size()))) {
            String str4;
            list = cVar.ehk;
            if (list == null || list.size() <= 0 || cVar.cEX != list.size()) {
                str4 = str3;
            } else {
                str2 = selectContactUI.getString(R.string.cm_);
                str4 = str3 + selectContactUI.getString(R.string.bx_, new Object[]{bo.c(O(list), string)});
            }
            List<String> list3 = cVar.cGa;
            if (list3 != null && list3.size() > 0) {
                Object obj;
                for (String str32 : list3) {
                    if (ad.aox(str32)) {
                        str2 = selectContactUI.getString(R.string.cm_);
                        str4 = selectContactUI.getString(R.string.cma);
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    str2 = selectContactUI.getString(R.string.cm_);
                    str4 = str4 + selectContactUI.getString(R.string.bxc, new Object[]{bo.c(O(list3), string)});
                }
            }
            if (str2 == null || str2.length() <= 0) {
                Toast.makeText(selectContactUI, selectContactUI.getString(R.string.bwv, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                AppMethodBeat.o(33904);
                return;
            }
            h.b((Context) selectContactUI, str4, str2, true);
            AppMethodBeat.o(33904);
            return;
        }
        final LinkedList linkedList = new LinkedList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            linkedList.add(list.get(i3));
        }
        Assert.assertTrue(linkedList.size() > 0);
        str32 = com.tencent.mm.sdk.platformtools.ah.getContext().getString(R.string.ajw);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(linkedList);
        arrayList.addAll(list2);
        h.a((Context) selectContactUI, selectContactUI.getString(R.string.bxl, new Object[]{bo.c(O(arrayList), str32)}), selectContactUI.getString(R.string.cm_), selectContactUI.getString(R.string.bxk), selectContactUI.getString(R.string.bxj), true, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(33857);
                SelectContactUI.a(SelectContactUI.this, linkedList);
                AppMethodBeat.o(33857);
            }
        }, null);
        AppMethodBeat.o(33904);
    }
}

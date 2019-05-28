package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.se;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.i;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.p;
import com.tencent.mm.vfs.e;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

public class ShakeItemListUI extends MMActivity {
    private com.tencent.mm.at.a.a fGv = null;
    private ListView gxZ;
    private int id;
    private d jKa = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.i(24727);
            m.cjS().Ct(ShakeItemListUI.this.id);
            AppMethodBeat.o(24727);
        }
    };
    private View kmS;
    private boolean quA = false;
    private a quB;
    public long quz = 0;
    private int showType;

    class a extends p<com.tencent.mm.plugin.shake.b.d> {
        b gvm = new b(new com.tencent.mm.ui.applet.b.a() {
            public final Bitmap wd(String str) {
                AppMethodBeat.i(24728);
                Bitmap a = com.tencent.mm.ah.b.a(str, false, -1);
                AppMethodBeat.o(24728);
                return a;
            }
        });
        private b.b gvn = null;
        private int showType = 0;

        class a {
            TextView gtG;
            ImageView gvq;
            TextView gvr;
            TextView oQA;
            ImageView oQB;
            TextView oQz;
            View quG;
            ImageView quH;
            TextView quI;
            LinearLayout quJ;
            TextView quK;

            a() {
            }

            public final void clear() {
                AppMethodBeat.i(24731);
                if (this.gvq != null) {
                    this.gvq.setImageDrawable(null);
                    this.gvq.setVisibility(8);
                }
                if (this.gtG != null) {
                    this.gtG.setText("");
                    this.gtG.setVisibility(8);
                }
                if (this.gvr != null) {
                    this.gvr.setVisibility(8);
                }
                if (this.quH != null) {
                    this.quH.setVisibility(8);
                }
                if (this.oQz != null) {
                    this.oQz.setText("");
                    this.oQz.setVisibility(8);
                }
                if (this.oQA != null) {
                    this.oQA.setVisibility(8);
                    this.quG.setVisibility(8);
                }
                if (this.oQB != null) {
                    this.oQB.setVisibility(8);
                }
                if (this.quI != null) {
                    this.quI.setText("");
                    this.quI.setVisibility(8);
                }
                AppMethodBeat.o(24731);
            }
        }

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            AppMethodBeat.i(24737);
            com.tencent.mm.plugin.shake.b.d dVar = (com.tencent.mm.plugin.shake.b.d) obj;
            if (dVar == null) {
                dVar = new com.tencent.mm.plugin.shake.b.d();
            }
            if (cursor != null) {
                dVar.d(cursor);
            }
            AppMethodBeat.o(24737);
            return dVar;
        }

        public a(ShakeItemListUI shakeItemListUI) {
            super(shakeItemListUI, new com.tencent.mm.plugin.shake.b.d());
            AppMethodBeat.i(24732);
            KD();
            AppMethodBeat.o(24732);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            AppMethodBeat.i(24733);
            if (this.gvn == null) {
                this.gvn = new b.b() {
                    public final String mW(int i) {
                        AppMethodBeat.i(24729);
                        if (i < 0 || i >= a.this.getCount()) {
                            ab.e("MicroMsg.ShakeFriendAdapter", "pos is invalid");
                            AppMethodBeat.o(24729);
                            return null;
                        }
                        com.tencent.mm.plugin.shake.b.d dVar = (com.tencent.mm.plugin.shake.b.d) a.this.getItem(i);
                        if (dVar == null) {
                            AppMethodBeat.o(24729);
                            return null;
                        }
                        String str = dVar.field_username;
                        AppMethodBeat.o(24729);
                        return str;
                    }

                    public final int apO() {
                        AppMethodBeat.i(24730);
                        int count = a.this.getCount();
                        AppMethodBeat.o(24730);
                        return count;
                    }
                };
            }
            if (this.gvm != null) {
                this.gvm.a(i, this.gvn);
            }
            if (view == null) {
                aVar = new a();
                view = View.inflate(this.context, R.layout.as_, null);
                aVar.gvq = (ImageView) view.findViewById(R.id.bi0);
                aVar.gtG = (TextView) view.findViewById(R.id.bi1);
                aVar.gvr = (TextView) view.findViewById(R.id.dgl);
                aVar.quH = (ImageView) view.findViewById(R.id.dgm);
                aVar.oQz = (TextView) view.findViewById(R.id.dgo);
                aVar.oQA = (TextView) view.findViewById(R.id.dgu);
                aVar.oQB = (ImageView) view.findViewById(R.id.dgn);
                aVar.quI = (TextView) view.findViewById(R.id.ebd);
                aVar.quG = view.findViewById(R.id.dgt);
                aVar.quJ = (LinearLayout) view.findViewById(R.id.ebf);
                aVar.quK = (TextView) view.findViewById(R.id.ebe);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            com.tencent.mm.plugin.shake.b.d dVar = (com.tencent.mm.plugin.shake.b.d) getItem(i);
            if (dVar != null) {
                aVar.clear();
                if (4 == dVar.field_type || (k.Cz(dVar.field_type) && 6 != dVar.field_type)) {
                    if (4 != dVar.field_type) {
                        aVar.gvq.setScaleType(ScaleType.CENTER_CROP);
                    }
                    e.a(aVar.gvq, dVar.field_sns_bgurl, R.raw.app_attach_file_icon_webpage, false);
                } else if (11 == dVar.field_type) {
                    ShakeItemListUI.this.fGv.a(dVar.getProvince(), aVar.gvq);
                } else {
                    com.tencent.mm.pluginsdk.ui.a.b.b(aVar.gvq, dVar.field_username);
                }
                aVar.gvq.setVisibility(0);
                if (7 != dVar.field_type && 10 != dVar.field_type && 12 != dVar.field_type && 13 != dVar.field_type && (8 != dVar.field_type || !bo.isNullOrNil(dVar.field_nickname) || !bo.isNullOrNil(dVar.field_username))) {
                    aVar.quK.setVisibility(8);
                    aVar.quJ.setVisibility(0);
                    if (8 == dVar.field_type && bo.isNullOrNil(dVar.field_nickname)) {
                        dVar.field_nickname = dVar.field_distance;
                        dVar.field_distance = dVar.field_username;
                    }
                    aVar.gtG.setText(j.b(this.context, bo.nullAsNil(dVar.field_nickname), aVar.gtG.getTextSize()));
                    aVar.gtG.setVisibility(0);
                    int paddingBottom = view.getPaddingBottom();
                    int paddingTop = view.getPaddingTop();
                    int paddingRight = view.getPaddingRight();
                    int paddingLeft = view.getPaddingLeft();
                    if (dVar.field_insertBatch == 2) {
                        view.setBackgroundDrawable(com.tencent.mm.bz.a.g(this.context, R.drawable.k4));
                    } else {
                        view.setBackgroundDrawable(com.tencent.mm.bz.a.g(this.context, R.drawable.k5));
                    }
                    view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                    switch (dVar.field_type) {
                        case 1:
                        case 2:
                        case 3:
                            aVar.quI.setText(dVar.field_nickname);
                            aVar.quI.setVisibility(0);
                            AppMethodBeat.o(24733);
                            break;
                        default:
                            aVar.quG.setVisibility(0);
                            aVar.oQz.setText(dVar.field_distance);
                            aVar.oQz.setVisibility(0);
                            if (dVar.field_signature == null || dVar.field_signature.trim().equals("")) {
                                aVar.oQA.setVisibility(8);
                            } else {
                                aVar.oQA.setVisibility(0);
                                aVar.oQA.setText(j.b(this.context, dVar.field_signature, aVar.gtG.getTextSize()));
                            }
                            if (dVar.field_sex == 1) {
                                aVar.quH.setVisibility(0);
                                aVar.quH.setImageDrawable(com.tencent.mm.bz.a.g(this.context, R.raw.ic_sex_male));
                                aVar.quH.setContentDescription(this.context.getString(R.string.cwa));
                            } else if (dVar.field_sex == 2) {
                                aVar.quH.setVisibility(0);
                                aVar.quH.setImageDrawable(com.tencent.mm.bz.a.g(this.context, R.raw.ic_sex_female));
                                aVar.quH.setContentDescription(this.context.getString(R.string.bsl));
                            } else {
                                aVar.quH.setVisibility(8);
                            }
                            aw.ZK();
                            ad aoO = c.XM().aoO(dVar.field_username);
                            if (aoO == null || !com.tencent.mm.n.a.jh(aoO.field_type)) {
                                aVar.gvr.setVisibility(8);
                            } else {
                                aVar.gvr.setVisibility(0);
                                if (ad.Mn(dVar.field_reserved1)) {
                                    aVar.gvr.setText(this.context.getString(R.string.d4p));
                                } else {
                                    aVar.gvr.setText(this.context.getString(R.string.d4u));
                                }
                            }
                            if (6 == dVar.field_type) {
                                aVar.oQz.setText(this.context.getString(R.string.eel));
                                aVar.gvr.setVisibility(8);
                            }
                            if (dVar.field_reserved1 != 0) {
                                aVar.oQB.setVisibility(0);
                                aVar.oQB.setImageBitmap(BackwardSupportUtil.b.i(com.tencent.mm.model.ao.a.flw.ky(dVar.field_reserved1), 2.0f));
                                aVar.quH.setVisibility(8);
                            } else {
                                aVar.oQB.setVisibility(8);
                            }
                            AppMethodBeat.o(24733);
                            break;
                    }
                }
                if (8 == dVar.field_type) {
                    aVar.quK.setText(dVar.field_distance);
                } else {
                    aVar.quK.setText(dVar.field_nickname);
                }
                aVar.quK.setVisibility(0);
                aVar.quJ.setVisibility(8);
                AppMethodBeat.o(24733);
            } else {
                aVar.clear();
                AppMethodBeat.o(24733);
            }
            return view;
        }

        public final void KD() {
            AppMethodBeat.i(24734);
            bIf();
            KC();
            AppMethodBeat.o(24734);
        }

        public final void KC() {
            AppMethodBeat.i(24735);
            if (aw.RK()) {
                switch (this.showType) {
                    case -12:
                        setCursor(m.cjS().Cs(ShakeItemListUI.this.getIntent().getIntExtra("_ibeacon_new_insert_size", 2)));
                        break;
                    case -6:
                        setCursor(m.cjS().cjE());
                        break;
                    case -5:
                        setCursor(m.cjS().cjC());
                        break;
                    case -1:
                        setCursor(m.cjS().cjz());
                        break;
                    case 0:
                        setCursor(m.cjS().cjA());
                        break;
                    case 4:
                        setCursor(m.cjS().cjB());
                        break;
                    case 5:
                        setCursor(m.cjS().cjD());
                        break;
                    case 11:
                        setCursor(m.cjS().cjF());
                        break;
                    case 100:
                        setCursor(m.cjS().cjy());
                        break;
                }
                super.notifyDataSetChanged();
                AppMethodBeat.o(24735);
                return;
            }
            AppMethodBeat.o(24735);
        }

        /* Access modifiers changed, original: protected|final */
        public final void CB(int i) {
            AppMethodBeat.i(24736);
            this.showType = i;
            KD();
            AppMethodBeat.o(24736);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ShakeItemListUI() {
        AppMethodBeat.i(24738);
        AppMethodBeat.o(24738);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(24739);
        super.onCreate(bundle);
        initView();
        m.cjS().c(this.quB);
        this.quB.KD();
        ab.i("MicroMsg.ShakeItemListUI", "onResume");
        AppMethodBeat.o(24739);
    }

    public final void initView() {
        AppMethodBeat.i(24740);
        this.fGv = new com.tencent.mm.at.a.a((Context) this);
        aw.ZK();
        final int a = bo.a((Integer) c.Ry().get(12290, null), 0);
        this.showType = getIntent().getIntExtra("_key_show_type_", 0);
        String stringExtra = getIntent().getStringExtra("_key_title_");
        if (!bo.isNullOrNil(stringExtra)) {
            setMMTitle(stringExtra);
        }
        this.quA = getIntent().getBooleanExtra("_key_show_from_shake_", false);
        addTextOptionMenu(0, getString(R.string.ou), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(24720);
                h.a(ShakeItemListUI.this, true, ShakeItemListUI.this.getString(R.string.dx3), "", ShakeItemListUI.this.getString(R.string.ou), ShakeItemListUI.this.getString(R.string.or), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(24719);
                        switch (ShakeItemListUI.this.showType) {
                            case -12:
                            case 11:
                                m.cjS().Cu(11);
                                break;
                            case -6:
                            case 5:
                                m.cjS().Cu(7);
                                m.cjS().Cu(6);
                                m.cjS().Cu(8);
                                m.cjS().Cu(9);
                                m.cjS().Cu(10);
                                m.cjS().Cu(12);
                                break;
                            case -5:
                            case 4:
                                aw.RS().aa(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(24634);
                                        e.N(i.ckx(), true);
                                        AppMethodBeat.o(24634);
                                    }

                                    public final String toString() {
                                        AppMethodBeat.i(24635);
                                        String str = super.toString() + "|asyncClearMusicData";
                                        AppMethodBeat.o(24635);
                                        return str;
                                    }
                                });
                                m.cjS().Cu(4);
                                break;
                            case -1:
                            case 0:
                                m.cjS().Cu(0);
                                break;
                            case 100:
                                m.cjS().Cu(0);
                                m.cjS().cjH();
                                break;
                        }
                        ShakeItemListUI.this.quB.KC();
                        ShakeItemListUI.this.gxZ.setVisibility(8);
                        TextView textView = (TextView) ShakeItemListUI.this.findViewById(R.id.dgi);
                        textView.setText(ShakeItemListUI.CC(ShakeItemListUI.this.showType));
                        textView.setVisibility(0);
                        ShakeItemListUI.this.enableOptionMenu(false);
                        AppMethodBeat.o(24719);
                    }
                }, null);
                AppMethodBeat.o(24720);
                return true;
            }
        });
        this.gxZ = (ListView) findViewById(R.id.dgh);
        this.kmS = getLayoutInflater().inflate(R.layout.asa, null);
        this.kmS.findViewById(R.id.ebg).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(24721);
                ShakeItemListUI.this.showType = ShakeItemListUI.this.showType ^ -1;
                ShakeItemListUI.this.CB(ShakeItemListUI.this.showType);
                AppMethodBeat.o(24721);
            }
        });
        this.gxZ.addFooterView(this.kmS);
        if (this.showType == -1) {
            this.kmS.findViewById(R.id.ebg).setVisibility(0);
        } else {
            this.kmS.findViewById(R.id.ebg).setVisibility(8);
        }
        this.quB = new a(this);
        this.quB.CB(this.showType);
        if (this.quB.getCount() <= 0) {
            this.gxZ.setVisibility(8);
            TextView textView = (TextView) findViewById(R.id.dgi);
            textView.setText(CC(this.showType));
            textView.setVisibility(0);
            enableOptionMenu(false);
        } else {
            this.gxZ.setAdapter(this.quB);
            this.gxZ.setOnItemClickListener(new OnItemClickListener() {
                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppMethodBeat.i(24722);
                    com.tencent.mm.plugin.shake.b.d dVar = (com.tencent.mm.plugin.shake.b.d) ShakeItemListUI.this.quB.getItem(i);
                    if (dVar == null) {
                        AppMethodBeat.o(24722);
                        return;
                    }
                    com.tencent.mm.plugin.shake.b.e cjS = m.cjS();
                    if (dVar == null) {
                        ab.w("MicroMsg.NewShakeItemStorage", "setRead, but item is null");
                    } else {
                        dVar.field_insertBatch = 1;
                        dVar.bJt = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                        if (-1 != cjS.bSd.update("shakeitem1", dVar.Hl(), "shakeItemID=? and insertBatch=?", new String[]{dVar.field_shakeItemID, "2"})) {
                            cjS.doNotify();
                        }
                    }
                    int i2 = dVar.field_type;
                    Intent intent;
                    if (i2 == 4) {
                        intent = new Intent();
                        if (com.tencent.mm.aw.d.aio()) {
                            com.tencent.mm.aw.a.b(i.d(dVar.field_lvbuffer, 0));
                        } else {
                            com.tencent.mm.aw.a.aic();
                            intent.putExtra("key_mode", 1);
                            intent.putExtra("KGlobalShakeMusic", true);
                            com.tencent.mm.aw.a.c(i.d(dVar.field_lvbuffer, 0));
                        }
                        intent.putExtra("key_scene", 3);
                        com.tencent.mm.bp.d.b(ShakeItemListUI.this, "music", ".ui.MusicMainUI", intent);
                        AppMethodBeat.o(24722);
                    } else if (i2 == 11) {
                        if (System.currentTimeMillis() - ShakeItemListUI.this.quz > FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
                            ShakeItemListUI.this.quz = System.currentTimeMillis();
                            if (dVar.field_reserved3 == null || dVar.field_reserved3.split(",").length != 3 || dVar.field_reserved3.split(",")[0] == null || dVar.field_reserved3.split(",")[0].equals("")) {
                                intent = new Intent();
                                intent.putExtra("rawUrl", dVar.getCity());
                                intent.putExtra("scene", 27);
                                intent.putExtra("stastic_scene", 5);
                                com.tencent.mm.bp.d.b(ah.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                            } else {
                                String[] split = dVar.field_reserved3.split(",");
                                se seVar = new se();
                                seVar.cOf.userName = split[0];
                                seVar.cOf.cOh = bo.bc(split[1], "");
                                seVar.cOf.cOi = Integer.parseInt(split[2]);
                                seVar.cOf.scene = FilterEnum4Shaka.MIC_WEISHI_HEICHA;
                                com.tencent.mm.sdk.b.a.xxA.m(seVar);
                            }
                            if (ShakeItemListUI.this.quA) {
                                com.tencent.mm.plugin.shake.d.a.h.a(dVar);
                                com.tencent.mm.plugin.shake.d.a.h.b(dVar);
                            }
                        }
                        AppMethodBeat.o(24722);
                    } else if (k.Cz(i2)) {
                        k.a(dVar, ShakeItemListUI.this, true);
                        AppMethodBeat.o(24722);
                    } else {
                        String str = dVar.field_username;
                        aw.ZK();
                        ad aoO = c.XM().aoO(str);
                        ab.d("MicroMsg.ShakeItemListUI", "listView onTtemClick username:" + str + " display:" + dVar.field_nickname + " position:" + i + " contactName" + aoO.field_username);
                        ab.d("MicroMsg.ShakeItemListUI", "isContact:" + com.tencent.mm.n.a.jh(aoO.field_type) + "  contact:" + aoO);
                        if (com.tencent.mm.n.a.jh(aoO.field_type)) {
                            Intent intent2 = new Intent();
                            intent2.putExtra("Contact_User", str);
                            intent2.putExtra("Contact_Scene", a == dVar.field_sex ? 23 : 24);
                            intent2.putExtra("Sns_from_Scene", 22);
                            if (str != null && str.length() > 0) {
                                if (aoO.dsf()) {
                                    com.tencent.mm.plugin.report.service.h.pYm.X(10298, dVar.field_username + "," + intent2.getIntExtra("Contact_Scene", 23));
                                    intent2.putExtra("Contact_Scene", 23);
                                }
                                com.tencent.mm.plugin.shake.a.gkE.c(intent2, ShakeItemListUI.this);
                            }
                            AppMethodBeat.o(24722);
                            return;
                        }
                        ab.d("MicroMsg.ShakeItemListUI", "listView onTtemClick username:" + str + " display:" + dVar.field_nickname + " position:" + i + " contactName" + aoO.field_username);
                        Intent intent3 = new Intent();
                        intent3.putExtra("Contact_User", dVar.field_username);
                        intent3.putExtra("Contact_Nick", dVar.field_nickname);
                        intent3.putExtra("Contact_Distance", dVar.field_distance);
                        intent3.putExtra("Contact_Signature", dVar.field_signature);
                        intent3.putExtra("Contact_Province", dVar.getProvince());
                        intent3.putExtra("Contact_City", dVar.getCity());
                        intent3.putExtra("Contact_Sex", dVar.field_sex);
                        intent3.putExtra("Contact_IsLBSFriend", true);
                        intent3.putExtra("Contact_VUser_Info", dVar.field_reserved3);
                        intent3.putExtra("Contact_VUser_Info_Flag", dVar.field_reserved1);
                        intent3.putExtra("Contact_Scene", a == dVar.field_sex ? 23 : 24);
                        intent3.putExtra("Sns_from_Scene", 22);
                        intent3.putExtra("Contact_KSnsIFlag", dVar.field_snsFlag);
                        intent3.putExtra("Contact_KSnsBgUrl", dVar.field_sns_bgurl);
                        if ((dVar.field_reserved1 & 8) > 0) {
                            com.tencent.mm.plugin.report.service.h.pYm.X(10298, dVar.field_username + "," + intent3.getIntExtra("Contact_Scene", 23));
                        }
                        com.tencent.mm.plugin.shake.a.gkE.c(intent3, ShakeItemListUI.this);
                        AppMethodBeat.o(24722);
                    }
                }
            });
            final com.tencent.mm.ui.tools.j jVar = new com.tencent.mm.ui.tools.j(this);
            this.gxZ.setOnItemLongClickListener(new OnItemLongClickListener() {
                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppMethodBeat.i(24723);
                    if (i < ShakeItemListUI.this.gxZ.getHeaderViewsCount()) {
                        ab.w("MicroMsg.ShakeItemListUI", "on header view long click, ignore");
                        AppMethodBeat.o(24723);
                    } else {
                        jVar.a(view, i, j, ShakeItemListUI.this, ShakeItemListUI.this.jKa);
                        AppMethodBeat.o(24723);
                    }
                    return true;
                }
            });
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(24724);
                ShakeItemListUI.this.aqX();
                ShakeItemListUI.this.finish();
                AppMethodBeat.o(24724);
                return true;
            }
        });
        AnonymousClass6 anonymousClass6 = new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(24725);
                BackwardSupportUtil.c.a(ShakeItemListUI.this.gxZ);
                AppMethodBeat.o(24725);
            }
        };
        this.gxZ.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(24726);
                if (ShakeItemListUI.this.quB != null) {
                    a b = ShakeItemListUI.this.quB;
                    if (b.gvm != null) {
                        b.gvm.onTouchEvent(motionEvent);
                    }
                }
                AppMethodBeat.o(24726);
                return false;
            }
        });
        AppMethodBeat.o(24740);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(24741);
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        this.id = ((com.tencent.mm.plugin.shake.b.d) this.quB.getItem(adapterContextMenuInfo.position)).field_shakeItemID;
        contextMenu.add(adapterContextMenuInfo.position, 0, 0, R.string.p4);
        AppMethodBeat.o(24741);
    }

    public void onPause() {
        AppMethodBeat.i(24742);
        super.onPause();
        AppMethodBeat.o(24742);
    }

    public void onDestroy() {
        AppMethodBeat.i(24743);
        this.quB.bIf();
        a aVar = this.quB;
        if (aVar.gvm != null) {
            aVar.gvm.detach();
            aVar.gvm = null;
        }
        m.cjS().d(this.quB);
        ab.i("MicroMsg.ShakeItemListUI", "onPause");
        if (this.fGv != null) {
            this.fGv.detach();
        }
        super.onDestroy();
        AppMethodBeat.o(24743);
    }

    /* Access modifiers changed, original: protected|final */
    public final void CB(int i) {
        AppMethodBeat.i(24744);
        this.quB.CB(i);
        switch (i) {
            case -12:
            case -1:
                if (this.kmS != null) {
                    this.kmS.findViewById(R.id.ebg).setVisibility(0);
                    break;
                }
                break;
            case 0:
            case 11:
                if (this.kmS != null) {
                    this.kmS.findViewById(R.id.ebg).setVisibility(8);
                    AppMethodBeat.o(24744);
                    return;
                }
                break;
        }
        AppMethodBeat.o(24744);
    }

    public final int getLayoutId() {
        return R.layout.as9;
    }

    public static int CC(int i) {
        switch (i) {
            case -12:
            case 11:
                return R.string.eep;
            case -6:
            case 5:
                return R.string.egi;
            case -5:
            case 4:
                return R.string.eff;
            case 100:
                return R.string.eem;
            default:
                return R.string.eei;
        }
    }
}

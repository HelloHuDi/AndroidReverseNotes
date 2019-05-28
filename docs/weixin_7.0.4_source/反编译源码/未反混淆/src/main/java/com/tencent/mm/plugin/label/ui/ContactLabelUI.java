package com.tencent.mm.plugin.label.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.label.b.d;
import com.tencent.mm.plugin.label.e;
import com.tencent.mm.plugin.label.ui.widget.MMLabelPanel;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cmh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.MMTagPanelScrollView;
import com.tencent.mm.ui.q.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class ContactLabelUI extends ContactLabelBaseUI implements f {
    private String edV;
    private MMTagPanelScrollView nIC;
    private MMLabelPanel nID;
    private TextView nIE;
    private View nIF;
    private View nIG;
    private TextView nIH;
    private MMLabelPanel nII;
    private ListView nIJ;
    private ScrollView nIK;
    private b nIL;
    private String nIM;
    private ArrayList<String> nIN;
    private HashSet<String> nIO = new HashSet();
    private HashSet<String> nIP = new HashSet();
    private ArrayList<String> nIQ = new ArrayList();
    private a nIR = a.Normal;
    private boolean nIS = false;
    private ArrayList<String> nIT;
    private boolean nId = true;

    enum a {
        Normal,
        Search,
        OverMaxCount,
        Invaildnput;

        static {
            AppMethodBeat.o(22679);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ContactLabelUI() {
        AppMethodBeat.i(22680);
        AppMethodBeat.o(22680);
    }

    static /* synthetic */ void a(ContactLabelUI contactLabelUI, String str, boolean z) {
        AppMethodBeat.i(22698);
        contactLabelUI.aR(str, z);
        AppMethodBeat.o(22698);
    }

    public final int getLayoutId() {
        return R.layout.qx;
    }

    public final void initView() {
        AppMethodBeat.i(22681);
        setMMTitle(getString(R.string.cq));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(22658);
                ContactLabelUI.this.onBackPressed();
                AppMethodBeat.o(22658);
                return false;
            }
        });
        a(0, getString(R.string.tc), (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(22662);
                ContactLabelUI.a(ContactLabelUI.this);
                AppMethodBeat.o(22662);
                return false;
            }
        }, b.GREEN);
        this.nIC = (MMTagPanelScrollView) findViewById(R.id.b4_);
        this.nIC.setMaxLine(3);
        this.nID = (MMLabelPanel) findViewById(R.id.b4a);
        this.nIE = (TextView) findViewById(R.id.b4b);
        this.nIF = findViewById(R.id.b4d);
        this.nIG = findViewById(R.id.b4f);
        this.nIG.setBackgroundDrawable(null);
        this.nIH = (TextView) this.nIG.findViewById(16908310);
        this.nIH.setText(R.string.cl7);
        this.nII = (MMLabelPanel) findViewById(R.id.b4g);
        this.nIJ = (ListView) findViewById(R.id.b4h);
        this.nIK = (ScrollView) findViewById(R.id.b4c);
        if (this.nIK != null) {
            this.nIK.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(22663);
                    if (motionEvent.getAction() == 2) {
                        ContactLabelUI.this.aqX();
                    }
                    AppMethodBeat.o(22663);
                    return false;
                }
            });
        }
        this.nID.yxp = true;
        this.nID.qe(true);
        this.nID.setTagEditTextBG(R.drawable.a2s);
        this.nID.setCallBack(new com.tencent.mm.ui.base.MMTagPanel.a() {
            public final void JR(String str) {
                AppMethodBeat.i(22664);
                ab.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagUnSelected] tag:%s", str);
                ContactLabelUI.this.nID.removeTag(str);
                if (ContactLabelUI.this.nII != null) {
                    ContactLabelUI.this.nII.cd(str, false);
                }
                ContactLabelUI.a(ContactLabelUI.this, str);
                AppMethodBeat.o(22664);
            }

            public final void JS(String str) {
                AppMethodBeat.i(22665);
                ab.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagSelected] tag:%s", str);
                AppMethodBeat.o(22665);
            }

            public final void JT(String str) {
                AppMethodBeat.i(22666);
                ab.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagRemove] tag:%s", str);
                if (ContactLabelUI.this.nII != null) {
                    ContactLabelUI.this.nII.cd(str, false);
                }
                ContactLabelUI.a(ContactLabelUI.this, str);
                AppMethodBeat.o(22666);
            }

            public final void bmm() {
                AppMethodBeat.i(22667);
                ab.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagEditTextClick]");
                AppMethodBeat.o(22667);
            }

            public final void JU(String str) {
                AppMethodBeat.i(22668);
                ab.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagEditTextChange] curText:%s", str);
                ContactLabelUI.b(ContactLabelUI.this, str);
                AppMethodBeat.o(22668);
            }

            public final void JV(String str) {
                AppMethodBeat.i(22669);
                ab.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagCreate] tag:%s", String.valueOf(str));
                if (bo.isNullOrNil(str)) {
                    ab.d("MicroMsg.Label.ContactLabelUI", "tag is null.");
                    AppMethodBeat.o(22669);
                    return;
                }
                ContactLabelUI.this.nID.cc(str, true);
                if (ContactLabelUI.this.nII != null) {
                    ContactLabelUI.this.nII.cd(str, true);
                }
                ContactLabelUI.a(ContactLabelUI.this, str, ContactLabelUI.this.nIS);
                AppMethodBeat.o(22669);
            }

            public final void q(boolean z, int i) {
                AppMethodBeat.i(22670);
                ab.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagLengthMax] match:%s exceedCount:%d", String.valueOf(z), Integer.valueOf(i));
                if (z) {
                    ContactLabelUI.this.enableOptionMenu(false);
                    ContactLabelUI.this.nIE.setVisibility(0);
                    ContactLabelUI.this.nIE.setText(R.string.cl8);
                    ContactLabelUI.this.nIE.setText(String.format(ContactLabelUI.this.getString(R.string.cl8), new Object[]{Integer.valueOf(com.tencent.mm.ui.tools.f.bP(36, "")), Integer.valueOf(i)}));
                    AppMethodBeat.o(22670);
                    return;
                }
                ContactLabelUI.this.enableOptionMenu(true);
                ContactLabelUI.this.nIE.setVisibility(8);
                AppMethodBeat.o(22670);
            }
        });
        this.nII.qe(false);
        this.nII.setCallBack(new com.tencent.mm.ui.base.MMTagPanel.a() {
            public final void JR(String str) {
                AppMethodBeat.i(22671);
                ab.d("MicroMsg.Label.ContactLabelUI", "cpan[All onTagUnSelected] tag:%s", String.valueOf(str));
                if (ContactLabelUI.this.nID != null) {
                    ContactLabelUI.this.nID.removeTag(str);
                }
                ContactLabelUI.a(ContactLabelUI.this, str);
                AppMethodBeat.o(22671);
            }

            public final void JS(String str) {
                AppMethodBeat.i(22672);
                ab.d("MicroMsg.Label.ContactLabelUI", "cpan[All onTagSelected] tag:%s", String.valueOf(str));
                if (ContactLabelUI.this.nID != null) {
                    ContactLabelUI.this.nID.cc(str, true);
                }
                ContactLabelUI.a(ContactLabelUI.this, str, ContactLabelUI.this.nIS);
                AppMethodBeat.o(22672);
            }

            public final void JT(String str) {
            }

            public final void q(boolean z, int i) {
            }

            public final void bmm() {
            }

            public final void JU(String str) {
            }

            public final void JV(String str) {
            }
        });
        this.nIJ.setAdapter(this.nIL);
        this.nIJ.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(22673);
                if (ContactLabelUI.this.nIL == null) {
                    AppMethodBeat.o(22673);
                    return;
                }
                String item = ContactLabelUI.this.nIL.getItem(i);
                if (!(bo.isNullOrNil(item) || ContactLabelUI.this.nID == null)) {
                    ContactLabelUI.this.nID.dAb();
                    ContactLabelUI.this.nID.cc(item, true);
                    ContactLabelUI.this.nII.cd(item, true);
                }
                AppMethodBeat.o(22673);
            }
        });
        enableOptionMenu(false);
        AppMethodBeat.o(22681);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(22682);
        super.onCreate(bundle);
        this.nIM = getIntent().getStringExtra("label_id_list");
        this.nIN = getIntent().getStringArrayListExtra("label_str_list");
        this.edV = getIntent().getStringExtra("label_username");
        this.nIS = getIntent().getBooleanExtra("is_stranger", false);
        this.nIL = new b(this);
        initView();
        if (!(bo.isNullOrNil(this.nIM) || this.nIN == null || this.nIN.size() <= 0)) {
            this.nID.a((Collection) this.nIN, (List) this.nIN);
        }
        if (this.nIS) {
            this.nIT = getIntent().getStringArrayListExtra("label_str_list");
            this.nID.a((Collection) this.nIT, (List) this.nIT);
        }
        h.pYm.e(16097, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1));
        AppMethodBeat.o(22682);
    }

    public void onResume() {
        AppMethodBeat.i(22683);
        aw.Rg().a((int) com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.b.CTRL_INDEX, (f) this);
        aw.Rg().a(638, (f) this);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(22676);
                ContactLabelUI.this.nIO.clear();
                ContactLabelUI.this.nIP.clear();
                Collection collection = null;
                if (ContactLabelUI.this.nID != null) {
                    ad aoO;
                    String str;
                    if (ContactLabelUI.this.nIS) {
                        String str2 = null;
                        aw.ZK();
                        bv RB = c.XN().RB(ContactLabelUI.this.edV);
                        if (RB != null) {
                            str2 = RB.field_contactLabels;
                        }
                        if (bo.isNullOrNil(str2)) {
                            aw.ZK();
                            aoO = c.XM().aoO(ContactLabelUI.this.edV);
                            String str3 = aoO.field_encryptUsername;
                            if (!bo.isNullOrNil(str3)) {
                                aw.ZK();
                                bv RB2 = c.XN().RB(str3);
                                if (RB2 != null) {
                                    str2 = RB2.field_contactLabels;
                                }
                            }
                            if (bo.isNullOrNil(str2)) {
                                str = aoO.field_username;
                                aw.ZK();
                                RB = c.XN().RB(str);
                                if (RB != null) {
                                    str2 = RB.field_contactLabels;
                                }
                            }
                        }
                        collection = (ArrayList) com.tencent.mm.plugin.label.a.a.bJa().PF(str2);
                    } else {
                        aw.ZK();
                        aoO = c.XM().aoO(ContactLabelUI.this.edV);
                        if (aoO != null) {
                            str = aoO.field_contactLabelIds;
                            if (!bo.isNullOrNil(str)) {
                                ArrayList arrayList = (ArrayList) com.tencent.mm.plugin.label.a.a.bJa().PG(str);
                            }
                        }
                    }
                    ContactLabelUI.this.nID.a(collection, (List) collection);
                    ContactLabelUI.a(ContactLabelUI.this, (ArrayList) collection);
                }
                if (ContactLabelUI.this.nII != null) {
                    ContactLabelUI.this.nIQ = e.bIZ().dsm();
                    if (ContactLabelUI.this.nIQ != null && ContactLabelUI.this.nIQ.size() > 0) {
                        ContactLabelUI.this.nIS;
                        ContactLabelUI.this.nII.a(collection, (List) ContactLabelUI.this.nIQ);
                        if (ContactLabelUI.this.nId) {
                            h.pYm.e(11346, Integer.valueOf(0), Integer.valueOf(1));
                            ContactLabelUI.this.nId = false;
                        }
                    } else if (ContactLabelUI.this.nId) {
                        h.pYm.e(11346, Integer.valueOf(0), Integer.valueOf(0));
                        ContactLabelUI.this.nId = false;
                    }
                }
                ContactLabelUI.a(ContactLabelUI.this, a.Normal);
                AppMethodBeat.o(22676);
            }
        });
        super.onResume();
        AppMethodBeat.o(22683);
    }

    public void onPause() {
        AppMethodBeat.i(22684);
        aw.Rg().b((int) com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.b.CTRL_INDEX, (f) this);
        aw.Rg().b(638, (f) this);
        super.onPause();
        AppMethodBeat.o(22684);
    }

    public void onDestroy() {
        AppMethodBeat.i(22685);
        super.onDestroy();
        AppMethodBeat.o(22685);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(22686);
        ab.i("MicroMsg.Label.ContactLabelUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        switch (mVar.getType()) {
            case com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.b.CTRL_INDEX /*635*/:
                if (i == 0 && i2 == 0) {
                    bJl();
                    AppMethodBeat.o(22686);
                    return;
                }
                bJf();
                AppMethodBeat.o(22686);
                return;
            case 638:
                if (i == 0 && i2 == 0) {
                    ab.i("MicroMsg.Label.ContactLabelUI", "cpan[onSceneEnd] success.");
                    bJm();
                    AppMethodBeat.o(22686);
                    return;
                }
                bJf();
                AppMethodBeat.o(22686);
                return;
            default:
                ab.w("MicroMsg.Label.ContactLabelUI", "unknow type.");
                AppMethodBeat.o(22686);
                return;
        }
    }

    public void onBackPressed() {
        AppMethodBeat.i(22687);
        if (bJn()) {
            com.tencent.mm.ui.base.h.d(this, getString(R.string.dwy), "", getString(R.string.abl), getString(R.string.abm), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(22659);
                    ContactLabelUI.a(ContactLabelUI.this);
                    AppMethodBeat.o(22659);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(22660);
                    ContactLabelUI.this.finish();
                    AppMethodBeat.o(22660);
                }
            });
            AppMethodBeat.o(22687);
            return;
        }
        super.onBackPressed();
        AppMethodBeat.o(22687);
    }

    private void a(a aVar) {
        AppMethodBeat.i(22688);
        this.nIR = aVar;
        switch (this.nIR) {
            case Normal:
                this.nIJ.setVisibility(8);
                if (this.nIQ == null || this.nIQ.size() <= 0) {
                    this.nIK.setVisibility(8);
                    this.nIF.setVisibility(8);
                } else {
                    this.nIF.setVisibility(0);
                    this.nIK.setVisibility(0);
                }
                this.nIE.setVisibility(8);
                AppMethodBeat.o(22688);
                return;
            case Search:
                this.nIK.setVisibility(8);
                this.nIJ.setVisibility(0);
                this.nIF.setVisibility(8);
                this.nIE.setVisibility(8);
                AppMethodBeat.o(22688);
                return;
            case OverMaxCount:
                this.nIJ.setVisibility(8);
                this.nIK.setVisibility(8);
                this.nIF.setVisibility(8);
                this.nIE.setVisibility(0);
                this.nIE.setText(R.string.cl8);
                AppMethodBeat.o(22688);
                return;
            case Invaildnput:
                this.nIJ.setVisibility(8);
                this.nIK.setVisibility(8);
                this.nIF.setVisibility(8);
                this.nIE.setVisibility(0);
                this.nIE.setText(R.string.cl8);
                break;
        }
        AppMethodBeat.o(22688);
    }

    private void aR(String str, boolean z) {
        AppMethodBeat.i(22689);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.Label.ContactLabelUI", "tag is empty");
            AppMethodBeat.o(22689);
            return;
        }
        String trim = str.trim();
        if (bo.isNullOrNil(trim)) {
            ab.w("MicroMsg.Label.ContactLabelUI", "new tag is empty");
            AppMethodBeat.o(22689);
            return;
        }
        af aoE = e.bIZ().aoE(trim);
        if (z) {
            if (this.nIQ == null || !this.nIQ.contains(trim) || aoE == null) {
                this.nIP.add(trim);
            }
        } else if (this.nIQ == null || !this.nIQ.contains(trim) || (aoE != null && aoE.field_isTemporary)) {
            this.nIP.add(trim);
        }
        if (this.nIO != null && this.nIO.contains(trim)) {
            this.nIO.remove(trim);
        }
        if (bJn()) {
            enableOptionMenu(true);
        }
        AppMethodBeat.o(22689);
    }

    private void bJl() {
        AppMethodBeat.i(22690);
        ab.i("MicroMsg.Label.ContactLabelUI", "cpan[saveContact]");
        if (this.nID != null) {
            int size;
            int size2;
            int size3;
            ab.i("MicroMsg.Label.ContactLabelUI", "cpan[saveContact] doScene");
            String str = "";
            ArrayList tagList = this.nID.getTagList();
            if (tagList != null && tagList.size() > 0) {
                str = com.tencent.mm.plugin.label.c.cf(e.bIZ().ai(tagList));
            }
            LinkedList linkedList = new LinkedList();
            cmh cmh = new cmh();
            cmh.wcD = str;
            cmh.jBB = this.edV;
            linkedList.add(cmh);
            aw.Rg().a(new d(linkedList), 0);
            if (this.nIP != null) {
                size = this.nIP.size();
            } else {
                size = 0;
            }
            if (this.nIN != null) {
                size2 = this.nIN.size();
            } else {
                size2 = 0;
            }
            if (this.nIO != null) {
                size3 = this.nIO.size();
            } else {
                size3 = 0;
            }
            size2 = ((size3 + this.nID.getTagList().size()) - size2) - size;
            if (size > 0 || size2 > 0) {
                ab.d("MicroMsg.Label.ContactLabelUI", "cpan[saveContact]addLabelNum:%d,updateLabelNum:%d", Integer.valueOf(size), Integer.valueOf(size2));
                h.pYm.e(11220, r.Yz(), Integer.valueOf(size), Integer.valueOf(size2), Integer.valueOf(0), Integer.valueOf(0));
            }
            if (size > 0) {
                h.pYm.e(16097, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1));
            }
        }
        AppMethodBeat.o(22690);
    }

    private void bJm() {
        AppMethodBeat.i(22691);
        bJc();
        this.nIP.clear();
        this.nIO.clear();
        finish();
        AppMethodBeat.o(22691);
    }

    private void bJf() {
        AppMethodBeat.i(22692);
        bJc();
        JN(getString(R.string.cn));
        AppMethodBeat.o(22692);
    }

    private boolean bJn() {
        AppMethodBeat.i(22693);
        if (this.nID != null) {
            if (this.nIN == null || this.nIN.size() <= 0) {
                if (this.nID.getTagList() != null && this.nID.getTagList().size() > 0) {
                    AppMethodBeat.o(22693);
                    return true;
                }
            } else if (this.nID.getTagList() != null || this.nID.getTagList().size() > 0) {
                ArrayList tagList = this.nID.getTagList();
                Collections.sort(this.nIN);
                Collections.sort(tagList);
                if (this.nIN.equals(tagList)) {
                    AppMethodBeat.o(22693);
                    return false;
                }
                AppMethodBeat.o(22693);
                return true;
            } else {
                AppMethodBeat.o(22693);
                return true;
            }
        }
        AppMethodBeat.o(22693);
        return false;
    }

    public void finish() {
        AppMethodBeat.i(22694);
        if (this.nID != null) {
            this.nID.dAd();
        }
        Intent intent = new Intent();
        if (bJn()) {
            intent.putExtra("hasLableChange", true);
        } else {
            intent.putExtra("hasLableChange", false);
        }
        setResult(-1, intent);
        super.finish();
        AppMethodBeat.o(22694);
    }
}

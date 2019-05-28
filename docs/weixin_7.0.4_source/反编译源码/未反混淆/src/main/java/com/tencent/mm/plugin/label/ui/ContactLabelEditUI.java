package com.tencent.mm.plugin.label.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.g;
import com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.b;
import com.tencent.mm.plugin.label.a;
import com.tencent.mm.plugin.label.e;
import com.tencent.mm.plugin.label.ui.widget.InputClearablePreference;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.protocal.protobuf.axj;
import com.tencent.mm.protocal.protobuf.cmh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.af;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.q;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class ContactLabelEditUI extends MMPreference implements f {
    private ProgressDialog gqo;
    private ak mHandler = new ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(22540);
            switch (message.what) {
                case 6001:
                    ContactLabelEditUI.a(ContactLabelEditUI.this);
                    AppMethodBeat.o(22540);
                    return;
                case 6002:
                    a.gkF.BS();
                    AppMethodBeat.o(22540);
                    return;
                default:
                    ab.w("MicroMsg.Label.ContactLabelEditUI", "unknow message. what is:%d", Integer.valueOf(message.what));
                    AppMethodBeat.o(22540);
                    return;
            }
        }
    };
    private boolean nBj = true;
    private String nHB;
    private String nHC;
    private String nHD;
    private af nHE;
    private boolean nHF;
    private boolean nHG = false;
    private String nHH;
    private com.tencent.mm.ui.base.preference.f nHI;
    private ContactListExpandPreference nHJ;
    private InputClearablePreference nHK;
    private Preference nHL;
    private PreferenceTitleCategory nHM;
    private boolean nHN = true;
    private ArrayList<String> nHO = new ArrayList();
    private ArrayList<String> nHP = new ArrayList();
    private HashSet<String> nHQ = new HashSet();
    private HashSet<String> nHR = new HashSet();
    private HashSet<String> nHS = new HashSet();
    private String nHT;
    private String nHU;
    private boolean nHV;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ContactLabelEditUI() {
        AppMethodBeat.i(22556);
        AppMethodBeat.o(22556);
    }

    static /* synthetic */ void c(ContactLabelEditUI contactLabelEditUI, String str) {
        AppMethodBeat.i(22582);
        contactLabelEditUI.PJ(str);
        AppMethodBeat.o(22582);
    }

    public final int JC() {
        return R.xml.az;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(22557);
        super.onCreate(bundle);
        this.nHT = r.Yz();
        this.nHD = getIntent().getStringExtra("label_id");
        this.nHB = getIntent().getStringExtra("label_name");
        this.nHC = getIntent().getStringExtra("label_name");
        this.nHF = getIntent().getBooleanExtra("Is_Chatroom", false);
        this.nHU = getIntent().getStringExtra("label_source");
        boolean z = this.nHU != null && this.nHU.equals("label_source_Address");
        this.nHV = z;
        this.nHG = getIntent().getBooleanExtra("is_show_delete", true);
        String stringExtra = getIntent().getStringExtra("Select_Contact");
        if (!bo.isNullOrNil(stringExtra)) {
            ArrayList P = bo.P(stringExtra.split(","));
            this.nHO = new ArrayList();
            if (P != null && P.size() > 0) {
                int size = P.size();
                for (int i = 0; i < size; i++) {
                    stringExtra = (String) P.get(i);
                    if (!bo.isNullOrNil(stringExtra)) {
                        if (!t.mY(stringExtra) || this.nHO.contains(stringExtra) || stringExtra.equals(this.nHT)) {
                            ab.i("MicroMsg.Label.ContactLabelEditUI", "dz[getIntent] %s is no friend or is user self and just filter", stringExtra);
                        } else {
                            this.nHO.add(stringExtra);
                            this.nHQ.add(stringExtra);
                            if (this.nHF) {
                                this.nHR.add(stringExtra);
                            }
                        }
                    }
                }
            }
        }
        aw.Rg().a((int) b.CTRL_INDEX, (f) this);
        aw.Rg().a(637, (f) this);
        aw.Rg().a(638, (f) this);
        initView();
        AppMethodBeat.o(22557);
    }

    public void onResume() {
        AppMethodBeat.i(22558);
        d.b(3, "ContactLabelEditUI" + bJj(), hashCode());
        aw.Rg().a(636, (f) this);
        PJ(this.nHC);
        bJd();
        super.onResume();
        AppMethodBeat.o(22558);
    }

    public void onPause() {
        AppMethodBeat.i(22559);
        d.b(4, "ContactLabelEditUI" + bJj(), hashCode());
        aw.Rg().b(636, (f) this);
        super.onPause();
        AppMethodBeat.o(22559);
    }

    public void onDestroy() {
        AppMethodBeat.i(22560);
        aw.Rg().b((int) b.CTRL_INDEX, (f) this);
        aw.Rg().b(637, (f) this);
        aw.Rg().b(638, (f) this);
        super.onDestroy();
        AppMethodBeat.o(22560);
    }

    public final void initView() {
        AppMethodBeat.i(22561);
        if (this.nHV) {
            h.pYm.e(16097, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2));
        } else {
            h.pYm.e(16097, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(3));
        }
        if (bo.isNullOrNil(this.nHD)) {
            this.nHN = true;
            this.nHH = getString(R.string.dec);
        } else {
            this.nHN = false;
            this.nHE = e.bIZ().aoF(this.nHD);
            this.nHH = getString(R.string.deb);
        }
        setMMTitle(this.nHH);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(22544);
                ContactLabelEditUI.this.onBackPressed();
                AppMethodBeat.o(22544);
                return true;
            }
        });
        a(0, getString(R.string.tc), (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(22545);
                ContactLabelEditUI.b(ContactLabelEditUI.this);
                AppMethodBeat.o(22545);
                return true;
            }
        }, q.b.GREEN);
        this.nHI = this.yCw;
        this.nHJ = (ContactListExpandPreference) this.nHI.aqO("contact_label_contact_list");
        this.nHJ.a(this.nHI, this.nHJ.mKey);
        this.nHJ.oD(true);
        this.nHJ.oE(true);
        this.nHJ.djF();
        this.nHJ.djz();
        this.nHJ.a(new k.b() {
            public final boolean iD(int i) {
                return false;
            }
        });
        this.nHJ.a(new ContactListExpandPreference.a() {
            public final void iB(int i) {
                AppMethodBeat.i(22546);
                if (ContactLabelEditUI.this.nHJ.KW(i)) {
                    String KX = ContactLabelEditUI.this.nHJ.KX(i);
                    String KY = ContactLabelEditUI.this.nHJ.KY(i);
                    if (bo.isNullOrNil(KX)) {
                        AppMethodBeat.o(22546);
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("Contact_User", KX);
                    intent.putExtra("Contact_RoomNickname", KY);
                    a.gkE.c(intent, ContactLabelEditUI.this);
                }
                AppMethodBeat.o(22546);
            }

            public final void JT() {
                AppMethodBeat.i(22547);
                if (ContactLabelEditUI.this.nHJ != null) {
                    ContactLabelEditUI.this.nHJ.djD();
                }
                AppMethodBeat.o(22547);
            }

            public final void iC(int i) {
                AppMethodBeat.i(22548);
                ContactLabelEditUI.d(ContactLabelEditUI.this);
                AppMethodBeat.o(22548);
            }

            public final void iA(int i) {
                AppMethodBeat.i(22549);
                ab.d("MicroMsg.Label.ContactLabelEditUI", "cpan[onItemDelClick] position:%d userName:%s", Integer.valueOf(i), ContactLabelEditUI.this.nHJ.KX(i));
                ContactLabelEditUI.a(ContactLabelEditUI.this, r0);
                AppMethodBeat.o(22549);
            }
        });
        this.nHK = (InputClearablePreference) this.nHI.aqO("contact_label_name");
        InputClearablePreference inputClearablePreference = this.nHK;
        inputClearablePreference.nJe = getString(R.string.ckz);
        if (inputClearablePreference.nJj != null) {
            inputClearablePreference.nJj.setHint(inputClearablePreference.nJe);
        }
        this.nHK.hAa = getString(R.string.cl8);
        inputClearablePreference = this.nHK;
        inputClearablePreference.nJf = getString(R.string.co);
        if (inputClearablePreference.nJl != null) {
            inputClearablePreference.nJl.setText(inputClearablePreference.nJf);
        }
        this.nHK.nJg = 36;
        this.nHK.nJi = this.nHN;
        this.nHK.nJn = new InputClearablePreference.a() {
            public final void PL(String str) {
                AppMethodBeat.i(22550);
                ContactLabelEditUI.this.nHC = str;
                ContactLabelEditUI.c(ContactLabelEditUI.this, str);
                ContactLabelEditUI.this.nHK.iA(false);
                AppMethodBeat.o(22550);
            }

            public final void iy(boolean z) {
                AppMethodBeat.i(22551);
                if (ContactLabelEditUI.this.nHN || !ContactLabelEditUI.this.nBj) {
                    ContactLabelEditUI.this.enableOptionMenu(z);
                    AppMethodBeat.o(22551);
                    return;
                }
                ContactLabelEditUI.this.enableOptionMenu(false);
                ContactLabelEditUI.this.nBj = false;
                AppMethodBeat.o(22551);
            }
        };
        this.nHK.setText(this.nHC);
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(6001);
        }
        if (!this.nHN) {
            aw.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(22552);
                    ArrayList aoD = e.bIZ().aoD(ContactLabelEditUI.this.nHD);
                    if (aoD == null) {
                        ab.w("MicroMsg.Label.ContactLabelEditUI", "result is null");
                        AppMethodBeat.o(22552);
                        return;
                    }
                    if (aoD != null) {
                        ContactLabelEditUI.this.nHO = aoD;
                        if (ContactLabelEditUI.this.nHP == null) {
                            ContactLabelEditUI.this.nHP = new ArrayList();
                        } else {
                            ContactLabelEditUI.this.nHP.clear();
                        }
                        ContactLabelEditUI.this.nHP.addAll(aoD);
                    }
                    if (ContactLabelEditUI.this.mHandler != null) {
                        ContactLabelEditUI.this.mHandler.sendEmptyMessage(6001);
                    }
                    AppMethodBeat.o(22552);
                }

                public final String toString() {
                    AppMethodBeat.i(22553);
                    String str = super.toString() + "|initView";
                    AppMethodBeat.o(22553);
                    return str;
                }
            });
        } else if (this.nHO == null || this.nHO.size() <= 0) {
            this.nHJ.ag(new ArrayList());
        } else {
            this.nHJ.u(null, this.nHO);
        }
        if (this.nDp != null) {
            this.nDp.setOnScrollListener(new OnScrollListener() {
                public final void onScrollStateChanged(AbsListView absListView, int i) {
                    AppMethodBeat.i(22554);
                    if (i == 2 || i == 1) {
                        ContactLabelEditUI.this.aqX();
                    }
                    AppMethodBeat.o(22554);
                }

                public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                }
            });
        }
        this.nHL = this.nHI.aqO("contact_label_delete");
        this.nHM = (PreferenceTitleCategory) this.nHI.aqO("contact_label_empty_category");
        if (this.nHN) {
            this.nHI.d(this.nHL);
            this.nHI.d(this.nHM);
            AppMethodBeat.o(22561);
            return;
        }
        if (!this.nHG) {
            this.nHI.d(this.nHL);
        }
        AppMethodBeat.o(22561);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(22562);
        super.onActivityResult(i, i2, intent);
        ab.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onActivityResult] requestCode:%d resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i2 != -1) {
            AppMethodBeat.o(22562);
            return;
        }
        switch (i) {
            case 7001:
                String stringExtra = intent.getStringExtra("Select_Contact");
                boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
                ab.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onActivityResult] %s", String.valueOf(stringExtra));
                if (!bo.isNullOrNil(stringExtra)) {
                    ArrayList P = bo.P(stringExtra.split(","));
                    if (P != null && P.size() > 0) {
                        int size = P.size();
                        int i3 = 0;
                        while (i3 < size) {
                            stringExtra = (String) P.get(i3);
                            if (!bo.isNullOrNil(stringExtra)) {
                                if (!t.mY(stringExtra) || this.nHO.contains(stringExtra) || stringExtra.equals(this.nHT)) {
                                    ab.i("MicroMsg.Label.ContactLabelEditUI", "dz[getIntent] %s is no friend or is user self and just filter", stringExtra);
                                } else {
                                    this.nHO.add(stringExtra);
                                    if (!(this.nHP == null || this.nHP.contains(P.get(i3)))) {
                                        this.nHQ.add(stringExtra);
                                    }
                                    if (booleanExtra) {
                                        this.nHR.add(stringExtra);
                                    }
                                    if (this.nHS != null && this.nHS.contains(stringExtra)) {
                                        this.nHS.remove(stringExtra);
                                    }
                                }
                            }
                            i3++;
                        }
                    }
                    if (this.mHandler != null) {
                        this.mHandler.sendEmptyMessage(6001);
                        break;
                    }
                }
                break;
        }
        AppMethodBeat.o(22562);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(22564);
        ab.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        switch (mVar.getType()) {
            case b.CTRL_INDEX /*635*/:
                if (i == 0 && i2 == 0) {
                    LinkedList linkedList = ((com.tencent.mm.plugin.label.b.a) mVar).bJb().vEm;
                    if (linkedList == null || linkedList.size() <= 0) {
                        bJf();
                        AppMethodBeat.o(22564);
                        return;
                    }
                    ab.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onSceneEnd] add label pair.LabelID:%s pair.LabelName:%s", r0.wBr, ((axj) linkedList.get(0)).wBq);
                    this.nHD = r0.wBr;
                    bJg();
                    AppMethodBeat.o(22564);
                    return;
                }
                bJf();
                AppMethodBeat.o(22564);
                return;
            case 636:
                if (i != 0 || i2 != 0) {
                    ab.w("MicroMsg.Label.ContactLabelEditUI", "cpan[onSceneEnd] delete fail.");
                    bJh();
                    break;
                }
                a(this.nHE);
                if (this.mHandler != null) {
                    this.mHandler.sendEmptyMessageDelayed(6002, 300);
                    AppMethodBeat.o(22564);
                    return;
                }
                break;
            case 637:
                if (i == 0 && i2 == 0) {
                    int intValue;
                    String str2 = this.nHD;
                    String str3 = this.nHC;
                    ab.i("MicroMsg.Label.ContactLabelEditUI", "cpan[doInsertOrUpdateLable]");
                    try {
                        intValue = Integer.valueOf(str2).intValue();
                    } catch (Exception e) {
                        ab.e("MicroMsg.Label.ContactLabelEditUI", "id is not integer type:%s", String.valueOf(str2));
                        intValue = -1;
                    }
                    if (intValue != -1) {
                        af aoF = e.bIZ().aoF(str2);
                        if (aoF == null) {
                            aoF = new af();
                        }
                        aoF.field_labelID = intValue;
                        aoF.field_labelName = str3;
                        aoF.field_labelPYFull = g.vo(str3);
                        aoF.field_labelPYShort = g.vp(str3);
                        e.bIZ().b(true, aoF, "labelID");
                    } else {
                        bJf();
                    }
                    bJg();
                    AppMethodBeat.o(22564);
                    return;
                }
                bJf();
                AppMethodBeat.o(22564);
                return;
            case 638:
                if (i == 0 && i2 == 0) {
                    bJe();
                    if (this.mHandler != null) {
                        this.mHandler.sendEmptyMessageDelayed(6002, 300);
                        AppMethodBeat.o(22564);
                        return;
                    }
                }
                bJf();
                AppMethodBeat.o(22564);
                return;
                break;
        }
        AppMethodBeat.o(22564);
    }

    private void bJd() {
        AppMethodBeat.i(22565);
        if (this.nHJ != null) {
            this.nHJ.u(null, this.nHO);
            if (this.nHO == null || this.nHO.size() <= 0) {
                this.nHJ.djD();
            }
        }
        if (this.nHK != null) {
            this.nHK.setText(this.nHC);
        }
        AppMethodBeat.o(22565);
    }

    private void PJ(String str) {
        AppMethodBeat.i(22566);
        enableOptionMenu(!bo.isNullOrNil(str));
        AppMethodBeat.o(22566);
    }

    private void bJe() {
        int size;
        int size2;
        AppMethodBeat.i(22567);
        ab.i("MicroMsg.Label.ContactLabelEditUI", "cpan[savaSuccess]");
        bJc();
        if (this.nHQ != null) {
            size = this.nHQ.size();
        } else {
            size = 0;
        }
        if (this.nHS != null) {
            size2 = this.nHS.size();
        } else {
            size2 = 0;
        }
        ab.i("MicroMsg.Label.ContactLabelEditUI", "cpan[doUpdateContactList]addnum:%d", Integer.valueOf(size));
        if (size > 0) {
            int size3 = this.nHR.size();
            int max = Math.max(0, size - size3);
            h hVar = h.pYm;
            Object[] objArr = new Object[7];
            objArr[0] = r.Yz();
            objArr[1] = Integer.valueOf(0);
            objArr[2] = Integer.valueOf(0);
            objArr[3] = Integer.valueOf(size);
            objArr[4] = Integer.valueOf(this.nHF ? 1 : 2);
            objArr[5] = Integer.valueOf(size3);
            objArr[6] = Integer.valueOf(max);
            hVar.e(11220, objArr);
        }
        if (this.nHN) {
            Intent intent = getIntent();
            intent.putExtra("k_sns_label_add_label", this.nHC);
            setResult(0, intent);
            if (this.nHV) {
                h.pYm.e(16097, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2));
            } else {
                h.pYm.e(16097, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(3));
            }
        } else {
            if (size > 0) {
                if (this.nHV) {
                    h.pYm.e(16097, Integer.valueOf(0), Integer.valueOf(3), Integer.valueOf(2));
                } else {
                    h.pYm.e(16097, Integer.valueOf(0), Integer.valueOf(3), Integer.valueOf(3));
                }
            }
            if (size2 > 0) {
                if (this.nHV) {
                    h.pYm.e(16097, Integer.valueOf(0), Integer.valueOf(4), Integer.valueOf(2));
                } else {
                    h.pYm.e(16097, Integer.valueOf(0), Integer.valueOf(4), Integer.valueOf(3));
                }
            }
            setResult(0);
        }
        finish();
        AppMethodBeat.o(22567);
    }

    private void bJf() {
        AppMethodBeat.i(22568);
        ab.i("MicroMsg.Label.ContactLabelEditUI", "cpan[saveFailed]");
        bJc();
        JN(getString(R.string.cn));
        AppMethodBeat.o(22568);
    }

    private static boolean PK(String str) {
        AppMethodBeat.i(22569);
        if (bo.isNullOrNil(e.bIZ().PE(str))) {
            AppMethodBeat.o(22569);
            return false;
        }
        AppMethodBeat.o(22569);
        return true;
    }

    private void bJg() {
        int i;
        Iterator it;
        String str;
        String str2;
        String eR;
        cmh cmh;
        AppMethodBeat.i(22570);
        String str3 = "MicroMsg.Label.ContactLabelEditUI";
        String str4 = "cpan[doUpdateContactList] addcount:%d,delcount:%d";
        Object[] objArr = new Object[2];
        if (this.nHQ == null) {
            i = 0;
        } else {
            i = this.nHQ.size();
        }
        objArr[0] = Integer.valueOf(i);
        if (this.nHS == null) {
            i = 0;
        } else {
            i = this.nHS.size();
        }
        objArr[1] = Integer.valueOf(i);
        ab.i(str3, str4, objArr);
        LinkedList linkedList = new LinkedList();
        if (this.nHQ != null && this.nHQ.size() > 0) {
            this.nHQ.size();
            it = this.nHQ.iterator();
            while (it.hasNext()) {
                str = (String) it.next();
                aw.ZK();
                ad aoO = c.XM().aoO(str);
                str2 = aoO.field_contactLabelIds;
                eR = com.tencent.mm.plugin.label.c.eR(str2, this.nHD);
                ab.i("MicroMsg.Label.ContactLabelEditUI", "labels:%s mixLabelIds:%s", str2, eR);
                if (!eR.equalsIgnoreCase(str2)) {
                    cmh = new cmh();
                    cmh.jBB = aoO.field_username;
                    cmh.wcD = eR;
                    linkedList.add(cmh);
                }
            }
        }
        if (this.nHS != null && this.nHS.size() > 0) {
            this.nHS.size();
            it = this.nHS.iterator();
            while (it.hasNext()) {
                str = (String) it.next();
                aw.ZK();
                str2 = c.XM().aoO(str).field_contactLabelIds;
                eR = com.tencent.mm.plugin.label.c.eS(str2, this.nHD);
                ab.i("MicroMsg.Label.ContactLabelEditUI", "username:%s labels:%s mixLabelIds:%s", str, str2, eR);
                if (!eR.equalsIgnoreCase(str2)) {
                    cmh = new cmh();
                    cmh.jBB = str;
                    cmh.wcD = eR;
                    linkedList.add(cmh);
                }
            }
        }
        if (linkedList.size() > 0) {
            aw.Rg().a(new com.tencent.mm.plugin.label.b.d(linkedList), 0);
            AppMethodBeat.o(22570);
            return;
        }
        bJe();
        AppMethodBeat.o(22570);
    }

    private void PI(String str) {
        AppMethodBeat.i(22571);
        getString(R.string.tz);
        this.gqo = com.tencent.mm.ui.base.h.b((Context) this, str, true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(22541);
                aw.Rg().cancel(b.CTRL_INDEX);
                aw.Rg().cancel(637);
                AppMethodBeat.o(22541);
            }
        });
        AppMethodBeat.o(22571);
    }

    private void bJc() {
        AppMethodBeat.i(22572);
        if (this.gqo != null && this.gqo.isShowing()) {
            this.gqo.dismiss();
        }
        AppMethodBeat.o(22572);
    }

    private void JN(String str) {
        AppMethodBeat.i(22573);
        com.tencent.mm.ui.base.h.a((Context) this, str, "", new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AppMethodBeat.o(22573);
    }

    public void onBackPressed() {
        AppMethodBeat.i(22574);
        if ((bo.isNullOrNil(this.nHC) || this.nHC.equals(this.nHB)) && ((this.nHQ == null || this.nHQ.size() <= 0) && (this.nHS == null || this.nHS.size() <= 0))) {
            setResult(0);
            finish();
            AppMethodBeat.o(22574);
            return;
        }
        com.tencent.mm.ui.base.h.d(this, getString(R.string.dwy), "", getString(R.string.abl), getString(R.string.abm), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(22542);
                ContactLabelEditUI.b(ContactLabelEditUI.this);
                AppMethodBeat.o(22542);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(22543);
                ContactLabelEditUI.this.setResult(0);
                ContactLabelEditUI.this.finish();
                AppMethodBeat.o(22543);
            }
        });
        AppMethodBeat.o(22574);
    }

    private void a(af afVar) {
        AppMethodBeat.i(22575);
        if (e.bIZ().a(afVar, "labelID")) {
            bJi();
            AppMethodBeat.o(22575);
            return;
        }
        ab.w("MicroMsg.Label.ContactLabelEditUI", "cpan[doDeleteContactLabel] fail.");
        bJh();
        AppMethodBeat.o(22575);
    }

    private void bJh() {
        AppMethodBeat.i(22576);
        JN(getString(R.string.b4x));
        AppMethodBeat.o(22576);
    }

    private void bJi() {
        AppMethodBeat.i(22577);
        setResult(-1);
        finish();
        AppMethodBeat.o(22577);
    }

    public final String bJj() {
        if (this.nHN) {
            return "_New";
        }
        return "_Edit";
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, Preference preference) {
        AppMethodBeat.i(22563);
        String str = preference.mKey;
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.Label.ContactLabelEditUI", "cpan [onPreferenceTreeClick] key is null.");
            AppMethodBeat.o(22563);
        } else {
            if (str.equals("contact_label_delete")) {
                com.tencent.mm.ui.base.h.d(this, getString(R.string.ckx), "", getString(R.string.p4), getString(R.string.or), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(22555);
                        ContactLabelEditUI.l(ContactLabelEditUI.this);
                        AppMethodBeat.o(22555);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
            ab.d("MicroMsg.Label.ContactLabelEditUI", "cpan [onPreferenceTreeClick] key is %s:", str);
            AppMethodBeat.o(22563);
        }
        return false;
    }

    static /* synthetic */ void b(ContactLabelEditUI contactLabelEditUI) {
        AppMethodBeat.i(22579);
        ab.i("MicroMsg.Label.ContactLabelEditUI", "cpan[saveLabelChange]");
        contactLabelEditUI.PI(contactLabelEditUI.getString(R.string.cl_));
        contactLabelEditUI.nHC = bo.bc(contactLabelEditUI.nHC, "");
        contactLabelEditUI.nHC = contactLabelEditUI.nHC.trim();
        if (bo.isNullOrNil(contactLabelEditUI.nHC)) {
            contactLabelEditUI.bJc();
            contactLabelEditUI.JN(contactLabelEditUI.getString(R.string.cl2));
            AppMethodBeat.o(22579);
        } else if (com.tencent.mm.ui.tools.f.asg(contactLabelEditUI.nHC) > 36) {
            contactLabelEditUI.bJc();
            contactLabelEditUI.JN(String.format(contactLabelEditUI.getString(R.string.cp), new Object[]{Integer.valueOf(com.tencent.mm.ui.tools.f.bP(36, ""))}));
            AppMethodBeat.o(22579);
        } else if (!(PK(contactLabelEditUI.nHC) && contactLabelEditUI.nHN) && (!PK(contactLabelEditUI.nHC) || bo.isNullOrNil(contactLabelEditUI.nHB) || contactLabelEditUI.nHB.equals(contactLabelEditUI.nHC))) {
            af aoF = e.bIZ().aoF(contactLabelEditUI.nHD);
            if (contactLabelEditUI.nHN || aoF.field_isTemporary) {
                aw.Rg().a(new com.tencent.mm.plugin.label.b.a(contactLabelEditUI.nHC), 0);
                AppMethodBeat.o(22579);
                return;
            }
            aw.Rg().a(new com.tencent.mm.plugin.label.b.e(Integer.valueOf(contactLabelEditUI.nHD).intValue(), contactLabelEditUI.nHC), 0);
            AppMethodBeat.o(22579);
        } else {
            contactLabelEditUI.bJc();
            contactLabelEditUI.JN(contactLabelEditUI.getString(R.string.cm));
            AppMethodBeat.o(22579);
        }
    }

    static /* synthetic */ void d(ContactLabelEditUI contactLabelEditUI) {
        AppMethodBeat.i(22580);
        ab.i("MicroMsg.Label.ContactLabelEditUI", "cpan[dealAddContact]");
        Intent intent = new Intent();
        intent.putExtra("list_attr", s.C(s.znE, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT));
        intent.putExtra("list_type", 1);
        intent.putExtra("titile", contactLabelEditUI.getString(R.string.cku));
        intent.putExtra("show_too_many_member", false);
        intent.putExtra("scene", 6);
        if (contactLabelEditUI.nHO != null) {
            intent.putExtra("always_select_contact", bo.c(contactLabelEditUI.nHO, ","));
        }
        com.tencent.mm.bp.d.b((Context) contactLabelEditUI, ".ui.contact.SelectContactUI", intent, 7001);
        AppMethodBeat.o(22580);
    }

    static /* synthetic */ void l(ContactLabelEditUI contactLabelEditUI) {
        AppMethodBeat.i(22583);
        if (contactLabelEditUI.nHE.field_isTemporary) {
            contactLabelEditUI.a(contactLabelEditUI.nHE);
        } else {
            af afVar = contactLabelEditUI.nHE;
            if (afVar == null) {
                ab.w("MicroMsg.Label.ContactLabelEditUI", "cpan[doDeleteScene] can not do scene. lable is null");
            } else {
                contactLabelEditUI.PI(contactLabelEditUI.getString(R.string.cky));
                aw.Rg().a(new com.tencent.mm.plugin.label.b.b(afVar.field_labelID), 0);
            }
        }
        if (contactLabelEditUI.nHV) {
            h.pYm.e(16097, Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(2));
            AppMethodBeat.o(22583);
            return;
        }
        h.pYm.e(16097, Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(3));
        AppMethodBeat.o(22583);
    }
}

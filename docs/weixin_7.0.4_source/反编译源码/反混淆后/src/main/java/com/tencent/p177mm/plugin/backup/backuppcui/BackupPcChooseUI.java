package com.tencent.p177mm.plugin.backup.backuppcui;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.backup.backuppcmodel.C42759b;
import com.tencent.p177mm.plugin.backup.backuppcmodel.C42760e;
import com.tencent.p177mm.plugin.backup.backupui.BackupSelectExtUI;
import com.tencent.p177mm.plugin.backup.p342b.C38634d;
import com.tencent.p177mm.plugin.backup.p342b.C38635g;
import com.tencent.p177mm.plugin.backup.p342b.C45733f.C27443b;
import com.tencent.p177mm.plugin.backup.p344c.C33685b.C33684a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.backup.backuppcui.BackupPcChooseUI */
public class BackupPcChooseUI extends MMWizardActivity {
    private static int aPA = 0;
    private static long endTime;
    private static int juK = 0;
    private static long startTime;
    private ProgressBar juA;
    private View juB;
    private LinearLayout juC;
    private LinearLayout juD;
    private LinearLayout juE;
    private LinearLayout juF;
    private TextView juG;
    private TextView juH;
    private TextView juI;
    private Button juJ;
    private SimpleDateFormat juL = new SimpleDateFormat("yyyy.MM.dd");
    private TextView jux;
    private TextView juy;
    private TextView juz;
    private C19958a jwH = new C19958a(this);
    private ListView jwI;
    private C33684a jwJ = new C427625();

    /* renamed from: com.tencent.mm.plugin.backup.backuppcui.BackupPcChooseUI$2 */
    class C26142 implements OnClickListener {
        C26142() {
        }

        public final void onClick(View view) {
            LinkedList linkedList;
            AppMethodBeat.m2504i(17575);
            C19958a a = BackupPcChooseUI.this.jwH;
            LinkedList linkedList2 = new LinkedList();
            if (a.jur.size() <= 0) {
                linkedList = linkedList2;
            } else {
                LinkedList aSV = C42759b.aTD().aTH().aSV();
                if (aSV != null) {
                    for (int i = 0; i < a.getCount(); i++) {
                        if (a.jur.contains(Integer.valueOf(i))) {
                            linkedList2.add(aSV.get(i));
                        }
                    }
                }
                C4990ab.m7417i("MicroMsg.BackupPcChooseAdapter", "finishSelected usernameSize:%d", Integer.valueOf(linkedList2.size()));
                linkedList = linkedList2;
            }
            final LinkedList A = C38635g.m65500A(linkedList);
            C9638aw.m17190ZK();
            C4990ab.m7417i("MicroMsg.BackupPcChooseUI", "initView OnMenuItemClickListener startbackup choose records finish, selectedConversation size[%d], hasMove[%b], timeMode[%d], startTime[%d], endTime[%d], contentType[%d]", Integer.valueOf(linkedList.size()), Boolean.valueOf(((Boolean) C18628c.m29072Ry().get(C5127a.USERINFO_BACKUP_OLD_RECORDS_BOOLEAN, Boolean.FALSE)).booleanValue()), Integer.valueOf(BackupPcChooseUI.juK), Long.valueOf(BackupPcChooseUI.startTime), Long.valueOf(BackupPcChooseUI.endTime), Integer.valueOf(BackupPcChooseUI.aPA));
            if (((Boolean) C18628c.m29072Ry().get(C5127a.USERINFO_BACKUP_OLD_RECORDS_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                C30379h.m48430a(BackupPcChooseUI.this, (int) C25738R.string.a0k, 0, (int) C25738R.string.a1u, 0, false, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(17574);
                        C42759b.aTD().aTH().mo35198F(linkedList);
                        C42759b.aTD().aTE().mo73535rs(2);
                        C42759b.aTD().aSu().jqW = 12;
                        C42759b.aTD().aTF().mo68230G(A);
                        C42759b.aTD().aTF().mo68233gx((long) linkedList.size());
                        C7060h.pYm.mo8378a(400, 8, 1, false);
                        C7060h.pYm.mo8381e(13735, Integer.valueOf(10), Integer.valueOf(C42759b.aTD().aTE().jwg));
                        if (BackupPcChooseUI.juK == 1 && BackupPcChooseUI.aPA == 1) {
                            C7060h.pYm.mo8378a(400, 32, 1, false);
                            C7060h.pYm.mo8378a(400, 35, 1, false);
                            C7060h.pYm.mo8381e(13735, Integer.valueOf(13), Integer.valueOf(C42759b.aTD().aTE().jwg));
                        } else if (BackupPcChooseUI.juK == 1) {
                            C7060h.pYm.mo8378a(400, 32, 1, false);
                            C7060h.pYm.mo8381e(13735, Integer.valueOf(11), Integer.valueOf(C42759b.aTD().aTE().jwg));
                        } else if (BackupPcChooseUI.aPA == 1) {
                            C7060h.pYm.mo8378a(400, 35, 1, false);
                            C7060h.pYm.mo8381e(13735, Integer.valueOf(12), Integer.valueOf(C42759b.aTD().aTE().jwg));
                        }
                        BackupPcChooseUI.this.finish();
                        AppMethodBeat.m2505o(17574);
                    }
                }, null, (int) C25738R.color.f11768gn);
                AppMethodBeat.m2505o(17575);
                return;
            }
            C42759b.aTD().aTH().mo35198F(linkedList);
            C42759b.aTD().aTE().mo73535rs(2);
            C42759b.aTD().aSu().jqW = 12;
            C42759b.aTD().aTF().mo68230G(A);
            C42759b.aTD().aTF().mo68233gx((long) linkedList.size());
            C7060h.pYm.mo8378a(400, 8, 1, false);
            C7060h.pYm.mo8381e(13735, Integer.valueOf(10), Integer.valueOf(C42759b.aTD().aTE().jwg));
            if (BackupPcChooseUI.juK == 1 && BackupPcChooseUI.aPA == 1) {
                C7060h.pYm.mo8378a(400, 32, 1, false);
                C7060h.pYm.mo8378a(400, 35, 1, false);
                C7060h.pYm.mo8381e(13735, Integer.valueOf(13), Integer.valueOf(C42759b.aTD().aTE().jwg));
            } else if (BackupPcChooseUI.juK == 1) {
                C7060h.pYm.mo8378a(400, 32, 1, false);
                C7060h.pYm.mo8381e(13735, Integer.valueOf(11), Integer.valueOf(C42759b.aTD().aTE().jwg));
            } else if (BackupPcChooseUI.aPA == 1) {
                C7060h.pYm.mo8378a(400, 35, 1, false);
                C7060h.pYm.mo8381e(13735, Integer.valueOf(12), Integer.valueOf(C42759b.aTD().aTE().jwg));
            }
            BackupPcChooseUI.this.finish();
            AppMethodBeat.m2505o(17575);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.backuppcui.BackupPcChooseUI$1 */
    class C111021 implements OnMenuItemClickListener {
        C111021() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(17573);
            BackupPcChooseUI.this.finish();
            AppMethodBeat.m2505o(17573);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.backuppcui.BackupPcChooseUI$3 */
    class C336703 implements OnClickListener {
        C336703() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(17576);
            Intent intent = new Intent(BackupPcChooseUI.this, BackupSelectExtUI.class);
            intent.putExtra("BACKUP_MODE", 1);
            intent.putExtra("BACKUP_SELECT_TIME_MODE", BackupPcChooseUI.juK);
            intent.putExtra("BACKUP_SELECT_SUPPORT_CONTENT_TYPE", C42759b.aTD().aTF().jww);
            intent.putExtra("BACKUP_SELECT_CONTENT_TYPE", BackupPcChooseUI.aPA);
            intent.putExtra("BACKUP_SELECT_TIME_START_TIME", BackupPcChooseUI.startTime);
            intent.putExtra("BACKUP_SELECT_TIME_END_TIME", BackupPcChooseUI.endTime);
            intent.putExtra("BACKUP_SELECT_TIME_MIN_CONVERSATION_TIME", C42759b.aTD().aTH().jsU);
            BackupPcChooseUI.this.startActivityForResult(intent, 0);
            AppMethodBeat.m2505o(17576);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.backuppcui.BackupPcChooseUI$4 */
    class C336714 implements OnClickListener {
        C336714() {
        }

        public final void onClick(View view) {
            int i = 0;
            AppMethodBeat.m2504i(17577);
            if (C42759b.aTD().aTH().jsY) {
                C19958a a = BackupPcChooseUI.this.jwH;
                if (a.jur.size() == a.getCount()) {
                    a.jur.clear();
                    C19958a.jwF = false;
                } else {
                    while (i < a.getCount()) {
                        a.jur.add(Integer.valueOf(i));
                        i++;
                    }
                    C19958a.jwF = true;
                }
                a.notifyDataSetChanged();
                a.jwE.mo68237a(a.jur);
            }
            AppMethodBeat.m2505o(17577);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.backuppcui.BackupPcChooseUI$5 */
    class C427625 implements C33684a {
        C427625() {
        }

        /* renamed from: B */
        public final void mo6658B(LinkedList<C27443b> linkedList) {
            AppMethodBeat.m2504i(17578);
            if (linkedList == null) {
                AppMethodBeat.m2505o(17578);
            } else if (linkedList.size() == 0) {
                BackupPcChooseUI.this.juA.setVisibility(8);
                BackupPcChooseUI.this.juy.setVisibility(0);
                switch (BackupPcChooseUI.juK) {
                    case 0:
                        BackupPcChooseUI.this.juy.setText(C25738R.string.f9428zo);
                        AppMethodBeat.m2505o(17578);
                        return;
                    case 1:
                        BackupPcChooseUI.this.juy.setText(C25738R.string.a1h);
                        break;
                }
                AppMethodBeat.m2505o(17578);
            } else {
                BackupPcChooseUI.this.jux.setClickable(true);
                BackupPcChooseUI.this.jux.setTextColor(BackupPcChooseUI.this.getResources().getColor(C25738R.color.f11768gn));
                BackupPcChooseUI.this.juA.setVisibility(8);
                BackupPcChooseUI.this.jwH.notifyDataSetChanged();
                AppMethodBeat.m2505o(17578);
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public BackupPcChooseUI() {
        AppMethodBeat.m2504i(17579);
        AppMethodBeat.m2505o(17579);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(17580);
        super.onCreate(bundle);
        if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            AppMethodBeat.m2505o(17580);
            return;
        }
        initView();
        AppMethodBeat.m2505o(17580);
    }

    public final int getLayoutId() {
        return 2130968795;
    }

    public void onStart() {
        AppMethodBeat.m2504i(17581);
        super.onStart();
        C42759b.aTD().aTH().jvS = this.jwJ;
        AppMethodBeat.m2505o(17581);
    }

    public void onStop() {
        AppMethodBeat.m2504i(17582);
        super.onStop();
        C42759b.aTD().aTH().jvS = null;
        AppMethodBeat.m2505o(17582);
    }

    public final void initView() {
        AppMethodBeat.m2504i(17583);
        setMMTitle((int) C25738R.string.a16);
        this.jwI = (ListView) findViewById(2131821563);
        this.jwI.setAdapter(this.jwH);
        this.jwI.setEmptyView(findViewById(2131821564));
        this.jux = (TextView) findViewById(2131821578);
        this.juy = (TextView) findViewById(2131821566);
        this.juA = (ProgressBar) findViewById(2131821565);
        this.juz = (TextView) findViewById(2131821579);
        this.juB = findViewById(2131821567);
        this.juC = (LinearLayout) findViewById(2131821568);
        this.juD = (LinearLayout) findViewById(2131821569);
        this.juE = (LinearLayout) findViewById(2131821572);
        this.juF = (LinearLayout) findViewById(2131821575);
        this.juG = (TextView) findViewById(2131821571);
        this.juH = (TextView) findViewById(2131821574);
        this.juI = (TextView) findViewById(2131821577);
        ((TextView) findViewById(2131821570)).setText(C25738R.string.f9429zp);
        ((TextView) findViewById(2131821573)).setText(C25738R.string.f9430zs);
        ((TextView) findViewById(2131821576)).setText(C25738R.string.f9427zn);
        setBackBtn(new C111021());
        this.juJ = (Button) findViewById(2131821580);
        this.juJ.setOnClickListener(new C26142());
        this.juJ.setEnabled(false);
        if (C42759b.aTD().aTF().jwv || C42759b.aTD().aTF().jww) {
            this.juz.setVisibility(0);
            m75822fm(true);
            this.juz.setOnClickListener(new C336703());
        } else {
            this.juz.setVisibility(8);
        }
        this.jux.setOnClickListener(new C336714());
        if (C42759b.aTD().aTH().jsY) {
            if (C42759b.aTD().aTH().aSV().size() == 0) {
                switch (juK) {
                    case 0:
                        this.juy.setText(C25738R.string.f9428zo);
                        break;
                    case 1:
                        this.juy.setText(C25738R.string.a1h);
                        break;
                }
                this.juy.setVisibility(0);
            }
            this.juA.setVisibility(4);
            AppMethodBeat.m2505o(17583);
            return;
        }
        this.jux.setTextColor(getResources().getColor(C25738R.color.f11770gp));
        this.jux.setClickable(false);
        this.juA.setVisibility(0);
        AppMethodBeat.m2505o(17583);
    }

    /* renamed from: fm */
    private void m75822fm(boolean z) {
        AppMethodBeat.m2504i(17584);
        if (z) {
            C42759b.aTD();
            SharedPreferences aSz = C38634d.aSz();
            juK = aSz.getInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0);
            aPA = aSz.getInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0);
            startTime = aSz.getLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0);
            endTime = aSz.getLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0);
        }
        if (C42759b.aTD().aTF().jwv) {
            switch (juK) {
                case 0:
                    this.juE.setVisibility(8);
                    break;
                case 1:
                    this.juB.setVisibility(0);
                    this.juC.setVisibility(0);
                    this.juE.setVisibility(0);
                    this.juH.setText(this.juL.format(new Date(startTime)) + "~" + this.juL.format(new Date(endTime - 86400000)));
                    break;
            }
        }
        if (C42759b.aTD().aTF().jww) {
            switch (aPA) {
                case 0:
                    this.juF.setVisibility(8);
                    break;
                case 1:
                    this.juB.setVisibility(0);
                    this.juC.setVisibility(0);
                    this.juF.setVisibility(0);
                    this.juI.setText(this.mController.ylL.getResources().getString(C25738R.string.a12));
                    break;
            }
        }
        aTt();
        AppMethodBeat.m2505o(17584);
    }

    /* renamed from: a */
    public final void mo68237a(HashSet<Integer> hashSet) {
        AppMethodBeat.m2504i(17585);
        HashSet hashSet2 = new HashSet();
        int size = C42759b.aTD().aTH().aSV().size();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            if (intValue >= size) {
                hashSet2.add(Integer.valueOf(intValue));
            }
        }
        Iterator it2 = hashSet2.iterator();
        while (it2.hasNext()) {
            hashSet.remove(Integer.valueOf(((Integer) it2.next()).intValue()));
        }
        if (hashSet.size() != 0) {
            this.juJ.setEnabled(true);
            if (C42759b.aTD().aTH().jsY && hashSet.size() == this.jwH.getCount()) {
                this.jux.setText(C25738R.string.f9347xd);
            } else {
                this.jux.setText(C25738R.string.f9346xc);
            }
            this.juB.setVisibility(0);
            this.juC.setVisibility(0);
            this.juD.setVisibility(0);
            this.juG.setText(getString(C25738R.string.f9349xf, new Object[]{Integer.valueOf(hashSet.size())}));
        } else {
            this.juJ.setEnabled(false);
            this.jux.setText(C25738R.string.f9346xc);
            this.juD.setVisibility(8);
            this.juG.setText("");
        }
        aTt();
        AppMethodBeat.m2505o(17585);
    }

    private void aTt() {
        AppMethodBeat.m2504i(17586);
        if (this.juD.getVisibility() == 8 && this.juE.getVisibility() == 8 && this.juF.getVisibility() == 8) {
            this.juB.setVisibility(8);
            this.juC.setVisibility(8);
            AppMethodBeat.m2505o(17586);
            return;
        }
        this.juB.setVisibility(0);
        this.juC.setVisibility(0);
        AppMethodBeat.m2505o(17586);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(17587);
        if (i2 != -1) {
            C4990ab.m7413e("MicroMsg.BackupPcChooseUI", "onActivityResult result error! resultCode[%d]", Integer.valueOf(i2));
            AppMethodBeat.m2505o(17587);
            return;
        }
        int i3 = juK;
        long j = startTime;
        long j2 = endTime;
        juK = intent.getIntExtra("BACKUP_SELECT_TIME_MODE", juK);
        startTime = intent.getLongExtra("BACKUP_SELECT_TIME_START_TIME", 0);
        endTime = intent.getLongExtra("BACKUP_SELECT_TIME_END_TIME", 0);
        aPA = intent.getIntExtra("BACKUP_SELECT_CONTENT_TYPE", aPA);
        C4990ab.m7417i("MicroMsg.BackupPcChooseUI", "onActivityResult timeMode/preTimeMode[%d/%d], startTime/preStartTime[%d/%d], endTime/preEndTime[%d/%d], contentType[%d]", Integer.valueOf(juK), Integer.valueOf(i3), Long.valueOf(startTime), Long.valueOf(j), Long.valueOf(endTime), Long.valueOf(j2), Integer.valueOf(aPA));
        C42759b.aTD().aTF();
        C42760e.m75812e(juK, startTime, endTime, aPA);
        m75822fm(false);
        if (i3 == juK && (juK == 0 || (juK == 1 && startTime == j && endTime == j2))) {
            AppMethodBeat.m2505o(17587);
            return;
        }
        C42759b.aTD().aTH().mo35199a(juK, startTime, endTime, C42759b.aTD().aTH().aSU());
        C19958a c19958a = this.jwH;
        c19958a.jur.clear();
        c19958a.jwE.mo68237a(c19958a.jur);
        if (C42759b.aTD().aTH().aSV() == null || C42759b.aTD().aTH().aSV().size() == 0) {
            switch (juK) {
                case 0:
                    this.juy.setText(C25738R.string.f9428zo);
                    break;
                case 1:
                    this.juy.setText(C25738R.string.a1h);
                    break;
            }
            this.juy.setVisibility(0);
        } else {
            this.juy.setVisibility(4);
        }
        this.jwH.notifyDataSetChanged();
        AppMethodBeat.m2505o(17587);
    }
}

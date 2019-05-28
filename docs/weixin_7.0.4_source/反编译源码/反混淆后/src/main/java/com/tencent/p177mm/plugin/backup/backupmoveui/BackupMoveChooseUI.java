package com.tencent.p177mm.plugin.backup.backupmoveui;

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
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.backup.backupui.BackupSelectExtUI;
import com.tencent.p177mm.plugin.backup.p342b.C38634d;
import com.tencent.p177mm.plugin.backup.p342b.C38635g;
import com.tencent.p177mm.plugin.backup.p342b.C45733f.C27443b;
import com.tencent.p177mm.plugin.backup.p344c.C33685b.C33686b;
import com.tencent.p177mm.plugin.backup.p345d.C41258b;
import com.tencent.p177mm.plugin.backup.p345d.C45743a;
import com.tencent.p177mm.plugin.backup.p345d.C45743a.C111442;
import com.tencent.p177mm.plugin.backup.p345d.C6793d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.pointers.PLong;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveChooseUI */
public class BackupMoveChooseUI extends MMWizardActivity {
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
    private C33686b juM = new C26025();
    private C27446a juv = new C27446a(this);
    private ListView juw;
    private TextView jux;
    private TextView juy;
    private TextView juz;

    /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveChooseUI$3 */
    class C26013 implements OnClickListener {
        C26013() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(17326);
            Intent intent = new Intent(BackupMoveChooseUI.this, BackupSelectExtUI.class);
            intent.putExtra("BACKUP_MODE", 2);
            intent.putExtra("BACKUP_SELECT_TIME_MODE", BackupMoveChooseUI.juK);
            intent.putExtra("BACKUP_SELECT_SUPPORT_CONTENT_TYPE", true);
            intent.putExtra("BACKUP_SELECT_CONTENT_TYPE", BackupMoveChooseUI.aPA);
            intent.putExtra("BACKUP_SELECT_TIME_START_TIME", BackupMoveChooseUI.startTime);
            intent.putExtra("BACKUP_SELECT_TIME_END_TIME", BackupMoveChooseUI.endTime);
            intent.putExtra("BACKUP_SELECT_TIME_MIN_CONVERSATION_TIME", C41258b.aSZ().aTd().jsU);
            BackupMoveChooseUI.this.startActivityForResult(intent, 0);
            AppMethodBeat.m2505o(17326);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveChooseUI$5 */
    class C26025 implements C33686b {
        C26025() {
        }

        /* renamed from: a */
        public final void mo6660a(LinkedList<C27443b> linkedList, C27443b c27443b, int i) {
        }

        /* renamed from: C */
        public final void mo6659C(LinkedList<C27443b> linkedList) {
        }

        /* renamed from: B */
        public final void mo6658B(LinkedList<C27443b> linkedList) {
            AppMethodBeat.m2504i(17328);
            if (linkedList == null) {
                AppMethodBeat.m2505o(17328);
            } else if (linkedList.size() == 0) {
                BackupMoveChooseUI.this.juA.setVisibility(8);
                BackupMoveChooseUI.this.juy.setVisibility(0);
                switch (BackupMoveChooseUI.juK) {
                    case 0:
                        BackupMoveChooseUI.this.juy.setText(C25738R.string.f9356xm);
                        AppMethodBeat.m2505o(17328);
                        return;
                    case 1:
                        BackupMoveChooseUI.this.juy.setText(C25738R.string.a1h);
                        break;
                }
                AppMethodBeat.m2505o(17328);
            } else {
                BackupMoveChooseUI.this.jux.setClickable(true);
                BackupMoveChooseUI.this.jux.setTextColor(BackupMoveChooseUI.this.getResources().getColor(C25738R.color.f11768gn));
                BackupMoveChooseUI.this.juA.setVisibility(8);
                BackupMoveChooseUI.this.juv.notifyDataSetChanged();
                AppMethodBeat.m2505o(17328);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveChooseUI$4 */
    class C26034 implements OnClickListener {
        C26034() {
        }

        public final void onClick(View view) {
            int i = 0;
            AppMethodBeat.m2504i(17327);
            if (C41258b.aSZ().aTd().jsY) {
                C27446a a = BackupMoveChooseUI.this.juv;
                if (a.jur.size() == a.getCount()) {
                    a.jur.clear();
                    a.jus = false;
                } else {
                    while (i < a.getCount()) {
                        a.jur.add(Integer.valueOf(i));
                        i++;
                    }
                    a.jus = true;
                }
                a.notifyDataSetChanged();
                a.juq.mo6652a(a.jur);
            }
            AppMethodBeat.m2505o(17327);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveChooseUI$1 */
    class C26041 implements OnMenuItemClickListener {
        C26041() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(17324);
            BackupMoveChooseUI.this.finish();
            AppMethodBeat.m2505o(17324);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveChooseUI$2 */
    class C26052 implements OnClickListener {
        C26052() {
        }

        public final void onClick(View view) {
            LinkedList linkedList;
            AppMethodBeat.m2504i(17325);
            PLong pLong = new PLong();
            PInt pInt = new PInt();
            C27446a a = BackupMoveChooseUI.this.juv;
            LinkedList linkedList2 = new LinkedList();
            if (a.jur.size() <= 0) {
                linkedList = linkedList2;
            } else {
                pLong.value = 0;
                pInt.value = 0;
                LinkedList aSV = C41258b.aSZ().aTd().aSV();
                if (aSV != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= a.getCount()) {
                            break;
                        }
                        if (a.jur.contains(Integer.valueOf(i2))) {
                            linkedList2.add(aSV.get(i2));
                            pLong.value += ((C27443b) aSV.get(i2)).jri;
                            pInt.value = (int) (((long) pInt.value) + ((C27443b) aSV.get(i2)).jrj);
                        }
                        i = i2 + 1;
                    }
                }
                C4990ab.m7417i("MicroMsg.BackupMoveChooseAdapter", "finishSelected usernameSize:%d, convSize:%d, convMsgCount:%d", Integer.valueOf(linkedList2.size()), Long.valueOf(pLong.value), Integer.valueOf(pInt.value));
                linkedList = linkedList2;
            }
            LinkedList A = C38635g.m65500A(linkedList);
            C45743a aTd = C41258b.aSZ().aTd();
            if (linkedList.size() == 0) {
                aTd.jsX = new LinkedList();
            } else {
                aTd.jsX = new LinkedList(linkedList.subList((linkedList.size() * 3) / 4, linkedList.size()));
                aTd.jsX.addAll(linkedList.subList(0, (linkedList.size() * 3) / 4));
            }
            C6793d aTb = C41258b.aSZ().aTb();
            aTb.jtQ = A;
            C41258b.aSZ();
            if (C38634d.aSz().getInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0) == 1) {
                C6793d.jtX = true;
            } else {
                C6793d.jtX = false;
            }
            C41258b.aSZ();
            aTb.jtT = C38634d.aSz().getLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0);
            C41258b.aSZ();
            aTb.jtU = C38634d.aSz().getLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0);
            C41258b.aSZ();
            if (C38634d.aSz().getInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0) == 1) {
                C6793d.jsA = true;
            } else {
                C6793d.jsA = false;
            }
            C4990ab.m7417i("MicroMsg.BackupMoveServer", "setBakupChooseData users size[%d], selectStartTime[%d], selectEndTime[%d], isQuickBackup[%b]", Integer.valueOf(A.size()), Long.valueOf(aTb.jtT), Long.valueOf(aTb.jtU), Boolean.valueOf(C6793d.jsA));
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(C5127a.USERINFO_BACKUP_MOVE_BACKUPING_BOOLEAN, Boolean.TRUE);
            C45743a aTd2 = C41258b.aSZ().aTd();
            if (aTd2.jsS != null) {
                aTd2.jsS.cancel();
            }
            C7305d.post(new C111442(), "BakMoveChooseServer.calculateChooseConvSize");
            if (BackupMoveChooseUI.this.juv.jus) {
                C7060h.pYm.mo8378a(485, 22, 1, false);
                C7060h.pYm.mo8381e(11788, Integer.valueOf(4));
            }
            if (BackupMoveChooseUI.juK == 1 && BackupMoveChooseUI.aPA == 1) {
                C7060h.pYm.mo8378a(485, 26, 1, false);
                C7060h.pYm.mo8378a(485, 27, 1, false);
                C7060h.pYm.mo8381e(11788, Integer.valueOf(7));
            } else if (BackupMoveChooseUI.juK == 1) {
                C7060h.pYm.mo8378a(485, 26, 1, false);
                C7060h.pYm.mo8381e(11788, Integer.valueOf(5));
            } else if (BackupMoveChooseUI.aPA == 1) {
                C7060h.pYm.mo8378a(485, 27, 1, false);
                C7060h.pYm.mo8381e(11788, Integer.valueOf(6));
            }
            C7060h.pYm.mo8381e(11788, Integer.valueOf(8));
            MMWizardActivity.m23791J(BackupMoveChooseUI.this, new Intent(BackupMoveChooseUI.this, BackupMoveQRCodeUI.class));
            C7060h.pYm.mo8378a(485, 23, 1, false);
            AppMethodBeat.m2505o(17325);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public BackupMoveChooseUI() {
        AppMethodBeat.m2504i(17329);
        AppMethodBeat.m2505o(17329);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(17330);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(17330);
    }

    public void onStart() {
        AppMethodBeat.m2504i(17331);
        super.onStart();
        C41258b.aSZ().aTd().jsT = this.juM;
        AppMethodBeat.m2505o(17331);
    }

    public void onStop() {
        AppMethodBeat.m2504i(17332);
        super.onStop();
        C41258b.aSZ().aTd().jsT = null;
        AppMethodBeat.m2505o(17332);
    }

    public final void initView() {
        AppMethodBeat.m2504i(17333);
        setMMTitle((int) C25738R.string.a1q);
        this.juw = (ListView) findViewById(2131821563);
        this.juw.setAdapter(this.juv);
        this.juw.setEmptyView(findViewById(2131821564));
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
        ((TextView) findViewById(2131821570)).setText(C25738R.string.f9357xn);
        ((TextView) findViewById(2131821573)).setText(C25738R.string.f9358xp);
        ((TextView) findViewById(2131821576)).setText(C25738R.string.f9355xl);
        setBackBtn(new C26041());
        this.juJ = (Button) findViewById(2131821580);
        this.juJ.setOnClickListener(new C26052());
        this.juJ.setEnabled(false);
        m4857fm(true);
        this.juz.setOnClickListener(new C26013());
        this.jux.setOnClickListener(new C26034());
        if (C41258b.aSZ().aTd().jsY) {
            if (C41258b.aSZ().aTd().aSV() == null || C41258b.aSZ().aTd().aSV().size() == 0) {
                switch (juK) {
                    case 0:
                        this.juy.setText(C25738R.string.f9356xm);
                        break;
                    case 1:
                        this.juy.setText(C25738R.string.a1h);
                        break;
                }
                this.juy.setVisibility(0);
            }
            this.juA.setVisibility(4);
            AppMethodBeat.m2505o(17333);
        } else if (C41258b.aSZ().aTd().jsY) {
            this.juA.setVisibility(4);
            AppMethodBeat.m2505o(17333);
        } else {
            this.jux.setTextColor(getResources().getColor(C25738R.color.f11770gp));
            this.jux.setClickable(false);
            this.juA.setVisibility(0);
            AppMethodBeat.m2505o(17333);
        }
    }

    /* renamed from: fm */
    private void m4857fm(boolean z) {
        AppMethodBeat.m2504i(17334);
        if (z) {
            C41258b.aSZ();
            SharedPreferences aSz = C38634d.aSz();
            juK = aSz.getInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0);
            aPA = aSz.getInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0);
            startTime = aSz.getLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0);
            endTime = aSz.getLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0);
        }
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
        switch (aPA) {
            case 0:
                this.juF.setVisibility(8);
                break;
            case 1:
                this.juB.setVisibility(0);
                this.juC.setVisibility(0);
                this.juF.setVisibility(0);
                this.juI.setText(this.mController.ylL.getResources().getString(C25738R.string.f9414z9));
                break;
        }
        aTt();
        AppMethodBeat.m2505o(17334);
    }

    /* renamed from: a */
    public final void mo6652a(HashSet<Integer> hashSet) {
        AppMethodBeat.m2504i(17335);
        LinkedList aSV = C41258b.aSZ().aTd().aSV();
        if (aSV == null) {
            C4990ab.m7412e("MicroMsg.BackupMoveChooseUI", "onClickCheckBox convInfo is null.");
            AppMethodBeat.m2505o(17335);
            return;
        }
        HashSet hashSet2 = new HashSet();
        Iterator it = hashSet.iterator();
        long j = 0;
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            if (intValue < aSV.size()) {
                j = ((C27443b) aSV.get(intValue)).jri + j;
            } else {
                hashSet2.add(Integer.valueOf(intValue));
            }
        }
        Iterator it2 = hashSet2.iterator();
        while (it2.hasNext()) {
            hashSet.remove((Integer) it2.next());
        }
        if (hashSet.size() != 0 || j > 0) {
            this.juJ.setEnabled(true);
            if (hashSet.size() == this.juv.getCount()) {
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
        AppMethodBeat.m2505o(17335);
    }

    private void aTt() {
        AppMethodBeat.m2504i(17336);
        if (this.juD.getVisibility() == 8 && this.juE.getVisibility() == 8 && this.juF.getVisibility() == 8) {
            this.juB.setVisibility(8);
            this.juC.setVisibility(8);
            AppMethodBeat.m2505o(17336);
            return;
        }
        this.juB.setVisibility(0);
        this.juC.setVisibility(0);
        AppMethodBeat.m2505o(17336);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(17337);
        if (i2 != -1) {
            C4990ab.m7413e("MicroMsg.BackupMoveChooseUI", "onActivityResult result error! resultCode:%d", Integer.valueOf(i2));
            AppMethodBeat.m2505o(17337);
            return;
        }
        int i3 = juK;
        long j = startTime;
        long j2 = endTime;
        juK = intent.getIntExtra("BACKUP_SELECT_TIME_MODE", juK);
        startTime = intent.getLongExtra("BACKUP_SELECT_TIME_START_TIME", 0);
        endTime = intent.getLongExtra("BACKUP_SELECT_TIME_END_TIME", 0);
        aPA = intent.getIntExtra("BACKUP_SELECT_CONTENT_TYPE", aPA);
        C4990ab.m7417i("MicroMsg.BackupMoveChooseUI", "onActivityResult timeMode/preTimeMode[%d/%d], startTime/preStartTime[%d/%d], endTime/preEndTime[%d/%d], contentType[%d]", Integer.valueOf(juK), Integer.valueOf(i3), Long.valueOf(startTime), Long.valueOf(j), Long.valueOf(endTime), Long.valueOf(j2), Integer.valueOf(aPA));
        C41258b.aSZ().aTb();
        C6793d.m11230d(juK, startTime, endTime, aPA);
        m4857fm(false);
        if (i3 == juK && (juK == 0 || (juK == 1 && startTime == j && endTime == j2))) {
            AppMethodBeat.m2505o(17337);
            return;
        }
        C41258b.aSZ().aTd().mo73540a(juK, startTime, endTime, C41258b.aSZ().aTd().aSU());
        C27446a c27446a = this.juv;
        c27446a.jur.clear();
        c27446a.juq.mo6652a(c27446a.jur);
        if (C41258b.aSZ().aTd().aSV() == null || C41258b.aSZ().aTd().aSV().size() == 0) {
            switch (juK) {
                case 0:
                    this.juy.setText(C25738R.string.f9356xm);
                    break;
                case 1:
                    this.juy.setText(C25738R.string.a1h);
                    break;
            }
            this.juy.setVisibility(0);
        } else {
            this.juy.setVisibility(4);
        }
        this.juv.notifyDataSetChanged();
        AppMethodBeat.m2505o(17337);
    }

    public final int getLayoutId() {
        return 2130968795;
    }
}

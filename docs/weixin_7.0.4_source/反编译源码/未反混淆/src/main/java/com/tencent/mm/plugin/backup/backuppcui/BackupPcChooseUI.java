package com.tencent.mm.plugin.backup.backuppcui;

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
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.b.f;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.backuppcmodel.e;
import com.tencent.mm.plugin.backup.backupui.BackupSelectExtUI;
import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

@a(3)
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
    private a jwH = new a(this);
    private ListView jwI;
    private b.a jwJ = new b.a() {
        public final void B(LinkedList<f.b> linkedList) {
            AppMethodBeat.i(17578);
            if (linkedList == null) {
                AppMethodBeat.o(17578);
            } else if (linkedList.size() == 0) {
                BackupPcChooseUI.this.juA.setVisibility(8);
                BackupPcChooseUI.this.juy.setVisibility(0);
                switch (BackupPcChooseUI.juK) {
                    case 0:
                        BackupPcChooseUI.this.juy.setText(R.string.zo);
                        AppMethodBeat.o(17578);
                        return;
                    case 1:
                        BackupPcChooseUI.this.juy.setText(R.string.a1h);
                        break;
                }
                AppMethodBeat.o(17578);
            } else {
                BackupPcChooseUI.this.jux.setClickable(true);
                BackupPcChooseUI.this.jux.setTextColor(BackupPcChooseUI.this.getResources().getColor(R.color.gn));
                BackupPcChooseUI.this.juA.setVisibility(8);
                BackupPcChooseUI.this.jwH.notifyDataSetChanged();
                AppMethodBeat.o(17578);
            }
        }
    };

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BackupPcChooseUI() {
        AppMethodBeat.i(17579);
        AppMethodBeat.o(17579);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(17580);
        super.onCreate(bundle);
        if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            AppMethodBeat.o(17580);
            return;
        }
        initView();
        AppMethodBeat.o(17580);
    }

    public final int getLayoutId() {
        return R.layout.f8;
    }

    public void onStart() {
        AppMethodBeat.i(17581);
        super.onStart();
        com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTH().jvS = this.jwJ;
        AppMethodBeat.o(17581);
    }

    public void onStop() {
        AppMethodBeat.i(17582);
        super.onStop();
        com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTH().jvS = null;
        AppMethodBeat.o(17582);
    }

    public final void initView() {
        AppMethodBeat.i(17583);
        setMMTitle((int) R.string.a16);
        this.jwI = (ListView) findViewById(R.id.a0i);
        this.jwI.setAdapter(this.jwH);
        this.jwI.setEmptyView(findViewById(R.id.a0j));
        this.jux = (TextView) findViewById(R.id.a0x);
        this.juy = (TextView) findViewById(R.id.a0l);
        this.juA = (ProgressBar) findViewById(R.id.a0k);
        this.juz = (TextView) findViewById(R.id.a0y);
        this.juB = findViewById(R.id.a0m);
        this.juC = (LinearLayout) findViewById(R.id.a0n);
        this.juD = (LinearLayout) findViewById(R.id.a0o);
        this.juE = (LinearLayout) findViewById(R.id.a0r);
        this.juF = (LinearLayout) findViewById(R.id.a0u);
        this.juG = (TextView) findViewById(R.id.a0q);
        this.juH = (TextView) findViewById(R.id.a0t);
        this.juI = (TextView) findViewById(R.id.a0w);
        ((TextView) findViewById(R.id.a0p)).setText(R.string.zp);
        ((TextView) findViewById(R.id.a0s)).setText(R.string.zs);
        ((TextView) findViewById(R.id.a0v)).setText(R.string.zn);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(17573);
                BackupPcChooseUI.this.finish();
                AppMethodBeat.o(17573);
                return false;
            }
        });
        this.juJ = (Button) findViewById(R.id.a0z);
        this.juJ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                LinkedList linkedList;
                AppMethodBeat.i(17575);
                a a = BackupPcChooseUI.this.jwH;
                LinkedList linkedList2 = new LinkedList();
                if (a.jur.size() <= 0) {
                    linkedList = linkedList2;
                } else {
                    LinkedList aSV = com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTH().aSV();
                    if (aSV != null) {
                        for (int i = 0; i < a.getCount(); i++) {
                            if (a.jur.contains(Integer.valueOf(i))) {
                                linkedList2.add(aSV.get(i));
                            }
                        }
                    }
                    ab.i("MicroMsg.BackupPcChooseAdapter", "finishSelected usernameSize:%d", Integer.valueOf(linkedList2.size()));
                    linkedList = linkedList2;
                }
                final LinkedList A = g.A(linkedList);
                aw.ZK();
                ab.i("MicroMsg.BackupPcChooseUI", "initView OnMenuItemClickListener startbackup choose records finish, selectedConversation size[%d], hasMove[%b], timeMode[%d], startTime[%d], endTime[%d], contentType[%d]", Integer.valueOf(linkedList.size()), Boolean.valueOf(((Boolean) c.Ry().get(ac.a.USERINFO_BACKUP_OLD_RECORDS_BOOLEAN, Boolean.FALSE)).booleanValue()), Integer.valueOf(BackupPcChooseUI.juK), Long.valueOf(BackupPcChooseUI.startTime), Long.valueOf(BackupPcChooseUI.endTime), Integer.valueOf(BackupPcChooseUI.aPA));
                if (((Boolean) c.Ry().get(ac.a.USERINFO_BACKUP_OLD_RECORDS_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                    h.a(BackupPcChooseUI.this, (int) R.string.a0k, 0, (int) R.string.a1u, 0, false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(17574);
                            com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTH().F(linkedList);
                            com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTE().rs(2);
                            com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aSu().jqW = 12;
                            com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTF().G(A);
                            com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTF().gx((long) linkedList.size());
                            com.tencent.mm.plugin.report.service.h.pYm.a(400, 8, 1, false);
                            com.tencent.mm.plugin.report.service.h.pYm.e(13735, Integer.valueOf(10), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTE().jwg));
                            if (BackupPcChooseUI.juK == 1 && BackupPcChooseUI.aPA == 1) {
                                com.tencent.mm.plugin.report.service.h.pYm.a(400, 32, 1, false);
                                com.tencent.mm.plugin.report.service.h.pYm.a(400, 35, 1, false);
                                com.tencent.mm.plugin.report.service.h.pYm.e(13735, Integer.valueOf(13), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTE().jwg));
                            } else if (BackupPcChooseUI.juK == 1) {
                                com.tencent.mm.plugin.report.service.h.pYm.a(400, 32, 1, false);
                                com.tencent.mm.plugin.report.service.h.pYm.e(13735, Integer.valueOf(11), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTE().jwg));
                            } else if (BackupPcChooseUI.aPA == 1) {
                                com.tencent.mm.plugin.report.service.h.pYm.a(400, 35, 1, false);
                                com.tencent.mm.plugin.report.service.h.pYm.e(13735, Integer.valueOf(12), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTE().jwg));
                            }
                            BackupPcChooseUI.this.finish();
                            AppMethodBeat.o(17574);
                        }
                    }, null, (int) R.color.gn);
                    AppMethodBeat.o(17575);
                    return;
                }
                com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTH().F(linkedList);
                com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTE().rs(2);
                com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aSu().jqW = 12;
                com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTF().G(A);
                com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTF().gx((long) linkedList.size());
                com.tencent.mm.plugin.report.service.h.pYm.a(400, 8, 1, false);
                com.tencent.mm.plugin.report.service.h.pYm.e(13735, Integer.valueOf(10), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTE().jwg));
                if (BackupPcChooseUI.juK == 1 && BackupPcChooseUI.aPA == 1) {
                    com.tencent.mm.plugin.report.service.h.pYm.a(400, 32, 1, false);
                    com.tencent.mm.plugin.report.service.h.pYm.a(400, 35, 1, false);
                    com.tencent.mm.plugin.report.service.h.pYm.e(13735, Integer.valueOf(13), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTE().jwg));
                } else if (BackupPcChooseUI.juK == 1) {
                    com.tencent.mm.plugin.report.service.h.pYm.a(400, 32, 1, false);
                    com.tencent.mm.plugin.report.service.h.pYm.e(13735, Integer.valueOf(11), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTE().jwg));
                } else if (BackupPcChooseUI.aPA == 1) {
                    com.tencent.mm.plugin.report.service.h.pYm.a(400, 35, 1, false);
                    com.tencent.mm.plugin.report.service.h.pYm.e(13735, Integer.valueOf(12), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTE().jwg));
                }
                BackupPcChooseUI.this.finish();
                AppMethodBeat.o(17575);
            }
        });
        this.juJ.setEnabled(false);
        if (com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTF().jwv || com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTF().jww) {
            this.juz.setVisibility(0);
            fm(true);
            this.juz.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(17576);
                    Intent intent = new Intent(BackupPcChooseUI.this, BackupSelectExtUI.class);
                    intent.putExtra("BACKUP_MODE", 1);
                    intent.putExtra("BACKUP_SELECT_TIME_MODE", BackupPcChooseUI.juK);
                    intent.putExtra("BACKUP_SELECT_SUPPORT_CONTENT_TYPE", com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTF().jww);
                    intent.putExtra("BACKUP_SELECT_CONTENT_TYPE", BackupPcChooseUI.aPA);
                    intent.putExtra("BACKUP_SELECT_TIME_START_TIME", BackupPcChooseUI.startTime);
                    intent.putExtra("BACKUP_SELECT_TIME_END_TIME", BackupPcChooseUI.endTime);
                    intent.putExtra("BACKUP_SELECT_TIME_MIN_CONVERSATION_TIME", com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTH().jsU);
                    BackupPcChooseUI.this.startActivityForResult(intent, 0);
                    AppMethodBeat.o(17576);
                }
            });
        } else {
            this.juz.setVisibility(8);
        }
        this.jux.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                int i = 0;
                AppMethodBeat.i(17577);
                if (com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTH().jsY) {
                    a a = BackupPcChooseUI.this.jwH;
                    if (a.jur.size() == a.getCount()) {
                        a.jur.clear();
                        a.jwF = false;
                    } else {
                        while (i < a.getCount()) {
                            a.jur.add(Integer.valueOf(i));
                            i++;
                        }
                        a.jwF = true;
                    }
                    a.notifyDataSetChanged();
                    a.jwE.a(a.jur);
                }
                AppMethodBeat.o(17577);
            }
        });
        if (com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTH().jsY) {
            if (com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTH().aSV().size() == 0) {
                switch (juK) {
                    case 0:
                        this.juy.setText(R.string.zo);
                        break;
                    case 1:
                        this.juy.setText(R.string.a1h);
                        break;
                }
                this.juy.setVisibility(0);
            }
            this.juA.setVisibility(4);
            AppMethodBeat.o(17583);
            return;
        }
        this.jux.setTextColor(getResources().getColor(R.color.gp));
        this.jux.setClickable(false);
        this.juA.setVisibility(0);
        AppMethodBeat.o(17583);
    }

    private void fm(boolean z) {
        AppMethodBeat.i(17584);
        if (z) {
            com.tencent.mm.plugin.backup.backuppcmodel.b.aTD();
            SharedPreferences aSz = d.aSz();
            juK = aSz.getInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0);
            aPA = aSz.getInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0);
            startTime = aSz.getLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0);
            endTime = aSz.getLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0);
        }
        if (com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTF().jwv) {
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
        if (com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTF().jww) {
            switch (aPA) {
                case 0:
                    this.juF.setVisibility(8);
                    break;
                case 1:
                    this.juB.setVisibility(0);
                    this.juC.setVisibility(0);
                    this.juF.setVisibility(0);
                    this.juI.setText(this.mController.ylL.getResources().getString(R.string.a12));
                    break;
            }
        }
        aTt();
        AppMethodBeat.o(17584);
    }

    public final void a(HashSet<Integer> hashSet) {
        AppMethodBeat.i(17585);
        HashSet hashSet2 = new HashSet();
        int size = com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTH().aSV().size();
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
            if (com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTH().jsY && hashSet.size() == this.jwH.getCount()) {
                this.jux.setText(R.string.xd);
            } else {
                this.jux.setText(R.string.xc);
            }
            this.juB.setVisibility(0);
            this.juC.setVisibility(0);
            this.juD.setVisibility(0);
            this.juG.setText(getString(R.string.xf, new Object[]{Integer.valueOf(hashSet.size())}));
        } else {
            this.juJ.setEnabled(false);
            this.jux.setText(R.string.xc);
            this.juD.setVisibility(8);
            this.juG.setText("");
        }
        aTt();
        AppMethodBeat.o(17585);
    }

    private void aTt() {
        AppMethodBeat.i(17586);
        if (this.juD.getVisibility() == 8 && this.juE.getVisibility() == 8 && this.juF.getVisibility() == 8) {
            this.juB.setVisibility(8);
            this.juC.setVisibility(8);
            AppMethodBeat.o(17586);
            return;
        }
        this.juB.setVisibility(0);
        this.juC.setVisibility(0);
        AppMethodBeat.o(17586);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(17587);
        if (i2 != -1) {
            ab.e("MicroMsg.BackupPcChooseUI", "onActivityResult result error! resultCode[%d]", Integer.valueOf(i2));
            AppMethodBeat.o(17587);
            return;
        }
        int i3 = juK;
        long j = startTime;
        long j2 = endTime;
        juK = intent.getIntExtra("BACKUP_SELECT_TIME_MODE", juK);
        startTime = intent.getLongExtra("BACKUP_SELECT_TIME_START_TIME", 0);
        endTime = intent.getLongExtra("BACKUP_SELECT_TIME_END_TIME", 0);
        aPA = intent.getIntExtra("BACKUP_SELECT_CONTENT_TYPE", aPA);
        ab.i("MicroMsg.BackupPcChooseUI", "onActivityResult timeMode/preTimeMode[%d/%d], startTime/preStartTime[%d/%d], endTime/preEndTime[%d/%d], contentType[%d]", Integer.valueOf(juK), Integer.valueOf(i3), Long.valueOf(startTime), Long.valueOf(j), Long.valueOf(endTime), Long.valueOf(j2), Integer.valueOf(aPA));
        com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTF();
        e.e(juK, startTime, endTime, aPA);
        fm(false);
        if (i3 == juK && (juK == 0 || (juK == 1 && startTime == j && endTime == j2))) {
            AppMethodBeat.o(17587);
            return;
        }
        com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTH().a(juK, startTime, endTime, com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTH().aSU());
        a aVar = this.jwH;
        aVar.jur.clear();
        aVar.jwE.a(aVar.jur);
        if (com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTH().aSV() == null || com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aTH().aSV().size() == 0) {
            switch (juK) {
                case 0:
                    this.juy.setText(R.string.zo);
                    break;
                case 1:
                    this.juy.setText(R.string.a1h);
                    break;
            }
            this.juy.setVisibility(0);
        } else {
            this.juy.setVisibility(4);
        }
        this.jwH.notifyDataSetChanged();
        AppMethodBeat.o(17587);
    }
}

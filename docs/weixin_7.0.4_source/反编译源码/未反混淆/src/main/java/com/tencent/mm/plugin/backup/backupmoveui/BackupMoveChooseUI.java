package com.tencent.mm.plugin.backup.backupmoveui;

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
import com.tencent.mm.plugin.backup.b.f;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.backupui.BackupSelectExtUI;
import com.tencent.mm.plugin.backup.c.b.AnonymousClass3;
import com.tencent.mm.plugin.backup.c.b.AnonymousClass4;
import com.tencent.mm.plugin.backup.c.b.b;
import com.tencent.mm.plugin.backup.d.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

@a(3)
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
    private b juM = new b() {
        public final void a(LinkedList<f.b> linkedList, f.b bVar, int i) {
        }

        public final void C(LinkedList<f.b> linkedList) {
        }

        public final void B(LinkedList<f.b> linkedList) {
            AppMethodBeat.i(17328);
            if (linkedList == null) {
                AppMethodBeat.o(17328);
            } else if (linkedList.size() == 0) {
                BackupMoveChooseUI.this.juA.setVisibility(8);
                BackupMoveChooseUI.this.juy.setVisibility(0);
                switch (BackupMoveChooseUI.juK) {
                    case 0:
                        BackupMoveChooseUI.this.juy.setText(R.string.xm);
                        AppMethodBeat.o(17328);
                        return;
                    case 1:
                        BackupMoveChooseUI.this.juy.setText(R.string.a1h);
                        break;
                }
                AppMethodBeat.o(17328);
            } else {
                BackupMoveChooseUI.this.jux.setClickable(true);
                BackupMoveChooseUI.this.jux.setTextColor(BackupMoveChooseUI.this.getResources().getColor(R.color.gn));
                BackupMoveChooseUI.this.juA.setVisibility(8);
                BackupMoveChooseUI.this.juv.notifyDataSetChanged();
                AppMethodBeat.o(17328);
            }
        }
    };
    private a juv = new a(this);
    private ListView juw;
    private TextView jux;
    private TextView juy;
    private TextView juz;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BackupMoveChooseUI() {
        AppMethodBeat.i(17329);
        AppMethodBeat.o(17329);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(17330);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(17330);
    }

    public void onStart() {
        AppMethodBeat.i(17331);
        super.onStart();
        com.tencent.mm.plugin.backup.d.b.aSZ().aTd().jsT = this.juM;
        AppMethodBeat.o(17331);
    }

    public void onStop() {
        AppMethodBeat.i(17332);
        super.onStop();
        com.tencent.mm.plugin.backup.d.b.aSZ().aTd().jsT = null;
        AppMethodBeat.o(17332);
    }

    public final void initView() {
        AppMethodBeat.i(17333);
        setMMTitle((int) R.string.a1q);
        this.juw = (ListView) findViewById(R.id.a0i);
        this.juw.setAdapter(this.juv);
        this.juw.setEmptyView(findViewById(R.id.a0j));
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
        ((TextView) findViewById(R.id.a0p)).setText(R.string.xn);
        ((TextView) findViewById(R.id.a0s)).setText(R.string.xp);
        ((TextView) findViewById(R.id.a0v)).setText(R.string.xl);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(17324);
                BackupMoveChooseUI.this.finish();
                AppMethodBeat.o(17324);
                return false;
            }
        });
        this.juJ = (Button) findViewById(R.id.a0z);
        this.juJ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                LinkedList linkedList;
                AppMethodBeat.i(17325);
                PLong pLong = new PLong();
                PInt pInt = new PInt();
                a a = BackupMoveChooseUI.this.juv;
                LinkedList linkedList2 = new LinkedList();
                if (a.jur.size() <= 0) {
                    linkedList = linkedList2;
                } else {
                    pLong.value = 0;
                    pInt.value = 0;
                    LinkedList aSV = com.tencent.mm.plugin.backup.d.b.aSZ().aTd().aSV();
                    if (aSV != null) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= a.getCount()) {
                                break;
                            }
                            if (a.jur.contains(Integer.valueOf(i2))) {
                                linkedList2.add(aSV.get(i2));
                                pLong.value += ((f.b) aSV.get(i2)).jri;
                                pInt.value = (int) (((long) pInt.value) + ((f.b) aSV.get(i2)).jrj);
                            }
                            i = i2 + 1;
                        }
                    }
                    ab.i("MicroMsg.BackupMoveChooseAdapter", "finishSelected usernameSize:%d, convSize:%d, convMsgCount:%d", Integer.valueOf(linkedList2.size()), Long.valueOf(pLong.value), Integer.valueOf(pInt.value));
                    linkedList = linkedList2;
                }
                LinkedList A = g.A(linkedList);
                com.tencent.mm.plugin.backup.d.a aTd = com.tencent.mm.plugin.backup.d.b.aSZ().aTd();
                if (linkedList.size() == 0) {
                    aTd.jsX = new LinkedList();
                } else {
                    aTd.jsX = new LinkedList(linkedList.subList((linkedList.size() * 3) / 4, linkedList.size()));
                    aTd.jsX.addAll(linkedList.subList(0, (linkedList.size() * 3) / 4));
                }
                d aTb = com.tencent.mm.plugin.backup.d.b.aSZ().aTb();
                aTb.jtQ = A;
                com.tencent.mm.plugin.backup.d.b.aSZ();
                if (com.tencent.mm.plugin.backup.b.d.aSz().getInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0) == 1) {
                    d.jtX = true;
                } else {
                    d.jtX = false;
                }
                com.tencent.mm.plugin.backup.d.b.aSZ();
                aTb.jtT = com.tencent.mm.plugin.backup.b.d.aSz().getLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0);
                com.tencent.mm.plugin.backup.d.b.aSZ();
                aTb.jtU = com.tencent.mm.plugin.backup.b.d.aSz().getLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0);
                com.tencent.mm.plugin.backup.d.b.aSZ();
                if (com.tencent.mm.plugin.backup.b.d.aSz().getInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0) == 1) {
                    d.jsA = true;
                } else {
                    d.jsA = false;
                }
                ab.i("MicroMsg.BackupMoveServer", "setBakupChooseData users size[%d], selectStartTime[%d], selectEndTime[%d], isQuickBackup[%b]", Integer.valueOf(A.size()), Long.valueOf(aTb.jtT), Long.valueOf(aTb.jtU), Boolean.valueOf(d.jsA));
                aw.ZK();
                c.Ry().set(ac.a.USERINFO_BACKUP_MOVE_BACKUPING_BOOLEAN, Boolean.TRUE);
                com.tencent.mm.plugin.backup.d.a aTd2 = com.tencent.mm.plugin.backup.d.b.aSZ().aTd();
                if (aTd2.jsS != null) {
                    aTd2.jsS.cancel();
                }
                com.tencent.mm.sdk.g.d.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(17222);
                        ab.i("MicroMsg.BackupMoveChooseServer", "start calculateChooseConvSize");
                        a.this.jsS = new com.tencent.mm.plugin.backup.c.b();
                        com.tencent.mm.plugin.backup.c.b bVar = a.this.jsS;
                        LinkedList aSW = a.this.aSW();
                        a aVar = a.this;
                        long j = b.aSZ().aSu().jrc;
                        long anU = bo.anU();
                        String str = (String) com.tencent.mm.plugin.backup.h.d.aUr().aUs().Ry().get(2, null);
                        int i = 0;
                        Iterator it = aSW.iterator();
                        while (it.hasNext()) {
                            f.b bVar2 = (f.b) it.next();
                            if (bVar2.jri < 0) {
                                if (bVar.a(bVar2, str, j)) {
                                    break;
                                }
                                i++;
                                if (!(bVar.jrv || aVar == null)) {
                                    al.d(new AnonymousClass3(aVar, aSW, bVar2.aSE(), i));
                                }
                            } else {
                                i++;
                            }
                        }
                        ab.i("MicroMsg.BackupCalculator", "calculChooseConvSize all, userSize:%d", Integer.valueOf(aSW.size()));
                        if (!(bVar.jrv || aVar == null)) {
                            al.d(new AnonymousClass4(aVar, aSW));
                        }
                        ab.d("MicroMsg.BackupCalculator", "calculChooseConvSize loading time[%d]", Long.valueOf(bo.gb(anU)));
                        AppMethodBeat.o(17222);
                    }
                }, "BakMoveChooseServer.calculateChooseConvSize");
                if (BackupMoveChooseUI.this.juv.jus) {
                    h.pYm.a(485, 22, 1, false);
                    h.pYm.e(11788, Integer.valueOf(4));
                }
                if (BackupMoveChooseUI.juK == 1 && BackupMoveChooseUI.aPA == 1) {
                    h.pYm.a(485, 26, 1, false);
                    h.pYm.a(485, 27, 1, false);
                    h.pYm.e(11788, Integer.valueOf(7));
                } else if (BackupMoveChooseUI.juK == 1) {
                    h.pYm.a(485, 26, 1, false);
                    h.pYm.e(11788, Integer.valueOf(5));
                } else if (BackupMoveChooseUI.aPA == 1) {
                    h.pYm.a(485, 27, 1, false);
                    h.pYm.e(11788, Integer.valueOf(6));
                }
                h.pYm.e(11788, Integer.valueOf(8));
                MMWizardActivity.J(BackupMoveChooseUI.this, new Intent(BackupMoveChooseUI.this, BackupMoveQRCodeUI.class));
                h.pYm.a(485, 23, 1, false);
                AppMethodBeat.o(17325);
            }
        });
        this.juJ.setEnabled(false);
        fm(true);
        this.juz.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(17326);
                Intent intent = new Intent(BackupMoveChooseUI.this, BackupSelectExtUI.class);
                intent.putExtra("BACKUP_MODE", 2);
                intent.putExtra("BACKUP_SELECT_TIME_MODE", BackupMoveChooseUI.juK);
                intent.putExtra("BACKUP_SELECT_SUPPORT_CONTENT_TYPE", true);
                intent.putExtra("BACKUP_SELECT_CONTENT_TYPE", BackupMoveChooseUI.aPA);
                intent.putExtra("BACKUP_SELECT_TIME_START_TIME", BackupMoveChooseUI.startTime);
                intent.putExtra("BACKUP_SELECT_TIME_END_TIME", BackupMoveChooseUI.endTime);
                intent.putExtra("BACKUP_SELECT_TIME_MIN_CONVERSATION_TIME", com.tencent.mm.plugin.backup.d.b.aSZ().aTd().jsU);
                BackupMoveChooseUI.this.startActivityForResult(intent, 0);
                AppMethodBeat.o(17326);
            }
        });
        this.jux.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                int i = 0;
                AppMethodBeat.i(17327);
                if (com.tencent.mm.plugin.backup.d.b.aSZ().aTd().jsY) {
                    a a = BackupMoveChooseUI.this.juv;
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
                    a.juq.a(a.jur);
                }
                AppMethodBeat.o(17327);
            }
        });
        if (com.tencent.mm.plugin.backup.d.b.aSZ().aTd().jsY) {
            if (com.tencent.mm.plugin.backup.d.b.aSZ().aTd().aSV() == null || com.tencent.mm.plugin.backup.d.b.aSZ().aTd().aSV().size() == 0) {
                switch (juK) {
                    case 0:
                        this.juy.setText(R.string.xm);
                        break;
                    case 1:
                        this.juy.setText(R.string.a1h);
                        break;
                }
                this.juy.setVisibility(0);
            }
            this.juA.setVisibility(4);
            AppMethodBeat.o(17333);
        } else if (com.tencent.mm.plugin.backup.d.b.aSZ().aTd().jsY) {
            this.juA.setVisibility(4);
            AppMethodBeat.o(17333);
        } else {
            this.jux.setTextColor(getResources().getColor(R.color.gp));
            this.jux.setClickable(false);
            this.juA.setVisibility(0);
            AppMethodBeat.o(17333);
        }
    }

    private void fm(boolean z) {
        AppMethodBeat.i(17334);
        if (z) {
            com.tencent.mm.plugin.backup.d.b.aSZ();
            SharedPreferences aSz = com.tencent.mm.plugin.backup.b.d.aSz();
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
                this.juI.setText(this.mController.ylL.getResources().getString(R.string.z9));
                break;
        }
        aTt();
        AppMethodBeat.o(17334);
    }

    public final void a(HashSet<Integer> hashSet) {
        AppMethodBeat.i(17335);
        LinkedList aSV = com.tencent.mm.plugin.backup.d.b.aSZ().aTd().aSV();
        if (aSV == null) {
            ab.e("MicroMsg.BackupMoveChooseUI", "onClickCheckBox convInfo is null.");
            AppMethodBeat.o(17335);
            return;
        }
        HashSet hashSet2 = new HashSet();
        Iterator it = hashSet.iterator();
        long j = 0;
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            if (intValue < aSV.size()) {
                j = ((f.b) aSV.get(intValue)).jri + j;
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
        AppMethodBeat.o(17335);
    }

    private void aTt() {
        AppMethodBeat.i(17336);
        if (this.juD.getVisibility() == 8 && this.juE.getVisibility() == 8 && this.juF.getVisibility() == 8) {
            this.juB.setVisibility(8);
            this.juC.setVisibility(8);
            AppMethodBeat.o(17336);
            return;
        }
        this.juB.setVisibility(0);
        this.juC.setVisibility(0);
        AppMethodBeat.o(17336);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(17337);
        if (i2 != -1) {
            ab.e("MicroMsg.BackupMoveChooseUI", "onActivityResult result error! resultCode:%d", Integer.valueOf(i2));
            AppMethodBeat.o(17337);
            return;
        }
        int i3 = juK;
        long j = startTime;
        long j2 = endTime;
        juK = intent.getIntExtra("BACKUP_SELECT_TIME_MODE", juK);
        startTime = intent.getLongExtra("BACKUP_SELECT_TIME_START_TIME", 0);
        endTime = intent.getLongExtra("BACKUP_SELECT_TIME_END_TIME", 0);
        aPA = intent.getIntExtra("BACKUP_SELECT_CONTENT_TYPE", aPA);
        ab.i("MicroMsg.BackupMoveChooseUI", "onActivityResult timeMode/preTimeMode[%d/%d], startTime/preStartTime[%d/%d], endTime/preEndTime[%d/%d], contentType[%d]", Integer.valueOf(juK), Integer.valueOf(i3), Long.valueOf(startTime), Long.valueOf(j), Long.valueOf(endTime), Long.valueOf(j2), Integer.valueOf(aPA));
        com.tencent.mm.plugin.backup.d.b.aSZ().aTb();
        d.d(juK, startTime, endTime, aPA);
        fm(false);
        if (i3 == juK && (juK == 0 || (juK == 1 && startTime == j && endTime == j2))) {
            AppMethodBeat.o(17337);
            return;
        }
        com.tencent.mm.plugin.backup.d.b.aSZ().aTd().a(juK, startTime, endTime, com.tencent.mm.plugin.backup.d.b.aSZ().aTd().aSU());
        a aVar = this.juv;
        aVar.jur.clear();
        aVar.juq.a(aVar.jur);
        if (com.tencent.mm.plugin.backup.d.b.aSZ().aTd().aSV() == null || com.tencent.mm.plugin.backup.d.b.aSZ().aTd().aSV().size() == 0) {
            switch (juK) {
                case 0:
                    this.juy.setText(R.string.xm);
                    break;
                case 1:
                    this.juy.setText(R.string.a1h);
                    break;
            }
            this.juy.setVisibility(0);
        } else {
            this.juy.setVisibility(4);
        }
        this.juv.notifyDataSetChanged();
        AppMethodBeat.o(17337);
    }

    public final int getLayoutId() {
        return R.layout.f8;
    }
}

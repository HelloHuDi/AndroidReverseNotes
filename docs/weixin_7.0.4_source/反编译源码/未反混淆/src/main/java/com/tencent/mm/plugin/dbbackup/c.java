package com.tencent.mm.plugin.dbbackup;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.text.method.ScrollingMovementMethod;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.mars.comm.WakerLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.by;
import com.tencent.mm.plugin.zero.b.b;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.vfs.e;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDebug;
import com.tencent.wcdb.database.SQLiteDebug.IOTraceStats;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xwalk.core.XWalkEnvironment;

public final class c implements a {
    private d kHL;
    private HandlerThread kHM = null;
    private Handler kHN = null;

    c(d dVar) {
        this.kHL = dVar;
    }

    private boolean dz(final Context context) {
        AppMethodBeat.i(18938);
        if (g.RP().Rs() == null) {
            h.g(context, R.string.djn, R.string.tz);
            AppMethodBeat.o(18938);
        } else {
            context.getString(R.string.tz);
            final p b = h.b(context, context.getString(R.string.djm), false, null);
            final by dgK = ((b) g.K(b.class)).dgK();
            dgK.aaw();
            d dVar = this.kHL;
            AnonymousClass1 anonymousClass1 = new b() {
                public final void tL(final int i) {
                    AppMethodBeat.i(18928);
                    dgK.aax();
                    al.d(new Runnable() {
                        public final void run() {
                            int i;
                            AppMethodBeat.i(18927);
                            if (b != null) {
                                b.dismiss();
                            }
                            switch (i) {
                                case -3:
                                    i = R.string.djn;
                                    break;
                                case -2:
                                    i = R.string.djo;
                                    break;
                                case 0:
                                    i = R.string.djp;
                                    break;
                                default:
                                    i = R.string.djl;
                                    break;
                            }
                            h.g(context, i, R.string.tz);
                            AppMethodBeat.o(18927);
                        }
                    });
                    AppMethodBeat.o(18928);
                }
            };
            com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(ah.getContext().getFilesDir(), "DBRecoverStarted");
            WakerLock wakerLock = new WakerLock(ah.getContext(), "MicroMsg.SubCoreDBBackup");
            com.tencent.mm.plugin.dbbackup.d.AnonymousClass5 anonymousClass5 = new com.tencent.mm.plugin.dbbackup.d.AnonymousClass5(bVar, anonymousClass1, wakerLock);
            ab.i("MicroMsg.SubCoreDBBackup", "Database recover started.");
            wakerLock.lock();
            com.tencent.mm.plugin.report.service.h.pYm.a(181, 28, 1, true);
            try {
                bVar.createNewFile();
            } catch (IOException e) {
            }
            anonymousClass5.tL(-1);
            AppMethodBeat.o(18938);
        }
        return true;
    }

    private boolean b(final Context context, String[] strArr) {
        int i = -1;
        int i2 = 0;
        AppMethodBeat.i(18939);
        String str = g.RP().cachePath;
        final String str2 = str + "ctest/";
        final String str3 = str + "EnMicroMsg.db";
        final String str4 = str2 + "EnMicroMsg.db";
        final String[] strArr2 = new String[]{"", "-journal", "-wal", ".sm", ".bak"};
        if (strArr.length > 1) {
            String str5 = strArr[1];
            switch (str5.hashCode()) {
                case -778987502:
                    if (str5.equals("clear-test")) {
                        i = 2;
                        break;
                    }
                    break;
                case 1220142353:
                    if (str5.equals("make-test")) {
                        i = 0;
                        break;
                    }
                    break;
                case 1933703003:
                    if (str5.equals("recover-test")) {
                        i = 1;
                        break;
                    }
                    break;
            }
            switch (i) {
                case 0:
                    if (e.ct(str2)) {
                        Toast.makeText(context, "Corruption test database exists.\nClear or recover before creating a new one.", 1).show();
                        AppMethodBeat.o(18939);
                        return true;
                    }
                    aw.ZK();
                    com.tencent.mm.model.c.Ru().dvx().close();
                    e.tf(str2);
                    while (i2 < 5) {
                        String str6 = strArr2[i2];
                        e.aQ(str3 + str6, str4 + str6);
                        i2++;
                    }
                    d.dB(context);
                    AppMethodBeat.o(18939);
                    return true;
                case 1:
                    if (e.ct(str2)) {
                        final Context context2 = context;
                        h.a(context, "Do you really want to recover test database?\nYour current database WILL BE LOST.", null, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(18935);
                                aw.ZK();
                                com.tencent.mm.model.c.Ru().dvx().close();
                                for (String str : strArr2) {
                                    e.deleteFile(str3 + str);
                                    e.aQ(str4 + str, str3 + str);
                                }
                                e.N(str2, true);
                                d.dB(context2);
                                AppMethodBeat.o(18935);
                            }
                        }, null);
                        AppMethodBeat.o(18939);
                        return true;
                    }
                    Toast.makeText(context, "Corruption test database not exist.", 0).show();
                    AppMethodBeat.o(18939);
                    return true;
                case 2:
                    if (e.ct(str2)) {
                        h.a(context, "Do you really want to clear test database?\nIt can't be recovered anymore.", null, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(18936);
                                e.N(str2, true);
                                Toast.makeText(context, "Corruption test database cleared.", 0).show();
                                AppMethodBeat.o(18936);
                            }
                        }, null);
                        AppMethodBeat.o(18939);
                        return true;
                    }
                    Toast.makeText(context, "Corruption test database not exist.", 0).show();
                    AppMethodBeat.o(18939);
                    return true;
                default:
                    AppMethodBeat.o(18939);
                    return false;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(512);
        str3 = g.RP().Rs();
        stringBuilder.append("Corrupted DB: ");
        if (str3 == null) {
            stringBuilder.append("not exist");
        } else {
            stringBuilder.append(str3.contains("/ctest/") ? "test" : "exists");
            stringBuilder.append("\nCorrupted DB size: ").append(e.asZ(str3));
            stringBuilder.append("\nSaved master exists: ").append(e.ct(str3 + ".sm"));
            stringBuilder.append("\nContent backup exists: ").append(e.ct(str3 + ".bak"));
        }
        View textView = new TextView(context);
        textView.setText(stringBuilder);
        textView.setGravity(8388627);
        textView.setTextSize(1, 10.0f);
        textView.setLayoutParams(new LayoutParams(-1, -2));
        textView.setTextColor(-16744704);
        textView.setTypeface(Typeface.MONOSPACE);
        textView.setMovementMethod(new ScrollingMovementMethod());
        i = context.getResources().getDimensionPixelSize(R.dimen.l5);
        textView.setPadding(i, i, i, i);
        h.a(context, null, textView, null);
        AppMethodBeat.o(18939);
        return true;
    }

    private static boolean dA(Context context) {
        AppMethodBeat.i(18940);
        int lastErrorLine = SQLiteDebug.getLastErrorLine();
        ArrayList lastIOTraceStats = SQLiteDebug.getLastIOTraceStats();
        if (lastIOTraceStats == null || lastIOTraceStats.isEmpty()) {
            AppMethodBeat.o(18940);
        } else {
            Object encodeToString;
            IOTraceStats iOTraceStats = (IOTraceStats) lastIOTraceStats.get(0);
            String str = "";
            try {
                aw.ZK();
                str = com.tencent.mm.a.g.x((q.LK() + com.tencent.mm.model.c.QF()).getBytes()).substring(0, 7);
            } catch (Exception e) {
            }
            String format = String.format("DB corrupted (line: %d, hash: %s) => %s", new Object[]{Integer.valueOf(lastErrorLine), str, iOTraceStats.toString()});
            Object obj = "";
            if (iOTraceStats.lastReadPage != null) {
                obj = Base64.encodeToString(iOTraceStats.lastReadPage, 0);
            }
            String str2 = "";
            if (iOTraceStats.lastJournalReadPage != null) {
                encodeToString = Base64.encodeToString(iOTraceStats.lastJournalReadPage, 0);
            } else {
                String encodeToString2 = str2;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("lastReadPage", obj);
            hashMap.put("lastJournalReadPage", encodeToString2);
            com.tencent.mm.plugin.report.service.h.pYm.g("DBCorrupt", format, hashMap);
            View textView = new TextView(context);
            textView.setText(format);
            textView.setGravity(8388627);
            textView.setTextSize(1, 10.0f);
            textView.setLayoutParams(new LayoutParams(-1, -2));
            textView.setTextColor(-16744704);
            textView.setTypeface(Typeface.MONOSPACE);
            textView.setMovementMethod(new ScrollingMovementMethod());
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.l5);
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            h.a(context, null, textView, null);
            AppMethodBeat.o(18940);
        }
        return true;
    }

    private static boolean c(Context context, String[] strArr) {
        CharSequence concat;
        AppMethodBeat.i(18941);
        z Ry = g.RP().Ry();
        if (strArr.length > 1) {
            try {
                int intValue = Integer.decode(strArr[1]).intValue();
                if (intValue > 2 || intValue < 0) {
                    NumberFormatException numberFormatException = new NumberFormatException();
                    AppMethodBeat.o(18941);
                    throw numberFormatException;
                }
                Ry.set(89, Integer.valueOf(intValue));
                Ry.dsb();
                concat = "Recovery status set to ".concat(String.valueOf(intValue));
            } catch (NumberFormatException e) {
                concat = "Recovery status must be 0, 1 or 2";
            }
        } else {
            concat = "Recovery status is ".concat(String.valueOf(Ry.getInt(89, 0)));
        }
        Toast.makeText(context, concat, 0).show();
        AppMethodBeat.o(18941);
        return true;
    }

    public final boolean a(Context context, String[] strArr, String str) {
        AppMethodBeat.i(18942);
        String str2 = strArr[0];
        boolean z = true;
        switch (str2.hashCode()) {
            case -1955673212:
                if (str2.equals("//recover")) {
                    z = true;
                    break;
                }
                break;
            case -1870250080:
                if (str2.equals("//backupdb")) {
                    z = true;
                    break;
                }
                break;
            case -1832373669:
                if (str2.equals("//recover-status")) {
                    z = true;
                    break;
                }
                break;
            case -1648083177:
                if (str2.equals("//post-recover")) {
                    z = true;
                    break;
                }
                break;
            case -896707907:
                if (str2.equals("//iotracedb")) {
                    z = true;
                    break;
                }
                break;
            case -398050965:
                if (str2.equals("//corruptdb")) {
                    z = true;
                    break;
                }
                break;
            case -137452885:
                if (str2.equals("//repairdb")) {
                    z = true;
                    break;
                }
                break;
            case 1483443294:
                if (str2.equals("//recover-old")) {
                    z = false;
                    break;
                }
                break;
            case 1793722114:
                if (str2.equals("//recoverdb")) {
                    z = true;
                    break;
                }
                break;
            case 2027162967:
                if (str2.equals("//dbbusy")) {
                    z = true;
                    break;
                }
                break;
        }
        boolean dz;
        final long nanoTime;
        final Context context2;
        String str3;
        final p b;
        switch (z) {
            case false:
                dz = dz(context);
                AppMethodBeat.o(18942);
                return dz;
            case true:
                Intent intent = new Intent(context, DBRecoveryUI.class);
                intent.putExtra("scene", 2);
                intent.setFlags(268435456);
                context.startActivity(intent);
                AppMethodBeat.o(18942);
                return true;
            case true:
                aw.ZK();
                d.bhR();
                Toast.makeText(context, "Post recovery cleanup done.", 0).show();
                AppMethodBeat.o(18942);
                return true;
            case true:
                if (strArr.length <= 1 || !strArr[1].equals("cipher")) {
                    final boolean z2 = strArr.length > 1 && strArr[1].equals("incremental");
                    nanoTime = System.nanoTime();
                    final p b2 = h.b(context, "Backing database up. Please wait...", false, null);
                    context2 = context;
                    if (!this.kHL.a(z2, new b() {
                        public final void tL(final int i) {
                            AppMethodBeat.i(18930);
                            al.d(new Runnable() {
                                public final void run() {
                                    CharSequence format;
                                    AppMethodBeat.i(18929);
                                    if (b2 != null) {
                                        b2.dismiss();
                                    }
                                    if (i == 0) {
                                        String str = "Database (%s) backup succeeded, elapsed %.2f seconds.";
                                        Object[] objArr = new Object[2];
                                        objArr[0] = z2 ? "incremental" : "new";
                                        objArr[1] = Float.valueOf(((float) (System.nanoTime() - nanoTime)) / 1.0E9f);
                                        format = String.format(str, objArr);
                                    } else if (i == 1) {
                                        format = "Database backup canceled.";
                                    } else {
                                        format = "Database backup failed.";
                                    }
                                    Toast.makeText(context2, format, 0).show();
                                    AppMethodBeat.o(18929);
                                }
                            });
                            AppMethodBeat.o(18930);
                        }
                    })) {
                        if (b2 != null) {
                            b2.dismiss();
                        }
                        Toast.makeText(context, "Database is busy.", 0).show();
                    }
                } else {
                    aw.ZK();
                    z Ry = com.tencent.mm.model.c.Ry();
                    if (strArr.length > 2) {
                        str2 = strArr[2];
                        z = true;
                        switch (str2.hashCode()) {
                            case 48:
                                if (str2.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                                    z = true;
                                    break;
                                }
                                break;
                            case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                                if (str2.equals("1")) {
                                    z = true;
                                    break;
                                }
                                break;
                            case 3521:
                                if (str2.equals("no")) {
                                    z = true;
                                    break;
                                }
                                break;
                            case 3551:
                                if (str2.equals("on")) {
                                    z = true;
                                    break;
                                }
                                break;
                            case 109935:
                                if (str2.equals("off")) {
                                    z = true;
                                    break;
                                }
                                break;
                            case 119527:
                                if (str2.equals("yes")) {
                                    z = false;
                                    break;
                                }
                                break;
                        }
                        switch (z) {
                            case false:
                            case true:
                            case true:
                                Ry.setInt(237571, 0);
                                Ry.dsb();
                                break;
                            case true:
                            case true:
                            case true:
                                Ry.setInt(237571, 1);
                                Ry.dsb();
                                break;
                        }
                    }
                    if (Ry.getInt(237571, 0) == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Toast.makeText(context, "Database backup with cipher: ".concat(String.valueOf(z)), 0).show();
                }
                AppMethodBeat.o(18942);
                return true;
            case true:
                str3 = strArr.length > 1 ? strArr[1] : null;
                nanoTime = System.nanoTime();
                context.getString(R.string.tz);
                b = h.b(context, context.getString(R.string.djm), false, null);
                context2 = context;
                this.kHL.a(str3, new b() {
                    public final void tL(final int i) {
                        AppMethodBeat.i(18932);
                        al.d(new Runnable() {
                            public final void run() {
                                CharSequence format;
                                AppMethodBeat.i(18931);
                                if (b != null) {
                                    b.dismiss();
                                }
                                if (i == 0) {
                                    format = String.format("Database recovery succeeded, elapsed %.2f seconds.", new Object[]{Float.valueOf(((float) (System.nanoTime() - nanoTime)) / 1.0E9f)});
                                } else if (i == 1) {
                                    format = "Database recovery canceled.";
                                } else {
                                    format = "Database recovery failed.";
                                }
                                Toast.makeText(context2, format, 0).show();
                                AppMethodBeat.o(18931);
                            }
                        });
                        AppMethodBeat.o(18932);
                    }
                });
                AppMethodBeat.o(18942);
                return true;
            case true:
                str3 = strArr.length > 1 ? strArr[1] : null;
                nanoTime = System.nanoTime();
                context.getString(R.string.tz);
                b = h.b(context, context.getString(R.string.djm), false, null);
                context2 = context;
                int b3 = this.kHL.b(str3, new b() {
                    public final void tL(final int i) {
                        AppMethodBeat.i(18934);
                        al.d(new Runnable() {
                            public final void run() {
                                CharSequence format;
                                AppMethodBeat.i(18933);
                                if (b != null) {
                                    b.dismiss();
                                }
                                if (i == 0) {
                                    format = String.format("Database recovery succeeded, elapsed %.2f seconds.", new Object[]{Float.valueOf(((float) (System.nanoTime() - nanoTime)) / 1.0E9f)});
                                } else if (i == 1) {
                                    format = "Database recovery canceled.";
                                } else {
                                    format = "Database recovery failed.";
                                }
                                Toast.makeText(context2, format, 0).show();
                                AppMethodBeat.o(18933);
                            }
                        });
                        AppMethodBeat.o(18934);
                    }
                });
                if (b3 != 0) {
                    if (b != null) {
                        b.dismiss();
                    }
                    switch (b3) {
                        case -3:
                            b3 = R.string.djn;
                            break;
                        case -2:
                            b3 = R.string.djo;
                            break;
                        default:
                            b3 = R.string.djl;
                            break;
                    }
                    Toast.makeText(context, b3, 1).show();
                }
                AppMethodBeat.o(18942);
                return true;
            case true:
                dz = b(context, strArr);
                AppMethodBeat.o(18942);
                return dz;
            case true:
                dz = dA(context);
                AppMethodBeat.o(18942);
                return dz;
            case true:
                dz = c(context, strArr);
                AppMethodBeat.o(18942);
                return dz;
            case true:
                if (this.kHM == null) {
                    this.kHM = new HandlerThread("DBBusyTest", 4);
                    this.kHM.start();
                    this.kHN = new Handler(this.kHM.getLooper(), new Callback() {
                        public final boolean handleMessage(Message message) {
                            AppMethodBeat.i(18937);
                            SQLiteDatabase dvx = g.RP().eJN.dvx();
                            switch (message.what) {
                                case 1:
                                    dvx.beginTransaction();
                                    AppMethodBeat.o(18937);
                                    return true;
                                case 2:
                                    dvx.endTransaction();
                                    AppMethodBeat.o(18937);
                                    return true;
                                default:
                                    AppMethodBeat.o(18937);
                                    return false;
                            }
                        }
                    });
                    this.kHN.sendEmptyMessage(1);
                    Toast.makeText(context, "TEST: Begin transaction", 1).show();
                } else {
                    this.kHN.sendEmptyMessage(2);
                    this.kHM.quitSafely();
                    this.kHM = null;
                    this.kHN = null;
                    Toast.makeText(context, "TEST: End transaction", 1).show();
                }
                AppMethodBeat.o(18942);
                return true;
            default:
                AppMethodBeat.o(18942);
                return false;
        }
    }
}

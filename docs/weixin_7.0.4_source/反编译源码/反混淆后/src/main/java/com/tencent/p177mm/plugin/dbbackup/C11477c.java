package com.tencent.p177mm.plugin.dbbackup;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C18620by;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.plugin.dbbackup.C11486d.C114905;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.zero.p757b.C35779b;
import com.tencent.p177mm.pluginsdk.cmd.C44041a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.storage.C7580z;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDebug;
import com.tencent.wcdb.database.SQLiteDebug.IOTraceStats;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.mm.plugin.dbbackup.c */
public final class C11477c implements C44041a {
    private C11486d kHL;
    private HandlerThread kHM = null;
    private Handler kHN = null;

    /* renamed from: com.tencent.mm.plugin.dbbackup.c$7 */
    class C114787 implements Callback {
        C114787() {
        }

        public final boolean handleMessage(Message message) {
            AppMethodBeat.m2504i(18937);
            SQLiteDatabase dvx = C1720g.m3536RP().eJN.dvx();
            switch (message.what) {
                case 1:
                    dvx.beginTransaction();
                    AppMethodBeat.m2505o(18937);
                    return true;
                case 2:
                    dvx.endTransaction();
                    AppMethodBeat.m2505o(18937);
                    return true;
                default:
                    AppMethodBeat.m2505o(18937);
                    return false;
            }
        }
    }

    C11477c(C11486d c11486d) {
        this.kHL = c11486d;
    }

    /* renamed from: dz */
    private boolean m19244dz(final Context context) {
        AppMethodBeat.m2504i(18938);
        if (C1720g.m3536RP().mo5234Rs() == null) {
            C30379h.m48467g(context, C25738R.string.djn, C25738R.string.f9238tz);
            AppMethodBeat.m2505o(18938);
        } else {
            context.getString(C25738R.string.f9238tz);
            final C44275p b = C30379h.m48458b(context, context.getString(C25738R.string.djm), false, null);
            final C18620by dgK = ((C35779b) C1720g.m3528K(C35779b.class)).dgK();
            dgK.aaw();
            C11486d c11486d = this.kHL;
            C114811 c114811 = new C33900b() {
                /* renamed from: tL */
                public final void mo23206tL(final int i) {
                    AppMethodBeat.m2504i(18928);
                    dgK.aax();
                    C5004al.m7441d(new Runnable() {
                        public final void run() {
                            int i;
                            AppMethodBeat.m2504i(18927);
                            if (b != null) {
                                b.dismiss();
                            }
                            switch (i) {
                                case -3:
                                    i = C25738R.string.djn;
                                    break;
                                case -2:
                                    i = C25738R.string.djo;
                                    break;
                                case 0:
                                    i = C25738R.string.djp;
                                    break;
                                default:
                                    i = C25738R.string.djl;
                                    break;
                            }
                            C30379h.m48467g(context, i, C25738R.string.f9238tz);
                            AppMethodBeat.m2505o(18927);
                        }
                    });
                    AppMethodBeat.m2505o(18928);
                }
            };
            C5728b c5728b = new C5728b(C4996ah.getContext().getFilesDir(), "DBRecoverStarted");
            WakerLock wakerLock = new WakerLock(C4996ah.getContext(), "MicroMsg.SubCoreDBBackup");
            C114905 c114905 = new C114905(c5728b, c114811, wakerLock);
            C4990ab.m7416i("MicroMsg.SubCoreDBBackup", "Database recover started.");
            wakerLock.lock();
            C7060h.pYm.mo8378a(181, 28, 1, true);
            try {
                c5728b.createNewFile();
            } catch (IOException e) {
            }
            c114905.mo23206tL(-1);
            AppMethodBeat.m2505o(18938);
        }
        return true;
    }

    /* renamed from: b */
    private boolean m19241b(final Context context, String[] strArr) {
        int i = -1;
        int i2 = 0;
        AppMethodBeat.m2504i(18939);
        String str = C1720g.m3536RP().cachePath;
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
                    if (C5730e.m8628ct(str2)) {
                        Toast.makeText(context, "Corruption test database exists.\nClear or recover before creating a new one.", 1).show();
                        AppMethodBeat.m2505o(18939);
                        return true;
                    }
                    C9638aw.m17190ZK();
                    C18628c.m29069Ru().dvx().close();
                    C5730e.m8643tf(str2);
                    while (i2 < 5) {
                        String str6 = strArr2[i2];
                        C5730e.m8623aQ(str3 + str6, str4 + str6);
                        i2++;
                    }
                    C11486d.m19272dB(context);
                    AppMethodBeat.m2505o(18939);
                    return true;
                case 1:
                    if (C5730e.m8628ct(str2)) {
                        final Context context2 = context;
                        C30379h.m48440a(context, "Do you really want to recover test database?\nYour current database WILL BE LOST.", null, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.m2504i(18935);
                                C9638aw.m17190ZK();
                                C18628c.m29069Ru().dvx().close();
                                for (String str : strArr2) {
                                    C5730e.deleteFile(str3 + str);
                                    C5730e.m8623aQ(str4 + str, str3 + str);
                                }
                                C5730e.m8618N(str2, true);
                                C11486d.m19272dB(context2);
                                AppMethodBeat.m2505o(18935);
                            }
                        }, null);
                        AppMethodBeat.m2505o(18939);
                        return true;
                    }
                    Toast.makeText(context, "Corruption test database not exist.", 0).show();
                    AppMethodBeat.m2505o(18939);
                    return true;
                case 2:
                    if (C5730e.m8628ct(str2)) {
                        C30379h.m48440a(context, "Do you really want to clear test database?\nIt can't be recovered anymore.", null, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.m2504i(18936);
                                C5730e.m8618N(str2, true);
                                Toast.makeText(context, "Corruption test database cleared.", 0).show();
                                AppMethodBeat.m2505o(18936);
                            }
                        }, null);
                        AppMethodBeat.m2505o(18939);
                        return true;
                    }
                    Toast.makeText(context, "Corruption test database not exist.", 0).show();
                    AppMethodBeat.m2505o(18939);
                    return true;
                default:
                    AppMethodBeat.m2505o(18939);
                    return false;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(512);
        str3 = C1720g.m3536RP().mo5234Rs();
        stringBuilder.append("Corrupted DB: ");
        if (str3 == null) {
            stringBuilder.append("not exist");
        } else {
            stringBuilder.append(str3.contains("/ctest/") ? "test" : "exists");
            stringBuilder.append("\nCorrupted DB size: ").append(C5730e.asZ(str3));
            stringBuilder.append("\nSaved master exists: ").append(C5730e.m8628ct(str3 + ".sm"));
            stringBuilder.append("\nContent backup exists: ").append(C5730e.m8628ct(str3 + ".bak"));
        }
        View textView = new TextView(context);
        textView.setText(stringBuilder);
        textView.setGravity(8388627);
        textView.setTextSize(1, 10.0f);
        textView.setLayoutParams(new LayoutParams(-1, -2));
        textView.setTextColor(-16744704);
        textView.setTypeface(Typeface.MONOSPACE);
        textView.setMovementMethod(new ScrollingMovementMethod());
        i = context.getResources().getDimensionPixelSize(C25738R.dimen.f9948l5);
        textView.setPadding(i, i, i, i);
        C30379h.m48435a(context, null, textView, null);
        AppMethodBeat.m2505o(18939);
        return true;
    }

    /* renamed from: dA */
    private static boolean m19243dA(Context context) {
        AppMethodBeat.m2504i(18940);
        int lastErrorLine = SQLiteDebug.getLastErrorLine();
        ArrayList lastIOTraceStats = SQLiteDebug.getLastIOTraceStats();
        if (lastIOTraceStats == null || lastIOTraceStats.isEmpty()) {
            AppMethodBeat.m2505o(18940);
        } else {
            Object encodeToString;
            IOTraceStats iOTraceStats = (IOTraceStats) lastIOTraceStats.get(0);
            String str = "";
            try {
                C9638aw.m17190ZK();
                str = C1178g.m2591x((C1427q.m3026LK() + C18628c.m29064QF()).getBytes()).substring(0, 7);
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
            C7060h.pYm.mo8382g("DBCorrupt", format, hashMap);
            View textView = new TextView(context);
            textView.setText(format);
            textView.setGravity(8388627);
            textView.setTextSize(1, 10.0f);
            textView.setLayoutParams(new LayoutParams(-1, -2));
            textView.setTextColor(-16744704);
            textView.setTypeface(Typeface.MONOSPACE);
            textView.setMovementMethod(new ScrollingMovementMethod());
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(C25738R.dimen.f9948l5);
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            C30379h.m48435a(context, null, textView, null);
            AppMethodBeat.m2505o(18940);
        }
        return true;
    }

    /* renamed from: c */
    private static boolean m19242c(Context context, String[] strArr) {
        CharSequence concat;
        AppMethodBeat.m2504i(18941);
        C7580z Ry = C1720g.m3536RP().mo5239Ry();
        if (strArr.length > 1) {
            try {
                int intValue = Integer.decode(strArr[1]).intValue();
                if (intValue > 2 || intValue < 0) {
                    NumberFormatException numberFormatException = new NumberFormatException();
                    AppMethodBeat.m2505o(18941);
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
        AppMethodBeat.m2505o(18941);
        return true;
    }

    /* renamed from: a */
    public final boolean mo7165a(Context context, String[] strArr, String str) {
        AppMethodBeat.m2504i(18942);
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
        final C44275p b;
        switch (z) {
            case false:
                dz = m19244dz(context);
                AppMethodBeat.m2505o(18942);
                return dz;
            case true:
                Intent intent = new Intent(context, DBRecoveryUI.class);
                intent.putExtra("scene", 2);
                intent.setFlags(268435456);
                context.startActivity(intent);
                AppMethodBeat.m2505o(18942);
                return true;
            case true:
                C9638aw.m17190ZK();
                C11486d.bhR();
                Toast.makeText(context, "Post recovery cleanup done.", 0).show();
                AppMethodBeat.m2505o(18942);
                return true;
            case true:
                if (strArr.length <= 1 || !strArr[1].equals("cipher")) {
                    final boolean z2 = strArr.length > 1 && strArr[1].equals("incremental");
                    nanoTime = System.nanoTime();
                    final C44275p b2 = C30379h.m48458b(context, "Backing database up. Please wait...", false, null);
                    context2 = context;
                    if (!this.kHL.mo23211a(z2, new C33900b() {
                        /* renamed from: tL */
                        public final void mo23206tL(final int i) {
                            AppMethodBeat.m2504i(18930);
                            C5004al.m7441d(new Runnable() {
                                public final void run() {
                                    CharSequence format;
                                    AppMethodBeat.m2504i(18929);
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
                                    AppMethodBeat.m2505o(18929);
                                }
                            });
                            AppMethodBeat.m2505o(18930);
                        }
                    })) {
                        if (b2 != null) {
                            b2.dismiss();
                        }
                        Toast.makeText(context, "Database is busy.", 0).show();
                    }
                } else {
                    C9638aw.m17190ZK();
                    C7580z Ry = C18628c.m29072Ry();
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
                AppMethodBeat.m2505o(18942);
                return true;
            case true:
                str3 = strArr.length > 1 ? strArr[1] : null;
                nanoTime = System.nanoTime();
                context.getString(C25738R.string.f9238tz);
                b = C30379h.m48458b(context, context.getString(C25738R.string.djm), false, null);
                context2 = context;
                this.kHL.mo23210a(str3, new C33900b() {
                    /* renamed from: tL */
                    public final void mo23206tL(final int i) {
                        AppMethodBeat.m2504i(18932);
                        C5004al.m7441d(new Runnable() {
                            public final void run() {
                                CharSequence format;
                                AppMethodBeat.m2504i(18931);
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
                                AppMethodBeat.m2505o(18931);
                            }
                        });
                        AppMethodBeat.m2505o(18932);
                    }
                });
                AppMethodBeat.m2505o(18942);
                return true;
            case true:
                str3 = strArr.length > 1 ? strArr[1] : null;
                nanoTime = System.nanoTime();
                context.getString(C25738R.string.f9238tz);
                b = C30379h.m48458b(context, context.getString(C25738R.string.djm), false, null);
                context2 = context;
                int b3 = this.kHL.mo23212b(str3, new C33900b() {
                    /* renamed from: tL */
                    public final void mo23206tL(final int i) {
                        AppMethodBeat.m2504i(18934);
                        C5004al.m7441d(new Runnable() {
                            public final void run() {
                                CharSequence format;
                                AppMethodBeat.m2504i(18933);
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
                                AppMethodBeat.m2505o(18933);
                            }
                        });
                        AppMethodBeat.m2505o(18934);
                    }
                });
                if (b3 != 0) {
                    if (b != null) {
                        b.dismiss();
                    }
                    switch (b3) {
                        case -3:
                            b3 = C25738R.string.djn;
                            break;
                        case -2:
                            b3 = C25738R.string.djo;
                            break;
                        default:
                            b3 = C25738R.string.djl;
                            break;
                    }
                    Toast.makeText(context, b3, 1).show();
                }
                AppMethodBeat.m2505o(18942);
                return true;
            case true:
                dz = m19241b(context, strArr);
                AppMethodBeat.m2505o(18942);
                return dz;
            case true:
                dz = C11477c.m19243dA(context);
                AppMethodBeat.m2505o(18942);
                return dz;
            case true:
                dz = C11477c.m19242c(context, strArr);
                AppMethodBeat.m2505o(18942);
                return dz;
            case true:
                if (this.kHM == null) {
                    this.kHM = new HandlerThread("DBBusyTest", 4);
                    this.kHM.start();
                    this.kHN = new Handler(this.kHM.getLooper(), new C114787());
                    this.kHN.sendEmptyMessage(1);
                    Toast.makeText(context, "TEST: Begin transaction", 1).show();
                } else {
                    this.kHN.sendEmptyMessage(2);
                    this.kHM.quitSafely();
                    this.kHM = null;
                    this.kHN = null;
                    Toast.makeText(context, "TEST: End transaction", 1).show();
                }
                AppMethodBeat.m2505o(18942);
                return true;
            default:
                AppMethodBeat.m2505o(18942);
                return false;
        }
    }
}
